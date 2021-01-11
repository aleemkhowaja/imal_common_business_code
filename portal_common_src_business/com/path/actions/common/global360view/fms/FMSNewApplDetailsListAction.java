package com.path.actions.common.global360view.fms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.global360view.fms.DashFMSBO;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.FMSCO;

public class FMSNewApplDetailsListAction extends GridBaseAction
{
    private DashFMSBO dashFMSBO;
    private String screenName = "";
    private FMSCO fmsCO = new FMSCO();
    private List<FMSCO> fmsCOList = new ArrayList<FMSCO>();
    private DashboardSC dashboardSC = new DashboardSC();

    public String showFMSNewAppGrid()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    dashboardSC.setCompCode(sessionCO.getCompanyCode());
	    dashboardSC.setBranchCode(sessionCO.getBranchCode());
	    fmsCOList = dashFMSBO.getNewAppCurrencyDetails(dashboardSC);

	}
	catch(Exception ex)
	{
	    log.error("Error in load showFMSNewAppGrid Page");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public String loadFMSNewAppGrid()
    {
	String[] searchCol = {};
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    dashboardSC.setCompCode(sessionCO.getCompanyCode());
	    dashboardSC.setBranchCode(sessionCO.getBranchCode());
	    dashboardSC.setLangCode(sessionCO.getLanguage());
	    dashboardSC.setLovType(new BigDecimal(229));// Application Facility Status
	    dashboardSC.setAppForlovType(new BigDecimal(219));// Application For
	    dashboardSC.setSearchCols(searchCol);

	    copyproperties(dashboardSC);
	    dashboardSC.setCompCode(returnSessionObject().getCompanyCode());
	    if(checkNbRec(dashboardSC))
	    {
		setRecords(dashFMSBO.getNewAppListCount(dashboardSC));
	    }
	    fmsCOList = dashFMSBO.getNewAppList(dashboardSC);

	    BigDecimal sumOfFCAmt = BigDecimal.ZERO;
	    BigDecimal sumOfCVAmt = BigDecimal.ZERO;
	    if(fmsCOList != null && !fmsCOList.isEmpty())
	    {
		for(FMSCO eachCO : fmsCOList)
		{
		    BigDecimal curValue = NumberUtil.nullToZero(eachCO.getFmsApplVO().getVALUE());
		    BigDecimal curRate = NumberUtil.nullToZero(eachCO.getFmsApplVO().getCURRENCY_RATE());
		    BigDecimal curUnit = NumberUtil.nullToZero(eachCO.getFmsApplVO().getCURRENCY_UNIT());

		    if(sessionCO.getBaseCurrencyCode().compareTo(eachCO.getFmsApplVO().getCURRENCY()) == 0)
		    {
			curValue = curValue.setScale(sessionCO.getBaseCurrDecPoint().intValue(),BigDecimal.ROUND_HALF_UP);// added to prevent rounding issue - 0091538: CY CONVERSION SHOWS WRONG VALUE AND DECIMAL PLACES
			eachCO.setCvAmount(curValue);
		    }
		    else
		    {
				       
			eachCO.setCvAmount(CommonMethods.multiplyDivideAmount(eachCO.getFmsApplVO()
				.getCURRENCY_MULT_DIV(), curValue, curRate, curUnit, sessionCO.getBaseCurrDecPoint()));
					
		    }
		    sumOfFCAmt = sumOfFCAmt.add(NumberUtil.nullToZero(eachCO.getFmsApplVO().getVALUE()).abs());
		    sumOfCVAmt = sumOfCVAmt.add(curValue);

		    eachCO.setBaseCurrDecPoint(sessionCO.getBaseCurrDecPoint());
		}
	    }
	    setGridModel(fmsCOList);

	    HashMap<String, Object> gridFooterMap = new HashMap<String, Object>();
	    gridFooterMap.put("currencyDesc", "Total");
	    gridFooterMap.put("fmsApplVO.VALUE", sumOfFCAmt);
	    gridFooterMap.put("cvAmount", sumOfCVAmt);
	    setUserdata(gridFooterMap);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in FMS New App List Grid");
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
