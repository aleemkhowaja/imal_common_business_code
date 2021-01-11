package com.path.bo.core.instructionsubinstr;

import java.util.List;

import com.path.dbmaps.vo.CTS_INSTRUCTION_SUB_INSTRUCTVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.instructionsubinstr.InstructionSubInstrCO;
import com.path.vo.core.instructionsubinstr.InstructionSubInstrSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionSubInstrBO.java used to
 */
public interface InstructionSubInstrBO 
{
	public int returnInstructionSubInstrListCount(InstructionSubInstrSC criteria) throws BaseException;
	public List returnInstructionSubInstrList(InstructionSubInstrSC criteria) throws BaseException;
	public InstructionSubInstrCO dependencyByInstrSubInstrCode(InstructionSubInstrSC criteria) throws BaseException;
}