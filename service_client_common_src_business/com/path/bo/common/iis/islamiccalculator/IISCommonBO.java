package com.path.bo.common.iis.islamiccalculator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.bo.common.iis.IISReturnMessagesCO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIF_OCCUPATIONVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.IISCTRLVO;
import com.path.dbmaps.vo.IISCTRLVOKey;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSCLASSVOKey;
import com.path.dbmaps.vo.TRSDEALCHARGESVO;
import com.path.dbmaps.vo.TRSDEAL_YIELD_AMENDEDVO;
import com.path.dbmaps.vo.TRSVAT_PERIODVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.iis.islamiccalculator.CifBlackListRestrictCO;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IISCustomerLimitCO;
import com.path.vo.common.iis.islamiccalculator.IISHolidayCheckCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorDBRatioSC;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.iis.common.IISInvestmentDealCO;
import com.path.vo.iis.common.IISInvestmentDealSC;

public interface IISCommonBO
{
    /**
     * f_get_cy_pt_method_iis_calc
     * 
     * @param currenciesVOKey
     * @return
     * @throws BaseException
     */
    public String returnCurrencyPtMethod(CURRENCIESVOKey currenciesVOKey) throws BaseException;

    public IISCommonCO validateCifStatus(IISCommonCO iiSCommonCO) throws BaseException;// Get

    // the
    // CIF
    // statuso
    // (Suspended,active,etc...)

    public IISCommonCO isBlackListed(IISCommonCO iisCommonCO) throws BaseException;// Check

    // whether
    // the
    // CIF
    // is
    // blacklisted
    // or
    // not

    public IISCommonCO returnMaturitydate(IISCommonCO iisCommonCO) throws BaseException;// Get

    // the
    // maturity
    // Date

    public String returnHolidayActionDealDateYn(IISCommonCO iisCommonCO) throws BaseException;// Get

    // the
    // Holiday
    // Action
    // Deal
    // Date

    public IslamicCalculatorEventMgmtCO returnIISControlParams(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;// Get
											    // the
											    // Control
											    // records

    public List<IslamicCalculatorDBRatioSC> calculateDBRatio(IISCommonCO iisCommonCO) throws BaseException;

    public CIF_OCCUPATIONVO returnCifIncome(IISCommonCO iiSCommonCO) throws BaseException;

    public Double returnVatPercentage1(IISCommonCO iisCommonCO) throws BaseException;
    
    /**
     * -- Added by Manoj on 20/06/2019 for BMO180067 
     * This method will return VAR rate and VAT account from Common VAT PArametor By Branch/Currency/Nationality..
     * This mehtod will call the API P_WRAP_CORE_GET_VAT_DETAILS_IIS(IIS Wrapper) 
     * @param iisCommonCO
     * @return
     * @throws BaseException
     */
    public IISCommonCO returnCommonVatDetails(IISCommonCO iisCommonCO) throws BaseException;

    public IISHolidayCheckCO checkCurrencyAndCountryHoliday(IISHolidayCheckCO iisHolidayCheckCO) throws BaseException;

    public IISHolidayCheckCO checkValueDateIsHoliday(IISHolidayCheckCO iisHolidayCheckCO) throws BaseException;

    public IISCommonCO returnYieldFromRegister(IISCommonCO iisCommonCO) throws BaseException;// To

    // get
    // the
    // yield
    // from
    // register

    public IISCommonCO returnFirstdate(IISCommonCO iisCommonCO) throws BaseException;// To

    // get
    // the
    // yield
    // from
    // register

    public IISCommonCO checkGracePeriod(IISCommonCO iisCommonCO) throws BaseException;// To

    // get
    // the
    // yield
    // from
    // register

    public BigDecimal returnCif(IISCommonCO iisCommonCO) throws BaseException;

    public IISCommonCO returnNumberofPayments(IISCommonCO iisCommonCO) throws BaseException;

    public Date returnNextDate(Date calcuteDate, String paymPeriodicity, boolean abFirst) throws BaseException;

    public IISHolidayCheckCO checkAllowBackDealValueDate(IISHolidayCheckCO iisHolidayCheckCO) throws BaseException;

    public BigDecimal returnHolidayAction(IISCommonCO iisCommonCO) throws BaseException;// Get

    // the
    // Holiday
    // Action

    public TRSCLASSVO returnHolidayActions(TRSCLASSVOKey trsclasskey) throws BaseException;

    public IISCommonCO returnExchangeRate(IISCommonCO iisCommonCO) throws BaseException;

    public IISCommonCO returnCrossRate(IISCommonCO iisCommonCO) throws BaseException;

    public IISCommonCO returnDaysAfterMaximumPeriod(IISCommonCO iisCommonCO) throws BaseException;

    public CURRENCIESVO returnCurrencyDetails(CURRENCIESVOKey currenciesVOKey) throws BaseException;

    public TRSVAT_PERIODVO returnVatPercentage1(TRSVAT_PERIODVO trsvatPERIODVO) throws BaseException;

    public BigDecimal returnAmountWithCurrencyDecimalForMaxMin(BigDecimal amount, int decimalPoint, String MinMax)
	    throws BaseException;

    public String returnRifStaff(IISCommonCO iisCommonCO) throws BaseException;

    public BigDecimal returnCifType(IISCommonCO iisCommonCO) throws BaseException;

    public IISCommonCO returnUsrAccess(IISCommonCO iisCommonCO) throws BaseException;

    public USRVO returnUsrDetailsIIS(USRVO usrvo) throws BaseException;

    /**
     * To get IIS Controll information
     * 
     * @param iisctrlvoKey
     * @return
     * @throws BaseException
     */
    public IISCTRLVO returnIISCTRL(IISCTRLVOKey iisctrlvoKey) throws BaseException;

    /**
     * REturn True if the application name is in IIS Module (eg: ITRS/IIS/ICOR
     * etc)
     * 
     * @param appName
     * @return
     * @throws BaseException
     */
    public boolean returnIsIisApplication(String appName) throws BaseException;

    /**
     * Return Months and Days between two dates PB
     * f_monthsbetween_with_remaining_days
     * 
     * @param dateFrom, dateTo
     * @return
     * @throws BaseException
     */
    public Double getMonthsAndDayDifferance(Date dateFrom, Date dateTo) throws BaseException;

    /**
     * 
     * @param compCode
     * @param branchCode
     * @param code
     * @return
     * @throws BaseException
     * @author Raees
     */
    public String returnIISCTRL_ADDITIONAL_PARAM(BigDecimal compCode, BigDecimal branchCode, BigDecimal code)
	    throws BaseException;

    /**
     * To get the IISCONTROL values
     * 
     * @param seqKey
     * @param flagName
     * @return
     * @throws BaseException
     * @author mvalappil
     */
    public String returnIISCONTROLValyByKey(BigDecimal seqKey, String flagName) throws BaseException;

    /**
     * To calculate the Total Flat yield
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     * 
     */
    public IslamicCalculatorEventMgmtCO calculateTotalAnnualYield(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public BigDecimal returnOutStandingPrincipal(BigDecimal dealNo, BigDecimal compCode, BigDecimal branchCode)
	    throws BaseException;

    /**
     * @author saheer.naduthodi
     * @BB130089
     */
    public IISCustomerLimitCO validateGeneralCustomerLimit(IISCustomerLimitCO iisCustomerLimitCO) throws BaseException;

    /**
     * BB130052;deepu.mohandas 25/05/2015
     * 
     * @param iisCommonCO
     * @throws BaseException
     */
    public void checkClassLimitTenure(IISCommonCO iisCommonCO) throws BaseException;

    /**
     * Return account details from AMF by Additinal ref
     * 
     * @param amfVo
     * @return
     * @throws BaseException
     */
    public AMFVO returnAccountByAdditionalRef(AMFVO amfVo) throws BaseException;

    /**
     * Return account details from AMF by account
     * 
     * @param amfVo
     * @return
     * @throws BaseException
     */
    public AMFVO returnAccountByAccount(AMFVO amfVo) throws BaseException;

    /**
     * Bills calculator of_set_price
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO applyPriceSetCalculator(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    /**
     * Bills calculator of_set_yield
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO applyBillsCalculatorYield(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    /**
     * 
     * @param valueDate
     * @param matrutiyDate
     * @return
     * @throws BaseException
     */
    public Double getAverageYearDaysInDealPeriod(Date valueDate, Date matrutiyDate) throws BaseException;

    /**
     * To return Year per days based on the accrual basis
     * 
     * @param compCode
     * @param accrualBasis
     * @param currencyCode
     * @param valueDate
     * @param MAturityDate
     * @return
     * @throws BaseException
     */
    public BigDecimal returnDaysPerYear(BigDecimal compCode, BigDecimal accrualBasis, BigDecimal currencyCode,
	    Date valueDate, Date MAturityDate) throws BaseException;

    /**
     * 
     * @param iiReturnMessagesCO
     * @param e
     * @return
     */
    public IISReturnMessagesCO addExceptionToList(IISReturnMessagesCO iiReturnMessagesCO, BaseException e)
	    throws BaseException;

    public boolean isExceptionInList(IISReturnMessagesCO iiReturnMessagesCO, String msgIdent) throws BaseException;

    public Date getpreviouscoupondate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public Date getnextCouponDate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public BigDecimal getNoOfcoupon(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    /**
     * @author Arun.Variyath #TAR BB130030 11/08/2015
     * @param iisCommonCO
     * @return
     * @throws BaseException
     */
    public String returnCalcMatDteFlagValue(IISCommonCO iisCommonCO) throws BaseException;

    /**
     * // TP# 222800 BM140006 - Limit for Yield Roster in IIS Sreejith
     * 
     * @param compCode
     * @param branchCode
     * @param partyType
     * @param cif
     * @param salaryWithBank
     * @param classCode
     * @param cy
     * @param amount
     * @param vDate
     * @param numberOfPayments
     * @param periodicityType
     * @param templateCode
     * @param balloonAmtPcnt
     * @param yieldNew
     * @param columnMargin
     * @throws BaseException
     */
    public List<String> checkLimitYieldRoster(BigDecimal compCode, BigDecimal branchCode, String partyType,
	    BigDecimal cif, String salaryWithBank, BigDecimal classCode, BigDecimal cy, BigDecimal amount, Date vDate,
	    BigDecimal numberOfPayments, String periodicityType, BigDecimal templateCode, BigDecimal balloonAmtPcnt,
	    BigDecimal yieldNew, Boolean columnMargin) throws BaseException;

    /**
     * // TP# 222800 BM140006 - Limit for Yield Roster in IIS Sreejith
     * 
     * @param compCode
     * @param branchCode
     * @param dealNo
     * @param multipleYieldLineNo
     * @param yield
     * @param defaultYN
     * @return
     * @throws BaseException
     */
    public TRSDEAL_YIELD_AMENDEDVO insertDealYield(BigDecimal compCode, BigDecimal branchCode, BigDecimal dealNo,
	    BigDecimal multipleYieldLineNo, BigDecimal yield, String defaultYN) throws BaseException;

    /**
     * Get VAT PErcentage for the spesific branch and Currency defained at the
     * level of VAT parametor for BURJ140135 on 01/09/2016
     * 
     * @author mvalappil
     * @param iisCommonCO
     * @return VAT Rate
     * @throws BaseException
     */
    public TRSVAT_PERIODVO returnVatPercentageForBrachAndCy(IISCommonCO iiSCommonCO) throws BaseException;

    /**
     * @author mvalappil
     * @param iiSCommonCO
     * @throws BaseException
     */
    public void returnWarningMessageForVatBrachCode(IISCommonCO iiSCommonCO) throws BaseException;

    /**
     * Moved from Calculator Classes for LOS Integration on 13/12/2017 [Begin]
     */
    public IslamicCalculatorEventMgmtCO checkInstamtWithCifSalPerc(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCoParam) throws BaseException;

    public IslamicCalculatorEventMgmtCO showWarningForCifSalaryMultiple(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO validateMinFinanacingAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO, TRSCLASSVO trsClassVO) throws BaseException;

    public IslamicCalculatorEventMgmtCO validateDealPeriod(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO,
	    TRSCLASSVO trsClassVO) throws BaseException;

    public IslamicCalculatorEventMgmtCO checkCifExistingDeals(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public IslamicCalculatorEventMgmtCO validateMaxFinancingAmountForDealCharges(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException;

    public IslamicCalculatorEventMgmtCO validateForCifSalaryMultiple(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException;

    // BB160136
    public IslamicCalculatorEventMgmtCO validateFlexiPayment(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException;

    public IslamicCalculatorEventMgmtCO validateFieldsForDealCharges(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO validateNoOfPaymentsForDealCharges(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    public IslamicCalculatorEventMgmtCO validateOnChangePayEvery(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException;

    /**
     * Moved from Calculator Classes for LOS Integration on 13/12/2017 [End]
     */

    public int returnCivilIdCount(IISCommonCO iisCommonCO) throws BaseException;

    /**
     * @author Saheer.Naduthodi
     * @param iisCommonCO.CompCode iisCommonCO.BranchCode iisCommonCO.CifNo
     *            iisCommonCO.LimitCode iisCommonCO.Currency iisCommonCO.LimitCY
     * @exception when currency not defined in limit
     */
    void checkLimitRelatedCY(IISCommonCO iisCommonCO) throws BaseException;
	
	
    /**
     * To retrieve the list of deals which marked for utilizing in asset dash
     * board where those not utilized yet
     * 
     * @param investmentDealSC compCode : logged in company Code branchCode :
     *            logged in branch Code baseCurrencyCode : Base currency code
     *            for the company, using for getting cross rate if utilization
     *            currency is other than the deal currency, runningDate using
     *            for getting cross rate if utilization currency is other than
     *            the deal currency tangibleAsset : Y OR N if its Y then will
     *            return the deals of the product of Ijarah, Istisna and Wakala
     *            Investment, else "N" will return the deals other than Ijarah,
     *            Istisna and Wakala Investment products fromDate :period from
     *            toDate : period to
     * 
     * @return List of IISInvestmentDealCO
     * @throws BaseException
     */
    public List<IISInvestmentDealCO> returnInvestDealList(IISInvestmentDealSC investmentDealSC) throws BaseException;

    /**
     * 
     * @param investmentDealSC compCode : logged in company Code branchCode :
     *            logged in branch Code dealNumber : deal number to update
     *            utilizaionStatus : "Y" or "N"
     * 
     * @return
     * @throws BaseException
     */
    public int updateDealUtilizationFromAsset(IISInvestmentDealSC investmentDealSC) throws BaseException;
	
	BigDecimal returnEarlySettlementReimbursmentAmount(IISCommonCO iisCommonCO) throws BaseException;

		
    public void validateActionDateWithPrevActionDate(Date trxDate, Date prevTrxDate, String trxMode,
    	    String VALD_ACT_WRT_PREV_ACT_DTE_YN) throws BaseException;

	void checkTotalYieldWithTieRate(BigDecimal compCode, BigDecimal branchCode, BigDecimal productClass,
			BigDecimal totalYield, BigDecimal minYieldPrm, Date valueDate, Object returnObject) throws BaseException;

	/**
	 * @author mvalappil
	 * BMOI160002
	 * @param commonCO
	 */
	public IISCommonCO returnFirstPaymentDateByCutoffDay(IISCommonCO commonCO)throws BaseException;
	
	/**
	 * @author mvalappil
	 * BMO160011
	 * @param cifBlackListRestrictCO
	 * @return
	 * @throws BaseException
	 */
	public CifBlackListRestrictCO updateCifBlackListReson(CifBlackListRestrictCO cifBlackListRestrictCO)throws BaseException;
	
	/**
	 * @author mvalappil
	 * BMO160011
	 * @param cifBlackListRestrictCO
	 * @return
	 * @throws BaseException
	 */
	
	public CifBlackListRestrictCO retrieveCifBlackListReson(CifBlackListRestrictCO cifBlackListRestrictCO)throws BaseException;
	/**
	 * @author mvalappil
	 * BMO160011
	 * @param iisCommonCO
	 * @return
	 * @throws BaseException
	 */
	public IISCommonCO validateCifBlacklistedRestrictionBypass(IISCommonCO iisCommonCO)throws BaseException;
	
	public String returnVatDeductionMethodOnCharge(BigDecimal compCode, BigDecimal charge_CODE) throws BaseException;

	public String returnvatPercInd(BigDecimal compCode, BigDecimal branchCode, BigDecimal dealNo) throws BaseException;

	public BigDecimal returnVatCodeChargesIncludeInst(BigDecimal compCode, BigDecimal branchCode, BigDecimal dealNo)throws BaseException;

	public BigDecimal returnVatCountOtherCharge(BigDecimal compCode, BigDecimal branchCode, BigDecimal dealNo, BigDecimal vatCode)throws BaseException;

    public TRSDEALCHARGESVO calculateChargeOnYearlyoutstandingCapital(BigDecimal compCode, BigDecimal branchCode,
	    BigDecimal dealNo, Date startDate, BigDecimal chargeCode, BigDecimal chargePercentage, String callType,
	    BigDecimal baseCurrency, BigDecimal chargeCurrency, Date runningDate,BigDecimal planNbr,BigDecimal planSeq) throws BaseException;

}