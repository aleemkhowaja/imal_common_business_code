package com.path.dao.core.fmsfundlimit.impl;

import java.util.List;

import com.path.dao.core.fmsfundlimit.FmsFundLimitDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.fmsfundlimit.FmsFundLimitSC;

public class FmsFundLimitDAOImpl extends BaseDAO implements FmsFundLimitDAO
{

    @Override
    public int fmsFundLimitListCount(FmsFundLimitSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "fmsFundLimitMapper.fmsFundLimitListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("fmsFundLimitMapper.fmsFundLimitListCount", criteria)).intValue();
	return nb;
}

    @Override
    public List fmsFundLimitList(FmsFundLimitSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "fmsFundLimitMapper.fmsFundLimitListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("fmsFundLimitMapper.fmsFundLimitList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("fmsFundLimitMapper.fmsFundLimitList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
}

}
