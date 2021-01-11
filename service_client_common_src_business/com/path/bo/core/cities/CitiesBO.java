package com.path.bo.core.cities;

import java.util.List;

import com.path.dbmaps.vo.CITIESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cities.CitiesSC;

public interface CitiesBO
{
	public int citiesListCount(CitiesSC criteria) throws BaseException;
    public List citiesList(CitiesSC criteria) throws BaseException;
    public CITIESVO returnCityById(CitiesSC criteria) throws BaseException;

}
