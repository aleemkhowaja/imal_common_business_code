/**
 * 
 */
package com.path.dao.core.pmsdeal.impl;

import java.util.List;

import com.path.bo.core.pmsdeal.PmsDealBO;
import com.path.dao.core.pmsdeal.PmsDealDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.pmsdeal.PmsDealCO;
import com.path.vo.core.pmsdeal.PmsDealSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          PmsDealDAOImpl.java used to
 */
public class PmsDealDAOImpl extends BaseDAO implements PmsDealDAO, PmsDealBO
{

    @SuppressWarnings("unchecked")
    @Override
    public List<PmsDealCO> pmsDealList(PmsDealSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "pmsDealMapper.pmsDealListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("pmsDealMapper.pmsDealList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("pmsDealMapper.pmsDealList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int pmsDealListCount(PmsDealSC criteria) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("pmsDealMapper.pmsDealListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public PmsDealCO returnDependencyByDealNo(PmsDealSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "pmsDealMapper.pmsDealListMap");
	return (PmsDealCO) getSqlMap().queryForObject("pmsDealMapper.returnDependencyByDealNo", criteria);
    }

    /**
     * return deal details
     */
    public PmsDealCO returnDealAndDealCyDetail(PmsDealSC criteria) throws DAOException
    {
	return (PmsDealCO) getSqlMap().queryForObject("pmsDealMapper.returnDealAndDealCyDetail", criteria);
    }

}
