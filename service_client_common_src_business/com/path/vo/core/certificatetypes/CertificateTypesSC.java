package com.path.vo.core.certificatetypes;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CertificateTypesSC extends GridParamsSC
{
    public CertificateTypesSC()
	{
		super.setSearchCols(new String[] { "COMP_CODE","CODE"});
	}
	
	private String userId;
	private BigDecimal compCode;
	private BigDecimal typesCode;
	public String getUserId()
	{
	    return userId;
	}
	public void setUserId(String userId)
	{
	    this.userId = userId;
	}
	public BigDecimal getCompCode()
	{
	    return compCode;
	}
	public void setCompCode(BigDecimal compCode)
	{
	    this.compCode = compCode;
	}
	public BigDecimal getTypesCode()
	{
	    return typesCode;
	}
	public void setTypesCode(BigDecimal typesCode)
	{
	    this.typesCode = typesCode;
	}
}
