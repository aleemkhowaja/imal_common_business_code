package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.ctsreparg.CtsReportArgBO;
import com.path.dbmaps.vo.CTS_REP_ARGVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ctsreparg.CtsReportArgSC;

public class CtsReportArgLookupAction  extends LookupBaseAction
{

    CtsReportArgSC criteria = new CtsReportArgSC();
    private CtsReportArgBO ctsReportArgBO;

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
	    String[] name = {"CODE", "FIELD1","FIELD2","FIELD3","FIELD4","FIELD5","FIELD6","FIELD7","FIELD8","FIELD9","FIELD10","FIELD11"};
	    String[] colType = { "number", "text", "text", "text", "text", "text", "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code__key"), getText("Argument_1_key"), getText("Argument_2_key"), getText("Argument_3_key"), getText("Argument_4_key"), 
	    					getText("Argument_5_key"), getText("Argument_6_key"), getText("Argument_7_key"), getText("Argument_8_key"), 
	    					getText("Argument_9_key"), getText("Argument_10_key"), getText("Argument_11_key")};
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    //grid.setCaption(getText("Provider_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsReportArg_fillCtsReportArgLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CtsReportArgLookupAction");
	    e.printStackTrace();
	}

	return SUCCESS;

    }

    public String fillCtsReportArgLookup()
    {
	try
	{
	    List<CTS_REP_ARGVO> reportArgVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setAppName(ConstantsCommon.RADM_APP_NAME);
	    criteria.setTrxType("T");
	    if(checkNbRec(criteria))
	    {
		setRecords(ctsReportArgBO.reportArgListCount(criteria));
	    }
	    reportArgVOList = ctsReportArgBO.reportArgList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(reportArgVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCtsReportArgLookup of CtsReportArgLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public CtsReportArgSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(CtsReportArgSC criteria)
	{
		this.criteria = criteria;
	}

	public void setCtsReportArgBO(CtsReportArgBO ctsReportArgBO)
	{
		this.ctsReportArgBO = ctsReportArgBO;
	}

}
