/**
 * 
 */
package com.path.actions.common.global360view.assetsandliabilities.dues;

import com.path.bo.common.global360view.DashboardBO;
import com.path.bo.core.entitycharges.EntityChargesConstant;
import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: EliasAoun
 * @Modif IIAB080110 - Dues in Global view
 * 
 *          DashAccDtlDuesListAction.java used to
 */
public class DashAccDtlDuesListAction extends GridBaseAction
{
    private DashboardSC criteria = new DashboardSC();
    private DashboardBO dashboardBO;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public String loadDuesForAccPage() throws BaseException
    {
	return "loadDuesForAccPage";
    }

    public String populateDuesForAccList() throws BaseException
    {
	String[] searchCol = {"APP_NAME"};
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    copyproperties(criteria);

	    criteria.setSearchCols(searchCol);
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setLanguage(sessionCO.getLanguage());
	    
	    criteria.setPaymentModeLovType( EntityChargesConstant.PAYMENT_MODE_LOV_TYPE);
	    criteria.setDuesStatusLovType( EntityChargesConstant.STATUS_LOV_TYPE);
	    criteria.setDuesTypeLovType( EntityChargesConstant.DUE_TYPE_LOV_TYPE);
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(dashboardBO.duesForAccListCount(criteria));
	    }
	    setGridModel(dashboardBO.duesForAccList(criteria));
	}

	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public DashboardSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(DashboardSC criteria)
    {
	this.criteria = criteria;
    }

    public void setDashboardBO(DashboardBO dashboardBO)
    {
	this.dashboardBO = dashboardBO;
    }

}
