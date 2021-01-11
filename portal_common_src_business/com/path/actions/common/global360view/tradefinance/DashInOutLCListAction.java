/**
 * 
 */
package com.path.actions.common.global360view.tradefinance;

import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
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
public class DashInOutLCListAction extends GridBaseAction
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
    public String loadInOutLCPage()
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
    public String inLCListGrid()
    {
        String[] searchCol = {"LC_NBR", "VALIDITY_FROM", "VALIDITY_TO", "LC_AMOUNT", "CV_AMOUNT",
            "LC_CURRENCY", "CREDIT_AVAILABILITY", "CREDIT_AVAILABILITY_DAYS", "statusDesc"};

        try
        {
            HashMap dateSearchCols = new HashMap();
            dateSearchCols.put("VALIDITY_FROM", "VALIDITY_FROM");
            dateSearchCols.put("VALIDITY_TO", "VALIDITY_TO");

            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());
            criteria.setLanguage(sessionCO.getLanguage());
            criteria.setLcType("I");
            criteria.setSearchCols(searchCol);
            criteria.setDateSearchCols(dateSearchCols);
            //Added by Mark Ayoub on 06/08/2020 - #1015216 - DBU191081
            criteria.setAppName(sessionCO.getCurrentAppName());
            criteria.setUserId(sessionCO.getUserName());
            //End Mark
            copyproperties(criteria);
            criteria.setLovType(ConstantsCommon.CREDIT_AVAILABILITY_LOV_TYPE);

            if(checkNbRec(criteria))
            {
                setRecords(dashTradeFinanceBO.inOutLCListCount(criteria));
            }
            setGridModel(dashTradeFinanceBO.inOutLCList(criteria));
        }

        catch(Exception ex)
        {
            log.error(ex, "Error in In/Out LC List Grid");
            handleException(ex, null, null);
        }
        return SUCCESS;
    }

    public String outLCListGrid()
    {
        String[] searchCol = {"LC_NBR", "VALIDITY_FROM", "VALIDITY_TO", "LC_AMOUNT", "CV_AMOUNT",
            "LC_CURRENCY", "CREDIT_AVAILABILITY", "CREDIT_AVAILABILITY_DAYS"};

        try
        {
            HashMap dateSearchCols = new HashMap();
            dateSearchCols.put("VALIDITY_FROM", "VALIDITY_FROM");
            dateSearchCols.put("VALIDITY_TO", "VALIDITY_TO");

            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());
            criteria.setLanguage(sessionCO.getLanguage());
            criteria.setLcType("O");
            criteria.setSearchCols(searchCol);
            criteria.setDateSearchCols(dateSearchCols);
            //Added by Mark Ayoub on 06/08/2020 - #1015216 - DBU191081
            criteria.setAppName(sessionCO.getCurrentAppName());
            criteria.setUserId(sessionCO.getUserName());
            //End Mark
            copyproperties(criteria);
            criteria.setLovType(ConstantsCommon.CREDIT_AVAILABILITY_LOV_TYPE);

            if(checkNbRec(criteria))
            {
                setRecords(dashTradeFinanceBO.inOutLCListCount(criteria));
            }
            setGridModel(dashTradeFinanceBO.inOutLCList(criteria));
        }

        catch(Exception ex)
        {
            log.error(ex, "Error in In/Out LC List Grid");
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
