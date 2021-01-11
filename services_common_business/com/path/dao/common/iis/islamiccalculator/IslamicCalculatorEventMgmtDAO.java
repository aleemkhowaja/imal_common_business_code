package com.path.dao.common.iis.islamiccalculator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.IBOR_HDRVO;
import com.path.dbmaps.vo.TRSCIFLIMITDETVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSCLASSVOKey;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVO;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVOKey;
import com.path.dbmaps.vo.TRSPAYPLANVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.common.iis.islamiccalculator.TrsDealSettlementChargesCO;

public interface IslamicCalculatorEventMgmtDAO
{
    public String getLongOrShortDescription(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public String getCalculatorLanguage(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public IslamicCalculatorEventMgmtCO populateOnChangeCifCivilId(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public IslamicCalculatorEventMgmtCO populateonChangeNoOfPayments(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public IslamicCalculatorEventMgmtCO getPaymentDetails(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public IslamicCalculatorEventMgmtCO getVatPercentageByPeriod(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public Double getMonthlyBasicSalary(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public Double getMaximumFinanceAmount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public IslamicCalculatorEventMgmtCO getCurrencyUnitDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public Double getOutstandingAmountOfExistingDeals(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public Long isProductClassExist(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public Long ifCifExist(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public BigDecimal isCurrencyExist(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public String getCurrencyDesc(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public IslamicCalculatorEventMgmtCO selectCurrencyUnitDetails(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public String getVatIndicator(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public BigDecimal isVatExist(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public String getVatDesc(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public BigDecimal getVatPercentagePeriod(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public BigDecimal getVatPercentageLatest(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public String getTemplateDesc(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public TRSPAYPLANTMPLTVO getTemplateDetails(TRSPAYPLANTMPLTVOKey trsPayplanTmpltVOKey) throws DAOException;

    public TRSCLASSVO getTRSClassParams(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public CURRENCIESVO getCurrencyDetails(CURRENCIESVOKey currenciesVOKey) throws DAOException;

    public TRSCLASSVO getDownPaymentDetails(TRSCLASSVOKey trsClassVOKey) throws DAOException;

    public String getFlagValueForBallonAmt() throws DAOException;

    public IslamicCalculatorEventMgmtCO getCifExistingDealCount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public TRSCIFLIMITDETVO returnTRSCIFLIMITDETDetails(TRSCIFLIMITDETVO trsciflimitdetvo) throws DAOException;

    public TRSCIFLIMITDETVO returnTRSCIFLIMITDETDetails1(TRSCIFLIMITDETVO trsciflimitdetvo) throws DAOException;

    // TP#225275;Arun.R.Variyath;27/09/2014 [Start]
    public BigDecimal returnMaxInstPercSalary(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public BigDecimal returnSumOfInstallmentAmount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;
    // TP#225275;Arun.R.Variyath;27/09/2014 [End]

    public IBOR_HDRVO returnFloatingRateCodeById(IBOR_HDRVO iborHDRVO) throws DAOException;

    public Boolean ib_linkedtorips(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    // TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement and reschedule
    // charges
    public List<TrsDealSettlementChargesCO> returnClassSettlementCharges(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 start **/
    public BigDecimal returnPIRecCount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public String returnActiveSettlement(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public BigDecimal returnTrsSetlmntBlockingRecCount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public Date returnLastSetlmntDate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws DAOException;

    public BigDecimal returnReimburseProfit(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    public BigDecimal returnBuyOutBankCifNo(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws DAOException;

    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 end **/

    TRSPAYPLANVO returnPlanByDeal(IISCommonCO iisCommonCO) throws DAOException;
}
