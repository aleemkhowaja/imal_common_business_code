/**
 *
 */
package com.path.bo.common.global360view.investments.impl;

import java.util.List;

import com.path.bo.common.global360view.investments.DashInvestmentsBO;
import com.path.dao.common.global360view.investments.DashInvestmentsDAO;
import com.path.dbmaps.vo.PMSPORTFOLIO_POSITION_TEMPVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
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
 * DashOthersBOImpl.java used to
 */
public class DashInvestmentsBOImpl extends BaseBO implements DashInvestmentsBO
{
    private DashInvestmentsDAO dashInvestmentsDAO;

    public int investmentsListCount(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.investmentsListCount(criteria);
    }
    public List<DashInvestmentsCO> investmentsList(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.investmentsList(criteria);
    }

    public List<DashboardGraphCO> bookValueList(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.bookValueList(criteria);
    }

    public List<DashboardGraphCO> marketValueList(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.marketValueList(criteria);
    }

    /**
     *
     * @author marwanmaddah
     * @date   Jul 12, 2013
     * @param criteria
     * @return
     * @throws BaseException int
     *
     */
    public int holdingPositionListCount(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.holdingPositionListCount(criteria);
    }
    public List<DashPrtfCashPosHoldPosCO> holdingPositionList(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.holdingPositionList(criteria);
    }
    public int cashPositionListCount(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.cashPositionListCount(criteria);
    }
    public List<DashPrtfCashPosHoldPosCO> cashPositionList(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.cashPositionList(criteria);
    }
    public DashPrtfCashPosHoldPosCO returnPortfolioCashHoldingData(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.returnPortfolioCashHoldingData(criteria);
    }
    public List<DashboardGraphCO> allSecuritiesChart(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.allSecuritiesChart(criteria);
    }

    public List<DashboardGraphCO> prtflPosSummaryChart(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.prtflPosSummaryChart(criteria);
    }

    public int returnSecuritiesLookupListCount(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.returnSecuritiesLookupListCount(criteria);
    }
    public List<PMSPORTFOLIO_POSITION_TEMPVO> returnSecuritiesLookupList(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.returnSecuritiesLookupList(criteria);
    }

    public PMSPORTFOLIO_POSITION_TEMPVO dashInvestmentDependencyBySecurity(DashboardSC criteria) throws BaseException
    {
	return dashInvestmentsDAO.dashInvestmentDependencyBySecurity(criteria);
    }

    /**
     *
     * @date   Jul 17, 2013
     * @return DashInvestmentsDAO
     *
     */
    public DashInvestmentsDAO getDashInvestmentsDAO()
    {
	return dashInvestmentsDAO;
    }
    public void setDashInvestmentsDAO(DashInvestmentsDAO dashInvestmentsDAO)
    {
	this.dashInvestmentsDAO = dashInvestmentsDAO;
    }
}