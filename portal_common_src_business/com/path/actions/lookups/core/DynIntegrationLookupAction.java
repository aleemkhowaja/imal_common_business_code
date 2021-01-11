package com.path.actions.lookups.core;

import java.util.HashMap;
import java.util.List;

import com.path.bo.core.integrationDynamic.IntegrationDynamicBO;
import com.path.bo.core.integrationDynamic.IntegrationDynamicConstant;
import com.path.dbmaps.vo.CIF_TRXTYPE_LIMITSVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.integrationDynamic.IntegrationDynamicCO;
import com.path.vo.core.integrationDynamic.IntegrationDynamicSC;


public class DynIntegrationLookupAction extends LookupBaseAction 
{
  
    public final IntegrationDynamicSC integrationDynamicSC = new IntegrationDynamicSC(); //Rania - 829901
    private IntegrationDynamicCO integrationDynamicCO = new IntegrationDynamicCO();
    private IntegrationDynamicBO integrationDynamicBO;
    
    
    @Override
    public Object getModel()
	{
		return integrationDynamicSC;
	}
  
    public String constructLookup() {

	try 
	{
	    
	        SessionCO sessionCO = returnSessionObject();
	        integrationDynamicSC.setUserId(sessionCO.getUserName());
		integrationDynamicSC.setCompCode(sessionCO.getCompanyCode());
		integrationDynamicCO.setLanguage(sessionCO.getLanguage());
		CIF_TRXTYPE_LIMITSVO cifTrxTypeLimitsVO = integrationDynamicBO.returnTypeCode(integrationDynamicSC); 
		if(null != cifTrxTypeLimitsVO && !NumberUtil.isEmptyDecimal(cifTrxTypeLimitsVO.getTYPE_CODE()))
		{
		    integrationDynamicSC.setTypeCode(cifTrxTypeLimitsVO.getTYPE_CODE());  
		}
		integrationDynamicCO= integrationDynamicBO.constructDynamicLookup(integrationDynamicCO,integrationDynamicSC);
		
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("TypesList"));
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/DynIntegrationLookup_fillDynIntegrationLkp");
	  	
		lookup(grid, integrationDynamicSC, integrationDynamicCO.getListNames().toArray(new String[integrationDynamicCO.getListNames().size()]), integrationDynamicCO.getListColtype().toArray(new String[integrationDynamicCO.getListColtype().size()]), integrationDynamicCO.getListTitles().toArray(new String[integrationDynamicCO.getListTitles().size()]));

	} 
catch(Exception e)
{
    handleException(e, null, null);
}

	return SUCCESS;

}
    
    
    
    public String fillDynIntegrationLkp() 
	{
		try {
		    	List<IntegrationDynamicCO> integrationDynList;
		    	HashMap<String,String> hmDate = new HashMap<String,String>();
			hmDate.put("cts_integrationVO.DATE1","cts_integrationVO.DATE1");
			hmDate.put("cts_integrationVO.DATE2","cts_integrationVO.DATE2");
			hmDate.put("cts_integrationVO.DATE3","cts_integrationVO.DATE3");
			hmDate.put("cts_integrationVO.DATE4","cts_integrationVO.DATE4");
			hmDate.put("cts_integrationVO.DATE5","cts_integrationVO.DATE5");
			hmDate.put("cts_integrationVO.DATE6","cts_integrationVO.DATE6");
			hmDate.put("cts_integrationVO.DATE7","cts_integrationVO.DATE7");
			hmDate.put("cts_integrationVO.DATE8","cts_integrationVO.DATE8");
			hmDate.put("cts_integrationVO.DATE9","cts_integrationVO.DATE9");
			hmDate.put("cts_integrationVO.DATE10","cts_integrationVO.DATE10");
			hmDate.put("cts_integrationVO.MODIFIED_DATE","cts_integrationVO.MODIFIED_DATE");
			hmDate.put("cts_integrationVO.DATE_OF_INSERTION","cts_integrationVO.DATE_OF_INSERTION");
			hmDate.put("cts_integrationVO.CREDITING_DATE","cts_integrationVO.CREDITING_DATE");
			hmDate.put("cts_integrationVO.REFUND_DATE","cts_integrationVO.REFUND_DATE");
			hmDate.put("cts_integrationVO.EXPIRY_DATE","cts_integrationVO.EXPIRY_DATE");
			hmDate.put("cts_integrationVO.DATE_CLAIMED","cts_integrationVO.DATE_CLAIMED");
			hmDate.put("cts_integrationVO.DATE_STOPPED","cts_integrationVO.DATE_STOPPED");
			hmDate.put("cts_integrationVO.DATE_REJECTED","cts_integrationVO.DATE_REJECTED");
			integrationDynamicSC.setDateSearchCols(hmDate);
			setSearchFilter(integrationDynamicSC);
			copyproperties(integrationDynamicSC);
			
			SessionCO sessionCO = returnSessionObject();
			integrationDynamicSC.setUserId(sessionCO.getUserName());
			integrationDynamicSC.setCompCode(sessionCO.getCompanyCode());
			integrationDynamicSC.setLang(sessionCO.getLanguage());
			integrationDynamicSC.setLovTypeId(IntegrationDynamicConstant.DYNAMIC_INTEGRATION_STATUS);
			integrationDynamicSC.setStatus(IntegrationDynamicConstant.STATUS_ACTIVE);
			integrationDynamicSC.setRunningDate(sessionCO.getRunningDateRET());
			CIF_TRXTYPE_LIMITSVO cifTrxTypeLimitsVO = integrationDynamicBO.returnTypeCode(integrationDynamicSC); 
			if(null != cifTrxTypeLimitsVO && !NumberUtil.isEmptyDecimal(cifTrxTypeLimitsVO.getTYPE_CODE()))
			{
			    integrationDynamicSC.setTypeCode(cifTrxTypeLimitsVO.getTYPE_CODE());  
			}
			if (getRecords() == 0)
			{
				setRecords(integrationDynamicBO.returndynamicIntegrationListCount(integrationDynamicSC));
			}
			integrationDynList = integrationDynamicBO.returndynamicIntegrationList(integrationDynamicSC);
			// set the collection into gridModel attribute defined at JSP grid
			setGridModel(integrationDynList);

		} 
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
		return SUCCESS;
	}

    public void setIntegrationDynamicBO(IntegrationDynamicBO integrationDynamicBO)
    {
        this.integrationDynamicBO = integrationDynamicBO;
    }

    public IntegrationDynamicCO getIntegrationDynamicCO()
    {
        return integrationDynamicCO;
    }

    public void setIntegrationDynamicCO(IntegrationDynamicCO integrationDynamicCO)
    {
        this.integrationDynamicCO = integrationDynamicCO;
    }

   

   
    
    
}
