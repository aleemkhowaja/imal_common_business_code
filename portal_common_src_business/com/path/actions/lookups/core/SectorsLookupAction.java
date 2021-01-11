package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.sectors.SectorsBO;
import com.path.dbmaps.vo.SECTORSVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.sectors.SectorsSC;

public class SectorsLookupAction extends LookupBaseAction {
	
	

	private SectorsSC criteria = new SectorsSC();
	private SectorsBO sectorsBO;
	private BigDecimal COUNTRY_CODE;
	private BigDecimal REGION_CODE;
	private BigDecimal CITY_CODE;
	
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
	    String[] name = {"SECTOR_CODE",
                             "BRIEF_DESC_ENG",
                             "BRIEF_DESC_ARAB",
                             "LONG_DESC_ENG",
                             "LONG_DESC_ARAB",
                             "ADDITIONAL_REFERENCE"
	    					};	
	    String[] colType = { "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Sector_Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
	    		getText("Long_Desc_Eng_key"), getText("Long_Desc_Arab_key"), getText("Additional_Reference_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[]{"SECTOR_CODE",
                                    "BRIEF_DESC_ENG",
                                    "LONG_DESC_ENG",
                                    "ADDITIONAL_REFERENCE" };
		colType = new String[] { "text", "text", "text", "text"};
		titles = new String[] { getText("Sector_Code_key"), getText("Brief_Desc_Eng_key"),
	    		getText("Long_Desc_Eng_key"), getText("Additional_Reference_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Sector__key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/SectorLookup_fillSectorsLookup");
	  /*  int cols = name.length;

	    for(int i = 0; i < cols; i++)
	    {
		// Defining each column
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);
	    }
	     lookup(grid, lsGridColumn, null, criteria);
	     */
	    lookup(grid,criteria,name,colType,titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Sectors data filtered by the defined criteria
     * 
     * @return
     */
    public String fillSectorsLookup()
    {
	try
	{
	    List<SECTORSVO> sectorsVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCountry_code(COUNTRY_CODE);
	    criteria.setRegion_code(REGION_CODE);
	    criteria.setCity_code(CITY_CODE);
	   
	    if(checkNbRec(criteria))
	    {
		setRecords(sectorsBO.sectorsListCount(criteria));
	    }
	    sectorsVOList = sectorsBO.sectorsList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(sectorsVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillSectorsLookup of SectorsLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public SectorsSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(SectorsSC criteria)
	{
		this.criteria = criteria;
	}

	public void setSectorsBO(SectorsBO sectorsBO)
	{
		this.sectorsBO = sectorsBO;
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

	public BigDecimal getCITY_CODE()
	{
		return CITY_CODE;
	}

	public void setCITY_CODE(BigDecimal cITYCODE)
	{
		CITY_CODE = cITYCODE;
	}

	

	

}
