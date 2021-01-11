package com.path.vo.core.certificate;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * CertificateLookupSC.java used to
 */
public class CertificateLookupSC extends GridParamsSC
{	
    private BigDecimal certificateCode;
    private BigDecimal numberOfBills;
    private BigDecimal sumOfBills;
    private BigDecimal certificateBranch;

    public void setCertificateCode(BigDecimal certificateCode)
    {
	this.certificateCode = certificateCode;
    }

    public BigDecimal getCertificateCode()
    {
	return certificateCode;
    }

    public void setNumberOfBills(BigDecimal numberOfBills)
    {
	this.numberOfBills = numberOfBills;
    }

    public BigDecimal getNumberOfBills()
    {
	return numberOfBills;
    }

    public void setSumOfBills(BigDecimal sumOfBills)
    {
	this.sumOfBills = sumOfBills;
    }

    public BigDecimal getSumOfBills()
    {
	return sumOfBills;
    }

    public void setCertificateBranch(BigDecimal certificateBranch)
    {
	this.certificateBranch = certificateBranch;
    }

    public BigDecimal getCertificateBranch()
    {
	return certificateBranch;
    }
}
