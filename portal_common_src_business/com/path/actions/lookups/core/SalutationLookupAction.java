package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.salutation.SalutationBO;
import com.path.dbmaps.vo.CIVIL_CODESVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.salutation.SalutationSC;

public class SalutationLookupAction extends LookupBaseAction {
	
	

	private SalutationSC criteria = new SalutationSC();
	private SalutationBO salutationBO;
	private BigDecimal CIF_TYPE_CODE;
	private BigDecimal cifFlag;
	
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
	    String[] name = {"CIVIL_CODE",
                             "BRIEF_DESC_ENG",
                             "LONG_DESC_ENG",
                             "BRIEF_DESC_ARAB",
                             "LONG_DESC_ARAB"
                             };	
	    String[] colType = { "number", "text", "text", "text", "text" }; 
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"),getText("Long_Desc_Eng_key"), 
	    					getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CIVIL_CODE",
                                    "BRIEF_DESC_ENG",
                                    "LONG_DESC_ENG"};	
		colType = new String[] { "number", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),getText("Long_Desc_Eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Salutation_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Salutation_fillSalutationLookup");
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
     * Fill the lookup Salutation data filtered by the defined criteria
     * 
     * @return
     */
    public String fillSalutationLookup()
    {
	try
	{
	    List<CIVIL_CODESVO> civilCodesVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCifTypeCode(CIF_TYPE_CODE);
	    criteria.setCifFlag(BigDecimal.ONE);
	   
	    if(checkNbRec(criteria))
	    {
		setRecords(salutationBO.salutationListCount(criteria));
	    }
	    civilCodesVOList = salutationBO.salutationList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(civilCodesVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillSalutationLookup of SalutationLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public SalutationSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(SalutationSC criteria)
	{
		this.criteria = criteria;
	}

	public void setSalutationBO(SalutationBO salutationBO)
	{
		this.salutationBO = salutationBO;
	}
	
	public BigDecimal getCifFlag()
	{
		return cifFlag;
	}

	public void setCifFlag(BigDecimal cifFlag)
	{
		this.cifFlag = cifFlag;
	}

	public BigDecimal getCIF_TYPE_CODE()
	{
		return CIF_TYPE_CODE;
	}

	public void setCIF_TYPE_CODE(BigDecimal cIFTYPECODE)
	{
		CIF_TYPE_CODE = cIFTYPECODE;
	}

	

	
    

}
