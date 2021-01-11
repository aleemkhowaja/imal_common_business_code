package com.path.actions.common.global360view.fms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.global360view.fms.DashFMSBO;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.FMSCO;

public class FMSDrawdownDetailsListAction extends GridBaseAction
{
    private DashFMSBO dashFMSBO;
    private String screenName = "";
    private FMSCO fmsCO = new FMSCO();
    private List<FMSCO> fmsCOList = new ArrayList<FMSCO>();
    private DashboardSC dashboardSC = new DashboardSC();

    public String showFMSDrawdownDetailsGrid()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    dashboardSC.setCompCode(sessionCO.getCompanyCode());
	    dashboardSC.setBranchCode(sessionCO.getBranchCode());
	    fmsCOList = dashFMSBO.getDrawdownCurrencyDetails(dashboardSC);

	}
	catch(Exception ex)
	{
	    log.error("Error in load showFMSDrawdownDetailsGrid Page");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public String loadFMSDrawdownDetailsGrid()
    {
	String[] searchCol = {};
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    dashboardSC.setCompCode(sessionCO.getCompanyCode());
	    dashboardSC.setBranchCode(sessionCO.getBranchCode());
	    dashboardSC.setLangCode(sessionCO.getLanguage());
	    dashboardSC.setLovType(new BigDecimal(467));
	    dashboardSC.setAppForlovType(new BigDecimal(219));
	    dashboardSC.setSearchCols(searchCol);

	    copyproperties(dashboardSC);
	    dashboardSC.setCompCode(returnSessionObject().getCompanyCode());
	    if(checkNbRec(dashboardSC))
	    {
		setRecords(dashFMSBO.getDrawdownListCount(dashboardSC));
	    }
	    fmsCOList = dashFMSBO.getDrawdownList(dashboardSC);

	    BigDecimal sumOfFCAmt = BigDecimal.ZERO;
	    BigDecimal sumOfCVAmt = BigDecimal.ZERO;
	    if(fmsCOList != null && !fmsCOList.isEmpty())
	    {
		for(FMSCO eachCO : fmsCOList)
		{
		    BigDecimal curValue = NumberUtil.nullToZero(eachCO.getFmsDrwDwnVO().getVALUE());
		    BigDecimal curRate = NumberUtil.nullToZero(eachCO.getFmsDrwDwnVO().getCURRENCY_RATE());
		    BigDecimal curUnit = NumberUtil.nullToZero(eachCO.getFmsDrwDwnVO().getCURRENCY_UNIT());

		    if(sessionCO.getBaseCurrencyCode().compareTo(eachCO.getFmsDrwDwnVO().getCURRENCY()) == 0)
		    {
			curValue = curValue.setScale(sessionCO.getBaseCurrDecPoint().intValue(),
				BigDecimal.ROUND_HALF_UP);
			eachCO.setCvAmount(curValue);
		    }
		    else
		    {

			eachCO.setCvAmount(
				CommonMethods.multiplyDivideAmount(eachCO.getFmsDrwDwnVO().getCURRENCY_MULT_DIV(),
					curValue, curRate, curUnit, sessionCO.getBaseCurrDecPoint()));

		    }
		    sumOfFCAmt = sumOfFCAmt.add(NumberUtil.nullToZero(eachCO.getFmsDrwDwnVO().getVALUE()).abs());
		    sumOfCVAmt = sumOfCVAmt.add(curValue);

		    eachCO.setBaseCurrDecPoint(sessionCO.getBaseCurrDecPoint());
		}
	    }
	    setGridModel(fmsCOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in FMS Drawdown List Grid");
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
