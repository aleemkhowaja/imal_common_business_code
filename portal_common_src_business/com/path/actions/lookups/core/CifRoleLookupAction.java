package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.cifrole.CifRoleBO;
import com.path.dbmaps.vo.CIF_ROLEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cifrole.CifRoleSC;

public class CifRoleLookupAction extends LookupBaseAction
{
    private CifRoleBO cifRoleBO;
    private CifRoleSC criteria = new CifRoleSC();
   
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
	    String[] name = {	"ROLE_CODE",
                            "ADDITIONAL_REFERENCE",
                            "BRIEF_DESC_ENG",
                			"LONG_DESC_ENG",
                			"BRIEF_DESC_ARAB",
                			"LONG_DESC_ARAB"
                        };	
	    String[] colType = { "number", "text", "text", "text","text", "text"};
	    String[] titles = { getText("Role_Code_key"), getText("Additional_Reference_key"),getText("Brief_Desc_Eng_key"), 
	    					getText("Long_Desc_Eng_key"),getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {	"ROLE_CODE",
                                        "ADDITIONAL_REFERENCE",
                                        "BRIEF_DESC_ENG",
            				"LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text", "text"};
		titles = new String[] { getText("Role_Code_key"), getText("Additional_Reference_key"),getText("Brief_Desc_Eng_key"), 
				getText("Long_Desc_Eng_key")};
	    }
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_Role_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifRole_fillCifRoleLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CifRoleLookupAction");
	    e.printStackTrace();
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for Role data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCifRoleLookup()
    {
	try
	{
	    List<CIF_ROLEVO> cifRoleVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(cifRoleBO.cifRoleListCount(criteria));
	    }
	    cifRoleVOList = cifRoleBO.cifRoleList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifRoleVOList);


	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCifRoleLookup of CifRoleLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public CifRoleSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CifRoleSC criteria)
    {
	this.criteria = criteria;
    }

    public void setCifRoleBO(CifRoleBO cifRoleBO)
    {
	this.cifRoleBO = cifRoleBO;
    }
}
