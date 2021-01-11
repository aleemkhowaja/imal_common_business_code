/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeBookTypesBO.java used to
 */
package com.path.bo.core.chequebooktypes;

import java.util.List;

import com.path.dbmaps.vo.CTSCHEQUEBOOK_TYPESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.chequebooktypes.ChequeBookTypesSC;

public interface ChequeBookTypesBO {

	public int getTypesByCompanyCount(ChequeBookTypesSC chequeBookTypesSC) throws BaseException;
	public List<CTSCHEQUEBOOK_TYPESVO> getTypesByCompanyList(ChequeBookTypesSC chequeBookTypesSC) throws BaseException;
	public CTSCHEQUEBOOK_TYPESVO returnDependencyByTypes(CTSCHEQUEBOOK_TYPESVO typesVO) throws BaseException;
}
