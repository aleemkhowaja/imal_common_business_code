/**
 * 
 */
package com.path.bo.core.unit.impl;

import java.util.List;

import com.path.bo.core.unit.UnitsBO;
import com.path.dao.core.unit.UnitsDAO;
import com.path.dbmaps.vo.UNITSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.unit.UnitSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * UnitsBOImpl.java used to
 */
public class UnitsBOImpl extends BaseBO implements UnitsBO
{
    private UnitsDAO unitsDAO;

    public UNITSVO returnDependencyByUnitCode(UnitSC unitSC) throws BaseException
    {
	return unitsDAO.returnDependencyByUnitCode(unitSC);
    }

    public List<UNITSVO> unitList(UnitSC unitSC) throws BaseException
    {
	return unitsDAO.unitList(unitSC);
    }

    public int unitListCount(UnitSC unitSC) throws BaseException
    {
	return unitsDAO.unitListCount(unitSC);
    }

    /**
     * @return the unitsDAO
     */
    public UnitsDAO getUnitsDAO()
    {
        return unitsDAO;
    }

    /**
     * @param unitsDAO the unitsDAO to set
     */
    public void setUnitsDAO(UnitsDAO unitsDAO)
    {
        this.unitsDAO = unitsDAO;
    }

}
