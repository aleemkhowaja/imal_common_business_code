package com.path.actions.lookups.core;

import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.core.itempropertydet.ItemPropertydetBO;
import com.path.dbmaps.vo.TRS_ITEM_PROPERTYDETVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.itempropertydet.ItemPropertydetSC;

@SuppressWarnings("serial")
public class ItemPropertydetLookupAction extends LookupBaseAction
{

    private ItemPropertydetSC criteria = new ItemPropertydetSC();
    private ItemPropertydetBO itemPropertydetBO;
    private List<TRS_ITEM_PROPERTYDETVO> trsItemPropertydetVOList;

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "PROPERTY_CODE", "LINE_NO", "PROPERTY_VALUE", "PROPERTY_VALUE_A" };
	    String[] colType = { "number", "number", "text", "text" };
	    String[] titles = { getText("Property_Code_key"), getText("Line_No_key"), getText("Property_Value_key"),
		    getText("Property_Value_A_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ItemPropertydetLookup_fillLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillLookup() throws JSONException
    {
	try
	{
	    if(NumberUtil.isEmptyDecimal(criteria.getPropertyCode()))
	    {
		return SUCCESS;
	    }
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    NumberUtil.resetEmptyValues(criteria);
	    if(criteria.getPropertyCode() == null)
	    {
		return SUCCESS;
	    }
	    if(checkNbRec(criteria))
	    {
		setRecords(itemPropertydetBO.itemPropertydetListCount(criteria));
	    }
	    trsItemPropertydetVOList = itemPropertydetBO.itemPropertydetList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trsItemPropertydetVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public ItemPropertydetSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(ItemPropertydetSC criteria)
    {
	this.criteria = criteria;
    }

    public void setItemPropertydetBO(ItemPropertydetBO itemPropertydetBO)
    {
	this.itemPropertydetBO = itemPropertydetBO;
    }

    @Override
    public Object getModel()
    {
	return criteria;

    }

}
