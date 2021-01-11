package com.path.actions.lookups.core;

import com.path.bo.core.chargesschema.ChargesSchemaBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.chargesschema.ChargesSchemaSC;

public class ChargesSchemaLookupAction extends LookupBaseAction
{
    private ChargesSchemaSC criteria = new ChargesSchemaSC();
    private ChargesSchemaBO chargesSchemaBO;

    public Object getModel()
    {
	return criteria;
    }

    /**
     * @PB : w_lookup_ctscharges_schema
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_Charges_Schema_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ChargesSchema_fillChargesSchemaLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of ChargesSchemaLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Salutation data filtered by the defined criteria
     * 
     * @return
     */
    public String fillChargesSchemaLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(criteria))
	    {
		setRecords(chargesSchemaBO.chargesSchemaListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(chargesSchemaBO.chargesSchemaList(criteria));

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillChargesSchemaLookup of ChargesSchemaLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public ChargesSchemaSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(ChargesSchemaSC criteria)
    {
	this.criteria = criteria;
    }

    public void setChargesSchemaBO(ChargesSchemaBO chargesSchemaBO)
    {
	this.chargesSchemaBO = chargesSchemaBO;
    }

}
