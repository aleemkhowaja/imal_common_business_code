package com.path.bo.common.global360view.financingDeals.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.financingDeals.FinancingDealsBO;
import com.path.bo.common.iis.IISCommonConstants;
import com.path.dao.common.global360view.financingDeals.FinancingDealsDAO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.TRSDEALVO;
import com.path.dbmaps.vo.TRSDEALVOKey;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.global360view.FinancingDealDetailsCO;
import com.path.vo.common.global360view.FinancingDealRepaymentPlanCO;
import com.path.vo.common.global360view.FinancingDealStatusCriteriaCO;
import com.path.vo.common.global360view.FinancingDealsCollateralCO;
import com.path.vo.common.global360view.FinancingDealsGuarantorCO;
import com.path.vo.common.global360view.FinancingDealsLimitUtilizationCO;
import com.path.vo.common.global360view.FinancingDealsSC;
import com.path.vo.common.global360view.ProductClassCO;
import com.path.vo.common.reportresponse.ReportResponseCO;

public class FinancingDealsBOImpl extends BaseBO implements FinancingDealsBO
{
    private FinancingDealsDAO financingDealsDAO;

    public void setFinancingDealsDAO(FinancingDealsDAO financingDealsDAO)
    {
	this.financingDealsDAO = financingDealsDAO;
    }

    // private FinancingDealsCO
    // getConsolidatedFinancingDealsCO(List<FinancingDealsCO>
    // financingDealsCOList)throws BaseException{
    // FinancingDealsCO consolidateFinancingDealsCO = new FinancingDealsCO();
    // for (FinancingDealsCO financingDealsCO : financingDealsCOList) {
    // consolidateFinancingDealsCO.setTotalAmt(consolidateFinancingDealsCO.getTotalAmt().add(NumberUtil.nullToZero(CommonMethods.multiplyDivideAmount(financingDealsCO.getMultiDivInd(),
    // financingDealsCO.getTotalAmt(), financingDealsCO.getDealRate(),
    // financingDealsCO.getUnit(), financingDealsCO.getDecimalPoints()))));
    // consolidateFinancingDealsCO.setSettledAmt(consolidateFinancingDealsCO.getSettledAmt().add(NumberUtil.nullToZero(CommonMethods.multiplyDivideAmount(financingDealsCO.getMultiDivInd(),
    // financingDealsCO.getSettledAmt(), financingDealsCO.getDealRate(),
    // financingDealsCO.getUnit(), financingDealsCO.getDecimalPoints()))));
    // consolidateFinancingDealsCO.setOutstandingAmt(consolidateFinancingDealsCO.getOutstandingAmt().add(NumberUtil.nullToZero(CommonMethods.multiplyDivideAmount(financingDealsCO.getMultiDivInd(),
    // financingDealsCO.getOutstandingAmt(), financingDealsCO.getDealRate(),
    // financingDealsCO.getUnit(), financingDealsCO.getDecimalPoints()))));
    // consolidateFinancingDealsCO.setEarnedProfit(consolidateFinancingDealsCO.getEarnedProfit().add(NumberUtil.nullToZero(CommonMethods.multiplyDivideAmount(financingDealsCO.getMultiDivInd(),
    // financingDealsCO.getEarnedProfit(), financingDealsCO.getDealRate(),
    // financingDealsCO.getUnit(), financingDealsCO.getDecimalPoints()))));
    // consolidateFinancingDealsCO.setOverdueAmt(consolidateFinancingDealsCO.getOverdueAmt().add(NumberUtil.nullToZero(CommonMethods.multiplyDivideAmount(financingDealsCO.getMultiDivInd(),
    // financingDealsCO.getOverdueAmt(), financingDealsCO.getDealRate(),
    // financingDealsCO.getUnit(), financingDealsCO.getDecimalPoints()))));
    // consolidateFinancingDealsCO.setGuarantees(consolidateFinancingDealsCO.getGuarantees().add(NumberUtil.nullToZero(CommonMethods.multiplyDivideAmount(financingDealsCO.getMultiDivInd(),
    // financingDealsCO.getGuarantees(), financingDealsCO.getDealRate(),
    // financingDealsCO.getUnit(), financingDealsCO.getDecimalPoints()))));
    // consolidateFinancingDealsCO.setCollaterals(consolidateFinancingDealsCO.getCollaterals().add(NumberUtil.nullToZero(CommonMethods.multiplyDivideAmount(financingDealsCO.getMultiDivInd(),
    // financingDealsCO.getCollaterals(), financingDealsCO.getDealRate(),
    // financingDealsCO.getUnit(), financingDealsCO.getDecimalPoints()))));
    // consolidateFinancingDealsCO.setPromissoryNotes(consolidateFinancingDealsCO.getPromissoryNotes().add(NumberUtil.nullToZero(CommonMethods.multiplyDivideAmount(financingDealsCO.getMultiDivInd(),
    // financingDealsCO.getPromissoryNotes(), financingDealsCO.getDealRate(),
    // financingDealsCO.getUnit(), financingDealsCO.getDecimalPoints()))));
    // }
    // return consolidateFinancingDealsCO;
    // }

    @Override
    public List<FinancingDealDetailsCO> getFinancingDealsByProduct(FinancingDealsSC financingDealsSC)
	    throws BaseException
    {
	List<FinancingDealDetailsCO> financingDealsDtlsList = financingDealsDAO
		.getFinancingDealsByProduct(financingDealsSC);
	for(FinancingDealDetailsCO financingDealDetailsCO : financingDealsDtlsList)
	{
	    financingDealDetailsCO.setCvAmt(NumberUtil.nullToZero(CommonMethods.multiplyDivideAmount(
		    financingDealDetailsCO.getTrsDealVO().getDEAL_MULTDIV(), financingDealDetailsCO.getDealAmt(),
		    financingDealDetailsCO.getTrsDealVO().getDEAL_RATE(),
		    financingDealDetailsCO.getTrsDealVO().getDEAL_UNIT(), financingDealsSC.getBaseCurrDecPoints())));
	}

	return financingDealsDtlsList;
    }

    @Override
    public List<ProductClassCO> getProductClasses(FinancingDealsSC financingDealsSC) throws BaseException
    {
	return financingDealsDAO.getProductClasses(financingDealsSC);
    }

    @Override
    public int getFinancingDealsByProductCount(FinancingDealsSC financingDealsSC) throws BaseException
    {
	return financingDealsDAO.getFinancingDealsByProductCount(financingDealsSC);
    }

    @Override
    public FinancingDealRepaymentPlanCO getRepaymentPlanHeaderDtls(FinancingDealsSC financingDealsSC)
	    throws BaseException
    {
	BigDecimal outstandingAmount;
	BigDecimal remainingCurrProfit;
	BigDecimal oustndingPrinciplePlusCurProfit;
	int day;
	int month;
	int year;

	FinancingDealRepaymentPlanCO financingDealRepaymentPlanCO;
	TRSDEALVO trsdealvo;

	financingDealRepaymentPlanCO = financingDealsDAO.getRepaymentPlanHeaderDtls(financingDealsSC);
	financingDealsSC.setPlanNbr(financingDealRepaymentPlanCO.getTrsPayPlanVO().getPLAN_NBR());
	financingDealsSC.setPlanSeq(financingDealRepaymentPlanCO.getTrsPayPlanVO().getPLAN_SEQ());
	financingDealsSC.setDealNo(financingDealRepaymentPlanCO.getTrsPayPlanVO().getTRX_NBR().intValue());
	trsdealvo = financingDealsDAO.getTrsDealValues(financingDealsSC);
	financingDealsSC.setProdClassCode(trsdealvo.getCLASS().intValue());
	String profitUpfront = financingDealsDAO.getUpFrontValue(financingDealsSC);
	financingDealRepaymentPlanCO.setUpfrontDeal(profitUpfront);
	financingDealRepaymentPlanCO.setDealType(trsdealvo.getDEAL_TYPE());

	Calendar cal = Calendar.getInstance();
	trsdealvo.setRATE_REV_DATE(DateUtil.nullToInitDate(trsdealvo.getRATE_REV_DATE()));

	cal.setTime(trsdealvo.getRATE_REV_DATE());
	day = cal.get(Calendar.DAY_OF_MONTH);
	month = cal.get(Calendar.MONTH);
	cal.setTime(financingDealsSC.getRunningDate());
	year = cal.get(Calendar.YEAR);
	Date dt = DateUtil.createDate(year, month, day);
	trsdealvo.setRATE_REV_DATE(dt);
	if(trsdealvo.getRATE_PERIODICITY_TYPE().equals(IISCommonConstants.DAY))
	{

	    trsdealvo.setRATE_REV_DATE(
		    DateUtil.dateAdd("dd", trsdealvo.getRATE_PERIODICITY().longValue(), trsdealvo.getRATE_REV_DATE()));
	}
	else if(trsdealvo.getRATE_PERIODICITY_TYPE().equals(IISCommonConstants.WEEK))
	{
	    trsdealvo.setRATE_REV_DATE(DateUtil.dateAdd("ww", trsdealvo.getRATE_PERIODICITY().longValue() * 7,
		    trsdealvo.getRATE_REV_DATE()));
	}
	else if(trsdealvo.getRATE_PERIODICITY_TYPE().equals(IISCommonConstants.MONTH))
	{
	    trsdealvo.setRATE_REV_DATE(
		    DateUtil.dateAdd("mm", trsdealvo.getRATE_PERIODICITY().longValue(), trsdealvo.getRATE_REV_DATE()));
	}
	else if(trsdealvo.getRATE_PERIODICITY_TYPE().equals(IISCommonConstants.YEAR))
	{

	    trsdealvo.setRATE_REV_DATE(DateUtil.dateAdd("yy", trsdealvo.getRATE_PERIODICITY().longValue() * 365,
		    trsdealvo.getRATE_REV_DATE()));
	}
	financingDealsSC.setRateRevDate(trsdealvo.getRATE_REV_DATE());
	outstandingAmount = NumberUtil
		.nullToZero(financingDealsDAO.getRepaymentPlanHeaderOutstandingAmt(financingDealsSC));
	remainingCurrProfit = NumberUtil
		.nullToZero(financingDealsDAO.getRepaymentPlanHeaderRemainingProfit(financingDealsSC));
	financingDealRepaymentPlanCO.setActNoOfpayments(
		NumberUtil.nullToZero(financingDealsDAO.getRepaymentPlanHeaderNoOfInstalmment(financingDealsSC)));
	oustndingPrinciplePlusCurProfit = outstandingAmount.subtract(remainingCurrProfit);
	if(oustndingPrinciplePlusCurProfit.compareTo(BigDecimal.ZERO) == -1)
	{
	    oustndingPrinciplePlusCurProfit = BigDecimal.ZERO;

	}

	financingDealRepaymentPlanCO.setCurPeriodUnsettledAmt(oustndingPrinciplePlusCurProfit);
	return financingDealRepaymentPlanCO;
    }

    @Override
    public int getFinancingDealsRepaymentPlanCount(FinancingDealsSC financingDealsSC) throws BaseException
    {
	return financingDealsDAO.getFinancingDealsRepaymentPlanCount(financingDealsSC);
    }

    @Override
    public List<FinancingDealRepaymentPlanCO> getFinancingDealsRepaymentPlanData(FinancingDealsSC financingDealsSC)
	    throws BaseException
    {
	return financingDealsDAO.getFinancingDealsRepaymentPlanData(financingDealsSC);
    }

    @Override
    public List<FinancingDealsGuarantorCO> getFinancingDealsGuarantor(FinancingDealsSC financingDealsSC)
	    throws BaseException
    {
	return financingDealsDAO.getFinancingDealsGuarantor(financingDealsSC);
    }

    @Override
    public List<FinancingDealsCollateralCO> getFinancingDealsCollateral(FinancingDealsSC financingDealsSC)
	    throws BaseException
    {
	return financingDealsDAO.getFinancingDealsCollateral(financingDealsSC);
    }

    @Override
    public List<FinancingDealsLimitUtilizationCO> getFinancingDealsLimitUtilizationDtls(
	    FinancingDealsSC financingDealsSC) throws BaseException
    {
	return financingDealsDAO.getFinancingDealsLimitUtilizationDtls(financingDealsSC);
    }

    @Override
    public FinancingDealStatusCriteriaCO getDealColorStatusCriteria(FinancingDealsSC financingDealsSC)
	    throws BaseException
    {
	return financingDealsDAO.getDealColorStatusCriteria(financingDealsSC);
    }

    @Override
    public List<FinancingDealDetailsCO> getFinancingDealsPromissoryNotes(FinancingDealsSC financingDealsSC)
	    throws BaseException
    {
	return financingDealsDAO.getFinancingDealsPromissoryNotes(financingDealsSC);
    }

    @Override
    // #408812-Fawas.Kuruvakkottil 10/06/2016
    public FinancingDealsSC printScheduleReport(FinancingDealsSC financingDealsSC) throws BaseException
    {
	ReportResponseCO reportResponseCO = new ReportResponseCO();

	List<ReportResponseCO> reportResponseCOList = new ArrayList<ReportResponseCO>();
	reportResponseCO.setReportRef("R04QR");
	reportResponseCO.setAutoPrint(true);

	String runningDate = DateUtil.format(financingDealsSC.getRunningDate(), "dd/MM/yyyy");
	TRSDEALVO trsdealvo = financingDealsDAO.getTrsDealValues(financingDealsSC);
	BigDecimal prodClassCode = trsdealvo.getCLASS();

	String reportParams = StringUtil.nullEmptyToValue(financingDealsSC.getCompCode(), "")
		.concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR)
		.concat(StringUtil.nullEmptyToValue(financingDealsSC.getBranchCode(), ""))
		.concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR)
		.concat(StringUtil.nullEmptyToValue(financingDealsSC.getCifNo(), ""))
		.concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR)
		.concat(StringUtil.nullEmptyToValue(prodClassCode, ""))
		.concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR)
		.concat(StringUtil.nullEmptyToValue(financingDealsSC.getDealNo(), ""))
		.concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR)
		.concat(StringUtil.nullEmptyToValue(financingDealsSC.getPlanNbr(), ""))
		.concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR)
		.concat(StringUtil.nullEmptyToValue(financingDealsSC.getPlanSeq(), ""))
		.concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR).concat(StringUtil.nullEmptyToValue(runningDate, ""))
		.concat(ConstantsCommon.REPORT_ARGUMENT_SEPARATOR).concat(StringUtil.nullEmptyToValue("A", ""));

	reportResponseCO.setReportParams(reportParams);

	reportResponseCOList.add(reportResponseCO);

	// FinancingDealRepaymentPlanCO financingDealRepaymentPlanCO = new
	// FinancingDealRepaymentPlanCO();
	financingDealsSC.setReportResponseCOList(reportResponseCOList);
	return financingDealsSC;
    }

    @Override
    public List<FinancingDealRepaymentPlanCO> loadUnmaturedInstallmentSummary(FinancingDealsSC financingDealsSC)
	    throws BaseException
    {
	List<FinancingDealRepaymentPlanCO> unmaturedInstallmentSummary = new ArrayList<FinancingDealRepaymentPlanCO>();
	FinancingDealRepaymentPlanCO financingDealRepaymentPlanCO = financingDealsDAO
		.loadUnmaturedInstallmentSummary(financingDealsSC);
	BigDecimal dealNo = BigDecimal.valueOf(financingDealsSC.getDealNo());
	if(financingDealRepaymentPlanCO != null)
	{
	    if(NumberUtil.isEmptyDecimal(dealNo))
	    {
		financingDealRepaymentPlanCO.setCurrDecimalPoints(BigDecimal.valueOf(3));
	    }
	    else
	    {
		TRSDEALVOKey trsdealvoKey = new TRSDEALVOKey();
		trsdealvoKey.setCOMP_CODE(financingDealsSC.getCompCode());
		trsdealvoKey.setBRANCH_CODE(financingDealsSC.getBranchCode());
		trsdealvoKey.setSERIAL_NO(dealNo);
		TRSDEALVO trsdealvo = (TRSDEALVO) genericDAO.selectByPK(trsdealvoKey);
		if(trsdealvo != null)
		{
		    CURRENCIESVOKey currenciesvoKey = new CURRENCIESVOKey();
		    currenciesvoKey.setCOMP_CODE(financingDealsSC.getCompCode());
		    currenciesvoKey.setCURRENCY_CODE(trsdealvo.getDEAL_CY());
		    CURRENCIESVO currenciesvo = (CURRENCIESVO) genericDAO.selectByPK(currenciesvoKey);
		    if(currenciesvo != null)
		    {
			financingDealRepaymentPlanCO.setCurrDecimalPoints(currenciesvo.getDECIMAL_POINTS());
		    }
		}
	    }
	    financingDealRepaymentPlanCO.setSettlementAmount(NumberUtil
		    .nullToZero(financingDealRepaymentPlanCO.getTrsPayPlanDetVO().getCAPITAL_AMT())
		    .add(NumberUtil.nullToZero(financingDealRepaymentPlanCO.getTrsPayPlanDetVO().getCHARGE_AMOUNT()))
		    .add(NumberUtil
			    .nullToZero(financingDealRepaymentPlanCO.getTrsPayPlanDetVO().getINSURANCE_AMOUNT())));
	    unmaturedInstallmentSummary.add(financingDealRepaymentPlanCO);
	}

	return unmaturedInstallmentSummary;
    }

    // DBU191081 Muhammed Anas Start
    @Override
    public Integer getTreasuryForexDealsCount(FinancingDealsSC financingDealsSC) throws BaseException
    {
	return financingDealsDAO.getTreasuryForexDealsCount(financingDealsSC);
    }

    @Override
    public List<FinancingDealDetailsCO> getTreasuryForexDeals(FinancingDealsSC financingDealsSC) throws BaseException
    {
	List<FinancingDealDetailsCO> financingDealsDtlsList = financingDealsDAO.getTreasuryForexDeals(financingDealsSC);
	return financingDealsDtlsList;
    }
    // DBU191081 Muhammed Anas End
}