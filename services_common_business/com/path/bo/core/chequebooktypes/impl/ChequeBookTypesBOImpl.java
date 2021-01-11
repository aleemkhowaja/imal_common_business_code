/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeBookTypesBOImpl.java used to
 */
package com.path.bo.core.chequebooktypes.impl;

import java.util.List;

import com.path.bo.core.chequebooktypes.ChequeBookTypesBO;
import com.path.dao.core.chequebooktypes.ChequeBookTypesDAO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_TYPESVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.chequebooktypes.ChequeBookTypesSC;

public class ChequeBookTypesBOImpl extends BaseBO implements ChequeBookTypesBO
{
	private ChequeBookTypesDAO chequeBookTypesDAO;

	public ChequeBookTypesDAO getChequeBookTypesDAO() {
		return chequeBookTypesDAO;
	}

	public void setChequeBookTypesDAO(ChequeBookTypesDAO chequeBookTypesDAO) {
		this.chequeBookTypesDAO = chequeBookTypesDAO;
	}

	public int getTypesByCompanyCount(ChequeBookTypesSC chequeBookTypesSC) throws BaseException
	{
    	return chequeBookTypesDAO.getTypesByCompanyCount(chequeBookTypesSC);
	}

	public List<CTSCHEQUEBOOK_TYPESVO> getTypesByCompanyList(ChequeBookTypesSC chequeBookTypesSC) throws BaseException
	{
    	return chequeBookTypesDAO.getTypesByCompanyList(chequeBookTypesSC);
	}

	public CTSCHEQUEBOOK_TYPESVO returnDependencyByTypes(CTSCHEQUEBOOK_TYPESVO typesVO) throws BaseException 
	{
		return (CTSCHEQUEBOOK_TYPESVO) genericDAO.selectByPK(typesVO);
	}
}
