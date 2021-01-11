package com.path.bo.core.providerreport.impl;

import java.util.List;

import com.path.bo.core.providerreport.ProviderReportBO;
import com.path.dao.core.providerreport.ProviderReportDAO;
import com.path.dbmaps.vo.REP_INFOVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.providerreport.ProviderReportSC;

public class ProviderReportBOImpl extends BaseBO implements ProviderReportBO
{
    private ProviderReportDAO providerReportDAO;
    
    public ProviderReportDAO getProviderReportDAO()
    {
        return providerReportDAO;
    }

    public void setProviderReportDAO(ProviderReportDAO providerReportDAO)
    {
        this.providerReportDAO = providerReportDAO;
    }

    @Override
    public List providerReportList(ProviderReportSC providerReportSC) throws BaseException
    {
	return providerReportDAO.providerReportList(providerReportSC);
    }

    @Override
    public int providerReportListCount(ProviderReportSC providerReportSC) throws BaseException
    {
	return providerReportDAO.providerReportListCount(providerReportSC);
    }

	@Override
	public REP_INFOVO providerReportById(ProviderReportSC providerReportSC) throws BaseException
	{
		return (REP_INFOVO) providerReportDAO.providerReportById(providerReportSC);
	}

}
