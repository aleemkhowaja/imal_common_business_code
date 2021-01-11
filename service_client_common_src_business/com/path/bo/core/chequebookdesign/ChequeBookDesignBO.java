package com.path.bo.core.chequebookdesign;

import java.util.List;

import com.path.dbmaps.vo.CTSCHEQUEBOOK_DESIGNVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.chequebookdesign.ChequeBookDesignSC;

public interface ChequeBookDesignBO {

	public int getDesignByCompanyCount(ChequeBookDesignSC chequeBookDesignSC) throws BaseException;
	public List<CTSCHEQUEBOOK_DESIGNVO> getDesignByCompanyList(ChequeBookDesignSC chequeBookDesignSC) throws BaseException;
	public CTSCHEQUEBOOK_DESIGNVO returnDependencyByDesign(CTSCHEQUEBOOK_DESIGNVO chequeBookDesign) throws BaseException;
}
