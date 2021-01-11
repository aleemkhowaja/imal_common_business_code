package com.path.dao.core.cifrelation.impl;

import java.util.List;

import com.path.dao.core.cifrelation.CifRelationDAO;
import com.path.dbmaps.vo.RELATION_BETWEEN_CIFSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cifrelation.CifRelationSC;

public class CifRelationDAOImpl extends BaseDAO implements CifRelationDAO
{

    @Override
    public List cifRelationList(CifRelationSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifRelationMapper.cifRelationList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifRelationMapper.cifRelationListMap");
	    return getSqlMap().queryForList("cifRelationMapper.cifRelationList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int cifRelationListCount(CifRelationSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifRelationMapper.cifRelationListMap");
	return ((Integer) getSqlMap().queryForObject("cifRelationMapper.cifRelationListCount", criteria)).intValue();
    }

    @Override
    public RELATION_BETWEEN_CIFSVO returnCifRelationByCode(CifRelationSC criteria) throws DAOException
    {
	return (RELATION_BETWEEN_CIFSVO) getSqlMap().queryForObject("cifRelationMapper.returnCifRelationByCode",
		criteria);
    }

}
