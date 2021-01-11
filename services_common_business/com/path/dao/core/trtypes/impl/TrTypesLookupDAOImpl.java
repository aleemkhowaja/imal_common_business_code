package com.path.dao.core.trtypes.impl;

import java.util.List;

import com.path.dao.core.trtypes.TrTypesLookupDAO;
import com.path.dbmaps.vo.TR_TYPESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.trtypes.TrTypesSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: HanaaElJazzar
 * 
 *          TrTypesLookupDAOImpl.java used to implement listed methods used to
 *          retrieve data from TR_TYPES.
 */
public class TrTypesLookupDAOImpl extends BaseDAO implements TrTypesLookupDAO
{
    /**
     * return the Tr_Types list based on compCode only
     * 
     * @param trTypesSC
     * @return List
     * @throws DAOException
     */
    @Override
    public List returnTrTypesList(TrTypesSC trTypesSC) throws DAOException
    {
	DAOHelper.fixGridMaps(trTypesSC, getSqlMap(), "TrTypesLookupMapper.BaseResultMap");
	if(trTypesSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("TrTypesLookupMapper.returnTrTypesList", trTypesSC);
	}
	else
	{
	    return getSqlMap().queryForList("TrTypesLookupMapper.returnTrTypesList", trTypesSC,
		    trTypesSC.getRecToskip(), trTypesSC.getNbRec());
	}
    }

    /**
     * Return TR_TYPES record details based on compCode and TR_CODE.
     * 
     * @param trTypeSC
     * @return TR_TYPESVO
     * @throws DAOException
     * @author HanaaElJazzar
     */
    public TR_TYPESVO returnTrTypeDetails(TrTypesSC trTypeSC) throws DAOException
    {
	return (TR_TYPESVO) getSqlMap().queryForObject("TrTypesLookupMapper.returnTrTypeDetails", trTypeSC);
    }

    /**
     * return the Tr_Types list count based on compCode only
     * 
     * @param trTypesSC
     * @return int
     * @throws BaseException
     */
    @Override
    public int returnTrTypesListCount(TrTypesSC trTypesSC) throws DAOException
    {
	DAOHelper.fixGridMaps(trTypesSC, getSqlMap(), "TrTypesLookupMapper.BaseResultMap");
	int nb;
	nb = ((Integer) getSqlMap().queryForObject("TrTypesLookupMapper.returnTrTypesListCount", trTypesSC)).intValue();
	return nb;
    }
}
