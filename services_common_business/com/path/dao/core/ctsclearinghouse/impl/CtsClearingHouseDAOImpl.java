package com.path.dao.core.ctsclearinghouse.impl;

import java.util.List;

import com.path.dao.core.ctsclearinghouse.CtsClearingHouseDAO;
import com.path.dbmaps.vo.CTSCLEARINGHOUSEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.ctsclearinghouse.CtsClearingHouseSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * CtsClearingHouseDAOImpl.java used to
 */
public class CtsClearingHouseDAOImpl extends BaseDAO implements CtsClearingHouseDAO
{

    @Override
    public List ctsClearingHouseList(CtsClearingHouseSC ctsClearingHouseSC) throws DAOException
    {
	if(ctsClearingHouseSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("ctsClearingHouseMapper.ctsClearingHouseList", ctsClearingHouseSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(ctsClearingHouseSC, getSqlMap(), "ctsClearingHouseMapper.ctsClearingHouseList_ResMap");
	    return getSqlMap().queryForList("ctsClearingHouseMapper.ctsClearingHouseList", ctsClearingHouseSC, ctsClearingHouseSC.getRecToskip(),
		    ctsClearingHouseSC.getNbRec());
	}
    }

    @Override
    public int ctsClearingHouseListCount(CtsClearingHouseSC ctsClearingHouseSC) throws DAOException
    {
	DAOHelper.fixGridMaps(ctsClearingHouseSC, getSqlMap(), "ctsClearingHouseMapper.ctsClearingHouseList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("ctsClearingHouseMapper.ctsClearingHouseListCount", ctsClearingHouseSC)).intValue();
	return nb;
    }

    @Override
    public CTSCLEARINGHOUSEVO returnCtsClearingHouseById(CtsClearingHouseSC ctsClearingHouseSC) throws DAOException
    {
	return (CTSCLEARINGHOUSEVO) getSqlMap().queryForObject("ctsClearingHouseMapper.ctsClearingHouseById", ctsClearingHouseSC);
    }


    /**
     * Clearing house on and off BS accounts details grid
     */
    public  List ctsClearingHouseListGrid(CtsClearingHouseSC criteria) throws DAOException
    {
    	DAOHelper.fixGridMaps(criteria, getSqlMap(), "ctsClearingHouseMapper.ctsClearingMap");
    	if(criteria.getNbRec() == -1)
    	{
    	    return  getSqlMap().queryForList("ctsClearingHouseMapper.ctsClearingHouseListGrid", criteria);
    	}
    	else
    	{
    	    return getSqlMap().queryForList("ctsClearingHouseMapper.ctsClearingHouseListGrid", criteria, criteria.getRecToskip(),criteria.getNbRec());
    	}
        
    }

    /**
     * Count for Clearing house on and off BS accounts details grid
     */
    public int ctsClearingHouseListGridCount(CtsClearingHouseSC ctsClearingHouseSC) throws DAOException
    {
	DAOHelper.fixGridMaps(ctsClearingHouseSC, getSqlMap(), "ctsClearingHouseMapper.ctsClearingMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("ctsClearingHouseMapper.ctsClearingHouseListGridCount", ctsClearingHouseSC)).intValue();
	return nb;
    }

    
    
	@Override
	public Integer clearingHouseByCompLkpCount(CtsClearingHouseSC criteria)  throws BaseException{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "ctsClearingHouseMapper.ctsClearingMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("ctsClearingHouseMapper.clearingHouseByCompLkpCount", criteria)).intValue();
		return nb;
	}

	@Override
	public List<CTSCLEARINGHOUSEVO> clearingHouseByCompLkpList( CtsClearingHouseSC criteria)  throws BaseException{
    	DAOHelper.fixGridMaps(criteria, getSqlMap(), "ctsClearingHouseMapper.ctsClearingMap");
    	if(criteria.getNbRec() == -1)
    	{
 
    	    return  getSqlMap().queryForList("ctsClearingHouseMapper.clearingHouseByCompLkpList", criteria);
    	}
    	else
    	{
    	    return getSqlMap().queryForList("ctsClearingHouseMapper.clearingHouseByCompLkpList", criteria, criteria.getRecToskip(),criteria.getNbRec());
    	}
	}

	@Override
	public CTSCLEARINGHOUSEVO clearingHouseDepByCode(CtsClearingHouseSC criteria) throws BaseException {
		return  (CTSCLEARINGHOUSEVO) getSqlMap().queryForObject("ctsClearingHouseMapper.clearingHouseDepByCode", criteria);
	}
	
	public CTSCLEARINGHOUSEVO returnCtsClearingHouse(CtsClearingHouseSC criteria) throws DAOException
	{
	    return  (CTSCLEARINGHOUSEVO) getSqlMap().queryForObject("ctsClearingHouseMapper.returnCtsClearingHouse", criteria); 
	}

    
    
}
