/**
 * 
 */
package com.path.actions.common.global360view.bankerscheques;

import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.bankerscheques.DashBankersChequesBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashBankersChequesListAction.java used to
 */
public class DashBankersChequesListAction extends GridBaseAction 
{
    private DashboardSC criteria = new DashboardSC();
    private DashBankersChequesBO dashBankersChequesBO; 
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
    public String loadBankersChequesPage()
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
    public String bankersChequesListGrid()
    {
  	String[] searchCol = {"COMP_CODE"
		     	     ,"TRS_TYPE"
			     ,"CB_IND"
  			     ,"branch_code"     
              		     ,"trx_no"          
              		     ,"trx_type"
              		     ,"trxTypeDesc"
              		     ,"from_acc_br"     
              		     ,"from_acc_cy"     
              		     ,"from_acc_gl"     
              		     ,"from_acc_cif"    
              		     ,"from_acc_sl"     
              		     ,"from_acc_add_ref"
              		     ,"from_acc_name"
              		     ,"to_acc_br"       
              		     ,"to_acc_cy"       
              		     ,"to_acc_gl"       
              		     ,"to_acc_cif"      
              		     ,"to_acc_sl"       
              		     ,"to_acc_add_ref"  
              		     ,"to_acc_name"
              		     ,"amount"          
              		     ,"trx_date"        
              		     ,"remittance_type" 
              		     ,"remittance_status"};

  	HashMap<String,String> hmSearchDate = new HashMap<String,String>();
  	try
  	{

  	    hmSearchDate.put("trx_date" ,"trx_date");
  	    SessionCO sessionCO = returnSessionObject();
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
  	    criteria.setRmitStatusLov(ConstantsCommon.DASH_REMITTANCE_STATUS_LOV_TYPE);
  	    criteria.setLovPeriodicity(ConstantsCommon.REMITTANCE_TYPE_LOV_TYPE);
  	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
  	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
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
  		setRecords(dashBankersChequesBO.bankersChequesListCount(criteria));
  	    }
  	    setGridModel(dashBankersChequesBO.bankersChequesList(criteria));
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
     * @param dashBankersChequesBO the dashBankersChequesBO to set
     */
    public void setDashBankersChequesBO(DashBankersChequesBO dashBankersChequesBO)
    {
        this.dashBankersChequesBO = dashBankersChequesBO;
    }
    
}
