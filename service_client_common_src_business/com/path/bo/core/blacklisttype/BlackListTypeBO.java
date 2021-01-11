package com.path.bo.core.blacklisttype;

import java.math.BigDecimal;
import java.util.List;
import com.path.dbmaps.vo.MOSBLACKLIST_TYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.core.blacklistsource.BlackListSourceCO;
import com.path.vo.core.blacklisttype.BlackListTypeCO;
import com.path.vo.core.blacklisttype.BlackListTypeSC;

public interface BlackListTypeBO
{

	public int blackLstTypeListCount(BlackListTypeSC criteria) throws BaseException;

	public List blackLstTypeList(BlackListTypeSC criteria) throws BaseException;

	public MOSBLACKLIST_TYPEVO returnBlackLstTypeById(BlackListTypeSC criteria) throws BaseException;

	// added by nour for 777000
	BlackListTypeCO initializeData(BlackListTypeCO blackListTypeCO) throws BaseException;

	public BlackListTypeCO returnBlackListType(BlackListTypeSC blackListTypeSC) throws BaseException;

	Integer blackListTypeByCount(BlackListTypeSC blackListTypeSC) throws BaseException;

	List<BlackListTypeCO> blackListTypeByList(BlackListTypeSC blackListTypeSC) throws BaseException;

	BlackListTypeCO saveBlackListType(BlackListTypeCO blackListTypeCO) throws BaseException;

	BlackListTypeCO updateBlackListType(BlackListTypeCO blackListTypeCO) throws BaseException;

	BlackListTypeCO deleteRecord(BlackListTypeCO blackListTypeCO, AuditRefCO refCO) throws BaseException;

	BlackListTypeCO returnDepByCode(BlackListTypeCO blackListTypeCO) throws BaseException;

	BlackListTypeCO returnDepRevBasis(BlackListTypeCO blackListTypeCO) throws BaseException;

	BlackListTypeCO returnDepRevPeriod(BlackListTypeCO blackListTypeCO) throws BaseException;

	BigDecimal getDualParam(BlackListTypeCO blackListTypeCO) throws BaseException, com.path.lib.common.exception.BaseException;

	BlackListTypeCO deleteBlackListType(BlackListTypeCO blackListTypeCO) throws BaseException;

	BlackListTypeCO approveBlackListType(BlackListTypeCO blackListTypeCO) throws BaseException;

}
