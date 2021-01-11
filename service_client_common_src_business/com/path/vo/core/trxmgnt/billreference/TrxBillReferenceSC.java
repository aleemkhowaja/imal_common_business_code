package com.path.vo.core.trxmgnt.billreference;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: eliasaoun
 * 
 *          TrxBillReferenceSC.java used to
 */
public class TrxBillReferenceSC extends GridParamsSC
{
    private String fromWhere;

    private BigDecimal cifNo;
    private BigDecimal billType;
    private BigDecimal accCy;
    private BigDecimal accCif;

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getBillType()
    {
	return billType;
    }

    public void setBillType(BigDecimal billType)
    {
	this.billType = billType;
    }

    public BigDecimal getAccCy()
    {
	return accCy;
    }

    public void setAccCy(BigDecimal accCy)
    {
	this.accCy = accCy;
    }

    public BigDecimal getAccCif()
    {
	return accCif;
    }

    public void setAccCif(BigDecimal accCif)
    {
	this.accCif = accCif;
    }

    public String getFromWhere()
    {
	return fromWhere;
    }

    public void setFromWhere(String fromWhere)
    {
	this.fromWhere = fromWhere;
    }

}
