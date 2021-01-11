
package com.path.actions.common.global360view.fms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.bo.common.global360view.fms.DashFMSBO;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.FMSCO;

public class FMSSuspendedFacilityDetailsListAction extends GridBaseAction
{
  private DashFMSBO dashFMSBO;
  private String screenName= "";
  private FMSCO fmsCO = new FMSCO();
  private List<FMSCO> fmsCOList = new ArrayList<FMSCO>();
  private DashboardSC dashboardSC = new DashboardSC();

  public String showFMSSuspendedFacilityGrid()
  {
      try
      {
    	  SessionCO sessionCO = returnSessionObject();
    	  dashboardSC.setCompCode(sessionCO.getCompanyCode());
    	  dashboardSC.setBranchCode(sessionCO.getBranchCode());
    	  fmsCOList = dashFMSBO.getBlockedAndSuspendedFacilitiesCurrencyDetails(dashboardSC);
    	  
	   }
      catch(Exception ex)
      {
    	  log.error("Error in load showFMSSuspendedFacilityGrid Page");
	  handleException(ex, null, null);
      }
      return SUCCESS;
  }

  public String loadFMSSuspendedFacilityGrid()
	{
	      String[] searchCol = {};
	      try
		{
			SessionCO sessionCO = returnSessionObject();
		    dashboardSC.setCompCode(sessionCO.getCompanyCode());
		    dashboardSC.setBranchCode(sessionCO.getBranchCode());
		    dashboardSC.setLangCode(sessionCO.getLanguage());
		    dashboardSC.setLovType(new BigDecimal(193));
		    dashboardSC.setSearchCols(searchCol);

		    copyproperties(dashboardSC);
		    dashboardSC.setCompCode(returnSessionObject().getCompanyCode());
		    if(checkNbRec(dashboardSC))
		    {
				setRecords(dashFMSBO.getBlockedAndSuspendedFacilitiesListCount(dashboardSC));
		    }
		    fmsCOList = dashFMSBO.getBlockedAndSuspendedFacilitiesList(dashboardSC);
		    
		   BigDecimal sumOfValueAmt = BigDecimal.ZERO;
		   if(fmsCOList!=null && !fmsCOList.isEmpty())
		   {
			   for(FMSCO eachFacilityCO:fmsCOList)
			   {
				   BigDecimal value 	 = NumberUtil.nullToZero(eachFacilityCO.getFmsFacilityVO().getFACILITY_VALUE());
				   sumOfValueAmt = sumOfValueAmt.add(value);
			   }
		   }
		   setGridModel(fmsCOList);
		   
		   HashMap<String, Object> gridFooterMap = new HashMap<String, Object>();
		   gridFooterMap.put("currencyDesc", "Total");
		   gridFooterMap.put("fmsFacilityVO.FACILITY_VALUE", sumOfValueAmt);
		   setUserdata(gridFooterMap);
		}
		catch(Exception e)
		{
			log.error(e, "Error in FMS Suspended Facility List Grid");
			handleException(e, null, null);
		}
		return "json";
	}
  
  
@Override
public Object getModel()
	{
		return dashboardSC;
	}
public String getScreenName()
{
	return screenName;
}

public void setScreenName(String screenName)
{
	this.screenName = screenName;
}

public void setDashFMSBO(DashFMSBO dashFMSBO)
{
	this.dashFMSBO = dashFMSBO;
}

public DashboardSC getDashboardSC()
{
	return dashboardSC;
}

public void setDashboardSC(DashboardSC dashboardSC)
{
	this.dashboardSC = dashboardSC;
}

public FMSCO getFmsCO()
{
	return fmsCO;
}

public void setFmsCO(FMSCO fmsCO)
{
	this.fmsCO = fmsCO;
}

public List<FMSCO> getFmsCOList()
{
	return fmsCOList;
}

public void setFmsCOList(List<FMSCO> fmsCOList)
{
	this.fmsCOList = fmsCOList;
}


  
}
