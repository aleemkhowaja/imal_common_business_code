package com.path.dao.common.iis.islamiccalculator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.BLACKLIST_OVERRIDE_REASONVO;
import com.path.dbmaps.vo.BRANCH_HOLIDAYVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_OCCUPATIONVO;
import com.path.dbmaps.vo.COUNTRY_CALENDARVO;
import com.path.dbmaps.vo.COUNTRY_CALENDARVOKey;
import com.path.dbmaps.vo.COUNTRY_HOLIDAYVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.IISCTRLVOKey;
import com.path.dbmaps.vo.TRSCHARGESVOKey;
import com.path.dbmaps.vo.TRSCIFLIMITDETVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSCLASSVOKey;
import com.path.dbmaps.vo.TRSCLASS_KEY_LABELVO;
import com.path.dbmaps.vo.TRSDEALVO;
import com.path.dbmaps.vo.TRSCLASS_EXTENDEDVO;
import com.path.dbmaps.vo.TRSCLASS_EXTENDEDVOKey;
import com.path.dbmaps.vo.TRSDEALVOKey;
import com.path.dbmaps.vo.TRSDEAL_STLMT_APTNMTVOKey;
import com.path.dbmaps.vo.TRSDETVO;
import com.path.dbmaps.vo.TRSPAYPLANDETVO;
import com.path.dbmaps.vo.TRSPAYPLANVO;
import com.path.dbmaps.vo.TRSROSTER_REGISTER_DETVO;
import com.path.dbmaps.vo.TRSROSTER_REGISTER_DETVOKey;
import com.path.dbmaps.vo.TRSVAT_PERIODVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.iis.islamiccalculator.CifBlackListRestrictCO;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IISCustomerLimitCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorDBRatioSC;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.iis.common.IISInvestmentDealCO;
import com.path.vo.iis.common.IISInvestmentDealSC;

public interface IISCommonDAO
{
    public IISCommonCO getCifStatus(IISCommonCO iisCommonCO) throws DAOException;

    public IISCommonCO getBlackListedDetails(IISCommonCO iisCommonCO) throws DAOException;

    public String isAllowBlackListed(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal getCif(IISCommonCO iisCommonCO) throws DAOException;

    public Long getDaysAfterMaximumPeriod(IISCommonCO iisCommonCO) throws DAOException;

    public String getHolidayActionDealDateYn(IISCommonCO iisCommonCO) throws DAOException;

    public IslamicCalculatorEventMgmtCO getIISControlParams(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public CIF_OCCUPATIONVO getCifIncome(IISCommonCO iisCommonCO) throws DAOException;

    // public IISCommonCO getCifType(IISCommonCO iisCommonCO) throws
    // DAOException;
    public IISCommonCO isCifTypeStaff(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal getOutstandingDealAmount(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal getOutstandingDealAmountForGuarantor(IISCommonCO iisCommonCO) throws DAOException;

    public List<IslamicCalculatorDBRatioSC> getMonthlyInstallmentsByCif(IISCommonCO iisCommonCO) throws DAOException;

    public Long getMaxDealInstPerOfSal(IISCommonCO iisCommonCO) throws DAOException;

    public Double getVatPercentage(IISCommonCO iisCommonCO) throws DAOException;

    public Double getVatPercentageWithNoDate(IISCommonCO iisCommonCO) throws DAOException;

    public COUNTRY_CALENDARVO getCountryCalendar(COUNTRY_CALENDARVOKey countryCalendarVO) throws DAOException;

    public Long getCountryCode(COUNTRY_CALENDARVOKey countryCalendarVO) throws DAOException;

    public BRANCH_HOLIDAYVO getBranchHoliday(BRANCH_HOLIDAYVO branchHolidayVO) throws DAOException;

    public COUNTRY_HOLIDAYVO getCountryHoliday(COUNTRY_HOLIDAYVO countryHolidayVO) throws DAOException;

    public TRSCLASSVO getHolidayActions(TRSCLASSVOKey trsclassvoKey) throws DAOException;

    public BigDecimal getRosterRegister(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal getRosterRegisterWithOutClass(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal getCifType(IISCommonCO iisCommonCO) throws DAOException;

    public List<TRSROSTER_REGISTER_DETVO> getYeildRegisterCif(TRSROSTER_REGISTER_DETVOKey trsRosterRegisterDetKey)
	    throws DAOException;

    public List<TRSROSTER_REGISTER_DETVO> getYeildRegisterAllCif(TRSROSTER_REGISTER_DETVOKey trsRosterRegisterDetKey)
	    throws DAOException;

    public BigDecimal getAccCifType(IISCommonCO iisCommonCO) throws DAOException;

    public String getMaintainsalaryAc(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal getStaffYield(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal getYieldSalaryWithBank(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal getYieldModarib(IISCommonCO iisCommonCO) throws DAOException;

    public String getCalcFirstPaymentDateYn(IISCommonCO iisCommonCO) throws DAOException;

    public TRSCLASSVO getGracePeriodClass(TRSCLASSVOKey trsClassKey) throws DAOException;

    public BigDecimal getHolidayAction(IISCommonCO iisCommonCO) throws DAOException;

    public Date getMaximumDateRate(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal getExchangeRateWrtDate(IISCommonCO iisCommonCO) throws DAOException;

    public CURRENCIESVO getCurrencyDetails(CURRENCIESVOKey currenciesVOKey) throws DAOException;

    public String getRifStaff(IISCommonCO iisCommonCO) throws DAOException;

    public IISCommonCO getUsrAccess(IISCommonCO iisCommonCO) throws DAOException;

    // public IISCTRLVO getIISCTRL(IISCTRLVOKey iisctrlvoKey) throws
    // DAOException;

    public USRVO getUsrDetailsIIS(USRVO usrvo) throws DAOException;

    public String returnIISCONTROLValyByKey(BigDecimal seqKey, String flagName) throws DAOException;

    // TP#253460; Ramesh; Date 29/12/2014
    public BigDecimal returnTrsDealCount(TRSDEALVOKey trsdealvoKey) throws DAOException;

    // TP#253460; Ramesh; Date 29/12/2014
    public BigDecimal returnTrsClassCount(TRSCLASSVOKey trsclassvoKey) throws DAOException;

    // TP#253460; Ramesh; Date 29/12/2014
    public BigDecimal returnSettlementDivision(TRSCLASSVOKey trsclassvoKey) throws DAOException;

    // TP#253460; Ramesh; Date 29/12/2014
    public BigDecimal returnCountTrsSelmntAptNmt(TRSDEAL_STLMT_APTNMTVOKey trsdealSTLMTAPTNMTVOKey) throws DAOException;

    // TP#253460; Ramesh; Date 29/12/2014
    public BigDecimal returnCurrenciesCount(CURRENCIESVOKey currenciesvoKey) throws DAOException;

    // TP#253460; Ramesh; Date 29/12/2014
    public String returnIISCtrlLimitBasedOn(IISCTRLVOKey iisctrlvoKey) throws DAOException;

    // TP#253460; Ramesh; Date 29/12/2014
    public TRSPAYPLANDETVO returnSumOfCapitalAmtAndCptlAmtBeforeXirr(TRSPAYPLANVO trspayplanvo) throws DAOException;

    // TP#253460; Ramesh; Date 29/12/2014
    public TRSPAYPLANDETVO returnTrsPayplanDetSumofValues(TRSPAYPLANVO trspayplanvo) throws DAOException;

    // BB130089; Saheer.Naduthodi; 14/05/2015
    public BigDecimal returnOutstandingAmount(IISCustomerLimitCO iisCustomerLimitCO) throws DAOException;

    // TP# BB130052;deepu.mohandas 25/05/2015
    public TRSCIFLIMITDETVO returnClassLimitTenure(IISCommonCO iisCommonCO) throws DAOException;

    public AMFVO returnAccountByAccount(AMFVO amfVo) throws DAOException;

    public AMFVO returnAccountByAdditionalRef(AMFVO amfVo) throws DAOException;

    /**
     * @author Arun.Variyath #TAR BB130030 11/08/2015
     * @param iisCommonCO
     * @return
     * @throws DAOException
     */
    public String returnCalcMatDteFlagValue(IISCommonCO iisCommonCO) throws DAOException;

    /**
     * // TP# 222800BM140006 - Limit for Yield Roster in IIS start Sreejith
     * 
     * @param iisCommonCO
     * @return
     * @throws DAOException
     */

    public BigDecimal returnCodeFromTRSROSTER_REGISTER(IISCommonCO iisCommonCO) throws DAOException;

    public List<TRSROSTER_REGISTER_DETVO> returnTRSROSTER_REGISTER_DETData(
	    TRSROSTER_REGISTER_DETVO trsrosterREGISTERDETVO) throws DAOException;

    public CIFVO returnCifTypeAndMaintSalaryAcc(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal returnCifTypeFromACC_NV_CONTROL(IISCommonCO iisCommonCO) throws DAOException;

    public IISCommonCO returnYieldFromTRSROSTERDET(IISCommonCO iisCommonCO) throws DAOException;

    public IISCommonCO returnAllowEditOutSideRangeAndDefaultedYield(IISCommonCO iisCommonCO) throws DAOException;

    /**
     * // TP# 222800BM140006 - Limit for Yield Roster in IIS end Sreejith
     * 
     * @param iisCommonCO
     * @return
     * @throws DAOException
     */
    public BigDecimal returnRecCountFromTRSDEAL_YIELD_AMENDED(IISCommonCO iisCommonCO) throws DAOException;

    /**
     * TP 253158 -Renaming by product category - Sreejith
     * 
     * @param iisCommonCO
     * @return
     * @throws DAOException
     */
    public List<TRSCLASS_KEY_LABELVO> returnTrsClassLabelVOData(IISCommonCO iisCommonCO) throws DAOException;

    /**
     * TP 253158 -Renaming by product category - Sreejith
     * 
     * @param iisCommonCO
     * @return
     * @throws BaseException
     */
    public String returnParentRef(IISCommonCO iisCommonCO) throws DAOException;

    /**
     * Return vat rate count
     * 
     * @param trsvatPERIODVO
     * @return
     * @throws DAOException
     */
    public BigDecimal getVatCountWithBranchAndCy(TRSVAT_PERIODVO trsvatPERIODVO) throws DAOException;

    /**
     * To return VAT percentage based on Branch and cy
     * 
     * @author mvalappil
     * @param trsvatPERIODVO
     * @return
     * @throws DAOException
     */
    public TRSVAT_PERIODVO returnVatRateByBranchAndCy(TRSVAT_PERIODVO trsvatPERIODVO) throws DAOException;

    /**
     * return Deal maturity account branch
     * 
     * @author mvalappil
     * @param trsdetvo
     * @return
     * @throws DAOException
     */
    public BigDecimal returnMaturityAccBr(TRSDETVO trsdetvo) throws DAOException;

    /**
     * Return Deal Currency
     * 
     * @author mvalappil
     * @param trsdealvo
     * @return
     * @throws DAOException
     */
    public BigDecimal returnDealCurrencyCode(TRSDEALVO trsdealvo) throws DAOException;

    public BigDecimal returnMaxInstPercSalary(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public BigDecimal getMonthlyBasicSalary(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public BigDecimal returnSumOfInstallmentAmount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public TRSCLASSVO returnProductClassDetails(TRSCLASSVOKey trsClassVOKey) throws DAOException;

    public IslamicCalculatorEventMgmtCO returnCifExistingDealCount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public BigDecimal returnExchangeRate(CommonLibSC commonLibSC) throws DAOException;

    public BigDecimal returnOutstandingAmountOfExistingDeals(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    /**
     * @param iisCommonCO
     * @return
     */
    public int returnCivilIdCount(IISCommonCO iisCommonCO) throws DAOException;

    int returnRelatedCYCount(IISCommonCO iisCommonCO) throws DAOException;

    BigDecimal returnLimitCY(TRSCIFLIMITDETVO trsciflimitdetvo) throws DAOException;

	public List<IISInvestmentDealCO> returnInvestDealList(IISInvestmentDealSC investmentDealSC) throws DAOException;
		
    BigDecimal returnNextLineInstallmentAmount(IISCommonCO iisCommonCO) throws DAOException;

    public Date returnFullySettledInstallmentDate(IISCommonCO iisCommonCO) throws DAOException;

    public Date returnPartialSettlementLastFullySettledInstallmentDate(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal returnPartialSettledPlanLineNbr(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal returnPlanLastLineNbr(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal returnRemainingProfitFromTrsdealdet(IISCommonCO iisCommonCO) throws DAOException;

    public BigDecimal returnRemainingProfitForPartialSettlted(IISCommonCO iisCommonCO) throws DAOException;

	public BigDecimal returnApplicableTieRate(IISCommonCO iisCommonCO) throws DAOException;

	public BigDecimal returnApplicableTieRateMinYield(IISCommonCO iisCommonCO) throws DAOException;


	public TRSCLASS_EXTENDEDVO returnTRSCLASSExtendedDetail(TRSCLASS_EXTENDEDVOKey trsclassExtendedVOKey)throws DAOException;

	public BigDecimal returnBlackListOverrideReasonMaxLineNbr(BLACKLIST_OVERRIDE_REASONVO blackListOverrideReasonVO)throws DAOException;

	public CifBlackListRestrictCO returnBlackListOverrideReasonDet(CifBlackListRestrictCO cifBlackListRestrictCO)throws DAOException;

	public void updatecifBlackListRestrict(BLACKLIST_OVERRIDE_REASONVO blackListOverrideReasonVO)throws DAOException;

	public IISCommonCO execP_RET_CHECK_BLACKLIST_RESTRICT(IISCommonCO iisCommonCO)throws DAOException;
	
	public String returnVatDeductionMethodOnCharge(TRSCHARGESVOKey trschargesvoKey) throws DAOException;

	public IISCommonCO returnCommonVatDetails(IISCommonCO iisCommonCO) throws DAOException;

	public String returnvatPercInd(IISCommonCO iisCommonCO) throws DAOException;

	public BigDecimal returnVatCodeChargesIncludeInst(IISCommonCO iisCommonCO)throws DAOException;

	public BigDecimal returnVatCountOtherCharge(IISCommonCO iisCommonCO)throws DAOException;
	
	TRSPAYPLANVO returnTrsPayPlanDetails(IISCommonCO iisCommonCO) throws DAOException;
	
    List<TRSPAYPLANDETVO> returnTrsPayPlanDetDetails(IISCommonCO iisCommonCO) throws DAOException;
    
    public List<TRSPAYPLANDETVO> returnFmsPayPlanDetDetails(IISCommonCO iisCommonParamCO) throws DAOException;;

}
