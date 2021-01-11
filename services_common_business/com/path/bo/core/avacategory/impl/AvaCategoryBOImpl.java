package com.path.bo.core.avacategory.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.avacategory.AvaCategoryBO;
import com.path.dao.core.avacategory.AvaCategoryDAO;
import com.path.dbmaps.vo.CTS_AVA_CATEGVO;
import com.path.dbmaps.vo.CTS_AVA_CATEG_PAY_LIMITVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.avacategory.AvaCategorySC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryBOImpl.java used to
 */
public class AvaCategoryBOImpl extends BaseBO implements AvaCategoryBO
{
    AvaCategoryDAO avaCategoryDAO;

    /**
     * Method used to return Lookup Count of AvaCategory
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws BaseException
     */
    public int returnAvaCategoryLookupCount(AvaCategorySC criteria) throws BaseException
    {
	return avaCategoryDAO.returnAvaCategoryLookupCount(criteria);
    }

    /**
     * Method used to return Lookup List of AvaCategory
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws BaseException
     */
    public List returnAvaCategoryLookup(AvaCategorySC criteria) throws BaseException
    {
	return avaCategoryDAO.returnAvaCategoryLookup(criteria);
    }

    /**
     * Method used to return dependency of AvaCategory
     * 
     * @param criteria Search Criteria Parameter
     * @return AvaCategoryCO Result object for dependency
     * @throws BaseException
     */
    public CTS_AVA_CATEGVO dependencyForAvaCategory(AvaCategorySC criteria) throws BaseException
    {
	CTS_AVA_CATEGVO avaCategVO = null;
	if(!NumberUtil.isEmptyDecimal(criteria.getAvaCategCode()))
	{
	    avaCategVO = avaCategoryDAO.dependencyForAvaCategory(criteria);
	    if(avaCategVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_AVA_CATEGORY);
	    }
	}
	return avaCategVO;
    }

    public CTS_AVA_CATEG_PAY_LIMITVO returnAvaCategoryPayLimit(AvaCategorySC criteria) throws BaseException
    {
	return avaCategoryDAO.returnAvaCategoryPayLimit(criteria);
    }
    
    public AvaCategoryDAO getAvaCategoryDAO()
    {
	return avaCategoryDAO;
    }

    public void setAvaCategoryDAO(AvaCategoryDAO avaCategoryDAO)
    {
	this.avaCategoryDAO = avaCategoryDAO;
    }
    
    
}
