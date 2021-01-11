package com.path.bo.common.reservedcif.impl;

import java.util.List;

import com.path.bo.common.reservedcif.ReservedCifBO;
import com.path.dao.common.reservedcif.ReservedCifDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.reservedcif.ReservedCifSC;

public class ReservedCifBOImpl extends BaseBO implements ReservedCifBO
{
    ReservedCifDAO reservedCifDAO;

    @Override
    public List getReservedCifList(ReservedCifSC criteria) throws BaseException
    {
	return reservedCifDAO.getReservedCifList(criteria);
    }

    @Override
    public int getReservedCifListCount(ReservedCifSC criteria) throws BaseException
    {
	return reservedCifDAO.getReservedCifListCount(criteria);
    }

    public ReservedCifDAO getReservedCifDAO()
    {
	return reservedCifDAO;
    }

    public void setReservedCifDAO(ReservedCifDAO reservedCifDAO)
    {
	this.reservedCifDAO = reservedCifDAO;
    }

    @Override
    public int returnReservedCifCount(ReservedCifSC criteria) throws BaseException
    {
	return reservedCifDAO.returnReservedCifCount(criteria);
    }

}
