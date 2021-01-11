package com.path.dao.core.ranking;

import java.util.List;

import com.path.dbmaps.vo.RIFPCTVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.ranking.RankingSC;

public interface RankingDAO
{
    public int rankingListCount(RankingSC rankingSC) throws DAOException;

    public List rankingList(RankingSC rankingSC) throws DAOException;
    
    public RIFPCTVO returnRankingById(RankingSC rankingSC) throws DAOException;

}
