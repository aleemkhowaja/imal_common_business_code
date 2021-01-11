package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.chequebookdesign.ChequeBookDesignBO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_DESIGNVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.chequebookdesign.ChequeBookDesignSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author CHADY ASSAF
 *
 *  ChequeBookDesignLookupAction.java used to load Design Lookup
 */
public class ChequeBookDesignLookupAction extends LookupBaseAction 
{
    private final ChequeBookDesignSC chequeBookDesignSC = new ChequeBookDesignSC();
    private ChequeBookDesignBO chequeBookDesignBO;

    @Override
    public Object getModel()
    {
	return chequeBookDesignSC;
    }

    /**
     * Construct Design Lookup
     * 
     * @return
     */
    public String constructLookup()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code__key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Code__key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("DesignList"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ChequeBookDesignLookup_fillLookupDesignByCompany");
	    lookup(grid, chequeBookDesignSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup Design data filtered by user.
     * 
     * @return
     * @throws BaseException
     */
    public String fillLookupDesignByCompany()
    {
	try
	{
	    List<CTSCHEQUEBOOK_DESIGNVO> designVOList;
	    setSearchFilter(chequeBookDesignSC);
	    copyproperties(chequeBookDesignSC);

	    SessionCO sessionCO = returnSessionObject();
	    chequeBookDesignSC.setUserId(sessionCO.getUserName());
	    chequeBookDesignSC.setCompCode(sessionCO.getCompanyCode());

	    if(getRecords() == 0)
	    {
		setRecords(chequeBookDesignBO.getDesignByCompanyCount(chequeBookDesignSC));
	    }
	    designVOList = chequeBookDesignBO.getDesignByCompanyList(chequeBookDesignSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(designVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setChequeBookDesignBO(ChequeBookDesignBO chequeBookDesignBO)
    {
	this.chequeBookDesignBO = chequeBookDesignBO;
    }
}
