package com.path.bo.core.smsservices;

import java.util.List;

import com.path.dbmaps.vo.SMS_SERVICESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.smsservices.SmsServicesSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * SmsServicesBO.java used to
 */
public interface SmsServicesBO 
{
	public int returnSmsServicesLookupCount(SmsServicesSC criteria) throws BaseException;
	public List<SMS_SERVICESVO> returnSmsServicesLookup(SmsServicesSC criteria) throws BaseException;
}