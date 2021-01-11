/**
 * 
 */
package com.path.dao.core.reason.impl;

import java.util.List;
import com.path.dao.core.reason.ReasonDAO;
import com.path.dbmaps.vo.AML_REASONVO;
import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.reason.ReasonSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          ReasonDAOImpl.java used to
 */
public class ReasonDAOImpl extends BaseDAO implements ReasonDAO
{

    @Override
    public int reasonsCount(ReasonSC reasonSC) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("reasonMapper.reasonLookupCount", reasonSC)).intValue();
    }

    @Override
    public List<CTSREASONSVO> reasonsList(ReasonSC reasonSC) throws DAOException
    {
	DAOHelper.fixGridMaps(reasonSC, getSqlMap(), null);
	if(reasonSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("reasonMapper.reasonLookupRecords", reasonSC);
	}
	else
	{
	    return getSqlMap().queryForList("reasonMapper.reasonLookupRecords", reasonSC, reasonSC.getRecToskip(),
		    reasonSC.getNbRec());
	}
    }

    @Override
    public CTSREASONSVO returnReasonByCode(ReasonSC reasonSC) throws DAOException
    {
	return (CTSREASONSVO) getSqlMap().queryForObject("reasonMapper.returnReasonByCode", reasonSC);
    }

    @Override
    public CTSREASONSVO returnReasonsRelatedToTrxType(ReasonSC reasonSC) throws DAOException
    {
	return (CTSREASONSVO) getSqlMap().queryForObject("reasonMapper.returnReasonsRelatedToTrxType", reasonSC);
    }

    @Override
    public Integer loadBillPurposeCount(ReasonSC reasonSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("reasonMapper.loadBillPurposeCount", reasonSC);
    }

    @Override
    public List<CTSREASONSVO> loadBillPurposeList(ReasonSC reasonSC) throws DAOException
    {
	DAOHelper.fixGridMaps(reasonSC, getSqlMap(), null);
	if(reasonSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("reasonMapper.loadBillPurposeList", reasonSC);
	}
	else
	{
	    return getSqlMap().queryForList("reasonMapper.loadBillPurposeList", reasonSC, reasonSC.getRecToskip(),
		    reasonSC.getNbRec());
	}
    }

	
	
	// ADDED BY NOUR FOR #864398

	 @Override
		public int amlReasonsCount(ReasonSC reasonSC) throws DAOException
	    {
		return ((Integer) getSqlMap().queryForObject("reasonMapper.amlReasonLookupCount", reasonSC)).intValue();
	    }

	    @Override
	    public List<AML_REASONVO> amlReasonsList(ReasonSC reasonSC) throws DAOException
	    {
		DAOHelper.fixGridMaps(reasonSC, getSqlMap(), null);
		if(reasonSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("reasonMapper.amlReasonLookupRecords", reasonSC);
		}
		else
		{
		    return getSqlMap().queryForList("reasonMapper.amlReasonLookupRecords", reasonSC, reasonSC.getRecToskip(),
			    reasonSC.getNbRec());
		}
	    }

}
