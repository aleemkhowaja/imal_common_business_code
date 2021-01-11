package com.path.vo.common.iis.islamiccalculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.CTS_SAFEBOX_TRXVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.TRSDEAL2VO;
import com.path.dbmaps.vo.TRSDEAL3VO;
import com.path.dbmaps.vo.TRSDEALCHARGESVO;
import com.path.dbmaps.vo.TRSDEALCHARGES_CALCULATORVO;
import com.path.dbmaps.vo.TRSDEALVO;
import com.path.dbmaps.vo.TRSDEAL_BALLOON_CALCVO;
import com.path.dbmaps.vo.TRSDEAL_NIDCVO;
import com.path.dbmaps.vo.TRSDEAL_NIDC_COUPON_PYMNTVO;
import com.path.dbmaps.vo.TRSDEAL_NIDC_DETVO;
import com.path.dbmaps.vo.TRSPAYPLANDETVO;
import com.path.dbmaps.vo.TRSPAYPLAN_BREAKUP_PROFITVO;
import com.path.dbmaps.vo.TRSPAYPLAN_CALCULATORVO;
import com.path.dbmaps.vo.TRSPAYPLAN_CRITERIAVO;
import com.path.dbmaps.vo.TRSPAYPLAN_CRITERIA_CALCVO;
import com.path.dbmaps.vo.TRSPAYPLAN_CRITERIA_TENTATIVEVO;
import com.path.dbmaps.vo.TRSPAYPLAN_CRITERIA_TENT_CALCVO;
import com.path.dbmaps.vo.TRSPAYPLAN_NIDC_COUPON_PYMVO;
import com.path.dbmaps.vo.TRSPAYPLAN_NIDC_DET_CALCVO;
import com.path.dbmaps.vo.TRS_BUY_OUT_DEALVO;
import com.path.dbmaps.vo.TRS_PROJECT_SCHEDULE_CALCVO;
import com.path.dbmaps.vo.TRS_TOP_UP_DEALVO;
import com.path.dbmaps.vo.TRS_TOP_UP_DEAL_DETVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.core.iisitems.ItemsCO;

public class IslamicCalculatorEventMgmtCO extends BaseVO implements Serializable
{

    private String appName;
    private String cifName;
    private String idNo;
    private String calculatorLanguage;
    private String longOrShortNameDesc;
    private String initialPaymentType;
    private String minimumSecurityDepositType;
    private String maintainSalaryAccount;
    private String paymPeriodPos;
    private String payResAmt;
    private String paymPeriodicity;
    private String gracePeriodicity;
    private String principalLast = "N";
    private String calculateProfit;
    private String profitDistMethod;
    private String roundingTypeRepayAmt;
    private String roundingTypeInstAmt;
    private String accrualAmountType;
    private String multipleDivisionIndicator;
    private String productClassName;
    private String tenureDesc;
    private String floatingRateCodeDesc;
    private String profitCalcMethod;
    private String profitRecognitionMethod;
    private String facilityTypeDesc;
    private String tempCodeDesc;
    private String vatDesc;
    private String currencyDesc;
    private String salaryWithBank;
    private String status;
    private String callType;
    private BigDecimal baloonAmountMaxPerc;
    private BigDecimal baloonAmountMinPerc;
    private String prefferedLanguage;
    private BigDecimal totalInsuranceAmt;
    // for memo
    private MemoSC memoSC;

    private String partyType;
    private String entityType;
    private String paymentType;
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal cifNo;
    private BigDecimal downPaymentAmount;
    private BigDecimal purchaseAmount;
    private BigDecimal productClass;
    private BigDecimal minimumSecurityDepositAmount;
    private BigDecimal financingAmount;
    private BigDecimal downPaymentPercentage;
    private BigDecimal totalFlatRate;
    private BigDecimal yield;
    private BigDecimal amountPerPayment;
    private BigDecimal noOfBaloonPayments;
    private BigDecimal baloonAmount;
    private BigDecimal baloonPercentage;
    private BigDecimal noOfPayments;
    private BigDecimal vatCode;
    private BigDecimal vatPercentage;
    private BigDecimal gracePeriod;
    private BigDecimal roundingFactor;
    private BigDecimal paymPeriodNbr;
    private BigDecimal gracePeriodOption;
    private BigDecimal repaymentTemplate;
    private BigDecimal accrualBasis;
    private BigDecimal maxDealInstPercOfSal;
    private BigDecimal currencyUnit;
    private BigDecimal income;
    private BigDecimal approvedSalary;
    private BigDecimal debtBurdanRatio;
    private BigDecimal annualYieldRate;
    private BigDecimal currencyCode;
    private BigDecimal advancePayment;
    private BigDecimal tenureCode;
    private BigDecimal margin;
    private BigDecimal floatingRateCode;
    private BigDecimal floatingRate;
    private BigDecimal annualFlatRate;
    private BigDecimal facilityTypeCode;
    private BigDecimal tempCode;
    private BigDecimal noOfMonths;
    private BigDecimal saleAmount;
    private BigDecimal profit;
    private BigDecimal xirr;
    private BigDecimal xirrWithCharges;
    private BigDecimal nidcDealCount;
    private BigDecimal holidayAction;
    private BigDecimal remainingAmount;
    private BigDecimal rosterRegisterCode;
    private BigDecimal rosterCodeyield;
    private BigDecimal rosterCodeModarib;
    private BigDecimal rosterLineno;
    private BigDecimal rosterNoOfPayments;
    private BigDecimal yieldAmendRangeFrom;
    private BigDecimal yieldAmendRangeTo;
    private BigDecimal classCode;
    private Date startDate;
    private Date maturityDate;
    private String calendarType;
    private Date firstPaymentDate;
    private Date fromDate;
    private Date toDate;
    private Date runningDate;
    private Date serverDate;
    private String userId;
    private Date defaultMaturityDate;
    private Date valueDate;
    private BigDecimal dealNo;
    private BigDecimal dealAmount;
    private BigDecimal rosterEntityCode;
    private BigDecimal rosterDealAmount;
    private BigDecimal orginalYield;
    private BigDecimal allocatedDealAmount;
    private BigDecimal capitalDealAmount;
    private BigDecimal sumOfCapitalAmtRepayment;
    private BigDecimal baloonpayment;
    private BigDecimal totalYield;
    private BigDecimal iborRatePeriodicity;
    private String iborRatePeriodicityType;
    private String firstPayDateHijri;
    private BigDecimal limitSerialNo;
    private String limitAccDesc;
    private BigDecimal ACC_BRANCH;
    private BigDecimal ACC_CURRENCY;
    private BigDecimal ACC_GL_CODE;
    private BigDecimal ACC_CIF_NO;
    private BigDecimal ACC_SL_NO;
    private String ADDITIONAL_REFERENCE;
    private String ACCOUNT_NAME;
    private BigDecimal drawDownCode;
    private BigDecimal drawDownBranch;
    private BigDecimal projectAmount;
    // IISCTRL for handling visibility and read only
    private String allowEditFinanceCyInCalc;
    private String allowEditYieldInCalc;
    private String allowProfitRecoInCalc;
    private String allowToEditProfitDistMthd;
    private String calcDbrCalculationReqdYn;
    private String calcDisableStartDate;
    private String showCifIncome;
    private String calcShowCifIncomeInd;
    private String showYieldInCalc;
    private String vatApplicable;
    private String includeVatinInstallment;
    private String allowtoEditVat;
    private String showVat;
    private String cyFormat;
    // IISCTRL for handling read only
    private Boolean calcDisableStartDateReadOnly = false;
    private Boolean allowProfitRecoInCalcReadOnly = true;
    private Boolean allowEditYieldInCalcReadOnly = true;
    private Boolean allowToEditProfitDistMthdReadOnly = true;
    private Boolean allowEditFinanceCyInCalcReadOnly = true;
    private Boolean checkDefaultMaturityDate = false;
    private Boolean enable = false;
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hmSysParam = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    private BigDecimal gracePeriodActual;
    private String gracePeriodicityActual;
    private BigDecimal planNbr;
    private BigDecimal firstYrProfit;
    private BigDecimal lastPaymentAmount;
    private String islamicCalcDecimalFormatPrint;
    private String baseCurrencyDesc;
    private String globalConfirmationFrom;

    // sankar; for AR- rahnu
    private BigDecimal quantity;
    private String safeboxchargetype;
    private BigDecimal financing_perc;
    private String calculatorType;
    private BigDecimal localCIFNo;
    private BigDecimal safeboxchargeamt;
    private BigDecimal safeboxchargeamt_1;
    private BigDecimal safeboxchargeamt_2;
    private CTS_SAFEBOX_TRXVO ctsSafeboxTrxVO;
    /*
     * For added AR-Ranhu calculator
     */
    private List<ItemsCO> itemsCOList;
    private BigDecimal safeboxno;
    private String remarks;
    private BigDecimal totalAmount;
    private BigDecimal insurance_charge;
    private BigDecimal insurance_charge_1;
    private BigDecimal insurance_charge_2;

    /**
     * For Bills Calculator
     * 
     * @return
     */

    private String tradingCurrencyDesc;
    private String tfaTrxType;
    private BigDecimal tfaDiscountingMargin;
    private BigDecimal tfaTrsAmount;
    private BigDecimal tradingCurrency;
    private BigDecimal crossRate;
    private BigDecimal tradingBillAmount;
    private BigDecimal noOfBills;
    private BigDecimal totalTradingBillAmount;
    private BigDecimal billAmount;
    private BigDecimal totalBillAmount;
    // private BigDecimal netPresentValue;// financingAmount
    // private BigDecimal marginRate;//
    // private BigDecimal globalRate;//
    // private BigDecimal annualDiascount;//
    // private BigDecimal profitCalcuMethod;// *
    // private BigDecimal commision;//
    private BigDecimal tfaBillAmount;
    private String interestCalculationMethod;
    private BigDecimal price;
    private BigDecimal portfolio_cif;
    private BigDecimal portfolio_seq;
    private String portfolio_name;
    private BigDecimal BROKER_CODE;
    private String BROKER_NAME;
    private String nidc;
    private String bills_yn;
    private String abiDeal;
    private BigDecimal lcYear;
    private BigDecimal lcNbr;
    private BigDecimal facilityNbr;
    private BigDecimal facilityBranch;
    private BigDecimal facilitySubNo;
    private BigDecimal facilitySubLineNbr;

    // Hari.K.S 24/04/2020
    private BigDecimal facilityDrowdown;
    private String drawDownDiscription;

    private BigDecimal lcAmount;
    private BigDecimal lcCurrency;
    private BigDecimal currency;// ---remove
    private BigDecimal inWardOutWradTrsNo;//
    private BigDecimal unutilizedFacilityAmt;
    private String priceUserTypedYN;
    private BigDecimal dealNidc;
    private String hideRateYn;
    private BigDecimal periodicityNbr;
    private BigDecimal defaultedFloatingRate;
    private List<TRSDEAL_NIDC_COUPON_PYMNTVO> trsdealNIDCCoupPaymtVOList;
    private List<TRSDEAL_NIDC_DETVO> trsdealNIDCDETVOList;
    private TRSDEAL_NIDCVO trsdealNIDCVO;
    private String columnName;
    private String mode;

    private String gridsize;
    private String periodicityType;
    private String tfaLinkYn = "N";
    private List linkTypeList = new ArrayList<SelectCO>();
    private TRSPAYPLAN_CALCULATORVO trsPayPlanCalculatorVO;
    private List<TRSDEALCHARGES_CALCULATORVO> trsdealChargesCalculatorVOlist;
    private List<TRSPAYPLAN_CRITERIA_CALCVO> trsPayplanCriteriaVOlist;
    private List<TRSDEAL_BALLOON_CALCVO> trsDealBalloonCalcVOlist;

    /***
     * for calaulator enhancement
     */
    private List<TRS_PROJECT_SCHEDULE_CALCVO> trsProjectScheduleCalcVOList;
    private List<TRSPAYPLAN_CRITERIA_TENT_CALCVO> criteriaTentativeCalcVOList;
    private List<HedgeCalcContributorCO> hedgeCalcCOList;
    private String eodProductClassName;
    private BigDecimal eodLentAmount;
    private BigDecimal cfTfValue;
    private BigDecimal cfMaturityAmount;
    private BigDecimal cfProfitFx;
    private BigDecimal cfProftAct;
    private BigDecimal cfEffYield;
    private String accrualBasisDesc;

    private List<TrsdealCustGuarLiabilitiesListCO> trsdealCustGuarLiabilitiesListCO;

    private List<TRSPAYPLAN_BREAKUP_PROFITVO> trspayplan_BREAKUP_PROFITVs = new ArrayList<TRSPAYPLAN_BREAKUP_PROFITVO>();

    private BigDecimal faceValue;
    private String issueType;
    private String couponPaymentType;
    private List<TRSPAYPLAN_NIDC_DET_CALCVO> trspaypalnNIDCdetVOList;
    private List<TRSPAYPLAN_NIDC_COUPON_PYMVO> trspaypalnNIDCCoupPaymtVOList;
    private BigDecimal noofCertificates;
    private BigDecimal refNo;
    private TrsdealNidcCO trsdealNidcCO;

    /** TP# 222800 BM140006 - Limit for Yield Roster in IIS Sreejith */
    private List<String> informationMessageList = new ArrayList<String>();
    // LOS integration; Saheer.Naduthodi; 13/12/2017 [Begin]
    private String calledFrom;
    private LOSmessagesCO losMessagesCO;
    private List<LOSmessagesCO> losMessagesCOList;
    private String flexiPaymentYn = "N";
    private BigDecimal flexiPaymentsMonth;
    private BigDecimal repaymentCriteriaRowCount;
    private String allowFlexiPaymentsYN;
    // LOS integration; Saheer.Naduthodi; 13/12/2017 [End]
    // BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619
    private String dealType;
    private TRS_TOP_UP_DEAL_DETVO trsTopUpDealDetVO = new TRS_TOP_UP_DEAL_DETVO();
    private TRS_TOP_UP_DEALVO trsTopUpDealVO = new TRS_TOP_UP_DEALVO();
    private BigDecimal outstandingPrnicipal;
    private BigDecimal outstandingInstallment;
    private Date dealDate;
    private BigDecimal dealCY;
    private String topUpDealSelYN;
    private BigDecimal transactioNo;
    private List<IslamicCalculatorEventMgmtCO> topUpGridList;
    private BigDecimal netCreditToCustomer;
    private TRS_BUY_OUT_DEALVO trsBuyOutDealVO = new TRS_BUY_OUT_DEALVO();
    private String newDealCYDesc;
    private String topUpGridData;
    private String topUpJasonData;
    private String reloadflag;
    private BigDecimal outStandingTopUpCy;
    private TRSDEALVO trsdealVO;
    private TRSDEAL2VO trsdeal2VO;

    // 625903 deepu
    private String APPLY_FIX_RATE;
    private String IBOR_PERIODICITY_TYPE_OLD;
    private BigDecimal IBOR_PERIODICITY_NUMBER_OLD;
    private BigDecimal totalExstInstAmt;

    private String calledByJSTriggerYN = ConstantsCommon.NO;

    private BigDecimal tradeDealNo;
    private List<ReportResponseCO> reportResponseCOList = new ArrayList<ReportResponseCO>();
//TP 795449 Srikumar
    private Date newDate;

    private String APPLY_TEG_YN;
    private BigDecimal teg;
    private String exemptedFromVatYn;
    private BigDecimal vatExemptionCertificateNo;
    private Date vatExemptionExpiryDate;
    // SBI170098 - PMYBL Product
    private BigDecimal customerRate;
    private BigDecimal govtRate;
    
    //928504 MFI190194  deepu 13/01/2020
    private BigDecimal	aprRate;
    
    private String[] params;
    private BigDecimal reasonCode;
    private String reasonDesc;
    private String crud;
    private String errorType;
    private String  errorDescription;
    private BigDecimal errorCode;
    /**
   	 * Added By Manoj On 01/02/2017 For - BMO160011
   	 */
    protected String cifBlackListRestrictionBriefDescription;
    protected BigDecimal cifBlackListRestrictionSourceCode;
    protected String validateBlackListRestriction = "Y";
    protected CifBlackListRestrictCO cifBlackListRestrictCO;
    private ReportResponseCO reportResponseCO;
	
	// TP#1022246 BAJI200012 Fawas.kuruvakkottil 10/07/2020
    private BigDecimal downPaymentToVendor;
    private BigDecimal downPaymentToVendorPerc;
    private BigDecimal totalDownPayment;
    private BigDecimal totalDownPaymentPerc;

    /**
     * @return the informationMessageList
     */
    public List<String> getInformationMessageList()
    {
	return informationMessageList;
    }

    /**
     * @param informationMessageList the informationMessageList to set
     */
    public void setInformationMessageList(List<String> informationMessageList)
    {
	this.informationMessageList = informationMessageList;
    }

    public BigDecimal getLocalCIFNo()
    {
	return localCIFNo;
    }

    public void setLocalCIFNo(BigDecimal localCIFNo)
    {
	this.localCIFNo = localCIFNo;
    }

    public BigDecimal getFinancing_perc()
    {
	return financing_perc;
    }

    public void setFinancing_perc(BigDecimal financingPerc)
    {
	financing_perc = financingPerc;
    }

    public BigDecimal getQuantity()
    {
	return quantity;
    }

    public void setQuantity(BigDecimal quantity)
    {
	this.quantity = quantity;
    }

    public String getSafeboxchargetype()
    {
	return safeboxchargetype;
    }

    public void setSafeboxchargetype(String safeboxchargetype)
    {
	this.safeboxchargetype = safeboxchargetype;
    }

    // BB130272 Modification;Ravikant.Singh;19/05/2015
    private boolean showCustGuarLiability;
    private List<IslamicCalculatorCustGuarLiabilitiesListCO> custGuarLiabilityList = new ArrayList<IslamicCalculatorCustGuarLiabilitiesListCO>();

    // TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement and reschedule
    // Charges
    private List<TrsDealSettlementChargesCO> trsDealSettlementChargesCO = new ArrayList<TrsDealSettlementChargesCO>();

    public String getIslamicCalcDecimalFormatPrint()
    {
	return islamicCalcDecimalFormatPrint;
    }

    public void setIslamicCalcDecimalFormatPrint(String islamicCalcDecimalFormatPrint)
    {
	this.islamicCalcDecimalFormatPrint = islamicCalcDecimalFormatPrint;
    }

    public BigDecimal getLastPaymentAmount()
    {
	return lastPaymentAmount;
    }

    public void setLastPaymentAmount(BigDecimal lastPaymentAmount)
    {
	this.lastPaymentAmount = lastPaymentAmount;
    }

    public BigDecimal getFirstYrProfit()
    {
	return firstYrProfit;
    }

    public void setFirstYrProfit(BigDecimal firstYrProfit)
    {
	this.firstYrProfit = firstYrProfit;
    }

    public BigDecimal getPlanNbr()
    {
	return planNbr;
    }

    public void setPlanNbr(BigDecimal planNbr)
    {
	this.planNbr = planNbr;
    }

    private Date repaymentCriteriaFirstRowDate;
    // TP#225275;Arun.R.Variyath;27/09/2014
    private int dateMonth;
    private int dateYear;
    private String FLOATING_RATE;
    private String repaymentCriteriaYieldYn = "N";
    private String dealUpdateYN = "N";

    public String getDealUpdateYN()
    {
	return dealUpdateYN;
    }

    public void setDealUpdateYN(String dealUpdateYN)
    {
	this.dealUpdateYN = dealUpdateYN;
    }

    public String getRepaymentCriteriaYieldYn()
    {
	return repaymentCriteriaYieldYn;
    }

    public void setRepaymentCriteriaYieldYn(String repaymentCriteriaYieldYn)
    {
	this.repaymentCriteriaYieldYn = repaymentCriteriaYieldYn;
    }

    public String getFLOATING_RATE()
    {
	return FLOATING_RATE;
    }

    public void setFLOATING_RATE(String fLOATINGRATE)
    {
	FLOATING_RATE = fLOATINGRATE;
    }

    // TP#232892;Arun.R.Variyath;21/10/2014
    private List<TrsdealMultipleYieldCO> trsdealMultipleYieldCOList;

    // TP# 232771;deepu.mohandas 28/10/2014
    private String printCalcDetailScheduleYN;
    private String printCalcDetailYN;

    public String getCalcShowCifIncomeInd()
    {
	return calcShowCifIncomeInd;
    }

    public void setCalcShowCifIncomeInd(String calcShowCifIncomeInd)
    {
	this.calcShowCifIncomeInd = calcShowCifIncomeInd;
    }

    public Boolean getEnable()
    {
	return enable;
    }

    public void setEnable(Boolean enable)
    {
	this.enable = enable;
    }

    private List<TrsDealChargesCO> trsDealChargesVO;
    private List<TrspayplandetCO> islamicCalculatorScheduleList;
    private List<TrsPlanBallonPaymentCO> balloonDetailsList;
    private List<TRSPAYPLAN_CRITERIAVO> trsPayplanCriteriaVO;
    private List<TRSDEALCHARGESVO> trsDealChargesVOList;
    private List<TRSPAYPLANDETVO> trsPayPlandetVOList;
    private List<TRSDEAL3VO> trsDealMultipleDisbursementList;
    private TRSDEAL3VO trsdeal3vo;
    private List<TRSPAYPLANDETVO> trspayplanTentativeScheduledet = new ArrayList<TRSPAYPLANDETVO>();
    private List<TRSPAYPLAN_CRITERIA_TENTATIVEVO> trspayplanCRITERIATENTATIVEVOs = new ArrayList<TRSPAYPLAN_CRITERIA_TENTATIVEVO>();

    // DBR
    private String showCifIncomeInd;
    private BigDecimal lineNo;
    private Date commencementDate;
    private long productClassCount;

    private BigDecimal currencyDecimalPointsForCalc;
    private BigDecimal currencyDecimalPoints;
    private BigDecimal financingCurrency;
    private String confirmationMessageId;
    private Boolean confirmationResult;
    private String eventType;
    private String profitUpfront = "N";
    private BigDecimal category;
    private TRSPAYPLAN_CRITERIAVO trsPayplanCriteriaVOObject = new TRSPAYPLAN_CRITERIAVO();
    private TrsPlanBallonPaymentCO ballonPaymentCO = new TrsPlanBallonPaymentCO();

    private Date maturityDateAfterHoliday;
    private Date startDateAfterHoliday;

    private String vatIcludedInInstallement;
    private String dealPeriodCompounding;
    private String yieldRequired;

    private String disableBtnAfterCalc;

    private String yieldFlag;
    private String confirmMessageDetailId;
    private String secondConfirmId;

    private BigDecimal ACTIVE_DEAL_COUNT;
    private BigDecimal APPROVE_DEAL_COUNT;
    private BigDecimal DELETE_DEAL_COUNT;
    private BigDecimal REVERSE_DEAL_COUNT;
    private BigDecimal REJECT_DEAL_COUNT;
    private String existingDealStatusMessage;
    private String pageRef = "";
    private BigDecimal linkType;
    private String rescheduleCalcYN = "N";
    private List<String[]> confirmMessagesArryList = new ArrayList<String[]>();
    private BigDecimal chargeAmount;
    // TP# 234177;deepu.mohandas 24/10/2014
    private String showPaySchedule;

    // TP#247336;Arun.R.Variyath;10/12/2014 [Start]
    private BigDecimal contractPrice;
    private BigDecimal discountPerc;
    private String discountCalMethod;
    private String musawamahYN;
    private String[] paramList;

    // TP#247336;Arun.R.Variyath;10/12/2014

    public BigDecimal getACTIVE_DEAL_COUNT()
    {
	return ACTIVE_DEAL_COUNT;
    }

    public void setACTIVE_DEAL_COUNT(BigDecimal aCTIVEDEALCOUNT)
    {
	ACTIVE_DEAL_COUNT = aCTIVEDEALCOUNT;
    }

    public BigDecimal getAPPROVE_DEAL_COUNT()
    {
	return APPROVE_DEAL_COUNT;
    }

    public void setAPPROVE_DEAL_COUNT(BigDecimal aPPROVEDEALCOUNT)
    {
	APPROVE_DEAL_COUNT = aPPROVEDEALCOUNT;
    }

    public BigDecimal getDELETE_DEAL_COUNT()
    {
	return DELETE_DEAL_COUNT;
    }

    public void setDELETE_DEAL_COUNT(BigDecimal dELETEDEALCOUNT)
    {
	DELETE_DEAL_COUNT = dELETEDEALCOUNT;
    }

    public BigDecimal getREVERSE_DEAL_COUNT()
    {
	return REVERSE_DEAL_COUNT;
    }

    public void setREVERSE_DEAL_COUNT(BigDecimal rEVERSEDEALCOUNT)
    {
	REVERSE_DEAL_COUNT = rEVERSEDEALCOUNT;
    }

    public BigDecimal getREJECT_DEAL_COUNT()
    {
	return REJECT_DEAL_COUNT;
    }

    public void setREJECT_DEAL_COUNT(BigDecimal rEJECTDEALCOUNT)
    {
	REJECT_DEAL_COUNT = rEJECTDEALCOUNT;
    }

    public String getExistingDealStatusMessage()
    {
	return existingDealStatusMessage;
    }

    public void setExistingDealStatusMessage(String existingDealStatusMessage)
    {
	this.existingDealStatusMessage = existingDealStatusMessage;
    }

    public String getSecondConfirmId()
    {
	return secondConfirmId;
    }

    public void setSecondConfirmId(String secondConfirmId)
    {
	this.secondConfirmId = secondConfirmId;
    }

    public BigDecimal getFinancingCurrency()
    {
	return financingCurrency;
    }

    public void setFinancingCurrency(BigDecimal financingCurrency)
    {
	this.financingCurrency = financingCurrency;
    }

    public Date getCommencementDate()
    {
	return commencementDate;
    }

    public void setCommencementDate(Date commencementDate)
    {
	this.commencementDate = commencementDate;
    }

    public long getProductClassCount()
    {
	return productClassCount;
    }

    public void setProductClassCount(long productClassCount)
    {
	this.productClassCount = productClassCount;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public String getAppName()
    {
	return appName;
    }

    public String getCifName()
    {
	return cifName;
    }

    public String getIdNo()
    {
	return idNo;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public String getCalculatorLanguage()
    {
	return calculatorLanguage;
    }

    public String getLongOrShortNameDesc()
    {
	return longOrShortNameDesc;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public BigDecimal getDownPaymentAmount()
    {
	return downPaymentAmount;
    }

    public BigDecimal getPurchaseAmount()
    {
	return purchaseAmount;
    }

    public BigDecimal getProductClass()
    {
	return productClass;
    }

    public String getInitialPaymentType()
    {
	return initialPaymentType;
    }

    public String getMinimumSecurityDepositType()
    {
	return minimumSecurityDepositType;
    }

    public BigDecimal getMinimumSecurityDepositAmount()
    {
	return minimumSecurityDepositAmount;
    }

    public BigDecimal getFinancingAmount()
    {
	return financingAmount;
    }

    public BigDecimal getDownPaymentPercentage()
    {
	return downPaymentPercentage;
    }

    public BigDecimal getTotalFlatRate()
    {
	return totalFlatRate;
    }

    public BigDecimal getYield()
    {
	return yield;
    }

    public BigDecimal getAmountPerPayment()
    {
	return amountPerPayment;
    }

    public Date getStartDate()
    {
	return startDate;
    }

    public Date getMaturityDate()
    {
	return maturityDate;
    }

    public BigDecimal getBaloonAmount()
    {
	return baloonAmount;
    }

    public BigDecimal getBaloonPercentage()
    {
	return baloonPercentage;
    }

    public BigDecimal getNoOfPayments()
    {
	return noOfPayments;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public void setCifName(String cifName)
    {
	this.cifName = cifName;
    }

    public void setIdNo(String idNo)
    {
	this.idNo = idNo;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public void setCalculatorLanguage(String calculatorLanguage)
    {
	this.calculatorLanguage = calculatorLanguage;
    }

    public void setLongOrShortNameDesc(String longOrShortNameDesc)
    {
	this.longOrShortNameDesc = longOrShortNameDesc;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public void setDownPaymentAmount(BigDecimal downPaymentAmount)
    {
	this.downPaymentAmount = downPaymentAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount)
    {
	this.purchaseAmount = purchaseAmount;
    }

    public void setProductClass(BigDecimal productClass)
    {
	this.productClass = productClass;
    }

    public void setInitialPaymentType(String initialPaymentType)
    {
	this.initialPaymentType = initialPaymentType;
    }

    public void setMinimumSecurityDepositType(String minimumSecurityDepositType)
    {
	this.minimumSecurityDepositType = minimumSecurityDepositType;
    }

    public void setMinimumSecurityDepositAmount(BigDecimal minimumSecurityDepositAmount)
    {
	this.minimumSecurityDepositAmount = minimumSecurityDepositAmount;
    }

    public void setFinancingAmount(BigDecimal financingAmount)
    {
	this.financingAmount = financingAmount;
    }

    public void setDownPaymentPercentage(BigDecimal downPaymentPercentage)
    {
	this.downPaymentPercentage = downPaymentPercentage;
    }

    public void setTotalFlatRate(BigDecimal totalFlatRate)
    {
	this.totalFlatRate = totalFlatRate;
    }

    public void setYield(BigDecimal yield)
    {
	this.yield = yield;
    }

    public void setAmountPerPayment(BigDecimal amountPerPayment)
    {
	this.amountPerPayment = amountPerPayment;
    }

    public void setStartDate(Date startDate)
    {
	this.startDate = startDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
	this.maturityDate = maturityDate;
    }

    public void setBaloonAmount(BigDecimal baloonAmount)
    {
	this.baloonAmount = baloonAmount;
    }

    public void setBaloonPercentage(BigDecimal baloonPercentage)
    {
	this.baloonPercentage = baloonPercentage;
    }

    public void setNoOfPayments(BigDecimal noOfPayments)
    {
	this.noOfPayments = noOfPayments;
    }

    public BigDecimal getNoOfBaloonPayments()
    {
	return noOfBaloonPayments;
    }

    public void setNoOfBaloonPayments(BigDecimal noOfBaloonPayments)
    {
	this.noOfBaloonPayments = noOfBaloonPayments;
    }

    public String getMaintainSalaryAccount()
    {
	return maintainSalaryAccount;
    }

    public void setMaintainSalaryAccount(String maintainSalaryAccount)
    {
	this.maintainSalaryAccount = maintainSalaryAccount;
    }

    /**
     * @return the vatCode
     */
    public BigDecimal getVatCode()
    {
	return vatCode;
    }

    /**
     * @param vatCode the vatCode to set
     */
    public void setVatCode(BigDecimal vatCode)
    {
	this.vatCode = vatCode;
    }

    /**
     * @return the fromDate
     */
    public Date getFromDate()
    {
	return fromDate;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(Date fromDate)
    {
	this.fromDate = fromDate;
    }

    /**
     * @return the vatPercentage
     */
    public BigDecimal getVatPercentage()
    {
	return vatPercentage;
    }

    /**
     * @param vatPercentage the vatPercentage to set
     */
    public void setVatPercentage(BigDecimal vatPercentage)
    {
	this.vatPercentage = vatPercentage;
    }

    /**
     * @return the firstPaymentDate
     */
    public Date getFirstPaymentDate()
    {
	return firstPaymentDate;
    }

    /**
     * @param firstPaymentDate the firstPaymentDate to set
     */
    public void setFirstPaymentDate(Date firstPaymentDate)
    {
	this.firstPaymentDate = firstPaymentDate;
    }

    /**
     * @return the paymPeriodPos
     */
    public String getPaymPeriodPos()
    {
	return paymPeriodPos;
    }

    /**
     * @param paymPeriodPos the paymPeriodPos to set
     */
    public void setPaymPeriodPos(String paymPeriodPos)
    {
	this.paymPeriodPos = paymPeriodPos;
    }

    public BigDecimal getRoundingFactor()
    {
	return roundingFactor;
    }

    public void setRoundingFactor(BigDecimal roundingFactor)
    {
	this.roundingFactor = roundingFactor;
    }

    public String getPayResAmt()
    {
	return payResAmt;
    }

    public void setPayResAmt(String payResAmt)
    {
	this.payResAmt = payResAmt;
    }

    public BigDecimal getPaymPeriodNbr()
    {
	return paymPeriodNbr;
    }

    public void setPaymPeriodNbr(BigDecimal paymPeriodNbr)
    {
	this.paymPeriodNbr = paymPeriodNbr;
    }

    public String getPaymPeriodicity()
    {
	return paymPeriodicity;
    }

    public void setPaymPeriodicity(String paymPeriodicity)
    {
	this.paymPeriodicity = paymPeriodicity;
    }

    public BigDecimal getGracePeriodOption()
    {
	return gracePeriodOption;
    }

    public void setGracePeriodOption(BigDecimal gracePeriodOption)
    {
	this.gracePeriodOption = gracePeriodOption;
    }

    public BigDecimal getGracePeriod()
    {
	return gracePeriod;
    }

    public void setGracePeriod(BigDecimal gracePeriod)
    {
	this.gracePeriod = gracePeriod;
    }

    public String getGracePeriodicity()
    {
	return gracePeriodicity;
    }

    public void setGracePeriodicity(String gracePeriodicity)
    {
	this.gracePeriodicity = gracePeriodicity;
    }

    public String getPrincipalLast()
    {
	return principalLast;
    }

    public void setPrincipalLast(String principalLast)
    {
	this.principalLast = principalLast;
    }

    public BigDecimal getRepaymentTemplate()
    {
	return repaymentTemplate;
    }

    public void setRepaymentTemplate(BigDecimal repaymentTemplate)
    {
	this.repaymentTemplate = repaymentTemplate;
    }

    public String getCalculateProfit()
    {
	return calculateProfit;
    }

    public void setCalculateProfit(String calculateProfit)
    {
	this.calculateProfit = calculateProfit;
    }

    public String getProfitDistMethod()
    {
	return profitDistMethod;
    }

    public void setProfitDistMethod(String profitDistMethod)
    {
	this.profitDistMethod = profitDistMethod;
    }

    public BigDecimal getAccrualBasis()
    {
	return accrualBasis;
    }

    public void setAccrualBasis(BigDecimal accrualBasis)
    {
	this.accrualBasis = accrualBasis;
    }

    public BigDecimal getMaxDealInstPercOfSal()
    {
	return maxDealInstPercOfSal;
    }

    public void setMaxDealInstPercOfSal(BigDecimal maxDealInstPercOfSal)
    {
	this.maxDealInstPercOfSal = maxDealInstPercOfSal;
    }

    public String getRoundingTypeRepayAmt()
    {
	return roundingTypeRepayAmt;
    }

    public void setRoundingTypeRepayAmt(String roundingTypeRepayAmt)
    {
	this.roundingTypeRepayAmt = roundingTypeRepayAmt;
    }

    public String getRoundingTypeInstAmt()
    {
	return roundingTypeInstAmt;
    }

    public void setRoundingTypeInstAmt(String roundingTypeInstAmt)
    {
	this.roundingTypeInstAmt = roundingTypeInstAmt;
    }

    public String getAccrualAmountType()
    {
	return accrualAmountType;
    }

    public void setAccrualAmountType(String accrualAmountType)
    {
	this.accrualAmountType = accrualAmountType;
    }

    public Date getRunningDate()
    {
	return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public Date getServerDate()
    {
	return serverDate;
    }

    public void setServerDate(Date serverDate)
    {
	this.serverDate = serverDate;
    }

    public BigDecimal getCurrencyUnit()
    {
	return currencyUnit;
    }

    public void setCurrencyUnit(BigDecimal currencyUnit)
    {
	this.currencyUnit = currencyUnit;
    }

    public String getMultipleDivisionIndicator()
    {
	return multipleDivisionIndicator;
    }

    public void setMultipleDivisionIndicator(String multipleDivisionIndicator)
    {
	this.multipleDivisionIndicator = multipleDivisionIndicator;
    }

    /**
     * @return the income
     */
    public BigDecimal getIncome()
    {
	return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(BigDecimal income)
    {
	this.income = income;
    }

    /**
     * @return the productClassName
     */
    public String getProductClassName()
    {
	return productClassName;
    }

    /**
     * @param productClassName the productClassName to set
     */
    public void setProductClassName(String productClassName)
    {
	this.productClassName = productClassName;
    }

    /**
     * @return the tenureDesc
     */
    public String getTenureDesc()
    {
	return tenureDesc;
    }

    /**
     * @param tenureDesc the tenureDesc to set
     */
    public void setTenureDesc(String tenureDesc)
    {
	this.tenureDesc = tenureDesc;
    }

    /**
     * @return the floatingRateCodeDesc
     */
    public String getFloatingRateCodeDesc()
    {
	return floatingRateCodeDesc;
    }

    /**
     * @param floatingRateCodeDesc the floatingRateCodeDesc to set
     */
    public void setFloatingRateCodeDesc(String floatingRateCodeDesc)
    {
	this.floatingRateCodeDesc = floatingRateCodeDesc;
    }

    /**
     * @return the profitCalcMethod
     */
    public String getProfitCalcMethod()
    {
	return profitCalcMethod;
    }

    /**
     * @param profitCalcMethod the profitCalcMethod to set
     */
    public void setProfitCalcMethod(String profitCalcMethod)
    {
	this.profitCalcMethod = profitCalcMethod;
    }

    /**
     * @return the profitRecognitionMethod
     */
    public String getProfitRecognitionMethod()
    {
	return profitRecognitionMethod;
    }

    /**
     * @param profitRecognitionMethod the profitRecognitionMethod to set
     */
    public void setProfitRecognitionMethod(String profitRecognitionMethod)
    {
	this.profitRecognitionMethod = profitRecognitionMethod;
    }

    /**
     * @return the facilityTypeDesc
     */
    public String getFacilityTypeDesc()
    {
	return facilityTypeDesc;
    }

    /**
     * @param facilityTypeDesc the facilityTypeDesc to set
     */
    public void setFacilityTypeDesc(String facilityTypeDesc)
    {
	this.facilityTypeDesc = facilityTypeDesc;
    }

    /**
     * @return the tempCodeDesc
     */
    public String getTempCodeDesc()
    {
	return tempCodeDesc;
    }

    /**
     * @param tempCodeDesc the tempCodeDesc to set
     */
    public void setTempCodeDesc(String tempCodeDesc)
    {
	this.tempCodeDesc = tempCodeDesc;
    }

    /**
     * @return the vatDesc
     */
    public String getVatDesc()
    {
	return vatDesc;
    }

    /**
     * @param vatDesc the vatDesc to set
     */
    public void setVatDesc(String vatDesc)
    {
	this.vatDesc = vatDesc;
    }

    /**
     * @return the approvedSalary
     */
    public BigDecimal getApprovedSalary()
    {
	return approvedSalary;
    }

    /**
     * @param approvedSalary the approvedSalary to set
     */
    public void setApprovedSalary(BigDecimal approvedSalary)
    {
	this.approvedSalary = approvedSalary;
    }

    /**
     * @return the debtBurdanRatio
     */
    public BigDecimal getDebtBurdanRatio()
    {
	return debtBurdanRatio;
    }

    /**
     * @param debtBurdanRatio the debtBurdanRatio to set
     */
    public void setDebtBurdanRatio(BigDecimal debtBurdanRatio)
    {
	this.debtBurdanRatio = debtBurdanRatio;
    }

    /**
     * @return the annualYieldRate
     */
    public BigDecimal getAnnualYieldRate()
    {
	return annualYieldRate;
    }

    /**
     * @param annualYieldRate the annualYieldRate to set
     */
    public void setAnnualYieldRate(BigDecimal annualYieldRate)
    {
	this.annualYieldRate = annualYieldRate;
    }

    /**
     * @return the currencyCode
     */
    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    /**
     * @param currencyCode the currencyCode to set
     */
    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    /**
     * @return the advancePayment
     */
    public BigDecimal getAdvancePayment()
    {
	return advancePayment;
    }

    /**
     * @param advancePayment the advancePayment to set
     */
    public void setAdvancePayment(BigDecimal advancePayment)
    {
	this.advancePayment = advancePayment;
    }

    /**
     * @return the tenureCode
     */
    public BigDecimal getTenureCode()
    {
	return tenureCode;
    }

    /**
     * @param tenureCode the tenureCode to set
     */
    public void setTenureCode(BigDecimal tenureCode)
    {
	this.tenureCode = tenureCode;
    }

    /**
     * @return the margin
     */
    public BigDecimal getMargin()
    {
	return margin;
    }

    /**
     * @param margin the margin to set
     */
    public void setMargin(BigDecimal margin)
    {
	this.margin = margin;
    }

    /**
     * @return the floatingRateCode
     */
    public BigDecimal getFloatingRateCode()
    {
	return floatingRateCode;
    }

    /**
     * @param floatingRateCode the floatingRateCode to set
     */
    public void setFloatingRateCode(BigDecimal floatingRateCode)
    {
	this.floatingRateCode = floatingRateCode;
    }

    /**
     * @return the floatingRate
     */
    public BigDecimal getFloatingRate()
    {
	return floatingRate;
    }

    /**
     * @param floatingRate the floatingRate to set
     */
    public void setFloatingRate(BigDecimal floatingRate)
    {
	this.floatingRate = floatingRate;
    }

    /**
     * @return the annualFlatRate
     */
    public BigDecimal getAnnualFlatRate()
    {
	return annualFlatRate;
    }

    /**
     * @param annualFlatRate the annualFlatRate to set
     */
    public void setAnnualFlatRate(BigDecimal annualFlatRate)
    {
	this.annualFlatRate = annualFlatRate;
    }

    /**
     * @return the facilityTypeCode
     */
    public BigDecimal getFacilityTypeCode()
    {
	return facilityTypeCode;
    }

    /**
     * @param facilityTypeCode the facilityTypeCode to set
     */
    public void setFacilityTypeCode(BigDecimal facilityTypeCode)
    {
	this.facilityTypeCode = facilityTypeCode;
    }

    /**
     * @return the tempCode
     */
    public BigDecimal getTempCode()
    {
	return tempCode;
    }

    /**
     * @param tempCode the tempCode to set
     */
    public void setTempCode(BigDecimal tempCode)
    {
	this.tempCode = tempCode;
    }

    /**
     * @return the noOfMonths
     */
    public BigDecimal getNoOfMonths()
    {
	return noOfMonths;
    }

    /**
     * @param noOfMonths the noOfMonths to set
     */
    public void setNoOfMonths(BigDecimal noOfMonths)
    {
	this.noOfMonths = noOfMonths;
    }

    /**
     * @return the saleAmount
     */
    public BigDecimal getSaleAmount()
    {
	return saleAmount;
    }

    /**
     * @param saleAmount the saleAmount to set
     */
    public void setSaleAmount(BigDecimal saleAmount)
    {
	this.saleAmount = saleAmount;
    }

    /**
     * @return the profit
     */
    public BigDecimal getProfit()
    {
	return profit;
    }

    /**
     * @param profit the profit to set
     */
    public void setProfit(BigDecimal profit)
    {
	this.profit = profit;
    }

    /**
     * @return the xirr
     */
    public BigDecimal getXirr()
    {
	return xirr;
    }

    /**
     * @param xirr the xirr to set
     */
    public void setXirr(BigDecimal xirr)
    {
	this.xirr = xirr;
    }

    // TODO FOR SCHEDULE - NEED TO REMOVE
    public List<TrspayplandetCO> getIslamicCalculatorScheduleList()
    {
	return islamicCalculatorScheduleList;
    }

    public void setIslamicCalculatorScheduleList(List<TrspayplandetCO> islamicCalculatorScheduleList)
    {
	this.islamicCalculatorScheduleList = islamicCalculatorScheduleList;
    }

    /**
     * @return the allowEditFinanceCyInCalc
     */
    public String getAllowEditFinanceCyInCalc()
    {
	return allowEditFinanceCyInCalc;
    }

    /**
     * @param allowEditFinanceCyInCalc the allowEditFinanceCyInCalc to set
     */
    public void setAllowEditFinanceCyInCalc(String allowEditFinanceCyInCalc)
    {
	this.allowEditFinanceCyInCalc = allowEditFinanceCyInCalc;
    }

    /**
     * @return the allowEditYieldInCalc
     */
    public String getAllowEditYieldInCalc()
    {
	return allowEditYieldInCalc;
    }

    /**
     * @param allowEditYieldInCalc the allowEditYieldInCalc to set
     */
    public void setAllowEditYieldInCalc(String allowEditYieldInCalc)
    {
	this.allowEditYieldInCalc = allowEditYieldInCalc;
    }

    /**
     * @return the allowProfitRecoInCalc
     */
    public String getAllowProfitRecoInCalc()
    {
	return allowProfitRecoInCalc;
    }

    /**
     * @param allowProfitRecoInCalc the allowProfitRecoInCalc to set
     */
    public void setAllowProfitRecoInCalc(String allowProfitRecoInCalc)
    {
	this.allowProfitRecoInCalc = allowProfitRecoInCalc;
    }

    /**
     * @return the allowToEditProfitDistMthd
     */
    public String getAllowToEditProfitDistMthd()
    {
	return allowToEditProfitDistMthd;
    }

    /**
     * @param allowToEditProfitDistMthd the allowToEditProfitDistMthd to set
     */
    public void setAllowToEditProfitDistMthd(String allowToEditProfitDistMthd)
    {
	this.allowToEditProfitDistMthd = allowToEditProfitDistMthd;
    }

    /**
     * @return the calcDbrCalculationReqdYn
     */
    public String getCalcDbrCalculationReqdYn()
    {
	return calcDbrCalculationReqdYn;
    }

    /**
     * @param calcDbrCalculationReqdYn the calcDbrCalculationReqdYn to set
     */
    public void setCalcDbrCalculationReqdYn(String calcDbrCalculationReqdYn)
    {
	this.calcDbrCalculationReqdYn = calcDbrCalculationReqdYn;
    }

    /**
     * @return the calcDisableStartDate
     */
    public String getCalcDisableStartDate()
    {
	return calcDisableStartDate;
    }

    /**
     * @param calcDisableStartDate the calcDisableStartDate to set
     */
    public void setCalcDisableStartDate(String calcDisableStartDate)
    {
	this.calcDisableStartDate = calcDisableStartDate;
    }

    /**
     * @return the showCifIncome
     */
    public String getShowCifIncome()
    {
	return showCifIncome;
    }

    /**
     * @param showCifIncome the showCifIncome to set
     */
    public void setShowCifIncome(String showCifIncome)
    {
	this.showCifIncome = showCifIncome;
    }

    /**
     * @return the showYieldInCalc
     */
    public String getShowYieldInCalc()
    {
	return showYieldInCalc;
    }

    /**
     * @param showYieldInCalc the showYieldInCalc to set
     */
    public void setShowYieldInCalc(String showYieldInCalc)
    {
	this.showYieldInCalc = showYieldInCalc;
    }

    /**
     * @return the allowProfitRecoInCalcReadOnly
     */
    public Boolean getAllowProfitRecoInCalcReadOnly()
    {
	return allowProfitRecoInCalcReadOnly;
    }

    /**
     * @param allowProfitRecoInCalcReadOnly the allowProfitRecoInCalcReadOnly to
     *            set
     */
    public void setAllowProfitRecoInCalcReadOnly(Boolean allowProfitRecoInCalcReadOnly)
    {
	this.allowProfitRecoInCalcReadOnly = allowProfitRecoInCalcReadOnly;
    }

    /**
     * @return the calcDisableStartDateReadOnly
     */
    public Boolean getCalcDisableStartDateReadOnly()
    {
	return calcDisableStartDateReadOnly;
    }

    /**
     * @param calcDisableStartDateReadOnly the calcDisableStartDateReadOnly to
     *            set
     */
    public void setCalcDisableStartDateReadOnly(Boolean calcDisableStartDateReadOnly)
    {
	this.calcDisableStartDateReadOnly = calcDisableStartDateReadOnly;
    }

    /**
     * @return the allowEditYieldInCalcReadOnly
     */
    public Boolean getAllowEditYieldInCalcReadOnly()
    {
	return allowEditYieldInCalcReadOnly;
    }

    /**
     * @param allowEditYieldInCalcReadOnly the allowEditYieldInCalcReadOnly to
     *            set
     */
    public void setAllowEditYieldInCalcReadOnly(Boolean allowEditYieldInCalcReadOnly)
    {
	this.allowEditYieldInCalcReadOnly = allowEditYieldInCalcReadOnly;
    }

    /**
     * @return the allowToEditProfitDistMthdReadOnly
     */
    public Boolean getAllowToEditProfitDistMthdReadOnly()
    {
	return allowToEditProfitDistMthdReadOnly;
    }

    /**
     * @param allowToEditProfitDistMthdReadOnly the
     *            allowToEditProfitDistMthdReadOnly to set
     */
    public void setAllowToEditProfitDistMthdReadOnly(Boolean allowToEditProfitDistMthdReadOnly)
    {
	this.allowToEditProfitDistMthdReadOnly = allowToEditProfitDistMthdReadOnly;
    }

    /**
     * @return the allowEditFinanceCyInCalcReadOnly
     */
    public Boolean getAllowEditFinanceCyInCalcReadOnly()
    {
	return allowEditFinanceCyInCalcReadOnly;
    }

    /**
     * @param allowEditFinanceCyInCalcReadOnly the
     *            allowEditFinanceCyInCalcReadOnly to set
     */
    public void setAllowEditFinanceCyInCalcReadOnly(Boolean allowEditFinanceCyInCalcReadOnly)
    {
	this.allowEditFinanceCyInCalcReadOnly = allowEditFinanceCyInCalcReadOnly;
    }

    public BigDecimal getNidcDealCount()
    {
	return nidcDealCount;
    }

    public void setNidcDealCount(BigDecimal nidcDealCount)
    {
	this.nidcDealCount = nidcDealCount;
    }

    public BigDecimal getHolidayAction()
    {
	return holidayAction;
    }

    public void setHolidayAction(BigDecimal holidayAction)
    {
	this.holidayAction = holidayAction;
    }

    public void setTrsDealChargesVO(List<TrsDealChargesCO> trsDealChargesVO)
    {
	this.trsDealChargesVO = trsDealChargesVO;
    }

    public List<TrsDealChargesCO> getTrsDealChargesVO()
    {
	return trsDealChargesVO;
    }

    // TODO FOR BALLOON PAYMENT - NEED TO REMOVE
    public List<TrsPlanBallonPaymentCO> getBalloonDetailsList()
    {
	return balloonDetailsList;
    }

    public void setBalloonDetailsList(List<TrsPlanBallonPaymentCO> balloonDetailsList)
    {
	this.balloonDetailsList = balloonDetailsList;
    }

    public List<TRSPAYPLAN_CRITERIAVO> getTrsPayplanCriteriaVO()
    {
	return trsPayplanCriteriaVO;
    }

    public void setTrsPayplanCriteriaVO(List<TRSPAYPLAN_CRITERIAVO> trsPayplanCriteriaVO)
    {
	this.trsPayplanCriteriaVO = trsPayplanCriteriaVO;
    }

    public BigDecimal getRemainingAmount()
    {
	return remainingAmount;
    }

    public void setRemainingAmount(BigDecimal remainingAmount)
    {
	this.remainingAmount = remainingAmount;
    }

    public String getShowCifIncomeInd()
    {
	return showCifIncomeInd;
    }

    public void setShowCifIncomeInd(String showCifIncomeInd)
    {
	this.showCifIncomeInd = showCifIncomeInd;
    }

    public String getSalaryWithBank()
    {
	return salaryWithBank;
    }

    public void setSalaryWithBank(String salaryWithBank)
    {
	this.salaryWithBank = salaryWithBank;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getCallType()
    {
	return callType;
    }

    public void setCallType(String callType)
    {
	this.callType = callType;
    }

    public BigDecimal getDealNo()
    {
	return dealNo;
    }

    public void setDealNo(BigDecimal dealNo)
    {
	this.dealNo = dealNo;
    }

    public BigDecimal getDealAmount()
    {
	return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount)
    {
	this.dealAmount = dealAmount;
    }

    public BigDecimal getBaloonpayment()
    {
	return baloonpayment;
    }

    public void setBaloonpayment(BigDecimal baloonpayment)
    {
	this.baloonpayment = baloonpayment;
    }

    public String getPartyType()
    {
	return partyType;
    }

    public void setPartyType(String partyType)
    {
	this.partyType = partyType;
    }

    public BigDecimal getRosterRegisterCode()
    {
	return rosterRegisterCode;
    }

    public void setRosterRegisterCode(BigDecimal rosterRegisterCode)
    {
	this.rosterRegisterCode = rosterRegisterCode;
    }

    public BigDecimal getRosterCodeyield()
    {
	return rosterCodeyield;
    }

    public void setRosterCodeyield(BigDecimal rosterCodeyield)
    {
	this.rosterCodeyield = rosterCodeyield;
    }

    public BigDecimal getRosterCodeModarib()
    {
	return rosterCodeModarib;
    }

    public void setRosterCodeModarib(BigDecimal rosterCodeModarib)
    {
	this.rosterCodeModarib = rosterCodeModarib;
    }

    public BigDecimal getRosterLineno()
    {
	return rosterLineno;
    }

    public void setRosterLineno(BigDecimal rosterLineno)
    {
	this.rosterLineno = rosterLineno;
    }

    public BigDecimal getRosterNoOfPayments()
    {
	return rosterNoOfPayments;
    }

    public void setRosterNoOfPayments(BigDecimal rosterNoOfPayments)
    {
	this.rosterNoOfPayments = rosterNoOfPayments;
    }

    public String getEntityType()
    {
	return entityType;
    }

    public void setEntityType(String entityType)
    {
	this.entityType = entityType;
    }

    public BigDecimal getRosterEntityCode()
    {
	return rosterEntityCode;
    }

    public void setRosterEntityCode(BigDecimal rosterEntityCode)
    {
	this.rosterEntityCode = rosterEntityCode;
    }

    public BigDecimal getRosterDealAmount()
    {
	return rosterDealAmount;
    }

    public void setRosterDealAmount(BigDecimal rosterDealAmount)
    {
	this.rosterDealAmount = rosterDealAmount;
    }

    public BigDecimal getOrginalYield()
    {
	return orginalYield;
    }

    public void setOrginalYield(BigDecimal orginalYield)
    {
	this.orginalYield = orginalYield;
    }

    public BigDecimal getYieldAmendRangeFrom()
    {
	return yieldAmendRangeFrom;
    }

    public void setYieldAmendRangeFrom(BigDecimal yieldAmendRangeFrom)
    {
	this.yieldAmendRangeFrom = yieldAmendRangeFrom;
    }

    public BigDecimal getYieldAmendRangeTo()
    {
	return yieldAmendRangeTo;
    }

    public void setYieldAmendRangeTo(BigDecimal yieldAmendRangeTo)
    {
	this.yieldAmendRangeTo = yieldAmendRangeTo;
    }

    public BigDecimal getCurrencyDecimalPoints()
    {
	return currencyDecimalPoints;
    }

    public void setCurrencyDecimalPoints(BigDecimal currencyDecimalPoints)
    {
	this.currencyDecimalPoints = currencyDecimalPoints;
    }

    public String getEventType()
    {
	return eventType;
    }

    public void setEventType(String eventType)
    {
	this.eventType = eventType;
    }

    public String getVatApplicable()
    {
	return vatApplicable;
    }

    public void setVatApplicable(String vatApplicable)
    {
	this.vatApplicable = vatApplicable;
    }

    public String getIncludeVatinInstallment()
    {
	return includeVatinInstallment;
    }

    public void setIncludeVatinInstallment(String includeVatinInstallment)
    {
	this.includeVatinInstallment = includeVatinInstallment;
    }

    public String getProfitUpfront()
    {
	return profitUpfront;
    }

    public void setProfitUpfront(String profitUpfront)
    {
	this.profitUpfront = profitUpfront;
    }

    public BigDecimal getCategory()
    {
	return category;
    }

    public void setCategory(BigDecimal category)
    {
	this.category = category;
    }

    public BigDecimal getBaloonAmountMaxPerc()
    {
	return baloonAmountMaxPerc;
    }

    public void setBaloonAmountMaxPerc(BigDecimal baloonAmountMaxPerc)
    {
	this.baloonAmountMaxPerc = baloonAmountMaxPerc;
    }

    public BigDecimal getBaloonAmountMinPerc()
    {
	return baloonAmountMinPerc;
    }

    public void setBaloonAmountMinPerc(BigDecimal baloonAmountMinPerc)
    {
	this.baloonAmountMinPerc = baloonAmountMinPerc;
    }

    public String getPaymentType()
    {
	return paymentType;
    }

    public void setPaymentType(String paymentType)
    {
	this.paymentType = paymentType;
    }

    public BigDecimal getAllocatedDealAmount()
    {
	return allocatedDealAmount;
    }

    public void setAllocatedDealAmount(BigDecimal allocatedDealAmount)
    {
	this.allocatedDealAmount = allocatedDealAmount;
    }

    public BigDecimal getCapitalDealAmount()
    {
	return capitalDealAmount;
    }

    public void setCapitalDealAmount(BigDecimal capitalDealAmount)
    {
	this.capitalDealAmount = capitalDealAmount;
    }

    public Date getToDate()
    {
	return toDate;
    }

    public void setToDate(Date toDate)
    {
	this.toDate = toDate;
    }

    public TRSPAYPLAN_CRITERIAVO getTrsPayplanCriteriaVOObject()
    {
	return trsPayplanCriteriaVOObject;
    }

    public void setTrsPayplanCriteriaVOObject(TRSPAYPLAN_CRITERIAVO trsPayplanCriteriaVOObject)
    {
	this.trsPayplanCriteriaVOObject = trsPayplanCriteriaVOObject;
    }

    public Date getMaturityDateAfterHoliday()
    {
	return maturityDateAfterHoliday;
    }

    public void setMaturityDateAfterHoliday(Date maturityDateAfterHoliday)
    {
	this.maturityDateAfterHoliday = maturityDateAfterHoliday;
    }

    public String getAllowtoEditVat()
    {
	return allowtoEditVat;
    }

    public void setAllowtoEditVat(String allowtoEditVat)
    {
	this.allowtoEditVat = allowtoEditVat;
    }

    public Date getDefaultMaturityDate()
    {
	return defaultMaturityDate;
    }

    public void setDefaultMaturityDate(Date defaultMaturityDate)
    {
	this.defaultMaturityDate = defaultMaturityDate;
    }

    public Boolean getCheckDefaultMaturityDate()
    {
	return checkDefaultMaturityDate;
    }

    public void setCheckDefaultMaturityDate(Boolean checkDefaultMaturityDate)
    {
	this.checkDefaultMaturityDate = checkDefaultMaturityDate;
    }

    public String getConfirmationMessageId()
    {
	return confirmationMessageId;
    }

    public void setConfirmationMessageId(String confirmationMessageId)
    {
	this.confirmationMessageId = confirmationMessageId;
    }

    public String getVatIcludedInInstallement()
    {
	return vatIcludedInInstallement;
    }

    public void setVatIcludedInInstallement(String vatIcludedInInstallement)
    {
	this.vatIcludedInInstallement = vatIcludedInInstallement;
    }

    public String getDealPeriodCompounding()
    {
	return dealPeriodCompounding;
    }

    public void setDealPeriodCompounding(String dealPeriodCompounding)
    {
	this.dealPeriodCompounding = dealPeriodCompounding;
    }

    public String getYieldRequired()
    {
	return yieldRequired;
    }

    public void setYieldRequired(String yieldRequired)
    {
	this.yieldRequired = yieldRequired;
    }

    public BigDecimal getClassCode()
    {
	return classCode;
    }

    public void setClassCode(BigDecimal classCode)
    {
	this.classCode = classCode;
    }

    public Date getValueDate()
    {
	return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public BigDecimal getSumOfCapitalAmtRepayment()
    {
	return sumOfCapitalAmtRepayment;
    }

    public void setSumOfCapitalAmtRepayment(BigDecimal sumOfCapitalAmtRepayment)
    {
	this.sumOfCapitalAmtRepayment = sumOfCapitalAmtRepayment;
    }

    public Date getStartDateAfterHoliday()
    {
	return startDateAfterHoliday;
    }

    public void setStartDateAfterHoliday(Date startDateAfterHoliday)
    {
	this.startDateAfterHoliday = startDateAfterHoliday;
    }

    public Boolean getConfirmationResult()
    {
	return confirmationResult;
    }

    public void setConfirmationResult(Boolean confirmationResult)
    {
	this.confirmationResult = confirmationResult;
    }

    public TrsPlanBallonPaymentCO getBallonPaymentCO()
    {
	return ballonPaymentCO;
    }

    public void setBallonPaymentCO(TrsPlanBallonPaymentCO ballonPaymentCO)
    {
	this.ballonPaymentCO = ballonPaymentCO;
    }

    public String getCurrencyDesc()
    {
	return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc)
    {
	this.currencyDesc = currencyDesc;
    }

    public String getYieldFlag()
    {
	return yieldFlag;
    }

    public void setYieldFlag(String yieldFlag)
    {
	this.yieldFlag = yieldFlag;
    }

    public BigDecimal getTotalYield()
    {
	return totalYield;
    }

    public void setTotalYield(BigDecimal totalYield)
    {
	this.totalYield = totalYield;
    }

    public String getPrefferedLanguage()
    {
	return prefferedLanguage;
    }

    public void setPrefferedLanguage(String prefferedLanguage)
    {
	this.prefferedLanguage = prefferedLanguage;
    }

    public BigDecimal getCurrencyDecimalPointsForCalc()
    {
	return currencyDecimalPointsForCalc;
    }

    public void setCurrencyDecimalPointsForCalc(BigDecimal currencyDecimalPointsForCalc)
    {
	this.currencyDecimalPointsForCalc = currencyDecimalPointsForCalc;
    }

    public String getDisableBtnAfterCalc()
    {
	return disableBtnAfterCalc;
    }

    public void setDisableBtnAfterCalc(String disableBtnAfterCalc)
    {
	this.disableBtnAfterCalc = disableBtnAfterCalc;
    }

    public String getShowVat()
    {
	return showVat;
    }

    public void setShowVat(String showVat)
    {
	this.showVat = showVat;
    }

    public void setRepaymentCriteriaFirstRowDate(Date repaymentCriteriaFirstRowDate)
    {
	this.repaymentCriteriaFirstRowDate = repaymentCriteriaFirstRowDate;
    }

    public Date getRepaymentCriteriaFirstRowDate()
    {
	return repaymentCriteriaFirstRowDate;
    }

    public String getCyFormat()
    {
	return cyFormat;
    }

    public void setCyFormat(String cyFormat)
    {
	this.cyFormat = cyFormat;
    }

    public String getConfirmMessageDetailId()
    {
	return confirmMessageDetailId;
    }

    public void setConfirmMessageDetailId(String confirmMessageDetailId)
    {
	this.confirmMessageDetailId = confirmMessageDetailId;
    }

    public void setTotalInsuranceAmt(BigDecimal totalInsuranceAmt)
    {
	this.totalInsuranceAmt = totalInsuranceAmt;
    }

    public BigDecimal getTotalInsuranceAmt()
    {
	return totalInsuranceAmt;
    }

    public List<TRSDEALCHARGESVO> getTrsDealChargesVOList()
    {
	return trsDealChargesVOList;
    }

    public void setTrsDealChargesVOList(List<TRSDEALCHARGESVO> trsDealChargesVOList)
    {
	this.trsDealChargesVOList = trsDealChargesVOList;
    }

    public List<TRSPAYPLANDETVO> getTrsPayPlandetVOList()
    {
	return trsPayPlandetVOList;
    }

    public void setTrsPayPlandetVOList(List<TRSPAYPLANDETVO> trsPayPlandetVOList)
    {
	this.trsPayPlandetVOList = trsPayPlandetVOList;
    }

    public String getPageRef()
    {
	return pageRef;
    }

    public void setPageRef(String pageRef)
    {
	this.pageRef = pageRef;
    }

    public BigDecimal getLinkType()
    {
	return linkType;
    }

    public void setLinkType(BigDecimal linkType)
    {
	this.linkType = linkType;
    }

    public String getRescheduleCalcYN()
    {
	return rescheduleCalcYN;
    }

    public void setRescheduleCalcYN(String rescheduleCalcYN)
    {
	this.rescheduleCalcYN = rescheduleCalcYN;
    }

    public void setCalendarType(String calendarType)
    {
	this.calendarType = calendarType;
    }

    public String getCalendarType()
    {
	return calendarType;
    }

    public void setIborRatePeriodicity(BigDecimal iborRatePeriodicity)
    {
	this.iborRatePeriodicity = iborRatePeriodicity;
    }

    public BigDecimal getIborRatePeriodicity()
    {
	return iborRatePeriodicity;
    }

    public void setIborRatePeriodicityType(String iborRatePeriodicityType)
    {
	this.iborRatePeriodicityType = iborRatePeriodicityType;
    }

    public String getIborRatePeriodicityType()
    {
	return iborRatePeriodicityType;
    }

    public void setFirstPayDateHijri(String firstPayDateHijri)
    {
	this.firstPayDateHijri = firstPayDateHijri;
    }

    public String getFirstPayDateHijri()
    {
	return firstPayDateHijri;
    }

    public void setLimitSerialNo(BigDecimal limitSerialNo)
    {
	this.limitSerialNo = limitSerialNo;
    }

    public BigDecimal getLimitSerialNo()
    {
	return limitSerialNo;
    }

    public void setLimitAccDesc(String limitAccDesc)
    {
	this.limitAccDesc = limitAccDesc;
    }

    public String getLimitAccDesc()
    {
	return limitAccDesc;
    }

    public void setACC_BRANCH(BigDecimal aCC_BRANCH)
    {
	ACC_BRANCH = aCC_BRANCH;
    }

    public BigDecimal getACC_BRANCH()
    {
	return ACC_BRANCH;
    }

    public void setACC_CURRENCY(BigDecimal aCC_CURRENCY)
    {
	ACC_CURRENCY = aCC_CURRENCY;
    }

    public BigDecimal getACC_CURRENCY()
    {
	return ACC_CURRENCY;
    }

    public void setACC_GL_CODE(BigDecimal aCC_GL_CODE)
    {
	ACC_GL_CODE = aCC_GL_CODE;
    }

    public BigDecimal getACC_GL_CODE()
    {
	return ACC_GL_CODE;
    }

    public void setACC_CIF_NO(BigDecimal aCC_CIF_NO)
    {
	ACC_CIF_NO = aCC_CIF_NO;
    }

    public BigDecimal getACC_CIF_NO()
    {
	return ACC_CIF_NO;
    }

    public void setACC_SL_NO(BigDecimal aCC_SL_NO)
    {
	ACC_SL_NO = aCC_SL_NO;
    }

    public BigDecimal getACC_SL_NO()
    {
	return ACC_SL_NO;
    }

    public void setADDITIONAL_REFERENCE(String aDDITIONAL_REFERENCE)
    {
	ADDITIONAL_REFERENCE = aDDITIONAL_REFERENCE;
    }

    public String getADDITIONAL_REFERENCE()
    {
	return ADDITIONAL_REFERENCE;
    }

    public void setACCOUNT_NAME(String aCCOUNT_NAME)
    {
	ACCOUNT_NAME = aCCOUNT_NAME;
    }

    public String getACCOUNT_NAME()
    {
	return ACCOUNT_NAME;
    }

    public void setHmSysParam(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hmSysParam)
    {
	this.hmSysParam = hmSysParam;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHmSysParam()
    {
	return hmSysParam;
    }

    public void setConfirmMessagesArryList(List<String[]> confirmMessagesArryList)
    {
	this.confirmMessagesArryList = confirmMessagesArryList;
    }

    public List<String[]> getConfirmMessagesArryList()
    {
	return confirmMessagesArryList;
    }

    public void setUserId(String userId)
    {
	this.userId = userId;
    }

    public String getUserId()
    {
	return userId;
    }

    public MemoSC getMemoSC()
    {
	return memoSC;
    }

    public void setMemoSC(MemoSC memoSC)
    {
	this.memoSC = memoSC;
    }

    public void setGracePeriodActual(BigDecimal gracePeriodActual)
    {
	this.gracePeriodActual = gracePeriodActual;
    }

    public BigDecimal getGracePeriodActual()
    {
	return gracePeriodActual;
    }

    public void setGracePeriodicityActual(String gracePeriodicityActual)
    {
	this.gracePeriodicityActual = gracePeriodicityActual;
    }

    public String getGracePeriodicityActual()
    {
	return gracePeriodicityActual;
    }

    public void setDateMonth(int dateMonth)
    {
	this.dateMonth = dateMonth;
    }

    public int getDateMonth()
    {
	return dateMonth;
    }

    public void setDateYear(int dateYear)
    {
	this.dateYear = dateYear;
    }

    public int getDateYear()
    {
	return dateYear;
    }

    public List<TrsdealMultipleYieldCO> getTrsdealMultipleYieldCOList()
    {
	return trsdealMultipleYieldCOList;
    }

    public void setTrsdealMultipleYieldCOList(List<TrsdealMultipleYieldCO> trsdealMultipleYieldCOList)
    {
	this.trsdealMultipleYieldCOList = trsdealMultipleYieldCOList;
    }

    public String getShowPaySchedule()
    {
	return showPaySchedule;
    }

    public void setShowPaySchedule(String showPaySchedule)
    {
	this.showPaySchedule = showPaySchedule;
    }

    public String getPrintCalcDetailScheduleYN()
    {
	return printCalcDetailScheduleYN;
    }

    public void setPrintCalcDetailScheduleYN(String printCalcDetailScheduleYN)
    {
	this.printCalcDetailScheduleYN = printCalcDetailScheduleYN;
    }

    public String getPrintCalcDetailYN()
    {
	return printCalcDetailYN;
    }

    public void setPrintCalcDetailYN(String printCalcDetailYN)
    {
	this.printCalcDetailYN = printCalcDetailYN;
    }

    public BigDecimal getChargeAmount()
    {
	return chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount)
    {
	this.chargeAmount = chargeAmount;
    }

    public List<TRSDEAL3VO> getTrsDealMultipleDisbursementList()
    {
	return trsDealMultipleDisbursementList;
    }

    public void setTrsDealMultipleDisbursementList(List<TRSDEAL3VO> trsDealMultipleDisbursementList)
    {
	this.trsDealMultipleDisbursementList = trsDealMultipleDisbursementList;
    }

    public List<TRSPAYPLANDETVO> getTrspayplanTentativeScheduledet()
    {
	return trspayplanTentativeScheduledet;
    }

    public void setTrspayplanTentativeScheduledet(List<TRSPAYPLANDETVO> trspayplanTentativeScheduledet)
    {
	this.trspayplanTentativeScheduledet = trspayplanTentativeScheduledet;
    }

    public List<TRSPAYPLAN_CRITERIA_TENTATIVEVO> getTrspayplanCRITERIATENTATIVEVOs()
    {
	return trspayplanCRITERIATENTATIVEVOs;
    }

    public void setTrspayplanCRITERIATENTATIVEVOs(List<TRSPAYPLAN_CRITERIA_TENTATIVEVO> trspayplanCRITERIATENTATIVEVOs)
    {
	this.trspayplanCRITERIATENTATIVEVOs = trspayplanCRITERIATENTATIVEVOs;
    }

    public TRSDEAL3VO getTrsdeal3vo()
    {
	return trsdeal3vo;
    }

    public void setTrsdeal3vo(TRSDEAL3VO trsdeal3vo)
    {
	this.trsdeal3vo = trsdeal3vo;
    }

    public BigDecimal getDrawDownCode()
    {
	return drawDownCode;
    }

    public void setDrawDownCode(BigDecimal drawDownCode)
    {
	this.drawDownCode = drawDownCode;
    }

    public BigDecimal getDrawDownBranch()
    {
	return drawDownBranch;
    }

    public void setDrawDownBranch(BigDecimal drawDownBranch)
    {
	this.drawDownBranch = drawDownBranch;
    }

    public BigDecimal getProjectAmount()
    {
	return projectAmount;
    }

    public void setProjectAmount(BigDecimal projectAmount)
    {
	this.projectAmount = projectAmount;
    }

    public BigDecimal getContractPrice()
    {
	return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice)
    {
	this.contractPrice = contractPrice;
    }

    public BigDecimal getDiscountPerc()
    {
	return discountPerc;
    }

    public void setDiscountPerc(BigDecimal discountPerc)
    {
	this.discountPerc = discountPerc;
    }

    public String getDiscountCalMethod()
    {
	return discountCalMethod;
    }

    public void setDiscountCalMethod(String discountCalMethod)
    {
	this.discountCalMethod = discountCalMethod;
    }

    public String getMusawamahYN()
    {
	return musawamahYN;
    }

    public void setMusawamahYN(String musawamahYN)
    {
	this.musawamahYN = musawamahYN;
    }

    public String getBaseCurrencyDesc()
    {
	return baseCurrencyDesc;
    }

    public void setBaseCurrencyDesc(String baseCurrencyDesc)
    {
	this.baseCurrencyDesc = baseCurrencyDesc;
    }

    public String getGlobalConfirmationFrom()
    {
	return globalConfirmationFrom;
    }

    public void setGlobalConfirmationFrom(String globalConfirmationFrom)
    {
	this.globalConfirmationFrom = globalConfirmationFrom;
    }

    public boolean isShowCustGuarLiability()
    {
	return showCustGuarLiability;
    }

    public void setShowCustGuarLiability(boolean showCustGuarLiability)
    {
	this.showCustGuarLiability = showCustGuarLiability;
    }

    public List<IslamicCalculatorCustGuarLiabilitiesListCO> getCustGuarLiabilityList()
    {
	return custGuarLiabilityList;
    }

    public void setCustGuarLiabilityList(List<IslamicCalculatorCustGuarLiabilitiesListCO> custGuarLiabilityList)
    {
	this.custGuarLiabilityList = custGuarLiabilityList;
    }

    public BigDecimal getSafeboxchargeamt()
    {
	return safeboxchargeamt;
    }

    public void setSafeboxchargeamt(BigDecimal safeboxchargeamt)
    {
	this.safeboxchargeamt = safeboxchargeamt;
    }

    public BigDecimal getSafeboxchargeamt_1()
    {
	return safeboxchargeamt_1;
    }

    public void setSafeboxchargeamt_1(BigDecimal safeboxchargeamt_1)
    {
	this.safeboxchargeamt_1 = safeboxchargeamt_1;
    }

    public BigDecimal getSafeboxchargeamt_2()
    {
	return safeboxchargeamt_2;
    }

    public void setSafeboxchargeamt_2(BigDecimal safeboxchargeamt_2)
    {
	this.safeboxchargeamt_2 = safeboxchargeamt_2;
    }

    public List<ItemsCO> getItemsCOList()
    {
	return itemsCOList;
    }

    public void setItemsCOList(List<ItemsCO> itemsCOList)
    {
	this.itemsCOList = itemsCOList;
    }

    public BigDecimal getSafeboxno()
    {
	return safeboxno;
    }

    public void setSafeboxno(BigDecimal safeboxno)
    {
	this.safeboxno = safeboxno;
    }

    public String getRemarks()
    {
	return remarks;
    }

    public void setRemarks(String remarks)
    {
	this.remarks = remarks;
    }

    public CTS_SAFEBOX_TRXVO getCtsSafeboxTrxVO()
    {
	return ctsSafeboxTrxVO;
    }

    public void setCtsSafeboxTrxVO(CTS_SAFEBOX_TRXVO ctsSafeboxTrxVO)
    {
	this.ctsSafeboxTrxVO = ctsSafeboxTrxVO;
    }

    public String getCalculatorType()
    {
	return calculatorType;
    }

    public void setCalculatorType(String calculatorType)
    {
	this.calculatorType = calculatorType;
    }

    public BigDecimal getTotalAmount()
    {
	return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount)
    {
	this.totalAmount = totalAmount;
    }

    public BigDecimal getInsurance_charge()
    {
	return insurance_charge;
    }

    public void setInsurance_charge(BigDecimal insuranceCharge)
    {
	insurance_charge = insuranceCharge;
    }

    public BigDecimal getInsurance_charge_1()
    {
	return insurance_charge_1;
    }

    public void setInsurance_charge_1(BigDecimal insuranceCharge_1)
    {
	insurance_charge_1 = insuranceCharge_1;
    }

    public BigDecimal getInsurance_charge_2()
    {
	return insurance_charge_2;
    }

    public void setInsurance_charge_2(BigDecimal insuranceCharge_2)
    {
	insurance_charge_2 = insuranceCharge_2;
    }

    public String getTradingCurrencyDesc()
    {
	return tradingCurrencyDesc;
    }

    public void setTradingCurrencyDesc(String tradingCurrencyDesc)
    {
	this.tradingCurrencyDesc = tradingCurrencyDesc;
    }

    public String getTfaTrxType()
    {
	return tfaTrxType;
    }

    public void setTfaTrxType(String tfaTrxType)
    {
	this.tfaTrxType = tfaTrxType;
    }

    public BigDecimal getTfaDiscountingMargin()
    {
	return tfaDiscountingMargin;
    }

    public void setTfaDiscountingMargin(BigDecimal tfaDiscountingMargin)
    {
	this.tfaDiscountingMargin = tfaDiscountingMargin;
    }

    public BigDecimal getTfaTrsAmount()
    {
	return tfaTrsAmount;
    }

    public void setTfaTrsAmount(BigDecimal tfaTrsAmount)
    {
	this.tfaTrsAmount = tfaTrsAmount;
    }

    public BigDecimal getTradingCurrency()
    {
	return tradingCurrency;
    }

    public void setTradingCurrency(BigDecimal tradingCurrency)
    {
	this.tradingCurrency = tradingCurrency;
    }

    public BigDecimal getCrossRate()
    {
	return crossRate;
    }

    public void setCrossRate(BigDecimal crossRate)
    {
	this.crossRate = crossRate;
    }

    public BigDecimal getTradingBillAmount()
    {
	return tradingBillAmount;
    }

    public void setTradingBillAmount(BigDecimal tradingBillAmount)
    {
	this.tradingBillAmount = tradingBillAmount;
    }

    public BigDecimal getTotalTradingBillAmount()
    {
	return totalTradingBillAmount;
    }

    public void setTotalTradingBillAmount(BigDecimal totalTradingBillAmount)
    {
	this.totalTradingBillAmount = totalTradingBillAmount;
    }

    public BigDecimal getBillAmount()
    {
	return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount)
    {
	this.billAmount = billAmount;
    }

    public BigDecimal getTotalBillAmount()
    {
	return totalBillAmount;
    }

    public void setTotalBillAmount(BigDecimal totalBillAmount)
    {
	this.totalBillAmount = totalBillAmount;
    }

    /*
     * public BigDecimal getGlobalRate() { return globalRate; }
     * 
     * public void setGlobalRate(BigDecimal globalRate) { this.globalRate =
     * globalRate; }
     */

    public BigDecimal getPrice()
    {
	return price;
    }

    public void setPrice(BigDecimal price)
    {
	this.price = price;
    }

    public BigDecimal getPortfolio_cif()
    {
	return portfolio_cif;
    }

    public void setPortfolio_cif(BigDecimal portfolioCif)
    {
	portfolio_cif = portfolioCif;
    }

    public BigDecimal getPortfolio_seq()
    {
	return portfolio_seq;
    }

    public void setPortfolio_seq(BigDecimal portfolioSeq)
    {
	portfolio_seq = portfolioSeq;
    }

    public String getPortfolio_name()
    {
	return portfolio_name;
    }

    public void setPortfolio_name(String portfolioName)
    {
	portfolio_name = portfolioName;
    }

    public BigDecimal getBROKER_CODE()
    {
	return BROKER_CODE;
    }

    public void setBROKER_CODE(BigDecimal bROKERCODE)
    {
	BROKER_CODE = bROKERCODE;
    }

    public String getBROKER_NAME()
    {
	return BROKER_NAME;
    }

    public void setBROKER_NAME(String bROKERNAME)
    {
	BROKER_NAME = bROKERNAME;
    }

    public String getNidc()
    {
	return nidc;
    }

    public void setNidc(String nidc)
    {
	this.nidc = nidc;
    }

    public String getBills_yn()
    {
	return bills_yn;
    }

    public void setBills_yn(String billsYn)
    {
	bills_yn = billsYn;
    }

    public String getAbiDeal()
    {
	return abiDeal;
    }

    public void setAbiDeal(String abiDeal)
    {
	this.abiDeal = abiDeal;
    }

    public BigDecimal getNoOfBills()
    {
	return noOfBills;
    }

    public void setNoOfBills(BigDecimal noOfBills)
    {
	this.noOfBills = noOfBills;
    }

    public BigDecimal getInWardOutWradTrsNo()
    {
	return inWardOutWradTrsNo;
    }

    public void setInWardOutWradTrsNo(BigDecimal inWardOutWradTrsNo)
    {
	this.inWardOutWradTrsNo = inWardOutWradTrsNo;
    }

    public BigDecimal getLcYear()
    {
	return lcYear;
    }

    public void setLcYear(BigDecimal lcYear)
    {
	this.lcYear = lcYear;
    }

    public BigDecimal getLcNbr()
    {
	return lcNbr;
    }

    public void setLcNbr(BigDecimal lcNbr)
    {
	this.lcNbr = lcNbr;
    }

    public BigDecimal getFacilityNbr()
    {
	return facilityNbr;
    }

    public void setFacilityNbr(BigDecimal facilityNbr)
    {
	this.facilityNbr = facilityNbr;
    }

    public BigDecimal getFacilitySubNo()
    {
	return facilitySubNo;
    }

    public void setFacilitySubNo(BigDecimal facilitySubNo)
    {
	this.facilitySubNo = facilitySubNo;
    }

    public BigDecimal getLcAmount()
    {
	return lcAmount;
    }

    public void setLcAmount(BigDecimal lcAmount)
    {
	this.lcAmount = lcAmount;
    }

    public BigDecimal getLcCurrency()
    {
	return lcCurrency;
    }

    public void setLcCurrency(BigDecimal lcCurrency)
    {
	this.lcCurrency = lcCurrency;
    }

    public BigDecimal getCurrency()
    {
	return currency;
    }

    public void setCurrency(BigDecimal currency)
    {
	this.currency = currency;
    }

    public BigDecimal getUnutilizedFacilityAmt()
    {
	return unutilizedFacilityAmt;
    }

    public void setUnutilizedFacilityAmt(BigDecimal unutilizedFacilityAmt)
    {
	this.unutilizedFacilityAmt = unutilizedFacilityAmt;
    }

    public BigDecimal getDealNidc()
    {
	return dealNidc;
    }

    public void setDealNidc(BigDecimal dealNidc)
    {
	this.dealNidc = dealNidc;
    }

    public String getGridsize()
    {
	return gridsize;
    }

    public void setGridsize(String gridsize)
    {
	this.gridsize = gridsize;
    }

    public String getPriceUserTypedYN()
    {
	return priceUserTypedYN;
    }

    public void setPriceUserTypedYN(String priceUserTypedYN)
    {
	this.priceUserTypedYN = priceUserTypedYN;
    }

    public TRSDEAL_NIDCVO getTrsdealNIDCVO()
    {
	return trsdealNIDCVO;
    }

    public void setTrsdealNIDCVO(TRSDEAL_NIDCVO trsdealNIDCVO)
    {
	this.trsdealNIDCVO = trsdealNIDCVO;
    }

    public List<TRSDEAL_NIDC_COUPON_PYMNTVO> getTrsdealNIDCCoupPaymtVOList()
    {
	return trsdealNIDCCoupPaymtVOList;
    }

    public void setTrsdealNIDCCoupPaymtVOList(List<TRSDEAL_NIDC_COUPON_PYMNTVO> trsdealNIDCCoupPaymtVOList)
    {
	this.trsdealNIDCCoupPaymtVOList = trsdealNIDCCoupPaymtVOList;
    }

    public List<TRSDEAL_NIDC_DETVO> getTrsdealNIDCDETVOList()
    {
	return trsdealNIDCDETVOList;
    }

    public void setTrsdealNIDCDETVOList(List<TRSDEAL_NIDC_DETVO> trsdealNIDCDETVOList)
    {
	this.trsdealNIDCDETVOList = trsdealNIDCDETVOList;
    }

    public String getHideRateYn()
    {
	return hideRateYn;
    }

    public void setHideRateYn(String hideRateYn)
    {
	this.hideRateYn = hideRateYn;
    }

    public BigDecimal getPeriodicityNbr()
    {
	return periodicityNbr;
    }

    public void setPeriodicityNbr(BigDecimal periodicityNbr)
    {
	this.periodicityNbr = periodicityNbr;
    }

    public BigDecimal getDefaultedFloatingRate()
    {
	return defaultedFloatingRate;
    }

    public void setDefaultedFloatingRate(BigDecimal defaultedFloatingRate)
    {
	this.defaultedFloatingRate = defaultedFloatingRate;
    }

    public BigDecimal getFacilityBranch()
    {
	return facilityBranch;
    }

    public void setFacilityBranch(BigDecimal facilityBranch)
    {
	this.facilityBranch = facilityBranch;
    }

    public String getTfaLinkYn()
    {
	return tfaLinkYn;
    }

    public void setTfaLinkYn(String tfaLinkYn)
    {
	this.tfaLinkYn = tfaLinkYn;
    }

    public String getMode()
    {
	return mode;
    }

    public void setMode(String mode)
    {
	this.mode = mode;
    }

    public String getColumnName()
    {
	return columnName;
    }

    public void setColumnName(String columnName)
    {
	this.columnName = columnName;
    }

    public String getInterestCalculationMethod()
    {
	return interestCalculationMethod;
    }

    public void setInterestCalculationMethod(String interestCalculationMethod)
    {
	this.interestCalculationMethod = interestCalculationMethod;
    }

    public BigDecimal getTfaBillAmount()
    {
	return tfaBillAmount;
    }

    public void setTfaBillAmount(BigDecimal tfaBillAmount)
    {
	this.tfaBillAmount = tfaBillAmount;
    }

    public String getPeriodicityType()
    {
	return periodicityType;
    }

    public void setPeriodicityType(String periodicityType)
    {
	this.periodicityType = periodicityType;
    }

    public BigDecimal getFacilitySubLineNbr()
    {
	return facilitySubLineNbr;
    }

    public void setFacilitySubLineNbr(BigDecimal facilitySubLineNbr)
    {
	this.facilitySubLineNbr = facilitySubLineNbr;
    }

    public void setLinkTypeList(List linkTypeList)
    {
	this.linkTypeList = linkTypeList;
    }

    public List getLinkTypeList()
    {
	return linkTypeList;
    }

    public BigDecimal getXirrWithCharges()
    {
	return xirrWithCharges;
    }

    public void setXirrWithCharges(BigDecimal xirrWithCharges)
    {
	this.xirrWithCharges = xirrWithCharges;
    }

    public TRSPAYPLAN_CALCULATORVO getTrsPayPlanCalculatorVO()
    {
	return trsPayPlanCalculatorVO;
    }

    public void setTrsPayPlanCalculatorVO(TRSPAYPLAN_CALCULATORVO trsPayPlanCalculatorVO)
    {
	this.trsPayPlanCalculatorVO = trsPayPlanCalculatorVO;
    }

    public List<TRSDEALCHARGES_CALCULATORVO> getTrsdealChargesCalculatorVOlist()
    {
	return trsdealChargesCalculatorVOlist;
    }

    public void setTrsdealChargesCalculatorVOlist(List<TRSDEALCHARGES_CALCULATORVO> trsdealChargesCalculatorVOlist)
    {
	this.trsdealChargesCalculatorVOlist = trsdealChargesCalculatorVOlist;
    }

    public List<TrsdealCustGuarLiabilitiesListCO> getTrsdealCustGuarLiabilitiesListCO()
    {
	return trsdealCustGuarLiabilitiesListCO;
    }

    public void setTrsdealCustGuarLiabilitiesListCO(
	    List<TrsdealCustGuarLiabilitiesListCO> trsdealCustGuarLiabilitiesListCO)
    {
	this.trsdealCustGuarLiabilitiesListCO = trsdealCustGuarLiabilitiesListCO;
    }

    public List<TRSDEAL_BALLOON_CALCVO> getTrsDealBalloonCalcVOlist()
    {
	return trsDealBalloonCalcVOlist;
    }

    public void setTrsDealBalloonCalcVOlist(List<TRSDEAL_BALLOON_CALCVO> trsDealBalloonCalcVOlist)
    {
	this.trsDealBalloonCalcVOlist = trsDealBalloonCalcVOlist;
    }

    public List<TRSPAYPLAN_CRITERIA_CALCVO> getTrsPayplanCriteriaVOlist()
    {
	return trsPayplanCriteriaVOlist;
    }

    public void setTrsPayplanCriteriaVOlist(List<TRSPAYPLAN_CRITERIA_CALCVO> trsPayplanCriteriaVOlist)
    {
	this.trsPayplanCriteriaVOlist = trsPayplanCriteriaVOlist;
    }

    public List<TRS_PROJECT_SCHEDULE_CALCVO> getTrsProjectScheduleCalcVOList()
    {
	return trsProjectScheduleCalcVOList;
    }

    public void setTrsProjectScheduleCalcVOList(List<TRS_PROJECT_SCHEDULE_CALCVO> trsProjectScheduleCalcVOList)
    {
	this.trsProjectScheduleCalcVOList = trsProjectScheduleCalcVOList;
    }

    public List<TRSPAYPLAN_CRITERIA_TENT_CALCVO> getCriteriaTentativeCalcVOList()
    {
	return criteriaTentativeCalcVOList;
    }

    public void setCriteriaTentativeCalcVOList(List<TRSPAYPLAN_CRITERIA_TENT_CALCVO> criteriaTentativeCalcVOList)
    {
	this.criteriaTentativeCalcVOList = criteriaTentativeCalcVOList;
    }

    public List<HedgeCalcContributorCO> getHedgeCalcCOList()
    {
	return hedgeCalcCOList;
    }

    public void setHedgeCalcCOList(List<HedgeCalcContributorCO> hedgeCalcCOList)
    {
	this.hedgeCalcCOList = hedgeCalcCOList;
    }

    public String getEodProductClassName()
    {
	return eodProductClassName;
    }

    public void setEodProductClassName(String eodProductClassName)
    {
	this.eodProductClassName = eodProductClassName;
    }

    public BigDecimal getEodLentAmount()
    {
	return eodLentAmount;
    }

    public void setEodLentAmount(BigDecimal eodLentAmount)
    {
	this.eodLentAmount = eodLentAmount;
    }

    public BigDecimal getCfTfValue()
    {
	return cfTfValue;
    }

    public void setCfTfValue(BigDecimal cfTfValue)
    {
	this.cfTfValue = cfTfValue;
    }

    public BigDecimal getCfMaturityAmount()
    {
	return cfMaturityAmount;
    }

    public void setCfMaturityAmount(BigDecimal cfMaturityAmount)
    {
	this.cfMaturityAmount = cfMaturityAmount;
    }

    public BigDecimal getCfProfitFx()
    {
	return cfProfitFx;
    }

    public void setCfProfitFx(BigDecimal cfProfitFx)
    {
	this.cfProfitFx = cfProfitFx;
    }

    public BigDecimal getCfProftAct()
    {
	return cfProftAct;
    }

    public void setCfProftAct(BigDecimal cfProftAct)
    {
	this.cfProftAct = cfProftAct;
    }

    public BigDecimal getCfEffYield()
    {
	return cfEffYield;
    }

    public void setCfEffYield(BigDecimal cfEffYield)
    {
	this.cfEffYield = cfEffYield;
    }

    public String getAccrualBasisDesc()
    {
	return accrualBasisDesc;
    }

    public void setAccrualBasisDesc(String accrualBasisDesc)
    {
	this.accrualBasisDesc = accrualBasisDesc;
    }

    public BigDecimal getFaceValue()
    {
	return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue)
    {
	this.faceValue = faceValue;
    }

    public String getIssueType()
    {
	return issueType;
    }

    public void setIssueType(String issueType)
    {
	this.issueType = issueType;
    }

    public String getCouponPaymentType()
    {
	return couponPaymentType;
    }

    public void setCouponPaymentType(String couponPaymentType)
    {
	this.couponPaymentType = couponPaymentType;
    }

    public List<TRSPAYPLAN_NIDC_DET_CALCVO> getTrspaypalnNIDCdetVOList()
    {
	return trspaypalnNIDCdetVOList;
    }

    public void setTrspaypalnNIDCdetVOList(List<TRSPAYPLAN_NIDC_DET_CALCVO> trspaypalnNIDCdetVOList)
    {
	this.trspaypalnNIDCdetVOList = trspaypalnNIDCdetVOList;
    }

    public List<TRSPAYPLAN_NIDC_COUPON_PYMVO> getTrspaypalnNIDCCoupPaymtVOList()
    {
	return trspaypalnNIDCCoupPaymtVOList;
    }

    public void setTrspaypalnNIDCCoupPaymtVOList(List<TRSPAYPLAN_NIDC_COUPON_PYMVO> trspaypalnNIDCCoupPaymtVOList)
    {
	this.trspaypalnNIDCCoupPaymtVOList = trspaypalnNIDCCoupPaymtVOList;
    }

    public BigDecimal getNoofCertificates()
    {
	return noofCertificates;
    }

    public void setNoofCertificates(BigDecimal noofCertificates)
    {
	this.noofCertificates = noofCertificates;
    }

    public BigDecimal getRefNo()
    {
	return refNo;
    }

    public void setRefNo(BigDecimal refNo)
    {
	this.refNo = refNo;
    }

    public TrsdealNidcCO getTrsdealNidcCO()
    {
	return trsdealNidcCO;
    }

    public void setTrsdealNidcCO(TrsdealNidcCO trsdealNidcCO)
    {
	this.trsdealNidcCO = trsdealNidcCO;
    }

    public List<TrsDealSettlementChargesCO> getTrsDealSettlementChargesCO()
    {
	return trsDealSettlementChargesCO;
    }

    public void setTrsDealSettlementChargesCO(List<TrsDealSettlementChargesCO> trsDealSettlementChargesCO)
    {
	this.trsDealSettlementChargesCO = trsDealSettlementChargesCO;
    }

    public String getCalledFrom()
    {
	return calledFrom;
    }

    public void setCalledFrom(String calledFrom)
    {
	this.calledFrom = calledFrom;
    }

    public LOSmessagesCO getLosMessagesCO()
    {
	return losMessagesCO;
    }

    public void setLosMessagesCO(LOSmessagesCO losMessagesCO)
    {
	this.losMessagesCO = losMessagesCO;
    }

    public List<LOSmessagesCO> getLosMessagesCOList()
    {
	return losMessagesCOList;
    }

    public void setLosMessagesCOList(List<LOSmessagesCO> losMessagesCOList)
    {
	this.losMessagesCOList = losMessagesCOList;
    }

    public BigDecimal getRepaymentCriteriaRowCount()
    {
	return repaymentCriteriaRowCount;
    }

    public void setRepaymentCriteriaRowCount(BigDecimal repaymentCriteriaRowCount)
    {
	this.repaymentCriteriaRowCount = repaymentCriteriaRowCount;
    }

    public String getFlexiPaymentYn()
    {
	return flexiPaymentYn;
    }

    public void setFlexiPaymentYn(String flexiPaymentYn)
    {
	this.flexiPaymentYn = flexiPaymentYn;
    }

    public BigDecimal getFlexiPaymentsMonth()
    {
	return flexiPaymentsMonth;
    }

    public void setFlexiPaymentsMonth(BigDecimal flexiPaymentsMonth)
    {
	this.flexiPaymentsMonth = flexiPaymentsMonth;
    }

    public String getAllowFlexiPaymentsYN()
    {
	return allowFlexiPaymentsYN;
    }

    public void setAllowFlexiPaymentsYN(String allowFlexiPaymentsYN)
    {
	this.allowFlexiPaymentsYN = allowFlexiPaymentsYN;
    }

    public String getDealType()
    {
	return dealType;
    }

    public void setDealType(String dealType)
    {
	this.dealType = dealType;
    }

    public TRS_TOP_UP_DEAL_DETVO getTrsTopUpDealDetVO()
    {
	return trsTopUpDealDetVO;
    }

    public void setTrsTopUpDealDetVO(TRS_TOP_UP_DEAL_DETVO trsTopUpDealDetVO)
    {
	this.trsTopUpDealDetVO = trsTopUpDealDetVO;
    }

    public TRS_TOP_UP_DEALVO getTrsTopUpDealVO()
    {
	return trsTopUpDealVO;
    }

    public void setTrsTopUpDealVO(TRS_TOP_UP_DEALVO trsTopUpDealVO)
    {
	this.trsTopUpDealVO = trsTopUpDealVO;
    }

    public BigDecimal getOutstandingPrnicipal()
    {
	return outstandingPrnicipal;
    }

    public void setOutstandingPrnicipal(BigDecimal outstandingPrnicipal)
    {
	this.outstandingPrnicipal = outstandingPrnicipal;
    }

    public BigDecimal getOutstandingInstallment()
    {
	return outstandingInstallment;
    }

    public void setOutstandingInstallment(BigDecimal outstandingInstallment)
    {
	this.outstandingInstallment = outstandingInstallment;
    }

    public Date getDealDate()
    {
	return dealDate;
    }

    public void setDealDate(Date dealDate)
    {
	this.dealDate = dealDate;
    }

    public BigDecimal getDealCY()
    {
	return dealCY;
    }

    public void setDealCY(BigDecimal dealCY)
    {
	this.dealCY = dealCY;
    }

    public String getTopUpDealSelYN()
    {
	return topUpDealSelYN;
    }

    public void setTopUpDealSelYN(String topUpDealSelYN)
    {
	this.topUpDealSelYN = topUpDealSelYN;
    }

    public String getTopUpGridData()
    {
	return topUpGridData;
    }

    public void setTopUpGridData(String topUpGridData)
    {
	this.topUpGridData = topUpGridData;
    }

    public List<IslamicCalculatorEventMgmtCO> getTopUpGridList()
    {
	return topUpGridList;
    }

    public void setTopUpGridList(List<IslamicCalculatorEventMgmtCO> topUpGridList)
    {
	this.topUpGridList = topUpGridList;
    }

    public BigDecimal getNetCreditToCustomer()
    {
	return netCreditToCustomer;
    }

    public void setNetCreditToCustomer(BigDecimal netCreditToCustomer)
    {
	this.netCreditToCustomer = netCreditToCustomer;
    }

    public TRS_BUY_OUT_DEALVO getTrsBuyOutDealVO()
    {
	return trsBuyOutDealVO;
    }

    public void setTrsBuyOutDealVO(TRS_BUY_OUT_DEALVO trsBuyOutDealVO)
    {
	this.trsBuyOutDealVO = trsBuyOutDealVO;
    }

    public String getNewDealCYDesc()
    {
	return newDealCYDesc;
    }

    public void setNewDealCYDesc(String newDealCYDesc)
    {
	this.newDealCYDesc = newDealCYDesc;
    }

    public String getTopUpJasonData()
    {
	return topUpJasonData;
    }

    public void setTopUpJasonData(String topUpJasonData)
    {
	this.topUpJasonData = topUpJasonData;
    }

    public String getReloadflag()
    {
	return reloadflag;
    }

    public void setReloadflag(String reloadflag)
    {
	this.reloadflag = reloadflag;
    }

    public BigDecimal getTransactioNo()
    {
	return transactioNo;
    }

    public void setTransactioNo(BigDecimal transactioNo)
    {
	this.transactioNo = transactioNo;
    }

    public BigDecimal getOutStandingTopUpCy()
    {
	return outStandingTopUpCy;
    }

    public void setOutStandingTopUpCy(BigDecimal outStandingTopUpCy)
    {
	this.outStandingTopUpCy = outStandingTopUpCy;
    }

    public TRSDEALVO getTrsdealVO()
    {
	return trsdealVO;
    }

    public void setTrsdealVO(TRSDEALVO trsdealVO)
    {
	this.trsdealVO = trsdealVO;
    }

    public TRSDEAL2VO getTrsdeal2VO()
    {
	return trsdeal2VO;
    }

    public void setTrsdeal2VO(TRSDEAL2VO trsdeal2VO)
    {
	this.trsdeal2VO = trsdeal2VO;
    }

    public String getAPPLY_FIX_RATE()
    {
	return APPLY_FIX_RATE;
    }

    public void setAPPLY_FIX_RATE(String aPPLY_FIX_RATE)
    {
	APPLY_FIX_RATE = aPPLY_FIX_RATE;
    }

    public String getIBOR_PERIODICITY_TYPE_OLD()
    {
	return IBOR_PERIODICITY_TYPE_OLD;
    }

    public void setIBOR_PERIODICITY_TYPE_OLD(String iBOR_PERIODICITY_TYPE_OLD)
    {
	IBOR_PERIODICITY_TYPE_OLD = iBOR_PERIODICITY_TYPE_OLD;
    }

    public BigDecimal getIBOR_PERIODICITY_NUMBER_OLD()
    {
	return IBOR_PERIODICITY_NUMBER_OLD;
    }

    public void setIBOR_PERIODICITY_NUMBER_OLD(BigDecimal iBOR_PERIODICITY_NUMBER_OLD)
    {
	IBOR_PERIODICITY_NUMBER_OLD = iBOR_PERIODICITY_NUMBER_OLD;
    }

    public BigDecimal getTotalExstInstAmt()
    {
	return totalExstInstAmt;
    }

    public void setTotalExstInstAmt(BigDecimal totalExstInstAmt)
    {
	this.totalExstInstAmt = totalExstInstAmt;
    }

    public String getCalledByJSTriggerYN()
    {
	return calledByJSTriggerYN;
    }

    public void setCalledByJSTriggerYN(String calledByJSTriggerYN)
    {
	this.calledByJSTriggerYN = calledByJSTriggerYN;
    }

    public String[] getParamList()
    {
	return paramList;
    }

    public void setParamList(String[] paramList)
    {
	this.paramList = paramList;
    }

    public BigDecimal getTradeDealNo()
    {
	return tradeDealNo;
    }

    public void setTradeDealNo(BigDecimal tradeDealNo)
    {
	this.tradeDealNo = tradeDealNo;
    }

    public List<ReportResponseCO> getReportResponseCOList()
    {
	return reportResponseCOList;
    }

    public void setReportResponseCOList(List<ReportResponseCO> reportResponseCOList)
    {
	this.reportResponseCOList = reportResponseCOList;
    }

    public List<TRSPAYPLAN_BREAKUP_PROFITVO> getTrspayplan_BREAKUP_PROFITVs()
    {
	return trspayplan_BREAKUP_PROFITVs;
    }

    public void setTrspayplan_BREAKUP_PROFITVs(List<TRSPAYPLAN_BREAKUP_PROFITVO> trspayplan_BREAKUP_PROFITVs)
    {
	this.trspayplan_BREAKUP_PROFITVs = trspayplan_BREAKUP_PROFITVs;
    }

//TP 795449 Srikumar [START]
    public Date getNewDate()
    {
	return newDate;
    }

    public void setNewDate(Date newDate)
    {
	this.newDate = newDate;
    }
//TP 795449 Srikumar [END]

    public String getAPPLY_TEG_YN()
    {
	return APPLY_TEG_YN;
    }

    public void setAPPLY_TEG_YN(String aPPLY_TEG_YN)
    {
	APPLY_TEG_YN = aPPLY_TEG_YN;
    }

    public BigDecimal getTeg()
    {
	return teg;
    }

    public void setTeg(BigDecimal teg)
    {
	this.teg = teg;
    }

    public String getExemptedFromVatYn()
    {
	return exemptedFromVatYn;
    }

    public void setExemptedFromVatYn(String exemptedFromVatYn)
    {
	this.exemptedFromVatYn = exemptedFromVatYn;
    }

    public BigDecimal getVatExemptionCertificateNo()
    {
	return vatExemptionCertificateNo;
    }

    public void setVatExemptionCertificateNo(BigDecimal vatExemptionCertificateNo)
    {
	this.vatExemptionCertificateNo = vatExemptionCertificateNo;
    }

    public Date getVatExemptionExpiryDate()
    {
	return vatExemptionExpiryDate;
    }

    public void setVatExemptionExpiryDate(Date vatExemptionExpiryDate)
    {
	this.vatExemptionExpiryDate = vatExemptionExpiryDate;
    }

    public BigDecimal getCustomerRate()
    {
	return customerRate;
    }

    public void setCustomerRate(BigDecimal customerRate)
    {
	this.customerRate = customerRate;
    }

    public BigDecimal getGovtRate()
    {
	return govtRate;
    }

    public void setGovtRate(BigDecimal govtRate)
    {
	this.govtRate = govtRate;
    }
    
    public BigDecimal getAprRate() {
		return aprRate;
	}

	public void setAprRate(BigDecimal aprRate) {
		this.aprRate = aprRate;
	}

    public BigDecimal getFacilityDrowdown()
    {
	return facilityDrowdown;
    }

    public void setFacilityDrowdown(BigDecimal facilityDrowdown)
    {
	this.facilityDrowdown = facilityDrowdown;
    }

    public String getDrawDownDiscription()
    {
	return drawDownDiscription;
    }

    public void setDrawDownDiscription(String drawDownDiscription)
    {
	this.drawDownDiscription = drawDownDiscription;
    }

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

	public BigDecimal getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(BigDecimal reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getReasonDesc() {
		return reasonDesc;
	}

	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

	public String getCifBlackListRestrictionBriefDescription() {
		return cifBlackListRestrictionBriefDescription;
	}

	public void setCifBlackListRestrictionBriefDescription(String cifBlackListRestrictionBriefDescription) {
		this.cifBlackListRestrictionBriefDescription = cifBlackListRestrictionBriefDescription;
	}

	public BigDecimal getCifBlackListRestrictionSourceCode() {
		return cifBlackListRestrictionSourceCode;
	}

	public void setCifBlackListRestrictionSourceCode(BigDecimal cifBlackListRestrictionSourceCode) {
		this.cifBlackListRestrictionSourceCode = cifBlackListRestrictionSourceCode;
	}

	public String getValidateBlackListRestriction() {
		return validateBlackListRestriction;
	}

	public void setValidateBlackListRestriction(String validateBlackListRestriction) {
		this.validateBlackListRestriction = validateBlackListRestriction;
	}

	public CifBlackListRestrictCO getCifBlackListRestrictCO() {
		return cifBlackListRestrictCO;
	}

	public void setCifBlackListRestrictCO(CifBlackListRestrictCO cifBlackListRestrictCO) {
		this.cifBlackListRestrictCO = cifBlackListRestrictCO;
	}

	public ReportResponseCO getReportResponseCO() {
		return reportResponseCO;
	}

	public void setReportResponseCO(ReportResponseCO reportResponseCO) {
		this.reportResponseCO = reportResponseCO;
	}
	
	public BigDecimal getDownPaymentToVendor()
    {
	return downPaymentToVendor;
    }

    public void setDownPaymentToVendor(BigDecimal downPaymentToVendor)
    {
	this.downPaymentToVendor = downPaymentToVendor;
    }

    public BigDecimal getDownPaymentToVendorPerc()
    {
	return downPaymentToVendorPerc;
    }

    public void setDownPaymentToVendorPerc(BigDecimal downPaymentToVendorPerc)
    {
	this.downPaymentToVendorPerc = downPaymentToVendorPerc;
    }

    public BigDecimal getTotalDownPayment()
    {
	return totalDownPayment;
    }

    public void setTotalDownPayment(BigDecimal totalDownPayment)
    {
	this.totalDownPayment = totalDownPayment;
    }

    public BigDecimal getTotalDownPaymentPerc()
    {
	return totalDownPaymentPerc;
    }

    public void setTotalDownPaymentPerc(BigDecimal totalDownPaymentPerc)
    {
	this.totalDownPaymentPerc = totalDownPaymentPerc;
    }

    public String getCrud()
    {
        return crud;
    }

    public void setCrud(String crud)
    {
        this.crud = crud;
    }

    public String getErrorType()
    {
        return errorType;
    }

    public void setErrorType(String errorType)
    {
        this.errorType = errorType;
    }

    public String getErrorDescription()
    {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription)
    {
        this.errorDescription = errorDescription;
    }

    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }
}