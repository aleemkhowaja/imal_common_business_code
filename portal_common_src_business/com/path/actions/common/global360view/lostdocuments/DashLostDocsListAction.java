	/**
 * 
 */
package com.path.actions.common.global360view.lostdocuments;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.lostdocuments.DashLostDocsBO;
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
public class DashLostDocsListAction extends GridBaseAction
{
    private DashboardSC   criteria = new DashboardSC();
    private DashLostDocsBO dashLostDocsBO;    
    /**
     * 
     */
    @Override
    public Object getModel()
    {
  	return criteria;
    }
    
    public String loadLostDocsPage()
    {
        return SUCCESS;
    }    
    
    
    /**
     * prepare chequebooks grid data 
     * @date   May 13, 2013
     * @return
     *
     */
    public String lostDocsListGrid()
    {
	String[] searchCol = {"branch_code"
            		     ,"trx_no"     
            		     ,"status"  
            		     ,"DOC_TYPE"
            		     ,"DOC_TYPE_BRIEF_NAME"
            		     ,"DOC_CODE"
            		     ,"DOC_CODE_BRIEF_NAME"
            		     ,"acc_br"     
            		     ,"acc_cy"     
            		     ,"acc_gl"     
            	 	     ,"acc_cif"    
            		     ,"acc_sl" 
            		     ,"ACC_ADD_REF"
            		     ,"ACC_LONG_NAME"
            		     ,"doc_no"     
            		     ,"to_doc_no"  
            		     ,"stop_date"  
            		     ,"stop_reason"};
  	try
  	{

  	    SessionCO sessionCO = returnSessionObject();
  	    criteria.setSearchCols(searchCol);
  	    copyproperties(criteria);
  	    
  	    criteria.setCompCode(sessionCO.getCompanyCode());
  	    if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(criteria.getLoginTypeByBr()))
  	    {
  	       criteria.setBranchCode(sessionCO.getBranchCode());
  	    }
  	    //917789 - DBU191081  
  	    criteria.setLoginBranchCode(sessionCO.getBranchCode());
  	    criteria.setIvCrud( getIv_crud());
  	    criteria.setProgRef(get_pageRef());
  	    criteria.setAppName(sessionCO.getCurrentAppName());
  	    criteria.setLanguage(sessionCO.getLanguage());
  	    criteria.setLangCode(sessionCO.getLanguage());
  	    criteria.setLovType(ConstantsCommon.LOST_DOC_STATUS_LOV_TYPE);
  	    criteria.setUserId(sessionCO.getUserName());
      	    //[John Massaad]-- IN CASE 360 degree opened From another application then CSM The USER_ID of the Login application may not have a TELLER_CODE
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
  	    if(checkNbRec(criteria))
  	    {
  		setRecords(dashLostDocsBO.lostDocsListCount(criteria));
  	    }
  	    setGridModel(dashLostDocsBO.lostDocsList(criteria));
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
     * @param dashLostDocsBO the dashLostDocsBO to set
     */
    public void setDashLostDocsBO(DashLostDocsBO dashLostDocsBO)
    {
        this.dashLostDocsBO = dashLostDocsBO;
    }

}
