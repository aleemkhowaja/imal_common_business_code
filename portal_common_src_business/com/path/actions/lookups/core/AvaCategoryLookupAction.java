package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.avacategory.AvaCategoryBO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.avacategory.AvaCategorySC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryLookupAction.java used to
 */
public class AvaCategoryLookupAction extends LookupBaseAction
{
    private AvaCategoryBO avaCategoryBO;
    private AvaCategorySC criteria = new AvaCategorySC();

    public String constructAvaCategoryLookup()
    {
	try
	{
	    String[] name = {"avaCategVO.CODE", "avaCategVO.AVA_TYPE", "avaTypeDesc", "avaCategVO.BRIEF_DESC_ENG", "avaCategVO.LONG_DESC_ENG",
		    "avaCategVO.BRIEF_DESC_ARAB",  "avaCategVO.LONG_DESC_ARAB" };
	    String[] colType = { "number", "text","text", "text", "text", "text", "text" };
	    String[] titles = { getText("CODE_key"), getText("AVA_TYPE_key"), getText("AVA_TYPE_key"),
		    getText("BRIEF_DESC_ENG_key"), getText("LONG_DESC_ENG_key"), getText("BRIEF_DESC_ARAB_key"),
		    getText("LONG_DESC_ARAB_key") };
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "avaCategVO.CODE", "avaCategVO.AVA_TYPE", "avaTypeDesc", "avaCategVO.BRIEF_DESC_ENG", "avaCategVO.LONG_DESC_ENG"};
		colType = new String[] { "number", "text", "text", "text", "text" };
		titles = new String[] {getText("CODE_key"), getText("AVA_TYPE_key"), getText("AVA_TYPE_key"),
			getText("BRIEF_DESC_ENG_key"), getText("LONG_DESC_ENG_key") };
	    }
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("AvaCategory_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/avaCategory/AvaCategoryLookupAction_fillAvaCategoryLookup");
	    
	    List<LookupGridColumn> lgGridColumn = returnStandarColSpecs(name, colType, titles);
	    for(int i = 0; i < name.length; i++)
            {
                if("avaCategVO.AVA_TYPE".equals(lgGridColumn.get(i).getName()))
                {
                    lgGridColumn.get(i).setHidden(true);
                }
            }

	    lookup(grid, lgGridColumn, null, criteria);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructAvaCategoryLookup of AvaCategoryLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillAvaCategoryLookup()
    {
	try
	{
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setLovTypeId(BigDecimal.valueOf(718));
	    criteria.setLanguage(sessionCO.getLanguage());

	    if(checkNbRec(criteria))
	    {
		setRecords(avaCategoryBO.returnAvaCategoryLookupCount(criteria));
	    }
	    setGridModel(avaCategoryBO.returnAvaCategoryLookup(criteria));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public Object getModel()
    {
	return criteria;
    }

    public AvaCategorySC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(AvaCategorySC criteria)
    {
	this.criteria = criteria;
    }

    public void setAvaCategoryBO(AvaCategoryBO avaCategoryBO)
    {
	this.avaCategoryBO = avaCategoryBO;
    }
}
