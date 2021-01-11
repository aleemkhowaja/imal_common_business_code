package com.path.actions.common.global360view.financingDeals;

import com.path.bo.common.global360view.financingDeals.FinancingDealsBO;
import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.global360view.FinancingDealsSC;

@SuppressWarnings("serial")
public class FinancingDealsMaintAction extends BaseAction
{

    private FinancingDealsSC financingDealsSC = new FinancingDealsSC();
    private FinancingDealsBO financingDealsBO;

    public String printScheduleReport()
    {
	try
	{
	    financingDealsSC.setCompCode(returnSessionObject().getCompanyCode());
	    financingDealsSC.setRunningDate(returnSessionObject().getRunningDateRET());
	    financingDealsSC = financingDealsBO.printScheduleReport(financingDealsSC);
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public FinancingDealsSC getFinancingDealsSC()
    {
	return financingDealsSC;
    }

    public void setFinancingDealsSC(FinancingDealsSC financingDealsSC)
    {
	this.financingDealsSC = financingDealsSC;
    }

    public void setFinancingDealsBO(FinancingDealsBO financingDealsBO)
    {
	this.financingDealsBO = financingDealsBO;
    }

}
