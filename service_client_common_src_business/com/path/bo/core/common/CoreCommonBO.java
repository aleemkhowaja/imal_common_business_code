package com.path.bo.core.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.CSM_CTRLVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSCONTROL_BY_COMPVO;
import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.dbmaps.vo.CTSTELLERACCTYPEDETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.dbmaps.vo.CTS_CONDITIONAL_AUTOMATIONVO;
import com.path.dbmaps.vo.CTS_MANUAL_JV_TMPVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.PROC_PRODUCT_PARAMVO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.S_ADDREF_MASK_SPECIFICVO;
import com.path.dbmaps.vo.YRTVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.admin.genledger.GenLedgerCO;
import com.path.vo.common.DepositerSC;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.requests.csm.CtsRequestCO;
import com.path.vo.common.requests.csm.CtsRequestSC;
import com.path.vo.common.signature.SigCapSignatureCO;
import com.path.vo.common.signature.SignatureSC;
import com.path.vo.core.account.AccountsManagementCO;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.ciftype.CifTypeSC;
import com.path.vo.core.common.CoreCommonCO;
import com.path.vo.core.common.CoreCommonSC;
import com.path.vo.core.conditionalautomation.ConditionalAutomationCO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.csmfom.FomSC;
import com.path.vo.core.csmfom.ResultCO;
import com.path.vo.core.ctsteller.CTSTELLERSC;
import com.path.vo.core.gl.GLSC;
import com.path.vo.core.reason.ReasonSC;
import com.path.vo.core.teller.TellerSC;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntSC;

public interface CoreCommonBO
{
    public CTSTRXTYPEVO findTrxType(CTSTRXTYPEVO ctstrxtypeVO) throws BaseException;

    public void checkClosedBal(TrxMgntSC trxMgntSC) throws BaseException;

    public RIFCTTVO findCifType(BigDecimal compCode, BigDecimal TYPE_CODE) throws BaseException;
    public ArrayList<CTSREASONSVO> returnReasonDropDownData(ReasonSC ctsreasonsvo) throws BaseException;

    public GEN_LEDGERVO returnValidGeneralLedger(GLSC criteria) throws BaseException;

    public GenLedgerCO checkAffectFlag(GLSC criteria) throws BaseException;

    public List<BigDecimal> getTellerBranches(TellerSC tellerSC) throws BaseException;

    public FomCO returnClientCIF(FomSC criteria) throws BaseException;

    public FomCO returnBankCIF(FomSC criteria) throws BaseException;

    public int countTrxDRCRTYPE(TrxMgntSC trxMgntSC) throws BaseException;

    public String returnDBAccount(TrxMgntSC trxMgntSC) throws BaseException;

    // public HashMap<String, PropertiesByTrxTypeCO>
    // returnPropertiesByTrxType(PropertiesByTrxTypeSC propByTrxTypeSC) throws
    // BaseException;
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> trxTypeMgntRequiredData(TrxMgntCO trxMgntCO, TrxMgntSC criteria)
	    throws BaseException;

    public CSM_CTRLVO returnCsmControls() throws BaseException;

    public String[] returnSectionName(String labelKey, String sectionName, String DefaultLablel);

    public CTSTRXTYPEVO linkToTrxTypes(TrxMgntSC criteria) throws BaseException;

    public Integer checkAccessOnGlType(CTSTELLERACCTYPEDETVO tellerAccTypeDetVO) throws BaseException;

    public String soundexEg(String name) throws BaseException;

    public SYS_PARAM_SCREEN_DISPLAYVO addBusinessEltScreenDisplay(CoreCommonCO coreCommonCO) throws BaseException;
    /**
     * this function checks the civild validity onlyIf the country == 3 then
     * //BMA :BAHRAIN
     * 
     * @param civilId
     * @return
     * @throws BOException
     */
    public int checkCivilIdBh(String civilId) throws BaseException;

    /**
     * this functions is used to check the digit of the civilid(pb
     * :f_getcivilidcheckdigit)
     * 
     * @param idno
     * @param inwardOutWardclrChq
     * @return
     * @throws BaseException
     */
    public int returnCivilIdCheckDigit(String idno, String inwardOutWardclrChq) throws BaseException;

    public DepositerSC checkIdNo(DepositerSC depositerSC) throws BaseException;

    /**
     * 
     * @param cifSC
     * @return
     * @throws BaseException method returns the nationality description of a
     *             specific nationality code
     */
    public String returnNationalityDescription(CifSC cifSC) throws BaseException;

    /**
     * Account Details Display Management..
     * 
     * @author marwanmaddah
     * @date Feb 20, 2013
     * @param trxMgntCO
     * @throws BaseException void
     * 
     */
    public void accountDtlDisplayMgnt(TrxMgntCO trxMgntCO) throws BaseException;

    public List returnClientCIFList(FomSC fomSC) throws BaseException;

    public Integer returnClientCIFCount(FomSC fomSC) throws BaseException;

    public String returnCheckdigit(String cardNum) throws BaseException;

    public CTSTRXTYPEVO returnTrxType(CTSTRXTYPEVO ctstrxtypeVO) throws BaseException;

    public void createHashManualJv() throws BaseException;

    public void dropHashManualJv() throws BaseException;
    
    public TrxMgntCO returnTransferMethod(TrxMgntCO trxMgntCO) throws BaseException;
    
  
    public void insertHashManualJv(CTS_MANUAL_JV_TMPVO ctsManualJvTmpVO) throws BaseException;
    
    public void deleteManualJvTmp(CTS_MANUAL_JV_TMPVO ctsManualJvTmpVO) throws BaseException;
    public RIFATTVO returnAccoutntType(BigDecimal compCode, BigDecimal TYPE_CODE) throws BaseException;
    
    /**
     * @author sarahelhusseini
     * @param coreCommonCO
     * @return the main vault
     * @throws BaseException
     */
	public CTSTELLERVO returnMainVault(CTSTELLERSC ctsTellerSC) throws BaseException;
    public void checkSignatureExpiryDateMandatory(SignatureSC signatureSC) throws BaseException;
    //NABIL FEGHALI - BB120129 - YMC FORMS
    public List<ReportResponseCO> printAccAdditionalAdvices(AccountsManagementCO accountsManagementCO) throws BaseException;
    public TrxMgntSC returnCrossRate(TrxMgntSC trxMgntSC) throws BaseException;
    //NABIL FEGHALI - BB130085 - Global Payment File
    public CTSTRXTYPE_EXTENDEDVO findTrxTypeExtended(CTSTRXTYPE_EXTENDEDVO ctstrxtypeExtendedVO) throws BaseException;
    //NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation 
    public ConditionalAutomationCO checkConditionalAutomation(ConditionalAutomationCO conditionalAutomationCO) throws BaseException;
    public List<CTS_CONDITIONAL_AUTOMATIONVO> returnConditionalAutomationList(BigDecimal compCode, String entityType,
	    BigDecimal eventType, BigDecimal cifType, BigDecimal deleteSpecialCond, BigDecimal linkedCondAutCode, BigDecimal cifTypesFlag)
	    throws BaseException;
    public void countDeleteSpecialCond(ConditionalAutomationCO conditionalAutomationCO, List<String> spCondsStatusList,
	    String resourceCode, List<BigDecimal> condAutoList) throws BaseException;
    //NABIL FEGHALI - END - IIAB110182 - IIAB100424 - Conditional Automation 
    
    /*
     * CHECK IF THE CIF IS BLACKLISTED
     */
    public int checkIfBlackListedCIF(CifSC cifSC) throws BaseException;
    public BigDecimal returnCIFNoOfBank(CifSC criteria) throws BaseException;
    
    public ResultCO checkCifAge(Date dateBirth, CifTypeSC cifTypeSC) throws BaseException;
    public YRTVO checkYrtPeriod(BigDecimal compCode,BigDecimal branchCode, Date runningDate) throws BaseException;
    public List <CIFCO> authorizedSigList (CifSC cifSC) throws BaseException;
    public TrxMgntSC returnNormalRate(TrxMgntSC trxMgntSC) throws BaseException;
    public List<S_ADDREF_MASK_SPECIFICVO> returnCIFAddRefNumberMask(String accountType) throws BaseException;
    
    public ReportResponseCO defaultPrinterName(ReportResponseCO reportResponseCO, CTSTELLERVO ctsTellerVO, CTSCONTROLVO ctsControlVO, String printType) throws BaseException;
    /**
     * used to apply template accounting entries in TFA application
     * 
     * @author: jihadlamaa
     * @date: Jun 3, 2014
     * @PB:
     * @param tfaCommonSC
     * @throws BaseException
     */
    public void applyTempAccEntries(CtsRequestSC criteria) throws BaseException;
    /**
     * 
     * @author: jihadlamaa
     * @date: Feb 13, 2015
     * @PB:
     * @param requestCO
     * @throws BaseException
     */
    public void processTFARequest(CtsRequestCO requestCO) throws BaseException;
    public int countClassifiedCIF(CifSC cifSC) throws BaseException;

    
    Map<String, PROC_PRODUCT_PARAMVO> retrieveProcProductParam(CoreCommonSC coreCommonSC) throws DAOException;
    public void refreshDual() throws BaseException;
    
    public Boolean getPassConfirmMsgYN(Integer confirmMsg) throws BaseException;
    
    public CoreCommonCO dependencyByReasonCode(CoreCommonSC coreCommonSC) throws BaseException;
    public CoreCommonCO checkExemptionExpiryDate(CoreCommonSC coreCommonSC) throws BaseException;
    
    /**
     * 
     * @param signatureSC
     * @return
     * @throws BaseException
     */
    public SigCapSignatureCO retSignatureScreen(SignatureSC signatureSC) throws BaseException;
    
    /**
     * 
     * @param ctscontrolByCompVO
     * @return
     * @throws BaseException
     */
    public CTSCONTROL_BY_COMPVO returnCTSControlByComp(CTSCONTROL_BY_COMPVO ctscontrolByCompVO) throws BaseException;

    public void validationNidCard(FomSC fomSC) throws BaseException;
}
