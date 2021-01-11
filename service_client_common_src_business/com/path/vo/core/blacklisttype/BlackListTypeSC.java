package com.path.vo.core.blacklisttype;

import java.math.BigDecimal;
import com.path.struts2.lib.common.GridParamsSC;

public class BlackListTypeSC extends GridParamsSC
{

	private BigDecimal code;
	// added by nour for 777000
	private BigDecimal compCode;
	private String langCode;
	private String language;
	private BigDecimal lovType;
	private String appName;
	private String progRef;
	private String ivCrud;
	private BigDecimal LovTypeId;
	private String status;
	private BigDecimal dualParam;
	private BigDecimal cancelFlag;
	// end nour

	public BigDecimal getCode()
	{
		return code;
	}

	public void setCode(BigDecimal code)
	{
		this.code = code;
	}

	public BigDecimal getCompCode()
	{
		return compCode;
	}

	public void setCompCode(BigDecimal compCode)
	{
		this.compCode = compCode;
	}

	public String getLangCode()
	{
		return langCode;
	}

	public void setLangCode(String langCode)
	{
		this.langCode = langCode;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public BigDecimal getLovType()
	{
		return lovType;
	}

	public void setLovType(BigDecimal lovType)
	{
		this.lovType = lovType;
	}

	public String getAppName()
	{
		return appName;
	}

	public void setAppName(String appName)
	{
		this.appName = appName;
	}

	public String getProgRef()
	{
		return progRef;
	}

	public void setProgRef(String progRef)
	{
		this.progRef = progRef;
	}

	public String getIvCrud()
	{
		return ivCrud;
	}

	public void setIvCrud(String ivCrud)
	{
		this.ivCrud = ivCrud;
	}

	public BigDecimal getLovTypeId()
	{
		return LovTypeId;
	}

	public void setLovTypeId(BigDecimal lovTypeId)
	{
		LovTypeId = lovTypeId;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public BigDecimal getDualParam()
	{
		return dualParam;
	}

	public void setDualParam(BigDecimal dualParam)
	{
		this.dualParam = dualParam;
	}

	public BigDecimal getCancelFlag()
	{
		return cancelFlag;
	}

	public void setCancelFlag(BigDecimal cancelFlag)
	{
		this.cancelFlag = cancelFlag;
	}

}
