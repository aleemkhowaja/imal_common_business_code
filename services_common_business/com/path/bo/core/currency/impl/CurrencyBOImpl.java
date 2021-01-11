/**
 * 
 */
package com.path.bo.core.currency.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.currency.CurrencyBO;
import com.path.dao.core.currency.CurrencyDAO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.currency.CurrencySC;

/**
 * @author MarwanMaddah
 * 
 */
public class CurrencyBOImpl extends BaseBO implements CurrencyBO
{
    private CurrencyDAO currencyDAO;

    /**
     * 
     */
    public Boolean checkCurrencyValidation(CurrencySC criteria) throws BaseException
    {
	Boolean result = false;
	int theValue = currencyDAO.checkCurrencyValidation(criteria);
	if(theValue > 0)
	{
	    result = true;
	}
	return result;
    }

    public CurrencyDAO getCurrencyDAO()
    {
	return currencyDAO;
    }

    public void setCurrencyDAO(CurrencyDAO currencyDAO)
    {
	this.currencyDAO = currencyDAO;
    }

    @Override
    public List currencyList(CurrencySC currencySC) throws BaseException
    {
	// TODO Auto-generated method stub
	return currencyDAO.currencyList(currencySC);
    }

    @Override
    public int currencyListCount(CurrencySC currencySC) throws BaseException
    {
	// TODO Auto-generated method stub
	return currencyDAO.currencyListCount(currencySC);
    }

    /**
     * @param preferredLanguage, compCode, currencyCode
     */
    @Override
    public CURRENCIESVO returnCurrencyById(CurrencySC criteria) throws BaseException
    {
	// TODO Auto-generated method stub
	return currencyDAO.returnCurrencyById(criteria);
    }

    @Override
    public CURRENCIESVO returnCurrencyInBranchById(CurrencySC currencySC) throws BaseException
    {
	return currencyDAO.returnCurrencyInBranchById(currencySC);
    }

    public List currencyAddRefList(CurrencySC currencySC) throws BaseException
    {
	return currencyDAO.currencyAddRefList(currencySC);
    }

    public int currencyAddRefListCount(CurrencySC currencySC) throws BaseException
    {
	return currencyDAO.currencyAddRefListCount(currencySC);
    }

    @Override
    public CURRENCIESVO returnCurrency(CURRENCIESVO currenciesVO) throws BaseException
    {
	return commonLibBO.returnCurrency(currenciesVO);
    }

    public CURRENCIESVO getCurrencyDetails(CURRENCIESVO theCurrenciesVO) throws BaseException
    {
	CURRENCIESVO currenciesVO = theCurrenciesVO;
	currenciesVO = commonLibBO.returnCurrency(currenciesVO);

	if(currenciesVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CURRENCY);
	}
	return currenciesVO;
    }

    @Override
    public List<CURRENCIESVO> currencyAmfList(CurrencySC currencySC) throws BaseException
    {
	return currencyDAO.currencyAmfList(currencySC);
    }

    @Override
    public Integer currencyAmfListCount(CurrencySC currencySC) throws BaseException
    {
	return currencyDAO.currencyAmfListCount(currencySC);
    }
    
    @Override
    public List<CURRENCIESVO> currencyFmsList(CurrencySC currencySC) throws BaseException
    {
	return currencyDAO.currencyFmsList(currencySC);
    }

    @Override
    public Integer currencyFmsListCount(CurrencySC currencySC) throws BaseException
    {
	return currencyDAO.currencyFmsListCount(currencySC);
    }
    
    public CURRENCIESVO returnCurrencyByIdFms(CurrencySC currencySC) throws BaseException
    {
	return  currencyDAO.returnCurrencyByIdFms(currencySC);

    }

    @Override
    public CURRENCIESVO returnCurrencyDescByCurrencyCode(CurrencySC currencySC) throws BaseException
    {
	return currencyDAO.returnCurrencyDescByCurrencyCode(currencySC);
    }

    @Override
    public List<CURRENCIESVO> returnCurrencyByIsoCode(CURRENCIESVO cyVO) throws BaseException
    {
	return currencyDAO.returnCurrencyByIsoCode(cyVO);
    }
    
	    @Override
    public Integer currencyListCountFAS(CurrencySC currencySC) throws BaseException
    {
       return currencyDAO.currencyListCountFAS(currencySC);
    }

    @Override
    public List<CURRENCIESVO> currencyListFAS(CurrencySC currencySC) throws BaseException
    {
       return currencyDAO.currencyListFAS(currencySC);
    }
    
    @Override
    public List<CURRENCIESVO> returnCurrencyBydesc(CURRENCIESVO cyVO) throws DAOException
    {
	return currencyDAO.returnCurrencyBydesc(cyVO);
    }


    // nizam method start
    @Override
    public List rateCurrencyList(CurrencySC currencySC) throws DAOException
    {
	return currencyDAO.rateCurrencyList(currencySC);
    }

    @Override
    public Integer rateCurrencyListCount(CurrencySC currencySC) throws DAOException
    {
	return currencyDAO.rateCurrencyListCount(currencySC);
    }
    // nizam method end

}
