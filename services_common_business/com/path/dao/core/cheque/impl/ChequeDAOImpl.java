package com.path.dao.core.cheque.impl;

import java.util.List;

import com.path.dao.core.cheque.ChequeDAO;
import com.path.dbmaps.vo.CTSCHEQUESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cheque.ChequeCO;
import com.path.vo.core.cheque.ChequeSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeDAOImpl.java
 */
public class ChequeDAOImpl extends BaseDAO implements ChequeDAO
{

	/**
	 * chequesLkpCount.
	 */
	public int chequesLkpCount(ChequeSC chequeSC) throws DAOException 
	{
		DAOHelper.fixGridMaps(chequeSC, getSqlMap(), "chequeMappers.chequesLkpMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("chequeMappers.chequesLkpCount", chequeSC)).intValue();
		return nb;
	}

	/**
	 * chequesLkpRecords.
	 */
	public List chequesLkpRecords(ChequeSC criteria) throws DAOException 
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "chequeMappers.chequesLkpMap");

		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("chequeMappers.chequesLkpRecords", criteria);
		}
		else
		{
		    return getSqlMap().queryForList("chequeMappers.chequesLkpRecords", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	public ChequeCO loadChequeRequestByCode(ChequeCO cheque) throws DAOException 
	{
		ChequeCO resultcheque = (ChequeCO)getSqlMap().queryForObject("chequeMappers.chequeRequestByCodeInfo", cheque);
		return (resultcheque==null)?(new ChequeCO()):resultcheque;
	}

	@Override
	public CTSCHEQUESVO returnDefaultedChequeByCifTypeCode(ChequeSC criteria) throws DAOException
	{
		return (CTSCHEQUESVO) getSqlMap().queryForObject("chequeMappers.returnDefaultedChequeByCifTypeCode", criteria);
	}

//	@Override
//	public List chequesLkpRecords(ChequeSC chequeSC) throws DAOException
//	{
//	    // TODO Auto-generated method stub
//	    return null;
//	}

    public CTSCHEQUESVO returnDefaultedBillByCifTypeCode(ChequeSC criteria) throws DAOException
    {
	return (CTSCHEQUESVO) getSqlMap().queryForObject("chequeMappers.returnDefaultedBillByCifTypeCode", criteria);
    }
}