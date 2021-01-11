package com.path.bo.common.iis.islamiccalculator;

import java.util.Date;
import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;

public interface IISIslamicCalculatorBO
{

    public IslamicCalculatorCO createRepaymentPlan(IslamicCalculatorCO islamicCalculatorCO) throws BaseException;

    public IslamicCalculatorCO checkHolidayActionForSchedule(IslamicCalculatorCO islamicCalculatorCO)
	    throws BaseException;

    public Date getNextValueDate(Date firstPaymentDate, Date nextDate, String paymentPeriodicity,
	    Long paymentPeriodicityNo, Long lineNo, String paymentMonthPos, Long paymentSetDay, String scheculeType)
	    throws BaseException;

    public Double getProfitAmount(IslamicCalculatorCO islamicCalculatorCO) throws BaseException;

    public void validateBalloonDetails(IslamicCalculatorCO islamicCalculatorCO) throws BaseException;

    /**
     * To create shceule based on the request BB110264
     * 
     * @param calculatorCO
     * @return
     * @throws BaseException
     */
    public IslamicCalculatorCO createRepaymentForRequest(IslamicCalculatorCO calculatorCO) throws BaseException;

    /**
     * @param islamicCalculatorCO
     * @return
     * @throws BaseException
     */
    public IslamicCalculatorCO calculateAgencyFee(IslamicCalculatorCO islamicCalculatorCO) throws BaseException;

    /**
     * @param islamicCalculatorCO
     * @return
     * @throws BaseException
     */
    public IslamicCalculatorCO calculateAgencyFeeAdvancePrincipalSettlement(IslamicCalculatorCO islamicCalculatorCO)
	    throws BaseException;

    /**
     * Moved From IslamicCalculatorEventMgmtBOImpl for BB Web Service
     * 
     * Fawas.Kuruvakkottil; 13/12/2018 [Start]
     */
    public IslamicCalculatorEventMgmtCO validateOneObligorGlobalLimit(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public Date getFirstPaymentDate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO);

    public IslamicCalculatorEventMgmtCO validateRepayamentCriteriaList(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public void validateDealChargesList(List<TrsDealChargesCO> trsdealchargesVO) throws BaseException;

    /**
     * @param islamicCalculatorCO
     * @return
     */
    public IslamicCalculatorCO createRepaymentPlanService(IslamicCalculatorCO islamicCalculatorCO, Date runningDate,
	    String salaryWithBank) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeNoOfBalloons(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for populating data on the change event of NoOfBaloons
    public IslamicCalculatorEventMgmtCO populateBaloonPaymentGrid(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO populateOnChangeBalloonPaymentAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    // for populating data based on Balloon Payment Amount
    public IslamicCalculatorEventMgmtCO populateOnChangeProductClass(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    /**
     * Moved From IslamicCalculatorEventMgmtBOImpl for BB Web Service
     * 
     * Fawas.Kuruvakkottil; 13/12/2018 [End]
     */
    // for
    // populating
    // data
    // based
    // on
    // profit
    // First
    // Payment
    // After

    public IslamicCalculatorEventMgmtCO populateOnChangeFirstPaymentAfterPeriodicity(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Method

    /**
     * @param islamicCalculatorEventMgmtCO
     * @return
     */
    public IISCommonCO calculateYield(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    /**
     * @param islamicCalculatorEventMgmtCO
     * @return
     */
    public IslamicCalculatorEventMgmtCO setAmountBasedOnCurrPoints(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;
}
