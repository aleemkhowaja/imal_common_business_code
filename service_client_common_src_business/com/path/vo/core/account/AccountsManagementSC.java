package com.path.vo.core.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.struts2.lib.common.GridParamsSC;

public class AccountsManagementSC extends GridParamsSC
{
    private String status; // RA_STATUS
    private String accountNumber; // RA_CODE
   	private String gmiFlag; // RA_GMI
    private BigDecimal currencyCode;
    private BigDecimal glCode;
    private BigDecimal cifSubNo;
    private BigDecimal slNo;
    private String langCode;
    private BigDecimal lovType;
    public String saveType;
    private List listBranches;
    private String bsContra;
    private String addRef;
    private String pageRef;
    private BigDecimal fromYearMonth;
    private BigDecimal toYearMonth;
    private String calledFrom;
    private Boolean isPrintCertificate = Boolean.FALSE;
    private BigDecimal fiscalYear;
    private BigDecimal scannedCIFNo;
    private BigDecimal fiscalMonth;

    private BigDecimal baseCurrDecPoint;
    private BigDecimal loginBraCode;
    private BigDecimal applicationId;
    private BigDecimal branch;

    private BigDecimal remittanceType;
    private BigDecimal seqNo;
    private String serialNo;
    private BigDecimal remittAccBr;
    private BigDecimal remittAccCy;
    private BigDecimal remittAccGl;
    private BigDecimal remittAccCif;
    private BigDecimal remittAccSl;
    private String actionType;

    private List<AmfDrawDownsCO> drawDownLst = new ArrayList<AmfDrawDownsCO>();
    private BigDecimal drawDownNumber;// DD_NO
    private BigDecimal drawDownBranch;// DD_BR
    private BigDecimal cifType;
    private BigDecimal objectCode;
    private boolean returnChargesSchemaFromPftRate;
    private String chargesSchemaGridUpdate;
    private String editType;
    //Tony Nouh User Story#336860 INDI150072
    private String ptDetailsSign;
    private String colRateTitle;
    private BigDecimal compCodeCif;
    private String allowCifCreationMaskYN;
    
    // Hasan ghrayeb - BB200160
    private BigDecimal oldbalancelimit;
    private String oldprcdandwarnaction;
    // End Hasan
    

    //Habib Baalbaki accocunt restriction 372747
    private String errType;
    private String errMsg;
    private BigDecimal rtrnVal;
    private BigDecimal errCode;
    private boolean checkNbRec;
    private int trxMgntNbRecords;
    private List<AccountsManagementCO> accountListRecords = new ArrayList<>();
    private List<AMFVO> amfListRecords = new ArrayList<AMFVO>();
    private String ibanAccNo ;
    private BigDecimal tellerCode;
    private String applyCifTypeRestrOnAcc;
    private BigDecimal cifNo;
    private ArrayList<String> listProgRef; 
    
    //Hala Al Sheikh - SBI170059 SBI170060
    private BigDecimal invstAccBR;
    private BigDecimal invstAccCY;
    private BigDecimal invstAccGL;
    private BigDecimal invstAccCIF;
    private BigDecimal invstAccSL;
    private String accountSearchQuery;
    private String fromDeleteDrawDown;
    private String musharaka;
    
    public String getLangCode()
    {
	return langCode;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getAccountNumber()
    {
	return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
	this.accountNumber = accountNumber;
    }

    public String getGmiFlag()
    {
	return gmiFlag;
    }

    public void setGmiFlag(String gmiFlag)
    {
	this.gmiFlag = gmiFlag;
    }

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    public BigDecimal getGlCode()
    {
	return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    public BigDecimal getCifSubNo()
    {
	return cifSubNo;
    }

    public void setCifSubNo(BigDecimal cifSubNo)
    {
	this.cifSubNo = cifSubNo;
    }

    public BigDecimal getSlNo()
    {
	return slNo;
    }

    public void setSlNo(BigDecimal slNo)
    {
	this.slNo = slNo;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public List getListBranches()
    {
	return listBranches;
    }

    public void setListBranches(List listBranches)
    {
	this.listBranches = listBranches;
    }

    /**
     * @return the bsContra
     */
    public String getBsContra()
    {
	return bsContra;
    }

    /**
     * @param bsContra the bsContra to set
     */
    public void setBsContra(String bsContra)
    {
	this.bsContra = bsContra;
    }

    /**
     * @return the pageRef
     */
    public String getPageRef()
    {
	return pageRef;
    }

    /**
     * @param pageRef the pageRef to set
     */
    public void setPageRef(String pageRef)
    {
	this.pageRef = pageRef;
    }

    /**
     * @return the fromYearMonth
     */
    public BigDecimal getFromYearMonth()
    {
	return fromYearMonth;
    }

    /**
     * @param fromYearMonth the fromYearMonth to set
     */
    public void setFromYearMonth(BigDecimal fromYearMonth)
    {
	this.fromYearMonth = fromYearMonth;
    }

    /**
     * @return the toYearMonth
     */
    public BigDecimal getToYearMonth()
    {
	return toYearMonth;
    }

    /**
     * @param toYearMonth the toYearMonth to set
     */
    public void setToYearMonth(BigDecimal toYearMonth)
    {
	this.toYearMonth = toYearMonth;
    }

    /**
     * @return the calledFrom
     */
    public String getCalledFrom()
    {
	return calledFrom;
    }

    /**
     * @param calledFrom the calledFrom to set
     */
    public void setCalledFrom(String calledFrom)
    {
	this.calledFrom = calledFrom;
    }

    /**
     * @return the fiscalYear
     */
    public BigDecimal getFiscalYear()
    {
	return fiscalYear;
    }

    /**
     * @param fiscalYear the fiscalYear to set
     */
    public void setFiscalYear(BigDecimal fiscalYear)
    {
	this.fiscalYear = fiscalYear;
    }

    /**
     * @return the fiscalMonth
     */
    public BigDecimal getFiscalMonth()
    {
	return fiscalMonth;
    }

    /**
     * @param fiscalMonth the fiscalMonth to set
     */
    public void setFiscalMonth(BigDecimal fiscalMonth)
    {
	this.fiscalMonth = fiscalMonth;
    }

    /**
     * @return the baseCurrDecPoint
     */
    public BigDecimal getBaseCurrDecPoint()
    {
	return baseCurrDecPoint;
    }

    /**
     * @param baseCurrDecPoint the baseCurrDecPoint to set
     */
    public void setBaseCurrDecPoint(BigDecimal baseCurrDecPoint)
    {
	this.baseCurrDecPoint = baseCurrDecPoint;
    }

    /**
     * @return the loginBraCode
     */
    public BigDecimal getLoginBraCode()
    {
	return loginBraCode;
    }

    /**
     * @param loginBraCode the loginBraCode to set
     */
    public void setLoginBraCode(BigDecimal loginBraCode)
    {
	this.loginBraCode = loginBraCode;
    }

    public Boolean getIsPrintCertificate()
    {
	return isPrintCertificate;
    }

    public void setIsPrintCertificate(Boolean isPrintCertificate)
    {
	this.isPrintCertificate = isPrintCertificate;
    }

    /**
     * @return the applicationId
     */
    public BigDecimal getApplicationId()
    {
	return applicationId;
    }

    /**
     * @param applicationId the applicationId to set
     */
    public void setApplicationId(BigDecimal applicationId)
    {
	this.applicationId = applicationId;
    }

    public BigDecimal getBranch()
    {
	return branch;
    }

    public void setBranch(BigDecimal branch)
    {
	this.branch = branch;
    }

    public BigDecimal getScannedCIFNo()
    {
	return scannedCIFNo;
    }

    public void setScannedCIFNo(BigDecimal scannedCIFNo)
    {
	this.scannedCIFNo = scannedCIFNo;
    }

    public BigDecimal getRemittanceType()
    {
	return remittanceType;
    }

    public void setRemittanceType(BigDecimal remittanceType)
    {
	this.remittanceType = remittanceType;
    }

    public BigDecimal getSeqNo()
    {
	return seqNo;
    }

    public void setSeqNo(BigDecimal seqNo)
    {
	this.seqNo = seqNo;
    }

    public String getSerialNo()
    {
	return serialNo;
    }

    public void setSerialNo(String serialNo)
    {
	this.serialNo = serialNo;
    }

    public BigDecimal getRemittAccBr()
    {
	return remittAccBr;
    }

    public void setRemittAccBr(BigDecimal remittAccBr)
    {
	this.remittAccBr = remittAccBr;
    }

    public BigDecimal getRemittAccCy()
    {
	return remittAccCy;
    }

    public void setRemittAccCy(BigDecimal remittAccCy)
    {
	this.remittAccCy = remittAccCy;
    }

    public BigDecimal getRemittAccGl()
    {
	return remittAccGl;
    }

    public void setRemittAccGl(BigDecimal remittAccGl)
    {
	this.remittAccGl = remittAccGl;
    }

    public BigDecimal getRemittAccCif()
    {
	return remittAccCif;
    }

    public void setRemittAccCif(BigDecimal remittAccCif)
    {
	this.remittAccCif = remittAccCif;
    }

    public BigDecimal getRemittAccSl()
    {
	return remittAccSl;
    }

    public void setRemittAccSl(BigDecimal remittAccSl)
    {
	this.remittAccSl = remittAccSl;
    }

    public List<AmfDrawDownsCO> getDrawDownLst()
    {
	return drawDownLst;
    }

    public void setDrawDownLst(List<AmfDrawDownsCO> drawDownLst)
    {
	this.drawDownLst = drawDownLst;
    }

    public String getActionType()
    {
	return actionType;
    }

    public void setActionType(String actionType)
    {
	this.actionType = actionType;
    }

    public BigDecimal getDrawDownNumber()
    {
	return drawDownNumber;
    }

    public void setDrawDownNumber(BigDecimal drawDownNumber)
    {
	this.drawDownNumber = drawDownNumber;
    }

    public BigDecimal getDrawDownBranch()
    {
	return drawDownBranch;
    }

    public void setDrawDownBranch(BigDecimal drawDownBranch)
    {
	this.drawDownBranch = drawDownBranch;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public BigDecimal getObjectCode()
    {
        return objectCode;
    }

    public void setObjectCode(BigDecimal objectCode)
    {
        this.objectCode = objectCode;
    }

    public boolean isReturnChargesSchemaFromPftRate()
    {
        return returnChargesSchemaFromPftRate;
    }

    public void setReturnChargesSchemaFromPftRate(boolean returnChargesSchemaFromPftRate)
    {
        this.returnChargesSchemaFromPftRate = returnChargesSchemaFromPftRate;
    }

    public String getChargesSchemaGridUpdate()
    {
        return chargesSchemaGridUpdate;
    }

    public void setChargesSchemaGridUpdate(String chargesSchemaGridUpdate)
    {
        this.chargesSchemaGridUpdate = chargesSchemaGridUpdate;
    }

    /**
     * @return the addRef
     */
    public String getAddRef()
    {
        return addRef;
    }

    /**
     * @param addRef the addRef to set
     */
    public void setAddRef(String addRef)
    {
        this.addRef = addRef;
    }
    
    public String getEditType()
    {
        return editType;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    public void setEditType(String editType)
    {
        this.editType = editType;
    }


    public String getErrType()
    {
        return errType;
    }

    public void setErrType(String errType)
    {
        this.errType = errType;
    }

    public String getErrMsg()
    {
        return errMsg;
    }

    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }

    public BigDecimal getRtrnVal()
    {
        return rtrnVal;
    }

    public void setRtrnVal(BigDecimal rtrnVal)
    {
        this.rtrnVal = rtrnVal;
    }

    public BigDecimal getErrCode()
    {
        return errCode;
    }

    public void setErrCode(BigDecimal errCode)
    {
        this.errCode = errCode;
    }

    public boolean isCheckNbRec()
    {
        return checkNbRec;
    }

    public void setCheckNbRec(boolean checkNbRec)
    {
        this.checkNbRec = checkNbRec;
    }

    public int getTrxMgntNbRecords()
    {
        return trxMgntNbRecords;
    }

    public void setTrxMgntNbRecords(int trxMgntNbRecords)
    {
        this.trxMgntNbRecords = trxMgntNbRecords;
    }

    public List<AccountsManagementCO> getAccountListRecords()
    {
        return accountListRecords;
    }

    public void setAccountListRecords(List<AccountsManagementCO> accountListRecords)
    {
        this.accountListRecords = accountListRecords;
    }


    public void setListProgRef(ArrayList<String> listProgRef)
    {
	this.listProgRef = listProgRef;
    }

    public List<AMFVO> getAmfListRecords()
    {
	return amfListRecords;
    }
   
    public String getIbanAccNo()
    {
	return ibanAccNo;
    }

    public void setIbanAccNo(String ibanAccNo)
    {
	this.ibanAccNo = ibanAccNo;
    }

    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
    }

    public String getApplyCifTypeRestrOnAcc()
    {
	return applyCifTypeRestrOnAcc;
    }

    public BigDecimal getInvstAccBR()
    {
        return invstAccBR;
    }
    public void setApplyCifTypeRestrOnAcc(String applyCifTypeRestrOnAcc)
    {
	this.applyCifTypeRestrOnAcc = applyCifTypeRestrOnAcc;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public void setAmfListRecords(List<AMFVO> amfListRecords)
    {
	this.amfListRecords = amfListRecords;
    }

    public String getAccountSearchQuery()
    {
	return accountSearchQuery;
    }

    public void setInvstAccBR(BigDecimal invstAccBR)
    {
        this.invstAccBR = invstAccBR;
    }

    public void setAccountSearchQuery(String accountSearchQuery)
    {
	this.accountSearchQuery = accountSearchQuery;
    }

    public BigDecimal getInvstAccCY()
    {
        return invstAccCY;
    }

    public List<String> getListProgRef()
    {
	return listProgRef;
    }

    public void setInvstAccCY(BigDecimal invstAccCY)
    {
        this.invstAccCY = invstAccCY;
    }

    public BigDecimal getInvstAccGL()
    {
        return invstAccGL;
    }

    public void setInvstAccGL(BigDecimal invstAccGL)
    {
        this.invstAccGL = invstAccGL;
    }

    public BigDecimal getInvstAccCIF()
    {
        return invstAccCIF;
    }

    public String getFromDeleteDrawDown()
    {
	return fromDeleteDrawDown;
    }

    public void setInvstAccCIF(BigDecimal invstAccCIF)
    {
        this.invstAccCIF = invstAccCIF;
    }

    public void setFromDeleteDrawDown(String fromDeleteDrawDown)
    {
	this.fromDeleteDrawDown = fromDeleteDrawDown;
    }

    public BigDecimal getInvstAccSL()
    {
        return invstAccSL;
    }


    public void setInvstAccSL(BigDecimal invstAccSL)
    {
        this.invstAccSL = invstAccSL;
    }
    
    public String getMusharaka()
    {
        return musharaka;
    }

    public void setMusharaka(String musharaka)
    {
        this.musharaka = musharaka;
    }

    public String getPtDetailsSign()
    {
        return ptDetailsSign;
    }

    public void setPtDetailsSign(String ptDetailsSign)
    {
        this.ptDetailsSign = ptDetailsSign;
    }

    public String getColRateTitle()
    {
        return colRateTitle;
    }

    public void setColRateTitle(String colRateTitle)
    {
        this.colRateTitle = colRateTitle;
    }
    
    public BigDecimal getOldbalancelimit()
    {
        return oldbalancelimit;
    }

    public void setOldbalancelimit(BigDecimal oldbalancelimit)
    {
        this.oldbalancelimit = oldbalancelimit;
    }

    public String getOldprcdandwarnaction()
    {
        return oldprcdandwarnaction;
    }

    public void setOldprcdandwarnaction(String oldprcdandwarnaction)
    {
        this.oldprcdandwarnaction = oldprcdandwarnaction;
    }

}