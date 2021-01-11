package com.path.bo.core.instructiondefinition.impl;

import java.util.List;

import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.instructiondefinition.InstructionDefinitionBO;
import com.path.dao.core.instructiondefinition.InstructionDefinitionDAO;
import com.path.dbmaps.vo.CTS_INSTRUCTIONVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.instructiondefinition.InstructionDefinitionSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionDefinitionBOImpl.java used to
 */
public class InstructionDefinitionBOImpl extends RetailBaseBO implements InstructionDefinitionBO
{
	InstructionDefinitionDAO instructionDefinitionDAO;
	 
	 /**
	 * Method used to return Count of InstructionDefinition
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws BaseException
	 */	
	public int returnInstructionDefinitionListCount(InstructionDefinitionSC criteria) throws BaseException
	{
		return instructionDefinitionDAO.returnInstructionDefinitionListCount(criteria);
	}
	/**
	 * Method used to return List of InstructionDefinition
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws BaseException
	 */
	public List returnInstructionDefinitionList(InstructionDefinitionSC criteria) throws BaseException
	{
		return instructionDefinitionDAO.returnInstructionDefinitionList(criteria);
	}

	public InstructionDefinitionDAO getInstructionDefinitionDAO()
	{
		return instructionDefinitionDAO;
	}
	public void setInstructionDefinitionDAO(InstructionDefinitionDAO instructionDefinitionDAO)
	{
		this.instructionDefinitionDAO = instructionDefinitionDAO;
	}
	
	public CTS_INSTRUCTIONVO dependencyByInstructionCode(InstructionDefinitionSC criteria) throws BaseException
	{
	    return instructionDefinitionDAO.dependencyByInstructionCode(criteria);
	}
}
