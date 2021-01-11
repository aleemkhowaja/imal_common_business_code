package com.path.dao.core.instructionsubinstr;

import java.util.List;

import com.path.dbmaps.vo.CTS_INSTRUCTION_SUB_INSTRUCTVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.instructionsubinstr.InstructionSubInstrCO;
import com.path.vo.core.instructionsubinstr.InstructionSubInstrSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionSubInstrDAO.java used to
 */
public interface InstructionSubInstrDAO 
{
	public int returnInstructionSubInstrListCount(InstructionSubInstrSC criteria) throws DAOException;
	public List returnInstructionSubInstrList(InstructionSubInstrSC criteria) throws DAOException;
	public InstructionSubInstrCO dependencyByInstrSubInstrCode(InstructionSubInstrSC criteria) throws DAOException;
}