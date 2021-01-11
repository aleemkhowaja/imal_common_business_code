/**
 * 
 */
package com.path.dao.core.ctstrsowing.impl;

import java.util.List;

import com.path.dao.core.ctstrsowing.CtstrsOwingDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.ctstrsowing.CtstrsOwingSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * CtstrsOwingDAOImpl.java used to
 */
public class CtstrsOwingDAOImpl extends BaseDAO implements CtstrsOwingDAO
{
    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int ctstrsOwingListCount(CtstrsOwingSC criteria) throws DAOException
    {

	DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.ctstrsOwingListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("accountMapper.ctstrsOwingListCount", criteria)).intValue();
	return nb;
    }

    /**
     * sql map to get the account list based on a defined criteria
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List ctstrsOwingList(CtstrsOwingSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("ctstrsOwingMapper.ctstrsOwingList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "ctstrsOwingMapper.ctstrsOwingListMap");
	    return getSqlMap().queryForList("ctstrsOwingMapper.ctstrsOwingList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

}
