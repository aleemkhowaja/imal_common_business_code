package com.path.bo.core.currencynominationdet;

import java.util.List;

import com.path.dbmaps.vo.CURRENCY_NOMINATION_DETVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.currency.CurrencySC;

public interface CurrencyNominationDetBO
{
    public int currencyNominationDetListCount(CurrencySC currencySC) throws BaseException;

    public List<CURRENCY_NOMINATION_DETVO> currencyNominationDetList(CurrencySC currencySC) throws BaseException;
}
