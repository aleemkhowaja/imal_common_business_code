package com.path.dao.core.ctsoperationstype;

import java.util.List;

import com.path.dbmaps.vo.CTS_OPERATIONS_TYPEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.ctsoperationstype.CtsOperationsTypeLkpSC;

public interface CtsOperationsTypeLkpDAO
{

    public List<CTS_OPERATIONS_TYPEVO> returnOperationTypeLookupList(CtsOperationsTypeLkpSC criteria)
	    throws DAOException;

    public int returnOperationTypeLookupCount(CtsOperationsTypeLkpSC criteria) throws DAOException;
    
    public CTS_OPERATIONS_TYPEVO returnOperationTypeByCode(CtsOperationsTypeLkpSC criteria) throws DAOException;
}
