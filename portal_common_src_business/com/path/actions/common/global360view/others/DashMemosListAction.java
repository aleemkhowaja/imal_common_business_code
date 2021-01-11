/**
 * 
 */
package com.path.actions.common.global360view.others;

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
public class DashMemosListAction extends GridBaseAction
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
    public String loadMemosPage()
    {
	return SUCCESS;
    }

    /**
     * 
     * @author elieachkar
     * @date May 23, 2013
     * @return
     * 
     */
    public String memosListGrid()
    {
	String[] searchCol = { "BRANCH_CODE", "TRX_NO", "ENG_COMENT", "COMMON_DESC_ENG", "BRIEF_DESC_ENG" ,"LONG_DESC_ENG", 
		"BRIEF_DESC_ARAB", "LONG_DESC_ARAB", "ARAB_COMENT" };

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setRunningDate(sessionCO.getRunningDateRET());
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setProgRef(get_pageRef());
	    copyproperties(criteria);
	    //917789 - DBU191081  
	    criteria.setLoginBranchCode(sessionCO.getBranchCode());
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
	    criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
	    if(checkNbRec(criteria))
	    {
		setRecords(dashOthersBO.memosListCount(criteria));
	    }
	    setGridModel(dashOthersBO.memosList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Memo List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
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
}
