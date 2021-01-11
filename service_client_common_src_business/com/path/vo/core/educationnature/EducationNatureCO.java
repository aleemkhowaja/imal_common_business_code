package com.path.vo.core.educationnature;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTS_EDUCATIONAL_NATUREVO;
import com.path.lib.vo.BaseVO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * EducationNatureCO.java used to
 */
public class EducationNatureCO extends BaseVO
{
	private BigDecimal COMP_CODE;
	private BigDecimal CODE;
	private String BRIEF_DESC_ENG;
	private String BRIEF_DESC_ARAB;
	private String LONG_DESC_ENG;
	private String LONG_DESC_ARAB;
	private String ADDITIONAL_REFERENCE;
	
	private CTS_EDUCATIONAL_NATUREVO ctsEducationalNatureVO = new CTS_EDUCATIONAL_NATUREVO();
	
	
	
	public void setCOMP_CODE(BigDecimal COMP_CODE)
	{
		this.COMP_CODE = COMP_CODE;
	}
	public BigDecimal getCOMP_CODE()
	{
		return COMP_CODE;
	}
	public void setCODE(BigDecimal CODE)
	{
		this.CODE = CODE;
	}
	public BigDecimal getCODE()
	{
		return CODE;
	}
	public void setBRIEF_DESC_ENG(String BRIEF_DESC_ENG)
	{
		this.BRIEF_DESC_ENG = BRIEF_DESC_ENG;
	}
	public String getBRIEF_DESC_ENG()
	{
		return BRIEF_DESC_ENG;
	}
	public void setBRIEF_DESC_ARAB(String BRIEF_DESC_ARAB)
	{
		this.BRIEF_DESC_ARAB = BRIEF_DESC_ARAB;
	}
	public String getBRIEF_DESC_ARAB()
	{
		return BRIEF_DESC_ARAB;
	}
	public void setLONG_DESC_ENG(String LONG_DESC_ENG)
	{
		this.LONG_DESC_ENG = LONG_DESC_ENG;
	}
	public String getLONG_DESC_ENG()
	{
		return LONG_DESC_ENG;
	}
	public void setLONG_DESC_ARAB(String LONG_DESC_ARAB)
	{
		this.LONG_DESC_ARAB = LONG_DESC_ARAB;
	}
	public String getLONG_DESC_ARAB()
	{
		return LONG_DESC_ARAB;
	}
	public void setADDITIONAL_REFERENCE(String ADDITIONAL_REFERENCE)
	{
		this.ADDITIONAL_REFERENCE = ADDITIONAL_REFERENCE;
	}
	public String getADDITIONAL_REFERENCE()
	{
		return ADDITIONAL_REFERENCE;
	}
	public CTS_EDUCATIONAL_NATUREVO getCtsEducationalNatureVO()
	{
	    return ctsEducationalNatureVO;
	}
	public void setCtsEducationalNatureVO(CTS_EDUCATIONAL_NATUREVO ctsEducationalNatureVO)
	{
	    this.ctsEducationalNatureVO = ctsEducationalNatureVO;
	}

}
