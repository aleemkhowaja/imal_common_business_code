package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.swiftinfo.SwiftInfoBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.swiftinfo.SwiftInfoSC;
import com.path.vo.core.trxmgnt.nonfininfo.SwiftInfoCO;

public class SwiftInfoLookupAction extends LookupBaseAction
{
  
    private SwiftInfoBO swiftInfoBO;
    private SwiftInfoSC swiftInfoSC = new SwiftInfoSC();


    @Override
    public Object getModel()
    {
	return swiftInfoSC;
    }

    
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "swiftInfoVO.SEND_TO_RECEIVER", "showTextDesc"};
	    String[] colType = { "text", "text"};
	    String[] titles = { getText("Send_To_Receiver_key"), getText("Show_Text_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Swift_Info_Details_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/SwiftInfoLookup_fillSwiftInfoLookup");
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
	    lookup(grid, lsGridColumn, null, swiftInfoSC);
	    */
	    lookup(grid,swiftInfoSC,name,colType,titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    public String fillSwiftInfoLookup()
    {
	try
	{
	    List<SwiftInfoCO> swiftInfoVOList;
	    setSearchFilter(swiftInfoSC);
	    copyproperties(swiftInfoSC);
	    SessionCO sessionCO = returnSessionObject();
	    swiftInfoSC.setCompCode(sessionCO.getCompanyCode());
	    swiftInfoSC.setPreferredLanguage( sessionCO.getLanguage());

	    if(checkNbRec(swiftInfoSC))
	    {
		setRecords(swiftInfoBO.returnSwiftInfoLookupCount(swiftInfoSC));
	    }
	    swiftInfoVOList = swiftInfoBO.returnSwiftInfoLookupData(swiftInfoSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(swiftInfoVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillSwiftInfoLookup of SwiftInfoLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public SwiftInfoSC getSwiftInfoSC()
    {
	return swiftInfoSC;
    }

    public void setSwiftInfoSC(SwiftInfoSC swiftInfoSC)
    {
	this.swiftInfoSC = swiftInfoSC;
    }

    public void setSwiftInfoBO(SwiftInfoBO swiftInfoBO)
    {
	this.swiftInfoBO = swiftInfoBO;
    }

}
