package com.path.dao.core.nationality;

import java.util.List;

import com.path.dbmaps.vo.NATIONALITYVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.nationality.NationalitySC;
import com.path.vo.core.nationalityvalid.NationalityValidSC;

public interface NationalityDAO
{
	public int nationalityListCount(NationalitySC criteria) throws DAOException;
    public List nationalityList(NationalitySC criteria) throws DAOException;
    public NATIONALITYVO returnNationalityById(NationalitySC criteria) throws DAOException;
    public int nationalityValidListCount(NationalityValidSC criteria) throws DAOException;
}
