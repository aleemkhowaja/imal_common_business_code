package com.path.dao.core.accountcharges;

import java.util.List;

import com.path.dbmaps.vo.CTS_SAFEBOX_CHARGESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.accountcharges.AccountChargesSC;

public interface AccountChargesProductsDAO
{
	public Integer loadSafeboxChargesLookupCount(AccountChargesSC criteria) throws DAOException;

	public List<CTS_SAFEBOX_CHARGESVO> loadSafeboxChargesLookup(AccountChargesSC criteria) throws DAOException;

	public CTS_SAFEBOX_CHARGESVO loadSafeboxChargesDependency(AccountChargesSC criteria) throws DAOException;
}
