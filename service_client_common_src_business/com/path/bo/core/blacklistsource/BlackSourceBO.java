package com.path.bo.core.blacklistsource;

import java.util.List;

import com.path.dbmaps.vo.MOSBLACKSOURCEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.blacklistsource.BlackSourceSC;

public interface BlackSourceBO
{
	public int blackSourceListCount(BlackSourceSC criteria) throws BaseException;
    public List blackSourceList(BlackSourceSC criteria) throws BaseException;
    public MOSBLACKSOURCEVO returnBlackSourceById(BlackSourceSC criteria) throws BaseException;

}
