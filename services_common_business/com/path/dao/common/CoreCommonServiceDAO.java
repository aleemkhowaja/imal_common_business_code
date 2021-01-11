package com.path.dao.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CIFCOUNTERVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_RESERVEDVO;
import com.path.dbmaps.vo.CIF_TYPE_PARAMVO;
import com.path.dbmaps.vo.CIF_TYPE_PARAM_DETVOKey;
import com.path.dbmaps.vo.COUNTRIES_TEL_FORMATVO;
import com.path.dbmaps.vo.CTSTRS_CONF_MSGVO;
import com.path.dbmaps.vo.ID_CHECK_DIGITVO;
import com.path.dbmaps.vo.ID_CHECK_DIGIT_ALLOWEDVO;
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

public interface CoreCommonServiceDAO
{
    /**
     * returnCountriesTelFormat
     * 
     * @param cntryTelFrmatVO
     * @return
     * @throws DAOException
     */
    public COUNTRIES_TEL_FORMATVO returnCountriesTelFormat(COUNTRIES_TEL_FORMATVO cntryTelFrmatVO) throws DAOException;

    public int returnCntCtsRegBillType(TrxMgntSC trxMgntSC) throws DAOException;

    /**
     * updateMainCifData
     * 
     * @param fomCO
     * @return
     * @throws DAOException
     */
    public int updateMainCifData(FomCO fomCO) throws DAOException;

    public Integer validateIdUniqueness(NCifMaintenanceSC nCifMaintenanceSC) throws DAOException;

    public List<FomCO> similarIdsPopupList(FomSC fomSC) throws DAOException;

    public ArrayList<CIFVO> returncifByIrisRecog(CifSC cifSC) throws BaseException;

    /**
     * updateDummyCIFCTR
     * 
     * @param cifCounter
     * @throws DAOException
     */
    public void updateDummyCTSCOUNTER(CIFCOUNTERVO cifCounter) throws DAOException;

    /**
     * IIAB100318 [John Massaad] This method returns the maximum CIF NO From CIF
     * Table between first and last CIF Numbers
     * 
     * @param commonLibSc
     * @return
     * @throws DAOException
     */
    public BigDecimal returnMaxCIFNumber(NCifMaintenanceSC nCifMaintenanceSC) throws DAOException;

    public int returnCifNotReserved(CIF_RESERVEDVO cifReservedVO) throws DAOException;

    public BigDecimal returnTotalAmountBetweenFirstAndLastPeriod(TrxMgntSC trxMgntSC) throws DAOException;

    public CIF_TYPE_PARAMVO returnLastNumberCifType(CIF_TYPE_PARAM_DETVOKey cifTypeParamDetvokey) throws DAOException;
    
    public void  updateDummyCIF_TYPE_PARAM(CIF_TYPE_PARAM_DETVOKey cifTypeParamDetvokey) throws DAOException;

    public ArrayList<TrxMgntCO> returnCifTrxTrendsDet(TrxMgntSC trxMgntSC) throws DAOException;

    public ArrayList<TrxMgntCO> returnRifObtTrendsDet(TrxMgntSC trxMgntSC) throws DAOException;

    public ArrayList<TrxMgntCO> returnCtsTrxTypeMl(TrxMgntSC trxMgntSC) throws DAOException;

    public ArrayList<TrxMgntCO> returnCtsControlMl(TrxMgntSC trxMgntSC) throws BaseException;

    // added by nancy -- 06/07/2018-- 382769-account limits
    public int returncountConfMsg (CtstrsConfMsgSC ctstrsConfMsgSC) throws DAOException;
    public List<CTSTRS_CONF_MSGVO> returnConfMsg(CtstrsConfMsgSC ctstrsConfMsgSC) throws DAOException;
    public int checkIfLimitationActionExists(CtstrsConfMsgSC ctstrsConfMsgSC) throws DAOException;
    public int returnTierNo(AccountSC accountSC) throws DAOException;
    // end nancy
    
    //Added by Maria Chamieh for SBI170183
    public int checkIfExistIdNo(FomCO fomCO) throws DAOException;
    
    //Hala Al Sheikh - ABSAI180070
    public List<ID_CHECK_DIGITVO> returnCheckIdDigitsData(ID_CHECK_DIGITVO idCheckDigitVO) throws DAOException;
    public List<ID_CHECK_DIGIT_ALLOWEDVO> returnCheckIdDigitsAllowedData(ID_CHECK_DIGITVO idCheckDigitVO) throws DAOException;
    public int returnSTodoDetByAlert(AlertsSC alertsSC)throws BaseException;

    public void deleteAccountLimitActionTemp(TrxMgntSC trxMgntSC) throws DAOException;
    
    public int checkNegativeComp(CifSC cifSC) throws BaseException;
    
    public int checkEligibility(IdTypeSC idTypeSC) throws BaseException;
    
}
