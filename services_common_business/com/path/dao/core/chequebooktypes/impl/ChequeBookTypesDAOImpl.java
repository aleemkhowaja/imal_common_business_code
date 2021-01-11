/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeBookTypesSC.java used to
 */
package com.path.dao.core.chequebooktypes.impl;

import java.util.List;

import com.path.dao.core.chequebooktypes.ChequeBookTypesDAO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_TYPESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.chequebooktypes.ChequeBookTypesSC;

public class ChequeBookTypesDAOImpl extends BaseDAO implements ChequeBookTypesDAO
{ 
	 
	public int getTypesByCompanyCount(ChequeBookTypesSC chequeBookTypesSC) throws DAOException
	{
		DAOHelper.fixGridMaps(chequeBookTypesSC, getSqlMap(), "CTSCHEQUEBOOK_TYPESMapper.getTypesList_ResMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("CTSCHEQUEBOOK_TYPESMapper.getTypesCount", chequeBookTypesSC)).intValue();
		return nb;
	}


	public List<CTSCHEQUEBOOK_TYPESVO> getTypesByCompanyList(ChequeBookTypesSC chequeBookTypesSC) throws DAOException
	{
		DAOHelper.fixGridMaps(chequeBookTypesSC, getSqlMap(), "CTSCHEQUEBOOK_TYPESMapper.getTypesList_ResMap");
		if(chequeBookTypesSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("CTSCHEQUEBOOK_TYPESMapper.getTypesList", chequeBookTypesSC);
		}
		else
		{
			return getSqlMap().queryForList("CTSCHEQUEBOOK_TYPESMapper.getTypesList", chequeBookTypesSC, chequeBookTypesSC.getRecToskip(), chequeBookTypesSC.getNbRec());
		}
	}
	
	
	
}
