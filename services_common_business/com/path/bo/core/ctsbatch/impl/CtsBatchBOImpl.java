package com.path.bo.core.ctsbatch.impl;

import java.util.List;

import com.path.bo.core.ctsbatch.CtsBatchBO;
import com.path.dao.core.ctsbatch.CtsBatchDAO;
import com.path.dbmaps.vo.CTSBATCHVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.ctsbatch.CtsBatchSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: EliasAoun
 * 
 *          CtsBatchBO.java used to retrieve data related to CTS_BATCH
 */
public class CtsBatchBOImpl extends BaseBO implements CtsBatchBO
{
    private CtsBatchDAO ctsBatchDAO;

    public void setCtsBatchDAO(CtsBatchDAO ctsBatchDAO)
    {
	this.ctsBatchDAO = ctsBatchDAO;
    }

    @Override
    public Integer batchLookupCount(CtsBatchSC criteria) throws BaseException
    {
	return ctsBatchDAO.batchLookupCount( criteria);
    }

    @Override
    public List<CTSBATCHVO> batchLookupList(CtsBatchSC criteria) throws BaseException
    {
	return ctsBatchDAO.batchLookupList( criteria);
    }

}
