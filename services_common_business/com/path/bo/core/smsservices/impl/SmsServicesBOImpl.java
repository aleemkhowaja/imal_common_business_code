package com.path.bo.core.smsservices.impl;

import java.util.List;

import com.path.bo.core.smsservices.SmsServicesBO;
import com.path.dao.core.smsservices.SmsServicesDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.smsservices.SmsServicesSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * SmsServicesBOImpl.java used to
 */
public class SmsServicesBOImpl extends BaseBO implements SmsServicesBO
{
    SmsServicesDAO smsServicesDAO;

    /**
     * Method used to return Lookup Count of SmsServices
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws BaseException
     */
    public int returnSmsServicesLookupCount(SmsServicesSC criteria) throws BaseException
    {
	return smsServicesDAO.returnSmsServicesLookupCount(criteria);
    }

    /**
     * Method used to return Lookup List of SmsServices
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws BaseException
     */
    public List returnSmsServicesLookup(SmsServicesSC criteria) throws BaseException
    {
	return smsServicesDAO.returnSmsServicesLookup(criteria);
    }

    public SmsServicesDAO getSmsServicesDAO()
    {
	return smsServicesDAO;
    }

    public void setSmsServicesDAO(SmsServicesDAO smsServicesDAO)
    {
	this.smsServicesDAO = smsServicesDAO;
    }
}
