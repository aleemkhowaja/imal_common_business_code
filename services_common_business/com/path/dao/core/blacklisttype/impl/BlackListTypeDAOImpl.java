package com.path.dao.core.blacklisttype.impl;

import java.util.List;
import com.path.dao.core.blacklisttype.BlackListTypeDAO;
import com.path.dbmaps.vo.MOSBLACKLIST_TYPEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.blacklisttype.BlackListTypeCO;
import com.path.vo.core.blacklisttype.BlackListTypeSC;

public class BlackListTypeDAOImpl extends BaseDAO implements BlackListTypeDAO
{

	@Override
	public List blackLstTypeList(BlackListTypeSC criteria) throws DAOException
	{
		if (criteria.getNbRec() == -1)
		{
			return getSqlMap().queryForList("blacklistTypeMapper.blacklistTypeList", criteria);
		}
		else
		{
			DAOHelper.fixGridMaps(criteria, getSqlMap(), "MOSBLACKLIST_TYPE.BaseResultMap");
			return getSqlMap().queryForList("blacklistTypeMapper.blacklistTypeList", criteria, criteria.getRecToskip(), criteria.getNbRec());
		}
	}

	@Override
	public int blackLstTypeListCount(BlackListTypeSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "MOSBLACKLIST_TYPE.BaseResultMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("blacklistTypeMapper.blacklistTypeListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public MOSBLACKLIST_TYPEVO returnBlackLstTypeById(BlackListTypeSC criteria) throws DAOException
	{
		return (MOSBLACKLIST_TYPEVO) getSqlMap().queryForObject("blacklistTypeMapper.returnBlackLstTypeById", criteria);
	}

	@Override
	public MOSBLACKLIST_TYPEVO returnBlackLstTypeforBlackListScreenValidation(BlackListTypeSC criteria) throws DAOException
	{
		return (MOSBLACKLIST_TYPEVO) getSqlMap().queryForObject("blacklistTypeMapper.returnBlackLstTypeforBlackListScreenValidation", criteria);
	}

	// added by nour for 885556
	@Override
	public Integer blackListTypeByCount(BlackListTypeSC blackListTypeSC) throws DAOException
	{
		DAOHelper.fixGridMaps(blackListTypeSC, getSqlMap(), "blacklistTypeMapper.resBlackListTypeListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("blacklistTypeMapper.returnBlackListTypeListCount", blackListTypeSC)).intValue();
		return nb;
	}

	@Override
	public List<BlackListTypeCO> blackListTypeByList(BlackListTypeSC blackListTypeSC) throws DAOException
	{
		DAOHelper.fixGridMaps(blackListTypeSC, getSqlMap(), "blacklistTypeMapper.resBlackListTypeListMap");
		if (blackListTypeSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("blacklistTypeMapper.returnBlackListTypeList", blackListTypeSC);
		}
		else
		{
			return getSqlMap().queryForList("blacklistTypeMapper.returnBlackListTypeList", blackListTypeSC, blackListTypeSC.getRecToskip(),
					blackListTypeSC.getNbRec());
		}
	}

	public BlackListTypeCO returnBlackListType(BlackListTypeSC blackListTypeSC) throws DAOException
	{

		return (BlackListTypeCO) getSqlMap().queryForObject("blacklistTypeMapper.blackListData", blackListTypeSC);

	}

	@Override
	public Integer deleteRecord(BlackListTypeCO blackListTypeCO) throws DAOException
	{
		return getSqlMap().update("blacklistTypeMapper.deleteBlackListType", blackListTypeCO);

	}

	@Override
	public Integer returnCodeDuplicateByCode(BlackListTypeCO blackListTypeCO) throws DAOException
	{
		return (Integer) getSqlMap().queryForObject("blacklistTypeMapper.returnCountByCode", blackListTypeCO);

	}

	@Override
	public Integer deleteBlackListType(BlackListTypeCO blackListTypeCO) throws DAOException
	{
		return getSqlMap().update("blacklistTypeMapper.deleteBlckListType", blackListTypeCO);

	}

	@Override
	public Integer approveBlackListType(BlackListTypeCO blackListTypeCO) throws DAOException
	{
		return getSqlMap().update("blacklistTypeMapper.approveBlackListType", blackListTypeCO);

	}

	@Override
	public Integer updateBlackListTypeHeader(BlackListTypeCO blackListTypeCO) throws DAOException
	{
		return getSqlMap().update("blacklistTypeMapper.updateBlackListTypeHeader", blackListTypeCO);

	}
}
