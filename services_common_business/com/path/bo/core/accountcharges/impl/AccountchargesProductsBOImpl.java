package com.path.bo.core.accountcharges.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.accountcharges.AccountChargesProductsBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.dao.core.accountcharges.AccountChargesProductsDAO;
import com.path.dbmaps.vo.CTS_SAFEBOX_CHARGESVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.accountcharges.AccountChargesSC;

public class AccountchargesProductsBOImpl extends RetailBaseBO implements AccountChargesProductsBO
{
    private AccountChargesProductsDAO accountChargesProductsDAO;

	public AccountChargesProductsDAO getAccountChargesProductsDAO() {
		return accountChargesProductsDAO;
	}

	public void setAccountChargesProductsDAO(AccountChargesProductsDAO accountChargesProductsDAO) {
		this.accountChargesProductsDAO = accountChargesProductsDAO;
	}

	@Override
	public Integer loadSafeboxChargesLookupCount(AccountChargesSC criteria) throws BaseException {
		return accountChargesProductsDAO.loadSafeboxChargesLookupCount(criteria);
	}

	@Override
	public List<CTS_SAFEBOX_CHARGESVO> loadSafeboxChargesLookup(AccountChargesSC criteria) throws BaseException {
		return accountChargesProductsDAO.loadSafeboxChargesLookup(criteria);
	}

	@Override
	public CTS_SAFEBOX_CHARGESVO loadSafeboxChargesDependency(AccountChargesSC criteria) throws BaseException {
		return accountChargesProductsDAO.loadSafeboxChargesDependency(criteria);
	}
}