package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.userlevel.UserLevelBO;
import com.path.dbmaps.vo.USR_LEVELVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.userlevel.UserLevelSC;

public class UserLevelLookupAction extends LookupBaseAction{
	
	
    private UserLevelBO userLevelBO;
    private UserLevelSC userLevelSC = new UserLevelSC();

    
	 @Override
	public Object getModel()
     {
         return userLevelSC;
     }	    

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = {"CODE","DESC_ENG","DESC_ARAB"};
	    String[] colType = {"number", "text", "text"};
	    String[] titles = {getText("Code_key"), 
		    getText("desc_eng_key"),  getText("Desc_Arb_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[]  {"CODE","DESC_ENG"};
		colType = new String[] {"number", "text"};
		titles = new String[] {getText("Code_key"), getText("desc_eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query__For_UserLevel_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/UserLevel_fillUserLevelLookup");
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
	    lookup(grid, lsGridColumn, null, userLevelSC);
	    */
	    lookup(grid,userLevelSC,name,colType,titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    /**
     * Fill the lookup for UserLevel data filtered by the defined criteria
     * 
     * @return
     */
    public String fillUserLevelLookup()
    {
	try
	{
	    List<USR_LEVELVO> userLevelVOList;
	    setSearchFilter(userLevelSC);
	    copyproperties(userLevelSC);
	    SessionCO sessionCO = returnSessionObject();
	    userLevelSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(userLevelSC))
	    {
	    setRecords(userLevelBO.userLevelListCount(userLevelSC));
	    }
	    userLevelVOList = userLevelBO.userLevelList(userLevelSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(userLevelVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of  UserLevelLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public UserLevelSC getUserLevelSC()
    {
	return userLevelSC;
    }

    public void setUserLevelSC(UserLevelSC userLevelSC)
    {
	this.userLevelSC = userLevelSC;
    }

    public void setUserLevelBO(UserLevelBO userLevelBO)
    {
	this.userLevelBO = userLevelBO;  
    }
}
