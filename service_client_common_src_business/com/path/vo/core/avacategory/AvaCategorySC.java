package com.path.vo.core.avacategory;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategorySC.java used to
 */
public class AvaCategorySC extends GridParamsSC
{
    private String language;
    private BigDecimal avaCategCode;
    private String paymentType;

    public BigDecimal getAvaCategCode()
    {
	return avaCategCode;
    }

    public void setAvaCategCode(BigDecimal avaCategCode)
    {
	this.avaCategCode = avaCategCode;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getPaymentType()
    {
        return paymentType;
    }

    public void setPaymentType(String paymentType)
    {
        this.paymentType = paymentType;
    }

}
