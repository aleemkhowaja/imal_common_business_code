/**
 * 
 */
package com.path.dao.core.link.impl;

import java.util.List;

import com.path.dao.core.link.LinkDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.link.LinkSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: MarwanMaddah
 *
 * LinkDAOImpl.java used to
 */
public class LinkDAOImpl extends BaseDAO implements LinkDAO
{
    /**
     * Get the count of links, based on a criteria ...
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int linkCodeLkpCount(LinkSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "linkMapper.linkCodeLkpMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("linkMapper.linkCodeLkpCount", criteria)).intValue();
	return nb;
    }

    /**
     * Get the links list and define the fliping management...
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List linkCodeLkpRecords(LinkSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "linkMapper.linkCodeLkpMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("linkMapper.linkCodeLkpRecords", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("linkMapper.linkCodeLkpRecords", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }
}
