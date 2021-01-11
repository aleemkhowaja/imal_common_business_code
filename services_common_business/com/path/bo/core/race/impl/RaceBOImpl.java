package com.path.bo.core.race.impl;

import java.util.List;

import com.path.bo.core.race.RaceBO;
import com.path.dao.core.race.RaceDAO;
import com.path.dbmaps.vo.RACEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.race.RaceSC;

public class RaceBOImpl extends BaseBO implements RaceBO
{
	private RaceDAO raceDAO;
	@Override
	public List raceList(RaceSC criteria) throws BaseException
	{
		return raceDAO.raceList(criteria);
	}

	@Override
	public int raceListCount(RaceSC criteria) throws BaseException
	{
		return raceDAO.raceListCount(criteria);
	}

	public RaceDAO getRaceDAO()
	{
		return raceDAO;
	}

	public void setRaceDAO(RaceDAO raceDAO)
	{
		this.raceDAO = raceDAO;
	}

	@Override
	public RACEVO returnRaceById(RaceSC criteria) throws BaseException
	{
		return (RACEVO) raceDAO.returnRaceById(criteria);
	}

}
