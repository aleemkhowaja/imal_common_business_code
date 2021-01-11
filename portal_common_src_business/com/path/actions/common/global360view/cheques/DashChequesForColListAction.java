/**
 * 
 */
package com.path.actions.common.global360view.cheques;

import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.cheques.DashChequesServicesBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashChequesForColListAction.java used to
 */
public class DashChequesForColListAction extends GridBaseAction
{
    private DashboardSC criteria = new DashboardSC();
    private DashChequesServicesBO dashChequesServicesBO;
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
     * @return String 
     *
     */
    public String loadChequesForColPage()
    {
        return SUCCESS;
    }
    
    /**
     * 
     * @author marwanmaddah
     * @date   May 23, 2013
     * @return
     *
     */
    /**
     * @return
     */
    public String chequesForColListGrid()
    {
  	String[] searchCol = {"COMP_CODE"
  			     ,"TRS_TYPE"
  			     ,"CB_IND"	
  			     ,"branch_code"
          		     ,"trx_no"
          		     ,"trx_date"
          		     ,"value_date"
          		     ,"cheque_date"
          		     ,"trs_acc_br"
          		     ,"trs_acc_cy"
          		     ,"from_acc_gl"
          		     ,"trs_acc_cif"
          		     ,"trs_acc_sl"
          		     ,"ADDITIONAL_REFERENCE"
          		     ,"LONG_NAME_ENG"
          		     ,"trs_currency"
          		     ,"amount"
          		     ,"cv_amount"};
  	HashMap<String,String> hmSearch = new HashMap<String,String>();
  	try
  	{
            hmSearch.put("trx_date","trx_date");
            hmSearch.put("value_date","value_date");
            hmSearch.put("cheque_date","cheque_date");
            
  	    SessionCO sessionCO = returnSessionObject();
  	    criteria.setSearchCols(searchCol);
  	    criteria.setDateSearchCols(hmSearch);
  	    copyproperties(criteria);
  	    
  	    criteria.setCompCode(sessionCO.getCompanyCode());
  	    if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(criteria.getLoginTypeByBr()))
  	    {
  	       criteria.setBranchCode(sessionCO.getBranchCode());
  	    }
 	    criteria.setUserId(sessionCO.getUserName());
 	   
  	    criteria.setIvCrud( getIv_crud());
  	    criteria.setProgRef(get_pageRef());
  	    criteria.setAppName( sessionCO.getCurrentAppName());
  	    criteria.setLanguage(sessionCO.getLanguage());
  	    criteria.setLovType(ConstantsCommon.SAFEBOXES_LOV_TYPE);
  	    criteria.setRunningDate(sessionCO.getRunningDateRET());
  	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    // [John Massaad]-- IN CASE 360 degree opened From another
	    // application then CSM The USER_ID of the Login application may not
	    // have a TELLER_CODE
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
  	    if(checkNbRec(criteria))
  	    {
  		setRecords(dashChequesServicesBO.chequesForColListCount(criteria));
  	    }
  	    setGridModel(dashChequesServicesBO.chequesForColList(criteria));
  	}

        catch(Exception ex)
        {
  	    log.error(ex, "Error in Safeboxes List Grid");
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
     * @param dashChequesServicesBO the dashChequesServicesBO to set
     */
    public void setDashChequesServicesBO(DashChequesServicesBO dashChequesServicesBO)
    {
        this.dashChequesServicesBO = dashChequesServicesBO;
    }
}
