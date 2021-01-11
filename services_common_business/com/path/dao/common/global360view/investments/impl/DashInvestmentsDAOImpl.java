/**
 * 
 */
package com.path.dao.common.global360view.investments.impl;

import java.util.List;

import com.path.dao.common.global360view.investments.DashInvestmentsDAO;
import com.path.dbmaps.vo.PMSPORTFOLIO_POSITION_TEMPVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.DashInvestmentsCO;
import com.path.vo.common.global360view.DashPrtfCashPosHoldPosCO;
import com.path.vo.common.global360view.DashboardGraphCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DashOthersDAOImpl.java used to
 */
public class DashInvestmentsDAOImpl extends BaseDAO implements DashInvestmentsDAO
{
    public int investmentsListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashInvestmentsMapper.investmentsListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashInvestmentsMapper.investmentsListCount", criteria)).intValue();
	return nb;
    }

    public List<DashInvestmentsCO> investmentsList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashInvestmentsMapper.investmentsListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashInvestmentsMapper.investmentsList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashInvestmentsMapper.investmentsList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public List<DashboardGraphCO> bookValueList(DashboardSC criteria) throws BaseException
    {
	return getSqlMap().queryForList("dashInvestmentsMapper.bookValueList", criteria);
    }
    

    public List<DashboardGraphCO> marketValueList(DashboardSC criteria) throws BaseException
    {
	return getSqlMap().queryForList("dashInvestmentsMapper.marketValueList", criteria);
    }

    /**
     * 
     * @author marwanmaddah
     * @date   Jul 12, 2013
     * @param criteria
     * @return
     * @throws DAOException int
     *
     */
    public int holdingPositionListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashInvestmentsMapper.holdingPositionListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashInvestmentsMapper.holdingPositionListCount", criteria)).intValue();
	return nb;
    }
    /**
     * 
     * @author marwanmaddah
     * @date   Jul 12, 2013
     * @param criteria
     * @return
     * @throws DAOException List<DashInvestmentsCO>
     *
     */
    public List<DashPrtfCashPosHoldPosCO> holdingPositionList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashInvestmentsMapper.holdingPositionListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashInvestmentsMapper.holdingPositionList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashInvestmentsMapper.holdingPositionList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    /**
     * 
     * @author marwanmaddah
     * @date   Jul 12, 2013
     * @param criteria
     * @return
     * @throws DAOException int
     *
     */
    public int cashPositionListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashInvestmentsMapper.cashPositionListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashInvestmentsMapper.cashPositionListCount", criteria)).intValue();
	return nb;
    }
    /**
     * 
     * @author marwanmaddah
     * @date   Jul 12, 2013
     * @param criteria
     * @return
     * @throws DAOException List<DashInvestmentsCO>
     *
     */
    public List<DashPrtfCashPosHoldPosCO> cashPositionList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashInvestmentsMapper.cashPositionListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashInvestmentsMapper.cashPositionList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashInvestmentsMapper.cashPositionList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    /**
     * 
     * @author marwanmaddah
     * @date   Jul 12, 2013
     * @param criteria
     * @return DashPrtfCashPosHoldPosCO
     *
     */
    public DashPrtfCashPosHoldPosCO returnPortfolioCashHoldingData(DashboardSC criteria) throws DAOException
    {
	return (DashPrtfCashPosHoldPosCO)getSqlMap().queryForObject("dashInvestmentsMapper.returnPortfolioCashHoldingData", criteria);
    }
    
    /**
     * 
     */
    public List<DashboardGraphCO> allSecuritiesChart(DashboardSC criteria) throws BaseException
    {
	return getSqlMap().queryForList("dashInvestmentsMapper.allSecuritiesChart", criteria);
    }
    
    /**
     * 
     */
    public List<DashboardGraphCO> prtflPosSummaryChart(DashboardSC criteria) throws BaseException
    {
	return getSqlMap().queryForList("dashInvestmentsMapper.prtflPosSummaryChart", criteria);
    }
    
    public int returnSecuritiesLookupListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashInvestmentsMapper.returnSecuritiesLookupListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashInvestmentsMapper.returnSecuritiesLookupListCount", criteria)).intValue();
	return nb;
    }

    public List<PMSPORTFOLIO_POSITION_TEMPVO> returnSecuritiesLookupList(DashboardSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashInvestmentsMapper.returnSecuritiesLookupList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashInvestmentsMapper.returnSecuritiesLookupListMap");
	    return getSqlMap()
		    .queryForList("dashInvestmentsMapper.returnSecuritiesLookupList", criteria, criteria.getRecToskip(), criteria.getNbRec());
	}
    }
    
    public PMSPORTFOLIO_POSITION_TEMPVO dashInvestmentDependencyBySecurity(DashboardSC criteria) throws DAOException
    {
	return (PMSPORTFOLIO_POSITION_TEMPVO) getSqlMap().queryForObject("dashInvestmentsMapper.dashInvestmentDependencyBySecurity", criteria);
    }
}
