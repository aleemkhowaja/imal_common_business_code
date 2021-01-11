package com.path.dao.core.trxfieldsname.impl;

import java.util.List;

import com.path.dao.core.trxfieldsname.TrxFieldsNameDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.trxfieldsname.TrxFieldsNameCO;
import com.path.vo.core.trxfieldsname.TrxFieldsNameSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * TrxFieldsNameDAOImpl.java used to
 */
public class TrxFieldsNameDAOImpl extends BaseDAO implements TrxFieldsNameDAO
{
    /**
     * Method used to return Lookup Count of Transaction Name Fields
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws DAOException
     */
    public int returnTrxFieldsNameLookupCount(TrxFieldsNameSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxFieldsNameMapper.trxFieldsNameLookupMap");
	return ((Integer) getSqlMap().queryForObject("trxFieldsNameMapper.returnTrxFieldsNameLookupCount", criteria))
		.intValue();
    }

    /**
     * Method used to return Lookup of Transaction Name Fields
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws DAOException
     */
    public List<TrxFieldsNameCO> returnTrxFieldsNameLookup(TrxFieldsNameSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "trxFieldsNameMapper.trxFieldsNameLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return (List<TrxFieldsNameCO>)getSqlMap().queryForList("trxFieldsNameMapper.returnTrxFieldsNameLookup", criteria);
	}
	else
	{
	    return (List<TrxFieldsNameCO>)getSqlMap().queryForList("trxFieldsNameMapper.returnTrxFieldsNameLookup", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }
}
