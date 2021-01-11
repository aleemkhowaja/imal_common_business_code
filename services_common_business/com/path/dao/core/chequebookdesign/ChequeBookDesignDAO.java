package com.path.dao.core.chequebookdesign;

import java.util.List;

import com.path.dbmaps.vo.CTSCHEQUEBOOK_DESIGNVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.chequebookdesign.ChequeBookDesignSC;

public interface ChequeBookDesignDAO {
	
	public int getDesignByCompanyCount(ChequeBookDesignSC chequeBookDesignSC) throws DAOException;
	public List<CTSCHEQUEBOOK_DESIGNVO> getDesignByCompanyList(ChequeBookDesignSC chequeBookDesignSC) throws DAOException;
}
