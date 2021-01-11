package com.path.bo.core.nationality.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.nationality.NationalityBO;
import com.path.dao.core.nationality.NationalityDAO;
import com.path.dbmaps.vo.NATIONALITYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.nationality.NationalitySC;
import com.path.vo.core.nationalityvalid.NationalityValidSC;

public class NationalityBOImpl extends BaseBO implements NationalityBO
{
    private NationalityDAO nationalityDAO;

    @Override
    public List nationalityList(NationalitySC criteria) throws BaseException
    {
	return nationalityDAO.nationalityList(criteria);
    }

    @Override
    public int nationalityListCount(NationalitySC criteria) throws BaseException
    {
	return nationalityDAO.nationalityListCount(criteria);
    }

    public NationalityDAO getNationalityDAO()
    {
	return nationalityDAO;
    }

    public void setNationalityDAO(NationalityDAO nationalityDAO)
    {
	this.nationalityDAO = nationalityDAO;
    }

    @Override
    public NATIONALITYVO returnNationalityById(NationalitySC criteria) throws BaseException
    {
	NATIONALITYVO nationalityVO = nationalityDAO.returnNationalityById(criteria);
	if(nationalityVO == null)
	{
	   throw new BOException(MessageCodes.INVALID_MISSING_NATIONALITY);
	}
	return nationalityVO;
    }

    @Override
    public int nationalityValidListCount(NationalityValidSC criteria) throws DAOException
    {
	return nationalityDAO.nationalityValidListCount(criteria);
    }

}
