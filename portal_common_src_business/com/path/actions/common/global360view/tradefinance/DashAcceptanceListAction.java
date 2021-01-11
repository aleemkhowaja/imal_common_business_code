/**
 * 
 */
package com.path.actions.common.global360view.tradefinance;

import java.util.HashMap;

import com.path.bo.common.global360view.tradefinance.DashTradeFinanceBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: elieachkar
 * 
 *          DashAcceptanceListAction.java used to
 */
public class DashAcceptanceListAction extends GridBaseAction
{
    private DashTradeFinanceBO dashTradeFinanceBO;
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
    public String loadAcceptancePage()
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
    public String acceptanceListGrid()
    {
	String[] searchCol = { "LC_NBR", "TRX_NBR", "CURRENCY", "SHIPMENT_AMOUNT", "CV_AMOUNT", "TRX_DATE", 
		"VALID_TO", "LC_TYPE" };

	try
	{
	    HashMap dateSearchCols = new HashMap();
	    dateSearchCols.put("TRX_DATE", "TRX_DATE");
	    dateSearchCols.put("VALID_TO", "VALID_TO");
	    
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setSearchCols(searchCol);
	    criteria.setDateSearchCols(dateSearchCols);
	    
            //Added by Mark Ayoub on 06/08/2020 - #1015216 - DBU191081
            criteria.setAppName(sessionCO.getCurrentAppName());
            criteria.setUserId(sessionCO.getUserName());
            //End Mark
	    copyproperties(criteria);

	    if(checkNbRec(criteria))
	    {
		setRecords(dashTradeFinanceBO.acceptanceListCount(criteria));
	    }
	    setGridModel(dashTradeFinanceBO.acceptanceList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Acceptance List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public void setDashTradeFinanceBO(DashTradeFinanceBO dashTradeFinanceBO)
    {
	this.dashTradeFinanceBO = dashTradeFinanceBO;
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
