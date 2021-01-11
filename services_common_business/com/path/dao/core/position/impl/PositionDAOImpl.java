package com.path.dao.core.position.impl;

import java.util.List;

import com.path.dao.core.position.PositionDAO;
import com.path.dbmaps.vo.POSITIONSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.position.PositionSC;

public class PositionDAOImpl extends BaseDAO implements PositionDAO
{
    @Override
    public List positionList(PositionSC positionSC) throws DAOException
    {
	if(positionSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("positionMapper.positionList", positionSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(positionSC, getSqlMap(), "positionMapper.positionList_ResMap");
	    return getSqlMap().queryForList("positionMapper.positionList", positionSC, positionSC.getRecToskip(),
		    positionSC.getNbRec());
	}
    }

    @Override
    public int positionListCount(PositionSC positionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(positionSC, getSqlMap(), "positionMapper.positionList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("positionMapper.positionListCount", positionSC)).intValue();
	return nb;
    }
    
    public POSITIONSVO positionDependency(PositionSC positionSC) throws DAOException
    {
	return (POSITIONSVO) getSqlMap().queryForObject("positionMapper.positionDependency", positionSC);
    }

}
