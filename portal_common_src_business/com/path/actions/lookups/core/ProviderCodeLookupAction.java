package com.path.actions.lookups.core;

import com.path.bo.core.provider.ProviderBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;

public class ProviderCodeLookupAction extends LookupBaseAction
{
    private ProviderBO providerBO;
    private GridParamsSC criteria = new GridParamsSC();

	public String constructProviderLookup()
	{
		try
		{
			String[] name = {"CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ENG", "LONG_NAME_ARAB"};
			String[] colType = {"number", "text", "text", "text", "text"};
			String[] titles = {getText("Code_key"), getText("brief_Name_key"), getText("Brief_name_arb_key"), getText("long_name_key"), getText("Long_Name_Arab")};
			if(returnSessionObject().getHideArabicColumns())
			{
				name = new String[] {"CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG"};
				colType = new String[] {"number", "text", "text"};
				titles = new String[] {getText("Code_key"), getText("brief_Name_key"), getText("long_name_key")};
			}
			 // Defining the Grid
			LookupGrid grid = new LookupGrid();
			grid.setCaption(getText("provider_key"));
			grid.setRowNum("5");
			grid.setUrl("/pathdesktop/ProviderCodeLookupAction_fillProviderLookup");

			lookup(grid, criteria, name, colType, titles);
		}
		catch(Exception e)
		{
			log.error(e, "Error in constructEducationNatureLookup of EducationNatureLookupAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String fillProviderLookup()
	{	
		try 
		{
			copyproperties(criteria);
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setBranchCode(sessionCO.getBranchCode());

			if(checkNbRec(criteria))
			{
				setRecords(providerBO.returnProviderLookupCount(criteria));
			}
			setGridModel(providerBO.returnProviderLookup(criteria));
		} 
		catch (Exception e) 
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public Object getModel()
	{
		return criteria;
	}

	public void setProviderBO(ProviderBO providerBO)
	{
	    this.providerBO = providerBO;
	}
	
}
