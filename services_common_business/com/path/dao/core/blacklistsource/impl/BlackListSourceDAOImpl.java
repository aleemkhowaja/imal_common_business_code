package com.path.dao.core.blacklistsource.impl;

import java.util.List;
import com.path.dao.core.blacklistsource.BlackListSourceDAO;
import com.path.dbmaps.vo.AML_CUSTOMERVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.blacklistsource.BlackListSourceCO;
import com.path.vo.core.blacklistsource.BlackListSourceSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * BlackListSourceDAOImpl.java used to
 */
public class BlackListSourceDAOImpl extends BaseDAO implements BlackListSourceDAO
{

	@Override
	public Integer blackListSourceCount(BlackListSourceSC blackListSourceSC) throws DAOException
	{
		DAOHelper.fixGridMaps(blackListSourceSC, getSqlMap(), "blackListSourceMapper.resBlackListSourceListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("blackListSourceMapper.returnBlackListSourceListCount", blackListSourceSC)).intValue();
		return nb;
	}

	@Override
	public List<BlackListSourceCO> blackListSourceList(BlackListSourceSC blackListSourceSC) throws DAOException
	{
		DAOHelper.fixGridMaps(blackListSourceSC, getSqlMap(), "blackListSourceMapper.resBlackListSourceListMap");
		if (blackListSourceSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("blackListSourceMapper.returnBlackListSourceList", blackListSourceSC);
		}
		else
		{
			return getSqlMap().queryForList("blackListSourceMapper.returnBlackListSourceList", blackListSourceSC, blackListSourceSC.getRecToskip(),
					blackListSourceSC.getNbRec());
		}
	}

	public BlackListSourceCO returnBlackListSource(BlackListSourceSC blackListSourceSC) throws DAOException
	{

		return (BlackListSourceCO) getSqlMap().queryForObject("blackListSourceMapper.blackListData", blackListSourceSC);

	}

	public Integer deleteRecord(BlackListSourceCO blackListSourceCO) throws DAOException
	{
		return getSqlMap().update("blackListSourceMapper.deleteBlackListSource", blackListSourceCO);

	}

	public CIFVO returnCifCode(BlackListSourceCO blackListSourceCO) throws DAOException
	{
		return (CIFVO) getSqlMap().queryForObject("blackListSourceMapper.returnCountByCifCode", blackListSourceCO);

	}

	@Override
	public Integer deleteBlackListSource(BlackListSourceCO blackListSourceCO) throws DAOException
	{
		return getSqlMap().update("blackListSourceMapper.deleteBlckListSource", blackListSourceCO);

	}

	@Override
	public Integer approveBlackListSource(BlackListSourceCO blackListSourceCO) throws DAOException
	{
		return getSqlMap().update("blackListSourceMapper.approveBlackListSource", blackListSourceCO);

	}

	public Integer updateBlackListSourceHeader(BlackListSourceCO blackListSourceCO) throws DAOException
	{
		return getSqlMap().update("blackListSourceMapper.updateBlackListSourceHeader", blackListSourceCO);
	}

}
