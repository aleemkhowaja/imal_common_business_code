package com.path.dao.core.cifrole.impl;

import java.util.List;

import com.path.dao.core.cifrole.CifRoleDAO;
import com.path.dbmaps.vo.CIF_ROLEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cifrole.CifRoleSC;

public class CifRoleDAOImpl extends BaseDAO implements CifRoleDAO
{

	@Override
	public List cifRoleList(CifRoleSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("cifRoleMapper.cifRoleList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifRoleMapper.cifRoleListMap");
		    return getSqlMap().queryForList("cifRoleMapper.cifRoleList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int cifRoleListCount(CifRoleSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifRoleMapper.cifRoleListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("cifRoleMapper.cifRoleListCount", criteria)).intValue();
		return nb;
	}
	
	@Override
	public CIF_ROLEVO returnRoleById(CifRoleSC criteria) throws DAOException
    {
		return (CIF_ROLEVO) getSqlMap().queryForObject("cifRoleMapper.returnRoleById", criteria);
    }
}
