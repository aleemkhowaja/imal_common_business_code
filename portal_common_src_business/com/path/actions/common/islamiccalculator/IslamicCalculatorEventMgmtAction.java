package com.path.actions.common.islamiccalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.iis.IISCommonConstants;
import com.path.bo.common.iis.dealcharges.IISDealChargesBO;
import com.path.bo.common.iis.islamiccalculator.IISCommonBO;
import com.path.bo.common.iis.islamiccalculator.IISIslamicCalculatorBO;
import com.path.bo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtBO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.IISCTRLVO;
import com.path.dbmaps.vo.IISCTRLVOKey;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.TRSDEAL3VO;
import com.path.dbmaps.vo.TRSDEAL_MULTIPLE_YIELDVO;
import com.path.dbmaps.vo.TRSDEAL_NIDCVO;
import com.path.dbmaps.vo.TRSDEAL_NIDC_COUPON_PYMNTVO;
import com.path.dbmaps.vo.TRSDEAL_NIDC_DETVO;
import com.path.dbmaps.vo.TRSPAYPLAN_CRITERIAVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.LabelElemCO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.iis.dealcharges.IisDealChargesCO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IISCustomerLimitCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorCustGuarLiabilitiesListCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.common.iis.islamiccalculator.TrsDealSettlementChargesCO;
import com.path.vo.common.iis.islamiccalculator.TrsPlanBallonPaymentCO;
import com.path.vo.common.iis.islamiccalculator.TrsdealMultipleYieldCO;
import com.path.vo.common.iis.islamiccalculator.TrsdealNidcCO;
import com.path.vo.common.iis.islamiccalculator.TrspayplanCriteriaCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.common.select.SelectCO;

public class IslamicCalculatorEventMgmtAction extends BaseAction
{
    private IslamicCalculatorEventMgmtBO islamicCalculatorEventMgmtBO;
    private IISCommonBO iisCommonBO;
    private IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
    private IslamicCalculatorCO calculatorCO = new IslamicCalculatorCO();
    private TrsdealNidcCO trsdealNidcCO = new TrsdealNidcCO();
    private IISIslamicCalculatorBO iisIslamicCalculatorBO;
    private IISCommonCO iisCommonCO = new IISCommonCO();
    private String strDealCharges;
    private String strRepaymentCharges;
    private String strBalloonDetails;
    private String strConfirm;
    private String projectFinanceDetails;
    private String strBillsDealCharges;
    private String strNIDCList;
	
    private IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
    private IISDealChargesBO iisDealChargesBO;
    private TrsDealChargesCO trsDealChargesCO;
    private MemoSC _memo;
    private String strMultipleYieldList;
    private String tentativeSchedule = "N";
    private String confirmType;
    // TP#244113; Ramesh; Date 09/12/2014
    private BigDecimal totalAllcBlnAmt;
	private Object confirmReturn;
	// EWBI160081; Saheer.Naduthodi; 01/07/2016 
	 
    // TP# 190913;deepu.mohandas 15/05/2015
    private String activeDealCount;

    // BB130272 Added;Ravikant.Singh;19/05/2015
    private String custGuarLiabilityListDet;
    private String settlementChargeGridData;
    private String strNIDCDetail;
    private String strNIDCCouponPayment;

    private String companyDomain;
    private String companyTelNo;

	public String onchangeBlackListRestrictionReasonCode()
	{
		try 
		{
			SessionCO sessionCO = returnSessionObject();
			islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
			islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
			islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO.onchangeBlackListRestrictionReasonCode(islamicCalculatorEventMgmtCO);
		
		} catch (Exception e) {
			islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
			handleException(e, null, null);
		}
	return SUCCESS;
	}

    private List linkTypeList = new ArrayList<SelectCO>();

    public String getConfirmType()
    {
	return confirmType;
    }

    public void setConfirmType(String confirmType)
    {
	this.confirmType = confirmType;
    }

    /***
     * // **************************** START NIZI120160 ******************
     * 
     * Method for validating One Obligor Global Limit
     * 
     * @return
     */
    public String validateOneObligorGlobalLimit()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());

	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    islamicCalculatorEventMgmtCO = iisIslamicCalculatorBO
		    .validateOneObligorGlobalLimit(islamicCalculatorEventMgmtCO);// validating

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateRepayamentCriteriaList";
    }

    /**
     * TP 253158 -Renaming by product category - Sreejith
     */
    public void setAdditionalScreenParams(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> additionalScreenParams)
    {
	// iterate to translate the Label key if available
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> theParams = additionalScreenParams;
	if(theParams != null)
	{
	    for(Map.Entry<String, SYS_PARAM_SCREEN_DISPLAYVO> e : theParams.entrySet())
	    {
		String key = e.getKey();
		SYS_PARAM_SCREEN_DISPLAYVO currVO = theParams.get(key);
		List<LabelElemCO> labelsLst = currVO.getLabelsLst();
		if(labelsLst != null && !labelsLst.isEmpty())
		{
		    for(LabelElemCO labelElemCO : labelsLst)
		    {
			labelElemCO.setValue(getText(labelElemCO.getValue()));

		    }
		}
	    }
	}
	super.setAdditionalScreenParams(theParams);
    }

    // TP# BB130052;deepu.mohandas 08/09/2015
    public String afterDependencyForOnChangeMaturityDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .afterDependencyForOnChangeMaturityDate(islamicCalculatorEventMgmtCO);
	}
	catch(BOException ex)
	{
	    String msgIdent;
	    msgIdent = (ex).getMsgIdent();
	    if(msgIdent != null)
	    {
		setConfirmType(msgIdent);
	    }
	    handleException(ex, null, null);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String dependencyGlobalRateBillsCalculator()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .dependencyGlobalRateBillsCalculator(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String dependencyMarginRateBillsCalculator()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .dependencyMarginRateBillsCalculator(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String iborDependencyPeriodicity()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .iborDependencyPeriodicity(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String dependencyPeriodicity()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .dependencyPeriodicity(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String dependencyTradingBillAmount()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .dependencyTradingBillAmount(islamicCalculatorEventMgmtCO);
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String dependencyByCrossRate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .dependencyByCrossRate(islamicCalculatorEventMgmtCO);

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    // TODO need to remove
    private String strBalloonDate;

    public SYS_PARAM_SCREEN_DISPLAYVO returnSysParamEnament(String elementName)
    {
	if(getAdditionalScreenParams().get(elementName) == null)
	{
	    SYS_PARAM_SCREEN_DISPLAYVO buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	    buisnessElement.setELEMENT_NAME(elementName);
	    return buisnessElement;
	}
	else
	{
	    getAdditionalScreenParams().get(elementName).setELEMENT_NAME(elementName);
	    return getAdditionalScreenParams().get(elementName);
	}
    }

    protected void applyColumnProperties(String elementName, String actionType, Object actionValue,
	    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap)
    {
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> localElementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	SYS_PARAM_SCREEN_DISPLAYVO buisnessElement;
	// new BigDecimal(0) removed due to infractions and assigned like below
	BigDecimal decimalValue = BigDecimal.ZERO;
	String stringValue = "";
	Date dateValue = Calendar.getInstance().getTime();
	Boolean booleanValue = false;

	if(actionValue instanceof BigDecimal)
	{
	    decimalValue = (BigDecimal) actionValue;
	}

	if(actionValue instanceof String)
	{
	    stringValue = actionValue.toString();
	}

	if(actionValue instanceof Date)
	{
	    dateValue = (Date) actionValue;
	}

	if(actionValue instanceof Boolean)
	{
	    booleanValue = (Boolean) actionValue;
	}

	if(elementHashmap.get(elementName) == null)
	{
	    buisnessElement = new SYS_PARAM_SCREEN_DISPLAYVO();
	    buisnessElement.setELEMENT_NAME(elementName);
	}
	else
	{
	    buisnessElement = elementHashmap.get(elementName);
	}

	if(actionType.equals(IISCommonConstants.ACTION_TYPE_VISIBLE))
	{
	    buisnessElement.setIS_VISIBLE(decimalValue);
	}

	if(actionType.equals(IISCommonConstants.ACTION_TYPE_REQUIRED))
	{
	    buisnessElement.setIS_MANDATORY(decimalValue);
	}

	if(actionType.equals(IISCommonConstants.ACTION_TYPE_READ_ONLY)
		|| actionType.equals(IISCommonConstants.ACTION_TYPE_READONLY))
	{
	    buisnessElement.setIS_READONLY(decimalValue);
	}

	if(actionType.equals(IISCommonConstants.ACTION_TYPE_LABEL))
	{
	    buisnessElement.setLABEL_KEY(stringValue);
	}
	if(actionType.equals(IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT))
	{
	    buisnessElement.setDecFormat(stringValue);

	}
	if(actionType.equals(IISCommonConstants.ACTION_TYPE_OVERWRITE_READONLY))
	{
	    buisnessElement.setOverWriteReadOnly(booleanValue);

	}
	if(actionType.equals(IISCommonConstants.ACTION_TYPE_VALUE))
	{
	    if(actionValue instanceof BigDecimal)
	    {
		buisnessElement.setValue(decimalValue);
	    }
	    if(actionValue instanceof String)
	    {
		buisnessElement.setValue(stringValue);
	    }
	    if(actionValue instanceof Date)
	    {
		buisnessElement.setValue(dateValue);
	    }
	}

	localElementHashmap.put(elementName, buisnessElement);
	elementHashmap.putAll(localElementHashmap);
    }

    /**
     * Method to execute the onchange of Contract price
     * 
     * @return
     */
    public String onChangeContractPrice()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeContractPrice(islamicCalculatorEventMgmtCO);
	    if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getContractPrice()).compareTo(BigDecimal.ZERO) == 1)
	    {
		SYS_PARAM_SCREEN_DISPLAYVO sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
		sysParam.setIS_READONLY(BigDecimal.ONE);
		getAdditionalScreenParams().put("annualYieldRate", sysParam);
		getAdditionalScreenParams().put("totalFlatRate", sysParam);

	    }

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "success";
    }

    /**
     * Method to execute the onchange of Discount calculatin method
     * 
     * @return
     */
    public String onChangeDiscountCalMethod()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeDiscountCalMethod(islamicCalculatorEventMgmtCO);

	    if(islamicCalculatorEventMgmtCO.getContractPrice().compareTo(BigDecimal.ZERO) == 1)
	    {
		SYS_PARAM_SCREEN_DISPLAYVO sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
		sysParam.setIS_READONLY(BigDecimal.ONE);
		getAdditionalScreenParams().put("annualYieldRate", sysParam);
		getAdditionalScreenParams().put("totalFlatRate", sysParam);

	    }

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "success";
    }

    /**
     * Method to execute the onchange of Discount Percentage method
     * 
     * @return
     */
    public String onChangeDiscountPerc()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeDiscountPerc(islamicCalculatorEventMgmtCO);

	    if(islamicCalculatorEventMgmtCO.getContractPrice().compareTo(BigDecimal.ZERO) == 1)
	    {
		SYS_PARAM_SCREEN_DISPLAYVO sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
		sysParam.setIS_READONLY(BigDecimal.ONE);
		getAdditionalScreenParams().put("annualYieldRate", sysParam);
		getAdditionalScreenParams().put("totalFlatRate", sysParam);

	    }

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "success";
    }

    /**
     * Method for checking whether CIF is black listed or not
     * 
     * @return
     */
    public String isCifBlackListed()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    iisCommonCO.setCompCode(sessionCO.getCompanyCode());
	    iisCommonCO.setBranchCode(sessionCO.getBranchCode());
	    iisCommonCO = iisCommonBO.isBlackListed(iisCommonCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "isCifBlackListed";
    }

    /**
     * Method for validating the CIF which is suspended,black listed ,etc...
     * 
     * @return
     */
    public String validateOnChangeCifCivilId()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    iisCommonCO.setCompCode(sessionCO.getCompanyCode());
	    iisCommonCO.setBranchCode(sessionCO.getBranchCode());
	    iisCommonCO = iisCommonBO.validateCifStatus(iisCommonCO);
	}
	catch(Exception e)
	{
	    iisCommonCO = new IISCommonCO();
	    handleException(e, null, null);
	}
	return "validateOnChangeCifCivilId";
    }

    /**
     * Method for populating on CIF details in the screen while choosing a CIF
     * number.
     * 
     * @return
     */
    public String onChangeCifCivilId()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setAppName("IIS");
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setCalculatorLanguage(sessionCO.getLanguage());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());

	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    BigDecimal currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeCif(islamicCalculatorEventMgmtCO);
	    if(!IISCommonConstants.ISLAMIC_CALCULATOR_AR_RAHANU
		    .equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    {
		setDecimalFormatBySelectedCurrency(sessionCO,
			currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											       // DECIMAL
											       // FORMAT
											       // BASED
											       // ON
	    }
	    if(islamicCalculatorEventMgmtCO != null)
	    {
		set_memo(islamicCalculatorEventMgmtCO.getMemoSC());
		if(islamicCalculatorEventMgmtCO.getExistingDealStatusMessage() != null)

		{
		    String returnTranslErrorMessage = returnCommonLibBO().returnTranslErrorMessage(
			    NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getExistingDealStatusMessage()),
			    new String[] { StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getACTIVE_DEAL_COUNT()),
				    StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getAPPROVE_DEAL_COUNT()),
				    StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getDELETE_DEAL_COUNT()),
				    StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getREVERSE_DEAL_COUNT()),
				    StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getREJECT_DEAL_COUNT()), },
			    sessionCO.getLanguage());
		    set_msgTitle(getText("warning_title_key"));
		    set_dependencyMsg(returnTranslErrorMessage);

		}
	    }
	}
	catch(BOException ex)
	{

	    String msgIdent;
	    msgIdent = (ex).getMsgIdent();
	    if(msgIdent != null)
	    {
		setConfirmType(msgIdent);
	    }
	    setActiveDealCount(StringUtil.nullToEmpty(ex.getRetValue()).toString());
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(ex, null, null);

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeCifNumber";
    }

    /**
     * 
     * @return String
     */
    public String onChangeCivilId()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setAppName("IIS");
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("onChangeCivilId");

	    log.info("compCode		:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode		:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("App Names		:	" + islamicCalculatorEventMgmtCO.getAppName());
	    log.info("Cif_No			:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("ValueDate		:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("Product class	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    // TO Check the NullPointer Exception in Console
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeCivilId(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO != null
		    && islamicCalculatorEventMgmtCO.getExistingDealStatusMessage() != null)
	    {
		set_msgTitle(getText("warning_title_key"));
		set_dependencyMsg(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getExistingDealStatusMessage()),
			new String[] { StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getACTIVE_DEAL_COUNT()),
				StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getAPPROVE_DEAL_COUNT()),
				StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getDELETE_DEAL_COUNT()),
				StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getREVERSE_DEAL_COUNT()),
				StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getREJECT_DEAL_COUNT()), },
			sessionCO.getLanguage()));
	    }
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeCivilId";
    }

    /**
     * Method for on change event of Approved Salary
     * 
     * @return
     */
    public String onChangeApprovedSalary()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    log.info("onChangeApprovedSalary");

	    log.info("compCode			:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode			:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("Cif_No	  			:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("ClassCode			:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("ValueDate			:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("CifApprovedSalary	:	" + islamicCalculatorEventMgmtCO.getApprovedSalary());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeApprovedSalary(islamicCalculatorEventMgmtCO);

	    log.info("Output CifApprovedSalary	:	" + islamicCalculatorEventMgmtCO.getApprovedSalary());
	    log.info("Output DBR	:	" + islamicCalculatorEventMgmtCO.getDebtBurdanRatio());

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeApprovedSalary";
    }

    /**
     * Method for on change event of Salary with Bank
     * 
     * @return
     */
    public String onChangeSalaryWithBank()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());

	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeSalaryWithBank(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeSalaryWithBank";
    }

    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> translateLabel()
    {
	return translateLabel(islamicCalculatorEventMgmtCO.getHmSysParam());

    }

    protected HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> translateLabel(
	    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hmSysParam)
    {
	// iterate to translate the Label key if available
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> theParams = hmSysParam;
	if(theParams != null)
	{
	    // Changed hashmap iteration method from keyset to entryset for
	    // performance enhancement
	    for(Map.Entry<String, SYS_PARAM_SCREEN_DISPLAYVO> entry : theParams.entrySet())
	    {

		SYS_PARAM_SCREEN_DISPLAYVO currVO = entry.getValue();
		if(currVO != null && currVO.getLABEL_KEY() != null)
		{
		    currVO.setLABEL_KEY(getText(currVO.getLABEL_KEY()));
		}
	    }

	}

	return theParams;
    }

    /**
     * Method for populating the details based on selected product class
     * 
     * @return
     */
    public String onChangeProductClass()
    {
	SessionCO sessionCO = null;
	BigDecimal currencyCode = null;
	try
	{
	    sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setCommencementDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO.setPrefferedLanguage(sessionCO.getLanguage());
	    islamicCalculatorEventMgmtCO.setAppName(sessionCO.getCurrentAppName());
	    currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO.setYield(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield()));

	    // For Bills Calculator
	    if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    {
		if(StringUtil.isNotEmpty(strBillsDealCharges))
		{
		    GridUpdates gridData = getGridUpdates(strBillsDealCharges, IslamicCalculatorEventMgmtCO.class,
			    true);
		    islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
		}

		if(StringUtil.isNotEmpty(strNIDCDetail))
		{
		    GridUpdates gridData = getGridUpdates(strNIDCDetail, TRSDEAL_NIDCVO.class, true);// Deal
		    islamicCalculatorEventMgmtCO.setTrsdealNIDCDETVOList(gridData.getLstAllRec());
		}
		else
		{
		    islamicCalculatorEventMgmtCO.setTrsdealNIDCDETVOList(new ArrayList<TRSDEAL_NIDC_DETVO>());
		}
	    }

	    if(currencyCode == null || currencyCode.compareTo(BigDecimal.ZERO) == -1)
	    {
		currencyCode = sessionCO.getBaseCurrencyCode();
	    }

	    setDecimalFormatBySelectedCurrency(sessionCO, currencyCode);//
	    // APPLY
	    // DECIMAL
	    // FORMAT BASED ON
	    // CURRENCY

	    // Added deal charges as param - based on issue 0092514
	    if(StringUtil.isNotEmpty(strDealCharges))
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }
	    // log.info(BillCalculatorConstant.BillAmount);
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeProductClass(islamicCalculatorEventMgmtCO);
	    linkTypeList = islamicCalculatorEventMgmtCO.getLinkTypeList();
	    /**
	     * TP 253158 -Renaming by product category - Sreejith commented the
	     */
	    setAdditionalScreenParams(islamicCalculatorEventMgmtCO.getHmSysParam());

	    // TP#200684; Ramesh; Date 17/08/2014 [START]
	    SYS_PARAM_SCREEN_DISPLAYVO sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();

	    if((ConstantsCommon.NO).equals(islamicCalculatorEventMgmtCO.getVatApplicable()))
	    {

		sysParam.setIS_VISIBLE(BigDecimal.ZERO);
		getAdditionalScreenParams().put("vatSection", sysParam);
	    }
	    else
	    {
		sysParam.setIS_VISIBLE(BigDecimal.ONE);
		getAdditionalScreenParams().put("vatSection", sysParam);
	    }
	    // TP#200684; Ramesh; Date 17/08/2014 [END]
	    sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();

	    sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	    // TP#242355; Ramesh; Date 24/11/2014 [START]
	    if((ConstantsCommon.NO).equals(islamicCalculatorEventMgmtCO.getAllowtoEditVat()))
	    {
		sysParam.setIS_READONLY(BigDecimal.ONE);
		getAdditionalScreenParams().put("vatApplicable", sysParam);

	    }
	    else if((ConstantsCommon.YES).equals(islamicCalculatorEventMgmtCO.getIncludeVatinInstallment()))
	    {
		sysParam.setIS_READONLY(BigDecimal.ONE);
		getAdditionalScreenParams().put("vatApplicable", sysParam);
	    }
	    else
	    {
		sysParam.setIS_READONLY(BigDecimal.ZERO);
		getAdditionalScreenParams().put("vatApplicable", sysParam);
	    }
	    // TP#242355; Ramesh; Date 24/11/2014 [END]
	    sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	    // TP#242375; Ramesh; Date 30/11/2014 [START]
	    if((ConstantsCommon.NO).equals(islamicCalculatorEventMgmtCO.getAllowtoEditVat()))
	    {
		sysParam.setIS_READONLY(BigDecimal.ONE);
		getAdditionalScreenParams().put("lookuptxt_vatCode", sysParam);
	    }
	    else if((ConstantsCommon.YES).equals(islamicCalculatorEventMgmtCO.getVatApplicable()))
	    {
		sysParam.setIS_READONLY(BigDecimal.ZERO);
		getAdditionalScreenParams().put("lookuptxt_vatCode", sysParam);
	    }
	    else
	    {
		sysParam.setIS_READONLY(BigDecimal.ONE);
		getAdditionalScreenParams().put("lookuptxt_vatCode", sysParam);
	    }
	    // TP#242375; Ramesh; Date 30/11/2014 [END]

	    // TP#255360; Ramesh; Date 06/01/2015 [START]
	    sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	    if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getDrawDownCode()).compareTo(BigDecimal.ZERO) <= 0)
	    {

		sysParam = returnSysParamEnament("lookuptxt_floatingRateCode1");
		sysParam.setIS_READONLY(BigDecimal.ZERO);
		getAdditionalScreenParams().put("lookuptxt_floatingRateCode1", sysParam);
	    }
	    else
	    {
		sysParam = returnSysParamEnament("lookuptxt_floatingRateCode1");
		sysParam.setIS_READONLY(BigDecimal.ONE);
		getAdditionalScreenParams().put("lookuptxt_floatingRateCode1", sysParam);
	    }

	    if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    {

		if((ConstantsCommon.NO).equals(islamicCalculatorEventMgmtCO.getShowVat()))
		{
		    sysParam.setIS_VISIBLE(BigDecimal.ZERO);
		    getAdditionalScreenParams().put("lookuptxt_vatCode", sysParam);

		    sysParam.setIS_VISIBLE(BigDecimal.ZERO);
		    getAdditionalScreenParams().put("vatDesc", sysParam);

		    sysParam.setIS_VISIBLE(BigDecimal.ZERO);
		    getAdditionalScreenParams().put("vatPercentage", sysParam);

		    sysParam.setIS_VISIBLE(BigDecimal.ZERO);
		    getAdditionalScreenParams().put("vatInstallment", sysParam);

		    sysParam.setIS_VISIBLE(BigDecimal.ZERO);
		    getAdditionalScreenParams().put("vatApplicable", sysParam);

		}
		else if((ConstantsCommon.YES).equals(islamicCalculatorEventMgmtCO.getShowVat()))
		{
		    sysParam.setIS_VISIBLE(BigDecimal.ONE);
		    getAdditionalScreenParams().put("lookuptxt_vatCode", sysParam);

		    sysParam.setIS_VISIBLE(BigDecimal.ONE);
		    getAdditionalScreenParams().put("vatDesc", sysParam);

		    sysParam.setIS_VISIBLE(BigDecimal.ONE);
		    getAdditionalScreenParams().put("vatPercentage", sysParam);

		    sysParam.setIS_VISIBLE(BigDecimal.ONE);
		    getAdditionalScreenParams().put("vatInstallment", sysParam);

		    sysParam.setIS_VISIBLE(BigDecimal.ONE);
		    getAdditionalScreenParams().put("vatApplicable", sysParam);
		}

	    }

	    if(!IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    {

		if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getFloatingRateCode())
			.compareTo(BigDecimal.ZERO) <= 0)
		{

		    sysParam = returnSysParamEnament("floatingRate");
		    sysParam.setIS_READONLY(BigDecimal.ONE);
		    getAdditionalScreenParams().put("floatingRate", sysParam);
		    islamicCalculatorEventMgmtCO.getHmSysParam();

		}
		else
		{
		    if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getDrawDownCode())
			    .compareTo(BigDecimal.ZERO) <= 0)
		    {
			IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();
			iisctrlvoKey.setCOMP_CODE(sessionCO.getCompanyCode());
			iisctrlvoKey.setBRANCH_CODE(sessionCO.getBranchCode());
			IISCTRLVO iisctrl = iisCommonBO.returnIISCTRL(iisctrlvoKey);
			// TP-683130
			if((StringUtil.nullEmptyToValue(iisctrl.getCALC_ALLOW_TO_EDIT_FLOAT_RT(), "N")
				.equals(ConstantsCommon.YES))
				|| ((ConstantsCommon.YES).equals(islamicCalculatorEventMgmtCO.getFLOATING_RATE())))
			{
			    sysParam = returnSysParamEnament("floatingRate");
			    sysParam.setIS_READONLY(BigDecimal.ZERO);
			    getAdditionalScreenParams().put("floatingRate", sysParam);
			}
			else
			{
			    sysParam = returnSysParamEnament("floatingRate");
			    sysParam.setIS_READONLY(BigDecimal.ONE);
			    getAdditionalScreenParams().put("floatingRate", sysParam);
			}
		    }
		    else
		    {
			sysParam = returnSysParamEnament("floatingRate");
			sysParam.setIS_READONLY(BigDecimal.ONE);
			getAdditionalScreenParams().put("floatingRate", sysParam);
		    }
		}

		// TP#255360; Ramesh; Date 06/01/2015 [END]

		// TP#280422;Arun.R.Variyath;16/03/2015
		if("ISLAMIC_CORPORTAE".equals(islamicCalculatorEventMgmtCO.getCalculatorType())
			|| (ConstantsCommon.YES).equals(islamicCalculatorEventMgmtCO.getFLOATING_RATE())
			|| NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getLimitSerialNo())
				.compareTo(BigDecimal.ZERO) > 0)
		{
		    sysParam = returnSysParamEnament("floatingRate");
		    sysParam.setIS_VISIBLE(BigDecimal.ONE);
		    getAdditionalScreenParams().put("floatingRate", sysParam);
		    islamicCalculatorEventMgmtCO.getHmSysParam();

		    sysParam = returnSysParamEnament("lookuptxt_floatingRateCode1");
		    sysParam.setIS_VISIBLE(BigDecimal.ONE);
		    getAdditionalScreenParams().put("lookuptxt_floatingRateCode1", sysParam);
		    islamicCalculatorEventMgmtCO.getHmSysParam();

		    sysParam = returnSysParamEnament("floatingRateCode_desc12");
		    sysParam.setIS_VISIBLE(BigDecimal.ONE);
		    getAdditionalScreenParams().put("floatingRateCode_desc12", sysParam);
		    islamicCalculatorEventMgmtCO.getHmSysParam();

		}
		else
		{
		    sysParam = returnSysParamEnament("floatingRate");
		    sysParam.setIS_VISIBLE(BigDecimal.ZERO);
		    getAdditionalScreenParams().put("floatingRate", sysParam);
		    islamicCalculatorEventMgmtCO.getHmSysParam();

		    sysParam = returnSysParamEnament("lookuptxt_floatingRateCode1");
		    sysParam.setIS_VISIBLE(BigDecimal.ZERO);
		    getAdditionalScreenParams().put("lookuptxt_floatingRateCode1", sysParam);
		    islamicCalculatorEventMgmtCO.getHmSysParam();

		    sysParam = returnSysParamEnament("floatingRateCode_desc12");
		    sysParam.setIS_VISIBLE(BigDecimal.ZERO);
		    getAdditionalScreenParams().put("floatingRateCode_desc12", sysParam);
		    islamicCalculatorEventMgmtCO.getHmSysParam();
		}
	    }
	    // TP#247336;Arun.R.Variyath;10/12/2014 [Start]
	    if(!IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    {
		if(ConstantsCommon.NO.equals(
			StringUtil.nullEmptyToValue(islamicCalculatorEventMgmtCO.getMusawamahYN(), ConstantsCommon.NO)))
		{
		    sysParam.setIS_VISIBLE(BigDecimal.ZERO);
		    getAdditionalScreenParams().put("musawamahDiv", sysParam);

		    sysParam = returnSysParamEnament("purchaseAmount");
		    sysParam.setIS_READONLY(BigDecimal.ZERO);
		    getAdditionalScreenParams().put("purchaseAmount", sysParam);

		    sysParam = returnSysParamEnament("financingAmount");
		    sysParam.setIS_READONLY(BigDecimal.ZERO);
		    getAdditionalScreenParams().put("financingAmount", sysParam);

		}
		else
		{
		    sysParam.setIS_VISIBLE(BigDecimal.ONE);
		    getAdditionalScreenParams().put("musawamahDiv", sysParam);

		    sysParam = returnSysParamEnament("purchaseAmount");
		    sysParam.setIS_READONLY(BigDecimal.ONE);
		    getAdditionalScreenParams().put("purchaseAmount", sysParam);

		    sysParam = returnSysParamEnament("financingAmount");
		    sysParam.setIS_READONLY(BigDecimal.ONE);
		    getAdditionalScreenParams().put("financingAmount", sysParam);

		}

	    }
	    // TP#247336;Arun.R.Variyath;10/12/2014 [End]
	    // BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
	    if(ConstantsCommon.YES.equals(StringUtil
		    .nullEmptyToValue(islamicCalculatorEventMgmtCO.getAllowFlexiPaymentsYN(), ConstantsCommon.NO)))
	    {
		sysParam = returnSysParamEnament("flexiPaymentYN_CheckBox");
		sysParam.setIS_READONLY(BigDecimal.ZERO);
		getAdditionalScreenParams().put("flexiPaymentYN_CheckBox", sysParam);

		sysParam = returnSysParamEnament("flexi_month");
		sysParam.setIS_READONLY(BigDecimal.ONE);
		getAdditionalScreenParams().put("flexi_month", sysParam);
	    }
	    else
	    {
		sysParam = returnSysParamEnament("flexiPaymentYN_CheckBox");
		sysParam.setIS_READONLY(BigDecimal.ONE);
		getAdditionalScreenParams().put("flexiPaymentYN_CheckBox", sysParam);

		sysParam = returnSysParamEnament("flexi_month");
		sysParam.setIS_READONLY(BigDecimal.ONE);
		getAdditionalScreenParams().put("flexi_month", sysParam);
	    }
	    // BB160136; Saheer.Naduthodi; 20/04/2017 [End]
	    // TP#681370 Mathew 03Jun18
	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		if(islamicCalculatorEventMgmtCO.getParamList() != null)
		{
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			    NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			    islamicCalculatorEventMgmtCO.getParamList(), sessionCO.getLanguage()));
		}
		else
		{
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			    NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			    islamicCalculatorEventMgmtCO.getParamList(), sessionCO.getLanguage()));
		}
	    }
	}
	catch(Exception e)
	{
	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);// APPLY
	    // DECIMAL
	    // FORMAT
	    // BASED ON
	    // CURRENCY
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeProductClass";
    }

    /***
     * Method for validating the criteria list
     * 
     * @return
     */
    public String validateRepayamentCriteriaList()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());

	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    // TP#221204;Arun.R.Variyath;18/09/2014 [Start]
	    if(strRepaymentCharges != null && StringUtil.isNotEmpty(strRepaymentCharges))
	    {
		GridUpdates gridData = getGridUpdates(strRepaymentCharges, TRSPAYPLAN_CRITERIAVO.class, true);// Repayment
		// Criteria
		List<TRSPAYPLAN_CRITERIAVO> repaymentList = gridData.getLstAllRec();
		for(TRSPAYPLAN_CRITERIAVO aTRSPAYPLAN_CRITERIAVO : repaymentList)
		{
		    if(aTRSPAYPLAN_CRITERIAVO.getPAYM_PERIODICITY().equals("Days"))
		    {
			aTRSPAYPLAN_CRITERIAVO.setPAYM_PERIODICITY("D");
		    }
		    // Months Quarterly Semi Annually Weeks
		    if(aTRSPAYPLAN_CRITERIAVO.getPAYMENT_TYPE().equals("Principal+Profit"))
		    {
			aTRSPAYPLAN_CRITERIAVO.setPAYMENT_TYPE("B");
		    }
		    // Principal+Profit
		}
		islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVO(repaymentList);
	    }
	    // TP#221204;Arun.R.Variyath;18/09/2014 [End]
	    islamicCalculatorEventMgmtCO = iisIslamicCalculatorBO
		    .validateRepayamentCriteriaList(islamicCalculatorEventMgmtCO);// validating
	    // re
	    // payment
	    // criteria
	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		if(islamicCalculatorEventMgmtCO.getParamList() != null)
		{
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			    NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			    islamicCalculatorEventMgmtCO.getParamList(), sessionCO.getLanguage()));
		}
		else
		{
		    islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			    NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			    islamicCalculatorEventMgmtCO.getParamList(), sessionCO.getLanguage()));
		}
	    }

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateRepayamentCriteriaList";
    }

    public String calculate()
    {
	SessionCO sessionCO = null;
	BigDecimal currencyCode = null;
	try
	{
	    // islamicCalculatorEventMgmtCO.setFirstPaymentDate(DateUtil.createDate(2013,
	    // 01, 10));
	    log.info("FirstPaymentDat edfsdf	    :	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    sessionCO = returnSessionObject();
	    log.info(strBalloonDetails);
	    log.info(strDealCharges);
	    log.info(strRepaymentCharges);
	    currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO.setTotalFlatRate(calculatorCO.getOutTotalFlatRate());
	    calculatorCO = new IslamicCalculatorCO();
	    calculatorCO.setCompanyCode(sessionCO.getCompanyCode());
	    calculatorCO.setBranchCode(sessionCO.getBranchCode());
	    calculatorCO.setProductClassCode(islamicCalculatorEventMgmtCO.getProductClass());
	    calculatorCO.setDealCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    calculatorCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
	    calculatorCO.setValueDate(islamicCalculatorEventMgmtCO.getStartDate());
	    calculatorCO.setMaturityDate(islamicCalculatorEventMgmtCO.getMaturityDate());
	    calculatorCO.setAnnualYeild(islamicCalculatorEventMgmtCO.getAnnualYieldRate());
	    calculatorCO.setProfitCalculationMethod(islamicCalculatorEventMgmtCO.getProfitCalcMethod());
	    calculatorCO.setProfitRecognitionMethod(islamicCalculatorEventMgmtCO.getProfitRecognitionMethod());
	    // calculatorCO.setCompudingDealPeriod(islamicCalculatorEventMgmtCO.getCompoundingDuringEntireDealPeriiod());
	    calculatorCO.setProfitAccrualBasis(
		    NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getAccrualBasis()).longValue());
	    calculatorCO.setTemplateCode(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTempCode()));
	    calculatorCO.setFirstPaymentDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    calculatorCO.setNoOfPayments(islamicCalculatorEventMgmtCO.getNoOfPayments());
	    calculatorCO.setPaymentPeriodicity(islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    calculatorCO.setPaymentPeriodicityNo(
		    NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getPaymPeriodNbr()).longValue());
	    calculatorCO.setPaymentPeriodicityMonthPos(islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    calculatorCO.setResidualValue(islamicCalculatorEventMgmtCO.getPayResAmt());
	    calculatorCO.setAmountPerPayment(islamicCalculatorEventMgmtCO.getAmountPerPayment());
	    calculatorCO.setRoundingFactor(
		    NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getRoundingFactor()).longValue());
	    calculatorCO.setTentativeSchedule(tentativeSchedule);
	    calculatorCO.setTotalFlatRate(islamicCalculatorEventMgmtCO.getTotalFlatRate());
	    calculatorCO.setProfitCollected(islamicCalculatorEventMgmtCO.getAdvancePayment());
	    calculatorCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    // 713888
	    calculatorCO.setHolidayAction(islamicCalculatorEventMgmtCO.getHolidayAction());
	    // calculatorCO.setIncludeVatInInstallment(islamicCalculatorEventMgmtCO.getIncludeVatinInstallment().equals(
	    // "true") ? "Y" : "N");
	    GridUpdates gridData;

	    // EWBI160081; Saheer.Naduthodi; 18/05/2017 [Begin]
	    if(settlementChargeGridData != null && !settlementChargeGridData.isEmpty())
	    {
		gridData = getGridUpdates(settlementChargeGridData, TrsDealSettlementChargesCO.class, true);
		calculatorCO.setTrsdealStlmntChargesList(gridData.getLstAllRec());
	    }
	    // EWBI160081; Saheer.Naduthodi; 18/05/2017 [End]
	    if(islamicCalculatorEventMgmtCO.getIncludeVatinInstallment() == null)
	    {
		calculatorCO.setIncludeVatInInstallment("N");
	    }
	    else
	    {
		calculatorCO.setIncludeVatInInstallment(islamicCalculatorEventMgmtCO.getIncludeVatinInstallment());
	    }

	    calculatorCO.setTotalBalloonAmount(islamicCalculatorEventMgmtCO.getBaloonAmount());
	    calculatorCO
		    .setVatCode(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getVatCode()).longValue());
	    calculatorCO.setVatPercentage(NumberUtil.toDoubleObj(islamicCalculatorEventMgmtCO.getVatPercentage()));
	    calculatorCO.setDownPaymentAmt(islamicCalculatorEventMgmtCO.getDownPaymentAmount());

	    // TP#167642; Ramesh; Date 04/08/2014
	    calculatorCO.setCalendarType(islamicCalculatorEventMgmtCO.getCalendarType());
	    // calculatorCO.setCompudingDealPeriod(islamicCalculatorEventMgmtCO.getDealPeriodCompounding());
	    // calculatorCO
	    // .setCompudingDealPeriod(islamicCalculatorEventMgmtCO.getDealPeriodCompounding().equals("true")
	    // ? "Y"
	    // : "N");

	    // TP#222666 ;Arun.R.Variyath;18/09/2014 [Start]
	    if(islamicCalculatorEventMgmtCO.getDealPeriodCompounding() == null)
	    {
		calculatorCO.setCompudingDealPeriod("N");
	    }
	    else
	    {
		calculatorCO.setCompudingDealPeriod(
			islamicCalculatorEventMgmtCO.getDealPeriodCompounding().equals("true") ? "Y" : "N");
	    }
	    // TP#222666 ;Arun.R.Variyath;18/09/2014 [End]

	    if(IISCommonConstants.ISLAMIC_CALCULATOR_AR_RAHANU.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    {
		calculatorCO.setArRahnuCalculatorYN("Y");
		calculatorCO.setTotalSafeBoxCharges(islamicCalculatorEventMgmtCO.getSafeboxchargeamt());
		calculatorCO.setSafeboxchargetype(islamicCalculatorEventMgmtCO.getSafeboxchargetype());
	    }
	    else
	    {
		calculatorCO.setArRahnuCalculatorYN("N");
	    }

	    if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    {
		calculatorCO.setBillsCalculatorYn("Y");
		calculatorCO.setTfaTrxType(islamicCalculatorEventMgmtCO.getTfaTrxType() == null ? "N"
			: islamicCalculatorEventMgmtCO.getTfaTrxType());
		calculatorCO.setTfaInwardOutwartTrsNo(
			NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getInWardOutWradTrsNo())
				? BigDecimal.ZERO
				: islamicCalculatorEventMgmtCO.getInWardOutWradTrsNo());

		calculatorCO.setTradeCurrency(islamicCalculatorEventMgmtCO.getTradingCurrency());
		calculatorCO
			.setInterest_calculation_method(islamicCalculatorEventMgmtCO.getInterestCalculationMethod());
		calculatorCO.setTotalBillAmount(islamicCalculatorEventMgmtCO.getTotalBillAmount());
		calculatorCO.setBillAmount(islamicCalculatorEventMgmtCO.getBillAmount());
		// calculatorCO.setTrsdealNIDCVO(trsdealNIDCVO);
		// calculatorCO.setTrsdealNIDCDETVO(trsdealNIDCDETVO);
		calculatorCO.setNidcDeal(islamicCalculatorEventMgmtCO.getNidc());

	    }
	    else
	    {
		calculatorCO.setBillsCalculatorYn("N");
	    }
	    // BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
	    calculatorCO.setFlexiPaymentYn(islamicCalculatorEventMgmtCO.getFlexiPaymentYn());
	    calculatorCO.setFlexiPaymentsMonth(islamicCalculatorEventMgmtCO.getFlexiPaymentsMonth());
	    // BB160136; Saheer.Naduthodi; 20/04/2017 [End]

	    // TP#221204;Arun.R.Variyath;18/09/2014 [Start]

	    if(strRepaymentCharges != null && StringUtil.isNotEmpty(strRepaymentCharges))
	    {

		gridData = getGridUpdates(strRepaymentCharges, TrspayplanCriteriaCO.class, true);// Repayment
		// Criteria
		// calculatorCO.setTrsPayPlanCriteriaVO((List<TRSPAYPLAN_CRITERIAVO>)gridData.getLstAllRec());
		// TODO Remove - start test
		List<TrspayplanCriteriaCO> testlist = gridData.getLstAllRec();
		for(TrspayplanCriteriaCO aTRSPAYPLAN_CRITERIAVO : testlist)
		{
		    if(aTRSPAYPLAN_CRITERIAVO.getPAYM_PERIODICITY().equals("Days"))
		    {
			aTRSPAYPLAN_CRITERIAVO.setPAYM_PERIODICITY("D");
		    }
		    // Months Quarterly Semi Annually Weeks
		    if(aTRSPAYPLAN_CRITERIAVO.getPAYMENT_TYPE().equals("Principal+Profit"))
		    {
			aTRSPAYPLAN_CRITERIAVO.setPAYMENT_TYPE("B");
		    }
		    // Principal+Profit
		}
		calculatorCO.setTrsPayPlanCriteriaVO(testlist);
	    }
	    // BB130272 Modification;Ravikant.Singh;19/05/2015
	    if(custGuarLiabilityListDet != null && !custGuarLiabilityListDet.isEmpty())
	    {
		gridData = getGridUpdates(custGuarLiabilityListDet, IslamicCalculatorCustGuarLiabilitiesListCO.class,
			true);
		islamicCalculatorEventMgmtCO.setCustGuarLiabilityList(gridData.getLstAllRec());
	    }

	    if(strNIDCList != null && !strNIDCList.isEmpty())
	    {
		gridData = getGridUpdates(strNIDCList, TRSDEAL_NIDC_DETVO.class, true);
		calculatorCO.setTrsdealNIDCDETVO(gridData.getLstAllRec());
		calculatorCO.setTrsdealNIDCVO(trsdealNidcCO.getTrsdealNIDCVO());

		if(strNIDCCouponPayment != null && !strNIDCCouponPayment.isEmpty())
		{
		    gridData = getGridUpdates(strNIDCCouponPayment, TRSDEAL_NIDC_COUPON_PYMNTVO.class, true);
		    calculatorCO.setTrsdealNIDC_COUPONPYMNTVOs(gridData.getLstAllRec());

		}
	    }

	    if("Y".equals(tentativeSchedule))
	    {
		if(strRepaymentCharges != null && StringUtil.isNotEmpty(strRepaymentCharges))
		{

		    gridData = getGridUpdates(strRepaymentCharges, TRSPAYPLAN_CRITERIAVO.class, true);// Repayment
		    // Criteria
		    // calculatorCO.setTrsPayPlanCriteriaVO((List<TRSPAYPLAN_CRITERIAVO>)gridData.getLstAllRec());
		    // TODO Remove - start test
		    List<TRSPAYPLAN_CRITERIAVO> testlist = gridData.getLstAllRec();
		    for(TRSPAYPLAN_CRITERIAVO trspayplanCriteriaVO : testlist)
		    {
			if(trspayplanCriteriaVO.getPAYM_PERIODICITY().equals("Days"))
			{
			    trspayplanCriteriaVO.setPAYM_PERIODICITY("D");
			}
			// Months Quarterly Semi Annually Weeks
			if(trspayplanCriteriaVO.getPAYMENT_TYPE().equals("Principal+Profit"))
			{
			    trspayplanCriteriaVO.setPAYMENT_TYPE("B");
			}
			// Principal+Profit
		    }
		    islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVO(testlist);
		}
	    }
	    if(islamicCalculatorEventMgmtCO.getConfirmMessagesArryList() != null
		    && !islamicCalculatorEventMgmtCO.getConfirmMessagesArryList().isEmpty())
	    {
		islamicCalculatorEventMgmtCO.setConfirmMessagesArryList(new ArrayList<String[]>());
	    }
	    // 677051 Fawas.Kuruvakkottil 21/05/2018-
	    // Moved from above validation
	    islamicCalculatorEventMgmtCO = iisIslamicCalculatorBO
		    .validateRepayamentCriteriaList(islamicCalculatorEventMgmtCO);
	    // TP#221204;Arun.R.Variyath;18/09/2014 [End]
	    // end test
	    gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
	    // Charges
	    calculatorCO.setTrsdealchargesVO(gridData.getLstAllRec());
	    // TP#221204;Arun.R.Variyath;18/09/2014 [Start]
	    if(strBalloonDetails != null && StringUtil.isNotEmpty(strBalloonDetails))
	    {
		gridData = getGridUpdates(strBalloonDetails, TrsPlanBallonPaymentCO.class, true);// Ballon
		// details
		calculatorCO.setTrsPlanBallonPaymentCO(gridData.getLstAllRec());
	    }

	    if(strMultipleYieldList != null && !strMultipleYieldList.isEmpty())
	    {
		List<TrsdealMultipleYieldCO> trsdealMultipleYieldCOList = new ArrayList<TrsdealMultipleYieldCO>();

		gridData = getGridUpdates(strMultipleYieldList, TrsdealMultipleYieldCO.class, true);
		trsdealMultipleYieldCOList = gridData.getLstAllRec();
		List<TRSDEAL_MULTIPLE_YIELDVO> trsdealMultipleYieldVOList = new ArrayList<TRSDEAL_MULTIPLE_YIELDVO>();

		for(TrsdealMultipleYieldCO trsdealMultipleYieldCO : trsdealMultipleYieldCOList)
		{
		    trsdealMultipleYieldVOList.add(trsdealMultipleYieldCO.getTrsdealMultipleYieldVO());
		}

		calculatorCO.setTrsDealMultipleYieldVO(trsdealMultipleYieldVOList);
	    }
	    // TP#221204;Arun.R.Variyath;18/09/2014 [End]
	    calculatorCO.getTrsdealchargesVO().forEach((u) -> u.setCOMP_CODE(calculatorCO.getCompanyCode()));
	    iisIslamicCalculatorBO.validateDealChargesList(calculatorCO.getTrsdealchargesVO());// validating
	    // deal
	    // charges
	    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 **/
	    if(IISCommonConstants.TOPUP.equals(StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getDealType()))
		    || IISCommonConstants.BUYOUT
			    .equals(StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getDealType())))
	    {
		if(StringUtil.isNotEmpty(islamicCalculatorEventMgmtCO.getTopUpGridData()))
		{
		    gridData = getGridUpdates(islamicCalculatorEventMgmtCO.getTopUpGridData(),
			    IslamicCalculatorEventMgmtCO.class, true);
		    islamicCalculatorEventMgmtCO.setTopUpGridList(gridData.getLstAllRec());
		}
		islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
		islamicCalculatorEventMgmtBO.validateDealType(islamicCalculatorEventMgmtCO);
	    }

	    // TP#244113; Ramesh; Date 09/12/2014 [START]
	    if(getTotalAllcBlnAmt() != null
		    && (NumberUtil.emptyDecimalToZero(getTotalAllcBlnAmt()).compareTo(BigDecimal.ZERO) > 0))
	    {

		calculatorCO.setTotalAllocatedAmount(getTotalAllcBlnAmt());
		calculatorCO.setTotalBalloonAmount(islamicCalculatorEventMgmtCO.getBaloonAmount());
		islamicCalculatorEventMgmtBO.validateBalloonAllocatedAmount(calculatorCO);
	    }
	    // TP#244113; Ramesh; Date 09/12/2014 [END]
	    if(projectFinanceDetails != null && !projectFinanceDetails.isEmpty())
	    {
		gridData = getGridUpdates(projectFinanceDetails, TRSDEAL3VO.class, true);// Ballon
		calculatorCO.setTrsDealMultipleDisbursementList(gridData.getLstAllRec());
	    }
	    calculatorCO.setCalledFromCalculator(true);
	    calculatorCO = iisIslamicCalculatorBO.createRepaymentPlan(calculatorCO);

	    islamicCalculatorEventMgmtCO.setAnnualFlatRate(calculatorCO.getOutAnnualFlatRate());
	    islamicCalculatorEventMgmtCO.setTotalFlatRate(calculatorCO.getOutTotalFlatRate());
	    islamicCalculatorEventMgmtCO.setXirr(calculatorCO.getXirrOut());
	    islamicCalculatorEventMgmtCO.setRemainingAmount(calculatorCO.getOutRemainingAmount());
	    islamicCalculatorEventMgmtCO.setProfit(calculatorCO.getOutProfitAmount());
	    islamicCalculatorEventMgmtCO.setAmountPerPayment(calculatorCO.getOutAmountPerPayment());
	    islamicCalculatorEventMgmtCO.setSaleAmount(calculatorCO.getOutSaleAmount());
	    if(calculatorCO.getConfirmationMessageId() != null)
	    {
		// islamicCalculatorEventMgmtCO.setConfirmMessageDetailId(islamicCalculatorEventMgmtCO.getConfirmationMessageId());
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(calculatorCO.getConfirmationMessageId()), sessionCO.getLanguage()));
	    }
	    if(calculatorCO.getConfirmationMessageId2() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmMessageDetailId("1");
		islamicCalculatorEventMgmtCO.setSecondConfirmId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(calculatorCO.getConfirmationMessageId2()), sessionCO.getLanguage()));
	    }

	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);

	}
	catch(Exception e)
	{
	    // Apply decimal format based on currency
	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);
	    handleException(e, null, null);
	}
	return "calculate";
    }

    /**
     * Method for on change event of Currency Code
     * 
     * @return
     */
    public String onChangeCurrencyCode()
    {
	SessionCO sessionCO = null;
	BigDecimal currencyCode = null;
	try
	{
	    sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTradingCurrency())
		    .compareTo(BigDecimal.ZERO) == 0)
	    {
		islamicCalculatorEventMgmtCO.setTradingCurrency(sessionCO.getBaseCurrencyCode());
	    }
	    currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    log.info("onChangeCurrencyCode");
	    islamicCalculatorEventMgmtCO.setSalaryWithBank("N");
	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)JSONArray.toCollection(JSONArray.fromObject(strDealCharges),
	    // TrsDealChargesCO.class));
	    // islamicCalculatorEventMgmtCO.getTrsdealnidcvo()
	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    {

		if(StringUtil.isNotEmpty(strNIDCDetail))
		{
		    GridUpdates gridData = getGridUpdates(strNIDCDetail, TRSDEAL_NIDCVO.class, true);// Deal
		    islamicCalculatorEventMgmtCO.setTrsdealNIDCDETVOList(gridData.getLstAllRec());
		}

		if(StringUtil.isNotEmpty(strNIDCCouponPayment))
		{
		    GridUpdates gridData = getGridUpdates(strNIDCCouponPayment, TRSDEAL_NIDC_COUPON_PYMNTVO.class,
			    true);// Deal
		    islamicCalculatorEventMgmtCO.setTrsdealNIDCCoupPaymtVOList(gridData.getLstAllRec());
		}

	    }
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeCurrencyCode(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }
	    islamicCalculatorEventMgmtCO.setYield(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield()));
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											   // DECIMAL
											   // FORMAT
											   // BASED
											   // ON
	    // CURRENCY
	    log.info("output financing amount		:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("output downpayment amount	:	" + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("output yield 				:	" + islamicCalculatorEventMgmtCO.getYield());
	    log.info("output dealcharges grid 	:	" + islamicCalculatorEventMgmtCO.getTrsDealChargesVO().size());
	}
	catch(Exception e)
	{
	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);// APPLY
	    // DECIMAL
	    // FORMAT
	    // BASED ON
	    // CURRENCY
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeCurrencyCode";
    }

    // BB160136; Saheer.Naduthodi; 20/04/2017
    public String onChangeFlexiPaymentCheckBox()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeFlexiPaymentCheckBox(islamicCalculatorEventMgmtCO);

	    getAdditionalScreenParams().putAll(islamicCalculatorEventMgmtCO.getHmSysParam());
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Method for on change event of Purchase Amount
     * 
     * @return
     */
    public String onChangePurchaseAmount()
    {
	SessionCO sessionCO = null;
	try
	{
	    sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    log.info("onChangePurchaseAmount");

	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)JSONArray.toCollection(JSONArray.fromObject(strDealCharges),
	    // TrsDealChargesCO.class));
	    // Added deal charges as param - based on issue 0092514
	    if(StringUtil.isNotEmpty(strDealCharges))
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }
	    islamicCalculatorEventMgmtCO.setSalaryWithBank("N");
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("compCode	          :	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	          :	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("productClass	      :	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("cifNo	              :	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("maturityDate	      :	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("ValueDate	          :	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("NoOfpayments	      :	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodNbr		  :	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity		  :	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos		  :	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("GracePeriod 	 	  :	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity	  :	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("puchaseAmount		  :	" + islamicCalculatorEventMgmtCO.getPurchaseAmount());
	    log.info("salaryWithBank		  :	" + islamicCalculatorEventMgmtCO.getSalaryWithBank());
	    log.info("currency		 	  :	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("finaicngAmount		  :	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("downpaymentAmount	  :	" + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("downpaymentpercentage :	" + islamicCalculatorEventMgmtCO.getDownPaymentPercentage());
	    log.info("Yield	 			  :	" + islamicCalculatorEventMgmtCO.getAnnualYieldRate());

	    // BB150217 - Rescheduling and Loan Buyout CR105585
	    if(IISCommonConstants.TOPUP.equals(islamicCalculatorEventMgmtCO.getDealType())
		    && StringUtil.isNotEmpty(islamicCalculatorEventMgmtCO.getTopUpGridData()))
	    {
		GridUpdates gridData = getGridUpdates(islamicCalculatorEventMgmtCO.getTopUpGridData(),
			IslamicCalculatorEventMgmtCO.class, true);
		islamicCalculatorEventMgmtCO.setTopUpGridList(gridData.getLstAllRec());
	    }

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangePurchaseAmount(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }

	    // TODO - Linchu should do it from server side
	    islamicCalculatorEventMgmtCO.setYield(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield()));

	    // Taking the Decimal Format based on the chosen currency and
	    // sending to client...
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    islamicCalculatorEventMgmtCO.getCurrencyCode() == null ? sessionCO.getBaseCurrencyCode()
			    : islamicCalculatorEventMgmtCO.getCurrencyCode());//
	    log.info("===================================================================================");
	    log.info("output financing amount		:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("output downpayment amount	:	" + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("output yield 				:	" + islamicCalculatorEventMgmtCO.getYield());

	    log.info("===================================================================================");
	}
	catch(BOException ex)
	{
	    String msgIdent;
	    msgIdent = (ex).getMsgIdent();
	    if(msgIdent != null)
	    {
		setConfirmType(msgIdent);
	    }
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(ex, null, null);
	}
	catch(Exception e)
	{
	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);
	    handleException(e, null, null);
	}
	return "onChangePurchaseAmount";
    }

    /**
     * Method for on change event of Payment Percentage
     * 
     * @return
     */
    public String onChangeDownPaymentPercentage()
    {
	SessionCO sessionCO = null;
	BigDecimal currencyCode = null;
	try
	{
	    sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());

	    log.info("onChangeDownPaymentPercentage");
	    islamicCalculatorEventMgmtCO.setSalaryWithBank("N");
	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)JSONArray.toCollection(JSONArray.fromObject(strDealCharges),
	    // TrsDealChargesCO.class));

	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("productClass	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("cifNo	:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("maturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("ValueDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("NoOfpayments	:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodNbr	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity	:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("puchaseAmount	:	" + islamicCalculatorEventMgmtCO.getPurchaseAmount());
	    log.info("salaryWithBank	:	" + islamicCalculatorEventMgmtCO.getSalaryWithBank());
	    log.info("currency	:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("downpayment percentage	:	" + islamicCalculatorEventMgmtCO.getDownPaymentPercentage());
	    log.info("financing amount	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    // log.info("dealcharges grid :
	    // "+islamicCalculatorEventMgmtCO.getTrsDealChargesVO().size());
	    // BB150217 - Rescheduling and Loan Buyout CR105585
	    if(IISCommonConstants.TOPUP.equals(islamicCalculatorEventMgmtCO.getDealType())
		    && StringUtil.isNotEmpty(islamicCalculatorEventMgmtCO.getTopUpGridData()))
	    {
		GridUpdates gridData = getGridUpdates(islamicCalculatorEventMgmtCO.getTopUpGridData(),
			IslamicCalculatorEventMgmtCO.class, true);
		islamicCalculatorEventMgmtCO.setTopUpGridList(gridData.getLstAllRec());
	    }

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeDownPaymentPercentage(islamicCalculatorEventMgmtCO);
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											   // DECIMAL
											   // FORMAT
											   // BASED
											   // ON
	    // CURRENCY
	    // TODO - Linchu should do it from server side
	    islamicCalculatorEventMgmtCO.setYield(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield()));

	    log.info("output financing amount		:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("output downpayment amount	:	" + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("output yield 				:	" + islamicCalculatorEventMgmtCO.getYield());
	    log.info("output dealcharges grid 	:	" + islamicCalculatorEventMgmtCO.getTrsDealChargesVO().size());

	}
	catch(Exception e)
	{
	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);// APPLY
	    // DECIMAL
	    // FORMAT
	    // BASED ON
	    // CURRENCY
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeDownPaymentPercentage";
    }

    /**
     * Method for down payment amount on change event of Down Payment
     * 
     * @return
     */
    public String onChangeDownPayment()
    {
	SessionCO sessionCO = null;
	BigDecimal currencyCode = null;
	try
	{
	    sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());

	    log.info("onChangeDownPayment");

	    islamicCalculatorEventMgmtCO.setSalaryWithBank("N");
	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)JSONArray.toCollection(JSONArray.fromObject(strDealCharges),
	    // TrsDealChargesCO.class));

	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }

	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    log.info("compCode	:	" + sessionCO.getCompanyCode());
	    log.info("BranchCode	:	" + sessionCO.getBranchCode());
	    log.info("productClass	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("cifNo	:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("maturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("ValueDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("NoOfpayments	:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodNbr	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity	:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("puchaseAmount	:	" + islamicCalculatorEventMgmtCO.getPurchaseAmount());
	    log.info("salaryWithBank	:	" + islamicCalculatorEventMgmtCO.getSalaryWithBank());
	    log.info("financing amount	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("downpayment amount	:	" + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("downpaymentpercentage		  :	"
		    + islamicCalculatorEventMgmtCO.getDownPaymentPercentage());
	    log.info("===================================================================================");

	    // BB150217 - Rescheduling and Loan Buyout CR105585
	    if(IISCommonConstants.TOPUP.equals(islamicCalculatorEventMgmtCO.getDealType())
		    && StringUtil.isNotEmpty(islamicCalculatorEventMgmtCO.getTopUpGridData()))
	    {
		GridUpdates gridData = getGridUpdates(islamicCalculatorEventMgmtCO.getTopUpGridData(),
			IslamicCalculatorEventMgmtCO.class, true);
		islamicCalculatorEventMgmtCO.setTopUpGridList(gridData.getLstAllRec());
	    }

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeDownPayment(islamicCalculatorEventMgmtCO);
	    // TODO - Linchu should do it from server side
	    islamicCalculatorEventMgmtCO.setYield(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield()));
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											   // DECIMAL
											   // FORMAT
											   // BASED
											   // ON
	    // CURRENCY

	    log.info("output financing amount		:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("output downpayment percentage	:	"
		    + islamicCalculatorEventMgmtCO.getDownPaymentPercentage());
	    log.info("output yield 				:	" + islamicCalculatorEventMgmtCO.getYield());
	    log.info("PurchaseAmount 				:	"
		    + islamicCalculatorEventMgmtCO.getPurchaseAmount());
	    log.info("output dealcharges grid 	:	" + islamicCalculatorEventMgmtCO.getTrsDealChargesVO().size());
	    log.info("===================================================================================");

	}
	catch(Exception e)
	{
	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);// APPLY
	    // DECIMAL
	    // FORMAT
	    // BASED ON
	    // CURRENCY
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeDownPayment";
    }

    /**
     * Method for down payment amount on change event of Financing Amount
     * 
     * @return
     */
    public String onChangeFinancingAmount()
    {
	SessionCO sessionCO = null;
	BigDecimal currencyCode = null;
	try
	{
	    sessionCO = returnSessionObject();

	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO.setCurrencyDecimalPoints(sessionCO.getBaseCurrDecPoint());

	    islamicCalculatorEventMgmtCO.setSalaryWithBank("N");
	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)JSONArray.toCollection(JSONArray.fromObject(strDealCharges),
	    // TrsDealChargesCO.class));

	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }

	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();

	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("productClass	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("cifNo	:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("maturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("ValueDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("NoOfpayments	:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodNbr	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity	:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("puchaseAmount	:	" + islamicCalculatorEventMgmtCO.getPurchaseAmount());
	    log.info("financing amount	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("downpayment amount	:	" + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("downpayment percentage	:	" + islamicCalculatorEventMgmtCO.getDownPaymentPercentage());
	    log.info("salaryWithBank	:	" + islamicCalculatorEventMgmtCO.getSalaryWithBank());
	    log.info("DealChargesVO	:	" + islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    log.info("downpaymentAmount		  :	" + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("===================================================================================");

	    // BB130272 Modification;Ravikant.Singh;19/05/2015
	    if(custGuarLiabilityListDet != null && !custGuarLiabilityListDet.isEmpty())
	    {
		GridUpdates gridData = getGridUpdates(custGuarLiabilityListDet,
			IslamicCalculatorCustGuarLiabilitiesListCO.class, true);
		islamicCalculatorEventMgmtCO.setCustGuarLiabilityList(gridData.getLstAllRec());
	    }
	    // BB150217 - Rescheduling and Loan Buyout CR105585
	    if(IISCommonConstants.TOPUP.equals(islamicCalculatorEventMgmtCO.getDealType())
		    && StringUtil.isNotEmpty(islamicCalculatorEventMgmtCO.getTopUpGridData()))
	    {
		GridUpdates gridData = getGridUpdates(islamicCalculatorEventMgmtCO.getTopUpGridData(),
			IslamicCalculatorEventMgmtCO.class, true);
		islamicCalculatorEventMgmtCO.setTopUpGridList(gridData.getLstAllRec());
	    }

	    islamicCalculatorEventMgmtCO.setBaseCurrencyDesc(sessionCO.getBaseCurrencyName());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeFinancingAmount(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }
	    // TODO - Linchu should do it from server side
	    islamicCalculatorEventMgmtCO.setYield(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield()));
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											   // DECIMAL
											   // FORMAT
											   // BASED
											   // ON
	    // CURRENCY

	    log.info("output yield 				:	" + islamicCalculatorEventMgmtCO.getYield());
	    log.info("output downpayment amount	:	" + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("PurchaseAmount 				:	"
		    + islamicCalculatorEventMgmtCO.getPurchaseAmount());
	    log.info("===================================================================================");
	}
	catch(BOException ex)
	{
	    String msgIdent;
	    msgIdent = (ex).getMsgIdent();
	    if(msgIdent != null)
	    {
		setConfirmType(msgIdent);
	    }
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(ex, null, null);
	}
	catch(Exception e)
	{

	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);// APPLY
	    // DECIMAL
	    // FORMAT
	    // BASED ON
	    // CURRENCY
	    handleException(e, null, null);
	}
	return "onChangeFinancingAmount";
    }

    public String validateOnChangeStartDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("	METHOD NAME ==========validateOnChangeStartDate================	");
	    log.info("************************************INPUT*********START****************");

	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("Branch 	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("StartDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("ProductClass:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("Currency Code:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());

	    log.info("************************************End*************************");

	    // BB150217 - Rescheduling and Loan Buyout CR105585
	    if(IISCommonConstants.TOPUP.equals(islamicCalculatorEventMgmtCO.getDealType())
		    && StringUtil.isNotEmpty(islamicCalculatorEventMgmtCO.getTopUpGridData()))
	    {
		GridUpdates gridData = getGridUpdates(islamicCalculatorEventMgmtCO.getTopUpGridData(),
			IslamicCalculatorEventMgmtCO.class, true);
		islamicCalculatorEventMgmtCO.setTopUpGridList(gridData.getLstAllRec());
	    }

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .validateOnChangeStartDate(islamicCalculatorEventMgmtCO);

	    // Setting the revised start date after holiday to the session if
	    // the start date selected by user is holiday.
	    if(islamicCalculatorEventMgmtCO.getStartDateAfterHoliday() != null)
	    {
		session.put("islamicCalcEvtMgmtCOStartDateAfterHoliday",
			islamicCalculatorEventMgmtCO.getStartDateAfterHoliday());
	    }
	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO
			.setConfirmationMessageId(returnCommonLibBO().returnTranslMessageOnly(901897,
				new String[] { getText("Start_date_key"),
					DateUtil.format(islamicCalculatorEventMgmtCO.getStartDate(), "dd/MM/YYYY"),
					DateUtil.format(islamicCalculatorEventMgmtCO.getStartDateAfterHoliday(),
						"dd/MM/YYYY") },
				sessionCO.getLanguage()));
	    }
	    log.info("************************************Out Put ******Start*******************");

	    log.info("StartDateAfterHoliday	:	" + islamicCalculatorEventMgmtCO.getStartDateAfterHoliday());
	    log.info("Check Default Maturity Date 	:	"
		    + islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate());

	    log.info("************************************Out Put ******End*******************");

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateOnChangeStartDate";
    }

    /**
     * Method for handling the change event for the start date
     * 
     * @return
     */
    public String validateOnChangeStartDateOnMaturityDate()
    {
	try
	{

	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("SSESSSSIIIIION	:	" + session.get("islamicCalcEvtMgmtCOStartDateAfterHoliday"));
	    // if the user pressed yes for applying the new start date after
	    // holiday then take the
	    // new start date from session and setting it to the current object
	    if(islamicCalculatorEventMgmtCO.getConfirmationResult())
	    {
		Date startDateAfterHoliday = (Date) session.get("islamicCalcEvtMgmtCOStartDateAfterHoliday");
		if(startDateAfterHoliday != null)
		{
		    islamicCalculatorEventMgmtCO
			    .setStartDate((Date) session.get("islamicCalcEvtMgmtCOStartDateAfterHoliday"));
		}
	    }
	    session.remove("islamicCalcEvtMgmtCOStartDateAfterHoliday");

	    log.info("	METHOD NAME ==========validateOnChangeStartDateOnMaturityDate================	");
	    log.info("************************************INPUT*********START****************");

	    log.info("onChangeStartDate	--------------:");
	    log.info("SSESSSSIIIIION	:	" + session.get("islamicCalcEvtMgmtCOStartDateAfterHoliday"));

	    log.info("Start DAte fter Ho;iday		:	"
		    + islamicCalculatorEventMgmtCO.getStartDateAfterHoliday());
	    log.info("Conf Result					:	"
		    + islamicCalculatorEventMgmtCO.getConfirmationResult());
	    log.info("NoOfpayments				:	"
		    + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodNbr				:	"
		    + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity				:	"
		    + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos				:	"
		    + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("Stat Date 					:	"
		    + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("cifNo						:	"
		    + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("compCode					:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode					:	"
		    + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("productClass				:	"
		    + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("Financing Amount			:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("Currency					:	"
		    + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("CheckDefaultMaturityDate	:	" + islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate());
	    log.info("MaturityDate				:	"
		    + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("DefaultMaturityDate			:	"
		    + islamicCalculatorEventMgmtCO.getDefaultMaturityDate());
	    log.info("************************************End*************************");
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeStartDate(islamicCalculatorEventMgmtCO);

	    // Setting the calculated maturity date to the session
	    if(islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	    {
		session.put("islamicCalcEvtMgmtCOMaturityDate", islamicCalculatorEventMgmtCO.getMaturityDate());
	    }

	    // Setting the latest start date to the session
	    if(islamicCalculatorEventMgmtCO.getStartDate() != null)
	    {
		session.put("islamicCalcEvtMgmtCOStartDate", islamicCalculatorEventMgmtCO.getStartDate());
	    }

	    if(islamicCalculatorEventMgmtCO.getFirstPaymentDate() != null)
	    {
		session.put("islamicCalcEvtMgmtCOFirstPaymentDate", islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    }

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }
	    log.info("************************************Out Put ******Start*******************");

	    log.info("Output MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Output MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());

	    log.info("************************************Out Put ******End*******************");
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    session.remove("islamicCalcEvtMgmtCOStartDateAfterHoliday");
	    session.remove("islamicCalcEvtMgmtCOFirstPaymentDate");
	    handleException(e, null, null);
	}
	return "validateOnChangeStartDateOnMaturityDate";
    }

    /**
     * Method for handling the change event for the start date
     * 
     * @return
     */
    public String checkMaturityDateIsHoliday()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    log.info("checkMaturityDateIsHoliday	:");
	    // Setting the calculated maturity,start date from session to the
	    // current object
	    if(strConfirm == null || "".equals(strConfirm))
	    {
		Date maturityDate = (Date) session.get("islamicCalcEvtMgmtCOMaturityDate");
		Date startDate = (Date) session.get("islamicCalcEvtMgmtCOStartDate");
		if(maturityDate != null && startDate != null)
		{
		    islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
		    islamicCalculatorEventMgmtCO.setStartDate(startDate);
		}
	    }
	    else if(strConfirm.equals(ConstantsCommon.YES))
	    {
		Date maturityDate = (Date) session.get("islamicCalcEvtMgmtCOMaturityDate");
		Date startDate = (Date) session.get("islamicCalcEvtMgmtCOStartDate");
		if(maturityDate != null && startDate != null)
		{
		    islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
		    islamicCalculatorEventMgmtCO.setStartDate(startDate);
		}
	    }
	    else
	    {
		islamicCalculatorEventMgmtCO.setMaturityDate(islamicCalculatorEventMgmtCO.getDefaultMaturityDate());
		Date startDate = (Date) session.get("islamicCalcEvtMgmtCOStartDate");
		if(startDate != null)
		{
		    islamicCalculatorEventMgmtCO.setStartDate(startDate);
		}
	    }
	    // Setting the calculated maturity,start date from session to the
	    // current object

	    // if(islamicCalculatorEventMgmtCO.getConfirmationResult()){
	    // Date maturityDate = (Date)
	    // session.get("islamicCalcEvtMgmtCOMaturityDate");
	    // Date startDate = (Date)
	    // session.get("islamicCalcEvtMgmtCOStartDate");
	    // if(maturityDate!=null && startDate != null){
	    // islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
	    // islamicCalculatorEventMgmtCO.setStartDate(startDate);
	    // }
	    // }
	    // else{
	    // islamicCalculatorEventMgmtCO.setMaturityDate(islamicCalculatorEventMgmtCO.getDefaultMaturityDate());
	    // Date startDate = (Date)
	    // session.get("islamicCalcEvtMgmtCOStartDate");
	    // if(startDate != null){
	    // islamicCalculatorEventMgmtCO.setStartDate(startDate);
	    // }
	    // }
	    session.remove("islamicCalcEvtMgmtCOMaturityDate");
	    session.remove("islamicCalcEvtMgmtCOStartDate");
	    log.info("	METHOD NAME ==========checkMaturityDateIsHoliday================	");
	    log.info("************************************INPUT*********START****************");

	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("productClass	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("cifNo	:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("Stat Date 	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("DownPayment amount	:	" + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("Currency:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("************************************End*************************");
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .checkMaturityDateIsHoliday(islamicCalculatorEventMgmtCO);

	    // Setting the calculated maturity date to the session
	    if(islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	    {
		session.put("islamicCalcEvtMgmtCOMaturityDate", islamicCalculatorEventMgmtCO.getMaturityDate());
	    }

	    // Setting the latest start date to the session
	    if(islamicCalculatorEventMgmtCO.getStartDate() != null)
	    {
		session.put("islamicCalcEvtMgmtCOStartDate", islamicCalculatorEventMgmtCO.getStartDate());
	    }

	    // Setting the latest maturity date after holiday to the session
	    if(islamicCalculatorEventMgmtCO.getStartDate() != null)
	    {
		session.put("islamicCalcEvtMgmtCOMaturityDateAfterHoliday",
			islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	    }

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO
			.setConfirmationMessageId(returnCommonLibBO().returnTranslMessageOnly(901897,
				new String[] { getText("Maturity_Date_key"),
					DateUtil.format(islamicCalculatorEventMgmtCO.getMaturityDate(), "dd/MM/YYYY"),
					DateUtil.format(islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday(),
						"dd/MM/YYYY") },
				sessionCO.getLanguage()));
	    }
	    log.info("************************************Out Put ******Start*******************");
	    log.info("Output MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Maturity Date After Holiday	:	"
		    + islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	    log.info("************************************Out Put ******End*******************");
	}
	catch(Exception e)
	{
	    session.remove("islamicCalcEvtMgmtCOMaturityDate");
	    session.remove("islamicCalcEvtMgmtCOStartDate");
	    session.remove("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "checkMaturityDateIsHoliday";
    }

    /**
     * Method for handling the change event for the start date
     * 
     * @return
     */
    public String setOnChangeStartDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    // NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    log.info("setOnChangeStartDate	:");
	    // Setting the calculated maturity,start date from session to the
	    // current object
	    if(islamicCalculatorEventMgmtCO.getConfirmationResult())
	    {
		Date maturityDateAfterHoliday = (Date) session.get("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");
		Date startDate = (Date) session.get("islamicCalcEvtMgmtCOStartDate");
		if(maturityDateAfterHoliday != null && startDate != null)
		{
		    islamicCalculatorEventMgmtCO.setMaturityDate(maturityDateAfterHoliday);
		    islamicCalculatorEventMgmtCO.setStartDate(startDate);
		}
	    }
	    else
	    {
		Date maturityDate = (Date) session.get("islamicCalcEvtMgmtCOMaturityDate");
		Date startDate = (Date) session.get("islamicCalcEvtMgmtCOStartDate");
		if(startDate != null && maturityDate != null)
		{
		    islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
		    islamicCalculatorEventMgmtCO.setStartDate(startDate);
		}
	    }
	    if(session.get("islamicCalcEvtMgmtCOFirstPaymentDate") != null)
	    {
		islamicCalculatorEventMgmtCO
			.setFirstPaymentDate((Date) session.get("islamicCalcEvtMgmtCOFirstPaymentDate"));
	    }

	    session.remove("islamicCalcEvtMgmtCOMaturityDate");
	    session.remove("islamicCalcEvtMgmtCOStartDate");
	    session.remove("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");
	    session.remove("islamicCalcEvtMgmtCOFirstPaymentDate");

	    log.info("	METHOD NAME ==========setOnChangeStartDate================	");
	    log.info("************************************INPUT*********START****************");
	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)JSONArray.toCollection(JSONArray.fromObject(strDealCharges),
	    // TrsDealChargesCO.class));

	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }

	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    log.info("Confirmation Result	:	" + islamicCalculatorEventMgmtCO.getConfirmationResult());
	    log.info("MaturityDateAfterHoliday	:	" + islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	    log.info("cifNo	:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("productClass	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("ValueDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("downpayment amount	:	" + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("Vatcode	:	" + islamicCalculatorEventMgmtCO.getVatCode());
	    log.info("Currency:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("Financing Amount:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("************************************End*************************");
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .setOnChangeStartDate(islamicCalculatorEventMgmtCO);

	    log.info("************************************Out Put ******Start*******************");
	    log.info("Output MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Output DBR	:	" + islamicCalculatorEventMgmtCO.getDebtBurdanRatio());
	    log.info("Output DealChargesVO	:	" + islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    log.info("Output VatPercentage	:	" + islamicCalculatorEventMgmtCO.getVatPercentage());
	    log.info("Output Firstpayment date	:	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    log.info("Output Yield	:	" + islamicCalculatorEventMgmtCO.getYield());
	    log.info("************************************Out Put ******End*******************");
	}
	catch(Exception e)
	{
	    session.remove("islamicCalcEvtMgmtCOMaturityDate");
	    session.remove("islamicCalcEvtMgmtCOStartDate");
	    session.remove("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");
	    session.remove("islamicCalcEvtMgmtCOFirstPaymentDate");
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "setOnChangeStartDate";
    }

    public String validateOnChangeMaturityDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .validateOnChangeMaturityDate(islamicCalculatorEventMgmtCO);

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }

	}

	catch(BOException ex)
	{
	    String msgIdent;
	    msgIdent = (ex).getMsgIdent();
	    if(msgIdent != null)
	    {
		setConfirmType(msgIdent);
	    }
	    handleException(ex, null, null);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}

	return "validateOnChangeMaturityDate";
    }

    /**
     * Method for handling the change event for the Maturity date
     * 
     * @return
     */
    public String onChangeMaturityDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("	METHOD NAME ==========onChangeMaturityDate================	");
	    log.info("************************************INPUT*********START****************");

	    log.info("compCode		:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode		:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("NoOfpayments	:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodNbr	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("StartDate		:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("cifNo			:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("productClass	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("FinanicngAmount	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("Currency		:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());

	    log.info(
		    "************************************INPUT*********END*******************************************");

	    log.info(
		    "************************************OUTPUT*********START*******************************************");

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeMaturityDate(islamicCalculatorEventMgmtCO);

	    // Setting the calculated maturity date to the session
	    if(islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	    {
		session.put("islamicCalcEvtMgmtCOMaturityDate", islamicCalculatorEventMgmtCO.getMaturityDate());
	    }

	    // Setting the calculated MaturityDateAfterHoliday to the session
	    if(islamicCalculatorEventMgmtCO.getStartDate() != null)
	    {
		session.put("islamicCalcEvtMgmtCOMaturityDateAfterHoliday",
			islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	    }

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO
			.setConfirmationMessageId(returnCommonLibBO().returnTranslMessageOnly(901897,
				new String[] { getText("Maturity_Date_key"),
					DateUtil.format(islamicCalculatorEventMgmtCO.getMaturityDate(), "dd/MM/YYYY"),
					DateUtil.format(islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday(),
						"dd/MM/YYYY") },
				sessionCO.getLanguage()));
	    }
	    log.info("Output MaturityDate					:	"
		    + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Output MaturityDate after Holiday	:	"
		    + islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	    log.info("OP ConfirmMessageId					:	"
		    + islamicCalculatorEventMgmtCO.getConfirmationMessageId());
	    log.info(
		    "************************************OUTPUT*********END*******************************************");

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    session.remove("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");
	    session.remove("islamicCalcEvtMgmtCOMaturityDate");
	    handleException(e, null, null);
	}
	return "onChangeMaturityDate";
    }

    /**
     * Method for handling the change event for the Maturity date
     * 
     * @return
     */
    public String setOnChangeMaturityDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    // GridUpdates gridData = getGridUpdates(strDealCharges,
	    // TrsDealChargesCO.class,true);//Deal Charges
	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)gridData.getLstAllRec());

	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }

	    islamicCalculatorEventMgmtCO.setMaturityDate((Date) session.get("islamicCalcEvtMgmtCOMaturityDate"));
	    islamicCalculatorEventMgmtCO
		    .setMaturityDateAfterHoliday((Date) session.get("islamicCalcEvtMgmtCOMaturityDateAfterHoliday"));

	    session.remove("islamicCalcEvtMgmtCOMaturityDate");
	    session.remove("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");

	    log.info("	METHOD NAME ==========setOnChangeMaturityDate================	");
	    log.info("************************************INPUT*********START****************");

	    log.info("compCode						:	"
		    + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode						:	"
		    + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("downpayment amount				:	"
		    + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("MaturityDate					:	"
		    + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Start Date						:	"
		    + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("PaymPeriodicity					:	"
		    + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodNbr					:	"
		    + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodPos					:	"
		    + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("Financing amount/DealAmount		:	"
		    + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("Financing amount/DealAmount		:	"
		    + islamicCalculatorEventMgmtCO.getDealAmount());
	    log.info("Currency						:	"
		    + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("productClass					:	"
		    + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("cifNo							:	"
		    + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("MaturityDate after Holiday		:	"
		    + islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	    log.info("Firstpayment date				:	"
		    + islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    log.info("Base Currency Code				:	"
		    + islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    log.info("ConfirmResult					:	"
		    + islamicCalculatorEventMgmtCO.getConfirmationResult());

	    log.info(
		    "************************************INPUT*********END*******************************************");

	    log.info(
		    "************************************OUTPUT*********START*******************************************");

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .setOnChangeMaturityDate(islamicCalculatorEventMgmtCO);

	    log.info("Output NoOfPayments				:	"
		    + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("Output DealChargesVO			:	"
		    + islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    log.info("OutPut MaturityDate				:	"
		    + islamicCalculatorEventMgmtCO.getMaturityDate());

	    log.info(
		    "************************************OUTPUT*********END*******************************************");

	}
	catch(Exception e)
	{
	    session.remove("islamicCalcEvtMgmtCOMaturityDate");
	    session.remove("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "setOnChangeMaturityDate";
    }

    /**
     * Method for handling the change event for the FirstPayDate
     * 
     * @return
     */

    public String validateOnChangeFirstPayDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("	METHOD NAME ==========validateOnChangeFirstPayDate================	");
	    log.info("************************************INPUT*********START****************");

	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("StartDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("ProductClass:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("ClassCode:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("Firstpayment date	:	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    log.info("CheckDefaultMaturityDate	:	" + islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate());

	    log.info(
		    "************************************INPUT*********END*******************************************");
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .validateOnChangeFirstPayDate(islamicCalculatorEventMgmtCO);
	    session.put("islamicCalcEvtMgmtCGracePeriod", islamicCalculatorEventMgmtCO.getGracePeriod());
	    session.put("islamicCalcEvtMgmtCOGracePeriodicity", islamicCalculatorEventMgmtCO.getGracePeriodicity());

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }

	    log.info(
		    "************************************OUTPUT*********START*******************************************");

	    log.info("OP CheckDefaultMaturityDate	:	"
		    + islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate());
	    log.info("Conf Msg	:	" + islamicCalculatorEventMgmtCO.getConfirmationMessageId());

	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity	:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info(
		    "************************************OUTPUT*********END*******************************************");
	}
	catch(Exception e)
	{
	    session.remove("islamicCalcEvtMgmtCGracePeriod");
	    session.remove("islamicCalcEvtMgmtCOGracePeriodicity");
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateOnChangeFirstPayDate";
    }

    /**
     * Method for handling the change event for the FirstPayDate
     * 
     * @return
     */
    public String onChangeFirstPayDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("	METHOD NAME ==========onChangeFirstPayDate================	");
	    log.info("************************************INPUT*********START****************");
	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("NoOfpayments	:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodNbr	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("ValueDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("cifNo	:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("productClass	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("Financing Amount  :	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("Currency:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("DealAmount:	" + islamicCalculatorEventMgmtCO.getDealAmount());
	    log.info("Maturity DAte:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("downpayment amount				:	"
		    + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("Firstpayment date	:	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    log.info(
		    "************************************INPUT*********END*******************************************");

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeFirstPayDate(islamicCalculatorEventMgmtCO);

	    session.put("islamicCalcEvtMgmtCOMaturityDate", islamicCalculatorEventMgmtCO.getMaturityDate());
	    session.put("islamicCalcEvtMgmtCOMaturityDateAfterHoliday",
		    islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());

	    log.info(
		    "************************************OUTPUT*********START*******************************************");

	    log.info("Output MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Output MaturityDate After Holiday	:	"
		    + islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	    log.info("Confirm message ID	:	" + islamicCalculatorEventMgmtCO.getConfirmationMessageId());
	    log.info(
		    "************************************OUTPUT*********END*******************************************");
	    // 679649
	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }

	}
	catch(Exception e)
	{
	    session.remove("islamicCalcEvtMgmtCOMaturityDate");
	    session.remove("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");
	    session.remove("islamicCalcEvtMgmtCGracePeriod");
	    session.remove("islamicCalcEvtMgmtCOGracePeriodicity");
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeFirstPayDate";
    }

    public String calculateDealChargesOnChangeFirstPaymentDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    log.info(
		    "================Input================calculateDealChargesOnChangeFirstPaymentDate============================");
	    log.info("compCode	      :	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	      :	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("MaturityDate	  :	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("StartDate	      :	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("productClass	  :	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("Financing Amount  :	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("Currency          :	" + islamicCalculatorEventMgmtCO.getCurrencyCode());

	    if(islamicCalculatorEventMgmtCO.getConfirmationResult() == null)
	    {
		Date maturityDate = (Date) session.get("islamicCalcEvtMgmtCOMaturityDate");
		islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
	    }
	    else
	    {
		if(islamicCalculatorEventMgmtCO.getConfirmationResult())
		{
		    Date maturityDate = (Date) session.get("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");
		    islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
		}
		else
		{
		    Date maturityDate = (Date) session.get("islamicCalcEvtMgmtCOMaturityDate");
		    islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
		}
	    }
	    session.remove("islamicCalcEvtMgmtCOMaturityDate");
	    session.remove("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");

	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)JSONArray.toCollection(JSONArray.fromObject(strDealCharges),
	    // TrsDealChargesCO.class));

	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .calculateDealCharges(islamicCalculatorEventMgmtCO);

	    if(session.get("islamicCalcEvtMgmtCGracePeriod") != null)
	    {
		islamicCalculatorEventMgmtCO.setGracePeriod((BigDecimal) session.get("islamicCalcEvtMgmtCGracePeriod"));
	    }
	    if(session.get("islamicCalcEvtMgmtCOGracePeriodicity") != null)
	    {
		islamicCalculatorEventMgmtCO
			.setGracePeriodicity(session.get("islamicCalcEvtMgmtCOGracePeriodicity").toString());
	    }

	    session.remove("islamicCalcEvtMgmtCGracePeriod");
	    session.remove("islamicCalcEvtMgmtCOGracePeriodicity");

	    log.info(
		    "================Output=======================calculateDealChargesOnChangeFirstPaymentDate=====================");
	    log.info("Output DealChargesVO:	" + islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    log.info("Output MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity	:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("============================================================");
	}
	catch(Exception e)
	{
	    session.remove("islCalcEvtMgmtNoOfPymtMaturityDate");
	    session.remove("islCalcEvtMgmtNoOfPymtMaturityDateAfterHoliday");
	    session.remove("islamicCalcEvtMgmtCGracePeriod");
	    session.remove("islamicCalcEvtMgmtCOGracePeriodicity");
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "calculateDealCharges";
    }

    /**
     * Method for handling the change event for the NoOfPayments
     * 
     * @return
     */

    public String validateOnChangeNoOfPayments()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("================Input================validateOnChangeNoOfPayments============================");
	    log.info("compCode					:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("NoOfPayments				:	"
		    + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("ProductClass				:	"
		    + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("Check defaultMaturityDate	:	" + islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate());

	    log.info("================Output=======================validateOnChangeNoOfPayments=====================");

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .validateOnChangeNoOfPayments(islamicCalculatorEventMgmtCO);

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }
	    log.info("OP CheckDefaultMaturityDate	:	"
		    + islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate());
	    log.info("============================================================");

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateOnChangeNoOfPayments";
    }

    /**
     * Method for handling the change event for the NoOfPayments
     * 
     * @return
     */
    public String onChangeNoOfPayments()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    log.info("================Input================onChangeNoOfPayments============================");
	    log.info("compCode				:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info(
		    "BranchCode				:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("NoOfpayments			:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodicity			:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodNbr			:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodPos			:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("StartDate				:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("cifNo					:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("productClass			:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("Financing Amount  		:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("Currency				:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("Maturity Date 			:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Firstpayment date	    :	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeNoOfPayments(islamicCalculatorEventMgmtCO);

	    // Setting the Maturity date to session
	    if(islamicCalculatorEventMgmtCO.getMaturityDate() != null)
	    {
		session.put("islCalcEvtMgmtNoOfPymtMaturityDate", islamicCalculatorEventMgmtCO.getMaturityDate());
	    }
	    // Setting the revised Maturity date after holiday to session in
	    // case of the passed maturity date falls on a holiday
	    if(islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday() != null)
	    {
		session.put("islCalcEvtMgmtNoOfPymtMaturityDateAfterHoliday",
			islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	    }

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }

	    log.info("================Output=======================onChangeNoOfPayments=====================");
	    log.info("Output MaturityDate				 :	"
		    + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info(
		    "Output MaturityDate AfterHoliday :	" + islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	    log.info("OP ConfirmMessageId				 :	"
		    + islamicCalculatorEventMgmtCO.getConfirmationMessageId());
	    log.info(
		    "************************************OUTPUT*********END*******************************************");

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeNoOfPayments";
    }

    public String calculateDealChargesOnChangeNoOfPayments()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    log.info(
		    "================Input================calculateDealChargesOnChangeNoOfPayments============================");
	    log.info("compCode	      :	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	      :	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("MaturityDate	  :	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("StartDate	      :	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("productClass	  :	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("Financing Amount  :	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("Currency          :	" + islamicCalculatorEventMgmtCO.getCurrencyCode());

	    if(islamicCalculatorEventMgmtCO.getConfirmationResult() == null)
	    {
		Date maturityDate = (Date) session.get("islCalcEvtMgmtNoOfPymtMaturityDate");
		islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
	    }
	    else
	    {
		if(islamicCalculatorEventMgmtCO.getConfirmationResult())
		{
		    Date maturityDate = (Date) session.get("islCalcEvtMgmtNoOfPymtMaturityDateAfterHoliday");
		    islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
		}
		else
		{
		    Date maturityDate = (Date) session.get("islCalcEvtMgmtNoOfPymtMaturityDate");
		    islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
		}
	    }
	    session.remove("islCalcEvtMgmtNoOfPymtMaturityDate");
	    session.remove("islCalcEvtMgmtNoOfPymtMaturityDateAfterHoliday");

	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)JSONArray.toCollection(JSONArray.fromObject(strDealCharges),
	    // TrsDealChargesCO.class));

	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .calculateDealCharges(islamicCalculatorEventMgmtCO);
	    log.info(
		    "================Output=======================calculateDealChargesOnChangeNoOfPayments=====================");
	    log.info("Output DealChargesVO:	" + islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    log.info("Output MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("============================================================");
	}
	catch(Exception e)
	{
	    session.remove("islCalcEvtMgmtNoOfPymtMaturityDate");
	    session.remove("islCalcEvtMgmtNoOfPymtMaturityDateAfterHoliday");
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "calculateDealCharges";
    }

    /**
     * Method for handling the change event for the NoOfPayments -
     * calculateDealCharges
     * 
     * @return
     */
    public String calculateDealCharges()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    log.info("================Input================calculateDealCharges============================");
	    log.info("compCode			:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode			:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("MaturityDate		:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("StartDate			:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("productClass		:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("Financing Amount    :	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("Currency			:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());

	    log.info("BaseCurrencyCode	:" + islamicCalculatorEventMgmtCO.getBaseCurrencyCode());

	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)JSONArray.toCollection(JSONArray.fromObject(strDealCharges),
	    // TrsDealChargesCO.class));

	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .calculateDealCharges(islamicCalculatorEventMgmtCO);
	    log.info("================Output=======================calculateDealCharges=====================");
	    log.info("Output DealChargesVO:	" + islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    log.info("Output MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("============================================================");
	}
	catch(Exception e)
	{
	    session.remove("islCalcEvtMgmtNoOfPymtMaturityDate");
	    session.remove("islCalcEvtMgmtNoOfPymtMaturityDateAfterHoliday");
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "calculateDealCharges";
    }

    /**
     * Method for handling the change event for the PayEvery
     * 
     * @return
     */

    public String validateOnChangePayEvery()
    {

	if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	{

	    islamicCalculatorEventMgmtCO.getGracePeriod();
	    islamicCalculatorEventMgmtCO.setFirstPaymentDate(islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	}
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("================Input================validateOnChangePayEvery============================");
	    log.info("compCode	   				 :	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("paymPeriodNbr   			 :	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("ProductClass    			 :	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("Check Default	        	 :	"
		    + islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate());

	    islamicCalculatorEventMgmtCO = iisCommonBO.validateOnChangePayEvery(islamicCalculatorEventMgmtCO);

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }
	    log.info("================Output=======================validateOnChangePayEvery=====================");
	    log.info("OP CheckDefaultMaturityDate	:	"
		    + islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate());
	    log.info("OP Confirmation MessageId	:	" + islamicCalculatorEventMgmtCO.getConfirmationMessageId());
	    log.info("============================================================");
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateOnChangePayEvery";
    }

    /**
     * Method for handling the change event for the PayEveryPeriodicity
     * 
     * @return
     */

    public String validateOnChangePayEveryPeriodicity()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info(
		    "================Input================validateOnChangePayEveryPeriodicity============================");
	    log.info("compCode	 				 :	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("ProductClass 				 :	"
		    + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info(
		    "Check Default MaturityDate	:	" + islamicCalculatorEventMgmtCO.getDefaultMaturityDate());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .validateOnChangePayEveryPeriodicity(islamicCalculatorEventMgmtCO);
	    // Hari.K.S 23/08/2018
	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()) + islamicCalculatorEventMgmtCO.getProductClass());
	    }

	    log.info(
		    "================Output=======================validateOnChangePayEveryPeriodicity=====================");
	    log.info("OP CheckDefaultMaturityDate	:	"
		    + islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate());
	    log.info("OP Confirmation MessageId	:	" + islamicCalculatorEventMgmtCO.getConfirmationMessageId());
	    log.info("============================================================");
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateOnChangePayEveryPeriodicity";
    }

    /**
     * Method for handling the change event for the PayEveryPosition
     * 
     * @return
     */

    public String validateOnChangePayEveryPosition()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info(
		    "================Input================validateOnChangePayEveryPeriodicity============================");
	    log.info("compCode	  				:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("ProductClass  				:	"
		    + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info(
		    "Check Default MaturityDate	:	" + islamicCalculatorEventMgmtCO.getDefaultMaturityDate());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .validateOnChangePayEveryPosition(islamicCalculatorEventMgmtCO);

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }
	    log.info(
		    "================Output=======================validateOnChangePayEveryPeriodicity=====================");
	    log.info("OP CheckDefaultMaturityDate	:	"
		    + islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate());
	    log.info("OP Confirmation MessageId	:	" + islamicCalculatorEventMgmtCO.getConfirmationMessageId());
	    log.info("============================================================");
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateOnChangePayEveryPosition";
    }

    /**
     * Method for handling the change event for Yield
     * 
     * @return
     */
    public String onChangeYield()
    {
	SessionCO sessionCO = null;
	try
	{
	    sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setPrefferedLanguage(sessionCO.getLanguage());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO.setSalaryWithBank("N");

	    log.info("***********--------------onChangeYield------INPUT------------************************");

	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("Yield	 	:	" + islamicCalculatorEventMgmtCO.getAnnualYieldRate());
	    log.info("productClass:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("ValueDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("cifNo		:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("Currency	:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("financing Amount:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("PaymPeriodNbr	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    BigDecimal currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();

	    if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    {

		if(StringUtil.isNotEmpty(strNIDCDetail))
		{
		    GridUpdates gridData = getGridUpdates(strNIDCDetail, TRSDEAL_NIDCVO.class, true);// Deal
		    islamicCalculatorEventMgmtCO.setTrsdealNIDCDETVOList(gridData.getLstAllRec());
		}
		else
		{
		    islamicCalculatorEventMgmtCO.setTrsdealNIDCDETVOList(new ArrayList<TRSDEAL_NIDC_DETVO>());
		}
	    }
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeYield(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .calculateAnnualFloatingMarginRates(islamicCalculatorEventMgmtCO);

	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);

	    log.info("***********--------------onChangeYield---------OUTPUT---------************************");
	    log.info("Margin				:	" + islamicCalculatorEventMgmtCO.getMargin());
	}
	catch(Exception e)
	{
	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);
	    handleException(e, null, null);
	}
	return "onChangeYield";
    }
	
	public String checkYieldGreaterThanTieRate()
    {	
		SessionCO sessionCO = null;
	try
	{
		sessionCO = returnSessionObject();
		islamicCalculatorEventMgmtCO
				.setCompCode(sessionCO.getCompanyCode());
		islamicCalculatorEventMgmtCO.setBranchCode(sessionCO
				.getBranchCode());
		islamicCalculatorEventMgmtCO.setRunningDate(sessionCO
				.getRunningDateRET());
		islamicCalculatorEventMgmtCO.setPrefferedLanguage(sessionCO
				.getLanguage());
		NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    
	    
	    
		islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO.checkYieldGreaterThanTieRate(islamicCalculatorEventMgmtCO);

	    
	    getAdditionalScreenParams().putAll(islamicCalculatorEventMgmtCO.getHmSysParam());

	    
	}
	catch(BOException ex)
	{
	    String msgIdent;
	    Object returnValue;
	    msgIdent = (ex).getMsgIdent();
	    returnValue = (ex).getRetValue();
	    if(msgIdent != null)
	    {
		setConfirmType(msgIdent);
	    }
	    
		setConfirmReturn(returnValue);
		
	    handleException(ex, null, null);

	}
	catch(Exception e)
	{
		islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Method for handling the change event for Yield
     * 
     * @return
     */
    public String populateOnChangeSalaryWithBank()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("populateOnChangeSalaryWithBank");

	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("NoOfPayments	 	:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodNbr	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity	:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("ValueDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("productClass	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("cifNo	:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("salaryWithBank	:	" + islamicCalculatorEventMgmtCO.getMaintainSalaryAccount());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeSalaryWithBank(islamicCalculatorEventMgmtCO);
	    log.info("output yield 		:	" + islamicCalculatorEventMgmtCO.getYield());
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "populateOnChangeSalaryWithBank";
    }

    /**
     * Method for handling the change event for Total Flat Rate
     * 
     * @return
     */
    public String onChangeTotalFlatRate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("	totalFlatRate	:	" + islamicCalculatorEventMgmtCO.getTotalFlatRate());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeTotalFlatRate(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangeTotalFlatRate";
    }

    /**
     * Method for handling the change event for Profit Calculation Method
     * 
     * @return
     */
    public String onChangeProfitCalculationMethod()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeProfitCalculationMethod(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Method for handling the change event for First PaymentAfter Number
     * 
     * @return
     */
    public String onChangeFirstPaymentAfter()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setCommencementDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO.setYield(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield()));
	    islamicCalculatorEventMgmtCO.setPageRef(get_pageRef());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    // TODO hard coded
	    islamicCalculatorEventMgmtCO.setSalaryWithBank("N");

	    log.info("================Input================onChangeFirstPaymentAfter============================");

	    log.info("compCode	      	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	    	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("NoOfPayments		:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodNbr		:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity		:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos		:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("GracePeriod 		:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity	:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("ClassCode			:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("ValueDate			:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("MaturityDate		:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("TempCode			:	" + islamicCalculatorEventMgmtCO.getTempCode());
	    log.info("Currency			:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("BaloonPercentage	:	" + islamicCalculatorEventMgmtCO.getBaloonPercentage());
	    log.info("salaryWithBank		:	" + islamicCalculatorEventMgmtCO.getSalaryWithBank());
	    log.info("basecurrency		:	" + islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    // BigDecimal yld =
	    // NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield());
	    BigDecimal currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    islamicCalculatorEventMgmtCO.setYield(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield()));
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeFirstPaymentAfter(islamicCalculatorEventMgmtCO);
	    // islamicCalculatorEventMgmtCO.setYield(yld);
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											   // DECIMAL
											   // FORMAT
											   // BASED
											   // ON
	    // CURRENCY

	    log.info("================Output=======================onChangeFirstPaymentAfter=====================");
	    log.info("firstPaymentDate	:	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    log.info("MaturityDate	    :	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("output yield 		:	" + islamicCalculatorEventMgmtCO.getYield());

	    log.info("============================================================");
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangeFirstPaymentAfter";
    }

    /**
     * Method for handling the change event for First PaymentAfter Periodicity
     * 
     * @return
     */
    public String onChangeFirstPaymentAfterPeriodicity()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setCommencementDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO.setYield(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield()));
	    islamicCalculatorEventMgmtCO.setPageRef(get_pageRef());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    // TODO hard coded
	    islamicCalculatorEventMgmtCO.setSalaryWithBank("N");

	    log.info("onChangeFirstPaymentAfterPeriodicity");
	    log.info(
		    "================Input================onChangeFirstPaymentAfterPeriodicity============================");
	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("NoOfPayments	:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodNbr	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity	:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("ClassCode	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("ValueDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("TempCode	:	" + islamicCalculatorEventMgmtCO.getTempCode());
	    log.info("Currency	:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("BaloonPercentage	:	" + islamicCalculatorEventMgmtCO.getBaloonPercentage());
	    log.info("salaryWithBank	:	" + islamicCalculatorEventMgmtCO.getSalaryWithBank());
	    log.info("Firstpayment date	:	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    // BigDecimal yld =
	    // NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield());
	    islamicCalculatorEventMgmtCO.setYield(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getYield()));
	    BigDecimal currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    islamicCalculatorEventMgmtCO = iisIslamicCalculatorBO
		    .populateOnChangeFirstPaymentAfterPeriodicity(islamicCalculatorEventMgmtCO);
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											   // DECIMAL
											   // FORMAT
											   // BASED
											   // ON
	    // CURRENCY
	    // islamicCalculatorEventMgmtCO.setYield(yld);
	    session.put("islamicCalcEvtMgmtCOFirstPaymentDate", islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    session.put("islamicCalcEvtMgmtCOMaturityDate", islamicCalculatorEventMgmtCO.getMaturityDate());
	    session.put("islamicCalcEvtMgmtCOYield", islamicCalculatorEventMgmtCO.getYield());
	    session.put("islamicCalcEvtMgmtCOMaturityDateAfterHoliday",
		    islamicCalculatorEventMgmtCO.getMaturityDateAfterHoliday());
	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }

	    log.info(
		    "================Output=======================onChangeFirstPaymentAfterPeriodicity=====================");
	    log.info("firstPaymentDate	:	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    log.info("MaturityDate	    :	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("output yield 		:	" + islamicCalculatorEventMgmtCO.getYield());
	    log.info("============================================================");
	}
	catch(Exception e)
	{
	    session.remove("islamicCalcEvtMgmtCOFirstPaymentDate");
	    session.remove("islamicCalcEvtMgmtCOMaturityDate");
	    session.remove("islamicCalcEvtMgmtCOYield");
	    session.remove("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");
	    handleException(e, null, null);
	}
	return "onChangeFirstPaymentAfterPeriodicity";
    }

    /**
     * Method for handling the change event for First PaymentAfter Periodicity
     * ((checking of setMaturityBasedonHoliday)
     * 
     * @return
     */
    public String setMaturityBasedonHoliday()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setCommencementDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setStartDate(islamicCalculatorEventMgmtCO.getStartDate());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    // TODO hard coded
	    islamicCalculatorEventMgmtCO.setSalaryWithBank("N");

	    log.info("setMaturityBasedonHoliday");

	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("NoOfPayments	:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("PaymPeriodNbr	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodicity	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodPos	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity	:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("ClassCode	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("ValueDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("TempCode	:	" + islamicCalculatorEventMgmtCO.getTempCode());
	    log.info("Currency	:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("BaloonPercentage	:	" + islamicCalculatorEventMgmtCO.getBaloonPercentage());
	    log.info("salaryWithBank	:	" + islamicCalculatorEventMgmtCO.getSalaryWithBank());
	    BigDecimal currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)JSONArray.toCollection(JSONArray.fromObject(strDealCharges),
	    // TrsDealChargesCO.class));

	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }

	    if(islamicCalculatorEventMgmtCO.getConfirmationResult() == null)
	    {
		Date maturityDate = (Date) session.get("islamicCalcEvtMgmtCOMaturityDate");
		islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
		islamicCalculatorEventMgmtCO.setMaturityDateAfterHoliday(
			(Date) session.get("islamicCalcEvtMgmtCOMaturityDateAfterHoliday"));
	    }
	    else
	    {
		if(islamicCalculatorEventMgmtCO.getConfirmationResult())
		{
		    Date maturityDate = (Date) session.get("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");
		    islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
		    islamicCalculatorEventMgmtCO.setMaturityDateAfterHoliday(maturityDate);
		}
		else
		{
		    Date maturityDate = (Date) session.get("islamicCalcEvtMgmtCOMaturityDate");
		    islamicCalculatorEventMgmtCO.setMaturityDate(maturityDate);
		    islamicCalculatorEventMgmtCO.setMaturityDateAfterHoliday(
			    (Date) session.get("islamicCalcEvtMgmtCOMaturityDateAfterHoliday"));
		}
	    }
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .setMaturityBasedonHoliday(islamicCalculatorEventMgmtCO);

	    islamicCalculatorEventMgmtCO
		    .setFirstPaymentDate((Date) session.get("islamicCalcEvtMgmtCOFirstPaymentDate"));
	    islamicCalculatorEventMgmtCO.setYield((BigDecimal) session.get("islamicCalcEvtMgmtCOYield"));
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											   // DECIMAL
											   // FORMAT
											   // BASED
											   // ON
	    // CURRENCY
	    log.info("firstPaymentDate	:	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    log.info("MaturityDate	    :	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("output yield 		:	" + islamicCalculatorEventMgmtCO.getYield());
	    log.info("Output DealChargesVO	          :	" + islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	}
	catch(Exception e)
	{
	    session.remove("islamicCalcEvtMgmtCOFirstPaymentDate");
	    session.remove("islamicCalcEvtMgmtCOMaturityDate");
	    session.remove("islamicCalcEvtMgmtCOYield");
	    session.remove("islamicCalcEvtMgmtCOMaturityDateAfterHoliday");
	    handleException(e, null, null);
	}
	return "setMaturityBasedonHoliday";
    }

    /**
     * Method for handling the change event for Amount Per Payment
     * 
     * @return
     */
    public String onChangeAmountPerPayment()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("*******************onChangeAmountPerPayment**************iNPUT***************************");
	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("amountPerPayment  :	" + islamicCalculatorEventMgmtCO.getAmountPerPayment());
	    log.info("currencyCode  :	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("financingCurrency  :	" + islamicCalculatorEventMgmtCO.getFinancingCurrency());
	    log.info("financingAmount  :	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("yield  :	" + islamicCalculatorEventMgmtCO.getYield());
	    log.info("startDate  :	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("maturityDate  :	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("noOfPayments  :	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("totalInsuranceAmount  :	" + islamicCalculatorEventMgmtCO.getTotalInsuranceAmt());
	    BigDecimal currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeAmountPerPayment(islamicCalculatorEventMgmtCO);
	    log.info("*******************onChangeAmountPerPayment**************oUTPUT***************************");
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											   // DECIMAL
											   // FORMAT
											   // BASED
											   // ON
	    // CURRENCY
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeAmountPerPayment";
    }

    /***
     * Method for the on change event of capital amount
     * 
     * @return
     */
    public String onChangeCapitalAmount()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("*******************onChangeCapitalAmount**************iNPUT***************************");
	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("financingAmount  :	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject() != null)
	    {
		log.info("noOfPayments :	"
			+ islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
		log.info("PaymentType  :	"
			+ islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYMENT_TYPE());
		log.info("CAPITAL_AMT  :	"
			+ islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    }
	    BigDecimal currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeRepaymentCriteriaAmount(islamicCalculatorEventMgmtCO);
	    log.info("*******************onChangeCapitalAmount**************oUTPUT***************************");
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											   // DECIMAL
											   // FORMAT
											   // BASED
											   // ON
	    // CURRENCY
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangeCapitalAmount";
    }

    /**
     * Method for handling the change event for Pay Every
     * 
     * @return
     */
    public String onChangePayEvery()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    // islamicCalculatorEventMgmtCO =
	    // islamicCalculatorEventMgmtBO.populateOnChangePayEvery(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangePayEvery";
    }

    /**
     * Method for handling the change event for Pay Every Periodicity
     * 
     * @return
     */
    public String onChangePayEveryPeriodicity()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    // islamicCalculatorEventMgmtCO =
	    // islamicCalculatorEventMgmtBO.populateOnChangePayEveryPeriodicity(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangePayEveryPeriodicity";
    }

    /**
     * Method for handling the change event for Pay Every Position
     * 
     * @return
     */
    public String onChangePayEveryPosition()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    // islamicCalculatorEventMgmtCO =
	    // islamicCalculatorEventMgmtBO.populateOnChangePayEveryPosition(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangePayEveryPosition";
    }

    /**
     * Method for handling the change event for Template Code
     * 
     * @return
     */
    public String onChangeTemplateCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("================Input================onChangeTemplateCode============================");
	    log.info("compCode					:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("BranchCode					:	"
		    + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("TempCode					:	" + islamicCalculatorEventMgmtCO.getTempCode());
	    log.info("currency		 	 		:	"
		    + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("ValueDate					:	"
		    + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("finaicng amount 		    :	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("DealChargesVO				:	"
		    + islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    log.info("MaturityDate				:	"
		    + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("ClassCode					:	"
		    + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("cifNo						:	"
		    + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("downpayment amount			:	"
		    + islamicCalculatorEventMgmtCO.getDownPaymentAmount());
	    log.info("PaymPeriodicity(Pay every)	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("PaymPeriodNbr(Pay every)	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("PaymPeriodPos(Pay every At)	:	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("GracePeriod 				:	"
		    + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity			:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("Baloon Percentage			:	" + islamicCalculatorEventMgmtCO.getBaloonPercentage());
	    log.info("NoOfPayments			    : 	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("yield			    		: 	" + islamicCalculatorEventMgmtCO.getYield());
	    log.info("firstPaymentDate		    : 	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    log.info(
		    "dealAmount				    : 	" + islamicCalculatorEventMgmtCO.getDealAmount());
	    log.info("Running Date				: 	"
		    + islamicCalculatorEventMgmtCO.getRunningDate());
	    // islamicCalculatorEventMgmtCO.setTrsDealChargesVO((List<TrsDealChargesCO>)JSONArray.toCollection(JSONArray.fromObject(strDealCharges),
	    // TrsDealChargesCO.class));

	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeTemplateCode(islamicCalculatorEventMgmtCO);
	    log.info("================Output================onChangeTemplateCode============================");

	    log.info("Output ProfitCalcMethod			  :	"
		    + islamicCalculatorEventMgmtCO.getProfitCalcMethod());
	    log.info("Output ProfitDistMethod			  :	"
		    + islamicCalculatorEventMgmtCO.getProfitDistMethod());
	    log.info("Output PaymPeriodicity(PAy every) :	" + islamicCalculatorEventMgmtCO.getPaymPeriodicity());
	    log.info("Output PaymPeriodNbr(PAy every)	  :	" + islamicCalculatorEventMgmtCO.getPaymPeriodNbr());
	    log.info("Output PaymPeriodPos(PAy every At):	" + islamicCalculatorEventMgmtCO.getPaymPeriodPos());
	    log.info("Output PayResAmt	  			  :	"
		    + islamicCalculatorEventMgmtCO.getPayResAmt());
	    log.info("Output GracePeriod 				  :	"
		    + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("Output GracePeriodicity			  :	"
		    + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("Output BaloonAmount				  :	"
		    + islamicCalculatorEventMgmtCO.getBaloonAmount());
	    log.info("Output NoOfBaloonPayments		  :	"
		    + islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    log.info("Output NoOfPayments			      : "
		    + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("Output DealChargesVO	          :	" + islamicCalculatorEventMgmtCO.getTrsDealChargesVO());
	    log.info("Output MaturityDate	              :	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Output FitrstPaymentDate          :	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());
	    if(islamicCalculatorEventMgmtCO.getBalloonDetailsList() != null)
	    {
		for(int i = 0; i < islamicCalculatorEventMgmtCO.getBalloonDetailsList().size(); i++)
		{
		    log.info("RECORD NO=============================================" + i
			    + "=================================");
		    log.info("balloonDate          :	"
			    + islamicCalculatorEventMgmtCO.getBalloonDetailsList().get(i).getBalloonDate());
		    log.info("balloonDate          :	"
			    + islamicCalculatorEventMgmtCO.getBalloonDetailsList().get(i).getBalloonNo());
		    log.info("balloonDate          :	"
			    + islamicCalculatorEventMgmtCO.getBalloonDetailsList().get(i).getBalloonAmount());
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangeTemplateCode";
    }

    /**
     * Method for handling the change event for No Of Balloons
     * 
     * @return
     */
    public String onChangeNoOfBalloons()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    // TP#194122; Ramesh; Date 10/08/2014
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("================Input================onChangeNoOfBalloons============================");
	    log.info("comp code		:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("branch			:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("TempCode		:	" + islamicCalculatorEventMgmtCO.getTempCode());
	    log.info("Start Date		:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("No of balloons	:	" + islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    log.info("BaloonPercentage:	" + islamicCalculatorEventMgmtCO.getBaloonPercentage());
	    log.info("Product Class	:	" + islamicCalculatorEventMgmtCO.getProductClass());

	    islamicCalculatorEventMgmtCO = iisIslamicCalculatorBO
		    .populateOnChangeNoOfBalloons(islamicCalculatorEventMgmtCO);

	    log.info("================OutPut================onChangeNoOfBalloons============================");
	    log.info("Output BaloonPercentage	:	" + islamicCalculatorEventMgmtCO.getBaloonPercentage());
	    log.info("Output BaloonAmount		:	" + islamicCalculatorEventMgmtCO.getBaloonAmount());
	    if(islamicCalculatorEventMgmtCO.getBalloonDetailsList() != null)
	    {
		log.info("Output : baloon list : " + islamicCalculatorEventMgmtCO.getBalloonDetailsList().size());
	    }

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangeNoOfBalloons";
    }

    /**
     * Method for handling the change event for Balloon Percentage
     * 
     * @return
     */
    public String onChangeBalloonPercentage()
    {
	SessionCO sessionCO = null;
	BigDecimal currencyCode = null;
	try
	{
	    sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    log.info("================Input================onChangeBalloonPercentage============================");
	    log.info("comp code	    :	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("branch		    :	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("TempCode	    :	" + islamicCalculatorEventMgmtCO.getTempCode());
	    log.info("Start Date	    :	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("No of balloons  :	" + islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    log.info("Percentage	    :	" + islamicCalculatorEventMgmtCO.getBaloonPercentage());
	    log.info("productclass	:	" + islamicCalculatorEventMgmtCO.getProductClass());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeBalloonPercentage(islamicCalculatorEventMgmtCO);
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											   // DECIMAL
											   // FORMAT
											   // BASED
											   // ON
	    // CURRENCY

	    log.info("================OutPut================onChangeBalloonPercentage============================");
	    log.info("Output BaloonAmount	:	" + islamicCalculatorEventMgmtCO.getBaloonAmount());
	    if(islamicCalculatorEventMgmtCO.getBalloonDetailsList() != null)
	    {
		log.info("Output : baloon list : " + islamicCalculatorEventMgmtCO.getBalloonDetailsList().size());
	    }
	}
	catch(Exception e)
	{
	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);// APPLY
	    // DECIMAL
	    // FORMAT
	    // BASED ON
	    // CURRENCY
	    handleException(e, null, null);
	}
	return "onChangeBalloonPercentage";
    }

    /**
     * Method for handling the change event for Balloon Payment Amount
     * 
     * @return
     */
    public String onChangeBalloonPaymentAmount()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    BigDecimal currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    log.info("================Input================onChangeBalloonPaymentAmount============================");

	    log.info("comp code   	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("branch		    :	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("TempCode	    :	" + islamicCalculatorEventMgmtCO.getTempCode());
	    log.info("startDate		:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("maturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("productClass	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("No of balloons  :	" + islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    log.info("Percentage	    :	" + islamicCalculatorEventMgmtCO.getBaloonPercentage());
	    log.info("productclass	:	" + islamicCalculatorEventMgmtCO.getProductClass());

	    log.info("baloonAmount	:	" + islamicCalculatorEventMgmtCO.getBaloonAmount());
	    log.info("dealAmount		:	" + islamicCalculatorEventMgmtCO.getDealAmount());
	    log.info("financing 		:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());

	    islamicCalculatorEventMgmtCO = iisIslamicCalculatorBO
		    .populateOnChangeBalloonPaymentAmount(islamicCalculatorEventMgmtCO);
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);// APPLY
											   // DECIMAL
											   // FORMAT
											   // BASED
											   // ON
	    // CURRENCY
	    log.info("================OutPut================onChangeBalloonPercentage============================");

	    log.info("Output   BaloonPercentage	:	" + islamicCalculatorEventMgmtCO.getBaloonPercentage());
	    if(islamicCalculatorEventMgmtCO.getBalloonDetailsList() != null)
	    {
		log.info("Output : baloon list : " + islamicCalculatorEventMgmtCO.getBalloonDetailsList().size());
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangeBalloonPaymentAmount";
    }

    /**
     * Method for handling the change event for Deal Period Compounding
     * 
     * @return
     */
    public String onChangeDealPeriodCompounding()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeDealPeriodCompounding(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangeDealPeriodCompounding";
    }

    /**
     * Method for handling the change event for Vat Applicable
     * 
     * @return
     */
    public String onChangeVatApplicable()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("Compcode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("Branch		:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("Vat Applicable	:	" + islamicCalculatorEventMgmtCO.getVatApplicable());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeVatApplicable(islamicCalculatorEventMgmtCO);

	    log.info(" Output Vatcode	:	" + islamicCalculatorEventMgmtCO.getVatCode());
	    log.info(" Output VatDesc	:	" + islamicCalculatorEventMgmtCO.getVatDesc());
	    log.info(" Output IncludeVatinInstallment	:	"
		    + islamicCalculatorEventMgmtCO.getIncludeVatinInstallment());
	    log.info(" Output Vat Percentage	:	" + islamicCalculatorEventMgmtCO.getVatPercentage());
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangeVatApplicable";
    }

    /**
     * Method for handling the change event for Vat Installment
     * 
     * @return
     */
    public String onChangeVatInstallment()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("Compcode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("Branch		:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("Vat code	:	" + islamicCalculatorEventMgmtCO.getVatCode());
	    log.info("Vat Applicable	:	" + islamicCalculatorEventMgmtCO.getIncludeVatinInstallment());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeVatInstallment(islamicCalculatorEventMgmtCO);
	    log.info("Vatcode	:	" + islamicCalculatorEventMgmtCO.getVatCode());
	    log.info("VatDesc	:	" + islamicCalculatorEventMgmtCO.getVatDesc());
	    log.info("VatPercentage	:	" + islamicCalculatorEventMgmtCO.getVatPercentage());
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangeVatInstallment";
    }

    /**
     * Method for handling the change event for Vat Code
     * 
     * @return
     */
    public String onChangeVatCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("Compcode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("Branch		:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("Vat code	:	" + islamicCalculatorEventMgmtCO.getVatCode());
	    log.info("productClass	:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("financingAmount	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("Vat Applicable	:	" + islamicCalculatorEventMgmtCO.getVatApplicable());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeVatCode(islamicCalculatorEventMgmtCO);

	    // islamicCalculatorEventMgmtCO.setVatDesc("test desc");
	    // islamicCalculatorEventMgmtCO.setIncludeVatinInstallment("Y");
	    // islamicCalculatorEventMgmtCO.setVatPercentage(new
	    // BigDecimal(1002));
	    log.info("VatDesc	:	" + islamicCalculatorEventMgmtCO.getVatDesc());
	    log.info("IncludeVatinInstallment	:	" + islamicCalculatorEventMgmtCO.getIncludeVatinInstallment());
	    log.info("VatPercentage	:	" + islamicCalculatorEventMgmtCO.getVatPercentage());

	    // TP#245267; Libin; Date 28/12/2014
	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "onChangeVatCode";
    }

    /**
     * Method for Show schedule
     * 
     * @return
     */
    public String populateIslamicCalculatorSchedulePopup()
    {
	return "populateIslamicCalculatorSchedulePopup";
    }

    /**
     * Method for Balloon Payments
     * 
     * @return
     */
    public String populateIslamicCalculatorBalloonPaymentPopup()
    {
	return "populateIslamicCalculatorBalloonPaymentPopup";
    }

    /**
     * Method for loading the Balloon details grid
     * 
     * @return
     */
    public String populateUnEqualBalloonPaymentDetails()
    {
	try
	{

	    log.info("getUnEqualBalloonPaymentDetails	:");
	    log.info("================Input================populateBaloonPaymentGrid============================");
	    log.info("NoOfBaloonPayments	:	" + islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    log.info("MaturityDate		:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Balloonpayment		:	" + islamicCalculatorEventMgmtCO.getBaloonAmount());
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO = iisIslamicCalculatorBO
		    .populateBaloonPaymentGrid(islamicCalculatorEventMgmtCO);

	    log.info("================Output================populateBaloonPaymentGrid============================");
	    if(islamicCalculatorEventMgmtCO.getBalloonDetailsList() != null)
	    {
		log.info("Output Balloon list	:	"
			+ islamicCalculatorEventMgmtCO.getBalloonDetailsList().size());
	    }
	    log.info("============================================");
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "getUnEqualBalloonPaymentDetails";
    }

    /**
     * Method for loading the Balloon details grid in equal payment mode
     * 
     * @return
     */
    public String populateEqualBalloonPaymentDetails()
    {
	try
	{
	    log.info("getEqualBalloonPaymentDetails	:");
	    log.info("================Input================getEqualBalloonPaymentDetails============================");
	    log.info("NoOfBaloonPayments	:	" + islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    log.info("MaturityDate		:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Balloonpayment		:	" + islamicCalculatorEventMgmtCO.getBaloonAmount());
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .getBalloonEqualPaymentsDetails(islamicCalculatorEventMgmtCO);

	    log.info("================Output================populateBaloonPaymentGrid============================");
	    if(islamicCalculatorEventMgmtCO.getBalloonDetailsList() != null)
	    {
		log.info("Output Balloon list	:	"
			+ islamicCalculatorEventMgmtCO.getBalloonDetailsList().size());
	    }
	    log.info("============================================");
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "getEqualBalloonPaymentDetails";
    }

    /**
     * Method for validateDateForBalloonDetails
     * 
     * @return
     */
    public String validateDateForBalloonDetails()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("validateDateForBalloonDetails	:");
	    log.info("================Input================validateDateForBalloonDetails============================");
	    log.info("NoOfBaloonPayments	:	" + islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    log.info("MaturityDate		:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Balloonpayment		:	" + islamicCalculatorEventMgmtCO.getBaloonAmount());
	    // // TP#221204;Arun.R.Variyath;18/09/2014 [Start]
	    if(strBalloonDetails != null && StringUtil.isNotEmpty(strBalloonDetails))
	    {
		GridUpdates gridData = getGridUpdates(strBalloonDetails, TrsPlanBallonPaymentCO.class, true);
		islamicCalculatorEventMgmtCO.setBalloonDetailsList(gridData.getLstAllRec());
	    }
	    // TP#221204;Arun.R.Variyath;18/09/2014 [End]
	    List<TrsPlanBallonPaymentCO> ballonDetails = islamicCalculatorEventMgmtBO
		    .validateDateForBalloonDetails(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO.setBalloonDetailsList(ballonDetails);

	    log.info("================Output================validateDateForBalloonDetails============================");
	    if(islamicCalculatorEventMgmtCO.getBalloonDetailsList() != null)
	    {
		log.info("Output Balloon list	:	"
			+ islamicCalculatorEventMgmtCO.getBalloonDetailsList().size());
	    }
	    log.info("============================================");
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }

    /**
     * Method for validateAmtForBalloonDetails
     * 
     * @return
     */
    public String validateAmtForBalloonDetails()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("validateAmtForBalloonDetails	:");
	    log.info("================Input================validateAmtForBalloonDetails============================");
	    log.info("NoOfBaloonPayments	:	" + islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    log.info("MaturityDate		:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("Balloonpayment		:	" + islamicCalculatorEventMgmtCO.getBaloonAmount());
	    // islamicCalculatorEventMgmtCO.getBallonPaymentCO().setBallonDate(new
	    // Date(strBalloonDate));
	    // islamicCalculatorEventMgmtCO.setBalloonDetailsList((List<TrsPlanBallonPaymentCO>)JSONArray.toCollection(JSONArray.fromObject(strBalloonDetails),
	    // TrsPlanBallonPaymentCO.class));
	    // TP#221204;Arun.R.Variyath;18/09/2014 [Start]
	    if(strBalloonDetails != null && StringUtil.isNotEmpty(strBalloonDetails))
	    {
		GridUpdates gridData = getGridUpdates(strBalloonDetails, TrsPlanBallonPaymentCO.class, true);
		gridData = getGridUpdates(strBalloonDetails, TrsPlanBallonPaymentCO.class, true);//
		islamicCalculatorEventMgmtCO.setBalloonDetailsList(gridData.getLstAllRec());
	    }
	    List<TrsPlanBallonPaymentCO> ballonDetails = islamicCalculatorEventMgmtBO
		    .validateAmtForBalloonDetails(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO.setBalloonDetailsList(ballonDetails);

	    log.info("================Output================validateAmtForBalloonDetails============================");
	    if(islamicCalculatorEventMgmtCO.getBalloonDetailsList() != null)
	    {
		log.info("Output Balloon list	:	"
			+ islamicCalculatorEventMgmtCO.getBalloonDetailsList().size());
	    }
	    log.info("============================================");
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }

    /**
     * Method for handling the change event for the RepaymentCriteria FromDate
     * 
     * @return
     */
    public String populateOnChangeRepaymentCriteriaFromDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCommencementDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() == null)
	    {
		islamicCalculatorEventMgmtCO.setSumOfCapitalAmtRepayment(BigDecimal.ZERO);
	    }
	    log.info("populateOnChangeRepaymentCriteriaFromDate	:");
	    log.info(
		    "================Input================populateOnChangeRepaymentCriteriaFromDate============================");
	    log.info("FROM_DATE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getFROM_DATE());
	    log.info("TO_DATE	:	" + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getTO_DATE());
	    log.info("PAYM_PERIODICITY	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIODICITY());
	    log.info("PAYM_PERIOD_POS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_POS());
	    log.info("PAYM_PERIOD_NBR	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_NBR());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("PAYMENT_TYPE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYMENT_TYPE());
	    log.info("CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    log.info("DEAL AMOUNT/FINANCING	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("NO_OF_PAYMENTS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
	    log.info("StartDate 	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("Financing Amount 	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("SumofcapitalamountRepayment 	:	"
		    + islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment());

	    // Added deal charges as param - based on issue 0092514
	    if(strDealCharges != null)
	    {
		GridUpdates gridData = getGridUpdates(strDealCharges, TrsDealChargesCO.class, true);// Deal
		// Charges
		islamicCalculatorEventMgmtCO.setTrsDealChargesVO(gridData.getLstAllRec());
	    }

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeRepaymentCriteriaFromDate(islamicCalculatorEventMgmtCO);
	    // islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().setCAPITAL_AMT(new
	    // BigDecimal(1111));
	    // islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().setNO_OF_PAYMENTS(new
	    // BigDecimal(11));
	    log.info(
		    "================Output================populateOnChangeRepaymentCriteriaFromDate============================");
	    log.info("Output CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());

	    log.info("Output NO_OF_PAYMENTS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
	    log.info("NoOfpayments	     	:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("============================================");
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "populateOnChangeRepaymentCriteriaFromDate";
    }

    /**
     * Method for handling the change event for the RepaymentCriteria FromDate
     * 
     * @return
     */
    public String populateOnChangeRepaymentCriteriaToDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCommencementDate(sessionCO.getRunningDateRET());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() == null)
	    {
		islamicCalculatorEventMgmtCO.setSumOfCapitalAmtRepayment(BigDecimal.ZERO);
	    }
	    log.info("populateOnChangeRepaymentCriteriaToDate	:");
	    log.info(
		    "================Input================populateOnChangeRepaymentCriteriaToDate============================");
	    log.info("FROM_DATE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getFROM_DATE());
	    log.info("TO_DATE	:	" + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getTO_DATE());
	    log.info("PAYM_PERIODICITY	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIODICITY());
	    log.info("PAYM_PERIOD_POS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_POS());
	    log.info("PAYM_PERIOD_NBR	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_NBR());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("PAYMENT_TYPE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYMENT_TYPE());
	    log.info("CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    log.info("DEAL AMOUNT/FINANCING	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("NO_OF_PAYMENTS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
	    log.info("StartDate 	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("Financing Amount 	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("SumofcapitalamountRepayment 	:	"
		    + islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeRepaymentCriteriaToDate(islamicCalculatorEventMgmtCO);
	    // islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().setCAPITAL_AMT(new
	    // BigDecimal(2222));
	    // islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().setNO_OF_PAYMENTS(new
	    // BigDecimal(22));
	    log.info(
		    "================Output================populateOnChangeRepaymentCriteriaToDate============================");
	    log.info("Output CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    log.info("Output NO_OF_PAYMENTS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
	    log.info("============================================================");
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "populateOnChangeRepaymentCriteriaToDate";
    }

    /**
     * Method for handling the change event for the RepaymentCriteria
     * PeriodicityNumber
     * 
     * @return
     */
    public String populateOnChangeRepaymentCriteriaPeriodicityNumber()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCommencementDate(sessionCO.getRunningDateRET());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() == null)
	    {
		islamicCalculatorEventMgmtCO.setSumOfCapitalAmtRepayment(BigDecimal.ZERO);
	    }
	    log.info("populateOnChangeRepaymentCriteriaPeriodicityNumber	:");
	    log.info(
		    "================Input================populateOnChangeRepaymentCriteriaPeriodicityNumber============================");
	    log.info("FROM_DATE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getFROM_DATE());
	    log.info("TO_DATE	:	" + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getTO_DATE());
	    log.info("PAYM_PERIODICITY	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIODICITY());
	    log.info("PAYM_PERIOD_POS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_POS());
	    log.info("PAYM_PERIOD_NBR	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_NBR());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("PAYMENT_TYPE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYMENT_TYPE());
	    log.info("CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    log.info("DEAL AMOUNT/FINANCING	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("NO_OF_PAYMENTS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
	    log.info("StartDate 	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("Financing Amount 	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("SumofcapitalamountRepayment 	:	"
		    + islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeRepaymentCriteriaPeriodicityNumber(islamicCalculatorEventMgmtCO);
	    log.info(
		    "================Output================populateOnChangeRepaymentCriteriaPeriodicityNumber============================");
	    log.info("Output CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    log.info("Output NO_OF_PAYMENTS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
	    log.info("============================================================");
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "populateOnChangeRepaymentCriteriaPeriodicityNumber";
    }

    /**
     * Method for handling the change event for the RepaymentCriteria
     * PeriodicityNumber
     * 
     * @return
     */
    public String populateOnChangeRepaymentCriteriaNoOfPayments()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO.setCommencementDate(sessionCO.getRunningDateRET());
	    if(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() == null)
	    {
		islamicCalculatorEventMgmtCO.setSumOfCapitalAmtRepayment(BigDecimal.ZERO);
	    }

	    log.info("populateOnChangeRepaymentCriteriaNoOfPayments	:");
	    log.info(
		    "================Input================populateOnChangeRepaymentCriteriaNoOfPayments============================");
	    log.info("FROM_DATE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getFROM_DATE());
	    log.info("TO_DATE	:	" + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getTO_DATE());
	    log.info("PAYM_PERIODICITY	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIODICITY());
	    log.info("PAYM_PERIOD_POS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_POS());
	    log.info("PAYM_PERIOD_NBR	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_NBR());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("FINANCING AMOUNT		:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("PAYMENT_TYPE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYMENT_TYPE());
	    log.info("CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    log.info("NO_OF_PAYMENTS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
	    log.info("SumofcapitalamountRepayment 	:	"
		    + islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeRepaymentCriteriaNoOfPayments(islamicCalculatorEventMgmtCO);
	    // islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().setCAPITAL_AMT(new
	    // BigDecimal(4444));
	    // islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().setNO_OF_PAYMENTS(new
	    // BigDecimal(44));
	    log.info(
		    "================Output================populateOnChangeRepaymentCriteriaNoOfPayments============================");
	    log.info("Output CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    log.info("Output TO_DATE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getTO_DATE());
	    log.info("============================================================");

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "populateOnChangeRepaymentCriteriaNoOfPayments";
    }

    /**
     * Method for handling the change event for the
     * RepaymentCriteriaPeriodicityPeriod
     * 
     * @return
     */
    public String populateOnChangeRepaymentCriteriaPeriodicityPeriod()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCommencementDate(sessionCO.getRunningDateRET());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() == null)
	    {
		islamicCalculatorEventMgmtCO.setSumOfCapitalAmtRepayment(BigDecimal.ZERO);
	    }

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeRepaymentCriteriaPeriodicityPeriod(islamicCalculatorEventMgmtCO);
	    // islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().setCAPITAL_AMT(new
	    // BigDecimal(5555));
	    // islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().setNO_OF_PAYMENTS(new
	    // BigDecimal(55));

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "populateOnChangeRepaymentCriteriaPeriodicityPeriod";
    }

    /**
     * Method for handling the change event for the
     * RepaymentCriteriaPeriodicityPosition
     * 
     * @return
     */
    public String populateOnChangeRepaymentCriteriaPeriodicityPosition()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCommencementDate(sessionCO.getRunningDateRET());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() == null)
	    {
		islamicCalculatorEventMgmtCO.setSumOfCapitalAmtRepayment(BigDecimal.ZERO);
	    }

	    log.info("populateOnChangeRepaymentCriteriaPeriodicityPosition:");
	    log.info(
		    "================Input================populateOnChangeRepaymentCriteriaPeriodicityPosition============================");
	    log.info("FROM_DATE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getFROM_DATE());
	    log.info("TO_DATE	:	" + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getTO_DATE());
	    log.info("PAYM_PERIODICITY	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIODICITY());
	    log.info("PAYM_PERIOD_POS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_POS());
	    log.info("PAYM_PERIOD_NBR	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_NBR());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("PAYMENT_TYPE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYMENT_TYPE());
	    log.info("CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    log.info("DEAL AMOUNT/FINANCING	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("NO_OF_PAYMENTS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
	    log.info("StartDate 	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("Financing Amount 	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("SumofcapitalamountRepayment 	:	"
		    + islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment());

	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeRepaymentCriteriaPeriodicityPosition(islamicCalculatorEventMgmtCO);
	    // islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().setCAPITAL_AMT(new
	    // BigDecimal(6666));
	    // islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().setNO_OF_PAYMENTS(new
	    // BigDecimal(66));
	    log.info(
		    "================Output================populateOnChangeRepaymentCriteriaPeriodicityPosition============================");
	    log.info("Output CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    log.info("Output NO_OF_PAYMENTS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
	    log.info("Output FROM_DATE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getFROM_DATE());
	    log.info("Output TO_DATE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getTO_DATE());
	    log.info("============================================================");

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "populateOnChangeRepaymentCriteriaPeriodicityPosition";
    }

    /**
     * Method for handling the change event for the
     * RepaymentCriteriaPeriodicityPosition
     * 
     * @return
     */
    public String populateOnChangeRepaymentCriteriaPaymentType()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCommencementDate(sessionCO.getRunningDateRET());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() == null)
	    {
		islamicCalculatorEventMgmtCO.setSumOfCapitalAmtRepayment(BigDecimal.ZERO);
	    }

	    log.info("populateOnChangeRepaymentCriteriaPaymentType:");
	    log.info(
		    "================Input============populateOnChangeRepaymentCriteriaPaymentType============================");
	    log.info("FROM_DATE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getFROM_DATE());
	    log.info("TO_DATE	:	" + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getTO_DATE());
	    log.info("PAYM_PERIODICITY	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIODICITY());
	    log.info("PAYM_PERIOD_POS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_POS());
	    log.info("PAYM_PERIOD_NBR	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_PERIOD_NBR());
	    log.info("GracePeriod 	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("GracePeriodicity:	" + islamicCalculatorEventMgmtCO.getGracePeriodicity());
	    log.info("PAYMENT_TYPE	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYMENT_TYPE());
	    log.info("CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    log.info("DEAL AMOUNT/FINANCING	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("NO_OF_PAYMENTS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
	    log.info("PAYMDAY	:	" + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getPAYM_DAY());
	    log.info("StartDate 	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("Financing Amount 	:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("SumofcapitalamountRepayment 	:	"
		    + islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment());
	    if(islamicCalculatorEventMgmtCO.getSumOfCapitalAmtRepayment() == null)
	    {
		islamicCalculatorEventMgmtCO.setSumOfCapitalAmtRepayment(BigDecimal.ZERO);
	    }
	    // TP#221204;Arun.R.Variyath;18/09/2014 [Start]
	    if(strRepaymentCharges != null && StringUtil.isNotEmpty(strRepaymentCharges))
	    {

		GridUpdates gridRepaymentData = getGridUpdates(strRepaymentCharges, TRSPAYPLAN_CRITERIAVO.class, true);//
		List<TRSPAYPLAN_CRITERIAVO> testlist = gridRepaymentData.getLstAllRec();
		for(TRSPAYPLAN_CRITERIAVO aTRSPAYPLAN_CRITERIAVO : testlist)
		{
		    if(aTRSPAYPLAN_CRITERIAVO.getPAYM_PERIODICITY().equals("Days"))
		    {
			aTRSPAYPLAN_CRITERIAVO.setPAYM_PERIODICITY("D");
		    }
		    // Months Quarterly Semi Annually Weeks
		    if(aTRSPAYPLAN_CRITERIAVO.getPAYMENT_TYPE().equals("Principal+Profit"))
		    {
			aTRSPAYPLAN_CRITERIAVO.setPAYMENT_TYPE("B");
		    }
		    // Principal+Profit
		}

		islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVO(testlist);
	    }
	    // TP#221204;Arun.R.Variyath;18/09/2014 [End]
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeRepaymentCriteriaPaymentType(islamicCalculatorEventMgmtCO);
	    log.info(
		    "================Output============populateOnChangeRepaymentCriteriaPaymentType============================");
	    log.info("Output CAPITAL_AMT	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getCAPITAL_AMT());
	    log.info("Output NO_OF_PAYMENTS	:	"
		    + islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVOObject().getNO_OF_PAYMENTS());
	    log.info("========================================================");

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "populateOnChangeRepaymentCriteriaPaymentType";
    }

    /**
     * Method for handling the change event for the
     * populateOnChangeDealChargesGridCurrencyAmount
     * 
     * @return
     */
    public String populateOnChangeDealChargesGridCurrencyAmount()
    {
	/*
	 * try{ //SessionCO sessionCO = returnSessionObject();
	 * 
	 * 
	 * } catch (Exception e) { islamicCalculatorEventMgmtCO = new
	 * IslamicCalculatorEventMgmtCO(); handleException(e, null, null); }
	 */
	return "populateOnChangeRepaymentCriteriaPaymentType";
    }

    /**
     * Method for handling the change event for the deal charges grid all are
     * calling one method
     * 
     * @return
     */
    public String populateOnChangeDealChargesGridAmounts()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    iisDealChargesCO.setCompCode(sessionCO.getCompanyCode());
	    iisDealChargesCO.setBranchCode(sessionCO.getBranchCode());
	    iisDealChargesCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    NumberUtil.resetEmptyValues(iisDealChargesCO);
	    // iisDealChargesCO.getTrsDealChargesCO().setCHARGES_CODE(new
	    // BigDecimal(12));
	    log.info("productclass	:	" + iisDealChargesCO.getProductClass());
	    log.info("cif 	:	" + iisDealChargesCO.getCifNo());
	    log.info("maturity	:	" + iisDealChargesCO.getMaturityDate());
	    log.info("startdate	:	" + iisDealChargesCO.getValueDate());
	    log.info("currency	:	" + iisDealChargesCO.getCurrency());
	    log.info("downpaymentamount	:	" + iisDealChargesCO.getDownPaymentAmount());
	    log.info("dealamount	:	" + iisDealChargesCO.getDealAmount());
	    log.info("CHARGES_CODE	:	" + iisDealChargesCO.getTrsDealChargesCO().getCHARGES_CODE());
	    log.info("CURRENCY	:	" + iisDealChargesCO.getTrsDealChargesCO().getCR_ACC_CURRENCY());
	    log.info("CHARGES_AMOUNT	:	" + iisDealChargesCO.getTrsDealChargesCO().getCHARGES_AMOUNT());
	    log.info("callType	:	" + iisDealChargesCO.getCallType());

	    iisDealChargesBO.validateDealChargesGridInputs(iisDealChargesCO);
	    trsDealChargesCO = iisDealChargesBO.calculateDealChargesForGrid(iisDealChargesCO);

	    log.info("OUTPUT CHARGES_AMOUNT	:	" + trsDealChargesCO.getCHARGES_AMOUNT());
	    log.info("OUTPUT CHARGES_AMT_FC	:	" + trsDealChargesCO.getCHARGES_AMT_FC());
	    log.info("OUTPUT CHARGES_AMT_CV	:	" + trsDealChargesCO.getCHARGES_AMT_CV());
	}
	catch(Exception e)
	{
	    trsDealChargesCO = new TrsDealChargesCO();
	    handleException(e, null, null);

	}
	return "populateOnChangeDealChargesGridAmounts";
    }

    /**
     * Method for handling the change event for the validateFieldsForDealCharges
     * for submit
     * 
     * @return
     */

    public String validateFieldsForDealCharges()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    log.info("validateFieldsForDealCharges");
	    log.info("ProductClass:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("vatcode:	" + islamicCalculatorEventMgmtCO.getVatCode());
	    log.info("vat include :	" + islamicCalculatorEventMgmtCO.getIncludeVatinInstallment());
	    log.info("cif no	:	" + islamicCalculatorEventMgmtCO.getCifNo());
	    log.info("currency:	" + islamicCalculatorEventMgmtCO.getCurrencyCode());
	    log.info("running date :	" + islamicCalculatorEventMgmtCO.getRunningDate());
	    log.info("ProductClass:	" + islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
	    log.info("Finincing amount:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());
	    log.info("Yield:	" + islamicCalculatorEventMgmtCO.getYield());
	    log.info("profit calc :	" + islamicCalculatorEventMgmtCO.getProfitCalcMethod());
	    log.info("totalflat rate :	" + islamicCalculatorEventMgmtCO.getTotalFlatRate());
	    log.info("getFirstPaymentDate :	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());

	    islamicCalculatorEventMgmtCO = iisCommonBO.validateFieldsForDealCharges(islamicCalculatorEventMgmtCO);
	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateFieldsForDealCharges";
    }

    /**
     * Method for handling the change event for the
     * validateMaxFinancingAmountForDealCharges for submit
     * 
     * @return
     */

    public String validateMaxFinancingAmountForDealCharges()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("validateMaxFinancingAmountForDealCharges");
	    log.info("ProductClass:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("Finaning amount:	" + islamicCalculatorEventMgmtCO.getFinancingAmount());

	    islamicCalculatorEventMgmtCO = iisCommonBO
		    .validateMaxFinancingAmountForDealCharges(islamicCalculatorEventMgmtCO);

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateMaxFinancingAmountForDealCharges";
    }

    /**
     * Method for handling the change event for the
     * validateNoOfPaymentsForDealCharges for submit
     * 
     * @return
     */

    public String validateNoOfPaymentsForDealCharges()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);

	    log.info("validateNoOfPaymentsForDealCharges");
	    log.info("ProductClass:	" + islamicCalculatorEventMgmtCO.getProductClass());
	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("noofpayments	:	" + islamicCalculatorEventMgmtCO.getNoOfPayments());
	    log.info("StartDate	:	" + islamicCalculatorEventMgmtCO.getStartDate());
	    log.info("Branch	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    log.info("MaturityDate	:	" + islamicCalculatorEventMgmtCO.getMaturityDate());
	    log.info("graceperiod	:	" + islamicCalculatorEventMgmtCO.getGracePeriod());
	    log.info("yield	:	" + islamicCalculatorEventMgmtCO.getYield());
	    log.info("noof ballonpayments	:	" + islamicCalculatorEventMgmtCO.getNoOfBaloonPayments());
	    log.info("baloonamount	:	" + islamicCalculatorEventMgmtCO.getBaloonAmount());
	    log.info("firstpay date 	:	" + islamicCalculatorEventMgmtCO.getFirstPaymentDate());

	    // TODO remove the hard coded
	    islamicCalculatorEventMgmtCO.setYieldRequired("N");
	    // GridUpdates gridData = getGridUpdates(strBalloonDetails,
	    // TrsPlanBallonPaymentCO.class, true);// Ballon
	    // // details
	    // islamicCalculatorEventMgmtCO.setBalloonDetailsList(gridData.getLstAllRec());

	    // TP#221204;Arun.R.Variyath;18/09/2014 [Start]
	    if(strBalloonDetails != null && StringUtil.isNotEmpty(strBalloonDetails))
	    {
		GridUpdates gridData = getGridUpdates(strBalloonDetails, TrsPlanBallonPaymentCO.class, true);// Balloon
		// details
		islamicCalculatorEventMgmtCO.setBalloonDetailsList(gridData.getLstAllRec());
	    }
	    // TP#221204;Arun.R.Variyath;18/09/2014 [Start]
	    if(strRepaymentCharges != null && StringUtil.isNotEmpty(strRepaymentCharges))
	    {
		GridUpdates gridRepaymentData = getGridUpdates(strRepaymentCharges, TRSPAYPLAN_CRITERIAVO.class, true);// Ballon

		// details
		List<TRSPAYPLAN_CRITERIAVO> testlist = gridRepaymentData.getLstAllRec();
		for(TRSPAYPLAN_CRITERIAVO aTRSPAYPLAN_CRITERIAVO : testlist)
		{
		    if(aTRSPAYPLAN_CRITERIAVO.getPAYM_PERIODICITY().equals("Days"))
		    {
			aTRSPAYPLAN_CRITERIAVO.setPAYM_PERIODICITY("D");
		    }
		    // Months Quarterly Semi Annually Weeks
		    if(aTRSPAYPLAN_CRITERIAVO.getPAYMENT_TYPE().equals("Principal+Profit"))
		    {
			aTRSPAYPLAN_CRITERIAVO.setPAYMENT_TYPE("B");
		    }
		    // Principal+Profit
		}
		islamicCalculatorEventMgmtCO.setTrsPayplanCriteriaVO(testlist);
	    }
	    islamicCalculatorEventMgmtCO = iisCommonBO.validateNoOfPaymentsForDealCharges(islamicCalculatorEventMgmtCO);

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateNoOfPaymentsForDealCharges";
    }

    public String showWarningForCifSalaryMultiple()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    log.info("compCode	:	" + islamicCalculatorEventMgmtCO.getCompCode());
	    log.info("Branch	:	" + islamicCalculatorEventMgmtCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = iisCommonBO.showWarningForCifSalaryMultiple(islamicCalculatorEventMgmtCO);

	    if(islamicCalculatorEventMgmtCO.getConfirmationMessageId() != null)
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId(returnCommonLibBO().returnTranslErrorMessage(
			NumberUtil.toInteger(islamicCalculatorEventMgmtCO.getConfirmationMessageId()),
			sessionCO.getLanguage()));
	    }

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "showWarningForCifSalaryMultiple";
    }

    public String validateForCifSalaryMultiple()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    // TP#641609; Saheer.Naduthodi; 19/03/2018 [Begin]
	    if(StringUtil.isNotEmpty(custGuarLiabilityListDet))
	    {
		GridUpdates gridData = getGridUpdates(custGuarLiabilityListDet,
			IslamicCalculatorCustGuarLiabilitiesListCO.class, true);
		islamicCalculatorEventMgmtCO.setCustGuarLiabilityList(gridData.getLstAllRec());
	    }

	    if(islamicCalculatorEventMgmtCO.getCustGuarLiabilityList() != null
		    && !islamicCalculatorEventMgmtCO.getCustGuarLiabilityList().isEmpty()
		    && (NumberUtil
			    .nullToZero(islamicCalculatorEventMgmtCO.getCustGuarLiabilityList().get(0)
				    .getTrsdealCustGuarLiabilitiesVO().getINSTALLMENT_AMOUNT())
			    .compareTo(BigDecimal.ZERO) > 0))
	    {
		islamicCalculatorEventMgmtCO.setTotalExstInstAmt(islamicCalculatorEventMgmtCO.getCustGuarLiabilityList()
			.get(0).getTrsdealCustGuarLiabilitiesVO().getINSTALLMENT_AMOUNT());
	    }
	    // TP#641609; Saheer.Naduthodi; 19/03/2018 [End]
	    islamicCalculatorEventMgmtCO = iisCommonBO.validateForCifSalaryMultiple(islamicCalculatorEventMgmtCO);

	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "validateForCifSalaryMultiple";
    }

    /**
     * @author saheer.naduthodi
     * @BB130089:14/05/2015
     */
    public String validateGeneralCustmerLimit()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    // BB130272 Modification;Ravikant.Singh;19/05/2015
	    if(custGuarLiabilityListDet != null && !custGuarLiabilityListDet.isEmpty())
	    {
		GridUpdates gridData = getGridUpdates(custGuarLiabilityListDet,
			IslamicCalculatorCustGuarLiabilitiesListCO.class, true);
		islamicCalculatorEventMgmtCO.setCustGuarLiabilityList(gridData.getLstAllRec());
	    }
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    if(!StringUtil.isNotEmpty(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom())
		    || !"DEAL_AMOUNT_EXCEED_GENERAL_CUSTOMER_LIMIT"
			    .equals(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom()))
	    {
		IISCustomerLimitCO iisCustomerLimitCO = new IISCustomerLimitCO();
		iisCustomerLimitCO.setCompCode(sessionCO.getCompanyCode());
		iisCustomerLimitCO.setBranchCode(sessionCO.getBranchCode());
		iisCustomerLimitCO.setCifNo(islamicCalculatorEventMgmtCO.getCifNo());
		iisCustomerLimitCO.setDealAmount(islamicCalculatorEventMgmtCO.getFinancingAmount());
		iisCustomerLimitCO.setDealCY(islamicCalculatorEventMgmtCO.getCurrencyCode());
		iisCustomerLimitCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
		iisCustomerLimitCO.setBaseCurrencyDesc(sessionCO.getBaseCurrencyName());
		iisCustomerLimitCO.setRunningDate(sessionCO.getRunningDateRET());
		/** BB Production Issue; Saheer.Naduthodi; 12/11/2018 <Begin> */
		iisCustomerLimitCO.setDealNo(islamicCalculatorEventMgmtCO.getDealNo());
		/** BB Production Issue; Saheer.Naduthodi; 12/11/2018 <End> */
		if(islamicCalculatorEventMgmtCO.getCustGuarLiabilityList() != null
			&& !islamicCalculatorEventMgmtCO.getCustGuarLiabilityList().isEmpty()
			&& (NumberUtil
				.nullToZero(islamicCalculatorEventMgmtCO.getCustGuarLiabilityList().get(0)
					.getTrsdealCustGuarLiabilitiesVO().getTOTAL_FINANCED_AMT())
				.compareTo(BigDecimal.ZERO) > 0))
		{
		    iisCustomerLimitCO.setRemainingAmount(islamicCalculatorEventMgmtCO.getCustGuarLiabilityList().get(0)
			    .getTrsdealCustGuarLiabilitiesVO().getTOTAL_FINANCED_AMT());
		}

		iisCommonBO.validateGeneralCustomerLimit(iisCustomerLimitCO);
		iisCustomerLimitCO = null;
	    }
	}
	catch(BOException ex)
	{
	    String msgIdent;
	    msgIdent = (ex).getMsgIdent();
	    if(msgIdent != null)
	    {
		setConfirmType(msgIdent);
	    }
	    handleException(ex, null, null);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "success";
    }

    public String calculateAnnualFloatingMarginRates()
    {
	SessionCO sessionCO = null;
	BigDecimal currencyCode = null;
	try
	{
	    sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    currencyCode = islamicCalculatorEventMgmtCO.getCurrencyCode();
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .calculateAnnualFloatingMarginRates(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .populateOnChangeYield(islamicCalculatorEventMgmtCO);
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    currencyCode == null ? sessionCO.getBaseCurrencyCode() : currencyCode);
	}
	catch(Exception e)
	{
	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);//
	    handleException(e, null, null);
	}

	return "calculateAnnualFloatingMarginRates";
    }

    /*****
     * Method for calculating the annual flat rate on the onchange event of
     * profit calc method
     * 
     * @return
     */
    public String calculateTotalAnnualYield()
    {
	try
	{
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = iisCommonBO.calculateTotalAnnualYield(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "success";
    }

    /**
     * Method for setting the IslamicCalculatorEventMgmtBO
     * 
     * @param islamicCalculatorEventMgmtBO
     */
    public void setIslamicCalculatorEventMgmtBO(IslamicCalculatorEventMgmtBO islamicCalculatorEventMgmtBO)
    {
	this.islamicCalculatorEventMgmtBO = islamicCalculatorEventMgmtBO;
    }

    /**
     * Getter method for IslamicCalculatorEventMgmtCO
     * 
     * @return islamicCalculatorEventMgmtCO
     */

    @Override
    public IslamicCalculatorEventMgmtCO getModel()
    {
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Getter method for IslamicCalculatorEventMgmtCO
     * 
     * @return islamicCalculatorEventMgmtCO
     */
    public IslamicCalculatorEventMgmtCO getIslamicCalculatorEventMgmtCO()
    {
	return islamicCalculatorEventMgmtCO;
    }

    public String dependencyByTradingCurrencyCode()
    {
	try
	{
	    if(islamicCalculatorEventMgmtCO.getTradingCurrency() != null)
	    {
		SessionCO sessionCO = returnSessionObject();
		islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
		islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
		islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
		islamicCalculatorEventMgmtCO.setCurrencyCode(sessionCO.getBaseCurrencyCode());
		islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
			.dependencyByTradingCurrencyCode(islamicCalculatorEventMgmtCO);
		if(islamicCalculatorEventMgmtCO != null)
		{
		    // setDecimalFormatBySelectedCurrency(sessionCO,
		    // islamicCalculatorEventMgmtCO.getTradingCurrency());
		    setAdditionalScreenParams(islamicCalculatorEventMgmtCO.getHmSysParam());

		}
	    }
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String dependencyByCurrencyCode()
    {
	try
	{
	    if(islamicCalculatorEventMgmtCO.getCurrencyCode() != null)
	    {
		SessionCO sessionCO = returnSessionObject();
		islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
		islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
		islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
			.dependencyByCurrencyCode(islamicCalculatorEventMgmtCO);
		if(islamicCalculatorEventMgmtCO != null)
		{
		    setDecimalFormatBySelectedCurrency(sessionCO, islamicCalculatorEventMgmtCO.getCurrencyCode());
		}
	    }
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /****
     * Method for getting the currency decimal format - decimal points based on
     * currency While throwing BO Exception..
     * 
     * @param sessionCO
     * @param currencyCode
     */
    private void setDecimalFormatBySelectedCurrencyOnException(SessionCO sessionCO)
    {
	try
	{
	    setDecimalFormatBySelectedCurrency(sessionCO,
		    islamicCalculatorEventMgmtCO.getCurrencyCode() == null ? sessionCO.getBaseCurrencyCode()
			    : islamicCalculatorEventMgmtCO.getCurrencyCode());//
	}
	catch(Exception e1)
	{
	    handleException(e1, null, null);
	}
    }

    /****
     * Method for getting the currency decimal format - decimal points based on
     * 
     * @param sessionCO
     * @param CurrencyCode
     * @throws BaseException
     */
    private void setDecimalFormatBySelectedCurrency(SessionCO sessionCO, BigDecimal currencyCode) throws BaseException
    {
	CURRENCIESVO currenciesVO = new CURRENCIESVO();
	currenciesVO.setCOMP_CODE(returnSessionObject().getCompanyCode());
	// currenciesVO.setCURRENCY_CODE(currencyCode == null ?
	// sessionCO.getBaseCurrencyCode() : currencyCode);
	if(currencyCode == null || currencyCode.compareTo(BigDecimal.ZERO) == -1)
	{
	    currenciesVO.setCURRENCY_CODE(sessionCO.getBaseCurrencyCode());
	}
	else
	{
	    currenciesVO.setCURRENCY_CODE(currencyCode);
	}

	CURRENCIESVO currencyVO = returnCommonLibBO().returnCurrency(currenciesVO);
	islamicCalculatorEventMgmtCO.setCurrencyDesc(currencyVO.getBRIEF_DESC_ENG());
	islamicCalculatorEventMgmtCO.setCurrencyDecimalPointsForCalc(currencyVO.getDECIMAL_POINTS());

	String currecnyMask = NumberUtil.currencyMask(currencyVO.getDECIMAL_POINTS());

	applyColumnProperties("financingAmount", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());
	applyColumnProperties("downPaymentAmount", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());
	applyColumnProperties("remainingAmount", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	applyColumnProperties("contractPrice", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	applyColumnProperties("profitCollected", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());
	applyColumnProperties("billAmount", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	applyColumnProperties("Total_Bill_Amount", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam.setDecFormat(NumberUtil.currencyMask(currencyVO.getDECIMAL_POINTS()));
	// sysParam.setELEMENT_NAME("financingAmount");
	// getAdditionalScreenParams().put("financingAmount", sysParam);
	// sysParam.setELEMENT_NAME("downPaymentAmount");
	// getAdditionalScreenParams().put("downPaymentAmount", sysParam);
	// sysParam.setELEMENT_NAME("remainingAmount");
	// getAdditionalScreenParams().put("remainingAmount", sysParam);

	// sysParam.setELEMENT_NAME("saleAmount");
	// getAdditionalScreenParams().put("saleAmount", sysParam);
	// sysParam.setELEMENT_NAME("profit");
	// getAdditionalScreenParams().put("profit", sysParam);
	// sysParam.setELEMENT_NAME("amountPerPayment");
	// getAdditionalScreenParams().put("amountPerPayment", sysParam);

	applyColumnProperties("saleAmount", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());
	applyColumnProperties("profit", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());
	applyColumnProperties("amountPerPayment", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam.setELEMENT_NAME("xirr");
	// getAdditionalScreenParams().put("xirr", sysParam);
	applyColumnProperties("xirr", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam.setELEMENT_NAME("baloonAmount");
	// getAdditionalScreenParams().put("baloonAmount", sysParam);
	applyColumnProperties("baloonAmount", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam.setELEMENT_NAME("purchaseAmount");
	// getAdditionalScreenParams().put("purchaseAmount", sysParam);
	applyColumnProperties("purchaseAmount", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam.setELEMENT_NAME("amountPerPaymentResult");
	// getAdditionalScreenParams().put("amountPerPaymentResult", sysParam);
	applyColumnProperties("amountPerPaymentResult", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam.setELEMENT_NAME("debtBurdanRatio");
	// getAdditionalScreenParams().put("debtBurdanRatio", sysParam);
	applyColumnProperties("debtBurdanRatio", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam.setELEMENT_NAME("approvedSalary");
	// getAdditionalScreenParams().put("approvedSalary", sysParam);
	applyColumnProperties("approvedSalary", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam.setELEMENT_NAME("insuranceChargesAmount");
	// getAdditionalScreenParams().put("insuranceChargesAmount", sysParam);
	applyColumnProperties("insuranceChargesAmount", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam.setELEMENT_NAME("chargeAmount");
	// getAdditionalScreenParams().put("chargeAmount", sysParam);
	applyColumnProperties("chargeAmount", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam.setELEMENT_NAME("insuranceChargesAmount");
	// getAdditionalScreenParams().put("insuranceChargesAmount", sysParam);
	applyColumnProperties("insuranceChargesAmount", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	// sysParam.setDecFormat(NumberUtil.currencyMask(new BigDecimal(12)));
	// sysParam.setELEMENT_NAME("xirr");
	// getAdditionalScreenParams().put("xirr", sysParam);

	currecnyMask = NumberUtil.currencyMask(BigDecimal.valueOf(12));
	applyColumnProperties("xirr", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());
	// for TAR : IIAB130173
	applyColumnProperties("XIRR_With_Charges", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());
	// sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	// sysParam.setDecFormat(NumberUtil.currencyMask(new BigDecimal(8)));
	// sysParam.setELEMENT_NAME("margin");
	// getAdditionalScreenParams().put("margin", sysParam);

	currecnyMask = NumberUtil.currencyMask(BigDecimal.valueOf(8));
	applyColumnProperties("margin", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	// sysParam.setDecFormat(NumberUtil.currencyMask(new BigDecimal(8)));
	// sysParam.setELEMENT_NAME("annualYieldRate");
	// getAdditionalScreenParams().put("annualYieldRate", sysParam);

	applyColumnProperties("annualYieldRate", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	// sysParam.setDecFormat(NumberUtil.currencyMask(new BigDecimal(8)));
	// sysParam.setELEMENT_NAME("floatingRate");
	// getAdditionalScreenParams().put("floatingRate", sysParam);

	applyColumnProperties("floatingRate", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	applyColumnProperties("discountPerc", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	// sysParam.setDecFormat(NumberUtil.currencyMask(new BigDecimal(6)));
	// sysParam.setELEMENT_NAME("annualFlatRate");
	// getAdditionalScreenParams().put("annualFlatRate", sysParam);

	currecnyMask = NumberUtil.currencyMask(BigDecimal.valueOf(6));
	applyColumnProperties("annualFlatRate", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam.setELEMENT_NAME("totalFlatRate");
	// getAdditionalScreenParams().put("totalFlatRate", sysParam);

	applyColumnProperties("totalFlatRate", IISCommonConstants.ACTION_TYPE_CURRENCYFORMAT, currecnyMask,
		islamicCalculatorEventMgmtCO.getHmSysParam());

	// sysParam = new SYS_PARAM_SCREEN_DISPLAYVO();
	// sysParam.setDecFormat(NumberUtil.currencyMask(new BigDecimal(3)));
	// sysParam.setELEMENT_NAME("downPaymentPercentage");
	// getAdditionalScreenParams().put("downPaymentPercentage", sysParam);

	getAdditionalScreenParams().putAll(islamicCalculatorEventMgmtCO.getHmSysParam());
    }

    public String onChangeOfActualGracePeriod()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeActualGracePeriod(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    // islamicCalculatorEventMgmtCO = new
	    // IslamicCalculatorEventMgmtCO();
	    islamicCalculatorEventMgmtCO.setGracePeriodActual(null);
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * setter method for IslamicCalculatorEventMgmtCO
     * 
     * @param islamicCalculatorEventMgmtCO
     */
    public void setIslamicCalculatorEventMgmtCO(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
    {
	this.islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCO;
    }

    public String printCalculateScreen()
    {
	SessionCO sessionCO = returnSessionObject();
	islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	islamicCalculatorEventMgmtCO.setUserId(sessionCO.getUserName());
	islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	islamicCalculatorEventMgmtCO.setAppName(sessionCO.getCurrentAppName());
	try
	{
	    islamicCalculatorEventMgmtCO.setSaleAmount(calculatorCO.getOutSaleAmount());
	    islamicCalculatorEventMgmtCO.setAmountPerPayment(calculatorCO.getOutAmountPerPayment());
	    islamicCalculatorEventMgmtCO.setProfit(calculatorCO.getOutProfitAmount());
	    islamicCalculatorEventMgmtCO.setConfirmMessagesArryList(null);
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .printCalculateScreen(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // TP# 241462 ;Ravikant.Singh;26/11/2014[start]
    public String validateCifBlackListedOrNot()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    iisCommonCO.setCompCode(sessionCO.getCompanyCode());
	    iisCommonCO.setBranchCode(sessionCO.getBranchCode());
	    iisCommonCO.setCifNo(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getCifNo()));
	    iisCommonCO.setValue(IISCommonConstants.MESSAGE_TYPEWARNING);
	    iisCommonCO = iisCommonBO.isBlackListed(iisCommonCO);
	}
	catch(BOException ex)
	{
	    String msgIdent;
	    msgIdent = (ex).getMsgIdent();
	    if(msgIdent != null)
	    {
		setConfirmType(msgIdent);
	    }
	    handleException(ex, null, null);
	}

	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // TP# 241462 ;Ravikant.Singh;26/11/2014[end]
    // #TAR JAIZ140012 #TP251229 Arun R Variyath ; 05/08/2015 [Start]
    public String onChangeProfitRecognitionMethod()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeProfitRecognitionMethod(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String onChangeAccrualBasis()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeAccrualBasis(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // #TAR JAIZ140012 #TP251229 Arun R Variyath ; 05/08/2015 [End]

    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 **/
    public String onChangeTopUpDealSelYN()
    {
	SessionCO sessionCO = returnSessionObject();
	islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	if(StringUtil.isNotEmpty(islamicCalculatorEventMgmtCO.getTopUpGridData()))
	{
	    GridUpdates gridData = getGridUpdates(islamicCalculatorEventMgmtCO.getTopUpGridData(),
		    IslamicCalculatorEventMgmtCO.class, true);
	    islamicCalculatorEventMgmtCO.setTopUpGridList(gridData.getLstAllRec());
	}
	try
	{
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeTopUpDealSelYN(islamicCalculatorEventMgmtCO);
	}
	catch(BaseException e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 **/
    public String onChangeReimburseProfitPerc()
    {
	SessionCO sessionCO = returnSessionObject();
	islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	try
	{
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeReimburseProfitPerc(islamicCalculatorEventMgmtCO);
	}
	catch(BaseException e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /** BB150217 - Rescheduling and Loan Buyout CR105585 TP # 412619 **/
    public String onChangeReimburseProfitAmount()
    {
	SessionCO sessionCO = returnSessionObject();
	islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	NumberUtil.resetEmptyValues(islamicCalculatorEventMgmtCO);
	try
	{
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeReimburseProfitAmount(islamicCalculatorEventMgmtCO);
	}
	catch(BaseException e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);

	}
	return SUCCESS;
    }

    public String onChangeBuyOutBankCifNo()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeBuyOutBankCifNo(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String onChangeBuyOutDealCy()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    islamicCalculatorEventMgmtCO.setRunningDate(sessionCO.getRunningDateRET());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeBuyOutDealCy(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String onChangeBuyOutDealAmount()
    {
	try
	{
	    islamicCalculatorEventMgmtCO.setCompCode(returnSessionObject().getCompanyCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeBuyOutDealAmount(islamicCalculatorEventMgmtCO);
	    setAdditionalScreenParams(islamicCalculatorEventMgmtCO.getHmSysParam());
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String onChangeCrossCyExchRate()
    {
	try
	{
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeCrossCyExchRate(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String onChangeTrAccountBranch()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeTrAccountBranch(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String onChangeTrAccountCy()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeTrAccountCy(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String onChangeTrAccountGl()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeTrAccountGl(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String onChangeTrAccountCif()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeTrAccountCif(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String onChangeTrAccountSl()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtBO
		    .onChangeTrAccountSl(islamicCalculatorEventMgmtCO);
	}
	catch(Exception e)
	{
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
	
	 // TP#1022246 BAJI200012 Fawas.kuruvakkottil 10/07/2020 <START>
    public String onChangeDownPaymentToVendorPercentage()
    {
	SessionCO sessionCO = null;
	try
	{
	    sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getPurchaseAmount()).compareTo(BigDecimal.ZERO) > 0)
	    {
		BigDecimal downPaymentToVendor = NumberUtil
			.nullToZero(islamicCalculatorEventMgmtCO.getDownPaymentToVendorPerc())
			.multiply(islamicCalculatorEventMgmtCO.getPurchaseAmount()).divide(BigDecimal.valueOf(100),
				BigDecimal.ROUND_HALF_UP, sessionCO.getBaseCurrDecPoint().intValue());
		BigDecimal totalDownPayment = NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getDownPaymentAmount())
			.add(downPaymentToVendor);
		BigDecimal totalDownPaymentPerc = totalDownPayment
			.divide(islamicCalculatorEventMgmtCO.getPurchaseAmount(), BigDecimal.ROUND_HALF_UP,
				sessionCO.getBaseCurrDecPoint().intValue())
			.multiply(BigDecimal.valueOf(100));
		islamicCalculatorEventMgmtCO.setDownPaymentToVendor(downPaymentToVendor);
		islamicCalculatorEventMgmtCO.setTotalDownPaymentPerc(totalDownPaymentPerc);
		islamicCalculatorEventMgmtCO.setTotalDownPayment(totalDownPayment);
		islamicCalculatorEventMgmtCO.setFinancingAmount(
			islamicCalculatorEventMgmtCO.getPurchaseAmount().subtract(totalDownPayment));
	    }

	}
	catch(Exception e)
	{
	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);// APPLY
	    // DECIMAL
	    // FORMAT
	    // BASED ON
	    // CURRENCY
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeDownPaymentToVendorPercentage";
    }

    public String onChangeDownPaymentToVendor()
    {
	SessionCO sessionCO = null;
	try
	{
	    sessionCO = returnSessionObject();
	    islamicCalculatorEventMgmtCO.setCompCode(sessionCO.getCompanyCode());
	    islamicCalculatorEventMgmtCO.setBranchCode(sessionCO.getBranchCode());
	    islamicCalculatorEventMgmtCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    if(NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getPurchaseAmount()).compareTo(BigDecimal.ZERO) > 0)
	    {
		BigDecimal downPaymentToVendorPerc = NumberUtil
			.nullToZero(islamicCalculatorEventMgmtCO.getDownPaymentToVendor())
			.divide(islamicCalculatorEventMgmtCO.getPurchaseAmount(), BigDecimal.ROUND_HALF_UP,
				sessionCO.getBaseCurrDecPoint().intValue())
			.multiply(BigDecimal.valueOf(100));
		BigDecimal totalDownPayment = NumberUtil.nullToZero(islamicCalculatorEventMgmtCO.getDownPaymentAmount())
			.add(islamicCalculatorEventMgmtCO.getDownPaymentToVendor());
		BigDecimal totalDownPaymentPerc = totalDownPayment
			.divide(islamicCalculatorEventMgmtCO.getPurchaseAmount(), BigDecimal.ROUND_HALF_UP,
				sessionCO.getBaseCurrDecPoint().intValue())
			.multiply(BigDecimal.valueOf(100));
		islamicCalculatorEventMgmtCO.setDownPaymentToVendorPerc(downPaymentToVendorPerc);
		islamicCalculatorEventMgmtCO.setTotalDownPaymentPerc(totalDownPaymentPerc);
		islamicCalculatorEventMgmtCO.setTotalDownPayment(totalDownPayment);
		islamicCalculatorEventMgmtCO.setFinancingAmount(
			islamicCalculatorEventMgmtCO.getPurchaseAmount().subtract(totalDownPayment));
	    }
	}
	catch(Exception e)
	{
	    setDecimalFormatBySelectedCurrencyOnException(sessionCO);// APPLY
	    // DECIMAL
	    // FORMAT
	    // BASED ON
	    // CURRENCY
	    islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	    handleException(e, null, null);
	}
	return "onChangeDownPaymentToVendor";
	// TP#1022246 BAJI200012 Fawas.kuruvakkottil 10/07/2020<END>
    }


    /**
     * setter method for IISCommonBO
     * 
     * @param iisCommonBO
     */
    public void setIisCommonBO(IISCommonBO iisCommonBO)
    {
	this.iisCommonBO = iisCommonBO;
    }

    /**
     * Getter method for IISCommonCO
     * 
     * @return
     */
    public IISCommonCO getIisCommonCO()
    {
	return iisCommonCO;
    }

    /**
     * setter method for IISCommonCO
     * 
     * @param iisCommonCO
     */
    public void setIisCommonCO(IISCommonCO iisCommonCO)
    {
	this.iisCommonCO = iisCommonCO;
    }

    public String getStrDealCharges()
    {
	return strDealCharges;
    }

    public void setStrDealCharges(String strDealCharges)
    {
	this.strDealCharges = strDealCharges;
    }

    public String getStrRepaymentCharges()
    {
	return strRepaymentCharges;
    }

    public void setStrRepaymentCharges(String strRepaymentCharges)
    {
	this.strRepaymentCharges = strRepaymentCharges;
    }

    public IslamicCalculatorCO getCalculatorCO()
    {
	return calculatorCO;
    }

    public void setCalculatorCO(IslamicCalculatorCO calculatorCO)
    {
	this.calculatorCO = calculatorCO;
    }

    public void setIisIslamicCalculatorBO(IISIslamicCalculatorBO iisIslamicCalculatorBO)
    {
	this.iisIslamicCalculatorBO = iisIslamicCalculatorBO;
    }

    public IisDealChargesCO getIisDealChargesCO()
    {
	return iisDealChargesCO;
    }

    public void setIisDealChargesCO(IisDealChargesCO iisDealChargesCO)
    {
	this.iisDealChargesCO = iisDealChargesCO;
    }

    public void setIisDealChargesBO(IISDealChargesBO iisDealChargesBO)
    {
	this.iisDealChargesBO = iisDealChargesBO;
    }

    public TrsDealChargesCO getTrsDealChargesCO()
    {
	return trsDealChargesCO;
    }

    public void setTrsDealChargesCO(TrsDealChargesCO trsDealChargesCO)
    {
	this.trsDealChargesCO = trsDealChargesCO;
    }

    public String getStrConfirm()
    {
	return strConfirm;
    }

    public void setStrConfirm(String strConfirm)
    {
	this.strConfirm = strConfirm;
    }

    public String getStrBalloonDetails()
    {
	return strBalloonDetails;
    }

    public void setStrBalloonDetails(String strBalloonDetails)
    {
	this.strBalloonDetails = strBalloonDetails;
    }

    public String getStrBalloonDate()
    {
	return strBalloonDate;
    }

    public void setStrBalloonDate(String strBalloonDate)
    {
	this.strBalloonDate = strBalloonDate;
    }

    public MemoSC get_memo()
    {
	return _memo;
    }

    public void set_memo(MemoSC memo)
    {
	_memo = memo;
    }

    public String getStrMultipleYieldList()
    {
	return strMultipleYieldList;
    }

    public void setStrMultipleYieldList(String strMultipleYieldList)
    {
	this.strMultipleYieldList = strMultipleYieldList;
    }

    public String getTentativeSchedule()
    {
	return tentativeSchedule;
    }

    public void setTentativeSchedule(String tentativeSchedule)
    {
	this.tentativeSchedule = tentativeSchedule;
    }

    public String getProjectFinanceDetails()
    {
	return projectFinanceDetails;
    }

    public void setProjectFinanceDetails(String projectFinanceDetails)
    {
	this.projectFinanceDetails = projectFinanceDetails;
    }

    public void setTotalAllcBlnAmt(BigDecimal totalAllcBlnAmt)
    {
	this.totalAllcBlnAmt = totalAllcBlnAmt;
    }

    public BigDecimal getTotalAllcBlnAmt()
    {
	return totalAllcBlnAmt;
    }

    public String getActiveDealCount()
    {
	return activeDealCount;
    }

    public void setActiveDealCount(String activeDealCount)
    {
	this.activeDealCount = activeDealCount;
    }

    public String getCustGuarLiabilityListDet()
    {
	return custGuarLiabilityListDet;
    }

    public void setCustGuarLiabilityListDet(String custGuarLiabilityListDet)
    {
	this.custGuarLiabilityListDet = custGuarLiabilityListDet;
    }

    public TrsdealNidcCO getTrsdealNidcCO()
    {
	return trsdealNidcCO;
    }

    public void setTrsdealNidcCO(TrsdealNidcCO trsdealNidcCO)
    {
	this.trsdealNidcCO = trsdealNidcCO;
    }

    public String getStrNIDCList()
    {
	return strNIDCList;
    }

    public void setStrNIDCList(String strNIDCList)
    {
	this.strNIDCList = strNIDCList;
    }

    public void setLinkTypeList(List linkTypeList)
    {
	this.linkTypeList = linkTypeList;
    }

    public List getLinkTypeList()
    {
	return linkTypeList;
    }

    public String getStrNIDCDetail()
    {
	return strNIDCDetail;
    }

    public void setStrNIDCDetail(String strNIDCDetail)
    {
	this.strNIDCDetail = strNIDCDetail;
    }

    public String getStrNIDCCouponPayment()
    {
	return strNIDCCouponPayment;
    }

    public void setStrNIDCCouponPayment(String strNIDCCouponPayment)
    {
	this.strNIDCCouponPayment = strNIDCCouponPayment;
    }

    public String getStrBillsDealCharges()
    {
	return strBillsDealCharges;
    }

    public void setStrBillsDealCharges(String strBillsDealCharges)
    {
	this.strBillsDealCharges = strBillsDealCharges;
    }

    public String getSettlementChargeGridData()
    {
	return settlementChargeGridData;
    }

    public void setSettlementChargeGridData(String settlementChargeGridData)
    {
	this.settlementChargeGridData = settlementChargeGridData;
    }

    public String getCompanyDomain()
    {
	return companyDomain;
    }

    public void setCompanyDomain(String companyDomain)
    {
	this.companyDomain = companyDomain;
    }

    public String getCompanyTelNo()
    {
	return companyTelNo;
    }

    public void setCompanyTelNo(String companyTelNo)
    {
	this.companyTelNo = companyTelNo;
    }

	public Object getConfirmReturn() {
		return confirmReturn;
	}

	public void setConfirmReturn(Object confirmReturn) {
		this.confirmReturn = confirmReturn;
	}

}
