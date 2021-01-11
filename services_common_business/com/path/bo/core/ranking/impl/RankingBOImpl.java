package com.path.bo.core.ranking.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.ranking.RankingBO;
import com.path.dao.core.ranking.RankingDAO;
import com.path.dbmaps.vo.LEGAL_STATUSVO;
import com.path.dbmaps.vo.RIFPCTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.ranking.RankingSC;

public class RankingBOImpl extends BaseBO implements RankingBO
{

    private RankingDAO rankingDAO;

    public RankingDAO getRankingDAO()
    {
	return rankingDAO;
    }

    public void setRankingDAO(RankingDAO rankingDAO)
    {
	this.rankingDAO = rankingDAO;
    }

    @Override
    public List rankingList(RankingSC rankingSC) throws BaseException
    {
	return rankingDAO.rankingList(rankingSC);
    }

    @Override
    public int rankingListCount(RankingSC rankingSC) throws BaseException
    {
	return rankingDAO.rankingListCount(rankingSC);
    }

    public RIFPCTVO returnRankingById(RankingSC rankingSC) throws BaseException
    {
    	RIFPCTVO rifpctVO = rankingDAO.returnRankingById(rankingSC);
    	if(rifpctVO == null && rankingSC.getCifType() != null)
    	{
    	    throw new BOException(MessageCodes.INVALID_MISSING_RANKING_CODE);
    	}
    	return rifpctVO;
    }

}
