/**
 * 
 */
package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: MarwanMaddah
 * 
 *          AccountPositionSC.java used to
 */
public class AccountPositionSC extends GridParamsSC
{
    private BigDecimal baseCurrency;
    private BigDecimal currCode;
    private BigDecimal cifNo;
    private BigDecimal glCode;
    private BigDecimal slNo;
    private BigDecimal lovTypeId;
    private BigDecimal trsNo;
    private String cbInd;
    private String trsType;
    private String srcType;
    private Date valueDate;

    /**
     * @return the baseCurrency
     */
    public BigDecimal getBaseCurrency()
    {
	return baseCurrency;
    }

    /**
     * @param baseCurrency the baseCurrency to set
     */
    public void setBaseCurrency(BigDecimal baseCurrency)
    {
	this.baseCurrency = baseCurrency;
    }

    /**
     * @return the currCode
     */
    public BigDecimal getCurrCode()
    {
	return currCode;
    }

    /**
     * @param currCode the currCode to set
     */
    public void setCurrCode(BigDecimal currCode)
    {
	this.currCode = currCode;
    }

    /**
     * @return the cifNo
     */
    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    /**
     * @param cifNo the cifNo to set
     */
    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    /**
     * @return the glCode
     */
    public BigDecimal getGlCode()
    {
	return glCode;
    }

    /**
     * @param glCode the glCode to set
     */
    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    /**
     * @return the slNo
     */
    public BigDecimal getSlNo()
    {
	return slNo;
    }

    /**
     * @param slNo the slNo to set
     */
    public void setSlNo(BigDecimal slNo)
    {
	this.slNo = slNo;
    }

    /**
     * @return the loveTypeId
     */
    public BigDecimal getLovTypeId()
    {
	return lovTypeId;
    }

    /**
     * @param loveTypeId the loveTypeId to set
     */
    public void setLovTypeId(BigDecimal lovTypeId)
    {
	this.lovTypeId = lovTypeId;
    }

    /**
     * @return the valueDate
     */
    public Date getValueDate()
    {
	return valueDate;
    }

    /**
     * @param valueDate the valueDate to set
     */
    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }

    public String getCbInd()
    {
        return cbInd;
    }

    public void setCbInd(String cbInd)
    {
        this.cbInd = cbInd;
    }

    public String getTrsType()
    {
        return trsType;
    }

    public void setTrsType(String trsType)
    {
        this.trsType = trsType;
    }

    public String getSrcType()
    {
        return srcType;
    }

    public void setSrcType(String srcType)
    {
        this.srcType = srcType;
    }
    
}
