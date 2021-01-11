package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.ciftype.CifTypeBO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ciftype.CifTypeSC;

public class CifTypeLookupAction extends LookupBaseAction
{
    private CifTypeSC criteria = new CifTypeSC();
    private CifTypeBO cifTypeBO;

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
	    String[] name = { "TYPE_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB",
		    "ADDITIONAL_REFERENCE" };
	    String[] colType = { "number", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"),
		    getText("Additional_Reference_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "TYPE_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "ADDITIONAL_REFERENCE" };
		colType = new String[] { "number", "text", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key"), getText("Additional_Reference_key") };
	    } 

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Cif_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifTypeLookup_fillCifTypeLookup");
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
    public String fillCifTypeLookup()
    {
	try
	{
	    List<RIFCTTVO> cifTypeVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setAllTypes(getText("All_types_key"));
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(criteria))
	    {
		setRecords(cifTypeBO.cifTypeListCount(criteria));
	    }
	    cifTypeVOList = cifTypeBO.cifTypeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifTypeVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public CifTypeSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CifTypeSC criteria)
    {
	this.criteria = criteria;
    }

    public void setCifTypeBO(CifTypeBO cifTypeBO)
    {
	this.cifTypeBO = cifTypeBO;
    }
}
