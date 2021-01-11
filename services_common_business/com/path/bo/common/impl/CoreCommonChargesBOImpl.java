/**
 *
 */
package com.path.bo.common.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.requests.csm.CtsRequestConstant;
import com.path.bo.core.common.CoreCommonChargesBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.currency.CurrencyBO;
import com.path.bo.core.entitycharges.EntityChargesBO;
import com.path.bo.core.entitycharges.EntityChargesConstant;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.dao.common.CoreCommonChargesDAO;
import com.path.dbmaps.vo.ACC_VATVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTSTRS_ACC_DETVO;
import com.path.dbmaps.vo.CTSTRS_CHARGES_DETVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTS_CHARGES_UNIFIEDVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.CommonLibCO;
import com.path.vo.common.entitycharges.EntityChargesSC;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.entitycharges.EntityChargesCO;
import com.path.vo.core.gl.GLSC;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntChargesCO;
import com.path.vo.core.trxmgnt.TrxMgntChargesSC;
import com.path.vo.core.trxmgnt.TrxMgntSC;
import com.path.vo.core.trxmgnt.WithholdingSC;
import com.path.vo.core.trxmgnt.accountdtl.TrxMgntAccountDtlCO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 *
 * @author: nabilfeghali
 *
 * CoreCommonChargesBOImpl.java used to
 */
public class CoreCommonChargesBOImpl extends RetailBaseBO implements CoreCommonChargesBO
{
    private EntityChargesBO entityChargesBO;
    private CoreCommonChargesDAO coreCommonChargesDAO;
    private CurrencyBO currencyBO;


    public void setEntityChargesBO(EntityChargesBO entityChargesBO)
    {
	this.entityChargesBO = entityChargesBO;
    }

    /**
     * Sets the Charge Branch and Currency
     *
     * @param 	TrxMgntChargesSC
     * 		TrxMgntCO
     * @return TrxMgntChargesSC
     * @throws BaseException
     */
    public TrxMgntChargesSC returnChargeAcc(TrxMgntChargesSC trxMgntChargesSC, TrxMgntCO trxMgntCO) throws BaseException
    {


	trxMgntChargesSC.setBranchBooking(selectChargeBr(trxMgntCO));

	/*
	 * Set Charges Booking
	 */
	//	String chargeBooking = trxMgntCO.getPthCtrlVO().getCHARGES_BOOKING();
	//
	//	if(chargeBooking.equals(TrxMgntConstant.CHARGES_BOOKING_A))
	//	{
	trxMgntChargesSC.setChargeCy(selectChargeCy(trxMgntCO));
	//	}
	//	else
	//	{
	//	    trxMgntChargesSC.setChargeCy(trxMgntCO.getBaseCurrencyCode());
	//	}

	return trxMgntChargesSC;
    }

    /**
     * This function selects the branch to be used by charges based on
     * n_transaction.uf_select_charge_br
     *
     * @param TrxMgntCO
     * @return BigDecimal
     * @throws BaseException
     */
    public BigDecimal selectChargeBr(TrxMgntCO trxMgntCO) throws BaseException
    {
	String deduct;
	String trsfrMethod;
	BigDecimal chargeBranch;

	deduct = StringUtil.nullToEmpty(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND());
	trsfrMethod = StringUtil.nullToEmpty(trxMgntCO.getCtstrsVO().getTRSFR_METHOD());

	/*
	 * Set Default Value
	 */
	chargeBranch = trxMgntCO.getCtstrsVO().getTRS_AC_BR();

	if(TrxMgntConstant.CASH_TRSFR.equals(trsfrMethod)
		&& (TrxMgntConstant.DEDUCT_CASH.equals(deduct) || TrxMgntConstant.DEDUCT_FROM_DEBTOR.equals(deduct)))
	{
	    /*
	     * To Account is used
	     */
	    chargeBranch = trxMgntCO.getCtstrsVO().getTO_TRS_AC_BR();
	}
	else if(TrxMgntConstant.DEDUCT_CASH.equals(deduct) || TrxMgntConstant.DEDUCT_FROM_ACCOUNT.equals(deduct)
		|| TrxMgntConstant.DEDUCT_FROM_TELLER_ACC.equals(deduct))
	{
	    /*
	     * From account is used
	     */
	    chargeBranch = trxMgntCO.getCtstrsVO().getTRS_AC_BR();
	}
	else if(TrxMgntConstant.DEDUCT_FROM_CREDITOR.equals(deduct))
	{
	    /*
	     * Credit account is used
	     */
	    if(TrxMgntConstant.MAIN_ACC_CR.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX())))
	    {
		chargeBranch = trxMgntCO.getCtstrsVO().getTRS_AC_BR();
	    }
	    else
	    {
		chargeBranch = trxMgntCO.getCtstrsVO().getTO_TRS_AC_BR();
	    }

	}
	else if(deduct.equals(TrxMgntConstant.DEDUCT_FROM_DEBTOR))
	{
	    /*
	     * Debit account is used
	     */
	    if(TrxMgntConstant.MAIN_ACC_CR.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX())))
	    {
		chargeBranch = trxMgntCO.getCtstrsVO().getTO_TRS_AC_BR();
	    }
	    else
	    {
		chargeBranch = trxMgntCO.getCtstrsVO().getTRS_AC_BR();
	    }
	}
	else if(TrxMgntConstant.DEDUCT_FROM_OTHER_ACC.equals(deduct))
	{
	    /*
	     * Charge Account is used, else if it is null use From account
	     */
	    chargeBranch = trxMgntCO.getCtstrsVO().getCH_AC_BR();
	    if(chargeBranch == null)
	    {
		chargeBranch = trxMgntCO.getCtstrsVO().getTRS_AC_BR();
	    }
	}



	return chargeBranch;

    }

    /**
     * This function selects the currency to be used by charges based on
     * n_transaction.uf_select_charge_cy
     *
     * @param TrxMgntCO
     * @return BigDecimal
     * @throws BaseException
     */
    public BigDecimal selectChargeCy(TrxMgntCO trxMgntCO) throws BaseException
    {

	String deduct;
	BigDecimal chargeCurrency;

	deduct = StringUtil.nullToEmpty(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND());

	/*
	 * Set Default Value
	 */
	chargeCurrency = trxMgntCO.getCtstrsVO().getTRS_AC_CY();

	if(deduct.equals(TrxMgntConstant.DEDUCT_CASH) || deduct.equals(TrxMgntConstant.DEDUCT_FROM_TELLER_ACC))
	{
	    /*
	     * If default main account to teller account then main account, else
	     * transaction currency
	     */
	    if(TrxMgntConstant.DEFAULT_DR_ACC_TELLER.equals(trxMgntCO.getCtstrxtypeVO().getDEFAULT_DR_ACC_TELLER()))
	    {
		chargeCurrency = trxMgntCO.getCtstrsVO().getTRS_AC_CY();
	    }
	    else
	    {
		chargeCurrency = trxMgntCO.getCtstrsVO().getTRS_CY();
	    }
	}
	else if(deduct.equals(TrxMgntConstant.DEDUCT_FROM_ACCOUNT))
	{
	    /*
	     * Use Main Account
	     */
	    chargeCurrency = trxMgntCO.getCtstrsVO().getTRS_AC_CY();
	}
	else if(deduct.equals(TrxMgntConstant.DEDUCT_FROM_CREDITOR))
	{
	    /*
	     * If Main Account is credit then use Main Account else Transaction
	     * Currency
	     */
	    if(TrxMgntConstant.MAIN_ACC_CR.equals(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX()))
	    {
		chargeCurrency = trxMgntCO.getCtstrsVO().getTRS_AC_CY();
	    }
	    else
	    {
		chargeCurrency = trxMgntCO.getCtstrsVO().getTRS_CY();
	    }
	}
	else if(deduct.equals(TrxMgntConstant.DEDUCT_FROM_DEBTOR))
	{
	    /*
	     * If Main Account is Credit then Transaction Currency else Main
	     * Account
	     */
	    if(TrxMgntConstant.MAIN_ACC_CR.equals(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX()))
	    {
		chargeCurrency = trxMgntCO.getCtstrsVO().getTRS_CY();
	    }
	    else
	    {
		chargeCurrency = trxMgntCO.getCtstrsVO().getTRS_AC_CY();
	    }

	}
	else if(deduct.equals(TrxMgntConstant.DEDUCT_FROM_OTHER_ACC))
	{
	    /*
	     * User Charge Account else if null use Main Account
	     */
	    chargeCurrency = trxMgntCO.getCtstrsVO().getCH_AC_CY();
	    if(chargeCurrency == null)
	    {
		chargeCurrency = trxMgntCO.getCtstrsVO().getTRS_AC_CY();
	    }

	}

	return chargeCurrency;

    }

    /**
     * This function selects the trx type charges based loosely on
     * selectChargeSchema
     *
     * @param criteria
     * @return
     * @throws BaseException
     */
    public BigDecimal selectChargeSchema(TrxMgntCO trxMgntCO) throws BaseException
    {
	TrxMgntChargesSC trxMgntChargesSC = new TrxMgntChargesSC();
	trxMgntChargesSC.setCompCode(trxMgntCO.getLoginCompCode());
	trxMgntChargesSC.setBranchCode(trxMgntCO.getLoginBraCode());
	trxMgntChargesSC.setEntityCode(trxMgntCO.getCtstrsVO().getTRX_TYPE());
	trxMgntChargesSC.setProductName("TRX_TYPE");
	
	
	/*
	 * Retrieve Transaction Type
	 */
	if(trxMgntCO.getCtstrxtypeVO() == null)
	{
	   
	    CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO();
	    ctsTrxTypeVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	    ctsTrxTypeVO.setCODE(trxMgntCO.getCtstrsVO().getTRX_TYPE());

	    ctsTrxTypeVO = coreCommonBO.findTrxType(ctsTrxTypeVO);

	    trxMgntCO.setCtstrxtypeVO(ctsTrxTypeVO);
	}
	

	/*
	 * If called from Entity Charges then trxMgntCO.getChargeSchema() is filled
	 */
	if(trxMgntCO.getChargeSchema() != null && trxMgntCO.getChargeSchema().intValue() > 0)
	{
	    return trxMgntCO.getChargeSchema();
	}
	
	
	/*
	 * Set Deduct Account
	 */
	if(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND() == null)
	{
	    trxMgntCO.getCtstrsVO().setCASH_DEDUCT_IND("1");
	}
	
	if(TrxMgntConstant.DEDUCT_CASH.equals(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND())
		|| TrxMgntConstant.DEDUCT_FROM_ACCOUNT.equals(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND())
		|| TrxMgntConstant.DEDUCT_FROM_TELLER_ACC.equals(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND())
		|| (TrxMgntConstant.DEDUCT_FROM_CREDITOR.equals(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND()) && TrxMgntConstant.MAIN_ACC_CR.equals(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX()))
		|| (TrxMgntConstant.DEDUCT_FROM_DEBTOR.equals(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND()) && TrxMgntConstant.MAIN_ACC_DR.equals(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX())))
	{
	    trxMgntChargesSC.setTrsAcBr(trxMgntCO.getCtstrsVO().getTRS_AC_BR());
	    trxMgntChargesSC.setTrsAcCy(trxMgntCO.getCtstrsVO().getTRS_AC_CY());
	    trxMgntChargesSC.setTrsAcGl(trxMgntCO.getCtstrsVO().getTRS_AC_GL());
	    trxMgntChargesSC.setTrsAcCif(trxMgntCO.getCtstrsVO().getTRS_AC_CIF());
	    trxMgntChargesSC.setTrsAcSl(trxMgntCO.getCtstrsVO().getTRS_AC_SL());
	}
	else if (TrxMgntConstant.DEDUCT_FROM_CREDITOR.equals(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND()) && TrxMgntConstant.MAIN_ACC_DR.equals(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX())
		|| (TrxMgntConstant.DEDUCT_FROM_DEBTOR.equals(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND()) && TrxMgntConstant.MAIN_ACC_CR.equals(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX())))
	{
	    trxMgntChargesSC.setTrsAcBr(trxMgntCO.getCtstrsVO().getTO_TRS_AC_BR());
	    trxMgntChargesSC.setTrsAcCy(trxMgntCO.getCtstrsVO().getTO_TRS_AC_CY());
	    trxMgntChargesSC.setTrsAcGl(trxMgntCO.getCtstrsVO().getTO_TRS_AC_GL());
	    trxMgntChargesSC.setTrsAcCif(trxMgntCO.getCtstrsVO().getTO_TRS_AC_CIF());
	    trxMgntChargesSC.setTrsAcSl(trxMgntCO.getCtstrsVO().getTO_TRS_AC_SL());
	}
	else if (TrxMgntConstant.DEDUCT_FROM_OTHER_ACC.equals(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND()))
	{
	    trxMgntChargesSC.setTrsAcBr(trxMgntCO.getCtstrsVO().getCH_AC_BR());
	    trxMgntChargesSC.setTrsAcCy(trxMgntCO.getCtstrsVO().getCH_AC_CY());
	    trxMgntChargesSC.setTrsAcGl(trxMgntCO.getCtstrsVO().getCH_AC_GL());
	    trxMgntChargesSC.setTrsAcCif(trxMgntCO.getCtstrsVO().getCH_AC_CIF());
	    trxMgntChargesSC.setTrsAcSl(trxMgntCO.getCtstrsVO().getCH_AC_SL());
	}

	
	/*
	 * Fetch CIF Type
	 */
	CIFVO cifVO = new CIFVO();
	cifVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	if(NumberUtil.emptyDecimalToNull(trxMgntChargesSC.getTrsAcCif()) == null )
	{
	    return BigDecimal.ZERO;
	}
	else if (!trxMgntChargesSC.getTrsAcCif().equals(BigDecimal.ZERO))
	{
	    /*
	     * In Case of CIF 0 (Internal)
	     */
	    cifVO.setCIF_NO(trxMgntChargesSC.getTrsAcCif());
	    cifVO = (CIFVO) genericDAO.selectByPK(cifVO);

	    if(cifVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
	    }

	    trxMgntChargesSC.setEntityTypeCode(cifVO.getCIF_TYPE());
	    trxMgntChargesSC.setCifType(cifVO.getCIF_TYPE());
	}

	if (trxMgntChargesSC.getCifType() == null)
	{
	    trxMgntChargesSC.setEntityTypeCode(BigDecimal.ZERO);
	}


	/*
	 * Set Charges Policy
	 */
	String policy = coreCommonServiceBO.getChargesCyPolicy(trxMgntCO);

	//trxMgntChargesSC.setChargesPolicy(policy);
	trxMgntChargesSC.setChqIssueType(policy);

	
	
	/*
	 * Set Cash/Account
	 */
	if(trxMgntCO.getCtstrxtypeVO().getTYPE().equals(TrxMgntConstant.TRANSFER))
	{
	    trxMgntChargesSC.setCashAccount(trxMgntCO.getCtstrsVO().getTRSFR_METHOD());
	}
	else
	{
	    trxMgntChargesSC.setCashAccount("A");

	}
	

	/*
	 * Set Charge Type
	 */
	if(TrxMgntConstant.CRUD_TO_CANCEL.equals(trxMgntCO.getCrud()))
	{
	    trxMgntChargesSC.setActionType("N");
	}
	else
	{
	    trxMgntChargesSC.setActionType("P");
	}
	
	trxMgntChargesSC.setUserId(trxMgntCO.getLoginUserId());
	trxMgntChargesSC.setRequestDate(trxMgntCO.getRunningDateRET());
	    
	/*
	 * Get Schema
	 */
	trxMgntChargesSC = coreCommonProcedureBO.returnProductCharges(trxMgntChargesSC);

	/*
	 * Check for missing charges
	 */
	if(trxMgntChargesSC != null && NumberUtil.nullToZero(trxMgntChargesSC.getSchema()).compareTo(BigDecimal.ZERO) > 0)
	{
	    return trxMgntChargesSC.getSchema();
	}
	else
	{
	    if(trxMgntChargesSC != null &&  NumberUtil.nullToZero(trxMgntChargesSC.getError()).compareTo(BigDecimal.ZERO) < 0)
	    {
		throw new BOException(trxMgntChargesSC.getErrorMessage());
	    }
	    
	    return BigDecimal.ZERO;
	}
    }

    /**
     * Selects the CIF to be Charged according to the Charge Deduct Criteria
     *
     * @param TrxMgntCO
     * @return BigDecimal
     * @throws BaseException
     */
    public BigDecimal returnCIFNumber(TrxMgntCO trxMgntCO) throws BaseException
    {
	BigDecimal cifNumber = trxMgntCO.getCtstrsVO().getTRS_AC_CIF();
	String deduct;
	BigDecimal glCode = trxMgntCO.getCtstrsVO().getTRS_AC_GL();

	deduct = trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND();

	if(TrxMgntConstant.DEDUCT_CASH.equals(deduct) || TrxMgntConstant.DEDUCT_FROM_TELLER_ACC.equals(deduct)
		|| TrxMgntConstant.DEDUCT_FROM_ACCOUNT.equals(deduct))
	{
	    /*
	     * Use Main Account
	     */
	    cifNumber = trxMgntCO.getCtstrsVO().getTRS_AC_CIF();

	}
	else if(TrxMgntConstant.DEDUCT_FROM_CREDITOR.equals(deduct))
	{
	    /*
	     * If Main Account is credit then use Main Account else Transaction
	     * Currency
	     */
	    if(TrxMgntConstant.MAIN_ACC_CR.equals(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX()))
	    {
		cifNumber = trxMgntCO.getCtstrsVO().getTRS_AC_CIF();
	    }
	    else
	    {
		cifNumber = trxMgntCO.getCtstrsVO().getTO_TRS_AC_CIF();
		glCode = trxMgntCO.getCtstrsVO().getTO_TRS_AC_GL();
	    }
	}
	else if(TrxMgntConstant.DEDUCT_FROM_DEBTOR.equals(deduct))
	{
	    /*
	     * If Main Account is Credit then Transaction Currency else Main
	     * Account
	     */
	    if(TrxMgntConstant.MAIN_ACC_CR.equals(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX()))
	    {
		cifNumber = trxMgntCO.getCtstrsVO().getTO_TRS_AC_CIF();
		glCode = trxMgntCO.getCtstrsVO().getTO_TRS_AC_GL();
	    }
	    else
	    {
		cifNumber = trxMgntCO.getCtstrsVO().getTRS_AC_CIF();
	    }

	}
	else if(TrxMgntConstant.DEDUCT_FROM_OTHER_ACC.equals(deduct))
	{
	    /*
	     * User Charge Account else if null use Main Account
	     */
	    cifNumber = trxMgntCO.getCtstrsVO().getCH_AC_CIF();
	    glCode = trxMgntCO.getCtstrsVO().getCH_AC_GL();
	    if(cifNumber == null)
	    {
		cifNumber = trxMgntCO.getCtstrsVO().getTRS_AC_CIF();
		glCode = trxMgntCO.getCtstrsVO().getTRS_AC_GL();
	    }

	}

	/*
	 * Check if Internal GL then return CIF 0 so as not to check on CIF Type
	 */
	if(cifNumber != null && !cifNumber.equals(BigDecimal.ZERO)
		&& glCode != null 
		&& checkInternalGL(trxMgntCO.getLoginCompCode(),glCode).equals(BigDecimal.valueOf(-1)))
	{
	    return BigDecimal.ZERO;
	}


	return cifNumber;
    }

    /**
     * Validates GL Code and Checks if it is Internal
     *
     * @param 	compCode
     * 		glCode
     * @return 	BigDecimal
     * 		-1 if Internal, 1 if non-internal
     * @throws BaseException
     */
    public BigDecimal checkInternalGL(BigDecimal compCode, BigDecimal glCode) throws BaseException
    {
	GLSC glSC = new GLSC();
	glSC.setCompCode(compCode);
	glSC.setGlCode(glCode);

	GEN_LEDGERVO genledgerVO = coreCommonBO.returnValidGeneralLedger(glSC);


	if(genledgerVO == null || genledgerVO.getGL_TYPE().equals(ConstantsCommon.INTERNAL_GEN_LEDGER_TYPE))
	{
	    return new BigDecimal(-1);
	}
	else
	{
	    return BigDecimal.ONE;
	}
    }

    /**
     * Get codes of charges schemas that have line number > 0
     * from entityChargesBO.getChargesSchema()
     *
     * @param trxChargesCO
     * @return List<BigDecimal>
     * @throws BaseException
     */
    public List<BigDecimal> retrieveChargesSchemaLine(TrxMgntChargesSC trxMgntChargesSC) throws BaseException
    {
	EntityChargesCO entityChargesCO = new EntityChargesCO();

	entityChargesCO.setLoginCompCode(trxMgntChargesSC.getCompCode());
	entityChargesCO.setSchema(trxMgntChargesSC.getChargeCode());

	return entityChargesBO.selectChargesSchemaList(entityChargesCO);
    }


    public BigDecimal returnChargeSchema(TrxMgntChargesSC trxMgntChargesSC) throws BaseException
    {
	return coreCommonChargesDAO.returnChargeSchema(trxMgntChargesSC);

    }

    /**
     * Retrieves Charges that have PASS_SEPERATELY as checked and have a Debit Criteria
     *
     * @param trxMgntCO
     * @return trxMgntCO
     *
     * @throws BaseException
     */
    public List<BigDecimal> retrieveSeparateChargesSchema(TrxMgntChargesSC trxMgntChargesSC) throws BaseException
    {
	return coreCommonChargesDAO.retrieveSeparateChargesSchema(trxMgntChargesSC);
    }


    /**
     * Sets the Currencies Decimal Points
     *
     * Sets them in
     * trxMgntCO.cyDecimalPoints
     * trxMgntCO.baseCyDecimalPoints
     *
     *
     * @param trxMgntCO
     * @return trxMgntCO
     *
     * @throws BaseException
     */
    public TrxMgntCO returnCurrenciesDecimalPoints(TrxMgntCO trxMgntCO) throws BaseException
    {

	/*
	 * Get Base Currency and Currency Decimal Points
	 */
	CURRENCIESVO baseCurrenciesVO = new CURRENCIESVO();
	baseCurrenciesVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	baseCurrenciesVO.setCURRENCY_CODE(trxMgntCO.getBaseCurrencyCode());

	baseCurrenciesVO = currencyBO.returnCurrency(baseCurrenciesVO);

	trxMgntCO.setBaseCyDecimalPoints(baseCurrenciesVO.getDECIMAL_POINTS());

	CURRENCIESVO currenciesVO = new CURRENCIESVO();
	if(null != trxMgntCO.getTrxChargesCO().getCurrency() && null != trxMgntCO.getTrxChargesCO().getBaseCurrencyCode()
		&& trxMgntCO.getTrxChargesCO().getCurrency().compareTo(trxMgntCO.getTrxChargesCO().getBaseCurrencyCode()) == 0)
	{
	    currenciesVO = baseCurrenciesVO;
	}
	else
	{
	    currenciesVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	    currenciesVO.setCURRENCY_CODE(trxMgntCO.getTrxChargesCO().getCurrency());

	    currenciesVO = currencyBO.returnCurrency(currenciesVO);

	}

	trxMgntCO.setCyDecimalPoints(currenciesVO.getDECIMAL_POINTS());

	return trxMgntCO;
    }

    /**
     * Get the charge details by calling entityChargesBO.getChargesDetails() which runs
     * procedure P_RET_GET_CHARGES_DETAILS
     *
     * @param trxMgntChargesSC
     * @return TrxMgntChargesSC
     * @throws BaseException
     */
    public TrxMgntChargesSC retrieveChargesDetails(TrxMgntChargesSC trxMgntChargesSC) throws BaseException
    {
	return entityChargesBO.retrieveChargesDetails(trxMgntChargesSC);

    }

    /**
     * Sets VAT details for the charge
     *
     * @param trxMgntCO
     * @return trxMgntCO
     * @throws BaseException
     */
    public TrxMgntCO retrieveVatChargesDetails(TrxMgntCO trxMgntCO) throws BaseException
    {

	int row = trxMgntCO.getTrxChargesCO().getRow().intValue();

	/*
	 * Get VAT Charges Details Amounts
	 */
	if(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getAPPLY_TVA() != null
		&& trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getAPPLY_TVA().equals("1")
		&& trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getVAT_CODE() != null
		&& trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getVAT_CODE().intValue() > 0)
	{
	    TrxMgntSC trxMgntSC = new TrxMgntSC();
	    trxMgntSC.setCompCode(trxMgntCO.getLoginCompCode());
	    trxMgntSC.setBranchCode(trxMgntCO.getLoginBraCode());
	    trxMgntSC.setTrsNo(BigDecimal.ZERO);
	    trxMgntSC.setTrsAcBr(trxMgntCO.getTrxChargesCO().getBranch());
	    trxMgntSC.setTrsAcCy(trxMgntCO.getTrxChargesCO().getCurrency());

	    /*
	     * Set Initial Values
	     */
	    if(trxMgntCO.getCtstrsVO().getEXCHANGE_RATE() == null)
	    {
		trxMgntSC.setExchRate(BigDecimal.ONE);
	    }
	    else
	    {
		trxMgntSC.setExchRate(trxMgntCO.getCtstrsVO().getEXCHANGE_RATE());
	    }

	    /*
	     * Set Deduct Currency according to Charges Booking
	     */
	    if(trxMgntCO.getPthCtrlVO() == null || trxMgntCO.getPthCtrlVO().getCHARGES_BOOKING() == null)
	    {
		trxMgntCO.setPthCtrlVO(commonLibBO.returnPthCtrl());
	    }

	    //	    String chargeBooking = trxMgntCO.getPthCtrlVO().getCHARGES_BOOKING();
	    //
	    //	    if(chargeBooking.equals(TrxMgntConstant.CHARGES_BOOKING_A))
	    //	    {
	    trxMgntSC.setCurrency(trxMgntCO.getTrxChargesCO().getCurrency());
	    //	    }
	    //	    else
	    //	    {
	    //		trxMgntSC.setCurrency(trxMgntCO.getBaseCurrencyCode());
	    //	    }

	    if(trxMgntCO.getCtstrxtypeVO().getCODE() == null)
	    {
		trxMgntSC.setTrxType(BigDecimal.ZERO);
	    }
	    else
	    {
		trxMgntSC.setTrxType(trxMgntCO.getCtstrxtypeVO().getCODE());
	    }

	    trxMgntSC.setSystemDate(trxMgntCO.getRunningDateRET());
	    trxMgntSC.setType("C");
	    trxMgntSC.setCode(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getVAT_CODE());
	    trxMgntSC.setTotalCVcharge(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getAMOUNT_NEW());
	    trxMgntSC.setTotalFCcharge(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getAMOUNT_FC_NEW());
	    trxMgntSC.setDeductBr(trxMgntCO.getDeductBr());
	    trxMgntSC.setChargeCode(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getCODE());
	    trxMgntSC.setChAcBr(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getDEDUCT_FROM_ACC_BR());
	    trxMgntSC.setChAcCy(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getDEDUCT_FROM_ACC_CY());
	    trxMgntSC.setChAcGl(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getDEDUCT_FROM_ACC_GL());
	    trxMgntSC.setChAcCif(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getDEDUCT_FROM_ACC_CIF());
	    trxMgntSC.setChAcSl(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getDEDUCT_FROM_ACC_SL());

	    trxMgntSC = retrieveVATDetails(trxMgntSC);

	    /*
	     * Set the VAT Charges Details
	     */
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setAMOUNT(trxMgntSC.getVatCVAmount());
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setAMOUNT_NEW(trxMgntSC.getVatCVAmount());
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setAMOUNT_FC_NEW(trxMgntSC.getVatFCAmount());
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setCHARGE_PERC(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getCHARGE_PERC());

	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setACC_BR(trxMgntCO.getOriginBraCode());
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setACC_CY(trxMgntCO.getTrxChargesCO().getCurrency());

	    /*
	     * Fetch VAT Charges Info
	     */
	    if(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getVAT_CODE() == null)
	    {
		trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setACC_GL(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getACC_GL());
		trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setACC_CIF(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getACC_CIF());
		trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setACC_SL(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getACC_SL());

	    }
	    else
	    {
		/*ACC_VATVO accVATVO = new ACC_VATVO();
		accVATVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());

		accVATVO.setVAT_CODE(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getVAT_CODE());
		accVATVO = (ACC_VATVO) genericDAO.selectByPK(accVATVO);

		if(accVATVO != null)
		{
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setACC_GL(accVATVO.getCR_GL());
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setACC_CIF(accVATVO.getCR_CIF());
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setACC_SL(accVATVO.getCR_SL());
		}*/
			//added by Maria for BMO180067
			AccountCO accountCO = new AccountCO();
			accountCO.getAmfVO().setCOMP_CODE(trxMgntCO.getLoginCompCode());
			accountCO.getAmfVO().setBRANCH_CODE(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getDEDUCT_FROM_ACC_BR());
			accountCO.getAmfVO().setCURRENCY_CODE(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getDEDUCT_FROM_ACC_CY());
			accountCO.getAmfVO().setGL_CODE(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getDEDUCT_FROM_ACC_GL());
			accountCO.getAmfVO().setCIF_SUB_NO(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtstrsCHARGESDETVO().getDEDUCT_FROM_ACC_CIF());				
			accountCO.setLoginUserId(trxMgntCO.getLoginUserId());
			accountCO.setRunningDate(trxMgntCO.getRunningDate());				
			accountCO.setTaxVatCode(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getVAT_CODE());
			accountCO = coreCommonProcedureBO.wrapCoreGetVatDetails(accountCO);
			if(accountCO != null)
			{
			    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setACC_GL(accountCO.getAmfSC().getGL_CODE());
			    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setACC_CIF(accountCO.getAmfSC().getCIF_SUB_NO());
			    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setACC_SL(accountCO.getAmfSC().getSL_NO());			    
			}
			//end Maria 		    	
	    }


	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setPASS_SEPARATELY(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getPASS_SEPARATELY());
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setAPPLY_TVA(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getAPPLY_TVA());
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setVAT_CODE(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getVAT_CODE());
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setDR_CRITERIA(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getDR_CRITERIA());
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setDR_ACC_GL(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getDR_ACC_GL());
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setDR_ACC_CIF(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getDR_ACC_CIF());
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getTvaChargesDetVO().setDR_ACC_SL(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(row).getCtsChargesVO().getACC_SL());

	}

	return trxMgntCO;
    }



    /**
     * Get the VAT charge details by calling entityChargesBO.retrieveVATDetails() which runs
     * procedure P_RET_GET_TVA_DETAILS
     *
     * @param trxMgntChargesSC
     * @return TrxMgntChargesSC
     * @throws BaseException
     */
    public TrxMgntSC retrieveVATDetails(TrxMgntSC trxMgntSC) throws BaseException
    {
	return entityChargesBO.retrieveVATDetails(trxMgntSC);
    }

    /**
     * Sets the Currencies Decimal Points Format on Amounts fields of both normal and VAT charges
     *
     * @param trxMgntCO
     * @return trxMgntCO
     *
     * @throws BaseException
     */
    public TrxMgntCO returnFormatAmounts(TrxMgntCO trxMgntCO) throws BaseException
    {
	/*
	 * Format Amount Values
	 */
	/* todo Commented to see if formatting can be done on jsp
	for(int i = 0; i < trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().size(); i++)
	{
	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().setAMOUNT(
		    new BigDecimal(CommonMethods.formatCurrency(NumberUtil.emptyDecimalToZero(trxMgntCO
			    .getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getAMOUNT()),
			    trxMgntCO.getBaseCyDecimalPoints())));

	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().setAMOUNT_NEW(
		    new BigDecimal(CommonMethods.formatCurrency(NumberUtil.emptyDecimalToZero(trxMgntCO
			    .getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getAMOUNT_NEW()),
			    trxMgntCO.getBaseCyDecimalPoints())));

	    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().setAMOUNT_FC_NEW(
		    new BigDecimal(CommonMethods.formatCurrency(NumberUtil
			    .emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i)
				    .getCtstrsCHARGESDETVO().getAMOUNT_FC_NEW()), trxMgntCO.getCyDecimalPoints())));
	 */

	/*
	 * Format VAT Amounts
	 */
	/* todo Commented to see if formatting can be done on jsp
	    if(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO() != null)
	    {
		trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO().setAMOUNT(
			new BigDecimal(CommonMethods.formatCurrency(NumberUtil.emptyDecimalToZero(trxMgntCO
				.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO().getAMOUNT()),
				trxMgntCO.getBaseCyDecimalPoints())));

		trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO().setAMOUNT_NEW(
			new BigDecimal(CommonMethods.formatCurrency(NumberUtil.emptyDecimalToZero(trxMgntCO
				.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO()
				.getAMOUNT_NEW()), trxMgntCO.getBaseCyDecimalPoints())));

		trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO().setAMOUNT_FC_NEW(
			new BigDecimal(CommonMethods.formatCurrency(NumberUtil.emptyDecimalToZero(trxMgntCO
				.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO()
				.getAMOUNT_FC_NEW()), trxMgntCO.getCyDecimalPoints())));

	    }
	}
	 */

	if((trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs() != null &&
		trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().size() > 0) ||
		(trxMgntCO.getTrxSOChargesCO().getTrxMgntSOChargesCOs() != null &&
			trxMgntCO.getTrxSOChargesCO().getTrxMgntSOChargesCOs().size() > 0))
	{
	    /*
	     * If Trx Type not set, then set it
	     */
	    if(trxMgntCO.getCtstrxtypeVO() == null ||
		    trxMgntCO.getCtstrxtypeVO().getDEFAULT_DR_ACC_TELLER() == null ||
		    trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX() == null)
	    {
		CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO();
		ctsTrxTypeVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
		ctsTrxTypeVO.setCODE(trxMgntCO.getTrxType());
		ctsTrxTypeVO = (CTSTRXTYPEVO) genericDAO.selectByPK(ctsTrxTypeVO);

		trxMgntCO.setCtstrxtypeVO(ctsTrxTypeVO);
	    }


	    /*
	     * Get the FC currency info
	     */
	    BigDecimal fcCurrency, fcDecimalPoints;

	    fcCurrency = selectChargeCy(trxMgntCO);

	    /*
	     * If base then use Base Decimals, else retrieve FC Currency Decimal
	     * Points
	     */
	    if(fcCurrency.equals(trxMgntCO.getBaseCurrencyCode()))
	    {
		fcDecimalPoints = trxMgntCO.getBaseCyDecimalPoints();
	    }
	    else
	    {
		CURRENCIESVO currenciesVO = new CURRENCIESVO();
		currenciesVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
		currenciesVO.setCURRENCY_CODE(fcCurrency);
		currenciesVO = currencyBO.getCurrencyDetails(currenciesVO);

		fcDecimalPoints = currenciesVO.getDECIMAL_POINTS();
	    }

	    /*
	     * Format the Amounts
	     */

	    /*
	     * Charges
	     */
	    if(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs() != null &&
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().size() > 0)
	    {
		for(int i = 0; i < trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().size(); i++)
		{
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).setAMOUNT_FORMAT(trxMgntCO.getBaseCyDecimalPoints());
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).setAMOUNT_NEW_FORMAT(trxMgntCO.getBaseCyDecimalPoints());
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).setTva_amount_FORMAT(trxMgntCO.getBaseCyDecimalPoints());
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).setTva_amount_new_FORMAT(trxMgntCO.getBaseCyDecimalPoints());

		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).setAMOUNT_FC_NEW_FORMAT(fcDecimalPoints);
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).setTva_amount_fc_new_FORMAT(fcDecimalPoints);
		}

	    }

	    /*
	     * SO Charges
	     */
	    if(trxMgntCO.getTrxSOChargesCO().getTrxMgntSOChargesCOs() != null &&
		    trxMgntCO.getTrxSOChargesCO().getTrxMgntSOChargesCOs().size() > 0)
	    {
		for(int i = 0; i < trxMgntCO.getTrxSOChargesCO().getTrxMgntSOChargesCOs().size(); i++)
		{
		    trxMgntCO.getTrxSOChargesCO().getTrxMgntSOChargesCOs().get(i).setAMOUNT_FORMAT(trxMgntCO.getBaseCyDecimalPoints());
		    trxMgntCO.getTrxSOChargesCO().getTrxMgntSOChargesCOs().get(i).setAMOUNT_NEW_FORMAT(trxMgntCO.getBaseCyDecimalPoints());
		    trxMgntCO.getTrxSOChargesCO().getTrxMgntSOChargesCOs().get(i).setTva_amount_FORMAT(trxMgntCO.getBaseCyDecimalPoints());
		    trxMgntCO.getTrxSOChargesCO().getTrxMgntSOChargesCOs().get(i).setTva_amount_new_FORMAT(trxMgntCO.getBaseCyDecimalPoints());

		    trxMgntCO.getTrxSOChargesCO().getTrxMgntSOChargesCOs().get(i).setAMOUNT_FC_NEW_FORMAT(fcDecimalPoints);
		    trxMgntCO.getTrxSOChargesCO().getTrxMgntSOChargesCOs().get(i).setTva_amount_fc_new_FORMAT(fcDecimalPoints);
		}
	    }
	}





	return trxMgntCO;
    }


    /**
     * Calculates the Total Charges and sets their format
     *
     * Sets them in
     * trxMgntCO.getTrxChargesCO().setTotalNew()
     * trxMgntCO.getTrxChargesCO().setTotalFc()
     *
     *
     * @param TrxMgntCO
     * @return TrxMgntCO
     *
     * @throws BaseException
     */
    public TrxMgntCO retrieveTotalCharges(TrxMgntCO trxMgntCO) throws BaseException
    {
	BigDecimal totalNew = BigDecimal.ZERO;
	BigDecimal totalFc = BigDecimal.ZERO;


	if(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs() != null)
	{
	    for(int i = 0; i < trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().size(); i++)
	    {
		/*
		 * In case pass_seperately is different than 1 (not checked) and
		 * Debit Criteria is empty or 1 (Not Applicable) then count charge
		 */
		if((trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtsChargesVO().getPASS_SEPARATELY() == null
			|| !trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtsChargesVO().getPASS_SEPARATELY().equals("1"))
			|| ((trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtsChargesVO().getDR_CRITERIA() == null)
				|| (trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtsChargesVO().getDR_CRITERIA().equals(""))
				|| (trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtsChargesVO().getDR_CRITERIA().equals("1"))))
		{
		    /*
		     * Add Normal Charge Amounts to Total
		     */
		    totalNew = totalNew.add(NumberUtil.emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getAMOUNT_NEW()));
		    totalFc = totalFc.add(NumberUtil.emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getAMOUNT_FC_NEW()));

		    /*
		     * Add VAT amounts to Total
		     */

		    if(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO() != null)
		    {
			totalNew = totalNew.add(NumberUtil.emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO().getAMOUNT_NEW()));
			totalFc = totalFc.add(NumberUtil.emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO().getAMOUNT_FC_NEW()));
		    }
		}
	    }
	}


	trxMgntCO.getTrxChargesCO().setTotalNew(totalNew);
	trxMgntCO.getTrxChargesCO().setTotalFc(totalFc);


	trxMgntCO.getCtstrsVO().setCHARGE(totalNew);
	trxMgntCO.getCtstrsVO().setFC_CHARGES(totalFc);

	/*
	 * Format all Total values
	 */
	/* todo Commented to see if formatting can be done on jsp
	trxMgntCO.getTrxChargesCO().setTotal(new BigDecimal(CommonMethods.formatCurrency(NumberUtil
		.emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTotal()),trxMgntCO.getBaseCyDecimalPoints())));
	trxMgntCO.getTrxChargesCO().setTotalNew(new BigDecimal(CommonMethods.formatCurrency(NumberUtil
		.emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTotalNew()),trxMgntCO.getBaseCyDecimalPoints())));
	trxMgntCO.getTrxChargesCO().setTotalFc(new BigDecimal(CommonMethods.formatCurrency(NumberUtil
		.emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTotalFc()),trxMgntCO.getCyDecimalPoints())));
	 */



	return trxMgntCO;

    }

    public void setCoreCommonChargesDAO(CoreCommonChargesDAO coreCommonChargesDAO)
    {
	this.coreCommonChargesDAO = coreCommonChargesDAO;
    }

    public void setCurrencyBO(CurrencyBO currencyBO)
    {
	this.currencyBO = currencyBO;
    }
    
    //Hasan Ghrayeb BPM modification - copy properties from ctstrs_charges_detVO into cts_charges_unifiedVO
    public CTS_CHARGES_UNIFIEDVO copyChargesfromDETVOToVO(CTSTRS_CHARGES_DETVO ctstrsChargesDetVO,CTS_CHARGES_UNIFIEDVO CtsChargesUnified) throws BaseException
    {
	if(ctstrsChargesDetVO != null && CtsChargesUnified != null)
	{
	    PathPropertyUtil.copyProperties(ctstrsChargesDetVO,CtsChargesUnified,
	    "CHARGE_CODE"				,
	    "AMOUNT"					,
	    "AMOUNT_NEW"				,
	    "AMOUNT_FC_NEW"				,
	    "ACC_CY CREDIT_ACC_CY"			,
	    "DEDUCT_FROM_ACC_BR DEBIT_ACC_BR"		,
	    "DEDUCT_FROM_ACC_CY DEBIT_ACC_CY"		,
	    "DEDUCT_FROM_ACC_CIF DEBIT_ACC_CIF"		,
	    "DEDUCT_FROM_ACC_GL DEBIT_ACC_GL"		,
	    "DEDUCT_FROM_ACC_SL DEBIT_ACC_SL"		,
	    "USER_ID");

	}
	return CtsChargesUnified;
    }
    
    
    //Hasan Ghrayeb BPM Modifizcation
    
    public TrxMgntCO CalculateNewGainLossCharge(TrxMgntCO argTrxMgntCO) throws BaseException {
	
	    BigDecimal DEDUCT_FROM_ACC_BR = null;
	    BigDecimal DEDUCT_FROM_ACC_CY = null;
	    BigDecimal DEDUCT_FROM_ACC_CIF =null;
	    BigDecimal DEDUCT_FROM_ACC_GL = null;
	    BigDecimal DEDUCT_FROM_ACC_SL = null;
	    BigDecimal CHARGE_PERC = null;
	    
	    int count = 0;
	
	
	TrxMgntCO trxmgntCO = argTrxMgntCO;
	
	if(argTrxMgntCO == null)
	    // add exception
	    return trxmgntCO;
	
	
	    	/*
		 * Get Session (For Oracle append session to Database Node)
		 */
	    	trxmgntCO.setSessionID(calculateSessionID());
	    	
	    	/*
		 * Empty all Charges before commencing
		 */
		emptyCharges(trxmgntCO.getLoginCompCode(),trxmgntCO.getLoginBraCode(),trxmgntCO.getSessionID(), null, null);
		
		/*
		 * Fill First line to be inserted into CTS_CHARGES_UNIFIED Line 0
		 */
		CTS_CHARGES_UNIFIEDVO ctsChargesUnifiedVO1 = fillFirstChargeLine(trxmgntCO);

		/*
		 * Insert Line 0 arguments
		 */
		ctsChargesUnifiedVO1.setDB_SESSION_ID(trxmgntCO.getSessionID());
		
		if(commonLibBO.returnIsSybase() == 1)
		{
			coreCommonChargesDAO.insertHashCtsChargesUnified(ctsChargesUnifiedVO1);
		}
		else
		{
			genericDAO.insert(ctsChargesUnifiedVO1);
		}
		
		//loop through CO's
		
		
	while ( count < trxmgntCO.getTrxChargesCO().getTrxMgntChargesCOs().size())
	{
		//loop through charges in CO except the gain/loss charge
		List<CTSTRS_CHARGES_DETVO> chargeslist = new ArrayList<CTSTRS_CHARGES_DETVO>();
		if(trxmgntCO.getTrxChargesCO() !=null  && trxmgntCO.getTrxChargesCO().getTrxMgntChargesCOs().size() > 0 ) {
		    CTSTRS_CHARGES_DETVO CTSTRS_CHARGES_DETVO = trxmgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(count).getCtstrsCHARGESDETVO();
		    chargeslist.add(CTSTRS_CHARGES_DETVO);
		    //Save DEDUCT_FROM_ACOUNT to be used with VAT ctstrschargesdet 
		     DEDUCT_FROM_ACC_BR = CTSTRS_CHARGES_DETVO.getDEDUCT_FROM_ACC_BR();
		     DEDUCT_FROM_ACC_CY = CTSTRS_CHARGES_DETVO.getDEDUCT_FROM_ACC_CY();
		     DEDUCT_FROM_ACC_CIF = CTSTRS_CHARGES_DETVO.getDEDUCT_FROM_ACC_CIF();
		     DEDUCT_FROM_ACC_GL = CTSTRS_CHARGES_DETVO.getDEDUCT_FROM_ACC_GL();
		     DEDUCT_FROM_ACC_SL = CTSTRS_CHARGES_DETVO.getDEDUCT_FROM_ACC_SL();
		     CHARGE_PERC = CTSTRS_CHARGES_DETVO.getCHARGE_PERC();
		    if(trxmgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(0).getTvaChargesDetVO() !=null)
			chargeslist.add(trxmgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(0).getTvaChargesDetVO());
			
		
		
		
		//loop through charges in CO except the gain/loss charge
		for(int i =0;i<chargeslist.size();i++) {
		    
		    CTSTRS_CHARGES_DETVO ctstrsChargesDetVO = chargeslist.get(i);
		    ctstrsChargesDetVO.setACC_CY(trxmgntCO.getCtstrsVO().getTRS_AC_CY());
		    CTS_CHARGES_UNIFIEDVO ctsChargesUnifiedVO = new CTS_CHARGES_UNIFIEDVO();
		    //copy charges from ctstrs_charges_detVO into cts_charges_unifiedVO
		    ctsChargesUnifiedVO = copyChargesfromDETVOToVO(ctstrsChargesDetVO, ctsChargesUnifiedVO);
		    if(ctsChargesUnifiedVO != null) {
			//increment line number
			ctsChargesUnifiedVO.setLINE_NO(new BigDecimal(i+1));
			ctsChargesUnifiedVO.setDB_SESSION_ID(trxmgntCO.getSessionID());
			ctsChargesUnifiedVO.setUSER_ID(trxmgntCO.getLoginUserId());
			ctsChargesUnifiedVO.setBATCH_NO(BigDecimal.ZERO);
			ctsChargesUnifiedVO.setSERIAL_NO(BigDecimal.ZERO);
			ctsChargesUnifiedVO.setBRANCH_CODE(trxmgntCO.getLoginBraCode());
			ctsChargesUnifiedVO.setCOMP_CODE(trxmgntCO.getLoginCompCode());
			ctsChargesUnifiedVO.setCHARGE_PERC(CHARGE_PERC);
			ctsChargesUnifiedVO.setPRODUCT_NAME(calculateProductType(trxmgntCO));
			if(ctsChargesUnifiedVO.getDEBIT_ACC_BR() == null 
				|| ctsChargesUnifiedVO.getDEBIT_ACC_CY() == null 
				|| ctsChargesUnifiedVO.getDEBIT_ACC_CIF() == null
				|| ctsChargesUnifiedVO.getDEBIT_ACC_GL() == null
				|| ctsChargesUnifiedVO.getDEBIT_ACC_SL() == null)
			    
			{
			    ctsChargesUnifiedVO.setDEBIT_ACC_BR(DEDUCT_FROM_ACC_BR);
			    ctsChargesUnifiedVO.setDEBIT_ACC_CY(DEDUCT_FROM_ACC_CY);
			    ctsChargesUnifiedVO.setDEBIT_ACC_CIF(DEDUCT_FROM_ACC_CIF);
			    ctsChargesUnifiedVO.setDEBIT_ACC_GL(DEDUCT_FROM_ACC_GL);
			    ctsChargesUnifiedVO.setDEBIT_ACC_SL(DEDUCT_FROM_ACC_SL);
			    ctsChargesUnifiedVO.setCHARGE_CODE(CTSTRS_CHARGES_DETVO.getCHARGE_CODE().multiply(new BigDecimal(-1)));
			    
			}
			
			//insert VO into CTS_charges_unified
			if(commonLibBO.returnIsSybase() == 1)
			{
				coreCommonChargesDAO.insertHashCtsChargesUnified(ctsChargesUnifiedVO);
			}
			else
			{
				genericDAO.insert(ctsChargesUnifiedVO);
			}
		    }
		    else
		    {
			//add exception
		    }
		
		    
		    
		}//end for
		
		
		}//end if
		
	count ++;
		
	}//end while
		    //Call the P_RET_CHARGES_GAINLOSS_DENOM TO GET THE CHARGE_CODE=0 (GAIN/LOSS RECORD)
		    TrxMgntSC trxmgntSC = new TrxMgntSC();
		    trxmgntSC.setSessionID(trxmgntCO.getSessionID());
		    trxmgntSC.setUserId(trxmgntCO.getLoginUserId());
		    trxmgntSC.setCompCode(trxmgntCO.getLoginCompCode());
		    trxmgntSC.setBranchCode(trxmgntCO.getLoginBraCode());
		    /*
		     * Set Entity Type, else use default value TRX
		     */
		    
		    coreCommonProcedureBO.InsertNewGainlossRecord(trxmgntSC);
		    
		    
		    //fetch all records from cts_charges_unified and take the new gain/loss record
		    trxmgntCO = retrieveTempChargeData(trxmgntCO);
		    
		    //empty when finish the cts_charges_unified
		    emptyCharges(trxmgntCO.getLoginCompCode(),trxmgntCO.getLoginBraCode(),trxmgntCO.getSessionID(), null, null);
		    
		    return trxmgntCO;

	
	
	
	
	
    }
    
    

    /**
     * This function will prepare the unified charges data for calling the
     * Procedure that calculates them; it then calls the procedure and returns
     * the copied data.
     *
     * @author Reda Charabaty
     * @param  TrxMgntCO
     * 		trxMgntCO.getLanguage()
     * 		trxMgntCO.getLoginUserId()
     * 		trxMgntCO.getIsSybase()
     * 		trxMgntCO.getLoginCompCode()
     * 		trxMgntCO.getLoginBraCode()
     * 		trxMgntCO.getLoginTellerCode()
     * 
     * 		trxMgntCO.getCtstrsVO().getTRX_TYPE()		Transaction or Entity Type
     * 		trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND()	Deduct method of Charges
     * 		trxMgntCO.getCrud()				Crud of screen
     * 		trxMgntCO.getCtstrsVO().getTRS_CY()		Transaction Currency
     * 		trxMgntCO.getRunningDateRET()			Running Date
     * 		trxMgntCO.getCtstrsVO().getAMOUNT()		Amount in Transaction Currency
     * 		trxMgntCO.getCtstrsVO().getCV_AMOUNT()		Amount in Base Currency
     * 		trxMgntCO.getCtstrsVO().getEXCHANGE_RATE()	Exchange Rate
     * 		trxMgntCO.getCtstrsVO().getTRSFR_METHOD()	Transfer Method (Cash/Account/Cheque)
     * 		trxMgntCO.getCtstrsVO().getTRS_AC_BR()		From Account
     * 		trxMgntCO.getCtstrsVO().getTRS_AC_CY()
     * 		trxMgntCO.getCtstrsVO().getTRS_AC_GL()
     * 		trxMgntCO.getCtstrsVO().getTRS_AC_CIF()
     * 		trxMgntCO.getCtstrsVO().getTRS_AC_SL()
     * 		trxMgntCO.getCtstrsVO().getTO_TRS_AC_BR()	To Account
     * 		trxMgntCO.getCtstrsVO().getTO_TRS_AC_CY()
     * 		trxMgntCO.getCtstrsVO().getTO_TRS_AC_GL()
     * 		trxMgntCO.getCtstrsVO().getTO_TRS_AC_CIF()
     * 		trxMgntCO.getCtstrsVO().getTO_TRS_AC_SL()
     * 		trxMgntCO.getCtstrsVO().getCH_AC_BR()		Charge (Other) Account
     * 		trxMgntCO.getCtstrsVO().getCH_AC_CY()
     * 		trxMgntCO.getCtstrsVO().getCH_AC_GL()
     * 		trxMgntCO.getCtstrsVO().getCH_AC_CIF()
     * 		trxMgntCO.getCtstrsVO().getCH_AC_SL()
     * 		trxMgntCO.getCtstrsVO().getCTRL_CY()		Teller Account
     * 		trxMgntCO.getCtstrsVO().getCTRL_GL()
     * 		trxMgntCO.getCtstrsVO().getCTRL_CIF()
     * 		trxMgntCO.getCtstrsVO().getCTRL_SL()
     *          trxMgntCO.getChargesWaived()			If Charges are Waived
     *          trxMgntCO.getChargesEmpty()			If Charges are affected by a change
     *
     * 		Optional:
     * 		trxMgntCO.getCtstrsVO().getTRS_NO()		Transaction Number
     * 		trxMgntCO.getTrxChargesCO().getEntityType()	"REA" for Reasons, "TRX" for Transactions, or each product its own type.
     * 		trxMgntCO.getTrxChargesCO().getReasonCode()	Reason Code for Reasons
     * 		trxMgntCO.getBatchNo()				Batch Number (when calculating Batch Charges)
     *
     *
     *
     * @return TrxMgntCO
     * @throws BaseException
     */
    public TrxMgntCO selectUnifiedCharges(TrxMgntCO trxMgntParamCO) throws BaseException
    {
	TrxMgntCO trxMgntCO = trxMgntParamCO;
	
	/*
	 * Get Session (For Oracle append session to Database Node)
	 */
	trxMgntCO.setSessionID(calculateSessionID());
	
	
	/*
	 * Check whether to proceed with calculation
	 */
	if (!proceedWithCalculation(trxMgntCO))
	{
	    return trxMgntCO;
	}

	/*
	 * Set Default Values
	 */
	trxMgntCO.getCtstrsVO().setEXCHANGE_RATE(NumberUtil.roundToBigDecimal(trxMgntCO.getCtstrsVO().getEXCHANGE_RATE(), 6));
	
//	if(trxMgntCO.getCtstrsVO().getAMOUNT() == null)
//	{
//	    trxMgntCO.getCtstrsVO().setAMOUNT(BigDecimal.ZERO);
//	}
	
	trxMgntCO.getCtstrsVO().setTRS_AC_CIF(retrievePMSCifNo(trxMgntCO));
	
	BigDecimal trsNo = trxMgntCO.getCtstrsVO().getTRS_NO();
	if((TrxMgntConstant.CRUD_AMEND_SO.equals(trxMgntCO.getCrud()) ||
		TrxMgntConstant.CRUD_MAINTENANCE.equals(trxMgntCO.getCrud())) &&
		 !EntityChargesConstant.ENTITY_CHEQUEBOOK.equals(trxMgntCO.getTrxChargesCO().getEntityType()) &&
		 !EntityChargesConstant.ENTITY_PASSBOOK.equals(trxMgntCO.getTrxChargesCO().getEntityType()))
	{
	    trxMgntCO.getCtstrsVO().setTRS_NO(null);
	}
	
	/*
	 * Get Session (For Oracle append session to Database Node)
	 */
	trxMgntCO.setSessionID(calculateSessionID());

	/*
	 * Empty all Charges before commencing
	 */
	emptyCharges(trxMgntCO.getLoginCompCode(),trxMgntCO.getLoginBraCode(),trxMgntCO.getSessionID(), null, trxMgntCO.getBatchNo());

	
	/*
	 * Fill First line to be inserted into CTS_CHARGES_UNIFIED Line 0
	 */
	CTS_CHARGES_UNIFIEDVO ctsChargesUnifiedVO = fillFirstChargeLine(trxMgntCO);

	/**
	 * @author RaniaAlBitar
	 * FIBSI180252  
	 */
	ctsChargesUnifiedVO.setBILL_TYPE(trxMgntCO.getCtstrsVO().getBILL_TYPE());
	ctsChargesUnifiedVO.setTOTAL_FEES_AMT(trxMgntCO.getCtstrsExtendedVO().getADDITIONAL_FEES());
	ctsChargesUnifiedVO.setTOTAL_FEES_AMT_CY(trxMgntCO.getBaseCurrencyCode());
	ctsChargesUnifiedVO.setPROVIDER_CODE(trxMgntCO.getCtstrsVO().getBANK_CIF());
	/*
	 * Insert Line 0 arguments
	 */
	ctsChargesUnifiedVO.setDB_SESSION_ID(trxMgntCO.getSessionID());
	//Rakan Makarem TP#509059 Apply the charge hash table to solve the Deadlocks
	if(commonLibBO.returnIsSybase() == 1)
	{
		coreCommonChargesDAO.insertHashCtsChargesUnified(ctsChargesUnifiedVO);
	}
	else
	{
		genericDAO.insert(ctsChargesUnifiedVO);
	}
	
	/*
	 * In case of Multi-Trx, fill the temp table
	 */
	if(ConstantsCommon.ONE.equals(trxMgntCO.getCtstrxtypeVO().getMULTI_TRX()))
	{
	    /*
	     * In case of Batch and multi accounts not supplied, retrieve them
	     */
	    trxMgntCO = fillBatchMultiAccounts(trxMgntCO);
	    
	    
	    
	    trxMgntCO.getCtstrsVO().setTELLER_CODE(trxMgntCO.getLoginTellerCode());
	    trxMgntCO.getCtstrsVO().setCOMP_CODE(trxMgntCO.getLoginCompCode());
	    trxMgntCO.getCtstrsVO().setBRANCH_CODE(trxMgntCO.getLoginBraCode());

	    entityChargesBO.processMultiTransfer(trxMgntCO);
	}

	/*
	 * Call Procedure to calculate Charges
	 */
	EntityChargesSC entityChargesSC = new EntityChargesSC();
	entityChargesSC.setLanguage(trxMgntCO.getLanguage());
	entityChargesSC.setUserId(trxMgntCO.getLoginUserId());
	entityChargesSC.setCompCode(trxMgntCO.getLoginCompCode());
	entityChargesSC.setBranchCode(trxMgntCO.getLoginBraCode());
	entityChargesSC = coreCommonProcedureBO.calculateCharges(entityChargesSC);
	if(entityChargesSC != null)
	{
	    trxMgntCO.setErrorCode(entityChargesSC.getErrorCode());
	    trxMgntCO.setErrorMsg(entityChargesSC.getErrorMessage());
	}
	/*
	 * In case some charges are not needed, delete them
	 */
	removeUselessData(trxMgntCO);

	/*
	 * Retrieve charges data
	 */
	trxMgntCO = retrieveTempChargeData(trxMgntCO);


	/*
	 * Set Total Amounts and Format
	 */	
	if(entityChargesSC == null)
	{
	    /*
	     * Empty Normal Charges Total
	     */
	    trxMgntCO.getTrxChargesCO().setTotalNew(null);
	    trxMgntCO.getTrxChargesCO().setTotalFc(null);
	    
	    /*
	     * Empty Dues Charges Total
	     */
	    trxMgntCO.getTrxChargesCO().setTotalDuesNew(null);
	    trxMgntCO.getTrxChargesCO().setTotalDuesFc(null);
	    
	    /*
	     * Empty Total VO
	     */
	    trxMgntCO.getCtstrsVO().setCHARGE(null);
	    trxMgntCO.getCtstrsVO().setFC_CHARGES(null);
	}
	else
	{
	    trxMgntCO = calculateTotalCharges(trxMgntCO);
	    
	    /*
	     * Fill Dues Charges Total
	     */
	    trxMgntCO.getTrxChargesCO().setTotalDuesNew(entityChargesSC.getTotalCvDues());
	    trxMgntCO.getTrxChargesCO().setTotalDuesFc(entityChargesSC.getTotalFcDues());
	}

	trxMgntCO.getCtstrsVO().setTRS_NO(trsNo);
	
	if(TrxMgntConstant.CRUD_AMEND_SO.equals(trxMgntCO.getCrud()) &&
		NumberUtil.emptyDecimalToNull(trsNo) != null && trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs() != null &&
		    !trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().isEmpty())
	{
	    
		for(int i = 0; i < trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().size(); i++)
		{
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().setTRS_NO(trsNo);
		    
		    if(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO() != null)
		    {
			trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO().setTRS_NO(trsNo);
		    }
		}
	    
	}
	
	
	/*
	 * Batch Delete Line 0 when finishing calculation TP#239424 11/11/2014
	 */
	if(NumberUtil.emptyDecimalToNull(trxMgntCO.getBatchNo()) != null)
	{
	    removeFirstChargeLine(trxMgntCO);
	}
	
	return trxMgntCO;
    }


    /**
     * This function will retrieve the data from CTS_CHARGES_UNIFIED and set them in TrxMgntCO.
     * Should be called after calling the Procedure coreCommonProcedureBO.calculateCharges(entityChargesSC)
     *
     * @author Reda Charabaty
     * @param  TrxMgntCO
     * 		trxMgntCO.getSessionID()
     * 		trxMgntCO.getLoginCompCode()
     * 		trxMgntCO.getLoginBraCode()
     * 
     * 	Optional:
     * 		trxMgntCO.getTrxChargesCO().getEntityType()
     *
     *
     *
     * @return TrxMgntCO
     * @throws BaseException
     */
    public TrxMgntCO retrieveTempChargeData(TrxMgntCO trxMgntCO) throws BaseException
    {

	/*
	 * Fetch Charges data from Table
	 */
	TrxMgntSC trxMgntSC = new TrxMgntSC();
	trxMgntSC.setCompCode(trxMgntCO.getLoginCompCode());
	trxMgntSC.setBranchCode(trxMgntCO.getLoginBraCode());
	trxMgntSC.setSessionID(trxMgntCO.getSessionID());
	trxMgntSC.setBatchNo(trxMgntCO.getBatchNo());

	/*
	 * Set Product Type
	 */
	trxMgntSC.setType(calculateProductType(trxMgntCO));
	
	// added by nancy -- 14/04/2018--FIBSI170009-Integration with chequebook printer and provider
	if("CHQ".equals(trxMgntSC.getType()))
	{
	    trxMgntSC.setPrintingLocation(trxMgntCO.getTrxChargesCO().getPrintingLocation());
	}
	// end nancy

	/*
	 * Retrieve Charges data
	 */
	List<CTS_CHARGES_UNIFIEDVO> retrievedCtsChargesUnified = retrieveCtsChargesUnifiedList(trxMgntSC);


	/*
	 * Clear Charges data in CO
	 */
	if(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs() == null)
	{
	    trxMgntCO.getTrxChargesCO().setTrxMgntChargesCOs(new ArrayList<TrxMgntChargesCO>());
	}

	trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().clear();

	/*
	 * Copy data from Table to CO
	 */
	if(retrievedCtsChargesUnified != null && !retrievedCtsChargesUnified.isEmpty())
	{
	    TrxMgntChargesCO trxMgntChargesCO;
	    int count = -1;
	    int lineNo = 1;

	    for(int i = 0; i < retrievedCtsChargesUnified.size(); i++)
	    {
		trxMgntChargesCO = new TrxMgntChargesCO();
		if(trxMgntChargesCO.getCtsChargesVO() == null)
		{
		    trxMgntChargesCO.setCtsChargesVO(new CTSCHARGESVO());
		}

		if(retrievedCtsChargesUnified.get(i).getCHARGE_CODE().compareTo(BigDecimal.ZERO) < 0) //VAT
		{
		    trxMgntChargesCO.setTvaChargesDetVO(copyChargesToVO(retrievedCtsChargesUnified.get(i),trxMgntChargesCO.getTvaChargesDetVO()));
		    trxMgntChargesCO.getTvaChargesDetVO().setLINE_NO(new BigDecimal(lineNo));
		    
		    /*
		     * In case of reasons, Charge Account cannot be null in db
		     */
		    if(EntityChargesConstant.ENTITY_REASON.equals(calculateProductType(trxMgntCO)))
		    {
			trxMgntChargesCO.getTvaChargesDetVO().setACC_BR(NumberUtil.nullToZero(trxMgntChargesCO.getTvaChargesDetVO().getACC_BR()));
			trxMgntChargesCO.getTvaChargesDetVO().setACC_CY(NumberUtil.nullToZero(trxMgntChargesCO.getTvaChargesDetVO().getACC_CY()));
			trxMgntChargesCO.getTvaChargesDetVO().setACC_GL(NumberUtil.nullToZero(trxMgntChargesCO.getTvaChargesDetVO().getACC_GL()));
			trxMgntChargesCO.getTvaChargesDetVO().setACC_CIF(NumberUtil.nullToZero(trxMgntChargesCO.getTvaChargesDetVO().getACC_CIF()));
			trxMgntChargesCO.getTvaChargesDetVO().setACC_SL(NumberUtil.nullToZero(trxMgntChargesCO.getTvaChargesDetVO().getACC_SL()));
		    }
		    
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(count).setTvaChargesDetVO(trxMgntChargesCO.getTvaChargesDetVO());
		}
		else //Normal Charge
		{
		    count = count + 1;

		    trxMgntChargesCO.setCtstrsCHARGESDETVO(copyChargesToVO(retrievedCtsChargesUnified.get(i),trxMgntChargesCO.getCtstrsCHARGESDETVO()));
		    trxMgntChargesCO.getCtstrsCHARGESDETVO().setLINE_NO(new BigDecimal(lineNo));

		    /*
		     * Fill General Charge Info
		     */
		    trxMgntChargesCO.getCtsChargesVO().setBRIEF_NAME_ENG(retrievedCtsChargesUnified.get(i).getBRIEF_DESC_ENG());
		    trxMgntChargesCO.getCtsChargesVO().setBRIEF_NAME_ARAB(retrievedCtsChargesUnified.get(i).getBRIEF_DESC_ARAB());
		    trxMgntChargesCO.getCtsChargesVO().setCONSIDER_ONCE_FOR_MULTI_TRX(retrievedCtsChargesUnified.get(i).getCONSIDER_ONCE());
		  
		    trxMgntChargesCO.getCtsChargesVO().setCHRG_ON_EXCEED(retrievedCtsChargesUnified.get(i).getCHRG_ON_EXCEED());
		    trxMgntChargesCO.setActionType(retrievedCtsChargesUnified.get(i).getACTION_TYPE());
		    trxMgntChargesCO.setTypeInd(retrievedCtsChargesUnified.get(i).getTYPE_IND());
		
		    /*
		     * In case of reasons, Charge Account cannot be null in db
		     */
		    if(EntityChargesConstant.ENTITY_REASON.equals(calculateProductType(trxMgntCO)))
		    {
			trxMgntChargesCO.getCtstrsCHARGESDETVO().setACC_BR(NumberUtil.nullToZero(trxMgntChargesCO.getCtstrsCHARGESDETVO().getACC_BR()));
			trxMgntChargesCO.getCtstrsCHARGESDETVO().setACC_CY(NumberUtil.nullToZero(trxMgntChargesCO.getCtstrsCHARGESDETVO().getACC_CY()));
			trxMgntChargesCO.getCtstrsCHARGESDETVO().setACC_GL(NumberUtil.nullToZero(trxMgntChargesCO.getCtstrsCHARGESDETVO().getACC_GL()));
			trxMgntChargesCO.getCtstrsCHARGESDETVO().setACC_CIF(NumberUtil.nullToZero(trxMgntChargesCO.getCtstrsCHARGESDETVO().getACC_CIF()));
			trxMgntChargesCO.getCtstrsCHARGESDETVO().setACC_SL(NumberUtil.nullToZero(trxMgntChargesCO.getCtstrsCHARGESDETVO().getACC_SL()));
		    }
		    
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().add(count, trxMgntChargesCO);


		}

		lineNo = lineNo + 1;
	    }
	}

	return trxMgntCO;
    }


    /**
     * This Function will retrieve data from CTS_CHARGES_UNIFIED and set them in list of VOs
     *
     * @author Reda Charabaty
     * @param TrxMgntSC
     * 		trxMgntSC.sessionID		Session ID
     * 		trxMgntSC.type			Entity Type (EX:'TRX')
     *
     * 		Optional:
     * 		trxMgntSC.compCode
     * 		trxMgntSC.branchCode
     * 		trxMgntSC.batchNo
     *
     *
     * @return List<CTS_CHARGES_UNIFIEDVO>
     * @throws BaseException
     */
    public List<CTS_CHARGES_UNIFIEDVO> retrieveCtsChargesUnifiedList(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonChargesDAO.retrieveCtsChargesUnifiedList(trxMgntSC);
    }


    /**
     * This function will empty the data from CTS_CHARGES_UNIFIED based on
     * Session ID
     *
     *
     * @author Reda Charabaty
     * @param 	compCode
     * 		branchCode
     * 		sessionID
     *
     * 		Optional: actionType	To Delete a specific Action Type (Without Line 0)
     *
     *
     *
     * @throws BaseException
     */
    public void emptyCharges(BigDecimal compCode, BigDecimal branchCode, BigDecimal sessionID, String actionType, BigDecimal batchNo) throws BaseException
    {
	TrxMgntChargesSC trxMgntChargesSC = new TrxMgntChargesSC();
	trxMgntChargesSC.setCompCode(compCode);
	trxMgntChargesSC.setBranchCode(branchCode);
	trxMgntChargesSC.setSessionID(sessionID);
	

	if(actionType != null)
	{
	    trxMgntChargesSC.setActionType(actionType);
	}

	coreCommonChargesDAO.deleteCtsChargesUnified(trxMgntChargesSC);
	
	
	/*
	 * Delete Batch Charges
	 */
	if(NumberUtil.isNumberPositive(batchNo))
	{
	    trxMgntChargesSC.setBatchNo(batchNo);
	    
	    coreCommonChargesDAO.deleteBatchCtsChargesUnified(trxMgntChargesSC);
	}
	
    }


    /**
     * This function will copy required charge data from the list of Unified
     * Charges VOs to the Charges Det VO used in our application
     *
     * @author Reda Charabaty
     * @param 	retrievedCtsChargesUnified	CTS_CHARGES_UNIFIEDVO retrieved from database
     * 			retrievedCtsChargesUnified.getCHARGE_CODE()
     * 			retrievedCtsChargesUnified.getAMOUNT()
     * 			retrievedCtsChargesUnified.getAMOUNT_NEW()
     * 			retrievedCtsChargesUnified.getAMOUNT_FC_NEW()
     * 			retrievedCtsChargesUnified.getCREDIT_ACC_BR()
     * 			retrievedCtsChargesUnified.getCREDIT_ACC_CY()
     * 			retrievedCtsChargesUnified.getCREDIT_ACC_GL()
     * 			retrievedCtsChargesUnified.getCREDIT_ACC_CIF()
     * 			retrievedCtsChargesUnified.getCREDIT_ACC_SL()
     * 			retrievedCtsChargesUnified.getDEBIT_ACC_BR()
     * 			retrievedCtsChargesUnified.getDEBIT_ACC_CY()
     * 			retrievedCtsChargesUnified.getDEBIT_ACC_GL()
     * 			retrievedCtsChargesUnified.getDEBIT_ACC_CIF()
     * 			retrievedCtsChargesUnified.getDEBIT_ACC_SL()
     * 			retrievedCtsChargesUnified.getAPPLY_TVA()
     * 			retrievedCtsChargesUnified.getVAT_CODE()
     * 			retrievedCtsChargesUnified.getPASS_SEPARATELY()
     * 			retrievedCtsChargesUnified.getDUES_COLLECTION_TYPE()
     * 			retrievedCtsChargesUnified.getACTION_TYPE()
     *
     * 		ctstrsChargesDetVO		VO to copy data to from retrievedCtsChargesUnified
     *
     *
     *
     * @return CTSTRS_CHARGES_DETVO
     * @throws BaseException
     */
    public CTSTRS_CHARGES_DETVO copyChargesToVO(CTS_CHARGES_UNIFIEDVO retrievedCtsChargesUnified, CTSTRS_CHARGES_DETVO ctstrsChargesDetVO) throws BaseException
    {
	if(ctstrsChargesDetVO != null && retrievedCtsChargesUnified != null)
	{
	    PathPropertyUtil.copyProperties(retrievedCtsChargesUnified,ctstrsChargesDetVO,
	    "CHARGE_CODE"				, "AMOUNT",
	    "AMOUNT_NEW"				, "AMOUNT_FC_NEW",
	    "CREDIT_ACC_BR ACC_BR"			, "CREDIT_ACC_CY ACC_CY",
	    "CREDIT_ACC_GL ACC_GL"			, "CREDIT_ACC_CIF ACC_CIF",
	    "CREDIT_ACC_SL ACC_SL"			, "DR_CRITERIA",
	    "DEBIT_ACC_BR DEDUCT_FROM_ACC_BR"		, "DEBIT_ACC_CY DEDUCT_FROM_ACC_CY",
	    "DEBIT_ACC_GL DEDUCT_FROM_ACC_GL"		, "DEBIT_ACC_CIF DEDUCT_FROM_ACC_CIF",
	    "DEBIT_ACC_SL DEDUCT_FROM_ACC_SL"		, "APPLY_TVA",
	    "VAT_CODE"					, "PASS_SEPARATELY",
	    "DUES_COLLECTION_TYPE"			, "ACTION_TYPE",
	    "DUES_MODE_PAY"				, "DR_ACC_GL",
	    "DR_ACC_CIF"				, "DR_ACC_SL",
	    "USER_ID"					, "EXCH_RATE",
	    "SCHEMA_CODE"				, "CHARGE_PERC", "ORIGINAL_AMOUNT");

	}

	return ctstrsChargesDetVO;
    }


    /**
     * This function will prepare the unified charges data for calling the
     * Procedure that calculates them.
     *
     * @author Reda Charabaty
     * @param  TrxMgntCO
     *
     * 		Preferred to be filled:
     * 		trxMgntCO.getLoginUserId()
     * 		trxMgntCO.getLoginCompCode()
     * 		trxMgntCO.getLoginBraCode()
     * 		trxMgntCO.getLoginTellerCode()
     * 		trxMgntCO.getCtstrsVO().getTRX_TYPE()
     * 		trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND()
     * 		trxMgntCO.getCrud()
     * 		trxMgntCO.getCtstrsVO().getTRS_CY()
     * 		trxMgntCO.getRunningDateRET()
     * 		trxMgntCO.getCtstrsVO().getAMOUNT()
     * 		trxMgntCO.getCtstrsVO().getCV_AMOUNT()
     * 		trxMgntCO.getCtstrsVO().getEXCHANGE_RATE()
     * 		trxMgntCO.getCtstrsVO().getTRSFR_METHOD()
     * 		trxMgntCO.getCtstrsVO().getTRS_AC_BR()
     * 		trxMgntCO.getCtstrsVO().getTRS_AC_CY()
     * 		trxMgntCO.getCtstrsVO().getTRS_AC_GL()
     * 		trxMgntCO.getCtstrsVO().getTRS_AC_CIF()
     * 		trxMgntCO.getCtstrsVO().getTRS_AC_SL()
     * 		trxMgntCO.getCtstrsVO().getTO_TRS_AC_BR()
     * 		trxMgntCO.getCtstrsVO().getTO_TRS_AC_CY()
     * 		trxMgntCO.getCtstrsVO().getTO_TRS_AC_GL()
     * 		trxMgntCO.getCtstrsVO().getTO_TRS_AC_CIF()
     * 		trxMgntCO.getCtstrsVO().getTO_TRS_AC_SL()
     * 		trxMgntCO.getCtstrsVO().getCH_AC_BR()
     * 		trxMgntCO.getCtstrsVO().getCH_AC_CY()
     * 		trxMgntCO.getCtstrsVO().getCH_AC_GL()
     * 		trxMgntCO.getCtstrsVO().getCH_AC_CIF()
     * 		trxMgntCO.getCtstrsVO().getCH_AC_SL()
     * 		trxMgntCO.getCtstrsVO().getCTRL_CY()
     * 		trxMgntCO.getCtstrsVO().getCTRL_GL()
     * 		trxMgntCO.getCtstrsVO().getCTRL_CIF()
     * 		trxMgntCO.getCtstrsVO().getCTRL_SL()
     *
     * 		Optional:
     * 		trxMgntCO.getCtstrsVO().getTRS_NO()
     * 		trxMgntCO.getTrxChargesCO().getEntityType()		"REA" for Reasons, "TRX" for Transactions
     * 		trxMgntCO.getTrxChargesCO().getReasonCode()		Reason Code for Reasons
     *
     *
     *
     * @return CTS_CHARGES_UNIFIEDVO
     * @throws BaseException
     */
    public CTS_CHARGES_UNIFIEDVO fillFirstChargeLine(TrxMgntCO trxMgntCO) throws BaseException
    {
	CTS_CHARGES_UNIFIEDVO ctsChargesUnifiedVO = new CTS_CHARGES_UNIFIEDVO();

        PathPropertyUtil.copyProperties(trxMgntCO,ctsChargesUnifiedVO,
        "loginCompCode COMP_CODE"		, "loginBraCode BRANCH_CODE",
        "ctstrsVO.TRS_NO ENTITY_CODE"		, "ctstrsVO.CASH_DEDUCT_IND DEDUCT",
        "crud CRUD"				, "ctstrsVO.TRS_AC_BR CREDIT_ACC_BR",
        "ctstrsVO.TRS_AC_CY CREDIT_ACC_CY"	, "ctstrsVO.TRS_AC_GL CREDIT_ACC_GL",
        "ctstrsVO.TRS_AC_CIF CREDIT_ACC_CIF"	, "ctstrsVO.TRS_AC_SL CREDIT_ACC_SL",
        "ctstrsVO.TO_TRS_AC_BR DEBIT_ACC_BR"	, "ctstrsVO.TO_TRS_AC_CY DEBIT_ACC_CY",
        "ctstrsVO.TO_TRS_AC_GL DEBIT_ACC_GL"	, "ctstrsVO.TO_TRS_AC_CIF DEBIT_ACC_CIF",
        "ctstrsVO.TO_TRS_AC_SL DEBIT_ACC_SL"	, "ctstrsVO.CH_AC_BR CHARGE_ACC_BR",
        "ctstrsVO.CH_AC_CY CHARGE_ACC_CY"	, "ctstrsVO.CH_AC_GL CHARGE_ACC_GL",
        "ctstrsVO.CH_AC_CIF CHARGE_ACC_CIF"	, "ctstrsVO.CH_AC_SL CHARGE_ACC_SL",
        "ctstrsVO.AMOUNT AMOUNT_FC_NEW"		, "ctstrsVO.TRS_CY TRS_CY",
        "runningDateRET TRS_DATE"		, "ctstrsVO.CV_AMOUNT AMOUNT",
        "ctstrsVO.EXCHANGE_RATE EXCH_RATE"	, "ctstrsVO.TRSFR_METHOD TRSFR_METHOD",
        "loginUserId USER_ID"			, "chargeActionType ACTION_TYPE",
        "ctstrsVO.CTRL_CY CTRL_CY"		, "ctstrsVO.CTRL_GL CTRL_GL",
        "ctstrsVO.CTRL_CIF CTRL_CIF"		, "ctstrsVO.CTRL_SL CTRL_SL",
        "serialNo SERIAL_NO"			, "batchNo BATCH_NO",
        "loginTellerCode TELLER_CODE"		, "trxChargesCO.leaves LEAVES",
        "trxChargesCO.type TYPE"		, "trxChargesCO.chqIssueType CHQ_ISSUE_TYPE",
        "entryDeductChrgVO.BRANCH_CODE ENTRY_DEDUCT_BR",
        "entryDeductChrgVO.CIF_SUB_NO ENTRY_DEDUCT_CIF",
        "entryDeductChrgVO.CURRENCY_CODE ENTRY_DEDUCT_CY",
        "entryDeductChrgVO.GL_CODE ENTRY_DEDUCT_GL",
        "entryDeductChrgVO.SL_NO ENTRY_DEDUCT_SL",
/*        "ENTRY_DEDUCT ENTRY_DEDUCT",*/
        "chargeSchema SCHEMA_CODE"		, "trxChargesCO.statusIdentifier DESCRIPTION",
        "trsNo TRS_NO_SO"			, "trxChargesCO.printingLocation DESCRIPTION1",// modified by nancy -- 14/04/2018--FIBSI170009-Integration with chequebook printer and provider
        "ctstrsVO.BENEF_BANK BENEF_BANK");//added by maria for BMO180166 12-03-2019


	ctsChargesUnifiedVO.setLINE_NO(BigDecimal.ZERO);

	/*
	 * Set Entity Type Code, else use default value TRX
	 */
        ctsChargesUnifiedVO.setENTITY_TYPE_CODE(calculateEntityTypeCode(trxMgntCO));

        /*
	 * Set Entity Type, else use default value TRX
	 */
	ctsChargesUnifiedVO.setPRODUCT_NAME(calculateProductType(trxMgntCO));
	
	/*
	 * For Reasons set Transaction Type in ctsChargesUnifiedVO.TRX_TYPE_CODE
	 */
	if(EntityChargesConstant.ENTITY_REASON.equals(calculateProductType(trxMgntCO)))
	{
	    ctsChargesUnifiedVO.setTRX_TYPE_CODE(trxMgntCO.getCtstrsVO().getTRX_TYPE());
	}
	
	//patricia calculate the void charges when voiding from the maint trx screen
		if(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeExtendedVO().getMANUAL_VOID_ON_TRX_CHEQUE_YN()).equals("1") 
			&& TrxMgntConstant.CRUD_MAINTENANCE.equals(trxMgntCO.getCrud())
		    && !StringUtil.nullToEmpty(trxMgntCO.getCtstrsVO().getVOID_REASON()).equals(""))
		{
		    ctsChargesUnifiedVO.setTRX_TYPE_CODE(trxMgntCO.getCtstrsVO().getTRX_TYPE());
		     ctsChargesUnifiedVO.setLEAVES( new BigDecimal(trxMgntCO.getCtstrsVO().getVOID_REASON())); 
		   
		}
	/*
	 * Fix Empty Values
	 */
	if(ctsChargesUnifiedVO.getBATCH_NO() == null)
	{
	    ctsChargesUnifiedVO.setBATCH_NO(BigDecimal.ZERO);
	}
	if(ctsChargesUnifiedVO.getSERIAL_NO() == null)
	{
	    ctsChargesUnifiedVO.setSERIAL_NO(BigDecimal.ZERO);
	}

	return ctsChargesUnifiedVO;
    }


    /**
     * This function deletes the Line 0 from table CTS_CHARGES_UNIFIED
     * when given a specific Batch Number 
     * 
     * @author Reda Charabaty
     * @param TrxMgntCO
     * 
     *            LoginCompCode		Login Company Code
     *            LoginBraCode		Login Branch Code
     *            BatchNo		Batch Number
     * 
     * 
     * 
     * @throws BaseException
     */
    public void removeFirstChargeLine(TrxMgntCO trxMgntCO) throws BaseException
    {
	TrxMgntChargesSC trxMgntChargesSC = new TrxMgntChargesSC();
	trxMgntChargesSC.setCompCode(trxMgntCO.getLoginCompCode());
	trxMgntChargesSC.setBranchCode(trxMgntCO.getLoginBraCode());
	trxMgntChargesSC.setSessionID(calculateSessionID());
	trxMgntChargesSC.setBatchNo(trxMgntCO.getBatchNo());
	trxMgntChargesSC.setLineNo(BigDecimal.ZERO);
	//trxMgntChargesSC.setSerialNo(trxMgntCO.getSerialNo());
	
	coreCommonChargesDAO.deleteCtsChargesUnified(trxMgntChargesSC);
    }
    

    /**
     * This function checks if the system should calculate the charges or not
     * based on a few criteria
     * 
     * @author Reda Charabaty
     * @param TrxMgntCO
     * 
     * 		trxMgntCO.getTrxChargesCO().getEntityType()		Entity Type
     *          trxMgntCO.getCrud() 					Crud
     *          trxMgntCO.getChargesEmpty()				If Charges should be recalculated	
     *          trxMgntCO.getChargesWaived()				If Charges are waived
     *          trxMgntCO.getCtstrxtypeVO()				Trx Type VO
     * 
     * 
     * 
     * @return Boolean True to Proceed False to Halt
     * @throws BaseException
     */
    public Boolean proceedWithCalculation(TrxMgntCO trxMgntCO) throws BaseException
    {
	/*
	 * If charges are reset due to change, calculate again, else just retrieve
	 */
	if((trxMgntCO.getTrxChargesCO().getEntityType() == null || TrxMgntConstant.TRX_ENTRY_SCREEN.equals(trxMgntCO.getTrxChargesCO().getEntityType()))
		&& (TrxMgntConstant.CRUD_MAINTENANCE.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_BULK_REMITTANCE.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_APPROVE.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_CANCEL.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_REVERSE.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_RELEASE_HOF.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_AMEND_SO.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_STOP_SO.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_CLOSE_SO.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_APPROVE_REACTIVATE_SO.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_APPLY_VOID_INWARD_CHQ.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_APPLY_VOID_OUTWARD_CHQ.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_APPLY_VOID_HOUSE_CHQ.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_TO_RELEASE_HOF.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_TO_BE_RELEASED.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_VOID_HOUSE_CHQ.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_VOID_INWARD_CHQ.equals(trxMgntCO.getCrud())
			|| TrxMgntConstant.CRUD_APP_VOID_INWARD_CHQ.equals(trxMgntCO.getCrud())
				
			)
		&& !EntityChargesConstant.TF_TRUE.equals(trxMgntCO.getChargesEmpty()))
	{
	    return false;
	}
	   
	if((trxMgntCO.getTrxChargesCO().getEntityType() == null || TrxMgntConstant.TRX_ENTRY_SCREEN.equals(trxMgntCO.getTrxChargesCO().getEntityType()))
		&& (TrxMgntConstant.CRUD_APPROVE_REACTIVATE_SO.equals(trxMgntCO.getCrud())
        		|| TrxMgntConstant.CRUD_APPLY_VOID_INWARD_CHQ.equals(trxMgntCO.getCrud())
        		|| TrxMgntConstant.CRUD_APPLY_VOID_OUTWARD_CHQ.equals(trxMgntCO.getCrud())
        		|| TrxMgntConstant.CRUD_APPLY_VOID_HOUSE_CHQ.equals(trxMgntCO.getCrud()))
			|| TrxMgntConstant.CRUD_TO_RELEASE_HOF.equals(trxMgntCO.getCrud()))
	{
	    return false;
	}
	if(TrxMgntConstant.CRUD_TO_REVERSE.equals(trxMgntCO.getCrud()) && !StringUtil.isNotEmpty(trxMgntCO.getChargeActionType()))
	{
	    return false;
	}
	
	/*if((trxMgntCO.getTrxChargesCO().getEntityType() == null || TrxMgntConstant.TRX_ENTRY_SCREEN.equals(trxMgntCO.getTrxChargesCO().getEntityType())) &&
		BigDecimal.ZERO.compareTo(NumberUtil.nullToZero(trxMgntCO.getCtstrsVO().getAMOUNT())) == 0
		&& !"1".equals(trxMgntCO.getCtstrxtypeVO().getSTANDING_ORDER()))
	{
	    return false;
	}*/
	
	/*
	 * If Statement Fees, then dont Recalculate
	 */
	if("1".equals(trxMgntCO.getCtstrxtypeVO().getDEF_CHARGE_IN_TRS()))
	{
	    return false;
	}

	return true;
    }


    /**
     * This function deletes unneeded Charge data
     *
     * @author Reda Charabaty
     * @param TrxMgntCO
     *
     *            trxMgntCO.getCrud()
     *            trxMgntCO.getChargesEmpty()
     *            trxMgntCO.getLoginCompCode()
     *            trxMgntCO.getLoginBraCode()
     * 		  trxMgntCO.getSessionID()
     *
     *
     * @throws BaseException
     */
    public void removeUselessData(TrxMgntCO trxMgntCO) throws BaseException
    {
	if(TrxMgntConstant.CRUD_AMEND_SO.equals(trxMgntCO.getCrud())
		&& !EntityChargesConstant.TF_TRUE.equals(trxMgntCO.getChargesEmpty()))
	{
	    emptyCharges(trxMgntCO.getLoginCompCode(),trxMgntCO.getLoginBraCode(),trxMgntCO.getSessionID(),"P", null);
	}
    }

    /**
     * This function calculates and returns the Session ID. It appends the DB
     * Node, since in Oracle, uniqueness is by Session ID and DB Node
     *
     * @author Reda Charabaty
     * @param TrxMgntCO
     *
     *            trxMgntCO.getCrud()
     *            trxMgntCO.getChargesEmpty()
     *            trxMgntCO.getLoginCompCode()
     *            trxMgntCO.getLoginBraCode()
     *            trxMgntCO.getSessionID()
     *
     *
     * @return BigDecimal Session ID
     *
     * @throws BaseException
     */
    public BigDecimal calculateSessionID() throws BaseException
    {
	BigDecimal sessionID;
	CommonLibCO commonLibCO = commonLibBO.returnDBSessionDetails();
	String appendedSession = commonLibCO.getDbSessionId().toString().concat(commonLibCO.getDbNode());
	sessionID = new BigDecimal(appendedSession);

	return sessionID;
    }


    /**
     * This function returns the Product Type that the charge
     * will be calculated for. This is to differentiate between
     * different types of charges, such as normal Transaction Charges,
     *  or Transaction Reason Charges, or others.
     *
     * @author Reda Charabaty
     * @param TrxMgntCO
     *
     *            trxMgntCO.getTrxChargesCO().getEntityType()	Can be filled with Product Name (ex:Reasons --> REA)
     *            						Leave Empty for Transaction Charges
     *
     *
     * @return BigDecimal Session ID
     *
     * @throws BaseException
     */
    public String calculateProductType(TrxMgntCO trxMgntCO) throws BaseException
    {
	/*
	 * Set Entity Type, else use default value TRX
	 */
	if(trxMgntCO.getTrxChargesCO() == null || trxMgntCO.getTrxChargesCO().getEntityType() == null)
	{
	    return EntityChargesConstant.ENTITY_TRANSACTION;
	}
	else
	{
	    return trxMgntCO.getTrxChargesCO().getEntityType();
	}

    }


    /**
     * This function returns the value to be set in Entity
     * Type Code for calculating the Charges. This depends on the
     * Charge Type, to set Transaction Type code or Reason Code.
     *
     * @author Reda Charabaty
     * @param TrxMgntCO
     *
     *            trxMgntCO.getTrxChargesCO().getEntityType()	Can be filled with Product Name (ex:Reasons --> REA)
     *            						Leave Empty for Transaction Charges
     *            trxMgntCO.getCtstrsVO().getTRX_TYPE()		For Transaction Charges
     * 		  trxMgntCO.getTrxChargesCO().getReasonCode()	For Reason Charges (Reason Code)
     *
     * @return BigDecimal Session ID
     *
     * @throws BaseException
     */
    public BigDecimal calculateEntityTypeCode(TrxMgntCO trxMgntCO) throws BaseException
    {
	if(EntityChargesConstant.ENTITY_REASON.equals(calculateProductType(trxMgntCO)))
	{
	    return trxMgntCO.getTrxChargesCO().getReasonCode();
	}
	else
	{
	    return trxMgntCO.getCtstrsVO().getTRX_TYPE();
	}
    }
    
    
    /**
     * This function sets the Total Charges based on Pass Separately
     *
     * @author Reda Charabaty
     * @param TrxMgntCO
     *
     *
     * @return TrxMgntCO
     *
     * @throws BaseException
     */
    public TrxMgntCO calculateTotalCharges(TrxMgntCO trxMgntCO) throws BaseException
    {
	BigDecimal totalNew = BigDecimal.ZERO;
	BigDecimal totalFc = BigDecimal.ZERO;
	Boolean isSO = false;
	
	if("1".equals(trxMgntCO.getCtstrxtypeVO().getSTANDING_ORDER()) &&
		(TrxMgntConstant.CRUD_MAINTENANCE.equals(trxMgntCO.getCrud()) ||
			TrxMgntConstant.CRUD_AMEND_SO.equals(trxMgntCO.getCrud())))
	{
	    isSO = true;
	}


	if(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs() != null)
	{
	    for(int i = 0; i < trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().size(); i++)
	    {
		/*
		 * In case pass_seperately is different than 1 (not checked) and
		 * Debit Criteria is empty or 1 (Not Applicable) then count charge
		 */
		if(((trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getPASS_SEPARATELY() == null
			|| !trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getPASS_SEPARATELY().equals("1"))
			|| ((trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getDR_CRITERIA() == null)
				|| (trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getDR_CRITERIA().equals(""))
				|| (trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getDR_CRITERIA().equals("1"))))
		&& (!isSO || (isSO && ("E".equals(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getACTION_TYPE()) ||
			    "A".equals(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getACTION_TYPE()))))		
		)
		{
		  
			/*
			 * Add Normal Charge Amounts to Total
			 */
			totalNew = totalNew.add(NumberUtil.emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getAMOUNT_NEW()));
			totalFc = totalFc.add(NumberUtil.emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getAMOUNT_FC_NEW()));

			/*
			 * Add VAT amounts to Total
			 */

			if(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO() != null)
			{
			    totalNew = totalNew.add(NumberUtil.emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO().getAMOUNT_NEW()));
			    totalFc = totalFc.add(NumberUtil.emptyDecimalToZero(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO().getAMOUNT_FC_NEW()));
			}
		    
		}
	    }
	}

	    
	/*
	 * Fill Normal Charges Total
	 */
	trxMgntCO.getTrxChargesCO().setTotalNew(totalNew);
	trxMgntCO.getTrxChargesCO().setTotalFc(totalFc);

	/*
	 * Fill Total VO
	 */
	trxMgntCO.getCtstrsVO().setCHARGE(totalNew);
	trxMgntCO.getCtstrsVO().setFC_CHARGES(totalFc);


	
	
	return trxMgntCO;

    }
    
    
    /**
     * This function retrieves the accounts from the charge in the given schema
     * could return one or more lines
     *
     * @author Reda Charabaty
     * @param TrxMgntSC
     * 		compCode			Company Code
     * 		chargeSchema			Charge Schema
     *
     *
     * @return List<CTSCHARGESVO>
     * 		trsAcBr
     * 		trsAcCy
     * 		trsAcGl
     * 		trsAcCif
     * 		trsAcSl
     *		chargeBranch
     *
     * @throws BaseException
     */
    public List<CTSCHARGESVO> retrieveChargeAccounts(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonChargesDAO.retrieveChargeAccounts(trxMgntSC);
    }
    
    
    /**
     * This function retrieves the accounts and amounts from multi transaction in case
     * of batch processing
     *
     * @author Reda Charabaty
     * @param TrxMgntSC
     * 		compCode			Company Code
     * 		batchNo				Batch Number
     * 		userId				User ID
     *
     *
     * @return List<CTSTRS_ACC_DETVO>
     * 		AC_BR
     * 		AC_CY
     * 		AC_GL
     * 		AC_CIF
     * 		AC_SL
     *		FC_AMOUNT
     *
     * @throws BaseException
     */
    public List<CTSTRS_ACC_DETVO> retrieveBatchChargeAccounts(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonChargesDAO.retrieveBatchChargeAccounts(trxMgntSC);
    }
    
    
    /**
     * This function retrieves the accounts and amounts from multi transaction in case
     * of batch processing and fills them in the CO
     *
     * @author Reda Charabaty
     * @param TrxMgntCO
     * 		LoginCompCode			Company Code
     * 		BatchNo				Batch Number
     * 		LoginUserId			User ID
     *
     *
     * @return TrxMgntCO
     * 
     *
     * @throws BaseException
     */
    public TrxMgntCO fillBatchMultiAccounts(TrxMgntCO trxMgntCO) throws BaseException
    {
	
	if(NumberUtil.nullEmptyToValue(trxMgntCO.getBatchNo(),BigDecimal.ZERO).compareTo(BigDecimal.ZERO) > 0
		    && (trxMgntCO.getCtstrsACCDETVOs() == null || trxMgntCO.getCtstrsACCDETVOs().isEmpty()))
	{
	    
	    TrxMgntSC trxMgntSC = new TrxMgntSC();
	    trxMgntSC.setCompCode(trxMgntCO.getLoginCompCode());
	    trxMgntSC.setBatchNo(trxMgntCO.getBatchNo());
	    trxMgntSC.setUserId(trxMgntCO.getLoginUserId());
	    trxMgntSC.setFileType(trxMgntCO.getFileType());
	    
	    List<CTSTRS_ACC_DETVO> returnCtrstrsAccDetVOs;
	    returnCtrstrsAccDetVOs = retrieveBatchChargeAccounts(trxMgntSC);

	    if(returnCtrstrsAccDetVOs != null && !returnCtrstrsAccDetVOs.isEmpty())
	    {
		TrxMgntAccountDtlCO trxMgntAccountDtlCO;

		if(trxMgntCO.getCtstrsACCDETVOs() == null)
		{
		    trxMgntCO.setCtstrsACCDETVOs(new ArrayList<TrxMgntAccountDtlCO>());
		}

		trxMgntAccountDtlCO = new TrxMgntAccountDtlCO();
		
		for(int i = 0; i < returnCtrstrsAccDetVOs.size(); i++)
		{
		    trxMgntAccountDtlCO = new TrxMgntAccountDtlCO();

		    trxMgntAccountDtlCO.setCtstrsACCDETAILSVO(returnCtrstrsAccDetVOs.get(i));

		    trxMgntCO.getCtstrsACCDETVOs().add(trxMgntAccountDtlCO);
		}
	    }

	}
	return trxMgntCO;
    }

    
    /**
     * This function retrieves the CIF No for the PMS request by selecting from 
     * PMSTRADEDET based on the Ticket Number
     *
     * @author Reda Charabaty
     * @param TrxMgntCO
     * 		LoginCompCode			Company Code
     * 		LoginBraCode			Branch Number
     * 		TrxChargesCO.TicketNo		Ticket Number
     *
     *
     * @return TrxMgntCO
     * 
     *
     * @throws BaseException
     */
    public BigDecimal retrievePMSCifNo(TrxMgntCO trxMgntCO) throws BaseException
    {
	
	if(trxMgntCO.getAppName() != null && ConstantsCommon.ASSETS_APP_NAME.equals(trxMgntCO.getAppName()) &&
		trxMgntCO.getTrxChargesCO().getEntityType() != null &&
		EntityChargesConstant.ENTITY_REQUEST.equals(trxMgntCO.getTrxChargesCO().getEntityType()) &&
		trxMgntCO.getCtstrsVO() != null && trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND() != null &&
		CtsRequestConstant.PAYMENT_TYPE_CASH.equals(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND()) &&
		trxMgntCO.getTrxChargesCO() != null)
	{	
	    TrxMgntChargesSC trxMgntChargesSC = new TrxMgntChargesSC();
	    trxMgntChargesSC.setCompCode(trxMgntCO.getLoginCompCode());
	    trxMgntChargesSC.setBranchCode(trxMgntCO.getLoginBraCode());
	    trxMgntChargesSC.setCompCode(trxMgntCO.getTrxChargesCO().getTicketNo());

	    return coreCommonChargesDAO.returnChargeSchema(trxMgntChargesSC);
	}
	return trxMgntCO.getCtstrsVO().getTRS_AC_CIF();
    }
    
    /**
     * This function processes the Withholding transaction records of accounts
     * by passing charges or creating a Hold of Funds transaction on the account.
     * Part of Modification #322439
     *
     * @author Reda Charabaty
     * @param WithholdingSC
     * 		compCode			Company Code
     * 		branchCode			Branch Code
     * 		userId				User ID
     * 		taxRegulationID			Tax Regulation ID
     * 		processID			Process ID
     * 		action				Action to be Done ('F' for Final Run / 'T' for Trial Run)
     *
     *
     * @return WithholdingSC
     * 		errorCode			Error Code
     * 		errorMessage			Error Message
     * 
     *
     * @throws BaseException
     */
    public WithholdingSC processWithholding(WithholdingSC withholdingSC) throws BaseException
    {
	/*
	 * Create Hash Table
	 */
	if(commonLibBO.returnIsSybase() == 1)
	{
	  coreCommonBO.dropHashManualJv();
	  coreCommonBO.createHashManualJv();
	  coreCommonProcedureBO.dropTrxHashTables();
	  coreCommonProcedureBO.createTrxHashTables();
	}
	
	
	/*
	 * Call P_RET_PROCESS_WITHHOLDING
	 */
	//Hussein elhajj-27/12/2017
	if("F".equals(withholdingSC.getAction()))
	{
	    String errMsg = "";
	    // withholdingSC.setAction("F");
	    withholdingSC = coreCommonProcedureBO.processWithholding(withholdingSC);

	    if(withholdingSC != null &&  null != withholdingSC.getErrorCode())
	    {
		if(withholdingSC.getErrorCode().compareTo(BigDecimal.ZERO) < 0) // check if negative error code
		{
		    return withholdingSC;
		}
		else if(!NumberUtil.isEmptyDecimal(withholdingSC.getErrorCode())) // warning appended to errMsg
		{
		    errMsg += withholdingSC.getErrorMessage();
		}
	    }
	    else
	    {
		return withholdingSC;
	    }
	    
	    /*
	     * Add Commit since in Sybase, Commit in procedures does not work anymore - Reda - 24/09/2018
	     */
	    coreCommonProcedureBO.commitTrans();
	    

	    withholdingSC.setAction("R");
	    withholdingSC.setErrorCode(null);
	    withholdingSC.setErrorMessage(null);
	    withholdingSC = coreCommonProcedureBO.processWithholding(withholdingSC);

	    if(!withholdingSC.equals(null) && !withholdingSC.getErrorCode().equals(null))
	    {

		if(withholdingSC.getErrorCode().compareTo(BigDecimal.ZERO) < 0)
		{
		    return withholdingSC;
		}
		else if(!NumberUtil.isEmptyDecimal(withholdingSC.getErrorCode()))
		{
		    errMsg += withholdingSC.getErrorMessage();
		}
	    }
	    else
	    {
		return withholdingSC;
	    }
	    
	    /*
	     * Add Commit since in Sybase, Commit in procedures does not work anymore - Reda - 24/09/2018
	     */
	    coreCommonProcedureBO.commitTrans();
	    
	    withholdingSC.setErrorCode(null);
	    withholdingSC.setErrorMessage(null);
	    
	    

	    TrxMgntSC trxMgntSC = new TrxMgntSC();
	    trxMgntSC.setCompCode(withholdingSC.getCompCode());
	    trxMgntSC.setBranchCode(withholdingSC.getBranchCode());
	    trxMgntSC.setRunningDate(withholdingSC.getRunningDate());
	    // trxMgntSC.setTrsNo(retAuxServiceCOParam.getCtstrsVO().getTRS_NO().negate());
	    trxMgntSC.setBaseCurrencyCode(withholdingSC.getBaseCurrencyCode());
	    trxMgntSC.setUserId(withholdingSC.getUserId());
	    trxMgntSC.setTrsType(TrxMgntConstant.TRS_TYPE_CSM);
	    trxMgntSC.setFromCif(withholdingSC.getFromCif());
	    trxMgntSC.setToCif(withholdingSC.getToCif());
	    trxMgntSC.setTaxRegulationID(withholdingSC.getTaxRegulationID());
	    trxMgntSC = coreCommonProcedureBO.releaseHofByCif(trxMgntSC);

	    if(trxMgntSC != null &&  null != trxMgntSC.getErrorCode())
	    {
		if(trxMgntSC.getErrorCode().compareTo(BigDecimal.ZERO) < 0)
		{
		    withholdingSC.setErrorCode(trxMgntSC.getErrorCode());
		    withholdingSC.setErrorMessage(trxMgntSC.getErrorMessage());
		    return withholdingSC;
		}
		else if(!NumberUtil.isEmptyDecimal(trxMgntSC.getErrorCode()))
		{
		    withholdingSC.setErrorCode(trxMgntSC.getErrorCode());
		    withholdingSC.setErrorMessage(trxMgntSC.getErrorMessage());
		    errMsg += trxMgntSC.getErrorMessage();
		}
	    }

	    else
	    {
		return withholdingSC;
	    }
	    
	    /*
	     * Add Commit since in Sybase, Commit in procedures does not work anymore - Reda - 24/09/2018
	     */
	    coreCommonProcedureBO.commitTrans();
	    
	    withholdingSC.setErrorMessage(errMsg);
	    return withholdingSC;

	}
	else
	{
	    withholdingSC = coreCommonProcedureBO.processWithholding(withholdingSC);
	    

	    return withholdingSC;
	    // Hussein el hajj-END
	}
    }
}
