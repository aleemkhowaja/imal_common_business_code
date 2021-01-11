package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.providerreport.ProviderReportBO;
import com.path.dbmaps.vo.REP_INFOVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.providerreport.ProviderReportSC;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: AIssac
 * 
 *          ProviderReportLookupAction.java used to
 */
public class ProviderReportLookupAction extends LookupBaseAction
{

    

    private ProviderReportSC criteria = new ProviderReportSC();
    private ProviderReportBO providerReportBO;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public String constructLookup()
    {
	try
	{

	    // Design the Grid by defining the column model and column names
	    String[] name = { "REP_ID", "TITLE", "USERID" };
	    String[] colType = { "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Report_Title_key"), getText("UserID_key") };

	    // below condition added by assetsteam for tp#84891
	    if(ConstantsCommon.ASSETS_APP_NAME.equals(returnSessionObject().getCurrentAppName()))
	    {
		name = new String[] { "REP_ID", "TITLE" };
		colType = new String[] { "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Report_Title_key") };

	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Provider_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ProviderReport_fillProviderReportLookup");
	    lookup(grid, criteria, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;

    }

    /**
     * Fill the lookup ProviderReport Type data filtered by the defined criteria
     * 
     * @return
     */
    public String fillProviderReportLookup()
    {
	try
	{
	    List<REP_INFOVO> reportInfoVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setApplication(returnSessionObject().getCurrentAppName());
	    criteria.setRepType("DWS");
	    if(checkNbRec(criteria))
	    {
		setRecords(providerReportBO.providerReportListCount(criteria));
	    }
	    reportInfoVOList = providerReportBO.providerReportList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(reportInfoVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillProviderReportLookup of ProviderReportLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setProviderReportBO(ProviderReportBO providerReportBO)
    {
	this.providerReportBO = providerReportBO;
    }

    public ProviderReportSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(ProviderReportSC criteria)
    {
	this.criteria = criteria;
    }

}
