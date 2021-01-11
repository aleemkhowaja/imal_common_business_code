/**
 * 
 */
package com.path.vo.common.requests.csm;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 * CtsRequestSC.java used to
 */
public class CtsRequestSC extends GridParamsSC
{
    private BigDecimal code;
    private BigDecimal cifNo;
    private BigDecimal requestType;

    private String reqReferene;
    private String appName;
    private String iisAmentFalg;
    private String trsType;
    private String cbInd;
    private String language;
    private String processRequest;
    private String expired;
    private String originalProgRef;
    private String originalAppName;
    private String paymentType;

    private Date runningDate;
    private BigDecimal scannedCIFNo;
    private String status;
    private String tfaStatus;// used ti set the tfa status
    private String lcType;
    private BigDecimal trxType;
    private BigDecimal trxNbr;
    private String crud;
    private String reinstateDocType;
    private String reinstateLinkedTrx; // A flag to reinstate a transaction linked
    private BigDecimal linkedTrxNbr;
    private String errorMessage;
    
    /**
     * Procedure Error code
     */
    private BigDecimal errorCode;
    /**
     * Procedure Error type example : E=Error W=Warning
     */
    private String errorType;
    
    private String waiveCharges;
    private BigDecimal BalanceLimitRequest;
    private boolean globalConfirmation;
    

    /**
     * @return the code
     */
    public BigDecimal getCode()
    {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(BigDecimal code)
    {
        this.code = code;
    }

    /**
     * @return the appName
     */
    public String getAppName()
    {
        return appName;
    }

    /**
     * @param appName the appName to set
     */
    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public BigDecimal getRequestType()
    {
        return requestType;
    }

    public void setRequestType(BigDecimal requestType)
    {
        this.requestType = requestType;
    }

    public String getIisAmentFalg()
    {
        return iisAmentFalg;
    }

    public void setIisAmentFalg(String iisAmentFalg)
    {
        this.iisAmentFalg = iisAmentFalg;
    }

    public String getReqReferene()
    {
        return reqReferene;
    }

    public void setReqReferene(String reqReferene)
    {
        this.reqReferene = reqReferene;
    }

    public String getTrsType()
    {
        return trsType;
    }

    public void setTrsType(String trsType)
    {
        this.trsType = trsType;
    }

    public String getCbInd()
    {
        return cbInd;
    }

    public void setCbInd(String cbInd)
    {
        this.cbInd = cbInd;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getProcessRequest()
    {
        return processRequest;
    }

    public void setProcessRequest(String processRequest)
    {
        this.processRequest = processRequest;
    }

    public String getExpired()
    {
        return expired;
    }

    public void setExpired(String expired)
    {
        this.expired = expired;
    }

    public Date getRunningDate()
    {
        return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    public String getOriginalProgRef()
    {
        return originalProgRef;
    }

    public void setOriginalProgRef(String originalProgRef)
    {
        this.originalProgRef = originalProgRef;
    }

    public String getOriginalAppName()
    {
        return originalAppName;
    }

    public void setOriginalAppName(String originalAppName)
    {
        this.originalAppName = originalAppName;
    }

    /**
     * @return the paymentType
     */
    public String getPaymentType()
    {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType)
    {
        this.paymentType = paymentType;
    }

    public BigDecimal getScannedCIFNo()
    {
        return scannedCIFNo;
    }

    public void setScannedCIFNo(BigDecimal scannedCIFNo)
    {
        this.scannedCIFNo = scannedCIFNo;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getTfaStatus()
    {
        return tfaStatus;
    }

    public void setTfaStatus(String tfaStatus)
    {
        this.tfaStatus = tfaStatus;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorType()
    {
        return errorType;
    }

    public void setErrorType(String errorType)
    {
        this.errorType = errorType;
    }

    public String getLcType()
    {
        return lcType;
    }

    public void setLcType(String lcType)
    {
        this.lcType = lcType;
    }

    public BigDecimal getTrxNbr()
    {
        return trxNbr;
    }

    public void setTrxNbr(BigDecimal trxNbr)
    {
        this.trxNbr = trxNbr;
    }

    public String getReinstateDocType()
    {
        return reinstateDocType;
    }

    public void setReinstateDocType(String reinstateDocType)
    {
        this.reinstateDocType = reinstateDocType;
    }

    public String getReinstateLinkedTrx()
    {
        return reinstateLinkedTrx;
    }

    public void setReinstateLinkedTrx(String reinstateLinkedTrx)
    {
        this.reinstateLinkedTrx = reinstateLinkedTrx;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public String getCrud()
    {
        return crud;
    }

    public void setCrud(String crud)
    {
        this.crud = crud;
    }

    public String getWaiveCharges()
    {
        return waiveCharges;
    }

    public void setWaiveCharges(String waiveCharges)
    {
        this.waiveCharges = waiveCharges;
    }

    public BigDecimal getBalanceLimitRequest()
    {
        return BalanceLimitRequest;
    }

    public void setBalanceLimitRequest(BigDecimal balanceLimitRequest)
    {
        BalanceLimitRequest = balanceLimitRequest;
    }

    public BigDecimal getLinkedTrxNbr()
    {
        return linkedTrxNbr;
    }

    public void setLinkedTrxNbr(BigDecimal linkedTrxNbr)
    {
        this.linkedTrxNbr = linkedTrxNbr;
    }
    
    public boolean isGlobalConfirmation()
    {
        return globalConfirmation;
    }

    public void setGlobalConfirmation(boolean globalConfirmation)
    {
        this.globalConfirmation = globalConfirmation;
    }

}
