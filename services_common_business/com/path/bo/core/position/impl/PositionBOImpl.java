package com.path.bo.core.position.impl;

import java.util.List;

import com.path.bo.core.position.PositionBO;
import com.path.dao.core.position.PositionDAO;
import com.path.dbmaps.vo.POSITIONSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.position.PositionSC;

public class PositionBOImpl extends BaseBO implements PositionBO
{
    private PositionDAO positionDAO;

    public PositionDAO getPositionDAO()
    {
	return positionDAO;
    }

    public void setPositionDAO(PositionDAO positionDAO)
    {
	this.positionDAO = positionDAO;
    }

    @Override
    public List positionList(PositionSC positionSC) throws BaseException
    {
	return positionDAO.positionList(positionSC);
    }

    @Override
    public int positionListCount(PositionSC positionSC) throws BaseException
    {
	return positionDAO.positionListCount(positionSC);
    }
    
    public POSITIONSVO positionDependency(PositionSC positionSC) throws BaseException
    {
	return positionDAO.positionDependency(positionSC);
    }

}
