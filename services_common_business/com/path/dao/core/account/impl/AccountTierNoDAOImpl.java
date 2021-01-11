package com.path.dao.core.account.impl;

import java.util.List;

import com.path.dao.core.account.AccountDAO;
import com.path.dao.core.account.AccountTierNoDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.account.AccountSC;

public class AccountTierNoDAOImpl extends BaseDAO implements AccountTierNoDAO
{
    public int accountTierNoListCount(AccountSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountTierNoMapper.accountTierNoListMap");
	return ((Integer) getSqlMap().queryForObject("accountTierNoMapper.accountTierNoListCount", criteria)).intValue();
    }
    public List accountTierNoList(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("accountTierNoMapper.accountTierNoList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountTierNoMapper.accountTierNoListMap");
	    return getSqlMap().queryForList("accountTierNoMapper.accountTierNoList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int returnAccountTierNoCount(AccountSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("accountTierNoMapper.returnAccountTierNoCount", criteria)).intValue();
    }
    
    public int returnAccountTierNoSuspension(AccountSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("accountTierNoMapper.returnAccountTierNoSuspension", criteria)).intValue();
    }
    
    
    
}
