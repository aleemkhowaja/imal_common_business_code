package com.path.vo.core.instructionsubinstr;

import com.path.dbmaps.vo.CTS_INSTRUCTION_SUB_INSTRUCTVO;
import com.path.lib.vo.BaseVO;
  
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionSubInstrCO.java used to
 */
public class InstructionSubInstrCO extends BaseVO
{
  private CTS_INSTRUCTION_SUB_INSTRUCTVO ctsInstructionSubInstrVO = new CTS_INSTRUCTION_SUB_INSTRUCTVO();
 
	private String SUB_INSTRUCTION_CODE;
	private String BRIEF_NAME_ENG;
 
	public void setBRIEF_NAME_ENG(String BRIEF_NAME_ENG)
	{
		this.BRIEF_NAME_ENG = BRIEF_NAME_ENG;
	}
	public String getBRIEF_NAME_ENG()
	{
		return BRIEF_NAME_ENG;
	}
	public CTS_INSTRUCTION_SUB_INSTRUCTVO getCtsInstructionSubInstrVO()
	{
	    return ctsInstructionSubInstrVO;
	}
	public void setCtsInstructionSubInstrVO(CTS_INSTRUCTION_SUB_INSTRUCTVO ctsInstructionSubInstrVO)
	{
	    this.ctsInstructionSubInstrVO = ctsInstructionSubInstrVO;
	}
	public String getSUB_INSTRUCTION_CODE()
	{
	    return SUB_INSTRUCTION_CODE;
	}
	public void setSUB_INSTRUCTION_CODE(String sUB_INSTRUCTION_CODE)
	{
	    SUB_INSTRUCTION_CODE = sUB_INSTRUCTION_CODE;
	}

}
