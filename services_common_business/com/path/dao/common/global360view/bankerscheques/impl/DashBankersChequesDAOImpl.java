/**
 * 
 */
package com.path.dao.common.global360view.bankerscheques.impl;

import java.util.List;

import com.path.dao.common.global360view.bankerscheques.DashBankersChequesDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.BankersChequesCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashBankersChequesDAOImpl.java used to
 */
public class DashBankersChequesDAOImpl extends BaseDAO implements DashBankersChequesDAO
{
    /**
     * 
     * @date   May 13, 2013
     * @param criteria
     * @return
     * @throws DAOException int
     *
     */
    public int bankersChequesListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashBankersChqMapper.bankersChequesListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashBankersChqMapper.bankersChequesListCount", criteria)).intValue();
	return nb;
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<BankersChequesCO> bankersChequesList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashBankersChqMapper.bankersChequesListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashBankersChqMapper.bankersChequesList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashBankersChqMapper.bankersChequesList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());

	}
    }

}
