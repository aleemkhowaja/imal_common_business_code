package com.path.vo.core.dues;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.common.memo.MemoCO;
import com.path.vo.core.account.AccountCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * DuesManagementSC.java used to
 */
@SuppressWarnings("serial")
public class DuesManagementSC extends GridParamsSC
{
    private String opt;
    
    private BigDecimal debitAccBr;
    private BigDecimal debitAccCy;
    private BigDecimal debitAccGL;
    private BigDecimal debitAccCIF;
    private BigDecimal debitAccSL;

    private String accountName;
    private String additionalRef;
    private String currencyFormat;

    private BigDecimal dueCode;
    private String dueStatus;
    private BigDecimal trsNo;

    private String dueTypeSelected;
    private String paymentMode;
    private String readOnlyPaymentMode;

    private BigDecimal creditAccBr;
    private BigDecimal creditAccCy;
    private BigDecimal creditAccGL;
    private BigDecimal creditAccCIF;
    private BigDecimal creditAccSL;

    private BigDecimal originalAmount;
    private BigDecimal outstandingAmount; /* Remaining amount */
    private BigDecimal settledAmount;
    private BigDecimal denominationAmount;

    private String descriptionEnglish;
    private String descriptionArabic;

    private Date createdDate;
    private Date expiryDate;
    private BigDecimal suspendReasonCode;

    private Integer lineNo;
    private Date actionDate;
    private String action;

    private Integer JVBranch;
    private Integer JVNumber;

    private Integer linkJVBranch;
    private Integer linkJVNumber;

    private boolean saveEnabled;
    private boolean approveEnabled;
    private boolean updateAfterApproveMode;
    private boolean amendDueEnabled;
    private boolean deleteDueEnabled;
    private boolean suspendReasonEnabled;
    private boolean applyToReverseEnabled;
    private boolean approveReverseEnabled;
    private boolean collectDuesEnabled;
    private boolean reactivateEnabled;
    private boolean alertEnabled;
    private boolean denominationEnabled;

    private String alertStatus;
    private BigDecimal errorCode;
    private String errorMessage;
    private String printExceptionTrace;

    private String invoker;/* process originator */
    private int counter;
    private Integer lineCount;

    private Integer trxType;
    private Date trxCreatedDate;

    private String autoDenom;
    
    //John Massaad
    private String langCode;
    
    //This flag is used to enable to retrieve the dues list by statuses provided when it is set to true
    private String retrieveDuesByStatus;
    
    private BigDecimal exemptReasonCode;
    private BigDecimal exemptedAmount;
    private BigDecimal totalExemptedAmount;
    private String oldStatus;
    
    //PATH130194
    private BigDecimal tellerCode;
    private String fromAlert;

    private String allowCifCreationMaskYN;
    
    // Added by nancy - 31/01/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    private BigDecimal trxBranch;
    private BigDecimal activeWidrawalAmount;
    private BigDecimal postDatedWidrawalBal;
    private BigDecimal postDatedDepositBal;
    private BigDecimal settlementBal;
    // end nancy
    
    //habib accocunt restriction 372747
    private String pageRef;
    private String errType;
    private String errMsg;
    private BigDecimal rtrnVal;
    private BigDecimal errCode;
    private boolean checkNbRec;
    private int nbRecords;
    private List<AccountCO> listRecords = new ArrayList<>();
    
    private BigDecimal originalAmountCV;
    private BigDecimal originalVATAmountCV;
    private BigDecimal originalVATAmountFC;
    
    private BigDecimal creditVATAccBr;
    private BigDecimal creditVATAccCy;
    private BigDecimal creditVATAccGL;
    private BigDecimal creditVATAccCIF;
    private BigDecimal creditVATAccSL;
    private String isFromAlert;
    private BigDecimal chargeCode;
    private BigDecimal chargeCvAmount;
    private BigDecimal chargeFcAmount;
    private BigDecimal vatCvAmount;
    private BigDecimal vatFcAmount;
    private BigDecimal vatCode;
    
    public String getFromAlert()
    {
        return fromAlert;
    }
    public void setFromAlert(String fromAlert)
    {
        this.fromAlert = fromAlert;
    }

    public String getIsFromAlert()
    {
	return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
	this.isFromAlert = isFromAlert;
    }

    public void setDebitAccBr(BigDecimal debitAccBr)
    {
	this.debitAccBr = debitAccBr;
    }
    public BigDecimal getDebitAccBr()
    {
	return debitAccBr;
    }

    public BigDecimal getDebitAccCy()
    {
	return debitAccCy;
    }

    public void setDebitAccCy(BigDecimal debitAccCy)
    {
	this.debitAccCy = debitAccCy;
    }

    public BigDecimal getDebitAccGL()
    {
	return debitAccGL;
    }

    public void setDebitAccGL(BigDecimal debitAccGL)
    {
	this.debitAccGL = debitAccGL;
    }

    public BigDecimal getDebitAccCIF()
    {
	return debitAccCIF;
    }

    public void setDebitAccCIF(BigDecimal debitAccCIF)
    {
	this.debitAccCIF = debitAccCIF;
    }

    public BigDecimal getDebitAccSL()
    {
	return debitAccSL;
    }

    public void setDebitAccSL(BigDecimal debitAccSL)
    {
	this.debitAccSL = debitAccSL;
    }

    public void setDueCode(BigDecimal dueCode)
    {
	this.dueCode = dueCode;
    }

    public BigDecimal getDueCode()
    {
	return dueCode;
    }

    public void setDueTypeSelected(String dueTypeSelected)
    {
	this.dueTypeSelected = dueTypeSelected;
    }

    public String getDueTypeSelected()
    {
	return dueTypeSelected;
    }

    public void setPaymentMode(String paymentMode)
    {
	this.paymentMode = paymentMode;
    }

    public String getPaymentMode()
    {
	return paymentMode;
    }

    public void setReadOnlyPaymentMode(String readOnlyPaymentMode)
    {
	this.readOnlyPaymentMode = readOnlyPaymentMode;
    }

    public String getReadOnlyPaymentMode()
    {
	return readOnlyPaymentMode;
    }

    public void setLineNo(Integer lineNo)
    {
	this.lineNo = lineNo;
    }

    public Integer getLineNo()
    {
	return lineNo;
    }

    public void setActionDate(Date actionDate)
    {
	if(null != actionDate)
	{
	    this.actionDate = (Date) actionDate.clone();
	}
    }

    public Date getActionDate()
    {
	return (Date) ((null == actionDate) ? null : actionDate.clone());
    }

    public void setAction(String action)
    {
	this.action = action;
    }

    public String getAction()
    {
	return action;
    }

    public void setJVBranch(Integer jVBranch)
    {
	JVBranch = jVBranch;
    }

    public Integer getJVBranch()
    {
	return JVBranch;
    }

    public void setJVNumber(Integer jVNumber)
    {
	JVNumber = jVNumber;
    }

    public Integer getJVNumber()
    {
	return JVNumber;
    }

    public void setLinkJVBranch(Integer linkJVBranch)
    {
	this.linkJVBranch = linkJVBranch;
    }

    public Integer getLinkJVBranch()
    {
	return linkJVBranch;
    }

    public void setLinkJVNumber(Integer linkJVNumber)
    {
	this.linkJVNumber = linkJVNumber;
    }

    public Integer getLinkJVNumber()
    {
	return linkJVNumber;
    }

    public void setSaveEnabled(boolean saveEnabled)
    {
	this.saveEnabled = saveEnabled;
    }

    public boolean isSaveEnabled()
    {
	return saveEnabled;
    }

    public void setApproveEnabled(boolean approveEnabled)
    {
	this.approveEnabled = approveEnabled;
    }

    public boolean isApproveEnabled()
    {
	return approveEnabled;
    }

    public void setUpdateAfterApproveMode(boolean updateAfterApproveMode)
    {
	this.updateAfterApproveMode = updateAfterApproveMode;
    }

    public boolean isUpdateAfterApproveMode()
    {
	return updateAfterApproveMode;
    }

    public void setAmendDueEnabled(boolean amendDueEnabled)
    {
	this.amendDueEnabled = amendDueEnabled;
    }

    public boolean isAmendDueEnabled()
    {
	return amendDueEnabled;
    }

    public void setDeleteDueEnabled(boolean deleteDueEnabled)
    {
	this.deleteDueEnabled = deleteDueEnabled;
    }

    public boolean isDeleteDueEnabled()
    {
	return deleteDueEnabled;
    }

    public void setSuspendReasonEnabled(boolean suspendReasonEnabled)
    {
	this.suspendReasonEnabled = suspendReasonEnabled;
    }

    public boolean isSuspendReasonEnabled()
    {
	return suspendReasonEnabled;
    }

    public void setApplyToReverseEnabled(boolean applyToReverseEnabled)
    {
	this.applyToReverseEnabled = applyToReverseEnabled;
    }

    public boolean isApplyToReverseEnabled()
    {
	return applyToReverseEnabled;
    }

    public void setApproveReverseEnabled(boolean approveReverseEnabled)
    {
	this.approveReverseEnabled = approveReverseEnabled;
    }

    public boolean isApproveReverseEnabled()
    {
	return approveReverseEnabled;
    }

    public void setCollectDuesEnabled(boolean collectDuesEnabled)
    {
	this.collectDuesEnabled = collectDuesEnabled;
    }

    public boolean isCollectDuesEnabled()
    {
	return collectDuesEnabled;
    }

    public void setReactivateEnabled(boolean reactivateEnabled)
    {
	this.reactivateEnabled = reactivateEnabled;
    }

    public boolean isReactivateEnabled()
    {
	return reactivateEnabled;
    }

    public void setAlertEnabled(boolean alertEnabled)
    {
	this.alertEnabled = alertEnabled;
    }

    public boolean isAlertEnabled()
    {
	return alertEnabled;
    }

    public void setDenominationEnabled(boolean denominationEnabled)
    {
	this.denominationEnabled = denominationEnabled;
    }

    public boolean isDenominationEnabled()
    {
	return denominationEnabled;
    }

    public void setAlertStatus(String alertStatus)
    {
	this.alertStatus = alertStatus;
    }

    public String getAlertStatus()
    {
	return alertStatus;
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

    public void setInvoker(String invoker)
    {
	this.invoker = invoker;
    }

    public String getInvoker()
    {
	return invoker;
    }

    public String getDueStatus()
    {
	return dueStatus;
    }

    public void setDueStatus(String dueStatus)
    {
	this.dueStatus = dueStatus;
    }

    public void setCounter(int counter)
    {
	this.counter = counter;
    }

    public int getCounter()
    {
	return counter;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }

    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setOriginalAmount(BigDecimal originalAmount)
    {
	this.originalAmount = originalAmount;
    }

    public BigDecimal getOriginalAmount()
    {
	return originalAmount;
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount)
    {
	this.outstandingAmount = outstandingAmount;
    }

    public BigDecimal getOutstandingAmount()
    {
	return outstandingAmount;
    }

    public void setSettledAmount(BigDecimal settledAmount)
    {
	this.settledAmount = settledAmount;
    }

    public BigDecimal getSettledAmount()
    {
	return settledAmount;
    }

    public void setDescriptionEnglish(String descriptionEnglish)
    {
	this.descriptionEnglish = descriptionEnglish;
    }

    public String getDescriptionEnglish()
    {
	return descriptionEnglish;
    }

    public void setDescriptionArabic(String descriptionArabic)
    {
	this.descriptionArabic = descriptionArabic;
    }

    public String getDescriptionArabic()
    {
	return descriptionArabic;
    }

    public void setCreatedDate(Date createdDate)
    {
	this.createdDate = createdDate;
    }

    public Date getCreatedDate()
    {
	return createdDate;
    }

    public void setExpiryDate(Date expiryDate)
    {
	this.expiryDate = expiryDate;
    }

    public Date getExpiryDate()
    {
	return expiryDate;
    }

    public void setSuspendReasonCode(BigDecimal suspendReasonCode)
    {
	this.suspendReasonCode = suspendReasonCode;
    }

    public BigDecimal getSuspendReasonCode()
    {
	return suspendReasonCode;
    }

    public void setTrxType(Integer trxType)
    {
	this.trxType = trxType;
    }

    public Integer getTrxType()
    {
	return trxType;
    }

    public void setTrxCreatedDate(Date trxCreatedDate)
    {
	this.trxCreatedDate = trxCreatedDate;
    }

    public Date getTrxCreatedDate()
    {
	return trxCreatedDate;
    }

    public BigDecimal getDenominationAmount()
    {
	return denominationAmount;
    }

    public void setDenominationAmount(BigDecimal denominationAmount)
    {
	this.denominationAmount = denominationAmount;
    }

    public BigDecimal getCreditAccBr()
    {
	return creditAccBr;
    }

    public void setCreditAccBr(BigDecimal creditAccBr)
    {
	this.creditAccBr = creditAccBr;
    }

    public BigDecimal getCreditAccCy()
    {
	return creditAccCy;
    }

    public void setCreditAccCy(BigDecimal creditAccCy)
    {
	this.creditAccCy = creditAccCy;
    }

    public BigDecimal getCreditAccGL()
    {
	return creditAccGL;
    }

    public void setCreditAccGL(BigDecimal creditAccGL)
    {
	this.creditAccGL = creditAccGL;
    }

    public BigDecimal getCreditAccCIF()
    {
	return creditAccCIF;
    }

    public void setCreditAccCIF(BigDecimal creditAccCIF)
    {
	this.creditAccCIF = creditAccCIF;
    }

    public BigDecimal getCreditAccSL()
    {
	return creditAccSL;
    }

    public void setCreditAccSL(BigDecimal creditAccSL)
    {
	this.creditAccSL = creditAccSL;
    }

    public void setLineCount(Integer lineCount)
    {
	this.lineCount = lineCount;
    }

    public Integer getLineCount()
    {
	return lineCount;
    }

    public void setCurrencyFormat(String currencyFormat)
    {
	this.currencyFormat = currencyFormat;
    }

    public String getCurrencyFormat()
    {
	return currencyFormat;
    }

    public void setAccountName(String accountName)
    {
	this.accountName = accountName;
    }

    public String getAccountName()
    {
	return accountName;
    }

    public void setAdditionalRef(String additionalRef)
    {
	this.additionalRef = additionalRef;
    }

    public String getAdditionalRef()
    {
	return additionalRef;
    }

    public void setAutoDenom(String autoDenom)
    {
	this.autoDenom = autoDenom;
    }

    public String getAutoDenom()
    {
	return autoDenom;
    }

    public void setOpt(String opt)
    {
	this.opt = opt;
    }

    public String getOpt()
    {
	return opt;
    }

    public void setPrintExceptionTrace(String printExceptionTrace)
    {
	this.printExceptionTrace = printExceptionTrace;
    }

    public String getPrintExceptionTrace()
    {
	return printExceptionTrace;
    }


    public String getLangCode()
    {
        return langCode;
    }

    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
    public String getRetrieveDuesByStatus()
    {
        return retrieveDuesByStatus;
    }
    public void setRetrieveDuesByStatus(String retrieveDuesByStatus)
    {
        this.retrieveDuesByStatus = retrieveDuesByStatus;
    }
    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }
    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }
    // Added by nancy - 31/01/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    public BigDecimal getTrxBranch()
    {
        return trxBranch;
    }
    public void setTrxBranch(BigDecimal trxBranch)
    {
        this.trxBranch = trxBranch;
    }
    public BigDecimal getActiveWidrawalAmount()
    {
        return activeWidrawalAmount;
    }
    public void setActiveWidrawalAmount(BigDecimal activeWidrawalAmount)
    {
        this.activeWidrawalAmount = activeWidrawalAmount;
    }
    public BigDecimal getPostDatedWidrawalBal()
    {
        return postDatedWidrawalBal;
    }
    public void setPostDatedWidrawalBal(BigDecimal postDatedWidrawalBal)
    {
        this.postDatedWidrawalBal = postDatedWidrawalBal;
    }
    public BigDecimal getPostDatedDepositBal()
    {
        return postDatedDepositBal;
    }
    public void setPostDatedDepositBal(BigDecimal postDatedDepositBal)
    {
        this.postDatedDepositBal = postDatedDepositBal;
    }
    public BigDecimal getSettlementBal()
    {
        return settlementBal;
    }
    public void setSettlementBal(BigDecimal settlementBal)
    {
        this.settlementBal = settlementBal;
    }
   
    // end nancy 
    public BigDecimal getExemptReasonCode()
    {
        return exemptReasonCode;
    }
    public void setExemptReasonCode(BigDecimal exemptReasonCode)
    {
        this.exemptReasonCode = exemptReasonCode;
    }
    public BigDecimal getExemptedAmount()
    {
        return exemptedAmount;
    }
    public void setExemptedAmount(BigDecimal exemptedAmount)
    {
        this.exemptedAmount = exemptedAmount;
    }
    public BigDecimal getTotalExemptedAmount()
    {
        return totalExemptedAmount;
    }
    public void setTotalExemptedAmount(BigDecimal totalExemptedAmount)
    {
        this.totalExemptedAmount = totalExemptedAmount;
    }
    public String getOldStatus()
    {
        return oldStatus;
    }
    public void setOldStatus(String oldStatus)
    {
        this.oldStatus = oldStatus;
    }
    public BigDecimal getTellerCode()
    {
        return tellerCode;
    }
    public void setTellerCode(BigDecimal tellerCode)
    {
        this.tellerCode = tellerCode;
    }
	
	public String getPageRef()
	{
		return pageRef;
	}
	
	public void setPageRef(String pageRef)
	{
		this.pageRef = pageRef;
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
	
	public int getNbRecords()
	{
		return nbRecords;
	}
	
	public void setNbRecords(int nbRecords)
	{
		this.nbRecords = nbRecords;
	}
	
	public List<AccountCO> getListRecords()
	{
		return listRecords;
	}
	
	public void setListRecords(List<AccountCO> listRecords)
	{
		this.listRecords = listRecords;
	}

    public BigDecimal getOriginalAmountCV()
    {
        return originalAmountCV;
    }
    public void setOriginalAmountCV(BigDecimal originalAmountCV)
    {
        this.originalAmountCV = originalAmountCV;
    }
    public BigDecimal getOriginalVATAmountCV()
    {
        return originalVATAmountCV;
    }
    public void setOriginalVATAmountCV(BigDecimal originalVATAmountCV)
    {
        this.originalVATAmountCV = originalVATAmountCV;
    }
    public BigDecimal getOriginalVATAmountFC()
    {
        return originalVATAmountFC;
    }
    public void setOriginalVATAmountFC(BigDecimal originalVATAmountFC)
    {
        this.originalVATAmountFC = originalVATAmountFC;
    }
    public BigDecimal getCreditVATAccBr()
    {
        return creditVATAccBr;
    }
    public void setCreditVATAccBr(BigDecimal creditVATAccBr)
    {
        this.creditVATAccBr = creditVATAccBr;
    }
    public BigDecimal getCreditVATAccCy()
    {
        return creditVATAccCy;
    }
    public void setCreditVATAccCy(BigDecimal creditVATAccCy)
    {
        this.creditVATAccCy = creditVATAccCy;
    }
    public BigDecimal getCreditVATAccGL()
    {
        return creditVATAccGL;
    }
    public void setCreditVATAccGL(BigDecimal creditVATAccGL)
    {
        this.creditVATAccGL = creditVATAccGL;
    }
    public BigDecimal getCreditVATAccCIF()
    {
        return creditVATAccCIF;
    }
    public void setCreditVATAccCIF(BigDecimal creditVATAccCIF)
    {
        this.creditVATAccCIF = creditVATAccCIF;
    }
    public BigDecimal getCreditVATAccSL()
    {
        return creditVATAccSL;
    }
    public void setCreditVATAccSL(BigDecimal creditVATAccSL)
    {
        this.creditVATAccSL = creditVATAccSL;
    }

    public BigDecimal getChargeCode()
    {
        return chargeCode;
    }
    public void setChargeCode(BigDecimal chargeCode)
    {
        this.chargeCode = chargeCode;
    }
    public BigDecimal getVatCode()
    {
        return vatCode;
    }
    public void setVatCode(BigDecimal vatCode)
    {
        this.vatCode = vatCode;
    }
    public BigDecimal getChargeCvAmount()
    {
        return chargeCvAmount;
    }
    public void setChargeCvAmount(BigDecimal chargeCvAmount)
    {
        this.chargeCvAmount = chargeCvAmount;
    }
    public BigDecimal getChargeFcAmount()
    {
        return chargeFcAmount;
    }
    public void setChargeFcAmount(BigDecimal chargeFcAmount)
    {
        this.chargeFcAmount = chargeFcAmount;
    }
    public BigDecimal getVatCvAmount()
    {
        return vatCvAmount;
    }
    public void setVatCvAmount(BigDecimal vatCvAmount)
    {
        this.vatCvAmount = vatCvAmount;
    }
    public BigDecimal getVatFcAmount()
    {
        return vatFcAmount;
    }
    public void setVatFcAmount(BigDecimal vatFcAmount)
    {
        this.vatFcAmount = vatFcAmount;
    }    
}
