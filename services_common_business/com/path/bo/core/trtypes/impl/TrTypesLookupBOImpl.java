package com.path.bo.core.trtypes.impl;

import java.util.List;

import com.path.bo.core.trtypes.TrTypesLookupBO;
import com.path.dao.core.trtypes.TrTypesLookupDAO;
import com.path.dbmaps.vo.TR_TYPESVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.trtypes.TrTypesSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: HanaaElJazzar
 * 
 *          TrTypesLookupBOImpl.java used to list functions used in Tr_Types
 *          data retrieve.
 */
public class TrTypesLookupBOImpl extends BaseBO implements TrTypesLookupBO
{
    private TrTypesLookupDAO trTypesLookupDAO;

    /**
     * return the Tr_Types list count based on compCode only
     * 
     * @param trTypesSC
     * @return int
     * @throws BaseException
     */
    @Override
    public int returnTrTypesListCount(TrTypesSC trTypesSC) throws BaseException
    {
	return trTypesLookupDAO.returnTrTypesListCount(trTypesSC);
    }

    /**
     * return the Tr_Types list based on compCode only
     * 
     * @param trTypesSC
     * @return List
     * @throws BaseException
     */
    @Override
    public List returnTrTypesList(TrTypesSC trTypesSC) throws BaseException
    {
	return trTypesLookupDAO.returnTrTypesList(trTypesSC);
    }

    /**
     * return the Tr_Type Code based on compCode
     * 
     * @param trTypesVO
     * @return TR_TYPESVO
     * @throws BaseException
     */
    @Override
    public TR_TYPESVO returnTrTypeDetails(TrTypesSC trTypesSC) throws BaseException
    {
	return trTypesLookupDAO.returnTrTypeDetails(trTypesSC);
    }

    public TrTypesLookupDAO getTrTypesLookupDAO()
    {
	return trTypesLookupDAO;
    }

    public void setTrTypesLookupDAO(TrTypesLookupDAO trTypesLookupDAO)
    {
	this.trTypesLookupDAO = trTypesLookupDAO;
    }
}
