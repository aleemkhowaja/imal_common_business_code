/**
 * 
 */
package com.path.dao.common.global360view.lostdocuments.impl;

import java.util.List;

import com.path.dao.common.global360view.lostdocuments.DashLostDocsDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.LostDocumentsCO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashLostDocsDAOImpl.java used to
 */
public class DashLostDocsDAOImpl extends BaseDAO implements DashLostDocsDAO
{
    /**
     * 
     * @date   May 13, 2013
     * @param criteria
     * @return
     * @throws DAOException int
     *
     */
    public int lostDocsListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashLostDocsMapper.lostDocsListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashLostDocsMapper.lostDocsListCount", criteria)).intValue();
	return nb;
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<LostDocumentsCO> lostDocsList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashLostDocsMapper.lostDocsListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashLostDocsMapper.lostDocsList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashLostDocsMapper.lostDocsList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
}
