package com.path.bo.core.legalstatus.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.legalstatus.LegalStatusBO;
import com.path.dao.core.legalstatus.LegalStatusDAO;
import com.path.dbmaps.vo.LEGAL_STATUSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.legalstatus.LegalStatusSC;

public class LegalStatusBOImpl extends BaseBO implements LegalStatusBO
{

    private LegalStatusDAO legalStatusDAO;

    public LegalStatusDAO getLegalStatusDAO()
    {
	return legalStatusDAO;
    }

    public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO)
    {
	this.legalStatusDAO = legalStatusDAO;
    }

    @Override
    public List legalStatusList(LegalStatusSC legalStatusSC) throws BaseException
    {
	return legalStatusDAO.legalStatusList(legalStatusSC);
    }

    @Override
    public int legalStatusListCount(LegalStatusSC legalStatusSC) throws BaseException
    {
	return legalStatusDAO.legalStatusListCount(legalStatusSC);
    }

    @Override
    public LEGAL_STATUSVO returnDependencyByStatusCode(LegalStatusSC legalStatusSC) throws BaseException
    {
	LEGAL_STATUSVO legalStatusVO = legalStatusDAO.returnDependencyByStatusCode(legalStatusSC);
	if(legalStatusVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_LEGAL_STATUS_CODE);
	}
	return legalStatusVO;
    
    }

}
