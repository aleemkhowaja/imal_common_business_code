package com.path.vo.core.chequebook;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_LINKACCVO;
import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: WissamChebli
 * 
 *          ChequeBookSC.java used to
 */
public class ChequeBookSC extends GridParamsSC
{
    private BigDecimal CODE;
    private BigDecimal linkSerial;
    private BigDecimal ACC_BR;
    private BigDecimal ACC_CY;
    private BigDecimal ACC_GL;
    private BigDecimal ACC_CIF;
    private BigDecimal ACC_SL;
    private BigDecimal PREVIOUSNBR;
    private BigDecimal CHQBOOK_NUM;
    private String SELECTED_ACC;
    private String status;
    private String type;
    private Date runningDate;
    private Date fromDate;
    private Date toDate;
    private BigDecimal destBranchCode;
    private String printingLocation;
    private String urgent;
    private String batchNo;
    private String userName;
    private String operation;
    private BigDecimal toNumber;
    private BigDecimal fromNumber;
    private String process;
    private BigDecimal processId;
    private String lang;
    private String userLang;
    private String ivCrud;
    private BigDecimal errorCode;
    private String errorMessage;
    private String addReference;
    private String chqType;
    private String userType;
    private BigDecimal deliveryMode;
    private int year;
    private int month;
    private BigDecimal lovType;
    private String progRef;
    private String appName;
    private String all;
    private BigDecimal chequeCode;
    private BigDecimal loginBranchCode;
    private String normalUrgent;
    private String BS_CONTRA;
    private String GMI_FLAG;
    private String affectPassChq;
    private String cifType;
    private BigDecimal currencyCode;
    private BigDecimal cif_no;
    private BigDecimal glCode;
    private String CHQ_UNIQUE;
    private String glType;
    private String ACCEPT_INTRN_CHQ;
    private BigDecimal baseCurrencyCode;
    private String FORBID_OTHER_BR_CHQ;
    private String CHQBOOK_PROCESS; // is_chqbook_status
    private int portal;
    private BigDecimal trsNo;
    private BigDecimal chequeType;
    private BigDecimal cifTypeNo;
    private BigDecimal leaves;
    private BigDecimal cheqbookType;
    private BigDecimal defaultBranch;
    private BigDecimal lcNbr;
    private BigDecimal remittType;
    private BigDecimal trxTypeRemittType;
    private BigDecimal trxCy;
    private String paymentMethod;
    private int checkTrx;
    private BigDecimal trxType;
    private String docType;
    private BigDecimal isBills;
    
    private BigDecimal fromCy;
    private String retrieveChqBookStatusBy;
    private String cardReaderCivilID; //BMOI130009 
    private String cardReaderCardSerial;
    
    private String parentRef; //Hasan BMO160011 25/01/2016
    private String allowCifCreationMaskYN;
    private String applyChqPrintThirdPartyYN; // Added by nancy -- 15/05/2018--FIBSI170009
    private String screenName;
    
    private BigDecimal scannedCif;
    
    //Habib Baalbaki accocunt restriction 372747
    private String pageRef;
    private String errType;
    private String errMsg;
    private BigDecimal rtrnVal;
    private BigDecimal errCode;
    private boolean checkNbRec;
    private int trxMgntNbRecords;
    private List<ChequeBookCO> accountListRecords = new ArrayList<>();
    private List<CTSCHEQUEBOOK_LINKACCVO> chqBookLinkList =new ArrayList<>();
    
    //Rania - IIAB120019 - Cancelling Customer Cheques    
    private String buttonName;
    private BigDecimal cancelReason;
    private String cancelReasonDesc;
    private BigDecimal bulkBatchNo;
    private String isFromAlert;
    //
    
    private BigDecimal bulkDestoryPeriod; //Rania - BMO180068 - Changes regarding chq book and related processing
	
	//added by maria for BMO180276
    private Date idExpiryDate;
    
    
    
    public String getParentRef()
    {
        return parentRef;
    }

    public void setParentRef(String parentRef)
    {
        this.parentRef = parentRef;
    }
    
    /**
     * @return the linkSerial
     */
    public BigDecimal getLinkSerial()
    {
        return linkSerial;
    }

    /**
     * @param linkSerial the linkSerial to set
     */
    public void setLinkSerial(BigDecimal linkSerial)
    {
        this.linkSerial = linkSerial;
    }

    /**
     * @return the cODE
     */
    public BigDecimal getCODE()
    {
        return CODE;
    }

    /**
     * @param cODE the cODE to set
     */
    public void setCODE(BigDecimal cODE)
    {
        CODE = cODE;
    }

    /**
     * @return the aCC_BR
     */
    public BigDecimal getACC_BR()
    {
        return ACC_BR;
    }

    /**
     * @param aCCBR the aCC_BR to set
     */
    public void setACC_BR(BigDecimal aCCBR)
    {
        ACC_BR = aCCBR;
    }

    /**
     * @return the aCC_CY
     */
    public BigDecimal getACC_CY()
    {
        return ACC_CY;
    }

    /**
     * @param aCCCY the aCC_CY to set
     */
    public void setACC_CY(BigDecimal aCCCY)
    {
        ACC_CY = aCCCY;
    }

    /**
     * @return the aCC_GL
     */
    public BigDecimal getACC_GL()
    {
        return ACC_GL;
    }

    /**
     * @param aCCGL the aCC_GL to set
     */
    public void setACC_GL(BigDecimal aCCGL)
    {
        ACC_GL = aCCGL;
    }

    /**
     * @return the aCC_CIF
     */
    public BigDecimal getACC_CIF()
    {
        return ACC_CIF;
    }

    /**
     * @param aCCCIF the aCC_CIF to set
     */
    public void setACC_CIF(BigDecimal aCCCIF)
    {
        ACC_CIF = aCCCIF;
    }

    /**
     * @return the aCC_SL
     */
    public BigDecimal getACC_SL()
    {
        return ACC_SL;
    }

    /**
     * @param aCCSL the aCC_SL to set
     */
    public void setACC_SL(BigDecimal aCCSL)
    {
        ACC_SL = aCCSL;
    }

    /**
     * @return the pREVIOUSNBR
     */
    public BigDecimal getPREVIOUSNBR()
    {
        return PREVIOUSNBR;
    }

    /**
     * @param pREVIOUSNBR the pREVIOUSNBR to set
     */
    public void setPREVIOUSNBR(BigDecimal pREVIOUSNBR)
    {
        PREVIOUSNBR = pREVIOUSNBR;
    }

    /**
     * @return the cHQBOOK_NUM
     */
    public BigDecimal getCHQBOOK_NUM()
    {
        return CHQBOOK_NUM;
    }

    /**
     * @param cHQBOOKNUM the cHQBOOK_NUM to set
     */
    public void setCHQBOOK_NUM(BigDecimal cHQBOOKNUM)
    {
        CHQBOOK_NUM = cHQBOOKNUM;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * @return the runningDate
     */
    public Date getRunningDate()
    {
        return runningDate;
    }

    /**
     * @param runningDate the runningDate to set
     */
    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * @return the toNumber
     */
    public BigDecimal getToNumber()
    {
        return toNumber;
    }

    /**
     * @param toNumber the toNumber to set
     */
    public void setToNumber(BigDecimal toNumber)
    {
        this.toNumber = toNumber;
    }

    /**
     * @return the fromNumber
     */
    public BigDecimal getFromNumber()
    {
        return fromNumber;
    }

    /**
     * @param fromNumber the fromNumber to set
     */
    public void setFromNumber(BigDecimal fromNumber)
    {
        this.fromNumber = fromNumber;
    }

    /**
     * @return the process
     */
    public String getProcess()
    {
        return process;
    }

    /**
     * @param process the process to set
     */
    public void setProcess(String process)
    {
        this.process = process;
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

    /**
     * @return the errorCode
     */
    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage()
    {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the addReference
     */
    public String getAddReference()
    {
        return addReference;
    }

    /**
     * @param addReference the addReference to set
     */
    public void setAddReference(String addReference)
    {
        this.addReference = addReference;
    }

    /**
     * @return the chqType
     */
    public String getChqType()
    {
        return chqType;
    }

    /**
     * @param chqType the chqType to set
     */
    public void setChqType(String chqType)
    {
        this.chqType = chqType;
    }

    /**
     * @return the userType
     */
    public String getUserType()
    {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    /**
     * @return the deliveryMode
     */
    public BigDecimal getDeliveryMode()
    {
        return deliveryMode;
    }

    /**
     * @param deliveryMode the deliveryMode to set
     */
    public void setDeliveryMode(BigDecimal deliveryMode)
    {
        this.deliveryMode = deliveryMode;
    }

    /**
     * @return the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * @return the month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month)
    {
        this.month = month;
    }

    /**
     * getLovType.
     * 
     * @return lovType.
     */
    public BigDecimal getLovType()
    {
        return lovType;
    }

    /**
     * setLovType.
     * 
     * @param lovType
     */
    public void setLovType(BigDecimal lovType)
    {
        this.lovType = lovType;
    }

    public String getProgRef()
    {
        return progRef;
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public Date getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public Date getToDate()
    {
        return toDate;
    }

    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }

    public BigDecimal getDestBranchCode()
    {
        return destBranchCode;
    }

    public void setDestBranchCode(BigDecimal destBranchCode)
    {
        this.destBranchCode = destBranchCode;
    }

    public String getPrintingLocation()
    {
        return printingLocation;
    }

    public void setPrintingLocation(String printingLocation)
    {
        this.printingLocation = printingLocation;
    }

    public String getUrgent()
    {
        return urgent;
    }

    public void setUrgent(String urgent)
    {
        this.urgent = urgent;
    }

    public String getBatchNo()
    {
        return batchNo;
    }

    public void setBatchNo(String batchNo)
    {
        this.batchNo = batchNo;
    }

    public String getAll()
    {
        return all;
    }

    public void setAll(String all)
    {
        this.all = all;
    }

    public BigDecimal getChequeCode()
    {
        return chequeCode;
    }

    public void setChequeCode(BigDecimal chequeCode)
    {
        this.chequeCode = chequeCode;
    }

    public String getNormalUrgent()
    {
        return normalUrgent;
    }

    public void setNormalUrgent(String normalUrgent)
    {
        this.normalUrgent = normalUrgent;
    }

    public String getBS_CONTRA()
    {
        return BS_CONTRA;
    }

    public void setBS_CONTRA(String bSCONTRA)
    {
        BS_CONTRA = bSCONTRA;
    }

    public BigDecimal getGlCode()
    {
        return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
        this.glCode = glCode;
    }

    public String getCHQ_UNIQUE()
    {
        return CHQ_UNIQUE;
    }

    public void setCHQ_UNIQUE(String cHQUNIQUE)
    {
        CHQ_UNIQUE = cHQUNIQUE;
    }

    public String getGlType()
    {
        return glType;
    }

    public void setGlType(String glType)
    {
        this.glType = glType;
    }

    public String getACCEPT_INTRN_CHQ()
    {
        return ACCEPT_INTRN_CHQ;
    }

    public void setACCEPT_INTRN_CHQ(String aCCEPTINTRNCHQ)
    {
        ACCEPT_INTRN_CHQ = aCCEPTINTRNCHQ;
    }

    public BigDecimal getBaseCurrencyCode()
    {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(BigDecimal baseCurrencyCode)
    {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public BigDecimal getLoginBranchCode()
    {
        return loginBranchCode;
    }

    public void setLoginBranchCode(BigDecimal loginBranchCode)
    {
        this.loginBranchCode = loginBranchCode;
    }

    public String getFORBID_OTHER_BR_CHQ()
    {
        return FORBID_OTHER_BR_CHQ;
    }

    public void setFORBID_OTHER_BR_CHQ(String fORBIDOTHERBRCHQ)
    {
        FORBID_OTHER_BR_CHQ = fORBIDOTHERBRCHQ;
    }

    public String getIvCrud()
    {
        return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
        this.ivCrud = ivCrud;
    }

    public String getCHQBOOK_PROCESS()
    {
        return CHQBOOK_PROCESS;
    }

    public void setCHQBOOK_PROCESS(String cHQBOOKPROCESS)
    {
        CHQBOOK_PROCESS = cHQBOOKPROCESS;
    }

    public String getGMI_FLAG()
    {
        return GMI_FLAG;
    }

    public void setGMI_FLAG(String gMIFLAG)
    {
        GMI_FLAG = gMIFLAG;
    }

    public String getAffectPassChq()
    {
        return affectPassChq;
    }

    public void setAffectPassChq(String affectPassChq)
    {
        this.affectPassChq = affectPassChq;
    }

    public String getCifType()
    {
        return cifType;
    }

    public void setCifType(String cifType)
    {
        this.cifType = cifType;
    }

    public BigDecimal getCurrencyCode()
    {
        return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getCif_no()
    {
        return cif_no;
    }

    public void setCif_no(BigDecimal cifNo)
    {
        cif_no = cifNo;
    }

    public int getPortal()
    {
        return portal;
    }

    public void setPortal(int portal)
    {
        this.portal = portal;
    }

    public String getSELECTED_ACC()
    {
        return SELECTED_ACC;
    }

    public void setSELECTED_ACC(String sELECTEDACC)
    {
        SELECTED_ACC = sELECTEDACC;
    }

    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public BigDecimal getChequeType()
    {
        return chequeType;
    }

    public void setChequeType(BigDecimal chequeType)
    {
        this.chequeType = chequeType;
    }

    public BigDecimal getCifTypeNo()
    {
        return cifTypeNo;
    }

    public void setCifTypeNo(BigDecimal cifTypeNo)
    {
        this.cifTypeNo = cifTypeNo;
    }

    public BigDecimal getLeaves()
    {
        return leaves;
    }

    public void setLeaves(BigDecimal leaves)
    {
        this.leaves = leaves;
    }

    public BigDecimal getCheqbookType()
    {
        return cheqbookType;
    }

    public void setCheqbookType(BigDecimal cheqbookType)
    {
        this.cheqbookType = cheqbookType;
    }

    public BigDecimal getProcessId()
    {
        return processId;
    }

    public void setProcessId(BigDecimal processId)
    {
        this.processId = processId;
    }

    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    /**
     * @return the defaultBranch
     */
    public BigDecimal getDefaultBranch()
    {
        return defaultBranch;
    }

    /**
     * @param defaultBranch the defaultBranch to set
     */
    public void setDefaultBranch(BigDecimal defaultBranch)
    {
        this.defaultBranch = defaultBranch;
    }

    /**
     * @return the lcNbr
     */
    public BigDecimal getLcNbr()
    {
        return lcNbr;
    }

    /**
     * @param lcNbr the lcNbr to set
     */
    public void setLcNbr(BigDecimal lcNbr)
    {
        this.lcNbr = lcNbr;
    }

    /**
     * @return the remittType
     */
    public BigDecimal getRemittType()
    {
        return remittType;
    }

    /**
     * @param remittType the remittType to set
     */
    public void setRemittType(BigDecimal remittType)
    {
        this.remittType = remittType;
    }

    /**
     * @return the trxTypeRemittType
     */
    public BigDecimal getTrxTypeRemittType()
    {
        return trxTypeRemittType;
    }

    /**
     * @param trxTypeRemittType the trxTypeRemittType to set
     */
    public void setTrxTypeRemittType(BigDecimal trxTypeRemittType)
    {
        this.trxTypeRemittType = trxTypeRemittType;
    }

    /**
     * @return the trxCy
     */
    public BigDecimal getTrxCy()
    {
        return trxCy;
    }

    /**
     * @param trxCy the trxCy to set
     */
    public void setTrxCy(BigDecimal trxCy)
    {
        this.trxCy = trxCy;
    }

    /**
     * @return the paymentMethod
     */
    public String getPaymentMethod()
    {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    /**
     * @return the checkTrx
     */
    public int getCheckTrx()
    {
        return checkTrx;
    }

    /**
     * @param checkTrx the checkTrx to set
     */
    public void setCheckTrx(int checkTrx)
    {
        this.checkTrx = checkTrx;
    }

    /**
     * @return the trxType
     */
    public BigDecimal getTrxType()
    {
        return trxType;
    }

    /**
     * @param trxType the trxType to set
     */
    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    /**
     * @return the docType
     */
    public String getDocType()
    {
        return docType;
    }

    /**
     * @param docType the docType to set
     */
    public void setDocType(String docType)
    {
        this.docType = docType;
    }

    public BigDecimal getFromCy()
    {
        return fromCy;
    }

    public void setFromCy(BigDecimal fromCy)
    {
        this.fromCy = fromCy;
    }

    public String getUserLang()
    {
        return userLang;
    }

    public void setUserLang(String userLang)
    {
        this.userLang = userLang;
    }

    public String getRetrieveChqBookStatusBy()
    {
        return retrieveChqBookStatusBy;
    }

    public void setRetrieveChqBookStatusBy(String retrieveChqBookStatusBy)
    {
        this.retrieveChqBookStatusBy = retrieveChqBookStatusBy;
    }

    public String getScreenName()
    {
        return screenName;
    }

    public void setScreenName(String screenName)
    {
        this.screenName = screenName;
    }

    public BigDecimal getScannedCif()
    {
        return scannedCif;
    }

    public void setScannedCif(BigDecimal scannedCif)
    {
        this.scannedCif = scannedCif;
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

    public List<ChequeBookCO> getAccountListRecords()
    {
        return accountListRecords;
    }

    public void setAccountListRecords(List<ChequeBookCO> accountListRecords)
    {
        this.accountListRecords = accountListRecords;
    }

    public String getPageRef()
    {
        return pageRef;
    }

    public void setPageRef(String pageRef)
    {
        this.pageRef = pageRef;
    }

    public List<CTSCHEQUEBOOK_LINKACCVO> getChqBookLinkList()
    {
        return chqBookLinkList;
    }

    public void setChqBookLinkList(List<CTSCHEQUEBOOK_LINKACCVO> chqBookLinkList)
    {
        this.chqBookLinkList = chqBookLinkList;
    }

    public String getButtonName()
    {
        return buttonName;
    }

    public void setButtonName(String buttonName)
    {
        this.buttonName = buttonName;
    }

    public BigDecimal getCancelReason()
    {
        return cancelReason;
    }

    public void setCancelReason(BigDecimal cancelReason)
    {
        this.cancelReason = cancelReason;
    }

    public String getCancelReasonDesc()
    {
        return cancelReasonDesc;
    }

    public void setCancelReasonDesc(String cancelReasonDesc)
    {
        this.cancelReasonDesc = cancelReasonDesc;
    }

    public BigDecimal getBulkBatchNo()
    {
        return bulkBatchNo;
    }

    public void setBulkBatchNo(BigDecimal bulkBatchNo)
    {
        this.bulkBatchNo = bulkBatchNo;
    }

    public String getIsFromAlert()
    {
        return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
        this.isFromAlert = isFromAlert;
    }
    public String getCardReaderCivilID()
    {
        return cardReaderCivilID;
    }

    public void setCardReaderCivilID(String cardReaderCivilID)
    {
        this.cardReaderCivilID = cardReaderCivilID;
    }

    public String getCardReaderCardSerial()
    {
        return cardReaderCardSerial;
    }

    public void setCardReaderCardSerial(String cardReaderCardSerial)
    {
        this.cardReaderCardSerial = cardReaderCardSerial;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }
    
    public BigDecimal getIsBills()
    {
        return isBills;
    }

    public void setIsBills(BigDecimal isBills)
    {
        this.isBills = isBills;
    }

    public String getApplyChqPrintThirdPartyYN()
    {
        return applyChqPrintThirdPartyYN;
    }

    public void setApplyChqPrintThirdPartyYN(String applyChqPrintThirdPartyYN)
    {
        this.applyChqPrintThirdPartyYN = applyChqPrintThirdPartyYN;
    }
	public BigDecimal getBulkDestoryPeriod() {
		return bulkDestoryPeriod;
	}

	public void setBulkDestoryPeriod(BigDecimal bulkDestoryPeriod) {
		this.bulkDestoryPeriod = bulkDestoryPeriod;
	}

	public Date getIdExpiryDate() {
		return idExpiryDate;
	}

	public void setIdExpiryDate(Date idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}
}
