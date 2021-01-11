package com.path.vo.core.division;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class DivisionSC extends GridParamsSC
{
	private BigDecimal divisionCode;

	 public BigDecimal getDivisionCode()
    {
	return divisionCode;
    }

    public void setDivisionCode(BigDecimal divisionCode)
    {
	this.divisionCode = divisionCode;
    }
}
