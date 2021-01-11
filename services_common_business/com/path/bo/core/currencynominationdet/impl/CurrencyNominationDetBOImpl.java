package com.path.bo.core.currencynominationdet.impl;

import java.util.List;

import com.path.bo.core.currencynominationdet.CurrencyNominationDetBO;
import com.path.dao.core.currencynominationdet.CurrencyNominationDetDAO;
import com.path.dbmaps.vo.CURRENCY_NOMINATION_DETVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.currency.CurrencySC;

public class CurrencyNominationDetBOImpl extends BaseBO implements CurrencyNominationDetBO 
{
    private CurrencyNominationDetDAO currencyNominationDetDAO;

    /**
     * return the Vault lookup list count  
     * @param vaultSC
     * @return int
     * @throws BaseException
     */
    public int currencyNominationDetListCount(CurrencySC currencySC) throws BaseException
    {
	return currencyNominationDetDAO.currencyNominationDetListCount(currencySC);
    }

    public List<CURRENCY_NOMINATION_DETVO> currencyNominationDetList(CurrencySC currencySC) throws BaseException
    {
	return currencyNominationDetDAO.currencyNominationDetList(currencySC);
    }

    public CurrencyNominationDetDAO getCurrencyNominationDetDAO()
    {
        return currencyNominationDetDAO;
    }

    public void setCurrencyNominationDetDAO(CurrencyNominationDetDAO currencyNominationDetDAO)
    {
        this.currencyNominationDetDAO = currencyNominationDetDAO;
    }
    
    

}
