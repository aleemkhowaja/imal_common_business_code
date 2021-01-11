package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.relation.RelationBO;
import com.path.dbmaps.vo.RELATIONVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.relation.RelationSC;

public class RelationLookupAction extends LookupBaseAction
{
    
    private RelationBO relationBO;
    private RelationSC relationSC = new RelationSC();
    private String additionalRef;


    @Override
    public Object getModel()
    {
	return relationSC;
    }
    
    
    /**
     * Construct Relation Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "RELATION_CODE", "ADDITIONAL_REFERENCE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Relation_Code_key"), getText("Additional_Reference_key"),
		    getText("Brief_Desc_Eng_key") , getText("Long_Desc_Eng_key"), getText("Brief_Desc_Arab_key")
		    , getText("Long_Desc_Arab_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "RELATION_CODE", "ADDITIONAL_REFERENCE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text", "text"};
		titles = new String[] {  getText("Relation_Code_key"), getText("Additional_Reference_key"),
			    getText("Brief_Desc_Eng_key") , getText("Long_Desc_Eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_Relation_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Relation_fillRelationLookup");
	    if(StringUtil.isNotEmpty(additionalRef))
	    {
		grid.setUrl("/pathdesktop/Relation_fillRelationLookup?additionalRef="+additionalRef);
	    }  
	    lookup(grid,relationSC,name,colType,titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for Relation data filtered by the defined criteria
     * 
     * @return
     */
    public String fillRelationLookup()
    {
	try
	{
	    List<RELATIONVO> relationVOList;
	    setSearchFilter(relationSC);
	    copyproperties(relationSC);
	    if(StringUtil.isNotEmpty(additionalRef))
	    {
		relationSC.setAddReference(additionalRef);
	    }
	    SessionCO sessionCO = returnSessionObject();
	    relationSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(relationSC))
	    {
		setRecords(relationBO.relationListCount(relationSC));
	    }
	    relationVOList = relationBO.relationList(relationSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(relationVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of RelationLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public RelationSC getRelationSC()
    {
        return relationSC;
    }


    public void setRelationSC(RelationSC relationSC)
    {
        this.relationSC = relationSC;
    }
    
    public void setRelationBO(RelationBO relationBO)
    {
        this.relationBO = relationBO;
    }


    public String getAdditionalRef()
    {
        return additionalRef;
    }


    public void setAdditionalRef(String additionalRef)
    {
        this.additionalRef = additionalRef;
    }
    
    
}
