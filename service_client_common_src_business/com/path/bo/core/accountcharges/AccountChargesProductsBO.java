package com.path.bo.core.accountcharges;

import java.util.List;

import com.path.dbmaps.vo.CTS_SAFEBOX_CHARGESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.accountcharges.AccountChargesSC;

public interface AccountChargesProductsBO
{
	public Integer loadSafeboxChargesLookupCount(AccountChargesSC criteria) throws BaseException;

	public List<CTS_SAFEBOX_CHARGESVO> loadSafeboxChargesLookup(AccountChargesSC criteria) throws BaseException;

	public CTS_SAFEBOX_CHARGESVO loadSafeboxChargesDependency(AccountChargesSC criteria) throws BaseException;
}
