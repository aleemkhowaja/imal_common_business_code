package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.economicagent.EconomicAgentBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CTS_ECONOMIC_AGENTVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.economicagent.EconomicAgentSC;

public class EconomicAgentLookupAction extends LookupBaseAction
{
   
    private EconomicAgentSC economicAgentSC = new EconomicAgentSC();
    private BigDecimal CIF_TYPE_CODE;  
    private List<CTS_ECONOMIC_AGENTVO> ecoAgentVOList;
    private EconomicAgentBO economicAgentBO;

    @Override
    public Object getModel()
    {
	return economicAgentSC;
    }

    /**
     * Construct EconomicAgent Lookup based on the VO returned in the
     * resultMap.
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ENG", "LONG_NAME_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("economic_agent_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Eng_key"),
		    getText("Long_Desc_Arab_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
		colType = new String[] { "number", "text", "text"};
		titles = new String[] { getText("economic_agent_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("economic_agent_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/EconomicAgent_fillEconomicAgentLookup");
	    
	    lookup(grid, economicAgentSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    /**
     * Fill the lookup for EconomicAgent data filtered by the defined criteria
     * 
     * @return
     */
    public String fillEconomicAgentLookup()
    {
	try
	{
	    setSearchFilter(economicAgentSC);
	    copyproperties(economicAgentSC);
	    SessionCO sessionCO = returnSessionObject();
	    economicAgentSC.setCompCode(sessionCO.getCompanyCode());
	    economicAgentSC.setCifType(NumberUtil.emptyDecimalToNull(CIF_TYPE_CODE));
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);	
	    economicAgentSC.setUseCifMatrix(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()));	    
	    if((("1".equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()))
		    && !NumberUtil.isEmptyDecimal(CIF_TYPE_CODE))
		    || ("0".equals(StringUtil.nullEmptyToValue(cifControlVO.getUSE_CIF_MATRIX_YN(), "0"))))) 
	    {
        	    if(checkNbRec(economicAgentSC))
        	    {
        		setRecords(economicAgentBO.economicAgentListCount(economicAgentSC));
        	    }
        	    ecoAgentVOList = economicAgentBO.economicAgentList(economicAgentSC);
	    }
            // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(ecoAgentVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of EconomicAgentLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setEconomicAgentBO(EconomicAgentBO economicAgentBO)
    {
        this.economicAgentBO = economicAgentBO;
    }

    public BigDecimal getCIF_TYPE_CODE()
    {
        return CIF_TYPE_CODE;
    }

    public void setCIF_TYPE_CODE(BigDecimal CIF_TYPE_CODE)
    {
        this.CIF_TYPE_CODE = CIF_TYPE_CODE;
    }
    
    
}