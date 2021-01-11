/**
 * 
 */
package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.lostfound.LostFoundBO;
import com.path.dbmaps.vo.CTS_LOSTDOCVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.lostfound.LostFoundSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          LostFoundLookupAction.java used to
 */
public class LostFoundLookupAction extends LookupBaseAction
{
    
    private LostFoundBO lostFoundBO;
    private LostFoundSC criteria = new LostFoundSC();
    private List<CTS_LOSTDOCVO> ctsLostDocVOList;

    public Object getModel()
    {
	return criteria;
    }

    /**
     * Build a Grid inside the LiveSearch ...
     */
    public String drawingDocTypeGrid()
    {
	try
	{
	    String[] name = {"DOC_CODE","BRIEF_DESC_ENG","BRIEF_DESC_ARAB"};
	    String[] colType = {"number","text", "text"};
	  /*  Boolean[] hidden = {false,false, false};*/
	    String[] titles = {getText("Document_Code_key"), getText("Lkp_Document_Desc_En_key"), getText("Lkp_Document_Desc_Ar_key")};
	     /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lkp_Document_Type_Caption_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/LostFoundLookup_loadDocTypeLookup");
	    lookup(grid, criteria, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }

    /**
     * This method is to get data from BO and load them in a grid inside the
     * liveSearch component.
     * 
     * @return
     */
    public String loadDocTypeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    setRecords(lostFoundBO.docTypeLookupCount(criteria));
	    ctsLostDocVOList = lostFoundBO.docTypeLookupList(criteria);
	    setGridModel(ctsLostDocVOList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public void setLostFoundBO(LostFoundBO lostFoundBO)
    {
	this.lostFoundBO = lostFoundBO;
    }

   

    public LostFoundSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(LostFoundSC criteria)
    {
        this.criteria = criteria;
    }

    public List<CTS_LOSTDOCVO> getCtsLostDocVOList()
    {
        return ctsLostDocVOList;
    }

    public void setCtsLostDocVOList(List<CTS_LOSTDOCVO> ctsLostDocVOList)
    {
        this.ctsLostDocVOList = ctsLostDocVOList;
    }

}
