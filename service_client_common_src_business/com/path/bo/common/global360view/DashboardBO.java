/**
 * 
 */
package com.path.bo.common.global360view;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.AMFSUPPLEMENTVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashAccDtlJvsCO;
import com.path.vo.common.global360view.DashAccDtlTrxCO;
import com.path.vo.common.global360view.DashAccountDetailsCO;
import com.path.vo.common.global360view.DashChequesServicesCO;
import com.path.vo.common.global360view.DashPassbookCO;
import com.path.vo.common.global360view.DashboardCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.core.csmfom.FomCO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashboardBO.java used to
 */
public interface DashboardBO
{
    public List<DashboardCO> returnFinancingDealsList(DashboardSC criteria) throws BaseException;
    public DashboardCO dashboardDependCifById(DashboardSC criteria) throws BaseException;
    public List<DashAccountDetailsCO> accountDetailsList(DashboardSC criteria) throws BaseException;
    public int accountDetailsListCount(DashboardSC criteria) throws BaseException;
    public int accDtlJvsListCount(DashboardSC criteria) throws BaseException;
    public List<DashAccDtlJvsCO> accDtlJvsList(DashboardSC criteria) throws BaseException;
    public int accDtlTrxListCount(DashboardSC criteria) throws BaseException;
    public List<DashAccDtlTrxCO> accDtlTrxList(DashboardSC criteria) throws BaseException;
    public DashAccountDetailsCO returnAccountData(DashboardSC criteria) throws BaseException;
    public int passbooksListCount(DashboardSC criteria) throws BaseException;
    public DashboardCO returnMainData(DashboardSC criteria) throws BaseException;
    public List<DashPassbookCO> passbooksList(DashboardSC criteria) throws BaseException;
    
    public BigDecimal fetchFinancialApprovedLinesAmountSum(DashboardSC criteria) throws BaseException;
    public BigDecimal fetchFinancialNewApplicationsAmountSum(DashboardSC criteria) throws BaseException;
    public BigDecimal fetchFinancialBlockedAndSuspendedAmountSum(DashboardSC criteria) throws BaseException;
    public BigDecimal fetchFinancialDrawDownsAmountSum(DashboardSC criteria) throws BaseException;
    public BigDecimal fetchFinancialCollateralsAmountSum(DashboardSC criteria) throws BaseException;
    public BigDecimal fetchFinancialGuarantorAmountSum(DashboardSC criteria) throws BaseException;

    public DashboardCO returnDashAccountMaintDetail(DashboardSC criteria) throws BaseException;
    public Integer duesForAccListCount(DashboardSC criteria) throws BaseException;
    public List duesForAccList(DashboardSC criteria) throws BaseException;
    public List<AMFSUPPLEMENTVO> getAmfSupplement(DashboardSC criteria) throws BaseException;
    
    public DashboardCO returnHiddenAccStatusesCount(DashboardCO dashboardCO)throws BaseException;

    public int dashboardCheckRestrictedCifById(DashboardSC criteria) throws BaseException;
    public int returnDashboardSmsSubscriptionListCount(DashboardSC criteria) throws BaseException;
    public List returnDashboardSmsSubscriptionList(DashboardSC criteria) throws BaseException;
    
    public FomCO dependencyByScoreRiskValue(DashboardCO dashboardCO) throws BaseException;

    // added by nancy - 02/02/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    public List<DashChequesServicesCO> postDatedChqListList(DashboardSC criteria) throws BaseException;
    public int postDatedChqListCount(DashboardSC criteria) throws BaseException;
    // end nancy
}
