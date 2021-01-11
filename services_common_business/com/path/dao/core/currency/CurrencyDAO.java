/**
 * 
 */
package com.path.dao.core.currency;

import java.util.List;

import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.currency.CurrencySC;

/**
 * @author MarwanMaddah
 *
 */
public interface CurrencyDAO
{
    public int checkCurrencyValidation(CurrencySC criteria) throws DAOException;

    public int currencyListCount(CurrencySC currencySC) throws DAOException;

    public List currencyList(CurrencySC currencySC) throws DAOException;

    public CURRENCIESVO returnCurrencyById(CurrencySC criteria) throws DAOException;

    public CURRENCIESVO returnCurrencyInBranchById(CurrencySC currencySC) throws DAOException;

    public int currencyAddRefListCount(CurrencySC currencySC) throws DAOException;

    public List currencyAddRefList(CurrencySC currencySC) throws DAOException;

    public List<CURRENCIESVO> currencyAmfList(CurrencySC currencySC) throws DAOException;

    public Integer currencyAmfListCount(CurrencySC currencySC) throws DAOException;

    public List<CURRENCIESVO> currencyFmsList(CurrencySC currencySC) throws DAOException;

    public Integer currencyFmsListCount(CurrencySC currencySC) throws DAOException;

    public CURRENCIESVO returnCurrencyByIdFms(CurrencySC currencySC) throws DAOException;

    public CURRENCIESVO returnCurrencyDescByCurrencyCode(CurrencySC currencySC) throws DAOException;

    public List<CURRENCIESVO> returnCurrencyBydesc(CURRENCIESVO cyVO) throws DAOException;

    public List<CURRENCIESVO> returnCurrencyByIsoCode(CURRENCIESVO cyVO) throws DAOException;

    public Integer currencyListCountFAS(CurrencySC currencySC) throws DAOException;
    
    public List<CURRENCIESVO> currencyListFAS(CurrencySC currencySC) throws DAOException;
    // nizam method start
    public List rateCurrencyList(CurrencySC currencySC) throws DAOException;
    
    public Integer rateCurrencyListCount(CurrencySC currencySC) throws DAOException;
    // nizam method end
}
