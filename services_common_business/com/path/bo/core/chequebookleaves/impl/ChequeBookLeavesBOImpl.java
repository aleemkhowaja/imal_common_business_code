/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeBookLeavesBOImpl.java used to
 */
package com.path.bo.core.chequebookleaves.impl;

import java.util.List;

import com.path.bo.core.chequebookleaves.ChequeBookLeavesBO;
import com.path.dao.core.chequebookleaves.ChequeBookLeavesDAO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_LEAVESVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.chequebookleaves.ChequeBookLeavesSC;

public class ChequeBookLeavesBOImpl extends BaseBO implements ChequeBookLeavesBO
{
	private ChequeBookLeavesDAO chequeBookLeavesDAO;

	public ChequeBookLeavesDAO getChequeBookLeavesDAO() {
		return chequeBookLeavesDAO;
	}

	public void setChequeBookLeavesDAO(ChequeBookLeavesDAO chequeBookLeavesDAO) {
		this.chequeBookLeavesDAO = chequeBookLeavesDAO;
	}

	public int getLeavesByCompanyCount(ChequeBookLeavesSC chequeBookLeavesSC) throws BaseException
	{
    	return chequeBookLeavesDAO.getLeavesByCompanyCount(chequeBookLeavesSC);
	}

	public List<CTSCHEQUEBOOK_LEAVESVO> getLeavesByCompanyList(ChequeBookLeavesSC chequeBookLeavesSC) throws BaseException
	{
    	return chequeBookLeavesDAO.getLeavesByCompanyList(chequeBookLeavesSC);
	}

	public CTSCHEQUEBOOK_LEAVESVO returnDependencyByLeaves(CTSCHEQUEBOOK_LEAVESVO leavesVO) throws BaseException 
	{
		return (CTSCHEQUEBOOK_LEAVESVO) genericDAO.selectByPK(leavesVO);
	}
}
