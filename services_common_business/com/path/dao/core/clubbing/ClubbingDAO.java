package com.path.dao.core.clubbing;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.clubbing.ClubbingCO;
import com.path.vo.core.clubbing.ClubbingSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ClubbingDAO.java used to
 */
public interface ClubbingDAO 
{
	public int returnClubbingLookupCount(ClubbingSC criteria) throws DAOException;
	public List returnClubbingLookup(ClubbingSC criteria) throws DAOException;
	public ClubbingCO dependencyForClubbing(ClubbingSC criteria) throws DAOException;
	public int returnClubbedAccLookupCount(ClubbingSC criteria) throws DAOException;
	public List returnClubbedAccLookup(ClubbingSC criteria) throws DAOException;
	public ClubbingCO dependencyForClubbedAcc(ClubbingSC criteria) throws DAOException;
	
}