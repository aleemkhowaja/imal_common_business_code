/**
 * 
 */
package com.path.vo.core.trxmgnt.batch;

import java.math.BigDecimal;
import java.util.Date;

import com.path.bo.common.ConstantsCommon;
import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: marwanmaddah
 * 
 *          TrxMgntBatchSC.java used to
 */
public class TrxMgntBatchSC extends GridParamsSC
{
    private String appName;
    private String progRef;
    private String ivCrud;
    private BigDecimal cifNo;
    private BigDecimal batchNo;
    private String s_batch_type;
    private String batch_status;
    private BigDecimal trsNo;
    private BigDecimal trsCy;
    private String trsType;
    private String createdBy;
    private BigDecimal bankCif;
    private BigDecimal reasonCode;
    private BigDecimal exchangeRate;
    private BigDecimal getOrSet;
    private BigDecimal recursive;
    
    private BigDecimal lineNo;
    private BigDecimal errorCode;
    private String errorMsg;
    
    private BigDecimal bank_code;
    private BigDecimal cheque_no;
    private BigDecimal clearing_house;
    private BigDecimal cheque_cy;
    private Date trsdate;
    
    private String automaticBatch;
    private BigDecimal clickOk;

    //this id is used for olap grid (subgrid)
    private BigDecimal id;
    
    /*
     * Simulating constants in xml
     */
    public final static BigDecimal STATUS_CODE_CLEAR = ConstantsCommon.CLEAR_VOID_STS_LOV_TYP_ID;
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

    /**
     * @return the progRef
     */
    public String getProgRef()
    {
	return progRef;
    }

    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    /**
     * @return the ivCrud
     */
    public String getIvCrud()
    {
	return ivCrud;
    }

    /**
     * @param ivCrud the ivCrud to set
     */
    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    public void setBatchNo(BigDecimal batchNo)
    {
	this.batchNo = batchNo;
    }

    public String getS_batch_type()
    {
	return s_batch_type;
    }

    public void setS_batch_type(String sBatchType)
    {
	s_batch_type = sBatchType;
    }

    public String getBatch_status()
    {
	return batch_status;
    }

    public void setBatch_status(String batchStatus)
    {
	batch_status = batchStatus;
    }

    public BigDecimal getBatchNo()
    {
	return batchNo;
    }

    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }

    public BigDecimal getBank_code()
    {
	return bank_code;
    }

    public void setBank_code(BigDecimal bankCode)
    {
	bank_code = bankCode;
    }

    public BigDecimal getCheque_no()
    {
	return cheque_no;
    }

    public void setCheque_no(BigDecimal chequeNo)
    {
	cheque_no = chequeNo;
    }

    public BigDecimal getClearing_house()
    {
	return clearing_house;
    }

    public void setClearing_house(BigDecimal clearingHouse)
    {
	clearing_house = clearingHouse;
    }

    public BigDecimal getCheque_cy()
    {
	return cheque_cy;
    }

    public void setCheque_cy(BigDecimal chequeCy)
    {
	cheque_cy = chequeCy;
    }

    public Date getTrsdate()
    {
	return trsdate;
    }

    public void setTrsdate(Date trsdate)
    {
	this.trsdate = trsdate;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getId()
    {
	return id;
    }

    public void setId(BigDecimal id)
    {
	this.id = id;
    }

    public BigDecimal getTrsCy()
    {
        return trsCy;
    }

    public void setTrsCy(BigDecimal trsCy)
    {
        this.trsCy = trsCy;
    }

    public BigDecimal getBankCif()
    {
        return bankCif;
    }

    public void setBankCif(BigDecimal bankCif)
    {
        this.bankCif = bankCif;
    }

    public String getAutomaticBatch()
    {
        return automaticBatch;
    }

    public void setAutomaticBatch(String automaticBatch)
    {
        this.automaticBatch = automaticBatch;
    }

    public String getTrsType()
    {
        return trsType;
    }

    public void setTrsType(String trsType)
    {
        this.trsType = trsType;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public BigDecimal getReasonCode()
    {
        return reasonCode;
    }

    public void setReasonCode(BigDecimal reasonCode)
    {
        this.reasonCode = reasonCode;
    }

    public BigDecimal getExchangeRate()
    {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate)
    {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getGetOrSet()
    {
        return getOrSet;
    }

    public void setGetOrSet(BigDecimal getOrSet)
    {
        this.getOrSet = getOrSet;
    }

    public BigDecimal getRecursive()
    {
        return recursive;
    }

    public void setRecursive(BigDecimal recursive)
    {
        this.recursive = recursive;
    }

    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
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

    public BigDecimal getClickOk()
    {
        return clickOk;
    }

    public void setClickOk(BigDecimal clickOk)
    {
        this.clickOk = clickOk;
    }

}
