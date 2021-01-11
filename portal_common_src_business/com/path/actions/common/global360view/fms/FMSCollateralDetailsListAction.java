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

public class FMSCollateralDetailsListAction extends GridBaseAction
{
    private DashFMSBO dashFMSBO;
    private String screenName = "";
    private FMSCO fmsCO = new FMSCO();
    private List<FMSCO> fmsCOList = new ArrayList<FMSCO>();
    private DashboardSC dashboardSC = new DashboardSC();

    public String showFMSCollateralsGrid()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    dashboardSC.setCompCode(sessionCO.getCompanyCode());
	    dashboardSC.setBranchCode(sessionCO.getBranchCode());
	    fmsCOList = dashFMSBO.getSecurityCurrencyDetails(dashboardSC);

	}
	catch(Exception ex)
	{
	    log.error("Error in load showFMSCollateralsGrid Page");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public String loadFMSCollateralGrid()
    {
	String[] searchCol = {};
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    dashboardSC.setCompCode(sessionCO.getCompanyCode());
	    dashboardSC.setBranchCode(sessionCO.getBranchCode());
	    dashboardSC.setLangCode(sessionCO.getLanguage());
	    dashboardSC.setLovType(new BigDecimal(195));
	    dashboardSC.setSearchCols(searchCol);

	    copyproperties(dashboardSC);
	    dashboardSC.setCompCode(returnSessionObject().getCompanyCode());
	    if(checkNbRec(dashboardSC))
	    {
		setRecords(dashFMSBO.getSecurityListCount(dashboardSC));
	    }
	    fmsCOList = dashFMSBO.getSecurityList(dashboardSC);

	    BigDecimal sumOfCalcAmt = BigDecimal.ZERO;
	    if(fmsCOList != null && !fmsCOList.isEmpty())
	    {
		for(FMSCO eachFacilityCO : fmsCOList)
		{
		    BigDecimal coverage = NumberUtil.nullToZero(eachFacilityCO.getFmsAppCollateralVO().getCOVERAGE());
		    BigDecimal accptValue = NumberUtil
			    .nullToZero(eachFacilityCO.getFmsCollateralVO().getACCEPT_VALUE());
		    BigDecimal calcAmount = coverage.multiply(accptValue);
		    calcAmount = calcAmount.divide(new BigDecimal(100));
		    eachFacilityCO.setCalcAmount(calcAmount);
		    sumOfCalcAmt = sumOfCalcAmt.add(calcAmount.abs());
		}
	    }
	    setGridModel(fmsCOList);

	    HashMap<String, Object> gridFooterMap = new HashMap<String, Object>();
	    // gridFooterMap.put("fmsCollateralVO.BRIEF_NAME_ENG",
	    // "Total Customers Pledged Deposits");
	    gridFooterMap.put("fmsCollateralVO.BRIEF_NAME_ENG", getText("Total_key"));
	    gridFooterMap.put("calcAmount", sumOfCalcAmt);
	    setUserdata(gridFooterMap);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in FMS Collateral List Grid");
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
