package com.path.dao.core.division;

import java.util.List;

import com.path.dbmaps.vo.DIVISIONSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.division.DivisionSC;

public interface DivisionDAO
{
    public int divisionListCount(DivisionSC divisionSC) throws DAOException;

    public List divisionList(DivisionSC divisionSC) throws DAOException;
    
    public DIVISIONSVO returnDivisionById(DivisionSC criteria) throws DAOException;
}
