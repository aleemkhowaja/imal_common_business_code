package com.path.dao.core.smsservices.impl;

import java.util.List;

import com.path.dao.core.smsservices.SmsServicesDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.smsservices.SmsServicesSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * SmsServicesDAOImpl.java used to
 */
public class SmsServicesDAOImpl extends BaseDAO implements SmsServicesDAO
{
/**
	 * Method used to return Lookup Count of SmsServices
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws DAOException
	 */
	public int returnSmsServicesLookupCount(SmsServicesSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "smsServicesMapper.resSmsServicesLookupMap");
		return ((Integer) getSqlMap().queryForObject("smsServicesMapper.returnSmsServicesLookupCount", criteria)).intValue();
	}
	 /**
	 * Method used to return Lookup of SmsServices
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws DAOException
	 */
	public List returnSmsServicesLookup(SmsServicesSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "smsServicesMapper.resSmsServicesLookupMap");
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("smsServicesMapper.returnSmsServicesLookup", criteria);
		}
		else
		{
		    return getSqlMap().queryForList("smsServicesMapper.returnSmsServicesLookup", criteria, criteria.getRecToskip(),criteria.getNbRec());
		}
	}
}
