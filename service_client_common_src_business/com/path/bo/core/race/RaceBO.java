package com.path.bo.core.race;

import java.util.List;

import com.path.dbmaps.vo.RACEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.race.RaceSC;

public interface RaceBO
{
	public int raceListCount(RaceSC criteria) throws BaseException;
    public List raceList(RaceSC criteria) throws BaseException;
    public RACEVO returnRaceById(RaceSC criteria) throws BaseException;
}
