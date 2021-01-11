package com.path.dao.core.educationnature;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.educationnature.EducationNatureCO;
import com.path.vo.core.educationnature.EducationNatureSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * EducationNatureDAO.java used to
 */
public interface EducationNatureDAO 
{
	public int returnEducationNatureLookupCount(EducationNatureSC criteria) throws DAOException;
	public List returnEducationNatureLookup(EducationNatureSC criteria) throws DAOException;
	public EducationNatureCO dependencyByEducationNature(EducationNatureSC criteria) throws DAOException;
	
}