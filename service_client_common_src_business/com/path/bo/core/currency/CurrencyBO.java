/**
 * 
 */
package com.path.bo.core.currency;

import java.util.List;

import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.currency.CurrencySC;

/**
 * @author MarwanMaddah
 *
 */
public interface CurrencyBO
{
   public Boolean checkCurrencyValidation(CurrencySC criteria) throws BaseException;  
   public int  currencyListCount(CurrencySC currencySC) throws BaseException;
	public List currencyList(CurrencySC currencySC) throws BaseException;
	public CURRENCIESVO returnCurrencyById(CurrencySC criteria) throws BaseException;
	public CURRENCIESVO returnCurrencyInBranchById(CurrencySC criteria) throws BaseException;
	public int  currencyAddRefListCount(CurrencySC currencySC) throws BaseException;
	public List currencyAddRefList(CurrencySC currencySC) throws BaseException;
	/**
	 * 
	 * Used for returning CurrencyVO given company and currency Code within curVO parameter
	 * 
	 * @param curVO
	 * @return
	 * @throws BaseException
	 */
	public CURRENCIESVO returnCurrency(CURRENCIESVO curVO)throws BaseException;
	public CURRENCIESVO getCurrencyDetails(CURRENCIESVO currenciesVO) throws BaseException;
	
	/**
	 * w_lookup_currency_acc
	 * @param currencySC
	 */
	public Integer currencyAmfListCount(CurrencySC currencySC) throws BaseException;
	public List<CURRENCIESVO> currencyAmfList(CurrencySC currencySC) throws BaseException;
	
	/**
	 * dw_ddw_currency
	 * @param currencySC
	 */
	public Integer currencyFmsListCount(CurrencySC currencySC) throws BaseException;
	public List<CURRENCIESVO> currencyFmsList(CurrencySC currencySC) throws BaseException;
	public CURRENCIESVO returnCurrencyByIdFms (CurrencySC currencySC) throws BaseException;
	public CURRENCIESVO returnCurrencyDescByCurrencyCode(CurrencySC currencySC) throws BaseException;
	public List<CURRENCIESVO> returnCurrencyByIsoCode(CURRENCIESVO cyVO) throws BaseException;
	
	public Integer currencyListCountFAS(CurrencySC currencySC) throws BaseException;

    public List<CURRENCIESVO> currencyListFAS(CurrencySC currencySC) throws BaseException;

    // nizam method start
    public List<CURRENCIESVO> rateCurrencyList(CurrencySC currencySC) throws BaseException;

    public Integer rateCurrencyListCount(CurrencySC currencySC) throws BaseException;
    // nizam method end
    public List<CURRENCIESVO> returnCurrencyBydesc(CURRENCIESVO cyVO) throws BaseException;
}
