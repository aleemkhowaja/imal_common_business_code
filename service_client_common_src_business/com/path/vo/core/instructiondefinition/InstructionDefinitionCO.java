package com.path.vo.core.instructiondefinition;

import java.util.Date;

import com.path.dbmaps.vo.CTS_INSTRUCTIONVO;
import com.path.lib.vo.BaseVO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionDefinitionCO.java used to
 */
public class InstructionDefinitionCO extends BaseVO
{
  private CTS_INSTRUCTIONVO ctsInstructionVO = new CTS_INSTRUCTIONVO();
 
	private String CLIENT_TYPE;
	private String CLIENT_NATURE;
	private String NATIONALITY;
	private String BUSINESS_NAME;
	private String ADDRESS;
	private String NATIONAL_CARD;
	private String PASSPORT;
	private Date PASSPORT_DELIVERY_DATE;
	private String REG_CARD;
	private String COMMERCIAL_REG;
	private String OC_AGREEMENT;
	private String REG_CENTER;
 
	public void setCLIENT_TYPE(String CLIENT_TYPE)
	{
		this.CLIENT_TYPE = CLIENT_TYPE;
	}
	public String getCLIENT_TYPE()
	{
		return CLIENT_TYPE;
	}
	public void setCLIENT_NATURE(String CLIENT_NATURE)
	{
		this.CLIENT_NATURE = CLIENT_NATURE;
	}
	public String getCLIENT_NATURE()
	{
		return CLIENT_NATURE;
	}
	public void setNATIONALITY(String NATIONALITY)
	{
		this.NATIONALITY = NATIONALITY;
	}
	public String getNATIONALITY()
	{
		return NATIONALITY;
	}
	public void setBUSINESS_NAME(String BUSINESS_NAME)
	{
		this.BUSINESS_NAME = BUSINESS_NAME;
	}
	public String getBUSINESS_NAME()
	{
		return BUSINESS_NAME;
	}
	public void setADDRESS(String ADDRESS)
	{
		this.ADDRESS = ADDRESS;
	}
	public String getADDRESS()
	{
		return ADDRESS;
	}
	public void setNATIONAL_CARD(String NATIONAL_CARD)
	{
		this.NATIONAL_CARD = NATIONAL_CARD;
	}
	public String getNATIONAL_CARD()
	{
		return NATIONAL_CARD;
	}
	public void setPASSPORT(String PASSPORT)
	{
		this.PASSPORT = PASSPORT;
	}
	public String getPASSPORT()
	{
		return PASSPORT;
	}
	public void setPASSPORT_DELIVERY_DATE(Date PASSPORT_DELIVERY_DATE)
	{
		this.PASSPORT_DELIVERY_DATE = PASSPORT_DELIVERY_DATE;
	}
	public Date getPASSPORT_DELIVERY_DATE()
	{
		return PASSPORT_DELIVERY_DATE;
	}
	public void setREG_CARD(String REG_CARD)
	{
		this.REG_CARD = REG_CARD;
	}
	public String getREG_CARD()
	{
		return REG_CARD;
	}
	public void setCOMMERCIAL_REG(String COMMERCIAL_REG)
	{
		this.COMMERCIAL_REG = COMMERCIAL_REG;
	}
	public String getCOMMERCIAL_REG()
	{
		return COMMERCIAL_REG;
	}
	public void setOC_AGREEMENT(String OC_AGREEMENT)
	{
		this.OC_AGREEMENT = OC_AGREEMENT;
	}
	public String getOC_AGREEMENT()
	{
		return OC_AGREEMENT;
	}
	public void setREG_CENTER(String REG_CENTER)
	{
		this.REG_CENTER = REG_CENTER;
	}
	public String getREG_CENTER()
	{
		return REG_CENTER;
	}

}
