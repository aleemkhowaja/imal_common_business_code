package com.path.dao.core.registrationcenter.impl;

import java.util.List;

import com.path.dao.core.registrationcenter.RegistrationCenterDAO;
import com.path.dbmaps.vo.CTS_REGISTER_CENTERVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.registrationcenter.RegistrationCenterSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * RegistrationCenterDAOImpl.java used to
 */
public class RegistrationCenterDAOImpl extends BaseDAO implements RegistrationCenterDAO
{
	 /**
	 * Method used to return Count of RegistrationCenter
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws DAOException
	 */
	public int returnRegistrationCenterListCount(RegistrationCenterSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "registrationCenterMapper.resRegistrationCenterListMap");
		return ((Integer) getSqlMap().queryForObject("registrationCenterMapper.returnRegistrationCenterListCount", criteria)).intValue();
	}
	 /**
	 * Method used to return List of RegistrationCenter
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws DAOException
	 */
	public List returnRegistrationCenterList(RegistrationCenterSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "registrationCenterMapper.resRegistrationCenterListMap");
		if(criteria.getNbRec() == -1)
		{
			return getSqlMap().queryForList("registrationCenterMapper.returnRegistrationCenterList", criteria);
		}
		else
		{
			return getSqlMap().queryForList("registrationCenterMapper.returnRegistrationCenterList", criteria, criteria.getRecToskip(),criteria.getNbRec());
		}
	}
	
	public CTS_REGISTER_CENTERVO dependencyByRegCode(RegistrationCenterSC criteria) throws DAOException
	{
	    return ((CTS_REGISTER_CENTERVO) getSqlMap().queryForObject("registrationCenterMapper.returnRegistrationCenterForDep", criteria));
	}
}
