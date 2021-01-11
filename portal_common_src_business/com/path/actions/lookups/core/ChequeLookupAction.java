/**
 * @Auther: Chady Assaf
 * @Date:Apr 17, 2012
 * @Team:CSM Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.cheque.ChequeBO;
import com.path.dbmaps.vo.CTSCHEQUESVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cheque.ChequeSC;


public class ChequeLookupAction extends LookupBaseAction
{
    private ChequeSC criteria = new ChequeSC();
    private List<CTSCHEQUESVO> chequeVOList;
    private ChequeBO chequeBO;

    public Object getModel()
    {
	return criteria;
    }
    
    /**
     * Build a Grid inside the LiveSearch ...
     */
    public String drawingChequeGrid()
    {
	try
	{
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB" };
	    String[] colType = { "number", "text", "text", "text" };
	    String[] titles  = { getText("cheque_code_key"), getText("Brief_Desc_Eng_key"),getText("Long_Desc_Eng_key"), getText("Brief_Desc_Arab_key")};
		    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
		1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		,3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("cheque_code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key") };
	    }
	    /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cheque_code_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ChequeLookupAction_loadChequeLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "drawingChequeGrid";
    }

    /**
     * This method is to get data from BO and load them in a grid inside the liveSearch component. 
     * @return
     */
    public String loadChequeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    setRecords(chequeBO.chequesLkpCount(criteria));
	    chequeVOList = chequeBO.chequesLkpRecords(criteria);
	    setGridModel(chequeVOList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public ChequeSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(ChequeSC criteria)
    {
	this.criteria = criteria;
    }

    public void setChequeBO(ChequeBO chequeBO)
    {
	this.chequeBO = chequeBO;
    }

    public List<CTSCHEQUESVO> getChequeVOList()
    {
	return chequeVOList;
    }

    public void setChequeVOList(List<CTSCHEQUESVO> chequeVOList)
    {
	this.chequeVOList = chequeVOList;
    }

}
