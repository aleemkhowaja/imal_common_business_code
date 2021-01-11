package com.path.dao.core.avapayment;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.avapayment.AvaPaymentCO;
import com.path.vo.core.avapayment.AvaPaymentLkpSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryDAO.java used to
 */
public interface AvaPaymentLkpDAO
{
    public int returnAvaPaymentLookupCount(AvaPaymentLkpSC criteria) throws DAOException;

    public List returnAvaPaymentLookup(AvaPaymentLkpSC criteria) throws DAOException;
    
    public int returnAvaPaymentTrxLookupCount(AvaPaymentLkpSC criteria) throws DAOException;

    public List returnAvaPaymentTrxLookup(AvaPaymentLkpSC criteria) throws DAOException;

    public AvaPaymentCO dependencyForAvaPayment(AvaPaymentLkpSC criteria) throws DAOException;

}