package com.path.vo.common.global360view.oneobligor;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class DashOneObligorSC extends GridParamsSC
{

    private BigDecimal oneObligorCode;
    private BigDecimal cifNo;
    private String language;
    
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

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }
}
