/**
 * 
 */
package com.path.dao.common.global360view.cheques.impl;

import java.util.List;

import com.path.dao.common.global360view.cheques.DashChequesServicesDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.DashChequesServicesCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashChequesServicesDAOImpl.java used to
 */
public class DashChequesServicesDAOImpl extends BaseDAO implements DashChequesServicesDAO
{
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int voidedChequesListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashChequesServicesMapper.voidedChequesListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashChequesServicesMapper.voidedChequesListCount", criteria)).intValue();
	return nb;
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashChequesServicesCO> voidedChequesList(DashboardSC criteria) throws BaseException
    {
	List<DashChequesServicesCO> ls;
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashChequesServicesMapper.voidedChequesListMap");
	if(criteria.getNbRec() == -1)
	{
	    ls =  getSqlMap().queryForList("dashChequesServicesMapper.voidedChequesList", criteria);
	}
	else
	{

	    ls = getSqlMap().queryForList("dashChequesServicesMapper.voidedChequesList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());

	}
	return ls;
    }
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int chequesForColListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashChequesServicesMapper.chequesForColListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashChequesServicesMapper.chequesForColCount", criteria)).intValue();
	return nb;
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashChequesServicesCO> chequesForColList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashChequesServicesMapper.chequesForColListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashChequesServicesMapper.chequesForColList", criteria);
	}
	else
	{

	    return getSqlMap().queryForList("dashChequesServicesMapper.chequesForColList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());

	}
    }
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int postDatedChqWDrawalListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashChequesServicesMapper.postDatedChqWDrawalListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashChequesServicesMapper.postDatedChqWDrawalListCount", criteria)).intValue();
	return nb;
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashChequesServicesCO> postDatedChqWDrawalList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashChequesServicesMapper.postDatedChqWDrawalListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashChequesServicesMapper.postDatedChqWDrawalList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashChequesServicesMapper.postDatedChqWDrawalList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());

	}
    }
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int postDatedChqDepListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashChequesServicesMapper.postDatedChqDepListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashChequesServicesMapper.postDatedChqDepListCount", criteria)).intValue();
	return nb;
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashChequesServicesCO> postDatedChqDepList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashChequesServicesMapper.postDatedChqDepListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashChequesServicesMapper.postDatedChqDepList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashChequesServicesMapper.postDatedChqDepList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());

	}
    }
}
