/**
 * 
 */
package com.path.bo.common.global360view.fms;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.FMSCO;


public interface DashFMSBO
{
	public List getSecurityList(DashboardSC dashboardSC) throws BaseException;

    public int getSecurityListCount(DashboardSC dashboardSC) throws BaseException;

    public List<FMSCO> getSecurityCurrencyDetails(DashboardSC dashboardSC) throws BaseException;
    
    public List getNewAppList(DashboardSC dashboardSC) throws BaseException;

    public int getNewAppListCount(DashboardSC dashboardSC) throws BaseException;

    public List<FMSCO> getNewAppCurrencyDetails(DashboardSC dashboardSC) throws BaseException;
    
    public List getBlockedAndSuspendedFacilitiesList(DashboardSC dashboardSC) throws BaseException;

    public int getBlockedAndSuspendedFacilitiesListCount(DashboardSC dashboardSC) throws BaseException;

    public List<FMSCO> getBlockedAndSuspendedFacilitiesCurrencyDetails(DashboardSC dashboardSC) throws BaseException;
    
    public List getCifGuarantorList(DashboardSC dashboardSC) throws BaseException;

    public int getCifGuarantorListCount(DashboardSC dashboardSC) throws BaseException;

    public List<FMSCO> getCifGuarantorCurrencyDetails(DashboardSC dashboardSC) throws BaseException;
    
    public List getLiabilitiesApprovedLinesList(DashboardSC dashboardSC) throws BaseException;
    
    public List getLiabilitiesApprovedLinesDetailedList(DashboardSC dashboardSC) throws BaseException;

    public List<FMSCO> getLiabilitiesApprovedLinesCurrencyDetails(DashboardSC dashboardSC) throws BaseException;
    
    List<FMSCO> getDrawdownCurrencyDetails(DashboardSC dashboardSC) throws BaseException;
    
    int getDrawdownListCount(DashboardSC dashboardSC) throws BaseException;

    List getDrawdownList(DashboardSC dashboardSC) throws BaseException;

    public List returnDrawDownApprovedLinesDetailedList(DashboardSC dashboardSC) throws BaseException;

}
