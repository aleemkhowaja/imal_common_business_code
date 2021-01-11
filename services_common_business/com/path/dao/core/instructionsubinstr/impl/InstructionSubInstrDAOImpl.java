package com.path.dao.core.instructionsubinstr.impl;

import java.util.List;

import com.path.dao.core.instructionsubinstr.InstructionSubInstrDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.instructionsubinstr.InstructionSubInstrCO;
import com.path.vo.core.instructionsubinstr.InstructionSubInstrSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionSubInstrDAOImpl.java used to
 */
public class InstructionSubInstrDAOImpl extends BaseDAO implements InstructionSubInstrDAO
{
	 /**
	 * Method used to return Count of InstructionSubInstr
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws DAOException
	 */
	public int returnInstructionSubInstrListCount(InstructionSubInstrSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "instructionSubInstrMapper.resInstructionSubInstrListMap");
		return ((Integer) getSqlMap().queryForObject("instructionSubInstrMapper.returnInstructionSubInstrListCount", criteria)).intValue();
	}
	 /**
	 * Method used to return List of InstructionSubInstr
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws DAOException
	 */
	public List returnInstructionSubInstrList(InstructionSubInstrSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "instructionSubInstrMapper.resInstructionSubInstrListMap");
		if(criteria.getNbRec() == -1)
		{
			return getSqlMap().queryForList("instructionSubInstrMapper.returnInstructionSubInstrList", criteria);
		}
		else
		{
			return getSqlMap().queryForList("instructionSubInstrMapper.returnInstructionSubInstrList", criteria, criteria.getRecToskip(),criteria.getNbRec());
		}
	}
	
	public InstructionSubInstrCO dependencyByInstrSubInstrCode(InstructionSubInstrSC criteria) throws DAOException
	{
	    return (InstructionSubInstrCO) sqlMap.queryForObject("instructionSubInstrMapper.returnSubInstructionForDep", criteria);
	}
	
}
