package com.path.dao.core.avacategory.impl;

import java.util.List;

import com.path.dao.core.avacategory.AvaCategoryDAO;
import com.path.dbmaps.vo.CTS_AVA_CATEGVO;
import com.path.dbmaps.vo.CTS_AVA_CATEG_PAY_LIMITVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.avacategory.AvaCategorySC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryDAOImpl.java used to
 */
public class AvaCategoryDAOImpl extends BaseDAO implements AvaCategoryDAO
{
    /**
     * Method used to return Lookup Count of AvaCategory
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws DAOException
     */
    public int returnAvaCategoryLookupCount(AvaCategorySC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaCategoryMapper.resAvaCategoryLookupMap");
	return ((Integer) getSqlMap().queryForObject("avaCategoryMapper.returnAvaCategoryLookupCount", criteria))
		.intValue();
    }

    /**
     * Method used to return Lookup of AvaCategory
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws DAOException
     */
    public List returnAvaCategoryLookup(AvaCategorySC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaCategoryMapper.resAvaCategoryLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("avaCategoryMapper.returnAvaCategoryLookup", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("avaCategoryMapper.returnAvaCategoryLookup", criteria,
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
    public CTS_AVA_CATEGVO dependencyForAvaCategory(AvaCategorySC criteria) throws DAOException
    {
	return (CTS_AVA_CATEGVO) getSqlMap().queryForObject("avaCategoryMapper.dependencyForAvaCategory", criteria);
    }
    
    public CTS_AVA_CATEG_PAY_LIMITVO returnAvaCategoryPayLimit(AvaCategorySC criteria) throws DAOException
    {
	return (CTS_AVA_CATEG_PAY_LIMITVO) getSqlMap().queryForObject("avaCategoryMapper.returnAvaCategoryPayLimit", criteria);
    }
}
