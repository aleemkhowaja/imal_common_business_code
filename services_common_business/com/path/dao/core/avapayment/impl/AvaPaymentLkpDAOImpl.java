package com.path.dao.core.avapayment.impl;

import java.util.List;

import com.path.dao.core.avapayment.AvaPaymentLkpDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.avapayment.AvaPaymentCO;
import com.path.vo.core.avapayment.AvaPaymentLkpSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaPaymentDAOImpl.java used to
 */
public class AvaPaymentLkpDAOImpl extends BaseDAO implements AvaPaymentLkpDAO
{
    /**
     * Method used to return Lookup Count of AvaPayment
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws DAOException
     */	       	
    public int returnAvaPaymentLookupCount(AvaPaymentLkpSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaPaymentLkpMapper.resAvaPaymentLookupMap");
	return ((Integer) getSqlMap().queryForObject("avaPaymentLkpMapper.returnAvaPaymentLookupCount", criteria))
		.intValue();
    }

    /**
     * Method used to return Lookup of AvaPayment
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws DAOException
     */
    public List returnAvaPaymentLookup(AvaPaymentLkpSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaPaymentLkpMapper.resAvaPaymentLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("avaPaymentLkpMapper.returnAvaPaymentLookup", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("avaPaymentLkpMapper.returnAvaPaymentLookup", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    public int returnAvaPaymentTrxLookupCount(AvaPaymentLkpSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaPaymentLkpMapper.resAvaPaymentTrxLookupMap");
	return ((Integer) getSqlMap().queryForObject("avaPaymentLkpMapper.returnAvaPaymentTrxLookupCount", criteria))
		.intValue();
    }

    /**
     * Method used to return Lookup of AvaPayment
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws DAOException
     */
    public List returnAvaPaymentTrxLookup(AvaPaymentLkpSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaPaymentLkpMapper.resAvaPaymentTrxLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("avaPaymentLkpMapper.returnAvaPaymentTrxLookup", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("avaPaymentLkpMapper.returnAvaPaymentTrxLookup", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

   /**
    *  Method used to return dependency of AvaPayment
    * @return CTS_AVA_PAYMENTVO Result
    * @throws DAOException
    */
    public AvaPaymentCO dependencyForAvaPayment(AvaPaymentLkpSC criteria) throws DAOException
    {
	return (AvaPaymentCO) getSqlMap().queryForObject("avaPaymentLkpMapper.dependencyForAvaPayment", criteria);
    }
}
