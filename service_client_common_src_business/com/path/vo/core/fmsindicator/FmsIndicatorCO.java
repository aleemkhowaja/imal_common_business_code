package com.path.vo.core.fmsindicator;

import com.path.dbmaps.vo.FMSINDICATORVO;
import com.path.vo.core.common.RetailBaseVO;


public class FmsIndicatorCO extends RetailBaseVO  
{
	private FMSINDICATORVO fmsIndicatorVO;
	private String CIF_TYPE_NAME;
	 
	public FMSINDICATORVO getFmsIndicatorVO()
	{
		return fmsIndicatorVO;
	}
	public void setFmsIndicatorVO(FMSINDICATORVO fmsIndicatorVO)
	{
		this.fmsIndicatorVO = fmsIndicatorVO;
	}
	public String getCIF_TYPE_NAME()
	{
		return CIF_TYPE_NAME;
	}
	public void setCIF_TYPE_NAME(String cIFTYPENAME)
	{
		CIF_TYPE_NAME = cIFTYPENAME;
	}
	 
 

}
