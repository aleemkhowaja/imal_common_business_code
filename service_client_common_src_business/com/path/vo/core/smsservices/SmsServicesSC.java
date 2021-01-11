package com.path.vo.core.smsservices;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * SmsServicesSC.java used to
 */
public class SmsServicesSC extends GridParamsSC
{
    private BigDecimal cifNoCode;
    private String serviceDesc;
    private String serviceType;

    public String getServiceDesc()
    {
	return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc)
    {
	this.serviceDesc = serviceDesc;
    }

    public String getServiceType()
    {
	return serviceType;
    }

    public void setServiceType(String serviceType)
    {
	this.serviceType = serviceType;
    }

    public void setCifNoCode(BigDecimal cifNoCode)
    {
	this.cifNoCode = cifNoCode;
    }

    public BigDecimal getCifNoCode()
    {
	return cifNoCode;
    }
}
