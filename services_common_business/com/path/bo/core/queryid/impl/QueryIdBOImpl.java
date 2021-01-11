package com.path.bo.core.queryid.impl;

import java.util.List;

import com.path.bo.core.queryid.QueryIdBO;
import com.path.dao.core.queryid.QueryIdDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.queryid.QueryIdCO;
import com.path.vo.core.queryid.QueryIdSC;

public class QueryIdBOImpl extends BaseBO implements QueryIdBO
{

    private QueryIdDAO queryIdDAO;

    public int getcriteriaQueryIdCount(QueryIdSC queryIdSC) throws BaseException
    {
	return queryIdDAO.getcriteriaQueryIdCount(queryIdSC);
    }

    public List<QueryIdCO> getcriteriaQueryIdList(QueryIdSC queryIdSC) throws BaseException
    {
	return queryIdDAO.getcriteriaQueryIdList(queryIdSC);
    }

    public QueryIdDAO getQueryIdDAO()
    {
	return queryIdDAO;
    }

    public void setQueryIdDAO(QueryIdDAO queryIdDAO)
    {
	this.queryIdDAO = queryIdDAO;
    }

    public QueryIdCO dependencyByQueryId(QueryIdSC queryIdSC) throws BaseException
    {
	return queryIdDAO.dependencyByQueryId(queryIdSC);
    }


}
