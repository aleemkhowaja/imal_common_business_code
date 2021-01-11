package com.path.dao.common.iis.islamiccalculator.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.dao.common.iis.islamiccalculator.IISIslamicCalculatorDAO;
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
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.common.iis.islamiccalculator.TrsDealSettlementChargesCO;

/**
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code<br>
 * <br>
 * 
 * DAO Class for Islamic Calculator Functions.
 * 
 * @see com.path.dao.common.iis.islamiccalculator.impl.IISIslamicCalculatorDAOImpl
 * @author mvalappil
 * 
 */
public class IISIslamicCalculatorDAOImpl extends BaseDAO implements IISIslamicCalculatorDAO
{

    @Override
    public TRSCHARGESVO getDealChargesInsuranceYn(TRSCHARGESVOKey trsChargesVOKey) throws DAOException
    {
	return (TRSCHARGESVO) getSqlMap().queryForObject("iisIslamicCalculator.getDealChargesInsuranceYn", trsChargesVOKey);
    }

    @Override
    public List<TRSDEAL_MULTIPLE_YIELDVO> getDealMultipleYield(TRSDEAL_MULTIPLE_YIELDVOKey trsDealMultipleYieldVOKey)
	    throws DAOException
    {
	return (List<TRSDEAL_MULTIPLE_YIELDVO>) getSqlMap().queryForList("iisIslamicCalculator.getDealMultipleYield",
		trsDealMultipleYieldVOKey);
    }

    @Override
    public CURRENCIESVO getCurrencyBaseInfo(CURRENCIESVOKey currenciesVoKey) throws DAOException
    {
	return (CURRENCIESVO) getSqlMap().queryForObject("iisIslamicCalculator.getCurrencyBaseInfo", currenciesVoKey);
    }

    // public IISCTRLVO getIisCtrlInfoForRepaymentPlan(IISCTRLVO iisCtrlVO)
    // throws DAOException
    // {
    // return (IISCTRLVO)
    // getSqlMap().queryForObject("iisIslamicCalculator.getIisCtrlInfoForRepaymentPlan",
    // iisCtrlVO);
    // }

    @Override
    public String getLastInstallmentDateAsMaturityDateYN(TRSPAYPLANTMPLTVOKey trsPayplanTmpltVOKey) throws DAOException
    {
	return (String) getSqlMap().queryForObject("iisIslamicCalculator.getLastInstallmentDateasMaturityDateYN",
		trsPayplanTmpltVOKey);
    }

    @Override
    public List<TRSPAYPLANTMPLTDETVO> getTemplateDetails(TRSPAYPLANTMPLTDETVOKey trsPayplanTmpltDetVOKey)
	    throws DAOException
    {
	return (List<TRSPAYPLANTMPLTDETVO>) getSqlMap().queryForList("iisIslamicCalculator.getTemplateDetails",
		trsPayplanTmpltDetVOKey);
    }

    @Override
    public TRSHIJRI_DETAIL_CALENDARVO getHijiriDate(TRSHIJRI_DETAIL_CALENDARVO trsHijriDetailCalendarVO)
	    throws DAOException
    {
	return (TRSHIJRI_DETAIL_CALENDARVO) getSqlMap().queryForObject("iisIslamicCalculator.getHijiriDate",
		trsHijriDetailCalendarVO);
    }

    @Override
    public TRSCLASSVO getProductClassDetails(TRSCLASSVOKey trsClassVOKey) throws DAOException
    {
	return (TRSCLASSVO) getSqlMap().queryForObject("iisIslamicCalculator.getProducClassDetails", trsClassVOKey);
    }

    @Override
    public List<TRSDEAL_COUNTRY_HOLIDAYVO> getTrsdealCountryHolidayList(
	    TRSDEAL_COUNTRY_HOLIDAYVOKey trsdealCountryHolidayVOKey) throws DAOException
    {
	return (List<TRSDEAL_COUNTRY_HOLIDAYVO>) getSqlMap()
		.queryForList("iisIslamicCalculator.getTrsdealCountryHolidayList", trsdealCountryHolidayVOKey);
    }

    @Override
    public String getVatPercentageInt(TRSCLASSVOKey trsClassVOKey) throws DAOException
    {
	return (String) getSqlMap().queryForObject("iisIslamicCalculator.getVatPercentageInt", trsClassVOKey);
    }

    @Override
    public TRSCLASSVO getHolidayActions(TRSCLASSVOKey trsClassVOKey) throws DAOException
    {
	return (TRSCLASSVO) getSqlMap().queryForObject("iisCommonMapper.getHolidayActions", trsClassVOKey);
    }

    @Override
    public TRSDEALVO getTrsDealDetails(TRSDEALVOKey trsdealvoKey) throws DAOException
    {
	return (TRSDEALVO) getSqlMap().queryForObject("iisIslamicCalculator.getTrsDealDetails", trsdealvoKey);
    }

    @Override
    public List<TRSDEAL3VO> getDealDisbursementDetails(TRSDEAL3VOKey trsdeal3voKey) throws DAOException
    {
	return (List<TRSDEAL3VO>) getSqlMap().queryForList("iisIslamicCalculator.getDealDisbursementDetails",
		trsdeal3voKey);
    }

    @Override
    public List<TrsDealChargesCO> getDealChargesdet(TRSDEALCHARGESVOKey trsdealchargesvoKey) throws DAOException
    {
	return (List<TrsDealChargesCO>) getSqlMap().queryForList("iisIslamicCalculator.getDealChargesdet",
		trsdealchargesvoKey);
    }

    @Override
    public TRSDETVO getDealMaturityAccount(TRSDEALVOKey trsdealvoKey) throws DAOException
    {
	return (TRSDETVO) getSqlMap().queryForObject("iisIslamicCalculator.getDealMaturityAccount", trsdealvoKey);
    }

    @Override
    public TRSDEAL_NIDCVO getNidcDeal(TRSDEAL_NIDCVOKey trsdealNIDCVOKey) throws DAOException
    {
	return (TRSDEAL_NIDCVO) getSqlMap().queryForObject("iisIslamicCalculator.getNidcDeal", trsdealNIDCVOKey);
    }

    @Override
    public List<TRSDEAL_NIDC_DETVO> getNidcDealDetails(TRSDEAL_NIDCVOKey trsdealNIDCVOKey) throws DAOException
    {
	return (List<TRSDEAL_NIDC_DETVO>) getSqlMap().queryForList("iisIslamicCalculator.getNidcDealDetails",
		trsdealNIDCVOKey);
    }

    @Override
    public List<TRSPAYPLANDETVO> returnPlanScheduleList(TRSPAYPLANDETVOKey trspayplandetvoKey) throws DAOException
    {
	return (List<TRSPAYPLANDETVO>) getSqlMap().queryForList("iisIslamicCalculator.returnPlanScheduleList",
		trspayplandetvoKey);
    }

    @Override
    public List<TRSPAYPLANVO> returnTrspayplanListByTrxNo(TRSPAYPLANVO trspayplanvoKey) throws DAOException
    {
	return (List<TRSPAYPLANVO>) getSqlMap().queryForList("iisIslamicCalculator.returnPlanHeaderList",
		trspayplanvoKey);
    }

    @Override
    public Date returnLastFullySettledInstllmentDate(TRSPAYPLANVO trspayplanvoKey) throws DAOException
    {
	return (Date) getSqlMap().queryForObject("iisIslamicCalculator.returnLastFullySettledInstllmentDate",
		trspayplanvoKey);
    }

    @Override
    public TRSDEALVO getTrsDealDisbursmentDetails(TRSDEALVOKey trsdealvoKey) throws DAOException
    {
	return (TRSDEALVO) getSqlMap().queryForObject("iisIslamicCalculator.getTrsDealDisbursmentDetails",
		trsdealvoKey);
    }

    @Override
    public BigDecimal returnRescheduleCountByDealAndDate(BigDecimal companyCode, BigDecimal branchCode,
	    BigDecimal dealNo, Date fromDate, Date toDate) throws DAOException
    {
	TRSPAYPLANVO trspayplanvo = new TRSPAYPLANVO();
	trspayplanvo.setCOMP_CODE(companyCode);
	trspayplanvo.setBRANCH(branchCode);
	trspayplanvo.setTRX_NBR(dealNo);
	trspayplanvo.setDATE_CREATED(fromDate);
	trspayplanvo.setDATE_APPROVED(toDate);
	return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnRescheduleCountByDealAndDate",
		trspayplanvo);
    }

    @Override
    public List<TRSPAYPLANDETVO> returnDisbursePlanScheduleList(TRSPAYPLANDETVOKey trspayplandetvoKey)
	    throws DAOException
    {
	return (List<TRSPAYPLANDETVO>) getSqlMap().queryForList("iisIslamicCalculator.returnDisbursePlanScheduleList",
		trspayplandetvoKey);
    }

    @Override
    public BigDecimal returnTotalAccrualProfitAsOfDate(BigDecimal compCode, BigDecimal branchCode, BigDecimal dealno,
	    Date valueDate) throws DAOException
    {
	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setCompCode(compCode);
	iisCommonCO.setBranchCode(branchCode);
	iisCommonCO.setDealNo(dealno);
	iisCommonCO.setValueDate(valueDate);

	return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnTotalAccrualProfitAsOfDate",
		iisCommonCO);
    }

    @Override
    public BigDecimal returnTotalPlanProfitAsOfDate(BigDecimal compCode, BigDecimal branchCode, BigDecimal planNbr,
	    BigDecimal planSeq, Date valueDate) throws DAOException
    {
	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setCompCode(compCode);
	iisCommonCO.setBranchCode(branchCode);

	iisCommonCO.setPlanNbr(planNbr);
	iisCommonCO.setPlanSeq(planSeq);
	iisCommonCO.setValueDate(valueDate);
	return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnTotalPlanProfitAsOfDate",
		iisCommonCO);
    }

    @Override
    public BigDecimal returnTotalPlanSettledProfitAsOfDate(BigDecimal compCode, BigDecimal branchCode,
	    BigDecimal planNbr, BigDecimal planSeq, Date valueDate) throws DAOException
    {
	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setCompCode(compCode);
	iisCommonCO.setBranchCode(branchCode);

	iisCommonCO.setPlanNbr(planNbr);
	iisCommonCO.setPlanSeq(planSeq);
	iisCommonCO.setValueDate(valueDate);
	return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnTotalPlanSettledProfitAsOfDate",
		iisCommonCO);
    }

    // #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015 [Start]
    @Override
    public BigDecimal returnAgencyFeePcnt(TRSDEAL2VOKey trsdeal2voKey) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnAgencyFeePcnt", trsdeal2voKey);
    }

    // #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015 [End]
    // EWBI160081; Saheer.Naduthodi; 02/03/2017
    @Override
    public List<TrsDealSettlementChargesCO> returnDealSettlementChargeDet(IslamicCalculatorCO islamicCalculatorCO)
	    throws DAOException
    {
    	return (List<TrsDealSettlementChargesCO>) getSqlMap()
		.queryForList("iisIslamicCalculator.returnDealSettlementChargeDetails", islamicCalculatorCO);
    }

    // TP 546955 BB160195 Fawas.Kuruvakkottil 23/01/2018
    @Override
    public TRSDEAL_COVERING_ACCOUNTSVO returnTrsDealCoveringAccountDet(IslamicCalculatorCO islamicCalculatorCO)
	    throws DAOException
    {
	return (TRSDEAL_COVERING_ACCOUNTSVO) getSqlMap()
		.queryForObject("iisIslamicCalculator.returnTrsDealCoveringAccountDet", islamicCalculatorCO);
    }

    @Override
    public String returnAccountName(TRSDEAL_COVERING_ACCOUNTSVO trsDealCoveringAccountVO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("iisIslamicCalculator.returnAccountName", trsDealCoveringAccountVO);
    }
    // TP 546955 BB160195 Fawas.Kuruvakkottil 23/01/2018 [End]

    @Override
    public TRSCIFLIMITDETVO returnTrsCifLimitDetValue(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (TRSCIFLIMITDETVO) getSqlMap().queryForObject("iisIslamicCalculator.returnTrsCifLimitDetValueCalc",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public TRSCIFLIMITDETVO returnTRSCIFLIMITDET(TRSCIFLIMITDETVO trsciflimitdetvoKey) throws DAOException
    {
	return (TRSCIFLIMITDETVO) getSqlMap().queryForObject("iisIslamicCalculator.returnTRSCIFLIMITDET",
		trsciflimitdetvoKey);
    }

    @Override
    public IslamicCalculatorEventMgmtCO populateOnChangeProductClass(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (IslamicCalculatorEventMgmtCO) getSqlMap()
		.queryForObject("iisIslamicCalculator.selectOnChangeProductClass", islamicCalculatorEventMgmtCO);
    }

	@Override
	public BigDecimal returnTotalAccrualProfitAsOfDateWithNewRate(IISCommonCO iisCommonCO) throws DAOException {
		

		return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnTotalAccrualProfitAsOfDateWithNewRate",
			iisCommonCO);
	}

	@Override
	public BigDecimal returnTotalPlanProfitAsOfDate(IISCommonCO iisCommonCO) throws DAOException {
		return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnTotalPlanProfitAsOfDate",
				iisCommonCO);
	}

	@Override
	public List<TRSPAYPLANDETVO> returnPlanScheduleFirstLegList(TRSPAYPLANDETVOKey trspayplandetvoKey)
			throws DAOException {
	return (List<TRSPAYPLANDETVO>) getSqlMap().queryForList("iisIslamicCalculator.returnPlanScheduleFirstLegList",
				trspayplandetvoKey);
	}

	@Override
	public List<TRSPAYPLANVO> returnTrspayplanFirstLegListByTrxNo(TRSPAYPLANVO trspayplanvoKey) throws DAOException{
	return (List<TRSPAYPLANVO>) getSqlMap().queryForList("iisIslamicCalculator.returnTrspayplanFirstLegListByTrxNo",
				trspayplanvoKey);
	}


    /*
     * (non-Javadoc)
     * 
     * @see com.path.dao.common.iis.islamiccalculator.IISIslamicCalculatorDAO#
     * returnDealFirstPaymentDate(com.path.dbmaps.vo.TRSPAYPLANVO)
     */
    @Override
    public Date returnDealFirstPaymentDate(TRSPAYPLANVO trspayplanvo) throws DAOException
    {
	return (Date) getSqlMap().queryForObject("iisIslamicCalculator.returnDealFirstPaymentDate", trspayplanvo);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.path.dao.common.iis.islamiccalculator.IISIslamicCalculatorDAO#
     * returnTRSPAYPLAN_BREAKUP_PROFITList(com.path.dbmaps.vo.TRSPAYPLANVO)
     */
    @Override
    public List<TRSPAYPLAN_BREAKUP_PROFITVO> returnTRSPAYPLAN_BREAKUP_PROFITList(TRSPAYPLANVO trspayplanvo)
	    throws DAOException
    {
	return (List<TRSPAYPLAN_BREAKUP_PROFITVO>) getSqlMap()
		.queryForList("iisIslamicCalculator.returnTRSPAYPLAN_BREAKUP_PROFITList", trspayplanvo);
    }


    // #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015 [Start]
    //@Override
    //public BigDecimal returnAgencyFeePcnt(TRSDEAL2VOKey trsdeal2voKey) throws DAOException
    //{
	//return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnAgencyFeePcnt", trsdeal2voKey);
    //}
    //// #TAR ICD140061 ; Arun.R.Variyath ; 15/10/2015 [End]


	@Override
	public BigDecimal returnTotalDsibursedAfterVDate(TRSPAYPLANVO trspayplanvo) throws DAOException {
		return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnTotalDsibursedAfterVDate",
				trspayplanvo);
	}

	@Override
	public BigDecimal returnCurrentDsiburseAmount(TRSDEALVO trsdealvo) throws DAOException {
		return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnCurrentDsiburseAmount",
				trsdealvo);
	}

	@Override
	public BigDecimal returnCurrentMultipleYield(TRSDEALVO trsdealvo) throws DAOException {
		return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnCurrentMultipleYield",
				trsdealvo);
		
	}

	@Override
	public int returnMultipleYieldCount(TRSDEALVO trsdealvo1) throws DAOException {
		return (Integer) getSqlMap().queryForObject("iisIslamicCalculator.returnMultipleYieldCount", trsdealvo1);
	}
	
	// DN# EWBI160013; deepu.mohandas 25/04/2016
    @Override
    public BigDecimal returnExcessiveProfitRate(IslamicCalculatorCO calculatorCO) throws DAOException
    {

	return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnExcessiveProfitRate", calculatorCO);

    }

    // DN# EWBI160013; deepu.mohandas 25/04/2016
    @Override
    public BigDecimal returnMinYield(IslamicCalculatorCO calculatorCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnMinYield", calculatorCO);
    }

    // DN# EWBI160013; deepu.mohandas 25/04/2016
    @Override
    public List<TRSCHARGESVO> returnTtrschargesVOList(IslamicCalculatorCO islamicCalculatorCO) throws DAOException
    {
	return (List<TRSCHARGESVO>) getSqlMap().queryForList("iisIslamicCalculator.returnTtrschargesVOList",
		islamicCalculatorCO);
    }
	
	// DN# EWBI160013; deepu.mohandas 25/04/2016
    @Override
    public TRSCHARGESVO getChargesDetails(TRSCHARGESVOKey trschargesVoKey) throws DAOException
    {
	return (TRSCHARGESVO) getSqlMap().queryForObject("iisIslamicCalculator.getChargesDetails", trschargesVoKey);
    }

    @Override
    public BigDecimal returnMarginRate(IslamicCalculatorCO calculatorCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("iisIslamicCalculator.returnMarginRate", calculatorCO);
    }
}
