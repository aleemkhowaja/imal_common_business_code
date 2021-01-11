package com.path.actions.lookups.core;

import java.util.HashMap;
import java.util.List;

import com.path.bo.admin.user.UsrBO;
import com.path.bo.common.ConstantsCommon;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.admin.user.UsrSC;
import com.path.vo.common.SessionCO;

public class UsrLookupAction extends LookupBaseAction{
	
	
    private UsrBO usrBO;
    private UsrSC usrSC = new UsrSC();

    
	 @Override
	public Object getModel()
     {
         return usrSC;
     }	    

    public String constructLookup()
    {
	try
	{
	    // / Design the Grid by defining the column model and column names
	    String[] name = { "USER_ID", "FIRST_NAME", "MIDDLE_NAME", "LAST_NAME", "USER_GRP_ID", "USER_GRP_DESC",
		    "USER_VALID_DT", "status_desc", "DATE_AUTHORIZED" };
	    String[] colType = { "text", "text", "text", "text", "text", "text", "date", "text", "date" };
	    String[] titles = { getText("userId"), getText("First_Name_eng_key"), getText("Middle_Name_eng_key"),
		    getText("Last_Name_eng_key"), getText("Group_ID_key"), getText("Group_Description_key"),
		    getText("User_Validity_Date_key"), getText("Status_key"), "" };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/UserLookup_fillUserLookup");
	  /*  int cols = name.length;

	    for(int i = 0; i < cols; i++)
	    {
		// Defining each column
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setHidden(hidden[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, usrSC);
	    */
	    List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(name, colType, titles);
	    lsGridColumn.get(8).setHidden(true);
	    lookup(grid, lsGridColumn, null, usrSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    /**
     * Fill the lookup for User data filtered by the defined criteria
     * 
     * @return
     */
    public String fillUserLookup()
    {
	try

	{

	    List<UsrCO> usrVOList;// TP#258985;roshin ;09/01/2014
	    HashMap<String, String> dateSearchCols = new HashMap<String, String>();
	    dateSearchCols.put("USER_VALID_DT", "USER_VALID_DT");
	    usrSC.setDateSearchCols(dateSearchCols);

	    setSearchFilter(usrSC);
	    copyproperties(usrSC);
	    SessionCO sessionCO = returnSessionObject();
	    usrSC.setCompCode(sessionCO.getCompanyCode());
	    // TP#258985;roshin ;09/01/2014
	    usrSC.setPreferredLanguage(sessionCO.getLanguage());
	    usrSC.setLovTypeId(ConstantsCommon.USER_STATUS_LOV_TYPE);

	    if(checkNbRec(usrSC))
	    {
	    setRecords(usrBO.getUserCountFor_w_lookup_user(usrSC));
	    }
	    usrVOList = usrBO.getUserListFor_w_lookup_user(usrSC);
	    setGridModel(usrVOList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of  UserLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Group ID lookup
     * 
     * @return
     */
    public String portletLookup()
    {
	try
	{
	    String[] name = { "USER_ID"};
	    String[] colType = { "text"};
	    String[] titles = { "USER ID"};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");

	    grid.setUrl("/pathdesktop/UsrLookupAction_fillPortletLookup?portletCode="
		    + usrSC.getPortletCode());
	    lookup(grid, usrSC, name, colType, titles);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillPortletLookup()
    {
	try
	{
	    usrSC.setUserListFlag(ConstantsCommon.ONE);
	    setSearchFilter(usrSC);
	    copyproperties(usrSC);

	    if(checkNbRec(usrSC))
	    {
		setRecords(usrBO.returnPortletUsersListCount(usrSC));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(usrBO.returnPortletUsersList(usrSC));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }   
    
	public UsrSC getUsrSC()
	{
		return usrSC;
	}

	public void setUsrSC(UsrSC usrSC)
	{
		this.usrSC = usrSC;
	}

	public void setUsrBO(UsrBO usrBO)
	{
		this.usrBO = usrBO;
	}
    

}
