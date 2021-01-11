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
 * DashVoidedChequesListAction.java used to
 */
public class DashLGListAction extends GridBaseAction
{
    private DashTradeFinanceBO dashTradeFinanceBO;
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
    public String loadLGPage()
    {
        return SUCCESS;
    }

    /**
     * 
     * @author marwanmaddah
     * @date May 23, 2013
     * @return
     * 
     */
    public String lgListGrid()
    {
        String[] searchCol = {"LG_NBR", "VALIDITY_FROM", "VALIDITY_TO", "DOC_DATE", "CURRENCY", "AMOUNT",
            "CV_AMOUNT"};

        try
        {
            SessionCO sessionCO = returnSessionObject();

            HashMap dateSearchCols = new HashMap();
            dateSearchCols.put("VALIDITY_FROM", "VALIDITY_FROM");
            dateSearchCols.put("VALIDITY_TO", "VALIDITY_TO");
            dateSearchCols.put("DOC_DATE", "DOC_DATE");

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
                setRecords(dashTradeFinanceBO.lgListCount(criteria));
            }
            setGridModel(dashTradeFinanceBO.lgList(criteria));
        }

        catch(Exception ex)
        {
            log.error(ex, "Error in LG List Grid");
            handleException(ex, null, null);
        }
        return SUCCESS;
    }

    /**
     * @param dashChequesServicesBO the dashChequesServicesBO to set
     */
    public void setDashTradeFinanceBO(DashTradeFinanceBO dashTradeFinanceBO)
    {
        this.dashTradeFinanceBO = dashTradeFinanceBO;
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
