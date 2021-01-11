package com.path.dao.core.registrationcenter;

import java.util.List;

import com.path.dbmaps.vo.CTS_REGISTER_CENTERVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.registrationcenter.RegistrationCenterSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * RegistrationCenterDAO.java used to
 */
public interface RegistrationCenterDAO 
{
	public int returnRegistrationCenterListCount(RegistrationCenterSC criteria) throws DAOException;
	public List returnRegistrationCenterList(RegistrationCenterSC criteria) throws DAOException;
	public CTS_REGISTER_CENTERVO dependencyByRegCode(RegistrationCenterSC criteria) throws DAOException;
}