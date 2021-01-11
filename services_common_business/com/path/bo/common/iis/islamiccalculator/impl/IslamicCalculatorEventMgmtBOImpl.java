package com.path.bo.common.iis.islamiccalculator.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import com.path.bo.common.CommonLibBO;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.fms.limitscommon.FmsLimitsCommonBO;
import com.path.bo.common.iis.IISCommonConstants;
import com.path.bo.common.iis.dealcharges.IISDealChargesBO;
import com.path.bo.common.iis.islamiccalculator.IISCommonBO;
import com.path.bo.common.iis.islamiccalculator.IISIslamicCalculatorBO;
import com.path.bo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtBO;
import com.path.bo.common.memo.MemoBO;
import com.path.bo.common.memo.MemoConstants;
import com.path.dao.common.CommonLibDAO;
import com.path.dao.common.iis.islamiccalculator.IISCommonDAO;
import com.path.dao.common.iis.islamiccalculator.IslamicCalculatorEventMgmtDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.AMFVOKey;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.BRANCHESVOKey;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIFVOKey;
import com.path.dbmaps.vo.CIF_OCCUPATIONVO;
import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.GEN_LEDGERVOKey;
import com.path.dbmaps.vo.IBOR_HDRVO;
import com.path.dbmaps.vo.IISCTRLVO;
import com.path.dbmaps.vo.IISCTRLVOKey;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.TRSCIFLIMITDETVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSCLASSVOKey;
import com.path.dbmaps.vo.TRSCLASS_EXTENDEDVO;
import com.path.dbmaps.vo.TRSCLASS_KEY_LABELVO;
import com.path.dbmaps.vo.TRSDEAL_CALC_VALUES_TEMPVO;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVO;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVOKey;
import com.path.dbmaps.vo.TRSPAYPLANVO;
import com.path.dbmaps.vo.TRSPAYPLAN_CRITERIAVO;
import com.path.dbmaps.vo.TRSVAT_PERIODVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.LabelElemCO;
import com.path.vo.common.iis.dealcharges.IisDealChargesCO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IISCustomerLimitCO;
import com.path.vo.common.iis.islamiccalculator.IISHolidayCheckCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorDBRatioSC;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.common.iis.islamiccalculator.TrsDealSettlementChargesCO;
import com.path.vo.common.iis.islamiccalculator.TrsPlanBallonPaymentCO;
import com.path.vo.common.iis.islamiccalculator.TrspayplandetCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.core.cif.CifSC;

/**
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code<br>
 * <br>
 * 
 * BO Class for Islamic Calculator Event Management.
 * 
 * @see com.path.bo.common.iis.islamiccalculator.impl.IslamicCalculatorEventMgmtBOImpl
 * @author Bejoy,Linchu
 * 
 */
public class IslamicCalculatorEventMgmtBOImpl extends BaseBO implements IslamicCalculatorEventMgmtBO
{
    private static final long serialVersionUID = 1L;
    private IslamicCalculatorEventMgmtDAO islamicCalculatorEventMgmtDAO;
    private IISIslamicCalculatorBO iisIslamicCalculatorBO;
    private CommonLibDAO commonLibDao;
    protected IISCommonBO iisCommonBO;
    private IISDealChargesBO iisDealChargesBO;
    // private boolean flagForNoOfPayments = false;
    private boolean flagForNoOfPayments;
    private MemoBO memoBO;
    private IISCommonDAO iisCommonDAO;
    protected CommonLibBO commonLibBO;
    protected FmsLimitsCommonBO fmsLimitsCommonBO;

    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> additionalScreenParams = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    /**
     * Method for calculating the yield
     */

    /**
     * Constant For Bills Calculator
     */

    public static final String NIDC_DETAILS = "nidc_details";
    public static final String NO_Of_Bills = "noOfBills";
    public static final String TOTAL_BILL_AMOUNT = "Total_Bill_Amount";
    public static final String PRICE = "Price";
    public static final String MATURITY_DATE = "plan_maturity_date";
    public static final String LINK_TYPE = "linkType";

    public static final String CALCULATE_BTN = "calculateBtn";
    public static final String PRINT_BTN = "  printBtn";
    public static final String RESET_BTN = "resetBtn";
    public static final String CREATE_DEAL_BTN = "createDealBtn";
    public static final String TRADING_CURRENCY = "lookuptxt_tradingCurrency";
    public static final String TRADING_CURRENCY_DEC = "tradingCurrencyDesc";

    public static final String profitcalculationdetailsdiv = "profitcalculationdetailsdiv";
    public static final String Tenor = "periodicity_nbr";
    public static final String TenorType = "periodicity_type";

    public static final String CROSS_RATE = "Cross_rate";

    public static final String TRADING_BILL_AMOUNT = "tradingBillAmount";

    public static final String Total_Trading_Bill_Amount = "Total_Trading_Bill_Amount";
    public static final String Margin_Rate = "margin";
    public static final String Global_Rate = "Global_rate";
    public static final String Periodicity_NBR = "lookuptxt_iborRatePeriodicity";
    public static final String Periodicity_Type = "iborRatePeriodicityType";
    public static final String Global_rate_code = "lookuptxt_global_rate_code";
    public static final String Global_rate_code_desc = "global_rate_code_desc";
    public static final String yield = "annualYieldRate";
    public static final String AnnualFlatRate = "annualFlatRate";
    public static final String TotalFlatRate = "totalFlatRate";

    public static final String portfolio_cif = "lookuptxt_trsdetVO_PORTFOLIO_CIF";
    public static final String portfolio_seq = "lookuptxt_trsdetVO_PORTFOLIO_SEQ";
    public static final String portfolio_name = "portfolio_name";
    public static final String BROKER_CODE = "lookuptxt_trsdealVO_BROKER_CODE";
    public static final String BROKER_NAME = "trsdealVO_BROKER_NAME";

    public static final String BillAmount = "billAmount";
    public static final String NOfBills = "noOfBills";
    public static final String Accural_Basis = "accrualBasis";
    public static final String interestCalculationMethod = "interestCalculationMethod";
    public static final String PaymPeriodNbr = "paymPeriodNbr";

    public static final String lbl_Total_Bill_Amount = "lbl_Total_Bill_Amount";
    public static final String Annual_Discount_Rate_key = "Annual_Discount_Rate_key";
    public static final String lbl_Annual_Discount_Rate = "lbl_Annual_Discount_Rate";

    public void setFmsLimitsCommonBO(FmsLimitsCommonBO fmsLimitsCommonBO)
    {
	this.fmsLimitsCommonBO = fmsLimitsCommonBO;
    }

    /**
     * Method for on change event of Cif
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeCif(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getCifNo()).compareTo(BigDecimal.ZERO) <= 0)
	{
	    throw new BOException(MessageCodes.INVALID_CIF_NUMBER);
	}
	long count = islamicCalculatorEventMgmtDAO.ifCifExist(islamicCalculatorEventMgmtCO);
	if(count == 0)
	{
	    throw new BOException(MessageCodes.INVALID_CIF_NUMBER);
	}
	if(islamicCalculatorEventMgmtCO.getStartDate() == null)
	{
	    islamicCalculatorEventMgmtCO.setStartDate(islamicCalculatorEventMgmtCO.getRunningDate());
	}
	if(islamicCalculatorEventMgmtCO.getCurrencyCode() == null
		|| NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getCurrencyCode()))
	{

	    islamicCalculatorEventMgmtCO.setCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	}
	// Call to check the Cif status.
	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());

	// To get client side
	iisCommonCO.setIdNo(islamicCalculatorEventMgmtCO.getIdNo());

	iisCommonCO = iisCommonBO.validateCifStatus(iisCommonCO);// 673168

	if(islamicCalculatorEventMgmtCO.getCifNo() == null || islamicCalculatorEventMgmtCO.getCompCode() == null
		|| islamicCalculatorEventMgmtCO.getBranchCode() == null
		// || islamicCalculatorEventMgmtCO.getProductClass() == null
		// || islamicCalculatorEventMgmtCO.getProductClass() == null
		|| islamicCalculatorEventMgmtCO.getStartDate() == null)
	{
	    // throw new
	    // BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	else
	{
	    // iisCommonCO = iisCommonBO.validateCifStatus(iisCommonCO);
	    islamicCalculatorEventMgmtCO.setStatus(iisCommonCO.getStatus());

	    // Added for showing CIf income based on flag.

	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParams = iisCommonBO
		    .returnIISControlParams(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCOParams.getShowCifIncome() == null)
	    {
		islamicCalculatorEventMgmtCOParams.setShowCifIncome("N");
	    }

	    if(islamicCalculatorEventMgmtCOParams.getCalcShowCifIncomeInd() == null)
	    {
		islamicCalculatorEventMgmtCO.setCalcShowCifIncomeInd("F");
	    }

	    iisCommonCO.setAccessRestricted(IISCommonConstants.OFF);
	    String lsStaff = IISCommonConstants.OFF;
	    if(!islamicCalculatorEventMgmtCOParams.getShowCifIncome().equals(ConstantsCommon.NO))
	    {
		BigDecimal cifType = iisCommonBO.returnCifType(iisCommonCO);

		if(cifType != null)
		{
		    iisCommonCO.setTypeCode(cifType);

		    lsStaff = iisCommonBO.returnRifStaff(iisCommonCO);
		    if(iisCommonCO.getIdNo() != null)
		    {
			IISCommonCO iisCommonCOTemp = iisCommonBO.returnUsrAccess(iisCommonCO);
			if(iisCommonCOTemp != null)
			{
			    iisCommonCO.setAccessRestricted(iisCommonCOTemp.getAccessRestricted());
			}
		    }

		    // Getting the Cif's monthly income and approved income.
		    CIF_OCCUPATIONVO cifIncome = iisCommonBO.returnCifIncome(iisCommonCO);
		    BigDecimal monthlySalary = BigDecimal.ZERO;
		    if(cifIncome != null)
		    {
			monthlySalary = cifIncome.getMONTHLY_BASIC_SALARY() == null ? BigDecimal.ZERO
				: cifIncome.getMONTHLY_BASIC_SALARY();
		    }
		    islamicCalculatorEventMgmtCO.setIncome(monthlySalary);
		    islamicCalculatorEventMgmtCO.setApprovedSalary(monthlySalary);

		}
	    }
	    // Setting the calculator language and setting the short name and
	    // long name.
	    // Setting calculator language
	    islamicCalculatorEventMgmtCO.setCalculatorLanguage(getCalculatorLanguage(islamicCalculatorEventMgmtCO));
	    // Setting the Long or Short name flag
	    islamicCalculatorEventMgmtCO
		    .setLongOrShortNameDesc(getLongOrShortDescription(islamicCalculatorEventMgmtCO));

	    // Setting the CIF name and civil id number.
	    // Method to populate the cif name and civilId number.
	    IslamicCalculatorEventMgmtCO populateOnChangeCifCivilId = islamicCalculatorEventMgmtDAO
		    .populateOnChangeCifCivilId(islamicCalculatorEventMgmtCO);

	    islamicCalculatorEventMgmtCO.setCifName(populateOnChangeCifCivilId.getCifName());
	    islamicCalculatorEventMgmtCO.setIdNo(populateOnChangeCifCivilId.getIdNo());
	    if(populateOnChangeCifCivilId.getSalaryWithBank() != null
		    && ("1".equals(populateOnChangeCifCivilId.getSalaryWithBank())
			    || "Y".equals(populateOnChangeCifCivilId.getSalaryWithBank())))
	    {
		islamicCalculatorEventMgmtCO.setSalaryWithBank("Y");
	    }
	    else
	    {
		islamicCalculatorEventMgmtCO.setSalaryWithBank("N");
	    }

	    // Calculating the DB ratio
	    iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    List<IslamicCalculatorDBRatioSC> vectDBRatio = iisCommonBO.calculateDBRatio(iisCommonCO);
	    if(!vectDBRatio.isEmpty())
	    {
		IslamicCalculatorDBRatioSC dbRatioSC = vectDBRatio.get(vectDBRatio.size() - 1);
		islamicCalculatorEventMgmtCO.setDebtBurdanRatio(dbRatioSC.getDbrAmount());
	    }

	    String showIncome = ConstantsCommon.NO;
	    IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();
	    iisctrlvoKey.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisctrlvoKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    IISCTRLVO iisctrlVO = iisCommonBO.returnIISCTRL(iisctrlvoKey);
	    if(iisctrlVO != null)
	    {
		showIncome = StringUtil.nullEmptyToValue(iisctrlVO.getSHOW_CIF_INCOME(), ConstantsCommon.NO);
	    }
	    if(ConstantsCommon.YES.equals(showIncome))
	    {
		if(lsStaff != null && iisCommonCO.getCifNo() != null && iisCommonCO.getAccessRestricted() != null
			&& ((lsStaff.equals(IISCommonConstants.OFF))
				|| (iisCommonCO.getCifNo() == islamicCalculatorEventMgmtCO.getCifNo())
				|| (iisCommonCO.getAccessRestricted().equals(IISCommonConstants.ON))))
		{
		    islamicCalculatorEventMgmtCO.setEnable(true);
		    setSalaryFieldProperty(islamicCalculatorEventMgmtCO);
		    if(islamicCalculatorEventMgmtCO.getCalcDbrCalculationReqdYn() != null
			    && islamicCalculatorEventMgmtCO.getCalcDbrCalculationReqdYn().equals(ConstantsCommon.YES))
		    {
			setApprovedSalaryFieldProperty(islamicCalculatorEventMgmtCO);
			setDBRatioFieldProperty(islamicCalculatorEventMgmtCO);
		    }
		    else
		    {
			islamicCalculatorEventMgmtCO.setEnable(false);
			setSalaryFieldProperty(islamicCalculatorEventMgmtCO);
			setApprovedSalaryFieldProperty(islamicCalculatorEventMgmtCO);
		    }
		}
		else
		{
		    islamicCalculatorEventMgmtCO.setEnable(false);
		    setSalaryFieldProperty(islamicCalculatorEventMgmtCO);
		    setApprovedSalaryFieldProperty(islamicCalculatorEventMgmtCO);
		    if(islamicCalculatorEventMgmtCO.getCalcDbrCalculationReqdYn() != null
			    && islamicCalculatorEventMgmtCO.getCalcDbrCalculationReqdYn().equals(ConstantsCommon.NO))
		    {
			setDBRatioFieldProperty(islamicCalculatorEventMgmtCO);
		    }
		}
	    }
	    vectDBRatio = null;
	    iisCommonCO = null;
	}
	// Calculating the yield.
	iisCommonCO = iisIslamicCalculatorBO.calculateYield(islamicCalculatorEventMgmtCO);
	// Added for yield not set properly
	if(iisCommonCO.getOrginalYield() != null && iisCommonCO.getOrginalYield().compareTo(BigDecimal.ZERO) == 1)
	{
	    islamicCalculatorEventMgmtCO.setYield(iisCommonCO.getOrginalYield());
	    islamicCalculatorEventMgmtCO.setMargin(iisCommonCO.getOrginalYield());
	}
	iisCommonCO = null;
	// TP# 190913;deepu.mohandas 15/05/2015
	if(StringUtil.nullEmptyToValue(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom(), "P").equals("JS"))
	{
	    iisCommonBO.checkCifExistingDeals(islamicCalculatorEventMgmtCO);

	    // TP#255368; Snitha; 15/01/2015 [START]
	    // f_check_memo

	    // For Memmo; Raeeas
	    if(ConstantsCommon.YES.equals(iisCommonBO.returnIISCTRL_ADDITIONAL_PARAM(
		    islamicCalculatorEventMgmtCO.getCompCode(), islamicCalculatorEventMgmtCO.getBranchCode(),
		    IISCommonConstants.IISCTRL_ADDITIONAL_PARAM_SHOW_MEMOS_IN_ALL_OPTS_UPON_RETRIEVAL)))
	    {
		MemoSC memoSC = new MemoSC();
		memoSC.setType(IISCommonConstants.SHOW_MEMOS_ON_RETRIEVAL);
		memoSC.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		memoSC.setLangCode(islamicCalculatorEventMgmtCO.getCalculatorLanguage());
		memoSC.setRunningDate(islamicCalculatorEventMgmtCO.getRunningDate());
		memoSC.setAppName(ConstantsCommon.IIS_APP_NAME);

		memoSC.setForAccOrCif(MemoConstants.CIF);
		memoSC.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
		memoSC.setLovType(MemoConstants.LOV_TYPE);
		if(memoBO.isMemoAvailable(memoSC))
		{
		    islamicCalculatorEventMgmtCO.setMemoSC(memoSC);
		}
	    }
	}
	if(ConstantsCommon.NO.equals(islamicCalculatorEventMgmtCO.getCalledByJSTriggerYN()))
	{
	    islamicCalculatorEventMgmtCO.setLimitSerialNo(null);
	    islamicCalculatorEventMgmtCO.setACC_BRANCH(null);
	    islamicCalculatorEventMgmtCO.setACC_CURRENCY(null);
	    islamicCalculatorEventMgmtCO.setACC_GL_CODE(null);
	    islamicCalculatorEventMgmtCO.setACC_CIF_NO(null);
	    islamicCalculatorEventMgmtCO.setACC_SL_NO(null);
	    islamicCalculatorEventMgmtCO.setADDITIONAL_REFERENCE(null);
	    islamicCalculatorEventMgmtCO.setACCOUNT_NAME(null);
	}
	return islamicCalculatorEventMgmtCO;
    }

    // Moved to iiscommonBO for LOS
    // private IslamicCalculatorEventMgmtCO checkCifExistingDeals(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws
    // BaseException
    // {
    //
    // }

    /**
     * Method to return the Deal Count for CIF
     * 
     * @param IISCommonParamCO
     * @return IISCommonParamCO
     * @throws BaseException
     */
    private void getCifExistingDealCount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	IslamicCalculatorEventMgmtCO resultCO = islamicCalculatorEventMgmtDAO
		.getCifExistingDealCount(islamicCalculatorEventMgmtCO);
	if(resultCO != null)
	{
	    islamicCalculatorEventMgmtCO.setACTIVE_DEAL_COUNT(resultCO.getACTIVE_DEAL_COUNT());
	    islamicCalculatorEventMgmtCO.setAPPROVE_DEAL_COUNT(resultCO.getAPPROVE_DEAL_COUNT());
	    islamicCalculatorEventMgmtCO.setDELETE_DEAL_COUNT(resultCO.getDELETE_DEAL_COUNT());
	    islamicCalculatorEventMgmtCO.setREJECT_DEAL_COUNT(resultCO.getREJECT_DEAL_COUNT());
	    islamicCalculatorEventMgmtCO.setREVERSE_DEAL_COUNT(resultCO.getREVERSE_DEAL_COUNT());
	    islamicCalculatorEventMgmtCO.setExistingDealStatusMessage("902419");
	}
    }

    private void setSalaryFieldProperty(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
    {
	SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	businessElement.setELEMENT_NAME("income");
	businessElement.setIS_VISIBLE(islamicCalculatorEventMgmtCO.getEnable() ? BigDecimal.ONE : BigDecimal.ZERO);
	getAdditionalScreenParams().put("income", businessElement);
	islamicCalculatorEventMgmtCO.getHmSysParam().put("income", businessElement);
    }

    private void setApprovedSalaryFieldProperty(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
    {
	SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	businessElement.setELEMENT_NAME("approvedSalary");
	businessElement.setIS_VISIBLE(islamicCalculatorEventMgmtCO.getEnable() ? BigDecimal.ONE : BigDecimal.ZERO);
	getAdditionalScreenParams().put("approvedSalary", businessElement);
	islamicCalculatorEventMgmtCO.getHmSysParam().put("approvedSalary", businessElement);
    }

    private void setDBRatioFieldProperty(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
    {
	SYS_PARAM_SCREEN_DISPLAYVO businessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	businessElement.setELEMENT_NAME("islamicCalculatorEventMgmtCO.debtBurdanRatio");
	businessElement.setIS_VISIBLE(islamicCalculatorEventMgmtCO.getEnable() ? BigDecimal.ONE : BigDecimal.ZERO);
	getAdditionalScreenParams().put("islamicCalculatorEventMgmtCO.debtBurdanRatio", businessElement);
    }

    /**
     * Method for on change event of CivilId
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeCivilId(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	// TP#346528 KFHML Sreejith
	if(islamicCalculatorEventMgmtCO.getIdNo() == null || "".equals(islamicCalculatorEventMgmtCO.getIdNo()))
	{
	    throw new BOException(MessageCodes.INVALID_CIVILID);
	}
	// Getting the Cif number
	if(islamicCalculatorEventMgmtCO.getCompCode() == null || islamicCalculatorEventMgmtCO.getIdNo() == null
	// || islamicCalculatorEventMgmtCO.getProductClass() == null
	)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	else
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setIdNo(islamicCalculatorEventMgmtCO.getIdNo());
	    int civilIdCount = iisCommonBO.returnCivilIdCount(iisCommonCO);
	    if(civilIdCount > 1)
	    {
		throw new BOException(MessageCodes.DUPLICATE_CIVIL_ID,
			new String[] { islamicCalculatorEventMgmtCO.getIdNo() }, true);
	    }

	    BigDecimal cif = iisCommonBO.returnCif(iisCommonCO);
	    if(NumberUtil.isEmptyDecimal(cif))
	    {
		throw new BOException(MessageCodes.INVALID_CIVILID);
	    }

	    islamicCalculatorEventMgmtCO.setCifNo(cif);
	    iisCommonCO = null;
	}
	// Calling the method to set the Cif related information like Cif
	// Status.Cif name,civilId number,yield etc.
	islamicCalculatorEventMgmtCO = populateOnChangeCif(islamicCalculatorEventMgmtCO);
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for on change event of Approved Salary
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO populateOnChangeApprovedSalary(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getCompCode() != null && islamicCalculatorEventMgmtCO.getCifNo() != null
		&& islamicCalculatorEventMgmtCO.getProductClass() != null
		&& islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getBranchCode() != null)
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	    iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    List<IslamicCalculatorDBRatioSC> vectDBRatio = iisCommonBO.calculateDBRatio(iisCommonCO);
	    if(!vectDBRatio.isEmpty())
	    {
		IslamicCalculatorDBRatioSC dbRatioSC = vectDBRatio.get(vectDBRatio.size() - 1);
		islamicCalculatorEventMgmtCO.setDebtBurdanRatio(dbRatioSC.getDbrAmount());
	    }
	    vectDBRatio = null;
	    iisCommonCO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for on change event of Salary With Bank
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO populateOnChangeSalaryWithBank(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	BigDecimal orginalYield = iisIslamicCalculatorBO.calculateYield(islamicCalculatorEventMgmtCO).getOrginalYield();
	if(orginalYield != null && orginalYield.compareTo(BigDecimal.ZERO) == 1)
	{
	    islamicCalculatorEventMgmtCO.setYield(orginalYield);
	    islamicCalculatorEventMgmtCO.setMargin(orginalYield);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating the details based on the product class selected.
     */
    @Override
    public IslamicCalculatorEventMgmtCO populateOnChangeProductClass(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = islamicCalculatorEventMgmtCO.getHmSysParam();
	islamicCalculatorEventMgmtCO.setFirstPaymentDate(islamicCalculatorEventMgmtCO.getStartDate());
	if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getProductClass()).compareTo(BigDecimal.ZERO) < 1)
	{
	    return islamicCalculatorEventMgmtCO;
	}

	// checking whether the product class exist in TRSCLASS table
	long count = islamicCalculatorEventMgmtDAO.isProductClassExist(islamicCalculatorEventMgmtCO);
	if(count == 0)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	////// - 713888 - Start
	IISCommonCO iisCommonCOForHolidayAction = new IISCommonCO();
	iisCommonCOForHolidayAction.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisCommonCOForHolidayAction.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisCommonCOForHolidayAction.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());

	BigDecimal holidayAction = iisCommonBO.returnHolidayAction(iisCommonCOForHolidayAction);
	islamicCalculatorEventMgmtCO.setHolidayAction(holidayAction);
	////// - 713888 - End
	/*
	 * //checking any NIDC deal linked in calculator if exists throw
	 * exception int
	 * nidcCount=NumberUtil.toInt(islamicCalculatorEventMgmtCO.
	 * getNidcDealCount()); if (nidcCount > 0) { throw new
	 * BOException(MessageCodes.NIDC_DEAL_EXISTS); //'NIDC Details exists,
	 * Please delete those rows and try again }not in the technical
	 */
	// Getting data based on product class
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOMain = iisIslamicCalculatorBO
		.populateOnChangeProductClass(islamicCalculatorEventMgmtCO);

	// 625903 deepu begin
	islamicCalculatorEventMgmtCOMain.setAPPLY_FIX_RATE(ConstantsCommon.NO);
	if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getLimitSerialNo())
		.compareTo(BigDecimal.ZERO) == 1)
	{
	    islamicCalculatorEventMgmtCOMain.setLimitSerialNo(islamicCalculatorEventMgmtCO.getLimitSerialNo());
	    TRSCIFLIMITDETVO trsciflimitdetvo = new TRSCIFLIMITDETVO();
	    trsciflimitdetvo.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsciflimitdetvo.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getBranchCode());
	    trsciflimitdetvo.setCIF(islamicCalculatorEventMgmtCO.getCifNo());
	    trsciflimitdetvo.setSERIAL_NO(islamicCalculatorEventMgmtCO.getLimitSerialNo());
	    trsciflimitdetvo = islamicCalculatorEventMgmtDAO.returnTRSCIFLIMITDETDetails(trsciflimitdetvo);

	    if(trsciflimitdetvo != null)
	    {
		islamicCalculatorEventMgmtCOMain.setProfitCalcMethod(trsciflimitdetvo.getPROFIT_CALCULATION_METHOD());
		islamicCalculatorEventMgmtCOMain.setProfitDistMethod(trsciflimitdetvo.getPROFIT_DIST_METHOD());
		islamicCalculatorEventMgmtCOMain.setPrincipalLast(trsciflimitdetvo.getPRINCIPAL_LAST());
		islamicCalculatorEventMgmtCOMain.setNoOfPayments(trsciflimitdetvo.getNO_OF_PAYMENTS());
		islamicCalculatorEventMgmtCO.setPaymPeriodicity(trsciflimitdetvo.getPAYM_PERIOD_NBR());
		islamicCalculatorEventMgmtCOMain.setRoundingFactor(trsciflimitdetvo.getROUNDING_FACTOR());
		islamicCalculatorEventMgmtCOMain.setPayResAmt(trsciflimitdetvo.getPAY_RES_AMT());
		islamicCalculatorEventMgmtCOMain.setPaymPeriodicity(trsciflimitdetvo.getPAYM_PERIODICITY());
		islamicCalculatorEventMgmtCO.setMargin(trsciflimitdetvo.getMARGIN_RATE());
		islamicCalculatorEventMgmtCOMain.setMargin(trsciflimitdetvo.getMARGIN_RATE());
		if(trsciflimitdetvo.getPAYM_PERIOD_NBR() != null)
		{
		    islamicCalculatorEventMgmtCOMain
			    .setPaymPeriodNbr(new BigDecimal(trsciflimitdetvo.getPAYM_PERIOD_NBR()));
		}
		islamicCalculatorEventMgmtCOMain.setFloatingRate(trsciflimitdetvo.getFLOATING_RATE());
		islamicCalculatorEventMgmtCOMain.setFloatingRateCode(trsciflimitdetvo.getGLOBAL_RATE_CODE());
		islamicCalculatorEventMgmtCOMain.setIborRatePeriodicity(trsciflimitdetvo.getIBOR_PERIODICITY_NUMBER());
		islamicCalculatorEventMgmtCOMain
			.setIborRatePeriodicityType(trsciflimitdetvo.getIBOR_PERIODICITY_TYPE());
		islamicCalculatorEventMgmtCOMain.setPaymPeriodPos(trsciflimitdetvo.getPAYM_PERIOD_POS());

		islamicCalculatorEventMgmtCOMain.setGracePeriodOption(trsciflimitdetvo.getGRACE_PERIOD_OPTION());
		islamicCalculatorEventMgmtCOMain.setGracePeriod(trsciflimitdetvo.getGRACE_PERIOD());
		islamicCalculatorEventMgmtCOMain.setGracePeriodicity(trsciflimitdetvo.getGRACE_PERIODICITY());

		islamicCalculatorEventMgmtCOMain
			.setIBOR_PERIODICITY_TYPE_OLD(trsciflimitdetvo.getIBOR_PERIODICITY_TYPE());

		islamicCalculatorEventMgmtCOMain
			.setIBOR_PERIODICITY_NUMBER_OLD(trsciflimitdetvo.getIBOR_PERIODICITY_NUMBER());

		islamicCalculatorEventMgmtCOMain.setAPPLY_FIX_RATE(
			StringUtil.nullEmptyToValue(trsciflimitdetvo.getAPPLY_FIX_RATE(), ConstantsCommon.NO));
		if(ConstantsCommon.YES.equals(trsciflimitdetvo.getAPPLY_FIX_RATE()))
		{
		    if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCOMain.getProfitUpfront()))
		    {
			islamicCalculatorEventMgmtCOMain
				.setFloatingRate(NumberUtil.emptyDecimalToZero(trsciflimitdetvo.getFIX_RATE()));
			islamicCalculatorEventMgmtCOMain
				.setMargin(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getMargin()));
			islamicCalculatorEventMgmtCOMain
				.setYield(NumberUtil.emptyDecimalToZero(trsciflimitdetvo.getFIX_RATE())
					.add(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getMargin())));
			islamicCalculatorEventMgmtCOMain
				.setAnnualYieldRate(NumberUtil.emptyDecimalToZero(trsciflimitdetvo.getFIX_RATE())
					.add(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getMargin())));
		    }
		    else
		    {
			if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCOMain.getFLOATING_RATE()))
			{
			    islamicCalculatorEventMgmtCOMain.setFloatingRate(trsciflimitdetvo.getFIX_RATE());
			    islamicCalculatorEventMgmtCOMain.setAnnualYieldRate(trsciflimitdetvo.getFIX_RATE());
			}
			else
			{
			    islamicCalculatorEventMgmtCOMain.setAnnualYieldRate(trsciflimitdetvo.getFIX_RATE());
			}
		    }
		}
		else // 679597 start
		{
		    double margin = NumberUtil.toDouble(islamicCalculatorEventMgmtCOMain.getMargin());
		    double floatingRate = NumberUtil.toDouble(islamicCalculatorEventMgmtCOMain.getFloatingRate());
		    islamicCalculatorEventMgmtCOMain.setAnnualYieldRate(BigDecimal.valueOf(floatingRate + margin));
		} // 679597 end
	    }
	}
	// 625903 deepu end

	if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCOMain.getNoOfPayments()).compareTo(BigDecimal.ZERO) != 1)
	{
	    islamicCalculatorEventMgmtCOMain.setNoOfPayments(BigDecimal.ONE);
	}

	// For Bills Claculator
	// 23-06-2015 Sankar
	islamicCalculatorEventMgmtCOMain.setCalculatorType(islamicCalculatorEventMgmtCO.getCalculatorType());

	islamicCalculatorEventMgmtCOMain.setPrefferedLanguage(islamicCalculatorEventMgmtCO.getPrefferedLanguage());

	if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	{

	    if(islamicCalculatorEventMgmtCO.getTrsdealNIDCDETVOList() != null
		    && islamicCalculatorEventMgmtCO.getTrsdealNIDCDETVOList().size() > 0)
	    {
		throw new BOException("Cannot_Proceed_Key",
			"NIDC Details exists, Please delete those rows and try again");
	    }

	    if("I".equals(islamicCalculatorEventMgmtCO.getAccrualAmountType()))
	    {
		throw new BOException("Cannot_Proceed_Key",
			"Cannot Create a Deal as Accrual Amount Type is Installment");
	    }

	    islamicCalculatorEventMgmtCOMain.setAbiDeal("N");
	    if(!"Y".equals(islamicCalculatorEventMgmtCOMain.getBills_yn()))
	    {
		// TP#505837
		throw new BOException(MessageCodes.EMPTY_MESSAGE,
			new String[] { "Cannot_Proceed_Key", "Product Class is not Bill Type" }, false);
	    }

	    /*
	     * commonLibBO.applyDynScreenDisplay(NIDC_DETAILS, null, "VISIBLE",
	     * BigDecimal.ZERO,
	     * islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);
	     */
	    if(islamicCalculatorEventMgmtCOMain.getNoOfPayments() == null)
	    {
		islamicCalculatorEventMgmtCOMain.setNoOfPayments(BigDecimal.ONE);
		commonLibBO.applyDynScreenDisplay("plan_maturity_date", null, "READONLY", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    }
	    if(islamicCalculatorEventMgmtCOMain.getNoOfPayments().compareTo(BigDecimal.ONE) == 1)
	    {
		commonLibBO.applyDynScreenDisplay("plan_maturity_date", null, "READONLY", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    }
	    islamicCalculatorEventMgmtCOMain.setNoOfBills(BigDecimal.ONE);
	    islamicCalculatorEventMgmtCOMain.setNidc("N");
	    commonLibBO.applyDynScreenDisplay(NO_Of_Bills, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(TOTAL_BILL_AMOUNT, null, "READONLY", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(lbl_Total_Bill_Amount, null, "LABEL", "Total_bill_Amount_key",
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(PRICE, null, "VISIBLE", BigDecimal.ZERO,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getNoOfBills()).equals(BigDecimal.ONE))
	    {
		commonLibBO.applyDynScreenDisplay(MATURITY_DATE, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);
	    }
	    else
	    {
		commonLibBO.applyDynScreenDisplay(MATURITY_DATE, null, "VISIBLE", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);
	    }

	    commonLibBO.applyDynScreenDisplay(lbl_Annual_Discount_Rate, null, "LABEL", "Annual_Discount_Rate_key",
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    islamicCalculatorEventMgmtCOMain.setLinkType(BigDecimal.ONE);

	    commonLibBO.applyDynScreenDisplay(LINK_TYPE, null, "READONLY", BigDecimal.ZERO,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    // commonLibBO.applyDynScreenDisplay(NIDC_DETAILS, null, "VISIBLE",
	    // BigDecimal.ZERO,
	    // islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);
	    islamicCalculatorEventMgmtCOMain.setNidc("Y");

	    commonLibBO.applyDynScreenDisplay(MATURITY_DATE, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(PRINT_BTN, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(CREATE_DEAL_BTN, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(LINK_TYPE, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(TRADING_CURRENCY, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(CROSS_RATE, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(TRADING_BILL_AMOUNT, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(Total_Trading_Bill_Amount, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(Margin_Rate, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(Global_Rate, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(Periodicity_NBR, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(profitcalculationdetailsdiv, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(Periodicity_Type, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(Global_rate_code, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(Global_rate_code_desc, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(Periodicity_NBR, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(Periodicity_Type, null, "VISIBLE", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(yield, null, "READONLY", BigDecimal.ZERO,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    // commonLibBO.applyDynScreenDisplay(AnnualFlatRate, null,
	    // "READONLY", BigDecimal.ZERO,
	    // islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(AnnualFlatRate, null, "READONLY", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(TotalFlatRate, null, "READONLY", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    // IslamicCalculatorEventMgmtCO islamicCalculatorIISCtrl =
	    // iisCommonBO.returnIISControlParams(islamicCalculatorEventMgmtCOMain);

	    IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();

	    Boolean ib_linkedtorips = islamicCalculatorEventMgmtDAO.ib_linkedtorips(islamicCalculatorEventMgmtCO);

	    iisctrlvoKey.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisctrlvoKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    IISCTRLVO iisctrlVO = iisCommonBO.returnIISCTRL(iisctrlvoKey);

	    islamicCalculatorEventMgmtCO.setCalcDisableStartDate(
		    StringUtil.nullEmptyToValue(iisctrlVO.getCALC_DISABLE_START_DATE(), ConstantsCommon.NO));
	    if((islamicCalculatorEventMgmtCOMain.getCategory().equals(BigDecimal.valueOf(19))
		    || islamicCalculatorEventMgmtCOMain.getCategory().equals(BigDecimal.valueOf(25))) && ib_linkedtorips
		    && "Y".equals(iisctrlVO.getINV_DEAL_SHOW_CONTRIB_DETAILS()))

	    {

		// islamicCalculatorEventMgmtCO.setHideRateYn("Y");

		islamicCalculatorEventMgmtCOMain.setNidc("Y");

		commonLibBO.applyDynScreenDisplay(portfolio_cif, null, "VISIBLE", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(portfolio_seq, null, "VISIBLE", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(portfolio_name, null, "VISIBLE", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(BROKER_CODE, null, "VISIBLE", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(BROKER_NAME, null, "VISIBLE", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(BillAmount, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(NOfBills, null, "READONLY", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(Accural_Basis, null, "READONLY", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(interestCalculationMethod, null, "READONLY", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(PaymPeriodNbr, null, "READONLY", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		// commonLibBO.applyDynScreenDisplay(CALCULATE_BTN, null,
		// "VISIBLE", BigDecimal.ZERO,
		// islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		// TODO
		// ls_value =
		// "Investment With Trade & P.I.~t1/Investment Without Trade &
		// With P.I.~t2/Investment Without Trade & P.I.~t4/Investment
		// With Trade & Without P.I.~t5"
		// dw_calc.Object.li_link_type.Values = ls_Value

		commonLibBO.applyDynScreenDisplay(TRADING_CURRENCY, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(TRADING_CURRENCY_DEC, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(CROSS_RATE, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(TRADING_BILL_AMOUNT, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(Total_Trading_Bill_Amount, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(Margin_Rate, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(Global_Rate, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(Periodicity_NBR, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(Periodicity_Type, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(Global_rate_code, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(Global_rate_code_desc, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(profitcalculationdetailsdiv, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(Tenor, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(TenorType, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(yield, null, "READONLY", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		// commonLibBO.applyDynScreenDisplay(AnnualFlatRate, null,
		// "READONLY", BigDecimal.ZERO,
		// islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		islamicCalculatorEventMgmtCOMain.setLinkType(BigDecimal.valueOf(2));

		if(islamicCalculatorEventMgmtCOMain.getNidc().equals("Y"))
		{
		    islamicCalculatorEventMgmtCOMain.setNidc("Y");

		    commonLibBO.applyDynScreenDisplay(NO_Of_Bills, null, "VISIBLE", BigDecimal.ZERO,
			    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		    commonLibBO.applyDynScreenDisplay(TOTAL_BILL_AMOUNT, null, "READONLY", BigDecimal.ZERO,
			    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		    commonLibBO.applyDynScreenDisplay(lbl_Total_Bill_Amount, null, "LABEL", "Total_Face_Val_key",
			    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		    commonLibBO.applyDynScreenDisplay(PRICE, null, "VISIBLE", BigDecimal.ONE,
			    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		    commonLibBO.applyDynScreenDisplay(MATURITY_DATE, null, "READONLY", BigDecimal.ZERO,
			    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		    commonLibBO.applyDynScreenDisplay(lbl_Annual_Discount_Rate, null, "LABEL", "Annual_Profit_Rate_key",
			    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		    // TO DO
		    // ls_value =
		    // "Investment Without Trade & With P.I.~t2/Investment
		    // Without Trade & P.I.~t4";
		    // String invTraWo = "InWoT";
		    // repaymentplanBOImpl applyProfitProfitDistMethodList
		    // islamicCalculatorEventMgmtCOMain
		    // islamicCalculatorEventMgmtCOMain.setLinkType(BigDecimal.valueOf(2));

		    createDealLov(islamicCalculatorEventMgmtCOMain);

		    commonLibBO.applyDynScreenDisplay(LINK_TYPE, null, "READONLY", BigDecimal.ZERO,
			    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		}
		else

		{
		    // islamicCalculatorEventMgmtCOMain.setAbiDeal("Y");
		    islamicCalculatorEventMgmtCOMain.setNidc("Y");

		    commonLibBO.applyDynScreenDisplay(MATURITY_DATE, null, "READONLY", BigDecimal.ZERO,
			    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		    commonLibBO.applyDynScreenDisplay(PRINT_BTN, null, "VISIBLE", BigDecimal.ZERO,
			    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		    commonLibBO.applyDynScreenDisplay(CREATE_DEAL_BTN, null, "VISIBLE", BigDecimal.ZERO,
			    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		    commonLibBO.applyDynScreenDisplay(LINK_TYPE, null, "VISIBLE", BigDecimal.ZERO,
			    islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		}

	    }
	    else
	    {

		// islamicCalculatorEventMgmtCO.setHideRateYn("N");
		islamicCalculatorEventMgmtCOMain.setNidc("N");
		/*
		 * commonLibBO.applyDynScreenDisplay(TRADING_CURRENCY, null,
		 * "VISIBLE", BigDecimal.ONE,
		 * islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);
		 */
		// islamicCalculatorEventMgmtCOMain.setLinkType(BigDecimal.valueOf(4));
		createDealLov(islamicCalculatorEventMgmtCOMain);
		commonLibBO.applyDynScreenDisplay(Tenor, null, "VISIBLE", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(TenorType, null, "VISIBLE", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(TOTAL_BILL_AMOUNT, null, "READONLY", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(portfolio_cif, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(portfolio_seq, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(portfolio_name, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(BROKER_CODE, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(BROKER_NAME, null, "VISIBLE", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(BillAmount, null, "VISIBLE", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(NOfBills, null, "READONLY", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(Accural_Basis, null, "READONLY", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(interestCalculationMethod, null, "READONLY", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(PaymPeriodNbr, null, "READONLY", BigDecimal.ZERO,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		commonLibBO.applyDynScreenDisplay(yield, null, "READONLY", BigDecimal.ONE,
			islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		// commonLibBO.applyDynScreenDisplay(AnnualFlatRate, null,
		// "READONLY", BigDecimal.ONE,
		// islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

		// commonLibBO.applyDynScreenDisplay(CALCULATE_BTN, null,
		// "VISIBLE", BigDecimal.ONE,
		// islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);

	    }
	}
	if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType())
		|| IISCommonConstants.ISLAMIC_CALCULATOR_AR_RAHANU
			.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	{
	    if(NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCOMain.getNoOfPayments()))
	    {
		islamicCalculatorEventMgmtCOMain.setNoOfPayments(BigDecimal.ONE);
	    }

	    islamicCalculatorEventMgmtCO.setNoOfPayments(islamicCalculatorEventMgmtCOMain.getNoOfPayments());
	    islamicCalculatorEventMgmtCO.setNoOfBills(islamicCalculatorEventMgmtCOMain.getNoOfPayments());
	    islamicCalculatorEventMgmtCO.setAccrualBasis(islamicCalculatorEventMgmtCOMain.getAccrualBasis());
	    islamicCalculatorEventMgmtCOMain.setPaymPeriodNbr(BigDecimal.ONE);
	    islamicCalculatorEventMgmtCOMain.setPaymPeriodicity("M");
	    islamicCalculatorEventMgmtCOMain.setPaymPeriodPos("D");
	    islamicCalculatorEventMgmtCOMain.setGracePeriod(BigDecimal.ONE);
	    islamicCalculatorEventMgmtCOMain.setGracePeriodicity("M");

	    // dw_calc.SetItem(1,'rounding_factor',0)
	    // dw_calc.SetItem(1,'grace_period_option',1)
	    // dw_calc.SetItem(1,'commencement_date',ldt_value_date)
	    // dw_calc.SetItem(1,'pay_res_amt','L')
	    // If IsNull(ll_payments) Or ll_payments < 1 Then ll_payments = 1
	}

	// Checking the amount type
	if(StringUtil.nullToEmpty(islamicCalculatorEventMgmtCOMain.getAccrualAmountType())
		.equals(IISCommonConstants.ACCRUAL_AMOUNT_TYPE_INSTALLMENT))
	{
	    throw new BOException(MessageCodes.DEAL_AS_ACCRUAL_AMT_TYPE_IS_INSTALLMENT);
	}
	// ////////////////////////PARAMETERS NEED TO GET FROM
	// SCREEN///////////////////////////////////
	islamicCalculatorEventMgmtCOMain.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	islamicCalculatorEventMgmtCOMain.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	islamicCalculatorEventMgmtCOMain.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	// Need to get the below values from the screen
	islamicCalculatorEventMgmtCOMain.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	islamicCalculatorEventMgmtCOMain.setRunningDate(islamicCalculatorEventMgmtCO.getRunningDate());
	islamicCalculatorEventMgmtCOMain.setCommencementDate(islamicCalculatorEventMgmtCO.getStartDate());
	islamicCalculatorEventMgmtCOMain.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
	islamicCalculatorEventMgmtCOMain.setPurchaseAmount(islamicCalculatorEventMgmtCO.getPurchaseAmount());
	islamicCalculatorEventMgmtCOMain.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	islamicCalculatorEventMgmtCOMain.setFirstPaymentDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	// islamicCalculatorEventMgmtCOMain.setFloatingRateCode(islamicCalculatorEventMgmtCO.getFloatingRateCode());
	if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCOMain.getFloatingRateCode())
		.compareTo(BigDecimal.ZERO) == 1)
	{

	    IBOR_HDRVO iborHDRVO = new IBOR_HDRVO();
	    iborHDRVO.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    iborHDRVO.setIBOR_CODE(islamicCalculatorEventMgmtCOMain.getFloatingRateCode());

	    iborHDRVO = islamicCalculatorEventMgmtDAO.returnFloatingRateCodeById(iborHDRVO);
	    if(iborHDRVO != null)
	    {
		islamicCalculatorEventMgmtCOMain.setFloatingRateCodeDesc(iborHDRVO.getBRIEF_DESC_ENG());
	    }
	}

	// added for cases when the template code is available in product class.
	if(islamicCalculatorEventMgmtCOMain.getRepaymentTemplate() != null
		&& NumberUtil.toInt(islamicCalculatorEventMgmtCOMain.getRepaymentTemplate()) > 0)
	{
		TRSPAYPLANTMPLTVO trspayplantmpltvo = new TRSPAYPLANTMPLTVO();
		trspayplantmpltvo.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
		trspayplantmpltvo.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getBranchCode());
		trspayplantmpltvo.setTEMPLATE_CODE(islamicCalculatorEventMgmtCOMain.getRepaymentTemplate());
		trspayplantmpltvo = (TRSPAYPLANTMPLTVO) genericDAO.selectByPK(trspayplantmpltvo);
		if(trspayplantmpltvo != null ){
			islamicCalculatorEventMgmtCO.setTempCodeDesc(trspayplantmpltvo.getBRIEF_NAME_ENG());
			islamicCalculatorEventMgmtCOMain.setTempCodeDesc(trspayplantmpltvo.getBRIEF_NAME_ENG());
		}
	    islamicCalculatorEventMgmtCO.setTempCode(islamicCalculatorEventMgmtCOMain.getRepaymentTemplate());
	    islamicCalculatorEventMgmtCOMain.setTempCode(islamicCalculatorEventMgmtCOMain.getRepaymentTemplate());
	}

	// Added bec yield was coming null from client side--- 10-7-2013
	islamicCalculatorEventMgmtCOMain.setYield(islamicCalculatorEventMgmtCO.getYield());
	islamicCalculatorEventMgmtCOMain.setFinancingAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	// Added the VAT values by Linchu for issue on 20/06/2013

	// To set the VAT desc and percentage. 089132: In Java Calculator the
	// Profit calc
	// method is straight Line (defaulted) were in IIS the same is
	// diminishing returns
	// Added by Linchu fro Navas to show the VAT fields
	islamicCalculatorEventMgmtCOMain.setShowVat(islamicCalculatorEventMgmtCOMain.getVatApplicable());
	islamicCalculatorEventMgmtCOMain = populateOnChangeVatCode(islamicCalculatorEventMgmtCOMain);

	// down payment percentage needs to set in orginal down payment and down
	// pay perc
	// ////////////////////////PARAMETERS NEED TO GET FROM
	// SCREEN///////////////////////////////////
	// int holidayAction =
	// islamicCalculatorEventMgmtCOMain.getHolidayAction().intValue();
	// Date valueDate = islamicCalculatorEventMgmtCOMain.getStartDate();
	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setCompCode(islamicCalculatorEventMgmtCOMain.getCompCode());
	iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCOMain.getBranchCode());
	iisCommonCO.setNoOfPayments(islamicCalculatorEventMgmtCOMain.getNoOfPayments());

	// uf_check_currency_holiday will write by manoj
	// Date holidayDate =
	// uf_check_currency_holiday(valueDate,'V',islamicCalculatorEventMgmtCOMain.getCurrencyCode(),holidayAction,islamicCalculatorEventMgmtCO.getProductClass(),holidayActionDealvalueDateYn);

	//
	if(StringUtil.isEmptyString(islamicCalculatorEventMgmtCOMain.getProfitCalcMethod()))
	{
	    islamicCalculatorEventMgmtCOMain.setProfitCalcMethod("S");
	}
	if(StringUtil.isEmptyString(islamicCalculatorEventMgmtCOMain.getProfitDistMethod()))
	{
	    islamicCalculatorEventMgmtCOMain
		    .setProfitDistMethod(islamicCalculatorEventMgmtCOMain.getProfitCalcMethod());
	}
	Date holidayDate = islamicCalculatorEventMgmtCO.getRunningDate();
	if(islamicCalculatorEventMgmtCOMain.getStartDate() != holidayDate)
	{
	    islamicCalculatorEventMgmtCOMain.setStartDate(holidayDate);
	}

	// need to set the value date here in commencement

	// calling the grace_periodicity item changed event for setting the
	// maturity date
	// islamicCalculatorEventMgmtCOMain.setMaturityDate(DateUtil.createDate(2111,
	// 12, 31));
	IISCommonCO iisCommonCO1 = new IISCommonCO();
//	iisCommonCO1.setNoOfPayments(
//		NumberUtil.nullToZero(islamicCalculatorEventMgmtCOMain.getNoOfPayments()).add(BigDecimal.ONE));
	iisCommonCO1.setNoOfPayments(
			NumberUtil.nullToZero(islamicCalculatorEventMgmtCOMain.getNoOfPayments()));
	iisCommonCO1.setPaymPeriodicity(islamicCalculatorEventMgmtCOMain.getPaymPeriodicity());
	iisCommonCO1.setPaymPeriodNbr(islamicCalculatorEventMgmtCOMain.getPaymPeriodNbr());
	iisCommonCO1.setPaymPeriodPos(islamicCalculatorEventMgmtCOMain.getPaymPeriodPos());
	// iisCommonCO1.setValue("COMMENCE");
	iisCommonCO1.setStartDate(islamicCalculatorEventMgmtCOMain.getStartDate());
	iisCommonCO1.setFirstPayDate(islamicCalculatorEventMgmtCOMain.getFirstPaymentDate());
	iisCommonCO1.setCompCode(islamicCalculatorEventMgmtCOMain.getCompCode());
	iisCommonCO1.setBranchCode(islamicCalculatorEventMgmtCOMain.getBranchCode());
	String calcMatDte = StringUtil.nullEmptyToValue(iisCommonBO.returnCalcMatDteFlagValue(iisCommonCO), "N");
	if("Y".equals(calcMatDte))
	{
	    iisCommonCO1.setPaymPeriodPos("D");
	}
	iisCommonCO1 = iisCommonBO.returnMaturitydate(iisCommonCO1);

	// islamicCalculatorEventMgmtCOMain.setMaturityDate(islamicCalculatorEventMgmtCO.getRunningDate());
	islamicCalculatorEventMgmtCOMain.setMaturityDate(iisCommonCO1.getMaturityDate());

	Date valuDate = islamicCalculatorEventMgmtCO.getStartDate();
	Date maturityDate = iisCommonCO1.getMaturityDate();
	// TP #518627

	if(islamicCalculatorEventMgmtCOMain.getMaturityDate() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MATURITY_DATE);
	}
	if(islamicCalculatorEventMgmtCOMain.getStartDate() == null)
	{
	    throw new BOException(MessageCodes.INVALID_VALUE_DATE);
	}

	long periodicityNbr = DateUtil.numberOfDays(valuDate, maturityDate);

	islamicCalculatorEventMgmtCOMain.setPeriodicityNbr(BigDecimal.valueOf(periodicityNbr));

	// TP#225019; Ramesh ; 09/10/2014 [START]
	TRSCLASSVOKey trsclassvoKey = new TRSCLASSVOKey();
	trsclassvoKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	trsclassvoKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	TRSCLASSVO trsClassVO = iisCommonDAO.getGracePeriodClass(trsclassvoKey);

	BigDecimal classGracePeriod = null;
	String classGracePeriodicity = null;
	if(trsClassVO != null)
	{
	    classGracePeriod = trsClassVO.getGRACE_PERIOD_MAX_NBR();
	    classGracePeriodicity = trsClassVO.getGRACE_PERIOD_MAX_TYPE();
	}

	if(classGracePeriod == null)
	{
	    classGracePeriod = BigDecimal.ZERO;
	}
	if(classGracePeriodicity == null)
	{
	    classGracePeriodicity = "D";
	}
	// if(NumberUtil.toInt(classGracePeriod) <= 0)
	// {
	// return iisCommonCO;
	// }
	int periodicityNo = 0;
	periodicityNo = calculatePeriodicity(classGracePeriodicity, classGracePeriod.intValue());
	classGracePeriod = BigDecimal.valueOf(periodicityNo);
	BigDecimal gracePeriod = islamicCalculatorEventMgmtCOMain.getGracePeriod();
	String gracePeriodicity = islamicCalculatorEventMgmtCOMain.getGracePeriodicity();
	if(gracePeriod == null)
	{
	    gracePeriod = BigDecimal.ZERO;
	}
	if(gracePeriodicity == null)
	{
	    gracePeriodicity = "D";
	}
	periodicityNo = calculatePeriodicity(gracePeriodicity, gracePeriod.intValue());
	gracePeriod = BigDecimal.valueOf(periodicityNo);
	if(NumberUtil.toInt(classGracePeriod) > 0
		&& (classGracePeriodicity != null && classGracePeriodicity.trim().length() > 0)
		&& NumberUtil.toInt(gracePeriod) > NumberUtil.toInt(classGracePeriod))
	{

	    islamicCalculatorEventMgmtCOMain.setGracePeriod(classGracePeriod);
	    islamicCalculatorEventMgmtCOMain.setGracePeriodicity("D");

	}
	
	/**
		 * Added By Manoj on 14/12/2016 for BMOI160002 <Start>
		 */
		if (BigDecimal.ONE.compareTo(islamicCalculatorEventMgmtCOMain.getGracePeriodOption()) == 0 && "D".equals(islamicCalculatorEventMgmtCOMain.getPaymPeriodPos()))
		{
			IISCommonCO commonCO = new IISCommonCO();
			commonCO.setCompCode(islamicCalculatorEventMgmtCOMain.getCompCode());
			commonCO.setBranchCode(islamicCalculatorEventMgmtCOMain.getBranchCode());
			commonCO.setProductClass(islamicCalculatorEventMgmtCOMain.getProductClass());
			commonCO.setValueDate(islamicCalculatorEventMgmtCOMain.getValueDate()== null ? 
					islamicCalculatorEventMgmtCOMain.getRunningDate(): islamicCalculatorEventMgmtCOMain.getValueDate() );
			commonCO.setFirstPayDate(islamicCalculatorEventMgmtCOMain.getFirstPaymentDate());
			commonCO.setGracePeriod(islamicCalculatorEventMgmtCOMain.getGracePeriod());
			commonCO.setGracePeriodicity(islamicCalculatorEventMgmtCOMain.getGracePeriodicity());
			
			commonCO = iisCommonBO.returnFirstPaymentDateByCutoffDay(commonCO);
			islamicCalculatorEventMgmtCOMain.setFirstPaymentDate(commonCO.getFirstPayDate());
			islamicCalculatorEventMgmtCOMain.setGracePeriodicity(commonCO.getGracePeriodicity());
			islamicCalculatorEventMgmtCOMain.setGracePeriod(commonCO.getGracePeriod());
		}
		/**
		 * Added By Manoj on 14/12/2016 for BMOI160002 <End>
		 */
		 
	// TP#225019; Ramesh ; 09/10/2014 [END]
	// TP#237333; Ramesh; Date 05/11/2014 [Added Below IF]
	if(islamicCalculatorEventMgmtCOMain.getNoOfPayments() != null)
	{
	    //Date maturityDateOrg = islamicCalculatorEventMgmtCOMain.getMaturityDate();
	    islamicCalculatorEventMgmtCOMain.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	    islamicCalculatorEventMgmtCOMain = iisIslamicCalculatorBO
		    .populateOnChangeFirstPaymentAfterPeriodicity(islamicCalculatorEventMgmtCOMain);
	    //islamicCalculatorEventMgmtCOMain.setMaturityDate(maturityDateOrg);
	 }
	IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCOMain.getCompCode());
	iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCOMain.getBranchCode());
	iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCOMain.getProductClass());
	iisDealChargesCO.setCifNo(islamicCalculatorEventMgmtCOMain.getCifNo());
	iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCOMain.getMaturityDate());
	iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCOMain.getStartDate());
	iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCOMain.getCurrencyCode());
	iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());// Changed
	// the Co object taken from screen as finacing amt shud be taken from
	// screen.Linchu 04-10-2012
	iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCOMain.getBaseCurrencyCode());
	iisDealChargesCO.setCallType("P");// Product Class
	islamicCalculatorEventMgmtCOMain.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	if(islamicCalculatorEventMgmtCOMain.getTrsDealChargesVO().size() > 0)
	{
	    for(TrsDealChargesCO trsDealChargesCO : islamicCalculatorEventMgmtCOMain.getTrsDealChargesVO())
	    {
		trsDealChargesCO.setCOLLECT_CHARGES_ACCOUNT_TYPE(
			StringUtil.nullEmptyToValue(trsDealChargesCO.getCOLLECT_CHARGES_ACCOUNT_TYPE(), "C"));
	    }
	}

	// TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement and reschedule
	// charges

	List<TrsDealSettlementChargesCO> productClassSettlementChargesList = islamicCalculatorEventMgmtDAO
		.returnClassSettlementCharges(islamicCalculatorEventMgmtCO);

	islamicCalculatorEventMgmtCOMain.setTrsDealSettlementChargesCO(productClassSettlementChargesList);

	// TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement and reschedule
	// charges

	if(NumberUtil.toInt(islamicCalculatorEventMgmtCO.getTempCode()) > 0)
	{
	    islamicCalculatorEventMgmtCOMain = populateOnChangeTemplateCode(islamicCalculatorEventMgmtCOMain);
	}

	iisDealChargesCO = null;
	if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getCifNo()).intValue() > 0)
	{
	    iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	    iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    List<IslamicCalculatorDBRatioSC> vectDBRatio = iisCommonBO.calculateDBRatio(iisCommonCO);
	    if(!vectDBRatio.isEmpty())
	    {
		IslamicCalculatorDBRatioSC dbRatioSC = vectDBRatio.get(vectDBRatio.size() - 1);
		islamicCalculatorEventMgmtCO.setDebtBurdanRatio(dbRatioSC.getDbrAmount());
	    }
	}
	// TP#245197;Ravikant.Singh ;01/12/2014
	islamicCalculatorEventMgmtCO
		.setProductClass(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getProductClass()));
	trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	if(trsClassVO != null)
	{
	    islamicCalculatorEventMgmtCOMain.setProfitUpfront(trsClassVO.getPROFIT_UPFRONT());
	    islamicCalculatorEventMgmtCOMain.setFLOATING_RATE(trsClassVO.getFLOATING_RATE());

	    // TP#247336;Arun.R.Variyath;10/12/2014
	    islamicCalculatorEventMgmtCOMain.setMusawamahYN(trsClassVO.getMUSAWAMAH_YN());
	}
	// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
	islamicCalculatorEventMgmtCOMain.setAllowFlexiPaymentsYN(trsClassVO.getALLOW_FLEXI_PAYMENTS_YN());
	// BB160136; Saheer.Naduthodi; 20/04/2017 [End]
	/**
	 * TP 253158 -Renaming by product category - Sreejith
	 */
	IISCommonCO commonCO = new IISCommonCO();
	commonCO.setProgRef(islamicCalculatorEventMgmtCO.getPageRef());
	commonCO.setAppName(islamicCalculatorEventMgmtCO.getAppName());
	islamicCalculatorEventMgmtCOMain.setHmSysParam(applyLabelByProductClass(
		islamicCalculatorEventMgmtCO.getCompCode(), islamicCalculatorEventMgmtCO.getProductClass(),
		iisCommonDAO.returnParentRef(commonCO), islamicCalculatorEventMgmtCOMain.getHmSysParam()));

	// TP 253158 -Renaming by product category - Sreejith end
	// BB150217 - Rescheduling and Loan Buyout CR105585
	if(trsClassVO != null && ConstantsCommon.YES.equals(trsClassVO.getTRANS_VENDOR_AMT_TO_CUSTOMER()))
	{
	    commonLibBO.applyDynScreenDisplay(IISCommonConstants.TYPE, null, IISCommonConstants.ACTION_TYPE_VISIBLE,
		    BigDecimal.ONE, islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);
	    commonLibBO.applyDynScreenDisplay(IISCommonConstants.TYPEBTN, null, IISCommonConstants.ACTION_TYPE_VISIBLE,
		    BigDecimal.ONE, islamicCalculatorEventMgmtCOMain.getHmSysParam(), null);
	}

	trsclassvoKey = null;
	trsClassVO = null;

	return islamicCalculatorEventMgmtCOMain;
    }

    /**
     * TP 253158 -Renaming by product category - Sreejith
     * 
     * @param compCode
     * @param classCode
     * @param progRef
     * @param hm
     * @return
     * @throws BaseException
     * @author AK
     */
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> applyLabelByProductClass(BigDecimal compCode,
	    BigDecimal classCode, String progRef, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm) throws BaseException
    {
	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setCompCode(compCode);
	iisCommonCO.setClassCode(classCode);
	iisCommonCO.setProgRef(progRef);
	List<TRSCLASS_KEY_LABELVO> trsClassLabelVOList = iisCommonDAO.returnTrsClassLabelVOData(iisCommonCO);
	SYS_PARAM_SCREEN_DISPLAYVO vo = new SYS_PARAM_SCREEN_DISPLAYVO();
	List<LabelElemCO> lblLst = new ArrayList<LabelElemCO>();
	for(TRSCLASS_KEY_LABELVO trsclasslabelvo : trsClassLabelVOList)
	{
	    if(StringUtil.nullEmptyToValue(trsclasslabelvo.getGRID_RELATED_YN(), ConstantsCommon.NO)
		    .equals(ConstantsCommon.NO))
	    {
		commonLibBO.applyDynScreenDisplay(trsclasslabelvo.getFIELD_NAME(), null, "LABEL",
			trsclasslabelvo.getKEY_LABEL_CODE(), hm, null);
	    }
	    else
	    {
		String[] gridName = null;
		if(!"".equals(StringUtil.nullToEmpty(trsclasslabelvo.getFIELD_NAME())))
		{
		    gridName = trsclasslabelvo.getFIELD_NAME().split("_" + trsclasslabelvo.getPROG_REF() + "_");

		    LabelElemCO co = new LabelElemCO();
		    co.setElementId(gridName[0]);
		    co.setGridColName(gridName[1]);
		    co.setValue(trsclasslabelvo.getKEY_LABEL_CODE());
		    lblLst.add(co);
		    vo.setLabelsLst(lblLst);
		    hm.put(gridName[0], vo);
		}
	    }
	}
	return hm;
    }

    public IslamicCalculatorEventMgmtCO createDealLov(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {

	CommonLibSC sc = new CommonLibSC();
	sc.setAppName("IMAL");
	sc.setProgRef("ROOT");
	sc.setLanguage(islamicCalculatorEventMgmtCO.getPrefferedLanguage());

	if(!islamicCalculatorEventMgmtCO.getLinkTypeList().isEmpty())
	{
	    islamicCalculatorEventMgmtCO.getLinkTypeList().clear();
	}
	SelectCO linkType = new SelectCO();
	// if(islamicCalculatorEventMgmtCO.getLinkType().compareTo(BigDecimal.valueOf(2))
	// == 0)
	if("Y".equals(islamicCalculatorEventMgmtCO.getNidc()))
	{
	    sc.setKeyLabelCode("Invest_Without_trade_with_PI_key");
	    linkType.setCode("4");
	    linkType.setDescValue(commonLibBO.returnKeyLabelTrans(sc));
	    islamicCalculatorEventMgmtCO.getLinkTypeList().add(linkType);

	    sc.setKeyLabelCode("Invest_Without_trade_And_with_PI_key");
	    linkType = new SelectCO();
	    linkType.setCode("2");
	    linkType.setDescValue(commonLibBO.returnKeyLabelTrans(sc));
	    islamicCalculatorEventMgmtCO.getLinkTypeList().add(linkType);
	}
	else if("N".equals(islamicCalculatorEventMgmtCO.getNidc()))
	{

	    sc.setKeyLabelCode("Invest_With_trade_PI_key");
	    linkType.setCode("1");
	    linkType.setDescValue(commonLibBO.returnKeyLabelTrans(sc));
	    islamicCalculatorEventMgmtCO.getLinkTypeList().add(linkType);

	    sc.setKeyLabelCode("Invest_Without_trade_And_with_PI_key");
	    linkType = new SelectCO();
	    linkType.setCode("2");
	    linkType.setDescValue(commonLibBO.returnKeyLabelTrans(sc));
	    islamicCalculatorEventMgmtCO.getLinkTypeList().add(linkType);

	    sc.setKeyLabelCode("Invest_Without_trade_with_PI_key");
	    linkType = new SelectCO();
	    linkType.setCode("4");
	    linkType.setDescValue(commonLibBO.returnKeyLabelTrans(sc));
	    islamicCalculatorEventMgmtCO.getLinkTypeList().add(linkType);

	    sc.setKeyLabelCode("Invest_With_trade_without_PI_key");
	    linkType = new SelectCO();
	    linkType.setCode("5");
	    linkType.setDescValue(commonLibBO.returnKeyLabelTrans(sc));
	    islamicCalculatorEventMgmtCO.getLinkTypeList().add(linkType);

	}

	return islamicCalculatorEventMgmtCO;
    }

    /*
     * public IslamicCalculatorEventMgmtCO
     * createDealLov(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
     * throws BaseException { List<SelectCO> SelectCOList; SelectSC selSC = new
     * SelectSC(new BigDecimal(46)); //
     * selSC.setLanguage(islamicCalculatorEventMgmtCO.getLanguage());
     * SelectCOList = commonLibBO.returnLOV(selSC);
     * 
     * List<SelectCO> SelectCONewList = new ArrayList<SelectCO>(); for(SelectCO
     * selectCO2 : SelectCOList) {
     * if(islamicCalculatorEventMgmtCO.getPROFIT_CALCULATION_METHOD
     * ().equals("R") && (selectCO2.getCode().endsWith("R") ||
     * selectCO2.getCode().endsWith("L") || selectCO2.getCode() .endsWith("I")))
     * { SelectCONewList.add(selectCO2); } else
     * if(repaymentPlanGridCO.getTrspayplanVO
     * ().getPROFIT_CALCULATION_METHOD().equals("S") &&
     * (selectCO2.getCode().endsWith("S") || selectCO2.getCode().endsWith("L")
     * || selectCO2.getCode() .endsWith("I"))) { SelectCONewList.add(selectCO2);
     * }
     * 
     * }
     * 
     * return islamicCalculatorEventMgmtCO; }
     */

    /**
     * @author Ramesh.Lekkala
     * @param paymPeriodicity
     * @param noOfpayments
     * @return
     */
    // TP#225019; Ramesh ; 09/10/2014
    private int calculatePeriodicity(String paymPeriodicity, int noOfpayments)
    {
	if(paymPeriodicity.equals(IISCommonConstants.DAY))
	{
	    return noOfpayments * 1;
	}
	else if(paymPeriodicity.equals(IISCommonConstants.WEEK))
	{
	    return noOfpayments * 7;
	}
	else if(paymPeriodicity.equals(IISCommonConstants.MONTH))
	{
	    return noOfpayments * 31;
	}
	else if(paymPeriodicity.equals(IISCommonConstants.YEAR))
	{
	    return noOfpayments * 365;
	}
	else
	{
	    return 0;
	}
    }

    /**
     * Method for on change event of currency code
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeCurrencyCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	// islamicCalculatorEventMgmtCO.setCurrencyCode(new
	// BigDecimal(1));//need to comment
	if(NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyCode()) <= 0)
	{
	    return islamicCalculatorEventMgmtCO;
	}
	BigDecimal currencyCount = islamicCalculatorEventMgmtDAO.isCurrencyExist(islamicCalculatorEventMgmtCO);

	if(currencyCount == null || currencyCount.intValue() == 0)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_DEAL_CURRENCY);
	}
	// set the description of currency
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	String currencyDesc = islamicCalculatorEventMgmtDAO.getCurrencyDesc(islamicCalculatorEventMgmtCO);
	islamicCalculatorEventMgmtCO.setCurrencyDesc(currencyDesc);

	if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	{
	    islamicCalculatorEventMgmtCO = billsCalculatorCurrencyCode(islamicCalculatorEventMgmtCO);
	}
	if(islamicCalculatorEventMgmtCO.getTrsDealChargesVO() != null
		&& !islamicCalculatorEventMgmtCO.getTrsDealChargesVO().isEmpty())
	{
	    if(islamicCalculatorEventMgmtCO.getTrsDealChargesVO().size() > 0)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId("1700");
		return islamicCalculatorEventMgmtCO;
	    }
	    // To calculate the Charges

	    BigDecimal cifNo = islamicCalculatorEventMgmtCO.getCifNo();
	    IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	    iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisDealChargesCO.setCifNo(cifNo);
	    iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	    iisDealChargesCO.setIisTrsdealchargesCO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    iisDealChargesCO.setCallType("P");// Product Class
	    // To set the Charges list from the screen
	    islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	    // To calculate the Yield
	    IISCommonCO iisCommonCO = iisIslamicCalculatorBO.calculateYield(islamicCalculatorEventMgmtCO);
	    // Added for yield not set properly
	    if(iisCommonCO.getOrginalYield() != null && iisCommonCO.getOrginalYield().compareTo(BigDecimal.ZERO) == 1)
	    {
		islamicCalculatorEventMgmtCO.setYield(iisCommonCO.getOrginalYield());
		islamicCalculatorEventMgmtCO.setMargin(iisCommonCO.getOrginalYield());
	    }

	    iisDealChargesCO = null;
	    iisCommonCO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO billsCalculatorCurrencyCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	islamicCalculatorEventMgmtCO.getCurrencyCode();

	if("N".equals(islamicCalculatorEventMgmtCO.getPriceUserTypedYN()))
	{
	    iisCommonBO.applyBillsCalculatorYield(islamicCalculatorEventMgmtCO);
	}
	else
	{
	    iisCommonBO.applyPriceSetCalculator(islamicCalculatorEventMgmtCO);

	}

	islamicCalculatorEventMgmtCO = crossRateBillsCalculator(islamicCalculatorEventMgmtCO);

	islamicCalculatorEventMgmtCO.setCrossRate(islamicCalculatorEventMgmtCO.getCrossRate());
	islamicCalculatorEventMgmtCO.setBillAmount(BigDecimal.ZERO);
	islamicCalculatorEventMgmtCO.setTotalBillAmount(BigDecimal.ZERO);
	islamicCalculatorEventMgmtCO.setAmountPerPayment(BigDecimal.ZERO);
	islamicCalculatorEventMgmtCO.setTradingBillAmount(BigDecimal.ZERO);

	if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getHideRateYn()) || NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getFloatingRateCode()).compareTo(BigDecimal.ONE) == 1)
	{

	    TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	    BigDecimal loGlobalRateCode = trsClassVO.getRATE_TYPE();
	    BigDecimal loIborPeriodicityNumber = trsClassVO.getIBOR_PERIODICITY_NUMBER();
	    String loIborPeriodicityType = trsClassVO.getIBOR_PERIODICITY_TYPE();
	    if(NumberUtil.isEmptyDecimal(loGlobalRateCode))
	    {
		loGlobalRateCode = BigDecimal.ZERO;
	    }

	    if(loGlobalRateCode.compareTo(BigDecimal.ZERO) > 0)
	    {

		islamicCalculatorEventMgmtCO.setFloatingRateCode(loGlobalRateCode);
		islamicCalculatorEventMgmtCO.setIborRatePeriodicity(loIborPeriodicityNumber);
		islamicCalculatorEventMgmtCO.setIborRatePeriodicityType(loIborPeriodicityType);

	    }

	    // TODO
	    /*
	     * 
	     * This.SEtColumn("global_rate_code")
	     * This.TriggerEvent(ItemChanged!) End IF End IF End IF
	     */
	}

	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO crossRateBillsCalculator(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	IISCommonCO iisCommonCO = new IISCommonCO();
	if(islamicCalculatorEventMgmtCO.getValueDate() != null
		|| NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTradingCurrency())
			.compareTo(BigDecimal.ZERO) > 0
		|| NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getCurrencyCode())
			.compareTo(BigDecimal.ZERO) > 0)

	{
	    if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTradingCurrency())
		    .compareTo(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getCurrencyCode())) != 0)
	    {
		iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
		iisCommonCO.setTrCurrency(islamicCalculatorEventMgmtCO.getTradingCurrency());
		// TP #475288
		iisCommonCO.setPfCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
		iisCommonCO.setCrossDate(islamicCalculatorEventMgmtCO.getValueDate());
		iisCommonCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
		iisCommonCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
		iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);

		/*
		 * if(iisCommonCO.getCrossRate().compareTo(BigDecimal.ONE) == 1)
		 * { islamicCalculatorEventMgmtCO.setCrossRate(BigDecimal.ONE);
		 * } else
		 */

		if(NumberUtil.emptyDecimalToZero(iisCommonCO.getCrossRate()).compareTo(BigDecimal.ZERO) == 0)
		{

		    islamicCalculatorEventMgmtCO.setCrossRate(BigDecimal.ZERO);
		}
		else
		{
		    islamicCalculatorEventMgmtCO
			    .setCrossRate(NumberUtil.roundToBigDecimal(iisCommonCO.getCrossRate(), 6));
		}
	    }
	    else
	    {
		islamicCalculatorEventMgmtCO.setCrossRate(BigDecimal.ONE);
	    }
	}

	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating details based on purchase amoufnt entered.
     */
    @Override
    public IslamicCalculatorEventMgmtCO populateOnChangePurchaseAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	BigDecimal purchaseamt = islamicCalculatorEventMgmtCO.getPurchaseAmount();
	if(purchaseamt.compareTo(BigDecimal.ZERO) != 1)
	{
	    throw new BOException(MessageCodes.PURCHASE_AMT_GREATER_THAN_ZERO);// Purchase
	    // amount
	    // should
	    // be
	    // greater
	    // than
	    // zero
	}
	CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getCurrencyCode());
	// CURRENCIESVO currenciesVO = new CURRENCIESVO();
	CURRENCIESVO currenciesVO;
	// Start By Sreejith - 11/04/2013
	if(islamicCalculatorEventMgmtCO.getCurrencyCode() == null)
	{
	    currenciesVO = null;
	}
	else
	{
	    currenciesVO = islamicCalculatorEventMgmtDAO.getCurrencyDetails(currenciesVOKey);
	}
	// currenciesVOKey = null;

	BigDecimal currencyDecimalPoints = currenciesVO == null ? BigDecimal.ZERO : currenciesVO.getDECIMAL_POINTS();
	// End By Sreejith - 11/04/2013

	int currDecimalPoints = NumberUtil.toInt(currencyDecimalPoints);

	BigDecimal downpaymentAmount = BigDecimal.ZERO;

	if(islamicCalculatorEventMgmtCO.getDownPaymentPercentage() != null
		&& doubleValue(islamicCalculatorEventMgmtCO.getDownPaymentPercentage()) > 0)
	{
	    downpaymentAmount = (purchaseamt.multiply(islamicCalculatorEventMgmtCO.getDownPaymentPercentage()))
		    .divide(BigDecimal.valueOf(100), 12, BigDecimal.ROUND_HALF_UP);

	    // Setting the down payment amount
	    islamicCalculatorEventMgmtCO
		    .setDownPaymentAmount(NumberUtil.roundToBigDecimal(downpaymentAmount, currDecimalPoints));
	}

	BigDecimal financeAmount = purchaseamt.subtract(downpaymentAmount);

	if(financeAmount.compareTo(BigDecimal.ZERO) == 1)
	{
	    // Setting the down finance amount
	    islamicCalculatorEventMgmtCO
		    .setFinancingAmount(NumberUtil.roundToBigDecimal(financeAmount, currDecimalPoints));
	}
	else
	{
	    // Finance amount should be greater than zero
	    throw new BOException(MessageCodes.FIN_AMT_SHOULD_BE_GREATER_THAN_ZERO);
	}
	// BB150217 - Rescheduling and Loan Buyout CR105585
	BigDecimal newDealAmt = BigDecimal.ZERO;
	if(IISCommonConstants.TOPUP.equals(islamicCalculatorEventMgmtCO.getDealType())
		&& islamicCalculatorEventMgmtCO.getTopUpGridList() != null
		&& !islamicCalculatorEventMgmtCO.getTopUpGridList().isEmpty())
	{
	    newDealAmt = NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNetCreditToCustomer())
		    .subtract(NumberUtil.emptyDecimalToZero(
			    islamicCalculatorEventMgmtCO.getTrsTopUpDealVO().getTOP_UP_DEAL_AMOUNT()))
		    .add(financeAmount);
	    if(newDealAmt.compareTo(BigDecimal.ZERO) < 0)
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] {
			"Top-Up Details exists, New Deal Amount cannot be is less than Settled Amount." });
	    }
	    else
	    {
		islamicCalculatorEventMgmtCO.getTrsTopUpDealVO().setTOP_UP_DEAL_AMOUNT(newDealAmt);
	    }
	}
	else if(IISCommonConstants.BUYOUT.equals(islamicCalculatorEventMgmtCO.getDealType()) && (NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBANK_CIF_NO())
		.compareTo(BigDecimal.ZERO) > 0
		|| NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_CY())
			.compareTo(BigDecimal.ZERO) > 0
		|| NumberUtil
			.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_AMOUNT())
			.compareTo(BigDecimal.ZERO) > 0))
	{
	    newDealAmt = NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNetCreditToCustomer())
		    .subtract(NumberUtil
			    .emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getNEW_DEAL_AMOUNT()))
		    .add(financeAmount);
	    if(newDealAmt.compareTo(BigDecimal.ZERO) < 0)
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] {
			"Buy-Out Details exists, New Deal Amount cannot be is less than Buy-Out Deal Amount." });
	    }
	    else
	    {
		islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().setNEW_DEAL_AMOUNT(newDealAmt);
	    }
	}
	// BB150217 - Rescheduling and Loan Buyout CR105585 end

	islamicCalculatorEventMgmtCO.setFinancingCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	islamicCalculatorEventMgmtCO.setDealAmount(financeAmount);
	StringBuffer zeroValue = new StringBuffer("0.");
	StringBuffer nineValue = new StringBuffer("999999999999.");
	for(int i = 0; i < currDecimalPoints; i++)
	{
	    // if(zeroValue.toString().equals(IISCommonConstants.BLANKSTRING))
	    // {
	    // zeroValue.append("0");
	    // }
	    // else
	    // {
	    zeroValue.append("0");
	    // }
	}

	/*
	 * if(zeroValue.toString().equals(IISCommonConstants.BLANKSTRING)) {
	 * zeroValue.append("1"); } else {
	 * zeroValue.append("0.").append(zeroValue).append("1"); }
	 */
	for(int i = 0; i < currDecimalPoints; i++)
	{
	    // if(nineValue.toString().equals(IISCommonConstants.BLANKSTRING))
	    // {
	    // nineValue.append("9");
	    // }
	    // else
	    // {
	    nineValue.append("9");
	    // }
	}
	// Start By Sreejith - 11/04/2013
	if(nineValue.toString().equals(IISCommonConstants.BLANKSTRING))
	{
	    nineValue.append("9");
	}
	// End By Sreejith - 11/04/2013
	// nineValue.append().append(nineValue);

	double minimumAmount = 0D;
	double maximumAmount = 0D;
	minimumAmount = NumberUtil.toDouble(zeroValue);
	maximumAmount = NumberUtil.toDouble(nineValue);

	if(currDecimalPoints == 0)
	{
	    minimumAmount = 1D;
	}

	if(NumberUtil.toDouble(purchaseamt) < minimumAmount)
	{
	    islamicCalculatorEventMgmtCO.setConfirmationMessageId(zeroValue.toString());
	    return islamicCalculatorEventMgmtCO;
	}
	if(NumberUtil.toDouble(purchaseamt) > maximumAmount)
	{
	    // islamicCalculatorEventMgmtCO.setConfirmationMessageId(nineValue);
	    // return islamicCalculatorEventMgmtCO;
	    throw new BOException(MessageCodes.FINANCE_AMT_BTW, new String[] { "0", nineValue.toString() });
	}
	// To calculate the Yield
	islamicCalculatorEventMgmtCO.setEventType("PA");
	islamicCalculatorEventMgmtCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	IISCommonCO iisCommonCO = iisIslamicCalculatorBO.calculateYield(islamicCalculatorEventMgmtCO);
	// Added for yield not set properly
	if(iisCommonCO.getOrginalYield() != null && iisCommonCO.getOrginalYield().compareTo(BigDecimal.ZERO) == 1)
	{
	    islamicCalculatorEventMgmtCO.setYield(iisCommonCO.getOrginalYield());
	    islamicCalculatorEventMgmtCO.setMargin(iisCommonCO.getOrginalYield());
	}

	checkDealRange(islamicCalculatorEventMgmtCO);
	// islamicCalculatorEventMgmtCO.setGlobalConfirmationFrom("");

	if(islamicCalculatorEventMgmtCO.getTrsDealChargesVO() != null
		&& !islamicCalculatorEventMgmtCO.getTrsDealChargesVO().isEmpty())
	{
	    // To calculate the Deal Charges
	    BigDecimal cifNo = islamicCalculatorEventMgmtCO.getCifNo();
	    if(cifNo == null)
	    {
		cifNo = BigDecimal.ZERO;
		// return islamicCalculatorEventMgmtCO;//Done as per Bijoy
		// purchase amount cannot be null
	    }
	    IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	    iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisDealChargesCO.setCifNo(cifNo);
	    iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	    iisDealChargesCO.setCallType("O");// others
	    iisDealChargesCO.setIisTrsdealchargesCO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	    cifNo = null;
	    iisDealChargesCO = null;
	}
	currencyDecimalPoints = null;
	return islamicCalculatorEventMgmtCO;
    }

    /***
     * Method for calculating the down payment , financing amount based on down
     * payment percent
     * 
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeDownPaymentPercentage(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	double downpaymentpercentage = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getDownPaymentPercentage());
	double financingamount = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getFinancingAmount());
	double purchaseamt = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getPurchaseAmount());

	if(downpaymentpercentage < 0.000 || downpaymentpercentage > 100)
	{// Down payment percentage should be b/w 0 and 100
	 // throw new
	 // BOException(MessageCodes.INVALID_DOWN_PAYMENT_PERCENTAGE);
	 // TP#164515;Libin;10/11/2014
	    throw new BOException(MessageCodes.PERCENTAGE_SHOULD_BE_BETWEEN_0_AND_100);
	}
	else if(financingamount > 0 && downpaymentpercentage > 0)
	{// Financial amount and Down payment percentage greater than zero
	    double downpaymentAmount = (purchaseamt * downpaymentpercentage) / 100;
	    double financingAmount = purchaseamt - downpaymentAmount;
	    islamicCalculatorEventMgmtCO = iisIslamicCalculatorBO
		    .setAmountBasedOnCurrPoints(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO
		    .setDownPaymentAmount(NumberUtil.roundToBigDecimal(BigDecimal.valueOf(downpaymentAmount),
			    NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints())));

	    if(financingAmount > 0)
	    {
		islamicCalculatorEventMgmtCO
			.setFinancingAmount(NumberUtil.roundToBigDecimal(BigDecimal.valueOf(financingAmount),
				NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints())));
	    }
	    else
	    {// Finance amount should be greater than zero
	     // TP#245247; Libin; 03/12/2014 To show correct message
		throw new BOException(MessageCodes.EMPTY_MESSAGE,
			new String[] { "Cannot_Proceed_Key", "Deal_cannot_be_less_than_or_equal_to_zero_key" }, false);
		// throw new BOException(MessageCodes.iis_invalid_code,
		// new String[] {
		// "Deal_cannot_be_less_than_or_equal_to_zero_key" }, false);//
		// changed
		// the
		// msg
		// by
		// sreejith
		// for
		// bug
		// fixing
		// on
		// 11/4/2013
	    }
	}
	else if(purchaseamt > 0 && downpaymentpercentage == 0)
	{// Down payment amount is equal to zero and purchase amount greater
	 // than zero
	    islamicCalculatorEventMgmtCO.setDownPaymentAmount(BigDecimal.ZERO);
	    islamicCalculatorEventMgmtCO
		    .setFinancingAmount(NumberUtil.roundToBigDecimal(BigDecimal.valueOf(purchaseamt),
			    NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints())));
	}
	// BB150217 - Rescheduling and Loan Buyout CR105585
	validateTopUpBuyOut(islamicCalculatorEventMgmtCO);

	// To calculate the Yield
	IISCommonCO iisCommonCO = iisIslamicCalculatorBO.calculateYield(islamicCalculatorEventMgmtCO);
	// Added for yield not set properly
	if(iisCommonCO.getOrginalYield() != null && iisCommonCO.getOrginalYield().compareTo(BigDecimal.ZERO) == 1)
	{
	    islamicCalculatorEventMgmtCO.setYield(iisCommonCO.getOrginalYield());
	    islamicCalculatorEventMgmtCO.setMargin(iisCommonCO.getOrginalYield());
	}

	// To calculate the Charges
	if(islamicCalculatorEventMgmtCO.getTrsDealChargesVO() != null
		&& !islamicCalculatorEventMgmtCO.getTrsDealChargesVO().isEmpty())
	{
	    IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	    iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    BigDecimal cifNo = islamicCalculatorEventMgmtCO.getCifNo();
	    iisDealChargesCO.setCifNo(cifNo);
	    iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	    iisDealChargesCO.setCallType("O");// others
	    iisDealChargesCO.setIisTrsdealchargesCO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	    cifNo = null;
	    iisDealChargesCO = null;
	}
	iisCommonCO = null;
	return islamicCalculatorEventMgmtCO;
    }

    /** BB150217 - Rescheduling and Loan Buyout CR105585 **/
    private void validateTopUpBuyOut(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	BigDecimal newDealAmt = BigDecimal.ZERO;
	if(IISCommonConstants.TOPUP.equals(islamicCalculatorEventMgmtCO.getDealType())
		&& islamicCalculatorEventMgmtCO.getTopUpGridList() != null
		&& !islamicCalculatorEventMgmtCO.getTopUpGridList().isEmpty())
	{
	    newDealAmt = NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNetCreditToCustomer())
		    .subtract(NumberUtil.emptyDecimalToZero(
			    islamicCalculatorEventMgmtCO.getTrsTopUpDealVO().getTOP_UP_DEAL_AMOUNT()))
		    .add(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getFinancingAmount()));
	    if(newDealAmt.compareTo(BigDecimal.ZERO) < 0)
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] {
			"Top-Up Details exists, New Deal Amount cannot be is less than Settled Amount." });
	    }

	}
	else if(IISCommonConstants.BUYOUT.equals(islamicCalculatorEventMgmtCO.getDealType()) && (NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBANK_CIF_NO())
		.compareTo(BigDecimal.ZERO) > 0
		|| NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_CY())
			.compareTo(BigDecimal.ZERO) > 0
		|| NumberUtil
			.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_AMOUNT())
			.compareTo(BigDecimal.ZERO) > 0))
	{
	    newDealAmt = NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNetCreditToCustomer())
		    .subtract(NumberUtil
			    .emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getNEW_DEAL_AMOUNT()))
		    .add(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getFinancingAmount()));
	    if(newDealAmt.compareTo(BigDecimal.ZERO) < 0)
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] {
			"Buy-Out Details exists, New Deal Amount cannot be is less than Buy-Out Deal Amount." });
	    }
	}
    }

    /**
     * Method for populating data based on down payment amount (Down Payment On
     * Change Event)
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO onChangeDownPayment(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	// TP#164723;Libin;06/11/2014 Removed the wrong validation from jsp and
	// added here
	// Validating the value Entered by calculating Decimal part from Decimal
	// Points passed from screen
	// [start]
	BigDecimal amt = NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	BigDecimal decPts = NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getCurrencyDecimalPointsForCalc());
	BigDecimal maxValue = BigDecimal.ZERO;
	String max = "999999999999.";
	if(decPts.compareTo(BigDecimal.ZERO) > 0)
	{
	    maxValue = new BigDecimal(max.concat(NumberUtil.fill("9", NumberUtil.emptyDecimalToNull(decPts))));
	}
	else
	{
	    maxValue = new BigDecimal(max);
	}
	if(amt.compareTo(BigDecimal.ZERO) < 0 || amt.compareTo(maxValue) > 0)
	{
	    String[] params = new String[2];
	    params[0] = "0";
	    params[1] = CommonMethods.formatCurrency(maxValue, decPts);
	    throw new BOException(MessageCodes.VALUE_SHOULD_BE_BETWEEN_PARAM_AND_PARAM, params);
	}
	// [end]

	if(islamicCalculatorEventMgmtCO.getDownPaymentAmount() != null
		&& islamicCalculatorEventMgmtCO.getPurchaseAmount() != null)
	{
	    double downPaymentAmount = doubleValue(islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    double purchaseAmount = doubleValue(islamicCalculatorEventMgmtCO.getPurchaseAmount());
	    BigDecimal productClass = islamicCalculatorEventMgmtCO.getProductClass();
	    if(downPaymentAmount < 0)
	    {
		throw new BOException(MessageCodes.DOWN_PAYMENT_LESS_THAN_ZERO);
	    }
	    else if(purchaseAmount <= 0)
	    {
		throw new BOException(MessageCodes.INVALID_TOTAL_AMOUNT);
	    }
	    else if((purchaseAmount - downPaymentAmount) <= 0)
	    {
		throw new BOException(MessageCodes.DOWN_PAYMENT_LESS_THAN_TOTAL_AMOUNT);
	    }
	    else if(downPaymentAmount >= purchaseAmount)
	    {
		throw new BOException(MessageCodes.DOWN_PAYMENT_LESS_THAN_TOTAL_AMOUNT);
	    }
	    else if(productClass != null && NumberUtil.toInt(productClass) > 0)
	    {
		TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
		trsClassVOKey.setCODE(productClass);
		trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
		TRSCLASSVO trsClassVO = islamicCalculatorEventMgmtDAO.getDownPaymentDetails(trsClassVOKey);
		trsClassVOKey = null;

		if(trsClassVO == null)
		{
		    return islamicCalculatorEventMgmtCO;
		}

		String initialPaymentType = "";
		initialPaymentType = trsClassVO.getINITIAL_PAYMENT_TYPE();
		double minimumSecurityDepositAmount = 0;
		minimumSecurityDepositAmount = doubleValue(trsClassVO.getMINIMUM_SECURITY_DEPOSIT_AMT());
		trsClassVO = null;
		// Getting the decimal points based on the currency unit.
		islamicCalculatorEventMgmtCO = iisIslamicCalculatorBO
			.setAmountBasedOnCurrPoints(islamicCalculatorEventMgmtCO);
		if(initialPaymentType.equals(IISCommonConstants.DOWN_PAYMENT))
		{
		    islamicCalculatorEventMgmtCO.setFinancingAmount(
			    NumberUtil.roundToBigDecimal(BigDecimal.valueOf(purchaseAmount - downPaymentAmount),
				    NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints())));
		}
		else if(initialPaymentType.equals(IISCommonConstants.INITIAL_PAYMENT_TYPE_A))
		{
		    if(downPaymentAmount < minimumSecurityDepositAmount)
		    {
			throw new BOException(MessageCodes.DEPOSIT_AMOUNT_LESS_THAN_MINIMUM_AMOUNT);
		    }
		    else
		    {
			islamicCalculatorEventMgmtCO.setFinancingAmount(
				NumberUtil.roundToBigDecimal(BigDecimal.valueOf(purchaseAmount - downPaymentAmount),
					NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints())));
		    }
		}
		else
		{
		    if(downPaymentAmount < ((minimumSecurityDepositAmount * purchaseAmount) / 100))
		    {
			throw new BOException(MessageCodes.SECURITY_AMT_LESS_THAN_MIN_SECURITY_PERCENTAGE);
		    }
		    else
		    {
			islamicCalculatorEventMgmtCO.setFinancingAmount(
				NumberUtil.roundToBigDecimal(BigDecimal.valueOf(purchaseAmount - downPaymentAmount),
					NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints())));
		    }
		}
	    }
	    // BB150217 - Rescheduling and Loan Buyout CR105585
	    BigDecimal newDealAmt = BigDecimal.ZERO;
	    if(IISCommonConstants.TOPUP.equals(islamicCalculatorEventMgmtCO.getDealType())
		    && islamicCalculatorEventMgmtCO.getTopUpGridList() != null
		    && !islamicCalculatorEventMgmtCO.getTopUpGridList().isEmpty())
	    {
		newDealAmt = NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNetCreditToCustomer())
			.subtract(NumberUtil.emptyDecimalToZero(
				islamicCalculatorEventMgmtCO.getTrsTopUpDealVO().getTOP_UP_DEAL_AMOUNT()))
			.add(BigDecimal.valueOf(purchaseAmount - downPaymentAmount));
		if(newDealAmt.compareTo(BigDecimal.ZERO) < 0)
		{
		    throw new BOException(MessageCodes.iis_invalid_code, new String[] {
			    "Top-Up Details exists, New Deal Amount cannot be is less than Settled Amount." });
		}

	    }
	    else if(IISCommonConstants.BUYOUT.equals(islamicCalculatorEventMgmtCO.getDealType()) && (NumberUtil
		    .emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBANK_CIF_NO())
		    .compareTo(BigDecimal.ZERO) > 0
		    || NumberUtil
			    .emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_CY())
			    .compareTo(BigDecimal.ZERO) > 0
		    || NumberUtil
			    .emptyDecimalToZero(
				    islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_AMOUNT())
			    .compareTo(BigDecimal.ZERO) > 0))
	    {
		newDealAmt = NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNetCreditToCustomer())
			.subtract(NumberUtil.emptyDecimalToZero(
				islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getNEW_DEAL_AMOUNT()))
			.add(BigDecimal.valueOf(purchaseAmount - downPaymentAmount));
		if(newDealAmt.compareTo(BigDecimal.ZERO) < 0)
		{
		    throw new BOException(MessageCodes.iis_invalid_code, new String[] {
			    "Buy-Out Details exists, New Deal Amount cannot be is less than Buy-Out Deal Amount." });
		}
	    }
	    // BB150217 - Rescheduling and Loan Buyout CR105585 end
	    if(downPaymentAmount >= 0)// changed by sreejith for bug fixing on
	    // 11/04/2013
	    {
		double downPaymentPercentage = downPaymentAmount * 100 / purchaseAmount;
		downPaymentPercentage = NumberUtil.round(downPaymentPercentage, 3);
		if(downPaymentPercentage > 100)
		{
		    throw new BOException(MessageCodes.DEPOSIT_AMOUNT_LESS_THAN_MINIMUM_AMOUNT);
		}
		else
		{
		    islamicCalculatorEventMgmtCO.setDownPaymentPercentage(BigDecimal.valueOf(downPaymentPercentage));
		    islamicCalculatorEventMgmtCO.setFinancingAmount(
			    NumberUtil.roundToBigDecimal(BigDecimal.valueOf(purchaseAmount - downPaymentAmount),
				    NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints())));
		}
		islamicCalculatorEventMgmtCO.setEventType("DP");
		// To calculate the Yield
		IISCommonCO iisCommonCO = iisIslamicCalculatorBO.calculateYield(islamicCalculatorEventMgmtCO);
		// Added for yield not set properly
		if(iisCommonCO.getOrginalYield() != null
			&& iisCommonCO.getOrginalYield().compareTo(BigDecimal.ZERO) == 1)
		{
		    islamicCalculatorEventMgmtCO.setYield(iisCommonCO.getOrginalYield());
		    islamicCalculatorEventMgmtCO.setMargin(iisCommonCO.getOrginalYield());
		}

		// To calculate the Charges
		if(islamicCalculatorEventMgmtCO.getTrsDealChargesVO() != null
			&& !islamicCalculatorEventMgmtCO.getTrsDealChargesVO().isEmpty())
		{
		    IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
		    iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		    iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
		    iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
		    BigDecimal cifNo = islamicCalculatorEventMgmtCO.getCifNo();
		    if(cifNo == null)
		    {
			return islamicCalculatorEventMgmtCO;
		    }
		    iisDealChargesCO.setCifNo(cifNo);
		    iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
		    iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
		    iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
		    iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
		    iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
		    iisDealChargesCO.setCallType("O");// others
		    iisDealChargesCO.setIisTrsdealchargesCO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
		    islamicCalculatorEventMgmtCO
			    .setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
		    cifNo = null;
		    iisDealChargesCO = null;
		}
		iisCommonCO = null;
	    }
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populate data based on the financing amount (On Change Event
     * of Financing Amount)
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeFinancingAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {

	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	// TP#164514;Libin;06/11/2014 Removed the wrong validation from jsp and
	// added here
	// Validating the value Entered by calculating Decimal part from Decimal
	// Points passed from screen
	// [start]
	BigDecimal amt = NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getFinancingAmount());
	BigDecimal decPts = NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getCurrencyDecimalPointsForCalc());
	BigDecimal maxValue = BigDecimal.ZERO;
	String max = "999999999999.";
	if(decPts.compareTo(BigDecimal.ZERO) > 0)
	{
	    maxValue = new BigDecimal(max.concat(NumberUtil.fill("9", NumberUtil.emptyDecimalToNull(decPts))));
	}
	else
	{
	    maxValue = new BigDecimal(max);
	}
	if(amt.compareTo(BigDecimal.ZERO) < 0 || amt.compareTo(maxValue) > 0)
	{
	    String[] params = new String[2];
	    params[0] = "0";
	    params[1] = CommonMethods.formatCurrency(maxValue, decPts);
	    throw new BOException(MessageCodes.FINANCE_AMT_BTW, params);
	}
	// BB150217 - Rescheduling and Loan Buyout CR105585
	validateTopUpBuyOut(islamicCalculatorEventMgmtCO);

	// double financingamount =
	// NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getFinancingAmount());
	// if(financingamount < 0 || financingamount > 999999999999d)
	// {
	// throw new BOException(MessageCodes.FINANCE_AMT_BTW, new String[] {
	// BigDecimal.ZERO.toString(),
	// BigDecimal.valueOf(999999999999d).toString() });
	// }
	if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getCifNo()).compareTo(BigDecimal.ZERO) == 1)
	{
	    islamicCalculatorEventMgmtCO = verifyDealAmountWithCifSalary(islamicCalculatorEventMgmtCO);
	    // added this validation for onchange of financing amount
	    islamicCalculatorEventMgmtCO = iisCommonBO.showWarningForCifSalaryMultiple(islamicCalculatorEventMgmtCO);
	    // BB130089; Saheer.Naduthodi; 14/05/2015 [START]
	    if(!StringUtil.isNotEmpty(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom())
		    || !"DEAL_AMOUNT_EXCEED_GENERAL_CUSTOMER_LIMIT"
			    .equals(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom()))
	    {
		IISCustomerLimitCO iisCustomerLimitCO = new IISCustomerLimitCO();
		iisCustomerLimitCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		iisCustomerLimitCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
		iisCustomerLimitCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());

		// BB130272 Modification;Ravikant.Singh;19/05/2015[start]
		// iisCustomerLimitCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
		if(islamicCalculatorEventMgmtCO.getCustGuarLiabilityList() != null
			&& !islamicCalculatorEventMgmtCO.getCustGuarLiabilityList().isEmpty())
		{
		    iisCustomerLimitCO.setDealAmount(islamicCalculatorEventMgmtCO.getCustGuarLiabilityList().get(0)
			    .getTrsdealCustGuarLiabilitiesVO().getTOTAL_FINANCED_AMT());
		}
		else
		{
		    iisCustomerLimitCO.setDealAmount(BigDecimal.ZERO);
		}
		// BB130272 Modification;Ravikant.Singh;19/05/2015[end]
		iisCustomerLimitCO.setDealCY(islamicCalculatorEventMgmtCO.getCurrencyCode());
		iisCustomerLimitCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
		iisCustomerLimitCO.setBaseCurrencyDesc(islamicCalculatorEventMgmtCO.getBaseCurrencyDesc());
		iisCustomerLimitCO.setBaseCurrencyDecimal(islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints());
		iisCustomerLimitCO.setRunningDate(islamicCalculatorEventMgmtCO.getRunningDate());
		iisCommonBO.validateGeneralCustomerLimit(iisCustomerLimitCO);
		iisCustomerLimitCO = null;
	    }
	    // BB130089; Saheer.Naduthodi; 14/05/2015 [END]
	    islamicCalculatorEventMgmtCO.setGlobalConfirmationFrom("");
	}

	// Getting the decimal points based on the currency unit.
	islamicCalculatorEventMgmtCO = iisIslamicCalculatorBO.setAmountBasedOnCurrPoints(islamicCalculatorEventMgmtCO);

	double downpayment = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	islamicCalculatorEventMgmtCO.setPurchaseAmount(NumberUtil.roundToBigDecimal(
		BigDecimal
			.valueOf(downpayment + NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getFinancingAmount())),
		NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints())));
	// To calculate the Yield
	IISCommonCO iisCommonCO = iisIslamicCalculatorBO.calculateYield(islamicCalculatorEventMgmtCO);
	// Added for yield not set properly
	if(iisCommonCO.getOrginalYield() != null && iisCommonCO.getOrginalYield().compareTo(BigDecimal.ZERO) == 1)
	{
	    islamicCalculatorEventMgmtCO.setYield(iisCommonCO.getOrginalYield());
	    islamicCalculatorEventMgmtCO.setMargin(iisCommonCO.getOrginalYield());
	}
	// To calculate the Charges
	if(islamicCalculatorEventMgmtCO.getTrsDealChargesVO() != null
		&& !islamicCalculatorEventMgmtCO.getTrsDealChargesVO().isEmpty())
	{
	    IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	    iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    BigDecimal cifNo = islamicCalculatorEventMgmtCO.getCifNo();
	    if(cifNo == null)
	    {
		return islamicCalculatorEventMgmtCO;
	    }
	    iisDealChargesCO.setCifNo(cifNo);
	    iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	    iisDealChargesCO.setCallType("O");// others
	    iisDealChargesCO.setIisTrsdealchargesCO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	}
	iisCommonCO = null;
	// Added by Linchu for Annual Yield
	islamicCalculatorEventMgmtCO = iisCommonBO.calculateTotalAnnualYield(islamicCalculatorEventMgmtCO);
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for verifying the deal amount with cif Salary
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    private IslamicCalculatorEventMgmtCO verifyDealAmountWithCifSalary(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	double maximumSalaryTimes = NumberUtil
		.toDouble(islamicCalculatorEventMgmtDAO.getMaximumFinanceAmount(islamicCalculatorEventMgmtCO));
	if(maximumSalaryTimes == 0)
	{
	    return islamicCalculatorEventMgmtCO;
	}
	double monthlyBasicSalary = NumberUtil
		.toDouble(islamicCalculatorEventMgmtDAO.getMonthlyBasicSalary(islamicCalculatorEventMgmtCO));
	if(monthlyBasicSalary == 0)
	{
	    throw new BOException(MessageCodes.CIF_SALARY_NOT_SPECIFIED);
	}
	double maximumFinanceAmount = monthlyBasicSalary * maximumSalaryTimes;
	if(NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyCode()) != NumberUtil
		.toInt(islamicCalculatorEventMgmtCO.getBaseCurrencyCode()))
	{
	    CommonLibSC commonLibSC = new CommonLibSC();
	    commonLibSC.setCompanyCode(islamicCalculatorEventMgmtCO.getCompCode());
	    commonLibSC.setAccCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    commonLibSC.setSelectedDate(islamicCalculatorEventMgmtCO.getRunningDate());
	    BigDecimal exchangeRate = BigDecimal.valueOf(commonLibDao.getExchangeRate(commonLibSC));
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOTemp = islamicCalculatorEventMgmtDAO
		    .getCurrencyUnitDetails(islamicCalculatorEventMgmtCO);

	    if(islamicCalculatorEventMgmtCOTemp != null)
	    {
		islamicCalculatorEventMgmtCO.setFinancingAmount(CommonMethods.multiplyDivideAmount(
			islamicCalculatorEventMgmtCOTemp.getMultipleDivisionIndicator(),
			islamicCalculatorEventMgmtCO.getFinancingAmount(), exchangeRate,
			islamicCalculatorEventMgmtCOTemp.getCurrencyUnit(),
			islamicCalculatorEventMgmtCOTemp.getCurrencyDecimalPoints()));

	    }

	    commonLibSC = null;
	    islamicCalculatorEventMgmtCOTemp = null;
	}
	double outstandingAmount = NumberUtil.toDouble(
		islamicCalculatorEventMgmtDAO.getOutstandingAmountOfExistingDeals(islamicCalculatorEventMgmtCO));
	// TP#225262;Arun.R.Variyath;27/09/2014
	if(maximumFinanceAmount < outstandingAmount
		+ NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getFinancingAmount()))
	{
	    throw new BOException(MessageCodes.DEAL_AMOUNT_GRT_THAN_CIF_SALARY);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for validating initially the on change event of start date
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO validateOnChangeStartDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	// TP#208366; Ramesh; Date 07/08/2014
	if(islamicCalculatorEventMgmtCO.getStartDate() == null)
	{
	    throw new BOException(MessageCodes.iis_invalid_code, new String[] { "Invalid_Date_Defined" }, false);
	}
	if(islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	{
	    // Start Date >= Maturity Date
	    if(islamicCalculatorEventMgmtCO.getStartDate().after(islamicCalculatorEventMgmtCO.getMaturityDate()))
	    {
		throw new BOException(MessageCodes.START_DTE_CANT_AFTER_OR_EQUALTO_MAT_DTE);
	    }
	    // 687725 jinson commented below checking 15/06/2018
	    // Start By Sreejith - 11/04/2013
	    // if(islamicCalculatorEventMgmtCO.getStartDate().before(islamicCalculatorEventMgmtCO.getRunningDate()))
	    // {
	    // throw new
	    // BOException(MessageCodes.DATE_CANNOT_BE_LESS_THAN_RUNNING_DATE);
	    // }
	    // End By Sreejith - 11/04/2013
	}
	// BB150217 - Rescheduling and Loan Buyout CR105585
	if(IISCommonConstants.TOPUP.equals(islamicCalculatorEventMgmtCO.getDealType())
		&& islamicCalculatorEventMgmtCO.getTopUpGridList() != null
		&& !islamicCalculatorEventMgmtCO.getTopUpGridList().isEmpty())
	{
	    for(IslamicCalculatorEventMgmtCO calculatorEventMgmtCO : islamicCalculatorEventMgmtCO.getTopUpGridList())
	    {
		if(ConstantsCommon.YES.equals(calculatorEventMgmtCO.getTopUpDealSelYN())
			&& islamicCalculatorEventMgmtCO.getStartDate()
				.compareTo(DateUtil.nullToInitDate(calculatorEventMgmtCO.getMaturityDate())) >= 0)
		{
		    throw new BOException(MessageCodes.iis_invalid_code, new String[] {
			    "Top-Up Details exists, Please unselect rows where maturity date is less than equal to new value date and try again" });
		}
	    }
	}
	else if(IISCommonConstants.BUYOUT.equals(islamicCalculatorEventMgmtCO.getDealType()) && (NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBANK_CIF_NO())
		.compareTo(BigDecimal.ZERO) > 0
		|| NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_CY())
			.compareTo(BigDecimal.ZERO) > 0
		|| NumberUtil
			.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_AMOUNT())
			.compareTo(BigDecimal.ZERO) > 0))
	{
	    islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO()
		    .setVALUE_DATE(islamicCalculatorEventMgmtCO.getStartDate());
	}
	// BB150217 - Rescheduling and Loan Buyout CR105585 end
	if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	{
	    if("N".equals(islamicCalculatorEventMgmtCO.getPriceUserTypedYN()))
	    {
		iisCommonBO.applyBillsCalculatorYield(islamicCalculatorEventMgmtCO);
	    }
	    else
	    {

		iisCommonBO.applyPriceSetCalculator(islamicCalculatorEventMgmtCO);
	    }

	    islamicCalculatorEventMgmtCO = crossRateBillsCalculator(islamicCalculatorEventMgmtCO);
	    // TODO
	    /*
	     * IF ldec_cross_rate = -1 Then This.SetText(iv_colvalue) Return 1
	     * End IF
	     */

	    islamicCalculatorEventMgmtCO.setCrossRate(islamicCalculatorEventMgmtCO.getCrossRate());
	    islamicCalculatorEventMgmtCO.setBillAmount(BigDecimal.ZERO);
	    islamicCalculatorEventMgmtCO.setAmountPerPayment(BigDecimal.ZERO);
	    islamicCalculatorEventMgmtCO.setTotalBillAmount(BigDecimal.ZERO);
	    islamicCalculatorEventMgmtCO.setTradingBillAmount(BigDecimal.ZERO);

	    Long lldays = DateUtil.numberOfDays(islamicCalculatorEventMgmtCO.getValueDate(),
		    islamicCalculatorEventMgmtCO.getMaturityDate());
	    islamicCalculatorEventMgmtCO.setIborRatePeriodicityType("D");
	    islamicCalculatorEventMgmtCO.setIborRatePeriodicity(BigDecimal.valueOf(lldays));
	    // TODO
	    // If lb_holiday_date_changed Then Return 1

	}

	// Check whether new start Date is holiday and the respective holiday
	// action
	if(islamicCalculatorEventMgmtCO.getCompCode() != null && islamicCalculatorEventMgmtCO.getBranchCode() != null
		&& islamicCalculatorEventMgmtCO.getProductClass() != null
		&& islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getCurrencyCode() != null)
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());

	    IISHolidayCheckCO iisHolidayCheckCO = new IISHolidayCheckCO();
	    iisHolidayCheckCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisHolidayCheckCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisHolidayCheckCO.setDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisHolidayCheckCO.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisHolidayCheckCO.setDateType("M");
	    iisHolidayCheckCO.setApplyYearHoliday(iisCommonBO.returnHolidayActionDealDateYn(iisCommonCO));
	    iisHolidayCheckCO.setProductClassCode(islamicCalculatorEventMgmtCO.getProductClass());
	    iisHolidayCheckCO.setActionCode(iisCommonBO.returnHolidayAction(iisCommonCO));
	    iisHolidayCheckCO = iisCommonBO.checkValueDateIsHoliday(iisHolidayCheckCO);

	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonBO.returnHolidayActions(trsClassVOKey);
	    if(iisHolidayCheckCO.getHolidayYn().equals(ConstantsCommon.YES)
		    && trsClassVO.getHOLIDAY_ACTION_WARNING_IND().equals(IISCommonConstants.MESSAGE_TYPEWARNING))
	    {
		islamicCalculatorEventMgmtCO.setStartDateAfterHoliday(iisHolidayCheckCO.getNewDate());
		islamicCalculatorEventMgmtCO.setConfirmationMessageId("901900");
		return islamicCalculatorEventMgmtCO;
	    }
	    iisCommonCO = null;
	    trsClassVOKey = null;
	    trsClassVO = null;
	    iisHolidayCheckCO = null;
	}

	return islamicCalculatorEventMgmtCO;
    }

    /*
     * private void settestdata(IslamicCalculatorEventMgmtCO
     * islamicCalculatorEventMgmtCO) { Date valueDate =
     * DateUtil.createDate(2010, 1, 1); Date maturityDate =
     * DateUtil.createDate(2012, 7, 1); Date firstPayDate =
     * DateUtil.createDate(2012, 5, 1); Date defmaturityDate =
     * DateUtil.createDate(2011, 1, 1); BigDecimal BranchCode = new
     * BigDecimal(1); BigDecimal dealAmount = BigDecimal.valueOf(500000);
     * BigDecimal noOfPayments = BigDecimal.valueOf(30);
     * 
     * islamicCalculatorEventMgmtCO.setStartDate(valueDate);
     * islamicCalculatorEventMgmtCO.setFirstPaymentDate(firstPayDate);
     * islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
     * islamicCalculatorEventMgmtCO.setCompCode(BigDecimal.valueOf(1));
     * islamicCalculatorEventMgmtCO.setProductClass(BigDecimal.valueOf(1230));
     * islamicCalculatorEventMgmtCO.setDefaultMaturityDate(defmaturityDate);
     * islamicCalculatorEventMgmtCO.setCheckDefaultMaturityDate(true);
     * islamicCalculatorEventMgmtCO.setBranchCode(BranchCode);
     * islamicCalculatorEventMgmtCO.setDealAmount(dealAmount);
     * islamicCalculatorEventMgmtCO.setCifNo(BigDecimal.valueOf(1));
     * islamicCalculatorEventMgmtCO.setCurrencyCode(BigDecimal.valueOf(1));
     * 
     * String paymentPeriodicity = "M"; Long paymentPeriodicityNo = 1L; String
     * paymentPeriodicityMonthPos = "S";
     * islamicCalculatorEventMgmtCO.setNoOfPayments(noOfPayments);
     * islamicCalculatorEventMgmtCO.setPaymPeriodicity(paymentPeriodicity);
     * islamicCalculatorEventMgmtCO.setPaymPeriodNbr(new
     * BigDecimal(paymentPeriodicityNo));
     * islamicCalculatorEventMgmtCO.setPaymPeriodPos
     * (paymentPeriodicityMonthPos);
     * islamicCalculatorEventMgmtCO.setStartDate(valueDate);
     * islamicCalculatorEventMgmtCO.setRosterDealAmount(dealAmount);
     * islamicCalculatorEventMgmtCO.setFinancingAmount(dealAmount);
     * islamicCalculatorEventMgmtCO.setVatCode(BigDecimal.valueOf(1));
     * islamicCalculatorEventMgmtCO.setConfirmationResult(true);
     * islamicCalculatorEventMgmtCO.setStartDateAfterHoliday(valueDate);
     * 
     * }
     */

    /**
     * Method for populating the on change event of start date
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeStartDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getStartDateAfterHoliday() != null
		&& islamicCalculatorEventMgmtCO.getConfirmationResult())
	{
	    islamicCalculatorEventMgmtCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDateAfterHoliday());
	}
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	validateValueDateAndTradeDate(islamicCalculatorEventMgmtCO);
	// Set First Payment Date = Start Date + Grace Period
	islamicCalculatorEventMgmtCO
		.setFirstPaymentDate(iisIslamicCalculatorBO.getFirstPaymentDate(islamicCalculatorEventMgmtCO));

	/**
	 * Added By Manoj on 14/12/2016 for BMOI160002 <Start>
	 */
	
	if (NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getGracePeriod()).compareTo(BigDecimal.ZERO) == 1 
			&& "D".equals(islamicCalculatorEventMgmtCO.getPaymPeriodPos()))
	{
		IISCommonCO commonCO = new IISCommonCO();
		commonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		commonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
		commonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
		commonCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate()== null ? 
				islamicCalculatorEventMgmtCO.getRunningDate(): islamicCalculatorEventMgmtCO.getStartDate());
		commonCO.setFirstPayDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
		commonCO.setGracePeriod(islamicCalculatorEventMgmtCO.getGracePeriod());
		commonCO.setGracePeriodicity(islamicCalculatorEventMgmtCO.getGracePeriodicity());
		
		commonCO = iisCommonBO.returnFirstPaymentDateByCutoffDay(commonCO);
		islamicCalculatorEventMgmtCO.setFirstPaymentDate(commonCO.getFirstPayDate());
		islamicCalculatorEventMgmtCO.setGracePeriodicity(commonCO.getGracePeriodicity());
		islamicCalculatorEventMgmtCO.setGracePeriod(commonCO.getGracePeriod());
	}
	/**
	 * Added By Manoj on 14/12/2016 for BMOI160002 <End>
	 */
	// Setting the new maturity date based on the parameters.
	if(islamicCalculatorEventMgmtCO.getNoOfPayments() != null
		&& islamicCalculatorEventMgmtCO.getPaymPeriodicity() != null
		&& islamicCalculatorEventMgmtCO.getPaymPeriodNbr() != null
		&& islamicCalculatorEventMgmtCO.getPaymPeriodPos() != null
		&& islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getCompCode() != null
		&& islamicCalculatorEventMgmtCO.getBranchCode() != null
		&& islamicCalculatorEventMgmtCO.getFirstPaymentDate() != null)
	{
	  	    IISCommonCO iisCommonCO = new IISCommonCO();
//	    iisCommonCO.setNoOfPayments(
//		    NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNoOfPayments()).add(BigDecimal.ONE));
	    iisCommonCO.setNoOfPayments(
			    NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNoOfPayments()));
	    iisCommonCO.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    iisCommonCO.setPaymPeriodNbr(islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    iisCommonCO.setPaymPeriodPos(islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    iisCommonCO.setValue("COMMENCE");
	    iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisCommonCO.setFirstPayDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    // #TAR BB130030 ;Arun R Variyath ; 11/08/2015 [Start]
	    String calcMatDte = StringUtil.nullEmptyToValue(iisCommonBO.returnCalcMatDteFlagValue(iisCommonCO), "N");
	    if("Y".equals(calcMatDte))
	    {
		iisCommonCO.setPaymPeriodPos("D");
	    }
	    // #TAR BB130030 ;Arun R Variyath ; 11/08/2015 [End]
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());

	    iisCommonCO = iisCommonBO.returnMaturitydate(iisCommonCO);
	    islamicCalculatorEventMgmtCO.setMaturityDate(iisCommonCO.getMaturityDate());
	    iisCommonCO = null;

	    TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	    if(trsClassVO != null && trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN() != null)
	    {
		String flag = trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN();
		if(flag.equals(ConstantsCommon.YES) && (islamicCalculatorEventMgmtCO.getDefaultMaturityDate().compareTo(// This
			// checking
			// is
			// done
			// after
			// setting
			// the
			// matuirty
			// date.
			islamicCalculatorEventMgmtCO.getMaturityDate()) != 0)
			&& (!islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate()))
		{
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId("902080");
		    islamicCalculatorEventMgmtCO.setCheckDefaultMaturityDate(true);
		}
	    }
	    trsClassVO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    private void validateValueDateAndTradeDate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());

	TRSCLASSVO trsClassVO = iisCommonDAO.getHolidayActions(trsClassVOKey);

	if(trsClassVO != null && ConstantsCommon.NO.equals(trsClassVO.getDEAL_ALLOW_BACK_VDATE_TRANS_YN())
		&& islamicCalculatorEventMgmtCO.getRunningDate() != null
		&& islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getStartDate().before(islamicCalculatorEventMgmtCO.getRunningDate()))
	{
	    throw new BOException(MessageCodes.DEAL_VALUE_DATE_CANNOT_LESS_SYSDATE);
	}

    }

    public IslamicCalculatorEventMgmtCO checkMaturityDateIsHoliday(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	// Check whether new Maturity Date is holiday and the respective holiday
	// action
	if(islamicCalculatorEventMgmtCO.getCompCode() != null && islamicCalculatorEventMgmtCO.getBranchCode() != null
		&& islamicCalculatorEventMgmtCO.getProductClass() != null
		&& islamicCalculatorEventMgmtCO.getMaturityDate() != null
		&& islamicCalculatorEventMgmtCO.getCurrencyCode() != null)
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());

	    IISHolidayCheckCO iisHolidayCheckCO = new IISHolidayCheckCO();
	    iisHolidayCheckCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisHolidayCheckCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisHolidayCheckCO.setDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisHolidayCheckCO.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisHolidayCheckCO.setDateType("M");
	    iisHolidayCheckCO.setApplyYearHoliday(iisCommonBO.returnHolidayActionDealDateYn(iisCommonCO));
	    iisHolidayCheckCO.setProductClassCode(islamicCalculatorEventMgmtCO.getProductClass());
	    iisHolidayCheckCO.setActionCode(iisCommonBO.returnHolidayAction(iisCommonCO));
	    iisHolidayCheckCO = iisCommonBO.checkValueDateIsHoliday(iisHolidayCheckCO);

	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonBO.returnHolidayActions(trsClassVOKey);
	    if(iisHolidayCheckCO.getHolidayYn().equals(ConstantsCommon.YES)
		    && trsClassVO.getHOLIDAY_ACTION_WARNING_IND().equals(IISCommonConstants.MESSAGE_TYPEWARNING))
	    {
		islamicCalculatorEventMgmtCO.setMaturityDateAfterHoliday(iisHolidayCheckCO.getNewDate());
		islamicCalculatorEventMgmtCO.setConfirmationMessageId("901900");
		return islamicCalculatorEventMgmtCO;
	    }
	    islamicCalculatorEventMgmtCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisCommonCO = null;
	    trsClassVOKey = null;
	    trsClassVO = null;
	    iisHolidayCheckCO = null;
	}

	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for set the fields after holiday checking called for the on change
     * event of start date
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO setOnChangeStartDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	// Set Yield From Yield Register for the new start date
	IISCommonCO iisCommonCOForYield = iisIslamicCalculatorBO.calculateYield(islamicCalculatorEventMgmtCO);
	islamicCalculatorEventMgmtCO.setYield(iisCommonCOForYield.getOrginalYield());
	islamicCalculatorEventMgmtCO.setMargin(iisCommonCOForYield.getOrginalYield());

	// Removing the First payment from here and adding up before cal of MD.
	// //Set First Payment Date = Start Date + Grace Period
	// islamicCalculatorEventMgmtCO.setFirstPaymentDate(getFirstPaymentDate(islamicCalculatorEventMgmtCO));
	//
	// Taking new maturity date based on holiday.
	if(islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday() != null
		&& islamicCalculatorEventMgmtCO.getConfirmationResult())
	{
	    islamicCalculatorEventMgmtCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	}
	if(islamicCalculatorEventMgmtCO.getCompCode() != null && islamicCalculatorEventMgmtCO.getCifNo() != null
		&& islamicCalculatorEventMgmtCO.getProductClass() != null
		&& islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getBranchCode() != null)
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    List<IslamicCalculatorDBRatioSC> vectDBRatio = iisCommonBO.calculateDBRatio(iisCommonCO);
	    if(!vectDBRatio.isEmpty())
	    {
		IslamicCalculatorDBRatioSC dbRatioSC = vectDBRatio.get(vectDBRatio.size() - 1);
		islamicCalculatorEventMgmtCO.setDebtBurdanRatio(dbRatioSC.getDbrAmount());
	    }
	    vectDBRatio = null;
	    iisCommonCO = null;
	}

	// Recalculate Charges based on the new Financing Amt SERVICE TEAM
	// of_recalculate_charges()
	if(islamicCalculatorEventMgmtCO.getProductClass() != null && islamicCalculatorEventMgmtCO.getCompCode() != null
		&& islamicCalculatorEventMgmtCO.getBranchCode() != null
		&& islamicCalculatorEventMgmtCO.getCifNo() != null
		&& islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getMaturityDate() != null
		&& islamicCalculatorEventMgmtCO.getCurrencyCode() != null
		&& islamicCalculatorEventMgmtCO.getDealAmount() != null
		&& islamicCalculatorEventMgmtCO.getDownPaymentAmount() != null)
	{
	    IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	    iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisDealChargesCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	    iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisDealChargesCO.setCallType("P");
	    iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    iisDealChargesCO.setDealNo(null);// in case of calculator the deal
	    // no is not needed as per manoj.
	    iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getDealAmount());
	    iisDealChargesCO.setDownPaymentAmount(islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	    iisDealChargesCO = null;
	}
	// Set VAT Percentage for the new Start Date
	if(islamicCalculatorEventMgmtCO.getCompCode() != null && islamicCalculatorEventMgmtCO.getVatCode() != null
		&& doubleValue(islamicCalculatorEventMgmtCO.getVatCode()) > 0
		&& islamicCalculatorEventMgmtCO.getStartDate() != null)
	{
		//-- Added by Manoj on 21/06/2019 for BMO180067 
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCO.setVatCode(islamicCalculatorEventMgmtCO.getVatCode());
	    iisCommonCO.setAccBr(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCO.setAccCy(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisCommonCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	    iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    //double vatPercentage = iisCommonBO.returnVatPercentage(iisCommonCO);
	    BigDecimal vatPercentage = BigDecimal.ZERO;
	    iisCommonCO = iisCommonBO.returnCommonVatDetails(iisCommonCO);
	    if(iisCommonCO != null) {
	    	vatPercentage = iisCommonCO.getVatRate();
	    }
	    islamicCalculatorEventMgmtCO.setVatPercentage(vatPercentage);

	}
	iisCommonCOForYield = null;
	// Added by Linchu for Annual Yield
	islamicCalculatorEventMgmtCO = iisCommonBO.calculateTotalAnnualYield(islamicCalculatorEventMgmtCO);
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for getting getTRSClassParams
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     */
    protected TRSCLASSVO getTRSClassParams(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	return islamicCalculatorEventMgmtDAO.getTRSClassParams(islamicCalculatorEventMgmtCO);
    }

    /**
     * Method for getting the Vat Percentage
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     */
    /*
     * private BigDecimal getVatPercentage(IslamicCalculatorEventMgmtCO
     * islamicCalculatorEventMgmtCO) throws BaseException {
     * if(islamicCalculatorEventMgmtCO.getVatCode() == null ||
     * doubleValue(islamicCalculatorEventMgmtCO.getVatCode()) < 0) { return
     * null; } IslamicCalculatorEventMgmtCO vatPercentageByPeriod =
     * islamicCalculatorEventMgmtDAO
     * .getVatPercentageByPeriod(islamicCalculatorEventMgmtCO);
     * if(vatPercentageByPeriod == null) {
     * islamicCalculatorEventMgmtCO.setFromDate(null); vatPercentageByPeriod =
     * islamicCalculatorEventMgmtDAO
     * .getVatPercentageByPeriod(islamicCalculatorEventMgmtCO);
     * if(vatPercentageByPeriod == null) { throw new
     * BOException(MessageCodes.VAT_PERC_NOT_DEFINED_FOR_THE_VAT_CODE); } else {
     * // throw new //BOException(MessageCodes.
     * VAT_PERCENTAGE_NOT_DEFINED_FOR_THE_VAT_CODE_FOR_THE_DEAL_WANT_TO_CONTINUE
     * , // ConstantsCommon.CONFIRM_MSG_TYPE);
     * islamicCalculatorEventMgmtCO.setConfirmationMessageId("902347"); } }
     * return null; }
     */

    /**
     * Method for validating maturity date
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO validateOnChangeMaturityDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	BigDecimal productClass = islamicCalculatorEventMgmtCO.getProductClass();
	if(productClass == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	TRSCLASSVO trsclassvo = new TRSCLASSVO();
	trsclassvo.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	trsclassvo.setCODE(productClass);
	trsclassvo = commonLibBO.returnTrsClassVO(trsclassvo);
	if(trsclassvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	if(islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	{

	    // Start Date >= Maturity Date
	    if(islamicCalculatorEventMgmtCO.getStartDate().after(islamicCalculatorEventMgmtCO.getMaturityDate()))
	    {
		throw new BOException(MessageCodes.MAT_DTE_CANT_BEFORE_OR_EQUALTO_START_DTE);
	    }
	    if(islamicCalculatorEventMgmtCO.getFirstPaymentDate() != null && islamicCalculatorEventMgmtCO
		    .getFirstPaymentDate().after(islamicCalculatorEventMgmtCO.getMaturityDate()))
	    {
		// first Payment Date >= Maturity Date

		throw new BOException(MessageCodes.MAT_DTE_CANT_BE_BEFORE_FIRST_PAYMENT_DTE);

	    }
	    TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	    if(trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN() != null)
	    {
		String flag = trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN();
		if(flag.equals(ConstantsCommon.YES)
			/*
			 * &&
			 * (islamicCalculatorEventMgmtCO.getDefaultMaturityDate(
			 * ).compareTo (
			 * islamicCalculatorEventMgmtCO.getMaturityDate())!=0)
			 */
			&& !(islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate()))
		{
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId("902080");
		    islamicCalculatorEventMgmtCO.setCheckDefaultMaturityDate(true);
		}
	    }
	    trsClassVO = null;
	}
	if(StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom()).isEmpty())
	{
	    long noOfDays = DateUtil.numberOfDays(islamicCalculatorEventMgmtCO.getStartDate(),
		    islamicCalculatorEventMgmtCO.getMaturityDate());
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCO.setCifNo(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getCifNo()));
	    iisCommonCO.setProductClass(productClass);
	    iisCommonCO.setLimitCode(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getLimitSerialNo()));
	    iisCommonCO.setPaymPeriodNbr(new BigDecimal(noOfDays));

	    IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();
	    iisctrlvoKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    iisctrlvoKey.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getBranchCode());
	    IISCTRLVO iisctrlVO = iisCommonBO.returnIISCTRL(iisctrlvoKey);
	    iisCommonCO.setAllowMultipleClassLimit(
		    StringUtil.nullEmptyToValue(iisctrlVO.getALLOW_MULTIPLE_CLASS_LIMIT(), ConstantsCommon.NO));

	    iisCommonCO.setPaymPeriodicity("D");
	    iisCommonCO.setDealType(trsclassvo.getCATEGORY());
	    if(ConstantsCommon.YES.equals(iisCommonCO.getAllowMultipleClassLimit())
		    && iisCommonCO.getLimitCode().compareTo(BigDecimal.ZERO) == 0)
	    {

		return islamicCalculatorEventMgmtCO;
	    }

	    iisCommonBO.checkClassLimitTenure(iisCommonCO);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating values based on maturity date
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeMaturityDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getMaturityDate() != null && islamicCalculatorEventMgmtCO.getCompCode() != null
		&& islamicCalculatorEventMgmtCO.getBranchCode() != null
		&& islamicCalculatorEventMgmtCO.getProductClass() != null
		&& islamicCalculatorEventMgmtCO.getCurrencyCode() != null)
	{
	    /*
	     * { //getting the new maturity date based on the parameters.
	     * if(islamicCalculatorEventMgmtCO.getNoOfPayments()!=null &&
	     * islamicCalculatorEventMgmtCO.getPaymPeriodicity()!=null &&
	     * islamicCalculatorEventMgmtCO.getPaymPeriodNbr()!=null &&
	     * islamicCalculatorEventMgmtCO.getPaymPeriodPos()!=null &&
	     * islamicCalculatorEventMgmtCO.getStartDate()!=null &&
	     * islamicCalculatorEventMgmtCO.getCompCode()!=null &&
	     * islamicCalculatorEventMgmtCO.getBranchCode()!=null) { IISCommonCO
	     * iisCommonCO = new IISCommonCO();
	     * iisCommonCO.setNoOfPayments(islamicCalculatorEventMgmtCO
	     * .getNoOfPayments());
	     * iisCommonCO.setPaymPeriodicity(islamicCalculatorEventMgmtCO
	     * .getPaymPeriodicity());
	     * iisCommonCO.setPaymPeriodNbr(islamicCalculatorEventMgmtCO
	     * .getPaymPeriodNbr());
	     * iisCommonCO.setPaymPeriodPos(islamicCalculatorEventMgmtCO
	     * .getPaymPeriodPos()); iisCommonCO.setValue("COMMENCE");
	     * iisCommonCO
	     * .setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	     * iisCommonCO
	     * .setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	     * iisCommonCO
	     * .setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	     * iisCommonCO = iisCommonBO.getMaturitydate(iisCommonCO);
	     * islamicCalculatorEventMgmtCO
	     * .setMaturityDate(iisCommonCO.getMaturityDate()); //
	     * islamicCalculatorEventMgmtCO
	     * .setMaturityDateAfterHoliday(iisCommonCO.getMaturityDate());
	     * iisCommonCO = null; }
	     */
	    // Check whether new Maturity Date is holiday and the respective
	    // holiday action

	    if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    {
		// TODO
		/*
		 * ldt_vdate = DateTime(This.GetText()) If
		 * IsNull(il_holiday_action) Then il_holiday_action = 0 ld_hdate
		 * = uf_check_currency_holiday(ldt_vdate, 'M',
		 * This.GetItemNumber(1,'currency_code'), il_holiday_action,
		 * This.GetItemNumber(1,'product_class'),
		 * gnv_iis_globalvar.is_holiday_action_deal_vdate_yn,
		 * dw_countryholiday) If Not IsNull(ld_hdate) And ld_hdate <>
		 * ldt_vdate Then ls_date = String(ld_hdate)
		 * this.SetText(ls_date) ldt_vdate = ld_hdate
		 * lb_holiday_date_changed = True ElseIf IsNull(ld_hdate) Then
		 * this.setText(iv_colvalue) Return 1 End If
		 */

		islamicCalculatorEventMgmtCO.setGracePeriodicity("D");

		islamicCalculatorEventMgmtCO.setNoOfPayments(BigDecimal.ONE);

		if("N".equals(islamicCalculatorEventMgmtCO.getPriceUserTypedYN()))
		{
		    iisCommonBO.applyBillsCalculatorYield(islamicCalculatorEventMgmtCO);
		}
		else
		{

		    iisCommonBO.applyPriceSetCalculator(islamicCalculatorEventMgmtCO);
		}

		// ll_days =
		// DaysAfter(Date(This.GetItemDateTime(1,"value_date")),dAte(Left(This.GetText(),10)))
		islamicCalculatorEventMgmtCO.setIborRatePeriodicityType("D");

		// This.SetItem(1,"periodicity_nbr",ll_days)

	    }

	    IISCommonCO iisCommonCOForHolidayAction = new IISCommonCO();
	    iisCommonCOForHolidayAction.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCOForHolidayAction.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCOForHolidayAction.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());

	    String holidayActionDealvalueDateYn = iisCommonBO
		    .returnHolidayActionDealDateYn(iisCommonCOForHolidayAction);
	    BigDecimal holidayAction = iisCommonBO.returnHolidayAction(iisCommonCOForHolidayAction);
	    IISHolidayCheckCO iisHolidayCheckCO = new IISHolidayCheckCO();
	    iisHolidayCheckCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisHolidayCheckCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisHolidayCheckCO.setDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisHolidayCheckCO.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisHolidayCheckCO.setDateType("M");
	    iisHolidayCheckCO.setApplyYearHoliday(holidayActionDealvalueDateYn);
	    iisHolidayCheckCO.setProductClassCode(islamicCalculatorEventMgmtCO.getProductClass());
	    iisHolidayCheckCO.setActionCode(holidayAction);
	    iisHolidayCheckCO = iisCommonBO.checkValueDateIsHoliday(iisHolidayCheckCO);

	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonBO.returnHolidayActions(trsClassVOKey);
	    if(iisHolidayCheckCO.getHolidayYn().equals(ConstantsCommon.YES)
		    && trsClassVO.getHOLIDAY_ACTION_WARNING_IND().equals(IISCommonConstants.MESSAGE_TYPEWARNING))
	    {
		islamicCalculatorEventMgmtCO.setMaturityDateAfterHoliday(iisHolidayCheckCO.getNewDate());
		islamicCalculatorEventMgmtCO.setConfirmationMessageId("901900");
		return islamicCalculatorEventMgmtCO;
	    }
	    trsClassVO = null;
	    trsClassVOKey = null;
	    iisCommonCOForHolidayAction = null;
	}

	return islamicCalculatorEventMgmtCO;
    }

    public IslamicCalculatorEventMgmtCO setOnChangeMaturityDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;

	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))

	{
	    double daydiffernce = DateUtil.numberOfDays(islamicCalculatorEventMgmtCO.getStartDate(),
		    islamicCalculatorEventMgmtCO.getMaturityDate());
	    islamicCalculatorEventMgmtCO.setGracePeriod(BigDecimal.valueOf(daydiffernce));
	    islamicCalculatorEventMgmtCO.setGracePeriodicity("D");
	    islamicCalculatorEventMgmtCO.setPeriodicityType("D");
	    islamicCalculatorEventMgmtCO.setPeriodicityNbr(BigDecimal.valueOf(daydiffernce));
	}
	if(islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday() != null
		&& islamicCalculatorEventMgmtCO.getConfirmationResult())
	{
	    islamicCalculatorEventMgmtCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	}
	if(islamicCalculatorEventMgmtCO.getMaturityDate() != null
		&& islamicCalculatorEventMgmtCO.getPaymPeriodicity() != null
		&& islamicCalculatorEventMgmtCO.getPaymPeriodPos() != null
		&& islamicCalculatorEventMgmtCO.getPaymPeriodNbr() != null
		&& islamicCalculatorEventMgmtCO.getFirstPaymentDate() != null)
	{// Set Number of Payments SERVICE TEAM of_set_no_of_payments()
	    IISCommonCO iisCommon = new IISCommonCO();
	    iisCommon.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisCommon.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    iisCommon.setPaymPeriodPos(islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    iisCommon.setPaymPeriodNbr(islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    iisCommon.setFirstPayDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    iisCommon = iisCommonBO.returnNumberofPayments(iisCommon);
	    // TP#212697;Sreejith; 11/09/2014
	    if(islamicCalculatorEventMgmtCO.getPaymPeriodicity().equals("M"))
	    {
		iisCommon.setNoOfPayments(BigDecimal.valueOf(iisCommon.getNoOfPayments().longValue() + 1));
	    }
	    islamicCalculatorEventMgmtCO.setNoOfPayments(BigDecimal.valueOf(iisCommon.getNoOfPayments().longValue()));
	    iisCommon = null;
	}

	// Recalculate Charges based on the new Financing Amt SERVICE TEAM
	// of_recalculate_charges()
	if(islamicCalculatorEventMgmtCO.getProductClass() != null && islamicCalculatorEventMgmtCO.getCompCode() != null
		&& islamicCalculatorEventMgmtCO.getBranchCode() != null
		// && islamicCalculatorEventMgmtCO.getCifNo()!=null //Added by
		// Linchu as cif nu can be null also to view the deal charges.
		&& islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getMaturityDate() != null
		&& islamicCalculatorEventMgmtCO.getCurrencyCode() != null
		&& islamicCalculatorEventMgmtCO.getDealAmount() != null
		&& islamicCalculatorEventMgmtCO.getDownPaymentAmount() != null)
	{
	    IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	    iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisDealChargesCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	    iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisDealChargesCO.setCallType("O");
	    iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    iisDealChargesCO.setDealNo(null);// As per manoj no need of deal no
	    iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getDealAmount());
	    iisDealChargesCO.setDownPaymentAmount(islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    iisDealChargesCO.setIisTrsdealchargesCO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	    iisDealChargesCO = null;
	}
	// Added by Linchu for Annual Yield
	islamicCalculatorEventMgmtCO = iisCommonBO.calculateTotalAnnualYield(islamicCalculatorEventMgmtCO);

	// TP#212256; Ramesh; Date 25/08/2014 [START]
	if(islamicCalculatorEventMgmtCO.getSalaryWithBank() == null)
	{
	    islamicCalculatorEventMgmtCO.setSalaryWithBank(ConstantsCommon.NO);
	}
	IISCommonCO iisCommonCO = iisIslamicCalculatorBO.calculateYield(islamicCalculatorEventMgmtCO);
	if(iisCommonCO != null && iisCommonCO.getOrginalYield() != null)
	{

	    islamicCalculatorEventMgmtCO.setYield(iisCommonCO.getOrginalYield());
	    islamicCalculatorEventMgmtCO.setMargin(iisCommonCO.getOrginalYield());

	}
	// TP#212256; Ramesh; Date 25/08/2014 [END]
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for getting the data based on yield rate.
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeYield(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	if(islamicCalculatorEventMgmtCO.getYield() != null)
	{
	    double yieldValue = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getYield());
	    // TP#164973; Libin; 06/11/2014 adjusted it after checking with Jose
	    // as in DB its 4.12 format
	    if((yieldValue < 0.000) || (yieldValue > 9999.999999))
	    {
		throw new BOException(MessageCodes.CHECK_YIELD_VALUE, new String[] { "0", "9,999.999999" });
	    }
	}
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOForYield = new IslamicCalculatorEventMgmtCO();
	// Added by Linchu for bug fix 88852
	islamicCalculatorEventMgmtCOForYield.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	islamicCalculatorEventMgmtCOForYield.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
	// TP#212782; Ramesh; Date 27/09/2014
	islamicCalculatorEventMgmtCOForYield.setFinancingAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	islamicCalculatorEventMgmtCOForYield.setNoOfPayments(islamicCalculatorEventMgmtCO.getNoOfPayments());
	islamicCalculatorEventMgmtCOForYield.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	islamicCalculatorEventMgmtCOForYield.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	islamicCalculatorEventMgmtCOForYield.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	islamicCalculatorEventMgmtCOForYield.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	islamicCalculatorEventMgmtCOForYield.setSalaryWithBank(islamicCalculatorEventMgmtCO.getSalaryWithBank());
	// IISCommonCO commonCO = new IISCommonCO();
	IISCommonCO commonCO;
	commonCO = iisIslamicCalculatorBO.calculateYield(islamicCalculatorEventMgmtCOForYield);
	if(commonCO != null && commonCO.getOrginalYield() != null)
	{
	    // TP#212782; Ramesh; Date 27/09/2014 [START]
	    try
	    {
		islamicCalculatorEventMgmtCO = checkYieldAmendmentRange(islamicCalculatorEventMgmtCO,
			commonCO.getOrginalYield());
	    }
	    catch(BaseException e)
	    {
		// if(e.getMsgType().equals(ConstantsCommon.CONFIRM_MSG_TYPE))

		if(NumberUtil.nullToZero(e.getMsgType()) == (ConstantsCommon.CONFIRM_MSG_TYPE))
		{

		    String msg[] = commonLibBO.translateErrorMessage(e,
			    islamicCalculatorEventMgmtCO.getPrefferedLanguage());

		    StringBuffer buff = new StringBuffer();
		    for(int i = 0; i < msg.length - 1; i++)
		    {
			buff.append(msg[i]);
		    }

		    String finalMsg = buff.toString();
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId(finalMsg);
		}
		else
		{
		    throw e;
		}
	    }
	    // TP#212782; Ramesh; Date 27/09/2014 [END]

	}

	if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	{

	    if(islamicCalculatorEventMgmtCO.getTrsdealNIDCDETVOList() != null)
	    {

		if(islamicCalculatorEventMgmtCO.getTrsdealNIDCDETVOList().size() > 0)

		{
		    throw new BOException(
			    "Cannot Procced, NIDC Details exists, Please delete those rows and try again");

		}
	    }
	    if(islamicCalculatorEventMgmtCO.getYield().compareTo(BigDecimal.ZERO) < 0)
	    {

		throw new BOException("Profit Rate,Profit Rate must be greater than 0");
	    }
	    islamicCalculatorEventMgmtCO.setPriceUserTypedYN("N");
	    iisCommonBO.applyPriceSetCalculator(islamicCalculatorEventMgmtCO);

	    return islamicCalculatorEventMgmtCO;
	}

	// TP# 222800 BM140006 - Limit for Yield Roster in IIS Sreejith
	islamicCalculatorEventMgmtCO.setInformationMessageList(iisCommonBO.checkLimitYieldRoster(
		islamicCalculatorEventMgmtCO.getCompCode(), islamicCalculatorEventMgmtCO.getBranchCode(), "B",
		NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getCifNo()),
		StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getMaintainSalaryAccount()),
		NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getProductClass()),
		NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getCurrencyCode()),
		NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getFinancingAmount()),
		DateUtil.nullToInitDate(islamicCalculatorEventMgmtCO.getStartDate()),
		NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNoOfPayments()),
		StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getPaymPeriodicity()),
		NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTempCode()),
		NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getBaloonPercentage()),
		NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getYield()), false));

	// TP# 222800 BM140006 - Limit for Yield Roster in IIS Sreejith

	commonCO = null;

	islamicCalculatorEventMgmtCOForYield = null;
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for checking the yield range.
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    private IslamicCalculatorEventMgmtCO checkYieldAmendmentRange(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam, BigDecimal calculatedYieldValue)
	    throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;

	String getYieldReqFlag = "N";
	double minYieldPercent = 0;
	double maxYieldPercent = 0;
	String getMessageType = "N";

	if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getProductClass()).compareTo(BigDecimal.ZERO) > 0)
	{
	    TRSCLASSVO trsClassVO = islamicCalculatorEventMgmtDAO.getTRSClassParams(islamicCalculatorEventMgmtCO);

	    if(trsClassVO.getYIELD_REQUIRED() != null)
	    {
		getYieldReqFlag = trsClassVO.getYIELD_REQUIRED();
	    }

	    if(trsClassVO.getYIELD_AMEND_RANGE_FROM() != null)
	    {
		minYieldPercent = NumberUtil.toDouble(trsClassVO.getYIELD_AMEND_RANGE_FROM());
	    }

	    if(trsClassVO.getYIELD_AMEND_RANGE_TO() != null)
	    {
		maxYieldPercent = NumberUtil.toDouble(trsClassVO.getYIELD_AMEND_RANGE_TO());
	    }

	    if(trsClassVO.getYIELD_AMEND_MESSAGE_TYPE() != null)
	    {
		getMessageType = trsClassVO.getYIELD_AMEND_MESSAGE_TYPE();
	    }

	    if(trsClassVO.getYIELD_AMEND_RANGE_FROM() == null && trsClassVO.getYIELD_AMEND_RANGE_TO() == null)
	    {
		getMessageType = "S";
	    }
	}

	if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield()).equals(BigDecimal.ZERO)
		|| ConstantsCommon.NO.equals(getYieldReqFlag) || ConstantsCommon.NO.equals(getMessageType))
	{
	    return islamicCalculatorEventMgmtCO;
	}

	if(minYieldPercent == 0 && maxYieldPercent == 0)
	{
	    IslamicCalculatorEventMgmtCO islamicCalculatorIISCtrl = iisCommonBO
		    .returnIISControlParams(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorIISCtrl != null)
	    {
		if(islamicCalculatorIISCtrl.getYieldAmendRangeFrom() != null)
		{
		    minYieldPercent = NumberUtil.toDouble(islamicCalculatorIISCtrl.getYieldAmendRangeFrom());
		}

		if(islamicCalculatorIISCtrl.getYieldAmendRangeTo() != null)
		{
		    maxYieldPercent = NumberUtil.toDouble(islamicCalculatorIISCtrl.getYieldAmendRangeTo());
		}
	    }
	}

	if(islamicCalculatorEventMgmtCO.getYield() != null)
	{
	    double minYieldValue = NumberUtil.toDouble(calculatedYieldValue)
		    - (((NumberUtil.toDouble(calculatedYieldValue)) * minYieldPercent) / 100);
	    double yieldValue = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getYield());
	    if(minYieldValue > 0 && yieldValue < minYieldValue)
	    {
		if("S".equals(getMessageType))
		{
		    throw new BOException(MessageCodes.YEILD_CANNOT_BE_LESS_THAN,
			    new String[] { String.valueOf(minYieldValue) });
		}
		else
		{
		    int msgType = 0;
		    if("W".equals(getMessageType))
		    {
			msgType = ConstantsCommon.CONFIRM_MSG_TYPE;
		    }
		    throw new BOException(MessageCodes.YEILD_CANNOT_BE_LESS_THAN,
			    new String[] { String.valueOf(minYieldValue) }, msgType, false);
		}
	    }
	    double maxYieldValue = NumberUtil.toDouble(calculatedYieldValue)
		    + (((NumberUtil.toDouble(calculatedYieldValue)) * maxYieldPercent) / 100);

	    if(maxYieldValue > 0 && yieldValue > maxYieldValue)
	    {
		if("S".equals(getMessageType))
		{
		    throw new BOException(MessageCodes.YIELD_MAX_LIMIT_EXCEED,
			    new String[] { String.valueOf(maxYieldValue) });
		}
		else
		{
		    int msgType = 0;
		    if("W".equals(getMessageType))
		    {
			msgType = ConstantsCommon.CONFIRM_MSG_TYPE;
		    }
		    throw new BOException(MessageCodes.YIELD_MAX_LIMIT_EXCEED,
			    new String[] { String.valueOf(maxYieldValue) }, msgType, false);

		}
	    }
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method check flag required of yield
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // PMD infractions; Saheer.Naduthodi; 10/12/2014 :UnusedPrivateMethod
    // private String getYieldRequiredFlag(IslamicCalculatorEventMgmtCO
    // islamicCalculatorEventMgmtCO) throws BaseException
    // {
    // String messageOnYield = "";
    // TRSCLASSVO trsClassVO =
    // islamicCalculatorEventMgmtDAO.getTRSClassParams(islamicCalculatorEventMgmtCO);
    // if(trsClassVO.getYIELD_REQUIRED() == null)
    // {
    // messageOnYield = "F";
    // }
    // else
    // {
    // messageOnYield = trsClassVO.getYIELD_REQUIRED();
    // }
    // trsClassVO = null;
    // return messageOnYield;
    // }

    /**
     * Method for populating the total flat rate.
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeTotalFlatRate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getTotalFlatRate() != null)
	{
	    double totalFlatRate = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getTotalFlatRate());
	    if(totalFlatRate < 0)
	    {
		islamicCalculatorEventMgmtCO.setTotalFlatRate(BigDecimal.ZERO);
		throw new BOException(MessageCodes.VALUE_CANNOT_BE_LESS_THAN_ZERO);
	    }
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating data based on profit calculation method
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeProfitCalculationMethod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {

	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	// Added by Linchu on 9-06-2013 as fix for setting the compounding deal
	// period msg.
	// #TAR JAIZ140012 #TP251229 Arun R Variyath ; 05/08/2015 [Start]
	TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	if(trsClassVO != null && "Y".equals(trsClassVO.getPRFT_ACCR_ON_OUTSTAND_PRINC_YN())
		&& IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			.equals(islamicCalculatorEventMgmtCO.getProfitCalcMethod()))
	{
	    throw new BOException(MessageCodes.iis_invalid_code, new String[] {
		    "Profit_Calculation_method_should_be_Diminishing_Returns_for_Profit_Accrual_on_Outstanding_Principal_Product_key" },
		    false);
	}
	// #TAR JAIZ140012 #TP251229 Arun R Variyath ; 05/08/2015 [End]
	islamicCalculatorEventMgmtCO = populateOnChangeDealPeriodCompounding(islamicCalculatorEventMgmtCO);
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for validating grace period option
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO validateOnChangeGracePeriodOption(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	if(NumberUtil.toInt(islamicCalculatorEventMgmtCO.getGracePeriodOption()) == 0)
	{
	    islamicCalculatorEventMgmtCO.setGracePeriod(BigDecimal.valueOf(0L));
	    islamicCalculatorEventMgmtCO.setGracePeriodicity("D");
	    islamicCalculatorEventMgmtCO.setFirstPaymentDate(islamicCalculatorEventMgmtCO.getStartDate());

	    TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	    if(trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN() != null)
	    {
		String flag = trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN();
		if(flag.equals(ConstantsCommon.YES) &&
		/*
		 * && (!islamicCalculatorEventMgmtCO.getDefaultMaturityDate()
		 * .equals(islamicCalculatorEventMgmtCO.getMaturityDate())))
		 */
			(!islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate()))
		{
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId("902080");
		    islamicCalculatorEventMgmtCO.setCheckDefaultMaturityDate(true);
		}
	    }
	    trsClassVO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating grace period option
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeGracePeriodOption(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	if(islamicCalculatorEventMgmtCO.getMaturityDate() != null
		&& islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate() != null
		&& islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate())
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setNoOfPayments(islamicCalculatorEventMgmtCO.getNoOfPayments());
	    iisCommonCO.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    iisCommonCO.setPaymPeriodNbr(islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    iisCommonCO.setPaymPeriodPos(islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    iisCommonCO.setValue("COMMENCE");
	    iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisCommonCO = iisCommonBO.returnMaturitydate(iisCommonCO);
	    islamicCalculatorEventMgmtCO.setMaturityDate(iisCommonCO.getMaturityDate());

	    // Check whether new Maturity Date is holiday and the respective
	    // holiday action
	    IISHolidayCheckCO iisHolidayCheckCO = new IISHolidayCheckCO();
	    iisHolidayCheckCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisHolidayCheckCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisHolidayCheckCO.setDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisHolidayCheckCO.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisHolidayCheckCO.setDateType("M");
	    iisHolidayCheckCO.setApplyYearHoliday(iisCommonBO.returnHolidayActionDealDateYn(iisCommonCO));
	    iisHolidayCheckCO.setProductClassCode(islamicCalculatorEventMgmtCO.getProductClass());
	    iisHolidayCheckCO.setActionCode(iisCommonBO.returnHolidayAction(iisCommonCO));
	    iisHolidayCheckCO = iisCommonBO.checkValueDateIsHoliday(iisHolidayCheckCO);
	    iisCommonCO = null;

	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonBO.returnHolidayActions(trsClassVOKey);
	    trsClassVOKey = null;
	    if(iisHolidayCheckCO.getHolidayYn().equals(ConstantsCommon.YES)
		    && trsClassVO.getHOLIDAY_ACTION_WARNING_IND().equals(IISCommonConstants.MESSAGE_TYPEWARNING))
	    {
		islamicCalculatorEventMgmtCO.setMaturityDateAfterHoliday(iisHolidayCheckCO.getNewDate());
		islamicCalculatorEventMgmtCO.setConfirmationMessageId("901900");
		trsClassVO = null;
		return islamicCalculatorEventMgmtCO;
	    }
	    trsClassVO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating data based on profit First Payment After
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeFirstPaymentAfter(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	return iisIslamicCalculatorBO.populateOnChangeFirstPaymentAfterPeriodicity(islamicCalculatorEventMgmtCO);
    }

    /**
     * Method for validate data based on First Pay date
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO validateOnChangeFirstPayDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getFirstPaymentDate() != null && islamicCalculatorEventMgmtCO
			.getStartDate().after(islamicCalculatorEventMgmtCO.getFirstPaymentDate()))
	{

	    throw new BOException(MessageCodes.FIRST_PAY_DTE_SHOULD_BE_AFTER_START_DTE);

	}
	if(islamicCalculatorEventMgmtCO.getMaturityDate() != null
		&& islamicCalculatorEventMgmtCO.getFirstPaymentDate() != null && islamicCalculatorEventMgmtCO
			.getFirstPaymentDate().after(islamicCalculatorEventMgmtCO.getMaturityDate()))
	{

	    throw new BOException(MessageCodes.FIRST_DTE_SHOULD_NOT_BE_AFTER_MAT_DATE);

	}

	// Calculate the grace period.
	if(islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getFirstPaymentDate() != null
		&& islamicCalculatorEventMgmtCO.getProductClass() != null
		&& islamicCalculatorEventMgmtCO.getCompCode() != null)
	{
	    long gracePeriodCalculated = DateUtil.numberOfDays(islamicCalculatorEventMgmtCO.getStartDate(),
		    islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setGracePeriod(BigDecimal.valueOf(gracePeriodCalculated));
	    iisCommonCO.setGracePeriodicity("D");
	    iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO = iisCommonBO.checkGracePeriod(iisCommonCO);
	    islamicCalculatorEventMgmtCO.setGracePeriod(iisCommonCO.getGracePeriod());
	    islamicCalculatorEventMgmtCO.setGracePeriodicity(iisCommonCO.getGracePeriodicity());

	    // Check if the default maturity date is changed.
	    TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	    if(trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN() != null)
	    {
		String flag = trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN();
		if(flag.equals(ConstantsCommon.YES) && (!islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate()))
		{
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId("902080");
		    islamicCalculatorEventMgmtCO.setCheckDefaultMaturityDate(true);
		}
	    }// end if
	    trsClassVO = null;
	    iisCommonCO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating data based on First Pay date
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeFirstPayDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	{
	    // getting the new maturity date based on the parameters.
	    if(islamicCalculatorEventMgmtCO.getNoOfPayments() != null
		    && islamicCalculatorEventMgmtCO.getPaymPeriodicity() != null
		    && islamicCalculatorEventMgmtCO.getPaymPeriodNbr() != null
		    && islamicCalculatorEventMgmtCO.getPaymPeriodPos() != null
		    && islamicCalculatorEventMgmtCO.getStartDate() != null
		    && islamicCalculatorEventMgmtCO.getCompCode() != null
		    && islamicCalculatorEventMgmtCO.getBranchCode() != null
		    && islamicCalculatorEventMgmtCO.getFirstPaymentDate() != null)
	    {
		IISCommonCO iisCommonCO = new IISCommonCO();
		iisCommonCO.setNoOfPayments(islamicCalculatorEventMgmtCO.getNoOfPayments());
		iisCommonCO.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
		iisCommonCO.setPaymPeriodNbr(islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
		iisCommonCO.setPaymPeriodPos(islamicCalculatorEventMgmtCO.getPaymPeriodPos());
		// iisCommonCO.setFirstPayDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
		iisCommonCO.setValue("COMMENCE");
		iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
		iisCommonCO.setFirstPayDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
		iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
		// #TAR BB130030 ;Arun R Variyath ; 11/08/2015 [Start]
		String calcMatDte = StringUtil.nullEmptyToValue(iisCommonBO.returnCalcMatDteFlagValue(iisCommonCO),
			"N");
		if("Y".equals(calcMatDte))
		{
		    iisCommonCO.setPaymPeriodPos("D");
		}
		// #TAR BB130030 ;Arun R Variyath ; 11/08/2015 [End]

		iisCommonCO = iisCommonBO.returnMaturitydate(iisCommonCO);
		islamicCalculatorEventMgmtCO.setMaturityDate(iisCommonCO.getMaturityDate());
		iisCommonCO = null;
	    }

	    // Check whether new Maturity Date is holiday and the respective
	    // holiday action
	    if(islamicCalculatorEventMgmtCO.getProductClass() != null
		    && islamicCalculatorEventMgmtCO.getCompCode() != null
		    && islamicCalculatorEventMgmtCO.getBranchCode() != null
		    && islamicCalculatorEventMgmtCO.getCifNo() != null
		    && islamicCalculatorEventMgmtCO.getStartDate() != null
		    && islamicCalculatorEventMgmtCO.getMaturityDate() != null
		    && islamicCalculatorEventMgmtCO.getCurrencyCode() != null
		    && islamicCalculatorEventMgmtCO.getDealAmount() != null
		    && islamicCalculatorEventMgmtCO.getDownPaymentAmount() != null)
	    {
		IISCommonCO iisCommonCOForHolidayAction = new IISCommonCO();
		iisCommonCOForHolidayAction.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		iisCommonCOForHolidayAction.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
		iisCommonCOForHolidayAction.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());

		IISHolidayCheckCO iisHolidayCheckCO = new IISHolidayCheckCO();
		iisHolidayCheckCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		iisHolidayCheckCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
		iisHolidayCheckCO.setDate(islamicCalculatorEventMgmtCO.getMaturityDate());
		iisHolidayCheckCO.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
		iisHolidayCheckCO.setDateType("M");
		iisHolidayCheckCO
			.setApplyYearHoliday(iisCommonBO.returnHolidayActionDealDateYn(iisCommonCOForHolidayAction));
		iisHolidayCheckCO.setProductClassCode(islamicCalculatorEventMgmtCO.getProductClass());
		iisHolidayCheckCO.setActionCode(iisCommonBO.returnHolidayAction(iisCommonCOForHolidayAction));
		iisHolidayCheckCO = iisCommonBO.checkValueDateIsHoliday(iisHolidayCheckCO);
		iisCommonCOForHolidayAction = null;

		iisHolidayCheckCO.setDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
		IISHolidayCheckCO iisHolidayCheckCOFirstPayment = iisCommonBO
			.checkValueDateIsHoliday(iisHolidayCheckCO);

		TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
		trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
		trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
		TRSCLASSVO trsClassVO = iisCommonBO.returnHolidayActions(trsClassVOKey);
		trsClassVOKey = null;
		if(iisHolidayCheckCO.getHolidayYn().equals(ConstantsCommon.YES)
			&& trsClassVO.getHOLIDAY_ACTION_WARNING_IND().equals(IISCommonConstants.MESSAGE_TYPEWARNING))
		{
		    islamicCalculatorEventMgmtCO.setMaturityDateAfterHoliday(iisHolidayCheckCO.getNewDate());
		    islamicCalculatorEventMgmtCO.setFirstPaymentDate(iisHolidayCheckCOFirstPayment.getNewDate());
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId("901900");
		    iisHolidayCheckCO = null;
		    trsClassVO = null;
		    return islamicCalculatorEventMgmtCO;
		}
		trsClassVO = null;
		iisHolidayCheckCO = null;
	    } // Recalculate Charges based on the new Maturity Date
	}

	return islamicCalculatorEventMgmtCO; // call calculateDealCharges
    }

    /**
     * Method for populating data based on amount per payment
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeAmountPerPayment(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	// islamicCalculatorEventMgmtCO.getCompCode();
	if(islamicCalculatorEventMgmtCO != null && islamicCalculatorEventMgmtCO.getCompCode() == null
		|| islamicCalculatorEventMgmtCO.getFinancingCurrency() == null)
	{

	    return islamicCalculatorEventMgmtCO;

	}
	double amountperpayment = doubleValue(islamicCalculatorEventMgmtCO.getAmountPerPayment());
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOMain = islamicCalculatorEventMgmtDAO
		.selectCurrencyUnitDetails(islamicCalculatorEventMgmtCO);
	BigDecimal currencyDecimalPoints = islamicCalculatorEventMgmtCOMain.getCurrencyDecimalPoints();
	double minimumAmount = 0D;
	double maximumAmount = 0D;

	StringBuffer nineValue = new StringBuffer("999999999999.");

	for(int i = 0; i < NumberUtil.toInt(currencyDecimalPoints); i++)
	{
	    // if(nineValue.toString().equals(""))
	    // {
	    // nineValue.append("9");
	    // }
	    // else
	    // {
	    nineValue.append("9");
	    // }
	}
	// nineValue.append("999999999999.").append(nineValue);
	// currencyDecimalPoints = null;

	maximumAmount = NumberUtil.toDouble(nineValue.toString());
	if(amountperpayment < minimumAmount)
	{
	    throw new BOException(MessageCodes.AMT_SHOULD_BE_BTW_0_AND_999999999,
		    new String[] { StringUtil.nullToEmpty(minimumAmount), StringUtil.nullToEmpty(
			    NumberUtil.format(maximumAmount, NumberUtil.currencyMask(currencyDecimalPoints))) });
	}
	if(amountperpayment > maximumAmount)
	{
	    throw new BOException(MessageCodes.AMT_SHOULD_BE_BTW_0_AND_999999999,
		    new String[] { StringUtil.nullToEmpty(minimumAmount), StringUtil.nullToEmpty(
			    NumberUtil.format(maximumAmount, NumberUtil.currencyMask(currencyDecimalPoints))) });

	}

	double totalAmount = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getFinancingAmount())
		+ NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getTotalInsuranceAmt());
	double profit = totalAmount * (NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getYield()) / 100);
	double perDayProfit = profit / 365;
	double daysafter = DateUtil.numberOfDays(islamicCalculatorEventMgmtCO.getStartDate(),
		islamicCalculatorEventMgmtCO.getMaturityDate(), "dd/MM/yyyy");
	double totalProfitforDealPeriod = daysafter * perDayProfit;
	double totalInstallmentAmt = totalAmount + totalProfitforDealPeriod;

	double totalAmtPerPayment = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getAmountPerPayment())
		* NumberUtil.toInt(islamicCalculatorEventMgmtCO.getNoOfPayments());

	if(totalAmtPerPayment > totalInstallmentAmt)
	{
	    throw new BOException(MessageCodes.TOTAL_AMT_CANNOT_BE_GRT_THAN_PRINCIPAL_AMT);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for getting MinMaxRep
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     */
    private IslamicCalculatorEventMgmtCO validateMinMaxRepayments(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO, int minNoOfPayments, int maxNoOfPayments)
	    throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getNoOfPayments() != null)
	{
	    int noOfPayments = NumberUtil.toInt(islamicCalculatorEventMgmtCO.getNoOfPayments());
	    if((minNoOfPayments > noOfPayments) || (noOfPayments > maxNoOfPayments))
	    {
		throw new BOException(MessageCodes.INVALID_NUMBER_OF_PAYMENTS);
	    }
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for validate data based on number of payments
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO validateOnChangeNoOfPayments(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {

	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;

	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	if(islamicCalculatorEventMgmtCO.getNoOfPayments() != null
		&& NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getNoOfPayments()) <= 0)
	{

	    throw new BOException(MessageCodes.INVALID_NUMBER_OF_PAYMENTS);

	}
	// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
	if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getFlexiPaymentYn()) && NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNoOfPayments()).compareTo(BigDecimal.ONE) < 1)
	{
	    throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_ALLOWED_FOR_NUMBER_OF_PAYMENTS_GREATER_THAN_1);
	}
	// BB160136; Saheer.Naduthodi; 20/04/2017 [End]
	TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	if(trsClassVO != null)
	{
	    if(trsClassVO.getREPAYMENTS_MIN() != null || trsClassVO.getREPAYMENTS_MAX() != null)

	    {
		int minNoOfPayments = NumberUtil.toInt(trsClassVO.getREPAYMENTS_MIN());
		int maxNoOfPayments = NumberUtil.toInt(trsClassVO.getREPAYMENTS_MAX());

		// Validating the minimum and maximum number of payments.
		islamicCalculatorEventMgmtCO = validateMinMaxRepayments(islamicCalculatorEventMgmtCO, minNoOfPayments,
			maxNoOfPayments);
	    }
	    if(trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN() != null)
	    {
		String flag = trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN();
		if(flag.equals(ConstantsCommon.YES)
			/*
			 * &&
			 * (islamicCalculatorEventMgmtCO.getDefaultMaturityDate(
			 * ) // Commented as per manoj this cheking not needed
			 * as maturity date will change on changing number of
			 * payments .compareTo(islamicCalculatorEventMgmtCO
			 * .getMaturityDate())!=0)
			 */
			&& !(islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate()))
		{
			islamicCalculatorEventMgmtCO.setParams(new String[] {"",islamicCalculatorEventMgmtCO.getProductClass().toString()});
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId("902080");
		    islamicCalculatorEventMgmtCO.setCheckDefaultMaturityDate(true);
		}
	    }
	}
	trsClassVO = null;
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating data based on number of payments
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeNoOfPayments(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	{
	    // getting the new maturity date based on the parameters.
	    if(islamicCalculatorEventMgmtCO.getNoOfPayments() != null
		    && islamicCalculatorEventMgmtCO.getPaymPeriodicity() != null
		    && islamicCalculatorEventMgmtCO.getPaymPeriodNbr() != null
		    && islamicCalculatorEventMgmtCO.getPaymPeriodPos() != null
		    && islamicCalculatorEventMgmtCO.getStartDate() != null
		    && islamicCalculatorEventMgmtCO.getCompCode() != null
		    && islamicCalculatorEventMgmtCO.getBranchCode() != null
		    && islamicCalculatorEventMgmtCO.getFirstPaymentDate() != null)
	    {
		IISCommonCO iisCommonCO = new IISCommonCO();
		iisCommonCO.setNoOfPayments(islamicCalculatorEventMgmtCO.getNoOfPayments());
		iisCommonCO.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
		iisCommonCO.setPaymPeriodNbr(islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
		iisCommonCO.setPaymPeriodPos(islamicCalculatorEventMgmtCO.getPaymPeriodPos());
		iisCommonCO.setValue("COMMENCE");
		iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
		// Modifed by manoj on 01/03/2018
		iisCommonCO.setFirstPayDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
		// // #TAR BB130030 ;Arun R Variyath ; 11/08/2015 [Start]
		String calcMatDte = StringUtil.nullEmptyToValue(iisCommonBO.returnCalcMatDteFlagValue(iisCommonCO),
			"N");
		if("Y".equals(calcMatDte))
		{
		    iisCommonCO.setPaymPeriodPos("D");
		}
		// #TAR BB130030 ;Arun R Variyath ; 11/08/2015 [End]
		iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());

		iisCommonCO = iisCommonBO.returnMaturitydate(iisCommonCO);
		islamicCalculatorEventMgmtCO.setMaturityDate(iisCommonCO.getMaturityDate());
		islamicCalculatorEventMgmtCO.setMaturityDateAfterHoliday(iisCommonCO.getMaturityDate());
		iisCommonCO = null;
	    }
	    // Check whether new Maturity Date is holiday and the respective
	    // holiday action
	    if(islamicCalculatorEventMgmtCO.getProductClass() != null
		    && islamicCalculatorEventMgmtCO.getCompCode() != null
		    && islamicCalculatorEventMgmtCO.getBranchCode() != null
		    && islamicCalculatorEventMgmtCO.getCifNo() != null
		    && islamicCalculatorEventMgmtCO.getStartDate() != null
		    && islamicCalculatorEventMgmtCO.getMaturityDate() != null
		    && islamicCalculatorEventMgmtCO.getCurrencyCode() != null
		    && islamicCalculatorEventMgmtCO.getDealAmount() != null
		    && islamicCalculatorEventMgmtCO.getDownPaymentAmount() != null)
	    {
		IISCommonCO iisCommonCOForHolidayAction = new IISCommonCO();
		iisCommonCOForHolidayAction.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		iisCommonCOForHolidayAction.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
		iisCommonCOForHolidayAction.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());

		IISHolidayCheckCO iisHolidayCheckCO = new IISHolidayCheckCO();
		iisHolidayCheckCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		iisHolidayCheckCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
		iisHolidayCheckCO.setDate(islamicCalculatorEventMgmtCO.getMaturityDate());
		iisHolidayCheckCO.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
		iisHolidayCheckCO.setDateType("M");
		iisHolidayCheckCO
			.setApplyYearHoliday(iisCommonBO.returnHolidayActionDealDateYn(iisCommonCOForHolidayAction));
		iisHolidayCheckCO.setProductClassCode(islamicCalculatorEventMgmtCO.getProductClass());
		iisHolidayCheckCO.setActionCode(iisCommonBO.returnHolidayAction(iisCommonCOForHolidayAction));
		iisHolidayCheckCO = iisCommonBO.checkValueDateIsHoliday(iisHolidayCheckCO);
		iisCommonCOForHolidayAction = null;

		TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
		trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
		trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
		TRSCLASSVO trsClassVO = iisCommonBO.returnHolidayActions(trsClassVOKey);
		trsClassVOKey = null;
		if(iisHolidayCheckCO.getHolidayYn().equals(ConstantsCommon.YES)
			&& trsClassVO.getHOLIDAY_ACTION_WARNING_IND().equals(IISCommonConstants.MESSAGE_TYPEWARNING))
		{
		    islamicCalculatorEventMgmtCO.setMaturityDateAfterHoliday(iisHolidayCheckCO.getNewDate());
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId("901900");
		    trsClassVO = null;
		    iisHolidayCheckCO = null;
		    return islamicCalculatorEventMgmtCO;
		}
		trsClassVO = null;
		iisHolidayCheckCO = null;
	    } // Recalculate Charges based on the new Maturity Date

	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Moved to iiscommonBO for LOS - Method for validate data based on pay
     * every
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // public IslamicCalculatorEventMgmtCO validateOnChangePayEvery(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws
    // BaseException
    // {
    //
    // }

    /**
     * Method for validate data based on pay every Periodicity
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO validateOnChangePayEveryPeriodicity(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	// 02/02/2015 Snitha
	if(islamicCalculatorEventMgmtCO.getPaymPeriodNbr().compareTo(BigDecimal.ZERO) == 0)
	{
	    throw new BOException(MessageCodes.CANNOT_BE_LESS_EQUAL_TO_ZERO);

	}
	// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
	if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getFlexiPaymentYn())
		&& !IISCommonConstants.MONTH.equals(islamicCalculatorEventMgmtCO.getPaymPeriodicity()))
	{
	    throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_ALLOWED_FOR_MONTHLY_INSTALLMENT);
	}
	// BB160136; Saheer.Naduthodi; 20/04/2017 [End]

	if(islamicCalculatorEventMgmtCO.getProductClass() != null
		&& doubleValue(islamicCalculatorEventMgmtCO.getProductClass()) > 0
		&& islamicCalculatorEventMgmtCO.getCompCode() != null)
	{
	    TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	    if(trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN() != null
		    && islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate() != null
		    && trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN().equals(ConstantsCommon.YES)
		    && (!islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate()))
	    {

		islamicCalculatorEventMgmtCO.setConfirmationMessageId("902080");
		islamicCalculatorEventMgmtCO.setCheckDefaultMaturityDate(true);

	    }
	    trsClassVO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }// then call populateOnChangeNoOfPayments

    /**
     * Method for validate data based on pay every Position
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO validateOnChangePayEveryPosition(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	if(trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN() != null
		&& islamicCalculatorEventMgmtCO.getDefaultMaturityDate() != null
		&& islamicCalculatorEventMgmtCO.getMaturityDate() != null
		&& trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN().equals(ConstantsCommon.YES)
		&& (!islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate()))
	{

	    islamicCalculatorEventMgmtCO.setConfirmationMessageId("902080");
	    islamicCalculatorEventMgmtCO.setCheckDefaultMaturityDate(true);

	}
	trsClassVO = null;
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating data based on Template Code
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeTemplateCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {

	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	if(NumberUtil.toInt(islamicCalculatorEventMgmtCO.getTempCode()) > 0)
	{
	    islamicCalculatorEventMgmtCO.setEventType("T");
	    String tempDesc = islamicCalculatorEventMgmtDAO.getTemplateDesc(islamicCalculatorEventMgmtCO);
	    if(tempDesc == null)
	    {
		throw new BOException(MessageCodes.INVALID_TEMPLATE_CODE);
	    }
	    // BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
	    if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getFlexiPaymentYn()) && NumberUtil
		    .emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTempCode()).compareTo(BigDecimal.ZERO) == 1)
	    {
		throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_NOT_APPLICABLE_WITH_REPAYMENT_PLAN_TEMPLATE);
	    }
	    // BB160136; Saheer.Naduthodi; 20/04/2017 [End]
	    // TRSPAYPLANTMPLTVO trsPayplanTmpltVO = new TRSPAYPLANTMPLTVO();
	    TRSPAYPLANTMPLTVO trsPayplanTmpltVO;
	    TRSPAYPLANTMPLTVOKey trspayplantmptvoKey = new TRSPAYPLANTMPLTVOKey();
	    trspayplantmptvoKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trspayplantmptvoKey.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getBranchCode());
	    trspayplantmptvoKey.setTEMPLATE_CODE(islamicCalculatorEventMgmtCO.getTempCode());
	    trsPayplanTmpltVO = islamicCalculatorEventMgmtDAO.getTemplateDetails(trspayplantmptvoKey);
	    trspayplantmptvoKey = null;

	    // Set the Template values
	    islamicCalculatorEventMgmtCO.setProfitCalcMethod(trsPayplanTmpltVO.getPROFIT_CALCULATION_METHOD());
	    islamicCalculatorEventMgmtCO.setProfitDistMethod(trsPayplanTmpltVO.getPROFIT_DIST_METHOD());
	    islamicCalculatorEventMgmtCO.setPaymPeriodicity(trsPayplanTmpltVO.getPAYM_PERIODICITY());
	    islamicCalculatorEventMgmtCO.setPaymPeriodNbr(trsPayplanTmpltVO.getPAYM_PERIOD_NBR());
	    islamicCalculatorEventMgmtCO.setPaymPeriodPos(trsPayplanTmpltVO.getPAYM_PERIOD_POS());
	    islamicCalculatorEventMgmtCO.setPayResAmt((trsPayplanTmpltVO.getPAY_RES_AMT()));
	    islamicCalculatorEventMgmtCO.setGracePeriod(trsPayplanTmpltVO.getGRACE_PERIOD());
	    islamicCalculatorEventMgmtCO.setGracePeriodicity((trsPayplanTmpltVO.getGRACE_PERIODICITY()));
	    islamicCalculatorEventMgmtCO.setGracePeriodOption(((trsPayplanTmpltVO.getGRACE_PERIOD_OPTION())));
	    islamicCalculatorEventMgmtCO.setBaloonAmount(trsPayplanTmpltVO.getBALLOON_AMT());
	    islamicCalculatorEventMgmtCO.setNoOfBaloonPayments((trsPayplanTmpltVO.getNO_OF_BALLOONS()));
	    islamicCalculatorEventMgmtCO.setNoOfPayments(trsPayplanTmpltVO.getNO_OF_PAYMENTS());
	    islamicCalculatorEventMgmtCO = populateOnChangeNoOfPayments(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = populateOnChangeFirstPaymentAfter(islamicCalculatorEventMgmtCO);
	    iisIslamicCalculatorBO.calculateYield(islamicCalculatorEventMgmtCO);
	    // added for 90714: While using the template repayment plan the
	    // balloon payments defaulted are wrong
	    if(islamicCalculatorEventMgmtCO.getFinancingAmount() != null && trsPayplanTmpltVO.getBALLOON_AMT() != null
		    && NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getFinancingAmount()) > 0
		    && NumberUtil.toDouble(trsPayplanTmpltVO.getBALLOON_AMT()) > 0)
	    {
		islamicCalculatorEventMgmtCO
			.setBaloonPercentage(BigDecimal.valueOf(NumberUtil.toDouble(trsPayplanTmpltVO.getBALLOON_AMT())
				/ NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getFinancingAmount()) * 100));
		iisIslamicCalculatorBO.populateBaloonPaymentGrid(islamicCalculatorEventMgmtCO);
	    }

	    trsPayplanTmpltVO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating data based on Deal Period Compounding
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeDealPeriodCompounding(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getProductClass()).compareTo(BigDecimal.ZERO) != 1)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
	if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getFlexiPaymentYn())
		&& ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getDealPeriodCompounding()))
	{
	    throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_NOT_APPLICABLE_WITH_DEAL_PERIOD_COMPOUNDING);
	}
	// BB160136; Saheer.Naduthodi; 20/04/2017 [End]
	// added by Linchu for fix of deal period compounding.
	// TP#165241; Ramesh; Date 25/08/2014
	if((islamicCalculatorEventMgmtCO.getDealPeriodCompounding().equals(ConstantsCommon.YES))
		&& (!((islamicCalculatorEventMgmtCO.getProfitCalcMethod()
			.equals(IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS))
			&& (islamicCalculatorEventMgmtCO.getProfitDistMethod()
				.equals(IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS))
			&& (islamicCalculatorEventMgmtCO.getPrincipalLast().equals(ConstantsCommon.NO))
			&& (selectProfitUpfront(islamicCalculatorEventMgmtCO).equals(ConstantsCommon.YES)))))
	{
	    throw new BOException(MessageCodes.MSG_DEAL_PERIOD_COMPOUNDING);
	}

	return islamicCalculatorEventMgmtCO;
    }

    /****
     * Method to get the profit up front based on the product class
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     */
    private String selectProfitUpfront(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	TRSCLASSVO trsclassvo = new TRSCLASSVO();
	trsclassvo.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	trsclassvo.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	trsclassvo = commonLibBO.returnTrsClassVO(trsclassvo);
	if(trsclassvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	return trsclassvo.getPROFIT_UPFRONT() == null ? islamicCalculatorEventMgmtCO.getProfitUpfront()
		: trsclassvo.getPROFIT_UPFRONT();
    }

    /**
     * Method for populating data based on Vat Applicable
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeVatApplicable(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getVatApplicable().equals(ConstantsCommon.NO))
	{
	    islamicCalculatorEventMgmtCO.setVatCode(null);
	    islamicCalculatorEventMgmtCO.setVatDesc(null);
	    islamicCalculatorEventMgmtCO.setIncludeVatinInstallment("N");
	    islamicCalculatorEventMgmtCO.setVatPercentage(BigDecimal.ZERO);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating data based on Vat Installment
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeVatInstallment(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getIncludeVatinInstallment().equals(ConstantsCommon.YES))
	{

	    // #TAR JAIZ140012 #TP251229 Arun R Variyath ; 06/08/2015 [Start]
	    if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	    }
	    TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	    if(trsClassVO != null && "Y".equals(trsClassVO.getPRFT_ACCR_ON_OUTSTAND_PRINC_YN()))
	    {
		throw new BOException(MessageCodes.iis_invalid_code,
			new String[] {
				"VAT_is_not_applicable_for_Profit_Accrual_on_Outstanding_Principal_Product_key" },
			false);
	    }
	    // #TAR JAIZ140012 #TP251229 Arun R Variyath ; 06/08/2015 [Start]
	    BigDecimal vatCode = islamicCalculatorEventMgmtCO.getVatCode();
	    if(vatCode == null)
	    {
		vatCode = BigDecimal.ZERO;
	    }
	    if(vatCode.intValue() > 0)
	    {
		String vatIndicator = islamicCalculatorEventMgmtDAO.getVatIndicator(islamicCalculatorEventMgmtCO);
		if(vatIndicator == null)
		{
		    vatIndicator = "I";
		}
		if(vatIndicator.equals(IISCommonConstants.VAT_PERCENTAGE_INDICATOR_DEAL_PROFIT)
			|| vatIndicator.equals(IISCommonConstants.VAT_PERCENTAGE_INDICATOR_INSTALLMENT))
		{
		    islamicCalculatorEventMgmtCO.setIncludeVatinInstallment("N");
		    // Removed this exceptipn as per done in PB
		    // throw new
		    // BOException(MessageCodes.VAT_PERCENTAGE_ON_VALIDATION);
		}
	    }
	    vatCode = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating data based on Vat Code
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeVatCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	BigDecimal vatCode = islamicCalculatorEventMgmtCO.getVatCode();
	if(vatCode == null)
	{
	    vatCode = BigDecimal.ZERO;
	}
	if(vatCode.intValue() > 0)
	{
		String vatIndicator =  "I";
	    if(NumberUtil.toInt(islamicCalculatorEventMgmtCO.getProductClass()) > 0)
	    {
		IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtResult = iisIslamicCalculatorBO
			.populateOnChangeProductClass(islamicCalculatorEventMgmtCO);
		TRSCLASS_EXTENDEDVO trsclassExte = new TRSCLASS_EXTENDEDVO();
		trsclassExte.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
		trsclassExte.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
		trsclassExte = (TRSCLASS_EXTENDEDVO) genericDAO.selectByPK(trsclassExte);
		vatIndicator = trsclassExte.getPERCENTAGE_IND();

		if((islamicCalculatorEventMgmtResult.getProfitUpfront().equals(ConstantsCommon.YES))
			|| (NumberUtil.toInt(islamicCalculatorEventMgmtResult.getCategory()) == 2
				|| NumberUtil.toInt(islamicCalculatorEventMgmtResult.getCategory()) == 19
				|| NumberUtil.toInt(islamicCalculatorEventMgmtResult.getCategory()) == 23
				|| NumberUtil.toInt(islamicCalculatorEventMgmtResult.getCategory()) == 25))
		{
		    BigDecimal vatCount = islamicCalculatorEventMgmtDAO.isVatExist(islamicCalculatorEventMgmtCO);// WITH
		    // TYPE
		    // "D"
		    if(vatCount == null)
		    {
			vatCount = BigDecimal.ZERO;
		    }
		    if(vatCount.intValue() > 0)
		    {
			throw new BOException(MessageCodes.VAT_PRFT_NOT_ALLOWED_ACCURAL_BORROWING);
		    }
		}
	    }

	    //String vatIndicator = islamicCalculatorEventMgmtDAO.getVatIndicator(islamicCalculatorEventMgmtCO);
	    if(vatIndicator == null)
	    {
		vatIndicator = "I";
	    }
	    if(vatIndicator.equals(IISCommonConstants.VAT_PERCENTAGE_INDICATOR_DEAL_PROFIT)
		    || vatIndicator.equals(IISCommonConstants.VAT_PERCENTAGE_INDICATOR_INSTALLMENT))
	    {
		islamicCalculatorEventMgmtCO.setIncludeVatinInstallment("N");

	    }
	    String vatDesc = islamicCalculatorEventMgmtDAO.getVatDesc(islamicCalculatorEventMgmtCO);
	    if(vatDesc == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
	    }
	    islamicCalculatorEventMgmtCO.setVatDesc(vatDesc);
	    BigDecimal vatPercantagePeriod = BigDecimal.ZERO;
	    
	  //-- Added by Manoj on 21/06/2019 for BMO180067 
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCO.setVatCode(islamicCalculatorEventMgmtCO.getVatCode());
	    iisCommonCO.setAccBr(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCO.setAccCy(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisCommonCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	    iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    	    //double vatPercentage = iisCommonBO.returnVatPercentage(iisCommonCO);
	    
	    iisCommonCO = iisCommonBO.returnCommonVatDetails(iisCommonCO);
	    if(iisCommonCO != null) {
	    	vatPercantagePeriod = iisCommonCO.getVatRate();
	     }
	    
//	    BigDecimal vatPercantagePeriod = islamicCalculatorEventMgmtDAO
//		    .getVatPercentagePeriod(islamicCalculatorEventMgmtCO);
//	    if(vatPercantagePeriod == null)
//	    {
//		vatPercantagePeriod = BigDecimal.ZERO;
//	    }
//	    if(vatPercantagePeriod.intValue() == 0)
//	    {
//		vatPercantagePeriod = islamicCalculatorEventMgmtDAO
//			.getVatPercentageLatest(islamicCalculatorEventMgmtCO);
//	    
//	  
//	    	    
//		// TP#245267; Libin; Date 28/12/2014
//		//if((vatPercantagePeriod == null || vatPercantagePeriod.intValue() == 0)
//		if((vatPercantagePeriod == null)
//			&& islamicCalculatorEventMgmtCO.getIncludeVatinInstallment() != null
//			&& islamicCalculatorEventMgmtCO.getIncludeVatinInstallment().equals(ConstantsCommon.NO))
//		{
//		    throw new BOException(MessageCodes.VAT_PERC_NOT_DEFINED_FOR_THE_VAT_CODE);
//		}
//		else
//		{
//		    // throw new BOException(
//		    // MessageCodes.VAT_PERCENTAGE_NOT_DEFINED_FOR_THE_VAT_CODE_FOR_THE_DEAL_WANT_TO_CONTINUE,
//		    // ConstantsCommon.CONFIRM_MSG_TYPE);
//		    islamicCalculatorEventMgmtCO.setConfirmationMessageId("902347");
//		}
//	    }
	    islamicCalculatorEventMgmtCO.setVatPercentage(vatPercantagePeriod);
	}
	else
	{
	    islamicCalculatorEventMgmtCO.setVatCode(null);
	    islamicCalculatorEventMgmtCO.setVatDesc(null);
	    islamicCalculatorEventMgmtCO.setIncludeVatinInstallment("N");
	    islamicCalculatorEventMgmtCO.setVatPercentage(BigDecimal.ZERO);
	}
	return islamicCalculatorEventMgmtCO;
    }

    public IslamicCalculatorEventMgmtDAO getIslamicCalculatorEventMgmtDAO()
    {
	return islamicCalculatorEventMgmtDAO;
    }

    public void setIslamicCalculatorEventMgmtDAO(IslamicCalculatorEventMgmtDAO islamicCalculatorEventMgmtDAO)
    {
	this.islamicCalculatorEventMgmtDAO = islamicCalculatorEventMgmtDAO;
    }

    @Override
    public String getLongOrShortDescription(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	return islamicCalculatorEventMgmtDAO.getLongOrShortDescription(islamicCalculatorEventMgmtCO);
    }

    @Override
    public String getCalculatorLanguage(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	return islamicCalculatorEventMgmtDAO.getCalculatorLanguage(islamicCalculatorEventMgmtCO);
    }

    public CommonLibDAO getCommonLibDao()
    {
	return commonLibDao;
    }

    public void setCommonLibDao(CommonLibDAO commonLibDao)
    {
	this.commonLibDao = commonLibDao;
    }

    // TODO Need to remove once we get the original method from service team
    // (Dummy checking)
    public List<TrspayplandetCO> populateSchedules()
    {
	List<TrspayplandetCO> islamicCalculatorScheduleList = new ArrayList<TrspayplandetCO>();
	for(int i = 0; i < 5; i++)
	{
	    TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
	    trspayplandetCO.setLINE_NBR(BigDecimal.valueOf(3));
	    trspayplandetCO.setAMOUNT(BigDecimal.valueOf(100));
	    trspayplandetCO.setVALUE_DATE(new Date());
	    trspayplandetCO.setBALLOON_PAYMENT(BigDecimal.valueOf(100));
	    trspayplandetCO.setPRINCIPLE_AMT(BigDecimal.valueOf(100));
	    trspayplandetCO.setCAPITAL_AMT(BigDecimal.valueOf(100));
	    trspayplandetCO.setCHARGE_AMOUNT(BigDecimal.valueOf(100));
	    trspayplandetCO.setINSURANCE_AMOUNT(BigDecimal.valueOf(100));
	    trspayplandetCO.setPROFIT_AMT(BigDecimal.valueOf(100));
	    trspayplandetCO.setVAT_AMOUNT(BigDecimal.valueOf(100));
	    trspayplandetCO.setTOTAL_EARNED_PROFIT(BigDecimal.valueOf(100));
	    trspayplandetCO.setXNPV(BigDecimal.valueOf(100));
	    trspayplandetCO.setNET_INVEST_OUTSTANDING(BigDecimal.valueOf(100));
	    trspayplandetCO.setTOTAL_DEFERRED_PROFIT(BigDecimal.valueOf(100));
	    trspayplandetCO.setTOTAL_PRINCIPAL_OUTSTANDIG(BigDecimal.valueOf(100));
	    trspayplandetCO.setNO_OF_DAYS(BigDecimal.valueOf(100));
	    trspayplandetCO.setROR(BigDecimal.valueOf(100));
	    islamicCalculatorScheduleList.add(trspayplandetCO);
	}
	return islamicCalculatorScheduleList;
    }

    /**
     * Method for populating equal balloon payment grid
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO getBalloonEqualPaymentsDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments() != null
		&& NumberUtil.toInt(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments()) > 0
		&& (!NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getBaloonAmount()))
		&& islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	{
	    int count = 1;
	    int noOfBalloonPayments = NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    double balloonAmt = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getBaloonAmount());
	    CURRENCIESVO currenciesVO = new CURRENCIESVO();
	    currenciesVO.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    currenciesVO.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getCurrencyCode() == null
		    ? islamicCalculatorEventMgmtCO.getBaseCurrencyCode()
		    : islamicCalculatorEventMgmtCO.getCurrencyCode());
	    CURRENCIESVO currencyVO = commonLibBO.returnCurrency(currenciesVO);
	    BigDecimal decimalPoints = BigDecimal.valueOf(2);
	    if(currencyVO != null && currencyVO.getDECIMAL_POINTS() != null)
	    {
		decimalPoints = currencyVO.getDECIMAL_POINTS();
	    }
	    double calBallonAmtForEachRow = NumberUtil.round((balloonAmt / noOfBalloonPayments),
		    NumberUtil.toInteger(decimalPoints));
	    List<TrsPlanBallonPaymentCO> listBallonPaymentCOs = new ArrayList<TrsPlanBallonPaymentCO>();
	    TrsPlanBallonPaymentCO ballonPaymentCO = new TrsPlanBallonPaymentCO();
	    ballonPaymentCO.setBalloonAmount(BigDecimal.valueOf(calBallonAmtForEachRow));
	    double tempSum = 0;
	    tempSum = tempSum + calBallonAmtForEachRow;
	    ballonPaymentCO.setBalloonDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    ballonPaymentCO.setBaloonAmtFormat(decimalPoints);
	    ballonPaymentCO.setCurrencyDecimal(decimalPoints);
	    ballonPaymentCO.setBalloonNo(BigDecimal.valueOf(count));
	    listBallonPaymentCOs.add(ballonPaymentCO);

	    for(int i = 0; i < noOfBalloonPayments - 1; i++)
	    {
		TrsPlanBallonPaymentCO equalballonPaymentCO = new TrsPlanBallonPaymentCO();
		equalballonPaymentCO.setBalloonAmount(BigDecimal.valueOf(calBallonAmtForEachRow));
		equalballonPaymentCO.setCurrencyDecimal(decimalPoints);
		tempSum = tempSum + calBallonAmtForEachRow;
		equalballonPaymentCO.setBaloonAmtFormat(decimalPoints);
		equalballonPaymentCO.setBalloonDate(null);
		equalballonPaymentCO.setBalloonNo(BigDecimal.valueOf(count + 1));
		listBallonPaymentCOs.add(equalballonPaymentCO);
		count = count + 1;
	    }
	    // if(tempSum != balloonAmt)
	    if((BigDecimal.valueOf(tempSum)).compareTo(BigDecimal.valueOf(balloonAmt)) != 0)
	    {
		TrsPlanBallonPaymentCO lastballonPaymentCO = listBallonPaymentCOs.get(noOfBalloonPayments - 1);
		lastballonPaymentCO.setBalloonAmount(BigDecimal.valueOf(NumberUtil.round(
			NumberUtil.toDouble(lastballonPaymentCO.getBalloonAmount()) + (balloonAmt - tempSum),
			NumberUtil.toInteger(decimalPoints))));
		lastballonPaymentCO.setBaloonAmtFormat(decimalPoints);
	    }
	    islamicCalculatorEventMgmtCO.setBalloonDetailsList(listBallonPaymentCOs);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /*
     * private void setTestValuesForBalloon(IslamicCalculatorEventMgmtCO
     * islamicCalculatorCO) {
     * 
     * BigDecimal companyCode = BigDecimal.valueOf(1); BigDecimal BranchCode =
     * new BigDecimal(1); BigDecimal productClassCode = BigDecimal.valueOf(1);
     * islamicCalculatorCO.setNoOfBaloonPayments(BigDecimal.valueOf(10));
     * islamicCalculatorCO.setBaloonAmount(BigDecimal.valueOf(10000));
     * 
     * Date valueDate = DateUtil.createDate(2010, 1, 1); Date valueDate1 =
     * DateUtil.createDate(2010, 3, 1); Date maturityDate =
     * DateUtil.createDate(2011, 1, 1);
     * 
     * islamicCalculatorCO.setCheckDefaultMaturityDate(true);
     * islamicCalculatorCO.setCompCode(companyCode);
     * islamicCalculatorCO.setBranchCode(BranchCode);
     * islamicCalculatorCO.setProductClass(productClassCode);
     * 
     * islamicCalculatorCO.setStartDate(valueDate);
     * islamicCalculatorCO.setMaturityDate(maturityDate);
     * 
     * List<TrsPlanBallonPaymentCO> listBallonPaymentCOs = new
     * ArrayList<TrsPlanBallonPaymentCO>();
     * 
     * TrsPlanBallonPaymentCO equalballonPaymentCO1 = new
     * TrsPlanBallonPaymentCO(); equalballonPaymentCO1.setBallonAmount(new
     * BigDecimal(100)); equalballonPaymentCO1.setBallonDate(valueDate);
     * equalballonPaymentCO1.setBalloonNo(BigDecimal.valueOf(1));
     * listBallonPaymentCOs.add(equalballonPaymentCO1);
     * 
     * TrsPlanBallonPaymentCO equalballonPaymentCO2 = new
     * TrsPlanBallonPaymentCO(); equalballonPaymentCO2.setBallonAmount(new
     * BigDecimal(10)); equalballonPaymentCO2.setBallonDate(valueDate);
     * equalballonPaymentCO2.setBalloonNo(BigDecimal.valueOf(2));
     * listBallonPaymentCOs.add(equalballonPaymentCO2);
     * 
     * /*TrsPlanBallonPaymentCO equalballonPaymentCO3 = new
     * TrsPlanBallonPaymentCO(); equalballonPaymentCO3.setBallonAmount(new
     * BigDecimal(20)); equalballonPaymentCO3.setBallonDate(valueDate);
     * equalballonPaymentCO3.setBalloonNo(BigDecimal.valueOf(3));
     * listBallonPaymentCOs.add(equalballonPaymentCO3);
     * 
     * TrsPlanBallonPaymentCO equalballonPaymentCO4 = new
     * TrsPlanBallonPaymentCO(); equalballonPaymentCO4.setBallonAmount(new
     * BigDecimal(50)); equalballonPaymentCO4.setBallonDate(valueDate);
     * equalballonPaymentCO4.setBalloonNo(BigDecimal.valueOf(4));
     * listBallonPaymentCOs.add(equalballonPaymentCO4);
     * islamicCalculatorCO.setBalloonDetailsList(listBallonPaymentCOs);
     * 
     * TrsPlanBallonPaymentCO ballonPaymentCO = new TrsPlanBallonPaymentCO();
     * ballonPaymentCO.setBallonAmount(BigDecimal.valueOf(10000));
     * ballonPaymentCO.setBallonDate(valueDate1);
     * ballonPaymentCO.setBalloonNo(BigDecimal.valueOf(1));
     * islamicCalculatorCO.setBallonPaymentCO(ballonPaymentCO);
     * 
     * 
     * }
     */

    /**
     * Method for validateDateForBalloonDetails
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return TrsPlanBallonPaymentCO
     * @throws BaseException
     */
    public List<TrsPlanBallonPaymentCO> validateDateForBalloonDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	TrsPlanBallonPaymentCO changedBalloonPaymentObject = islamicCalculatorEventMgmtCO.getBallonPaymentCO();
	if(changedBalloonPaymentObject.getBalloonDate() == null)
	{
	    throw new BOException(MessageCodes.INVALID_BALLOON_DETAILS);
	}
	if(changedBalloonPaymentObject.getBalloonDate().before(islamicCalculatorEventMgmtCO.getStartDate()))
	{
	    throw new BOException(MessageCodes.DATE_CANNOT_BE_BEFORE_VALUE_DATE);

	}
	if(changedBalloonPaymentObject.getBalloonDate().after(islamicCalculatorEventMgmtCO.getMaturityDate()))
	{
	    throw new BOException(MessageCodes.DATE_CANNOT_BE_AFTER_MATURITY_DATE);

	}
	int index = 0;
	List<TrsPlanBallonPaymentCO> ballonPaymentCOList = islamicCalculatorEventMgmtCO.getBalloonDetailsList();
	int gridRows = ballonPaymentCOList.size();
	for(TrsPlanBallonPaymentCO eachBalloonObject : ballonPaymentCOList)
	{
	    if(changedBalloonPaymentObject.getBalloonNo().intValue() == eachBalloonObject.getBalloonNo().intValue())
	    {
		if(gridRows > 1)
		{
		    if(index == 0)// checking first record
		    {
			checkNextRecord(changedBalloonPaymentObject, ballonPaymentCOList.get(index + 1));
		    }
		    else if(index == gridRows - 1)// Checking if last row
		    {
			checkPreviousRecord(ballonPaymentCOList.get(index - 1), changedBalloonPaymentObject);
		    }
		    else
		    {
			checkPreviousRecord(ballonPaymentCOList.get(index - 1), changedBalloonPaymentObject);
			checkNextRecord(changedBalloonPaymentObject, ballonPaymentCOList.get(index + 1));
		    }
		}
		eachBalloonObject.setBalloonDate(changedBalloonPaymentObject.getBalloonDate());
		// break;
	    }
	    eachBalloonObject.setBalloonAmount(NumberUtil.nullToZero(eachBalloonObject.getBalloonAmount()));
	    index++;
	}
	return ballonPaymentCOList;
    }

    private void checkPreviousRecord(TrsPlanBallonPaymentCO previousballoonObject,
	    TrsPlanBallonPaymentCO currentBalloonObject) throws BaseException
    {
	// if(previousballoonObject.getBalloonDate() != null &&
	// currentBalloonObject.getBalloonDate() != null
	// &&
	// previousballoonObject.getBalloonDate().after(currentBalloonObject.getBalloonDate()))
	// {
	// TP#239536;Arun.R.Variyath;11/11/2014 ADDED EQUAL CHECKING
	if(previousballoonObject.getBalloonDate() != null && currentBalloonObject.getBalloonDate() != null
		&& (previousballoonObject.getBalloonDate().after(currentBalloonObject.getBalloonDate())
			|| previousballoonObject.getBalloonDate()
				.compareTo(currentBalloonObject.getBalloonDate()) == 0))
	{

	    throw new BOException(MessageCodes.DTE_CANT_BE_LESS_THAN_EQUAL_TO_PREV_DTE);

	}
    }

    private void checkNextRecord(TrsPlanBallonPaymentCO currentBalloonObject, TrsPlanBallonPaymentCO nextBalloonObject)
	    throws BaseException
    {
	if(currentBalloonObject.getBalloonDate() != null && nextBalloonObject.getBalloonDate() != null
		&& nextBalloonObject.getBalloonDate().before(currentBalloonObject.getBalloonDate()))
	{

	    throw new BOException(MessageCodes.DATE_CANNOT_BE_AFTER_NEXT_DATE_SCHEDULE);

	}
    }

    /**
     * Method for validateAmtForBalloonDetails
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return TrsPlanBallonPaymentCO
     * @throws BaseException
     */
    public List<TrsPlanBallonPaymentCO> validateAmtForBalloonDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	TrsPlanBallonPaymentCO changedBalloonPaymentObject = islamicCalculatorEventMgmtCO.getBallonPaymentCO();
	if(doubleValue(changedBalloonPaymentObject.getBalloonAmount()) > doubleValue(
		islamicCalculatorEventMgmtCO.getBaloonAmount()))
	{
	    throw new BOException(MessageCodes.AMOUNT_EXCEEDS_TOTAL_BALLOON_AMT);
	}
	if(NumberUtil.isEmptyDecimal(changedBalloonPaymentObject.getBalloonAmount())
		|| doubleValue(changedBalloonPaymentObject.getBalloonAmount()) == 0)
	{
	    throw new BOException(MessageCodes.VALUE_GREATER_ZERO);
	}

	if(doubleValue(changedBalloonPaymentObject.getBalloonAmount()) < 0)
	{
	    throw new BOException(MessageCodes.AMOUNT_CANNOT_BE_NEGATIVE);
	}
	String flagforBallonAmt = islamicCalculatorEventMgmtDAO.getFlagValueForBallonAmt();
	if(flagforBallonAmt == null)
	{
	    flagforBallonAmt = "N";
	}
	if(!flagforBallonAmt.equals(ConstantsCommon.YES)
		&& doubleValue(changedBalloonPaymentObject.getBalloonAmount()) != java.lang.Math
			.round(doubleValue(changedBalloonPaymentObject.getBalloonAmount())))
	{

	    throw new BOException(MessageCodes.BALLON_AMT_IS_NOT_INTEGER_VAL);
	}
	TRSCLASSVO trsclassvo = islamicCalculatorEventMgmtDAO.getTRSClassParams(islamicCalculatorEventMgmtCO);
	if(trsclassvo != null && trsclassvo.getMIN_BALLOON_AMT_PERC_INST() != null
		&& trsclassvo.getMAX_BALLOON_AMT_PERC_INST() != null)
	{
	    double minBallonAmtPerLimit = doubleValue(trsclassvo.getMIN_BALLOON_AMT_PERC_INST());

	    if((NumberUtil.round(
		    doubleValue(changedBalloonPaymentObject.getBalloonAmount())
			    / doubleValue(islamicCalculatorEventMgmtCO.getBaloonAmount()) * 100,
		    2) < minBallonAmtPerLimit) && minBallonAmtPerLimit > 0
		    && doubleValue(changedBalloonPaymentObject.getBalloonAmount()) > 0)
	    {
		throw new BOException(MessageCodes.AMT_IS_LESS_THEN_MIN_LINE_PERCENTAGE,
			new String[] { String.valueOf(minBallonAmtPerLimit) }, true);
	    }

	    double maxBallonAmtPerLimit = doubleValue(trsclassvo.getMAX_BALLOON_AMT_PERC_INST());
	    if((NumberUtil.round(
		    doubleValue(changedBalloonPaymentObject.getBalloonAmount())
			    / doubleValue(islamicCalculatorEventMgmtCO.getBaloonAmount()) * 100,
		    2) > maxBallonAmtPerLimit) && maxBallonAmtPerLimit > 0
		    && doubleValue(changedBalloonPaymentObject.getBalloonAmount()) > 0)
	    {
		throw new BOException(MessageCodes.AMT_EXCEEDS_MAX_BALLOON_LINE_PERCENTAGE,
			new String[] { String.valueOf(maxBallonAmtPerLimit) }, true);
	    }
	}

	if(changedBalloonPaymentObject.getBalloonAmount() == null)
	{
	    changedBalloonPaymentObject.setBalloonAmount(BigDecimal.ZERO);
	}
	if(islamicCalculatorEventMgmtCO.getBaloonAmount() == null)
	{
	    islamicCalculatorEventMgmtCO.setBaloonAmount(BigDecimal.ZERO);
	}
	double sumOfAllocatedAmount = 0, oldBalloonAmt = 0, newBalloonAmt = 0;

	List<TrsPlanBallonPaymentCO> ballonPaymentCOList = islamicCalculatorEventMgmtCO.getBalloonDetailsList();
	for(TrsPlanBallonPaymentCO eachBalloonObject : ballonPaymentCOList)
	{
	    if(changedBalloonPaymentObject.getBalloonNo().intValue() == eachBalloonObject.getBalloonNo().intValue())
	    {
		oldBalloonAmt = doubleValue(eachBalloonObject.getBalloonAmount());
	    }

	    sumOfAllocatedAmount = sumOfAllocatedAmount + doubleValue(eachBalloonObject.getBalloonAmount());
	}

	if((doubleValue(islamicCalculatorEventMgmtCO.getBaloonAmount())) - sumOfAllocatedAmount + oldBalloonAmt
		- doubleValue(changedBalloonPaymentObject.getBalloonAmount()) < 0)
	{
	    throw new BOException(MessageCodes.AMOUNT_EXCEEDS_TOTAL_BALLOON_AMT);
	}

	if((doubleValue(islamicCalculatorEventMgmtCO.getBaloonAmount())) - sumOfAllocatedAmount + oldBalloonAmt
		- doubleValue(changedBalloonPaymentObject.getBalloonAmount()) > 0)
	{
	    newBalloonAmt = (doubleValue(islamicCalculatorEventMgmtCO.getBaloonAmount())) - sumOfAllocatedAmount
		    + oldBalloonAmt - doubleValue(changedBalloonPaymentObject.getBalloonAmount());
	}

	for(int i = 0; i < ballonPaymentCOList.size(); i++)
	{
	    TrsPlanBallonPaymentCO eachBalloonObject = ballonPaymentCOList.get(i);
	    if(changedBalloonPaymentObject.getBalloonNo().intValue() == eachBalloonObject.getBalloonNo().intValue())
	    {
		if(i == ballonPaymentCOList.size() - 1)
		{
		    break;
		}
		else
		{
		    ballonPaymentCOList.get(i + 1).setBalloonAmount(BigDecimal
			    .valueOf(doubleValue(ballonPaymentCOList.get(i + 1).getBalloonAmount()) + newBalloonAmt));
		    break;
		}
	    }
	}
	return ballonPaymentCOList;

    }

    public IISCommonBO getIisCommonBO()
    {
	return iisCommonBO;
    }

    public void setIisCommonBO(IISCommonBO iisCommonBO)
    {
	this.iisCommonBO = iisCommonBO;
    }

    public IISDealChargesBO getIisDealChargesBO()
    {
	return iisDealChargesBO;
    }

    public void setIisDealChargesBO(IISDealChargesBO iisDealChargesBO)
    {
	this.iisDealChargesBO = iisDealChargesBO;
    }

    /*
     * private void setTestValuesr(IslamicCalculatorEventMgmtCO
     * islamicCalculatorEventMgmtCO) { List<TRSPAYPLAN_CRITERIAVO>
     * criteriavosList = new ArrayList<TRSPAYPLAN_CRITERIAVO>();
     * TRSPAYPLAN_CRITERIAVO criteriavos1 = new TRSPAYPLAN_CRITERIAVO();
     * criteriavos1.setFROM_DATE(DateUtil.createDate(2012, 8, 10));
     * criteriavos1.setTO_DATE(DateUtil.createDate(2014, 01, 15));
     * criteriavos1.setPAYMENT_TYPE("B"); criteriavos1.setCAPITAL_AMT(new
     * BigDecimal(0)); criteriavos1.setPAYM_PERIODICITY("M");
     * criteriavos1.setPAYM_PERIOD_NBR(BigDecimal.valueOf(1));
     * criteriavos1.setPAYM_PERIOD_POS("S"); // // //
     * criteriavos1.setPAYM_DAY(BigDecimal.valueOf(12));
     * criteriavos1.setNO_OF_PAYMENTS(BigDecimal.valueOf(30));
     * criteriavos1.setCAPITAL_AMT(BigDecimal.valueOf(100));
     * islamicCalculatorEventMgmtCO.setSumOfCapitalAmtRepayment(new
     * BigDecimal(10000)); islamicCalculatorEventMgmtCO.setFinancingAmount(new
     * BigDecimal(100000));
     * islamicCalculatorEventMgmtCO.setCommencementDate(DateUtil
     * .createDate(2012, 8, 13));
     * islamicCalculatorEventMgmtCO.setGracePeriod(BigDecimal.valueOf(100));
     * islamicCalculatorEventMgmtCO.setGracePeriodicity("M"); //
     * criteriavosList.add(criteriavos1);
     * islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVOObject(criteriavos1);
     * criteriavosList.size(); }
     */

    /**
     * Method for populating the amount and no of payments while
     * OnChangeRepaymentCriteriaFromDate
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaFromDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject() != null)
	{
	    TRSPAYPLAN_CRITERIAVO payPlanCriteriaObject = islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject();
	    if(payPlanCriteriaObject.getFROM_DATE() != null
		    && payPlanCriteriaObject.getFROM_DATE().before(islamicCalculatorEventMgmtCO.getStartDate()))
	    {

		throw new BOException(MessageCodes.FROM_DATE_CANNOT_BE_LESS_THAN_VALUE_DATE);

	    }
	    if(payPlanCriteriaObject.getFROM_DATE() != null
		    && payPlanCriteriaObject.getFROM_DATE().after(payPlanCriteriaObject.getTO_DATE()))
	    {
		throw new BOException(MessageCodes.TO_DATE_CANNOT_BE_LESS_THAN_FROM_DATE);
	    }

	    if(payPlanCriteriaObject.getTO_DATE() != null && payPlanCriteriaObject.getPAYM_PERIODICITY() != null
		    && payPlanCriteriaObject.getPAYM_PERIOD_POS() != null
		    && payPlanCriteriaObject.getPAYM_PERIOD_NBR() != null
		    && payPlanCriteriaObject.getFROM_DATE() != null
		    && islamicCalculatorEventMgmtCO.getCommencementDate() != null
		    && islamicCalculatorEventMgmtCO.getGracePeriodicity() != null
		    && islamicCalculatorEventMgmtCO.getGracePeriod() != null
		    && payPlanCriteriaObject.getPAYMENT_TYPE() != null && payPlanCriteriaObject.getCAPITAL_AMT() != null
		    && islamicCalculatorEventMgmtCO.getFinancingAmount() != null
		    && islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() != null
		    && doubleValue(islamicCalculatorEventMgmtCO.getFinancingAmount()) > 0
		    && doubleValue(payPlanCriteriaObject.getPAYM_PERIOD_NBR()) > 0)
	    {
		IISCommonCO commonCO = new IISCommonCO();
		commonCO.setMaturityDate(payPlanCriteriaObject.getTO_DATE());
		commonCO.setPaymPeriodicity(payPlanCriteriaObject.getPAYM_PERIODICITY());
		commonCO.setPaymPeriodPos(payPlanCriteriaObject.getPAYM_PERIOD_POS());
		commonCO.setPaymPeriodNbr(payPlanCriteriaObject.getPAYM_PERIOD_NBR());
		commonCO.setFirstPayDate(payPlanCriteriaObject.getFROM_DATE());
		commonCO.setCommencementDate(islamicCalculatorEventMgmtCO.getCommencementDate());
		commonCO.setGracePeriodicity(islamicCalculatorEventMgmtCO.getGracePeriodicity());
		commonCO.setGracePeriod(islamicCalculatorEventMgmtCO.getGracePeriod());

		commonCO = iisCommonBO.returnNumberofPayments(commonCO);
		payPlanCriteriaObject.setNO_OF_PAYMENTS(commonCO.getNoOfPayments());

		if((payPlanCriteriaObject.getPAYMENT_TYPE().equals(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL)
			|| payPlanCriteriaObject.getPAYMENT_TYPE()
				.equals(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT)
			|| payPlanCriteriaObject.getPAYMENT_TYPE()
				.equals(IISCommonConstants.PAYMENT_TYPE_PRINCIPAL_UPFRONT_PROFIT))
			&& NumberUtil.nullToZero(payPlanCriteriaObject.getNO_OF_PAYMENTS()).intValue() > 0)
		{
		    double capitalDealAmount;

		    double dealAmount = doubleValue(islamicCalculatorEventMgmtCO.getFinancingAmount());
		    double capitalAmount = doubleValue(payPlanCriteriaObject.getCAPITAL_AMT());
		    double sumOfCapitalAmount = doubleValue(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment());
		    double allotedCapitalAmt = sumOfCapitalAmount - capitalAmount;
		    if(sumOfCapitalAmount == 0D)
		    {
			capitalDealAmount = NumberUtil.round(
				dealAmount
					/ NumberUtil.nullToZero(payPlanCriteriaObject.getNO_OF_PAYMENTS().intValue()),
				3);
		    }
		    else
		    {
			capitalDealAmount = NumberUtil.round(
				(NumberUtil.toDouble(dealAmount) - allotedCapitalAmt)
					/ NumberUtil.nullToZero(payPlanCriteriaObject.getNO_OF_PAYMENTS().intValue()),
				3);
			if(capitalDealAmount < 0)
			{
			    capitalDealAmount = 0;
			}
		    }
		    payPlanCriteriaObject.setCAPITAL_AMT(BigDecimal.valueOf((capitalDealAmount)));
		}
		islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVOObject(payPlanCriteriaObject);
		commonCO = null;
	    }
	}// close if

	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject() != null
		&& islamicCalculatorEventMgmtCO.getRepaymentCriteriaFirstRowDate() != null)
	{
	    islamicCalculatorEventMgmtCO
		    .setFirstPaymentDate(islamicCalculatorEventMgmtCO.getRepaymentCriteriaFirstRowDate());
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO1 = validateOnChangeFirstPayDate(
		    islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO.setGracePeriod(islamicCalculatorEventMgmtCO1.getGracePeriod());
	    islamicCalculatorEventMgmtCO.setGracePeriodicity(islamicCalculatorEventMgmtCO1.getGracePeriodicity());

	    islamicCalculatorEventMgmtCO1.setNoOfPayments(islamicCalculatorEventMgmtCO.getNoOfPayments());
	    islamicCalculatorEventMgmtCO1.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    islamicCalculatorEventMgmtCO1.setPaymPeriodNbr(islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    islamicCalculatorEventMgmtCO1.setPaymPeriodPos(islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    islamicCalculatorEventMgmtCO1.setFirstPaymentDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    islamicCalculatorEventMgmtCO1.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    islamicCalculatorEventMgmtCO1.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    islamicCalculatorEventMgmtCO1.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    islamicCalculatorEventMgmtCO1.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    islamicCalculatorEventMgmtCO1.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    islamicCalculatorEventMgmtCO1.setDealAmount(islamicCalculatorEventMgmtCO.getDealAmount());
	    islamicCalculatorEventMgmtCO1.setDownPaymentAmount(islamicCalculatorEventMgmtCO.getDownPaymentAmount());

	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO2 = populateOnChangeFirstPayDate(
		    islamicCalculatorEventMgmtCO1);
	    islamicCalculatorEventMgmtCO.setMaturityDate(islamicCalculatorEventMgmtCO2.getMaturityDate());
	    islamicCalculatorEventMgmtCO
		    .setMaturityDateAfterHoliday(islamicCalculatorEventMgmtCO2.getMaturityDateAfterHoliday());
	    islamicCalculatorEventMgmtCO
		    .setConfirmationMessageId(islamicCalculatorEventMgmtCO2.getConfirmationMessageId());

	    islamicCalculatorEventMgmtCO2.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    islamicCalculatorEventMgmtCO2.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    islamicCalculatorEventMgmtCO2.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    islamicCalculatorEventMgmtCO2.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	    islamicCalculatorEventMgmtCO2.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    islamicCalculatorEventMgmtCO2.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	    islamicCalculatorEventMgmtCO2.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    islamicCalculatorEventMgmtCO2.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	    islamicCalculatorEventMgmtCO2.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO2.setTrsDealChargesVO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    islamicCalculatorEventMgmtCO2.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO2.setCallType("O");
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO3 = calculateDealCharges(
		    islamicCalculatorEventMgmtCO2);
	    islamicCalculatorEventMgmtCO.setTrsDealChargesVO(islamicCalculatorEventMgmtCO3.getTrsDealChargesVO());
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating the amount and no of payments while
     * OnChangeRepaymentCriteriaToDate
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaToDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject() != null)
	{
	    TRSPAYPLAN_CRITERIAVO payPlanCriteriaObject = islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject();
	    if(payPlanCriteriaObject.getFROM_DATE() != null && payPlanCriteriaObject.getTO_DATE() != null
		    && payPlanCriteriaObject.getTO_DATE().before(payPlanCriteriaObject.getFROM_DATE()))
	    {
		throw new BOException(MessageCodes.TO_DATE_CANNOT_BE_LESS_THAN_FROM_DATE);
	    }

	    if(payPlanCriteriaObject.getTO_DATE() != null && islamicCalculatorEventMgmtCO.getMaturityDate() != null
		    && payPlanCriteriaObject.getTO_DATE().after(islamicCalculatorEventMgmtCO.getMaturityDate()))
	    {
		islamicCalculatorEventMgmtCO.setMaturityDate(payPlanCriteriaObject.getTO_DATE());
	    }
	    if(payPlanCriteriaObject.getTO_DATE() != null && payPlanCriteriaObject.getPAYM_PERIODICITY() != null
		    && payPlanCriteriaObject.getPAYM_PERIOD_POS() != null
		    && payPlanCriteriaObject.getPAYM_PERIOD_NBR() != null
		    && payPlanCriteriaObject.getFROM_DATE() != null
		    && islamicCalculatorEventMgmtCO.getCommencementDate() != null
		    && islamicCalculatorEventMgmtCO.getGracePeriodicity() != null
		    && islamicCalculatorEventMgmtCO.getGracePeriod() != null
		    && payPlanCriteriaObject.getPAYMENT_TYPE() != null && payPlanCriteriaObject.getCAPITAL_AMT() != null
		    && islamicCalculatorEventMgmtCO.getFinancingAmount() != null
		    && islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() != null
		    && doubleValue(islamicCalculatorEventMgmtCO.getFinancingAmount()) > 0
		    && doubleValue(payPlanCriteriaObject.getPAYM_PERIOD_NBR()) > 0)
	    {
		IISCommonCO commonCO = new IISCommonCO();
		commonCO.setMaturityDate(payPlanCriteriaObject.getTO_DATE());
		commonCO.setPaymPeriodicity(payPlanCriteriaObject.getPAYM_PERIODICITY());
		commonCO.setPaymPeriodPos(payPlanCriteriaObject.getPAYM_PERIOD_POS());
		commonCO.setPaymPeriodNbr(payPlanCriteriaObject.getPAYM_PERIOD_NBR());
		commonCO.setFirstPayDate(payPlanCriteriaObject.getFROM_DATE());
		commonCO.setCommencementDate(islamicCalculatorEventMgmtCO.getCommencementDate());
		commonCO.setGracePeriodicity(islamicCalculatorEventMgmtCO.getGracePeriodicity());
		commonCO.setGracePeriod(islamicCalculatorEventMgmtCO.getGracePeriod());

		commonCO = iisCommonBO.returnNumberofPayments(commonCO);
		payPlanCriteriaObject.setNO_OF_PAYMENTS(commonCO.getNoOfPayments());
		// TP#231459;Arun.R.Variyath;15/10/2014 -intValue
		if((payPlanCriteriaObject.getPAYMENT_TYPE().equals(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL)
			|| payPlanCriteriaObject.getPAYMENT_TYPE()
				.equals(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT)
			|| payPlanCriteriaObject.getPAYMENT_TYPE()
				.equals(IISCommonConstants.PAYMENT_TYPE_PRINCIPAL_UPFRONT_PROFIT))
			&& NumberUtil.nullToZero(payPlanCriteriaObject.getNO_OF_PAYMENTS()).intValue() > 0)
		{
		    double capitalDealAmount;

		    double dealAmount = doubleValue(islamicCalculatorEventMgmtCO.getFinancingAmount());
		    double capitalAmount = doubleValue(payPlanCriteriaObject.getCAPITAL_AMT());
		    double sumOfCapitalAmount = doubleValue(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment());
		    double allotedCapitalAmt = sumOfCapitalAmount - capitalAmount;

		    if(sumOfCapitalAmount == 0D)
		    {
			capitalDealAmount = NumberUtil.round(
				dealAmount
					/ NumberUtil.nullToZero(payPlanCriteriaObject.getNO_OF_PAYMENTS()).intValue(),
				3);
		    }
		    else
		    {
			capitalDealAmount = NumberUtil.round(
				(dealAmount - allotedCapitalAmt)
					/ NumberUtil.nullToZero(payPlanCriteriaObject.getNO_OF_PAYMENTS()).intValue(),
				3);
			if(capitalDealAmount < 0)
			{
			    capitalDealAmount = 0;
			}
		    }
		    payPlanCriteriaObject.setCAPITAL_AMT(BigDecimal.valueOf((capitalDealAmount)));
		}
		islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVOObject(payPlanCriteriaObject);
		commonCO = null;
	    }
	    payPlanCriteriaObject = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating the amount and no of payments while OnChange
     * PeriodicityNumber
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaPeriodicityNumber(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject() != null)
	{
	    TRSPAYPLAN_CRITERIAVO payPlanCriteriaObject = islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject();
	    if(NumberUtil.toInt(payPlanCriteriaObject.getPAYM_PERIOD_NBR()) < 0)
	    {
		throw new BOException(MessageCodes.PAY_PERIOD_SHOULD_BE_GREATER_THAN_ZERO);
	    }
	}
	populateOnChangeRepaymentCriteriaFromDate(islamicCalculatorEventMgmtCO);
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating the amount and no of payments and from date and to
     * date while OnChange PeriodicityPeriod
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaPeriodicityPeriod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject() != null)
	{
	    TRSPAYPLAN_CRITERIAVO payPlanCriteriaObject = islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject();
	    TRSPAYPLAN_CRITERIAVO criteriaObject = getFromDateForRepaymentCriteria(payPlanCriteriaObject,
		    islamicCalculatorEventMgmtCO);
	    if(payPlanCriteriaObject.getTO_DATE() != null && payPlanCriteriaObject.getPAYM_PERIODICITY() != null
		    && payPlanCriteriaObject.getPAYM_PERIOD_POS() != null
		    && payPlanCriteriaObject.getPAYM_PERIOD_NBR() != null
		    && payPlanCriteriaObject.getFROM_DATE() != null
		    && islamicCalculatorEventMgmtCO.getCommencementDate() != null
		    && islamicCalculatorEventMgmtCO.getGracePeriodicity() != null
		    && islamicCalculatorEventMgmtCO.getGracePeriod() != null
		    && payPlanCriteriaObject.getPAYMENT_TYPE() != null && payPlanCriteriaObject.getCAPITAL_AMT() != null
		    && islamicCalculatorEventMgmtCO.getFinancingAmount() != null
		    && islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() != null
		    && doubleValue(islamicCalculatorEventMgmtCO.getFinancingAmount()) > 0
		    && doubleValue(payPlanCriteriaObject.getPAYM_PERIOD_NBR()) > 0)
	    {
		IISCommonCO commonCO = new IISCommonCO();
		commonCO.setMaturityDate(criteriaObject.getTO_DATE());
		commonCO.setPaymPeriodicity(payPlanCriteriaObject.getPAYM_PERIODICITY());
		commonCO.setPaymPeriodPos(payPlanCriteriaObject.getPAYM_PERIOD_POS());
		commonCO.setPaymPeriodNbr(payPlanCriteriaObject.getPAYM_PERIOD_NBR());
		commonCO.setFirstPayDate(criteriaObject.getFROM_DATE());
		commonCO.setCommencementDate(islamicCalculatorEventMgmtCO.getCommencementDate());
		commonCO.setGracePeriodicity(islamicCalculatorEventMgmtCO.getGracePeriodicity());
		commonCO.setGracePeriod(islamicCalculatorEventMgmtCO.getGracePeriod());

		payPlanCriteriaObject.setFROM_DATE(criteriaObject.getFROM_DATE());
		payPlanCriteriaObject.setTO_DATE(criteriaObject.getTO_DATE());

		commonCO = iisCommonBO.returnNumberofPayments(commonCO);
		payPlanCriteriaObject.setNO_OF_PAYMENTS(commonCO.getNoOfPayments());

		if((payPlanCriteriaObject.getPAYMENT_TYPE().equals(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL)
			|| payPlanCriteriaObject.getPAYMENT_TYPE()
				.equals(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT)
			|| payPlanCriteriaObject.getPAYMENT_TYPE()
				.equals(IISCommonConstants.PAYMENT_TYPE_PRINCIPAL_UPFRONT_PROFIT))
			&& payPlanCriteriaObject.getNO_OF_PAYMENTS().compareTo(BigDecimal.ZERO) == 1)
		{
		    double capitalDealAmount;
		    BigDecimal dealAmount = islamicCalculatorEventMgmtCO.getFinancingAmount();
		    double capitalAmount = doubleValue(payPlanCriteriaObject.getCAPITAL_AMT());
		    double sumOfCapitalAmount = doubleValue(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment());
		    double allotedCapitalAmt = sumOfCapitalAmount - capitalAmount;

		    if(sumOfCapitalAmount == 0D)
		    {
			capitalDealAmount = dealAmount
				.divide(payPlanCriteriaObject.getNO_OF_PAYMENTS(), 3, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
		    }
		    else
		    {
			capitalDealAmount = (dealAmount.subtract(BigDecimal.valueOf(allotedCapitalAmt)))
				.divide(payPlanCriteriaObject.getNO_OF_PAYMENTS(), 3, BigDecimal.ROUND_HALF_UP)
				.doubleValue();

			if(capitalDealAmount < 0)
			{
			    capitalDealAmount = 0;
			}
		    }

		    payPlanCriteriaObject.setCAPITAL_AMT(BigDecimal.valueOf((capitalDealAmount)));
		}
		islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVOObject(payPlanCriteriaObject);
		commonCO = null;
	    }
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating the amount and no of payments and from date and to
     * date while OnChange PeriodicityPosition
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaPeriodicityPosition(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject() != null)
	{
	    TRSPAYPLAN_CRITERIAVO payPlanCriteriaObject = islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject();
	    if(payPlanCriteriaObject.getPAYM_PERIOD_POS() != null
		    && payPlanCriteriaObject.getPAYM_PERIOD_POS().equals(IISCommonConstants.SET_DATE)
		    && (payPlanCriteriaObject.getPAYM_DAY() == null
			    || NumberUtil.toInt(payPlanCriteriaObject.getPAYM_DAY()) < 0))
	    {
		throw new BOException(MessageCodes.PAY_TYPE_CANT_REPEATED_FOR_SAME_INST_NUM);
	    }
	}

	return populateOnChangeRepaymentCriteriaPeriodicityPeriod(islamicCalculatorEventMgmtCO);
    }

    /**
     * Method for populating CriteriaAmount and from date and to date while
     * OnChange PeriodicityPosition
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject() != null)
	{
	    TRSPAYPLAN_CRITERIAVO payPlanCriteriaObject = islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject();

	    double capitalAmount = doubleValue(payPlanCriteriaObject.getCAPITAL_AMT());

	    if(capitalAmount < 0)
	    {
		throw new BOException(MessageCodes.AMOUNT_CANNOT_BE_GREATER_THAN_ZERO);
	    }
	    double dealAmount = doubleValue(islamicCalculatorEventMgmtCO.getFinancingAmount());
	    if(capitalAmount > dealAmount)
	    {
		throw new BOException(MessageCodes.AMT_CANNOT_BE_GRT_THAN_PRINCIPAL_AMT);
	    }
	    if(("C".equals(payPlanCriteriaObject.getPAYMENT_TYPE())
		    || "B".equals(payPlanCriteriaObject.getPAYMENT_TYPE())
		    || "O".equals(payPlanCriteriaObject.getPAYMENT_TYPE()))
		    && capitalAmount * NumberUtil.toInt(payPlanCriteriaObject.getNO_OF_PAYMENTS()) > dealAmount)
	    {
		throw new BOException(MessageCodes.TOTAL_AMT_CANNOT_BE_GRT_THAN_PRINCIPAL_AMT);

	    }
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating the amount and to date while OnChange
     * RepaymentCriteriaNoOfPayments
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaNoOfPayments(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject() != null)
	{
	    TRSPAYPLAN_CRITERIAVO payPlanCriteriaObject = islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject();
	    Date fromDate = payPlanCriteriaObject.getFROM_DATE();
	    flagForNoOfPayments = true;// Setting the flag to get the todate.
	    Date toDate = getToDateForRepayPlanCriteria(fromDate, payPlanCriteriaObject);
	    payPlanCriteriaObject.setTO_DATE(toDate);

	    if(NumberUtil.nullToZero(payPlanCriteriaObject.getNO_OF_PAYMENTS()).intValue() < 0)
	    {
		throw new BOException(MessageCodes.NO_OF_PAYMENTS_GREATER_ZERO);
	    }

	    if(((payPlanCriteriaObject.getNO_OF_PAYMENTS() != null
		    && NumberUtil.toInt(payPlanCriteriaObject.getNO_OF_PAYMENTS()) > 0)
		    && (payPlanCriteriaObject.getPAYMENT_TYPE().equals("C")
			    || payPlanCriteriaObject.getPAYMENT_TYPE().equals("B")
			    || payPlanCriteriaObject.getPAYMENT_TYPE().equals("O")))
		    && NumberUtil.toInt(payPlanCriteriaObject.getNO_OF_PAYMENTS()) > 0)
	    {
		double capitalDealAmount;
		double dealAmount = doubleValue(islamicCalculatorEventMgmtCO.getFinancingAmount());
		double capitalAmount = doubleValue(payPlanCriteriaObject.getCAPITAL_AMT());
		double sumOfCapitalAmount = doubleValue(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment());
		double allotedCapitalAmt = sumOfCapitalAmount - capitalAmount;

		if(sumOfCapitalAmount == 0D)
		{
		    capitalDealAmount = NumberUtil
			    .round(dealAmount / NumberUtil.toInt(payPlanCriteriaObject.getNO_OF_PAYMENTS()), 3);
		}
		else
		{
		    capitalDealAmount = NumberUtil.round((dealAmount - NumberUtil.toDouble(allotedCapitalAmt))
			    / NumberUtil.toInt(payPlanCriteriaObject.getNO_OF_PAYMENTS()), 3);
		    if(capitalDealAmount < 0)
		    {
			capitalDealAmount = 0;
		    }
		}
		payPlanCriteriaObject.setCAPITAL_AMT(BigDecimal.valueOf((capitalDealAmount)));
	    }
	    islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVOObject(payPlanCriteriaObject);
	}
	return islamicCalculatorEventMgmtCO;
    }

    private TRSPAYPLAN_CRITERIAVO getFromDateForRepaymentCriteria(TRSPAYPLAN_CRITERIAVO criteriaVO,
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(criteriaVO.getFROM_DATE() != null && criteriaVO.getPAYM_PERIODICITY() != null
		&& criteriaVO.getPAYM_PERIOD_POS() != null && islamicCalculatorEventMgmtCO.getStartDate() != null)
	{
	    Date fromDate = criteriaVO.getFROM_DATE();
	    if(criteriaVO.getPAYM_PERIODICITY().equals("M"))
	    {
		int day, month, year;
		if(criteriaVO.getPAYM_PERIOD_POS().equals("S") || criteriaVO.getPAYM_PERIOD_POS().equals("M"))
		{
		    if(criteriaVO.getPAYM_PERIOD_POS().equals("S") && !DateUtil.getDatePart("DD", fromDate).equals(1L))
		    {

			fromDate = getNextDateSetNewDay(fromDate, 1L);

		    }
		    else if(criteriaVO.getPAYM_PERIOD_POS().equals("M")
			    && !DateUtil.getDatePart("DD", fromDate).equals(15L))
		    {

			fromDate = getNextDateSetNewDay(fromDate, 15L);

		    }
		    if(fromDate.before(islamicCalculatorEventMgmtCO.getStartDate()))
		    {
			day = DateUtil.getDatePart("DD", fromDate).intValue();
			month = DateUtil.getDatePart("MM", fromDate).intValue();
			year = DateUtil.getDatePart("YY", fromDate).intValue();
			if(month == 11)
			{
			    month = 0;
			    year++;
			}
			if(criteriaVO.getPAYM_PERIOD_POS().equals("S"))
			{
			    day = 1;
			}
			if(criteriaVO.getPAYM_PERIOD_POS().equals("M"))
			{
			    day = 15;
			}
			fromDate = createDate(year, month, day);
		    }
		}
		else if(criteriaVO.getPAYM_PERIOD_POS().equals("E"))
		{
		    // Last day Of the Month
		    fromDate = DateUtil.getMonthLastDay(fromDate);
		}
		else if(criteriaVO.getPAYM_PERIOD_POS().equals("D"))
		{
		    day = DateUtil.getDatePart("DD", fromDate).intValue();
		    month = DateUtil.getDatePart("MM", fromDate).intValue();
		    year = DateUtil.getDatePart("YY", fromDate).intValue();
		    switch (month)
		    {
			// case 1: case 3:case 5: case 7: case 8: case 10:case
			// 12:
			case 0:
			case 2:
			case 4:
			case 6:
			case 7:
			case 9:
			case 11:
			    if(day == 31)
			    {
				day = 31;
			    }
			    break;

			// case 4:case 6:case 9:case 11:
			case 3:
			case 5:
			case 8:
			case 10:
			    if(day == 31)
			    {
				month++;
				day = 1;
			    }
			    break;

			// case 2:
			case 1:
			    if((year % 4) == 0)// checking Leap year
			    {
				if(day == 31)
				{
				    month++;
				    day = 2;
				}
				else if(day == 30)
				{
				    month++;
				    day = 1;
				}
			    }
			    else
			    {
				if(day == 31)
				{
				    month++;
				    day = 3;
				}
				else if(day == 30)
				{
				    month++;
				    day = 2;
				}
				else if(day == 29)
				{
				    month++;
				    day = 1;
				}
			    }
			    break;
			default:
			    break;
		    }
		    fromDate = createDate(year, month, day);
		}
	    }
	    else if(criteriaVO.getPAYM_PERIODICITY().equals("Q") || criteriaVO.getPAYM_PERIODICITY().equals("S")
		    || criteriaVO.getPAYM_PERIODICITY().equals("A"))
	    {
		fromDate = DateUtil.relativeDate(fromDate, -1);// Adding -1 to
		// get the
		// correct date
		// as per Bijoy.
		fromDate = iisCommonBO.returnNextDate(fromDate, criteriaVO.getPAYM_PERIODICITY(), false);
	    }
	    criteriaVO.setFROM_DATE(fromDate);
	    criteriaVO.setTO_DATE(getToDateForRepayPlanCriteria(fromDate, criteriaVO));
	}
	return criteriaVO;
    }

    private Date getToDateForRepayPlanCriteria(Date fromDate, TRSPAYPLAN_CRITERIAVO criteriaVO) throws BaseException
    {
	Date toDate = new Date();
	if(criteriaVO.getTO_DATE() != null)
	{
	    toDate = criteriaVO.getTO_DATE();
	    if(fromDate.after(criteriaVO.getTO_DATE()) || flagForNoOfPayments)
	    {
		IISCommonCO iisCommonCO = new IISCommonCO();
		iisCommonCO.setNoOfPayments(criteriaVO.getNO_OF_PAYMENTS());
		iisCommonCO.setPaymPeriodNbr(criteriaVO.getPAYM_PERIOD_NBR());
		iisCommonCO.setPaymPeriodicity(criteriaVO.getPAYM_PERIODICITY());
		iisCommonCO.setFirstPayDate(criteriaVO.getFROM_DATE());
		iisCommonCO.setValue("COMMENCE");
		iisCommonCO = iisCommonBO.returnMaturitydate(iisCommonCO);
		toDate = iisCommonCO.getMaturityDate();
		iisCommonCO = null;
	    }
	}
	return toDate;
    }

    private Date getNextDateSetNewDay(Date date, Long day) throws BaseException
    {
	Calendar calendar = new GregorianCalendar();
	calendar.setTime(date);
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH);

	calendar.set(year, month, day.intValue());
	if(calendar.get(Calendar.MONTH) != month)
	{
	    int day1 = calendar.get(Calendar.DAY_OF_MONTH);
	    calendar.add(Calendar.DAY_OF_MONTH, -day1);
	}
	return calendar.getTime();
    }

    /*
     * private void setTestValuesForRepay(IslamicCalculatorEventMgmtCO
     * islamicCalculatorEventMgmtCO) { List<TRSPAYPLAN_CRITERIAVO>
     * criteriavosList = new ArrayList<TRSPAYPLAN_CRITERIAVO>();
     * TRSPAYPLAN_CRITERIAVO criteriavos1 = new TRSPAYPLAN_CRITERIAVO();
     * criteriavos1.setFROM_DATE(DateUtil.createDate(2012, 8, 10));
     * criteriavos1.setTO_DATE(DateUtil.createDate(2014, 01, 15));
     * criteriavos1.setPAYMENT_TYPE("B"); criteriavos1.setCAPITAL_AMT(new
     * BigDecimal(0)); criteriavos1.setPAYM_PERIODICITY("M");
     * criteriavos1.setPAYM_PERIOD_NBR(BigDecimal.valueOf(1));
     * criteriavos1.setPAYM_PERIOD_POS("S"); // // //
     * criteriavos1.setPAYM_DAY(BigDecimal.valueOf(12));
     * criteriavos1.setNO_OF_PAYMENTS(BigDecimal.valueOf(30));
     * criteriavos1.setCAPITAL_AMT(BigDecimal.valueOf(100));
     * 
     * TRSPAYPLAN_CRITERIAVO criteriavos2 = new TRSPAYPLAN_CRITERIAVO();
     * criteriavos2.setFROM_DATE(DateUtil.createDate(2000, 8, 20));
     * criteriavos2.setTO_DATE(DateUtil.createDate(2010, 01, 5));
     * criteriavos2.setPAYMENT_TYPE("B"); criteriavos2.setCAPITAL_AMT(new
     * BigDecimal(100)); criteriavos2.setPAYM_PERIODICITY("M");
     * criteriavos2.setPAYM_PERIOD_NBR(BigDecimal.valueOf(1));
     * criteriavos2.setPAYM_PERIOD_POS("S"); // // //
     * criteriavos2.setPAYM_DAY(BigDecimal.valueOf(12));
     * criteriavos2.setNO_OF_PAYMENTS(BigDecimal.valueOf(30));
     * 
     * TRSPAYPLAN_CRITERIAVO criteriavos3 = new TRSPAYPLAN_CRITERIAVO();
     * criteriavos3.setFROM_DATE(DateUtil.createDate(2012, 8, 11));
     * criteriavos3.setTO_DATE(DateUtil.createDate(2014, 01, 15));
     * criteriavos3.setPAYMENT_TYPE("B"); criteriavos3.setPAYM_PERIODICITY("M");
     * criteriavos3.setPAYM_PERIOD_NBR(BigDecimal.valueOf(1));
     * criteriavos3.setPAYM_PERIOD_POS("S"); // // //
     * criteriavos3.setPAYM_DAY(BigDecimal.valueOf(12));
     * criteriavos3.setNO_OF_PAYMENTS(BigDecimal.valueOf(30));
     * criteriavos3.setCAPITAL_AMT(BigDecimal.valueOf(1000));
     * 
     * islamicCalculatorEventMgmtCO.setSumOfCapitalAmtRepayment(new
     * BigDecimal(10000)); islamicCalculatorEventMgmtCO.setFinancingAmount(new
     * BigDecimal(100000));
     * islamicCalculatorEventMgmtCO.setCommencementDate(DateUtil
     * .createDate(2012, 8, 13));
     * islamicCalculatorEventMgmtCO.setGracePeriod(BigDecimal.valueOf(100));
     * islamicCalculatorEventMgmtCO.setGracePeriodicity("M");
     * criteriavosList.add(criteriavos1); criteriavosList.add(criteriavos2);
     * criteriavosList.add(criteriavos3);
     * islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVOObject(criteriavos1);
     * islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVO(criteriavosList);
     * criteriavosList.size(); }
     */

    /**
     * Method for populating the amount while OnChange
     * populateOnChangeRepaymentCriteriaPaymentType
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    private IslamicCalculatorEventMgmtCO calculateRepayCriteriaAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO() != null)
	{
	    TRSPAYPLAN_CRITERIAVO payPlanCriteriaObject = islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject();
	    if(payPlanCriteriaObject.getPAYMENT_TYPE() != null
		    && islamicCalculatorEventMgmtCO.getFinancingAmount() != null
		    && payPlanCriteriaObject.getCAPITAL_AMT() != null
		    && islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() != null)
	    {
		if((payPlanCriteriaObject.getPAYMENT_TYPE().equals("C")
			|| payPlanCriteriaObject.getPAYMENT_TYPE().equals("B")
			|| payPlanCriteriaObject.getPAYMENT_TYPE().equals("O"))
			&& NumberUtil.toInt(payPlanCriteriaObject.getNO_OF_PAYMENTS()) > 0)
		{
		    double capitalDealAmount;
		    double financingAmt = doubleValue(islamicCalculatorEventMgmtCO.getFinancingAmount());
		    double capitalAmount = doubleValue(payPlanCriteriaObject.getCAPITAL_AMT());
		    double sumOfCapitalAmount = doubleValue(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment());
		    double allotedCapitalAmt = sumOfCapitalAmount - capitalAmount;

		    if(sumOfCapitalAmount == 0D)
		    {
			capitalDealAmount = NumberUtil
				.round(financingAmt / NumberUtil.toInt(payPlanCriteriaObject.getNO_OF_PAYMENTS()), 3);
		    }
		    else
		    {
			capitalDealAmount = NumberUtil.round((financingAmt - NumberUtil.toDouble(allotedCapitalAmt))
				/ NumberUtil.toInt(payPlanCriteriaObject.getNO_OF_PAYMENTS()), 3);
		    }
		    payPlanCriteriaObject.setCAPITAL_AMT(BigDecimal.valueOf((capitalDealAmount)));
		}
		else
		{
		    payPlanCriteriaObject.setCAPITAL_AMT(BigDecimal.ZERO);
		}
		islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVOObject(payPlanCriteriaObject);
	    }
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for validating the duplicate rows in the grid and populating the
     * amount based on the new payment type while OnChange
     * populateOnChangeRepaymentCriteriaPaymentType
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaPaymentType(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO() != null)
	{
	    List<TRSPAYPLAN_CRITERIAVO> payPlanCriteriaList = islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO();
	    if(payPlanCriteriaList.size() == 1)
	    {
		return calculateRepayCriteriaAmount(islamicCalculatorEventMgmtCO);
	    }

	    for(TRSPAYPLAN_CRITERIAVO eachPayPlanCriteriaObject : payPlanCriteriaList)
	    {
		TRSPAYPLAN_CRITERIAVO payPlanCriteriaChangedObject = islamicCalculatorEventMgmtCO
			.getTrsPayplanCriteriaVOObject();
		int cnt = 0;
		if(checkRecordExists(eachPayPlanCriteriaObject, payPlanCriteriaChangedObject))
		{
		    cnt++;
		}
		if(cnt > 1)
		{
		    throw new BOException(MessageCodes.PAY_TYPE_CANT_REPEATED_FOR_SAME_INST_NUM);
		}
	    }
	    calculateRepayCriteriaAmount(islamicCalculatorEventMgmtCO);
	    payPlanCriteriaList = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    private boolean checkRecordExists(TRSPAYPLAN_CRITERIAVO payPlanCriteriaObject,
	    TRSPAYPLAN_CRITERIAVO chkPayPlanCriteriaObject)
    {
	if((payPlanCriteriaObject != null && chkPayPlanCriteriaObject != null
		&& payPlanCriteriaObject.getPAYMENT_TYPE() != null && chkPayPlanCriteriaObject.getPAYMENT_TYPE() != null
		&& payPlanCriteriaObject.getPAYMENT_TYPE().compareTo(chkPayPlanCriteriaObject.getPAYMENT_TYPE()) == 0)
		&& payPlanCriteriaObject.getPAYM_PERIODICITY() != null
		&& chkPayPlanCriteriaObject.getPAYM_PERIODICITY() != null
		&& (payPlanCriteriaObject.getPAYM_PERIODICITY()
			.compareTo(chkPayPlanCriteriaObject.getPAYM_PERIODICITY()) == 0)
		&& payPlanCriteriaObject.getTO_DATE() != null && chkPayPlanCriteriaObject.getTO_DATE() != null
		&& (payPlanCriteriaObject.getTO_DATE().compareTo(chkPayPlanCriteriaObject.getTO_DATE()) == 0)
		&& payPlanCriteriaObject.getFROM_DATE() != null && chkPayPlanCriteriaObject.getFROM_DATE() != null
		&& (payPlanCriteriaObject.getFROM_DATE().compareTo(chkPayPlanCriteriaObject.getFROM_DATE()) == 0)
		&& payPlanCriteriaObject.getPAYM_PERIOD_NBR() != null
		&& chkPayPlanCriteriaObject.getPAYM_PERIOD_NBR() != null
		&& (payPlanCriteriaObject.getPAYM_PERIOD_NBR()
			.compareTo(chkPayPlanCriteriaObject.getPAYM_PERIOD_NBR()) == 0)
		&& payPlanCriteriaObject.getPAYM_PERIOD_POS() != null
		&& chkPayPlanCriteriaObject.getPAYM_PERIOD_POS() != null
		&& (payPlanCriteriaObject.getPAYM_PERIOD_POS()
			.compareTo(chkPayPlanCriteriaObject.getPAYM_PERIOD_POS()) == 0)
		&& payPlanCriteriaObject.getPAYM_DAY() != null && chkPayPlanCriteriaObject.getPAYM_DAY() != null
		&& (payPlanCriteriaObject.getPAYM_DAY().compareTo(chkPayPlanCriteriaObject.getPAYM_DAY()) == 0)
		&& payPlanCriteriaObject.getNO_OF_PAYMENTS() != null
		&& chkPayPlanCriteriaObject.getNO_OF_PAYMENTS() != null && (payPlanCriteriaObject.getNO_OF_PAYMENTS()
			.compareTo(chkPayPlanCriteriaObject.getNO_OF_PAYMENTS())) == 0)
	{
	    return true;
	}
	return false;
    }

    @Override
    public IslamicCalculatorEventMgmtCO setMaturityBasedonHoliday(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getCompCode() != null && islamicCalculatorEventMgmtCO.getBranchCode() != null
		&& islamicCalculatorEventMgmtCO.getProductClass() != null
		&& islamicCalculatorEventMgmtCO.getCifNo() != null
		&& islamicCalculatorEventMgmtCO.getMaturityDate() != null
		&& islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getCurrencyCode() != null
		&& islamicCalculatorEventMgmtCO.getBaseCurrencyCode() != null
		&& islamicCalculatorEventMgmtCO.getFinancingAmount() != null)
	{
	    if(islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday() != null)
	    {
		islamicCalculatorEventMgmtCO
			.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	    }

	    IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	    iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisDealChargesCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	    iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	    iisDealChargesCO.setCallType("P");
	    iisDealChargesCO.setIisTrsdealchargesCO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	    populateOnChangeCurrencyCode(islamicCalculatorEventMgmtCO);
	    iisDealChargesCO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO populateOnChangeChargecode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	iisDealChargesCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	iisDealChargesCO.setCallType("CC");// charge Code
	iisDealChargesCO.setIisTrsdealchargesCO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	iisDealChargesCO = null;
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO populateOnChangeChargeCurrencyCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	iisDealChargesCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	iisDealChargesCO.setCallType("CR");// charge currency
	iisDealChargesCO.setIisTrsdealchargesCO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	iisDealChargesCO = null;
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO populateOnChangeChargeAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	iisDealChargesCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	iisDealChargesCO.setCallType("CA");// charge Amount
	iisDealChargesCO.setIisTrsdealchargesCO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO populateSetProductClassDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisCommonCO.setNoOfPayments(islamicCalculatorEventMgmtCO.getNoOfPayments());

	if(islamicCalculatorEventMgmtCO.getProfitCalcMethod() == null)
	{
	    islamicCalculatorEventMgmtCO.setProfitCalcMethod("S");
	}
	if(islamicCalculatorEventMgmtCO.getProfitDistMethod() == null
		|| Character.isWhitespace(islamicCalculatorEventMgmtCO.getProfitDistMethod().charAt(0)))
	{
	    islamicCalculatorEventMgmtCO.setProfitDistMethod(islamicCalculatorEventMgmtCO.getProfitCalcMethod());
	}
	Date holidayDate = islamicCalculatorEventMgmtCO.getRunningDate();
	if(islamicCalculatorEventMgmtCO.getStartDate() != holidayDate)
	{
	    islamicCalculatorEventMgmtCO.setStartDate(holidayDate);
	}
	// need to set the value date here in commencement

	// calling the grace_periodicity item changed event for setting the
	// maturity date
	islamicCalculatorEventMgmtCO.setMaturityDate(DateUtil.createDate(2111, 12, 31));
	islamicCalculatorEventMgmtCO = iisIslamicCalculatorBO
		.populateOnChangeFirstPaymentAfterPeriodicity(islamicCalculatorEventMgmtCO);

	IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	iisDealChargesCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	iisDealChargesCO.setCallType("P");
	islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	if(islamicCalculatorEventMgmtCO.getTempCode().intValue() > 0)
	{
	    islamicCalculatorEventMgmtCO = populateOnChangeTemplateCode(islamicCalculatorEventMgmtCO);
	}
	iisDealChargesCO = null;
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO calculateDealCharges(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	BigDecimal cifNo = islamicCalculatorEventMgmtCO.getCifNo();
	// since we cannot pass a null value to IBATIS we are assigning 0 to
	// cifNo if it is null
	if(cifNo == null)
	{
	    cifNo = BigDecimal.ZERO;// Modified by bejoy on 27 Aug
	}
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	iisDealChargesCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisDealChargesCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisDealChargesCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	iisDealChargesCO.setCifNo(cifNo);
	iisDealChargesCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	iisDealChargesCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	iisDealChargesCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	iisDealChargesCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	iisDealChargesCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	iisDealChargesCO.setIisTrsdealchargesCO(islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	if(islamicCalculatorEventMgmtCO.getCallType() == null)
	{
	    iisDealChargesCO.setCallType("P");
	}
	else
	{
	    iisDealChargesCO.setCallType(islamicCalculatorEventMgmtCO.getCallType());
	}
	// To set the Charges list from the screen
	islamicCalculatorEventMgmtCO.setTrsDealChargesVO(iisDealChargesBO.calculateDealCharges(iisDealChargesCO));
	iisDealChargesCO = null;
	return islamicCalculatorEventMgmtCO;
    }

    /*
     * private void setTestValues(IslamicCalculatorEventMgmtCO
     * islamicCalculatorCO) {
     * 
     * BigDecimal companyCode = BigDecimal.valueOf(1); BigDecimal BranchCode =
     * new BigDecimal(1); BigDecimal productClassCode = BigDecimal.valueOf(1);
     * BigDecimal dealCurrency = BigDecimal.valueOf(40); BigDecimal dealAmount =
     * new BigDecimal(500000); Date valueDate = DateUtil.createDate(2010, 1, 1);
     * Date maturityDate = DateUtil.createDate(2011, 1, 1); BigDecimal
     * annualYeild = BigDecimal.valueOf(12); BigDecimal maxYeild = new
     * BigDecimal(0); BigDecimal minYeild = BigDecimal.valueOf(0);
     * islamicCalculatorCO.setCheckDefaultMaturityDate(true);
     * islamicCalculatorCO.setCompCode(companyCode);
     * islamicCalculatorCO.setBranchCode(BranchCode);
     * islamicCalculatorCO.setProductClass(productClassCode);
     * islamicCalculatorCO.setCurrencyCode(dealCurrency);
     * islamicCalculatorCO.setDealAmount(dealAmount);
     * islamicCalculatorCO.setStartDate(valueDate);
     * islamicCalculatorCO.setMaturityDate(maturityDate);
     * islamicCalculatorCO.setYield(annualYeild);
     * islamicCalculatorCO.setYieldAmendRangeTo(maxYeild);
     * islamicCalculatorCO.setMaturityDateAfterHoliday(maturityDate);
     * islamicCalculatorCO.setFirstPaymentDate(valueDate);
     * islamicCalculatorCO.setYieldAmendRangeFrom(minYeild);
     * islamicCalculatorCO.setVatIcludedInInstallement("true");
     * islamicCalculatorCO.setVatCode(BigDecimal.valueOf(1));
     * islamicCalculatorCO.setCifNo(BigDecimal.valueOf(1));
     * islamicCalculatorCO.setRunningDate(new Date());
     * islamicCalculatorCO.setBaseCurrencyCode(dealCurrency);
     * islamicCalculatorCO.setFinancingAmount(BigDecimal.valueOf("10000"));
     * islamicCalculatorCO.setTotalFlatRate(BigDecimal.valueOf(100));
     * islamicCalculatorCO.setProfitCalcMethod("S");
     * islamicCalculatorCO.setNoOfPayments( BigDecimal.valueOf(50));
     * islamicCalculatorCO.setDealPeriodCompounding("N");
     * islamicCalculatorCO.setGracePeriod( BigDecimal.valueOf(0));
     * islamicCalculatorCO.setNoOfBaloonPayments(BigDecimal.valueOf("10"));
     * islamicCalculatorCO.setBaloonAmount(BigDecimal.valueOf("10")); String
     * paymentPeriodicity = "M"; Long paymentPeriodicityNo = 1L; String
     * paymentPeriodicityMonthPos = "S";
     * islamicCalculatorCO.setPaymPeriodicity(paymentPeriodicity);
     * islamicCalculatorCO.setPaymPeriodNbr(new
     * BigDecimal(paymentPeriodicityNo));
     * islamicCalculatorCO.setPaymPeriodPos(paymentPeriodicityMonthPos);
     * BigDecimal profitOnCharges = BigDecimal.valueOf(0); BigDecimal
     * profitOnInsurance = BigDecimal.valueOf(0); BigDecimal totalCharges = new
     * BigDecimal(0); BigDecimal totalInsurance = BigDecimal.valueOf(0); String
     * profitCalculationMethod = "R"; String profitRecognitionMethod = "R"; Long
     * profitAccrualBasis = 2L; String compudingDealPeriod = "N"; String
     * compoudingGracePeriod = "N"; String compoundingProfitPeriodicity = "M";
     * Long compoundingProfitPeriodicityNo = 1L;
     * 
     * BigDecimal templateCode = BigDecimal.valueOf(0); Date firstPaymentDate =
     * DateUtil.createDate(2010, 2, 1);
     * 
     * 
     * 
     * BigDecimal noOfPayments = BigDecimal.valueOf(350);
     * 
     * String residualValue = "L"; BigDecimal amountPerPayment = new
     * BigDecimal(0); Long roundingFactor = 0L; String principalInLastPayment =
     * "N"; String tentativeSchedule = "N"; String calendarType = "H";
     * 
     * 
     * 
     * 
     * }
     */

    /**
     * Moved to iiscommonBO for LOS - Method for validating the
     * CifSalaryMultiple the methods to calculate the payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    // public IslamicCalculatorEventMgmtCO validateForCifSalaryMultiple(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws
    // BaseException
    // {
    //
    // }

    /**
     * Moved to iiscommonBO for LOS - Method for validating the fields before
     * calling the methods to calculate the payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    //
    // public IslamicCalculatorEventMgmtCO validateFieldsForDealCharges(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws
    // BaseException
    // {

    // }

    /**
     * Moved to iiscommonBO for LOS - Method for further validations after the
     * user clicks yes to calculate the payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    // public IslamicCalculatorEventMgmtCO
    // validateMaxFinancingAmountForDealCharges(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws
    // BaseException
    // {
    //
    // }

    /**
     * Method for validation RepayamentCriteriaList
     * 
     * schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    /**
     * Moved to iiscommonBO for LOS - Method for validating financing amount
     * should not exceed limit max financing amount the methods to calculate the
     * payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // private IslamicCalculatorEventMgmtCO validateFinancingLimitMaxMinAmount(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO, TRSCLASSVO
    // trsClassVOParam) throws BaseException
    // {
    // }

    /**
     * Moved to iiscommonBO for LOS - Method for further validations where user
     * clicks second alert and clicks on yes to calculate the payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // public IslamicCalculatorEventMgmtCO validateNoOfPaymentsForDealCharges(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws
    // BaseException
    // {
    // }

    /**
     * Moved to iiscommonBO for LOS - Method for validating the vat code for
     * null check or less than zero based on flag VatIcludedInInstallement
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // private IslamicCalculatorEventMgmtCO
    // validateVatCode(IslamicCalculatorEventMgmtCO
    // islamicCalculatorEventMgmtCO)
    // throws BaseException
    // {
    //
    // }

    /**
     * Moved to iiscommonBO for LOS - Method for validating Cif salary if the
     * cif salary is less than deal amount.
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // private IslamicCalculatorEventMgmtCO
    // validateCifSalary(IslamicCalculatorEventMgmtCO
    // islamicCalculatorEventMgmtCO,
    // TRSCLASSVO trsClassVO) throws BaseException
    // {
    //
    // }

    /**
     * Moved to iiscommonBO for LOS - Method for validating the yield rate and
     * throw exception if flat rate is less than zero
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // private IslamicCalculatorEventMgmtCO
    // validateYieldRate(IslamicCalculatorEventMgmtCO
    // islamicCalculatorEventMgmtCO)
    // throws BaseException
    // {
    //
    // }

    /**
     * Moved to iiscommonBO for LOS - Method for validating the deal mount
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // private IslamicCalculatorEventMgmtCO
    // validateDealAmount(IslamicCalculatorEventMgmtCO
    // islamicCalculatorEventMgmtCO)
    // throws BaseException
    // {
    //
    // }

    /**
     * Moved to iiscommonBO for LOS - Method for validating financing amount
     * should not exceed maximum financing amount the methods to calculate the
     * payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // private IslamicCalculatorEventMgmtCO validateMaxFinancingAmount(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO, TRSCLASSVO
    // trsClassVOParam) throws BaseException
    // {
    //
    // }

    /**
     * Moved to iisCommonBO for LOS - Method for validating if financing amount
     * is less than minimum financing amt
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // private IslamicCalculatorEventMgmtCO validateMinFinanacingAmount(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO, TRSCLASSVO
    // trsClassVO) throws BaseException
    // {
    //
    // }

    /**
     * Method for validating the no of payments the methods to calculate the
     * payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    /*
     * private IslamicCalculatorEventMgmtCO validateNoOfPayments(
     * IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO, TRSCLASSVO
     * trsClassVO) throws BaseException { }
     */
    /** Moved to iisCommonBO for LOS - */
    // private IslamicCalculatorEventMgmtCO
    // validateNoOfPayments(IslamicCalculatorEventMgmtCO
    // islamicCalculatorEventMgmtCO,
    // TRSCLASSVO trsClassVOParam) throws BaseException
    // {
    //
    // }

    /**
     * Moved to iiscommonBO for LOS - Method for validating the deal period if
     * deal period is exceeding the max period
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // private IslamicCalculatorEventMgmtCO
    // validateDealPeriod(IslamicCalculatorEventMgmtCO
    // islamicCalculatorEventMgmtCO,
    // TRSCLASSVO trsClassVO) throws BaseException
    // {
    //
    // }

    /**
     * Moved to iiscommonBO for LOS - Method for validating the balloon payments
     * to check the no of balloon payments and balloon amount greater then 0
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // private IslamicCalculatorEventMgmtCO validateBalloonAmount(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws
    // BaseException
    // {
    // }

    /**
     * Moved to iiscommonBO for LOS - Method for validating the yield check the
     * yield greater than 0 and flag for yield should be true.
     * 
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    // private IslamicCalculatorEventMgmtCO
    // validateYield(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
    // throws BaseException
    // {
    //
    // if(doubleValue(islamicCalculatorEventMgmtCO.getYield()) == 0
    // &&
    // islamicCalculatorEventMgmtCO.getYieldRequired().equals(ConstantsCommon.YES))
    // {
    // throw new
    // BOException(MessageCodes.CANNOT_PROC_ANNUAL_RATE_NOT_SPECIFIED);
    // }
    //
    // return islamicCalculatorEventMgmtCO;
    // }

    private static final double doubleValue(Object o)
    {
	return NumberUtil.toDouble(o);

    }

    /***
     * Method for calculating the annual yield rate ,margin and floating rates
     * on each of its change events
     */
    @Override
    public IslamicCalculatorEventMgmtCO calculateAnnualFloatingMarginRates(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;

	if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	{
	    return islamicCalculatorEventMgmtCO;
	}

	double annualYieldRate = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getAnnualYieldRate());
	double margin = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getMargin());
	double floatingRate = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getFloatingRate());
	if(islamicCalculatorEventMgmtCO.getYieldFlag() == null
		|| islamicCalculatorEventMgmtCO.getYieldFlag().equals("A"))
	{// Annual Yield OnChange
	    double newMargin = annualYieldRate - floatingRate;
	    if(newMargin < 0)
	    {
		throw new BOException(MessageCodes.YEILD_CANNOT_BE_LESS_THAN,
			new String[] { String.valueOf(floatingRate) });
	    }
	    islamicCalculatorEventMgmtCO.setMargin(BigDecimal.valueOf(newMargin));
	}
	else if(islamicCalculatorEventMgmtCO.getYieldFlag().equals("FM"))
	{// Floating OnChange /Margin OnChange
	    islamicCalculatorEventMgmtCO.setAnnualYieldRate(BigDecimal.valueOf(floatingRate + margin));

	}
	// Added by Linchu for Annual Yield
	islamicCalculatorEventMgmtCO.setYield(islamicCalculatorEventMgmtCO.getAnnualYieldRate());
	islamicCalculatorEventMgmtCO = iisCommonBO.calculateTotalAnnualYield(islamicCalculatorEventMgmtCO);
	return islamicCalculatorEventMgmtCO;
    }

    public IslamicCalculatorEventMgmtCO dependencyByCurrencyCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getCurrencyCode());
	CURRENCIESVO currrency = (CURRENCIESVO) genericDAO.selectByPK(currenciesVOKey);
	if(currrency == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_DEAL_CURRENCY);
	}
	islamicCalculatorEventMgmtCO.setCurrencyDesc(currrency.getBRIEF_DESC_ENG());
	islamicCalculatorEventMgmtCO.setCurrencyDecimalPoints(currrency.getDECIMAL_POINTS());
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO dependencyByTradingCurrencyCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	BigDecimal ltradingcurr;
	CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getTradingCurrency());
	CURRENCIESVO currrency = (CURRENCIESVO) genericDAO.selectByPK(currenciesVOKey);
	if(currrency == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_DEAL_CURRENCY);
	}

	islamicCalculatorEventMgmtCO.setTradingCurrencyDesc(currrency.getBRIEF_DESC_ENG());
	islamicCalculatorEventMgmtCO.setCurrencyDecimalPoints(currrency.getDECIMAL_POINTS());

	islamicCalculatorEventMgmtCO = crossRateBillsCalculator(islamicCalculatorEventMgmtCO);

	islamicCalculatorEventMgmtCO.setCrossRate(islamicCalculatorEventMgmtCO.getCrossRate());
	islamicCalculatorEventMgmtCO.setBillAmount(BigDecimal.ZERO);
	islamicCalculatorEventMgmtCO.setAmountPerPayment(BigDecimal.ZERO);
	islamicCalculatorEventMgmtCO.setTotalBillAmount(BigDecimal.ZERO);
	islamicCalculatorEventMgmtCO.setTradingBillAmount(BigDecimal.ZERO);

	ltradingcurr = islamicCalculatorEventMgmtCO.getTradingCurrency();
	islamicCalculatorEventMgmtCO.getTradingBillAmount();
	if(ltradingcurr.compareTo(BigDecimal.ZERO) > 0)
	{
	    String currencyMask = NumberUtil.currencyMask(currrency.getDECIMAL_POINTS());
	    commonLibBO.applyDynScreenDisplay(Total_Trading_Bill_Amount, null, ConstantsCommon.ACTION_TYPE_DECFORMAT,
		    currencyMask, islamicCalculatorEventMgmtCO.getHmSysParam(), null);

	    commonLibBO.applyDynScreenDisplay(TOTAL_BILL_AMOUNT, null, ConstantsCommon.ACTION_TYPE_DECFORMAT,
		    currencyMask, islamicCalculatorEventMgmtCO.getHmSysParam(), null);
	}

	return islamicCalculatorEventMgmtCO;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getAdditionalScreenParams()
    {
	return additionalScreenParams;
    }

    public void setAdditionalScreenParams(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> additionalScreenParams)
    {

	this.additionalScreenParams = additionalScreenParams;
    }

    private Date createDate(int year, int month, int day)
    {
	Calendar cal = Calendar.getInstance();
	// cal.setTime(date);
	cal.set(Calendar.YEAR, year);
	cal.set(Calendar.MONTH, month - 1);
	cal.set(Calendar.DAY_OF_MONTH, day);

	cal.set(Calendar.HOUR, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	cal.set(Calendar.AM_PM, 0);

	return cal.getTime();
    }

    public boolean isFlagForNoOfPayments()
    {
	return flagForNoOfPayments;
    }

    public void setFlagForNoOfPayments(boolean flagForNoOfPayments)
    {
	this.flagForNoOfPayments = flagForNoOfPayments;
    }

    private int checkDealRange(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	if(islamicCalculatorEventMgmtCO.getLimitSerialNo() == null)
	{
	    return 1;
	}
	TRSCIFLIMITDETVO trsciflimitdetvo = new TRSCIFLIMITDETVO();
	if(islamicCalculatorEventMgmtCO.getLimitSerialNo().compareTo(BigDecimal.ZERO) > 0)
	{
	    trsciflimitdetvo.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsciflimitdetvo.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getBranchCode());
	    trsciflimitdetvo.setCIF(islamicCalculatorEventMgmtCO.getCifNo());
	    trsciflimitdetvo.setSERIAL_NO(islamicCalculatorEventMgmtCO.getLimitSerialNo());
	    trsciflimitdetvo = islamicCalculatorEventMgmtDAO.returnTRSCIFLIMITDETDetails(trsciflimitdetvo);

	}
	else
	{
	    trsciflimitdetvo.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsciflimitdetvo.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getBranchCode());
	    trsciflimitdetvo.setCIF(islamicCalculatorEventMgmtCO.getCifNo());
	    trsciflimitdetvo.setCLASS(islamicCalculatorEventMgmtCO.getProductClass());
	    trsciflimitdetvo = islamicCalculatorEventMgmtDAO.returnTRSCIFLIMITDETDetails1(trsciflimitdetvo);
	}

	if(trsciflimitdetvo != null)
	{
	    // BigDecimal amountFrom =
	    // NumberUtil.nullToZero(trsciflimitdetvo.getMIN_DEAL_AMT());
	    // BigDecimal amountTo = trsciflimitdetvo.getMAX_DEAL_AMT();
	    // if(amountTo == null)
	    // {
	    // amountTo = BigDecimal.valueOf(999999999999999.999);
	    // }
	    String warningNotRequired = trsciflimitdetvo.getDEAL_AMT_ALLOW_TO_PROCEED_YN();
	    if(warningNotRequired == null)
	    {
		warningNotRequired = ConstantsCommon.YES;
	    }

	    if(warningNotRequired.equals(ConstantsCommon.YES))
	    {
		return 1;
	    }
	    BigDecimal dealAmount = BigDecimal.ZERO;
	    if(trsciflimitdetvo.getCY().compareTo(islamicCalculatorEventMgmtCO.getCurrencyCode()) == 0)
	    {
		dealAmount = NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getPurchaseAmount());
	    }
	    else
	    {
		CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
		currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
		currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getCurrencyCode());
		CURRENCIESVO currenciesvo = iisCommonBO.returnCurrencyDetails(currenciesVOKey);
		BigDecimal decimalPoint = currenciesvo.getDECIMAL_POINTS();

		IISCommonCO iisCommonCO = new IISCommonCO();
		iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
		iisCommonCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
		iisCommonCO.setTrCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
		iisCommonCO.setPfCurrency(trsciflimitdetvo.getCY());
		iisCommonCO.setCrossDate(islamicCalculatorEventMgmtCO.getRunningDate());
		iisCommonCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
		BigDecimal crossRate = BigDecimal.ZERO;
		iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
		if(iisCommonCO.getCrossRate().compareTo(BigDecimal.ZERO) > 0)
		{

		    dealAmount = NumberUtil.roundToBigDecimal(dealAmount.multiply(crossRate), decimalPoint.intValue());
		}
	    }

	    // if(StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom()).isEmpty())

	    if(!StringUtil.isNotEmpty(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom())
		    || ("DEAL_AMOUNT_LESS_THAN_AMOUNT_RANGE_DEFINED_AT_LIMIT")
			    .equals(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom()))
	    {

		if(trsciflimitdetvo.getMIN_DEAL_AMT() != null
			&& dealAmount.compareTo(trsciflimitdetvo.getMIN_DEAL_AMT()) < 0)

		{
		    throw new BOException(MessageCodes.iis_invalid_code,
			    new String[] { "Deal_amount_is_less_than_amount_range_defined_at_Limit_key" },
			    ConstantsCommon.CONFIRM_MSG_TYPE, "DEAL_AMOUNT_LESS_THAN_AMOUNT_RANGE_DEFINED_AT_LIMIT",
			    true);

		}
	    }

	    if(!StringUtil.isNotEmpty(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom())
		    || ("DEAL_AMOUNT_GREATER_THAN_AMOUNT_RANGE_DEFINED_AT_LIMIT")
			    .equals(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom()))
	    {
		if(trsciflimitdetvo.getMAX_DEAL_AMT() != null
			&& dealAmount.compareTo(NumberUtil.nullEmptyToValue(trsciflimitdetvo.getMAX_DEAL_AMT(),
				BigDecimal.valueOf(999999999999999.999))) > 0)
		{
		    throw new BOException(MessageCodes.iis_invalid_code,
			    new String[] { "Deal_amount_is_greater_than_amount_range_defined_at_Limit_key" },
			    ConstantsCommon.CONFIRM_MSG_TYPE, "DEAL_AMOUNT_GREATER_THAN_AMOUNT_RANGE_DEFINED_AT_LIMIT",
			    true);

		}
	    }
	}
	return 1;

    }

    public MemoBO getMemoBO()
    {
	return memoBO;
    }

    public void setMemoBO(MemoBO memoBO)
    {
	this.memoBO = memoBO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO onChangeActualGracePeriod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	Date firstPaymentDate = null;
	if((islamicCalculatorEventMgmtCO.getGracePeriodActual() == null)
		|| (islamicCalculatorEventMgmtCO.getGracePeriodActual().compareTo(BigDecimal.ZERO) < 0))
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Actual_Grace_Period_cannot_be_less_than_0" }, false);
	}
	else if(islamicCalculatorEventMgmtCO.getGracePeriodActual().compareTo(BigDecimal.ZERO) >= 0)
	{
	    Date actualGracePeriodDate = iisIslamicCalculatorBO.getNextValueDate(
		    islamicCalculatorEventMgmtCO.getStartDate(), islamicCalculatorEventMgmtCO.getStartDate(),
		    StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getPaymPeriodPos()),
		    islamicCalculatorEventMgmtCO.getGracePeriodActual().longValue(), 0L,
		    StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getGracePeriodicityActual()), null, "P");

	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCO.setNoOfPayments(islamicCalculatorEventMgmtCO.getNoOfPayments());
	    iisCommonCO.setPaymPeriodNbr(islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    iisCommonCO.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    iisCommonCO.setPaymPeriodPos(islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    iisCommonCO.setFirstPayDate(actualGracePeriodDate);
	    iisCommonCO.setGracePeriod(islamicCalculatorEventMgmtCO.getGracePeriodActual());
	    iisCommonCO.setGracePeriodicity(islamicCalculatorEventMgmtCO.getGracePeriodicityActual());
	    iisCommonCO.setCommencementDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisCommonCO.setRunningDate(islamicCalculatorEventMgmtCO.getRunningDate());
	    iisCommonCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisCommonCO.setOrginalYield(islamicCalculatorEventMgmtCO.getOrginalYield());
	    iisCommonCO.setValue("COMMENCE");
	    iisCommonCO.setLineNo(BigDecimal.ONE);
	    iisCommonCO = iisCommonBO.returnFirstdate(iisCommonCO);
	    firstPaymentDate = iisCommonCO.getFirstPayDate();
	}
	TRSCLASSVO trsclassvo = new TRSCLASSVO();
	trsclassvo.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	trsclassvo.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	trsclassvo = commonLibBO.returnTrsClassVO(trsclassvo);
	if(trsclassvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	if(trsclassvo.getPLAN_CALC_FRSTPAYDT_PAYEVRY_YN().equals(ConstantsCommon.YES))
	{
	    firstPaymentDate = returnFirstPaymentDate(islamicCalculatorEventMgmtCO, null,
		    islamicCalculatorEventMgmtCO.getValueDate());
	}
	islamicCalculatorEventMgmtCO.setFirstPaymentDate(firstPaymentDate);
	if(trsclassvo.getPLAN_CALC_FRSTPAYDT_PAYEVRY_YN().equals(ConstantsCommon.YES))
	{
	    populateOnChangeGracePeriodOption(islamicCalculatorEventMgmtCO);
	}
	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setNoOfPayments(islamicCalculatorEventMgmtCO.getNoOfPayments());
	iisCommonCO.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	iisCommonCO.setPaymPeriodNbr(islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	iisCommonCO.setPaymPeriodPos(islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	iisCommonCO.setValue("COMMENCE");
	iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	iisCommonCO.setFirstPayDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	// #TAR BB130030 ;Arun R Variyath ; 11/08/2015 [Start]
	String calcMatDte = StringUtil.nullEmptyToValue(iisCommonBO.returnCalcMatDteFlagValue(iisCommonCO), "N");
	if("Y".equals(calcMatDte))
	{
	    iisCommonCO.setPaymPeriodPos("D");
	}
	// #TAR BB130030 ;Arun R Variyath ; 11/08/2015 [End]
	iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());

	iisCommonCO = iisCommonBO.returnMaturitydate(iisCommonCO);
	islamicCalculatorEventMgmtCO.setMaturityDate(iisCommonCO.getMaturityDate());
	// Check whether new Maturity Date is holiday and the respective
	// holiday action
	IISHolidayCheckCO iisHolidayCheckCO = new IISHolidayCheckCO();
	iisHolidayCheckCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisHolidayCheckCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisHolidayCheckCO.setDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	iisHolidayCheckCO.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
	iisHolidayCheckCO.setDateType("M");
	iisHolidayCheckCO.setApplyYearHoliday(iisCommonBO.returnHolidayActionDealDateYn(iisCommonCO));
	iisHolidayCheckCO.setProductClassCode(islamicCalculatorEventMgmtCO.getProductClass());
	iisHolidayCheckCO.setActionCode(iisCommonBO.returnHolidayAction(iisCommonCO));
	iisHolidayCheckCO = iisCommonBO.checkValueDateIsHoliday(iisHolidayCheckCO);
	iisCommonCO = null;
	TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	TRSCLASSVO trsClassVO = iisCommonBO.returnHolidayActions(trsClassVOKey);
	trsClassVOKey = null;
	if(iisHolidayCheckCO.getHolidayYn().equals(ConstantsCommon.YES)
		&& trsClassVO.getHOLIDAY_ACTION_WARNING_IND().equals(IISCommonConstants.MESSAGE_TYPEWARNING))
	{
	    islamicCalculatorEventMgmtCO.setMaturityDateAfterHoliday(iisHolidayCheckCO.getNewDate());
	    islamicCalculatorEventMgmtCO.setConfirmationMessageId("901900");
	    trsClassVO = null;
	    return islamicCalculatorEventMgmtCO;
	}
	trsClassVO = null;
	// TODO limit checking
	// IF
	// luo_maintain_limit.uf_check_limit_exp_with_maturity(dw_calc.GetItemNumber(1,'cif_no'),dw_calc.GetItemNumber(1,'limit_serial_no'),dw_calc.GetItemDateTime(1,'maturity_date'),dw_calc.GetItemNumber(1,'product_class'))
	// = - 1 THEN
	// this.SetText(iv_colvalue)
	// il_return_limit_dte = -1
	// return 1
	// ELSE
	// il_return_limit_dte = 1
	// END IF
	// TODO IF IsNull(dw_calc.GetItemNumber(1,'ibor_rate_periodicity')) OR
	// IsNull(dw_calc.GetItemString(1,'ibor_rate_periodicity_type')) THEN
	// of_get_floating_yield_rate()
	// END IF
	islamicCalculatorEventMgmtCO
		.setGracePeriod(BigDecimal.valueOf(DateUtil.numberOfDays(islamicCalculatorEventMgmtCO.getStartDate(),
			islamicCalculatorEventMgmtCO.getFirstPaymentDate())));
	islamicCalculatorEventMgmtCO.setGracePeriodicity(IISCommonConstants.DAY);
	return islamicCalculatorEventMgmtCO;
    }

    private Date returnFirstPaymentDate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam,
	    String PLAN_CALC_FRSTPAYDT_PAYEVRY_YN_PARAM, Date valueDate) throws BaseException
    {

	String PLAN_CALC_FRSTPAYDT_PAYEVRY_YN = PLAN_CALC_FRSTPAYDT_PAYEVRY_YN_PARAM;
	if(PLAN_CALC_FRSTPAYDT_PAYEVRY_YN == null)
	{
	    TRSCLASSVOKey trsclassvoKey = new TRSCLASSVOKey();
	    // trsclassvoKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    // trsclassvoKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsclassvo = (TRSCLASSVO) genericDAO.selectByPK(trsclassvoKey);
	    PLAN_CALC_FRSTPAYDT_PAYEVRY_YN = trsclassvo.getPLAN_CALC_FRSTPAYDT_PAYEVRY_YN();
	}

	if(valueDate == null)
	{
	    // throw new BOException("Value Date Cannot be null");
	    return valueDate;
	}
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	String paymentPeriodicity = islamicCalculatorEventMgmtCO.getGracePeriodicity();
	if(paymentPeriodicity == null)
	{
	    // throw new BOException("Peridocicity Cannot be null");
	    return valueDate;
	}
	Long paymentPeriodicityNo = NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getGracePeriod()).longValue();
	if((paymentPeriodicityNo == 0) && PLAN_CALC_FRSTPAYDT_PAYEVRY_YN.equals(ConstantsCommon.NO))
	{
	    islamicCalculatorEventMgmtCO.setFirstPaymentDate(valueDate);
	    // repaymentPlanGridCO = setHijiriDates(repaymentPlanGridCO);
	    return valueDate;
	}
	String paymentMonthPos = islamicCalculatorEventMgmtCO.getPaymPeriodPos();
	if(paymentMonthPos == null)
	{
	    paymentMonthPos = "D";
	}
	String nextDayType = "N";
	if(ConstantsCommon.YES.equals(StringUtil.nullEmptyToValue(PLAN_CALC_FRSTPAYDT_PAYEVRY_YN, ConstantsCommon.NO)))
	{
	    nextDayType = "P";
	}
	Date firstPayDate = valueDate;
	firstPayDate = iisIslamicCalculatorBO.getNextValueDate(valueDate, valueDate, paymentPeriodicity,
		paymentPeriodicityNo, 0L, paymentMonthPos, null, nextDayType);

	if(StringUtil.nullEmptyToValue(PLAN_CALC_FRSTPAYDT_PAYEVRY_YN, "N").equals(ConstantsCommon.YES))
	{
	    nextDayType = "P";
	}
	else
	{
	    return firstPayDate;
	}

	paymentPeriodicity = islamicCalculatorEventMgmtCO.getPaymPeriodicity();
	if(paymentPeriodicity.equals(IISCommonConstants.DAY) || paymentPeriodicity.equals(IISCommonConstants.WEEK))
	{
	    return firstPayDate;
	}
	firstPayDate = DateUtil.dateAdd("MM", -1L, firstPayDate);
	paymentPeriodicityNo = 1l;
	firstPayDate = iisIslamicCalculatorBO.getNextValueDate(firstPayDate, firstPayDate, paymentPeriodicity,
		paymentPeriodicityNo, 0L, paymentMonthPos, null, nextDayType);
	return firstPayDate;

    }

    public void setIisIslamicCalculatorBO(IISIslamicCalculatorBO iisIslamicCalculatorBO)
    {
	this.iisIslamicCalculatorBO = iisIslamicCalculatorBO;
    }

    public void setIisCommonDAO(IISCommonDAO iisCommonDAO)
    {
	this.iisCommonDAO = iisCommonDAO;
    }

    public IISCommonDAO getIisCommonDAO()
    {
	return iisCommonDAO;
    }

    // TP#244113; Ramesh; Date 09/12/2014 [START]
    @Override
    public void validateBalloonAllocatedAmount(IslamicCalculatorCO calculatorCO) throws BaseException
    {
	if(calculatorCO.getTotalBalloonAmount().compareTo(calculatorCO.getTotalAllocatedAmount()) != 0)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Invalid_Missing_Key", "Balloon_Payments_key", "Amount_key" }, true);
	}

    }

    // TP#244113; Ramesh; Date 09/12/2014 [END]

    @Override
    public IslamicCalculatorEventMgmtCO onChangeContractPrice(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {

	calculateDiscountAmount(islamicCalculatorEventMgmtCO);
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * uf_calculate_discount_amt
     * 
     * @param islamicCalculatorEventMgmtCO
     */
    public void calculateDiscountAmount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	BigDecimal ldc_contract_price = NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getContractPrice());
	if(ldc_contract_price.compareTo(BigDecimal.ZERO) == -1)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Contract_Price_cannot_be_less_than_0" }, false);
	}
	BigDecimal ldc_discount_percentage = NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getDiscountPerc());
	if(ldc_discount_percentage.compareTo(BigDecimal.ZERO) == -1)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Discount_percent_cannot_be_less_than_0" }, false);
	}

	if(ldc_discount_percentage.compareTo(BigDecimal.valueOf(999.99999999)) == 1)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Discount_percent_cannot_be_greater_than_999_99999999" }, false);
	}

	String ll_discount_calc_method = StringUtil
		.nullEmptyToValue(islamicCalculatorEventMgmtCO.getDiscountCalMethod(), "0");

	if(ll_discount_calc_method.isEmpty() || "0".equals(ll_discount_calc_method)
		|| ldc_contract_price.compareTo(BigDecimal.ZERO) == 0)
	{
	    islamicCalculatorEventMgmtCO.setPurchaseAmount(BigDecimal.ZERO);
	    islamicCalculatorEventMgmtCO.setDownPaymentAmount(BigDecimal.ZERO);
	    islamicCalculatorEventMgmtCO.setDealAmount(BigDecimal.ZERO);
	    islamicCalculatorEventMgmtCO.setDownPaymentPercentage(BigDecimal.ZERO);
	    islamicCalculatorEventMgmtCO.setAdvancePayment(BigDecimal.ZERO);
	    return;
	}
	BigDecimal ldc_discount_amount = BigDecimal.ZERO;
	if("1".equals(ll_discount_calc_method))
	{
	    // On Purchase Amount
	    ldc_discount_amount = ldc_contract_price.multiply(ldc_discount_percentage
		    .divide(BigDecimal.valueOf(100).add(ldc_discount_percentage), 12, BigDecimal.ROUND_HALF_UP));
	}
	else if("2".equals(ll_discount_calc_method))
	{
	    // on contract price
	    ldc_discount_amount = ldc_contract_price.multiply(ldc_discount_percentage.divide(BigDecimal.valueOf(100)));
	}
	iisIslamicCalculatorBO.setAmountBasedOnCurrPoints(islamicCalculatorEventMgmtCO);
	ldc_discount_amount = NumberUtil.roundToBigDecimal(ldc_discount_amount,
		islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints().intValue());
	BigDecimal ldc_purchase_amt = ldc_contract_price.subtract(ldc_discount_amount);
	if(ldc_purchase_amt.compareTo(BigDecimal.ZERO) != 1)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Discount_Amount_cannot_be_greater_than_or_equal_to_Contract_Price" }, false);
	}

	islamicCalculatorEventMgmtCO.setPurchaseAmount(ldc_purchase_amt);
	islamicCalculatorEventMgmtCO.setDownPaymentAmount(BigDecimal.ZERO);
	islamicCalculatorEventMgmtCO.setDealAmount(ldc_purchase_amt);
	islamicCalculatorEventMgmtCO.setDownPaymentPercentage(BigDecimal.ZERO);
	islamicCalculatorEventMgmtCO.setAdvancePayment(ldc_discount_amount);

	islamicCalculatorEventMgmtCO.setAnnualYieldRate(BigDecimal.ZERO);

    }

    @Override
    public IslamicCalculatorEventMgmtCO onChangeDiscountCalMethod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	calculateDiscountAmount(islamicCalculatorEventMgmtCO);
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO onChangeDiscountPerc(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	calculateDiscountAmount(islamicCalculatorEventMgmtCO);
	return islamicCalculatorEventMgmtCO;
    }

    public CommonLibBO getCommonLibBO()
    {
	return commonLibBO;
    }

    @Override
    public void setCommonLibBO(CommonLibBO commonLibBO)
    {
	this.commonLibBO = commonLibBO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO dependencyByCrossRate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	BigDecimal multipleamt = BigDecimal.ZERO;

	CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getTradingCurrency());
	CURRENCIESVO currrency = commonLibBO.returnCurrency(currenciesVOKey);
	// CURRENCIESVO currrency = (CURRENCIESVO)
	// genericDAO.selectByPK(currenciesVOKey);

	if(currrency == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_DEAL_CURRENCY);
	}

	if(islamicCalculatorEventMgmtCO.getCrossRate().compareTo(BigDecimal.ZERO) < 0)
	{
	    throw new BOException("Currency Cross Rate ,Currency Cross Rate must be greater than 0");

	}
	if(islamicCalculatorEventMgmtCO.getTradingBillAmount() != null)
	{
	    multipleamt = islamicCalculatorEventMgmtCO.getTradingBillAmount()
		    .multiply(islamicCalculatorEventMgmtCO.getCrossRate());

	    if(islamicCalculatorEventMgmtCO.getTradingBillAmount().compareTo(BigDecimal.ZERO) != 0)
	    {

		BigDecimal loTotalBillamt = islamicCalculatorEventMgmtCO.getNoOfBills();
		NumberUtil.roundToBigDecimal(multipleamt, currrency.getDECIMAL_POINTS().intValue());
		islamicCalculatorEventMgmtCO.setBillAmount(multipleamt);
		islamicCalculatorEventMgmtCO.setAmountPerPayment(multipleamt);
		islamicCalculatorEventMgmtCO.setTotalBillAmount(loTotalBillamt.multiply(multipleamt));
	    }

	}
	BigDecimal lfacilitynbr = islamicCalculatorEventMgmtCO.getFacilityNbr();

	if(lfacilitynbr.compareTo(BigDecimal.ZERO) != 0 || lfacilitynbr.compareTo(BigDecimal.ZERO) > 0)
	{
	    multipleamt = islamicCalculatorEventMgmtCO.getNoOfBills().multiply(multipleamt);

	    // FOR TESTING cOMMENDED
	    /*
	     * if(multipleamt.compareTo(islamicCalculatorEventMgmtCO.
	     * getUnutilizedFacilityAmt ()) > 0) { throw new
	     * BOException("Bill Amount",
	     * "Amount cannot be greater than the Remaining Facility Amount"); }
	     */
	}

	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO dependencyTradingBillAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	if(islamicCalculatorEventMgmtCO.getCrossRate().compareTo(BigDecimal.ZERO) == 0)
	{
	    throw new BOException("Cross rate Cannot be Zero");
	}
	CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getTradingCurrency());
	CURRENCIESVO currrency = commonLibBO.returnCurrency(currenciesVOKey);
	// CURRENCIESVO currrency = (CURRENCIESVO)
	// genericDAO.selectByPK(currenciesVOKey);

	if(currrency == null)
	{
	    throw new BOException(MessageCodes.INVALID_CURRENCY_CODE);
	}

	BigDecimal crossrate = islamicCalculatorEventMgmtCO.getCrossRate();

	BigDecimal multipleamt = islamicCalculatorEventMgmtCO.getTradingBillAmount().multiply(crossrate);

	BigDecimal totalTradingBillAmount = islamicCalculatorEventMgmtCO.getNoOfBills()
		.multiply(islamicCalculatorEventMgmtCO.getTradingBillAmount());

	islamicCalculatorEventMgmtCO.getTradingBillAmount();

	if(crossrate.compareTo(BigDecimal.ZERO) != 0)
	{
	    BigDecimal intval = NumberUtil.nullToZero(currrency.getDECIMAL_POINTS());
	    NumberUtil.roundToBigDecimal(multipleamt, intval.intValue());
	    islamicCalculatorEventMgmtCO.setBillAmount(multipleamt);
	    islamicCalculatorEventMgmtCO.setTotalTradingBillAmount(totalTradingBillAmount);
	    islamicCalculatorEventMgmtCO.setAmountPerPayment(multipleamt);
	    if(islamicCalculatorEventMgmtCO.getNoOfBills() != null)
	    {
		islamicCalculatorEventMgmtCO
			.setTotalBillAmount(islamicCalculatorEventMgmtCO.getNoOfBills().multiply(multipleamt));
	    }

	}

	BigDecimal lfacilitynbr = islamicCalculatorEventMgmtCO.getFacilityNbr();

	if(lfacilitynbr.compareTo(BigDecimal.ZERO) != 0 || lfacilitynbr.compareTo(BigDecimal.ZERO) > 0)
	{
	    if(islamicCalculatorEventMgmtCO.getNoOfBills() != null)
	    {
		multipleamt = islamicCalculatorEventMgmtCO.getNoOfBills().multiply(multipleamt);

		// For testing commanded
		/*
		 * if(multipleamt.compareTo(islamicCalculatorEventMgmtCO.
		 * getUnutilizedFacilityAmt ()) > 0) { throw newBOException(
		 * "Bill Amount, Amount cannot be greater than the Remaining Facility Amount"
		 * ); }
		 */

	    }

	}
	if(islamicCalculatorEventMgmtCO.getTfaTrxType().equals("N"))
	{
	    if(islamicCalculatorEventMgmtCO.getTradingBillAmount()
		    .compareTo(islamicCalculatorEventMgmtCO.getTfaBillAmount()) > 0)

	    {
		throw new BOException("Invalid Bill Amount ,Amount cannot be greater than the TFA Margin amount");
	    }

	}

	// TODO Auto-generated method stub
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO dependencyPeriodicity(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {

	if(islamicCalculatorEventMgmtCO.getPeriodicityNbr().compareTo(BigDecimal.ZERO) < 0)

	{
	    throw new BOException("Tenure  must be greater than 0");
	}

	IISCommonCO iisCommonCO1 = new IISCommonCO();

	if("Y".equals(islamicCalculatorEventMgmtCO.getPeriodicityType()))
	{
	    iisCommonCO1.setNoOfPayments(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getPeriodicityNbr()));

	}
	else
	{
	    iisCommonCO1.setNoOfPayments(
		    NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getPeriodicityNbr()).add(BigDecimal.ONE));

	}
	// iisCommonCO1.setNoOfPayments(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getPeriodicityNbr().add(
	// BigDecimal.ONE)));
	iisCommonCO1.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPeriodicityType());
	iisCommonCO1.setPaymPeriodNbr(BigDecimal.ONE);
	iisCommonCO1.setPaymPeriodPos("D");
	// iisCommonCO1.setValue("COMMENCE");
	iisCommonCO1.setValue("BILLS");
	iisCommonCO1.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	iisCommonCO1.setFirstPayDate(islamicCalculatorEventMgmtCO.getStartDate());
	iisCommonCO1.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisCommonCO1.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());

	iisCommonCO1 = iisCommonBO.returnMaturitydate(iisCommonCO1);

	islamicCalculatorEventMgmtCO.setMaturityDate(iisCommonCO1.getMaturityDate());

	if(islamicCalculatorEventMgmtCO.getNoOfPayments().compareTo(BigDecimal.ONE) == 0)
	{
	    islamicCalculatorEventMgmtCO.setGracePeriodicity("D");
	    islamicCalculatorEventMgmtCO.setGracePeriod(BigDecimal.valueOf(DateUtil.numberOfDays(
		    islamicCalculatorEventMgmtCO.getStartDate(), islamicCalculatorEventMgmtCO.getMaturityDate())));
	    islamicCalculatorEventMgmtCO.setFirstPaymentDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	}

	/*
	 * Long(This.GetText()) )) // //BMMB100081 - <begin> If
	 * IsNull(il_holiday_action) Then il_holiday_action = 0 lv_date =
	 * This.GetItemDateTime(1,'maturity_date') ld_hdate =
	 * uf_check_currency_holiday(lv_date, 'M',
	 * This.GetItemNumber(1,'currency_code'), il_holiday_action,
	 * This.GetItemNumber(1,'product_class'),
	 * gnv_iis_globalvar.is_holiday_action_deal_vdate_yn, dw_countryholiday)
	 * If Not IsNull(ld_hdate) And ld_hdate <> lv_date Then
	 * This.SetItem(1,'maturity_date',ld_hdate) End If
	 */
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO iborDependencyPeriodicity(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getIborRatePeriodicity().compareTo(BigDecimal.ZERO) < 0)
	{
	    throw new BOException("Floating Rate Periodicity ,Floating Rate Periodicity must be greater than 0");
	}

	// TODO
	// IF
	// wf_get_libor_rate(This.GetItemNumber(1,'global_rate_code'),Long(This.GetText()),
	// This.GetItemString(1,'ibor_periodicity_type') ) = -1 Then

	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO dependencyMarginRateBillsCalculator(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);

	if(trsClassVO == null)

	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);

	}
	if(trsClassVO.getALLOW_NEGATIVE_MARGIN_RATE_YN().isEmpty())
	{
	    trsClassVO.setALLOW_NEGATIVE_MARGIN_RATE_YN("N");
	}
	if(trsClassVO.getALLOW_NEGATIVE_MARGIN_RATE_YN().equals("Y"))
	{

	    double marginValue = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getMargin());

	    if(marginValue > 9999.999999)
	    {
		throw new BOException(MessageCodes.CHECK_YIELD_VALUE, new String[] { "0", "9,999.999999" });
	    }
	    else if((marginValue < 0 || marginValue > 9999.999999))
	    {
		throw new BOException(MessageCodes.CHECK_YIELD_VALUE, new String[] { "0", "9,999.999999" });
	    }
	}

	islamicCalculatorEventMgmtCO.setYield(
		islamicCalculatorEventMgmtCO.getMargin().add(islamicCalculatorEventMgmtCO.getFloatingRateCode()));
	islamicCalculatorEventMgmtCO.setPriceUserTypedYN("N");

	islamicCalculatorEventMgmtCO.setAnnualYieldRate(
		islamicCalculatorEventMgmtCO.getMargin().add(islamicCalculatorEventMgmtCO.getFloatingRate()));

	iisCommonBO.applyPriceSetCalculator(islamicCalculatorEventMgmtCO);

	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO dependencyGlobalRateBillsCalculator(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	islamicCalculatorEventMgmtCO.setPriceUserTypedYN("N");

	iisCommonBO.applyPriceSetCalculator(islamicCalculatorEventMgmtCO);
	TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);

	if(trsClassVO == null)

	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);

	}

	if(islamicCalculatorEventMgmtCO.getDefaultedFloatingRate()
		.compareTo(islamicCalculatorEventMgmtCO.getFloatingRate()) > 0)
	{
	    if("Y".equals(trsClassVO.getWARN_FLOAT_RATE_DECREASE_YN()))

	    {
		throw new BOException("Information , The floating rate has been changed by the user !");
	    }
	}
	islamicCalculatorEventMgmtCO.setAnnualYieldRate(
		islamicCalculatorEventMgmtCO.getMargin().add(islamicCalculatorEventMgmtCO.getFloatingRate()));

	/*
	 * islamicCalculatorEventMgmtCO.setAnnualYieldRate(
	 * islamicCalculatorEventMgmtCO.getMargin().add(
	 * islamicCalculatorEventMgmtCO.getFloatingRate()));
	 */ // wf_get_libor_rate

	// int count =
	// iisCommonFunctionsBO.returnCheckFloatingRateQuotedByNeedYN(islamicCalculatorEventMgmtCO
	// .getCompCode(), islamicCalculatorEventMgmtCO.getClassCode());

	// TODO
	/*
	 * IF dw_float_rate_uoted_by.RowCount() > 0 Then ll_find =
	 * dw_float_rate_uoted_by.Find(ls_find, 1,
	 * dw_float_rate_uoted_by.RowCount()) End If
	 * 
	 * IF ll_find <= 0 Then ll_row = dw_float_rate_uoted_by.InsertRow(0)
	 * dw_float_rate_uoted_by.SetITem(ll_row, 'comp_code', gv_company_code)
	 * dw_float_rate_uoted_by.SetITem(ll_row, 'branch_code', gv_branch_code)
	 * dw_float_rate_uoted_by.SetITem(ll_row, 'deal_no', 0)
	 * dw_float_rate_uoted_by.SetITem(ll_row, 'actual_rate',
	 * idec_defaulted_floating_rate) dw_float_rate_uoted_by.SetITem(ll_row,
	 * 'new_rate', lv_dec) dw_float_rate_uoted_by.SetITem(ll_row, 'trs_no',
	 * 0) dw_float_rate_uoted_by.SetITem(ll_row, 'trs_seq', 0)
	 * dw_float_rate_uoted_by.SetITem(ll_row, 'line_no', 1)
	 * dw_float_rate_uoted_by.SetITem(ll_row, 'trs_type', 'C')
	 * dw_float_rate_uoted_by.SetITem(ll_row, 'created_by', gv_userid)
	 * dw_float_rate_uoted_by.SetITem(ll_row, 'created_date',
	 * gv_system_date) Else dw_float_rate_uoted_by.SetITem(ll_find,
	 * 'new_rate', lv_dec) End If Else IF dw_float_rate_uoted_by.RowCount()
	 * > 0 Then ll_find = dw_float_rate_uoted_by.Find(ls_find, 1,
	 * dw_float_rate_uoted_by.RowCount()) End If IF ll_find > 0 Then
	 * dw_float_rate_uoted_by.DeleteRow(ll_find) End If End If End IF
	 * 
	 * IF lv_colname = "total_bill_amount" or lv_colname =
	 * "trading_bill_amount" or lv_colname = "cross_rate" or lv_colname =
	 * "bill_amount" or lv_colname = "no_of_bills" Then IF
	 * wf_get_libor_rate(This.GetItemNumber(1,
	 * 'global_rate_code'),This.GetItemNumber(1,'ibor_periodicity_nbr'),
	 * This.GetItemString(1,'ibor_periodicity_type') ) = -1 Then Return 1
	 * End If End If IF lv_colname <> 'periodicity_nbr' and lv_colname <>
	 * 'periodicity_type' & and lv_colname <> 'value_date' and lv_colname <>
	 * 'maturity_date' Then ll_days = DaysAfter(
	 * Date(This.GetItemDateTime(1,"value_date")),
	 * Date(This.GetItemDateTime(1,"maturity_date")))
	 * This.SetItem(1,"periodicity_type",'D')
	 * This.SetItem(1,"periodicity_nbr",ll_days) End IF
	 * 
	 * IF lv_colname <> 'maturity_date' And
	 * This.GetItemNumber(1,'no_of_payments') = 1 Then
	 * This.SetItem(1,'grace_periodicity','D')This.SetItem(1,
	 * 'grace_period',DaysAfter(Date(This.GetItemDateTime(1,'
	 * commencement_date')),Date(This.GetItemDateTime(1,'maturity_date')) ))
	 * This.SetItem(1,'first_pay_date',This.GetItemDateTime(1,'maturity_date
	 * ')) End IF
	 * 
	 * 
	 * IF lv_colname = 'no_of_bills' OR lv_colname = 'maturity_date' OR
	 * lv_colname = 'paym_period_nbr' THEN IF f_get_base_calendor () = 'H'
	 * AND dw_calc.GetItemString(1,'calendar_type') = 'H' THEN IF Not
	 * Isnull(dw_calc.GetItemDateTime(1,'first_pay_date')) THEN ls_date =
	 * luo_hijiri_calendor.uf_get_hijiri_date
	 * (dw_calc.GetItemDateTime(1,'first_pay_date'))
	 * dw_calc.SetItem(1,'first_payment_date_hijiri',ls_date) END IF END IF
	 * END IF
	 * 
	 * 
	 * iv_definition_changed = True
	 */

	return islamicCalculatorEventMgmtCO;

    }

    /**
     * @author Arun.Variyath
     * @date 05/08/2015 TAR JAIZ140012
     * @param islamicCalculatorEventMgmtCO
     * @return
     */
    @Override
    public IslamicCalculatorEventMgmtCO onChangeProfitRecognitionMethod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	if(trsClassVO != null && "Y".equals(trsClassVO.getPRFT_ACCR_ON_OUTSTAND_PRINC_YN())
		&& (IISCommonConstants.PROFIT_DISTRIBUTION_METHOD_IAS_18
			.equals(islamicCalculatorEventMgmtCO.getProfitRecognitionMethod())
			|| IISCommonConstants.PROFIT_DISTRIBUTION_METHOD_IAS_18
				.equals(islamicCalculatorEventMgmtCO.getProfitRecognitionMethod())))
	{
	    throw new BOException(MessageCodes.iis_invalid_code, new String[] {
		    "Profit_Recognition_method_should_be_Diminishing_Returns_for_Profit_Accrual_on_Outstanding_Principal_Product_key" },
		    false);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * @author Arun.Variyath
     * @date 05/08/2015 TAR JAIZ140012
     * @param islamicCalculatorEventMgmtCO
     * @return
     */
    @Override
    public IslamicCalculatorEventMgmtCO onChangeAccrualBasis(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	if(trsClassVO != null && "Y".equals(trsClassVO.getPRFT_ACCR_ON_OUTSTAND_PRINC_YN())
		&& (islamicCalculatorEventMgmtCO.getAccrualBasis().compareTo(BigDecimal.valueOf(2)) == 0
			|| islamicCalculatorEventMgmtCO.getAccrualBasis().compareTo(BigDecimal.valueOf(3)) == 0))
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Invalid_Accrual_Basis_for_Profit_Accrual_on_Outstanding_Principal_Product_key" },
		    false);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * // TP# BB130052;deepu.mohandas 08/09/2015
     */
    @Override
    public IslamicCalculatorEventMgmtCO afterDependencyForOnChangeMaturityDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom()).isEmpty())
	{
	    long noOfDays = DateUtil.numberOfDays(islamicCalculatorEventMgmtCO.getStartDate(),
		    islamicCalculatorEventMgmtCO.getMaturityDate());
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCO.setCifNo(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getCifNo()));
	    iisCommonCO.setProductClass(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getProductClass()));
	    // iisCommonCO.setLimitCode(BigDecimal.ZERO);
	    iisCommonCO.setLimitCode(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getLimitSerialNo()));

	    iisCommonCO.setPaymPeriodNbr(new BigDecimal(noOfDays));

	    iisCommonCO.setPaymPeriodicity("D");
	    iisCommonBO.checkClassLimitTenure(iisCommonCO);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 **/
    @Override
    public IslamicCalculatorEventMgmtCO onChangeTopUpDealSelYN(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	BigDecimal prevTopupAmount = BigDecimal.ZERO, totalTopupAmount = BigDecimal.ZERO, netAmount = BigDecimal.ZERO;
	for(IslamicCalculatorEventMgmtCO aIslamicCalculatorEventMgmtCO : islamicCalculatorEventMgmtCO
		.getTopUpGridList())
	{
	    // if(ConstantsCommon.YES.equals(aIslamicCalculatorEventMgmtCO.getTopUpDealSelYN()))
	    // {
	    prevTopupAmount = prevTopupAmount
		    .add(NumberUtil.emptyDecimalToZero(aIslamicCalculatorEventMgmtCO.getOutStandingTopUpCy()));
	    // }
	}
	BigDecimal curRowOsAmount = NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsTopUpDealDetVO().getCROSS_CY_OS_AMOUNT());
	if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getTopUpDealSelYN()))
	{
	    totalTopupAmount = prevTopupAmount.add(curRowOsAmount);
	}
	else
	{
	    totalTopupAmount = prevTopupAmount.subtract(curRowOsAmount);
	}
	netAmount = NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsTopUpDealVO().getTOP_UP_DEAL_AMOUNT())
		.subtract(totalTopupAmount);
	if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getTopUpDealSelYN()))
	{
	    if(netAmount.compareTo(BigDecimal.ZERO) < 0)
	    {
		throw new BOException(MessageCodes.iis_invalid_code,
			new String[] { "deal_amount_cannot_be_less_than_settled_amount_key" });
	    }
	    islamicCalculatorEventMgmtCO
		    .setBranchCode(islamicCalculatorEventMgmtCO.getTrsTopUpDealDetVO().getDEAL_BRANCH());
	    islamicCalculatorEventMgmtCO.setDealNo(islamicCalculatorEventMgmtCO.getTrsTopUpDealDetVO().getDEAL_NO());
	    BigDecimal recCount = NumberUtil
		    .emptyDecimalToZero(islamicCalculatorEventMgmtDAO.returnPIRecCount(islamicCalculatorEventMgmtCO));
	    if(recCount.compareTo(BigDecimal.ZERO) == 0)
	    {
		throw new BOException(MessageCodes.iis_invalid_code,
			new String[] { "payment_instruction_not_created_or_approved_key" });
	    }

	    String status = StringUtil
		    .nullToEmpty(islamicCalculatorEventMgmtDAO.returnActiveSettlement(islamicCalculatorEventMgmtCO));
	    if(ConstantsCommon.YES.equals(status))
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] { "active_settlement_exist_key" });
	    }

	    recCount = NumberUtil.emptyDecimalToZero(
		    islamicCalculatorEventMgmtDAO.returnTrsSetlmntBlockingRecCount(islamicCalculatorEventMgmtCO));
	    if(recCount.compareTo(BigDecimal.ZERO) > 0)
	    {
		throw new BOException(MessageCodes.iis_invalid_code,
			new String[] { "active_online_salary_blocking_exists_key" });
	    }
	}
	if(ConstantsCommon.NO.equals(islamicCalculatorEventMgmtCO.getTopUpDealSelYN()))
	{
	    islamicCalculatorEventMgmtCO.setOutStandingTopUpCy(BigDecimal.ZERO);
	}
	else
	{
	    islamicCalculatorEventMgmtCO.setOutStandingTopUpCy(NumberUtil
		    .emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsTopUpDealDetVO().getCROSS_CY_OS_AMOUNT()));
	}
	islamicCalculatorEventMgmtCO.setNetCreditToCustomer(netAmount);
	return islamicCalculatorEventMgmtCO;
    }

    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 **/
    @Override
    public IslamicCalculatorEventMgmtCO onChangeReimburseProfitPerc(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	BigDecimal reimburseProfitPerc = NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsTopUpDealDetVO().getREIMBURSE_PROFIT_PERC());

	if(reimburseProfitPerc.compareTo(BigDecimal.ZERO) < 0
		|| reimburseProfitPerc.compareTo(BigDecimal.valueOf(100)) > 0)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "reimburse_profit_percentage_should_be_between_0_perc_and_100_perc_key" });
	}

	islamicCalculatorEventMgmtCO
		.setProductClass(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getProductClass()));
	TRSCLASSVO trsClassVO = getTRSClassParams(islamicCalculatorEventMgmtCO);
	BigDecimal reimburseProfitMinPerc = BigDecimal.ZERO, reimburseProfitMaxPerc = BigDecimal.ZERO;
	if(trsClassVO != null)
	{
	    reimburseProfitMinPerc = NumberUtil.emptyDecimalToZero(trsClassVO.getREIMBURSE_PROFIT_MIN_PERC());
	    reimburseProfitMaxPerc = NumberUtil.emptyDecimalToZero(trsClassVO.getREIMBURSE_PROFIT_MAX_PERC());
	}
	if(reimburseProfitPerc.compareTo(reimburseProfitMinPerc) < 0
		|| reimburseProfitPerc.compareTo(reimburseProfitMaxPerc) > 0)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Reimburse_Profit_Percentage_Should_be_between_Key" + reimburseProfitMinPerc
			    + "% And " + reimburseProfitMaxPerc + "%" });
	}
	islamicCalculatorEventMgmtCO.setDealNo(islamicCalculatorEventMgmtCO.getTrsTopUpDealDetVO().getDEAL_NO());
	Date nextMaturityDate = islamicCalculatorEventMgmtCO.getTrsTopUpDealVO().getVALUE_DATE();
	Date lastSettlementDate = DateUtil
		.nullToInitDate(islamicCalculatorEventMgmtDAO.returnLastSetlmntDate(islamicCalculatorEventMgmtCO));
	if(nextMaturityDate.before(lastSettlementDate))
	{
	    nextMaturityDate = lastSettlementDate;
	}
	islamicCalculatorEventMgmtCO.setMaturityDate(nextMaturityDate);
	// BigDecimal reimburseProfit = NumberUtil
	// .emptyDecimalToZero(islamicCalculatorEventMgmtDAO.returnReimburseProfit(islamicCalculatorEventMgmtCO));

	BigDecimal reimburseProfit = returnEarlySettlementReimbursmentAmount(islamicCalculatorEventMgmtCO);

	reimburseProfit = reimburseProfit.multiply(reimburseProfitPerc).divide(BigDecimal.valueOf(100));
	islamicCalculatorEventMgmtCO.getTrsTopUpDealDetVO().setREIMBURSE_PROFIT_AMOUNT(reimburseProfit);
	return islamicCalculatorEventMgmtCO;
    }

    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 **/
    @Override
    public IslamicCalculatorEventMgmtCO onChangeReimburseProfitAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	BigDecimal reimburseProfitAmount = NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsTopUpDealDetVO().getREIMBURSE_PROFIT_AMOUNT());

	if(reimburseProfitAmount.compareTo(BigDecimal.ZERO) < 0)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "reimburse_profit_should_be_greater_than_zero_key" });
	}
	islamicCalculatorEventMgmtCO.setDealNo(islamicCalculatorEventMgmtCO.getTrsTopUpDealDetVO().getDEAL_NO());
	Date nextMaturityDate = islamicCalculatorEventMgmtCO.getTrsTopUpDealVO().getVALUE_DATE();
	Date lastSettlementDate = DateUtil
		.nullToInitDate(islamicCalculatorEventMgmtDAO.returnLastSetlmntDate(islamicCalculatorEventMgmtCO));
	if(nextMaturityDate.before(lastSettlementDate))
	{
	    nextMaturityDate = lastSettlementDate;
	}
	islamicCalculatorEventMgmtCO.setMaturityDate(nextMaturityDate);
	// BigDecimal reimburseProfit = NumberUtil
	// .emptyDecimalToZero(islamicCalculatorEventMgmtDAO.returnReimburseProfit(islamicCalculatorEventMgmtCO));

	BigDecimal reimburseProfit = returnEarlySettlementReimbursmentAmount(islamicCalculatorEventMgmtCO);
	if(reimburseProfitAmount.compareTo(reimburseProfit) > 0)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "reimburse_profit_percentage_should_be_between_0_perc_and_100_perc_key" });
	}
	else
	{

	    BigDecimal reimbureProfitPerc = NumberUtil
		    .roundToBigDecimal((reimburseProfitAmount.divide(reimburseProfit, 6, RoundingMode.HALF_UP))
			    .multiply(BigDecimal.valueOf(100)), 3);
	    islamicCalculatorEventMgmtCO.getTrsTopUpDealDetVO().setREIMBURSE_PROFIT_PERC(reimbureProfitPerc);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * @author sputhiyapurayil
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     */
    private BigDecimal returnEarlySettlementReimbursmentAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisCommonCO.setDealNo(islamicCalculatorEventMgmtCO.getTrsTopUpDealDetVO().getDEAL_NO());
	TRSPAYPLANVO trspayplanvo = islamicCalculatorEventMgmtDAO.returnPlanByDeal(iisCommonCO);
	if(trspayplanvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING);
	}
	iisCommonCO.setPlanNbr(trspayplanvo.getPLAN_NBR());
	iisCommonCO.setPlanSeq(trspayplanvo.getPLAN_SEQ());
	iisCommonCO.setSettlementDate(islamicCalculatorEventMgmtCO.getRunningDate());
	iisCommonCO.setProfitUpfront(ConstantsCommon.YES);
	BigDecimal reimburseAmount = iisCommonBO.returnEarlySettlementReimbursmentAmount(iisCommonCO);

	return reimburseAmount;
    }

    @Override
    public IslamicCalculatorEventMgmtCO onChangeBuyOutBankCifNo(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	islamicCalculatorEventMgmtCO.setCifNo(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBANK_CIF_NO());
	BigDecimal cifNo = NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtDAO.returnBuyOutBankCifNo(islamicCalculatorEventMgmtCO));
	if(cifNo.compareTo(BigDecimal.ZERO) == 0)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
	}
	CIFVOKey cifVOKey = new CIFVOKey();
	cifVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	cifVOKey.setCIF_NO(cifNo);
	CIFVO cifvo = commonLibBO.returnCIFVO(cifVOKey);
	if(cifvo != null)
	{
	    islamicCalculatorEventMgmtCO.setCifName(cifvo.getSHORT_NAME_ENG());
	}
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO onChangeBuyOutDealCy(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getCurrencyCode());
	CURRENCIESVO currrency = (CURRENCIESVO) genericDAO.selectByPK(currenciesVOKey);
	if(currrency == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_DEAL_CURRENCY);
	}
	islamicCalculatorEventMgmtCO.setCurrencyDesc(currrency.getBRIEF_DESC_ENG());
	islamicCalculatorEventMgmtCO.setCurrencyDecimalPoints(currrency.getDECIMAL_POINTS());
	islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO()
		.setCROSS_CY_EXCH_MULT_DIV_IND(IISCommonConstants.DEAL_MULTDIV_MULTIPLY);
	if(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_CY()
		.compareTo(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getNEW_DEAL_CY()) == 0)
	{
	    islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().setCROSS_CY_EXCH_RATE(BigDecimal.ONE);
	}
	else
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisCommonCO.setTrCurrency(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_CY());
	    iisCommonCO.setPfCurrency(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getNEW_DEAL_CY());
	    iisCommonCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    iisCommonCO.setRunningDate(islamicCalculatorEventMgmtCO.getRunningDate());
	    iisCommonCO.setCifNo(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBANK_CIF_NO());
	    iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
	    if(iisCommonCO != null)
	    {
		islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().setCROSS_CY_EXCH_RATE(iisCommonCO.getCrossRate());
	    }
	}
	islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO()
		.setTRSFR_TO_ACC_CY(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_CY());
	islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().setTRSFR_TO_ACC_GL(null);
	islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().setTRSFR_TO_ACC_SL(null);
	islamicCalculatorEventMgmtCO.setACCOUNT_NAME(null);
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO onChangeBuyOutDealAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	BigDecimal buyOutDealAmountCross = BigDecimal.ZERO, buyOutDealAmount = BigDecimal.ZERO;
	buyOutDealAmount = NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_AMOUNT());
	BigDecimal newDealAmount = NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getNEW_DEAL_AMOUNT());
	if(buyOutDealAmount.compareTo(BigDecimal.ZERO) <= 0)
	{
	    throw new BOException(MessageCodes.VALUE_CANNOT_BE_LESS_THAN_ZERO);
	}
	if(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_CY()
		.compareTo(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getNEW_DEAL_CY()) == 0)
	{
	    buyOutDealAmountCross = buyOutDealAmount;
	}
	else
	{
	    if(IISCommonConstants.DEAL_MULTDIV_MULTIPLY
		    .equals(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getCROSS_CY_EXCH_MULT_DIV_IND()))
	    {
		buyOutDealAmountCross = buyOutDealAmount.multiply(NumberUtil
			.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getCROSS_CY_EXCH_RATE()));
	    }
	    else
	    {
		if(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getCROSS_CY_EXCH_RATE()
			.compareTo(BigDecimal.ZERO) <= 0)
		{
		    throw new BOException(MessageCodes.iis_invalid_code,
			    new String[] { "invalid_cross_exchange_rate_key" });
		}
		buyOutDealAmountCross = buyOutDealAmount.divide(NumberUtil
			.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getCROSS_CY_EXCH_RATE()));
	    }
	}
	if(buyOutDealAmountCross.compareTo(NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getNEW_DEAL_AMOUNT())) > 0)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "buy_out_deal_amount_cannot_be_greater_than_new_deal_amount_key" });
	}
	CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_CY());
	CURRENCIESVO currenciesVO = (CURRENCIESVO) genericDAO.selectByPK(currenciesVOKey);
	if(currenciesVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CURRENCY);
	}
	String currencyFormat = NumberUtil.currencyMask(currenciesVO.getDECIMAL_POINTS());
	BigDecimal netCreditToCustomer = newDealAmount.subtract(buyOutDealAmountCross);
	islamicCalculatorEventMgmtCO.setNetCreditToCustomer(netCreditToCustomer);
	commonLibBO.applyDynScreenDisplay("buyOut_net_credit_to_customer", null, ConstantsCommon.ACTION_TYPE_DECFORMAT,
		currencyFormat, islamicCalculatorEventMgmtCO.getHmSysParam(), null);
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO onChangeCrossCyExchRate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getCROSS_CY_EXCH_RATE())
		.compareTo(BigDecimal.ZERO) <= 0)
	{
	    throw new BOException(MessageCodes.VALUE_CANNOT_BE_LESS_THAN_ZERO);
	}
	return islamicCalculatorEventMgmtCO;
    }

    public IslamicCalculatorEventMgmtCO onChangeTrAccountBranch(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	BRANCHESVOKey branchesVOKey = new BRANCHESVOKey();
	branchesVOKey.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_BR());
	branchesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	BRANCHESVO branchesVO = (BRANCHESVO) genericDAO.selectByPK(branchesVOKey);
	branchesVOKey = null;
	if(branchesVO == null)
	{
	    throw new BOException(MessageCodes.iis_invalid_code, new String[] { "Invalid_Account_Branch_Code_key" },
		    false);
	}
	islamicCalculatorEventMgmtCO.setACCOUNT_NAME(null);
	islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().setTRSFR_TO_ACC_GL(null);
	islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().setTRSFR_TO_ACC_CIF(null);
	islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().setTRSFR_TO_ACC_SL(null);
	NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO());
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO onChangeTrAccountGl(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	BigDecimal accGl = NumberUtil
		.nullToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_GL());
	if((!NumberUtil.isEmptyDecimal(accGl)) && (accGl.compareTo(BigDecimal.ZERO) <= 0))
	{
	    throw new BOException(MessageCodes.INVALID_GL_CODE);
	}

	GEN_LEDGERVOKey genLEDGERVOKey = new GEN_LEDGERVOKey();
	genLEDGERVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	genLEDGERVOKey.setGL_CODE(accGl);
	GEN_LEDGERVO ledgervo = (GEN_LEDGERVO) genericDAO.selectByPK(genLEDGERVOKey);
	if(ledgervo == null)
	{
	    throw new BOException(MessageCodes.INVALID_GL_CODE);
	}
	islamicCalculatorEventMgmtCO.setACCOUNT_NAME(null);
	islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().setTRSFR_TO_ACC_CIF(null);
	islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().setTRSFR_TO_ACC_SL(null);
	NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO());
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO onChangeTrAccountCif(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	BigDecimal accCif = islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_CIF();
	if(NumberUtil.isEmptyDecimal(accCif) || accCif.compareTo(BigDecimal.ZERO) < 0)
	{
	    throw new BOException(MessageCodes.INVALID_CIF_NUMBER);
	}

	CifSC criteria = new CifSC();
	criteria.setComp_code(islamicCalculatorEventMgmtCO.getCompCode());
	criteria.setCif_no(accCif);
	CIFVO cifvo = commonLibBO.returnCIF(criteria);
	if(cifvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_CIF_NUMBER);
	}
	islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().setTRSFR_TO_ACC_SL(null);
	islamicCalculatorEventMgmtCO.setACCOUNT_NAME(null);
	NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO());
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO onChangeTrAccountSl(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	BigDecimal accSl = islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_SL();
	if(accSl == null || accSl.compareTo(BigDecimal.ZERO) < 0)
	{
	    throw new BOException(MessageCodes.iis_invalid_code, new String[] { "Missing_Invalid_SL_key" }, false);
	}
	BigDecimal accBr = islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_BR();
	BigDecimal accCy = islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_CY();
	BigDecimal accGl = islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_GL();
	BigDecimal accCif = islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_CIF();
	if(accBr != null && accCif != null && accCy != null && accGl != null)
	{
	    AMFVOKey amfVOKey = new AMFVOKey();
	    amfVOKey.setBRANCH_CODE(accBr);
	    amfVOKey.setCURRENCY_CODE(accCy);
	    amfVOKey.setCIF_SUB_NO(accCif);
	    amfVOKey.setGL_CODE(accGl);
	    amfVOKey.setSL_NO(accSl);
	    amfVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    AMFVO amfVO = (AMFVO) genericDAO.selectByPK(amfVOKey);
	    amfVOKey = null;
	    if(amfVO == null)
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] { "Missing_Invalid_SL_key" }, false);
	    }
	    else
	    {
		islamicCalculatorEventMgmtCO.setACCOUNT_NAME(amfVO.getBRIEF_NAME_ENG());
		islamicCalculatorEventMgmtCO.setADDITIONAL_REFERENCE(amfVO.getADDITIONAL_REFERENCE());
	    }
	}
	NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO());
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IslamicCalculatorEventMgmtCO onChangeTrAccountCy(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	BigDecimal accCy = NumberUtil
		.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_CY());
	if(accCy.compareTo(BigDecimal.ZERO) <= 0)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CURRENCY);
	}
	else
	{
	    CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	    currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    currenciesVOKey.setCURRENCY_CODE(accCy);
	    CURRENCIESVO currenciesVO = (CURRENCIESVO) genericDAO.selectByPK(currenciesVOKey);
	    if(currenciesVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CURRENCY);
	    }
	}
	NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO());
	return islamicCalculatorEventMgmtCO;
    }

    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 **/
    @Override
    public void validateDealType(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(IISCommonConstants.TOPUP.equals(StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getDealType())))
	{
	    boolean isDealSelected = false;
	    if(islamicCalculatorEventMgmtCO.getTopUpGridList() == null
		    || islamicCalculatorEventMgmtCO.getTopUpGridList().isEmpty())
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] { "top_up_details_missing_key" });
	    }
	    else
	    {
		for(IslamicCalculatorEventMgmtCO aIslamicCalculatorEventMgmtCO : islamicCalculatorEventMgmtCO
			.getTopUpGridList())
		{
		    if(ConstantsCommon.YES.equals(aIslamicCalculatorEventMgmtCO.getTopUpDealSelYN()))
		    {
			isDealSelected = true;
			break;
		    }
		}
	    }
	    if(!isDealSelected)
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] { "top_up_details_missing_key" });
	    }
	}
	else if(IISCommonConstants.BUYOUT.equals(StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getDealType())))
	{
	    if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBANK_CIF_NO())
		    .compareTo(BigDecimal.ZERO) == 0
		    || NumberUtil
			    .emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_CY())
			    .compareTo(BigDecimal.ZERO) == 0
		    || NumberUtil
			    .emptyDecimalToZero(
				    islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getBUY_OUT_DEAL_AMOUNT())
			    .compareTo(BigDecimal.ZERO) == 0)
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] { "buy_out_details_missing_key" });
	    }
	    if(NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_BR())
		    || NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_CY())
		    || NumberUtil
			    .isEmptyDecimal(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_CIF())
		    || NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_GL())
		    || NumberUtil
			    .isEmptyDecimal(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_SL()))
	    {
		throw new BOException(MessageCodes.INVALID_ACCOUNT);
	    }
	    AMFVO amfVo = new AMFVO();
	    amfVo.setCOMP_CODE(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getCompCode()));
	    amfVo.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_BR());
	    amfVo.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_CY());
	    amfVo.setGL_CODE(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_GL());
	    amfVo.setCIF_SUB_NO(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_CIF());
	    amfVo.setSL_NO(islamicCalculatorEventMgmtCO.getTrsBuyOutDealVO().getTRSFR_TO_ACC_SL());
	    amfVo = iisCommonBO.returnAccountByAccount(amfVo);
	    if(amfVo == null)
	    {
		throw new BOException(MessageCodes.INVALID_ACCOUNT);
	    }
	}
    }

    // BB160136; Saheer.Naduthodi; 20/04/2017
    @Override
    public IslamicCalculatorEventMgmtCO onChangeFlexiPaymentCheckBox(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getFlexiPaymentYn()))
	{
	    commonLibBO.applyDynScreenDisplay("flexi_month", null, "READONLY", BigDecimal.ZERO,
		    islamicCalculatorEventMgmtCO.getHmSysParam(), null);
	}
	else
	{
	    commonLibBO.applyDynScreenDisplay("flexi_month", null, "READONLY", BigDecimal.ONE,
		    islamicCalculatorEventMgmtCO.getHmSysParam(), null);
	}
	iisCommonBO.validateFlexiPayment(islamicCalculatorEventMgmtCO);
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating data based on no of balloons percentage
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeBalloonPercentage(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getBaloonPercentage() != null)
	{
	    double baloonPercentage = doubleValue(islamicCalculatorEventMgmtCO.getBaloonPercentage());
	    if(baloonPercentage < 0 || baloonPercentage > 100)
	    {
		throw new BOException(MessageCodes.PERCENTAGE_SHOULD_BE_BETWEEN_0_AND_100);
	    }
	    // TP#245168; Libin ; 03/12/2014 Added checking as its needed for
	    // performing next server call
	    if(NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getProductClass()))
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	    }
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOMain = iisIslamicCalculatorBO
		    .populateOnChangeProductClass(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCOMain != null)
	    {
		BigDecimal baloonAmountMaxPerc = islamicCalculatorEventMgmtCOMain.getBaloonAmountMaxPerc();
		BigDecimal baloonAmountMinPerc = islamicCalculatorEventMgmtCOMain.getBaloonAmountMinPerc();

		if(baloonPercentage > NumberUtil.toDouble(baloonAmountMaxPerc)
			&& NumberUtil.toDouble(baloonAmountMaxPerc) > 0)
		{
		    throw new BOException(MessageCodes.BALLON_PAYMENT_PERCENTAGE_MAX,
			    new String[] { StringUtil.nullToEmpty(baloonAmountMaxPerc) });

		}
		else if(baloonPercentage < NumberUtil.toDouble(baloonAmountMinPerc)
			&& NumberUtil.toDouble(baloonAmountMinPerc) > 0)
		{
		    throw new BOException(MessageCodes.BALLON_PAYMENT_PERCENTAGE_MIN,
			    new String[] { StringUtil.nullToEmpty(baloonAmountMinPerc) });
		}
		islamicCalculatorEventMgmtCO.setBaloonAmount(
			BigDecimal.valueOf(doubleValue(islamicCalculatorEventMgmtCO.getFinancingAmount())
				* doubleValue(islamicCalculatorEventMgmtCO.getBaloonPercentage()) / 100));
		islamicCalculatorEventMgmtCOMain = null;
	    }
	}
	if(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments() != null
		&& doubleValue(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments()) > 0
		&& islamicCalculatorEventMgmtCO.getBaloonAmount() != null
		&& doubleValue(islamicCalculatorEventMgmtCO.getBaloonAmount()) > 0
		&& islamicCalculatorEventMgmtCO.getBaloonPercentage() != null
		&& doubleValue(islamicCalculatorEventMgmtCO.getBaloonPercentage()) > 0)
	{
	    iisIslamicCalculatorBO.populateBaloonPaymentGrid(islamicCalculatorEventMgmtCO);
	}

	return islamicCalculatorEventMgmtCO;
    }

    public IslamicCalculatorEventMgmtCO printCalculateScreen(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {

	IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();
	iisctrlvoKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	iisctrlvoKey.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getBranchCode());
	IISCTRLVO iisctrl = iisCommonBO.returnIISCTRL(iisctrlvoKey);
	iisctrlvoKey = null;

	if(ConstantsCommon.NO.equals(iisctrl.getPRINT_CALC_DETAILS_YN()))
	{
	    TRSDEAL_CALC_VALUES_TEMPVO trsdealCalcValuesTempVO = new TRSDEAL_CALC_VALUES_TEMPVO();
	    trsdealCalcValuesTempVO.setKEY_ID(islamicCalculatorEventMgmtCO.getUserId());
	    trsdealCalcValuesTempVO.setTYPE("M016");
	    trsdealCalcValuesTempVO.setSL_NO(BigDecimal.ONE);

	    genericDAO.delete(trsdealCalcValuesTempVO);

	    trsdealCalcValuesTempVO.setADD_DATE1(islamicCalculatorEventMgmtCO.getStartDate());
	    trsdealCalcValuesTempVO.setADD_DATE2(islamicCalculatorEventMgmtCO.getFirstPaymentDate());

	    trsdealCalcValuesTempVO
		    .setADD_NUMBER1(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getPurchaseAmount()));
	    trsdealCalcValuesTempVO
		    .setADD_NUMBER2(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getSaleAmount()));
	    trsdealCalcValuesTempVO
		    .setADD_NUMBER3(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNoOfMonths()));
	    trsdealCalcValuesTempVO
		    .setADD_NUMBER4(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getDownPaymentAmount()));
	    trsdealCalcValuesTempVO
		    .setADD_NUMBER5(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNoOfPayments()));
	    trsdealCalcValuesTempVO
		    .setADD_NUMBER6(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getAmountPerPayment()));
	    trsdealCalcValuesTempVO
		    .setADD_NUMBER7(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getLastPaymentAmount()));
	    trsdealCalcValuesTempVO
		    .setADD_NUMBER8(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getProductClass()));
	    trsdealCalcValuesTempVO
		    .setADD_NUMBER9(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getProfit()));
	    BigDecimal dealCurrency = NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getCurrencyCode())
		    ? islamicCalculatorEventMgmtCO.getBaseCurrencyCode()
		    : islamicCalculatorEventMgmtCO.getCurrencyCode();
	    trsdealCalcValuesTempVO.setADD_NUMBER10(dealCurrency);

	    genericDAO.insert(trsdealCalcValuesTempVO);

	    List<ReportResponseCO> reportResponseCOList = new ArrayList<ReportResponseCO>();

	    String reportParams = StringUtil
		    .nullEmptyToValue(islamicCalculatorEventMgmtCO.getCompCode(), IISCommonConstants.BLANKSTRING)
		    .concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR)
		    .concat(StringUtil.nullEmptyToValue(islamicCalculatorEventMgmtCO.getUserId(),
			    IISCommonConstants.BLANKSTRING))
		    .concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR).concat(IISCommonConstants.BLANKSTRING)
		    .concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR)
		    .concat(StringUtil.nullEmptyToValue(islamicCalculatorEventMgmtCO.getBranchCode(),
			    IISCommonConstants.BLANKSTRING))
		    .concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR)
		    .concat(StringUtil.nullEmptyToValue(islamicCalculatorEventMgmtCO.getUserId(),
			    IISCommonConstants.BLANKSTRING))
		    .concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR).concat("M016")
		    .concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR).concat("1")
		    .concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR);

	    ReportResponseCO reportResponseCO = new ReportResponseCO();

	    reportResponseCO.setReportRef("M0165CP");
	    reportResponseCO.setAutoPrint(true);
	    reportResponseCO.setReportParams(reportParams);
	    reportResponseCOList.add(reportResponseCO);
	    islamicCalculatorEventMgmtCO.setReportResponseCOList(reportResponseCOList);

	}
	return islamicCalculatorEventMgmtCO;
    }

	@Override
	public IslamicCalculatorEventMgmtCO checkYieldGreaterThanTieRate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
			throws BaseException {
		BigDecimal totalYield = NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getAnnualYieldRate());
		iisCommonBO.checkTotalYieldWithTieRate(islamicCalculatorEventMgmtCO.getCompCode(),islamicCalculatorEventMgmtCO.getBranchCode(),
		islamicCalculatorEventMgmtCO.getProductClass(), totalYield,islamicCalculatorEventMgmtCO.getTrsdealVO().getMINIMUM_YIELD() ,
		islamicCalculatorEventMgmtCO.getStartDate(), islamicCalculatorEventMgmtCO );
//// throw new BOException(MessageCodes.COUNTER_PARTY_STATUS_BLACK_LISTED_PARAM, ConstantsCommon.CONFIRM_MSG_TYPE,
////		    "CHECK_BLACK_LISTED_CIF", investmentDealsCO);
	return islamicCalculatorEventMgmtCO;
	}

	@Override
	public IslamicCalculatorEventMgmtCO onchangeBlackListRestrictionReasonCode(	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)throws BaseException  
	{
		CTSREASONSVO ctsreasonsvo = new  CTSREASONSVO();
		ctsreasonsvo.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
		ctsreasonsvo.setCODE(islamicCalculatorEventMgmtCO.getReasonCode());
		
		ctsreasonsvo = (CTSREASONSVO) genericDAO.selectByPK(ctsreasonsvo);
		if(ctsreasonsvo == null){
			throw new BOException(MessageCodes.iis_invalid_code,
				    new String[] { "missing_invalid_reason_code_key" }, false);
		}else{
			islamicCalculatorEventMgmtCO.setReasonDesc(ctsreasonsvo.getBRIEF_NAME_ENG());
		}
		return islamicCalculatorEventMgmtCO;
	}

	
}
