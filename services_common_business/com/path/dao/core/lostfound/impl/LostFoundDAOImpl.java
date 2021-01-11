/**
 * 
 */
package com.path.dao.core.lostfound.impl;

import java.util.List;

import com.path.dao.core.lostfound.LostFoundDAO;
import com.path.dbmaps.vo.CTS_LOSTDOCVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.lostfound.LostFoundSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          LostFoundDAOImpl.java used to
 */
public class LostFoundDAOImpl extends BaseDAO implements LostFoundDAO
{

    @Override
    public int docTypeLookupCount(LostFoundSC lostFoundSC) throws DAOException
    {
	DAOHelper.fixGridMaps(lostFoundSC, getSqlMap(), "lostFoundMapper.lostFoundLookupMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("lostFoundMapper.lostFoundLookupCount", lostFoundSC)).intValue();
	return nb;
    }

    @Override
    public List<CTS_LOSTDOCVO> docTypeLookupList(LostFoundSC lostFoundSC) throws DAOException
    {
	DAOHelper.fixGridMaps(lostFoundSC, getSqlMap(), "lostFoundMapper.lostFoundLookupMap");

	if(lostFoundSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("lostFoundMapper.lostFoundLookupRecords", lostFoundSC);
	}
	else
	{
	    return getSqlMap().queryForList("lostFoundMapper.lostFoundLookupRecords", lostFoundSC, lostFoundSC.getRecToskip(),
		    lostFoundSC.getNbRec());
	}
    }

}
