package com.path.bo.core.ctsoperationstype;

import java.util.List;

import com.path.dbmaps.vo.CTS_OPERATIONS_TYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.ctsoperationstype.CtsOperationsTypeLkpSC;

public interface CtsOperationsTypeLkpBO
{
    public List<CTS_OPERATIONS_TYPEVO> returnOperationTypeLookupList(CtsOperationsTypeLkpSC criteria) throws BaseException;
    
    public int returnOperationTypeLookupCount(CtsOperationsTypeLkpSC criteria) throws BaseException;
    
    public CTS_OPERATIONS_TYPEVO returnOperationTypeByCode(CtsOperationsTypeLkpSC criteria) throws BaseException;
}
