package com.path.bo.core.providerreport;

import java.util.List;

import com.path.dbmaps.vo.REP_INFOVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.providerreport.ProviderReportSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * ProviderReportBO.java used to
 */
public interface ProviderReportBO
{
	public int  providerReportListCount(ProviderReportSC providerReportSC) throws BaseException;
	public List providerReportList(ProviderReportSC providerReportSC) throws BaseException;
	public REP_INFOVO  providerReportById(ProviderReportSC providerReportSC) throws BaseException;

}
