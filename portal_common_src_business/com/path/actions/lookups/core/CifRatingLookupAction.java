package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.cifrating.CifRatingBO;
import com.path.dbmaps.vo.CREDIT_RATINGVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cifrating.CifRatingSC;

public class CifRatingLookupAction extends LookupBaseAction
{
    private CifRatingBO cifRatingBO;
    private CifRatingSC cifRatingSC = new CifRatingSC();
    
    @Override
    public Object getModel()
    {
	return cifRatingSC;
    }

    /**
     * Construct CifRating Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB","SOURCE" };
	    String[] colType = { "number", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"),getText("source_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "SOURCE" };
		colType = new String[] { "number", "text", "text","text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),getText("source_key")};
	    }
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_Credit_Rating_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifRating_fillCifRatingLookup");
	    lookup(grid, cifRatingSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for CifRating data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCifRatingLookup()
    {
	try
	{
	    List<CREDIT_RATINGVO> cifRatingVOList;
	    setSearchFilter(cifRatingSC);
	    copyproperties(cifRatingSC);
	    SessionCO sessionCO = returnSessionObject();
	    cifRatingSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(cifRatingSC))
	    {
		setRecords(cifRatingBO.cifRatingListCount(cifRatingSC));
	    }
	    cifRatingVOList = cifRatingBO.cifRatingList(cifRatingSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifRatingVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setCifRatingBO(CifRatingBO cifRatingBO)
    {
	this.cifRatingBO = cifRatingBO;
    }

    public CifRatingSC getCifRatingSC()
    {
	return cifRatingSC;
    }

    public void setCifRatingSC(CifRatingSC cifRatingSC)
    {
	this.cifRatingSC = cifRatingSC;
    }

}
