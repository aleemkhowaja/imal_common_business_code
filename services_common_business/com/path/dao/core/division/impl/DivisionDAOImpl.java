package com.path.dao.core.division.impl;

import java.util.List;

import com.path.dao.core.division.DivisionDAO;
import com.path.dbmaps.vo.DIVISIONSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.division.DivisionSC;

public class DivisionDAOImpl extends BaseDAO implements DivisionDAO
{

    @Override
    public List divisionList(DivisionSC divisionSC) throws DAOException
    {
	if(divisionSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("divisionListMapper.divisionList", divisionSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(divisionSC, getSqlMap(), "divisionListMapper.divisionList_ResMap");
	    return getSqlMap().queryForList("divisionListMapper.divisionList", divisionSC, divisionSC.getRecToskip(),
		    divisionSC.getNbRec());
	}
    }

    @Override
    public int divisionListCount(DivisionSC divisionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(divisionSC, getSqlMap(), "divisionListMapper.divisionList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("divisionListMapper.divisionListCount", divisionSC)).intValue();
	return nb;
    }
    
    @Override
	public DIVISIONSVO returnDivisionById(DivisionSC criteria) throws DAOException
    {
		return (DIVISIONSVO) getSqlMap().queryForObject("divisionListMapper.returnDivisionById", criteria);
    }

}
