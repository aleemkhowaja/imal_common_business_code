package com.path.vo.core.clubbing;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ClubbingSC.java used to
 */
public class ClubbingSC extends GridParamsSC
{
    	private BigDecimal clubbedAccCode;
	private BigDecimal compCode;
	private BigDecimal groupCode;
 
	@Override
	public void setCompCode(BigDecimal compCode)
	{
		this.compCode = compCode;
	}
	@Override
	public BigDecimal getCompCode()
	{
		return compCode;
	}
	public BigDecimal getGroupCode()
	{
	    return groupCode;
	}
	public void setGroupCode(BigDecimal groupCode)
	{
	    this.groupCode = groupCode;
	}
	public BigDecimal getClubbedAccCode()
	{
	    return clubbedAccCode;
	}
	public void setClubbedAccCode(BigDecimal clubbedAccCode)
	{
	    this.clubbedAccCode = clubbedAccCode;
	}
}
