package com.path.vo.core.race;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class RaceSC  extends GridParamsSC {

	private BigDecimal raceCode;

	public BigDecimal getRaceCode()
	{
		return raceCode;
	}

	public void setRaceCode(BigDecimal raceCode)
	{
		this.raceCode = raceCode;
	}
}
