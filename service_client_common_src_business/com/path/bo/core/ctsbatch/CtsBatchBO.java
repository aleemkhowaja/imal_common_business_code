package com.path.bo.core.ctsbatch;

import java.util.List;

import com.path.dbmaps.vo.CTSBATCHVO;
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
public interface CtsBatchBO
{

    public Integer batchLookupCount(CtsBatchSC criteria) throws BaseException;

    public List<CTSBATCHVO> batchLookupList(CtsBatchSC criteria) throws BaseException;

}
