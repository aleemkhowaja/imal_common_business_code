package com.path.vo.core.trxmgnt.beneficiary;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: eliasaoun
 * 
 *          TrxMgntBenefSC.java used to
 */
public class TrxMgntBenefSC extends GridParamsSC
{
    private String fromWhere;
    private BigDecimal lineNo;
    private BigDecimal trsCy;
    private BigDecimal trsAcCif;
    private String trsfrType;
    private String multiBeneficiary;

    public BigDecimal getTrsCy()
    {
	return trsCy;
    }

    public void setTrsCy(BigDecimal trsCy)
    {
	this.trsCy = trsCy;
    }

    public BigDecimal getTrsAcCif()
    {
	return trsAcCif;
    }

    public void setTrsAcCif(BigDecimal trsAcCif)
    {
	this.trsAcCif = trsAcCif;
    }

    public String getTrsfrType()
    {
	return trsfrType;
    }

    public void setTrsfrType(String trsfrType)
    {
	this.trsfrType = trsfrType;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public String getFromWhere()
    {
	return fromWhere;
    }

    public void setFromWhere(String fromWhere)
    {
	this.fromWhere = fromWhere;
    }

    public String getMultiBeneficiary()
    {
	return multiBeneficiary;
    }

    public void setMultiBeneficiary(String multiBeneficiary)
    {
	this.multiBeneficiary = multiBeneficiary;
    }

}
