package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.core.iisitems.ItemsBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.iisitems.ItemsCO;
import com.path.vo.core.iisitems.ItemsSC;

public class ItemsLookupAction extends LookupBaseAction
{

    private ItemsSC itemsSC = new ItemsSC();
    private ItemsBO itemsBO;

    private BigDecimal itemCode;

    public String constructArRahnItemLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "trsitemsvo.CODE", "trsitemsvo.BRIEF_NAME_ENG" };

	    String[] colType = { "number", "text" };

	    String[] titles = { getText("code_key"), getText("desc_eng_key") };

	
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText(""));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ItemsLookup_fillArRahnItemLookup");

	    lookup(grid, itemsSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String fillArRahnItemLookup() throws JSONException
    {
	try
	{

	    setSearchFilter(itemsSC);
	    copyproperties(itemsSC);
	    SessionCO sessionCO = returnSessionObject();
	    itemsSC.setCompCode(sessionCO.getCompanyCode());

	    List<ItemsCO> itemsCOs = itemsBO.getArRahnItemLookup(itemsSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(itemsCOs);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);

	}
	return SUCCESS;
    }
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "trsitemsvo.CODE", "trsitemsvo.BRIEF_NAME_ENG", "trsitemscategoryvo.CODE",
		    "trsitemscategoryvo.BRIEF_NAME_ENG", "trsitemsvo.LONG_DESC_ENG", "trsitemsvo.BRIEF_DESC_ARAB",
		    "trsitemsvo.LONG_DESC_ARAB", "trsitemsvo.CREATED_BY", "trsitemsvo.DATE_CREATED",
		    "trsitemsvo.MODIFIED_BY", "trsitemsvo.DATE_MODIFIED", "trsitemsvo.PURCHASE_CY_CODE",
		    "currenciesvo.BRIEF_DESC_ENG", "trsitemsvo.PURCHASE_AMOUNT" };

	    String[] colType = { "number", "text", "number", "text", "text", "text", "text", "text", "date", "text",
		    "date", "number", "text", "number" };

	    String[] titles = { getText("Item_Code_key"), getText("Brief_Name_key"), getText("Item_Category_key"),
		    getText("Category_Brief_Name_key"), getText("Long_Name_key"),
		    getText("Category_Brief_Name_ar_key"), getText("Long_Name_ar_key"), getText("Created_By_key"),
		    getText("Date_Created_key"), getText("Modified_By_key"), getText("Date_Modified_key"),
		    getText("Purchase_Curr_Code_key"), getText("Purchase_Curr_key"), getText("Purchase_Amount_key"), };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText(""));
	    grid.setRowNum("5");
	    // grid.setUrl("/pathdesktop/iislookups/ItemsLookup_fillLookup");
	    grid.setUrl("/pathdesktop/ItemsLookup_fillLookup");
	    /*
	     * int cols = name.length;
	     * 
	     * for(int i = 0; i < cols; i++) { // Defining each column
	     * LookupGridColumn gridColumn = new LookupGridColumn();
	     * gridColumn.setName(name[i]); gridColumn.setIndex(name[i]);
	     * gridColumn.setColType(colType[i]);
	     * gridColumn.setTitle(titles[i]); gridColumn.setSearch(true); //
	     * adding column to the list lsGridColumn.add(gridColumn); }
	     * lookup(grid, lsGridColumn, null, itemsSC);
	     */
	    lookup(grid, itemsSC, name, colType, titles);
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

	    setSearchFilter(itemsSC);
	    copyproperties(itemsSC);
	    SessionCO sessionCO = returnSessionObject();
	    itemsSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(itemsSC))
	    {
		setRecords(itemsBO.getItemsLookupCount(itemsSC));
	    }

	    List<ItemsCO> itemsCOs = itemsBO.getItemsLookupDtls(itemsSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(itemsCOs);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);

	}
	return SUCCESS;
    }

    @Override
    public Object getModel()
    {
	return itemsSC;
    }

    public void setItemsSC(ItemsSC itemsSC)
    {
	this.itemsSC = itemsSC;
    }

    public ItemsSC getItemsSC()
    {
	return itemsSC;
    }

    public void setItemsBO(ItemsBO itemsBO)
    {
	this.itemsBO = itemsBO;
    }

    public void setItemCode(BigDecimal itemCode)
    {
	this.itemCode = itemCode;
    }

    public BigDecimal getItemCode()
    {
	return itemCode;
    }

}
