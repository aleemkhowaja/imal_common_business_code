package com.path.bo.core.nationality;

import java.util.List;

import com.path.dbmaps.vo.NATIONALITYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.nationality.NationalitySC;
import com.path.vo.core.nationalityvalid.NationalityValidSC;

public interface NationalityBO
{
	public int nationalityListCount(NationalitySC criteria) throws BaseException;
    public List nationalityList(NationalitySC criteria) throws BaseException;
    public NATIONALITYVO returnNationalityById(NationalitySC criteria) throws BaseException;
    public int nationalityValidListCount(NationalityValidSC criteria) throws DAOException;
}
