package com.path.vo.core.educationnature;

import com.path.struts2.lib.common.GridParamsSC;
import java.math.BigDecimal;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * EducationNatureSC.java used to
 */
public class EducationNatureSC extends GridParamsSC
{
	private BigDecimal compCode;
 
	private BigDecimal educationNatureCode;
 
	public void setCompCode(BigDecimal compCode)
	{
		this.compCode = compCode;
	}
	public BigDecimal getCompCode()
	{
		return compCode;
	}

	public void setEducationNatureCode(BigDecimal educationNatureCode)
	{
		this.educationNatureCode = educationNatureCode;
	}
	public BigDecimal getEducationNatureCode()
	{
		return educationNatureCode;
	}

}
