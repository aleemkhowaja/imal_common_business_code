/**
 * 
 */
package com.path.actions.common.global360view.assetsandliabilities;

import java.math.BigDecimal;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.global360view.DashboardBO;
import com.path.dbmaps.vo.AMFVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.global360view.DashAccountDetailsCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: marwanmaddah
 * 
 *          DashAccountsDetailsListAction.java used to
 */
public class DashAccountsDetailsListAction extends GridBaseAction
{
    private DashboardSC criteria = new DashboardSC();
    private DashboardBO dashboardBO;

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
     * @date May 28, 2013
     * @return String
     * 
     */
    public String loadAccountsDetailsPage()
    {
	return SUCCESS;
    }

    /**
     * 
     * @author marwanmaddah
     * @date May 28, 2013
     * @return
     * @throws JSONException String
     * 
     */
    public String accountDetailsListGrid() throws JSONException
    {
	String[] searchCol = { "acc_num", "acc_add_ref","accountType", "accountTypeDesc", "status", "accountName", "ytdBalance", "availableBalance",
		"blockedAmount", "approvedLine", "currency", "rateOfReturn","showDues","showPostDTDepchqsBl","showPostWdDepchqsBl","showsettlchqsBl","activeWdBalance","investmentBalance" };

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
	    criteria.setIvCrud(getIv_crud());
	    criteria.setProgRef(get_pageRef());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setLovType(ConstantsCommon.ACCOUNT_STATUS_LOV_TYPE);
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    criteria.setRunningDate(sessionCO.getRunningDateRET());
	    criteria.setUserId(sessionCO.getUserName());
		 
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
	            criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
	    else
	    {
	            criteria.setTellerCode(BigDecimal.ZERO);
	    }
	    
	    

	    if(checkNbRec(criteria))
	    {
		setRecords(dashboardBO.accountDetailsListCount(criteria));
	    }
	    
	    //Hala Al Sheikh - SBI170052
	    List<DashAccountDetailsCO> dashAccountDetailsCOs = dashboardBO.accountDetailsList(criteria);
	    AMFVO amfVO = new AMFVO();
	    for(int i = 0; i < dashAccountDetailsCOs.size(); i++)
	    {
		amfVO.setCOMP_CODE(dashAccountDetailsCOs.get(i).getLoginCompCode());
		amfVO.setBRANCH_CODE(dashAccountDetailsCOs.get(i).getBranchCode());
		amfVO.setCURRENCY_CODE(dashAccountDetailsCOs.get(i).getCurrencyCode());
		amfVO.setGL_CODE(dashAccountDetailsCOs.get(i).getGlCode());
		amfVO.setCIF_SUB_NO(dashAccountDetailsCOs.get(i).getCifCode());
		amfVO.setSL_NO(dashAccountDetailsCOs.get(i).getSlNo());
		AuditRefCO refCO = initAuditRefCO();
		refCO.setOperationType(AuditConstant.DASHBOARD_DETAILS);
		refCO.setKeyRef(AuditConstant.FIXED_GENERAL_KEY_REF);
		refCO.setAppName(sessionCO.getCurrentAppName());
		refCO.setUserID(sessionCO.getUserName());
		if("G".equals(dashAccountDetailsCOs.get(i).getGmiFlag()))
		{
		    refCO.setProgRef("A002MA");

		}
		else
		{
		    refCO.setProgRef("A001MA");

		}
		amfVO.setAuditRefCO(refCO);
		
		
		auditBO.callAudit(null, amfVO, refCO);
	    }
	    //End Hala
	    setGridModel(dashAccountDetailsCOs);
	}

	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    // added by nancy - 01/02/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    public String loadpostDatedBalForAccPage() 
    {
	return "loadPostDatedChequesBalForAccPage";
    }
    public String populatePostDatedChequeTrxList() throws JSONException
    {
	String[] searchCol = {"BRANCH_CODE","TRS_NO","TRS_DATE","VALUE_DATE","TRS_AC_AMOUNT","CV_AMOUNT"};

       
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
	    criteria.setIvCrud(getIv_crud());
	    criteria.setProgRef(get_pageRef());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setLovType(ConstantsCommon.ACCOUNT_STATUS_LOV_TYPE);
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    criteria.setRunningDate(sessionCO.getRunningDateRET());
	    criteria.setUserId(sessionCO.getUserName());
  	  if(checkNbRec(criteria))
	    {
		setRecords(dashboardBO.postDatedChqListCount(criteria));
	    }
	    setGridModel(dashboardBO.postDatedChqListList(criteria));
  	}

        catch(Exception ex)
        {
  	    log.error(ex, "Error in Safeboxes List Grid");
	    handleException(ex, null, null);
        }
	return SUCCESS;
    }
    // end nancy 

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

}
