package com.path.vo.core.accounttype;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class AccountTypeSC extends GridParamsSC{
	
	private BigDecimal typeCode;
	private String bs_contra;
	private BigDecimal clubCode;

	public String getBs_contra()
	{
		return bs_contra;
	}

	public void setBs_contra(String bsContra)
	{
		bs_contra = bsContra;
	}

	public BigDecimal getTypeCode()
	{
		return typeCode;
	}

	public void setTypeCode(BigDecimal typeCode)
	{
		this.typeCode = typeCode;
	}

	public BigDecimal getClubCode()
	{
	    return clubCode;
	}

	public void setClubCode(BigDecimal clubCode)
	{
	    this.clubCode = clubCode;
	}

}
