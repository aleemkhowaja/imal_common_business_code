package com.path.dao.common.iis.islamiccalculator.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.dao.common.iis.islamiccalculator.IslamicCalculatorEventMgmtDAO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.IBOR_HDRVO;
import com.path.dbmaps.vo.TRSCIFLIMITDETVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSCLASSVOKey;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVO;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVOKey;
import com.path.dbmaps.vo.TRSPAYPLANVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.common.iis.islamiccalculator.TrsDealSettlementChargesCO;

/**
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code<br>
 * <br>
 * 
 * DAO Class for Islamic Calculator Event Management Functions.
 * 
 * @see com.path.dao.common.iis.islamiccalculator.impl.IslamicCalculatorEventMgmtDAOImpl
 * @author Bejoy, Linchu
 * 
 */
public class IslamicCalculatorEventMgmtDAOImpl extends BaseDAO implements IslamicCalculatorEventMgmtDAO
{
    /**
     * Method for fetching the description from the DB
     */
    @Override
    public String getLongOrShortDescription(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.selectLongOrShortDescription",
		islamicCalculatorEventMgmtCO).toString();
    }

    /**
     * Method for fetching calculator language from DB
     */
    @Override
    public String getCalculatorLanguage(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.selectCalculatorLanguage",
		islamicCalculatorEventMgmtCO).toString();
    }

    /**
     * Method for fetching CIF details from DB
     */
    @Override
    public IslamicCalculatorEventMgmtCO populateOnChangeCifCivilId(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (IslamicCalculatorEventMgmtCO) getSqlMap().queryForObject(
		"islamicCalculatorEventMgmtMapper.selectOnChangeCifNumber", islamicCalculatorEventMgmtCO);
    }

    /**
     * Method for fetching basic monthly salary details for a CIF
     */
    public Double getMonthlyBasicSalary(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (Double) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.selectMonthlyBasicSalary",
		islamicCalculatorEventMgmtCO);
    }

    /**
     * Method for fetching basic monthly salary details for a CIF
     */
    public Double getMaximumFinanceAmount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (Double) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.selectMaxFinanceAmount",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public IslamicCalculatorEventMgmtCO populateonChangeNoOfPayments(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (IslamicCalculatorEventMgmtCO) getSqlMap().queryForObject(
		"islamicCalculatorEventMgmtMapper.selectonChangeNoOfPayments", islamicCalculatorEventMgmtCO);
    }

    public IslamicCalculatorEventMgmtCO getPaymentDetails(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (IslamicCalculatorEventMgmtCO) getSqlMap()
		.queryForObject("islamicCalculatorEventMgmtMapper.selectPaymentDetails", islamicCalculatorEventMgmtCO);
    }

    @Override
    public IslamicCalculatorEventMgmtCO getVatPercentageByPeriod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (IslamicCalculatorEventMgmtCO) getSqlMap().queryForObject(
		"islamicCalculatorEventMgmtMapper.selectVatPercentageByPeriod", islamicCalculatorEventMgmtCO);
    }

    public IslamicCalculatorEventMgmtCO getCurrencyUnitDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (IslamicCalculatorEventMgmtCO) getSqlMap().queryForObject(
		"islamicCalculatorEventMgmtMapper.getCurrencyUnitDetails", islamicCalculatorEventMgmtCO);
    }

    public Double getOutstandingAmountOfExistingDeals(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (Double) getSqlMap().queryForObject(
		"islamicCalculatorEventMgmtMapper.selectOutstandingAmountOfExistingDeals",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public Long isProductClassExist(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (Long) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.isProductClassExist",
		islamicCalculatorEventMgmtCO);

    }

    public Long ifCifExist(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (Long) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.ifCifExist",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal isCurrencyExist(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.isCurrencyExist",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public String getCurrencyDesc(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.getCurrencyDesc",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public IslamicCalculatorEventMgmtCO selectCurrencyUnitDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (IslamicCalculatorEventMgmtCO) getSqlMap().queryForObject(
		"islamicCalculatorEventMgmtMapper.selectCurrencyUnitDetails", islamicCalculatorEventMgmtCO);
    }

    @Override
    public String getVatIndicator(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.getVatIndicator",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal isVatExist(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.isVatExist",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public String getVatDesc(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.getVatDesc",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal getVatPercentagePeriod(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.getVatPercentagePeriod",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal getVatPercentageLatest(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.getVatPercentageLatest",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public String getTemplateDesc(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.getTemplateDesc",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public TRSPAYPLANTMPLTVO getTemplateDetails(TRSPAYPLANTMPLTVOKey trsPayplanTmpltVOKey) throws DAOException
    {
	return (TRSPAYPLANTMPLTVO) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.getTemplateDetails",
		trsPayplanTmpltVOKey);
    }

    public CURRENCIESVO getCurrencyDetails(CURRENCIESVOKey currenciesVOKey) throws DAOException
    {
	return (CURRENCIESVO) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.getCurrencyDetails",
		currenciesVOKey);
    }

    public TRSCLASSVO getTRSClassParams(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (TRSCLASSVO) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.selectTRSClassParams",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public TRSCLASSVO getDownPaymentDetails(TRSCLASSVOKey trsClassVOKey) throws DAOException
    {
	return (TRSCLASSVO) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.getDownPaymentDetails",
		trsClassVOKey);
    }

    public String getFlagValueForBallonAmt() throws DAOException
    {
	return (String) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.getFlagDetails", null);
    }

    /**
     * Method to return the Deal Count for CIF
     * 
     * @param IISCTRLVO,IISCommonParamCO
     * @return IISCommonParamCO
     * @throws BaseException
     */
    @Override
    public IslamicCalculatorEventMgmtCO getCifExistingDealCount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (IslamicCalculatorEventMgmtCO) getSqlMap()
		.queryForObject("islamicCalculatorEventMgmtMapper.CifExistingDealCount", islamicCalculatorEventMgmtCO);
    }

    @Override
    public TRSCIFLIMITDETVO returnTRSCIFLIMITDETDetails(TRSCIFLIMITDETVO trsciflimitdetvo) throws DAOException
    {
	return (TRSCIFLIMITDETVO) getSqlMap()
		.queryForObject("islamicCalculatorEventMgmtMapper.returnTRSCIFLIMITDETDetails", trsciflimitdetvo);
    }

    @Override
    public TRSCIFLIMITDETVO returnTRSCIFLIMITDETDetails1(TRSCIFLIMITDETVO trsciflimitdetvo) throws DAOException
    {
	return (TRSCIFLIMITDETVO) getSqlMap()
		.queryForObject("islamicCalculatorEventMgmtMapper.returnTRSCIFLIMITDETDetails1", trsciflimitdetvo);
    }

    // TP#225275;Arun.R.Variyath;27/09/2014 [Start]
    @Override
    public BigDecimal returnMaxInstPercSalary(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.selectMaxInstPercSalary",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal returnSumOfInstallmentAmount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.selectSumOfInstallmentAmount",
		islamicCalculatorEventMgmtCO);
    }
    // TP#225275;Arun.R.Variyath;27/09/2014 [End]

    @Override
    public IBOR_HDRVO returnFloatingRateCodeById(IBOR_HDRVO iborHDRVO) throws DAOException
    {
	return (IBOR_HDRVO) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.returnFloatingRateCodeById",
		iborHDRVO);
    }

    @Override
    public Boolean ib_linkedtorips(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	BigDecimal count = (BigDecimal) getSqlMap()
		.queryForObject("islamicCalculatorEventMgmtMapper.selectIblinkedtorips", islamicCalculatorEventMgmtCO);
	if(NumberUtil.isEmptyDecimal(count))
	{
	    return false;
	}
	else if(count.compareTo(BigDecimal.ZERO) > 0)
	{
	    return true;
	}
	return false;
    }

    // TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement and reschedule
    // charges
    @Override
    public List<TrsDealSettlementChargesCO> returnClassSettlementCharges(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return getSqlMap().queryForList("islamicCalculatorEventMgmtMapper.returnClassSettlementCharges",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal returnPIRecCount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.returnPIRecCount",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public String returnActiveSettlement(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (String) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.returnActiveSettlement",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal returnTrsSetlmntBlockingRecCount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject(
		"islamicCalculatorEventMgmtMapper.returnTrsSetlmntBlockingRecCount", islamicCalculatorEventMgmtCO);
    }

    @Override
    public Date returnLastSetlmntDate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException
    {
	return (Date) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.returnLastSetlmntDate",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal returnReimburseProfit(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.returnReimburseProfit",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public BigDecimal returnBuyOutBankCifNo(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.returnBuyOutBankCifNo",
		islamicCalculatorEventMgmtCO);
    }

    @Override
    public TRSPAYPLANVO returnPlanByDeal(IISCommonCO iisCommonCO) throws DAOException
    {
	return (TRSPAYPLANVO) getSqlMap().queryForObject("islamicCalculatorEventMgmtMapper.returnPlanByDeal",
		iisCommonCO);
    }

}
