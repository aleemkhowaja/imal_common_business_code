package com.path.dao.core.providerreport.impl;

import java.util.List;

import com.path.dao.core.providerreport.ProviderReportDAO;
import com.path.dbmaps.vo.REP_INFOVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.providerreport.ProviderReportSC;

public class ProviderReportDAOImpl extends BaseDAO  implements ProviderReportDAO
{
	@Override
    public List providerReportList(ProviderReportSC providerReportSC) throws DAOException
    {
	if(providerReportSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("providerReportMapper.providerReportList", providerReportSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(providerReportSC, getSqlMap(), "providerReportMapper.providerReportList_ResMap");
	    return getSqlMap().queryForList("providerReportMapper.providerReportList", providerReportSC, providerReportSC.getRecToskip(),
		    providerReportSC.getNbRec());
	}
    }

    @Override
    public int providerReportListCount(ProviderReportSC providerReportSC) throws DAOException
    {
	DAOHelper.fixGridMaps(providerReportSC, getSqlMap(), "providerReportMapper.providerReportList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("providerReportMapper.providerReportListCount", providerReportSC)).intValue();
	return nb;
    }

	@Override
	public REP_INFOVO providerReportById(ProviderReportSC providerReportSC) throws DAOException
	{
		return (REP_INFOVO) getSqlMap().queryForObject("providerReportMapper.providerReportById", providerReportSC);
	}

}
