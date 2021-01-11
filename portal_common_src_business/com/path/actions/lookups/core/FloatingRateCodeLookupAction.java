package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.floatingratecode.FloatingRateCodeBO;
import com.path.dbmaps.vo.IBOR_HDRVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.floatingratecode.FloatingRateCodeSC;

public class FloatingRateCodeLookupAction extends LookupBaseAction
{

    private FloatingRateCodeSC floatingRateCodeSC = new FloatingRateCodeSC();
    private FloatingRateCodeBO floatingRateCodeBO;

    @Override
    public Object getModel()
    {
	return floatingRateCodeSC;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "IBOR_CODE", "BRIEF_DESC_ENG" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("Rate_Code_key"), getText("Brief_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifType.cifType"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/floatingRateCodeLookup_fillFloatingRateCodeLookup");

	    lookup(grid, floatingRateCodeSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillFloatingRateCodeLookup()
    {
	try
	{
	    List<IBOR_HDRVO> floatingRateCodeVOList;
	    setSearchFilter(floatingRateCodeSC);
	    copyproperties(floatingRateCodeSC);
	    SessionCO sessionCO = returnSessionObject();
	    floatingRateCodeSC.setCompCode(sessionCO.getCompanyCode());
	    floatingRateCodeSC.setBranchCode(sessionCO.getBranchCode());

	    if(checkNbRec(floatingRateCodeSC))
	    {
		setRecords(floatingRateCodeBO.floatingRateCodeListCount(floatingRateCodeSC));
	    }
	    floatingRateCodeVOList = floatingRateCodeBO.floatingRateCodeList(floatingRateCodeSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(floatingRateCodeVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of AccountLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public FloatingRateCodeSC getFloatingRateCodeSC()
    {
	return floatingRateCodeSC;
    }

    public void setFloatingRateCodeSC(FloatingRateCodeSC floatingRateCodeSC)
    {
	this.floatingRateCodeSC = floatingRateCodeSC;
    }

    public void setFloatingRateCodeBO(FloatingRateCodeBO FloatingRateCodeBO)
    {
	this.floatingRateCodeBO = FloatingRateCodeBO;
    }

}
