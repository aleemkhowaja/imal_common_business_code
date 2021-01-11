package com.path.dao.core.providerreport;

import java.util.List;

import com.path.dbmaps.vo.REP_INFOVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.providerreport.ProviderReportSC;

public interface ProviderReportDAO
{
	public int  providerReportListCount(ProviderReportSC providerReportSC) throws DAOException;
	public List providerReportList(ProviderReportSC providerReportSC) throws DAOException;
	public REP_INFOVO  providerReportById(ProviderReportSC providerReportSC) throws DAOException;
}
