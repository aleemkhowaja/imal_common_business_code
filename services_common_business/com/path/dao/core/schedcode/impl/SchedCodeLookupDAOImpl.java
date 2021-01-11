package com.path.dao.core.schedcode.impl;

import java.util.List;

import com.path.dao.core.schedcode.SchedCodeLookupDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.schedcode.SchedCodeLookupCO;
import com.path.vo.core.schedcode.SchedCodeLookupSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 */
public class SchedCodeLookupDAOImpl extends BaseDAO implements SchedCodeLookupDAO
{
    @Override
    public int returnSchedCodeLookupCount(SchedCodeLookupSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "schedCodeLookupMapper.resSchedCodeLookupMap");
	return ((Integer) getSqlMap().queryForObject("schedCodeLookupMapper.returnSchedCodeLookupCount", criteria))
		.intValue();
    }

    @Override
    public List<SchedCodeLookupCO> returnSchedCodeLookupList(SchedCodeLookupSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "schedCodeLookupMapper.resSchedCodeLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("schedCodeLookupMapper.returnSchedCodeLookupList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("schedCodeLookupMapper.returnSchedCodeLookupList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }
}
