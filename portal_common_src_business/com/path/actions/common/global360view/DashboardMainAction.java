/**
 * 
 */
package com.path.actions.common.global360view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.actions.common.global360view.financingDeals.FinancingDealsConstants;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.DashboardBO;
import com.path.dbmaps.vo.AMFSUPPLEMENTVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.AssetsAndLiabCO;
import com.path.vo.common.global360view.DashboardCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.FinAppAndApprovedLinesCO;
import com.path.vo.common.global360view.FinancingDealsCO;
import com.path.vo.common.global360view.InvestAndTreasuryCO;
import com.path.vo.common.global360view.TradeFinanceCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: marwanmaddah
 * 
 *          DashboardMainAction.java used to
 */
public class DashboardMainAction extends BaseAction
{
    private DashboardBO dashboardBO;
    private DashboardCO dashboardCO = new DashboardCO();
    private List<SelectCO> loginBrTypeList = new ArrayList<SelectCO>();
    private DashboardSC dashboardSC = new DashboardSC();
    private Map<String, String> kycDropDown;
    private String assetsValues, liabilityValues, categValues, nbAccountAssets, nbAccountLiabl,
	    accBalanceChartLiableList, accBalanceChartAssetList, finAppList;

    /**
     * 
     * @author marwanmaddah
     * @date Apr 18, 2013
     * @return String
     * 
     */
    public String loadDashboardPage()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    //806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen
	    loadKYCDropDown();
	    fillLoginTypeCmb();
	    dashboardCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    dashboardCO.setBaseCurrencyName(sessionCO.getBaseCurrencyName());
	    dashboardCO.setAppName(sessionCO.getCurrentAppName());
	    dashboardCO.setCurrencyMsg(getText("currency_dashboard_key"));
	    cardReaderVisibility(sessionCO.getCompanyCode(),sessionCO.getBranchCode());
	    
	    //Rania - FIBSI190047
	    set_enableAudit(true);
	    set_showSmartInfoBtn("false");
	    set_showRecordLogsBtn("false");
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * check the access right based on userId, compCode, branch code and OPT
     * 
     * @author marwanmaddah
     * @date Jul 2, 2013
     * @throws BaseException void
     * 
     */
    private void checkUserAccessRight() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	CommonLibSC commonLibSC = new CommonLibSC();
	List<String> privilegesToCheck = new ArrayList<String>();
	privilegesToCheck.add(ConstantsCommon.DASH_TOTAL_ASS_LIAB_OPT);
	privilegesToCheck.add(ConstantsCommon.DASH_FIN_APP_APR_LINE_OPT);
	privilegesToCheck.add(ConstantsCommon.DASH_CUSTOMER_GARDING_OPT);
	privilegesToCheck.add(ConstantsCommon.DASH_FINANCING_DEALS_OPT);
	privilegesToCheck.add(ConstantsCommon.DASH_INVESTMENTS_OPT);
	privilegesToCheck.add(ConstantsCommon.DASH_PRODUCTS_OPT);
	privilegesToCheck.add(ConstantsCommon.DASH_OTHER_OPT);
	privilegesToCheck.add(ConstantsCommon.DASH_TREASURY_OPT);
	privilegesToCheck.add(ConstantsCommon.DASH_CHEQUES_OPT);

	commonLibSC.setPrivilegesToCheck(privilegesToCheck);
	commonLibSC.setCompCode(sessionCO.getCompanyCode());
	commonLibSC.setBranchCode(sessionCO.getBranchCode());
	commonLibSC.setUserId(sessionCO.getUserName());
	commonLibSC.setAppName(sessionCO.getCurrentAppName());

	List<String> accessResult = returnCommonLibBO().checkAccessPrivilegeForUser(commonLibSC);

	if(accessResult.contains(ConstantsCommon.DASH_TOTAL_ASS_LIAB_OPT))
	{
	    dashboardCO.setTotalAssLiabOpt("true");
	}
	if(accessResult.contains(ConstantsCommon.DASH_FIN_APP_APR_LINE_OPT))
	{
	    dashboardCO.setFinAppAprLineOpt("true");
	}
	if(accessResult.contains(ConstantsCommon.DASH_CUSTOMER_GARDING_OPT))
	{
	    dashboardCO.setCustomerGardingOpt("true");
	}
	if(accessResult.contains(ConstantsCommon.DASH_FINANCING_DEALS_OPT))
	{
	    dashboardCO.setFinancingDealsOpt("true");
	}
	if(accessResult.contains(ConstantsCommon.DASH_INVESTMENTS_OPT))
	{
	    dashboardCO.setInvestmentsOpt("true");
	}
	if(accessResult.contains(ConstantsCommon.DASH_PRODUCTS_OPT))
	{
	    dashboardCO.setProductsOpt("true");
	}
	if(accessResult.contains(ConstantsCommon.DASH_OTHER_OPT))
	{
	    dashboardCO.setOtherOpt("true");
	}
	if(accessResult.contains(ConstantsCommon.DASH_TREASURY_OPT))
	{
	    dashboardCO.setTreasuryOpt("true");
	}
	if(accessResult.contains(ConstantsCommon.DASH_CHEQUES_OPT))
	{
	    dashboardCO.setChequesOpt("true");
	}

	// [John Massaad]-- IN CASE 360 degree opened From another application
	// then CSM The USER_ID of the Login application may not have a
	// TELLER_CODE
	if(ConstantsCommon.RET_APP_NAME.equals(dashboardSC.getAppName()))
	{
	    // John Massaad -- PATH130194 - Hide Show accounts under the 360
	    // degree view
	    dashboardCO.setLoginCompCode(sessionCO.getCompanyCode());
	    dashboardCO.setLoginBraCode(sessionCO.getBranchCode());
	    dashboardCO.setLoginTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    dashboardCO = dashboardBO.returnHiddenAccStatusesCount(dashboardCO);
	    // John Massaad -- PATH130194 - Hide Show accounts under the 360
	    // degree view
	}

    }

    /**
     * to load the main data without the header.
     * 
     * @author marwanmaddah
     * @date Apr 23, 2013
     * @return String
     * 
     */
    public String loadMainData()
    {
	try
	{
	    ArrayList<BigDecimal> assetsValuesList = new ArrayList<BigDecimal>();
	    ArrayList<BigDecimal> liablValuesList = new ArrayList<BigDecimal>();
	    ArrayList<String> categValuesList = new ArrayList<String>();
	    BigDecimal BalSignNumber = BigDecimal.valueOf(-1);
	    SessionCO sessionCO = returnSessionObject();
	    dashboardSC.setCompCode(sessionCO.getCompanyCode());
	    if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(dashboardSC.getLoginTypeByBr()))
	    {
		dashboardSC.setBranchCode(sessionCO.getBranchCode());
	    }
	    dashboardSC.setUserId(sessionCO.getUserName());
	    dashboardSC.setRunningDate(sessionCO.getRunningDateRET());
	    dashboardSC.setAppName(sessionCO.getCurrentAppName());
	    dashboardSC.setProgRef(ConstantsCommon.INVESTMENT_QUERY_REF);
	    dashboardSC.setLanguage(sessionCO.getPreferredLanguage());
	    // PATH130194 here we are filling the accBr always with login branch
	    // (in the 2 cases: DASH_LOGIN_BRANCH = 1 or DASH_LOGIN_BRANCH = 2)
	    dashboardSC.setAccBr(sessionCO.getBranchCode());
	    // PATH130194
	    dashboardCO = dashboardBO.returnMainData(dashboardSC);
	    /**
	     * get application management
	     */
	    S_APPVO sappVO = new S_APPVO();
	    sappVO.setAPP_NAME(ConstantsCommon.FMS_APP_NAME);
	    sappVO = returnCommonLibBO().returnApplication(sappVO);

	    /*
	     * The values of the grid are set in the assetsCO and liabilityCO ,
	     * then the graph construct the list reading from these COs
	     */
	    AssetsAndLiabCO liabilityCO = new AssetsAndLiabCO();
	    /*BB180158 - incorrect mapping of account numbers in gridview*/
	    /*The Data is inversed of Assets and Liabilities in grid view*/
	    liabilityCO.setCategory(getText("liabilities_key"));
	    liabilityCO.setDecimal_points(returnDecimalFromBaseCurrency());
	    /**
	     * assets and liabilities grid data ...
	     */
	    AssetsAndLiabCO assetsCO = new AssetsAndLiabCO();
	    assetsCO.setCategory(getText("assets_key"));
	    assetsCO.setDecimal_points(returnDecimalFromBaseCurrency());
	    /**
	    * 	   
	    */
	    FinAppAndApprovedLinesCO finAppAndApprovedLinesCO = new FinAppAndApprovedLinesCO();
	    finAppAndApprovedLinesCO.setDecimal_points(returnDecimalFromBaseCurrency());

	    /**
	     * Elie Achkar TFA data
	     */
	    TradeFinanceCO tradeFinanceCO = new TradeFinanceCO();
	    tradeFinanceCO.setDecimal_points(returnDecimalFromBaseCurrency());
	    
	    // DBU190980 START Assets and Liabilities data shows in reverse
	    FinancingDealsCO assetsFinDeals = new FinancingDealsCO();
	    assetsFinDeals.setCategory(getText("liabilities_key"));
	    assetsFinDeals.setDecimalPoints(returnDecimalFromBaseCurrency());
	    assetsFinDeals.setCategoryId(FinancingDealsConstants.ASSET_CATEGORY);

	    FinancingDealsCO liabFinDeals = new FinancingDealsCO();
	    liabFinDeals.setCategory(getText("assets_key"));
	    liabFinDeals.setDecimalPoints(returnDecimalFromBaseCurrency());
	    liabFinDeals.setCategoryId(FinancingDealsConstants.LIABILITY_CATEGORY);

	    FinancingDealsCO indirectLiabFinDeals = new FinancingDealsCO();
	    indirectLiabFinDeals.setCategory(getText("indirect_assets_key"));
	    indirectLiabFinDeals.setDecimalPoints(returnDecimalFromBaseCurrency());
	    indirectLiabFinDeals.setCategoryId(FinancingDealsConstants.INDIRECT_LIABILITY_CATEGORY);
	    // DBU190980 END Assets and Liabilities data shows in reverse

	    FinancingDealsCO limitsFinDeals = new FinancingDealsCO();
	    limitsFinDeals.setCategory(getText("limits_key"));
	    limitsFinDeals.setDecimalPoints(returnDecimalFromBaseCurrency());
	    limitsFinDeals.setCategoryId(FinancingDealsConstants.LIMIT_UTILIZATION_CATEGORY);

	    InvestAndTreasuryCO investAndTreasury = new InvestAndTreasuryCO();
	    investAndTreasury.setDecimal_points(returnDecimalFromBaseCurrency());
	    /**
	    * 
	    */

	    if(dashboardCO == null)
	    {
		dashboardCO = new DashboardCO();
	    }
	    else
	    {

		assetsCO.setTotalNbrAcc(dashboardCO.getAmfAssetNbr());
		assetsCO.setCategoryId(BigDecimal.ONE);/*DBU190941 - Reverting DBU190856 since the issue was in the naming of assets and liabilities*/
		//assetsCO.setCategoryId(BigDecimal.ZERO);/*DBU190856*/
		assetsCO.setCurrentBalance(NumberUtil.nullToZero(dashboardCO.getCurBalAssetAmt()));
		assetsCO.setAvailableBalance(NumberUtil.nullToZero(dashboardCO.getAvailBalAssetAmt()));
		// assetsCO.setBlockedAmount(NumberUtil.nullToZero(dashboardCO.getBlockedBalAssetAmt()));
		// assetsCO.setOverdrawLimit(NumberUtil.nullToZero(dashboardCO.getOverdrawAssetAmt().add(dashboardCO.getOverdrawLiabAmt())));/*Adding
		// the Liab to the assets since it must be shown under assets
		// and not according to the type as requested by QC
		// AGIBI150326*/
		// assetsCO.setDuesAssetLiablAmt(NumberUtil.nullToZero(dashboardCO.getDuesAssetAmt()));/*Dues
		// to be shown only for assets*/

		/*
		 * Setting the liability values in the assets ones for the graph
		 * as requested
		 */
		/* Commented as requested by QC AGIBI150326 */

		/*
		 * assetsCO.setTotalNbrAcc(dashboardCO.getAmfLiabNbr());
		 * assetsCO.setCategoryId(BigDecimal.ZERO);
		 * assetsCO.setCurrentBalance(NumberUtil.nullToZero(dashboardCO.
		 * getCurBalLiabAmt()));
		 * assetsCO.setAvailableBalance(NumberUtil.nullToZero(
		 * dashboardCO.getAvailBalLiabAmt()));
		 * assetsCO.setBlockedAmount(NumberUtil.nullToZero(dashboardCO.
		 * getBlockedBalLiabAmt()));
		 * assetsCO.setOverdrawLimit(NumberUtil.nullToZero(dashboardCO.
		 * getOverdrawLiabAmt()));
		 * assetsCO.setDuesAssetLiablAmt(NumberUtil.nullToZero(
		 * dashboardCO.getDuesLiabAmt()));
		 */

		liabilityCO.setTotalNbrAcc(dashboardCO.getAmfLiabNbr());
		liabilityCO.setCategoryId(BigDecimal.ZERO); assetsCO.setCategoryId(BigDecimal.ONE);/*DBU190941 - Reverting DBU190856 since the issue was in the naming of assets and liabilities*/
		//liabilityCO.setCategoryId(BigDecimal.ONE);/*DBU190856*/
		liabilityCO.setCurrentBalance(NumberUtil.nullToZero(dashboardCO.getCurBalLiabAmt()));
		liabilityCO.setAvailableBalance(NumberUtil.nullToZero(dashboardCO.getAvailBalLiabAmt()));
		liabilityCO.setBlockedAmount(NumberUtil.nullToZero(dashboardCO.getBlockedBalLiabAmt())/*.multiply(
			BalSignNumber)*/); /*DBU190794*/ /* So it will be CR sign in the grid */
		liabilityCO.setOverdrawLimit(dashboardCO.getOverdrawLiabAmt());
		liabilityCO.setDuesAssetLiablAmt(NumberUtil.nullToZero(dashboardCO.getDuesLiabAmt()));

		/*
		 * Setting the assets values in the liabilities ones for the
		 * graph as requested
		 */
		/* Commented as requested by QC AGIBI150326 */
		/*
		 * liabilityCO.setTotalNbrAcc(dashboardCO.getAmfAssetNbr());
		 * liabilityCO.setCategoryId(BigDecimal.ONE);
		 * liabilityCO.setCurrentBalance(NumberUtil.nullToZero(
		 * dashboardCO.getCurBalAssetAmt()));
		 * liabilityCO.setAvailableBalance(NumberUtil.nullToZero(
		 * dashboardCO.getAvailBalAssetAmt()));
		 * liabilityCO.setBlockedAmount(NumberUtil.nullToZero(
		 * dashboardCO.getBlockedBalAssetAmt()));
		 */

		/**
		 * Elie Achkar TFA data
		 */
		tradeFinanceCO.setInOutLC(NumberUtil.nullToZero(dashboardCO.getLcAmt()));
		tradeFinanceCO.setLgs(NumberUtil.nullToZero(dashboardCO.getLgAmt()));
		tradeFinanceCO.setInOutBills(NumberUtil.nullToZero(dashboardCO.getBillsAmt()));
		tradeFinanceCO.setAcceptance(NumberUtil.nullToZero(dashboardCO.getAcceptanceAmt()));
		tradeFinanceCO.setImpLcSum(NumberUtil.nullToZero(dashboardCO.getImpLcSum()));
		tradeFinanceCO.setImpLcOuts(NumberUtil.nullToZero(dashboardCO.getImpLcOuts()));
		tradeFinanceCO.setImpLcAccept(NumberUtil.nullToZero(dashboardCO.getImpLcAccept()));
		tradeFinanceCO.setImpLcSettled(NumberUtil.nullToZero(dashboardCO.getImpLcSettled()));
		tradeFinanceCO.setExpLcSum(NumberUtil.nullToZero(dashboardCO.getExpLcSum()));
		tradeFinanceCO.setExpLcOuts(NumberUtil.nullToZero(dashboardCO.getExpLcOuts()));
		tradeFinanceCO.setExpLcAccept(NumberUtil.nullToZero(dashboardCO.getExpLcAccept()));
		tradeFinanceCO.setExpLcSettled(NumberUtil.nullToZero(dashboardCO.getExpLcSettled()));
		tradeFinanceCO.setLgOuts(NumberUtil.nullToZero(dashboardCO.getLgOuts()));
		tradeFinanceCO.setLgSettled(NumberUtil.nullToZero(dashboardCO.getLgSettled()));
		tradeFinanceCO.setExpBillsSum(NumberUtil.nullToZero(dashboardCO.getExpBillsSum()));
		tradeFinanceCO.setExpBillsOuts(NumberUtil.nullToZero(dashboardCO.getExpBillsOuts()));
		tradeFinanceCO.setExpBillsAccept(NumberUtil.nullToZero(dashboardCO.getExpBillsAccept()));
		tradeFinanceCO.setExpBillsSettled(NumberUtil.nullToZero(dashboardCO.getExpBillsSettled()));
		tradeFinanceCO.setImpBillsSum(NumberUtil.nullToZero(dashboardCO.getImpBillsSum()));
		tradeFinanceCO.setImpBillsOuts(NumberUtil.nullToZero(dashboardCO.getImpBillsOuts()));
		tradeFinanceCO.setImpBillsAccept(NumberUtil.nullToZero(dashboardCO.getImpBillsAccept()));
		tradeFinanceCO.setImpBillsSettled(NumberUtil.nullToZero(dashboardCO.getImpBillsSettled()));

		/**
		 * Financing applications and approved lines ...
		 */
		finAppAndApprovedLinesCO.setApprovedLines(NumberUtil.nullToZero(dashboardCO.getApprovedLinesAmt()));
		finAppAndApprovedLinesCO.setNewApplications(dashboardCO.getApplicationsAmt());
		finAppAndApprovedLinesCO.setBlockedOrSuspFac(NumberUtil.nullToZero(dashboardCO.getFacilitiesAmt()));
		finAppAndApprovedLinesCO.setDrawdowns(dashboardCO.getDrawdownsAmt());
		finAppAndApprovedLinesCO.setCollaterals(NumberUtil.nullToZero(dashboardCO.getCollateralsAmt()));
		finAppAndApprovedLinesCO.setGuarantees(dashboardCO.getGuaranteesAmt());
		finAppAndApprovedLinesCO.setInOutLC(NumberUtil.nullToZero(dashboardCO.getLcAmt()));
		finAppAndApprovedLinesCO.setLgs(NumberUtil.nullToZero(dashboardCO.getLgAmt()));
		finAppAndApprovedLinesCO.setInOutBills(NumberUtil.nullToZero(dashboardCO.getBillsAmt()));
		finAppAndApprovedLinesCO.setAcceptance(NumberUtil.nullToZero(dashboardCO.getAcceptanceAmt()));

		/**
		 * Financing Deals ...
		 */
		assetsFinDeals.setTotalAmt(NumberUtil.nullToZero(dashboardCO.getTotalAssetAmt()));
		assetsFinDeals.setSettledAmt(NumberUtil.nullToZero(dashboardCO.getSettledAssetAmt()));
		assetsFinDeals.setOutstandingAmt(NumberUtil.nullToZero(dashboardCO.getOutstandAssetAmt())
			.subtract(NumberUtil.nullToZero(dashboardCO.getOverdueAssetAmt())));
		assetsFinDeals.setEarnedProfit(NumberUtil.nullToZero(dashboardCO.getProfitAssetAmt()));
		assetsFinDeals.setOverdueAmt(NumberUtil.nullToZero(dashboardCO.getOverdueAssetAmt()));
		assetsFinDeals.setGuarantees(NumberUtil.nullToZero(dashboardCO.getGuaranteesAssetAmt()));
		assetsFinDeals.setCollaterals(NumberUtil.nullToZero(dashboardCO.getCollateralAssetAmt()));
		assetsFinDeals.setPromissoryNotes(NumberUtil.nullToZero(dashboardCO.getPromNoteAssetAmt()));

		liabFinDeals.setTotalAmt(NumberUtil.nullToZero(dashboardCO.getTotalLiabAmt()));
		liabFinDeals.setSettledAmt(NumberUtil.nullToZero(dashboardCO.getSettledLiabAmt()));
		liabFinDeals.setOutstandingAmt(NumberUtil.nullToZero(dashboardCO.getOutstandLiabAmt())
			.subtract(NumberUtil.nullToZero(dashboardCO.getOverdueLiabAmt())));
		liabFinDeals.setEarnedProfit(NumberUtil.nullToZero(dashboardCO.getProfitLiabAmt()));
		liabFinDeals.setOverdueAmt(NumberUtil.nullToZero(dashboardCO.getOverdueLiabAmt()));
		liabFinDeals.setGuarantees(NumberUtil.nullToZero(dashboardCO.getGuaranteesLiabAmt()));
		liabFinDeals.setCollaterals(NumberUtil.nullToZero(dashboardCO.getCollateralLiabAmt()));
		liabFinDeals.setPromissoryNotes(NumberUtil.nullToZero(dashboardCO.getPromNoteLiabAmt()));

		indirectLiabFinDeals.setTotalAmt(NumberUtil.nullToZero(dashboardCO.getTotalIliabAmt()));
		indirectLiabFinDeals.setSettledAmt(NumberUtil.nullToZero(dashboardCO.getSettledIliabAmt()));
		indirectLiabFinDeals.setOutstandingAmt(NumberUtil.nullToZero(dashboardCO.getOutstandIliabAmt())
			.subtract(NumberUtil.nullToZero(dashboardCO.getOverdueIliabAmt())));
		indirectLiabFinDeals.setEarnedProfit(NumberUtil.nullToZero(dashboardCO.getProfitIliabAmt()));
		indirectLiabFinDeals.setOverdueAmt(NumberUtil.nullToZero(dashboardCO.getOverdueIliabAmt()));
		indirectLiabFinDeals.setGuarantees(NumberUtil.nullToZero(dashboardCO.getGuaranteesIliabAmt()));
		indirectLiabFinDeals.setCollaterals(NumberUtil.nullToZero(dashboardCO.getCollateralIliabAmt()));
		indirectLiabFinDeals.setPromissoryNotes(NumberUtil.nullToZero(dashboardCO.getPromNoteIliabAmt()));
		if(sappVO == null)
		{
		    limitsFinDeals.setTotalAmt(NumberUtil.nullToZero(dashboardCO.getTotalLimitAmt()));
		    limitsFinDeals.setSettledAmt(NumberUtil.nullToZero(dashboardCO.getSettledLimitAmt()));
		    limitsFinDeals.setOutstandingAmt(NumberUtil.nullToZero(dashboardCO.getOutstandLimitAmt()));
		    limitsFinDeals.setEarnedProfit(NumberUtil.nullToZero(dashboardCO.getProfitLimitAmt()));
		    limitsFinDeals.setOverdueAmt(NumberUtil.nullToZero(dashboardCO.getOverdueLimitAmt()));
		    limitsFinDeals.setGuarantees(NumberUtil.nullToZero(dashboardCO.getGuaranteesLimitAmt()));
		    limitsFinDeals.setCollaterals(NumberUtil.nullToZero(dashboardCO.getCollateralLimitAmt()));
		    limitsFinDeals.setPromissoryNotes(NumberUtil.nullToZero(dashboardCO.getPromNoteLimitAmt()));
		}
		investAndTreasury.setInvestTreasury_cash(NumberUtil.nullToZero(dashboardCO.getInvCashAmt()));
		investAndTreasury.setInvestTreasury_holding(NumberUtil.nullToZero(dashboardCO.getInvHoldingAmt()));
		investAndTreasury.setInvestTreasury_sukuk(NumberUtil.nullToZero(dashboardCO.getInvSukukAmt()));
		investAndTreasury.setInvestTreasury_forex(NumberUtil.nullToZero(dashboardCO.getTreasForexAmt()));
		investAndTreasury.setInvestTreasury_moneyMarket(NumberUtil.nullToZero(dashboardCO.getTreasMarketAmt()));
		investAndTreasury
			.setInvestTreasury_islamicDerivatives(NumberUtil.nullToZero(dashboardCO.getTreasDerivAmt()));
	    }
	    List<Object> assetsAndLiabList = new ArrayList<Object>();
	    List<Object> finAppAndAppList = new ArrayList<Object>();
	    List<Object> financeDealsList = new ArrayList<Object>();
	    List<Object> investAndTreasuryList = new ArrayList<Object>();

	    // Hala - TP686119 - IJU- 3995
	    assetsAndLiabList.add(liabilityCO);
	    assetsAndLiabList.add(assetsCO);
	    finAppAndAppList.add(finAppAndApprovedLinesCO);
	    financeDealsList.add(assetsFinDeals);
	    financeDealsList.add(liabFinDeals);
	    financeDealsList.add(indirectLiabFinDeals);
	    investAndTreasuryList.add(investAndTreasury);
	    /**
	    * 
	    */

	    /**
	     * Elie Achkar TFA
	     */
	    List<Object> tradeFinanceList = new ArrayList<Object>();
	    tradeFinanceList.add(tradeFinanceCO);

	    if(sappVO == null)
	    {
		financeDealsList.add(limitsFinDeals);
	    }
	    // investAndTreasuryList.add();

	    String assetsAndLiabStr = CommonMethods.convertListToJSONString(assetsAndLiabList);
	    String finAppAndAppStr = CommonMethods.convertListToJSONString(finAppAndAppList);
	    String financeDealsStr = CommonMethods.convertListToJSONString(financeDealsList);
	    String investAndTreasuryStr = CommonMethods.convertListToJSONString(investAndTreasuryList);
	    // JSONObject jsonObj = JSONObject.fromObject(assetsAndLiabList);
	    // jsonObj.toString();

	    dashboardCO.setAssetsAndLiabList(assetsAndLiabStr);
	    dashboardCO.setFinAppAndAppList(finAppAndAppStr);
	    dashboardCO.setFinanceDealsList(financeDealsStr);
	    dashboardCO.setInvestAndTreasuryList(investAndTreasuryStr);

	    /**
	     * Elie Achkar Trade Finance Data
	     */
	    String tradeFinanceStr = CommonMethods.convertListToJSONString(tradeFinanceList);
	    dashboardCO.setTradeFinanceList(tradeFinanceStr);

	    /**
	     * Access privilege
	     */
	    checkUserAccessRight();
	    /**
	    * 
	    */
	    /* For the Graphs grid */
	    BigDecimal blockedAmount = (liabilityCO.getBlockedAmount() != null
		    && liabilityCO.getBlockedAmount().compareTo(BigDecimal.ZERO) == 0) ? null
			    : liabilityCO.getBlockedAmount();
	    BigDecimal currentBalance = (liabilityCO.getCurrentBalance() != null
		    && liabilityCO.getCurrentBalance().compareTo(BigDecimal.ZERO) == 0) ? null
			    : liabilityCO.getCurrentBalance();
	    BigDecimal availableBalance = (liabilityCO.getAvailableBalance() != null
		    && liabilityCO.getAvailableBalance().compareTo(BigDecimal.ZERO) == 0) ? null
			    : liabilityCO.getAvailableBalance();
	    BigDecimal overdrawLimitLiab = (liabilityCO.getOverdrawLimit() != null
		    && liabilityCO.getOverdrawLimit().compareTo(BigDecimal.ZERO) == 0) ? null
			    : liabilityCO.getOverdrawLimit();
	    BigDecimal duesAssetLiablAmtAsset = (liabilityCO.getDuesAssetLiablAmt() != null
		    && liabilityCO.getDuesAssetLiablAmt().compareTo(BigDecimal.ZERO) == 0) ? null
			    : liabilityCO.getDuesAssetLiablAmt();

	    // (inverse in the graph)

	    /*
	     * Multiplying by -1 for the current and available and blocked
	     * Liabilities as requested to be inverse of the original amount
	     */
	    /*
	     * divided into two conditions because if null value , so , null
	     * pointer will occur on .multiply
	     */

	    if(null == currentBalance)
	    {
		liablValuesList.add(null);
	    }
	    else
	    {
		liablValuesList.add(currentBalance.multiply(BalSignNumber));
	    }
	    if(null == availableBalance)
	    {
		liablValuesList.add(null);
	    }
	    else
	    {
		liablValuesList.add(availableBalance.multiply(BalSignNumber));
	    }
	    if(null == blockedAmount)   /*TP#335452 Blocked amount at the level of 360 degrees view /view chart"*/
	    {
		liablValuesList.add(null);
	    }
	    else
	    {
		liablValuesList.add(blockedAmount.multiply(
			BalSignNumber)); /* To be positive in the graph */
	    }
	    if(null == overdrawLimitLiab)
	    {
		liablValuesList.add(null);
	    }
	    else
	    {
		liablValuesList.add(overdrawLimitLiab);
	    }

	    // liablValuesList.add(blockedAmount);
	    // liablValuesList.add(overdrawLimitLiab);
	    liablValuesList.add(duesAssetLiablAmtAsset);

	    BigDecimal currentBalanceAsset = (assetsCO.getCurrentBalance() != null
		    && assetsCO.getCurrentBalance().compareTo(BigDecimal.ZERO) == 0) ? null
			    : assetsCO.getCurrentBalance();
	    BigDecimal availableBalanceAsset = (assetsCO.getAvailableBalance() != null
		    && assetsCO.getAvailableBalance().compareTo(BigDecimal.ZERO) == 0) ? null
			    : assetsCO.getAvailableBalance();
	    BigDecimal blockedAmountAsset = (assetsCO.getBlockedAmount() != null
		    && assetsCO.getBlockedAmount().compareTo(BigDecimal.ZERO) == 0) ? null
			    : assetsCO.getBlockedAmount();
	    /*
	     * BigDecimal overdrawLimitAsset = (assetsCO.getOverdrawLimit() !=
	     * null && assetsCO.getOverdrawLimit() .compareTo(BigDecimal.ZERO)
	     * == 0) ? null : assetsCO.getOverdrawLimit(); BigDecimal
	     * duesAssetLiablAmtAsset = (assetsCO.getDuesAssetLiablAmt() != null
	     * && assetsCO .getDuesAssetLiablAmt().compareTo(BigDecimal.ZERO) ==
	     * 0) ? null : assetsCO.getDuesAssetLiablAmt();
	     */
	    /*
	     * Multiplying the assets by -1 for the current and available assets
	     * as requested to be inverse of the original amount
	     */
	    /*
	     * divided into two conditions because if null value , so , null
	     * pointer will occur on .multiply
	     */
	    if(null == currentBalanceAsset)
	    {
		assetsValuesList.add(null);
	    }
	    else
	    {
		assetsValuesList.add(currentBalanceAsset.multiply(BalSignNumber));
	    }
	    if(null == availableBalanceAsset)
	    {
		assetsValuesList.add(null);
	    }
	    else
	    {
		assetsValuesList.add(availableBalanceAsset.multiply(BalSignNumber));
	    }
	    //assetsValuesList.add(blockedAmountAsset);
	    assetsValuesList.add(null);
	    assetsValuesList.add(null);
	    assetsValuesList.add(null);
	    categValuesList.add(getText("currentBalance_key"));
	    categValuesList.add(getText("availableBalance_key"));
	    categValuesList.add(getText("blockedAmount_key"));
	    categValuesList.add(getText("overdrawLimit_key"));
	    categValuesList.add(getText("Dues_Amount_key"));
	    //Hala Al Sheikh - TP941927
	    if(NumberUtil.isEmptyDecimal(assetsCO.getTotalNbrAcc()))
	    {
		nbAccountAssets = "";
	    }
	    else
	    {
		nbAccountAssets = assetsCO.getTotalNbrAcc().toString();
		double dblAccAssets = Double.parseDouble(nbAccountAssets);
		nbAccountAssets = String.valueOf((int) dblAccAssets);
	    }
	    if(NumberUtil.isEmptyDecimal(liabilityCO.getTotalNbrAcc()))
	    {
		nbAccountLiabl = "";
	    }
	    else
	    {
		nbAccountLiabl = liabilityCO.getTotalNbrAcc().toString();
		double dblAccLiab = Double.parseDouble(nbAccountLiabl);
		nbAccountLiabl = String.valueOf((int) dblAccLiab);
	    }    
	    //End TP941927
	    liabilityValues = CommonMethods.convertListToJSONString(liablValuesList);
	    assetsValues = CommonMethods.convertListToJSONString(assetsValuesList);
	    categValues = CommonMethods.convertListToJSONString(categValuesList);

	    categValuesList = new ArrayList<String>();
	    categValuesList.add(getText("approvedLines_key"));
	    categValuesList.add(getText("newApp_key"));
	    categValuesList.add(getText("blockedOrSuspFac_key"));
	    categValuesList.add(getText("collaterals_key"));
	    categValuesList.add(getText("guarantees_key"));
	    finAppList = CommonMethods.convertListToJSONString(categValuesList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    return "jsonError";
	}
	return SUCCESS;
    }

    public String loadLineChart() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();

	dashboardSC.setCompCode(sessionCO.getCompanyCode());
	if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(dashboardSC.getLoginTypeByBr()))
	{
	    dashboardSC.setBranchCode(sessionCO.getBranchCode());
	}
	dashboardSC.setLovType(ConstantsCommon.ACCOUNT_STATUS_LOV_TYPE);
	dashboardSC.setLanguage(sessionCO.getLanguage());
	dashboardSC.setAssestsOrLiab(ConstantsCommon.ASSETS_ACC);
	dashboardSC.setUserId(sessionCO.getUserName());
	dashboardSC.setAppName(sessionCO.getCurrentAppName());
	dashboardSC.setProgRef(get_pageRef());
	dashboardSC.setNbRec(-1);
	List<AMFSUPPLEMENTVO> amfSupplementAssetsVOs = dashboardBO.getAmfSupplement(dashboardSC);
	dashboardSC.setAssestsOrLiab(ConstantsCommon.LIABILTIES_ACC);
	List<AMFSUPPLEMENTVO> amfSupplementLiabilitiesVOs = dashboardBO.getAmfSupplement(dashboardSC);
	/* put it as inverse coz it is inversed in the chart. */
	setAccBalanceChartAssetList(CommonMethods.convertListToJSONString(amfSupplementLiabilitiesVOs));
	setAccBalanceChartLiableList(CommonMethods.convertListToJSONString(amfSupplementAssetsVOs));

	return "loadJson";
    }

    /**
     * format the amount
     * 
     * @author marwanmaddah
     * @date Jul 5, 2013
     * @param theValue
     * @return
     * @throws BaseException String
     * 
     */
    private BigDecimal returnDecimalFromBaseCurrency() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	CURRENCIESVO currenciesVO = new CURRENCIESVO();
	currenciesVO.setCOMP_CODE(sessionCO.getCompanyCode());
	currenciesVO.setCURRENCY_CODE(sessionCO.getBaseCurrencyCode());
	currenciesVO = returnCommonLibBO().returnCurrency(currenciesVO);
	return currenciesVO.getDECIMAL_POINTS();
    }

    /**
     * 
     * @author marwanmaddah
     * @date Apr 18, 2013 void
     * 
     */
    private void fillLoginTypeCmb() throws BaseException
    {
	/**
	 * Login Branch
	 */
	SelectCO loginBranch = new SelectCO();
	loginBranch.setCode("1");
	loginBranch.setDescValue(getText("login_branch_key"));
	

	/**
	 * all branches
	 */
	SelectCO allBranches = new SelectCO();
	allBranches.setCode("2");
	allBranches.setDescValue(getText("all_branch_key"));
	loginBrTypeList.add(allBranches);//id:949679 Details:SUPT200009 - [AUB-Upgrade] 360 Degrees View does not work TAR:SUPT200009
	loginBrTypeList.add(loginBranch);
    }
    
  //806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen

    @SuppressWarnings("unchecked")
    private void loadKYCDropDown()
    {

	try
	{
	    SelectSC selSC = new SelectSC(new BigDecimal(26));
	  // selSC.setLovCodesExclude("'"+NCifMaintenanceConstant.KYC_REJECTED+"'");
	    List<SelectCO> selCOs = returnLOV(selSC);
	  //  selCOs.add(new SelectCO());
	    kycDropDown = new HashMap<String, String>();
	    for(SelectCO selectCO : selCOs)
	    {
		kycDropDown.put(selectCO.getCode(), selectCO.getDescValue());
	    }
	}
	catch(BaseException e)
	{
	    e.printStackTrace();
	}

    }

    /**
     * used to show/hide the button cardReader Based on the flag
     * ENABLE_CARD_READER_YN at the level of CTSCONTROL related to modification
     * BMOI130009
     * 
     * @author AntonellaAndraos
     * @param compCode company code
     * @param branchCode branch code
     * @throws BaseException
     */
    private void cardReaderVisibility(BigDecimal compCode, BigDecimal branchCode) throws BaseException
    {
	// by default is not visible
	BigDecimal isVisible = BigDecimal.ZERO;
	if(("1".equals(StringUtil.nullEmptyToValue( returnCommonLibBO().returnCTSCONTROLVO(compCode, branchCode).getENABLE_CARD_READER_YN(), "0"))))
	{
	    isVisible = BigDecimal.ONE;
	}
	SYS_PARAM_SCREEN_DISPLAYVO dynVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	dynVO.setIS_VISIBLE(isVisible);
	getAdditionalScreenParams().put("cb_cardReader", dynVO);
    }
    
    
  //806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen

    /**
     * @param dashboardBO the dashboardBO to set
     */
    public void setDashboardBO(DashboardBO dashboardBO)
    {
	this.dashboardBO = dashboardBO;
    }

    /**
     * @return the dashboardCO
     */
    public DashboardCO getDashboardCO()
    {
	return dashboardCO;
    }

    /**
     * @param dashboardCO the dashboardCO to set
     */
    public void setDashboardCO(DashboardCO dashboardCO)
    {
	this.dashboardCO = dashboardCO;
    }

    /**
     * @return the loginBrTypeList
     */
    public List<SelectCO> getLoginBrTypeList()
    {
	return loginBrTypeList;
    }

    /**
     * @param loginBrTypeList the loginBrTypeList to set
     */
    public void setLoginBrTypeList(List<SelectCO> loginBrTypeList)
    {
	this.loginBrTypeList = loginBrTypeList;
    }

    public DashboardSC getDashboardSC()
    {
	return dashboardSC;
    }

    public void setDashboardSC(DashboardSC dashboardSC)
    {
	this.dashboardSC = dashboardSC;
    }

    @Override
    public Object getModel()
    {
	return dashboardSC;
    }

    public String getAssetsValues()
    {
	return assetsValues;
    }

    public void setAssetsValues(String assetsValues)
    {
	this.assetsValues = assetsValues;
    }

    public String getLiabilityValues()
    {
	return liabilityValues;
    }

    public void setLiabilityValues(String liabilityValues)
    {
	this.liabilityValues = liabilityValues;
    }

    public String getCategValues()
    {
	return categValues;
    }

    public void setCategValues(String categValues)
    {
	this.categValues = categValues;
    }

    public String getNbAccountAssets()
    {
	return nbAccountAssets;
    }

    public void setNbAccountAssets(String nbAccountAssets)
    {
	this.nbAccountAssets = nbAccountAssets;
    }

    public String getNbAccountLiabl()
    {
	return nbAccountLiabl;
    }

    public void setNbAccountLiabl(String nbAccountLiabl)
    {
	this.nbAccountLiabl = nbAccountLiabl;
    }

    public String getAccBalanceChartLiableList()
    {
	return accBalanceChartLiableList;
    }

    public void setAccBalanceChartLiableList(String accBalanceChartLiableList)
    {
	this.accBalanceChartLiableList = accBalanceChartLiableList;
    }

    public String getAccBalanceChartAssetList()
    {
	return accBalanceChartAssetList;
    }

    public void setAccBalanceChartAssetList(String accBalanceChartAssetList)
    {
	this.accBalanceChartAssetList = accBalanceChartAssetList;
    }

    public String getFinAppList()
    {
	return finAppList;
    }

    public void setFinAppList(String finAppList)
    {
	this.finAppList = finAppList;
    }

    public Map<String, String> getKycDropDown()
    {
        return kycDropDown;
    }

    public void setKycDropDown(Map<String, String> kycDropDown)
    {
        this.kycDropDown = kycDropDown;
    }

}
