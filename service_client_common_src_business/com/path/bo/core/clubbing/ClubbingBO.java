package com.path.bo.core.clubbing;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.clubbing.ClubbingCO;
import com.path.vo.core.clubbing.ClubbingSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ClubbingBO.java used to
 */
public interface ClubbingBO 
{
	public int returnClubbingLookupCount(ClubbingSC criteria) throws BaseException;
	public List returnClubbingLookup(ClubbingSC criteria) throws BaseException;
	public ClubbingCO dependencyForClubbing(ClubbingSC criteria) throws BaseException;
	public int returnClubbedAccLookupCount(ClubbingSC criteria) throws BaseException;
	public List returnClubbedAccLookup(ClubbingSC criteria) throws BaseException;
	public ClubbingCO dependencyForClubbedAcc(ClubbingSC criteria) throws BaseException;

}