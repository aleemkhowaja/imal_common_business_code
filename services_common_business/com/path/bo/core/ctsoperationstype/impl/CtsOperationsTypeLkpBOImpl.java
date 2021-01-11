package com.path.bo.core.ctsoperationstype.impl;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.ctsoperationstype.CtsOperationsTypeLkpBO;
import com.path.dao.core.ctsoperationstype.CtsOperationsTypeLkpDAO;
import com.path.dbmaps.vo.CTS_OPERATIONS_TYPEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.ctsoperationstype.CtsOperationsTypeLkpSC;

public class CtsOperationsTypeLkpBOImpl extends BaseBO implements CtsOperationsTypeLkpBO
{
    private CtsOperationsTypeLkpDAO ctsOperationsTypeLkpDAO;

    public List<CTS_OPERATIONS_TYPEVO> returnOperationTypeLookupList(CtsOperationsTypeLkpSC criteria)
	    throws BaseException
    {
	return ctsOperationsTypeLkpDAO.returnOperationTypeLookupList(criteria);
    }

    public int returnOperationTypeLookupCount(CtsOperationsTypeLkpSC criteria) throws BaseException
    {
	return ctsOperationsTypeLkpDAO.returnOperationTypeLookupCount(criteria);
    }
    
    
    public CTS_OPERATIONS_TYPEVO returnOperationTypeByCode(CtsOperationsTypeLkpSC criteria) throws BaseException
    {
	CTS_OPERATIONS_TYPEVO operationTypeVO = new CTS_OPERATIONS_TYPEVO();
	if(!NumberUtil.isEmptyDecimal(criteria.getOperationTypeCode()))
	{
	    operationTypeVO = ctsOperationsTypeLkpDAO.returnOperationTypeByCode(criteria);
	    if(operationTypeVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CODE);
	    }
	    if(ConstantsCommon.PREFERED_LANG_ARABIC.equals(criteria.getPreferredLanguage()))
	    {
		operationTypeVO.setBRIEF_DESC_ENG(operationTypeVO.getBRIEF_DESC_ARAB());
	    }
	}
	else
	{
	    operationTypeVO.setCODE(null);
	    operationTypeVO.setBRIEF_DESC_ENG(null);
	}
	return operationTypeVO;
    }

    public CtsOperationsTypeLkpDAO getCtsOperationsTypeLkpDAO()
    {
        return ctsOperationsTypeLkpDAO;
    }

    public void setCtsOperationsTypeLkpDAO(CtsOperationsTypeLkpDAO ctsOperationsTypeLkpDAO)
    {
        this.ctsOperationsTypeLkpDAO = ctsOperationsTypeLkpDAO;
    }
}
