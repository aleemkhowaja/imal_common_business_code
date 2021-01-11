package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.charges.ChargesBO;
import com.path.dbmaps.vo.TRSCHARGESVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.charges.ChargesSC;

public class ChargesLookupAction extends LookupBaseAction
{

    private ChargesBO chargesBO;
    private ChargesSC chargesSC = new ChargesSC();
    List<TRSCHARGESVO> chargesVOList;

    @Override
    public Object getModel()
    {
	return chargesSC;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("brief_Name_key"), getText("Long_Name__key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query__For_Charges_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Charges_fillChargesLookup");
	    lookup(grid, chargesSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CahrgesLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for Charges data filtered by the defined criteria
     * 
     * @return
     */
    public String fillChargesLookup()
    {
	try
	{

	    setSearchFilter(chargesSC);
	    copyproperties(chargesSC);
	    SessionCO sessionCO = returnSessionObject();
	    chargesSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(chargesSC))
	    {
		setRecords(chargesBO.chargesListCount(chargesSC));
	    }
	    chargesVOList = chargesBO.chargesList(chargesSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(chargesVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of  ChargesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement and reschedule
    // Charges START
    public String constructSettlementChargesLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("brief_Name_key"), getText("Long_Name__key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query__For_Charges_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Charges_fillChargesLookup?chargesSC.perInstallmentYn=Y");
	    lookup(grid, chargesSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CahrgesLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    // TP#416613;Roshin;02/02/2017 - EWBI160081 - Settlement and reschedule
    // Charges END

    public ChargesSC getChargesSC()
    {
	return chargesSC;
    }

    public void setChargesSC(ChargesSC chargesSC)
    {
	this.chargesSC = chargesSC;
    }

    public void setChargesBO(ChargesBO chargesBO)
    {
	this.chargesBO = chargesBO;
    }

    public List<TRSCHARGESVO> getChargesVOList()
    {
	return chargesVOList;
    }

    public void setChargesVOList(List<TRSCHARGESVO> chargesVOList)
    {
	this.chargesVOList = chargesVOList;
    }
}
