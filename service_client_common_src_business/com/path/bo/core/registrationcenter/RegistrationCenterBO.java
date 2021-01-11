package com.path.bo.core.registrationcenter;

import java.util.List;

import com.path.dbmaps.vo.CTS_REGISTER_CENTERVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.registrationcenter.RegistrationCenterSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * RegistrationCenterBO.java used to
 */
public interface RegistrationCenterBO 
{
	public int returnRegistrationCenterListCount(RegistrationCenterSC criteria) throws BaseException;
	public List returnRegistrationCenterList(RegistrationCenterSC criteria) throws BaseException;
	public CTS_REGISTER_CENTERVO dependencyByRegCode(RegistrationCenterSC criteria) throws BaseException;
	
}