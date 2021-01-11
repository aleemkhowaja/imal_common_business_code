package com.path.dao.common.global360view.oneobligor.impl;

import java.util.List;

import com.path.dao.common.global360view.oneobligor.DashOneObligorDAO;
import com.path.dbmaps.vo.RIFOBTVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.oneobligor.DashOneObligorCO;
import com.path.vo.common.global360view.oneobligor.DashOneObligorSC;

public class DashOneObligorDAOImpl extends BaseDAO implements DashOneObligorDAO
{

    @Override
    public DashOneObligorCO fillOneObligorForm(DashOneObligorSC dashOneObligorSC) throws DAOException
    {
	return (DashOneObligorCO) getSqlMap().queryForObject("dashOneObligorMapper.returnDashOneObligorDataByCIF", dashOneObligorSC);
    }

    @Override
    public Integer oneObligorClassCount(DashOneObligorSC dashOneObligorSC) throws DAOException
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<TRSCLASSVO> oneObligorClassList(DashOneObligorSC dashOneObligorSC) throws DAOException
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List oneObligorList(DashOneObligorSC dashOneObligorSC) throws DAOException
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public int oneObligorListCount(DashOneObligorSC dashOneObligorSC) throws DAOException
    {
	return 0;
    }

    @Override
    public List oneObligorTrendsList(DashOneObligorSC dashOneObligorSC) throws DAOException
    {
	DAOHelper.fixGridMaps(dashOneObligorSC, getSqlMap(), "dashOneObligorMapper.dashOneObligorTrendsListMap");
	if(dashOneObligorSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOneObligorMapper.returnDashOneObligorTrendsList", dashOneObligorSC,
		    dashOneObligorSC.getRecToskip(), dashOneObligorSC.getNbRec());
	}
	else
	{
	    return getSqlMap().queryForList("dashOneObligorMapper.returnDashOneObligorTrendsList", dashOneObligorSC);
	}
    }

    @Override
    public int oneObligorTrendsListCount(DashOneObligorSC dashOneObligorSC) throws DAOException
    {
	DAOHelper.fixGridMaps(dashOneObligorSC, getSqlMap(), "dashOneObligorMapper.dashOneObligorTrendsListMap");
	return ((Integer) getSqlMap().queryForObject("dashOneObligorMapper.returnDashOneObligorTrendsListCount", dashOneObligorSC))
		.intValue();
    }

    @Override
    public RIFOBTVO returnOneObligorByCode(DashOneObligorSC dashOneObligorSC) throws DAOException
    {
	// TODO Auto-generated method stub
	return null;
    }


}
