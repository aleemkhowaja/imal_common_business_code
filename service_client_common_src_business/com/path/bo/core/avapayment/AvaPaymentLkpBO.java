package com.path.bo.core.avapayment;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.avapayment.AvaPaymentCO;
import com.path.vo.core.avapayment.AvaPaymentLkpSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryBO.java used to
 */
public interface AvaPaymentLkpBO
{
    public int returnAvaPaymentLookupCount(AvaPaymentLkpSC criteria) throws BaseException;
    
    public int returnAvaPaymentTrxLookupCount(AvaPaymentLkpSC criteria) throws BaseException;
    

    public List returnAvaPaymentLookupList(AvaPaymentLkpSC criteria) throws BaseException;
    
    public List returnAvaPaymentTrxLookupList(AvaPaymentLkpSC criteria) throws BaseException;
    

    public AvaPaymentCO dependencyForAvaPayment(AvaPaymentLkpSC criteria) throws BaseException;
}