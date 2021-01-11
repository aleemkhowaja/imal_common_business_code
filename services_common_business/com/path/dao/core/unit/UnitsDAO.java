/**
 * 
 */
package com.path.dao.core.unit;

import java.util.List;

import com.path.dbmaps.vo.UNITSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.unit.UnitSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * UnitsDAO.java used to
 */
public interface UnitsDAO
{
    public int unitListCount(UnitSC unitSC) throws DAOException;

    public List<UNITSVO> unitList(UnitSC unitSC) throws DAOException;
    
    public UNITSVO returnDependencyByUnitCode(UnitSC unitSC) throws DAOException;
}
