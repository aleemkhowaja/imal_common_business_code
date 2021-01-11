package com.path.bo.common.iis.islamiccalculator;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.common.iis.islamiccalculator.TrsPlanBallonPaymentCO;

public interface IslamicCalculatorEventMgmtBO
{
    public String getLongOrShortDescription(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;// Get whether to take long/short description

    public String getCalculatorLanguage(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for getting language of Calculator

    public IslamicCalculatorEventMgmtCO populateOnChangeCif(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;// Method for populating data on the change

    // event of cif number

    public IslamicCalculatorEventMgmtCO populateOnChangeProductClass(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for populating data on the change event of product class

    public IslamicCalculatorEventMgmtCO populateOnChangePurchaseAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for populating data on the change event of PurchaseAmount

    public IslamicCalculatorEventMgmtCO populateOnChangeDownPaymentPercentage(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for populating data on the change event of PaymentPercentage

    public IslamicCalculatorEventMgmtCO populateOnChangeTotalFlatRate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for populating data on the change event of TotalFlatRate

    public IslamicCalculatorEventMgmtCO populateOnChangeFinancingAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // on
    // the
    // change
    // event
    // of
    // FinancingAmount

    public IslamicCalculatorEventMgmtCO populateOnChangeYield(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;// Method for populating data on the change

    // event of Yield

    public IslamicCalculatorEventMgmtCO populateOnChangeAmountPerPayment(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // on
    // the
    // change
    // event
    // of
    // AmountPerPayment
    public IslamicCalculatorEventMgmtCO populateOnChangeNoOfPayments(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // on
    // the
    // change
    // event
    // of
    // NoOfPayments

    public IslamicCalculatorEventMgmtCO onChangeDownPayment(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;// Method for populating data on the change

    // event of Down Payment

    public IslamicCalculatorEventMgmtCO populateOnChangeStartDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // on
    // the
    // change
    // event
    // of
    // Start
    // Date

    public IslamicCalculatorEventMgmtCO populateOnChangeMaturityDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // on
    // the
    // change
    // event
    // of
    // Maturity
    // Date

    public IslamicCalculatorEventMgmtCO populateOnChangeApprovedSalary(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // on
    // change
    // event
    // of
    // Approved
    // Salary

    public IslamicCalculatorEventMgmtCO populateOnChangeSalaryWithBank(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // on
    // change
    // event
    // of
    // Salary
    // with
    // bank
    // check
    // box

    public IslamicCalculatorEventMgmtCO populateOnChangeCurrencyCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // on
    // change
    // event
    // of
    // currency
    // drop
    // down

    public IslamicCalculatorEventMgmtCO populateOnChangeProfitCalculationMethod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // based
    // on
    // profit
    // calculation
    // method

    public IslamicCalculatorEventMgmtCO populateOnChangeFirstPaymentAfter(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // based
    // on
    // profit
    // First
    // Payment
    // After
    // Periodicity

    public IslamicCalculatorEventMgmtCO populateOnChangeFirstPayDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // based
    // on
    // First
    // Pay
    // date

    // public IslamicCalculatorEventMgmtCO validateOnChangePayEvery(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws
    // BaseException;// Method

    // for
    // populating
    // data
    // based
    // on
    // pay
    // every

    public IslamicCalculatorEventMgmtCO validateOnChangePayEveryPeriodicity(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // based
    // on
    // pay
    // every
    // Periodicity

    public IslamicCalculatorEventMgmtCO validateOnChangePayEveryPosition(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // based
    // on
    // pay
    // every
    // Position

    public IslamicCalculatorEventMgmtCO populateOnChangeDealPeriodCompounding(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // based
    // on
    // Deal
    // Period
    // Compounding

    public IslamicCalculatorEventMgmtCO populateOnChangeVatApplicable(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // based
    // on
    // Vat
    // Applicable

    public IslamicCalculatorEventMgmtCO populateOnChangeVatInstallment(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // based
    // on
    // Vat
    // Installment

    public IslamicCalculatorEventMgmtCO populateOnChangeVatCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // based
    // on
    // Vat
    // Code

    public IslamicCalculatorEventMgmtCO populateOnChangeTemplateCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for
    // populating
    // data
    // based
    // on
    // Template
    // Code

    public IslamicCalculatorEventMgmtCO getBalloonEqualPaymentsDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // to
    // set
    // ballon
    // payment
    // grid
    // with
    // equal
    // amount.

    public IslamicCalculatorEventMgmtCO populateOnChangeCivilId(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO validateOnChangeMaturityDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO validateOnChangeGracePeriodOption(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO validateOnChangeFirstPayDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO validateOnChangeStartDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO validateOnChangeNoOfPayments(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeGracePeriodOption(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaFromDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaToDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaPeriodicityNumber(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaPeriodicityPeriod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaPeriodicityPosition(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaPaymentType(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaNoOfPayments(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO setMaturityBasedonHoliday(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeChargecode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeChargeCurrencyCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeChargeAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateSetProductClassDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO calculateDealCharges(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public IslamicCalculatorEventMgmtCO setOnChangeStartDate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public IslamicCalculatorEventMgmtCO setOnChangeMaturityDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;
    /* Moved to IISCommonBO */
    // public IslamicCalculatorEventMgmtCO validateFieldsForDealCharges(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws
    // BaseException;

    // public IslamicCalculatorEventMgmtCO
    // validateMaxFinancingAmountForDealCharges(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws
    // BaseException;

    // public IslamicCalculatorEventMgmtCO validateNoOfPaymentsForDealCharges(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws
    // BaseException;

    public IslamicCalculatorEventMgmtCO checkMaturityDateIsHoliday(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public List<TrsPlanBallonPaymentCO> validateDateForBalloonDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public List<TrsPlanBallonPaymentCO> validateAmtForBalloonDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    /* Moved to IISCommonBO */
    // public IslamicCalculatorEventMgmtCO showWarningForCifSalaryMultiple(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws
    // BaseException;

    /* Moved to IISCommonBO */
    // public IslamicCalculatorEventMgmtCO validateForCifSalaryMultiple(
    // IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws
    // BaseException;

    public IslamicCalculatorEventMgmtCO calculateAnnualFloatingMarginRates(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO dependencyByTradingCurrencyCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO dependencyByCurrencyCode(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeRepaymentCriteriaAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeActualGracePeriod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    // TP#244113; Ramesh; Date 09/12/2014
    public void validateBalloonAllocatedAmount(IslamicCalculatorCO calculatorCO) throws BaseException;

    /**
     * @author mvalappil
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException onchange of contract price
     */
    public IslamicCalculatorEventMgmtCO onChangeContractPrice(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    /**
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO onChangeDiscountCalMethod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeDiscountPerc(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    /**
     * uf_set_cross_rate
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     */

    IslamicCalculatorEventMgmtCO crossRateBillsCalculator(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    IslamicCalculatorEventMgmtCO billsCalculatorCurrencyCode(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public IslamicCalculatorEventMgmtCO dependencyByCrossRate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public IslamicCalculatorEventMgmtCO dependencyTradingBillAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO dependencyPeriodicity(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public IslamicCalculatorEventMgmtCO iborDependencyPeriodicity(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO dependencyMarginRateBillsCalculator(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO dependencyGlobalRateBillsCalculator(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    /**
     * @author Arun.Variyath
     * @date 05/08/2015 TAR JAIZ140012
     * @param islamicCalculatorEventMgmtCO
     * @return
     */
    public IslamicCalculatorEventMgmtCO onChangeProfitRecognitionMethod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    /**
     * @author Arun.Variyath
     * @date 05/08/2015 TAR JAIZ140012
     * @param islamicCalculatorEventMgmtCO
     * @return
     */
    public IslamicCalculatorEventMgmtCO onChangeAccrualBasis(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    /**
     * TP# BB130052;deepu.mohandas 08/09/2015
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     * @author Deepu
     */
    public IslamicCalculatorEventMgmtCO afterDependencyForOnChangeMaturityDate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 start **/

    public IslamicCalculatorEventMgmtCO onChangeTopUpDealSelYN(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeReimburseProfitPerc(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeReimburseProfitAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeBuyOutBankCifNo(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeBuyOutDealCy(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeBuyOutDealAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeCrossCyExchRate(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeTrAccountBranch(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeTrAccountGl(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeTrAccountCif(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeTrAccountSl(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public IslamicCalculatorEventMgmtCO onChangeTrAccountCy(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public void validateDealType(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 end **/
    // BB160136; Saheer.Naduthodi; 20/04/2017
    public IslamicCalculatorEventMgmtCO onChangeFlexiPaymentCheckBox(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeBalloonPercentage(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO printCalculateScreen(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;
    
	public IslamicCalculatorEventMgmtCO checkYieldGreaterThanTieRate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)throws BaseException;

	public IslamicCalculatorEventMgmtCO onchangeBlackListRestrictionReasonCode(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)throws BaseException;


}