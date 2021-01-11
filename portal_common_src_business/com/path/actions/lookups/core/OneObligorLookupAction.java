package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.oneobligor.OneObligorBO;
import com.path.dbmaps.vo.RIFOBTVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.oneobligor.OneObligorSC;

public class OneObligorLookupAction extends LookupBaseAction
{

    private OneObligorSC oneObligorSC = new OneObligorSC();
    private OneObligorBO oneObligorBO;

    @Override
    public Object getModel()
    {
	return oneObligorSC;
    }

    /**
     * Construct OneObligor Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "OBLIGOR_CODE", "ADDITIONAL_REFERENCE", "BRIEF_DESC_ENG", "LONG_DESC_ENG",
		    "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Obligor_Code_key"), getText("Additional_Reference_key"),
		    getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
		    getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "OBLIGOR_CODE", "ADDITIONAL_REFERENCE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text", "text" };
		titles = new String[] { getText("Obligor_Code_key"), getText("Additional_Reference_key"),
			getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_One_Obligor_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/OneObligor_fillOneObligorLookup");

	    lookup(grid, oneObligorSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for OneObligor data filtered by the defined criteria
     * 
     * @return
     */
    public String fillOneObligorLookup()
    {
	try
	{
	    List<RIFOBTVO> oneObligorVOList;
	    setSearchFilter(oneObligorSC);
	    copyproperties(oneObligorSC);
	    SessionCO sessionCO = returnSessionObject();
	    oneObligorSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(oneObligorSC))
	    {
		setRecords(oneObligorBO.oneObligorListCount(oneObligorSC));
	    }
	    oneObligorVOList = oneObligorBO.oneObligorList(oneObligorSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(oneObligorVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of OneObligorLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // TP#202527; Saheer.Naduthodi; 01/08/2014 [START]
    // PB_Name: w_lookup_limit_class

    public String constructClassLookup()
    {
	try
	{
	    String[] name = { "CODE", "CATEGORY", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "EXPOSURE_LIMIT", "PREFIX",
		    "SETTLEMENT_DIVISION" };
	    String[] colType = { "number", "number", "text", "text", "number", "text", "number" };
	    String[] titles = { getText("Code_key"), getText("Category_key"), getText("Brief_Name_Eng_key"),
		    getText("Brief_Name_Arab_key"), getText("Exposure_Limit_key"), getText("Prefix_key"),
		    getText("Settlement_Division_key") };

	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_One_Obligor_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/OneObligor_fillOneObligorClassLookup");

	    lookup(grid, oneObligorSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillOneObligorClassLookup()
    {
	try
	{
	    List<TRSCLASSVO> oneObligorClassList;
	    setSearchFilter(oneObligorSC);
	    copyproperties(oneObligorSC);
	    SessionCO sessionCO = returnSessionObject();
	    oneObligorSC.setCompCode(sessionCO.getCompanyCode());
	    oneObligorSC.setCurrAppName(sessionCO.getCurrentAppName());
	    if(checkNbRec(oneObligorSC))
	    {
		setRecords(oneObligorBO.oneObligorClassCount(oneObligorSC));
	    }
	    oneObligorClassList = oneObligorBO.oneObligorClassList(oneObligorSC);
	    setGridModel(oneObligorClassList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of OneObligorClassLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // TP#202527; Saheer.Naduthodi; 01/08/2014 [END]
    public OneObligorSC getOneObligorSC()
    {
	return oneObligorSC;
    }

    public void setOneObligorSC(OneObligorSC oneObligorSC)
    {
	this.oneObligorSC = oneObligorSC;
    }

    public void setOneObligorBO(OneObligorBO oneObligorBO)
    {
	this.oneObligorBO = oneObligorBO;
    }

}
