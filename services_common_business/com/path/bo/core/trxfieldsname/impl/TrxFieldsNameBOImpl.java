package com.path.bo.core.trxfieldsname.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.bo.core.trxfieldsname.TrxFieldsNameBO;
import com.path.dao.core.trxfieldsname.TrxFieldsNameDAO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.csmfom.FOMTrxDetailsCO;
import com.path.vo.core.trxfieldsname.TrxFieldsNameCO;
import com.path.vo.core.trxfieldsname.TrxFieldsNameSC;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntSC;

/**
 * @author Sarah ElHusseini
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * TrxFieldsNameBOImpl.java used to
 */
public class TrxFieldsNameBOImpl extends RetailBaseBO implements TrxFieldsNameBO
{
    private TrxFieldsNameDAO trxFieldsNameDAO;

    /**
     * Method used to return Lookup Count of transaction fields Name
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws BaseException
     */
    public int returnTrxFieldsNameLookupCount(TrxFieldsNameSC criteria) throws BaseException
    {
	return trxFieldsNameDAO.returnTrxFieldsNameLookupCount(criteria);
    }

    /**
     * Method used to return Lookup List of transaction fields Name
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws BaseException
     */
    public List<TrxFieldsNameCO> returnTrxFieldsNameLookup(TrxFieldsNameSC criteria) throws BaseException
    {
	return trxFieldsNameDAO.returnTrxFieldsNameLookup(criteria);
    }

    /**
     * check on fields based on criteria sent by paramter
     * 
     * @return FOMTrxDetailsCO filled with value (mandatory, labeling..) for
     *         transaction fields from transaction type
     */
    public FOMTrxDetailsCO dependencyByTrxFieldName(TrxFieldsNameSC trxFieldsNameSC) throws BaseException
    {
	/* fill the parameters */
 	FOMTrxDetailsCO fomTrxDetailsCO = new FOMTrxDetailsCO();
	fomTrxDetailsCO.getCtsTrxTypeDetVO().setFIELD_NAME(trxFieldsNameSC.getFieldName());
	fomTrxDetailsCO.getCtsTrxTypeDetVO().setCODE(trxFieldsNameSC.getTrxType());
	fomTrxDetailsCO.getCtsTrxTypeDetVO().setLINE_NBR(trxFieldsNameSC.getLineNbr());
	fomTrxDetailsCO.setElementName(trxFieldsNameSC.getElementName());
	fomTrxDetailsCO.setFomTrxDetailsListCOs(trxFieldsNameSC.getFomTrxDetailsListCOs());
	
	/* check for duplicate value in the grid */
	checkDupGridVal(fomTrxDetailsCO);
	
	/* Defaukting criteria from transaction type */
	if(!NumberUtil.isEmptyDecimal(trxFieldsNameSC.getTrxType()))
	{
	    defaultTrxFieldProp(fomTrxDetailsCO, trxFieldsNameSC);
	}

	return fomTrxDetailsCO;
    }

    /**
     * check if field name and trx type are duplicated in the grid
     * @param fomTrxDetailsCO
     * @throws BOException 
     */
    private void checkDupGridVal(FOMTrxDetailsCO fomTrxDetailsCO) throws BOException
    {
	String fieldName = fomTrxDetailsCO.getCtsTrxTypeDetVO().getFIELD_NAME();
	BigDecimal trxType = fomTrxDetailsCO.getCtsTrxTypeDetVO().getCODE();

	int count = 0;
	for(FOMTrxDetailsCO fomTrxDetailsRowCO: fomTrxDetailsCO.getFomTrxDetailsListCOs())
	{
	    if(fieldName.equals(fomTrxDetailsRowCO.getCtsTrxTypeDetVO().getFIELD_NAME())
		    && (trxType.compareTo(fomTrxDetailsRowCO.getCtsTrxTypeDetVO().getCODE()) == 0))
	    {
		count++;
		if(count > 1)
		{
		    throw new BOException(MessageCodes.DUPLICATED_ENTRY_OF_RECORD);
		}
	    }
	}
    }

    /**
     * default criteria of fields name to its value from transaction type
     * 
     * @return
     * @throws BaseException
     */
    public FOMTrxDetailsCO defaultTrxFieldProp(FOMTrxDetailsCO fOMTrxDetailsCO, TrxFieldsNameSC trxFieldsNameSC) throws BaseException
    {
	/* Getting the required data from DB */
	TrxMgntSC criteria = new TrxMgntSC();
	TrxMgntCO trxMgntCO = new TrxMgntCO();
	fillTrxTypeRequiredData(trxMgntCO, criteria, trxFieldsNameSC);
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> dataResultMap = coreCommonBO.trxTypeMgntRequiredData(trxMgntCO, criteria);
	SYS_PARAM_SCREEN_DISPLAYVO resultCriteria = dataResultMap.get(fOMTrxDetailsCO.getElementName());
	
	/* Defaulting criteria needed in FOM trx details Pop Up*/
	fOMTrxDetailsCO.getCtsTrxTypeDetVO().setMANDATORY((resultCriteria.getIS_MANDATORY()).toString());
	fOMTrxDetailsCO.getCtsTrxTypeDetVO().setDISPLAY_LABEL(resultCriteria.getLABEL_KEY());
	fOMTrxDetailsCO.getCtsTrxTypeDetVO().setDISPLAY_LABEL_AR(resultCriteria.getLabelKeyVal());
 	return fOMTrxDetailsCO;
    }

    private void fillTrxTypeRequiredData(TrxMgntCO trxMgntCO, TrxMgntSC criteria, TrxFieldsNameSC trxFieldsNameSC)
    {
	trxMgntCO.getCtstrsVO().setTRX_TYPE(trxFieldsNameSC.getTrxType());
	trxMgntCO.setLoginCompCode(trxFieldsNameSC.getCompCode());
	trxMgntCO.setLoginBraCode(trxFieldsNameSC.getBranchCode());

	/*
	 * if we set the preferred language to current we woudn't get the
	 * english label if the current preferred lang is Arabic; In this case
	 * (fom transaction details Pop up), we need to have the english and
	 * arabic label in all cases so we set preferred language to null to get
	 * the english label (default label) and the arabic label from
	 * DISPLAY_LABEL_AR
	 */
	trxMgntCO.setLoginPreferrredLanguage(null);
	trxMgntCO.setAppName(trxFieldsNameSC.getCurrAppName());
	criteria.setUserId(trxFieldsNameSC.getUserId());
    }

    public TrxFieldsNameDAO getTrxFieldsNameDAO()
    {
	return trxFieldsNameDAO;
    }

    public void setTrxFieldsNameDAO(TrxFieldsNameDAO trxFieldsNameDAO)
    {
        this.trxFieldsNameDAO = trxFieldsNameDAO;
    }

    @Override
    public boolean returnTellerAccess(TrxFieldsNameSC trxFieldsNameSC) throws BaseException
    {

	Integer AccessDescriptionNumber = NCifMaintenanceConstant.TRANSACTION_DETAILS;
	  boolean checkAcess = coreCommonServiceBO.checkAccesTellerModified( trxFieldsNameSC.getCtsTellerVO(),  AccessDescriptionNumber);
	  
     return checkAcess;
    }
}
