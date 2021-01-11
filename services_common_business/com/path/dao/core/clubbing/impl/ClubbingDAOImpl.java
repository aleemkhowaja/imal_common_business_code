package com.path.dao.core.clubbing.impl;

import java.util.List;

import com.path.dao.core.clubbing.ClubbingDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.clubbing.ClubbingCO;
import com.path.vo.core.clubbing.ClubbingSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ClubbingDAOImpl.java used to
 */
public class ClubbingDAOImpl extends BaseDAO implements ClubbingDAO
{
/**
	 * Method used to return Lookup Count of Clubbing
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws DAOException
	 */
	public int returnClubbingLookupCount(ClubbingSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "clubbingMapper.resClubbingLookupMap");
		return ((Integer) getSqlMap().queryForObject("clubbingMapper.returnClubbingLookupCount", criteria)).intValue();
	}
	 /**
	 * Method used to return Lookup of Clubbing
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws DAOException
	 */
	public List returnClubbingLookup(ClubbingSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "clubbingMapper.resClubbingLookupMap");
		if(criteria.getNbRec() == -1)
		{
			return getSqlMap().queryForList("clubbingMapper.returnClubbingLookup", criteria);
		}
		else
		{
			return getSqlMap().queryForList("clubbingMapper.returnClubbingLookup", criteria, criteria.getRecToskip(),criteria.getNbRec());
		}
	}
	/**
	 * Method used to return dependency for Clubbing
	 * @param criteria Search Criteria Parameter
	 * @return ClubbingCO Result Object
	 * @throws DAOException
	 */
	public ClubbingCO dependencyForClubbing(ClubbingSC criteria) throws DAOException
	{
		return (ClubbingCO) getSqlMap().queryForObject("clubbingMapper.dependencyForClubbing", criteria);
		
	}
	@Override
	public int returnClubbedAccLookupCount(ClubbingSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "clubbingMapper.resClubbedAccLookupMap");
		return ((Integer) getSqlMap().queryForObject("clubbingMapper.returnClubbedAccLookupCount", criteria)).intValue();
	    }
	@Override
	public List returnClubbedAccLookup(ClubbingSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "clubbingMapper.resClubbedAccLookupMap");
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("clubbingMapper.returnClubbedAccLookup", criteria);
		}
		else
		{
		    return getSqlMap().queryForList("clubbingMapper.returnClubbedAccLookup", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	    }
	@Override
	public ClubbingCO dependencyForClubbedAcc(ClubbingSC criteria) throws DAOException
	{
	    return (ClubbingCO) getSqlMap().queryForObject("clubbingMapper.dependencyForClubbedAcc", criteria);
		}
}
