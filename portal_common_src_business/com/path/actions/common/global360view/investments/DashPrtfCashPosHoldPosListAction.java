/**
 * 
 */
package com.path.actions.common.global360view.investments;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.investments.DashInvestmentsBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashPrtfCashPosHoldPosCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: marwanmaddah
 * 
 *          DashPrtfCashPosHoldPosListAction.java used to
 */
public class DashPrtfCashPosHoldPosListAction extends GridBaseAction
{
    private DashboardSC criteria = new DashboardSC();
    private DashPrtfCashPosHoldPosCO dashPrtfCashPosHoldPosCO = new DashPrtfCashPosHoldPosCO();
    private DashInvestmentsBO dashInvestmentsBO;
    private List<SelectCO> holdingBySecurityList = new ArrayList<SelectCO>();

    private String allSecuritiesChartList;
    private String prtflPosSummaryList;
    private String ondblclickCashPosition;
    private String ondblclickHoldingPosition;

    /**
   * 
   */
    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * load the page
     * 
     * @return String
     */
    public String loadDashPrtfCashPosHoldPosPage()
    {
	try
	{
	    
	    
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    
	    if(ConstantsCommon.ASSETS_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		criteria.setAsOfDate(DateUtil.parseDate(criteria.getAsOfDateStr(), "dd/MM/yyyy"));
	    }
	    else
	    {
		criteria.setAsOfDate(sessionCO.getRunningDateRET());
		criteria.setAsOfDateStr(DateUtil.format(sessionCO.getRunningDateRET(), "dd/MM/yyyy"));
	    }
	    
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setLangCode(sessionCO.getLanguage());
	    if(ConstantsCommon.ASSETS_QUERY_POS_CALL_SOURCE.equalsIgnoreCase(criteria.getCallSource()))
	    {
		ondblclickCashPosition = "queryPosition_CashPosition_onDbClickedEvent()";
		ondblclickHoldingPosition = "queryPosition_HoldingPosition_onDbClickedEvent()";
	    }
	    else
	    {
		ondblclickCashPosition = "";
		ondblclickHoldingPosition = "";
	    }

	    if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(criteria.getLoginTypeByBr()))
	    {
		criteria.setBranchCode(sessionCO.getBranchCode());
	    }
	    BigDecimal decPoints = NumberUtil.emptyDecimalToZero(sessionCO.getBaseCurrDecPoint());

	    dashPrtfCashPosHoldPosCO = dashInvestmentsBO.returnPortfolioCashHoldingData(criteria);
	    BigDecimal totalAssets = BigDecimal.ZERO, totalRealizedGainLoss = BigDecimal.ZERO, totalUnrealizedGainLoss = BigDecimal.ZERO, unrealizedCyGainLoss = BigDecimal.ZERO;
	    if(dashPrtfCashPosHoldPosCO == null)
	    {
		dashPrtfCashPosHoldPosCO = new DashPrtfCashPosHoldPosCO();
	    }
	    else
	    {
		totalAssets = NumberUtil.nullToZero(dashPrtfCashPosHoldPosCO.getTotalAssets());
		totalRealizedGainLoss = NumberUtil.nullToZero(dashPrtfCashPosHoldPosCO.getTotalRealizedGainLoss());
		totalUnrealizedGainLoss = NumberUtil.nullToZero(dashPrtfCashPosHoldPosCO.getTotalUnrealizedGainLoss());
		unrealizedCyGainLoss = NumberUtil.nullToZero(dashPrtfCashPosHoldPosCO.getUnrealizedCyGainLoss());
	    }
	    dashPrtfCashPosHoldPosCO.setTotalAssetsFrmtd((totalAssets.compareTo(BigDecimal.ZERO) == -1) ? CommonMethods
		    .formatCurrency(totalAssets.abs(), decPoints)
		    + " " + getText("cr_suffix_key") : CommonMethods.formatCurrency(totalAssets, decPoints) + " "
		    + getText("dr_suffix_key"));
	    dashPrtfCashPosHoldPosCO
		    .setTotalRealizedGainLossFrmtd((totalRealizedGainLoss.compareTo(BigDecimal.ZERO) == -1) ? CommonMethods
			    .formatCurrency(totalRealizedGainLoss.abs(), decPoints)
			    + " " + getText("cr_suffix_key")
			    : CommonMethods.formatCurrency(totalRealizedGainLoss, decPoints) + " "
				    + getText("dr_suffix_key"));
	    dashPrtfCashPosHoldPosCO.setTotalUnrealizedGainLossFrmtd((totalUnrealizedGainLoss
		    .compareTo(BigDecimal.ZERO) == -1) ? CommonMethods.formatCurrency(totalUnrealizedGainLoss.abs(),
		    decPoints)
		    + " " + getText("cr_suffix_key") : CommonMethods.formatCurrency(totalUnrealizedGainLoss, decPoints)
		    + " " + getText("dr_suffix_key"));
	    dashPrtfCashPosHoldPosCO
		    .setUnrealizedCyGainLossFrmtd((unrealizedCyGainLoss.compareTo(BigDecimal.ZERO) == -1) ? CommonMethods
			    .formatCurrency(unrealizedCyGainLoss.abs(), decPoints)
			    + " " + getText("cr_suffix_key")
			    : CommonMethods.formatCurrency(unrealizedCyGainLoss, decPoints) + " "
				    + getText("dr_suffix_key"));
	    chartsComboMgnt();
	    /**
	     * charts management on load...
	     */
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * Charts Combo managements
     * 
     * @author marwanmaddah
     * @date Jul 17, 2013
     * 
     */
    public void chartsComboMgnt() throws BaseException
    {
	dashPrtfCashPosHoldPosCO.setSecurityName(getText("All_Securities_key"));
	allSecuritiesChart();
	prtflPosSummaryChart();
	loadDashPrtfPosGraph();
	loadDashSummaryPositionGraph();

	SelectSC selectSC = new SelectSC(ConstantsCommon.PORTFOLIO_POSITION_SUMMARY_LOV_TYPE);
	holdingBySecurityList = returnLOV(selectSC);

    }

    /**
     * 
     * @author marwanmaddah
     * @date Jul 17, 2013
     * @throws BaseException void
     * 
     */
    public void allSecuritiesChart() throws BaseException
    {
	Date asOfDate = DateUtil.parseDate(criteria.getAsOfDateStr(), "dd/MM/yyyy"); 
	
	Long day = DateUtil.getDatePart("DD", asOfDate) - 1;
	Date fromDate = DateUtil.dateAdd("dd", -day, asOfDate);
	
	criteria.setFromDate(fromDate);
	criteria.setAsOfDate(asOfDate);
	List allSecurities = dashInvestmentsBO.allSecuritiesChart(criteria);
	allSecuritiesChartList = CommonMethods.convertListToJSONString(allSecurities);
    }

    /**
     * 
     * @author marwanmaddah
     * @date Jul 17, 2013
     * @throws BaseException void
     * 
     */
    public void prtflPosSummaryChart() throws BaseException
    {
	Date asOfDate = DateUtil.parseDate(criteria.getAsOfDateStr(), "dd/MM/yyyy"); 
	criteria.setAsOfDate(asOfDate);
	
	List prtflPosSummary = dashInvestmentsBO.prtflPosSummaryChart(criteria);
	prtflPosSummaryList = CommonMethods.convertListToJSONString(prtflPosSummary);
    }

    /**
     * Cash position Grid Data ...
     * 
     * @author marwanmaddah
     * @date Jul 12, 2013
     * @return
     * 
     */
    public String loadCashPositionGridData()
    {
	String[] searchCol = { "account_type", "currency", "value_trade_cy", "value_base_cy" };

	try
	{
	    Date asOfDate = DateUtil.parseDate(criteria.getAsOfDateStr(), "dd/MM/yyyy");
	    
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);

	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setIvCrud(getIv_crud());
	    criteria.setProgRef(get_pageRef());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    //criteria.setRunningDate(sessionCO.getRunningDateRET());
	    criteria.setAsOfDate(asOfDate);
	    criteria.setUserId(sessionCO.getUserName());

	    if(checkNbRec(criteria))
	    {
		setRecords(dashInvestmentsBO.cashPositionListCount(criteria));
	    }
	    setGridModel(dashInvestmentsBO.cashPositionList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Safeboxes List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * holding position grid Data
     * 
     * @author marwanmaddah
     * @date Jul 12, 2013
     * @return
     * 
     */
    public String loadHoldingPositionGridData()
    {
	String[] searchCol = { "security_type", "cyDesc", "book_value", "market_value", "market_value_base_cy" };

	try
	{

	    Date asOfDate = DateUtil.parseDate(criteria.getAsOfDateStr(), "dd/MM/yyyy");
	    
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);

	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setIvCrud(getIv_crud());
	    criteria.setProgRef(get_pageRef());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    //criteria.setRunningDate(sessionCO.getRunningDateRET());
	    criteria.setAsOfDate(asOfDate);
	    criteria.setUserId(sessionCO.getUserName());

	    if(checkNbRec(criteria))
	    {
		setRecords(dashInvestmentsBO.holdingPositionListCount(criteria));
	    }
	    setGridModel(dashInvestmentsBO.holdingPositionList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Safeboxes List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public String loadDashPrtfPosGraph() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();

	criteria.setCompCode(sessionCO.getCompanyCode());
	criteria.setRunningDate(sessionCO.getRunningDateRET());
	criteria.setUserId(sessionCO.getUserName());

	List prtflPosSummary = dashInvestmentsBO.prtflPosSummaryChart(criteria);
	setPrtflPosSummaryList(CommonMethods.convertListToJSONString(prtflPosSummary));
	return SUCCESS;
    }

    public void loadDashSummaryPositionGraph() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();

	criteria.setCompCode(sessionCO.getCompanyCode());
	criteria.setRunningDate(sessionCO.getRunningDateRET());
	criteria.setUserId(sessionCO.getUserName());
	criteria.setFromDate(DateUtil.getMonthFirstDay(sessionCO.getRunningDateRET()));

	List allSecurities = dashInvestmentsBO.allSecuritiesChart(criteria);
	allSecuritiesChartList = CommonMethods.convertListToJSONString(allSecurities);
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
     * @return the dashPrtfCashPosHoldPosCO
     */
    public DashPrtfCashPosHoldPosCO getDashPrtfCashPosHoldPosCO()
    {
	return dashPrtfCashPosHoldPosCO;
    }

    /**
     * @param dashPrtfCashPosHoldPosCO the dashPrtfCashPosHoldPosCO to set
     */
    public void setDashPrtfCashPosHoldPosCO(DashPrtfCashPosHoldPosCO dashPrtfCashPosHoldPosCO)
    {
	this.dashPrtfCashPosHoldPosCO = dashPrtfCashPosHoldPosCO;
    }

    /**
     * @param dashInvestmentsBO the dashInvestmentsBO to set
     */
    public void setDashInvestmentsBO(DashInvestmentsBO dashInvestmentsBO)
    {
	this.dashInvestmentsBO = dashInvestmentsBO;
    }

    /**
     * @return the holdingBySecurityList
     */
    public List getHoldingBySecurityList()
    {
	return holdingBySecurityList;
    }

    /**
     * @param holdingBySecurityList the holdingBySecurityList to set
     */
    public void setHoldingBySecurityList(List holdingBySecurityList)
    {
	this.holdingBySecurityList = holdingBySecurityList;
    }

    /**
     * @return the allSecuritiesChartList
     */
    public String getAllSecuritiesChartList()
    {
	return allSecuritiesChartList;
    }

    /**
     * @param allSecuritiesChartList the allSecuritiesChartList to set
     */
    public void setAllSecuritiesChartList(String allSecuritiesChartList)
    {
	this.allSecuritiesChartList = allSecuritiesChartList;
    }

    /**
     * @return the prtflPosSummaryList
     */
    public String getPrtflPosSummaryList()
    {
	return prtflPosSummaryList;
    }

    /**
     * @param prtflPosSummaryList the prtflPosSummaryList to set
     */
    public void setPrtflPosSummaryList(String prtflPosSummaryList)
    {
	this.prtflPosSummaryList = prtflPosSummaryList;
    }

    /**
     * @return the ondblclickCashPosition
     */
    public String getOndblclickCashPosition()
    {
	return ondblclickCashPosition;
    }

    /**
     * @param ondblclickCashPosition the ondblclickCashPosition to set
     */
    public void setOndblclickCashPosition(String ondblclickCashPosition)
    {
	this.ondblclickCashPosition = ondblclickCashPosition;
    }

    /**
     * @return the ondblclickHoldingPosition
     */
    public String getOndblclickHoldingPosition()
    {
	return ondblclickHoldingPosition;
    }

    /**
     * @param ondblclickHoldingPosition the ondblclickHoldingPosition to set
     */
    public void setOndblclickHoldingPosition(String ondblclickHoldingPosition)
    {
	this.ondblclickHoldingPosition = ondblclickHoldingPosition;
    }
}
