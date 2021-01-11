package com.path.bo.core.avapayment.impl;

import java.util.List;

import com.path.bo.core.avapayment.AvaPaymentLkpBO;
import com.path.dao.core.avapayment.AvaPaymentLkpDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.avapayment.AvaPaymentCO;
import com.path.vo.core.avapayment.AvaPaymentLkpSC;



/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaFileLkpBOImpl.java used to
 */
public class AvaPaymentLkpBOImpl extends BaseBO implements AvaPaymentLkpBO
{
    AvaPaymentLkpDAO avaPaymentLkpDAO;
    
    /**
     * Method used to return Lookup Count of AvaFile
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws BaseException
     */
    public int returnAvaPaymentLookupCount(AvaPaymentLkpSC criteria) throws BaseException
    {	
	return avaPaymentLkpDAO.returnAvaPaymentLookupCount(criteria);
    }

    /**
     * Method used to return Lookup List of AvaFile
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws BaseException
     */
    public List returnAvaPaymentLookupList(AvaPaymentLkpSC criteria) throws BaseException
    {
	return avaPaymentLkpDAO.returnAvaPaymentLookup(criteria);
    }
    
    public int returnAvaPaymentTrxLookupCount(AvaPaymentLkpSC criteria) throws BaseException
    {	
	return avaPaymentLkpDAO.returnAvaPaymentTrxLookupCount(criteria);
    }
    
    public List returnAvaPaymentTrxLookupList(AvaPaymentLkpSC criteria) throws BaseException
    {
	return avaPaymentLkpDAO.returnAvaPaymentTrxLookup(criteria);
    }

    /**
     * Method used to return dependency of AvaFile
     * 
     * @param criteria Search Criteria Parameter
     * @return AvaFileVO Result object for dependency
     * @throws BaseException
     */
    public AvaPaymentCO dependencyForAvaPayment(AvaPaymentLkpSC criteria) throws BaseException
    {
	AvaPaymentCO avaPaymentCO = null;
	if(!NumberUtil.isEmptyDecimal(criteria.getPaymentCode()))
	{
	    avaPaymentCO = avaPaymentLkpDAO.dependencyForAvaPayment(criteria);
	    
	    if(avaPaymentCO == null)
	    {
		throw new BOException("Invalid/Missing AVA Payment");
	    }
	}
	return avaPaymentCO;
    }

    public AvaPaymentLkpDAO getAvaPaymentLkpDAO()
    {
        return avaPaymentLkpDAO;
    }

    public void setAvaPaymentLkpDAO(AvaPaymentLkpDAO avaPaymentLkpDAO)
    {
        this.avaPaymentLkpDAO = avaPaymentLkpDAO;
    }




}
