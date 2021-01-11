package com.path.vo.core.nationalityvalid;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class NationalityValidSC  extends GridParamsSC {
	
	private BigDecimal nationalityCode;
	private BigDecimal idType;

	public BigDecimal getNationalityCode()
	{
		return nationalityCode;
	}

	public void setNationalityCode(BigDecimal nationalityCode)
	{
		this.nationalityCode = nationalityCode;
	}

	public void setIdType(BigDecimal idType)
	{
	    this.idType = idType;
	}

	public BigDecimal getIdType()
	{
	    return idType;
	}

	
}
