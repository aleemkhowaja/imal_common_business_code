/**
 * 
 */
package com.path.dao.common.global360view.safeboxes.impl;

import java.util.List;

import com.path.dao.common.global360view.safeboxes.SafeboxesDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * SafeboxesDAOImpl.java used to
 */
public class SafeboxesDAOImpl extends BaseDAO implements SafeboxesDAO
{
    public int safeboxesListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "safeboxesMapper.safeboxesListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("safeboxesMapper.getSafeboxesListCount", criteria)).intValue();
	return nb;
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List safeboxesList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "safeboxesMapper.safeboxesListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("safeboxesMapper.getSafeboxesList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("safeboxesMapper.getSafeboxesList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
}
