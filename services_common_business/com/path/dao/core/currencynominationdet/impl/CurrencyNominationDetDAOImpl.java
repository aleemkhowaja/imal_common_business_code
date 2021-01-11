package com.path.dao.core.currencynominationdet.impl;

import java.util.List;

import com.path.dao.core.currencynominationdet.CurrencyNominationDetDAO;
import com.path.dbmaps.vo.CURRENCY_NOMINATION_DETVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.currency.CurrencySC;

public class CurrencyNominationDetDAOImpl extends BaseDAO implements CurrencyNominationDetDAO
{
    public int currencyNominationDetListCount(CurrencySC currencySC) throws DAOException
    {
	DAOHelper.fixGridMaps(currencySC, getSqlMap(), "currencyNominationDetMapper.currencyNominationDetListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("currencyNominationDetMapper.returnCurrencyNominationDetLookupCount", currencySC)).intValue();
	return nb;

    }

    public List<CURRENCY_NOMINATION_DETVO> currencyNominationDetList(CurrencySC currencySC) throws DAOException
    {
	DAOHelper.fixGridMaps(currencySC, getSqlMap(), "currencyNominationDetMapper.currencyNominationDetListMap");
	if(currencySC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("currencyNominationDetMapper.returnCurrencyNominationDetLookupData", currencySC);
	}
	else
	{
	    return getSqlMap().queryForList("currencyNominationDetMapper.returnCurrencyNominationDetLookupData", currencySC, currencySC.getRecToskip(),
		    currencySC.getNbRec());
	}
    }
}
