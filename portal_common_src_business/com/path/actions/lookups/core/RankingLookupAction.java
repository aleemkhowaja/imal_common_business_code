package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.ranking.RankingBO;
import com.path.dbmaps.vo.RIFPCTVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ranking.RankingSC;

public class RankingLookupAction extends LookupBaseAction
{
    
    private RankingSC rankingSC = new RankingSC();
    private RankingBO rankingBO;


    @Override
    public Object getModel()
    {
	return rankingSC;
    }

    /**
     * Construct Ranking status Lookup based on the VO returned in the
     * resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "PRIORITY_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
		    getText("Long_Desc_Eng_key"), getText("Long_Desc_Arab_key") };
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "PRIORITY_CODE", "BRIEF_DESC_ENG","LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("legal_status_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Ranking_fillRankingLookup");
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
	    }*/
	    lookup(grid,rankingSC,name,colType,titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for Ranking data filtered by the defined criteria
     * 
     * @return
     */
    public String fillRankingLookup()
    {
	try
	{
	    List<RIFPCTVO> rankingVOList;
	    setSearchFilter(rankingSC);
	    copyproperties(rankingSC);
	    SessionCO sessionCO = returnSessionObject();
	    rankingSC.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(rankingSC))
	    {
		setRecords(rankingBO.rankingListCount(rankingSC));
	    }
	    rankingVOList = rankingBO.rankingList(rankingSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(rankingVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of RankingLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public RankingSC getRankingSC()
    {
	return rankingSC;
    }

    public void setRankingSC(RankingSC rankingSC)
    {
	this.rankingSC = rankingSC;
    }

    public void setRankingBO(RankingBO rankingBO)
    {
	this.rankingBO = rankingBO;
    }

}
