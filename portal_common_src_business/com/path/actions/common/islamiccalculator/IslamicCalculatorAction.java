package com.path.actions.common.islamiccalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.iis.islamiccalculator.IISCommonBO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

public class IslamicCalculatorAction extends BaseAction
{
    private List acccrualBasis = new ArrayList<SelectCO>();
    private List profitCalculationMethod = new ArrayList<SelectCO>();
    private List profitDistMethod = new ArrayList<SelectCO>();
    private List paymPeriodicity = new ArrayList<SelectCO>();
    // TP#247336;Arun.R.Variyath;15/12/2014
    private List discountCalMethodList = new ArrayList<SelectCO>();
    private List gracePeriodicity = new ArrayList<SelectCO>();
    private List paymPeriodPos = new ArrayList<SelectCO>();
    private List roundingFactor = new ArrayList<SelectCO>();
    private List paymentType = new ArrayList<SelectCO>();
    private List autoCreateSettlement = new ArrayList<SelectCO>();
    private List calendarType = new ArrayList<SelectCO>();
    private List<SelectCO> dealTypeDropDownList = new ArrayList<SelectCO>();
    private List flexiMonthList = new ArrayList<SelectCO>();
    private IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
    private String profCalc = "S";
    private String accrual = "1";
    private String payevery = "M";
    private String graceprdcty = "M";
    private String payeverypos = "E";
    private String roundingf = "0";
    private String vataplcable = "N";
    private HashMap<String, String> payResidualAmount = new HashMap<String, String>();

    private String calledFromFirstLeg = "N";

    private String calledFromIPRS = "N";

    private IISCommonBO iisCommonBO;

    public String loadIslamicCalculator()
    {
	SessionCO sessionCO = returnSessionObject();
	initialize();
	islamicCalculatorEventMgmtCO.setIncome(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setApprovedSalary(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setDebtBurdanRatio(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setDownPaymentAmount(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setProfit(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setPurchaseAmount(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setDownPaymentPercentage(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setFinancingAmount(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setAnnualYieldRate(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setAnnualFlatRate(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setTotalFlatRate(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setNoOfMonths(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setPaymPeriodNbr(getBigDecimal(1));
	islamicCalculatorEventMgmtCO.setGracePeriod(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setAmountPerPayment(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setVatPercentage(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setNoOfBaloonPayments(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setRemainingAmount(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setProfit(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setCurrencyCode(sessionCO.getBaseCurrencyCode());
	islamicCalculatorEventMgmtCO.setMargin(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setFloatingRate(getBigDecimal(0));
	islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());

	try
	{
	    CURRENCIESVO currenciesVO = new CURRENCIESVO();
	    currenciesVO.setCOMP_CODE(returnSessionObject().getCompanyCode());
	    currenciesVO.setCURRENCY_CODE(sessionCO.getBaseCurrencyCode());
	    CURRENCIESVO currencyVO = returnCommonLibBO().returnCurrency(currenciesVO);
	    islamicCalculatorEventMgmtCO.setCurrencyDesc(currencyVO.getBRIEF_DESC_ENG());
	    islamicCalculatorEventMgmtCO.setCurrencyDecimalPointsForCalc(currencyVO.getDECIMAL_POINTS());
	    SYS_PARAM_SCREEN_DISPLAYVO sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	    sysParam.setDecFormat(NumberUtil.currencyMask(currencyVO.getDECIMAL_POINTS()));
	    getAdditionalScreenParams().put("financingAmount", sysParam);
	    getAdditionalScreenParams().put("downPaymentAmount", sysParam);
	    getAdditionalScreenParams().put("remainingAmount", sysParam);
	    // getAdditionalScreenParams().put("totalFlatRate", sysParam);
	    getAdditionalScreenParams().put("saleAmount", sysParam);
	    getAdditionalScreenParams().put("profit", sysParam);
	    getAdditionalScreenParams().put("amountPerPaymentResult", sysParam);
	    getAdditionalScreenParams().put("xirr", sysParam);
	    getAdditionalScreenParams().put("baloonAmount", sysParam);

	    sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	    sysParam.setIS_MANDATORY(BigDecimal.ONE);
	    sysParam.setDecFormat(NumberUtil.currencyMask(currencyVO.getDECIMAL_POINTS()));
	    getAdditionalScreenParams().put("purchaseAmount", sysParam);

	    sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	    sysParam.setIS_MANDATORY(BigDecimal.ONE);
	    getAdditionalScreenParams().put("lookuptxt_productClass", sysParam);

	    sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	    sysParam.setIS_MANDATORY(BigDecimal.ONE);
	    getAdditionalScreenParams().put("annualYieldRate", sysParam);
	    islamicCalculatorEventMgmtCO.setCyFormat(NumberUtil.currencyMask(currencyVO.getDECIMAL_POINTS()));

	}
	catch(BaseException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	// currenciesVO = commonLibBO.returnCurrency(currenciesVO);

	return "csmIslamicCalc";
    }

    public String showSchedule()
    {
	return "showSchedule";
    }

    /**
     * Initializing all html selects
     * 
     * @return
     */
    public String initialize()
    {
	try
	{
	    loadAllDropdowns();
	    islamicCalculatorEventMgmtCO.setCompCode(returnSessionObject().getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(returnSessionObject().getBranchCode());
	    islamicCalculatorEventMgmtCO = iisCommonBO.returnIISControlParams(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO.setStartDate(returnSessionObject().getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setMaturityDate(returnSessionObject().getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setFirstPaymentDate(returnSessionObject().getRunningDateRET());
	    setReadOnlyValues(islamicCalculatorEventMgmtCO);

	    // SYS_PARAM_SCREEN_DISPLAYVO sysParam = new
	    // SYS_PARAM_SCREEN_DISPLAYVO();
	    // sysParam.setIS_VISIBLE(new BigDecimal(0));
	    // if(islamicCalculatorEventMgmtCO.getIncome().equals("0"))
	    // getAdditionalScreenParams().put("profitkkkkk", sysParam);

	    payResidualAmount.put("D", getText("Down_Payment_key"));
	    payResidualAmount.put("F", getText("First_key"));
	    payResidualAmount.put("L", getText("Last_key"));
	    // setFieldProperties();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "islamicCalcloaded";
    }

    /***
     * Method for setting the properities such as readonly,mandatory etc..
     * dynamically
     */
    /*
     * private void setFieldProperties() { try { SYS_PARAM_SCREEN_DISPLAYVO
     * buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
     * buisnessElement.setIS_MANDATORY(new BigDecimal(1)); HashMap hm = new
     * HashMap(); hm.put("islamicCalculatorEventMgmtCO.purchaseAmount",
     * buisnessElement); hm.put("islamicCalculatorEventMgmtCO.productClass",
     * buisnessElement); setAdditionalScreenParams(hm); } catch(Exception e) {
     * handleException(e, null, null); } }
     */

    public String getDefaultPayResidualAmount()
    {
	return "L";
    }

    /**
     * Set Read Only Fields base on IISCTRL flags
     * 
     * @param islamicCalculatorEventMgmtCO
     * @throws Exception
     */
    private void setReadOnlyValues(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws Exception
    {
	if("Y".equalsIgnoreCase(islamicCalculatorEventMgmtCO.getCalcDisableStartDate()))
	{
	    islamicCalculatorEventMgmtCO.setCalcDisableStartDateReadOnly(true);
	}
	if("N".equalsIgnoreCase(islamicCalculatorEventMgmtCO.getAllowProfitRecoInCalc()))
	{
	    islamicCalculatorEventMgmtCO.setAllowProfitRecoInCalcReadOnly(false);
	}
	if("Y".equalsIgnoreCase(islamicCalculatorEventMgmtCO.getAllowEditYieldInCalc()))
	{
	    islamicCalculatorEventMgmtCO.setAllowEditYieldInCalcReadOnly(false);
	}
	if("Y".equalsIgnoreCase(islamicCalculatorEventMgmtCO.getAllowToEditProfitDistMthd()))
	{
	    islamicCalculatorEventMgmtCO.setAllowToEditProfitDistMthdReadOnly(false);
	}
	if("Y".equalsIgnoreCase(islamicCalculatorEventMgmtCO.getAllowEditFinanceCyInCalc()))
	{
	    islamicCalculatorEventMgmtCO.setAllowEditFinanceCyInCalcReadOnly(false);
	}
	islamicCalculatorEventMgmtCO.setAllowToEditProfitDistMthdReadOnly(false);

    }

    /**
     * Load all drop down box with values from database
     * 
     * @throws Exception
     */
    private void loadAllDropdowns() throws Exception
    {
	SelectSC selSC = new SelectSC(new BigDecimal(44));// Acccrual Basis
	acccrualBasis = returnLOV(selSC);

	selSC = new SelectSC(new BigDecimal(45));// Profit Calculation Method
	profitCalculationMethod = returnLOV(selSC);

	selSC = new SelectSC(new BigDecimal(46));// Profit Dist Method
	profitDistMethod = returnLOV(selSC);

	loadPaymPeriodicity(); // Paym Periodicity

	// TP#227337;Arun.R.Variyath;29/09/2014
	selSC = new SelectSC(new BigDecimal(145));// Grace Periodicity
	gracePeriodicity = returnLOV(selSC);

	loadPaymPeriodPosition(); // Paym Period Pos

	selSC = new SelectSC(new BigDecimal(50));// Rounding Factor
	roundingFactor = returnLOV(selSC);

	selSC = new SelectSC(new BigDecimal(43));// autoCreateSettlement
	autoCreateSettlement = returnLOV(selSC);

	selSC = new SelectSC(new BigDecimal(135));// Calendar Type
	calendarType = returnLOV(selSC);

	// TP#258237;Arun.R.Variyath;06/01/2015
	selSC = new SelectSC(new BigDecimal(579));// Paym
	setDiscountCalMethodList(returnLOV(selSC));

	dealTypeDropDownList = new ArrayList<SelectCO>();
	selSC = new SelectSC(new BigDecimal(1201));
	selSC.setPreferredLanguage(returnSessionObject().getPreferredLanguage());
	selSC.setOrderCriteria(ConstantsCommon.LOV_ORDER_BY_SPECIFIC_ORDER);
	dealTypeDropDownList = (ArrayList<SelectCO>) returnLOV(selSC);

	selSC = new SelectSC(new BigDecimal(286));
	selSC.setOrderCriteria(ConstantsCommon.LOV_ORDER_BY_SPECIFIC_ORDER);
	flexiMonthList = returnLOV(selSC);

	loadAutoCreateSettlement();
    }

    /***
     * method for loading auto create settlement for repayment
     * 
     * @return
     */
    public String loadAutoCreateSettlement()
    {
	try
	{
	    SelectSC selSC = new SelectSC(new BigDecimal(43));
	    autoCreateSettlement = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return SUCCESS;
    }

    /**
     * Method for periodicity
     * 
     * @return
     */
    public String loadPaymPeriodicity()
    {
	try
	{
	    SelectSC selSC = new SelectSC(new BigDecimal(47));// Paym
	    // Periodicity
	    paymPeriodicity = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return SUCCESS;
    }

    /**
     * Method for period position
     * 
     * @return
     */
    public String loadPaymPeriodPosition()
    {
	try
	{
	    SelectSC selSC = new SelectSC(new BigDecimal(49));// Paym Period Pos
	    List<SelectCO> paymPeriodPosTemp; // = new ArrayList<SelectCO>();
	    paymPeriodPosTemp = returnLOV(selSC);
	    // TP#212220; Ramesh; Date 24/08/2014 [commented due to Oracle DB is
	    // not allowing -1. DB column size is 1 and passing parameter size
	    // is 2 exception getiing. Thats why we commented this line of code]
	    SelectCO selectCO = new SelectCO();
	    // TP# 237041 ;Libin ;05/11/2014
	    // [Added it as this entry is needed as its referred from lot of
	    // areas
	    // and also the above mentioned issue will not occur if its a blank
	    // string.So replaced -1 with ""
	    // Checked with Ramesh]
	    // selectCO.setCode("-1");
	    selectCO.setCode("");
	    selectCO.setDescValue(" ");
	    paymPeriodPos = new ArrayList<SelectCO>();
	    paymPeriodPos.add(selectCO);

	    for(SelectCO selCO : paymPeriodPosTemp)
	    {
		paymPeriodPos.add(selCO);
	    }
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return SUCCESS;
    }

    /***
     * Method for getting payment types
     * 
     * @return
     */
    public String loadPaymentType()
    {
	try
	{
	    SelectSC selSC = new SelectSC(new BigDecimal(66));// Payment Type
	    if(ConstantsCommon.YES.equals(calledFromIPRS))
	    {
		selSC.setLovCodesInlude("'P'");
	    }
	    paymentType = returnLOV(selSC);

	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return SUCCESS;
    }

    public List getPaymentType()
    {
	return paymentType;
    }

    public void setPaymentType(List paymentType)
    {
	this.paymentType = paymentType;
    }

    public List getAcccrualBasis()
    {
	return acccrualBasis;
    }

    public void setAcccrualBasis(List acccrualBasis)
    {
	this.acccrualBasis = acccrualBasis;
    }

    public List getProfitCalculationMethod()
    {
	return profitCalculationMethod;
    }

    public void setProfitCalculationMethod(List profitCalculationMethod)
    {
	this.profitCalculationMethod = profitCalculationMethod;
    }

    public List getProfitDistMethod()
    {
	return profitDistMethod;
    }

    public void setProfitDistMethod(List profitDistMethod)
    {
	this.profitDistMethod = profitDistMethod;
    }

    public List getPaymPeriodicity()
    {
	return paymPeriodicity;
    }

    public void setPaymPeriodicity(List paymPeriodicity)
    {
	this.paymPeriodicity = paymPeriodicity;
    }

    public List getGracePeriodicity()
    {
	return gracePeriodicity;
    }

    public void setGracePeriodicity(List gracePeriodicity)
    {
	this.gracePeriodicity = gracePeriodicity;
    }

    public List getPaymPeriodPos()
    {
	return paymPeriodPos;
    }

    public void setPaymPeriodPos(List paymPeriodPos)
    {
	this.paymPeriodPos = paymPeriodPos;
    }

    public List getRoundingFactor()
    {
	return roundingFactor;
    }

    public void setRoundingFactor(List roundingFactor)
    {
	this.roundingFactor = roundingFactor;
    }

    /**
     * @return the islamicCalculatorEventMgmtCO
     */
    public IslamicCalculatorEventMgmtCO getIslamicCalculatorEventMgmtCO()
    {
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * @param islamicCalculatorEventMgmtCO the islamicCalculatorEventMgmtCO to
     *            set
     */
    public void setIslamicCalculatorEventMgmtCO(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
    {
	this.islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCO;
    }

    /**
     * @return the iisCommonBO
     */
    /*
     * public IISCommonBO getIisCommonBO() { return iisCommonBO; }
     */

    /**
     * @param iisCommonBO the iisCommonBO to set
     */
    public void setIisCommonBO(IISCommonBO iisCommonBO)
    {
	this.iisCommonBO = iisCommonBO;
    }

    private BigDecimal getBigDecimal(int value)
    {
	return new BigDecimal(value);
    }

    public void setProfCalc(String profCalc)
    {
	this.profCalc = profCalc;
    }

    public String getProfCalc()
    {
	return profCalc;
    }

    public String getAccrual()
    {
	return accrual;
    }

    public void setAccrual(String accrual)
    {
	this.accrual = accrual;
    }

    public String getPayevery()
    {
	return payevery;
    }

    public void setPayevery(String payevery)
    {
	this.payevery = payevery;
    }

    public String getPayeverypos()
    {
	return payeverypos;
    }

    public void setPayeverypos(String payeverypos)
    {
	this.payeverypos = payeverypos;
    }

    public String getRoundingf()
    {
	return roundingf;
    }

    public void setRoundingf(String roundingf)
    {
	this.roundingf = roundingf;
    }

    public String getGraceprdcty()
    {
	return graceprdcty;
    }

    public void setGraceprdcty(String graceprdcty)
    {
	this.graceprdcty = graceprdcty;
    }

    public HashMap<String, String> getPayResidualAmount()
    {
	return payResidualAmount;
    }

    public void setPayResidualAmount(HashMap<String, String> payResidualAmount)
    {
	this.payResidualAmount = payResidualAmount;
    }

    public String getVataplcable()
    {
	return vataplcable;
    }

    public void setVataplcable(String vataplcable)
    {
	this.vataplcable = vataplcable;
    }

    public List getAutoCreateSettlement()
    {
	return autoCreateSettlement;
    }

    public void setAutoCreateSettlement(List autoCreateSettlement)
    {
	this.autoCreateSettlement = autoCreateSettlement;
    }

    public List getCalendarType()
    {
	return calendarType;
    }

    public void setCalendarType(List calendarType)
    {
	this.calendarType = calendarType;
    }

    public List getDiscountCalMethodList()
    {
	return discountCalMethodList;
    }

    public void setDiscountCalMethodList(List discountCalMethodList)
    {
	this.discountCalMethodList = discountCalMethodList;
    }

    public String getCalledFromFirstLeg()
    {
	return calledFromFirstLeg;
    }

    public void setCalledFromFirstLeg(String calledFromFirstLeg)
    {
	this.calledFromFirstLeg = calledFromFirstLeg;
    }

    public String getCalledFromIPRS()
    {
	return calledFromIPRS;
    }

    public void setCalledFromIPRS(String calledFromIPRS)
    {
	this.calledFromIPRS = calledFromIPRS;
    }

    public List<SelectCO> getDealTypeDropDownList()
    {
	return dealTypeDropDownList;
    }

    public void setDealTypeDropDownList(List<SelectCO> dealTypeDropDownList)
    {
	this.dealTypeDropDownList = dealTypeDropDownList;
    }

    public List getFlexiMonthList()
    {
	return flexiMonthList;
    }

    public void setFlexiMonthList(List flexiMonthList)
    {
	this.flexiMonthList = flexiMonthList;
    }

}