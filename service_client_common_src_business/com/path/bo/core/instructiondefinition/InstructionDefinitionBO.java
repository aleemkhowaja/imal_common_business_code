package com.path.bo.core.instructiondefinition;

import com.path.dbmaps.vo.CTS_INSTRUCTIONVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.instructiondefinition.InstructionDefinitionSC;
import com.path.vo.core.instructiondefinition.InstructionDefinitionCO;
import java.util.List;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionDefinitionBO.java used to
 */
public interface InstructionDefinitionBO 
{
	public int returnInstructionDefinitionListCount(InstructionDefinitionSC criteria) throws BaseException;
	public List returnInstructionDefinitionList(InstructionDefinitionSC criteria) throws BaseException;
	public CTS_INSTRUCTIONVO dependencyByInstructionCode(InstructionDefinitionSC criteria) throws BaseException;
}