package com.path.dao.core.trxfieldsname;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.trxfieldsname.TrxFieldsNameCO;
import com.path.vo.core.trxfieldsname.TrxFieldsNameSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * TrxFieldsNameDAO.java used to
 */
public interface TrxFieldsNameDAO 
{
	public int returnTrxFieldsNameLookupCount(TrxFieldsNameSC criteria) throws DAOException;
	public List<TrxFieldsNameCO> returnTrxFieldsNameLookup(TrxFieldsNameSC criteria)throws DAOException;
	
}