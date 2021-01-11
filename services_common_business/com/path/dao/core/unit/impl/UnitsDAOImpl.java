/**
 * 
 */
package com.path.dao.core.unit.impl;

import java.util.List;

import com.path.dao.core.unit.UnitsDAO;
import com.path.dbmaps.vo.UNITSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.unit.UnitSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * UnitsDAOImpl.java used to
 */
public class UnitsDAOImpl extends BaseDAO implements UnitsDAO
{

    public UNITSVO returnDependencyByUnitCode(UnitSC unitSC) throws DAOException
    {
	return (UNITSVO)getSqlMap().queryForObject("unitsMapper.returnUnitByCode", unitSC);
    }

    @SuppressWarnings("unchecked")
    public List<UNITSVO> unitList(UnitSC unitSC) throws DAOException
    {
	if(unitSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("unitsMapper.unitList", unitSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(unitSC, getSqlMap(), "unitsMapper.unitsListMap");
	    return getSqlMap().queryForList("unitsMapper.unitList", unitSC,
		    unitSC.getRecToskip(), unitSC.getNbRec());
	}
    }

    public int unitListCount(UnitSC unitSC) throws DAOException
    {
	DAOHelper.fixGridMaps(unitSC, getSqlMap(), "unitsMapper.unitsListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap()
		.queryForObject("unitsMapper.unitListCount", unitSC)).intValue();
	return nb;
    }

}
