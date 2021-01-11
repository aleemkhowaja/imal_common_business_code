package com.path.dao.common.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dao.common.CoreCommonServiceDAO;
import com.path.dbmaps.vo.CIFCOUNTERVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_RESERVEDVO;
import com.path.dbmaps.vo.CIF_TYPE_PARAMVO;
import com.path.dbmaps.vo.CIF_TYPE_PARAM_DETVOKey;
import com.path.dbmaps.vo.COUNTRIES_TEL_FORMATVO;
import com.path.dbmaps.vo.CTSTRS_CONF_MSGVO;
import com.path.dbmaps.vo.ID_CHECK_DIGITVO;
import com.path.dbmaps.vo.ID_CHECK_DIGIT_ALLOWEDVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.common.NCifMaintenanceSC;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.csmfom.FomSC;
import com.path.vo.core.idtype.IdTypeSC;
import com.path.vo.core.trxmgnt.CtstrsConfMsgSC;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntSC;

public class CoreCommonServiceDAOImpl extends BaseDAO implements CoreCommonServiceDAO
{

    public COUNTRIES_TEL_FORMATVO returnCountriesTelFormat(COUNTRIES_TEL_FORMATVO cntryTelFrmatVO) throws DAOException
    {
	return (COUNTRIES_TEL_FORMATVO) getSqlMap().queryForObject("coreCommonServiceMapper.returnCountriesTelFormat",
		cntryTelFrmatVO);
    }

    public int returnCntCtsRegBillType(TrxMgntSC trxMgntSC) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("coreCommonServiceMapper.returnCntCtsRegBillType", trxMgntSC))
		.intValue();
    }

    public int updateMainCifData(FomCO fomCO) throws DAOException
    {
	return getSqlMap().update("nCifMaintenanceMapper.updateMainCifData", fomCO);
    }

    public Integer validateIdUniqueness(NCifMaintenanceSC nCifMaintenanceSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("coreCommonServiceMapper.validateIdUniqueness", nCifMaintenanceSC);
    }

    /**
     * #82962 - IIAB110527 - Document Number Repetition in CIF - fboukarroum
     * This function is used to load the grid of similar cif's records that have
     * same id_type and id_no
     * 
     * @param fomSC
     * @return List<FomCO>
     * @throws BaseException
     */
    public List<FomCO> similarIdsPopupList(FomSC fomSC) throws DAOException
    {
	return getSqlMap().queryForList("coreCommonServiceMapper.similarIdsPopupListCommon", fomSC);
    }
    
    public ArrayList<CIFVO> returncifByIrisRecog(CifSC cifSC) throws DAOException
    {
	return (ArrayList<CIFVO>) getSqlMap().queryForList("coreCommonServiceMapper.cifByIrisRecog", cifSC);
    }
    
    @Override
    public BigDecimal returnMaxCIFNumber(NCifMaintenanceSC nCifMaintenanceSC) throws DAOException
    {
	return  (BigDecimal) getSqlMap().queryForObject("coreCommonServiceMapper.returnMaxCIFNo", nCifMaintenanceSC);
    }

    @Override
    public void updateDummyCTSCOUNTER(CIFCOUNTERVO cifCounter) throws DAOException
    {
	getSqlMap().update("coreCommonServiceMapper.updateDummyCTSCOUNTER", cifCounter);
    }
    
    /**
     * if the CIF returned by any counter exists in table CIF_RESEVED  this function get the minimum CIF not exist in this list
     * 
     * example : if the counter is 4 and we have in CIF_RESERVED 2,4,5,8 then we get the 6 since 4 and 5 are reserved . 
     * 
     * 
     * this function replaced the this code:
     * 	
	//EXCLUSDE THE CIF RESERVED LIST
	ls_not_in_reserved = '0'
	DO WHILE ls_not_in_reserved = '0'
		//CHECK IF NO IS IN RESERVED CIF LIST
		SELECT COUNT(1) INTO :ll_count FROM CIF_RESERVED 
		WHERE CIF_RESERVED.COMP_CODE = :gv_company_code
		AND 	CIF_RESERVED.CIF_NO = :ll_last_number;
		If sqlca.sqlcode <> 0 then ll_count = 0
		If ll_count = 0 Then 
			ls_not_in_reserved = '1'
		Else 
			ll_last_number = ll_last_number + 1
		End If
	LOOP	
	//	
     * @param cifReservedVO
     * @return
     * @throws BaseException
     */
    public int returnCifNotReserved(CIF_RESERVEDVO cifReservedVO)  throws DAOException
    {
	return (Integer)(getSqlMap().queryForObject("coreCommonServiceMapper.returnCifNotReserved", cifReservedVO));
    }
    
    /**
     * this function is used to get the cif number based on the cif type range defined in"CIF Type Ranges" screen defined in CSMADMIN
     * @param cifTypeParamDetvokey
     * @return
     * @throws DAOException
     */
    public CIF_TYPE_PARAMVO  returnLastNumberCifType(CIF_TYPE_PARAM_DETVOKey cifTypeParamDetvokey) throws DAOException
    {
	 return (CIF_TYPE_PARAMVO) getSqlMap().queryForObject("coreCommonServiceMapper.returnLastNumberCifType", cifTypeParamDetvokey);
    }
    
    public void  updateDummyCIF_TYPE_PARAM(CIF_TYPE_PARAM_DETVOKey cifTypeParamDetvokey) throws DAOException
    {
	 getSqlMap().update("coreCommonServiceMapper.updateDummyCIF_TYPE_PARAM", cifTypeParamDetvokey);
    }
    
    public BigDecimal returnTotalAmountBetweenFirstAndLastPeriod(TrxMgntSC trxMgntSC) throws DAOException
    {
	return (BigDecimal)getSqlMap().queryForObject("coreCommonServiceMapper.returnTotalAmountBetweenFirstAndLastPeriod", trxMgntSC);
    }
    
    public ArrayList<TrxMgntCO> returnCtsTrxTypeMl(TrxMgntSC trxMgntSC) throws DAOException
    {
	return (ArrayList<TrxMgntCO>)getSqlMap().queryForList("coreCommonServiceMapper.returnCtsTrxTypeMl", trxMgntSC);
    }
    
    public ArrayList<TrxMgntCO> returnCifTrxTrendsDet(TrxMgntSC trxMgntSC) throws DAOException
    {
	return (ArrayList<TrxMgntCO>) getSqlMap().queryForList("coreCommonServiceMapper.returnCifTrxTrendsDet", trxMgntSC);
    }
    
    public ArrayList<TrxMgntCO> returnRifObtTrendsDet(TrxMgntSC trxMgntSC) throws DAOException
    {
	return (ArrayList<TrxMgntCO>)getSqlMap().queryForList("coreCommonServiceMapper.returnRifObtTrendsDet", trxMgntSC);
    }
    
    public ArrayList<TrxMgntCO> returnCtsControlMl(TrxMgntSC trxMgntSC) throws DAOException
    {
	return (ArrayList<TrxMgntCO>)getSqlMap().queryForList("coreCommonServiceMapper.returnCtsControlMl", trxMgntSC);
    }
    
    // added by nancy -- 06/07/2018-- 382769-account limits
    public int returncountConfMsg (CtstrsConfMsgSC ctstrsConfMsgSC) throws DAOException
    {
	return (int) getSqlMap().queryForObject("coreCommonServiceMapper.returncountConfMsg", ctstrsConfMsgSC);
    }
    
    public List<CTSTRS_CONF_MSGVO> returnConfMsg(CtstrsConfMsgSC ctstrsConfMsgSC) throws DAOException
    {
	return getSqlMap().queryForList("coreCommonServiceMapper.returnConfMsg", ctstrsConfMsgSC); 
    }
    
    public int checkIfLimitationActionExists(CtstrsConfMsgSC ctstrsConfMsgSC) throws DAOException
    {
	return (int) getSqlMap().queryForObject("coreCommonServiceMapper.checkIfLimitationActionExists", ctstrsConfMsgSC);
    }
    
    public int returnTierNo(AccountSC accountSC) throws DAOException
    {
	return (int) getSqlMap().queryForObject("coreCommonServiceMapper.returnTierNo", accountSC);
    }
    // end nancy
    
    //Added by Maria Chamieh for SBI170183
    public int checkIfExistIdNo(FomCO fomCO) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("coreCommonServiceMapper.checkIfExistIdNo", fomCO))
		.intValue();
    }

    //Hala Al Sheikh - ABSAI180070
    public List<ID_CHECK_DIGITVO> returnCheckIdDigitsData(ID_CHECK_DIGITVO idCheckDigitVO) throws DAOException
    {
	return getSqlMap().queryForList("coreCommonServiceMapper.returnCheckIdDigitsData", idCheckDigitVO); 
    }

    public List<ID_CHECK_DIGIT_ALLOWEDVO> returnCheckIdDigitsAllowedData(ID_CHECK_DIGITVO idCheckDigitVO) throws DAOException
    {
	return getSqlMap().queryForList("coreCommonServiceMapper.returnCheckIdDigitsAllowedData", idCheckDigitVO); 
    }
    
    public void deleteAccountLimitActionTemp(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().delete("coreCommonServiceMapper.deleteAccountLimitActionTemp", trxMgntSC);
    }
    
    @Override
    public int checkNegativeComp(CifSC cifSC) throws BaseException
    {
	return (Integer)getSqlMap().queryForObject("coreCommonServiceMapper.checkNegativeComp", cifSC);
    }

    public int checkEligibility(IdTypeSC idTypeSC) throws BaseException
    {
	return (Integer)getSqlMap().queryForObject("coreCommonServiceMapper.checkEligibility", idTypeSC);
    }
    public int returnSTodoDetByAlert(AlertsSC alertsSC) throws BaseException
    {
	return (int) getSqlMap().queryForObject("coreCommonServiceMapper.returnSTodoDetByAlert", alertsSC);
    }
}
