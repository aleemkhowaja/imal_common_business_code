package com.path.dao.core.chequebookdesign.impl;

import java.util.List;

import com.path.dao.core.chequebookdesign.ChequeBookDesignDAO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_DESIGNVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.chequebookdesign.ChequeBookDesignSC;

public class ChequeBookDesignDAOImpl extends BaseDAO implements ChequeBookDesignDAO
{ 
	 
	public int getDesignByCompanyCount(ChequeBookDesignSC chequeBookDesignSC) throws DAOException
	{
		DAOHelper.fixGridMaps(chequeBookDesignSC, getSqlMap(), "CTSCHEQUEBOOK_DESIGNMapper.getDesignList_ResMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("CTSCHEQUEBOOK_DESIGNMapper.getDesignCount", chequeBookDesignSC)).intValue();
		return nb;
	}


	public List<CTSCHEQUEBOOK_DESIGNVO> getDesignByCompanyList(ChequeBookDesignSC chequeBookDesignSC) throws DAOException
	{
		DAOHelper.fixGridMaps(chequeBookDesignSC, getSqlMap(), "CTSCHEQUEBOOK_DESIGNMapper.getDesignList_ResMap");
		if(chequeBookDesignSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("CTSCHEQUEBOOK_DESIGNMapper.getDesignList", chequeBookDesignSC);
		}
		else
		{
			return getSqlMap().queryForList("CTSCHEQUEBOOK_DESIGNMapper.getDesignList", chequeBookDesignSC, chequeBookDesignSC.getRecToskip(), chequeBookDesignSC.getNbRec());
		}
	}
	
	
	
}
