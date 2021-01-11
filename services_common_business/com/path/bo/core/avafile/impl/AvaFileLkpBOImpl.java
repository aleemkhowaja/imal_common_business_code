package com.path.bo.core.avafile.impl;

import java.util.List;

import com.path.bo.core.avafile.AvaFileLkpBO;
import com.path.dao.core.avafile.AvaFileLkpDAO;
import com.path.dbmaps.vo.CTS_AVA_FILEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.avafile.AvaFileLkpSC;



/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaFileLkpBOImpl.java used to
 */
public class AvaFileLkpBOImpl extends BaseBO implements AvaFileLkpBO
{
    AvaFileLkpDAO avaFileLkpDAO;
    
    /**
     * Method used to return Lookup Count of AvaFile
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws BaseException
     */
    public int returnAvaFileLookupCount(AvaFileLkpSC criteria) throws BaseException
    {		
	return avaFileLkpDAO.returnAvaFileLookupCount(criteria);
    }

    /**
     * Method used to return Lookup List of AvaFile
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws BaseException
     */
    public List returnAvaFileLookupList(AvaFileLkpSC criteria) throws BaseException
    {
	return avaFileLkpDAO.returnAvaFileLookup(criteria);
    }

    /**
     * Method used to return dependency of AvaFile
     * 
     * @param criteria Search Criteria Parameter
     * @return AvaFileVO Result object for dependency
     * @throws BaseException
     */
    public CTS_AVA_FILEVO dependencyForAvaFile(AvaFileLkpSC criteria) throws BaseException
    {
	CTS_AVA_FILEVO avaFileVO = null;
	if(!NumberUtil.isEmptyDecimal(criteria.getFileCode()))
	{
	    avaFileVO = avaFileLkpDAO.dependencyForAvaFile(criteria);
	    if(avaFileVO == null)
	    {
		throw new BOException("Invalid/Missing AVA File");
	    }
	}
	return avaFileVO;
    }

    public AvaFileLkpDAO getAvaFileLkpDAO()
    {
        return avaFileLkpDAO;
    }

    public void setAvaFileLkpDAO(AvaFileLkpDAO avaFileLkpDAO)
    {
        this.avaFileLkpDAO = avaFileLkpDAO;
    }


}
