package com.path.dao.core.instructiondefinition;

import java.util.List;

import com.path.dbmaps.vo.CTS_INSTRUCTIONVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.instructiondefinition.InstructionDefinitionSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionDefinitionDAO.java used to
 */
public interface InstructionDefinitionDAO 
{
	public int returnInstructionDefinitionListCount(InstructionDefinitionSC criteria) throws DAOException;
	public List returnInstructionDefinitionList(InstructionDefinitionSC criteria) throws DAOException;
	public CTS_INSTRUCTIONVO dependencyByInstructionCode(InstructionDefinitionSC criteria) throws DAOException;
}