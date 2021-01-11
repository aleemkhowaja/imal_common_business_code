/**
 * 
 */
package com.path.dao.common.global360view.fms.impl;

import java.util.List;

import com.path.dao.common.global360view.fms.DashFMSDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.FMSCO;

public class DashFMSDAOImpl extends BaseDAO implements DashFMSDAO
{

	public List<FMSCO> getSecurityCurrencyDetails(DashboardSC dashboardSC) throws DAOException
	{
		return getSqlMap().queryForList("dashFMSMapper.dw_cust_securityCurrencies", dashboardSC);
	}

	public List getSecurityList(DashboardSC dashboardSC) throws DAOException
	{
		if(dashboardSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("dashFMSMapper.dw_cust_securityList", dashboardSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_cust_securityMap");
		    return getSqlMap().queryForList("dashFMSMapper.dw_cust_securityList", dashboardSC, dashboardSC.getRecToskip(),
		    		dashboardSC.getNbRec());
		}
	}

	public int getSecurityListCount(DashboardSC dashboardSC) throws DAOException
	{
		DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_cust_securityMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("dashFMSMapper.dw_cust_securityListCount", dashboardSC)).intValue();
		return nb;
	}

	public List<FMSCO> getNewAppCurrencyDetails(DashboardSC dashboardSC) throws DAOException
	{
		return getSqlMap().queryForList("dashFMSMapper.dw_new_appCurrencies", dashboardSC);
	}

	public List getNewAppList(DashboardSC dashboardSC) throws DAOException
	{
		if(dashboardSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("dashFMSMapper.dw_new_appList", dashboardSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_new_appMap");
		    return getSqlMap().queryForList("dashFMSMapper.dw_new_appList", dashboardSC);
		}
	}

	public int getNewAppListCount(DashboardSC dashboardSC) throws DAOException
	{
		DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_new_appMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("dashFMSMapper.dw_new_appListCount", dashboardSC)).intValue();
		return nb;
	}

	public List<FMSCO> getBlockedAndSuspendedFacilitiesCurrencyDetails(DashboardSC dashboardSC) throws DAOException
	{
		return getSqlMap().queryForList("dashFMSMapper.dw_cif_facilitiesCurrencies", dashboardSC);
	}

	public List getBlockedAndSuspendedFacilitiesList(DashboardSC dashboardSC) throws DAOException
	{
		if(dashboardSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("dashFMSMapper.dw_cif_facilitiesList", dashboardSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_cif_facilitiesMap");
		    return getSqlMap().queryForList("dashFMSMapper.dw_cif_facilitiesList", dashboardSC);
		}
	}

	public int getBlockedAndSuspendedFacilitiesListCount(DashboardSC dashboardSC) throws DAOException
	{
		DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_cif_facilitiesMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("dashFMSMapper.dw_cif_facilitiesListCount", dashboardSC)).intValue();
		return nb;
	}

	public List<FMSCO> getCifGuarantorCurrencyDetails(DashboardSC dashboardSC) throws DAOException
	{
		return getSqlMap().queryForList("dashFMSMapper.dw_cif_guarantorCurrencies", dashboardSC);
	}

	public List getCifGuarantorList(DashboardSC dashboardSC) throws DAOException
	{
		if(dashboardSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("dashFMSMapper.dw_cif_guarantorList", dashboardSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_cif_facilitiesMap");
		    return getSqlMap().queryForList("dashFMSMapper.dw_cif_guarantorList", dashboardSC);
		}
	}

	public int getCifGuarantorListCount(DashboardSC dashboardSC) throws DAOException
	{
		DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_cif_facilitiesMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("dashFMSMapper.dw_cif_guarantorListCount", dashboardSC)).intValue();
		return nb;
	}

	public List<FMSCO> getLiabilitiesApprovedLinesCurrencyDetails(DashboardSC dashboardSC) throws DAOException
	{
		return getSqlMap().queryForList("dashFMSMapper.dw_approved_linesCurrencies", dashboardSC);
	}

	public List getLiabilitiesApprovedLinesList(DashboardSC dashboardSC) throws DAOException
	{
		if(dashboardSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("dashFMSMapper.dw_approved_linesList", dashboardSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_approved_linesMap");
		    return getSqlMap().queryForList("dashFMSMapper.dw_approved_linesList", dashboardSC);
		}
	}

	public List getLiabilitiesApprovedLinesDetailedList(DashboardSC dashboardSC) throws DAOException
	{
		if(dashboardSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("dashFMSMapper.dw_approved_linesDetailedList", dashboardSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_approved_linesMap");
		    return getSqlMap().queryForList("dashFMSMapper.dw_approved_linesDetailedList", dashboardSC);
		}
	}

    @Override
    public List<FMSCO> getDrawdownCurrencyDetails(DashboardSC dashboardSC) throws DAOException
    {
	return getSqlMap().queryForList("dashFMSMapper.dw_drawdown_detailsCurrencies", dashboardSC);
    }

    @Override
    public int getDrawdownListCount(DashboardSC dashboardSC) throws DAOException
    {
	DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_drawdown_detailsMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashFMSMapper.dw_drawdown_detailsListCount", dashboardSC)).intValue();
	return nb;
    }

    @Override
    public List getDrawdownList(DashboardSC dashboardSC) throws DAOException
    {
	DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_drawdown_detailsMap");
	if(dashboardSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashFMSMapper.dw_drawdown_detailsList", dashboardSC);
	}
	else
	{
	    return getSqlMap().queryForList("dashFMSMapper.dw_drawdown_detailsList", dashboardSC,dashboardSC.getRecToskip(), dashboardSC.getNbRec());
	}
    }

    @Override
    public List returnDrawDownApprovedLinesDetailedList(DashboardSC dashboardSC) throws DAOException
    {
	if(dashboardSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashFMSMapper.dw_drawdown_approved_linesDetailedList", dashboardSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(dashboardSC, getSqlMap(), "dashFMSMapper.dw_drawdown_approved_linesDetailedListMap");
	    return getSqlMap().queryForList("dashFMSMapper.dw_drawdown_approved_linesDetailedList", dashboardSC);
	}
    }
}
