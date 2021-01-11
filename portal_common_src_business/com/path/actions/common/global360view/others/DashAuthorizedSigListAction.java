/**
 *
 */
package com.path.actions.common.global360view.others;

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
 *          DashAuthorizedSigListAction.java used to
 */
public class DashAuthorizedSigListAction extends GridBaseAction
{
    private DashOthersBO dashOthersBO;
    private DashboardSC criteria = new DashboardSC();

    /**
     *
     */
    public Object getModel()
    {
	return criteria;
    }

    /**
     *
     * @return String
     *
     */
    public String loadAuthorizedSigPage()
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
    public String authorizedSigListGrid()
    {
	String[] searchCol = {"BRANCH_CODE","NAME", "ID_TYPE", "ID" };

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setSearchCols(searchCol);
	    //917789 - DBU191081  
	    criteria.setLoginBranchCode(sessionCO.getBranchCode());
	    criteria.setUserId(sessionCO.getUserName()); 
	    copyproperties(criteria);
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    if(checkNbRec(criteria))
	    {
		setRecords(dashOthersBO.authorizedSigListCount(criteria));
	    }
	    setGridModel(dashOthersBO.authorizedSigList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Signatories List Grid");
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
