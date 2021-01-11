package com.path.vo.common.iis.islamiccalculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSDEAL3VO;
import com.path.dbmaps.vo.TRSDEALCHARGESVO;
import com.path.dbmaps.vo.TRSDEALVO;
import com.path.dbmaps.vo.TRSDEAL_ASSET_VNDR_INCENTIVEVO;
import com.path.dbmaps.vo.TRSDEAL_MULTIPLE_YIELDVO;
import com.path.dbmaps.vo.TRSDEAL_NIDCVO;
import com.path.dbmaps.vo.TRSDEAL_NIDC_COUPON_PYMNTVO;
import com.path.dbmaps.vo.TRSDEAL_NIDC_DETVO;
import com.path.dbmaps.vo.TRSPAYPLAN_BREAKUP_PROFITVO;
import com.path.dbmaps.vo.TRSPAYPLAN_SEGMENT_START_DATESVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;

public class IslamicCalculatorCO extends BaseVO implements Serializable
{
    private BigDecimal companyCode;
    private BigDecimal BranchCode;
    private BigDecimal productClassCode;
    private BigDecimal dealCurrency;
    private Long dealCyDecimalPoint = 2L;
    private Long dealCyPtMethod = 360L;
    private BigDecimal dealAmount = BigDecimal.ZERO;
    private Date valueDate;
    private Date maturityDate;
    private BigDecimal annualYield = BigDecimal.ZERO;
    private BigDecimal maxYeild = BigDecimal.ZERO;
    private BigDecimal minYeild = BigDecimal.ZERO;
    private String profitCalculationMethod = "S";
    private String profitRecognitionMethod = "S";
    private String compudingDealPeriod = ConstantsCommon.NO;
    private String compoudingGracePeriod = ConstantsCommon.NO;
    private Long profitAccrualBasis = 1L;
    private BigDecimal templateCode = BigDecimal.ZERO;
    private Date firstPaymentDate;
    private BigDecimal noOfPayments = BigDecimal.ONE;
    private String paymentPeriodicity = "D";
    private Long paymentPeriodicityNo = 1L;
    private String paymentPeriodicityMonthPos = "E";
    private String residualValue = "L";
    private BigDecimal amountPerPayment = BigDecimal.ZERO;
    private BigDecimal amountPerPaymentEqualDisbur = BigDecimal.ZERO;
    private Long roundingFactor = 0L;
    private String ROUNDING_TYPE_INST_AMT = "R";

    private String principalInLastPayment = ConstantsCommon.NO;
    private String tentativeSchedule = ConstantsCommon.NO;
    private String outstandingPrincipalAsInstallment = ConstantsCommon.NO;
    private Date outstandingPrincipalInstallmentDate;
    private String equalInstallmentForDisbursement;
    private String equalSegments = ConstantsCommon.NO;
    private String capitalization = ConstantsCommon.NO;
    private Date capitalizationStartOn;
    private String capitalizePeriodicity = "D";
    private Long capitalizePeriodicityNo;
    private String capitalizePeriodicityNopos = "E";
    private Long compoundingProfitPeriodicityNo = 1l;
    private Long capitalizePeriodicitySetDay;
    private String confirmationMessageId;
    private String confirmationMessageId2;
    private String rescheduleType = "";
    private String rescheduleYn = "false";
    private String revaluationProcess = ConstantsCommon.NO;
    private String rescheduleForLateSettlementYn = ConstantsCommon.NO;
    private String adjustNoOfPaymentsBasedOnAmtPerPaymentsYn = ConstantsCommon.NO;

    // ABSAI190381 -GAB170029 copied from 14.0.1
    private String ALLOW_RESCHEDULE_AFTER_REVALUATION_WITH_PAST_DUE_AMOUNT = "N";

    private BigDecimal outstandingProfit = BigDecimal.ZERO;
    private BigDecimal additionalProfit = BigDecimal.ZERO;

    private BigDecimal profitCollected = BigDecimal.ZERO;
    private BigDecimal profitOnCharges = BigDecimal.ZERO;
    private BigDecimal profitOnInsurance = BigDecimal.ZERO;
    private BigDecimal totalCharges = BigDecimal.ZERO;
    private BigDecimal totalInsurance = BigDecimal.ZERO;
    private BigDecimal paymentSetDay;
    private BigDecimal dealNo;
    private String IncludeInstallmentDateInProfitCalculation = ConstantsCommon.NO;
    private String redusingBalanceMethod = ConstantsCommon.NO;
    private String payProfitAndChargesOnly;
    private String calendarType = "G";
    private String hijriDate;
    private BigDecimal avgDaysInYearsForProfitCalculation;
    private Integer changeEffectLineNo;
    private BigDecimal totalBalloonAmount = BigDecimal.ZERO;
    private BigDecimal balloonPayment = BigDecimal.ZERO;
    private BigDecimal noOfBaloonPayments = BigDecimal.ZERO;
    private String profitCalculateAsOnYieldDate = ConstantsCommon.NO;
    private String multipleYieldEqualiseFromValueDate;
    private String lastInstallmentOnMaturityDate;
    private Date nextProfitValueDate;
    private Date nextDisbursementDate;
    private String compoundingProfit = ConstantsCommon.NO;
    private BigDecimal totalGracePeriodCompundingProfit;
    private String PLAN_EDIT_SCHEDULE_DETAILS_YN = ConstantsCommon.NO;
    private String callingFromOnchangeYn = "N";
    private String onchangeColumnName = "";
    private String onchangeNewType = "";
    private Date onchangeNewDate = null;
    private BigDecimal onchangeNewAmount = BigDecimal.ZERO;
    private BigDecimal onchangeLineNbr = BigDecimal.ZERO;

    private Date installmentCommentsDate;
    private List<TrsPlanBallonPaymentCO> trsPlanBallonPaymentCO;
    private List<TrspayplandetCO> trspayplandetVOList = new ArrayList<TrspayplandetCO>();
    private List<TrspayplandetCO> trspayplandetCompoundingDealPeriod = new ArrayList<TrspayplandetCO>();
    private List<TrspayplandetCO> trspayplandetCompoundingGracePeriod = new ArrayList<TrspayplandetCO>();
    private List<TrsDealChargesCO> trsdealchargesVO;
    private List<TRSDEAL_MULTIPLE_YIELDVO> TrsDealMultipleYieldVO;
    private List<TRSPAYPLAN_SEGMENT_START_DATESVO> TrsPayPlanSegmentStartDatesVO;
    private List<TrspayplanCriteriaCO> TrsPayPlanCriteriaVO;
    private List<TRSDEAL3VO> trsDealMultipleDisbursementList;
    private List<TrsPayPlanDetNetPresentValCO> trsPayPlanDetNPVlist = new ArrayList<TrsPayPlanDetNetPresentValCO>();
    private List<TRSPAYPLAN_BREAKUP_PROFITVO> trspayplan_BREAKUP_PROFITVs = new ArrayList<TRSPAYPLAN_BREAKUP_PROFITVO>();

    private List<TRSDEAL_ASSET_VNDR_INCENTIVEVO> trsdealAssetVendorIncentiveList = new ArrayList<TRSDEAL_ASSET_VNDR_INCENTIVEVO>();

    private String applyRoundingFact_after_calc = ConstantsCommon.NO;
    private String accruakBasisActualDaysYn;
    private String InstAmtInBalloon = ConstantsCommon.NO;
    private String InstAmtInLastBalloon = ConstantsCommon.NO;
    private String compoundingProfitPeriodicity = ConstantsCommon.NO;
    private String segmentAppliedYn = ConstantsCommon.NO;
    private String excessProfitInNextInstallment = ConstantsCommon.YES;
    private String upfrontProduct;
    private BigDecimal holidayAction = BigDecimal.ZERO;
    private String includeVatInInstallment = ConstantsCommon.NO;
    private Long vatCode;
    private Double vatPercentage;
    private String calculateVatAfterSchedule = ConstantsCommon.YES;
    private String vatPercentageOn = "P";
    private Double totalVatAmount = 0D;
    private Double totalAllocatedVatAmount = 0D;
    private String dailyDepreciationYn = ConstantsCommon.NO;
    private BigDecimal xirrOut = BigDecimal.ZERO;
    private BigDecimal xirrWithChargesOut = BigDecimal.ZERO;
    private BigDecimal outRemainingAmount = BigDecimal.ZERO;
    private BigDecimal outProfitAmount = BigDecimal.ZERO;
    private BigDecimal outAmountPerPayment = BigDecimal.ZERO;
    private BigDecimal outSaleAmount = BigDecimal.ZERO;
    private BigDecimal outAnnualFlatRate = BigDecimal.ZERO;
    private BigDecimal outTotalFlatRate = BigDecimal.ZERO;
    private BigDecimal outResidualValueDownPayment = BigDecimal.ZERO;
    private BigDecimal outNoOfPayments = BigDecimal.ZERO;

    private String calculatorType = "CALCULATOR";
    private String showCifIncomeInd;
    private String holidayActionConformationYn = ConstantsCommon.NO;
    private BigDecimal planChargesAmount = BigDecimal.ZERO;
    private BigDecimal planChargesAmountForPrfotCalc = BigDecimal.ZERO;
    private BigDecimal downPaymentAmt = BigDecimal.ZERO;
    private BigDecimal noOfMonths;
    private BigDecimal maxNoOfPayments;
    private String combainedScreen;
    private double currentLineActualProfitAmount;
    private boolean firstLoop;
    private Long dealPeriodCompoundingPeriodicityNo = 1l;
    private String dealPeriodCompoundingPeriodicity = "M";
    private double outstandingAmountForXIRR;
    private BigDecimal previousDealAmount = BigDecimal.ZERO;
    private String disburs_maintain_indiv_plan_yn = ConstantsCommon.NO;
    private BigDecimal mudarabahRateCode = BigDecimal.ZERO;
    private TRSCLASSVO trsclassvo;

    private String lastInstAssetResidualYn;
    private BigDecimal assetResidualAmount;
    private BigDecimal assetResidualprofit;

    private BigDecimal TRSDET_MATR_AC_BR;
    private BigDecimal TRSDET_MATR_AC_CY;
    private BigDecimal TRSDET_MATR_AC_GL;
    private BigDecimal TRSDET_MATR_AC_CIF;
    private BigDecimal TRSDET_MATR_AC_SL;
    private String TRSDET_MATR_AC_BRIEF_NAME_ENG;
    private String AUTO_CREATE_SETTLEMENT;

    private String upfront_profit_yn;
    private BigDecimal upfront_profit_amt;
    private BigDecimal upfront_capital_amt;
    private String ACCRUAL_AMOUNT_TYPE;
    private String PLAN_SHOW_PRINCIPAL_AMOUNT_YN;
    private BigDecimal DEAL_CATEGORY;
    private List<String> confirm_messages = new ArrayList<String>();
    private String nidcDeal = ConstantsCommon.NO;
    private String settlmentType = "";
    private int igoreIfStatement;

    private BigDecimal planNbr;
    private BigDecimal planSeq;
    private String limitReinstateBasedOn;
    private Date originalValueDate;
    private BigDecimal originalDealAmount;
    private BigDecimal firstLineProfitToBeAdjust;
    private BigDecimal prevAnnualYield = BigDecimal.ZERO;
    private String yieldRequiredYn = ConstantsCommon.YES;
    private int dealAmountMachingWithPlanYn = 1;
    private int totalAmountMachingWithPlanYn = 1;
    private int totalCapitalMachingWithPlanYn = 1;
    private Date previousLineValudateForRevaluation;
    private String revaluationProfitAdjustAppliedYn = ConstantsCommon.NO;
    private Boolean disbursementScreen;
    // PMD infractions; Saheer.Naduthodi; 10/12/2014
    private int pushedDownRowExist;
    // Added by Roshin
    private BigDecimal collectedDepreciation;
    private BigDecimal collectedAccrual;
    private BigDecimal writtenOffDepreciationAmount;
    private BigDecimal writeOffAmount;
    private String applyDepreciationDeal;
    private BigDecimal dailyDepreciationOld;
    private BigDecimal totalDepreciationOld;
    private BigDecimal dailyAccrualOld;

    private BigDecimal noOfMonthsOut;
    private String EXCL_PRFT_RECLC_DUE_INST_YN;

    private BigDecimal linkedDealNo;
    private BigDecimal linkedDealPlanNbr;
    private BigDecimal linkedDealPlanSeq;

    private String grace_prd_cmpnd_pft_deal_yn;
    private String limit_reinstate_based_on;
    private BigDecimal idec_outstanding_grace_compounding_pft = BigDecimal.ZERO;

    private String calledFromApp = "IIS";
    private String language = "EN";
    private String dealAmmendmentYn = ConstantsCommon.NO;
    private BigDecimal outupfrontProfitAmt = BigDecimal.ZERO;
    private BigDecimal settledCapital = BigDecimal.ZERO;

    private BigDecimal PLAN_LIBOR_RATE = BigDecimal.ZERO;
    private BigDecimal YIELD = BigDecimal.ZERO;
    private BigDecimal PLAN_EXPECTED_YIELD = BigDecimal.ZERO;
    // TP#244113; Ramesh; Date 09/12/2014
    private BigDecimal totalAllocatedAmount;

    private String calledFromFmsYN = ConstantsCommon.NO;

    private String generate_payplan_based_on = ConstantsCommon.NO;

    private BigDecimal totalFlatRate = BigDecimal.ZERO;

    private String musawamah_yn = ConstantsCommon.NO;

    private BigDecimal calc_max_user_pft_sys_pft_diff = BigDecimal.ZERO;
    
    private String PROFIT_CALC_FOR_DEAL_PERIOD_YN = "N";
    private BigDecimal allocatedProfitAmount = BigDecimal.ZERO;
    

    private BigDecimal calc_max_iter_getyield_frm_pft = BigDecimal.ZERO;

    private BigDecimal sysYield = BigDecimal.TEN;

    private TRSDEALVO trsdealvo = new TRSDEALVO();

    private String fetchDataFromDbYn = ConstantsCommon.YES;
    /**
     * For Ar-Rahnu Calulator; added on 12/06/2015
     */
    private String safeboxchargetype;

    private String arRahnuCalculatorYN = ConstantsCommon.NO;

    private BigDecimal totalSafeBoxCharges = BigDecimal.ZERO;

    /**
     * For Bills Calculator; added on 07/07/2015
     * 
     * @return
     */
    private String tfaTrxType = ConstantsCommon.NO;

    private BigDecimal tfaInwardOutwartTrsNo;

    private String billsCalculatorYn = ConstantsCommon.NO;

    private String pft_calc_based_trade_cy_yn = ConstantsCommon.NO;

    private BigDecimal tradeCurrency;

    private String interest_calculation_method;

    private BigDecimal totalBillAmount;

    private BigDecimal totalNetPrecentValue;

    private BigDecimal billAmount;

    private String calculateMultipleYieldProfitForGracePeriod = "N";

    TRSDEAL_NIDCVO trsdealNIDCVO = new TRSDEAL_NIDCVO();

    List<TRSDEAL_NIDC_DETVO> trsdealNIDCDETVO = new ArrayList<TRSDEAL_NIDC_DETVO>();

    List<TRSDEAL_NIDC_COUPON_PYMNTVO> trsdealNIDC_COUPONPYMNTVOs = new ArrayList<TRSDEAL_NIDC_COUPON_PYMNTVO>();

    /**
     * Added For JAIZ Modification
     */

    private String PRFT_ACCR_ON_OUTSTAND_PRINC_YN;

    private BigDecimal settledFromLineNo;

    private BigDecimal settledToLineNo;
    // #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015 [Start]
    private BigDecimal agencyFeePercentage = BigDecimal.ZERO;
    private String accrueAgencyFeeYn = ConstantsCommon.NO;
    private BigDecimal outstandingAgencyFee;
    // #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015 [End]

    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hmSysParam = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    // EWBI160081; Saheer.Naduthodi; 02/03/2017 [Begin]
    private List<TrsDealSettlementChargesCO> trsdealStlmntChargesList;
    // EWBI160081; Saheer.Naduthodi; 02/03/2017[End]
    // SBI170098 ; Saheer.Naduthodi; 29/11/2017 [Begin]
    private boolean govtPromotedProduct;
    // SBI170098 ; Saheer.Naduthodi; 29/11/2017 [End]
    private BigDecimal orgTotalProfit = BigDecimal.ZERO;
    private BigDecimal orgTotalCharges = BigDecimal.ZERO;
    private BigDecimal orgTotalInsurance = BigDecimal.ZERO;

    // SBI170077 -Round off by Product type and Price of Fixed Income Securities
    private BigDecimal profitAmountRoundingType;

    private BigDecimal additionalProfitMsgCount;
    // LOS integration; Saheer.Naduthodi; 13/12/2017 [Begin]
    private List<LOSmessagesCO> losMessagesCOList;
    private BigDecimal CifNo;
    // LOS integration; Saheer.Naduthodi; 13/12/2017 [End]
    // BB160136; Saheer.Naduthodi; 21/04/2017 [Begin]
    private String flexiPaymentYn = ConstantsCommon.NO;
    private BigDecimal flexiPaymentsMonth;
    // BB160136; Saheer.Naduthodi; 21/04/2017 [End]
    // ICD170039
    private String calledFromIPRSYN = ConstantsCommon.NO;
    private String calledFromFirstLeg = ConstantsCommon.NO;

    private String calledFromDealModifyYN = ConstantsCommon.NO;

    private BigDecimal limitSerialNo;
    private BigDecimal currentLineNo = BigDecimal.valueOf(-1);
    private Date lastSettledValueDate;
    private String revaluationOnSettledInstallmentYn = ConstantsCommon.NO;
    private String skippingProcessYn = ConstantsCommon.NO;
    private String CUSTOM_INSTLMNT_ON_RESCHDUL_YN = ConstantsCommon.NO;
    private BigDecimal profitPerPayment = BigDecimal.ZERO;
    private BigDecimal capitalPerPayment = BigDecimal.ZERO;
    private boolean calledFromCalculator;
    private String APPLY_TEG_YN;
    private BigDecimal teg;
    private String rescheduling_disbursement_capital_due_Yn = "N";

    private BigDecimal balanceAmt;
    private BigDecimal totalSettledAmt;

    private BigDecimal yieldSign = BigDecimal.ZERO;

    private BigDecimal totalChargeAmortization = BigDecimal.ZERO;
    private String takeChargeAmortizationfromDB = ConstantsCommon.YES;
    
    //928504 MFI190194  deepu 13/01/2020
    private String	applyAprRateYn  = ConstantsCommon.NO;
    private BigDecimal	aprRate;
    
    // 772002 - Cross Currency Swaps
    private String calledFromCrossCySwapYN;

    // 845216 Hari.K.S 25/06/2019
    private String informationMessageId;

    // AUBBH170071 deepu.mohandas
    private String ROUND_OFF_CHARGE_YN;
    private String EXCLUDE_INS_BALLOON_YN;
    private String INCLD_UPFRNT_INSU_FOR_REIMB_YN;
    private String EDIT_CHARGE_REIMBURSE_AMT_YN;
    private String ALLOW_CHARGE_FIRST_EMI_YN;

    /** TP#681128-ABEI180001 */
    private BigDecimal capitalizeProfitAmt;
    private BigDecimal chargeDue;
    private String reschCapitalizeType;
    private BigDecimal VENDOR_DISCOUNT_AMOUNT = BigDecimal.ZERO;
    private BigDecimal VENDOR_DISCOUNT_YIELD = BigDecimal.ZERO;
    private BigDecimal NET_YIELD = BigDecimal.ZERO;

    // TP#930596 ; Naseef ; 22/11/2019
    private BigDecimal govtRate;

    // AUBBH170071
    private BigDecimal AMENDMENT_AMOUNT;
    private String AMENDMENT_TYPE;
    private BigDecimal originalNewNoOfPayments;
    private BigDecimal increasedNoofPayment;
    private Date orgMaturityDate;

    private BigDecimal noOfAdvPayments = BigDecimal.ONE;

    // DASI180568 Hari.K.S 06/03/2018
    private String advRepaymentYN = "N";
    private List<TrspayplandetCO> trspayplandetRemAdvPaymentVOList = new ArrayList<TrspayplandetCO>();
    private BigDecimal outstandingVat = BigDecimal.ZERO;


    private BigDecimal firstLineVatToBeAdjust = BigDecimal.ZERO;
    private String vatAccrual = "N";
    private String vatRateChangedYn = "N";
    private String accru_newrate_frm_effect_dt_yn = "N";


    // DN# EWBI160013; deepu.mohandas 25/04/2016
    private BigDecimal floatingRate;
    private String showTegMessages = "N";
    private String chargeCodes;
    private Date runningDate;
    private boolean minYeildReached = false;
    private boolean minChargeReached = false;
    private BigDecimal actualAnnualRate;
    private BigDecimal tieAdjustedAnnualRate;
    private BigDecimal actualTegRate;
    private BigDecimal tieRate;
    private String tegAdjustmentType = "M";
    private String chargeAdjustedForTie = "N";
    private BigDecimal totalSettlementChargesForTeg = BigDecimal.ZERO;
    private List<TRSDEALCHARGESVO> trsdealchargesVOList;
    private List<TRSDEALCHARGESVO> tegAdjustmenttrsdealchargesVOList;
    // DN# EWBI160013; deepu.mohandas END
    private BigDecimal pushedDownProfitAmount;
    private BigDecimal vatMaxAmount;
    private BigDecimal vatMinAmount;
    
    private String EXCLUDE_PASTDUE_AT_RESCHDL_YN;

    /** TP#681128-ABEI180001 end */
    
    // TAR# BAJI200034 Fawas.Kuruvakkottil 27/07/2020
    private BigDecimal advInsuranceAmount;
    private BigDecimal advInsVatAmount;
    
    
    public String getRescheduling_disbursement_capital_due_Yn()
    {
	return rescheduling_disbursement_capital_due_Yn;
    }

    public void setRescheduling_disbursement_capital_due_Yn(String rescheduling_disbursement_capital_due_Yn)
    {
	this.rescheduling_disbursement_capital_due_Yn = rescheduling_disbursement_capital_due_Yn;
    }

    public BigDecimal getTotalSafeBoxCharges()
    {
	return totalSafeBoxCharges;
    }

    public void setTotalSafeBoxCharges(BigDecimal totalSafeBoxCharges)
    {
	this.totalSafeBoxCharges = totalSafeBoxCharges;
    }

    public String getArRahnuCalculatorYN()
    {
	return arRahnuCalculatorYN;
    }

    public void setArRahnuCalculatorYN(String arRahnuCalculatorYN)
    {
	this.arRahnuCalculatorYN = arRahnuCalculatorYN;
    }

    public String getSafeboxchargetype()
    {
	return safeboxchargetype;
    }

    public void setSafeboxchargetype(String safeboxchargetype)
    {
	this.safeboxchargetype = safeboxchargetype;
    }

    public BigDecimal getSysYield()
    {
	return sysYield;
    }

    public void setSysYield(BigDecimal sysYield)
    {
	this.sysYield = sysYield;
    }

    public BigDecimal getCalc_max_user_pft_sys_pft_diff()
    {
	return calc_max_user_pft_sys_pft_diff;
    }

    public void setCalc_max_user_pft_sys_pft_diff(BigDecimal calcMaxUserPftSysPftDiff)
    {
	calc_max_user_pft_sys_pft_diff = calcMaxUserPftSysPftDiff;
    }

    public BigDecimal getCalc_max_iter_getyield_frm_pft()
    {
	return calc_max_iter_getyield_frm_pft;
    }

    public void setCalc_max_iter_getyield_frm_pft(BigDecimal calcMaxIterGetyieldFrmPft)
    {
	calc_max_iter_getyield_frm_pft = calcMaxIterGetyieldFrmPft;
    }

    public String getMusawamah_yn()
    {
	return musawamah_yn;
    }

    public void setMusawamah_yn(String musawamahYn)
    {
	musawamah_yn = musawamahYn;
    }

    public BigDecimal getTotalFlatRate()
    {
	return totalFlatRate;
    }

    public void setTotalFlatRate(BigDecimal totalFlatRate)
    {
	this.totalFlatRate = totalFlatRate;
    }

    public String getGenerate_payplan_based_on()
    {
	return generate_payplan_based_on;
    }

    public void setGenerate_payplan_based_on(String generatePayplanBasedOn)
    {
	generate_payplan_based_on = generatePayplanBasedOn;
    }

    public String getCalledFromFmsYN()
    {
	return calledFromFmsYN;
    }

    public void setCalledFromFmsYN(String calledFromFmsYN)
    {
	this.calledFromFmsYN = calledFromFmsYN;
    }

    // Added by Roshin END
    public BigDecimal getNoOfMonths()
    {
	return noOfMonths;
    }

    public void setNoOfMonths(BigDecimal noOfMonths)
    {
	this.noOfMonths = noOfMonths;
    }

    public String getHolidayActionConformationYn()
    {
	return holidayActionConformationYn;
    }

    public void setHolidayActionConformationYn(String holidayActionConformationYn)
    {
	this.holidayActionConformationYn = holidayActionConformationYn;
    }

    public BigDecimal getHolidayAction()
    {
	return holidayAction;
    }

    public void setHolidayAction(BigDecimal holidayAction)
    {
	this.holidayAction = holidayAction;
    }

    public BigDecimal getOutResidualValueDownPayment()
    {
	return outResidualValueDownPayment;
    }

    public void setOutResidualValueDownPayment(BigDecimal outResidualValueDownPayment)
    {
	this.outResidualValueDownPayment = outResidualValueDownPayment;
    }

    public BigDecimal getOutTotalFlatRate()
    {
	return outTotalFlatRate;
    }

    public void setOutTotalFlatRate(BigDecimal outTotalFlatRate)
    {
	this.outTotalFlatRate = outTotalFlatRate;
    }

    public BigDecimal getOutRemainingAmount()
    {
	return outRemainingAmount;
    }

    public void setOutRemainingAmount(BigDecimal outRemainingAmount)
    {
	this.outRemainingAmount = outRemainingAmount;
    }

    public BigDecimal getOutProfitAmount()
    {
	return outProfitAmount;
    }

    public void setOutProfitAmount(BigDecimal outProfitAmount)
    {
	this.outProfitAmount = outProfitAmount;
    }

    public BigDecimal getOutSaleAmount()
    {
	return outSaleAmount;
    }

    public void setOutSaleAmount(BigDecimal outSaleAmount)
    {
	this.outSaleAmount = outSaleAmount;
    }

    public BigDecimal getOutAnnualFlatRate()
    {
	return outAnnualFlatRate;
    }

    public void setOutAnnualFlatRate(BigDecimal outAnnualFlatRate)
    {
	this.outAnnualFlatRate = outAnnualFlatRate;
    }

    public String getCalculatorType()
    {
	return calculatorType;
    }

    public void setCalculatorType(String calculatorType)
    {
	this.calculatorType = calculatorType;
    }

    public BigDecimal getXirrOut()
    {
	return xirrOut;
    }

    public void setXirrOut(BigDecimal xirrOut)
    {
	this.xirrOut = xirrOut;
    }

    public String getDailyDepreciationYn()
    {
	return dailyDepreciationYn;
    }

    public void setDailyDepreciationYn(String dailyDepreciationYn)
    {
	this.dailyDepreciationYn = dailyDepreciationYn;
    }

    public Double getTotalAllocatedVatAmount()
    {
	return totalAllocatedVatAmount;
    }

    public void setTotalAllocatedVatAmount(Double totalAllocatedVatAmount)
    {
	this.totalAllocatedVatAmount = totalAllocatedVatAmount;
    }

    public Double getTotalVatAmount()
    {
	return totalVatAmount;
    }

    public void setTotalVatAmount(Double totalVatAmount)
    {
	this.totalVatAmount = totalVatAmount;
    }

    public String getVatPercentageOn()
    {
	return vatPercentageOn;
    }

    public void setVatPercentageOn(String vatPercentageOn)
    {
	this.vatPercentageOn = vatPercentageOn;
    }

    public BigDecimal getAnnualYield()
    {
	return annualYield;
    }

    public void setAnnualYield(BigDecimal annualYield)
    {
	this.annualYield = annualYield;
    }

    public String getCalculateVatAfterSchedule()
    {
	return calculateVatAfterSchedule;
    }

    public void setCalculateVatAfterSchedule(String calculateVatAfterSchedule)
    {
	this.calculateVatAfterSchedule = calculateVatAfterSchedule;
    }

    public Long getVatCode()
    {
	return vatCode;
    }

    public Double getVatPercentage()
    {
	return vatPercentage;
    }

    public void setVatCode(Long vatCode)
    {
	this.vatCode = vatCode;
    }

    public void setVatPercentage(Double vatPercentage)
    {
	this.vatPercentage = vatPercentage;
    }

    public String getIncludeVatInInstallment()
    {
	return includeVatInInstallment;
    }

    public void setIncludeVatInInstallment(String includeVatInInstallment)
    {
	this.includeVatInInstallment = includeVatInInstallment;
    }

    public Long getCapitalizePeriodicitySetDay()
    {
	return capitalizePeriodicitySetDay;
    }

    public void setCapitalizePeriodicitySetDay(Long capitalizePeriodicitySetDay)
    {
	this.capitalizePeriodicitySetDay = capitalizePeriodicitySetDay;
    }

    public BigDecimal getCompanyCode()
    {
	return companyCode;
    }

    public void setCompanyCode(BigDecimal companyCode)
    {
	this.companyCode = companyCode;
    }

    public BigDecimal getBranchCode()
    {
	return BranchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	BranchCode = branchCode;
    }

    public BigDecimal getProductClassCode()
    {
	return productClassCode;
    }

    public void setProductClassCode(BigDecimal productClassCode)
    {
	this.productClassCode = productClassCode;
    }

    public BigDecimal getDealCurrency()
    {
	return dealCurrency;
    }

    public void setDealCurrency(BigDecimal dealCurrency)
    {
	this.dealCurrency = dealCurrency;
    }

    public BigDecimal getTemplateCode()
    {
	return templateCode;
    }

    public void setTemplateCode(BigDecimal templateCode)
    {
	this.templateCode = templateCode;
    }

    public Date getFirstPaymentDate()
    {
	return firstPaymentDate;
    }

    public void setFirstPaymentDate(Date firstPaymentDate)
    {
	this.firstPaymentDate = firstPaymentDate;
    }

    public BigDecimal getNoOfPayments()
    {
	return noOfPayments;
    }

    public void setNoOfPayments(BigDecimal noOfPayments)
    {
	this.noOfPayments = noOfPayments;
    }

    public String getPaymentPeriodicity()
    {
	return paymentPeriodicity;
    }

    public void setPaymentPeriodicity(String paymentPeriodicity)
    {
	this.paymentPeriodicity = paymentPeriodicity;
    }

    public Long getPaymentPeriodicityNo()
    {
	return paymentPeriodicityNo;
    }

    public void setPaymentPeriodicityNo(Long paymentPeriodicityNo)
    {
	this.paymentPeriodicityNo = paymentPeriodicityNo;
    }

    public Long getCapitalizePeriodicityNo()
    {
	return capitalizePeriodicityNo;
    }

    public void setCapitalizePeriodicityNo(Long capitalizePeriodicityNo)
    {
	this.capitalizePeriodicityNo = capitalizePeriodicityNo;
    }

    public String getCapitalizePeriodicityNopos()
    {
	return capitalizePeriodicityNopos;
    }

    public void setCapitalizePeriodicityNopos(String capitalizePeriodicityNopos)
    {
	this.capitalizePeriodicityNopos = capitalizePeriodicityNopos;
    }

    public Long getCompoundingProfitPeriodicityNo()
    {
	return compoundingProfitPeriodicityNo;
    }

    public void setCompoundingProfitPeriodicityNo(Long compoundingProfitPeriodicityNo)
    {
	this.compoundingProfitPeriodicityNo = compoundingProfitPeriodicityNo;
    }

    public BigDecimal getDealNo()
    {
	return dealNo;
    }

    public void setDealNo(BigDecimal dealNo)
    {
	this.dealNo = dealNo;
    }

    public String getUpfrontProduct()
    {
	return upfrontProduct;
    }

    public void setUpfrontProduct(String upfrontProduct)
    {
	this.upfrontProduct = upfrontProduct;
    }

    public String getExcessProfitInNextInstallment()
    {
	return excessProfitInNextInstallment;
    }

    public void setExcessProfitInNextInstallment(String excessProfitInNextInstallment)
    {
	this.excessProfitInNextInstallment = excessProfitInNextInstallment;
    }

    public String getSegmentAppliedYn()
    {
	return segmentAppliedYn;
    }

    public void setSegmentAppliedYn(String segmentAppliedYn)
    {
	this.segmentAppliedYn = segmentAppliedYn;
    }

    public String getCompoundingProfitPeriodicity()
    {
	return compoundingProfitPeriodicity;
    }

    public void setCompoundingProfitPeriodicity(String compoundingProfitPeriodicity)
    {
	this.compoundingProfitPeriodicity = compoundingProfitPeriodicity;
    }

    public String getInstAmtInBalloon()
    {
	return InstAmtInBalloon;
    }

    public void setInstAmtInBalloon(String instAmtInBalloon)
    {
	InstAmtInBalloon = instAmtInBalloon;
    }

    public String getInstAmtInLastBalloon()
    {
	return InstAmtInLastBalloon;
    }

    public void setInstAmtInLastBalloon(String instAmtInLastBalloon)
    {
	InstAmtInLastBalloon = instAmtInLastBalloon;
    }

    public String getAccruakBasisActualDaysYn()
    {
	return accruakBasisActualDaysYn;
    }

    public void setAccruakBasisActualDaysYn(String accruakBasisActualDaysYn)
    {
	this.accruakBasisActualDaysYn = accruakBasisActualDaysYn;
    }

    public String getApplyRoundingFact_after_calc()
    {
	return applyRoundingFact_after_calc;
    }

    public void setApplyRoundingFact_after_calc(String applyRoundingFactAfterCalc)
    {
	applyRoundingFact_after_calc = applyRoundingFactAfterCalc;
    }

    public Long getDealCyDecimalPoint()
    {
	return dealCyDecimalPoint;
    }

    public void setDealCyDecimalPoint(Long dealCyDecimalPoint)
    {
	this.dealCyDecimalPoint = dealCyDecimalPoint;
    }

    public Long getDealCyPtMethod()
    {
	return dealCyPtMethod;
    }

    public void setDealCyPtMethod(Long dealCyPtMethod)
    {
	this.dealCyPtMethod = dealCyPtMethod;
    }

    public BigDecimal getDealAmount()
    {
	return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount)
    {
	this.dealAmount = dealAmount;
    }

    public Date getValueDate()
    {
	return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public Date getMaturityDate()
    {
	return maturityDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
	this.maturityDate = maturityDate;
    }

    public BigDecimal getAnnualYeild()
    {
	return annualYield;
    }

    public void setAnnualYeild(BigDecimal annualYeild)
    {
	annualYield = annualYeild;
    }

    public BigDecimal getMaxYeild()
    {
	return maxYeild;
    }

    public void setMaxYeild(BigDecimal maxYeild)
    {
	this.maxYeild = maxYeild;
    }

    public BigDecimal getMinYeild()
    {
	return minYeild;
    }

    public void setMinYeild(BigDecimal minYeild)
    {
	this.minYeild = minYeild;
    }

    public String getProfitCalculationMethod()
    {
	return profitCalculationMethod;
    }

    public void setProfitCalculationMethod(String profitCalculationMethod)
    {
	this.profitCalculationMethod = profitCalculationMethod;
    }

    public String getProfitRecognitionMethod()
    {
	return profitRecognitionMethod;
    }

    public void setProfitRecognitionMethod(String profitRecognitionMethod)
    {
	this.profitRecognitionMethod = profitRecognitionMethod;
    }

    public String getCompudingDealPeriod()
    {
	return compudingDealPeriod;
    }

    public void setCompudingDealPeriod(String compudingDealPeriod)
    {
	this.compudingDealPeriod = compudingDealPeriod;
    }

    public String getCompoudingGracePeriod()
    {
	return compoudingGracePeriod;
    }

    public void setCompoudingGracePeriod(String compoudingGracePeriod)
    {
	this.compoudingGracePeriod = compoudingGracePeriod;
    }

    public Long getProfitAccrualBasis()
    {
	return profitAccrualBasis;
    }

    public void setProfitAccrualBasis(Long profitAccrualBasis)
    {
	this.profitAccrualBasis = profitAccrualBasis;
    }

    public String getPaymentPeriodicityMonthPos()
    {
	return paymentPeriodicityMonthPos;
    }

    public void setPaymentPeriodicityMonthPos(String paymentPeriodicityMonthPos)
    {
	this.paymentPeriodicityMonthPos = paymentPeriodicityMonthPos;
    }

    public String getResidualValue()
    {
	return residualValue;
    }

    public void setResidualValue(String residualValue)
    {
	this.residualValue = residualValue;
    }

    public BigDecimal getAmountPerPayment()
    {
	return amountPerPayment;
    }

    public void setAmountPerPayment(BigDecimal amountPerPayment)
    {
	this.amountPerPayment = amountPerPayment;
    }

    public Long getRoundingFactor()
    {
	return roundingFactor;
    }

    public void setRoundingFactor(Long roundingFactor)
    {
	this.roundingFactor = roundingFactor;
    }

    public String getPrincipalInLastPayment()
    {
	return principalInLastPayment;
    }

    public void setPrincipalInLastPayment(String principalInLastPayment)
    {
	this.principalInLastPayment = principalInLastPayment;
    }

    public String getTentativeSchedule()
    {
	return tentativeSchedule;
    }

    public void setTentativeSchedule(String tentativeSchedule)
    {
	this.tentativeSchedule = tentativeSchedule;
    }

    public String getOutstandingPrincipalAsInstallment()
    {
	return outstandingPrincipalAsInstallment;
    }

    public void setOutstandingPrincipalAsInstallment(String outstandingPrincipalAsInstallment)
    {
	this.outstandingPrincipalAsInstallment = outstandingPrincipalAsInstallment;
    }

    public Date getOutstandingPrincipalInstallmentDate()
    {
	return outstandingPrincipalInstallmentDate;
    }

    public void setOutstandingPrincipalInstallmentDate(Date outstandingPrincipalInstallmentDate)
    {
	this.outstandingPrincipalInstallmentDate = outstandingPrincipalInstallmentDate;
    }

    public String getEqualInstallmentForDisbursement()
    {
	return equalInstallmentForDisbursement;
    }

    public void setEqualInstallmentForDisbursement(String equalInstallmentForDisbursement)
    {
	this.equalInstallmentForDisbursement = equalInstallmentForDisbursement;
    }

    public String getEqualSegments()
    {
	return equalSegments;
    }

    public void setEqualSegments(String equalSegments)
    {
	this.equalSegments = equalSegments;
    }

    public String getCapitalization()
    {
	return capitalization;
    }

    public void setCapitalization(String capitalization)
    {
	this.capitalization = capitalization;
    }

    public Date getCapitalizationStartOn()
    {
	return capitalizationStartOn;
    }

    public void setCapitalizationStartOn(Date capitalizationStartOn)
    {
	this.capitalizationStartOn = capitalizationStartOn;
    }

    public String getCapitalizePeriodicity()
    {
	return capitalizePeriodicity;
    }

    public void setCapitalizePeriodicity(String capitalizePeriodicity)
    {
	this.capitalizePeriodicity = capitalizePeriodicity;
    }

    public BigDecimal getProfitCollected()
    {
	return profitCollected;
    }

    public void setProfitCollected(BigDecimal profitCollected)
    {
	this.profitCollected = profitCollected;
    }

    public BigDecimal getProfitOnCharges()
    {
	return profitOnCharges;
    }

    public void setProfitOnCharges(BigDecimal profitOnCharges)
    {
	this.profitOnCharges = profitOnCharges;
    }

    public BigDecimal getProfitOnInsurance()
    {
	return profitOnInsurance;
    }

    public void setProfitOnInsurance(BigDecimal profitOnInsurance)
    {
	this.profitOnInsurance = profitOnInsurance;
    }

    public BigDecimal getTotalCharges()
    {
	return totalCharges;
    }

    public void setTotalCharges(BigDecimal totalCharges)
    {
	this.totalCharges = totalCharges;
    }

    public BigDecimal getTotalInsurance()
    {
	return totalInsurance;
    }

    public void setTotalInsurance(BigDecimal totalInsurance)
    {
	this.totalInsurance = totalInsurance;
    }

    public BigDecimal getPaymentSetDay()
    {
	return paymentSetDay;
    }

    public void setPaymentSetDay(BigDecimal paymentSetDay)
    {
	this.paymentSetDay = paymentSetDay;
    }

    public String getIncludeInstallmentDateInProfitCalculation()
    {
	return IncludeInstallmentDateInProfitCalculation;
    }

    public void setIncludeInstallmentDateInProfitCalculation(String includeInstallmentDateInProfitCalculation)
    {
	IncludeInstallmentDateInProfitCalculation = includeInstallmentDateInProfitCalculation;
    }

    public String getRedusingBalanceMethod()
    {
	return redusingBalanceMethod;
    }

    public void setRedusingBalanceMethod(String redusingBalanceMethod)
    {
	this.redusingBalanceMethod = redusingBalanceMethod;
    }

    public String getPayProfitAndChargesOnly()
    {
	return payProfitAndChargesOnly;
    }

    public void setPayProfitAndChargesOnly(String payProfitAndChargesOnly)
    {
	this.payProfitAndChargesOnly = payProfitAndChargesOnly;
    }

    public String getCalendarType()
    {
	return calendarType;
    }

    public void setCalendarType(String calendarType)
    {
	this.calendarType = calendarType;
    }

    public BigDecimal getAvgDaysInYearsForProfitCalculation()
    {
	return avgDaysInYearsForProfitCalculation;
    }

    public void setAvgDaysInYearsForProfitCalculation(BigDecimal avgDaysInYearsForProfitCalculation)
    {
	this.avgDaysInYearsForProfitCalculation = avgDaysInYearsForProfitCalculation;
    }

    public Integer getChangeEffectLineNo()
    {
	return changeEffectLineNo;
    }

    public void setChangeEffectLineNo(Integer changeEffectLineNo)
    {
	this.changeEffectLineNo = changeEffectLineNo;
    }

    public BigDecimal getTotalBalloonAmount()
    {
	return totalBalloonAmount;
    }

    public void setTotalBalloonAmount(BigDecimal totalBalloonAmount)
    {
	this.totalBalloonAmount = totalBalloonAmount;
    }

    public String getProfitCalculateAsOnYieldDate()
    {
	return profitCalculateAsOnYieldDate;
    }

    public void setProfitCalculateAsOnYieldDate(String profitCalculateAsOnYieldDate)
    {
	this.profitCalculateAsOnYieldDate = profitCalculateAsOnYieldDate;
    }

    public String getMultipleYieldEqualiseFromValueDate()
    {
	return multipleYieldEqualiseFromValueDate;
    }

    public void setMultipleYieldEqualiseFromValueDate(String multipleYieldEqualiseFromValueDate)
    {
	this.multipleYieldEqualiseFromValueDate = multipleYieldEqualiseFromValueDate;
    }

    public String getLastInstallmentOnMaturityDate()
    {
	return lastInstallmentOnMaturityDate;
    }

    public void setLastInstallmentOnMaturityDate(String lastInstallmentOnMaturityDate)
    {
	this.lastInstallmentOnMaturityDate = lastInstallmentOnMaturityDate;
    }

    public Date getNextProfitValueDate()
    {
	return nextProfitValueDate;
    }

    public void setNextProfitValueDate(Date nextProfitValueDate)
    {
	this.nextProfitValueDate = nextProfitValueDate;
    }

    public Date getNextDisbursementDate()
    {
	return nextDisbursementDate;
    }

    public void setNextDisbursementDate(Date nextDisbursementDate)
    {
	this.nextDisbursementDate = nextDisbursementDate;
    }

    public String getCompoundingProfit()
    {
	return compoundingProfit;
    }

    public void setCompoundingProfit(String compoundingProfit)
    {
	this.compoundingProfit = compoundingProfit;
    }

    public BigDecimal getTotalGracePeriodCompundingProfit()
    {
	return totalGracePeriodCompundingProfit;
    }

    public void setTotalGracePeriodCompundingProfit(BigDecimal totalGracePeriodCompundingProfit)
    {
	this.totalGracePeriodCompundingProfit = totalGracePeriodCompundingProfit;
    }

    public Date getInstallmentCommentsDate()
    {
	return installmentCommentsDate;
    }

    public void setInstallmentCommentsDate(Date installmentCommentsDate)
    {
	this.installmentCommentsDate = installmentCommentsDate;
    }

    public List<TrsPlanBallonPaymentCO> getTrsPlanBallonPaymentCO()
    {
	return trsPlanBallonPaymentCO;
    }

    public void setTrsPlanBallonPaymentCO(List<TrsPlanBallonPaymentCO> trsPlanBallonPaymentCO)
    {
	this.trsPlanBallonPaymentCO = trsPlanBallonPaymentCO;
    }

    public List<TrspayplandetCO> getTrspayplandetVOList()
    {
	return trspayplandetVOList;
    }

    public void setTrspayplandetVOList(List<TrspayplandetCO> trspayplandetCOList)
    {
	this.trspayplandetVOList = trspayplandetCOList;
    }

    public List<TrspayplandetCO> getTrspayplandetCompoundingDealPeriod()
    {
	return trspayplandetCompoundingDealPeriod;
    }

    public void setTrspayplandetCompoundingDealPeriod(List<TrspayplandetCO> trspayplandetCompoundingDealPeriod)
    {
	this.trspayplandetCompoundingDealPeriod = trspayplandetCompoundingDealPeriod;
    }

    public List<TrspayplandetCO> getTrspayplandetCompoundingGracePeriod()
    {
	return trspayplandetCompoundingGracePeriod;
    }

    public void setTrspayplandetCompoundingGracePeriod(List<TrspayplandetCO> trspayplandetCompoundingGracePeriod)
    {
	this.trspayplandetCompoundingGracePeriod = trspayplandetCompoundingGracePeriod;
    }

    public List<TrsDealChargesCO> getTrsdealchargesVO()
    {
	return trsdealchargesVO;
    }

    public void setTrsdealchargesVO(List<TrsDealChargesCO> trsdealchargesVO)
    {
	this.trsdealchargesVO = trsdealchargesVO;
    }

    public List<TRSDEAL_MULTIPLE_YIELDVO> getTrsDealMultipleYieldVO()
    {
	return TrsDealMultipleYieldVO;
    }

    public void setTrsDealMultipleYieldVO(List<TRSDEAL_MULTIPLE_YIELDVO> trsDealMultipleYieldVO)
    {
	TrsDealMultipleYieldVO = trsDealMultipleYieldVO;
    }

    public List<TRSPAYPLAN_SEGMENT_START_DATESVO> getTrsPayPlanSegmentStartDatesVO()
    {
	return TrsPayPlanSegmentStartDatesVO;
    }

    public void setTrsPayPlanSegmentStartDatesVO(List<TRSPAYPLAN_SEGMENT_START_DATESVO> trsPayPlanSegmentStartDatesVO)
    {
	TrsPayPlanSegmentStartDatesVO = trsPayPlanSegmentStartDatesVO;
    }

    public List<TRSDEAL3VO> getTrsDealMultipleDisbursementList()
    {
	return trsDealMultipleDisbursementList;
    }

    public void setTrsDealMultipleDisbursementList(List<TRSDEAL3VO> trsDealMultipleDisbursementList)
    {
	this.trsDealMultipleDisbursementList = trsDealMultipleDisbursementList;
    }

    public String getShowCifIncomeInd()
    {
	return showCifIncomeInd;
    }

    public void setShowCifIncomeInd(String showCifIncomeInd)
    {
	this.showCifIncomeInd = showCifIncomeInd;
    }

    public BigDecimal getOutAmountPerPayment()
    {
	return outAmountPerPayment;
    }

    public void setOutAmountPerPayment(BigDecimal outAmountPerPayment)
    {
	this.outAmountPerPayment = outAmountPerPayment;
    }

    public BigDecimal getPlanChargesAmount()
    {
	return planChargesAmount;
    }

    public void setPlanChargesAmount(BigDecimal planChargesAmount)
    {
	this.planChargesAmount = planChargesAmount;
    }

    public BigDecimal getPlanChargesAmountForPrfotCalc()
    {
	return planChargesAmountForPrfotCalc;
    }

    public void setPlanChargesAmountForPrfotCalc(BigDecimal planChargesAmountForPrfotCalc)
    {
	this.planChargesAmountForPrfotCalc = planChargesAmountForPrfotCalc;
    }

    public BigDecimal getDownPaymentAmt()
    {
	return downPaymentAmt;
    }

    public void setDownPaymentAmt(BigDecimal downPaymentAmt)
    {
	this.downPaymentAmt = downPaymentAmt;
    }

    public String getCombainedScreen()
    {
	return combainedScreen;
    }

    public void setCombainedScreen(String combainedScreen)
    {
	this.combainedScreen = combainedScreen;
    }

    public BigDecimal getMaxNoOfPayments()
    {
	return maxNoOfPayments;
    }

    public void setMaxNoOfPayments(BigDecimal maxNoOfPayments)
    {
	this.maxNoOfPayments = maxNoOfPayments;
    }

    public void setConfirmationMessageId(String confirmationMessageId)
    {
	this.confirmationMessageId = confirmationMessageId;
    }

    public String getConfirmationMessageId()
    {
	return confirmationMessageId;
    }

    public void setConfirmationMessageId2(String confirmationMessageId2)
    {
	this.confirmationMessageId2 = confirmationMessageId2;
    }

    public String getConfirmationMessageId2()
    {
	return confirmationMessageId2;
    }

    public double getCurrentLineActualProfitAmount()
    {
	return currentLineActualProfitAmount;
    }

    public void setCurrentLineActualProfitAmount(double currentLineActualProfitAmount)
    {
	this.currentLineActualProfitAmount = currentLineActualProfitAmount;
    }

    public Long getDealPeriodCompoundingPeriodicityNo()
    {
	return dealPeriodCompoundingPeriodicityNo;
    }

    public void setDealPeriodCompoundingPeriodicityNo(Long dealPeriodCompoundingPeriodicityNo)
    {
	this.dealPeriodCompoundingPeriodicityNo = dealPeriodCompoundingPeriodicityNo;
    }

    public String getDealPeriodCompoundingPeriodicity()
    {
	return dealPeriodCompoundingPeriodicity;
    }

    public void setDealPeriodCompoundingPeriodicity(String dealPeriodCompoundingPeriodicity)
    {
	this.dealPeriodCompoundingPeriodicity = dealPeriodCompoundingPeriodicity;
    }

    public boolean isFirstLoop()
    {
	return firstLoop;
    }

    public void setFirstLoop(boolean firstLoop)
    {
	this.firstLoop = firstLoop;
    }

    public double getOutstandingAmountForXIRR()
    {
	return outstandingAmountForXIRR;
    }

    public void setOutstandingAmountForXIRR(double outstandingAmountForXIRR)
    {
	this.outstandingAmountForXIRR = outstandingAmountForXIRR;
    }

    public BigDecimal getPreviousDealAmount()
    {
	return previousDealAmount;
    }

    public void setPreviousDealAmount(BigDecimal previousDealAmount)
    {
	this.previousDealAmount = previousDealAmount;
    }

    public String getDisburs_maintain_indiv_plan_yn()
    {
	return disburs_maintain_indiv_plan_yn;
    }

    public void setDisburs_maintain_indiv_plan_yn(String disbursMaintainIndivPlanYn)
    {
	disburs_maintain_indiv_plan_yn = disbursMaintainIndivPlanYn;
    }

    public TRSCLASSVO getTrsclassvo()
    {
	return trsclassvo;
    }

    public void setTrsclassvo(TRSCLASSVO trsclassvo)
    {
	this.trsclassvo = trsclassvo;
    }

    public BigDecimal getMudarabahRateCode()
    {
	return mudarabahRateCode;
    }

    public void setMudarabahRateCode(BigDecimal mudarabahRateCode)
    {
	this.mudarabahRateCode = mudarabahRateCode;
    }

    public String getHijriDate()
    {
	return hijriDate;
    }

    public void setHijriDate(String hijriDate)
    {
	this.hijriDate = hijriDate;
    }

    public String getLastInstAssetResidualYn()
    {
	return lastInstAssetResidualYn;
    }

    public void setLastInstAssetResidualYn(String lastInstAssetResidualYn)
    {
	this.lastInstAssetResidualYn = lastInstAssetResidualYn;
    }

    public BigDecimal getAssetResidualAmount()
    {
	return assetResidualAmount;
    }

    public void setAssetResidualAmount(BigDecimal assetResidualAmount)
    {
	this.assetResidualAmount = assetResidualAmount;
    }

    public BigDecimal getOutNoOfPayments()
    {
	return outNoOfPayments;
    }

    public void setOutNoOfPayments(BigDecimal outNoOfPayments)
    {
	this.outNoOfPayments = outNoOfPayments;
    }

    public BigDecimal getAmountPerPaymentEqualDisbur()
    {
	return amountPerPaymentEqualDisbur;
    }

    public void setAmountPerPaymentEqualDisbur(BigDecimal amountPerPaymentEqualDisbur)
    {
	this.amountPerPaymentEqualDisbur = amountPerPaymentEqualDisbur;
    }

    public BigDecimal getTRSDET_MATR_AC_CY()
    {
	return TRSDET_MATR_AC_CY;
    }

    public void setTRSDET_MATR_AC_CY(BigDecimal tRSDETMATRACCY)
    {
	TRSDET_MATR_AC_CY = tRSDETMATRACCY;
    }

    public BigDecimal getTRSDET_MATR_AC_GL()
    {
	return TRSDET_MATR_AC_GL;
    }

    public void setTRSDET_MATR_AC_GL(BigDecimal tRSDETMATRACGL)
    {
	TRSDET_MATR_AC_GL = tRSDETMATRACGL;
    }

    public BigDecimal getTRSDET_MATR_AC_CIF()
    {
	return TRSDET_MATR_AC_CIF;
    }

    public void setTRSDET_MATR_AC_CIF(BigDecimal tRSDETMATRACCIF)
    {
	TRSDET_MATR_AC_CIF = tRSDETMATRACCIF;
    }

    public BigDecimal getTRSDET_MATR_AC_SL()
    {
	return TRSDET_MATR_AC_SL;
    }

    public void setTRSDET_MATR_AC_SL(BigDecimal tRSDETMATRACSL)
    {
	TRSDET_MATR_AC_SL = tRSDETMATRACSL;
    }

    public String getTRSDET_MATR_AC_BRIEF_NAME_ENG()
    {
	return TRSDET_MATR_AC_BRIEF_NAME_ENG;
    }

    public void setTRSDET_MATR_AC_BRIEF_NAME_ENG(String tRSDETMATRACBRIEFNAMEENG)
    {
	TRSDET_MATR_AC_BRIEF_NAME_ENG = tRSDETMATRACBRIEFNAMEENG;
    }

    public String getAUTO_CREATE_SETTLEMENT()
    {
	return AUTO_CREATE_SETTLEMENT;
    }

    public void setAUTO_CREATE_SETTLEMENT(String aUTOCREATESETTLEMENT)
    {
	AUTO_CREATE_SETTLEMENT = aUTOCREATESETTLEMENT;
    }

    public BigDecimal getTRSDET_MATR_AC_BR()
    {
	return TRSDET_MATR_AC_BR;
    }

    public void setTRSDET_MATR_AC_BR(BigDecimal tRSDETMATRACBR)
    {
	TRSDET_MATR_AC_BR = tRSDETMATRACBR;
    }

    public String getUpfront_profit_yn()
    {
	return upfront_profit_yn;
    }

    public void setUpfront_profit_yn(String upfrontProfitYn)
    {
	upfront_profit_yn = upfrontProfitYn;
    }

    public BigDecimal getUpfront_profit_amt()
    {
	return upfront_profit_amt;
    }

    public void setUpfront_profit_amt(BigDecimal upfrontProfitAmt)
    {
	upfront_profit_amt = upfrontProfitAmt;
    }

    public BigDecimal getUpfront_capital_amt()
    {
	return upfront_capital_amt;
    }

    public void setUpfront_capital_amt(BigDecimal upfrontCapitalAmt)
    {
	upfront_capital_amt = upfrontCapitalAmt;
    }

    public String getACCRUAL_AMOUNT_TYPE()
    {
	return ACCRUAL_AMOUNT_TYPE;
    }

    public void setACCRUAL_AMOUNT_TYPE(String aCCRUALAMOUNTTYPE)
    {
	ACCRUAL_AMOUNT_TYPE = aCCRUALAMOUNTTYPE;
    }

    public String getPLAN_SHOW_PRINCIPAL_AMOUNT_YN()
    {
	return PLAN_SHOW_PRINCIPAL_AMOUNT_YN;
    }

    public void setPLAN_SHOW_PRINCIPAL_AMOUNT_YN(String pLANSHOWPRINCIPALAMOUNTYN)
    {
	PLAN_SHOW_PRINCIPAL_AMOUNT_YN = pLANSHOWPRINCIPALAMOUNTYN;
    }

    public BigDecimal getDEAL_CATEGORY()
    {
	return DEAL_CATEGORY;
    }

    public void setDEAL_CATEGORY(BigDecimal dEALCATEGORY)
    {
	DEAL_CATEGORY = dEALCATEGORY;
    }

    public List<String> getConfirm_messages()
    {
	return confirm_messages;
    }

    public void setConfirm_messages(List<String> confirmMessages)
    {
	confirm_messages = confirmMessages;
    }

    public String getNidcDeal()
    {
	return nidcDeal;
    }

    public void setNidcDeal(String nidcDeal)
    {
	this.nidcDeal = nidcDeal;
    }

    public List<TrspayplanCriteriaCO> getTrsPayPlanCriteriaVO()
    {
	return TrsPayPlanCriteriaVO;
    }

    public void setTrsPayPlanCriteriaVO(List<TrspayplanCriteriaCO> trsPayPlanCriteriaVO)
    {
	TrsPayPlanCriteriaVO = trsPayPlanCriteriaVO;
    }

    public BigDecimal getNoOfBaloonPayments()
    {
	return noOfBaloonPayments;
    }

    public void setNoOfBaloonPayments(BigDecimal noOfBaloonPayments)
    {
	this.noOfBaloonPayments = noOfBaloonPayments;
    }

    public BigDecimal getBalloonPayment()
    {
	return balloonPayment;
    }

    public void setBalloonPayment(BigDecimal balloonPayment)
    {
	this.balloonPayment = balloonPayment;
    }

    public String getSettlmentType()
    {
	return settlmentType;
    }

    public void setSettlmentType(String settlmentType)
    {
	this.settlmentType = settlmentType;
    }

    public String getRescheduleType()
    {
	return rescheduleType;
    }

    public void setRescheduleType(String rescheduleType)
    {
	this.rescheduleType = rescheduleType;
    }

    public BigDecimal getOutstandingProfit()
    {
	return outstandingProfit;
    }

    public void setOutstandingProfit(BigDecimal outstandingProfit)
    {
	this.outstandingProfit = outstandingProfit;
    }

    public BigDecimal getAdditionalProfit()
    {
	return additionalProfit;
    }

    public void setAdditionalProfit(BigDecimal additionalProfit)
    {
	this.additionalProfit = additionalProfit;
    }

    public String getRescheduleYn()
    {
	return rescheduleYn;
    }

    public void setRescheduleYn(String rescheduleYn)
    {
	this.rescheduleYn = rescheduleYn;
    }

    public BigDecimal getPlanSeq()
    {
	return planSeq;
    }

    public void setPlanSeq(BigDecimal planSeq)
    {
	this.planSeq = planSeq;
    }

    public BigDecimal getPlanNbr()
    {
	return planNbr;
    }

    public void setPlanNbr(BigDecimal planNbr)
    {
	this.planNbr = planNbr;
    }

    public String getLimitReinstateBasedOn()
    {
	return limitReinstateBasedOn;
    }

    public void setLimitReinstateBasedOn(String limitReinstateBasedOn)
    {
	this.limitReinstateBasedOn = limitReinstateBasedOn;
    }

    public Date getOriginalValueDate()
    {
	return originalValueDate;
    }

    public void setOriginalValueDate(Date originalValueDate)
    {
	this.originalValueDate = originalValueDate;
    }

    public BigDecimal getOriginalDealAmount()
    {
	return originalDealAmount;
    }

    public void setOriginalDealAmount(BigDecimal originalDealAmount)
    {
	this.originalDealAmount = originalDealAmount;
    }

    public BigDecimal getFirstLineProfitToBeAdjust()
    {
	return firstLineProfitToBeAdjust;
    }

    public void setFirstLineProfitToBeAdjust(BigDecimal firstLineProfitToBeAdjust)
    {
	this.firstLineProfitToBeAdjust = firstLineProfitToBeAdjust;
    }

    public int getIgoreIfStatement()
    {
	return igoreIfStatement;
    }

    public void setIgoreIfStatement(int igoreIfStatement)
    {
	this.igoreIfStatement = igoreIfStatement;
    }

    public BigDecimal getPrevAnnualYield()
    {
	return prevAnnualYield;
    }

    public void setPrevAnnualYield(BigDecimal prevAnnualYield)
    {
	this.prevAnnualYield = prevAnnualYield;
    }

    public String getYieldRequiredYn()
    {
	return yieldRequiredYn;
    }

    public void setYieldRequiredYn(String yieldRequiredYn)
    {
	this.yieldRequiredYn = yieldRequiredYn;
    }

    public int getDealAmountMachingWithPlanYn()
    {
	return dealAmountMachingWithPlanYn;
    }

    public void setDealAmountMachingWithPlanYn(int dealAmountMachingWithPlanYn)
    {
	this.dealAmountMachingWithPlanYn = dealAmountMachingWithPlanYn;
    }

    public int getTotalAmountMachingWithPlanYn()
    {
	return totalAmountMachingWithPlanYn;
    }

    public void setTotalAmountMachingWithPlanYn(int totalAmountMachingWithPlanYn)
    {
	this.totalAmountMachingWithPlanYn = totalAmountMachingWithPlanYn;
    }

    public int getTotalCapitalMachingWithPlanYn()
    {
	return totalCapitalMachingWithPlanYn;
    }

    public void setTotalCapitalMachingWithPlanYn(int totalCapitalMachingWithPlanYn)
    {
	this.totalCapitalMachingWithPlanYn = totalCapitalMachingWithPlanYn;
    }

    public Date getPreviousLineValudateForRevaluation()
    {
	return previousLineValudateForRevaluation;
    }

    public void setPreviousLineValudateForRevaluation(Date previousLineValudateForRevaluation)
    {
	this.previousLineValudateForRevaluation = previousLineValudateForRevaluation;
    }

    public String getRevaluationProfitAdjustAppliedYn()
    {
	return revaluationProfitAdjustAppliedYn;
    }

    public void setRevaluationProfitAdjustAppliedYn(String revaluationProfitAdjustAppliedYn)
    {
	this.revaluationProfitAdjustAppliedYn = revaluationProfitAdjustAppliedYn;
    }

    public void setDisbursementScreen(Boolean disbursementScreen)
    {

	this.disbursementScreen = disbursementScreen;
    }

    public Boolean getDisbursementScreen()
    {
	if(disbursementScreen == null)
	{
	    disbursementScreen = false;
	}
	return disbursementScreen;
    }

    public void setCollectedDepreciation(BigDecimal collectedDepreciation)
    {
	this.collectedDepreciation = collectedDepreciation;
    }

    public BigDecimal getCollectedDepreciation()
    {
	return collectedDepreciation;
    }

    public void setCollectedAccrual(BigDecimal collectedAccrual)
    {
	this.collectedAccrual = collectedAccrual;
    }

    public BigDecimal getCollectedAccrual()
    {
	return collectedAccrual;
    }

    public void setWrittenOffDepreciationAmount(BigDecimal writtenOffDepreciationAmount)
    {
	this.writtenOffDepreciationAmount = writtenOffDepreciationAmount;
    }

    public BigDecimal getWrittenOffDepreciationAmount()
    {
	return writtenOffDepreciationAmount;
    }

    public void setWriteOffAmount(BigDecimal writeOffAmount)
    {
	this.writeOffAmount = writeOffAmount;
    }

    public BigDecimal getWriteOffAmount()
    {
	return writeOffAmount;
    }

    public String getApplyDepreciationDeal()
    {
	return applyDepreciationDeal;
    }

    public void setApplyDepreciationDeal(String applyDepreciationDeal)
    {
	this.applyDepreciationDeal = applyDepreciationDeal;
    }

    public void setDailyDepreciationOld(BigDecimal dailyDepreciationOld)
    {
	this.dailyDepreciationOld = dailyDepreciationOld;
    }

    public BigDecimal getDailyDepreciationOld()
    {
	return dailyDepreciationOld;
    }

    public void setDailyAccrualOld(BigDecimal dailyAccrualOld)
    {
	this.dailyAccrualOld = dailyAccrualOld;
    }

    public BigDecimal getDailyAccrualOld()
    {
	return dailyAccrualOld;
    }

    public int getPushedDownRowExist()
    {
	return pushedDownRowExist;
    }

    public void setPushedDownRowExist(int pushedDownRowExist)
    {
	this.pushedDownRowExist = pushedDownRowExist;
    }

    public String getRevaluationProcess()
    {
	return revaluationProcess;
    }

    public void setRevaluationProcess(String revaluationProcess)
    {
	this.revaluationProcess = revaluationProcess;
    }

    public BigDecimal getNoOfMonthsOut()
    {
	return noOfMonthsOut;
    }

    public void setNoOfMonthsOut(BigDecimal noOfMonthsOut)
    {
	this.noOfMonthsOut = noOfMonthsOut;
    }

    public String getEXCL_PRFT_RECLC_DUE_INST_YN()
    {
	return EXCL_PRFT_RECLC_DUE_INST_YN;
    }

    public void setEXCL_PRFT_RECLC_DUE_INST_YN(String eXCLPRFTRECLCDUEINSTYN)
    {
	EXCL_PRFT_RECLC_DUE_INST_YN = eXCLPRFTRECLCDUEINSTYN;
    }

    public BigDecimal getTotalDepreciationOld()
    {
	return totalDepreciationOld;
    }

    public void setTotalDepreciationOld(BigDecimal totalDepreciationOld)
    {
	this.totalDepreciationOld = totalDepreciationOld;
    }

    public BigDecimal getLinkedDealNo()
    {
	return linkedDealNo;
    }

    public void setLinkedDealNo(BigDecimal linkedDealNo)
    {
	this.linkedDealNo = linkedDealNo;
    }

    public BigDecimal getLinkedDealPlanNbr()
    {
	return linkedDealPlanNbr;
    }

    public void setLinkedDealPlanNbr(BigDecimal linkedDealPlanNbr)
    {
	this.linkedDealPlanNbr = linkedDealPlanNbr;
    }

    public BigDecimal getLinkedDealPlanSeq()
    {
	return linkedDealPlanSeq;
    }

    public void setLinkedDealPlanSeq(BigDecimal linkedDealPlanSeq)
    {
	this.linkedDealPlanSeq = linkedDealPlanSeq;
    }

    public String getGrace_prd_cmpnd_pft_deal_yn()
    {
	return grace_prd_cmpnd_pft_deal_yn;
    }

    public void setGrace_prd_cmpnd_pft_deal_yn(String gracePrdCmpndPftDealYn)
    {
	grace_prd_cmpnd_pft_deal_yn = gracePrdCmpndPftDealYn;
    }

    public String getLimit_reinstate_based_on()
    {
	return limit_reinstate_based_on;
    }

    public void setLimit_reinstate_based_on(String limitReinstateBasedOn)
    {
	limit_reinstate_based_on = limitReinstateBasedOn;
    }

    public BigDecimal getIdec_outstanding_grace_compounding_pft()
    {
	return idec_outstanding_grace_compounding_pft;
    }

    public void setIdec_outstanding_grace_compounding_pft(BigDecimal idecOutstandingGraceCompoundingPft)
    {
	idec_outstanding_grace_compounding_pft = idecOutstandingGraceCompoundingPft;
    }

    public String getCalledFromApp()
    {
	return calledFromApp;
    }

    public void setCalledFromApp(String calledFromApp)
    {
	this.calledFromApp = calledFromApp;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getAssetResidualprofit()
    {
	return assetResidualprofit;
    }

    public void setAssetResidualprofit(BigDecimal assetResidualprofit)
    {
	this.assetResidualprofit = assetResidualprofit;
    }

    public BigDecimal getOutupfrontProfitAmt()
    {
	return outupfrontProfitAmt;
    }

    public void setOutupfrontProfitAmt(BigDecimal outupfrontProfitAmt)
    {
	this.outupfrontProfitAmt = outupfrontProfitAmt;
    }

    public BigDecimal getSettledCapital()
    {
	return settledCapital;
    }

    public void setSettledCapital(BigDecimal settledCapital)
    {
	this.settledCapital = settledCapital;
    }

    public String getDealAmmendmentYn()
    {
	return dealAmmendmentYn;
    }

    public void setDealAmmendmentYn(String dealAmmendmentYn)
    {
	this.dealAmmendmentYn = dealAmmendmentYn;
    }

    public BigDecimal getPLAN_LIBOR_RATE()
    {
	return PLAN_LIBOR_RATE;
    }

    public void setPLAN_LIBOR_RATE(BigDecimal pLANLIBORRATE)
    {
	PLAN_LIBOR_RATE = pLANLIBORRATE;
    }

    public BigDecimal getYIELD()
    {
	return YIELD;
    }

    public void setYIELD(BigDecimal yIELD)
    {
	YIELD = yIELD;
    }

    public BigDecimal getPLAN_EXPECTED_YIELD()
    {
	return PLAN_EXPECTED_YIELD;
    }

    public void setPLAN_EXPECTED_YIELD(BigDecimal pLANEXPECTEDYIELD)
    {
	PLAN_EXPECTED_YIELD = pLANEXPECTEDYIELD;
    }

    public void setTotalAllocatedAmount(BigDecimal totalAllocatedAmount)
    {
	this.totalAllocatedAmount = totalAllocatedAmount;
    }

    public BigDecimal getTotalAllocatedAmount()
    {
	return totalAllocatedAmount;
    }

    public TRSDEALVO getTrsdealvo()
    {
	return trsdealvo;
    }

    public void setTrsdealvo(TRSDEALVO trsdealvo)
    {
	this.trsdealvo = trsdealvo;
    }

    public String getFetchDataFromDbYn()
    {
	return fetchDataFromDbYn;
    }

    public void setFetchDataFromDbYn(String fetchDataFromDbYn)
    {
	this.fetchDataFromDbYn = fetchDataFromDbYn;
    }

    public String getTfaTrxType()
    {
	return tfaTrxType;
    }

    public void setTfaTrxType(String tfaTrxType)
    {
	this.tfaTrxType = tfaTrxType;
    }

    public BigDecimal getTfaInwardOutwartTrsNo()
    {
	return tfaInwardOutwartTrsNo;
    }

    public void setTfaInwardOutwartTrsNo(BigDecimal tfaInwardOutwartTrsNo)
    {
	this.tfaInwardOutwartTrsNo = tfaInwardOutwartTrsNo;
    }

    public String getBillsCalculatorYn()
    {
	return billsCalculatorYn;
    }

    public void setBillsCalculatorYn(String billsCalculatorYn)
    {
	this.billsCalculatorYn = billsCalculatorYn;
    }

    public String getPft_calc_based_trade_cy_yn()
    {
	return pft_calc_based_trade_cy_yn;
    }

    public void setPft_calc_based_trade_cy_yn(String pftCalcBasedTradeCyYn)
    {
	pft_calc_based_trade_cy_yn = pftCalcBasedTradeCyYn;
    }

    public BigDecimal getTradeCurrency()
    {
	return tradeCurrency;
    }

    public void setTradeCurrency(BigDecimal tradeCurrency)
    {
	this.tradeCurrency = tradeCurrency;
    }

    public String getInterest_calculation_method()
    {
	return interest_calculation_method;
    }

    public void setInterest_calculation_method(String interestCalculationMethod)
    {
	interest_calculation_method = interestCalculationMethod;
    }

    public BigDecimal getTotalBillAmount()
    {
	return totalBillAmount;
    }

    public void setTotalBillAmount(BigDecimal totalBillAmount)
    {
	this.totalBillAmount = totalBillAmount;
    }

    public BigDecimal getTotalNetPrecentValue()
    {
	return totalNetPrecentValue;
    }

    public void setTotalNetPrecentValue(BigDecimal totalNetPrecentValue)
    {
	this.totalNetPrecentValue = totalNetPrecentValue;
    }

    public TRSDEAL_NIDCVO getTrsdealNIDCVO()
    {
	return trsdealNIDCVO;
    }

    public void setTrsdealNIDCVO(TRSDEAL_NIDCVO trsdealNIDCVO)
    {
	this.trsdealNIDCVO = trsdealNIDCVO;
    }

    public List<TRSDEAL_NIDC_DETVO> getTrsdealNIDCDETVO()
    {
	return trsdealNIDCDETVO;
    }

    public void setTrsdealNIDCDETVO(List<TRSDEAL_NIDC_DETVO> trsdealNIDCDETVO)
    {
	this.trsdealNIDCDETVO = trsdealNIDCDETVO;
    }

    public BigDecimal getBillAmount()
    {
	return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount)
    {
	this.billAmount = billAmount;
    }

    public List<TRSDEAL_NIDC_COUPON_PYMNTVO> getTrsdealNIDC_COUPONPYMNTVOs()
    {
	return trsdealNIDC_COUPONPYMNTVOs;
    }

    public void setTrsdealNIDC_COUPONPYMNTVOs(List<TRSDEAL_NIDC_COUPON_PYMNTVO> trsdealNIDCCOUPONPYMNTVOs)
    {
	trsdealNIDC_COUPONPYMNTVOs = trsdealNIDCCOUPONPYMNTVOs;
    }

    public String getPRFT_ACCR_ON_OUTSTAND_PRINC_YN()
    {
	return PRFT_ACCR_ON_OUTSTAND_PRINC_YN;
    }

    public void setPRFT_ACCR_ON_OUTSTAND_PRINC_YN(String pRFTACCRONOUTSTANDPRINCYN)
    {
	PRFT_ACCR_ON_OUTSTAND_PRINC_YN = pRFTACCRONOUTSTANDPRINCYN;
    }

    public String getRescheduleForLateSettlementYn()
    {
	return rescheduleForLateSettlementYn;
    }

    public void setRescheduleForLateSettlementYn(String rescheduleForLateSettlementYn)
    {
	this.rescheduleForLateSettlementYn = rescheduleForLateSettlementYn;
    }

    public BigDecimal getSettledFromLineNo()
    {
	return settledFromLineNo;
    }

    public void setSettledFromLineNo(BigDecimal settledFromLineNo)
    {
	this.settledFromLineNo = settledFromLineNo;
    }

    public BigDecimal getSettledToLineNo()
    {
	return settledToLineNo;
    }

    public void setSettledToLineNo(BigDecimal settledToLineNo)
    {
	this.settledToLineNo = settledToLineNo;
    }

    public BigDecimal getXirrWithChargesOut()
    {
	return xirrWithChargesOut;
    }

    public void setXirrWithChargesOut(BigDecimal xirrWithChargesOut)
    {
	this.xirrWithChargesOut = xirrWithChargesOut;
    }

    /**
     * @param agencyFeePercentage the agencyFeePercentage to set
     */
    public void setAgencyFeePercentage(BigDecimal agencyFeePercentage)
    {
	this.agencyFeePercentage = agencyFeePercentage;
    }

    /**
     * @return the agencyFeePercentage
     */
    public BigDecimal getAgencyFeePercentage()
    {
	return agencyFeePercentage;
    }

    /**
     * @param accrueAgencyFeeYn the accrueAgencyFeeYn to set
     */
    public void setAccrueAgencyFeeYn(String accrueAgencyFeeYn)
    {
	this.accrueAgencyFeeYn = accrueAgencyFeeYn;
    }

    /**
     * @return the accrueAgencyFeeYn
     */
    public String getAccrueAgencyFeeYn()
    {
	return accrueAgencyFeeYn;
    }

    /**
     * @param outstandingAgencyFee the outstandingAgencyFee to set
     */
    public void setOutstandingAgencyFee(BigDecimal outstandingAgencyFee)
    {
	this.outstandingAgencyFee = outstandingAgencyFee;
    }

    /**
     * @return the outstandingAgencyFee
     */
    public BigDecimal getOutstandingAgencyFee()
    {
	return outstandingAgencyFee;
    }

    public String getROUNDING_TYPE_INST_AMT()
    {
	return ROUNDING_TYPE_INST_AMT;
    }

    public void setROUNDING_TYPE_INST_AMT(String rOUNDINGTYPEINSTAMT)
    {
	ROUNDING_TYPE_INST_AMT = rOUNDINGTYPEINSTAMT;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHmSysParam()
    {
	return hmSysParam;
    }

    public void setHmSysParam(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hmSysParam)
    {
	this.hmSysParam = hmSysParam;
    }

    public List<TrsDealSettlementChargesCO> getTrsdealStlmntChargesList()
    {
	return trsdealStlmntChargesList;
    }

    public void setTrsdealStlmntChargesList(List<TrsDealSettlementChargesCO> trsdealStlmntChargesList)
    {
	this.trsdealStlmntChargesList = trsdealStlmntChargesList;
    }

    public BigDecimal getOrgTotalProfit()
    {
	return orgTotalProfit;
    }

    public void setOrgTotalProfit(BigDecimal orgTotalProfit)
    {
	this.orgTotalProfit = orgTotalProfit;
    }

    public BigDecimal getOrgTotalCharges()
    {
	return orgTotalCharges;
    }

    public void setOrgTotalCharges(BigDecimal orgTotalCharges)
    {
	this.orgTotalCharges = orgTotalCharges;
    }

    public BigDecimal getOrgTotalInsurance()
    {
	return orgTotalInsurance;
    }

    public void setOrgTotalInsurance(BigDecimal orgTotalInsurance)
    {
	this.orgTotalInsurance = orgTotalInsurance;
    }

    public BigDecimal getProfitAmountRoundingType()
    {
	return profitAmountRoundingType;
    }

    public void setProfitAmountRoundingType(BigDecimal profitAmountRoundingType)
    {
	this.profitAmountRoundingType = profitAmountRoundingType;
    }

    public BigDecimal getAdditionalProfitMsgCount()
    {
	return additionalProfitMsgCount;
    }

    public void setAdditionalProfitMsgCount(BigDecimal additionalProfitMsgCount)
    {
	this.additionalProfitMsgCount = additionalProfitMsgCount;
    }

    public boolean isGovtPromotedProduct()
    {
	return govtPromotedProduct;
    }

    public void setGovtPromotedProduct(boolean govtPromotedProduct)
    {
	this.govtPromotedProduct = govtPromotedProduct;
    }

    public List<LOSmessagesCO> getLosMessagesCOList()
    {
	return losMessagesCOList;
    }

    public void setLosMessagesCOList(List<LOSmessagesCO> losMessagesCOList)
    {
	this.losMessagesCOList = losMessagesCOList;
    }

    public BigDecimal getCifNo()
    {
	return CifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	CifNo = cifNo;
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

    public String getCalledFromIPRSYN()
    {
	return calledFromIPRSYN;
    }

    public void setCalledFromIPRSYN(String calledFromIPRSYN)
    {
	this.calledFromIPRSYN = calledFromIPRSYN;
    }

    public String getCalledFromFirstLeg()
    {
	return calledFromFirstLeg;
    }

    public void setCalledFromFirstLeg(String calledFromFirstLeg)
    {
	this.calledFromFirstLeg = calledFromFirstLeg;
    }

    public BigDecimal getLimitSerialNo()
    {
	return limitSerialNo;
    }

    public void setLimitSerialNo(BigDecimal limitSerialNo)
    {
	this.limitSerialNo = limitSerialNo;
    }

    public BigDecimal getCurrentLineNo()
    {
	return currentLineNo;
    }

    public void setCurrentLineNo(BigDecimal currentLineNo)
    {
	this.currentLineNo = currentLineNo;
    }

    public List<TrsPayPlanDetNetPresentValCO> getTrsPayPlanDetNPVlist()
    {
	return trsPayPlanDetNPVlist;
    }

    public void setTrsPayPlanDetNPVlist(List<TrsPayPlanDetNetPresentValCO> trsPayPlanDetNPVlist)
    {
	this.trsPayPlanDetNPVlist = trsPayPlanDetNPVlist;
    }

    public Date getLastSettledValueDate()
    {
	return lastSettledValueDate;
    }

    public void setLastSettledValueDate(Date lastSettledValueDate)
    {
	this.lastSettledValueDate = lastSettledValueDate;
    }

    public String getRevaluationOnSettledInstallmentYn()
    {
	return revaluationOnSettledInstallmentYn;
    }

    public void setRevaluationOnSettledInstallmentYn(String revaluationOnSettledInstallmentYn)
    {
	this.revaluationOnSettledInstallmentYn = revaluationOnSettledInstallmentYn;
    }

    public String getCalledFromDealModifyYN()
    {
	return calledFromDealModifyYN;
    }

    public void setCalledFromDealModifyYN(String calledFromDealModifyYN)
    {
	this.calledFromDealModifyYN = calledFromDealModifyYN;
    }

    public String getSkippingProcessYn()
    {
	return skippingProcessYn;
    }

    public void setSkippingProcessYn(String skippingProcessYn)
    {
	this.skippingProcessYn = skippingProcessYn;
    }

    public List<TRSPAYPLAN_BREAKUP_PROFITVO> getTrspayplan_BREAKUP_PROFITVs()
    {
	return trspayplan_BREAKUP_PROFITVs;
    }

    public void setTrspayplan_BREAKUP_PROFITVs(List<TRSPAYPLAN_BREAKUP_PROFITVO> trspayplan_BREAKUP_PROFITVs)
    {
	this.trspayplan_BREAKUP_PROFITVs = trspayplan_BREAKUP_PROFITVs;
    }

    public String getCalculateMultipleYieldProfitForGracePeriod()
    {
	return calculateMultipleYieldProfitForGracePeriod;
    }

    public void setCalculateMultipleYieldProfitForGracePeriod(String calculateMultipleYieldProfitForGracePeriod)
    {
	this.calculateMultipleYieldProfitForGracePeriod = calculateMultipleYieldProfitForGracePeriod;
    }

    public String getCUSTOM_INSTLMNT_ON_RESCHDUL_YN()
    {
	return CUSTOM_INSTLMNT_ON_RESCHDUL_YN;
    }

    public void setCUSTOM_INSTLMNT_ON_RESCHDUL_YN(String cUSTOM_INSTLMNT_ON_RESCHDUL_YN)
    {
	CUSTOM_INSTLMNT_ON_RESCHDUL_YN = cUSTOM_INSTLMNT_ON_RESCHDUL_YN;
    }

    public BigDecimal getProfitPerPayment()
    {
	return profitPerPayment;
    }

    public void setProfitPerPayment(BigDecimal profitPerPayment)
    {
	this.profitPerPayment = profitPerPayment;
    }

    public BigDecimal getCapitalPerPayment()
    {
	return capitalPerPayment;
    }

    public void setCapitalPerPayment(BigDecimal capitalPerPayment)
    {
	this.capitalPerPayment = capitalPerPayment;
    }

    public String getAdjustNoOfPaymentsBasedOnAmtPerPaymentsYn()
    {
	return adjustNoOfPaymentsBasedOnAmtPerPaymentsYn;
    }

    public void setAdjustNoOfPaymentsBasedOnAmtPerPaymentsYn(String adjustNoOfPaymentsBasedOnAmtPerPaymentsYn)
    {
	this.adjustNoOfPaymentsBasedOnAmtPerPaymentsYn = adjustNoOfPaymentsBasedOnAmtPerPaymentsYn;
    }

    public boolean isCalledFromCalculator()
    {
	return calledFromCalculator;
    }

    public void setCalledFromCalculator(boolean calledFromCalculator)
    {
	this.calledFromCalculator = calledFromCalculator;
    }

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

    public BigDecimal getBalanceAmt()
    {
	return balanceAmt;
    }

    public void setBalanceAmt(BigDecimal balanceAmt)
    {
	this.balanceAmt = balanceAmt;
    }

    public BigDecimal getTotalSettledAmt()
    {
	return totalSettledAmt;
    }

    public void setTotalSettledAmt(BigDecimal totalSettledAmt)
    {
	this.totalSettledAmt = totalSettledAmt;
    }

    public BigDecimal getCapitalizeProfitAmt()
    {
	return capitalizeProfitAmt;
    }

    public void setCapitalizeProfitAmt(BigDecimal capitalizeProfitAmt)
    {
	this.capitalizeProfitAmt = capitalizeProfitAmt;
    }

    public BigDecimal getChargeDue()
    {
	return chargeDue;
    }

    public void setChargeDue(BigDecimal chargeDue)
    {
	this.chargeDue = chargeDue;
    }

    public String getReschCapitalizeType()
    {
	return reschCapitalizeType;
    }

    public void setReschCapitalizeType(String reschCapitalizeType)
    {
	this.reschCapitalizeType = reschCapitalizeType;
    }

    public BigDecimal getTotalChargeAmortization()
    {
	return totalChargeAmortization;
    }

    public void setTotalChargeAmortization(BigDecimal totalChargeAmortization)
    {
	this.totalChargeAmortization = totalChargeAmortization;
    }

    public String getTakeChargeAmortizationfromDB()
    {
	return takeChargeAmortizationfromDB;
    }

    public void setTakeChargeAmortizationfromDB(String takeChargeAmortizationfromDB)
    {
	this.takeChargeAmortizationfromDB = takeChargeAmortizationfromDB;
    }
    
    public String getApplyAprRateYn() {
		return applyAprRateYn;
	}

	public void setApplyAprRateYn(String applyAprRateYn) {
		this.applyAprRateYn = applyAprRateYn;
	}

	public BigDecimal getAprRate() {
		return aprRate;
	}

	public void setAprRate(BigDecimal aprRate) {
		this.aprRate = aprRate;
	}

    public String getCalledFromCrossCySwapYN()
    {
	return calledFromCrossCySwapYN;
    }

    public void setCalledFromCrossCySwapYN(String calledFromCrossCySwapYN)
    {
	this.calledFromCrossCySwapYN = calledFromCrossCySwapYN;
    }

    public String getInformationMessageId()
    {
	return informationMessageId;
    }

    public void setInformationMessageId(String informationMessageId)
    {
	this.informationMessageId = informationMessageId;
    }

    public String getPLAN_EDIT_SCHEDULE_DETAILS_YN()
    {
	return PLAN_EDIT_SCHEDULE_DETAILS_YN;
    }

    public void setPLAN_EDIT_SCHEDULE_DETAILS_YN(String pLAN_EDIT_SCHEDULE_DETAILS_YN)
    {
	PLAN_EDIT_SCHEDULE_DETAILS_YN = pLAN_EDIT_SCHEDULE_DETAILS_YN;
    }

    public String getCallingFromOnchangeYn()
    {
	return callingFromOnchangeYn;
    }

    public void setCallingFromOnchangeYn(String callingFromOnchangeYn)
    {
	this.callingFromOnchangeYn = callingFromOnchangeYn;
    }

    public String getOnchangeColumnName()
    {
	return onchangeColumnName;
    }

    public void setOnchangeColumnName(String onchangeColumnName)
    {
	this.onchangeColumnName = onchangeColumnName;
    }

    public String getOnchangeNewType()
    {
	return onchangeNewType;
    }

    public void setOnchangeNewType(String onchangeNewType)
    {
	this.onchangeNewType = onchangeNewType;
    }

    public Date getOnchangeNewDate()
    {
	return onchangeNewDate;
    }

    public void setOnchangeNewDate(Date onchangeNewDate)
    {
	this.onchangeNewDate = onchangeNewDate;
    }

    public BigDecimal getOnchangeNewAmount()
    {
	return onchangeNewAmount;
    }

    public void setOnchangeNewAmount(BigDecimal onchangeNewAmount)
    {
	this.onchangeNewAmount = onchangeNewAmount;
    }

    public BigDecimal getOnchangeLineNbr()
    {
	return onchangeLineNbr;
    }

    public void setOnchangeLineNbr(BigDecimal onchangeLineNbr)
    {
	this.onchangeLineNbr = onchangeLineNbr;
    }

    public BigDecimal getVENDOR_DISCOUNT_AMOUNT()
    {
	return VENDOR_DISCOUNT_AMOUNT;
    }

    public void setVENDOR_DISCOUNT_AMOUNT(BigDecimal vENDOR_DISCOUNT_AMOUNT)
    {
	VENDOR_DISCOUNT_AMOUNT = vENDOR_DISCOUNT_AMOUNT;
    }

    public BigDecimal getVENDOR_DISCOUNT_YIELD()
    {
	return VENDOR_DISCOUNT_YIELD;
    }

    public void setVENDOR_DISCOUNT_YIELD(BigDecimal vENDOR_DISCOUNT_YIELD)
    {
	VENDOR_DISCOUNT_YIELD = vENDOR_DISCOUNT_YIELD;
    }

    public BigDecimal getNET_YIELD()
    {
	return NET_YIELD;
    }

    public void setNET_YIELD(BigDecimal nET_YIELD)
    {
	NET_YIELD = nET_YIELD;
    }

    public List<TRSDEAL_ASSET_VNDR_INCENTIVEVO> getTrsdealAssetVendorIncentiveList()
    {
	return trsdealAssetVendorIncentiveList;
    }

    public void setTrsdealAssetVendorIncentiveList(List<TRSDEAL_ASSET_VNDR_INCENTIVEVO> trsdealAssetVendorIncentiveList)
    {
	this.trsdealAssetVendorIncentiveList = trsdealAssetVendorIncentiveList;
    }

    public BigDecimal getYieldSign()
    {
	return yieldSign;
    }

    public void setYieldSign(BigDecimal yieldSign)
    {
	this.yieldSign = yieldSign;
    }

    public String getALLOW_RESCHEDULE_AFTER_REVALUATION_WITH_PAST_DUE_AMOUNT()
    {
	return ALLOW_RESCHEDULE_AFTER_REVALUATION_WITH_PAST_DUE_AMOUNT;
    }

    public void setALLOW_RESCHEDULE_AFTER_REVALUATION_WITH_PAST_DUE_AMOUNT(
	    String aLLOW_RESCHEDULE_AFTER_REVALUATION_WITH_PAST_DUE_AMOUNT)
    {
	ALLOW_RESCHEDULE_AFTER_REVALUATION_WITH_PAST_DUE_AMOUNT = aLLOW_RESCHEDULE_AFTER_REVALUATION_WITH_PAST_DUE_AMOUNT;
    }

    /**
     * @return the rOUND_OFF_CHARGE_YN
     */
    public String getROUND_OFF_CHARGE_YN()
    {
	return ROUND_OFF_CHARGE_YN;
    }

    /**
     * @param rOUND_OFF_CHARGE_YN the rOUND_OFF_CHARGE_YN to set
     */
    public void setROUND_OFF_CHARGE_YN(String rOUND_OFF_CHARGE_YN)
    {
	ROUND_OFF_CHARGE_YN = rOUND_OFF_CHARGE_YN;
    }

    /**
     * @return the eXCLUDE_INS_BALLOON_YN
     */
    public String getEXCLUDE_INS_BALLOON_YN()
    {
	return EXCLUDE_INS_BALLOON_YN;
    }

    /**
     * @param eXCLUDE_INS_BALLOON_YN the eXCLUDE_INS_BALLOON_YN to set
     */
    public void setEXCLUDE_INS_BALLOON_YN(String eXCLUDE_INS_BALLOON_YN)
    {
	EXCLUDE_INS_BALLOON_YN = eXCLUDE_INS_BALLOON_YN;
    }

    /**
     * @return the iNCLD_UPFRNT_INSU_FOR_REIMB_YN
     */
    public String getINCLD_UPFRNT_INSU_FOR_REIMB_YN()
    {
	return INCLD_UPFRNT_INSU_FOR_REIMB_YN;
    }

    /**
     * @param iNCLD_UPFRNT_INSU_FOR_REIMB_YN the iNCLD_UPFRNT_INSU_FOR_REIMB_YN
     *            to set
     */
    public void setINCLD_UPFRNT_INSU_FOR_REIMB_YN(String iNCLD_UPFRNT_INSU_FOR_REIMB_YN)
    {
	INCLD_UPFRNT_INSU_FOR_REIMB_YN = iNCLD_UPFRNT_INSU_FOR_REIMB_YN;
    }

    /**
     * @return the eDIT_CHARGE_REIMBURSE_AMT_YN
     */
    public String getEDIT_CHARGE_REIMBURSE_AMT_YN()
    {
	return EDIT_CHARGE_REIMBURSE_AMT_YN;
    }

    /**
     * @param eDIT_CHARGE_REIMBURSE_AMT_YN the eDIT_CHARGE_REIMBURSE_AMT_YN to
     *            set
     */
    public void setEDIT_CHARGE_REIMBURSE_AMT_YN(String eDIT_CHARGE_REIMBURSE_AMT_YN)
    {
	EDIT_CHARGE_REIMBURSE_AMT_YN = eDIT_CHARGE_REIMBURSE_AMT_YN;
    }

    /**
     * @return the aLLOW_CHARGE_FIRST_EMI_YN
     */
    public String getALLOW_CHARGE_FIRST_EMI_YN()
    {
	return ALLOW_CHARGE_FIRST_EMI_YN;
    }

    /**
     * @param aLLOW_CHARGE_FIRST_EMI_YN the aLLOW_CHARGE_FIRST_EMI_YN to set
     */
    public void setALLOW_CHARGE_FIRST_EMI_YN(String aLLOW_CHARGE_FIRST_EMI_YN)
    {
	ALLOW_CHARGE_FIRST_EMI_YN = aLLOW_CHARGE_FIRST_EMI_YN;
    }

    public BigDecimal getGovtRate()
    {
	return govtRate;
    }

    public void setGovtRate(BigDecimal govtRate)
    {
	this.govtRate = govtRate;
    }

    /**
     * @return the aMENDMENT_AMOUNT
     */
    public BigDecimal getAMENDMENT_AMOUNT()
    {
	return AMENDMENT_AMOUNT;
    }

    /**
     * @param aMENDMENT_AMOUNT the aMENDMENT_AMOUNT to set
     */
    public void setAMENDMENT_AMOUNT(BigDecimal aMENDMENT_AMOUNT)
    {
	AMENDMENT_AMOUNT = aMENDMENT_AMOUNT;
    }

    /**
     * @return the aMENDMENT_TYPE
     */
    public String getAMENDMENT_TYPE()
    {
	return AMENDMENT_TYPE;
    }

    /**
     * @param aMENDMENT_TYPE the aMENDMENT_TYPE to set
     */
    public void setAMENDMENT_TYPE(String aMENDMENT_TYPE)
    {
	AMENDMENT_TYPE = aMENDMENT_TYPE;
    }

    /**
     * @return the originalNewNoOfPayments
     */
    public BigDecimal getOriginalNewNoOfPayments()
    {
	return originalNewNoOfPayments;
    }

    /**
     * @param originalNewNoOfPayments the originalNewNoOfPayments to set
     */
    public void setOriginalNewNoOfPayments(BigDecimal originalNewNoOfPayments)
    {
	this.originalNewNoOfPayments = originalNewNoOfPayments;
    }

    /**
     * @return the increasedNoofPayment
     */
    public BigDecimal getIncreasedNoofPayment()
    {
	return increasedNoofPayment;
    }

    /**
     * @param increasedNoofPayment the increasedNoofPayment to set
     */
    public void setIncreasedNoofPayment(BigDecimal increasedNoofPayment)
    {
	this.increasedNoofPayment = increasedNoofPayment;
    }

    /**
     * @return the orgMaturityDate
     */
    public Date getOrgMaturityDate()
    {
	return orgMaturityDate;
    }

    /**
     * @param orgMaturityDate the orgMaturityDate to set
     */
    public void setOrgMaturityDate(Date orgMaturityDate)
    {
	this.orgMaturityDate = orgMaturityDate;
    }

    public BigDecimal getNoOfAdvPayments()
    {
	return noOfAdvPayments;
    }

    public void setNoOfAdvPayments(BigDecimal noOfAdvPayments)
    {
	this.noOfAdvPayments = noOfAdvPayments;
    }

    public String getAdvRepaymentYN()
    {
	return advRepaymentYN;
    }

    public void setAdvRepaymentYN(String advRepaymentYN)
    {
	this.advRepaymentYN = advRepaymentYN;
    }

    public List<TrspayplandetCO> getTrspayplandetRemAdvPaymentVOList()
    {
	return trspayplandetRemAdvPaymentVOList;
    }

    public void setTrspayplandetRemAdvPaymentVOList(List<TrspayplandetCO> trspayplandetRemAdvPaymentVOList)
    {
	this.trspayplandetRemAdvPaymentVOList = trspayplandetRemAdvPaymentVOList;
    }

    public BigDecimal getOutstandingVat()
    {
	return outstandingVat;
    }

    public void setOutstandingVat(BigDecimal outstandingVat)
    {
	this.outstandingVat = outstandingVat;
    }


    public BigDecimal getFirstLineVatToBeAdjust()
    {
	return firstLineVatToBeAdjust;
    }

    public void setFirstLineVatToBeAdjust(BigDecimal firstLineVatToBeAdjust)
    {
	this.firstLineVatToBeAdjust = firstLineVatToBeAdjust;
    }

    public String getVatAccrual()
    {
	return vatAccrual;
    }

    public void setVatAccrual(String vatAccrual)
    {
	this.vatAccrual = vatAccrual;
    }

    public String getVatRateChangedYn()
    {
	return vatRateChangedYn;
    }

    public void setVatRateChangedYn(String vatRateChangedYn)
    {
	this.vatRateChangedYn = vatRateChangedYn;
    }

    public String getAccru_newrate_frm_effect_dt_yn()
    {
	return accru_newrate_frm_effect_dt_yn;
    }

    public void setAccru_newrate_frm_effect_dt_yn(String accru_newrate_frm_effect_dt_yn)
    {
	this.accru_newrate_frm_effect_dt_yn = accru_newrate_frm_effect_dt_yn;
    }


    public BigDecimal getActualAnnualRate()
    {
	return actualAnnualRate;
    }

    public void setActualAnnualRate(BigDecimal actualAnnualRate)
    {
	this.actualAnnualRate = actualAnnualRate;
    }

    public BigDecimal getTieAdjustedAnnualRate()
    {
	return tieAdjustedAnnualRate;
    }

    public void setTieAdjustedAnnualRate(BigDecimal tieAdjustedAnnualRate)
    {
	this.tieAdjustedAnnualRate = tieAdjustedAnnualRate;
    }

    public BigDecimal getActualTegRate()
    {
	return actualTegRate;
    }

    public void setActualTegRate(BigDecimal actualTegRate)
    {
	this.actualTegRate = actualTegRate;
    }

    public BigDecimal getTieRate()
    {
	return tieRate;
    }

    public void setTieRate(BigDecimal tieRate)
    {
	this.tieRate = tieRate;
    }

    public String getTegAdjustmentType()
    {
	return tegAdjustmentType;
    }

    public void setTegAdjustmentType(String tegAdjustmentType)
    {
	this.tegAdjustmentType = tegAdjustmentType;
    }

    public String getChargeAdjustedForTie()
    {
	return chargeAdjustedForTie;
    }

    public void setChargeAdjustedForTie(String chargeAdjustedForTie)
    {
	this.chargeAdjustedForTie = chargeAdjustedForTie;
    }

    public BigDecimal getTotalSettlementChargesForTeg()
    {
	return totalSettlementChargesForTeg;
    }

    public void setTotalSettlementChargesForTeg(BigDecimal totalSettlementChargesForTeg)
    {
	this.totalSettlementChargesForTeg = totalSettlementChargesForTeg;
    }

    public String getChargeCodes()
    {
	return chargeCodes;
    }

    public void setChargeCodes(String chargeCodes)
    {
	this.chargeCodes = chargeCodes;
    }

    public Date getRunningDate()
    {
	return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public boolean isMinYeildReached()
    {
	return minYeildReached;
    }

    public void setMinYeildReached(boolean minYeildReached)
    {
	this.minYeildReached = minYeildReached;
    }

    public boolean isMinChargeReached()
    {
	return minChargeReached;
    }

    public void setMinChargeReached(boolean minChargeReached)
    {
	this.minChargeReached = minChargeReached;
    }

    public BigDecimal getFloatingRate()
    {
	return floatingRate;
    }

    public void setFloatingRate(BigDecimal floatingRate)
    {
	this.floatingRate = floatingRate;
    }

    public String getShowTegMessages()
    {
	return showTegMessages;
    }

    public void setShowTegMessages(String showTegMessages)
    {
	this.showTegMessages = showTegMessages;
    }

    public List<TRSDEALCHARGESVO> getTrsdealchargesVOList()
    {
	return trsdealchargesVOList;
    }

    public void setTrsdealchargesVOList(List<TRSDEALCHARGESVO> trsdealchargesVOList)
    {
	this.trsdealchargesVOList = trsdealchargesVOList;
    }

    public List<TRSDEALCHARGESVO> getTegAdjustmenttrsdealchargesVOList()
    {
	return tegAdjustmenttrsdealchargesVOList;
    }

    public void setTegAdjustmenttrsdealchargesVOList(List<TRSDEALCHARGESVO> tegAdjustmenttrsdealchargesVOList)
    {
	this.tegAdjustmenttrsdealchargesVOList = tegAdjustmenttrsdealchargesVOList;
    }

	public BigDecimal getPushedDownProfitAmount() {
		return pushedDownProfitAmount;
	}

	public void setPushedDownProfitAmount(BigDecimal pushedDownProfitAmount) {
		this.pushedDownProfitAmount = pushedDownProfitAmount;
	}

	public BigDecimal getVatMaxAmount() {
		return vatMaxAmount;
	}

	public void setVatMaxAmount(BigDecimal vatMaxAmount) {
		this.vatMaxAmount = vatMaxAmount;
	}

	public BigDecimal getVatMinAmount() {
		return vatMinAmount;
	}

	public void setVatMinAmount(BigDecimal vatMinAmount) {
		this.vatMinAmount = vatMinAmount;
	}

	public String getEXCLUDE_PASTDUE_AT_RESCHDL_YN() {
		return EXCLUDE_PASTDUE_AT_RESCHDL_YN;
	}

	public void setEXCLUDE_PASTDUE_AT_RESCHDL_YN(String eXCLUDE_PASTDUE_AT_RESCHDL_YN) {
		EXCLUDE_PASTDUE_AT_RESCHDL_YN = eXCLUDE_PASTDUE_AT_RESCHDL_YN;
	}

	public BigDecimal getAdvInsuranceAmount() {
		return advInsuranceAmount;
	}

	public void setAdvInsuranceAmount(BigDecimal advInsuranceAmount) {
		this.advInsuranceAmount = advInsuranceAmount;
	}

	public BigDecimal getAdvInsVatAmount() {
		return advInsVatAmount;
	}

	public void setAdvInsVatAmount(BigDecimal advInsVatAmount) {
		this.advInsVatAmount = advInsVatAmount;
	}

	public String getPROFIT_CALC_FOR_DEAL_PERIOD_YN() {
		return PROFIT_CALC_FOR_DEAL_PERIOD_YN;
	}

	public void setPROFIT_CALC_FOR_DEAL_PERIOD_YN(String pROFIT_CALC_FOR_DEAL_PERIOD_YN) {
		PROFIT_CALC_FOR_DEAL_PERIOD_YN = pROFIT_CALC_FOR_DEAL_PERIOD_YN;
	}

	public BigDecimal getAllocatedProfitAmount() {
		return allocatedProfitAmount;
	}

	public void setAllocatedProfitAmount(BigDecimal allocatedProfitAmount) {
		this.allocatedProfitAmount = allocatedProfitAmount;
	}
}