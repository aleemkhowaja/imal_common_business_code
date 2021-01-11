/**
 * 
 */
package com.path.actions.common.global360view.passbooks;

import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.DashboardBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * chequebooksListAction.java used to
 */
public class DashPassbooksListAction extends GridBaseAction
{
    private DashboardSC   criteria = new DashboardSC();
    private DashboardBO   dashboardBO;    
    /**
     * 
     */
    @Override
    public Object getModel()
    {
  	return criteria;
    }
    
    public String loadPassbooksPage()
    {
        return SUCCESS;
    }    
    
    
    /**
     * prepare chequebooks grid data 
     * @date   May 13, 2013
     * @return
     *
     */
    public String passbooksListGrid()
    {
	String[] searchCol = { "branch_code", "passbook_no", "status", "date_created", "passbook_type", "current_page", "acc_br", "acc_cy",
		"acc_gl", "acc_cif", "acc_sl","ACC_ADD_REF","ACC_LONG_NAME_ENG"};
	HashMap<String,String> hmSearchDate = new HashMap<String,String>();
  	try
  	{

  	    SessionCO sessionCO = returnSessionObject();
  	    hmSearchDate.put("date_created" ,"date_created");
  	    criteria.setSearchCols(searchCol);
  	    criteria.setDateSearchCols(hmSearchDate);
  	    copyproperties(criteria);
  	    
  	    criteria.setCompCode(sessionCO.getCompanyCode());
  	    
            if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(criteria.getLoginTypeByBr()))
    	    {
    	       criteria.setBranchCode(sessionCO.getBranchCode());
    	    }
  	    criteria.setIvCrud( getIv_crud());
  	    criteria.setProgRef(get_pageRef());
  	    criteria.setAppName(sessionCO.getCurrentAppName());
  	    criteria.setLanguage(sessionCO.getLanguage());
  	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
  	    criteria.setLovType(ConstantsCommon.PASSBOOK_STATUS_LOV_TYPE);
  	    criteria.setUserId(sessionCO.getUserName());
	    // [John Massaad]-- IN CASE 360 degree opened From another
	    // application then CSM The USER_ID of the Login application may not
	    // have a TELLER_CODE
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
  	    if(checkNbRec(criteria))
  	    {
  		setRecords(dashboardBO.passbooksListCount(criteria));
  	    }
  	    setGridModel(dashboardBO.passbooksList(criteria));
  	}

        catch(Exception ex)
        {
  	    log.error(ex, "Error in Chequebooks List Grid");
	    handleException(ex, null, null);
        }
        return SUCCESS;
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
     * @param dashboardBO the dashboardBO to set
     */
    public void setDashboardBO(DashboardBO dashboardBO)
    {
        this.dashboardBO = dashboardBO;
    }

}
