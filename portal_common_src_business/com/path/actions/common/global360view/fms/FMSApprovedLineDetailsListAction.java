package com.path.actions.common.global360view.fms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.path.bo.common.global360view.fms.DashFMSBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.FMSCO;

public class FMSApprovedLineDetailsListAction extends GridBaseAction
{
    private DashFMSBO dashFMSBO;
    private String screenName = "";
    private FMSCO fmsCO = new FMSCO();
    private List<FMSCO> fmsCOList = new ArrayList<FMSCO>();
    private DashboardSC dashboardSC = new DashboardSC();

    public String showFMSApprovedLinesData()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    dashboardSC.setCompCode(sessionCO.getCompanyCode());
	    dashboardSC.setBranchCode(sessionCO.getBranchCode());
	    fmsCOList = dashFMSBO.getLiabilitiesApprovedLinesCurrencyDetails(dashboardSC);

	}
	catch(Exception ex)
	{
	    log.error("Error in load showFMSApprovedLinesData Page");
	    handleException(ex, null, null);
	}
	return "approvedLinesCurrencyPage";
    }

    public String showFMSApprovedLinesDetailData()
    {
	return "approvedLinesDetailPage";
    }

    public String loadFMSApprovedLinesGrid()
    {
	String[] searchCol = {};
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    dashboardSC.setCompCode(sessionCO.getCompanyCode());
	    dashboardSC.setBranchCode(sessionCO.getBranchCode());
	    dashboardSC.setSearchCols(searchCol);

	    copyproperties(dashboardSC);
	    dashboardSC.setCompCode(returnSessionObject().getCompanyCode());
	    fmsCOList = dashFMSBO.getLiabilitiesApprovedLinesList(dashboardSC);

	    // BigDecimal sumOfCalcAmt = BigDecimal.ZERO;
	    if(fmsCOList != null && !fmsCOList.isEmpty())
	    {
		Collections.sort(fmsCOList, new Comparator<FMSCO>()
		{
		    @Override
		    public int compare(FMSCO o1, FMSCO o2)
		    {
			return o1.getFmsFacilityVO().getCODE().compareTo(o2.getFmsFacilityVO().getCODE());
		    }
		});
		for(FMSCO eachFacilityCO : fmsCOList)
		{
		    //
		    BigDecimal facilityValue = NumberUtil.nullToZero(eachFacilityCO.getFmsFacilityVO()
			    .getFACILITY_VALUE());
		    BigDecimal utilizedAmt = NumberUtil.nullToZero(eachFacilityCO.getUTILIZED_AMOUNT());
		    BigDecimal unUtilizedAmt = facilityValue.subtract(utilizedAmt);
		    eachFacilityCO.setUNUTILIZED_AMOUNT(unUtilizedAmt);

		    String revolve = StringUtil.nullToEmpty(eachFacilityCO.getFmsFacilityVO().getREVOLVING_ONEOFF());
		    // eachFacilityCO.setRevolveOnOff("R".equalsIgnoreCase(revolve)?"Revolving":"One Off");
		    eachFacilityCO.setRevolveOnOff("R".equalsIgnoreCase(revolve) ? getText("Revolving_key")
			    : getText("One_Off_key"));
		    eachFacilityCO.setCurrencyDesc(dashboardSC.getCurName());
		    // BigDecimal coverage =
		    // NumberUtil.nullToZero(eachFacilityCO.getFmsAppCollateralVO().getCOVERAGE());
		    // BigDecimal accptValue =
		    // NumberUtil.nullToZero(eachFacilityCO.getFmsCollateralVO().getACCEPT_VALUE());
		    // BigDecimal calcAmount = coverage.multiply(accptValue);
		    // calcAmount = calcAmount.divide(new BigDecimal(100));
		    // eachFacilityCO.setCalcAmount(calcAmount);
		    // sumOfCalcAmt = sumOfCalcAmt.add(calcAmount.abs());
		}
	    }
	    setGridModel(fmsCOList);
	    //
	    // HashMap<String, Object> gridFooterMap = new HashMap<String,
	    // Object>();
	    // gridFooterMap.put("fmsCollateralVO.BRIEF_NAME_ENG",
	    // "Total Customers Pledged Deposits");
	    // gridFooterMap.put("calcAmount", sumOfCalcAmt);
	    // setUserdata(gridFooterMap);
	    //
	}
	catch(Exception e)
	{
	    log.error(e, "Error in FMS ApprovedLines List Grid");
	    handleException(e, null, null);
	}
	return "json";
    }

    @SuppressWarnings("unchecked")
    public String loadFMSApprovedLinesDetailGrid()
    {
	String[] searchCol = {};
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    dashboardSC.setCompCode(sessionCO.getCompanyCode());
	    dashboardSC.setLangCode(sessionCO.getLanguage());
	    dashboardSC.setLovType(new BigDecimal(218));
	    dashboardSC.setSearchCols(searchCol);

	    copyproperties(dashboardSC);
	    fmsCOList = dashFMSBO.getLiabilitiesApprovedLinesDetailedList(dashboardSC);
	    if(fmsCOList != null && !fmsCOList.isEmpty())
	    {
		Collections.sort(fmsCOList, new Comparator<FMSCO>()
		{
		    @Override
		    public int compare(FMSCO o1, FMSCO o2)
		    {
			return o1.getFmsFacilityDetVO().getLINE_NBR().compareTo(o2.getFmsFacilityDetVO().getLINE_NBR());
		    }

		});
		for(FMSCO eachCO : fmsCOList)
		{
		    eachCO.setCurDecimalPoints(fmsCO.getCurDecimalPoints());
		    if(eachCO.getFmsFacilityDetVO().getCLASS().compareTo(BigDecimal.ZERO) == -1)
		    {
			eachCO.getFmsFacilityDetVO().setCLASS(null);
		    }
		    BigDecimal facilityValue = NumberUtil.nullToZero(eachCO.getFmsFacilityDetVO().getFACILITY_VALUE());
		    BigDecimal utilizedAmt = NumberUtil.nullToZero(eachCO.getUTILIZED_AMOUNT());
		    BigDecimal unUtilizedAmt = facilityValue.subtract(utilizedAmt);
		    eachCO.setUNUTILIZED_AMOUNT(unUtilizedAmt);
		    eachCO.setCurrencyDesc(dashboardSC.getCurName());
		}
	    }

	    setGridModel(fmsCOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in FMS ApprovedLinesDetail List Grid");
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
