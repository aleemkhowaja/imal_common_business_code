package com.path.dao.core.blacklistcontrolrecord.impl;

import com.path.dao.core.blacklistcontrolrecord.BlackListControlRecordDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.blacklistcontrolrecord.BlackListControlRecordCO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ControlRecordDAOImpl.java used to
 */
public class BlackListControlRecordDAOImpl extends BaseDAO implements BlackListControlRecordDAO
{

	 

	public BlackListControlRecordCO returnData(BlackListControlRecordCO controlRecordCO) throws  DAOException
	{
		return (BlackListControlRecordCO) getSqlMap().queryForObject("blackListControlRecordMapper.returnData",
				controlRecordCO);
	}
	
	public Integer approveControlRecord(BlackListControlRecordCO controlRecordCO) throws DAOException
    {
	return getSqlMap().update("blackListControlRecordMapper.approveControlRecord", controlRecordCO);
    }
   
    public Integer deleteControlRecord(BlackListControlRecordCO controlRecordCO) throws DAOException
    {
	return getSqlMap().update("blackListControlRecordMapper.deleteControlRecord", controlRecordCO);

    }

	@Override
	public Integer updateBlackListControlRecord(BlackListControlRecordCO controlRecordCO) throws DAOException
	{
		return getSqlMap().update("blackListControlRecordMapper.updateBlackListControlRecord", controlRecordCO);

		
	}
}
