package com.path.dao.core.fmsindicator.impl;

import java.util.List;

import com.path.dao.core.fmsindicator.FmsIndicatorDAO;
import com.path.dbmaps.vo.FMSINDICATORVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.fmsindicator.FmsIndicatorSC;

public class FmsIndicatorDAOImpl extends BaseDAO implements FmsIndicatorDAO
{
	@Override
	public List fmsIndicatorList(FmsIndicatorSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("fmsIndicatorMapper.fmsIndicatorListfmsIndicatorList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "fmsIndicatorMapper.fmsIndicatorListMap");
		    return getSqlMap().queryForList("fmsIndicatorMapper.fmsIndicatorList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int fmsIndicatorListCount(FmsIndicatorSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "fmsIndicatorMapper.fmsIndicatorListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("fmsIndicatorMapper.fmsIndicatorListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public FMSINDICATORVO returnFmsIndicatorNameById(FmsIndicatorSC criteria) throws DAOException
	{
		return (FMSINDICATORVO) getSqlMap().queryForObject("fmsIndicatorMapper.returnFmsIndicatorNameById", criteria);
	}

	@Override
	public List fmsCustomerIndicatorList(FmsIndicatorSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("fmsIndicatorMapper.fmsCustomerIndicatorListfmsIndicatorList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "fmsIndicatorMapper.fmsIndicatorListMap");
		    return getSqlMap().queryForList("fmsIndicatorMapper.fmsCustomerIndicatorList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int fmsCustomerIndicatorListCount(FmsIndicatorSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "fmsIndicatorMapper.fmsIndicatorListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("fmsIndicatorMapper.fmsCustomerIndicatorListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public FMSINDICATORVO returnFmsCustomerIndicatorNameById(FmsIndicatorSC criteria) throws DAOException
	{
		return (FMSINDICATORVO) getSqlMap().queryForObject("fmsIndicatorMapper.returnFmsCustomerIndicatorNameById", criteria);
	}

}
