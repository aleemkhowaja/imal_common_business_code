package com.path.dao.core.queryid.impl;

import java.util.List;

import com.path.dao.core.queryid.QueryIdDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.queryid.QueryIdCO;
import com.path.vo.core.queryid.QueryIdSC;

public class QueryIdDAOImpl extends BaseDAO implements QueryIdDAO
{

    public int getcriteriaQueryIdCount(QueryIdSC queryIdSC) throws DAOException
    {
	DAOHelper.fixGridMaps(queryIdSC, getSqlMap(), "CTSCRITERIAQUERY_IDMapper.getIdList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("CTSCRITERIAQUERY_IDMapper.getIdCount", queryIdSC))
		.intValue();
	return nb;
    }

    public List<QueryIdCO> getcriteriaQueryIdList(QueryIdSC queryIdSC) throws DAOException
    {
	DAOHelper.fixGridMaps(queryIdSC, getSqlMap(), "CTSCRITERIAQUERY_IDMapper.getIdList_ResMap");
	if(queryIdSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("CTSCRITERIAQUERY_IDMapper.getIdList", queryIdSC);
	}
	else
	{
	    return getSqlMap().queryForList("CTSCRITERIAQUERY_IDMapper.getIdList", queryIdSC,
		    queryIdSC.getRecToskip(), queryIdSC.getNbRec());
	}
    }

    public QueryIdCO dependencyByQueryId(QueryIdSC queryIdSC) throws DAOException
    {
	return (QueryIdCO) getSqlMap().queryForObject("CTSCRITERIAQUERY_IDMapper.getQueryId",
		queryIdSC);
    }
}
