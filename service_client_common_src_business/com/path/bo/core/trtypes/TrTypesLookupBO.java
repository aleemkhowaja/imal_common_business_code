package com.path.bo.core.trtypes;

import java.util.List;

import com.path.dbmaps.vo.TR_TYPESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.trtypes.TrTypesSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: HanaaElJazzar
 * 
 *          TrTypesLookupBO.java used to list methods used to retrieve Tr_Types
 *          data.
 */
public interface TrTypesLookupBO
{
    /**
     * Return TR_TYPES List based on compCode.
     * 
     * @param trTypeSC
     * @return List
     * @throws BaseException
     * @author HanaaElJazzar
     */
    List returnTrTypesList(TrTypesSC trTypeSC) throws BaseException;

    /**
     * Return TR_TYPES record details based on compCode and TR_CODE.
     * 
     * @param trTypeSC
     * @return TR_TYPESVO
     * @throws BaseException
     * @author HanaaElJazzar
     */
    TR_TYPESVO returnTrTypeDetails(TrTypesSC trTypeSC) throws BaseException;

    /**
     * Return TR_TYPES List count based on compCode.
     * 
     * @param trTypeSC
     * @return int
     * @throws BaseException
     * @author HanaaElJazzar
     */
    int returnTrTypesListCount(TrTypesSC trTypeSC) throws BaseException;
}
