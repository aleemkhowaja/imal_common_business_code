package com.path.bo.core.visitreason.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.visitreason.VisitReasonBO;
import com.path.dao.core.visitreason.VisitReasonDAO;
import com.path.dbmaps.vo.CRM_PARAMVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.visitreason.VisitReasonSC;

/**
* 
*/
public class VisitReasonBOImpl extends BaseBO implements VisitReasonBO
{
    private VisitReasonDAO visitReasonDAO;

    public CRM_PARAMVO returnVisitReasonById(VisitReasonSC visitReasonSC) throws BaseException
    {
	return (CRM_PARAMVO) visitReasonDAO.returnVisitReasonById(visitReasonSC);

    }

    public List visitReasonList(VisitReasonSC visitReasonSC) throws BaseException
    {
	return visitReasonDAO.visitReasonList(visitReasonSC);
    }

    public int visitReasonListCount(VisitReasonSC visitReasonSC) throws BaseException
    {
	return visitReasonDAO.visitReasonListCount(visitReasonSC);
    }

    public VisitReasonDAO getVisitReasonDAO()
    {
	return visitReasonDAO;
    }

    public void setVisitReasonDAO(VisitReasonDAO visitReasonDAO)
    {
	this.visitReasonDAO = visitReasonDAO;
    }

    @Override
    public CRM_PARAMVO returnVisitReasonDesc(VisitReasonSC criteria) throws BaseException
    {

	CRM_PARAMVO crmParamVO = new CRM_PARAMVO();

	if(NumberUtil.isEmptyDecimal(criteria.getReasonCode()))
	{
	    return crmParamVO;
	}
	else
	{
	    crmParamVO = visitReasonDAO.returnVisitReasonDesc(criteria);

	    if(crmParamVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_CODE);
	    }
	}

	return crmParamVO;

    }
}