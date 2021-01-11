/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeBookLeavesDAO.java used to
 */
package com.path.dao.core.chequebookleaves;

import java.util.List;

import com.path.dbmaps.vo.CTSCHEQUEBOOK_LEAVESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.chequebookleaves.ChequeBookLeavesSC;

public interface ChequeBookLeavesDAO 
{
	
	public int getLeavesByCompanyCount(ChequeBookLeavesSC chequeBookLeavesSC) throws DAOException;
	public List<CTSCHEQUEBOOK_LEAVESVO> getLeavesByCompanyList(ChequeBookLeavesSC chequeBookLeavesSC) throws DAOException;
}
