package com.path.bo.core.ctsclearinghouse;

import java.util.List;

import com.path.dbmaps.vo.CTSCLEARINGHOUSEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.ctsclearinghouse.CtsClearingHouseSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * CtsClearingHouseBO.java used to
 */
public interface CtsClearingHouseBO
{
    public int ctsClearingHouseListCount(CtsClearingHouseSC ctsClearingHouseSC) throws BaseException;
    public List ctsClearingHouseList(CtsClearingHouseSC ctsClearingHouseSC) throws BaseException;
    public CTSCLEARINGHOUSEVO returnCtsClearingHouseById(CtsClearingHouseSC ctsClearingHouseSC) throws BaseException;
    
    /**
     * Count of Clearing house on and off BS accounts details
     * @param ctsClearingHouseSC
     * @return
     * @throws BaseException
     */
    public int ctsClearingHouseListGridCount(CtsClearingHouseSC ctsClearingHouseSC) throws BaseException;
    
    /**
     * Clearing house on and off BS accounts details grid
     * @param ctsClearingHouseSC
     * @return
     * @throws BaseException
     */
    public List ctsClearingHouseListGrid(CtsClearingHouseSC ctsClearingHouseSC) throws BaseException;
    
    
    /**
     * get List and Count of Clearing house by company code
     * @param CtsClearingHouseSC
     * @return
     */
	public Integer clearingHouseByCompLkpCount(CtsClearingHouseSC criteria) throws BaseException;
	public List<CTSCLEARINGHOUSEVO> clearingHouseByCompLkpList( CtsClearingHouseSC criteria) throws BaseException;
	public CTSCLEARINGHOUSEVO clearingHouseDepByCode(CtsClearingHouseSC criteria) throws BaseException;
	
	public CTSCLEARINGHOUSEVO returnCtsClearingHouse(CtsClearingHouseSC criteria) throws BaseException;
  
}
