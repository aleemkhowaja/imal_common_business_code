package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.trxfieldsname.TrxFieldsNameBO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.trxfieldsname.TrxFieldsNameSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * TrxFieldsNameLookupAction.java used to
 */
public class TrxFieldsNameLookupAction extends LookupBaseAction
{
    private TrxFieldsNameBO trxFieldsNameBO;
    private TrxFieldsNameSC criteria = new TrxFieldsNameSC();

    public String constructTrxFieldsNameLookup()
    {
	try
	{
	    String[] name = {"ctsTrxTypeSTDVO.LINE_NBR", "ctsTrxTypeSTDVO.FIELD_NAME", "elementName"};
	    String[] colType = {"number", "text", "text"};
	    String[] titles = {getText("line_nbr_key"), getText("fieldName"), getText("Element_Name_key")};

	    List<LookupGridColumn> listGridColumn = returnStandarColSpecs(name, colType, titles);
	    for(int i = 0; i < name.length; i++)
	    {
	    	if(!"ctsTrxTypeSTDVO.FIELD_NAME".equals(listGridColumn.get(i).getName()) && (!"ctsTrxTypeSTDVO.LINE_NBR".equals(listGridColumn.get(i).getName())) )
			{
			    listGridColumn.get(i).setHidden(true);
			}
	    }
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/TrxFieldsNameLookup_fillTrxFieldsNameLookup");
	    lookup(grid, listGridColumn, null, criteria);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructTrxFieldsNameLookup of TrxFieldsNameLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillTrxFieldsNameLookup()
    {
	try
	{
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());

	    if(checkNbRec(criteria))
	    {
		setRecords(trxFieldsNameBO.returnTrxFieldsNameLookupCount(criteria));
	    }
	    setGridModel(trxFieldsNameBO.returnTrxFieldsNameLookup(criteria));
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


    public void setTrxFieldsNameBO(TrxFieldsNameBO trxFieldsNameBO)
    {
        this.trxFieldsNameBO = trxFieldsNameBO;
    }

    public TrxFieldsNameSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(TrxFieldsNameSC criteria)
    {
        this.criteria = criteria;
    }
}
