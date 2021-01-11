package com.path.dao.core.smsservices;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.smsservices.SmsServicesSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * SmsServicesDAO.java used to
 */
public interface SmsServicesDAO 
{
	public int returnSmsServicesLookupCount(SmsServicesSC criteria) throws DAOException;
	public List returnSmsServicesLookup(SmsServicesSC criteria) throws DAOException;
	
}