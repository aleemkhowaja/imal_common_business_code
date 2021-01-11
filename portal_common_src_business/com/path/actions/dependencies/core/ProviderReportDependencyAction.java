package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.providerreport.ProviderReportBO;
import com.path.dbmaps.vo.REP_INFOVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.providerreport.ProviderReportSC;

public class ProviderReportDependencyAction extends RetailBaseAction{
	
	private ProviderReportBO providerReportBO;
	private REP_INFOVO reportInfoVO;
	private BigDecimal  REPORT_CODE; 
/**
 * 	
 * Used for returning the Provider Report Details ignoring Company Filter
 * 
 * @return
 */
    public String dependancyByProviderReportWithoutCompFilter()
    {
	try
	{
	    ProviderReportSC criteria = new ProviderReportSC();
	    criteria.setIgnoreComp("1");
	    returnReportInfo(criteria);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependancyByProviderReportWithoutCompFilter method of ProviderReportDependencyAction");
	    handleException(e, "ERROR in ProviderReportDependencyAction", null);
	}

	return SUCCESS;
    }
    /**
     * 
     * Used for returning Provider Report Details
     * 
     * @return
     */
    public String dependancyByProviderReport()
    {
	try
	{
	    ProviderReportSC criteria = new ProviderReportSC();
	    returnReportInfo(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in DependancyByProviderReport method of ProviderReportDependencyAction");
	    handleException(e, "ERROR in ProviderReport", null);
	}

	return SUCCESS;
    }

    private void returnReportInfo(ProviderReportSC criteria) throws BaseException
    {
	criteria.setCompCode(returnSessionObject().getCompanyCode());
	criteria.setApplication(returnSessionObject().getCurrentAppName());
	criteria.setRepType("DWS");
	criteria.setReportId(REPORT_CODE);

	reportInfoVO = providerReportBO.providerReportById(criteria);
    }

    public REP_INFOVO getReportInfoVO()
    {
	return reportInfoVO;
    }

    public void setReportInfoVO(REP_INFOVO reportInfoVO)
    {
	this.reportInfoVO = reportInfoVO;
    }

    public BigDecimal getREPORT_CODE()
    {
	return REPORT_CODE;
    }

    public void setREPORT_CODE(BigDecimal rEPORTCODE)
    {
	REPORT_CODE = rEPORTCODE;
    }

    public void setProviderReportBO(ProviderReportBO providerReportBO)
    {
	this.providerReportBO = providerReportBO;
    }

}
