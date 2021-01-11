package com.path.bo.common.iis.dealcharges.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.fms.limitscommon.FmsLimitsCommonBO;
import com.path.bo.common.iis.IISCommonConstants;
import com.path.bo.common.iis.IISReturnMessagesCO;
import com.path.bo.common.iis.dealcharges.IISDealChargesBO;
import com.path.bo.common.iis.islamiccalculator.IISCommonBO;
import com.path.dao.common.iis.dealcharges.IISDealChargesDAO;
import com.path.dbmaps.vo.CIFVOKey;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.FMSCTRLVO;
import com.path.dbmaps.vo.FMSCTRLVOKey;
import com.path.dbmaps.vo.IISCTRLVO;
import com.path.dbmaps.vo.IISCTRLVOKey;
import com.path.dbmaps.vo.PRODUCT_CLASS_LINK_CHARGESVO;
import com.path.dbmaps.vo.PRODUCT_CLASS_LINK_CHARGESVOKey;
import com.path.dbmaps.vo.TRSCHARGESVO;
import com.path.dbmaps.vo.TRSCHARGESVOKey;
import com.path.dbmaps.vo.TRSCHARGES_ROSTERVO;
import com.path.dbmaps.vo.TRSCHARGES_ROSTERVOKey;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSCLASSVOKey;
import com.path.dbmaps.vo.TRSDEALCHARGESVO;
import com.path.dbmaps.vo.TRSDEALCHARGESVOKey;
import com.path.dbmaps.vo.TRSDEALVO;
import com.path.dbmaps.vo.TRSDEALVOKey;
import com.path.dbmaps.vo.TRSPFXCHARGESVO;
import com.path.dbmaps.vo.TRSPFXCHARGESVOKey;
import com.path.dbmaps.vo.TRSVATVO;
import com.path.dbmaps.vo.TRSVATVOKey;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.fms.limitscommon.FmsLimitsInputCO;
import com.path.vo.common.iis.dealcharges.IisDealChargesCO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesCO;
import com.path.vo.common.iis.dealcharges.TrsDealChargesSC;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.dbmaps.vo.TRSDEAL_ASSET_VNDR_INCENTIVEVO;

/**
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code<br>
 * <br>
 * 
 * BO Class for IIS Deal Charges.
 * 
 * @see com.path.bo.common.iis.dealcharges.impl.IISDealChargesBOImpl
 * @author Bejoy
 * 
 */
public class IISDealChargesBOImpl extends BaseBO implements IISDealChargesBO
{
    private static final long serialVersionUID = 1L;
    private IISDealChargesDAO iisDealChargesDAO;
    private IISCommonBO iisCommonBO;
    protected FmsLimitsCommonBO fmsLimitsCommonBO;

    public FmsLimitsCommonBO getFmsLimitsCommonBO()
    {
	return fmsLimitsCommonBO;
    }

    public void setFmsLimitsCommonBO(FmsLimitsCommonBO fmsLimitsCommonBO)
    {
	this.fmsLimitsCommonBO = fmsLimitsCommonBO;
    }

    public IISCommonBO getIisCommonBO()
    {
	return iisCommonBO;
    }

    public void setIisCommonBO(IISCommonBO iisCommonBO)
    {
	this.iisCommonBO = iisCommonBO;
    }

    public IISDealChargesDAO getIisDealChargesDAO()
    {
	return iisDealChargesDAO;
    }

    public void setIisDealChargesDAO(IISDealChargesDAO iisDealChargesDAO)
    {
	this.iisDealChargesDAO = iisDealChargesDAO;
    }

    @Override
    public TrsDealChargesCO calculateDealChargesForGrid(IisDealChargesCO iisDealChargesCO) throws BaseException
    {
	List<TrsDealChargesCO> lsTrsDealChargesCO = new ArrayList<TrsDealChargesCO>();
	TrsDealChargesCO chargesCO = iisDealChargesCO.getTrsDealChargesCO();
	lsTrsDealChargesCO.add(chargesCO);
	chargesCO.setEventColumn("Y");
	// iisDealChargesCO.setCallType("O");//in case of grid events setting it
	// to O.
	iisDealChargesCO.setCompanyContributionAmount(BigDecimal.ZERO);// For
	// grid
	// events
	// set
	// the
	// amt
	// to
	// 0.

	// Calculating the charge amount
	if(lsTrsDealChargesCO != null)
	{
	    lsTrsDealChargesCO = calculateChargeAmount(lsTrsDealChargesCO, iisDealChargesCO);
	}
	if(!lsTrsDealChargesCO.isEmpty())
	{
	    chargesCO = lsTrsDealChargesCO.get(0);
	}
	lsTrsDealChargesCO = null;
	TRSCHARGESVOKey trschargesVoKey = new TRSCHARGESVOKey();
	trschargesVoKey.setCOMP_CODE(iisDealChargesCO.getCompCode());
	trschargesVoKey.setCODE(NumberUtil.emptyDecimalToZero(iisDealChargesCO.getTrsDealChargesCO().getCHARGES_CODE()));
	TRSCHARGESVO trschargesvo = (TRSCHARGESVO) genericDAO.selectByPK(trschargesVoKey);
	chargesCO.setCalcOnYerlyOutstndPrincYN("N");
	if(trschargesvo != null && "Y".equals(trschargesvo.getCALC_ON_YERLY_OUTSTND_PRINC_YN()))
	{
	    chargesCO.setCHARGES_AMOUNT(BigDecimal.ZERO);
	    chargesCO.setCalcOnYerlyOutstndPrincYN(trschargesvo.getCALC_ON_YERLY_OUTSTND_PRINC_YN());
	}
	return chargesCO;
    }

    /**
     * Method calculateDealCharges
     */
    @Override
    public List<TrsDealChargesCO> calculateDealCharges(IisDealChargesCO iisDealChargesCO) throws BaseException
    {
	List<TrsDealChargesCO> lsTrsDealChargesCO = new ArrayList<TrsDealChargesCO>();
	/*
	 * if Charges is defined at product class level ,then all charge details
	 * defined in Product Class will be defaulted to the deal charges
	 * window.
	 */
	if(iisDealChargesCO.getCallType().equals("P")) // P- product class
	{
	    lsTrsDealChargesCO = setCharges(iisDealChargesCO);
	}
	else
	// -OTHERS,ITEMCHANGED FROM DEAL CHARGES
	{
	    lsTrsDealChargesCO = iisDealChargesCO.getIisTrsdealchargesCO();
	}

	// Calculating the charge amount
	if(lsTrsDealChargesCO != null)
	{
	    lsTrsDealChargesCO = calculateChargeAmount(lsTrsDealChargesCO, iisDealChargesCO);
	}
	return lsTrsDealChargesCO;
    }

    // Invoked from calculateDealCharges
    private List<TrsDealChargesCO> setCharges(IisDealChargesCO iisDealChargesCO) throws BaseException
    {
	// Getting the charges and class details which are linked in product
	// class
	TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	trsClassVOKey.setCOMP_CODE(iisDealChargesCO.getCompCode());
	trsClassVOKey.setCODE(iisDealChargesCO.getProductClass());
	List<PRODUCT_CLASS_LINK_CHARGESVO> productClassLinkChargesVO = iisDealChargesDAO
		.getProductclassLinkCharges(trsClassVOKey);
	TRSCLASSVO trsClassVO = iisDealChargesDAO.getClassDetails(trsClassVOKey);
	trsClassVOKey = null;

	List<TrsDealChargesCO> lsTrsDealChargesCO = new ArrayList<TrsDealChargesCO>();

	String chargeType, creditToSdAccountYn;
	String payAtDealClosureYn;
	String payNetIncentPrincStlmtYn;
	BigDecimal vatCode, chargePercentage;
	BigDecimal accountBranch, accountCurrency, accountGlCode, accountCifCode, accountSlNo;
	for(int i = 0; i < productClassLinkChargesVO.size(); i++)
	{
	    // Getting the charges details which are linked in product class
	    chargeType = StringUtil.nullEmptyToValue(productClassLinkChargesVO.get(i).getCHARGE_TYPE(),
		    ConstantsCommon.NO);
	    chargePercentage = new BigDecimal(
		    NumberUtil.toDouble(productClassLinkChargesVO.get(i).getCHARGE_PERCENTAGE()));
	    creditToSdAccountYn = productClassLinkChargesVO.get(i).getCREDIT_TO_SD_ACCOUNT_YN();
	    vatCode = NumberUtil.nullToZero(productClassLinkChargesVO.get(i).getVAT_CODE());

	    // Getting the charges details directly from TRSCHARGES table
	    TRSCHARGESVOKey trschargesvoKey = new TRSCHARGESVOKey();
	    trschargesvoKey.setCOMP_CODE(iisDealChargesCO.getCompCode());
	    trschargesvoKey.setCODE(productClassLinkChargesVO.get(i).getCHARGE_CODE());
	    TRSCHARGESVO trschargesVO = null;
	    if(iisDealChargesCO.getCompCode() != null && productClassLinkChargesVO.get(i).getCHARGE_CODE() != null)
	    {
		trschargesVO = iisDealChargesDAO.getTrsChargeDetails(trschargesvoKey);
	    }
	    if(trschargesVO != null)
	    {
		trschargesvoKey = null;

		payAtDealClosureYn = trschargesVO.getPAY_AT_DEAL_CLOSURE_YN();
		creditToSdAccountYn = trschargesVO.getCREDIT_TO_SD_ACCOUNT_YN();// dupilcated???????

		// If charge percentage is not defined in product class then get
		// the percentage from TRSCHARGES table
		if(NumberUtil.toDouble(chargePercentage) == 0)
		{
		    chargePercentage = trschargesVO.getPERCENTAGE();
		}

		// Getting class details from TRSCLASS table
		if(trsClassVO.getEXCLUDE_CHARGES().equals("Y"))
		{
		    chargeType = "N";
		    //continue;
		} // TP#211333;Roshin;20/08/2014
		if((ConstantsCommon.YES.equals(chargeType)
			&& ConstantsCommon.NO.equals(trsClassVO.getEXCLUDE_CHARGES()))
			|| ConstantsCommon.YES.equals(StringUtil
				.nullEmptyToValue(trschargesVO.getPERCENTAGE_OF_PROFIT_YN(), ConstantsCommon.NO))
			|| ConstantsCommon.YES.equals(StringUtil.nullEmptyToValue(
				productClassLinkChargesVO.get(i).getCHARGE_AMT_PER_INST_YN(), ConstantsCommon.NO))
			|| vatCode.compareTo(BigDecimal.ZERO) == 1
			|| ConstantsCommon.YES.equals(StringUtil.nullEmptyToValue(
				productClassLinkChargesVO.get(i).getCOLLECT_CHARGE_AT_DEAL_YN(), ConstantsCommon.NO)))
		{
		    payAtDealClosureYn = ConstantsCommon.NO;
		}

		// Added By Jose Afonso on 2015/11/23 BURJ140133 <Start>
		payNetIncentPrincStlmtYn = trschargesVO.getPAY_NET_INCENT_PRINC_STLMT_YN();

		if(payNetIncentPrincStlmtYn == null)
		{
		    payNetIncentPrincStlmtYn = ConstantsCommon.NO;
		}

		if(ConstantsCommon.YES.equals(payNetIncentPrincStlmtYn))
		{
		    if(ConstantsCommon.NO.equals(trsClassVO.getPROFIT_UPFRONT()))
		    {
			continue;
		    }
		    chargeType = ConstantsCommon.NO;
		    payAtDealClosureYn = ConstantsCommon.NO;
		}
		// Added By Jose Afonso on 2015/11/23 BURJ140133 <End>

		if(ConstantsCommon.YES.equals(payAtDealClosureYn))// Y - Yes
		{
		    accountBranch = trschargesVO.getDR_ACC_BRANCH();
		    accountCurrency = trschargesVO.getDR_ACC_CURRENCY();
		    accountGlCode = trschargesVO.getDR_ACC_GL();
		    accountCifCode = trschargesVO.getDR_ACC_CIF_SUB_NO();
		    accountSlNo = trschargesVO.getDR_ACC_SL_NO();
		}
		else
		{
		    accountBranch = trschargesVO.getCR_ACC_BRANCH();
		    accountCurrency = trschargesVO.getCR_ACC_CURRENCY();
		    accountGlCode = trschargesVO.getCR_ACC_GL();
		    accountCifCode = trschargesVO.getCR_ACC_CIF_SUB_NO();
		    accountSlNo = trschargesVO.getCR_ACC_SL_NO();
		}

		if(ConstantsCommon.NO.equals(trschargesVO.getSPECIFIC_ACC_BR_CY()))// N
		// -
		// None
		{
		    accountCurrency = iisDealChargesCO.getCurrency();
		    accountBranch = iisDealChargesCO.getBranchCode();
		}
		else if(ConstantsCommon.ON_BALANCE_SHEET.equals(trschargesVO.getSPECIFIC_ACC_BR_CY()))// B
		// -
		// Both
		{
		    accountCurrency = iisDealChargesCO.getCurrency();
		}
		else if(ConstantsCommon.OFF_BALANCE_SHEET.equals(trschargesVO.getSPECIFIC_ACC_BR_CY()))// C
		// -
		// Currency
		{
		    accountBranch = iisDealChargesCO.getBranchCode();
		}

		// Filling values to DealCharges object and adding to the List
		TrsDealChargesCO trsDealChargesCO = new TrsDealChargesCO();
		trsDealChargesCO.setCOMP_CODE(iisDealChargesCO.getCompCode());
		trsDealChargesCO.setBRANCH_CODE(iisDealChargesCO.getBranchCode());
		trsDealChargesCO.setCHARGES_CODE(productClassLinkChargesVO.get(i).getCHARGE_CODE());
		trsDealChargesCO.setSERIAL_NO(iisDealChargesCO.getDealNo());
		trsDealChargesCO.setLINE_NO(new BigDecimal(i));
		trsDealChargesCO.setLsBriefNameeng(trschargesVO.getBRIEF_NAME_ENG());
		trsDealChargesCO.setCR_ACC_BRANCH(accountBranch);
		trsDealChargesCO.setCR_ACC_CURRENCY(accountCurrency);
		trsDealChargesCO.setCR_ACC_GL(accountGlCode);
		trsDealChargesCO.setCR_ACC_CIF_SUB_NO(accountCifCode);
		trsDealChargesCO.setCR_ACC_SL_NO(accountSlNo);
		
		
		trsDealChargesCO.setCOLLECT_CHARGES_ACCOUNT_TYPE(
				   StringUtil.nullEmptyToValue(productClassLinkChargesVO.get(i).getCOLLECT_CHARGES_ACCOUNT_TYPE(),
				    "R"));
		
		trsDealChargesCO
			.setCOLLECT_CHARGE_AT_DEAL_YN(productClassLinkChargesVO.get(i).getCOLLECT_CHARGE_AT_DEAL_YN());
		trsDealChargesCO.setCHARGES_PERCENTAGE(chargePercentage);
		trsDealChargesCO
			.setCHARGE_AMT_PER_INST_YN(productClassLinkChargesVO.get(i).getCHARGE_AMT_PER_INST_YN());
		trsDealChargesCO.setPAY_AT_DEAL_CLOSURE_YN(payAtDealClosureYn);
		trsDealChargesCO.setCHARGE_TYPE(chargeType);
		trsDealChargesCO.setCREDIT_TO_SD_ACCOUNT_YN(creditToSdAccountYn);

		if(!ConstantsCommon.YES.equals(chargeType))
		{
		    trsDealChargesCO.setVAT_CODE(vatCode);
		}

		if(ConstantsCommon.NO.equals(trsClassVO.getEXCLUDE_CHARGES()))
		{
		    trsDealChargesCO.setCHARGE_TYPE(chargeType);
		}
		else
		{
		    trsDealChargesCO.setCHARGE_TYPE(ConstantsCommon.NO);
		}

		trsDealChargesCO.setLsPeriodicity(trschargesVO.getPERIODICITY());
		trsDealChargesCO.setLsPercentageOfProfit(trschargesVO.getPERCENTAGE_OF_PROFIT_YN());
		trsDealChargesCO.setLsAllowToEditChargePerYn(trschargesVO.getALLOW_TO_EDIT_CHARGE_PER_YN());
		// TP#231436; Saheer.Naduthodi; 19/10/2014
		trsDealChargesCO.setALLOW_EDIT(trschargesVO.getALLOW_TO_EDIT_CHARGES());

		// Added By Jose Afonso on 2015/11/23 BURJ140133 <Start>
		trsDealChargesCO.setTRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN(payNetIncentPrincStlmtYn);

		if(ConstantsCommon.YES.equals(payNetIncentPrincStlmtYn))
		{
		    trsDealChargesCO.setCHARGE_TYPE(ConstantsCommon.NO);
		    trsDealChargesCO.setPROFIT_ON_CHARGES(BigDecimal.ZERO);
		    trsDealChargesCO.setProfitOnCharge(ConstantsCommon.NO);
		    trsDealChargesCO.setLsAllowToEditChargePerYn(ConstantsCommon.NO);
		    trsDealChargesCO.setPAY_AT_DEAL_CLOSURE_YN(ConstantsCommon.NO);
		    trsDealChargesCO.setCOLLECT_CHARGES_ACCOUNT_TYPE("C");
		    trsDealChargesCO.setCOLLECT_CHARGE_AT_DEAL_YN(ConstantsCommon.YES);
		    trsDealChargesCO.setCREDIT_TO_SD_ACCOUNT_YN(ConstantsCommon.NO);
		    trsDealChargesCO.setCHARGE_AMT_PER_INST_YN(ConstantsCommon.NO);
		}
		// Added By Jose Afonso on 2015/11/23 BURJ140133 <End>

		lsTrsDealChargesCO.add(trsDealChargesCO);
	    }
	}// End of for loop
	trsClassVO = null;
	chargeType = null;
	creditToSdAccountYn = null;
	payAtDealClosureYn = null;
	vatCode = null;
	chargePercentage = null;
	accountBranch = null;
	accountCurrency = null;
	accountGlCode = null;
	accountCifCode = null;
	accountSlNo = null;
	return lsTrsDealChargesCO;
    }

    // Invoked from calculateDealCharges
    private List<TrsDealChargesCO> calculateChargeAmount(List<TrsDealChargesCO> lsTrsDealChargesCO,
	    IisDealChargesCO iisDealChargesCOTmp) throws BaseException
    {
	BigDecimal minimumAmount;
	BigDecimal cifProfile = BigDecimal.ZERO;
	BigDecimal flatAmount;
	BigDecimal chargePercentage = BigDecimal.ZERO;
	BigDecimal calculationBasedOn;
	BigDecimal creditAccountCy;
	BigDecimal maximumAmount;
	BigDecimal dealAmount;
	BigDecimal downPaymentAmount;

	double periodChargeable;
	// int decimalPoints = 2;
	String payAtDealClosureYn;
	String payNetIncentPrincStlmtYn;

	if(!lsTrsDealChargesCO.isEmpty())
	{
	    if(NumberUtil.toInt(iisDealChargesCOTmp.getCifNo()) > 0)
	    {
		CIFVOKey cifvoKey = new CIFVOKey();
		cifvoKey.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
		cifvoKey.setCIF_NO(iisDealChargesCOTmp.getCifNo());
		cifProfile = iisDealChargesDAO.getCifProfile(cifvoKey);
		cifvoKey = null;
	    }
	    if(cifProfile == null)
	    {
		cifProfile = BigDecimal.ZERO;
	    }
	    String chargeType = "";
	    BigDecimal vatCode = BigDecimal.ZERO;
	    BigDecimal accountBranch, accountCurrency, accountGlCode, accountCifCode, accountSlNo;

	    CURRENCIESVO dealCurrency = new CURRENCIESVO();
	    dealCurrency.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
	    BigDecimal baseCurrencyCode = iisDealChargesCOTmp.getBaseCurrencyCode();
	    dealCurrency.setCURRENCY_CODE(
		    iisDealChargesCOTmp.getCurrency() == null ? baseCurrencyCode : iisDealChargesCOTmp.getCurrency());
	    CURRENCIESVO currencyVO = commonLibBO.returnCurrency(dealCurrency);
	    BigDecimal dealCurrencyDecimalFormat = BigDecimal.ZERO;
	    if(currencyVO != null && currencyVO.getDECIMAL_POINTS() != null)
	    {
		dealCurrencyDecimalFormat = currencyVO.getDECIMAL_POINTS();
	    }

	    BigDecimal chargeCurrencyDecimalFormat = BigDecimal.ZERO;
	    CURRENCIESVO chargeCurrency = new CURRENCIESVO();
	    chargeCurrency.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());

	    BigDecimal baseCurrencyDecimalFormat = BigDecimal.ZERO;
	    CURRENCIESVO baseCurrency = new CURRENCIESVO();
	    baseCurrency.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
	    baseCurrency.setCURRENCY_CODE(iisDealChargesCOTmp.getBaseCurrencyCode());
	    baseCurrency = commonLibBO.returnCurrency(baseCurrency);
	    if(baseCurrency != null && !NumberUtil.isEmptyDecimal(baseCurrency.getDECIMAL_POINTS()))
	    {
		baseCurrencyDecimalFormat = baseCurrency.getDECIMAL_POINTS();
	    }

	    for(int i = 0; i < lsTrsDealChargesCO.size(); i++)
	    {
		if(!NumberUtil.isEmptyDecimal(lsTrsDealChargesCO.get(i).getCR_ACC_CURRENCY()))
		{
		    chargeCurrency.setCURRENCY_CODE(lsTrsDealChargesCO.get(i).getCR_ACC_CURRENCY());
		    chargeCurrency = commonLibBO.returnCurrency(chargeCurrency);

		    if(chargeCurrency != null && !NumberUtil.isEmptyDecimal(chargeCurrency.getDECIMAL_POINTS()))
		    {
			chargeCurrencyDecimalFormat = chargeCurrency.getDECIMAL_POINTS();
		    }
		}
		// Getting the CIF_PROFILE for that CIF for checking the
		// percentage and charge amount in roaster tab
		if(iisDealChargesCOTmp.getCallType() != null && "CC".equals(iisDealChargesCOTmp.getCallType()))// CC
		// is
		// charge
		// code
		{// DEAL CHARGE CODE FROM GRID
		    if("N".equals(lsTrsDealChargesCO.get(i).getEventColumn()))
		    {
			continue;// else it will go the below loop and calculate
			// the charges
		    }
		    // Getting the charges details directly from TRSCHARGES
		    // table
		    // Getting the charges and class details which are linked in
		    // product class
		    PRODUCT_CLASS_LINK_CHARGESVOKey linkCHARGESVOKey = new PRODUCT_CLASS_LINK_CHARGESVOKey();
		    linkCHARGESVOKey.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
		    linkCHARGESVOKey.setCLASS_CODE(iisDealChargesCOTmp.getProductClass());
		    linkCHARGESVOKey.setCHARGE_CODE(lsTrsDealChargesCO.get(i).getCHARGES_CODE());
		    if(lsTrsDealChargesCO.get(i).getCHARGES_CODE() != null
			    && iisDealChargesCOTmp.getProductClass() != null
			    && iisDealChargesCOTmp.getCompCode() != null)
		    {
			PRODUCT_CLASS_LINK_CHARGESVO productClassLinkChargesVO = iisDealChargesDAO
				.getProductclassLinkChargesObject(linkCHARGESVOKey);

			if(productClassLinkChargesVO != null)
			{
			    if(productClassLinkChargesVO.getCHARGE_TYPE() != null)
			    {
				chargeType = productClassLinkChargesVO.getCHARGE_TYPE();
			    }
			    if(productClassLinkChargesVO.getCHARGE_PERCENTAGE() != null)
			    {
				chargePercentage = new BigDecimal(
					NumberUtil.toDouble(productClassLinkChargesVO.getCHARGE_PERCENTAGE()));
			    }
			    if(productClassLinkChargesVO.getVAT_CODE() != null)
			    {
				vatCode = productClassLinkChargesVO.getVAT_CODE();
			    }

			}
		    }
		    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
		    trsClassVOKey.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
		    trsClassVOKey.setCODE(iisDealChargesCOTmp.getProductClass());
		    TRSCLASSVO trsClassVO = iisDealChargesDAO.getClassDetails(trsClassVOKey);
		    trsClassVOKey = null;
		    linkCHARGESVOKey = null;

		    TRSCHARGESVOKey trschargesvoKey = new TRSCHARGESVOKey();
		    trschargesvoKey.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
		    trschargesvoKey.setCODE(lsTrsDealChargesCO.get(i).getCHARGES_CODE());
		    TRSCHARGESVO trschargesVO = null;
		    if(lsTrsDealChargesCO.get(i).getCHARGES_CODE() != null && iisDealChargesCOTmp.getCompCode() != null)
		    {
			trschargesVO = iisDealChargesDAO.getTrsChargeDetails(trschargesvoKey);
		    }
		    if(trschargesVO != null)
		    {
			trschargesvoKey = null;
			payAtDealClosureYn = trschargesVO.getPAY_AT_DEAL_CLOSURE_YN();
			chargeType = trschargesVO.getCHARGE_TYPE();
			// Getting class details from TRSCLASS table
			if(trsClassVO.getEXCLUDE_CHARGES().equals("Y"))
			{
			    chargeType = "N";

			}
			if((chargeType.equals("Y") && trsClassVO.getEXCLUDE_CHARGES() != null
				&& trsClassVO.getEXCLUDE_CHARGES().equals("N"))
				|| (trschargesVO.getPERCENTAGE_OF_PROFIT_YN() != null
					&& trschargesVO.getPERCENTAGE_OF_PROFIT_YN().equals("Y"))

				|| (trschargesVO != null && trschargesVO.getCHARGE_AMT_PER_INST_YN() != null
					&& trschargesVO.getCHARGE_AMT_PER_INST_YN().equals("Y"))
				// || (trschargesVO!=null
				// &&trschargesVO.getCOLLECT_CHARGE_AT_DEAL_YN()!=null
				// &&
				// productClassLinkChargesVO.getCOLLECT_CHARGE_AT_DEAL_YN().equals("Y"))
				// Commented as per manoj
				|| NumberUtil.toDouble(vatCode) > 0

			)
			{
			    payAtDealClosureYn = "N";
			}

			// Added By Jose Afonso on 2015/11/23 BURJ140133 <Start>
			payNetIncentPrincStlmtYn = trschargesVO.getPAY_NET_INCENT_PRINC_STLMT_YN();

			if(payNetIncentPrincStlmtYn == null)
			{
			    payNetIncentPrincStlmtYn = ConstantsCommon.NO;
			}

			if(ConstantsCommon.YES.equals(payNetIncentPrincStlmtYn))
			{
			    chargeType = ConstantsCommon.NO;
			    payAtDealClosureYn = ConstantsCommon.NO;
			}
			// Added By Jose Afonso on 2015/11/23 BURJ140133 <End>

			if(payAtDealClosureYn.equals(ConstantsCommon.YES))// Y -
			// Yes
			{
			    accountBranch = trschargesVO.getDR_ACC_BRANCH();
			    accountCurrency = trschargesVO.getDR_ACC_CURRENCY();
			    accountGlCode = trschargesVO.getDR_ACC_GL();
			    accountCifCode = trschargesVO.getDR_ACC_CIF_SUB_NO();
			    accountSlNo = trschargesVO.getDR_ACC_SL_NO();
			}
			else
			{
			    accountBranch = trschargesVO.getCR_ACC_BRANCH();
			    accountCurrency = trschargesVO.getCR_ACC_CURRENCY();
			    accountGlCode = trschargesVO.getCR_ACC_GL();
			    accountCifCode = trschargesVO.getCR_ACC_CIF_SUB_NO();
			    accountSlNo = trschargesVO.getCR_ACC_SL_NO();
			}

			if(trschargesVO.getSPECIFIC_ACC_BR_CY().equals("N"))// N
			// -
			// None
			{
			    accountCurrency = iisDealChargesCOTmp.getCurrency();
			    accountBranch = iisDealChargesCOTmp.getBranchCode();
			}
			else if(trschargesVO.getSPECIFIC_ACC_BR_CY().equals("B"))// B
			// -
			// Both
			{
			    accountCurrency = iisDealChargesCOTmp.getCurrency();
			}
			else if(trschargesVO.getSPECIFIC_ACC_BR_CY().equals("C"))// C
			// -
			// Currency
			{
			    accountBranch = iisDealChargesCOTmp.getBranchCode();
			}
			// Filling values to DealCharges object and adding to
			// the List
			lsTrsDealChargesCO.get(i).setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
			lsTrsDealChargesCO.get(i).setBRANCH_CODE(iisDealChargesCOTmp.getBranchCode());
			lsTrsDealChargesCO.get(i).setCHARGES_CODE(lsTrsDealChargesCO.get(i).getCHARGES_CODE());
			lsTrsDealChargesCO.get(i).setSERIAL_NO(iisDealChargesCOTmp.getDealNo());
			lsTrsDealChargesCO.get(i).setLINE_NO(new BigDecimal(i));
			lsTrsDealChargesCO.get(i).setLsBriefNameeng(trschargesVO.getBRIEF_NAME_ENG());
			lsTrsDealChargesCO.get(i).setCR_ACC_BRANCH(accountBranch);
			lsTrsDealChargesCO.get(i).setCR_ACC_CURRENCY(accountCurrency);
			lsTrsDealChargesCO.get(i).setCR_ACC_GL(accountGlCode);
			lsTrsDealChargesCO.get(i).setCR_ACC_CIF_SUB_NO(accountCifCode);
			lsTrsDealChargesCO.get(i).setCR_ACC_SL_NO(accountSlNo);
			// trsDealChargesCO.setCOLLECT_CHARGE_AT_DEAL_YN(productClassLinkChargesVO.getCOLLECT_CHARGE_AT_DEAL_YN());
			lsTrsDealChargesCO.get(i).setCHARGES_PERCENTAGE(chargePercentage);
			lsTrsDealChargesCO.get(i).setCHARGE_AMT_PER_INST_YN(trschargesVO.getCHARGE_AMT_PER_INST_YN());
			lsTrsDealChargesCO.get(i).setPAY_AT_DEAL_CLOSURE_YN(payAtDealClosureYn);
			lsTrsDealChargesCO.get(i).setCHARGE_TYPE(chargeType);
			// TP#234960;roshin ;28/10/2014
			vatCode = NumberUtil.nullToZero(trschargesVO.getVAT_CODE());
			if(!chargeType.equals(ConstantsCommon.YES) && vatCode.doubleValue() > 0)
			{
			    lsTrsDealChargesCO.get(i).setVAT_CODE(vatCode);
			    TRSVATVOKey trsVatVOKey = new TRSVATVOKey();
			    trsVatVOKey.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
			    trsVatVOKey.setVAT_CODE(vatCode);
			    TRSVATVO trsVatVO = (TRSVATVO) genericDAO.selectByPK(trsVatVOKey);
			    lsTrsDealChargesCO.get(i).setVAT_BRIEF_NAME_ENG(trsVatVO.getBRIEF_NAME_ENG());
			}
			// TP#234960;roshin ;28/10/2014
			if(trsClassVO.getEXCLUDE_CHARGES().equals("N"))
			{
			    lsTrsDealChargesCO.get(i).setCHARGE_TYPE(chargeType);
			}
			else
			{
			    lsTrsDealChargesCO.get(i).setCHARGE_TYPE("N");
			}

			lsTrsDealChargesCO.get(i).setLsPeriodicity(trschargesVO.getPERIODICITY());
			lsTrsDealChargesCO.get(i).setLsPercentageOfProfit(trschargesVO.getPERCENTAGE_OF_PROFIT_YN());
			lsTrsDealChargesCO.get(i)
				.setLsAllowToEditChargePerYn(trschargesVO.getALLOW_TO_EDIT_CHARGE_PER_YN());
			lsTrsDealChargesCO.get(i).setAllowToEditVatCode(trschargesVO.getALLOW_TO_EDIT_VAT_CODE());// TP#234960;roshin
			// ;28/10/2014

			// lsTrsDealChargesCO.add(trsDealChargesCO);

			// Added By Jose Afonso on 2015/11/23 BURJ140133 <Start>
			lsTrsDealChargesCO.get(i).setTRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN(payNetIncentPrincStlmtYn);

			if(ConstantsCommon.YES.equals(payNetIncentPrincStlmtYn))
			{
			    lsTrsDealChargesCO.get(i).setCHARGE_TYPE(ConstantsCommon.NO);
			    lsTrsDealChargesCO.get(i).setPROFIT_ON_CHARGES(BigDecimal.ZERO);
			    lsTrsDealChargesCO.get(i).setProfitOnCharge(ConstantsCommon.NO);
			    lsTrsDealChargesCO.get(i).setLsAllowToEditChargePerYn(ConstantsCommon.NO);
			    lsTrsDealChargesCO.get(i).setPAY_AT_DEAL_CLOSURE_YN(ConstantsCommon.NO);
			    lsTrsDealChargesCO.get(i).setCOLLECT_CHARGES_ACCOUNT_TYPE("C");
			    lsTrsDealChargesCO.get(i).setCOLLECT_CHARGE_AT_DEAL_YN(ConstantsCommon.YES);
			    lsTrsDealChargesCO.get(i).setCREDIT_TO_SD_ACCOUNT_YN(ConstantsCommon.NO);
			    lsTrsDealChargesCO.get(i).setCHARGE_AMT_PER_INST_YN(ConstantsCommon.NO);
			}
			// Added By Jose Afonso on 2015/11/23 BURJ140133 <End>

		    }

		}// End of checking for CC"
		else if(iisDealChargesCOTmp.getCallType() != null && iisDealChargesCOTmp.getCallType().equals("CR"))
		{// DEAL CURRENCY FROM GRID ITEMCHANGED
		    if(lsTrsDealChargesCO.get(i).getEventColumn().equals("N"))
		    {
			continue;
		    }

		    TRSCHARGES_ROSTERVOKey trschargesrostervokey = new TRSCHARGES_ROSTERVOKey();
		    trschargesrostervokey.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());// Company
		    // code
		    trschargesrostervokey.setCODE(lsTrsDealChargesCO.get(i).getCHARGES_CODE());// Charge
		    // code
		    long rosterCount = 0;
		    if(iisDealChargesCOTmp.getCompCode() != null && lsTrsDealChargesCO.get(i).getCHARGES_CODE() != null)
		    {
			rosterCount = iisDealChargesDAO.getChargeExists(trschargesrostervokey);
			trschargesrostervokey = null;
		    }
		    if(rosterCount <= 0)
		    {
			if(doubleValue(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT()) > 0)
			{
			    IISCommonCO iisCommonCO = new IISCommonCO();
			    iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
			    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
			    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
			    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
			    iisCommonCO.setTrCurrency(iisDealChargesCOTmp.getCurrency());// Transaction
			    // currency
			    iisCommonCO.setPfCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// Base
			    // currency
			    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());
			    iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			    // decimalPoints = (int)
			    // iisCommonCO.getDealCyDecimalPoint();

			    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
			    {
				// Removed rounding as it will be done on client
				// side as per navas.
				/*
				 * lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(
				 * new BigDecimal(NumberUtil.Round(
				 * doubleValue(lsTrsDealChargesCO
				 * .get(i).getCHARGES_AMOUNT())
				 * doubleValue(iisCommonCO
				 * .getCrossRate()),decimalPoints)));
				 */
				if(NumberUtil.isEmptyDecimal(baseCurrencyDecimalFormat)
					|| baseCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) <= 0)
				{
				    lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(
					    new BigDecimal(doubleValue(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT())
						    * doubleValue(iisCommonCO.getCrossRate())));
				}
				else
				{
				    lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(NumberUtil.roundToBigDecimal(
					    new BigDecimal(doubleValue(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT())
						    * doubleValue(iisCommonCO.getCrossRate())),
					    baseCurrencyDecimalFormat.intValue()));
				}

			    }
			    else
			    {
				throw new BOException(MessageCodes.INVALID_EXCHANGE_RATE);
			    }
			    iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
			    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
			    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
			    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
			    iisCommonCO.setTrCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// Transaction
			    // currency
			    iisCommonCO.setPfCurrency(lsTrsDealChargesCO.get(i).getCR_ACC_CURRENCY());// Base
			    // currency
			    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());

			    // decimalPoints = (int)
			    // iisCommonCO.getDealCyDecimalPoint();

			    // TP# 234313;deepu.mohandas 25/10/2014
			    // iisCommonCO =
			    // iisCommonBO.returnCrossRate(iisCommonCO);
			    if(iisCommonCO.getPfCurrency() == null)
			    {
				iisCommonCO.setCrossRate(BigDecimal.ONE);
			    }
			    else
			    {
				iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			    }

			    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
			    {
				// Removed rounding as it will be done on client
				// side as per navas.
				/*
				 * lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(
				 * new BigDecimal(NumberUtil.Round(
				 * doubleValue(lsTrsDealChargesCO
				 * .get(i).getCHARGES_AMOUNT())
				 * doubleValue(iisCommonCO
				 * .getCrossRate()),decimalPoints)));
				 */
				if(NumberUtil.isEmptyDecimal(chargeCurrencyDecimalFormat)
					|| chargeCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) <= 0)
				{
				    lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(
					    new BigDecimal(doubleValue(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT())
						    * doubleValue(iisCommonCO.getCrossRate())));
				}
				else
				{
				    lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(NumberUtil.roundToBigDecimal(
					    new BigDecimal(doubleValue(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT())
						    * doubleValue(iisCommonCO.getCrossRate())),
					    chargeCurrencyDecimalFormat.intValue()));
				}

				lsTrsDealChargesCO.get(i).setEXCH_RATE(iisCommonCO.getCrossRate());
			    }
			    else
			    {
				throw new BOException(MessageCodes.INVALID_EXCHANGE_RATE);
			    }
			    lsTrsDealChargesCO.get(i).setCR_ACC_GL(BigDecimal.ZERO);
			    lsTrsDealChargesCO.get(i).setCR_ACC_SL_NO(BigDecimal.ZERO);
			    iisCommonCO = null;
			}
			continue;
		    }
		}// End of checking for CR"
		else if(iisDealChargesCOTmp.getCallType() != null && iisDealChargesCOTmp.getCallType().equals("CA"))// Deal
		// currency
		{// DEAL CHARGE AMOUNT FROM GRID ITEMCHANGED
		    if(lsTrsDealChargesCO.get(i).getEventColumn().equals("N"))
		    {
			continue;
		    }
		    BigDecimal currencyDecimalPoints = new BigDecimal(2);
		    double minimumAmountcur = 0D;
		    double maximumAmountcur = 0D;

		    BigDecimal chargeAmountevent = lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT();

		    // TP#210227; Ramesh; Date 31/08/2014 [START]
		    String nineValue; // = new StringBuffer("");
		    String zeroValue; // = new StringBuffer("");
		    // for(int row = 0; row < currencyDecimalPoints.intValue() -
		    // 1; row++)
		    // {
		    // if(zeroValue.toString().equals(""))
		    // {
		    // zeroValue.append("0");
		    // }
		    // else
		    // {
		    // zeroValue.append("0");
		    // }
		    // }
		    // if(zeroValue.toString().equals(""))
		    // {
		    // zeroValue.append("0.1");
		    // }
		    // else
		    // {
		    // zeroValue.append("0.").append(zeroValue).append("1");
		    // }

		    zeroValue = "0."
			    + NumberUtil.fill("0", BigDecimal.valueOf((currencyDecimalPoints.doubleValue() - 1))) + "1";
		    nineValue = "999999999999."
			    + NumberUtil.fill("9", BigDecimal.valueOf((currencyDecimalPoints.doubleValue())));

		    // for(int row = 0; row < currencyDecimalPoints.intValue();
		    // row++)
		    // {
		    // if(nineValue.toString().equals(""))
		    // {
		    // nineValue.append("9");
		    // }
		    // else
		    // {
		    // nineValue.append("9");
		    // }
		    // }
		    // nineValue.append("999999999999.").append(nineValue);
		    // TP#210227; Ramesh; Date 31/08/2014 [END]
		    maximumAmountcur = NumberUtil.toDouble(nineValue);
		    minimumAmountcur = NumberUtil.toDouble(zeroValue);
		    if(doubleValue(chargeAmountevent) < minimumAmountcur)
		    {
			throw new BOException(MessageCodes.AMOUNT_SHOULD_BE_BETWEEN,
				new String[] { zeroValue.toString(), nineValue.toString() });// zeroValue
		    }
		    if(doubleValue(chargeAmountevent) > maximumAmountcur)
		    {
			throw new BOException(MessageCodes.AMOUNT_SHOULD_BE_BETWEEN,
				new String[] { zeroValue.toString(), nineValue.toString() });// nineValue
		    }

		    TRSCHARGESVOKey trsChargesVOKey = new TRSCHARGESVOKey();
		    trsChargesVOKey.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
		    trsChargesVOKey.setCODE(lsTrsDealChargesCO.get(i).getCHARGES_CODE());
		    TRSCHARGESVO trsChargesVO = null;
		    if(lsTrsDealChargesCO.get(i).getCHARGES_CODE() != null && iisDealChargesCOTmp.getCompCode() != null)
		    {
			trsChargesVO = iisDealChargesDAO.getTrsChargeDetails(trsChargesVOKey);
			trsChargesVOKey = null;
		    }

		    // Get the Flat amount,Minimum amount and charge percentage
		    // from TRSCHARGES
		    if(trsChargesVO != null && trsChargesVO.getMINIMUM_AMOUNT() != null)
		    {
			minimumAmount = trsChargesVO.getMINIMUM_AMOUNT();

			if(doubleValue(chargeAmountevent) < doubleValue(minimumAmount))
			{
			    throw new BOException(MessageCodes.AMT_SHOULD_BE_GREATER_MIN_AMT_IN_CHRGS);// nineValue
			}
		    }

		    IISCommonCO iisCommonCO = new IISCommonCO();
		    iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
		    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
		    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
		    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
		    iisCommonCO.setTrCurrency(iisDealChargesCOTmp.getCurrency());// transaction
		    // currency
		    iisCommonCO.setPfCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// base
		    // currency
		    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());
		    if(iisDealChargesCOTmp.getBaseCurrencyCode() != null && iisDealChargesCOTmp.getCurrency() != null)
		    {
			iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			// decimalPoints = (int)
			// iisCommonCO.getDealCyDecimalPoint();
		    }

		    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
		    {
			// Removed rounding as it will be done on client side as
			// per navas.
			// lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(new
			// BigDecimal(NumberUtil.Round(doubleValue(chargeAmountevent)
			// *doubleValue(iisCommonCO.getCrossRate()),decimalPoints)));
			if(NumberUtil.isEmptyDecimal(baseCurrencyDecimalFormat)
				|| baseCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) <= 0)
			{
			    lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(new BigDecimal(
				    doubleValue(chargeAmountevent) * doubleValue(iisCommonCO.getCrossRate())));
			}
			else
			{
			    lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(NumberUtil.roundToBigDecimal(
				    new BigDecimal(
					    doubleValue(chargeAmountevent) * doubleValue(iisCommonCO.getCrossRate())),
				    baseCurrencyDecimalFormat.intValue()));
			}
		    }
		    else
		    {
			throw new BOException(MessageCodes.INVALID_EXCHANGE_RATE);
		    }
		    iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
		    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
		    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
		    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
		    iisCommonCO.setTrCurrency(lsTrsDealChargesCO.get(i).getCR_ACC_CURRENCY());// transaction
		    // currency
		    iisCommonCO.setPfCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// base
		    // currency
		    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());
		    if(iisCommonCO.getTrCurrency() != null && iisCommonCO.getPfCurrency() != null)
		    {
			iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			// decimalPoints = (int)
			// iisCommonCO.getDealCyDecimalPoint();
		    }
		    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
		    {
			// Removed rounding as it will be done on client side as
			// per navas.
			// lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(new
			// BigDecimal(NumberUtil.Round(doubleValue(chargeAmountevent)
			// *
			// doubleValue(iisCommonCO.getCrossRate()),decimalPoints)));
			if(NumberUtil.isEmptyDecimal(chargeCurrencyDecimalFormat)
				|| chargeCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) <= 0)
			{
			    lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(new BigDecimal(
				    doubleValue(chargeAmountevent) * doubleValue(iisCommonCO.getCrossRate())));
			}
			else
			{
			    lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(NumberUtil.roundToBigDecimal(
				    new BigDecimal(
					    doubleValue(chargeAmountevent) * doubleValue(iisCommonCO.getCrossRate())),
				    chargeCurrencyDecimalFormat.intValue()));
			}
			lsTrsDealChargesCO.get(i).setEXCH_RATE(iisCommonCO.getCrossRate());
		    }
		    else
		    {
			throw new BOException(MessageCodes.INVALID_EXCHANGE_RATE);
		    }
		    if("Y".equals(trsChargesVO.getINSURANCE()))
		    {
			lsTrsDealChargesCO.get(i).setInsuranceAmount(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT());
			lsTrsDealChargesCO.get(i).setChargeAmtToInclInPrinciple(BigDecimal.ZERO);
		    }
		    else
		    {
			lsTrsDealChargesCO.get(i).setInsuranceAmount(BigDecimal.ZERO);
			lsTrsDealChargesCO.get(i)
				.setChargeAmtToInclInPrinciple(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT());
		    }

		    System.out.println("Insur" + lsTrsDealChargesCO.get(i).getInsuranceAmount());
		    System.out.println("charges " + lsTrsDealChargesCO.get(i).getChargeAmtToInclInPrinciple());
		    iisCommonCO = null;
		    currencyDecimalPoints = null;
		    chargeAmountevent = null;
		    trsChargesVO = null;
		    continue;
		}// End of checking for CA"

		// Added by Linchu for grid onchange of charge currency.
		else if(iisDealChargesCOTmp.getCallType() != null && iisDealChargesCOTmp.getCallType().equals("CS"))// Charge
		// currency
		{// DEAL CHARGE AMOUNT FROM GRID ITEMCHANGED
		    if(lsTrsDealChargesCO.get(i).getEventColumn().equals("N"))
		    {
			continue;
		    }
		    BigDecimal currencyDecimalPoints = new BigDecimal(2);
		    double minimumAmountcur = 0D;
		    double maximumAmountcur = 0D;
		    double chargeCVAmount = 0D;
		    double newChargeAmount = 0D;

		    // BigDecimal chargeAmountevent =
		    // lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT();
		    BigDecimal chargeAmounteventFC = lsTrsDealChargesCO.get(i).getCHARGES_AMT_FC();

		    // As per PB code first find the chargeCV amount based on
		    // crossrate with
		    // credit currency and company currency.
		    IISCommonCO iisCommonCO = new IISCommonCO();
		    iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
		    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
		    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
		    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
		    iisCommonCO.setTrCurrency(lsTrsDealChargesCO.get(i).getCR_ACC_CURRENCY());// Credit
		    // currency
		    // from
		    // the
		    // grid.
		    iisCommonCO.setPfCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// Base
		    // currency
		    // --company
		    // currency.

		    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());
		    if(iisCommonCO.getTrCurrency() != null && iisCommonCO.getPfCurrency() != null)
		    {
			iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			// decimalPoints = (int)
			// iisCommonCO.getDealCyDecimalPoint();
		    }
		    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
		    {
			chargeCVAmount = doubleValue(chargeAmounteventFC) * doubleValue(iisCommonCO.getCrossRate());
			// Removed rounding as it will be done on client side as
			// per navas.
			// chargeCVAmount = NumberUtil.Round(chargeCVAmount,
			// decimalPoints);
		    }

		    // Next find the cross rate based on the base currency and
		    // deal currency and then multiply with chargeCVAmount to
		    // get the new chargeamount.
		    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
		    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
		    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
		    iisCommonCO.setTrCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// Base
		    // currency
		    // --company
		    // currency.
		    iisCommonCO.setPfCurrency(iisDealChargesCOTmp.getCurrency());// Deal
		    // currency
		    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());
		    if(iisCommonCO.getTrCurrency() != null && iisCommonCO.getPfCurrency() != null)
		    {
			iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			// decimalPoints = (int)
			// iisCommonCO.getDealCyDecimalPoint();
		    }
		    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
		    {
			newChargeAmount = doubleValue(chargeCVAmount) * doubleValue(iisCommonCO.getCrossRate());
			// Removed rounding as it will be done on client side as
			// per navas.
			// newChargeAmount = NumberUtil.Round(newChargeAmount,
			// decimalPoints);
		    }

		    StringBuffer nineValue = new StringBuffer("");
		    StringBuffer zeroValue = new StringBuffer("");
		    for(int row = 0; row < currencyDecimalPoints.intValue() - 1; row++)
		    {
			if(zeroValue.toString().equals(""))
			{
			    zeroValue.append("0");
			}
			else
			{
			    zeroValue.append("0");
			}
		    }
		    if(zeroValue.toString().equals(""))
		    {
			zeroValue.append("0.1");
		    }
		    else
		    {
			// TP#231434; Saheer.Naduthodi; 15/10/2014
			zeroValue = new StringBuffer("0.").append(zeroValue).append("1");
		    }
		    for(int row = 0; row < currencyDecimalPoints.intValue(); row++)
		    {
			if(nineValue.toString().equals(""))
			{
			    nineValue.append("9");
			}
			else
			{
			    nineValue.append("9");
			}
		    }
		    // TP#231434; Saheer.Naduthodi; 15/10/2014
		    nineValue = new StringBuffer("999999999999.").append(nineValue);

		    maximumAmountcur = NumberUtil.toDouble(nineValue);
		    minimumAmountcur = NumberUtil.toDouble(zeroValue);
		    if(doubleValue(newChargeAmount) < minimumAmountcur)
		    {
			throw new BOException(MessageCodes.AMOUNT_SHOULD_BE_BETWEEN,
				new String[] { zeroValue.toString(), nineValue.toString() });// zeroValue
		    }
		    if(doubleValue(newChargeAmount) > maximumAmountcur)
		    {
			throw new BOException(MessageCodes.AMOUNT_SHOULD_BE_BETWEEN,
				new String[] { zeroValue.toString(), nineValue.toString() });// nineValue
		    }

		    TRSCHARGESVOKey trsChargesVOKey = new TRSCHARGESVOKey();
		    trsChargesVOKey.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
		    trsChargesVOKey.setCODE(lsTrsDealChargesCO.get(i).getCHARGES_CODE());
		    TRSCHARGESVO trsChargesVO = null;
		    if(lsTrsDealChargesCO.get(i).getCHARGES_CODE() != null && iisDealChargesCOTmp.getCompCode() != null)
		    {
			trsChargesVO = iisDealChargesDAO.getTrsChargeDetails(trsChargesVOKey);
			trsChargesVOKey = null;
		    }

		    // Get the Flat amount,Minimum amount and charge percentage
		    // from TRSCHARGES
		    if(trsChargesVO != null && trsChargesVO.getMINIMUM_AMOUNT() != null)
		    {
			minimumAmount = trsChargesVO.getMINIMUM_AMOUNT();

			if(doubleValue(newChargeAmount) < doubleValue(minimumAmount))
			{
			    throw new BOException(MessageCodes.AMT_SHOULD_BE_GREATER_MIN_AMT_IN_CHRGS);// nineValue
			}
		    }

		    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
		    {
			if(NumberUtil.isEmptyDecimal(baseCurrencyDecimalFormat)
				|| baseCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) <= 0)
			{
			    lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(new BigDecimal(doubleValue(chargeCVAmount)));
			}
			else
			{
			    lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(NumberUtil.roundToBigDecimal(
				    new BigDecimal(doubleValue(chargeCVAmount)), baseCurrencyDecimalFormat.intValue()));
			}
		    }
		    else
		    {
			throw new BOException(MessageCodes.INVALID_EXCHANGE_RATE);
		    }

		    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
		    {
			if(dealCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) > 0)
			{
			    lsTrsDealChargesCO.get(i).setCHARGES_AMOUNT(
				    NumberUtil.roundToBigDecimal(new BigDecimal(doubleValue(newChargeAmount)),
					    dealCurrencyDecimalFormat.intValue()));
			}
			else
			{
			    lsTrsDealChargesCO.get(i).setCHARGES_AMOUNT(new BigDecimal(doubleValue(newChargeAmount)));
			}
			lsTrsDealChargesCO.get(i).setEXCH_RATE(iisCommonCO.getCrossRate());
		    }
		    else
		    {
			throw new BOException(MessageCodes.INVALID_EXCHANGE_RATE);
		    }
		    if("Y".equals(trsChargesVO.getINSURANCE()))
		    {
			lsTrsDealChargesCO.get(i).setInsuranceAmount(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT());
			lsTrsDealChargesCO.get(i).setChargeAmtToInclInPrinciple(BigDecimal.ZERO);
		    }
		    else
		    {
			lsTrsDealChargesCO.get(i).setInsuranceAmount(BigDecimal.ZERO);
			lsTrsDealChargesCO.get(i)
				.setChargeAmtToInclInPrinciple(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT());
		    }

		    // System.out.println("Insur"
		    // +lsTrsDealChargesCO.get(i).getInsuranceAmount());
		    // System.out.println("charges "
		    // +lsTrsDealChargesCO.get(i).getChargeAmtToInclInPrinciple());
		    iisCommonCO = null;
		    currencyDecimalPoints = null;
		    trsChargesVO = null;
		    continue;
		}// End of checking for CS"

		// Get the Flat amount,Minimum amount and charge percentage from
		// TRSCHARGES
		TRSCHARGESVOKey trsChargesVOKey = new TRSCHARGESVOKey();
		trsChargesVOKey.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
		trsChargesVOKey.setCODE(lsTrsDealChargesCO.get(i).getCHARGES_CODE());
		TRSCHARGESVO trsChargesVO = null;
		if(lsTrsDealChargesCO.get(i).getCHARGES_CODE() != null && iisDealChargesCOTmp.getCompCode() != null)
		{
		    trsChargesVO = iisDealChargesDAO.getTrsChargeDetails(trsChargesVOKey);
		}
		if(trsChargesVO != null)
		{
		    trsChargesVOKey = null;
		    flatAmount = trsChargesVO.getFLAT_AMOUNT();
		    minimumAmount = trsChargesVO.getMINIMUM_AMOUNT();
		    chargePercentage = trsChargesVO.getPERCENTAGE();
		    calculationBasedOn = trsChargesVO.getCALCULATED_ON_AMT();
		    creditAccountCy = trsChargesVO.getCR_ACC_CURRENCY();
		    maximumAmount = trsChargesVO.getMAXIMUM_AMOUNT();
		    vatCode = trsChargesVO.getVAT_CODE();// TP#234960;roshin
		    // ;28/10/2014
		    if(flatAmount == null)
		    {
			flatAmount = BigDecimal.ZERO;
		    }

		    if(minimumAmount == null)
		    {
			minimumAmount = BigDecimal.ZERO;
		    }

		    if(maximumAmount == null)
		    {
			maximumAmount = BigDecimal.ZERO;
		    }

		    if(chargePercentage == null)
		    {
			chargePercentage = BigDecimal.ZERO;
		    }

		    if(trsChargesVO.getSPECIFIC_ACC_BR_CY().equals("N"))
		    {
			creditAccountCy = iisDealChargesCOTmp.getCurrency();
		    }
		    else if(trsChargesVO.getSPECIFIC_ACC_BR_CY().equals("B"))
		    {
			creditAccountCy = iisDealChargesCOTmp.getCurrency();
		    }
		    if(creditAccountCy == null)
		    {
			creditAccountCy = iisDealChargesCOTmp.getCurrency();
		    }

		    if(trsChargesVO.getPROFIT_ON_CHARGE() == null)
		    {
			trsChargesVO.setPROFIT_ON_CHARGE("N");
		    }
		    if(trsChargesVO.getPROFIT_ON_CHARGE().equals("N")
			    || trsChargesVO.getPAY_NET_INCENT_PRINC_STLMT_YN().equals("Y"))
		    {
			lsTrsDealChargesCO.get(i).setProfitOnCharge("FALSE");
		    }
		    else
		    {
			lsTrsDealChargesCO.get(i).setProfitOnCharge("TRUE");
		    }

		    dealAmount = new BigDecimal(NumberUtil.toDouble(iisDealChargesCOTmp.getDealAmount()));

		    /*
		     * Checking the charge amount calculation based on ( 1-Deal
		     * Mount. 2-Financing AMount (Deal Amount + Down Payment )
		     * 3- Company Contribution AMount )
		     */
		    if(NumberUtil.toDouble(calculationBasedOn) == 3)
		    {
			dealAmount = new BigDecimal(
				NumberUtil.toDouble(iisDealChargesCOTmp.getCompanyContributionAmount()));
		    }
		    else if(NumberUtil.toDouble(calculationBasedOn) == 2)
		    {
			dealAmount = new BigDecimal(NumberUtil.toDouble(iisDealChargesCOTmp.getDealAmount()));
			// Get Initial payment type
			TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
			trsClassVOKey.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
			trsClassVOKey.setCODE(iisDealChargesCOTmp.getProductClass());
			TRSCLASSVO trsClassVO = iisDealChargesDAO.getClassDetails(trsClassVOKey);
			String intialPaymentType = trsClassVO.getINITIAL_PAYMENT_TYPE();
			trsClassVOKey = null;
			trsClassVO = null;
			if(intialPaymentType.equals(IISCommonConstants.DOWN_PAYMENT))
			{
			    downPaymentAmount = new BigDecimal(
				    NumberUtil.toDouble(iisDealChargesCOTmp.getDownPaymentAmount()));
			}
			else
			{
			    downPaymentAmount = BigDecimal.ZERO;
			}
			// Add down payment amount to deal mount
			dealAmount = new BigDecimal(NumberUtil.toDouble(dealAmount.add(downPaymentAmount)));
		    }

		    else
		    {
			dealAmount = new BigDecimal(NumberUtil.toDouble(iisDealChargesCOTmp.getDealAmount()));
		    }
		    if(lsTrsDealChargesCO.get(i).getCHARGES_PERCENTAGE() != null
			    && (NumberUtil.toDouble(lsTrsDealChargesCO.get(i).getCHARGES_PERCENTAGE()) > 0)
			    && !("CC".equals(iisDealChargesCOTmp.getCallType())))
		    {
			chargePercentage = lsTrsDealChargesCO.get(i).getCHARGES_PERCENTAGE();
		    }
		    
		    //RIDB180085
		    String flatAmountCyType=StringUtil.nullToEmpty(trsChargesVO.getFLAT_AMOUNT_CURRENCY_TYPE());
			
		    BigDecimal flatAmountCy = null;
		    if("D".equals(flatAmountCyType))
		    {
		    	flatAmountCy = iisDealChargesCOTmp.getCurrency();
		    }else if("B".equals(flatAmountCyType)){
		    	flatAmountCy = iisDealChargesCOTmp.getBaseCurrencyCode();
		    }
		    else
		    {
		    	flatAmountCy =NumberUtil.emptyDecimalToNull(lsTrsDealChargesCO.get(i).getCR_ACC_CURRENCY());//acc_creditcy
		    }
		   
		    BigDecimal flatAmountOriginal=flatAmount;
		    if((NumberUtil.toDouble(flatAmount) > 0D) && (flatAmountCy.compareTo(iisDealChargesCOTmp.getCurrency()) != 0))
		    {
			IISCommonCO iisCommonCO = new IISCommonCO();
			iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
			iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
			iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
			iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
			iisCommonCO.setTrCurrency(flatAmountCy);
			iisCommonCO.setPfCurrency(iisDealChargesCOTmp.getCurrency());
			iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());			
			if(!NumberUtil.isEmptyDecimal(iisCommonCO.getTrCurrency()) && !NumberUtil.isEmptyDecimal(iisCommonCO.getPfCurrency()))
			{
			    iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			}		    
			if(NumberUtil.toDouble(iisCommonCO.getCrossRate()) > 0)
			{
			    flatAmount = new BigDecimal(NumberUtil.toDouble(flatAmount)
				    * doubleValue(iisCommonCO.getCrossRate()));
			}
			iisCommonCO = null;
		    }	 //RIDB180085
		   /*
		    if((NumberUtil.toDouble(flatAmount) > 0D) && (iisDealChargesCOTmp.getCurrency() != creditAccountCy))
		    {
			IISCommonCO iisCommonCO = new IISCommonCO();
			iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
			iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
			iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
			iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
			iisCommonCO.setTrCurrency(creditAccountCy);
			iisCommonCO.setPfCurrency(iisDealChargesCOTmp.getCurrency());
			iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());
			iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			// decimalPoints = (int)
			// iisCommonCO.getDealCyDecimalPoint();

			if(NumberUtil.toDouble(iisCommonCO.getCrossRate()) > 0)
			{
			    flatAmount = new BigDecimal(
				    NumberUtil.toDouble(flatAmount) * doubleValue(iisCommonCO.getCrossRate()));
			}
			iisCommonCO = null;
		    }
		    */
		    if("D".equals(trsChargesVO.getPERIODICITY()) && iisDealChargesCOTmp.getMaturityDate() != null
			    && iisDealChargesCOTmp.getValueDate() != null)
		    {
			long days = DateUtil.numberOfDays(iisDealChargesCOTmp.getValueDate(),
				iisDealChargesCOTmp.getMaturityDate());
			periodChargeable = days + 1;
		    }
		    else if("M".equals(trsChargesVO.getPERIODICITY()) && iisDealChargesCOTmp.getMaturityDate() != null
			    && iisDealChargesCOTmp.getValueDate() != null)
		    {
			periodChargeable = DateUtil.getMonthsDifference(iisDealChargesCOTmp.getValueDate(),
				iisDealChargesCOTmp.getMaturityDate());

		    }
		    else if("Y".equals(trsChargesVO.getPERIODICITY()) && iisDealChargesCOTmp.getMaturityDate() != null
			    && iisDealChargesCOTmp.getValueDate() != null)
		    {
			periodChargeable = DateUtil.getYearDifference(iisDealChargesCOTmp.getValueDate(),
				iisDealChargesCOTmp.getMaturityDate());
			Calendar cal = Calendar.getInstance();
			cal.setTime(iisDealChargesCOTmp.getValueDate());
			int month1 = cal.get(Calendar.MONTH);
			int day1 = cal.get(Calendar.DAY_OF_MONTH);
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(iisDealChargesCOTmp.getMaturityDate());
			int month2 = cal1.get(Calendar.MONTH);
			int day2 = cal1.get(Calendar.DAY_OF_MONTH);
			if(month2 > month1)
			{
			    periodChargeable = periodChargeable + 1;
			}
			else if(month2 == month1 && day2 > day1)
			{

			    periodChargeable = periodChargeable + 1;

			}
		    }
		    else if("A".equals(trsChargesVO.getPERIODICITY()))
		    {
			long days = DateUtil.numberOfDays(iisDealChargesCOTmp.getValueDate(),
				iisDealChargesCOTmp.getMaturityDate());
			periodChargeable = days / (double) 365;
		    }
		    else
		    {
			periodChargeable = 1;
		    }

		    if(periodChargeable == 0D)
		    {
			periodChargeable = 1;
		    }

		    TRSCHARGES_ROSTERVO trsChargesRosterVO = new TRSCHARGES_ROSTERVO();
		    trsChargesRosterVO.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());// setting
		    // the
		    // company
		    // code
		    trsChargesRosterVO.setCODE(lsTrsDealChargesCO.get(i).getCHARGES_CODE());// setting
		    // the
		    // charge
		    // code
		    if(cifProfile == null)
		    {
			cifProfile = BigDecimal.ZERO;
		    }
		    trsChargesRosterVO.setCIF_PROFILE(cifProfile);// setting the
		    // CIF profile
		    // code
		    trsChargesRosterVO.setAMOUNT(dealAmount);// setting the deal
		    // mount
		    trsChargesRosterVO.setCURRENCY_CODE(creditAccountCy);// setting
		    // the
		    // currency

		    // Checking whether any row is defined for that CIF_PROFILE
		    // under roaster tab

		    long roasterCifProfileCount = 0;
		    long rosterCurrencyCount = 0;
		    if(iisDealChargesCOTmp.getCompCode() != null && lsTrsDealChargesCO.get(i).getCHARGES_CODE() != null)
		    {
			roasterCifProfileCount = iisDealChargesDAO.getChargeRosterExists(trsChargesRosterVO);

			// Checking whether any row is defined for charge
			// account
			// currency under roaster tab
			rosterCurrencyCount = iisDealChargesDAO.getChargeRosterCurrencyExists(trsChargesRosterVO);
			if(roasterCifProfileCount > 0)
			{
			    TRSCHARGES_ROSTERVO trsChargesRosterVOTemp = new TRSCHARGES_ROSTERVO();
			    trsChargesRosterVOTemp = iisDealChargesDAO.getChargeRosterDetails(trsChargesRosterVO);// getting
			    // the
			    // details

			    if(trsChargesRosterVOTemp != null)
			    {
				trsChargesRosterVO.setPERCENTAGE(trsChargesRosterVOTemp.getPERCENTAGE());
				trsChargesRosterVO.setAMOUNT(trsChargesRosterVOTemp.getAMOUNT());
				trsChargesRosterVO.setFACTOR(trsChargesRosterVOTemp.getFACTOR());
				trsChargesRosterVO.setMINIMUM_AMT(trsChargesRosterVOTemp.getMINIMUM_AMT());

			    }

			}
			else if(rosterCurrencyCount > 0)
			{
			    TRSCHARGES_ROSTERVO trsChargesRosterVOTemp = new TRSCHARGES_ROSTERVO();
			    trsChargesRosterVOTemp = iisDealChargesDAO
				    .getChargeRosterDetailsWithOutCifProfile(trsChargesRosterVO);
			    if(trsChargesRosterVOTemp != null)
			    {
				trsChargesRosterVO.setPERCENTAGE(trsChargesRosterVOTemp.getPERCENTAGE());
				trsChargesRosterVO.setAMOUNT(trsChargesRosterVOTemp.getAMOUNT());
				trsChargesRosterVO.setFACTOR(trsChargesRosterVOTemp.getFACTOR());
				trsChargesRosterVO.setMINIMUM_AMT(trsChargesRosterVOTemp.getMINIMUM_AMT());
			    }
			}
		    }
		    if(trsChargesRosterVO.getFACTOR() == null
			    || (NumberUtil.toDouble(trsChargesRosterVO.getFACTOR())) < 0)
		    {
			trsChargesRosterVO.setFACTOR(BigDecimal.ONE);
		    }
		    // TP#238906; Saheer.Naduthodi; 08/11/2014
		    double chargeAmount = 0;
		    if(rosterCurrencyCount > 0 || roasterCifProfileCount > 0)
		    {
			chargePercentage = trsChargesRosterVO.getPERCENTAGE();
			chargeAmount = doubleValue(trsChargesRosterVO.getAMOUNT());
			if(NumberUtil.toDouble(chargePercentage) > 0D)
			{
			    chargeAmount = doubleValue(dealAmount) * (doubleValue(chargePercentage) / 100)
				    * periodChargeable * doubleValue(trsChargesRosterVO.getFACTOR());
			}
			if(roasterCifProfileCount > 0 && doubleValue(trsChargesRosterVO.getMINIMUM_AMT()) > 0
				&& chargeAmount < doubleValue(trsChargesRosterVO.getMINIMUM_AMT()))
			{

			    chargeAmount = doubleValue(trsChargesRosterVO.getMINIMUM_AMT());// setting
			    // the
			    // minimum
			    // amount

			}
		    }
		    else
		    {
			if(doubleValue(chargePercentage) > 0)
			{
			    chargeAmount = doubleValue(dealAmount) * (doubleValue(chargePercentage) / 100)
				    * periodChargeable;
			}
		    }
		    if(roasterCifProfileCount == 0 && chargeAmount > 0 && NumberUtil.toDouble(minimumAmount) > 0
			    && chargeAmount < doubleValue(minimumAmount))
		    {

			chargeAmount = doubleValue(minimumAmount);

		    }
		    if(NumberUtil.toDouble(maximumAmount) > 0 && chargeAmount > doubleValue(maximumAmount))
		    {
			chargeAmount = doubleValue(maximumAmount);
		    }
		    if(NumberUtil.toDouble(chargePercentage) > 0)
		    {
			lsTrsDealChargesCO.get(i).setCHARGES_PERCENTAGE(chargePercentage);
		    }
		    if(NumberUtil.toDouble(chargeAmount) == 0 && doubleValue(flatAmount) > 0)
		    {
			chargeAmount = doubleValue(flatAmount);
		    }
		    // Removed rounding as it will be done on client side as per
		    // navas.
		    // lsTrsDealChargesCO.get(i).setCHARGES_AMOUNT(new
		    // BigDecimal(NumberUtil.Round(chargeAmount,decimalPoints)));
		    if(dealCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) > 0)
		    {
			lsTrsDealChargesCO.get(i).setCHARGES_AMOUNT(NumberUtil.roundToBigDecimal(
				BigDecimal.valueOf(chargeAmount), dealCurrencyDecimalFormat.intValue()));
		    }
		    else
		    {
			lsTrsDealChargesCO.get(i).setCHARGES_AMOUNT(BigDecimal.valueOf(chargeAmount));
		    }
		    IISCommonCO iisCommonCO = new IISCommonCO();
		  //  flatAmountOriginal=
		    if(NumberUtil.toDouble(flatAmount) > 0D && iisDealChargesCOTmp.getCurrency().doubleValue() != iisDealChargesCOTmp.getBaseCurrencyCode().doubleValue())
		    {
			if( flatAmountCy.compareTo(iisDealChargesCOTmp.getBaseCurrencyCode())!=0)
			{
			
		    iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
			    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
			    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
			    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
			    iisCommonCO.setTrCurrency(iisDealChargesCOTmp.getCurrency());// transaction
			    // currency
			    iisCommonCO.setPfCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// base
			    // currency
			    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());
			    iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			    BigDecimal currency_exch_rate = iisCommonCO.getCrossRate();
			    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
			    {
				if(NumberUtil.isEmptyDecimal(baseCurrencyDecimalFormat) || baseCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) <= 0)
				    {
				    lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(
						new BigDecimal(chargeAmount * doubleValue(iisCommonCO.getCrossRate())));
				    }
				    else
				    {
					lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(NumberUtil.roundToBigDecimal(
						new BigDecimal(chargeAmount * doubleValue(iisCommonCO.getCrossRate())),baseCurrencyDecimalFormat.intValue()));
				    }
			    }
			    else
			    {
				lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(BigDecimal.ZERO);
				
			    }
}
			 else
			 {
				
				lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(NumberUtil.roundToBigDecimal(NumberUtil.nullToZero(trsChargesVO.getFLAT_AMOUNT()), baseCurrencyDecimalFormat.intValue()));
			 
				    //TP# #578994 543321 CBR170080 -
				    BigDecimal currency_exch_rate = iisCommonCO.getCrossRate();
				    if(NumberUtil.nullToZero(currency_exch_rate).compareTo(BigDecimal.ZERO)==0)
				    {
					 lsTrsDealChargesCO.get(i).setEXCH_RATE(BigDecimal.ONE);
				    }
				    else
				    {
				    lsTrsDealChargesCO.get(i).setEXCH_RATE(currency_exch_rate);
				    }
			 }
		    }
		    
		    else if(iisDealChargesCOTmp.getCurrency().doubleValue() != iisDealChargesCOTmp.getBaseCurrencyCode().doubleValue())
		    {
			 iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
			    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
			    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
			    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
			    iisCommonCO.setTrCurrency(iisDealChargesCOTmp.getCurrency());// transaction
			    // currency
			    iisCommonCO.setPfCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// base
			    // currency
			    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());
			    iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			    BigDecimal currency_exch_rate = iisCommonCO.getCrossRate();
			    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
			    {
				if(NumberUtil.isEmptyDecimal(baseCurrencyDecimalFormat) || baseCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) <= 0)
				    {
				    lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(
						new BigDecimal(chargeAmount * doubleValue(iisCommonCO.getCrossRate())));
				    }
				    else
				    {
					lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(NumberUtil.roundToBigDecimal(
						new BigDecimal(chargeAmount * doubleValue(iisCommonCO.getCrossRate())),baseCurrencyDecimalFormat.intValue()));
				    }
			    }
			    else
			    {
				lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(BigDecimal.ZERO);
				
			    }
		    }	    
		    
		    else
		    {
// 722094 SUPT180300		    	
			//lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(NumberUtil.roundToBigDecimal(
			//	flatAmountOriginal ,baseCurrencyDecimalFormat.intValue()));
			lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(NumberUtil.roundToBigDecimal(
				    BigDecimal.valueOf(chargeAmount) ,baseCurrencyDecimalFormat.intValue()));
		    }
		  
			
		    /*
		    IISCommonCO iisCommonCO = new IISCommonCO();
		    iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
		    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
		    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
		    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
		    iisCommonCO.setTrCurrency(iisDealChargesCOTmp.getCurrency());// transaction
		    // currency
		    iisCommonCO.setPfCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// base
		    // currency
		    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());
		    iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
		  //TP #578994  #543321 CBR170080 -
		    BigDecimal currency_exch_rate = iisCommonCO.getCrossRate();
		    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
		    {
			// Removed rounding as it will be done on client side as
			// per navas.
			// lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(new
			// BigDecimal(NumberUtil.Round(chargeAmount *
			// doubleValue(iisCommonCO.getCrossRate()),decimalPoints)));
			if(NumberUtil.isEmptyDecimal(baseCurrencyDecimalFormat)
				|| baseCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) <= 0)
			{
			    lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(
				    new BigDecimal(chargeAmount * doubleValue(iisCommonCO.getCrossRate())));
			}
			else
			{
			    lsTrsDealChargesCO.get(i)
				    .setCHARGES_AMT_CV(NumberUtil.roundToBigDecimal(
					    new BigDecimal(chargeAmount * doubleValue(iisCommonCO.getCrossRate())),
					    baseCurrencyDecimalFormat.intValue()));
			}
		    }
		    else
		    {
			lsTrsDealChargesCO.get(i).setCHARGES_AMT_CV(BigDecimal.ZERO);
		    }
		    */
		   if((NumberUtil.toDouble(flatAmount) > 0D))
		   {
		       if(flatAmountCy.doubleValue()==creditAccountCy.doubleValue())
	                    {	    
	                    	lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(NumberUtil
	                    	.roundToBigDecimal(flatAmountOriginal, chargeCurrencyDecimalFormat.intValue()));
	                    }
	                    else if(iisDealChargesCOTmp.getCurrency().doubleValue()==creditAccountCy.doubleValue())
	                    {
	                    	lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(NumberUtil
	                    	.roundToBigDecimal(new BigDecimal(chargeAmount), chargeCurrencyDecimalFormat.intValue()));
	                    }
	                    else
	                    {
			    iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
			    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
			    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
			    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
			    //TP# #578994 543321 CBR170080 -
				 //  iisCommonCO.setTrCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// transaction
				    iisCommonCO.setTrCurrency(iisDealChargesCOTmp.getCurrency());// transaction
			    // currency
			    iisCommonCO.setPfCurrency(creditAccountCy);// base currency
			    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());
			    iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
			    
			    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
			    {
				// Removed rounding as it will be done on client side as
				// per navas.
				// lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(new
				// BigDecimal(NumberUtil.Round(chargeAmount *
				// doubleValue(iisCommonCO.getCrossRate()),decimalPoints)));
				
				if(NumberUtil.isEmptyDecimal(chargeCurrencyDecimalFormat) || chargeCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) <=0)
				{
				    lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(
						new BigDecimal(chargeAmount * doubleValue(iisCommonCO.getCrossRate())));
				}
				else{
				lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(NumberUtil.roundToBigDecimal(
					new BigDecimal(chargeAmount * doubleValue(iisCommonCO.getCrossRate())),chargeCurrencyDecimalFormat.intValue()));
				}
				
				lsTrsDealChargesCO.get(i).setEXCH_RATE(iisCommonCO.getCrossRate());
			    }
			    else
			    {
				lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(BigDecimal.ZERO);
				lsTrsDealChargesCO.get(i).setEXCH_RATE(BigDecimal.ZERO);
			    }
	                    } 
		   }
		   else
		   {
		       lsTrsDealChargesCO.get(i).setCHARGES_AMT_FC(NumberUtil
	                    	.roundToBigDecimal(new BigDecimal(chargeAmount), chargeCurrencyDecimalFormat.intValue()));
		       

		   }
		 
		    //TP# #578994 543321 CBR170080 -
		    BigDecimal currency_exch_rate = iisCommonCO.getCrossRate();
		    if(NumberUtil.nullToZero(currency_exch_rate).compareTo(BigDecimal.ZERO)==0)
		    {
		    	lsTrsDealChargesCO.get(i).setEXCH_RATE(BigDecimal.ONE);
		    }
	    	else
		    {
		    lsTrsDealChargesCO.get(i).setEXCH_RATE(currency_exch_rate);
		    }

		    if(ConstantsCommon.YES.equals(trsChargesVO.getINSURANCE()))
		    {
			lsTrsDealChargesCO.get(i).setInsuranceAmount(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT());
			lsTrsDealChargesCO.get(i).setChargeAmtToInclInPrinciple(BigDecimal.ZERO);
		    }
		    else
		    {
			lsTrsDealChargesCO.get(i).setInsuranceAmount(BigDecimal.ZERO);
			lsTrsDealChargesCO.get(i)
				.setChargeAmtToInclInPrinciple(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT());
		    }
		    // System.out.println("Insur"
		    // +lsTrsDealChargesCO.get(i).getInsuranceAmount());
		    // System.out.println("charges "
		    // +lsTrsDealChargesCO.get(i).getChargeAmtToInclInPrinciple());

		    trsChargesVO = null;
		    trsChargesRosterVO = null;
		    iisCommonCO = null;
		}
		lsTrsDealChargesCO.get(i).setDealChargesFormat(dealCurrencyDecimalFormat);
		lsTrsDealChargesCO.get(i).setCOLLECT_CHARGE_AT_DEAL_YN(
			StringUtil.nullEmptyToValue(lsTrsDealChargesCO.get(i).getCOLLECT_CHARGE_AT_DEAL_YN(), "N"));
	    }// End of for loop
	    flatAmount = null;
	    chargePercentage = null;
	    calculationBasedOn = null;
	    creditAccountCy = null;
	    maximumAmount = null;
	    dealAmount = null;
	    downPaymentAmount = null;
	}

	return lsTrsDealChargesCO;
    }

    private static final double doubleValue(Object o)
    {
	return NumberUtil.toDouble(o);

    }

    @Override
    public List<TrsDealChargesCO> getDealChargesByDeal(TrsDealChargesSC trsDealChargesSC) throws BaseException
    {
	return iisDealChargesDAO.getDealChargesByDeal(trsDealChargesSC);
    }

    @Override
    public IISReturnMessagesCO saveDealCharges(List<TrsDealChargesCO> trsDealChargesCOList, TrsDealChargesSC trsDealChargesSC, IISReturnMessagesCO iisReturnMessagesCO)
	    throws BaseException
    {
    	// TP# 870190 BAJ Fawas.Kuruvakkottil 30/08/2019 Start
//    	IISDealChargesParamCO iisdealchargesparamco = new IISDealChargesParamCO();
//    	iisdealchargesparamco.setIisReturnMessagesCO(iisReturnMessagesCO);
    	IISReturnMessagesCO returnIISReturnMessagesCO = validateDealChargesForLeasedAsset(trsDealChargesCOList,
    		trsDealChargesSC.getAssetVendorIncentiveGridList(), iisReturnMessagesCO, trsDealChargesSC.getCompCode(),
    		trsDealChargesSC.getBranchCode(), trsDealChargesSC.getDealNo());

    	// TP# 870190 BAJ Fawas.Kuruvakkottil 30/08/2019 End
    	validateDealChargesForGeneralLimit(trsDealChargesCOList, trsDealChargesSC);

    	if(trsDealChargesSC.getPageRefName().equalsIgnoreCase("PFX"))
    	{
    	    TRSPFXCHARGESVOKey trspfxchargesvoKey = new TRSPFXCHARGESVOKey();
    	    trspfxchargesvoKey.setCOMP_CODE(trsDealChargesSC.getCompCode());
    	    trspfxchargesvoKey.setBRANCH_CODE(trsDealChargesSC.getBranchCode());
    	    trspfxchargesvoKey.setSERIAL_NO(trsDealChargesSC.getDealNo());
    	    if(NumberUtil.emptyDecimalToZero(trsDealChargesSC.getPfxCancellationNo()).compareTo(BigDecimal.ZERO) == 1
    		    && trsDealChargesSC.getPromissoryFxType().equals("C"))
    	    {// Setting the PFX no as serial_no column
    		trspfxchargesvoKey.setLINE_NO(trsDealChargesSC.getPfxCancellationNo());
    	    }
    	    iisDealChargesDAO.deletePfxCharges(trspfxchargesvoKey);
    	}
    	else
    	{

    	    TRSDEALCHARGESVOKey trsdealchargesvokey = new TRSDEALCHARGESVOKey();
    	    trsdealchargesvokey.setCOMP_CODE(trsDealChargesSC.getCompCode());
    	    trsdealchargesvokey.setBRANCH_CODE(trsDealChargesSC.getBranchCode());
    	    trsdealchargesvokey.setSERIAL_NO(trsDealChargesSC.getDealNo());
    	    iisDealChargesDAO.deleteDealChargesByDeal(trsdealchargesvokey);
    	}
    	BigDecimal lineNo = BigDecimal.ZERO;
    	for(TrsDealChargesCO trsDealChargesCO : trsDealChargesCOList)
    	{
    	    // TP# 713881 - adding validation for charges CY fields [START]
    	    if(NumberUtil.nullToZero(trsDealChargesCO.getCHARGES_AMOUNT()).compareTo(BigDecimal.ONE) != 1
    		    || NumberUtil.nullToZero(trsDealChargesCO.getCHARGES_AMT_CV()).compareTo(BigDecimal.ONE) != 1
    		    || NumberUtil.nullToZero(trsDealChargesCO.getCHARGES_AMT_FC()).compareTo(BigDecimal.ONE) != 1)
    	    {
    		throw new BOException(MessageCodes.INVALID_CHARGE_AMOUNT);
    	    }

    	    if(NumberUtil.nullToZero(trsDealChargesCO.getCHARGES_CODE()).compareTo(BigDecimal.ZERO) == 1)
    	    {
    		if(NumberUtil.emptyDecimalToNull(trsDealChargesCO.getCR_ACC_BRANCH()) == null
    			|| NumberUtil.emptyDecimalToNull(trsDealChargesCO.getCR_ACC_CURRENCY()) == null
    			|| NumberUtil.emptyDecimalToNull(trsDealChargesCO.getCR_ACC_GL()) == null
    			|| NumberUtil.emptyDecimalToNull(trsDealChargesCO.getCR_ACC_CIF_SUB_NO()) == null
    			|| NumberUtil.emptyDecimalToNull(trsDealChargesCO.getCR_ACC_SL_NO()) == null)
    		{
    		    throw new BOException(MessageCodes.INVALID_ACCOUNT);
    		}

    		TRSDEALCHARGESVO trsdealchargesvo = new TRSDEALCHARGESVO();
    		trsDealChargesCO.setCOMP_CODE(trsDealChargesSC.getCompCode());
    		trsDealChargesCO.setBRANCH_CODE(trsDealChargesSC.getBranchCode());
    		trsDealChargesCO.setSERIAL_NO(trsDealChargesSC.getDealNo());
    		// lineNo = lineNo.add(BigDecimal.ONE);
    		trsDealChargesCO.setLINE_NO(lineNo);

    		if(trsDealChargesSC.getPageRefName().equalsIgnoreCase("PFX"))
    		{
    		    TRSPFXCHARGESVO trspfxchargesvo = new TRSPFXCHARGESVO();
    		    PathPropertyUtil.copyProperties(trsDealChargesCO, trspfxchargesvo);
    		    trspfxchargesvo.setPFX_TYPE(trsDealChargesSC.getPromissoryFxType());
    		    trspfxchargesvo.setPFX_EXTENSION_NO(BigDecimal.ZERO);
    		    lineNo = NumberUtil.emptyDecimalToZero(iisDealChargesDAO.returnMaxLineNbrPFX(trsDealChargesSC));
    		    lineNo = lineNo.add(BigDecimal.ONE);
    		    trspfxchargesvo.setLINE_NO(lineNo);
    		    if(NumberUtil.emptyDecimalToZero(trsDealChargesSC.getPfxCancellationNo())
    			    .compareTo(BigDecimal.ZERO) == 1 && trsDealChargesSC.getPromissoryFxType().equals("C"))
    		    {
    			trspfxchargesvo.setSERIAL_NO(trsDealChargesSC.getDealNo());// Setting
    			trspfxchargesvo.setPFX_CANCEL_NO(trsDealChargesSC.getPfxCancellationNo());
    			trspfxchargesvo.setPFX_CANCEL_YN("Y");
    			// the PFX no as serial_no column
    		    }
    		    genericDAO.insert(trspfxchargesvo);
    		}
    		else
    		{
    		    lineNo = lineNo.add(BigDecimal.ONE);
    		    trsDealChargesCO.setLINE_NO(lineNo);
    		    PathPropertyUtil.copyProperties(trsDealChargesCO, trsdealchargesvo);
    		    // TP# 744157
    		    if(StringUtil.isEmptyString(trsdealchargesvo.getBLOCKED_YN()))
    		    {
    			trsdealchargesvo.setBLOCKED_YN(ConstantsCommon.NO);
    		    }
    		    genericDAO.insert(trsdealchargesvo);
    		}
    	    }
    	    else
    	    {
    		throw new BOException(MessageCodes.CHARGES_CODE_MUST_BE_GREATER_THAN_0);
    	    }
    	}// TP# 713881 - adding validation for charges CY fields [END]
    	return iisReturnMessagesCO;

        }

    public void validateDealChargesForGeneralLimit(List<TrsDealChargesCO> trsDealChargesCOList,
	    TrsDealChargesSC trsDealChargesSC) throws BaseException
    {

	FMSCTRLVOKey fmsCtrlVoKey = new FMSCTRLVOKey();
	fmsCtrlVoKey.setCOMP_CODE(trsDealChargesSC.getCompCode());
	fmsCtrlVoKey.setBRANCH_CODE(trsDealChargesSC.getBranchCode());
	FMSCTRLVO fmsCtrlVo = (FMSCTRLVO) genericDAO.selectByPK(fmsCtrlVoKey);
	// PMD infractions; Saheer.Naduthodi; 10/12/2014
	if(fmsCtrlVo != null && fmsCtrlVo.getCIF_GEN_LIMIT() != null && fmsCtrlVo.getCIF_GEN_LIMIT().equals("Y"))
	{
	    BigDecimal totChargeAmtIncInPrin = BigDecimal.ZERO;

	    for(TRSDEALCHARGESVO trsdealChargesVO : trsDealChargesCOList)
	    {
		if(StringUtil.nullEmptyToValue(trsdealChargesVO.getCHARGE_TYPE(), "N").equals("Y"))
		{
		    totChargeAmtIncInPrin = totChargeAmtIncInPrin
			    .add(NumberUtil.nullToZero(trsdealChargesVO.getCHARGES_AMOUNT()));

		}
	    }

	    if(totChargeAmtIncInPrin.compareTo(BigDecimal.ZERO) == 1)
	    {
		TRSDEALVOKey trsdealvoKey = new TRSDEALVOKey();
		trsdealvoKey.setCOMP_CODE(trsDealChargesSC.getCompCode());
		trsdealvoKey.setBRANCH_CODE(trsDealChargesSC.getBranchCode());
		trsdealvoKey.setSERIAL_NO(trsDealChargesSC.getDealNo());
		TRSDEALVO trsdealVO = (TRSDEALVO) genericDAO.selectByPK(trsdealvoKey);

		FmsLimitsInputCO fmsLimitsInputCO = new FmsLimitsInputCO();
		fmsLimitsInputCO.setCompanyCode(trsDealChargesSC.getCompCode());
		fmsLimitsInputCO.setBranchCode(trsDealChargesSC.getBranchCode());
		fmsLimitsInputCO.setUserId(trsDealChargesSC.getUserId());
		fmsLimitsInputCO.setCifCode(trsdealVO.getCIF_NO());
		fmsLimitsInputCO.setDealCode(trsdealVO.getSERIAL_NO());
		fmsLimitsInputCO.setGeneralType(IISCommonConstants.FMS_LIMIT_GENERAL_TYPE);
		fmsLimitsInputCO.setProductClass(trsdealVO.getCLASS());
		fmsLimitsInputCO.setClassType(BigDecimal.ZERO);
		fmsLimitsInputCO.setSysDate(trsDealChargesSC.getRunningDate());
		fmsLimitsInputCO.setDrawDowncode(null);
		fmsLimitsInputCO.setPaidAmount(BigDecimal.ZERO);
		fmsLimitsInputCO.setDealFlag(null);
		fmsLimitsInputCO.setDrawdownFlag(null);
		fmsLimitsInputCO.setAutoDrwdwn(null);
		fmsLimitsInputCO.setDealType(trsdealVO.getDEAL_TYPE_BY_TERM());
		fmsLimitsInputCO.setCashFinance("Y");
		fmsLimitsInputCO.setTfaDdOrDdPrinted("N");
		fmsLimitsInputCO.setDrawdownBranch(trsdealVO.getBRANCH_CODE());
		fmsLimitsInputCO.setFacilityBranch(null);
		fmsLimitsInputCO.setFacilityCode(null);
		fmsLimitsInputCO.setSublimitNumber(null);
		fmsLimitsInputCO.setDealAmountOld(NumberUtil.emptyDecimalToZero(trsdealVO.getDEAL_AMOUNT()));
		fmsLimitsInputCO.setDealAmount(totChargeAmtIncInPrin);
		fmsLimitsInputCO.setDealYield(trsdealVO.getYIELD());
		fmsLimitsInputCO.setDealCy(trsdealVO.getDEAL_CY());
		fmsLimitsInputCO.setDealRate(trsdealVO.getDEAL_RATE());
		fmsLimitsInputCO.setDealUnit(trsdealVO.getDEAL_UNIT());
		fmsLimitsInputCO.setMultiDiv(trsdealVO.getDEAL_MULTDIV());
		fmsLimitsInputCO.setValueDate(trsdealVO.getVALUE_DATE());
		fmsLimitsInputCO.setMaturityDate(trsdealVO.getMATURITY_DATE());
		// PMD infractions; Saheer.Naduthodi; 12/01/2014
		fmsLimitsCommonBO.utilizeFMSLimit(fmsLimitsInputCO);

	    }

	}

    }

    /*
     * Method to check the input params for deal charges
     */
    public void validateDealChargesGridInputs(IisDealChargesCO iisDealChargesCO) throws BaseException
    {
	// TP#231436; Saheer.Naduthodi; 19/10/2014
	if(ConstantsCommon.NO.equals(StringUtil.nullEmptyToValue(iisDealChargesCO.getAllowEdit(), ConstantsCommon.YES)))
	{
	    throw new BOException(MessageCodes.CHARGES_CANNOT_DELETE_EDIT);
	}
	if(iisDealChargesCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	if(iisDealChargesCO.getDealAmount() == null || NumberUtil.toDouble(iisDealChargesCO.getDealAmount()) < 0)
	{
	    throw new BOException(MessageCodes.FIN_AMT_SHOULD_BE_GREATER_THAN_ZERO);
	}
	if(iisDealChargesCO.getCurrency() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_DEAL_CURRENCY);
	}
	if(iisDealChargesCO.getTrsDealChargesCO().getCHARGES_CODE() == null)
	{
	    throw new BOException(MessageCodes.INVALID_CHARGE_CODE);
	}
	// TP#250443; Ramesh; Date 21/12/2014 [START]
	TRSCLASSVO trsclassvo = new TRSCLASSVO();
	trsclassvo.setCODE(NumberUtil.emptyDecimalToZero(iisDealChargesCO.getProductClass()));
	trsclassvo.setCOMP_CODE(NumberUtil.emptyDecimalToZero(iisDealChargesCO.getCompCode()));
	trsclassvo = commonLibBO.returnTrsClassVO(trsclassvo);
	if(trsclassvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();
	iisctrlvoKey.setCOMP_CODE(iisDealChargesCO.getCompCode());
	iisctrlvoKey.setBRANCH_CODE(iisDealChargesCO.getBranchCode());
	IISCTRLVO iisctrlvo = iisCommonBO.returnIISCTRL(iisctrlvoKey);
	TRSCHARGESVOKey trschargesvoKey = new TRSCHARGESVOKey();
	trschargesvoKey.setCOMP_CODE(iisDealChargesCO.getCompCode());
	trschargesvoKey.setCODE(iisDealChargesCO.getTrsDealChargesCO().getCHARGES_CODE());
	TRSCHARGESVO trschargesvo = iisDealChargesDAO.getTrsChargeDetails(trschargesvoKey);
	if(StringUtil.nullEmptyToValue(trschargesvo.getCREDIT_TO_SD_ACCOUNT_YN(), ConstantsCommon.NO)
		.equals(ConstantsCommon.YES))
	{
	    int count = NumberUtil.nullToZero(iisDealChargesDAO.returnTrsClassNostroAccountDetails(iisDealChargesCO));
	    if((trsclassvo.getCATEGORY().compareTo(BigDecimal.ONE) == 0)
		    || (trsclassvo.getCATEGORY().compareTo(BigDecimal.valueOf(2)) == 0)
		    || (trsclassvo.getCATEGORY().compareTo(BigDecimal.valueOf(19)) == 0)
		    || (trsclassvo.getCATEGORY().compareTo(BigDecimal.valueOf(23)) == 0)
		    || (trsclassvo.getCATEGORY().compareTo(BigDecimal.valueOf(25)) == 0))
	    {
		throw new BOException(MessageCodes.CANNOT_PROCEED,
			new String[] { "SD_Charge_cannot_be_Applied_for_this_Category_Key" });
	    }
	    else if((count != 0)
		    || !(StringUtil.nullEmptyToValue(iisctrlvo.getTRADE_SALES_AC_REQUIRED(), ConstantsCommon.NO)
			    .equals(ConstantsCommon.NO))
		    || !(StringUtil
			    .nullEmptyToValue(trsclassvo.getINITIAL_PAYMENT_TYPE(),
				    IISCommonConstants.PAYMENT_TYPE_COMPOUND_PROFIT)
			    .equals(IISCommonConstants.PAYMENT_TYPE_SPECIFIC_AMOUNT)))
	    {

		throw new BOException(MessageCodes.CANNOT_PROCEED,
			new String[] { "SD_Charge_cannot_be_linked_as_SD_Account_will_not_be_created_Key" });

	    }
	}
	// TP#250443; Ramesh; Date 21/12/2014 [END]

    }

    // TP#190558; Saheer.Naduthodi; 20/07/2014 [START]
    // PB_function : wf_setting_deal_charges
    @Override
    public List<TrsDealChargesCO> applyDealCharges(TrsDealChargesSC trsDealChargesSC) throws BaseException
    {
	TRSCLASSVO trsclassvo = new TRSCLASSVO();
	trsclassvo.setCODE(NumberUtil.emptyDecimalToZero(trsDealChargesSC.getProdClass()));
	trsclassvo.setCOMP_CODE(NumberUtil.emptyDecimalToZero(trsDealChargesSC.getCompCode()));
	trsclassvo = commonLibBO.returnTrsClassVO(trsclassvo);
	if(trsclassvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	List<TrsDealChargesCO> productClassChargesList = iisDealChargesDAO.returnProductClassCharges(trsDealChargesSC);

	if(!productClassChargesList.isEmpty())
	{
	    int i = 1;
	    for(TrsDealChargesCO chargesCo : productClassChargesList)
	    {

		TRSCHARGESVOKey trschargesvoKey = new TRSCHARGESVOKey();
		trschargesvoKey.setCODE(chargesCo.getCHARGES_CODE());
		trschargesvoKey.setCOMP_CODE(trsDealChargesSC.getCompCode());
		TRSCHARGESVO trschargesvo = (TRSCHARGESVO) genericDAO.selectByPK(trschargesvoKey);
		trschargesvoKey = null;
		if(trschargesvo == null)
		{
		    throw new BOException(MessageCodes.INVALID_CHARGE_CODE);
		}
		trschargesvo.setVAT_CODE(NumberUtil.nullToZero(trschargesvo.getVAT_CODE()));

		trsclassvo.setEXCLUDE_CHARGES(
			StringUtil.nullEmptyToValue(trsclassvo.getEXCLUDE_CHARGES(), ConstantsCommon.NO));

		if(ConstantsCommon.YES.equals(StringUtil.nullToEmpty(chargesCo.getCHARGE_TYPE()))
			&& ConstantsCommon.NO.equals(trsclassvo.getEXCLUDE_CHARGES())
			|| ConstantsCommon.YES.equals(StringUtil.nullEmptyToValue(
				chargesCo.getTRSCHARGES_PERCENTAGE_OF_PROFIT_YN(), ConstantsCommon.NO))
			|| ConstantsCommon.YES.equals(StringUtil.nullToEmpty(chargesCo.getCHARGE_AMT_PER_INST_YN()))
			|| trschargesvo.getVAT_CODE().compareTo(BigDecimal.ZERO) == 1
			|| ConstantsCommon.YES.equals(StringUtil.nullToEmpty(chargesCo.getCOLLECT_CHARGE_AT_DEAL_YN())))
		{
		    chargesCo.setPAY_AT_DEAL_CLOSURE_YN(ConstantsCommon.NO);
		}
		BigDecimal accBranch;
		BigDecimal accGL;
		BigDecimal accCIF;
		BigDecimal accSL;
		BigDecimal accCY;
		if(ConstantsCommon.YES.equals(StringUtil.nullToEmpty(chargesCo.getPAY_AT_DEAL_CLOSURE_YN())))
		{
		    accGL = chargesCo.getDrAccGL();
		    accCIF = chargesCo.getDrAccCifSubNo();
		    accSL = chargesCo.getDrAccSL();
		    accBranch = chargesCo.getDrAccBranch();
		    accCY = chargesCo.getDrAccCurrency();
		}
		else
		{
		    accGL = chargesCo.getCR_ACC_GL();
		    accCIF = chargesCo.getCR_ACC_CIF_SUB_NO();
		    accSL = chargesCo.getCR_ACC_SL_NO();
		    accBranch = chargesCo.getCR_ACC_BRANCH();
		    accCY = chargesCo.getCR_ACC_CURRENCY();
		}

		// ls_collect_charges_account_type = lds_charges.GetItemString
		// (ll_row,'collect_charges_account_type')

		String specificAccBrCy = StringUtil.nullToEmpty(chargesCo.getSpecificAccBrCy());

		if("N".equals(specificAccBrCy))
		{
		    accCY = trsDealChargesSC.getDealCY();
		    accBranch = trsDealChargesSC.getBranchCode();
		}
		else if("B".equals(specificAccBrCy))
		{
		    accCY = trsDealChargesSC.getDealCY();
		}
		else if("C".equals(specificAccBrCy))
		{
		    accBranch = trsDealChargesSC.getBranchCode();
		}
		if(accCY == null)
		{
		    accCY = trsDealChargesSC.getDealCY();
		}
		if(accBranch == null)
		{
		    accBranch = trsDealChargesSC.getBranchCode();
		}

		// If IsNull(ls_collect_charges_account_type) Then
		// ls_collect_charges_account_type = 'R'
		// BigDecimal ldec_percentage =
		// chargesCo.getCHARGES_PERCENTAGE();

		// wf_reset_payplan()
		chargesCo.setCOMP_CODE(trsDealChargesSC.getCompCode());
		chargesCo.setBRANCH_CODE(trsDealChargesSC.getBranchCode());
		chargesCo.setSERIAL_NO(trsDealChargesSC.getDealNo());
		chargesCo.setLINE_NO(BigDecimal.valueOf(i));
		chargesCo.setCR_ACC_BRANCH(accBranch);
		chargesCo.setCR_ACC_CURRENCY(accCY);
		// dw_deal_charges.SetITem( ll_new_row, "cf_currency", al_cy )
		// dw_deal_charges.SetITem( ll_new_row, "cf_decimal_points",
		// al_dec_pts )
		chargesCo.setCR_ACC_GL(accGL);
		chargesCo.setCR_ACC_CIF_SUB_NO(accCIF);
		chargesCo.setCR_ACC_SL_NO(accSL);
		// chargesCo.setCOLLECT_CHARGES_ACCOUNT_TYPE(ls_collect_charges_account_type)
		// ;
		// dw_deal_charges.SetITem( ll_new_row, "cf_crud", iv_crud )
		// dw_deal_charges.SetITem( ll_new_row, "trsdeal_status",
		// as_deal_status)

		// dw_deal_charges.SetITem(
		// ll_new_row,'trsdealcharges_charges_percentage',
		// ldec_percentage)

		// if ( wf_classname() = 'w_maintain_forex' or wf_classname() =
		// 'w_maintain_forex_swap' or wf_classname()
		// ='w_maintain_promissory_fx_exercise_mat' or wf_classname()
		// ='w_maintain_promissory_fx_exercise_early') then
		// else
		// dw_deal_charges.SetITem
		// (ll_new_row,'trsdealcharges_pay_at_deal_closure_yn',
		// ls_trscharges_pay_at_deal_closure_yn)
		// end if
		if(ConstantsCommon.NO.equals(trsclassvo.getEXCLUDE_CHARGES()))
		{
		    chargesCo.setCHARGE_TYPE(chargesCo.getCHARGE_TYPE());
		}
		else
		{
		    chargesCo.setCHARGE_TYPE(ConstantsCommon.NO);
		}

		// IF ls_percentage_of_profit_yn = 'Y' AND ls_charge_type = 'Y'
		// AND ll_category = 4 AND ll_drwdwn_no > 0 AND
		// ldec_deal_period_yield > 0 THEN
		// dw_deal_charges.SetITem( ll_new_row,
		// "trscharges_percentage_of_profit_yn",
		// ls_percentage_of_profit_yn )
		// END IF
		chargesCo.setTRSCHARGES_CREDIT_TO_SD_ACCOUNT_YN(StringUtil
			.nullEmptyToValue(chargesCo.getTRSCHARGES_CREDIT_TO_SD_ACCOUNT_YN(), ConstantsCommon.NO));
		//
		//
		// Long ll_calc
		// If IsNull(is_calculator) or Trim(is_calculator) = '' Then
		// ll_calc = 0
		// Else
		// ll_calc = 1
		// End If
		// dw_deal_charges.SetITem(ll_new_row,'is_calc',ll_calc)

		// dw_deal_charges.SetITem(ll_new_row,'include_chg',ls_exclude_charges)

		// Cideve 02112009 VAT Al Baraka Bank Algeria, PTRK0000242 Start

		// if("Y".equals(ls_charge_type))
		{
		    TRSVATVOKey trsvatvoKey = new TRSVATVOKey();
		    trsvatvoKey.setCOMP_CODE(trsDealChargesSC.getCompCode());
		    trsvatvoKey.setVAT_CODE(trschargesvo.getVAT_CODE());
		    TRSVATVO trsvatvo = (TRSVATVO) genericDAO.selectByPK(trsvatvoKey);
		    trsvatvoKey = null;
		    if(trsvatvo != null)
		    {
			chargesCo.setVAT_BRIEF_NAME_ENG(trsvatvo.getBRIEF_NAME_ENG());
		    }
		    trsvatvo = null;
		}
		// else
		// {
		// chargesCo.setVAT_CODE(null);
		//
		// }
		// dw_deal_charges.setitem
		// (ll_new_row,'allow_to_edit_vat',ls_allow_to_edit_vat_code_charges)
		// TP#210840; Ravikant.Singh; 28/08/2014[start]
		if(NumberUtil.isEmptyDecimal(chargesCo.getCHARGES_AMOUNT())
			&& !NumberUtil.isEmptyDecimal(chargesCo.getFLAT_AMOUNT()))
		{
		    BigDecimal dealCurrencyDecimalFormat = BigDecimal.ZERO;
		    if(!NumberUtil.isEmptyDecimal(trsDealChargesSC.getDealCY()))
		    {
			CURRENCIESVO dealCurrency = new CURRENCIESVO();
			dealCurrency.setCOMP_CODE(trsDealChargesSC.getCompCode());
			dealCurrency.setCURRENCY_CODE(trsDealChargesSC.getDealCY());
			dealCurrency = commonLibBO.returnCurrency(dealCurrency);

			if(dealCurrency != null && !NumberUtil.isEmptyDecimal(dealCurrency.getDECIMAL_POINTS()))
			{
			    dealCurrencyDecimalFormat = dealCurrency.getDECIMAL_POINTS();

			}

		    }
		    if(dealCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) > 0)
		    {
			chargesCo.setCHARGES_AMOUNT(NumberUtil.roundToBigDecimal(chargesCo.getFLAT_AMOUNT(),
				dealCurrencyDecimalFormat.intValue()));
		    }
		    else
		    {
			chargesCo.setCHARGES_AMOUNT(chargesCo.getFLAT_AMOUNT());
		    }
		}
		if(NumberUtil.isEmptyDecimal(chargesCo.getCHARGES_AMT_CV())
			&& !NumberUtil.isEmptyDecimal(chargesCo.getFLAT_AMOUNT()))
		{
		    if(NumberUtil.isEmptyDecimal(trsDealChargesSC.getBaseCyDecimalPoint())
			    || trsDealChargesSC.getBaseCyDecimalPoint().compareTo(BigDecimal.ZERO) <= 0)
		    {
			chargesCo.setCHARGES_AMT_CV(chargesCo.getFLAT_AMOUNT());
		    }
		    else
		    {
			chargesCo.setCHARGES_AMT_CV(NumberUtil.roundToBigDecimal(chargesCo.getFLAT_AMOUNT(),
				trsDealChargesSC.getBaseCyDecimalPoint().intValue()));
		    }

		}
		if(NumberUtil.isEmptyDecimal(chargesCo.getCHARGES_AMT_FC())
			&& !NumberUtil.isEmptyDecimal(chargesCo.getFLAT_AMOUNT()))
		{
		    BigDecimal chargeCurrencyDecimalFormat = BigDecimal.ZERO;
		    if(!NumberUtil.isEmptyDecimal(accCY))
		    {
			CURRENCIESVO chargeCurrency = new CURRENCIESVO();
			chargeCurrency.setCOMP_CODE(trsDealChargesSC.getCompCode());
			chargeCurrency.setCURRENCY_CODE(accCY);
			chargeCurrency = commonLibBO.returnCurrency(chargeCurrency);

			if(chargeCurrency != null && !NumberUtil.isEmptyDecimal(chargeCurrency.getDECIMAL_POINTS()))
			{
			    chargeCurrencyDecimalFormat = chargeCurrency.getDECIMAL_POINTS();
			}
		    }

		    if(chargeCurrencyDecimalFormat.compareTo(BigDecimal.ZERO) > 0)
		    {
			chargesCo.setCHARGES_AMT_FC(NumberUtil.roundToBigDecimal(chargesCo.getFLAT_AMOUNT(),
				chargeCurrencyDecimalFormat.intValue()));
		    }
		    else
		    {
			chargesCo.setCHARGES_AMT_FC(chargesCo.getFLAT_AMOUNT());
		    }
		}

		chargesCo.setCHARGES_MULTDIV("M");
		CURRENCIESVOKey currenciesvoKey = new CURRENCIESVOKey();
		currenciesvoKey.setCOMP_CODE(trsDealChargesSC.getCompCode());
		currenciesvoKey.setCURRENCY_CODE(accCY);
		CURRENCIESVO currenciesvo = (CURRENCIESVO) genericDAO.selectByPK(currenciesvoKey);
		currenciesvoKey = null;
		if(currenciesvo != null)
		{
		    chargesCo.setDealChargesFormat(currenciesvo.getDECIMAL_POINTS());
		}
		currenciesvo = null;

		i++;
	    }

	    // TP#222679; Hari ; 19/09/2014
	    IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	    iisDealChargesCO.setCompCode(trsDealChargesSC.getCompCode());
	    iisDealChargesCO.setBaseCurrencyCode(trsDealChargesSC.getBaseCurrencyCode());
	    iisDealChargesCO.setCurrency(NumberUtil.nullToZero(trsDealChargesSC.getDealCY()));
	    iisDealChargesCO.setProductClass(NumberUtil.nullToZero(trsDealChargesSC.getProdClass()));

	    // TP# 220154; Ravikant.Singh ;22/09/2014
	    iisDealChargesCO
		    .setCompanyContributionAmount(NumberUtil.nullToZero(trsDealChargesSC.getTotalCompContrib()));

	    productClassChargesList = calculateChargeAmount(productClassChargesList, iisDealChargesCO);

	}

	return productClassChargesList;
    }

    // TP#190558; Saheer.Naduthodi; 20/07/2014 [END]
    @Override
    public List<TrsDealChargesCO> returnPFXCharges(TrsDealChargesSC trsDealChargesSC) throws BaseException
    {
	return iisDealChargesDAO.returnPFXCharges(trsDealChargesSC);
    }

    // TP#271602;Ravikant.Singh ;16/02/2015[start]
    @Override
    public List<TrsDealChargesCO> returnDealChargesFromFacility(TrsDealChargesSC trsDealChargesSC) throws BaseException
    {

	// TP#335814 ;Arun R Variyath ; 09/10/2015 [Start]
	BigDecimal facilitySubLineNbr = NumberUtil.nullToZero(trsDealChargesSC.getFacilitySubLineNbr());
	// if(facilityType.equals(IISCommonConstants.FMS_GENERAL_TYPE))
	// {
	// TrsDealChargesSC fmsFacilitySCLimitLine =
	// iisDealChargesDAO.returnSubLimitLineCount(trsDealChargesSC);
	//
	// if(fmsFacilitySCLimitLine.getSubLimitLineCount().compareTo(BigDecimal.ONE)
	// == 1)
	// {
	// throw new BOException(MessageCodes.CANNOT_PROCEED,
	// new String[] {
	// "SD_Charge_cannot_be_Applied_for_this_Category_Key" });
	// throw new
	//
	// BOException(MessageCodes.PLEASE_SELECT_FROM_LOOKUP_AS_FACILITY_HAVE_SUBLIMIT);
	// }
	//
	// facilitySubLineNbr = fmsFacilitySCLimitLine.getFacilitySubLineNbr();
	// }
	// else
	// {
	// facilitySubLineNbr = BigDecimal.ZERO;
	// }
	// TP#335814 ;Arun R Variyath ; 09/10/2015 [End]

	trsDealChargesSC.setFacilitySubLineNbr(facilitySubLineNbr);
	List<TrsDealChargesCO> lsTrsDealChargesCO = iisDealChargesDAO.returnDealChargesFromFacility(trsDealChargesSC);

	for(TrsDealChargesCO trsDealChargesCO : lsTrsDealChargesCO)
	{
	    // Getting the charges details directly from TRSCHARGES table
	    TRSCHARGESVOKey trschargesvoKey = new TRSCHARGESVOKey();
	    trschargesvoKey.setCOMP_CODE(trsDealChargesSC.getCompCode());
	    trschargesvoKey.setCODE(trsDealChargesCO.getCHARGES_CODE());
	    TRSCHARGESVO trschargesVO = null;
	    if(trsDealChargesSC.getCompCode() != null && trsDealChargesCO.getCHARGES_CODE() != null)
	    {
		trschargesVO = iisDealChargesDAO.getTrsChargeDetails(trschargesvoKey);
	    }
	    if(trschargesVO != null)
	    {
		trsDealChargesCO.setLsBriefNameeng(trschargesVO.getBRIEF_NAME_ENG());
	    }
	}
	IisDealChargesCO iisDealChargesCO = new IisDealChargesCO();
	iisDealChargesCO.setCompCode(trsDealChargesSC.getCompCode());
	iisDealChargesCO.setBaseCurrencyCode(trsDealChargesSC.getBaseCurrencyCode());
	iisDealChargesCO.setCurrency(NumberUtil.nullToZero(trsDealChargesSC.getDealCY()));
	iisDealChargesCO.setProductClass(NumberUtil.nullToZero(trsDealChargesSC.getProdClass()));
	iisDealChargesCO.setCompanyContributionAmount(NumberUtil.nullToZero(trsDealChargesSC.getTotalCompContrib()));
	iisDealChargesCO.setCallType("O");
	iisDealChargesCO.setDealAmount(trsDealChargesSC.getDealAmt());
	
	 //TP 574018 Hari.K.S 11/10/2017
	 iisDealChargesCO.setValueDate(trsDealChargesSC.getRunningDate());
	 iisDealChargesCO.setMaturityDate(trsDealChargesSC.getMaturityDate());
	// #TAR AIBBI190106 ;Rakesh ; 12/02/2019 [start]
	// lsTrsDealChargesCO = calculateChargeAmount(lsTrsDealChargesCO,
	// iisDealChargesCO);
	lsTrsDealChargesCO = calculateFMSChargeAmount(lsTrsDealChargesCO, iisDealChargesCO);
	// #TAR AIBBI190106 ;Rakesh ; 12/02/2019 [end]
	return lsTrsDealChargesCO;
    }

    // #TAR AIBBI190106 ;Rakesh ; 12/02/2019 [start]
    private List<TrsDealChargesCO> calculateFMSChargeAmount(List<TrsDealChargesCO> lsTrsDealChargesCO,
	    IisDealChargesCO iisDealChargesCOTmp) throws BaseException
    {
	if(!lsTrsDealChargesCO.isEmpty())
	{

	    CURRENCIESVO baseCurrency = new CURRENCIESVO();
	    baseCurrency.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
	    baseCurrency.setCURRENCY_CODE(iisDealChargesCOTmp.getBaseCurrencyCode());
	    baseCurrency = commonLibBO.returnCurrency(baseCurrency);
	    BigDecimal baseCurrencyDecimalFormat = baseCurrency.getDECIMAL_POINTS();

	    CURRENCIESVO chargeCurrency = new CURRENCIESVO();
	    chargeCurrency.setCOMP_CODE(iisDealChargesCOTmp.getCompCode());
	    for(int i = 0; i < lsTrsDealChargesCO.size(); i++)
	    {
		BigDecimal chargeCurrencyDecimalFormat = BigDecimal.ZERO;
		if(!NumberUtil.isEmptyDecimal(lsTrsDealChargesCO.get(i).getCR_ACC_CURRENCY()))
		{
		    chargeCurrency.setCURRENCY_CODE(lsTrsDealChargesCO.get(i).getCR_ACC_CURRENCY());
		    chargeCurrency = commonLibBO.returnCurrency(chargeCurrency);

		    if(chargeCurrency != null && !NumberUtil.isEmptyDecimal(chargeCurrency.getDECIMAL_POINTS()))
		    {
			chargeCurrencyDecimalFormat = chargeCurrency.getDECIMAL_POINTS();
		    }
		}
		if(doubleValue(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT()) > 0)
		{
		    IISCommonCO iisCommonCO = new IISCommonCO();
		    iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
		    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
		    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
		    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
		    iisCommonCO.setTrCurrency(iisDealChargesCOTmp.getCurrency());// Transaction
										 // currency
		    iisCommonCO.setPfCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// Base
											 // currency
		    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());
		    iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);

		    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
		    {

			lsTrsDealChargesCO.get(i)
				.setCHARGES_AMT_CV(NumberUtil.roundToBigDecimal(
					new BigDecimal(doubleValue(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT())
						* doubleValue(iisCommonCO.getCrossRate())),
					baseCurrencyDecimalFormat.intValue()));

		    }
		    else
		    {
			throw new BOException(MessageCodes.INVALID_EXCHANGE_RATE);
		    }
		    iisCommonCO.setCompCode(iisDealChargesCOTmp.getCompCode());
		    iisCommonCO.setBaseCurrencyCode(iisDealChargesCOTmp.getBaseCurrencyCode());
		    iisCommonCO.setBranchCode(iisDealChargesCOTmp.getBranchCode());
		    iisCommonCO.setCifNo(iisDealChargesCOTmp.getCifNo());
		    iisCommonCO.setTrCurrency(iisDealChargesCOTmp.getBaseCurrencyCode());// Transaction
											 // currency
		    iisCommonCO.setPfCurrency(lsTrsDealChargesCO.get(i).getCR_ACC_CURRENCY());// Base
											      // currency
		    iisCommonCO.setCrossDate(iisDealChargesCOTmp.getValueDate());

		    if(iisCommonCO.getPfCurrency() == null)
		    {
			iisCommonCO.setCrossRate(BigDecimal.ONE);
		    }
		    else
		    {
			iisCommonCO = iisCommonBO.returnCrossRate(iisCommonCO);
		    }

		    if(iisCommonCO.getCrossRate() != null && doubleValue(iisCommonCO.getCrossRate()) > 0)
		    {

			lsTrsDealChargesCO.get(i)
				.setCHARGES_AMT_FC(NumberUtil.roundToBigDecimal(
					new BigDecimal(doubleValue(lsTrsDealChargesCO.get(i).getCHARGES_AMOUNT())
						* doubleValue(iisCommonCO.getCrossRate())),
					chargeCurrencyDecimalFormat.intValue()));
			lsTrsDealChargesCO.get(i).setEXCH_RATE(iisCommonCO.getCrossRate());
		    }
		    else
		    {
			throw new BOException(MessageCodes.INVALID_EXCHANGE_RATE);
		    }
		    iisCommonCO = null;
		}
	    }
	}
	return lsTrsDealChargesCO;
    }
    
	// TP# 870190 BAJ Fawas.Kuruvakkottil 30/08/2019 Start
    public IISReturnMessagesCO validateDealChargesForLeasedAsset(List<TrsDealChargesCO> trsDealChargesCOList,
	    List<TRSDEAL_ASSET_VNDR_INCENTIVEVO> assetVendorIncentiveGridList, IISReturnMessagesCO iisReturnMessagesCO,
	    BigDecimal compCode, BigDecimal branchCode, BigDecimal serialNo) throws BaseException
    {
	BigDecimal totalAdjustToDealCharges = BigDecimal.ZERO;
	BigDecimal totalVendorDiscountAmount = BigDecimal.ZERO;
	if(assetVendorIncentiveGridList == null || assetVendorIncentiveGridList.isEmpty())
	{
	    TrsDealChargesSC trsDealChargesSC = new TrsDealChargesSC();
	    trsDealChargesSC.setCompCode(compCode);
	    trsDealChargesSC.setBranchCode(branchCode);
	    trsDealChargesSC.setDealNo(serialNo);
	    if(!NumberUtil.isEmptyDecimal(serialNo))
	    {
//		assetVendorIncentiveGridList = iisDealChargesDAO.loadAssetVendorIncentiveList(trsDealChargesSC);
	    }
	}
	if(assetVendorIncentiveGridList != null && !assetVendorIncentiveGridList.isEmpty()
		&& trsDealChargesCOList == null)
	{
	    throw new BOException(MessageCodes.SELECT_CHARGES_TO_BE_ADJUSTED_TO_VENDOR_DISCOUNT_CONTRIBUTION);
	}
	if(trsDealChargesCOList != null && !trsDealChargesCOList.isEmpty())
	{
	    for(TrsDealChargesCO dealChargesCO : trsDealChargesCOList)
	    {
		totalVendorDiscountAmount = totalVendorDiscountAmount
			.add(NumberUtil.nullToZero(dealChargesCO.getADJUST_VENDOR_DISCOUNT_AMOUNT()));
		if(NumberUtil.nullToZero(dealChargesCO.getCHARGES_AMOUNT())
			.compareTo(NumberUtil.nullToZero(dealChargesCO.getADJUST_VENDOR_DISCOUNT_AMOUNT())) < 0)
		{
		    throw new BOException(
			    MessageCodes.SELECTED_VENDOR_DISCOUNT_CONTRIBUTION_GREATER_THAN_CHARGE_AMOUNT);
		}
		if(assetVendorIncentiveGridList == null && trsDealChargesCOList != null && dealChargesCO != null
			&& !NumberUtil.isEmptyDecimal(dealChargesCO.getADJUST_VENDOR_DISCOUNT_AMOUNT()))
		{
		    throw new BOException(MessageCodes.SELECT_VENDOR_INCENTIVE_SCHEME_TO_ADJUST_CHARGES);
		}
	    }
	}

	if(assetVendorIncentiveGridList != null && !assetVendorIncentiveGridList.isEmpty())
	{
	    for(TRSDEAL_ASSET_VNDR_INCENTIVEVO assetVendorIncentiveVO : assetVendorIncentiveGridList)
	    {
		totalAdjustToDealCharges = totalAdjustToDealCharges
			.add(NumberUtil.nullToZero(assetVendorIncentiveVO.getADJUST_TO_DEAL_CHARGES()));
	    }
	}
	if(totalVendorDiscountAmount.compareTo(totalAdjustToDealCharges) > 0)
	{
	    throw new BOException(MessageCodes.SELECTED_CHARGES_GREATER_THAN_TOTAL_VENDOR_CONTRIBUTION);
	}
	else if(totalVendorDiscountAmount.compareTo(totalAdjustToDealCharges) < 0)
	{
	    iisCommonBO.addExceptionToList(iisReturnMessagesCO, new BOException(
		    MessageCodes.SELECTED_CHARGES_AMOUNT_LESS_THAN_TOTAL_VENDOR_DISCOUNT_CONTRIBUTION_DO_YOU_WANT_TO_CONTINUE,
		    ConstantsCommon.CONFIRM_MSG_TYPE, "CHARGES_AMOUNT_LESS_THAN_TOTAL_VENDOR_DISCOUNT", false));
	}

	return iisReturnMessagesCO;
	// TP# 870190 BAJ Fawas.Kuruvakkottil 30/08/2019 End
    }
    
}
// #TAR AIBBI190106 ;Rakesh ; 12/02/2019 [end]