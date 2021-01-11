package com.path.dao.core.trtypes;

import java.util.List;

import com.path.dbmaps.vo.TR_TYPESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.trtypes.TrTypesSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: HanaaElJazzar
 * 
 *          TrTypesLookupDAO.java used to list methods used in retrieving data
 *          from TR_Types.
 */
public interface TrTypesLookupDAO
{
    /**
     * Return TR_TYPES List based on compCode.
     * 
     * @param trTypesSC
     * @return List
     * @throws DAOException
     * @author HanaaElJazzar
     */
    List returnTrTypesList(TrTypesSC trTypesSC) throws DAOException;

    /**
     * Return TR_TYPES record details based on compCode and TR_CODE.
     * 
     * @param trTypeSC
     * @return TR_TYPESVO
     * @throws DAOException
     * @author HanaaElJazzar
     */
    TR_TYPESVO returnTrTypeDetails(TrTypesSC trTypeSC) throws DAOException;

    /**
     * Return TR_TYPES List Count based on compCode.
     * 
     * @param trTypesSC
     * @return int
     * @throws DAOException
     * @author HanaaElJazzar
     */
    int returnTrTypesListCount(TrTypesSC trTypesSC) throws DAOException;
}
