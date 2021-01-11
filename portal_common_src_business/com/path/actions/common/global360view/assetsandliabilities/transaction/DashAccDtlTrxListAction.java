/**
 * 
 */
package com.path.actions.common.global360view.assetsandliabilities.transaction;

import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.DashboardBO;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashAccDtlTrxCO;
import com.path.vo.common.global360view.DashAccountDetailsCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashAccDtlJvsListAction.java used to
 */
public class DashAccDtlTrxListAction extends GridBaseAction
{
    private DashboardSC          criteria             = new DashboardSC();
    private DashAccDtlTrxCO      dashAccDtlTrxCO      = new DashAccDtlTrxCO();
    private DashAccountDetailsCO dashAccountDetailsCO = new DashAccountDetailsCO();
    private DashboardBO          dashboardBO;
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
     * @author marwanmaddah
     * @date   May 28, 2013
     * @return String
     *
     */
    public String loadAccDtlTrxPage()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(criteria.getLoginTypeByBr()))
	    {
	      criteria.setBranchCode(sessionCO.getBranchCode());
	    }
	    dashAccountDetailsCO = dashboardBO.returnAccountData(criteria);
	}
	catch(Exception ex)
	{
	    log.error(ex, "Error in Safeboxes List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * 
     * @author marwanmaddah
     * @date   May 28, 2013
     * @return
     *
     */
    public String accDtlTrxListGrid()
    {
  	String[] searchCol = {"COMP_CODE"
		     	     ,"TRS_TYPE"
			     ,"CB_IND"
			     ,"TRX_TYPE"
  			     ,"trx_branch"
          		     ,"trx_no"
          		     ,"trx_desc"
          		     ,"trx_status"
          		     ,"trade_date"
          		     ,"value_date"
          		     ,"amount"
          		     ,"cvAmount"
          		     ,"voidReason"};

  	HashMap<String,String> hmDate = new HashMap<String,String>();
  	try
  	{

  	    hmDate.put("trade_date", "trade_date");
  	    hmDate.put("value_date", "value_date");
  	    
  	    SessionCO sessionCO = returnSessionObject();
  	    criteria.setSearchCols(searchCol);
  	    criteria.setDateSearchCols(hmDate);
  	    copyproperties(criteria);
  	    
  	    criteria.setCompCode(sessionCO.getCompanyCode());
  	    if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(criteria.getLoginTypeByBr()))
  	    {
  	       criteria.setBranchCode(sessionCO.getBranchCode());
  	    }
  	    criteria.setIvCrud( getIv_crud());
  	    criteria.setProgRef(get_pageRef());
  	    criteria.setAppName( sessionCO.getCurrentAppName());
  	    criteria.setLanguage(sessionCO.getLanguage());
  	    criteria.setLangCode(sessionCO.getLanguage());
  	    criteria.setLovType(TrxMgntConstant.LOV_TYPE);
  	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
  	    if(checkNbRec(criteria))
  	    {
  		setRecords(dashboardBO.accDtlTrxListCount(criteria));
  	    }
  	    setGridModel(dashboardBO.accDtlTrxList(criteria));
  	}

        catch(Exception ex)
        {
  	    log.error(ex, "Error in Safeboxes List Grid");
	    handleException(ex, null, null);
        }
        return SUCCESS;
    }

    /**
     * @param dashboardBO the dashboardBO to set
     */
    public void setDashboardBO(DashboardBO dashboardBO)
    {
        this.dashboardBO = dashboardBO;
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

    /**
     * @return the dashAccDtlTrxCO
     */
    public DashAccDtlTrxCO getDashAccDtlTrxCO()
    {
        return dashAccDtlTrxCO;
    }

    /**
     * @param dashAccDtlTrxCO the dashAccDtlTrxCO to set
     */
    public void setDashAccDtlTrxCO(DashAccDtlTrxCO dashAccDtlTrxCO)
    {
        this.dashAccDtlTrxCO = dashAccDtlTrxCO;
    }

    /**
     * @return the dashAccountDetailsCO
     */
    public DashAccountDetailsCO getDashAccountDetailsCO()
    {
        return dashAccountDetailsCO;
    }

    /**
     * @param dashAccountDetailsCO the dashAccountDetailsCO to set
     */
    public void setDashAccountDetailsCO(DashAccountDetailsCO dashAccountDetailsCO)
    {
        this.dashAccountDetailsCO = dashAccountDetailsCO;
    }

}
