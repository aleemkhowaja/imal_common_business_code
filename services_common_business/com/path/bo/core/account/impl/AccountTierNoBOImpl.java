package com.path.bo.core.account.impl;

import java.util.List;

import com.path.bo.core.account.AccountTierNoBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.dao.core.account.AccountTierNoDAO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.account.AccountSC;

public class AccountTierNoBOImpl extends RetailBaseBO implements AccountTierNoBO
{
    private AccountTierNoDAO accountTierNoDAO;
    
    public int accountTierNoListCount(AccountSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	return accountTierNoDAO.accountTierNoListCount(criteria);
    }
    
    public List accountTierNoList(AccountSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	return accountTierNoDAO.accountTierNoList(criteria);
    }

    public int returnAccountTierNoCount(AccountSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	return accountTierNoDAO.returnAccountTierNoCount(criteria);
    }
    
    public int returnAccountTierNoSuspension(AccountSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	return accountTierNoDAO.returnAccountTierNoSuspension(criteria);
    }
    
    
    public AccountTierNoDAO getAccountTierNoDAO()
    {
        return accountTierNoDAO;
    }

    public void setAccountTierNoDAO(AccountTierNoDAO accountTierNoDAO)
    {
        this.accountTierNoDAO = accountTierNoDAO;
    }
}
