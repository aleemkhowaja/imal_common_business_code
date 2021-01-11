/**
 * 
 */
package com.path.dao.common.global360view.chequebooks.impl;

import java.util.List;

import com.path.dao.common.global360view.chequebooks.DashChequebooksDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.core.chequebook.ChequeBookCO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * ChequebooksDAOImpl.java used to
 */
public class DashChequebooksDAOImpl extends BaseDAO implements DashChequebooksDAO
{
    /**
     * 
     * @date   May 13, 2013
     * @param criteria
     * @return
     * @throws DAOException int
     *
     */
    public int chequebooksListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashChequebooksMapper.chequebooksListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashChequebooksMapper.chequebooksListCount", criteria)).intValue();
	return nb;
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<ChequeBookCO> chequebooksList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashChequebooksMapper.chequebooksListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashChequebooksMapper.chequebooksList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashChequebooksMapper.chequebooksList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());

	}
    }

}
