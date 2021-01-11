/**
 * 
 */
package com.path.actions.common.global360view.others;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.others.DashOthersBO;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashOthersCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: elieachkar
 * 
 *          DashVoidedChequesListAction.java used to
 */
public class DashSOListAction extends GridBaseAction
{
    private DashOthersBO dashOthersBO;
    private DashboardSC criteria = new DashboardSC();
    private DashOthersCO dashOthersCO  = new DashOthersCO();


    /**
     * 
     */
    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * 
     * @return String
     * 
     */
    public String loadSOPage()
    {
	fillSOTransactionCounts();
	
	return SUCCESS;
    }

    /**
     * 
     * @author elieachkar
     * @date May 29, 2013
     * @return
     * 
     */
    public String soListGrid()
    {
	String[] searchCol = {"COMP_CODE","TRS_TYPE","CB_IND" ,"BRANCH_CODE", "trsStatusDesc", "TRS_NO", "TRX_TYPE", "SHORT_DESC_ENG", "TRS_AC_BR", 
		"TRS_AC_CY", "TRS_AC_GL", "TRS_AC_CIF", "TRS_AC_SL", "BRIEF_NAME_ENG", "ADDITIONAL_REFERENCE", 
		"TO_TRS_AC_BR", "TO_TRS_AC_CY", "TO_TRS_AC_GL", "TO_TRS_AC_CIF", "TO_TRS_AC_SL", 
		"TO_BRIEF_NAME_ENG", "TO_ADDITIONAL_REFERENCE", "AMOUNT", "SO_PROCESS_TYPE", 
		"SO_PERIODICITY", "startDate", "endDate" };
	HashMap<String,String> hmSearchDate = new HashMap<String,String>();
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setSearchCols(searchCol);
	    hmSearchDate.put("startDate" ,"startDate");
	    hmSearchDate.put("endDate" ,"endDate");
	    criteria.setDateSearchCols(hmSearchDate);
	    copyproperties(criteria);
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setLovType(ConstantsCommon.PROCESS_LOV_TYPE);
	    criteria.setLovPeriodicity(ConstantsCommon.PERIODICITY_LOV_TYPE);
	    criteria.setTrsStatusLovType(TrxMgntConstant.LOV_TYPE);
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setProgRef(get_pageRef());
	    //917789 - DBU191081  
	    criteria.setLoginBranchCode(sessionCO.getBranchCode());
	    
	    // [John Massaad]-- IN CASE 360 degree opened From another
	    // application then CSM The USER_ID of the Login application may not
	    // have a TELLER_CODE
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {

		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
	    if(checkNbRec(criteria))
	    {
		setRecords(dashOthersBO.soListCount(criteria));
	    }
	    setGridModel(dashOthersBO.soList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Standing Order List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    private void fillSOTransactionCounts()
    {
	try
	{    
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    copyproperties(criteria);
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setLovType(ConstantsCommon.PROCESS_LOV_TYPE);
	    criteria.setLovPeriodicity(ConstantsCommon.PERIODICITY_LOV_TYPE);
	    criteria.setTrsStatusLovType(TrxMgntConstant.LOV_TYPE);
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setProgRef(get_pageRef());
	    
	    
	    // [John Massaad]-- IN CASE 360 degree opened From another
	    // application then CSM The USER_ID of the Login application may not
	    // have a TELLER_CODE
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
	    if(checkNbRec(criteria))
	    {   criteria.setTrsStatus(TrxMgntConstant.STATUS_CREATED_SO);//count only STATUS created
		dashOthersCO.setNbrOfTemplateSO(new BigDecimal(dashOthersBO.soListCount(criteria)));
		
		criteria.setTrsStatus("O");//count statuses other than created
		dashOthersCO.setNbrOfProcessedSO(new BigDecimal(dashOthersBO.soListCount(criteria)));
	    }
	}
	catch(Exception ex)
	{
	    log.error(ex, "Error in Standing Order List Grid");
	    handleException(ex, null, null);
	}
    }
    /**
     * @param dashChequesServicesBO the dashChequesServicesBO to set
     */
    public void setDashOthersBO(DashOthersBO dashOthersBO)
    {
	this.dashOthersBO = dashOthersBO;
    }

    /**
     * @return the criteria
     */
    public DashboardSC getCriteria()
    {
	return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(DashboardSC criteria)
    {
	this.criteria = criteria;
    }

    public DashOthersCO getDashOthersCO()
    {
        return dashOthersCO;
    }

    public void setDashOthersCO(DashOthersCO dashOthersCO)
    {
        this.dashOthersCO = dashOthersCO;
    }
}
