package com.path.actions.lookups.core;

import com.path.bo.core.educationnature.EducationNatureBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.educationnature.EducationNatureSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * EducationNatureLookupAction.java used to
 */
public class EducationNatureLookupAction extends LookupBaseAction
{
	private EducationNatureBO educationNatureBO;
	private EducationNatureSC criteria = new EducationNatureSC();

	public String constructEducationNatureLookup()
	{
		try
		{
			String[] name = {"CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB", "ADDITIONAL_REFERENCE"};
			String[] colType = {"number", "text", "text", "text", "text", "text"};
			String[] titles = {getText("Code_key"), getText("brief_Name_key"), getText("Brief_name_arb_key"), getText("long_name_key"), getText("Long_Name_Arab"), getText("Additional_Reference_key")};
			if(returnSessionObject().getHideArabicColumns())
			{
				name = new String[] {"CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB", "ADDITIONAL_REFERENCE"};
				colType = new String[] {"number", "text", "text", "text", "text", "text"};
				titles = new String[] {getText("CODE_key"), getText("BRIEF_DESC_ENG_key"), getText("BRIEF_DESC_ARAB_key"), getText("LONG_DESC_ENG_key"), getText("LONG_DESC_ARAB_key"), getText("ADDITIONAL_REFERENCE_key")};
			}
			 // Defining the Grid
			LookupGrid grid = new LookupGrid();
			grid.setCaption(getText("EducationNature_key"));
			grid.setRowNum("5");
			grid.setUrl("/pathdesktop/educationNature/EducationNatureLookupAction_fillEducationNatureLookup");

			lookup(grid, criteria, name, colType, titles);
		}
		catch(Exception e)
		{
			log.error(e, "Error in constructEducationNatureLookup of EducationNatureLookupAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String fillEducationNatureLookup()
	{	
		try 
		{
			copyproperties(criteria);
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setBranchCode(sessionCO.getBranchCode());

			if(checkNbRec(criteria))
			{
				setRecords(educationNatureBO.returnEducationNatureLookupCount(criteria));
			}
			setGridModel(educationNatureBO.returnEducationNatureLookup(criteria));
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
	public EducationNatureSC getCriteria()
	{
		return criteria;
	}
	public void setCriteria(EducationNatureSC criteria)
	{
		this.criteria = criteria;
	}
	public void setEducationNatureBO(EducationNatureBO educationNatureBO)
	{
		this.educationNatureBO = educationNatureBO;
	}
}
