package com.path.dao.core.race.impl;

import java.util.List;

import com.path.dao.core.race.RaceDAO;
import com.path.dbmaps.vo.RACEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.race.RaceSC;

public class RaceDAOImpl extends BaseDAO implements RaceDAO
{

	@Override
	public List raceList(RaceSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("raceMapper.raceList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "raceMapper.raceListMap");
		    return getSqlMap().queryForList("raceMapper.raceList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int raceListCount(RaceSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "raceMapper.raceListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("raceMapper.raceListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public RACEVO returnRaceById(RaceSC criteria) throws DAOException
	{
		return (RACEVO) getSqlMap().queryForObject("raceMapper.returnRaceById", criteria);
	}

}
