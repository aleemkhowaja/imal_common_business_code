package com.path.dao.core.blacklistcontrolrecord;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.blacklistcontrolrecord.BlackListControlRecordCO;

public interface BlackListControlRecordDAO
{

	BlackListControlRecordCO returnData(BlackListControlRecordCO controlRecordCO) throws DAOException;

	Integer approveControlRecord(BlackListControlRecordCO controlRecordCO) throws DAOException;

	Integer deleteControlRecord(BlackListControlRecordCO controlRecordCO) throws DAOException;
	Integer updateBlackListControlRecord(BlackListControlRecordCO controlRecordCO) throws DAOException;

}
