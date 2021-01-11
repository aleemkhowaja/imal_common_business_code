package com.path.dao.core.queryid;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.queryid.QueryIdCO;
import com.path.vo.core.queryid.QueryIdSC;

public interface QueryIdDAO
{

    public int getcriteriaQueryIdCount(QueryIdSC criteriaQueryIdSC) throws DAOException;

    public List<QueryIdCO> getcriteriaQueryIdList(QueryIdSC criteriaQueryIdSC) throws DAOException;

    public QueryIdCO dependencyByQueryId(QueryIdSC criteriaQueryIdSC) throws DAOException;

}
