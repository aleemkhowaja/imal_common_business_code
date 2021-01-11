package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.nationality.NationalityBO;
import com.path.dbmaps.vo.NATIONALITYVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.nationality.NationalitySC;

public class NationalityLookupAction extends LookupBaseAction
{

    private NationalitySC criteria = new NationalitySC();
    private NationalityBO nationalityBO;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    
    /**
     * @PB : w_lookup_nationality
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB", };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
		    getText("Long_Desc_Eng_key"), getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Nationality_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/NationalityLookup_fillNationalityLookup");

	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;

    }

    /**
     * Fill the lookup CIF Type data filtered by the defined criteria
     * 
     * @return
     */
    public String fillNationalityLookup()
    {
	try
	{
	    List<NATIONALITYVO> nationalityVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    if(NumberUtil.isEmptyDecimal(criteria.getCompCode())){
	    	criteria.setCompCode(sessionCO.getCompanyCode());
	    }

	    if(checkNbRec(criteria))
	    {
		setRecords(nationalityBO.nationalityListCount(criteria));
	    }
	    nationalityVOList = nationalityBO.nationalityList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(nationalityVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillNationalityLookup of NationalityLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public NationalitySC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(NationalitySC criteria)
    {
	this.criteria = criteria;
    }

    public void setNationalityBO(NationalityBO nationalityBO)
    {
	this.nationalityBO = nationalityBO;
    }

}
