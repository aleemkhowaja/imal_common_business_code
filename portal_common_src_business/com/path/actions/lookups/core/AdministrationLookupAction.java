package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.administration.AdministrationBO;
import com.path.dbmaps.vo.CTSADMINISTRATIONVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.administration.AdministrationSC;

@SuppressWarnings("serial")
public final class AdministrationLookupAction extends LookupBaseAction
{
    private AdministrationSC criteria = new AdministrationSC();
    private AdministrationBO administrationBO;
    private List<CTSADMINISTRATIONVO> administrationVOList;
    private BigDecimal administrationCode;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public String drawAdministrationGrid()
    {
	try
	{
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Code__key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AdministrationLookup_loadAdministrationLookup");
	    final String columnName[] = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB" };
	    final String columnType[] = { "number", "text", "text" };
	    final String columnTitle[] = { getText("Code__key"), getText("Brief_Name_eng_key"),
		    getText("Brief_Name_Arab_key") };
	    List<LookupGridColumn> gridColumnList = returnStandarColSpecs(columnName, columnType, columnTitle);
	    lookup(grid, gridColumnList, null, criteria);
	}
	catch(Exception e)
	{
	    StringBuilder strBldr = new StringBuilder();
	    strBldr.append("Error message '");
	    strBldr.append(e.getMessage());
	    strBldr.append("; Cause: '");
	    strBldr.append(e.getCause());
	    strBldr.append("'; Class: '");
	    strBldr.append(this.getClass());
	    strBldr.append("'; Method: '");
	    strBldr.append("drawAdministrationGrid'.");
	    strBldr.trimToSize();
	    log.error(strBldr.toString());
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String loadAdministrationLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    setRecords(Integer.valueOf(administrationBO.administrationLookupCount(criteria)));
	    administrationVOList = administrationBO.administrationLookupList(criteria);
	    setGridModel(administrationVOList);
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setAdministrationBO(AdministrationBO obj)
    {
	administrationBO = obj;
    }

    public BigDecimal getAdministrationCode()
    {
	return administrationCode;
    }

    public void setAdministrationCode(BigDecimal obj)
    {
	administrationCode = obj;
    }

    public List<CTSADMINISTRATIONVO> getAdministrationVOList()
    {
	return administrationVOList;
    }

    public void setAdministrationVOList(List<CTSADMINISTRATIONVO> obj)
    {
	administrationVOList = obj;
    }

    public AdministrationSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(AdministrationSC obj)
    {
	criteria = obj;
    }
}
