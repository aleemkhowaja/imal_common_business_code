package com.path.vo.core.oneobligor;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class OneObligorSC extends GridParamsSC
{

    private BigDecimal oneObligorCode;
    private BigDecimal cifNo;
    
    public BigDecimal getOneObligorCode()
    {
	return oneObligorCode;
    }

    public void setOneObligorCode(BigDecimal oneObligorCode)
    {
	this.oneObligorCode = oneObligorCode;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
}
