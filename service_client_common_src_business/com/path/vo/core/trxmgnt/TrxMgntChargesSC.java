package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

public class TrxMgntChargesSC extends GridParamsSC 
{
    private BigDecimal trsNo;
    private String cashDeductInd;
    private BigDecimal trsCy;
    private BigDecimal trsAcCy;
    private BigDecimal trsAcGl;
    private BigDecimal exchangeRate;
    private String language;
    private BigDecimal lovType;
    private String actionType;
    private String actionReaType;
    private BigDecimal actionLovType;
    private BigDecimal duesLovType;
    private String appName;
    private String progRef;
    private BigDecimal voidReason;
    private BigDecimal serialNo;
    private String relatedSerialNoList;
    private BigDecimal batchNo;
    private BigDecimal fileType;
    private String ivCrud;
    private String trsType;
    private String cb_ind;
    private String productName;
    private String detailProcessStatus;
    private String isUnifiedCharge;
    private String considerOnce;
    private String showSavedCharges;

    private BigDecimal deductAcBr;
    private BigDecimal deductAcCy;
    private BigDecimal deductAcGl;
    private BigDecimal deductAcCif;
    private BigDecimal deductAcSl;
    private String deductAcRef;

    private BigDecimal chargeCode;
    private BigDecimal chargeCy;
    private String chargesBooking;
    private BigDecimal branchBooking;
    private BigDecimal trxAmount;
    private BigDecimal trxType;
    private BigDecimal defaultTrxType;
    private String type;
    private Date date;
    private BigDecimal cvAmount;
    private BigDecimal fcAmount;
    private BigDecimal duesCv;
    private BigDecimal duesFc;
    private BigDecimal glCode;
    private BigDecimal cifCode;
    private BigDecimal slNo;
    private String exceed;
    private BigDecimal exceedAmt;
    private BigDecimal minAmt;
    private BigDecimal tellerCode;
    private BigDecimal maxAmt;
    private BigDecimal chargePercentage;
    private BigDecimal entityCode;
    private BigDecimal leaves;				// Leave code for Chequebooks
    private BigDecimal chequeType;			// type code for Chequebooks
    private String chqIssueType;			// Chequebook Issuance Type (Normal/Urgent)
    private BigDecimal entityTypeCode;			// Entity Type Code
    private BigDecimal error;
    private String errorMessage;
    private String chargeMsg;

    private BigDecimal trsAcCif;
    private BigDecimal trsAcBr;
    private BigDecimal trsAcSl;

    private BigDecimal trsCtrlBr;
    private BigDecimal trsCtrlCy;
    private BigDecimal trsCtrlGL;
    private BigDecimal trsCtrlCif;
    private BigDecimal trsCtrlSL;
    private String trsfrMethod;
    private String screenSrc; // instead of isMultiCHQ we specify the screen source;
    private BigDecimal toTrsAcBr;
    private BigDecimal toTrsAcCy;
    private BigDecimal toTrsAcGl;
    private BigDecimal toTrsAcCif;
    private BigDecimal toTrsAcSl;
    private BigDecimal chAcBr;
    private BigDecimal chAcCy;
    private BigDecimal chAcGl;
    private BigDecimal chAcCif;
    private BigDecimal chAcSl;
    private Boolean suppressMessage = false;		//Used to determine if error message is outputted or not

    private BigDecimal cifNo;			//CIF Number for Charge Schema Select
    private String chargesPolicy;		//Charges Fees Policy for Charge Schema Select
    private String cashAccount;			//Cash Account indicator for Charge Schema Select
    private BigDecimal cifType;
    private String currStatus;
    private String id;
    private BigDecimal schema;
    private BigDecimal destroyCharges;
    private BigDecimal cancelSchema;
    private BigDecimal submitSchema;
    private BigDecimal billType;
    private BigDecimal providerCode;
    private BigDecimal totalAddFeesAmt;
    private BigDecimal benefBank; //Maria for BMO180166
    
    private BigDecimal oldSchema;
    private BigDecimal oldDestroyCharges;
    private BigDecimal oldCancelSchema;
    private BigDecimal oldSubmitSchema;
    
    /*
     * currency exchange parameter
     */
    private BigDecimal cashInCurrencyCode;    
    
    private BigDecimal cashInAmount;    
    
    private BigDecimal cashInAccBr;    
    
    private BigDecimal cashInAccCy;    
    
    private BigDecimal cashInAccGl;    
    
    private BigDecimal cashInAccCif;   
    
    private BigDecimal cashInAccSl;
    
    private BigDecimal cashOutCurrencyCode;    
    
    private BigDecimal cashOutAmount;    
    
    private BigDecimal cashOutAccBr;    
    
    private BigDecimal cashOutAccCy;    
    
    private BigDecimal cashOutAccGl;    
    
    private BigDecimal cashOutAccCif;
    
    private BigDecimal cashOutAccSl;
    
    private String chargesEmpty;
    private String chargesWaived;
    private String crDrForex;
    private String multiTrx;
    private String frmAlert = "false";
    private String baseCyFormat;
    private String fcCyFormat;
    private BigDecimal sessionID;
    private BigDecimal lineNo;
    
    private String trxMgntAccountDtlGridUpdate;
    
    private BigDecimal requestCy;
    private String autoApprove;
    private Date requestDate;
    private BigDecimal amount;
    private BigDecimal totalAmount;
    private BigDecimal ticketNo;
    private String payType;
    
    private BigDecimal releaseDays;
    private BigDecimal linkToOtherTrxNo;
    private String addString;
    private BigDecimal addNumber;
    private Date addDate;
    private String hofReason;
    
    private String acceptIntrnChq;//Hasan Bug#475705 15/03/2017
    
    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public String getIvCrud()
    {
	return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    public String getCashDeductInd()
    {
	return cashDeductInd;
    }

    public void setCashDeductInd(String cashDeductInd)
    {
	this.cashDeductInd = cashDeductInd;
    }

    public BigDecimal getTrsAcCy()
    {
	return trsAcCy;
    }

    public void setTrsAcCy(BigDecimal trsAcCy)
    {
	this.trsAcCy = trsAcCy;
    }

    public BigDecimal getTrsAcGl()
    {
	return trsAcGl;
    }

    public void setTrsAcGl(BigDecimal trsAcGl)
    {
	this.trsAcGl = trsAcGl;
    }

    public BigDecimal getExchangeRate()
    {
	return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate)
    {
	this.exchangeRate = exchangeRate;
    }

    public void setTrsCy(BigDecimal trsCy)
    {
	this.trsCy = trsCy;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getTrsCy()
    {
	return trsCy;
    }

    /**
     * @return the deductAcBr
     */
    public BigDecimal getDeductAcBr()
    {
	return deductAcBr;
    }

    /**
     * @param deductAcBr the deductAcBr to set
     */
    public void setDeductAcBr(BigDecimal deductAcBr)
    {
	this.deductAcBr = deductAcBr;
    }

    /**
     * @return the deductAcCy
     */
    public BigDecimal getDeductAcCy()
    {
	return deductAcCy;
    }

    /**
     * @param deductAcCy the deductAcCy to set
     */
    public void setDeductAcCy(BigDecimal deductAcCy)
    {
	this.deductAcCy = deductAcCy;
    }

    /**
     * @return the deductAcGl
     */
    public BigDecimal getDeductAcGl()
    {
	return deductAcGl;
    }

    /**
     * @param deductAcGl the deductAcGl to set
     */
    public void setDeductAcGl(BigDecimal deductAcGl)
    {
	this.deductAcGl = deductAcGl;
    }

    /**
     * @return the deductAcCif
     */
    public BigDecimal getDeductAcCif()
    {
	return deductAcCif;
    }

    /**
     * @param deductAcCif the deductAcCif to set
     */
    public void setDeductAcCif(BigDecimal deductAcCif)
    {
	this.deductAcCif = deductAcCif;
    }

    /**
     * @return the deductAcSl
     */
    public BigDecimal getDeductAcSl()
    {
	return deductAcSl;
    }

    /**
     * @param deductAcSl the deductAcSl to set
     */
    public void setDeductAcSl(BigDecimal deductAcSl)
    {
	this.deductAcSl = deductAcSl;
    }

    /**
     * @return the deductAcRef
     */
    public String getDeductAcRef()
    {
	return deductAcRef;
    }

    /**
     * @param deductAcRef the deductAcRef to set
     */
    public void setDeductAcRef(String deductAcRef)
    {
	this.deductAcRef = deductAcRef;
    }

    public BigDecimal getChargeCode()
    {
	return chargeCode;
    }

    public void setChargeCode(BigDecimal chargeCode)
    {
	this.chargeCode = chargeCode;
    }

    public BigDecimal getChargeCy()
    {
	return chargeCy;
    }

    public void setChargeCy(BigDecimal chargeCy)
    {
	this.chargeCy = chargeCy;
    }

    public String getChargesBooking()
    {
	return chargesBooking;
    }

    public void setChargesBooking(String chargesBooking)
    {
	this.chargesBooking = chargesBooking;
    }

    public BigDecimal getBranchBooking()
    {
	return branchBooking;
    }

    public void setBranchBooking(BigDecimal branchBooking)
    {
	this.branchBooking = branchBooking;
    }

    public BigDecimal getTrxAmount()
    {
	return trxAmount;
    }

    public void setTrxAmount(BigDecimal trxAmount)
    {
	this.trxAmount = trxAmount;
    }

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    public Date getDate()
    {
	return date;
    }

    public void setDate(Date date)
    {
	this.date = date;
    }

    public BigDecimal getCvAmount()
    {
	return cvAmount;
    }

    public void setCvAmount(BigDecimal cvAmount)
    {
	this.cvAmount = cvAmount;
    }

    public BigDecimal getFcAmount()
    {
	return fcAmount;
    }

    public void setFcAmount(BigDecimal fcAmount)
    {
	this.fcAmount = fcAmount;
    }

    public BigDecimal getGlCode()
    {
	return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    public BigDecimal getSlNo()
    {
	return slNo;
    }

    public void setSlNo(BigDecimal slNo)
    {
	this.slNo = slNo;
    }

    public String getExceed()
    {
	return exceed;
    }

    public void setExceed(String exceed)
    {
	this.exceed = exceed;
    }

    public BigDecimal getExceedAmt()
    {
	return exceedAmt;
    }

    public void setExceedAmt(BigDecimal exceedAmt)
    {
	this.exceedAmt = exceedAmt;
    }

    public BigDecimal getMinAmt()
    {
	return minAmt;
    }

    public void setMinAmt(BigDecimal minAmt)
    {
	this.minAmt = minAmt;
    }

    public BigDecimal getMaxAmt()
    {
	return maxAmt;
    }

    public void setMaxAmt(BigDecimal maxAmt)
    {
	this.maxAmt = maxAmt;
    }

    public BigDecimal getChargePercentage()
    {
	return chargePercentage;
    }

    public void setChargePercentage(BigDecimal chargePercentage)
    {
	this.chargePercentage = chargePercentage;
    }

    public BigDecimal getError()
    {
	return error;
    }

    public void setError(BigDecimal error)
    {
	this.error = error;
    }

    public String getErrorMessage()
    {
	return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
	this.errorMessage = errorMessage;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    /**
     * @return the trsAcCif
     */
    public BigDecimal getTrsAcCif()
    {
	return trsAcCif;
    }

    /**
     * @param trsAcCif the trsAcCif to set
     */
    public void setTrsAcCif(BigDecimal trsAcCif)
    {
	this.trsAcCif = trsAcCif;
    }

    /**
     * @return the trsAcBr
     */
    public BigDecimal getTrsAcBr()
    {
	return trsAcBr;
    }

    /**
     * @param trsAcBr the trsAcBr to set
     */
    public void setTrsAcBr(BigDecimal trsAcBr)
    {
	this.trsAcBr = trsAcBr;
    }

    /**
     * @return the trsfrMethod
     */
    public String getTrsfrMethod()
    {
	return trsfrMethod;
    }

    /**
     * @param trsfrMethod the trsfrMethod to set
     */
    public void setTrsfrMethod(String trsfrMethod)
    {
	this.trsfrMethod = trsfrMethod;
    }

    /**
     * @return the toTrsAcCif
     */
    public BigDecimal getToTrsAcCif()
    {
	return toTrsAcCif;
    }

    /**
     * @param toTrsAcCif the toTrsAcCif to set
     */
    public void setToTrsAcCif(BigDecimal toTrsAcCif)
    {
	this.toTrsAcCif = toTrsAcCif;
    }

    /**
     * @return the toTrsAcBr
     */
    public BigDecimal getToTrsAcBr()
    {
	return toTrsAcBr;
    }

    /**
     * @param toTrsAcBr the toTrsAcBr to set
     */
    public void setToTrsAcBr(BigDecimal toTrsAcBr)
    {
	this.toTrsAcBr = toTrsAcBr;
    }

    /**
     * @return the chAcCif
     */
    public BigDecimal getChAcCif()
    {
	return chAcCif;
    }

    /**
     * @param chAcCif the chAcCif to set
     */
    public void setChAcCif(BigDecimal chAcCif)
    {
	this.chAcCif = chAcCif;
    }

    /**
     * @return the chAcBr
     */
    public BigDecimal getChAcBr()
    {
	return chAcBr;
    }

    /**
     * @param chAcBr the chAcBr to set
     */
    public void setChAcBr(BigDecimal chAcBr)
    {
	this.chAcBr = chAcBr;
    }

    /**
     * @return the chAcCy
     */
    public BigDecimal getChAcCy()
    {
	return chAcCy;
    }

    /**
     * @param chAcCy the chAcCy to set
     */
    public void setChAcCy(BigDecimal chAcCy)
    {
	this.chAcCy = chAcCy;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public String getChargesPolicy()
    {
        return chargesPolicy;
    }

    public void setChargesPolicy(String chargesPolicy)
    {
        this.chargesPolicy = chargesPolicy;
    }

    public String getCashAccount()
    {
        return cashAccount;
    }

    public void setCashAccount(String cashAccount)
    {
        this.cashAccount = cashAccount;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public BigDecimal getCashInCurrencyCode()
    {
        return cashInCurrencyCode;
    }

    public void setCashInCurrencyCode(BigDecimal cashInCurrencyCode)
    {
        this.cashInCurrencyCode = cashInCurrencyCode;
    }

    public BigDecimal getCashInAmount()
    {
        return cashInAmount;
    }

    public void setCashInAmount(BigDecimal cashInAmount)
    {
        this.cashInAmount = cashInAmount;
    }

    public BigDecimal getCashInAccBr()
    {
        return cashInAccBr;
    }

    public void setCashInAccBr(BigDecimal cashInAccBr)
    {
        this.cashInAccBr = cashInAccBr;
    }

    public BigDecimal getCashInAccCy()
    {
        return cashInAccCy;
    }

    public void setCashInAccCy(BigDecimal cashInAccCy)
    {
        this.cashInAccCy = cashInAccCy;
    }

    public BigDecimal getCashInAccGl()
    {
        return cashInAccGl;
    }

    public void setCashInAccGl(BigDecimal cashInAccGl)
    {
        this.cashInAccGl = cashInAccGl;
    }

    public BigDecimal getCashInAccCif()
    {
        return cashInAccCif;
    }

    public void setCashInAccCif(BigDecimal cashInAccCif)
    {
        this.cashInAccCif = cashInAccCif;
    }

    public BigDecimal getCashOutCurrencyCode()
    {
        return cashOutCurrencyCode;
    }

    public void setCashOutCurrencyCode(BigDecimal cashOutCurrencyCode)
    {
        this.cashOutCurrencyCode = cashOutCurrencyCode;
    }

    public BigDecimal getCashOutAmount()
    {
        return cashOutAmount;
    }

    public void setCashOutAmount(BigDecimal cashOutAmount)
    {
        this.cashOutAmount = cashOutAmount;
    }

    public BigDecimal getCashOutAccBr()
    {
        return cashOutAccBr;
    }

    public void setCashOutAccBr(BigDecimal cashOutAccBr)
    {
        this.cashOutAccBr = cashOutAccBr;
    }

    public BigDecimal getCashOutAccCy()
    {
        return cashOutAccCy;
    }

    public void setCashOutAccCy(BigDecimal cashOutAccCy)
    {
        this.cashOutAccCy = cashOutAccCy;
    }

    public BigDecimal getCashOutAccGl()
    {
        return cashOutAccGl;
    }

    public void setCashOutAccGl(BigDecimal cashOutAccGl)
    {
        this.cashOutAccGl = cashOutAccGl;
    }

    public BigDecimal getCashOutAccCif()
    {
        return cashOutAccCif;
    }

    public void setCashOutAccCif(BigDecimal cashOutAccCif)
    {
        this.cashOutAccCif = cashOutAccCif;
    }

    public String getScreenSrc()
    {
        return screenSrc;
    }

    public void setScreenSrc(String screenSrc)
    {
        this.screenSrc = screenSrc;
    }

    /**
     * @return the chargesEmpty
     */
    public String getChargesEmpty()
    {
        return chargesEmpty;
    }

    /**
     * @param chargesEmpty the chargesEmpty to set
     */
    public void setChargesEmpty(String chargesEmpty)
    {
        this.chargesEmpty = chargesEmpty;
    }

    /**
     * @return the multiTrx
     */
    public String getMultiTrx()
    {
        return multiTrx;
    }

    /**
     * @param multiTrx the multiTrx to set
     */
    public void setMultiTrx(String multiTrx)
    {
        this.multiTrx = multiTrx;
    }

    /**
     * @return the crDrForex
     */
    public String getCrDrForex()
    {
        return crDrForex;
    }

    /**
     * @param crDrForex the crDrForex to set
     */
    public void setCrDrForex(String crDrForex)
    {
        this.crDrForex = crDrForex;
    }

    /**
     * @return the currStatus
     */
    public String getCurrStatus()
    {
        return currStatus;
    }

    /**
     * @param currStatus the currStatus to set
     */
    public void setCurrStatus(String currStatus)
    {
        this.currStatus = currStatus;
    }

    /**
     * @return the frmAlert
     */
    public String getFrmAlert()
    {
        return frmAlert;
    }

    /**
     * @param frmAlert the frmAlert to set
     */
    public void setFrmAlert(String frmAlert)
    {
        this.frmAlert = frmAlert;
    }

    public Boolean getSuppressMessage()
    {
        return suppressMessage;
    }

    public void setSuppressMessage(Boolean suppressMessage)
    {
        this.suppressMessage = suppressMessage;
    }

    public String getBaseCyFormat()
    {
        return baseCyFormat;
    }

    public void setBaseCyFormat(String baseCyFormat)
    {
        this.baseCyFormat = baseCyFormat;
    }

    public String getFcCyFormat()
    {
        return fcCyFormat;
    }

    public void setFcCyFormat(String fcCyFormat)
    {
        this.fcCyFormat = fcCyFormat;
    }

    public String getChargesWaived()
    {
        return chargesWaived;
    }

    public void setChargesWaived(String chargesWaived)
    {
        this.chargesWaived = chargesWaived;
    }

    public String getTrxMgntAccountDtlGridUpdate()
    {
        return trxMgntAccountDtlGridUpdate;
    }

    public void setTrxMgntAccountDtlGridUpdate(String trxMgntAccountDtlGridUpdate)
    {
        this.trxMgntAccountDtlGridUpdate = trxMgntAccountDtlGridUpdate;
    }

    public BigDecimal getTrsAcSl()
    {
        return trsAcSl;
    }

    public void setTrsAcSl(BigDecimal trsAcSl)
    {
        this.trsAcSl = trsAcSl;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    
    public BigDecimal getChAcGl()
    {
        return chAcGl;
    }

    public void setChAcGl(BigDecimal chAcGl)
    {
        this.chAcGl = chAcGl;
    }

    public BigDecimal getChAcSl()
    {
        return chAcSl;
    }

    public void setChAcSl(BigDecimal chAcSl)
    {
        this.chAcSl = chAcSl;
    }

    public BigDecimal getToTrsAcCy()
    {
        return toTrsAcCy;
    }

    public void setToTrsAcCy(BigDecimal toTrsAcCy)
    {
        this.toTrsAcCy = toTrsAcCy;
    }

    public BigDecimal getToTrsAcGl()
    {
        return toTrsAcGl;
    }

    public void setToTrsAcGl(BigDecimal toTrsAcGl)
    {
        this.toTrsAcGl = toTrsAcGl;
    }

    public BigDecimal getToTrsAcSl()
    {
        return toTrsAcSl;
    }

    public void setToTrsAcSl(BigDecimal toTrsAcSl)
    {
        this.toTrsAcSl = toTrsAcSl;
    }

    public BigDecimal getTrsCtrlBr()
    {
        return trsCtrlBr;
    }

    public void setTrsCtrlBr(BigDecimal trsCtrlBr)
    {
        this.trsCtrlBr = trsCtrlBr;
    }

    public BigDecimal getTrsCtrlCy()
    {
        return trsCtrlCy;
    }

    public void setTrsCtrlCy(BigDecimal trsCtrlCy)
    {
        this.trsCtrlCy = trsCtrlCy;
    }

    public BigDecimal getTrsCtrlGL()
    {
        return trsCtrlGL;
    }

    public void setTrsCtrlGL(BigDecimal trsCtrlGL)
    {
        this.trsCtrlGL = trsCtrlGL;
    }

    public BigDecimal getTrsCtrlCif()
    {
        return trsCtrlCif;
    }

    public void setTrsCtrlCif(BigDecimal trsCtrlCif)
    {
        this.trsCtrlCif = trsCtrlCif;
    }

    public BigDecimal getTrsCtrlSL()
    {
        return trsCtrlSL;
    }

    public void setTrsCtrlSL(BigDecimal trsCtrlSL)
    {
        this.trsCtrlSL = trsCtrlSL;
    }

    public BigDecimal getActionLovType()
    {
        return actionLovType;
    }

    public void setActionLovType(BigDecimal actionLovType)
    {
        this.actionLovType = actionLovType;
    }

    public String getConsiderOnce()
    {
        return considerOnce;
    }

    public void setConsiderOnce(String considerOnce)
    {
        this.considerOnce = considerOnce;
    }

    public BigDecimal getDuesCv()
    {
        return duesCv;
    }

    public void setDuesCv(BigDecimal duesCv)
    {
        this.duesCv = duesCv;
    }

    public BigDecimal getDuesFc()
    {
        return duesFc;
    }

    public void setDuesFc(BigDecimal duesFc)
    {
        this.duesFc = duesFc;
    }

    public String getActionType()
    {
        return actionType;
    }

    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }

    public BigDecimal getSessionID()
    {
        return sessionID;
    }

    public void setSessionID(BigDecimal sessionID)
    {
        this.sessionID = sessionID;
    }

    public BigDecimal getTellerCode()
    {
        return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
        this.tellerCode = tellerCode;
    }

    public String getIsUnifiedCharge()
    {
        return isUnifiedCharge;
    }

    public void setIsUnifiedCharge(String isUnifiedCharge)
    {
        this.isUnifiedCharge = isUnifiedCharge;
    }

    public BigDecimal getVoidReason()
    {
        return voidReason;
    }

    public void setVoidReason(BigDecimal voidReason)
    {
        this.voidReason = voidReason;
    }

    public BigDecimal getSerialNo()
    {
        return serialNo;
    }

    public void setSerialNo(BigDecimal serialNo)
    {
        this.serialNo = serialNo;
    }

    public BigDecimal getBatchNo()
    {
        return batchNo;
    }

    public void setBatchNo(BigDecimal batchNo)
    {
        this.batchNo = batchNo;
    }

    public BigDecimal getFileType()
    {
        return fileType;
    }

    public void setFileType(BigDecimal fileType)
    {
        this.fileType = fileType;
    }

    public String getDetailProcessStatus()
    {
        return detailProcessStatus;
    }

    public void setDetailProcessStatus(String detailProcessStatus)
    {
        this.detailProcessStatus = detailProcessStatus;
    }

    /**
     * @return the productName
     */
    public String getProductName()
    {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    /**
     * @return the entityCode
     */
    public BigDecimal getEntityCode()
    {
        return entityCode;
    }

    /**
     * @param entityCode the entityCode to set
     */
    public void setEntityCode(BigDecimal entityCode)
    {
        this.entityCode = entityCode;
    }

    /**
     * @return the leaves
     */
    public BigDecimal getLeaves()
    {
        return leaves;
    }

    /**
     * @param leaves the leaves to set
     */
    public void setLeaves(BigDecimal leaves)
    {
        this.leaves = leaves;
    }

    /**
     * @return the chequeType
     */
    public BigDecimal getChequeType()
    {
        return chequeType;
    }

    /**
     * @param chequeType the chequeType to set
     */
    public void setChequeType(BigDecimal chequeType)
    {
        this.chequeType = chequeType;
    }

    /**
     * @return the chqIssueType
     */
    public String getChqIssueType()
    {
        return chqIssueType;
    }

    /**
     * @param chqIssueType the chqIssueType to set
     */
    public void setChqIssueType(String chqIssueType)
    {
        this.chqIssueType = chqIssueType;
    }

    /**
     * @return the entityTypeCode
     */
    public BigDecimal getEntityTypeCode()
    {
        return entityTypeCode;
    }

    /**
     * @param entityTypeCode the entityTypeCode to set
     */
    public void setEntityTypeCode(BigDecimal entityTypeCode)
    {
        this.entityTypeCode = entityTypeCode;
    }

    /**
     * @return the schema
     */
    public BigDecimal getSchema()
    {
        return schema;
    }

    /**
     * @param schema the schema to set
     */
    public void setSchema(BigDecimal schema)
    {
        this.schema = schema;
    }

    /**
     * @return the destroyCharges
     */
    public BigDecimal getDestroyCharges()
    {
        return destroyCharges;
    }

    /**
     * @param destroyCharges the destroyCharges to set
     */
    public void setDestroyCharges(BigDecimal destroyCharges)
    {
        this.destroyCharges = destroyCharges;
    }

    /**
     * @return the cancelSchema
     */
    public BigDecimal getCancelSchema()
    {
        return cancelSchema;
    }

    /**
     * @param cancelSchema the cancelSchema to set
     */
    public void setCancelSchema(BigDecimal cancelSchema)
    {
        this.cancelSchema = cancelSchema;
    }

    /**
     * @return the submitSchema
     */
    public BigDecimal getSubmitSchema()
    {
        return submitSchema;
    }

    /**
     * @param submitSchema the submitSchema to set
     */
    public void setSubmitSchema(BigDecimal submitSchema)
    {
        this.submitSchema = submitSchema;
    }

    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

    /**
     * @return the trsType
     */
    public String getTrsType()
    {
        return trsType;
    }

    /**
     * @param trsType the trsType to set
     */
    public void setTrsType(String trsType)
    {
        this.trsType = trsType;
    }

    /**
     * @return the cb_ind
     */
    public String getCb_ind()
    {
        return cb_ind;
    }

    /**
     * @param cbInd the cb_ind to set
     */
    public void setCb_ind(String cbInd)
    {
        cb_ind = cbInd;
    }

    /**
     * @return the actionReaType
     */
    public String getActionReaType()
    {
        return actionReaType;
    }

    /**
     * @param actionReaType the actionReaType to set
     */
    public void setActionReaType(String actionReaType)
    {
        this.actionReaType = actionReaType;
    }


    public String getAutoApprove()
    {
        return autoApprove;
    }

    public void setAutoApprove(String autoApprove)
    {
        this.autoApprove = autoApprove;
    }

    public Date getRequestDate()
    {
        return requestDate;
    }

    public void setRequestDate(Date requestDate)
    {
        this.requestDate = requestDate;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the duesLovType
     */
    public BigDecimal getDuesLovType()
    {
        return duesLovType;
    }

    /**
     * @param duesLovType the duesLovType to set
     */
    public void setDuesLovType(BigDecimal duesLovType)
    {
        this.duesLovType = duesLovType;
    }

    public BigDecimal getDefaultTrxType()
    {
        return defaultTrxType;
    }

    public void setDefaultTrxType(BigDecimal defaultTrxType)
    {
        this.defaultTrxType = defaultTrxType;
    }

    public BigDecimal getCashInAccSl()
    {
        return cashInAccSl;
    }

    public void setCashInAccSl(BigDecimal cashInAccSl)
    {
        this.cashInAccSl = cashInAccSl;
    }

    public BigDecimal getCashOutAccSl()
    {
        return cashOutAccSl;
    }

    public void setCashOutAccSl(BigDecimal cashOutAccSl)
    {
        this.cashOutAccSl = cashOutAccSl;
    }

    public BigDecimal getTicketNo()
    {
        return ticketNo;
    }

    public void setTicketNo(BigDecimal ticketNo)
    {
        this.ticketNo = ticketNo;
    }

    /**
     * @return the showSavedCharges
     */
    public String getShowSavedCharges()
    {
        return showSavedCharges;
    }

    /**
     * @param showSavedCharges the showSavedCharges to set
     */
    public void setShowSavedCharges(String showSavedCharges)
    {
        this.showSavedCharges = showSavedCharges;
    }

    public String getChargeMsg()
    {
        return chargeMsg;
    }

    public void setChargeMsg(String chargeMsg)
    {
        this.chargeMsg = chargeMsg;
    }

    public String getRelatedSerialNoList()
    {
        return relatedSerialNoList;
    }

    public void setRelatedSerialNoList(String relatedSerialNoList)
    {
        this.relatedSerialNoList = relatedSerialNoList;
    }

    public BigDecimal getRequestCy()
    {
        return requestCy;
    }

    public void setRequestCy(BigDecimal requestCy)
    {
        this.requestCy = requestCy;
    }

    public String getPayType()
    {
        return payType;
    }

    public void setPayType(String payType)
    {
        this.payType = payType;
    }

    public String getAcceptIntrnChq()
    {
	return acceptIntrnChq;
    }

    public void setAcceptIntrnChq(String acceptIntrnChq)
    {
	this.acceptIntrnChq = acceptIntrnChq;
    }

    public BigDecimal getReleaseDays()
    {
        return releaseDays;
    }

    public void setReleaseDays(BigDecimal releaseDays)
    {
        this.releaseDays = releaseDays;
    }

    public BigDecimal getLinkToOtherTrxNo()
    {
        return linkToOtherTrxNo;
    }

    public void setLinkToOtherTrxNo(BigDecimal linkToOtherTrxNo)
    {
        this.linkToOtherTrxNo = linkToOtherTrxNo;
    }

    public String getAddString()
    {
        return addString;
    }

    public void setAddString(String addString)
    {
        this.addString = addString;
    }

    public BigDecimal getAddNumber()
    {
        return addNumber;
    }

    public void setAddNumber(BigDecimal addNumber)
    {
        this.addNumber = addNumber;
    }

    public Date getAddDate()
    {
        return addDate;
    }

    public void setAddDate(Date addDate)
    {
        this.addDate = addDate;
    }

    public String getHofReason()
    {
        return hofReason;
    }

    public void setHofReason(String hofReason)
    {
        this.hofReason = hofReason;
    }
    
    public BigDecimal getOldSchema()
    {
        return oldSchema;
    }
    
    public void setOldSchema(BigDecimal oldSchema)
    {
        this.oldSchema = oldSchema;
    }
    
    public BigDecimal getOldDestroyCharges()
    {
        return oldDestroyCharges;
    }
    
    public void setOldDestroyCharges(BigDecimal oldDestroyCharges)
    {
        this.oldDestroyCharges = oldDestroyCharges;
    }
    
    public BigDecimal getOldCancelSchema()
    {
        return oldCancelSchema;
    }
    
    public void setOldCancelSchema(BigDecimal oldCancelSchema)
    {
        this.oldCancelSchema = oldCancelSchema;
    }
    
    public BigDecimal getOldSubmitSchema()
    {
        return oldSubmitSchema;
    }
    
    public void setOldSubmitSchema(BigDecimal oldSubmitSchema)
    {
        this.oldSubmitSchema = oldSubmitSchema;
    }

    public BigDecimal getBillType()
    {
        return billType;
    }

    public void setBillType(BigDecimal billType)
    {
        this.billType = billType;
    }

    public BigDecimal getProviderCode()
    {
        return providerCode;
    }

    public void setProviderCode(BigDecimal providerCode)
    {
        this.providerCode = providerCode;
    }

    public BigDecimal getTotalAddFeesAmt()
    {
        return totalAddFeesAmt;
    }

    public void setTotalAddFeesAmt(BigDecimal totalAddFeesAmt)
    {
        this.totalAddFeesAmt = totalAddFeesAmt;
    }

    public BigDecimal getBenefBank()
    {
        return benefBank;
    }

    public void setBenefBank(BigDecimal benefBank)
    {
        this.benefBank = benefBank;
    }
}
