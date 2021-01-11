package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.blacklistsource.BlackSourceBO;
import com.path.dbmaps.vo.MOSBLACKSOURCEVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.core.bo.blacklistmanagement.blacklistintsource.BlackListIntSourceBO;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceSC;

public class BlackListSourceUploadLookupAction extends LookupBaseAction {
	
	private BlackListIntSourceBO blackListIntSourceBO;
	private BlackListIntSourceSC blackListInSourceSC = new BlackListIntSourceSC();
	

    @Override
    public Object getModel()
    {
    	return blackListInSourceSC;
    }
    
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "dfDataFileVO.FILE_CODE", "dfDataFileVO.FILE_DESC" };
	    String[] colType = { "text", "text" };
	    String[] titles = { getText("File_Code_key"), getText("File_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/BlackListSourceUploadLookup_loadLookupUploadFile");
	    lookup(grid, blackListInSourceSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of Enquiry File Lookup");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup branch data filtered by user.
     * 
     * @return
     */
    public String loadLookupUploadFile()
    {
	try
	{
	    String[] searchCol = { "dfDataFileVO.FILE_CODE", "dfDataFileVO.FILE_DESC" };
	    blackListInSourceSC.setSearchCols(searchCol);
	    SessionCO sessionCO = returnSessionObject();
	    setSearchFilter(blackListInSourceSC);
	    copyproperties(blackListInSourceSC);

	    if(getRecords() == 0)
	    {
		setRecords(blackListIntSourceBO.getDynFilesBlackListedListCount(blackListInSourceSC));
	    }

	    setGridModel(blackListIntSourceBO.getDynFilesBlackListedList(blackListInSourceSC));
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loading Enquiry File lookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


	public BlackListIntSourceSC getBlackListInSourceSC() {
		return blackListInSourceSC;
	}
	public void setBlackListInSourceSC(BlackListIntSourceSC blackListInSourceSC) {
		this.blackListInSourceSC = blackListInSourceSC;
	}
	public void setBlackListIntSourceBO(BlackListIntSourceBO blackListIntSourceBO) {
		this.blackListIntSourceBO = blackListIntSourceBO;
	}	
	
}
