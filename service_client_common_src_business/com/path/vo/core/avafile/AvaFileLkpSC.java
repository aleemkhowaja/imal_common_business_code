package com.path.vo.core.avafile;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * AvaCategorySC.java used to
 */
public class AvaFileLkpSC extends GridParamsSC
{	
    	private BigDecimal fileCode;	
	private String fileName;
	private String status;
 
	
	public BigDecimal getFileCode()
	{
	    return fileCode;
	}
	public void setFileCode(BigDecimal fileCode)
	{
	    this.fileCode = fileCode;
	}
	
	public String getFileName()
	{
	    return fileName;
	}
	public void setFileName(String fileName)
	{
	    this.fileName = fileName;
	}
	/**
	 * @return the status
	 */
	public String getStatus()
	{
	    return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status)
	{
	    this.status = status;
	}

}
