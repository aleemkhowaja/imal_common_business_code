package com.path.dao.common.iis.islamiccalculator.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dao.common.iis.islamiccalculator.IISCommonDAO;
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
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.iis.islamiccalculator.CifBlackListRestrictCO;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IISCustomerLimitCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorDBRatioSC;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.iis.common.IISInvestmentDealCO;
import com.path.vo.iis.common.IISInvestmentDealSC;
/**
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code<br>
 * <br>
 * 
 * DAO Class for IIS Common Functions.
 * 
 * @see com.path.dao.common.iis.islamiccalculator.impl.IISCommonDAOImpl
 * @author Bejoy
 * 
 */
public class IISCommonDAOImpl extends BaseDAO implements IISCommonDAO
{

    /**
     * Getting cif status details whether it is active,suspended etc...
     */
    @Override
    public IISCommonCO getCifStatus(IISCommonCO iisCommonCO) throws DAOException
    {
	return (IISCommonCO) getSqlMap().queryForObject("iisCommonMapper.selectCifStatus", iisCommonCO);
    }

    /**
     * Getting the blacklist details of a black listed cif
     */
    @Override
    public IISCommonCO getBlackListedDetails(IISCommonCO iisCommonCO) throws DAOException
    {
	return (IISCommonCO) getSqlMap().queryForObject("iisCommonMapper.selectBlackListDetails", iisCommonCO);
    }

    /**
     * Getting the allow blacklisted flag from IISCTRL
     */
    @Override
    public String isAllowBlackListed(IISCommonCO iisCommonCO) throws DAOException
    {
	return getSqlMap().queryForObject("iisCommonMapper.selectIsAllowBlackListed", iisCommonCO).toString();
    }

    /**
     * Method for getting the CIF number by passing Civil Id
     */
    @Override
    public BigDecimal getCif(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.selectCif", iisCommonCO);
    }

    @Override
    public Long getDaysAfterMaximumPeriod(IISCommonCO iisCommonCO) throws DAOException
    {
	return (Long) getSqlMap().queryForObject("iisCommonMapper.getDaysAfterMaximumPeriod", iisCommonCO);
    }

    @Override
    public String getHolidayActionDealDateYn(IISCommonCO iisCommonCO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("iisCommonMapper.getHolidayActionDealDateYn", iisCommonCO);
    }

    @Override
    public IslamicCalculatorEventMgmtCO getIISControlParams(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (IslamicCalculatorEventMgmtCO) getSqlMap().queryForObject("iisCommonMapper.getIISControlParams",
		islamicCalculatorEventMgmtCO);
    }

    public CIF_OCCUPATIONVO getCifIncome(IISCommonCO iisCommonCO) throws DAOException
    {
	return (CIF_OCCUPATIONVO) getSqlMap().queryForObject("iisCommonMapper.selectCifIncome", iisCommonCO);
    }

    /*
     * public IISCommonCO getCifType(IISCommonCO iisCommonCO) throws
     * DAOException { return (IISCommonCO)
     * getSqlMap().queryForObject("iisCommonMapper.selectCifType",iisCommonCO);
     * }
     */

    public IISCommonCO isCifTypeStaff(IISCommonCO iisCommonCO) throws DAOException
    {
	return (IISCommonCO) getSqlMap().queryForObject("iisCommonMapper.selectRifStaff", iisCommonCO);
    }

    public BigDecimal getOutstandingDealAmount(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.selectOutstandingDealAmount", iisCommonCO);
    }

    public BigDecimal getOutstandingDealAmountForGuarantor(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.selectOutstandingDealAmountForGuarantor",
		iisCommonCO);
    }

    public List<IslamicCalculatorDBRatioSC> getMonthlyInstallmentsByCif(IISCommonCO iisCommonCO) throws DAOException
    {
	return (List<IslamicCalculatorDBRatioSC>) getSqlMap()
		.queryForList("iisCommonMapper.selectMonthlyInstallmentsByCif", iisCommonCO);
    }

    public Long getMaxDealInstPerOfSal(IISCommonCO iisCommonCO) throws DAOException
    {
	return (Long) getSqlMap().queryForObject("iisCommonMapper.selectMaxDealInstPerOfSal", iisCommonCO);
    }

    public BigDecimal getRosterRegister(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.getRosterRegister", iisCommonCO);
    }

    public BigDecimal getCifType(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.getCifType", iisCommonCO);
    }

    public BigDecimal getRosterRegisterWithOutClass(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.getRosterRegisterWithOutClass", iisCommonCO);
    }

    @Override
    public List<TRSROSTER_REGISTER_DETVO> getYeildRegisterCif(TRSROSTER_REGISTER_DETVOKey trsRosterRegisterDetKey)
	    throws DAOException
    {
	return (ArrayList<TRSROSTER_REGISTER_DETVO>) getSqlMap().queryForList("iisCommonMapper.getYeildRegisterCif",
		trsRosterRegisterDetKey);
    }

    @Override
    public List<TRSROSTER_REGISTER_DETVO> getYeildRegisterAllCif(TRSROSTER_REGISTER_DETVOKey trsRosterRegisterDetKey)
	    throws DAOException
    {
	return (ArrayList<TRSROSTER_REGISTER_DETVO>) getSqlMap().queryForList("iisCommonMapper.getYeildRegisterAllCif",
		trsRosterRegisterDetKey);
    }

    @Override
    public BigDecimal getAccCifType(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.getAccCifType", iisCommonCO);
    }

    @Override
    public String getMaintainsalaryAc(IISCommonCO iisCommonCO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("iisCommonMapper.getMaintainsalaryAc", iisCommonCO);
    }

    @Override
    public BigDecimal getStaffYield(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.getStaffYield", iisCommonCO);
    }

    @Override
    public BigDecimal getYieldSalaryWithBank(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.getYieldSalaryWithBank", iisCommonCO);
    }

    @Override
    public BigDecimal getYieldModarib(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.getYieldModarib", iisCommonCO);
    }

    @Override
    public String getCalcFirstPaymentDateYn(IISCommonCO iisCommonCO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("iisCommonMapper.getCalcFirstPaymentDateYn", iisCommonCO);
    }

    @Override
    public TRSCLASSVO getGracePeriodClass(TRSCLASSVOKey trsClassKey) throws DAOException
    {
	return (TRSCLASSVO) getSqlMap().queryForObject("iisCommonMapper.getGracePeriodClass", trsClassKey);
    }

    @Override
    public Double getVatPercentage(IISCommonCO iisCommonCO) throws DAOException
    {
	return (Double) getSqlMap().queryForObject("iisCommonMapper.getVatPercentage", iisCommonCO);
    }

    @Override
    public Double getVatPercentageWithNoDate(IISCommonCO iisCommonCO) throws DAOException
    {
	return (Double) getSqlMap().queryForObject("iisCommonMapper.getVatPercentageWithNoDate", iisCommonCO);
    }

    @Override
    public BRANCH_HOLIDAYVO getBranchHoliday(BRANCH_HOLIDAYVO branchHolidayVO) throws DAOException
    {
	return (BRANCH_HOLIDAYVO) getSqlMap().queryForObject("iisCommonMapper.getBranchHoliday", branchHolidayVO);
    }

    @Override
    public COUNTRY_CALENDARVO getCountryCalendar(COUNTRY_CALENDARVOKey countryCalendarVO) throws DAOException
    {
	return (COUNTRY_CALENDARVO) getSqlMap().queryForObject("iisCommonMapper.getCountryCalendar", countryCalendarVO);
    }

    @Override
    public Long getCountryCode(COUNTRY_CALENDARVOKey countryCalendarVO) throws DAOException
    {
	return (Long) getSqlMap().queryForObject("iisCommonMapper.getCountryCode", countryCalendarVO);
    }

    @Override
    public COUNTRY_HOLIDAYVO getCountryHoliday(COUNTRY_HOLIDAYVO countryHolidayVO) throws DAOException
    {
	return (COUNTRY_HOLIDAYVO) getSqlMap().queryForObject("iisCommonMapper.getCountryHoliday", countryHolidayVO);
    }

    @Override
    public TRSCLASSVO getHolidayActions(TRSCLASSVOKey trsclassvoKey) throws DAOException
    {
	return (TRSCLASSVO) getSqlMap().queryForObject("iisCommonMapper.getHolidayActions", trsclassvoKey);
    }

    @Override
    public BigDecimal getHolidayAction(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.getHolidayAction", iisCommonCO);
    }

    @Override
    public Date getMaximumDateRate(IISCommonCO iisCommonCO) throws DAOException
    {
	return (Date) getSqlMap().queryForObject("iisCommonMapper.getMaximumDateRate", iisCommonCO);
    }

    @Override
    public BigDecimal getExchangeRateWrtDate(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.getExchangeRateWrtDate", iisCommonCO);
    }

    @Override
    public CURRENCIESVO getCurrencyDetails(CURRENCIESVOKey currenciesVOKey) throws DAOException
    {
	return (CURRENCIESVO) getSqlMap().queryForObject("iisCommonMapper.getCurrencyDetails", currenciesVOKey);
    }

    /**
     * Getting the getRifStaff
     */
    @Override
    public String getRifStaff(IISCommonCO iisCommonCO) throws DAOException
    {
	return getSqlMap().queryForObject("iisCommonMapper.selectRifStaff", iisCommonCO).toString();
    }

    @Override
    public IISCommonCO getUsrAccess(IISCommonCO iisCommonCO) throws DAOException
    {
	return (IISCommonCO) getSqlMap().queryForObject("iisCommonMapper.selectUsrAccess", iisCommonCO);
    }

    // @Override
    // public IISCTRLVO getIISCTRL(IISCTRLVOKey iisctrlvoKey) throws
    // DAOException
    // {
    // return (IISCTRLVO)
    // getSqlMap().queryForObject("iisCommonMapper.getIISCTRL", iisctrlvoKey);
    // }

    @Override
    public USRVO getUsrDetailsIIS(USRVO usrvo) throws DAOException
    {
	return (USRVO) getSqlMap().queryForObject("iisCommonMapper.getUsrDetailsIIS", usrvo);
    }

    @Override
    public String returnIISCONTROLValyByKey(BigDecimal seqKey, String flagName) throws DAOException
    {
	CommonLibSC commonLibSC = new CommonLibSC();
	commonLibSC.setCode(seqKey);
	commonLibSC.setFlag(flagName);
	return (String) getSqlMap().queryForObject("iisCommonMapper.returnIISCONTROLValyByKey", commonLibSC);
	// return (String)
	// getSqlMap().queryForObject("iisCommonMapper.returnIISCONTROLValyByKey",
	// seqKey);
    }

    // TP#253460; Ramesh; Date 29/12/2014
    @Override
    public BigDecimal returnTrsDealCount(TRSDEALVOKey trsdealvoKey) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnTrsDealCount", trsdealvoKey);
    }

    // TP#253460; Ramesh; Date 29/12/2014
    @Override
    public BigDecimal returnTrsClassCount(TRSCLASSVOKey trsclassvoKey) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnTrsClassCount", trsclassvoKey);
    }

    // TP#253460; Ramesh; Date 29/12/2014
    @Override
    public BigDecimal returnSettlementDivision(TRSCLASSVOKey trsclassvoKey) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnSettlementDivision", trsclassvoKey);
    }

    // TP#253460; Ramesh; Date 29/12/2014
    @Override
    public BigDecimal returnCountTrsSelmntAptNmt(TRSDEAL_STLMT_APTNMTVOKey trsdealSTLMTAPTNMTVOKey) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnCountTrsSelmntAptNmt",
		trsdealSTLMTAPTNMTVOKey);
    }

    // TP#253460; Ramesh; Date 29/12/2014
    @Override
    public BigDecimal returnCurrenciesCount(CURRENCIESVOKey currenciesvoKey) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnCurrenciesCount", currenciesvoKey);
    }

    // TP#253460; Ramesh; Date 29/12/2014
    @Override
    public String returnIISCtrlLimitBasedOn(IISCTRLVOKey iisctrlvoKey) throws DAOException
    {
	return (String) getSqlMap().queryForObject("iisCommonMapper.returnCurrenciesCount", iisctrlvoKey);
    }

    // TP#253460; Ramesh; Date 29/12/2014
    @Override
    public TRSPAYPLANDETVO returnSumOfCapitalAmtAndCptlAmtBeforeXirr(TRSPAYPLANVO trspayplanvo) throws DAOException
    {
	return (TRSPAYPLANDETVO) getSqlMap().queryForObject("iisCommonMapper.returnSumOfCapitalAmtAndCptlAmtBeforeXirr",
		trspayplanvo);
    }

    // TP#253460; Ramesh; Date 29/12/2014
    @Override
    public TRSPAYPLANDETVO returnTrsPayplanDetSumofValues(TRSPAYPLANVO trspayplanvo) throws DAOException
    {
	return (TRSPAYPLANDETVO) getSqlMap().queryForObject("iisCommonMapper.returnTrsPayplanDetSumofValues",
		trspayplanvo);
    }

    // BB130089; Saheer.Naduthodi; 14/05/2015
    @Override
    public BigDecimal returnOutstandingAmount(IISCustomerLimitCO iisCustomerLimitCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnOutstandingAmount", iisCustomerLimitCO);
    }

    // TP# BB130052;deepu.mohandas 25/05/2015
    @Override
    public TRSCIFLIMITDETVO returnClassLimitTenure(IISCommonCO iisCommonCO) throws DAOException
    {

	return (TRSCIFLIMITDETVO) getSqlMap().queryForObject("iisCommonMapper.returnClassLimitTenure", iisCommonCO);
    }

    @Override
    public AMFVO returnAccountByAccount(AMFVO amfVo) throws DAOException
    {
	return (AMFVO) getSqlMap().queryForObject("iisCommonMapper.returnAccountByAccount", amfVo);
    }

    @Override
    public AMFVO returnAccountByAdditionalRef(AMFVO amfVo) throws DAOException
    {
	return (AMFVO) getSqlMap().queryForObject("iisCommonMapper.returnAccountByAdditionalRef", amfVo);
    }

    /**
     * @author Arun.Variyath #TAR BB130030 11/08/2015
     * @param iisCommonCO
     * @return
     * @throws DAOException
     */
    @Override
    public String returnCalcMatDteFlagValue(IISCommonCO iisCommonCO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("iisCommonMapper.returnCalcMatDteFlagValue", iisCommonCO);
    }

    /**
     * // TP# 222800 BM140006 - Limit for Yield Roster in IIS start Sreejith
     */
    @Override
    public BigDecimal returnCodeFromTRSROSTER_REGISTER(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnCodeFromTRSROSTER_REGISTER", iisCommonCO);
    }

    @Override
    public List<TRSROSTER_REGISTER_DETVO> returnTRSROSTER_REGISTER_DETData(
	    TRSROSTER_REGISTER_DETVO trsrosterREGISTERDETVO) throws DAOException
    {
	return (List<TRSROSTER_REGISTER_DETVO>) getSqlMap()
		.queryForList("iisCommonMapper.returnTRSROSTER_REGISTER_DETData", trsrosterREGISTERDETVO);
    }

    @Override
    public CIFVO returnCifTypeAndMaintSalaryAcc(IISCommonCO iisCommonCO) throws DAOException
    {
	return (CIFVO) getSqlMap().queryForObject("iisCommonMapper.returnCifTypeAndMaintSalaryAcc", iisCommonCO);
    }

    @Override
    public BigDecimal returnCifTypeFromACC_NV_CONTROL(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnCifTypeFromACC_NV_CONTROL", iisCommonCO);
    }

    @Override
    public IISCommonCO returnYieldFromTRSROSTERDET(IISCommonCO iisCommonCO) throws DAOException
    {
	return (IISCommonCO) getSqlMap().queryForObject("iisCommonMapper.returnYieldFromTRSROSTERDET", iisCommonCO);
    }

    @Override
    public IISCommonCO returnAllowEditOutSideRangeAndDefaultedYield(IISCommonCO iisCommonCO) throws DAOException
    {
	return (IISCommonCO) getSqlMap().queryForObject("iisCommonMapper.returnAllowEditOutSideRangeAndDefaultedYield",
		iisCommonCO);
    }

    /**
     * // TP# 222800BM140006 - Limit for Yield Roster in IIS end Sreejith
     */
    @Override
    public BigDecimal returnRecCountFromTRSDEAL_YIELD_AMENDED(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnRecCountFromTRSDEAL_YIELD_AMENDED",
		iisCommonCO);
    }

    /**
     * TP 253158 -Renaming by product category - Sreejith
     */
    @Override
    public List<TRSCLASS_KEY_LABELVO> returnTrsClassLabelVOData(IISCommonCO iisCommonCO) throws DAOException
    {
	return (List<TRSCLASS_KEY_LABELVO>) getSqlMap().queryForList("iisCommonMapper.returnTrsClassLabelVOData",
		iisCommonCO);
    }

    /**
     * TP 253158 -Renaming by product category - Sreejith
     */
    @Override
    public String returnParentRef(IISCommonCO iisCommonCO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("iisCommonMapper.returnParentRef", iisCommonCO);
    }

    @Override
    public BigDecimal getVatCountWithBranchAndCy(TRSVAT_PERIODVO trsvatPERIODVO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.getVatCountWithBranchAndC", trsvatPERIODVO);
    }

    @Override
    public TRSVAT_PERIODVO returnVatRateByBranchAndCy(TRSVAT_PERIODVO trsvatPERIODVO) throws DAOException
    {
	return (TRSVAT_PERIODVO) getSqlMap().queryForObject("iisCommonMapper.returnVatRateByBranchAndCy",
		trsvatPERIODVO);
    }

    @Override
    public BigDecimal returnMaturityAccBr(TRSDETVO trsdetvo) throws DAOException
    {
		return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.getVatCountWithBranchAndCy", trsdetvo);

    }

    @Override
    public BigDecimal returnDealCurrencyCode(TRSDEALVO trsdealvo) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnDealCurrencyCode", trsdealvo);
    }

    @Override
    public BigDecimal returnMaxInstPercSalary(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.selectMaxInstPercentageSalary",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal getMonthlyBasicSalary(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnMonthlyBasicSalary",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal returnSumOfInstallmentAmount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.selectSumOfInstallmentAmt",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public TRSCLASSVO returnProductClassDetails(TRSCLASSVOKey trsClassVOKey) throws DAOException
    {
	return (TRSCLASSVO) getSqlMap().queryForObject("iisCommonMapper.returnTRSCLASSDetails", trsClassVOKey);
    }

    /**
     * Method to return the Deal Count for CIF
     * 
     * @param IISCTRLVO,IISCommonParamCO
     * @return IISCommonParamCO
     * @throws BaseException
     */
    @Override
    public IslamicCalculatorEventMgmtCO returnCifExistingDealCount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (IslamicCalculatorEventMgmtCO) getSqlMap().queryForObject("iisCommonMapper.CifExistingDealCount",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal returnExchangeRate(CommonLibSC commonLibSC) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.selectExchangeRate", commonLibSC);
    }

    @Override
    public BigDecimal returnOutstandingAmountOfExistingDeals(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.selectOutstandingAmountOfExistingDeals",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public int returnCivilIdCount(IISCommonCO iisCommonCO) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("iisCommonMapper.returnCivilIdCount", iisCommonCO);
    }

    @Override
    public int returnRelatedCYCount(IISCommonCO iisCommonCO) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("iisCommonMapper.returnRelatedCYCount", iisCommonCO);
    }

    @Override
    public BigDecimal returnLimitCY(TRSCIFLIMITDETVO trsciflimitdetvo) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnLimitCY", trsciflimitdetvo);
    }

	@Override
    public List<IISInvestmentDealCO> returnInvestDealList(IISInvestmentDealSC investmentDealSC) throws DAOException
    {
	return (List<IISInvestmentDealCO>) getSqlMap().queryForList("iisCommonMapper.returnInvestDealList",
		investmentDealSC);
    }
	
    @Override
    public BigDecimal returnNextLineInstallmentAmount(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnNextLineInstallmentAmount", iisCommonCO);
    }

    @Override
    public Date returnFullySettledInstallmentDate(IISCommonCO iisCommonCO) throws DAOException
    {
	return (Date) getSqlMap().queryForObject("iisCommonMapper.returnFullySettledInstallmentDate", iisCommonCO);
    }

    @Override
    public Date returnPartialSettlementLastFullySettledInstallmentDate(IISCommonCO iisCommonCO) throws DAOException
    {
	return (Date) getSqlMap()
		.queryForObject("iisCommonMapper.returnPartialSettlementLastFullySettledInstallmentDate", iisCommonCO);
    }

    @Override
    public BigDecimal returnPartialSettledPlanLineNbr(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnPartialSettledPlanLineNbr", iisCommonCO);
    }

    @Override
    public BigDecimal returnPlanLastLineNbr(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnPlanLastLineNbr", iisCommonCO);
    }

    @Override
    public BigDecimal returnRemainingProfitFromTrsdealdet(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnRemainingProfitFromTrsdealdet",
		iisCommonCO);
    }

    @Override
    public BigDecimal returnRemainingProfitForPartialSettlted(IISCommonCO iisCommonCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnRemainingProfitForPartialSettlted",
		iisCommonCO);
    }

	@Override
	public BigDecimal returnApplicableTieRate(IISCommonCO iisCommonCO) throws DAOException {
		return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnApplicableTieRate", iisCommonCO);
	}

	@Override
	public BigDecimal returnApplicableTieRateMinYield(IISCommonCO iisCommonCO) throws DAOException {
		return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnApplicableTieRateMinYield", iisCommonCO);
	}


	@Override
	public TRSCLASS_EXTENDEDVO returnTRSCLASSExtendedDetail(TRSCLASS_EXTENDEDVOKey trsclassExtendedVOKey) throws DAOException {
		return (TRSCLASS_EXTENDEDVO) getSqlMap().queryForObject("iisCommonMapper.returnTRSCLASSExtendedDetail", trsclassExtendedVOKey);
	}

	@Override
	public BigDecimal returnBlackListOverrideReasonMaxLineNbr(BLACKLIST_OVERRIDE_REASONVO blackListOverrideReasonVO)
			throws DAOException {
		return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnBlackListOverrideReasonMaxLineNbr", blackListOverrideReasonVO);
	}

	@Override
	public CifBlackListRestrictCO returnBlackListOverrideReasonDet(CifBlackListRestrictCO cifBlackListRestrictCO)
			throws DAOException {
		return (CifBlackListRestrictCO) getSqlMap().queryForObject("iisCommonMapper.returnBlackListOverrideReasonDet", cifBlackListRestrictCO.getBlackListOverrideReasonVO());
	}

	@Override
	public void updatecifBlackListRestrict(BLACKLIST_OVERRIDE_REASONVO blackListOverrideReasonVO) throws DAOException {
		 getSqlMap().update("iisCommonMapper.updatecifBlackListRestrict", blackListOverrideReasonVO);
	}

	@Override
	public IISCommonCO execP_RET_CHECK_BLACKLIST_RESTRICT(IISCommonCO iisCommonCO) throws DAOException {
		getSqlMap().update("iisCommonMapper.execP_RET_CHECK_BLACKLIST_RESTRICT", iisCommonCO);
		return iisCommonCO;
	}
	
	@Override
	public String returnVatDeductionMethodOnCharge(TRSCHARGESVOKey trschargesvoKey) throws DAOException {
		return (String) getSqlMap().queryForObject("iisCommonMapper.returnVatDeductionMethodOnCharge", trschargesvoKey);
	}

	@Override
	public IISCommonCO returnCommonVatDetails(IISCommonCO iisCommonCO) throws DAOException {
		getSqlMap().update("iisCommonMapper.execP_WRAP_CORE_GET_VAT_DETAILS_IIS", iisCommonCO);
		return iisCommonCO;
	}

	@Override
	public String returnvatPercInd(IISCommonCO iisCommonCO) throws DAOException {
		return (String) getSqlMap().queryForObject("iisCommonMapper.returnvatPercInd", iisCommonCO);
	}

	@Override
	public BigDecimal returnVatCodeChargesIncludeInst(IISCommonCO iisCommonCO) throws DAOException {
		return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnVatCodeChargesIncludeInst", iisCommonCO);
	}

	@Override
	public BigDecimal returnVatCountOtherCharge(IISCommonCO iisCommonCO) throws DAOException {
		return (BigDecimal) getSqlMap().queryForObject("iisCommonMapper.returnVatCountOtherCharge", iisCommonCO);
	}

	@Override
    public TRSPAYPLANVO returnTrsPayPlanDetails(IISCommonCO iisCommonCO) throws DAOException
    {
	return (TRSPAYPLANVO) getSqlMap().queryForObject("iisCommonMapper.returnTrsPayPlanDetails", iisCommonCO);
    }

    @Override
    public List<TRSPAYPLANDETVO> returnTrsPayPlanDetDetails(IISCommonCO iisCommonCO) throws DAOException
    {
	return (List<TRSPAYPLANDETVO>) getSqlMap().queryForList("iisCommonMapper.returnTrsPayPlanDetDetails",
		iisCommonCO);
    }

    @Override
    public List<TRSPAYPLANDETVO> returnFmsPayPlanDetDetails(IISCommonCO iisCommonParamCO) throws DAOException
    {
	return (List<TRSPAYPLANDETVO>) getSqlMap().queryForList("iisCommonMapper.returnFmsPayPlanDetDetails",
		iisCommonParamCO);
    }


}
