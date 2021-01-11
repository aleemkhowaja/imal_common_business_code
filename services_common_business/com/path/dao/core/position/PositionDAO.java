package com.path.dao.core.position;

import java.util.List;

import com.path.dbmaps.vo.POSITIONSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.position.PositionSC;

public interface PositionDAO
{
    public List positionList(PositionSC positionSC) throws DAOException;

    public int positionListCount(PositionSC positionSC) throws DAOException;
    public POSITIONSVO positionDependency(PositionSC positionSC) throws DAOException;

}
