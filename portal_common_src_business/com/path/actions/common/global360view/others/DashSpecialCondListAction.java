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
public class DashSpecialCondListAction extends GridBaseAction
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
    public String loadSpecialCondPage()
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
    public String specialCondCifListGrid()
    {
	String[] searchCol = { "LINE_NO","CIF_NO", "CIF_NAME", "FORBID_RESTRICT_TRX", "FORBID_PRODUCT", "REASON",
				"STARTING_DATE", "EXPIRY_DATE", "ALLOW_SO" };

	try
	{
	    HashMap dateSearchCols = new HashMap();
	    dateSearchCols.put("STARTING_DATE", "STARTING_DATE");
	    dateSearchCols.put("EXPIRY_DATE", "EXPIRY_DATE");
	    
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setLovType(ConstantsCommon.FORBID_RESTRICT_TRX_LOV_TYPE);
	    criteria.setLovPeriodicity(ConstantsCommon.FORBID_PRODUCT_LOV_TYPE);
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setSearchCols(searchCol);
	    criteria.setDateSearchCols(dateSearchCols);
	    copyproperties(criteria);
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setProgRef(get_pageRef());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    //917789 - DBU191081  
	    criteria.setLoginBranchCode(sessionCO.getBranchCode());
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(dashOthersBO.specialCondCifListCount(criteria));
	    }
	    setGridModel(dashOthersBO.specialCondCifList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Special Conditions List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    public String specialCondAccListGrid()
    {
	String[] searchCol = { "LINE_NO","ACC_BRANCH", "ACC_CURRENCY", "ACC_GL", "ACC_CIF", "ACC_SL", "ACC_NAME", 
		"FORBID_RESTRICT_TRX", "FORBID_PRODUCT", "REASON", "STARTING_DATE", "EXPIRY_DATE", "ALLOW_SO" };

	try
	{
	    HashMap dateSearchCols = new HashMap();
	    dateSearchCols.put("STARTING_DATE", "STARTING_DATE");
	    dateSearchCols.put("EXPIRY_DATE", "EXPIRY_DATE");
	    
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setLovType(ConstantsCommon.FORBID_RESTRICT_TRX_LOV_TYPE);
	    criteria.setLovPeriodicity(ConstantsCommon.FORBID_PRODUCT_LOV_TYPE);
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setProgRef(get_pageRef());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    //917789 - DBU191081  
	    criteria.setLoginBranchCode(sessionCO.getBranchCode());

	    // [John Massaad]-- IN CASE 360 degree opened From another
	    // application then CSM The USER_ID of the Login application may not
	    // have a TELLER_CODE
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {

		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);

	    if(checkNbRec(criteria))
	    {
		setRecords(dashOthersBO.specialCondAccListCount(criteria));
	    }
	    setGridModel(dashOthersBO.specialCondAccList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Special Conditions List Grid");
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
