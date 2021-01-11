package com.path.dao.core.educationnature.impl;

import java.util.List;

import com.path.dao.core.educationnature.EducationNatureDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.educationnature.EducationNatureCO;
import com.path.vo.core.educationnature.EducationNatureSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * EducationNatureDAOImpl.java used to
 */
public class EducationNatureDAOImpl extends BaseDAO implements EducationNatureDAO
{
/**
	 * Method used to return Lookup Count of EducationNature
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws DAOException
	 */
	public int returnEducationNatureLookupCount(EducationNatureSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "educationNatureMapper.resEducationNatureLookupMap");
		return ((Integer) getSqlMap().queryForObject("educationNatureMapper.returnEducationNatureLookupCount", criteria)).intValue();
	}
	 /**
	 * Method used to return Lookup of EducationNature
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws DAOException
	 */
	public List returnEducationNatureLookup(EducationNatureSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "educationNatureMapper.resEducationNatureLookupMap");
		if(criteria.getNbRec() == -1)
		{
			return getSqlMap().queryForList("educationNatureMapper.returnEducationNatureLookup", criteria);
		}
		else
		{
			return getSqlMap().queryForList("educationNatureMapper.returnEducationNatureLookup", criteria, criteria.getRecToskip(),criteria.getNbRec());
		}
	}
	/**
	 * Method used to return dependency for EducationNature
	 * @param criteria Search Criteria Parameter
	 * @return EducationNatureCO Result Object
	 * @throws DAOException
	 */
	public EducationNatureCO dependencyByEducationNature(EducationNatureSC criteria) throws DAOException
	{
		return (EducationNatureCO) getSqlMap().queryForObject("educationNatureMapper.dependencyByEducationNature", criteria);
	}
}
