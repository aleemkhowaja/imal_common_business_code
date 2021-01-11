package com.path.vo.core.grouping;

import java.math.BigDecimal;
import java.util.Date;
import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * SegmentGroupingSC.java used to
 */
public class SegmentGroupingSC extends GridParamsSC
{

	private BigDecimal groupCode;
	private String ivCrud;
	private BigDecimal priority;
	private Date dateUpdated;
	private String language;
	private BigDecimal isRejected;
	private BigDecimal errorCode;
	private String errorMessage;
	
	public void setIvCrud(String ivCrud)
	{
		this.ivCrud = ivCrud;
	}

	public String getIvCrud()
	{
		return ivCrud;
	}

	public BigDecimal getGroupCode()
	{
		return groupCode;
	}

	public void setGroupCode(BigDecimal groupCode)
	{
		this.groupCode = groupCode;
	}

	public BigDecimal getPriority()
	{
		return priority;
	}

	public void setPriority(BigDecimal priority)
	{
		this.priority = priority;
	}

	public Date getDateUpdated()
	{
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated)
	{
		this.dateUpdated = dateUpdated;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public BigDecimal getIsRejected()
	{
		return isRejected;
	}

	public void setIsRejected(BigDecimal isRejected)
	{
		this.isRejected = isRejected;
	}

	
	public BigDecimal getErrorCode()
	{
		return errorCode;
	}

	
	public void setErrorCode(BigDecimal errorCode)
	{
		this.errorCode = errorCode;
	}

	
	public String getErrorMessage()
	{
		return errorMessage;
	}

	
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
}
