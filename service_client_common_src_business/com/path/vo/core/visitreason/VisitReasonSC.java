package com.path.vo.core.visitreason;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class VisitReasonSC extends GridParamsSC
{
    private String paramType;
    private BigDecimal reasonCode;

    public String getParamType()
    {
	return paramType;
    }

    public void setParamType(String paramType)
    {
	this.paramType = paramType;
    }

    public BigDecimal getReasonCode()
    {
	return reasonCode;
    }

    public void setReasonCode(BigDecimal reasonCode)
    {
	this.reasonCode = reasonCode;
    }
}
