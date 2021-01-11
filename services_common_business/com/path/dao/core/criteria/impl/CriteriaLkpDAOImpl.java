package com.path.dao.core.criteria.impl;

import java.util.List;

import com.path.dao.core.criteria.CriteriaLkpDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.struts2.lib.common.GridParamsSC;

public class CriteriaLkpDAOImpl extends BaseDAO implements CriteriaLkpDAO
{
    @Override
    public int returnCriteriaLookupCount(GridParamsSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "criteriaLookupMapper.criteriaLookupMap");
	return ((Integer) getSqlMap().queryForObject("criteriaLookupMapper.returnCriteriaLookupCount", criteria))
		.intValue();
    }

    @Override
    public List returnCriteriaLookup(GridParamsSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "criteriaLookupMapper.criteriaLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("criteriaLookupMapper.returnCriteriaLookup", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("criteriaLookupMapper.returnCriteriaLookup", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }
}