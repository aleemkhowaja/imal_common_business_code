package com.path.bo.core.religion.impl;

import java.util.List;

import com.path.bo.core.religion.ReligionBO;
import com.path.dao.core.religion.ReligionDAO;
import com.path.dbmaps.vo.RELIGIONVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.religion.ReligionSC;

public class ReligionBOImpl extends BaseBO implements ReligionBO
{
	private ReligionDAO religionDAO;
	@Override
	public List religionList(ReligionSC criteria) throws BaseException
	{
		return religionDAO.religionList(criteria);
	}

	@Override
	public int religionListCount(ReligionSC criteria) throws BaseException
	{
		return religionDAO.religionListCount(criteria);
	}

	public ReligionDAO getReligionDAO()
	{
		return religionDAO;
	}

	public void setReligionDAO(ReligionDAO religionDAO)
	{
		this.religionDAO = religionDAO;
	}

	@Override
	public RELIGIONVO returnReligionById(ReligionSC criteria) throws BaseException
	{
		return (RELIGIONVO) religionDAO.returnReligionById(criteria);
	}

}
