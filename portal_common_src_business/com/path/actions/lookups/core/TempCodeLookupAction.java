package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.tempcode.TempCodeBO;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.tempcode.TempCodeSC;


public class TempCodeLookupAction extends LookupBaseAction{
	
	    private TempCodeBO tempCodeBO;
	    private TempCodeSC tempCodeSC = new TempCodeSC();

	    
		 @Override
		public Object getModel()
	     {
	         return tempCodeSC;
	     }	    
	    
	    public String constructLookup() 
	    {
		try
		{
		    // Design the Grid by defining the column model and column names
		    String[] name = { "TEMPLATE_CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ENG", "LONG_NAME_ARAB" };
		    String[] colType = { "number", "text", "text", "text", "text" };
		    String[] titles = { getText("Template_code"), getText("Short_name_eng_key"), getText("Short_Name_Arab_key"), 
			    getText("Long_Name_eng_key"),  getText("Long_Name_Arab_key") };
		    
		    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
		       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
			, 3= Arabic Visible and Mandatory English Not Mandatory). */
		    if(returnSessionObject().getHideArabicColumns())
		    {
			name = new String[] { "TEMPLATE_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
			colType = new String[]  { "number", "text", "text"};
			titles = new String[] { getText("Template_code"), getText("Short_name_eng_key"),  getText("Long_Name_eng_key") };
		    }

		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Lookup/Query__For_TempCode_key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/TempCodeLookup_fillTempCodeLookup");
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
		    lookup(grid, lsGridColumn, null, tempCodeSC);
		    */
		    lookup(grid,tempCodeSC,name,colType,titles);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}

		return SUCCESS;

	    }
	    public String fillTempCodeLookup()
	    {
		try
		{
		    List<TRSPAYPLANTMPLTVO> templateCodeVOList;
		    setSearchFilter(tempCodeSC);
		    copyproperties(tempCodeSC);
		    SessionCO sessionCO = returnSessionObject();
		    tempCodeSC.setCompCode(sessionCO.getCompanyCode());
		    tempCodeSC.setBranchCode(sessionCO.getBranchCode());
		    
		    if(checkNbRec(tempCodeSC))
		    {
			setRecords(tempCodeBO.tempCodeListCount(tempCodeSC));
		    }
		    templateCodeVOList = tempCodeBO.tempCodeList(tempCodeSC);
		    // set the collection into gridModel attribute defined at JSP grid
		    setGridModel(templateCodeVOList);

		}
		catch(Exception e)
		{
		    log.error(e, "Error in fillLookupData of TempCodeLookupAction");
		    handleException(e, null, null);
		}
		return SUCCESS;
	    }
	    public TempCodeSC getTempCodeSC()
	    {
		return tempCodeSC;
	    }

	    public void setTempCodeSC(TempCodeSC tempCodeSC)
	    {
		this.tempCodeSC = tempCodeSC;
	    }

	    public void setTempCodeBO(TempCodeBO tempCodeBO)
	    {
		this.tempCodeBO = tempCodeBO;
	    }

}
