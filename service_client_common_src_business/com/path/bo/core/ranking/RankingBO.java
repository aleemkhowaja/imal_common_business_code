package com.path.bo.core.ranking;

import java.util.List;

import com.path.dbmaps.vo.RIFPCTVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.ranking.RankingSC;

public interface RankingBO
{
    public int rankingListCount(RankingSC rankingSC) throws BaseException;

    public List rankingList(RankingSC rankingSC) throws BaseException;
    
    public RIFPCTVO returnRankingById(RankingSC rankingSC) throws BaseException;

}
