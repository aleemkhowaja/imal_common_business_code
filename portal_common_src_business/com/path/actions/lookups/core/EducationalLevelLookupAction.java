package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.educationallevel.EducationalLevelBO;
import com.path.dbmaps.vo.EDUC_DEGREEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.educationallevel.EducationalLevelSC;

public class EducationalLevelLookupAction extends LookupBaseAction
{
    
    private EducationalLevelSC educationalLevelSC = new EducationalLevelSC();
    private EducationalLevelBO educationalLevelBO;


    @Override
    public Object getModel()
    {
	return educationalLevelSC;
    }

    /**
     * Construct EducationalLevel Lookup based on the VO returned in the
     * resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Eng_key"),
		    getText("Long_Desc_Arab_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_DESC_ENG",  "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("legal_status_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/EducationalLevel_fillEducationalLevelLookup");
	    lookup(grid, educationalLevelSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	

	return SUCCESS;

    }

    /**
     * Fill the lookup for EducationalLevel data filtered by the defined
     * criteria
     * 
     * @return
     */
    public String fillEducationalLevelLookup()
    {
	try
	{
	    List<EDUC_DEGREEVO> educationalLevelVOList;
	    setSearchFilter(educationalLevelSC);
	    copyproperties(educationalLevelSC);
	    SessionCO sessionCO = returnSessionObject();
	    educationalLevelSC.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(educationalLevelSC))
	    {
		setRecords(educationalLevelBO.educationalLevelListCount(educationalLevelSC));
	    }
	    educationalLevelVOList = educationalLevelBO.educationalLevelList(educationalLevelSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(educationalLevelVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of EducationalLevelLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setEducationalLevelBO(EducationalLevelBO educationalLevelBO)
    {
	this.educationalLevelBO = educationalLevelBO;
    }

    public EducationalLevelSC getEducationalLevelSC()
    {
	return educationalLevelSC;
    }

    public void setEducationalLevelSC(EducationalLevelSC educationalLevelSC)
    {
	this.educationalLevelSC = educationalLevelSC;
    }
}
