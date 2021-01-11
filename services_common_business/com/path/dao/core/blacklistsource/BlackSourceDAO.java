package com.path.dao.core.blacklistsource;

import java.util.List;

import com.path.dbmaps.vo.MOSBLACKSOURCEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.blacklistsource.BlackSourceSC;

public interface BlackSourceDAO
{
	public int blackSourceListCount(BlackSourceSC criteria) throws DAOException;
    public List blackSourceList(BlackSourceSC criteria) throws DAOException;
    public MOSBLACKSOURCEVO returnBlackSourceById(BlackSourceSC criteria) throws DAOException;
}

