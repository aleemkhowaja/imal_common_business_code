package com.path.bo.core.ctsclearinghouse.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.ctsclearinghouse.CtsClearingHouseBO;
import com.path.dao.core.ctsclearinghouse.CtsClearingHouseDAO;
import com.path.dbmaps.vo.CTSCLEARINGHOUSEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.ctsclearinghouse.CtsClearingHouseSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * CtsClearingHouseBOImpl.java used to
 */
public class CtsClearingHouseBOImpl extends BaseBO implements CtsClearingHouseBO
{
    private CtsClearingHouseDAO ctsClearingHouseDAO;
    
    public CtsClearingHouseDAO getCtsClearingHouseDAO()
    {
        return ctsClearingHouseDAO;
    }

    public void setCtsClearingHouseDAO(CtsClearingHouseDAO ctsClearingHouseDAO)
    {
        this.ctsClearingHouseDAO = ctsClearingHouseDAO;
    }
    
    @Override
    public List ctsClearingHouseList(CtsClearingHouseSC ctsClearingHouseSC) throws BaseException
    {
	return ctsClearingHouseDAO.ctsClearingHouseList(ctsClearingHouseSC);
    }

    @Override
    public int ctsClearingHouseListCount(CtsClearingHouseSC ctsClearingHouseSC) throws BaseException
    {
	return ctsClearingHouseDAO.ctsClearingHouseListCount(ctsClearingHouseSC);
    }

    @Override
    public CTSCLEARINGHOUSEVO returnCtsClearingHouseById(CtsClearingHouseSC ctsClearingHouseSC) throws BaseException
    {
	return ctsClearingHouseDAO.returnCtsClearingHouseById(ctsClearingHouseSC);
    }
    
    
    
    /**
     * Clearing house on and off BS accounts details grid
     */
    public List ctsClearingHouseListGrid(CtsClearingHouseSC ctsClearingHouseSC) throws BaseException
    {
	return ctsClearingHouseDAO.ctsClearingHouseListGrid(ctsClearingHouseSC);
    }

    /**
     * Count of Clearing house on and off BS accounts details
     */
    public int ctsClearingHouseListGridCount(CtsClearingHouseSC ctsClearingHouseSC) throws BaseException
    {
	return ctsClearingHouseDAO.ctsClearingHouseListGridCount(ctsClearingHouseSC);
    }

    
	@Override
	public Integer clearingHouseByCompLkpCount(CtsClearingHouseSC criteria)  throws BaseException{
		return ctsClearingHouseDAO.clearingHouseByCompLkpCount( criteria);
	}

	@Override
	public List<CTSCLEARINGHOUSEVO> clearingHouseByCompLkpList( CtsClearingHouseSC criteria) throws BaseException {
		return ctsClearingHouseDAO.clearingHouseByCompLkpList( criteria);
	}

	@Override
	public CTSCLEARINGHOUSEVO clearingHouseDepByCode(CtsClearingHouseSC criteria) throws BaseException {
		CTSCLEARINGHOUSEVO theVO = ctsClearingHouseDAO.clearingHouseDepByCode( criteria);
		if(theVO==null)
		{
			throw new BOException( MessageCodes.Invalid_Clearing_House_code);
		}
		return theVO;
	}
	
	public CTSCLEARINGHOUSEVO returnCtsClearingHouse(CtsClearingHouseSC criteria) throws BaseException
	{
	    return ctsClearingHouseDAO.returnCtsClearingHouse(criteria);
	}

}
