package com.path.dao.core.cities;

import java.util.List;

import com.path.dbmaps.vo.CITIESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cities.CitiesSC;

public interface CitiesDAO
{
	public int citiesListCount(CitiesSC criteria) throws DAOException;
    public List citiesList(CitiesSC criteria) throws DAOException;
    public CITIESVO returnCityById(CitiesSC criteria) throws DAOException;
}

