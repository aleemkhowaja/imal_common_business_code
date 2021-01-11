package com.path.dao.core.blacklistsource;

import java.util.List;
import com.path.dbmaps.vo.AML_CUSTOMERVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.blacklistsource.BlackListSourceCO;
import com.path.vo.core.blacklistsource.BlackListSourceSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * BlackListSourceDAO.java used to
 */
public interface BlackListSourceDAO
{

	Integer blackListSourceCount(BlackListSourceSC blackListSourceSC) throws DAOException;

	List<BlackListSourceCO> blackListSourceList(BlackListSourceSC blackListSourceSC) throws DAOException;

	BlackListSourceCO returnBlackListSource(BlackListSourceSC blackListSourceSC) throws DAOException;

	Integer deleteRecord(BlackListSourceCO blackListSourceCO) throws DAOException;

	CIFVO returnCifCode(BlackListSourceCO blackListSourceCO) throws DAOException;

	Integer deleteBlackListSource(BlackListSourceCO blackListSourceCO) throws DAOException;

	Integer approveBlackListSource(BlackListSourceCO blackListSourceCO) throws DAOException;

	Integer updateBlackListSourceHeader(BlackListSourceCO blackListSourceCO) throws DAOException;

}
