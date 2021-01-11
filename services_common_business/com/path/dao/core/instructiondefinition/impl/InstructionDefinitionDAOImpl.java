package com.path.dao.core.instructiondefinition.impl;

import java.util.List;

import com.path.dao.core.instructiondefinition.InstructionDefinitionDAO;
import com.path.dbmaps.vo.CTS_INSTRUCTIONVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.instructiondefinition.InstructionDefinitionSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionDefinitionDAOImpl.java used to
 */
public class InstructionDefinitionDAOImpl extends BaseDAO implements InstructionDefinitionDAO
{
	 /**
	 * Method used to return Count of InstructionDefinition
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws DAOException
	 */
	public int returnInstructionDefinitionListCount(InstructionDefinitionSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "instructionDefinitionMapper.resInstructionDefinitionListMap");
		return ((Integer) getSqlMap().queryForObject("instructionDefinitionMapper.returnInstructionDefinitionListCount", criteria)).intValue();
	}
	 /**
	 * Method used to return List of InstructionDefinition
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws DAOException
	 */
	public List returnInstructionDefinitionList(InstructionDefinitionSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "instructionDefinitionMapper.resInstructionDefinitionListMap");
		if(criteria.getNbRec() == -1)
		{
			return getSqlMap().queryForList("instructionDefinitionMapper.returnInstructionDefinitionList", criteria);
		}
		else
		{
			return getSqlMap().queryForList("instructionDefinitionMapper.returnInstructionDefinitionList", criteria, criteria.getRecToskip(),criteria.getNbRec());
		}
	}
	
	public CTS_INSTRUCTIONVO dependencyByInstructionCode(InstructionDefinitionSC criteria) throws DAOException
	{
	    return ((CTS_INSTRUCTIONVO) getSqlMap().queryForObject("instructionDefinitionMapper.returnInstructionDefinitionForDep", criteria));
	}
	
}
