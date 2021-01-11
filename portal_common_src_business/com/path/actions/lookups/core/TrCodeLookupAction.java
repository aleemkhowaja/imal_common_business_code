package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.core.trtypes.TrTypesLookupBO;
import com.path.dbmaps.vo.TR_TYPESVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.trtypes.TrTypesSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: HanaaElJazzar
 * 
 *          TrCodeLookupAction.java used to construct lookup to retrieve the trx
 *          type "TR_Type" records.
 */
public class TrCodeLookupAction extends LookupBaseAction
{
    private TrTypesLookupBO trTypesLookupBO;
   

    private TrTypesSC trTypesSC = new TrTypesSC();
    private BigDecimal compCode;

    public Object getModel()
    {
	return trTypesSC;
    }

    /**
     * Construct Tr Types Code Lookup based on compCode only. w_lookup_trtype
     * 
     * @return String
     */
    public String constructTrCodeLookupByCompCode()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "TR_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("TR_Code"), getText("BRIEF_NAME_IN_ENG_key"), getText("brief_name_ar_key"),
		    getText("LONG_NAME_IN_ENG_key"), getText("long_name_ar_key") };

	    // Defining the Grid
	    LookupGrid lookGrid = new LookupGrid();
	    lookGrid.setCaption(getText("Transaction_Types_List"));
	    lookGrid.setUrl("/pathdesktop/TrCodeLookupAction_fillTrCodeLookupByCompCode");
	    lookGrid.setRowNum("5");
	  /*  int colsNb = name.length;

	    for(int k = 0; k < colsNb; k++)
	    {
		// Defining each column
		LookupGridColumn column = new LookupGridColumn();
		column.setTitle(titles[k]);
		column.setName(name[k]);
		column.setColType(colType[k]);
		column.setIndex(name[k]);
		column.setSearch(true);
		// adding column to the list
		lsGridColumn.add(column);
	    }
	    lookup(lookGrid, lsGridColumn, null, trTypesSC);
	    */
	    List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
	    columnSpecs.get(0).setLeadZeros("4");
	    lookup(lookGrid, columnSpecs, null, trTypesSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup TR_Types data filtered by the defined compCode
     * 
     * @return String
     * @throws JSONException
     */
    @SuppressWarnings("unchecked")
    public String fillTrCodeLookupByCompCode() throws JSONException
    {
	try
	{
	    List<TR_TYPESVO> trTypesVOList;
	    setSearchFilter(trTypesSC);
	    copyproperties(trTypesSC);
	    SessionCO sessionCO = returnSessionObject();

	    if(NumberUtil.isEmptyDecimal(trTypesSC.getCompCode()))
	    {
		trTypesSC.setCompCode(sessionCO.getCompanyCode());
	    }

	    if(checkNbRec(trTypesSC))
	    {
		setRecords(trTypesLookupBO.returnTrTypesListCount(trTypesSC));
	    }

	    trTypesVOList = (List<TR_TYPESVO>) trTypesLookupBO.returnTrTypesList(trTypesSC);

	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trTypesVOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @return the criteria
     */
    public TrTypesSC getTrTypesSC()
    {
	return trTypesSC;
    }

    /**
     * @param trTypesSC the criteria to set
     */
    public void setTrTypesSC(TrTypesSC trTypesSC)
    {
	this.trTypesSC = trTypesSC;
    }

    public void setTrTypesLookupBO(TrTypesLookupBO trTypesLookupBO)
    {
	this.trTypesLookupBO = trTypesLookupBO;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }
}
