package com.path.dao.common.iis.islamiccalculator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.TRSCHARGESVO;
import com.path.dbmaps.vo.TRSCHARGESVOKey;
import com.path.dbmaps.vo.TRSCIFLIMITDETVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSCLASSVOKey;
import com.path.dbmaps.vo.TRSDEAL2VOKey;
import com.path.dbmaps.vo.TRSDEAL3VO;
import com.path.dbmaps.vo.TRSDEAL3VOKey;
import com.path.dbmaps.vo.TRSDEALCHARGESVOKey;
import com.path.dbmaps.vo.TRSDEALVO;
import com.path.dbmaps.vo.TRSDEALVOKey;
import com.path.dbmaps.vo.TRSDEAL_COUNTRY_HOLIDAYVO;
import com.path.dbmaps.vo.TRSDEAL_COUNTRY_HOLIDAYVOKey;
import com.path.dbmaps.vo.TRSDEAL_COVERING_ACCOUNTSVO;
import com.path.dbmaps.vo.TRSDEAL_MULTIPLE_YIELDVO;
import com.path.dbmaps.vo.TRSDEAL_MULTIPLE_YIELDVOKey;
import com.path.dbmaps.vo.TRSDEAL_NIDCVO;
import com.path.dbmaps.vo.TRSDEAL_NIDCVOKey;
import com.path.dbmaps.vo.TRSDEAL_NIDC_DETVO;
import com.path.dbmaps.vo.TRSDETVO;
import com.path.dbmaps.vo.TRSHIJRI_DETAIL_CALENDARVO;
import com.path.dbmaps.vo.TRSPAYPLANDETVO;
import com.path.dbmaps.vo.TRSPAYPLANDETVOKey;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTDETVO;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTDETVOKey;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVOKey;
import com.path.dbmaps.vo.TRSPAYPLANVO;
import com.path.dbmaps.vo.TRSPAYPLAN_BREAKUP_PROFITVO;
import com.path.dbmaps.vo.TRSVATVOKey;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.common.iis.islamiccalculator.TrsDealSettlementChargesCO;

public interface IISIslamicCalculatorDAO
{
    public List<TRSDEAL_MULTIPLE_YIELDVO> getDealMultipleYield(TRSDEAL_MULTIPLE_YIELDVOKey trsDealMultipleYieldVOKey)
	    throws DAOException;

    public TRSCHARGESVO getDealChargesInsuranceYn(TRSCHARGESVOKey trsChargesVOKey) throws DAOException;

    public CURRENCIESVO getCurrencyBaseInfo(CURRENCIESVOKey currenciesVoKey) throws DAOException;

    // public IISCTRLVO getIisCtrlInfoForRepaymentPlan(IISCTRLVO iisCtrlVO)
    // throws DAOException;

    public List<TRSPAYPLANTMPLTDETVO> getTemplateDetails(TRSPAYPLANTMPLTDETVOKey trsPayplanTmpltDetVOKey)
	    throws DAOException;;

    public String getLastInstallmentDateAsMaturityDateYN(TRSPAYPLANTMPLTVOKey trsPayplanTmpltVOKey) throws DAOException;

    public TRSCLASSVO getProductClassDetails(TRSCLASSVOKey trsClassVOKey) throws DAOException;

    public TRSHIJRI_DETAIL_CALENDARVO getHijiriDate(TRSHIJRI_DETAIL_CALENDARVO trsHijriDetailCalendarVO)
	    throws DAOException;

    public List<TRSDEAL_COUNTRY_HOLIDAYVO> getTrsdealCountryHolidayList(
	    TRSDEAL_COUNTRY_HOLIDAYVOKey trsdealCountryHolidayVOKey) throws DAOException;

    public String getVatPercentageInt(TRSCLASSVOKey trsClassVOKey) throws DAOException;
    
    public TRSCLASSVO getHolidayActions(TRSCLASSVOKey trsClassVOKey) throws DAOException;

    public TRSDEALVO getTrsDealDetails(TRSDEALVOKey trsdealvoKey) throws DAOException;

    public List<TRSDEAL3VO> getDealDisbursementDetails(TRSDEAL3VOKey trsdeal3voKey) throws DAOException;

    public List<TrsDealChargesCO> getDealChargesdet(TRSDEALCHARGESVOKey trsdealchargesvoKey) throws DAOException;

    public TRSDETVO getDealMaturityAccount(TRSDEALVOKey trsdealvoKey) throws DAOException;

    public TRSDEAL_NIDCVO getNidcDeal(TRSDEAL_NIDCVOKey trsdealNIDCVOKey) throws DAOException;

    public List<TRSDEAL_NIDC_DETVO> getNidcDealDetails(TRSDEAL_NIDCVOKey trsdealNIDCVOKey) throws DAOException;

    public List<TRSPAYPLANDETVO> returnPlanScheduleList(TRSPAYPLANDETVOKey trspayplandetvoKey) throws DAOException;

    public List<TRSPAYPLANVO> returnTrspayplanListByTrxNo(TRSPAYPLANVO trspayplanvoKey) throws DAOException;

    public Date returnLastFullySettledInstllmentDate(TRSPAYPLANVO trspayplanvoKey) throws DAOException;

    public TRSDEALVO getTrsDealDisbursmentDetails(TRSDEALVOKey trsdealvoKey) throws DAOException;

    public BigDecimal returnRescheduleCountByDealAndDate(BigDecimal companyCode, BigDecimal branchCode,
	    BigDecimal dealNo, Date fromDate, Date lineValueDate) throws DAOException;

    public List<TRSPAYPLANDETVO> returnDisbursePlanScheduleList(TRSPAYPLANDETVOKey trspayplandetvoKey)
	    throws DAOException;

    // DN# EWBI160013; deepu.mohandas 29/04/2016
    public BigDecimal returnExcessiveProfitRate(IslamicCalculatorCO calculatorCO) throws DAOException;

    // DN# EWBI160013; deepu.mohandas 29/04/2016
    public BigDecimal returnMinYield(IslamicCalculatorCO calculatorCO) throws DAOException;

    // DN# EWBI160013; deepu.mohandas 29/04/2016
    public List<TRSCHARGESVO> returnTtrschargesVOList(IslamicCalculatorCO islamicCalculatorCO) throws DAOException;

    public BigDecimal returnMarginRate(IslamicCalculatorCO calculatorCO) throws DAOException;

    public BigDecimal returnTotalAccrualProfitAsOfDate(BigDecimal compCODE, BigDecimal branch, BigDecimal dealNo,
	    Date valueDate) throws DAOException;

    public BigDecimal returnTotalPlanProfitAsOfDate(BigDecimal compCODE, BigDecimal branch, BigDecimal planNBR,
	    BigDecimal planNBR2, Date valueDate) throws DAOException;

    public BigDecimal returnTotalPlanSettledProfitAsOfDate(BigDecimal compCODE, BigDecimal branch, BigDecimal planNBR,
	    BigDecimal planNBR2, Date valueDate) throws DAOException;

    /**
     * @param trsdeal2voKey
     * @return
     * @throws DAOException
     */
    public BigDecimal returnAgencyFeePcnt(TRSDEAL2VOKey trsdeal2voKey) throws DAOException;

    // EWBI160081; Saheer.Naduthodi; 02/03/2017
    public List<TrsDealSettlementChargesCO> returnDealSettlementChargeDet(IslamicCalculatorCO islamicCalculatorCO)
	    throws DAOException;

    public TRSDEAL_COVERING_ACCOUNTSVO returnTrsDealCoveringAccountDet(IslamicCalculatorCO islamicCalculatorCO)
	    throws DAOException;

    public String returnAccountName(TRSDEAL_COVERING_ACCOUNTSVO trsDealCoveringAccountVO) throws DAOException;

    // 615217 deepu 06/02/2018
    public TRSCIFLIMITDETVO returnTrsCifLimitDetValue(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    /**
     * @param trsciflimitdetvoKey
     * @return
     */
    public TRSCIFLIMITDETVO returnTRSCIFLIMITDET(TRSCIFLIMITDETVO trsciflimitdetvoKey) throws DAOException;

    public IslamicCalculatorEventMgmtCO populateOnChangeProductClass(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

	public BigDecimal returnTotalAccrualProfitAsOfDateWithNewRate(IISCommonCO iisCommonCO)throws DAOException;    

	public BigDecimal returnTotalPlanProfitAsOfDate(IISCommonCO iisCommonCO)throws DAOException;

	public List<TRSPAYPLANDETVO> returnPlanScheduleFirstLegList(TRSPAYPLANDETVOKey trspayplandetvoKey) throws DAOException;

	public List<TRSPAYPLANVO> returnTrspayplanFirstLegListByTrxNo(TRSPAYPLANVO trspayplanvoKey)throws DAOException;
/**
     * @param trspayplanvo
     * @return
     */
    public Date returnDealFirstPaymentDate(TRSPAYPLANVO trspayplanvo) throws DAOException;

    public List<TRSPAYPLAN_BREAKUP_PROFITVO> returnTRSPAYPLAN_BREAKUP_PROFITList(TRSPAYPLANVO trspayplanvo)
	    throws DAOException;


    /**
     * @param trsdeal2voKey
     * @return
     * @throws DAOException
     */
    //public BigDecimal returnAgencyFeePcnt(TRSDEAL2VOKey trsdeal2voKey) throws DAOException;

	public BigDecimal returnTotalDsibursedAfterVDate(TRSPAYPLANVO trspayplanvo) throws DAOException;

	public BigDecimal returnCurrentDsiburseAmount(TRSDEALVO trsdealvo)throws DAOException;

	public BigDecimal returnCurrentMultipleYield(TRSDEALVO trsdealvo) throws DAOException;

	public int returnMultipleYieldCount(TRSDEALVO trsdealvo1) throws DAOException;
	
	public TRSCHARGESVO getChargesDetails(TRSCHARGESVOKey trschargesVoKey) throws DAOException;

}
