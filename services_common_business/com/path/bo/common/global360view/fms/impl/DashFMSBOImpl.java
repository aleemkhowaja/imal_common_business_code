/**
 * 
 */
package com.path.bo.common.global360view.fms.impl;

import java.util.List;

import com.path.bo.common.global360view.fms.DashFMSBO;
import com.path.dao.common.global360view.fms.DashFMSDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.FMSCO;

public class DashFMSBOImpl extends BaseBO implements DashFMSBO
{
  private DashFMSDAO dashFMSDAO;

public DashFMSDAO getDashFMSDAO()
{
	return dashFMSDAO;
}

public void setDashFMSDAO(DashFMSDAO dashFMSDAO)
{
	this.dashFMSDAO = dashFMSDAO;
}

public List<FMSCO> getSecurityCurrencyDetails(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getSecurityCurrencyDetails(dashboardSC);
}

public List getSecurityList(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getSecurityList(dashboardSC);
}

public int getSecurityListCount(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getSecurityListCount(dashboardSC);
}

public List<FMSCO> getNewAppCurrencyDetails(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getNewAppCurrencyDetails(dashboardSC);
}

public List getNewAppList(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getNewAppList(dashboardSC);
}

public int getNewAppListCount(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getNewAppListCount(dashboardSC);
}


public List<FMSCO> getBlockedAndSuspendedFacilitiesCurrencyDetails(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getBlockedAndSuspendedFacilitiesCurrencyDetails(dashboardSC);
}

public List getBlockedAndSuspendedFacilitiesList(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getBlockedAndSuspendedFacilitiesList(dashboardSC);
}

public int getBlockedAndSuspendedFacilitiesListCount(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getBlockedAndSuspendedFacilitiesListCount(dashboardSC);
}

public List<FMSCO> getCifGuarantorCurrencyDetails(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getCifGuarantorCurrencyDetails(dashboardSC);
}

public List getCifGuarantorList(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getCifGuarantorList(dashboardSC);
}

public int getCifGuarantorListCount(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getCifGuarantorListCount(dashboardSC);
}

public List<FMSCO> getLiabilitiesApprovedLinesCurrencyDetails(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getLiabilitiesApprovedLinesCurrencyDetails(dashboardSC);
}

public List getLiabilitiesApprovedLinesList(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getLiabilitiesApprovedLinesList(dashboardSC);
}

public List getLiabilitiesApprovedLinesDetailedList(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getLiabilitiesApprovedLinesDetailedList(dashboardSC);
}

@Override
public List<FMSCO> getDrawdownCurrencyDetails(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getDrawdownCurrencyDetails(dashboardSC);
}

@Override
public int getDrawdownListCount(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getDrawdownListCount(dashboardSC);
}

@Override
public List getDrawdownList(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.getDrawdownList(dashboardSC);
}

@Override
public List returnDrawDownApprovedLinesDetailedList(DashboardSC dashboardSC) throws BaseException
{
	return dashFMSDAO.returnDrawDownApprovedLinesDetailedList(dashboardSC);
}

}