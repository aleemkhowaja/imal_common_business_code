package com.path.vo.core.blacklistcontrolrecord;

import java.math.BigDecimal;
import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ControlRecordSC.java used to
 */
public class BlackListControlRecordSC extends GridParamsSC
{

	private String status;
	private BigDecimal dualParam;
	private String ivCrud;
	private String language;
	private String cancelFlag;

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

	public String getIvCrud()
	{
		return ivCrud;
	}

	public void setIvCrud(String ivCrud)
	{
		this.ivCrud = ivCrud;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public String getCancelFlag()
	{
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag)
	{
		this.cancelFlag = cancelFlag;
	}

}
