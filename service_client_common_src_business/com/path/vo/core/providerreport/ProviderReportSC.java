package com.path.vo.core.providerreport;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * ProviderReportSC.java used to
 */
public class ProviderReportSC extends GridParamsSC
{
    private BigDecimal reportId;
    private String application;
    private String repType;
    // used to remove company checking Filter in the Query
    private String ignoreComp;
    
    public String getApplication()
    {
        return application;
    }

    public void setApplication(String application)
    {
        this.application = application;
    }

    public String getRepType()
    {
        return repType;
    }

    public void setRepType(String repType)
    {
        this.repType = repType;
    }
    
    public BigDecimal getReportId()
    {
        return reportId;
    }

    public void setReportId(BigDecimal reportId)
    {
        this.reportId = reportId;
    }

    public String getIgnoreComp()
    {
        return ignoreComp;
    }

    public void setIgnoreComp(String ignoreComp)
    {
        this.ignoreComp = ignoreComp;
    }
}
