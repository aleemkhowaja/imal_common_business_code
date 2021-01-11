package com.path.actions.lookups.core;

import com.path.bo.core.clubbing.ClubbingBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.clubbing.ClubbingSC;

public class ClubbedAccountsLookupAction extends LookupBaseAction
{
	private ClubbingBO clubbingBO;
	private ClubbingSC criteria = new ClubbingSC();

	public String constructClubbedAccLookup()
	{
		try
		{
			String[] name = {"ctsClubbedAccVO.CODE", "ctsClubbedAccVO.BRIEF_NAME_ENG", "ctsClubbedAccVO.LONG_NAME_ENG", "ctsClubbedAccVO.BRIEF_NAME_ARAB", "ctsClubbedAccVO.LONG_NAME_ARAB"};
			String[] colType = {"number", "text", "text", "text", "text"};
			String[] titles = {getText("CODE_key"), getText("BRIEF_NAME_ENG_key"), getText("LONG_NAME_ENG_key"), getText("BRIEF_NAME_ARAB_key"), getText("LONG_NAME_ARAB_key")};
			if(returnSessionObject().getHideArabicColumns())
			{
				name = new String[] {"ctsClubbedAccVO.CODE", "ctsClubbedAccVO.BRIEF_NAME_ENG", "ctsClubbedAccVO.LONG_NAME_ENG", "ctsClubbedAccVO.BRIEF_NAME_ARAB", "ctsClubbedAccVO.LONG_NAME_ARAB"};
				colType = new String[] {"number", "text", "text", "text", "text"};
				titles = new String[] {getText("CODE_key"), getText("BRIEF_NAME_ENG_key"), getText("LONG_NAME_ENG_key"), getText("BRIEF_NAME_ARAB_key"), getText("LONG_NAME_ARAB_key")};
			}
			 // Defining the Grid
			LookupGrid grid = new LookupGrid();
			grid.setCaption(getText("ClubbedAccounts_key"));
			grid.setRowNum("5");
			grid.setUrl("/pathdesktop/clubbing/ClubbedAccountsLookupAction_fillTaggedGrpsLookup");

			lookup(grid, criteria, name, colType, titles);
		}
		catch(Exception e)
		{
			log.error(e, "Error in constructClubbedAccLookup of ClubbedAccountsLookupAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String fillTaggedGrpsLookup()
	{	
		try 
		{
			copyproperties(criteria);
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());

			if(checkNbRec(criteria))
			{
				setRecords(clubbingBO.returnClubbedAccLookupCount(criteria));
			}
			setGridModel(clubbingBO.returnClubbedAccLookup(criteria));
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

	public ClubbingBO getClubbingBO()
	{
	    return clubbingBO;
	}

	public void setClubbingBO(ClubbingBO clubbingBO)
	{
	    this.clubbingBO = clubbingBO;
	}
}
