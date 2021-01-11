package com.path.dao.core.ctsbatch.impl;

import java.util.List;

import com.path.dao.core.ctsbatch.CtsBatchDAO;
import com.path.dbmaps.vo.CTSBATCHVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.ctsbatch.CtsBatchSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: EliasAoun
 * 
 *          CtsBatchDAOImpl.java used to
 */
public class CtsBatchDAOImpl extends BaseDAO implements CtsBatchDAO
{

    @Override
    public Integer batchLookupCount(CtsBatchSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), null);
	return (Integer) getSqlMap().queryForObject("CTSBATCHMapper.batchLookupCount", criteria);
    }

    @Override
    public List<CTSBATCHVO> batchLookupList(CtsBatchSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), null);
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("CTSBATCHMapper.batchLookupList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("CTSBATCHMapper.batchLookupList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

}
