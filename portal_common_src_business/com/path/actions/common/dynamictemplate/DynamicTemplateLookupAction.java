package com.path.actions.common.dynamictemplate;

import java.util.List;

import com.path.bo.common.dynamictemplate.DynamicTemplateBO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * DynamicTemplateListAction.java used to
 */
public class DynamicTemplateLookupAction extends LookupBaseAction
{
    private DynamicTemplateBO dynamicTemplateBO;
    private DynamicTemplateSC criteria = new DynamicTemplateSC();

    
    public Object getModel()
    {
	return criteria;
    }
    
    public DynamicTemplateSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(DynamicTemplateSC criteria)
    {
        this.criteria = criteria;
    }

    public void setDynamicTemplateBO(DynamicTemplateBO dynamicTemplateBO)
    {
        this.dynamicTemplateBO = dynamicTemplateBO;
    }
    
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = {"sysParamChrgTempScreensVO.SCREEN_ID", "sysParamChrgTempScreensVO.SCREEN_DESC"};
	    String[] colType = {"number", "text"};
	    String[] titles = {getText("ID_key"), getText("screenName_key")};

	    /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText(" "));
	    grid.setRowNum("5");
	    grid.setUrl("/path/dynamicTemplate/DynamicTemplateLookupAction_loadSysParamScreenChrgLookup");

	    List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
	    columnSpecs.get(0).setLeadZeros("6");

	    lookup(grid, columnSpecs, null, criteria);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * This method is to get data from BO and load them in a grid inside the
     * liveSearch component.
     * 
     * @return
     */
    public String loadSysParamScreenChrgLookup()
    {
	try
	{
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    //criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    if(checkNbRec(criteria))
	    {
		setRecords(dynamicTemplateBO.retSysParamScreenChrgListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(dynamicTemplateBO.retSysParamScreenChrgList(criteria));
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

}
