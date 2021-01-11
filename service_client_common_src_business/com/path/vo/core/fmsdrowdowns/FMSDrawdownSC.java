package com.path.vo.core.fmsdrowdowns;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FMSDrawdownSC extends GridParamsSC
{
    private BigDecimal code;
    private String status;
    private BigDecimal lineNbr;

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public void setLineNbr(BigDecimal lineNbr)
    {
	this.lineNbr = lineNbr;
    }

    public BigDecimal getLineNbr()
    {
	return lineNbr;
    }

}