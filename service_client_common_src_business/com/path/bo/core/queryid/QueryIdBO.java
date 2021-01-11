package com.path.bo.core.queryid;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.queryid.QueryIdCO;
import com.path.vo.core.queryid.QueryIdSC;

public interface QueryIdBO

{
    public int getcriteriaQueryIdCount(QueryIdSC queryIdSC) throws BaseException;

    public List<QueryIdCO> getcriteriaQueryIdList(QueryIdSC queryIdSC) throws BaseException;

    public QueryIdCO dependencyByQueryId(QueryIdSC queryIdSC) throws BaseException;

}
