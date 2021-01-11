package com.path.dao.core.ctsclearinghouse;

import java.util.List;

import com.path.dbmaps.vo.CTSCLEARINGHOUSEVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.ctsclearinghouse.CtsClearingHouseSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * CtsClearingHouseDAO.java used to
 */
public interface CtsClearingHouseDAO
{
    public int ctsClearingHouseListCount(CtsClearingHouseSC ctsClearingHouseSC) throws DAOException;
    public List ctsClearingHouseList(CtsClearingHouseSC ctsClearingHouseSC) throws DAOException;
    public CTSCLEARINGHOUSEVO returnCtsClearingHouseById(CtsClearingHouseSC ctsClearingHouseSC) throws DAOException;
    
    /**
     * Count for Clearing house on and off BS accounts details grid
     */
    public int ctsClearingHouseListGridCount(CtsClearingHouseSC ctsClearingHouseSC) throws DAOException;
    
    /**
     * Clearing house on and off BS accounts details grid
     */
    public  List  ctsClearingHouseListGrid(CtsClearingHouseSC criteria) throws DAOException;
    
    
    /**
     * Count all clearing house by comp code
     */
	public Integer clearingHouseByCompLkpCount(CtsClearingHouseSC criteria) throws BaseException;
	/**
	 * list all clearing house by comp code
	 * @param criteria
	 * @return
	 */
	public List<CTSCLEARINGHOUSEVO> clearingHouseByCompLkpList( CtsClearingHouseSC criteria) throws BaseException;
	public CTSCLEARINGHOUSEVO clearingHouseDepByCode(CtsClearingHouseSC criteria) throws BaseException;
	
	public CTSCLEARINGHOUSEVO returnCtsClearingHouse(CtsClearingHouseSC criteria) throws DAOException;

}
