package com.path.vo.core.account;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CERTIFICATE_DEPOSIT_DENOMVO;
import com.path.vo.core.common.RetailBaseVO;

public class CertificateDepositCO extends  RetailBaseVO
{
    CERTIFICATE_DEPOSIT_DENOMVO certDepositVO = new CERTIFICATE_DEPOSIT_DENOMVO();
    private String trxTypeName;
    private BigDecimal calcAmount;
    private String certDepositValueEditable = "true";
    private String remittType;
    private String predefinedValue;
    private String certOfDepSignature;
    private BigDecimal certOfDepSignatureAmt;

    public CERTIFICATE_DEPOSIT_DENOMVO getCertDepositVO()
    {
	return certDepositVO;
    }

    public void setCertDepositVO(CERTIFICATE_DEPOSIT_DENOMVO certDepositVO)
    {
	this.certDepositVO = certDepositVO;
    }

    public String getTrxTypeName()
    {
	return trxTypeName;
    }

    public void setTrxTypeName(String trxTypeName)
    {
	this.trxTypeName = trxTypeName;
    }

    public BigDecimal getCalcAmount()
    {
	return calcAmount;
    }

    public void setCalcAmount(BigDecimal calcAmount)
    {
	this.calcAmount = calcAmount;
    }

    public String getCertDepositValueEditable()
    {
	return certDepositValueEditable;
    }

    public void setCertDepositValueEditable(String certDepositValueEditable)
    {
	this.certDepositValueEditable = certDepositValueEditable;
    }

    public String getRemittType()
    {
	return remittType;
    }

    public void setRemittType(String remittType)
    {
	this.remittType = remittType;
    }

    public String getPredefinedValue()
    {
	return predefinedValue;
    }

    public void setPredefinedValue(String predefinedValue)
    {
	this.predefinedValue = predefinedValue;
    }

    public String getCertOfDepSignature()
    {
	return certOfDepSignature;
    }

    public void setCertOfDepSignature(String certOfDepSignature)
    {
	this.certOfDepSignature = certOfDepSignature;
    }

    public BigDecimal getCertOfDepSignatureAmt()
    {
	return certOfDepSignatureAmt;
    }

    public void setCertOfDepSignatureAmt(BigDecimal certOfDepSignatureAmt)
    {
	this.certOfDepSignatureAmt = certOfDepSignatureAmt;
    }
	
}