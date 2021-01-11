package com.path.actions.lookups.core;

import com.path.bo.core.clubbing.ClubbingBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.clubbing.ClubbingSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ClubbingLookupAction.java used to
 */
public class ClubbingLookupAction extends LookupBaseAction
{
	private ClubbingBO clubbingBO;
	private ClubbingSC criteria = new ClubbingSC();

	public String constructClubbingLookup()
	{
		try
		{
			String[] name = {"accClubGrpVO.CLUBBING_CODE", "accClubGrpVO.BRIEF_DESC_ENG", "accClubGrpVO.LONG_DESC_ENG", "accClubGrpVO.BRIEF_DESC_AR", "accClubGrpVO.LONG_DESC_AR"};
			String[] colType = {"number", "text", "text", "text", "text"};
			String[] titles = {getText("CLUB_CODE_key"), getText("BRIEF_DESC_ENG_key"), getText("LONG_DESC_ENG_key"), getText("BRIEF_DESC_AR_key"), getText("LONG_DESC_AR_key")};
			if(returnSessionObject().getHideArabicColumns())
			{
				name = new String[] {"accClubGrpVO.CLUB_CODE", "accClubGrpVO.BRIEF_DESC_ENG", "accClubGrpVO.LONG_DESC_ENG", "accClubGrpVO.BRIEF_DESC_AR", "accClubGrpVO.LONG_DESC_AR"};
				colType = new String[] {"number", "text", "text", "text", "text"};
				titles = new String[] {getText("CLUB_CODE_key"), getText("BRIEF_DESC_ENG_key"), getText("LONG_DESC_ENG_key"), getText("BRIEF_DESC_AR_key"), getText("LONG_DESC_AR_key")};
			}
			 // Defining the Grid
			LookupGrid grid = new LookupGrid();
			grid.setCaption(getText("Clubbing_key"));
			grid.setRowNum("5");
			grid.setUrl("/pathdesktop/clubbing/ClubbingLookupAction_fillClubbingLookup");

			lookup(grid, criteria, name, colType, titles);
		}
		catch(Exception e)
		{
			log.error(e, "Error in constructClubbingLookup of ClubbingLookupAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String fillClubbingLookup()
	{	
		try 
		{
			copyproperties(criteria);
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setBranchCode(sessionCO.getBranchCode());

			if(checkNbRec(criteria))
			{
				setRecords(clubbingBO.returnClubbingLookupCount(criteria));
			}
			setGridModel(clubbingBO.returnClubbingLookup(criteria));
		} 
		catch (Exception e) 
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	@Override
	public Object getModel()
	{
		return criteria;
	}
	public ClubbingSC getCriteria()
	{
		return criteria;
	}
	public void setCriteria(ClubbingSC criteria)
	{
		this.criteria = criteria;
	}
	public void setClubbingBO(ClubbingBO clubbingBO)
	{
		this.clubbingBO = clubbingBO;
	}
}
