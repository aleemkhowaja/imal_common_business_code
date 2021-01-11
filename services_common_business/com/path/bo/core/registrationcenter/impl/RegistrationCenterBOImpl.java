package com.path.bo.core.registrationcenter.impl;

import java.util.List;

import com.path.bo.core.registrationcenter.RegistrationCenterBO;
import com.path.dao.core.registrationcenter.RegistrationCenterDAO;
import com.path.dbmaps.vo.CTS_REGISTER_CENTERVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.registrationcenter.RegistrationCenterSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * RegistrationCenterBOImpl.java used to
 */
public class RegistrationCenterBOImpl extends BaseBO implements RegistrationCenterBO
{
	RegistrationCenterDAO registrationCenterDAO;
	 /**
	 * Method used to return Count of RegistrationCenter
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws BaseException
	 */	
	public int returnRegistrationCenterListCount(RegistrationCenterSC criteria) throws BaseException
	{
		return registrationCenterDAO.returnRegistrationCenterListCount(criteria);
	}
	/**
	 * Method used to return List of RegistrationCenter
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws BaseException
	 */
	public List returnRegistrationCenterList(RegistrationCenterSC criteria) throws BaseException
	{
		return registrationCenterDAO.returnRegistrationCenterList(criteria);
	}

	public RegistrationCenterDAO getRegistrationCenterDAO()
	{
		return registrationCenterDAO;
	}
	public void setRegistrationCenterDAO(RegistrationCenterDAO registrationCenterDAO)
	{
		this.registrationCenterDAO = registrationCenterDAO;
	}
	
	public CTS_REGISTER_CENTERVO dependencyByRegCode(RegistrationCenterSC criteria) throws BaseException
	{
	    return registrationCenterDAO.dependencyByRegCode(criteria);
	}
}
