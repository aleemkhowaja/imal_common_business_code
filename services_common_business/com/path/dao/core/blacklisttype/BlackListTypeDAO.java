package com.path.dao.core.blacklisttype;

import java.util.List;

import com.path.dbmaps.vo.MOSBLACKLIST_TYPEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.blacklisttype.BlackListTypeCO;
import com.path.vo.core.blacklisttype.BlackListTypeSC;

public interface BlackListTypeDAO
{

	public int blackLstTypeListCount(BlackListTypeSC criteria) throws DAOException;

	public List blackLstTypeList(BlackListTypeSC criteria) throws DAOException;

	public MOSBLACKLIST_TYPEVO returnBlackLstTypeById(BlackListTypeSC criteria) throws DAOException;

	public MOSBLACKLIST_TYPEVO returnBlackLstTypeforBlackListScreenValidation(BlackListTypeSC criteria) throws DAOException;

	// added by nour for 777000
	Integer blackListTypeByCount(BlackListTypeSC blackListTypeSC) throws DAOException;

	List<BlackListTypeCO> blackListTypeByList(BlackListTypeSC blackListTypeSC) throws DAOException;

	BlackListTypeCO returnBlackListType(BlackListTypeSC blackListTypeSC) throws DAOException;

	Integer deleteRecord(BlackListTypeCO blackListTypeCO) throws DAOException;

	Integer returnCodeDuplicateByCode(BlackListTypeCO blackListTypeCO) throws DAOException;

	Integer deleteBlackListType(BlackListTypeCO blackListTypeCO) throws DAOException;

	Integer approveBlackListType(BlackListTypeCO blackListTypeCO) throws DAOException;
	
	Integer updateBlackListTypeHeader(BlackListTypeCO blackListTypeCO) throws DAOException;

}
