package com.path.dao.core.ctsoperationstype.impl;

import java.util.ArrayList;
import java.util.List;

import com.path.dao.core.ctsoperationstype.CtsOperationsTypeLkpDAO;
import com.path.dbmaps.vo.CTS_OPERATIONS_TYPEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.ctsoperationstype.CtsOperationsTypeLkpSC;

public class CtsOperationsTypeLkpDAOImpl extends BaseDAO implements CtsOperationsTypeLkpDAO
{
    @Override
    public List<CTS_OPERATIONS_TYPEVO> returnOperationTypeLookupList(CtsOperationsTypeLkpSC criteria)
	    throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "ctsOperationsTypeLkpMapper.returnOperationTypeLookupMap");
	return (ArrayList<CTS_OPERATIONS_TYPEVO>) getSqlMap().queryForList(
		"ctsOperationsTypeLkpMapper.returnOperationTypeLookupList", criteria, criteria.getRecToskip(),
		criteria.getNbRec());
    }

    @Override
    public int returnOperationTypeLookupCount(CtsOperationsTypeLkpSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "ctsOperationsTypeLkpMapper.returnOperationTypeLookupMap");
	return ((Integer) getSqlMap().queryForObject("ctsOperationsTypeLkpMapper.returnOperationTypeLookupCount", criteria))
		.intValue();
    }
    
    public CTS_OPERATIONS_TYPEVO returnOperationTypeByCode(CtsOperationsTypeLkpSC criteria) throws DAOException
    {
	return (CTS_OPERATIONS_TYPEVO)getSqlMap().queryForObject("ctsOperationsTypeLkpMapper.returnOperationTypeByCode", criteria);
    }
}
