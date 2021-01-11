package com.path.vo.core.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSTELLERACCDETVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.vo.common.AmountCO;
import com.path.vo.common.blacklistmanagement.MosBlackListCO;
import com.path.vo.core.common.RetailBaseVO;

public class AccountCO extends RetailBaseVO
{

    public String getWarningMessage()
    {
        return warningMessage;
    }

    public void setWarningMessage(String warningMessage)
    {
        this.warningMessage = warningMessage;
    }

    private AMFVO amfVO = new AMFVO();
    private CIFVO cifVO = new CIFVO();
    private AMFVO amfSC = new AMFVO();
    private CTSTELLERACCDETVO ctsTellerAccDet = new CTSTELLERACCDETVO();
    private CURRENCIESVO currency = new CURRENCIESVO();
    private GEN_LEDGERVO glVO = new GEN_LEDGERVO();
    private String nullOldStatus = "";
    private String nullSuspendBy = "";
    private String nullDateSuspended = "";
    private String nullSuspendReason = "";

    private String FORBID_TRX;
    private String FORBID_PRODUCT;
    private String reasonEng;
    private String reasonAr;
    private BigDecimal errorCode;
    private String errorMsg;
    private String cifAcc;
    private RIFATTVO rifattVO;
    private String accountType;
    private BigDecimal accCount;
    private BigDecimal accAmount;
    private String STATUSDESC;
    private String creditDebit; // To know if we are checking Special Condition for Credit or Debit
                                // cases
    private BigDecimal amtFormat;
    private BigDecimal pointRate;
    private BigDecimal newBS;
    private MosBlackListCO mosBlackListCO = new MosBlackListCO();
    private String civilCodeDesc;
    private String BRIEF_NAME;
    private String TRF_ADD_REF;
    private String CUR_ADD_REF;
    private String OFF_ADD_REF;
    private String PFT_ADD_REF;
    //maria for bmo180074
    private BigDecimal sl_no; 
    private String errorType;
    private String origin;
    private String createFrom;
    /**
     * added by jihad if we need to set the status as old status
     */
    private String updateStatusToOldStatus = "";
    /**
     * added by jihad if we need to set the status as old status
     */
    private String updateOldStatusToStatus = "";
    /**
     * added by jihad this is a list of type used for searchcritiria
     */
    private List<String> gmiList = new ArrayList<String>();
    /**
     * added by jihad this is a list of status used for searchcritiria
     */
    private List<String> statusList = new ArrayList<String>();

    private List<String> oldStatusList = new ArrayList<String>();

    private AmountCO amount = new AmountCO();

    private String validateCurrency;
    private String validateCurrenGl;
    private String validateCif;
    private String validateSl;
    private String calculateCvAmount;
    private String calculateFcAmount;
    private String validateSpecialCond;// 0:apply,1:do not
    private String includeFGI;// this flag is used to include the GMI criteria needed('F','G','I')
    // if the currency is based
    private boolean basedCy;
    private String validateAccountPart;// this flag is used to check when the user enter a apart of
                                       // an account exits in Account
    private String validateGlCategory;
    private String validateGlType;
    private String glType;
    private String accountName;
    private String callCyDep;
    private String warningMessage;
    
    private BigDecimal taxVatCode;
    private BigDecimal vatPercentage;
    private BigDecimal vatMinAmount;
    private BigDecimal vatMaxAmount;
    private BigDecimal vatInputCy;
    private BigDecimal vatInputGl;
    private BigDecimal vatInputCif;
    private BigDecimal vatInputSl;
    //Bassam Eid - BUG# 512170
    //Flag 0/1 to treat the Forbid CSM special condition parametrization as Restrict     
    private String makeForbidAsRestrict;
    //////////////////////////
    private BigDecimal transferAm;
    private String debitAddRef;
    private BigDecimal outSLNo;
    private BigDecimal subsidiary;
    
    
    //Hala Al Sheikh
    private String toAccountSign; 
    private BigDecimal toBranchCode;
    private BigDecimal toCurrencyCode;
    private BigDecimal toGlCode;
    private BigDecimal toCifSubNo;
    private BigDecimal toSlNo;
    private String multiTrx;
    
    //Transferred CIF data
    private String ACC_CHEQBOOKS;//           Chequebooks                                    Chéquiers
    private String ACC_CARDS;//                       Cards                                                     Cartes
    private String ACC_SAFEBOX;//                  Safe Box                                              Coffres Forts
    private String ACC_CSM_HOF;//                Hold of Funds                                    Blocage de fonds                             
    private String ACC_IISFMS_HOF;//            System Hold of funds                     Blocage de fonds (système)
    private String ACC_SO;//                               Standing Orders                               Istructions Permanantes
    private String ACC_CTSSPCOND;//            Special Conditions                           Conditions spéciales
    private String ACC_COLLATERALS;//         Collaterals                                           Guaranties
    private String ACC_DEALS;//                        Deals                                                     Financements

    
    public AMFVO getAmfVO()
    {
        return amfVO;
    }

    public void setAmfVO(AMFVO amfVO)
    {
        this.amfVO = amfVO;
    }

    public CIFVO getCifVO()
    {
        return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }

    public List<String> getGmiList()
    {
        return gmiList;
    }

    public void setGmiList(List<String> gmiList)
    {
        this.gmiList = gmiList;
    }

    public List<String> getStatusList()
    {
        return statusList;
    }

    public void setStatusList(List<String> statusList)
    {
        this.statusList = statusList;
    }

    public String getUpdateStatusToOldStatus()
    {
        return updateStatusToOldStatus;
    }

    public void setUpdateStatusToOldStatus(String updateStatusToOldStatus)
    {
        this.updateStatusToOldStatus = updateStatusToOldStatus;
    }

    public String getUpdateOldStatusToStatus()
    {
        return updateOldStatusToStatus;
    }

    public void setUpdateOldStatusToStatus(String updateOldStatusToStatus)
    {
        this.updateOldStatusToStatus = updateOldStatusToStatus;
    }

    public AMFVO getAmfSC()
    {
        return amfSC;
    }

    public void setAmfSC(AMFVO amfSC)
    {
        this.amfSC = amfSC;
    }

    public String getNullOldStatus()
    {
        return nullOldStatus;
    }

    public void setNullOldStatus(String nullOldStatus)
    {
        this.nullOldStatus = nullOldStatus;
    }

    public String getNullSuspendBy()
    {
        return nullSuspendBy;
    }

    public void setNullSuspendBy(String nullSuspendBy)
    {
        this.nullSuspendBy = nullSuspendBy;
    }

    public String getNullDateSuspended()
    {
        return nullDateSuspended;
    }

    public void setNullDateSuspended(String nullDateSuspended)
    {
        this.nullDateSuspended = nullDateSuspended;
    }

    public String getNullSuspendReason()
    {
        return nullSuspendReason;
    }

    public void setNullSuspendReason(String nullSuspendReason)
    {
        this.nullSuspendReason = nullSuspendReason;
    }

    public void setMosBlackListCO(MosBlackListCO mosBlackListCO)
    {
        this.mosBlackListCO = mosBlackListCO;
    }

    public CURRENCIESVO getCurrency()
    {
        return currency;
    }

    public void setCurrency(CURRENCIESVO currency)
    {
        this.currency = currency;
    }

    public GEN_LEDGERVO getGlVO()
    {
        return glVO;
    }

    public void setGlVO(GEN_LEDGERVO glVO)
    {
        this.glVO = glVO;
    }

    public RIFATTVO getRifattVO()
    {
        return rifattVO;
    }

    public void setRifattVO(RIFATTVO rifattVO)
    {
        this.rifattVO = rifattVO;
    }

    public List<String> getOldStatusList()
    {
        return oldStatusList;
    }

    public void setOldStatusList(List<String> oldStatusList)
    {
        this.oldStatusList = oldStatusList;
    }

    public String getFORBID_TRX()
    {
        return FORBID_TRX;
    }

    public void setFORBID_TRX(String fORBIDTRX)
    {
        FORBID_TRX = fORBIDTRX;
    }

    public String getFORBID_PRODUCT()
    {
        return FORBID_PRODUCT;
    }

    public void setFORBID_PRODUCT(String fORBIDPRODUCT)
    {
        FORBID_PRODUCT = fORBIDPRODUCT;
    }

    public String getReasonEng()
    {
        return reasonEng;
    }

    public void setReasonEng(String reasonEng)
    {
        this.reasonEng = reasonEng;
    }

    public String getReasonAr()
    {
        return reasonAr;
    }

    public void setReasonAr(String reasonAr)
    {
        this.reasonAr = reasonAr;
    }

    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public String getCifAcc()
    {
        return cifAcc;
    }

    public void setCifAcc(String cifAcc)
    {
        this.cifAcc = cifAcc;
    }

    public CTSTELLERACCDETVO getCtsTellerAccDet()
    {
        return ctsTellerAccDet;
    }

    public void setCtsTellerAccDet(CTSTELLERACCDETVO ctsTellerAccDet)
    {
        this.ctsTellerAccDet = ctsTellerAccDet;
    }

    /**
     * @return the accountType
     */
    public String getAccountType()
    {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public BigDecimal getAccCount()
    {
        return accCount;
    }

    public void setAccCount(BigDecimal accCount)
    {
        this.accCount = accCount;
    }

    public String getSTATUSDESC()
    {
        return STATUSDESC;
    }

    public void setSTATUSDESC(String sTATUSDESC)
    {
        STATUSDESC = sTATUSDESC;
    }

    public String getCreditDebit()
    {
        return creditDebit;
    }

    public void setCreditDebit(String creditDebit)
    {
        this.creditDebit = creditDebit;
    }

    public BigDecimal getAmtFormat()
    {
        return amtFormat;
    }

    public void setAmtFormat(BigDecimal amtFormat)
    {
        this.amtFormat = amtFormat;
    }

    public MosBlackListCO getMosBlackListCO()
    {
        return mosBlackListCO;
    }

    public String getCivilCodeDesc()
    {
        return civilCodeDesc;
    }

    public void setCivilCodeDesc(String civilCodeDesc)
    {
        this.civilCodeDesc = civilCodeDesc;
    }

    public BigDecimal getAccAmount()
    {
        return accAmount;
    }

    public void setAccAmount(BigDecimal accAmount)
    {
        this.accAmount = accAmount;
    }

    public AmountCO getAmount()
    {
        return amount;
    }

    public void setAmount(AmountCO amount)
    {
        this.amount = amount;
    }

    public String getValidateCurrency()
    {
        return validateCurrency;
    }

    public void setValidateCurrency(String validateCurrency)
    {
        this.validateCurrency = validateCurrency;
    }

    public String getValidateCurrenGl()
    {
        return validateCurrenGl;
    }

    public void setValidateCurrenGl(String validateCurrenGl)
    {
        this.validateCurrenGl = validateCurrenGl;
    }

    public String getValidateCif()
    {
        return validateCif;
    }

    public void setValidateCif(String validateCif)
    {
        this.validateCif = validateCif;
    }

    public String getValidateSl()
    {
        return validateSl;
    }

    public void setValidateSl(String validateSl)
    {
        this.validateSl = validateSl;
    }

    public String getCalculateFcAmount()
    {
        return calculateFcAmount;
    }

    public void setCalculateFcAmount(String calculateFcAmount)
    {
        this.calculateFcAmount = calculateFcAmount;
    }

    public boolean isBasedCy()
    {
        return basedCy;
    }

    public void setBasedCy(boolean basedCy)
    {
        this.basedCy = basedCy;
    }

    public String getCalculateCvAmount()
    {
        return calculateCvAmount;
    }

    public void setCalculateCvAmount(String calculateCvAmount)
    {
        this.calculateCvAmount = calculateCvAmount;
    }

    public String getValidateAccountPart()
    {
        return validateAccountPart;
    }

    public void setValidateAccountPart(String validateAccountPart)
    {
        this.validateAccountPart = validateAccountPart;
    }

    public String getValidateSpecialCond()
    {
        return validateSpecialCond;
    }

    public void setValidateSpecialCond(String validateSpecialCond)
    {
        this.validateSpecialCond = validateSpecialCond;
    }

    public String getIncludeFGI()
    {
        return includeFGI;
    }

    public void setIncludeFGI(String includeFGI)
    {
        this.includeFGI = includeFGI;
    }

    /**
     * @return the validateGlCategory
     */
    public String getValidateGlCategory()
    {
        return validateGlCategory;
    }

    /**
     * @param validateGlCategory the validateGlCategory to set
     */
    public void setValidateGlCategory(String validateGlCategory)
    {
        this.validateGlCategory = validateGlCategory;
    }

    /**
     * @return the validateGlType
     */
    public String getValidateGlType()
    {
        return validateGlType;
    }

    /**
     * @param validateGlType the validateGlType to set
     */
    public void setValidateGlType(String validateGlType)
    {
        this.validateGlType = validateGlType;
    }

    /**
     * @return the glType
     */
    public String getGlType()
    {
        return glType;
    }

    /**
     * @param glType the glType to set
     */
    public void setGlType(String glType)
    {
        this.glType = glType;
    }

    /**
     * @return the accountName
     */
    public String getAccountName()
    {
        return accountName;
    }

    /**
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    public String getBRIEF_NAME()
    {
        return BRIEF_NAME;
    }

    public void setBRIEF_NAME(String bRIEFNAME)
    {
        BRIEF_NAME = bRIEFNAME;
    }

    /**
     * @return the tRF_ADD_REF
     */
    public String getTRF_ADD_REF()
    {
        return TRF_ADD_REF;
    }

    /**
     * @param tRFADDREF the tRF_ADD_REF to set
     */
    public void setTRF_ADD_REF(String tRFADDREF)
    {
        TRF_ADD_REF = tRFADDREF;
    }

    /**
     * @return the cUR_ADD_REF
     */
    public String getCUR_ADD_REF()
    {
        return CUR_ADD_REF;
    }

    /**
     * @param cURADDREF the cUR_ADD_REF to set
     */
    public void setCUR_ADD_REF(String cURADDREF)
    {
        CUR_ADD_REF = cURADDREF;
    }

    /**
     * @return the oFF_ADD_REF
     */
    public String getOFF_ADD_REF()
    {
        return OFF_ADD_REF;
    }

    /**
     * @param oFFADDREF the oFF_ADD_REF to set
     */
    public void setOFF_ADD_REF(String oFFADDREF)
    {
        OFF_ADD_REF = oFFADDREF;
    }

    /**
     * @return the pFT_ADD_REF
     */
    public String getPFT_ADD_REF()
    {
        return PFT_ADD_REF;
    }

    /**
     * @param pFTADDREF the pFT_ADD_REF to set
     */
    public void setPFT_ADD_REF(String pFTADDREF)
    {
        PFT_ADD_REF = pFTADDREF;
    }

    /**
     * @return the pointRate
     */
    public BigDecimal getPointRate()
    {
        return pointRate;
    }

    /**
     * @param pointRate the pointRate to set
     */
    public void setPointRate(BigDecimal pointRate)
    {
        this.pointRate = pointRate;
    }

    /**
     * @return the newBS
     */
    public BigDecimal getNewBS()
    {
        return newBS;
    }

    /**
     * @param newBS the newBS to set
     */
    public void setNewBS(BigDecimal newBS)
    {
        this.newBS = newBS;
    }

    public String getCallCyDep()
    {
        return callCyDep;
    }

    public void setCallCyDep(String callCyDep)
    {
        this.callCyDep = callCyDep;
    }
    

    public String getMakeForbidAsRestrict()
    {
        return makeForbidAsRestrict;
    }

    public void setMakeForbidAsRestrict(String makeForbidAsRestrict)
    {
        this.makeForbidAsRestrict = makeForbidAsRestrict;
    }

    public BigDecimal getTransferAm()
    {
        return transferAm;
    }

    public void setTransferAm(BigDecimal transferAm)
    {
        this.transferAm = transferAm;
    }

    public String getDebitAddRef()
    {
        return debitAddRef;
    }

    public void setDebitAddRef(String debitAddRef)
    {
        this.debitAddRef = debitAddRef;
    }

    public BigDecimal getOutSLNo()
    {
        return outSLNo;
    }

    public void setOutSLNo(BigDecimal outSLNo)
    {
        this.outSLNo = outSLNo;
    }

    public String getToAccountSign()
    {
        return toAccountSign;
    }

    public void setToAccountSign(String toAccountSign)
    {
        this.toAccountSign = toAccountSign;
    }

    public BigDecimal getToBranchCode()
    {
        return toBranchCode;
    }

    public void setToBranchCode(BigDecimal toBranchCode)
    {
        this.toBranchCode = toBranchCode;
    }

    public BigDecimal getToCurrencyCode()
    {
        return toCurrencyCode;
    }

    public void setToCurrencyCode(BigDecimal toCurrencyCode)
    {
        this.toCurrencyCode = toCurrencyCode;
    }

    public BigDecimal getToGlCode()
    {
        return toGlCode;
    }

    public void setToGlCode(BigDecimal toGlCode)
    {
        this.toGlCode = toGlCode;
    }

    public BigDecimal getToCifSubNo()
    {
        return toCifSubNo;
    }

    public void setToCifSubNo(BigDecimal toCifSubNo)
    {
        this.toCifSubNo = toCifSubNo;
    }

    public BigDecimal getToSlNo()
    {
        return toSlNo;
    }

    public void setToSlNo(BigDecimal toSlNo)
    {
        this.toSlNo = toSlNo;
    }

    public String getMultiTrx()
    {
        return multiTrx;
    }

    public void setMultiTrx(String multiTrx)
    {
        this.multiTrx = multiTrx;
    }


    public BigDecimal getSubsidiary()
    {
        return subsidiary;
    }

    public void setSubsidiary(BigDecimal subsidiary)
    {
        this.subsidiary = subsidiary;
    }

    public String getACC_CHEQBOOKS()
    {
        return ACC_CHEQBOOKS;
    }

    public void setACC_CHEQBOOKS(String aCCCHEQBOOKS)
    {
        ACC_CHEQBOOKS = aCCCHEQBOOKS;
    }

    public String getACC_CARDS()
    {
        return ACC_CARDS;
    }

    public void setACC_CARDS(String aCCCARDS)
    {
        ACC_CARDS = aCCCARDS;
    }

    public String getACC_SAFEBOX()
    {
        return ACC_SAFEBOX;
    }

    public void setACC_SAFEBOX(String aCCSAFEBOX)
    {
        ACC_SAFEBOX = aCCSAFEBOX;
    }

    public String getACC_CSM_HOF()
    {
        return ACC_CSM_HOF;
    }

    public void setACC_CSM_HOF(String aCCCSMHOF)
    {
        ACC_CSM_HOF = aCCCSMHOF;
    }

    public String getACC_IISFMS_HOF()
    {
        return ACC_IISFMS_HOF;
    }

    public void setACC_IISFMS_HOF(String aCCIISFMSHOF)
    {
        ACC_IISFMS_HOF = aCCIISFMSHOF;
    }

    public String getACC_SO()
    {
        return ACC_SO;
    }

    public void setACC_SO(String aCCSO)
    {
        ACC_SO = aCCSO;
    }

    public String getACC_CTSSPCOND()
    {
        return ACC_CTSSPCOND;
    }

    public void setACC_CTSSPCOND(String aCCCTSSPCOND)
    {
        ACC_CTSSPCOND = aCCCTSSPCOND;
    }

    public String getACC_COLLATERALS()
    {
        return ACC_COLLATERALS;
    }

    public void setACC_COLLATERALS(String aCCCOLLATERALS)
    {
        ACC_COLLATERALS = aCCCOLLATERALS;
    }

    public String getACC_DEALS()
    {
        return ACC_DEALS;
    }

    public void setACC_DEALS(String aCCDEALS)
    {
        ACC_DEALS = aCCDEALS;
    }
    public BigDecimal getSl_no()
    {
        return sl_no;
    }

    public void setSl_no(BigDecimal sl_no)
    {
        this.sl_no = sl_no;
    }

    public String getErrorType()
    {
        return errorType;
    }

    public void setErrorType(String errorType)
    {
        this.errorType = errorType;
    }

    public String getOrigin()
    {
        return origin;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public String getCreateFrom()
    {
        return createFrom;
    }

    public void setCreateFrom(String createFrom)
    {
        this.createFrom = createFrom;
    }

    public BigDecimal getTaxVatCode()
    {
	return taxVatCode;
    }

    public void setTaxVatCode(BigDecimal taxVatCode)
    {
	this.taxVatCode = taxVatCode;
    }

    public BigDecimal getVatPercentage()
    {
	return vatPercentage;
    }

    public void setVatPercentage(BigDecimal vatPercentage)
    {
	this.vatPercentage = vatPercentage;
    }

    public BigDecimal getVatMinAmount()
    {
	return vatMinAmount;
    }

    public void setVatMinAmount(BigDecimal vatMinAmount)
    {
	this.vatMinAmount = vatMinAmount;
    }

    public BigDecimal getVatMaxAmount()
    {
	return vatMaxAmount;
    }

    public void setVatMaxAmount(BigDecimal vatMaxAmount)
    {
	this.vatMaxAmount = vatMaxAmount;
    }

    public BigDecimal getVatInputCy()
    {
	return vatInputCy;
    }

    public void setVatInputCy(BigDecimal vatInputCy)
    {
	this.vatInputCy = vatInputCy;
    }

    public BigDecimal getVatInputGl()
    {
	return vatInputGl;
    }

    public void setVatInputGl(BigDecimal vatInputGl)
    {
	this.vatInputGl = vatInputGl;
    }

    public BigDecimal getVatInputCif()
    {
	return vatInputCif;
    }

    public void setVatInputCif(BigDecimal vatInputCif)
    {
	this.vatInputCif = vatInputCif;
    }

    public BigDecimal getVatInputSl()
    {
	return vatInputSl;
    }

    public void setVatInputSl(BigDecimal vatInputSl)
    {
	this.vatInputSl = vatInputSl;
    }

}
