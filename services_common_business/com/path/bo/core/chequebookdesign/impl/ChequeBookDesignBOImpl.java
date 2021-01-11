package com.path.bo.core.chequebookdesign.impl;

import java.util.List;

import com.path.bo.core.chequebookdesign.ChequeBookDesignBO;
import com.path.dao.core.chequebookdesign.ChequeBookDesignDAO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_DESIGNVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.chequebookdesign.ChequeBookDesignSC;

public class ChequeBookDesignBOImpl extends BaseBO implements ChequeBookDesignBO
{
	private ChequeBookDesignDAO chequeBookDesignDAO;

	public ChequeBookDesignDAO getChequeBookDesignDAO() {
		return chequeBookDesignDAO;
	}

	public void setChequeBookDesignDAO(ChequeBookDesignDAO chequeBookDesignDAO) {
		this.chequeBookDesignDAO = chequeBookDesignDAO;
	}

	public int getDesignByCompanyCount(ChequeBookDesignSC chequeBookDesignSC) throws BaseException
	{
    	return chequeBookDesignDAO.getDesignByCompanyCount(chequeBookDesignSC);
	}

	public List<CTSCHEQUEBOOK_DESIGNVO> getDesignByCompanyList(ChequeBookDesignSC chequeBookDesignSC) throws BaseException
	{
    	return chequeBookDesignDAO.getDesignByCompanyList(chequeBookDesignSC);
	}

	public CTSCHEQUEBOOK_DESIGNVO returnDependencyByDesign(CTSCHEQUEBOOK_DESIGNVO chequeBookDesign) throws BaseException 
	{
		return (CTSCHEQUEBOOK_DESIGNVO) genericDAO.selectByPK(chequeBookDesign);
	}
}
