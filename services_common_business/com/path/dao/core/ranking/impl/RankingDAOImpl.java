package com.path.dao.core.ranking.impl;

import java.util.List;

import com.path.dao.core.ranking.RankingDAO;
import com.path.dbmaps.vo.RIFPCTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.ranking.RankingSC;

public class RankingDAOImpl extends BaseDAO implements RankingDAO
{

    @Override
    public List rankingList(RankingSC rankingSC) throws DAOException
    {
	if(rankingSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("rankingMapper.rankingList", rankingSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(rankingSC, getSqlMap(), "rankingMapper.rankingList_ResMap");
	    return getSqlMap().queryForList("rankingMapper.rankingList", rankingSC, rankingSC.getRecToskip(),
		    rankingSC.getNbRec());
	}
    }

    @Override
    public int rankingListCount(RankingSC rankingSC) throws DAOException
    {
	DAOHelper.fixGridMaps(rankingSC, getSqlMap(), "rankingMapper.rankingList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("rankingMapper.rankingListCount", rankingSC)).intValue();
	return nb;
    }

	@Override
	public RIFPCTVO returnRankingById(RankingSC rankingSC) throws DAOException
	{
		return (RIFPCTVO) getSqlMap().queryForObject("rankingMapper.returnRankingById", rankingSC);
	}

}
