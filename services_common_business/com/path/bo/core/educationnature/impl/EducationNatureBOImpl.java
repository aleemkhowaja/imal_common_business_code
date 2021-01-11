package com.path.bo.core.educationnature.impl;

import java.util.List;

import com.path.bo.core.educationnature.EducationNatureBO;
import com.path.dao.core.educationnature.EducationNatureDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.educationnature.EducationNatureCO;
import com.path.vo.core.educationnature.EducationNatureSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * EducationNatureBOImpl.java used to
 */
public class EducationNatureBOImpl extends BaseBO implements EducationNatureBO
{
	EducationNatureDAO educationNatureDAO;
	/**
	 * Method used to return Lookup Count of EducationNature
	 * @param criteria Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws BaseException
	 */	
	public int returnEducationNatureLookupCount(EducationNatureSC criteria) throws BaseException
	{
		return educationNatureDAO.returnEducationNatureLookupCount(criteria);
	}
	/**
	 * Method used to return Lookup List of EducationNature
	 * @param criteria Search Criteria Parameter
	 * @return List Result
	 * @throws BaseException
	 */
	public List returnEducationNatureLookup(EducationNatureSC criteria) throws BaseException
	{
		return educationNatureDAO.returnEducationNatureLookup(criteria);
	}
	/**
	 * Method used to return dependency of EducationNature
	 * @param criteria Search Criteria Parameter
	 * @return EducationNatureCO Result object for dependency
	 * @throws BaseException
	 */
	public EducationNatureCO dependencyByEducationNature(EducationNatureSC criteria) throws BaseException
	{
		return educationNatureDAO.dependencyByEducationNature(criteria);
	}
	public EducationNatureDAO getEducationNatureDAO()
	{
		return educationNatureDAO;
	}
	public void setEducationNatureDAO(EducationNatureDAO educationNatureDAO)
	{
		this.educationNatureDAO = educationNatureDAO;
	}
}
