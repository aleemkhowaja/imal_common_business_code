package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.rifcttgl.RifcttGlBO;
import com.path.dbmaps.vo.RIFCTT_GLVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.rifcttgl.RifcttGlSC;

public class RifcttGlLookupAction extends LookupBaseAction
{

    private RifcttGlSC criteria = new RifcttGlSC();
    private RifcttGlBO rifcttGlBO;

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
	    String[] name = { "TYPE_CODE", "CURRENCY_CODE", "GL_CODE", "SL_NO" };
	    String[] colType = { "number", "number", "number", "number" };
	    String[] titles = { getText("Type_Code_key"), getText("Currency_key"), getText("Gl_Code_key"),
		    getText("Sl_No_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/RifcttGlLookup_fillAccountLookup");
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
     * Fill the lookup RifcttGl data filtered by the defined criteria
     * 
     * @return
     */
    public String fillAccountLookup()
    {
	try
	{
	    List<RIFCTT_GLVO> rifcttGlVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCifTypeCode(criteria.getTypeCode());

	    if(checkNbRec(criteria))
	    {
		setRecords(rifcttGlBO.accountListCount(criteria));
	    }
	    rifcttGlVOList = rifcttGlBO.accountList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(rifcttGlVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillAccountLookup of RifcttGlLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * for business wise this lookup can be moved to another dedicated action
     * PB : dw_message_eng_comp
     * @return
     */
    public String rifMessageByCompLkp()
    {
	// Design the Grid by defining the column model and column names
	String[] name = { "MSG_CODE", "MSG_ENG", "MSG_ARAB"};
	String[] colType = { "number", "text", "text"};
	String[] titles = { getText("Code__key"), getText("message_key"), getText("message_arkey") };
	    
	try
	{

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Code__key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/RifcttGlLookup_fillRifMessageByCompLkp");
	    lookup(grid,criteria,name,colType,titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * Fill the lookup reason data filtered by the defined criteria
     * 
     * @return
     */
    public String fillRifMessageByCompLkp()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());

	    if(getRecords() == 0)
	    {
		setRecords(rifcttGlBO.getRifMessageByCompLkpCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(rifcttGlBO.getRifMessageByCompLkpList(criteria));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public RifcttGlSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(RifcttGlSC criteria)
    {
	this.criteria = criteria;
    }

    public void setRifcttGlBO(RifcttGlBO rifcttGlBO)
    {
	this.rifcttGlBO = rifcttGlBO;
    }

}
