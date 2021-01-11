package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.chequebookleaves.ChequeBookLeavesBO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_LEAVESVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.chequebookleaves.ChequeBookLeavesSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author CHADY ASSAF
 * 
 *         ChequeBookLeavesLookupAction.java used to load Leaves Lookup
 */
public class ChequeBookLeavesLookupAction extends LookupBaseAction
{
    private ChequeBookLeavesSC chequeBookLeavesSC = new ChequeBookLeavesSC();
    private List<CTSCHEQUEBOOK_LEAVESVO> leavesVOList;
    CTSCHEQUEBOOK_LEAVESVO temp;
    private ChequeBookLeavesBO chequeBookLeavesBO;

    @Override
    public Object getModel()
    {
	return chequeBookLeavesSC;
    }

    /**
     * Construct Leaves Lookup
     * 
     * @return
     */
    public String constructLookup()
    {

	try
	{
	    // Leaves the Grid by defining the column model and column names
	    String[] name = { "CODE", "NO_LEAVES", "DESC_ENG", "DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text" };
	    String[] titles = { getText("Code__key"), getText("no_leaves_key"), getText("desc_eng_key"), getText("desc_arab_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "NO_LEAVES", "DESC_ENG"};
		colType = new String[] { "number", "text", "text"};
		titles = new String[] { getText("Code__key"), getText("no_leaves_key"), getText("desc_eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("LeavesList"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ChequeBookLeavesLookup_fillLookupLeavesByCompany");
	    lookup(grid, chequeBookLeavesSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Leaves data filtered by user.
     * 
     * @return
     */
    public String fillLookupLeavesByCompany()
    {
	try
	{
	    setSearchFilter(chequeBookLeavesSC);
	    copyproperties(chequeBookLeavesSC);

	    SessionCO sessionCO = returnSessionObject();
	    chequeBookLeavesSC.setUserId(sessionCO.getUserName());
	    chequeBookLeavesSC.setCompCode(sessionCO.getCompanyCode());

	    if(getRecords() == 0)
	    {
		setRecords(chequeBookLeavesBO.getLeavesByCompanyCount(chequeBookLeavesSC));
	    }
	    leavesVOList = chequeBookLeavesBO.getLeavesByCompanyList(chequeBookLeavesSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(leavesVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public ChequeBookLeavesSC getChequeBookLeavesSC()
    {
	return chequeBookLeavesSC;
    }

    public void setChequeBookLeavesSC(ChequeBookLeavesSC chequeBookLeavesSC)
    {
	this.chequeBookLeavesSC = chequeBookLeavesSC;
    }

    public List<CTSCHEQUEBOOK_LEAVESVO> getLeavesVOList()
    {
	return leavesVOList;
    }

    public void setLeavesVOList(List<CTSCHEQUEBOOK_LEAVESVO> leavesVOList)
    {
	this.leavesVOList = leavesVOList;
    }

    public void setChequeBookLeavesBO(ChequeBookLeavesBO chequeBookLeavesBO)
    {
	this.chequeBookLeavesBO = chequeBookLeavesBO;
    }

}
