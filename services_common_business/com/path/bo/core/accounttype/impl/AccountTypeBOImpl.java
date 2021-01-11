package com.path.bo.core.accounttype.impl;

import java.util.List;

import com.path.bo.core.accounttype.AccountTypeBO;
import com.path.dao.core.accounttype.AccountTypeDAO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.accounttype.AccountTypeSC;

public class AccountTypeBOImpl extends BaseBO implements AccountTypeBO
{
	
	private AccountTypeDAO accountTypeDAO;

	@Override
	public List accountTypeList(AccountTypeSC criteria) throws BaseException
	{
		return accountTypeDAO.accountTypeList(criteria);
	}

	@Override
	public int accountTypeListCount(AccountTypeSC criteria) throws BaseException
	{
		return accountTypeDAO.accountTypeListCount(criteria);
	}

	public AccountTypeDAO getAccountTypeDAO()
	{
		return accountTypeDAO;
	}

	public void setAccountTypeDAO(AccountTypeDAO accountTypeDAO)
	{
		this.accountTypeDAO = accountTypeDAO;
	}

	@Override
	public RIFATTVO returnAccountTypeById(AccountTypeSC criteria) throws BaseException
	{
		return (RIFATTVO) accountTypeDAO.returnAccountTypeById(criteria);
	}

}
