package com.path.vo.common.entitycharges;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.struts2.lib.common.GridParamsSC;

public class EntityChargesSC extends GridParamsSC
{

    private BigDecimal code;
    private BigDecimal[] codeArr;
    private BigDecimal amount;
    private CTSCHARGESVO ctsChargesVO = new CTSCHARGESVO();
    private String language;
    private String typeInd;
    private String entityType;
    private BigDecimal totalCvAmount;
    private BigDecimal totalFcAmount;
    private BigDecimal totalCvDues;
    private BigDecimal totalFcDues;
    private BigDecimal debitAccBr;
    private BigDecimal errorCode;
    private String errorMessage;
    private BigDecimal applyVAT;
    private BigDecimal schema;
    private BigDecimal chargeCurrency;

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }

    public CTSCHARGESVO getCtsChargesVO()
    {
	return ctsChargesVO;
    }

    public void setCtsChargesVO(CTSCHARGESVO ctsChargesVO)
    {
	this.ctsChargesVO = ctsChargesVO;
    }

    public BigDecimal getAmount()
    {
	return amount;
    }

    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public String getTypeInd()
    {
	return typeInd;
    }

    public void setTypeInd(String typeInd)
    {
	this.typeInd = typeInd;
    }

    public String getEntityType()
    {
	return entityType;
    }

    public void setEntityType(String entityType)
    {
	this.entityType = entityType;
    }

    public BigDecimal getTotalCvAmount()
    {
	return totalCvAmount;
    }

    public void setTotalCvAmount(BigDecimal totalCvAmount)
    {
	this.totalCvAmount = totalCvAmount;
    }

    public BigDecimal getTotalFcAmount()
    {
	return totalFcAmount;
    }

    public void setTotalFcAmount(BigDecimal totalFcAmount)
    {
	this.totalFcAmount = totalFcAmount;
    }

    public BigDecimal getTotalCvDues()
    {
	return totalCvDues;
    }

    public void setTotalCvDues(BigDecimal totalCvDues)
    {
	this.totalCvDues = totalCvDues;
    }

    public BigDecimal getTotalFcDues()
    {
	return totalFcDues;
    }

    public void setTotalFcDues(BigDecimal totalFcDues)
    {
	this.totalFcDues = totalFcDues;
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

    public BigDecimal[] getCodeArr()
    {
	return codeArr == null ? new BigDecimal[] {} : codeArr;
    }

    public void setCodeArr(BigDecimal... codeArr)
    {
	this.codeArr = codeArr;
    }

    public BigDecimal getDebitAccBr()
    {
        return debitAccBr;
    }

    public void setDebitAccBr(BigDecimal debitAccBr)
    {
        this.debitAccBr = debitAccBr;
    }

    public BigDecimal getApplyVAT()
    {
        return applyVAT;
    }

    public void setApplyVAT(BigDecimal applyVAT)
    {
        this.applyVAT = applyVAT;
    }

    public BigDecimal getSchema()
    {
        return schema;
    }

    public void setSchema(BigDecimal schema)
    {
        this.schema = schema;
    }

    public BigDecimal getChargeCurrency()
    {
        return chargeCurrency;
    }

    public void setChargeCurrency(BigDecimal chargeCurrency)
    {
        this.chargeCurrency = chargeCurrency;
    }

}
