/**
 * @Auther:John Massaad
 * @Date:Mar 6, 2016
 * @Team:JAVA Team.
 * @copyright: PathSolution 2016
 */
package com.path.actions.lookups.core;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.core.authsignatories.AuthSignatoriesBO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.authsignatories.AuthSignatoriesSC;

/**
 * @author MarwanMaddah
 * 
 */
public class AuthSignatoriesLookupAction extends LookupBaseAction
{
    private AuthSignatoriesSC criteria = new AuthSignatoriesSC();
    private AuthSignatoriesBO authSignatoriesBO;


    private String lookupCallingScreen;

    /**
     * 
     */
    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * Construct CIF Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "cifAuthSignatoryVO.AUTH_CIF_NO", "cifAuthSignatoryVO.AUTH_NAME",
		    	     "cifAuthSignatoryVO.MANAGER_DESIGNATION",  "cifAuthSignatoryVO.ID_NO",
            		     "cifAuthSignatoryVO.STATUARY_MANAGER" , "cifAuthSignatoryVO.ADDRESS", "authSignCountryDesc", "authSignCountryOfAddressDesc"};
	    
	    
	    String[] colType = { "number",  "text", "text",
            		       "number", "text", "text", "text",
            		       "text"};
	    
	    
	    
	    String[] titles = { getText("CIF_No_key"), getText("Name_key"),
		    getText("Id_Type_key"), getText("ID_No_key"), getText("Nationality_key"), getText("Address_key"),getText("Country_key"),
		    getText("Country_Of_Address_key") };
	    
	    

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Authorized_signatory_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AuthSignatoriesLookup_fillAuthSignLookup");
	    
	    
	    
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    
	    int cols = name.length;

	    for(int i = 0; i < cols; i++)
	    {
		// Defining each column
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		// gridColumn.setIndex(name[i].split("\\.")[1]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		gridColumn.setSortable(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, criteria);
	    
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

  
    /**
     * Fill the lookup CIF data filtered by the defined criteria
     * 
     * @return
     */
    public String fillAuthSignLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    
	    // from billRegistration screen

		if(checkNbRec(criteria))
		{
		    setRecords(authSignatoriesBO.authSignatoriesListCount(criteria));
		}
		// set the collection into gridModel attribute defined at JSP grid
		setGridModel(authSignatoriesBO.authSignatoriesList(criteria));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    /**
     * @return the criteria
     */
    public AuthSignatoriesSC getCriteria()
    {
	return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(AuthSignatoriesSC criteria)
    {
	this.criteria = criteria;
    }

    public String getLookupCallingScreen()
    {
	return lookupCallingScreen;
    }

    public void setLookupCallingScreen(String lookupCallingScreen)
    {
	this.lookupCallingScreen = lookupCallingScreen;
    }
    public void setAuthSignatoriesBO(AuthSignatoriesBO authSignatoriesBO)
    {
        this.authSignatoriesBO = authSignatoriesBO;
    }


}
