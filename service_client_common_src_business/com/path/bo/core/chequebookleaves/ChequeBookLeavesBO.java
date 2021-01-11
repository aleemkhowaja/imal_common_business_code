/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeBookLeavesBO.java used to
 */
package com.path.bo.core.chequebookleaves;

import java.util.List;

import com.path.dbmaps.vo.CTSCHEQUEBOOK_LEAVESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.chequebookleaves.ChequeBookLeavesSC;

public interface ChequeBookLeavesBO {

	public int getLeavesByCompanyCount(ChequeBookLeavesSC chequeBookLeavesSC) throws BaseException;
	public List<CTSCHEQUEBOOK_LEAVESVO> getLeavesByCompanyList(ChequeBookLeavesSC chequeBookLeavesSC) throws BaseException;
	public CTSCHEQUEBOOK_LEAVESVO returnDependencyByLeaves(CTSCHEQUEBOOK_LEAVESVO leavesVO) throws BaseException;
}
