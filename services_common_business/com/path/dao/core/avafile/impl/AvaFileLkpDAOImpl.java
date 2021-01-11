package com.path.dao.core.avafile.impl;

import java.util.List;

import com.path.dao.core.avafile.AvaFileLkpDAO;
import com.path.dbmaps.vo.CTS_AVA_FILEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.avafile.AvaFileLkpSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryDAOImpl.java used to
 */
public class AvaFileLkpDAOImpl extends BaseDAO implements AvaFileLkpDAO
{
    /**
     * Method used to return Lookup Count of AvaCategory
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws DAOException
     */	       	
    public int returnAvaFileLookupCount(AvaFileLkpSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaFileLkpMapper.resAvaFileLookupMap");
	return ((Integer) getSqlMap().queryForObject("avaFileLkpMapper.returnAvaFileLookupCount", criteria))
		.intValue();
    }

    /**
     * Method used to return Lookup of AvaCategory
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws DAOException
     */
    public List returnAvaFileLookup(AvaFileLkpSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaFileLkpMapper.resAvaFileLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("avaFileLkpMapper.returnAvaFileLookup", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("avaFileLkpMapper.returnAvaFileLookup", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    /**
     * Method used to return dependency for AvaCategory
     * 
     * @param criteria Search Criteria Parameter
     * @return AvaCategoryCO Result Object
     * @throws DAOException
     */
    public CTS_AVA_FILEVO dependencyForAvaFile(AvaFileLkpSC criteria) throws DAOException
    {
	return (CTS_AVA_FILEVO) getSqlMap().queryForObject("avaFileLkpMapper.dependencyForAvaFile", criteria);
    }
}
