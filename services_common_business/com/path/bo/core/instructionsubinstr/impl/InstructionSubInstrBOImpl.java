package com.path.bo.core.instructionsubinstr.impl;

import java.util.List;

import com.path.bo.core.instructionsubinstr.InstructionSubInstrBO;
import com.path.dao.core.instructionsubinstr.InstructionSubInstrDAO;
import com.path.dbmaps.vo.CTS_INSTRUCTION_SUB_INSTRUCTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.instructionsubinstr.InstructionSubInstrCO;
import com.path.vo.core.instructionsubinstr.InstructionSubInstrSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionSubInstrBOImpl.java used to
 */
public class InstructionSubInstrBOImpl extends BaseBO implements InstructionSubInstrBO
{
	InstructionSubInstrDAO instructionSubInstrDAO;
	 /**
	 * Method used to return Count of InstructionSubInstr
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws BaseException
	 */	
	public int returnInstructionSubInstrListCount(InstructionSubInstrSC criteria) throws BaseException
	{
		return instructionSubInstrDAO.returnInstructionSubInstrListCount(criteria);
	}
	/**
	 * Method used to return List of InstructionSubInstr
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws BaseException
	 */
	public List returnInstructionSubInstrList(InstructionSubInstrSC criteria) throws BaseException
	{
		return instructionSubInstrDAO.returnInstructionSubInstrList(criteria);
	}

	public InstructionSubInstrDAO getInstructionSubInstrDAO()
	{
		return instructionSubInstrDAO;
	}
	public void setInstructionSubInstrDAO(InstructionSubInstrDAO instructionSubInstrDAO)
	{
		this.instructionSubInstrDAO = instructionSubInstrDAO;
	}
	
	public InstructionSubInstrCO dependencyByInstrSubInstrCode(InstructionSubInstrSC criteria) throws BaseException
	{
	    return instructionSubInstrDAO.dependencyByInstrSubInstrCode(criteria);
	}
}
