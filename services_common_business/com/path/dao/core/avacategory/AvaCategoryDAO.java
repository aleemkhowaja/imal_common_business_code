package com.path.dao.core.avacategory;

import java.util.List;

import com.path.dbmaps.vo.CTS_AVA_CATEGVO;
import com.path.dbmaps.vo.CTS_AVA_CATEG_PAY_LIMITVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.avacategory.AvaCategorySC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryDAO.java used to
 */
public interface AvaCategoryDAO
{
    public int returnAvaCategoryLookupCount(AvaCategorySC criteria) throws DAOException;

    public List returnAvaCategoryLookup(AvaCategorySC criteria) throws DAOException;

    public CTS_AVA_CATEGVO dependencyForAvaCategory(AvaCategorySC criteria) throws DAOException;
    
    public CTS_AVA_CATEG_PAY_LIMITVO returnAvaCategoryPayLimit(AvaCategorySC criteria) throws DAOException;
    
    

}