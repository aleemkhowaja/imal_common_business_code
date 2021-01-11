package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FOMAddNationalitiesSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal lineNo;
    private BigDecimal mainLineNo;

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
}
