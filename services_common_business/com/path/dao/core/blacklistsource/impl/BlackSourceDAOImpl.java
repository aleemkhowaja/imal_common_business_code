package com.path.dao.core.blacklistsource.impl;

import java.util.List;

import com.path.dao.core.blacklistsource.BlackSourceDAO;
import com.path.dbmaps.vo.MOSBLACKSOURCEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.blacklistsource.BlackSourceSC;

public class BlackSourceDAOImpl extends BaseDAO implements BlackSourceDAO
{

	@Override
	public List blackSourceList(BlackSourceSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("blackSourceMapper.blacksourceList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "MOSBLACKSOURCE.BaseResultMap");
		    return getSqlMap().queryForList("blackSourceMapper.blacksourceList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int blackSourceListCount(BlackSourceSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "MOSBLACKSOURCE.BaseResultMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("blackSourceMapper.blacksourceListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public MOSBLACKSOURCEVO returnBlackSourceById(BlackSourceSC criteria) throws DAOException
	{
		return (MOSBLACKSOURCEVO) getSqlMap().queryForObject("blackSourceMapper.returnBlackSourceById", criteria);
	}

}
