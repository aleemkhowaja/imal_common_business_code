/**
 * 
 */
package com.path.bo.core.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_RESERVEDVO;
import com.path.dbmaps.vo.CIF_TYPE_PARAMVO;
import com.path.dbmaps.vo.CIF_TYPE_PARAM_DETVOKey;
import com.path.dbmaps.vo.COUNTRIES_TEL_FORMATVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTELLER_AXSVO;
import com.path.dbmaps.vo.CTSTRS_CONF_MSGVO;
import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.admin.countries.CountriesCO;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.blacklistmanagement.MosBlackListSC;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.cifuseraccess.CifUserAccessSC;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.ctsteller.CTSTELLERSC;
import com.path.vo.core.idtype.IdTypeSC;
import com.path.vo.core.trxmgnt.CtstrsConfMsgSC;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntSC;

public interface CoreCommonServiceBO
{
    public TrxMgntCO returnCommonVariables(TrxMgntCO trxMgntCO) throws BaseException;

    public COUNTRIES_TEL_FORMATVO returnCountriesTelFormat(COUNTRIES_TEL_FORMATVO cntryTelFrmatVO) throws BaseException;

    public String replaceCountryExtension(String originalFormat, String extension);

    public String returnMaskedCardNo(CardsManagementCO cardsManagementCO) throws BaseException;

    public TrxMgntSC lockSafeAccounts(TrxMgntCO trxMgntCO) throws BaseException;

    public String unlockSafeAccounts(BigDecimal lockId, String accForLockExists, boolean fromExeption,
	    RetailBaseVO retailBaseVO) throws BaseException;

    public int returnCntCtsRegBillType(TrxMgntSC trxMgntSC) throws BaseException;

    /**
     * updateMainCifData
     * 
     * @param cifVO
     * @param dateUpdated
     * @throws BaseException
     */
    public CIFVO updateMainCifData(CIFVO cifVO, Date dateUpdated) throws BaseException;

    public CifSC callAlertCif(BigDecimal compCode, BigDecimal cifNo, String status, String flag) throws BaseException;

    public void fillSoundex(MosBlackListSC mosBlackListSC) throws BaseException;

    public boolean checkIfDataCanModified(CTSTELLERVO ctsTellerVO, String cifstatus, String crudLevel,
	    Integer AccessDescriptionNumber) throws BaseException;

    public boolean checkAccesTellerModified(CTSTELLERVO ctsTellerVO, Integer AccessDescriptionNumber)
	    throws BaseException;

    public boolean checkAccesTellerModified(CTSTELLERVO ctsTellerVO, Integer AccessDescriptionNumber,
	    HashMap<BigDecimal, CTSTELLER_AXSVO> cifUserAccessMap1) throws BaseException;

    public FomCO fillCifUserAccessMap(FomCO fomCO) throws BaseException;

    public Map returnCifTellersAcces(CifUserAccessSC cifUserAccessSC) throws BaseException;

    public Boolean checkCifIsDraft(FomCO fomCO) throws BaseException;

    public void validateIdNo(FomCO fomCO) throws BaseException;

    public Boolean checkCivilId(ID_TYPESVO idTypesSC, ID_TYPESVO idTypesVO1) throws BaseException;
    
    public void validateLegnhIdNo(FomCO fomCO) throws BaseException;

    public void checkDataType(String idNo, String dataType) throws BaseException;

    public int verifyCivilId(FomCO fomCO, String checkOnjoin) throws BaseException;

    public Integer validateIdUniqueness(FomCO fomCO, String idNo2, BigDecimal idType2) throws BaseException;

    public String returnSimilarIds(FomCO fomCO) throws BaseException;

    public void returnIDBirthDate(FomCO fomCO) throws BaseException;

    public void addWarningMessagesList(FomCO fomCO, BigDecimal msgCode, String infoType);

    public void addWarningMessagesList(FomCO fomCO, BigDecimal msgCode, String[] msgParam, String infoType);

    public FomCO checkPassportIDType(FomCO fomCO) throws BaseException;

    public FomCO addActionToFOMElement(String element, String actionType, Object value1, FomCO fomCO)
	    throws BaseException;
    
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> addActionToFOMElement(List<String> elementsList, String actionType, Object value1, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo) throws BaseException;
    
    public FomCO addActionToFOMElement(String elementId, String elementName, String actionType, Object value1, FomCO fomCO) throws BaseException;
    
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> addActionToFOMElement(String elementId, String elementName, String actionType, Object value1, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo) throws BaseException;

    public FomCO fillCifControlDetails(FomCO fomCO) throws BaseException;

    public Boolean checkCIDLength(FomCO fomCO) throws BaseException;

    public String returnLableOfBirthdate(FomCO fomCO) throws BaseException;

    public FomCO checkBirthDate(FomCO fomCO) throws BaseException;

    public String getChargesCyPolicy(TrxMgntCO trxMgntCO) throws BaseException;

    public ArrayList<CIFVO> returncifByIrisRecog(CifSC cifSC) throws BaseException;

    public AddressCommonCO checkAddressCountry(AddressCommonCO addressCommonCO) throws BaseException;

    public HashMap<String, String> returnPhoneByCountry(CountriesCO countriesCO) throws BaseException;

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> checkAddressPoBoxArea(AddressCommonCO addressCommonCO)
	    throws BaseException;

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> checkAddressRegion(AddressCommonCO addressCommonCO)
	    throws BaseException;

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> checkAddressCityCode(AddressCommonCO addressCommonCO)
	    throws BaseException;

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> checkAddressSectorCode(AddressCommonCO addressCommonCO)
	    throws BaseException;

    /**
     * this function is used to get the cif number based on the cif type range
     * defined in"CIF Type Ranges" screen defined in CSMADMIN
     * 
     * @param cifTypeParamDetvokey
     * @return
     * @throws DAOException
     */
    public CIF_TYPE_PARAMVO returnLastNumberCifType(CIF_TYPE_PARAM_DETVOKey cifTypeParamDetvokey) throws BaseException;

    /**
     * this method returns the cif no (PB: uf_get_cifno)
     */
    public BigDecimal returnCifNumber(FomCO fomCO) throws BaseException;

    /**
     * if the CIF returned by any counter exists in table CIF_RESEVED this
     * function get the minimum CIF not exist in this list
     * 
     * example : if the counter is 4 and we have in CIF_RESERVED 2,4,5,8 then we
     * get the 6 since 4 and 5 are reserved .
     * 
     * 
     * this function replaced the this code:
     * 
     * //EXCLUSDE THE CIF RESERVED LIST ls_not_in_reserved = '0' DO WHILE
     * ls_not_in_reserved = '0' //CHECK IF NO IS IN RESERVED CIF LIST SELECT
     * COUNT(1) INTO :ll_count FROM CIF_RESERVED WHERE CIF_RESERVED.COMP_CODE =
     * :gv_company_code AND CIF_RESERVED.CIF_NO = :ll_last_number; If
     * sqlca.sqlcode <> 0 then ll_count = 0 If ll_count = 0 Then
     * ls_not_in_reserved = '1' Else ll_last_number = ll_last_number + 1 End If
     * LOOP //
     * 
     * @param cifReservedVO
     * @return
     * @throws BaseException
     */
    public int returnCifNotReserved(CIF_RESERVEDVO cifReservedVO) throws BaseException;

    /**
     * IIAB100318 [John Massaad] Equivalent to f_get_cif_number_mask
     */
    public FomCO returnCIFNumbBasedOnMask(FomCO fomCO) throws BaseException;

    public ArrayList<TrxMgntCO> returnCifTrxTrendsDet(TrxMgntSC trxMgntSC) throws BaseException;

    public int checkMoneyLaunderingExceedingAmount(TrxMgntSC trxMgntSC) throws BaseException;

    public ArrayList<TrxMgntCO> returnCtsTrxTypeMl(TrxMgntSC trxMgntSC) throws BaseException;

    public ArrayList<TrxMgntCO> returnRifObtTrendsDet(TrxMgntSC trxMgntSC) throws BaseException;
    
    public ArrayList<TrxMgntCO> returnCtsControlMl(TrxMgntSC trxMgntSC) throws BaseException;

    public TrxMgntCO trxCheckMoneyLaundering(TrxMgntCO trxMgntCO, boolean sendAlert) throws BaseException;

    public TrxMgntCO checkMoneyLaundering(TrxMgntCO trxMgntCO, AMFVO accountVO, BigDecimal cashCvAmount,
	    boolean isTrxOpt, boolean sendAlert) throws BaseException;
    
    public String checkCardReaderEnability(IdTypeSC idTypeSC) throws BaseException;
    
    public BigDecimal returnAvailBalBr(TrxMgntSC trxMgntSC) throws BaseException;
    
    public AccountCO checkAMFSpecialConditions(AccountCO accountCO1) throws BaseException;
    
    public AccountCO specialConditions(AccountCO accountCO1) throws BaseException;

    // added by nancy -- 06/07/2018-- 382769-account limits
    public int returncountConfMsg (CtstrsConfMsgSC ctstrsConfMsgSC) throws BaseException;
    
    public List<CTSTRS_CONF_MSGVO> returnConfMsg(CtstrsConfMsgSC ctstrsConfMsgSC) throws BaseException;
    
    public int checkIfLimitationActionExists(CtstrsConfMsgSC ctstrsConfMsgSC) throws BaseException;
    
    public int returnTierNo(AccountSC accountSC) throws BaseException;
    
    // end nancy 
    public CifSC calculateScoringForCifNo(CifSC cifSC) throws BaseException;
    
    //Hala Al Sheikh - BIPL180103    
    public void checkFomBtnCifBlackList(FomCO fomCO) throws BaseException; 

    public boolean returnBlackListPercentMatching(FomCO fomCO)throws BaseException ;
    
    //Hasan EWBI160091 20/05/2016
    public CifSC callCifUpdate(CifSC cifSC) throws BaseException;

    public int checkNegativeComp(CifSC criteria) throws BaseException;
    public int checkNegativeCompApproved(CifSC criteria) throws BaseException;
    public Object returnCifAbs(Object objectBean) throws BaseException;
    
    
    //Hala Al Sheikh - AMANA130215
    public FomCO checkIdDigits(FomCO fomCO) throws BaseException;
    
    public CTSTELLERVO returnloginTeller(CTSTELLERSC ctsTellerSC) throws BaseException;
    
    public void setPhoneLength(AddressCommonCO addressCommonCO, FomCO fomCO) throws BaseException;
    public int returnSTodoDetByAlert(AlertsSC alertsSC)throws BaseException;
    
}
