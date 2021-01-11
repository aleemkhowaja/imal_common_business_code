/**
 * 
 */
package com.path.actions.common.global360view.smssubscription;

import java.math.BigDecimal;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.DashboardBO;

import com.path.lib.common.util.PathPropertyUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;


public class DashboardSmsSubscriptionListAction extends GridBaseAction
{
   // private DashboardSC criteria = new DashboardSC();
    private DashboardSC criteria = new DashboardSC();

    private DashboardBO dashboardBO ;
    /**
     * 
     * @date   May 3, 2013
     * @return String 
     *
     */
    public String loadSmsSubscriptionPage()
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
     */
    public String smsSubscriptionListGrid()
    {
	  try
	{
  	  String[] searchCol = {"BRANCH_CODE", "CODE", "ACC_BR", "ACC_CY", "ACC_GL", "ACC_CIF", "ACC_SL", "smsSubStatus", "MOBILE_NUM"};
  	  SessionCO sessionCO = returnSessionObject();
  	 criteria.setSearchCols(searchCol);
	 copyproperties(criteria);
  	
  	
  	 DashboardSC dashboardSc=new DashboardSC();
  	 PathPropertyUtil.copyProperties(criteria, dashboardSc);
  	dashboardSc.setCompCode(sessionCO.getCompanyCode());
  	dashboardSc.setBranchCode(sessionCO.getBranchCode());
  	dashboardSc.setCrudMode(getIv_crud());
  	//smsSubscriptionSC.setLovTypeId(SmsSubscriptionConstant.LOV_TYPE);
  	dashboardSc.setLovTypeId(new BigDecimal(473));
  	dashboardSc.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
  	dashboardSc.setCurrAppName(sessionCO.getCurrentAppName());
  	dashboardSc.setCifNo(criteria.getCif_no());
  	dashboardSc.setOriginalProgRef(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef()));
  	dashboardSc.setLanguage(sessionCO.getLanguage()); 
  	dashboardSc.setCrudMode("R");
  	  copyproperties(criteria);
  	dashboardSc.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
  	  criteria.setBranchCode(BigDecimal.ZERO);
  	//bug #837556 System is not displaying the code of SMS subscription in another branch
        if (new BigDecimal(2) .equals(criteria.getLoginTypeByBr()))
        {
        	    dashboardSc.setBranchCode(BigDecimal.ZERO);
        }
  	  if(checkNbRec(criteria))
  	  {
  	      setRecords(dashboardBO.returnDashboardSmsSubscriptionListCount(dashboardSc));
  	  }
  	  setGridModel(dashboardBO.returnDashboardSmsSubscriptionList(dashboardSc));
  	}
  	catch(Exception e)
  	{
  	    log.error(e, "Error in loadSmsSubscriptionGrid of SmsSubscriptionListAction");
  	    handleException(e, null, null);
  	}
        return SUCCESS;
    }

   

  

    public DashboardSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(DashboardSC criteria)
    {
        this.criteria = criteria;
    }

    public DashboardBO getDashboardBO()
    {
        return dashboardBO;
    }

    public void setDashboardBO(DashboardBO dashboardBO)
    {
        this.dashboardBO = dashboardBO;
    }

    

}
