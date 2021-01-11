/**
 * 
 */
package com.path.dao.common.global360view.tradefinance.impl;

import java.util.List;

import com.path.dao.common.global360view.tradefinance.DashTradeFinanceDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.DashTradeFinanceCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DashOthersDAOImpl.java used to
 */
public class DashTradeFinanceDAOImpl extends BaseDAO implements DashTradeFinanceDAO
{
    public int acceptanceListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashTradeFinanceMapper.acceptanceListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashTradeFinanceMapper.acceptanceListCount", criteria)).intValue();
	return nb;
    }

    public List<DashTradeFinanceCO> acceptanceList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashTradeFinanceMapper.acceptanceListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashTradeFinanceMapper.acceptanceList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashTradeFinanceMapper.acceptanceList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int inOutBillsListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashTradeFinanceMapper.inOutBillsListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashTradeFinanceMapper.inOutBillsListCount", criteria)).intValue();
	return nb;
    }

    public List<DashTradeFinanceCO> inOutBillsList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashTradeFinanceMapper.inOutBillsListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashTradeFinanceMapper.inOutBillsList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashTradeFinanceMapper.inOutBillsList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int lgListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashTradeFinanceMapper.lgListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashTradeFinanceMapper.lgListCount", criteria)).intValue();
	return nb;
    }

    public List<DashTradeFinanceCO> lgList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashTradeFinanceMapper.lgListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashTradeFinanceMapper.lgList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashTradeFinanceMapper.lgList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int inOutLCListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashTradeFinanceMapper.inOutLCListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashTradeFinanceMapper.inOutLCListCount", criteria)).intValue();
	return nb;
    }

    public List<DashTradeFinanceCO> inOutLCList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashTradeFinanceMapper.inOutLCListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashTradeFinanceMapper.inOutLCList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashTradeFinanceMapper.inOutLCList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
}
