package com.path.bo.core.avacategory;

import java.util.List;

import com.path.dbmaps.vo.CTS_AVA_CATEGVO;
import com.path.dbmaps.vo.CTS_AVA_CATEG_PAY_LIMITVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.avacategory.AvaCategorySC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryBO.java used to
 */
public interface AvaCategoryBO
{
    public int returnAvaCategoryLookupCount(AvaCategorySC criteria) throws BaseException;

    public List returnAvaCategoryLookup(AvaCategorySC criteria) throws BaseException;

    public CTS_AVA_CATEGVO dependencyForAvaCategory(AvaCategorySC criteria) throws BaseException;
    
    public CTS_AVA_CATEG_PAY_LIMITVO returnAvaCategoryPayLimit(AvaCategorySC criteria) throws BaseException;
}