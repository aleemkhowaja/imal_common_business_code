/**
 * 
 */
package com.path.actions.common.global360view.assetsandliabilities.jvs;

import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.DashboardBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashAccDtlJvsCO;
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
public class DashAccDtlJvsListAction extends GridBaseAction
{
    private DashboardSC criteria = new DashboardSC();
    private DashAccDtlJvsCO dashAccDtlJvsCO = new DashAccDtlJvsCO();
    private DashAccountDetailsCO dashAccountDetailsCO = new DashAccountDetailsCO();
    private DashboardBO dashboardBO;
    /**
     * 
     */
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
    public String loadAccDtlJvsPage()
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
    public String accDtlJvsListGrid()
    {
  	String[] searchCol = {"op_no"
          		     ,"jv_type"
          		     ,"jv_ref"
          		     ,"op_status"
          		     ,"value_date"
          		     ,"statusDesc"
          		     ,"trx_date"
          		     ,"amount"
          		     ,"description"};

  	HashMap<String,String> hmDate = new HashMap<String,String>();
  	try
  	{
  	    hmDate.put("value_date", "value_date");
  	    hmDate.put("trx_date", "trx_date");

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
  	    criteria.setAppName(sessionCO.getCurrentAppName());
  	    //Bug # 346812 -- [John Massaad] 
  	    //Using LOV_TYPE_TYPE = 262 to display the correct status description of DOF.OP_STATUS OR HST.OP_STATUS 
  	    criteria.setLovType(ConstantsCommon.MANUAL_JV_STATUS_LOV_TYPE);
  	    //Bug # 346812 -- [John Massaad]
  	    criteria.setLanguage(sessionCO.getLanguage());
  	    
  	    if(checkNbRec(criteria))
  	    {
  		setRecords(dashboardBO.accDtlJvsListCount(criteria)); 
  	    }
  	    setGridModel(dashboardBO.accDtlJvsList(criteria));
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
     * @return the dashAccDtlJvsCO
     */
    public DashAccDtlJvsCO getDashAccDtlJvsCO()
    {
        return dashAccDtlJvsCO;
    }

    /**
     * @param dashAccDtlJvsCO the dashAccDtlJvsCO to set
     */
    public void setDashAccDtlJvsCO(DashAccDtlJvsCO dashAccDtlJvsCO)
    {
        this.dashAccDtlJvsCO = dashAccDtlJvsCO;
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
