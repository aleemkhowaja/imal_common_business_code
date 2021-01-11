/**
 * 
 */
package com.path.dao.common.global360view.investments;

import java.util.List;

import com.path.dbmaps.vo.PMSPORTFOLIO_POSITION_TEMPVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
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
 * DashChequesServicesDAO.java used to
 */
public interface DashInvestmentsDAO
{
    public int investmentsListCount(DashboardSC criteria) throws BaseException;
    public List<DashInvestmentsCO> investmentsList(DashboardSC criteria) throws BaseException;
    
    public List<DashboardGraphCO> bookValueList(DashboardSC criteria) throws BaseException;
    public List<DashboardGraphCO> marketValueList(DashboardSC criteria) throws BaseException;
    
    /**
     * Investment portfolio cash position and holding.
     * @author marwanmaddah
     * @date   Jul 12, 2013
     * @param criteria
     * @return
     * @throws BaseException int
     *
     */
    public int holdingPositionListCount(DashboardSC criteria) throws BaseException;
    public List<DashPrtfCashPosHoldPosCO> holdingPositionList(DashboardSC criteria) throws BaseException;
    public int cashPositionListCount(DashboardSC criteria) throws BaseException;
    public List<DashPrtfCashPosHoldPosCO> cashPositionList(DashboardSC criteria) throws BaseException;
    public DashPrtfCashPosHoldPosCO returnPortfolioCashHoldingData(DashboardSC criteria) throws DAOException;
    public List<DashboardGraphCO> allSecuritiesChart(DashboardSC criteria) throws BaseException;
    public List<DashboardGraphCO> prtflPosSummaryChart(DashboardSC criteria) throws BaseException;
    public int returnSecuritiesLookupListCount(DashboardSC criteria) throws DAOException;
    public List<PMSPORTFOLIO_POSITION_TEMPVO> returnSecuritiesLookupList(DashboardSC criteria) throws DAOException;
    public PMSPORTFOLIO_POSITION_TEMPVO dashInvestmentDependencyBySecurity(DashboardSC criteria) throws DAOException;
}