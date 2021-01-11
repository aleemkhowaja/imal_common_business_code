package com.path.dao.core.avafilecompanion.impl;

import java.util.ArrayList;
import java.util.List;

import com.path.dao.core.avafilecompanion.AvaFileCompanionLkpDAO;
import com.path.dbmaps.vo.CTS_AVA_FILE_COMPANIONVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.avafilecompanion.AvaFileCompanionLkpSC;

public class AvaFileCompanionLkpDAOImpl extends BaseDAO implements AvaFileCompanionLkpDAO
{
    @Override
    public List<CTS_AVA_FILE_COMPANIONVO> returnAccompanistLookupList(AvaFileCompanionLkpSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaFileCompanionLkpMapper.returnAccompanistLookupMap");
	return (ArrayList<CTS_AVA_FILE_COMPANIONVO>) getSqlMap().queryForList(
		"avaFileCompanionLkpMapper.returnAccompanistLookupList", criteria, criteria.getRecToskip(),
		criteria.getNbRec());
    }

    @Override
    public int returnAccompanistLookupCount(AvaFileCompanionLkpSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "avaFileCompanionLkpMapper.returnAccompanistLookupMap");
	return ((Integer) getSqlMap()
		.queryForObject("avaFileCompanionLkpMapper.returnAccompanistLookupCount", criteria)).intValue();
    }
    
    @Override
    public CTS_AVA_FILE_COMPANIONVO dependencyByCompanionSeq(AvaFileCompanionLkpSC sc) throws DAOException
    {
	return (CTS_AVA_FILE_COMPANIONVO) getSqlMap().queryForObject(
		"avaFileCompanionLkpMapper.dependencyByCompanionSeq", sc);
    }
}
