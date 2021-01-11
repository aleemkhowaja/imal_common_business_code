package com.path.bo.core.occupation.impl;

import java.util.List;

import com.path.bo.core.occupation.OccupationBO;
import com.path.dao.core.occupation.OccupationDAO;
import com.path.dbmaps.vo.CIF_OCCUPATIONVO;
import com.path.dbmaps.vo.OCCUPATIONSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.occupation.OccupationSC;

public class OccupationBOImpl extends BaseBO implements OccupationBO
{
    private OccupationDAO occupationDAO;

    public OccupationDAO getOccupationDAO()
    {
	return occupationDAO;
    }

    public void setOccupationDAO(OccupationDAO occupationDAO)
    {
	this.occupationDAO = occupationDAO;
    }

    @Override
    public List occupationList(OccupationSC occupationSC) throws BaseException
    {
	return occupationDAO.occupationList(occupationSC);
    }

    @Override
    public int occupationListCount(OccupationSC occupationSC) throws BaseException
    {
	return occupationDAO.occupationListCount(occupationSC);
    }

	@Override
	public OCCUPATIONSVO returnOccupationById(OccupationSC occupationSC) throws BaseException
	{
		return (OCCUPATIONSVO) occupationDAO.returnOccupationById(occupationSC);
	}

	@Override
	public List cifOccupationStatusList(OccupationSC occupationSC) throws BaseException
	{
		return occupationDAO.cifOccupationStatusList(occupationSC);
	}

	@Override
	public int cifOccupationStatusListCount(OccupationSC occupationSC) throws BaseException
	{
		return occupationDAO.cifOccupationStatusListCount(occupationSC);
	}

	@Override
	public CIF_OCCUPATIONVO returnCifOccupationStatus(OccupationSC occupationSC) throws BaseException
	{
		return (CIF_OCCUPATIONVO) occupationDAO.returnCifOccupationStatus(occupationSC);
	}

}
