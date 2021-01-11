package com.path.vo.core.fmsindicator;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FmsIndicatorSC extends GridParamsSC {

	private BigDecimal cif_type;
	private BigDecimal indicatorCode;
	private BigDecimal multiplier;
	private BigDecimal value;
	private BigDecimal netValue;
	private BigDecimal cifNo;

	public BigDecimal getCif_type()
	{
		return cif_type;
	}

	public void setCif_type(BigDecimal cifType)
	{
		cif_type = cifType;
	}

	public BigDecimal getIndicatorCode()
	{
		return indicatorCode;
	}

	public void setIndicatorCode(BigDecimal indicatorCode)
	{
		this.indicatorCode = indicatorCode;
	}

	public BigDecimal getMultiplier()
	{
	    return multiplier;
	}

	public void setMultiplier(BigDecimal multiplier)
	{
	    this.multiplier = multiplier;
	}

	public BigDecimal getValue()
	{
	    return value;
	}

	public void setValue(BigDecimal value)
	{
	    this.value = value;
	}

	public BigDecimal getNetValue()
	{
	    return netValue;
	}

	public void setNetValue(BigDecimal netValue)
	{
	    this.netValue = netValue;
	}

	/**
	 * @return the cifNo
	 */
	public BigDecimal getCifNo()
	{
	    return cifNo;
	}

	/**
	 * @param cifNo the cifNo to set
	 */
	public void setCifNo(BigDecimal cifNo)
	{
	    this.cifNo = cifNo;
	}

	
}
