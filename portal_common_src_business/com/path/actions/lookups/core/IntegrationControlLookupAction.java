package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.integrationcontrol.IntegrationControlBO;
import com.path.dbmaps.vo.CTS_INTEG_PARAMVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.integrationcontrol.IntegrationControlSC;


public class IntegrationControlLookupAction extends LookupBaseAction
{
    
    private IntegrationControlBO integrationControlBO;
    private IntegrationControlSC integrationControlSC = new IntegrationControlSC();
  
	 @Override
	public Object getModel()
     {
         return integrationControlSC;
     }	    
    


    /**
     * Construct IntegrationControl Lookup based on the VO returned in the resultMap.
     * @PB w_lookup_integration_control
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "TYPE_CODE","BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
	    String[] colType = { "number","text", "text", "text", "text" };
	    String[] titles = {getText("Type_Code_key"),getText("Brief_Desc_Eng_key"), 
		      getText("Long_Desc_Eng_key"),getText("Brief_Desc_Arab_key"),  getText("Long_Desc_Arab_key") };



	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "TYPE_CODE","BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number","text", "text"};
		titles = new String[] {getText("Type_Code_key"),getText("Brief_Desc_Eng_key"),  getText("Long_Desc_Eng_key") };
	    }
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query__For_IntegrationControl_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/IntegrationControl_fillItegrationControlLookup");
	    lookup(grid, integrationControlSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for IntegrationControl data filtered by the defined criteria
     * 
     * @return
     */
    public String fillItegrationControlLookup()
    {
	try
	{
	    List<CTS_INTEG_PARAMVO> integrationControlVOList;
	    setSearchFilter(integrationControlSC);
	    copyproperties(integrationControlSC);
	    SessionCO sessionCO = returnSessionObject();
	    integrationControlSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(integrationControlSC))
	    {
	    setRecords(integrationControlBO.integrationControlListCount(integrationControlSC));
	    }
	    integrationControlVOList = integrationControlBO.integrationControlList(integrationControlSC);	   
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(integrationControlVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of IntegrationControlLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public IntegrationControlSC getIntegrationControlSC()
    {
	return integrationControlSC;
    }

    public void setIntegrationControlSC(IntegrationControlSC integrationControlSC)
    {
	this.integrationControlSC = integrationControlSC;
    }

    public void setIntegrationControlBO(IntegrationControlBO integrationControlBO)
    {
	this.integrationControlBO = integrationControlBO;
    }

}
