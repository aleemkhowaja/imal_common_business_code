package com.path.vo.core.billtype;

import java.math.BigDecimal;

import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: EliasAoun
 * 
 *          BillTypeCO.java used to retrieve data related for bill type
 */
public class BillTypeCO extends RetailBaseVO
{

    public BillTypeCO()
    {
	// TODO Auto-generated constructor stub
    }

    /**
     * SO_REFERENCE, REFERENCE
     */
    private String reference;

    /**
     * REF_FIELD_TYPE
     */
    private String refFieldType;

    /**
     * REF_MIN_MAX
     */
    private String refMinMax;

    /**
     * REF_FIELD_LENGTH
     */
    private BigDecimal refFieldLength;

    /**
     * START_WITH
     */
    private String startWith;

    /**
     * BILL_TYPE
     */
    private BigDecimal billType;

    /**
     * CIF
     */
    private BigDecimal cifNo;

    public String getRefFieldType()
    {
	return refFieldType;
    }

    public void setRefFieldType(String refFieldType)
    {
	this.refFieldType = refFieldType;
    }

    public String getRefMinMax()
    {
	return refMinMax;
    }

    public void setRefMinMax(String refMinMax)
    {
	this.refMinMax = refMinMax;
    }

    public BigDecimal getRefFieldLength()
    {
	return refFieldLength;
    }

    public void setRefFieldLength(BigDecimal refFieldLength)
    {
	this.refFieldLength = refFieldLength;
    }

    public String getStartWith()
    {
	return startWith;
    }

    public void setStartWith(String startWith)
    {
	this.startWith = startWith;
    }

    public String getReference()
    {
	return reference;
    }

    public void setReference(String reference)
    {
	this.reference = reference;
    }

    public BigDecimal getBillType()
    {
	return billType;
    }

    public void setBillType(BigDecimal billType)
    {
	this.billType = billType;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

}
