package com.path.bo.common.iis.islamiccalculator.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.fms.limitscommon.FmsLimitsCommonBO;
import com.path.bo.common.iis.IISCommonConstants;
import com.path.bo.common.iis.hijiricalendar.HijiriCalendarBO;
import com.path.bo.common.iis.islamiccalculator.IISCommonBO;
import com.path.bo.common.iis.islamiccalculator.IISIslamicCalculatorBO;
import com.path.dao.common.iis.islamiccalculator.IISIslamicCalculatorDAO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.BRANCHESVOKey;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.IISCTRLVO;
import com.path.dbmaps.vo.IISCTRLVOKey;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.TRSCHARGESVO;
import com.path.dbmaps.vo.TRSCHARGESVOKey;
import com.path.dbmaps.vo.TRSCIFLIMITDETVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSCLASSVOKey;
import com.path.dbmaps.vo.TRSCLASS_EXTENDEDVO;
import com.path.dbmaps.vo.TRSCLASS_EXTENDEDVOKey;
import com.path.dbmaps.vo.TRSDEAL2VO;
import com.path.dbmaps.vo.TRSDEAL2VOKey;
import com.path.dbmaps.vo.TRSDEAL3VO;
import com.path.dbmaps.vo.TRSDEAL3VOKey;
import com.path.dbmaps.vo.TRSDEALCHARGESVO;
import com.path.dbmaps.vo.TRSDEALCHARGESVOKey;
import com.path.dbmaps.vo.TRSDEALVO;
import com.path.dbmaps.vo.TRSDEALVOKey;
import com.path.dbmaps.vo.TRSDEAL_COUNTRY_HOLIDAYVOKey;
import com.path.dbmaps.vo.TRSDEAL_COVERING_ACCOUNTSVO;
import com.path.dbmaps.vo.TRSDEAL_MULTIPLE_YIELDVO;
import com.path.dbmaps.vo.TRSDEAL_MULTIPLE_YIELDVOKey;
import com.path.dbmaps.vo.TRSDEAL_NIDCVO;
import com.path.dbmaps.vo.TRSDEAL_NIDCVOKey;
import com.path.dbmaps.vo.TRSDEAL_NIDC_DETVO;
import com.path.dbmaps.vo.TRSDEAL_SWAP_DETAILSVO;
import com.path.dbmaps.vo.TRSDETVO;
import com.path.dbmaps.vo.TRSHIJRI_DETAIL_CALENDARVO;
import com.path.dbmaps.vo.TRSPAYPLANDETVO;
import com.path.dbmaps.vo.TRSPAYPLANDETVOKey;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTDETVO;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTDETVOKey;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVO;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVOKey;
import com.path.dbmaps.vo.TRSPAYPLANVO;
import com.path.dbmaps.vo.TRSPAYPLAN_CRITERIAVO;
import com.path.dbmaps.vo.TRSPAYPLAN_BREAKUP_PROFITVO;
import com.path.dbmaps.vo.TRSPAYPLAN_SEGMENT_START_DATESVO;
import com.path.dbmaps.vo.TRSVATVO;
import com.path.dbmaps.vo.TRSVATVOKey;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.fms.limitscommon.FmsOneObligorDetCO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IISCustomerLimitCO;
import com.path.vo.common.iis.islamiccalculator.IISHolidayCheckCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorStructurePlanDetCO;
import com.path.vo.common.iis.islamiccalculator.LOSmessagesCO;
import com.path.vo.common.iis.islamiccalculator.TrsDealSettlementChargesCO;
import com.path.vo.common.iis.islamiccalculator.TrsPlanBallonPaymentCO;
import com.path.vo.common.iis.islamiccalculator.TrspayplanCriteriaCO;
import com.path.vo.common.iis.islamiccalculator.TrspayplandetCO;

/**
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code. BO Class for IIS Islamic Calculator. Reschedule calculator
 * 
 * @author mvalappil
 * 
 */
public class IISIslamicCalculatorBOImpl extends BaseBO implements IISIslamicCalculatorBO
{

    private static final long serialVersionUID = 1L;
    private static final String INTEREST_CALCULATION_METHOD_FLAT = "F";
    private static final String INTEREST_CALCULATION_METHOD_SIMPLE = "S";

    private IISIslamicCalculatorDAO iisIslamicCalculatorDAO;
    private IISCommonBO iisCommonBO;
    private HijiriCalendarBO hijiriCalendarBO;
    private FmsLimitsCommonBO fmsLimitsCommonBO;

    public void setHijiriCalendarBO(HijiriCalendarBO hijiriCalendarBO)
    {
	this.hijiriCalendarBO = hijiriCalendarBO;
    }

    public IISCommonBO getIisCommonBO()
    {
	return iisCommonBO;
    }

    public void setIisCommonBO(IISCommonBO iisCommonBO)
    {
	this.iisCommonBO = iisCommonBO;
    }

    public IISIslamicCalculatorDAO getIisIslamicCalculatorDAO()
    {
	return iisIslamicCalculatorDAO;
    }

    public void setIisIslamicCalculatorDAO(IISIslamicCalculatorDAO iisIslamicCalculatorDAO)
    {
	this.iisIslamicCalculatorDAO = iisIslamicCalculatorDAO;
    }

    private static final String CALCULATIONTYPE_D = "D";
    private static final String CALCULATIONTYPE_Y = ConstantsCommon.YES;
    private static final String COLUMNNAME_AMOUNT = "AMOUNT";
    private static final String CALLED_FROM_IB = "IB";
    private static final String PAYPLAN_BASED_ON_REDUCE_INSTALLMENT = "R";
	    private static final long MAX_NO_OF_PAYMENTS = 720;
    private static final long MAX_LOOP_COUNT = 720;
    @Override
    public IslamicCalculatorCO createRepaymentPlan(IslamicCalculatorCO islamicCalculatorCOParam) throws BaseException
    {
	IslamicCalculatorCO islamicCalculatorCO = islamicCalculatorCOParam;
	NumberUtil.resetEmptyValues(islamicCalculatorCO);
	/**
	 * if calling from Internet Banking application, all the parameters need
	 * to be defaulted from Product class
	 */
	if(CALLED_FROM_IB.equals(islamicCalculatorCO.getCalledFromApp()))
	{
	    validateSessionVariable(islamicCalculatorCO);
	    applyDefaultValuesFromProductClass(islamicCalculatorCO);
	}
	if(IISCommonConstants.CALLED_FROM_WS.equals(islamicCalculatorCO.getCalledFromApp()))
	{
	    validateSessionVariable(islamicCalculatorCO);
	}
	// Set the needed parameter from product class and all
	// setTestValues(islamicCalculatorCO);
	if(islamicCalculatorCO.getDealNo() != null && islamicCalculatorCO.getDealNo().compareTo(BigDecimal.ZERO) == 1
		&& !ConstantsCommon.YES.equals(islamicCalculatorCO.getCalledFromFmsYN()))
	{
	    islamicCalculatorCO = defaultDealValues(islamicCalculatorCO);
	}
	/**
	 * For Bills Calculator
	 */
	validateBillsCalculator(islamicCalculatorCO);

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn())
		&& ConstantsCommon.YES.equals(islamicCalculatorCO.getNidcDeal()))
	{
	    createScheduleNidc(islamicCalculatorCO);
	    return islamicCalculatorCO;
	}

	islamicCalculatorCO = setValues(islamicCalculatorCO);
	/**
	 * Validation for Webservice Params
	 */
	if(CALLED_FROM_IB.equals(islamicCalculatorCO.getCalledFromApp())
		|| IISCommonConstants.CALLED_FROM_WS.equals(islamicCalculatorCO.getCalledFromApp()))
	{
	    validationForWebServices(islamicCalculatorCO);
	}
	/**
	 * Added on 12/06/2015 for AR-Rahnu Calulator
	 */
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getArRahnuCalculatorYN()))
	{
	    setArRahnuCalculatorDetails(islamicCalculatorCO);

	}
	else
	{
	    /**
	     * calulate annual Yield if Total Flate Rate is defined
	     */
	    calculateAnnualYield(islamicCalculatorCO);
	}

	/**
	 * Skipp Staff Plan
	 */
	if(IISCommonConstants.RESCHEDULE_TYPE_STAFF_SKIPP.equals(islamicCalculatorCO.getRescheduleType()))
	{
	    createRepaymentPlanStaffSkipping(islamicCalculatorCO);
	    return islamicCalculatorCO;
	}

	// islamicCalculatorCO.setAnnualYeild(BigDecimal.valueOf(5));
	validate(islamicCalculatorCO);
	if((islamicCalculatorCO.getDisbursementScreen()) || (IISCommonConstants.RESCHEDULE_YES
		.equals(islamicCalculatorCO.getRescheduleYn())
		&& (IISCommonConstants.RESCHEDULE_TYPE_RECALCULATE.equals(islamicCalculatorCO.getRescheduleType())
			|| (IISCommonConstants.RESCHEDULE_TYPE_ADVANCE_PRINCIPAL_SETTL
				.equals(islamicCalculatorCO.getRescheduleType())
				&& ConstantsCommon.YES
					.equals(islamicCalculatorCO.getRevaluationProfitAdjustAppliedYn())))))
	{
	    calulateAdjustSettledAmount(islamicCalculatorCO);
	}

	if(IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())
		|| IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit()))
	{

	    createScheduleNidc(islamicCalculatorCO);
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getNidcDeal()))
	    {
		return islamicCalculatorCO;
	    }
	}
	if(IISCommonConstants.COMPOUND_PROFIT_GRACE.equals(islamicCalculatorCO.getCompoundingProfit())
		|| IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit()))
	{
	    // if Compounding profit is applicable the Vat cannot be included in
	    // the installment
	    islamicCalculatorCO.setIncludeVatInInstallment(ConstantsCommon.NO);
	    String TentativeSchedule = islamicCalculatorCO.getTentativeSchedule(); // Added
	    // On
	    // 23/10/2013
	    // Compounding During Grace Period
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement())
		    && ConstantsCommon.NO.equals(islamicCalculatorCO.getTentativeSchedule()))
	    {
		islamicCalculatorCO.setTentativeSchedule(ConstantsCommon.YES);
	    }
	    islamicCalculatorCO.setTrspayplandetCompoundingGracePeriod(calculateCompoundingProfitGracePeriod(
		    islamicCalculatorCO, islamicCalculatorCO.getCompoundingProfitPeriodicity(),
		    islamicCalculatorCO.getCompoundingProfitPeriodicityNo(), islamicCalculatorCO.getValueDate(),
		    islamicCalculatorCO.getFirstPaymentDate()));
	    islamicCalculatorCO.setTentativeSchedule(TentativeSchedule); // Added
	    // On
	    // 23/10/2013
	}

	// set the plan details based on no of days/ template/ criteria
	islamicCalculatorCO = setPlandetails(islamicCalculatorCO);

	/*
	 * holidayAction = 1 or 2 need to reset the value date Apply holiday
	 * action before calculation
	 */
	if(NumberUtil.toInteger(islamicCalculatorCO.getHolidayAction()) == 1
		|| NumberUtil.toInteger(islamicCalculatorCO.getHolidayAction()) == 2
		|| NumberUtil.toInteger(islamicCalculatorCO.getHolidayAction()) == 5)
	{
	    reSetPlanHolidayDates(islamicCalculatorCO);
	}

	calculateInstallmentValues(islamicCalculatorCO);

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule())
		&& ConstantsCommon.NO.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement()))
	{
	    // trspayplandetCOListTemp =
	    // islamicCalculatorCO.getTrspayplandetVOList();
	    for(int i = 1; i < islamicCalculatorCO.getTrsDealMultipleDisbursementList().size(); i++)
	    {
		// List<TrspayplandetCO> trspayplandetCOListTemp2 = new
		// ArrayList<TrspayplandetCO>();
		Date nextDisbursementDate = islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i)
			.getVALUE_DATE();
		islamicCalculatorCO.setNextDisbursementDate(nextDisbursementDate);
		// double nextDisbursementamount =
		// islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).getAMOUNT().doubleValue();
		// islamicCalculatorCO.setValueDate(nextDisbursementDate);

		for(int j = 0; j < islamicCalculatorCO.getTrspayplandetVOList().size(); j++)
		{
		    if(islamicCalculatorCO.getTrspayplandetVOList().get(j).getVALUE_DATE().after(nextDisbursementDate))
		    {
			islamicCalculatorCO.setChangeEffectLineNo(j);
			break;
			// nextDisbursementamount = nextDisbursementamount +
			// islamicCalculatorCO.getTrspayplandetVOList().get(j).getCAPITAL_AMT().doubleValue();
			// trspayplandetCOListTemp2.add(islamicCalculatorCO.getTrspayplandetVOList().get(j));
			// islamicCalculatorCO.getTrspayplandetVOList().remove(islamicCalculatorCO.getTrspayplandetVOList().size());
		    }
		    // else
		    // {
		    // //
		    // trspayplandetCOListTemp1.add(islamicCalculatorCO.getTrspayplandetVOList().get(j));
		    // //
		    // islamicCalculatorCO.getTrspayplandetVOList().remove(j);
		    // // j = j - 1;
		    // }

		}
		// trspayplandetCOListTemp =
		// islamicCalculatorCO.getTrspayplandetVOList();
		// islamicCalculatorCO.setTrspayplandetVOList(trspayplandetCOListTemp2);
		if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			.equals(islamicCalculatorCO.getProfitCalculationMethod())
			&& islamicCalculatorCO.getChangeEffectLineNo() - 1 >= 0
			&& islamicCalculatorCO.getChangeEffectLineNo() - 1 < islamicCalculatorCO
				.getTrspayplandetVOList().size())
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(islamicCalculatorCO.getChangeEffectLineNo() - 1)
			    .setTOTAL_PRINCIPAL_OUTSTANDIG(islamicCalculatorCO.getDealAmount());
		}
		getCurrentYield(islamicCalculatorCO);
		calculateInstallmentValues(islamicCalculatorCO);
	    }

	}

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getLastInstAssetResidualYn()))
	{
	    islamicCalculatorCO.getTrspayplandetVOList().get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
		    .setPAYMENT_TYPE("E");
	    if(islamicCalculatorCO.getAssetResidualAmount().compareTo(BigDecimal.ZERO) == 1)
	    {
		// islamicCalculatorCO.getTrspayplandetVOList().get(
		// islamicCalculatorCO.getTrspayplandetVOList().size() -
		// 1).setPROFIT_AMT(BigDecimal.ZERO);
		// islamicCalculatorCO.getTrspayplandetVOList().get(
		// islamicCalculatorCO.getTrspayplandetVOList().size() -
		// 1).setPROFIT_AMT_BEFORE_XIRR(
		// BigDecimal.ZERO);

		islamicCalculatorCO.getTrspayplandetVOList()
			.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
			.setPROFIT_AMT(islamicCalculatorCO.getAssetResidualprofit());
		islamicCalculatorCO.getTrspayplandetVOList()
			.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
			.setPROFIT_AMT_BEFORE_XIRR(islamicCalculatorCO.getAssetResidualprofit());

	    }

	}

	// SBI170077 -Round off by Product type and Price of Fixed Income
	// Securities
	applyProfitAmountRounding(islamicCalculatorCO);

	setCalculatorResultSet(islamicCalculatorCO);
	// #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015
	calculateAgencyFee(islamicCalculatorCO);
	if(!(IISCommonConstants.COMPOUND_PROFIT_GRACE.equals(islamicCalculatorCO.getCompoundingProfit())
		&& IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit())))
	{
	    setUpfrontProfit(islamicCalculatorCO);
	}

	/*
	 * holidayAction != 1 and 2 need to reset the value date after the
	 * calculation Apply holiday action after calculation
	 */
	if(NumberUtil.toInteger(islamicCalculatorCO.getHolidayAction()) != 1
		&& NumberUtil.toInteger(islamicCalculatorCO.getHolidayAction()) != 2
		&& NumberUtil.toInteger(islamicCalculatorCO.getHolidayAction()) != 5
		&& NumberUtil.toInteger(islamicCalculatorCO.getHolidayAction()) > 0)
	{
	    reSetPlanHolidayDates(islamicCalculatorCO);
	}
	setScheduleFormat(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);

	// Added by Linchu for setting the no of months
	if(islamicCalculatorCO.getValueDate() != null && islamicCalculatorCO.getMaturityDate() != null)
	 {
	     BigDecimal months = BigDecimal.valueOf(DateUtil.getMonthsDifference(islamicCalculatorCO.getValueDate(),
	      islamicCalculatorCO.getMaturityDate()));
	     Date newDate = DateUtil.dateAdd("MM", months.longValue(), islamicCalculatorCO.getValueDate());
	     long days = DateUtil.numberOfDays(newDate, islamicCalculatorCO.getMaturityDate());
	     if(days > 0)
	     {
	    	 months = months.add(BigDecimal.ONE);
	     }
	     islamicCalculatorCO.setNoOfMonths(months);
	 }

	islamicCalculatorCO.setNoOfPayments(BigDecimal.valueOf(islamicCalculatorCO.getTrspayplandetVOList().size()));

	// Added by Linchu for showing a server side message.(Fix for 91215: No
	// messages in in java (one or more) and the plan goes wrong with
	// diminishing diminishing , the following details a )
	validationForPrincipalAmount(islamicCalculatorCO);
	if(CALLED_FROM_IB.equals(islamicCalculatorCO.getCalledFromApp()))
	{
	    /**
	     * Salary Checking
	     */
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    islamicCalculatorEventMgmtCO.setCifNo(islamicCalculatorCO.getCifNo());
	    islamicCalculatorEventMgmtCO.setCompCode(islamicCalculatorCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setProductClass(islamicCalculatorCO.getProductClassCode());
	    islamicCalculatorEventMgmtCO.setCurrencyCode(islamicCalculatorCO.getDealCurrency());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(islamicCalculatorCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO.setTrsPayPlandetVOList(new ArrayList<TRSPAYPLANDETVO>());
	    for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
	    {
		islamicCalculatorEventMgmtCO.getTrsPayPlandetVOList().add(trspayplandetCO);
	    }
	    islamicCalculatorEventMgmtCO.setCalledFrom(CALLED_FROM_IB);
	    iisCommonBO.checkInstamtWithCifSalPerc(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getLosMessagesCO() != null)
	    {
		islamicCalculatorCO.getLosMessagesCOList().add(islamicCalculatorEventMgmtCO.getLosMessagesCO());
		islamicCalculatorEventMgmtCO.setLosMessagesCO(null);
	    }
	    islamicCalculatorEventMgmtCO = null;
	}
	/**
	 * Reset Payment Type for IPRS deal
	 */
	reSetPaymentTypeForIprsDeal(islamicCalculatorCO);
	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);

	calculateTegAndTie(islamicCalculatorCO);
	setCalculatorResultSet(islamicCalculatorCO);
	// #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015
	//calculateAgencyFee(islamicCalculatorCO);

	return islamicCalculatorCO;
    }

    private void reSetPaymentTypeForIprsDeal(IslamicCalculatorCO islamicCalculatorCO)
    {
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCalledFromIPRSYN()))
	{
	    List<TrspayplandetCO> trspayplandetVOList = islamicCalculatorCO.getTrspayplandetVOList();
	    if(trspayplandetVOList != null && !trspayplandetVOList.isEmpty())
	    {
		int size = trspayplandetVOList.size();
		TrspayplandetCO trspayplandetCO = trspayplandetVOList.get(size - 1);
		trspayplandetCO.setPAYMENT_TYPE("P");
		BigDecimal principle_AMT = NumberUtil.nullToZero(trspayplandetCO.getPRINCIPLE_AMT());
		BigDecimal amount = NumberUtil.nullToZero(trspayplandetCO.getAMOUNT());
		trspayplandetCO.setAMOUNT(amount.subtract(principle_AMT));

		trspayplandetCO.setCAPITAL_AMT_BEFORE_XIRR(BigDecimal.ZERO);
		trspayplandetCO.setCAPITAL_AMT(BigDecimal.ZERO);
		trspayplandetCO.setPRINCIPLE_AMT(BigDecimal.ZERO);

		BigDecimal REMAINING_AMOUNT = NumberUtil.nullToZero(trspayplandetCO.getREMAINING_AMOUNT());
		trspayplandetCO.setREMAINING_AMOUNT(REMAINING_AMOUNT.subtract(principle_AMT));
	    }
	}
    }

	private Double applayRoundingType(IslamicCalculatorCO islamicCalculatorCO, Double amountParam, Long roundingFactor)
    {
	Double amount = amountParam;
	if("R".equals(islamicCalculatorCO.getROUNDING_TYPE_INST_AMT()))
	{
	    amount = NumberUtil.round(amount, roundingFactor);
	}
	else if("D".equals(islamicCalculatorCO.getROUNDING_TYPE_INST_AMT()))
	{
	    amount = NumberUtil.truncate(amount, roundingFactor);
	}
	else if("U".equals(islamicCalculatorCO.getROUNDING_TYPE_INST_AMT()))
	{
	    amount = Math.ceil(amount);
	}
	return amount;
    }
    
    private void setDefaultValues(IslamicCalculatorCO islamicCalculatorCO)
    {
	if(islamicCalculatorCO.getDealCyDecimalPoint() == null)
	{
	    islamicCalculatorCO.setDealCyDecimalPoint(2L);
	}
	if(islamicCalculatorCO.getDealCyPtMethod() == null)
	{
	    islamicCalculatorCO.setDealCyPtMethod(360L);
	}

	if(islamicCalculatorCO.getMaxYeild() == null)
	{
	    islamicCalculatorCO.setMaxYeild(BigDecimal.ZERO);
	}

	if(islamicCalculatorCO.getMinYeild() == null)
	{
	    islamicCalculatorCO.setMinYeild(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getCompudingDealPeriod() == null)
	{
	    islamicCalculatorCO.setCompudingDealPeriod("N");
	}
	if(islamicCalculatorCO.getCompoudingGracePeriod() == null)
	{
	    islamicCalculatorCO.setCompoudingGracePeriod("N");
	}
	if(islamicCalculatorCO.getProfitAccrualBasis() == null)
	{
	    islamicCalculatorCO.setProfitAccrualBasis(1L);
	}
	if(islamicCalculatorCO.getTemplateCode() == null)
	{
	    islamicCalculatorCO.setTemplateCode(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getPaymentPeriodicity() == null)
	{
	    islamicCalculatorCO.setPaymentPeriodicity("D");
	}
	if(islamicCalculatorCO.getPaymentPeriodicityNo() == null)
	{
	    islamicCalculatorCO.setPaymentPeriodicityNo(1L);
	}
	if(islamicCalculatorCO.getPaymentPeriodicityMonthPos() == null)
	{
	    islamicCalculatorCO.setPaymentPeriodicityMonthPos("E");
	}
	if(islamicCalculatorCO.getResidualValue() == null)
	{
	    islamicCalculatorCO.setResidualValue("L");
	}
	if(islamicCalculatorCO.getAmountPerPayment() == null)
	{
	    islamicCalculatorCO.setAmountPerPayment(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getAmountPerPaymentEqualDisbur() == null)
	{
	    islamicCalculatorCO.setAmountPerPaymentEqualDisbur(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getRoundingFactor() == null)
	{
	    islamicCalculatorCO.setRoundingFactor(0L);
	}
	if(islamicCalculatorCO.getPrincipalInLastPayment() == null)
	{
	    islamicCalculatorCO.setPrincipalInLastPayment("N");
	}
	if(islamicCalculatorCO.getTentativeSchedule() == null)
	{
	    islamicCalculatorCO.setTentativeSchedule("N");
	}
	if(islamicCalculatorCO.getOutstandingPrincipalAsInstallment() == null)
	{
	    islamicCalculatorCO.setOutstandingPrincipalAsInstallment("N");
	}
	if(islamicCalculatorCO.getEqualSegments() == null)
	{

	    islamicCalculatorCO.setEqualSegments("N");
	}
	if(islamicCalculatorCO.getCapitalization() == null)
	{
	    islamicCalculatorCO.setCapitalization("N");
	}
	if(islamicCalculatorCO.getCapitalizePeriodicity() == null)
	{

	    islamicCalculatorCO.setCapitalizePeriodicity("D");
	}
	if(islamicCalculatorCO.getCapitalizePeriodicityNopos() == null)
	{
	    islamicCalculatorCO.setCapitalizePeriodicityNopos("E");
	}
	if(islamicCalculatorCO.getCompoundingProfitPeriodicityNo() == null)
	{
	    islamicCalculatorCO.setCompoundingProfitPeriodicityNo(1l);
	}
	if(islamicCalculatorCO.getRescheduleType() == null)
	{

	    islamicCalculatorCO.setRescheduleType("");
	}
	if(islamicCalculatorCO.getRescheduleYn() == null)
	{
	    islamicCalculatorCO.setRescheduleYn("false");
	}
	if(islamicCalculatorCO.getRevaluationProcess() == null)
	{
	    islamicCalculatorCO.setRevaluationProcess("N");
	}
	if(islamicCalculatorCO.getOutstandingProfit() == null)
	{

	    islamicCalculatorCO.setOutstandingProfit(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getAdditionalProfit() == null)
	{
	    islamicCalculatorCO.setAdditionalProfit(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getProfitOnCharges() == null)
	{

	    islamicCalculatorCO.setProfitOnCharges(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getProfitOnInsurance() == null)
	{
	    islamicCalculatorCO.setProfitOnInsurance(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getTotalCharges() == null)
	{
	    islamicCalculatorCO.setTotalCharges(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getTotalInsurance() == null)
	{
	    islamicCalculatorCO.setTotalInsurance(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getIncludeInstallmentDateInProfitCalculation() == null)
	{

	    islamicCalculatorCO.setIncludeInstallmentDateInProfitCalculation("N");
	}
	if(islamicCalculatorCO.getRedusingBalanceMethod() == null)
	{
	    islamicCalculatorCO.setRedusingBalanceMethod("N");
	}
	if(islamicCalculatorCO.getCalendarType() == null)
	{
	    islamicCalculatorCO.setCalendarType("G");
	}
	if(islamicCalculatorCO.getTotalBalloonAmount() == null)
	{
	    islamicCalculatorCO.setTotalBalloonAmount(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getBalloonPayment() == null)
	{
	    islamicCalculatorCO.setBalloonPayment(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getNoOfBaloonPayments() == null)
	{
	    islamicCalculatorCO.setNoOfBaloonPayments(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getProfitCalculateAsOnYieldDate() == null)
	{
	    islamicCalculatorCO.setProfitCalculateAsOnYieldDate("N");
	}
	if(islamicCalculatorCO.getCompoundingProfit() == null)
	{
	    islamicCalculatorCO.setCompoundingProfit("N");
	}
	if(islamicCalculatorCO.getTrspayplandetVOList() == null)
	{
	    islamicCalculatorCO.setTrspayplandetVOList(new ArrayList<TrspayplandetCO>());
	}
	if(islamicCalculatorCO.getTrspayplandetCompoundingDealPeriod() == null)
	{
	    islamicCalculatorCO.setTrspayplandetCompoundingDealPeriod(new ArrayList<TrspayplandetCO>());
	}
	if(islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod() == null)
	{
	    islamicCalculatorCO.setTrspayplandetCompoundingGracePeriod(new ArrayList<TrspayplandetCO>());
	}
	if(islamicCalculatorCO.getApplyRoundingFact_after_calc() == null)
	{
	    islamicCalculatorCO.setApplyRoundingFact_after_calc("N");
	}
	if(islamicCalculatorCO.getInstAmtInBalloon() == null)
	{
	    islamicCalculatorCO.setInstAmtInBalloon("N");
	}
	if(islamicCalculatorCO.getInstAmtInLastBalloon() == null)
	{
	    islamicCalculatorCO.setInstAmtInLastBalloon("N");
	}
	if(islamicCalculatorCO.getCompoundingProfitPeriodicity() == null)
	{
	    islamicCalculatorCO.setCompoundingProfitPeriodicity("N");
	}
	if(islamicCalculatorCO.getSegmentAppliedYn() == null)
	{
	    islamicCalculatorCO.setSegmentAppliedYn("N");
	}
	if(islamicCalculatorCO.getExcessProfitInNextInstallment() == null)
	{
	    islamicCalculatorCO.setExcessProfitInNextInstallment("Y");
	}
	if(islamicCalculatorCO.getHolidayAction() == null)
	{
	    islamicCalculatorCO.setHolidayAction(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getIncludeVatInInstallment() == null)
	{
	    islamicCalculatorCO.setIncludeVatInInstallment("N");
	}
	if(islamicCalculatorCO.getCalculateVatAfterSchedule() == null)
	{
	    islamicCalculatorCO.setCalculateVatAfterSchedule("Y");
	}
	if(islamicCalculatorCO.getVatPercentageOn() == null)
	{
	    islamicCalculatorCO.setVatPercentageOn("P");
	}
	if(islamicCalculatorCO.getTotalVatAmount() == null)
	{
	    islamicCalculatorCO.setTotalVatAmount(0D);
	}
	if(islamicCalculatorCO.getTotalAllocatedVatAmount() == null)
	{
	    islamicCalculatorCO.setTotalAllocatedVatAmount(0D);
	}
	if(islamicCalculatorCO.getDailyDepreciationYn() == null)
	{
	    islamicCalculatorCO.setDailyDepreciationYn("N");
	}
	if(islamicCalculatorCO.getXirrOut() == null)
	{
	    islamicCalculatorCO.setXirrOut(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getOutRemainingAmount() == null)
	{
	    islamicCalculatorCO.setOutRemainingAmount(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getOutProfitAmount() == null)
	{
	    islamicCalculatorCO.setOutProfitAmount(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getOutAmountPerPayment() == null)
	{
	    islamicCalculatorCO.setOutAmountPerPayment(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getOutSaleAmount() == null)
	{
	    islamicCalculatorCO.setOutSaleAmount(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getOutAnnualFlatRate() == null)
	{
	    islamicCalculatorCO.setOutAnnualFlatRate(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getOutTotalFlatRate() == null)
	{
	    islamicCalculatorCO.setOutTotalFlatRate(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getOutResidualValueDownPayment() == null)
	{
	    islamicCalculatorCO.setOutResidualValueDownPayment(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getOutNoOfPayments() == null)
	{
	    islamicCalculatorCO.setOutNoOfPayments(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getCalculatorType() == null)
	{

	    islamicCalculatorCO.setCalculatorType("CALCULATOR");
	}
	if(islamicCalculatorCO.getHolidayActionConformationYn() == null)
	{
	    islamicCalculatorCO.setHolidayActionConformationYn("N");
	}
	if(islamicCalculatorCO.getPlanChargesAmount() == null)
	{
	    islamicCalculatorCO.setPlanChargesAmount(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getPlanChargesAmountForPrfotCalc() == null)
	{
	    islamicCalculatorCO.setPlanChargesAmountForPrfotCalc(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getDownPaymentAmt() == null)
	{
	    islamicCalculatorCO.setDownPaymentAmt(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getDealPeriodCompoundingPeriodicityNo() == null)
	{
	    islamicCalculatorCO.setDealPeriodCompoundingPeriodicityNo(1l);
	}
	if(islamicCalculatorCO.getDealPeriodCompoundingPeriodicity() == null)
	{
	    islamicCalculatorCO.setDealPeriodCompoundingPeriodicity("M");
	}
	if(islamicCalculatorCO.getPreviousDealAmount() == null)
	{
	    islamicCalculatorCO.setPreviousDealAmount(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getDisburs_maintain_indiv_plan_yn() == null)
	{
	    islamicCalculatorCO.setDisburs_maintain_indiv_plan_yn("N");
	}
	if(islamicCalculatorCO.getMudarabahRateCode() == null)
	{
	    islamicCalculatorCO.setMudarabahRateCode(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getConfirm_messages() == null)
	{

	    islamicCalculatorCO.setConfirm_messages(new ArrayList<String>());
	}
	if(islamicCalculatorCO.getNidcDeal() == null)
	{
	    islamicCalculatorCO.setNidcDeal("N");
	}
	if(islamicCalculatorCO.getSettlmentType() == null)
	{
	    islamicCalculatorCO.setSettlmentType("");
	}
	if(islamicCalculatorCO.getPrevAnnualYield() == null)
	{
	    islamicCalculatorCO.setPrevAnnualYield(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getYieldRequiredYn() == null)
	{
	    islamicCalculatorCO.setYieldRequiredYn("Y");
	}

	if(islamicCalculatorCO.getRevaluationProfitAdjustAppliedYn() == null)
	{
	    islamicCalculatorCO.setRevaluationProfitAdjustAppliedYn("N");
	}

	if(islamicCalculatorCO.getIdec_outstanding_grace_compounding_pft() == null)
	{
	    islamicCalculatorCO.setIdec_outstanding_grace_compounding_pft(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getLanguage() == null || islamicCalculatorCO.getLanguage().isEmpty())
	{
	    islamicCalculatorCO.setLanguage("EN");
	}
    }

	 private void validationForWebServices(IslamicCalculatorCO islamicCalculatorCO) throws BaseException, BOException
    {

	// if calling from Internet Banking application, all the parameters
	// need to be defaulted from Product class
	if(CALLED_FROM_IB.equals(islamicCalculatorCO.getCalledFromApp()))
	{
	    applyDefaultValuesFromProductClass(islamicCalculatorCO);
	}

	COMPANIESVO compVO = new COMPANIESVO();
	compVO.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	compVO = commonLibBO.returnCompany(compVO);
	if(compVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
	}
	islamicCalculatorCO.setBaseCurrencyCode(compVO.getBASE_CURRENCY());
	compVO = null;
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	islamicCalculatorEventMgmtCO.setCompCode(islamicCalculatorCO.getCompanyCode());
	islamicCalculatorEventMgmtCO.setBranchCode(islamicCalculatorCO.getBranchCode());
	islamicCalculatorEventMgmtCO.setCifNo(islamicCalculatorCO.getCifNo());
	islamicCalculatorEventMgmtCO.setProductClass(islamicCalculatorCO.getProductClassCode());
	islamicCalculatorEventMgmtCO.setYield(islamicCalculatorCO.getAnnualYeild());
	islamicCalculatorEventMgmtCO.setFinancingAmount(islamicCalculatorCO.getDealAmount());
	islamicCalculatorEventMgmtCO.setRoundingFactor(BigDecimal.valueOf(islamicCalculatorCO.getRoundingFactor()));
	islamicCalculatorEventMgmtCO.setMaturityDate(islamicCalculatorCO.getMaturityDate());
	islamicCalculatorEventMgmtCO.setValueDate(islamicCalculatorCO.getValueDate());
	islamicCalculatorEventMgmtCO.setProfitCalcMethod(islamicCalculatorCO.getProfitCalculationMethod());
	islamicCalculatorEventMgmtCO.setNoOfPayments(islamicCalculatorCO.getNoOfPayments());
	islamicCalculatorEventMgmtCO.setStartDate(islamicCalculatorCO.getValueDate());
	islamicCalculatorEventMgmtCO.setFirstPaymentDate(islamicCalculatorCO.getFirstPaymentDate());
	islamicCalculatorEventMgmtCO.setYieldRequired(islamicCalculatorCO.getYieldRequiredYn());
	islamicCalculatorEventMgmtCO
		.setAmountPerPayment(NumberUtil.emptyDecimalToZero(islamicCalculatorCO.getAmountPerPayment()));
	islamicCalculatorEventMgmtCO
		.setPaymPeriodNbr(BigDecimal.valueOf(islamicCalculatorCO.getPaymentPeriodicityNo()));
	islamicCalculatorEventMgmtCO.setPaymPeriodicity(islamicCalculatorCO.getPaymentPeriodicity());

	islamicCalculatorEventMgmtCO.setDealPeriodCompounding(islamicCalculatorCO.getCompudingDealPeriod());
	if(IISCommonConstants.CALLED_FROM_WS.equals(islamicCalculatorCO.getCalledFromApp()))
	{
	    islamicCalculatorEventMgmtCO.setCalledFrom(IISCommonConstants.CALLED_FROM_WS);
	}
	else
	{
	    islamicCalculatorEventMgmtCO.setCalledFrom(CALLED_FROM_IB);
	}

	islamicCalculatorCO.setLosMessagesCOList(new ArrayList<LOSmessagesCO>());
	if(islamicCalculatorEventMgmtCO.getMaturityDate().before(islamicCalculatorEventMgmtCO.getValueDate())
		|| islamicCalculatorEventMgmtCO.getMaturityDate().equals(islamicCalculatorEventMgmtCO.getValueDate()))
	{
	    throw new BOException(MessageCodes.MATURITY_DATE_CANNOT_BE_BEFORE_OR_EQUAL_VALUE_DATE);
	}
	if(!("D".equals(islamicCalculatorEventMgmtCO.getPaymPeriodicity())
		|| "W".equals(islamicCalculatorEventMgmtCO.getPaymPeriodicity())
		|| "M".equals(islamicCalculatorEventMgmtCO.getPaymPeriodicity())
		|| "Q".equals(islamicCalculatorEventMgmtCO.getPaymPeriodicity())
		|| "S".equals(islamicCalculatorEventMgmtCO.getPaymPeriodicity())
		|| "A".equals(islamicCalculatorEventMgmtCO.getPaymPeriodicity())))
	{

	    throw new BOException(MessageCodes.INVALID_PAYMENTS_PERIODICITY_TYPE);
	}

	if(islamicCalculatorEventMgmtCO.getFinancingAmount() == null
		|| islamicCalculatorEventMgmtCO.getFinancingAmount().compareTo(BigDecimal.ZERO) <= 0)
	{
	    throw new BOException(MessageCodes.INVALID_AMOUNT);
	}
	if(islamicCalculatorEventMgmtCO.getAmountPerPayment().compareTo(BigDecimal.ZERO) < 0
		|| islamicCalculatorEventMgmtCO.getAmountPerPayment()
			.compareTo(BigDecimal.valueOf(999999999.999999999)) == 1)
	{
	    // throw new
	    // BOException(MessageCodes.AMT_SHOULD_BE_BTW_0_AND_999999999,
	    // "0", "999999999.999999999");
	    throw new BOException(MessageCodes.AMOUNT_PER_PAYMENT_SHOULD_BE_BETWEEN_0_AND_999999999_999999999);
	}

	if(NumberUtil.nullToZero(islamicCalculatorCO.getCifNo()).compareTo(BigDecimal.ZERO) == 1)
	{
	    /**
	     * General Customer limit
	     */
	    IISCustomerLimitCO iisCustomerLimitCO = new IISCustomerLimitCO();
	    iisCustomerLimitCO.setCompCode(islamicCalculatorCO.getCompanyCode());
	    iisCustomerLimitCO.setBranchCode(islamicCalculatorCO.getBranchCode());
	    iisCustomerLimitCO.setCifNo(islamicCalculatorCO.getCifNo());
	    iisCustomerLimitCO.setDealAmount(islamicCalculatorCO.getDealAmount());
	    iisCustomerLimitCO.setDealCY(islamicCalculatorCO.getDealCurrency());
	    iisCustomerLimitCO.setBaseCurrencyCode(islamicCalculatorCO.getBaseCurrencyCode());
	    iisCustomerLimitCO.setRunningDate(islamicCalculatorCO.getValueDate());
	    iisCustomerLimitCO.setCalledFrom("LOS");
	    iisCustomerLimitCO = iisCommonBO.validateGeneralCustomerLimit(iisCustomerLimitCO);
	    if(iisCustomerLimitCO.getLosMessagesCO() != null)
	    {
		islamicCalculatorCO.getLosMessagesCOList().add(iisCustomerLimitCO.getLosMessagesCO());
	    }
	    iisCustomerLimitCO = null;
	    islamicCalculatorEventMgmtCO = iisCommonBO.showWarningForCifSalaryMultiple(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getLosMessagesCO() != null)
	    {
		islamicCalculatorCO.getLosMessagesCOList().add(islamicCalculatorEventMgmtCO.getLosMessagesCO());
		islamicCalculatorEventMgmtCO.setLosMessagesCO(null);
	    }
	    iisCommonBO.validateForCifSalaryMultiple(islamicCalculatorEventMgmtCO);

	    islamicCalculatorEventMgmtCO = iisCommonBO.checkCifExistingDeals(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getLosMessagesCO() != null)
	    {
		islamicCalculatorCO.getLosMessagesCOList().add(islamicCalculatorEventMgmtCO.getLosMessagesCO());
		islamicCalculatorEventMgmtCO.setLosMessagesCO(null);
	    }
	}
	islamicCalculatorEventMgmtCO = iisCommonBO.validateFieldsForDealCharges(islamicCalculatorEventMgmtCO);
	if(islamicCalculatorEventMgmtCO.getLosMessagesCO() != null)
	{
	    islamicCalculatorCO.getLosMessagesCOList().add(islamicCalculatorEventMgmtCO.getLosMessagesCO());
	    islamicCalculatorEventMgmtCO.setLosMessagesCO(null);
	}

	islamicCalculatorEventMgmtCO = iisCommonBO
		.validateMaxFinancingAmountForDealCharges(islamicCalculatorEventMgmtCO);
	if(islamicCalculatorEventMgmtCO.getLosMessagesCO() != null)
	{
	    islamicCalculatorCO.getLosMessagesCOList().add(islamicCalculatorEventMgmtCO.getLosMessagesCO());
	    islamicCalculatorEventMgmtCO.setLosMessagesCO(null);
	}

	islamicCalculatorEventMgmtCO = iisCommonBO.validateNoOfPaymentsForDealCharges(islamicCalculatorEventMgmtCO);
	if(islamicCalculatorEventMgmtCO.getLosMessagesCO() != null)
	{
	    islamicCalculatorCO.getLosMessagesCOList().add(islamicCalculatorEventMgmtCO.getLosMessagesCO());
	    islamicCalculatorEventMgmtCO.setLosMessagesCO(null);
	}
	if(islamicCalculatorCO.getFirstPaymentDate() != null)
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorCO.getCompanyCode());
	    iisCommonCO.setProductClass(islamicCalculatorCO.getProductClassCode());
	    iisCommonCO.setGracePeriodicity("D");
	    iisCommonCO.setGracePeriod(BigDecimal.valueOf(DateUtil.numberOfDays(islamicCalculatorCO.getValueDate(),
		    islamicCalculatorCO.getFirstPaymentDate())));
	    iisCommonBO.checkGracePeriod(iisCommonCO);
	}

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getFlexiPaymentYn()))
	{
	    BigDecimal flexiMonth = NumberUtil.emptyDecimalToZero(islamicCalculatorCO.getFlexiPaymentsMonth());
	    if(flexiMonth.compareTo(BigDecimal.ZERO) < 1 || flexiMonth.compareTo(BigDecimal.valueOf(12)) == 1)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_FLEXI_PAYMENTS_MONTH);
	    }
	    islamicCalculatorEventMgmtCO.setFlexiPaymentYn(islamicCalculatorCO.getFlexiPaymentYn());
	    islamicCalculatorEventMgmtCO.setProfitCalcMethod(islamicCalculatorCO.getProfitCalculationMethod());
	    islamicCalculatorEventMgmtCO.setPaymPeriodicity(islamicCalculatorCO.getPaymentPeriodicity());
	    islamicCalculatorEventMgmtCO.setNoOfPayments(islamicCalculatorCO.getNoOfPayments());
	    islamicCalculatorEventMgmtCO.setProductClass(islamicCalculatorCO.getProductClassCode());
	    islamicCalculatorEventMgmtCO.setRepaymentCriteriaRowCount(BigDecimal.ZERO);
	    islamicCalculatorEventMgmtCO.setNoOfBaloonPayments(islamicCalculatorCO.getNoOfBaloonPayments());
	    islamicCalculatorEventMgmtCO.setTempCode(islamicCalculatorCO.getTemplateCode());
	    islamicCalculatorEventMgmtCO.setPrincipalLast(islamicCalculatorCO.getRedusingBalanceMethod());
	    islamicCalculatorEventMgmtCO.setRepaymentCriteriaRowCount(
		    BigDecimal.valueOf(islamicCalculatorCO.getTrsPayPlanCriteriaVO().size()));
	    iisCommonBO.validateFlexiPayment(islamicCalculatorEventMgmtCO);
	}
	else
	{
	    islamicCalculatorCO.setFlexiPaymentYn(ConstantsCommon.NO);

	}
	islamicCalculatorEventMgmtCO = validateOneObligorGlobalLimit(islamicCalculatorEventMgmtCO);
	for(TrspayplanCriteriaCO trspayplanCriteriaCO : islamicCalculatorCO.getTrsPayPlanCriteriaVO())
	{
	    TRSPAYPLAN_CRITERIAVO trspayPlanCriteriaVO = new TRSPAYPLAN_CRITERIAVO();
	    List<TRSPAYPLAN_CRITERIAVO> payPlancriteriaList = new ArrayList<TRSPAYPLAN_CRITERIAVO>();
	    PathPropertyUtil.copyMainNotNullProperties(trspayplanCriteriaCO, trspayPlanCriteriaVO);
	    payPlancriteriaList.add(trspayPlanCriteriaVO);
	    islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVO(payPlancriteriaList);
	}
	islamicCalculatorEventMgmtCO = validateRepayamentCriteriaList(islamicCalculatorEventMgmtCO);
	validateDealChargesList(islamicCalculatorCO.getTrsdealchargesVO());
	islamicCalculatorEventMgmtCO.setNoOfBaloonPayments(islamicCalculatorCO.getNoOfBaloonPayments());
	islamicCalculatorEventMgmtCO.setBaseCurrencyCode(islamicCalculatorCO.getBaseCurrencyCode());
	populateOnChangeNoOfBalloons(islamicCalculatorEventMgmtCO);
	islamicCalculatorEventMgmtCO.setBaloonAmount(islamicCalculatorCO.getTotalBalloonAmount());
	populateOnChangeBalloonPaymentAmount(islamicCalculatorEventMgmtCO);
    }

    private void validateSessionVariable(IslamicCalculatorCO islamicCalculatorCO) throws BaseException, BOException
    {
	COMPANIESVO compVO = new COMPANIESVO();
	compVO.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	compVO = commonLibBO.returnCompany(compVO);
	if(compVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
	}
	if(NumberUtil.isEmptyDecimal(islamicCalculatorCO.getBranchCode()))
	{
	    throw new BOException(MessageCodes.INVALID_BRANCH_CODE);
	}
	BRANCHESVOKey branchKey = new BRANCHESVOKey();
	branchKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	branchKey.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
	BRANCHESVO branchesvo = commonLibBO.returnBranch(branchKey);
	if(branchesvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_BRANCH_CODE);
	}
    }

    // DASI170030 TP 555811 Fawas.Kuruvakkottil 18/09/2017 Start
    /**
     * @param islamicCalculatorCO
     */
    // private void applyDistributionStraightLine(IslamicCalculatorCO
    // islamicCalculatorCO)
    // {
    // if(islamicCalculatorCO.getTrspayplandetVOList() == null ||
    // islamicCalculatorCO.getTrspayplandetVOList().isEmpty())
    // {
    // return;
    // }
    //
    // BigDecimal totalProfitAmount =
    // BigDecimal.valueOf(getTotalProfit(islamicCalculatorCO));
    // int numberOfIns = islamicCalculatorCO.getTrspayplandetVOList().size();
    // BigDecimal installmentProfit =
    // totalProfitAmount.divide(BigDecimal.valueOf(numberOfIns),
    // islamicCalculatorCO.getDealCyDecimalPoint().intValue(),
    // BigDecimal.ROUND_HALF_UP);
    // BigDecimal totalAllocatedProfit = BigDecimal.ZERO;
    // BigDecimal totalOutstandingAmount =
    // islamicCalculatorCO.getTentativeSchedule().equals(ConstantsCommon.NO)
    // ?islamicCalculatorCO.getDealAmount()
    // : BigDecimal.valueOf(islamicCalculatorCO.getOutstandingAmountForXIRR());
    // totalOutstandingAmount = (totalOutstandingAmount
    // .add(islamicCalculatorCO.getTotalCharges()))
    // .add(islamicCalculatorCO.getTotalInsurance())
    // .add(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());
    // totalOutstandingAmount =
    // NumberUtil.roundToBigDecimal(totalOutstandingAmount.doubleValue(),
    // islamicCalculatorCO.getDealCyDecimalPoint());
    // BigDecimal pushDownProfit = BigDecimal.ZERO;
    // BigDecimal toalVat = returnTotalVat(islamicCalculatorCO);
    // BigDecimal allocatedCharges = BigDecimal.ZERO;
    // BigDecimal allocatedInsurance = BigDecimal.ZERO;
    //
    // BigDecimal pushedDownCharges = BigDecimal.ZERO;
    // BigDecimal pushedDownInsurance = BigDecimal.ZERO;
    //
    //
    //
    // int count = 0;
    // BigDecimal allocatedVat = BigDecimal.ZERO;
    // for(TrspayplandetCO trspayplandetCO :
    // islamicCalculatorCO.getTrspayplandetVOList())
    // {
    // count++;
    // BigDecimal currentCharge =
    // NumberUtil.nullToZero(trspayplandetCO.getCHARGE_AMOUNT());
    // BigDecimal currentInsurance =
    // NumberUtil.nullToZero(trspayplandetCO.getINSURANCE_AMOUNT());
    //
    // currentCharge = currentCharge.add(pushedDownCharges);
    // currentInsurance = currentInsurance.add(pushedDownInsurance);
    //
    // pushedDownCharges = BigDecimal.ZERO;
    // pushedDownInsurance = BigDecimal.ZERO;
    //
    // BigDecimal lineInstallmentProfit = installmentProfit.add(pushDownProfit);
    // pushDownProfit = BigDecimal.ZERO;
    // BigDecimal installmentAmount = trspayplandetCO.getAMOUNT();
    // if(installmentAmount.compareTo(installmentProfit) < 0)
    // {
    // lineInstallmentProfit = installmentAmount;
    // pushDownProfit = installmentProfit.subtract(lineInstallmentProfit);
    // }
    // if(count == numberOfIns)
    // {
    // BigDecimal diff = totalProfitAmount.subtract(totalAllocatedProfit);
    // lineInstallmentProfit = diff;
    // }
    // BigDecimal newVatAmount = trspayplandetCO.getVAT_AMOUNT();
    // if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment())
    // && islamicCalculatorCO.getVatPercentageOn().equals("P"))
    // {
    // newVatAmount = BigDecimal.valueOf(calculateVatAmount(islamicCalculatorCO,
    // NumberUtil.toDouble(installmentAmount),
    // NumberUtil.toDouble(lineInstallmentProfit), ConstantsCommon.NO));
    //
    // }
    //
    //
    // if(count == numberOfIns)
    // {
    // BigDecimal vatDiff=toalVat.subtract(allocatedVat);
    // newVatAmount = vatDiff;
    // }
    // trspayplandetCO.setVAT_AMOUNT(newVatAmount);
    // trspayplandetCO.setPROFIT_AMT(lineInstallmentProfit);
    // BigDecimal subtract = installmentAmount.subtract(lineInstallmentProfit);
    // trspayplandetCO.setCAPITAL_AMT(subtract.subtract(newVatAmount));
    // BigDecimal capitalAmount =
    // NumberUtil.nullToZero(trspayplandetCO.getCAPITAL_AMT());
    //
    // if(count == numberOfIns)
    // {
    // currentCharge =
    // islamicCalculatorCO.getTotalCharges().subtract(allocatedCharges);
    // currentInsurance =
    // islamicCalculatorCO.getTotalInsurance().subtract(allocatedInsurance);
    //
    // }else if(capitalAmount.compareTo((currentCharge.add(currentInsurance)))
    // == -1)
    // {
    // BigDecimal tempCapitalAmount = capitalAmount;
    // if(tempCapitalAmount.compareTo((currentCharge)) == -1)
    // {
    // pushedDownCharges = currentCharge.subtract(tempCapitalAmount);
    // currentCharge = tempCapitalAmount;
    // }
    // tempCapitalAmount = tempCapitalAmount.subtract(currentCharge);
    //
    // if(tempCapitalAmount.compareTo((currentInsurance)) == -1)
    // {
    // pushedDownInsurance = currentInsurance.subtract(tempCapitalAmount);
    // currentInsurance = tempCapitalAmount;
    // }
    // }
    // trspayplandetCO.setCHARGE_AMOUNT(currentCharge);
    // trspayplandetCO.setINSURANCE_AMOUNT(currentInsurance);
    //
    // trspayplandetCO.setPRINCIPLE_AMT(capitalAmount
    // .subtract((NumberUtil.nullToZero(trspayplandetCO.getCHARGE_AMOUNT())
    // .add(NumberUtil.nullToZero(trspayplandetCO.getINSURANCE_AMOUNT())))));
    // trspayplandetCO.setTOTAL_PRINCIPAL_OUTSTANDIG(totalOutstandingAmount);
    // trspayplandetCO.setPUSHDOWN_PROFIT_AFTER_XIRR(pushDownProfit);
    // totalOutstandingAmount = totalOutstandingAmount.subtract(capitalAmount);
    // totalAllocatedProfit = totalAllocatedProfit.add(lineInstallmentProfit);
    // allocatedVat =
    // allocatedVat.add(NumberUtil.nullToZero(trspayplandetCO.getVAT_AMOUNT()));
    // allocatedCharges =
    // allocatedCharges.add(NumberUtil.nullToZero(trspayplandetCO.getCHARGE_AMOUNT()));
    // allocatedInsurance =
    // allocatedInsurance.add(trspayplandetCO.getINSURANCE_AMOUNT());
    // }
    //
    // if
    // (islamicCalculatorCO.getTrspayplandetVOList().get(islamicCalculatorCO.getTrspayplandetVOList().size()-1).getPRINCIPLE_AMT().compareTo(BigDecimal.ZERO)
    // ==-1 )
    // {
    // int rows = islamicCalculatorCO.getTrspayplandetVOList().size()-1;
    // BigDecimal diffAmount =
    // islamicCalculatorCO.getTrspayplandetVOList().get(rows).getPRINCIPLE_AMT().abs()
    // ;
    // BigDecimal adjustedCharges = BigDecimal.ZERO;
    // BigDecimal adjustedInsurance = BigDecimal.ZERO;
    //
    //
    // for (int i = rows; i >= 0; i--) {
    // TrspayplandetCO trspayplandetCO =
    // islamicCalculatorCO.getTrspayplandetVOList().get(i);
    //
    // BigDecimal capitalAmount = trspayplandetCO.getCAPITAL_AMT();
    // BigDecimal chargesAmount = trspayplandetCO.getCHARGE_AMOUNT();
    // BigDecimal insuranceAmount = trspayplandetCO.getINSURANCE_AMOUNT();
    // //BigDecimal principalAmount =
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).getPRINCIPLE_AMT();
    //
    // chargesAmount = chargesAmount.add(adjustedCharges);
    // insuranceAmount = insuranceAmount.add(adjustedInsurance);
    // adjustedCharges = BigDecimal.ZERO;
    // adjustedInsurance = BigDecimal.ZERO;
    // if(chargesAmount.compareTo(capitalAmount) == 1){
    // adjustedCharges = chargesAmount.subtract(capitalAmount);
    // chargesAmount = capitalAmount;
    // capitalAmount = BigDecimal.ZERO;
    // }else{
    // capitalAmount = capitalAmount.subtract(chargesAmount);
    // }
    //
    // if(insuranceAmount.compareTo(capitalAmount) == 1){
    // adjustedInsurance = insuranceAmount.subtract(capitalAmount);
    // insuranceAmount = capitalAmount;
    // capitalAmount = BigDecimal.ZERO;
    // }else{
    // capitalAmount = capitalAmount.subtract(insuranceAmount);
    // }
    //
    // trspayplandetCO.setCHARGE_AMOUNT(chargesAmount);
    // trspayplandetCO.setINSURANCE_AMOUNT(insuranceAmount);
    //
    // trspayplandetCO.setPRINCIPLE_AMT(trspayplandetCO.getCAPITAL_AMT()
    // .subtract((NumberUtil.nullToZero(trspayplandetCO.getCHARGE_AMOUNT())
    // .add(NumberUtil.nullToZero(trspayplandetCO.getINSURANCE_AMOUNT())))));
    //
    // if (adjustedCharges.compareTo(BigDecimal.ZERO) == 0
    // && adjustedInsurance.compareTo(BigDecimal.ZERO) == 0 ){
    // break;
    // }
    // }
    // }
    // }
    //
    // private BigDecimal returnTotalVat(IslamicCalculatorCO
    // islamicCalculatorCO)
    // {
    // BigDecimal totalVat = BigDecimal.ZERO;
    // for(int index = 0; index <
    // islamicCalculatorCO.getTrspayplandetVOList().size(); index++)
    // {
    // totalVat =
    // totalVat.add(islamicCalculatorCO.getTrspayplandetVOList().get(index).getVAT_AMOUNT());
    // }
    // return NumberUtil.roundToBigDecimal(totalVat.doubleValue(),
    // islamicCalculatorCO.getDealCyDecimalPoint());
    // }
    // // DASI170030 TP 555811 Fawas.Kuruvakkottil 18/09/2017 End

    private IslamicCalculatorCO createRepaymentPlanStaffSkipping(IslamicCalculatorCO islamicCalculatorCO)
	    throws BaseException
    {
	BigDecimal profitAmt = BigDecimal.ZERO;
	BigDecimal profitAmtBeforeXirr = BigDecimal.ZERO;
	BigDecimal totalCapitalToBeAdjusted = BigDecimal.ZERO;
	List<TrspayplandetCO> trspayplandetVOListTemp = new ArrayList<TrspayplandetCO>();
	Date profitFromDate = islamicCalculatorCO.getTrspayplandetVOList()
		.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getVALUE_DATE();

	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    TrspayplandetCO trspayplandetCO = islamicCalculatorCO.getTrspayplandetVOList().get(i);

	    if(trspayplandetCO.getSKIPPED_DATE() != null
		    && trspayplandetCO.getSKIPPED_DATE().after(DateUtil.nullToInitDate(null)))
	    {
		profitAmt = trspayplandetCO.getPROFIT_AMT();
		profitAmtBeforeXirr = trspayplandetCO.getPROFIT_AMT_BEFORE_XIRR();
		if(i != islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
		{
		    // Profit
		    BigDecimal tempAmt = islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).getPROFIT_AMT();
		    tempAmt = NumberUtil.emptyDecimalToZero(tempAmt).add(profitAmt);
		    islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).setPROFIT_AMT(tempAmt);

		    // Profit Before XIRR
		    tempAmt = islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).getPROFIT_AMT_BEFORE_XIRR();
		    tempAmt = NumberUtil.emptyDecimalToZero(tempAmt).add(profitAmtBeforeXirr);
		    islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).setPROFIT_AMT_BEFORE_XIRR(tempAmt);

		    // Installment
		    tempAmt = islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).getAMOUNT();
		    tempAmt = NumberUtil.emptyDecimalToZero(tempAmt).add(profitAmt);
		    islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).setAMOUNT(tempAmt);
		    profitAmt = BigDecimal.ZERO;
		    profitAmtBeforeXirr = BigDecimal.ZERO;
		    trspayplandetVOListTemp.add(trspayplandetCO);
		}
		else
		{
		    trspayplandetVOListTemp.add(trspayplandetCO);
		}

		totalCapitalToBeAdjusted = totalCapitalToBeAdjusted.add(trspayplandetCO.getCAPITAL_AMT());
		islamicCalculatorCO.getTrspayplandetVOList().remove(i);
		i = i - 1;
	    }
	}
	if(totalCapitalToBeAdjusted.compareTo(BigDecimal.ZERO) == 1)
	{
	    // BigDecimal lineNumbner =
	    // BigDecimal.valueOf(islamicCalculatorCO.getTrspayplandetVOList().size());
	    int planSize = islamicCalculatorCO.getTrspayplandetVOList().size();
	    for(int j = 0; j < trspayplandetVOListTemp.size(); j++)
	    {
		TrspayplandetCO tempTrspayplandetCO = new TrspayplandetCO();
		boolean addNewLine = true;
		// tempTrspayplandetCO.setVALUE_DATE(trspayplandetVOListTemp.get(j).getSKIPPED_DATE());
		// tempTrspayplandetCO.setCAPITAL_AMT(trspayplandetVOListTemp.get(j).getCAPITAL_AMT());
		// tempTrspayplandetCO.setCAPITAL_AMT_BEFORE_XIRR(trspayplandetVOListTemp.get(j).getCAPITAL_AMT_BEFORE_XIRR());
		tempTrspayplandetCO = trspayplandetVOListTemp.get(j);
		tempTrspayplandetCO.setOUTSTANDING_AMOUNT(totalCapitalToBeAdjusted);
		tempTrspayplandetCO.setVALUE_DATE(tempTrspayplandetCO.getSKIPPED_DATE());
		Date dateTo = tempTrspayplandetCO.getVALUE_DATE();

		if(profitFromDate.compareTo(dateTo) == 0)
		{

		    if(j == 0)
		    {
			if(planSize > 1)
			{
			    profitFromDate = islamicCalculatorCO.getTrspayplandetVOList().get(planSize - 2)
				    .getVALUE_DATE();
			}
			else
			{
			    profitFromDate = islamicCalculatorCO.getOriginalValueDate();
			}
		    }
		    addNewLine = false;
		}
		BigDecimal profitAmount = BigDecimal.ZERO;
		if(ConstantsCommon.NO.equals(islamicCalculatorCO.getUpfrontProduct()))
		{
		    profitAmount = NumberUtil.roundToBigDecimal(
			    calculateProfitAmount(islamicCalculatorCO, profitFromDate, dateTo,
				    NumberUtil.toDoubleObj(totalCapitalToBeAdjusted), 0L, 0D,
				    islamicCalculatorCO.getAnnualYeild().doubleValue(), ConstantsCommon.NO),
			    islamicCalculatorCO.getDealCyDecimalPoint());
		}
		if(!addNewLine)
		{
		    BigDecimal tempAmount = islamicCalculatorCO.getTrspayplandetVOList()
			    .get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getPROFIT_AMT_BEFORE_XIRR();
		    islamicCalculatorCO.getTrspayplandetVOList()
			    .get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
			    .setPROFIT_AMT_BEFORE_XIRR(tempAmount.add(profitAmount).add(profitAmtBeforeXirr));

		    tempAmount = islamicCalculatorCO.getTrspayplandetVOList()
			    .get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getPROFIT_AMT();
		    islamicCalculatorCO.getTrspayplandetVOList()
			    .get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
			    .setPROFIT_AMT(tempAmount.add(profitAmount).add(profitAmt));

		    BigDecimal capitalAmt = tempTrspayplandetCO.getCAPITAL_AMT();

		    tempAmount = islamicCalculatorCO.getTrspayplandetVOList()
			    .get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getAMOUNT();
		    islamicCalculatorCO.getTrspayplandetVOList()
			    .get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
			    .setAMOUNT(tempAmount.add(profitAmount).add(profitAmt).add(capitalAmt));

		    tempAmount = islamicCalculatorCO.getTrspayplandetVOList()
			    .get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getCAPITAL_AMT();
		    islamicCalculatorCO.getTrspayplandetVOList()
			    .get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
			    .setCAPITAL_AMT(tempAmount.add(capitalAmt));

		    capitalAmt = tempTrspayplandetCO.getCAPITAL_AMT_BEFORE_XIRR();
		    tempAmount = islamicCalculatorCO.getTrspayplandetVOList()
			    .get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getCAPITAL_AMT_BEFORE_XIRR();
		    islamicCalculatorCO.getTrspayplandetVOList()
			    .get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
			    .setCAPITAL_AMT_BEFORE_XIRR(tempAmount.add(capitalAmt));
		    profitAmt = BigDecimal.ZERO;
		    profitAmtBeforeXirr = BigDecimal.ZERO;

		}
		else
		{
		    tempTrspayplandetCO.setPROFIT_AMT_BEFORE_XIRR(profitAmount.add(profitAmt));
		    tempTrspayplandetCO.setPROFIT_AMT(profitAmount.add(profitAmtBeforeXirr));
		    tempTrspayplandetCO
			    .setAMOUNT(tempTrspayplandetCO.getCAPITAL_AMT().add(profitAmount).add(profitAmt));
		    islamicCalculatorCO.getTrspayplandetVOList().add(tempTrspayplandetCO);
		    profitAmt = BigDecimal.ZERO;
		    profitAmtBeforeXirr = BigDecimal.ZERO;
		}
		totalCapitalToBeAdjusted = totalCapitalToBeAdjusted.subtract(tempTrspayplandetCO.getCAPITAL_AMT());
		profitFromDate = dateTo;
	    }

	    BigDecimal outStandingAmount = BigDecimal.ZERO;
	    for(int j = islamicCalculatorCO.getTrspayplandetVOList().size() - 1; j >= 0; j--)
	    {
		BigDecimal capitalAmt = islamicCalculatorCO.getTrspayplandetVOList().get(j).getCAPITAL_AMT();
		outStandingAmount = outStandingAmount.add(capitalAmt);
		islamicCalculatorCO.getTrspayplandetVOList().get(j).setTOTAL_PRINCIPAL_OUTSTANDIG(outStandingAmount);
	    }
	}

	return islamicCalculatorCO;
    }

    /**
     * Added for TAR:IIAB130173 on 28/09/2015
     * 
     * @param islamicCalculatorCOParam
     * @throws BaseException
     */

    private void applyXirrWithCharges(IslamicCalculatorCO islamicCalculatorCOParam) throws BaseException
    {
	String Show_XIRR_with_deal_charges = iisCommonBO.returnIISCTRL_ADDITIONAL_PARAM(
		islamicCalculatorCOParam.getCompanyCode(), islamicCalculatorCOParam.getBranchCode(),
		IISCommonConstants.SHOW_XIRR_WITH_DEAL_CHARGES);
	if(!ConstantsCommon.YES.equals(Show_XIRR_with_deal_charges))
	{
	    islamicCalculatorCOParam.setXirrWithChargesOut(BigDecimal.ZERO);
	    return;
	}
	if(islamicCalculatorCOParam.getTrsdealchargesVO() == null
		|| islamicCalculatorCOParam.getTrsdealchargesVO().isEmpty())
	{
	    islamicCalculatorCOParam.setXirrWithChargesOut(BigDecimal.ZERO);
	    return;
	}
	if(ConstantsCommon.YES.equals(islamicCalculatorCOParam.getTentativeSchedule()))
	{
	    islamicCalculatorCOParam.setXirrWithChargesOut(BigDecimal.ZERO);
	    return;
	}
	if(islamicCalculatorCOParam.getTrspayplandetVOList() == null
		|| islamicCalculatorCOParam.getTrspayplandetVOList().isEmpty())
	{
	    islamicCalculatorCOParam.setXirrWithChargesOut(BigDecimal.ZERO);
	    return;
	}

	BigDecimal totalChargesCollectDealApproval = BigDecimal.ZERO;
	BigDecimal totalChargesIncludePrincipal = BigDecimal.ZERO;

	for(TrsDealChargesCO trsdealchargesvo : islamicCalculatorCOParam.getTrsdealchargesVO())
	{
	    if(ConstantsCommon.YES.equals(trsdealchargesvo.getCOLLECT_CHARGE_AT_DEAL_YN()))
	    {
		totalChargesCollectDealApproval = totalChargesCollectDealApproval
			.add(trsdealchargesvo.getCHARGES_AMOUNT());
	    }

	    if(ConstantsCommon.YES.equals(trsdealchargesvo.getCHARGE_TYPE()))
	    {
		totalChargesIncludePrincipal = totalChargesIncludePrincipal.add(trsdealchargesvo.getCHARGES_AMOUNT());
	    }
	}

	if(totalChargesIncludePrincipal.compareTo(BigDecimal.ZERO) <= 0
		&& totalChargesCollectDealApproval.compareTo(BigDecimal.ZERO) <= 0)
	{
	    islamicCalculatorCOParam.setXirrWithChargesOut(BigDecimal.ZERO);
	    return;
	}

	if(totalChargesCollectDealApproval.compareTo(BigDecimal.ZERO) <= 0)
	{
	    islamicCalculatorCOParam.setXirrWithChargesOut(islamicCalculatorCOParam.getXirrOut());
	    return;
	}

	if(totalChargesCollectDealApproval.compareTo(totalChargesIncludePrincipal) == 0)
	{
	    islamicCalculatorCOParam.setXirrWithChargesOut(islamicCalculatorCOParam.getXirrOut());
	    return;
	}

	List<TrspayplandetCO> localtrsDealChargesCOList = new ArrayList<TrspayplandetCO>();
	for(TrspayplandetCO trspayplandetCOline : islamicCalculatorCOParam.getTrspayplandetVOList())
	{
	    localtrsDealChargesCOList.add(trspayplandetCOline);
	}
	// PathPropertyUtil.copyProperties(islamicCalculatorCOParam.getTrspayplandetVOList(),
	// localtrsDealChargesCOList);
	boolean lineAdded = false;
	if(islamicCalculatorCOParam.getTrspayplandetVOList().get(0).getVALUE_DATE()
		.compareTo(islamicCalculatorCOParam.getValueDate()) == 0)
	{
	    islamicCalculatorCOParam.getTrspayplandetVOList().get(0).setAMOUNT(totalChargesCollectDealApproval
		    .add(islamicCalculatorCOParam.getTrspayplandetVOList().get(0).getAMOUNT()));
	    lineAdded = false;
	}
	else
	{
	    TrspayplandetCO trspayplandetCOtemp = new TrspayplandetCO();
	    trspayplandetCOtemp.setVALUE_DATE(islamicCalculatorCOParam.getValueDate());
	    trspayplandetCOtemp.setAMOUNT(totalChargesCollectDealApproval);
	    islamicCalculatorCOParam.getTrspayplandetVOList().add(0, trspayplandetCOtemp);
	    lineAdded = true;
	}

	// double totalOutstandingAmount =
	// NumberUtil.toDoubleObj(islamicCalculatorCOParam.getDealAmount())
	// +
	// NumberUtil.toDoubleObj(islamicCalculatorCOParam.getProfitOnCharges())
	// +
	// NumberUtil.toDoubleObj(islamicCalculatorCOParam.getProfitOnInsurance())
	// +
	// NumberUtil.toDoubleObj(islamicCalculatorCOParam.getTotalGracePeriodCompundingProfit());
	double totalOutstandingAmount = NumberUtil.toDoubleObj(islamicCalculatorCOParam.getDealAmount())
		+ NumberUtil.toDoubleObj(islamicCalculatorCOParam.getTotalCharges())
		+ NumberUtil.toDoubleObj(islamicCalculatorCOParam.getTotalInsurance());

	totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount,
		islamicCalculatorCOParam.getDealCyDecimalPoint());

	double XIRRRate = getXIRR(islamicCalculatorCOParam, totalOutstandingAmount);
	islamicCalculatorCOParam.setXirrWithChargesOut(BigDecimal.valueOf(XIRRRate));

	islamicCalculatorCOParam.setTrspayplandetVOList(new ArrayList<TrspayplandetCO>());
	for(TrspayplandetCO trspayplandetCOline : localtrsDealChargesCOList)
	{
	    islamicCalculatorCOParam.getTrspayplandetVOList().add(trspayplandetCOline);
	}
	if(!lineAdded)
	{
	    islamicCalculatorCOParam.getTrspayplandetVOList().get(0).setAMOUNT(islamicCalculatorCOParam
		    .getTrspayplandetVOList().get(0).getAMOUNT().subtract(totalChargesCollectDealApproval));
	}
	// PathPropertyUtil.copyProperties(localtrsDealChargesCOList,
	// islamicCalculatorCOParam.getTrspayplandetVOList());

	localtrsDealChargesCOList = null;
    }

    private void setArRahnuCalculatorDetails(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	islamicCalculatorCO.setAnnualYeild(BigDecimal.ZERO);
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getRescheduleYn()))
	{
	    islamicCalculatorCO.setTotalCharges(islamicCalculatorCO.getTotalSafeBoxCharges());
	}
	if(IISCommonConstants.PAYMENT_TYPE_UPFRONT_PROFIT.equals(islamicCalculatorCO.getSafeboxchargetype()))
	{
	    islamicCalculatorCO.setNoOfPayments(BigDecimal.ONE);
	    islamicCalculatorCO.setAmountPerPayment(BigDecimal.ZERO);
	    // islamicCalculatorCO.setTotalSafeBoxCharges(BigDecimal.ZERO);

	    islamicCalculatorCO.setTotalCharges(BigDecimal.ZERO);
	    islamicCalculatorCO.setTotalInsurance(BigDecimal.ZERO);

	}
	else if(IISCommonConstants.MONTH.equals(islamicCalculatorCO.getSafeboxchargetype()))
	{
	    if(NumberUtil.nullToZero(islamicCalculatorCO.getTotalSafeBoxCharges()).compareTo(BigDecimal.ZERO) == 1)
	    {
		islamicCalculatorCO.setAmountPerPayment(
			islamicCalculatorCO.getTotalSafeBoxCharges().divide(islamicCalculatorCO.getNoOfPayments(),
				islamicCalculatorCO.getDealCyDecimalPoint().intValue(), BigDecimal.ROUND_HALF_UP));
	    }

	}
	else if("A".equals(islamicCalculatorCO.getSafeboxchargetype()))
	{
	    islamicCalculatorCO.setNoOfPayments(BigDecimal.ONE);
	    islamicCalculatorCO.setAmountPerPayment(BigDecimal.ZERO);
	}
	else
	{
	    throw new BOException(MessageCodes.Invalid_Code, "Invalid Safe Box Charge Type");
	}

	// islamicCalculatorCO.setTotalCharges(islamicCalculatorCO.getTotalSafeBoxCharges());
    }

    private void validateBillsCalculator(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	if(!ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	{
	    return;
	}
	if(islamicCalculatorCO.getTfaTrxType() == null || islamicCalculatorCO.getTfaTrxType().isEmpty())
	{
	    islamicCalculatorCO.setTfaTrxType(ConstantsCommon.NO);
	}
	if(!ConstantsCommon.NO.equals(islamicCalculatorCO.getTfaTrxType()) && NumberUtil
		.nullToZero(islamicCalculatorCO.getTfaInwardOutwartTrsNo()).compareTo(BigDecimal.ZERO) != 1)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Invalid Receipt of Document / Returning Bills Trasaction number" }, false);
	}
	if(NumberUtil.nullToZero(islamicCalculatorCO.getTradeCurrency()).compareTo(BigDecimal.ZERO) != 1)
	{
	    throw new BOException(MessageCodes.iis_invalid_code, new String[] { "Invalid_Trande_Currency" }, false);
	}
	if(INTEREST_CALCULATION_METHOD_FLAT.equals(islamicCalculatorCO.getInterest_calculation_method()))
	{
	    islamicCalculatorCO.setProfitCalculationMethod(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE);
	}
	else
	{
	    islamicCalculatorCO
		    .setProfitCalculationMethod(IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS);
	}
	islamicCalculatorCO.setProfitRecognitionMethod(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE);
	islamicCalculatorCO.setDealAmount(islamicCalculatorCO.getTotalBillAmount());
	islamicCalculatorCO.setResidualValue("L");
    }
    
	private void applyDefaultValuesFromProductClass(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	trsClassVOKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	trsClassVOKey.setCODE(islamicCalculatorCO.getProductClassCode());
	TRSCLASSVO trsClassVO = iisIslamicCalculatorDAO.getProductClassDetails(trsClassVOKey);
	trsClassVOKey = null;

	if(trsClassVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	
	setDefaultValues(islamicCalculatorCO);
	islamicCalculatorCO.setProfitAccrualBasis(NumberUtil.nullToZero(trsClassVO.getACCRUAL_BASIS()).longValue());
	if("L".equals(trsClassVO.getCALCULATE_PROFIT()))
	{
	    islamicCalculatorCO.setProfitCalculationMethod(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE);
	}
	else
	{
	    islamicCalculatorCO
		    .setProfitCalculationMethod(IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS);
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getProfitRecognitionMethod()))
	{
	    islamicCalculatorCO.setProfitRecognitionMethod(trsClassVO.getPROFIT_DIST_METHOD());
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getPaymentPeriodicity()))
	{
	    islamicCalculatorCO
		    .setPaymentPeriodicity(StringUtil.nullEmptyToValue(trsClassVO.getPAYM_PERIODICITY(), "M"));
	}

	if(StringUtil.isEmptyString(islamicCalculatorCO.getPaymentPeriodicity()))
	{
	    islamicCalculatorCO.setPaymentPeriodicityNo(
		    NumberUtil.nullEmptyToValue(trsClassVO.getPAYM_PERIOD_NBR(), BigDecimal.ONE).longValue());
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getPaymentPeriodicityMonthPos()))
	{
	    islamicCalculatorCO
		    .setPaymentPeriodicityMonthPos(StringUtil.nullEmptyToValue(trsClassVO.getPAYM_PERIOD_POS(), "D"));
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getResidualValue()))
	{
	    islamicCalculatorCO.setResidualValue(StringUtil.nullEmptyToValue(trsClassVO.getPAY_RES_AMT(), "L"));
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getUpfrontProduct()))
	{
	    islamicCalculatorCO.setUpfrontProduct(trsClassVO.getPROFIT_UPFRONT());
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getCapitalizePeriodicity()))
	{
	    islamicCalculatorCO.setCapitalizePeriodicity(trsClassVO.getCAPITALIZE_PAYM_PERIODICITY());
	}
	if(islamicCalculatorCO.getCapitalizePeriodicityNo() != null)
	{
	    islamicCalculatorCO.setCapitalizePeriodicityNo(trsClassVO.getCAPITALIZE_PAYM_PERIOD_NBR().longValue());
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getCapitalizePeriodicityNopos()))
	{
	    islamicCalculatorCO.setCapitalizePeriodicityNopos(trsClassVO.getCAPITALIZE_PAYM_PERIOD_POS());
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getDailyDepreciationYn()))
	{
	    islamicCalculatorCO.setDailyDepreciationYn(trsClassVO.getDAILY_DEPRECIATION_YN());
	}
	if(islamicCalculatorCO.getProfitAccrualBasis() != null)
	{
	    islamicCalculatorCO.setProfitAccrualBasis(trsClassVO.getACCRUAL_BASIS().longValue());
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getSegmentAppliedYn()))
	{
	    islamicCalculatorCO.setSegmentAppliedYn(trsClassVO.getSEGMENT_APPLIED_YN());
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getACCRUAL_AMOUNT_TYPE()))
	{
	    islamicCalculatorCO.setACCRUAL_AMOUNT_TYPE(trsClassVO.getACCRUAL_AMOUNT_TYPE());
	}
	if(NumberUtil.isEmptyDecimal(islamicCalculatorCO.getDEAL_CATEGORY()))
	{
	    islamicCalculatorCO.setDEAL_CATEGORY(trsClassVO.getCATEGORY());
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getPLAN_SHOW_PRINCIPAL_AMOUNT_YN()))
	{
	    islamicCalculatorCO.setPLAN_SHOW_PRINCIPAL_AMOUNT_YN(trsClassVO.getPLAN_SHOW_PRINCIPAL_AMOUNT_YN());
	}
	if(StringUtil.isEmptyString(islamicCalculatorCO.getEXCL_PRFT_RECLC_DUE_INST_YN()))
	{
	    islamicCalculatorCO.setEXCL_PRFT_RECLC_DUE_INST_YN(trsClassVO.getEXCL_PRFT_RECLC_DUE_INST_YN());
	}
	// #TAR ICD140061 ; Arun R Variyath 17/12/2015
	if(StringUtil.isEmptyString(islamicCalculatorCO.getAccrueAgencyFeeYn()))
	{
	    islamicCalculatorCO.setAccrueAgencyFeeYn(trsClassVO.getACCRUE_AGENCY_FEE_YN());
	}
	if("P".equals(islamicCalculatorCO.getACCRUAL_AMOUNT_TYPE()))
	{
	    islamicCalculatorCO.setPLAN_SHOW_PRINCIPAL_AMOUNT_YN(ConstantsCommon.YES);
	}

	trsClassVO = null;

    }
	
	private IslamicCalculatorCO createScheduleNidc(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	TRSDEAL_NIDCVO trsdealNIDCVO = null;
	TRSDEAL_NIDCVOKey trsdealNIDCVOKey = new TRSDEAL_NIDCVOKey();
	trsdealNIDCVOKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	trsdealNIDCVOKey.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
	trsdealNIDCVOKey.setTRS_NO(islamicCalculatorCO.getDealNo());

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	{
	    trsdealNIDCVO = islamicCalculatorCO.getTrsdealNIDCVO();
	    if(trsdealNIDCVO == null)
	    {
		throw new BOException(MessageCodes.iis_invalid_code,
			new String[] { "invalid_missing_nidc_details_key" }, false);
	    }
	    if(ConstantsCommon.YES.equals(trsdealNIDCVO.getISSUE_AT_TYPE()))
	    {
		if(islamicCalculatorCO.getTrsdealNIDC_COUPONPYMNTVOs() == null
			|| islamicCalculatorCO.getTrsdealNIDC_COUPONPYMNTVOs().isEmpty())
		{
		    throw new BOException(MessageCodes.iis_invalid_code,
			    new String[] { "invalid_missing_nidc_details_key" }, false);
		}
		boolean lb_Maturity_Date_Equal_Coupon_Payment_Date = false;
		for(int i = 0; i < islamicCalculatorCO.getTrsdealNIDC_COUPONPYMNTVOs().size(); i++)
		{
		    if(islamicCalculatorCO.getMaturityDate().compareTo(
			    islamicCalculatorCO.getTrsdealNIDC_COUPONPYMNTVOs().get(i).getCOUPON_PAYMENT_DATE()) == 0)
		    {
			lb_Maturity_Date_Equal_Coupon_Payment_Date = true;
			break;
		    }
		}

		if(!lb_Maturity_Date_Equal_Coupon_Payment_Date)
		{
		    throw new BOException(MessageCodes.iis_invalid_code,
			    new String[] { "One_of_the_Coupon_Payment_Date_must_be_Equal_Maturity_Date" }, false);
		}

	    }
	}
	else
	{

	    trsdealNIDCVO = iisIslamicCalculatorDAO.getNidcDeal(trsdealNIDCVOKey);
	}

	if(trsdealNIDCVO != null)
	{
	    List<TRSDEAL_NIDC_DETVO> trsdealNIDCDETVO = null;
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	    {
		trsdealNIDCDETVO = islamicCalculatorCO.getTrsdealNIDCDETVO();
		if(trsdealNIDCDETVO == null || trsdealNIDCDETVO.isEmpty())
		{
		    throw new BOException(MessageCodes.iis_invalid_code,
			    new String[] { "invalid_missing_nidc_details_key" }, false);
		}
	    }
	    else
	    {
		trsdealNIDCDETVO = iisIslamicCalculatorDAO.getNidcDealDetails(trsdealNIDCVOKey);
	    }

	    if(trsdealNIDCDETVO != null && !trsdealNIDCDETVO.isEmpty())
	    {
		TRSDEAL_NIDC_DETVO nidcDETVOSum = getNidcDealAmount(trsdealNIDCDETVO);

		BigDecimal nidcDealAmount = nidcDETVOSum.getNOMINAL_AMOUNT();
		BigDecimal totalProfitAmount = nidcDETVOSum.getEXPENSES();
		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
		{
		    nidcDealAmount = nidcDealAmount.subtract(totalProfitAmount);
		    islamicCalculatorCO.setNoOfPayments(BigDecimal.valueOf(trsdealNIDCDETVO.size()));
		}

		islamicCalculatorCO.setNidcDeal(ConstantsCommon.YES);
		for(int i = 0; i < trsdealNIDCDETVO.size(); i++)
		{
		    BigDecimal capitalAmount = trsdealNIDCDETVO.get(i).getNOMINAL_AMOUNT();
		    BigDecimal profitAmount = trsdealNIDCDETVO.get(i).getEXPENSES();
		    BigDecimal installmentAmount = BigDecimal.ZERO;

		    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
		    {
			installmentAmount = capitalAmount;
			capitalAmount = capitalAmount.subtract(profitAmount);
		    }
		    else
		    {
			installmentAmount = capitalAmount.add(profitAmount);
		    }
		    TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
		    trspayplandetCO.setVALUE_DATE(islamicCalculatorCO.getMaturityDate());
		    trspayplandetCO.setPAYMENT_TYPE("B");
		    trspayplandetCO.setDEAL_VALUE_DATE(islamicCalculatorCO.getValueDate());
		    trspayplandetCO.setAMOUNT(installmentAmount);
		    trspayplandetCO.setPRINCIPLE_AMT(capitalAmount);
		    trspayplandetCO.setCAPITAL_AMT(capitalAmount);
		    trspayplandetCO.setCAPITAL_AMT_BEFORE_XIRR(capitalAmount);

		    trspayplandetCO.setPROFIT_AMT(profitAmount);
		    trspayplandetCO.setPROFIT_AMT_BEFORE_XIRR(profitAmount);
		    trspayplandetCO.setTOTAL_PRINCIPAL_OUTSTANDIG(nidcDealAmount);

		    trspayplandetCO.setACC_BR(islamicCalculatorCO.getTRSDET_MATR_AC_BR());
		    trspayplandetCO.setACC_CY(islamicCalculatorCO.getTRSDET_MATR_AC_CY());
		    trspayplandetCO.setACC_GL(islamicCalculatorCO.getTRSDET_MATR_AC_GL());
		    trspayplandetCO.setACC_CIF(islamicCalculatorCO.getTRSDET_MATR_AC_CIF());
		    trspayplandetCO.setACC_SL(islamicCalculatorCO.getTRSDET_MATR_AC_SL());
		    trspayplandetCO.setACC_NAME(islamicCalculatorCO.getTRSDET_MATR_AC_BRIEF_NAME_ENG());
		    trspayplandetCO.setAUTO_CREATE_SETTLEMENT(islamicCalculatorCO.getAUTO_CREATE_SETTLEMENT());

		    trspayplandetCO.setINSURANCE_AMOUNT(BigDecimal.valueOf(0D));
		    trspayplandetCO.setPROFIT_ON_INSURANCE(BigDecimal.valueOf(0D));
		    trspayplandetCO.setCHARGE_AMOUNT(BigDecimal.valueOf(0D));
		    trspayplandetCO.setPROFIT_ON_CHARGES(BigDecimal.valueOf(0D));

		    islamicCalculatorCO.getTrspayplandetVOList().add(trspayplandetCO);
		}
		if(trsdealNIDCVO.getFACE_VALUE().compareTo(nidcDealAmount.add(totalProfitAmount)) != 0)
		{
		    throw new BOException(MessageCodes.iis_invalid_code,
			    new String[] { "Total_Nominal_Amount_is_not_equal_to_Face_Value_key" }, false);
		}

		if(trsdealNIDCVO.getNO_OF_CERTIFICATE()
			.compareTo(BigDecimal.valueOf(islamicCalculatorCO.getTrspayplandetVOList().size())) != 0)
		{
		    throw new BOException(MessageCodes.iis_invalid_code,
			    new String[] { "Number_of_Rows_is_not_equal_to_Number_of_NIDC_Certificate_key" }, false);
		}

	    }
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getNidcDeal()))
	    {

		setCalculatorResultSet(islamicCalculatorCO);
		islamicCalculatorCO
			.setNoOfPayments(BigDecimal.valueOf(islamicCalculatorCO.getTrspayplandetVOList().size()));
		validationForPrincipalAmount(islamicCalculatorCO);
		setScheduleFormat(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
		printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
	    }
	}

	return islamicCalculatorCO;
    }

	private TRSDEAL_NIDC_DETVO getNidcDealAmount(List<TRSDEAL_NIDC_DETVO> trsdealNIDCDETVO)
    {
	BigDecimal nidcDealAmount = BigDecimal.ZERO;
	BigDecimal profitAmount = BigDecimal.ZERO;
	TRSDEAL_NIDC_DETVO trsdealNIDCDETVOSum = new TRSDEAL_NIDC_DETVO();
	for(int i = 0; i < trsdealNIDCDETVO.size(); i++)
	{
	    nidcDealAmount = nidcDealAmount.add(trsdealNIDCDETVO.get(i).getNOMINAL_AMOUNT());
	    profitAmount = profitAmount.add(trsdealNIDCDETVO.get(i).getEXPENSES());
	}
	trsdealNIDCDETVOSum.setNOMINAL_AMOUNT(nidcDealAmount);
	trsdealNIDCDETVOSum.setEXPENSES(profitAmount);

	return trsdealNIDCDETVOSum;
    }

    // PMD infractions; Saheer.Naduthodi; 10/12/2014: UnusedPrivateMethod
    // private IslamicCalculatorCO setUpfrontProfitxxx(IslamicCalculatorCO
    // islamicCalculatorCO) throws BaseException
    // {
    // int llTotalCount = islamicCalculatorCO.getTrspayplandetVOList().size();
    // double profitAmtPrev = 0;
    // double capitalAmtPrev = 0;
    // double instAmtPrev = 0;
    // boolean processed = false;
    // double upfront_profit = 0;
    // double upfront_capital = 0;
    //
    // for(int i = 0; i < llTotalCount; i++)
    // {
    // String actualPaymentType =
    // StringUtil.nullToEmpty(islamicCalculatorCO.getTrspayplandetVOList().get(i)
    // .getACTUAL_PAYMENT_TYPE());
    //
    // double profitAmt1 =
    // NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
    // .getPROFIT_AMT_BEFORE_XIRR());
    // double capitalAmt1 =
    // NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
    // .getCAPITAL_AMT_BEFORE_XIRR());
    // double instAmt1 =
    // NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT());
    // if(upfront_profit > 0 || upfront_capital > 0)
    // {
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setLINE_NBR(BigDecimal.valueOf(i
    // + 2));
    // }
    //
    // if(!(actualPaymentType.equals(IISCommonConstants.PAYMENT_TYPE_UPFRONT_PROFIT)
    // ||
    // actualPaymentType.equals(IISCommonConstants.PAYMENT_TYPE_UPFRONT_PRINCIPAL_UPFRONT_PROFIT)
    // || actualPaymentType
    // .equals(IISCommonConstants.PAYMENT_TYPE_PRINCIPAL_UPFRONT_PROFIT)))
    // {
    // profitAmtPrev = profitAmt1;
    // capitalAmtPrev = capitalAmt1;
    // instAmtPrev = instAmt1;
    // continue;
    // }
    // /*
    // * double profitAmt2 =
    // * NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList
    // * ().get(i + 1) .getPROFIT_AMT_BEFORE_XIRR()); double capitalAmt2 =
    // * NumberUtil
    // * .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i +
    // * 1) .getCAPITAL_AMT_BEFORE_XIRR()); double instAmt2 =
    // * NumberUtil.toDoubleObj
    // * (islamicCalculatorCO.getTrspayplandetVOList().get(i + 1)
    // * .getAMOUNT());
    // */
    // /**
    // * U = Upfront Profit - Profit will be collect in previous
    // * installment O = Principal + Upfront Profit - Collect profit in
    // * previous installment
    // */
    //
    // processed = true;
    // if(actualPaymentType.equals(IISCommonConstants.PAYMENT_TYPE_UPFRONT_PROFIT)
    // ||
    // actualPaymentType.equals(IISCommonConstants.PAYMENT_TYPE_PRINCIPAL_UPFRONT_PROFIT))
    // {
    // if(i == 0)
    // {
    // upfront_profit = profitAmt1;
    // if(islamicCalculatorCO.getTentativeSchedule().equals(ConstantsCommon.NO))
    // {
    // islamicCalculatorCO.setUpfront_profit_yn(ConstantsCommon.YES);
    // islamicCalculatorCO.setUpfront_profit_amt(BigDecimal.valueOf(NumberUtil
    // .toDoubleObj(islamicCalculatorCO.getUpfront_profit_amt())
    // + upfront_profit));
    // }
    //
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setLINE_NBR(BigDecimal.valueOf(i
    // + 2));
    // }
    // islamicCalculatorCO.getTrspayplandetVOList().get(i)
    // .setAMOUNT(BigDecimal.valueOf(instAmt1 - profitAmt1));
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT_BEFORE_XIRR(BigDecimal.ZERO);
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT(BigDecimal.ZERO);
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setPAYMENT_TYPE("C");
    // if(i > 0)
    // {
    // islamicCalculatorCO.getTrspayplandetVOList().get(i - 1).setPROFIT_AMT(
    // BigDecimal.valueOf(profitAmtPrev + profitAmt1));
    // islamicCalculatorCO.getTrspayplandetVOList().get(i -
    // 1).setPROFIT_AMT_BEFORE_XIRR(
    // BigDecimal.valueOf(profitAmtPrev + profitAmt1));
    // islamicCalculatorCO.getTrspayplandetVOList().get(i - 1).setAMOUNT(
    // BigDecimal.valueOf(instAmtPrev + profitAmt1));
    // islamicCalculatorCO.getTrspayplandetVOList().get(i -
    // 1).setPAYMENT_TYPE(actualPaymentType);
    // }
    //
    // instAmt1 = instAmt1 - profitAmt1;
    // profitAmt1 = 0;
    // /**
    // * Upfront Principal + Upfront Profit - Collect profit +
    // * principle in previous installment
    // */
    // }
    // else
    // if(actualPaymentType.equals(IISCommonConstants.PAYMENT_TYPE_UPFRONT_PRINCIPAL_UPFRONT_PROFIT))
    // {
    // if(i == 0)
    // {
    // upfront_profit = profitAmt1;
    // upfront_capital = capitalAmt1;
    // islamicCalculatorCO.setUpfront_profit_yn(ConstantsCommon.YES);
    // if(islamicCalculatorCO.getTentativeSchedule().equals(ConstantsCommon.NO))
    // {
    // islamicCalculatorCO.setUpfront_profit_yn(ConstantsCommon.YES);
    // islamicCalculatorCO.setUpfront_profit_amt(BigDecimal.valueOf(NumberUtil
    // .toDoubleObj(islamicCalculatorCO.getUpfront_profit_amt())
    // + upfront_profit));
    // }
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setLINE_NBR(BigDecimal.valueOf(i
    // + 2));
    // }
    //
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setAMOUNT(
    // BigDecimal.valueOf(instAmt1 - (profitAmt1 + capitalAmt1)));
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT_BEFORE_XIRR(BigDecimal.ZERO);
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT(BigDecimal.ZERO);
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT_BEFORE_XIRR(BigDecimal.ZERO);
    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT(BigDecimal.ZERO);
    //
    // if(i > 0)
    // {
    // islamicCalculatorCO.getTrspayplandetVOList().get(i - 1).setPROFIT_AMT(
    // BigDecimal.valueOf(profitAmtPrev + profitAmt1));
    // islamicCalculatorCO.getTrspayplandetVOList().get(i -
    // 1).setPROFIT_AMT_BEFORE_XIRR(
    // BigDecimal.valueOf(profitAmtPrev + profitAmt1));
    //
    // islamicCalculatorCO.getTrspayplandetVOList().get(i - 1).setCAPITAL_AMT(
    // BigDecimal.valueOf(capitalAmtPrev + capitalAmt1));
    // islamicCalculatorCO.getTrspayplandetVOList().get(i -
    // 1).setCAPITAL_AMT_BEFORE_XIRR(
    // BigDecimal.valueOf(capitalAmtPrev + capitalAmt1));
    //
    // islamicCalculatorCO.getTrspayplandetVOList().get(i - 1).setAMOUNT(
    // BigDecimal.valueOf(instAmtPrev + profitAmt1 + capitalAmt1));
    //
    // islamicCalculatorCO.getTrspayplandetVOList().get(i -
    // 1).setPAYMENT_TYPE("A");
    // }
    //
    // instAmt1 = instAmt1 - profitAmt1 - capitalAmt1;
    // profitAmt1 = 0;
    // capitalAmt1 = 0;
    //
    // }
    //
    // profitAmtPrev = profitAmt1;
    // capitalAmtPrev = capitalAmt1;
    // instAmtPrev = instAmt1;
    // }
    //
    // // if(upfront_profit > 0 || upfront_capital > 0)
    // if(upfront_profit > 0 &&
    // islamicCalculatorCO.getTrsPayPlanCriteriaVO().size() > 0)
    // {
    // TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
    // trspayplandetCO.setLINE_NBR(BigDecimal.ONE);
    // trspayplandetCO.setVALUE_DATE(islamicCalculatorCO.getValueDate());
    // if(islamicCalculatorCO.getCalendarType().equals(IISCommonConstants.CALENDAR_TYPE_HIJRI_H))
    // {
    // String hijiriDate =
    // hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(),
    // islamicCalculatorCO.getValueDate());
    // trspayplandetCO.setVALUE_DATE_HIJRI(hijiriDate);
    // }
    //
    // trspayplandetCO.setPAYMENT_TYPE(upfront_capital > 0 ? "B" : "P");
    //
    // trspayplandetCO.setAMOUNT(BigDecimal.valueOf(upfront_profit +
    // upfront_capital));
    // trspayplandetCO.setPROFIT_AMT_BEFORE_XIRR(BigDecimal.valueOf(upfront_profit));
    // trspayplandetCO.setPROFIT_AMT(BigDecimal.valueOf(upfront_profit));
    // trspayplandetCO.setCAPITAL_AMT(BigDecimal.valueOf(upfront_capital));
    // trspayplandetCO.setCAPITAL_AMT_BEFORE_XIRR(BigDecimal.valueOf(upfront_capital));
    //
    // trspayplandetCO.setCHARGE_AMOUNT(BigDecimal.ZERO);
    // trspayplandetCO.setINSURANCE_AMOUNT(BigDecimal.ZERO);
    //
    // trspayplandetCO.setOUTSTANDING_AMOUNT(islamicCalculatorCO.getDealAmount());
    // trspayplandetCO.setTOTAL_PRINCIPAL_OUTSTANDIG(islamicCalculatorCO.getDealAmount());
    //
    // trspayplandetCO.setPRINCIPLE_AMT(BigDecimal.valueOf(upfront_capital));
    //
    // trspayplandetCO.setAUTO_CREATE_SETTLEMENT(islamicCalculatorCO.getTrspayplandetVOList().get(0)
    // .getAUTO_CREATE_SETTLEMENT());
    // trspayplandetCO.setACC_BR(islamicCalculatorCO.getTrspayplandetVOList().get(0).getACC_BR());
    // trspayplandetCO.setACC_CY(islamicCalculatorCO.getTrspayplandetVOList().get(0).getACC_CY());
    // trspayplandetCO.setACC_GL(islamicCalculatorCO.getTrspayplandetVOList().get(0).getACC_GL());
    // trspayplandetCO.setACC_CIF(islamicCalculatorCO.getTrspayplandetVOList().get(0).getACC_CIF());
    // trspayplandetCO.setACC_SL(islamicCalculatorCO.getTrspayplandetVOList().get(0).getACC_SL());
    // trspayplandetCO
    // .setCOVERING_ACC_BR(islamicCalculatorCO.getTrspayplandetVOList().get(0).getCOVERING_ACC_BR());
    // trspayplandetCO
    // .setCOVERING_ACC_CY(islamicCalculatorCO.getTrspayplandetVOList().get(0).getCOVERING_ACC_CY());
    // trspayplandetCO
    // .setCOVERING_ACC_GL(islamicCalculatorCO.getTrspayplandetVOList().get(0).getCOVERING_ACC_GL());
    // trspayplandetCO.setCOVERING_ACC_CIF(islamicCalculatorCO.getTrspayplandetVOList().get(0)
    // .getCOVERING_ACC_CIF());
    // trspayplandetCO
    // .setCOVERING_ACC_SL(islamicCalculatorCO.getTrspayplandetVOList().get(0).getCOVERING_ACC_SL());
    // trspayplandetCO.setAUTO_CREATE_SETTLEMENT(islamicCalculatorCO.getAUTO_CREATE_SETTLEMENT());
    // trspayplandetCO.setBALLOON_PAYMENT(BigDecimal.valueOf(0L));
    //
    // islamicCalculatorCO.getTrspayplandetVOList().add(0, trspayplandetCO);
    //
    // if(processed)
    // {
    // applyIAS18Method(islamicCalculatorCO);
    // printPlan(islamicCalculatorCO.getTrspayplandetVOList(),
    // islamicCalculatorCO);
    // }
    // }
    // return islamicCalculatorCO;
    // }
    
	private IslamicCalculatorCO setUpfrontProfit(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	int llTotalCount = islamicCalculatorCO.getTrspayplandetVOList().size();

	boolean processed = false;
	double upfront_profit = 0;
	double upfront_capital = 0;
	double ldec_profit_xirr = 0;
	double ldec_amount_3 = 0;
	double ldec_profit_3_sum = 0;

	double ldec_capital_amt = 0;

	// double ldec_profit_upfront_org =
	// NumberUtil.nullToZero(islamicCalculatorCO.getUpfront_profit_amt()).doubleValue();

	for(int i = 0; i < llTotalCount - 1; i++)
	{
	    String actualPaymentType = StringUtil
		    .nullToEmpty(islamicCalculatorCO.getTrspayplandetVOList().get(i).getACTUAL_PAYMENT_TYPE());

	    if("U".equals(actualPaymentType) || "A".equals(actualPaymentType) || "O".equals(actualPaymentType))
	    {

		double ldec_profit_1 = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT_BEFORE_XIRR());
		double ldec_capital_1 = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT_BEFORE_XIRR());
		double ldec_amount_1 = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT());

		double ldec_profit_2 = NumberUtil.toDoubleObj(
			islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).getPROFIT_AMT_BEFORE_XIRR());
		double ldec_capital_2 = NumberUtil.toDoubleObj(
			islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).getCAPITAL_AMT_BEFORE_XIRR());
		double ldec_amount_2 = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).getAMOUNT());
		// Date ldt_value_date;

		if("U".equals(actualPaymentType))
		{
		    if(i == 0)
		    {
			islamicCalculatorCO.setUpfront_profit_yn(ConstantsCommon.YES);
			islamicCalculatorCO.setUpfront_profit_amt(BigDecimal.valueOf(
				NumberUtil.toDoubleObj(islamicCalculatorCO.getUpfront_profit_amt()) + upfront_profit));
			islamicCalculatorCO.getTrspayplandetVOList().get(i)
				.setAMOUNT(BigDecimal.valueOf(ldec_amount_1 - ldec_profit_1));

			// ldec_profit_xirr =
			// NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
			// .getPROFIT_AMT());

			ldec_amount_1 = ldec_amount_1 - ldec_profit_1;
		    }

		    islamicCalculatorCO.getTrspayplandetVOList().get(i)
			    .setAMOUNT(BigDecimal.valueOf(ldec_amount_1 + ldec_profit_2));

		    islamicCalculatorCO.getTrspayplandetVOList().get(i)
			    .setPROFIT_AMT_BEFORE_XIRR(BigDecimal.valueOf(ldec_profit_1 + ldec_profit_2));

		    islamicCalculatorCO.getTrspayplandetVOList().get(i)
			    .setPROFIT_AMT(BigDecimal.valueOf(ldec_profit_1 + ldec_profit_2));

		    islamicCalculatorCO.getTrspayplandetVOList().get(i + 1)
			    .setAMOUNT(BigDecimal.valueOf(ldec_amount_2 - ldec_profit_2));
		    islamicCalculatorCO.getTrspayplandetVOList().get(i + 1)
			    .setPROFIT_AMT_BEFORE_XIRR(BigDecimal.valueOf(0));
		    islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).setPROFIT_AMT(BigDecimal.valueOf(0));

		    islamicCalculatorCO.getTrspayplandetVOList().get(i).setPAYMENT_TYPE(actualPaymentType);
		    processed = true;
		    if("U".equals(actualPaymentType))
		    {
			islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).setPAYMENT_TYPE("C");
		    }
		    int ll_start_row = i + 1;
		    ldec_profit_3_sum = 0;
		    while(ll_start_row < llTotalCount - 1)
		    {
			actualPaymentType = StringUtil.nullToEmpty(islamicCalculatorCO.getTrspayplandetVOList()
				.get(ll_start_row).getACTUAL_PAYMENT_TYPE());
			if(!"B".equals(actualPaymentType) && !"C".equals(actualPaymentType)
				&& !"P".equals(actualPaymentType))
			{
			    break;
			}
			ldec_amount_3 = NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrspayplandetVOList().get(ll_start_row + 1).getAMOUNT());
			double ldec_profit_3 = NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
				.get(ll_start_row + 1).getPROFIT_AMT_BEFORE_XIRR());
			// PMD infractions; Saheer.Naduthodi; 10/12/2014
			// double ldec_capital_3 =
			// NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
			// .get(ll_start_row + 1).getCAPITAL_AMT_BEFORE_XIRR());
			islamicCalculatorCO.getTrspayplandetVOList().get(ll_start_row + 1)
				.setAMOUNT((BigDecimal.valueOf(ldec_amount_3 - ldec_profit_3)));
			islamicCalculatorCO.getTrspayplandetVOList().get(ll_start_row + 1)
				.setPROFIT_AMT_BEFORE_XIRR((BigDecimal.valueOf(0)));
			islamicCalculatorCO.getTrspayplandetVOList().get(ll_start_row + 1)
				.setPROFIT_AMT((BigDecimal.valueOf(0)));
			ldec_profit_3_sum = ldec_profit_3_sum + ldec_profit_3;
			islamicCalculatorCO.getTrspayplandetVOList().get(ll_start_row + 1).setPAYMENT_TYPE("C");
			ll_start_row++;
		    }

		    islamicCalculatorCO.getTrspayplandetVOList().get(i)
			    .setAMOUNT(BigDecimal.valueOf(ldec_amount_1 + ldec_profit_2 + ldec_profit_3_sum));
		    islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT_BEFORE_XIRR(
			    BigDecimal.valueOf(ldec_amount_1 + ldec_profit_2 + ldec_profit_3_sum));
		    islamicCalculatorCO.getTrspayplandetVOList().get(i)
			    .setPROFIT_AMT(BigDecimal.valueOf(ldec_amount_1 + ldec_profit_2 + ldec_profit_3_sum));
		}
		else if("A".equals(actualPaymentType))
		{
		    processed = true;
		    if(i == 0)
		    {
			islamicCalculatorCO.setUpfront_profit_yn(ConstantsCommon.YES);
			islamicCalculatorCO.setUpfront_profit_amt(BigDecimal.valueOf(
				NumberUtil.toDoubleObj(islamicCalculatorCO.getUpfront_profit_amt()) + upfront_profit));

			islamicCalculatorCO.getTrspayplandetVOList().get(i)
				.setAMOUNT(BigDecimal.valueOf(ldec_amount_1 - (ldec_profit_1 + ldec_capital_1)));

			// ldec_profit_xirr =
			// NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
			// .getPROFIT_AMT());
			// ldec_capital_xirr =
			// NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
			// .getCAPITAL_AMT());

			islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT_BEFORE_XIRR(BigDecimal.ZERO);
			islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT_BEFORE_XIRR(BigDecimal.ZERO);

			islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT(BigDecimal.ZERO);
			islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT(BigDecimal.ZERO);

			ldec_amount_1 = ldec_amount_1 - (ldec_profit_1 + ldec_capital_1);
			ldec_capital_1 = 0;
			ldec_profit_1 = 0;

		    }

		    // ldt_value_date =
		    // islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE();

		    for(int j = 0; j < islamicCalculatorCO.getTrsPayPlanCriteriaVO().size(); j++)
		    {

			// Date ldt_from_date =
			// islamicCalculatorCO.getTrsPayPlanCriteriaVO().get(j).getFROM_DATE();
			// Date ldt_to_date =
			// islamicCalculatorCO.getTrsPayPlanCriteriaVO().get(j).getFROM_DATE();
			ldec_capital_amt = NumberUtil
				.toDoubleObj(islamicCalculatorCO.getTrsPayPlanCriteriaVO().get(j).getCAPITAL_AMT());
			// String ls_payment_type_repaymnt =
			// (islamicCalculatorCO.getTrsPayPlanCriteriaVO().get(j)
			// .getPAYMENT_TYPE());
			// PMD infractions; Saheer.Naduthodi; 10/12/2014 :
			// if(ls_payment_type_repaymnt.equals("A") &&
			// ldec_capital_amt > 0
			// && ldt_value_date.after(ldt_from_date) &&
			// !ldt_value_date.after(ldt_to_date))
			// {
			//
			// }
			ldec_capital_2 = ldec_capital_amt;

		    }

		    islamicCalculatorCO.getTrspayplandetVOList().get(i)
			    .setAMOUNT(BigDecimal.valueOf(ldec_amount_1 + (ldec_profit_2 + ldec_capital_2)));
		    islamicCalculatorCO.getTrspayplandetVOList().get(i)
			    .setPROFIT_AMT(BigDecimal.valueOf(ldec_amount_1 + ldec_profit_2 + ldec_profit_3_sum));

		    //
		    islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT_BEFORE_XIRR(
			    BigDecimal.valueOf(ldec_amount_1 + ldec_profit_2 + ldec_profit_3_sum));
		    islamicCalculatorCO.getTrspayplandetVOList().get(i)
			    .setCAPITAL_AMT_BEFORE_XIRR(BigDecimal.valueOf(ldec_capital_1 + ldec_capital_2));
		    islamicCalculatorCO.getTrspayplandetVOList().get(i)
			    .setCAPITAL_AMT(BigDecimal.valueOf(ldec_capital_1 + ldec_capital_2));

		    islamicCalculatorCO.getTrspayplandetVOList().get(i + 1)
			    .setAMOUNT(BigDecimal.valueOf(ldec_amount_2 - (ldec_profit_2 + ldec_capital_2)));

		    islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).setPROFIT_AMT_BEFORE_XIRR(BigDecimal.ZERO);
		    islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).setPROFIT_AMT(BigDecimal.ZERO);
		    islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).setCAPITAL_AMT_BEFORE_XIRR(
			    BigDecimal.valueOf(ldec_amount_2 - (ldec_profit_2 + ldec_capital_2)));
		    islamicCalculatorCO.getTrspayplandetVOList().get(i + 1)
			    .setCAPITAL_AMT(BigDecimal.valueOf(ldec_amount_2 - (ldec_profit_2 + ldec_capital_2)));

		    islamicCalculatorCO.getTrspayplandetVOList().get(i).setPAYMENT_TYPE(actualPaymentType);

		}
		else if("O".equals(actualPaymentType))
		{
		    processed = true;
		    if(i == 0)
		    {
			islamicCalculatorCO.setUpfront_profit_yn(ConstantsCommon.YES);
			islamicCalculatorCO.setUpfront_profit_amt(BigDecimal.valueOf(
				NumberUtil.toDoubleObj(islamicCalculatorCO.getUpfront_profit_amt()) + upfront_profit));

			islamicCalculatorCO.getTrspayplandetVOList().get(i)
				.setAMOUNT(BigDecimal.valueOf(ldec_amount_1 - ldec_profit_1));

			// ldec_profit_xirr =
			// NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
			// .getPROFIT_AMT());

			islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT_BEFORE_XIRR(BigDecimal.ZERO);

			ldec_amount_1 = ldec_amount_1 - ldec_profit_1;

		    }

		    int ll_find = returnNextProfitAmtBeforeXirrRow(islamicCalculatorCO, i + 1, llTotalCount);
		    if(ll_find >= 0)
		    {

			ldec_profit_xirr = NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrspayplandetVOList().get(ll_find).getPROFIT_AMT_BEFORE_XIRR());
			double ldec_amount_1_find = NumberUtil
				.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(ll_find).getAMOUNT());

			islamicCalculatorCO.getTrspayplandetVOList().get(ll_find)
				.setAMOUNT(BigDecimal.valueOf(ldec_amount_1_find - ldec_profit_xirr));
			islamicCalculatorCO.getTrspayplandetVOList().get(ll_find)
				.setPROFIT_AMT_BEFORE_XIRR(BigDecimal.ZERO);

			islamicCalculatorCO.getTrspayplandetVOList().get(i)
				.setAMOUNT(BigDecimal.valueOf(ldec_amount_1 + ldec_profit_xirr));
			islamicCalculatorCO.getTrspayplandetVOList().get(i)
				.setPROFIT_AMT_BEFORE_XIRR(BigDecimal.valueOf(ldec_profit_xirr));

			islamicCalculatorCO.getTrspayplandetVOList().get(i).setPAYMENT_TYPE(actualPaymentType);

		    }
		}
	    }
	}

	// if(upfront_profit > 0 || upfront_capital > 0)
	if(NumberUtil.nullToZero(islamicCalculatorCO.getUpfront_profit_amt()).doubleValue() > 0
		&& islamicCalculatorCO.getTrsPayPlanCriteriaVO().size() > 0)
	{
	    TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
	    trspayplandetCO.setLINE_NBR(BigDecimal.ONE);
	    trspayplandetCO.setVALUE_DATE(islamicCalculatorCO.getValueDate());
	    if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
	    {
		String hijiriDate = hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(),
			islamicCalculatorCO.getValueDate());
		trspayplandetCO.setVALUE_DATE_HIJRI(hijiriDate);
	    }

	    trspayplandetCO.setPAYMENT_TYPE(upfront_capital > 0 ? "B" : "P");

	    trspayplandetCO.setAMOUNT(BigDecimal.valueOf(upfront_profit + upfront_capital));
	    trspayplandetCO.setPROFIT_AMT_BEFORE_XIRR(BigDecimal.valueOf(upfront_profit));
	    trspayplandetCO.setPROFIT_AMT(BigDecimal.valueOf(upfront_profit));
	    trspayplandetCO.setCAPITAL_AMT(BigDecimal.valueOf(upfront_capital));
	    trspayplandetCO.setCAPITAL_AMT_BEFORE_XIRR(BigDecimal.valueOf(upfront_capital));

	    trspayplandetCO.setCHARGE_AMOUNT(BigDecimal.ZERO);
	    trspayplandetCO.setINSURANCE_AMOUNT(BigDecimal.ZERO);

	    trspayplandetCO.setOUTSTANDING_AMOUNT(islamicCalculatorCO.getDealAmount());
	    trspayplandetCO.setTOTAL_PRINCIPAL_OUTSTANDIG(islamicCalculatorCO.getDealAmount());

	    trspayplandetCO.setPRINCIPLE_AMT(BigDecimal.valueOf(upfront_capital));

	    trspayplandetCO.setAUTO_CREATE_SETTLEMENT(
		    islamicCalculatorCO.getTrspayplandetVOList().get(0).getAUTO_CREATE_SETTLEMENT());
	    trspayplandetCO.setACC_BR(islamicCalculatorCO.getTrspayplandetVOList().get(0).getACC_BR());
	    trspayplandetCO.setACC_CY(islamicCalculatorCO.getTrspayplandetVOList().get(0).getACC_CY());
	    trspayplandetCO.setACC_GL(islamicCalculatorCO.getTrspayplandetVOList().get(0).getACC_GL());
	    trspayplandetCO.setACC_CIF(islamicCalculatorCO.getTrspayplandetVOList().get(0).getACC_CIF());
	    trspayplandetCO.setACC_SL(islamicCalculatorCO.getTrspayplandetVOList().get(0).getACC_SL());
	    trspayplandetCO
		    .setCOVERING_ACC_BR(islamicCalculatorCO.getTrspayplandetVOList().get(0).getCOVERING_ACC_BR());
	    trspayplandetCO
		    .setCOVERING_ACC_CY(islamicCalculatorCO.getTrspayplandetVOList().get(0).getCOVERING_ACC_CY());
	    trspayplandetCO
		    .setCOVERING_ACC_GL(islamicCalculatorCO.getTrspayplandetVOList().get(0).getCOVERING_ACC_GL());
	    trspayplandetCO
		    .setCOVERING_ACC_CIF(islamicCalculatorCO.getTrspayplandetVOList().get(0).getCOVERING_ACC_CIF());
	    trspayplandetCO
		    .setCOVERING_ACC_SL(islamicCalculatorCO.getTrspayplandetVOList().get(0).getCOVERING_ACC_SL());
	    trspayplandetCO.setAUTO_CREATE_SETTLEMENT(islamicCalculatorCO.getAUTO_CREATE_SETTLEMENT());
	    trspayplandetCO.setBALLOON_PAYMENT(BigDecimal.valueOf(0L));

	    islamicCalculatorCO.getTrspayplandetVOList().add(0, trspayplandetCO);

	}
	if(processed)
	{
	    applyIAS18Method(islamicCalculatorCO);
	    printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
	}
	return islamicCalculatorCO;
    }
    
    private int returnNextProfitAmtBeforeXirrRow(IslamicCalculatorCO islamicCalculatorCO, int from, int to)
    {
	int i = 0;
	for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
	{
	    if(i > to)
	    {
		break;
	    }
	    if(from < i)
	    {
		i++;
		continue;
	    }

	    if(NumberUtil.nullToZero(trspayplandetCO.getPROFIT_AMT_BEFORE_XIRR()).doubleValue() > 0)
	    {
		return i;
	    }

	    i++;
	}
	return -1;
    }
	
	private void getCurrentYield(IslamicCalculatorCO islamicCalculatorCO)
    {
	Date currentDate = islamicCalculatorCO.getValueDate();
	if(islamicCalculatorCO.getTrspayplandetVOList() != null
		&& !islamicCalculatorCO.getTrspayplandetVOList().isEmpty())
	{
	    currentDate = islamicCalculatorCO.getTrspayplandetVOList().get(islamicCalculatorCO.getChangeEffectLineNo())
		    .getVALUE_DATE();
	}

	Date yealdDate = islamicCalculatorCO.getValueDate();
	BigDecimal annualYiled = islamicCalculatorCO.getAnnualYeild();
	for(TRSDEAL_MULTIPLE_YIELDVO multipleYIELDVO : islamicCalculatorCO.getTrsDealMultipleYieldVO())
	{
	    if(multipleYIELDVO.getFROM_DATE().before(currentDate))
	    {
		annualYiled = multipleYIELDVO.getYIELD();
		yealdDate = multipleYIELDVO.getFROM_DATE();
	    }
	    else
	    {
		break;
	    }

	}
	islamicCalculatorCO.setNextProfitValueDate(yealdDate);
	islamicCalculatorCO
		.setAnnualYeild(BigDecimal.valueOf(getActualYrild(islamicCalculatorCO, annualYiled.doubleValue())));
    }

    // EWBI160081; Saheer.Naduthodi; 29/06/2016
	private void calculateInstallmentValues(IslamicCalculatorCO islamicCalculatorCOParam) throws BaseException
    {
	IslamicCalculatorCO islamicCalculatorCO = islamicCalculatorCOParam;
	
	/**
	 * Grace period multiple yield profit
	 */
	calculateGracePeriodMultipleYieldProfit(islamicCalculatorCO);
	// calculate plan profit capital, installment etc
	islamicCalculatorCO = setPlanInstallmentDetails(islamicCalculatorCO);

	List<TrspayplandetCO> trspayplandetCOListTemp1 = new ArrayList<TrspayplandetCO>();
	islamicCalculatorCO.setOutstandingAmountForXIRR(islamicCalculatorCO.getDealAmount().doubleValue());
	if(islamicCalculatorCO.getChangeEffectLineNo() > 0)
	{
	    List<TrspayplandetCO> trspayplandetCOListTemp2 = new ArrayList<TrspayplandetCO>();
	    double outstandingAmountForXIRR = 0.00;
	    for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	    {
		if(i < islamicCalculatorCO.getChangeEffectLineNo())
		{
		    trspayplandetCOListTemp1.add(islamicCalculatorCO.getTrspayplandetVOList().get(i));
		}
		else
		{
		    trspayplandetCOListTemp2.add(islamicCalculatorCO.getTrspayplandetVOList().get(i));
		    outstandingAmountForXIRR += NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT())
			    - NumberUtil
				    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCHARGE_AMOUNT())
			    - NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(i).getINSURANCE_AMOUNT());

		}
	    }
	    islamicCalculatorCO.setOutstandingAmountForXIRR(outstandingAmountForXIRR);
	    islamicCalculatorCO.setTrspayplandetVOList(trspayplandetCOListTemp2);
	}
	/*
	 * Calculate the XIRR - As per BMMB modification the XIRR need to be
	 * calculated irrespective of the profit recognition method
	 */
	if(islamicCalculatorCO.getTrspayplandetVOList().get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
		.getAMOUNT().compareTo(BigDecimal.ZERO) == 1)
	{

	    applyIAS18Method(islamicCalculatorCO);
	    /**
	     * For TAR :IIAB130173
	     */
	    applyXirrWithCharges(islamicCalculatorCO);

	    printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
	    // if the Profit Recognition Method is Rule 78
	    if(IISCommonConstants.PROFIT_DISTRIBUTION_METHOD_RULE_78
		    .equals(islamicCalculatorCO.getProfitRecognitionMethod()))
	    {
		if(islamicCalculatorCO.getSegmentAppliedYn().equals(ConstantsCommon.YES))
		{
		    // if the segment applicable Y
		    applyRule78Segment(islamicCalculatorCO);
		}
		else
		{
		    applyRule78(islamicCalculatorCO);
		}

	    }
	    // // DASI170030 TP 555811 Fawas.Kuruvakkottil 18/09/2017 Start
	    // else
	    // if(IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
	    // .equals(islamicCalculatorCO.getProfitCalculationMethod())
	    // && islamicCalculatorCO.getProfitRecognitionMethod()
	    // .equals(IISCommonConstants.PROFIT_DISTRIBUTION_METHOD_STRAIGHT_LINE))
	    // {
	    // applyDistributionStraightLine(islamicCalculatorCO);
	    // } // DASI170030 TP 555811 Fawas.Kuruvakkottil 18/09/2017 End
	}
	if(!trspayplandetCOListTemp1.isEmpty())
	{
	    // for(trspayplandetCOListTemp1 : trspayplandetCO
	    int i = 0;
	    for(TrspayplandetCO trspayplandetCOTemp : trspayplandetCOListTemp1)
	    {
		islamicCalculatorCO.getTrspayplandetVOList().add(i, trspayplandetCOTemp);
		i++;
	    }
	}

	/*
	 * Apply rounding after the entire calculation. no need to recalculate
	 * the profit or principal just round then installment amount to nearest
	 * 1
	 */
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getApplyRoundingFact_after_calc())
		&& islamicCalculatorCO.getRoundingFactor() == 1L
		&& NumberUtil.toDouble(islamicCalculatorCO.getAmountPerPayment()) == 0D
		&& ConstantsCommon.NO.equals(islamicCalculatorCO.getRedusingBalanceMethod())
		&& ConstantsCommon.YES.equals(islamicCalculatorCO.getUpfrontProduct()))
	{
	    applyRoundingFactorAfterCalculation(islamicCalculatorCO);
	}

	if(islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().size() > 0)
	{
	    setGracePeriodCompoundingProfitWithInstallment(islamicCalculatorCO);
	}
	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
	if(islamicCalculatorCO.getTrspayplandetCompoundingDealPeriod().size() > 0
		&& IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
			.equals(islamicCalculatorCO.getProfitCalculationMethod()))
	{
	    setDealPeriodCompoundingProfitWithInstallment(islamicCalculatorCO);
	}

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCapitalization()))
	{
	    calculateCapitalizationProfit(islamicCalculatorCO);
	}
	// if calculate the daily depreciation
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getDailyDepreciationYn()))
	{
	    setDailyDepreciation(islamicCalculatorCO);
	}
	// Calculate the Vat amount
	calculateVatOninstallment(islamicCalculatorCO);
	// EWBI160081; Saheer.Naduthodi; 02/03/2017
	applySetttlementCharges(islamicCalculatorCO);
	
	allocateChargeOnYearlyoutstandingCapital(islamicCalculatorCO);
	
	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
    }

	// EWBI160081; Saheer.Naduthodi; 29/06/2016
    private void applySetttlementCharges(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {

	islamicCalculatorCO.getCalculatorType();
	BigDecimal settlChargesInstalment = BigDecimal.ZERO;
	BigDecimal settlChargesNotInstalment = BigDecimal.ZERO;
	BigDecimal settlChargesVATInstalment = BigDecimal.ZERO;
	if(islamicCalculatorCO.getTrsdealStlmntChargesList() == null
		|| islamicCalculatorCO.getTrsdealStlmntChargesList().isEmpty())
	{
	    List<TrsDealSettlementChargesCO> settlementChargesVOList = iisIslamicCalculatorDAO
		    .returnDealSettlementChargeDet(islamicCalculatorCO);
	    for(TrsDealSettlementChargesCO settlementChargesVO : settlementChargesVOList)
	    {
		if(ConstantsCommon.YES.equals(settlementChargesVO.getINCLUDE_IN_INSTALLMENT_YN()))
		{
		    settlChargesInstalment = settlChargesInstalment.add(settlementChargesVO.getCHARGE_AMOUNT());
		}
		else
		{
		    settlChargesNotInstalment = settlChargesNotInstalment.add(settlementChargesVO.getCHARGE_AMOUNT());
		}
	    }
	    if(!settlementChargesVOList.isEmpty())
	    {
		for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
		{
		    trspayplandetCO.setAMOUNT(trspayplandetCO.getAMOUNT().add(settlChargesInstalment));
		    // TP# BAJ200023 Fawas.Kuruvakkottil 22/10/2020
		    if(!IISCommonConstants.PAYMENT_TYPE_ASSET_RESIDUAL_VALUE.equals(trspayplandetCO.getPAYMENT_TYPE()))
		    {
			trspayplandetCO.setSettlChargesInstalment(settlChargesInstalment);
			trspayplandetCO.setSettlChargesNotInstalment(settlChargesNotInstalment);
			trspayplandetCO.setVatChargesAtDealPlan(settlChargesVATInstalment);
		    }
		}
	    }
	}
	else
	{
	    for(TrsDealSettlementChargesCO settlementChargesCO : islamicCalculatorCO.getTrsdealStlmntChargesList())
	    {
		if(NumberUtil.emptyDecimalToZero(settlementChargesCO.getCHARGE_CODE()).compareTo(BigDecimal.ZERO) != 1)
		{
		    throw new BOException(MessageCodes.INVALID_CHARGE_CODE);
		}
		if(ConstantsCommon.YES.equals(settlementChargesCO.getINCLUDE_IN_INSTALLMENT_YN()))
		{
		    // TP# BAJ200023 Fawas.Kuruvakkottil 22/10/2020
		BigDecimal chargeAmount = NumberUtil.nullToZero(settlementChargesCO.getCHARGE_AMOUNT());
		if(chargeAmount.compareTo(BigDecimal.ZERO) > 0)
		{
		    settlChargesVATInstalment = NumberUtil.nullToZero(settlementChargesCO.getVAT_AMOUNT());
		    TRSCHARGESVOKey trschargesVoKey = new TRSCHARGESVOKey();
		    trschargesVoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
		    trschargesVoKey.setCODE(settlementChargesCO.getCHARGE_CODE());
		    TRSCHARGESVO trschargesvo = iisIslamicCalculatorDAO.getChargesDetails(trschargesVoKey);
		    if(ConstantsCommon.NO.equals(trschargesvo.getCHARGE_AMT_PER_INST_YN()))
		    {
			BigDecimal settlChargesPerInstalment = chargeAmount.divide(
				islamicCalculatorCO.getNoOfPayments(),
				islamicCalculatorCO.getDealCyDecimalPoint().intValue(), BigDecimal.ROUND_HALF_UP);
			BigDecimal settlChargesVATPerInstalment = settlChargesVATInstalment.divide(
				islamicCalculatorCO.getNoOfPayments(),
				islamicCalculatorCO.getDealCyDecimalPoint().intValue(), BigDecimal.ROUND_HALF_UP);
			chargeAmount = settlChargesPerInstalment;
			settlChargesVATInstalment = settlChargesVATPerInstalment;
		    }

		    if(ConstantsCommon.YES.equals(settlementChargesCO.getINCLUDE_IN_INSTALLMENT_YN()))
		    {

			settlChargesInstalment = settlChargesInstalment.add(chargeAmount);
		    }
		    else
		    {
			settlChargesNotInstalment = settlChargesNotInstalment.add(chargeAmount);
		    }
		}
		}
		else
		{
		    settlChargesNotInstalment = settlChargesNotInstalment
			    .add(NumberUtil.emptyDecimalToZero(settlementChargesCO.getCHARGE_AMOUNT()));
		}
	    }
	    if(!islamicCalculatorCO.getTrsdealStlmntChargesList().isEmpty())
	    {
		for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
		{
		    trspayplandetCO.setAMOUNT(trspayplandetCO.getAMOUNT().add(settlChargesInstalment));
		    // TP# BAJ200023 Fawas.Kuruvakkottil 22/10/2020
		    if(!IISCommonConstants.PAYMENT_TYPE_ASSET_RESIDUAL_VALUE.equals(trspayplandetCO.getPAYMENT_TYPE()))
		    {
			trspayplandetCO.setSettlChargesInstalment(settlChargesInstalment);
			trspayplandetCO.setVatChargesAtDealPlan(settlChargesVATInstalment);
			trspayplandetCO.setSettlChargesNotInstalment(settlChargesNotInstalment);
		    }
		}
	    }

	}

    }

	private IslamicCalculatorCO defaultDealValues(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	TRSDEALVOKey trsdealvoKey = new TRSDEALVOKey();
	// TRSDEALVO trsdealvo = new TRSDEALVO();
	TRSDEALVO trsdealvo = null;
	trsdealvoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	trsdealvoKey.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
	trsdealvoKey.setSERIAL_NO(islamicCalculatorCO.getDealNo());

	if(islamicCalculatorCO.getDisbursementScreen())
	{
	    trsdealvo = iisIslamicCalculatorDAO.getTrsDealDisbursmentDetails(trsdealvoKey);
	    trsdealvoKey.setSERIAL_NO(trsdealvo.getLINKED_DEAL_NO());
	    TRSDEALVO trsdealvoTemp = iisIslamicCalculatorDAO.getTrsDealDetails(trsdealvoKey);
	    islamicCalculatorCO.setOriginalValueDate(trsdealvoTemp.getVALUE_DATE());
	    islamicCalculatorCO.setLinkedDealNo(trsdealvo.getLINKED_DEAL_NO());
	    trsdealvoTemp = null;
	}
	else
	{
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getFetchDataFromDbYn()))
	    {
		trsdealvo = iisIslamicCalculatorDAO.getTrsDealDetails(trsdealvoKey);

		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCalledFromFirstLeg()))
		{
		    TRSDEAL_SWAP_DETAILSVO trsdealSwapDetailsVO = new TRSDEAL_SWAP_DETAILSVO();
		    trsdealSwapDetailsVO.setCOMP_CODE(trsdealvoKey.getCOMP_CODE());
		    trsdealSwapDetailsVO.setBRANCH_CODE(trsdealvoKey.getBRANCH_CODE());
		    trsdealSwapDetailsVO.setDEAL_NO(trsdealvoKey.getSERIAL_NO());
		    trsdealSwapDetailsVO = (TRSDEAL_SWAP_DETAILSVO) genericDAO.selectByPK(trsdealSwapDetailsVO);
		    if(trsdealSwapDetailsVO != null)
		    {
			trsdealvo.setDEAL_EXPECTED_YIELD(trsdealSwapDetailsVO.getYIELD());
			trsdealvo.setLIBOR_RATE(BigDecimal.ZERO);
			// islamicCalculatorCO.setHolidayAction(trsdealSwapDetailsVO.getHOLIDAY_ACTION());

			if(!NumberUtil.isEmptyDecimal(trsdealSwapDetailsVO.getACCRUAL_BASIS()))
			{
			    islamicCalculatorCO
				    .setProfitAccrualBasis(trsdealSwapDetailsVO.getACCRUAL_BASIS().longValue());
			}

		    }

		}
		if(IISCommonConstants.RESCHEDULE_TYPE_ADVANCE_PRINCIPAL_SETTL
			.equals(islamicCalculatorCO.getRescheduleType()))
		{
		    islamicCalculatorCO.setOriginalValueDate(trsdealvo.getVALUE_DATE());
		}
	    }
	    else if(ConstantsCommon.NO.equals(islamicCalculatorCO.getFetchDataFromDbYn()))
	    {
		if(islamicCalculatorCO.getTrsdealvo() != null)
		{
		    trsdealvo = islamicCalculatorCO.getTrsdealvo();
		}
		trsdealvo.setDEAL_AMOUNT(islamicCalculatorCO.getDealAmount());
		trsdealvo.setVALUE_DATE(islamicCalculatorCO.getValueDate());
		trsdealvo.setMATURITY_DATE(islamicCalculatorCO.getMaturityDate());
		trsdealvo.setDEAL_EXPECTED_YIELD(islamicCalculatorCO.getPLAN_EXPECTED_YIELD());
		trsdealvo.setLIBOR_RATE(islamicCalculatorCO.getPLAN_LIBOR_RATE());
		trsdealvo.setVAT_CODE(BigDecimal.valueOf(NumberUtil.toDouble(islamicCalculatorCO.getVatCode())));
	    }
	}

	if(trsdealvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_DEAL_REFERENCE);
	}
	if((trsdealvo.getSTATUS() == null || !IISCommonConstants.STATUS_APPROVE.equals(trsdealvo.getSTATUS()))
		&& IISCommonConstants.FALSE.equals(islamicCalculatorCO.getCombainedScreen()))
	{
	    throw new BOException(MessageCodes.DEAL_STATUS_IS_NOT_APPROVED);
	}
	// #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015 [Start]
//	if("Y".equals(islamicCalculatorCO.getFetchDataFromDbYn()))
//	{
//	    TRSDEAL2VOKey trsdeal2VOKey = new TRSDEAL2VOKey();
//	    trsdeal2VOKey.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
//	    trsdeal2VOKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
//	    if(islamicCalculatorCO.getDisbursementScreen())
//	    {
//		trsdeal2VOKey.setSERIAL_NO(islamicCalculatorCO.getLinkedDealNo());
//	    }
//	    else
//	    {
//		trsdeal2VOKey.setSERIAL_NO(islamicCalculatorCO.getDealNo());
//	    }
//	    islamicCalculatorCO.setAgencyFeePercentage(NumberUtil.nullToZero(iisIslamicCalculatorDAO
//		    .returnAgencyFeePcnt(trsdeal2VOKey)));
//	}
	// #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015 [End]
	if(!IISCommonConstants.RESCHEDULE_YES.equals(StringUtil.nullToEmpty(islamicCalculatorCO.getRescheduleYn())))
	{
	    islamicCalculatorCO.setProductClassCode(trsdealvo.getCLASS());
	    islamicCalculatorCO.setDealCurrency(trsdealvo.getDEAL_CY());

	    if(islamicCalculatorCO.getDisbursementScreen())
	    {
		islamicCalculatorCO.setDealAmount(
			trsdealvo.getDEAL_AMOUNT().add(NumberUtil.nullToZero(islamicCalculatorCO.getDealAmount())));
	    }
	    else
	    {
		islamicCalculatorCO.setDealAmount(trsdealvo.getDEAL_AMOUNT());
	    }

	    islamicCalculatorCO.setMaturityDate(trsdealvo.getMATURITY_DATE());
	    if(islamicCalculatorCO.getValueDate() == null)
	    {
		islamicCalculatorCO.setValueDate(trsdealvo.getVALUE_DATE());
	    }
	    if(islamicCalculatorCO.getResidualValue() == null)
	    {
		islamicCalculatorCO.setResidualValue("L");
	    }
	    if(islamicCalculatorCO.getFirstPaymentDate() == null)
	    {
		islamicCalculatorCO.setFirstPaymentDate(islamicCalculatorCO.getValueDate());
	    }

	}
	else
	{
	    if(islamicCalculatorCO.getTrsDealMultipleYieldVO() != null
		    && !islamicCalculatorCO.getTrsDealMultipleYieldVO().isEmpty())
	    {

		for(int i = islamicCalculatorCO.getTrsDealMultipleYieldVO().size() - 1; i >= 0; i--)
		{
		    TRSDEAL_MULTIPLE_YIELDVO multipleYIELDVO = islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i);
		    if(!multipleYIELDVO.getFROM_DATE().after(islamicCalculatorCO.getValueDate()))
		    {
			islamicCalculatorCO.setAnnualYeild(multipleYIELDVO.getYIELD());
			break;
		    }
		}
	    }
	}

	if(NumberUtil.nullToZero(islamicCalculatorCO.getHolidayAction()).compareTo(BigDecimal.ZERO) == 0)
	{
	    islamicCalculatorCO.setHolidayAction(trsdealvo.getHOLIDAY_ACTION());
	}
	else if(islamicCalculatorCO.getHolidayAction().compareTo(BigDecimal.ZERO) == -1)
	{
	    islamicCalculatorCO.setHolidayAction(BigDecimal.ZERO);
	}
	TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	trsClassVOKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	trsClassVOKey.setCODE(islamicCalculatorCO.getProductClassCode());
	TRSCLASSVO trsClassVO = iisIslamicCalculatorDAO.getProductClassDetails(trsClassVOKey);
	trsClassVOKey = null;
	islamicCalculatorCO.setUpfrontProduct(trsClassVO.getPROFIT_UPFRONT());
	islamicCalculatorCO.setCapitalizePeriodicity(trsClassVO.getCAPITALIZE_PAYM_PERIODICITY());
	islamicCalculatorCO.setCapitalizePeriodicityNo(trsClassVO.getCAPITALIZE_PAYM_PERIOD_NBR().longValue());
	islamicCalculatorCO.setCapitalizePeriodicityNopos(trsClassVO.getCAPITALIZE_PAYM_PERIOD_POS());
	islamicCalculatorCO.setDailyDepreciationYn(trsClassVO.getDAILY_DEPRECIATION_YN());

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCalledFromIPRSYN()) 
			&& !ConstantsCommon.YES.equals(islamicCalculatorCO.getCalledFromFirstLeg()))
	{
	    TRSDEAL2VO trsdeal2VO = new TRSDEAL2VO();
	    trsdeal2VO.setCOMP_CODE(trsdealvoKey.getCOMP_CODE());
	    trsdeal2VO.setBRANCH_CODE(trsdealvoKey.getBRANCH_CODE());
	    trsdeal2VO.setSERIAL_NO(trsdealvoKey.getSERIAL_NO());
	    trsdeal2VO = (TRSDEAL2VO) genericDAO.selectByPK(trsdeal2VO);
	    if(trsdeal2VO != null)
	    {
		BigDecimal accrualBasis = trsdeal2VO.getACCRUAL_BASIS();

		if(islamicCalculatorCO.getProfitAccrualBasis() != null
			&& islamicCalculatorCO.getProfitAccrualBasis().compareTo(0L) != 1
			&& (!NumberUtil.isEmptyDecimal(accrualBasis)))
		{
		    islamicCalculatorCO.setProfitAccrualBasis(accrualBasis.longValue());
		}
	    }
	}
	if(islamicCalculatorCO.getProfitAccrualBasis() != null
		&& islamicCalculatorCO.getProfitAccrualBasis().compareTo(0L) != 1)
	{
	    islamicCalculatorCO.setProfitAccrualBasis(trsClassVO.getACCRUAL_BASIS().longValue());
	}
	islamicCalculatorCO.setSegmentAppliedYn(trsClassVO.getSEGMENT_APPLIED_YN());
	islamicCalculatorCO.setACCRUAL_AMOUNT_TYPE(trsClassVO.getACCRUAL_AMOUNT_TYPE());
	islamicCalculatorCO.setDEAL_CATEGORY(trsClassVO.getCATEGORY());
	islamicCalculatorCO.setPLAN_SHOW_PRINCIPAL_AMOUNT_YN(trsClassVO.getPLAN_SHOW_PRINCIPAL_AMOUNT_YN());
	islamicCalculatorCO.setEXCL_PRFT_RECLC_DUE_INST_YN(trsClassVO.getEXCL_PRFT_RECLC_DUE_INST_YN());
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getDealAmmendmentYn()))
	{
	    islamicCalculatorCO.setDealAmount(trsdealvo.getDEAL_AMOUNT()
		    .subtract(NumberUtil.nullToZero(islamicCalculatorCO.getSettledCapital())));
	}
	if(IISCommonConstants.ACCRUAL_AMOUNT_TYPE_PROFIT.equals(islamicCalculatorCO.getACCRUAL_AMOUNT_TYPE()))
	{
	    islamicCalculatorCO.setPLAN_SHOW_PRINCIPAL_AMOUNT_YN(ConstantsCommon.YES);
	}

	trsClassVO = null;

	if(!IISCommonConstants.RESCHEDULE_YES.equals(StringUtil.nullToEmpty(islamicCalculatorCO.getRescheduleYn())))
	{
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getUpfrontProduct()))
	    {
		if(ConstantsCommon.NO.equals(islamicCalculatorCO.getFetchDataFromDbYn()))
		{
		    trsdealvo.setYIELD(trsdealvo.getDEAL_EXPECTED_YIELD());
		}
		islamicCalculatorCO.setAnnualYeild(trsdealvo.getYIELD());
	    }
	    else
	    {
	    	islamicCalculatorCO.setAnnualYeild(NumberUtil.emptyDecimalToZero(trsdealvo.getDEAL_EXPECTED_YIELD()).add(NumberUtil.emptyDecimalToZero(trsdealvo.getLIBOR_RATE())));

	    }
	    islamicCalculatorCO.setVatCode(NumberUtil.emptyDecimalToZero(trsdealvo.getVAT_CODE()).longValue());

	    if(ConstantsCommon.YES.equals(StringUtil.nullToEmpty(islamicCalculatorCO.getTentativeSchedule()))
		    || ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement()))
	    {
		TRSDEAL3VOKey trsdeal3voKey = new TRSDEAL3VOKey();
		trsdeal3voKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
		trsdeal3voKey.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
		trsdeal3voKey.setSERIAL_NO(islamicCalculatorCO.getDealNo());
		islamicCalculatorCO.setTrsDealMultipleDisbursementList(
			iisIslamicCalculatorDAO.getDealDisbursementDetails(trsdeal3voKey));
		trsdeal3voKey = null;
	    }

	    islamicCalculatorCO.setMudarabahRateCode(trsdealvo.getMUDARABAH_RATE_CODE());
	    // get deal charges trsdealchargesVO
	    TRSDEALCHARGESVOKey trsdealchargesvoKey = new TRSDEALCHARGESVOKey();
	    trsdealchargesvoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	    trsdealchargesvoKey.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
	    trsdealchargesvoKey.setSERIAL_NO(islamicCalculatorCO.getDealNo());
	    islamicCalculatorCO.setTrsdealchargesVO(iisIslamicCalculatorDAO.getDealChargesdet(trsdealchargesvoKey));
	}
	islamicCalculatorCO.setAUTO_CREATE_SETTLEMENT(trsdealvo.getAUTO_CREATE_SETTLEMENT());

	/**
	 * Get The maturity account from TRSDET to set in payplan det
	 */
	if(islamicCalculatorCO.getDisbursementScreen())
	{
	    trsdealvoKey.setSERIAL_NO(islamicCalculatorCO.getLinkedDealNo());
	}
	TRSDETVO trsdetvo = iisIslamicCalculatorDAO.getDealMaturityAccount(trsdealvoKey);
	if(trsdetvo != null)
	{
	    // throw new BOException(MessageCodes.INVALID_SERIAL_NO);
	    islamicCalculatorCO.setTRSDET_MATR_AC_BRIEF_NAME_ENG(trsdetvo.getCONTRIBBLOCK_TRF_REASON());
	    islamicCalculatorCO.setTRSDET_MATR_AC_BR(trsdetvo.getMATR_AC_BR());
	    islamicCalculatorCO.setTRSDET_MATR_AC_CIF(trsdetvo.getMATR_AC_CIF());
	    islamicCalculatorCO.setTRSDET_MATR_AC_CY(trsdetvo.getMATR_AC_CY());
	    islamicCalculatorCO.setTRSDET_MATR_AC_GL(trsdetvo.getMATR_AC_GL());
	    islamicCalculatorCO.setTRSDET_MATR_AC_SL(trsdetvo.getMATR_AC_SL());
	}

	return islamicCalculatorCO;
    }

	private void setCalculatorResultSet(IslamicCalculatorCO islamicCalculatorCO)
    {
	double totalInstallmentAmount = 0d;
	double totalProfitAmount = 0d;
	double totalCapitalAmount = 0d;
	double annualFlatRate = 0d;
	double totalFlatRate = 0d;
	double totalVat = 0d;
	// if(islamicCalculatorCO.getCalculatorType().equals(IISCommonConstants.CALCULATOR_TYPE_CALCULATOR))
	// {
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVAT_AMOUNT() == null)
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setVAT_AMOUNT(BigDecimal.ZERO);
	    }
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	    {
		totalInstallmentAmount = totalInstallmentAmount
			+ islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT().doubleValue();
	    }
	    else
	    {
		totalInstallmentAmount = totalInstallmentAmount
			+ islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT().doubleValue()
			- NumberUtil.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVAT_AMOUNT())
				.doubleValue();
	    }
	    totalCapitalAmount = totalCapitalAmount
		    + islamicCalculatorCO.getTrspayplandetVOList().get(i).getPRINCIPLE_AMT().doubleValue();
	    totalProfitAmount = totalProfitAmount
		    + islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT().doubleValue();
	   
	    totalVat=totalVat+ islamicCalculatorCO.getTrspayplandetVOList().get(i).getVAT_AMOUNT().doubleValue();
	    
	    if(islamicCalculatorCO.isGovtPromotedProduct())
	    {
		BigDecimal govtProfitShare = (BigDecimal.ONE);
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setGOVT_PROFIT_SHARE(govtProfitShare);
		islamicCalculatorCO.getTrspayplandetVOList().get(i)
			.setTotalProfit(NumberUtil
				.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT())
				.add(govtProfitShare));
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setTotalInstallmentAmount(
			NumberUtil.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT())
				.add(govtProfitShare));

	    }
	}
	totalCapitalAmount = NumberUtil.round(totalCapitalAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	totalInstallmentAmount = NumberUtil.round(totalInstallmentAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	totalProfitAmount = NumberUtil.round(totalProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint());

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	{
	    islamicCalculatorCO.setTotalNetPrecentValue(BigDecimal.valueOf(totalCapitalAmount));
	    double totalflatRate = NumberUtil.round(totalProfitAmount / totalCapitalAmount * 100D, 6);
	    islamicCalculatorCO.setTotalFlatRate(BigDecimal.valueOf(totalflatRate));

	}

	// Added for 91560 Incorrect Amount per payment when the plan links
	// with Balloon payment.
	double amountPerPayment = 0d;
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if(NumberUtil.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getBALLOON_PAYMENT())
		    .compareTo(BigDecimal.ZERO) == 0)
	    {
		amountPerPayment = islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT().doubleValue()
			- NumberUtil
				.nullToZero(islamicCalculatorCO.getTrspayplandetVOList()
					.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getVAT_AMOUNT())
				.doubleValue();
		break;
	    }
	    else
	    {
		amountPerPayment = islamicCalculatorCO.getTrspayplandetVOList().get(0).getAMOUNT().doubleValue()
			- NumberUtil
				.nullToZero(islamicCalculatorCO.getTrspayplandetVOList()
					.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getVAT_AMOUNT())
				.doubleValue();
	    }

	}
	// Removing the vat as per Jose in the latest PB not shown 91082: In
	// the result set the schedule is displayed as 188 for the amount
	// per payment, The plan is displaying the correct amount
	// - islamicCalculatorCO.getTrspayplandetVOList().get(
	// islamicCalculatorCO.getTrspayplandetVOList().size() -
	// 1).getVAT_AMOUNT().doubleValue();
	amountPerPayment = NumberUtil.round(amountPerPayment, islamicCalculatorCO.getDealCyDecimalPoint());
	islamicCalculatorCO.setOutAmountPerPayment(BigDecimal.valueOf(amountPerPayment));
	//TP #709163	BTII180061 05/09/2018 SANKAR.REMANAN
	totalInstallmentAmount =totalInstallmentAmount+totalVat;

	islamicCalculatorCO.setOutRemainingAmount(BigDecimal
		.valueOf(NumberUtil.round(totalInstallmentAmount, islamicCalculatorCO.getDealCyDecimalPoint())));
	islamicCalculatorCO.setOutSaleAmount(BigDecimal.valueOf(NumberUtil.round(
		totalInstallmentAmount + NumberUtil.nullToZero(islamicCalculatorCO.getDownPaymentAmt()).doubleValue(),
		islamicCalculatorCO.getDealCyDecimalPoint())));
	islamicCalculatorCO.setOutProfitAmount(
		BigDecimal.valueOf(NumberUtil.round(totalProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint())));
	if(totalProfitAmount > 0)
	{

	    if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		    .equals(islamicCalculatorCO.getProfitCalculationMethod()))
	    {
		annualFlatRate = islamicCalculatorCO.getAnnualYeild().doubleValue();
	    }
	    else
	    {
		// annualFlatRate = NumberUtil.round((totalProfitAmount /
		// islamicCalculatorCO.getDealAmount()
		long days = DateUtil.numberOfDays(islamicCalculatorCO.getValueDate(),
			islamicCalculatorCO.getMaturityDate());
		if(days <= 0)
		{
		    days = 1;
		}
		annualFlatRate = round(
			(totalProfitAmount / islamicCalculatorCO.getDealAmount().doubleValue()) * 100 * 365 / days, 12);
	    }
	    if(annualFlatRate > islamicCalculatorCO.getAnnualYeild().doubleValue())
	    {
		islamicCalculatorCO.setOutAnnualFlatRate(islamicCalculatorCO.getAnnualYeild());
	    }
	    else
	    {
		islamicCalculatorCO.setOutAnnualFlatRate(BigDecimal.valueOf(NumberUtil.round(annualFlatRate, 12)));
	    }

	    // Added for issue 61349
	    if(NumberUtil.nullToZero(islamicCalculatorCO.getTotalFlatRate()).compareTo(BigDecimal.ZERO) == 1)
	    {
		islamicCalculatorCO.setOutTotalFlatRate(islamicCalculatorCO.getTotalFlatRate());
	    }
	    else
	    {
		if(IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
			.equals(islamicCalculatorCO.getProfitCalculationMethod()))
		{
		    totalFlatRate = NumberUtil
			    .round((totalProfitAmount / islamicCalculatorCO.getDealAmount().doubleValue()) * 100, 6);
		}
		else
		{
		    totalFlatRate = NumberUtil.round(DateUtil.numberOfDays(islamicCalculatorCO.getValueDate(),
			    islamicCalculatorCO.getMaturityDate())
			    * (NumberUtil.toDouble(islamicCalculatorCO.getAnnualYeild()) / 365), 6);
		}
		islamicCalculatorCO.setOutTotalFlatRate(BigDecimal.valueOf(totalFlatRate));

	    }

	}
    }

    // }

    /*
     * private void setTestValues(IslamicCalculatorCO islamicCalculatorCO) {
     * BigDecimal companyCode = BigDecimal.valueOf(1); BigDecimal BranchCode =
     * new BigDecimal(1); BigDecimal productClassCode = BigDecimal.valueOf(0);
     * BigDecimal dealCurrency = BigDecimal.valueOf(40); BigDecimal dealAmount =
     * new BigDecimal(500000); Date valueDate = DateUtil.createDate(2010, 1, 1);
     * Date maturityDate = DateUtil.createDate(2011, 1, 1); BigDecimal
     * annualYeild = BigDecimal.valueOf(12); BigDecimal maxYeild = new
     * BigDecimal(0); BigDecimal minYeild = BigDecimal.valueOf(0);
     * 
     * islamicCalculatorCO.setCompanyCode(companyCode);
     * islamicCalculatorCO.setBranchCode(BranchCode);
     * islamicCalculatorCO.setProductClassCode(productClassCode);
     * islamicCalculatorCO.setDealCurrency(dealCurrency);
     * islamicCalculatorCO.setDealAmount(dealAmount);
     * islamicCalculatorCO.setValueDate(valueDate);
     * islamicCalculatorCO.setMaturityDate(maturityDate);
     * islamicCalculatorCO.setAnnualYeild(annualYeild);
     * islamicCalculatorCO.setMaxYeild(maxYeild);
     * islamicCalculatorCO.setMinYeild(minYeild);
     * 
     * BigDecimal profitOnCharges = BigDecimal.valueOf(0); BigDecimal
     * profitOnInsurance = BigDecimal.valueOf(0); BigDecimal totalCharges = new
     * BigDecimal(0); BigDecimal totalInsurance = BigDecimal.valueOf(0); String
     * profitCalculationMethod = "R"; String profitRecognitionMethod = "R"; Long
     * profitAccrualBasis = 2L; String compudingDealPeriod = ConstantsCommon.NO;
     * String compoudingGracePeriod = ConstantsCommon.NO; String
     * compoundingProfitPeriodicity = "M"; Long compoundingProfitPeriodicityNo =
     * 1L;
     * 
     * BigDecimal templateCode = BigDecimal.valueOf(0); Date firstPaymentDate =
     * DateUtil.createDate(2010, 2, 1);
     * 
     * islamicCalculatorCO.setProfitOnCharges(profitOnCharges);
     * islamicCalculatorCO.setProfitOnInsurance(profitOnInsurance);
     * islamicCalculatorCO.setTotalCharges(totalCharges);
     * islamicCalculatorCO.setTotalInsurance(totalInsurance);
     * islamicCalculatorCO.setProfitCalculationMethod(profitCalculationMethod);
     * islamicCalculatorCO.setProfitRecognitionMethod(profitRecognitionMethod);
     * islamicCalculatorCO.setProfitAccrualBasis(profitAccrualBasis);
     * islamicCalculatorCO.setCompudingDealPeriod(compudingDealPeriod);
     * islamicCalculatorCO.setCompoudingGracePeriod(compoudingGracePeriod);
     * islamicCalculatorCO.setTemplateCode(templateCode);
     * islamicCalculatorCO.setFirstPaymentDate(firstPaymentDate);
     * 
     * islamicCalculatorCO.setCompoundingProfit(compoudingGracePeriod);
     * islamicCalculatorCO
     * .setCompoundingProfitPeriodicity(compoundingProfitPeriodicity);
     * islamicCalculatorCO
     * .setCompoundingProfitPeriodicityNo(compoundingProfitPeriodicityNo);
     * 
     * BigDecimal noOfPayments = BigDecimal.valueOf(350); String
     * paymentPeriodicity = "M"; Long paymentPeriodicityNo = 1L; String
     * paymentPeriodicityMonthPos = "S"; String residualValue = "L"; BigDecimal
     * amountPerPayment = new BigDecimal(0); Long roundingFactor = 0L; String
     * principalInLastPayment = ConstantsCommon.NO; String tentativeSchedule =
     * ConstantsCommon.NO; String calendarType = "H";
     * 
     * islamicCalculatorCO.setNoOfPayments(noOfPayments);
     * islamicCalculatorCO.setPaymentPeriodicity(paymentPeriodicity);
     * islamicCalculatorCO.setPaymentPeriodicityNo(paymentPeriodicityNo);
     * islamicCalculatorCO
     * .setPaymentPeriodicityMonthPos(paymentPeriodicityMonthPos);
     * islamicCalculatorCO.setResidualValue(residualValue);
     * islamicCalculatorCO.setAmountPerPayment(amountPerPayment);
     * islamicCalculatorCO.setRoundingFactor(roundingFactor);
     * islamicCalculatorCO.setPrincipalInLastPayment(principalInLastPayment);
     * islamicCalculatorCO.setTentativeSchedule(tentativeSchedule);
     * islamicCalculatorCO.setCalendarType(calendarType);
     * 
     * String redusingBalanceMethod = ConstantsCommon.NO;
     * islamicCalculatorCO.setRedusingBalanceMethod(redusingBalanceMethod);
     * String segmentAppliedYn = ConstantsCommon.NO; BigDecimal
     * totalBalloonAmount = new BigDecimal(0); String UpfrontProduct =
     * ConstantsCommon.YES; String outstandingPrincipalAsInstallment =
     * ConstantsCommon.NO; Date outstandingPrincipalInstallmentDate =
     * DateUtil.createDate(2009, 01, 23); String equalInstallmentForDisbursement
     * = ConstantsCommon.NO;
     * 
     * islamicCalculatorCO.setSegmentAppliedYn(segmentAppliedYn);
     * islamicCalculatorCO.setTotalBalloonAmount(totalBalloonAmount);
     * islamicCalculatorCO.setUpfrontProduct(UpfrontProduct);
     * islamicCalculatorCO
     * .setOutstandingPrincipalAsInstallment(outstandingPrincipalAsInstallment);
     * islamicCalculatorCO .setOutstandingPrincipalInstallmentDate(
     * outstandingPrincipalInstallmentDate );
     * islamicCalculatorCO.setMaxYeild(BigDecimal.valueOf(20));
     * islamicCalculatorCO.setMinYeild(BigDecimal.valueOf(2));
     * islamicCalculatorCO.setEqualInstallmentForDisbursement
     * (equalInstallmentForDisbursement);
     * 
     * String capitalization = ConstantsCommon.NO; Date capitalizationStartOn =
     * DateUtil.createDate(2008, 2, 15); String capitalizePeriodicity = "M";
     * Long capitalizePeriodicityNo = 1L; String capitalizePeriodicityNopos =
     * "D"; Long capitalizePeriodicitySetDay = 16L;
     * 
     * String vatIncludeInstallment = ConstantsCommon.NO; Long vatCode = 1L;
     * Double vatPercentage = 17D; String dilyDepreciationYn =
     * ConstantsCommon.NO;
     * 
     * islamicCalculatorCO.setDailyDepreciationYn(dilyDepreciationYn);
     * islamicCalculatorCO.setIncludeVatInInstallment(vatIncludeInstallment);
     * islamicCalculatorCO.setVatCode(vatCode);
     * islamicCalculatorCO.setVatPercentage(vatPercentage);
     * 
     * islamicCalculatorCO.setCapitalization(capitalization);
     * islamicCalculatorCO.setCapitalizationStartOn(capitalizationStartOn);
     * islamicCalculatorCO.setCapitalizePeriodicity(capitalizePeriodicity);
     * islamicCalculatorCO.setCapitalizePeriodicityNo(capitalizePeriodicityNo);
     * islamicCalculatorCO
     * .setCapitalizePeriodicityNopos(capitalizePeriodicityNopos);
     * islamicCalculatorCO
     * .setCapitalizePeriodicitySetDay(capitalizePeriodicitySetDay);
     * 
     * 
     * // List<TRSPAYPLAN_SEGMENT_START_DATESVO> trspayplanSegment = new //
     * ArrayList<TRSPAYPLAN_SEGMENT_START_DATESVO>(); //
     * TRSPAYPLAN_SEGMENT_START_DATESVO trspayplanSegment1 = new //
     * TRSPAYPLAN_SEGMENT_START_DATESVO(); //
     * trspayplanSegment1.setSTART_DATE(DateUtil.createDate(2008, 1, 15)); //
     * trspayplanSegment.add(trspayplanSegment1); // //
     * TRSPAYPLAN_SEGMENT_START_DATESVO trspayplanSegment2 = new //
     * TRSPAYPLAN_SEGMENT_START_DATESVO(); //
     * trspayplanSegment2.setSTART_DATE(DateUtil.createDate(2008, 4, 15)); //
     * trspayplanSegment.add(trspayplanSegment2); // //
     * TRSPAYPLAN_SEGMENT_START_DATESVO trspayplanSegment3 = new //
     * TRSPAYPLAN_SEGMENT_START_DATESVO(); //
     * trspayplanSegment3.setSTART_DATE(DateUtil.createDate(2008, 11, 15)); //
     * trspayplanSegment.add(trspayplanSegment3); // //
     * TRSPAYPLAN_SEGMENT_START_DATESVO trspayplanSegment4 = new //
     * TRSPAYPLAN_SEGMENT_START_DATESVO(); //
     * trspayplanSegment4.setSTART_DATE(DateUtil.createDate(2009, 6, 15)); //
     * trspayplanSegment.add(trspayplanSegment4);
     * 
     * String equalSegments = ConstantsCommon.NO;
     * islamicCalculatorCO.setEqualSegments(equalSegments);
     * 
     * // List<TRSPAYPLAN_CRITERIAVO> criteriavosList = new
     * ArrayList<TRSPAYPLAN_CRITERIAVO>(); // // TRSPAYPLAN_CRITERIAVO
     * criteriavos1 = new TRSPAYPLAN_CRITERIAVO(); //
     * criteriavos1.setFROM_DATE(DateUtil.createDate(2008, 01, 15)); //
     * criteriavos1.setTO_DATE(DateUtil.createDate(2009, 01, 15)); //
     * criteriavos1.setPAYMENT_TYPE("B"); // criteriavos1.setCAPITAL_AMT(new
     * BigDecimal(0)); // criteriavos1.setPAYM_PERIODICITY("M"); //
     * criteriavos1.setPAYM_PERIOD_NBR(BigDecimal.valueOf(1)); //
     * criteriavos1.setPAYM_PERIOD_POS("M"); // criteriavos1.setPAYM_DAY(12); //
     * criteriavos1.setNO_OF_PAYMENTS(BigDecimal.valueOf(30)); //
     * criteriavosList.add(criteriavos1); // // TRSPAYPLAN_CRITERIAVO
     * criteriavos2 = new TRSPAYPLAN_CRITERIAVO(); //
     * criteriavos2.setFROM_DATE(DateUtil.createDate(2008, 3, 15)); //
     * criteriavos2.setTO_DATE(DateUtil.createDate(2009, 01, 15)); //
     * criteriavos2.setPAYMENT_TYPE("C"); // criteriavos2.setCAPITAL_AMT(new
     * BigDecimal(0)); // criteriavos2.setPAYM_PERIODICITY("M"); //
     * criteriavos2.setPAYM_PERIOD_NBR(BigDecimal.valueOf(3)); //
     * criteriavos2.setPAYM_PERIOD_POS("M"); // // // //
     * criteriavos1.setPAYM_DAY(12); // criteriavos2.setNO_OF_PAYMENTS(new
     * BigDecimal(15)); // criteriavosList.add(criteriavos2); //
     * islamicCalculatorCO.setTrsPayPlanCriteriaVO(criteriavosList);
     * 
     * 
     * // TRSPAYPLAN_CRITERIAVO criteriavos3 = new TRSPAYPLAN_CRITERIAVO(); //
     * criteriavos3.setFROM_DATE(DateUtil.createDate(2008, 5, 1)); //
     * criteriavos3.setTO_DATE(DateUtil.createDate(2010, 01, 01)); //
     * criteriavos3.setPAYMENT_TYPE("C"); // criteriavos3.setCAPITAL_AMT(new
     * BigDecimal(0)); // criteriavos3.setPAYM_PERIODICITY("M"); //
     * criteriavos3.setPAYM_PERIOD_NBR(BigDecimal.valueOf(4)); //
     * criteriavos3.setPAYM_PERIOD_POS("S"); //criteriavos1.setPAYM_DAY(12); //
     * criteriavos3.setNO_OF_PAYMENTS(BigDecimal.valueOf(15)); //
     * criteriavosList.add(criteriavos3); // //
     * islamicCalculatorCO.setTrsPayPlanCriteriaVO(criteriavosList);
     * 
     * 
     * // List<TRSDEAL3VO> trsDeal3 = new ArrayList<TRSDEAL3VO>(); TRSDEAL3VO //
     * trsDeal3a = new TRSDEAL3VO(); //
     * trsDeal3a.setVALUE_DATE(DateUtil.createDate(2008, 01, 15)); //
     * trsDeal3a.setAMOUNT(BigDecimal.valueOf(500000) ); //
     * trsDeal3a.setPAID_IND(ConstantsCommon.NO); trsDeal3.add(trsDeal3a); // //
     * TRSDEAL3VO trsDeal3b = new TRSDEAL3VO(); //
     * trsDeal3b.setVALUE_DATE(DateUtil.createDate(2008, 05, 25)); //
     * trsDeal3b.setAMOUNT(BigDecimal.valueOf(200000) ); //
     * trsDeal3b.setPAID_IND(ConstantsCommon.NO); trsDeal3.add(trsDeal3b); // //
     * TRSDEAL3VO trsDeal3c = new TRSDEAL3VO(); //
     * trsDeal3c.setVALUE_DATE(DateUtil.createDate(2009, 02, 01)); //
     * trsDeal3c.setAMOUNT(BigDecimal.valueOf(300000) ); //
     * trsDeal3c.setPAID_IND(ConstantsCommon.NO); trsDeal3.add(trsDeal3c); // //
     * islamicCalculatorCO.setTrsDealMultipleDisbursementList(trsDeal3);
     * 
     * // List<TRSDEAL_MULTIPLE_YIELDVO> multipleYIELDVOs = new
     * ArrayList<TRSDEAL_MULTIPLE_YIELDVO>(); // TRSDEAL_MULTIPLE_YIELDVO
     * multipleYIELDVOs1 = new TRSDEAL_MULTIPLE_YIELDVO(); //
     * multipleYIELDVOs1.setFROM_DATE(DateUtil.createDate(2008, 01, 15)); //
     * multipleYIELDVOs1.setYIELD(BigDecimal.valueOf(12)); //
     * islamicCalculatorCO.getTrsDealMultipleYieldVO().add(multipleYIELDVOs1);
     * // // TRSDEAL_MULTIPLE_YIELDVO multipleYIELDVOs2 = new
     * TRSDEAL_MULTIPLE_YIELDVO(); //
     * multipleYIELDVOs2.setFROM_DATE(DateUtil.createDate(2008, 05, 10)); //
     * multipleYIELDVOs2.setYIELD(BigDecimal.valueOf(8)); //
     * islamicCalculatorCO.getTrsDealMultipleYieldVO().add(multipleYIELDVOs2);
     * // // TRSDEAL_MULTIPLE_YIELDVO multipleYIELDVOs3 = new
     * TRSDEAL_MULTIPLE_YIELDVO(); //
     * multipleYIELDVOs3.setFROM_DATE(DateUtil.createDate(2009, 01, 15)); //
     * multipleYIELDVOs3.setYIELD(BigDecimal.valueOf(10)); //
     * islamicCalculatorCO.getTrsDealMultipleYieldVO().add(multipleYIELDVOs3);
     * 
     * // List<TrsPlanBallonPaymentCO> trsPlanBallonPaymentCO = new //
     * ArrayList<TrsPlanBallonPaymentCO>(); TrsPlanBallonPaymentCO //
     * trsPlanBallonPaymentCO1 = new TrsPlanBallonPaymentCO(); // //
     * TrsPlanBallonPaymentCO trsPlanBallonPaymentCO2 = new
     * TrsPlanBallonPaymentCO(); // trsPlanBallonPaymentCO2.setBallonAmount(new
     * BigDecimal(28000)); //
     * trsPlanBallonPaymentCO2.setBallonDate(DateUtil.createDate(2010, 01,15));
     * // trsPlanBallonPaymentCO.add(trsPlanBallonPaymentCO2); //
     * islamicCalculatorCO.setTrsPlanBallonPaymentCO(trsPlanBallonPaymentCO);
     * 
     * 
     * // Long compoundingProfitPeriodicityNo;
     * 
     * BigDecimal paymentSetDay; BigDecimal dealNo; String
     * IncludeInstallmentDateInProfitCalculation;
     * 
     * String payProfitAndChargesOnly;
     * 
     * Integer changeEffectLineNo;
     * 
     * String profitCalculateAsOnYieldDate; String
     * multipleYieldEqualiseFromValueDate;
     * 
     * String compoundingProfit;
     * 
     * Long holidayAction; }
     */

	private void setDailyDepreciation(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	double totalDepreciationAmount = 0d;
	double totalAccrualAmount = 0d;
	totalDepreciationAmount = NumberUtil.round(
		islamicCalculatorCO.getDealAmount().doubleValue() - islamicCalculatorCO.getTrspayplandetVOList()
			.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getAMOUNT().doubleValue(),
		islamicCalculatorCO.getDealCyDecimalPoint());
	Date dateFrom = islamicCalculatorCO.getValueDate();
	Date dateTo = islamicCalculatorCO.getTrspayplandetVOList()
		.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getVALUE_DATE();
	long totalDays = DateUtil.numberOfDays(dateFrom, dateTo);
	totalAccrualAmount = getTotalFromTrspayplanList(islamicCalculatorCO, "AMOUNT");
	totalAccrualAmount = NumberUtil.round(
		totalAccrualAmount - islamicCalculatorCO.getTrspayplandetVOList()
			.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getAMOUNT().doubleValue(),
		islamicCalculatorCO.getDealCyDecimalPoint());
	double dailyDepreciationAmount = NumberUtil.round((totalDepreciationAmount / totalDays),
		islamicCalculatorCO.getDealCyDecimalPoint());
	double dailyAccrual = NumberUtil.round((totalAccrualAmount / totalDays),
		islamicCalculatorCO.getDealCyDecimalPoint());
	islamicCalculatorCO.setDailyAccrualOld(BigDecimal.valueOf(dailyAccrual));
	islamicCalculatorCO.setDailyDepreciationOld(BigDecimal.valueOf(dailyDepreciationAmount));
	islamicCalculatorCO.setTotalDepreciationOld(BigDecimal.valueOf(totalDepreciationAmount));

	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    double depreciationAmount = 0d;
	    double accrualAmount = 0d;
	    dateTo = islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE();
	    long days = DateUtil.numberOfDays(dateFrom, dateTo);
	    if(i == islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
	    {
		depreciationAmount = totalDepreciationAmount - (dailyDepreciationAmount * (totalDays - days));
		accrualAmount = totalAccrualAmount - (dailyAccrual * (totalDays - days));
	    }
	    else
	    {
		depreciationAmount = dailyDepreciationAmount * days;
		accrualAmount = dailyAccrual * days;
	    }

	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setDEPRECIATION_AMT(
		    NumberUtil.roundToBigDecimal(depreciationAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setACCRUAL_AMT(
		    NumberUtil.roundToBigDecimal(accrualAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    dateFrom = dateTo;
	}
    }
    
    private Double getTotalFromTrspayplanList(IslamicCalculatorCO islamicCalculatorCO, String columnName)
    {
	double totalAmount = 0d;
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if(COLUMNNAME_AMOUNT.equals(columnName))
	    {
		totalAmount = totalAmount
			+ islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT().doubleValue();

	    }
	}
	return NumberUtil.round(totalAmount, islamicCalculatorCO.getDealCyDecimalPoint());
    }

    /**
     * calculate and set the installment details
     * 
     * @param islamicCalculatorCO
     * @return
     * @throws BaseException
     */
     private IslamicCalculatorCO setPlanInstallmentDetails(IslamicCalculatorCO islamicCalculatorCOParam)
	    throws BaseException
    {
	IslamicCalculatorCO islamicCalculatorCO = islamicCalculatorCOParam;

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	{
	    islamicCalculatorCO = calculateBillsPlanSchedule(islamicCalculatorCO);
	    distributeCharges(islamicCalculatorCO);
	    reCalculateBillsCalculatorChargeDetails(islamicCalculatorCO);

	    return islamicCalculatorCO;
	}

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getPayProfitAndChargesOnly()))
	{
	    // in this case Vat amount will be calculated after plan created
	    islamicCalculatorCO.setCalculateVatAfterSchedule(ConstantsCommon.YES);
	    setPlanInstallmentDetailsForProfitAndChargesOnly(islamicCalculatorCO);
	    return islamicCalculatorCO;
	}
	/**
	 * For Musawamah Product
	 */
	String musawamah_yn = ConstantsCommon.NO;
	BigDecimal ldec_min_yield = islamicCalculatorCO.getSysYield();
	BigDecimal ldec_max_yield = islamicCalculatorCO.getSysYield();
	BigDecimal ldec_sys_yield = islamicCalculatorCO.getSysYield();
	BigDecimal ldec_previous_yield = islamicCalculatorCO.getSysYield();
	BigDecimal ldec_Increment_Profit_By = BigDecimal.ZERO;

	boolean lb_First_Time = true;
	boolean lb_Approx_Yield_Not_Calculated = true;
	boolean lb_Increase_Profit = false;
	boolean lb_Start_Profit_Averaging = false;
	boolean lb_finalAdjustment = false;
	BigDecimal previousDiff = BigDecimal.ZERO;
	BigDecimal previousProfitRate = ldec_sys_yield;

	//928504 MFI190194  deepu 13/01/2020
	islamicCalculatorCO.setApplyAprRateYn(ConstantsCommon.NO);
	if(islamicCalculatorCO.getAnnualYield().compareTo(BigDecimal.ZERO)==1 
			&&  "S".equals(islamicCalculatorCO.getProfitCalculationMethod()) 
			&&	"R".equals(islamicCalculatorCO.getProfitRecognitionMethod())  
			&&islamicCalculatorCO.getTrsDealMultipleYieldVO().size() == 0
			&& islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() == 0 
			&& islamicCalculatorCO.getDisbursementScreen() == false ) 
		{
				islamicCalculatorCO.setApplyAprRateYn( ConstantsCommon.YES); 
				Date periodFrom = islamicCalculatorCO.getInstallmentCommentsDate();
				double straightLineProfit = 0D;
				
				 straightLineProfit =  getProfitAmount(islamicCalculatorCO, periodFrom,
							islamicCalculatorCO.getMaturityDate(),
							NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
								+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
								+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
								+ NumberUtil
									.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit()),
							0L,
							(NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
								- NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges()))
								+ (NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
									- NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance())),
							NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), 0, ConstantsCommon.NO);
				 
				 straightLineProfit = NumberUtil.round(straightLineProfit, islamicCalculatorCO.getDealCyDecimalPoint());
				 if( !((islamicCalculatorCO.getTrsPayPlanCriteriaVO() != null && !islamicCalculatorCO.getTrsPayPlanCriteriaVO().isEmpty())
							|| NumberUtil.nullToZero(islamicCalculatorCO.getTemplateCode()).compareTo(BigDecimal.ZERO) == 1))
				{
					islamicCalculatorCO = calculatePlanInstallmentDetails(islamicCalculatorCO,
						    islamicCalculatorCO.getChangeEffectLineNo());
					 
					if(islamicCalculatorCO.getTrspayplandetVOList() != null && islamicCalculatorCO.getTrspayplandetVOList().size() > 1)
					{
						islamicCalculatorCO.setAmountPerPayment(islamicCalculatorCO.getTrspayplandetVOList().get(1).getAMOUNT());
						for(TrspayplandetCO trspayplandetCO :islamicCalculatorCO.getTrspayplandetVOList())
						{
							trspayplandetCO.setUSER_DEFINED_AMOUNT(trspayplandetCO.getAMOUNT());
							trspayplandetCO.setUserDefined(ConstantsCommon.YES);
						}
					}
				}
				 
				islamicCalculatorCO.setProfitCollected( NumberUtil.roundToBigDecimal(straightLineProfit, islamicCalculatorCO.getDealCyDecimalPoint())); 
				
				islamicCalculatorCO.setProfitCalculationMethod("R");
				islamicCalculatorCO.setOutAnnualFlatRate(islamicCalculatorCO.getAnnualYeild());
		}
	
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getMusawamah_yn())
		|| NumberUtil.nullToZero(islamicCalculatorCO.getProfitCollected()).compareTo(BigDecimal.ZERO) == 1)
	{
	    musawamah_yn = ConstantsCommon.YES;
	    if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		    .equals(islamicCalculatorCO.getProfitCalculationMethod()))
	    {
		islamicCalculatorCO.setCalc_max_user_pft_sys_pft_diff(BigDecimal.ZERO);
		islamicCalculatorCO.setCalc_max_iter_getyield_frm_pft(BigDecimal.ONE);
		BigDecimal annualYield = getAnnualYieldMusawamah(islamicCalculatorCO);
		islamicCalculatorCO.setAnnualYield(NumberUtil.roundToBigDecimal(annualYield, 8));
	    }
	    else
	    {
		islamicCalculatorCO.setCalc_max_user_pft_sys_pft_diff(
			NumberUtil.nullToZero(islamicCalculatorCO.getCalc_max_user_pft_sys_pft_diff()));
		if(NumberUtil.nullToZero(islamicCalculatorCO.getCalc_max_iter_getyield_frm_pft())
			.compareTo(BigDecimal.ZERO) != 1)
		{
		    islamicCalculatorCO.setCalc_max_iter_getyield_frm_pft(BigDecimal.ONE);
		}

		/**
		 * calculate the annual Yield
		 */
		//928504 MFI190194  deepu 13/01/2020
		if(  ConstantsCommon.YES.equals(islamicCalculatorCO.getApplyAprRateYn()) ) 
		{
			islamicCalculatorCO.setSysYield(islamicCalculatorCO.getAnnualYield());
			islamicCalculatorCO.setCalc_max_iter_getyield_frm_pft(BigDecimal.valueOf(60));
			ldec_min_yield = islamicCalculatorCO.getAnnualYield();
			ldec_max_yield = islamicCalculatorCO.getAnnualYield();
			ldec_sys_yield = islamicCalculatorCO.getAnnualYield();
			ldec_previous_yield = islamicCalculatorCO.getAnnualYield();
		}
		else 
		{
			islamicCalculatorCO.setAnnualYield(islamicCalculatorCO.getSysYield());
		}
	    }
	}
	else
	{
	    islamicCalculatorCO.setCalc_max_user_pft_sys_pft_diff(BigDecimal.ZERO);
	    islamicCalculatorCO.setCalc_max_iter_getyield_frm_pft(BigDecimal.ONE);
	}

	for(int i = 1; i <= islamicCalculatorCO.getCalc_max_iter_getyield_frm_pft().intValue(); i++)
	{
	    islamicCalculatorCO = calculatePlanInstallmentDetails(islamicCalculatorCO,
		    islamicCalculatorCO.getChangeEffectLineNo());

	    if(lb_finalAdjustment)
	    {
		break;
	    }
	    // BB160136; Manoj MV; 22/01/2018 [Begin]
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getFlexiPaymentYn()) && i == 1)
	    {
		islamicCalculatorCO.setProfitCollected(BigDecimal.valueOf(getTotalProfit(islamicCalculatorCO)));
		if(NumberUtil.emptyDecimalToZero(islamicCalculatorCO.getFlexiPaymentsMonth())
			.compareTo(BigDecimal.ZERO) == 0)
		{
		    throw new BOException(MessageCodes.FLEXI_PAYMENTS_MONTH_NOT_DEFINED);
		}
		int lastLineNo = islamicCalculatorCO.getTrspayplandetVOList().size() - 1;
		boolean flexiPaymentsOnly = true;
		for(int currentLineNo = 0; currentLineNo < islamicCalculatorCO.getTrspayplandetVOList()
			.size(); currentLineNo++)
		{
		    Date currentLineValueDate = islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo)
			    .getVALUE_DATE();
		    if(BigDecimal.valueOf(DateUtil.getDatePart("MM", currentLineValueDate))
			    .compareTo(islamicCalculatorCO.getFlexiPaymentsMonth()) == 0)
		    {
			if(lastLineNo == currentLineNo)
			{
			    islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo - 1)
				    .setVALUE_DATE(currentLineValueDate);
			    islamicCalculatorCO.getTrspayplandetVOList().remove(currentLineNo);
			    islamicCalculatorCO
				    .setNoOfPayments(islamicCalculatorCO.getNoOfPayments().subtract(BigDecimal.ONE));
			}
			else
			{
			    // islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo).setAMOUNT(BigDecimal.ZERO);
			    // islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo)
			    // .setCAPITAL_AMT(islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo)
			    // .getPROFIT_AMT().multiply(BigDecimal.valueOf(-1)));
			    // islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo).setCAPITAL_AMT_BEFORE_XIRR(
			    // islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo)
			    // .getPROFIT_AMT_BEFORE_XIRR().multiply(BigDecimal.valueOf(-1)));

			    // islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo).setCAPITAL_AMT(trsPayPlanCriteriaVO.getCAPITAL_AMT());
			    // islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo)
			    // .setPRINCIPLE_AMT(islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo)
			    // .getPROFIT_AMT().multiply(BigDecimal.valueOf(-1)));
			    // islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo)
			    // .setUSER_DEFINED_AMOUNT(islamicCalculatorCO.getTrspayplandetVOList()
			    // .get(currentLineNo).getPROFIT_AMT().multiply(BigDecimal.valueOf(-1)));
			    islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo)
				    .setFlexiPaymentYN(ConstantsCommon.YES);
			}
		    }
		    else
		    {
			flexiPaymentsOnly = false;
		    }

		}
		if(flexiPaymentsOnly)
		{
		    throw new BOException(MessageCodes.ALL_INSTALLMENTS_ARE_FLEXI_PAYMENTS);
		}
		musawamah_yn = ConstantsCommon.YES;
		islamicCalculatorCO.setCalc_max_user_pft_sys_pft_diff(BigDecimal.ZERO);
		islamicCalculatorCO.setCalc_max_iter_getyield_frm_pft(BigDecimal.TEN);
		islamicCalculatorCO.setSysYield(islamicCalculatorCO.getAnnualYield());
		ldec_sys_yield = islamicCalculatorCO.getAnnualYield();

		previousDiff = islamicCalculatorCO.getProfitCollected();
		previousProfitRate = islamicCalculatorCO.getAnnualYield();
	    }
	    // BB160136; Manoj MV; 22/01/2018 [End]
	    if(ConstantsCommon.YES.equals(musawamah_yn))
	    {
		BigDecimal ldec_profit_amt = BigDecimal.valueOf(getTotalProfit(islamicCalculatorCO));
		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getFlexiPaymentYn()) && i == 1)
		{
		    ldec_profit_amt = BigDecimal.ZERO;
		}
		if(islamicCalculatorCO.getCalc_max_iter_getyield_frm_pft().compareTo(BigDecimal.valueOf(i)) == 0
			&& ldec_profit_amt.compareTo(islamicCalculatorCO.getProfitCollected()) != 0)
		{
		    BigDecimal diff = islamicCalculatorCO.getProfitCollected().subtract(ldec_profit_amt);
		    int lastLine = islamicCalculatorCO.getTrspayplandetVOList().size() - 1;
		    BigDecimal profit = islamicCalculatorCO.getTrspayplandetVOList().get(lastLine).getPROFIT_AMT();
		    BigDecimal capital = islamicCalculatorCO.getTrspayplandetVOList().get(lastLine).getCAPITAL_AMT();
		    profit = profit.add(diff);
		    islamicCalculatorCO.getTrspayplandetVOList().get(lastLine).setPROFIT_AMT(profit);
		    islamicCalculatorCO.getTrspayplandetVOList().get(lastLine).setPROFIT_AMT_BEFORE_XIRR(profit);
		    islamicCalculatorCO.getTrspayplandetVOList().get(lastLine).setAMOUNT(profit.add(capital));

		    // if("S".equals(islamicCalculatorCO.getProfitCalculationMethod()))
		    // {
		    break;
		    // }
		}

		if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			.equals(islamicCalculatorCO.getProfitCalculationMethod()))
		{
		    break;
		}

		BigDecimal ldec_user_profit_amt = NumberUtil.nullToZero(islamicCalculatorCO.getProfitCollected());
		BigDecimal diff = ldec_user_profit_amt.subtract(ldec_profit_amt);

		if(diff.abs().compareTo(islamicCalculatorCO.getCalc_max_user_pft_sys_pft_diff()) == 1)
		{
		    if(previousDiff.abs().compareTo(diff.abs()) != 1 && i > 10)
		    {
			islamicCalculatorCO.setSysYield(previousProfitRate);
			islamicCalculatorCO.setAnnualYield(previousProfitRate);
			ldec_sys_yield = previousProfitRate;
			lb_finalAdjustment = true;
		    }
		    else
		    {

			if(diff.compareTo(BigDecimal.ZERO) == 1)
			{
			    ldec_min_yield = islamicCalculatorCO.getSysYield();
			}
			else
			{
			    ldec_max_yield = islamicCalculatorCO.getSysYield();
			}

			if(lb_First_Time)
			{
			    if(lb_Approx_Yield_Not_Calculated)
			    {
				lb_Approx_Yield_Not_Calculated = false;
				if(ldec_profit_amt.compareTo(BigDecimal.ZERO) == 1)
				{
				    ldec_sys_yield = ldec_sys_yield.multiply(ldec_user_profit_amt)
					    .divide(ldec_profit_amt, 12, BigDecimal.ROUND_HALF_UP);
				}
				ldec_previous_yield = ldec_sys_yield;

			    }
			    else
			    {
				lb_First_Time = false;
				ldec_Increment_Profit_By = BigDecimal.valueOf(0.1);
				if(diff.compareTo(BigDecimal.ZERO) == 1)
				{
				    lb_Increase_Profit = true;
				    ldec_sys_yield = ldec_sys_yield.add(ldec_Increment_Profit_By);

				}
				else
				{
				    lb_Increase_Profit = false;
				    ldec_sys_yield = ldec_sys_yield.subtract(ldec_Increment_Profit_By);
				}
			    }

			}
			else
			{
			    if(!lb_Start_Profit_Averaging)
			    {
				if(diff.compareTo(BigDecimal.ZERO) == 1)
				{
				    if(!lb_Increase_Profit)
				    {
					lb_Start_Profit_Averaging = true;
				    }
				}
				else
				{
				    if(lb_Increase_Profit)
				    {
					lb_Start_Profit_Averaging = true;
				    }
				}
			    }

			    if(lb_Start_Profit_Averaging)
			    {
				ldec_sys_yield = (ldec_min_yield.add(ldec_max_yield)).divide(BigDecimal.valueOf(2));
			    }
			    else
			    {
				if(diff.compareTo(BigDecimal.ZERO) == 1)
				{
				    if(!lb_Increase_Profit)
				    {
					ldec_Increment_Profit_By = ldec_Increment_Profit_By.divide(BigDecimal.TEN);
				    }
				    ldec_previous_yield = ldec_sys_yield;
				    lb_Increase_Profit = true;
				    ldec_sys_yield = ldec_sys_yield.add(ldec_Increment_Profit_By);
				}
				else
				{
				    if(lb_Increase_Profit)
				    {
					ldec_Increment_Profit_By = ldec_Increment_Profit_By.divide(BigDecimal.TEN);
					ldec_sys_yield = ldec_previous_yield;
					lb_Increase_Profit = true;
					ldec_sys_yield = ldec_sys_yield.add(ldec_Increment_Profit_By);
				    }
				    else
				    {
					ldec_previous_yield = ldec_sys_yield;
					lb_Increase_Profit = false;
					ldec_sys_yield = ldec_sys_yield.subtract(ldec_Increment_Profit_By);
				    }
				}
			    }

			}
		    }
		    previousDiff = diff;
		    previousProfitRate = islamicCalculatorCO.getAnnualYield();

		    islamicCalculatorCO.setSysYield(ldec_sys_yield);
		    islamicCalculatorCO.setAnnualYield(islamicCalculatorCO.getSysYield());
		    islamicCalculatorCO.getAnnualYield();
		    //928504 MFI190194  deepu 13/01/2020
		    islamicCalculatorCO.setAprRate(NumberUtil.roundToBigDecimal( islamicCalculatorCO.getAnnualYield(),12));
		}
		else
		{
		    break;
		}

	    }
	}
	
	//928504 MFI190194  deepu 13/01/2020
	if(  ConstantsCommon.YES.equals(islamicCalculatorCO.getApplyAprRateYn())) {
		  islamicCalculatorCO.setProfitCalculationMethod("S");
	}
	
	adjustUserProfit(islamicCalculatorCO);

	distributeCharges(islamicCalculatorCO);

	/*
	 * if the below flag is ConstantsCommon.NO no need to push down the
	 * excess profit to next installment. calculate all the values
	 * installment by pushing down the excess profit to next installment and
	 * finally just remove the profit adjustment and installment and
	 * principal amount will be same
	 */
	if(ConstantsCommon.NO.equals(islamicCalculatorCO.getExcessProfitInNextInstallment()))
	{
	    reSetExcessProfitInNextInstallment(islamicCalculatorCO);
	}

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getOutstandingPrincipalAsInstallment()))
	{
	    setOutstandingPrincipalInstallmentDate(islamicCalculatorCO);
	}
	return islamicCalculatorCO;
    }

    private void adjustUserProfit(IslamicCalculatorCO islamicCalculatorCO) throws BOException
    {
	if(NumberUtil.nullToZero(islamicCalculatorCO.getProfitCollected()).compareTo(BigDecimal.ZERO) != 1)
	{
	    return;
	}
	BigDecimal ldec_profit_amt = BigDecimal.valueOf(getTotalProfit(islamicCalculatorCO));

	BigDecimal diff = islamicCalculatorCO.getProfitCollected().subtract(ldec_profit_amt);

	int noOfPlanDet = islamicCalculatorCO.getTrspayplandetVOList().size() - 1;

	if(diff.compareTo(BigDecimal.ZERO) == 0)
	{
	    BigDecimal profitTemp = NumberUtil
		    .nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(noOfPlanDet).getPROFIT_AMT());
	    islamicCalculatorCO.getTrspayplandetVOList().get(noOfPlanDet).setPROFIT_AMT(profitTemp.add(diff));

	    profitTemp = NumberUtil.nullToZero(
		    islamicCalculatorCO.getTrspayplandetVOList().get(noOfPlanDet).getPROFIT_AMT_BEFORE_XIRR());
	    islamicCalculatorCO.getTrspayplandetVOList().get(noOfPlanDet)
		    .setPROFIT_AMT_BEFORE_XIRR(profitTemp.add(diff));

	    profitTemp = NumberUtil.nullToZero(
		    islamicCalculatorCO.getTrspayplandetVOList().get(noOfPlanDet).getACTUAL_PROFIT_AMT_BEFORE_XIRR());
	    islamicCalculatorCO.getTrspayplandetVOList().get(noOfPlanDet)
		    .setACTUAL_PROFIT_AMT_BEFORE_XIRR(profitTemp.add(diff));

	    profitTemp = NumberUtil
		    .nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(noOfPlanDet).getACTUAL_PROFIT_AMT());
	    islamicCalculatorCO.getTrspayplandetVOList().get(noOfPlanDet).setACTUAL_PROFIT_AMT(profitTemp.add(diff));

	    BigDecimal installmentTemp = NumberUtil
		    .nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(noOfPlanDet).getAMOUNT());
	    islamicCalculatorCO.getTrspayplandetVOList().get(noOfPlanDet).setAMOUNT(installmentTemp.add(diff));
	    return;
	}

	diff = diff.abs();

	for(int i = noOfPlanDet; i >= 0; i--)
	{
	    if(diff.compareTo(BigDecimal.ZERO) == 0)
	    {
		break;
	    }
	    BigDecimal installmentTemp = NumberUtil
		    .nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT());
	    if(installmentTemp.compareTo(BigDecimal.ZERO) == 1)
	    {

		BigDecimal diffTemp = diff;
		BigDecimal profitTemp = NumberUtil
			.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT());
		if(profitTemp.compareTo(diff) != -1)
		{
		    diffTemp = diff;
		    diff = BigDecimal.ZERO;
		}
		else
		{
		    diffTemp = profitTemp;
		    diff = diff.subtract(diffTemp);
		}

		islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT(profitTemp.subtract(diffTemp));

		profitTemp = NumberUtil
			.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT_BEFORE_XIRR());
		islamicCalculatorCO.getTrspayplandetVOList().get(i)
			.setPROFIT_AMT_BEFORE_XIRR(profitTemp.subtract(diffTemp));

		profitTemp = NumberUtil.nullToZero(
			islamicCalculatorCO.getTrspayplandetVOList().get(i).getACTUAL_PROFIT_AMT_BEFORE_XIRR());
		islamicCalculatorCO.getTrspayplandetVOList().get(i)
			.setACTUAL_PROFIT_AMT_BEFORE_XIRR(profitTemp.subtract(diffTemp));

		profitTemp = NumberUtil
			.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getACTUAL_PROFIT_AMT());
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setACTUAL_PROFIT_AMT(profitTemp.subtract(diffTemp));

		islamicCalculatorCO.getTrspayplandetVOList().get(i).setAMOUNT(installmentTemp.subtract(diffTemp));
	    }
	}

    }

    private void reCalculateBillsCalculatorChargeDetails(IslamicCalculatorCO islamicCalculatorCO)
	    throws BaseException, DAOException
    {
	Date ldt_value_date;
	if(islamicCalculatorCO.getTrsdealchargesVO() != null && !islamicCalculatorCO.getTrsdealchargesVO().isEmpty()
		&& !islamicCalculatorCO.getTrspayplandetVOList().isEmpty())
	{
	    for(TrsDealChargesCO trsdealchargesvo : islamicCalculatorCO.getTrsdealchargesVO())
	    {

		if((ConstantsCommon.YES.equals(trsdealchargesvo.getCHARGE_TYPE()))
			&& trsdealchargesvo.getAMOUNT_CALCULATION_BASIS() != null
			&& !("P".equals(trsdealchargesvo.getAMOUNT_CALCULATION_BASIS())
				|| ConstantsCommon.NO.equals(trsdealchargesvo.getCHARGES_CALCULATION_METHOD())))
		{
		    BigDecimal billAmount = NumberUtil.nullToZero(islamicCalculatorCO.getBillAmount());
		    BigDecimal charges_percentage = NumberUtil.nullToZero(trsdealchargesvo.getCHARGES_PERCENTAGE());
		    BigDecimal periodical_number = NumberUtil.nullEmptyToValue(trsdealchargesvo.getPERIODICAL_NUMBER(),
			    BigDecimal.ONE);
		    if("P".equals(trsdealchargesvo.getPERIODICAL_BASIS()))
		    {
			ldt_value_date = islamicCalculatorCO.getValueDate();
		    }
		    else
		    {
			ldt_value_date = DateUtil.createDate(
				DateUtil.getDayYearMonth(islamicCalculatorCO.getValueDate(), DateUtil.YEAR), 12,
				DateUtil.getDayYearMonth(islamicCalculatorCO.getValueDate(), DateUtil.DAY_OF_MONTH));
		    }
		    Date ldt_next_date = returnNextDate(islamicCalculatorCO, ldt_value_date, periodical_number);

		    BigDecimal totalChargesAmount = BigDecimal.ZERO;
		    BigDecimal totalInsurancesAmount = BigDecimal.ZERO;

		    TRSCHARGESVOKey trschargesVoKey = new TRSCHARGESVOKey();
		    trschargesVoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
		    trschargesVoKey.setCODE(trsdealchargesvo.getCHARGES_CODE());
		    String insuranceYn = ConstantsCommon.NO;
		    TRSCHARGESVO trschargesVo = iisIslamicCalculatorDAO.getDealChargesInsuranceYn(trschargesVoKey);
		    trschargesVoKey = null;
		    insuranceYn = trschargesVo.getINSURANCE();
		    BigDecimal ll_Times = BigDecimal.ONE;
		    BigDecimal lv_charges_amount = BigDecimal.ZERO;
		    BigDecimal lv_insurance_amount = BigDecimal.ZERO;
		    for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
		    {
			ldt_value_date = islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE();
			if(!ldt_value_date.after(ldt_next_date))
			{
			    lv_charges_amount = billAmount.multiply(charges_percentage)
				    .divide(BigDecimal.valueOf(100), 12, BigDecimal.ROUND_HALF_UP).multiply(ll_Times);
			    lv_charges_amount = NumberUtil.roundToBigDecimal(lv_charges_amount,
				    islamicCalculatorCO.getDealCyDecimalPoint().intValue());

			    if(ConstantsCommon.YES.equals(insuranceYn))
			    {
				lv_insurance_amount = lv_charges_amount;
				lv_charges_amount = BigDecimal.ZERO;
			    }
			    else
			    {
				lv_insurance_amount = BigDecimal.ZERO;
			    }
			    islamicCalculatorCO.getTrspayplandetVOList().get(i).setCHARGE_AMOUNT(islamicCalculatorCO
				    .getTrspayplandetVOList().get(i).getCHARGE_AMOUNT().add(lv_charges_amount));
			    islamicCalculatorCO.getTrspayplandetVOList().get(i).setINSURANCE_AMOUNT(islamicCalculatorCO
				    .getTrspayplandetVOList().get(i).getINSURANCE_AMOUNT().add(lv_insurance_amount));
			    totalChargesAmount = totalChargesAmount.add(lv_charges_amount);
			    totalInsurancesAmount = totalInsurancesAmount.add(lv_insurance_amount);

			    islamicCalculatorCO.getTrspayplandetVOList().get(i).setPRINCIPLE_AMT(

				    NumberUtil.roundToBigDecimal(
					    NumberUtil
						    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
							    .getCAPITAL_AMT())
						    - (NumberUtil
							    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
								    .get(i).getCHARGE_AMOUNT())
							    + NumberUtil.toDoubleObj(
								    islamicCalculatorCO.getTrspayplandetVOList().get(i)
									    .getINSURANCE_AMOUNT())),
					    islamicCalculatorCO.getDealCyDecimalPoint()));

			    islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT_BEFORE_XIRR(
				    islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT());
			    islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT_BEFORE_XIRR(
				    islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT());

			}

			if(!ldt_value_date.before(ldt_next_date))
			{
			    if(ldt_value_date.after(ldt_next_date))
			    {
				i = i - 1;
			    }
			    ldt_next_date = returnNextDate(islamicCalculatorCO, ldt_next_date, periodical_number);
			    ll_Times = ll_Times.add(BigDecimal.ONE);
			}

		    }
		    trsdealchargesvo.setCHARGES_AMT_FC(totalChargesAmount.add(totalInsurancesAmount));

		    /**
		     * Calculate in deal cy
		     */
		    BigDecimal crossRate = returnCrossRate(islamicCalculatorCO, trsdealchargesvo.getCR_ACC_CURRENCY(),
			    islamicCalculatorCO.getDealCurrency());

		    BigDecimal amountInDealCy = totalChargesAmount.add(totalInsurancesAmount).multiply(crossRate);
		    amountInDealCy = NumberUtil.roundToBigDecimal(amountInDealCy,
			    islamicCalculatorCO.getDealCyDecimalPoint().intValue());
		    trsdealchargesvo.setCHARGES_AMOUNT(amountInDealCy);

		    if(ConstantsCommon.YES.equals(insuranceYn))
		    {
			trsdealchargesvo.setInsuranceAmount(trsdealchargesvo.getCHARGES_AMOUNT());
			trsdealchargesvo.setChargeAmtToInclInPrinciple(BigDecimal.ZERO);
		    }
		    else
		    {
			trsdealchargesvo.setInsuranceAmount(BigDecimal.ZERO);
			trsdealchargesvo.setChargeAmtToInclInPrinciple(trsdealchargesvo.getCHARGES_AMOUNT());
		    }

		    /**
		     * Calculate in base cy
		     */

		    crossRate = returnCrossRate(islamicCalculatorCO, trsdealchargesvo.getCR_ACC_CURRENCY(),
			    islamicCalculatorCO.getBaseCurrencyCode());

		    amountInDealCy = totalChargesAmount.add(totalInsurancesAmount).multiply(crossRate);
		    amountInDealCy = NumberUtil.roundToBigDecimal(amountInDealCy,
			    islamicCalculatorCO.getDealCyDecimalPoint().intValue());
		    trsdealchargesvo.setCHARGES_AMT_CV(amountInDealCy);
		}

	    }
	    for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT();
	    }
	}
    }

    private BigDecimal returnCrossRate(IslamicCalculatorCO islamicCalculatorCO, BigDecimal trxCy, BigDecimal fcCy)
	    throws BaseException
    {
	if(trxCy.compareTo(fcCy) == 0)
	{
	    return BigDecimal.ONE;
	}

	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setCompCode(islamicCalculatorCO.getCompanyCode());
	iisCommonCO.setBaseCurrencyCode(islamicCalculatorCO.getBaseCurrencyCode());
	iisCommonCO.setBranchCode(islamicCalculatorCO.getBranchCode());

	iisCommonCO.setTrCurrency(trxCy);// Transaction

	iisCommonCO.setPfCurrency(fcCy);// Base

	iisCommonCO.setCrossDate(islamicCalculatorCO.getValueDate());
	iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
	if(iisCommonCO.getCrossRate() == null || iisCommonCO.getCrossRate().compareTo(BigDecimal.ZERO) == -1)
	{
	    return BigDecimal.ONE;
	}
	return iisCommonCO.getCrossRate();
    }

    private Date returnNextDate(IslamicCalculatorCO islamicCalculatorCO, Date ldt_value_date,
	    BigDecimal periodical_number) throws BaseException
    {
	int year = DateUtil.getDayYearMonth(ldt_value_date, DateUtil.YEAR);
	int month = DateUtil.getDayYearMonth(DateUtil.relativeMonth(ldt_value_date, periodical_number.intValue()),
		DateUtil.MONTH);
	int day = DateUtil.getDayYearMonth(islamicCalculatorCO.getValueDate(), DateUtil.DAY_OF_MONTH);
	Date ldt_next_date = DateUtil.createDate(year, month, 1);
	Date monthLastDate = DateUtil.getMonthLastDay(ldt_next_date);

	if(day > DateUtil.getDayYearMonth(monthLastDate, DateUtil.DAY_OF_MONTH))
	{
	    ldt_next_date = monthLastDate;
	}
	else
	{
	    ldt_next_date = DateUtil.createDate(year, month, day);
	}
	return ldt_next_date;
    }

    /**
     * to calculate the annual yield for Musawamah product
     * 
     * @param islamicCalculatorCO
     * @return
     * @throws BaseException
     */
     private BigDecimal getAnnualYieldMusawamah(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	BigDecimal annualYield = islamicCalculatorCO.getAnnualYield();

	BigDecimal profitAmt = NumberUtil.nullToZero(islamicCalculatorCO.getProfitCollected());
	BigDecimal amount = NumberUtil.nullToZero(islamicCalculatorCO.getDealAmount())
		.add(NumberUtil.nullToZero(islamicCalculatorCO.getProfitOnCharges()))
		.add(NumberUtil.nullToZero(islamicCalculatorCO.getProfitOnInsurance()));

	if(profitAmt.compareTo(BigDecimal.ZERO) != 1 || amount.compareTo(BigDecimal.ZERO) != 1)
	{
	    return annualYield;
	}

	BigDecimal annualDays = BigDecimal.valueOf(islamicCalculatorCO.getDealCyPtMethod());
	if(islamicCalculatorCO.getProfitAccrualBasis().equals(4L)
		|| islamicCalculatorCO.getProfitAccrualBasis().equals(3L))
	{
	    annualDays = BigDecimal.valueOf(365);
	}
	else if(islamicCalculatorCO.getProfitAccrualBasis().equals(2L)
		|| islamicCalculatorCO.getProfitAccrualBasis().equals(6L))
	{
	    annualDays = BigDecimal.valueOf(360);
	}
	else if(islamicCalculatorCO.getProfitAccrualBasis().equals(5L))
	{
	    annualDays = islamicCalculatorCO.getAvgDaysInYearsForProfitCalculation();
	}

	double monthsDay = iisCommonBO.getMonthsAndDayDifferance(islamicCalculatorCO.getValueDate(),
		islamicCalculatorCO.getMaturityDate());
	long month = (long) monthsDay;
	double days = NumberUtil.round(((monthsDay - month) * 100L), 0L);
	BigDecimal totalDays = BigDecimal.valueOf(days);
	if(islamicCalculatorCO.getProfitAccrualBasis().equals(2L))
	{
	    monthsDay = monthsDay * 30;
	    totalDays = totalDays.add(BigDecimal.valueOf(monthsDay));
	}
	else if(islamicCalculatorCO.getProfitAccrualBasis().equals(2L))
	{
	    monthsDay = monthsDay * 31;
	    totalDays = totalDays.add(BigDecimal.valueOf(monthsDay));
	}
	else
	{
	    totalDays = BigDecimal.valueOf(
		    DateUtil.numberOfDays(islamicCalculatorCO.getValueDate(), islamicCalculatorCO.getMaturityDate()));
	}

	if(totalDays.compareTo(BigDecimal.ZERO) != 1)
	{
	    return annualYield;
	}
	annualYield = profitAmt.divide(amount, 12, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100))
		.divide(totalDays, 12, BigDecimal.ROUND_HALF_UP).multiply(annualDays);
	return annualYield;
    }
    
    private void validationForPrincipalAmount(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	double minBalloonAmt = 0;
	if(islamicCalculatorCO.getTrspayplandetVOList().size() - 2 >= 0)
	{
	    for(int i = islamicCalculatorCO.getTrspayplandetVOList().size() - 2; i < islamicCalculatorCO
		    .getTrspayplandetVOList().size(); i++)
	    {
		if(NumberUtil
			.nullToZero(
				islamicCalculatorCO.getTrspayplandetVOList().get(i).getMONTHLY_COMPOUNDED_PROFIT_AMT())
			.compareTo(BigDecimal.ZERO) != 0
			|| IISCommonConstants.PAYMENT_TYPE_COMPOUND_PROFIT
				.equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE()))
		{
		    continue;
		}
		if(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT().compareTo(BigDecimal.ZERO) == 0
			&& !"M0168".equals(islamicCalculatorCO.getTraceProgRef()))
		{

		    islamicCalculatorCO.setConfirmationMessageId("902397");
		}
	    }
	}
	if(islamicCalculatorCO.getTrsPlanBallonPaymentCO() != null
		&& !islamicCalculatorCO.getTrsPlanBallonPaymentCO().isEmpty())
	{
	    for(int i = 0; i < islamicCalculatorCO.getTrsPlanBallonPaymentCO().size(); i++)
	    {
		if(NumberUtil.toDouble(
			islamicCalculatorCO.getTrsPlanBallonPaymentCO().get(i).getBalloonAmount()) < minBalloonAmt
			|| i == 0)
		{
		    minBalloonAmt = NumberUtil
			    .toDouble(islamicCalculatorCO.getTrsPlanBallonPaymentCO().get(i).getBalloonAmount());
		}
		if(i == islamicCalculatorCO.getTrsPlanBallonPaymentCO().size() - 1)
		{
		    break;
		}
	    }
	}

	BigDecimal totalPlanAmount = BigDecimal.ZERO;
	BigDecimal totalPlanCapital = BigDecimal.ZERO;
	BigDecimal totalPlanProfit = BigDecimal.ZERO;
	BigDecimal totalPlanCharges = BigDecimal.ZERO;
	BigDecimal totalPlanInsurance = BigDecimal.ZERO;
	BigDecimal tempLineNo = BigDecimal.ZERO;
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if(NumberUtil
		    .nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getMONTHLY_COMPOUNDED_PROFIT_AMT())
		    .compareTo(BigDecimal.ZERO) != 0
		    || "D".equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE())
		    || "Z".equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE()))
	    {
		continue;
	    }
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getFlexiPaymentYN()))
	    {
		continue;
	    }
	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT_BEFORE_XIRR_DUMMY(BigDecimal.ZERO);
	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT_DUMMY(BigDecimal.ZERO);
	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setPRINCIPLE_AMT_DUMMY(BigDecimal.ZERO);
	    islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    .setPRINCIPLE_AMT_BEFORE_XIRR(NumberUtil
			    .nullToZero(
				    islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT_BEFORE_XIRR())
			    .subtract(NumberUtil.nullToZero(
				    islamicCalculatorCO.getTrspayplandetVOList().get(i).getCHARGE_AMOUNT())
				    .add(NumberUtil.nullToZero(
						    islamicCalculatorCO.getTrspayplandetVOList().get(i)
						    .getINSURANCE_AMOUNT()))));// 714070-
									       // BBRUP180640

	    totalPlanAmount = totalPlanAmount.add(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT());
	    totalPlanCapital = totalPlanCapital
		    .add(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT());
	    totalPlanProfit = totalPlanProfit.add(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT());

	    totalPlanCharges = totalPlanCharges
		    .add(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCHARGE_AMOUNT());
	    totalPlanInsurance = totalPlanInsurance
		    .add(islamicCalculatorCO.getTrspayplandetVOList().get(i).getINSURANCE_AMOUNT());

	    islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    .setPROFIT_AMT_BEFORE_XIRR_DUMMY(NumberUtil
			    .nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT_BEFORE_XIRR())
			    .add(NumberUtil.nullToZero(
				    islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT_BEFORE_XIRR())));

	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT_DUMMY(NumberUtil
		    .nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT())
		    .add(NumberUtil.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT())));

	    if(!ConstantsCommon.YES.equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getExcludeRescheduleYn() )) 
	    {
	    islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    .setREMAINING_AMOUNT(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT());
	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setSETTLEMENT_AMOUNT(BigDecimal.ZERO);
	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setREIMBURSED_PROFIT(BigDecimal.ZERO);
	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setRESERVE_AMOUNT(BigDecimal.ZERO);
	    }
	    BigDecimal vatPercentage = NumberUtil.nullEmptyToValue(
		    islamicCalculatorCO.getTrspayplandetVOList().get(i).getVAT_PERCENTAGE(), BigDecimal.ZERO);
	    if(vatPercentage.compareTo(BigDecimal.ZERO) == -1)
	    {
		vatPercentage = BigDecimal.ZERO;
	    }

	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setVAT_PERCENTAGE(vatPercentage);
	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setCHEQUE(islamicCalculatorCO.getSettlmentType());

	    // 667706
	    if(i >= islamicCalculatorCO.getTrspayplandetVOList().size() - 2)
	    {
		if(minBalloonAmt > 0
			&& (NumberUtil.toDouble(
				islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT()) > minBalloonAmt)
			&& islamicCalculatorCO.getTrspayplandetVOList().get(i).getBALLOON_PAYMENT()
				.compareTo(BigDecimal.ZERO) == 0)
		{

		    islamicCalculatorCO.setConfirmationMessageId2("902399");
		    // break;
		}
	    }
	    islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    .setDEAL_VALUE_DATE(islamicCalculatorCO.getOriginalValueDate());
	    islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    .setDEAL_AMOUNT(islamicCalculatorCO.getOriginalDealAmount());

	    if("I".equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE()))
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(i)
			.setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT);
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setBALLOON_PAYMENT(BigDecimal.ONE);

	    }
	    if(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT() != null
		    && islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT().compareTo(BigDecimal.ZERO) == 1)
	    {
		tempLineNo = tempLineNo.add(BigDecimal.ONE);
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setTEMP_LINE_NBR(tempLineNo);
	    }
	    
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEXCLUDE_PASTDUE_AT_RESCHDL_YN()))
	    {
	    	if(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT().compareTo(BigDecimal.ZERO) <= 0)
	    	{
	    		throw new BOException(MessageCodes.iis_invalid_code,
	    				new String[] { "Invalid Repayment Plan Profit Amount Cannot be Less than 0" }, false);
	    	}
	    }

	    // 667706
	    if(!islamicCalculatorCO.getCalculatorType().equals(IISCommonConstants.CALCULATOR_TYPE_CALCULATOR))
	    {
		// this message need to show in all the clulaator and repayment
		// plan
		if(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT() != null && islamicCalculatorCO
			.getTrspayplandetVOList().get(i).getAMOUNT().compareTo(BigDecimal.ZERO) <= 0)
		{
		    throw new BOException(
			    MessageCodes.INVALID_REPAYMENT_PLAN_ONE_OR_MORE_OF_THE_INSTALLMENT_AMOUNT_IS_ZERO);
		}
	    }

	    // if
	    // (NumberUtil.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT()).compareTo(BigDecimal.ZERO)
	    // == 1
	    // &&
	    // islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT()
	    // != null
	    // &&
	    // islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT().compareTo(BigDecimal.ZERO)
	    // <= 0)
	    // {
	    // throw new BOException(MessageCodes.iis_invalid_code,
	    // new String[] {
	    // "invalid_repayment_plan_installment_principal_is_zero" }, false);
	    // }

	    if(PAYPLAN_BASED_ON_REDUCE_INSTALLMENT.equals(islamicCalculatorCO.getGenerate_payplan_based_on()))
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setPAYMENT_TYPE("B");
	    }

	    islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    .setVAT_AND_INSTALLMENT_AMOUNT(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT());
	}
	if(totalPlanAmount == null)
	{
	    totalPlanAmount = BigDecimal.ZERO;
	}
	if(totalPlanCapital == null)
	{
	    totalPlanCapital = BigDecimal.ZERO;
	}
	if(totalPlanProfit == null)
	{
	    totalPlanProfit = BigDecimal.ZERO;
	}
	if(totalPlanCharges == null)
	{
	    totalPlanCharges = BigDecimal.ZERO;
	}
	if(totalPlanInsurance == null)
	{
	    totalPlanInsurance = BigDecimal.ZERO;
	}

	BigDecimal totalPlanPrincipal = totalPlanCapital.subtract(totalPlanCharges.add(totalPlanInsurance));

	if(islamicCalculatorCO.getDealAmount().compareTo(totalPlanPrincipal) != 0)
	{
	    islamicCalculatorCO.setDealAmountMachingWithPlanYn(0);
	}

	if((islamicCalculatorCO.getDealAmount()
		.add(islamicCalculatorCO.getTotalCharges().add(islamicCalculatorCO.getTotalCharges())))
			.compareTo(totalPlanCapital) != 0)
	{
	    islamicCalculatorCO.setTotalCapitalMachingWithPlanYn(0);
	}

	if(totalPlanAmount.compareTo(totalPlanCapital.add(totalPlanProfit)) != 0)
	{
	    islamicCalculatorCO.setTotalAmountMachingWithPlanYn(0);
	}

    }

	private void setOutstandingPrincipalInstallmentDate(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	// to set the outstanding principal installment date
	if(islamicCalculatorCO.getOutstandingPrincipalInstallmentDate() == null)
	{
	    // if date is not defined throw the exception
	    throw new BOException(MessageCodes.INVALID_OUTSTDING_PRINCIPAL_AS_INST_DTE);
	}
	// log
	// .error("REPAYMENT PLAN SCHEDULE<MANOJ> :
	// setOutstandingPrincipalInstallmentDate :-
	// getOutstandingPrincipalInstallmentDate = "
	// +
	// islamicCalculatorCO.getOutstandingPrincipalInstallmentDate().toString());
	int outstndPrncInstallmentLineNo = 0;
	boolean recalcProfit = false;
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE()
		    .compareTo(islamicCalculatorCO.getOutstandingPrincipalInstallmentDate()) == 0)
	    {
		/*
		 * if the installment date and outstanding principal installment
		 * date are same date then no need to set it again
		 */
		// log.error("REPAYMENT PLAN SCHEDULE<MANOJ> :
		// setOutstandingPrincipalInstallmentDate :- First condetion");
		outstndPrncInstallmentLineNo = i;
		recalcProfit = false;
		break;
	    }
	    if(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE()
		    .after(islamicCalculatorCO.getOutstandingPrincipalInstallmentDate())
		    && islamicCalculatorCO.getLastInstallmentOnMaturityDate().equals(ConstantsCommon.NO))
	    {
		/*
		 * if the outstanding principal installment date is not an
		 * installment date then set the outstanding principal
		 * installment date as installment date in this case need to
		 * recalculate the profit again
		 */
		// log
		// .error("REPAYMENT PLAN SCHEDULE<MANOJ> :
		// setOutstandingPrincipalInstallmentDate :- Second condetion");

		outstndPrncInstallmentLineNo = i - 1;
		if(outstndPrncInstallmentLineNo < 0)
		{
		    outstndPrncInstallmentLineNo = 0;
		}
		islamicCalculatorCO.getTrspayplandetVOList().get(outstndPrncInstallmentLineNo)
			.setVALUE_DATE(islamicCalculatorCO.getOutstandingPrincipalInstallmentDate());

		// outstndPrncInstallmentLineNo = i;
		recalcProfit = true;
		break;
	    }
	    if(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE()
		    .after(islamicCalculatorCO.getOutstandingPrincipalInstallmentDate())
		    && ConstantsCommon.YES.equals(islamicCalculatorCO.getLastInstallmentOnMaturityDate()))
	    {
		/*
		 * if the outstanding principal installment date is not an
		 * installment date then set the outstanding principal
		 * installment date as installment date in this case need to
		 * recalculate the profit again
		 */
		// log.error("REPAYMENT PLAN SCHEDULE<MANOJ> :
		// setOutstandingPrincipalInstallmentDate :- Third condetion");
		islamicCalculatorCO.getTrspayplandetVOList().get(i)
			.setVALUE_DATE(islamicCalculatorCO.getOutstandingPrincipalInstallmentDate());
		outstndPrncInstallmentLineNo = i;
		recalcProfit = true;
		break;
	    }
	}
	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
	// recalculate the profit of the line 'outstndPrncInstallmentLineNo'
	if(recalcProfit)
	{
	    double chargesExcludingProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
		    - NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges());
	    double insuranceExcludingProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
		    - NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance());

	    double chargesAndInsuranceExcludingProfitCalc = 0d;
	    Date dateFrom = islamicCalculatorCO.getValueDate();
	    double outStandingCapital = 0d;
	    for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	    {
		if(i < outstndPrncInstallmentLineNo)
		{
		    chargesExcludingProfitCalc -= NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCHARGE_AMOUNT())
			    - NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_ON_CHARGES());
		    insuranceExcludingProfitCalc -= NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getINSURANCE_AMOUNT())
			    - NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_ON_INSURANCE());
		    dateFrom = islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE();
		}
		else if(i == outstndPrncInstallmentLineNo)
		{
		    Date dateTo = islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE();
		    chargesAndInsuranceExcludingProfitCalc = (chargesExcludingProfitCalc
			    + insuranceExcludingProfitCalc);
		    chargesAndInsuranceExcludingProfitCalc = NumberUtil.round(chargesAndInsuranceExcludingProfitCalc,
			    islamicCalculatorCO.getDealCyDecimalPoint());
		    outStandingCapital = NumberUtil.toDoubleObj(
			    islamicCalculatorCO.getTrspayplandetVOList().get(i).getTOTAL_PRINCIPAL_OUTSTANDIG())
			    - chargesAndInsuranceExcludingProfitCalc;
		    outStandingCapital = NumberUtil.round(outStandingCapital,
			    islamicCalculatorCO.getDealCyDecimalPoint());
		    String capitalize = ConstantsCommon.NO;
		    double profitAmount = getProfitAmount(islamicCalculatorCO, dateFrom, dateTo, outStandingCapital, 0L,
			    0D, NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), i, capitalize);
		    profitAmount = NumberUtil.round(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		    islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT(
			    NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

		    // log.error("REPAYMENT PLAN SCHEDULE<MANOJ> : profitAmount
		    // :- profitAmount = "
		    // + profitAmount);
		    // log.error("REPAYMENT PLAN SCHEDULE<MANOJ> : dateFrom :-
		    // dateFrom = "
		    // + dateFrom.toString());
		    // log.error("REPAYMENT PLAN SCHEDULE<MANOJ> : dateTo :-
		    // dateTo = "
		    // + dateTo.toString());

		    islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT(NumberUtil.roundToBigDecimal(
			    NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT())
				    - profitAmount,
			    islamicCalculatorCO.getDealCyDecimalPoint()));

		    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT(
		    // NumberUtil.roundToBigDecimal(outStandingCapital,
		    // islamicCalculatorCO
		    // .getDealCyDecimalPoint()));
		    //
		    // islamicCalculatorCO.getTrspayplandetVOList().get(i).setAMOUNT(
		    // NumberUtil.roundToBigDecimal(outStandingCapital +
		    // profitAmount, islamicCalculatorCO
		    // .getDealCyDecimalPoint()));

		    islamicCalculatorCO.getTrspayplandetVOList().get(i).setPRINCIPLE_AMT(NumberUtil.roundToBigDecimal(
			    NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT())
				    - NumberUtil.toDoubleObj(
					    islamicCalculatorCO.getTrspayplandetVOList().get(i).getCHARGE_AMOUNT())
				    - NumberUtil.toDoubleObj(
					    islamicCalculatorCO.getTrspayplandetVOList().get(i).getINSURANCE_AMOUNT()),
			    islamicCalculatorCO.getDealCyDecimalPoint()));
		    outStandingCapital = NumberUtil.toDoubleObj(
			    islamicCalculatorCO.getTrspayplandetVOList().get(i).getTOTAL_PRINCIPAL_OUTSTANDIG())
			    - NumberUtil
				    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT());

		    islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT_BEFORE_XIRR(
			    islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT());
		    islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT_BEFORE_XIRR(
			    islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT());

		}
		else
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(i).setTOTAL_PRINCIPAL_OUTSTANDIG(NumberUtil
			    .roundToBigDecimal(outStandingCapital, islamicCalculatorCO.getDealCyDecimalPoint()));
		    break;
		}
	    }// end of for loop
	}
	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
	if(islamicCalculatorCO.getTrspayplandetVOList().size() > outstndPrncInstallmentLineNo)
	{
	    setOutstandingPrincipalAsInstallment(islamicCalculatorCO, outstndPrncInstallmentLineNo);
	    islamicCalculatorCO
		    .setOutNoOfPayments(BigDecimal.valueOf(islamicCalculatorCO.getTrspayplandetVOList().size()));
	}
	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
    }

    private void setOutstandingPrincipalAsInstallment(IslamicCalculatorCO islamicCalculatorCO,
	    Integer outstndPrncInstallmentLineNoParam) throws BaseException
    {
	Integer outstndPrncInstallmentLineNo = outstndPrncInstallmentLineNoParam;

	if(outstndPrncInstallmentLineNo == null)
	{
	    outstndPrncInstallmentLineNo = 0;
	}
	if(outstndPrncInstallmentLineNo == islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
	{
	    return;
	}
	// log
	// .error("REPAYMENT PLAN SCHEDULE<MANOJ> :
	// setOutstandingPrincipalAsInstallment :- outstndPrncInstallmentLineNo
	// = "
	// + outstndPrncInstallmentLineNo.toString());
	double outstandingCapital = 0D;
	double outstandingCharges = 0D;
	double outstandingChargesProfit = 0D;
	double outstandingInsuranceProfit = 0D;
	double outstandingInsurance = 0D;
	for(int i = outstndPrncInstallmentLineNo; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if(outstndPrncInstallmentLineNo == i)
	    {
		outstandingCapital = NumberUtil.toDoubleObj(
			islamicCalculatorCO.getTrspayplandetVOList().get(i + 1).getTOTAL_PRINCIPAL_OUTSTANDIG());
	    }
	    else if(outstndPrncInstallmentLineNo < i)
	    {
		outstandingCharges += NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCHARGE_AMOUNT());
		outstandingInsurance += NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getINSURANCE_AMOUNT());
		outstandingChargesProfit += NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_ON_CHARGES());
		outstandingInsuranceProfit += NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_ON_INSURANCE());
		islamicCalculatorCO.getTrspayplandetVOList().remove(i);
		i--;
	    }
	}
	double outstandingPrincipal = 0D;
	if(outstndPrncInstallmentLineNo >= 0 && outstandingCapital > 0)
	{
	    TrspayplandetCO trspayplandetCO = new TrspayplandetCO();

	    outstandingCapital = NumberUtil.round(outstandingCapital, islamicCalculatorCO.getDealCyDecimalPoint());
	    // log.error("REPAYMENT PLAN SCHEDULE<MANOJ> :
	    // setOutstandingPrincipalAsInstallment :- outstandingCapital = "
	    // + outstandingCapital);

	    outstandingCharges = NumberUtil.round(outstandingCharges, islamicCalculatorCO.getDealCyDecimalPoint());
	    outstandingInsurance = NumberUtil.round(outstandingInsurance, islamicCalculatorCO.getDealCyDecimalPoint());
	    outstandingChargesProfit = NumberUtil.round(outstandingChargesProfit,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    outstandingInsuranceProfit = NumberUtil.round(outstandingInsuranceProfit,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    outstandingPrincipal = NumberUtil.round(outstandingCapital - outstandingCharges - outstandingInsurance,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    // log
	    // .error("REPAYMENT PLAN SCHEDULE<MANOJ> :
	    // setOutstandingPrincipalAsInstallment :- outstandingPrincipal = "
	    // + outstandingPrincipal);

	    trspayplandetCO.setVALUE_DATE(islamicCalculatorCO.getOutstandingPrincipalInstallmentDate());
	    trspayplandetCO.setCAPITAL_AMT(
		    NumberUtil.roundToBigDecimal(outstandingCapital, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setCAPITAL_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(outstandingCapital, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setAMOUNT(
		    NumberUtil.roundToBigDecimal(outstandingCapital, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setPROFIT_AMT(BigDecimal.valueOf(0D));
	    trspayplandetCO.setPROFIT_AMT_BEFORE_XIRR(BigDecimal.valueOf(0D));
	    trspayplandetCO.setACTUAL_PROFIT_AMT(BigDecimal.valueOf(0D));
	    trspayplandetCO.setACTUAL_PROFIT_AMT_BEFORE_XIRR(BigDecimal.valueOf(0D));

	    trspayplandetCO.setPRINCIPLE_AMT(
		    NumberUtil.roundToBigDecimal(outstandingPrincipal, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setCHARGE_AMOUNT(
		    NumberUtil.roundToBigDecimal(outstandingCharges, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setPROFIT_ON_CHARGES(NumberUtil.roundToBigDecimal(outstandingChargesProfit,
		    islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setINSURANCE_AMOUNT(
		    NumberUtil.roundToBigDecimal(outstandingInsurance, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setPROFIT_ON_INSURANCE(NumberUtil.roundToBigDecimal(outstandingInsuranceProfit,
		    islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setPAYMENT_TYPE("B");
	    trspayplandetCO.setBALLOON_PAYMENT(BigDecimal.ZERO);
	    trspayplandetCO.setLINE_NBR(BigDecimal.valueOf(outstndPrncInstallmentLineNo.longValue() + 2L));
	    trspayplandetCO.setNO_OF_DAYS(BigDecimal.ZERO);
	    trspayplandetCO.setTOTAL_PRINCIPAL_OUTSTANDIG(
		    NumberUtil.roundToBigDecimal(outstandingCapital, islamicCalculatorCO.getDealCyDecimalPoint()));

	    trspayplandetCO.setAUTO_CREATE_SETTLEMENT(ConstantsCommon.NO);
	    trspayplandetCO.setEXCLUDE_MATURITY_ENTRY_YN(ConstantsCommon.YES);
	    trspayplandetCO.setOUTSTD_PRINCIPAL_INSTALLMNT_YN(ConstantsCommon.YES);

	    islamicCalculatorCO.getTrspayplandetVOList().add(trspayplandetCO);
	}
    }

    private void applyRoundingFactorAfterCalculation(IslamicCalculatorCO islamicCalculatorCO)
    {
	double applayedRoundingInstallmentAmount = 0D;
	// double totalOutstandingAmount =
	// NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
	// + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
	// + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
	// +
	// NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());

	// totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount,
	// islamicCalculatorCO.getDealCyDecimalPoint());
	double diffAmount = 0d;

	for(int index = 0; index < islamicCalculatorCO.getTrspayplandetVOList().size(); index++)
	{
	    if(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT
		    .equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE())
		    && ConstantsCommon.NO
			    .equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getUserDefined()))
	    {
		double installmentAmount = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT());

		applayedRoundingInstallmentAmount = roundPmtAmount(islamicCalculatorCO, installmentAmount,
			islamicCalculatorCO.getRoundingFactor());

		islamicCalculatorCO.getTrspayplandetVOList().get(index).setAMOUNT(NumberUtil.roundToBigDecimal(
			applayedRoundingInstallmentAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

		diffAmount += installmentAmount - applayedRoundingInstallmentAmount;
	    }
	}

	if(diffAmount != 0D)
	{
	    if(IISCommonConstants.RESIDUAL_VALUE_LAST_INSTALLMENT.equals(islamicCalculatorCO.getResidualValue()))
	    {
		islamicCalculatorCO.getTrspayplandetVOList()
			.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
			.setAMOUNT(NumberUtil.roundToBigDecimal(applayedRoundingInstallmentAmount + diffAmount,
				islamicCalculatorCO.getDealCyDecimalPoint()));
	    }
	    else if(IISCommonConstants.RESIDUAL_VALUE_FIRST_INSTALLMENT.equals(islamicCalculatorCO.getResidualValue()))
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(0).setAMOUNT(NumberUtil.roundToBigDecimal(
			applayedRoundingInstallmentAmount + diffAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    }
	    else
	    {
		islamicCalculatorCO.setOutResidualValueDownPayment(BigDecimal.valueOf(diffAmount));
	    }
	}
    }

    private void reSetExcessProfitInNextInstallment(IslamicCalculatorCO islamicCalculatorCO)
    {
	double pushDownProfit = 0d;
	for(int index = 0; index < islamicCalculatorCO.getTrspayplandetVOList().size(); index++)
	{
	    if(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL
		    .equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE()))
	    {
		pushDownProfit = NumberUtil.toDoubleObj(
			islamicCalculatorCO.getTrspayplandetVOList().get(index).getPRFT_AMT_PUSHDWN_FRM_ABV_INST());
	    }
	    else
	    {
		if(islamicCalculatorCO.getTrspayplandetVOList().size() == index + 1
			&& IISCommonConstants.PAYMENT_TYPE_SPECIFIC_AMOUNT
				.equals(islamicCalculatorCO.getProfitCalculationMethod()))
		{
		    pushDownProfit = 0d;
		}
		islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.setPROFIT_AMT(
				NumberUtil.roundToBigDecimal(
					NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
						.getACTUAL_PROFIT_AMT()) + pushDownProfit,
					islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT_BEFORE_XIRR(
			islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
		islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.setPRFT_AMT_PUSHDWN_FRM_ABV_INST(BigDecimal.valueOf(0D));
		pushDownProfit = 0d;
	    }
	}
    }

    private void distributeCharges(IslamicCalculatorCO islamicCalculatorCO)
    {
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getPayProfitAndChargesOnly()))
	{
	    return;
	}
	double cumSumAllocatedCharges = 0D;
	double cumSumAllocatedInsurance = 0D;
	boolean allocateCharges = false;
	boolean allocateInsurance = false;
	// int loopCount = 0;
	// loopCount++;
	int index = 0;

	// double lineCharges =
	// NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
	// / islamicCalculatorCO.getTrspayplandetVOList().size();
	// double lineInsurance =
	// NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
	// / islamicCalculatorCO.getTrspayplandetVOList().size();

	for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
	{
	    if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		    .endsWith(islamicCalculatorCO.getProfitCalculationMethod())
		    && ConstantsCommon.YES.equals(islamicCalculatorCO.getPrincipalInLastPayment()))
	    {
		if(index == islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setCHARGE_AMOUNT(islamicCalculatorCO.getTotalCharges());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPROFIT_ON_CHARGES(islamicCalculatorCO.getProfitOnCharges());

		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setINSURANCE_AMOUNT(islamicCalculatorCO.getTotalInsurance());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPROFIT_ON_INSURANCE(islamicCalculatorCO.getProfitOnInsurance());
		    cumSumAllocatedCharges = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges());
		    cumSumAllocatedInsurance = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance());
		}
		else
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGE_AMOUNT(BigDecimal.valueOf(0D));
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPROFIT_ON_CHARGES(BigDecimal.valueOf(0D));

		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_AMOUNT(BigDecimal.valueOf(0D));
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPROFIT_ON_INSURANCE(BigDecimal.valueOf(0D));
		}
	    }
	    else
	    {
		if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges()) > 0D && !allocateCharges)
		{
		    double allocateLineCharge = 0D;
		    if(NumberUtil.toDouble(islamicCalculatorCO.getProfitOnCharges()) == 0d)
		    {
			islamicCalculatorCO.getTrspayplandetVOList().get(index)
				.setPROFIT_ON_CHARGES(BigDecimal.valueOf(0D));
			islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGE_AMOUNT(islamicCalculatorCO
				.getTrspayplandetVOList().get(index).getCHARGES_EXCLUDE_PROFI_CALC());
		    }
		    else
		    {
			IslamicCalculatorStructurePlanDetCO strCharges = new IslamicCalculatorStructurePlanDetCO();
			strCharges = getlineCharges(islamicCalculatorCO,
				NumberUtil.toDoubleObj(trspayplandetCO.getCAPITAL_AMT()), cumSumAllocatedCharges, index,
				islamicCalculatorCO.getTotalCharges().doubleValue());
			allocateLineCharge = strCharges.getLineAllocatedCharges();
			cumSumAllocatedCharges = strCharges.getCumAllocatedCharges();
			/*
			 * cumSumActualCharges =
			 * strCharges.getCumActualCharges(); chargesLineCount +=
			 * strCharges.getLineAllocatedCount();
			 */
			islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGE_AMOUNT(NumberUtil
				.roundToBigDecimal(allocateLineCharge, islamicCalculatorCO.getDealCyDecimalPoint()));
			if(islamicCalculatorCO.getTrspayplandetVOList().get(index)
				.getCHARGES_EXCLUDE_PROFI_CALC() == null)
			{
			    islamicCalculatorCO.getTrspayplandetVOList().get(index)
				    .setPROFIT_ON_CHARGES(NumberUtil.roundToBigDecimal(allocateLineCharge,
					    islamicCalculatorCO.getDealCyDecimalPoint()));
			}
			else
			{
			    islamicCalculatorCO.getTrspayplandetVOList().get(index)
				    .setPROFIT_ON_CHARGES(NumberUtil.roundToBigDecimal(
					    allocateLineCharge - NumberUtil
						    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
							    .getCHARGES_EXCLUDE_PROFI_CALC()),
					    islamicCalculatorCO.getDealCyDecimalPoint()));
			}
			strCharges = null;
		    }
		}
		else if(NumberUtil.toDouble(islamicCalculatorCO.getTotalCharges()) == 0D)
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGE_AMOUNT(BigDecimal.valueOf(0D));
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPROFIT_ON_CHARGES(BigDecimal.valueOf(0D));
		}
		if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance()) > 0D && !allocateInsurance)
		{
		    double allocateLineInsurance = 0D;

		    if(NumberUtil.toDouble(islamicCalculatorCO.getProfitOnInsurance()) == 0D)
		    {
			islamicCalculatorCO.getTrspayplandetVOList().get(index)
				.setPROFIT_ON_INSURANCE(BigDecimal.valueOf(0d));
			islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_AMOUNT(islamicCalculatorCO
				.getTrspayplandetVOList().get(index).getINSURANCE_EXCLUDE_PROFI_CALC());
		    }
		    else
		    {
			IslamicCalculatorStructurePlanDetCO strInsurance = new IslamicCalculatorStructurePlanDetCO();
			strInsurance = getlineCharges(islamicCalculatorCO,
				NumberUtil.toDoubleObj(trspayplandetCO.getCAPITAL_AMT()), cumSumAllocatedInsurance,
				index, islamicCalculatorCO.getTotalInsurance().doubleValue());
			allocateLineInsurance = strInsurance.getLineAllocatedCharges();
			cumSumAllocatedInsurance = strInsurance.getCumAllocatedCharges();

			/*
			 * cumSumActualInsurance =
			 * strInsurance.getCumActualCharges();
			 * InsuranceLineCount +=
			 * strInsurance.getLineAllocatedCount();
			 */
			islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_AMOUNT(NumberUtil
				.roundToBigDecimal(allocateLineInsurance, islamicCalculatorCO.getDealCyDecimalPoint()));
			if(islamicCalculatorCO.getTrspayplandetVOList().get(index)
				.getINSURANCE_EXCLUDE_PROFI_CALC() == null)
			{
			    islamicCalculatorCO.getTrspayplandetVOList().get(index)
				    .setPROFIT_ON_INSURANCE(NumberUtil.roundToBigDecimal(allocateLineInsurance,
					    islamicCalculatorCO.getDealCyDecimalPoint()));
			}
			else
			{
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_ON_INSURANCE(

				    NumberUtil.roundToBigDecimal(
					    allocateLineInsurance - NumberUtil
						    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
							    .getINSURANCE_EXCLUDE_PROFI_CALC()),
					    islamicCalculatorCO.getDealCyDecimalPoint()));
			}
			strInsurance = null;
		    }
		}
		else if(NumberUtil.toDouble(islamicCalculatorCO.getTotalInsurance()) == 0D)
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_AMOUNT(BigDecimal.valueOf(0D));
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPROFIT_ON_INSURANCE(BigDecimal.valueOf(0D));
		}
	    }
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPRINCIPLE_AMT(

		    NumberUtil.roundToBigDecimal(
			    NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
				    - (NumberUtil.toDoubleObj(
					    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT())
					    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
						    .get(index).getINSURANCE_AMOUNT())),
			    islamicCalculatorCO.getDealCyDecimalPoint()));

	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setTOTAL_PRINCIPAL_OUTSTANDIG(BigDecimal.ZERO);
	    }
	    else
	    {
		if(index > 0)
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setTOTAL_PRINCIPAL_OUTSTANDIG(

			    NumberUtil.roundToBigDecimal(
				    NumberUtil
					    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index - 1)
						    .getTOTAL_PRINCIPAL_OUTSTANDIG())
					    - NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
						    .get(index - 1).getCAPITAL_AMT()),
				    islamicCalculatorCO.getDealCyDecimalPoint()));
		}
	    }
	    islamicCalculatorCO.getTrspayplandetVOList().get(index)
		    .setPROFIT_AMT_BEFORE_XIRR(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT_BEFORE_XIRR(
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
	    index++;
	}// end of for loop
    }

    private void applyIAS18Method(IslamicCalculatorCO islamicCalculatorCO)
    {
	double totalProfitAmount = getTotalProfit(islamicCalculatorCO);
	double totalOutstandingAmount = ConstantsCommon.NO.equals(islamicCalculatorCO.getTentativeSchedule())
		? NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
		: NumberUtil.toDoubleObj(islamicCalculatorCO.getOutstandingAmountForXIRR());

	// totalOutstandingAmount = totalOutstandingAmount +
	// NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
	// + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
	// + NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges())
	// + NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance())
	// +
	// NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());
	totalOutstandingAmount = totalOutstandingAmount + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance());

	totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount, islamicCalculatorCO.getDealCyDecimalPoint());

	if(totalProfitAmount == 0)
	{
	    return;
	}
	/**
	 * For Reschedul
	 */
	adjustFirstLineXirrProfit(islamicCalculatorCO, "D");
	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);

	double XIRRRate = getXIRR(islamicCalculatorCO, totalOutstandingAmount);
	islamicCalculatorCO.setXirrOut(BigDecimal.valueOf(XIRRRate));
	// System.out.println("XIRR= " + XIRRRate);
	/*
	 * if the Profit Recognition Method is IAS 18 apply the reallocate the
	 * profit based on the XIRR rate
	 */

	if(IISCommonConstants.PROFIT_DISTRIBUTION_METHOD_IAS_18
		.equals(islamicCalculatorCO.getProfitRecognitionMethod()))
	{
	    getXNPV(islamicCalculatorCO, XIRRRate / 100, totalOutstandingAmount, totalProfitAmount);
	}
	adjustFirstLineXirrProfit(islamicCalculatorCO, "A");
    }

    /**
     * To adjust ehe first line XIRR profit
     * 
     * @param islamicCalculatorCO
     * @param type A - Add, D Dedut
     */
    private void adjustFirstLineXirrProfit(IslamicCalculatorCO islamicCalculatorCO, String type)
    {
	String add = "A";
	BigDecimal firstLineAdjustProfitAmt = NumberUtil.nullToZero(islamicCalculatorCO.getFirstLineProfitToBeAdjust());
	if(firstLineAdjustProfitAmt.compareTo(BigDecimal.ZERO) != 0)
	{
	    BigDecimal profitAmt = islamicCalculatorCO.getTrspayplandetVOList().get(0).getPROFIT_AMT();
	    BigDecimal instAmt = islamicCalculatorCO.getTrspayplandetVOList().get(0).getAMOUNT();
	    if(type.equals(add))
	    {
		profitAmt = profitAmt.add(firstLineAdjustProfitAmt);
		instAmt = instAmt.add(firstLineAdjustProfitAmt);
	    }
	    else
	    {
		profitAmt = profitAmt.subtract(firstLineAdjustProfitAmt);
		instAmt = instAmt.subtract(firstLineAdjustProfitAmt);
	    }

	    islamicCalculatorCO.getTrspayplandetVOList().get(0).setPROFIT_AMT(profitAmt);
	    islamicCalculatorCO.getTrspayplandetVOList().get(0).setAMOUNT(instAmt);
	}
    }

    private void getXNPV(IslamicCalculatorCO islamicCalculatorCO, Double rate, Double totalOutstandingAmountParam,
	    Double totalProfitAmount)
    {
	Double totalOutstandingAmount = totalOutstandingAmountParam;
	// Date dateFrom = islamicCalculatorCO.getValueDate();
	Date dateFrom = islamicCalculatorCO.getNextDisbursementDate();
	double pushDowinProfitAmount = 0D;
	double netInvestOutstandingAmt = totalOutstandingAmount;
	double totalEarnedProfit = 0D;
	double installmentAmount = 0D;
	double xnpvAmount = 0.00;

	double outstandingProfitAmount = totalProfitAmount;
	for(int index = 0; index < islamicCalculatorCO.getTrspayplandetVOList().size(); index++)
	{
	    xnpvAmount = 0.00;
	    installmentAmount = 0D;
	    for(int i = index; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	    {
		if(i == index)
		{
		    dateFrom = islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE();
		    // xnpvAmount = NumberUtil
		    // .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT())
		    // -
		    // (NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    // .getCHARGE_AMOUNT()) +
		    // NumberUtil.toDoubleObj(islamicCalculatorCO
		    // .getTrspayplandetVOList().get(i).getINSURANCE_AMOUNT()))
		    // +
		    // (NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    // .getPROFIT_ON_CHARGES()) +
		    // NumberUtil.toDoubleObj(islamicCalculatorCO
		    // .getTrspayplandetVOList().get(i).getPROFIT_ON_INSURANCE()));

		    xnpvAmount = NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT());

		    xnpvAmount = NumberUtil.round(xnpvAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		}
		else
		{
		    Date dateTo = islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE();
		    // installmentAmount =
		    // NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    // .getAMOUNT())
		    // -
		    // (NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    // .getCHARGE_AMOUNT()) +
		    // NumberUtil.toDoubleObj(islamicCalculatorCO
		    // .getTrspayplandetVOList().get(i).getINSURANCE_AMOUNT()))
		    // +
		    // (NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    // .getPROFIT_ON_CHARGES()) +
		    // NumberUtil.toDoubleObj(islamicCalculatorCO
		    // .getTrspayplandetVOList().get(i).getPROFIT_ON_INSURANCE()));
		    installmentAmount = NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT());

		    installmentAmount = NumberUtil.round(installmentAmount,
			    islamicCalculatorCO.getDealCyDecimalPoint());
		    double expFactor = DateUtil.numberOfDays(dateFrom, dateTo) / 365.00;
		    double vnpValues = installmentAmount / Math.pow((1 + rate), expFactor);
		    xnpvAmount += vnpValues;
		    dateTo = null;
		}
	    }
	    islamicCalculatorCO.getTrspayplandetVOList().get(index)
		    .setXNPV(NumberUtil.roundToBigDecimal(xnpvAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    // installmentAmount =
	    // NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
	    // .getAMOUNT())
	    // -
	    // (NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
	    // .getCHARGE_AMOUNT()) +
	    // NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
	    // .get(index).getINSURANCE_AMOUNT()))
	    // +
	    // (NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
	    // .getPROFIT_ON_CHARGES()) +
	    // NumberUtil.toDoubleObj(islamicCalculatorCO
	    // .getTrspayplandetVOList().get(index).getPROFIT_ON_INSURANCE()));

	    installmentAmount = NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT());

	    installmentAmount = NumberUtil.round(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint());

	    netInvestOutstandingAmt = NumberUtil.round(netInvestOutstandingAmt - installmentAmount,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setNET_INVEST_OUTSTANDING(
		    NumberUtil.roundToBigDecimal(netInvestOutstandingAmt, islamicCalculatorCO.getDealCyDecimalPoint()));
	}

	netInvestOutstandingAmt = totalOutstandingAmount;
	totalOutstandingAmount = totalOutstandingAmount
		+ (NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
			- NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges()))
		+ (NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
			- NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance()));
	double pushDownProfitOnCharges = 0D;
	double pushDownCharges = 0D;

	double pushDownProfitOnInsurance = 0D;
	double pushDownInsurance = 0D;
	for(int index = 0; index < islamicCalculatorCO.getTrspayplandetVOList().size(); index++)
	{
	    xnpvAmount = NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getXNPV());
	    double currentProfitAmount = pushDowinProfitAmount;
	    pushDowinProfitAmount = 0d;

	    double currentProfitOnCharges = pushDownProfitOnCharges + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_ON_CHARGES());
	    double currentCharges = pushDownCharges + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT());
	    double currentProfitOnInsurance = pushDownProfitOnInsurance + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_ON_INSURANCE());
	    double currentInsurance = pushDownInsurance + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT());

	    pushDownProfitOnCharges = 0d;
	    pushDownCharges = 0d;
	    pushDownProfitOnInsurance = 0d;
	    pushDownInsurance = 0d;

	    currentProfitOnCharges = NumberUtil.round(currentProfitOnCharges,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    currentCharges = NumberUtil.round(currentCharges, islamicCalculatorCO.getDealCyDecimalPoint());
	    currentProfitOnInsurance = NumberUtil.round(currentProfitOnInsurance,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    currentInsurance = NumberUtil.round(currentInsurance, islamicCalculatorCO.getDealCyDecimalPoint());

	    installmentAmount = NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT());
	    double actualProfitAmount = NumberUtil.round((xnpvAmount - netInvestOutstandingAmt - totalEarnedProfit),
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    currentProfitAmount = NumberUtil.round(currentProfitAmount + (actualProfitAmount),
		    islamicCalculatorCO.getDealCyDecimalPoint());

	    totalEarnedProfit = NumberUtil.round(xnpvAmount - netInvestOutstandingAmt,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setTOTAL_EARNED_PROFIT(
		    NumberUtil.roundToBigDecimal(totalEarnedProfit, islamicCalculatorCO.getDealCyDecimalPoint()));

	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getPrincipalInLastPayment())
		    && IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			    .equals(islamicCalculatorCO.getProfitCalculationMethod()))
	    {
		double diffAmount = NumberUtil.round(
			NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT())
				- currentProfitAmount,
			islamicCalculatorCO.getDealCyDecimalPoint());
		if(diffAmount > 0D || index == islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
		{
		    installmentAmount = NumberUtil.round(installmentAmount - (diffAmount),
			    islamicCalculatorCO.getDealCyDecimalPoint());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setAMOUNT(NumberUtil
			    .roundToBigDecimal(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		}
	    }

	    if(currentProfitAmount > installmentAmount && ConstantsCommon.NO
		    .equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getFlexiPaymentYN()))
	    {
		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getExcessProfitInNextInstallment()))
		{
		    pushDowinProfitAmount = NumberUtil.round(currentProfitAmount - installmentAmount,
			    islamicCalculatorCO.getDealCyDecimalPoint());
		    currentProfitAmount = installmentAmount;
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(NumberUtil.roundToBigDecimal(
			    installmentAmount - currentProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPUSHDOWN_PROFIT_AFTER_XIRR(NumberUtil
			    .roundToBigDecimal(pushDowinProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		}
		else
		{
		    pushDowinProfitAmount = NumberUtil.round(currentProfitAmount - installmentAmount,
			    islamicCalculatorCO.getDealCyDecimalPoint());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(BigDecimal.valueOf(0d));
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPUSHDOWN_PROFIT_AFTER_XIRR(BigDecimal.valueOf(0D));
		    currentProfitAmount = actualProfitAmount;
		}
	    }
	    else
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(NumberUtil.roundToBigDecimal(
			installmentAmount - currentProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		if(ConstantsCommon.NO.equals(islamicCalculatorCO.getExcessProfitInNextInstallment()))
		{
		    currentProfitAmount = actualProfitAmount;
		}
	    }

	    netInvestOutstandingAmt = NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getNET_INVEST_OUTSTANDING());

	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT(
		    NumberUtil.roundToBigDecimal(currentProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    outstandingProfitAmount = NumberUtil.round(outstandingProfitAmount - currentProfitAmount,
		    islamicCalculatorCO.getDealCyDecimalPoint());

	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setTOTAL_DEFERRED_PROFIT(
		    NumberUtil.roundToBigDecimal(outstandingProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setTOTAL_PRINCIPAL_OUTSTANDIG(
		    NumberUtil.roundToBigDecimal(totalOutstandingAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    totalOutstandingAmount = NumberUtil.round(
		    totalOutstandingAmount - NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT()),
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    if(ConstantsCommon.NO.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getFlexiPaymentYN()))
	    {
		if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
			- currentProfitOnCharges < 0)
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_ON_CHARGES(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
		    pushDownProfitOnCharges = currentProfitOnCharges - NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
		}
		else
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_ON_CHARGES(NumberUtil
			    .roundToBigDecimal(currentProfitOnCharges, islamicCalculatorCO.getDealCyDecimalPoint()));
		}
		if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
			- currentCharges < 0)
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setCHARGE_AMOUNT(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
		    pushDownCharges = currentCharges - NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
		}
		else
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGE_AMOUNT(
			    NumberUtil.roundToBigDecimal(currentCharges, islamicCalculatorCO.getDealCyDecimalPoint()));
		}

		if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
			- currentProfitOnInsurance - NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT()) < 0)
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_ON_INSURANCE(

			    NumberUtil.roundToBigDecimal(
				    NumberUtil.toDoubleObj(
					    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
					    - NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
						    .get(index).getCHARGE_AMOUNT()),
				    islamicCalculatorCO.getDealCyDecimalPoint()));

		    pushDownProfitOnInsurance = currentProfitOnInsurance - NumberUtil.toDoubleObj(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_ON_INSURANCE());
		}
		else
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_ON_INSURANCE(NumberUtil
			    .roundToBigDecimal(currentProfitOnInsurance, islamicCalculatorCO.getDealCyDecimalPoint()));
		}
		if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
			- currentInsurance - NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT()) < 0)
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_AMOUNT(NumberUtil
			    .roundToBigDecimal(
				    NumberUtil.toDoubleObj(
					    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
					    - NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
						    .get(index).getCHARGE_AMOUNT()),
				    islamicCalculatorCO.getDealCyDecimalPoint()));

		    pushDownInsurance = currentInsurance - NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT());
		}
		else
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_AMOUNT(NumberUtil
			    .roundToBigDecimal(currentInsurance, islamicCalculatorCO.getDealCyDecimalPoint()));
		}
	    }
	    double outstandingPrincipal = NumberUtil.toDoubleObj(
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).getTOTAL_PRINCIPAL_OUTSTANDIG());
	    long noDays = islamicCalculatorCO.getTrspayplandetVOList().get(index).getNO_OF_DAYS().longValue();
	    double ror = 0D;
	    if(noDays > 0L)
	    {
		// TP 167661 ; Manoj ; 23/06/2014
		// ror = NumberUtil.round(((currentProfitAmount / xnpvAmount /
		// noDays) * 365) * 100, 3);
		if(currentProfitAmount > 0 && outstandingPrincipal > 0 && noDays > 0)
		{
		    ror = NumberUtil.round(((currentProfitAmount / outstandingPrincipal / noDays) * 365) * 100, 6);
		}
		else
		{
		    ror = 0;
		}
	    }
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPRINCIPLE_AMT(NumberUtil.roundToBigDecimal(
		    NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
			    - NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT())
			    - NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT()),
		    islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setROR(BigDecimal.valueOf(ror));
	}
    }

    private Double getXIRR(IslamicCalculatorCO islamicCalculatorCO, Double totalOutstandingAmount)
    {
	double rate = 0d;
	double xnpvAmount = 0d;
	// double incrementalValue = 1d;
	// double counter = 0;
	// double counter1 = 10000;
	// int sign = 1;

	double x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13;

	for(x1 = 1; x1 <= 10000; x1++)
	{
	    rate = x1;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount < 0D)
	    {
		break;
	    }
	}

	for(x2 = x1; x2 >= .1; x2 = x2 - 0.1)
	{
	    rate = x2;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount > 0D)
	    {
		break;
	    }
	}

	for(x3 = x2; x3 <= x1; x3 = x3 + 0.01)
	{
	    rate = x3;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount < 0D)
	    {
		break;
	    }
	}

	for(x4 = x3; x4 >= x2; x4 = x4 - 0.001)
	{
	    rate = x4;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount > 0D)
	    {
		break;
	    }
	}

	for(x5 = x4; x5 <= x3; x5 = x5 + 0.0001)
	{
	    rate = x5;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount < 0D)
	    {
		break;
	    }
	}

	for(x6 = x5; x6 >= x4; x6 = x6 - 0.00001)
	{
	    rate = x6;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount > 0D)
	    {
		break;
	    }
	}

	for(x7 = x6; x7 <= x5; x7 = x7 + 0.000001)
	{
	    rate = x7;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount < 0D)
	    {
		break;
	    }
	}

	for(x8 = x7; x8 >= x6; x8 = x8 - 0.0000001)
	{
	    rate = x8;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount > 0D)
	    {
		break;
	    }
	}

	for(x9 = x8; x9 <= x7; x9 = x9 + 0.00000001)
	{
	    rate = x9;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount < 0D)
	    {
		break;
	    }
	}

	for(x10 = x9; x10 >= x8; x10 = x10 - 0.000000001)
	{
	    rate = x10;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount > 0D)
	    {
		break;
	    }
	}

	for(x11 = x10; x11 <= x9; x11 = x11 + 0.0000000001)
	{
	    rate = x11;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount < 0D)
	    {
		break;
	    }
	}

	for(x12 = x11; x12 >= x10; x12 = x12 - 0.0000000001)
	{
	    rate = x12;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount > 0D)
	    {
		break;
	    }
	}

	for(x13 = x12; x13 <= x11; x13 = x13 + 0.00000000001)
	{
	    rate = x13;
	    xnpvAmount = calculateXIRR(islamicCalculatorCO, totalOutstandingAmount, (rate));
	    if(xnpvAmount == 0D)
	    {
		return rate * 100;
	    }
	    if(xnpvAmount < 0D)
	    {
		break;
	    }
	}
	return rate * 100;

	// for(int i = 0; i < 13; i++)
	// {
	// double mod = i % 2;
	// if(mod == 0D)
	// {
	// sign = 1;
	// }
	// else
	// {
	// sign = -1;
	// }
	// incrementalValue = NumberUtil.round((1D / Math.pow(10D, i)) * sign,
	// i);
	// do
	// {
	// counter++;
	//
	// rate = NumberUtil.round((rate + incrementalValue), i);
	// xnpvAmount = calculateXIRR(islamicCalculatorCO,
	// totalOutstandingAmount, (rate));
	// // if(Math.abs(xnpvAmount) > 10000 && i == 0)
	// // {
	// // incrementalValue = sign * 1000;
	// // }
	// // else if(Math.abs(xnpvAmount) > 1000 && i == 0)
	// // {
	// // incrementalValue = sign * 100;
	// // }
	// // else
	// // {
	// // incrementalValue = NumberUtil.round((1D / Math.pow(10D, i)) *
	// // sign, i);
	// // }
	//
	// // xnpvAmount = NumberUtil.round(xnpvAmount, 12);
	// xnpvAmount = round(xnpvAmount, 12);
	// if(xnpvAmount == 0D)
	// {
	// return rate * 100;
	// }
	// else if(sign == 1)
	// {
	// if(xnpvAmount < 0D)
	// {
	// break;
	// }
	// }
	// else
	// {
	// if(xnpvAmount > 0D)
	// {
	// break;
	// }
	// }
	// if(rate == 0D)
	// {
	// break;
	// }
	// if(counter > counter1)
	// {
	// counter1 = Math.pow(10D, i) * counter;
	// counter = 0;
	// break;
	// }
	// }while(true);
	// }
	// return rate * 100;
    }

    private Double calculateXIRR(IslamicCalculatorCO islamicCalculatorCO, Double totalOutstandingAmount, Double rate)
    {
	double totalAmount = totalOutstandingAmount * -1;

	for(int index = 0; index < islamicCalculatorCO.getTrspayplandetVOList().size(); index++)
	{
	    Date dateTo = islamicCalculatorCO.getTrspayplandetVOList().get(index).getVALUE_DATE();
	    // commented on 01/12/2015 to corre ct the XIRR for chanrges
	    // including principal
	    // double installmentAmount =
	    // NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
	    // .getAMOUNT())
	    // -
	    // (NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
	    // .getCHARGE_AMOUNT()) +
	    // NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
	    // .get(index).getINSURANCE_AMOUNT()))
	    // +
	    // (NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
	    // .getPROFIT_ON_CHARGES()) +
	    // NumberUtil.toDoubleObj(islamicCalculatorCO
	    // .getTrspayplandetVOList().get(index).getPROFIT_ON_INSURANCE()));
	    double installmentAmount = NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT());

	    installmentAmount = NumberUtil.round(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint());

	    // double expFactor =
	    // DateUtil.numberOfDays(islamicCalculatorCO.getValueDate(), dateTo)
	    // / 365.00;
	    if(islamicCalculatorCO.getNextDisbursementDate() == null
		    || islamicCalculatorCO.getNextDisbursementDate().compareTo(DateUtil.nullToInitDate(null)) == 0)
	    {
		islamicCalculatorCO.setNextDisbursementDate(islamicCalculatorCO.getValueDate());
	    }
	    double expFactor = DateUtil.numberOfDays(islamicCalculatorCO.getNextDisbursementDate(), dateTo) / 365.00;

	    double vnpValues = installmentAmount / Math.pow((1 + rate), expFactor);
	    totalAmount += vnpValues;
	}
	// return NumberUtil.round(totalAmount, 12);
	return round(totalAmount, 12);
    }

    private void setGracePeriodCompoundingProfitWithInstallment(IslamicCalculatorCO islamicCalculatorCO)
    {
	int i = 0;
	BigDecimal ldec_total_compound_pft = BigDecimal.ZERO;
	for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod())
	{
	    islamicCalculatorCO.getTrspayplandetVOList().add(i, trspayplandetCO);
	    i++;
	    ldec_total_compound_pft = ldec_total_compound_pft
		    .add(NumberUtil.nullToZero(trspayplandetCO.getCAPITAL_AMT()));
	}
	ldec_total_compound_pft = ldec_total_compound_pft.multiply(BigDecimal.valueOf(-1));
	/**
	 * Added By manoj on 29/09/2014 TP ID #225663
	 * uf_set_compound_profit_in_grace_period
	 */
	if(!StringUtil.nullEmptyToValue(islamicCalculatorCO.getGrace_prd_cmpnd_pft_deal_yn(), ConstantsCommon.NO)
		.equals(ConstantsCommon.YES))
	{
	    return;
	}
	BigDecimal ldec_sum_capital = BigDecimal.ZERO;

	for(int j = 0; j < islamicCalculatorCO.getTrspayplandetVOList().size(); j++)
	{
	    ldec_sum_capital = ldec_sum_capital
		    .add(NumberUtil.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(j).getCAPITAL_AMT()));

	}
	int ll_Rows = islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().size();

	for(int j = 0; j < ll_Rows; j++)
	{
	    BigDecimal ldec_capital_amt = NumberUtil
		    .nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(j).getCAPITAL_AMT());

	    if(IISCommonConstants.LIMIT_REINSTATE_BASED_ON_PRINCIPAL
		    .equals(islamicCalculatorCO.getLimit_reinstate_based_on()))
	    {
		NumberUtil.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(j).getCAPITAL_AMT_BEFORE_XIRR());
	    }
	    islamicCalculatorCO.getTrspayplandetVOList().get(j).setGRACE_PRD_CMPND_CAPITAL_AMT(BigDecimal.ZERO);
	    islamicCalculatorCO.getTrspayplandetVOList().get(j).setGRACE_PRD_CMPND_PROFIT_AMT(ldec_capital_amt);
	}
	int total_rows = islamicCalculatorCO.getTrspayplandetVOList().size() - 1;
	BigDecimal ldec_sum_grace_prd_cmpnd_profit_amt = BigDecimal.ZERO,
		ldec_grace_prd_cmpnd_capital_amt = BigDecimal.ZERO;

	for(int j = ll_Rows; j <= total_rows; j++)
	{
	    BigDecimal ldec_capital_amt = NumberUtil
		    .nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(j).getCAPITAL_AMT());

	    if(IISCommonConstants.LIMIT_REINSTATE_BASED_ON_PRINCIPAL
		    .equals(islamicCalculatorCO.getLimit_reinstate_based_on()))
	    {
		NumberUtil.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(j).getCAPITAL_AMT_BEFORE_XIRR());
	    }
	    BigDecimal ldec_grace_prd_cmpnd_profit_amt = BigDecimal.ZERO;
	    BigDecimal idec_outstanding_grace_compounding_pft = islamicCalculatorCO
		    .getIdec_outstanding_grace_compounding_pft();
	    if(j == total_rows)
	    {
		ldec_grace_prd_cmpnd_profit_amt = ldec_total_compound_pft
			.add(islamicCalculatorCO.getIdec_outstanding_grace_compounding_pft())
			.subtract(ldec_sum_grace_prd_cmpnd_profit_amt);
	    }
	    else
	    {
		if(ldec_sum_capital.add(ldec_total_compound_pft).compareTo(BigDecimal.ZERO) == 0)
		{
		    ldec_grace_prd_cmpnd_profit_amt = BigDecimal.ZERO;
		}
		else
		{

		    ldec_grace_prd_cmpnd_profit_amt = NumberUtil
			    .roundToBigDecimal(
				    ldec_total_compound_pft.add(idec_outstanding_grace_compounding_pft)
					    .divide(ldec_sum_capital.add(ldec_total_compound_pft), 12,
						    BigDecimal.ROUND_HALF_UP)
					    .multiply(ldec_capital_amt),
				    islamicCalculatorCO.getDealCyDecimalPoint().intValue());
		}

	    }
	    ldec_sum_grace_prd_cmpnd_profit_amt = ldec_sum_grace_prd_cmpnd_profit_amt
		    .add(ldec_grace_prd_cmpnd_profit_amt);
	    ldec_grace_prd_cmpnd_capital_amt = ldec_capital_amt.subtract(ldec_grace_prd_cmpnd_profit_amt);

	    islamicCalculatorCO.getTrspayplandetVOList().get(j)
		    .setGRACE_PRD_CMPND_CAPITAL_AMT(ldec_grace_prd_cmpnd_capital_amt);
	    islamicCalculatorCO.getTrspayplandetVOList().get(j)
		    .setGRACE_PRD_CMPND_PROFIT_AMT(ldec_grace_prd_cmpnd_profit_amt);
	}

    }

    private void setDealPeriodCompoundingProfitWithInstallment(IslamicCalculatorCO islamicCalculatorCO)
    {
	int i = islamicCalculatorCO.getTrspayplandetCompoundingDealPeriod().get(0).getLINE_NBR().intValue();
	int currInstNo = i;
	int prevInstNo = i;
	for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetCompoundingDealPeriod())
	{
	    currInstNo = trspayplandetCO.getLINE_NBR().intValue();

	    if(currInstNo != prevInstNo)
	    {
		i++;
	    }
	    if(trspayplandetCO.getVALUE_DATE()
		    .equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE()))
	    {
		double tempAmount = NumberUtil.toDoubleObj(
			islamicCalculatorCO.getTrspayplandetVOList().get(i).getACTUAL_PROFIT_AMT_BEFORE_XIRR())
			+ NumberUtil.toDoubleObj(trspayplandetCO.getMONTHLY_COMPOUNDED_PROFIT_AMT());
		tempAmount = NumberUtil.round(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setMONTHLY_COMPOUNDED_PROFIT_AMT(
			NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		i--;
	    }
	    else
	    {
		islamicCalculatorCO.getTrspayplandetVOList().add(i, trspayplandetCO);
		prevInstNo = currInstNo;
	    }
	    i++;
	}
    }

    private void applyRule78Segment(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	double totalProfitAmount = getTotalProfit(islamicCalculatorCO);
	if(totalProfitAmount == 0)
	{
	    return;
	}
	// double totalOutstandingAmount =
	// NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
	double totalOutstandingAmount = ConstantsCommon.NO.equals(islamicCalculatorCO.getTentativeSchedule())
		? NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
		: NumberUtil.toDoubleObj(islamicCalculatorCO.getOutstandingAmountForXIRR());

	totalOutstandingAmount = totalOutstandingAmount + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());

	totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	int noCapitalLines = getnoCapitalLinesInPlan(islamicCalculatorCO);
	if(noCapitalLines == 0)
	{
	    noCapitalLines = 1;
	}

	double equalCapitalInstallAmount = totalOutstandingAmount / noCapitalLines;
	equalCapitalInstallAmount = NumberUtil.round(equalCapitalInstallAmount,
		islamicCalculatorCO.getDealCyDecimalPoint());

	// if there is multiple segment
	int segmentRowCount = islamicCalculatorCO.getTrsPayPlanSegmentStartDatesVO().size();
	int planRowCount = 0;
	double totalAllocatedProfitAmount = 0d;
	if(segmentRowCount > 0)
	{
	    // get the total profit
	    long sumSegmentRowCount = getSumOfRowCount(segmentRowCount);

	    // Date segmentStartDate =
	    // islamicCalculatorCO.getTrsPayPlanSegmentStartDatesVO().get(0).getSTART_DATE();
	    for(int i = 1; i <= segmentRowCount; i++)
	    {

		Date segmentEndDate = islamicCalculatorCO.getMaturityDate();
		if(segmentRowCount != i)
		{
		    segmentEndDate = islamicCalculatorCO.getTrsPayPlanSegmentStartDatesVO().get(i).getSTART_DATE();
		}
		int planCountInSegment = 0;
		// calculate and set the values for this segment installment

		int tempPlanRowNbr = planRowCount;
		do
		{
		    if(tempPlanRowNbr == islamicCalculatorCO.getTrspayplandetVOList().size())
		    {
			break;
		    }
		    if(islamicCalculatorCO.getTrspayplandetVOList().get(tempPlanRowNbr).getVALUE_DATE()
			    .before(segmentEndDate) || segmentRowCount == i)
		    {
			planCountInSegment++;
		    }
		    else
		    {
			break;
		    }
		    tempPlanRowNbr++;
		}while(true);

		int firstLine = 1;
		double newRule78ProfitAmount = totalProfitAmount
			* ((segmentRowCount - (i - 1)) / NumberUtil.toDouble(sumSegmentRowCount));
		newRule78ProfitAmount = NumberUtil.round(newRule78ProfitAmount / planCountInSegment,
			islamicCalculatorCO.getDealCyDecimalPoint());

		for(int j = 1; j <= planCountInSegment; j++)
		{
		    if(islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getVALUE_DATE()
			    .before(segmentEndDate) || segmentRowCount == i)
		    {
			if(firstLine == 1)
			{
			    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
				    .setSEGMENT_START_YN(ConstantsCommon.YES);
			}
			else
			{
			    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
				    .setSEGMENT_START_YN(ConstantsCommon.NO);
			}

			// set profit amount
			islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).setPROFIT_AMT(NumberUtil
				.roundToBigDecimal(newRule78ProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
			islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
				.setPROFIT_AMT_BEFORE_XIRR(NumberUtil.roundToBigDecimal(newRule78ProfitAmount,
					islamicCalculatorCO.getDealCyDecimalPoint()));

			// if profit calculation method is Diminishing Return
			if(IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
				.equals(islamicCalculatorCO.getProfitCalculationMethod()))
			{
			    // set capital amount
			    double capitalAmount = NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getAMOUNT())
				    - newRule78ProfitAmount;
			    capitalAmount = NumberUtil.round(capitalAmount,
				    islamicCalculatorCO.getDealCyDecimalPoint());
			    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).setCAPITAL_AMT(NumberUtil
				    .roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
			}
			else
			// if profit calculation method is Straight line
			{
			    // the installment is not equal in a segment
			    if(ConstantsCommon.NO.equals(islamicCalculatorCO.getEqualSegments()))
			    {
				// set capital amount
				islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
					.setCAPITAL_AMT(NumberUtil.roundToBigDecimal(equalCapitalInstallAmount,
						islamicCalculatorCO.getDealCyDecimalPoint()));
				// set installment amount
				double amount = NumberUtil.toDoubleObj(
					islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getCAPITAL_AMT())
					+ newRule78ProfitAmount;
				amount = NumberUtil.round(amount, islamicCalculatorCO.getDealCyDecimalPoint());
				islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).setAMOUNT(NumberUtil
					.roundToBigDecimal(amount, islamicCalculatorCO.getDealCyDecimalPoint()));
			    }
			    else
			    // if the installment should be equal in segment
			    {
				// set capital amount
				double capitalAmount = NumberUtil.toDoubleObj(
					islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getAMOUNT())
					- newRule78ProfitAmount;
				capitalAmount = NumberUtil.round(capitalAmount,
					islamicCalculatorCO.getDealCyDecimalPoint());
				islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).setCAPITAL_AMT(NumberUtil
					.roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
			    }
			}
			if(IISCommonConstants.PAYMENT_TYPE_SETTLE_PROFIT.equals(
				islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getPAYMENT_TYPE()))
			{
			    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
				    .setCAPITAL_AMT(BigDecimal.valueOf(0d));
			    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
				    .setCHARGE_AMOUNT(BigDecimal.valueOf(0d));
			    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
				    .setPROFIT_ON_CHARGES(BigDecimal.valueOf(0d));

			    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
				    .setINSURANCE_AMOUNT(BigDecimal.valueOf(0d));
			    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
				    .setPROFIT_ON_INSURANCE(BigDecimal.valueOf(0d));

			    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
				    .setAMOUNT(NumberUtil.roundToBigDecimal(newRule78ProfitAmount,
					    islamicCalculatorCO.getDealCyDecimalPoint()));
			}
			else if(!IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT.equals(
				islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getPAYMENT_TYPE()))
			{
			    throw new BOException(MessageCodes.INVALID_LAST_PAYMENT_TYPE);
			}
			islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).setCAPITAL_AMT_BEFORE_XIRR(
				islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getCAPITAL_AMT());
			islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
				.setPRINCIPLE_AMT(NumberUtil.roundToBigDecimal(
					NumberUtil
						.toDoubleObj(islamicCalculatorCO
							.getTrspayplandetVOList().get(planRowCount).getCAPITAL_AMT())
						- NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
							.get(planRowCount).getCHARGE_AMOUNT())
						- NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
							.get(planRowCount).getINSURANCE_AMOUNT()),
					islamicCalculatorCO.getDealCyDecimalPoint()));

			islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
				.setTOTAL_PRINCIPAL_OUTSTANDIG(NumberUtil.roundToBigDecimal(totalOutstandingAmount,
					islamicCalculatorCO.getDealCyDecimalPoint()));
			totalOutstandingAmount -= NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getCAPITAL_AMT());
			totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount,
				islamicCalculatorCO.getDealCyDecimalPoint());
			totalAllocatedProfitAmount += newRule78ProfitAmount;
			totalAllocatedProfitAmount = NumberUtil.round(totalAllocatedProfitAmount,
				islamicCalculatorCO.getDealCyDecimalPoint());

			planRowCount++;
			firstLine++;
			if(planRowCount > islamicCalculatorCO.getTrspayplandetVOList().size())
			{
			    break;
			}
		    }
		    else
		    {
			break;
		    }
		}// end of inner for loop
		 // segmentStartDate = segmentEndDate;

	    }// end of for loop
	}
	else
	// if there is no multiple segment
	{
	    planRowCount = islamicCalculatorCO.getTrspayplandetVOList().size();
	    long sumPlanRowCount = getSumOfRowCount(planRowCount);

	    for(int k = 0; k < planRowCount; k++)
	    {
		double newRule78ProfitAmount = totalProfitAmount * ((planRowCount - k) / (double) sumPlanRowCount);
		newRule78ProfitAmount = NumberUtil.round(newRule78ProfitAmount,
			islamicCalculatorCO.getDealCyDecimalPoint());

		islamicCalculatorCO.getTrspayplandetVOList().get(k).setPROFIT_AMT(NumberUtil
			.roundToBigDecimal(newRule78ProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(k).setPROFIT_AMT_BEFORE_XIRR(NumberUtil
			.roundToBigDecimal(newRule78ProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

		if(IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
			.equals(islamicCalculatorCO.getProfitCalculationMethod()))
		{
		    // set capital amount
		    double capitalAmount = NumberUtil.toDoubleObj(
			    islamicCalculatorCO.getTrspayplandetVOList().get(k).getAMOUNT()) - newRule78ProfitAmount;
		    capitalAmount = NumberUtil.round(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		    islamicCalculatorCO.getTrspayplandetVOList().get(k).setCAPITAL_AMT(
			    NumberUtil.roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

		}
		else
		// if profit calculation method is Straight line
		{
		    if(ConstantsCommon.NO.equals(islamicCalculatorCO.getEqualSegments()))// the
		    // installment
		    // is
		    // not
		    // equal
		    // in
		    // a
		    // segment
		    {
			// set capital amount
			islamicCalculatorCO.getTrspayplandetVOList().get(k).setCAPITAL_AMT(NumberUtil.roundToBigDecimal(
				equalCapitalInstallAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
			// set installment amount
			double amount = NumberUtil
				.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(k).getCAPITAL_AMT())
				+ newRule78ProfitAmount;
			amount = NumberUtil.round(amount, islamicCalculatorCO.getDealCyDecimalPoint());
			islamicCalculatorCO.getTrspayplandetVOList().get(k).setAMOUNT(
				NumberUtil.roundToBigDecimal(amount, islamicCalculatorCO.getDealCyDecimalPoint()));
		    }
		    else
		    // if the installment should be equal in segment
		    {
			// set capital amount
			double capitalAmount = NumberUtil
				.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(k).getAMOUNT())
				- newRule78ProfitAmount;
			capitalAmount = NumberUtil.round(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint());
			islamicCalculatorCO.getTrspayplandetVOList().get(k).setCAPITAL_AMT(NumberUtil
				.roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		    }
		}
		islamicCalculatorCO.getTrspayplandetVOList().get(k).setCAPITAL_AMT_BEFORE_XIRR(
			islamicCalculatorCO.getTrspayplandetVOList().get(k).getCAPITAL_AMT());

		islamicCalculatorCO.getTrspayplandetVOList().get(k).setPRINCIPLE_AMT(NumberUtil.roundToBigDecimal(
			NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(k).getCAPITAL_AMT())
				- NumberUtil.toDoubleObj(
					islamicCalculatorCO.getTrspayplandetVOList().get(k).getCHARGE_AMOUNT())
				- NumberUtil.toDoubleObj(
					islamicCalculatorCO.getTrspayplandetVOList().get(k).getINSURANCE_AMOUNT()),
			islamicCalculatorCO.getDealCyDecimalPoint()));

		islamicCalculatorCO.getTrspayplandetVOList().get(k).setTOTAL_PRINCIPAL_OUTSTANDIG(NumberUtil
			.roundToBigDecimal(totalOutstandingAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		totalOutstandingAmount -= NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(k).getCAPITAL_AMT());
		totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount,
			islamicCalculatorCO.getDealCyDecimalPoint());
		totalAllocatedProfitAmount += newRule78ProfitAmount;
	    }
	}
	planRowCount--;

	// adjust the remaining profit amount at the last line
	// if(totalAllocatedProfitAmount != totalProfitAmount)
	if(BigDecimal.valueOf(totalAllocatedProfitAmount).compareTo(BigDecimal.valueOf(totalProfitAmount)) != 0)

	{
	    double diffAmount = totalProfitAmount - totalAllocatedProfitAmount;
	    diffAmount = diffAmount + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getPROFIT_AMT());
	    diffAmount = NumberUtil.round(diffAmount, islamicCalculatorCO.getDealCyDecimalPoint());

	    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).setPROFIT_AMT(
		    NumberUtil.roundToBigDecimal(diffAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).setPROFIT_AMT_BEFORE_XIRR(
		    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getPROFIT_AMT());

	    diffAmount = diffAmount + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getCAPITAL_AMT());
	    diffAmount = NumberUtil.round(diffAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
		    .setAMOUNT(NumberUtil.roundToBigDecimal(diffAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	}

	// adjust the remaining capital amount at the last line
	if(totalOutstandingAmount != 0d)
	{
	    double amount = totalOutstandingAmount + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getCAPITAL_AMT());
	    amount = NumberUtil.round(amount, islamicCalculatorCO.getDealCyDecimalPoint());
	    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
		    .setCAPITAL_AMT(NumberUtil.roundToBigDecimal(amount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).setCAPITAL_AMT_BEFORE_XIRR(
		    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getCAPITAL_AMT());

	    amount = amount + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getPROFIT_AMT());
	    amount = NumberUtil.round(amount, islamicCalculatorCO.getDealCyDecimalPoint());
	    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount)
		    .setAMOUNT(NumberUtil.roundToBigDecimal(amount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).setPRINCIPLE_AMT(NumberUtil
		    .roundToBigDecimal(
			    NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(planRowCount).getCAPITAL_AMT())
				    - NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
					    .get(planRowCount).getCHARGE_AMOUNT())
				    - NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
					    .get(planRowCount).getINSURANCE_AMOUNT()),
			    islamicCalculatorCO.getDealCyDecimalPoint()));
	}
    }

    private Integer getnoCapitalLinesInPlan(IslamicCalculatorCO islamicCalculatorCO)
    {
	int count = 0;
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if(!IISCommonConstants.PAYMENT_TYPE_SETTLE_PROFIT
		    .equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE())
		    && !IISCommonConstants.PAYMENT_TYPE_PROFIT_CHARGES
			    .equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE()))
	    {
		count++;
	    }
	}
	return count;
    }

    private void applyRule78(IslamicCalculatorCO islamicCalculatorCO)
    {
	// double totalOutstandingAmount =
	// NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())MANOJ ON
	// 24/09/2013
	double totalOutstandingAmount = ConstantsCommon.NO.equals(islamicCalculatorCO.getTentativeSchedule())
		? NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
		: NumberUtil.toDoubleObj(islamicCalculatorCO.getOutstandingAmountForXIRR());

	totalOutstandingAmount = totalOutstandingAmount + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());

	totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	double totalProfitAmount = getTotalProfit(islamicCalculatorCO);
	if(totalProfitAmount == 0)
	{
	    return;
	}
	double totalAllocatedProfitAmount = 0D;
	for(int index = 0; index < islamicCalculatorCO.getTrspayplandetVOList().size(); index++)
	{

	    int rowCount = islamicCalculatorCO.getTrspayplandetVOList().size();

	    long sumRowCount = getSumOfRowCount(rowCount);
	    double newRule78ProfitAmount = totalProfitAmount * ((rowCount - index) / (double) sumRowCount);
	    newRule78ProfitAmount = NumberUtil.round(newRule78ProfitAmount,
		    islamicCalculatorCO.getDealCyDecimalPoint());

	    double pushDowinProfitAmount = 0d;
	    double currentProfitAmount = pushDowinProfitAmount;
	    pushDowinProfitAmount = 0d;

	    double pushDownProfitOnCharges = 0d;
	    double currentProfitOnCharges = pushDownProfitOnCharges + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_ON_CHARGES());
	    double pushDownCharges = 0d;
	    double currentCharges = pushDownCharges + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT());
	    double pushDownProfitOnInsurance = 0d;
	    double currentProfitOnInsurance = pushDownProfitOnInsurance + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_ON_INSURANCE());
	    double pushDownInsurance = 0d;
	    double currentInsurance = pushDownInsurance + NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT());

	    pushDownProfitOnCharges = 0d;
	    pushDownCharges = 0d;
	    pushDownProfitOnInsurance = 0d;
	    pushDownInsurance = 0d;

	    currentProfitOnCharges = NumberUtil.round(currentProfitOnCharges,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    currentCharges = NumberUtil.round(currentCharges, islamicCalculatorCO.getDealCyDecimalPoint());
	    currentProfitOnInsurance = NumberUtil.round(currentProfitOnInsurance,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    currentInsurance = NumberUtil.round(currentInsurance, islamicCalculatorCO.getDealCyDecimalPoint());

	    double installmentAmount = 0d;
	    installmentAmount = NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT());

	    currentProfitAmount = NumberUtil.round(currentProfitAmount + (newRule78ProfitAmount),
		    islamicCalculatorCO.getDealCyDecimalPoint());

	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getPrincipalInLastPayment())
		    && IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			    .equals(islamicCalculatorCO.getProfitCalculationMethod()))
	    {
		installmentAmount = NumberUtil.round(installmentAmount - (NumberUtil.toDoubleObj(
			islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT()) - currentProfitAmount),
			islamicCalculatorCO.getDealCyDecimalPoint());
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setAMOUNT(
			NumberUtil.roundToBigDecimal(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    }

	    if(currentProfitAmount > installmentAmount)
	    {
		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getExcessProfitInNextInstallment()))
		{
		    pushDowinProfitAmount = NumberUtil.round(currentProfitAmount - installmentAmount,
			    islamicCalculatorCO.getDealCyDecimalPoint());
		    currentProfitAmount = installmentAmount;
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(NumberUtil.roundToBigDecimal(
			    installmentAmount - currentProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPUSHDOWN_PROFIT_AFTER_XIRR(NumberUtil
			    .roundToBigDecimal(pushDowinProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		}
		else
		{
		    pushDowinProfitAmount = NumberUtil.round(currentProfitAmount - installmentAmount,
			    islamicCalculatorCO.getDealCyDecimalPoint());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(BigDecimal.valueOf(0d));
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPUSHDOWN_PROFIT_AFTER_XIRR(BigDecimal.valueOf(0D));
		    currentProfitAmount = newRule78ProfitAmount;
		}
	    }
	    else
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(NumberUtil.roundToBigDecimal(
			installmentAmount - currentProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		if(ConstantsCommon.NO.equals(islamicCalculatorCO.getExcessProfitInNextInstallment()))
		{
		    currentProfitAmount = newRule78ProfitAmount;
		}
	    }

	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT(
		    NumberUtil.roundToBigDecimal(currentProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    totalAllocatedProfitAmount += currentProfitAmount;

	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setTOTAL_PRINCIPAL_OUTSTANDIG(
		    NumberUtil.roundToBigDecimal(totalOutstandingAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    totalOutstandingAmount -= NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
	    totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount,
		    islamicCalculatorCO.getDealCyDecimalPoint());

	    if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
		    - currentProfitOnCharges < 0)
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.setPROFIT_ON_CHARGES(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
		pushDownProfitOnCharges = currentProfitOnCharges - NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
	    }
	    else
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_ON_CHARGES(NumberUtil
			.roundToBigDecimal(currentProfitOnCharges, islamicCalculatorCO.getDealCyDecimalPoint()));
	    }
	    if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
		    - currentCharges < 0)
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.setCHARGE_AMOUNT(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
		pushDownCharges = currentCharges - NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
	    }
	    else
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGE_AMOUNT(
			NumberUtil.roundToBigDecimal(currentCharges, islamicCalculatorCO.getDealCyDecimalPoint()));
	    }

	    if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
		    - currentProfitOnInsurance - NumberUtil.toDoubleObj(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT()) < 0)
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.setPROFIT_ON_INSURANCE(NumberUtil
				.roundToBigDecimal(
					NumberUtil
						.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
							.getCAPITAL_AMT())
						- NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
							.get(index).getCHARGE_AMOUNT()),
					islamicCalculatorCO.getDealCyDecimalPoint()));

		pushDownProfitOnInsurance = currentProfitOnInsurance - NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_ON_INSURANCE());
	    }
	    else
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_ON_INSURANCE(NumberUtil
			.roundToBigDecimal(currentProfitOnInsurance, islamicCalculatorCO.getDealCyDecimalPoint()));
	    }
	    if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
		    - currentInsurance - NumberUtil.toDoubleObj(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT()) < 0)
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.setINSURANCE_AMOUNT(NumberUtil
				.roundToBigDecimal(
					NumberUtil
						.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
							.getCAPITAL_AMT())
						- NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
							.get(index).getCHARGE_AMOUNT()),
					islamicCalculatorCO.getDealCyDecimalPoint()));

		pushDownInsurance = currentInsurance - NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT());
	    }
	    else
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_AMOUNT(
			NumberUtil.roundToBigDecimal(currentInsurance, islamicCalculatorCO.getDealCyDecimalPoint()));
	    }

	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPRINCIPLE_AMT(NumberUtil.roundToBigDecimal(
		    NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
			    - NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT())
			    - NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT()),
		    islamicCalculatorCO.getDealCyDecimalPoint()));

	    islamicCalculatorCO.getTrspayplandetVOList().get(index)
		    .setPROFIT_AMT_BEFORE_XIRR(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT_BEFORE_XIRR(
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
	}
	int index = islamicCalculatorCO.getTrspayplandetVOList().size() - 1;

	totalAllocatedProfitAmount = NumberUtil.round(totalAllocatedProfitAmount,
		islamicCalculatorCO.getDealCyDecimalPoint());
	// if(totalProfitAmount != totalAllocatedProfitAmount)
	if(BigDecimal.valueOf(totalProfitAmount).compareTo(BigDecimal.valueOf(totalAllocatedProfitAmount)) != 0)
	{
	    double diffAmount = NumberUtil.round(totalProfitAmount - totalAllocatedProfitAmount,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT(NumberUtil.roundToBigDecimal(
		    NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT())
			    + diffAmount,
		    islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index)
		    .setPROFIT_AMT_BEFORE_XIRR(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());

	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(NumberUtil.roundToBigDecimal(
		    NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
			    - diffAmount,
		    islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT_BEFORE_XIRR(
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPRINCIPLE_AMT(NumberUtil.roundToBigDecimal(
		    NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
			    - NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT())
			    - NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT()),
		    islamicCalculatorCO.getDealCyDecimalPoint()));
	}
    }

    private Double getTotalProfit(IslamicCalculatorCO islamicCalculatorCO)
    {
	double totalProfitAmount = 0.00;
	// double outstandingAmountForXIRR = 0.00;
	for(int index = 0; index < islamicCalculatorCO.getTrspayplandetVOList().size(); index++)
	{
	    totalProfitAmount += NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
	    // outstandingAmountForXIRR +=
	    // NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
	}
	// islamicCalculatorCO.setOutstandingAmountForXIRR(outstandingAmountForXIRR);
	return NumberUtil.round(totalProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
    }

    private Long getSumOfRowCount(Integer rowCount)
    {
	return rowCount.longValue() * (rowCount + 1) / 2;
    }

    /**
     * Calculate the compounding grace period profit
     * 
     * @param islamicCalculatorCO
     * @param periodicity
     * @param periodicityNo
     * @param dateFrom
     * @param dateTo
     * @return
     * @throws BaseException
     */
    private List<TrspayplandetCO> calculateCompoundingProfitGracePeriod(IslamicCalculatorCO islamicCalculatorCO,
	    String periodicity, Long periodicityNo, Date dateFromParam, Date dateTo) throws BaseException
    {
	if(IISCommonConstants.GRACE_COMPOUND_PERIODICITY_GRACE_PERIOD.equals(periodicity) && periodicityNo != 1L)
	{
	    throw new BOException(
		    "Cannot Create Schedule, Compounding Periodicity Number cannot be greater than 1 for Grace period Periodicity ");
	}
	/*
	 * elseif(periodicity.equals(IISCommonConstants.
	 * GRACE_COMPOUND_PERIODICITY_GRACE_PERIOD) &&
	 * islamicCalculatorCO.getCompoundingProfit().equals("B")) { throw new
	 * BOException(
	 * "Cannot Create Schedule, Compounding During Deal Period Not Applicable For Periodicity Grace Period "
	 * ); }
	 */

	Date dateFrom = dateFromParam;

	islamicCalculatorCO.setCompoundingProfit("H");

	BigDecimal ldec_first_line_extra_profit = BigDecimal.ZERO;
	if(islamicCalculatorCO.getDisbursementScreen())
	{
	    dateFrom = islamicCalculatorCO.getOriginalValueDate();

	    TRSPAYPLANDETVOKey trspayplandetvoKey = new TRSPAYPLANDETVOKey();
	    trspayplandetvoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	    trspayplandetvoKey.setBRANCH(islamicCalculatorCO.getBranchCode());
	    trspayplandetvoKey.setPLAN_NBR(islamicCalculatorCO.getPlanNbr());
	    trspayplandetvoKey.setPLAN_SEQ(islamicCalculatorCO.getPlanSeq());
	    // BigDecimal dealNo = islamicCalculatorCO.getDealNo();
	    if(islamicCalculatorCO.getDisbursementScreen())
	    {
		trspayplandetvoKey.setPLAN_NBR(islamicCalculatorCO.getLinkedDealPlanNbr());
		trspayplandetvoKey.setPLAN_SEQ(islamicCalculatorCO.getLinkedDealPlanSeq());
		// dealNo = islamicCalculatorCO.getLinkedDealNo();
	    }

	    if(trspayplandetvoKey.getPLAN_NBR() == null || trspayplandetvoKey.getPLAN_SEQ() == null)
	    {
		throw new BOException(MessageCodes.iis_invalid_code,
			new String[] { "Previous_Linked_Repayment_Plan_Cannot_Found_key" }, false);

	    }

	    List<TRSPAYPLANDETVO> trspayplandetvoList = iisIslamicCalculatorDAO
		    .returnPlanScheduleList(trspayplandetvoKey);
	    for(int i = 0; i < trspayplandetvoList.size(); i++)
	    {
		if(!trspayplandetvoList.get(i).getVALUE_DATE().after(islamicCalculatorCO.getValueDate()))
		{
		    dateFrom = trspayplandetvoList.get(i).getVALUE_DATE();
		}
		else if(dateFrom.compareTo(islamicCalculatorCO.getValueDate()) != 0)
		{
		    BigDecimal ldec_profit_amt = NumberUtil.nullToZero(trspayplandetvoList.get(i).getPROFIT_AMT_NEW());
		    BigDecimal ldec_reimbursed_profit_for_accrual = NumberUtil
			    .nullToZero(trspayplandetvoList.get(i).getREIMBURSED_PROFIT_FOR_ACCRUAL());
		    BigDecimal ll_Days_1 = BigDecimal
			    .valueOf(DateUtil.numberOfDays(dateFrom, trspayplandetvoList.get(i).getVALUE_DATE()));
		    BigDecimal ll_Days_2 = BigDecimal.valueOf(DateUtil.numberOfDays(islamicCalculatorCO.getValueDate(),
			    trspayplandetvoList.get(i).getVALUE_DATE()));
		    ldec_first_line_extra_profit = ldec_profit_amt.subtract(NumberUtil.roundToBigDecimal(
			    (ldec_profit_amt.subtract(ldec_reimbursed_profit_for_accrual))
				    .multiply(ll_Days_2.divide(ll_Days_1, 12, BigDecimal.ROUND_HALF_UP)),
			    islamicCalculatorCO.getDealCyDecimalPoint().intValue()));
		    break;

		}
	    }

	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getDisburs_maintain_indiv_plan_yn()))
	    {
		ldec_first_line_extra_profit = BigDecimal.ZERO;
	    }
	}
	Date nextDate = dateFrom;
	String capitalize = ConstantsCommon.NO;
	// nextDate = dateFrom;
	List<TrspayplandetCO> trspayplandetCompoundingGracePeriod = new ArrayList<TrspayplandetCO>();
	long lineNo = 0L;
	double totalOutstandingAmountForProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance());
	do
	{
	    double profitAmount = 0d;
	    TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
	    lineNo++;

	    String scheculeTypeString = "P";
	    nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(), nextDate,
		    periodicity, periodicityNo, lineNo, "D", null, scheculeTypeString);
	    if(nextDate.before(dateTo))
	    {
		trspayplandetCO.setLINE_NBR(BigDecimal.valueOf(lineNo));
		trspayplandetCO.setVALUE_DATE(nextDate);
		trspayplandetCO.setPAYMENT_TYPE("D");
	    }
	    else
	    {
		break;
	    }
	    Date profitFromDate = dateFrom;
	    if(profitFromDate.before(dateFromParam))
	    {
		profitFromDate = dateFromParam;
	    }
	    totalOutstandingAmountForProfitCalc = NumberUtil.round(totalOutstandingAmountForProfitCalc,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    if(islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() > 0
		    && islamicCalculatorCO.getTrsDealMultipleYieldVO().size() == 0
		    && ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule()))
	    {
		profitAmount = getMultipleDisbursementProfit(islamicCalculatorCO, islamicCalculatorCO.getValueDate(),
			profitFromDate, nextDate, totalOutstandingAmountForProfitCalc, 0L, 0d,
			NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), 0, capitalize);
	    }
	    else if(islamicCalculatorCO.getTrsDealMultipleYieldVO().size() > 0
		    && ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule()))
	    {
		profitAmount = getMultipleYieldProfit(islamicCalculatorCO, islamicCalculatorCO.getValueDate(),
			profitFromDate, nextDate, totalOutstandingAmountForProfitCalc, 0L, 0D, 0, capitalize);
	    }
	    else
	    {
		profitAmount = getProfitAmount(islamicCalculatorCO, profitFromDate, nextDate,
			totalOutstandingAmountForProfitCalc, 0L, 0D,
			NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), 0, capitalize);
	    }
	    if(lineNo == 1)
	    {
		profitAmount = profitAmount + NumberUtil.nullToZero(ldec_first_line_extra_profit).doubleValue();
	    }

	    profitAmount = NumberUtil.round(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    trspayplandetCO.setPROFIT_AMT(
		    NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setACTUAL_PROFIT_AMT(
		    NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setACTUAL_PROFIT_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setPROFIT_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setAMOUNT(BigDecimal.valueOf(0d));
	    trspayplandetCO.setCAPITAL_AMT(
		    NumberUtil.roundToBigDecimal(profitAmount * -1, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setCAPITAL_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(profitAmount * -1, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setPRINCIPLE_AMT(
		    NumberUtil.roundToBigDecimal(profitAmount * -1, islamicCalculatorCO.getDealCyDecimalPoint()));
	    trspayplandetCO.setTOTAL_PRINCIPAL_OUTSTANDIG(BigDecimal.valueOf(0d));

	    trspayplandetCO.setCHARGE_AMOUNT(BigDecimal.valueOf(0d));
	    trspayplandetCO.setPROFIT_ON_CHARGES(BigDecimal.valueOf(0d));
	    trspayplandetCO.setINSURANCE_AMOUNT(BigDecimal.valueOf(0d));
	    trspayplandetCO.setPROFIT_ON_INSURANCE(BigDecimal.valueOf(0d));
	    trspayplandetCO.setPRFT_AMT_PUSHDWN_FRM_ABV_INST(BigDecimal.valueOf(0d));

	    long totalDays = DateUtil.numberOfDays(dateFrom, nextDate);

	    trspayplandetCO.setNO_OF_DAYS(BigDecimal.valueOf(totalDays));

	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule()))
	    {
		if(lineNo == 1L)
		{
		    totalOutstandingAmountForProfitCalc += getDisbursementAmountAsOfDate(islamicCalculatorCO, dateFrom,
			    nextDate) - NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount());
		}
		else
		{
		    totalOutstandingAmountForProfitCalc += getDisbursementAmountAsOfDate(islamicCalculatorCO, dateFrom,
			    nextDate);
		}
	    }
	    totalOutstandingAmountForProfitCalc += profitAmount;
	    islamicCalculatorCO.setTotalGracePeriodCompundingProfit(BigDecimal.valueOf(
		    NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit()) + profitAmount));
	    trspayplandetCompoundingGracePeriod.add(trspayplandetCO);
	    dateFrom = nextDate;
	    if(IISCommonConstants.GRACE_COMPOUND_PERIODICITY_GRACE_PERIOD.equals(periodicity))
	    {
		break;
	    }
	}while(nextDate.before(dateTo));
	printPlan(trspayplandetCompoundingGracePeriod, islamicCalculatorCO);
	islamicCalculatorCO.setTotalGracePeriodCompundingProfit(NumberUtil.roundToBigDecimal(
		NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit()),
		islamicCalculatorCO.getDealCyDecimalPoint()));
	if(!trspayplandetCompoundingGracePeriod.isEmpty())
	{
	    islamicCalculatorCO.setInstallmentCommentsDate(trspayplandetCompoundingGracePeriod
		    .get(trspayplandetCompoundingGracePeriod.size() - 1).getVALUE_DATE());
	}
	String tempcompoundingProfit = islamicCalculatorCO.getCompoundingProfit();
	islamicCalculatorCO.setCompoundingProfit(tempcompoundingProfit);
	return trspayplandetCompoundingGracePeriod;
    }

    private void calculateCapitalizationProfit(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	Date nextDate = islamicCalculatorCO.getCapitalizationStartOn();
	if(nextDate == null)
	{
	    return;
	}
	String periodicity = islamicCalculatorCO.getCapitalizePeriodicity();
	String periodicityPos = islamicCalculatorCO.getCapitalizePeriodicityNopos();
	long periodicityNo = islamicCalculatorCO.getCapitalizePeriodicityNo().longValue();
	Long paymentSetDays = null;
	if(islamicCalculatorCO.getCapitalizePeriodicitySetDay() != null)
	{
	    paymentSetDays = islamicCalculatorCO.getCapitalizePeriodicitySetDay();
	}

	long lineNo = 0;
	Date lastDate = islamicCalculatorCO.getTrspayplandetVOList()
		.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getVALUE_DATE();
	double totalActualOutstandingAmount = NumberUtil
		.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(0).getTOTAL_PRINCIPAL_OUTSTANDIG());
	String capitalize = ConstantsCommon.YES;
	long count = 0L;
	do
	{
	    for(int i = (int) lineNo; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	    {
		if(nextDate.before(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE())
			|| nextDate.equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE()))
		{
		    lineNo = i;
		    break;
		}
	    }

	    TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
	    trspayplandetCO.setLINE_NBR(BigDecimal.valueOf(lineNo));
	    trspayplandetCO.setVALUE_DATE(nextDate);
	    trspayplandetCO.setPAYMENT_TYPE("Z");
	    trspayplandetCO.setAMOUNT(BigDecimal.valueOf(0D));
	    trspayplandetCO.setCAPITAL_AMT_BEFORE_XIRR(BigDecimal.valueOf(0D));
	    trspayplandetCO.setCAPITAL_AMT(BigDecimal.valueOf(0d));
	    trspayplandetCO.setCHARGE_AMOUNT(BigDecimal.valueOf(0d));
	    trspayplandetCO.setPROFIT_ON_CHARGES(BigDecimal.valueOf(0d));
	    trspayplandetCO.setINSURANCE_AMOUNT(BigDecimal.valueOf(0d));
	    trspayplandetCO.setPROFIT_ON_INSURANCE(BigDecimal.valueOf(0d));
	    trspayplandetCO.setPROFIT_AMT_BEFORE_XIRR(BigDecimal.valueOf(0d));
	    trspayplandetCO.setPROFIT_AMT(BigDecimal.valueOf(0d));
	    trspayplandetCO.setDEAL_VALUE_DATE(islamicCalculatorCO.getValueDate());
	    trspayplandetCO.setACTUAL_PROFIT_AMT(BigDecimal.valueOf(0d));
	    trspayplandetCO.setACTUAL_PROFIT_AMT_BEFORE_XIRR(BigDecimal.valueOf(0d));
	    trspayplandetCO.setPRINCIPLE_AMT(BigDecimal.valueOf(0d));

	    islamicCalculatorCO.getTrspayplandetVOList().add((int) lineNo, trspayplandetCO);
	    lineNo++;
	    if(nextDate.compareTo(lastDate) == 0)
	    {
		break;
	    }
	    if(count == 0)
	    {
		if(periodicity.endsWith(IISCommonConstants.MONTH)
			&& IISCommonConstants.MONTH_END.equals(periodicityPos))
		{
		    // nextDate =
		    // DateUtil.getMonthLastDay(nextDate);MANOJMV16102013
		    Date monthLastDate = DateUtil.getMonthLastDay(nextDate);
		    if(nextDate.compareTo(monthLastDate) == 0)
		    {
			nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(),
				nextDate, periodicity, periodicityNo, lineNo, periodicityPos, paymentSetDays, "P");
		    }
		    else
		    {
			nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(),
				nextDate, periodicity, periodicityNo - 1, lineNo, periodicityPos, paymentSetDays, "P");
		    }
		}
		else
		{
		    nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(),
			    nextDate, periodicity, periodicityNo, lineNo, periodicityPos, paymentSetDays, "P");
		}
	    }
	    else
	    {
		nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(), nextDate,
			periodicity, periodicityNo, lineNo, periodicityPos, paymentSetDays, "P");
	    }

	    // nextDate = NumberUtil.dateAdd(DateUtil.DAY, 1L, nextDate);

	    if(nextDate.after(lastDate))
	    {
		nextDate = lastDate;

	    }
	    count++;
	}while(nextDate.before(lastDate) || nextDate.compareTo(lastDate) == 0);

	// Reset the line number
	Date dateFrom = islamicCalculatorCO.getValueDate();
	Date dateTo;
	long newLineNo = 0L;
	double totalOutstandingAmountForProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());
	double profitAmount = 0d;
	double amountAddForProfitCalculation = 0d;
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    dateTo = islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE();
	    long noOfDays = DateUtil.numberOfDays(dateFrom, dateTo);
	    newLineNo += noOfDays + 10L;
	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setLINE_NBR(BigDecimal.valueOf(newLineNo));

	    totalOutstandingAmountForProfitCalc = NumberUtil.round(totalOutstandingAmountForProfitCalc,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    if(islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() > 0
		    && islamicCalculatorCO.getTrsDealMultipleYieldVO().size() == 0
		    && ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule()))
	    {
		profitAmount = getMultipleDisbursementProfit(islamicCalculatorCO, dateFrom, dateFrom, dateTo,
			totalOutstandingAmountForProfitCalc, 0L, amountAddForProfitCalculation,
			NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), 0, capitalize);
	    }
	    else if(islamicCalculatorCO.getTrsDealMultipleYieldVO().size() > 0
		    && ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule()))
	    {
		profitAmount = getMultipleYieldProfit(islamicCalculatorCO, dateFrom, dateFrom, dateTo,
			totalOutstandingAmountForProfitCalc, 0L, amountAddForProfitCalculation, 0, capitalize);
	    }
	    else
	    {
		profitAmount = getProfitAmount(islamicCalculatorCO, dateFrom, dateTo,
			totalOutstandingAmountForProfitCalc, 0L, 0d,
			NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), 0, capitalize);
	    }
	    profitAmount = NumberUtil.round(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint());

	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setACTUAL_PROFIT_AMT(
		    NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setNO_OF_DAYS(BigDecimal.valueOf(noOfDays));

	    if("Z".equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE()))
	    {
		for(int j = i - 1; j >= 0; j--)
		{
		    if("Z".equals(islamicCalculatorCO.getTrspayplandetVOList().get(j).getPAYMENT_TYPE()))
		    {
			break;
		    }

		    profitAmount += NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(j).getACTUAL_PROFIT_AMT());
		}
		profitAmount = NumberUtil.round(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setMONTHLY_CAPITALIZED_PROFIT_AMT(
			NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setTOTAL_PRINCIPAL_OUTSTANDIG(NumberUtil
			.roundToBigDecimal(totalActualOutstandingAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		totalActualOutstandingAmount += profitAmount;
		totalOutstandingAmountForProfitCalc += profitAmount;
		amountAddForProfitCalculation -= profitAmount;
	    }
	    else
	    {
		for(int j = i - 1; j >= 0; j--)
		{
		    if(!"Z".equals(islamicCalculatorCO.getTrspayplandetVOList().get(j).getPAYMENT_TYPE())
			    && !"F".equals(islamicCalculatorCO.getTrspayplandetVOList().get(j).getPAYMENT_TYPE())
			    && !"L".equals(islamicCalculatorCO.getTrspayplandetVOList().get(j).getPAYMENT_TYPE())
			    && !"R".equals(islamicCalculatorCO.getTrspayplandetVOList().get(j).getPAYMENT_TYPE())
			    && !"T".equals(islamicCalculatorCO.getTrspayplandetVOList().get(j).getPAYMENT_TYPE()))
		    {
			break;
		    }
		    profitAmount += NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(j).getACTUAL_PROFIT_AMT());
		}
		islamicCalculatorCO.getTrspayplandetVOList().get(i)
			.setMONTHLY_CAPITALIZED_PROFIT_AMT(BigDecimal.valueOf(0D));

		profitAmount = NumberUtil.round(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT(
			NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setPROFIT_AMT_BEFORE_XIRR(
			NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

		double capitalAmount = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT()) - profitAmount;
		capitalAmount = NumberUtil.round(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT(
			NumberUtil.roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setCAPITAL_AMT_BEFORE_XIRR(
			NumberUtil.roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

		capitalAmount = capitalAmount
			- NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCHARGE_AMOUNT())
			- NumberUtil
				.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getINSURANCE_AMOUNT());
		capitalAmount = NumberUtil.round(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setPRINCIPLE_AMT(
			NumberUtil.roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

		islamicCalculatorCO.getTrspayplandetVOList().get(i)
			.setTOTAL_PRINCIPAL_OUTSTANDIG(BigDecimal.valueOf(totalActualOutstandingAmount));

		totalActualOutstandingAmount -= NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT());
		double tempChargesOnProfit = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCHARGE_AMOUNT())
			+ NumberUtil
				.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getINSURANCE_AMOUNT());
		tempChargesOnProfit -= (NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_ON_CHARGES())
			+ NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_ON_INSURANCE()));

		totalOutstandingAmountForProfitCalc -= (NumberUtil.toDoubleObj(
			islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT()) - tempChargesOnProfit);

	    }
	    totalActualOutstandingAmount = NumberUtil.round(totalActualOutstandingAmount,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    totalOutstandingAmountForProfitCalc = NumberUtil.round(totalOutstandingAmountForProfitCalc,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    dateFrom = dateTo;
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule()))
	    {
		if(lineNo == 1L)
		{
		    totalOutstandingAmountForProfitCalc += getDisbursementAmountAsOfDate(islamicCalculatorCO, dateFrom,
			    nextDate) - NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount());
		}
		else
		{
		    totalOutstandingAmountForProfitCalc += getDisbursementAmountAsOfDate(islamicCalculatorCO, dateFrom,
			    nextDate);
		}
	    }
	}
	// Adjusting the Residual value
	if(totalActualOutstandingAmount != 0D)
	{
	    int index = islamicCalculatorCO.getTrspayplandetVOList().size() - 1;
	    double tempAmount = NumberUtil.toDoubleObj(
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT()) + totalActualOutstandingAmount;
	    tempAmount = NumberUtil.round(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    islamicCalculatorCO.getTrspayplandetVOList().get(index)
		    .setAMOUNT(NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    tempAmount = NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
		    + totalActualOutstandingAmount;
	    tempAmount = NumberUtil.round(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(
		    NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    tempAmount -= (NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT())
		    + NumberUtil.toDoubleObj(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPRINCIPLE_AMT(
		    NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	}
    }

    /**
     * create installment details
     * 
     * @param islamicCalculatorCO
     * @param changeEffectLineNo
     * @return
     * @throws BaseException
     */
    private IslamicCalculatorCO calculatePlanInstallmentDetails(IslamicCalculatorCO islamicCalculatorCO,
	    Integer changeEffectLineNoParam) throws BaseException
    {
	Integer changeEffectLineNo = changeEffectLineNoParam;
	// setPlanInstallmentDetailsDiminishing
	String equalizeInstallment = ConstantsCommon.YES;
	// String roundingApplicable = ConstantsCommon.YES;
	int noOfInstallment = islamicCalculatorCO.getTrspayplandetVOList().size();
	int noOfexclCalcLines = 0;
	double totalDealAmount = 0d;
	double totalAllocatedPrincipelAmount = 0D;
	double totalAllocatedProfitAmount = 0D;
	double priviousYieldPercent = NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild());
	String tempTentativeSchedule = islamicCalculatorCO.getTentativeSchedule();
	String capitalize = ConstantsCommon.NO;
	long dealCyDecimalPoint = islamicCalculatorCO.getDealCyDecimalPoint();
	int noOfInstallmentAsBalloon = getNoOfInstallmentAsBalloon(islamicCalculatorCO, changeEffectLineNo);
	double totalpreviousAllocatedProfit = 0D;
	double totalVatAmount = 0d;
	double totalAllocatedVatAmount = 0d;
	boolean equalInstallmentForDisbursementPlan = false;
	int index = 0;
	islamicCalculatorCO.setCurrentLineNo(BigDecimal.valueOf(-1));
	islamicCalculatorCO.setFirstLoop(true);
	boolean exitLoop1 = false;
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEXCLUDE_PASTDUE_AT_RESCHDL_YN())) 
	{
		for (int m = 0; m < islamicCalculatorCO.getTrspayplandetVOList().size() ; m++) {
			if (ConstantsCommon.YES.equals(islamicCalculatorCO.getTrspayplandetVOList().get(m).getExcludeRescheduleYn())){
				noOfexclCalcLines = ++noOfexclCalcLines;	
			}
		}
	}


	do
	{
	    if(islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() > 0
		    && !equalInstallmentForDisbursementPlan
		    && (ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule())
			    || ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement())))
	    // &&
	    // islamicCalculatorCO.getEqualInstallmentForDisbursement().equals(ConstantsCommon.YES)))
	    {
		// getDealAmount(islamicCalculatorCO, changeEffectLineNo);
		getDealAmount(islamicCalculatorCO, islamicCalculatorCO.getChangeEffectLineNo());
		islamicCalculatorCO.setTentativeSchedule(ConstantsCommon.YES);
	    }

	    double pmtAmount = 0D;
	    double totalOutstandingAmount = NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
		    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
		    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
		    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());
	    totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount,
		    islamicCalculatorCO.getDealCyDecimalPoint());

	    double chargesExcludingProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
		    - NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges());
	    double insuranceExcludingProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
		    - NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance());

	    IslamicCalculatorStructurePlanDetCO strAllocatedDet = new IslamicCalculatorStructurePlanDetCO();

	    if(changeEffectLineNo > 0)
	    {
		strAllocatedDet = getAllocatedDetails(islamicCalculatorCO, changeEffectLineNo - 1);

		chargesExcludingProfitCalc -= strAllocatedDet.getTotalChargesExcludeProfitCalc();
		insuranceExcludingProfitCalc -= strAllocatedDet.getTotalInsuranceExcludeProfitCalc();
	    }
	    chargesExcludingProfitCalc = NumberUtil.round(chargesExcludingProfitCalc,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    insuranceExcludingProfitCalc = NumberUtil.round(insuranceExcludingProfitCalc,
		    islamicCalculatorCO.getDealCyDecimalPoint());

	    double chargesAndInsuranceExcludingProfitCalc = (chargesExcludingProfitCalc + insuranceExcludingProfitCalc);
	    chargesAndInsuranceExcludingProfitCalc = NumberUtil.round(chargesAndInsuranceExcludingProfitCalc,
		    islamicCalculatorCO.getDealCyDecimalPoint());

	    double totalDealMonths = iisCommonBO.getMonthsAndDayDifferance(islamicCalculatorCO.getValueDate(),
		    islamicCalculatorCO.getMaturityDate());

	    double principelAmountForRedusingBalanceMethod = 0D;
	    double linechargesExcludingProfitCalc = chargesExcludingProfitCalc / (noOfInstallment - changeEffectLineNo);
	    double lineinsuranceExcludingProfitCalc = insuranceExcludingProfitCalc
		    / (noOfInstallment - changeEffectLineNo);
	    double prevousDiffAmount = 0D;
	    double prevousActualLineDiffAmount = 0D;
	    double prevousActualDiffAmount = 0d;
	    double prevousPMTAmount = 0d;

	    double totalProfitAmount = 0D;
	    double origChargesAndInsuranceExcludingProfitCalc = chargesAndInsuranceExcludingProfitCalc;

	    boolean finalAdjustment = false;

	    Date nextprofitChangeDate = getNextprofitRateChangeDate(islamicCalculatorCO);
	    Date nextprofitChangeEfffectiveDate = getNextprofitRateChangeEffectiveDate(islamicCalculatorCO,
		    nextprofitChangeDate);
	    Date periodFrom = islamicCalculatorCO.getInstallmentCommentsDate();
	    totalpreviousAllocatedProfit = 0d;
	    /**
	     * if reschedule with no recalculate treate this as Stateline
	     */
	    if(IISCommonConstants.RESCHEDULE_TYPE_NO_RECALCULATE.equals(islamicCalculatorCO.getRescheduleType()))
	    {
		islamicCalculatorCO
			.setProfitCalculationMethod(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE);
	    }
	    if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		    .equals(islamicCalculatorCO.getProfitCalculationMethod()))
	    {
		equalizeInstallment = ConstantsCommon.NO;
		if((ConstantsCommon.NO.equals(islamicCalculatorCO.getProfitCalculateAsOnYieldDate())
			|| ConstantsCommon.NO.equals(islamicCalculatorCO.getMultipleYieldEqualiseFromValueDate()))
			&& (NumberUtil.toDouble(priviousYieldPercent) != NumberUtil
				.toDouble(islamicCalculatorCO.getAnnualYeild())
				&& NumberUtil.toInt(changeEffectLineNo) > 0))
		{

		    periodFrom = islamicCalculatorCO.getTrspayplandetVOList().get(changeEffectLineNo - 1)
			    .getVALUE_DATE();
		    totalpreviousAllocatedProfit = strAllocatedDet.getTotalAllocatedProfit();
		}

		if(IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit())
			|| IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit()))
		{
		    totalProfitAmount = 0d;
		}
		else
		{
		    if(IISCommonConstants.RESCHEDULE_TYPE_NO_RECALCULATE
			    .equals(islamicCalculatorCO.getRescheduleType()))
		    {
			totalProfitAmount = NumberUtil.toDoubleObj(islamicCalculatorCO.getOutstandingProfit());
		    }
		    else
		    {

			totalProfitAmount = getProfitAmount(islamicCalculatorCO, periodFrom,
				islamicCalculatorCO.getMaturityDate(),
				NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
					+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
					+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
					+ NumberUtil
						.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit()),
				0L,
				(NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
					- NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges()))
					+ (NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
						- NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance())),
				NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), 0, capitalize);
		    }
		    totalProfitAmount = NumberUtil.round(
			    totalProfitAmount + NumberUtil
				    .nullToZero(islamicCalculatorCO.getFirstLineProfitToBeAdjust()).doubleValue(),
			    islamicCalculatorCO.getDealCyDecimalPoint());
		    long noOfStrighLineInstallment = getStrighLineInstallmentCount(islamicCalculatorCO,
			    changeEffectLineNo);
		    // noOfStrighLineInstallment = 6;
		    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment())
			    && ConstantsCommon.NO.equals(islamicCalculatorCO.getCalculateVatAfterSchedule()))
		    {
			totalVatAmount = calculateVatAmount(islamicCalculatorCO, 0d, totalProfitAmount,
				ConstantsCommon.NO);
			islamicCalculatorCO.setTotalVatAmount(totalVatAmount);
		    }
		    /***
		     * Manoj on 27/09/2012
		     * 
		     */
		    if(noOfStrighLineInstallment == 0)
		    {
			noOfStrighLineInstallment = 1;
		    }
		    if(islamicCalculatorCO.getTrsPayPlanCriteriaVO().size() > 0
			    || NumberUtil.nullToZero(islamicCalculatorCO.getTemplateCode()).intValue() > 0)
		    {
			double totalAmount = totalOutstandingAmount + totalProfitAmount + totalVatAmount;
			totalAmount = totalAmount - NumberUtil.nullToZero(strAllocatedDet.getTotalAllocatedProfit())
				- NumberUtil.nullToZero(strAllocatedDet.getAllocatedCapitalAmount())
				- NumberUtil.nullToZero(strAllocatedDet.getAllocatedVatAmount());
			noOfInstallmentAsBalloon = getNoOfInstallmentAsBalloon(islamicCalculatorCO, changeEffectLineNo);
			double divisor = noOfInstallment - changeEffectLineNo + noOfInstallmentAsBalloon;
			if(divisor <= 0)
			{
			    divisor = 1;
			}

			pmtAmount = (totalAmount / (divisor));
		    }
		    else
		    {
			double divisor = noOfStrighLineInstallment - changeEffectLineNo + noOfInstallmentAsBalloon;
			if(divisor <= 0)
			{
			    divisor = 1;
			}
			pmtAmount = (totalOutstandingAmount + totalProfitAmount + totalVatAmount
				- NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalBalloonAmount())) / (divisor);
		    }

		    // pmtAmount = (totalOutstandingAmount + totalProfitAmount +
		    // totalVatAmount - NumberUtil
		    // .toDoubleObj(islamicCalculatorCO.getTotalBalloonAmount()))
		    // / (noOfStrighLineInstallment - changeEffectLineNo +
		    // noOfInstallmentAsBalloon);

		    pmtAmount = NumberUtil.round(pmtAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		    totalProfitAmount = totalProfitAmount + totalpreviousAllocatedProfit;
		    totalProfitAmount = NumberUtil.round(totalProfitAmount,
			    islamicCalculatorCO.getDealCyDecimalPoint());

		}
		if(NumberUtil.toDoubleObj(islamicCalculatorCO.getAmountPerPayment()) > 0D)
		{
		    equalizeInstallment = ConstantsCommon.NO;
		    // roundingApplicable = ConstantsCommon.NO;
		}
	    }
	    else
	    {
		if(NumberUtil.toDoubleObj(islamicCalculatorCO.getAmountPerPayment()) > 0D)
		{
		    if(islamicCalculatorCO.getTrsDealMultipleYieldVO().size() == 0)
		    {
			equalizeInstallment = ConstantsCommon.NO;
		    }
		    // islamicCalculatorCO.setProfitCalculateAsOnYieldDate(ConstantsCommon.YES);
		    // roundingApplicable = ConstantsCommon.NO;
		}

		else
		{
		    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getRedusingBalanceMethod()))
		    {
			/*
			 * if the interest calculation is residuing balance
			 * method the the principle will be the equal amount
			 */
			principelAmountForRedusingBalanceMethod = totalOutstandingAmount
				/ (noOfInstallment + noOfInstallmentAsBalloon);
			principelAmountForRedusingBalanceMethod = NumberUtil.round(
				principelAmountForRedusingBalanceMethod, islamicCalculatorCO.getDealCyDecimalPoint());
			equalizeInstallment = ConstantsCommon.NO;
			// roundingApplicable = ConstantsCommon.NO;
		    }
		    else
		    {
			/**
			 * if the rate is 0 no needt to calculate profit and
			 * all. pmt = out staning/ number of payment
			 */
			if(NumberUtil.toDouble(islamicCalculatorCO.getAnnualYeild()) == 0)
			{
			    pmtAmount = totalOutstandingAmount
				    / Long.valueOf(noOfInstallment + noOfInstallmentAsBalloon);
			}
			else
			{

			    if(NumberUtil.toInt(islamicCalculatorCO.getProfitAccrualBasis()) == 3)
			    {
				// Accruals basis = 365/31
				pmtAmount = calculatePMTAmount365By31(islamicCalculatorCO,
					NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()),
					(long) noOfInstallment, totalOutstandingAmount,
					Long.valueOf(noOfInstallment + noOfInstallmentAsBalloon));
			    }
			    else
			    {
				pmtAmount = calculatePMTAmount360By30(islamicCalculatorCO,
					NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()),
					(long) noOfInstallment, totalOutstandingAmount,
					Long.valueOf(noOfInstallment + noOfInstallmentAsBalloon));
			    }
			}
			pmtAmount = NumberUtil.round(pmtAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		    }
		}
	    }
	    if(ConstantsCommon.NO.equals(islamicCalculatorCO.getApplyRoundingFact_after_calc()))
	    {
		pmtAmount = roundPmtAmount(islamicCalculatorCO, pmtAmount, islamicCalculatorCO.getRoundingFactor());
	    }

	    double capitalAmount = 0D;
	    double pushDownProfitAmount = 0D;
	    totalAllocatedPrincipelAmount = 0D;
	    totalAllocatedProfitAmount = 0D;
	    totalDealAmount = totalOutstandingAmount;
	    boolean equalizeEnd = false;
	    int loopCount = 0;
	    index = 0;
	    islamicCalculatorCO.setCurrentLineNo(BigDecimal.valueOf(-1));
	    int equalizationCount = 0;
	    int maxEqualizationCount = 250;

	    do
	    {
		if(NumberUtil.toInteger(islamicCalculatorCO.getProfitAccrualBasis()) == 5L
			&& ConstantsCommon.YES.equals(islamicCalculatorCO.getMultipleYieldEqualiseFromValueDate()))
		{
		    islamicCalculatorCO.setAvgDaysInYearsForProfitCalculation(
			    BigDecimal.valueOf(getAverageYearDaysInDealPeriod(islamicCalculatorCO.getValueDate(),
				    islamicCalculatorCO.getMaturityDate())));
		}
		double totalOutstandingAmountForProfitCalc = totalOutstandingAmount;
		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement()))
		{
		    totalOutstandingAmountForProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
			    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
			    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());
		}
		chargesAndInsuranceExcludingProfitCalc = origChargesAndInsuranceExcludingProfitCalc;
		loopCount++;

		// Loop for Equalize the installment
		index = 0;
		islamicCalculatorCO.setCurrentLineNo(BigDecimal.valueOf(-1));
		totalOutstandingAmount = totalDealAmount;
		Date prviousDate = islamicCalculatorCO.getInstallmentCommentsDate();
		long noOfInstallmentForEqualize = 0L;
		totalAllocatedPrincipelAmount = 0D;
		totalAllocatedProfitAmount = 0D;
		totalAllocatedVatAmount = 0D;
		double cumAllocatedInsuranceExcludingProfitCalc = 0D;
		double cumAllocatedChargesExcludingProfitCalc = 0D;
		long chargeslineCount = 0L;
		long insurancelineCount = 0L;

		islamicCalculatorCO.getTrspayplandetCompoundingDealPeriod().clear();
		for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
		{
		    islamicCalculatorCO.setCurrentLineNo(BigDecimal.valueOf(index));
		    if(index == 0 && islamicCalculatorCO.getRescheduleType().equals(
				    IISCommonConstants.RESCHEDULE_TYPE_ADVANCE_PRINCIPAL_SETTL))
		    {
			trspayplandetCO
				.setPRFT_AMT_PUSHDWN_FRM_ABV_INST(islamicCalculatorCO.getFirstLineProfitToBeAdjust());
		    }
		    Date curDate = trspayplandetCO.getVALUE_DATE();
		    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement())
			    && !equalInstallmentForDisbursementPlan)
		    {
			if(index == 0)
			{
			    if(islamicCalculatorCO.getValueDate().compareTo(curDate) == 0)
			    {
				totalOutstandingAmountForProfitCalc += NumberUtil.toDoubleObj(
					islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(0).getAMOUNT());
			    }
			    else
			    {
				totalOutstandingAmountForProfitCalc += getDisbursementAmountAsOfDate(
					islamicCalculatorCO, islamicCalculatorCO.getValueDate(), curDate);
			    }
			}
			else
			{
			    totalOutstandingAmountForProfitCalc += getDisbursementAmountAsOfDate(islamicCalculatorCO,
				    prviousDate, curDate);
			    if(prviousDate.equals(islamicCalculatorCO.getValueDate()))
			    {
				totalOutstandingAmountForProfitCalc -= NumberUtil.toDoubleObj(
					islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(0).getAMOUNT());
			    }
			}
			totalOutstandingAmountForProfitCalc = NumberUtil.round(totalOutstandingAmountForProfitCalc,
				islamicCalculatorCO.getDealCyDecimalPoint());

		    }
		    IslamicCalculatorStructurePlanDetCO structurePlanDet = new IslamicCalculatorStructurePlanDetCO();

		    // if(islamicCalculatorCO.getTrspayplandetVOList().get(changeEffectLineNo).getPAYMENT_TYPE().equals("P")
		    if((IISCommonConstants.PAYMENT_TYPE_SETTLE_PROFIT.equals(
			    islamicCalculatorCO.getTrspayplandetVOList().get(changeEffectLineNo).getPAYMENT_TYPE())
			    || IISCommonConstants.PAYMENT_TYPE_UPFRONT_PROFIT.equals(islamicCalculatorCO
				    .getTrspayplandetVOList().get(changeEffectLineNo).getPAYMENT_TYPE())
			    || IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL.equals(islamicCalculatorCO
				    .getTrspayplandetVOList().get(changeEffectLineNo).getPAYMENT_TYPE()))
			    && (!islamicCalculatorCO.isFirstLoop()))
		    {
			if(index == changeEffectLineNo + 1
				// && nextprofitChangeDate.after(curDate) //on
				// 18/09/2013 Manoj
				&& (nextprofitChangeEfffectiveDate.after(curDate)
					|| nextprofitChangeEfffectiveDate.equals(curDate)) // on
											   // 18/09/2013
											   // Manoj
				&& (ConstantsCommon.NO.equals(islamicCalculatorCO.getProfitCalculateAsOnYieldDate())
					|| ConstantsCommon.NO
						.equals(islamicCalculatorCO.getMultipleYieldEqualiseFromValueDate())))
			{
			    changeEffectLineNo = index;
			}
			else if(index == changeEffectLineNo + 1
				&& (ConstantsCommon.YES.equals(islamicCalculatorCO.getProfitCalculateAsOnYieldDate())
					|| ConstantsCommon.YES
						.equals(islamicCalculatorCO.getMultipleYieldEqualiseFromValueDate())))
			{
			    changeEffectLineNo = index;
			}
		    }
		    if(index < changeEffectLineNo)
		    {
			/*
			 * if(islamicCalculatorCO.getProfitCalculationMethod().
			 * equals ("S")) {
			 * islamicCalculatorCO.getTrspayplandetVOList().
			 * get(index).setTOTAL_PRINCIPAL_OUTSTANDIG( new
			 * BigDecimal
			 * (NumberUtil.toDoubleObj(islamicCalculatorCO.
			 * getDealAmount()) +
			 * NumberUtil.toDoubleObj(islamicCalculatorCO
			 * .getTotalCharges()) +
			 * NumberUtil.toDoubleObj(islamicCalculatorCO
			 * .getTotalInsurance()) +
			 * NumberUtil.toDoubleObj(islamicCalculatorCO
			 * .getTotalGracePeriodCompundingProfit()))); } else {
			 * if (islamicCalculatorCO.
			 * getEqualInstallmentForDisbursement
			 * ().equals(ConstantsCommon.YES)) {
			 * islamicCalculatorCO.getTrspayplandetVOList
			 * ().get(index).setTOTAL_PRINCIPAL_OUTSTANDIG( new
			 * BigDecimal(totalOutstandingAmountForProfitCalc)); }
			 * else {
			 * islamicCalculatorCO.getTrspayplandetVOList().get
			 * (index).setTOTAL_PRINCIPAL_OUTSTANDIG( new
			 * BigDecimal(totalOutstandingAmount)); } }
			 */

			if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement())
				&& equalInstallmentForDisbursementPlan)
			{
			    totalOutstandingAmountForProfitCalc = totalOutstandingAmount;
			}
			structurePlanDet = getCurrentLineDetails(islamicCalculatorCO, index);

			totalAllocatedProfitAmount = totalAllocatedProfitAmount + structurePlanDet.getProfitAmount();
			totalAllocatedProfitAmount = NumberUtil.round(totalAllocatedProfitAmount,
				islamicCalculatorCO.getDealCyDecimalPoint());
			pushDownProfitAmount = structurePlanDet.getPushDownProfitAmount();
			capitalAmount = structurePlanDet.getPrincipleAmount();

			totalOutstandingAmount = totalOutstandingAmount - (capitalAmount);
			totalOutstandingAmountForProfitCalc -= capitalAmount;

			totalAllocatedPrincipelAmount = totalAllocatedPrincipelAmount + capitalAmount;
			totalAllocatedPrincipelAmount = NumberUtil.round(totalAllocatedPrincipelAmount,
				islamicCalculatorCO.getDealCyDecimalPoint());
			totalAllocatedVatAmount = NumberUtil.round(
				totalAllocatedVatAmount + structurePlanDet.getVatAmount(),
				islamicCalculatorCO.getDealCyDecimalPoint());

		    }
		    else
		    {
			if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement())
				&& equalInstallmentForDisbursementPlan)
			{
			    totalOutstandingAmountForProfitCalc = totalOutstandingAmount;
			}
			if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
				.equals(islamicCalculatorCO.getProfitCalculationMethod()))
			{
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).setTOTAL_PRINCIPAL_OUTSTANDIG(
				    BigDecimal.valueOf(NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
					    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
					    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
					    + NumberUtil.toDoubleObj(
						    islamicCalculatorCO.getTotalGracePeriodCompundingProfit())));
			}
			else
			{
			    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement()))
			    {
				islamicCalculatorCO.getTrspayplandetVOList().get(index).setTOTAL_PRINCIPAL_OUTSTANDIG(
					BigDecimal.valueOf(totalOutstandingAmountForProfitCalc));
			    }
			    else
			    {
				islamicCalculatorCO.getTrspayplandetVOList().get(index)
					.setTOTAL_PRINCIPAL_OUTSTANDIG(BigDecimal.valueOf(totalOutstandingAmount));
			    }
			}
			if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
				.equals(islamicCalculatorCO.getProfitCalculationMethod()) && loopCount > 1
				&& !IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT.equals(
					islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE()))
			{
			    structurePlanDet = getCurrentLineDetails(islamicCalculatorCO, index);
			}
			else
			{

			    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement())
				    && equalInstallmentForDisbursementPlan && index == 0)
			    {

				structurePlanDet = setInstallmentValues(islamicCalculatorCO, trspayplandetCO,
					NumberUtil.toDoubleObj(
						islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT()),
					index, principelAmountForRedusingBalanceMethod, noOfInstallment,
					pushDownProfitAmount, prviousDate, totalOutstandingAmount, totalDealAmount,
					chargesAndInsuranceExcludingProfitCalc, changeEffectLineNo,
					totalOutstandingAmountForProfitCalc);
			    }
			    else
			    {

				structurePlanDet = setInstallmentValues(islamicCalculatorCO, trspayplandetCO, pmtAmount,
					index, principelAmountForRedusingBalanceMethod, noOfInstallment,
					pushDownProfitAmount, prviousDate, totalOutstandingAmount, totalDealAmount,
					chargesAndInsuranceExcludingProfitCalc, changeEffectLineNo,
					totalOutstandingAmountForProfitCalc);
			    }
			}
			pushDownProfitAmount = structurePlanDet.getPushDownProfitAmount();
			totalOutstandingAmount = structurePlanDet.getTotalOutstandingAmount();
			capitalAmount = structurePlanDet.getPrincipleAmount();

			noOfInstallmentForEqualize = noOfInstallmentForEqualize
				+ structurePlanDet.getNoOfInstallmentForEqualize();

			totalAllocatedProfitAmount = totalAllocatedProfitAmount + structurePlanDet.getProfitAmount();
			totalAllocatedProfitAmount = NumberUtil.round(totalAllocatedProfitAmount,
				islamicCalculatorCO.getDealCyDecimalPoint());
			totalAllocatedVatAmount = NumberUtil.round(
				totalAllocatedVatAmount + structurePlanDet.getVatAmount(),
				islamicCalculatorCO.getDealCyDecimalPoint());

			if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
				.equals(islamicCalculatorCO.getProfitCalculationMethod())
				&& (islamicCalculatorCO.getCompoundingProfit().equals(ConstantsCommon.NO)
					|| IISCommonConstants.COMPOUND_PROFIT_GRACE
						.equals(islamicCalculatorCO.getCompoundingProfit())))
			{
			    if(totalProfitAmount - totalAllocatedProfitAmount < 0D)
			    {
				double diff = NumberUtil.round(totalProfitAmount - totalAllocatedProfitAmount,
					islamicCalculatorCO.getDealCyDecimalPoint());
				capitalAmount = NumberUtil.round(NumberUtil.toDoubleObj(
					islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
					- diff, islamicCalculatorCO.getDealCyDecimalPoint());
				structurePlanDet
					.setProfitAmount(NumberUtil.round(structurePlanDet.getProfitAmount() + diff,
						islamicCalculatorCO.getDealCyDecimalPoint()));
				islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT(NumberUtil
					.roundToBigDecimal(structurePlanDet.getProfitAmount(), dealCyDecimalPoint));
				islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(
					NumberUtil.roundToBigDecimal(capitalAmount, dealCyDecimalPoint));
				totalAllocatedProfitAmount = totalProfitAmount;
			    }
			    if(totalOutstandingAmount == 0D)
			    {
				islamicCalculatorCO.getTrspayplandetVOList().get(index)
					.setCAPITAL_AMT(BigDecimal.valueOf(0D));
				islamicCalculatorCO.getTrspayplandetVOList().get(index)
					.setAMOUNT(NumberUtil.roundToBigDecimal(
						structurePlanDet.getProfitAmount() + structurePlanDet.getVatAmount(),
						islamicCalculatorCO.getDealCyDecimalPoint()));
				capitalAmount = 0D;
			    }
			    else
			    {
				totalOutstandingAmount = totalOutstandingAmount - (capitalAmount);
				totalOutstandingAmountForProfitCalc -= capitalAmount;
			    }

			    if(totalOutstandingAmount < 0D
				    && (totalProfitAmount - totalAllocatedProfitAmount) > structurePlanDet
					    .getInstallmentAmount())
			    {
				capitalAmount = NumberUtil.round(capitalAmount + totalOutstandingAmount,
					islamicCalculatorCO.getDealCyDecimalPoint());
				totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount,
					islamicCalculatorCO.getDealCyDecimalPoint());
				islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(
					NumberUtil.roundToBigDecimal(capitalAmount, dealCyDecimalPoint));
				islamicCalculatorCO.getTrspayplandetVOList().get(index)
					.setAMOUNT(NumberUtil.roundToBigDecimal(
						capitalAmount + structurePlanDet.getProfitAmount()
							+ structurePlanDet.getVatAmount(),
						islamicCalculatorCO.getDealCyDecimalPoint()));
				totalOutstandingAmount = 0D;
				equalizeInstallment = ConstantsCommon.NO;
			    }
			}

			else
			{
			    totalOutstandingAmount = totalOutstandingAmount - (capitalAmount);
			    totalOutstandingAmountForProfitCalc -= capitalAmount;
			}

			// Added on 20/05/2014
			if(totalOutstandingAmount < 0
				&& NumberUtil.toDouble(islamicCalculatorCO.getAmountPerPayment()) > 0)
			{
			    capitalAmount = capitalAmount + totalOutstandingAmount;
			    islamicCalculatorCO.getTrspayplandetVOList().get(index)
				    .setCAPITAL_AMT(NumberUtil.roundToBigDecimal(capitalAmount, dealCyDecimalPoint));
			    islamicCalculatorCO.getTrspayplandetVOList().get(index)
				    .setAMOUNT(
					    NumberUtil.roundToBigDecimal(
						    structurePlanDet.getProfitAmount() + structurePlanDet.getVatAmount()
							    + capitalAmount,
						    islamicCalculatorCO.getDealCyDecimalPoint()));
			    totalOutstandingAmount = 0d;

			}

			totalAllocatedPrincipelAmount = totalAllocatedPrincipelAmount + capitalAmount;
			totalAllocatedPrincipelAmount = NumberUtil.round(totalAllocatedPrincipelAmount,
				islamicCalculatorCO.getDealCyDecimalPoint());

			double lineAllocatedCharges = 0D;

			if(linechargesExcludingProfitCalc > 0D)
			{
				if (ConstantsCommon.YES.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getExcludeRescheduleYn() ))
				{
					BigDecimal currentCharge = islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT();
					islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGES_EXCLUDE_PROFI_CALC(currentCharge);
					chargesAndInsuranceExcludingProfitCalc -= NumberUtil.toDouble(currentCharge);
					chargesAndInsuranceExcludingProfitCalc = NumberUtil.round(
							chargesAndInsuranceExcludingProfitCalc,
							islamicCalculatorCO.getDealCyDecimalPoint());
					cumAllocatedChargesExcludingProfitCalc = cumAllocatedChargesExcludingProfitCalc + NumberUtil.toDouble(currentCharge);
					cumAllocatedChargesExcludingProfitCalc = NumberUtil.round(
							cumAllocatedChargesExcludingProfitCalc,
							islamicCalculatorCO.getDealCyDecimalPoint());


				}else
				{

					IslamicCalculatorStructurePlanDetCO strCharges = new IslamicCalculatorStructurePlanDetCO();
					strCharges = getlineCharges(islamicCalculatorCO, capitalAmount,
							cumAllocatedChargesExcludingProfitCalc, index, chargesExcludingProfitCalc);
					lineAllocatedCharges = strCharges.getLineAllocatedCharges();
					cumAllocatedChargesExcludingProfitCalc = strCharges.getCumAllocatedCharges();
					islamicCalculatorCO.getTrspayplandetVOList().get(index)
					.setCHARGES_EXCLUDE_PROFI_CALC(NumberUtil.roundToBigDecimal(lineAllocatedCharges,
							islamicCalculatorCO.getDealCyDecimalPoint()));
					chargesAndInsuranceExcludingProfitCalc -= lineAllocatedCharges;
					chargesAndInsuranceExcludingProfitCalc = NumberUtil.round(
							chargesAndInsuranceExcludingProfitCalc,
							islamicCalculatorCO.getDealCyDecimalPoint());
					if(ConstantsCommon.NO.equals(equalizeInstallment))
					{
						linechargesExcludingProfitCalc = (chargesExcludingProfitCalc
								- cumAllocatedChargesExcludingProfitCalc) / (noOfInstallment - noOfexclCalcLines - (index + 1));
					}
					chargeslineCount += strCharges.getLineAllocatedCount();
				}
			}
			if(lineinsuranceExcludingProfitCalc > 0D)
			{
				if (ConstantsCommon.YES.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getExcludeRescheduleYn() ))
				{
					BigDecimal currentCharge = islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT();
					islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_EXCLUDE_PROFI_CALC(currentCharge);

					chargesAndInsuranceExcludingProfitCalc -= NumberUtil.toDouble(currentCharge);
					chargesAndInsuranceExcludingProfitCalc = NumberUtil.round(
							chargesAndInsuranceExcludingProfitCalc,
							islamicCalculatorCO.getDealCyDecimalPoint());
					cumAllocatedInsuranceExcludingProfitCalc = cumAllocatedInsuranceExcludingProfitCalc + NumberUtil.toDouble(currentCharge);
					cumAllocatedInsuranceExcludingProfitCalc = NumberUtil.round(
							cumAllocatedInsuranceExcludingProfitCalc,
							islamicCalculatorCO.getDealCyDecimalPoint());


				}else
				{

					IslamicCalculatorStructurePlanDetCO strInsurance = new IslamicCalculatorStructurePlanDetCO();
					strInsurance = getlineCharges(islamicCalculatorCO, capitalAmount - lineAllocatedCharges,
							cumAllocatedInsuranceExcludingProfitCalc, index, insuranceExcludingProfitCalc);

					cumAllocatedInsuranceExcludingProfitCalc = strInsurance.getCumAllocatedCharges();
					islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_EXCLUDE_PROFI_CALC(
							NumberUtil.roundToBigDecimal(strInsurance.getLineAllocatedCharges(),
									islamicCalculatorCO.getDealCyDecimalPoint()));
					chargesAndInsuranceExcludingProfitCalc -= strInsurance.getLineAllocatedCharges();
					chargesAndInsuranceExcludingProfitCalc = NumberUtil.round(
							chargesAndInsuranceExcludingProfitCalc,
							islamicCalculatorCO.getDealCyDecimalPoint());
					if(ConstantsCommon.NO.equals(equalizeInstallment))
					{
						lineinsuranceExcludingProfitCalc = (insuranceExcludingProfitCalc
								- cumAllocatedInsuranceExcludingProfitCalc) / (noOfInstallment - (index + 1));
					}
					insurancelineCount += strInsurance.getLineAllocatedCount();
				}
			}
		    }
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getACTUAL_PROFIT_AMT());
		    prviousDate = curDate;
		    index++;
		}
		printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);// TODO
		index--;
		islamicCalculatorCO.setTotalAllocatedVatAmount(totalAllocatedVatAmount);
		if(linechargesExcludingProfitCalc > 0D)
		{
		    double diff = chargesExcludingProfitCalc - cumAllocatedChargesExcludingProfitCalc;
		    diff = NumberUtil.round(diff, islamicCalculatorCO.getDealCyDecimalPoint());
		    if(chargeslineCount == 0L)
		    {
			chargeslineCount = 1L;
		    }
		    if(diff != 0D)
		    {
			double lineDiff = diff / chargeslineCount;
			lineDiff = NumberUtil.round(lineDiff, islamicCalculatorCO.getDealCyDecimalPoint());
			if(lineDiff == 0D)
			{
			    islamicCalculatorCO.getTrspayplandetVOList().get(index)
				    .setCHARGES_EXCLUDE_PROFI_CALC(NumberUtil.roundToBigDecimal(
					    NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
						    .get(index).getCHARGES_EXCLUDE_PROFI_CALC()) + diff,
					    islamicCalculatorCO.getDealCyDecimalPoint()));
			}
			else
			{
			    linechargesExcludingProfitCalc += lineDiff;
			}
		    }
		}
		if(lineinsuranceExcludingProfitCalc > 0D)
		{
		    double diff = insuranceExcludingProfitCalc - cumAllocatedInsuranceExcludingProfitCalc;
		    diff = NumberUtil.round(diff, islamicCalculatorCO.getDealCyDecimalPoint());

		    if(insurancelineCount == 0L)
		    {
			insurancelineCount = 1L;
		    }
		    if(diff != 0D)
		    {
			double lineDiff = diff / insurancelineCount;
			lineDiff = NumberUtil.round(lineDiff, islamicCalculatorCO.getDealCyDecimalPoint());
			if(lineDiff == 0D)
			{
			    islamicCalculatorCO.getTrspayplandetVOList().get(index)
				    .setINSURANCE_EXCLUDE_PROFI_CALC(NumberUtil.roundToBigDecimal(
					    NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
						    .get(index).getINSURANCE_EXCLUDE_PROFI_CALC()) + diff,
					    islamicCalculatorCO.getDealCyDecimalPoint()));
			}
			else
			{
			    lineinsuranceExcludingProfitCalc += lineDiff;
			}
		    }
		}

		if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			.equals(islamicCalculatorCO.getProfitCalculationMethod())
			&& (ConstantsCommon.NO.equals(islamicCalculatorCO.getCompoundingProfit())
				|| IISCommonConstants.COMPOUND_PROFIT_GRACE
					.equals(islamicCalculatorCO.getCompoundingProfit())))
		{

		    // if(totalAllocatedProfitAmount != totalProfitAmount)
		    if(BigDecimal.valueOf(totalAllocatedProfitAmount)
			    .compareTo(BigDecimal.valueOf(totalProfitAmount)) != 0)
		    {
			double diff = totalProfitAmount - totalAllocatedProfitAmount;
			diff = NumberUtil.round(diff, islamicCalculatorCO.getDealCyDecimalPoint());
			islamicCalculatorCO.getTrspayplandetVOList().get(index)
				.setPROFIT_AMT(
					NumberUtil.roundToBigDecimal(
						NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
							.get(index).getPROFIT_AMT()) + diff,
						islamicCalculatorCO.getDealCyDecimalPoint()));

			islamicCalculatorCO.getTrspayplandetVOList().get(index)
				.setCAPITAL_AMT(NumberUtil.roundToBigDecimal(
					NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
						.getCAPITAL_AMT()) - diff,
					islamicCalculatorCO.getDealCyDecimalPoint()));
			totalAllocatedPrincipelAmount = totalAllocatedPrincipelAmount - diff;
			totalAllocatedPrincipelAmount = NumberUtil.round(totalAllocatedPrincipelAmount,
				islamicCalculatorCO.getDealCyDecimalPoint());
		    }

		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());

		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
		}
		if(PAYPLAN_BASED_ON_REDUCE_INSTALLMENT.equals(islamicCalculatorCO.getGenerate_payplan_based_on()))
		{
			islamicCalculatorCO.setFirstLoop(false);
		    // 675492 DASI180241
		    double diffAmount = totalDealAmount - totalAllocatedPrincipelAmount;
		    diffAmount = NumberUtil.round(diffAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		    adjustResidualInstallmentValue(islamicCalculatorCO,
			    NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT()),
			    diffAmount, noOfInstallment);
		    totalAllocatedPrincipelAmount = totalDealAmount;
		    break;
		}

		if(finalAdjustment)
		{
		    break;
		}
		if(ConstantsCommon.NO.equals(equalizeInstallment))
		{
		    // if no need to equalize the installment then exit from the
		    // loop
		    break;
		}
		/*
		 * if the total outstanding amount and allocated principle
		 * amount is not matching then need to equalize the principle
		 */
		if(noOfInstallmentForEqualize < 2)
		{
		    equalizeInstallment = ConstantsCommon.NO;
		    break;
		}
		double diffAmount = totalDealAmount - totalAllocatedPrincipelAmount;

		diffAmount = NumberUtil.round(diffAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		double currActualDiffAmount = diffAmount;
		// BigDecimal.valueOf(diffAmount);
		double currActualLineDiffAmount = diffAmount / (noOfInstallmentForEqualize
			- NumberUtil.toDouble(islamicCalculatorCO.getNoOfBaloonPayments()) + noOfInstallmentAsBalloon);
		currActualLineDiffAmount = NumberUtil.round(currActualLineDiffAmount,
			islamicCalculatorCO.getDealCyDecimalPoint());

		diffAmount = getInstallmentAdjustAmount(islamicCalculatorCO, currActualLineDiffAmount,
			(long) totalDealMonths, equalizationCount);
		// diffAmount = currActualLineDiffAmount;
		// if(Math.abs(diffAmount) > Math.abs(prevousDiffAmount) &&
		// prevousDiffAmount != 0D
		// && Math.abs(diffAmount) < 1000)
		// {
		// break;
		// }
		if(equalizationCount > maxEqualizationCount)
		{
		    break;
		}
		equalizationCount++;
		if(Math.abs(currActualDiffAmount) == Math.abs(prevousActualDiffAmount) && currActualDiffAmount < 0D
			&& prevousActualDiffAmount > 0D && pmtAmount + diffAmount > 0D)
		{
		    finalAdjustment = true;
		}
		else if(diffAmount == 0D && Math.abs(currActualDiffAmount) == Math.abs(prevousActualDiffAmount)
			&& currActualDiffAmount < 0D)
		{
		    finalAdjustment = true;
		    pmtAmount = prevousPMTAmount;
		}

		// else if(diffAmount == 0D
		// || (Math.abs(prevousDiffAmount) == Math.abs(diffAmount) &&
		// prevousDiffAmount * -1 == diffAmount && (Math
		// .abs(currActualLineDiffAmount) <
		// Math.abs(prevousActualLineDiffAmount) || Math
		// .abs(currActualLineDiffAmount) ==
		// Math.abs(prevousActualLineDiffAmount))))
		else if(BigDecimal.valueOf(diffAmount).compareTo(BigDecimal.ZERO) == 0 || (BigDecimal
			.valueOf(prevousDiffAmount).abs().compareTo(BigDecimal.valueOf(diffAmount).abs()) == 0
			&& BigDecimal.valueOf(prevousDiffAmount).multiply(BigDecimal.valueOf(-1))
				.compareTo(BigDecimal.valueOf(diffAmount)) == 0
			&& (BigDecimal.valueOf(currActualLineDiffAmount).abs()
				.compareTo(BigDecimal.valueOf(prevousActualLineDiffAmount).abs()) == -1
				|| BigDecimal.valueOf(currActualLineDiffAmount).abs()
					.compareTo(BigDecimal.valueOf(prevousActualLineDiffAmount).abs()) == 0)))
		{

		    double tempDiffAmount = totalDealAmount - totalAllocatedPrincipelAmount;

		    if(pmtAmount + tempDiffAmount > 0D)
		    {
			if(Math.abs(currActualDiffAmount) > Math.abs(prevousActualDiffAmount))
			{
			    finalAdjustment = true;

			}
			else
			{
			    break;
			}

		    }
		    else
		    {
			finalAdjustment = true;
		    }
		}
		// BigDecimal.valueOf(pmtAmount);
		prevousPMTAmount = pmtAmount;
		// Added to show the corrected second last pricipalamount
		// :91058: Multiple Balloon Payment Criteria- 3 Lines Dim- Dim-
		// Equal Pymnts, Last 3 lines principal amt not matching
		/*
		 * if(diffAmount == 0L) { switch
		 * (islamicCalculatorCO.getRoundingFactor().intValue()) { case
		 * 0: switch
		 * (islamicCalculatorCO.getDealCyDecimalPoint().intValue()) {
		 * case 0: diffAmount = 1; break; case 1: diffAmount = .1;
		 * break; case 2: diffAmount = .01; break; case 3: diffAmount =
		 * .001; break; default: break; } case 1: diffAmount = 1; break;
		 * case 2: diffAmount = 10; break; case 3: diffAmount = 100;
		 * break; case 4: diffAmount = 1000; break; default: break; }
		 * 
		 * if(totalDealAmount < totalAllocatedPrincipelAmount) {
		 * diffAmount = -diffAmount; } }
		 */

		pmtAmount = pmtAmount + (diffAmount);

		/*
		 * if(islamicCalculatorCO.getResidualValue().equals("D")) {
		 * pmtAmount = NumberUtil.truncate(pmtAmount,
		 * islamicCalculatorCO.getDealCyDecimalPoint()); } else {
		 * pmtAmount = NumberUtil.round(pmtAmount,
		 * islamicCalculatorCO.getDealCyDecimalPoint()); }
		 */

		pmtAmount = NumberUtil.round(pmtAmount, islamicCalculatorCO.getDealCyDecimalPoint());

		if(ConstantsCommon.NO.equals(islamicCalculatorCO.getApplyRoundingFact_after_calc()))
		{
		    pmtAmount = roundPmtAmount(islamicCalculatorCO, pmtAmount, islamicCalculatorCO.getRoundingFactor());
		}

		prevousActualLineDiffAmount = currActualLineDiffAmount;
		prevousActualDiffAmount = currActualDiffAmount;
		prevousDiffAmount = diffAmount;
		if(pmtAmount < 0)
		{
		    pmtAmount = 0;
		    finalAdjustment = true;
		}
		log.info("@@@@@@@@@@@@@ COUNT @@@@@@@@  =" + "	" + equalizationCount);
	    }while(!equalizeEnd);
	    printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
	    if(NumberUtil.toDoubleObj(islamicCalculatorCO.getAmountPerPayment()) > 0D
		    && islamicCalculatorCO.getTrsDealMultipleYieldVO().size() == 0
		    && !PAYPLAN_BASED_ON_REDUCE_INSTALLMENT.equals(islamicCalculatorCO.getGenerate_payplan_based_on()))
	    {
		break;
	    }
	    if(equalInstallmentForDisbursementPlan)
	    {
		break;
	    }
	    if(changeEffectLineNo == noOfInstallment - 1)
	    {
		break;
	    }
	    changeEffectLineNo = getNextChangeEffectLinNo(islamicCalculatorCO, changeEffectLineNo);
	    if(ConstantsCommon.NO.equals(tempTentativeSchedule)
		    && ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement())
		    && islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() > 0
		    && (changeEffectLineNo > noOfInstallment || changeEffectLineNo.equals(noOfInstallment)))
	    {
		changeEffectLineNo = getNextDisbursmentPlanLineNo(islamicCalculatorCO);
		equalInstallmentForDisbursementPlan = true;
		islamicCalculatorCO.setTentativeSchedule(tempTentativeSchedule);
		islamicCalculatorCO.setTrspayplandetCompoundingGracePeriod(
			reCalculateCompoundingProfitGracePeriod(islamicCalculatorCO));

		islamicCalculatorCO.setAmountPerPaymentEqualDisbur(BigDecimal.valueOf(pmtAmount));
		/**
		 * or new modification - if first payment is after all the
		 * disbursement and the first disbursement amount is less than
		 * the EMI the no need to create plan as equal disbursement
		 */

		if(islamicCalculatorCO.getFirstPaymentDate()
			.after(islamicCalculatorCO.getTrsDealMultipleDisbursementList()
				.get(islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() - 1)
				.getVALUE_DATE()))
		{
		    totalOutstandingAmount = NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
			    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
			    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
			    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());
		    totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount,
			    islamicCalculatorCO.getDealCyDecimalPoint());

		    if(pmtAmount >= totalOutstandingAmount)
		    {
			equalInstallmentForDisbursementPlan = false;
			islamicCalculatorCO.setEqualInstallmentForDisbursement(ConstantsCommon.NO);
			islamicCalculatorCO.setEqualInstallmentForDisbursement(ConstantsCommon.NO);
			changeEffectLineNo = 0;
		    }
		}
	    }
	    if(PAYPLAN_BASED_ON_REDUCE_INSTALLMENT.equals(islamicCalculatorCO.getGenerate_payplan_based_on()))
	    {
	    	Date lastDate = islamicCalculatorCO.getTrspayplandetVOList()
	    			.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getVALUE_DATE();
	    	// added for DASI170059 TP 556462 Fawas.Kuruvakkottil
	    	BigDecimal totalAmountAllocated = BigDecimal.ZERO;
	    	boolean removeLine = false;

	    	for(Iterator iterator = islamicCalculatorCO.getTrspayplandetVOList().iterator(); iterator.hasNext();)
	    	{

	    		boolean lineRemoved = false;
	    		TrspayplandetCO trspayplandetCOTmp = (TrspayplandetCO) iterator.next();
	    		// added for DASI170059 TP 556462 Fawas.Kuruvakkottil
	    		// 07/11/2017<Start>
	    		if(islamicCalculatorCO.getProfitCalculationMethod().equals("S"))
	    		{
	    			if(removeLine)
	    			{

	    				iterator.remove();
	    				lineRemoved = true;
	    			}
	    			totalAmountAllocated = totalAmountAllocated.add(trspayplandetCOTmp.getAMOUNT());
	    			if(totalAmountAllocated.compareTo(islamicCalculatorCO.getDealAmount().add(islamicCalculatorCO
	    					.getTotalCharges().add(islamicCalculatorCO.getTotalInsurance()
	    							.add(islamicCalculatorCO.getOutstandingProfit())))) == 1)
	    			{
	    				removeLine = true;
	    			}
	    		}// added for DASI170059 TP 556462 Fawas.Kuruvakkottil
	    		// 07/11/2017<End>
	    		// if(NumberUtil.toDoubleObj(trspayplandetCOTmp.getPROFIT_AMT())
	    		// <= 0D)
	    		if(!lineRemoved && NumberUtil.toDoubleObj(trspayplandetCOTmp.getAMOUNT()) <= 0D)
	    		{
	    			iterator.remove();
	    		}else if(!lineRemoved && NumberUtil.nullToZero(trspayplandetCOTmp.getCAPITAL_AMT())
	    				.subtract(NumberUtil.nullToZero(trspayplandetCOTmp.getCHARGES_EXCLUDE_PROFI_CALC())
	    						.add(NumberUtil.nullToZero(trspayplandetCOTmp.getPROFIT_ON_CHARGES()))
	    						.add(NumberUtil.nullToZero(trspayplandetCOTmp.getINSURANCE_EXCLUDE_PROFI_CALC())
	    								.add(NumberUtil.nullToZero(trspayplandetCOTmp.getPROFIT_ON_INSURANCE()))))
	    				.compareTo(BigDecimal.ZERO) == -1)
	    		{
	    			iterator.remove();
	    		}
	    	}
	    	// commeted for DASI170059 TP 556462 Fawas.Kuruvakkottil
	    	// 07/11/2017
	    	// need to reduce the deal period if settling in advance
	    	// islamicCalculatorCO.getTrspayplandetVOList()
	    	// .get(islamicCalculatorCO.getTrspayplandetVOList().size() -
	    	// 1).setVALUE_DATE(lastDate);

	    	noOfInstallment = islamicCalculatorCO.getTrspayplandetVOList().size();
	    	if(islamicCalculatorCO.getTotalCharges().add(islamicCalculatorCO.getTotalInsurance())
	    			.compareTo(BigDecimal.ZERO) == 0)
	    	{
	    		changeEffectLineNo = noOfInstallment - 1;
	    	}

	    	exitLoop1 = true;
	    }

	}while(changeEffectLineNo < noOfInstallment);

	islamicCalculatorCO.getTrspayplandetVOList().get(0)
		.setTOTAL_PRINCIPAL_OUTSTANDIG(
			NumberUtil
				.roundToBigDecimal(
					NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
						+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
						+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
						+ NumberUtil.toDoubleObj(
							islamicCalculatorCO.getTotalGracePeriodCompundingProfit()),
					islamicCalculatorCO.getDealCyDecimalPoint()));

	if(ConstantsCommon.NO.equals(equalizeInstallment)
		&& !IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			.equals(islamicCalculatorCO.getProfitCalculationMethod())
		&& IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT.equals(
			islamicCalculatorCO.getTrspayplandetVOList().get(noOfInstallment - 1).getPAYMENT_TYPE()))
	{
	    /*
	     * if no need to equalize the installment amount need to adjust the
	     * difference amount with the last installment
	     */
	    double diffAmount = totalDealAmount - totalAllocatedPrincipelAmount;
	    if(diffAmount != 0D)
	    {
		double tempPrincipleAmount = NumberUtil.toDoubleObj(
			islamicCalculatorCO.getTrspayplandetVOList().get(noOfInstallment - 1).getCAPITAL_AMT());
		double tempInstallmentAmount = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(noOfInstallment - 1).getAMOUNT());
		tempPrincipleAmount = tempPrincipleAmount + diffAmount;
		tempPrincipleAmount = NumberUtil.round(tempPrincipleAmount,
			islamicCalculatorCO.getDealCyDecimalPoint());
		double tempVatAmt = NumberUtil.toDoubleObj(
			islamicCalculatorCO.getTrspayplandetVOList().get(noOfInstallment - 1).getVAT_AMOUNT());

		// tp 574857 Manoj on 13/10/2017 Installment <> Principal +
		// profit + vat issue
		// tempInstallmentAmount = tempInstallmentAmount + diffAmount +
		// tempVatAmt;
		tempInstallmentAmount = tempInstallmentAmount + diffAmount;
		tempInstallmentAmount = NumberUtil.round(tempInstallmentAmount,
			islamicCalculatorCO.getDealCyDecimalPoint());

		islamicCalculatorCO.getTrspayplandetVOList().get(noOfInstallment - 1).setCAPITAL_AMT(
			NumberUtil.roundToBigDecimal(tempPrincipleAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(noOfInstallment - 1).setPRINCIPLE_AMT(
			NumberUtil.roundToBigDecimal(tempPrincipleAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(noOfInstallment - 1).setAMOUNT(NumberUtil
			.roundToBigDecimal(tempInstallmentAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    }
	}
	else
	{
	    /*
	     * need to round the installment amount based on the rounding factor
	     * and adjust the remaining amount at first or last installment
	     * based on the 'residualValue' flag
	     */
	    double diffAmount = totalDealAmount - totalAllocatedPrincipelAmount;
	    diffAmount = NumberUtil.round(diffAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    adjustResidualInstallmentValue(islamicCalculatorCO,
		    NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT()),
		    diffAmount, noOfInstallment);

	}

	if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		.equals(islamicCalculatorCO.getProfitCalculationMethod())
		&& NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT()) < 0D)
	{
	    adjustStaightLineProfitAmount(islamicCalculatorCO);
	}
	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
	return islamicCalculatorCO;
    }
	
	private IslamicCalculatorCO calculateBillsPlanSchedule(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	int noOfInstallment = islamicCalculatorCO.getTrspayplandetVOList().size();
	double totalDealAmount = 0d;
	double totalAllocatedPrincipelAmount = 0D;
	double totalAllocatedProfitAmount = 0D;
	long dealCyDecimalPoint = islamicCalculatorCO.getDealCyDecimalPoint();
	double totalVatAmount = 0d;
	double totalAllocatedVatAmount = 0d;
	int index = 0;
	String capitalize = ConstantsCommon.NO;
	double totalProfitAmount = 0d;
	islamicCalculatorCO.setCalculateVatAfterSchedule(ConstantsCommon.NO);

	double pmtAmount = 0D;

	double totalOutstandingAmount = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalBillAmount());

	double chargesExcludingProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
		- NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges());
	double insuranceExcludingProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
		- NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance());

	// IslamicCalculatorStructurePlanDetCO strAllocatedDet = new
	// IslamicCalculatorStructurePlanDetCO();

	// double totalDealMonths =
	// iisCommonBO.getMonthsAndDayDifferance(islamicCalculatorCO.getValueDate(),islamicCalculatorCO.getMaturityDate());

	if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		.equals(islamicCalculatorCO.getProfitCalculationMethod()))
	{
	    totalProfitAmount = getProfitAmount(islamicCalculatorCO, islamicCalculatorCO.getValueDate(),
		    islamicCalculatorCO.getMaturityDate(),
		    NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalBillAmount()), 0L, 0D,
		    NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), 0, capitalize);
	    totalProfitAmount = NumberUtil.round(totalProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    // long noOfStrighLineInstallment = noOfInstallment;

	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment()))
	    {
		totalVatAmount = calculateVatAmount(islamicCalculatorCO, 0d, totalProfitAmount, ConstantsCommon.NO);
		islamicCalculatorCO.setTotalVatAmount(totalVatAmount);
	    }

	}
	pmtAmount = NumberUtil.round(NumberUtil.toDoubleObj(islamicCalculatorCO.getAmountPerPayment()),
		islamicCalculatorCO.getDealCyDecimalPoint());

	double capitalAmount = 0D;
	double pushDownProfitAmount = 0D;
	// totalAllocatedPrincipelAmount = 0D;
	// totalAllocatedProfitAmount = 0D;
	totalDealAmount = totalOutstandingAmount;
	// boolean equalizeEnd = false;
	// int loopCount = 0;
	index = 0;
	// int equalizationCount = 0;
	// int maxEqualizationCount = 300;
	if(NumberUtil.toInteger(islamicCalculatorCO.getProfitAccrualBasis()) == 5L)
	{
	    islamicCalculatorCO.setAvgDaysInYearsForProfitCalculation(BigDecimal.valueOf(getAverageYearDaysInDealPeriod(
		    islamicCalculatorCO.getValueDate(), islamicCalculatorCO.getMaturityDate())));
	}

	double totalOutstandingAmountForProfitCalc = totalOutstandingAmount;

	// Loop for Equalize the installment
	// index = 0;
	totalOutstandingAmount = totalDealAmount;
	Date prviousDate = islamicCalculatorCO.getInstallmentCommentsDate();
	// long noOfInstallmentForEqualize = 0L;
	// totalAllocatedPrincipelAmount = 0D;
	// totalAllocatedProfitAmount = 0D;
	// totalAllocatedVatAmount = 0D;
	double cumAllocatedInsuranceExcludingProfitCalc = 0D;
	double cumAllocatedChargesExcludingProfitCalc = 0D;
	long chargeslineCount = 0L;
	long insurancelineCount = 0L;
	double chargesAndInsuranceExcludingProfitCalc = 0D;
	double principelAmountForRedusingBalanceMethod = 0D;
	Integer changeEffectLineNo = 0;
	islamicCalculatorCO.getTrspayplandetCompoundingDealPeriod().clear();
	double linechargesExcludingProfitCalc = chargesExcludingProfitCalc / (noOfInstallment - changeEffectLineNo);
	double lineinsuranceExcludingProfitCalc = insuranceExcludingProfitCalc / (noOfInstallment - changeEffectLineNo);
	for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
	{

	    Date curDate = trspayplandetCO.getVALUE_DATE();

	    IslamicCalculatorStructurePlanDetCO structurePlanDet = new IslamicCalculatorStructurePlanDetCO();

	    if(index < changeEffectLineNo)
	    {
	    }
	    else
	    {

		structurePlanDet = setInstallmentValues(islamicCalculatorCO, trspayplandetCO, pmtAmount, index,
			principelAmountForRedusingBalanceMethod, noOfInstallment, pushDownProfitAmount, prviousDate,
			totalOutstandingAmount, totalDealAmount, chargesAndInsuranceExcludingProfitCalc,
			changeEffectLineNo, totalOutstandingAmountForProfitCalc);

		capitalAmount = structurePlanDet.getPrincipleAmount();

		totalAllocatedProfitAmount = totalAllocatedProfitAmount + structurePlanDet.getProfitAmount();
		totalAllocatedProfitAmount = NumberUtil.round(totalAllocatedProfitAmount,
			islamicCalculatorCO.getDealCyDecimalPoint());
		totalAllocatedVatAmount = NumberUtil.round(totalAllocatedVatAmount + structurePlanDet.getVatAmount(),
			islamicCalculatorCO.getDealCyDecimalPoint());

		if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			.equals(islamicCalculatorCO.getProfitCalculationMethod()))
		{
		    if(totalProfitAmount - totalAllocatedProfitAmount < 0D)
		    {
			double diff = NumberUtil.round(totalProfitAmount - totalAllocatedProfitAmount,
				islamicCalculatorCO.getDealCyDecimalPoint());
			capitalAmount = NumberUtil.round(NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT()) - diff,
				islamicCalculatorCO.getDealCyDecimalPoint());
			structurePlanDet.setProfitAmount(NumberUtil.round(structurePlanDet.getProfitAmount() + diff,
				islamicCalculatorCO.getDealCyDecimalPoint()));
			islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT(
				NumberUtil.roundToBigDecimal(structurePlanDet.getProfitAmount(), dealCyDecimalPoint));
			islamicCalculatorCO.getTrspayplandetVOList().get(index)
				.setCAPITAL_AMT(NumberUtil.roundToBigDecimal(capitalAmount, dealCyDecimalPoint));
			totalAllocatedProfitAmount = totalProfitAmount;
		    }

		}
		double lineAllocatedCharges = 0D;

		if(linechargesExcludingProfitCalc > 0D)
		{
		    IslamicCalculatorStructurePlanDetCO strCharges = new IslamicCalculatorStructurePlanDetCO();
		    strCharges = getlineCharges(islamicCalculatorCO, capitalAmount,
			    cumAllocatedChargesExcludingProfitCalc, index, chargesExcludingProfitCalc);
		    lineAllocatedCharges = strCharges.getLineAllocatedCharges();
		    cumAllocatedChargesExcludingProfitCalc = strCharges.getCumAllocatedCharges();
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGES_EXCLUDE_PROFI_CALC(NumberUtil
			    .roundToBigDecimal(lineAllocatedCharges, islamicCalculatorCO.getDealCyDecimalPoint()));
		    chargesAndInsuranceExcludingProfitCalc -= lineAllocatedCharges;
		    chargesAndInsuranceExcludingProfitCalc = NumberUtil.round(chargesAndInsuranceExcludingProfitCalc,
			    islamicCalculatorCO.getDealCyDecimalPoint());

		    linechargesExcludingProfitCalc = (chargesExcludingProfitCalc
			    - cumAllocatedChargesExcludingProfitCalc) / (noOfInstallment - (index + 1));

		    chargeslineCount += strCharges.getLineAllocatedCount();
		}
		if(lineinsuranceExcludingProfitCalc > 0D)
		{
		    IslamicCalculatorStructurePlanDetCO strInsurance = new IslamicCalculatorStructurePlanDetCO();
		    strInsurance = getlineCharges(islamicCalculatorCO, capitalAmount - lineAllocatedCharges,
			    cumAllocatedInsuranceExcludingProfitCalc, index, insuranceExcludingProfitCalc);

		    cumAllocatedInsuranceExcludingProfitCalc = strInsurance.getCumAllocatedCharges();
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_EXCLUDE_PROFI_CALC(
			    NumberUtil.roundToBigDecimal(strInsurance.getLineAllocatedCharges(),
				    islamicCalculatorCO.getDealCyDecimalPoint()));
		    chargesAndInsuranceExcludingProfitCalc -= strInsurance.getLineAllocatedCharges();
		    chargesAndInsuranceExcludingProfitCalc = NumberUtil.round(chargesAndInsuranceExcludingProfitCalc,
			    islamicCalculatorCO.getDealCyDecimalPoint());

		    lineinsuranceExcludingProfitCalc = (insuranceExcludingProfitCalc
			    - cumAllocatedInsuranceExcludingProfitCalc) / (noOfInstallment - (index + 1));

		    insurancelineCount += strInsurance.getLineAllocatedCount();
		}
	    }
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).getACTUAL_PROFIT_AMT());
	    if(INTEREST_CALCULATION_METHOD_FLAT.equals(islamicCalculatorCO.getInterest_calculation_method()))
	    {
		prviousDate = curDate;
	    }
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_AMOUNT(BigDecimal.valueOf(0D));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_ON_INSURANCE(BigDecimal.valueOf(0D));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGE_AMOUNT(BigDecimal.valueOf(0D));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_ON_CHARGES(BigDecimal.valueOf(0D));
	    index++;
	}
	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);// TODO
	index--;
	islamicCalculatorCO.setTotalAllocatedVatAmount(totalAllocatedVatAmount);
	if(linechargesExcludingProfitCalc > 0D)
	{
	    double diff = chargesExcludingProfitCalc - cumAllocatedChargesExcludingProfitCalc;
	    diff = NumberUtil.round(diff, islamicCalculatorCO.getDealCyDecimalPoint());

	    if(diff != 0D)
	    {

		islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.setCHARGES_EXCLUDE_PROFI_CALC(NumberUtil.roundToBigDecimal(
				NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
					.getCHARGES_EXCLUDE_PROFI_CALC()) + diff,
				islamicCalculatorCO.getDealCyDecimalPoint()));

	    }
	}
	if(lineinsuranceExcludingProfitCalc > 0D)
	{
	    double diff = insuranceExcludingProfitCalc - cumAllocatedInsuranceExcludingProfitCalc;
	    diff = NumberUtil.round(diff, islamicCalculatorCO.getDealCyDecimalPoint());

	    if(diff != 0D)
	    {

		islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.setINSURANCE_EXCLUDE_PROFI_CALC(NumberUtil.roundToBigDecimal(
				NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index)
					.getINSURANCE_EXCLUDE_PROFI_CALC()) + diff,
				islamicCalculatorCO.getDealCyDecimalPoint()));

	    }
	}

	if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		.equals(islamicCalculatorCO.getProfitCalculationMethod()))
	{

	    // if(totalAllocatedProfitAmount != totalProfitAmount)
	    if(BigDecimal.valueOf(totalAllocatedProfitAmount).compareTo(BigDecimal.valueOf(totalProfitAmount)) != 0)
	    {
		double diff = totalProfitAmount - totalAllocatedProfitAmount;
		diff = NumberUtil.round(diff, islamicCalculatorCO.getDealCyDecimalPoint());
		islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.setPROFIT_AMT(NumberUtil.roundToBigDecimal(
				NumberUtil.toDoubleObj(
					islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT()) + diff,
				islamicCalculatorCO.getDealCyDecimalPoint()));

		islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(NumberUtil.roundToBigDecimal(
			NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
				- diff,
			islamicCalculatorCO.getDealCyDecimalPoint()));
		totalAllocatedPrincipelAmount = totalAllocatedPrincipelAmount - diff;
		totalAllocatedPrincipelAmount = NumberUtil.round(totalAllocatedPrincipelAmount,
			islamicCalculatorCO.getDealCyDecimalPoint());
	    }

	    islamicCalculatorCO.getTrspayplandetVOList().get(index)
		    .setACTUAL_PROFIT_AMT(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());

	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
	}

	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);

	islamicCalculatorCO.getTrspayplandetVOList().get(0)
		.setTOTAL_PRINCIPAL_OUTSTANDIG(
			NumberUtil
				.roundToBigDecimal(
					NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
						+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
						+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
						+ NumberUtil.toDoubleObj(
							islamicCalculatorCO.getTotalGracePeriodCompundingProfit()),
					islamicCalculatorCO.getDealCyDecimalPoint()));

	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
	return islamicCalculatorCO;

    }

    private IslamicCalculatorStructurePlanDetCO getAllocatedDetails(IslamicCalculatorCO islamicCalculatorCO,
	    Integer lineNo)
    {
	double totalProfit = 0d;
	double totalChargesExcludeProfitCalc = 0d;
	double totalInsuranceExcludeProfitCalc = 0d;
	double totalCapitalAllocated = 0d;
	double totalVatAllocated = 0d;

	for(int i = 0; i < lineNo + 1; i++)
	{
	    totalProfit += NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getACTUAL_PROFIT_AMT());

	    totalCapitalAllocated += NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT());

	    totalVatAllocated += NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVAT_AMOUNT());

	    totalChargesExcludeProfitCalc += islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    .getCHARGES_EXCLUDE_PROFI_CALC() == null ? 0D
			    : islamicCalculatorCO.getTrspayplandetVOList().get(i).getCHARGES_EXCLUDE_PROFI_CALC()
				    .doubleValue();

	    totalInsuranceExcludeProfitCalc += islamicCalculatorCO.getTrspayplandetVOList().get(i)
		    .getINSURANCE_EXCLUDE_PROFI_CALC() == null ? 0D
			    : islamicCalculatorCO.getTrspayplandetVOList().get(i).getINSURANCE_EXCLUDE_PROFI_CALC()
				    .doubleValue();
	}
	IslamicCalculatorStructurePlanDetCO strInsurance = new IslamicCalculatorStructurePlanDetCO();
	strInsurance
		.setTotalAllocatedProfit(NumberUtil.round(totalProfit, islamicCalculatorCO.getDealCyDecimalPoint()));
	strInsurance.setTotalChargesExcludeProfitCalc(
		NumberUtil.round(totalChargesExcludeProfitCalc, islamicCalculatorCO.getDealCyDecimalPoint()));
	strInsurance.setTotalInsuranceExcludeProfitCalc(
		NumberUtil.round(totalInsuranceExcludeProfitCalc, islamicCalculatorCO.getDealCyDecimalPoint()));

	strInsurance.setAllocatedVatAmount(
		NumberUtil.round(totalVatAllocated, islamicCalculatorCO.getDealCyDecimalPoint()));

	strInsurance.setAllocatedCapitalAmount(
		NumberUtil.round(totalCapitalAllocated, islamicCalculatorCO.getDealCyDecimalPoint()));

	return strInsurance;
    }
	
	private Long getStrighLineInstallmentCount(IslamicCalculatorCO islamicCalculatorCO, Integer changeEffectLineNo)
    {
	long balloonPaymentCount = 0L;
	islamicCalculatorCO.setTotalBalloonAmount(BigDecimal.valueOf(0D));
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if(i < changeEffectLineNo)
	    {
		islamicCalculatorCO.setTotalBalloonAmount(BigDecimal.valueOf(NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTotalBalloonAmount())
			// +
			// NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getCAPITAL_AMT())));MANOJ
			// ON 22/09/2013
			+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT())));
	    }
	    else
	    {

		if(NumberUtil.toInteger(islamicCalculatorCO.getTrspayplandetVOList().get(i).getBALLOON_PAYMENT()) == 1)
		{

		    if(ConstantsCommon.YES
			    .equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getNormalInstallment()))
		    {
			islamicCalculatorCO.setTotalBalloonAmount(BigDecimal.valueOf(NumberUtil
				.toDoubleObj(islamicCalculatorCO.getTotalBalloonAmount())
				+ NumberUtil.toDoubleObj(
					islamicCalculatorCO.getTrspayplandetVOList().get(i).getBALLOON_AMOUNT())));
			if(ConstantsCommon.YES.equals(islamicCalculatorCO.getInstAmtInBalloon()))
			{
			    islamicCalculatorCO.setIgoreIfStatement(0);

			}
			else if(i == islamicCalculatorCO.getTrspayplandetVOList().size() - 1
				&& ConstantsCommon.YES.equals(islamicCalculatorCO.getInstAmtInLastBalloon()))
			{
			    islamicCalculatorCO.setIgoreIfStatement(0);

			}
			else
			{
			    balloonPaymentCount++;
			}

		    }
		    else
		    {
				islamicCalculatorCO.setTotalBalloonAmount(BigDecimal.valueOf(NumberUtil
				  .toDoubleObj(islamicCalculatorCO.getTotalBalloonAmount())
				  + NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i)
				   .getBALLOON_AMOUNT())));
				balloonPaymentCount++;
		    }
		}
		else if(IISCommonConstants.PAYMENT_TYPE_SPECIFIC_AMOUNT
			.equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE())
			|| (NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrspayplandetVOList().get(i).getUSER_DEFINED_AMOUNT()) > 0))
		{

		    islamicCalculatorCO.setTotalBalloonAmount(BigDecimal.valueOf(NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTotalBalloonAmount())
			    + NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(i).getUSER_DEFINED_AMOUNT())));
		    balloonPaymentCount++;
		}
		else if(IISCommonConstants.PAYMENT_TYPE_SETTLE_PROFIT
			.equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE()))
		{
		    balloonPaymentCount++;

		}
	    }
	}// end of for loop
	return islamicCalculatorCO.getTrspayplandetVOList().size() - balloonPaymentCount;
    }

    private Double calculatePMTAmount365By31(IslamicCalculatorCO islamicCalculatorCO, Double rate, Long months,
	    Double loanValue, Long noOfInstallment)
    {
	double intRate = ((rate / 100) / 365) * 31;
	double pmt = Math.floor((loanValue * intRate) / (1 - Math.pow(1 + intRate, (-1 * months))) * 100) / 100;

	long totalNoOfInstallment = islamicCalculatorCO.getTrspayplandetVOList().size();
	if(totalNoOfInstallment != months)
	{
	    pmt = (pmt * months) / noOfInstallment;
	}
	return pmt;
    }

    private Double calculatePMTAmount360By30(IslamicCalculatorCO islamicCalculatorCO, Double rate, Long months,
	    Double loanValue, Long noOfInstallment)
    {

	double intRate = (rate / 100) / 12;
	double pmt = Math.floor((loanValue * intRate) / (1 - Math.pow(1 + intRate, (-1 * months))) * 100) / 100;
	if(months == 0)
	{
	    pmt = loanValue / noOfInstallment;
	    return pmt;
	}
	long totalNoOfInstallment = islamicCalculatorCO.getTrspayplandetVOList().size();
	if(totalNoOfInstallment != months)
	{
	    pmt = (pmt * months) / noOfInstallment;
	}
	return pmt;
    }

    private IslamicCalculatorStructurePlanDetCO getCurrentLineDetails(IslamicCalculatorCO islamicCalculatorCO,
	    int index)
    {
	IslamicCalculatorStructurePlanDetCO structurePlanDet = new IslamicCalculatorStructurePlanDetCO();
	structurePlanDet.setPushDownProfitAmount(NumberUtil.toDoubleObj(
		islamicCalculatorCO.getTrspayplandetVOList().get(index).getPRFT_AMT_PUSHDWN_FRM_ABV_INST()));
	structurePlanDet.setTotalOutstandingAmount(NumberUtil
		.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getTOTAL_PRINCIPAL_OUTSTANDIG()));
	structurePlanDet.setPrincipleAmount(
		NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT()));
	structurePlanDet.setNoOfInstallmentForEqualize(0L);
	structurePlanDet.setProfitAmount(
		NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT()));
	structurePlanDet.setInstallmentAmount(
		NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT()));
	structurePlanDet.setVatAmount(
		NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getVAT_AMOUNT()));

	return structurePlanDet;
    }

    private IslamicCalculatorStructurePlanDetCO setInstallmentValues(IslamicCalculatorCO islamicCalculatorCO,
	    TrspayplandetCO trsPayplanDetCO, Double pmtAmount, Integer index, Double principleAmountParam,
	    Integer noOfInstallment, Double pushDownProfitAmountParam, Date prviousDate, Double totalOutstandingAmount,
	    Double totalDealAmount, Double chargesAndInsuranceExcludingProfitCals, Integer changeEffectiveLineNo,
	    Double totalOutstandingAmountForProfitCalc) throws BaseException
    {
	Double principleAmount = principleAmountParam, pushDownProfitAmount = pushDownProfitAmountParam;

	long adjustDays = 0L;
	double installmentAmount = pmtAmount;
	double actualProfitAmount = 0D;
	long noOfInstallmentForEqualize = 0L;
	String capitalize = ConstantsCommon.NO;
	double vatAmount = 0D;
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeInstallmentDateInProfitCalculation())
		&& NumberUtil.toInt(islamicCalculatorCO.getNoOfPayments()) != 1)
	{
	    if(index.compareTo(0) == 0)
	    {
		adjustDays = 1L;
	    }
	    else if(index.equals((noOfInstallment - 1)))
	    {
		adjustDays = -1L;
	    }
	}
	Date curDate = trsPayplanDetCO.getVALUE_DATE();
	if(PAYPLAN_BASED_ON_REDUCE_INSTALLMENT.equals(islamicCalculatorCO.getGenerate_payplan_based_on())
		&& !islamicCalculatorCO.getTrsDealMultipleYieldVO().isEmpty()
		&& !prviousDate.before(islamicCalculatorCO.getNextProfitValueDate()))
	{

	    Date nextprofitChangeDate = getNextprofitRateChangeDate(islamicCalculatorCO);
	    if(prviousDate.after(nextprofitChangeDate) || prviousDate.equals(nextprofitChangeDate))
	    {
		for(int j = 0; j < islamicCalculatorCO.getTrsDealMultipleYieldVO().size(); j++)
		{
		    if(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(j).getFROM_DATE()
			    .compareTo(nextprofitChangeDate) == 0)
		    {
			islamicCalculatorCO
				.setAnnualYeild(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(j).getYIELD());
		    }

		}
		islamicCalculatorCO.setNextProfitValueDate(nextprofitChangeDate);
	    }

	}

	if(pushDownProfitAmount == null)
	{
	    pushDownProfitAmount = 0D;
	}

	if(index.compareTo(0) == 0)
	{
	    pushDownProfitAmount = pushDownProfitAmount
		    + NumberUtil.nullToZero(islamicCalculatorCO.getFirstLineProfitToBeAdjust()).doubleValue();
	}

	if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		.equals(islamicCalculatorCO.getProfitCalculationMethod()))
	{
	    Double chargesAndInsuranceExcludingProfitCalcForStrateline = (NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTotalCharges())
		    + NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
		    - NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges())
		    - NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance()));
	    chargesAndInsuranceExcludingProfitCalcForStrateline = NumberUtil.round(
		    chargesAndInsuranceExcludingProfitCalcForStrateline, islamicCalculatorCO.getDealCyDecimalPoint());
	    actualProfitAmount = getProfitAmount(islamicCalculatorCO, prviousDate, curDate, totalDealAmount, adjustDays,
		    chargesAndInsuranceExcludingProfitCalcForStrateline,
		    NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), index, capitalize);

	}
	else
	{
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement()))
	    {
		actualProfitAmount = getProfitAmount(islamicCalculatorCO, prviousDate, curDate,
			totalOutstandingAmountForProfitCalc, adjustDays, chargesAndInsuranceExcludingProfitCals,
			NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), index, capitalize);
		if(actualProfitAmount < 0D)
		{
		    actualProfitAmount = 0d;
		}
	    }
	    else
	    {
		actualProfitAmount = getProfitAmount(islamicCalculatorCO, prviousDate, curDate, totalOutstandingAmount,
			adjustDays, chargesAndInsuranceExcludingProfitCals,
			NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), index, capitalize);
	    }

	}
	if(actualProfitAmount < 0)
	{
	    actualProfitAmount = 0;
	}
	actualProfitAmount = NumberUtil.round(actualProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint());

	islamicCalculatorCO.setCurrentLineActualProfitAmount(actualProfitAmount);
	double profitAmount = actualProfitAmount + pushDownProfitAmount;
	pushDownProfitAmount = 0D;

	// Calculating installment and principal amount
	IslamicCalculatorStructurePlanDetCO structurePlanDet = new IslamicCalculatorStructurePlanDetCO();
	if(IISCommonConstants.PAYMENT_TYPE_ASSET_RESIDUAL_VALUE
		.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE()))
	{
	    installmentAmount = islamicCalculatorCO.getAssetResidualAmount().doubleValue();
	    principleAmount = installmentAmount - islamicCalculatorCO.getAssetResidualprofit().doubleValue();
	    profitAmount = islamicCalculatorCO.getAssetResidualprofit().doubleValue();
	    noOfInstallmentForEqualize = 1L;
	    vatAmount = 0d;
	}
	if(((changeEffectiveLineNo.equals(index) && !islamicCalculatorCO.isFirstLoop())
		|| NumberUtil.toInt(islamicCalculatorCO.getTrspayplandetVOList().get(index).getBALLOON_PAYMENT()) == 1
		|| NumberUtil.toDoubleObj(islamicCalculatorCO.getAmountPerPayment()) > 0D
		|| ConstantsCommon.YES.equals(islamicCalculatorCO.getRedusingBalanceMethod())
		|| "I".equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE())
		|| IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			.equals(islamicCalculatorCO.getProfitCalculationMethod())
		|| (islamicCalculatorCO.getTrsPayPlanCriteriaVO() != null
			&& checkForAmtInRepaymentCriteria(islamicCalculatorCO))
			|| "Y".equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getExcludeRescheduleYn())
	// ||
	// islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE().equals("C")
	) || PAYPLAN_BASED_ON_REDUCE_INSTALLMENT.equals(islamicCalculatorCO.getGenerate_payplan_based_on()))
	{
	    structurePlanDet = getInstallmentAmount(islamicCalculatorCO, pmtAmount, profitAmount, principleAmount,
		    index, changeEffectiveLineNo);

	    installmentAmount = structurePlanDet.getInstallmentAmount();
	    pushDownProfitAmount = structurePlanDet.getPushDownProfitAmount();
	    pushDownProfitAmount = NumberUtil.round(pushDownProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    principleAmount = structurePlanDet.getPrincipleAmount();
	    profitAmount = structurePlanDet.getProfitAmount();
	    noOfInstallmentForEqualize = structurePlanDet.getNoOfInstallmentForEqualize();
	    vatAmount = structurePlanDet.getVatAmount();

	}
	else
	{
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment())
		    && ConstantsCommon.NO.equals(islamicCalculatorCO.getCalculateVatAfterSchedule()))
	    {
		vatAmount = calculateVatAmount(islamicCalculatorCO, installmentAmount, profitAmount,
			ConstantsCommon.NO);
	    }
	    noOfInstallmentForEqualize = 1L;
	    if(installmentAmount < profitAmount + vatAmount
		    && !index.equals(islamicCalculatorCO.getTrspayplandetVOList().size() - 1))
	    {
		pushDownProfitAmount = profitAmount;
		profitAmount = installmentAmount;

		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment())
			&& ConstantsCommon.NO.equals(islamicCalculatorCO.getCalculateVatAfterSchedule()))
		{
		    vatAmount = calculateVatAmount(islamicCalculatorCO, installmentAmount, profitAmount,
			    ConstantsCommon.YES);
		}
		profitAmount = profitAmount - vatAmount;
		pushDownProfitAmount = pushDownProfitAmount - profitAmount;
	    }
	}

	installmentAmount = NumberUtil.round(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	profitAmount = NumberUtil.round(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	principleAmount = installmentAmount - (profitAmount + vatAmount);
	principleAmount = NumberUtil.round(principleAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	vatAmount = NumberUtil.round(vatAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	/**
	 * BB160136; Manoj MV; 22/01/2018 Flexi Payment
	 */
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getFlexiPaymentYN()))
	{
	    installmentAmount = 0;
	    principleAmount = profitAmount * -1;
	}

	// if vat included in the installment
	islamicCalculatorCO.getTrspayplandetVOList().get(index).setAMOUNT(
		NumberUtil.roundToBigDecimal(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	islamicCalculatorCO.getTrspayplandetVOList().get(index)
		.setPROFIT_AMT(NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(
		NumberUtil.roundToBigDecimal(principleAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	islamicCalculatorCO.getTrspayplandetVOList().get(index).setPRINCIPLE_AMT(
		NumberUtil.roundToBigDecimal(principleAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT(
		NumberUtil.roundToBigDecimal(actualProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
		NumberUtil.roundToBigDecimal(actualProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	islamicCalculatorCO.getTrspayplandetVOList().get(index).setPRFT_AMT_PUSHDWN_FRM_ABV_INST(
		NumberUtil.roundToBigDecimal(pushDownProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEXCLUDE_PASTDUE_AT_RESCHDL_YN())
			&& islamicCalculatorCO.getFirstPaymentDate().compareTo(islamicCalculatorCO.getTrspayplandetVOList().get(index).getVALUE_DATE()) == 0 )
	{
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setOVERDUE_INSTLMNT_EXCESS_PRFT(
		        NumberUtil.roundToBigDecimal(pushDownProfitAmountParam, islamicCalculatorCO.getDealCyDecimalPoint()));
	}

	islamicCalculatorCO.getTrspayplandetVOList().get(index)
		.setVAT_AMOUNT(NumberUtil.roundToBigDecimal(vatAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	islamicCalculatorCO.getTrspayplandetVOList().get(index).setVAT_PERCENTAGE(NumberUtil.roundToBigDecimal(
		islamicCalculatorCO.getVatPercentage(), islamicCalculatorCO.getDealCyDecimalPoint()));
	if(!ConstantsCommon.YES.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getExcludeRescheduleYn())){
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setYIELD(islamicCalculatorCO.getAnnualYeild());	
	}

	islamicCalculatorCO.getTrspayplandetVOList().get(index).setYIELD(islamicCalculatorCO.getAnnualYeild());

	if(islamicCalculatorCO.getTrspayplandetVOList().get(index).getNO_OF_DAYS() == null)
	{
	    Long totalDays = DateUtil.numberOfDays(prviousDate, curDate);
	    totalDays = totalDays + adjustDays;
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setNO_OF_DAYS(BigDecimal.valueOf(totalDays));
	}

	structurePlanDet.setInstallmentAmount(installmentAmount);
	structurePlanDet.setNoOfInstallmentForEqualize(noOfInstallmentForEqualize);
	structurePlanDet.setPrincipleAmount(principleAmount);
	structurePlanDet.setProfitAmount(profitAmount);
	structurePlanDet.setPushDownProfitAmount(pushDownProfitAmount);
	structurePlanDet.setTotalOutstandingAmount(totalOutstandingAmount);
	structurePlanDet.setVatAmount(vatAmount);

	return structurePlanDet;
    }
    
    private boolean checkForAmtInRepaymentCriteria(IslamicCalculatorCO islamicCalculatorCO)
    {
	for(TrspayplanCriteriaCO trspayplanCRITERIAVO : islamicCalculatorCO.getTrsPayPlanCriteriaVO())
	{
	    if(NumberUtil.toDouble(trspayplanCRITERIAVO.getCAPITAL_AMT()) > 0)
	    {
		return true;
	    }

	}
	return false;
    }

	private Double calculateVatAmount(IslamicCalculatorCO islamicCalculatorCO, Double installmentAmount,
	    Double profitAmount, String proRateVatYn)
    {
	double vatAmount = 0d;

	if(IISCommonConstants.VAT_PERCENTAGE_INDICATOR_PROFIT.equals(islamicCalculatorCO.getVatPercentageOn()))
	{
	    if(ConstantsCommon.YES.equals(proRateVatYn))
	    {
		vatAmount = NumberUtil.round(
			(profitAmount * islamicCalculatorCO.getVatPercentage().doubleValue())
				/ (100 + islamicCalculatorCO.getVatPercentage().doubleValue()),
			islamicCalculatorCO.getDealCyDecimalPoint());
	    }
	    else
	    {
		vatAmount = NumberUtil.round(profitAmount * islamicCalculatorCO.getVatPercentage().doubleValue() / 100,
			islamicCalculatorCO.getDealCyDecimalPoint());
	    }

	}
	else
	{
	    if(ConstantsCommon.YES.equals(proRateVatYn))
	    {
		vatAmount = NumberUtil.round(
			(installmentAmount * islamicCalculatorCO.getVatPercentage().doubleValue())
				/ (100 + islamicCalculatorCO.getVatPercentage().doubleValue()),
			islamicCalculatorCO.getDealCyDecimalPoint());
	    }
	    else
	    {
		vatAmount = NumberUtil.round(
			installmentAmount * islamicCalculatorCO.getVatPercentage().doubleValue() / 100,
			islamicCalculatorCO.getDealCyDecimalPoint());
	    }
	}
	if(vatAmount < 0D)
	{
	    vatAmount = 0d;
	}

	return vatAmount;
    }

    private IslamicCalculatorStructurePlanDetCO getInstallmentAmount(IslamicCalculatorCO islamicCalculatorCO,
	    Double pmtAmount, Double profitAmountParam, Double principleAmountParam, Integer index,
	    Integer changeEffectiveLineNo)
    {
	Double profitAmount = profitAmountParam, principleAmount = principleAmountParam;
	double installmentAmount = pmtAmount;
	double pushDownProfitAmount = 0D;
	long noOfInstallmentForEqualize = 0L;
	double vatAmount = 0D;
	IslamicCalculatorStructurePlanDetCO structurePlanDet = new IslamicCalculatorStructurePlanDetCO();
	if("I".equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE()))
	{
	    /*
	     * if payment type is installment as balloon payment then then
	     * installment amount will be double of the normal installment
	     * amount
	     */
	    installmentAmount = installmentAmount * 2L;
	    installmentAmount = NumberUtil.round(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	}

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment())
		&& ConstantsCommon.NO.equals(islamicCalculatorCO.getCalculateVatAfterSchedule()))
	{
	    vatAmount = calculateVatAmount(islamicCalculatorCO, installmentAmount, profitAmount, ConstantsCommon.NO);
	}
	/**
	 * Added By manoj on 08/07/2015 for Bills Calculator
	 */
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	{
	    principleAmount = installmentAmount - (profitAmount + vatAmount);

	    principleAmount = NumberUtil.round(principleAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    structurePlanDet.setInstallmentAmount(installmentAmount);
	    structurePlanDet.setNoOfInstallmentForEqualize(noOfInstallmentForEqualize);
	    structurePlanDet.setPrincipleAmount(principleAmount);
	    structurePlanDet.setProfitAmount(profitAmount);
	    structurePlanDet.setPushDownProfitAmount(pushDownProfitAmount);
	    structurePlanDet.setVatAmount(vatAmount);

	    return structurePlanDet;
	}
	else if(ConstantsCommon.YES.equals(islamicCalculatorCO.getRedusingBalanceMethod()))
	{
	    /*
	     * if the interest calculation is residuing balance method the the
	     * principle will be the equal amount no need to equalize the
	     * installment amount
	     */
	    installmentAmount = profitAmount + principleAmount + vatAmount;

	    installmentAmount = NumberUtil.round(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    structurePlanDet.setInstallmentAmount(installmentAmount);
	    structurePlanDet.setNoOfInstallmentForEqualize(noOfInstallmentForEqualize);
	    structurePlanDet.setPrincipleAmount(principleAmount);
	    structurePlanDet.setProfitAmount(profitAmount);
	    structurePlanDet.setPushDownProfitAmount(pushDownProfitAmount);
	    structurePlanDet.setVatAmount(vatAmount);

	    return structurePlanDet;
	}
	else if(ConstantsCommon.YES.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getUserDefined()))
	{
		// if the installment is user defined Specific amount or fixed
		// principal amount
		if (ConstantsCommon.YES.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getExcludeRescheduleYn()))
		{
			BigDecimal userDefinedProfit = NumberUtil.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(index).getUSER_DEFINED_PRFIT_AMOUNT());
			BigDecimal userDefinedInstAmount = NumberUtil.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(index).getUSER_DEFINED_AMOUNT());
			BigDecimal capitalAmt = userDefinedInstAmount.subtract(userDefinedProfit);
			vatAmount = NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getVAT_AMOUNT());

			if (userDefinedProfit.compareTo(BigDecimal.valueOf(profitAmount)) != 0){
				pushDownProfitAmount = NumberUtil.toDoubleObj(BigDecimal.valueOf(profitAmount).subtract(userDefinedProfit));
				profitAmount = NumberUtil.toDoubleObj(userDefinedProfit);
			}
			principleAmount = NumberUtil.toDoubleObj(capitalAmt); 
			installmentAmount = profitAmount + vatAmount + principleAmount;

		}else
		{

			if(IISCommonConstants.PAYMENT_TYPE_SPECIFIC_AMOUNT
					.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE())
					|| NumberUtil.toDoubleObj(islamicCalculatorCO.getAmountPerPayment()) > 0
					|| PAYPLAN_BASED_ON_REDUCE_INSTALLMENT.equals(islamicCalculatorCO.getGenerate_payplan_based_on()))// Specific
				// Amount
			{
				installmentAmount = NumberUtil
						.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getUSER_DEFINED_AMOUNT());
				if(installmentAmount < profitAmount)
				{
					pushDownProfitAmount = profitAmount - installmentAmount;
					profitAmount = installmentAmount;

					if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment())
							&& ConstantsCommon.NO.equals(islamicCalculatorCO.getCalculateVatAfterSchedule()))
					{

						vatAmount = calculateVatAmount(islamicCalculatorCO, installmentAmount, profitAmount,
								ConstantsCommon.YES);

						profitAmount = profitAmount - vatAmount;
						pushDownProfitAmount = pushDownProfitAmount + vatAmount;

					}
				}
				// installmentAmount = installmentAmount + vatAmount;
			}
			else
				// fixed principal amount
			{
				principleAmount = NumberUtil
						.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getUSER_DEFINED_AMOUNT());
				if(principleAmount.equals(Double.valueOf(0)))
				{
					principleAmount = NumberUtil
							.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
				}
				if(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL
						.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE()))
				{
					installmentAmount = principleAmount;
					pushDownProfitAmount = profitAmount;
					profitAmount = 0D;
					vatAmount = 0D;
				}
				else
				{
					installmentAmount = principleAmount + profitAmount + vatAmount;
				}
			}
		}
	}
	else
	// if the installment is defined by the system
	{
		if(IISCommonConstants.PAYMENT_TYPE_SETTLE_PROFIT
				.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE())
				|| IISCommonConstants.PAYMENT_TYPE_UPFRONT_PROFIT
				.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE()))// Profit
			// Only
		{
			installmentAmount = profitAmount + vatAmount;
		}
		else if(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL
				.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE()))// Principal
			// Only
		{
			// if(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT()
			// != null
			if(NumberUtil.nullToZero(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT())
					.compareTo(BigDecimal.ZERO) != 0
					&& IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
					.equals(islamicCalculatorCO.getProfitCalculationMethod()))
			{
				if(NumberUtil
						.toDouble(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT()) == 0d
						|| changeEffectiveLineNo.equals(index))
				{
					installmentAmount = NumberUtil
							.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
				}
				else
				{
					installmentAmount = NumberUtil
							.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT())
							- profitAmount - vatAmount;
				}
			}
			else
			{
				if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
						.equals(islamicCalculatorCO.getProfitCalculationMethod()))
				{
					installmentAmount = installmentAmount - NumberUtil
							.nullToZero(islamicCalculatorCO.getCurrentLineActualProfitAmount() - vatAmount);
				}
				else
				{
					installmentAmount = installmentAmount - profitAmount - vatAmount;
				}

			}
			pushDownProfitAmount = profitAmount;
			profitAmount = 0D;
			vatAmount = 0d;
		}
		else if(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT
				.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE())
				|| "I".equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE()))
		{
			noOfInstallmentForEqualize = 1L;
			if(installmentAmount < profitAmount + vatAmount
					&& !index.equals(islamicCalculatorCO.getTrspayplandetVOList().size() - 1))
			{
				pushDownProfitAmount = profitAmount;
				profitAmount = installmentAmount;
				if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment())
						&& ConstantsCommon.NO.equals(islamicCalculatorCO.getCalculateVatAfterSchedule()))
				{
					vatAmount = calculateVatAmount(islamicCalculatorCO, installmentAmount, profitAmount,
							ConstantsCommon.YES);
				}
				profitAmount = profitAmount - vatAmount;
				pushDownProfitAmount = pushDownProfitAmount - profitAmount;
			}
		}
	}

	if(NumberUtil.toInteger(islamicCalculatorCO.getTrspayplandetVOList().get(index).getBALLOON_PAYMENT()) == 1)
	{// if balloon payment exist
	    Double baloonAmount = NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getBALLOON_AMOUNT());
	    if(ConstantsCommon.YES
		    .equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getNormalInstallment()))
	    {
		/*
		 * Means this line is both normal installment and Balloon
		 * payment then need to check the ctrl info whether the normal
		 * installment also added with the balloon amount
		 */
		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getInstAmtInBalloon()))
		{
		    // add the normal installment amount with the balloon amount
		    if(index.equals(islamicCalculatorCO.getTrspayplandetVOList().size() - 1))
		    {
			/*
			 * if this is the lastInstallment, need to check another
			 * flag to add the normal installment amount with
			 * balloon amount
			 */
			if(ConstantsCommon.YES.equals(islamicCalculatorCO.getInstAmtInLastBalloon()))
			{
			    installmentAmount = installmentAmount + baloonAmount;
			}
			else
			{
			    // no need to add the installment amount with
			    // balloon amount
			    installmentAmount = baloonAmount;
			}
		    }
		    else
		    {
			installmentAmount = installmentAmount + baloonAmount;
		    }
		}
		else if(index.equals(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
			&& ConstantsCommon.YES.equals(islamicCalculatorCO.getInstAmtInLastBalloon()))
		{
		    /*
		     * need to check this is the last Balloon payment, if so
		     * need to check another flag to add the normal installment
		     * amount with balloon amount
		     */
		    // add the normal installment amount with the balloon amount
		    installmentAmount = installmentAmount + baloonAmount;
		}
		else
		{
		    // no need to add the installment amount with balloon amount
		    installmentAmount = baloonAmount;
		    if(installmentAmount < profitAmount + vatAmount
			    && !index.equals(islamicCalculatorCO.getTrspayplandetVOList().size() - 1))
		    {
			pushDownProfitAmount = profitAmount;
			profitAmount = installmentAmount;

			if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment())
				&& ConstantsCommon.NO.equals(islamicCalculatorCO.getCalculateVatAfterSchedule()))
			{
			    vatAmount = calculateVatAmount(islamicCalculatorCO, installmentAmount, profitAmount,
				    ConstantsCommon.YES);
			}
			profitAmount = profitAmount - vatAmount;
			pushDownProfitAmount = pushDownProfitAmount - profitAmount;
		    }
		}
	    }
	    else
	    {
		installmentAmount = baloonAmount;

		if(installmentAmount < profitAmount + vatAmount)
		{
		    pushDownProfitAmount = profitAmount;
		    profitAmount = installmentAmount;

		    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment())
			    && ConstantsCommon.NO.equals(islamicCalculatorCO.getCalculateVatAfterSchedule()))
		    {
			vatAmount = calculateVatAmount(islamicCalculatorCO, installmentAmount, profitAmount,
				ConstantsCommon.YES);
		    }
		    profitAmount = profitAmount - vatAmount;
		    pushDownProfitAmount = pushDownProfitAmount - profitAmount;
		}
	    }
	}
	structurePlanDet.setInstallmentAmount(installmentAmount);
	structurePlanDet.setNoOfInstallmentForEqualize(noOfInstallmentForEqualize);
	structurePlanDet.setPrincipleAmount(principleAmount);
	structurePlanDet.setProfitAmount(profitAmount);
	structurePlanDet.setPushDownProfitAmount(pushDownProfitAmount);
	structurePlanDet.setVatAmount(vatAmount);
	return structurePlanDet;
    }

    private void getDealAmount(IslamicCalculatorCO islamicCalculatorCO, Integer lineNo)
    {
	Date currentDate = islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).getVALUE_DATE();
	islamicCalculatorCO.setDealAmount(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(0).getAMOUNT());
	for(int j = 1; j < islamicCalculatorCO.getTrsDealMultipleDisbursementList().size(); j++)
	{
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement()))
	    {
		islamicCalculatorCO.setDealAmount(BigDecimal
			.valueOf(NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount()) + NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(j).getAMOUNT())));
		islamicCalculatorCO.setNextDisbursementDate(
			islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(j).getVALUE_DATE());
	    }
	    else if(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(j).getVALUE_DATE().before(currentDate))
	    {
		islamicCalculatorCO.setDealAmount(BigDecimal
			.valueOf(NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount()) + NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(j).getAMOUNT())));
		islamicCalculatorCO.setNextDisbursementDate(
			islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(j).getVALUE_DATE());
	    }
	}
    }

    private IslamicCalculatorStructurePlanDetCO getlineCharges(IslamicCalculatorCO islamicCalculatorCO,
	    Double capitalAmountParam, Double cumAllocatedParam, int currentLineNo, Double totalAmount)
    {
	Double capitalAmount = capitalAmountParam, cumAllocated = cumAllocatedParam;
	IslamicCalculatorStructurePlanDetCO structurePlanDet = new IslamicCalculatorStructurePlanDetCO();
	long count = 0L;
	int totalNoOfLine = islamicCalculatorCO.getTrspayplandetVOList().size();
	double lineAllocated = 0D;
	double outstaningAmount = NumberUtil.round(totalAmount - cumAllocated,
		islamicCalculatorCO.getDealCyDecimalPoint());
	int noOfexclCalcLines = 0;

	totalNoOfLine = totalNoOfLine - noOfexclCalcLines;


	if(capitalAmount > 0)
	{
	    lineAllocated = NumberUtil.round(outstaningAmount / (totalNoOfLine - currentLineNo),
		    islamicCalculatorCO.getDealCyDecimalPoint());
	    capitalAmount = NumberUtil.round(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    if(capitalAmount < lineAllocated && totalNoOfLine != currentLineNo + 1)
	    {
		lineAllocated = capitalAmount;
	    }
	    else
	    {
		count = 1L;
	    }
	}
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getArRahnuCalculatorYN())
		&& totalNoOfLine != currentLineNo + 1)
	{
	    lineAllocated = NumberUtil.nullToZero(islamicCalculatorCO.getAmountPerPayment()).doubleValue();
	}
	cumAllocated = NumberUtil.round(cumAllocated + lineAllocated, islamicCalculatorCO.getDealCyDecimalPoint());

	structurePlanDet.setLineAllocatedCount(count);
	structurePlanDet.setLineAllocatedCharges(lineAllocated);
	structurePlanDet.setCumAllocatedCharges(cumAllocated);
	return structurePlanDet;
    }

    private Integer getNextChangeEffectLinNo(IslamicCalculatorCO islamicCalculatorCO, Integer currentLineNo)
    {
	if(PAYPLAN_BASED_ON_REDUCE_INSTALLMENT.equals(islamicCalculatorCO.getGenerate_payplan_based_on()))
	{
	    return currentLineNo;
	}
	if(islamicCalculatorCO.isFirstLoop())
	{
	    islamicCalculatorCO.setFirstLoop(false);
	    if(!IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT
		    .equals(islamicCalculatorCO.getTrspayplandetVOList().get(0).getPAYMENT_TYPE()))
	    {
		return currentLineNo;
	    }
	}
	Date currDate = islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo).getVALUE_DATE();
	Date nextprofitChangeDate = islamicCalculatorCO.getNextProfitValueDate();
	if(islamicCalculatorCO.getTrsDealMultipleYieldVO().size() > 0
		&& (currDate.after(islamicCalculatorCO.getNextProfitValueDate())
			|| currDate.compareTo(islamicCalculatorCO.getNextProfitValueDate()) == 0))
	{
	    nextprofitChangeDate = getNextprofitRateChangeDate(islamicCalculatorCO);
	    islamicCalculatorCO.setNextProfitValueDate(nextprofitChangeDate);
	}
	/*
	 * MANOJ ON 22/09/2013
	 * if(islamicCalculatorCO.getTentativeSchedule().equals
	 * (ConstantsCommon.YES)) { islamicCalculatorCO
	 * .setNextDisbursementDate(getnextDisbursementDate(islamicCalculatorCO,
	 * islamicCalculatorCO.getNextDisbursementDate())); }
	 */
	return getNextPaytypeChanageLineNo(islamicCalculatorCO, currentLineNo, nextprofitChangeDate);
    }

    /*
     * private Date getnextDisbursementDate(IslamicCalculatorCO
     * islamicCalculatorCO, Date currDisbursementDate) { for(int i = 0; i <
     * islamicCalculatorCO.getTrsDealMultipleDisbursementList().size(); i++) {
     * if(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).
     * getVALUE_DATE().after( currDisbursementDate)) { return
     * islamicCalculatorCO
     * .getTrsDealMultipleDisbursementList().get(i).getVALUE_DATE(); } } return
     * islamicCalculatorCO.getMaturityDate(); }
     */
    
    private Integer getNextPaytypeChanageLineNo(IslamicCalculatorCO islamicCalculatorCO, Integer currentLineNo,
	    Date nextprofitChangeDate)
    {
	// Date previousValueDate =
	// islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo).getVALUE_DATE();
	int nextDisbursmentNo = 0;
	String prevPaymentType = null;
	for(int i = currentLineNo - 1; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    // if(i > currentLineNo) Manoj on 18/09/2013
	    if(i >= 0)
	    {
		Date curreLineDate = islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE();

		// if there is any profit rate change
		/*
		 * MANOJ ON 22/09/2013
		 * if(curreLineDate.after(islamicCalculatorCO
		 * .getNextDisbursementDate()) &&
		 * islamicCalculatorCO.getTrsDealMultipleDisbursementList
		 * ().size() > 0 &&
		 * (islamicCalculatorCO.getTentativeSchedule().equals
		 * (ConstantsCommon.YES) && islamicCalculatorCO
		 * .getEqualInstallmentForDisbursement
		 * ().equals(ConstantsCommon.NO))) { nextDisbursmentNo = i; }
		 */

		if(((curreLineDate.after(nextprofitChangeDate) || curreLineDate.equals(nextprofitChangeDate))
			&& islamicCalculatorCO.getTrsDealMultipleYieldVO().size() > 0)
			&& (islamicCalculatorCO.getMultipleYieldEqualiseFromValueDate().equals(ConstantsCommon.NO)
				|| IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
					.equals(islamicCalculatorCO.getProfitCalculationMethod())))
		{

		    // if profit change date < value date then next change line
		    // number is previous line
		    for(int j = 0; j < islamicCalculatorCO.getTrsDealMultipleYieldVO().size(); j++)
		    {
			if(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(j).getFROM_DATE()
				.compareTo(nextprofitChangeDate) == 0)
			{
			    islamicCalculatorCO
				    .setAnnualYeild(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(j).getYIELD());
			}

		    }
		    if(NumberUtil.toInteger(islamicCalculatorCO.getProfitAccrualBasis()) == 5)
		    {
			islamicCalculatorCO.setAvgDaysInYearsForProfitCalculation(
				BigDecimal.valueOf(getAverageYearDaysInDealPeriod(nextprofitChangeDate,
					islamicCalculatorCO.getMaturityDate())));
		    }
		    if(!curreLineDate.after(nextprofitChangeDate))
		    {
			// return i + 1;
			//return i;
		    	
		    if(curreLineDate.compareTo(nextprofitChangeDate) == 0)
		    {
		       return i + 1;
		    }
	    	   return i;
		    }
		    else
		    {
			return i + 1;
		    }

		}
		if(nextDisbursmentNo != 0)
		{
		    return i;
		}
		// >= is modifed to > for TAR BMO190009
		if(islamicCalculatorCO.getProfitCalculationMethod().equals("R")
			&& !islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE().equals("B")
			&& !islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE().equals("I")
			&& i > currentLineNo)
		{
		    /*
		     * if the payment type is not profit + principal then the
		     * next change line number is current line
		     */
		    return i;
		}
		//753982
		// >= is modifed to > for TAR BMO190009
		else if(islamicCalculatorCO.getProfitCalculationMethod().equals("S")
			&& ((islamicCalculatorCO.getTrsPayPlanCriteriaVO().size() > 0)
				|| NumberUtil.nullToZero(islamicCalculatorCO.getTemplateCode()).intValue() > 0)
			&& !islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE()
				.equals(prevPaymentType)
				&& i > currentLineNo)
		{
		    /*
		     * if the payment type is not profit + principal then the
		     * next change line number is current line
		     */

		    return i;
		}
		
		prevPaymentType = islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE();
	    }

	    // previousValueDate =
	    // islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE();
	}
	return islamicCalculatorCO.getTrspayplandetVOList().size() + 1;
    }

    private Double getInstallmentAdjustAmount(IslamicCalculatorCO islamicCalculatorCO, Double amount, Long totalMonths,
	    int loopCount)
    {
	double diffAmount = 0D;
	double dinominator = 1D;
	// if(loopCount < 3)
		// {
		// dinominator = .5D;
		// }
		// else
		// {
		if(Math.abs(amount) < .05D) {
			if (amount < 0 ){
				dinominator = -1D;
			}else{
				dinominator = 1D;
			}
			
			if(islamicCalculatorCO.getDealCyDecimalPoint().compareTo(2L) == 1){
				amount  = .001D;
			}else{
				amount  = .01D;
			}
			
			
		}else if(islamicCalculatorCO.getAnnualYeild().compareTo(BigDecimal.valueOf(750D)) == 1 || (totalMonths >= 250L))
		    {
			if(loopCount > 185)
			{
			    dinominator = 0.00010D;
			}
			else if(loopCount > 175)
			{
			    dinominator = 0.0010D;
			}
			else if(loopCount > 160)
			{
			    dinominator = 0.0040D;
			}
			else if(loopCount > 140)
			{
			    dinominator = 0.0070D;
			}
			else if(loopCount > 120)
			{
			    dinominator = 0.0090D;
			}
			else if(loopCount > 100)
			{
			    dinominator = 0.010D;
			}
			else if(loopCount > 80)
			{
			    dinominator = 0.0200D;
			}
			else if(loopCount > 50)
			{
			    dinominator = 0.030D;
			}
			else
			{
			    dinominator = 0.035D;
			}
		    }
		    else if(islamicCalculatorCO.getAnnualYeild().compareTo(BigDecimal.valueOf(500D)) == 1)
		    {
			dinominator = 0.020D;
		    }
		    else if(totalMonths >= 299L
			    || islamicCalculatorCO.getAnnualYeild().compareTo(BigDecimal.valueOf(100D)) == 1)
		    {
			dinominator = 0.02D;
		    }
		    else if(totalMonths >= 150L && islamicCalculatorCO.getAnnualYeild().compareTo(BigDecimal.valueOf(15D)) == 1)
		    {
			dinominator = 0.025D;
		    }
		    else if(totalMonths > 200L)
		    {
		    dinominator = 0.05D;
		    }
		    else if(totalMonths > 170L)
		    {
		    dinominator = 0.08D;
		    }
		    else if(totalMonths > 160L)
		    {
		    dinominator = 0.15D;
		    }
		    else if(totalMonths > 150L)
		    {
		    dinominator = 0.2D;
		    }
		    else if(totalMonths > 143L || islamicCalculatorCO.getAnnualYeild().compareTo(BigDecimal.valueOf(50D)) == 1)
		    {
		    dinominator = 0.25D;
		    }
		    else if(totalMonths > 119L)
		    {
		    dinominator = 0.3D;
		    }
		    else if(totalMonths > 96L || islamicCalculatorCO.getAnnualYeild().compareTo(BigDecimal.valueOf(29D)) == 1)
		    {
		    dinominator = 0.35D;
		    }
		    else if(totalMonths > 72L)
		    {
		    dinominator = 0.45D;
		    }
		    else if(totalMonths > 48L)
		    {
		    dinominator = 0.45D;
		    }
		    else if(totalMonths > 24L)
		    {
		    dinominator = 0.5D;
		    }
		    else
		    {
		    dinominator = .6D;
		    }
	// }
	diffAmount = amount * dinominator;
	if (NumberUtil.round(diffAmount, islamicCalculatorCO.getDealCyDecimalPoint()) == 0D)
	{
	if(Math.abs(amount) > .05D) 
	{
		if (amount < 0 ){
			dinominator = -1D;
		}else{
			dinominator = 1D;
		}
		
		if(islamicCalculatorCO.getDealCyDecimalPoint().compareTo(2L) == 1){
			amount  = .001D;
		}else{
			amount  = .01D;
		}
	}
	diffAmount = amount * dinominator;
	}
	if(islamicCalculatorCO.getApplyRoundingFact_after_calc().equals(ConstantsCommon.NO)
		&& islamicCalculatorCO.getRoundingFactor() > 0L)
	{
	    double roundingValue = 0D;
	    switch (islamicCalculatorCO.getRoundingFactor().intValue())
	    {
		case 0:
		    break;
		case 1:
		    roundingValue = 1D;
		    break;
		case 2:
		    // Nearest 10
		    roundingValue = 10D;
		    break;
		case 3:
		    // Nearest 100
		    roundingValue = 100D;
		    break;
		case 4:
		    // Nearest 1000
		    roundingValue = 1000D;
		    break;
		default:
		    break;
	    }
	    if(Math.abs(diffAmount) < roundingValue)
	    {
		if(diffAmount > 0D)
		{
		    diffAmount = roundingValue;
		}
		else
		{
		    diffAmount = roundingValue * -1;
		}
	    }
	    // diffAmount = roundPmtAmount(islamicCalculatorCO, diffAmount,
	    // islamicCalculatorCO.getRoundingFactor());MANOJ_MV 19/08/2013
	}
	return NumberUtil.round(diffAmount, islamicCalculatorCO.getDealCyDecimalPoint());
    }

    private Double roundPmtAmount(IslamicCalculatorCO islamicCalculatorCO, Double amountParam, Long roundingFactor)
    {
	Double amount = amountParam;
	double roundingValue = 0D;

	switch (roundingFactor.intValue())
	{
	    case 0:
		// No Rounding
		return amount;
	    case 1:
		// Nearest 1
		// if(islamicCalculatorCO.getResidualValue().equals("D"))
		// {
		// return NumberUtil.truncate(amount, 0L);
		// }
		// else
		// {
		// return NumberUtil.round(amount, 0L);
		// }
		// return NumberUtil.truncate(amount, 0L);
		return applayRoundingType(islamicCalculatorCO, amountParam, 0L);
	    // falls through
	    case 2:
		// Nearest 10
		roundingValue = 10D;
		break;
	    case 3:
		// Nearest 100
		roundingValue = 100D;
		break;
	    case 4:
		// Nearest 1000
		roundingValue = 1000D;
		break;
	    default:
		break;
	}

	double amount1 = 0D;
	// if(islamicCalculatorCO.getResidualValue().equals("D"))
	// {
	//
	// }
	// else
	// if (!islamicCalculatorCO.getResidualValue().equals("D")) {
	// amount1 = NumberUtil.round(amount / roundingValue, 0);
	// }
	// amount = amount1 * roundingValue;
	if(islamicCalculatorCO.getResidualValue().equals("D"))
	{
	    islamicCalculatorCO.setROUNDING_TYPE_INST_AMT("D");
	}
	amount1 = amount / roundingValue;
	amount1 = applayRoundingType(islamicCalculatorCO, amount1, 0L);
	amount = amount1 * roundingValue;
	return amount;

	// return amount;
    }

    private Integer getNextDisbursmentPlanLineNo(IslamicCalculatorCO islamicCalculatorCO)
    {

	int currentDisbursementLineNo = 0;
	islamicCalculatorCO.setDealAmount(BigDecimal.valueOf(0d));
	for(int i = 0; i < islamicCalculatorCO.getTrsDealMultipleDisbursementList().size(); i++)
	{

	    islamicCalculatorCO.setDealAmount(
		    BigDecimal.valueOf(NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount()) + NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).getAMOUNT())));

	    if(islamicCalculatorCO.getValueDate()
		    .before(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).getVALUE_DATE())
		    || islamicCalculatorCO.getValueDate()
			    .equals((islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).getVALUE_DATE())))
	    {
		currentDisbursementLineNo = i;
		break;
	    }
	    if(ConstantsCommon.NO.equals(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).getPAID_IND()))
	    {
		currentDisbursementLineNo = i;
		break;
	    }
	}

	if(currentDisbursementLineNo == islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() - 1)
	{
	    return islamicCalculatorCO.getTrspayplandetVOList().size();
	}
	Date nextDisbursmentDate = islamicCalculatorCO.getTrsDealMultipleDisbursementList()
		.get(currentDisbursementLineNo + 1).getVALUE_DATE();

	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE().equals(nextDisbursmentDate))
	    {
		return i + 1;
	    }
	    if(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE().after(nextDisbursmentDate))
	    {
		return i;
	    }

	}
	return 0;
    }

    private List<TrspayplandetCO> reCalculateCompoundingProfitGracePeriod(IslamicCalculatorCO islamicCalculatorCO)
	    throws BaseException
    {

	if(islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().size() == 0)
	{
	    return islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod();
	}
	double totalOutstandingAmountForProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance());
	Date dateFrom = islamicCalculatorCO.getValueDate();
	islamicCalculatorCO.setTotalGracePeriodCompundingProfit(BigDecimal.valueOf(0d));
	String tempcompoundingProfit = islamicCalculatorCO.getCompoundingProfit();
	islamicCalculatorCO.setCompoundingProfit("H");
	String capitalize = ConstantsCommon.NO;
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().size(); i++)
	{
	    double profitAmount = 0D;
	    Date nextDate = islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i).getVALUE_DATE();

	    totalOutstandingAmountForProfitCalc = NumberUtil.round(totalOutstandingAmountForProfitCalc,
		    islamicCalculatorCO.getDealCyDecimalPoint());

	    if(islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() > 0
		    && islamicCalculatorCO.getTrsDealMultipleYieldVO().size() == 0
		    && ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule()))
	    {
		profitAmount = getMultipleDisbursementProfit(islamicCalculatorCO, islamicCalculatorCO.getValueDate(),
			dateFrom, nextDate, totalOutstandingAmountForProfitCalc, 0L, 0d,
			NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), 0, capitalize);
	    }
	    else if(islamicCalculatorCO.getTrsDealMultipleYieldVO().size() > 0
		    && ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule()))
	    {
		profitAmount = getMultipleYieldProfit(islamicCalculatorCO, islamicCalculatorCO.getValueDate(), dateFrom,
			nextDate, totalOutstandingAmountForProfitCalc, 0L, 0D, 0, capitalize);
	    }
	    else
	    {
		profitAmount = getProfitAmount(islamicCalculatorCO, dateFrom, nextDate,
			totalOutstandingAmountForProfitCalc, 0L, 0D,
			NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()), 0, capitalize);
	    }
	    profitAmount = NumberUtil.round(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i).setPROFIT_AMT(
		    NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i).setACTUAL_PROFIT_AMT(
		    NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i).setPROFIT_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i).setAMOUNT(BigDecimal.valueOf(0d));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i).setCAPITAL_AMT(
		    NumberUtil.roundToBigDecimal(profitAmount * -1, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i).setCAPITAL_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(profitAmount * -1, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i).setPRINCIPLE_AMT(
		    NumberUtil.roundToBigDecimal(profitAmount * -1, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i)
		    .setTOTAL_PRINCIPAL_OUTSTANDIG(BigDecimal.valueOf(0d));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i)
		    .setCHARGE_AMOUNT(BigDecimal.valueOf(0d));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i)
		    .setPROFIT_ON_CHARGES(BigDecimal.valueOf(0d));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i)
		    .setINSURANCE_AMOUNT(BigDecimal.valueOf(0d));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i)
		    .setPROFIT_ON_INSURANCE(BigDecimal.valueOf(0d));
	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i)
		    .setPRFT_AMT_PUSHDWN_FRM_ABV_INST(BigDecimal.valueOf(0d));

	    long totalDays = DateUtil.numberOfDays(dateFrom, nextDate);

	    islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod().get(i)
		    .setNO_OF_DAYS(BigDecimal.valueOf(totalDays));

	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule()))
	    {
		if(i == 1)
		{
		    totalOutstandingAmountForProfitCalc += getDisbursementAmountAsOfDate(islamicCalculatorCO, dateFrom,
			    nextDate) - NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount());
		}
		else
		{
		    totalOutstandingAmountForProfitCalc += getDisbursementAmountAsOfDate(islamicCalculatorCO, dateFrom,
			    nextDate);
		}
	    }
	    totalOutstandingAmountForProfitCalc += profitAmount;
	    islamicCalculatorCO.setTotalGracePeriodCompundingProfit(BigDecimal.valueOf(
		    NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit()) + profitAmount));
	    dateFrom = nextDate;
	}
	islamicCalculatorCO.setTotalGracePeriodCompundingProfit(BigDecimal.valueOf(
		NumberUtil.round(NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit()),
			islamicCalculatorCO.getDealCyDecimalPoint())));
	islamicCalculatorCO.setCompoundingProfit(tempcompoundingProfit);
	return islamicCalculatorCO.getTrspayplandetCompoundingGracePeriod();
    }

    private void printPlan(List<TrspayplandetCO> TrspayplandetVOList, IslamicCalculatorCO islamicCalculatorCO)
    {
	return;
//	 System.out.println("Xirr =" + " " +
//	 islamicCalculatorCO.getXirrOut());
//	 System.out.println("Remaining Amount =" + " " +
//	 islamicCalculatorCO.getOutRemainingAmount());
//	 System.out.println("Profit Amount =" + " " +
//	 islamicCalculatorCO.getOutProfitAmount());
//	 System.out.println("Amount Per Payment =" + " " +
//	 islamicCalculatorCO.getOutAmountPerPayment());
//	 System.out.println("Sale Amount =" + " " +
//	 islamicCalculatorCO.getOutSaleAmount());
//	 System.out.println("Annual Flat Rate =" + " " +
//	 islamicCalculatorCO.getOutAnnualFlatRate());
//	 System.out.println("Total Flat Rate =" + " " +
//	 islamicCalculatorCO.getOutTotalFlatRate());
//	
//	 //
////	// log.error("REPAYMENT PLAN SCHEDULE : SCHEDULE List:-
////	 //*******Start********* ");
////	
////	 System.out
////	 .println("# Date Pay Type Dyas % Installment Profit Capital principal
////	 Charges Profit On Charges "
////	 +
////	 "Ins Prft Ins outstanding Actual Profit CompProfit CAPITALIZED_PROFIT
////	 PushDownBeforeXIRR XNPV NetInvestOutStanding "
////	 +
////	 "EarnedProfit DeferredProfit ProfitB4XIRR CapitalB4XIRR
////	 PushdownAfterXIRR ROR Balloon Payment HijriDate Balloon Amt VAT "
////	 +
////	 "VAT% Depreciation Amt Accrual Amount GRACE_PRD_CMPND_PROFIT_AMT
////	 GRACE_PRD_CMPND_CAPITAL_AMT YIELD");
////	
////	 // log
////	 //
////	 .error("# Date Pay Type Dyas % Installment Profit Capital principal
////	 Charges Profit On Charges "
////	 // +
////	 //
////	 "Ins Prft Ins outstanding Actual Profit CompProfit CAPITALIZED_PROFIT
////	 PushDownBeforeXIRR XNPV NetInvestOutStanding "
////	 // +
////	 //
////	 "EarnedProfit DeferredProfit ProfitB4XIRR CapitalB4XIRR
////	 PushdownAfterXIRR ROR Balloon Payment HijriDate Balloon Amt VAT "
////	 // + "VAT% Depreciation Amt Accrual Amount");
//	
//	 for(TrspayplandetCO trspayplandetVO : TrspayplandetVOList)
//	 {
//	 trspayplandetVO.setAMOUNT(NumberUtil.roundToBigDecimal(trspayplandetVO.getAMOUNT() == null ? 0D
//	 : trspayplandetVO.getAMOUNT().doubleValue(), 3L));
//	 System.out.println(trspayplandetVO.getLINE_NBR() + " " +
//	 trspayplandetVO.getVALUE_DATE() + " "
//	 + trspayplandetVO.getPAYMENT_TYPE() + " " +
//	 trspayplandetVO.getNO_OF_DAYS() + " " + 0 + " "
//	 + trspayplandetVO.getAMOUNT() + " " + trspayplandetVO.getPROFIT_AMT()
//	 + " "
//	 + trspayplandetVO.getCAPITAL_AMT() + " " +
//	 trspayplandetVO.getPRINCIPLE_AMT() + " "
//	 + trspayplandetVO.getCHARGE_AMOUNT() + " " +
//	 trspayplandetVO.getPROFIT_ON_CHARGES() + " "
//	 + trspayplandetVO.getINSURANCE_AMOUNT() + " " +
//	 trspayplandetVO.getPROFIT_ON_INSURANCE() + " "
//	 + trspayplandetVO.getTOTAL_PRINCIPAL_OUTSTANDIG() + " " +
//	 trspayplandetVO.getACTUAL_PROFIT_AMT()
//	 + " " + trspayplandetVO.getMONTHLY_COMPOUNDED_PROFIT_AMT() + " "
//	 + trspayplandetVO.getMONTHLY_CAPITALIZED_PROFIT_AMT() + " "
//	 + trspayplandetVO.getPRFT_AMT_PUSHDWN_FRM_ABV_INST() + " " +
//	 trspayplandetVO.getXNPV() + " "
//	 + trspayplandetVO.getNET_INVEST_OUTSTANDING() + " " +
//	 trspayplandetVO.getTOTAL_EARNED_PROFIT()
//	 + " " + trspayplandetVO.getTOTAL_DEFERRED_PROFIT() + " "
//	 + trspayplandetVO.getPROFIT_AMT_BEFORE_XIRR() + " " +
//	 trspayplandetVO.getCAPITAL_AMT_BEFORE_XIRR()
//	 + " " + trspayplandetVO.getPUSHDOWN_PROFIT_AFTER_XIRR() + " " +
//	 trspayplandetVO.getROR() + " "
//	 + trspayplandetVO.getBALLOON_PAYMENT() + " " +
//	 trspayplandetVO.getVALUE_DATE_HIJRI() + " "
//	 + trspayplandetVO.getBALLOON_AMOUNT() + " " +
//	 trspayplandetVO.getVAT_AMOUNT() + " "
//	 + trspayplandetVO.getVAT_PERCENTAGE() + " " +
//	 trspayplandetVO.getDEPRECIATION_AMT() + " "
//	 + trspayplandetVO.getACCRUAL_AMT() + " " +
//	 trspayplandetVO.getGRACE_PRD_CMPND_PROFIT_AMT() + " "
//	 + trspayplandetVO.getGRACE_PRD_CMPND_CAPITAL_AMT() + " " +
//	 trspayplandetVO.getYIELD());
//	
//	 // log.error(trspayplandetVO.getLINE_NBR() + " " +
//	 // trspayplandetVO.getVALUE_DATE() + " "
//	 // + trspayplandetVO.getPAYMENT_TYPE() + " " +
//	 // trspayplandetVO.getNO_OF_DAYS() + " " + 0 + " "
//	 // + trspayplandetVO.getAMOUNT() + " " +
//	 // trspayplandetVO.getPROFIT_AMT() + " "
//	 // + trspayplandetVO.getCAPITAL_AMT() + " " +
//	 // trspayplandetVO.getPRINCIPLE_AMT() + " "
//	 // + trspayplandetVO.getCHARGE_AMOUNT() + " " +
//	 // trspayplandetVO.getPROFIT_ON_CHARGES() + " "
//	 // + trspayplandetVO.getINSURANCE_AMOUNT() + " " +
//	 // trspayplandetVO.getPROFIT_ON_INSURANCE() + " "
//	 // + trspayplandetVO.getTOTAL_PRINCIPAL_OUTSTANDIG() + " " +
//	 // trspayplandetVO.getACTUAL_PROFIT_AMT()
//	 // + " " + trspayplandetVO.getMONTHLY_COMPOUNDED_PROFIT_AMT() + " "
//	 // + trspayplandetVO.getMONTHLY_CAPITALIZED_PROFIT_AMT() + " "
//	 // + trspayplandetVO.getPRFT_AMT_PUSHDWN_FRM_ABV_INST() + " " +
//	 // trspayplandetVO.getXNPV() + " "
//	 // + trspayplandetVO.getNET_INVEST_OUTSTANDING() + " " +
//	 // trspayplandetVO.getTOTAL_EARNED_PROFIT()
//	 // + " " + trspayplandetVO.getTOTAL_DEFERRED_PROFIT() + " "
//	 // + trspayplandetVO.getPROFIT_AMT_BEFORE_XIRR() + " " +
//	 // trspayplandetVO.getCAPITAL_AMT_BEFORE_XIRR()
//	 // + " " + trspayplandetVO.getPUSHDOWN_PROFIT_AFTER_XIRR() + " " +
//	 // trspayplandetVO.getROR() + " "
//	 // + trspayplandetVO.getBALLOON_PAYMENT() + " " +
//	 // trspayplandetVO.getVALUE_DATE_HIJRI() + " "
//	 // + trspayplandetVO.getBALLOON_AMOUNT() + " " +
//	 // trspayplandetVO.getVAT_AMOUNT() + " "
//	 // + trspayplandetVO.getVAT_PERCENTAGE() + " " +
//	 // trspayplandetVO.getDEPRECIATION_AMT() + " "
//	 // + trspayplandetVO.getACCRUAL_AMT());
//	
//	 }
//	  System.out
//	 	 .println("*********************************************************************************************************");
//	 //
//	 //log.error("REPAYMENT PLAN SCHEDULE : SCHEDULE List:-
//	 //*******Start********* ");
    }

    private Double getDisbursementAmountAsOfDate(IslamicCalculatorCO islamicCalculatorCO, Date dateFrom, Date dateTo)
    {
	double amount = 0d;
	for(int j = 0; j < islamicCalculatorCO.getTrsDealMultipleDisbursementList().size(); j++)
	{

	    if((islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(j).getVALUE_DATE().equals(dateFrom)
		    || islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(j).getVALUE_DATE().after(dateFrom))
		    && islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(j).getVALUE_DATE().before(dateTo))
	    {
		amount += NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(j).getAMOUNT());
	    }
	}
	return NumberUtil.round(amount, islamicCalculatorCO.getDealCyDecimalPoint());
    }

    private void allocateResidualInstallmentValue(IslamicCalculatorCO islamicCalculatorCO, Double pmtAmountParam,
	    Double diffAmount, Integer noOfInstallment)
    {
	Double tempDiffAmount = diffAmount;
	for(int index = islamicCalculatorCO.getTrspayplandetVOList().size() - 1; index >= 0; index--)
	{
	    // if(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE().equals("B"))
	    // {
	    diffAmount = tempDiffAmount;
	    double tempAmount = NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT());
	    if(tempAmount > 0)
	    {
		if(tempAmount < Math.abs(diffAmount))
		{
		    diffAmount = tempAmount * -1;
		}
		tempDiffAmount = tempDiffAmount - diffAmount;
		tempAmount = tempAmount + diffAmount;
		tempAmount = NumberUtil.round(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setAMOUNT(
			NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

		tempAmount = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
		tempAmount = tempAmount + diffAmount;
		tempAmount = NumberUtil.round(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(
			NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT_BEFORE_XIRR(
			NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		Double chargesAmount = islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.getCHARGE_AMOUNT() == null ? 0D
				: islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT()
					.doubleValue();
		Double insuranceAmount = islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.getINSURANCE_AMOUNT() == null ? 0D
				: islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT()
					.doubleValue();

		islamicCalculatorCO.getTrspayplandetVOList().get(index).setPRINCIPLE_AMT(NumberUtil.roundToBigDecimal(
			tempAmount - chargesAmount - insuranceAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		if(tempDiffAmount == 0)
		{
		    break;
		}
	    }
	}
    }

    private void adjustResidualInstallmentValue(IslamicCalculatorCO islamicCalculatorCO, Double pmtAmountParam,
	    Double diffAmount, Integer noOfInstallment)
    {
	if(PAYPLAN_BASED_ON_REDUCE_INSTALLMENT.equals(islamicCalculatorCO.getGenerate_payplan_based_on())
		&& diffAmount < 0)
	{
	    allocateResidualInstallmentValue(islamicCalculatorCO, pmtAmountParam, diffAmount, noOfInstallment);
	    return;
	}

	Double pmtAmount = pmtAmountParam;
	if(IISCommonConstants.RESIDUAL_VALUE_LAST_INSTALLMENT.equals(islamicCalculatorCO.getResidualValue()))
	{
	    boolean lineFound = false;
	    // Adjust the difference amount with Last installment
	    int lineNo = noOfInstallment - 1;

	    // TP#153489; Ramesh; Date 17/07/2014 [added below if condition]
	    if(noOfInstallment > 1)
	    {

		if(islamicCalculatorCO.getAssetResidualAmount().compareTo(BigDecimal.ZERO) == 1)
		{
		    lineNo = lineNo - 1;
		}
		do
		{
		    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getPrincipalInLastPayment())
			    && IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
				    .equals(islamicCalculatorCO.getProfitCalculationMethod()))
		    {
			lineFound = true;
			break;
		    }
		    if(((NumberUtil.toInteger(
			    islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).getBALLOON_PAYMENT()) == 1
			    && islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).getBALLOON_AMOUNT()
				    .doubleValue() == islamicCalculatorCO.getTrspayplandetVOList().get(lineNo)
					    .getAMOUNT().doubleValue())
			    || (islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).getAMOUNT()
				    .doubleValue() <= 0))
			    || (islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).getCAPITAL_AMT()
				    .doubleValue() <= 0
				    && islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).getCAPITAL_AMT()
					    .doubleValue() + diffAmount < 0))
		    {
			lineNo--;

		    }
		    else
		    {
			lineFound = true;
		    }
		}while(!lineFound && lineNo >= 0);
	    }

	    if(lineNo < 0)
	    {
		lineNo = noOfInstallment - 1;
	    }
	    pmtAmount = NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).getAMOUNT())
		    + diffAmount;
	    pmtAmount = NumberUtil.round(pmtAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    islamicCalculatorCO.getTrspayplandetVOList().get(lineNo)
		    .setAMOUNT(NumberUtil.roundToBigDecimal(pmtAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    Double tempAmount = NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).getCAPITAL_AMT());
	    tempAmount = tempAmount + diffAmount;
	    tempAmount = NumberUtil.round(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).setCAPITAL_AMT(
		    NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).setCAPITAL_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    Double chargesAmount = islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).getCHARGE_AMOUNT() == null
		    ? 0D : islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).getCHARGE_AMOUNT().doubleValue();
	    // if(chargesAmount == null)
	    // {
	    // chargesAmount = 0.00;
	    // }
	    Double insuranceAmount = islamicCalculatorCO.getTrspayplandetVOList().get(lineNo)
		    .getINSURANCE_AMOUNT() == null ? 0d
			    : islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).getINSURANCE_AMOUNT()
				    .doubleValue();

	    // if(insuranceAmount == null)
	    // {
	    // insuranceAmount = 0.00;
	    // }
	    islamicCalculatorCO.getTrspayplandetVOList().get(lineNo).setPRINCIPLE_AMT(NumberUtil.roundToBigDecimal(
		    tempAmount - chargesAmount - insuranceAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	}
	else if(IISCommonConstants.RESIDUAL_VALUE_FIRST_INSTALLMENT.equals(islamicCalculatorCO.getResidualValue()))
	{
	    // Adjust the difference amount with First installment

	    // for(TrspayplandetCO trspayplandetCO :
	    // islamicCalculatorCO.getTrspayplandetVOList())
	    for(int index = 0; index < islamicCalculatorCO.getTrspayplandetVOList().size(); index++)
	    {
		if(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT
			.equals(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPAYMENT_TYPE()))
		{
		    double tempAmount = NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getAMOUNT());
		    tempAmount = tempAmount + diffAmount;
		    tempAmount = NumberUtil.round(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setAMOUNT(
			    NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

		    tempAmount = NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
		    tempAmount = tempAmount + diffAmount;
		    tempAmount = NumberUtil.round(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(
			    NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT_BEFORE_XIRR(
			    NumberUtil.roundToBigDecimal(tempAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		    Double chargesAmount = islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .getCHARGE_AMOUNT() == null ? 0D
				    : islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT()
					    .doubleValue();
		    Double insuranceAmount = islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .getINSURANCE_AMOUNT() == null ? 0D
				    : islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT()
					    .doubleValue();

		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPRINCIPLE_AMT(NumberUtil.roundToBigDecimal(tempAmount - chargesAmount - insuranceAmount,
				    islamicCalculatorCO.getDealCyDecimalPoint()));

		    break;
		}

	    }
	}
	else
	{
	   islamicCalculatorCO.setOutResidualValueDownPayment(NumberUtil.nullToZero(BigDecimal.valueOf(diffAmount))
		    .add(NumberUtil.nullToZero(islamicCalculatorCO.getDownPaymentAmt())));

	}
    }

    private void adjustStaightLineProfitAmount(IslamicCalculatorCO islamicCalculatorCO)
    {

	double totalExcessProfitAmount = 0D;
	for(int index = islamicCalculatorCO.getTrspayplandetVOList().size() - 1; index > 0; index--)
	{

	    if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT()) < 0D)
	    {
		totalExcessProfitAmount += NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
		totalExcessProfitAmount = NumberUtil.round(totalExcessProfitAmount,
			islamicCalculatorCO.getDealCyDecimalPoint());
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT(BigDecimal.valueOf(0D));
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setVAT_AMOUNT(BigDecimal.valueOf(0D));
		islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.setAMOUNT(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
		islamicCalculatorCO.getTrspayplandetVOList().get(index)
			.setACTUAL_PROFIT_AMT(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
			islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());

	    }
	    else
	    {
		if(NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT())
			+ totalExcessProfitAmount < 0)
		{
		    totalExcessProfitAmount += NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
		    totalExcessProfitAmount = NumberUtil.round(totalExcessProfitAmount,
			    islamicCalculatorCO.getDealCyDecimalPoint());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT(BigDecimal.valueOf(0D));
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setAMOUNT(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setVAT_AMOUNT(BigDecimal.valueOf(0D));
		}
		else
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPROFIT_AMT(
				    BigDecimal
					    .valueOf(NumberUtil.round(
						    NumberUtil
							    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
								    .get(index).getPROFIT_AMT())
							    + totalExcessProfitAmount,
						    islamicCalculatorCO.getDealCyDecimalPoint())));
		    totalExcessProfitAmount -= totalExcessProfitAmount;
		    totalExcessProfitAmount = NumberUtil.round(totalExcessProfitAmount,
			    islamicCalculatorCO.getDealCyDecimalPoint());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setAMOUNT(NumberUtil.roundToBigDecimal(NumberUtil.toDoubleObj(
				    islamicCalculatorCO.getTrspayplandetVOList().get(index).getCAPITAL_AMT())
				    + NumberUtil.toDoubleObj(
					    islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT())
				    + NumberUtil.toDoubleObj(
					    islamicCalculatorCO.getTrspayplandetVOList().get(index).getVAT_AMOUNT()),
				    islamicCalculatorCO.getDealCyDecimalPoint()));
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
		    islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
		    break;
		}
	    }
	}
    }

    private Integer getNoOfInstallmentAsBalloon(IslamicCalculatorCO islamicCalculatorCO, Integer lineNo)
    {
	int installmentAsBalloonLineCount = 0;
	for(int i = lineNo; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if("I".equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPAYMENT_TYPE()))
	    {
		installmentAsBalloonLineCount += 1;
	    }
	}
	return installmentAsBalloonLineCount;
    }

    private IslamicCalculatorCO setPlanInstallmentDetailsForProfitAndChargesOnly(
	    IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	String capitalize = ConstantsCommon.NO;
	double dealAmount = NumberUtil.toDoubleObj(islamicCalculatorCO.getDealAmount());
	double totalCharges = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges());
	double totalInsurance = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance());
	double totalGracePeriodCompundingProfit = NumberUtil
		.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());
	long dealCyDecimalPoint = islamicCalculatorCO.getDealCyDecimalPoint().longValue();
	double profitOnCharges = NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges());
	double profitOnInsurance = NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance());

	double totalOutstandingAmount = dealAmount + totalCharges + totalInsurance + totalGracePeriodCompundingProfit;
	totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount, dealCyDecimalPoint);
	double chargesAndInsuranceExcludingProfitCalc = (totalCharges + totalInsurance - profitOnCharges
		- profitOnInsurance);
	chargesAndInsuranceExcludingProfitCalc = NumberUtil.round(chargesAndInsuranceExcludingProfitCalc,
		dealCyDecimalPoint);

	double totalDealAmountForProfitCalc = dealAmount + profitOnCharges + profitOnInsurance
		+ totalGracePeriodCompundingProfit;
	totalDealAmountForProfitCalc = NumberUtil.round(totalDealAmountForProfitCalc, dealCyDecimalPoint);
	double totalAllocatedProfit = 0d;
	double lineTotalCharges = totalCharges / islamicCalculatorCO.getTrspayplandetVOList().size();
	double lineTotalInsurance = totalInsurance / islamicCalculatorCO.getTrspayplandetVOList().size();
	double lineProfitOnCharges = (profitOnCharges / islamicCalculatorCO.getTrspayplandetVOList().size());
	double lineProfitOnInsurance = (profitOnInsurance / islamicCalculatorCO.getTrspayplandetVOList().size());
	double yeildPercent = NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild());
	Date dealValueDate = islamicCalculatorCO.getValueDate();
	Date dealMatrutiyDate = islamicCalculatorCO.getMaturityDate();

	double totalProfitAmount = 0D;
	islamicCalculatorCO.setMultipleYieldEqualiseFromValueDate(ConstantsCommon.YES);
	

	if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		.equals(islamicCalculatorCO.getProfitCalculationMethod()))
	{
	    if(islamicCalculatorCO.getTrsDealMultipleYieldVO().size() > 0
		    && ConstantsCommon.NO.equals(islamicCalculatorCO.getProfitCalculateAsOnYieldDate()))
	    {
		islamicCalculatorCO.setIgoreIfStatement(0);
	    }
	    else
	    {
		totalProfitAmount = getProfitAmount(islamicCalculatorCO, dealValueDate, dealMatrutiyDate,
			totalDealAmountForProfitCalc, 0L, 0D, yeildPercent, 0, capitalize);
	    }
	}
	int index = 0;
	Date prviousDate = dealValueDate;
	double cumSumActualCharges = 0D;
	double cumSumAllocatedCharges = 0D;

	double cumSumActualProfitOnCharges = 0D;
	double cumSumAllocatedProfitOnCharges = 0D;

	double cumSumActualProfitOnInsurance = 0D;
	double cumSumAllocatedProfitOnInsurance = 0D;

	double cumSumActualInsurance = 0D;
	double cumSumAllocatedInsurance = 0D;
	Date nextprofitChangeDate = dealValueDate;

	for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
	{
	    long adjustDays = 0L;
	    double allocateLineCharge = 0D;
	    double allocateLineProfitOnCharges = 0D;
	    double allocateLineProfitOnInsurance = 0D;
	    double allocateLineInsurance = 0D;
	    double actualProfitAmount = 0D;

	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeInstallmentDateInProfitCalculation())
		    && NumberUtil.toInt(islamicCalculatorCO.getNoOfPayments()) != 1)
	    {
		if(index == 0)
		{
		    adjustDays = 1L;
		}
		else if(index == (islamicCalculatorCO.getTrspayplandetVOList().size() - 1))
		{
		    adjustDays = -1L;
		}
	    }

	    Date curDate = trspayplandetCO.getVALUE_DATE();
	    if(ConstantsCommon.NO.equals(islamicCalculatorCO.getProfitCalculateAsOnYieldDate()))
	    {
		if(curDate.after(nextprofitChangeDate))
		{
		    nextprofitChangeDate = getNextprofitRateChangeDate(islamicCalculatorCO);
		    islamicCalculatorCO.setNextProfitValueDate(nextprofitChangeDate);
		}
		if(prviousDate.after(nextprofitChangeDate))
		{
		    for(int j = 0; j < islamicCalculatorCO.getTrsDealMultipleYieldVO().size(); j++)
		    {
			if(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(j).getFROM_DATE()
				.equals(nextprofitChangeDate))
			{
			    yeildPercent = NumberUtil
				    .toDoubleObj(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(j).getYIELD());
			}
		    }
		}
	    }

	    if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		    .equals(islamicCalculatorCO.getProfitCalculationMethod()))
	    {
		actualProfitAmount = getProfitAmount(islamicCalculatorCO, prviousDate, curDate,
			totalDealAmountForProfitCalc, adjustDays, 0D, yeildPercent, index, capitalize);
	    }
	    else
	    {
		actualProfitAmount = getProfitAmount(islamicCalculatorCO, prviousDate, curDate, totalOutstandingAmount,
			adjustDays, chargesAndInsuranceExcludingProfitCalc, yeildPercent, index, capitalize);
	    }

	    actualProfitAmount = NumberUtil.round(actualProfitAmount, dealCyDecimalPoint);

	    if(totalCharges > 0D)
	    {
		allocateLineCharge = NumberUtil.round(lineTotalCharges, dealCyDecimalPoint);
		cumSumActualCharges = cumSumActualCharges + lineTotalCharges;
		cumSumAllocatedCharges = NumberUtil.round(cumSumAllocatedCharges + allocateLineCharge,
			dealCyDecimalPoint);
		double chargeDiff = NumberUtil.round(cumSumActualCharges - cumSumAllocatedCharges, dealCyDecimalPoint);
		if(chargeDiff != 0D)
		{
		    allocateLineCharge = NumberUtil.round(allocateLineCharge + chargeDiff, dealCyDecimalPoint);
		    cumSumAllocatedCharges = NumberUtil.round(cumSumAllocatedCharges + chargeDiff, dealCyDecimalPoint);
		}

		islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGE_AMOUNT(
			NumberUtil.roundToBigDecimal(allocateLineCharge, islamicCalculatorCO.getDealCyDecimalPoint()));

		if(profitOnCharges > 0D)
		{
		    allocateLineProfitOnCharges = NumberUtil.round(lineProfitOnCharges, dealCyDecimalPoint);
		    cumSumActualProfitOnCharges = cumSumActualProfitOnCharges + lineProfitOnCharges;

		    cumSumAllocatedProfitOnCharges = NumberUtil
			    .round(cumSumAllocatedProfitOnCharges + allocateLineProfitOnCharges, dealCyDecimalPoint);
		    double profitOnChargesDiff = NumberUtil
			    .round(cumSumActualProfitOnCharges - cumSumAllocatedProfitOnCharges, dealCyDecimalPoint);
		    if(profitOnChargesDiff != 0)
		    {

			allocateLineProfitOnCharges = NumberUtil
				.round(allocateLineProfitOnCharges + profitOnChargesDiff, dealCyDecimalPoint);
			cumSumAllocatedProfitOnCharges = NumberUtil
				.round(cumSumAllocatedProfitOnCharges + profitOnChargesDiff, dealCyDecimalPoint);
		    }
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPROFIT_ON_CHARGES(NumberUtil.roundToBigDecimal(allocateLineProfitOnCharges,
				    islamicCalculatorCO.getDealCyDecimalPoint()));
		}
		else
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPROFIT_ON_CHARGES(BigDecimal.valueOf(0D));
		}
	    }
	    else
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGE_AMOUNT(BigDecimal.valueOf(0D));
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_ON_CHARGES(BigDecimal.valueOf(0D));
	    }

	    if(totalInsurance > 0D)
	    {
		allocateLineInsurance = NumberUtil.round(lineTotalInsurance, dealCyDecimalPoint);
		cumSumActualInsurance = cumSumActualInsurance + lineTotalInsurance;

		cumSumAllocatedInsurance = NumberUtil.round(cumSumAllocatedInsurance + allocateLineInsurance,
			dealCyDecimalPoint);
		double insuranceDiff = NumberUtil.round(cumSumActualInsurance - cumSumAllocatedInsurance,
			dealCyDecimalPoint);

		if(insuranceDiff != 0D)
		{
		    allocateLineInsurance = NumberUtil.round(allocateLineInsurance + insuranceDiff, dealCyDecimalPoint);
		    cumSumAllocatedInsurance = NumberUtil.round(cumSumAllocatedInsurance + insuranceDiff,
			    dealCyDecimalPoint);
		}
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_AMOUNT(NumberUtil
			.roundToBigDecimal(allocateLineInsurance, islamicCalculatorCO.getDealCyDecimalPoint()));

		if(profitOnInsurance > 0D)
		{
		    allocateLineProfitOnInsurance = NumberUtil.round(lineProfitOnInsurance, dealCyDecimalPoint);
		    cumSumActualProfitOnInsurance = cumSumActualProfitOnInsurance + lineProfitOnInsurance;

		    cumSumAllocatedProfitOnInsurance = NumberUtil.round(
			    cumSumAllocatedProfitOnInsurance + allocateLineProfitOnInsurance, dealCyDecimalPoint);
		    Double ProfitOnInsuranceDiff = NumberUtil.round(
			    cumSumActualProfitOnInsurance - cumSumAllocatedProfitOnInsurance, dealCyDecimalPoint);
		    if(ProfitOnInsuranceDiff.compareTo(0D) != 0)
		    {
			allocateLineProfitOnInsurance = NumberUtil
				.round(allocateLineProfitOnInsurance + ProfitOnInsuranceDiff, dealCyDecimalPoint);
			cumSumAllocatedProfitOnInsurance = NumberUtil
				.round(cumSumAllocatedProfitOnInsurance + ProfitOnInsuranceDiff, dealCyDecimalPoint);
		    }
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPROFIT_ON_INSURANCE(NumberUtil.roundToBigDecimal(allocateLineProfitOnInsurance,
				    islamicCalculatorCO.getDealCyDecimalPoint()));
		}
		else
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(index)
			    .setPROFIT_ON_INSURANCE(BigDecimal.valueOf(0D));
		}
	    }
	    else
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_AMOUNT(BigDecimal.valueOf(0D));
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_ON_INSURANCE(BigDecimal.valueOf(0D));
	    }

	    chargesAndInsuranceExcludingProfitCalc = chargesAndInsuranceExcludingProfitCalc
		    - (allocateLineCharge - allocateLineProfitOnCharges)
		    - (allocateLineInsurance - allocateLineProfitOnInsurance);
	    chargesAndInsuranceExcludingProfitCalc = NumberUtil.round(chargesAndInsuranceExcludingProfitCalc,
		    dealCyDecimalPoint);

	    double installmentAmount = NumberUtil.round(actualProfitAmount + allocateLineCharge + allocateLineInsurance,
		    dealCyDecimalPoint);
	    double capitalAmount = NumberUtil.round(installmentAmount - actualProfitAmount, dealCyDecimalPoint);

	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setAMOUNT(
		    NumberUtil.roundToBigDecimal(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT(
		    NumberUtil.roundToBigDecimal(actualProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPRINCIPLE_AMT(BigDecimal.valueOf(0D));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(
		    NumberUtil.roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT(
		    NumberUtil.roundToBigDecimal(actualProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(actualProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setTOTAL_PRINCIPAL_OUTSTANDIG(
		    NumberUtil.roundToBigDecimal(totalOutstandingAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT_BEFORE_XIRR(
		    NumberUtil.roundToBigDecimal(actualProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));

	    if(islamicCalculatorCO.getTrspayplandetVOList().get(index).getNO_OF_DAYS() == null)
	    {
		long totalDays = DateUtil.numberOfDays(prviousDate, curDate);
		totalDays = totalDays + adjustDays;
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setNO_OF_DAYS(BigDecimal.valueOf(totalDays));
	    }

	    index++;
	    prviousDate = curDate;
	    totalOutstandingAmount = NumberUtil.round(totalOutstandingAmount - capitalAmount, dealCyDecimalPoint);
	    totalAllocatedProfit += actualProfitAmount;
	}
	index--;
	// if(totalCharges != cumSumAllocatedCharges)
	if(BigDecimal.valueOf(totalCharges).compareTo(BigDecimal.valueOf(cumSumAllocatedCharges)) != 0)
	{
	    double diff = NumberUtil.round(totalCharges - cumSumAllocatedCharges, dealCyDecimalPoint);
	    double allocateLineCharge = NumberUtil.round(
		    (NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT())
			    + diff),
		    dealCyDecimalPoint);
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setCHARGE_AMOUNT(
		    NumberUtil.roundToBigDecimal(allocateLineCharge, islamicCalculatorCO.getDealCyDecimalPoint()));
	}
	// if(totalInsurance != cumSumAllocatedInsurance)
	if(BigDecimal.valueOf(totalInsurance).compareTo(BigDecimal.valueOf(cumSumAllocatedInsurance)) != 0)
	{
	    double diff = NumberUtil.round(totalInsurance - cumSumAllocatedInsurance, dealCyDecimalPoint);
	    double allocateLineInsurance = NumberUtil.round(
		    (NumberUtil.toDoubleObj(
			    islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT()) + diff),
		    dealCyDecimalPoint);
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setINSURANCE_AMOUNT(
		    NumberUtil.roundToBigDecimal(allocateLineInsurance, islamicCalculatorCO.getDealCyDecimalPoint()));
	}
	if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		.equals(islamicCalculatorCO.getProfitCalculationMethod()) && totalProfitAmount > 0D)
	{
	    totalAllocatedProfit = NumberUtil.round(totalAllocatedProfit, dealCyDecimalPoint);
	    // if(totalAllocatedProfit != totalProfitAmount)
	    if(BigDecimal.valueOf(totalAllocatedProfit).compareTo(BigDecimal.valueOf(totalProfitAmount)) != 0)
	    {
		Double diff = NumberUtil.round(totalProfitAmount - totalAllocatedProfit, dealCyDecimalPoint);
		Double newProfitAmount = NumberUtil.round(
			(NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT())
				+ diff),
			dealCyDecimalPoint);
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT(
			NumberUtil.roundToBigDecimal(newProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setPROFIT_AMT_BEFORE_XIRR(
			NumberUtil.roundToBigDecimal(newProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT(
			NumberUtil.roundToBigDecimal(newProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(index).setACTUAL_PROFIT_AMT_BEFORE_XIRR(
			NumberUtil.roundToBigDecimal(newProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	    }
	}
	double installmentAmount = dealAmount
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT())
		+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
	installmentAmount = NumberUtil.round(installmentAmount, dealCyDecimalPoint);

	double capitalAmount = installmentAmount
		- NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getPROFIT_AMT());
	capitalAmount = NumberUtil.round(capitalAmount, dealCyDecimalPoint);

	double principalAmount = capitalAmount
		- (NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(index).getCHARGE_AMOUNT())
			+ NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrspayplandetVOList().get(index).getINSURANCE_AMOUNT()));
	principalAmount = NumberUtil.round(principalAmount, dealCyDecimalPoint);

	islamicCalculatorCO.getTrspayplandetVOList().get(index).setAMOUNT(
		NumberUtil.roundToBigDecimal(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	islamicCalculatorCO.getTrspayplandetVOList().get(index).setPRINCIPLE_AMT(
		NumberUtil.roundToBigDecimal(principalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT(
		NumberUtil.roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	islamicCalculatorCO.getTrspayplandetVOList().get(index).setCAPITAL_AMT_BEFORE_XIRR(
		NumberUtil.roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	islamicCalculatorCO.getTrspayplandetVOList().get(index).setTOTAL_PRINCIPAL_OUTSTANDIG(
		NumberUtil.roundToBigDecimal(capitalAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
	return islamicCalculatorCO;
    }

    private Date getNextprofitRateChangeDate(IslamicCalculatorCO islamicCalculatorCO)
    {
	for(int i = 0; i < islamicCalculatorCO.getTrsDealMultipleYieldVO().size(); i++)
	{
	    if(islamicCalculatorCO.getNextProfitValueDate() == null)
	    {
		continue;
	    }
	    if(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i).getFROM_DATE()
		    .after(islamicCalculatorCO.getNextProfitValueDate()))
	    {
		return islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i).getFROM_DATE();
	    }
	}
	return islamicCalculatorCO.getMaturityDate();
    }

    private Date getNextprofitRateChangeEffectiveDate(IslamicCalculatorCO islamicCalculatorCO, Date profitChangeDate)
    {
	// islamicCalculatorCO.getTrspayplandetVOList().get(changeEffectLineNo)
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE().after(profitChangeDate)
		    || islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE().equals(profitChangeDate))
	    {
		return islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE();
	    }
	}
	return islamicCalculatorCO.getMaturityDate();
    }

    private Double getProfitAmount(IslamicCalculatorCO islamicCalculatorCO, Date dateFrom, Date dateToParam,
	    Double amount, Long adjustDaysParam, Double chargesAndInsuranceExcludingProfitCals,
	    Double yeildPercentParam, Integer currentLineNo, String capitalize) throws BaseException
    {

	Date dateTo = dateToParam;
	Long adjustDays = adjustDaysParam;
	Double yeildPercent = yeildPercentParam;
	/**
	 * For Bills Calculator
	 */
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	{
	    if(INTEREST_CALCULATION_METHOD_SIMPLE.equals(islamicCalculatorCO.getInterest_calculation_method()))
	    {
		amount = NumberUtil.toDouble(islamicCalculatorCO.getAmountPerPayment());
	    }
	    chargesAndInsuranceExcludingProfitCals = 0D;
	}

	if((islamicCalculatorCO.getTrsDealMultipleYieldVO().size() == 0
		&& islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() == 0)
		|| (islamicCalculatorCO.getProfitCalculateAsOnYieldDate().equals(ConstantsCommon.NO)
			&& islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() == 0))
	{
	    if(IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())
		    || IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit()))
	    {
		return getDealPeriodCompundingProfitNormal(islamicCalculatorCO, dateFrom, dateTo, amount, adjustDays,
			chargesAndInsuranceExcludingProfitCals, yeildPercent, currentLineNo, ConstantsCommon.NO,
			capitalize);
	    }
	    else
	    {
	    if(currentLineNo == 0 
					&& islamicCalculatorCO.getTrsDealMultipleYieldVO().size() > 0
					&& islamicCalculatorCO.getCalculateMultipleYieldProfitForGracePeriod().equals("Y") ) {
				double totalProfitAmount = getMultipleYieldProfit(islamicCalculatorCO, dateFrom, dateFrom, dateTo, amount,
					    adjustDays, chargesAndInsuranceExcludingProfitCals, currentLineNo, capitalize);
				return NumberUtil.round(totalProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
			}
		return calculateProfitAmount(islamicCalculatorCO, dateFrom, dateTo, amount, adjustDays,
			chargesAndInsuranceExcludingProfitCals, yeildPercent, capitalize);
	    }
	}

	Date yieldToDate = islamicCalculatorCO.getMaturityDate();
	// Date yieldFromDate = islamicCalculatorCO.getValueDate();
	// Double actualYield = yeildPercent;
	if(adjustDays.compareTo(0L) != 0)
	{
	    dateTo = DateUtil.dateAdd(DateUtil.DAY, adjustDays, dateTo);
	    adjustDays = 0L;
	}

	if(islamicCalculatorCO.getTrsDealMultipleYieldVO().size() > 0)
	{
	    yieldToDate = islamicCalculatorCO.getTrsDealMultipleYieldVO()
		    .get(islamicCalculatorCO.getTrsDealMultipleYieldVO().size() - 1).getFROM_DATE();
	    if((dateFrom.compareTo(yieldToDate) == 0 || dateFrom.after(yieldToDate)) && (islamicCalculatorCO
		    .getNextProfitValueDate().compareTo(islamicCalculatorCO.getMaturityDate()) == 0))
	    {
		yeildPercent = NumberUtil.toDoubleObj(islamicCalculatorCO.getTrsDealMultipleYieldVO()
			.get(islamicCalculatorCO.getTrsDealMultipleYieldVO().size() - 1).getYIELD());
		if(islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() > 0)
		{
		    if(IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())
			    || IISCommonConstants.COMPOUND_PROFIT_BOTH
				    .equals(islamicCalculatorCO.getCompoundingProfit()))
		    {
			return getDealPeriodCompundingProfitNormal(islamicCalculatorCO, dateFrom, dateTo, amount,
				adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent, currentLineNo, "D",
				capitalize);
		    }
		    else
		    {
			return getMultipleDisbursementProfit(islamicCalculatorCO, dateFrom, dateFrom, dateTo, amount,
				adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent, currentLineNo,
				capitalize);
		    }
		}
		else
		{
		    if(IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())
			    || IISCommonConstants.COMPOUND_PROFIT_BOTH
				    .equals(islamicCalculatorCO.getCompoundingProfit()))
		    {
			return getDealPeriodCompundingProfitNormal(islamicCalculatorCO, dateFrom, dateTo, amount,
				adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent, currentLineNo,
				ConstantsCommon.NO, capitalize);
		    }
		    else
		    {
			return calculateProfitAmount(islamicCalculatorCO, dateFrom, dateTo, amount, adjustDays,
				chargesAndInsuranceExcludingProfitCals, yeildPercent, capitalize);
		    }
		}
	    }
	    // yieldFromDate =
	    // islamicCalculatorCO.getTrsDealMultipleYieldVO().get(0).getFROM_DATE();
	    // actualYield =
	    // NumberUtil.toDoubleObj(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(0).getYIELD());
	}
	else
	{
	    if(IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())
		    || IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit()))
	    {
		return getDealPeriodCompundingProfitNormal(islamicCalculatorCO, dateFrom, dateTo, amount, adjustDays,
			chargesAndInsuranceExcludingProfitCals, yeildPercent, currentLineNo, "D", capitalize);
	    }
	    else
	    {
		return getMultipleDisbursementProfit(islamicCalculatorCO, dateFrom, dateFrom, dateTo, amount,
			adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent, currentLineNo, capitalize);
	    }
	}

	if((dateFrom.after(islamicCalculatorCO.getNextProfitValueDate())
		|| dateFrom.compareTo(islamicCalculatorCO.getNextProfitValueDate()) == 0)
		&& ConstantsCommon.NO.equals(islamicCalculatorCO.getMultipleYieldEqualiseFromValueDate()))
	{
	    if(islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() > 0)
	    {
		if(IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())
			|| IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit()))
		{
		    return getDealPeriodCompundingProfitNormal(islamicCalculatorCO, dateFrom, dateTo, amount,
			    adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent, currentLineNo, "D",
			    capitalize);
		}
		else
		{
		    return getMultipleDisbursementProfit(islamicCalculatorCO, dateFrom, dateFrom, dateTo, amount,
			    adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent, currentLineNo,
			    capitalize);
		}
	    }
	    else
	    {
		if(IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())
			|| IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit()))
		{
		    return getDealPeriodCompundingProfitNormal(islamicCalculatorCO, dateFrom, dateTo, amount,
			    adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent, currentLineNo,
			    ConstantsCommon.NO, capitalize);
		}
		else
		{
			if(currentLineNo == 0 
					&& islamicCalculatorCO.getTrsDealMultipleYieldVO().size() > 0
					&& islamicCalculatorCO.getCalculateMultipleYieldProfitForGracePeriod().equals("Y") ) {
				double totalProfitAmount = getMultipleYieldProfit(islamicCalculatorCO, dateFrom, dateFrom, dateTo, amount,
					    adjustDays, chargesAndInsuranceExcludingProfitCals, currentLineNo, capitalize);
				return NumberUtil.round(totalProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
			}
		    return calculateProfitAmount(islamicCalculatorCO, dateFrom, dateTo, amount, adjustDays,
			    chargesAndInsuranceExcludingProfitCals, yeildPercent, capitalize);
		}
	    }
	}

	double totalProfitAmount = 0d;
	if(IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())
		|| IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit()))
	{
	    return getDealPeriodCompundingProfitNormal(islamicCalculatorCO, dateFrom, dateTo, amount, adjustDays,
		    chargesAndInsuranceExcludingProfitCals, yeildPercent, currentLineNo, ConstantsCommon.YES,
		    capitalize);
	}
	else
	{
	    totalProfitAmount = getMultipleYieldProfit(islamicCalculatorCO, dateFrom, dateFrom, dateTo, amount,
		    adjustDays, chargesAndInsuranceExcludingProfitCals, currentLineNo, capitalize);
	}
	return NumberUtil.round(totalProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
    }

    private Double getMultipleYieldProfit(IslamicCalculatorCO islamicCalculatorCO, Date actualFromDate, Date dateFrom,
	    Date dateTo, Double amount, Long adjustDays, Double chargesAndInsuranceExcludingProfitCals,
	    Integer currentLineNo, String capitalize) throws BaseException
    {
	Date newFromDate = dateFrom;
	Date yieldToDate = islamicCalculatorCO.getMaturityDate();
	double totalProfitAmount = 0d;
	Date yieldFromDate = islamicCalculatorCO.getTrsDealMultipleYieldVO().get(0).getFROM_DATE();
	double actualYield = NumberUtil.toDoubleObj(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(0).getYIELD());

	for(int i = 0; i < islamicCalculatorCO.getTrsDealMultipleYieldVO().size(); i++)
	{
	    yieldToDate = islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i).getFROM_DATE();

	    if((newFromDate.after(yieldFromDate) || newFromDate.compareTo(yieldFromDate) == 0)
		    && (dateTo.before(yieldToDate) || dateTo.compareTo(yieldToDate) == 0))
	    {
		totalProfitAmount += getMultipleDisbursementProfit(islamicCalculatorCO, actualFromDate, newFromDate,
			dateTo, amount, adjustDays, chargesAndInsuranceExcludingProfitCals, actualYield, currentLineNo,
			capitalize);
		return totalProfitAmount;
	    }
	    else if(newFromDate.before(yieldToDate) && dateTo.after(yieldToDate))
	    {
		totalProfitAmount += getMultipleDisbursementProfit(islamicCalculatorCO, actualFromDate, newFromDate,
			yieldToDate, amount, adjustDays, chargesAndInsuranceExcludingProfitCals, actualYield,
			currentLineNo, capitalize);
		newFromDate = yieldToDate;
	    }
	  	if(newFromDate.after(islamicCalculatorCO.getNextProfitValueDate())
		    && islamicCalculatorCO.getMultipleYieldEqualiseFromValueDate().equals(ConstantsCommon.NO)
		    && islamicCalculatorCO.getCalculateMultipleYieldProfitForGracePeriod().equals(ConstantsCommon.NO))
	    {
		break;
	    }
	    actualYield = NumberUtil.toDoubleObj(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i).getYIELD());
	    yieldFromDate = islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i).getFROM_DATE();

	    if(NumberUtil.toInteger(islamicCalculatorCO.getProfitAccrualBasis()) == 5)
	    {
		islamicCalculatorCO.setAvgDaysInYearsForProfitCalculation(BigDecimal
			.valueOf(getAverageYearDaysInDealPeriod(yieldToDate, islamicCalculatorCO.getMaturityDate())));
	    }
	}
	if(dateTo.after(yieldToDate))
	{
	    totalProfitAmount += getMultipleDisbursementProfit(islamicCalculatorCO, actualFromDate, newFromDate, dateTo,
		    amount, adjustDays, chargesAndInsuranceExcludingProfitCals, actualYield, currentLineNo, capitalize);
	}
	return NumberUtil.round(totalProfitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
    }

    private Double getDealPeriodCompundingProfitNormal(IslamicCalculatorCO islamicCalculatorCO, Date dateFromParam,
	    Date dateTo, Double amountParam, Long adjustDays, Double chargesAndInsuranceExcludingProfitCals,
	    Double yeildPercent, Integer currentLineNo, String calculationType, String capitalize) throws BaseException
    {
	Date dateFrom = dateFromParam;
	Double amount = amountParam;
	// to calculate the Compounding profit
	Date nextDate = dateFrom;
	double totalProfitAmount = 0d;
	String CompoundingPeriodicityMonthPos = "E";
	/*
	 * CompoundingPeriodicityMonthPos is currently every Month End only.
	 * this is for client specific scenario
	 */
	double profitAmount = 0d;
	Date actualFromDate = dateFrom;
	int count = 1;
	do
	{
	    // if(islamicCalculatorCO.getCompoundingProfitPeriodicity().equals("M")
	    if(IISCommonConstants.PERIODICITY_TYPE_M.equals(islamicCalculatorCO.getDealPeriodCompoundingPeriodicity())
		    && IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			    .equals(islamicCalculatorCO.getProfitCalculationMethod())
		    && NumberUtil.toInteger(islamicCalculatorCO.getDealPeriodCompoundingPeriodicityNo()) == 1)
	    {
		if(count == 1)
		{
		    nextDate = DateUtil.getMonthLastDay(nextDate);
		    nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(),
			    nextDate, islamicCalculatorCO.getDealPeriodCompoundingPeriodicity(),
			    islamicCalculatorCO.getDealPeriodCompoundingPeriodicityNo().longValue() - 1, 1L,
			    CompoundingPeriodicityMonthPos, null, "P");

		}
		else
		{
		    nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(),
			    nextDate, islamicCalculatorCO.getDealPeriodCompoundingPeriodicity(),
			    islamicCalculatorCO.getDealPeriodCompoundingPeriodicityNo(), 1L,
			    CompoundingPeriodicityMonthPos, null, "P");
		}
	    }
	    else
	    {
		nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(), nextDate,
			islamicCalculatorCO.getDealPeriodCompoundingPeriodicity(),
			islamicCalculatorCO.getDealPeriodCompoundingPeriodicityNo(), 1L,
			islamicCalculatorCO.getPaymentPeriodicityMonthPos(), null, "P");
	    }
	    if(nextDate.after(dateTo))
	    {
		nextDate = dateTo;
	    }
	    if(CALCULATIONTYPE_D.equals(calculationType))
	    {
		return getMultipleDisbursementProfit(islamicCalculatorCO, actualFromDate, dateFrom, nextDate, amount,
			adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent, currentLineNo, capitalize);
	    }
	    if(CALCULATIONTYPE_Y.equals(calculationType))
	    {
		totalProfitAmount = getMultipleYieldProfit(islamicCalculatorCO, actualFromDate, dateFrom, nextDate,
			amount, adjustDays, chargesAndInsuranceExcludingProfitCals, currentLineNo, capitalize);
	    }
	    else
	    {
		profitAmount = calculateProfitAmount(islamicCalculatorCO, dateFrom, nextDate, amount, adjustDays,
			chargesAndInsuranceExcludingProfitCals, yeildPercent, capitalize);
	    }
	    profitAmount = NumberUtil.round(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
	    dateFrom = nextDate;
	    amount += profitAmount;
	    totalProfitAmount += profitAmount;
	    if(IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
		    .equals(islamicCalculatorCO.getProfitCalculationMethod()))
	    {
		TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
		trspayplandetCO.setLINE_NBR(BigDecimal.valueOf(currentLineNo));
		trspayplandetCO.setVALUE_DATE(nextDate);
		trspayplandetCO.setMONTHLY_COMPOUNDED_PROFIT_AMT(
			NumberUtil.roundToBigDecimal(profitAmount * -1, islamicCalculatorCO.getDealCyDecimalPoint()));
		trspayplandetCO.setAMOUNT(BigDecimal.valueOf(0d));
		trspayplandetCO.setPROFIT_AMT(BigDecimal.valueOf(0d));
		// trspayplandetCO.setPAYMENT_TYPE("P");
		trspayplandetCO.setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_COMPOUND_PROFIT);
		islamicCalculatorCO.getTrspayplandetCompoundingDealPeriod().add(trspayplandetCO);
	    }
	    count++;
	    // if(islamicCalculatorCO.getCompoundingProfitPeriodicity().equals("G"))
	    // break;
	}while(nextDate.before(dateTo));
	return totalProfitAmount;
    }

	private Double getMultipleDisbursementProfit(IslamicCalculatorCO islamicCalculatorCO, Date actualFromDate,
	    Date dateFromParam, Date dateTo, Double amount, Long adjustDays,
	    Double chargesAndInsuranceExcludingProfitCals, Double yeildPercent, Integer currentLineNo,
	    String capitalize) throws BaseException
    {
	Date dateFrom = dateFromParam;
	double totalProfitAmount = 0d;
	if(islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() == 0
		|| (ConstantsCommon.NO.equals(islamicCalculatorCO.getTentativeSchedule())))
	{
	    totalProfitAmount += calculateProfitAmount(islamicCalculatorCO, dateFrom, dateTo, amount, adjustDays,
		    chargesAndInsuranceExcludingProfitCals, yeildPercent, capitalize);
	    return totalProfitAmount;
	}
	double currentOutstandingAmount = 0d;
	Date disbursementFromDate = islamicCalculatorCO.getValueDate();
	Date disbursementToDate = islamicCalculatorCO.getValueDate();
	if(currentLineNo > 0)
	{
	    if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		    .equals(islamicCalculatorCO.getProfitCalculationMethod()))
	    {
		currentOutstandingAmount = NumberUtil.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList()
			.get(currentLineNo - 1).getTOTAL_PRINCIPAL_OUTSTANDIG());
	    }
	    else
	    {
		currentOutstandingAmount = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo - 1)
				.getTOTAL_PRINCIPAL_OUTSTANDIG())
			- NumberUtil.toDoubleObj(
				islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo - 1).getCAPITAL_AMT());
	    }
	    currentOutstandingAmount = NumberUtil.round(currentOutstandingAmount,
		    islamicCalculatorCO.getDealCyDecimalPoint());
	}
	else if(currentLineNo.compareTo(0) == 0)
	{
	    if("H".equals(islamicCalculatorCO.getCompoundingProfit()) || ConstantsCommon.YES.equals(capitalize))
	    {
		currentOutstandingAmount = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(0).getAMOUNT())
			+ NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges())
			+ NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance())
			+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());
	    }
	    else
	    {
		currentOutstandingAmount = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(0).getAMOUNT())
			+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
			+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
			+ NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalGracePeriodCompundingProfit());
	    }
	    for(int j = 1; j < islamicCalculatorCO.getTrsDealMultipleDisbursementList().size(); j++)
	    {
		if(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(j).getVALUE_DATE().before(dateFrom))
		{
		    currentOutstandingAmount += NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(j).getAMOUNT());
		}
	    }
	}

	for(int i = 1; i < islamicCalculatorCO.getTrsDealMultipleDisbursementList().size(); i++)
	{
	    disbursementToDate = islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).getVALUE_DATE();
	    if(disbursementToDate.before(actualFromDate))
	    {
		disbursementFromDate = disbursementToDate;
		continue;
	    }
	    if(disbursementToDate.before(dateFrom))
	    {
		disbursementFromDate = disbursementToDate;
		currentOutstandingAmount += NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).getAMOUNT());
		continue;
	    }

	    if(ConstantsCommon.NO.equals(islamicCalculatorCO.getEqualInstallmentForDisbursement())
		    && !"H".equals(islamicCalculatorCO.getCompoundingProfit())
		    && ((disbursementToDate.after(islamicCalculatorCO.getNextDisbursementDate()))))
	    {
		break;
	    }
	    if(islamicCalculatorCO.getEqualInstallmentForDisbursement().equals(ConstantsCommon.NO)
		    && !"H".equals(islamicCalculatorCO.getCompoundingProfit())
		    && ((dateFrom.after(islamicCalculatorCO.getNextDisbursementDate())
			    || dateFrom.compareTo(islamicCalculatorCO.getNextDisbursementDate()) == 0)))
	    {
		if(dateFrom.compareTo(islamicCalculatorCO.getNextDisbursementDate()) == 0
			&& disbursementToDate.compareTo(dateFrom) == 0)
		{
		    currentOutstandingAmount += NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).getAMOUNT());
		}
		break;
	    }
	    if((disbursementFromDate.before(dateFrom)) && disbursementToDate.before(dateTo))
	    {
		// totalProfitAmount +=
		// calculateProfitAmount(islamicCalculatorCO, dateFrom,
		// disbursementToDate,MANOJMV848ON22/10/2013
		double totalProfitAmount_temp = calculateProfitAmount(islamicCalculatorCO, dateFrom, dateTo,
			currentOutstandingAmount, adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent,
			capitalize);
		if(disbursementFromDate.before(dateFrom))
		{
		    totalProfitAmount_temp = (totalProfitAmount_temp / DateUtil.numberOfDays(dateFrom, dateTo))
			    * DateUtil.numberOfDays(dateFrom, disbursementToDate);
		    totalProfitAmount_temp = NumberUtil.round(totalProfitAmount_temp,
			    islamicCalculatorCO.getDealCyDecimalPoint());
		}
		totalProfitAmount += totalProfitAmount_temp;
		dateFrom = disbursementToDate;
		currentOutstandingAmount += NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).getAMOUNT());
	    }
	    if((disbursementFromDate.compareTo(dateFrom) == 0
		    || (disbursementFromDate.after(dateFrom) && disbursementFromDate.before(dateTo)))
		    && disbursementToDate.after(dateTo))
	    {
		totalProfitAmount += calculateProfitAmount(islamicCalculatorCO, dateFrom, dateTo,
			currentOutstandingAmount, adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent,
			capitalize);
		dateFrom = dateTo;
		currentOutstandingAmount += NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).getAMOUNT());
		break;
	    }
	    else if((disbursementFromDate.compareTo(dateFrom) == 0
		    || (disbursementFromDate.after(dateFrom) && disbursementFromDate.before(dateTo)))
		    && (disbursementToDate.before(dateTo) || disbursementToDate.compareTo(dateTo) == 0))
	    {

		// totalProfitAmount +=
		// calculateProfitAmount(islamicCalculatorCO, dateFrom,
		// disbursementToDate, MANOJMV848ON22/10/2013
		double totalProfitAmount_temp = calculateProfitAmount(islamicCalculatorCO, dateFrom, dateTo,
			currentOutstandingAmount, adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent,
			capitalize);
		// TP#212089; Ramesh; Date 26/08/2014 [added
		// (DateUtil.numberOfDays(dateFrom, dateTo) > 0) condition]
		if((dateFrom.equals(disbursementFromDate)) && (DateUtil.numberOfDays(dateFrom, dateTo) > 0))
		{
		    totalProfitAmount_temp = (totalProfitAmount_temp / DateUtil.numberOfDays(dateFrom, dateTo))
			    * DateUtil.numberOfDays(dateFrom, disbursementToDate);
		    totalProfitAmount_temp = NumberUtil.round(totalProfitAmount_temp,
			    islamicCalculatorCO.getDealCyDecimalPoint());
		}
		totalProfitAmount += totalProfitAmount_temp;
		dateFrom = disbursementToDate;
		currentOutstandingAmount += NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrsDealMultipleDisbursementList().get(i).getAMOUNT());
	    }

	    disbursementFromDate = disbursementToDate;

	}
	if(dateFrom.compareTo(dateTo) != 0)
	{
	    totalProfitAmount += calculateProfitAmount(islamicCalculatorCO, dateFrom, dateTo, currentOutstandingAmount,
		    adjustDays, chargesAndInsuranceExcludingProfitCals, yeildPercent, capitalize);
	}
	return totalProfitAmount;
    }

    private Double calculateProfitAmountForRescheduleNoRecalculate(IslamicCalculatorCO islamicCalculatorCO,
	    Date dateFrom, Date dateToParam) throws BaseException
    {
	BigDecimal profitAmount = BigDecimal.ZERO;

	long lineDays = DateUtil.numberOfDays(dateFrom, dateToParam);
	long totalDays = DateUtil.numberOfDays(islamicCalculatorCO.getValueDate(),
		islamicCalculatorCO.getMaturityDate());
	if(totalDays == 0l)
	{
		totalDays = 1l;
	}
	profitAmount = (islamicCalculatorCO.getOutstandingProfit().divide(BigDecimal.valueOf(totalDays), 12,
		BigDecimal.ROUND_HALF_UP));
	profitAmount = profitAmount.multiply(BigDecimal.valueOf(lineDays));

	return NumberUtil.round(profitAmount.doubleValue(), islamicCalculatorCO.getDealCyDecimalPoint());
    }

    private Double calculateProfitAmount(IslamicCalculatorCO islamicCalculatorCO, Date dateFrom, Date dateToParam,
	    Double amountParam, Long adjustDays, Double chargesAndInsuranceExcludingProfitCals, Double yeildPercent,
	    String capitalize) throws BaseException
    {
	if(islamicCalculatorCO.getRescheduleType() != null
		&& IISCommonConstants.RESCHEDULE_TYPE_NO_RECALCULATE.equals(islamicCalculatorCO.getRescheduleType()))
	{
	    return calculateProfitAmountForRescheduleNoRecalculate(islamicCalculatorCO, dateFrom, dateToParam);
	}

	Date dateTo = dateToParam;
	Double amount = amountParam;
	double profitAmount = 0D;
	amount = amount - chargesAndInsuranceExcludingProfitCals;
	amount = NumberUtil.round(amount, islamicCalculatorCO.getDealCyDecimalPoint());

	if(adjustDays.compareTo(0L) != 0)
	{
	    dateTo = DateUtil.dateAdd(DateUtil.DAY, adjustDays, dateTo);
	}
	double monthsDay = iisCommonBO.getMonthsAndDayDifferance(dateFrom, dateTo);
	long month = (long) monthsDay;
	double days = NumberUtil.round(((monthsDay - month) * 100L), 0L);
	double profitPerMonth = 0D;
	double profitPerDay = 0D;
	int currentLineNo = islamicCalculatorCO.getCurrentLineNo().intValue();

	// Added By Manoj on 10/05/2018 for BUG reported from AMANA - Accrual
	// Basis 2(30/360), feb month differance was not considering.g
	if(currentLineNo >= 0 && ((NumberUtil.toInteger(islamicCalculatorCO.getProfitAccrualBasis()) == 2
		&& islamicCalculatorCO.getAccruakBasisActualDaysYn().equals(ConstantsCommon.YES))
		|| NumberUtil.toInteger(islamicCalculatorCO.getProfitAccrualBasis()) == 3))
	{

	    if(DateUtil.getDatePart("MM", dateTo) == 2
		    && DateUtil.getDatePart("DD", dateFrom) > DateUtil.getDatePart("DD", dateTo)
		    && dateFrom.compareTo(DateUtil.getMonthLastDay(dateFrom)) != 0
		    && dateTo.compareTo(DateUtil.getMonthLastDay(dateTo)) == 0)
	    {
		if(islamicCalculatorCO.getCurrentLineNo().add(BigDecimal.ONE)
			.compareTo(BigDecimal.valueOf(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)) != 1)
		{
		    Date nexDate = islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo + 1).getVALUE_DATE();
		    if(DateUtil.getDatePart("DD", dateFrom) == DateUtil.getDatePart("DD", nexDate))
		    {
			long ll_from_year = DateUtil.getDatePart("YY", dateFrom);
			long ll_from_month = DateUtil.getDatePart("MM", dateFrom);
			long ll_to_year = DateUtil.getDatePart("YY", dateTo);
			long ll_to_month = DateUtil.getDatePart("MM", dateTo);

			if(ll_to_month < ll_from_month)
			{
			    ll_to_month = ll_to_month + 12;
			    ll_to_year = ll_to_year - 1;
			}
			month = ((ll_to_year - ll_from_year) * 12) + ll_to_month - ll_from_month;
			days = 0D;
		    }
		}
	    }

	    if(DateUtil.getDatePart("MM", dateFrom) == 2
		    && DateUtil.getDatePart("DD", dateFrom) < DateUtil.getDatePart("DD", dateTo)
		    && dateFrom.compareTo(DateUtil.getMonthLastDay(dateFrom)) == 0
		    && dateTo.compareTo(DateUtil.getMonthLastDay(dateTo)) != 0)
	    {
		if(currentLineNo >= 0)
		{
		    Date lv_prev_date = islamicCalculatorCO.getValueDate();
		    if(currentLineNo != 1)
		    {
			lv_prev_date = islamicCalculatorCO.getTrspayplandetVOList().get(currentLineNo - 2)
				.getVALUE_DATE();
		    }
		    if(DateUtil.getDatePart("DD", lv_prev_date) == DateUtil.getDatePart("DD", dateTo))
		    {
			long ll_from_year = DateUtil.getDatePart("YY", dateFrom);
			long ll_from_month = DateUtil.getDatePart("MM", dateFrom);
			long ll_to_year = DateUtil.getDatePart("YY", dateTo);
			long ll_to_month = DateUtil.getDatePart("MM", dateTo);

			if(ll_to_month < ll_from_month)
			{
			    ll_to_month = ll_to_month + 12;
			    ll_to_year = ll_to_year - 1;
			}
			month = ((ll_to_year - ll_from_year) * 12) + ll_to_month - ll_from_month;
			days = 0D;
		    }
		}
	    }
	}
	// Amana Issue End

	if(islamicCalculatorCO.getProfitAccrualBasis().equals(1L))// Accrual
	// basis =
	// Actual
	// /Point
	// Method
	{
	    long totalDays = DateUtil.numberOfDays(dateFrom, dateTo);
	    if(ConstantsCommon.NO.equals(capitalize))
	    {
		profitAmount = (amount * (yeildPercent / 100) / islamicCalculatorCO.getDealCyPtMethod() * totalDays);
	    }
	    else
	    {
		profitAmount = (NumberUtil.round(
			amount * (yeildPercent / 100) / islamicCalculatorCO.getDealCyPtMethod(),
			islamicCalculatorCO.getDealCyDecimalPoint()) * totalDays);
	    }
	}
	else if(NumberUtil.toInteger(islamicCalculatorCO.getProfitAccrualBasis()) == 2)// Accrual
	// basis
	// =
	// 30/360
	{
	    if(ConstantsCommon.NO.equals(islamicCalculatorCO.getAccruakBasisActualDaysYn()))
	    {
		days = getDaysBetweenStubPeriod(dateFrom, dateTo);
		month = 0L;
	    }
	    if(ConstantsCommon.NO.equals(capitalize))
	    {
		profitPerMonth = (amount * (yeildPercent / 100) / 360 * 30);
		profitPerDay = (profitPerMonth / 30 * days);
	    }
	    else
	    {
		profitPerMonth = (NumberUtil.round(amount * (yeildPercent / 100) / 360,
			islamicCalculatorCO.getDealCyDecimalPoint()) * 30);
		profitPerDay = (NumberUtil.round(profitPerMonth / 30, islamicCalculatorCO.getDealCyDecimalPoint())
			* days);
	    }

	    profitAmount = (profitPerMonth * month) + profitPerDay;
	}
	else if(NumberUtil.toInteger(islamicCalculatorCO.getProfitAccrualBasis()) == 3)// Accrual
	// basis
	// =
	// 31/365
	{
	    if(ConstantsCommon.NO.equals(capitalize))
	    {
		profitPerMonth = (amount * (yeildPercent / 100) / 365 * 31);
		profitPerDay = (profitPerMonth / 31 * days);
	    }
	    else
	    {
		profitPerMonth = (NumberUtil.round(amount * (yeildPercent / 100) / 365,
			islamicCalculatorCO.getDealCyDecimalPoint()) * 31);
		profitPerDay = (NumberUtil.round(profitPerMonth / 31, islamicCalculatorCO.getDealCyDecimalPoint())
			* days);

	    }

	    profitAmount = (profitPerMonth * month) + profitPerDay;
	}
	else if(NumberUtil.toInt(islamicCalculatorCO.getProfitAccrualBasis()) == 4)// Accrual
	// basis
	// =
	// Actual
	// /365
	{
	    long totalDays = DateUtil.numberOfDays(dateFrom, dateTo);
	    if(ConstantsCommon.NO.equals(capitalize))
	    {
		profitAmount = (amount * (yeildPercent / 100) / 365 * totalDays);
	    }
	    else
	    {
		profitAmount = (NumberUtil.round(amount * (yeildPercent / 100) / 365,
			islamicCalculatorCO.getDealCyDecimalPoint()) * totalDays);
	    }
	}
	else if(NumberUtil.toInteger(islamicCalculatorCO.getProfitAccrualBasis()) == 5)// Accrual
	// basis
	// =
	// Actual
	// /actual
	{

	    long totalDays = DateUtil.numberOfDays(dateFrom, dateTo);
	    if(ConstantsCommon.NO.equals(capitalize))
	    {
		profitAmount = (amount * (yeildPercent / 100)
			/ NumberUtil.toDoubleObj(islamicCalculatorCO.getAvgDaysInYearsForProfitCalculation())
			* totalDays);
	    }
	    else
	    {
		profitAmount = (NumberUtil.round(
			amount * (yeildPercent / 100)
				/ NumberUtil.toDoubleObj(islamicCalculatorCO.getAvgDaysInYearsForProfitCalculation()),
			islamicCalculatorCO.getDealCyDecimalPoint()) * totalDays);
	    }
	}
	else
	// Accrual basis = Actual /360
	{
	    // Long totalDays = DateUtil.numberOfDays(dateFrom, dateTo);
	    // Long totalDays = returnNumberOfDays(dateFrom, dateTo);
	    Long totalDays = daysBetween(dateFrom, dateTo);
	    // returnNumberOfDays

	    // log.error("REPAYMENT PLAN SCHEDULE : dateFrom:-" +
	    // dateFrom.toString() + " dateTo:-" + dateTo.toString()
	    // + " totalDays :" + totalDays.toString());
	    if(ConstantsCommon.NO.equals(capitalize))
	    {
		profitAmount = (amount * (yeildPercent / 100) / 360 * totalDays);
	    }
	    else
	    {
		profitAmount = (NumberUtil.round(amount * (yeildPercent / 100) / 365,
			islamicCalculatorCO.getDealCyDecimalPoint()) * totalDays);
	    }
	}
	// profitAmount = NumberUtil.round(profitAmount, 12);
	profitAmount = round(profitAmount, 12);
	return NumberUtil.round(profitAmount, islamicCalculatorCO.getDealCyDecimalPoint());
    }

    public static long daysBetween(Date startDate1, Date endDate1)
    {
	Calendar startDate = DateUtil.getDateWithoutTime(startDate1);
	Calendar endDate = DateUtil.getDateWithoutTime(endDate1);
	// PMD infractions; Saheer.Naduthodi; 10/12/2014
	if(startDate.after(endDate))
	{
	    return -daysBetween(endDate1, startDate1);
	}
	Calendar date = (Calendar) startDate.clone();
	long bigLeap = (endDate.getTimeInMillis() - startDate.getTimeInMillis()) / 1000 / 60 / 60 / 24;
	date.add(Calendar.DAY_OF_YEAR, (int) bigLeap);

	long smallStep = 0;
	if(date.before(endDate))
	{
	    while(date.before(endDate))
	    {
		date.add(Calendar.DAY_OF_MONTH, 1);
		smallStep++;
	    }
	}
	else if(endDate.before(date))
	{
	    while(endDate.before(date))
	    {
		date.add(Calendar.DAY_OF_MONTH, -1);
		smallStep--;
	    }
	}
	return smallStep + bigLeap;
    }

 

    private Double getDaysBetweenStubPeriod(Date dateFrom, Date dateTo)
    {
	long daysFrom = DateUtil.getDatePart("DD", dateFrom);
	long monthFrom = DateUtil.getDatePart("MM", dateFrom);
	long yearFrom = DateUtil.getDatePart("YYYY", dateFrom);

	long daysTo = DateUtil.getDatePart("DD", dateTo);
	long monthTo = DateUtil.getDatePart("MM", dateTo);
	long yearTo = DateUtil.getDatePart("YYYY", dateTo);

	if(daysFrom > 30)
	{
	    daysFrom = 30L;
	}
	if(daysTo > 30)
	{
	    daysTo = 30L;
	}
	long year = yearTo - yearFrom;
	long month = monthTo - monthFrom;
	long days = daysTo - daysFrom;

	if(days < 0)
	{
	    month -= 1L;
	    days += 30L;
	}
	if(month < 0)
	{
	    year -= 1L;
	    month += 12L;
	}
	return (year * 360) + (month * 30) + (double) days;
    }

    /**
     * Create schedule using payment periodicty/Template/criteria
     * 
     * @param islamicCalculatorCO
     * @return
     * @throws BaseException
     */
    private IslamicCalculatorCO setPlandetails(IslamicCalculatorCO islamicCalculatorCOParam) throws BaseException
    {
	IslamicCalculatorCO islamicCalculatorCO = islamicCalculatorCOParam;
	// set the plan details based on no of days/ template/ criteria
	if(islamicCalculatorCO.getTemplateCode().longValue() > 0)
	{
	    // if there is any plan template is linked, schedule create based on
	    // the template
	    // if(islamicCalculatorCO.getRescheduleYn().equals(IISCommonConstants.RESCHEDULE_YES))
	    if(IISCommonConstants.RESCHEDULE_YES.equals(islamicCalculatorCO.getRevaluationProcess()))
	    {
		/**
		 * in case of Revaluation with Template, copy the previous plan
		 * dates
		 */
		copyPreviousPlandetails(islamicCalculatorCO);
	    }
	    else
	    {
		islamicCalculatorCO = setPlandetailsBasedTemplateValues(islamicCalculatorCO);
	    }

	    /*
	     * if the payment based on the template or criteria, the amount per
	     * payment is not applicable
	     */
	    islamicCalculatorCO.setAmountPerPayment(BigDecimal.ZERO);
	    /*
	     * if the payment based on the template or criteria, the flag
	     * APPLY_ROUNDING_FACT_AFTER_CALC is not applicable
	     */
	    islamicCalculatorCO.setApplyRoundingFact_after_calc(ConstantsCommon.NO);
	    islamicCalculatorCO.setGenerate_payplan_based_on(ConstantsCommon.NO);
	}
	else
	{
	    if(islamicCalculatorCO.getTrsPayPlanCriteriaVO().size() > 0)
	    {

		// If the criteria is defined, schedule create based on the
		// criteria

		islamicCalculatorCO = setPlandetailsBasedOnCriteria(islamicCalculatorCO);
		/*
		 * if the payment based on the template or criteria, the amount
		 * per payment is not applicable
		 */
		islamicCalculatorCO.setAmountPerPayment(BigDecimal.ZERO);
		/*
		 * if the payment based on the template or criteria, the flag
		 * APPLY_ROUNDING_FACT_AFTER_CALC is not applicable
		 */
		islamicCalculatorCO.setApplyRoundingFact_after_calc(ConstantsCommon.NO);
		islamicCalculatorCO.setGenerate_payplan_based_on(ConstantsCommon.NO);
		islamicCalculatorCO
			.setFirstPaymentDate(islamicCalculatorCO.getTrspayplandetVOList().get(0).getVALUE_DATE());
	    }
	    else if(islamicCalculatorCO.getTrspayplandetVOList().size() == 0)
	    {
		if(IISCommonConstants.RESCHEDULE_YES.equals(islamicCalculatorCO.getRevaluationProcess())
			|| PAYPLAN_BASED_ON_REDUCE_INSTALLMENT
				.equals(islamicCalculatorCO.getGenerate_payplan_based_on())
			|| IISCommonConstants.RESCHEDULE_TYPE_ADVANCE_PRINCIPAL_SETTL
				.equals(islamicCalculatorCO.getRescheduleType()))
		{
		    /**
		     * in case of Revaluation with Template, copy the previous
		     * plan dates
		     */
		    copyPreviousPlandetails(islamicCalculatorCO);
		}
		else
		{
		    islamicCalculatorCO = setPlandetailsBasedOnNoPayments(islamicCalculatorCO);
		}

	    }
	}

	if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
	{
	    // if the calendar is Hijira then Corresponding hijiri date also
	    // need to set
	    setHijiriDate(islamicCalculatorCO);
	}
	// TP 546955 BB160195 Fawas.Kuruvakkottil 23/01/2018
	setPlanDetailsBasedOnCoveringAccFromtrsDeal(islamicCalculatorCO);

	if(islamicCalculatorCO.getTrspayplandetVOList().isEmpty())
	{
	    throw new BOException(900007, new String[] { "invalid_Number_Of_Payments" }, false);
	}

	reSetLineNo(islamicCalculatorCO);
	if(islamicCalculatorCO.getMaxNoOfPayments() != null && islamicCalculatorCO.getMaxNoOfPayments()
		.longValue() < islamicCalculatorCO.getTrspayplandetVOList().size()
		&& islamicCalculatorCO.getMaxNoOfPayments().longValue() > 0)
	{
	    throw new BOException(MessageCodes.CANNOT_PROC_NO_OF_PAYMENTS_EXCEEDS_LIMIT);
	}
	
	if(islamicCalculatorCO.getTrspayplandetVOList().size() > MAX_NO_OF_PAYMENTS){
		throw new BOException(900007, new String[] { "Number of payment cannot be greater than " +  MAX_NO_OF_PAYMENTS }, false);
	}
	
	if(NumberUtil.toInteger(islamicCalculatorCO.getMudarabahRateCode()) > 0
		&& islamicCalculatorCO.getTrspayplandetVOList().size() > 1)
	{
	    throw new BOException(900007, new String[] { "Number_of_Payments_should_be_1" }, false);
	}

	// Added By Manoj On 08/07/2019 for SUPT190047
	if (ConstantsCommon.YES.equals(islamicCalculatorCO.getEXCLUDE_PASTDUE_AT_RESCHDL_YN()) 
			&& !islamicCalculatorCO.getRescheduleType().equals(IISCommonConstants.RESCHEDULE_TYPE_NO_RECALCULATE)){
		copyExcludeRecalulatePlanDet(islamicCalculatorCO);	
	}

	if(StringUtil.nullEmptyToValue(islamicCalculatorCO.getLastInstAssetResidualYn(), ConstantsCommon.NO).equals(
		ConstantsCommon.YES) && islamicCalculatorCO.getAssetResidualAmount().compareTo(BigDecimal.ZERO) == 1)
	{
	    islamicCalculatorCO.getTrspayplandetVOList().get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
		    .setPAYMENT_TYPE("E");
	    islamicCalculatorCO.getTrspayplandetVOList().get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
		    .setUSER_DEFINED_AMOUNT(islamicCalculatorCO.getAssetResidualAmount());
	    islamicCalculatorCO.getTrspayplandetVOList().get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
		    .setUserDefined(ConstantsCommon.YES);
	}
	islamicCalculatorCO.setOutNoOfPayments(BigDecimal.valueOf(islamicCalculatorCO.getTrspayplandetVOList().size()));
	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
	return islamicCalculatorCO;
    }

    // TP 546955 BB160195 Fawas.Kuruvakkottil 23/01/2018 [Start]
    private IslamicCalculatorCO setPlanDetailsBasedOnCoveringAccFromtrsDeal(IslamicCalculatorCO islamicCalculatorCO)
	    throws DAOException, BOException
    {
	TRSDEAL_COVERING_ACCOUNTSVO trsDealCoveringAccountVO = iisIslamicCalculatorDAO
		.returnTrsDealCoveringAccountDet(islamicCalculatorCO);
	if(trsDealCoveringAccountVO != null)
	{
	    for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
	    {
		trspayplandetCO.setCOVERING_ACC_BR(trsDealCoveringAccountVO.getACCOUNT_BRANCH());
		trspayplandetCO.setCOVERING_ACC_CY(trsDealCoveringAccountVO.getACCOUNT_CURRENCY());
		trspayplandetCO.setCOVERING_ACC_GL(trsDealCoveringAccountVO.getACCOUNT_GL());
		trspayplandetCO.setCOVERING_ACC_CIF(trsDealCoveringAccountVO.getACCOUNT_CIF());
		trspayplandetCO.setCOVERING_ACC_SL(trsDealCoveringAccountVO.getACCOUNT_SL());
		trspayplandetCO
			.setCOVERING_ACC_NAME(iisIslamicCalculatorDAO.returnAccountName(trsDealCoveringAccountVO));
	    }
	}
	return islamicCalculatorCO;
    }

    // TP 546955 BB160195 Fawas.Kuruvakkottil 23/01/2018 [End]

    private void reSetLineNo(IslamicCalculatorCO islamicCalculatorCO)
    {
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCalledFromIPRSYN()))
	    {
		islamicCalculatorCO.getTrspayplandetVOList().get(i)
			.setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_SETTLE_PROFIT);
	    }
	    islamicCalculatorCO.getTrspayplandetVOList().get(i).setLINE_NBR(BigDecimal.valueOf(i + 1L));
	}
    }

    private IslamicCalculatorCO setPlandetailsBasedTemplateValues(IslamicCalculatorCO islamicCalculatorCO)
	    throws BaseException
    {
	// schedule create based on the template
	// List<TRSPAYPLANTMPLTDETVO> trsPayPlanTmpltdetVOList = new
	// ArrayList<TRSPAYPLANTMPLTDETVO>();
	List<TRSPAYPLANTMPLTDETVO> trsPayPlanTmpltdetVOList;
	TRSPAYPLANTMPLTDETVOKey trsPayPlanTmpltdetVOKey = new TRSPAYPLANTMPLTDETVOKey();

	trsPayPlanTmpltdetVOKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	trsPayPlanTmpltdetVOKey.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
	trsPayPlanTmpltdetVOKey.setTEMPLATE_CODE(islamicCalculatorCO.getTemplateCode());

	// get the template details
	trsPayPlanTmpltdetVOList = iisIslamicCalculatorDAO.getTemplateDetails(trsPayPlanTmpltdetVOKey);
	trsPayPlanTmpltdetVOKey = null;
	if(trsPayPlanTmpltdetVOList == null || trsPayPlanTmpltdetVOList.isEmpty())
	{
	    // if template is not valid then throw the exceptions
	    throw new BOException(MessageCodes.INVALID_REPAYMENT_TEMPLATE_CODE);
	}
	Map<Date, Long> planMap = new HashMap<Date, Long>();
	ArrayList<Date> planArrayList = new ArrayList<Date>();

	long lineNo = 0L;
	Date nextDate = islamicCalculatorCO.getFirstPaymentDate();
	String hijiriDate = null;
	if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
	{
	    hijiriDate = hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(),
		    islamicCalculatorCO.getFirstPaymentDate());
	    islamicCalculatorCO.setHijriDate(hijiriDate);
	}

	Date prevDate = null;
	if(NumberUtil.nullToZero(islamicCalculatorCO.getNoOfPayments()).longValue() > trsPayPlanTmpltdetVOList
		.get((trsPayPlanTmpltdetVOList.size() - 1)).getINST_NBR_TO().longValue())
	{
	    // BMOUPI180077
	    /*
	     * if the number of payment is defined in the plan hd is greater
	     * than the template then Plan will be created with the last payment
	     * periodicity with payment type "B"(Principal+Profit)
	     */
	    /*
	     * 553950,Vysakh,05/10/2017,BMO need no of payments from limit
	     * rather than from template
	     */
	    // if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCalledFromFmsYN()))
	    // {
	    // TRSPAYPLANTMPLTDETVO aTRSPAYPLANTMPLTDETVO =
	    // trsPayPlanTmpltdetVOList
	    // .get((trsPayPlanTmpltdetVOList.size() - 1));
	    //
	    // aTRSPAYPLANTMPLTDETVO.setINST_NBR_TO(islamicCalculatorCO.getNoOfPayments());
	    // trsPayPlanTmpltdetVOList.set((trsPayPlanTmpltdetVOList.size() -
	    // 1), aTRSPAYPLANTMPLTDETVO);
	    //
	    // }
	    // else
	    // {
	    // islamicCalculatorCO.setNoOfPayments(
	    // trsPayPlanTmpltdetVOList.get((trsPayPlanTmpltdetVOList.size() -
	    // 1)).getINST_NBR_TO());
	    // }
	    TRSPAYPLANTMPLTDETVO trsPayPlanTmpltdetVOTemp = new TRSPAYPLANTMPLTDETVO();
	    trsPayPlanTmpltdetVOTemp.setINST_NBR_TO(islamicCalculatorCO.getNoOfPayments());
	    trsPayPlanTmpltdetVOTemp.setPAYM_PERIODICITY(
		    trsPayPlanTmpltdetVOList.get(trsPayPlanTmpltdetVOList.size() - 1).getPAYM_PERIODICITY());
	    trsPayPlanTmpltdetVOTemp.setPAYM_PERIOD_NBR(
		    trsPayPlanTmpltdetVOList.get(trsPayPlanTmpltdetVOList.size() - 1).getPAYM_PERIOD_NBR());
	    trsPayPlanTmpltdetVOTemp.setPAYM_PERIOD_POS(
		    trsPayPlanTmpltdetVOList.get(trsPayPlanTmpltdetVOList.size() - 1).getPAYM_PERIOD_POS());
	    trsPayPlanTmpltdetVOTemp.setINST_NBR_FROM(trsPayPlanTmpltdetVOList.get(trsPayPlanTmpltdetVOList.size() - 1)
		    .getINST_NBR_TO().add(BigDecimal.ONE));

	    trsPayPlanTmpltdetVOTemp.setPAYMENT_TYPE("B");

	    trsPayPlanTmpltdetVOList.add(trsPayPlanTmpltdetVOTemp);
	}
	// get flag getLastInstallmentDateasMaturityDateYN from template header
	// table
	TRSPAYPLANTMPLTVOKey trsPayplanTmpltVOKey = new TRSPAYPLANTMPLTVOKey();
	trsPayplanTmpltVOKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	trsPayplanTmpltVOKey.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
	trsPayplanTmpltVOKey.setTEMPLATE_CODE(islamicCalculatorCO.getTemplateCode());
	TRSPAYPLANTMPLTVO trspayplantmpltvo = (TRSPAYPLANTMPLTVO) genericDAO.selectByPK(trsPayplanTmpltVOKey);
	String lastInstallmentDateAsMaturityDateYN = StringUtil
		.nullEmptyToValue(trspayplantmpltvo.getSET_LAST_INST_ON_MAT_DTE_IFNOT(), ConstantsCommon.YES);
	BigDecimal balloonAmount = NumberUtil.nullToZero(trspayplantmpltvo.getBALLOON_AMT());
	/*
	 * String lastInstallmentDateAsMaturityDateYN = iisIslamicCalculatorDAO
	 * .getLastInstallmentDateAsMaturityDateYN(trsPayplanTmpltVOKey);
	 */
	trsPayplanTmpltVOKey = null;

	// Start main Loop For template
	for(TRSPAYPLANTMPLTDETVO trsPayPlanTmpltdetVO : trsPayPlanTmpltdetVOList)
	{
	    if(StringUtil.isEmptyString(trsPayPlanTmpltdetVO.getPAYMENT_TYPE()))
	    {
		throw new BOException(MessageCodes.iis_invalid_code,
			new String[] { "Payment_Type_Not_Defined_For_the_Selected_Template_Code_key" }, false);
	    }
	    boolean planEnd = false;

	    if(islamicCalculatorCO.getTrspayplandetVOList().size() > 0)
	    {
		// not the first line of the template
		nextDate = islamicCalculatorCO.getTrspayplandetVOList()
			.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getVALUE_DATE();
		if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
		{
		    hijiriDate = hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(),
			    nextDate);
		    islamicCalculatorCO.setHijriDate(hijiriDate);
		}
	    }
	    long seqLineNo = 0L;

	    // Start the line level Loop
	    for(long i = trsPayPlanTmpltdetVO.getINST_NBR_FROM().longValue(); i <= trsPayPlanTmpltdetVO.getINST_NBR_TO()
		    .longValue(); i++)
	    {
		lineNo++;
		seqLineNo++;

		if(lineNo != i)// if the line number is not serial number then
		// cannot continue
		{
		    throw new BOException(MessageCodes.INVALID_TEMPLATE_DETAILS);
		}
		if(lineNo > 1 && prevDate.equals(nextDate))
		{

		    // calculate the next value date
		    nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(),
			    nextDate, trsPayPlanTmpltdetVO.getPAYM_PERIODICITY(),
			    trsPayPlanTmpltdetVO.getPAYM_PERIOD_NBR().longValue(), seqLineNo,
			    trsPayPlanTmpltdetVO.getPAYM_PERIOD_POS(), null, "T");

		    hijiriDate = islamicCalculatorCO.getHijriDate();

		    if(nextDate.after(islamicCalculatorCO.getMaturityDate()))
		    {
			/*
			 * if the next value date is after the deal maturity
			 * date then need to set the value date as maturity date
			 */
			if(ConstantsCommon.NO.equals(lastInstallmentDateAsMaturityDateYN))
			{
			    // if this flag is ConstantsCommon.NO then no need
			    // to continue
			    planEnd = true;
			    break;
			}
			else if(prevDate.before(islamicCalculatorCO.getMaturityDate()))
			{
			    nextDate = islamicCalculatorCO.getMaturityDate();
			    islamicCalculatorCO.setLastInstallmentOnMaturityDate(ConstantsCommon.NO);
			    if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
			    {
				hijiriDate = hijiriCalendarBO
					.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(), nextDate);
				islamicCalculatorCO.setHijriDate(hijiriDate);
			    }
			}
		    }
		}
		prevDate = nextDate;
		TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
		trspayplandetCO.setLINE_NBR(BigDecimal.valueOf(lineNo));
		trspayplandetCO.setVALUE_DATE(nextDate);
		trspayplandetCO.setVALUE_DATE_HIJRI(hijiriDate);
		trspayplandetCO.setPAYMENT_TYPE(trsPayPlanTmpltdetVO.getPAYMENT_TYPE());
		trspayplandetCO.setDEAL_VALUE_DATE(islamicCalculatorCO.getValueDate());
		trspayplandetCO.setBALLOON_PAYMENT(BigDecimal.valueOf(0L));
		trspayplandetCO.setNormalInstallment(ConstantsCommon.YES);
		if(IISCommonConstants.PAYMENT_TYPE_SPECIFIC_AMOUNT.equals(trsPayPlanTmpltdetVO.getPAYMENT_TYPE()))
		{
		    trspayplandetCO.setAMOUNT(trsPayPlanTmpltdetVO.getAMOUNT());
		    trspayplandetCO.setUSER_DEFINED_AMOUNT(trsPayPlanTmpltdetVO.getAMOUNT());
		    trspayplandetCO.setUserDefined(ConstantsCommon.YES);
		}
		else
		{
		    trspayplandetCO.setUserDefined(ConstantsCommon.NO);
		}

		trspayplandetCO.setACC_CY(islamicCalculatorCO.getDealCurrency());
		trspayplandetCO.setCOVERING_ACC_CY(islamicCalculatorCO.getDealCurrency());
		/**
		 * set Maturity account
		 */
		trspayplandetCO.setACC_BR(islamicCalculatorCO.getTRSDET_MATR_AC_BR());
		trspayplandetCO.setACC_CY(islamicCalculatorCO.getTRSDET_MATR_AC_CY());
		trspayplandetCO.setACC_GL(islamicCalculatorCO.getTRSDET_MATR_AC_GL());
		trspayplandetCO.setACC_CIF(islamicCalculatorCO.getTRSDET_MATR_AC_CIF());
		trspayplandetCO.setACC_SL(islamicCalculatorCO.getTRSDET_MATR_AC_SL());
		trspayplandetCO.setACC_NAME(islamicCalculatorCO.getTRSDET_MATR_AC_BRIEF_NAME_ENG());
		trspayplandetCO.setAUTO_CREATE_SETTLEMENT(islamicCalculatorCO.getAUTO_CREATE_SETTLEMENT());
		if("L".equals(trsPayPlanTmpltdetVO.getPAYMENT_TYPE()))
		{

		    trspayplandetCO.setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT);
		    trspayplandetCO.setUserDefined(ConstantsCommon.NO);
		    trspayplandetCO.setBALLOON_AMOUNT(balloonAmount);
		    trspayplandetCO.setBALLOON_PAYMENT(BigDecimal.valueOf(1L));
		    trspayplandetCO.setNormalInstallment(ConstantsCommon.NO);

		}
		islamicCalculatorCO.getTrspayplandetVOList().add(trspayplandetCO);
		planMap.put(nextDate, lineNo);
		planArrayList.add(nextDate);

		// calculate the next value date
		nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(), nextDate,
			trsPayPlanTmpltdetVO.getPAYM_PERIODICITY(),
			trsPayPlanTmpltdetVO.getPAYM_PERIOD_NBR().longValue(), seqLineNo,
			trsPayPlanTmpltdetVO.getPAYM_PERIOD_POS(), null, "T");
		hijiriDate = islamicCalculatorCO.getHijriDate();
		if(nextDate.after(islamicCalculatorCO.getMaturityDate()))
		{
		    if(ConstantsCommon.NO.equals(lastInstallmentDateAsMaturityDateYN))
		    {
			planEnd = true;
			break;
		    }
		    else if(prevDate.before(islamicCalculatorCO.getMaturityDate()))
		    {
			nextDate = islamicCalculatorCO.getMaturityDate();
			islamicCalculatorCO.setLastInstallmentOnMaturityDate(ConstantsCommon.NO);
			if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
			{
			    hijiriDate = hijiriCalendarBO
				    .getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(), nextDate);
			    islamicCalculatorCO.setHijriDate(hijiriDate);
			}
		    }
		    else
		    {
			planEnd = true;
			break;
		    }
		}
		if(islamicCalculatorCO.getNoOfPayments() != null && NumberUtil
			.toInteger(islamicCalculatorCO.getNoOfPayments()).equals(NumberUtil.toInteger(lineNo)))
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get((int) lineNo - 1)
			    .setVALUE_DATE(islamicCalculatorCO.getMaturityDate());

		    planEnd = true;
		    break;
		}
	    }
	    if(planEnd)
	    {
		break;
	    }
	    else
	    {
		islamicCalculatorCO.setIgoreIfStatement(0);
	    }
	} // end of for loop
	  // List<TrspayplandetCO> trspayplandetCOListTemp = new
	  // ArrayList<TrspayplandetCO>();
	List<TrspayplandetCO> trspayplandetCOListTemp;
	trspayplandetCOListTemp = islamicCalculatorCO.getTrspayplandetVOList();
	insertBaloonPaymentDet(islamicCalculatorCO, planMap, planArrayList, trspayplandetCOListTemp, lineNo);
	return islamicCalculatorCO;
    }

    private void copyExcludeRecalulatePlanDet(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {

	TRSPAYPLANDETVOKey trspayplandetvoKey = new TRSPAYPLANDETVOKey();
	trspayplandetvoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	trspayplandetvoKey.setBRANCH(islamicCalculatorCO.getBranchCode());
	if(islamicCalculatorCO.getDisbursementScreen())
	{
	    trspayplandetvoKey.setPLAN_NBR(islamicCalculatorCO.getLinkedDealPlanNbr());
	    trspayplandetvoKey.setPLAN_SEQ(islamicCalculatorCO.getLinkedDealPlanSeq());
	}
	else
	{
	    trspayplandetvoKey.setPLAN_NBR(islamicCalculatorCO.getPlanNbr());
	    trspayplandetvoKey.setPLAN_SEQ(islamicCalculatorCO.getPlanSeq());
	}

	List<TRSPAYPLANDETVO> trspayplandetvoList = new ArrayList<TRSPAYPLANDETVO>();
	if(islamicCalculatorCO.getDisbursementScreen()
		&& islamicCalculatorCO.getRevaluationProcess().equals(IISCommonConstants.RESCHEDULE_YES))
	{

	    trspayplandetvoList = iisIslamicCalculatorDAO.returnDisbursePlanScheduleList(trspayplandetvoKey);
	}
	else
	{

	    trspayplandetvoList = iisIslamicCalculatorDAO.returnPlanScheduleList(trspayplandetvoKey);
	}

	
	if(trspayplandetvoList == null)
	{
	    return;
	}
	Date firstPaymentDate = islamicCalculatorCO.getFirstPaymentDate();
	int lineNo = 0;
	
	// Start main Loop For template
	for(TRSPAYPLANDETVO trspayplandetvo : trspayplandetvoList)
	{
		BigDecimal instAmount = NumberUtil.nullToZero(trspayplandetvo.getAMOUNT_NEW());
		if ("Y".equals(islamicCalculatorCO.getUpfrontProduct()) )
		{
			instAmount = NumberUtil.nullToZero(trspayplandetvo.getAMOUNT());
		}
		if (NumberUtil.nullToZero(trspayplandetvo.getSETTLEMENT_AMOUNT()).compareTo(instAmount) == -1
				&& trspayplandetvo.getVALUE_DATE().before(firstPaymentDate) 
				&& !trspayplandetvo.getVALUE_DATE().before(islamicCalculatorCO.getValueDate()) ){
			TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
			PathPropertyUtil.copyProperties(trspayplandetvo, trspayplandetCO);
		    trspayplandetCO.setNormalInstallment("Y");
//		    trspayplandetCO.setSETTLED_CAPITAL_AMT(SETTLED_CAPITAL_AMT);
//		    trspayplandetCO.setSETTLED_PROFIT_AMT(SETTLED_PROFIT_AMT);
//		    trspayplandetCO.setSETTLED_VAT_AMT(SETTLED_VAT_AMT);
//		    trspayplandetCO.setSETTLEMENT_AMOUNT(SETTLEMENT_AMOUNT);
		    if ("Y".equals(islamicCalculatorCO.getUpfrontProduct()) )
			{
		    	trspayplandetCO.setREMAINING_AMOUNT(NumberUtil.nullToZero(trspayplandetvo.getAMOUNT()).subtract(NumberUtil.nullToZero(trspayplandetvo.getSETTLEMENT_AMOUNT())));
				trspayplandetCO.setAMOUNT(trspayplandetvo.getAMOUNT());
				trspayplandetCO.setUSER_DEFINED_AMOUNT(trspayplandetvo.getAMOUNT());
				trspayplandetCO.setUSER_DEFINED_PRFIT_AMOUNT(trspayplandetvo.getPROFIT_AMT());
			}else
			{
				trspayplandetCO.setREMAINING_AMOUNT(NumberUtil.nullToZero(trspayplandetvo.getAMOUNT_NEW()).subtract(NumberUtil.nullToZero(trspayplandetvo.getSETTLEMENT_AMOUNT())));
				trspayplandetCO.setAMOUNT(trspayplandetvo.getAMOUNT_NEW());
				trspayplandetCO.setUSER_DEFINED_AMOUNT(trspayplandetvo.getAMOUNT_NEW());
				trspayplandetCO.setUSER_DEFINED_PRFIT_AMOUNT(trspayplandetvo.getPROFIT_AMT_NEW());
			}
		    
			trspayplandetCO.setUserDefined("Y");
			
			trspayplandetCO.setExcludeRescheduleYn("Y");
			islamicCalculatorCO.getTrspayplandetVOList().add(lineNo, trspayplandetCO);
			trspayplandetCO.setLINE_STATUS("DUE");
			lineNo = lineNo + 1;
	    }

	    
	}
    }
    
    private void copyPreviousPlandetails(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {

	TRSPAYPLANDETVOKey trspayplandetvoKey = new TRSPAYPLANDETVOKey();
	trspayplandetvoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	trspayplandetvoKey.setBRANCH(islamicCalculatorCO.getBranchCode());
	if(islamicCalculatorCO.getDisbursementScreen())
	{
	    trspayplandetvoKey.setPLAN_NBR(islamicCalculatorCO.getLinkedDealPlanNbr());
	    trspayplandetvoKey.setPLAN_SEQ(islamicCalculatorCO.getLinkedDealPlanSeq());
	}
	else
	{
	    trspayplandetvoKey.setPLAN_NBR(islamicCalculatorCO.getPlanNbr());
	    trspayplandetvoKey.setPLAN_SEQ(islamicCalculatorCO.getPlanSeq());
	}

	List<TRSPAYPLANDETVO> trspayplandetvoList = new ArrayList<TRSPAYPLANDETVO>();
	if(islamicCalculatorCO.getDisbursementScreen()
		&& IISCommonConstants.RESCHEDULE_YES.equals(islamicCalculatorCO.getRevaluationProcess()))
	{

	    trspayplandetvoList = iisIslamicCalculatorDAO.returnDisbursePlanScheduleList(trspayplandetvoKey);
	}
	else
	{

	    trspayplandetvoList = iisIslamicCalculatorDAO.returnPlanScheduleList(trspayplandetvoKey);
	}

	// List<TRSPAYPLANDETVO> trspayplandetvoList =
	// iisIslamicCalculatorDAO.returnPlanScheduleList(trspayplandetvoKey);

	if(trspayplandetvoList == null)
	{
	    return;
	}
	Date firstPaymentDate = islamicCalculatorCO.getFirstPaymentDate();
	BigDecimal lineNo = BigDecimal.ONE;
	int row = 0;
	boolean addRowWithMaturityDate = false;
	boolean recalcValueDate = false;
	Date nextDate = firstPaymentDate;
	// Start main Loop For template
	for(TRSPAYPLANDETVO trspayplandetvo : trspayplandetvoList)
	{
	    row++;
	    if(firstPaymentDate.after(trspayplandetvo.getVALUE_DATE()))
	    {
		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getRescheduleForLateSettlementYn())
			&& row == trspayplandetvoList.size() && islamicCalculatorCO.getTrspayplandetVOList().isEmpty())
		{
		    addRowWithMaturityDate = true;
		}
		else
		{
		    continue;
		}
		if(firstPaymentDate.compareTo(trspayplandetvo.getVALUE_DATE() ) == -1 && lineNo.compareTo(BigDecimal.ONE)  == 0) 
	    {
//	    	islamicCalculatorCO.setNoOfPayments(BigDecimal.valueOf(trspayplandetvoList.size()).subtract(settledLineNo));
//	    	islamicCalculatorCO.setAmountPerPayment(trspayplandetvo.getAMOUNT());
//	    	islamicCalculatorCO = setPlandetailsBasedOnNoPayments(islamicCalculatorCO);
//	    	islamicCalculatorCO.setAmountPerPayment(BigDecimal.ZERO);
	    	trspayplandetvo.setVALUE_DATE(firstPaymentDate);
	    	recalcValueDate = true;
	    }else if(recalcValueDate)
	    {
	    	
	    	nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(), nextDate,
	    		    islamicCalculatorCO.getPaymentPeriodicity(), islamicCalculatorCO.getPaymentPeriodicityNo(), lineNo.longValue(),
	    		    islamicCalculatorCO.getPaymentPeriodicityMonthPos(), null, "P");
	    	trspayplandetvo.setVALUE_DATE(nextDate);
	    	trspayplandetvo.setVALUE_DATE_HIJRI(islamicCalculatorCO.getHijriDate());
	    }
	    }
	    TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
	    trspayplandetCO.setLINE_NBR(lineNo);
	    trspayplandetCO.setVALUE_DATE(trspayplandetvo.getVALUE_DATE());
	    trspayplandetCO.setVALUE_DATE_HIJRI(trspayplandetvo.getVALUE_DATE_HIJRI());
	    trspayplandetCO.setPAYMENT_TYPE(trspayplandetvo.getPAYMENT_TYPE());
	    trspayplandetCO.setDEAL_VALUE_DATE(islamicCalculatorCO.getValueDate());
	    trspayplandetCO.setBALLOON_PAYMENT(BigDecimal.valueOf(0L));
	    trspayplandetCO.setNormalInstallment(ConstantsCommon.YES);
	    if(IISCommonConstants.PAYMENT_TYPE_SPECIFIC_AMOUNT.equals(trspayplandetvo.getPAYMENT_TYPE()))
	    {
		trspayplandetCO.setAMOUNT(trspayplandetvo.getAMOUNT());
		trspayplandetCO.setUSER_DEFINED_AMOUNT(trspayplandetvo.getAMOUNT());
		trspayplandetCO.setUserDefined(ConstantsCommon.YES);
	    }
	    else
	    {
		trspayplandetCO.setUserDefined(ConstantsCommon.NO);
	    }

	    if(NumberUtil.toDoubleObj(islamicCalculatorCO.getAmountPerPayment()) > 0D)
	    {
		trspayplandetCO.setAMOUNT(islamicCalculatorCO.getAmountPerPayment());
		trspayplandetCO.setUSER_DEFINED_AMOUNT(islamicCalculatorCO.getAmountPerPayment());
		trspayplandetCO.setUserDefined(ConstantsCommon.YES);
		// trspayplandetCO.setPAYMENT_TYPE("S");
		trspayplandetCO.setPAYMENT_TYPE("B");
	    }
	    else
	    {
	    	if(islamicCalculatorCO.getDisbursementScreen()
	    			&& islamicCalculatorCO.getRevaluationProcess().equals(IISCommonConstants.RESCHEDULE_NO))
	    	{
	    		trspayplandetCO.setUserDefined(ConstantsCommon.NO);
	    	}
	    	else
	    	{
	    		trspayplandetCO.setUserDefined(ConstantsCommon.NO);
	    		trspayplandetCO.setPAYMENT_TYPE("B");
	    	}
	    }

	    trspayplandetCO.setACC_CY(islamicCalculatorCO.getDealCurrency());
	    trspayplandetCO.setCOVERING_ACC_CY(islamicCalculatorCO.getDealCurrency());
	    /**
	     * set Maturity account
	     */
	    trspayplandetCO.setACC_BR(islamicCalculatorCO.getTRSDET_MATR_AC_BR());
	    trspayplandetCO.setACC_CY(islamicCalculatorCO.getTRSDET_MATR_AC_CY());
	    trspayplandetCO.setACC_GL(islamicCalculatorCO.getTRSDET_MATR_AC_GL());
	    trspayplandetCO.setACC_CIF(islamicCalculatorCO.getTRSDET_MATR_AC_CIF());
	    trspayplandetCO.setACC_SL(islamicCalculatorCO.getTRSDET_MATR_AC_SL());
	    trspayplandetCO.setACC_NAME(islamicCalculatorCO.getTRSDET_MATR_AC_BRIEF_NAME_ENG());
	    trspayplandetCO.setAUTO_CREATE_SETTLEMENT(islamicCalculatorCO.getAUTO_CREATE_SETTLEMENT());

	    if(PAYPLAN_BASED_ON_REDUCE_INSTALLMENT.equals(islamicCalculatorCO.getGenerate_payplan_based_on()))
	    {
	    	// DASI170059 TP 556462 Fawas.Kuruvakkottil 07/11/2017
	    	if ( "N".equals(islamicCalculatorCO.getCalculateVatAfterSchedule())) {
	    		
	    		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getUpfrontProduct()))
				{
				    trspayplandetCO.setAMOUNT(
					    trspayplandetvo.getAMOUNT().add(NumberUtil.nullToZero(trspayplandetvo.getVAT_AMOUNT())));

				}
				else
				{
				    trspayplandetCO.setAMOUNT(trspayplandetvo.getAMOUNT_NEW()
					    .add(NumberUtil.nullToZero(trspayplandetvo.getVAT_AMOUNT())));

				}	
	    	}else {
	    		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getUpfrontProduct()))
				{
				    trspayplandetCO.setAMOUNT(trspayplandetvo.getAMOUNT());
				}
				else
				{
				    trspayplandetCO.setAMOUNT(trspayplandetvo.getAMOUNT_NEW());
				}
	    	}
		    trspayplandetCO.setUSER_DEFINED_AMOUNT(trspayplandetvo.getAMOUNT());
		    
			trspayplandetCO.setUserDefined(ConstantsCommon.YES);

	    }
	    if(addRowWithMaturityDate)
	    {
		trspayplandetCO.setVALUE_DATE(islamicCalculatorCO.getMaturityDate());
	    }
	    islamicCalculatorCO.getTrspayplandetVOList().add(trspayplandetCO);
	    lineNo = lineNo.add(BigDecimal.ONE);
	}

	if(PAYPLAN_BASED_ON_REDUCE_INSTALLMENT.equals(islamicCalculatorCO.getGenerate_payplan_based_on())
		&& !islamicCalculatorCO.getTrspayplandetVOList().isEmpty())
	{
	    islamicCalculatorCO.getTrspayplandetVOList().get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
		    .setPAYMENT_TYPE("B");
	}

    }
    
	private void validate(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	{
	    islamicCalculatorCO.setPaymentPeriodicityMonthPos(IISCommonConstants.MONTH_DAY);
	}
	// TP#237344; Ramesh; Date 05/11/2014[START]
	if((islamicCalculatorCO.getIncludeVatInInstallment() != null)
		&& ((ConstantsCommon.YES).equals(islamicCalculatorCO.getIncludeVatInInstallment()))
		&& (islamicCalculatorCO.getVatCode() == 0))
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
	}
	// TP#237344; Ramesh; Date 05/11/2014 [END]

	if(islamicCalculatorCO.getDealAmount() == null)
	{
	    islamicCalculatorCO.setDealAmount(BigDecimal.ZERO);
	}

	if(islamicCalculatorCO.getDealAmount().compareTo(BigDecimal.ZERO) <= 0)
	{
	    throw new BOException(MessageCodes.ENTER_FINANCING_AMOUNT);
	}
	if(islamicCalculatorCO.getAnnualYeild() == null)
	{
	    islamicCalculatorCO.setAnnualYeild(BigDecimal.ZERO);
	}

	if((!IISCommonConstants.ISLAMIC_CALCULATOR_AR_RAHANU.equals(islamicCalculatorCO.getCalculatorType())
		&& !"REPAYMENT_PLAN".equals(islamicCalculatorCO.getCalculatorType()))
		&& (ConstantsCommon.YES.equals(islamicCalculatorCO.getYieldRequiredYn()))
		&& (islamicCalculatorCO.getAnnualYeild().compareTo(BigDecimal.ZERO) <= 0)
		&& (NumberUtil.isEmptyDecimal(islamicCalculatorCO.getProfitCollected()))
		&& (StringUtil.isEmptyString(islamicCalculatorCO.getRescheduleType())
			|| IISCommonConstants.RESCHEDULE_TYPE_RECALCULATE
				.equals(islamicCalculatorCO.getRescheduleType())))

	{
	    throw new BOException(MessageCodes.CHECK_YIELD_VALUE, new String[] { "0", "99999.999999" });
	}

	if(IISCommonConstants.PAYMENT_PERIODICITY_TYPE_MONTHLY.equals(islamicCalculatorCO.getPaymentPeriodicity())
		&& islamicCalculatorCO.getPaymentPeriodicityMonthPos() == null)
	{

	    throw new BOException(MessageCodes.NULL_PAYMWENT_PERIODICITY_POS);
	}
	if(islamicCalculatorCO.getCalendarType() == null)
	{
	    throw new BOException(MessageCodes.NULL_CALENDAR_TYPE);
	}
	if(islamicCalculatorCO.getResidualValue() == null)
	{
	    throw new BOException(MessageCodes.NULL_RESIDUAL_VALUE);
	}
	if(islamicCalculatorCO.getFirstPaymentDate() == null)
	{
	    throw new BOException(MessageCodes.NULL_FIRST_INSTALLMENT_DATE);
	}
	if(islamicCalculatorCO.getProfitCalculationMethod() == null)
	{
	    throw new BOException(MessageCodes.NULL_PROFIT_CALCULATION_METHOD);
	}
	if(islamicCalculatorCO.getProfitRecognitionMethod() == null)
	{
	    throw new BOException(MessageCodes.NULL_PROFIT_RECOGNITION_METHOD);
	}
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getOutstandingPrincipalAsInstallment())
		&& islamicCalculatorCO.getOutstandingPrincipalInstallmentDate() == null)
	{
	    throw new BOException(MessageCodes.INVALID_OUTSTDING_PRINCIPAL_AS_INST_DTE);
	}

	if(islamicCalculatorCO.getTrsDealMultipleDisbursementList() != null
		&& islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() > 0)
	{
	    if((ConstantsCommon.YES.equals(islamicCalculatorCO.getDisburs_maintain_indiv_plan_yn())
		    && (IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit())
			    || IISCommonConstants.COMPOUND_PROFIT_GRACE
				    .equals(islamicCalculatorCO.getCompoundingProfit())))
		    && islamicCalculatorCO.getFirstPaymentDate()
			    .before(islamicCalculatorCO.getTrsDealMultipleDisbursementList()
				    .get(islamicCalculatorCO.getTrsDealMultipleDisbursementList().size())
				    .getVALUE_DATE()))
	    {
		throw new BOException(MessageCodes.CHECK_YIELD_VALUE,
			new String[] { "First_payment_date_cannot_before_LastDisbursement_date" }, false);
	    }
	    if((IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit())
		    || IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())))
	    {
		throw new BOException(MessageCodes.CHECK_YIELD_VALUE,
			new String[] { "Deal_Period_Compounding_cannot_for_Project_Finance_Deals" }, false);
		// TODO - Need to call this from Save
	    }
	}
	validateBalloonDetails(islamicCalculatorCO);
	if(islamicCalculatorCO.getTrsDealMultipleYieldVO() != null
		&& islamicCalculatorCO.getTrsDealMultipleYieldVO().size() > 0
		&& IISCommonConstants.PROFIT_DISTRIBUTION_METHOD_RULE_78
			.equals(islamicCalculatorCO.getProfitRecognitionMethod()))
	{

	    throw new BOException(MessageCodes.CHECK_YIELD_VALUE, new String[] { "Multiple_Yield_cannot_for_Rule_78" },
		    false);

	}
	// Commented by Manoj on 27 Aug 2012
	/*
	 * if(islamicCalculatorCO.getCapitalizePeriodicity().equals(
	 * ConstantsCommon.YES)) {
	 * if(islamicCalculatorCO.getCapitalizationStartOn() == null) { throw
	 * new BaseException(MessageCodes.NULL_CAPITALIZATION_START_DATE); } }
	 */
	if(islamicCalculatorCO.getValueDate().after(islamicCalculatorCO.getMaturityDate()))
	{
	    throw new BOException(MessageCodes.INVALID_VALUE_DATE);
	}

	
		
	///////
	// DASI170030 TP 555811 Fawas.Kuruvakkottil 18/09/2017 Start
    else if((IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS.equals(islamicCalculatorCO.getProfitCalculationMethod())
	    && islamicCalculatorCO.getProfitRecognitionMethod().equals(IISCommonConstants.PROFIT_DISTRIBUTION_METHOD_STRAIGHT_LINE))
    	&& (NumberUtil.nullToZero(islamicCalculatorCO.getTemplateCode()).compareTo(BigDecimal.ZERO) == 1
    			|| (islamicCalculatorCO.getTrsPayPlanCriteriaVO() != null && !islamicCalculatorCO.getTrsPayPlanCriteriaVO().isEmpty()))
	    )
    {
    	 throw new BOException(MessageCodes.iis_invalid_code,
    			    new String[] { "profit_calc_diminishing_disbrb_straigh_is_not_applicable_for_template_criteria_key" }, false);
    }
	
	if(islamicCalculatorCO.getFirstPaymentDate().after(islamicCalculatorCO.getMaturityDate())
		|| islamicCalculatorCO.getFirstPaymentDate().before(islamicCalculatorCO.getValueDate()))
	{
	    throw new BOException(MessageCodes.INVALID_FIRST_PAYMENT_DATE);
	}
	// PMD infractions; Saheer.Naduthodi; 10/12/2014
	if((IISCommonConstants.COMPOUND_PROFIT_GRACE.equals(islamicCalculatorCO.getCompoundingProfit())
		|| IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit()))
		&& (islamicCalculatorCO.getCompoundingProfitPeriodicityNo() == null
			|| islamicCalculatorCO.getCompoundingProfitPeriodicityNo().intValue() <= 0))
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "invalid_compounding_grace_periodicity" }, false);
	}
	if(IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())
		|| IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit()))
	{
	    if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		    .equals(islamicCalculatorCO.getProfitCalculationMethod())
		    && IISCommonConstants.PROFIT_DISTRIBUTION_METHOD_STRAIGHT_LINE
			    .equals(islamicCalculatorCO.getProfitRecognitionMethod())
		    && ConstantsCommon.YES.equals(islamicCalculatorCO.getPrincipalInLastPayment()))
	    {
		return;
	    }
	    else if(IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
		    .equals(islamicCalculatorCO.getProfitCalculationMethod()))
	    {
		if(IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
			.equals(islamicCalculatorCO.getProfitCalculationMethod())

			&& IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
				.equals(islamicCalculatorCO.getProfitRecognitionMethod())
			&& ConstantsCommon.NO.equals(islamicCalculatorCO.getRedusingBalanceMethod())
			&& ConstantsCommon.YES.equals(islamicCalculatorCO.getUpfrontProduct()))
		{
		    if(IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit()))
		    {
			throw new BOException(MessageCodes.COMPNDING_DURING_GRACE_PERIOD_VALIDATION);
		    }
		    // continue
		}
		else
		{
		    throw new BOException(MessageCodes.COMPNDING_DURING_DEAL_PERIOD_VALIDATION);
		}
	    }
	}
	if(islamicCalculatorCO.getOriginalValueDate() == null)
	{
	    islamicCalculatorCO.setOriginalValueDate(islamicCalculatorCO.getValueDate());
	}

	if(islamicCalculatorCO.getOriginalDealAmount() == null)
	{
	    islamicCalculatorCO.setOriginalDealAmount(islamicCalculatorCO.getDealAmount());
	}

	if(islamicCalculatorCO.getCapitalization() == null)
	{
	    islamicCalculatorCO.setCapitalization(ConstantsCommon.NO);
	}
	if(NumberUtil.nullToZero(islamicCalculatorCO.getNoOfBaloonPayments()).compareTo(BigDecimal.ZERO) != 1)
	{
	    islamicCalculatorCO.setNoOfBaloonPayments(BigDecimal.ZERO);
	}
    }

	private Date getNextHijiriValueDate(IslamicCalculatorCO islamicCalculatorCO, Date firstPaymentDate,
	    Date nextDateParam, String paymentPeriodicity, Long paymentPeriodicityNo, Long lineNo,
	    String paymentMonthPos, Long paymentSetDayParam, String scheculeType) throws BaseException
    {
	Long paymentSetDay = paymentSetDayParam;
	Date nextDate = nextDateParam;
	BigDecimal compCode = islamicCalculatorCO.getCompanyCode();
	String nextHijriDate = islamicCalculatorCO.getHijriDate();
	if(nextHijriDate == null)
	{
	    nextHijriDate = hijiriCalendarBO.getHijiriDateForGregorian(compCode, nextDate);
	}

	if(IISCommonConstants.DAY.equals(paymentPeriodicity))// Payment
	// Periodicity is
	// Daily
	{
	    nextHijriDate = hijiriCalendarBO.addDays(compCode, BigDecimal.valueOf(paymentPeriodicityNo), nextHijriDate);
	}
	else if(IISCommonConstants.WEEK.equals(paymentPeriodicity))// Payment
	// Periodicity
	// is Weekly
	{
	    nextHijriDate = hijiriCalendarBO.addDays(compCode, BigDecimal.valueOf(paymentPeriodicityNo * 7),
		    nextHijriDate);
	}
	else if(IISCommonConstants.MONTH.equals(paymentPeriodicity))// Payment
	// Periodicity
	// is
	// Monthly
	{
	    nextHijriDate = hijiriCalendarBO.addMonths(compCode, BigDecimal.valueOf(paymentPeriodicityNo),
		    nextHijriDate);
	    if(ConstantsCommon.NO.equals(scheculeType))
	    {
		islamicCalculatorCO.setHijriDate(nextHijriDate);
		return hijiriCalendarBO.getGregorianDate(compCode, nextHijriDate);
	    }
	    if(IISCommonConstants.MONTH_DAY.equals(paymentMonthPos))
	    {
		// Set Date
		if(paymentSetDay == null || paymentSetDay <= 0L)
		{
		    String hijiriFirstPaymentDate = hijiriCalendarBO.getHijiriDateForGregorian(compCode,
			    firstPaymentDate);
		    paymentSetDay = NumberUtil.toInteger(StringUtil.substring(hijiriFirstPaymentDate, 1, 2))
			    .longValue();
		}
		long day = NumberUtil.toInt(StringUtil.substring(nextHijriDate, 1, 2));
		if(!paymentSetDay.equals(day))
		{
		    long month = NumberUtil.toInt(StringUtil.substring(nextHijriDate, 4, 2));
		    long year = NumberUtil.toInt(StringUtil.substring(nextHijriDate, 7, 4));
		    nextHijriDate = hijiriCalendarBO.createHijiriDate(compCode, paymentSetDay, month, year, -1);

		}
	    }
	    else if(IISCommonConstants.MONTH_END.equals(paymentMonthPos))// Last
	    // day
	    // Of
	    // the
	    // Month
	    {
		nextHijriDate = hijiriCalendarBO.getHijiriMonthLastDate(compCode, nextHijriDate);
		islamicCalculatorCO.setHijriDate(nextHijriDate);
		return hijiriCalendarBO.getGregorianDate(compCode, nextHijriDate);
	    }
	    else if(IISCommonConstants.MONTH_MIDDLE.equals(paymentMonthPos))
	    {
		long day = NumberUtil.toInt(StringUtil.substring(nextHijriDate, 1, 2));
		long month = NumberUtil.toInt(StringUtil.substring(nextHijriDate, 4, 2));
		long year = NumberUtil.toInt(StringUtil.substring(nextHijriDate, 7, 4));

		if(day != 15)
		{
		    day = 15;
		    nextHijriDate = hijiriCalendarBO.createHijiriDate(compCode, day, month, year, -1);
		    islamicCalculatorCO.setHijriDate(nextHijriDate);
		    return hijiriCalendarBO.getGregorianDate(compCode, nextHijriDate);

		}
	    }
	    else if(IISCommonConstants.MONTH_START.equals(paymentMonthPos))
	    {
		long day = NumberUtil.toInt(StringUtil.substring(nextHijriDate, 1, 2));
		long month = NumberUtil.toInt(StringUtil.substring(nextHijriDate, 4, 2));
		long year = NumberUtil.toInt(StringUtil.substring(nextHijriDate, 7, 4));

		if(day != 1)
		{
		    day = 1;
		    nextHijriDate = hijiriCalendarBO.createHijiriDate(compCode, day, month, year, -1);
		    islamicCalculatorCO.setHijriDate(nextHijriDate);
		    return hijiriCalendarBO.getGregorianDate(compCode, nextHijriDate);

		}

	    }
	}
	else if(IISCommonConstants.GRACE.equals(paymentPeriodicity))
	{
	    String hijiriFirstPaymentDate = hijiriCalendarBO.getHijiriDateForGregorian(compCode, firstPaymentDate);
	    nextHijriDate = hijiriCalendarBO.addDays(compCode, BigDecimal.valueOf(-1), hijiriFirstPaymentDate);
	}
	else
	{
	    // Payment Periodicity is Qtly/Half YEarly/Yearly
	    nextDate = getNextDayForAnnualyPayment(nextDate, paymentPeriodicity, paymentPeriodicityNo, lineNo);
	    nextHijriDate = hijiriCalendarBO.getHijiriDateForGregorian(compCode, nextDate);
	}
	nextDate = hijiriCalendarBO.getGregorianDate(compCode, nextHijriDate);
	islamicCalculatorCO.setHijriDate(nextHijriDate);
	return nextDate;

    }

    public Date getNextValueDate(Date firstPaymentDate, Date nextDate, String paymentPeriodicity,
	    Long paymentPeriodicityNo, Long lineNo, String paymentMonthPos, Long paymentSetDay, String scheculeType)
	    throws BaseException
    {
	IslamicCalculatorCO islamicCalculatorCO = new IslamicCalculatorCO();
	islamicCalculatorCO.setCalendarType(IISCommonConstants.CALENDAR_TYPE_GREGORIAN_G);
	return getNextValueDate(islamicCalculatorCO, firstPaymentDate, nextDate, paymentPeriodicity,
		paymentPeriodicityNo, lineNo, paymentMonthPos, paymentSetDay, scheculeType);
    }

    private Date dateAdd(String dateField, Long theValue, Date date)
    {
	return DateUtil.dateAdd(dateField, theValue, date);
    }

    private Date getNextValueDate(IslamicCalculatorCO islamicCalculatorCO, Date firstPaymentDate, Date nextDateParam,
	    String paymentPeriodicity, Long paymentPeriodicityNo, Long lineNo, String paymentMonthPos,
	    Long paymentSetDayParam, String scheculeType) throws BaseException
    {
	Date nextDate = nextDateParam;
	Long paymentSetDay = paymentSetDayParam;
	if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
	{
	    return getNextHijiriValueDate(islamicCalculatorCO, firstPaymentDate, nextDate, paymentPeriodicity,
		    paymentPeriodicityNo, lineNo, paymentMonthPos, paymentSetDay, scheculeType);
	}
	if(IISCommonConstants.DAY.equals(paymentPeriodicity))// Payment
	// Periodicity is
	// Daily
	{
	    nextDate = dateAdd(DateUtil.DAY, paymentPeriodicityNo, nextDate);
	}
	else if(IISCommonConstants.WEEK.equals(paymentPeriodicity))// Payment
	// Periodicity
	// is Weekly
	{
	    nextDate = dateAdd(DateUtil.DAY, (paymentPeriodicityNo * 7), nextDate);
	}
	else if(IISCommonConstants.MONTH.equals(paymentPeriodicity))// Payment
	// Periodicity
	// is
	// Monthly
	{
	    nextDate = dateAdd(DateUtil.MONTH, paymentPeriodicityNo, nextDate);
	    if(ConstantsCommon.NO.equals(scheculeType))
	    {
		return DateUtil.removeTimeFromDate(nextDate);
	    }

	    if(IISCommonConstants.MONTH_DAY.equals(paymentMonthPos))
	    {
		// Set Date
		if(paymentSetDay == null || paymentSetDay <= 0L)
		{
		    paymentSetDay = DateUtil.getDatePart("DD", firstPaymentDate);
		}
		if(!paymentSetDay.equals(DateUtil.getDatePart("DD", nextDate)))
		{
		    nextDate = getNextDateSetNewDay(nextDate, paymentSetDay);
		}
	    }
	    else if(IISCommonConstants.MONTH_END.equals(paymentMonthPos))
	    /*
	     * Last day Of the Month
	     */
	    {
		return DateUtil.removeTimeFromDate(DateUtil.getMonthLastDay(nextDate));
	    }
	    else if(IISCommonConstants.MONTH_MIDDLE.equals(paymentMonthPos))
	    {
		if(!DateUtil.getDatePart("DD", nextDate).equals(15L))
		{
		    return DateUtil.removeTimeFromDate(getNextDateSetNewDay(nextDate, 15L));
		}
	    }
	    else if((IISCommonConstants.MONTH_START.equals(paymentMonthPos))
		    && (!DateUtil.getDatePart("DD", nextDate).equals(1L)))
	    {

		return DateUtil.removeTimeFromDate(getNextDateSetNewDay(nextDate, 1L));
	    }
	}
	else if(IISCommonConstants.GRACE.equals(paymentPeriodicity))
	{
	    // nextDate = DateUtil.dateAdd(DateUtil.MONTH, -1L,
	    // firstPaymentDate);
	    nextDate = dateAdd(DateUtil.DAY, -1L, firstPaymentDate);
	}
	else
	{
	    // Payment Periodicity is Qtly/Half YEarly/Yearly
	    nextDate = getNextDayForAnnualyPayment(nextDate, paymentPeriodicity, paymentPeriodicityNo, lineNo);
	}
	return DateUtil.removeTimeFromDate(nextDate);
    }

    private Date getNextDateSetNewDay(Date date, Long day) throws BaseException
    {
	Calendar calendar = new GregorianCalendar();
	calendar.setTime(date);
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH);
	// Commented by Manoj on 18/09/2018
	// To fix BB issue skipping one month
	// int actDay = calendar.get(Calendar.DAY_OF_MONTH);
	// if(actDay > day)
	// {
	// month = month + 1;
	// if(month > 11)
	// {
	// month = 0;
	// year = year + 1;
	// }
	// }
	calendar.set(year, month, day.intValue());
	if(calendar.get(Calendar.MONTH) != month)
	{
	    int day1 = calendar.get(Calendar.DAY_OF_MONTH);
	    calendar.add(Calendar.DAY_OF_MONTH, -day1);
	}
	return calendar.getTime();
    }

    private Date getNextDayForAnnualyPayment(Date date, String periodicity, Long periodicityNo, Long lineNo)
	    throws BaseException
    {
	Calendar calendar = new GregorianCalendar();
	calendar.setTime(date);
	long month = 0;
	if(lineNo > 1L)
	{
	    if(IISCommonConstants.QUARTER.equals(periodicity))
	    {
		month = 3 * (periodicityNo.intValue());
	    }
	    else if(IISCommonConstants.SEMI.equals(periodicity))
	    {
		month = 6 * (periodicityNo.intValue());
	    }
	    else
	    {
		month = 12 * (periodicityNo.intValue());
	    }
	    return DateUtil.getMonthLastDay(DateUtil.dateAdd(DateUtil.MONTH, month, date));
	}
	Date nextDate;
	if(IISCommonConstants.QUARTER.equals(periodicity))
	{
	    if(calendar.get(Calendar.MONTH) <= 2)
	    {
		month = 2 - calendar.get(Calendar.MONTH);
	    }
	    else if(calendar.get(Calendar.MONTH) <= 5)
	    {
		month = 5 - calendar.get(Calendar.MONTH);
	    }
	    else if(calendar.get(Calendar.MONTH) <= 8)
	    {
		month = 8 - calendar.get(Calendar.MONTH);
	    }
	    else if(calendar.get(Calendar.MONTH) <= 11)
	    {
		month = 11 - calendar.get(Calendar.MONTH);
	    }
	    nextDate = DateUtil.getMonthLastDay(DateUtil.dateAdd(DateUtil.MONTH, month, date));

	    month = 3 * (periodicityNo.intValue() - 1);
	    if(nextDate.equals(date))
	    {
		month = month + 3;
	    }
	}
	else if(IISCommonConstants.SEMI.equals(periodicity))
	{
	    if(calendar.get(Calendar.MONTH) <= 5)
	    {
		month = 5 - calendar.get(Calendar.MONTH);
	    }
	    else if(calendar.get(Calendar.MONTH) <= 11)
	    {
		month = 11 - calendar.get(Calendar.MONTH);
	    }
	    nextDate = DateUtil.getMonthLastDay(DateUtil.dateAdd("MM", month, date));
	    month = 6 * (periodicityNo.intValue() - 1);
	    if(nextDate.equals(date))
	    {
		month = month + 6;
	    }
	}
	else
	{
	    month = 11 - calendar.get(Calendar.MONTH);
	    nextDate = DateUtil.getMonthLastDay(DateUtil.dateAdd(DateUtil.MONTH, month, date));
	    month = 12 * (periodicityNo.intValue() - 1);
	    if(nextDate.equals(date))
	    {
		month = month + 12;
	    }
	}
	nextDate = DateUtil.dateAdd(DateUtil.MONTH, month, nextDate);
	return DateUtil.getMonthLastDay(nextDate);

    }

    private String getCriteriaPaymentType(String paymentType)
    {
	if(IISCommonConstants.PAYMENT_TYPE_UPFRONT_PROFIT.equals(paymentType))
	{
	    return "P";
	}
	else if(IISCommonConstants.PAYMENT_TYPE_UPFRONT_PRINCIPAL_UPFRONT_PROFIT.equals(paymentType)
		|| IISCommonConstants.PAYMENT_TYPE_PRINCIPAL_UPFRONT_PROFIT.equals(paymentType))
	{
	    return "B";
	}
	else
	{
	    return paymentType;
	}

    }

    private IslamicCalculatorCO setPlandetailsBasedOnCriteria(IslamicCalculatorCO islamicCalculatorCO)
	    throws BaseException
    {
	// schedule create based on the criteria
	// Date prevDate = null;
	// if the criteria not defined return
	if(islamicCalculatorCO.getTrsPayPlanCriteriaVO().size() <= 0)
	{
	    return islamicCalculatorCO;
	}
	getPayProfitAndChargesOnly(islamicCalculatorCO);

	Map<Date, Long> planMap = new HashMap<Date, Long>();
	ArrayList<Date> planArrayList = new ArrayList<Date>();
	List<TrspayplandetCO> trspayplandetCOListTemp = new ArrayList<TrspayplandetCO>();

	Long lineNo = 0L;
	Long seqLineNo = 0L;
	Date nextDate = islamicCalculatorCO.getFirstPaymentDate();
	Date actualPaymentStartDate = islamicCalculatorCO.getFirstPaymentDate();
	String hijiriDate = null;
	String checkFirstPaydateYN = "N";
	if(islamicCalculatorCO.getRevaluationProcess().equals(IISCommonConstants.RESCHEDULE_YES)
		|| islamicCalculatorCO.getDisbursementScreen())
	{
	    checkFirstPaydateYN = "Y";
	}
	// Start Main loop for Criteria
	for(TrspayplanCriteriaCO trsPayPlanCriteriaVO : islamicCalculatorCO.getTrsPayPlanCriteriaVO())
	{
		if(trsPayPlanCriteriaVO.getPAYMENT_TYPE() == null || StringUtil.isEmptyString(trsPayPlanCriteriaVO.getPAYMENT_TYPE()))
	    {
		throw new BOException(MessageCodes.iis_invalid_code,
			new String[] { "Specify_Valid_Value_For_Payment_Type" }, false);
	    }
	    
	    nextDate = trsPayPlanCriteriaVO.getFROM_DATE();
	    if(!IISCommonConstants.RESCHEDULE_YES .equals(islamicCalculatorCO.getRescheduleYn())){
	    	actualPaymentStartDate = trsPayPlanCriteriaVO.getFROM_DATE();
	    }
	    
	    if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
	    {
		hijiriDate = hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(), nextDate);
		islamicCalculatorCO.setHijriDate(hijiriDate);
	    }
	    seqLineNo = 0L;
	    do
	    {
		// start loop for each line
		seqLineNo++;
		if((!nextDate.before(islamicCalculatorCO.getFirstPaymentDate()) && "Y".equals(checkFirstPaydateYN))
			|| "N".equals(checkFirstPaydateYN))
		{
		Long planExist = planMap.get(nextDate);
		if(planExist == null)
		{
		    TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
		    lineNo++;

		    trspayplandetCO.setLINE_NBR(BigDecimal.valueOf(lineNo));
		    trspayplandetCO.setVALUE_DATE(nextDate);
		    trspayplandetCO.setVALUE_DATE_HIJRI(hijiriDate);
		    trspayplandetCO.setACTUAL_PAYMENT_TYPE(trsPayPlanCriteriaVO.getPAYMENT_TYPE());
		    trspayplandetCO.setPAYMENT_TYPE(getCriteriaPaymentType(trsPayPlanCriteriaVO.getPAYMENT_TYPE()));
		    trspayplandetCO.setDEAL_VALUE_DATE(islamicCalculatorCO.getValueDate());
		    if(IISCommonConstants.PAYMENT_TYPE_SPECIFIC_AMOUNT.equals(trsPayPlanCriteriaVO.getPAYMENT_TYPE()))
		    {
			trspayplandetCO.setAMOUNT(trsPayPlanCriteriaVO.getCAPITAL_AMT());
			trspayplandetCO.setUSER_DEFINED_AMOUNT(trsPayPlanCriteriaVO.getCAPITAL_AMT());
			trspayplandetCO.setUserDefined(ConstantsCommon.YES);
		    }
		    else if(NumberUtil.toDoubleObj(trsPayPlanCriteriaVO.getCAPITAL_AMT()) > 0D)
		    {
			trspayplandetCO.setCAPITAL_AMT(trsPayPlanCriteriaVO.getCAPITAL_AMT());
			trspayplandetCO.setPRINCIPLE_AMT(trsPayPlanCriteriaVO.getCAPITAL_AMT());
			trspayplandetCO.setUSER_DEFINED_AMOUNT(trsPayPlanCriteriaVO.getCAPITAL_AMT());
			trspayplandetCO.setUserDefined(ConstantsCommon.YES);
		    }
		    else
		    {
			trspayplandetCO.setUserDefined(ConstantsCommon.NO);
		    }
		    trspayplandetCO.setAUTO_CREATE_SETTLEMENT(trsPayPlanCriteriaVO.getAUTO_CREATE_SETTLEMENT_YN());
		    trspayplandetCO.setACC_BR(trsPayPlanCriteriaVO.getACC_BR());
		    trspayplandetCO.setACC_CY(trsPayPlanCriteriaVO.getACC_CY());
		    trspayplandetCO.setACC_GL(trsPayPlanCriteriaVO.getACC_GL());
		    trspayplandetCO.setACC_CIF(trsPayPlanCriteriaVO.getACC_CIF());
		    trspayplandetCO.setACC_SL(trsPayPlanCriteriaVO.getACC_SL());
		    trspayplandetCO.setACC_NAME(trsPayPlanCriteriaVO.getACC_NAME());
		    trspayplandetCO.setCOVERING_ACC_BR(trsPayPlanCriteriaVO.getCOVERING_ACC_BR());
		    trspayplandetCO.setCOVERING_ACC_CY(trsPayPlanCriteriaVO.getCOVERING_ACC_CY());
		    trspayplandetCO.setCOVERING_ACC_GL(trsPayPlanCriteriaVO.getCOVERING_ACC_GL());
		    trspayplandetCO.setCOVERING_ACC_CIF(trsPayPlanCriteriaVO.getCOVERING_ACC_CIF());
		    trspayplandetCO.setCOVERING_ACC_SL(trsPayPlanCriteriaVO.getCOVERING_ACC_SL());
		    trspayplandetCO.setCOVERING_ACC_NAME(trsPayPlanCriteriaVO.getCOVERING_ACC_NAME());

		    trspayplandetCO.setAUTO_CREATE_SETTLEMENT(islamicCalculatorCO.getAUTO_CREATE_SETTLEMENT());
		    trspayplandetCO.setBALLOON_PAYMENT(BigDecimal.valueOf(0L));
		    trspayplandetCO.setNormalInstallment(ConstantsCommon.YES);
		    trspayplandetCOListTemp.add(trspayplandetCO);
		    planMap.put(nextDate, lineNo);
		    planArrayList.add(nextDate);
		}
		else
		{
		    int index = planExist.intValue() - 1;
		    trspayplandetCOListTemp.get(index).setACTUAL_PAYMENT_TYPE(trsPayPlanCriteriaVO.getPAYMENT_TYPE());
		    trspayplandetCOListTemp.get(index)
			    .setPAYMENT_TYPE(getCriteriaPaymentType(trsPayPlanCriteriaVO.getPAYMENT_TYPE()));

		    if(IISCommonConstants.PAYMENT_TYPE_SPECIFIC_AMOUNT.equals(trsPayPlanCriteriaVO.getPAYMENT_TYPE()))
		    {
			trspayplandetCOListTemp.get(index).setAMOUNT(trsPayPlanCriteriaVO.getCAPITAL_AMT());
			trspayplandetCOListTemp.get(index)
				.setUSER_DEFINED_AMOUNT(trsPayPlanCriteriaVO.getCAPITAL_AMT());
			trspayplandetCOListTemp.get(index).setUserDefined(ConstantsCommon.YES);
		    }
		    else if(NumberUtil.toDoubleObj(trsPayPlanCriteriaVO.getCAPITAL_AMT()) > 0D)
		    {
			trspayplandetCOListTemp.get(index).setCAPITAL_AMT(trsPayPlanCriteriaVO.getCAPITAL_AMT());
			trspayplandetCOListTemp.get(index).setPRINCIPLE_AMT(trsPayPlanCriteriaVO.getCAPITAL_AMT());
			trspayplandetCOListTemp.get(index)
				.setUSER_DEFINED_AMOUNT(trsPayPlanCriteriaVO.getCAPITAL_AMT());
			trspayplandetCOListTemp.get(index).setUserDefined(ConstantsCommon.YES);
		    }
		    else
		    {
			trspayplandetCOListTemp.get(index).setUserDefined(ConstantsCommon.NO);
		    }
		    trspayplandetCOListTemp.get(index)
			    .setAUTO_CREATE_SETTLEMENT(trsPayPlanCriteriaVO.getAUTO_CREATE_SETTLEMENT_YN());
		    trspayplandetCOListTemp.get(index).setACC_BR(trsPayPlanCriteriaVO.getACC_BR());
		    trspayplandetCOListTemp.get(index).setACC_CY(trsPayPlanCriteriaVO.getACC_CY());
		    trspayplandetCOListTemp.get(index).setACC_GL(trsPayPlanCriteriaVO.getACC_GL());
		    trspayplandetCOListTemp.get(index).setACC_CIF(trsPayPlanCriteriaVO.getACC_CIF());
		    trspayplandetCOListTemp.get(index).setACC_SL(trsPayPlanCriteriaVO.getACC_SL());
		    trspayplandetCOListTemp.get(index).setACC_NAME(trsPayPlanCriteriaVO.getACC_NAME());
		    trspayplandetCOListTemp.get(index).setCOVERING_ACC_BR(trsPayPlanCriteriaVO.getCOVERING_ACC_BR());
		    trspayplandetCOListTemp.get(index).setCOVERING_ACC_CY(trsPayPlanCriteriaVO.getCOVERING_ACC_CY());
		    trspayplandetCOListTemp.get(index).setCOVERING_ACC_GL(trsPayPlanCriteriaVO.getCOVERING_ACC_GL());
		    trspayplandetCOListTemp.get(index).setCOVERING_ACC_CIF(trsPayPlanCriteriaVO.getCOVERING_ACC_CIF());
		    trspayplandetCOListTemp.get(index).setCOVERING_ACC_SL(trsPayPlanCriteriaVO.getCOVERING_ACC_SL());
		    trspayplandetCOListTemp.get(index)
			    .setCOVERING_ACC_NAME(trsPayPlanCriteriaVO.getCOVERING_ACC_NAME());
		    trspayplandetCOListTemp.get(index)
			    .setAUTO_CREATE_SETTLEMENT(islamicCalculatorCO.getAUTO_CREATE_SETTLEMENT());
		}
		}
		if(nextDate.compareTo(islamicCalculatorCO.getMaturityDate()) == 0)
		{
		    break;
		}
		// prevDate = nextDate;
		nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(), nextDate,
			trsPayPlanCriteriaVO.getPAYM_PERIODICITY(),
			trsPayPlanCriteriaVO.getPAYM_PERIOD_NBR().longValue(), seqLineNo,
			trsPayPlanCriteriaVO.getPAYM_PERIOD_POS(),
			NumberUtil.toInteger(trsPayPlanCriteriaVO.getPAYM_DAY()).longValue(), "P");
		if(nextDate.compareTo(islamicCalculatorCO.getMaturityDate()) == 1)
		{
		    nextDate = islamicCalculatorCO.getMaturityDate();
		    if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
		    {
			hijiriDate = hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(),
				islamicCalculatorCO.getMaturityDate());
			islamicCalculatorCO.setHijriDate(hijiriDate);
		    }

		}
		hijiriDate = islamicCalculatorCO.getHijriDate();
		if(seqLineNo != null && trsPayPlanCriteriaVO.getNO_OF_PAYMENTS() != null
			&& BigDecimal.valueOf(seqLineNo).equals(trsPayPlanCriteriaVO.getNO_OF_PAYMENTS()))
		{
		    break;
		}
	    }while(nextDate.before(trsPayPlanCriteriaVO.getTO_DATE())
		    || nextDate.equals(trsPayPlanCriteriaVO.getTO_DATE()));
	}
	lineNo = (long) trspayplandetCOListTemp.size();
	if(islamicCalculatorCO.getMaturityDate()
		.compareTo(islamicCalculatorCO.getTrsPayPlanCriteriaVO()
			.get(islamicCalculatorCO.getTrsPayPlanCriteriaVO().size() - 1).getTO_DATE()) == -1
		&& planMap.get(islamicCalculatorCO.getMaturityDate()) == null)
	{

	    // }
	    // if(planMap.get(islamicCalculatorCO.getMaturityDate()) == null)
	    // {
	    TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
	    lineNo = lineNo + 1;
	    trspayplandetCO.setLINE_NBR(BigDecimal.valueOf(lineNo));
	    trspayplandetCO.setVALUE_DATE(islamicCalculatorCO.getMaturityDate());
	    if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
	    {
		hijiriDate = hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(),
			islamicCalculatorCO.getMaturityDate());
		islamicCalculatorCO.setHijriDate(hijiriDate);
	    }
	    trspayplandetCO.setVALUE_DATE_HIJRI(hijiriDate);
	    trspayplandetCO.setPAYMENT_TYPE("B");
	    trspayplandetCO.setDEAL_VALUE_DATE(islamicCalculatorCO.getValueDate());
	    trspayplandetCO.setBALLOON_PAYMENT(BigDecimal.valueOf(0L));
	    trspayplandetCO.setNormalInstallment(ConstantsCommon.YES);
	    trspayplandetCO.setUserDefined(ConstantsCommon.NO);
	    trspayplandetCOListTemp.add(trspayplandetCO);
	    planMap.put(islamicCalculatorCO.getMaturityDate(), lineNo);
	    planArrayList.add(islamicCalculatorCO.getMaturityDate());
	    islamicCalculatorCO.setLastInstallmentOnMaturityDate(ConstantsCommon.NO);
	}

	else if(planMap.get(islamicCalculatorCO.getMaturityDate()) == null)
	{
	    nextDate = trspayplandetCOListTemp.get(trspayplandetCOListTemp.size() - 1).getVALUE_DATE();
	    // Long index = planMap.get(nextDate);
	    planMap.remove(nextDate);
	    planArrayList.remove(nextDate);
	    trspayplandetCOListTemp.get(trspayplandetCOListTemp.size() - 1)
		    .setVALUE_DATE(islamicCalculatorCO.getMaturityDate());
	    if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
	    {
		hijiriDate = hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(),
			islamicCalculatorCO.getMaturityDate());
		islamicCalculatorCO.setHijriDate(hijiriDate);
	    }
	    trspayplandetCOListTemp.get(trspayplandetCOListTemp.size() - 1).setVALUE_DATE_HIJRI(hijiriDate);
	    planMap.put(islamicCalculatorCO.getMaturityDate(), lineNo);
	    planArrayList.add(islamicCalculatorCO.getMaturityDate());
	}

	// Need to sort the list again
	insertBaloonPaymentDet(islamicCalculatorCO, planMap, planArrayList, trspayplandetCOListTemp, lineNo);
	// sortPayPlanDet(islamicCalculatorCO, planArrayList, planMap,
	// trspayplandetCOListTemp);Commented by Linchu as the schedule was
	// coming with incorrect no Of payments.28-07-2013
	return islamicCalculatorCO;
    }

    private void sortPayPlanDet(IslamicCalculatorCO islamicCalculatorCO, ArrayList<Date> planArrayList,
	    Map<Date, Long> planMap, List<TrspayplandetCO> trspayplandetCOListTemp)
    {
	if(islamicCalculatorCO.getTrspayplandetVOList().isEmpty() && trspayplandetCOListTemp.isEmpty())
	{
	    return;
	}
	Collections.sort(planArrayList);
	islamicCalculatorCO.setTrspayplandetVOList(new ArrayList<TrspayplandetCO>());
	for(int i = 0; i < planArrayList.size(); i++)
	{
	    Date date = planArrayList.get(i);
	    // TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
	    TrspayplandetCO trspayplandetCO;
	    Long index = planMap.get(date);
	    trspayplandetCO = trspayplandetCOListTemp.get(index.intValue() - 1);
	    islamicCalculatorCO.getTrspayplandetVOList().add(trspayplandetCO);
	}
	if(!"I".equals(islamicCalculatorCO.getTrspayplandetVOList()
		.get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1).getPAYMENT_TYPE()))
	{
	    islamicCalculatorCO.getTrspayplandetVOList().get(islamicCalculatorCO.getTrspayplandetVOList().size() - 1)
		    .setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT);
	}
    }

    private void getPayProfitAndChargesOnly(IslamicCalculatorCO islamicCalculatorCO)
    {
	// Q = Profit + Charges
	boolean payTypePrincipal = false;
	boolean payTypeProfitCharge = false;
	for(TrspayplanCriteriaCO trsPayPlanCriteriaVO : islamicCalculatorCO.getTrsPayPlanCriteriaVO())
	{

	    if(IISCommonConstants.PAYMENT_TYPE_PROFIT_CHARGES.equals(trsPayPlanCriteriaVO.getPAYMENT_TYPE()))
	    {
		payTypeProfitCharge = true;
	    }
	    else
	    {
		payTypePrincipal = true;
	    }
	}
	if(payTypePrincipal)
	{
	    islamicCalculatorCO.setPayProfitAndChargesOnly(ConstantsCommon.NO);
	    if(payTypeProfitCharge)
	    {
		int index = 0;
		for(TrspayplanCriteriaCO trsPayPlanCriteriaVO : islamicCalculatorCO.getTrsPayPlanCriteriaVO())
		{
		    if(IISCommonConstants.PAYMENT_TYPE_PROFIT_CHARGES.equals(trsPayPlanCriteriaVO.getPAYMENT_TYPE()))
		    {
			islamicCalculatorCO.getTrsPayPlanCriteriaVO().get(index)
				.setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_SETTLE_PROFIT);// profit
			// only
		    }
		    index++;
		}
	    }
	}
	else if(payTypeProfitCharge)
	{
	    islamicCalculatorCO.setPayProfitAndChargesOnly(ConstantsCommon.YES);
	}
    }

    private IslamicCalculatorCO setPlandetailsBasedOnNoPayments(IslamicCalculatorCO islamicCalculatorCO)
	    throws BaseException
    {
	// create plan based on the number of payment
	Date nextDate = islamicCalculatorCO.getFirstPaymentDate();
	Date prevDate = islamicCalculatorCO.getFirstPaymentDate();

	// log.error("REPAYMENT PLAN SCHEDULE<MANOJ> : First Payment Date :- " +
	// nextDate.toString());
	String hijiriDate = null;
	if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
	{
	    hijiriDate = hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(), nextDate);
	    islamicCalculatorCO.setHijriDate(hijiriDate);
	}
	if(IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())
		&& IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			.equals(islamicCalculatorCO.getProfitCalculationMethod()))
	{
	    // TP#203228; Ramesh; Date 21/07/2014 [commented below code]
	    // if(!islamicCalculatorCO.getPaymentPeriodicity().equals("M"))
	    // {
	    // throw new
	    // BOException(MessageCodes.COMPNDING_DURING_DEAL_PERIOD_VALIDATION);
	    // }
	    nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(),
		    islamicCalculatorCO.getValueDate(), islamicCalculatorCO.getPaymentPeriodicity(),
		    islamicCalculatorCO.getPaymentPeriodicityNo(), 1L,
		    islamicCalculatorCO.getPaymentPeriodicityMonthPos(), null, "P");
	    hijiriDate = islamicCalculatorCO.getHijriDate();
	    prevDate = nextDate;
	}
	else if(IISCommonConstants.COMPOUND_PROFIT_BOTH.equals(islamicCalculatorCO.getCompoundingProfit())
		&& IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
			.equals(islamicCalculatorCO.getProfitCalculationMethod()))
	{
	    islamicCalculatorCO.setIgoreIfStatement(0);
	    /*
	     * nextDate =
	     * getNextValueDate(islamicCalculatorCO.getFirstPaymentDate(),
	     * islamicCalculatorCO .getInstallmentCommentsDate(),
	     * islamicCalculatorCO.getPaymentPeriodicity(), islamicCalculatorCO
	     * .getPaymentPeriodicityNo().longValue(), 1L,
	     * islamicCalculatorCO.getPaymentPeriodicityMonthPos(), null, "P");
	     * prevDate = nextDate;
	     */
	}
	else if(IISCommonConstants.COMPOUND_PROFIT_DEAL.equals(islamicCalculatorCO.getCompoundingProfit())
		&& IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
			.equals(islamicCalculatorCO.getProfitCalculationMethod()))
	{
	    if(islamicCalculatorCO.getFirstPaymentDate().equals(islamicCalculatorCO.getValueDate()))
	    {
		nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(),
			islamicCalculatorCO.getValueDate(), islamicCalculatorCO.getPaymentPeriodicity(),
			islamicCalculatorCO.getPaymentPeriodicityNo(), 1L,
			islamicCalculatorCO.getPaymentPeriodicityMonthPos(), null, "P");
		hijiriDate = islamicCalculatorCO.getHijriDate();
	    }
	    prevDate = nextDate;
	}
	Long lineNo = 0L;

	Map<Date, Long> planMap = new HashMap<Date, Long>();
	ArrayList<Date> planArrayList = new ArrayList<Date>();
	List<TrspayplandetCO> trspayplandetCOListTemp = new ArrayList<TrspayplandetCO>();

	for(int i = 0; i < islamicCalculatorCO.getNoOfPayments().longValue(); i++)
	{
	    TrspayplandetCO trspayplandetCO = new TrspayplandetCO();
	    lineNo++;
	    if((i == islamicCalculatorCO.getNoOfPayments().intValue() - 1)
		    && (!nextDate.equals(islamicCalculatorCO.getMaturityDate())))
	    {
		// if it is the last payment

		islamicCalculatorCO.setLastInstallmentOnMaturityDate(ConstantsCommon.NO);
		nextDate = islamicCalculatorCO.getMaturityDate();
		if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
		{
		    hijiriDate = hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(),
			    nextDate);
		    islamicCalculatorCO.setHijriDate(hijiriDate);
		}
	    }

	    prevDate = nextDate;
	    trspayplandetCO.setLINE_NBR(BigDecimal.valueOf(lineNo));
	    trspayplandetCO.setVALUE_DATE(nextDate);
	    trspayplandetCO.setVALUE_DATE_HIJRI(hijiriDate);

	    trspayplandetCO.setDEAL_VALUE_DATE(islamicCalculatorCO.getValueDate());

	    trspayplandetCO.setACC_CY(islamicCalculatorCO.getDealCurrency());
	    trspayplandetCO.setCOVERING_ACC_CY(islamicCalculatorCO.getDealCurrency());
	    if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		    .equals(islamicCalculatorCO.getProfitCalculationMethod())
		    && ConstantsCommon.YES.equals(islamicCalculatorCO.getPrincipalInLastPayment()))
	    {
		trspayplandetCO.setUserDefined(ConstantsCommon.NO);
		trspayplandetCO.setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_SETTLE_PROFIT);
	    }
	    else if(NumberUtil.toDoubleObj(islamicCalculatorCO.getAmountPerPayment()) > 0D)
	    {
		trspayplandetCO.setAMOUNT(islamicCalculatorCO.getAmountPerPayment());
		trspayplandetCO.setUSER_DEFINED_AMOUNT(islamicCalculatorCO.getAmountPerPayment());
		trspayplandetCO.setUserDefined(ConstantsCommon.YES);
		// trspayplandetCO.setPAYMENT_TYPE("S");
		trspayplandetCO.setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT);
	    }
	    else
	    {
		trspayplandetCO.setUserDefined(ConstantsCommon.NO);
		trspayplandetCO.setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT);
	    }

	    if(islamicCalculatorCO.getNoOfPayments() != null
		    && BigDecimal.valueOf(lineNo).equals(islamicCalculatorCO.getNoOfPayments()))
	    {
		trspayplandetCO.setVALUE_DATE(islamicCalculatorCO.getMaturityDate());
	    }

	    trspayplandetCO.setBALLOON_PAYMENT(BigDecimal.valueOf(0L));
	    trspayplandetCO.setNormalInstallment(ConstantsCommon.YES);

	    /**
	     * set Maturity account
	     */

	    trspayplandetCO.setACC_BR(islamicCalculatorCO.getTRSDET_MATR_AC_BR());
	    trspayplandetCO.setACC_CY(islamicCalculatorCO.getTRSDET_MATR_AC_CY());
	    trspayplandetCO.setACC_GL(islamicCalculatorCO.getTRSDET_MATR_AC_GL());
	    trspayplandetCO.setACC_CIF(islamicCalculatorCO.getTRSDET_MATR_AC_CIF());
	    trspayplandetCO.setACC_SL(islamicCalculatorCO.getTRSDET_MATR_AC_SL());
	    trspayplandetCO.setACC_NAME(islamicCalculatorCO.getTRSDET_MATR_AC_BRIEF_NAME_ENG());
	    trspayplandetCO.setAUTO_CREATE_SETTLEMENT(islamicCalculatorCO.getAUTO_CREATE_SETTLEMENT());

	    // ICD170039 START
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCalledFromIPRSYN()))
	    {
		trspayplandetCO.setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_SETTLE_PROFIT);
	    }
	    // ICD170039 END
	    trspayplandetCOListTemp.add(trspayplandetCO);
	    planMap.put(nextDate, lineNo);
	    planArrayList.add(nextDate);

	    nextDate = getNextValueDate(islamicCalculatorCO, islamicCalculatorCO.getFirstPaymentDate(), nextDate,
		    islamicCalculatorCO.getPaymentPeriodicity(), islamicCalculatorCO.getPaymentPeriodicityNo(), lineNo,
		    islamicCalculatorCO.getPaymentPeriodicityMonthPos(), null, "P");
	    hijiriDate = islamicCalculatorCO.getHijriDate();
	    if(nextDate.after(islamicCalculatorCO.getMaturityDate()))
	    {
		if(prevDate.before(islamicCalculatorCO.getMaturityDate()))
		{
		    nextDate = islamicCalculatorCO.getMaturityDate();
		    islamicCalculatorCO.setLastInstallmentOnMaturityDate(ConstantsCommon.NO);
		    if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
		    {
			hijiriDate = hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(),
				nextDate);
			islamicCalculatorCO.setHijriDate(hijiriDate);
		    }
		}
		else
		{
		    break;
		}
	    }
	}
	if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		.equals(islamicCalculatorCO.getProfitCalculationMethod())
		&& ConstantsCommon.YES.equals(islamicCalculatorCO.getPrincipalInLastPayment()))
	{
	    trspayplandetCOListTemp.get(trspayplandetCOListTemp.size() - 1).setUserDefined(ConstantsCommon.NO);
	    trspayplandetCOListTemp.get(trspayplandetCOListTemp.size() - 1)
		    .setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT);
	}

	// IF BALLON PAYMENT EXIST THEN INSERT THOSE LINE ALSO IN TO THE PALN
	// LIST
	insertBaloonPaymentDet(islamicCalculatorCO, planMap, planArrayList, trspayplandetCOListTemp, lineNo);
	return islamicCalculatorCO;
    }

    private void insertBaloonPaymentDet(IslamicCalculatorCO islamicCalculatorCO, Map<Date, Long> planMap,
	    ArrayList<Date> planArrayList, List<TrspayplandetCO> trspayplandetCOListTemp, Long lineNoParam)
	    throws BaseException
    {
	Long lineNo = lineNoParam;
	for(TrsPlanBallonPaymentCO trsPlanBallonPaymentCO : islamicCalculatorCO.getTrsPlanBallonPaymentCO())
	{
	    Date nextDate = trsPlanBallonPaymentCO.getBalloonDate();
	    if(nextDate.before(islamicCalculatorCO.getValueDate()))
	    {
		continue;
	    }
	    String hijiriDate = null;
	    if(IISCommonConstants.CALENDAR_TYPE_HIJRI_H.equals(islamicCalculatorCO.getCalendarType()))
	    {
		hijiriDate = hijiriCalendarBO.getHijiriDateForGregorian(islamicCalculatorCO.getCompanyCode(), nextDate);
		islamicCalculatorCO.setHijriDate(hijiriDate);
	    }
	    Long planExist = planMap.get(nextDate);
	    if(planExist == null)
	    {
		lineNo++;
		TrspayplandetCO trsPayplanDetCO = new TrspayplandetCO();
		trsPayplanDetCO.setLINE_NBR(BigDecimal.valueOf(lineNo));
		trsPayplanDetCO.setVALUE_DATE(nextDate);
		trsPayplanDetCO.setVALUE_DATE_HIJRI(hijiriDate);
		trsPayplanDetCO.setPAYMENT_TYPE(IISCommonConstants.PAYMENT_TYPE_SETTLE_PRINCIPAL_PROFIT);
		trsPayplanDetCO.setDEAL_VALUE_DATE(nextDate);
		trsPayplanDetCO.setUserDefined(ConstantsCommon.NO);
		trsPayplanDetCO.setACC_CY(islamicCalculatorCO.getDealCurrency());
		trsPayplanDetCO.setCOVERING_ACC_CY(islamicCalculatorCO.getDealCurrency());
		trsPayplanDetCO.setBALLOON_AMOUNT(trsPlanBallonPaymentCO.getBalloonAmount());
		trsPayplanDetCO.setBALLOON_PAYMENT(BigDecimal.valueOf(1L));
		trsPayplanDetCO.setNormalInstallment(ConstantsCommon.NO);

		/**
		 * set Maturity account
		 */

		trsPayplanDetCO.setACC_BR(islamicCalculatorCO.getTRSDET_MATR_AC_BR());
		trsPayplanDetCO.setACC_CY(islamicCalculatorCO.getTRSDET_MATR_AC_CY());
		trsPayplanDetCO.setACC_GL(islamicCalculatorCO.getTRSDET_MATR_AC_GL());
		trsPayplanDetCO.setACC_CIF(islamicCalculatorCO.getTRSDET_MATR_AC_CIF());
		trsPayplanDetCO.setACC_SL(islamicCalculatorCO.getTRSDET_MATR_AC_SL());
		trsPayplanDetCO.setACC_NAME(islamicCalculatorCO.getTRSDET_MATR_AC_BRIEF_NAME_ENG());
		trsPayplanDetCO.setAUTO_CREATE_SETTLEMENT(islamicCalculatorCO.getAUTO_CREATE_SETTLEMENT());

		trspayplandetCOListTemp.add(trsPayplanDetCO);
		planMap.put(nextDate, lineNo);
		planArrayList.add(nextDate);
	    }
	    else
	    {
		int index = planExist.intValue() - 1;
		trspayplandetCOListTemp.get(index).setBALLOON_AMOUNT(trsPlanBallonPaymentCO.getBalloonAmount());
		trspayplandetCOListTemp.get(index).setBALLOON_PAYMENT(BigDecimal.valueOf(1L));
	    }
	}
	// Need to sort the list again
	sortPayPlanDet(islamicCalculatorCO, planArrayList, planMap, trspayplandetCOListTemp);
	int noOfInstallment = islamicCalculatorCO.getTrspayplandetVOList().size();
	islamicCalculatorCO.setNoOfPayments(BigDecimal.valueOf(noOfInstallment));
    }

    private void calculateVatOninstallment(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	double vatAmount = 0d;
	double installmentAmount = 0d;
	double profitAmount = 0d;
	String proRateVatYn = ConstantsCommon.NO;
	double totalAllocatedVatAmount = 0d;
	double vatDiffAmount = 0d;
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment())
		&& ConstantsCommon.YES.equals(islamicCalculatorCO.getCalculateVatAfterSchedule()))
	{
	    for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	    {
		installmentAmount = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT());
		profitAmount = NumberUtil
			.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getPROFIT_AMT());

		vatAmount = calculateVatAmount(islamicCalculatorCO, installmentAmount, profitAmount, proRateVatYn);
		installmentAmount = installmentAmount + vatAmount;

		islamicCalculatorCO.getTrspayplandetVOList().get(i).setVAT_AMOUNT(
			NumberUtil.roundToBigDecimal(vatAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setVAT_PERCENTAGE(NumberUtil.roundToBigDecimal(
			islamicCalculatorCO.getVatPercentage(), islamicCalculatorCO.getDealCyDecimalPoint()));
		islamicCalculatorCO.getTrspayplandetVOList().get(i).setAMOUNT(
			NumberUtil.roundToBigDecimal(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
		totalAllocatedVatAmount = totalAllocatedVatAmount + vatAmount;
	    }
	}
	else
	{
	    totalAllocatedVatAmount = islamicCalculatorCO.getTotalAllocatedVatAmount();
	}
	if(NumberUtil.toDouble(islamicCalculatorCO.getTotalVatAmount()) > 0)
	{
	    vatDiffAmount = islamicCalculatorCO.getTotalVatAmount() - totalAllocatedVatAmount;
	    if(vatDiffAmount != 0)
	    {
		for(int i = islamicCalculatorCO.getTrspayplandetVOList().size() - 1; i >= 0; i--)
		{
		    vatAmount = NumberUtil
			    .toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVAT_AMOUNT());
		    if(vatAmount + vatDiffAmount > 0D)
		    {
			installmentAmount = NumberUtil
				.toDoubleObj(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT());
			vatAmount = NumberUtil.round(vatAmount + vatDiffAmount,
				islamicCalculatorCO.getDealCyDecimalPoint());
			installmentAmount = NumberUtil.round(installmentAmount + vatDiffAmount,
				islamicCalculatorCO.getDealCyDecimalPoint());
			islamicCalculatorCO.getTrspayplandetVOList().get(i).setVAT_AMOUNT(
				NumberUtil.roundToBigDecimal(vatAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
			islamicCalculatorCO.getTrspayplandetVOList().get(i).setAMOUNT(NumberUtil
				.roundToBigDecimal(installmentAmount, islamicCalculatorCO.getDealCyDecimalPoint()));
			vatDiffAmount = 0d;
			break;
		    }
		}
	    }
	}
    }

    /**
     * wf_get_annual_yield
     * 
     * @param islamicCalculatorCO
     */
    private void calculateAnnualYield(IslamicCalculatorCO islamicCalculatorCO)
    {

	if(!IISCommonConstants.CALCULATOR_TYPE_CALCULATOR.equals(islamicCalculatorCO.getCalculatorType()))
	{
	    return;
	}
	if(!IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		.equals(islamicCalculatorCO.getProfitCalculationMethod()))
	{
	    islamicCalculatorCO.setTotalFlatRate(BigDecimal.ZERO);
	    return;
	}

	if(NumberUtil.nullToZero(islamicCalculatorCO.getAnnualYeild()).compareTo(BigDecimal.ZERO) != 1
		&& NumberUtil.nullToZero(islamicCalculatorCO.getTotalFlatRate()).compareTo(BigDecimal.ZERO) == 1)
	{
	    long llDays = DateUtil.numberOfDays(islamicCalculatorCO.getValueDate(),
		    islamicCalculatorCO.getMaturityDate());
	    if(llDays <= 0)
	    {
		llDays = 1;
	    }
	    BigDecimal parDayYield = islamicCalculatorCO.getTotalFlatRate().divide(BigDecimal.valueOf(llDays), 12,
		    BigDecimal.ROUND_HALF_UP);
	    parDayYield = NumberUtil.roundToBigDecimal(parDayYield.multiply(BigDecimal.valueOf(365)), 8);
	    islamicCalculatorCO.setAnnualYeild(parDayYield);

	}

    }

    /**
     * get needed parameters from TRSCLASS and IISCTRL table and keep for
     * further calculation
     * 
     * @param islamicCalculatorCO
     * @return
     * @throws BaseException
     */
     
    private IslamicCalculatorCO setValues(IslamicCalculatorCO islamicCalculatorCOParam) throws BaseException
    {

	IslamicCalculatorCO islamicCalculatorCO = islamicCalculatorCOParam;
	// Initialize all the variables
	islamicCalculatorCO.setShowTegMessages(ConstantsCommon.NO);
	if(NumberUtil.nullToZero(islamicCalculatorCO.getTemplateCode()).compareTo(BigDecimal.ZERO) != 1
		&& (islamicCalculatorCO.getTrsPayPlanCriteriaVO() == null
			|| islamicCalculatorCO.getTrsPayPlanCriteriaVO().isEmpty()))
	{
	    if(NumberUtil.isEmptyDecimal(islamicCalculatorCO.getNoOfPayments()))
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] { "Invalid_number_of_Payment_key" },
			false);
	    }

	    if(islamicCalculatorCO.getPaymentPeriodicityNo() == null
		    || islamicCalculatorCO.getPaymentPeriodicityNo() <= 0)
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] { "Invalid_Payment_Period_Nbr" },
			false);
	    }

	    if(islamicCalculatorCO.getPaymentPeriodicity() == null)
	    {
		throw new BOException(MessageCodes.iis_invalid_code, new String[] { "Invalid_Payment_Period_Nbr" },
			false);
	    }

	}
	islamicCalculatorCO.setMultipleYieldEqualiseFromValueDate(ConstantsCommon.YES);

	if(islamicCalculatorCO.getLastInstAssetResidualYn() == null)
	{
	    islamicCalculatorCO.setLastInstAssetResidualYn(ConstantsCommon.NO);
	}
	// if(islamicCalculatorCO.getRedusingBalanceMethod() == null)
	// {
	// islamicCalculatorCO.setRedusingBalanceMethod(ConstantsCommon.NO);
	// }
	islamicCalculatorCO.setRedusingBalanceMethod(
		StringUtil.nullEmptyToValue(islamicCalculatorCO.getRedusingBalanceMethod(), ConstantsCommon.NO));

	if(islamicCalculatorCO.getPrincipalInLastPayment() == null)
	{
	    islamicCalculatorCO.setPrincipalInLastPayment(ConstantsCommon.NO);
	}
	if(islamicCalculatorCO.getEqualInstallmentForDisbursement() == null)
	{
	    islamicCalculatorCO.setEqualInstallmentForDisbursement(ConstantsCommon.NO);
	}
	if(islamicCalculatorCO.getSegmentAppliedYn() == null)
	{
	    islamicCalculatorCO.setSegmentAppliedYn(ConstantsCommon.NO);
	}
	if(islamicCalculatorCO.getEqualSegments() == null)
	{
	    islamicCalculatorCO.setEqualSegments(ConstantsCommon.NO);
	}
	if(islamicCalculatorCO.getIncludeVatInInstallment() == null)
	{
	    islamicCalculatorCO.setIncludeVatInInstallment(ConstantsCommon.NO);
	}
	if(islamicCalculatorCO.getVatPercentage() == null)
	{
	    islamicCalculatorCO.setVatPercentage(0D);
	}
	islamicCalculatorCO.setCalculateVatAfterSchedule(ConstantsCommon.YES);

	if(islamicCalculatorCO.getAssetResidualAmount() == null)
	{
	    islamicCalculatorCO.setAssetResidualAmount(BigDecimal.ZERO);
	}

	if(islamicCalculatorCO.getAssetResidualprofit() == null)
	{
	    islamicCalculatorCO.setAssetResidualprofit(BigDecimal.ZERO);
	}

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getIncludeVatInInstallment()))
	{
	    if(islamicCalculatorCO.getVatCode() == null || NumberUtil.toDouble(islamicCalculatorCO.getVatCode()) <= 0)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
	    }

//	    TRSVATVOKey trsVatkey = new TRSVATVOKey();
//	    trsVatkey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
//	    trsVatkey.setVAT_CODE(BigDecimal.valueOf(islamicCalculatorCO.getVatCode()));
//	    islamicCalculatorCO.setVatPercentageOn(iisIslamicCalculatorDAO.getVatPercentageInt(trsVatkey));
//	    trsVatkey = null;
	    
	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	    trsClassVOKey.setCODE(islamicCalculatorCO.getProductClassCode());
	    TRSCLASSVO trsClassVO = iisIslamicCalculatorDAO.getProductClassDetails(trsClassVOKey);
	    if(trsClassVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	    }
	    
	    islamicCalculatorCO.setVatPercentageOn(iisIslamicCalculatorDAO.getVatPercentageInt(trsClassVOKey));	    
	    
	    /*
	     * Removing this exception 091074: Include VAT in installment flag
	     * is not allowed to checked as per teh below scenario (Linchu)
	     * if(!islamicCalculatorCO.getVatPercentageOn().equals("P") &&
	     * !islamicCalculatorCO.getVatPercentageOn().equals("S")) { throw
	     * new BOException(MessageCodes.VAT_PERCENTAGE_ON_VALIDATION); }
	     */
	    if(islamicCalculatorCO.getVatPercentage() == null || islamicCalculatorCO.getVatPercentage() <= 0D)
	    {
		throw new BOException(MessageCodes.NULL_VAT_PERCENTAGE);
	    }
	    if((IISCommonConstants.PROFIT_DISTRIBUTION_METHOD_STRAIGHT_LINE
		    .equals(islamicCalculatorCO.getProfitRecognitionMethod())
		    || IISCommonConstants.PROFIT_DISTRIBUTION_METHOD_DIMINISHING_RETURNS
			    .equals(islamicCalculatorCO.getProfitRecognitionMethod()))
		    && ((islamicCalculatorCO.getTrsDealMultipleYieldVO() == null
			    || islamicCalculatorCO.getTrsDealMultipleYieldVO().size() <= 1))// Added
		    // null
		    // check
		    // by
		    // Linchu
		    // on
		    // 28-27-2013
		    && islamicCalculatorCO.getVatPercentageOn()
			    .equals(IISCommonConstants.VAT_PERCENTAGE_INDICATOR_PROFIT))
	    {
		islamicCalculatorCO.setCalculateVatAfterSchedule(ConstantsCommon.NO);
	    }
	    else
	    {
		islamicCalculatorCO.setCalculateVatAfterSchedule(ConstantsCommon.YES);
	    }
	}
	if(islamicCalculatorCO.getCompoudingGracePeriod() == null)
	{
	    islamicCalculatorCO.setCompoudingGracePeriod(ConstantsCommon.NO);
	}
	if(islamicCalculatorCO.getCompudingDealPeriod() == null)
	{
	    islamicCalculatorCO.setCompudingDealPeriod(ConstantsCommon.NO);
	}
	islamicCalculatorCO.setCompoundingProfit(ConstantsCommon.NO);
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCompoudingGracePeriod()))
	{
	    islamicCalculatorCO.setCompoundingProfit("G");
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCompudingDealPeriod()))
	    {
		islamicCalculatorCO.setCompoundingProfit("B");
	    }
	}
	else if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCompudingDealPeriod()))
	{
	    islamicCalculatorCO.setCompoundingProfit("D");
	}
	islamicCalculatorCO.setPayProfitAndChargesOnly(ConstantsCommon.NO);

	islamicCalculatorCO.setLastInstallmentOnMaturityDate(ConstantsCommon.YES);
	islamicCalculatorCO.setTotalGracePeriodCompundingProfit(BigDecimal.ZERO);
	islamicCalculatorCO.setNextProfitValueDate(islamicCalculatorCO.getValueDate());
	islamicCalculatorCO.setNextDisbursementDate(islamicCalculatorCO.getValueDate());

	if(islamicCalculatorCO.getTrspayplandetVOList() == null)
	{
	    List<TrspayplandetCO> trspayplandetCO = new ArrayList<TrspayplandetCO>();
	    islamicCalculatorCO.setTrspayplandetVOList(trspayplandetCO);
	}
	if(islamicCalculatorCO.getTrsDealMultipleYieldVO() == null)
	{
	    List<TRSDEAL_MULTIPLE_YIELDVO> trsDealMultipleYieldVO = new ArrayList<TRSDEAL_MULTIPLE_YIELDVO>();
	    islamicCalculatorCO.setTrsDealMultipleYieldVO(trsDealMultipleYieldVO);
	}
	if(islamicCalculatorCO.getTrsdealchargesVO() == null)
	{
	    List<TrsDealChargesCO> trsdealchargesVO = new ArrayList<TrsDealChargesCO>();
	    islamicCalculatorCO.setTrsdealchargesVO(trsdealchargesVO);
	}
	if(islamicCalculatorCO.getTrsPlanBallonPaymentCO() == null)
	{
	    List<TrsPlanBallonPaymentCO> trsPlanBallonPaymentCO = new ArrayList<TrsPlanBallonPaymentCO>();
	    islamicCalculatorCO.setTrsPlanBallonPaymentCO(trsPlanBallonPaymentCO);
	}
	if(islamicCalculatorCO.getTrsPayPlanSegmentStartDatesVO() == null)
	{
	    List<TRSPAYPLAN_SEGMENT_START_DATESVO> trsPayPlanSegmentStartDatesVO = new ArrayList<TRSPAYPLAN_SEGMENT_START_DATESVO>();
	    islamicCalculatorCO.setTrsPayPlanSegmentStartDatesVO(trsPayPlanSegmentStartDatesVO);
	}
	if(islamicCalculatorCO.getTrsPayPlanCriteriaVO() == null)
	{
	    List<TrspayplanCriteriaCO> trsPayPlanCriteriaVO = new ArrayList<TrspayplanCriteriaCO>();
	    islamicCalculatorCO.setTrsPayPlanCriteriaVO(trsPayPlanCriteriaVO);
	}

	if(islamicCalculatorCO.getTrsDealMultipleDisbursementList() == null)
	{
	    List<TRSDEAL3VO> trsDealMultipleDisbursementList = new ArrayList<TRSDEAL3VO>();
	    islamicCalculatorCO.setTrsDealMultipleDisbursementList(trsDealMultipleDisbursementList);
	}
	if(islamicCalculatorCO.getProductClassCode() == null)
	{
	    islamicCalculatorCO.setProductClassCode(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getDealNo() == null)
	{
	    islamicCalculatorCO.setDealNo(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getCalendarType() == null)
	{
	    islamicCalculatorCO.setCalendarType("G");
	}
	if(islamicCalculatorCO.getHolidayAction() == null)
	{
	    islamicCalculatorCO.setHolidayAction(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getChangeEffectLineNo() == null)
	{
	    islamicCalculatorCO.setChangeEffectLineNo(0);
	}
	if(islamicCalculatorCO.getTotalBalloonAmount() == null)
	{
	    islamicCalculatorCO.setTotalBalloonAmount(BigDecimal.ZERO);
	}
	if(islamicCalculatorCO.getProfitCalculateAsOnYieldDate() == null)
	{
	    islamicCalculatorCO.setProfitCalculateAsOnYieldDate(ConstantsCommon.NO);
	}
	if(islamicCalculatorCO.getDailyDepreciationYn() == null)
	{
	    islamicCalculatorCO.setDailyDepreciationYn(ConstantsCommon.NO);
	}
	if(islamicCalculatorCO.getTentativeSchedule() == null)
	{
	    islamicCalculatorCO.setTentativeSchedule(ConstantsCommon.NO);
	}

	/*
	 * if no multiple yield is not passed from the client, in case deal need
	 * to fetch same details from the TRSDEAL_MULTIPLE_YIELD for specific
	 * deal no
	 */
	if(islamicCalculatorCO.getTrsDealMultipleYieldVO().size() == 0
		&& islamicCalculatorCO.getDealNo().longValue() > 0)
	{

	    TRSDEAL_MULTIPLE_YIELDVOKey trsDealMultipleYieldVOKey = new TRSDEAL_MULTIPLE_YIELDVOKey();
	    trsDealMultipleYieldVOKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	    trsDealMultipleYieldVOKey.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
	    trsDealMultipleYieldVOKey.setDEAL_NO(islamicCalculatorCO.getDealNo());
		if(islamicCalculatorCO.getDisbursementScreen())
		{
	    	trsDealMultipleYieldVOKey.setDEAL_NO(islamicCalculatorCO.getLinkedDealNo());
		}
		
	    islamicCalculatorCO
		    .setTrsDealMultipleYieldVO(iisIslamicCalculatorDAO.getDealMultipleYield(trsDealMultipleYieldVOKey));
	    trsDealMultipleYieldVOKey = null;
	}
	if((islamicCalculatorCO.getAnnualYeild() == null
		|| islamicCalculatorCO.getAnnualYeild().compareTo(BigDecimal.ZERO) != 1)
		&& (islamicCalculatorCO.getTrsDealMultipleYieldVO() != null
			&& !islamicCalculatorCO.getTrsDealMultipleYieldVO().isEmpty()))
	{
	    islamicCalculatorCO.setAnnualYeild(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(0).getYIELD());
	}
	if(islamicCalculatorCO.getDisbursementScreen()
			&& islamicCalculatorCO.getTrsDealMultipleYieldVO() != null
			&& !islamicCalculatorCO.getTrsDealMultipleYieldVO().isEmpty())
	{
		getCurrentYield(islamicCalculatorCO);
	}
	/*
	 * calculate the charges/insurance amount which include in principal and
	 * profit calculation from TrsdealchargesVO list
	 */
	if(islamicCalculatorCO.getTotalCharges() == null
		|| islamicCalculatorCO.getTotalCharges().equals(BigDecimal.ZERO))
	{
	    islamicCalculatorCO = getChargeInsuranceAmount(islamicCalculatorCO);
	}

	islamicCalculatorCO.setMultipleYieldEqualiseFromValueDate(ConstantsCommon.NO);

	islamicCalculatorCO.setInstallmentCommentsDate(islamicCalculatorCO.getValueDate());

	// Get IIS control information
	IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();
	iisctrlvoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	iisctrlvoKey.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());

	IISCTRLVO iisCtrlVO = iisCommonBO.returnIISCTRL(iisctrlvoKey);
	;
	if(iisCtrlVO == null)
	{
	    throw new BOException(MessageCodes.MISSING_INVALID_CONTROL_RECORD);
	}
	islamicCalculatorCO.setIncludeInstallmentDateInProfitCalculation(iisCtrlVO.getINCLUDE_INST_DATE_IN_PRF_CALC());
	islamicCalculatorCO.setApplyRoundingFact_after_calc(iisCtrlVO.getAPPLY_ROUNDING_FACT_AFTER_CALC());
	islamicCalculatorCO.setAccruakBasisActualDaysYn(iisCtrlVO.getACCRUAL_BASIS_ACTUAL_DAYS_YN());
	islamicCalculatorCO.setInstAmtInBalloon(iisCtrlVO.getINST_AMT_IN_BALLOON());
	islamicCalculatorCO.setInstAmtInLastBalloon(iisCtrlVO.getINST_AMT_IN_LAST_BALLOON());
	islamicCalculatorCO.setExcessProfitInNextInstallment(iisCtrlVO.getEXCESS_PROFIT_IN_NEXT_INSTALL());
	islamicCalculatorCO.setLimit_reinstate_based_on(iisCtrlVO.getLIMIT_REINSTATE_BASED_ON());
	islamicCalculatorCO.setCalc_max_user_pft_sys_pft_diff(iisCtrlVO.getCALC_MAX_USER_PFT_SYS_PFT_DIFF());
	islamicCalculatorCO.setCalc_max_iter_getyield_frm_pft(iisCtrlVO.getCALC_MAX_ITER_GETYIELD_FRM_PFT());

	if((islamicCalculatorCO.getProductClassCode() != null)
		&& (NumberUtil.toDoubleObj(islamicCalculatorCO.getProductClassCode()) > 0))
	{
	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	    trsClassVOKey.setCODE(islamicCalculatorCO.getProductClassCode());
	    TRSCLASSVO trsClassVO = iisIslamicCalculatorDAO.getProductClassDetails(trsClassVOKey);
	    if(trsClassVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	    }
	    trsClassVOKey = null;
	    islamicCalculatorCO.setUpfrontProduct(trsClassVO.getPROFIT_UPFRONT());
	    islamicCalculatorCO.setCapitalizePeriodicity(trsClassVO.getCAPITALIZE_PAYM_PERIODICITY());
	    islamicCalculatorCO.setCapitalizePeriodicityNo(trsClassVO.getCAPITALIZE_PAYM_PERIOD_NBR().longValue());
	    islamicCalculatorCO.setCapitalizePeriodicityNopos(trsClassVO.getCAPITALIZE_PAYM_PERIOD_POS());
	    islamicCalculatorCO.setDailyDepreciationYn(trsClassVO.getDAILY_DEPRECIATION_YN());
	    islamicCalculatorCO.setMaxNoOfPayments(trsClassVO.getREPAYMENTS_MAX());
	    islamicCalculatorCO.setGrace_prd_cmpnd_pft_deal_yn(trsClassVO.getGRACE_PRD_CMPND_PFT_DEAL_YN());
	    islamicCalculatorCO.setMusawamah_yn(trsClassVO.getMUSAWAMAH_YN());
	    islamicCalculatorCO.setPRFT_ACCR_ON_OUTSTAND_PRINC_YN(trsClassVO.getPRFT_ACCR_ON_OUTSTAND_PRINC_YN());
	    islamicCalculatorCO.setROUNDING_TYPE_INST_AMT(trsClassVO.getROUNDING_TYPE_INST_AMT());
	    if(!ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	    {
		islamicCalculatorCO.setPft_calc_based_trade_cy_yn(ConstantsCommon.NO);
	    }
	    else
	    {
		islamicCalculatorCO.setPft_calc_based_trade_cy_yn(trsClassVO.getPFT_CALC_BASED_TRADE_CY_YN());
	    }
	    // #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015
	    islamicCalculatorCO.setAccrueAgencyFeeYn(trsClassVO.getACCRUE_AGENCY_FEE_YN());
	    if(islamicCalculatorCO.getProfitAccrualBasis() == null
		    || islamicCalculatorCO.getProfitAccrualBasis().compareTo(0L) != 1)
	    {
		islamicCalculatorCO.setProfitAccrualBasis(trsClassVO.getACCRUAL_BASIS().longValue());
	    }
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getTentativeSchedule())
		    && (islamicCalculatorCO.getTrsDealMultipleDisbursementList() == null
			    || islamicCalculatorCO.getTrsDealMultipleDisbursementList().size() == 0)
		    && ConstantsCommon.YES.equals(trsClassVO.getFINANCING_BASED_ON_PROJECT_AMT()))
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE,
			new String[] { "Enter_Project_Disbursement_Schedule_Details" }, false);

	    }
	    islamicCalculatorCO.setYieldRequiredYn(trsClassVO.getYIELD_REQUIRED());
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCalledFromFmsYN()))
	    {
		islamicCalculatorCO.setAPPLY_TEG_YN(trsClassVO.getAPPLY_TEG_YN());
		// islamicCalculatorCO.setHolidayAction(trsClassVO.getHOLIDAY_ACTION());
	    }
	    trsClassVO = null;

	    // SBI170077 -Round off by Product type and Price of Fixed Income
	    // Securities
	    TRSCLASS_EXTENDEDVOKey tExtendedvoKey = new TRSCLASS_EXTENDEDVOKey();
	    tExtendedvoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	    tExtendedvoKey.setCODE(islamicCalculatorCO.getProductClassCode());
	    TRSCLASS_EXTENDEDVO trsclassExtendedVO = (TRSCLASS_EXTENDEDVO) genericDAO.selectByPK(tExtendedvoKey);
	    if(trsclassExtendedVO != null)
	    {
		islamicCalculatorCO.setProfitAmountRoundingType(trsclassExtendedVO.getPROFIT_AMT_ROUNDING_TYPE());
		islamicCalculatorCO.setGovtPromotedProduct(
			(ConstantsCommon.YES.equals(trsclassExtendedVO.getGOVT_PROMOTED_PRODUCT_YN()) ? true : false));
	    }
	    trsclassExtendedVO = null;

	}

	// Get the currency informations like decimal point, PT method etc
	setCurrencyDetails(islamicCalculatorCO);

	if(islamicCalculatorCO.getUpfrontProduct() == null)
	{
	    islamicCalculatorCO.setUpfrontProduct(ConstantsCommon.NO);
	}
	if(ConstantsCommon.NO.equals(islamicCalculatorCO.getUpfrontProduct()))
	{
	    islamicCalculatorCO.setExcessProfitInNextInstallment(ConstantsCommon.YES);
	    islamicCalculatorCO.setApplyRoundingFact_after_calc(ConstantsCommon.NO);

	}
	if(islamicCalculatorCO.getRoundingFactor() == null)
	{
	    islamicCalculatorCO.setRoundingFactor(0L);
	}
	if(islamicCalculatorCO.getRoundingFactor() != 1L)
	{
	    islamicCalculatorCO.setApplyRoundingFact_after_calc(ConstantsCommon.NO);
	}

	if(NumberUtil.toInteger(islamicCalculatorCO.getProfitAccrualBasis()) == 5L)
	{
	    islamicCalculatorCO.setAvgDaysInYearsForProfitCalculation(BigDecimal.valueOf(getAverageYearDaysInDealPeriod(
		    islamicCalculatorCO.getValueDate(), islamicCalculatorCO.getMaturityDate())));
	}
	// check the annual yield is > maximum yield or < minimum yield
	islamicCalculatorCO.setAnnualYeild(BigDecimal.valueOf(
		getActualYrild(islamicCalculatorCO, NumberUtil.toDoubleObj(islamicCalculatorCO.getAnnualYeild()))));
	for(int i = 0; i < islamicCalculatorCO.getTrsDealMultipleYieldVO().size(); i++)
	{
	    double multipleYield = NumberUtil
		    .toDoubleObj(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i).getYIELD());
	    islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i)
		    .setYIELD(BigDecimal.valueOf(getActualYrild(islamicCalculatorCO, multipleYield)));
	}

	if(ConstantsCommon.NO.equals(islamicCalculatorCO.getExcessProfitInNextInstallment())
		|| ConstantsCommon.YES.equals(islamicCalculatorCO.getRedusingBalanceMethod())
		|| ConstantsCommon.YES.equals(islamicCalculatorCO.getPrincipalInLastPayment()))
	{
	    islamicCalculatorCO.setCalculateVatAfterSchedule(ConstantsCommon.YES);
	}
	return islamicCalculatorCO;
    }

    /**
     * SBI170077 -Round off by Product type and Price of Fixed Income Securities
     **/
    private void applyProfitAmountRounding(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	if(islamicCalculatorCO.getTrspayplandetVOList() != null
		&& islamicCalculatorCO.getTrspayplandetVOList().size() == 1
		&& ConstantsCommon.NO.equals(islamicCalculatorCO.getCompudingDealPeriod())
		&& ConstantsCommon.NO.equals(islamicCalculatorCO.getCompoudingGracePeriod())
		&& NumberUtil.emptyDecimalToZero(islamicCalculatorCO.getProfitAmountRoundingType())
			.compareTo(BigDecimal.ONE) == 0)
	{
	    for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
	    {
		BigDecimal profitBeforeRounding = NumberUtil.emptyDecimalToZero(trspayplandetCO.getPROFIT_AMT());
		BigDecimal profitAfterRounding = NumberUtil
			.roundToBigDecimal(NumberUtil.emptyDecimalToZero(trspayplandetCO.getPROFIT_AMT()), 0);
		trspayplandetCO.setPROFIT_AMT(profitAfterRounding);
		trspayplandetCO.setPROFIT_AMT_BEFORE_XIRR(profitAfterRounding);
		BigDecimal profitDifference = profitBeforeRounding.subtract(profitAfterRounding);
		trspayplandetCO.setAMOUNT(trspayplandetCO.getAMOUNT().subtract(profitDifference));
	    }
	}
    }

    private void setCurrencyDetails(IslamicCalculatorCO islamicCalculatorCO) throws DAOException, BaseException
    {
	CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	currenciesVOKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getPft_calc_based_trade_cy_yn()))
	{
	    if(NumberUtil.emptyDecimalToZero(islamicCalculatorCO.getTradeCurrency()).compareTo(BigDecimal.ZERO) == 0)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CURRENCY);
	    }
	    currenciesVOKey.setCURRENCY_CODE(islamicCalculatorCO.getTradeCurrency());
	}
	else
	{
	    if(NumberUtil.emptyDecimalToZero(islamicCalculatorCO.getDealCurrency()).compareTo(BigDecimal.ZERO) == 0)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CURRENCY);
	    }
	    currenciesVOKey.setCURRENCY_CODE(islamicCalculatorCO.getDealCurrency());
	}
	CURRENCIESVO currenciesVO = iisIslamicCalculatorDAO.getCurrencyBaseInfo(currenciesVOKey);
	currenciesVOKey = null;

	if(currenciesVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_DEAL_CURRENCY);
	}
	islamicCalculatorCO.setDealCyDecimalPoint(currenciesVO.getDECIMAL_POINTS().longValue());
	String PT_METHOD = currenciesVO.getPT_METHOD();
	BigDecimal IISCONTROL_SEQ_KEY_DEBIT_PT_METHOD = BigDecimal.valueOf(9);
	String DEBIT_PT_METHOD = iisCommonBO.returnIISCONTROLValyByKey(IISCONTROL_SEQ_KEY_DEBIT_PT_METHOD,
		"DEBIT_PT_METHOD");

	if(DEBIT_PT_METHOD != null && ConstantsCommon.YES.equals(DEBIT_PT_METHOD))
	{
	    PT_METHOD = currenciesVO.getORIGIN();
	}
	if(PT_METHOD == null || PT_METHOD.isEmpty())
	{
	    PT_METHOD = "1";
	}
	if("1".equals(PT_METHOD))
	{
	    islamicCalculatorCO.setDealCyPtMethod(365L);
	}
	else
	{
	    islamicCalculatorCO.setDealCyPtMethod(360L);
	}
	currenciesVO = null;
    }

    /**
     * To check the annual yield is less then minimum yield or greater than the
     * maximum yield if so the annual yield will be recalculate and return
     * 
     * @param islamicCalculatorCO
     * @param annualYield
     * @return new annual yield
     */
   	 private double getActualYrild(IslamicCalculatorCO islamicCalculatorCO, Double annualYieldParam)
    {
	Double annualYield = annualYieldParam;
	double minYield = NumberUtil.toDoubleObj(islamicCalculatorCO.getMinYeild());
	double maxYield = NumberUtil.toDoubleObj(islamicCalculatorCO.getMaxYeild());
	if(minYield > 0 && annualYield < minYield)
	{
	    annualYield = minYield;
	}

	if(maxYield > 0 && annualYield > maxYield)
	{
	    annualYield = maxYield;
	}
	return annualYield;
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

    private Double getAverageYearDaysInDealPeriod(Date dealValueDate, Date dealMatrutiyDate)
    {
	int fromYear = DateUtil.getDatePart("YYYY", dealValueDate).intValue();
	int toYear = DateUtil.getDatePart("YYYY", dealMatrutiyDate).intValue();

	Date fromYearBingin = createDate(fromYear, 1, 1);
	Date fromYearEnd = createDate(fromYear, 12, 31);
	Date toYearBigin = createDate(toYear, 1, 1);
	Date toYearEnd = createDate(toYear, 12, 31);

	long dealDaysInFirstYear = DateUtil.numberOfDays(dealValueDate, fromYearEnd) + 1L;
	long actualDaysInLastYear = DateUtil.numberOfDays(toYearBigin, toYearEnd) + 1L;
	long dealPeriodLastYear = DateUtil.numberOfDays(toYearBigin, dealMatrutiyDate);
	long actualDaysInFirstYear = DateUtil.numberOfDays(fromYearBingin, fromYearEnd) + 1L;
	toYearBigin = null;
	toYearEnd = null;

	double totalMonths = (((((double) dealDaysInFirstYear * actualDaysInLastYear)
		+ (dealPeriodLastYear * actualDaysInFirstYear)) / (actualDaysInLastYear * actualDaysInFirstYear))
		+ toYear - fromYear - 1);
	long totalDays = DateUtil.numberOfDays(dealValueDate, dealMatrutiyDate);
	double avgDays = 0;
	if(totalMonths != 0)
	{
	    avgDays = totalDays / totalMonths;
	}

	// double avgDays = totalDays / totalMonths;

	return avgDays;

    }

    private IslamicCalculatorCO getChargeInsuranceAmount(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	/*
	 * calculate the charges/insurance amount which include in principal and
	 * profit calculation from TrsdealchargesVO list
	 */
	BigDecimal profitOnCharges = BigDecimal.ZERO;
	BigDecimal profitOnInsurance = BigDecimal.ZERO;
	BigDecimal totalCharges = BigDecimal.ZERO;
	BigDecimal totalInsurance = BigDecimal.ZERO;

	if(islamicCalculatorCO.getTrsdealchargesVO().size() > 0)
	{
	    for(int i = 0; i < islamicCalculatorCO.getTrsdealchargesVO().size(); i++)
	    {
		BigDecimal chargeCode = islamicCalculatorCO.getTrsdealchargesVO().get(i).getCHARGES_CODE();
		BigDecimal chargeAmount = islamicCalculatorCO.getTrsdealchargesVO().get(i).getCHARGES_AMOUNT();
		String chargesIncPrincYn = islamicCalculatorCO.getTrsdealchargesVO().get(i).getCHARGE_TYPE();
		BigDecimal chargesIncProfitYn = NumberUtil
			.nullToZero(islamicCalculatorCO.getTrsdealchargesVO().get(i).getPROFIT_ON_CHARGES());
		String insuranceYn = ConstantsCommon.NO;

		/**
		 * Added on 12/06/2015 for AR-Rahnu calculator
		 */
		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getArRahnuCalculatorYN()))
		{
		    TRSCHARGESVOKey trschargesVoKey = new TRSCHARGESVOKey();
		    trschargesVoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
		    trschargesVoKey.setCODE(chargeCode);
		    TRSCHARGESVO trschargesVo = iisIslamicCalculatorDAO.getDealChargesInsuranceYn(trschargesVoKey);
		    trschargesVoKey = null;
		    insuranceYn = trschargesVo.getINSURANCE();

		    if(ConstantsCommon.YES.equals(insuranceYn))
		    {
			totalInsurance = totalInsurance.add(chargeAmount);
		    }
		    else
		    {
			totalCharges = totalCharges.add(chargeAmount);

		    }

		}
		else if(ConstantsCommon.YES.equals(chargesIncPrincYn))
		{
		    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
		    {
			String amountCalculationBasis = islamicCalculatorCO.getTrsdealchargesVO().get(i)
				.getAMOUNT_CALCULATION_BASIS();
			String amountCalculationMethod = islamicCalculatorCO.getTrsdealchargesVO().get(i)
				.getCHARGES_CALCULATION_METHOD();

			if(amountCalculationBasis != null && !("P".equals(amountCalculationBasis)
				|| ConstantsCommon.NO.equals(amountCalculationMethod)))
			{
			    continue;
			}
		    }

		    TRSCHARGESVOKey trschargesVoKey = new TRSCHARGESVOKey();
		    trschargesVoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
		    trschargesVoKey.setCODE(chargeCode);
		    TRSCHARGESVO trschargesVo = iisIslamicCalculatorDAO.getDealChargesInsuranceYn(trschargesVoKey);
		    trschargesVoKey = null;
		    insuranceYn = trschargesVo.getINSURANCE();

		    if(ConstantsCommon.YES.equals(insuranceYn))
		    {
			totalInsurance = totalInsurance.add(chargeAmount);
			if(chargesIncProfitYn.compareTo(BigDecimal.ONE) == 0)
			{
			    profitOnInsurance = profitOnInsurance.add(chargeAmount);
			}
		    }
		    else
		    {
			totalCharges = totalCharges.add(chargeAmount);
			if(chargesIncProfitYn.compareTo(BigDecimal.ONE) == 0)
			{
			    profitOnCharges = profitOnCharges.add(chargeAmount);
			}
		    }
		}
	    }
	}
	if(profitOnCharges == null)
	{
	    profitOnCharges = BigDecimal.ZERO;
	}
	if(profitOnInsurance == null)
	{
	    profitOnInsurance = BigDecimal.ZERO;
	}
	if(totalCharges == null)
	{
	    totalCharges = BigDecimal.ZERO;
	}
	if(totalInsurance == null)
	{
	    totalInsurance = BigDecimal.ZERO;
	}
	// if(ConstantsCommon.YES.equals(islamicCalculatorCO.getBillsCalculatorYn()))
	// {
	// profitOnCharges = BigDecimal.ZERO;
	// profitOnInsurance = BigDecimal.ZERO;
	// }
	islamicCalculatorCO.setProfitOnCharges(profitOnCharges);
	islamicCalculatorCO.setProfitOnInsurance(profitOnInsurance);
	islamicCalculatorCO.setTotalCharges(totalCharges);
	islamicCalculatorCO.setTotalInsurance(totalInsurance);
	return islamicCalculatorCO;
    }

    private String getHijiriDate(IslamicCalculatorCO islamicCalculatorCO, Date date) throws BaseException
    {
	TRSHIJRI_DETAIL_CALENDARVO hijriDetailCalendarVO = new TRSHIJRI_DETAIL_CALENDARVO();
	hijriDetailCalendarVO.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	hijriDetailCalendarVO.setGREGORIAN_DATE(date);
	hijriDetailCalendarVO = iisIslamicCalculatorDAO.getHijiriDate(hijriDetailCalendarVO);
	if(hijriDetailCalendarVO == null)
	{
	    throw new BOException(MessageCodes.HIJIRI_CALANDER);
	}
	String hijiriDay = NumberUtil.addLeadingZeros(hijriDetailCalendarVO.getHIJRI_DAY().longValue(), 2);
	String hijiriMonth = NumberUtil.addLeadingZeros(hijriDetailCalendarVO.getHIJRI_MONTH().longValue(), 2);
	String hijiriYear = NumberUtil.addLeadingZeros(hijriDetailCalendarVO.getHIJRI_YEAR().longValue(), 2);
	hijriDetailCalendarVO = null;
	return hijiriDay + "/" + hijiriMonth + "/" + hijiriYear;
    }

    private void reSetPlanHolidayDates(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	if(islamicCalculatorCO.getHolidayAction() == null
		|| NumberUtil.toDouble(islamicCalculatorCO.getHolidayAction()) == 0)
	{
	    return;
	}
	// List<TRSDEAL_COUNTRY_HOLIDAYVO> trsdealCountryHolidayList = new
	// ArrayList<TRSDEAL_COUNTRY_HOLIDAYVO>();

	TRSDEAL_COUNTRY_HOLIDAYVOKey trsdealCountryHolidayCriteria = new TRSDEAL_COUNTRY_HOLIDAYVOKey();
	trsdealCountryHolidayCriteria.setSERIAL_NO(islamicCalculatorCO.getDealNo());
	trsdealCountryHolidayCriteria.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	trsdealCountryHolidayCriteria.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
	// trsdealCountryHolidayList =
	// iisIslamicCalculatorDAO.getTrsdealCountryHolidayList(trsdealCountryHolidayCriteria);

	IISHolidayCheckCO iisHolidayCheckCO = new IISHolidayCheckCO();
	iisHolidayCheckCO.setHolidayMessageAction(ConstantsCommon.NO);
	iisHolidayCheckCO.setCompCode(islamicCalculatorCO.getCompanyCode());
	iisHolidayCheckCO.setBranchCode(islamicCalculatorCO.getBranchCode());
	iisHolidayCheckCO.setActionCode(islamicCalculatorCO.getHolidayAction());
	iisHolidayCheckCO.setCurrencyCode(islamicCalculatorCO.getDealCurrency());
	iisHolidayCheckCO.setDateType("P");
	PTH_CTRLVO ctrlvo = commonLibBO.returnPthCtrl();

	iisHolidayCheckCO
		.setApplyYearHoliday(ctrlvo.getAPPLY_YR_HOL() == null ? ConstantsCommon.NO : ctrlvo.getAPPLY_YR_HOL());
	for(int i = 0; i < islamicCalculatorCO.getTrspayplandetVOList().size(); i++)
	{
	    if((islamicCalculatorCO.getHolidayAction().intValue() == 1
		    || islamicCalculatorCO.getHolidayAction().intValue() == 2
		    || islamicCalculatorCO.getHolidayAction().intValue() == 5
		    || NumberUtil.toDouble(islamicCalculatorCO.getTrspayplandetVOList().get(i).getAMOUNT()) > 0)
		    && islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE()
			    .before(islamicCalculatorCO.getMaturityDate())
			&& !ConstantsCommon.YES.equals(islamicCalculatorCO.getTrspayplandetVOList().get(i).getExcludeRescheduleYn()))
	    {

		iisHolidayCheckCO.setHolidayYn(ConstantsCommon.NO);

		iisHolidayCheckCO.setDate(islamicCalculatorCO.getTrspayplandetVOList().get(i).getVALUE_DATE());
		iisHolidayCheckCO = iisCommonBO.checkCurrencyAndCountryHoliday(iisHolidayCheckCO);
		Date newDate = iisHolidayCheckCO.getNewDate();
		if(ConstantsCommon.YES.equals(iisHolidayCheckCO.getHolidayYn())
			&& !newDate.after(islamicCalculatorCO.getMaturityDate())
			&& !newDate.before(islamicCalculatorCO.getValueDate()))
		{
		    islamicCalculatorCO.getTrspayplandetVOList().get(i).setVALUE_DATE(newDate);
		}
	    }
	}
	// trsdealCountryHolidayList = null;
    }

    private void setHijiriDate(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	for(int index = 0; index < islamicCalculatorCO.getTrspayplandetVOList().size(); index++)
	{
	    islamicCalculatorCO.getTrspayplandetVOList().get(index).setVALUE_DATE_HIJRI(getHijiriDate(
		    islamicCalculatorCO, islamicCalculatorCO.getTrspayplandetVOList().get(index).getVALUE_DATE()));
	}
    }

    @Override
    public IslamicCalculatorCO checkHolidayActionForSchedule(IslamicCalculatorCO islamicCalculatorCO)
	    throws BaseException
    {
	islamicCalculatorCO.setHolidayActionConformationYn(ConstantsCommon.NO);
	if(islamicCalculatorCO.getHolidayAction() == null)
	{
	    if(islamicCalculatorCO.getProductClassCode() == null)
	    {
		return islamicCalculatorCO;
	    }
	    TRSCLASSVOKey trsClassKey = new TRSCLASSVOKey();
	    trsClassKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	    trsClassKey.setCODE(islamicCalculatorCO.getProductClassCode());
	    TRSCLASSVO trsClassVO = new TRSCLASSVO();
	    trsClassVO = iisIslamicCalculatorDAO.getHolidayActions(trsClassKey);
	    islamicCalculatorCO.setHolidayAction(trsClassVO.getHOLIDAY_ACTION());
	    islamicCalculatorCO.setHolidayActionConformationYn(trsClassVO.getHOLIDAY_ACTION_WARNING_IND());
	    trsClassKey = null;
	    trsClassVO = null;
	}

	if(islamicCalculatorCO.getHolidayAction() == null)
	{
	    islamicCalculatorCO.setHolidayAction(BigDecimal.ZERO);
	}

	if(NumberUtil.toDouble(islamicCalculatorCO.getHolidayAction()) == 0)
	{
	    return islamicCalculatorCO;
	}

	TRSCLASSVOKey trsClassKey = new TRSCLASSVOKey();
	TRSCLASSVO trsClassVO = new TRSCLASSVO();

	trsClassVO = iisIslamicCalculatorDAO.getHolidayActions(trsClassKey);
	islamicCalculatorCO.setHolidayActionConformationYn(trsClassVO.getHOLIDAY_ACTION_WARNING_IND());
	trsClassKey = null;
	trsClassVO = null;
	return islamicCalculatorCO;
    }

    /****
     * Method to place decimal format for rendering in the schedule list grid.
     * 
     * @param trspayplandetVOList
     * @param islamicCalculatorCO
     * @throws BaseException
     */
    private void setScheduleFormat(List<TrspayplandetCO> trspayplandetVOList, IslamicCalculatorCO islamicCalculatorCO)
	    throws BaseException
    {
	CURRENCIESVO currenciesVO = new CURRENCIESVO();
	currenciesVO.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	currenciesVO.setCURRENCY_CODE(islamicCalculatorCO.getDealCurrency() == null
		? islamicCalculatorCO.getBaseCurrencyCode() : islamicCalculatorCO.getDealCurrency());
	CURRENCIESVO currencyVO = commonLibBO.returnCurrency(currenciesVO);
	for(TrspayplandetCO trspayplandetCO : trspayplandetVOList)
	{
	    trspayplandetCO.setScheduleAmtFormat(
		    currencyVO.getDECIMAL_POINTS() == null ? BigDecimal.valueOf(2) : currencyVO.getDECIMAL_POINTS());
	    trspayplandetCO.setConstantRorFormat(BigDecimal.valueOf(6));
	    trspayplandetCO.setCC_BALLOON_PAYMENT(
		    NumberUtil.nullToZero(trspayplandetCO.getBALLOON_PAYMENT()).compareTo(BigDecimal.ZERO) == 0 ? true
			    : false);
	    trspayplandetCO.setSTATUS("A");

	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getSegmentAppliedYn())
		    && islamicCalculatorCO.getTrsPayPlanSegmentStartDatesVO().isEmpty())
	    {
		trspayplandetCO.setSEGMENT_START_YN(ConstantsCommon.YES);
	    }

	}
    }

    public double round(double val, long periods)
    {
	// BigDecimal bd = BigDecimal.valueOf(val);
	BigDecimal bd;
	bd = NumberUtil.roundToBigDecimal(val, periods);
	return bd.doubleValue();

    }

    @Override
    public Double getProfitAmount(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	Date dateFrom = islamicCalculatorCO.getValueDate();
	Date dateTo = islamicCalculatorCO.getMaturityDate();
	double amount = islamicCalculatorCO.getDealAmount().doubleValue();
	double planChargesAmount = NumberUtil.nullToZero(islamicCalculatorCO.getPlanChargesAmount()).doubleValue();
	double planChargesAmountProfit = NumberUtil.nullToZero(islamicCalculatorCO.getPlanChargesAmountForPrfotCalc())
		.doubleValue();
	long adjustDays = 0;
	double yeildPercent = NumberUtil.nullToZero(islamicCalculatorCO.getAnnualYeild().doubleValue());
	String capitalize = ConstantsCommon.NO;
	amount = amount + planChargesAmount;
	Double chargesAndInsuranceExcludingProfitCals = planChargesAmount - planChargesAmountProfit;
	setCurrencyDetails(islamicCalculatorCO);
	if(NumberUtil.toInteger(islamicCalculatorCO.getProfitAccrualBasis()) == 5)
	{
	    // Accrual basis = Actual /actual
	    islamicCalculatorCO.setAvgDaysInYearsForProfitCalculation(BigDecimal.valueOf(getAverageYearDaysInDealPeriod(
		    islamicCalculatorCO.getValueDate(), islamicCalculatorCO.getMaturityDate())));
	}

	return calculateProfitAmount(islamicCalculatorCO, dateFrom, dateTo, amount, adjustDays,
		chargesAndInsuranceExcludingProfitCals, yeildPercent, capitalize);
    }

    @Override
    public void validateBalloonDetails(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	if(NumberUtil.toDouble(islamicCalculatorCO.getBalloonPayment()) > 0
		&& (NumberUtil.toInt(islamicCalculatorCO.getNoOfBaloonPayments()) <= 0
			|| NumberUtil.toDouble(islamicCalculatorCO.getTotalBalloonAmount()) <= 0))
	{
	    // TP#250775;Arun.R.Variyath;17/12/2014
	    throw new BOException(MessageCodes.INVALID_BALLOON_DETAILS);
	}
	List<TrsPlanBallonPaymentCO> listBallonPaymentCOs = islamicCalculatorCO.getTrsPlanBallonPaymentCO();
	if(listBallonPaymentCOs == null || listBallonPaymentCOs.isEmpty())
	{
	    return;
	}
	double sumOfBalloonAmount = 0d;
	for(TrsPlanBallonPaymentCO eachBallonPaymentCO : listBallonPaymentCOs)
	{
	    if(eachBallonPaymentCO.getBalloonDate() == null)
	    {
		throw new BOException(MessageCodes.INVALID_BALLOON_DATE);
	    }
	    if(NumberUtil.toDouble(eachBallonPaymentCO.getBalloonAmount()) <= 0)
	    {
		throw new BOException(MessageCodes.BALLOON_AMOUNT_CANNOT_BE_LESS_THAN_ZERO);
	    }
	    // if(eachBallonPaymentCO.getBalloonDate() == null)
	    // {
	    //
	    // }
	    sumOfBalloonAmount = sumOfBalloonAmount + NumberUtil.toDouble(eachBallonPaymentCO.getBalloonAmount());
	}
	if(sumOfBalloonAmount > NumberUtil.toDouble(islamicCalculatorCO.getTotalBalloonAmount()))
	{
	    throw new BOException(MessageCodes.AMOUNT_EXCEEDS_TOTAL_BALLOON_AMT);
	}

    }

    /**
     * of_adjust_settled
     * 
     * @throws BaseException
     */
    // method call is commented in same file. due to jenkins un used private
    // method we commented this.
   
    private void calulateAdjustSettledAmount(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getDisburs_maintain_indiv_plan_yn()))
	{
	    return;
	}
	
	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getEXCLUDE_PASTDUE_AT_RESCHDL_YN()))
	{
	    return;
	}

	if(ConstantsCommon.NO.equals(islamicCalculatorCO.getRevaluationProcess())
		&& IISCommonConstants.RESCHEDULE_YES.equals(islamicCalculatorCO.getRescheduleYn())
		&& IISCommonConstants.RESCHEDULE_TYPE_RECALCULATE.equals(islamicCalculatorCO.getRescheduleType())
		&& ConstantsCommon.YES.equals(islamicCalculatorCO.getEXCL_PRFT_RECLC_DUE_INST_YN()))

	{
	    calulateAdjustSettledAmountNoRecalculate(islamicCalculatorCO);
	    return;
	}

	TRSPAYPLANDETVOKey trspayplandetvoKey = new TRSPAYPLANDETVOKey();
	trspayplandetvoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	trspayplandetvoKey.setBRANCH(islamicCalculatorCO.getBranchCode());
	trspayplandetvoKey.setPLAN_NBR(islamicCalculatorCO.getPlanNbr());
	trspayplandetvoKey.setPLAN_SEQ(islamicCalculatorCO.getPlanSeq());
	BigDecimal dealNo = islamicCalculatorCO.getDealNo();
	if(islamicCalculatorCO.getDisbursementScreen())
	{
	    trspayplandetvoKey.setPLAN_NBR(islamicCalculatorCO.getLinkedDealPlanNbr());
	    trspayplandetvoKey.setPLAN_SEQ(islamicCalculatorCO.getLinkedDealPlanSeq());
	    dealNo = islamicCalculatorCO.getLinkedDealNo();
	}

	if(trspayplandetvoKey.getPLAN_NBR() == null || trspayplandetvoKey.getPLAN_SEQ() == null)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Previous_Linked_Repayment_Plan_Cannot_Found_key" }, false);

	}

	if(ConstantsCommon.YES.equals(islamicCalculatorCO.getPRFT_ACCR_ON_OUTSTAND_PRINC_YN()))
	{
	    String considerSettlementYn = ConstantsCommon.YES;
	    if(IISCommonConstants.RESCHEDULE_YES.equals(islamicCalculatorCO.getRescheduleYn())
		    && IISCommonConstants.RESCHEDULE_TYPE_RECALCULATE.equals(islamicCalculatorCO.getRescheduleType())
		    && ConstantsCommon.NO.equals(islamicCalculatorCO.getRevaluationProcess()))
	    {
		considerSettlementYn = ConstantsCommon.YES;

	    }
	    else if(ConstantsCommon.YES.equals(islamicCalculatorCO.getRevaluationProcess()))
	    {
		if(ConstantsCommon.YES.equals(islamicCalculatorCO.getRescheduleForLateSettlementYn()))
		{
		    considerSettlementYn = ConstantsCommon.YES;
		}
		else
		{
		    considerSettlementYn = ConstantsCommon.NO;
		}
	    }
	    else if(islamicCalculatorCO.getDisbursementScreen())
	    {
		considerSettlementYn = ConstantsCommon.NO;
	    }

	    calulateAdjustSettledAmountNoProfitAccrualOuststandCapital(islamicCalculatorCO, trspayplandetvoKey, dealNo,
		    considerSettlementYn);
	    return;
	}

	List<TRSPAYPLANDETVO> trspayplandetvoList;
	if(islamicCalculatorCO.getDisbursementScreen()
		&& IISCommonConstants.RESCHEDULE_YES.equals(islamicCalculatorCO.getRevaluationProcess()))
	{

	    trspayplandetvoList = iisIslamicCalculatorDAO.returnDisbursePlanScheduleList(trspayplandetvoKey);
	}
	else
	{

	    trspayplandetvoList = iisIslamicCalculatorDAO.returnPlanScheduleList(trspayplandetvoKey);
	}

	if(trspayplandetvoList == null)
	{
	    return;
	}
	Date dealValueDate = islamicCalculatorCO.getValueDate();
	Date orgValueDate = islamicCalculatorCO.getOriginalValueDate();
	Date fromDate = orgValueDate;
	Date lineValueDate = dealValueDate;
	BigDecimal totalDealAmount = NumberUtil.nullToZero(islamicCalculatorCO.getOriginalDealAmount());
	// BigDecimal adjustProfit = BigDecimal.ZERO;

	// Date lastSettledDate =
	// iisIslamicCalculatorDAO.returnLastFullySettledInstllmentDate(trspayplanvoKey);
	// if(lastSettledDate == null)
	// {
	// lastSettledDate = orgValueDate;
	// }
	BigDecimal profitTobeAdjust = BigDecimal.ZERO;
	BigDecimal pushedDownProfitFromPrev = BigDecimal.ZERO;
	boolean recalulate = false;
	for(int i = 0; i < trspayplandetvoList.size(); i++)
	{
	    BigDecimal lineCapitalAmount = NumberUtil.nullToZero(trspayplandetvoList.get(i).getCAPITAL_AMT());
	    BigDecimal lineProfitAmt = trspayplandetvoList.get(i).getPROFIT_AMT();
	    // BigDecimal lineProfitAmtBeforeXirr =
	    // trspayplandetvoList.get(i).getPROFIT_AMT_BEFORE_XIRR();
	    BigDecimal lineActualProfitAmt = trspayplandetvoList.get(i).getACTUAL_PROFIT_AMT();

	    if(IISCommonConstants.LIMIT_REINSTATE_BASED_ON_PRINCIPAL
		    .equals(islamicCalculatorCO.getLimitReinstateBasedOn()))
	    {
		lineCapitalAmount = NumberUtil.nullToZero(trspayplandetvoList.get(i).getCAPITAL_AMT_BEFORE_XIRR());
		lineProfitAmt = trspayplandetvoList.get(i).getPROFIT_AMT_BEFORE_XIRR();
		lineActualProfitAmt = trspayplandetvoList.get(i).getACTUAL_PROFIT_AMT_BEFORE_XIRR();
	    }
	    if(lineActualProfitAmt.compareTo(BigDecimal.ZERO) != 1)
		{
		lineActualProfitAmt = lineProfitAmt;
		}

	    if(lineProfitAmt.compareTo(lineActualProfitAmt) == 1)
	    {
		pushedDownProfitFromPrev = lineProfitAmt.subtract(lineActualProfitAmt);
	    }
	    if(pushedDownProfitFromPrev.compareTo(BigDecimal.ZERO) == -1)
	    {
		pushedDownProfitFromPrev = BigDecimal.ZERO;
	    }

	    // BigDecimal lineSettledCapital =
	    //
	    NumberUtil.nullToZero(trspayplandetvoList.get(i).getSETTLED_CAPITAL_AMT());
	    // BigDecimal lineCharges =
	    // NumberUtil.nullToZero(trspayplandetvoList.get(i).getCHARGE_AMOUNT());
	    // BigDecimal lineInsurance =
	    //
	    NumberUtil.nullToZero(trspayplandetvoList.get(i).getINSURANCE_AMOUNT());
	    BigDecimal lineSettledAmount = NumberUtil.nullToZero(trspayplandetvoList.get(i).getSETTLEMENT_AMOUNT());
	    BigDecimal lineAmount = NumberUtil.nullToZero(trspayplandetvoList.get(i).getAMOUNT());

	    if(ConstantsCommon.NO.equals(islamicCalculatorCO.getUpfrontProduct()))
	    {
		lineAmount = NumberUtil.nullToZero(trspayplandetvoList.get(i).getAMOUNT_NEW());
	    }
	    BigDecimal lineSettledProfit = NumberUtil.nullToZero(trspayplandetvoList.get(i).getSETTLED_PROFIT_AMT());
	    lineValueDate = trspayplandetvoList.get(i).getVALUE_DATE();
	    if(!lineValueDate.after(dealValueDate) && islamicCalculatorCO.getDisbursementScreen())
	    {
		pushedDownProfitFromPrev = NumberUtil
			.nullToZero(trspayplandetvoList.get(i).getPRFT_AMT_PUSHDWN_FRM_ABV_INST());
		fromDate = lineValueDate;
		totalDealAmount = totalDealAmount.subtract(lineCapitalAmount);
		continue;
	    }

	    // BigDecimal pushedDownProfitFromUp =
	    // trspayplandetvoList.get(i).getPRFT_AMT_PUSHDWN_FRM_ABV_INST();
	    // BigDecimal yeildPercent = BigDecimal.ZERO;
	    // || lineValueDate.after(lastSettledDate)
	    if(fromDate.after(dealValueDate))
	    {
		break;
	    }

	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getRevaluationProcess())
		    && !lineValueDate.after(dealValueDate))
	    {
		pushedDownProfitFromPrev = NumberUtil
			.nullToZero(trspayplandetvoList.get(i).getPRFT_AMT_PUSHDWN_FRM_ABV_INST());
		fromDate = lineValueDate;
		totalDealAmount = totalDealAmount.subtract(lineCapitalAmount);
		continue;
	    }
	    if((IISCommonConstants.RESCHEDULE_TYPE_ADVANCE_PRINCIPAL_SETTL
		    .equals(islamicCalculatorCO.getRescheduleType())
		    && (fromDate.compareTo(
			    DateUtil.nullToInitDate(islamicCalculatorCO.getPreviousLineValudateForRevaluation())) == 0))

		    || (((lineSettledAmount.compareTo(BigDecimal.ZERO) == 1
			    && lineSettledAmount.compareTo(lineAmount) == -1)
			    || (lineAmount.compareTo(BigDecimal.ZERO) == 1
				    && lineSettledAmount.compareTo(BigDecimal.ZERO) == 0))
			    && (!IISCommonConstants.RESCHEDULE_TYPE_ADVANCE_PRINCIPAL_SETTL
				    .equals(islamicCalculatorCO.getRescheduleType()))))
	    {
		pushedDownProfitFromPrev = NumberUtil
        .nullToZero(trspayplandetvoList.get(i).getPRFT_AMT_PUSHDWN_FRM_ABV_INST());
		/*
		 * BigDecimal profitAmount = BigDecimal.ZERO;
		 * 
		 * long lineDays = DateUtil.numberOfDays(fromDate,
		 * lineValueDate); long totalDays =
		 * DateUtil.numberOfDays(islamicCalculatorCO.getValueDate(),
		 * islamicCalculatorCO .getMaturityDate());
		 * 
		 * profitAmount =
		 * (islamicCalculatorCO.getOutstandingProfit().divide
		 * (BigDecimal.valueOf(totalDays), 12,
		 * BigDecimal.ROUND_HALF_UP)); profitAmount =
		 * profitAmount.multiply(BigDecimal.valueOf(lineDays));
		 * 
		 * NumberUtil.round(profitAmount.doubleValue(),
		 * islamicCalculatorCO.getDealCyDecimalPoint());
		 * 
		 * calculateProfitAmountForRescheduleNoRecalculate(
		 * islamicCalculatorCO, dateFrom, dateToParam)
		 */
		long lineDays = DateUtil.numberOfDays(fromDate, lineValueDate);
		long totalDays = DateUtil.numberOfDays(fromDate, dealValueDate);
		if(lineValueDate.before(dealValueDate))
		{
		    totalDays = DateUtil.numberOfDays(fromDate, lineValueDate);
		}

		BigDecimal profit = BigDecimal.ZERO;

		if(lineDays > 0)
		{

		    profit = lineActualProfitAmt.divide(BigDecimal.valueOf(lineDays), 12, BigDecimal.ROUND_HALF_UP);
		    profit = profit.multiply(BigDecimal.valueOf(totalDays));
		}
		BigDecimal rescheduleCount = iisIslamicCalculatorDAO.returnRescheduleCountByDealAndDate(
			islamicCalculatorCO.getCompanyCode(), islamicCalculatorCO.getBranchCode(), dealNo, fromDate,
			lineValueDate);
		recalulate = true;
		if(rescheduleCount != null && rescheduleCount.compareTo(BigDecimal.ZERO) == 1)
		{
		    profit = BigDecimal.ZERO;
		    lineValueDate = fromDate;
		    recalulate = true;
		}
		profitTobeAdjust = profitTobeAdjust.add(pushedDownProfitFromPrev);
		profitTobeAdjust = profitTobeAdjust.add(profit).subtract(lineSettledProfit);

		/*
		 * if(trspayplanvoList.size() == 1) {
		 * 
		 * long lineDays = DateUtil.numberOfDays(fromDate,
		 * lineValueDate); long totalDays =
		 * DateUtil.numberOfDays(fromDate, dealValueDate); BigDecimal
		 * profit =
		 * lineActualProfitAmt.divide(BigDecimal.valueOf(lineDays), 12,
		 * BigDecimal.ROUND_HALF_UP); profit =
		 * profit.multiply(BigDecimal.valueOf(totalDays));
		 * profitTobeAdjust = profitTobeAdjust.add(profit); } else {
		 * 
		 * for(int j = 0; j < trspayplanvoList.size(); j++) { Date
		 * planLineDate =
		 * trspayplanvoList.get(j).getRESCHEDULE_VALUE_DATE();
		 * if(planLineDate == null) { planLineDate = orgValueDate; }
		 * 
		 * } }
		 */
		/*
		 * for(int j = 0; j < trspayplanvoList.size(); j++) {
		 * 
		 * } double Profit = calculateProfitAmount(islamicCalculatorCO,
		 * fromDate, lineValueDate, totalDealAmount .doubleValue(), 0L,
		 * 0D, 0D, ConstantsCommon.NO);
		 */
		break;
	    }
	    pushedDownProfitFromPrev = NumberUtil
		    .nullToZero(trspayplandetvoList.get(i).getPRFT_AMT_PUSHDWN_FRM_ABV_INST());
	    fromDate = lineValueDate;
	    totalDealAmount = totalDealAmount.subtract(lineCapitalAmount);
	}

	if(lineValueDate.before(dealValueDate) || (recalulate) || (ConstantsCommon.YES).equals(islamicCalculatorCO.getRescheduling_disbursement_capital_due_Yn()))
	{
	    TRSPAYPLANVO trspayplanvoKey = new TRSPAYPLANVO();
	    trspayplanvoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	    trspayplanvoKey.setBRANCH(islamicCalculatorCO.getBranchCode());
	    trspayplanvoKey.setTRX_NBR(dealNo);
	    List<TRSPAYPLANVO> trspayplanvoList = iisIslamicCalculatorDAO.returnTrspayplanListByTrxNo(trspayplanvoKey);
	    if(trspayplanvoList == null)
	    {
		throw new BOException("Invalid Plan List by Deal");
	    }
	    double Profit = 0;
	    double prevYield = 0;
	    BigDecimal outstandingAmount = islamicCalculatorCO.getOriginalDealAmount();

	    BigDecimal profitOnCharges = NumberUtil.nullToZero(islamicCalculatorCO.getProfitOnCharges());
	    BigDecimal profitOnInsurance = NumberUtil.nullToZero(islamicCalculatorCO.getProfitOnInsurance());

	    outstandingAmount = islamicCalculatorCO.getDealAmount().add(profitOnCharges.add(profitOnInsurance));
	    BigDecimal prevOutstandingAmount = outstandingAmount;
		BigDecimal disburseAmount = BigDecimal.ZERO;
	    if(islamicCalculatorCO.getDisbursementScreen() 
	    		&& islamicCalculatorCO.getRevaluationProcess().equals(IISCommonConstants.RESCHEDULE_NO)){
	    	TRSDEALVO trsdealvo = new TRSDEALVO();
	    	trsdealvo.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	    	trsdealvo.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
	    	trsdealvo.setSERIAL_NO(islamicCalculatorCO.getDealNo());
	    	
	    	disburseAmount=  NumberUtil.nullToZero(iisIslamicCalculatorDAO.returnCurrentDsiburseAmount(trsdealvo));
	    }
	    fromDate = lineValueDate;
	    for(int i = 0; i < trspayplanvoList.size(); i++)
	    {
		lineValueDate = trspayplanvoList.get(i).getRESCHEDULE_VALUE_DATE();

		if(fromDate.before(lineValueDate))
		{
		    // double prevYield =
		    // islamicCalculatorCO.getPrevAnnualYield().doubleValue();
		    // outstandingAmount =
		    
			BigDecimal totalDsibursedAfterVDate =  BigDecimal.ZERO;
			
			if(islamicCalculatorCO.getTrsDealMultipleYieldVO() != null && !islamicCalculatorCO.getTrsDealMultipleYieldVO().isEmpty() ){
				TRSDEALVO trsdealvo = new TRSDEALVO();
				trsdealvo.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
				trsdealvo.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
				trsdealvo.setSERIAL_NO(dealNo);
				trsdealvo.setVALUE_DATE(fromDate);
				prevYield = NumberUtil.toDoubleObj(iisIslamicCalculatorDAO.returnCurrentMultipleYield(trsdealvo));
				
	    	}
			
			if( i > 0)
			{
				if(BigDecimal.valueOf(9).compareTo(NumberUtil.nullToZero(trspayplanvoList.get(i-1).getRESCHEDULE_TYPE())) == 0
						|| (islamicCalculatorCO.getDisbursementScreen() 
					    		&& islamicCalculatorCO.getRevaluationProcess().equals(IISCommonConstants.RESCHEDULE_NO))
						|| (i == 1 && NumberUtil.nullToZero(trspayplanvoList.get(i-1).getRESCHEDULE_TYPE()).compareTo(BigDecimal.ZERO) == 0 ) )
				{
					TRSPAYPLANVO trspayplanvo = new TRSPAYPLANVO();
					trspayplanvo.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
					trspayplanvo.setBRANCH(islamicCalculatorCO.getBranchCode());
					trspayplanvo.setTRX_NBR(dealNo);
					trspayplanvo.setRESCHEDULE_VALUE_DATE(trspayplanvoList.get(i-1).getRESCHEDULE_VALUE_DATE());
					
					totalDsibursedAfterVDate =  NumberUtil.nullToZero(iisIslamicCalculatorDAO.returnTotalDsibursedAfterVDate(trspayplanvo));
					totalDsibursedAfterVDate = totalDsibursedAfterVDate.add(disburseAmount);
					
					outstandingAmount = prevOutstandingAmount.subtract(totalDsibursedAfterVDate) ;
				}else{
					outstandingAmount =  NumberUtil.nullToZero(trspayplanvoList.get(i-1).getPLAN_PRINCIPAL());
				}
			}
			
			
		    Profit = calculateProfitAmount(islamicCalculatorCO, fromDate, lineValueDate,
			    outstandingAmount.doubleValue(), 0L, 0D, prevYield, "N");
		    profitTobeAdjust = profitTobeAdjust.add(BigDecimal.valueOf(Profit));
		    fromDate = lineValueDate;
		    if(BigDecimal.valueOf(9).compareTo(NumberUtil.nullToZero(trspayplanvoList.get(i).getRESCHEDULE_TYPE())) == 0
		    		|| (islamicCalculatorCO.getDisbursementScreen() 
		    	    		&& islamicCalculatorCO.getRevaluationProcess().equals(IISCommonConstants.RESCHEDULE_NO))
		    		|| (i == 1 && NumberUtil.nullToZero(trspayplanvoList.get(i-1).getRESCHEDULE_TYPE()).compareTo(BigDecimal.ZERO) == 0 )){
		    	TRSPAYPLANVO trspayplanvo = new TRSPAYPLANVO();
				trspayplanvo.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
				trspayplanvo.setBRANCH(islamicCalculatorCO.getBranchCode());
				trspayplanvo.setTRX_NBR(dealNo);
				trspayplanvo.setRESCHEDULE_VALUE_DATE(trspayplanvoList.get(i).getRESCHEDULE_VALUE_DATE());
				
				totalDsibursedAfterVDate =  NumberUtil.nullToZero(iisIslamicCalculatorDAO.returnTotalDsibursedAfterVDate(trspayplanvo));
				totalDsibursedAfterVDate = totalDsibursedAfterVDate.add(disburseAmount);
				outstandingAmount = prevOutstandingAmount.subtract(totalDsibursedAfterVDate) ;
				
			}else{
				outstandingAmount =  NumberUtil.nullToZero(trspayplanvoList.get(i).getPLAN_PRINCIPAL());
			}
		    
		    
		    
		}
		double planExpectedYield = NumberUtil.nullToZero(trspayplanvoList.get(i).getPLAN_EXPECTED_YIELD())
			.doubleValue();
		double planLiborYield = NumberUtil.nullToZero(trspayplanvoList.get(i).getPLAN_LIBOR_RATE())
			.doubleValue();
		// outstandingAmount =
		// NumberUtil.nullToZero(trspayplanvoList.get(i).getPLAN_PRINCIPAL());
		prevYield = planExpectedYield + planLiborYield;

	    }

	    if(dealValueDate.after(fromDate))
	    {
		// BigDecimal profitOnCharges =
		// NumberUtil.nullToZero(islamicCalculatorCO.getProfitOnCharges());
		// BigDecimal profitOnInsurance =
		// NumberUtil.nullToZero(islamicCalculatorCO.getProfitOnInsurance());

		// outstandingAmount =
		// islamicCalculatorCO.getDealAmount().add(profitOnCharges.add(profitOnInsurance));
	    	
	    if(islamicCalculatorCO.getTrsDealMultipleYieldVO() != null && !islamicCalculatorCO.getTrsDealMultipleYieldVO().isEmpty() ){
			TRSDEALVO trsdealvo = new TRSDEALVO();
			trsdealvo.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
			trsdealvo.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
			trsdealvo.setSERIAL_NO(dealNo);
			trsdealvo.setVALUE_DATE(fromDate);
			prevYield = NumberUtil.toDoubleObj(iisIslamicCalculatorDAO.returnCurrentMultipleYield(trsdealvo));
    	}
	    	
		Profit = calculateProfitAmount(islamicCalculatorCO, fromDate, dealValueDate,
			outstandingAmount.doubleValue(), 0L, 0D, prevYield, "N");
		profitTobeAdjust = profitTobeAdjust.add(BigDecimal.valueOf(Profit));
	    }

	}
	BigDecimal gracePeriodAdditionalProfit =  calculateAdditionalGracePeriodPRofit(islamicCalculatorCO, orgValueDate, dealValueDate);
	if (gracePeriodAdditionalProfit.compareTo(BigDecimal.ZERO) == 1){
		islamicCalculatorCO.setFirstLineProfitToBeAdjust(gracePeriodAdditionalProfit);
	}else{
		islamicCalculatorCO.setFirstLineProfitToBeAdjust(profitTobeAdjust);
		if(NumberUtil.nullToZero(profitTobeAdjust).compareTo(NumberUtil.nullToZero(pushedDownProfitFromPrev)) >= 0)
		{
			islamicCalculatorCO.setPushedDownProfitAmount(NumberUtil.nullToZero(pushedDownProfitFromPrev));
		}
		else
		{
			islamicCalculatorCO.setPushedDownProfitAmount(BigDecimal.ZERO);
		}
	}
	
	islamicCalculatorCO.getFirstLineProfitToBeAdjust();
    }

    private void calulateAdjustSettledAmountNoProfitAccrualOuststandCapital(IslamicCalculatorCO islamicCalculatorCO,
	    TRSPAYPLANDETVOKey trspayplandetvoKey, BigDecimal dealNo, String considerSettlementYn) throws DAOException
    {
	BigDecimal totalAccruedPrft = NumberUtil
		.nullToZero(iisIslamicCalculatorDAO.returnTotalAccrualProfitAsOfDate(trspayplandetvoKey.getCOMP_CODE(),
			trspayplandetvoKey.getBRANCH(), dealNo, islamicCalculatorCO.getValueDate()));

	BigDecimal totalPlanProfitAsofDate = BigDecimal.ZERO;
	if(ConstantsCommon.NO.equals(considerSettlementYn))
	{
	    totalPlanProfitAsofDate = NumberUtil.nullToZero(iisIslamicCalculatorDAO.returnTotalPlanProfitAsOfDate(
		    trspayplandetvoKey.getCOMP_CODE(), trspayplandetvoKey.getBRANCH(), trspayplandetvoKey.getPLAN_NBR(),
		    trspayplandetvoKey.getPLAN_SEQ(), islamicCalculatorCO.getValueDate()));
	}
	else
	{
	    totalPlanProfitAsofDate = NumberUtil.nullToZero(
		    iisIslamicCalculatorDAO.returnTotalPlanSettledProfitAsOfDate(trspayplandetvoKey.getCOMP_CODE(),
			    trspayplandetvoKey.getBRANCH(), trspayplandetvoKey.getPLAN_NBR(),
			    trspayplandetvoKey.getPLAN_SEQ(), islamicCalculatorCO.getValueDate()));
	}

	BigDecimal additional_profit = NumberUtil.roundToBigDecimal(totalAccruedPrft.subtract(totalPlanProfitAsofDate),
		islamicCalculatorCO.getDealCyDecimalPoint().intValue());
	if(additional_profit.compareTo(BigDecimal.ZERO) == -1)
	{
	    additional_profit = BigDecimal.ZERO;
	}
	islamicCalculatorCO.setFirstLineProfitToBeAdjust(additional_profit);
    }

    private void calulateAdjustSettledAmountNoRecalculate(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	List<TRSPAYPLANDETVO> trspayplandetvoList;
	TRSPAYPLANDETVOKey trspayplandetvoKey = new TRSPAYPLANDETVOKey();
	trspayplandetvoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	trspayplandetvoKey.setBRANCH(islamicCalculatorCO.getBranchCode());
	trspayplandetvoKey.setPLAN_NBR(islamicCalculatorCO.getPlanNbr());
	trspayplandetvoKey.setPLAN_SEQ(islamicCalculatorCO.getPlanSeq());

	if(islamicCalculatorCO.getDisbursementScreen())
	{
	    trspayplandetvoList = iisIslamicCalculatorDAO.returnDisbursePlanScheduleList(trspayplandetvoKey);
	}
	else
	{
	    trspayplandetvoList = iisIslamicCalculatorDAO.returnPlanScheduleList(trspayplandetvoKey);
	}

	if(trspayplandetvoList == null)
	{
	    return;
	}

	Date dealValueDate = islamicCalculatorCO.getValueDate();
	Date orgValueDate = islamicCalculatorCO.getOriginalValueDate();
	Date fromDate = orgValueDate;
	Date lineValueDate = dealValueDate;
	// BigDecimal totalDealAmount =
	// NumberUtil.nullToZero(islamicCalculatorCO.getOriginalDealAmount());

	BigDecimal profitTobeAdjust = BigDecimal.ZERO;
	// BigDecimal pushedDownProfitFromPrev = BigDecimal.ZERO;
	// boolean recalulate = false;
	for(int i = 0; i < trspayplandetvoList.size(); i++)
	{
	    // BigDecimal lineCapitalAmount =
	    // NumberUtil.nullToZero(trspayplandetvoList.get(i).getCAPITAL_AMT());
	    BigDecimal lineProfitAmt = trspayplandetvoList.get(i).getPROFIT_AMT();
	    // BigDecimal lineProfitAmtBeforeXirr =
	    // trspayplandetvoList.get(i).getPROFIT_AMT_BEFORE_XIRR();
	    // BigDecimal lineActualProfitAmt =
	    // trspayplandetvoList.get(i).getACTUAL_PROFIT_AMT();

	    if(IISCommonConstants.LIMIT_REINSTATE_BASED_ON_PRINCIPAL
		    .equals(islamicCalculatorCO.getLimitReinstateBasedOn()))
	    {
		// lineCapitalAmount =
		// NumberUtil.nullToZero(trspayplandetvoList.get(i).getCAPITAL_AMT_BEFORE_XIRR());
		lineProfitAmt = trspayplandetvoList.get(i).getPROFIT_AMT_BEFORE_XIRR();
		// lineActualProfitAmt =
		// trspayplandetvoList.get(i).getACTUAL_PROFIT_AMT_BEFORE_XIRR();
	    }

	    // BigDecimal lineSettledCapital =
	    //
	    NumberUtil.nullToZero(trspayplandetvoList.get(i).getSETTLED_CAPITAL_AMT());
	    // BigDecimal lineCharges =
	    // NumberUtil.nullToZero(trspayplandetvoList.get(i).getCHARGE_AMOUNT());
	    // BigDecimal lineInsurance =
	    //
	    NumberUtil.nullToZero(trspayplandetvoList.get(i).getINSURANCE_AMOUNT());
	    // BigDecimal lineSettledAmount =
	    // NumberUtil.nullToZero(trspayplandetvoList.get(i).getSETTLEMENT_AMOUNT());
	    // BigDecimal lineAmount =
	    // NumberUtil.nullToZero(trspayplandetvoList.get(i).getAMOUNT());

	    if(ConstantsCommon.NO.equals(islamicCalculatorCO.getUpfrontProduct()))
	    {
		// lineAmount =
		// NumberUtil.nullToZero(trspayplandetvoList.get(i).getAMOUNT_NEW());
		lineProfitAmt = trspayplandetvoList.get(i).getPROFIT_AMT_NEW();
	    }
	    BigDecimal lineSettledProfit = NumberUtil.nullToZero(trspayplandetvoList.get(i).getSETTLED_PROFIT_AMT());
	    lineValueDate = trspayplandetvoList.get(i).getVALUE_DATE();

	    // BigDecimal pushedDownProfitFromUp =
	    // trspayplandetvoList.get(i).getPRFT_AMT_PUSHDWN_FRM_ABV_INST();
	    // BigDecimal yeildPercent = BigDecimal.ZERO;
	    // || lineValueDate.after(lastSettledDate)
	    if(!fromDate.before(dealValueDate))
	    {
		break;
	    }

	    long lineDays = DateUtil.numberOfDays(fromDate, lineValueDate);
	    long totalDays = DateUtil.numberOfDays(fromDate, dealValueDate);
	    BigDecimal profit = BigDecimal.ZERO;
	    // PMD infractions; Saheer.Naduthodi; 10/12/2014
	    if(lineValueDate.after(dealValueDate))
	    {
		profit = BigDecimal.ZERO;
		totalDays = DateUtil.numberOfDays(fromDate, dealValueDate);
		if(lineDays > 0)
		{
		    profit = lineProfitAmt.divide(BigDecimal.valueOf(lineDays), 12, BigDecimal.ROUND_HALF_UP);
		    profit = profit.multiply(BigDecimal.valueOf(totalDays));
		}
		profitTobeAdjust = profitTobeAdjust.add(profit).subtract(lineSettledProfit);
		break;
	    }
	    else
	    {
		profit = lineProfitAmt;
	    }
	    profitTobeAdjust = profitTobeAdjust.add(profit).subtract(lineSettledProfit);
	    fromDate = lineValueDate;
	}

	islamicCalculatorCO.setFirstLineProfitToBeAdjust(profitTobeAdjust);
	islamicCalculatorCO.getFirstLineProfitToBeAdjust();
    }

    @Override
    public IslamicCalculatorCO createRepaymentForRequest(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	applyIAS18Method(islamicCalculatorCO);
	printPlan(islamicCalculatorCO.getTrspayplandetVOList(), islamicCalculatorCO);
	// if the Profit Recognition Method is Rule 78
	if(IISCommonConstants.PROFIT_DISTRIBUTION_METHOD_RULE_78
		.equals(islamicCalculatorCO.getProfitRecognitionMethod()))
	{
	    if(ConstantsCommon.YES.equals(islamicCalculatorCO.getSegmentAppliedYn()))
	    {
		// if the segment applicable Y
		applyRule78Segment(islamicCalculatorCO);
	    }
	    else
	    {
		applyRule78(islamicCalculatorCO);
	    }
	}
	return islamicCalculatorCO;
    }

    // #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015 [Start]
    @Override
    public IslamicCalculatorCO calculateAgencyFee(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {

	String isAccrueAgencyFeeYn = islamicCalculatorCO.getAccrueAgencyFeeYn();

	if(islamicCalculatorCO.getTrspayplandetVOList() == null
		|| islamicCalculatorCO.getTrspayplandetVOList().isEmpty()
		|| ConstantsCommon.NO.equals(isAccrueAgencyFeeYn))
	{
	    return islamicCalculatorCO;
	}

	if(IISCommonConstants.RESCHEDULE_TYPE_ADVANCE_PRINCIPAL_SETTL.equals(islamicCalculatorCO.getRescheduleType()))
	{
	    calculateAgencyFeeAdvancePrincipalSettlement(islamicCalculatorCO);
	    return islamicCalculatorCO;
	}
	if(NumberUtil.nullToZero(islamicCalculatorCO.getAgencyFeePercentage()).compareTo(BigDecimal.ZERO) != 1)
	{
	    return islamicCalculatorCO;
	}
	// Deepu 421068 ICD160002 13/09/2017
	if("C".equals(isAccrueAgencyFeeYn))
	{
	    calculateAgencyFeeOnOutstandingpricipal(islamicCalculatorCO);

	    return islamicCalculatorCO;
	}

	// calculate agency fee for each installment and set in column
	BigDecimal profitAmount, agencyFeeAmt;
	BigDecimal agencyFeePcnt = islamicCalculatorCO.getAgencyFeePercentage().divide(BigDecimal.valueOf(100), 12,
		BigDecimal.ROUND_HALF_UP);
	// BigDecimal agencyFeePcnt =
	// islamicCalculatorCO.getAgencyFeePercentage().divide(
	// islamicCalculatorCO.getAnnualYield(), 12,
	// BigDecimal.ROUND_HALF_UP);
	int count = 0;
	for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
	{
	    if(trspayplandetCO.getAMOUNT().compareTo(BigDecimal.ZERO) > 0)
	    {
		profitAmount = trspayplandetCO.getPROFIT_AMT();
		agencyFeeAmt = profitAmount.multiply(agencyFeePcnt);
		islamicCalculatorCO.getTrspayplandetVOList().get(count).setAGENCY_FEE_AMT(agencyFeeAmt);
	    }
	    count++;
	}
	return islamicCalculatorCO;
    }

    // Deepu 421068 ICD160002 13/09/2017
    private void calculateAgencyFeeOnOutstandingpricipal(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	Date profitFromDate = islamicCalculatorCO.getValueDate();
	int count = 0;
	for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
	{
	    if(NumberUtil.emptyDecimalToZero(trspayplandetCO.getAMOUNT()).compareTo(BigDecimal.ZERO) == 1)
	    {

		BigDecimal agencyFeeAmt = NumberUtil.roundToBigDecimal(calculateProfitAmount(islamicCalculatorCO,
			profitFromDate, trspayplandetCO.getVALUE_DATE(),
			NumberUtil.toDoubleObj(trspayplandetCO.getTOTAL_PRINCIPAL_OUTSTANDIG()), 0L, 0D,
			NumberUtil.toDoubleObj(islamicCalculatorCO.getAgencyFeePercentage()), ConstantsCommon.NO),
			islamicCalculatorCO.getDealCyDecimalPoint());
		islamicCalculatorCO.getTrspayplandetVOList().get(count).setAGENCY_FEE_AMT(agencyFeeAmt);

		trspayplandetCO.setProfitAmountAgencyFees(agencyFeeAmt.add(trspayplandetCO.getPROFIT_AMT()));

	    }
	    profitFromDate = trspayplandetCO.getVALUE_DATE();
	    count++;
	}
    }

    // #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015 [End]
    // #TAR ICD140061 ; Arun.R.Variyath ; 20/10/2015 [Start]
    @Override
    public IslamicCalculatorCO calculateAgencyFeeAdvancePrincipalSettlement(IslamicCalculatorCO islamicCalculatorCO)
	    throws BaseException
    {
	int count = 0;
	int size = islamicCalculatorCO.getTrspayplandetVOList().size();
	BigDecimal totalProfit = NumberUtil.nullToZero(islamicCalculatorCO.getOutProfitAmount());

	if(NumberUtil.nullToZero(islamicCalculatorCO.getOutstandingAgencyFee()).compareTo(BigDecimal.ZERO) != 1
		|| totalProfit.compareTo(BigDecimal.ZERO) != 1)
	{
	    return islamicCalculatorCO;
	}
	if(islamicCalculatorCO.getOutstandingAgencyFee().compareTo(totalProfit) == 1)
	{
	    throw new BOException(MessageCodes.Invalid_Code,
		    "Outstanding_Agency_Fee_is_greater_than_new_total_profit_amount_key");
	}
	BigDecimal totalAlloccated = BigDecimal.ZERO;
	for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
	{
	    BigDecimal agencyFeeAmt = BigDecimal.ZERO;
	    if(trspayplandetCO.getAMOUNT().compareTo(BigDecimal.ZERO) > 0)
	    {
		if(size == count)
		{
		    agencyFeeAmt = islamicCalculatorCO.getOutstandingAgencyFee().subtract(totalAlloccated);
		}
		else
		{
		    BigDecimal profitAmount = trspayplandetCO.getPROFIT_AMT();
		    agencyFeeAmt = islamicCalculatorCO.getOutstandingAgencyFee()
			    .divide(totalProfit, 12, BigDecimal.ROUND_HALF_UP).multiply(profitAmount);
		    agencyFeeAmt = NumberUtil.roundToBigDecimal(agencyFeeAmt,
			    islamicCalculatorCO.getDealCyDecimalPoint().intValue());
		    totalAlloccated = totalAlloccated.add(agencyFeeAmt);
		}
	    }
	    // TODO ARUN
	    islamicCalculatorCO.getTrspayplandetVOList().get(count).setAGENCY_FEE_AMT(agencyFeeAmt);
	    count++;
	}
	return islamicCalculatorCO;
    }
    // #TAR ICD140061 ; Arun.R.Variyath ; 20/10/2015 [End]

	private void calculateAgencyFeesonInstallmentPrincipal (IslamicCalculatorCO islamicCalculatorCO) throws BaseException
	{

//    	if(islamicCalculatorCO.getTrspayplandetVOList() == null
//    		|| islamicCalculatorCO.getTrspayplandetVOList().isEmpty() 
//    		|| !"C".equals(islamicCalculatorCO.getAccrueAgencyFeeYn())
//    		|| NumberUtil.nullToZero(islamicCalculatorCO.getAgencyFeePercentage()).compareTo(BigDecimal.ZERO) <= 0 )
//    	{
    	    return;
//    	}
    	
	}
	
	// DN# EWBI160013; deepu.mohandas 25/04/2016

    private IslamicCalculatorCO calculateTegAndTie(IslamicCalculatorCO calculatorCO) throws BaseException
    {

	if(ConstantsCommon.NO.equals(StringUtil.nullEmptyToValue(calculatorCO.getAPPLY_TEG_YN(), ConstantsCommon.NO)))
	{
	    return calculatorCO;
	}

	TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	trsClassVOKey.setCOMP_CODE(calculatorCO.getCompanyCode());
	trsClassVOKey.setCODE(calculatorCO.getProductClassCode());
	TRSCLASSVO trsClassVO = iisIslamicCalculatorDAO.getProductClassDetails(trsClassVOKey);
	if(trsClassVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	trsClassVOKey = null;
	BigDecimal tie = iisIslamicCalculatorDAO.returnExcessiveProfitRate(calculatorCO);
	BigDecimal marginRate = NumberUtil.nullToZero(iisIslamicCalculatorDAO.returnMarginRate(calculatorCO));

	if(NumberUtil.isEmptyDecimal(tie))
	{
	    return calculatorCO;
	}
	tie = tie.subtract(marginRate);
	BigDecimal teg = returnTegValue(calculatorCO, trsClassVO, tie);

	if(teg.compareTo(tie) == 1)
	{
	    calculatorCO.setActualTegRate(teg);
	    calculatorCO.setActualAnnualRate(calculatorCO.getAnnualYeild());
	    calculatorCO.setTieRate(tie);
	    calculatorCO.setTegAdjustmentType(trsClassVO.getTEG_ADJUSTMENT_TYPE());
	    calculatorCO.getTeg();
	    calculatorCO.getActualTegRate();
	    // if(IISCommonConstants.AUTOMATIC.equals(trsClassVO.getTEG_ADJUSTMENT_TYPE()))
	    // {

	    if(IISCommonConstants.YIELD_FIRST.equals(trsClassVO.getTEG_PRIORITY())
		    || IISCommonConstants.MANUAL.equals(trsClassVO.getTEG_ADJUSTMENT_TYPE())
		    || ConstantsCommon.YES.equals(calculatorCO.getCalledFromFmsYN())
		    || calculatorCO.getCalculatorType().equals(IISCommonConstants.CALCULATOR_TYPE_CALCULATOR))
	    {

		calculatorCO = returnYieldValue(calculatorCO, trsClassVO, tie);

	    }
	    else
	    {
		calculatorCO = returnAdjustedDealChargesListAccordingToPriority(calculatorCO);
		calculatorCO = claculateTegForDealCharges(calculatorCO, trsClassVO, tie);
	    }
	    if(NumberUtil.nullToZero(calculatorCO.getAnnualYeild())
		    .compareTo(NumberUtil.nullToZero(calculatorCO.getFloatingRate())) == -1)
	    {

		calculatorCO.setFloatingRate(calculatorCO.getAnnualYeild());
	    }
	    calculatorCO.setShowTegMessages("Y");

	    if(calculatorCO.isMinYeildReached() && calculatorCO.getTeg().compareTo(tie) == 1)
	    {
		calculatorCO.setMinYeildReached(true);
	    }
	    else
	    {
		calculatorCO.setMinYeildReached(false);
	    }
	    // }
	    // else
	    // {
	    // throw new BOException(MessageCodes.iis_invalid_code, new String[]
	    // { "teg_is_greater_than_tie",
	    // " TEG :" + teg }, true);
	    // }

	    // if(calculatorCO.isMinYeildReached() &&
	    // calculatorCO.isMinChargeReached())
	    // {
	    // throw new BOException(MessageCodes.iis_invalid_code,
	    // new String[] {
	    // "TEG_is_greater_than_the_TIE_after_adjusting_Yield_Charges" },
	    // false);
	    // }

	    calculatorCO.setTieAdjustedAnnualRate(calculatorCO.getAnnualYeild());
	    if(ConstantsCommon.YES.equals(calculatorCO.getCalledFromFmsYN())
		    || calculatorCO.getCalculatorType().equals(IISCommonConstants.CALCULATOR_TYPE_CALCULATOR))
	    {
		calculatorCO.setAnnualYeild(calculatorCO.getActualAnnualRate());
		calculateInstallmentValues(calculatorCO);
		calculatorCO.setTeg(calculatorCO.getActualTegRate());
	    }
	}

	return calculatorCO;
    }

    // DN# EWBI160013; deepu.mohandas 25/04/2016
    private BigDecimal returnTegValue(IslamicCalculatorCO calculatorCO, TRSCLASSVO trsClassVO, BigDecimal tie)
	    throws BaseException
    {

	List<TrspayplandetCO> trspayplandetVOList = calculatorCO.getTrspayplandetVOList();

	ArrayList<Double> periodInMonthList = new ArrayList<Double>();
	ArrayList<BigDecimal> installmentAmountList = new ArrayList<BigDecimal>();

	BigDecimal totalPricipalAmount = calculatorCO.getDealAmount();
	BigDecimal chargesCollected = BigDecimal.ZERO;

	//List<TRSDEALCHARGESVO> trsdealchargesVOList = calculatorCO.getTrsdealchargesVO();

	for(TRSDEALCHARGESVO trsdealchargesvo : calculatorCO.getTrsdealchargesVO())
	{

	    if(ConstantsCommon.YES.equals(trsdealchargesvo.getCOLLECT_CHARGE_AT_DEAL_YN()) || (ConstantsCommon.NO
		    .equals(StringUtil.nullEmptyToValue(trsdealchargesvo.getCHARGE_TYPE(), ConstantsCommon.NO))
		    && ConstantsCommon.NO.equals(StringUtil
			    .nullEmptyToValue(trsdealchargesvo.getPAY_AT_DEAL_CLOSURE_YN(), ConstantsCommon.NO))
		    && ConstantsCommon.NO.equals(StringUtil
			    .nullEmptyToValue(trsdealchargesvo.getCOLLECT_CHARGE_AT_DEAL_YN(), ConstantsCommon.NO))))

	    {
		if(ConstantsCommon.YES.equals(
			StringUtil.nullEmptyToValue(trsdealchargesvo.getCHARGE_AMT_PER_INST_YN(), ConstantsCommon.NO)))
		{
		    chargesCollected = chargesCollected
			    .add(trsdealchargesvo.getCHARGES_AMOUNT().multiply(BigDecimal.valueOf(1)));
		}
		else
		{
		    chargesCollected = chargesCollected.add(trsdealchargesvo.getCHARGES_AMOUNT());
		}
	    }

	}

	for(int i = 0; i < trspayplandetVOList.size(); i++)
	{

	    // totalPricipalAmount = totalPricipalAmount.add(trspayplandetCO
	    // .getPRINCIPLE_AMT());

	    // n (between date 1 and date 2) = (J2-J1) + 30*(M2-M1) +
	    // 360*(A2-A1)
	    // J: days of the month
	    // M: month
	    // A : year

	    Date D1, D2;

	    if(i == 0)
	    {
		D1 = calculatorCO.getValueDate();
		D2 = trspayplandetVOList.get(i).getVALUE_DATE();
	    }
	    else
	    {

		D1 = trspayplandetVOList.get(i - 1).getVALUE_DATE();
		D2 = trspayplandetVOList.get(i).getVALUE_DATE();
	    }

	    Long J1 = DateUtil.getDatePart("DD", D1);
	    Long J2 = DateUtil.getDatePart("DD", D2);

	    Long M1 = DateUtil.getDatePart("MM", D1);
	    Long M2 = DateUtil.getDatePart("MM", D2);

	    Long A1 = DateUtil.getDatePart("YY", D1);
	    Long A2 = DateUtil.getDatePart("YY", D2);
	    Long n = (J2 - J1) + (30 * (M2 - M1)) + (360 * (A2 - A1));

	    if(i == 0)
	    {
		periodInMonthList.add(n / 30D);
	    }
	    else
	    {
		Double p = periodInMonthList.get(i - 1);
		periodInMonthList.add(p + n / 30D);
	    }

	    installmentAmountList.add(trspayplandetVOList.get(i).getAMOUNT());

	}

	BigDecimal kc = totalPricipalAmount.subtract(chargesCollected);
	BigDecimal divisor = BigDecimal.valueOf(10);

	// to do TegCalculation

	// K-C =RP1/(1+T) P1 + RP2/(1+T) P2+....
	// to Get Tie

	// BigDecimal t = tie.divide(BigDecimal.valueOf(12), 6,
	// BigDecimal.ROUND_HALF_UP);
	BigDecimal t = BigDecimal.ZERO;

	t = returnTvalue(installmentAmountList, periodInMonthList, t, kc);
	// Modified By Manoj on 03/11/2016 for EWBI160423
	// BigDecimal teg =
	// NumberUtil.roundToBigDecimal(t.multiply(BigDecimal.valueOf(12)), 2);
	BigDecimal teg = NumberUtil
		.roundToBigDecimal(t.multiply(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(12)), 2);
	// teg = BigDecimal.valueOf(11.8);
	calculatorCO.setTeg(teg);
	return teg;
    }

    // DN# EWBI160013; deepu.mohandas 25/04/2016
    // to get Adjusted yield value
    private IslamicCalculatorCO returnYieldValue(IslamicCalculatorCO islamicCalculatorCO, TRSCLASSVO trsClassVO,
	    BigDecimal tie) throws BaseException
    {

	BigDecimal minYield = iisIslamicCalculatorDAO.returnMinYield(islamicCalculatorCO);
	if(minYield == null && ConstantsCommon.YES.equals(islamicCalculatorCO.getYieldRequiredYn()))
	{

	    throw new BOException(MessageCodes.iis_invalid_code, new String[] { "Min Yeild Not Defined" }, false);
	}
	BigDecimal teg = BigDecimal.ZERO;
	BigDecimal yield = islamicCalculatorCO.getAnnualYeild();
	while(yield.compareTo(minYield) == 1)
	{
	    yield = yield.subtract(BigDecimal.ONE);
	    // for recreate repayment plan for new yield
	    if(yield.compareTo(minYield) == 1)
	    {
		islamicCalculatorCO.setAnnualYeild(yield);
	    }
	    else
	    {
		islamicCalculatorCO.setAnnualYeild(minYield);
	    }
	    // islamicCalculatorCO.getTrspayplandetVOList().clear();
	    // islamicCalculatorCO = createRepaymentPlan(islamicCalculatorCO);

	    calculateInstallmentValues(islamicCalculatorCO);
	    teg = returnTegValue(islamicCalculatorCO, trsClassVO, tie);
	    // Teg lessthan or equal to tie
	    if(teg.compareTo(tie) <= 0)
	    {
		break;
	    }

	}
	BigDecimal divisor = BigDecimal.valueOf(100);
	while(yield.compareTo(minYield) == 1 && teg.compareTo(tie) != 0)
	{

	    yield = yield.add(BigDecimal.ONE.divide(divisor));
	    // for recreate repayment plan for new yield
	    islamicCalculatorCO.setAnnualYeild(yield);

	    // islamicCalculatorCO.getTrspayplandetVOList().clear();
	    // islamicCalculatorCO = createRepaymentPlan(islamicCalculatorCO);
	    calculateInstallmentValues(islamicCalculatorCO);

	    teg = returnTegValue(islamicCalculatorCO, trsClassVO, tie);
	    if(teg.compareTo(tie) >= 0)
	    {
		break;
	    }

	}

	if(yield.compareTo(minYield) <= 0)
	{

	    islamicCalculatorCO.setMinYeildReached(true);

	    if(teg.compareTo(tie) == 1 && !islamicCalculatorCO.isMinChargeReached())
	    {
		islamicCalculatorCO = returnAdjustedDealChargesListAccordingToPriority(islamicCalculatorCO);
		claculateTegForDealCharges(islamicCalculatorCO, trsClassVO, tie);
	    }

	}
	islamicCalculatorCO.setAnnualYeild(yield);
	return islamicCalculatorCO;

    }


    private IslamicCalculatorCO claculateTegForDealCharges(IslamicCalculatorCO islamicCalculatorCO,
	    TRSCLASSVO trsClassVO, BigDecimal tie) throws BaseException
    {
	if(IISCommonConstants.MANUAL.equals(trsClassVO.getTEG_ADJUSTMENT_TYPE())
		|| ConstantsCommon.YES.equals(islamicCalculatorCO.getCalledFromFmsYN())
		|| islamicCalculatorCO.getCalculatorType().equals(IISCommonConstants.CALCULATOR_TYPE_CALCULATOR))
	{
	    return islamicCalculatorCO;
	}

	/*
	List<TRSDEALCHARGESVO> trsdealchargesVOList = islamicCalculatorCO.getTrsdealchargesVO();

	BigDecimal dealCyCrossRate = BigDecimal.ONE;
	if(islamicCalculatorCO.getDealCurrency().compareTo(islamicCalculatorCO.getBaseCurrencyCode()) != 0)
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorCO.getCompanyCode());
	    iisCommonCO.setBaseCurrencyCode(islamicCalculatorCO.getBaseCurrencyCode());
	    iisCommonCO.setBranchCode(islamicCalculatorCO.getBranchCode());
	    iisCommonCO.setTrCurrency(islamicCalculatorCO.getDealCurrency());
	    iisCommonCO.setPfCurrency(islamicCalculatorCO.getBaseCurrencyCode());
	    iisCommonCO.setCrossDate(islamicCalculatorCO.getRunningDate());
	    iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);

	    if(iisCommonCO != null && !NumberUtil.isEmptyDecimal(iisCommonCO.getCrossRate())
		    && iisCommonCO.getCrossRate().compareTo(BigDecimal.ZERO) > 0)
	    {
		dealCyCrossRate = iisCommonCO.getCrossRate();
	    }
	    else
	    {
		throw new BOException(MessageCodes.EXCHANGE_RATE_NOT_DEFINED);
	    }
	}
	int index = trsdealchargesVOList.size();
	int count = 0;
	BigDecimal charge = BigDecimal.ZERO;
	BigDecimal teg = BigDecimal.ZERO;
	while(index > count)
	{

	    TRSDEALCHARGESVO trsdealchargesvo = trsdealchargesVOList.get(count);
	    boolean considerChageForAdjustment = returnconsiderChageForAdjustment(trsdealchargesvo,
		    islamicCalculatorCO.getTegAdjustmenttrsdealchargesVOList());
	    if(considerChageForAdjustment)
	    {
		charge = trsdealchargesvo.getCHARGES_AMOUNT();

		while(charge.compareTo(BigDecimal.ZERO) == 1 && teg.compareTo(tie) != 0)
		{
		    charge = charge.subtract(BigDecimal.ONE);

		    islamicCalculatorCO.getTrsdealchargesVO().get(count).setCHARGES_AMOUNT(charge);
		    islamicCalculatorCO.setChargeAdjustedForTie("Y");
		    BigDecimal flatAmount = charge;

		    flatAmount = flatAmount.multiply(dealCyCrossRate);
		    islamicCalculatorCO.getTrsdealchargesVO().get(count).setCHARGES_AMT_CV(flatAmount);
		    BigDecimal chargeCyCrossRate = BigDecimal.ONE;

		    if(islamicCalculatorCO.getDealCurrency()
			    .compareTo(islamicCalculatorCO.getTrsdealchargesVO().get(count).getCR_ACC_CURRENCY()) != 0)
		    {
			IISCommonCO iisCommonCO = new IISCommonCO();
			iisCommonCO.setCompCode(islamicCalculatorCO.getCompanyCode());
			iisCommonCO.setBaseCurrencyCode(islamicCalculatorCO.getBaseCurrencyCode());
			iisCommonCO.setTrCurrency(islamicCalculatorCO.getBaseCurrencyCode());
			iisCommonCO.setPfCurrency(
				islamicCalculatorCO.getTrsdealchargesVO().get(count).getCR_ACC_CURRENCY());
			iisCommonCO.setCrossDate(islamicCalculatorCO.getRunningDate());
			iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			if(iisCommonCO != null && !NumberUtil.isEmptyDecimal(iisCommonCO.getCrossRate())
				&& iisCommonCO.getCrossRate().compareTo(BigDecimal.ZERO) > 0)
			{
			    chargeCyCrossRate = iisCommonCO.getCrossRate();
			}
			else
			{
			    throw new BOException(MessageCodes.EXCHANGE_RATE_NOT_DEFINED);
			}
		    }
		    else
		    {
			flatAmount = charge;
		    }

		    flatAmount = flatAmount.multiply(chargeCyCrossRate);
		    islamicCalculatorCO.getTrsdealchargesVO().get(count).setCHARGES_AMT_FC(flatAmount);

		    // islamicCalculatorCO = setValues(islamicCalculatorCO);
		    if(islamicCalculatorCO.getTotalCharges().compareTo(BigDecimal.ZERO) == 1
			    || islamicCalculatorCO.getTotalInsurance().compareTo(BigDecimal.ZERO) == 1)
		    {
			islamicCalculatorCO = getChargeInsuranceAmount(islamicCalculatorCO);
			calculateInstallmentValues(islamicCalculatorCO);
		    }

		    teg = returnTegValue(islamicCalculatorCO, trsClassVO, tie);
		    if(teg.compareTo(tie) <= 0)
		    {
			if(teg.compareTo(tie) != 1)
			{
			    charge = charge.add(BigDecimal.ONE);
			}
			break;
		    }

		}

		BigDecimal divisor = BigDecimal.valueOf(10).pow(NumberUtil.toInt(NumberUtil.nullEmptyToValue(
			BigDecimal.valueOf(islamicCalculatorCO.getDealCyDecimalPoint()), BigDecimal.ONE)));

		Boolean chargeReached = false;

		while(charge.compareTo(BigDecimal.ZERO) == 1 && teg.compareTo(tie) != 0)
		{
		    chargeReached = true;

		    charge = charge.subtract(BigDecimal.ONE.divide(divisor));
		    islamicCalculatorCO.getTrsdealchargesVO().get(count).setCHARGES_AMOUNT(charge);
		    BigDecimal flatAmount = charge;
		    islamicCalculatorCO.setChargeAdjustedForTie("Y");
		    flatAmount = flatAmount.multiply(dealCyCrossRate);
		    islamicCalculatorCO.getTrsdealchargesVO().get(count).setCHARGES_AMT_CV(flatAmount);
		    BigDecimal chargeCyCrossRate = BigDecimal.ONE;
		    if(islamicCalculatorCO.getDealCurrency()
			    .compareTo(islamicCalculatorCO.getTrsdealchargesVO().get(count).getCR_ACC_CURRENCY()) != 0)
		    {

			IISCommonCO iisCommonCO = new IISCommonCO();
			iisCommonCO.setCompCode(islamicCalculatorCO.getCompanyCode());
			iisCommonCO.setBaseCurrencyCode(islamicCalculatorCO.getBaseCurrencyCode());
			iisCommonCO.setTrCurrency(islamicCalculatorCO.getBaseCurrencyCode());
			iisCommonCO.setPfCurrency(
				islamicCalculatorCO.getTrsdealchargesVO().get(count).getCR_ACC_CURRENCY());
			iisCommonCO.setCrossDate(islamicCalculatorCO.getRunningDate());
			iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);

			if(iisCommonCO != null && !NumberUtil.isEmptyDecimal(iisCommonCO.getCrossRate())
				&& iisCommonCO.getCrossRate().compareTo(BigDecimal.ZERO) > 0)
			{
			    chargeCyCrossRate = iisCommonCO.getCrossRate();
			}
			else
			{
			    throw new BOException(MessageCodes.EXCHANGE_RATE_NOT_DEFINED);
			}
		    }
		    else
		    {
			flatAmount = charge;
		    }
		    flatAmount = flatAmount.multiply(chargeCyCrossRate);
		    islamicCalculatorCO.getTrsdealchargesVO().get(count).setCHARGES_AMT_FC(flatAmount);

		    // islamicCalculatorCO = setValues(islamicCalculatorCO);
		    if(islamicCalculatorCO.getTotalCharges().compareTo(BigDecimal.ZERO) == 1
			    || islamicCalculatorCO.getTotalInsurance().compareTo(BigDecimal.ZERO) == 1)
		    {
			islamicCalculatorCO = getChargeInsuranceAmount(islamicCalculatorCO);
			calculateInstallmentValues(islamicCalculatorCO);
		    }
		    teg = returnTegValue(islamicCalculatorCO, trsClassVO, tie);
		    if(teg.compareTo(tie) <= 0)
		    {
			break;
		    }

		}
		if(chargeReached)
		{
		    break;
		}
	    }
	    count++;

	}
	if(charge.compareTo(BigDecimal.ZERO) == 0 && (index == count) || index == 0)
	{
	    islamicCalculatorCO.setMinChargeReached(true);
	    if(!islamicCalculatorCO.isMinYeildReached())
	    {
		islamicCalculatorCO = returnYieldValue(islamicCalculatorCO, trsClassVO, tie);
	    }
	}
	
	*/
	return islamicCalculatorCO;
    }
    

    // function for COnsider Charge or not
    private boolean returnconsiderChageForAdjustment(TRSDEALCHARGESVO trsdealchargesvo,
	    List<TRSDEALCHARGESVO> tegAdjustmenttrsdealchargesVOList)
    {
	for(TRSDEALCHARGESVO trsdealchargesvo2 : tegAdjustmenttrsdealchargesVOList)
	{
	    if(trsdealchargesvo2.getCHARGES_CODE().compareTo(trsdealchargesvo.getCHARGES_CODE()) == 0)
	    {
		return true;
	    }

	}
	return false;
    }

    // DN# EWBI160013; deepu.mohandas 25/04/2016
    private IslamicCalculatorCO returnAdjustedDealChargesListAccordingToPriority(
	    IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	if(islamicCalculatorCO.getTrsdealchargesVO() == null || islamicCalculatorCO.getTrsdealchargesVO().size() == 0)
	{
	    return islamicCalculatorCO;
	}

	List<TRSDEALCHARGESVO> trsdealchargesVOList = new ArrayList<TRSDEALCHARGESVO>();

	trsdealchargesVOList.addAll(islamicCalculatorCO.getTrsdealchargesVO());
	// List<TRSDEALCHARGESVO> trsdealchargesVOList =
	// islamicCalculatorCO.getTrsdealchargesVO();

	String chargeCodes = "";
	for(TRSDEALCHARGESVO trsdealchargesvo : trsdealchargesVOList)
	{
	    if(chargeCodes.equals(""))
	    {
		chargeCodes = trsdealchargesvo.getCHARGES_CODE().toString();
	    }
	    else
	    {
		chargeCodes = chargeCodes.concat(",").concat(trsdealchargesvo.getCHARGES_CODE().toString());
	    }

	}
	islamicCalculatorCO.setChargeCodes(chargeCodes);
	islamicCalculatorCO.getTrsdealchargesVO().clear();
	List<TRSCHARGESVO> trschargesVOList = iisIslamicCalculatorDAO.returnTtrschargesVOList(islamicCalculatorCO);
	// Loop for arrange dealcharges according to priority
	for(TRSCHARGESVO trschargesvo : trschargesVOList)
	{

	    for(TRSDEALCHARGESVO trsdealchargesvo : trsdealchargesVOList)
	    {
		if(islamicCalculatorCO.getTegAdjustmenttrsdealchargesVOList() == null)
		{
		    islamicCalculatorCO.setTegAdjustmenttrsdealchargesVOList(new ArrayList<TRSDEALCHARGESVO>());
		}

		if(trschargesvo.getCODE().compareTo(trsdealchargesvo.getCHARGES_CODE()) == 0)
		{
//		    islamicCalculatorCO.getTrsdealchargesVO().add(trsdealchargesvo);
//		    if(NumberUtil.nullToZero(trschargesvo.getTEG_ADJUSTMENT_PRIORITY()).compareTo(BigDecimal.ZERO) == 1)
//		    {
//			islamicCalculatorCO.getTegAdjustmenttrsdealchargesVOList().add(trsdealchargesvo);
//		    }
		}
	    }
	}
	return islamicCalculatorCO;
    }

    // DN# EWBI160013; deepu.mohandas 25/04/2016
    private BigDecimal returnRightPart(ArrayList<BigDecimal> installmentAmountList, ArrayList<Double> periodInMonthList,
	    BigDecimal t)
    {
	BigDecimal rightPart = BigDecimal.ZERO;
	for(int i = 0; i < installmentAmountList.size(); i++)
	{

	    if(BigDecimal.ZERO.compareTo(t) != 0)
	    {
		rightPart = rightPart.add(installmentAmountList.get(i)
			.divide((BigDecimal.ONE.add(t)).pow(periodInMonthList.get(i).intValue()), 6));

	    }

	}
	return rightPart;
    }

    // DN# EWBI160013; deepu.mohandas 25/04/2016
    private BigDecimal returnTvalue(ArrayList<BigDecimal> installmentAmountList, ArrayList<Double> periodInMonthList,
	    BigDecimal t, BigDecimal kc)
    {
	Boolean flag = true;
	boolean deciamlFlag = true;
	BigDecimal divisor = BigDecimal.valueOf(10);
	while(flag)
	{
	    BigDecimal rightPart = returnRightPart(installmentAmountList, periodInMonthList, t);
	    if(kc.compareTo(rightPart) == -1 && deciamlFlag || t.compareTo(BigDecimal.ONE) == -1)
	    {
		BigDecimal t0 = t.add(BigDecimal.ONE);
		if(t.compareTo(BigDecimal.ONE) == 1
			&& kc.compareTo(returnRightPart(installmentAmountList, periodInMonthList, t0)) == -1)
		{
		    t = t0;
		    // break;
		}
		else
		{

		    while(deciamlFlag)
		    {
			if(t.compareTo(BigDecimal.ONE) == -1)
			{
			    t = BigDecimal.ZERO;
			}
			BigDecimal t1 = t.add(BigDecimal.ONE.divide(divisor));
			if(kc.compareTo(returnRightPart(installmentAmountList, periodInMonthList, t1)) == -1)
			{
			    t = t1;
			    deciamlFlag = false;

			}
			else
			{

			    divisor = divisor.multiply(BigDecimal.valueOf(10));

			}
		    }

		    for(int i = 1; i < 10; i++)
		    {
			BigDecimal t2 = t.add(BigDecimal.ONE.divide(divisor));
			if(kc.compareTo(returnRightPart(installmentAmountList, periodInMonthList, t2)) == -1)
			{
			    t = t2;

			}
			else
			{

			    divisor = divisor.multiply(BigDecimal.valueOf(10));

			}

			if(kc.compareTo(returnRightPart(installmentAmountList, periodInMonthList, t2)) == 0)
			{
			    t = t2;
			    flag = false;
			    break;
			}

		    }

		}

	    }
	    else if(kc.compareTo(rightPart) == 1)
	    {
		if(t.compareTo(BigDecimal.ONE) == 1 && (kc.compareTo(
			returnRightPart(installmentAmountList, periodInMonthList, t.subtract(BigDecimal.ONE))) == -1))
		{
		    t = t.subtract(BigDecimal.ONE);
		}
		else
		{
		    t = BigDecimal.ZERO;
		}

	    }
	    else
	    {
		flag = false;
	    }

	}
	return t;

    }
	/**
	 * //Added By Manoj on 09/08/2017 for DB170110 
	 * To calulate the grace period profit 
	 * @param islamicCalculatorCO
	 * @return
	 * @throws BaseException
	 */
    private IslamicCalculatorCO calculateGracePeriodMultipleYieldProfit(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
    	islamicCalculatorCO.setCalculateMultipleYieldProfitForGracePeriod("N");
    	if(islamicCalculatorCO.getTrsDealMultipleYieldVO() == null || islamicCalculatorCO.getTrsDealMultipleYieldVO().isEmpty() ){
    		return islamicCalculatorCO;
    	}
    	
    	Date dealFirstPaymentDate = null;
    	Date dealValueDate = null;
    	
    	if(NumberUtil.nullToZero(islamicCalculatorCO.getDealNo()).compareTo(BigDecimal.ZERO) ==1  ){
    		TRSDEALVOKey trsdealvoKey = new TRSDEALVOKey();
        	TRSDEALVO trsdealvo = null;
        	
        	trsdealvoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
        	trsdealvoKey.setBRANCH_CODE(islamicCalculatorCO.getBranchCode());
        	trsdealvoKey.setSERIAL_NO(islamicCalculatorCO.getDealNo());
        	if(islamicCalculatorCO.getDisbursementScreen())
        	{
        		trsdealvoKey.setSERIAL_NO(islamicCalculatorCO.getLinkedDealNo());
        	}
        	trsdealvo = (TRSDEALVO) genericDAO.selectByPK(trsdealvoKey);
        	if(trsdealvo != null && trsdealvo.getPAYMENT_PLAN_NBR() != null){
        		TRSPAYPLANVO trspayplanvo = new TRSPAYPLANVO();
        		trspayplanvo.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
        		trspayplanvo.setBRANCH(islamicCalculatorCO.getBranchCode());
        		trspayplanvo.setPLAN_NBR(trsdealvo.getPAYMENT_PLAN_NBR());
        		
        		dealFirstPaymentDate = iisIslamicCalculatorDAO.returnDealFirstPaymentDate(trspayplanvo);
        		dealValueDate = trsdealvo.getVALUE_DATE();
        	}
    	}else{
    		dealFirstPaymentDate = islamicCalculatorCO.getFirstPaymentDate();
    		
    	}
    	dealValueDate = islamicCalculatorCO.getValueDate();
    	if(dealFirstPaymentDate == null){
    		dealFirstPaymentDate = islamicCalculatorCO.getFirstPaymentDate();
    	}
    	if(dealValueDate == null){
    		dealValueDate = islamicCalculatorCO.getValueDate();
    	}
    	BigDecimal ldec_outstanding_principle =  islamicCalculatorCO.getDealAmount().add(NumberUtil.nullToZero(islamicCalculatorCO.getTotalCharges()))
    			.add(NumberUtil.nullToZero(islamicCalculatorCO.getTotalInsurance())) ;
    	
	double chargesExcludingProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalCharges())
		- NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnCharges());
	double insuranceExcludingProfitCalc = NumberUtil.toDoubleObj(islamicCalculatorCO.getTotalInsurance())
		- NumberUtil.toDoubleObj(islamicCalculatorCO.getProfitOnInsurance());

	ldec_outstanding_principle = ldec_outstanding_principle
		.subtract(BigDecimal.valueOf(NumberUtil.nullToZero(chargesExcludingProfitCalc))
			.add(BigDecimal.valueOf(NumberUtil.nullToZero(insuranceExcludingProfitCalc))));

    	BigDecimal lineNo = BigDecimal.ONE;
    	for (int i = 0; i < islamicCalculatorCO.getTrsDealMultipleYieldVO().size(); i++) {
    		Date ldt_criteria_from_date = islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i).getFROM_DATE();
    		Date ldt_criteria_to_date = dealFirstPaymentDate;
    		
    		if(ldt_criteria_from_date.before(dealFirstPaymentDate)){
    			if(ldt_criteria_from_date.before(dealValueDate)){
    				ldt_criteria_from_date = dealValueDate;
    			}
    			BigDecimal ldec_criteria_yield = NumberUtil.nullToZero(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i).getMARGIN_RATE());
    			ldec_criteria_yield = ldec_criteria_yield.add(NumberUtil.nullToZero(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i).getFLOATING_RATE()));
    			
    			BigDecimal ldec_maximum_yield = NumberUtil.nullToZero(islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i).getMAXIMUM_YIELD());
    			BigDecimal ldec_minimum_yield = BigDecimal.ZERO;
    			
    			if(ldec_criteria_yield.compareTo(ldec_minimum_yield) == -1 ){
    				ldec_criteria_yield = ldec_minimum_yield;
    			}
    			if( ldec_maximum_yield.compareTo(BigDecimal.ZERO) == 1 && ldec_criteria_yield.compareTo(ldec_maximum_yield) == 1){
    				ldec_criteria_yield = ldec_maximum_yield;
    			}
    			
    			if (i + 1 >  islamicCalculatorCO.getTrsDealMultipleYieldVO().size() - 1){
    				ldt_criteria_to_date = dealFirstPaymentDate;
    			}else{
    				ldt_criteria_to_date = islamicCalculatorCO.getTrsDealMultipleYieldVO().get(i+1).getFROM_DATE();
    			}
    			if(ldt_criteria_to_date.after(dealFirstPaymentDate)){
    				ldt_criteria_to_date = dealFirstPaymentDate;
    			}
    			
    			Double ldc_total_profit = 	calculateProfitAmount(islamicCalculatorCO, ldt_criteria_from_date, ldt_criteria_to_date, ldec_outstanding_principle.doubleValue(), 
    					0L, 0D, ldec_criteria_yield.doubleValue(), "N");
    			if(ldc_total_profit > 0){
    				if(ldt_criteria_from_date.before(dealValueDate)){
    					if (islamicCalculatorCO.getTrspayplan_BREAKUP_PROFITVs() != null && !islamicCalculatorCO.getTrspayplan_BREAKUP_PROFITVs().isEmpty()){
    						islamicCalculatorCO.getTrspayplan_BREAKUP_PROFITVs().get(1).setPROFIT_AMOUNT(BigDecimal.valueOf(ldc_total_profit));
    						islamicCalculatorCO.getTrspayplan_BREAKUP_PROFITVs().get(1).setTO_DATE(ldt_criteria_to_date);
    						islamicCalculatorCO.getTrspayplan_BREAKUP_PROFITVs().get(1).setFROM_DATE(ldt_criteria_from_date);
    						islamicCalculatorCO.getTrspayplan_BREAKUP_PROFITVs().get(1).setYIELD(ldec_criteria_yield);
    						islamicCalculatorCO.getTrspayplan_BREAKUP_PROFITVs().get(1).setLINE_NO(BigDecimal.ONE);
    						islamicCalculatorCO.getTrspayplan_BREAKUP_PROFITVs().get(1).setDEAL_AMOUNT(ldec_outstanding_principle);
    					}
    				}else{
    					
	    				TRSPAYPLAN_BREAKUP_PROFITVO breakup_PROFITVO = new TRSPAYPLAN_BREAKUP_PROFITVO();
	    				breakup_PROFITVO.setPROFIT_AMOUNT(BigDecimal.valueOf(ldc_total_profit));
	    				breakup_PROFITVO.setTO_DATE(ldt_criteria_to_date);
	    				breakup_PROFITVO.setFROM_DATE(ldt_criteria_from_date);
	    				breakup_PROFITVO.setYIELD(ldec_criteria_yield);
	    				breakup_PROFITVO.setLINE_NO(lineNo);
	    				breakup_PROFITVO.setDEAL_AMOUNT(ldec_outstanding_principle);
	    				
	    				islamicCalculatorCO.getTrspayplan_BREAKUP_PROFITVs().add(breakup_PROFITVO);
    				}
    				
    				lineNo = lineNo.add(BigDecimal.ONE);
    				islamicCalculatorCO.setCalculateMultipleYieldProfitForGracePeriod("Y");
    			}
    		}
		}
    	
//    	calculateProfitAmount(islamicCalculatorCO, dateFrom, Date dateToParam,
//    		    Double amountParam, Long adjustDays, Double chargesAndInsuranceExcludingProfitCals, Double yeildPercent,
//    		    String capitalize)
    	
    	return 	islamicCalculatorCO;
    }
 
    private BigDecimal calculateAdditionalGracePeriodPRofit(IslamicCalculatorCO islamicCalculatorCO, Date fromDate, Date toDate) throws BaseException
    {
    	BigDecimal profitAmount = BigDecimal.ZERO;
    	
    	
    	if(NumberUtil.nullToZero(islamicCalculatorCO.getDealNo()).compareTo(BigDecimal.ZERO) != 1  ){
    		return profitAmount;
    	}
    	
    	TRSPAYPLANVO trspayplanvo = new TRSPAYPLANVO();
        trspayplanvo.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
        trspayplanvo.setBRANCH(islamicCalculatorCO.getBranchCode());
        trspayplanvo.setPLAN_NBR(islamicCalculatorCO.getPlanNbr());
        if(islamicCalculatorCO.getDisbursementScreen())
    	{
        trspayplanvo.setPLAN_NBR(islamicCalculatorCO.getLinkedDealPlanNbr());
    	}
        
        Date dealFirstPaymentDate = iisIslamicCalculatorDAO.returnDealFirstPaymentDate(trspayplanvo);
        if(dealFirstPaymentDate == null){
        	return profitAmount;
        }
        
        if (fromDate.after(dealFirstPaymentDate)){
        	return profitAmount;
        }
        
	if(!islamicCalculatorCO.getValueDate().before(dealFirstPaymentDate))
	{
	    return profitAmount;
	}

        List<TRSPAYPLAN_BREAKUP_PROFITVO> trspayplan_BREAKUP_PROFITVs = iisIslamicCalculatorDAO.returnTRSPAYPLAN_BREAKUP_PROFITList(trspayplanvo);
        if(trspayplan_BREAKUP_PROFITVs == null || trspayplan_BREAKUP_PROFITVs.isEmpty()){
        	return profitAmount;
        }
        Date ldt_calc_to_date;
        BigDecimal  ldc_line_profit;
        Long ll_actual_days, ll_days;
        
        ldt_calc_to_date = toDate;
        for (int i = 0; i < trspayplan_BREAKUP_PROFITVs.size() ; i++) 
        {
        	ldt_calc_to_date= toDate;
        	ldc_line_profit = NumberUtil.nullToZero(trspayplan_BREAKUP_PROFITVs.get(i).getPROFIT_AMOUNT());
        	Date ldt_criteria_to_date = trspayplan_BREAKUP_PROFITVs.get(i).getTO_DATE();
        	Date ldt_criteria_from_date = trspayplan_BREAKUP_PROFITVs.get(i).getFROM_DATE();
        	
        	if(ldt_criteria_from_date.after(ldt_calc_to_date)){
        		continue;
        	} 
        	if(ldt_calc_to_date.after(ldt_criteria_to_date) ){
        		ldt_calc_to_date = ldt_criteria_to_date; 
        	}
        	if(i < trspayplan_BREAKUP_PROFITVs.size() -1 ){
        		Date ldt_criteria_next_from_date = trspayplan_BREAKUP_PROFITVs.get(i+1).getFROM_DATE();
        		if(ldt_calc_to_date.after(ldt_criteria_next_from_date) ){
            		ldt_calc_to_date = ldt_criteria_next_from_date; 
            	}
        	}
        	ll_actual_days = DateUtil.numberOfDays(ldt_criteria_from_date, ldt_criteria_to_date);
        	ll_days = DateUtil.numberOfDays(ldt_criteria_from_date, ldt_calc_to_date);
        	
        	if(ll_days < 0){
        		continue;
        	}
        	
        	if(ll_actual_days <= 0) ll_actual_days = 0L;
        	profitAmount = profitAmount.add(ldc_line_profit.divide(BigDecimal.valueOf(ll_actual_days), 12, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(ll_days)));
        	ldt_calc_to_date = ldt_criteria_from_date;
		}
        
        
    	return profitAmount;
    }
    
    /**
     * Method for validation RepayamentCriteriaList
     * 
     * schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO validateOneObligorGlobalLimit(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getFacilityNbr()).compareTo(BigDecimal.ZERO) != 1)
	{
	    return islamicCalculatorEventMgmtCO;
	}
	// **************************** START NIZI120160 **************
	FmsOneObligorDetCO fmsOneObligorDetCO = new FmsOneObligorDetCO();
	fmsOneObligorDetCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	fmsOneObligorDetCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	fmsOneObligorDetCO.setUserId(islamicCalculatorEventMgmtCO.getUserId());
	fmsOneObligorDetCO.setCounterParty(islamicCalculatorEventMgmtCO.getCifNo());
	fmsOneObligorDetCO.setDealNo(BigDecimal.ZERO);
	fmsOneObligorDetCO.setDealAmount(islamicCalculatorEventMgmtCO.getPurchaseAmount());
	fmsOneObligorDetCO.setDealYeild(islamicCalculatorEventMgmtCO.getAnnualYieldRate());
	fmsOneObligorDetCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	fmsOneObligorDetCO.setDealRate(islamicCalculatorEventMgmtCO.getFloatingRate());

	CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getCurrencyCode());
	CURRENCIESVO currenciesVO = (CURRENCIESVO) genericDAO.selectByPK(currenciesVOKey);

	fmsOneObligorDetCO.setMultiDiv(currenciesVO.getMULT_DIV_IND());
	fmsOneObligorDetCO.setCurrencyUnit(currenciesVO.getUNIT());
	currenciesVOKey = null;
	currenciesVO = null;
	fmsOneObligorDetCO.setGeneralType("P");
	fmsOneObligorDetCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	fmsOneObligorDetCO.setCashFinanceFlag(ConstantsCommon.YES);
	fmsOneObligorDetCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	fmsOneObligorDetCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());

	TRSCLASSVO trsclassVO = new TRSCLASSVO();
	trsclassVO.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	trsclassVO.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	trsclassVO = commonLibBO.returnTrsClassVO(trsclassVO);
	if(trsclassVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	if(islamicCalculatorEventMgmtCO.getStartDate().equals(islamicCalculatorEventMgmtCO.getMaturityDate())
		&& trsclassVO.getCATEGORY().compareTo(BigDecimal.valueOf(13)) != 0
		&& trsclassVO.getCATEGORY().compareTo(BigDecimal.valueOf(17)) != 0)
	{
	    fmsOneObligorDetCO.setDealType("MMO");
	}

	fmsOneObligorDetCO.setRunningDate(islamicCalculatorEventMgmtCO.getRunningDate());
	fmsOneObligorDetCO.setFacilityBranch(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getFacilityBranch()));
	fmsOneObligorDetCO.setFromFacility(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getFacilityNbr()));
	fmsOneObligorDetCO.setSubLimitNo(BigDecimal.ZERO);
	fmsOneObligorDetCO.setDrawdownNo(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getDrawDownCode()));
	fmsOneObligorDetCO.setDrawDownBranch(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getDrawDownBranch()));
	// fmsOneObligorDetCO.setAmount(settlementCO.getTrsdealvo().getDEAL_AMOUNT());
	// fmsOneObligorDetCO.setLimitFlag(limitFlag);
	// fmsOneObligorDetCO.setDrawDownStatus(drawDownStatus);
	fmsOneObligorDetCO.setAmountWithCompany(islamicCalculatorEventMgmtCO.getPurchaseAmount());
	fmsOneObligorDetCO.setAmountWithClient(BigDecimal.ZERO);
	// fmsOneObligorDetCO.setUnUtilzed(unUtilzed);
	// fmsOneObligorDetCO.setTrsNo(settlementCO.getTrsdealvo().getSERIAL_NO());
	fmsLimitsCommonBO.executeProcValidateOneObligorGlobalLimit(fmsOneObligorDetCO);
	// ******************** END NIZI120160 ********************************
	return islamicCalculatorEventMgmtCO;

    }

    public void setFmsLimitsCommonBO(FmsLimitsCommonBO fmsLimitsCommonBO)
    {
	this.fmsLimitsCommonBO = fmsLimitsCommonBO;
    }

    public void validateDealChargesList(List<TrsDealChargesCO> trsDealChargesVOlist) throws BaseException
    {
	if(trsDealChargesVOlist != null)
	{
	    for(TRSDEALCHARGESVO trsDealChargesVO : trsDealChargesVOlist)
	    {
		if((trsDealChargesVO.getCR_ACC_BRANCH() == null
			|| NumberUtil.toDouble(trsDealChargesVO.getCR_ACC_BRANCH()) < 0)
			|| (trsDealChargesVO.getCR_ACC_CURRENCY() == null
				|| NumberUtil.toDouble(trsDealChargesVO.getCR_ACC_CURRENCY()) < 0)
			|| (trsDealChargesVO.getCR_ACC_GL() == null
				|| NumberUtil.toDouble(trsDealChargesVO.getCR_ACC_GL()) < 0)
			|| (trsDealChargesVO.getCR_ACC_CIF_SUB_NO() == null
				|| NumberUtil.toDouble(trsDealChargesVO.getCR_ACC_CIF_SUB_NO()) < 0)
			|| (trsDealChargesVO.getCR_ACC_SL_NO() == null
				|| NumberUtil.toDouble(trsDealChargesVO.getCR_ACC_SL_NO()) < 0))
		{
		    throw new BOException(MessageCodes.INVALID_CHARGE_ACCOUNT);
		}
		if(trsDealChargesVO.getCHARGES_CODE() == null
			|| NumberUtil.toDouble(trsDealChargesVO.getCHARGES_CODE()) < 0)
		{
		    throw new BOException(MessageCodes.INVALID_CHARGE_CODE);
		}
		if(trsDealChargesVO.getCHARGES_AMOUNT() == null
			|| NumberUtil.toDouble(trsDealChargesVO.getCHARGES_AMOUNT()) < 0)
		{
		    throw new BOException(MessageCodes.INVALID_CHARGE_AMOUNT);
		}
		if(trsDealChargesVO.getCHARGES_AMT_CV() == null
			|| NumberUtil.toDouble(trsDealChargesVO.getCHARGES_AMT_CV()) < 0)
		{
		    throw new BOException(MessageCodes.INVALID_CHARGE_AMOUNT_CV);
		}
		if(trsDealChargesVO.getCHARGES_AMT_FC() == null
			|| NumberUtil.toDouble(trsDealChargesVO.getCHARGES_AMT_FC()) < 0)
		{
		    throw new BOException(MessageCodes.INVALID_CHARGE_AMOUNT_FC);
		}
		TRSCHARGESVO trsChargesVO = new TRSCHARGESVO();
		BigDecimal compCode = NumberUtil.nullToZero(trsDealChargesVO.getCOMP_CODE());
		trsChargesVO.setCOMP_CODE(compCode);
		trsChargesVO.setCODE(NumberUtil.nullToZero(trsDealChargesVO.getCHARGES_CODE()));
		trsChargesVO = (TRSCHARGESVO) genericDAO.selectByPK(trsChargesVO);
		if(trsChargesVO == null)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_CHARGE_CODE);
		}
		BigDecimal vatCode = trsDealChargesVO.getVAT_CODE();
		if(NumberUtil.nullToZero(vatCode).compareTo(BigDecimal.ZERO) == 1)
		{
		    TRSVATVO trsVatvo = new TRSVATVO();
		    trsVatvo.setCOMP_CODE(compCode);

		    trsVatvo.setVAT_CODE(vatCode);
		    trsVatvo = (TRSVATVO) genericDAO.selectByPK(trsVatvo);
		    if(trsVatvo == null)
		    {
			throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
		    }
		}
	    }
	}
    }

    /**
     * Method for getting the first payment date based on periodicity type.
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     */
    public Date getFirstPaymentDate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
    {
	Date firstPaymentDate = null;
	Date valueDate = islamicCalculatorEventMgmtCO.getStartDate();
	// String periodicityType =
	// islamicCalculatorEventMgmtCO.getPaymPeriodicity();//TODO -Navas
	// comment service team should check
	String periodicityType = islamicCalculatorEventMgmtCO.getGracePeriodicity();
	try
	{
	    // if(islamicCalculatorEventMgmtCO.getPaymPeriodNbr() != null)//TODO
	    // -Navas comment service team should check
	    if(islamicCalculatorEventMgmtCO.getGracePeriod() == null)
	    {
		firstPaymentDate = valueDate;
	    }
	    else
	    {
		// int periodicityNumber =
		// NumberUtil.toInt(islamicCalculatorEventMgmtCO.getPaymPeriodNbr());//TODO
		// -Navas comment service team should check
		int periodicityNumber = NumberUtil.toInt(islamicCalculatorEventMgmtCO.getGracePeriod());
		if(IISCommonConstants.PERIODICITY_TYPE_D.equalsIgnoreCase(periodicityType))
		{
		    firstPaymentDate = DateUtil.relativeDate(valueDate, periodicityNumber);
		}
		else if(IISCommonConstants.PERIODICITY_TYPE_W.equalsIgnoreCase(periodicityType))
		{
		    firstPaymentDate = DateUtil.relativeDate(valueDate, periodicityNumber * 7);
		}
		else if(IISCommonConstants.PERIODICITY_TYPE_M.equalsIgnoreCase(periodicityType))
		{
		    firstPaymentDate = DateUtil.relativeMonth(valueDate, periodicityNumber);
		}
		else if(ConstantsCommon.YES.equalsIgnoreCase(periodicityType))
		{
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(valueDate);
		    int valueDateYear = cal.get(Calendar.YEAR);
		    valueDateYear = +periodicityNumber;
		    cal.add(Calendar.YEAR, valueDateYear);
		    firstPaymentDate = cal.getTime();
		    cal = null;
		}
		else
		{
		    firstPaymentDate = valueDate;
		}
	    }
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return firstPaymentDate;
    }

    /**
     * Moved From IslamicCalculatorEventMgmtBOImpl for BB Web Service
     * 
     * Fawas.Kuruvakkottil; 13/02/2018 [Start]
     *
     * Method for validation RepayamentCriteriaList
     * 
     * schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO validateRepayamentCriteriaList(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO() != null)
	{
	    for(TRSPAYPLAN_CRITERIAVO eachTrspayplanCRITERIAVO : islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO())
	    {
		if(eachTrspayplanCRITERIAVO.getFROM_DATE() == null || eachTrspayplanCRITERIAVO.getTO_DATE() == null
			|| eachTrspayplanCRITERIAVO.getPAYM_PERIODICITY() == null
			|| NumberUtil.emptyDecimalToZero(eachTrspayplanCRITERIAVO.getNO_OF_PAYMENTS())
				.compareTo(BigDecimal.ZERO) < 1
			|| eachTrspayplanCRITERIAVO.getPAYMENT_TYPE() == null
			|| NumberUtil.toDouble(eachTrspayplanCRITERIAVO.getNO_OF_PAYMENTS()) < 0)
		{
		    throw new BOException(MessageCodes.REPAYMENT_PLAN_INCORRECT);
		}
		if(NumberUtil.emptyDecimalToZero(eachTrspayplanCRITERIAVO.getPAYM_PERIOD_NBR())
			.compareTo(BigDecimal.ZERO) < 1)
		{
		    throw new BOException(MessageCodes.PAY_PERIOD_SHOULD_BE_GREATER_THAN_ZERO);
		}
		// TP 677051 Fawas.kuruvakkottil 21/05/2018
		// Added Amount validation
		if((eachTrspayplanCRITERIAVO.getPAYMENT_TYPE() != null
			&& IISCommonConstants.PAYMENT_TYPE_SPECIFIC_AMOUNT
				.equals(eachTrspayplanCRITERIAVO.getPAYMENT_TYPE()))
			&& NumberUtil.nullToZero(eachTrspayplanCRITERIAVO.getCAPITAL_AMT()).equals(BigDecimal.ZERO))
		{
		    throw new BOException(
			    MessageCodes.AMOUNT_SHOULD_BE_GREATER_THAN_ZERO_FOR_PAYMENT_TYPE_SPECIFIC_AMOUNT);
		}

		if(eachTrspayplanCRITERIAVO.getPAYM_PERIODICITY() != null
			&& IISCommonConstants.PERIODICITY_TYPE_M.equals(eachTrspayplanCRITERIAVO.getPAYM_PERIODICITY())
			&& eachTrspayplanCRITERIAVO.getPAYM_PERIOD_POS() == null)
		{
		    throw new BOException(MessageCodes.REPAYMENT_PLAN_INCORRECT);
		}
		else if(eachTrspayplanCRITERIAVO.getPAYM_PERIODICITY() != null
			&& IISCommonConstants.PERIODICITY_TYPE_M.equals(eachTrspayplanCRITERIAVO.getPAYM_PERIODICITY())
			&& eachTrspayplanCRITERIAVO.getPAYM_PERIOD_POS() != null
			&& IISCommonConstants.PERIODICITY_TYPE_D.equals(eachTrspayplanCRITERIAVO.getPAYM_PERIOD_POS())
			&& (eachTrspayplanCRITERIAVO.getPAYM_DAY() == null
				|| NumberUtil.toInt(eachTrspayplanCRITERIAVO.getPAYM_DAY()) < 0))
		{
		    throw new BOException(MessageCodes.REPAYMENT_PLAN_INCORRECT);
		}

	    }
	    if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().size() == 1)
	    {
		// TP#212543; Ramesh ; 09/10/2014 [commented below if
		// condition]
		if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().get(0).getTO_DATE()
			.compareTo(islamicCalculatorEventMgmtCO.getMaturityDate()) != 0)
		{
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId("902398");
		    islamicCalculatorEventMgmtCO.setParamList(new String[] { DateUtil
			    .format(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().get(0).getTO_DATE()) });
		}
		islamicCalculatorEventMgmtCO
			.setMaturityDate(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().get(0).getTO_DATE());
		islamicCalculatorEventMgmtCO
			.setStartDate(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().get(0).getFROM_DATE());
		islamicCalculatorEventMgmtCO.setGracePeriodicity(
			islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().get(0).getPAYM_PERIODICITY());
		islamicCalculatorEventMgmtCO.setGracePeriod(
			islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().get(0).getPAYM_PERIOD_NBR());
		islamicCalculatorEventMgmtCO.setFirstPaymentDate(getFirstPaymentDate(islamicCalculatorEventMgmtCO));

		// }

	    }
	    else if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().size() > 1)
	    {
		Date maxDate = null;
		for(int i = 0; i < islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().size() - 1; i++)
		{
		    for(int j = 0; j < islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().size() - 1; j++)
		    {
			if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().get(i).getTO_DATE()
				.after(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().get(j + 1).getTO_DATE()))
			{
			    maxDate = islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().get(i).getTO_DATE();
			}
			else
			{
			    maxDate = islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().get(j + 1).getTO_DATE();
			}
		    }

		}
		if(maxDate != null && maxDate.compareTo(islamicCalculatorEventMgmtCO.getMaturityDate()) != 0)
		{
		    islamicCalculatorEventMgmtCO.setMaturityDate(maxDate);
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId("902398");
		}

	    }
	}
	return islamicCalculatorEventMgmtCO;

    }

    public IslamicCalculatorCO createRepaymentPlanService(IslamicCalculatorCO islamicCalculatorCOParam,
	    Date runningDate, String salaryWithBank) throws BaseException
    {
	BigDecimal limitSerialNo = NumberUtil.nullToZero(islamicCalculatorCOParam.getLimitSerialNo());
	BigDecimal productClassCode = islamicCalculatorCOParam.getProductClassCode();
	if(limitSerialNo.compareTo(BigDecimal.ZERO) == 0 && NumberUtil.isEmptyDecimal(productClassCode))
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	TRSCLASSVO trsclassvo = new TRSCLASSVO();
	trsclassvo.setCOMP_CODE(islamicCalculatorCOParam.getCompanyCode());
	trsclassvo.setCODE(NumberUtil.nullToZero(productClassCode));
	trsclassvo = commonLibBO.returnTrsClassVO(trsclassvo);
	if(trsclassvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	if(NumberUtil.isEmptyDecimal(islamicCalculatorCOParam.getAnnualYeild()))
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setSalaryWithBank(salaryWithBank);
	    iisCommonCO.setNoOfPayments(islamicCalculatorCOParam.getNoOfPayments());
	    iisCommonCO.setBranchCode(islamicCalculatorCOParam.getBranchCode());
	    iisCommonCO.setProductClass(islamicCalculatorCOParam.getProductClassCode());
	    iisCommonCO.setCifNo(islamicCalculatorCOParam.getCifNo());
	    iisCommonCO.setPaymPeriodicity(islamicCalculatorCOParam.getPaymentPeriodicity());
	    iisCommonCO.setRosterDealAmount(NumberUtil.nullToZero(islamicCalculatorCOParam.getDealAmount()));
	    iisCommonCO.setPartyType("B");// Both
	    iisCommonCO.setCompCode(islamicCalculatorCOParam.getCompanyCode());
	    iisCommonCO = iisCommonBO.returnYieldFromRegister(iisCommonCO);
	    if(NumberUtil.isEmptyDecimal(iisCommonCO.getOrginalYield()))
	    {
		throw new BOException(MessageCodes.Invalid_Code, new String[] { "Invalid/Missing Annual Yield" });
	    }
	    else
	    {
		islamicCalculatorCOParam.setAnnualYeild(iisCommonCO.getOrginalYield());

	    }
	}

	if(limitSerialNo.compareTo(BigDecimal.ZERO) == 1)
	{
	    TRSCIFLIMITDETVO trsciflimitdetvoKey = new TRSCIFLIMITDETVO();
	    trsciflimitdetvoKey.setCOMP_CODE(islamicCalculatorCOParam.getCompanyCode());
	    trsciflimitdetvoKey.setBRANCH_CODE(islamicCalculatorCOParam.getBranchCode());
	    trsciflimitdetvoKey.setSERIAL_NO(limitSerialNo);

	    TRSCIFLIMITDETVO trsciflimitdetvo = iisIslamicCalculatorDAO.returnTRSCIFLIMITDET(trsciflimitdetvoKey);
	    if(trsciflimitdetvo == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_LIMIT_SERIAL_NO);
	    }

	    if(NumberUtil.emptyDecimalToZero(islamicCalculatorCOParam.getCifNo()).compareTo(BigDecimal.ZERO) == 1
		    && islamicCalculatorCOParam.getCifNo().compareTo(trsciflimitdetvo.getCIF()) != 0)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_LIMIT_SERIAL_NO);
	    }

	    if(NumberUtil.nullToZero(productClassCode).compareTo(BigDecimal.ZERO) == 1
		    && productClassCode.compareTo(trsciflimitdetvo.getCLASS()) != 0)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_LIMIT_SERIAL_NO);
	    }

	    trsciflimitdetvoKey = null;
	    trsclassvo.setCALCULATE_PROFIT(trsciflimitdetvo.getPROFIT_CALCULATION_METHOD());
	    trsclassvo.setPROFIT_DIST_METHOD(trsciflimitdetvo.getPROFIT_DIST_METHOD());
	    trsclassvo.setPRINCIPAL_LAST(trsciflimitdetvo.getPRINCIPAL_LAST());
	    trsclassvo.setNO_OF_PAYMENTS(trsciflimitdetvo.getNO_OF_PAYMENTS());
	    trsclassvo.setROUNDING_FACTOR(trsciflimitdetvo.getROUNDING_FACTOR());
	    trsclassvo.setPAY_RES_AMT(trsciflimitdetvo.getPAY_RES_AMT());
	    trsclassvo.setPAYM_PERIODICITY(trsciflimitdetvo.getPAYM_PERIODICITY());
	    if(trsciflimitdetvo.getPAYM_PERIOD_NBR() != null)
	    {
		trsclassvo.setPAYM_PERIOD_NBR(new BigDecimal(trsciflimitdetvo.getPAYM_PERIOD_NBR()));
	    }
	    trsclassvo.setPAYM_PERIOD_POS(trsciflimitdetvo.getPAYM_PERIOD_POS());
	    trsclassvo.setGRACE_PERIOD_OPTION(trsciflimitdetvo.getGRACE_PERIOD_OPTION());
	    trsclassvo.setGRACE_PERIOD(trsciflimitdetvo.getGRACE_PERIOD());
	    trsclassvo.setGRACE_PERIODICITY(trsciflimitdetvo.getGRACE_PERIODICITY());
	    if(NumberUtil.isEmptyDecimal(islamicCalculatorCOParam.getProductClassCode()))
	    {
		islamicCalculatorCOParam.setProductClassCode(trsciflimitdetvo.getCLASS());
	    }

	}
	if(StringUtil.isEmptyString(trsclassvo.getPROFIT_DIST_METHOD()))
	{
	    trsclassvo.setPROFIT_DIST_METHOD(trsclassvo.getCALCULATE_PROFIT());
	}

	if(StringUtil.isEmptyString(islamicCalculatorCOParam.getProfitCalculationMethod()))
	{
	    String calculateProfit = trsclassvo.getCALCULATE_PROFIT();
	    if("L".equals(calculateProfit))
	    {
		calculateProfit = IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE;
	    }
	    else
	    {
		calculateProfit = IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS;
	    }
	    islamicCalculatorCOParam.setProfitCalculationMethod(calculateProfit);
	}
	if(StringUtil.isEmptyString(islamicCalculatorCOParam.getProfitRecognitionMethod()))
	{
	    islamicCalculatorCOParam.setProfitRecognitionMethod(trsclassvo.getPROFIT_DIST_METHOD());
	}
	if(StringUtil.isEmptyString(islamicCalculatorCOParam.getPrincipalInLastPayment()))
	{
	    islamicCalculatorCOParam.setPrincipalInLastPayment(trsclassvo.getPRINCIPAL_LAST());
	}
	if(NumberUtil.isEmptyDecimal(islamicCalculatorCOParam.getNoOfPayments()))
	{
	    islamicCalculatorCOParam.setNoOfPayments(trsclassvo.getNO_OF_PAYMENTS());
	}
	if(islamicCalculatorCOParam.getRoundingFactor() == null)
	{
	    islamicCalculatorCOParam.setRoundingFactor(trsclassvo.getROUNDING_FACTOR().longValue());
	}
	if(StringUtil.isEmptyString(islamicCalculatorCOParam.getResidualValue()))
	{
	    islamicCalculatorCOParam.setResidualValue(trsclassvo.getPAY_RES_AMT());

	}
	String paym_PERIODICITY = trsclassvo.getPAYM_PERIODICITY();
	if(StringUtil.isEmptyString(islamicCalculatorCOParam.getResidualValue()))
	{
	    islamicCalculatorCOParam.setPaymentPeriodicity(paym_PERIODICITY);
	}
	if(islamicCalculatorCOParam.getFirstPaymentDate() == null)
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setPaymPeriodicity(paym_PERIODICITY);
	    iisCommonCO.setPaymPeriodPos(trsclassvo.getPAYM_PERIOD_POS());
	    iisCommonCO.setGracePeriod(trsclassvo.getGRACE_PERIOD());
	    iisCommonCO.setGracePeriodicity(trsclassvo.getGRACE_PERIODICITY());
	    iisCommonCO.setMaturityDate(islamicCalculatorCOParam.getMaturityDate());
	    iisCommonCO.setCommencementDate(islamicCalculatorCOParam.getValueDate());
	    iisCommonCO.setCompCode(islamicCalculatorCOParam.getCompanyCode());
	    iisCommonCO.setProductClass(islamicCalculatorCOParam.getProductClassCode());
	    iisCommonCO = iisCommonBO.returnFirstdate(iisCommonCO);
	    islamicCalculatorCOParam.setFirstPaymentDate(iisCommonCO.getFirstPayDate());
	}
	islamicCalculatorCOParam.setCalledFromApp(IISCommonConstants.CALLED_FROM_WS);
	islamicCalculatorCOParam = createRepaymentPlan(islamicCalculatorCOParam);
	return islamicCalculatorCOParam;

    }

    /**
     * Method for populating data based on no of balloons
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeNoOfBalloons(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments() != null
		&& islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	{
	    double noOfBaloonPayments = NumberUtil.toInt(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    if(noOfBaloonPayments < 0)
	    {
		throw new BOException(MessageCodes.NO_OF_BALLOONS_CANNOT_BE_LESS_THAN_ZERO);
	    }
	    // BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
	    if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getFlexiPaymentYn())
		    && NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments())
			    .compareTo(BigDecimal.ZERO) == 1)
	    {
		throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_NOT_APPLICABLE_WITH_BALLOON_PAYMENT);
	    }
	    // BB160136; Saheer.Naduthodi; 20/04/2017 [End]
	    Date startDate = islamicCalculatorEventMgmtCO.getStartDate();
	    Date maturityDate = islamicCalculatorEventMgmtCO.getMaturityDate();
	    double daysafter = DateUtil.numberOfDays(startDate, maturityDate, "dd/MM/yyyy");
	    startDate = null;
	    maturityDate = null;

	    if(noOfBaloonPayments > 0)
	    {
		if(noOfBaloonPayments > 999)
		{
		    // PLEASE_SPECIFY_AN_INTEGER_VALUE_LESS_THAN_EQUAL_TO_999
		    throw new BOException(MessageCodes.SPECIFY_INT_VALUE_LESS_THAN_EQUAL_TO_999);
		}
		if(noOfBaloonPayments > (daysafter + 1))// need to check the
		// date function
		{
		    throw new BOException(MessageCodes.SPECIFY_AN_INT_VAL_LESS_EQUAL_DEAL_PRD);
		}
	    }
	    else
	    {
		islamicCalculatorEventMgmtCO.setBaloonPercentage((BigDecimal.ZERO));
		islamicCalculatorEventMgmtCO.setBaloonAmount(BigDecimal.ZERO);
		// clear balloon details.
	    }
	    if(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments() != null
		    && doubleValue(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments()) > 0
		    && islamicCalculatorEventMgmtCO.getBaloonAmount() != null
		    && doubleValue(islamicCalculatorEventMgmtCO.getBaloonAmount()) > 0
		    && islamicCalculatorEventMgmtCO.getBaloonPercentage() != null
		    && doubleValue(islamicCalculatorEventMgmtCO.getBaloonPercentage()) > 0)
	    {
		populateBaloonPaymentGrid(islamicCalculatorEventMgmtCO);
	    }
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating data based on Balloon Payment Amount
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeBalloonPaymentAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getBaloonAmount() != null)
	{
	    if(NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getBaloonAmount()) < 0)
	    {
		throw new BOException(MessageCodes.BALLOON_AMOUNT_CANNOT_BE_LESS_THAN_ZERO);

	    }
	    islamicCalculatorEventMgmtCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	    if(NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getBaloonAmount()) > NumberUtil
		    .toDouble(islamicCalculatorEventMgmtCO.getDealAmount()))
	    {
		throw new BOException(MessageCodes.BALLOON_AMT_CANT_BE_GREATER_THAN_FIN_AMT);

	    }
	    if(islamicCalculatorEventMgmtCO.getDealAmount() == null
		    || NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getDealAmount()) == 0)
	    {
		throw new BOException(MessageCodes.ENTER_FINANCING_AMOUNT);

	    }
	    else
	    {
		double baloonPercentage = NumberUtil
			.round(NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getBaloonAmount())
				/ doubleValue((islamicCalculatorEventMgmtCO.getDealAmount())) * 100, 3);

		IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOMain = populateOnChangeProductClass(
			islamicCalculatorEventMgmtCO);
		BigDecimal baloonAmountMaxPerc = islamicCalculatorEventMgmtCOMain.getBaloonAmountMaxPerc();
		BigDecimal baloonAmountMinPerc = islamicCalculatorEventMgmtCOMain.getBaloonAmountMinPerc();
		islamicCalculatorEventMgmtCOMain = null;

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
		islamicCalculatorEventMgmtCO.setBaloonPercentage(BigDecimal.valueOf(baloonPercentage));
	    }
	}
	if(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments() != null
		&& doubleValue(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments()) > 0
		&& islamicCalculatorEventMgmtCO.getBaloonAmount() != null
		&& doubleValue(islamicCalculatorEventMgmtCO.getBaloonAmount()) > 0
		&& islamicCalculatorEventMgmtCO.getBaloonPercentage() != null
		&& doubleValue(islamicCalculatorEventMgmtCO.getBaloonPercentage()) > 0)
	{
	    populateBaloonPaymentGrid(islamicCalculatorEventMgmtCO);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for populating balloon payment grid
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateBaloonPaymentGrid(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments() != null
		&& islamicCalculatorEventMgmtCO.getNoOfBaloonPayments().intValue() > 0
		&& islamicCalculatorEventMgmtCO.getBaloonAmount() != null
		&& islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	{
	    int count = 1;
	    int noOfBalloonPayments = NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    List<TrsPlanBallonPaymentCO> listBallonPaymentCOs = new ArrayList<TrsPlanBallonPaymentCO>();
	    TrsPlanBallonPaymentCO ballonPaymentCO = new TrsPlanBallonPaymentCO();
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
	    ballonPaymentCO.setBalloonAmount(islamicCalculatorEventMgmtCO.getBaloonAmount());
	    ballonPaymentCO.setBalloonDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    ballonPaymentCO.setBalloonNo(BigDecimal.valueOf(count));
	    ballonPaymentCO.setBaloonAmtFormat(decimalPoints);
	    listBallonPaymentCOs.add(ballonPaymentCO);
	    if(currencyVO.getDECIMAL_POINTS() != null)
	    {
		decimalPoints = currencyVO.getDECIMAL_POINTS();
	    }
	    for(int i = 0; i < noOfBalloonPayments - 1; i++)
	    {
		TrsPlanBallonPaymentCO emptyballonPaymentCO = new TrsPlanBallonPaymentCO();
		emptyballonPaymentCO.setBalloonAmount(BigDecimal.ZERO);
		emptyballonPaymentCO.setBalloonDate(null);
		emptyballonPaymentCO.setBalloonNo(BigDecimal.valueOf(count + 1));
		emptyballonPaymentCO.setBaloonAmtFormat(decimalPoints);
		listBallonPaymentCOs.add(emptyballonPaymentCO);
		count = count + 1;

	    }
	    islamicCalculatorEventMgmtCO.setBalloonDetailsList(listBallonPaymentCOs);
	}
	return islamicCalculatorEventMgmtCO;
    }

    public IslamicCalculatorEventMgmtCO populateOnChangeProductClass(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	return islamicCalculatorEventMgmtCO = iisIslamicCalculatorDAO
		.populateOnChangeProductClass(islamicCalculatorEventMgmtCO);
    }

    /**
     * Moved From IslamicCalculatorEventMgmtBOImpl for BB Web Service
     * 
     * Fawas.Kuruvakkottil; 13/02/2018 [End]
     */
    /**
     * Method for populating data based on profit First Payment After
     * Periodicity
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO populateOnChangeFirstPaymentAfterPeriodicity(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	// Added for fix 89133: Invalid message box while selecting the product
	// class
	islamicCalculatorEventMgmtCO
		.setGracePeriod(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getGracePeriod()));
	// To calculate the First Payment date
	if(doubleValue(islamicCalculatorEventMgmtCO.getGracePeriod()) < 0
		|| islamicCalculatorEventMgmtCO.getGracePeriod() == null)
	{
	    throw new BOException(MessageCodes.INVALID_GRACE_PERIOD);
	}
	if(doubleValue(islamicCalculatorEventMgmtCO.getGracePeriod()) > 32767)
	{
	    throw new BOException(MessageCodes.INVALID_GRACE_PERIOD);
	}
	// TP#237333; Ramesh; Date 05/11/2014 [START]
	if(islamicCalculatorEventMgmtCO.getNoOfPayments() == null)
	{
	    throw new BOException(MessageCodes.INVALID_NUMBER_OF_PAYMENT);
	}
	// TP#237333; Ramesh; Date 05/11/2014 [END]

	if(islamicCalculatorEventMgmtCO.getCompCode() != null && islamicCalculatorEventMgmtCO.getBranchCode() != null
		&& islamicCalculatorEventMgmtCO.getNoOfPayments() != null
		&& islamicCalculatorEventMgmtCO.getPaymPeriodNbr() != null
		&& islamicCalculatorEventMgmtCO.getPaymPeriodicity() != null
		&& islamicCalculatorEventMgmtCO.getPaymPeriodPos() != null
		&& islamicCalculatorEventMgmtCO.getGracePeriod() != null
		&& islamicCalculatorEventMgmtCO.getGracePeriodicity() != null
		&& islamicCalculatorEventMgmtCO.getStartDate() != null
		&& islamicCalculatorEventMgmtCO.getProductClass() != null &&
		// for linchu
		islamicCalculatorEventMgmtCO.getYield() != null &&
		// for linchu
		// islamicCalculatorEventMgmtCO.getFirstPaymentDate()!=null &&
		islamicCalculatorEventMgmtCO.getRunningDate() != null
		&& islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	   // iisCommonCO.setNoOfPayments(
	   //    NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNoOfPayments()).add(BigDecimal.ONE));
	    iisCommonCO.setNoOfPayments(
			    NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNoOfPayments()));
	    iisCommonCO.setPaymPeriodNbr(islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    iisCommonCO.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    iisCommonCO.setPaymPeriodPos(islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    iisCommonCO.setFirstPayDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    iisCommonCO.setGracePeriod(islamicCalculatorEventMgmtCO.getGracePeriod());
	    iisCommonCO.setGracePeriodicity(islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    iisCommonCO.setCommencementDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    iisCommonCO.setRunningDate(islamicCalculatorEventMgmtCO.getRunningDate());
	    iisCommonCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    // for linchu
	    iisCommonCO.setOrginalYield(islamicCalculatorEventMgmtCO.getOrginalYield());
	    // for linchu
	    iisCommonCO.setValue("COMMENCE");
	    iisCommonCO.setLineNo(BigDecimal.ONE);
	    iisCommonCO = iisCommonBO.returnFirstdate(iisCommonCO);
	    islamicCalculatorEventMgmtCO.setFirstPaymentDate(iisCommonCO.getFirstPayDate());
	    iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    // TP#231558;Arun.R.Variyath;15/10/2014
	    islamicCalculatorEventMgmtCO
		    .setGracePeriodActual(BigDecimal.valueOf(returnActualGracePeriod(islamicCalculatorEventMgmtCO)));

	    // System.out.println("First Pay
	    // Date-"+iisCommonCO.getFirstPayDate());
	    // #TAR BB130030 ;Arun R Variyath ; 11/08/2015 [Start]
	    String calcMatDte = StringUtil.nullEmptyToValue(iisCommonBO.returnCalcMatDteFlagValue(iisCommonCO), "N");
	    if("Y".equals(calcMatDte))
	    {
		iisCommonCO.setPaymPeriodPos("D");
	    }
	    // #TAR BB130030 ;Arun R Variyath ; 11/08/2015 [End]

	    if(iisCommonCO.getFirstPayDate().after(iisCommonCO.getMaturityDate()))
	    {
		throw new BOException(MessageCodes.GRACE_PERIOD_CANNOT_BE_AFTER_MAT_DATE);
	    }
	    // To check the Grace period
	    iisCommonBO.checkGracePeriod(iisCommonCO);

	    // To calculate the maturity date
	    iisCommonCO = iisCommonBO.returnMaturitydate(iisCommonCO);
	    islamicCalculatorEventMgmtCO.setMaturityDate(iisCommonCO.getMaturityDate());
	    iisCommonCO = calculateYield(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO.setYield(iisCommonCO.getOrginalYield());
	    iisCommonCO = null;
	}

	// Checking holiday action
	if(islamicCalculatorEventMgmtCO.getCompCode() != null && islamicCalculatorEventMgmtCO.getBranchCode() != null
		&& islamicCalculatorEventMgmtCO.getMaturityDate() != null
		&& islamicCalculatorEventMgmtCO.getCurrencyCode() != null
		&& islamicCalculatorEventMgmtCO.getProductClass() != null)
	{
	    IISHolidayCheckCO iisHolidayCheckCO = new IISHolidayCheckCO();
	    iisHolidayCheckCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisHolidayCheckCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    iisHolidayCheckCO.setDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    iisHolidayCheckCO.setCurrencyCode(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    iisHolidayCheckCO.setDateType("M");
	    IISCommonCO coForHolidayaction = new IISCommonCO();
	    coForHolidayaction.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	    coForHolidayaction.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	    coForHolidayaction.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisHolidayCheckCO.setApplyYearHoliday(iisCommonBO.returnHolidayActionDealDateYn(coForHolidayaction));
	    iisHolidayCheckCO.setProductClassCode(islamicCalculatorEventMgmtCO.getProductClass());
	    iisHolidayCheckCO.setActionCode(iisCommonBO.returnHolidayAction(coForHolidayaction));

	    iisHolidayCheckCO = iisCommonBO.checkValueDateIsHoliday(iisHolidayCheckCO);
	    TRSCLASSVOKey trsClassVOkey = new TRSCLASSVOKey();
	    trsClassVOkey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOkey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonBO.returnHolidayActions(trsClassVOkey);
	    if(iisHolidayCheckCO.getHolidayYn().equals(ConstantsCommon.YES)
		    && trsClassVO.getHOLIDAY_ACTION_WARNING_IND().equals(IISCommonConstants.MESSAGE_TYPEWARNING))
	    {
		// islamicCalculatorEventMgmtCO.setMaturityDate(iisHolidayCheckCO.getNewDate());
		islamicCalculatorEventMgmtCO.setMaturityDateAfterHoliday(iisHolidayCheckCO.getNewDate());
		islamicCalculatorEventMgmtCO.setConfirmationMessageId("901900");
		trsClassVO = null;
		return islamicCalculatorEventMgmtCO;
	    }
	    trsClassVO = null;
	    trsClassVOkey = null;
	    iisHolidayCheckCO = null;
	    String rescheduleChecking = islamicCalculatorEventMgmtCO.getRescheduleCalcYN();
	    String pageRef = islamicCalculatorEventMgmtCO.getPageRef();

	    if(rescheduleChecking.equals(ConstantsCommon.YES)
		    && pageRef.equals(IISCommonConstants.CALCULATOR_PAGE_REF_RESCHEDULE_M0165)
		    || pageRef.equals(IISCommonConstants.CALCULATOR_PAGE_REF_RESCHEDULE_M0169))
	    {
		double adjustNoOfPayments = islamicCalculatorEventMgmtCO.getNoOfPayments().doubleValue();
		double gracePeriod = islamicCalculatorEventMgmtCO.getGracePeriod().doubleValue();
		String gracePeriodicity = islamicCalculatorEventMgmtCO.getGracePeriodicity();
		double noOfMonths, totalPayments;
		if(gracePeriodicity.equals(IISCommonConstants.DAY))
		{
		    noOfMonths = NumberUtil.truncate((gracePeriod / 30), 0l);
		    if(noOfMonths >= 1)
		    {
			totalPayments = adjustNoOfPayments - noOfMonths;
			islamicCalculatorEventMgmtCO.setNoOfPayments(BigDecimal.valueOf(totalPayments));
		    }
		}
		else if(gracePeriodicity.equals(IISCommonConstants.MONTH) && gracePeriod >= 1)
		{
		    totalPayments = adjustNoOfPayments - gracePeriod;
		    islamicCalculatorEventMgmtCO.setNoOfPayments(BigDecimal.valueOf(totalPayments));
		}
		else if(gracePeriodicity.equals(IISCommonConstants.WEEK) && gracePeriod >= 1)
		{

		    noOfMonths = (gracePeriod * 7) / 30;
		    if(noOfMonths >= 1)
		    {
			totalPayments = adjustNoOfPayments - noOfMonths;
			islamicCalculatorEventMgmtCO.setNoOfPayments(BigDecimal.valueOf(totalPayments));
		    }

		}
	    }
	}

	return islamicCalculatorEventMgmtCO;
    }
    // call setmaturitybasedonholiday

    // TP#231558;Arun.R.Variyath;15/10/2014
    private long returnActualGracePeriod(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	Date valueDate = islamicCalculatorEventMgmtCO.getStartDate();
	Date firstPayDate = islamicCalculatorEventMgmtCO.getFirstPaymentDate();
	long periodicityNbr = NumberUtil
		.nullEmptyToValue(islamicCalculatorEventMgmtCO.getPaymPeriodNbr(), BigDecimal.ZERO).longValue();
	String periodicityType = islamicCalculatorEventMgmtCO.getPaymPeriodicity();
	String periodicityPos = islamicCalculatorEventMgmtCO.getPaymPeriodPos();

	Date nexDate = getNextValueDate(firstPayDate, firstPayDate, periodicityType, periodicityNbr * -1, 0L,
		periodicityPos, null, "N");

	long actualGraceDays = DateUtil.numberOfDays(valueDate, nexDate);
	if(actualGraceDays < 0)
	{
	    actualGraceDays = 0;
	}

	return actualGraceDays;
    }

    public IISCommonCO calculateYield(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam)
	    throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;

	BigDecimal cifNo = islamicCalculatorEventMgmtCO.getCifNo();
	/*
	 * if(cifNo == null) { return new IISCommonCO(); }Commented by Linchu on
	 * 17-06-2013 as onchange events like purchase amt yield was not getting
	 * calculated.
	 */
	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisCommonCO.setNoOfPayments(islamicCalculatorEventMgmtCO.getNoOfPayments());
	iisCommonCO.setPaymPeriodNbr(islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	iisCommonCO.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	iisCommonCO.setPaymPeriodPos(islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	iisCommonCO.setGracePeriod(islamicCalculatorEventMgmtCO.getGracePeriod());
	iisCommonCO.setGracePeriodicity(islamicCalculatorEventMgmtCO.getGracePeriodicity());
	iisCommonCO.setCommencementDate(islamicCalculatorEventMgmtCO.getStartDate());
	iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	iisCommonCO.setRunningDate(islamicCalculatorEventMgmtCO.getRunningDate());
	iisCommonCO.setCifNo(cifNo);

	iisCommonCO.setPartyType("B");// Both
	iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	iisCommonCO.setCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	iisCommonCO.setTempCode(islamicCalculatorEventMgmtCO.getTempCode());
	iisCommonCO.setBaloonPercentage(islamicCalculatorEventMgmtCO.getBaloonPercentage());
	iisCommonCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());

	// To calculate the decimal points based on the currency unit
	islamicCalculatorEventMgmtCO = setAmountBasedOnCurrPoints(islamicCalculatorEventMgmtCO);
	// C - DownPayment Event
	if(islamicCalculatorEventMgmtCO.getEventType() != null
		&& islamicCalculatorEventMgmtCO.getEventType().equals(IISCommonConstants.DOWN_PAYMENT_DP))
	{
	    double dealAmount = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getPurchaseAmount())
		    - NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    BigDecimal dealAmountValue = NumberUtil.roundToBigDecimal(BigDecimal.valueOf(dealAmount),
		    NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints()));
	    iisCommonCO.setRosterDealAmount(dealAmountValue);
	}
	else
	{
	    iisCommonCO
		    .setRosterDealAmount(NumberUtil.roundToBigDecimal(islamicCalculatorEventMgmtCO.getFinancingAmount(),
			    NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCurrencyDecimalPoints())));
	}
	iisCommonCO.setSalaryWithBank(islamicCalculatorEventMgmtCO.getSalaryWithBank());
	// TP#212782; Ramesh; Date 27/09/2014
	iisCommonCO.setNoOfPayments(islamicCalculatorEventMgmtCO.getNoOfPayments());
	iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());
	iisCommonCO.setProductClass(islamicCalculatorEventMgmtCO.getProductClass());
	iisCommonCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
	iisCommonCO.setSalaryWithBank(islamicCalculatorEventMgmtCO.getSalaryWithBank());
	iisCommonCO.setPaymPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	// TP#259947;Arun.R.Variyath;09/01/2015
	// 680720-commenting the below line since rosterdealamount already set
	// in above condition.And if the belowexists, caused issue while
	// changing downpayment amount
	// iisCommonCO.setRosterDealAmount(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getDealAmount()));
	iisCommonCO = iisCommonBO.returnYieldFromRegister(iisCommonCO);
	return iisCommonCO;
    }

    /***
     * Method for setting the rounding the amount based on the currency passed
     */
    public IslamicCalculatorEventMgmtCO setAmountBasedOnCurrPoints(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getCompCode() != null && islamicCalculatorEventMgmtCO.getCurrencyCode() != null)
	{
	    // Get the currency informations like decimal point, PT method etc
	    CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	    currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    CURRENCIESVO currenciesVO = iisCommonBO.returnCurrencyDetails(currenciesVOKey);
	    currenciesVOKey = null;

	    if(currenciesVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_DEAL_CURRENCY);
	    }
	    islamicCalculatorEventMgmtCO.setCurrencyDecimalPoints(currenciesVO.getDECIMAL_POINTS());
	}
	return islamicCalculatorEventMgmtCO;
    }

    private static final double doubleValue(Object o)
    {
	return NumberUtil.toDouble(o);

    }

    /**
     * @author mvalappil To recalulat the charges amount which the flag
     *         "CALC_ON_YERLY_OUTSTND_PRINC_YN"
     * @param islamicCalculatorCO
     * @throws BaseException
     */
    private void allocateChargeOnYearlyoutstandingCapital(IslamicCalculatorCO islamicCalculatorCO) throws BaseException
    {
	if(islamicCalculatorCO.getTrsdealchargesVO() == null || islamicCalculatorCO.getTrsdealchargesVO().isEmpty()
		|| "Y".equals(islamicCalculatorCO.getRescheduleYn())
		|| islamicCalculatorCO.getDisbursementScreen())
	{
	    return;
	}
	
	for(TRSDEALCHARGESVO trsdealchargesVO : islamicCalculatorCO.getTrsdealchargesVO())
	{
	//  CDMI190005 - Takaful Insurance Product
	    String CALC_ON_YERLY_OUTSTND_PRINC_YN = ConstantsCommon.NO;/// Get From TRSCHARGES
	    String insuranceYn = ConstantsCommon.NO;/// Get From TRSCHARGES
	    String trsdealcharges_charge_type = ConstantsCommon.NO; /// Get From TRSCHARGES
	   
	    TRSCHARGESVOKey trschargesVoKey = new TRSCHARGESVOKey();
	    trschargesVoKey.setCOMP_CODE(islamicCalculatorCO.getCompanyCode());
	    trschargesVoKey.setCODE(trsdealchargesVO.getCHARGES_CODE());
	    TRSCHARGESVO trschargesvo = iisIslamicCalculatorDAO.getDealChargesInsuranceYn(trschargesVoKey);
	    if(trschargesvo != null)
	    {
		insuranceYn = trschargesvo.getINSURANCE();
		CALC_ON_YERLY_OUTSTND_PRINC_YN = trschargesvo.getCALC_ON_YERLY_OUTSTND_PRINC_YN();
		trsdealcharges_charge_type = trschargesvo.getCHARGE_TYPE();
		// TP 1039534 CDMI200002 ; Jinson; 18/07/2020 Start[]
        if(ConstantsCommon.YES.equals(islamicCalculatorCO.getCalledFromFmsYN()))
        {
            if(ConstantsCommon.YES.equals(CALC_ON_YERLY_OUTSTND_PRINC_YN))
            {
            trsdealchargesVO.setCHARGES_PERCENTAGE(trschargesvo.getPERCENTAGE());
            }
        }
        // TP 1039534 CDMI200002 ; Jinson; 18/07/2020 END[]
	    }
	    log.info("CALC_ON_YERLY_OUTSTND_PRINC_YN ==="+CALC_ON_YERLY_OUTSTND_PRINC_YN );
	   if(ConstantsCommon.YES.equals(CALC_ON_YERLY_OUTSTND_PRINC_YN))
	   {
		if(ConstantsCommon.NO.equals(trsdealcharges_charge_type))
		{
		    throw new BOException(MessageCodes.iis_invalid_code, new String[] {
			    "calculate_charges_on_yearly_outstanding_principal_is_applicable_for_include_in_principle_key" });
		}
		BigDecimal outstandingCapital = islamicCalculatorCO.getDealAmount();
		Date outstandingStartDate = islamicCalculatorCO.getValueDate();
		Date outstandingEndDate = DateUtil.relativeMonth(outstandingStartDate, 12);
		
		Date fromDate = islamicCalculatorCO.getValueDate();
		Date toDate;
		BigDecimal cumCapitalAmount = BigDecimal.ZERO;
		BigDecimal totalChargeAmount = BigDecimal.ZERO;
		boolean yearChange = false;
		BigDecimal chargePercentage = NumberUtil.nullToZero(trsdealchargesVO.getCHARGES_PERCENTAGE());
		BigDecimal noOfDays = BigDecimal.ZERO;
		if(chargePercentage.compareTo(BigDecimal.ZERO) == 1)
		{
		for(TrspayplandetCO trspayplandetCO : islamicCalculatorCO.getTrspayplandetVOList())
		    {
		    long totalNoOfDaysInYear = DateUtil.numberOfDays(outstandingStartDate, outstandingEndDate);
		    toDate = trspayplandetCO.getVALUE_DATE();
		    BigDecimal chargeAmount = BigDecimal.ZERO;
		    cumCapitalAmount = cumCapitalAmount.add(NumberUtil.nullToZero(trspayplandetCO.getCAPITAL_AMT())
			    .subtract(NumberUtil.nullToZero(trspayplandetCO.getCHARGE_AMOUNT())
				    .add(NumberUtil.nullToZero(trspayplandetCO.getINSURANCE_AMOUNT()))));
			yearChange = false;

		    if(!trspayplandetCO.getVALUE_DATE().before(outstandingStartDate)
			    && !trspayplandetCO.getVALUE_DATE().after(outstandingEndDate))
		    {
			noOfDays = BigDecimal.valueOf(DateUtil.numberOfDays(fromDate, toDate));
			if(noOfDays.compareTo(BigDecimal.ZERO) == -1)
			{
			    noOfDays = BigDecimal.ZERO;
			}

			chargeAmount = outstandingCapital.multiply(chargePercentage).divide(BigDecimal.valueOf(100), 12,
				BigDecimal.ROUND_HALF_UP);
			chargeAmount = chargeAmount.divide(BigDecimal.valueOf(totalNoOfDaysInYear), 12, BigDecimal.ROUND_HALF_UP)
				.multiply(noOfDays);
			log.info("if 1 noOfDays ==="+noOfDays );
			 log.info("if 1 chargeAmount==="+chargeAmount );
		    }
		    else if(trspayplandetCO.getVALUE_DATE().after(outstandingEndDate)
			    && fromDate.before(outstandingEndDate))
		    {
			noOfDays = BigDecimal.valueOf(DateUtil.numberOfDays(fromDate, outstandingEndDate));
			if(noOfDays.compareTo(BigDecimal.ZERO) == -1)
			{
			    noOfDays = BigDecimal.ZERO;
			}
			chargeAmount = outstandingCapital.multiply(chargePercentage).divide(BigDecimal.valueOf(100), 12,
				BigDecimal.ROUND_HALF_UP);
			chargeAmount = chargeAmount.divide(BigDecimal.valueOf(totalNoOfDaysInYear), 12, BigDecimal.ROUND_HALF_UP)
				.multiply(noOfDays);

			noOfDays = BigDecimal.valueOf(DateUtil.numberOfDays(outstandingEndDate, toDate));
			if(noOfDays.compareTo(BigDecimal.ZERO) == -1)
			{
			    noOfDays = BigDecimal.ZERO;
			}

			outstandingCapital = outstandingCapital.subtract(cumCapitalAmount);

			    BigDecimal chargeAmount1 = outstandingCapital.multiply(chargePercentage).divide(
				    BigDecimal.valueOf(100), 12,
				BigDecimal.ROUND_HALF_UP);
			    chargeAmount1 = chargeAmount1.divide(BigDecimal.valueOf(totalNoOfDaysInYear), 12, BigDecimal.ROUND_HALF_UP)
				.multiply(noOfDays);
			    chargeAmount = chargeAmount.add(chargeAmount1);
			    cumCapitalAmount = BigDecimal.ZERO;
			    yearChange = true;
			    log.info("if 2 noOfDays ==="+noOfDays );
				 log.info("if 2 chargeAmount==="+chargeAmount );
		    }
			chargeAmount = NumberUtil.roundToBigDecimal(chargeAmount,
				islamicCalculatorCO.getDealCyDecimalPoint().intValue());

		    if(!trspayplandetCO.getVALUE_DATE().before(outstandingEndDate))
		    {
			outstandingCapital = outstandingCapital.subtract(cumCapitalAmount);
			cumCapitalAmount = BigDecimal.ZERO;
			    yearChange = true;
			}

			if(yearChange)
			{
			    outstandingStartDate = outstandingEndDate;
			    outstandingEndDate = DateUtil.relativeMonth(outstandingStartDate, 12);
		    }

		    if("Y".equals(insuranceYn))
		    {
			trspayplandetCO.setINSURANCE_AMOUNT(
				NumberUtil.nullToZero(trspayplandetCO.getINSURANCE_AMOUNT()).add(chargeAmount));

		    }
		    else
		    {
			trspayplandetCO.setCHARGE_AMOUNT(
				NumberUtil.nullToZero(trspayplandetCO.getCHARGE_AMOUNT()).add(chargeAmount));
		    }
		    trspayplandetCO
			    .setCAPITAL_AMT(NumberUtil.nullToZero(trspayplandetCO.getCAPITAL_AMT()).add(chargeAmount));
		    trspayplandetCO.setCAPITAL_AMT_BEFORE_XIRR(
			    NumberUtil.nullToZero(trspayplandetCO.getCAPITAL_AMT_BEFORE_XIRR()).add(chargeAmount));
		    trspayplandetCO.setAMOUNT(NumberUtil.nullToZero(trspayplandetCO.getAMOUNT()).add(chargeAmount));
		    log.info("chargeAmount out ==="+chargeAmount );
		    System.out.println(chargeAmount);
		    totalChargeAmount = totalChargeAmount.add(chargeAmount);
		    fromDate = toDate;

		}
		trsdealchargesVO.setCHARGES_AMOUNT(totalChargeAmount);
		totalChargeAmount = BigDecimal.ZERO;
		}
	   }

	}
    }

}
    