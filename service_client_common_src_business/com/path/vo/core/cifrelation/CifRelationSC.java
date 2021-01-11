package com.path.vo.core.cifrelation;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CifRelationSC extends GridParamsSC
{
    private BigDecimal cifRelationCode;

	public BigDecimal getCifRelationCode()
	{
		return cifRelationCode;
	}

	public void setCifRelationCode(BigDecimal cifRelationCode)
	{
		this.cifRelationCode = cifRelationCode;
	}

    
}
