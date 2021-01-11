package com.path.vo.core.chargesfeespolicy;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ChargesFeesPolicySC  extends GridParamsSC {
    
    public BigDecimal chargesCode;
    private String     langCode;
	private BigDecimal lovType;
    
    public BigDecimal getChargesCode()
    {
        return chargesCode;
    }

    public void setChargesCode(BigDecimal chargesCode)
    {
        this.chargesCode = chargesCode;
    }

	public String getLangCode()
	{
		return langCode;
	}

	public void setLangCode(String langCode)
	{
		this.langCode = langCode;
	}

	public BigDecimal getLovType()
	{
		return lovType;
	}

	public void setLovType(BigDecimal lovType)
	{
		this.lovType = lovType;
	}



}
