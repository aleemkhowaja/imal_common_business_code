/**
 * 
 */
package com.path.actions.common.global360view.investments;

import java.util.List;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.investments.DashInvestmentsBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: elieachkar
 * 
 *          DashInvestmentsListAction.java used to
 */
public class DashInvestmentsListAction extends GridBaseAction
{
    private DashInvestmentsBO dashInvestmentsBO;
    private DashboardSC criteria = new DashboardSC();
    private String bookValueList;
    private String marketValueList;
    private String ondblclick;

    /**
     * 
     */
    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * 
     * @return String
     * @throws BaseException
     * 
     */
    public String loadInvestmentsPage() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	criteria.setCompCode(sessionCO.getCompanyCode());
	criteria.setUserId(sessionCO.getUserName());
	if(NumberUtil.isEmptyDecimal(criteria.getBranchCode()))
	{
	    criteria.setBranchCode(sessionCO.getBranchCode());
	}
	if(criteria.getRunningDate() == null)
	{
	    criteria.setRunningDate(sessionCO.getRunningDateRET());
	}

	// Storing date as String to be used as query parameter
	criteria.setAsOfDateStr(DateUtil.format(criteria.getRunningDate(), "dd/MM/yyyy"));
	if("QUERYPOSITION".equalsIgnoreCase(criteria.getCallSource()))
	{
	    ondblclick = "queryPosition_investments_onDbClickedEvent()";
	}
	else
	{
	    ondblclick = "investments_onDbClickedEvent()";
	}

	bookValueAmount();
	marketValueAmount();
	return SUCCESS;
    }

    /**
     * 
     * @author elieachkar
     * @date May 29, 2013
     * @return
     * 
     */
    public String investmentsListGrid()
    {
	String[] searchCol = { "BRANCH", "CIF", "SEQ", "PF_NAME", "LONG_NAME", "BASE_CY", "PORTFOLIO_TYPE",
		"PORTFOLIO_VALUE_BASE_CY", "PORTFOLIO_VALUE_CONS_CY", "DATE_OPENED", "STATUS",
		"PORTFOLIO_MARKET_BASE_CY", "PORTFOLIO_MARKET_CONS_CY" };

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());


	    /**
	     * The branch code and running date they will send from ASSETS team, otherwise read them from session
	     */
	    if(NumberUtil.isEmptyDecimal(criteria.getBranchCode()))
	    {
		criteria.setBranchCode(sessionCO.getBranchCode());
	    }
	    if(criteria.getRunningDate() == null)
	    {
		criteria.setRunningDate(sessionCO.getRunningDateRET());
	    }

	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setLovType(ConstantsCommon.INVESTMENT_STATUS_LOV_TYPE);

	    /**
	     * used for the dynamic call from Assets application
	     */
	    if(ConstantsCommon.ASSETS_QUERY_POS_CALL_SOURCE.equalsIgnoreCase(criteria.getCallSource()))
	    {
                criteria.setProgRef(ConstantsCommon.ASSET_QUERY_POSITION_REF);
	    }
            else
            {
        	criteria.setProgRef(ConstantsCommon.INVESTMENT_QUERY_REF);
            }

	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setLangCode(sessionCO.getLanguage());
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);

	    if(checkNbRec(criteria))
	    {
		setRecords(dashInvestmentsBO.investmentsListCount(criteria));
	    }
	    setGridModel(dashInvestmentsBO.investmentsList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Investments List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public void bookValueAmount() throws BaseException
    {
	List bookValues = dashInvestmentsBO.bookValueList(criteria);
	bookValueList = CommonMethods.convertListToJSONString(bookValues);
    }

    public void marketValueAmount() throws BaseException
    {
	List marketValues = dashInvestmentsBO.marketValueList(criteria);
	marketValueList = CommonMethods.convertListToJSONString(marketValues);
    }

    public void setDashInvestmentsBO(DashInvestmentsBO dashInvestmentsBO)
    {
	this.dashInvestmentsBO = dashInvestmentsBO;
    }

    public DashboardSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(DashboardSC criteria)
    {
	this.criteria = criteria;
    }

    public String getBookValueList()
    {
	return bookValueList;
    }

    public void setBookValueList(String bookValueList)
    {
	this.bookValueList = bookValueList;
    }

    public String getMarketValueList()
    {
	return marketValueList;
    }

    public void setMarketValueList(String marketValueList)
    {
	this.marketValueList = marketValueList;
    }

    /**
     * @return the ondblclick
     */
    public String getOndblclick()
    {
	return ondblclick;
    }

    /**
     * @param ondblclick the ondblclick to set
     */
    public void setOndblclick(String ondblclick)
    {
	this.ondblclick = ondblclick;
    }
}
