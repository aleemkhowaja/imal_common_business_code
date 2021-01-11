package com.path.vo.core.common.billtypeaddref;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class BillTypeAddReferenceSC extends GridParamsSC
{
    private String language;
    private String regType;
    private BigDecimal lineNo;
    private BigDecimal addRefLineNo;
    private BigDecimal providerLineNo;
    private BigDecimal cifNo;
    private BigDecimal billType;

    private String trsType;
    private String cbInd;
    private BigDecimal trsNo;
    private String reference;
    private String fromWhere;
    private String status;

    private BigDecimal validateRefWithProvider;
    private BigDecimal trxType;
    private String refType;
    private BigDecimal fieldCode;

    public String getRegType()
    {
	return regType;
    }

    public void setRegType(String regType)
    {
	this.regType = regType;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
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

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getProviderLineNo()
    {
	return providerLineNo;
    }

    public void setProviderLineNo(BigDecimal providerLineNo)
    {
	this.providerLineNo = providerLineNo;
    }

    public BigDecimal getAddRefLineNo()
    {
	return addRefLineNo;
    }

    public void setAddRefLineNo(BigDecimal addRefLineNo)
    {
	this.addRefLineNo = addRefLineNo;
    }

    public String getFromWhere()
    {
	return fromWhere;
    }

    public void setFromWhere(String fromWhere)
    {
	this.fromWhere = fromWhere;
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

    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public BigDecimal getValidateRefWithProvider()
    {
	return validateRefWithProvider;
    }

    public void setValidateRefWithProvider(BigDecimal validateRefWithProvider)
    {
	this.validateRefWithProvider = validateRefWithProvider;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public String getRefType()
    {
        return refType;
    }

    public void setRefType(String refType)
    {
        this.refType = refType;
    }

    public BigDecimal getFieldCode()
    {
        return fieldCode;
    }

    public void setFieldCode(BigDecimal fieldCode)
    {
        this.fieldCode = fieldCode;
    }
}