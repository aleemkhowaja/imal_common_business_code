/**
 * 
 */
package com.path.actions.common.global360view.others;

import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.others.DashOthersBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: elieachkar
 * 
 *          DashVoidedChequesListAction.java used to
 */
public class DashRemittancesListAction extends GridBaseAction
{
    private DashOthersBO dashOthersBO;
    private DashboardSC criteria = new DashboardSC();

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
    public String loadRemittancesPage()
    {
	return SUCCESS;
    }

    /**
     * 
     * @author elieachkar
     * @date May 29, 2013
     * @return
     * 
     */
    public String remittancesListGrid()
    {
	String[] searchCol = {"COMP_CODE","CB_IND","trsType","BRANCH_CODE", "TRS_NO", "TRX_TYPE", "TRS_TYPE", "SHORT_DESC_ENG", "TRS_AC_BR", 
		"TRS_AC_CY", "TRS_AC_GL", "TRS_AC_CIF", "TRS_AC_SL", "ACC_ADDITIONAL_REFERENCE", "LONG_NAME_ENG", 
		"TO_TRS_AC_BR", "TO_TRS_AC_CY", "TO_TRS_AC_GL", "TO_TRS_AC_CIF", "TO_TRS_AC_SL", "TO_ACC_ADD_REF", 
		"LONG_NAME_ENG", "AMOUNT", "TRS_AC_AMOUNT", "CV_AMOUNT", "TRS_DATE", "VALUE_DATE", 
		"REMITTANCE_STATUS", "REMITT_TYPE" };

	try
	{
	    HashMap dateSearchCols = new HashMap();
	    dateSearchCols.put("TRS_DATE", "TRS_DATE");
	    dateSearchCols.put("VALUE_DATE", "VALUE_DATE");
	    
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setSearchCols(searchCol);
	    criteria.setDateSearchCols(dateSearchCols);
	    copyproperties(criteria);
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setLangCode(sessionCO.getPreferredLanguage());
	    criteria.setLovType(ConstantsCommon.TRS_TYPE_LOV_TYPE);
	    criteria.setRmitStatusLov(ConstantsCommon.DASH_REMITTANCE_STATUS_LOV_TYPE);
	    criteria.setLovPeriodicity(ConstantsCommon.REMITTANCE_TYPE_LOV_TYPE);
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
		setRecords(dashOthersBO.remittancesListCount(criteria));
	    }
	    setGridModel(dashOthersBO.remittancesList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Remittances List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public void setDashOthersBO(DashOthersBO dashOthersBO)
    {
	this.dashOthersBO = dashOthersBO;
    }

    public DashboardSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(DashboardSC criteria)
    {
	this.criteria = criteria;
    }
}
