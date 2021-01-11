package com.path.vo.core.registrationcenter;

import com.path.dbmaps.vo.CTS_REGISTER_CENTERVO;
import com.path.lib.vo.BaseVO;
  
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * RegistrationCenterCO.java used to
 */
public class RegistrationCenterCO extends BaseVO
{
  private CTS_REGISTER_CENTERVO ctsRegCenterVO = new CTS_REGISTER_CENTERVO();

  private String CODE;
	private String BRIEF_NAME_ENG;
 
	public void setCODE(String CODE)
	{
		this.CODE = CODE;
	}
	public String getCODE()
	{
		return CODE;
	}
	public void setBRIEF_NAME_ENG(String BRIEF_NAME_ENG)
	{
		this.BRIEF_NAME_ENG = BRIEF_NAME_ENG;
	}
	public String getBRIEF_NAME_ENG()
	{
		return BRIEF_NAME_ENG;
	}
	public CTS_REGISTER_CENTERVO getCtsRegCenterVO()
	{
	    return ctsRegCenterVO;
	}
	public void setCtsRegCenterVO(CTS_REGISTER_CENTERVO ctsRegCenterVO)
	{
	    this.ctsRegCenterVO = ctsRegCenterVO;
	}
	
}
