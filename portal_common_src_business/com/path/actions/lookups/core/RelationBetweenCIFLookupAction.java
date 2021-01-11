package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.cifrelation.CifRelationBO;
import com.path.dbmaps.vo.RELATION_BETWEEN_CIFSVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cifrelation.CifRelationSC;

public class RelationBetweenCIFLookupAction extends LookupBaseAction
{

    private CifRelationSC criteria = new CifRelationSC();
    private CifRelationBO cifRelationBO;
	
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
	    String[] name = {"CODE",
                             "BRIEF_DESC_ENG",
                             "BRIEF_DESC_ARAB" };	
	    String[] colType = {"text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "REGION_CODE", "BRIEF_DESC_ENG"};
		colType = new String[] { "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/RelationBwCif_fillCifRelationLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Religion data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCifRelationLookup()
    {
	try
	{
	    List<RELATION_BETWEEN_CIFSVO> cifRelationVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	   
	    if(checkNbRec(criteria))
	    {
		setRecords(cifRelationBO.cifRelationListCount(criteria));
	    }
	    cifRelationVOList = cifRelationBO.cifRelationList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifRelationVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public CifRelationSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CifRelationSC criteria)
    {
	this.criteria = criteria;
    }

    public void setCifRelationBO(CifRelationBO cifRelationBO)
    {
	this.cifRelationBO = cifRelationBO;
    }

	
}
