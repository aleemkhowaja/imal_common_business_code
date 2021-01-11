package com.path.bo.core.blacklistsource;

import java.math.BigDecimal;
import java.util.List;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.core.blacklistsource.BlackListSourceCO;
import com.path.vo.core.blacklistsource.BlackListSourceSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * BlackListSourceBO.java used to
 */
public interface BlackListSourceBO
{

	Integer blackListSourceCount(BlackListSourceSC blackListSourceSC) throws BaseException;

	List<BlackListSourceCO> blackListSourceList(BlackListSourceSC blackListSourceSC) throws BaseException;

	public BlackListSourceCO returnBlackListSource(BlackListSourceSC blackListSourceSC) throws BaseException;

	BlackListSourceCO saveBlackListSource(BlackListSourceCO blackListSourceCO) throws BaseException;

	BlackListSourceCO updateBlackListSource(BlackListSourceCO blackListSourceCO) throws BaseException;

	BlackListSourceCO deleteRecord(BlackListSourceCO blackListSourceCO, AuditRefCO refCO) throws BaseException;


	BlackListSourceCO initializeData(BlackListSourceCO blackListSourceCO) throws BaseException;

	BlackListSourceCO returnDepByCifCode(BlackListSourceCO blackListSourceCO) throws BaseException;

	BigDecimal getDualParam(BlackListSourceCO blackListSourceCO) throws BaseException, com.path.lib.common.exception.BaseException;

	BlackListSourceCO deleteBlackListSource(BlackListSourceCO blackListSourceCO) throws BaseException;

	BlackListSourceCO approveBlackListSource(BlackListSourceCO blackListSourceCO) throws BaseException;

}
