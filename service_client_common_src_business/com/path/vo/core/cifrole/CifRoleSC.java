package com.path.vo.core.cifrole;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CifRoleSC extends GridParamsSC {

	private BigDecimal roleCode;
	private String language;

	public BigDecimal getRoleCode()
	{
		return roleCode;
	}

	public void setRoleCode(BigDecimal roleCode)
	{
		this.roleCode = roleCode;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}


}
