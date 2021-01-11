package com.path.dao.core.salutation.impl;

import java.util.List;

import com.path.dao.core.salutation.SalutationDAO;
import com.path.dbmaps.vo.CIVIL_CODESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.salutation.SalutationSC;

public class SalutationDAOImpl extends BaseDAO implements SalutationDAO
{

	@Override
	public List salutationList(SalutationSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("salutationMapper.salutationList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "salutationMapper.salutationListMap");
		    return getSqlMap().queryForList("salutationMapper.salutationList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int salutationListCount(SalutationSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "salutationMapper.salutationListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("salutationMapper.salutationListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public CIVIL_CODESVO returnSalutationById(SalutationSC criteria) throws DAOException
	{
		return (CIVIL_CODESVO) getSqlMap().queryForObject("salutationMapper.returnSalutationById", criteria);
	}
	
	public int checkSalutationExistance(SalutationSC criteria) throws DAOException
	{
	    int nb = 0;
	    nb = ((Integer) getSqlMap().queryForObject("salutationMapper.checkSalutationExistance", criteria)).intValue();
	    return nb;
	}
	
    public int checkSalutExistByCifType(SalutationSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("salutationMapper.checkSalutExistByCifType", criteria)).intValue();
    }

}
