/**
 * 
 */
package com.path.bo.core.reason.impl;

import java.util.List;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.reason.ReasonBO;
import com.path.dao.core.reason.ReasonDAO;
import com.path.dbmaps.vo.AML_REASONVO;
import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.reason.ReasonSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          ReasonBOImpl.java used to
 */
public class ReasonBOImpl extends BaseBO implements ReasonBO
{
    private ReasonDAO reasonDAO;

    public void setReasonDAO(ReasonDAO reasonDAO)
    {
	this.reasonDAO = reasonDAO;
    }

    @Override
    public int reasonLookupCount(ReasonSC reasonSC) throws BaseException
    {
	return reasonDAO.reasonsCount(reasonSC);
    }

    @Override
    public List<CTSREASONSVO> reasonLookupList(ReasonSC reasonSC) throws BaseException
    {
	return reasonDAO.reasonsList(reasonSC);
    }
    

    @Override
    public CTSREASONSVO returnReasonByCode(ReasonSC reasonSC) throws BaseException
    {
	CTSREASONSVO ctsReasonsVO =  (CTSREASONSVO) reasonDAO.returnReasonByCode(reasonSC);
	//Hasan Bug#491743 01/03/2017
	if(ctsReasonsVO == null && "true".equals(StringUtil.nullToEmpty(reasonSC.getShowMessage())))
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_REASON_CODE);
	}
	
	return ctsReasonsVO;
    }

    @Override
    public CTSREASONSVO returnReasonsRelatedToTrxType(ReasonSC reasonSC) throws BaseException
    {
	return (CTSREASONSVO) reasonDAO.returnReasonsRelatedToTrxType(reasonSC);
    }

    @Override
    public Integer loadBillPurposeCount(ReasonSC reasonSC) throws BaseException
    {
	return reasonDAO.loadBillPurposeCount(reasonSC);
    }

    @Override
    public List<CTSREASONSVO> loadBillPurposeList(ReasonSC reasonSC) throws BaseException
    {
	return reasonDAO.loadBillPurposeList(reasonSC);
    }
    
    // added BY NOUR  for #864398

    public int amlReasonLookupCount(ReasonSC reasonSC) throws BaseException
    {
	return reasonDAO.amlReasonsCount(reasonSC);
    }
  
    @Override
   
    public List<AML_REASONVO> amlReasonLookupList(ReasonSC reasonSC) throws BaseException
    {
	return reasonDAO.amlReasonsList(reasonSC);
    }
    
}
