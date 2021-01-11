package com.path.bo.core.educationnature;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.educationnature.EducationNatureCO;
import com.path.vo.core.educationnature.EducationNatureSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * EducationNatureBO.java used to
 */
public interface EducationNatureBO 
{
	public int returnEducationNatureLookupCount(EducationNatureSC criteria) throws BaseException;
	public List returnEducationNatureLookup(EducationNatureSC criteria) throws BaseException;
	public EducationNatureCO dependencyByEducationNature(EducationNatureSC criteria) throws BaseException;
}