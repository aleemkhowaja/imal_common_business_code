package com.path.dao.core.cities.impl;

import java.util.List;

import com.path.dao.core.cities.CitiesDAO;
import com.path.dbmaps.vo.CITIESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cities.CitiesSC;

public class CitiesDAOImpl extends BaseDAO implements CitiesDAO
{

	@Override
	public List citiesList(CitiesSC criteria) throws DAOException
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "citiesMapper.citiesListMap");
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("citiesMapper.citiesList", criteria);
		}
		else
		{
		    return getSqlMap().queryForList("citiesMapper.citiesList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int citiesListCount(CitiesSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "citiesMapper.citiesListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("citiesMapper.citiesListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public CITIESVO returnCityById(CitiesSC criteria) throws DAOException
	{
		return (CITIESVO) getSqlMap().queryForObject("citiesMapper.returnCitiesById", criteria);
	}

}
