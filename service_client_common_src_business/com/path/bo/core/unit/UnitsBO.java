/**
 * 
 */
package com.path.bo.core.unit;

import java.util.List;

import com.path.dbmaps.vo.UNITSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.unit.UnitSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * UnitsBO.java used to
 */
public interface UnitsBO
{
    public int unitListCount(UnitSC unitSC) throws BaseException;

    public List<UNITSVO> unitList(UnitSC unitSC) throws BaseException;
    
    public UNITSVO returnDependencyByUnitCode(UnitSC unitSC) throws BaseException;
}
