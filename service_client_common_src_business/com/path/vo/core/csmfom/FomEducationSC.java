package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FomEducationSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal lineNo;

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    /**
     * @return the lineNo
     */
    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    /**
     * @param lineNo the lineNo to set
     */
    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

}
