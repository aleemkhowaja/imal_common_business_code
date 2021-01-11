package com.path.bo.core.clubbing.impl;

import java.util.List;

import com.path.bo.core.clubbing.ClubbingBO;
import com.path.dao.core.clubbing.ClubbingDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.clubbing.ClubbingCO;
import com.path.vo.core.clubbing.ClubbingSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ClubbingBOImpl.java used to
 */
public class ClubbingBOImpl extends BaseBO implements ClubbingBO
{
	ClubbingDAO clubbingDAO;
	/**
	 * Method used to return Lookup Count of Clubbing
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws BaseException
	 */	
	public int returnClubbingLookupCount(ClubbingSC criteria) throws BaseException
	{
		return clubbingDAO.returnClubbingLookupCount(criteria);
	}
	/**
	 * Method used to return Lookup List of Clubbing
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws BaseException
	 */
	public List returnClubbingLookup(ClubbingSC criteria) throws BaseException
	{
		return clubbingDAO.returnClubbingLookup(criteria);
	}
	/**
	 * Method used to return dependency of Clubbing
	 * @param criteria Search Criteria Parameter
	 * @return ClubbingCO Result object for dependency
	 * @throws BaseException
	 */
	public ClubbingCO dependencyForClubbing(ClubbingSC criteria) throws BaseException
	{
		return clubbingDAO.dependencyForClubbing(criteria);
	}
	public ClubbingDAO getClubbingDAO()
	{
		return clubbingDAO;
	}
	public void setClubbingDAO(ClubbingDAO clubbingDAO)
	{
		this.clubbingDAO = clubbingDAO;
	}
	@Override
	public int returnClubbedAccLookupCount(ClubbingSC criteria) throws BaseException
	{
	    return clubbingDAO.returnClubbedAccLookupCount(criteria);
	}
	@Override
	public List returnClubbedAccLookup(ClubbingSC criteria) throws BaseException
	{
	    return clubbingDAO.returnClubbedAccLookup(criteria);
	}
	@Override
	public ClubbingCO dependencyForClubbedAcc(ClubbingSC criteria) throws BaseException
	{
	    return clubbingDAO.dependencyForClubbedAcc(criteria);
	}
}
