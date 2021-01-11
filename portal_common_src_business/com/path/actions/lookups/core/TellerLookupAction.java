package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.teller.TellerBO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTELLER_ALLOWED_USERSVOKey;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.teller.TellerCO;
import com.path.vo.core.teller.TellerSC;

public class TellerLookupAction extends LookupBaseAction
{
   
    private final TellerSC tellerSC = new TellerSC();
    private TellerBO tellerBO;

    @Override
    public Object getModel()
    {
	return tellerSC;

    }

    /**
     * Construct vault Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */
    public String constructLookup()
    {

	try
	{
	    if("L0PT".equals(tellerSC.getTransferCashReference()) && "1".equals(tellerSC.getAllowHeadTelleAccessATM()) )
	    {// and condition from partial transfer
	     // Design the Grid by defining the column model and column names

		String[] nameUSer = { "CODE", "USER_ID", "LONG_NAME_ARAB" };
		String[] colTypeUser = { "text", "text", "text" };
		String[] titlesUser = { getText("User_Code_key"), getText("User_Id_key"), getText("Long_Name_key") };
		if(returnSessionObject().getHideArabicColumns())
		{
		    nameUSer = new String[] { "CODE", "USER_ID", "LONG_NAME_ENG" };
		    colTypeUser = new String[] { "text", "text", "text" };
		    titlesUser = new String[] { getText("User_Code_key"), getText("User_Id_key"),
			    getText("Long_Name_key") };
		}

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("tellerLookup.teller"));
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/TellerLookup_populateATmUsersLookup");
		lookup(grid, tellerSC, nameUSer, colTypeUser, titlesUser);

	    }else{
		 // Design the Grid by defining the column model and column names
		    String[] name = { "CODE", "USER_ID", "TELLER_TYPE", "PRIVILEGE_LEVEL", "DIVISION_CODE", "DEPT_CODE",
			    "ROLE_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "STATUS", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB" };
		    String[] colType = { "text", "text", "text", "text", "text", "text", "text", "text", "text", "text",
			    "text", "text" };
		    String[] titles = { getText("User_Code_key"), getText("User_Id_key"), getText("User_Type_key"),
			    getText("Privilege_Level_key"), getText("Division_Code_key"), getText("Dept_Code_key"),
			    getText("Role_Code_key"), getText("brief_Name_key"), getText("Long_Name_key"),
			    getText("status_key"), getText("arabic1"), getText("arabic2") };
		    
		    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
		       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
			, 3= Arabic Visible and Mandatory English Not Mandatory). */
		    if(returnSessionObject().getHideArabicColumns())
		    {
			name = new String[] { "CODE", "USER_ID", "TELLER_TYPE", "PRIVILEGE_LEVEL", "DIVISION_CODE", "DEPT_CODE",
				    "ROLE_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "STATUS"};
			colType = new String[]{ "text", "text", "text", "text", "text", "text", "text", "text", "text", "text"};
			titles = new String[] { getText("User_Code_key"), getText("User_Id_key"), getText("User_Type_key"),
				    getText("Privilege_Level_key"), getText("Division_Code_key"), getText("Dept_Code_key"),
				    getText("Role_Code_key"), getText("brief_Name_key"), getText("Long_Name_key"), getText("status_key")};
		    }

		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("tellerLookup.teller"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/TellerLookup_populateTellerLookup");
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
		    lookup(grid, lsGridColumn, null, null);
		    */
		    lookup(grid,tellerSC,name,colType,titles);
	    }
	   
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * Fill the lookup vault data filtered by the defined criteria
     * 
     * @return
     */
    public String populateTellerLookup()
    {
	try
	{
	    setSearchFilter(tellerSC);
	    copyproperties(tellerSC);
	    SessionCO sessionCO = returnSessionObject();
	    tellerSC.setCompCode(sessionCO.getCompanyCode());
	    tellerSC.setBranchCode(sessionCO.getBranchCode());
	    tellerSC.setStatus("T");
	    tellerSC.setPrivilegeLevel(BigDecimal.ZERO);
	    //Hasan Bug#620580 22/02/2018
	    if(!StringUtil.isNotEmpty(tellerSC.getTellerType()))
	    {
		tellerSC.setTellerType("T");
	    }

	    if(getRecords() == 0)
	    {
		setRecords(tellerBO.returnTellerLookupCount(tellerSC));
	    }
	    List<CTSTELLERVO> ctstellervos = tellerBO.returnTellerLookupData(tellerSC);
	    setGridModel(ctstellervos);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of VaultLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    /**
     * 
     * @return
     */
    public String constructRepresentiveLookup()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "ctsTellerDetVO.SUB_TELLER_CODE",  "ctsTellerDetVO.USER_ID"  };
	    String[] colType = { "number" , "text" };
	    String[] titles = { getText("code_key") ,  getText("User_Id_key")};
	    
	 

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("tellerLookup.teller"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/TellerLookup_populateRepresentiveLookup");
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
	    lookup(grid, lsGridColumn, null, null);
	    */
	    lookup(grid,tellerSC,name,colType,titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }    	 

     
    
    /**
     * Fill the lookup vault data filtered by the defined criteria
     * 
     * @return
     */
    public String populateRepresentiveLookup()
    {
	try
	{
	    setSearchFilter(tellerSC);
	    copyproperties(tellerSC);
	    SessionCO sessionCO = returnSessionObject();
	    tellerSC.setCompCode(sessionCO.getCompanyCode());
	    tellerSC.setBranchCode(sessionCO.getBranchCode());
	   
	    // get logged in user ( Model.B)
	    tellerSC.setLoggedInUserCode(sessionCO.getCtsTellerVO().getCODE());

	    if(getRecords() == 0)
	    {
	    	setRecords(tellerBO.returnRepresentiveLookupCount(tellerSC));
	    }
	    List<TellerCO> ctstellerdetvos = tellerBO.returnRepresentiveLookupData(tellerSC);
	    setGridModel(ctstellerdetvos);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of VaultLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public String populateATmUsersLookup()
    {
	try
	{
	    setSearchFilter(tellerSC);
	    copyproperties(tellerSC);
	    SessionCO sessionCO = returnSessionObject();
	    tellerSC.setCompCode(sessionCO.getCompanyCode());
	    tellerSC.setBranchCode(sessionCO.getBranchCode());
	    tellerSC.setTellerCode(sessionCO.getCtsTellerVO().getCODE());

	    if(getRecords() == 0)
	    {
		setRecords(tellerBO.returnATMUsersLookupCount(tellerSC));
	    }
	    List<CTSTELLER_ALLOWED_USERSVOKey> ctstellervos = tellerBO.returnATMUsersLookupData(tellerSC);
	    setGridModel(ctstellervos);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of VaultLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setTellerBO(TellerBO tellerBO)
    {
	this.tellerBO = tellerBO;
    }

}

