package com.path.dao.core.currencynominationdet;

import java.util.List;

import com.path.dbmaps.vo.CURRENCY_NOMINATION_DETVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.currency.CurrencySC;

public interface CurrencyNominationDetDAO
{
    public int currencyNominationDetListCount(CurrencySC currencySC) throws DAOException;

    public List<CURRENCY_NOMINATION_DETVO> currencyNominationDetList(CurrencySC currencySC) throws DAOException;
}
