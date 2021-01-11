/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeBookLeavesSC.java used to
 */
package com.path.dao.core.chequebookleaves.impl;

import java.util.List;

import com.path.dao.core.chequebookleaves.ChequeBookLeavesDAO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_LEAVESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.chequebookleaves.ChequeBookLeavesSC;

public class ChequeBookLeavesDAOImpl extends BaseDAO implements ChequeBookLeavesDAO
{ 
	 
	public int getLeavesByCompanyCount(ChequeBookLeavesSC chequeBookLeavesSC) throws DAOException
	{
		DAOHelper.fixGridMaps(chequeBookLeavesSC, getSqlMap(), "CTSCHEQUEBOOK_LEAVESMapper.getLeavesList_ResMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("CTSCHEQUEBOOK_LEAVESMapper.getLeavesCount", chequeBookLeavesSC)).intValue();
		return nb;
	}


	public List<CTSCHEQUEBOOK_LEAVESVO> getLeavesByCompanyList(ChequeBookLeavesSC chequeBookLeavesSC) throws DAOException
	{
		DAOHelper.fixGridMaps(chequeBookLeavesSC, getSqlMap(), "CTSCHEQUEBOOK_LEAVESMapper.getLeavesList_ResMap");
		if(chequeBookLeavesSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("CTSCHEQUEBOOK_LEAVESMapper.getLeavesList", chequeBookLeavesSC);
		}
		else
		{
			return getSqlMap().queryForList("CTSCHEQUEBOOK_LEAVESMapper.getLeavesList", chequeBookLeavesSC, chequeBookLeavesSC.getRecToskip(), chequeBookLeavesSC.getNbRec());
		}
	}
	
	
	
}
