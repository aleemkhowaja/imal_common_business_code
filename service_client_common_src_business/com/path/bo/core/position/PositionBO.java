package com.path.bo.core.position;

import java.util.List;

import com.path.dbmaps.vo.POSITIONSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.position.PositionSC;

public interface PositionBO
{

    public int positionListCount(PositionSC positionSC) throws BaseException;

    public List positionList(PositionSC positionSC) throws BaseException;
    public POSITIONSVO positionDependency(PositionSC positionSC) throws BaseException;

}
