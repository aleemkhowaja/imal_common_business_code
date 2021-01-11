/**
 * 
 */
package com.path.actions.common.global360view.chequebooks;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.chequebooks.DashChequebooksBO;
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
public class DashChequebooksListAction extends GridBaseAction
{
    private DashboardSC   criteria = new DashboardSC();
    private DashChequebooksBO dashChequebooksBO;    
    /**
     * 
     */
    @Override
    public Object getModel()
    {
  	return criteria;
    }
    
    public String loadChequebooksPage()
    {
        return SUCCESS;
    }    
    
    
    /**
     * prepare chequebooks grid data 
     * @date   May 13, 2013
     * @return
     *
     */
    public String chequebooksListGrid()
    {
	String[] searchCol = { "BRANCH_CODE","CODE", "CHEQUE_CODE","TYPES_DESC", "ACC_BR", "ACC_CY", "ACC_GL", "ACC_CIF", "ACC_SL", "ACC_ADD_REF","LONG_NAME_ENG",
		"IBAN_ACC_NO", "FROM_NUMBER", "NUMBER_TO", "statusDesc", "STATUS" };

  	try
  	{

  	    SessionCO sessionCO = returnSessionObject();
  	    criteria.setSearchCols(searchCol);
  	    copyproperties(criteria);
  	    
  	    criteria.setCompCode(sessionCO.getCompanyCode());
  	    criteria.setLoginBranchCode(sessionCO.getBranchCode());
  	    if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(criteria.getLoginTypeByBr()))
  	    {
  	       criteria.setBranchCode(sessionCO.getBranchCode());
  	    }
  	    criteria.setIvCrud( getIv_crud());
  	    criteria.setProgRef(get_pageRef());
  	    criteria.setAppName(sessionCO.getCurrentAppName());
  	    criteria.setLanguage(sessionCO.getLanguage());
  	    criteria.setLovType(ConstantsCommon.CHEQUEBOOK_LOV_TYPE);
  	    criteria.setUserId(sessionCO.getUserName());
  	   //[John Massaad]-- IN CASE 360 degree opened From another application then CSM The USER_ID of the Login application may not have a TELLER_CODE
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
  	    if(checkNbRec(criteria))
  	    {
  		setRecords(dashChequebooksBO.chequebooksListCount(criteria));
  	    }
  	    setGridModel(dashChequebooksBO.chequebooksList(criteria));
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
     * @param dashChequebooksBO the dashChequebooksBO to set
     */
    public void setDashChequebooksBO(DashChequebooksBO dashChequebooksBO)
    {
        this.dashChequebooksBO = dashChequebooksBO;
    }

}
