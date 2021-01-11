package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.todotemplate.ToDoTemplateBO;
import com.path.dbmaps.vo.S_TODO_TEMPLATE_HDRVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.todotemplate.ToDoTemplateSC;

public class ToDoTemplateLookupAction extends LookupBaseAction
{
    
    private ToDoTemplateBO toDoTemplateBO;
    private ToDoTemplateSC toDoTemplateSC = new ToDoTemplateSC();


	 @Override
	public Object getModel()
     {
         return toDoTemplateSC;
     }	    
	 
    /**
     * Construct ToDoTemplate Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "TODO_TEMPLATE","COMP_CODE","BRANCH_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB" };
	    String[] colType = { "number", "number", "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Company_key"), getText("Branch_key"), 
		    getText("Short_name_eng_key"),  getText("Long_Name_eng_key"),getText("Short_Name_Arab_key"),  getText("Long_Name_Arab_key") };
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[]  { "TODO_TEMPLATE","COMP_CODE","BRANCH_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG"};
		colType = new String[]  { "number", "number", "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Company_key"), getText("Branch_key"), 
			    getText("Short_name_eng_key"),  getText("Long_Name_eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_For_ToDO_Template_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ToDoTemplate_fillToDoTemplateLookup");
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
	    lookup(grid, lsGridColumn, null, toDoTemplateSC);
	    */
	    lookup(grid,toDoTemplateSC,name,colType,titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for ToDoTemplate data filtered by the defined criteria
     * 
     * @return
     */
    public String fillToDoTemplateLookup()
    {
	try
	{
	    List<S_TODO_TEMPLATE_HDRVO> toDoTemplateVOList;
	    setSearchFilter(toDoTemplateSC);
	    copyproperties(toDoTemplateSC);
	    SessionCO sessionCO = returnSessionObject();
	    toDoTemplateSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(toDoTemplateSC))
	    {
	    setRecords(toDoTemplateBO.toDoTemplateListCount(toDoTemplateSC));
	    }
	    toDoTemplateVOList = toDoTemplateBO.toDoTemplateList(toDoTemplateSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(toDoTemplateVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of ToDoTemplateLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public ToDoTemplateSC getToDoTemplateSC()
    {
	return toDoTemplateSC;
    }

    public void setToDoTemplateSC(ToDoTemplateSC toDoTemplateSC)
    {
	this.toDoTemplateSC = toDoTemplateSC;
    }

    public void setToDoTemplateBO(ToDoTemplateBO toDoTemplateBO)
    {
	this.toDoTemplateBO = toDoTemplateBO;
    }

}
