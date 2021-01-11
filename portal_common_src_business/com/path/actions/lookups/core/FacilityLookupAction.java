/**
 * 
 */
package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.facilitytype.FacilityTypeBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.facilitytype.FacilityTypeSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 * FacilityNumberLookupAction.java used to
 */
public class FacilityLookupAction extends LookupBaseAction
{
    private FacilityTypeBO facilityTypeBO;
    private FacilityTypeSC facilityTypeSC = new FacilityTypeSC();

    @Override
    public Object getModel()
    {
        return facilityTypeSC;
    }

    public String constructFacilityNumberLookup()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"CODE", "SHORT_NAME_ENG", "LONG_NAME_ENG"};
            String[] colType = {"number", "text", "text"};
            String[] titles = {getText("Code_key"), getText("Brief_Description_key"),
                getText("Long_Description_key")};

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Lookup/Query__For_FacilityType_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/FacilityLookup_fillFacilityNumberLookup");
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
            lookup(grid, lsGridColumn, null, facilityTypeSC);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructFacilityNumberLookup of FacilityLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;

    }

    public String fillFacilityNumberLookup()
    {
        try
        {
            setSearchFilter(facilityTypeSC);
            copyproperties(facilityTypeSC);
            SessionCO sessionCO = returnSessionObject();
            facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
            //facilityTypeSC.setBranchCode(sessionCO.getBranchCode());
            
            if(NumberUtil.isEmptyDecimal(facilityTypeSC.getBranchCode()))
            {
            facilityTypeSC.setBranchCode(sessionCO.getBranchCode());
            }

            if(checkNbRec(facilityTypeSC))
            {
                setRecords(facilityTypeBO.facilityNumberListCount(facilityTypeSC));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(facilityTypeBO.facilityNumberList(facilityTypeSC));

        }
        catch(Exception e)
        {
            log.error(e, "Error in fillLookupData of FacilityLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    public String constructFacilitySubLimitLookup()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"LINE_NBR", "CATEGORY", "GENERAL_FACILITY_TYPE", "FACILITY_VALUE",
                "MATURITY_DATE", "CLASS_TYPE", "FLOATING_RATE", "MARGIN_RATE", "REMARKS", "EXCH_RATE",
                "CV_VALUE", "VALUE_DATE"};
            String[] colType = {"number", "number", "text", "number", "date", "number", "number", "number",
                "text", "number", "number", "date"};
            String[] titles = {getText("Code__key"), getText("Category_key"), getText("Item_key"),
                getText("Facility_Value_key"), getText("Maturity_Date_key"), getText("Class_Type_key"),
                getText("Floating_Rate_key"), getText("Margin_Rate_key"), getText("remarks_key"),
                getText("Exchange_Rate_key"), getText("Value_in_Base_CY_key"), getText("valueDate_key")};

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Lookup/Query__For_FacilityType_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/FacilityLookup_fillFacilitySubLimitLookup");
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
            lookup(grid, lsGridColumn, null, facilityTypeSC);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructFacilitySubLimitLookup of FacilityLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;

    }

    public String fillFacilitySubLimitLookup()
    {
        try
        {
            setSearchFilter(facilityTypeSC);
            copyproperties(facilityTypeSC);
            SessionCO sessionCO = returnSessionObject();
            facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
            //facilityTypeSC.setBranchCode(sessionCO.getBranchCode());
            if(NumberUtil.isEmptyDecimal(facilityTypeSC.getBranchCode()))
            {
            facilityTypeSC.setBranchCode(sessionCO.getBranchCode());
            }

            if(checkNbRec(facilityTypeSC))
            {
                setRecords(facilityTypeBO.facilitySubLimitListCount(facilityTypeSC));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(facilityTypeBO.facilitySubLimitList(facilityTypeSC));

        }
        catch(Exception e)
        {
            log.error(e, "Error in fillFacilitySubLimitLookup of FacilityLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * TFA Facility Management Lookup construction
     * 
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_facility_management (tfa06.pbl) / dw_lookup_facility_management (tfa06.pbl)
     * amount (nominal_value) parameter sent deleted (not used)
     */
    public String constructFacilityNumberLookupTFA()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"CODE", "branch", "fromApplication", "revolvingOneOff", "cif", "shortNameEng",
                "facilityType", "status", "facilityValue", "drwdwnAmount", "briefDescEng"};
            String[] colType = {"number", "number", "number", "text", "number", "text", "text", "text",
                "number", "number", "text"};
            String[] titles = {getText("Code_key"), getText("Branch_key"), getText("From_Application_key"),
                getText("Revolving_Oneoff_key"), getText("CIF_Code_key"), getText("CIF_Brief_Name_key"),
                getText("FacilityType_key"), getText("Status_key"), getText("Facility_Value_key"),
                getText("Draw_Down_Amount_key"), getText("Currency_key")};

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Facility_Management_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/FacilityLookup_fillFacilityNumberLookupTFA");

            List<LookupGridColumn> trxGridColumn = returnStandarColSpecs(name, colType, titles);

            trxGridColumn.get(0).setLeadZeros("10");// CODE
            trxGridColumn.get(1).setLeadZeros("4");// branch
            trxGridColumn.get(2).setLeadZeros("10");// fromApplication
            trxGridColumn.get(8).setNbFormat("#,##0.00"); // facilityValue

            lookup(grid, trxGridColumn, null, facilityTypeSC);
        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }

        return SUCCESS;

    }

    /**
     * TFA Facility Management Lookup filling
     * 
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_facility_management (tfa06.pbl) / dw_lookup_facility_management (tfa06.pbl)
     * amount (nominal_value) parameter sent deleted (not used)
     */
    public String fillFacilityNumberLookupTFA()
    {
        try
        {
            setSearchFilter(facilityTypeSC);
            copyproperties(facilityTypeSC);
            SessionCO sessionCO = returnSessionObject();
            facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
            facilityTypeSC.setBranchCode(sessionCO.getBranchCode());
            facilityTypeSC.setPreferredLanguage(sessionCO.getLanguage());
            facilityTypeSC.setStatusLovType(BigDecimal.valueOf(263));
            facilityTypeSC.setFacilityTypeLovType(BigDecimal.valueOf(221));
            facilityTypeSC.setOneOffLovType(BigDecimal.valueOf(220));

            if(BigDecimal.ZERO.compareTo(NumberUtil.nullEmptyToValue(NumberUtil
                .emptyDecimalToNull(facilityTypeSC.getFacilityCode()), BigDecimal.ZERO)) != 0)
            {
                facilityTypeSC.setBranchCode(facilityTypeSC.getFacilityCode());
            }
            
            if(BigDecimal.ONE.compareTo(NumberUtil.nullToZero(facilityTypeSC.getDisableBranchFilter())) == 0)
            {
        	facilityTypeSC.setBranchCode(null);
            }

            if(ConstantsCommon.FUND_METHOD_LG_FINANCING.equals(StringUtil.nullToEmpty(facilityTypeSC
                .getSettleMethod())))
            {
                facilityTypeSC.setSettleMethod(ConstantsCommon.FUND_METHOD_FINANCING);
            }
            else if(ConstantsCommon.FUND_METHOD_LG_APPLICANT_ACCOUNT.equals(StringUtil
                .nullToEmpty(facilityTypeSC.getSettleMethod())))
            {
                facilityTypeSC.setSettleMethod(ConstantsCommon.FUND_METHOD_APPLICANT_ACCOUNT);
            }

            if(checkNbRec(facilityTypeSC))
            {
                setRecords(facilityTypeBO.facilityNumberTFAListCount(facilityTypeSC));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(facilityTypeBO.facilityNumberTFAList(facilityTypeSC));

        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * @return the facilityTypeSC
     */
    public FacilityTypeSC getFacilityTypeSC()
    {
        return facilityTypeSC;
    }

    /**
     * @param facilityTypeSC the facilityTypeSC to set
     */
    public void setFacilityTypeSC(FacilityTypeSC facilityTypeSC)
    {
        this.facilityTypeSC = facilityTypeSC;
    }

    /**
     * @param facilityTypeBO the facilityTypeBO to set
     */
    public void setFacilityTypeBO(FacilityTypeBO facilityTypeBO)
    {
        this.facilityTypeBO = facilityTypeBO;
    }
}
