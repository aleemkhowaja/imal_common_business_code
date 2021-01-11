package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FOMBalanceLimitSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal lineNo;
    private BigDecimal mainLineNo;
    private BigDecimal cifType;
    private BigDecimal accLimitCode;

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public BigDecimal getMainLineNo()
    {
	return mainLineNo;
    }

    public void setMainLineNo(BigDecimal mainLineNo)
    {
	this.mainLineNo = mainLineNo;
    }

    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public BigDecimal getAccLimitCode()
    {
        return accLimitCode;
    }

    public void setAccLimitCode(BigDecimal accLimitCode)
    {
        this.accLimitCode = accLimitCode;
    }
}
