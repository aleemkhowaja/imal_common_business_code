package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.avafile.AvaFileLkpBO;
import com.path.dbmaps.vo.CTS_AVA_FILEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.avafile.AvaFileLkpSC;

public class AvaFileLookupAction extends LookupBaseAction
{
    private AvaFileLkpBO avaFileLkpBO;
    private AvaFileLkpSC avaFileLkpSC = new AvaFileLkpSC();

    @Override
    public Object getModel()
    {
	return avaFileLkpSC;
    }

    public String constructFileLookup()
    {

	try
	{
	    // Types the Grid by defining the column model and column names
	    String[] name = { "CODE", "NAME" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("Code__key"), getText("Name_key") };

	
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("FileList"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AvaFileLookupAction_fillFileLkp");
	    lookup(grid, avaFileLkpSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Types data filtered by user.
     * 
     * @return
     * 
     */
    public String fillFileLkp()
    {
	try
	{
	    List<CTS_AVA_FILEVO> fileVOList;
	    String originOptRef = "";
	    setSearchFilter(avaFileLkpSC);
	    copyproperties(avaFileLkpSC);

	    SessionCO sessionCO = returnSessionObject();
	    avaFileLkpSC.setUserId(sessionCO.getUserName());
	    avaFileLkpSC.setCompCode(sessionCO.getCompanyCode());
	    
	    originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
	    if("AVAPAYMT".equals(originOptRef))
	    {
		avaFileLkpSC.setStatus("A");
	    }
	    
	    if(getRecords() == 0)
	    {
		setRecords(avaFileLkpBO.returnAvaFileLookupCount(avaFileLkpSC));
	    }
	    fileVOList = avaFileLkpBO.returnAvaFileLookupList(avaFileLkpSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(fileVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setAvaFileLkpBO(AvaFileLkpBO avaFileLkpBO)
    {
	this.avaFileLkpBO = avaFileLkpBO;
    }

    public AvaFileLkpSC getAvaFileLkpSC()
    {
	return avaFileLkpSC;
    }

    public void setAvaFileLkpSC(AvaFileLkpSC avaFileLkpSC)
    {
	this.avaFileLkpSC = avaFileLkpSC;
    }

}
