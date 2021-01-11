package com.path.vo.core.religion;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ReligionSC  extends GridParamsSC {

	private BigDecimal religionCode;

	public BigDecimal getReligionCode()
	{
		return religionCode;
	}

	public void setReligionCode(BigDecimal religionCode)
	{
		this.religionCode = religionCode;
	}
}
