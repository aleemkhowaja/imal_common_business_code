package com.path.bo.core.division.impl;

import java.util.List;

import com.path.bo.core.division.DivisionBO;
import com.path.dao.core.division.DivisionDAO;
import com.path.dbmaps.vo.DIVISIONSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.division.DivisionSC;

public class DivisionBOImpl extends BaseBO implements DivisionBO
{

    private DivisionDAO divisionDAO;

    public DivisionDAO getDivisionDAO()
    {
	return divisionDAO;
    }

    public void setDivisionDAO(DivisionDAO divisionDAO)
    {
	this.divisionDAO = divisionDAO;
    }

    @Override
    public List divisionList(DivisionSC divisionSC) throws BaseException
    {
	return divisionDAO.divisionList(divisionSC);
    }

    @Override
    public int divisionListCount(DivisionSC divisionSC) throws BaseException
    {
	return divisionDAO.divisionListCount(divisionSC);
    }

	@Override
	public DIVISIONSVO returnDivisionById(DivisionSC criteria) throws BaseException
	{
		return (DIVISIONSVO) divisionDAO.returnDivisionById(criteria);
	}

}
