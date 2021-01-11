package com.path.dao.core.sectors.impl;

import java.util.List;

import com.path.dao.core.sectors.SectorsDAO;
import com.path.dbmaps.vo.SECTORSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.sectors.SectorsSC;

public class SectorsDAOImpl extends BaseDAO implements SectorsDAO
{

    @Override
    public List sectorsList(SectorsSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("sectorsMapper.sectorsList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "sectorsMapper.sectorsListMap");
	    return getSqlMap().queryForList("sectorsMapper.sectorsList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int sectorsListCount(SectorsSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "sectorsMapper.sectorsListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("sectorsMapper.sectorsListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public SECTORSVO returnSectorById(SectorsSC criteria) throws DAOException
    {
	return (SECTORSVO) getSqlMap().queryForObject("sectorsMapper.returnSectorsById", criteria);
    }

}
