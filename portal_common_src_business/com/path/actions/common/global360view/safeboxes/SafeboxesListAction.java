/**
 * 
 */
package com.path.actions.common.global360view.safeboxes;

import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.safeboxes.SafeboxesBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * SafeboxesListAction.java used to
 */
public class SafeboxesListAction extends GridBaseAction
{
  private SafeboxesBO safeboxesBO;
  private DashboardSC criteria = new DashboardSC();
  
  /**
   * 
   * @date   May 3, 2013
   * @return String
   *
   */
  public String loadSafeboxesPage()
  {
      return SUCCESS;
  }
  
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
   * @date   May 3, 2013
   * @return
   *
   */
  public String safeboxesListGrid()
  {
	String[] searchCol = { "branch_code"
                		,"trx_no"
                		,"type"
                		,"safebox_no"
                		,"safeBoxStatus"
                		,"safeBoxTrxStatus"
                		,"PARAM_TYPE"
                		,"location"
                		,"statusdesc"
                		,"acc_br"
                		,"acc_cy"
                		,"acc_gl"
                		,"acc_cif"
                		,"acc_sl"
                		,"acc_add_ref"
                		,"accountName"
                		,"dateFrom"
                		,"dateTo"};
	HashMap<String,String> hmSearchDate = new HashMap<String,String>();
	try
	{

	    SessionCO sessionCO = returnSessionObject();
	    hmSearchDate.put("dateFrom" ,"dateFrom");
	    hmSearchDate.put("dateTo" ,"dateTo");
	    criteria.setSearchCols(searchCol);
	    criteria.setDateSearchCols(hmSearchDate);
	    copyproperties(criteria);
	    
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setLoginBranchCode(sessionCO.getBranchCode());
	    if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(criteria.getLoginTypeByBr()))
	    {
	      criteria.setBranchCode(sessionCO.getBranchCode());
	    }
	    criteria.setIvCrud( getIv_crud());
	    criteria.setProgRef(get_pageRef());
	    criteria.setAppName( sessionCO.getCurrentAppName());
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setLovType(ConstantsCommon.SAFEBOXES_LOV_TYPE);
	    criteria.setUserId(sessionCO.getUserName());
	    
	  //[John Massaad]-- IN CASE 360 degree opened From another application then CSM The USER_ID of the Login application may not have a TELLER_CODE
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
	    if(checkNbRec(criteria))
	    {
		setRecords(safeboxesBO.safeboxesListCount(criteria));
	    }
	    setGridModel(safeboxesBO.safeboxesList(criteria));
	}

      catch(Exception ex)
      {
	    log.error(ex, "Error in Safeboxes List Grid");
	    handleException(ex, null, null);
      }
      return SUCCESS;
  }

/**
 * @param safeboxesBO the safeboxesBO to set
 */
public void setSafeboxesBO(SafeboxesBO safeboxesBO)
{
    this.safeboxesBO = safeboxesBO;
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
