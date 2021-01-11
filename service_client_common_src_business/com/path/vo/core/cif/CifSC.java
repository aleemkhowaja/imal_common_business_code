/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.core.cif;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.AMFVO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.GridParamsSC;

/**
 * @author MarwanMaddah
 * 
 */
public class CifSC extends GridParamsSC
{
    private BigDecimal cif_no;
    private String cif_name;// cif name used upon choosing CIF from IRIS Scan/
    // Choose Customer popup Pages
    private String userId;
    private String addString2;
    private BigDecimal comp_code;
    private BigDecimal displayMsg;
    private BigDecimal branchCode;
    private BigDecimal currencyCode;
    private BigDecimal glCode;
    private BigDecimal cifCode;
    private BigDecimal slNbr;
    private String addRef;
    private String raFlag;
    private String raStatus;
    private String raType;
    private String raResident;
    private String lang;
    private String ACC_BC;
    private String status;
    private String AMFStatus; // to be used in dynAccountListQuery
    private String CIFStatus; // to be used in dynAccountListQuery
    private String flag;
    private String allowInternAcc;
    private String GL_TYPE;
    private String CATEGORY;
    private String GMI_FLAG;
    private String BS_CONTRA; // s_category
    private String AFFECT_CARD; // s_card
    private String affectPassChq;
    private String columnId;
    private List<AMFVO> lstTrsAccount = new ArrayList<AMFVO>();
    private String cifType;
    private String client;
    private BigDecimal jointCifNo;
    // added by jihad to get all status of CIF
    private boolean allStatus;
    private boolean isNotInternal;
    private String retExpIfExsits;
    //
    private BigDecimal blackListCode; // added by Fady A.Sleiman for blackList
    // Screen.
    private BigDecimal GI_VERSION;
    private BigDecimal idTypeCode;
    private BigDecimal trxType;
    private String CR_DR_FOREX; // CTSTRXTYPE table
    private String id_no;
    private BigDecimal code;
    private String appName;
    private String gmiExcludes;
    private String gmiIncludes;

    // GL category
    private String glCategory;
    private BigDecimal errorCode;
    private String errorMessage;
    private String cifAlertStatus;
    private BigDecimal country;
    private BigDecimal cifTypeCode;

    private String lookupCorrBank = "false";
    private String lookupBankCifAib = "false";
    private String lookupBankCif = "false";
    private String lookupCivilId = "";

    private String bankCifLkp = "false";
    private String benefBankLkp = "false";
    private String intermBankLkp = "false";
    private String corrBankLkp = "false";
    private String banksLkp = "false";
    private BigDecimal clearingHouse;
    private Boolean preventException = false;
    private BigDecimal fromDash = BigDecimal.ZERO;
    private BigDecimal loginTypeByBr;
    private BigDecimal tellerCode;
    private boolean showMemo = true;
    private BigDecimal bankType = BigDecimal.ONE;

    private String bicCode;
//    private boolean isBicCode;
    private BigDecimal bicCodeLimit;
    private String bankCode;
    private String countryCode;
    private String locationCode;
    private String bicTrsFlag;
    private String bicBranchCode;
    private int validateStatus; // 1: check CIF by Status, 0 or null: dismiss
    private int validateBank; // 1: check CIF if Bank, 0 or null: dismiss
    private int validateBicCode; // 1: check CIF by Bic Code, 0 or null: dismiss
    private String bankUsed;
    private String bankCifInd; // B (Bank) , C (Client)
    private String rifCttBank;
    private int validateCntryBlkLst; // 1: add checking for blacklist
    private BigDecimal countryBlacklisted;// Country blk list value
    private BigDecimal returnNisNif;// 1: add checking for CIF-NIS and CIF-NIF
    private String validateCifAdress;
    private String vehicleNo;
    private String validateTfaTrading;// this is ussedto validate if this cif allowed to do
    // transactions in TFA
    private String validateCifBlackList;// this is used to validate if this cif is black listed or
    // not
    private String validateCifClassified;// this is used to validate if this cif is classified or
    // not
    private String[] paramsCtsMsg; // used to send CtsMessages Parameters
    private int messageId;// used to send error message Id
    private String glCategoryIncludes;

    private String depByBicCode;/// used to validate bic code
    private String depByBankCif;// used to validate bank cif
    private String depByCustomerCif; //used to validate customer cif
    private String errorType;//return the error type "E":ERROR,"C":confirmation,"W":warning
    //NABIL FEGHALI BB140155 KYC new changes
    private String resident;
    private String fromScreen;
    private String countryName; 
    private String todoParam;  //added by antonella to insert cif_no into a String todo_param
    private String branchCentralisation; //BB110153
    
    private String accNo; //Rania Al-Bitar - Bug #621666 - system is showing CIFs having different IBAN acc in the search grid
    
    private String switchBranchCode;
    private String accountReference;
    
    //Bassam Eid BUG# 678070
    private String doNotfilterByUpdatePassBook;
	
    private BigDecimal fmsCategory;
	
    private String avaCardFlag;
    // EWBI160091 (403157)- Modification of CIF
    private BigDecimal compCodeCif;
    
    //TP # 412662 -- Customer RelationShip Management  -- [Joyce Kanazeh]
    private String limitType ;  
    
    private String idNoFilter;
    
    private boolean checkNbRec;
    private String pageRef;
    private int trxMgntNbRecords;
    
    private BigDecimal restrBranchCode;
    private String applyRestriction;
	
    ////////////////////////
    private BigDecimal clubCode;
    
    private boolean subsidiarySearch;
    
    //Hala Al Sheikh - ABSAI180070
    private String checksumDigit;
    private boolean proceedOnInactiveCIF;
    private boolean throwProceedOnInactiveCIFWarning;
    private String cifWhereQuery;
    //Hala Al Sheikh - BIPL180103
    private String blkListScreenCheck;
    
    
    private String cardTypeDesc;
    private BigDecimal cardType;// BMOI140007
    private BigDecimal cif_Type;// BMOI140007
    private BigDecimal cifPriority;// BMOI140007
    private BigDecimal parentType;// BMOI140007
    private String cardNo;// BMOI140007
    private int checkWithoutStatus;// BMOI140007
    // TP#476264 EWBI160749; Ajas.Abbas; 03/02/2017

    private String methodName;
    private BigDecimal reasonCode;

    private BigDecimal kycCode;
    private String pepDescription;
    // BMOI130009 card reader
    private String cardReaderCivilID;
    private String allowCifCreationMaskYN;
    private String crud;
    private BigDecimal segmentCode;
    
    private String ecoSecProfMatrix;
    private BigDecimal requestId;//FIBSI170006 
    private String populateImage;// FIBSI170006 
    private String cifByProviderBillType;
    
    private String allow_suspended_cif;
    
    private BigDecimal isBank = BigDecimal.ONE;
    
    // Zalfa Bou Moussa 10/07/2019 ----- SUPT190047
    private BigDecimal excludeCheckingOnSuspense;
    // End Zalfa
    
    public String getMethodName()
    {
	return methodName;
    }

    public void setMethodName(String methodName)
    {
	this.methodName = methodName;
    }

    private String isFromDependency = "0";// Raed Saad - [BB160150]

    public BigDecimal getReasonCode()
    {
	return reasonCode;
    }

    public void setReasonCode(BigDecimal reasonCode)
    {
	this.reasonCode = reasonCode;
    }

    public String getGmiExcludes()
    {
	return gmiExcludes;
    }

    public void setGmiExcludes(String gmiExcludes)
    {
        this.gmiExcludes = gmiExcludes;
    }

    public String getGmiIncludes()
    {
        return gmiIncludes;
    }

    public void setGmiIncludes(String gmiIncludes)
    {
        this.gmiIncludes = gmiIncludes;
    }

    public BigDecimal getTellerCode()
    {
        return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
        this.tellerCode = tellerCode;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public boolean isAllStatus()
    {
        return allStatus;
    }

    public void setAllStatus(boolean allStatus)
    {
        this.allStatus = allStatus;
    }

    public BigDecimal getJointCifNo()
    {
        return jointCifNo;
    }

    public void setJointCifNo(BigDecimal jointCifNo)
    {
        this.jointCifNo = jointCifNo;
    }

    public void setDefaultValues()
    {
        if("".equals(StringUtil.nullToEmpty(this.ACC_BC)))
        {
            /**
             * default AMF.ACC_BC is X that means the Account will be
             * ON_BALANCE_SHEET OR OFF_BALANCE SHEET
             */
            this.setACC_BC(ConstantsCommon.XOR);
        }
        if("".equals(StringUtil.nullToEmpty(this.GMI_FLAG)))
        {
            /**
             * default AMF.GMI_FLAG is X that means the Account will be General,
             * Fixed or Internal
             */
            this.setGMI_FLAG(ConstantsCommon.XOR);
        }
        if("".equals(StringUtil.nullToEmpty(this.BS_CONTRA)))
        {
            /**
             * default BS_CONTRA is X than means ON_BALANCE_SHEET OR OFF_BALANCE
             * SHEET
             */
            this.setBS_CONTRA(ConstantsCommon.XOR);
        }
        if("".equals(StringUtil.nullToEmpty(this.affectPassChq)))
        {
            /**
             * affectPassChq = affect Passbook and ChequeBook is
             * RIFATT.AFFECTION
             */
            this.setAffectPassChq("-1");
        }
        if("".equals(StringUtil.nullToEmpty(this.AFFECT_CARD)))
        {
            this.setAFFECT_CARD("0");
        }

        if("".equals(StringUtil.nullToEmpty(this.flag)))
        {
            /**
             * Calling AccountLookupAction means FLAG is AMF TABLE Calling
             * CIFLookupAction means FLAS is CIF table
             */
            this.setFlag("CIF");
        }

        if("".equals(StringUtil.nullToEmpty(this.CIFStatus)) && !BigDecimal.ONE.equals(this.fromDash))
        {
            /**
             * By Default, CIF Status is Active, Inactive, Dormant or Applied
             * For Closure
             */
            if(this.allStatus)
            { 
                // get All statuses of CIF
                this.setCIFStatus(null);
            }
            else
            { 
        	// get active status
        	this.setCIFStatus("'" + ConstantsCommon.ACTIVE_ACCOUNT + "'");
            }
        }
    }

    /**
     * @return the userId
     */
    @Override
    public String getUserId()
    {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    @Override
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    /**
     * @return the comp_code
     */
    public BigDecimal getComp_code()
    {
        return comp_code;
    }

    /**
     * @param compCode the comp_code to set
     */
    public void setComp_code(BigDecimal compCode)
    {
        comp_code = compCode;
    }

    /**
     * @return the cif_no
     */
    public BigDecimal getCif_no()
    {
        return cif_no;
    }

    /**
     * @param cifNo the cif_no to set
     */
    public void setCif_no(BigDecimal cifNo)
    {
        cif_no = cifNo;
    }

    @Override
    public BigDecimal getBranchCode()
    {
        return branchCode;
    }

    @Override
    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }

    public BigDecimal getCurrencyCode()
    {
        return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    /**
     * getting the Ra
     * 
     * @return
     */
    public BigDecimal getGlCode()
    {
        return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
        this.glCode = glCode;
    }

    /**
     * Getting the raFlag
     * 
     * @return
     */

    public String getRaFlag()
    {
        return raFlag;
    }

    /**
     * Setting the raFlag
     * 
     * @param raFlag
     */

    public void setRaFlag(String raFlag)
    {
        this.raFlag = raFlag;
    }

    /**
     * Getting the raStatus
     * 
     * @return
     */

    public String getRaStatus()
    {
        return raStatus;
    }

    /**
     * Setting the raStatus
     * 
     * @param raStatus
     */

    public void setRaStatus(String raStatus)
    {
        this.raStatus = raStatus;
    }

    /**
     * Getting raResident
     * 
     * @return
     */

    public String getRaResident()
    {
        return raResident;
    }

    /**
     * Setting raResident
     * 
     * @param raResident
     */
    public void setRaResident(String raResident)
    {
        this.raResident = raResident;
    }

    /**
     * @return the lang
     */
    public String getLang()
    {
        return lang;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(String lang)
    {
        this.lang = lang;
    }

    public String getColumnId()
    {
        return columnId;
    }

    public void setColumnId(String columnId)
    {
        this.columnId = columnId;
    }

    public String getACC_BC()
    {
        return ACC_BC;
    }

    public void setACC_BC(String aCCBC)
    {
        ACC_BC = aCCBC;
    }

    public String getFlag()
    {
        return flag;
    }

    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    public String getAllowInternAcc()
    {
        return allowInternAcc;
    }

    public void setAllowInternAcc(String allowInternAcc)
    {
        this.allowInternAcc = allowInternAcc;
    }

    public String getGL_TYPE()
    {
        return GL_TYPE;
    }

    public void setGL_TYPE(String gLTYPE)
    {
        GL_TYPE = gLTYPE;
    }

    public String getGMI_FLAG()
    {
        return GMI_FLAG;
    }

    public void setGMI_FLAG(String gMIFLAG)
    {
        GMI_FLAG = gMIFLAG;
    }

    public String getBS_CONTRA()
    {
        return BS_CONTRA;
    }

    public void setBS_CONTRA(String bSCONTRA)
    {
        BS_CONTRA = bSCONTRA;
    }

    public String getAFFECT_CARD()
    {
        return AFFECT_CARD;
    }

    public void setAFFECT_CARD(String aFFECTCARD)
    {
        AFFECT_CARD = aFFECTCARD;
    }

    public String getAffectPassChq()
    {
        return affectPassChq;
    }

    public void setAffectPassChq(String affectPassChq)
    {
        this.affectPassChq = affectPassChq;
    }

    public List<AMFVO> getLstTrsAccount()
    {
        return lstTrsAccount;
    }

    public void setLstTrsAccount(List<AMFVO> lstTrsAccount)
    {
        this.lstTrsAccount = lstTrsAccount;
    }

    public BigDecimal getCifCode()
    {
        return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
        this.cifCode = cifCode;
    }

    public String getCifType()
    {
        return cifType;
    }

    public void setCifType(String cifType)
    {
        this.cifType = cifType;
    }

    public String getAMFStatus()
    {
        return AMFStatus;
    }

    public void setAMFStatus(String aMFStatus)
    {
        AMFStatus = aMFStatus;
    }

    public String getCIFStatus()
    {
        return CIFStatus;
    }

    public void setCIFStatus(String cIFStatus)
    {
        CIFStatus = cIFStatus;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public BigDecimal getSlNbr()
    {
        return slNbr;
    }

    public void setSlNbr(BigDecimal slNbr)
    {
        this.slNbr = slNbr;
    }

    public String getAddRef()
    {
        return addRef;
    }

    public void setAddRef(String addRef)
    {
        this.addRef = addRef;
    }

    public void setGI_VERSION(BigDecimal gI_VERSION)
    {
        GI_VERSION = gI_VERSION;
    }

    public BigDecimal getGI_VERSION()
    {
        return GI_VERSION;
    }

    public BigDecimal getIdTypeCode()
    {
        return idTypeCode;
    }

    public void setIdTypeCode(BigDecimal idTypeCode)
    {
        this.idTypeCode = idTypeCode;
    }

    public String getId_no()
    {
        return id_no;
    }

    public void setId_no(String idNo)
    {
        id_no = idNo;
    }

    public String getCATEGORY()
    {
        return CATEGORY;
    }

    public void setCATEGORY(String cATEGORY)
    {
        CATEGORY = cATEGORY;
    }

    public String getRaType()
    {
        return raType;
    }

    public void setRaType(String raType)
    {
        this.raType = raType;
    }

    public BigDecimal getCode()
    {
        return code;
    }

    public void setCode(BigDecimal code)
    {
        this.code = code;
    }

    public boolean isNotInternal()
    {
        return isNotInternal;
    }

    public void setNotInternal(boolean isNotInternal)
    {
        this.isNotInternal = isNotInternal;
    }

    public String getCif_name()
    {
        return cif_name;
    }

    public void setCif_name(String cifName)
    {
        cif_name = cifName;
    }

    public BigDecimal getBlackListCode()
    {
        return blackListCode;
    }

    public void setBlackListCode(BigDecimal blackListCode)
    {
        this.blackListCode = blackListCode;
    }

    public String getRetExpIfExsits()
    {
        return retExpIfExsits;
    }

    public void setRetExpIfExsits(String retExpIfExsits)
    {
        this.retExpIfExsits = retExpIfExsits;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public String getCR_DR_FOREX()
    {
        return CR_DR_FOREX;
    }

    public void setCR_DR_FOREX(String cRDRFOREX)
    {
        CR_DR_FOREX = cRDRFOREX;
    }

    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public String getCifAlertStatus()
    {
        return cifAlertStatus;
    }

    public void setCifAlertStatus(String cifAlertStatus)
    {
        this.cifAlertStatus = cifAlertStatus;
    }

    /**
     * @return the lookupCorrBank
     */
    public String getLookupCorrBank()
    {
        return lookupCorrBank;
    }

    /**
     * @param lookupCorrBank the lookupCorrBank to set
     */
    public void setLookupCorrBank(String lookupCorrBank)
    {
        this.lookupCorrBank = lookupCorrBank;
    }

    /**
     * @return the bankCifLkp
     */
    public String getBankCifLkp()
    {
        return bankCifLkp;
    }

    /**
     * @param bankCifLkp the bankCifLkp to set
     */
    public void setBankCifLkp(String bankCifLkp)
    {
        this.bankCifLkp = bankCifLkp;
    }

    /**
     * @return the lookupBankCifAib
     */
    public String getLookupBankCifAib()
    {
        return lookupBankCifAib;
    }

    /**
     * @param lookupBankCifAib the lookupBankCifAib to set
     */
    public void setLookupBankCifAib(String lookupBankCifAib)
    {
        this.lookupBankCifAib = lookupBankCifAib;
    }

    /**
     * @return the benefBankLkp
     */
    public String getBenefBankLkp()
    {
        return benefBankLkp;
    }

    /**
     * @param benefBankLkp the benefBankLkp to set
     */
    public void setBenefBankLkp(String benefBankLkp)
    {
        this.benefBankLkp = benefBankLkp;
    }

    /**
     * @return the banksLkp
     */
    public String getBanksLkp()
    {
        return banksLkp;
    }

    /**
     * @param banksLkp the banksLkp to set
     */
    public void setBanksLkp(String banksLkp)
    {
        this.banksLkp = banksLkp;
    }

    /**
     * @return the lookupBankCif
     */
    public String getLookupBankCif()
    {
        return lookupBankCif;
    }

    /**
     * @param lookupBankCif the lookupBankCif to set
     */
    public void setLookupBankCif(String lookupBankCif)
    {
        this.lookupBankCif = lookupBankCif;
    }

    /**
     * @return the country
     */
    public BigDecimal getCountry()
    {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(BigDecimal country)
    {
        this.country = country;
    }

    /**
     * @return the clearingHouse
     */
    public BigDecimal getClearingHouse()
    {
        return clearingHouse;
    }

    /**
     * @param clearingHouse the clearingHouse to set
     */
    public void setClearingHouse(BigDecimal clearingHouse)
    {
        this.clearingHouse = clearingHouse;
    }

    /**
     * @return the intermBankLkp
     */
    public String getIntermBankLkp()
    {
        return intermBankLkp;
    }

    /**
     * @param intermBankLkp the intermBankLkp to set
     */
    public void setIntermBankLkp(String intermBankLkp)
    {
        this.intermBankLkp = intermBankLkp;
    }

    /**
     * @return the corrBankLkp
     */
    public String getCorrBankLkp()
    {
        return corrBankLkp;
    }

    /**
     * @param corrBankLkp the corrBankLkp to set
     */
    public void setCorrBankLkp(String corrBankLkp)
    {
        this.corrBankLkp = corrBankLkp;
    }

    public String getClient()
    {
        return client;
    }

    public void setClient(String client)
    {
        this.client = client;
    }

    public Boolean getPreventException()
    {
        return preventException;
    }

    public void setPreventException(Boolean preventException)
    {
        this.preventException = preventException;
    }

    /**
     * @return the loginTypeByBr
     */
    public BigDecimal getLoginTypeByBr()
    {
        return loginTypeByBr;
    }

    /**
     * @param loginTypeByBr the loginTypeByBr to set
     */
    public void setLoginTypeByBr(BigDecimal loginTypeByBr)
    {
        this.loginTypeByBr = loginTypeByBr;
    }

    /**
     * @return the fromDash
     */
    public BigDecimal getFromDash()
    {
        return fromDash;
    }

    /**
     * @param fromDash the fromDash to set
     */
    public void setFromDash(BigDecimal fromDash)
    {
        this.fromDash = fromDash;
    }

    public boolean isShowMemo()
    {
        return showMemo;
    }

    public void setShowMemo(boolean showMemo)
    {
        this.showMemo = showMemo;
    }

    /**
     * @return the bankType
     */
    public BigDecimal getBankType()
    {
        return bankType;
    }

    /**
     * @param bankType the bankType to set
     */
    public void setBankType(BigDecimal bankType)
    {
        this.bankType = bankType;
    }

    /**
     * @return the cifTypeCode
     */
    public BigDecimal getCifTypeCode()
    {
        return cifTypeCode;
    }

    /**
     * @param cifTypeCode the cifTypeCode to set
     */
    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
        this.cifTypeCode = cifTypeCode;
    }

    public String getLookupCivilId()
    {
        return lookupCivilId;
    }

    public void setLookupCivilId(String lookupCivilId)
    {
        this.lookupCivilId = lookupCivilId;
    }

    /**
     * @return the bicCode
     */
    public String getBicCode()
    {
        return bicCode;
    }

    /**
     * @param bicCode the bicCode to set
     */
    public void setBicCode(String bicCode)
    {
        this.bicCode = bicCode;
    }

    /**
     * @return the validateStatus
     */
    public int getValidateStatus()
    {
        return validateStatus;
    }

    /**
     * @param validateStatus the validateStatus to set
     */
    public void setValidateStatus(int validateStatus)
    {
        this.validateStatus = validateStatus;
    }

    /**
     * @return the validateBank
     */
    public int getValidateBank()
    {
        return validateBank;
    }

    /**
     * @param validateBank the validateBank to set
     */
    public void setValidateBank(int validateBank)
    {
        this.validateBank = validateBank;
    }

    /**
     * @return the validateBicCode
     */
    public int getValidateBicCode()
    {
        return validateBicCode;
    }

    /**
     * @param validateBicCode the validateBicCode to set
     */
    public void setValidateBicCode(int validateBicCode)
    {
        this.validateBicCode = validateBicCode;
    }

    /**
     * @return the bankUsed
     */
    public String getBankUsed()
    {
        return bankUsed;
    }

    /**
     * @param bankUsed the bankUsed to set
     */
    public void setBankUsed(String bankUsed)
    {
        this.bankUsed = bankUsed;
    }

    /**
     * @return the bankCifInd
     */
    public String getBankCifInd()
    {
        return bankCifInd;
    }

    /**
     * @param bankCifInd the bankCifInd to set
     */
    public void setBankCifInd(String bankCifInd)
    {
        this.bankCifInd = bankCifInd;
    }

    /**
     * @return the bicCodeLimit
     */
    public BigDecimal getBicCodeLimit()
    {
        return bicCodeLimit;
    }

    /**
     * @param bicCodeLimit the bicCodeLimit to set
     */
    public void setBicCodeLimit(BigDecimal bicCodeLimit)
    {
        this.bicCodeLimit = bicCodeLimit;
    }

    /**
     * @return the rifCttBank
     */
    public String getRifCttBank()
    {
        return rifCttBank;
    }

    /**
     * @param rifCttBank the rifCttBank to set
     */
    public void setRifCttBank(String rifCttBank)
    {
        this.rifCttBank = rifCttBank;
    }

    /**
     * @return the countryBlacklisted
     */
    public BigDecimal getCountryBlacklisted()
    {
        return countryBlacklisted;
    }

    /**
     * @param countryBlacklisted the countryBlacklisted to set
     */
    public void setCountryBlacklisted(BigDecimal countryBlacklisted)
    {
        this.countryBlacklisted = countryBlacklisted;
    }

    /**
     * @return the validateCntryBlkLst
     */
    public int getValidateCntryBlkLst()
    {
        return validateCntryBlkLst;
    }

    /**
     * @param validateCntryBlkLst the validateCntryBlkLst to set
     */
    public void setValidateCntryBlkLst(int validateCntryBlkLst)
    {
        this.validateCntryBlkLst = validateCntryBlkLst;
    }

    /**
     * @return the returnNisNif
     */
    public BigDecimal getReturnNisNif()
    {
        return returnNisNif;
    }

    /**
     * @param returnNisNif the returnNisNif to set
     */
    public void setReturnNisNif(BigDecimal returnNisNif)
    {
        this.returnNisNif = returnNisNif;
    }

    public String getValidateCifAdress()
    {
        return validateCifAdress;
    }

    public void setValidateCifAdress(String validateCifAdress)
    {
        this.validateCifAdress = validateCifAdress;
    }

    public String getVehicleNo()
    {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo)
    {
        this.vehicleNo = vehicleNo;
    }

    public String getValidateTfaTrading()
    {
        return validateTfaTrading;
    }

    public void setValidateTfaTrading(String validateTfaTrading)
    {
        this.validateTfaTrading = validateTfaTrading;
    }

    public String getValidateCifBlackList()
    {
        return validateCifBlackList;
    }

    public void setValidateCifBlackList(String validateCifBlackList)
    {
        this.validateCifBlackList = validateCifBlackList;
    }

    public String getValidateCifClassified()
    {
        return validateCifClassified;
    }

    public void setValidateCifClassified(String validateCifClassified)
    {
        this.validateCifClassified = validateCifClassified;
    }

    /**
     * @return the paramsCtsMsg
     */
    public String[] getParamsCtsMsg()
    {
        return paramsCtsMsg;
    }

    /**
     * @param paramsCtsMsg the paramsCtsMsg to set
     */
    public void setParamsCtsMsg(String... paramsCtsMsg)
    {
        this.paramsCtsMsg = paramsCtsMsg;
    }

    /**
     * @return the messageId
     */
    public int getMessageId()
    {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(int messageId)
    {
        this.messageId = messageId;
    }

    /**
     * @return the bankCode
     */
    public String getBankCode()
    {
        return bankCode;
    }

    /**
     * @param bankCode the bankCode to set
     */
    public void setBankCode(String bankCode)
    {
        this.bankCode = bankCode;
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode()
    {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    /**
     * @return the locationCode
     */
    public String getLocationCode()
    {
        return locationCode;
    }

    /**
     * @param locationCode the locationCode to set
     */
    public void setLocationCode(String locationCode)
    {
        this.locationCode = locationCode;
    }

    /**
     * @return the bicTrsFlag
     */
    public String getBicTrsFlag()
    {
        return bicTrsFlag;
    }

    /**
     * @param bicTrsFlag the bicTrsFlag to set
     */
    public void setBicTrsFlag(String bicTrsFlag)
    {
        this.bicTrsFlag = bicTrsFlag;
    }

    /**
     * @return the bicBranchCode
     */
    public String getBicBranchCode()
    {
        return bicBranchCode;
    }

    /**
     * @param bicBranchCode the bicBranchCode to set
     */
    public void setBicBranchCode(String bicBranchCode)
    {
        this.bicBranchCode = bicBranchCode;
    }

    public String getGlCategory()
    {
        return glCategory;
    }

    public void setGlCategory(String glCategory)
    {
        this.glCategory = glCategory;
    }

    public String getGlCategoryIncludes()
    {
        return glCategoryIncludes;
    }

    public void setGlCategoryIncludes(String glCategoryIncludes)
    {
        this.glCategoryIncludes = glCategoryIncludes;
    }

   /* public boolean isBicCode()
    {
        return isBicCode;
    }

    public void setBicCode(boolean isBicCode)
    {
        this.isBicCode = isBicCode;
    }*/

    public String getDepByBicCode()
    {
        return depByBicCode;
    }

    public void setDepByBicCode(String depByBicCode)
    {
        this.depByBicCode = depByBicCode;
    }

    public String getDepByBankCif()
    {
        return depByBankCif;
    }

    public void setDepByBankCif(String depByBankCif)
    {
        this.depByBankCif = depByBankCif;
    }

    public String getDepByCustomerCif()
    {
        return depByCustomerCif;
    }

    public void setDepByCustomerCif(String depByCustomerCif)
    {
        this.depByCustomerCif = depByCustomerCif;
    }

    public String getErrorType()
    {
        return errorType;
    }

    public void setErrorType(String errorType)
    {
        this.errorType = errorType;
    }

    public String getResident()
    {
        return resident;
    }

    public void setResident(String resident)
    {
        this.resident = resident;
    }

    public String getFromScreen()
    {
        return fromScreen;
    }

    public void setFromScreen(String fromScreen)
    {
        this.fromScreen = fromScreen;
    }
    
    public String getCountryName()
    {
        return countryName;
    }

    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    /**
     * @return the displayMsg
     */
    public BigDecimal getDisplayMsg()
    {
        return displayMsg;
    }

    /**
     * @param displayMsg the displayMsg to set
     */
    public void setDisplayMsg(BigDecimal displayMsg)
    {
        this.displayMsg = displayMsg;
    }

    /**
     * @return the addString2
     */
    public String getAddString2()
    {
        return addString2;
    }

    /**
     * @param addString2 the addString2 to set
     */
    public void setAddString2(String addString2)
    {
	this.addString2 = addString2;
    }


    public String getTodoParam()
    {
	return todoParam;
    }

    public void setTodoParam(String todoParam)
    {
	this.todoParam = todoParam;
    }
    public String getBranchCentralisation()
    {
	return branchCentralisation;
    }

    public void setBranchCentralisation(String branchCentralisation)
    {
	this.branchCentralisation = branchCentralisation;
    }

    public String getAccNo()
    {
        return accNo;
    }

    public void setAccNo(String accNo)
    {
        this.accNo = accNo;
    }

    public String getDoNotfilterByUpdatePassBook()
    {
        return doNotfilterByUpdatePassBook;
    }

    public void setDoNotfilterByUpdatePassBook(String doNotfilterByUpdatePassBook)
    {
        this.doNotfilterByUpdatePassBook = doNotfilterByUpdatePassBook;
    }

    public boolean isSubsidiarySearch()
    {
        return subsidiarySearch;
    }

    public void setSubsidiarySearch(boolean subsidiarySearch)
    {
        this.subsidiarySearch = subsidiarySearch;
    }
    
    public BigDecimal getFmsCategory()
    {
	return fmsCategory;
    }

    public void setFmsCategory(BigDecimal fmsCategory)
    {
	this.fmsCategory = fmsCategory;
    }

    public String getIdNoFilter()
    {
        return idNoFilter;
    }

    public void setIdNoFilter(String idNoFilter)
    {
        this.idNoFilter = idNoFilter;
    }
    
    public String getAvaCardFlag()
    {
	return avaCardFlag;
    }

    public void setAvaCardFlag(String avaCardFlag)
    {
	this.avaCardFlag = avaCardFlag;
    }

    public BigDecimal getClubCode()
    {
        return clubCode;
    }

    public void setClubCode(BigDecimal clubCode)
    {
        this.clubCode = clubCode;
    }

    public boolean isCheckNbRec()
    {
        return checkNbRec;
    }

    public void setCheckNbRec(boolean checkNbRec)
    {
        this.checkNbRec = checkNbRec;
    }
    
    public String getPageRef()
    {
        return pageRef;
    }

    public void setPageRef(String pageRef)
    {
        this.pageRef = pageRef;
    }
    
    public int getTrxMgntNbRecords()
    {
        return trxMgntNbRecords;
    }

    public void setTrxMgntNbRecords(int trxMgntNbRecords)
    {
        this.trxMgntNbRecords = trxMgntNbRecords;
    }
    
    public BigDecimal getRestrBranchCode()
    {
        return restrBranchCode;
    }

    public void setRestrBranchCode(BigDecimal restrBranchCode)
    {
        this.restrBranchCode = restrBranchCode;
    }
    
    public String getApplyRestriction()
    {
        return applyRestriction;
    }

    public void setApplyRestriction(String applyRestriction)
    {
        this.applyRestriction = applyRestriction;
    }

    public String getChecksumDigit()
    {
        return checksumDigit;
    }

    public void setChecksumDigit(String checksumDigit)
    {
        this.checksumDigit = checksumDigit;
    }

    public String getCifWhereQuery()
    {
        return cifWhereQuery;
    }

    public void setCifWhereQuery(String cifWhereQuery)
    {
        this.cifWhereQuery = cifWhereQuery;
    }

    public boolean isProceedOnInactiveCIF()
    {
        return proceedOnInactiveCIF;
    }

    public void setProceedOnInactiveCIF(boolean proceedOnInactiveCIF)
    {
        this.proceedOnInactiveCIF = proceedOnInactiveCIF;
    }

    public boolean isThrowProceedOnInactiveCIFWarning()
    {
        return throwProceedOnInactiveCIFWarning;
    }

    public void setThrowProceedOnInactiveCIFWarning(boolean throwProceedOnInactiveCIFWarning)
    {
        this.throwProceedOnInactiveCIFWarning = throwProceedOnInactiveCIFWarning;
    }

    public String getBlkListScreenCheck()
    {
        return blkListScreenCheck;
    }

    public void setBlkListScreenCheck(String blkListScreenCheck)
    {
        this.blkListScreenCheck = blkListScreenCheck;
    }

    public BigDecimal getIsBank()
    {
	return isBank;
    }

    public void setIsBank(BigDecimal isBank)
    {
	this.isBank = isBank;
    }

    public String getSwitchBranchCode()
    {
        return switchBranchCode;
    }

    public void setSwitchBranchCode(String switchBranchCode)
    {
        this.switchBranchCode = switchBranchCode;
    }

    public String getLimitType()
    {
	return limitType;
    }

    public void setLimitType(String limitType)
    {
	this.limitType = limitType;
    }

    public String getAccountReference()
    {
	return accountReference;
    }

    public void setAccountReference(String accountReference)
    {
	this.accountReference = accountReference;
    }

    public String getCifByProviderBillType()
    {
	return cifByProviderBillType;
    }

    public void setCifByProviderBillType(String cifByProviderBillType)
    {
	this.cifByProviderBillType = cifByProviderBillType;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public String getCardTypeDesc()
    {
	return cardTypeDesc;
    }

    public void setCardTypeDesc(String cardTypeDesc)
    {
	this.cardTypeDesc = cardTypeDesc;
    }

    public BigDecimal getCardType()
    {
	return cardType;
    }

    public void setCardType(BigDecimal cardType)
    {
	this.cardType = cardType;
    }

    public BigDecimal getCif_Type()
    {
	return cif_Type;
    }

    public void setCif_Type(BigDecimal cif_Type)
    {
	this.cif_Type = cif_Type;
    }

    public BigDecimal getCifPriority()
    {
	return cifPriority;
    }

    public void setCifPriority(BigDecimal cifPriority)
    {
	this.cifPriority = cifPriority;
    }

    public BigDecimal getParentType()
    {
	return parentType;
    }

    public void setParentType(BigDecimal parentType)
    {
	this.parentType = parentType;
    }

    public String getCardNo()
    {
	return cardNo;
    }

    public void setCardNo(String cardNo)
    {
	this.cardNo = cardNo;
    }

    public int getCheckWithoutStatus()
    {
	return checkWithoutStatus;
    }

    public void setCheckWithoutStatus(int checkWithoutStatus)
    {
	this.checkWithoutStatus = checkWithoutStatus;
    }

    public String getIsFromDependency()
    {
        return isFromDependency;
    }

    public void setIsFromDependency(String isFromDependency)
    {
        this.isFromDependency = isFromDependency;
    }

    public BigDecimal getKycCode()
    {
	return kycCode;
    }

    public void setKycCode(BigDecimal kycCode)
    {
	this.kycCode = kycCode;
    }

    public String getPepDescription()
    {
	return pepDescription;
    }

    public void setPepDescription(String pepDescription)
    {
	this.pepDescription = pepDescription;
    }

    public String getCardReaderCivilID()
    {
	return cardReaderCivilID;
    }

    public void setCardReaderCivilID(String cardReaderCivilID)
    {
	this.cardReaderCivilID = cardReaderCivilID;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    public String getCrud()
    {
        return crud;
    }

    public void setCrud(String crud)
    {
        this.crud = crud;
    }

    public BigDecimal getSegmentCode()
    {
        return segmentCode;
    }

    public void setSegmentCode(BigDecimal segmentCode)
    {
        this.segmentCode = segmentCode;
    }
    
    public String getEcoSecProfMatrix()
    {
        return ecoSecProfMatrix;
    }

    public void setEcoSecProfMatrix(String ecoSecProfMatrix)
    {
        this.ecoSecProfMatrix = ecoSecProfMatrix;
    }
    public String getPopulateImage()
    {
	return populateImage;
    }

    public void setPopulateImage(String populateImage)
    {
	this.populateImage = populateImage;
    }

    public BigDecimal getRequestId()
    {
	return requestId;
    }

    public void setRequestId(BigDecimal requestId)
    {
	this.requestId = requestId;
    }

    public String getAllow_suspended_cif()
    {
	return allow_suspended_cif;
    }

    public void setAllow_suspended_cif(String allow_suspended_cif)
    {
	this.allow_suspended_cif = allow_suspended_cif;
    }

	
    public BigDecimal getExcludeCheckingOnSuspense()
    {
	return excludeCheckingOnSuspense;
    }

    public void setExcludeCheckingOnSuspense(BigDecimal excludeCheckingOnSuspense)
    {
	this.excludeCheckingOnSuspense = excludeCheckingOnSuspense;
    }
}
