package com.path.bo.core.mosblacklist.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.bo.core.mosblacklist.MosBlackListBO;
import com.path.dao.core.mosblacklist.MosBlackListDAO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_JOINT_DETVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.blacklistmanagement.CifBlckLstVO;
import com.path.vo.common.blacklistmanagement.MosBlackListCO;
import com.path.vo.common.blacklistmanagement.MosBlackListSC;
import com.path.vo.common.fom.FomCifJointAccCO;
import com.path.vo.core.blacklistmanagement.BlackListCO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: RabihElKhatib
 * 
 *          MosBlackListBOimpl.java used to Check if a CIF or a joint CIF is
 *          blacklisted based on CIFCONTROL BLCKL_* and AND_OR flags
 */
public class MosBlackListBOimpl extends BaseBO implements MosBlackListBO
{
    private MosBlackListDAO mosBlackListDAO;

    /**
     * PB f_check_cif_blcklist
     * Check if a CIF or Joint CIF is black listed Returns boolean,
     * MosBlackListCO (by reference) Input MosBlackListCO (CifVO(CompCode,
     * cifNO, columns' values),
     * mosBlackListCO.List<FomCifJointAccCO>.CIF_JOINT_DETVO(),
     * mosBlackListCO.AppName)
     */
    public boolean checkCifBlcklist(MosBlackListCO mosBlackListCO) throws BaseException

    {
	// TODO should call the procedure "P_FILL_CIF_BLACKLIST_MOS" instead
	// Declare variables
	Boolean bBlack = false;

	// Get needed values

	// commented the below because CifBlckLstVO shall be empty (as per Grace
	// note)
	// mosBlackListSC.setCompCode(mosBlackListCO.getCifVO().getCOMP_CODE());
	// mosBlackListSC.setCifNO(mosBlackListCO.getCifVO().getCIF_NO());
	// mosBlackListSC.setIsSybase(ConstantsCommon.CURR_DBMS_SYBASE);
	// mosBlackListCO.setCifBlckLstVO(mosBlackListDAO.returncifBlackList(mosBlackListSC));

	CIFVO cifVO = mosBlackListCO.getCifVO();

	mosBlackListCO.setFrom(cifVO.getCOMP_CODE());

	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(mosBlackListCO.getFrom());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);

	String sAndOR = cifControlVO.getAND_OR();

	// set cifControlVO AND_OR flag
	if(StringUtil.nullToEmpty(ConstantsCommon.CIF_OR).equals(sAndOR))
	{
	    sAndOR = "OR";
	}
	else
	{
	    sAndOR = "AND";
	}

	// set cifControlVO BLCKL_ (the columns to be checked for blacklist)
	// flags
	String sBlkLastName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_LAST_NAME());
	String sBlkThrdName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_THRD_NAME());
	String sBlkSecName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_SEC_NAME());
	String sBlkFName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_FST_NAME());
	String sBlkMLName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_MOTHER_LNAME());
	String sBlkMFName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_MOTHER_FNAME());
	String sBlkRegion = StringUtil.nullToEmpty(cifControlVO.getBLCKL_REGION());
	String sBlkCountry = StringUtil.nullToEmpty(cifControlVO.getBLCKL_COUNTRY());
	String sBlkNation = StringUtil.nullToEmpty(cifControlVO.getBLCKL_NATION());
	String sBlkBPlace = StringUtil.nullToEmpty(cifControlVO.getBLCKL_BPLACE());
	String sBlkBdate = StringUtil.nullToEmpty(cifControlVO.getBLCKL_BDATE());
	String sBlkRegNo = StringUtil.nullToEmpty(cifControlVO.getBLCKL_REGNO());
	String sBlkIdNo = StringUtil.nullToEmpty(cifControlVO.getBLCKL_IDNO());
	String sBlkLName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_LNAME());
	String sBlkBName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_BNAME());
	String sBlkLegal = StringUtil.nullToEmpty(cifControlVO.getBLCKL_LEGAL());
	BigDecimal criteriaPercent = cifControlVO.getBLCKL_CRITERIA_MATCH_PERC();

	// check if any flag is enabled
	if(!(StringUtil.isNotEmpty(sBlkLastName) || StringUtil.isNotEmpty(sBlkThrdName)
		|| StringUtil.isNotEmpty(sBlkSecName) || StringUtil.isNotEmpty(sBlkFName)
		|| StringUtil.isNotEmpty(sBlkMLName) || StringUtil.isNotEmpty(sBlkMFName)
		|| StringUtil.isNotEmpty(sBlkRegion) || StringUtil.isNotEmpty(sBlkCountry)
		|| StringUtil.isNotEmpty(sBlkNation) || StringUtil.isNotEmpty(sBlkBPlace)
		|| StringUtil.isNotEmpty(sBlkBdate) || StringUtil.isNotEmpty(sBlkRegNo)
		|| StringUtil.isNotEmpty(sBlkIdNo) || StringUtil.isNotEmpty(sBlkLName)
		|| StringUtil.isNotEmpty(sBlkBName) || StringUtil.isNotEmpty(sBlkLegal)))
	{
	    return bBlack;
	}

	String sLName;
	String sFName;
	String sSecName;
	String sThrdName;
	String sMotherFName = null;
	String sMotherLName = null;
	String sBPlace = null;
	String sLNameAR = null;
	String sFNameAR = null;
	String sSecNameAR = null;
	String sThrdNameAR = null;
	String sIdNo = null;
	String sLongName;
	String sLongNameAR;
	String sBriefName;
	String sBriefNameAR;

	BigDecimal bdCountry = null;
	BigDecimal bdRegion = null;
	BigDecimal bdNation = null;
	BigDecimal bdRegno = null;
	BigDecimal bdLegal = null;
	BigDecimal bdIdType = null;

	Date ldtBDate = null;
	// check on Application name ad getCifVO values
	if(StringUtil.isNotEmpty(mosBlackListCO.getAppName())
		&& (mosBlackListCO.getAppName().equals(ConstantsCommon.SUKUK_APP_NAME)
			|| mosBlackListCO.getAppName().equals(ConstantsCommon.DIRECT_INVEST_APP_NAME)
			|| mosBlackListCO.getAppName().equals(ConstantsCommon.ASSETS_APP_NAME)))
	{
	    sBriefName = StringUtil.nullToEmpty(mosBlackListCO.getBriefName()).trim().toLowerCase().replaceAll("'",
		    "''");
	    sBriefNameAR = StringUtil.nullToEmpty(mosBlackListCO.getBriefNameArab()).trim().toLowerCase()
		    .replaceAll("'", "''");
	    sLongName = StringUtil.nullToEmpty(mosBlackListCO.getStringReturn()).trim().toLowerCase().replaceAll("'",
		    "''");
	    sLongNameAR = StringUtil.nullToEmpty(mosBlackListCO.getStringReturnA()).trim().toLowerCase().replaceAll("'",
		    "''");

	    sFName = sLongName;
	    sSecName = sLongName;
	    sThrdName = sLongName;
	    sLName = sLongName;
	}
	else
	{
	    sLongName = StringUtil.nullToEmpty(cifVO.getLONG_NAME_ENG()).trim().toLowerCase().replaceAll("'", "''");
	    sLongNameAR = StringUtil.nullToEmpty(cifVO.getLONG_NAME_ARAB()).trim().toLowerCase().replaceAll("'", "''");
	    sBriefName = StringUtil.nullToEmpty(cifVO.getSHORT_NAME_ENG()).trim().toLowerCase().replaceAll("'", "''");
	    sBriefNameAR = StringUtil.nullToEmpty(cifVO.getSHORT_NAME_ARAB()).trim().toLowerCase().replaceAll("'",
		    "''");
	    sLName = StringUtil.nullToEmpty(cifVO.getLAST_NAME_ENG()).trim().toLowerCase().replaceAll("'", "''");
	    sFName = StringUtil.nullToEmpty(cifVO.getFIRST_NAME_ENG()).trim().toLowerCase().replaceAll("'", "''");
	    sSecName = StringUtil.nullToEmpty(cifVO.getSEC_NAME_ENG()).trim().toLowerCase().replaceAll("'", "''");
	    sThrdName = StringUtil.nullToEmpty(cifVO.getTHIRD_NAME_ENG()).trim().toLowerCase().replaceAll("'", "''");
	    sLNameAR = StringUtil.nullToEmpty(cifVO.getLAST_NAME_AR()).trim().toLowerCase().replaceAll("'", "''");
	    sFNameAR = StringUtil.nullToEmpty(cifVO.getFIRST_NAME_AR()).trim().toLowerCase().replaceAll("'", "''");
	    sSecNameAR = StringUtil.nullToEmpty(cifVO.getSEC_NAME_AR()).trim().toLowerCase().replaceAll("'", "''");
	    sThrdNameAR = StringUtil.nullToEmpty(cifVO.getTHIRD_NAME_AR()).trim().toLowerCase().replaceAll("'", "''");
	    sMotherFName = StringUtil.nullToEmpty(cifVO.getMOTHER_FIRST_NAME()).trim().toLowerCase().replaceAll("'",
		    "''");
	    sMotherLName = StringUtil.nullToEmpty(cifVO.getMOTHER_LAST_NAME()).trim().toLowerCase().replaceAll("'",
		    "''");
	    sBPlace = StringUtil.nullToEmpty(cifVO.getPLACE_OF_BIRTH()).trim().toLowerCase().replaceAll("'", "''");
	    sIdNo = StringUtil.nullToEmpty(cifVO.getID_NO()).trim().toLowerCase().replaceAll("'", "''");
	    bdCountry = NumberUtil.nullToZero(cifVO.getCOUNTRY());
	    // bdRegion = NumberUtil.nullToZero(cifVO.getREGION_CODE());
	    bdRegion = NumberUtil.nullToZero(mosBlackListCO.getRegionCode());
	    bdNation = NumberUtil.nullToZero(cifVO.getNATION_CODE());
	    bdRegno = NumberUtil.nullToZero(cifVO.getREGISTER_NO());
	    bdLegal = NumberUtil.nullToZero(cifVO.getLEGAL_STATUS());
	    ldtBDate = cifVO.getBIRTH_DATE();
	    bdIdType = NumberUtil.nullToZero(cifVO.getID_TYPE());
	}

	Boolean bQueryExistMOS = false;
	Boolean bQueryExistOFAC = false;
	Boolean bQueryExistUN = false;
	Boolean bFirstCond = true;
	List<BigDecimal> bdList = null;

	MosBlackListSC mosBlackListSC = new MosBlackListSC();

	// in the future in case different and/or parameter is created for each
	// attribute, we'll be having different AndOr parameters set
	// independently
	mosBlackListSC.setAndOR(sAndOR);
	int blackListCriteria = 0;
	BigDecimal criteriaMatchRes;

	// Fill the criteria mosBlackListSC to compose the query
	// Long Name
	if(sBlkLName.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(sLongName == null || sLongName.equals("") || sLongNameAR == null || sLongNameAR.equals(""))
	    {
		if(sLongName != null && !sLongName.equals("") && (sLongNameAR == null || sLongNameAR.equals("")))
		{
		    mosBlackListSC.setQcBlkLName("E");
		    mosBlackListSC.setLongNameEng(sLongName);
		    bQueryExistMOS = true;
		}
		else if((sLongName == null || sLongName.equals("")) && sLongNameAR != null && !sLongNameAR.equals(""))
		{
		    mosBlackListSC.setQcBlkLName("A");
		    mosBlackListSC.setLongNameArab(sLongNameAR);
		    bQueryExistMOS = true;
		}
	    }
	    else
	    {
		mosBlackListSC.setQcBlkLName("EA");
		mosBlackListSC.setLongNameEng(sLongName);
		mosBlackListSC.setLongNameArab(sLongNameAR);
		bQueryExistMOS = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkLName()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkLNameCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkLNameCond(sAndOR);
	    }
	}

	// Brief Name
	if(sBlkBName.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(sBriefName == null || sBriefName.equals("") || sBriefNameAR == null || sBriefNameAR.equals(""))
	    {
		if(sBriefName != null && !sBriefName.equals("") && (sBriefNameAR == null || sBriefNameAR.equals("")))
		{
		    mosBlackListSC.setQcBlkBName("E");
		    mosBlackListSC.setShortNameEng(sBriefName);
		    bQueryExistMOS = true;
		}
		else if((sBriefName == null || sBriefName.equals("")) && sBriefNameAR != null
			&& !sBriefNameAR.equals(""))
		{
		    mosBlackListSC.setQcBlkBName("A");
		    mosBlackListSC.setShortNameArab(sBriefNameAR);
		    bQueryExistMOS = true;
		}
	    }
	    else
	    {
		mosBlackListSC.setQcBlkBName("EA");
		mosBlackListSC.setShortNameEng(sBriefName);
		mosBlackListSC.setShortNameArab(sBriefNameAR);
		bQueryExistMOS = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkBName()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkBNameCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkBNameCond(sAndOR);
	    }
	}

	// Last Name //UN NAME4
	if(sBlkLastName.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(sLName == null || sLName.equals("") || sLNameAR == null || sLNameAR.equals(""))
	    {
		if(sLName != null && !sLName.equals("") && (sLNameAR == null || sLNameAR.equals("")))
		{
		    mosBlackListSC.setQcBlkLastName("E");
		    mosBlackListSC.setLastNameEng(sLName);
		    bQueryExistMOS = true;
		    bQueryExistUN = true;
		}
		else if((sLName == null || sLName.equals("")) && sLNameAR != null && !sLNameAR.equals(""))
		{
		    mosBlackListSC.setQcBlkLastName("A");
		    mosBlackListSC.setLastNameAr(sLNameAR);
		    bQueryExistMOS = true;
		}
	    }
	    else
	    {
		mosBlackListSC.setQcBlkLastName("EA");
		mosBlackListSC.setLastNameEng(sLName);
		mosBlackListSC.setLastNameAr(sLNameAR);
		bQueryExistMOS = true;
		bQueryExistUN = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkLastName()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkLastNameCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkLastNameCond(sAndOR);
	    }
	}

	// Third Name //UN NAME3
	if(sBlkThrdName.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(sThrdName == null || sThrdName.equals("") || sThrdNameAR == null || sThrdNameAR.equals(""))
	    {
		if(sThrdName != null && !sThrdName.equals("") && (sThrdNameAR == null || sThrdNameAR.equals("")))
		{
		    mosBlackListSC.setQcBlkThrdName("E");
		    mosBlackListSC.setThirdNameEng(sThrdName);
		    bQueryExistMOS = true;
		    bQueryExistUN = true;
		}
		else if((sThrdName == null || sThrdName.equals("")) && sThrdNameAR != null && !sThrdNameAR.equals(""))
		{
		    mosBlackListSC.setQcBlkThrdName("A");
		    mosBlackListSC.setThirdNameAr(sThrdNameAR);
		    bQueryExistMOS = true;
		}
	    }
	    else
	    {
		mosBlackListSC.setQcBlkThrdName("EA");
		mosBlackListSC.setThirdNameEng(sThrdName);
		mosBlackListSC.setThirdNameAr(sThrdNameAR);
		bQueryExistMOS = true;
		bQueryExistUN = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkThrdName()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkThrdNameCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkThrdNameCond(sAndOR);
	    }
	}

	// Second Name //UN NAME2
	if(sBlkSecName.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(sSecName == null || sSecName.equals("") || sSecNameAR == null || sSecNameAR.equals(""))
	    {
		if(sSecName != null && !sSecName.equals("") && (sSecNameAR == null || sSecNameAR.equals("")))
		{
		    mosBlackListSC.setQcBlkSecName("E");
		    mosBlackListSC.setSecNameEng(sSecName);
		    bQueryExistMOS = true;
		    bQueryExistUN = true;
		}
		else if((sSecName == null || sSecName.equals("")) && sSecNameAR != null && !sSecNameAR.equals(""))
		{
		    mosBlackListSC.setQcBlkSecName("A");
		    mosBlackListSC.setSecNameAr(sSecNameAR);
		    bQueryExistMOS = true;
		}
	    }
	    else
	    {
		mosBlackListSC.setQcBlkSecName("EA");
		mosBlackListSC.setSecNameEng(sSecName);
		mosBlackListSC.setSecNameAr(sSecNameAR);
		bQueryExistMOS = true;
		bQueryExistUN = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkSecName()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkSecNameCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkSecNameCond(sAndOR);
	    }
	}

	// First Name //UN NAME1 //OFAC SDN_NAME
	if(sBlkFName.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(sFName == null || sFName.equals("") || sFNameAR == null || sFNameAR.equals(""))
	    {
		if(sFName != null && !sFName.equals("") && (sFNameAR == null || sFNameAR.equals("")))
		{
		    mosBlackListSC.setQcBlkFName("E");
		    mosBlackListSC.setFirstNameEng(sFName);
		    bQueryExistMOS = true;
		    bQueryExistUN = true;
		    bQueryExistOFAC = true;
		}
		else if((sFName == null || sFName.equals("")) && sFNameAR != null && !sFNameAR.equals(""))
		{
		    mosBlackListSC.setQcBlkFName("A");
		    mosBlackListSC.setFirstNameAr(sFNameAR);
		    bQueryExistMOS = true;
		}
	    }
	    else
	    {
		mosBlackListSC.setQcBlkFName("EA");
		mosBlackListSC.setFirstNameEng(sFName);
		mosBlackListSC.setFirstNameAr(sFNameAR);
		bQueryExistMOS = true;
		bQueryExistUN = true;
		bQueryExistOFAC = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkFName()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkFNameCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkFNameCond(sAndOR);
	    }
	}

	// Mother First Name
	if(sBlkMFName.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(sMotherFName != null && !sMotherFName.equals(""))
	    {
		mosBlackListSC.setQcBlkMFName("E");
		mosBlackListSC.setMotherFirstName(sMotherFName);
		bQueryExistMOS = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkMFName()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkMFNameCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkMFNameCond(sAndOR);
	    }
	}

	// Mother Last Name
	if(sBlkMLName.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(sMotherLName != null && !sMotherLName.equals(""))
	    {
		mosBlackListSC.setQcBlkMLName("E");
		mosBlackListSC.setMotherLastName(sMotherLName);
		bQueryExistMOS = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkMLName()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkMLNameCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkMLNameCond(sAndOR);
	    }
	}

	// Region
	if(sBlkRegion.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(NumberUtil.isNumberPositive(bdRegion))
	    {
		mosBlackListSC.setQcBlkRegion("E");
		mosBlackListSC.setlRegion(bdRegion);
		bQueryExistMOS = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkRegion()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkRegionCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkRegionCond(sAndOR);
	    }
	}

	// Country
	if(sBlkCountry.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(NumberUtil.isNumberPositive(bdCountry))
	    {
		mosBlackListSC.setQcBlkCountry("E");
		mosBlackListSC.setlCountry(bdCountry);
		bQueryExistMOS = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkCountry()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkCountryCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkCountryCond(sAndOR);
	    }
	}

	// Nation
	if(sBlkNation.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(NumberUtil.isNumberPositive(bdNation))
	    {
		mosBlackListSC.setQcBlkNation("E");
		mosBlackListSC.setlNation(bdNation);
		bQueryExistMOS = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkNation()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkNationCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkNationCond(sAndOR);
	    }
	}

	// DATE OF BIRTH //UN DOB
	if(sBlkBdate.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(ldtBDate != null && ldtBDate.compareTo(DateUtil.parseDate("01/01/1900", "dd/mm/yyyy")) != 0)
	    {
		mosBlackListSC.setQcBlkBdate("E");
		mosBlackListSC.setLdtBDate(ldtBDate);
		bQueryExistMOS = true;
		bQueryExistUN = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkBdate()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkBdateCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkBdateCond(sAndOR);
	    }
	}

	// PLACE OF BIRTH
	if(sBlkBPlace.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(sBPlace != null && !sBPlace.equals(""))
	    {
		mosBlackListSC.setQcBlkBPlace("E");
		mosBlackListSC.setbPlace(sBPlace);
		bQueryExistMOS = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkBPlace()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkBPlaceCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkBPlaceCond(sAndOR);
	    }
	}

	// Register No
	if(sBlkRegNo.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(NumberUtil.isNumberPositive(bdRegno))
	    {
		mosBlackListSC.setQcBlkRegNo("E");
		mosBlackListSC.setlRegno(bdRegno);
		bQueryExistMOS = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkRegNo()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkRegNoCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkRegNoCond(sAndOR);
	    }
	}

	// Legal Status
	if(sBlkLegal.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(NumberUtil.isNumberPositive(bdLegal))
	    {
		mosBlackListSC.setQcBlkLegal("E"); // to remove
		mosBlackListSC.setlLegal(bdLegal);
		bQueryExistMOS = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkLegal()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkLegalCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkLegalCond(sAndOR);
	    }
	}

	// OID_DOCUMENT_NBR //MOSBLACKLIST_ID ID_NO //UN PASSPORT_NO
	if(sBlkIdNo.equals(ConstantsCommon.BLACKLISTENABLED))
	{
	    blackListCriteria = blackListCriteria + 1;
	    if(sIdNo != null && !sIdNo.equals(""))
	    {
		mosBlackListSC.setQcBlkIdNo("E");
		mosBlackListSC.setIdNo(sIdNo);
		mosBlackListSC.setlIdType(bdIdType);
		bQueryExistMOS = true;
		bQueryExistUN = true;
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkIdNo()) && bFirstCond)
	    {
		mosBlackListSC.setQcBlkIdNoCond("");
		bFirstCond = false;
	    }
	    else
	    {
		mosBlackListSC.setQcBlkIdNoCond(sAndOR);
	    }
	}

	// if any condition exist then execute the query
	// //mosBlackListDAO.returnMOSBlackListedCif(mosBlackListSC
	if(bQueryExistMOS)
	{
	    // clear the list of results if already filled
	    if(bdList != null)
	    {
		bdList.clear();
	    }
	    mosBlackListSC.setCompCode(mosBlackListCO.getCompCode());

	    if(!NumberUtil.isEmptyDecimal(criteriaPercent) && !(criteriaPercent.equals(0)))
	    {

		ArrayList<MosBlackListCO> blckLstCriteriaList = (ArrayList<MosBlackListCO>) mosBlackListDAO
			.returnCriteriaMatching(mosBlackListSC);

		int matchCount = 0;
		for(MosBlackListCO temp : blckLstCriteriaList)
		{
		  //id:1056020 Details:Blacklist CIF appear when create criteria matching less than percentage match falha
                    if (!(StringUtil.isEmptyString(temp.getCriteriaName())) && !" ".equals(temp.getCriteriaName()))
                	
                	
                    { 
		    BigDecimal criteriaCount = temp.getCriteriaCount();
		    if(criteriaCount.compareTo(BigDecimal.ZERO) == 1)
		    {

			matchCount++;
		    }
		    
		}

		}

		BigDecimal matchCountBd = new BigDecimal(matchCount);
		BigDecimal blackListCriteriaBd = new BigDecimal(blackListCriteria);
		criteriaMatchRes = (matchCountBd.divide(blackListCriteriaBd,2,RoundingMode.HALF_UP)) ;
		criteriaMatchRes = criteriaMatchRes.multiply(new BigDecimal(100));
		mosBlackListCO.setCriteriaPerc(criteriaMatchRes);

		if((criteriaMatchRes).floatValue() < (criteriaPercent).floatValue())
		{

		    bBlack = false;
		    return bBlack;

		}

		else
		{

		    for(MosBlackListCO temp : blckLstCriteriaList)
		    {
			if (!(StringUtil.isEmptyString(temp.getCriteriaName()))) {
			    
			
			if(temp.getCriteriaName().equals("LONG_NAME_ENG"))
			{
			    String longNameEn = cifVO.getLONG_NAME_ENG();
			    mosBlackListCO.getCriteriaMatchList().add("Long Name: " + longNameEn);

			}

			else if(temp.getCriteriaName().equals("BRIEF_NAME_ENG"))
			{
			    String briefNameEn = cifVO.getSHORT_NAME_ENG();
			    mosBlackListCO.getCriteriaMatchList().add("Brief Name: " + briefNameEn);

			}

			else if(temp.getCriteriaName().equals("CIF_LAST_NAME_ENG"))
			{
			    String lastNameEn = cifVO.getLAST_NAME_ENG();
			    mosBlackListCO.getCriteriaMatchList().add("Last Name: " + lastNameEn);

			}

			else if(temp.getCriteriaName().equals("CIF_THIRD_NAME_ENG"))
			{
			    String thirdNameEn = cifVO.getTHIRD_NAME_ENG();
			    mosBlackListCO.getCriteriaMatchList().add("Third Name: " + thirdNameEn);

			}

			else if(temp.getCriteriaName().equals("CIF_SEC_NAME_ENG"))
			{
			    String secNameEn = cifVO.getSEC_NAME_ENG();
			    mosBlackListCO.getCriteriaMatchList().add("Second Name: " + secNameEn);

			}

			else if(temp.getCriteriaName().equals("CIF_FIRST_NAME_ENG"))
			{
			    String firstNameEn = cifVO.getFIRST_NAME_ENG();
			    mosBlackListCO.getCriteriaMatchList().add("First Name: " + firstNameEn);

			}

			else if(temp.getCriteriaName().equals("CIF_MOTHER_FNAME"))
			{
			    String motherFNameEn = cifVO.getMOTHER_FIRST_NAME();
			    mosBlackListCO.getCriteriaMatchList().add("Mother First Name: " + motherFNameEn);

			}

			else if(temp.getCriteriaName().equals("CIF_MOTHER_LNAME"))
			{
			    String motherLNameEn = cifVO.getMOTHER_LAST_NAME();
			    mosBlackListCO.getCriteriaMatchList().add("Mother Last Name: " + motherLNameEn);

			}

			else if(temp.getCriteriaName().equals("CIF_REGION_CODE"))
			{
			    BigDecimal region = cifVO.getREGION_CODE();
			    mosBlackListCO.getCriteriaMatchList().add("Region Code: " + region);

			}

			else if(temp.getCriteriaName().equals("COUNTRY"))
			{
			    BigDecimal country = cifVO.getCOUNTRY();
			    mosBlackListCO.getCriteriaMatchList().add("Country: " + country);

			}

			else if(temp.getCriteriaName().equals("CIF_NATION_CODE"))
			{
			    BigDecimal nation = cifVO.getNATION_CODE();
			    mosBlackListCO.getCriteriaMatchList().add("Nationality: " + nation);

			}

			else if(temp.getCriteriaName().equals("DATE_OF_BIRTH"))
			{
			    Date dateOfBirth = cifVO.getBIRTH_DATE();
			    mosBlackListCO.getCriteriaMatchList().add("Date of Birth: " + dateOfBirth);

			}

			else if(temp.getCriteriaName().equals("CIF_PLACE_OF_BIRTH"))
			{
			    String placeOfBirth = cifVO.getPLACE_OF_BIRTH();
			    mosBlackListCO.getCriteriaMatchList().add("Birth Place: " + placeOfBirth);

			}

			else if(temp.getCriteriaName().equals("CIF_REGISTER_NO"))
			{
			    BigDecimal registorNo = cifVO.getREGISTER_NO();
			    mosBlackListCO.getCriteriaMatchList().add("Registor No: " + registorNo);

			}

			else if(temp.getCriteriaName().equals("LEGAL_STATUS"))
			{
			    BigDecimal legalStatus = cifVO.getLEGAL_STATUS();
			    mosBlackListCO.getCriteriaMatchList().add("Legal Status: " + legalStatus);

			}

			else if(temp.getCriteriaName().equals("OID_DOCUMENT_NBR"))
			{
			    String idNo = cifVO.getID_NO();
			    mosBlackListCO.getCriteriaMatchList().add("ID No: " + idNo);

			}

			bBlack = true;
			
		    }

		    }

		}

	    }

	    bdList = mosBlackListDAO.returnMOSBlackListedCif(mosBlackListSC);

	    if(bdList != null && !bdList.isEmpty())
	    {
		ArrayList<CifBlckLstVO> cifBlckLstVO = mosBlackListCO.getCifBlckLstVO();

		BigDecimal bdBLCode = null;
		String sBLType = "";
		boolean bRecExist = false;

		// loop on the blacklisted records
		for(int j = 0; j < bdList.size(); j++)
		{
		    // loop to check if blacklisted records already exist
		    for(int i = 0; i < cifBlckLstVO.size(); i++)
		    {
			bBlack = true;
			bdBLCode = cifBlckLstVO.get(i).getBlCode();
			sBLType = cifBlckLstVO.get(i).getBlType();

			// check bl_code and bl_type of each record
			if(bdList.get(j) == bdBLCode && sBLType.equals(ConstantsCommon.BLCK_MOS))
			{
			    bRecExist = true;

			}

		    }
		    // if records does not exist then add to CifBlckLstVO
		    if(!bRecExist)
		    {
			CifBlckLstVO newBlckRec = new CifBlckLstVO();
			newBlckRec.setCompCode(mosBlackListCO.getFrom());
			newBlckRec.setBlChecked("1");
			newBlckRec.setBlCode(bdList.get(j));
			newBlckRec.setBlType(ConstantsCommon.BLCK_MOS);

			cifBlckLstVO.add(newBlckRec);
			bRecExist = false;
			bBlack = true;
		    }
		}
	    }
	}
	// same checking for UN_MAIN table
	if(bQueryExistUN)
	{
	    if(bdList != null)
	    {
		bdList.clear();
	    }

	    bdList = mosBlackListDAO.returnUNBlackListedCif(mosBlackListSC);

	    if(bdList != null && !bdList.isEmpty())
	    {
		ArrayList<CifBlckLstVO> cifBlckLstVO = mosBlackListCO.getCifBlckLstVO();

		BigDecimal bLCode = null;
		String bLType = "";
		boolean recExist = false;
		for(int j = 0; j < bdList.size(); j++)
		{
		    for(int i = 0; i < cifBlckLstVO.size(); i++)
		    {
			bBlack = true;
			bLCode = cifBlckLstVO.get(i).getBlCode();
			bLType = cifBlckLstVO.get(i).getBlType();

			if(bdList.get(j) == bLCode && bLType.equals(ConstantsCommon.BLCK_UN))
			{
			    recExist = true;

			}

		    }

		    if(!recExist)
		    {

			CifBlckLstVO newBlckRec = new CifBlckLstVO();
			newBlckRec.setCompCode(mosBlackListCO.getFrom());
			newBlckRec.setBlChecked("1");
			newBlckRec.setBlCode(bdList.get(j));
			newBlckRec.setBlType(ConstantsCommon.BLCK_UN);

			cifBlckLstVO.add(newBlckRec);
			recExist = false;
			bBlack = true;
		    }
		}
	    }
	}
	// same checking for OFAC_MAIN table
	if(bQueryExistOFAC)
	{
	    if(bdList != null)
	    {
		bdList.clear();
	    }
	    if(StringUtil.isNotEmpty(mosBlackListSC.getLongNameEng()))
	    {
		bdList = mosBlackListDAO.returnOFACBlackListedCif(mosBlackListSC);
	    }
	    if(bdList != null && !bdList.isEmpty())
	    {
		ArrayList<CifBlckLstVO> cifBlckLstVO = mosBlackListCO.getCifBlckLstVO();

		BigDecimal bLCode = null;
		String bLType = "";
		boolean recExist = false;
		for(int j = 0; j < bdList.size(); j++)
		{
		    for(int i = 0; i < cifBlckLstVO.size(); i++)
		    {
			bBlack = true;
			bLCode = cifBlckLstVO.get(i).getBlCode();
			bLType = cifBlckLstVO.get(i).getBlType();

			if(bdList.get(j) == bLCode && bLType.equals(ConstantsCommon.BLCK_OFAC))
			{
			    recExist = true;

			}

		    }

		    if(!recExist)
		    {
			CifBlckLstVO newBlckRec = new CifBlckLstVO();
			newBlckRec.setCompCode(mosBlackListCO.getFrom());
			newBlckRec.setBlChecked("1");
			newBlckRec.setBlCode(bdList.get(j));
			newBlckRec.setBlType(ConstantsCommon.BLCK_OFAC);

			cifBlckLstVO.add(newBlckRec);
			recExist = false;
			bBlack = true;
		    }
		}
	    }
	}

	// checking joint section

	if(StringUtil.isNotEmpty(mosBlackListCO.getAppName())
		&& (!mosBlackListCO.getAppName().equals(ConstantsCommon.SUKUK_APP_NAME)
			&& !mosBlackListCO.getAppName().equals(ConstantsCommon.DIRECT_INVEST_APP_NAME)
			&& !mosBlackListCO.getAppName().equals(ConstantsCommon.ASSETS_APP_NAME)))
	{
	    // Check Joint Accounts for blacklisted
	    List<FomCifJointAccCO> jointAccList = new ArrayList<FomCifJointAccCO>();

	    jointAccList = mosBlackListCO.getJointAccList();

	    // Same as the above procedure for each joint account
	    for(int n = 0; n < jointAccList.size(); n++)
	    {
		CIF_JOINT_DETVO jointAccDet = new CIF_JOINT_DETVO();

		bFirstCond = true;

		jointAccDet = jointAccList.get(n).getCifJointAccVO();

		sLongName = StringUtil.nullToEmpty(jointAccDet.getLONG_NAME_ENG()).trim().toLowerCase().replaceAll("'",
			"''");
		sLongNameAR = StringUtil.nullToEmpty(jointAccDet.getLONG_NAME_ARAB()).trim().toLowerCase()
			.replaceAll("'", "''");
		sBriefName = StringUtil.nullToEmpty(jointAccDet.getBRIEF_NAME_ENG()).trim().toLowerCase()
			.replaceAll("'", "''");
		sBriefNameAR = StringUtil.nullToEmpty(jointAccDet.getBRIEF_NAME_ARAB()).trim().toLowerCase()
			.replaceAll("'", "''");
		sLName = StringUtil.nullToEmpty(jointAccDet.getLAST_NAME_ENG()).trim().toLowerCase().replaceAll("'",
			"''");
		sFName = StringUtil.nullToEmpty(jointAccDet.getFIRST_NAME_ENG()).trim().toLowerCase().replaceAll("'",
			"''");
		sSecName = StringUtil.nullToEmpty(jointAccDet.getSECOND_NAME_ENG()).trim().toLowerCase().replaceAll("'",
			"''");
		sThrdName = StringUtil.nullToEmpty(jointAccDet.getTHIRD_NAME_ENG()).trim().toLowerCase().replaceAll("'",
			"''");
		sLNameAR = StringUtil.nullToEmpty(jointAccDet.getLAST_NAME_ARAB()).trim().toLowerCase().replaceAll("'",
			"''");
		sFNameAR = StringUtil.nullToEmpty(jointAccDet.getFIRST_NAME_ARAB()).trim().toLowerCase().replaceAll("'",
			"''");
		sSecNameAR = StringUtil.nullToEmpty(jointAccDet.getSECOND_NAME_ARAB()).trim().toLowerCase()
			.replaceAll("'", "''");
		sThrdNameAR = StringUtil.nullToEmpty(jointAccDet.getTHIRD_NAME_ARAB()).trim().toLowerCase()
			.replaceAll("'", "''");
		sIdNo = StringUtil.nullToEmpty(jointAccDet.getID_NO()).trim().toLowerCase().replaceAll("'", "''");
		bdNation = NumberUtil.nullToZero(jointAccDet.getNATION_CODE());
		ldtBDate = jointAccDet.getB_DATE();
		bdIdType = NumberUtil.nullToZero(jointAccDet.getID_TYPE());

		// Long Name
		if(sBlkLName.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(sLongName == null || sLongName.equals("") || sLongNameAR == null || sLongNameAR.equals(""))
		    {
			if(sLongName != null && !sLongName.equals("")
				&& (sLongNameAR == null || sLongNameAR.equals("")))
			{
			    mosBlackListSC.setQcBlkLName("E");
			    mosBlackListSC.setLongNameEng(sLongName);
			    bQueryExistMOS = true;
			}
			else if((sLongName == null || sLongName.equals("")) && sLongNameAR != null
				&& !sLongNameAR.equals(""))
			{
			    mosBlackListSC.setQcBlkLName("A");
			    mosBlackListSC.setLongNameArab(sLongNameAR);
			    bQueryExistMOS = true;
			}
		    }
		    else
		    {
			mosBlackListSC.setQcBlkLName("EA");
			mosBlackListSC.setLongNameEng(sLongName);
			mosBlackListSC.setLongNameArab(sLongNameAR);
			bQueryExistMOS = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkLName()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkLNameCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkLNameCond(sAndOR);
		    }
		}

		// Brief Name
		if(sBlkBName.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(sBriefName == null || sBriefName.equals("") || sBriefNameAR == null || sBriefNameAR.equals(""))
		    {
			if(sBriefName != null && !sBriefName.equals("")
				&& (sBriefNameAR == null || sBriefNameAR.equals("")))
			{
			    mosBlackListSC.setQcBlkBName("E");
			    mosBlackListSC.setShortNameEng(sBriefName);
			    bQueryExistMOS = true;
			}
			else if((sBriefName == null || sBriefName.equals("")) && sBriefNameAR != null
				&& !sBriefNameAR.equals(""))
			{
			    mosBlackListSC.setQcBlkBName("A");
			    mosBlackListSC.setShortNameArab(sBriefNameAR);
			    bQueryExistMOS = true;
			}
		    }
		    else
		    {
			mosBlackListSC.setQcBlkBName("EA");
			mosBlackListSC.setShortNameEng(sBriefName);
			mosBlackListSC.setShortNameArab(sBriefNameAR);
			bQueryExistMOS = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkBName()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkBNameCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkBNameCond(sAndOR);
		    }
		}

		// Last Name //UN NAME4
		if(sBlkLastName.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(sLName == null || sLName.equals("") || sLNameAR == null || sLNameAR.equals(""))
		    {
			if(sLName != null && !sLName.equals("") && (sLNameAR == null || sLNameAR.equals("")))
			{
			    mosBlackListSC.setQcBlkLastName("E");
			    mosBlackListSC.setLastNameEng(sLName);
			    bQueryExistMOS = true;
			    bQueryExistUN = true;
			}
			else if((sLName == null || sLName.equals("")) && sLNameAR != null && !sLNameAR.equals(""))
			{
			    mosBlackListSC.setQcBlkLastName("A");
			    mosBlackListSC.setLastNameAr(sLNameAR);
			    bQueryExistMOS = true;
			}
		    }
		    else
		    {
			mosBlackListSC.setQcBlkLastName("EA");
			mosBlackListSC.setLastNameEng(sLName);
			mosBlackListSC.setLastNameAr(sLNameAR);
			bQueryExistMOS = true;
			bQueryExistUN = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkLastName()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkLastNameCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkLastNameCond(sAndOR);
		    }
		}

		// Third Name //UN NAME3
		if(sBlkThrdName.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(sThrdName == null || sThrdName.equals("") || sThrdNameAR == null || sThrdNameAR.equals(""))
		    {
			if(sThrdName != null && !sThrdName.equals("")
				&& (sThrdNameAR == null || sThrdNameAR.equals("")))
			{
			    mosBlackListSC.setQcBlkThrdName("E");
			    mosBlackListSC.setThirdNameEng(sThrdName);
			    bQueryExistMOS = true;
			    bQueryExistUN = true;
			}
			else if((sThrdName == null || sThrdName.equals("")) && sThrdNameAR != null
				&& !sThrdNameAR.equals(""))
			{
			    mosBlackListSC.setQcBlkThrdName("A");
			    mosBlackListSC.setThirdNameAr(sThrdNameAR);
			    bQueryExistMOS = true;
			}
		    }
		    else
		    {
			mosBlackListSC.setQcBlkThrdName("EA");
			mosBlackListSC.setThirdNameEng(sThrdName);
			mosBlackListSC.setThirdNameAr(sThrdNameAR);
			bQueryExistMOS = true;
			bQueryExistUN = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkThrdName()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkThrdNameCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkThrdNameCond(sAndOR);
		    }
		}

		// Second Name //UN NAME2
		if(sBlkSecName.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(sSecName == null || sSecName.equals("") || sSecNameAR == null || sSecNameAR.equals(""))
		    {

			if(sSecName != null && !sSecName.equals("") && (sSecNameAR == null || sSecNameAR.equals("")))
			{
			    mosBlackListSC.setQcBlkSecName("E");
			    mosBlackListSC.setSecNameEng(sSecName);
			    bQueryExistMOS = true;
			    bQueryExistUN = true;
			}
			else if((sSecName == null || sSecName.equals("")) && sSecNameAR != null
				&& !sSecNameAR.equals(""))
			{
			    mosBlackListSC.setQcBlkSecName("A");
			    mosBlackListSC.setSecNameAr(sSecNameAR);
			    bQueryExistMOS = true;
			}
		    }
		    else
		    {
			mosBlackListSC.setQcBlkSecName("EA");
			mosBlackListSC.setSecNameEng(sSecName);
			mosBlackListSC.setSecNameAr(sSecNameAR);
			bQueryExistMOS = true;
			bQueryExistUN = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkSecName()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkSecNameCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkSecNameCond(sAndOR);
		    }
		}

		// First Name //UN NAME1 //OFAC SDN_NAME
		if(sBlkFName.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(sFName == null || sFName.equals("") || sFNameAR == null || sFNameAR.equals(""))
		    {
			if(sFName != null && !sFName.equals("") && (sFNameAR == null || sFNameAR.equals("")))
			{
			    mosBlackListSC.setQcBlkFName("E");
			    mosBlackListSC.setFirstNameEng(sFName);
			    bQueryExistMOS = true;
			    bQueryExistUN = true;
			    bQueryExistOFAC = true;
			}
			else
			{
			    if((sFName == null || sFName.equals("")) && sFNameAR != null && !sFNameAR.equals(""))
			    {
				mosBlackListSC.setQcBlkFName("A");
				mosBlackListSC.setFirstNameAr(sFNameAR);
				bQueryExistMOS = true;
			    }
			}
		    }
		    else
		    {
			mosBlackListSC.setQcBlkFName("EA");
			mosBlackListSC.setFirstNameEng(sFName);
			mosBlackListSC.setFirstNameAr(sFNameAR);
			bQueryExistMOS = true;
			bQueryExistUN = true;
			bQueryExistOFAC = true;
		    }

		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkFName()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkFNameCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkFNameCond(sAndOR);
		    }
		}

		// Mother First Name
		if(sBlkMFName.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(sMotherFName != null && !sMotherFName.equals(""))
		    {
			mosBlackListSC.setQcBlkMFName("E");
			mosBlackListSC.setMotherFirstName(sMotherFName);
			bQueryExistMOS = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkMFName()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkMFNameCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkMFNameCond(sAndOR);
		    }
		}

		// Mother Last Name
		if(sBlkMLName.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(sMotherLName != null && !sMotherLName.equals(""))
		    {
			mosBlackListSC.setQcBlkMLName("E");
			mosBlackListSC.setMotherLastName(sMotherLName);
			bQueryExistMOS = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkMLName()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkMLNameCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkMLNameCond(sAndOR);
		    }
		}

		// Region
		if(sBlkRegion.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(NumberUtil.isNumberPositive(bdRegion))
		    {
			mosBlackListSC.setQcBlkRegion("E");
			mosBlackListSC.setlRegion(bdRegion);
			bQueryExistMOS = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkRegion()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkRegionCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkRegionCond(sAndOR);
		    }
		}

		// Country
		if(sBlkCountry.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(NumberUtil.isNumberPositive(bdCountry))
		    {
			mosBlackListSC.setQcBlkCountry("E");
			mosBlackListSC.setlCountry(bdCountry);
			bQueryExistMOS = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkCountry()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkCountryCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkCountryCond(sAndOR);
		    }
		}

		// Nation
		if(sBlkNation.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(NumberUtil.isNumberPositive(bdNation))
		    {
			mosBlackListSC.setQcBlkNation("E");
			mosBlackListSC.setlNation(bdNation);
			bQueryExistMOS = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkNation()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkNationCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkNationCond(sAndOR);
		    }
		}

		// DATE OF BIRTH //UN DOB
		if(sBlkBdate.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(ldtBDate != null && ldtBDate.compareTo(DateUtil.parseDate("01/01/1900", "dd/mm/yyyy")) != 0)
		    {
			mosBlackListSC.setQcBlkBdate("E");
			mosBlackListSC.setLdtBDate(ldtBDate);
			bQueryExistMOS = true;
			bQueryExistUN = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkBdate()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkBdateCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkBdateCond(sAndOR);
		    }
		}

		// PLACE OF BIRTH
		if(sBlkBPlace.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(sBPlace != null && !sBPlace.equals(""))
		    {
			mosBlackListSC.setQcBlkBPlace("E");
			mosBlackListSC.setbPlace(sBPlace);
			bQueryExistMOS = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkBPlace()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkBPlaceCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkBPlaceCond(sAndOR);
		    }
		}

		// Register No
		if(sBlkRegNo.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(NumberUtil.isNumberPositive(bdRegno))
		    {
			mosBlackListSC.setQcBlkRegNo("E");
			mosBlackListSC.setlRegno(bdRegno);
			bQueryExistMOS = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkRegNo()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkRegNoCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkRegNoCond(sAndOR);
		    }
		}

		// Legal Status
		if(sBlkLegal.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(NumberUtil.isNumberPositive(bdLegal))
		    {
			mosBlackListSC.setQcBlkLegal("E"); // to remove
			mosBlackListSC.setlLegal(bdLegal);
			bQueryExistMOS = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkLegal()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkLegalCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkLegalCond(sAndOR);
		    }
		}

		// OID_DOCUMENT_NBR //MOSBLACKLIST_ID ID_NO //UN PASSPORT_NO
		if(sBlkIdNo.equals(ConstantsCommon.BLACKLISTENABLED))
		{
		    if(sIdNo != null && !sIdNo.equals(""))
		    {
			mosBlackListSC.setQcBlkIdNo("E");
			mosBlackListSC.setIdNo(sIdNo);
			mosBlackListSC.setlIdType(bdIdType);
			bQueryExistMOS = true;
			bQueryExistUN = true;
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getQcBlkIdNo()) && bFirstCond)
		    {
			mosBlackListSC.setQcBlkIdNoCond("");
			bFirstCond = false;
		    }
		    else
		    {
			mosBlackListSC.setQcBlkIdNoCond(sAndOR);
		    }
		}

		// ////////////////////////////////////////////////////////////////////////////////////////////////
		if(bQueryExistMOS)
		{
		    if(bdList != null)
		    {
			bdList.clear();
		    }

		    if(!NumberUtil.isEmptyDecimal(criteriaPercent) && !(criteriaPercent.equals(0)))
		    {

			ArrayList<MosBlackListCO> blckLstCriteriaList = (ArrayList<MosBlackListCO>) mosBlackListDAO
				.returnCriteriaMatching(mosBlackListSC);

			int matchCount = 0;
			for(MosBlackListCO temp : blckLstCriteriaList)
			{

			    BigDecimal criteriaCount = temp.getCriteriaCount();
			    if(criteriaCount.compareTo(BigDecimal.ZERO) == 1)
			    {

				matchCount++;
			    }

			}

			BigDecimal matchCountBd = new BigDecimal(matchCount);
			BigDecimal blackListCriteriaBd = new BigDecimal(blackListCriteria);
			criteriaMatchRes = (matchCountBd.divide(blackListCriteriaBd));
			criteriaMatchRes = criteriaMatchRes.multiply(new BigDecimal(100));

			if((criteriaMatchRes).floatValue() < (criteriaPercent).floatValue())
			{

			    bBlack = false;
			    return bBlack;

			}

			else
			{

			    for(MosBlackListCO temp : blckLstCriteriaList)
			    {
				if(temp.getCriteriaName().equals("LONG_NAME_ENG"))
				{
				    String longNameEn = cifVO.getLONG_NAME_ENG();
				    mosBlackListCO.getCriteriaMatchList().add("Long Name: " + longNameEn);

				}

				else if(temp.getCriteriaName().equals("BRIEF_NAME_ENG"))
				{
				    String briefNameEn = cifVO.getSHORT_NAME_ENG();
				    mosBlackListCO.getCriteriaMatchList().add("Brief Name: " + briefNameEn);

				}

				else if(temp.getCriteriaName().equals("CIF_LAST_NAME_ENG"))
				{
				    String lastNameEn = cifVO.getLAST_NAME_ENG();
				    mosBlackListCO.getCriteriaMatchList().add("Last Name: " + lastNameEn);

				}

				else if(temp.getCriteriaName().equals("CIF_THIRD_NAME_ENG"))
				{
				    String thirdNameEn = cifVO.getTHIRD_NAME_ENG();
				    mosBlackListCO.getCriteriaMatchList().add("Third Name: " + thirdNameEn);

				}

				else if(temp.getCriteriaName().equals("CIF_SEC_NAME_ENG"))
				{
				    String secNameEn = cifVO.getSEC_NAME_ENG();
				    mosBlackListCO.getCriteriaMatchList().add("Second Name: " + secNameEn);

				}

				else if(temp.getCriteriaName().equals("CIF_FIRST_NAME_ENG"))
				{
				    String firstNameEn = cifVO.getFIRST_NAME_ENG();
				    mosBlackListCO.getCriteriaMatchList().add("First Name: " + firstNameEn);

				}

				else if(temp.getCriteriaName().equals("CIF_MOTHER_FNAME"))
				{
				    String motherFNameEn = cifVO.getMOTHER_FIRST_NAME();
				    mosBlackListCO.getCriteriaMatchList().add("Mother First Name: " + motherFNameEn);

				}

				else if(temp.getCriteriaName().equals("CIF_MOTHER_LNAME"))
				{
				    String motherLNameEn = cifVO.getMOTHER_LAST_NAME();
				    mosBlackListCO.getCriteriaMatchList().add("Mother Last Name: " + motherLNameEn);

				}

				else if(temp.getCriteriaName().equals("CIF_REGION_CODE"))
				{
				    BigDecimal region = cifVO.getREGION_CODE();
				    mosBlackListCO.getCriteriaMatchList().add("Region Code: " + region);

				}

				else if(temp.getCriteriaName().equals("COUNTRY"))
				{
				    BigDecimal country = cifVO.getCOUNTRY();
				    mosBlackListCO.getCriteriaMatchList().add("Country: " + country);

				}

				else if(temp.getCriteriaName().equals("CIF_NATION_CODE"))
				{
				    BigDecimal nation = cifVO.getNATION_CODE();
				    mosBlackListCO.getCriteriaMatchList().add("Nationality: " + nation);

				}

				else if(temp.getCriteriaName().equals("DATE_OF_BIRTH"))
				{
				    Date dateOfBirth = cifVO.getBIRTH_DATE();
				    mosBlackListCO.getCriteriaMatchList().add("Date of Birth: " + dateOfBirth);

				}

				else if(temp.getCriteriaName().equals("CIF_PLACE_OF_BIRTH"))
				{
				    String placeOfBirth = cifVO.getPLACE_OF_BIRTH();
				    mosBlackListCO.getCriteriaMatchList().add("Birth Place: " + placeOfBirth);

				}

				else if(temp.getCriteriaName().equals("CIF_REGISTER_NO"))
				{
				    BigDecimal registorNo = cifVO.getREGISTER_NO();
				    mosBlackListCO.getCriteriaMatchList().add("Registor No: " + registorNo);

				}

				else if(temp.getCriteriaName().equals("LEGAL_STATUS"))
				{
				    BigDecimal legalStatus = cifVO.getLEGAL_STATUS();
				    mosBlackListCO.getCriteriaMatchList().add("Legal Status: " + legalStatus);

				}

				else if(temp.getCriteriaName().equals("OID_DOCUMENT_NBR"))
				{
				    String idNo = cifVO.getID_NO();
				    mosBlackListCO.getCriteriaMatchList().add("ID No: " + idNo);

				}

				bBlack = true;

			    }

			}

		    }

		    if(StringUtil.isNotEmpty(mosBlackListSC.getLongNameEng()))
		    {
			bdList = mosBlackListDAO.returnMOSBlackListedCif(mosBlackListSC);
		    }

		    if(bdList != null && !bdList.isEmpty())
		    {
			ArrayList<CifBlckLstVO> cifBlckLstVO = mosBlackListCO.getCifBlckLstVO();

			BigDecimal bLCode = null;
			String bLType = "";
			boolean recExist = false;
			for(int j = 0; j < bdList.size(); j++)
			{
			    for(int i = 0; i < cifBlckLstVO.size(); i++)
			    {
				bBlack = true;
				bLCode = cifBlckLstVO.get(i).getBlCode();
				bLType = cifBlckLstVO.get(i).getBlType();

				if(bdList.get(j) == bLCode && bLType.equals(ConstantsCommon.BLCK_MOS))
				{
				    recExist = true;

				}

			    }

			    if(!recExist)
			    {
				CifBlckLstVO newBlckRec = new CifBlckLstVO();
				newBlckRec.setCompCode(mosBlackListCO.getFrom());
				newBlckRec.setBlChecked("1");
				newBlckRec.setBlCode(bdList.get(j));
				newBlckRec.setBlType(ConstantsCommon.BLCK_MOS);

				cifBlckLstVO.add(newBlckRec);
				recExist = false;
				bBlack = true;
			    }
			}
		    }
		}
		if(bQueryExistUN)
		{
		    if(bdList != null)
		    {
			bdList.clear();
		    }

		    bdList = mosBlackListDAO.returnUNBlackListedCif(mosBlackListSC);

		    if(bdList != null && !bdList.isEmpty())
		    {
			ArrayList<CifBlckLstVO> cifBlckLstVO = mosBlackListCO.getCifBlckLstVO();

			BigDecimal bLCode = null;
			String bLType = "";
			boolean recExist = false;
			for(int j = 0; j < bdList.size(); j++)
			{
			    for(int i = 0; i < cifBlckLstVO.size(); i++)
			    {
				bBlack = true;
				bLCode = cifBlckLstVO.get(i).getBlCode();
				bLType = cifBlckLstVO.get(i).getBlType();

				if(bdList.get(j) == bLCode && bLType.equals(ConstantsCommon.BLCK_UN))
				{
				    recExist = true;

				}

			    }

			    if(!recExist)
			    {
				CifBlckLstVO newBlckRec = new CifBlckLstVO();
				newBlckRec.setCompCode(mosBlackListCO.getFrom());
				newBlckRec.setBlChecked("1");
				newBlckRec.setBlCode(bdList.get(j));
				newBlckRec.setBlType(ConstantsCommon.BLCK_UN);

				cifBlckLstVO.add(newBlckRec);
				recExist = false;
				bBlack = true;
			    }
			}
		    }
		}
		if(bQueryExistOFAC)
		{
		    if(bdList != null)
		    {
			bdList.clear();
		    }
		    if(StringUtil.isNotEmpty(mosBlackListSC.getLongNameEng()))
		    {
			bdList = mosBlackListDAO.returnOFACBlackListedCif(mosBlackListSC);
		    }

		    if(bdList != null && !bdList.isEmpty())
		    {
			ArrayList<CifBlckLstVO> cifBlckLstVO = mosBlackListCO.getCifBlckLstVO();

			BigDecimal bLCode = null;
			String bLType = "";
			boolean recExist = false;
			for(int j = 0; j < bdList.size(); j++)
			{
			    for(int i = 0; i < cifBlckLstVO.size(); i++)
			    {
				bBlack = true;
				bLCode = cifBlckLstVO.get(i).getBlCode();
				bLType = cifBlckLstVO.get(i).getBlType();

				if(bdList.get(j) == bLCode && bLType.equals(ConstantsCommon.BLCK_OFAC))
				{
				    recExist = true;

				}

			    }

			    if(!recExist)
			    {
				CifBlckLstVO newBlckRec = new CifBlckLstVO();
				newBlckRec.setCompCode(mosBlackListCO.getFrom());
				newBlckRec.setBlChecked("1");
				newBlckRec.setBlCode(bdList.get(j));
				newBlckRec.setBlType(ConstantsCommon.BLCK_OFAC);

				cifBlckLstVO.add(newBlckRec);
				recExist = false;
				bBlack = true;
			    }
			}
		    }
		}
	    }

	}

	return bBlack;
    }

    /**
     * 
     * @param mosBlackListSC
     * @return
     * @throws BaseException
     */
    public ArrayList<CifBlckLstVO> checkIdBlcklist(MosBlackListSC mosBlackListSC) throws BaseException

    {
	List<BigDecimal> bdList = null;
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();

	cifControlVO.setCOMP_CODE(mosBlackListSC.getCompCode());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);

	String sBlcklIDNO = cifControlVO.getBLCKL_IDNO();

	ArrayList<CifBlckLstVO> cifBlckLstVO = mosBlackListDAO.returncifBlackList(mosBlackListSC);

	for(int i = 0; i < cifBlckLstVO.size(); i++)
	{
	    String sIdType = "", sColname, sBLType;

	    sBLType = StringUtil.nullToEmpty(cifBlckLstVO.get(i).getBlType());
	    sIdType = StringUtil.nullToEmpty(cifBlckLstVO.get(i).getIdType());
	    sColname = StringUtil.nullToEmpty(cifBlckLstVO.get(i).getColumnName());

	    if(sBLType.equals(ConstantsCommon.BLCK_MOS) && sColname.equals(mosBlackListSC.getsColname())
		    && sIdType.equals(String.valueOf(mosBlackListSC.getlIdType())))
	    {
		cifBlckLstVO.remove(i);
	    }
	}

	if("1".equals(sBlcklIDNO) && StringUtil.nullToEmpty(mosBlackListSC.getsType()).equals(NCifMaintenanceConstant.CIF_IS_INDIVIDUAL))
	{
	    bdList = mosBlackListDAO.returnBlackListByID(mosBlackListSC);
	    if(bdList != null && !bdList.isEmpty())
	    {
		for(int j = 0; j < bdList.size(); j++)
		{

		    CifBlckLstVO newBlckRec = new CifBlckLstVO();
		    newBlckRec.setCompCode(mosBlackListSC.getCompCode());
		    newBlckRec.setBlChecked(sBlcklIDNO);
		    newBlckRec.setBlCode(bdList.get(j));
		    newBlckRec.setBlType(ConstantsCommon.BLCK_MOS);
		    newBlckRec.setColumnName(StringUtil.nullToEmpty(mosBlackListSC.getsColname()));
		    newBlckRec.setIdType(StringUtil.nullToEmpty(mosBlackListSC.getlIdType()).toString());
		    newBlckRec.setReturnBlCode(NumberUtil.emptyDecimalToZero(bdList.get(j)));
		    cifBlckLstVO.add(newBlckRec);

		}
	    }
	}

	else
	{
	    if(StringUtil.isNotEmpty(mosBlackListSC.getLongNameEng()))
	    {
		bdList = mosBlackListDAO.returnMOSBlackListedCif(mosBlackListSC);
	    }
	    if(bdList != null && !bdList.isEmpty())
	    {
		for(int j = 0; j < bdList.size(); j++)
		{

		    CifBlckLstVO newBlckRec = new CifBlckLstVO();
		    newBlckRec.setCompCode(mosBlackListSC.getCompCode());
		    newBlckRec.setBlChecked(sBlcklIDNO);
		    newBlckRec.setBlCode(bdList.get(j));
		    newBlckRec.setBlType(ConstantsCommon.BLCK_MOS);
		    newBlckRec.setColumnName(StringUtil.nullToEmpty(mosBlackListSC.getsColname()));
		    newBlckRec.setIdType(StringUtil.nullToEmpty(mosBlackListSC.getlIdType()).toString());
		    newBlckRec.setReturnBlCode(NumberUtil.emptyDecimalToZero(bdList.get(j)));
		    cifBlckLstVO.add(newBlckRec);

		}
	    }
	}

	return cifBlckLstVO;
    }

    public MosBlackListCO checkSucpiciousIdBlcklist(MosBlackListSC mosBlackListSC) throws BaseException

    {
	String sBlcklIDNO, sBlacklistType, sBlacklistSource;
	BigDecimal bdMosBlkCode, bdBlacklistType, bdBlacklistSource;
	boolean blFound = false;

	MosBlackListCO mosBlackListCO = new MosBlackListCO();

	ArrayList<CifBlckLstVO> cifBlckLstVO = checkIdBlcklist(mosBlackListSC);
	if(cifBlckLstVO != null && !cifBlckLstVO.isEmpty() && NumberUtil.emptyDecimalToZero(cifBlckLstVO.get(cifBlckLstVO.size() - 1).getReturnBlCode()).compareTo(BigDecimal.ZERO) > 0 )
	{

	    bdMosBlkCode = NumberUtil.nullToZero(cifBlckLstVO.get(cifBlckLstVO.size() - 1).getReturnBlCode());
	    mosBlackListSC.setBdMosBlkCode(bdMosBlkCode);
	    mosBlackListCO = mosBlackListDAO.returnBlkTypeSource(mosBlackListSC);
	    
	    if(mosBlackListCO == null)
	    {
		mosBlackListCO = new MosBlackListCO();
	    }
	    sBlacklistType = StringUtil.nullToEmpty(mosBlackListCO.getBlacklistType());
	    sBlacklistSource = StringUtil.nullToEmpty(mosBlackListCO.getBlacklistSource());
	    bdBlacklistType = NumberUtil.nullToZero(mosBlackListCO.getCodeType());
	    bdBlacklistSource = NumberUtil.nullToZero(mosBlackListCO.getCodeSource());

	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(mosBlackListSC.getCompCode());
	    cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);

	    sBlcklIDNO = StringUtil.nullToEmpty(cifControlVO.getBLCKL_IDNO());

	    if(sBlcklIDNO.equals(ConstantsCommon.BLACKLISTENABLED))
	    {
				if(mosBlackListSC.getCifControlRecordFlag() == null)
				{
				    throw new BOException(MessageCodes.CIF_IS_BLACKLISTED,
					    new String[] { "as CIF control record. Do you want to proceed ?" },
					    ConstantsCommon.CONFIRM_MSG_TYPE, ConstantsCommon.BLACKLISTED_CIF_CONFIRMATION);
				}
				else if(mosBlackListSC.getCifControlRecordFlag())
				{
				    mosBlackListCO.setBlackListed(BigDecimal.ONE);
				    mosBlackListCO.setProceedBlackListed(BigDecimal.ONE);
				    return mosBlackListCO;
				}
		else
		{
		    for(int i = 0; i < cifBlckLstVO.size(); i++)
		    {
			String sIdType = "", sColname, sBLType;

			sBLType = StringUtil.nullToEmpty(cifBlckLstVO.get(i).getBlType());
			sIdType = StringUtil.nullToEmpty(cifBlckLstVO.get(i).getIdType());
			sColname = StringUtil.nullToEmpty(cifBlckLstVO.get(i).getColumnName());
			if(sBLType.equals(ConstantsCommon.BLCK_MOS) && sColname.equals(mosBlackListSC.getsColname())
				&& mosBlackListSC.getlIdType() != null && sIdType.equals(mosBlackListSC.getlIdType().toString()))
			{
			    cifBlckLstVO.remove(i);
			}

		    }
		}

	    }
	    else
	    {
		if(mosBlackListSC.getCifSuspiciousFlag() == null)
		{
		    throw new BOException(MessageCodes.CIF_IS_SUSPICIOUS,
			    new String[] { bdMosBlkCode.toString(), bdBlacklistType.toString(), sBlacklistType,
				    bdBlacklistSource.toString(), sBlacklistSource }, ConstantsCommon.CONFIRM_MSG_TYPE,
			    ConstantsCommon.SUSPICIOUS_CIF_CONFIRMATION);
		}

		else if(mosBlackListSC.getCifSuspiciousFlag())
		{
		    mosBlackListCO.setBlackListed(BigDecimal.ONE);
		    mosBlackListCO.setProceedBlackListed(BigDecimal.ONE);
		    return mosBlackListCO;
		}
		else
		{
		    for(int i = 0; i < cifBlckLstVO.size(); i++)
		    {
			String sIdType = "", sColname, sBLType;

			sBLType = StringUtil.nullToEmpty(cifBlckLstVO.get(i).getBlType());
			sIdType = StringUtil.nullToEmpty(cifBlckLstVO.get(i).getIdType());
			sColname = StringUtil.nullToEmpty(cifBlckLstVO.get(i).getColumnName());

			if(sBLType.equals(ConstantsCommon.BLCK_MOS) && sColname.equals(mosBlackListSC.getsColname())
				&& sIdType.equals(String.valueOf(mosBlackListSC.getlIdType())))
			{
			    cifBlckLstVO.remove(i);

			}
		    }
		}
	    }
	for(int i = 0; i < cifBlckLstVO.size(); i++)
	{
	    String sBlChecked;

	    sBlChecked = StringUtil.nullToEmpty(cifBlckLstVO.get(i).getBlChecked());

	    if(sBlChecked.equals(ConstantsCommon.BLACKLISTENABLED))
	    {
		blFound = true;

	    }

	}
	if(!blFound)
	{
	    mosBlackListCO.setBlackListed(BigDecimal.ZERO);
	}

	mosBlackListCO.setCifBlckLstVO(cifBlckLstVO);
	}
	
	return mosBlackListCO;
    }
        
    public List<BigDecimal> returnBlackListByID(MosBlackListSC mosBlackListSC) throws BaseException
    {
	return mosBlackListDAO.returnBlackListByID(mosBlackListSC);
    }

    public void setMosBlackListDAO(MosBlackListDAO mosBlackListDAO)
    {
	this.mosBlackListDAO = mosBlackListDAO;
    }

    public BigDecimal returnBlackListByCIFNO(MosBlackListSC mosBlackListSC) throws BaseException
    {

	return mosBlackListDAO.returnBlackListByCIFNO(mosBlackListSC);
    }

    public MosBlackListCO returnBlkTypeSource(MosBlackListSC mosBlackListSC) throws BaseException
    {
	return mosBlackListDAO.returnBlkTypeSource(mosBlackListSC);

    }
    
    /**
     * returns the list of black list CifBlckLstVO
     */
    public ArrayList<CifBlckLstVO> returncifBlackList(MosBlackListSC mosBlackListSC) throws DAOException
    {
    	return (mosBlackListDAO.returncifBlackList(mosBlackListSC));
    }

    @Override
    public String showcifBlackListed(MosBlackListSC mosBlackListSC)	throws DAOException {
	return (mosBlackListDAO.showcifBlackListed(mosBlackListSC));
    }
    
    public Integer suspiciousBlackListUNMainRecordCount(MosBlackListSC mosBlackListSC) throws BaseException
    {	
	 Integer count = 0;
	 count = mosBlackListDAO.suspiciousBlackListUNMainRecordCount(mosBlackListSC); 
	 return  count;
    }
    public Integer getSuspiciousBlackListRecordCount(MosBlackListSC mosBlackListSC) throws BaseException
    {
	 Integer count = 0;
	 count = mosBlackListDAO.getSuspiciousBlackListRecordCount(mosBlackListSC); 
	return  count;
    }
    
    public ArrayList<MosBlackListCO> getSuspiciousBlackListList (MosBlackListSC criteria) throws BaseException {
	return (mosBlackListDAO.getSuspiciousBlackListList(criteria));
    }

    public ArrayList<MosBlackListCO> suspiciousBlackListUNMainList (MosBlackListSC criteria) throws BaseException {
	ArrayList<MosBlackListCO> LST =  (mosBlackListDAO.suspiciousBlackListUNMainList(criteria));
		
	return LST;
    }
    
    public ArrayList<MosBlackListCO> suspiciousBlackListJointMainList (MosBlackListSC criteria) throws DAOException
    {
	ArrayList<MosBlackListCO> LST =  (mosBlackListDAO.suspiciousBlackListJointMainList(criteria));
	
	return LST;
    }

    @Override
    public void saveSuspiciousRecords(MosBlackListCO mosBlackListCO) throws BaseException
    {
	// TODO Auto-generated method stub
	mosBlackListDAO.saveSuspiciousRecords(mosBlackListCO);
	
    }
    
    public ArrayList<CIF_JOINT_DETVO> selectJointName (MosBlackListSC criteria) throws BaseException
    {
	return mosBlackListDAO.selectJointName (criteria);
    }
    
    public BigDecimal countTrsBlackList(MosBlackListCO mosBlackListCO) throws BaseException
    {
	return mosBlackListDAO.countTrsBlackList(mosBlackListCO);
    }
    
    public void whiteListCif(MosBlackListCO mosBlackListCO) throws BaseException
    {
	mosBlackListDAO.whiteListCif(mosBlackListCO);
    }
}
