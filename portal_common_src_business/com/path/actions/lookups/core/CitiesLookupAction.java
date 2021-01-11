package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.cities.CitiesBO;
import com.path.dbmaps.vo.CITIESVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cities.CitiesSC;

public class CitiesLookupAction extends LookupBaseAction {
	
	
	private CitiesSC criteria = new CitiesSC();
	private CitiesBO citiesBO;
	private BigDecimal COUNTRY_CODE;
	private BigDecimal REGION_CODE;
	
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
	    String[] name = {"CITY_CODE",
                             "BRIEF_DESC_ENG",
                             "BRIEF_DESC_ARAB",
                             "LONG_DESC_ENG",
                             "LONG_DESC_ARAB",
                             "ADDITIONAL_REFERENCE"
	    					};	
	    String[] colType = { "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
	    		getText("Long_Desc_Eng_key"),getText("Long_Desc_Arab_key"), getText("Additional_Reference_key")};
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CITY_CODE",
                                    "BRIEF_DESC_ENG",
                                    "LONG_DESC_ENG",
                                    "ADDITIONAL_REFERENCE" };
		colType = new String[] { "text", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
	    		getText("Long_Desc_Eng_key"), getText("Additional_Reference_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("City_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CityLookup_fillCitiesLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CitiesLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Cities data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCitiesLookup()
    {
	try
	{
	    List<CITIESVO> citiesVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCountry_code(COUNTRY_CODE);
	    criteria.setRegion_code(REGION_CODE);
	   
	    if(checkNbRec(criteria))
	    {
		setRecords(citiesBO.citiesListCount(criteria));
	    }
	    citiesVOList = citiesBO.citiesList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(citiesVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCitiesLookup of CitiesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public CitiesSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(CitiesSC criteria)
	{
		this.criteria = criteria;
	}

	public void setCitiesBO(CitiesBO citiesBO)
	{
		this.citiesBO = citiesBO;
	}

	public BigDecimal getCOUNTRY_CODE()
	{
		return COUNTRY_CODE;
	}

	public void setCOUNTRY_CODE(BigDecimal cOUNTRYCODE)
	{
		COUNTRY_CODE = cOUNTRYCODE;
	}

	public BigDecimal getREGION_CODE()
	{
		return REGION_CODE;
	}

	public void setREGION_CODE(BigDecimal rEGIONCODE)
	{
		REGION_CODE = rEGIONCODE;
	}
}
