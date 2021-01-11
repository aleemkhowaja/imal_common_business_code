package com.path.dao.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.ACC_NV_ADVICEVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.dbmaps.vo.CTSTELLERACCTYPEDETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.dbmaps.vo.CTS_CONDITIONAL_AUTOMATIONVO;
import com.path.dbmaps.vo.CTS_MANUAL_JV_TMPVO;
import com.path.dbmaps.vo.PROC_PRODUCT_PARAMVO;
import com.path.dbmaps.vo.S_ADDREF_MASK_SPECIFICVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.common.DepositerSC;
import com.path.vo.common.signature.SignatureSC;
import com.path.vo.core.account.AccountsManagementCO;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.common.CoreCommonSC;
import com.path.vo.core.conditionalautomation.ConditionalAutomationSC;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.csmfom.FomSC;
import com.path.vo.core.ctsteller.CTSTELLERSC;
import com.path.vo.core.reason.ReasonSC;
import com.path.vo.core.specialconditions.SpecialConditionsCO;
import com.path.vo.core.trxmgnt.TrxMgntSC;

public interface CoreCommonDAO
{
    public int checkClosedBalance(TrxMgntSC trxMgntSC) throws DAOException;
    public ArrayList<CTSREASONSVO> returnReasonDropDownData(ReasonSC ctsreasonsvo) throws DAOException;

    // public Map<String, PropertiesByTrxTypeCO>
    // returnPropertiesByTrxType(PropertiesByTrxTypeSC propertiesByTrxTypeSC)
    // throws DAOException;

    public CTSTRXTYPEVO returnTrxType(CTSTRXTYPEVO ctstrxtypeVO) throws DAOException;

    public FomCO returnClientBankCIF(FomSC criteria) throws DAOException;

    public CTSTRXTYPEVO linkToTrxTypes(TrxMgntSC criteria) throws DAOException;

    public Integer checkAccessOnGlType(CTSTELLERACCTYPEDETVO tellerAccTypeDetVO) throws DAOException;

    public String returnValidateIdByCif(DepositerSC depositerSC) throws DAOException;

    public String returnNationalityDescription(CifSC cifSC) throws DAOException;

    public int countTrxDRCRTYPE(TrxMgntSC trxMgntSC) throws DAOException;

    public int returnClientBankCIFCount(FomSC criteria) throws DAOException;

    public List<FomCO> returnClientBankCIFList(FomSC criteria) throws DAOException;

    public void createHashManualJv(String sybOra) throws DAOException;

    public void dropHashManualJv(String sybOra);
    
    public void insertHashManualJv(CTS_MANUAL_JV_TMPVO ctsManualJvTmpVO) throws DAOException;
    
    public void deleteManualJvTmp(CTS_MANUAL_JV_TMPVO ctsManualJvTmpVO) throws DAOException;
	
    public CTSTELLERVO returnMainVault(CTSTELLERSC ctsTellerSC) throws DAOException;

    //NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
    public HashMap<String, Integer> checkSignatureExpiryDateMandatory(SignatureSC signatureSC) throws DAOException;
    //NABIL FEGHALI - BB120129 - YMC FORMS
    public List<ACC_NV_ADVICEVO> returnAccNvAdvices(AccountsManagementCO accountsManagementCO) throws DAOException;
    //NABIL FEGHALI - BB130085 - Global Payment File
    public CTSTRXTYPE_EXTENDEDVO returnTrxTypeExtended(CTSTRXTYPE_EXTENDEDVO ctstrxtypeExtendedVO) throws DAOException;
    //NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
    public BigDecimal countSpecialCondition(SpecialConditionsCO specialConditionsCO) throws DAOException;
    //NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
    public void updateSpecialConditions(SpecialConditionsCO specialConditionsCO) throws DAOException;
    //NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
    public List<CTS_CONDITIONAL_AUTOMATIONVO> selectConditionalAutomation(ConditionalAutomationSC conditionalAutomationSC) throws DAOException;

    public int checkIfBlackListedCIF(CifSC cifSC) throws DAOException;
    
    public List<CIFCO> authorizedSigList(CifSC cifSC) throws DAOException;
    public List<S_ADDREF_MASK_SPECIFICVO> returnCIFAddRefNumberMask(String accountType) throws DAOException;
    public int countClassifiedCIF(CifSC cifSC) throws DAOException;
    public Map<String, PROC_PRODUCT_PARAMVO> retrieveProcProductParam(CoreCommonSC coreCommonSC) throws DAOException;
    public BigDecimal returnCIFNoOfBank(CifSC criteria) throws DAOException;
    public int refreshDual() throws DAOException;
    public String getPassConfirmMsgYN(Integer msgCode) throws DAOException;
    public HashMap retExtSigAndUrl() throws DAOException;
  //added by reda for SUPT190047
    public List<CIFVO> listCIFbyID(CifSC criteria) throws DAOException;
    //
    public int validationNidCard(FomSC criteria) throws DAOException;
    
}
