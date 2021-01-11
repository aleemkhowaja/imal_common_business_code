package com.path.vo.core.administration;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public final class AdministrationSC extends GridParamsSC
{
    private BigDecimal code;
    private String language;

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal obj)
    {
	this.code = obj;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String obj)
    {
	this.language = obj;
    }
}
