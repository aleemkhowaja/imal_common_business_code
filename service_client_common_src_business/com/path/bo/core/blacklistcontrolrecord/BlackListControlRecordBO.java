package com.path.bo.core.blacklistcontrolrecord;

import java.math.BigDecimal;
import com.path.expression.common.PBFunc.BaseException;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.blacklistcontrolrecord.BlackListControlRecordCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ControlRecordBO.java used to
 */
public interface BlackListControlRecordBO
{

	BlackListControlRecordCO loadData(BlackListControlRecordCO controlRecordCO) throws BaseException, DAOException, com.path.lib.common.exception.BaseException;

	public BlackListControlRecordCO saveNew(BlackListControlRecordCO controlRecordCO)
			throws BaseException, DAOException, com.path.lib.common.exception.BaseException;

	public BlackListControlRecordCO updateControlRecord(BlackListControlRecordCO controlRecordCO)
			throws BaseException, DAOException, BOException, com.path.lib.common.exception.BaseException;

	BigDecimal getDualParam(BlackListControlRecordCO controlRecordCO) throws BaseException, com.path.lib.common.exception.BaseException;

	BlackListControlRecordCO approveControlRecord(BlackListControlRecordCO controlRecordCO) throws BaseException, com.path.lib.common.exception.BaseException;

	BlackListControlRecordCO deleteControlRecord(BlackListControlRecordCO controlRecordCO)
			throws BaseException, DAOException, com.path.lib.common.exception.BaseException;

	BlackListControlRecordCO returnDepCriteriaMatch(BlackListControlRecordCO controlRecordCO) throws BaseException, BOException;

	BlackListControlRecordCO returnDepNameMatch(BlackListControlRecordCO controlRecordCO) throws BaseException, BOException;

	BlackListControlRecordCO returnDepWalkinNameMatch(BlackListControlRecordCO controlRecordCO)
			throws BaseException, BOException, com.path.lib.common.exception.BaseException;

	BlackListControlRecordCO returnDepWalkinCriteriaMatch(BlackListControlRecordCO controlRecordCO)
			throws BaseException, BOException, com.path.lib.common.exception.BaseException;
	
	BlackListControlRecordCO returnDepNameWalkinMatch(BlackListControlRecordCO controlRecordCO) throws BaseException, BOException;

	BlackListControlRecordCO returnDepAndOr(BlackListControlRecordCO controlRecordCO)
			throws BaseException, BOException, com.path.lib.common.exception.BaseException;
	

}
