package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.vatcode.VatCodeBO;
import com.path.dbmaps.vo.TRSVATVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.vatcode.VatCodeSC;

public class VatCodeLookupAction extends LookupBaseAction
{

    private VatCodeBO vatCodeBO;
    private VatCodeSC vatCodeSC = new VatCodeSC();

    @Override
    public Object getModel()
    {
	return vatCodeSC;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "VAT_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Name_key"), getText("Long_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Code_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/VatCodeLookup_fillVatCodeLookup?vatCodeSC");
	    /*
	     * int cols = name.length;
	     * 
	     * for(int i = 0; i < cols; i++) { // Defining each column
	     * LookupGridColumn gridColumn = new LookupGridColumn();
	     * gridColumn.setName(name[i]); gridColumn.setIndex(name[i]);
	     * gridColumn.setColType(colType[i]);
	     * gridColumn.setTitle(titles[i]); gridColumn.setSearch(true); //
	     * adding column to the list lsGridColumn.add(gridColumn); }
	     * lookup(grid, lsGridColumn, null, vatCodeSC);
	     */
	    lookup(grid, vatCodeSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillVatCodeLookup()
    {
	try
	{
	    if(vatCodeSC == null)
	    {
		vatCodeSC = new VatCodeSC();
	    }
	    List<TRSVATVO> vatCodeVOList;
	    setSearchFilter(vatCodeSC);
	    copyproperties(vatCodeSC);
	    SessionCO sessionCO = returnSessionObject();
	    vatCodeSC.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(vatCodeSC))
	    {
		setRecords(vatCodeBO.vatCodeListCount(vatCodeSC));
	    }
	    vatCodeVOList = vatCodeBO.vatCodeList(vatCodeSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(vatCodeVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of VatCodeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public VatCodeSC getVatCodeSC()
    {
	return vatCodeSC;
    }

    public void setVatCodeSC(VatCodeSC vatCodeSC)
    {
	this.vatCodeSC = vatCodeSC;
    }

    public void setVatCodeBO(VatCodeBO vatCodeBO)
    {
	this.vatCodeBO = vatCodeBO;
    }

}
