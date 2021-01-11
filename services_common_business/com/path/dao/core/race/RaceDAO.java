package com.path.dao.core.race;

import java.util.List;

import com.path.dbmaps.vo.RACEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.race.RaceSC;

public interface RaceDAO
{
	public int raceListCount(RaceSC criteria) throws DAOException;
    public List raceList(RaceSC criteria) throws DAOException;
    public RACEVO returnRaceById(RaceSC criteria) throws DAOException;
}
