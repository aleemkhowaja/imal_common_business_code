package com.path.bo.core.division;

import java.util.List;

import com.path.dbmaps.vo.DIVISIONSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.division.DivisionSC;

public interface DivisionBO
{
    public int divisionListCount(DivisionSC divisionSC) throws BaseException;

    public List divisionList(DivisionSC divisionSC) throws BaseException;
    
    public DIVISIONSVO returnDivisionById(DivisionSC criteria) throws BaseException;

}
