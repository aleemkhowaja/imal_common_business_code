package com.path.vo.core.cifprofile;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CifProfileSC extends GridParamsSC
{
    private BigDecimal cifProfileCode;

    public BigDecimal getCifProfileCode()
    {
	return cifProfileCode;
    }

    public void setCifProfileCode(BigDecimal cifProfileCode)
    {
	this.cifProfileCode = cifProfileCode;
    }
}
