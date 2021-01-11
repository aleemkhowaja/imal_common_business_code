package com.path.dao.core.ctsbatch;

import java.util.List;

import com.path.dbmaps.vo.CTSBATCHVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.ctsbatch.CtsBatchSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: EliasAoun
 * 
 *          CtsBatchDAO.java used to
 */
public interface CtsBatchDAO
{

    List<CTSBATCHVO> batchLookupList(CtsBatchSC criteria) throws DAOException;

    Integer batchLookupCount(CtsBatchSC criteria) throws DAOException;

}
