package com.path.dao.core.giftclass.impl;

import java.util.List;

import com.path.dao.core.giftclass.GiftClassLookupDAO;
import com.path.dbmaps.vo.CRM_PARAMVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.giftclass.GiftClassLookupSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 */
public class GiftClassLookupDAOImpl extends BaseDAO implements GiftClassLookupDAO
{
    @Override
    public int returnGiftClassLookupCount(GiftClassLookupSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "giftClassLookupMapper.resGiftClassLookupMap");
	return ((Integer) getSqlMap().queryForObject("giftClassLookupMapper.returnGiftClassLookupCount", criteria))
		.intValue();
    }

    @Override
    public List<CRM_PARAMVO> returnGiftClassLookupList(GiftClassLookupSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "giftClassLookupMapper.resGiftClassLookupMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("giftClassLookupMapper.returnGiftClassLookupList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("giftClassLookupMapper.returnGiftClassLookupList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }
}
