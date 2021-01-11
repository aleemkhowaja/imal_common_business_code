package com.path.bo.core.entitycharges.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.iis.islamiccalculator.IISCommonBO;
import com.path.bo.common.requests.csm.CtsRequestConstant;
import com.path.bo.core.account.AccountBO;
import com.path.bo.core.account.AccountsConstant;
import com.path.bo.core.common.CoreCommonChargesBO;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.entitycharges.EntityChargesBO;
import com.path.bo.core.entitycharges.EntityChargesConstant;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.bo.core.trxtype.TrxTypeBO;
import com.path.dao.core.entitycharges.EntityChargesDAO;
import com.path.dbmaps.vo.ACC_VATVO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.AMF_EXTENDEDVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_EXTENDEDVO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.dbmaps.vo.CTSCERTIFICATE_TYPEVO;
import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTSCHARGES_EXEMPTED_BRANCHVO;
import com.path.dbmaps.vo.CTSCHARGES_SCHEMAVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERACCDETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRS_ACC_DET_TMPVO;
import com.path.dbmaps.vo.CTSTRS_CHARGES_DETVO;
import com.path.dbmaps.vo.CTSTRS_CONF_MSGVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTS_CHARGES_ENTITYVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.CommonLibCO;
import com.path.vo.common.entitycharges.EntityChargesSC;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.entitycharges.CtsChargesEntityCO;
import com.path.vo.core.entitycharges.EntityChargesCO;
import com.path.vo.core.transfercash.TransferCashSC;
import com.path.vo.core.trxmgnt.AccountPositionCO;
import com.path.vo.core.trxmgnt.CtstrsConfMsgSC;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntChargesSC;
import com.path.vo.core.trxmgnt.TrxMgntSC;
import com.path.vo.core.trxmgnt.accountdtl.TrxMgntAccountDtlCO;
import com.path.vo.core.trxtype.TrxTypeSC;
import com.rits.cloning.Cloner;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Reda Charabaty
 * 
 * 
 */

public class EntityChargesBOImpl extends RetailBaseBO implements EntityChargesBO
{

    private EntityChargesDAO entityChargesDAO;
    private AccountBO accountBO;
    private IISCommonBO iisCommonBO;
    private TrxTypeBO trxTypeBO;
    private CoreCommonChargesBO coreCommonChargesBO;

    /**
     * dependency of amount or FC amount on charges screen
     * 
     * @param EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO dependencyByAMT(EntityChargesCO entityChargesCO1) throws BaseException
    {
	EntityChargesCO entityChargesCO = entityChargesCO1;
	BigDecimal amount;
	BigDecimal amountFC;


	if(entityChargesCO.getBaseForeign() != null)
	{
	    /*
	     * Get Amount Changed
	     */
	    if(entityChargesCO.getBaseForeign().equals(EntityChargesConstant.BASE_CURRENCY))
	    {
		amount = entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().getAMOUNT();
	    }
	    else
	    {
		amount = entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().getAMOUNT_FC();
	    }
	    
	    /*
	     * Set empty to null
	     */
	    if(amount != null)
	    {
		amount = NumberUtil.emptyDecimalToNull(amount);
	    }
	    
	    /*
	     * In Case of Negative Amounts
	     */
	    if(NumberUtil.nullToZero(amount).compareTo(BigDecimal.ZERO) < 0)
	    {
		throw new BOException(MessageCodes.CHARGES_AMOUNT_CANNOT_BE_NEGATIVE);
	    }
	    
	    /*
	     * In case of emptying the amount
	     */
	    if(amount == null || NumberUtil.isEmptyDecimal(amount))
	    {
		amount = BigDecimal.ZERO;
		
		if(entityChargesCO.getBaseForeign().equals(EntityChargesConstant.BASE_CURRENCY))
		{
		    entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().setAMOUNT(BigDecimal.ZERO);
		}
		else
		{
		    entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().setAMOUNT_FC(BigDecimal.ZERO);
		}
		
	    }
		
	    
	    /*
	     * Set Currency to be used
	     */
	    entityChargesCO = setChargeAcc(entityChargesCO);
	    
	    if(entityChargesCO.getBaseForeign().equals(EntityChargesConstant.BASE_CURRENCY))
	    {
		amount = amount.setScale(entityChargesCO.getCtsChargesEntityCOs().get(0).getBaseCurrDecPoint().intValue(),BigDecimal.ROUND_HALF_UP);
	    }
	    else
	    {
		if(entityChargesCO.getChargeAccCurrency().equals(entityChargesCO.getBaseCurrencyCode()))
		{
		    amount = amount.setScale(entityChargesCO.getCtsChargesEntityCOs().get(0).getBaseCurrDecPoint().intValue(),BigDecimal.ROUND_HALF_UP);
		}
		else
		{
		    /*
		     * Retrieve FC Currency Details
		     */
		    CURRENCIESVO currenciesVO = new CURRENCIESVO();
		    currenciesVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
		    currenciesVO.setCURRENCY_CODE(entityChargesCO.getChargeAccCurrency());
		    currenciesVO = commonLibBO.returnCurrency(currenciesVO);
		    amount = amount.setScale(currenciesVO.getDECIMAL_POINTS().intValue(),BigDecimal.ROUND_HALF_UP);
		}
			
		
	    }
	    // #553923 -DASI170045 - Commission on Cheque Deposit
	    if(EntityChargesConstant.ENTITY_CERTIFICATE.equals(entityChargesCO.getEntityType()))
		
		
	    {
		CTSCERTIFICATE_TYPEVO ctscertificate = new CTSCERTIFICATE_TYPEVO();
		ctscertificate.setCOMP_CODE(entityChargesCO.getLoginCompCode());
		ctscertificate.setCODE(entityChargesCO.getCertificateCode());
		if (null != entityChargesCO.getCertificateCode() )
		{
		   ctscertificate = (CTSCERTIFICATE_TYPEVO) genericDAO.selectByPK(ctscertificate);
		}
		if("1".equals(ctscertificate.getAPP_MULT_CHRGS())){
		    if (amount.compareTo(NumberUtil.nullToZero(ctscertificate.getMAX_CHARGE_BASE_CY())) > 0)
			{
			    
			    amount =ctscertificate.getMAX_CHARGE_BASE_CY();    
			}
		}
		
	    }
	    //  #553923

	    /*
	     * Set Charges based on schema
	     */

	    entityChargesCO.getCtsChargesEntityCOs().get(0).setCtsChargesVO(retrieveChargesInfo(entityChargesCO.getLoginCompCode(), entityChargesCO
		    .getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().getCHARGE_CODE()));

	    
	    if(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesVO().getALLOW_MODIFY().equals(EntityChargesConstant.VALUE_ZERO))
	    {
		/*
		 * If not allowed to modify or clear charges
		 */

		if(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesVO().getALLOW_CLEARING().equals(EntityChargesConstant.VALUE_ZERO))
		{
		    throw new BOException(MessageCodes.CANNOT_CLEAR_OR_MODIFY_CHARGES);
		}
	    }
	    else
	    {
		/*
		 * Cannot Clear Charges
		 */
		if(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesVO().getALLOW_CLEARING().equals(EntityChargesConstant.VALUE_ZERO)
		
		    &&(amount == null || amount.doubleValue() == 0))
		    {
			throw new BOException(MessageCodes.CANNOT_CLEAR_CHARGES);
		    }
		
	    }
	    
	    /*
	     * Get PTH_CTRL Details
	     */
	    entityChargesCO.setPthCTRL(commonLibBO.returnPthCtrl());

	    /*
	     * Calculate FC/CV Amount
	     */
	    if(entityChargesCO.getChargeAccCurrency().equals(entityChargesCO.getBaseCurrencyCode()))
	    {
		entityChargesCO.setExchRate(BigDecimal.ONE);
		amountFC = amount;
	    }
	    else
	    {
		/*
		 * Get Exchange Rate
		 */
		entityChargesCO.setExchRate(retrieveExchRate(entityChargesCO));
		amountFC = calculateExchangedAmount(entityChargesCO,amount);
	    }

	    /*
	     * Set Equivalent Amount
	     */
	    if(entityChargesCO.getBaseForeign().equals(EntityChargesConstant.BASE_CURRENCY))
	    {
		entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().setAMOUNT_FC(amountFC);
		entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().setAMOUNT(amountFC);
	    }
	    else
	    {
		entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().setAMOUNT(amountFC);
	    }
	    
	   
	    

	    /*
	     * Set VAT Amounts
	     */
	    
	    entityChargesCO.setDeductBr(NumberUtil.emptyDecimalToZero(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_BR()));//BURJ140135
	    entityChargesCO.setRow(BigDecimal.ZERO);
	    entityChargesCO = retrieveVatChargesDetails(entityChargesCO);


	}
	return entityChargesCO;
    }

    /**
     * Updates / Inserts the Charges
     * 
     * @param EntityChargesCO
     * 
     * @throws BaseException
     */
    public void updateCharges(EntityChargesCO entityChargesCO1, String update) throws BaseException
    {
	EntityChargesCO entityChargesCO = entityChargesCO1;
	if(update != null 
	 
	    &&entityChargesCO.getLoginCompCode() != null && entityChargesCO.getLoginBraCode() != null
		    && entityChargesCO.getEntityCode() != null)
	    {
		/*
		 * Set Default Values
		 */
		if(entityChargesCO.getCtsChargesEntityCOs() != null)
		{
		    for(int i = 0; i < entityChargesCO.getCtsChargesEntityCOs().size(); i++)
		    {
			entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().setCOMP_CODE(entityChargesCO.getLoginCompCode());
			entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().setBRANCH_CODE(entityChargesCO.getLoginBraCode());
			entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().setENTITY_TYPE(entityChargesCO.getEntityType());
			entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().setENTITY_CODE(entityChargesCO.getEntityCode());

			/*
			 * Set Default Value of Type Indicator to "P" for Chequebook, "C" for others
			 */
			if(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getTYPE_IND() == null
				|| entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO()
					.getTYPE_IND().equals(EntityChargesConstant.VALUE_EMPTY))
			{
			    /*
			     * Separate Chequebook from others
			     */
			    if(entityChargesCO.getEntityType().equals(CoreCommonConstants.CHEQUEBOOK_ENTITY_TYPE)
				    || entityChargesCO.getEntityType().equals(CoreCommonConstants.LOSTFOUND_ENTITY_TYPE))
			    {
				/*
				 * Set the TYPE_IND for the row
				 */
				entityChargesCO.setRow(new BigDecimal(i));
				entityChargesCO = fillTypeInd(entityChargesCO);
			    }
			    else
			    {
				entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().setTYPE_IND(EntityChargesConstant.TYPEIND_ALL_DEFAULT);
			    }
			    
			}

			/*
			 * Set VAT Defaults
			 */
			if(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO() != null)
			{
			    if(NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT()) == null
				    && NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC()) == null)
			    {
				entityChargesCO.getCtsChargesEntityCOs().get(i).setVatCtsChargesEntityVO(null);
			    }
			    else
			    {
				entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setCOMP_CODE(entityChargesCO.getLoginCompCode());
				entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setBRANCH_CODE(entityChargesCO.getLoginBraCode());
				entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setENTITY_TYPE(entityChargesCO.getEntityType());
				entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setENTITY_CODE(entityChargesCO.getEntityCode());

				/*
				 * Set Default Value of Type Indicator to "P" for Chequebook, "C" for others
				 */
				if(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getTYPE_IND() == null
					|| entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getTYPE_IND().equals(EntityChargesConstant.VALUE_EMPTY))
				{
				    /*
				     * Separate Chequebook from others
				     */
				    if(entityChargesCO.getEntityType().equals(CoreCommonConstants.CHEQUEBOOK_ENTITY_TYPE)
					    || entityChargesCO.getEntityType().equals(CoreCommonConstants.LOSTFOUND_ENTITY_TYPE))
				    {
					entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setTYPE_IND(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getTYPE_IND());
				    }
				    else
				    {
					entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setTYPE_IND(EntityChargesConstant.TYPEIND_ALL_DEFAULT);
				    }
				}
			    }
			}
		    }
		}

		if(update.equals(EntityChargesConstant.SAVEUPDATE_UPDATE))
		{
		    /*
		     * Delete Old Charges
		     */
		    deleteEntityCharges(entityChargesCO);
		}

		if(entityChargesCO.getCtsChargesEntityCOs() != null)
		{
		    /*
		     * Insert New Charges
		     */
		    for(int i = 0; i < entityChargesCO.getCtsChargesEntityCOs().size(); i++)
		    {
			genericDAO.insert(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO());
			
			/*
			 * Insert VAT Charges
			 */
			if(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO() != null)
			{
			    /*
			     * Set VAT deduct account to be same as charge deduct account in case it is empty
			     */
			    if(NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getDEDUCT_FROM_ACC_BR()) == null ||
				    NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getDEDUCT_FROM_ACC_CY()) == null || 
				    NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getDEDUCT_FROM_ACC_GL()) == null || 
				    NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getDEDUCT_FROM_ACC_CIF()) == null || 
				    NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getDEDUCT_FROM_ACC_SL()) == null)
			    {
				entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setDEDUCT_FROM_ACC_BR(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_BR());
				entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setDEDUCT_FROM_ACC_CY(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_CY());
				entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setDEDUCT_FROM_ACC_GL(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_GL());
				entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setDEDUCT_FROM_ACC_CIF(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_CIF());
				entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setDEDUCT_FROM_ACC_SL(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_SL());
			    }
			    
			    entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setCHARGE_CODE(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getCHARGE_CODE().multiply(new BigDecimal(-1)));
			    
			    genericDAO.insert(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO());
			}
		    }
		}
	    }
	 
    }

    public EntityChargesDAO retrieveEntityChargesDAO()
    {
	return entityChargesDAO;
    }

    public void setEntityChargesDAO(EntityChargesDAO entityChargesDAO)
    {
	this.entityChargesDAO = entityChargesDAO;
    }

    /**
     * Retrieves charges details replaces uo_charges.uf_get_charges_details
     * 
     * @param EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO fillChargesDetails(EntityChargesCO entityChargesCO) throws BaseException
    {
	int row = entityChargesCO.getRow().intValue();

	if(!entityChargesCO.getChargeAccCurrency().equals(entityChargesCO.getBaseCurrencyCode())
		&& entityChargesCO.getPthCTRL().getCHARGES_BOOKING().equals(EntityChargesConstant.CHARGES_BOOKING_A))
	{
	    /*
	     * Select Amount from CTSCHARGES_CURRENCY
	     */
	    EntityChargesSC chargesCurrencyEntityChargesSC = new EntityChargesSC();
	    chargesCurrencyEntityChargesSC = returnChargesWithChargesCurrency(entityChargesCO);

	    if(chargesCurrencyEntityChargesSC == null)
	    {

		if(entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_COMMAND_RT)
			|| entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_COMMAND_RTM)
			|| entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_COMMAND_GEN)
			|| entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_COMMAND_CHECKING)
			|| entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_COMMAND_SBR)
			|| entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_COMMAND_DOM)
			|| (entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_COMMAND_GAMT) 
			    && 
		            entityChargesCO.isRepeat()))
		{
		    if(entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_COMMAND_CHECKING))
		    {
			/*
			 * Fill the Proceed variable here. Confirmation message
			 * to be handled in js page, if user chooses yes then
			 * fill "proceed" and call function again
			 */
			if(entityChargesCO.getProceed() == null)
			{
			    throw new BOException(MessageCodes.CHARGE_CODE_NOT_DEFINED_FOR_CY_PROCEED, new String[] {
				    entityChargesCO.getChargeCode().toString(), entityChargesCO.getBriefDescEng() },
				    ConstantsCommon.CONFIRM_MSG_TYPE);
			}
			entityChargesCO.setReturnInt(-1);

		    }
		    else if(entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_COMMAND_DOM)
			    || entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_COMMAND_SBR))
		    {
			entityChargesCO.setReturnInt(-1);
		    }
		}
		else
		{
		    throw new BOException(MessageCodes.CHARGE_NOT_DEFINED_FOR_CURRENCY, new String[] {
			    entityChargesCO.getChargeCode().toString(), entityChargesCO.getBriefDescEng() });
		}

	    }
	    else
	    {
		entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesVO().setAMOUNT(chargesCurrencyEntityChargesSC.getAmount());
		entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesVO().setALLOW_MODIFY(chargesCurrencyEntityChargesSC.getCtsChargesVO().getALLOW_MODIFY());
		entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesVO().setALLOW_CLEARING(chargesCurrencyEntityChargesSC.getCtsChargesVO().getALLOW_CLEARING());
		entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesVO().setBRIEF_NAME_ENG(chargesCurrencyEntityChargesSC.getCtsChargesVO().getBRIEF_NAME_ENG());
		entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesVO().setBRIEF_NAME_ARAB(chargesCurrencyEntityChargesSC.getCtsChargesVO().getBRIEF_NAME_ARAB());
		entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesVO().setAPPLY_TVA(chargesCurrencyEntityChargesSC.getCtsChargesVO().getAPPLY_TVA());
		entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesVO().setVAT_CODE(chargesCurrencyEntityChargesSC.getCtsChargesVO().getVAT_CODE());
	    }
	}

	/*
	 * Get Charges Details
	 */
	TrxMgntChargesSC trxMgntChargesSC = new TrxMgntChargesSC();
	trxMgntChargesSC.setCompCode(entityChargesCO.getLoginCompCode());
	trxMgntChargesSC.setBranchCode(entityChargesCO.getLoginBraCode());
	trxMgntChargesSC.setChargeCy(entityChargesCO.getChargeAccCurrency());
	trxMgntChargesSC.setChargesBooking(entityChargesCO.getPthCTRL().getCHARGES_BOOKING());
	trxMgntChargesSC.setBranchBooking(entityChargesCO.getChargeAccBranch());
	trxMgntChargesSC.setExchangeRate(entityChargesCO.getExchRate());
	trxMgntChargesSC.setTrxAmount(BigDecimal.ZERO);
	trxMgntChargesSC.setTrxType(BigDecimal.ZERO);
	trxMgntChargesSC.setType(EntityChargesConstant.CHARGE_DETAIL_CHARGE);
	trxMgntChargesSC.setDate(entityChargesCO.getRunningDate());
	trxMgntChargesSC.setTrsCy(entityChargesCO.getChargeAccCurrency());
	trxMgntChargesSC.setChargeCode(entityChargesCO.getChargeCode());
	trxMgntChargesSC.setSuppressMessage(entityChargesCO.getSuppressMessage());
	trxMgntChargesSC = retrieveChargesDetails(trxMgntChargesSC);

	entityChargesCO.setCvAmount(trxMgntChargesSC.getCvAmount());
	entityChargesCO.setFcAmount(trxMgntChargesSC.getFcAmount());	

	return entityChargesCO;
    }

    /**
     * This function returns data from CTSCHARGES and CTSCHARGES_CURRENCY
     * 
     * @param EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesSC returnChargesWithChargesCurrency(EntityChargesCO entityChargesCO) throws BaseException
    {
	return entityChargesDAO.returnChargesWithChargesCurrency(entityChargesCO);
    }

    /**
     * Does calculations to get the currency to use in case of Cards
     * 
     * @param EntityChargesCO
     * 		entityChargesCO.getLoginCompCode()
     * 		entityChargesCO.getCardType()
     * 		entityChargesCO.getBaseCurrencyCode()
     * 
     * 
     * @return BigDecimal
     * 
     * @throws BaseException
     */
    public BigDecimal cardsCurrency(EntityChargesCO entityChargesCO) throws BaseException
    {
	BigDecimal currency;

	CTSCARDSVO ctsCardsVO = new CTSCARDSVO();
	ctsCardsVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	ctsCardsVO.setCODE(entityChargesCO.getCardType());
	ctsCardsVO = (CTSCARDSVO) genericDAO.selectByPK(ctsCardsVO);

	/*
	 * Select Currency if base or by card type
	 */
	if(ctsCardsVO.getALLOW_ONLY_BASECY() != null && ctsCardsVO.getALLOW_ONLY_BASECY().equals(EntityChargesConstant.VALUE_ONE))
	{
	    currency = entityChargesCO.getBaseCurrencyCode();
	}
	else
	{
	    if(ctsCardsVO.getPREPAID() != null && ctsCardsVO.getPREPAID().equals(EntityChargesConstant.VALUE_ONE))
	    {
		if(ctsCardsVO.getCURRENCY_CODE() != null && ctsCardsVO.getCURRENCY_CODE().intValue() > 0)
		{
		    currency = ctsCardsVO.getCURRENCY_CODE();
		}
		else
		{
		    currency = entityChargesCO.getBaseCurrencyCode();
		}
	    }
	    else
	    {
		currency = entityChargesCO.getBaseCurrencyCode();
	    }
	}

	return currency;
    }

    /**
     * This function fills charges values based loosely on wf_retrieve_charges in various entity screens: 
     * Chequebook / Safebox / Lostand Found / Passbook / Cards
     *  
     * @param entityChargesCO:
     * 
     *          entityChargesCO.getIsEmptied() 			Should be set to true in order to recalculate charges.
     *          entityChargesCO.getCtsChargesEntityCOs() 	The list of charges should be empty. This and the isEmptied flag can be set on the entity screen when needed.  
     *		entityChargesCO.getDeductCharges() 		If the field Deduct From exists on the main entity screen then set its value, and if it does not this should be sent as null.
     *		entityChargesCO.getEntityType()			This denotes the Entity Screen that is calling the charge, Chequebook is CHQ, Safebox is SAF, Cards is CAR, Lost and Found is LOS, Passbook is PAS, Currency Exchange is EXC
     *		entityChargesCO.getCardType()			In Case of Cards, this field should be filled with Card Type from Cards Managements screen.
     *		entityChargesCO.getAccBranch()			This is the Main Account Branch in the Entity Screen.
     *		entityChargesCO.getAccCurrency()		This is the Main Account Currency in the Entity Screen.
     *		entityChargesCO.getChargeAccBranch()		This is the Charge Account Branch (if it exists) in the Entity Screen.
     *		entityChargesCO.getChargeAccCurrency()		This is the Charge Account Currency (if it exists) in the Entity Screen.
     *		entityChargesCO.getLoginCompCode()		Logged-In Company Code
     *		entityChargesCO.getLoginBraCode()		Logged-In Branch Code
     *		entityChargesCO.getBaseCurrencyCode()		Base Currency Code
     *		entityChargesCO.getBriefDescEngBase()		Base Currency Brief Description (sessionCO.getBaseCurrencyName())
     *		entityChargesCO.getBaseCurrDecPoint()		Base Currency Decimal Points (sessionCO.getBaseCurrDecPoint())
     *		entityChargesCO.getEntityCommand()		Command from the Entity Screen usually with a name of the screen, ex CHQ, and SBR
     *		entityChargesCO.getCrud()			Crud of screen
     *		entityChargesCO.getSchema()			Charges Schema retrieved from Entity Screen parameterization.(should be filled with il_charge_schema)
     *		entityChargesCO.getSchemaDestroy()		In case of Chequebook, there exists Destroy Schema for the Destroy Charges.
     *		entityChargesCO.getSchemaCancel()		In case of Chequebook, there exists Cancel Schema for the Cancel Charges.
     *		entityChargesCO.getRunningDate()		Running Date for CSM
     *		entityChargesCO.isRepeat()			Some cases from Transaction screens require calculation of the total charges without referring to the charges on screen, this flag must be set as True.
     *		entityChargesCO.getProceed()			The proceed flag is used for confirmation message in function getChargesDetails(), in case it is null, the system assumes the message has not been displayed yet, after it is displayed, the client side should fill the Proceed flag based on the user choice.
     *		entityChargesCO.getNumOfEntities()		In the case of Chequebook or Lostand Found, this should be filled as num_of_chqbooks in chequebook and filled as (to_doc - doc_number + 1) in Lostand Found.
     *		entityChargesCO.getChargeType()			In the case of Safebox, we have 4 types of charges, we use this to know which one we are retrieving. Value will be either R / I / S / N for Rental / Insurance / Stamp / Renewal.
     *		entityChargesCO.getPreferredLanguage()		User Preferred Language
     * 
     * @return EntityChargesCO
     * @throws BaseException
     */
    public EntityChargesCO selectCharges(EntityChargesCO entityChargesCO1) throws BaseException
    {
	EntityChargesCO entityChargesCO = entityChargesCO1;
	if((entityChargesCO.getCtsChargesEntityCOs() == null || entityChargesCO.getCtsChargesEntityCOs().isEmpty())
		&& entityChargesCO.getIsEmptied().equals(true))
	{
	    
	    /*
	     * Get Charge Branch and Currency
	     */
	    entityChargesCO = setChargeAcc(entityChargesCO);

	    /*
	     * Get Currency Description and Decimal Points to be used
	     */
	    entityChargesCO = calculateChargeCurrencyDecimalPoints(entityChargesCO);
	    
	    
	    /*
	     * Get the Charges Schema
	     */
	    entityChargesCO = setChargeSchema(entityChargesCO);

	    if(NumberUtil.emptyDecimalToNull(entityChargesCO.getSchema()) != null)
	    {
		List<BigDecimal> schemaCodeList = null;
		schemaCodeList = selectChargesSchemaList(entityChargesCO);

		if(schemaCodeList != null && !schemaCodeList.isEmpty())
		{

		    /*
		     * Initialize Variables and Amounts
		     */
		    if(entityChargesCO.getCtsChargesEntityCOs() == null)
		    {
			entityChargesCO.setCtsChargesEntityCOs(new ArrayList<CtsChargesEntityCO>());
		    }

		    CtsChargesEntityCO ctsChargesEntityCO = new CtsChargesEntityCO();

		    /*
		     * Get Pth_Ctrl details
		     */
		    PTH_CTRLVO pthCtrlVO = commonLibBO.returnPthCtrl();
		    entityChargesCO.setPthCTRL(pthCtrlVO);

		    if(pthCtrlVO.getCHARGES_BOOKING() == null)
		    {
			pthCtrlVO.setCHARGES_BOOKING(EntityChargesConstant.VALUE_EMPTY);
		    }
		    /*
		     * Set Exchange Rate
		     */
		    entityChargesCO.setExchRate(retrieveExchRate(entityChargesCO));

		    /*
		     * Set Entity Count to calculate total
		     */
		    if(entityChargesCO.getNumOfEntities() == null || entityChargesCO.getNumOfEntities().intValue() <= 0)
		    {
			entityChargesCO.setNumOfEntities(BigDecimal.ONE);
		    }
		    int objectcount = 0;
		    /*
		     * Loop on all Schema Charges to insert them
		     */
		    for(int i = 0; i < schemaCodeList.size(); i++)
		    {

			/*
			 * If charges are not exempted then continue
			 */
			if(!checkExemptedCharges(entityChargesCO, schemaCodeList.get(i)))
			{

			    entityChargesCO.setChargeCode(schemaCodeList.get(i));
			    entityChargesCO.setRow(new BigDecimal(objectcount));

			    /*
			     * Add Row
			     */
			    entityChargesCO.getCtsChargesEntityCOs().add(objectcount, ctsChargesEntityCO);
			    ctsChargesEntityCO = new CtsChargesEntityCO();

			    /*
			     * Get Charges Details
			     */
			    entityChargesCO.getCtsChargesEntityCOs().get(objectcount).setCtsChargesVO(retrieveChargesInfo(entityChargesCO.getLoginCompCode(), schemaCodeList.get(i)));

			    /*
			     * Get Charges Details for Row
			     */
			    entityChargesCO = fillChargesDetails(entityChargesCO);

			    /*
			     * Add charge
			     */
			    entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesEntityVO().setCHARGE_CODE(schemaCodeList.get(i));
			    entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesEntityVO().setAMOUNT(entityChargesCO.getCvAmount());
			    entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesEntityVO().setAMOUNT_FC(entityChargesCO.getFcAmount());
			    entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesEntityVO().setAMOUNT_ORIGINAL(entityChargesCO.getCvAmount());
			    entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesEntityVO().setAMOUNT_ORIGINAL_FC(entityChargesCO.getFcAmount());
			    entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesVO().setALLOW_MODIFY(entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesVO().getALLOW_MODIFY());
			    entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesVO().setALLOW_CLEARING(entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesVO().getALLOW_CLEARING());

			    /*
			     * Set Entity Count
			     */
			    entityChargesCO.getCtsChargesEntityCOs().get(objectcount).setEntityCount(retrieveEntityCount(entityChargesCO));

			    /*
			     * Set the TYPE_IND for the row
			     */
			    entityChargesCO = fillTypeInd(entityChargesCO);

			    /*
			     * Fill The Charge Description
			     */
			    if(entityChargesCO.getLoginPreferrredLanguage() == null || entityChargesCO.getLoginPreferrredLanguage().equals(ConstantsCommon.PREFERED_LANG_LATIN))
			    {
				entityChargesCO.getCtsChargesEntityCOs().get(objectcount).setChargeDesc(entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesVO().getBRIEF_NAME_ENG());
			    }
			    else
			    {
				entityChargesCO.getCtsChargesEntityCOs().get(objectcount).setChargeDesc(entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesVO().getBRIEF_NAME_ARAB());
			    }

			    /*
			     * VAT
			     */
			    entityChargesCO.setDeductBr(NumberUtil.emptyDecimalToZero(entityChargesCO.getCtsChargesEntityCOs().get(objectcount).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_BR()));//BURJ140135
				   
			    entityChargesCO = retrieveVatChargesDetails(entityChargesCO);

			    objectcount++;
			}

		    }

		    /*
		     * Set Total Amounts
		     */
		    entityChargesCO = retrieveTotalCharges(entityChargesCO);

		}
	    }
	}

	return entityChargesCO;
    }

    /**
     * Calculates VAT details
     * 
     * 
     * @param EntityChargesCO
     * @return EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO retrieveVatChargesDetails(EntityChargesCO entityChargesCO) throws BaseException
    {

	TrxMgntSC trxMgntSC = new TrxMgntSC();
	int row = entityChargesCO.getRow().intValue();
	
	// Hasan Bug#410189 14/06/2016
	String exemptedFromVat = null;
	AMF_EXTENDEDVO amfExtendedVO = new AMF_EXTENDEDVO();
	amfExtendedVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	amfExtendedVO.setBRANCH_CODE(NumberUtil.emptyDecimalToNull(entityChargesCO.getAccBranch()));
	amfExtendedVO.setCURRENCY_CODE(NumberUtil.emptyDecimalToNull(entityChargesCO.getAccCurrency()));
	amfExtendedVO.setGL_CODE(NumberUtil.emptyDecimalToNull(entityChargesCO.getAccGL()));
	amfExtendedVO.setCIF_SUB_NO(NumberUtil.emptyDecimalToNull(entityChargesCO.getAccCIF()));
	amfExtendedVO.setSL_NO(NumberUtil.emptyDecimalToNull(entityChargesCO.getAccSL()));
	if(amfExtendedVO.getCIF_SUB_NO() == null)
	{
	    exemptedFromVat = "0";
	}
	else
	{
	    if(amfExtendedVO.getBRANCH_CODE() == null || amfExtendedVO.getBRANCH_CODE().equals(BigDecimal.ZERO)
		    || amfExtendedVO.getCURRENCY_CODE() == null
		    || amfExtendedVO.getCURRENCY_CODE().equals(BigDecimal.ZERO) || amfExtendedVO.getGL_CODE() == null
		    || amfExtendedVO.getGL_CODE().equals(BigDecimal.ZERO) || amfExtendedVO.getSL_NO() == null)
	    {
		CIF_EXTENDEDVO cifExtended = new CIF_EXTENDEDVO();
		cifExtended.setCOMP_CODE(entityChargesCO.getLoginCompCode());
		cifExtended.setCIF_NO(amfExtendedVO.getCIF_SUB_NO());
		cifExtended = (CIF_EXTENDEDVO) genericDAO.selectByPK(cifExtended);
		if(cifExtended == null)
		{
		    cifExtended = new CIF_EXTENDEDVO();
		}
		exemptedFromVat = cifExtended.getEXEMPTED_FROM_VAT_YN();
	    }
	    else
	    {
		amfExtendedVO = (AMF_EXTENDEDVO) genericDAO.selectByPK(amfExtendedVO);
		if(amfExtendedVO == null)
		{
		    amfExtendedVO = new AMF_EXTENDEDVO();
		}
		exemptedFromVat = amfExtendedVO.getEXEMPTED_FROM_VAT_YN();
	    }
	}

	if(entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesVO().getAPPLY_TVA() != null
		&& entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesVO().getAPPLY_TVA().equals(EntityChargesConstant.VALUE_ONE)
		&& StringUtil.nullEmptyToValue(exemptedFromVat,"0").equals("0"))
	{

	    /*
	     * Retrieve VAT details
	     */
	    trxMgntSC.setCompCode(entityChargesCO.getLoginCompCode());
	    trxMgntSC.setBranchCode(entityChargesCO.getLoginBraCode());
	    trxMgntSC.setTrsNo(BigDecimal.ZERO);
	    trxMgntSC.setCode(entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesVO().getVAT_CODE());
	    if(entityChargesCO.getChargeAccBranch() == null)
		{trxMgntSC.setTrsAcBr(BigDecimal.ZERO);}
	    else
		{trxMgntSC.setTrsAcBr(entityChargesCO.getChargeAccBranch());}

	    if(entityChargesCO.getChargeAccCurrency() == null)
		{trxMgntSC.setTrsAcCy(BigDecimal.ZERO);}
	    else
		{trxMgntSC.setTrsAcCy(entityChargesCO.getChargeAccCurrency());}
	    
	    trxMgntSC.setExchRate(entityChargesCO.getExchRate());
	    
	    /*
	     * Set Amounts with Scaling to 3 to prevent Overflow
	     */
	    trxMgntSC.setTotalCVcharge(entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesEntityVO().getAMOUNT().setScale(3,BigDecimal.ROUND_HALF_UP));
	    trxMgntSC.setTotalFCcharge(entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesEntityVO().getAMOUNT_FC().setScale(3,BigDecimal.ROUND_HALF_UP));
	    
	    trxMgntSC.setCurrency(entityChargesCO.getChargeAccCurrency());
	    
	    if(entityChargesCO.getTrxType() == null)
	    {
		trxMgntSC.setTrxType(BigDecimal.ZERO);
	    }
	    else
	    {
		trxMgntSC.setTrxType(entityChargesCO.getTrxType());
	    }
	    
	    trxMgntSC.setSystemDate(entityChargesCO.getRunningDate());
	    trxMgntSC.setType(EntityChargesConstant.CHARGE_DETAIL_CHARGE);

	    trxMgntSC.setDeductBr(entityChargesCO.getDeductBr());
	    trxMgntSC = retrieveVATDetails(trxMgntSC);

	    /*
	     * Set VAT Values
	     */	    
	    entityChargesCO.getCtsChargesEntityCOs().get(row).getVatCtsChargesEntityVO().setAMOUNT(trxMgntSC.getVatCVAmount());
	    entityChargesCO.getCtsChargesEntityCOs().get(row).getVatCtsChargesEntityVO().setAMOUNT_FC(trxMgntSC.getVatFCAmount());

	}

	/*
	 * In case of empty set to null so as not to count in total
	 */
	entityChargesCO.getCtsChargesEntityCOs().get(row).getVatCtsChargesEntityVO().setAMOUNT(NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(row).getVatCtsChargesEntityVO().getAMOUNT()));
	entityChargesCO.getCtsChargesEntityCOs().get(row).getVatCtsChargesEntityVO().setAMOUNT_FC(NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(row).getVatCtsChargesEntityVO().getAMOUNT_FC()));
	//IIAB100357 - hold the original amount upon retrieving the grid data
	entityChargesCO.getCtsChargesEntityCOs().get(row).getVatCtsChargesEntityVO().setAMOUNT_ORIGINAL(NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(row).getVatCtsChargesEntityVO().getAMOUNT()));
	entityChargesCO.getCtsChargesEntityCOs().get(row).getVatCtsChargesEntityVO().setAMOUNT_ORIGINAL_FC(NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(row).getVatCtsChargesEntityVO().getAMOUNT_FC()));
	
	return entityChargesCO;
    }

    /**
     * Fills the TYPE_IND field according to the criteria
     * 
     * 
     * @param EntityChargesCO
     * @return EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO fillTypeInd(EntityChargesCO entityChargesCO) throws BaseException
    {
	if(entityChargesCO.getCtsChargesEntityCOs() != null && !entityChargesCO.getCtsChargesEntityCOs().isEmpty())
	{
	    if(entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK)   && entityChargesCO.getEntityType().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK))
	    {
		/*
		 * Chequebook
		 */
		if(entityChargesCO.getCrud().equals(CoreCommonConstants.CHEQUEBOOK_CRUD_APPROVE_DESTROY)
			|| entityChargesCO.getCrud().equals("BTD")
			|| entityChargesCO.getCrud().equals(CoreCommonConstants.CHEQUEBOOK_CRUD_TO_DESTROY)
			|| entityChargesCO.getCrud().equals("BAD"))
		{
		    entityChargesCO.getCtsChargesEntityCOs().get(entityChargesCO.getRow().intValue())
			    .getCtsChargesEntityVO()
			    .setTYPE_IND(EntityChargesConstant.TYPEIND_CHEQUEBOOK_APPROVE_DESTROY);
		}
		else if(entityChargesCO.getCrud().equals(CoreCommonConstants.CHEQUEBOOK_CRUD_APPROVE_CANCEL)
			|| entityChargesCO.getCrud().equals(CoreCommonConstants.CHEQUEBOOK_CRUD_TO_CANCEL))
		{
		    entityChargesCO.getCtsChargesEntityCOs().get(entityChargesCO.getRow().intValue())
			    .getCtsChargesEntityVO()
			    .setTYPE_IND(EntityChargesConstant.TYPEIND_CHEQUEBOOK_APPROVE_CANCEL);
		}
		// Hasan Bug#571036 03/10/2017
		else if(entityChargesCO.getCrud().equals(CoreCommonConstants.CHEQUEBOOK_CRUD_SUBMIT)
			|| entityChargesCO.getCrud().equals(CoreCommonConstants.CHEQUEBOOK_CRUD_APPLY_TO_SUBMIT))
		{
		    entityChargesCO.getCtsChargesEntityCOs().get(entityChargesCO.getRow().intValue())
			    .getCtsChargesEntityVO().setTYPE_IND(EntityChargesConstant.TYPEIND_CHEQUEBOOK_SUBMIT);
		}
		else
		{
		 // modified by nancy -- 12/04/2018--FIBSI170009-Integration with chequebook printer and provider
		    for(int i = 0; i < entityChargesCO.getCtsChargesEntityCOs().size(); i++)
			{
			    if(entityChargesCO.getCtsChargesEntityCOs().get(entityChargesCO.getRow().intValue()).getActionType() != null && "H".equals(entityChargesCO.getCtsChargesEntityCOs().get(i).getActionType()))
			    {
				entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO()
					.setTYPE_IND(EntityChargesConstant.TYPEIND_IN_HOUSE_CHARGES);
			    }
			    else
			    {
				entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO()
					.setTYPE_IND(EntityChargesConstant.TYPEIND_CHEQUEBOOK_CREATE);
			    }
			}
		    // end nancy
		}

	    }
	    else if(entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK)
		    && entityChargesCO.getEntityType().equals(EntityChargesConstant.ENTITY_PASSBOOK))
	    {
		/*
		 * Passbook
		 */
		entityChargesCO.getCtsChargesEntityCOs().get(entityChargesCO.getRow().intValue())
			.getCtsChargesEntityVO().setTYPE_IND(EntityChargesConstant.TYPEIND_PASSBOOK);

	    }
	    else if(entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK)
		    && entityChargesCO.getEntityType().equals(EntityChargesConstant.ENTITY_SAFEBOX))
	    {
		/*
		 * Safebox
		 */
		entityChargesCO.getCtsChargesEntityCOs().get(entityChargesCO.getRow().intValue())
			.getCtsChargesEntityVO().setTYPE_IND(entityChargesCO.getChargeType());

	    }
	    else if(entityChargesCO.getEntityType().equals(EntityChargesConstant.ENTITY_LOSTFOUND))
	    {
		for(int i = 0; i < entityChargesCO.getCtsChargesEntityCOs().size(); i++)
		{
		    if("REA".equals(entityChargesCO.getCtsChargesEntityCOs().get(i).getActionType()))
		    {
			entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO()
				.setTYPE_IND(EntityChargesConstant.TYPEIND_LOSTFOUND_REASON);
		    }
		    else
		    {
			entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO()
				.setTYPE_IND(EntityChargesConstant.TYPEIND_ALL_DEFAULT);
		    }
		}
	    }
	    else
	    {
		/*
		 * Default Value for the rest
		 */
		entityChargesCO.getCtsChargesEntityCOs().get(entityChargesCO.getRow().intValue())
			.getCtsChargesEntityVO().setTYPE_IND(EntityChargesConstant.TYPEIND_ALL_DEFAULT);
	    }

	}
	return entityChargesCO;
    }

    /**
     * Calculates the Total Charges and Total All Charges and sets their format
     * 
     * Sets them in 
     * entityChargesCO.setTotalAmount()
     * entityChargesCO.setTotalAmountFc()
     * entityChargesCO.setTotalAllAmount()
     * entityChargesCO.setTotalAllAmountFc()
     * 
     * 
     * @param EntityChargesCO
     * @return EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO retrieveTotalCharges(EntityChargesCO entityChargesCO) throws BaseException
    {
	BigDecimal total = BigDecimal.ZERO;
	BigDecimal totalFc = BigDecimal.ZERO;
	BigDecimal totalAll = BigDecimal.ZERO;
	BigDecimal totalAllFc = BigDecimal.ZERO;
	BigDecimal amount, amountFC, entityCount;
	

	for(int i = 0; i < entityChargesCO.getCtsChargesEntityCOs().size(); i++)
	{
	    /*
	     * Add Normal Charge Amounts to Total
	     */
	    total = total.add(NumberUtil.emptyDecimalToZero(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT()));
	    totalFc = totalFc.add(NumberUtil.emptyDecimalToZero(entityChargesCO.getCtsChargesEntityCOs().get(i)
		    .getCtsChargesEntityVO().getAMOUNT_FC()));

	    /*
	     * Add VAT amounts to Total
	     */
	    if(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO() != null)
	    {
		total = total.add(NumberUtil.emptyDecimalToZero(entityChargesCO.getCtsChargesEntityCOs().get(i)
			.getVatCtsChargesEntityVO().getAMOUNT()));
		totalFc = totalFc.add(NumberUtil.emptyDecimalToZero(entityChargesCO.getCtsChargesEntityCOs().get(i)
			.getVatCtsChargesEntityVO().getAMOUNT_FC()));
	    }

	    if(entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK) && entityChargesCO.getEntityType().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK))
	    {
		/*
		 * Set Entity Count and Amounts
		 */
		entityCount = entityChargesCO.getCtsChargesEntityCOs().get(i).getEntityCount();
		amount = entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT();
		amountFC = entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT_FC();
		   
		/*
		 * Calculate Totals
		 */

		    totalAll = totalAll.add(NumberUtil.emptyDecimalToZero(amount).multiply(entityCount));
		    totalAllFc = totalAllFc.add(NumberUtil.emptyDecimalToZero(amountFC).multiply(entityCount));

		    /*
		     * Add VAT amounts to Totals
		     */
		    if(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO() != null)
		    {
			amount = entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT();
		    amountFC = entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC();

			totalAll = totalAll.add(NumberUtil.emptyDecimalToZero(amount).multiply(entityCount));
			totalAllFc = totalAllFc.add(NumberUtil.emptyDecimalToZero(amountFC).multiply(entityCount));
		    }
    		
	    }
	}
	

	entityChargesCO.setTotalAmount(total);
	entityChargesCO.setTotalAmountFc(totalFc);

	/*
	 * For Chequebook and Lost & Found we have possibility of multiple records
	 */
	if(entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK) && entityChargesCO.getEntityType().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK))
	{
	    entityChargesCO.setTotalAllAmount(totalAll);
	    entityChargesCO.setTotalAllAmountFc(totalAllFc);
	}
	else
	{
	    entityChargesCO.setTotalAllAmount(total);
	    entityChargesCO.setTotalAllAmountFc(totalFc);
	}

	return entityChargesCO;

    }

    /**
     * Sets the Charge Branch and Currency to be used
     * 
     * Fills them in entityChargesCO.setChargeAccBranch() and
     * entityChargesCO.setChargeAccCurrency()
     * 
     * @param EntityChargesCO
     * 		entityChargesCO.getDeductCharges()		Deduct Charges By (if exists)
     * 		entityChargesCO.getEntityCommand()
     * 		entityChargesCO.getTrsAccounDetBranch()		
     * 		entityChargesCO.getAccCurrency()
     * 		entityChargesCO.getAccBranch()
     * 		entityChargesCO.getLoginCompCode()		For Cards
     * 		entityChargesCO.getCardType()			For Cards
     * 		entityChargesCO.getBaseCurrencyCode()		For Cards
     * 
     * 
     * @return EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO setChargeAcc(EntityChargesCO entityChargesCO) throws BaseException
    {

	/*
	 * If Deduct Charges Exist, then get Branch and Currency based on it,
	 * else get them from main account
	 */

	if(entityChargesCO.getDeductCharges() == null || EntityChargesConstant.VALUE_EMPTY.equals(entityChargesCO.getDeductCharges().trim()))
	{
	    entityChargesCO.setDeductCharges(EntityChargesConstant.VALUE_ZERO);
	}
	
	if(EntityChargesConstant.ENTITY_COMMAND_ACC.equals(entityChargesCO.getEntityCommand()) ||
		EntityChargesConstant.ENTITY_COMMAND_USO.equals(entityChargesCO.getEntityCommand()) ||
		EntityChargesConstant.ENTITY_COMMAND_EXCH.equals(entityChargesCO.getEntityCommand()))
	{
	    entityChargesCO.setChargeAccBranch(entityChargesCO.getTrsAccounDetBranch());
	    entityChargesCO.setChargeAccCurrency(entityChargesCO.getAccCurrency());
	}
	else if(EntityChargesConstant.ENTITY_COMMAND_CAR.equals(entityChargesCO.getEntityCommand()) && entityChargesCO.getCardType() != null)
	{
	    /*
	     * Cards have a special way to get the charge account
	     */
	    entityChargesCO.setChargeAccBranch(entityChargesCO.getAccBranch());
	    entityChargesCO.setChargeAccCurrency(cardsCurrency(entityChargesCO));

	}
	else if(!entityChargesCO.getDeductCharges().equals(EntityChargesConstant.CHARGES_DEDUCT_BY_ACCOUNT))
	{
	    /*
	     * If the Deduct From flag is set to Deduct From Main Account, or if
	     * it doesnt exist
	     */
	    
	    /*
	     * In case of multi-transaction(transaction screen), if the selected account's branch exist then use it
	     */
	    if(entityChargesCO.getTrsAccounDetBranch() != null
		&& entityChargesCO.getTrsAccounDetBranch().intValue() > 0)
	    {
		entityChargesCO.setChargeAccBranch(entityChargesCO.getTrsAccounDetBranch());
	    }
	    else
	    {
		entityChargesCO.setChargeAccBranch(entityChargesCO.getAccBranch());
	    }
	    entityChargesCO.setChargeAccCurrency(entityChargesCO.getAccCurrency());
	}

	if(NumberUtil.emptyDecimalToNull(entityChargesCO.getChargeAccBranch()) == null || NumberUtil.emptyDecimalToNull(entityChargesCO.getChargeAccCurrency()) == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_ACCOUNT);
	}

	return entityChargesCO;
    }

    /**
     * This function sets the schema type to be used, in case of Chequebook. If
     * the Chequebook is being Cancelled or Destroyed then the corresponding
     * Schema is chosen.
     * 
     * All schemas are set in entityChargesCO.setSchema()
     * 
     * @param EntityChargesCO
     * @return EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO setChargeSchema(EntityChargesCO entityChargesCO) throws BaseException
    {

	if(entityChargesCO.getEntityCommand().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK)
		&& entityChargesCO.getEntityType().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK))
	{
	    /*
	     * In Case of Chequebook
	     */
	    if(entityChargesCO.getCrud().equals(CoreCommonConstants.CHEQUEBOOK_CRUD_APPROVE_DESTROY)
		    || entityChargesCO.getCrud().equals(CoreCommonConstants.CHEQUEBOOK_CRUD_TO_DESTROY))
	    {
		/*
		 * Destroy
		 */
		if(entityChargesCO.getSchemaDestroy() != null)
		{
		    entityChargesCO.setSchema(entityChargesCO.getSchemaDestroy());
		}
	    }
	    else if(entityChargesCO.getCrud().equals(CoreCommonConstants.CHEQUEBOOK_CRUD_APPROVE_CANCEL)
		    || entityChargesCO.getCrud().equals(CoreCommonConstants.CHEQUEBOOK_CRUD_TO_CANCEL)

		    /*
		     * Cancel
		     */
		    && entityChargesCO.getSchemaCancel() != null)
	    {
		entityChargesCO.setSchema(entityChargesCO.getSchemaCancel());
	    }
	}

	return entityChargesCO;
    }

    /**
     * This function gets a list of charges that will be used to populate the
     * charges grid
     * calls entityChargesDAO.getChargesSchema()
     * 
     * @param trxChargesCO
     * @return List<BigDecimal>
     * @throws BaseException
     */
    public List<BigDecimal> selectChargesSchemaList(EntityChargesCO entityChargesCO) throws BaseException
    {
	return entityChargesDAO.retrieveChargesSchema(entityChargesCO);
    }

    /**
     * This function gets a count of charges related to certain criteria
     * 
     * @param trxChargesCO
     * @return BigDecimal
     * @throws BaseException
     */
    public BigDecimal returnCountCharges(EntityChargesCO entityChargesCO) throws BaseException
    {
	return entityChargesDAO.returnCountCharges(entityChargesCO);
    }

    /**
     * This function gets a count of charges related to certain criteria
     * 
     * @param EntityChargesCO entityChargesCO, BigDecimal chargeCode
     * @return Boolean true for is exempted (charge shouldnt be read), false for
     *         not exempted (proceed on charge)
     * @throws BaseException
     */
    public Boolean checkExemptedCharges(EntityChargesCO entityChargesCO, BigDecimal chargeCode) throws BaseException
    {

	CTSCHARGES_EXEMPTED_BRANCHVO chargeExemptedVO = new CTSCHARGES_EXEMPTED_BRANCHVO();
	CTSCHARGES_EXEMPTED_BRANCHVO chargeExemptedLocalVO = new CTSCHARGES_EXEMPTED_BRANCHVO();
	Boolean isExempted = true;

	/*
	 * Get Exempted Charges for login branch
	 */
	chargeExemptedVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	chargeExemptedVO.setBRANCH_CODE(entityChargesCO.getLoginBraCode());
	chargeExemptedVO.setCHARGE_CODE(chargeCode);

	chargeExemptedVO = (CTSCHARGES_EXEMPTED_BRANCHVO) genericDAO.selectByPK(chargeExemptedVO);
	if(chargeExemptedVO == null)
	    {chargeExemptedVO = new CTSCHARGES_EXEMPTED_BRANCHVO();}
	if(chargeExemptedVO.getTRX_BR() == null)
	    {chargeExemptedVO.setTRX_BR(BigDecimal.ZERO);}

	/*
	 * Get Exempted Charges for charge branch
	 */
	if(!EntityChargesConstant.ENTITY_EXCHANGE.equals(entityChargesCO.getEntityType()))
	{	
	    if(entityChargesCO.getChargeAccBranch() != null && entityChargesCO.getChargeAccBranch().intValue() > 0)
	    {
		chargeExemptedLocalVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
		chargeExemptedLocalVO.setBRANCH_CODE(entityChargesCO.getChargeAccBranch());
		chargeExemptedLocalVO.setCHARGE_CODE(chargeCode);

		chargeExemptedLocalVO = (CTSCHARGES_EXEMPTED_BRANCHVO) genericDAO.selectByPK(chargeExemptedLocalVO);
	    }

	    if(chargeExemptedLocalVO == null)
		{chargeExemptedLocalVO = new CTSCHARGES_EXEMPTED_BRANCHVO();}
	}
	
	if(chargeExemptedLocalVO.getACC_BR() == null)
	    {chargeExemptedLocalVO.setACC_BR(BigDecimal.ZERO);}

	if(chargeExemptedLocalVO.getACC_BR().intValue() == 0 && chargeExemptedVO.getTRX_BR().intValue() == 0)
	{
	    isExempted = false;
	}

	return isExempted;
    }

    /**
     * This function gets the exchange rate and returns it
     * 
     * @param EntityChargesCO
     * 		entityChargesCO.getLoginCompCode()
     * 		entityChargesCO.getChargeAccCurrency()
     * 		entityChargesCO.getBaseCurrencyCode()
     * 		entityChargesCO.getRunningDate()
     * 		entityChargesCO.getPthCTRL()
     * 
     * 
     * 
     * @return BigDecimal
     * @throws BaseException
     */
    public BigDecimal retrieveExchRate(EntityChargesCO entityChargesCO) throws BaseException
    {
	TransferCashSC transferCashSC = new TransferCashSC();
	transferCashSC.setCompCode(entityChargesCO.getLoginCompCode());
	transferCashSC.setCurrencyCode(entityChargesCO.getChargeAccCurrency());
	transferCashSC.setBaseCurrencyCode(entityChargesCO.getBaseCurrencyCode());
	transferCashSC.setRunningDate(entityChargesCO.getRunningDate());
	transferCashSC.setAlBranchCode(BigDecimal.ZERO);
	transferCashSC.setAlCif(BigDecimal.ZERO);

	if(StringUtil.nullToEmpty(entityChargesCO.getPthCTRL().getCHARGES_BOOKING()).equals(EntityChargesConstant.CHARGES_BOOKING_A))
	{
	    /*
	     * Middle Rate
	     */
	    transferCashSC.setA_sb(EntityChargesConstant.RATE_MIDDLE_RATE);
	}
	else
	{
	    /*
	     * Transfer Buy Rate
	     */
	    transferCashSC.setA_sb(EntityChargesConstant.RATE_TRANSFER_BUY_RATE);
	}

	transferCashSC = coreCommonProcedureBO.getExChRate(transferCashSC);

	if(transferCashSC.getOdecRate() == null || transferCashSC.getOdecRate().doubleValue() == 0)
	{
	    throw new BOException(MessageCodes.FOREIGN_EXCHANGE_RATE_NOT_DEFINED);
	}

	return transferCashSC.getOdecRate();
    }

    /**
     * This function gets the charge information from table CTSCHARGES, using
     * the company code and charge code as input parameters
     * 
     * @param BigDecimal compCode, BigDecimal chargeCode
     * @return CTSCHARGESVO
     * @throws BaseException
     */
    public CTSCHARGESVO retrieveChargesInfo(BigDecimal compCode, BigDecimal chargeCode) throws BaseException
    {
	CTSCHARGESVO ctsChargesVO = new CTSCHARGESVO();

	ctsChargesVO.setCOMP_CODE(compCode);
	ctsChargesVO.setCODE(chargeCode);

	ctsChargesVO = (CTSCHARGESVO) genericDAO.selectByPK(ctsChargesVO);

	if(ctsChargesVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CHARGE_CODE);
	}

	/*
	 * Set Default Values
	 */
	if(ctsChargesVO.getALLOW_MODIFY() == null)
	{
	    ctsChargesVO.setALLOW_MODIFY(EntityChargesConstant.VALUE_ZERO);
	}
	if(ctsChargesVO.getALLOW_CLEARING() == null)
	{
	    ctsChargesVO.setALLOW_CLEARING(EntityChargesConstant.VALUE_ZERO);
	}
	if(ctsChargesVO.getAPPLY_TVA() == null)
	{
	    ctsChargesVO.setAPPLY_TVA(EntityChargesConstant.VALUE_ZERO);
	}
	if(ctsChargesVO.getFIX_CHARGES() == null)
	{
	    ctsChargesVO.setFIX_CHARGES(EntityChargesConstant.VALUE_ZERO);
	}

	return ctsChargesVO;
    }

    /**
     * This function gets the charge information by running procedure
     * P_RET_GET_CHARGES_DETAILS
     * 
     * @param TrxMgntChargesSC
     * 
     * 
     * trxMgntChargesSC.setCompCode() 		Company Code, usually Logged in Company Code 
     * trxMgntChargesSC.setBranchCode() 	Branch Code, usually Logged in Branch Code 
     * trxMgntChargesSC.setChargeCode()         Charge Code 
     * trxMgntChargesSC.setChargeCy() 		Charge Currency
     * trxMgntChargesSC.setChargesBooking() 	CHARGES_BOOKING from PTH_CTRL 
     * trxMgntChargesSC.setBranchBooking() 	Charge Branch
     * trxMgntChargesSC.setExchangeRate() 	Exchange Rate
     * trxMgntChargesSC.setTrxAmount() 		Transaction Amount in case  Type = 'T', else 0 
     * trxMgntChargesSC.setTrxType() 		Transaction Type in case Type = 'T', else 0 
     * trxMgntChargesSC.setType() 		'T' when Transaction, 'C' when Charge 
     * trxMgntChargesSC.setDate()            	Date, usually Running Date 
     * trxMgntChargesSC.setTrsCy()            	Transaction Currency in case Type = 'T', else TrsCy = ChargeCy
     * trxMgntChargesSC.setSuppressMessage()	Set to True so no Exception is generated, False to proceed normally
     * @return TrxMgntChargesSC
     * @throws BaseException
     */
    public TrxMgntChargesSC retrieveChargesDetails(TrxMgntChargesSC trxMgntChargesSC1) throws BaseException
    {
	TrxMgntChargesSC trxMgntChargesSC = trxMgntChargesSC1;
	trxMgntChargesSC = coreCommonProcedureBO.getChargesDetails(trxMgntChargesSC);

	if(trxMgntChargesSC.getError() != null && trxMgntChargesSC.getError().intValue() < 0 
		&& !trxMgntChargesSC.getSuppressMessage())
	{
	    throw new BOException(trxMgntChargesSC.getErrorMessage());
	}

	return trxMgntChargesSC;
    }
    

    /**
     * This function gets the VAT charge information by running procedure
     * P_RET_GET_TVA_DETAILS
     * 
     * @param TrxMgntChargesSC
     * 	    
     * 
     * trxMgntSC.setCompCode() 			Company Code, usually Logged in Company Code 
     * trxMgntSC.setBranchCode() 		Branch Code, usually Logged in Branch Code 
     * trxMgntSC.setTrsNo()			Not needed, fill as 0
     * trxMgntSC.setCode()			VAT Charge Code
     * trxMgntSC.setTrsAcBr()			Charge Branch
     * trxMgntSC.setTrsAcCy()			Charge Currency
     * trxMgntSC.setExchRate()			Exchange Rate
     * trxMgntSC.setTotalCVcharge()		Charge CV Amount
     * trxMgntSC.setTotalFCcharge()		Charge FC Amount
     * trxMgntSC.setCurrency()			Currency of Deduct From Account
     * trxMgntSC.setTrxType()			Transaction Type in case Type = 'T', else 0 
     * trxMgntSC.setSystemDate()		Running Date
     * trxMgntSC.setType()			'T' when Transaction, 'C' when Charge 
     * 
     * @return TrxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC retrieveVATDetails(TrxMgntSC trxMgntSC1) throws BaseException
    {
	TrxMgntSC trxMgntSC = trxMgntSC1;
	trxMgntSC.setTrxType(NumberUtil.emptyDecimalToNull(trxMgntSC.getTrxType()));

	trxMgntSC = coreCommonProcedureBO.getTVADetails(trxMgntSC);

	if(trxMgntSC.getErrorCode() != null && trxMgntSC.getErrorCode().intValue() < 0)
	{
//	    throw new BOException(MessageCodes.API_FAILED, new String[] {trxMgntSC.getErrorCode().setScale(0)
//		    .toString() + " - " + trxMgntSC.getErrorMessage() });
	    
	    if(trxMgntSC.getVatCVAmount() == null)
		{trxMgntSC.setVatCVAmount(BigDecimal.ZERO);}

	    if(trxMgntSC.getVatFCAmount() == null)
		{trxMgntSC.setVatFCAmount(BigDecimal.ZERO);}
	}
	

	    
	return trxMgntSC;
    }

    /**
     * This Function returns the Entity Count to know the number of entities
     * 
     * @param BigDecimal compCode, BigDecimal chargeCode
     * @return CTSCHARGESVO
     * @throws BaseException
     */
    public BigDecimal retrieveEntityCount(EntityChargesCO entityChargesCO) throws BaseException
    {
	BigDecimal count = BigDecimal.ONE;
	int row = entityChargesCO.getRow().intValue();
	
	  /*
	     * Chequebook or Lost and Found
	     */
	if((entityChargesCO.getEntityType().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK) || entityChargesCO
		.getEntityType().equals(EntityChargesConstant.ENTITY_LOSTFOUND))
		&& entityChargesCO.getCtsChargesEntityCOs().get(row).getCtsChargesVO().getFIX_CHARGES().equals(
			EntityChargesConstant.VALUE_ZERO))
	{
	    count = entityChargesCO.getNumOfEntities();
	}
	
	return count;
	
     }
    
    /**
     * This Function retrieves a list of charges and their corresponding VAT charges
     * 
     * @param entityChargesCO
     * 			loginPreferrredLanguage
     * 			loginCompCode
     * 			loginBraCode
     * 			typeInd
     * 			entityType
     * 			entityCode
     * @return List<CtsChargesEntityCO>
     * @throws BaseException
     */
    public List<CtsChargesEntityCO> retrieveCtsChargesEntityCOList(EntityChargesCO entityChargesCO)
	    throws BaseException
    {
	if("REQ".equals(entityChargesCO.getEntityType()))
	{
	    List<CtsChargesEntityCO> lst = entityChargesDAO.retrieveReqChargesEntityCOList(entityChargesCO);
	    if(lst != null && !lst.isEmpty())
	    {

		TrxMgntChargesSC trxMgntChargesSC = new TrxMgntChargesSC();

		PathPropertyUtil.copyProperties(entityChargesCO, trxMgntChargesSC, "loginCompCode compCode",
			"loginBraCode branchCode", "type entityCode");
		trxMgntChargesSC.setProductName(EntityChargesConstant.INSTRUCTIONS_REQUEST);
		trxMgntChargesSC.setEntityCode(entityChargesCO.getEntityTypeCode());
		trxMgntChargesSC.setTrsAcCif(entityChargesCO.getChargeAccCIF());// applicant
		
		trxMgntChargesSC.setUserId(entityChargesCO.getLoginUserId());
		trxMgntChargesSC.setRequestDate(entityChargesCO.getRunningDate());
		
										// cif
		CIFVO cifVO = new CIFVO();
		cifVO.setCIF_NO(entityChargesCO.getChargeAccCIF());
		cifVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
		cifVO = (CIFVO) genericDAO.selectByPK(cifVO);
		if(cifVO != null)
		{
		    trxMgntChargesSC.setEntityTypeCode(cifVO.getCIF_TYPE());// CIF_TYPE
		}
		// cal the proc P_RET_GET_PRODUCT_CHARGES, to get the schema
		coreCommonProcedureBO.returnProductCharges(trxMgntChargesSC);
		if(NumberUtil.nullToZero(trxMgntChargesSC.getError()).compareTo(BigDecimal.ZERO) < 0)
		{
		    // in some exception we may get empty message, to avoid this
		    // i throw the errorCode
		    if(trxMgntChargesSC.getErrorMessage() == null)
		    {
			double error = Math.abs(Math.round(NumberUtil.toDouble(trxMgntChargesSC.getError())));
			throw new BOException((int) error);
		    }
		    else
		    {
			throw new BOException(trxMgntChargesSC.getErrorMessage());
		    }
		}
		// fill the schema at least for first record, because it is the
		// same for all, and in js we are selecting only the first
		if(!NumberUtil.isEmptyDecimal(trxMgntChargesSC.getSchema()))
		{
		    lst.get(0).getCtsChargesEntityVO().setSCHEMA_CODE(trxMgntChargesSC.getSchema().setScale(0));
		}
	    }
	    return lst;
	}
	else
	{
	    return entityChargesDAO.retrieveCtsChargesEntityCOList(entityChargesCO);
	}
    }
    
    
    /**
     * This Function deletes the entity charges from the database
     * 
     * @param EntityChargesCO
     * 			loginCompCode			Company Code
     * 			loginBraCode			Branch Code
     * 			entityType			Entity Type ('CHQ'/'CAR'/'SAF'/'LOS'/'PAS')
     * 			entityCode			Code of the Entity Record
     * 			typeInd				Optional (Type Indicator
     * 
     * @throws BaseException
     */    
    public void deleteEntityCharges(EntityChargesCO entityChargesCO) throws BaseException
    {
	entityChargesDAO.deleteEntityCharges(entityChargesCO);
    }
    
    /**
     * This calculates the foreign/base amount from its counterpart using the exchange rate
     * 
     * @param EntityChargesCO
     * 			exchRate()			Exchange Rate
     * 			loginCompCode()			Company Code
     * 			chargeAccCurrency()		Charge Account Currency
     * 			baseForeign()			'B' --> Base / 'F' --> Foreign
     * 			baseCurrencyCode()		Base Currency Code
     * 
     * 		amount					Amount
     * 
     * @return BigDecimal
     * 
     * @throws BaseException
     */
    public BigDecimal calculateExchangedAmount(EntityChargesCO entityChargesCO,BigDecimal amount) throws BaseException
    {
	if(BigDecimal.ZERO.equals(NumberUtil.nullToZero(entityChargesCO.getExchRate())))
	{
	    return BigDecimal.ZERO;
	}
	   
	CURRENCIESVO currenciesVO = new CURRENCIESVO();
	
	/*
	 * Retrieve FC Currency Details
	 */
	currenciesVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	currenciesVO.setCURRENCY_CODE(entityChargesCO.getChargeAccCurrency());
	currenciesVO = commonLibBO.returnCurrency(currenciesVO);
	
	if(currenciesVO == null)
	{ currenciesVO = new CURRENCIESVO();}
	if(currenciesVO.getMULT_DIV_IND() == null)
	{
	    currenciesVO.setMULT_DIV_IND(EntityChargesConstant.MULTDIV_MULT);
	}
	if(currenciesVO.getUNIT() == null || currenciesVO.getUNIT().intValue() == 0)
	{
	    currenciesVO.setUNIT(BigDecimal.ONE);
	}
	if(currenciesVO.getDECIMAL_POINTS() == null)
	{
	    currenciesVO.setDECIMAL_POINTS(BigDecimal.ZERO);
	}
	
	/*
	 * Retrieve CV Currency Details
	 */
	String multDiv;
	BigDecimal unit, decimalPoints;
	if(entityChargesCO.getBaseForeign().equals(EntityChargesConstant.BASE_CURRENCY))
	{
	    if(EntityChargesConstant.MULTDIV_MULT.equals(currenciesVO.getMULT_DIV_IND()))
	    {
		multDiv = EntityChargesConstant.MULTDIV_DIV;
	    }
	    else
	    {
		multDiv = EntityChargesConstant.MULTDIV_MULT;
	    }
	    
	    CURRENCIESVO baseCurrenciesVO = new CURRENCIESVO();
	    baseCurrenciesVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	    baseCurrenciesVO.setCURRENCY_CODE(entityChargesCO.getBaseCurrencyCode());
	    baseCurrenciesVO = commonLibBO.returnCurrency(baseCurrenciesVO);

	    if(baseCurrenciesVO == null)
	    {
		baseCurrenciesVO = new CURRENCIESVO();
	    }
	    if(baseCurrenciesVO.getUNIT() == null || baseCurrenciesVO.getUNIT().intValue() == 0)
	    {
		baseCurrenciesVO.setUNIT(BigDecimal.ONE);
	    }
	    if(baseCurrenciesVO.getDECIMAL_POINTS() == null)
	    {
		baseCurrenciesVO.setDECIMAL_POINTS(BigDecimal.ZERO);
	    }
	    
	    unit = baseCurrenciesVO.getUNIT();
	    decimalPoints = baseCurrenciesVO.getDECIMAL_POINTS();
	}
	else
	{
	    multDiv = currenciesVO.getMULT_DIV_IND();
	    unit = currenciesVO.getUNIT();
	    decimalPoints = currenciesVO.getDECIMAL_POINTS();
	}

	
	/*
	 * Calculate the FC/CV Amount and set that into amountFC
	 */
	return CommonMethods.multiplyDivideAmount(multDiv, amount,
		entityChargesCO.getExchRate(), unit, decimalPoints);
    }
    
    /**
     * This returns a count of charges in the charge schema that correspond to all Charges
     * 
     * @param EntityChargesSC
     * @return BigDecimal
     * 
     * @throws BaseException
     */
    public BigDecimal retrieveCountChargesSchema(EntityChargesSC entityChargesSC) throws BaseException
    {
	return entityChargesDAO.retrieveCountChargesSchema(entityChargesSC);
    }
    
    
    /**
     * This returns a count of charges in the charge schema that correspond to VAT Charges
     * 
     * @param EntityChargesSC
     * @return BigDecimal
     * 
     * @throws BaseException
     */
    public BigDecimal retrieveCountChargesSchemaVAT(EntityChargesSC entityChargesSC) throws BaseException
    {
	return entityChargesDAO.retrieveCountChargesSchemaVAT(entityChargesSC);
    }
    
    /**
     * This function returns the sum of AMOUNT_FC related to a specified entity
     * @param entityChargesSC
     * @return
     * @throws BaseException
     */
    public BigDecimal retrieveSumOfChargesAmountFc(EntityChargesCO entityChargesCO) throws BaseException
    {
	return entityChargesDAO.retrieveSumOfChargesAmountFc(entityChargesCO);
    }
    
    
    /**
     * Retrieves the sum of CV and FC Amounts of charges of a certain Entity
     * 
     * @author Reda Charabaty
     * @param entityChargesCO
     * 
     * @return EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO retrieveSumsOfChargesAmount(EntityChargesCO entityChargesCO) throws BaseException
    {
	return entityChargesDAO.retrieveSumsOfChargesAmount(entityChargesCO);
    }
    
    
    /**
     * This function is used to create Transaction from Charges
     * 
     * @author Reda Charabaty
     * @param 	trxMgntCO
     * 		entityChargesCO
     * 
     * @return BigDecimal Transaction Number
     * 
     * @throws BaseException
     */
    public TrxMgntSC openChargeTrx(TrxMgntCO trxMgntCO1, EntityChargesCO entityChargesCO) throws BaseException
    {
	
	/*
	 * JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659 in case of
	 * LOG_DUES_WITHOUT_TRX then we only insert Dues without creating any transaction
	 */
	 // TONY NOUH User Story#315732 AMANA130105 Overdraft Products
	 //contains instead of equals because LogDuesCreateTrx may contains other values from os_s_string
	if(entityChargesCO.getLogDuesCreateTrx() != null && entityChargesCO.getLogDuesCreateTrx().contains(TrxMgntConstant.LOG_DUES_WITHOUT_TRX))
	{
	    return logChargesAsDues(trxMgntCO1, entityChargesCO);
	}
	else
	{

	    TrxMgntCO trxMgntCO = trxMgntCO1;
	    
	    /*
	     * Get Transaction Type Details
	     */
	    CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO();
	    ctsTrxTypeVO.setCOMP_CODE(trxMgntCO.getCtstrsVO().getCOMP_CODE());
	    ctsTrxTypeVO.setCODE(trxMgntCO.getCtstrsVO().getTRX_TYPE());
	    ctsTrxTypeVO = coreCommonBO.findTrxType(ctsTrxTypeVO);

	    TrxMgntSC trxMgntSC = new TrxMgntSC();
	    trxMgntSC.setLangCode(entityChargesCO.getLanguage());

	    /*
	     * If not Debit Trx and not Safebox then dont proceed
	     */
	    if(!ctsTrxTypeVO.getCR_DR_FOREX().equals(TrxMgntConstant.MAIN_ACC_DR)
		    && !trxMgntCO.getReference().equals(EntityChargesConstant.TRXTYPE_SAFEBOX)
		    && !trxMgntCO.getReference().equals(EntityChargesConstant.REFERENCE_CLOSE_ACCOUNT)
		    && !trxMgntCO.getReference().equals(EntityChargesConstant.REFERENCE_CLOSE_ACCOUNT)
		    && !trxMgntCO.getReference().equals(EntityChargesConstant.REFERENCE_REACTIVATE_ACCOUNT))
	    {
		return trxMgntSC;
	    }

	    trxMgntCO.setCtstrxtypeVO(ctsTrxTypeVO);
	    trxMgntCO.setPthCtrlVO(commonLibBO.returnPthCtrl());

	    /*
	     * Set Transaction Currency based on Charges Booking
	     */
	    trxMgntCO.getCtstrsVO().setTRS_CY(returnTrsCurrency(trxMgntCO));

	    /*
	     * If not closing the account
	     */
	    if(!(EntityChargesConstant.REFERENCE_CLOSE_ACCOUNT.equals(trxMgntCO.getReference()) ||
	            (EntityChargesConstant.REFERENCE_REACTIVATE_ACCOUNT.equals(trxMgntCO.getReference())
	                && NumberUtil.isEmptyDecimal(trxMgntCO.getChargeSchema()))))
	    {
		/*
		 * Calculate the From and To Accounts
		 */
		trxMgntCO = calculateFromToAccounts(trxMgntCO, entityChargesCO);

		/*
		 * Calculate the Transaction Amounts
		 */
		trxMgntCO = calculateTransactionAmounts(trxMgntCO, entityChargesCO);

		

	    }

	    /*
		 * If Multi-Trx Transaction
		 */
		fillMultiTransferDetails(trxMgntCO, entityChargesCO);
	    /*
	     * In case of Chequebook or Lost & Found, check for multiple records
	     */
	    if(trxMgntCO.getReference().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK)
		    || trxMgntCO.getReference().equals(EntityChargesConstant.ENTITY_LOSTFOUND))
	    {
		if(trxMgntCO.getTrxChargesCO().getNumOfEntities() == null
			|| trxMgntCO.getTrxChargesCO().getNumOfEntities().equals(BigDecimal.ZERO))
		{
		    trxMgntCO.getTrxChargesCO().setNumOfEntities(BigDecimal.ONE);
		}

		/*
		 * If not Fixed Charges, then multiply charges by number of records
		 */
		if(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesVO().getFIX_CHARGES() == null
			|| entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesVO().getFIX_CHARGES().equals(ConstantsCommon.ZERO)
			|| trxMgntCO.getReference().equals(EntityChargesConstant.ENTITY_LOSTFOUND))
		{
		    trxMgntCO.getCtstrsVO().setAMOUNT(trxMgntCO.getCtstrsVO().getAMOUNT().multiply(trxMgntCO.getTrxChargesCO().getNumOfEntities()));
		    trxMgntCO.getCtstrsVO().setTRS_AC_AMOUNT(trxMgntCO.getCtstrsVO().getTRS_AC_AMOUNT().multiply(trxMgntCO.getTrxChargesCO().getNumOfEntities()));
		    trxMgntCO.getCtstrsVO().setCV_AMOUNT(trxMgntCO.getCtstrsVO().getCV_AMOUNT().multiply(trxMgntCO.getTrxChargesCO().getNumOfEntities()));
		}
	    }

	    trxMgntCO.setRunningDateRET(commonLibBO.addSystemTimeToDate(trxMgntCO.getRunningDateRET()));

	    /*
	     * Copy Data
	     */
	    PathPropertyUtil.copyProperties(trxMgntCO, trxMgntSC, "ctstrsVO.COMP_CODE compCode",
		    "ctstrsVO.BRANCH_CODE branchCode", "ctstrsVO.TRX_TYPE trxType", "ctstrsVO.TRS_CY trsCy",
		    "ctstrsVO.TRS_NO inTrsno", "ctstrsVO.TELLER_CODE tellerCode", "ctstrsVO.TRS_AC_BR trsAcBr",
		    "ctstrsVO.TRS_AC_CY trsAcCy", "ctstrsVO.TRS_AC_GL trsAcGl", "ctstrsVO.TRS_AC_CIF trsAcCif",
		    "ctstrsVO.TRS_AC_SL trsAcSl", "ctstrsVO.TO_TRS_AC_BR toTrsAcBr", "ctstrsVO.TO_TRS_AC_CY toTrsAcCy",
		    "ctstrsVO.TO_TRS_AC_GL toTrsAcGl", "ctstrsVO.TO_TRS_AC_CIF toTrsAcCif",
		    "ctstrsVO.TO_TRS_AC_SL toTrsAcSl", "ctstrsVO.AMOUNT trxAmount", "ctstrsVO.TRS_AC_AMOUNT accAmount",
		    "ctstrsVO.CV_AMOUNT cvAmount", "ctstrsVO.TRSFR_METHOD trsfrMethod", "ctstrsVO.TRS_DATE trsDate",
		    "ctstrsVO.VALUE_DATE valueDate", "runningDateRET systemDate", "ctstrsVO.CHQ_DATE chqDate",
		    "ctstrsVO.CHQ_NUM chqNum", "ctstrsVO.REMITTANCE_FR_NUM fromRemit",
		    "ctstrsVO.REMITTANCE_TO_NUM toRemit", "ctstrsVO.BANK_CIF bankCif");

	    
	    /*
	     * Check For Special Conditions. In case they exist, create transaction as active, else approved
	     */
	    trxMgntSC.setCompCode(trxMgntCO.getCtstrsVO().getCOMP_CODE());
	    trxMgntSC.setBranchCode(trxMgntCO.getCtstrsVO().getBRANCH_CODE());
	    trxMgntSC.setTrsType(trxMgntCO.getCtstrxtypeVO().getTYPE());
	    trxMgntSC.setCrDrForex(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX());
	    trxMgntSC.setMultiTrx(trxMgntCO.getCtstrxtypeVO().getMULTI_TRX());
	    trxMgntSC.setIsSO(trxMgntCO.getCtstrxtypeVO().getSTANDING_ORDER());
	    trxMgntSC.setLangCode(entityChargesCO.getLanguage());
	    trxMgntSC.setIvCrud(TrxMgntConstant.APPROVED_TRX);


	    /*
	     * If we are closing the account we set the close account as 'CA' to avoid checking on closed account
	     */
	    if(EntityChargesConstant.REFERENCE_CLOSE_ACCOUNT.equals(trxMgntCO.getReference()))
	    {
		trxMgntSC.setIvCrud(trxMgntSC.getIvCrud() + " " + TrxMgntConstant.APPEND_CRUD_CLOSE_ACC);
	    }

	    /*
	     * JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659
	     * If we are reactivating the account we set the reactivate account as 'RA' to
	     * avoid checking on reactivate account status.
	     */
	    if(EntityChargesConstant.REFERENCE_REACTIVATE_ACCOUNT.equals(trxMgntCO.getReference()))
	    {
		trxMgntSC.setIvCrud(trxMgntSC.getIvCrud() + " " + TrxMgntConstant.APPEND_CRUD_REACTIVATE_ACC + " ");
	    }
	    
	    trxMgntSC.setAction(TrxMgntConstant.INSERT_ACTION);

	    /*
	     * In order not to send invalid numbers to the procedure like -999999
	     */
	    NumberUtil.resetEmptyValues(trxMgntSC);

	    /*
	     * Jihane TP82682 ABARI110659 - send: ENTITY_TYPE: ('CHQ','SAF',
	     * 'LOS', 'CAR', 'SMS', 'PAS', 'CER') TYPE_IND: for
	     * chequebook:'P'[creation], 'AD'[approve destroy], 'AC'[approve
	     * cancel], for safebox:'S'[stamp], 'I'[inssurance], R'[rental],
	     * 'N'[renewal], for passbook: 'I'[issuance], for other
	     * products:'C'[charges] ENTITY_CODE: product code if length > 1
	     * then no need to add space, else if only one digit sent, then add
	     * space to avoid wrong parsing
	     */
	    if (null != trxMgntCO.getEntityCode())
	    {
	      trxMgntSC.setChqNum(trxMgntCO.getEntityCode().negate());
	    }
	
	    if(trxMgntSC.getIvCrud().length() > 1)
	    {
		trxMgntSC.setIvCrud((trxMgntSC.getIvCrud()
			.concat(trxMgntCO.getTrxChargesCO().getEntityType())).concat(StringUtil.nullToEmpty(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().getTYPE_IND())));
	    }
	    else
	    {
		trxMgntSC.setIvCrud(((trxMgntSC.getIvCrud().concat(" "))
			.concat(trxMgntCO.getTrxChargesCO().getEntityType())).concat(StringUtil.nullToEmpty(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().getTYPE_IND())));
	    }
	    
	    // TONY NOUH US 154817 SAFE account locking
	    // in case of return we should unlock the accounts already locked
	    TrxMgntSC trxMgntSCForLock = new TrxMgntSC();
	    if(!entityChargesCO.isAlreadyLocked())
	    {
		trxMgntCO.setLoginCompCode(trxMgntSC.getCompCode());
		trxMgntCO.setLoginBraCode(trxMgntSC.getBranchCode());
		trxMgntCO.setLoginTellerCode(trxMgntSC.getTellerCode());
		trxMgntCO.setCrud(TrxMgntConstant.APPROVED_TRX);
		trxMgntSCForLock = coreCommonServiceBO.lockSafeAccounts(trxMgntCO);
		
		entityChargesCO.setAlreadyLocked(true);
	    }
	    try
	    {
		/*
		 * Create Transaction
		 */
		trxMgntSC.applyTraceProps(trxMgntSC.getTraceAppName(), trxMgntSC.getTraceUserId(), trxMgntSC.getTraceProgRef(), trxMgntSC.getHttpSessionIdForLink()); //Rania - SQL session tracing R14.1 - 27/03/2018
		trxMgntSC = coreCommonProcedureBO.processCtstrs(trxMgntSC);

		if((TrxMgntConstant.ERROR.equals(trxMgntSC.getErrType()) || NumberUtil.nullToZero(
			trxMgntSC.getErrorCode()).compareTo(BigDecimal.ZERO) < 0)
			&& trxMgntSC.getErrorMessage() != null)
		{
		    String waiveCharges = "\n".concat(commonLibBO.returnTranslMessageOnly(
			    MessageCodes.PLEASE_WAIVE_CHARGES_TO_CONTINUE, StringUtil.nullEmptyToValue(entityChargesCO
				    .getLanguage(), ConstantsCommon.LANGUAGE_ENGLISH)));

		    BOException bo;

		    if(EntityChargesConstant.REFERENCE_CLOSE_ACCOUNT.equals(trxMgntCO.getReference())
			    || EntityChargesConstant.REFERENCE_REACTIVATE_ACCOUNT.equals(trxMgntCO.getReference()))
		    {
			bo = new BOException(trxMgntSC.getErrorMessage());
		    }
		    else
		    {
			bo = new BOException(trxMgntSC.getErrorMessage().concat(waiveCharges));
		    }

		    bo.setMsgTitleKey("Cannot_Proceed");
		    throw bo;
		}
		
		trxMgntSC.setCreatedBy(trxMgntCO.getCtstrsVO().getCREATED_BY());
		updateCTSTRSCreatedBy(trxMgntSC);
		
		// TONY NOUH US 154817 SAFE account locking
		trxMgntSC.setLockId(trxMgntSCForLock.getLockId());
		trxMgntSC.setAccForLockExists(trxMgntSCForLock.getAccForLockExists());
	    }
	    // TONY NOUH US 154817 SAFE account locking
	    catch(BOException ex)
	    {
		// TONY NOUH US 154817 SAFE account locking
		trxMgntSC.setLockId(trxMgntSCForLock.getLockId());
		trxMgntSC.setAccForLockExists(trxMgntSCForLock.getAccForLockExists());
		
		if(ex.getErrorCode() != null)
		{
		    throw new BOException(ex.getErrorCode(), ex.getParams(), ex.getMsgType(), trxMgntSC);
		}
		throw new BOException(ex.getMessage(), trxMgntSC);
	    }
	    catch(Exception ex)
	    {
		// TONY NOUH US 154817 SAFE account locking
		trxMgntSC.setLockId(trxMgntSCForLock.getLockId());
		trxMgntSC.setAccForLockExists(trxMgntSCForLock.getAccForLockExists());
		
		throw new BaseException(ex, "", trxMgntSC);
	    }

	    return trxMgntSC;
	}
    }

    /**
     * @author jihane Mazloum
     *  TP82894 - IIAB080110 ; TP82682 ABARI110659 
     * @param  trxMgntCO1  entityChargesCO
     * @return
     */
    public TrxMgntSC logChargesAsDues(TrxMgntCO trxMgntCO1, EntityChargesCO entityChargesCO)  throws BaseException
    {
	TrxMgntSC trxMgntSC = new TrxMgntSC();

	trxMgntSC.setSystemDate(trxMgntCO1.getRunningDateRET());
	trxMgntSC.setUserId(trxMgntCO1.getLoginUserId());
	trxMgntSC.setAppName(ConstantsCommon.RET_APP_NAME);
	//Hala Al Sheikh TP790351 - DASI190021
	//trxMgntSC.setTrsNo(null);
	trxMgntSC.setTrsNo(BigDecimal.valueOf(-1).multiply(entityChargesCO.getTrxType()));
	trxMgntSC.setTrsType(TrxMgntConstant.TRS_TYPE_CSM);
	trxMgntSC.setCbInd(TrxMgntConstant.CLIENT_CB_IND);
	trxMgntSC.setDuesSubOperation(null);
	trxMgntSC.setBatchNo(null);
	trxMgntSC.setSerialNo(null);
	trxMgntSC.setDuesInd(EntityChargesConstant.DUES_IND);

	trxMgntSC.setEntityCode(entityChargesCO.getEntityCode());
	trxMgntSC.setEntityType(entityChargesCO.getEntityType());

	
	/*
	 * loop on CTS_CHARGES_ENTITY
	 * insert charges as dues for every single record, since they are dues charges and no transaction will be created (we don't have normal charges)
	 * insert dues record by record in case we have multi charges 
	 * get total amount to be sent to the procedure P_RET_INSERT_CTS_DUES
	 */ 
	if(entityChargesCO.getCtsChargesEntityCOs() != null)
	{
	    for(int i = 0; i < entityChargesCO.getCtsChargesEntityCOs().size(); i++)
	    {
		if(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO() != null)
		{
		    
		    trxMgntSC.setCompCode(entityChargesCO.getLoginCompCode());
		    trxMgntSC.setBranchCode(entityChargesCO.getLoginBraCode());

		    trxMgntSC.setDuesCollectionType(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDUES_COLLECTION_TYPE());
		    trxMgntSC.setDuesPaymentMethod(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDUES_MODE_PAY());

		    // we are using "TrsAc account" within SC as product acc from where the charges will is to be deducted (debtor)
		    trxMgntSC.setTrsAcBr(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_BR());
		    trxMgntSC.setTrsAcCy(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_CY());
		    trxMgntSC.setTrsAcGl(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_GL());
		    trxMgntSC.setTrsAcCif(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_CIF());
		    trxMgntSC.setTrsAcSl(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_SL());

		    trxMgntSC.setChargeSchema(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getCHARGE_CODE());

		    /*
		     * get charges description from CTSCHARGES table
		     */
		    CTSCHARGESVO ctsChargesVO = new CTSCHARGESVO();
		    ctsChargesVO.setCOMP_CODE(trxMgntSC.getCompCode());
		    ctsChargesVO.setCODE(trxMgntSC.getChargeSchema());
		    ctsChargesVO = (CTSCHARGESVO) genericDAO.selectByPK(ctsChargesVO);
		    if(ctsChargesVO == null)
		    {
			throw new BOException(MessageCodes.INVALID_MISSING_CHARGE_CODE);
		    }
		    else
		    {
			trxMgntSC.setChargeBriefNameEng(ctsChargesVO.getBRIEF_NAME_ENG());
			trxMgntSC.setChargeBriefNameArab(ctsChargesVO.getBRIEF_NAME_ARAB());
			trxMgntSC.setVatCode(ctsChargesVO.getVAT_CODE()); //Hala Al Sheikh TP790351 - DASI190021
		    }

		    /*
		     * get the exchange rate
		     */
		    trxMgntSC.setBaseCurrencyCode(trxMgntCO1.getBaseCurrencyCode());
		    trxMgntSC.setTrsDate(trxMgntCO1.getRunningDateRET());
		    trxMgntSC.setRateFlag(EntityChargesConstant.RATE_TRANSFER_BUY_RATE);
		    // send currency of the product account
		    trxMgntSC.setTrsCy(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDEDUCT_FROM_ACC_CY());
		    TrxMgntSC trxMgntSCExchRate = coreCommonBO.returnNormalRate(trxMgntSC);
		    trxMgntSC.setExchRate(trxMgntSCExchRate.getExchRate());
		
		    //#228623 add time to date to be used in coreCommonProcedureBO.insertCtsDues
		    trxMgntSC.setSystemDate(commonLibBO.addSystemTimeToDate(trxMgntSC.getSystemDate()));
			    
		    if(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT() != null
			    && entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT_FC() != null)
		    {
			trxMgntSC.setTotalDuesCVcharge(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT());
			trxMgntSC.setTotalDuesFCcharge(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT_FC());
			
			
			//trxMgntSC.setDuesRemainingCharge((entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT_FC()).subtract(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC())); // subtract vat
			trxMgntSC.setDuesRemainingCharge(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT_FC());  
			
			
			// and the "ToTrs account" as charges account (creditor)
			trxMgntSC.setToTrsAcBr(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getACC_BR());
			trxMgntSC.setToTrsAcCy(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getACC_CY());
			trxMgntSC.setToTrsAcGl(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getACC_GL());
			trxMgntSC.setToTrsAcCif(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getACC_CIF());
			trxMgntSC.setToTrsAcSl(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getACC_SL());

			//Hala Al Sheikh TP790351 - DASI190021
			if(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO() != null			    
				&& (NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT()) != null
					&& NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC()) != null)) // FOR TVA
			{
			    trxMgntSC.setVatCVAmount(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT());
			    trxMgntSC.setVatFCAmount(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC());				

			    // and the "ToTrs account" as charges account (creditor)
			    trxMgntSC.setChAcBr(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getACC_BR());
			    trxMgntSC.setChAcCy(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getACC_CY());
			    trxMgntSC.setChAcGl(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getACC_GL());
			    trxMgntSC.setChAcCif(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getACC_CIF());
			    trxMgntSC.setChAcSl(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getACC_SL());

			}
			// End Hala
			
			/*
			 * call P_RET_INSERT_CTS_DUES to log charges as Dues
			 */
			trxMgntSC.setLineNo(BigDecimal.ZERO); //Hala Al Sheikh TP790351 - DASI190021
			NumberUtil.resetEmptyValues(trxMgntSC); //jihane TP223924 in order not to send invalid numbers to the procedure like -999999
			TrxMgntSC trxMgntSCLogDues = coreCommonProcedureBO.insertCtsDues(trxMgntSC);
			if(NumberUtil.nullToZero(trxMgntSCLogDues.getErrorCode()).compareTo(BigDecimal.ZERO) < 0)
			{
			    throw new BOException(trxMgntSCLogDues.getErrorMessage());
			}

		    }
		    
		}

	    }

	}

	return trxMgntSC;
    }
    
    public AccountBO getAccountBO()
    {
        return accountBO;
    }

    public void setAccountBO(AccountBO accountBO)
    {
        this.accountBO = accountBO;
    }

    /**
     * Checks if the Transaction to be Created is Multi Trx and if it is compatible with the charges
     * If Multi-Charges then we have to select Transfer in Multi Mode
     * 
     * @author Reda Charabaty
     * @param 	compCode		Company Code
     * 		chargeSchema		Charges Schema
     * 		trxtype			Transaction Type
     * 		suppressMessage		false to output exception, true to return int
     * 		loginBraCode		Login Branch Code
     * 		AccBranch		Deduct Account Branch Code
     * 
     * @return	int
     * 			-1 In Case Trx Type is not Valid
     * 			0  In Case no Charges
     * @throws BaseException
     */
    public int checkMultiTrxCompatibility(EntityChargesCO entityChargesCO) throws BaseException
    {
	BigDecimal compCode = entityChargesCO.getLoginCompCode();
	BigDecimal chargeSchema = entityChargesCO.getSchema();
	BigDecimal trxtype = entityChargesCO.getTrxType();
	
	//SANDRA: 868780 - DASI190356 - Multi transfer transaction: no need for this checking
	if(1 == 1)
	{
	    return 1;
	}
	
	/*
	 * If no Charges to be created
	 */
	if(NumberUtil.nullToZero(compCode).compareTo(BigDecimal.ZERO) == 0
		|| NumberUtil.nullToZero(chargeSchema).compareTo(BigDecimal.ZERO) == 0
		|| NumberUtil.nullToZero(trxtype).compareTo(BigDecimal.ZERO) == 0)
	{
	    return 0;
	}
	
	TrxTypeSC criteria = new TrxTypeSC();
	criteria.setCompCode(compCode);
	criteria.setCode(trxtype);
	criteria.setStatus(TrxMgntConstant.STATUS_APPROVE);
	
	CTSTRXTYPEVO ctsTRXTYPE = trxTypeBO.returnTrxTypeById(criteria);
	
	/*
	 * If Trx type is invalid/missing
	 */
	if(ctsTRXTYPE == null)
	{
	    return -2;
	}
	
	if (ctsTRXTYPE.getMULTI_TRX() == null)
	{
	    ctsTRXTYPE.setMULTI_TRX(ConstantsCommon.ZERO);
	}
	
	BigDecimal loginBranch = entityChargesCO.getLoginBraCode();
	BigDecimal debitAccBranch = entityChargesCO.getAccBranch();
	/*
	 * Get counts of Charges and VAT charges
	 */
	EntityChargesSC entityChargesSC = new EntityChargesSC();
	entityChargesSC.setCompCode(compCode);
	entityChargesSC.setCode(chargeSchema);
	entityChargesSC.setBranchCode(loginBranch);
	entityChargesSC.setDebitAccBr(debitAccBranch);
	
	int count; 
	
	count = retrieveCountNonExemptedCharges(entityChargesSC).intValue();

	int vatCount; 
	vatCount = retrieveCountChargesSchemaVAT(entityChargesSC).intValue();
	
	/*
	 * If no Charges to be created
	 */
	if(count + vatCount == 0)
	{
	    return 0;
	}
	Boolean suppressMessage = entityChargesCO.getSuppressMessage();
	/*
	 * In case of incompatibility
	 */
	if((ctsTRXTYPE.getMULTI_TRX().equals(ConstantsCommon.ZERO) && vatCount > 0)
		|| (ctsTRXTYPE.getMULTI_TRX().equals(ConstantsCommon.ZERO) && count > 1))
		//|| (ctsTRXTYPE.getMULTI_TRX().equasls(ConstantsCommon.ONE) && count == 1 && vatCount == 0))
	    		// COMMENTED SINCE NEW BEHAVIOR ALLOW IF MULTI TRX TO PROCESS ONLY 1 RECORD AND INCLUDE BOTH CASES
	{
	    if(suppressMessage)
	    {
		return -1;
	    }
	    else
	    {
		throw new BOException(MessageCodes.TRX_TYPE_MODE_AND_CHARGES_NOT_COMPATIBLE_CONTINUE, ConstantsCommon.CONFIRM_MSG_TYPE);
	    }
	}
	
	return 1;
    }
    
    /**
     * This returns a count of charges in the charge schema that correspond to VAT Charges
     * 
     * @author Reda Charabaty
     * @param EntityChargesSC
     * 
     * @return BigDecimal
     * 
     * @throws BaseException
     */
    public BigDecimal retrieveCountAllChargesSchema(EntityChargesSC entityChargesSC) throws BaseException
    {
	return entityChargesDAO.retrieveCountAllChargesSchema(entityChargesSC);
    }

    /**
     * This sets the Decimal Points of the Charge Currency
     * 
     * @author Reda Charabaty
     * @param entityChargesCO
     * 
     * @return entityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO calculateChargeCurrencyDecimalPoints(EntityChargesCO entityChargesCO) throws BaseException
    {
	
	if(entityChargesCO.getChargeAccCurrency().equals(entityChargesCO.getBaseCurrencyCode()))
	{
	    /*
	     * Base Currency
	     */
	    entityChargesCO.setBriefDescEng(entityChargesCO.getBriefDescEngBase());
	    entityChargesCO.setChargeCurrDecPoint(entityChargesCO.getBaseCurrDecPoint());
	}
	else
	{
	    /*
	     * Foreign Currency
	     */
	    CURRENCIESVO currenciesVO = new CURRENCIESVO();
	    currenciesVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	    currenciesVO.setCURRENCY_CODE(entityChargesCO.getChargeAccCurrency());
	    currenciesVO = commonLibBO.returnCurrency(currenciesVO);

	    entityChargesCO.setBriefDescEng(currenciesVO.getBRIEF_DESC_ENG());
	    entityChargesCO.setChargeCurrDecPoint(currenciesVO.getDECIMAL_POINTS());
	}
	return entityChargesCO;
    }
    
    /**
     * Calculates the teller Account and checks if it is Valid. Sets It in trxMgntCO.getCtstrsVO()
     * 
     * Retrieves Teller Account for the Transaction Type or All Transactions
     * 
     * @author Reda Charabaty
     * @param 	trxmgntCO
     * 			ctstrsVO.getTELLER_CODE()		Teller Code
     * 			ctstrsVO.getTRS_CY()			Transaction Currency
     * 			ctstrsVO.getTRX_TYPE()			Transaction Type
     * 			language				Language
     * 
     * 		entityChargesCO
     * 			loginCompCode				Login Company Code
     * 			loginBraCode				Login Branch Code
     * 			
     * 		
     * @return TrxMgntCO
     * 			ctstrsVO.getTRS_AC_BR()
     * 			ctstrsVO.getTRS_AC_CY()
     * 			ctstrsVO.getTRS_AC_GL()
     * 			ctstrsVO.getTRS_AC_CIF()
     * 			ctstrsVO.getTRS_AC_SL()
     * 
     * @throws BaseException
     */
    public TrxMgntCO calculateTellerAccount(TrxMgntCO trxMgntCO, EntityChargesCO entityChargesCO) throws BaseException
    {
	BigDecimal tellerCode = trxMgntCO.getCtstrsVO().getTELLER_CODE();
	if(trxMgntCO.getCtstrsVO().getCREATED_BY() != null && !"".equals(trxMgntCO.getCtstrsVO().getCREATED_BY()))
	{
	    CTSTELLERVO ctsTellerVO = commonLibBO.returnCtsTellerDetails(entityChargesCO.getLoginCompCode(), entityChargesCO.getLoginBraCode(), trxMgntCO.getCtstrsVO().getCREATED_BY());
	    if(ctsTellerVO != null)
	    {
		tellerCode = ctsTellerVO.getCODE();
	    }
	}
	
	CTSTELLERACCDETVO ctsTellerAccDetVO = new CTSTELLERACCDETVO();
	ctsTellerAccDetVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	ctsTellerAccDetVO.setBRANCH_CODE(entityChargesCO.getLoginBraCode());
	ctsTellerAccDetVO.setCODE(tellerCode);
	ctsTellerAccDetVO.setCY_CODE(trxMgntCO.getCtstrsVO().getTRS_CY());
	ctsTellerAccDetVO.setTRX_TYPE(trxMgntCO.getCtstrsVO().getTRX_TYPE());

	ctsTellerAccDetVO = (CTSTELLERACCDETVO) genericDAO.selectByPK(ctsTellerAccDetVO);

	if(ctsTellerAccDetVO == null)
	{
	    /*
	     * Select for All Transaction Types
	     */
	    ctsTellerAccDetVO = new CTSTELLERACCDETVO();
	    ctsTellerAccDetVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	    ctsTellerAccDetVO.setBRANCH_CODE(entityChargesCO.getLoginBraCode());
	    ctsTellerAccDetVO.setCODE(tellerCode);
	    ctsTellerAccDetVO.setCY_CODE(trxMgntCO.getCtstrsVO().getTRS_CY());
	    ctsTellerAccDetVO.setTRX_TYPE(BigDecimal.ZERO);

	    ctsTellerAccDetVO = (CTSTELLERACCDETVO) genericDAO.selectByPK(ctsTellerAccDetVO);

	    if(ctsTellerAccDetVO == null)
	    {
		throw new BOException(MessageCodes.MISSING_ACC_FOR_TRX_TYPE_IN_ACC_DETAIL, new String[] { ConstantsCommon.ZERO, trxMgntCO.getCtstrsVO().getTELLER_CODE().toString() });
	    }
	}

	/*
	 * Check if Account is Valid
	 */
	AccountSC accountSC = new AccountSC();
	accountSC.setCompCode(ctsTellerAccDetVO.getCOMP_CODE());
	accountSC.setBranchCode(ctsTellerAccDetVO.getACC_BR());
	accountSC.setCurrencyCode(ctsTellerAccDetVO.getACC_CY());
	accountSC.setGlCode(ctsTellerAccDetVO.getACC_GL());
	accountSC.setCifCode(ctsTellerAccDetVO.getACC_CIF());
	accountSC.setSlNbr(ctsTellerAccDetVO.getACC_SL());
	accountSC.setPreferredLanguage(trxMgntCO.getLanguage());
	accountBO.checkAccountInAMF(accountSC);

	/*
	 * Set Account
	 */
	trxMgntCO.getCtstrsVO().setTRS_AC_BR(ctsTellerAccDetVO.getACC_BR());
	trxMgntCO.getCtstrsVO().setTRS_AC_CY(ctsTellerAccDetVO.getACC_CY());
	trxMgntCO.getCtstrsVO().setTRS_AC_GL(ctsTellerAccDetVO.getACC_GL());
	trxMgntCO.getCtstrsVO().setTRS_AC_CIF(ctsTellerAccDetVO.getACC_CIF());
	trxMgntCO.getCtstrsVO().setTRS_AC_SL(ctsTellerAccDetVO.getACC_SL());
	
	return trxMgntCO;
    }
    
    /**
     * Retrieves Charges of a specific Entity
     * 
     * @author Reda Charabaty
     * @param  entityChargesCO
     * 	       entityChargesSC
     * 		
     * @return entityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO calculateCharges(EntityChargesCO entityChargesCO1, EntityChargesSC entityChargesSC) throws BaseException
    {
	EntityChargesCO entityChargesCO = entityChargesCO1;
	/*
	 * Set new objects
	 */
	if(entityChargesCO == null)
	{
	    entityChargesCO = new EntityChargesCO();
	}
	if(entityChargesCO.getCtsChargesEntityCOs() == null)
	{
	    entityChargesCO.setCtsChargesEntityCOs(new ArrayList<CtsChargesEntityCO>());
	}

	/*
	 * Set arguments
	 */
	entityChargesCO.setLoginPreferrredLanguage(entityChargesSC.getLanguage());
	entityChargesCO.setLoginCompCode(entityChargesSC.getCompCode());
	entityChargesCO.setLoginBraCode(entityChargesSC.getBranchCode());
	entityChargesCO.setTypeInd(entityChargesSC.getTypeInd());
	entityChargesCO.setEntityType(entityChargesSC.getEntityType());
	entityChargesCO.setEntityCode(entityChargesSC.getCode());

	/*
	 * Retrieve Charges
	 */
	List<CtsChargesEntityCO> entityChargesList = retrieveCtsChargesEntityCOList(entityChargesCO);
	entityChargesCO.setCtsChargesEntityCOs(entityChargesList);
	    
	
	
	return entityChargesCO;
    }
    
    /**
     * Prepares and calls the retrieval of Charges in case the ones we have are null
     * 
     * @author Reda Charabaty
     * @param   lang			Login Preferred Language
     * 		compCode 		Company Code
     * 		branchCode 		Branch Code
     * 		typeInd 		Type Indicator
     * 		entityType 		Entity Type
     * 		entityCode		Entity Code
     * 		
     * @return entityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO callCalculateCharges(EntityChargesCO entityChargesCO, String lang, BigDecimal compCode, BigDecimal branchCode, String typeInd, String entityType, BigDecimal entityCode) throws BaseException
    {
	if(entityChargesCO == null || entityChargesCO.getCtsChargesEntityCOs() == null
		|| entityChargesCO.getCtsChargesEntityCOs().size() == 0)
	{
	    /*
	     * Prepare Data
	     */
	    EntityChargesSC entityChargesSC = new EntityChargesSC();
	    entityChargesSC.setLanguage(lang);
	    entityChargesSC.setCompCode(compCode);
	    entityChargesSC.setBranchCode(branchCode);
	    entityChargesSC.setTypeInd(typeInd);
	    entityChargesSC.setEntityType(entityType);
	    entityChargesSC.setCode(entityCode);

	    /*
	     * Call function
	     */
	    return calculateCharges(entityChargesCO, entityChargesSC);
	}
	else
	{
	    return entityChargesCO;
	}
    }
    
    /**
     * Catches Transaction Number, Warning and Error Messages to be returned for output after creating a Charge Trx
     * 
     * @author Reda Charabaty
     * @param  TrxMgntSC
     * 		
     * @return List<String>
     * 
     * @throws BaseException
     */
    public List<String> fillReturnMessage(TrxMgntSC trxMgntSC) throws BaseException
    {
	List<String> returnMessage = new ArrayList<String>();

	
	
	if(trxMgntSC.getOutTrsno() != null && trxMgntSC.getOutTrsno().intValue() > 0 && 
		(!TrxMgntConstant.ERROR.equals(trxMgntSC.getErrType()) && (trxMgntSC.getErrorCode() == null ||
			trxMgntSC.getErrorCode().intValue() >= 0)))
	{
	    /*
	     * Convert to Double so as not to get an incoherent Value
	     */
	    int trsNo = trxMgntSC.getOutTrsno().intValue();
	    trxMgntSC.setOutTrsno((BigDecimal.valueOf(trsNo)));

	    /*
	     * Catch Transaction Number
	     */
	    returnMessage.add(commonLibBO.returnTranslErrorMessage(MessageCodes.OPERATION_GENERATED_TRANACTION_NUMBER,
		    new String[] { trxMgntSC.getOutTrsno().toString() }, trxMgntSC.getLangCode()) + ConstantsCommon.NEW_LINE);

	    /*
	     * Catch Warnings
	     */
	    if((TrxMgntConstant.WARNING.equals(trxMgntSC.getErrType())
		    || TrxMgntConstant.LIMIT_WARNING.equals(trxMgntSC.getErrType()) || NumberUtil.nullToZero(
		    trxMgntSC.getErrorCode()).compareTo(BigDecimal.ZERO) > 0)
		    && trxMgntSC.getErrorMessage() != null
		    && !trxMgntSC.getErrorMessage().trim().equals(EntityChargesConstant.VALUE_EMPTY))
	    {
		returnMessage.add(trxMgntSC.getErrorMessage() + ConstantsCommon.NEW_LINE);
	    }
	    
	}
	else
	{
	    /*
	     * Catch Errors
	     */
	    if(trxMgntSC.getErrorCode() != null
		    && trxMgntSC.getErrorMessage() != null
		    && (TrxMgntConstant.ERROR.equals(trxMgntSC.getErrType()) || trxMgntSC.getErrorCode().intValue() < 0))
	    {
		returnMessage.add(trxMgntSC.getErrorMessage() + ConstantsCommon.NEW_LINE);
	    }

	}

	return returnMessage;
    }
    
    
    /**
     * Calculates and Processes Multi-Transfer Charges Details in the table to be used when creating Charge Transaction
     * 
     * @author Reda Charabaty
     * @param  TrxMgntCO, EntityChargesCO
     * 
     * @throws BaseException
     */
    public void fillMultiTransferDetails(TrxMgntCO trxMgntCO1, EntityChargesCO entityChargesCO) throws BaseException
    {
	TrxMgntCO trxMgntCO = trxMgntCO1;
	/*
	 * Check if the trx type is multi trx
	 */
	if(ConstantsCommon.ONE.equals(trxMgntCO.getCtstrxtypeVO().getMULTI_TRX()))
	{

	    /*
	     * Calculate Data needed
	     */
	    trxMgntCO = calculateMultiTransfer(trxMgntCO);
	    
	    
	    /*
	     * Process Data into Database
	     */
	    processMultiTransfer(trxMgntCO);
	    
	}
    }
    
    /**
     * Calculates Multi-Transfer Charges Details to be used when creating Charge Transaction
     * 
     * @author Reda Charabaty
     * @param  TrxMgntCO
     * 
     * @return TrxMgntCO
     * 
     * @throws BaseException
     */
    public TrxMgntCO calculateMultiTransfer(TrxMgntCO trxMgntCO) throws BaseException
    {
	if(trxMgntCO.getCtstrsACCDETVOs() != null)
	{
	    /*
	     * Get Exchange Rate to be used. (PB function f_get_exchrate_dt)
	     */
	    BigDecimal exchRate;
	    
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(trxMgntCO.getCtstrsVO().getCOMP_CODE());
	    iisCommonCO.setExchangeRateCurrency(trxMgntCO.getCtstrsVO().getTRS_CY());
	    iisCommonCO.setExchangeDate(trxMgntCO.getCtstrsVO().getTRS_DATE());
	    iisCommonCO.setBaseCurrencyCode(trxMgntCO.getBaseCurrencyCode());
	    iisCommonCO = iisCommonBO.returnExchangeRate(iisCommonCO);
	    
	    exchRate = iisCommonCO.getExchageRate();
	    
	    if(exchRate == null)
	    {
		exchRate = BigDecimal.ONE;
	    }
	    
	    CTSCHARGESVO ctsChargesVO = new CTSCHARGESVO();
	    ctsChargesVO.setCOMP_CODE(trxMgntCO.getCtstrsVO().getCOMP_CODE());
	    
	    ACC_VATVO accVATVO = new ACC_VATVO();
	    accVATVO.setCOMP_CODE(trxMgntCO.getCtstrsVO().getCOMP_CODE());
		
	    
	    for(int i =0; i < trxMgntCO.getCtstrsACCDETVOs().size(); i++)
	    {
		
		if(trxMgntCO.getCtstrsVO().getTRS_CY().equals(trxMgntCO.getBaseCurrencyCode()))
		{
		    trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setFC_AMOUNT(trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().getCV_AMOUNT());
		}
		
		trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setAC_BR(trxMgntCO.getCtstrsVO().getBRANCH_CODE());
		trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setAC_CY(trxMgntCO.getCtstrsVO().getTRS_CY());
		
		
		/*
		 * Fetch Charges Info
		 */
		ctsChargesVO.setCODE(trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().getCHARGE_CODE());
		ctsChargesVO = (CTSCHARGESVO) genericDAO.selectByPK(ctsChargesVO);

		if(ctsChargesVO != null)
		{
		    if(ctsChargesVO.getPASS_SEPARATELY() == null)
		    {
			ctsChargesVO.setPASS_SEPARATELY(ConstantsCommon.ZERO);
		    }
		    trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setPASS_SEPARATELY(ctsChargesVO.getPASS_SEPARATELY());

		    if(trxMgntCO.getPthCtrlVO().getCHARGES_BOOKING().equals(EntityChargesConstant.CHARGES_BOOKING_A))
		    {
			trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setEXCH_RATE(exchRate);
		    }
		    else
		    {
			trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setEXCH_RATE(BigDecimal.ONE);
		    }
		    
		    
		    /*
		     * Check if Normal Charge or VAT charge to know where to get Account info
		     */
		    if(trxMgntCO.getCtstrsACCDETVOs().get(i).getIsVAT() == null  || trxMgntCO.getCtstrsACCDETVOs().get(i).getIsVAT().equals(false))
		    {
			/*
			 * Normal Charges
			 */
			trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setAC_GL(ctsChargesVO.getACC_GL());
			trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setAC_CIF(ctsChargesVO.getACC_CIF());
			trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setAC_SL(ctsChargesVO.getACC_SL());
			
		    }
		    else
		    {
			/*
			 * Fetch VAT Charges Info
			 */
			if(ctsChargesVO.getVAT_CODE() == null)
			{
			    trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setAC_GL(ctsChargesVO.getACC_GL());
			    trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setAC_CIF(ctsChargesVO.getACC_CIF());
			    trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setAC_SL(ctsChargesVO.getACC_SL());
			}
			else
			{
				/*
			    accVATVO.setVAT_CODE(ctsChargesVO.getVAT_CODE());
			    accVATVO = (ACC_VATVO) genericDAO.selectByPK(accVATVO);

			    if(accVATVO != null)
			    {			    	
				trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setAC_GL(accVATVO.getCR_GL());
				trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setAC_CIF(accVATVO.getCR_CIF());
				trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETVO().setAC_SL(accVATVO.getCR_SL());
			    }
			    */
				//added by Maria for BMO180067
				AccountCO accountCO = new AccountCO();
				accountCO.getAmfVO().setCOMP_CODE(trxMgntCO.getCtstrsVO().getCOMP_CODE());
				
				accountCO.getAmfVO().setBRANCH_CODE(trxMgntCO.getCtstrsVO().getTRS_AC_BR());						
				accountCO.getAmfVO().setCURRENCY_CODE(trxMgntCO.getCtstrsVO().getTRS_AC_CY());
				accountCO.getAmfVO().setGL_CODE(trxMgntCO.getCtstrsVO().getTRS_AC_GL());
				accountCO.getAmfVO().setCIF_SUB_NO(trxMgntCO.getCtstrsVO().getTRS_AC_CIF());				
				accountCO.setLoginUserId(trxMgntCO.getLoginUserId());
				accountCO.setRunningDate(trxMgntCO.getRunningDateRET());				
				accountCO.setTaxVatCode(ctsChargesVO.getVAT_CODE());
				accountCO = coreCommonProcedureBO.wrapCoreGetVatDetails(accountCO);
				if(accountCO != null)
				{
				    trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETAILSVO().setAC_GL(accountCO.getAmfSC().getGL_CODE());
					trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETAILSVO().setAC_CIF(accountCO.getAmfSC().getCIF_SUB_NO());
					trxMgntCO.getCtstrsACCDETVOs().get(i).getCtstrsACCDETAILSVO().setAC_SL(accountCO.getAmfSC().getSL_NO());
				}
				//end Maria 	
				
			}
		    }
		}
	    }
	}
	return trxMgntCO;
	
    }
    
    /**
     * This function will empty the temporary table CTSTRS_ACC_DET_TMP, and then it will fill it with the list of accounts
     * (Copied from TrxMgntBO)
     * 
     * @author Reda Charabaty
     * @param trxMgntCO
     * 
     * @throws BaseException
     */
    public void processMultiTransfer(TrxMgntCO trxMgntCO) throws BaseException
    {
	
	BigDecimal tellerCode = trxMgntCO.getCtstrsVO().getTELLER_CODE();
	if(!NumberUtil.isEmptyDecimal(tellerCode))
	{
	    /*
	     * Delete the CTSTRS_ACC_DET_TMP by compCode , branchCode and tellerCode.
	     */
	    TrxMgntSC trxMgntSC = new TrxMgntSC();
	    trxMgntSC.setCompCode(trxMgntCO.getCtstrsVO().getCOMP_CODE());
	    trxMgntSC.setBranchCode(trxMgntCO.getCtstrsVO().getBRANCH_CODE());
	    trxMgntSC.setTellerCode(tellerCode);
	    entityChargesDAO.deleteCTSTRS_ACC_DET_TMP(trxMgntSC);

	    /*
	     * Insert into CTSTRS_ACC_DET_TMP, the list of accountDet vo's.
	     */
	    List<TrxMgntAccountDtlCO> ctsTrsACCDETVOList = trxMgntCO.getCtstrsACCDETVOs();
	    if(ctsTrsACCDETVOList != null && !ctsTrsACCDETVOList.isEmpty())
	    {
		/*
		 * Start LINE_NO with value 1
		 */
		BigDecimal lineNo = BigDecimal.ONE;
		BigDecimal numOfEntities = trxMgntCO.getTrxChargesCO().getNumOfEntities();
		
		if(numOfEntities == null || numOfEntities.equals(BigDecimal.ZERO))
		{
		    numOfEntities = BigDecimal.ONE;
		}
		
		
		CTSTRS_ACC_DET_TMPVO ctsTrsACCDETTMPVO;
		for(TrxMgntAccountDtlCO ctsTrsACCDETCO : ctsTrsACCDETVOList)
		{
		    ctsTrsACCDETTMPVO = new CTSTRS_ACC_DET_TMPVO();
		    ctsTrsACCDETTMPVO.setCOMP_CODE(trxMgntCO.getCtstrsVO().getCOMP_CODE());
		    ctsTrsACCDETTMPVO.setBRANCH_CODE(trxMgntCO.getCtstrsVO().getBRANCH_CODE());
		    ctsTrsACCDETTMPVO.setTRS_ACC_NO(tellerCode);
		    ctsTrsACCDETTMPVO.setLINE_NO(lineNo);
		    ctsTrsACCDETTMPVO.setACC_BR(ctsTrsACCDETCO.getCtstrsACCDETVO().getAC_BR());
		    ctsTrsACCDETTMPVO.setACC_CIF(ctsTrsACCDETCO.getCtstrsACCDETVO().getAC_CIF());
		    ctsTrsACCDETTMPVO.setACC_CY(ctsTrsACCDETCO.getCtstrsACCDETVO().getAC_CY());
		    ctsTrsACCDETTMPVO.setACC_GL(ctsTrsACCDETCO.getCtstrsACCDETVO().getAC_GL());
		    ctsTrsACCDETTMPVO.setACC_SL(ctsTrsACCDETCO.getCtstrsACCDETVO().getAC_SL());
		    ctsTrsACCDETTMPVO.setFC_AMOUNT(NumberUtil.nullToZero(ctsTrsACCDETCO.getCtstrsACCDETVO().getFC_AMOUNT()).setScale(3,BigDecimal.ROUND_HALF_UP).multiply(numOfEntities));
		    ctsTrsACCDETTMPVO.setEXCH_RATE(ctsTrsACCDETCO.getCtstrsACCDETVO().getEXCH_RATE());
		    ctsTrsACCDETTMPVO.setCV_AMOUNT(NumberUtil.nullToZero(ctsTrsACCDETCO.getCtstrsACCDETVO().getCV_AMOUNT()).setScale(3,BigDecimal.ROUND_HALF_UP).multiply(numOfEntities));
		    ctsTrsACCDETTMPVO.setCHARGE_CODE(ctsTrsACCDETCO.getCtstrsACCDETVO().getCHARGE_CODE());
		    genericDAO.insert(ctsTrsACCDETTMPVO);

		    /*
		     * Increment LINE_NO by 1
		     */
		    lineNo = lineNo.add(BigDecimal.ONE);
		}
	    }
	}
    }

    public IISCommonBO getIisCommonBO()
    {
        return iisCommonBO;
    }

    public void setIisCommonBO(IISCommonBO iisCommonBO)
    {
        this.iisCommonBO = iisCommonBO;
    }

    public EntityChargesDAO getEntityChargesDAO()
    {
        return entityChargesDAO;
    }
    
    /**
     * This function will prepare the Account Details grid for the Charges Transaction
     * 
     * @author Reda Charabaty
     * @param trxMgntCO
     * 
     * @throws BaseException
     */
    public TrxMgntCO prepareEntityMultiTransferData(EntityChargesCO entityChargesCO) throws BaseException
    {
	TrxMgntCO trxMgntCO = new TrxMgntCO();
	
	/*
	 * Prepare Multi-Transfer Data
	 */
	if(entityChargesCO.getCtsChargesEntityCOs().size() > 1 ||
		(entityChargesCO.getCtsChargesEntityCOs().get(0).getVatCtsChargesEntityVO() != null && 
			entityChargesCO.getCtsChargesEntityCOs().get(0).getVatCtsChargesEntityVO().getAMOUNT() != null &&
			entityChargesCO.getCtsChargesEntityCOs().get(0).getVatCtsChargesEntityVO().getAMOUNT().compareTo(BigDecimal.ZERO) > 0))
	{
	    if (trxMgntCO.getCtstrsACCDETVOs() == null)
	    {
		trxMgntCO.setCtstrsACCDETVOs(new ArrayList<TrxMgntAccountDtlCO>());
	    }
	    
	    TrxMgntAccountDtlCO trxMgntAccountDtlCO;
	    
	    for(int i = 0; i < entityChargesCO.getCtsChargesEntityCOs().size(); i++)
	    {
		trxMgntAccountDtlCO = new TrxMgntAccountDtlCO();
		
		trxMgntAccountDtlCO.getCtstrsACCDETVO().setCV_AMOUNT(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT());
		trxMgntAccountDtlCO.getCtstrsACCDETVO().setFC_AMOUNT(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT_FC());
		trxMgntAccountDtlCO.getCtstrsACCDETVO().setCHARGE_CODE(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getCHARGE_CODE());
		trxMgntCO.getCtstrsACCDETVOs().add(trxMgntAccountDtlCO);
		
		if(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO() != null
		
		    &&entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT() != null
			    && entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC() != null
			    && entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT().compareTo(BigDecimal.ZERO) > 0
			    && entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC().compareTo(BigDecimal.ZERO) > 0)
		    {
			trxMgntAccountDtlCO = new TrxMgntAccountDtlCO();
			
			trxMgntAccountDtlCO.getCtstrsACCDETVO().setCV_AMOUNT(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT());
			trxMgntAccountDtlCO.getCtstrsACCDETVO().setFC_AMOUNT(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC());
			trxMgntAccountDtlCO.getCtstrsACCDETVO().setCHARGE_CODE(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getCHARGE_CODE());
			
			trxMgntAccountDtlCO.setIsVAT(true);
			
			trxMgntCO.getCtstrsACCDETVOs().add(trxMgntAccountDtlCO);
		    }
		
	    }
	}

	return trxMgntCO;
    }
    
    /**
     * Waives the Charges on product screen. Performs the necessary checking to do the waiving.
     * 
     * @author Reda Charabaty
     * @param  EntityChargesCO
     * 
     * 
     * @return EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO waiveCharges(EntityChargesCO entityChargesCO) throws BaseException
    {
	/*
	 * Below Commented due to bug 
	 */
//	if(entityChargesCO.getCtsChargesEntityCOs() != null && entityChargesCO.getCtsChargesEntityCOs().size() > 0)
//	{
//	    CTSCHARGESVO ctsChargesVO;
//	    
//	    for(int i = 0; i < entityChargesCO.getCtsChargesEntityCOs().size(); i++)
//	    {
//		ctsChargesVO = new CTSCHARGESVO();
//		ctsChargesVO = retrieveChargesInfo(entityChargesCO.getLoginCompCode(), entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getCHARGE_CODE());
//		
//		if(ctsChargesVO != null)
//		{
//		    if(ctsChargesVO.getALLOW_CLEARING().equals(ConstantsCommon.ZERO) || ctsChargesVO.getALLOW_MODIFY().equals(ConstantsCommon.ZERO))
//		    {
//			throw new BOException(MessageCodes.CANNOT_CLEAR_CHARGES);
//		    }
//		}
//	    }
//	}
	
	return entityChargesCO;
    }
    
    public EntityChargesCO waiveEntityCharges(EntityChargesCO entityChargesCO) throws BaseException
    {
	if(entityChargesCO.getIsWaived() != null && EntityChargesConstant.TF_TRUE.equals(entityChargesCO.getIsWaived()))
	{
	    entityChargesDAO.waiveEntityCharges(entityChargesCO);
	}
	return entityChargesCO;
    }
  
    /**
     * Returns sum of Available & Covering Balances of the account 
     * 
     * @author Reda Charabaty 
     * @param  EntityChargesCO
     *       		deductCharges			Deduct Charges flag in Case it exists
     * 			accBranch			Main Account Branch
     * 			accCurrency			Main Account Currency
     * 			accGL				Main Account GL
     * 			accCIF				Main Account CIF
     * 			accSL				Main Account SL
     * 			chargeAccBranch			Charge Account Branch 
     * 			chargeAccCurrency		Charge Account Currency
     * 			chargeAccGL			Charge Account GL
     * 			chargeAccCIF			Charge Account CIF
     * 			chargeAccSL			Charge Account SL
     * 			loginCompCode			Login Company Code
     * 			entityCommand			Denotes Entity Type (ex: "SAF" for Safebox)
     * 			trxType				Transaction Type
     * 			baseCurrencyCode		Base Currency Code
     * 			loginBraCode			Login Branch Code
     * 			loginUserId			Login User ID
     * 			runningDate			Running Date
     * 			language			Language
     * 
     * 
     * @return BigDecimal
     * 
     * @throws BaseException
     */
    public BigDecimal returnAvailableBalance(EntityChargesCO entityChargesCO) throws BaseException
    {
	/*
	 * Set Account Details
	 */
	AMFVO amfVO = chooseChargeAccount(entityChargesCO);
	amfVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	amfVO = (AMFVO)genericDAO.selectByPK(amfVO);
	
	if(amfVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CHARGE_ACC);
	}
	
	AccountPositionCO accountPositionCO = new AccountPositionCO();
	
	
	if(EntityChargesConstant.ENTITY_SAFEBOX.equals(entityChargesCO.getEntityCommand()))
	{
	    accountPositionCO.setCtsTrxTypeVO(new CTSTRXTYPEVO());
	    accountPositionCO.getCtsTrxTypeVO().setBLOCK_ACTIVE_WITH(ConstantsCommon.ZERO);
	}
	else
	{
	    /*
	     * Get Transaction Type Details
	     */
	    CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO();
	    ctsTrxTypeVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	    ctsTrxTypeVO.setCODE(entityChargesCO.getTrxType());

	    ctsTrxTypeVO = coreCommonBO.findTrxType(ctsTrxTypeVO);

	    accountPositionCO.setCtsTrxTypeVO(ctsTrxTypeVO);
	}
	
	
	/*
	 * Get Available Balance
	 */
	accountPositionCO.setLoginCompCode(entityChargesCO.getLoginCompCode());
	accountPositionCO.setBaseCurrencyCode(entityChargesCO.getBaseCurrencyCode());
	accountPositionCO.getAmfVO().setCUR_AC_BR(amfVO.getBRANCH_CODE());
	accountPositionCO.getAmfVO().setCUR_AC_CY(amfVO.getCURRENCY_CODE());
	accountPositionCO.getAmfVO().setCUR_AC_GL(amfVO.getGL_CODE());
	accountPositionCO.getAmfVO().setCUR_AC_CIF(amfVO.getCIF_SUB_NO());
	accountPositionCO.getAmfVO().setCUR_AC_SL(amfVO.getSL_NO());

	
	BigDecimal availableBalance = BigDecimal.ZERO;
	availableBalance = new BigDecimal(coreCommonProcedureBO.returnAvlBalBR(accountPositionCO).doubleValue());
	
	if(accountPositionCO.getAmfVO().getAC_SIGN() == null)
	{
	    accountPositionCO.getAmfVO().setAC_SIGN(TrxMgntConstant.ACCOUNT_SIGN_CREDIT);
	}
	
	if(accountPositionCO.getAmfVO().getAC_SIGN().equals(TrxMgntConstant.ACCOUNT_SIGN_CREDIT))
	{
	    availableBalance = availableBalance.negate();
	}
	
	/*
	 * Get Covering Balance
	 */
	accountPositionCO.setAvailBalance(availableBalance);
	accountPositionCO.setLoginBraCode(entityChargesCO.getLoginBraCode());
	accountPositionCO.setLoginUserId(entityChargesCO.getLoginUserId());
	accountPositionCO.setRunningDate(entityChargesCO.getRunningDate());
	accountPositionCO.setLanguage(entityChargesCO.getLanguage());
	
	AccountPositionCO accPosCO = coreCommonProcedureBO.returnCoveringBalance(accountPositionCO);

	if(NumberUtil.nullToZero(accPosCO.getErrorCode()).intValue() < 0)
	{
	    throw new BOException(MessageCodes.EMPTY_MESSAGE, new String[] { accPosCO.getErrorCode().toString(), accPosCO.getErrorMsg() });
	}

	if(accPosCO.getCoveringBalance() != null && accPosCO.getCoveringBalance().compareTo(BigDecimal.ZERO) > 0)
	{
	    availableBalance = availableBalance.add(accPosCO.getCoveringBalance());
	}

	
	return availableBalance;
	    
    }
    
    /**
     * Sets the From & To accounts for the Charges Transaction to be created based on Deduct By flag
     * 
     * @author Reda Charabaty
     * @param   TrxMgntCO
     *       		ctstrsVO.getCASH_DEDUCT_IND()					Cash Deduct Indicator
     * 			ctstrsVO.getCH_AC_BR()						Charge Account Branch
     * 			ctstrsVO.getCH_AC_CY()						Charge Account Currency
     * 			ctstrsVO.getCH_AC_GL()						Charge Account GL
     * 			ctstrsVO.getCH_AC_CIF()						Charge Account CIF
     * 			ctstrsVO.getCH_AC_SL()						Charge Account SL
     * 			ctstrsVO.getBRANCH_CODE()					Transaction Branch Code
     * 			ctstrsVO.getTRS_CY()						Transaction Currency
     * 			ctstrsVO.getCOMP_CODE()						Transaction Company Code
     * 			ctstrsVO.getTELLER_CODE()					Teller Code
     * 			ctstrsVO.getTRX_TYPE()						Transaction Type
     * 			ctstrxtypeVO.getMULTI_TRX()					Multi Trx Flag
     * 			chargeSchema							Charge Schema
     * 			reference							Refers to Entity Type ('SAF','CHQ','PAS','LOS','CAR')
     * 			language							Language
     * 
     * 		EntityChargesCO
     *       		ctsChargesEntityCOs						Charges Grid (1st line)
     * 			ctsChargesEntityCOs.get(0).getCtsChargesVO().getACC_GL()	Charge Account GL
     * 			ctsChargesEntityCOs.get(0).getCtsChargesVO().getACC_CIF()	Charge Account CIF
     * 			ctsChargesEntityCOs.get(0).getCtsChargesVO().getACC_SL()	Charge Account SL
     * 			loginCompCode							Login Company Code
     * 			loginBraCode							Login Branch Code
     * 
     * 
     * @return TrxMgntCO
     * 
     * @throws BaseException
     */
    public TrxMgntCO calculateFromToAccounts(TrxMgntCO trxMgntCO1, EntityChargesCO entityChargesCO) throws BaseException
    {
	TrxMgntCO trxMgntCO = trxMgntCO1;
	/*
	 * If Deduct Charges By Account then use the Charges Account, else use the Teller Account
	 */
	if(EntityChargesConstant.CHARGES_DEDUCT_BY_ACCOUNT.equals(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND()))
	{
	    /*
	     * Use Charges Account
	     */
	    trxMgntCO.getCtstrsVO().setTRS_AC_BR(trxMgntCO.getCtstrsVO().getCH_AC_BR());
	    trxMgntCO.getCtstrsVO().setTRS_AC_CY(trxMgntCO.getCtstrsVO().getCH_AC_CY());
	    trxMgntCO.getCtstrsVO().setTRS_AC_GL(trxMgntCO.getCtstrsVO().getCH_AC_GL());
	    trxMgntCO.getCtstrsVO().setTRS_AC_CIF(trxMgntCO.getCtstrsVO().getCH_AC_CIF());
	    trxMgntCO.getCtstrsVO().setTRS_AC_SL(trxMgntCO.getCtstrsVO().getCH_AC_SL());

	    trxMgntCO.getTrxChargesCO().setChargeBranch(trxMgntCO.getCtstrsVO().getCH_AC_BR());

	    /*
	     * Set Account based on Transaction Type is Multi Transfer or not
	     */
	    if(trxMgntCO.getCtstrxtypeVO().getMULTI_TRX() == null || trxMgntCO.getCtstrxtypeVO().getMULTI_TRX().equals(ConstantsCommon.ZERO))
	    {
		/*
		 * If not Multi-Trx Transaction
		 */
//		trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(trxMgntCO.getCtstrsVO().getBRANCH_CODE());
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_CY(trxMgntCO.getCtstrsVO().getTRS_CY());

		if(entityChargesCO.getCtsChargesEntityCOs() != null
		
		    &&entityChargesCO.getCtsChargesEntityCOs().size() > 0)
		    {
			CTSCHARGES_SCHEMAVO ctsChargesSchemaVO = new CTSCHARGES_SCHEMAVO();
			ctsChargesSchemaVO.setCOMP_CODE(trxMgntCO.getCtstrsVO().getCOMP_CODE());
			ctsChargesSchemaVO.setCODE(trxMgntCO.getChargeSchema());
			ctsChargesSchemaVO.setLINE_NO(BigDecimal.ONE);

			ctsChargesSchemaVO = (CTSCHARGES_SCHEMAVO) genericDAO.selectByPK(ctsChargesSchemaVO);

			if(ctsChargesSchemaVO != null)
			{
			    CTSCHARGESVO ctsChargesVO = new CTSCHARGESVO();
			    ctsChargesVO.setCOMP_CODE(trxMgntCO.getCtstrsVO().getCOMP_CODE());
			    ctsChargesVO.setCODE(ctsChargesSchemaVO.getCHARGE_CODE());

			    ctsChargesVO = (CTSCHARGESVO) genericDAO.selectByPK(ctsChargesVO);

			    entityChargesCO.getCtsChargesEntityCOs().get(0).setCtsChargesVO(ctsChargesVO);

			    trxMgntCO.getCtstrsVO().setTO_TRS_AC_GL(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesVO().getACC_GL());
			    trxMgntCO.getCtstrsVO().setTO_TRS_AC_CIF(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesVO().getACC_CIF());
			    trxMgntCO.getCtstrsVO().setTO_TRS_AC_SL(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesVO().getACC_SL());
			    trxMgntCO.setCtsChargesVO(ctsChargesVO);
			    getChargeBranchCode(trxMgntCO);
			}
			if(NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrsVO().getTO_TRS_AC_BR()))
			{
			    trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(trxMgntCO.getCtstrsVO().getBRANCH_CODE());
			}
		     
		}
	    }

	    trxMgntCO.getCtstrsVO().setTRSFR_METHOD(TrxMgntConstant.Account_TRSFR);

	}
	else
	{
	    /*
	     * In Case of Chequebook/Passbook, Set From Account as Teller Account, else
	     * if not Chequebook/Passbook, Use the one already set
	     */
	    if(trxMgntCO.getReference().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK) ||
		    trxMgntCO.getReference().equals(EntityChargesConstant.ENTITY_PASSBOOK) ||
		    trxMgntCO.getReference().equals(EntityChargesConstant.ENTITY_SMS) ||
		    trxMgntCO.getReference().equals(EntityChargesConstant.ENTITY_ADD_PAYMENT))
	    {
		/*
		 * Use Teller Account
		 */
		trxMgntCO = calculateTellerAccount(trxMgntCO, entityChargesCO);
	    }

	    /*
	     * Set To Account as Charge Account
	     */
	    CTSCHARGES_SCHEMAVO ctsChargesSchemaVO = new CTSCHARGES_SCHEMAVO();
	    ctsChargesSchemaVO.setCOMP_CODE(trxMgntCO.getCtstrsVO().getCOMP_CODE());
	    ctsChargesSchemaVO.setCODE(trxMgntCO.getChargeSchema());
	    ctsChargesSchemaVO.setLINE_NO(BigDecimal.ONE);

	    ctsChargesSchemaVO = (CTSCHARGES_SCHEMAVO) genericDAO.selectByPK(ctsChargesSchemaVO);

	    if(ctsChargesSchemaVO != null)
	    {
		CTSCHARGESVO ctsChargesVO = new CTSCHARGESVO();
		ctsChargesVO.setCOMP_CODE(trxMgntCO.getCtstrsVO().getCOMP_CODE());
		ctsChargesVO.setCODE(ctsChargesSchemaVO.getCHARGE_CODE());

		ctsChargesVO = (CTSCHARGESVO) genericDAO.selectByPK(ctsChargesVO);

		trxMgntCO.getCtstrsVO().setTO_TRS_AC_GL(ctsChargesVO.getACC_GL());
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_CIF(ctsChargesVO.getACC_CIF());
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_SL(ctsChargesVO.getACC_SL());
		trxMgntCO.setCtsChargesVO(ctsChargesVO);
		getChargeBranchCode(trxMgntCO);
	    }

	    if(NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrsVO().getTO_TRS_AC_BR()))
	    {
	    trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(trxMgntCO.getCtstrsVO().getBRANCH_CODE());
	    }
	    trxMgntCO.getCtstrsVO().setTO_TRS_AC_CY(trxMgntCO.getCtstrsVO().getTRS_CY());
	    
	    /*
	     * In Case of Lost & Found, deduct from Account (TP#235373)
	     * 28/10/2014 Reda
	     */
	    if(trxMgntCO.getReference().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK) ||
		    trxMgntCO.getReference().equals(EntityChargesConstant.ENTITY_PASSBOOK) ||
		    trxMgntCO.getReference().equals(EntityChargesConstant.ENTITY_SMS))
	    {

		trxMgntCO.getCtstrsVO().setTRSFR_METHOD(TrxMgntConstant.CASH_TRSFR);
	    }
	    else 
	    {
		trxMgntCO.getCtstrsVO().setTRSFR_METHOD(TrxMgntConstant.Account_TRSFR);
	    }

	}
	
	return trxMgntCO;
    }
    
    public TrxMgntCO getChargeBranchCode(TrxMgntCO trxMgntCO) throws BaseException
    {
	if("0".equals(StringUtil.nullToEmpty(trxMgntCO.getCtsChargesVO().getCHRG_BR())))
	{
	    if(trxMgntCO.getPthCtrlVO() != null
		    && "A".equals(StringUtil.nullToEmpty(trxMgntCO.getPthCtrlVO().getCHARGES_BR_BOOKING())))
	    {
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(trxMgntCO.getCtstrsVO().getTRS_AC_BR());
	    }
	    else
	    {
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(trxMgntCO.getCtstrsVO().getBRANCH_CODE());
	    }
	}
	else if("2".equals(StringUtil.nullToEmpty(trxMgntCO.getCtsChargesVO().getCHRG_BR())))
	{
	    trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(trxMgntCO.getCtstrsVO().getTRS_AC_BR());
	}
	else if("3".equals(StringUtil.nullToEmpty(trxMgntCO.getCtsChargesVO().getCHRG_BR())))
	{
	    trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(trxMgntCO.getCtsChargesVO().getACC_BR());
	}
	else
	{
	    trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(trxMgntCO.getCtstrsVO().getBRANCH_CODE());
	}
	return trxMgntCO;
    }
    
    /**
     * Calculates and sets the Transaction Amount to be used in the Charge Transaction
     * 
     * @author Reda Charabaty
     * @param   TrxMgntCO
     * 		EntityChargesCO
     * 
     * 
     * @return TrxMgntCO
     * 
     * @throws BaseException
     */
    public TrxMgntCO calculateTransactionAmounts(TrxMgntCO trxMgntCO, EntityChargesCO entityChargesCO1) throws BaseException
    {
	EntityChargesCO entityChargesCO = entityChargesCO1;
	PTH_CTRLVO pthCtrlVO = commonLibBO.returnPthCtrl();

	/*
	 * If Charges already supplied, use them to calculate amounts, else
	 * select from database
	 */
	if(entityChargesCO.getCtsChargesEntityCOs() != null && entityChargesCO.getCtsChargesEntityCOs().size() > 0)
	{
	    BigDecimal amount = BigDecimal.ZERO;
	    BigDecimal amountFC = BigDecimal.ZERO;

	    /*
	     * Calculate Amounts
	     */
	    for(int i = 0; i < entityChargesCO.getCtsChargesEntityCOs().size(); i++)
	    {
		amount = amount.add(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT());
		amountFC = amountFC.add(NumberUtil.nullToZero(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT_FC()));

		/*
		 * VAT Amounts
		 */
		if(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO() != null)
		{
		    if(NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT()) != null)
		    {
			amount = amount.add(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT());
		    }

		    if(NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC()) != null)
		    {
			amountFC = amountFC.add(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC());
		    }
		}
	    }
	    
	    amount = amount.setScale(3,BigDecimal.ROUND_HALF_UP);
	    amountFC = amountFC.setScale(3,BigDecimal.ROUND_HALF_UP);
		

	    /*
	     * Set Amounts
	     */
	    if(pthCtrlVO.getCHARGES_BOOKING().equals(EntityChargesConstant.CHARGES_BOOKING_A))
	    {
		trxMgntCO.getCtstrsVO().setAMOUNT(amountFC);
	    }
	    else
	    {
		trxMgntCO.getCtstrsVO().setAMOUNT(amount);
	    }
		
	    if(trxMgntCO.getCtstrsVO().getTRS_AC_CY().equals(trxMgntCO.getBaseCurrencyCode()))
	    {
		 trxMgntCO.getCtstrsVO().setTRS_AC_AMOUNT(amount);
	    }
	    else
	    {
		trxMgntCO.getCtstrsVO().setTRS_AC_AMOUNT(amountFC);
	    }
	   
	    trxMgntCO.getCtstrsVO().setCV_AMOUNT(amount);

	}
	else
	{

	    /*
	     * Get Sum of Charges to set Transaction Amount
	     */
	    entityChargesCO.setLoginCompCode(trxMgntCO.getCtstrsVO().getCOMP_CODE());
	    entityChargesCO.setLoginBraCode(trxMgntCO.getCtstrsVO().getBRANCH_CODE());
	    entityChargesCO.setEntityType(trxMgntCO.getTrxChargesCO().getEntityType());
	    entityChargesCO.setEntityCode(trxMgntCO.getEntityCode());
	    entityChargesCO.setTypeInd(trxMgntCO.getCrud());

	    entityChargesCO = retrieveSumsOfChargesAmount(entityChargesCO);

//	    if(pthCtrlVO.getCHARGES_BOOKING().equals(EntityChargesConstant.CHARGES_BOOKING_A))
//	    {
		trxMgntCO.getCtstrsVO().setAMOUNT(entityChargesCO.getTotalAllAmountFc());
//	    }
//	    else
//	    {
//		trxMgntCO.getCtstrsVO().setAMOUNT(entityChargesCO.getTotalAllAmount());
//	    }
	    trxMgntCO.getCtstrsVO().setTRS_AC_AMOUNT(entityChargesCO.getTotalAllAmountFc());
	    trxMgntCO.getCtstrsVO().setCV_AMOUNT(entityChargesCO.getTotalAllAmount());
	}

	return trxMgntCO;
    }
    
    /**
     * Calculate the available balance and compare it with the transaction amount in order to check if amount exceeds available balance
     * 
     * @author Reda Charabaty
     * @param   EntityChargesCO
     * 
     * 
     * @return EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO checkAmountExceedsAvailableBalance(EntityChargesCO entityChargesCO1) throws BaseException
    {
	EntityChargesCO entityChargesCO = entityChargesCO1;
	if(entityChargesCO.getCtsChargesEntityCOs() == null ||
		entityChargesCO.getCtsChargesEntityCOs().size() == 0)
	{
	    return entityChargesCO;
	}
	/*
	 * If Trx Type Not Defined, then return
	 */
	if(entityChargesCO.getTrxType() == null || 
		entityChargesCO.getTrxType().intValue() == 0)
	{
	    return entityChargesCO;
	}
	
	/*
	 * Calculate Total Charges
	 */
	if(!EntityChargesConstant.ENTITY_SAFEBOX.equals(entityChargesCO.getEntityCommand())
		&& (!EntityChargesConstant.ENTITY_SAFEBOX.equals(entityChargesCO.getEntityType()) || !EntityChargesConstant.ENTITY_COMMAND_CONFIRMATION_MESSAGE.equals(entityChargesCO.getEntityCommand())))
	{
	    entityChargesCO = retrieveTotalCharges(entityChargesCO);
	}
	
	if(entityChargesCO.getTotalAllAmountFc() == null || entityChargesCO.getTotalAllAmountFc().compareTo(BigDecimal.ZERO) <= 0)
	{
	    return entityChargesCO;
	}
	
	
	/*
	 * MBSI200068 - Stopping Message for Card Issuance in case of Insufficient Balance - Reda - 24/09/2020
	 */
	CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
	ctsControlVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	ctsControlVO.setBRANCH_CODE(entityChargesCO.getLoginBraCode());
	ctsControlVO = commonLibBO.returnCtsControlDetails(ctsControlVO);
	
	if(ctsControlVO == null)
	{
	    ctsControlVO = new CTSCONTROLVO();
	}
	
	/*
	 * JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659 
	 * CALCULATE SUM OF TOTAL DUES AND SEND IT AS ARGUMENT TO THE PROCEDURE TO VALIDATE IF
	 * ACCOUNT HAS AVAIL BAL OR DUES CHARGES TO BE LOGGED
	 */
	if(entityChargesCO.getCtsChargesEntityCOs() != null)
	{
	    //Rania - #931037 - system is generating error message while approving SMS subscription
	    entityChargesCO.setDuesTotalAmount(BigDecimal.ZERO);
	    entityChargesCO.setDuesTotalAmountFc(BigDecimal.ZERO);
	    //
	    
	    for(int i = 0; i < entityChargesCO.getCtsChargesEntityCOs().size(); i++)
	    {
		if(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO() != null
		&&
		    
		    (!entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getDUES_COLLECTION_TYPE().equals(EntityChargesConstant.DUES_COLLECTION_TYPE)))// if it's of type DUES
		{
		    if(NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT()) != null
			    && NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT_FC()) != null)
		    {
			    entityChargesCO.setDuesTotalAmount(NumberUtil.nullToZero(
				    entityChargesCO.getDuesTotalAmount())
				    .add(
					    entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT()));
			    entityChargesCO.setDuesTotalAmountFc(NumberUtil.nullToZero(
				    entityChargesCO.getDuesTotalAmountFc()).add(
				    entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT_FC()));
		    }
		    if(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO() != null
			    &&(NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT()) != null
				    && NumberUtil.emptyDecimalToNull(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC()) != null))
		    {
			entityChargesCO.setDuesTotalAmount(NumberUtil.nullToZero(entityChargesCO.getDuesTotalAmount())
				.add(
					entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT()));
			entityChargesCO.setDuesTotalAmountFc(NumberUtil.nullToZero(
				entityChargesCO.getDuesTotalAmountFc()).add(
				entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC()));
		    }
			
		}

		
	    }

	}
	/*
	 * we need to send the total charge amount without dues (TotalAllAmount and TotalAllAmountFc)
	 * and total dues amount to calculate transaction amount and to log dues when no avail balance
	 * we will deduct the Dues amount from TotalAllAmount and TotalAllAmountFc,
	 * in case of products with multi charges (ex: chqbook, num chqbook = 5 => 5*total charge) 
	 */
	 if (entityChargesCO.getNumOfEntities() != null && entityChargesCO.getNumOfEntities().compareTo(BigDecimal.ONE) > 0 &&
		 entityChargesCO.getDuesTotalAmount() != null && entityChargesCO.getDuesTotalAmountFc() != null)
	 {
	     entityChargesCO.setDuesTotalAmount(entityChargesCO.getDuesTotalAmount().multiply(entityChargesCO.getNumOfEntities()));
	     entityChargesCO.setDuesTotalAmountFc(entityChargesCO.getDuesTotalAmountFc().multiply(entityChargesCO.getNumOfEntities()));
	 }
	 
	 if ( entityChargesCO.getTotalAllAmount()!= null && entityChargesCO.getTotalAllAmountFc()!= null && 
	      entityChargesCO.getDuesTotalAmount() != null && entityChargesCO.getDuesTotalAmountFc() != null) 
	 {
	     //in case of safebox we need to consider charges by type (rental, stamp, inssurance)
	     if(EntityChargesConstant.ENTITY_SAFEBOX.equals(entityChargesCO.getEntityCommand()) &&
		entityChargesCO.getTotalAmount()!= null && entityChargesCO.getTotalAmountFc()!= null)
	     {

		 entityChargesCO.setTotalAmount(entityChargesCO.getTotalAmount().subtract(entityChargesCO.getDuesTotalAmount()));
		 entityChargesCO.setTotalAmountFc(entityChargesCO.getTotalAmountFc().subtract(entityChargesCO.getDuesTotalAmountFc()));
		 
		 entityChargesCO.setTotalAllAmount(entityChargesCO.getTotalAmount());
		 entityChargesCO.setTotalAllAmountFc(entityChargesCO.getTotalAmountFc()); 
	     }
	     else
	     {
		 entityChargesCO.setTotalAllAmount(entityChargesCO.getTotalAllAmount().subtract(NumberUtil.nullToZero (entityChargesCO.getDuesTotalAmount())));
		 entityChargesCO.setTotalAllAmountFc(entityChargesCO.getTotalAllAmountFc().subtract(NumberUtil.nullToZero (entityChargesCO.getDuesTotalAmountFc()))); 
	     }
	   
	 }
	
	
	
	/*
	 * end JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659
	 */
	 
	/*
	 * Get Available & Covering Balance
	 */
//	entityChargesCO.setAvailBalance(returnAvailableBalance(entityChargesCO));
	
	
	   
		// added by nancy -- 06/07/2018-- 382769-- account limits 
		BigDecimal sessionID;
		CommonLibCO commonLibCO = commonLibBO.returnDBSessionDetails();
		String appendedSession = commonLibCO.getDbSessionId().toString().concat(commonLibCO.getDbNode());
		sessionID = new BigDecimal(appendedSession);
		CtstrsConfMsgSC confMsgSC = new CtstrsConfMsgSC();
		confMsgSC.setUser_id(entityChargesCO.getLoginUserId()); //sandra
		confMsgSC.setSessionId(sessionID);
		CTSTRS_CONF_MSGVO confMsgVO = new CTSTRS_CONF_MSGVO();
		confMsgVO.setUSER_ID(entityChargesCO.getLoginUserId()); //sandra
		confMsgVO.setDB_SESSION_ID(sessionID);
		// end nancy	    
	    
		if(EntityChargesConstant.ENTITY_COMMAND_CONFIRMATION_MESSAGE.equals(entityChargesCO.getEntityCommand()))
		{		    
		    genericDAO.delete(confMsgVO);		 
		}
		
		// end added by nancy -- 06/07/2018-- 382769-- account limits
		
	TrxMgntSC trxMgntSC = checkAmountRestriction(entityChargesCO);

	if(trxMgntSC != null)
	{
	    
	    if(EntityChargesConstant.ENTITY_COMMAND_CONFIRMATION_MESSAGE.equals(entityChargesCO.getEntityCommand()))
	    {
		if(NumberUtil.nullToZero(trxMgntSC.getErrorCode()).compareTo(BigDecimal.ZERO) >= 0)
		{

		    int count = coreCommonServiceBO.returncountConfMsg(confMsgSC); //sandra
		    //int count = coreCommonTrxBO.returncountConfMsg(confMsgSC); //sandra
		    if(count > 0)
		    //if(MessageCodes.WARNING_CHECK_ONE_OBLIGOR.compareTo(trxMgntSC.getErrorCode().intValue()) == 0 || MessageCodes.ONE_OBLIGOR_CIF_CAPITAL_LIMIT_BREACHED_BY_PARAM_PROCEED.compareTo(trxMgntSC.getErrorCode().intValue()) == 0)
		    {
			List<CTSTRS_CONF_MSGVO> cstTrsConfMsgList = new ArrayList<CTSTRS_CONF_MSGVO>();
			cstTrsConfMsgList = coreCommonServiceBO.returnConfMsg(confMsgSC);
			String confMsg = "";
			for(int i = 0; i < cstTrsConfMsgList.size(); i++)
			{
				if (i == 0) //sandra
				{
				    confMsg = confMsg.concat(cstTrsConfMsgList.get(i).getCONF_MSG());
				    confMsg = confMsg.concat("\n");
				}
				else
				{
				    confMsg = confMsg.concat("\n").concat(cstTrsConfMsgList.get(i).getCONF_MSG());  
				}			    
			}

			confMsg = confMsg.concat("\n");
			throw new BOException(MessageCodes.CONFIRMATON_MESSAGES, new String[] {confMsg}, ConstantsCommon.CONFIRM_MSG_TYPE,entityChargesCO); //SANDRA
				
			    
		    	//trxMgntCO.setConfirmationCode(trxMgntSC.getErrorCode().intValue());
		    	//throw new BOException(trxMgntSC.getErrorCode().intValue(),new String[] {NumberUtil.roundToBigDecimal(NumberUtil.nullEmptyToValue(trxMgntSC.getOverDrawnAmountFr(),BigDecimal.ZERO).abs(),NumberUtil.nullEmptyToValue(entityChargesCO.getBaseCurrDecPoint(),new BigDecimal(3)).intValue()).toString() },ConstantsCommon.CONFIRM_MSG_TYPE, "ONE_OBLIGOR", entityChargesCO);
		    }
		}
	    }
	    else
	    {
//		if(TrxMgntConstant.ERROR.equals(trxMgntSC.getErrType())
//			|| NumberUtil.nullToZero(trxMgntSC.getErrorCode()).compareTo(BigDecimal.ZERO) < 0)
//		{
//		    throw new BOException(trxMgntSC.getErrorMessage());
//		}
//	    

	    
	    //Elias Aoun - setting erroCode = 0 in case it is null just to avoid null checking [should be managed
	    //JIHANE add "condition on 'error' ErrType ", in case multi warning msg returned.
	    trxMgntSC.setErrorCode(NumberUtil.nullEmptyToValue(trxMgntSC.getErrorCode(), BigDecimal.ZERO));
		if(("1".equals(trxMgntSC.getOverDrawnVoid()) || "2".equals(trxMgntSC.getOverDrawnVoid())
			|| (null != trxMgntSC.getErrorCode() && MessageCodes.AMOUNT_EXCEED_AVAIL_BAL.compareTo(trxMgntSC.getErrorCode().abs().intValue()) == 0))
		&& (TrxMgntConstant.ERROR.equals(trxMgntSC.getErrType())) )
	    {
		String account;
		AMFVO amfVO = chooseChargeAccount(entityChargesCO);
	
		account = "0000".substring(amfVO.getBRANCH_CODE().toString().length()) + amfVO.getBRANCH_CODE().toString() + '-'
			+ "000".substring(amfVO.getCURRENCY_CODE().toString().length()) + amfVO.getCURRENCY_CODE().toString() + '-'
			+ "000000".substring(amfVO.getGL_CODE().toString().length()) + amfVO.getGL_CODE().toString() + '-'
			+ "00000000".substring(amfVO.getCIF_SUB_NO().toString().length()) + amfVO.getCIF_SUB_NO().toString() + '-'
			+ "000".substring(amfVO.getSL_NO().toString().length()) + amfVO.getSL_NO().toString();
		
		if(EntityChargesConstant.CONFIRMSTOP_STOP.equals(entityChargesCO.getConfirmStop()))
		{
		    //comment this flag after applying the modif AUBBH120024, because it is covered in the proc
//		    int allowOverdraw = checkAllowOverdraw(entityChargesCO);
//
//		    /*
//		     * If internal then don't check
//		     */
//		    if(allowOverdraw == 0)
//		    {
//			return entityChargesCO;
//		    }
//
//		    if(allowOverdraw < 0)
//		    {
//			throw new BOException(MessageCodes.AMOUNT_EXCEED_AVAIL_BAL, new String[] { account });
			entityChargesCO.setLanguage(StringUtil.nullEmptyToValue(entityChargesCO.getLanguage(), "EN"));
			

			String amountExceed = commonLibBO.returnTranslMessageOnly(MessageCodes.AMOUNT_EXCEED_AVAIL_BAL, new String[] { account }, entityChargesCO.getLanguage());
			String waiveCharges = "\n".concat(commonLibBO.returnTranslMessageOnly(MessageCodes.PLEASE_WAIVE_CHARGES_TO_CONTINUE, entityChargesCO.getLanguage()));

			// throw new BOException(MessageCodes.EMPTY_MESSAGE,new String[]{"Cannot_Proceed",entityType.concat(" \n").concat(trxMgntSC.getErrorMessage().concat(waiveCharges))});

			BOException bo;
			
			
			/*
			 * MBSI200068 - Stopping Message for Card Issuance in case of Insufficient Balance - Reda - 24/09/2020
			 */
			if(ctsControlVO != null 
					&& "1".equals(ctsControlVO.getSTOP_PROD_PROC_INSUF_BAL_YN())
					&& null != trxMgntSC.getErrorCode()
					&& MessageCodes.AMOUNT_EXCEED_AVAIL_BAL.compareTo(trxMgntSC.getErrorCode().abs().intValue()) == 0)
			{
			    bo = new BOException(MessageCodes.AMOUNT_EXCEED_AVAIL_BAL, new String[] { account });
			}
			else
			{
			    bo = new BOException(amountExceed.concat(waiveCharges));
			}
			    
			bo.setMsgTitleKey("Cannot_Proceed");
			throw bo;
			
			
//		    }
//		       else
//		    {
//			if(trxMgntSC.getErrorMessage() != null)
//			{
//				entityChargesCO.setWarningMessage(trxMgntSC.getErrorMessage());
//			}
//		    }
		    }
		    else if(EntityChargesConstant.CONFIRMSTOP_CONFIRM.equals(entityChargesCO.getConfirmStop()))
		    {
			throw new BOException(MessageCodes.AMOUNT_EXCEEDS_AVAILABLE_BALANCE, new String[] { account },ConstantsCommon.CONFIRM_MSG_TYPE);
		    }
		    else  if(EntityChargesConstant.CONFIRMSTOP_WARN.equals(entityChargesCO.getConfirmStop())) // Added Case for no message to be outputted (ex: Web Service)
		    {
			
			entityChargesCO.setLanguage(StringUtil.nullEmptyToValue(entityChargesCO.getLanguage(), "EN"));
			
			String amountExceed = commonLibBO.returnTranslMessageOnly(MessageCodes.AMOUNT_EXCEED_AVAIL_BAL, new String[] { account }, entityChargesCO.getLanguage());

			entityChargesCO.setWarningMessage(amountExceed);
		    }

		    }
		       else
		    {
		    //FALHA: Moving fill the duescreate trx here(advised by reda) to fill dues instead of trx
		   // id:885216 Details:System is generating error while approving Safebox
		    /*
		     * JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659 
		     * save return result from the procedure to decide weither to insert dues without create transaction from product screen
		     * or cotinue transaction creation and dues logging
		     */
		    if (null != trxMgntSC.getOs_s_string())
		    {
			// TONY NOUH User Story#315732 AMANA130105 Overdraft Products
			String os_s_string = trxMgntSC.getOs_s_string();
			os_s_string = StringUtil.replaceInString(os_s_string, TrxMgntConstant.ALERT_OVER_DRAWN_AMT, "");
			os_s_string = StringUtil.replaceInString(os_s_string, TrxMgntConstant.ALERT_IIS_OVERDUE_INST, "");
			os_s_string = StringUtil.removeNewLineTabSpace(os_s_string);
			// END TONY NOUH User Story#315732 AMANA130105 Overdraft Products
			entityChargesCO.setLogDuesCreateTrx(os_s_string);
		    }
		    //id:885216 Details:System is generating error while approving Safebox
		    if(TrxMgntConstant.WARNING.equals(trxMgntSC.getErrType()) && trxMgntSC.getErrorMessage() != null)
		    {
			if(trxMgntSC.getErrorMessage() != null)
			{
			    entityChargesCO.setWarningMessage(trxMgntSC.getErrorMessage());
			}

    		    
		}
		else if(TrxMgntConstant.ERROR.equals(trxMgntSC.getErrType()))
		{
		    String entityType;
		    
		    /*
		     * In case of Safebox, add Charge Type
		     */
		    if(entityChargesCO.getChargeType() == null)
		    {
			entityType = "";
		    }
		    else
		    {
			if(EntityChargesConstant.SAFEBOX_CHARGES_RENTAL.equals(entityChargesCO.getChargeType()))
			{
			    entityType = "Safebox_Rental_Charges_Msg_key";
			}
			    else if(EntityChargesConstant.SAFEBOX_CHARGES_INSURANCE
				    .equals(entityChargesCO.getChargeType()))
			{
			    entityType = "Safebox_Insurance_Charges_Msg_Key";
			}
			else if(EntityChargesConstant.SAFEBOX_CHARGES_STAMP.equals(entityChargesCO.getChargeType()))
			{
			    entityType = "Safebox_Stamp_Charges_Msg_Key";
			}
			else
			{
			    entityType = "";
			}
		    }
		    
		    
			String waiveCharges = "\n".concat(commonLibBO.returnTranslMessageOnly(MessageCodes.PLEASE_WAIVE_CHARGES_TO_CONTINUE,entityChargesCO.getLanguage()));
		    
		    //throw new BOException(MessageCodes.EMPTY_MESSAGE,new String[]{"Cannot_Proceed",entityType.concat("  \n").concat(trxMgntSC.getErrorMessage().concat(waiveCharges))});
		    
			BOException bo;
		    
			/*
			 * MBSI200068 - Stopping Message for Card Issuance in case of Insufficient Balance - Reda - 24/09/2020
			 */
			if(ctsControlVO != null 
				&& "1".equals(ctsControlVO.getSTOP_PROD_PROC_INSUF_BAL_YN())
				&& null != trxMgntSC.getErrorCode()
				&& MessageCodes.AMOUNT_EXCEED_AVAIL_BAL.compareTo(trxMgntSC.getErrorCode().abs().intValue()) == 0)
			{
			    bo = new BOException(MessageCodes.EMPTY_MESSAGE,new String[] { "", StringUtil.nullToEmpty(entityType).concat("\n").concat(trxMgntSC.getErrorMessage()) });
			}
			else
			{
			    bo = new BOException(MessageCodes.EMPTY_MESSAGE,new String[] { "", StringUtil.nullToEmpty(entityType).concat("\n").concat(trxMgntSC.getErrorMessage().concat(waiveCharges)) });
			}
			
			bo.setMsgTitleKey("Cannot_Proceed");
			throw bo;
		    }
		}
	    }
	}
		
//	if(entityChargesCO.getTotalAllAmountFc().compareTo(entityChargesCO.getAvailBalance()) > 0)
//	{
//	    int allowOverdraw = checkAllowOverdraw(entityChargesCO);
//	    
//	    /*
//	     * If internal then don't check
//	     */
//	    if(allowOverdraw == 0)
//	    {
//		return entityChargesCO;
//	    }
//
//	    String account;
//	    AMFVO amfVO = chooseChargeAccount(entityChargesCO);
//		
//	    account = "0000".substring(amfVO.getBRANCH_CODE().toString().length()) + amfVO.getBRANCH_CODE().toString() + '-'
//			+ "000".substring(amfVO.getCURRENCY_CODE().toString().length()) + amfVO.getCURRENCY_CODE().toString() + '-'
//			+ "000000".substring(amfVO.getGL_CODE().toString().length()) + amfVO.getGL_CODE().toString() + '-'
//			+ "00000000".substring(amfVO.getCIF_SUB_NO().toString().length()) + amfVO.getCIF_SUB_NO().toString() + '-'
//			+ "000".substring(amfVO.getSL_NO().toString().length()) + amfVO.getSL_NO().toString();
//		    
//	    if(EntityChargesConstant.CONFIRMSTOP_STOP.equals(entityChargesCO.getConfirmStop()) && allowOverdraw < 0)
//	    {
//		throw new BOException(MessageCodes.AMOUNT_EXCEED_AVAIL_BAL, new String[] { account });
//	    }
//	    else
//	    {
//		throw new BOException(MessageCodes.AMOUNT_EXCEEDS_AVAILABLE_BALANCE, new String[] { account },
//			ConstantsCommon.CONFIRM_MSG_TYPE);
//	    }		
//	    
//	}
	
	
	return entityChargesCO;
    }
    
    /**
     * Returns the Charge Account to be used, based on Deduct Charges flag
     * 
     * @author Reda Charabaty
     * @param   EntityChargesCO
     * 			deductCharges			Deduct Charges flag in Case it exists
     * 			accBranch			Main Account Branch
     * 			accCurrency			Main Account Currency
     * 			accGL				Main Account GL
     * 			accCIF				Main Account CIF
     * 			accSL				Main Account SL
     * 			chargeAccBranch			Charge Account Branch 
     * 			chargeAccCurrency		Charge Account Currency
     * 			chargeAccGL			Charge Account GL
     * 			chargeAccCIF			Charge Account CIF
     * 			chargeAccSL			Charge Account SL
     * 		
     * 
     * @return AMFVO
     * 
     * @throws BaseException
     */
    public AMFVO chooseChargeAccount(EntityChargesCO entityChargesCO) throws BaseException
    {
	AMFVO amfVO = new AMFVO();
	
	if(entityChargesCO.getDeductCharges() == null || entityChargesCO.getDeductCharges().trim().equals(EntityChargesConstant.VALUE_EMPTY)
		|| entityChargesCO.getDeductCharges().trim().equals(ConstantsCommon.ZERO)
		|| entityChargesCO.getDeductCharges().equals(EntityChargesConstant.CHARGES_DEDUCT_BY_CASH))
	{
	    amfVO.setBRANCH_CODE(entityChargesCO.getAccBranch());
	    amfVO.setCURRENCY_CODE(entityChargesCO.getAccCurrency());
	    amfVO.setGL_CODE(entityChargesCO.getAccGL());
	    amfVO.setCIF_SUB_NO(entityChargesCO.getAccCIF());
	    amfVO.setSL_NO(entityChargesCO.getAccSL());
	}
	else
	{
	    amfVO.setBRANCH_CODE(entityChargesCO.getChargeAccBranch());
	    amfVO.setCURRENCY_CODE(entityChargesCO.getChargeAccCurrency());
	    amfVO.setGL_CODE(entityChargesCO.getChargeAccGL());
	    amfVO.setCIF_SUB_NO(entityChargesCO.getChargeAccCIF());
	    amfVO.setSL_NO(entityChargesCO.getChargeAccSL());
	}
	
	return amfVO;
    }
    
    /**
     * Checks if Account is allowed to be overdrawn
     * 
     * @author Reda Charabaty
     * @param   EntityChargesCO
     * 
     * 
     * @return int
     * 		-1 in case Not Allowed
     * 		1 in case Allowed
     * 		0 if case Not Applicable
     * 
     * @throws BaseException
     */
    public int checkAllowOverdraw(EntityChargesCO entityChargesCO) throws BaseException
    {
	/*
	 * Choose Account to Charge
	 */
	AMFVO amfVO = chooseChargeAccount(entityChargesCO);
	
	/*
	 * If internal then don't check
	 */
	amfVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	amfVO = (AMFVO)genericDAO.selectByPK(amfVO);
	if(amfVO.getGMI_FLAG() != null && amfVO.getGMI_FLAG().equals(AccountsConstant.INTERNAL_ACCOUNT))
	{
	    return 0;
	}

	/*
	 * Check if Allow Overdrawn on Account Type
	 */
	RIFATTVO rifAttVO = new RIFATTVO();
	rifAttVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	rifAttVO.setTYPE_CODE(amfVO.getGL_CODE());
	rifAttVO = commonLibBO.returnRIFATTInfo(rifAttVO);

	if(rifAttVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_ACCOUNT_TYPE);
	}

	if(rifAttVO.getALLOW_OVERDRAWN() == null)
	{
	    rifAttVO.setALLOW_OVERDRAWN(ConstantsCommon.ZERO);
	}

	/*
	 * Get Transaction Type Details
	 */
	CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO();
	ctsTrxTypeVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	ctsTrxTypeVO.setCODE(entityChargesCO.getTrxType());

	ctsTrxTypeVO = coreCommonBO.findTrxType(ctsTrxTypeVO);

	/*
	 * If not allowed to overdraw account or proceed on insufficient funds,
	 * then raise exception
	 */
	if(ConstantsCommon.ZERO.equals(rifAttVO.getALLOW_OVERDRAWN()) || !ConstantsCommon.ONE.equals(ctsTrxTypeVO.getPROCEED_ON_INSUFF_FUND()))
	{
	    /*
	     * Not Allowed to Overdraw
	     */
	    return -1;
	}

	/*
	 * Allowed to Overdraw
	 */
	return 1;
    }
    
    /**
     * This function will Reverse the charge Transaction
     * 
     * @author Reda Charabaty
     * @param trxMgntSC
     * 
     * 		trxMgntSC.setCompCode()			Company Code
     *          trxMgntSC.setBranchCode()		Branch Code
     *          trxMgntSC.setTrsNo()			Transaction Number to Reverse
     *          trxMgntSC.setIvCrud()			Crud (If not sure, set as TrxMgntConstant.REVERSED_TRX)
     *          trxMgntSC.setSystemDate()		System Date
     *          trxMgntSC.setTellerCode()		Logged In Teller Code
     *          trxMgntSC.setReason()			(Optional)
     * 
     * @return trxMgntSC
     * 		could fill trxMgntSC.setWarningMessages()
     * @throws BaseException
     */
    public TrxMgntSC reverseChargeTrx(TrxMgntSC trxMgntSC) throws BaseException
    {

	TrxMgntSC trxMgntSC1 = coreCommonProcedureBO.reverseCtstrs(trxMgntSC);
		
	
	if(TrxMgntConstant.ERROR.equals(trxMgntSC1.getErrType())
		|| NumberUtil.nullToZero(trxMgntSC1.getErrorCode()).compareTo(BigDecimal.ZERO) < 0)
	{
	    throw new BOException(trxMgntSC1.getErrorMessage());
	}
	if(TrxMgntConstant.WARNING.equals(trxMgntSC1.getErrType())
		|| NumberUtil.nullToZero(trxMgntSC1.getErrorCode()).compareTo(BigDecimal.ZERO) > 0)
	{
	    trxMgntSC.setWarningMessages(trxMgntSC1.getErrorMessage());
	}
	
	return trxMgntSC;
    }

    /**
     * This function will Update the Transaction with necessary entity info on Instructions1 and Reference1 columns
     * 
     * @author Reda Charabaty
     * @param trxMgntCO
     * 
     * 		trxMgntSC.getCompCode()			Company Code
     *          trxMgntSC.getBranchCode()		Branch Code
     *          trxMgntSC.getTrsNo()			Transaction Number to Reverse
     *          trxMgntSC.getInstructions1()		Denotes which entity the Transaction is being created from (CHEQUEBOOK/SAFEBOX/PASSBOOK/CARD REQUEST/Lost & Found Reason
     *          trxMgntSC.getReference()		Denotes which entity the Transaction is being created from (CHQ/CHQ_CANCEL/SB/PAS/CD/CDP/LF
     * 
     * @throws BaseException
     */
    public void updateCTSTRSEntityInfo(TrxMgntSC trxMgntSC) throws BaseException
    {	
	entityChargesDAO.updateCTSTRSEntityInfo(trxMgntSC);
    }

    public TrxTypeBO getTrxTypeBO()
    {
        return trxTypeBO;
    }

    public void setTrxTypeBO(TrxTypeBO trxTypeBO)
    {
        this.trxTypeBO = trxTypeBO;
    }
    
    
    /**
     * Calls procedures to check Limits and balance exceeding 
     * 
     * @author Reda Charabaty 
     * @param  EntityChargesCO
     * 			entityChargesCO.getLoginCompCode()
     * 			entityChargesCO.getLoginBraCode()
     * 			entityChargesCO.getTrxType()
     * 			entityChargesCO.getLoginTellerCode()
     * 			entityChargesCO.getRunningDate()
     * 			entityChargesCO.getTotalAllAmountFc()
     * 			entityChargesCO.getTotalAllAmount()
     * 			entityChargesCO.getDeductCharges()
     * 			entityChargesCO.getAccBranch()
     * 			entityChargesCO.getAccCurrency()
     * 			entityChargesCO.getAccGL()
     * 			entityChargesCO.getAccCIF()
     * 			entityChargesCO.getAccSL()
     * 			entityChargesCO.getChargeAccBranch()
     * 			entityChargesCO.getChargeAccCurrency()
     * 			entityChargesCO.getChargeAccGL()
     * 			entityChargesCO.getChargeAccCIF()
     * 			entityChargesCO.getChargeAccSL()
     * 
     * 
     * @return TrxMgntSC
     * 
     * @throws BaseException
     */
    public TrxMgntSC checkAmountRestriction(EntityChargesCO entityChargesCO) throws BaseException
    {
	
	/*
	 * Set Account Details
	 */
	AMFVO amfVO = chooseChargeAccount(entityChargesCO);
	amfVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	//amfVO.setBRANCH_CODE(entityChargesCO.getLoginBraCode()); /* #685606 */
	amfVO = (AMFVO)genericDAO.selectByPK(amfVO);
	
	if(amfVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CHARGE_ACC);
	}
	
	
	/*
	 * Call Procedure
	 */	
	TrxMgntSC trxMgntSC = new TrxMgntSC();
	trxMgntSC.setCompCode(entityChargesCO.getLoginCompCode());
	trxMgntSC.setBranchCode(entityChargesCO.getLoginBraCode());
	trxMgntSC.setTrxType(entityChargesCO.getTrxType());
	trxMgntSC.setTrsAcBr(amfVO.getBRANCH_CODE());
	trxMgntSC.setTrsAcCy(amfVO.getCURRENCY_CODE());
	trxMgntSC.setTrsAcGl(amfVO.getGL_CODE());
	trxMgntSC.setTrsAcCif(amfVO.getCIF_SUB_NO());
	trxMgntSC.setTrsAcSl(amfVO.getSL_NO());
	trxMgntSC.setTellerCode(entityChargesCO.getLoginTellerCode());
	trxMgntSC.setTrsDate(entityChargesCO.getRunningDate());
	trxMgntSC.setSystemDate(entityChargesCO.getRunningDate());
	
	trxMgntSC.setAppName(entityChargesCO.getAppName());
	trxMgntSC.setLangCode(entityChargesCO.getLanguage());
	trxMgntSC.setUserId(entityChargesCO.getLoginUserId());
	trxMgntSC.setRunningDate(entityChargesCO.getRunningDate());
	trxMgntSC.setTrxAmount(NumberUtil.nullToZero(entityChargesCO.getTotalAllAmountFc()));
	trxMgntSC.setAccAmount(NumberUtil.nullToZero(entityChargesCO.getTotalAllAmountFc()));
	trxMgntSC.setLinkToTrsNoBr(entityChargesCO.getLoginBraCode());
	
	// added by nancy -- 22/05/2018-- Bug 678071
	if(entityChargesCO.getCtsChargesEntityCOs() != null && !entityChargesCO.getCtsChargesEntityCOs().isEmpty())
	{
	    if(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO() != null)
	    {
		trxMgntSC.setToTrsAcCy(entityChargesCO.getCtsChargesEntityCOs().get(0).getCtsChargesEntityVO().getACC_CY());
	    }
	}
	// end nancy 
	
	
	NumberUtil.resetEmptyValues(trxMgntSC);
	
	/*
	 * JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659  
	 * SEND DUES CHARGES
	 * SINCE OTHER CHARGES HAVE "NULL" VALUE FROM PRODUCT SCREEN, AND TO AVOID WRONG CALCULATION WITH 
	 * NULL VALUE WITHIN PROCEDURE (ORACLE VERSION)
	 */
	trxMgntSC.setTotalDuesCVcharge(NumberUtil.nullToZero(entityChargesCO.getDuesTotalAmount()));
	trxMgntSC.setTotalDuesFCcharge(NumberUtil.nullToZero(entityChargesCO.getDuesTotalAmountFc()));
	trxMgntSC.setTotalFCcharge(BigDecimal.ZERO);
	trxMgntSC.setTotalCVcharge(BigDecimal.ZERO);
	trxMgntSC.setIvCrud(entityChargesCO.getCrud());
	
	
	if(EntityChargesConstant.ENTITY_COMMAND_CONFIRMATION_MESSAGE.equals(entityChargesCO.getEntityCommand()))
	{
	    trxMgntSC.setIvCrud(String.format("%1$-" + 7 + "s", trxMgntSC.getIvCrud())); 
	    trxMgntSC.setIvCrud(trxMgntSC.getIvCrud().concat("CF"));

	}
	
	
	
	/*
	 * trxMgntSC.setDeduct is added by Guitta on 20/08/2014 #209540. The cash deduct indicator is sent
	 * as "1" since in trxtypes defined for product charges transactions,
	 * the deduct indicator is usually null, while when checking on dues total charges we should 
	 * consider the dues charges as dues amount to be deducted from the main account
	 */
	trxMgntSC.setDeduct(TrxMgntConstant.DEDUCT_FROM_ACCOUNT);
	//Hasan Bug#461583 04/04/2017
	if(!entityChargesCO.getCommit())
	{
	    coreCommonProcedureBO.dropHashEccArguments();
	    coreCommonProcedureBO.createHashEccArguments();
	}
	trxMgntSC = coreCommonProcedureBO.checkAmntRestriction(trxMgntSC);
	
	return trxMgntSC;	    
    
    }

    public CoreCommonChargesBO getCoreCommonChargesBO()
    {
        return coreCommonChargesBO;
    }

    @Override
    public void setCoreCommonChargesBO(CoreCommonChargesBO coreCommonChargesBO)
    {
        this.coreCommonChargesBO = coreCommonChargesBO;
    }
    
    
    /**
     * This function prepares data, and calls the Unified Charges Calculation Procedure
     * and returns them.
     * 
     * @author Reda Charabaty 
     * @param  EntityChargesCO
     * 		entityChargesCO.getLanguage()
     * 		entityChargesCO.getLoginCompCode()
     * 		entityChargesCO.getLoginBraCode()
     * 		entityChargesCO.getLoginTellerCode()
     * 		entityChargesCO.getLoginUserId()
     * 		entityChargesCO.getDeductCharges()		Charges Deducted By Flag (In case it exists)
     * 		entityChargesCO.getCrud()
     * 		entityChargesCO.getRunningDate()
     * 		entityChargesCO.getAccBranch()			Branch of Account to be charged	(In case deduct by account, use Charge Account if available, or main account if not available, else use main account)
     * 		entityChargesCO.getAccCurrency()		Currency of Account to be charged (In case deduct by account, use Charge Account if available, or main account if not available, else use main account)
     * 		entityChargesCO.getAccGL()			GL of Account to be charged (In case deduct by account, use Charge Account if available, or main account if not available, else use main account)
     * 		entityChargesCO.getAccCIF()			CIF of Account to be charged (In case deduct by account, use Charge Account if available, or main account if not available, else use main account)
     * 		entityChargesCO.getAccSL()			SL of Account to be charged (In case deduct by account, use Charge Account if available, or main account if not available, else use main account)
     * 		entityChargesCO.getEntityType()			Product Type (ex: 'CHQ', 'PAS'...)
     * 		entityChargesCO.getEntityTypeCode()		Product Type Code
     * 		entityChargesCO.getBaseCurrencyCode()		Base Currency
     * 		entityChargesCO.getCardType()			For Cards
     * 		entityChargesCO.getTrsAccounDetBranch()		(Optional) (Branch supplied by ACC, USO, and EXC)
     * 		entityChargesCO.getEntityCommand()		(Optional)
     * 		entityChargesCO.getActionType()			(For some products)
     * 		
     * 
     * @return EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO calculateUnifiedCharges(EntityChargesCO entityChargesCO1) throws BaseException
    {
	EntityChargesCO entityChargesCO = entityChargesCO1;
	NumberUtil.resetEmptyValues(entityChargesCO);
	
	if((entityChargesCO.getCtsChargesEntityCOs() == null || entityChargesCO.getCtsChargesEntityCOs().isEmpty())
		&& entityChargesCO.getIsEmptied().equals(true))
	{
	    TrxMgntCO trxMgntCO = new TrxMgntCO();

	    /*
	     * Get PTH_CTRL Details
	     */
	    entityChargesCO.setPthCTRL(commonLibBO.returnPthCtrl());
	    trxMgntCO.setPthCtrlVO(entityChargesCO.getPthCTRL());
	
	    trxMgntCO.setLanguage(entityChargesCO.getLanguage());
	    trxMgntCO.setLoginUserId(entityChargesCO.getLoginUserId());
	    trxMgntCO.setIsSybase(commonLibBO.returnIsSybase());
	    trxMgntCO.setLoginCompCode(entityChargesCO.getLoginCompCode());
	    trxMgntCO.setLoginBraCode(entityChargesCO.getLoginBraCode());
	    trxMgntCO.setLoginTellerCode(entityChargesCO.getLoginTellerCode());
	    trxMgntCO.getCtstrsVO().setCASH_DEDUCT_IND(entityChargesCO.getDeductCharges());
	    trxMgntCO.setCrud(entityChargesCO.getCrud());
	    trxMgntCO.setRunningDateRET(entityChargesCO.getRunningDate());
	    trxMgntCO.setChargeActionType(entityChargesCO.getActionType());
	    trxMgntCO.setBaseCurrencyCode(entityChargesCO.getBaseCurrencyCode());
	    trxMgntCO.setChargesEmpty(EntityChargesConstant.TF_TRUE);
	    trxMgntCO.getTrxChargesCO().setTicketNo(entityChargesCO.getTradeSerialNbr());
	    trxMgntCO.setTrsNo(NumberUtil.nullToZero(entityChargesCO.getTrsNo()));//Hasan Bug#598728 DASI170135 27/12/2017
//	    entityChargesCO = setChargeAcc(entityChargesCO);

	    /*
	     * Set Main Account
	     */
	    if(entityChargesCO.getDeductCharges() == null
		    || EntityChargesConstant.VALUE_EMPTY.equals(entityChargesCO.getDeductCharges().trim()))
	    {
		entityChargesCO.setDeductCharges(EntityChargesConstant.VALUE_ZERO);
	    }
	    
	  //Hussein El Hajj US#626178 DASI180013 02/03/2018
	    if(EntityChargesConstant.ENTITY_CERTIFICATE.equals(entityChargesCO.getEntityType())
		    && EntityChargesConstant.TO_BE_CANCELLED_CRUD.equals(entityChargesCO.getCrud()))
	    {
		entityChargesCO.setEntityType(EntityChargesConstant.ENTITY_REASON);
		trxMgntCO.getTrxChargesCO().setReasonCode(entityChargesCO.getTrsNo());
	    }
	
	    if(entityChargesCO.getDeductCharges().equals(EntityChargesConstant.CHARGES_DEDUCT_BY_ACCOUNT) ||
		    CtsRequestConstant.PAYMENT_TYPE_IND_ACCOUNT.equals(entityChargesCO.getDeductCharges()))
	    {		
		trxMgntCO.getCtstrsVO().setCH_AC_BR(entityChargesCO.getChargeAccBranch());
		trxMgntCO.getCtstrsVO().setCH_AC_CY(entityChargesCO.getChargeAccCurrency());
		trxMgntCO.getCtstrsVO().setCH_AC_GL(entityChargesCO.getChargeAccGL());
		trxMgntCO.getCtstrsVO().setCH_AC_CIF(entityChargesCO.getChargeAccCIF());
		trxMgntCO.getCtstrsVO().setCH_AC_SL(entityChargesCO.getChargeAccSL());
		
		/*
		 * For Trx (From Accounts screen), we need both accounts filled
		 */
		if(TrxMgntConstant.TRX_ENTRY_SCREEN.equals(entityChargesCO.getEntityType()))
		{
		    trxMgntCO.getCtstrsVO().setTRS_AC_BR(entityChargesCO.getChargeAccBranch());
		    trxMgntCO.getCtstrsVO().setTRS_AC_CY(entityChargesCO.getChargeAccCurrency());
		    trxMgntCO.getCtstrsVO().setTRS_AC_GL(entityChargesCO.getChargeAccGL());
		    trxMgntCO.getCtstrsVO().setTRS_AC_CIF(entityChargesCO.getChargeAccCIF());
		    trxMgntCO.getCtstrsVO().setTRS_AC_SL(entityChargesCO.getChargeAccSL());
		    
		    if(EntityChargesConstant.TYPEIND_CLOSE_TRANSFER.equals(entityChargesCO.getTypeInd()))
		    {
			trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(entityChargesCO.getAccBranch());
			trxMgntCO.getCtstrsVO().setTO_TRS_AC_CY(entityChargesCO.getAccCurrency());
			trxMgntCO.getCtstrsVO().setTO_TRS_AC_GL(entityChargesCO.getAccGL());
			trxMgntCO.getCtstrsVO().setTO_TRS_AC_CIF(entityChargesCO.getAccCIF());
			trxMgntCO.getCtstrsVO().setTO_TRS_AC_SL(entityChargesCO.getAccSL());
		    }
		}
		else
		{
		    trxMgntCO.getCtstrsVO().setTRS_AC_BR(entityChargesCO.getAccBranch());
		    trxMgntCO.getCtstrsVO().setTRS_AC_CY(entityChargesCO.getAccCurrency());
		    trxMgntCO.getCtstrsVO().setTRS_AC_GL(entityChargesCO.getAccGL());
		    trxMgntCO.getCtstrsVO().setTRS_AC_CIF(entityChargesCO.getAccCIF());
		    trxMgntCO.getCtstrsVO().setTRS_AC_SL(entityChargesCO.getAccSL());

		    if(EntityChargesConstant.TYPEIND_CLOSE_TRANSFER.equals(entityChargesCO.getTypeInd()))
		    {
			trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(entityChargesCO.getChargeAccBranch());
			trxMgntCO.getCtstrsVO().setTO_TRS_AC_CY(entityChargesCO.getChargeAccCurrency());
			trxMgntCO.getCtstrsVO().setTO_TRS_AC_GL(entityChargesCO.getChargeAccGL());
			trxMgntCO.getCtstrsVO().setTO_TRS_AC_CIF(entityChargesCO.getChargeAccCIF());
			trxMgntCO.getCtstrsVO().setTO_TRS_AC_SL(entityChargesCO.getChargeAccSL());
		    }
		}
	    }
	    else
	    {
		trxMgntCO.getCtstrsVO().setTRS_AC_BR(entityChargesCO.getAccBranch());
		trxMgntCO.getCtstrsVO().setTRS_AC_CY(entityChargesCO.getAccCurrency());
		trxMgntCO.getCtstrsVO().setTRS_AC_GL(entityChargesCO.getAccGL());
		trxMgntCO.getCtstrsVO().setTRS_AC_CIF(entityChargesCO.getAccCIF());
		trxMgntCO.getCtstrsVO().setTRS_AC_SL(entityChargesCO.getAccSL());
		
		if(EntityChargesConstant.TYPEIND_CLOSE_TRANSFER.equals(entityChargesCO.getTypeInd()))
		{
		    trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(entityChargesCO.getChargeAccBranch());
		    trxMgntCO.getCtstrsVO().setTO_TRS_AC_CY(entityChargesCO.getChargeAccCurrency());
		    trxMgntCO.getCtstrsVO().setTO_TRS_AC_GL(entityChargesCO.getChargeAccGL());
		    trxMgntCO.getCtstrsVO().setTO_TRS_AC_CIF(entityChargesCO.getChargeAccCIF());
		    trxMgntCO.getCtstrsVO().setTO_TRS_AC_SL(entityChargesCO.getChargeAccSL());
		}

		entityChargesCO.setChargeAccCurrency(trxMgntCO.getCtstrsVO().getTRS_AC_CY());
		trxMgntCO.getCtstrsVO().setCH_AC_CY(entityChargesCO.getAccCurrency());
	    }
	
	    
	    /**
	     * @author RaniaAlBitar
	     * DB140075 - Customer wants to close the General Account - R14.1.1
	     */
	   /* if(EntityChargesConstant.TYPEIND_CLOSE_TRANSFER.equals(entityChargesCO.getTypeInd()))
	    {
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(entityChargesCO.getChargeAccBranch());
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_CY(entityChargesCO.getChargeAccCurrency());
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_GL(entityChargesCO.getChargeAccGL());
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_CIF(entityChargesCO.getChargeAccCIF());
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_SL(entityChargesCO.getChargeAccSL());
	    }*/
	    
	    /** End Rania */
	    
	    /*
	     * Set Exchange Rate
	     */
	    trxMgntCO.getCtstrsVO().setEXCHANGE_RATE(retrieveExchRate(entityChargesCO));
	    
	    trxMgntCO.getTrxChargesCO().setEntityType(entityChargesCO.getEntityType());

	    trxMgntCO.getCtstrsVO().setTRX_TYPE(entityChargesCO.getEntityTypeCode());
	    trxMgntCO.getTrxChargesCO().setCurrency(entityChargesCO.getAccCurrency());
	    trxMgntCO.getCtstrsVO().setTRS_CY(returnTrsCurrency(trxMgntCO));
	    
	  
	    trxMgntCO.setChargeSchema(NumberUtil.emptyDecimalToNull(entityChargesCO.getSchema()));

	    
	    if(EntityChargesConstant.ENTITY_LOSTFOUND.equals(entityChargesCO.getEntityType()) || (EntityChargesConstant.ENTITY_CERTIFICATE.equals(entityChargesCO.getEntityType())&& ("true").equals(StringUtil.nullToEmpty(entityChargesCO.getMultiplyByBills()))))
	    {
		trxMgntCO.getTrxChargesCO().setLeaves(entityChargesCO.getNumOfEntities());
	    }
	    else
	    {
		trxMgntCO.getTrxChargesCO().setLeaves(entityChargesCO.getLeaves());
	    }
	    
	    /*
	     * Chequebook Data
	     */
	    trxMgntCO.getTrxChargesCO().setType(entityChargesCO.getType());
	    trxMgntCO.getTrxChargesCO().setChqIssueType(entityChargesCO.getChqIssueType());
	    // added by nancy -- 14/04/2018--FIBSI170009-Integration with chequebook printer and provider
	    trxMgntCO.getTrxChargesCO().setPrintingLocation(entityChargesCO.getPrintingLocation());
	    // end nancy
	    /*
	     * Cards Data
	     */
	    trxMgntCO.getTrxChargesCO().setStatusIdentifier(entityChargesCO.getStatusIdentifer());
	    
	    /*
	     * iPad Solutions - Reda 23/12/2015
	     */
	    if(entityChargesCO.getAutoCreated() != null && entityChargesCO.getAutoCreated())
	    {
		trxMgntCO.getCtstrsVO().setTRS_NO(entityChargesCO.getEntityCode());
	    }

	    /*
	     * BOKI100025 set amount to the amount of Lost & found document of
	     * type remittance
	     */
	    if(EntityChargesConstant.ENTITY_LOSTFOUND.equals(entityChargesCO.getEntityType()))
	    {
		trxMgntCO.getCtstrsVO().setCV_AMOUNT(NumberUtil.nullToZero(entityChargesCO.getCvAmount()));
	    }
	    
	    
	    /*
	     * iPad Solutions - Reda 23/12/2015
	     */
	    if(entityChargesCO.getAutoCreated() != null && entityChargesCO.getAutoCreated())
	    {
		trxMgntCO.getCtstrsVO().setTRS_NO(entityChargesCO.getEntityCode());
	    }
	    

	    //Rania - DB130089 Close account with transfer: from close with transfer the entity type is TRX; it should be treated as Transaction and not product; the deduct charges should be as transaction type parametrization
	    if(EntityChargesConstant.TYPEIND_CLOSE_TRANSFER.equals(entityChargesCO.getTypeInd()))
	    {
		trxMgntCO.getCtstrsVO().setCASH_DEDUCT_IND(null);		
		entityChargesCO.setTypeInd(EntityChargesConstant.TYPEIND_ALL_DEFAULT);
		
	    }
	    //
	    
	    /*
	     * Call Account Limit validation for checking if breaching the limit and there are extra charges to be deducted, then this fills a table that will
	     * be read when P_RET_GET_CHARGES_UNIFIED calls P_RET_ACC_LIMIT_APPLY_ACTION
	     */
	    BigDecimal totalAmount, countAccLim;
	    EntityChargesSC entityChargesSC = new EntityChargesSC();
	    entityChargesSC.setCompCode(entityChargesCO.getLoginCompCode());
	    
	    countAccLim = entityChargesDAO.returnCountAccountLimits(entityChargesSC);
	    
	    if(NumberUtil.isNumberPositive(countAccLim))
	    {
		TrxMgntCO chargeTrxMgntCO = (new Cloner()).deepClone(trxMgntCO);
		chargeTrxMgntCO = coreCommonChargesBO.selectUnifiedCharges(chargeTrxMgntCO); // Dummy first call to get Original charge amount for products to use in Account Limit
    	    
		AccountSC accountSC = new AccountSC();
		accountSC.setCompCode(entityChargesCO.getLoginCompCode());
		accountSC.setLoginBranchCode(entityChargesCO.getLoginBraCode());
		accountSC.setRunningDate(entityChargesCO.getRunningDate());
		accountSC.setUserId(entityChargesCO.getLoginUserId());
		accountSC.setCallingIndicator("P");
		accountSC.setAccTierNOChar("O");
		accountSC.setBranchCode(trxMgntCO.getCtstrsVO().getTRS_AC_BR());
		accountSC.setCurrencyCode(trxMgntCO.getCtstrsVO().getTRS_AC_CY());
		accountSC.setGlCode(trxMgntCO.getCtstrsVO().getTRS_AC_GL());
		accountSC.setCifCode(trxMgntCO.getCtstrsVO().getTRS_AC_CIF());
		accountSC.setSlNbr(trxMgntCO.getCtstrsVO().getTRS_AC_SL());

		if(chargeTrxMgntCO.getTrxChargesCO() == null)
		{
		    totalAmount = BigDecimal.ZERO;
		}
		else
		{
		    totalAmount = NumberUtil.nullToZero(chargeTrxMgntCO.getTrxChargesCO().getTotalFc()).add(NumberUtil.nullToZero(chargeTrxMgntCO.getTrxChargesCO().getTotalDuesFc()));
		}

		accountSC.setAmount(totalAmount);
		coreCommonProcedureBO.accLimitValidationChecking(accountSC);
	    }
	    //
	    
	    
	    trxMgntCO = coreCommonChargesBO.selectUnifiedCharges(trxMgntCO);
	    entityChargesCO.setErrorCode(trxMgntCO.getErrorCode());
	    entityChargesCO.setErrorMsg(trxMgntCO.getErrorMsg());
	
	    /*
	     * Copy Changes to Entity CO
	     */
	    entityChargesCO = returnChargesData(trxMgntCO, entityChargesCO);
	    
	    /*
	     * Set Entity Count for Chequebooks
	     */
	    for(int i = 0; i < entityChargesCO.getCtsChargesEntityCOs().size(); i++)
	    {
		entityChargesCO.setRow(BigDecimal.valueOf(i));
		entityChargesCO.getCtsChargesEntityCOs().get(i).setCtsChargesVO(
			retrieveChargesInfo(entityChargesCO.getLoginCompCode(), entityChargesCO
				.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getCHARGE_CODE()));
		entityChargesCO.getCtsChargesEntityCOs().get(i).setEntityCount(retrieveEntityCount(entityChargesCO));
		
		//IIAB100357 - hold the original amount upon retrieving the grid data
		entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().setAMOUNT_ORIGINAL(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT());
		entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().setAMOUNT_ORIGINAL_FC(entityChargesCO.getCtsChargesEntityCOs().get(i).getCtsChargesEntityVO().getAMOUNT_FC());
		entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setAMOUNT_ORIGINAL(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT());
		entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().setAMOUNT_ORIGINAL_FC(entityChargesCO.getCtsChargesEntityCOs().get(i).getVatCtsChargesEntityVO().getAMOUNT_FC());
	    
	    
		// added by nancy -- 14/04/2018--FIBSI170009-Integration with chequebook printer and provider
		/*if(entityChargesCO.getEntityType().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK))
		{
		    entityChargesCO = fillTypeInd(entityChargesCO);
		}*/
		// end nancy
	    }
	    //Hasan Bug#598728 DASI170135 26/01/2018
	    // modified by nancy -- 14/04/2018--FIBSI170009-Integration with chequebook printer and provider
	    if(entityChargesCO.getEntityType().equals(EntityChargesConstant.ENTITY_LOSTFOUND) ||entityChargesCO.getEntityType().equals(EntityChargesConstant.ENTITY_CHEQUEBOOK) )
	    {
		entityChargesCO = fillTypeInd(entityChargesCO);
	    }
	    
	    /*
	     * Delete Temp Charges data from DB
	     */
	    coreCommonChargesBO.emptyCharges(trxMgntCO.getLoginCompCode(), trxMgntCO.getLoginBraCode(), trxMgntCO.getSessionID(), null, null);

	}
	
	return entityChargesCO;
	
    }
    
    
    /**
     * 
     * This function returns the Transaction Currency to be used.
     * 
     * @author Reda Charabaty 
     * @param  TrxMgntCO
     * 		trxMgntCO.getPthCtrlVO()
     * 		trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND()
     * 		trxMgntCO.getCtstrsVO().getCH_AC_CY()			Charge Account Currency (If Exists)
     * 		trxMgntCO.getTrxChargesCO().getCurrency()		Main Account Currency
     * 		trxMgntCO.getBaseCurrencyCode();
     * 		
     * 
     * @return BigDecimal
     * 
     * @throws BaseException
     */
    public BigDecimal returnTrsCurrency(TrxMgntCO trxMgntCO) throws BaseException
    {
	BigDecimal trsCy;
	
	
	if(EntityChargesConstant.REFERENCE_CLOSE_ACCOUNT.equals(trxMgntCO.getReference()) ||
	            (EntityChargesConstant.REFERENCE_REACTIVATE_ACCOUNT.equals(trxMgntCO.getReference())
	                && NumberUtil.isEmptyDecimal(trxMgntCO.getChargeSchema())))
	{
	    /*
	     * In case of Close Account with Transfer, the Transaction Currency will be specified in Accounts BO
	     */
	    trsCy = trxMgntCO.getCtstrsVO().getTRS_CY();
	    
	}
	else
	{
	    if(EntityChargesConstant.CHARGES_BOOKING_A.equals(trxMgntCO.getPthCtrlVO().getCHARGES_BOOKING())
		    || EntityChargesConstant.CHARGES_BOOKING_C.equals(trxMgntCO.getPthCtrlVO().getCHARGES_BOOKING())) // Hala Al Sheikh ABEI190073 
	    {
		if(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND() != null
			&& EntityChargesConstant.CHARGES_DEDUCT_BY_ACCOUNT.equals(trxMgntCO.getCtstrsVO().getCASH_DEDUCT_IND()))
		{
		    /*
		     * Charge Account Currency
		     */
		    trsCy = trxMgntCO.getCtstrsVO().getCH_AC_CY();

		}
		else
		{
		    /*
		     * Main Account Currency
		     */
		    trsCy = trxMgntCO.getTrxChargesCO().getCurrency();
		}

		/*
		 * If Transaction Currency is null, then set it to Base Currency
		 */
		if(trsCy == null)
		{
		    trsCy = trxMgntCO.getBaseCurrencyCode();
		}
        
	    }
	    else
	    {
		/*
		 * Base Currency
		 */
		trsCy = trxMgntCO.getBaseCurrencyCode();
	    }
	}
	
	return trsCy;
    }
    
    
    /**
     * 
     * This function fills the charges data in entityChargesCO after getting them from trxMgntCO
     * 
     * @author Reda Charabaty 
     * 
     * @param  TrxMgntCO trxMgntCO
     * 	       EntityChargesCO entityChargesCO1
     * 
     * 
     * @return EntityChargesCO
     * 
     * @throws BaseException
     */
    public EntityChargesCO returnChargesData(TrxMgntCO trxMgntCO, EntityChargesCO entityChargesCO1) throws BaseException
    {
	EntityChargesCO entityChargesCO = entityChargesCO1;
	
	if(trxMgntCO.getTrxChargesCO() != null
	    &&(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs() != null &&
		    trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().size() > 0))
	    {
		CtsChargesEntityCO ctsChargesEntityCO;
		
		for(int i=0; i <trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().size(); i++)
		{
		    ctsChargesEntityCO = new CtsChargesEntityCO();
		    ctsChargesEntityCO.setCtsChargesEntityVO(copyFromTrxChargeToEntity(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO(),ctsChargesEntityCO.getCtsChargesEntityVO()));
		    
		    if(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO() != null)
		    {			
			ctsChargesEntityCO.setVatCtsChargesEntityVO(copyFromTrxChargeToEntity(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getTvaChargesDetVO(),ctsChargesEntityCO.getVatCtsChargesEntityVO()));
		    }
		    
		    ctsChargesEntityCO.getCtsChargesVO().setBRIEF_NAME_ENG(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtsChargesVO().getBRIEF_NAME_ENG());
		    ctsChargesEntityCO.getCtsChargesVO().setBRIEF_NAME_ARAB(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtsChargesVO().getBRIEF_NAME_ARAB());
		    ctsChargesEntityCO.getCtsChargesVO().setDUES_COLLECTION_TYPE(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getDUES_COLLECTION_TYPE());
		    ctsChargesEntityCO.getCtsChargesVO().setDUES_MODE_PAY(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtstrsCHARGESDETVO().getDUES_MODE_PAY());
		    ctsChargesEntityCO.getCtsChargesVO().setCONSIDER_ONCE_FOR_MULTI_TRX(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getCtsChargesVO().getCONSIDER_ONCE_FOR_MULTI_TRX());
		    ctsChargesEntityCO.setActionType(trxMgntCO.getTrxChargesCO().getTrxMgntChargesCOs().get(i).getActionType());
		    
		    /*
		     * Fill The Charge Description
		     */
		    if(entityChargesCO.getLoginPreferrredLanguage() == null || ConstantsCommon.PREFERED_LANG_LATIN.equals(entityChargesCO.getLoginPreferrredLanguage()))
		    {
			ctsChargesEntityCO.setChargeDesc(ctsChargesEntityCO.getCtsChargesVO().getBRIEF_NAME_ENG());
		    }
		    else
		    {
			ctsChargesEntityCO.setChargeDesc(ctsChargesEntityCO.getCtsChargesVO().getBRIEF_NAME_ARAB());
		    }
		    
		    entityChargesCO.getCtsChargesEntityCOs().add(ctsChargesEntityCO);
		    
		}
	    }
	 
	
	
	return entityChargesCO;
    }
    
    
    /**
     * 
     * This function copies Charges data from the Unified Calculation Charges to the Entity Charges
     * 
     * @author Reda Charabaty 
     * @param  CTSTRS_CHARGES_DETVO ctstrsChargesDetVO		Unified Charges
     * 	       CTS_CHARGES_ENTITYVO ctsChargesEntity1VO		Entity Charges
     * 
     * 
     * @return CTS_CHARGES_ENTITYVO
     * 
     * @throws BaseException
     */
    public CTS_CHARGES_ENTITYVO copyFromTrxChargeToEntity(CTSTRS_CHARGES_DETVO ctstrsChargesDetVO, CTS_CHARGES_ENTITYVO ctsChargesEntity1VO) throws BaseException
    {
	CTS_CHARGES_ENTITYVO ctsChargesEntityVO = ctsChargesEntity1VO;
	
	if(ctsChargesEntityVO != null && ctstrsChargesDetVO != null)
	{
	    PathPropertyUtil.copyProperties(ctstrsChargesDetVO,ctsChargesEntityVO,
	    "CHARGE_CODE"		,"AMOUNT",				
	    "AMOUNT_FC_NEW AMOUNT_FC"	,"PASS_SEPARATELY",				
	    "DR_CRITERIA"		,"APPLY_TVA",		
	    "VAT_CODE"			,"ACC_BR",		
	    "ACC_CY"			,"ACC_GL",	
	    "ACC_CIF"			,"ACC_SL",	
	    "DEDUCT_FROM_ACC_BR"	,"DEDUCT_FROM_ACC_CY",
	    "DEDUCT_FROM_ACC_GL"	,"DEDUCT_FROM_ACC_CIF",		
	    "DEDUCT_FROM_ACC_SL"	,"DR_ACC_GL",				
	    "DR_ACC_CIF"		,"DR_ACC_SL",
	    "SCHEMA_CODE"		,"DUES_COLLECTION_TYPE",
	    "DUES_MODE_PAY");

	}
	return ctsChargesEntityVO;
    }
    
    
    /**
     * This function returns a count of charges in the charge schema that are not
     * exempted in Logged-In nor Account Branches
     * 
     * @author Reda Charabaty
     * @param EntityChargesSC
     * 		compCode			Company Code
     * 		code				Charge Schema Code
     * 		branchCode			Logged-In Branch Code
     * 		debitAccBr			Debit Account Branch Code
     * 
     * 		applyVAT			1: Count those that have VAT (Optional)
     * 
     * @return BigDecimal
     * 
     * @throws BaseException
     */
    public BigDecimal retrieveCountNonExemptedCharges(EntityChargesSC entityChargesSC) throws BaseException
    {
	return entityChargesDAO.retrieveCountNonExemptedCharges(entityChargesSC);
    }
    
    
    /**
     * This function checks if the charge contains a record in CTSCHARGES_CURRENCY. 
     * If it does not find, then returns a Confirmation message. Fills returnInt with -1
     * in case no message to be outputted
     * 
     * @author Reda Charabaty
     * @param EntityChargesCO
     * 		loginCompCode			Company Code
     * 		schema				Charge Schema Code
     * 		chargeAccCurrency		Currency Code
     * 
     * Optional:
     * 		Proceed				Fill with any value to suppress the message. 
     * 						This will cause ReturnInt to be filled with -1 in case no charge amount defined.
     * 
     * @return EntityChargesCO
     * 		ReturnInt			Filled with -1 in case no Charge Amount Defined and Proceed filled
     * 		
     * 
     * @throws BaseException
     */
    public EntityChargesCO checkNonexistingChargesByCurrency(EntityChargesCO entityChargesCO) throws BaseException
    {
	/*
	 * Get PTH_CTRL Details
	 */
	entityChargesCO.setPthCTRL(commonLibBO.returnPthCtrl());
	
	
	if(NumberUtil.emptyDecimalToZero(entityChargesCO.getChargeAccCurrency()).compareTo(BigDecimal.ZERO) > 0 &&
		EntityChargesConstant.CHARGES_BOOKING_A.equals(entityChargesCO.getPthCTRL().getCHARGES_BOOKING()) &&
		entityChargesCO.getBaseCurrencyCode().compareTo(entityChargesCO.getChargeAccCurrency()) != 0 &&
		entityChargesCO.getSchema() != null)
	{
	    /*
	     * Select Charges Amounts
	     */
	    EntityChargesSC chargesCurrencyEntityChargesSC = new EntityChargesSC();
	    chargesCurrencyEntityChargesSC.setCompCode(entityChargesCO.getLoginCompCode());
	    chargesCurrencyEntityChargesSC.setSchema(entityChargesCO.getSchema());
	    chargesCurrencyEntityChargesSC.setChargeCurrency(entityChargesCO.getChargeAccCurrency());
	    BigDecimal chargeNonExistingCharges = entityChargesDAO.checkNonexistingChargesByCurrency(chargesCurrencyEntityChargesSC);

	    if(chargeNonExistingCharges != null && chargeNonExistingCharges.compareTo(BigDecimal.ZERO) > 0 )
	    {

		
		CURRENCIESVO chargeCurrencyVO = new CURRENCIESVO();
		chargeCurrencyVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
		chargeCurrencyVO.setCURRENCY_CODE(entityChargesCO.getChargeAccCurrency());
		chargeCurrencyVO = commonLibBO.returnCurrency(chargeCurrencyVO);

		String entityType;

		/*
		 * In case of Safebox, add Charge Type
		 */
		if(entityChargesCO.getChargeType() == null)
		{
		    entityType = "";
		}
		else
		{
		    /*
		     * In Case of Transactions
		     */
		    if(EntityChargesConstant.ENTITY_TRANSACTION.equals(entityChargesCO.getChargeType()))
		    {
			throw new BOException(MessageCodes.CHARGE_NOT_DEFINED_FOR_CURRENCY, new String[] {chargeNonExistingCharges.toString(),chargeCurrencyVO.getBRIEF_DESC_ENG() });
		    }
		    else if(EntityChargesConstant.SAFEBOX_CHARGES_RENTAL.equals(entityChargesCO.getChargeType()))
		    {
			entityType = "Safebox_Rental_Charges_Msg_key";
		    }
		    else if(EntityChargesConstant.SAFEBOX_CHARGES_INSURANCE.equals(entityChargesCO.getChargeType()))
		    {
			entityType = "Safebox_Insurance_Charges_Msg_Key";
		    }
		    else if(EntityChargesConstant.SAFEBOX_CHARGES_STAMP.equals(entityChargesCO.getChargeType()))
		    {
			entityType = "Safebox_Stamp_Charges_Msg_Key";
		    }
		    else
		    {
			entityType = "";
		    }
		}

		throw new BOException(MessageCodes.PARAM_CHARGE_CODE_NOT_DEFINED_FOR_CY_PROCEED, new String[] { entityType, chargeNonExistingCharges.toString(),chargeCurrencyVO.getBRIEF_DESC_ENG() }, ConstantsCommon.CONFIRM_MSG_TYPE, true);
	    }
	}

	return entityChargesCO;
    }
    
    /**
     * This function will Update the Transaction with necessary entity info on CREATED_BY  column 
     *  
     * @author tonynouh
     * @param trxMgntCO
     * 
     * 		trxMgntSC.getCompCode()			Company Code
     *          trxMgntSC.getBranchCode()		Branch Code
     *          trxMgntSC.getTrsNo()			Transaction Number to update
     * 
     * @throws BaseException
     */
    public void updateCTSTRSCreatedBy(TrxMgntSC trxMgntSC) throws BaseException
    {	
	if(!NumberUtil.isEmptyDecimal(trxMgntSC.getOutTrsno()) && trxMgntSC.getCreatedBy() != null
		&& !"".equals(trxMgntSC.getCreatedBy()))
	{
	    CTSTELLERVO ctsTellerVO = commonLibBO.returnCtsTellerDetails(trxMgntSC.getCompCode(), trxMgntSC
		    .getBranchCode(), trxMgntSC.getCreatedBy());
	    if(ctsTellerVO != null)
	    {
		trxMgntSC.setCreatedByTellerCode(ctsTellerVO.getCODE());
	    }
	    entityChargesDAO.updateCTSTRSCreatedBy(trxMgntSC);
	}
    }
    
    /**
     * Hasan Bug#475705 15/03/2017
     * This method is called from all products to calculate the product charges
     */
    @Override
    public EntityChargesCO returnProductCharges(TrxMgntChargesSC trxMgntChargesSC) throws BaseException
    {
	CIFVO cifVO = new CIFVO();
	cifVO.setCOMP_CODE(trxMgntChargesSC.getCompCode());
	cifVO.setBRANCH_CODE(trxMgntChargesSC.getBranchCode());
	cifVO.setCIF_NO(trxMgntChargesSC.getTrsAcCif());
	GEN_LEDGERVO genLedgerVO = null;
	if(!NumberUtil.isEmptyDecimal(trxMgntChargesSC.getChAcGl()))
	{
	    genLedgerVO = new GEN_LEDGERVO();
	    genLedgerVO.setCOMP_CODE(trxMgntChargesSC.getCompCode());
	    genLedgerVO.setGL_CODE(trxMgntChargesSC.getTrsAcGl());
	    genLedgerVO = commonLibBO.returnGenralLegder(genLedgerVO);
	}	
	if(genLedgerVO != null && ConstantsCommon.INTERNAL_GL_TYPE.equals(genLedgerVO.getGL_TYPE()) && ("1").equals(trxMgntChargesSC.getAcceptIntrnChq()))
	{
	    cifVO.setCIF_TYPE(BigDecimal.ZERO);  
	}
	else
	{
	    cifVO = (CIFVO)genericDAO.selectByPK(cifVO);  
	}
	
	if(cifVO != null)
	{
	    //500873
	    trxMgntChargesSC.setEntityTypeCode(cifVO.getCIF_TYPE());
	}
	
	coreCommonProcedureBO.returnProductCharges(trxMgntChargesSC);
	if(NumberUtil.nullToZero(trxMgntChargesSC.getError()).compareTo(BigDecimal.ZERO) < 0)
	{
	    throw new BOException(trxMgntChargesSC.getErrorMessage());
	}
	   
	EntityChargesCO entityChargesCO = new EntityChargesCO();
	entityChargesCO.setSchema(trxMgntChargesSC.getSchema());
	entityChargesCO.setTrxType(NumberUtil.nullToZero(trxMgntChargesSC.getTrxType()));
	return entityChargesCO;
    }
    
    
    public EntityChargesCO calculateUnifiedChargesHash(EntityChargesCO entityChargesCO) throws BaseException
    {
	
   	//Rakan Makarem - #509059 Apply the charge hash table to solve the Deadlocks 
   	coreCommonProcedureBO.dropHashCtsChargesUnified();
	coreCommonProcedureBO.createHashCtsChargesUnified();
	
	coreCommonProcedureBO.dropAccHashTables();
	coreCommonProcedureBO.createAccHashTables();
	entityChargesCO = calculateUnifiedCharges(entityChargesCO);
	
	return entityChargesCO;
    }

    /**
     * Hasan Youssef Bug#410184
     * This function check if the account is exempted from VAT and returns a string that will appears as warning
     */
    @Override
    public int checkAccountExemptedFromVAT(EntityChargesCO entityChargesCO) throws BaseException
    {
	int vatCount;
	
	/*
	 * If no Charges to be created
	 * Bug #  -- [John Massaad]
	 */
	if(NumberUtil.nullToZero(entityChargesCO.getLoginCompCode()).compareTo(BigDecimal.ZERO) == 0
		|| NumberUtil.nullToZero(entityChargesCO.getSchema()).compareTo(BigDecimal.ZERO) == 0)
	{
	    return 0;
	}
	
	EntityChargesSC entityChargesSC = new EntityChargesSC();
	entityChargesSC.setCompCode(entityChargesCO.getLoginCompCode());
	entityChargesSC.setCode(entityChargesCO.getSchema());
	entityChargesSC.setBranchCode(entityChargesCO.getLoginBraCode());
	entityChargesSC.setDebitAccBr(entityChargesCO.getAccBranch());
	vatCount = retrieveCountChargesSchemaVAT(entityChargesSC).intValue();
	if(vatCount > 0)
	{
	    String exemptedFromVat = null;
	    AMF_EXTENDEDVO amfExtendedVO = new AMF_EXTENDEDVO();
	    amfExtendedVO.setCOMP_CODE(entityChargesCO.getLoginCompCode());
	    amfExtendedVO.setBRANCH_CODE(NumberUtil.emptyDecimalToNull(entityChargesCO.getAccBranch()));
	    amfExtendedVO.setCURRENCY_CODE(NumberUtil.emptyDecimalToNull(entityChargesCO.getAccCurrency()));
	    amfExtendedVO.setGL_CODE(NumberUtil.emptyDecimalToNull(entityChargesCO.getAccGL()));
	    amfExtendedVO.setCIF_SUB_NO(NumberUtil.emptyDecimalToNull(entityChargesCO.getAccCIF()));
	    amfExtendedVO.setSL_NO(NumberUtil.emptyDecimalToNull(entityChargesCO.getAccSL()));
	    if(amfExtendedVO.getCIF_SUB_NO() == null)
	    {
		exemptedFromVat = "0";
	    }
	    else
	    {
		if(amfExtendedVO.getBRANCH_CODE() == null || amfExtendedVO.getBRANCH_CODE().equals(BigDecimal.ZERO)
			|| amfExtendedVO.getCURRENCY_CODE() == null
			|| amfExtendedVO.getCURRENCY_CODE().equals(BigDecimal.ZERO)
			|| amfExtendedVO.getGL_CODE() == null || amfExtendedVO.getGL_CODE().equals(BigDecimal.ZERO)
			|| amfExtendedVO.getSL_NO() == null)
		{
		    CIF_EXTENDEDVO cifExtended = new CIF_EXTENDEDVO();
		    cifExtended.setCOMP_CODE(entityChargesCO.getLoginCompCode());
		    cifExtended.setCIF_NO(amfExtendedVO.getCIF_SUB_NO());
		    cifExtended = (CIF_EXTENDEDVO) genericDAO.selectByPK(cifExtended);
		    if(cifExtended == null)
		    {
			cifExtended = new CIF_EXTENDEDVO();
		    }
		    exemptedFromVat = cifExtended.getEXEMPTED_FROM_VAT_YN();
		}
		else
		{
		    amfExtendedVO = (AMF_EXTENDEDVO) genericDAO.selectByPK(amfExtendedVO);
		    if(amfExtendedVO == null)
		    {
			amfExtendedVO = new AMF_EXTENDEDVO();
		    }
		//    exemptedFromVat = amfExtendedVO.getEXEMPTED_FROM_VAT_YN();
		}
	    }

	    if("1".equals(StringUtil.nullEmptyToValue(exemptedFromVat, "0")))
	    {
		return MessageCodes.EXEMPTED_FROM_VAT_WARNING;
	    }

	}
	return 0;
    }

    
    public BigDecimal returnCountLostFound(EntityChargesCO entityChargesCO) throws BaseException
    {
           return entityChargesDAO.returnCountLostFound(entityChargesCO);
    }
    
}

