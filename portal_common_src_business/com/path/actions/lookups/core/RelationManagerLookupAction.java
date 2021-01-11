package com.path.actions.lookups.core;

import java.util.List;

import com.path.core.bo.transferentity.TransferEntityBO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.transferentity.TransferEntitySC;

public class RelationManagerLookupAction extends LookupBaseAction
{
    private TransferEntityBO transferEntityBO;
    private TransferEntitySC transferEntitySC = new TransferEntitySC();

 public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = {"userId","userDesc"};
	    String[] colType = { "text", "text"};
	    String[] titles = { getText("userId"), getText("Name_key")};
	    
	    /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText(" "));
	    grid.setRowNum("5");
	    grid.setUrl("/path/transferentity/RelationManagerLookupAction_loadRelationManagerLookup");

	    List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
	    columnSpecs.get(0).setLeadZeros("6");

	    lookup(grid, columnSpecs, null, transferEntitySC);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * This method is to get data from BO and load them in a grid inside the
     * liveSearch component.
     * 
     * @return
     */
    public String loadRelationManagerLookup()
    {
	try
	{
	    copyproperties(transferEntitySC);
	    SessionCO sessionCO = returnSessionObject();
	    transferEntitySC.setCompCode(sessionCO.getCompanyCode());
	    transferEntitySC.setLang(sessionCO.getLanguage());
	    if(checkNbRec(transferEntitySC))
	    {
		setRecords(transferEntityBO.retRelationManagerListCount(transferEntitySC));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(transferEntityBO.retRelationManagerList(transferEntitySC));
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }


    public Object getModel()
    {
	return transferEntitySC;
    }
	
	public TransferEntityBO getTransferEntityBO()
	{
		return transferEntityBO;
	}

	public void setTransferEntityBO(TransferEntityBO transferEntityBO)
	{
		this.transferEntityBO = transferEntityBO;
	}
	
	public TransferEntitySC getTransferEntitySC()
	{
		return transferEntitySC;
	}

	public void setTransferEntitySC(TransferEntitySC transferEntitySC)
	{
		this.transferEntitySC = transferEntitySC;
	}

}
