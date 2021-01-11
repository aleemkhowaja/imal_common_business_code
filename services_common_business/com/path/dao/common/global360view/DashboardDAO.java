/**
 * 
 */
package com.path.dao.common.global360view;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.AMFSUPPLEMENTVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.global360view.DashAccDtlJvsCO;
import com.path.vo.common.global360view.DashAccDtlTrxCO;
import com.path.vo.common.global360view.DashAccountDetailsCO;
import com.path.vo.common.global360view.DashChequesServicesCO;
import com.path.vo.common.global360view.DashPassbookCO;
import com.path.vo.common.global360view.DashboardCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashboardDAO.java used to
 */
public interface DashboardDAO
{
    public List<DashboardCO> returnFinancingDealsList(DashboardSC criteria) throws DAOException;
    public DashboardCO dashboardDependCifById(DashboardSC criteria) throws DAOException;
    public List<DashAccountDetailsCO> accountDetailsList(DashboardSC criteria) throws DAOException;
    public int accountDetailsListCount(DashboardSC criteria) throws DAOException;
    public List<DashAccDtlJvsCO> accDtlJvsList(DashboardSC criteria) throws DAOException;
    public int accDtlJvsListCount(DashboardSC criteria) throws DAOException;
    public List<DashAccDtlTrxCO> accDtlTrxList(DashboardSC criteria) throws DAOException;
    public int accDtlTrxListCount(DashboardSC criteria) throws DAOException;
    public DashAccountDetailsCO returnAccountData(DashboardSC criteria) throws DAOException;
    public List<DashPassbookCO> passbooksList(DashboardSC criteria) throws DAOException;
    public DashboardCO returnMainData(DashboardSC criteria) throws DAOException;
    public int passbooksListCount(DashboardSC criteria) throws DAOException;
    
    public BigDecimal fetchFinancialApprovedLinesAmountSum(DashboardSC criteria) throws DAOException;
    public BigDecimal fetchFinancialNewApplicationsAmountSum(DashboardSC criteria) throws DAOException;
    public BigDecimal fetchFinancialBlockedAndSuspendedAmountSum(DashboardSC criteria) throws DAOException;
    public BigDecimal fetchFinancialDrawDownsAmountSum(DashboardSC criteria) throws DAOException;
    public BigDecimal fetchFinancialCollateralsAmountSum(DashboardSC criteria) throws DAOException;
    public BigDecimal fetchFinancialGuarantorAmountSum(DashboardSC criteria) throws DAOException;
    public DashboardSC fillDashboardCounts(DashboardSC criteria) throws DAOException;
    
    public DashboardCO returnDashAccountMaintDetail(DashboardSC criteria)throws DAOException;
    public List duesForAccList(DashboardSC criteria)throws DAOException;
    public Integer duesForAccListCount(DashboardSC criteria)throws DAOException;
    public List<AMFSUPPLEMENTVO> getAmfSupplement(DashboardSC criteria) throws DAOException;
    public void dropDashTables() throws BaseException;
    public void createDashTables() throws BaseException;
    
    //PATH13019
    public int returnHiddenAccStatusesCount(DashboardSC dashboardSC) throws DAOException;
    //PATH130194
    public void dashboardDeleteLoginBranchCode(DashboardSC dashboardSC)throws DAOException;
    //PATH130194
    public void dashboardInsertLoginBranchCode(DashboardSC dashboardSC)throws DAOException;
    public int dashboardCheckRestrictedCifById(DashboardSC criteria) throws DAOException;
    
    public List dashboardReturnScoreRiskDescriptions(DashboardCO dashboardCO) throws DAOException;
    public int returnDashboardSmsSubscriptionListCount(DashboardSC criteria) throws DAOException;
    public List returnDashboardSmsSubscriptionList(DashboardSC criteria) throws DAOException;

    
    // added by nancy - 02/02/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    public List<DashChequesServicesCO> postDatedChqListList(DashboardSC criteria) throws DAOException;
    public int postDatedChqListCount(DashboardSC criteria) throws DAOException;
    // end nancy
    
    // DBU191081 Muhammed Anas Start
    public List<DashboardCO> returnChildCifList(DashboardSC dashboardSC) throws DAOException;
    // DBU191081 Muhammed Anas End
    
    // DBU191081 Rakan Start
    public void deleteFmsSubdidiaryCifs(DashboardSC dashboardSC) throws DAOException;
    // DBU191081 Rakan End
}
