package com.path.vo.common.reservedcif;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ReservedCifSC extends GridParamsSC
{
	private BigDecimal cifType;
	private BigDecimal cifNo;

	public BigDecimal getCifType()
	{
		return cifType;
	}

	public void setCifType(BigDecimal cifType)
	{
		this.cifType = cifType;
	}

	public void setCifNo(BigDecimal cifNo)
	{
	    this.cifNo = cifNo;
	}

	public BigDecimal getCifNo()
	{
	    return cifNo;
	}
	
	
	

}
