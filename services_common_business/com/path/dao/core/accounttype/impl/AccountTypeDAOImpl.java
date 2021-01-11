package com.path.dao.core.accounttype.impl;

import java.util.List;

import com.path.dao.core.accounttype.AccountTypeDAO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.accounttype.AccountTypeSC;

public class AccountTypeDAOImpl extends BaseDAO implements AccountTypeDAO
{

	@Override
	public List accountTypeList(AccountTypeSC criteria) throws DAOException
	{
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("accountTypeMapper.selectAccountTypeList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "RIFATT.BaseResultMap");
		    return getSqlMap().queryForList("accountTypeMapper.selectAccountTypeList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int accountTypeListCount(AccountTypeSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(),"RIFATT.BaseResultMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("accountTypeMapper.selectAccountTypeListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public RIFATTVO returnAccountTypeById(AccountTypeSC criteria) throws DAOException
	{
		return (RIFATTVO) getSqlMap().queryForObject("accountTypeMapper.returnAccountTypeById", criteria);
	}

}
