package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.facilitytypeclass.FacilityTypeClassBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.facilitytypeclass.FacilityTypeClassSC;

public class FacilityTypeClassLookupAction extends LookupBaseAction
{
    private FacilityTypeClassSC facilityTypeClassSC = new FacilityTypeClassSC();
    private FacilityTypeClassBO facilityTypeClassBO;

    @Override
    public Object getModel()
    {
	return facilityTypeClassSC;
    }

    public String constructDrawDownTypeLookup()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "viewDrawDownClassVO.CODE", "viewDrawDownClassVO.CLASS",
		    "viewDrawDownClassVO.BRIEF_NAME_ENG", "viewDrawDownClassVO.LINE_NBR",
		    "viewDrawDownClassVO.FACILITY_VALUE", "viewDrawDownClassVO.DEAL_YIELD" };
	    String[] colType = { "number", "number", "text", "number", "number", "number" };
	    String[] titles = { getText("Facility_Code_key"), getText("product_class_key"), getText("Class_Key"),
		    getText("Line_Nbr_Key"), getText("Facilityvalue_key"), getText("Deal_Yeild_Key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("drawDowtype_Key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/FacilityTypeClassLookup_fillFromFacilityLookup");
	    int cols = name.length;
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    for(int i = 0; i < cols; i++)
	    {
		// Defining each column
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, facilityTypeClassSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillFromFacilityLookup() throws JSONException
    {
	try
	{
	    setSearchFilter(facilityTypeClassSC);
	    copyproperties(facilityTypeClassSC);
	    SessionCO sessionCO = returnSessionObject();
	    facilityTypeClassSC.setUserId(sessionCO.getUserName());
	    facilityTypeClassSC.setCompCode(sessionCO.getCompanyCode());
	    // TP#200950; Ajas.Abbas; Date 10/07/2014
	    if(NumberUtil.emptyDecimalToZero(facilityTypeClassSC.getBranchCode()).compareTo(BigDecimal.ZERO) == 0)
	    {
		facilityTypeClassSC.setBranchCode(sessionCO.getBranchCode());
	    }

	    facilityTypeClassSC.setLangCode(sessionCO.getLanguage());

	    if(getRecords() == 0)
	    {
		setRecords(facilityTypeClassBO.facilityTypeClassListCount(facilityTypeClassSC));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(facilityTypeClassBO.facilityTypeClassList(facilityTypeClassSC));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * TFA Facility Class Lookup construction
     * 
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_facility_class (tfa01.pbl)/ dw_lookup_facility_class
     *      (tfa01.pbl)
     * @return
     */
    public String constructDrawDownTypeLookupTFA()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "lineNbr", "generalFacilityType", "productClass", "briefNameClass", "classtype",
		    "briefNameDocType", "category", "briefNameCategory", "dealYield", "maturityDate", "facilityValue" };
	    String[] colType = { "number", "text", "number", "text", "number", "text", "number", "text", "number",
		    "date", "number" };
	    String[] titles = { getText("Line_No_key"), getText("Item_key"), getText("Product_Class_key"),
		    getText("Class_Desc_key"), getText("Type_key"), getText("Type_Desc_key"), getText("Category_key"),
		    getText("Category_Desc_key"), getText("Deal_Yield_key"), getText("Maturity_Date_key"),
		    getText("Facility_Value_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Facility_Class_Line_Nbr_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/FacilityTypeClassLookup_fillFromFacilityLookupTFA");

	    List<LookupGridColumn> trxGridColumn = returnStandarColSpecs(name, colType, titles);

	    trxGridColumn.get(0).setLeadZeros("3"); // lineNbr
	    trxGridColumn.get(2).setLeadZeros("4"); // productClass
	    trxGridColumn.get(4).setLeadZeros("4"); // classtype

	    lookup(grid, trxGridColumn, null, facilityTypeClassSC);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructDrawDownTypeLookupTFA of FacilityTypeClassLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * TFA Facility Class Lookup Filling
     * 
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_facility_class (tfa01.pbl)/ dw_lookup_facility_class
     *      (tfa01.pbl) generalFacilityType : docType : 'G' if LG, 'C' if LC,
     *      'N'/'U' if BC facilityCode : cif : facility facilityBr
     */
    public String fillFromFacilityLookupTFA()
    {
	try
	{
	    setSearchFilter(facilityTypeClassSC);
	    copyproperties(facilityTypeClassSC);
	    SessionCO sessionCO = returnSessionObject();
	    facilityTypeClassSC.setCompCode(sessionCO.getCompanyCode());
	    facilityTypeClassSC.setBranchCode(sessionCO.getBranchCode());
	    facilityTypeClassSC.setPreferredLanguage(sessionCO.getLanguage());
	    facilityTypeClassSC.setGeneralFacTypeLovType(ConstantsCommon.DOCUMENT_TYPE_LOV_TYPE);
	    facilityTypeClassSC.setAppType("F");

	    if(BigDecimal.ZERO.compareTo(NumberUtil.nullEmptyToValue(
		    NumberUtil.emptyDecimalToNull(facilityTypeClassSC.getFacilityBr()), BigDecimal.ZERO)) != 0)
	    {
		facilityTypeClassSC.setBranchCode(facilityTypeClassSC.getFacilityBr());
	    }

	    if(ConstantsCommon.NO.equals(StringUtil.nullToEmpty(facilityTypeClassSC.getClassType())))
	    {
		facilityTypeClassSC.setClassType("1");
	    }
	    else
	    {
		facilityTypeClassSC.setClassType("2");
	    }

	    if(ConstantsCommon.DOC_TYPE_EXPORT_LC.equals(facilityTypeClassSC.getFacilityType()))
	    {
		facilityTypeClassSC.setFacilityType("C");
	    }

	    if(checkNbRec(facilityTypeClassSC))
	    {
		setRecords(facilityTypeClassBO.facilityTypeClassTFAListCount(facilityTypeClassSC));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(facilityTypeClassBO.facilityTypeClassTFAList(facilityTypeClassSC));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public FacilityTypeClassSC getFacilityTypeClassSC()
    {
	return facilityTypeClassSC;
    }

    public void setFacilityTypeClassSC(FacilityTypeClassSC facilityTypeClassSC)
    {
	this.facilityTypeClassSC = facilityTypeClassSC;
    }

    public void setFacilityTypeClassBO(FacilityTypeClassBO facilityTypeClassBO)
    {
	this.facilityTypeClassBO = facilityTypeClassBO;
    }

}
