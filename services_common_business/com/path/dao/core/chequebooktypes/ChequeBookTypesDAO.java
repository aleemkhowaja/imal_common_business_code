/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeBookTypesDAO.java used to
 */
package com.path.dao.core.chequebooktypes;

import java.util.List;

import com.path.dbmaps.vo.CTSCHEQUEBOOK_TYPESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.chequebooktypes.ChequeBookTypesSC;

public interface ChequeBookTypesDAO 
{
	
	public int getTypesByCompanyCount(ChequeBookTypesSC chequeBookTypesSC) throws DAOException;
	public List<CTSCHEQUEBOOK_TYPESVO> getTypesByCompanyList(ChequeBookTypesSC chequeBookTypesSC) throws DAOException;
}
