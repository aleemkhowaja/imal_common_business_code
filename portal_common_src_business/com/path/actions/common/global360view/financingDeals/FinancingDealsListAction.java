package com.path.actions.common.global360view.financingDeals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.financingDeals.FinancingDealsBO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.FinancingDealDetailsCO;
import com.path.vo.common.global360view.FinancingDealRepaymentPlanCO;
import com.path.vo.common.global360view.FinancingDealStatusCriteriaCO;
import com.path.vo.common.global360view.FinancingDealsCO;
import com.path.vo.common.global360view.FinancingDealsSC;

@SuppressWarnings("serial")
public class FinancingDealsListAction extends GridBaseAction
{

    private List<FinancingDealsCO> financingDealsCOList;
    private FinancingDealRepaymentPlanCO financingDealRepaymentPlanCO;
    private FinancingDealsBO financingDealsBO;
    private FinancingDealsSC financingDealsSC = new FinancingDealsSC();

    public String loadFinancingDealsByProductGrid()
    {
	return "dealsByProduct";
    }
    
    // DBU191081 Muhammed Anas Start
    public String loadTreasuryForexDealsGrid()
    {
		return "treasuryForexDeals";
    }
    // DBU191081 Muhammed Anas End

    public String loadProductClassGrid()
    {
	return "productClass";
    }

    @Override
    public Object getModel()
    {
	return financingDealsSC;
    }

    public String loadFinancingDealsByProductData() throws JSONException
    {

	String[] searchCol = { "branchBriefDescEng", "trsDealVO.USER_ID", "trsDealVO.SERIAL_NO", "trsDealVO.DEAL_DATE",
		"cvAmt", "dealAmt", "YIELD", "trsDealVO.MGMT_PCNT", "trsDealVO.DEAL_RATE", "trsDealVO.VALUE_DATE",
		"trsDealVO.MATURITY_DATE", "trsDealVO.ECO_SECTOR", "trsDealVO.SUB_ECO_SECTOR" };
	try
	{
	    financingDealsSC.setSearchCols(searchCol);
	    setFinancingDealSCProperties();
	    setDealTypeSCProperty();
	    financingDealsSC.setBaseCurrDecPoints(returnSessionObject().getBaseCurrDecPoint());
	    copyproperties(financingDealsSC);
	    if(checkNbRec(financingDealsSC))
	    {
		setRecords(financingDealsBO.getFinancingDealsByProductCount(financingDealsSC));
	    }
	    List<FinancingDealDetailsCO> financingDealDtlsList = financingDealsBO
		    .getFinancingDealsByProduct(financingDealsSC);
	    // setting the status of the deal

	    for(FinancingDealDetailsCO financingDealDetailsCO : financingDealDtlsList)
	    {
		financingDealDetailsCO.setBaseCurrDecPoint(returnSessionObject().getBaseCurrDecPoint());
		if(financingDealsSC.getStatus().equals("P"))
		{
		    financingDealsSC.setDealNo(financingDealDetailsCO.getTrsDealVO().getSERIAL_NO().intValue());
		    financingDealsSC.setBranchCode(financingDealDetailsCO.getTrsDealVO().getBRANCH_CODE());
		    FinancingDealStatusCriteriaCO financingDealStatusCriteriaCO = financingDealsBO.getDealColorStatusCriteria(financingDealsSC);
		    String status = getFinancingDealStatus(financingDealStatusCriteriaCO);
		    financingDealDetailsCO.setStatus(status);
		    // DBU191081 Muhammed Anas Start
		    if(ConstantsCommon.YES.equals(financingDealsSC.getOutstandingDealsFlag()))
		    {
			    if(financingDealStatusCriteriaCO != null)
			    {
			    	BigDecimal totalAmt = NumberUtil.nullToZero(financingDealStatusCriteriaCO.getTotalAmt());
			    	BigDecimal totalAmtPaid = NumberUtil.nullToZero(financingDealStatusCriteriaCO.getTotalAmtPaid());
			    	BigDecimal remainingAmt = totalAmt.subtract(totalAmtPaid);
			    	financingDealDetailsCO.setRemainingAmt(remainingAmt);
			    }
			    else
			    {
			    	financingDealDetailsCO.setRemainingAmt(BigDecimal.ZERO);
			    }
		    }   
		    // DBU191081 Muhammed Anas End
		}
		else
		{
		    financingDealDetailsCO.setStatus(getText("Active_key"));
		}

	    }
	    
	    // DBU191081 Muhammed Anas Start
	    if(ConstantsCommon.YES.equals(financingDealsSC.getOutstandingDealsFlag()))
	    {
		    Iterator<FinancingDealDetailsCO> itr = financingDealDtlsList.iterator();
		    while (itr.hasNext()) 
		    {
		    	FinancingDealDetailsCO financingdealdetailsCO = itr.next();
		        if (financingdealdetailsCO.getStatus().equals("A")) 
		        {
		        	itr.remove();
		        }
		    }
		}
	    // DBU191081 Muhammed Anas End

	    setGridModel(financingDealDtlsList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    log.error(e, "Error in Financing grid by product");

	}
	return SUCCESS;

    }

    public String loadFinancingDealsPromissoryNotesGrid()
    {
	return "dealsPromissoryNotes";
    }

    public String loadFinancingDealsPromissoryNotesData() throws JSONException
    {

	String[] searchCol = { "fromFacility", "trsDealVO.SERIAL_NO", "trsDealVO.DEAL_CY", "valueDate", "amount",
		"cvAmt" };
	try
	{
	    financingDealsSC.setSearchCols(searchCol);
	    setFinancingDealSCProperties();
	    setDealTypeSCProperty();
	    copyproperties(financingDealsSC);
	    List<FinancingDealDetailsCO> financingDealDtlsList = financingDealsBO
		    .getFinancingDealsPromissoryNotes(financingDealsSC);
	    setGridModel(financingDealDtlsList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    log.error(e, "Error in Promissory grid");

	}
	return SUCCESS;

    }

    private String getFinancingDealStatus(FinancingDealStatusCriteriaCO financingDealStatusCriteriaCO)
    {
	if(financingDealStatusCriteriaCO != null)
	{
	    if(financingDealStatusCriteriaCO.getOverdueAmt() == null)
	    {
		financingDealStatusCriteriaCO.setOverdueAmt(BigDecimal.ZERO);
	    }
	    if(financingDealStatusCriteriaCO.getApprSettlmentAmt() == null)
	    {
		financingDealStatusCriteriaCO.setApprSettlmentAmt(BigDecimal.ZERO);
	    }
	    SessionCO sessionCO = returnSessionObject();
	    if(BigDecimal.ONE.equals(financingDealStatusCriteriaCO.getDealType())
		    || new BigDecimal(2).equals(financingDealStatusCriteriaCO.getDealType())
		    || new BigDecimal(15).equals(financingDealStatusCriteriaCO.getDealType()))
	    {
		if(sessionCO.getRunningDateRET().after(financingDealStatusCriteriaCO.getMaturityDate()))
		{
		    return "N";
		}
		else
		{
		    return "P";
		}
	    }
	    else if(new BigDecimal(13).equals(financingDealStatusCriteriaCO.getDealType()))
	    {
		if(sessionCO.getRunningDateRET().after(financingDealStatusCriteriaCO.getMaturityDate()))
		{
		    if((financingDealStatusCriteriaCO.getMatRecInsNbr() > 0)
			    && financingDealStatusCriteriaCO.getMatPaymentInsNbr() > 0)
		    {
			return "A";
		    }
		    else
		    {
			return "N";
		    }
		}
		else
		{
		    return "P";
		}
	    }

	    if("A".equals(financingDealStatusCriteriaCO.getStatus()))
	    {
		return "B";
	    }
	    else if(financingDealStatusCriteriaCO.getTotalAmt().compareTo(
		    financingDealStatusCriteriaCO.getTotalAmtPaid()) == 0
		    && financingDealStatusCriteriaCO.getActiveSettlementCount().compareTo(BigDecimal.ZERO) == 0
		    && financingDealStatusCriteriaCO.getTotalAmt().intValue() > 0)
	    {
		return "A";
	    }
	    else
	    {
		financingDealStatusCriteriaCO.setTotalAmtPaid(financingDealStatusCriteriaCO.getApprSettlmentAmt());
	    }

	    if(financingDealStatusCriteriaCO.getTotalAmt().compareTo(financingDealStatusCriteriaCO.getTotalAmtPaid()) == 0
		    && financingDealStatusCriteriaCO.getActiveSettlementCount().compareTo(BigDecimal.ZERO) == 0)
	    {
		return "A";
	    }
	    else if((financingDealStatusCriteriaCO.getTotalAmtPaid().compareTo(
		    financingDealStatusCriteriaCO.getTotalAmt()) == -1)
		    && financingDealStatusCriteriaCO.getOverdueAmt().subtract(
			    financingDealStatusCriteriaCO.getApprSettlmentAmt()).compareTo(BigDecimal.ZERO) > 0)
	    {
		return "N";
	    }
	    else if((financingDealStatusCriteriaCO.getTotalAmtPaid().compareTo(
		    financingDealStatusCriteriaCO.getTotalAmt()) == -1)
		    && financingDealStatusCriteriaCO.getTotalAmtPaid().compareTo(BigDecimal.ZERO) != 0
		    && (sessionCO.getRunningDateRET().before(financingDealStatusCriteriaCO.getMaturityDate()) || sessionCO
			    .getRunningDateRET().compareTo(financingDealStatusCriteriaCO.getMaturityDate()) == 0))
	    {
		return "D";
	    }
	    else if(financingDealStatusCriteriaCO.getTotalAmtPaid().compareTo(BigDecimal.ZERO) == 0)
	    {
		return "P";
	    }
	    else if("A".equals(financingDealStatusCriteriaCO.getStatus()))
	    {
		return "B";
	    }
	}

	return "";
    }

    public String loadProductClassData()
    {
	try
	{
	    setFinancingDealSCProperties();
	    // getFinancingDealsSC().setDealCurrency(24);
	    setGridModel(financingDealsBO.getProductClasses(financingDealsSC));

	}
	catch(BaseException e)
	{
	    // TODO Auto-generated catch block
	    handleException(e, null, null);
	}
	return SUCCESS;

    }

    public String loadFinancingDealsRepaymentPlanHeaderDtls()
    {
	try
	{
	    setFinancingDealSCProperties();
	    financingDealRepaymentPlanCO = financingDealsBO.getRepaymentPlanHeaderDtls(financingDealsSC);
	    if(financingDealRepaymentPlanCO != null)
	    {
		String decFormat = NumberUtil.currencyMask(financingDealRepaymentPlanCO.getCurrDecimalPoints());
		SYS_PARAM_SCREEN_DISPLAYVO sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
		sysParam.setDecFormat(decFormat);
		sysParam.setELEMENT_NAME("financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT");
		getAdditionalScreenParams().put("financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT", sysParam);

		sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
		sysParam.setDecFormat(decFormat);
		sysParam.setELEMENT_NAME("financingDealRepaymentPlanCO.activeSettlementAmt");
		getAdditionalScreenParams().put("financingDealRepaymentPlanCO.activeSettlementAmt", sysParam);

		sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
		sysParam.setDecFormat(decFormat);
		sysParam.setELEMENT_NAME("financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT_PAID");
		getAdditionalScreenParams().put("financingDealRepaymentPlanCO.trsPayPlanVO.TOTAL_AMT_PAID", sysParam);

		sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
		sysParam.setDecFormat(decFormat);
		sysParam.setELEMENT_NAME("financingDealRepaymentPlanCO.trsPayPlanVO.AMT_PER_PAYMENT");
		getAdditionalScreenParams().put("financingDealRepaymentPlanCO.trsPayPlanVO.AMT_PER_PAYMENT", sysParam);

		sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
		sysParam.setDecFormat(decFormat);
		sysParam.setELEMENT_NAME("financingDealRepaymentPlanCO.remainingAmt");
		getAdditionalScreenParams().put("financingDealRepaymentPlanCO.remainingAmt", sysParam);
		if(ConstantsCommon.YES.equals(financingDealRepaymentPlanCO.getUpfrontDeal())
			&& !NumberUtil.isEmptyDecimal(financingDealRepaymentPlanCO.getDealType())
			&& financingDealRepaymentPlanCO.getDealType().equals(BigDecimal.valueOf(11)))
		{
		    sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
		    sysParam.setDecFormat(decFormat);
		    sysParam.setELEMENT_NAME("financingDealRepaymentPlanCO.curPeriodUnsettledAmt");
		    getAdditionalScreenParams().put("financingDealRepaymentPlanCO.curPeriodUnsettledAmt", sysParam);
		    sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
		    sysParam.setDecFormat(decFormat);
		    sysParam.setELEMENT_NAME("financingDealRepaymentPlanCO.actNoOfpayments");
		    getAdditionalScreenParams().put("financingDealRepaymentPlanCO.actNoOfpayments", sysParam);
		}

	    }

	    set_recReadOnly("true");
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	    e.printStackTrace();

	}
	return "repaymentPlanDetails";
    }

    public String loadFinancingDealsRepaymentPlanGridDetails() throws JSONException
    {

	String[] searchCol = { "trsPayPlanDetVO.LINE_NBR", "trsPayPlanDetVO.VALUE_DATE", "paymentType", "amount",
		"trsPayPlanDetVO.CAPITAL_AMT_BEFORE_XIRR", "trsPayPlanDetVO.CAPITAL_AMT",
		"trsPayPlanDetVO.PROFIT_AMT_BEFORE_XIRR", "profitAmt", "trsPayPlanDetVO.BALLOON_PAYMENT",
		"dateSettled", "settlementAmount", "computedActiveSettlementAmt", "computedRemainingAmt",
		"trsPayPlanDetVO.REIMBURSED_PROFIT", "trsPayPlanDetVO.RESERVE_AMOUNT", "computedAmtReceived",
		"computedIncidentalCost", "computedAdvInsurance", "computedTotalInstallment" };
	try
	{

	    if(financingDealsSC.getPlanNbr() != null)
	    {
		financingDealsSC.setSearchCols(searchCol);
		financingDealsSC.setPreferredLanguage(returnSessionObject().getLanguage());
		setFinancingDealSCProperties();
		// setDealTypeSCProperty();
		copyproperties(financingDealsSC);
		/*
		 * if(checkNbRec(financingDealsSC))
		 * setRecords(financingDealsBO.getFinancingDealsRepaymentPlanCount
		 * (financingDealsSC));
		 */

		List<FinancingDealRepaymentPlanCO> repaymentDtlsList = financingDealsBO
			.getFinancingDealsRepaymentPlanData(financingDealsSC);
		FinancingDealRepaymentPlanCO currObj = null;
		FinancingDealRepaymentPlanCO prevObj = null;
		//758813
        Map<BigDecimal, FinancingDealRepaymentPlanCO> map = new TreeMap<BigDecimal, FinancingDealRepaymentPlanCO>();
		for(int i = 0; i < repaymentDtlsList.size(); i++)
		{
		    currObj = repaymentDtlsList.get(i);
		    currObj.setStatus(getRepaymentPlanDtlsStatus(currObj));
		    if(i == 0)
		    {
			currObj.setComputedIncidentalCost(currObj.getCfIncidentCost());
			currObj.setComputedAdvInsurance(currObj.getAdvInsuranceAmt());
		    }
		    else
		    {
			prevObj = repaymentDtlsList.get(i - 1);
			currObj.setComputedIncidentalCost(currObj.getCfIncidentCost().subtract(
				prevObj.getCfIncidentCost()));
			currObj.setComputedAdvInsurance(currObj.getAdvInsuranceAmt().subtract(
				prevObj.getAdvInsuranceAmt()));
		    }
			//758813
            map.put(currObj.getTrsPayPlanDetVO().getLINE_NBR(), currObj);
		}
		//758813
		repaymentDtlsList = new ArrayList<FinancingDealRepaymentPlanCO>(map.values());


		/*
		 * for (FinancingDealRepaymentPlanCO
		 * financingDealRepaymentPlanCO : repaymentDtlsList) {
		 * financingDealRepaymentPlanCO
		 * .setStatus(getRepaymentPlanDtlsStatus
		 * (financingDealRepaymentPlanCO)); }
		 */
		setGridModel(repaymentDtlsList);
	    }

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    log.error(e, "Error in Financing deal repayment plan grid");

	}
	return SUCCESS;

    }

    private String getRepaymentPlanDtlsStatus(FinancingDealRepaymentPlanCO financingDealRepaymentPlanCO)
    {

	BigDecimal cf_settled = financingDealRepaymentPlanCO.getApprovedSettlement() == null ? BigDecimal.ZERO
		: financingDealRepaymentPlanCO.getApprovedSettlement();
	BigDecimal amount = financingDealRepaymentPlanCO.getAmount();
	BigDecimal reimbursed_profit = financingDealRepaymentPlanCO.getTrsPayPlanDetVO().getREIMBURSED_PROFIT();
	Date date_settled = financingDealRepaymentPlanCO.getDateSettled();
	Date value_date = financingDealRepaymentPlanCO.getTrsPayPlanDetVO().getVALUE_DATE();
	String cf_deal_sts = financingDealRepaymentPlanCO.getStatus();
	Date sysDate = returnSessionObject().getRunningDateRET();
	
	BigDecimal settledVatAmt = NumberUtil.emptyDecimalToZero(financingDealRepaymentPlanCO.getTrsPayPlanDetVO().getSETTLED_VAT_AMT());
	cf_settled=cf_settled.add(settledVatAmt);
	

	if(financingDealRepaymentPlanCO.getDealStatus().equals("P")
		|| financingDealRepaymentPlanCO.getDealStatus().equals("W"))
	{
	    if(((cf_settled.compareTo(amount) == 0 || (cf_settled.add(reimbursed_profit)).compareTo(amount) == 0) && cf_settled
		    .compareTo(BigDecimal.ZERO) > 0)
		    && (date_settled != null && date_settled.before(value_date) && !cf_deal_sts.equals("W")))
	    {
		return "A"; // early paid - green
	    }
	    else if(((cf_settled.compareTo(amount) == 0 || (cf_settled.add(reimbursed_profit)).compareTo(amount) == 0) && cf_settled
		    .compareTo(BigDecimal.ZERO) > 0)
		    || (cf_settled.compareTo(BigDecimal.ZERO) == 0 && amount.compareTo(BigDecimal.ZERO) == 0))
	    {
		return "P"; // paid - blue
	    }
	    else if((cf_settled.compareTo(BigDecimal.ZERO) == 0 || cf_settled.compareTo(amount) < 0)
		    && value_date.before(sysDate))
	    {
		return "N";// over due - red
	    }
	    else if(cf_settled.compareTo(BigDecimal.ZERO) == 0)
	    {
		return "";
	    }
	    else
	    {
		return "D"; // partially paid -
	    }
	}
	else
	{
	    return "";
	}

    }

    public String loadFinancingDealsGuarantorGrid()
    {
	return "guarantorDetails";
    }

    public String loadFinancingDealsGuarantorData()
    {
	try
	{
	    String[] searchCol = { "trsDealGuarantorVO.GUARANTOR_CIF", "guarantorName",
		    "trsDealGuarantorVO.GUARANTOR_AMOUNT", "trsDealGuarantorVO.AMOUNT_WITH_COMPANY",
		    "trsDealGuarantorVO.AMOUNT_WITH_CLIENT", "trsDealGuarantorVO.ACC_BRANCH",
		    "trsDealGuarantorVO.ACC_CURRENCY", "trsDealGuarantorVO.ACC_GL_CODE",
		    "trsDealGuarantorVO.ACC_CIF_NO", "trsDealGuarantorVO.ACC_SL_NO", "accName" };
	    financingDealsSC.setSearchCols(searchCol);
	    setFinancingDealSCProperties();
	    copyproperties(financingDealsSC);
	    setGridModel(financingDealsBO.getFinancingDealsGuarantor(financingDealsSC));
	}
	catch(BaseException e)
	{
	    handleException(e, "", "");
	    e.printStackTrace();
	}
	return SUCCESS;
    }

    public String loadFinancingDealsCollateralGrid()
    {
	return "collateralDetails";
    }

    public String loadFinancingDealsCollateralData()
    {
	try
	{
	    String[] searchCol = { "trsCollateralDetVO.COLLATERAL_NO", "fmsCollateralVO.BRIEF_NAME_ENG",
		    "fmsCollateralVO.CURRENCY", "collateralType", "fmsCollateralVO.APPL_REF",
		    "fmsCollateralVO.FACILITY_COVERAGE", "fmsCollateralVO.LEVERAGE_RATIO",
		    "fmsCollateralVO.APPROVED_COVERAGE", "fmsCollateralVO.ACCEPT_VALUE",
		    "fmsCollateralVO.MARKET_VALUE", "fmsCollateralVO.ACTUAL_ALLOCATED",
		    "trsCollateralDetVO.DEAL_ALLOCATED" };
	    financingDealsSC.setSearchCols(searchCol);
	    setFinancingDealSCProperties();
	    copyproperties(financingDealsSC);
	    financingDealsSC.setPreferredLanguage(returnSessionObject().getLanguage());
	    setGridModel(financingDealsBO.getFinancingDealsCollateral(financingDealsSC));
	}
	catch(BaseException e)
	{
	    handleException(e, "", "");
	    e.printStackTrace();
	}
	return SUCCESS;
    }

    public String loadFinancingDealsLimitUtilizationGrid()
    {
	return "limitUtilizationDtls";
    }

    public String loadFinancingDealsLimitUtilizationData()
    {

	try
	{
	    setFinancingDealSCProperties();
	    setGridModel(financingDealsBO.getFinancingDealsLimitUtilizationDtls(financingDealsSC));
	}
	catch(BaseException e)
	{
	    handleException(e, "", "");
	    e.printStackTrace();
	}
	return SUCCESS;
    }

    private void setFinancingDealSCProperties()
    {
	SessionCO sessionCO = returnSessionObject();
	getFinancingDealsSC().setCompCode(sessionCO.getCompanyCode());
	if(getFinancingDealsSC().getBranchCode() == null)
	{
	    getFinancingDealsSC().setBranchCode(sessionCO.getBranchCode());
	}
	// getFinancingDealsSC().setBranchFilter("A");//replace it with orginal
	// value
	getFinancingDealsSC().setRunningDate(sessionCO.getRunningDateRET());

    }

    // category is Asset then dealtype B,category is liability/indirect
    // liability then dealtype L
     private void setDealTypeSCProperty()
    {
	financingDealsSC
		.setDealType(FinancingDealsConstants.ASSET_CATEGORY.equals(financingDealsSC.getCategory()) ? FinancingDealsConstants.ASSET_DEAL_TYPE
			: FinancingDealsConstants.LIABILITY_DEAL_TYPE);
    }

    public String loadUnmaturedInstallmentSummary()
    {
	try
	{
	    setFinancingDealSCProperties();
	    copyproperties(financingDealsSC);
	    List<FinancingDealRepaymentPlanCO> unmaturedInstallmentSummaryList = financingDealsBO
		    .loadUnmaturedInstallmentSummary(financingDealsSC);

	    setGridModel(unmaturedInstallmentSummaryList);
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
 // DBU191081 Muhammed Anas Start
    public String loadTreasuryForexDeals() throws JSONException
    {

	String[] searchCol = { "branchBriefDescEng", "trsDealVO.USER_ID", "trsDealVO.SERIAL_NO", "trsDealVO.DEAL_DATE",
		 				   "trsDealVO.VALUE_DATE", "trsDealVO.FOREX_TYPE", "boughtCurrency", "trsDealVO.OTHER_AMOUNT",
		 				   "trsDealVO.SALES_DATE", "trsDealVO.CROSS_EXCH_RATE", "soldCurrency", "trsDealVO.DEAL_AMOUNT",
		 				   "className"};
	try
	{
		if(StringUtil.isEmptyString(financingDealsSC.getAppName()))
        {
        	financingDealsSC.setAppName(null);
        }
	    financingDealsSC.setSearchCols(searchCol);
	    setFinancingDealSCProperties();
	    financingDealsSC.setBaseCurrDecPoints(returnSessionObject().getBaseCurrDecPoint());
	    copyproperties(financingDealsSC);
	    financingDealsSC.setLangCode(returnSessionObject().getLanguage());
	    financingDealsSC.setLovType(new BigDecimal(317));
	    if(checkNbRec(financingDealsSC))
	    {
		setRecords(financingDealsBO.getTreasuryForexDealsCount(financingDealsSC));
	    }
	    List<FinancingDealDetailsCO> treasuryForexDealDtlsList = financingDealsBO
		    .getTreasuryForexDeals(financingDealsSC);
	    setGridModel(treasuryForexDealDtlsList);

	   	}
	   	catch(Exception e)
	   	{
	   	    handleException(e, null, null);
	   	    log.error(e, "Error in Treasury Forex grid");

	   	}
	   	return SUCCESS;

	 }
    // DBU191081 Muhammed Anas End

    public List<FinancingDealsCO> getFinancingDealsCO()
    {
	return financingDealsCOList;
    }

    public void setfinancingDealsCOList(List<FinancingDealsCO> financingDealsCOList)
    {
	this.financingDealsCOList = financingDealsCOList;
    }

    public void setFinancingDealsBO(FinancingDealsBO financingDealsBO)
    {
	this.financingDealsBO = financingDealsBO;
    }

    public void setFinancingDealsSC(FinancingDealsSC financingDealsSC)
    {
	this.financingDealsSC = financingDealsSC;
    }

    public FinancingDealsSC getFinancingDealsSC()
    {
	return financingDealsSC;
    }

    public void setFinancingDealRepaymentPlanCO(FinancingDealRepaymentPlanCO financingDealRepaymentPlanCO)
    {
	this.financingDealRepaymentPlanCO = financingDealRepaymentPlanCO;
    }

    public FinancingDealRepaymentPlanCO getFinancingDealRepaymentPlanCO()
    {
	return financingDealRepaymentPlanCO;
    }

}

