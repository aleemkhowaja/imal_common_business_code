package com.path.dao.core.occupation.impl;

import java.util.List;

import com.path.dao.core.occupation.OccupationDAO;
import com.path.dbmaps.vo.CIF_OCCUPATIONVO;
import com.path.dbmaps.vo.OCCUPATIONSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.occupation.OccupationSC;

public class OccupationDAOImpl extends BaseDAO implements OccupationDAO
{

    @Override
    public List occupationList(OccupationSC occupationSC) throws DAOException
    {
	if(occupationSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("occupationMapper.occupationList", occupationSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(occupationSC, getSqlMap(), "occupationMapper.occupationList_ResMap");
	    return getSqlMap().queryForList("occupationMapper.occupationList", occupationSC,
		    occupationSC.getRecToskip(), occupationSC.getNbRec());
	}
    }

    @Override
    public int occupationListCount(OccupationSC occupationSC) throws DAOException
    {
	DAOHelper.fixGridMaps(occupationSC, getSqlMap(), "occupationMapper.occupationList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("occupationMapper.occupationListCount", occupationSC)).intValue();
	return nb;
    }
    
    @Override
	public OCCUPATIONSVO returnOccupationById(OccupationSC occupationSC) throws DAOException
	{
		return (OCCUPATIONSVO) getSqlMap().queryForObject("occupationMapper.returnOccupationById", occupationSC);
	}

	@Override
	public List cifOccupationStatusList(OccupationSC occupationSC) throws DAOException
	{
		if(occupationSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("occupationMapper.cifOccupationStatusList", occupationSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(occupationSC, getSqlMap(), "CIF_OCCUPATION.BaseResultMap");
		    return getSqlMap().queryForList("occupationMapper.cifOccupationStatusList", occupationSC,
			    occupationSC.getRecToskip(), occupationSC.getNbRec());
		}
	}

	@Override
	public int cifOccupationStatusListCount(OccupationSC occupationSC) throws DAOException
	{
		DAOHelper.fixGridMaps(occupationSC, getSqlMap(),"CIF_OCCUPATION.BaseResultMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("occupationMapper.cifOccupationStatusListCount", occupationSC)).intValue();
		return nb;
	}

	@Override
	public CIF_OCCUPATIONVO returnCifOccupationStatus(OccupationSC occupationSC) throws DAOException
	{
		return (CIF_OCCUPATIONVO) getSqlMap().queryForObject("occupationMapper.returnCifOccupationStatus", occupationSC);
	}

}
