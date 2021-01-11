package com.path.bo.core.cities.impl;

import java.util.List;

import com.path.bo.core.cities.CitiesBO;
import com.path.dao.core.cities.CitiesDAO;
import com.path.dbmaps.vo.CITIESVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cities.CitiesSC;

public class CitiesBOImpl extends BaseBO implements CitiesBO
{
	private CitiesDAO citiesDAO;
	@Override
	public List citiesList(CitiesSC criteria) throws BaseException
	{
		return citiesDAO.citiesList(criteria);
	}

	@Override
	public int citiesListCount(CitiesSC criteria) throws BaseException
	{
		return citiesDAO.citiesListCount(criteria);
	}

	public CitiesDAO getCitiesDAO()
	{
		return citiesDAO;
	}

	public void setCitiesDAO(CitiesDAO citiesDAO)
	{
		this.citiesDAO = citiesDAO;
	}

	@Override
	public CITIESVO returnCityById(CitiesSC criteria) throws BaseException
	{
		return citiesDAO.returnCityById(criteria);
	}

}
