/**
 * 
 */
package com.path.dao.common.global360view.fms;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.FMSCO;


public interface DashFMSDAO
{
	public List getSecurityList(DashboardSC dashboardSC) throws DAOException;

    public int getSecurityListCount(DashboardSC dashboardSC) throws DAOException;

    public List<FMSCO> getSecurityCurrencyDetails(DashboardSC dashboardSC) throws DAOException;
    
    public List getNewAppList(DashboardSC dashboardSC) throws DAOException;

    public int getNewAppListCount(DashboardSC dashboardSC) throws DAOException;

    public List<FMSCO> getNewAppCurrencyDetails(DashboardSC dashboardSC) throws DAOException;
    
    public List getBlockedAndSuspendedFacilitiesList(DashboardSC dashboardSC) throws DAOException;

    public int getBlockedAndSuspendedFacilitiesListCount(DashboardSC dashboardSC) throws DAOException;

    public List<FMSCO> getBlockedAndSuspendedFacilitiesCurrencyDetails(DashboardSC dashboardSC) throws DAOException;
    
    public List getCifGuarantorList(DashboardSC dashboardSC) throws DAOException;

    public int getCifGuarantorListCount(DashboardSC dashboardSC) throws DAOException;

    public List<FMSCO> getCifGuarantorCurrencyDetails(DashboardSC dashboardSC) throws DAOException;
    
    public List getLiabilitiesApprovedLinesList(DashboardSC dashboardSC) throws DAOException;

    public List getLiabilitiesApprovedLinesDetailedList(DashboardSC dashboardSC) throws BaseException;
    
    public List<FMSCO> getLiabilitiesApprovedLinesCurrencyDetails(DashboardSC dashboardSC) throws DAOException;
    
    public List<FMSCO> getDrawdownCurrencyDetails(DashboardSC dashboardSC) throws DAOException;

    public int getDrawdownListCount(DashboardSC dashboardSC) throws DAOException;

    public List getDrawdownList(DashboardSC dashboardSC) throws DAOException;

    public List returnDrawDownApprovedLinesDetailedList(DashboardSC dashboardSC) throws DAOException;
}
