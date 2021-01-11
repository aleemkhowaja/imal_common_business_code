/**
 * 
 */
package com.path.dao.core.currency.impl;

import java.util.List;

import com.path.dao.core.currency.CurrencyDAO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.currency.CurrencySC;


/**
 * @author MarwanMaddah
 *
 */
public class CurrencyDAOImpl extends BaseDAO implements CurrencyDAO
{
    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int checkCurrencyValidation(CurrencySC criteria) throws DAOException
    {
	return NumberUtil.nullToZero((Integer)getSqlMap().queryForObject("currencyMapper.checkCurrencyValidation", criteria));
    }

	@Override
	public List currencyList(CurrencySC currencySC) throws DAOException {
		DAOHelper.fixGridMaps(currencySC, getSqlMap(), "currencyMapper.currencyListMap");
		if (currencySC.getNbRec() == -1) {
			return getSqlMap().queryForList("currencyMapper.currencyList",
					currencySC);
		} else {			
			return getSqlMap().queryForList("currencyMapper.currencyList",
					currencySC, currencySC.getRecToskip(),
					currencySC.getNbRec());
		}
	}

	@Override
	public int currencyListCount(CurrencySC currencySC) throws DAOException {
		// TODO Auto-generated method stub
		DAOHelper.fixGridMaps(currencySC, getSqlMap(),
				"currencyMapper.currencyListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject(
				"currencyMapper.currencyListCount", currencySC)).intValue();
		return nb;
	}
	@Override
	public CURRENCIESVO returnCurrencyById(CurrencySC criteria) throws DAOException
    {
		return (CURRENCIESVO) getSqlMap().queryForObject("currencyMapper.returnCurrencyById", criteria);
    }

	@Override
	public CURRENCIESVO returnCurrencyInBranchById(CurrencySC currencySC) throws DAOException 
	{
		return (CURRENCIESVO)getSqlMap().queryForObject("currencyMapper.returnCurrencyInBranchById", currencySC);
	}

	public List currencyAddRefList(CurrencySC currencySC) throws DAOException
	{
	    if (currencySC.getNbRec() == -1) {
		return getSqlMap().queryForList("currencyMapper.currencyAddRefList",currencySC);
	    } else {
    		DAOHelper.fixGridMaps(currencySC, getSqlMap(),"currencyMapper.currencyListMap");
    		return getSqlMap().queryForList("currencyMapper.currencyAddRefList",
    				currencySC, currencySC.getRecToskip(),
    				currencySC.getNbRec());
    	    }
	}

	public int currencyAddRefListCount(CurrencySC currencySC) throws DAOException
	{
            int nb = 0;
            nb = ((Integer) getSqlMap().queryForObject(
            		"currencyMapper.currencyAddRefListCount", currencySC)).intValue();
            return nb;
	}

	@Override
	public List<CURRENCIESVO> currencyAmfList(CurrencySC currencySC) throws DAOException
	{
        	if(currencySC.getNbRec() == -1)
        	{
        	    return getSqlMap().queryForList("currencyMapper.currencyAmfList", currencySC);
        	}
        	else
        	{
        	    DAOHelper.fixGridMaps(currencySC, getSqlMap(), "currencyMapper.currencyListMap");
        	    return getSqlMap().queryForList("currencyMapper.currencyAmfList", currencySC, currencySC.getRecToskip(),
        		    currencySC.getNbRec());
        	}
	}

	@Override
	public Integer currencyAmfListCount(CurrencySC currencySC) throws DAOException
	{
        	int nb = 0;
        	nb = ((Integer) getSqlMap().queryForObject("currencyMapper.currencyAmfListCount", currencySC)).intValue();
        	return nb;
	}
	
	@Override
	public List<CURRENCIESVO> currencyFmsList(CurrencySC currencySC) throws DAOException
	{
        	if(currencySC.getNbRec() == -1)
        	{
        	    return getSqlMap().queryForList("currencyMapper.currencyFmsList", currencySC);
        	}
        	else
        	{
        	    DAOHelper.fixGridMaps(currencySC, getSqlMap(), "currencyMapper.currencyListMap");
        	    return getSqlMap().queryForList("currencyMapper.currencyFmsList", currencySC, currencySC.getRecToskip(),
        		    currencySC.getNbRec());
        	}
	}

	@Override
	public Integer currencyFmsListCount(CurrencySC currencySC) throws DAOException
	{
        	int nb = 0;
        	nb = ((Integer) getSqlMap().queryForObject("currencyMapper.currencyFmsListCount", currencySC)).intValue();
        	return nb;
	}
	
	@Override
	public CURRENCIESVO returnCurrencyByIdFms(CurrencySC currencySC) throws DAOException 
	{
		return (CURRENCIESVO)getSqlMap().queryForObject("currencyMapper.returnCurrencyByIdFms", currencySC);
	}

	@Override
	public CURRENCIESVO returnCurrencyDescByCurrencyCode(CurrencySC currencySC) throws DAOException
	{
	    return (CURRENCIESVO)getSqlMap().queryForObject("currencyMapper.returnCurrencyDescByCurrencyCode", currencySC);
	}

	@Override
	public List<CURRENCIESVO> returnCurrencyByIsoCode(CURRENCIESVO cyVO) throws DAOException
	{
	    return (List<CURRENCIESVO>)getSqlMap().queryForList("currencyMapper.returnCurrencyByIsoCode", cyVO);
	}

	@Override
    public Integer currencyListCountFAS(CurrencySC currencySC) throws DAOException
    {
              // TODO Auto-generated method stub
              DAOHelper.fixGridMaps(currencySC, getSqlMap(),
                           "currencyMapper.currencyListMap");
              int nb = 0;
              nb = ((Integer) getSqlMap().queryForObject(
                           "currencyMapper.currencyListCountFAS", currencySC)).intValue();
              return nb;
    }

    @Override
    public List<CURRENCIESVO> currencyListFAS(CurrencySC currencySC) throws DAOException
    {

              // TODO Auto-generated method stub
              if (currencySC.getNbRec() == -1) {
                     return getSqlMap().queryForList("currencyMapper.currencyListFAS",
                                  currencySC);
              } else {
                     DAOHelper.fixGridMaps(currencySC, getSqlMap(),
                                  "currencyMapper.currencyListMap");
                     return getSqlMap().queryForList("currencyMapper.currencyListFAS",
                                  currencySC, currencySC.getRecToskip(),
                                  currencySC.getNbRec());
              }
       
    }

	
    
    @Override
    public List<CURRENCIESVO> returnCurrencyBydesc(CURRENCIESVO cyVO) throws DAOException
    {
	return (List<CURRENCIESVO>) getSqlMap().queryForList("currencyMapper.returnCurrencyBydesc", cyVO);
    }


    // nizam method start
    @Override
    public List rateCurrencyList(CurrencySC currencySC) throws DAOException
    {
	// TODO Auto-generated method stub
	if(currencySC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("currencyMapper.rateCurrencyList", currencySC);
	}
	else
	{
	    DAOHelper.fixGridMaps(currencySC, getSqlMap(), "currencyMapper.rateCurrencyListMap");
	    return getSqlMap().queryForList("currencyMapper.rateCurrencyList", currencySC);
	}
    }
    
    public Integer rateCurrencyListCount(CurrencySC currencySC) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("currencyMapper.rateCurrencyListCount", currencySC)).intValue();
	return nb;
    }    
    // nizam method end
}
