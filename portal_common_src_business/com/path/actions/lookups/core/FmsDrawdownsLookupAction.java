/**
 * 
 */
package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.core.fmsdrawdowns.FmsDrawdownsBO;
import com.path.lib.common.util.NumberUtil;
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
 * FmsDrawDownLookupAction.java used to
 */
public class FmsDrawdownsLookupAction extends LookupBaseAction
{
    private FacilityTypeSC facilityTypeSC = new FacilityTypeSC();
    private FmsDrawdownsBO fmsDrawdownsBO;

    @Override
    public Object getModel()
    {
        return facilityTypeSC;
    }

    /**
     * Construct Fms DrawDowns LookupAction based on the VO returned in the
     * resultMap.
     * 
     * @return
     */
    public String constructLookup()
    {
        try
        {
            List<LookupGridColumn> lsGridColumn = constructLookupGrid();

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Drawdown_Details_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/FmsDrawdowns_fillFmsDrawDownsList");
            lookup(grid, lsGridColumn, null, facilityTypeSC);
        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }

        return SUCCESS;

    }

    /**
     * 
     */
    private List<LookupGridColumn> constructLookupGrid()
    {
        // Design the Grid by defining the column model and column names
        String[] name = {"CODE", "FROM_FACILITY", "FROM_APPLICATION", "STATUS", "LONG_NAME_ENG",
            "DRAWDOWN_TYPE", "BRIEF_NAME_ENG", "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG"};

        String[] colType = {"number", "number", "number", "text", "text", "number", "text", "number", "text",
            "text"};
        String[] titles = {getText("Code__key"), getText("Facility_Ref_key"), getText("Application_Ref_key"),
            getText("Status_key"), getText("Long_Name__key"), getText("Type_key"), getText("Brief_Name_key"),
            getText("CIF_code_key"), getText("CIF_Short_Name_key"), getText("Cif_Long_Name_key")};

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
        return lsGridColumn;
    }

    /**
     * Fill the lookup for fillFmsDrawDowns data filtered by the defined
     * criteria
     * 
     * @return
     * @throws JSONException
     */
    public String fillFmsDrawDownsList() throws JSONException
    {
        try
        {
            setSearchFilter(facilityTypeSC);
            copyproperties(facilityTypeSC);
            SessionCO sessionCO = returnSessionObject();
            facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
            facilityTypeSC.setFACILITY_CATEG(BigDecimal.valueOf(22));
            if(NumberUtil.isEmptyDecimal(facilityTypeSC.getCifNo()))
            {
                facilityTypeSC.setCifNo(BigDecimal.ZERO);
            }
            facilityTypeSC.setCrud("V");
            if(checkNbRec(facilityTypeSC))
            {
                setRecords(fmsDrawdownsBO.fmsDrawDownsListCount(facilityTypeSC));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(fmsDrawdownsBO.fmsDrawDownsList(facilityTypeSC));

        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /***
     * Construct Fms DrawDowns LookupAction based on the VO returned in the
     * 
     * @return String
     */
    public String constructLookupFMS()
    {
        try
        {
            List<LookupGridColumn> lsGridColumn = constructLookupGrid();

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Drawdown_Details_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/FmsDrawdowns_fillFmsDrawDownsListFMS");

            lookup(grid, lsGridColumn, null, facilityTypeSC);
        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }

        return SUCCESS;

    }

    /**
     * Fill the lookup for fillFmsDrawDowns data filtered by the defined
     * criteria
     * 
     * @return
     * @throws JSONException
     */
    public String fillFmsDrawDownsListFMS() throws JSONException
    {
        try
        {
            setSearchFilter(facilityTypeSC);
            copyproperties(facilityTypeSC);
            SessionCO sessionCO = returnSessionObject();
            facilityTypeSC.setBranchCode(sessionCO.getBranchCode());
            facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
            facilityTypeSC.setPreferredLanguage(sessionCO.getLanguage());

            if(checkNbRec(facilityTypeSC))
            {
                setRecords(fmsDrawdownsBO.fmsDrawDownsListCountFMS(facilityTypeSC));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(fmsDrawdownsBO.fmsDrawDownsListFMS(facilityTypeSC));

        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * Construct the lookup for TfaFmsDrawDowns data filtered by the defined criteria
     * 
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_draw_down (tfa06.pbl)/ dw_lookup_draw_down (syb_tfa.pbl)
     */
    public String constructFmsDrwDwnLkpTFA()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"CODE", "FROM_FACILITY", "STATUS", "LONG_NAME_ENG", "DRAWDOWN_TYPE",
                "BRIEF_NAME_ENG"};
            String[] colType = {"number", "number", "text", "text", "number", "text"};
            String[] titles = {getText("Code_key"), getText("Facility_Reference_key"), getText("Status_key"),
                getText("Long_Name_key"), getText("Type_key"), getText("Type_Brief_Name_key")};

            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Draw_Down_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/FmsDrawdowns_fillFmsDrwDwnListTFA");

            List<LookupGridColumn> trxGridColumn = returnStandarColSpecs(name, colType, titles);

            trxGridColumn.get(0).setLeadZeros("10"); // CODE
            trxGridColumn.get(1).setLeadZeros("10"); // FROM_FACILITY
            trxGridColumn.get(3).setWidth("100"); // LONG_NAME_ENG
            trxGridColumn.get(4).setLeadZeros("4"); // DRAWDOWN_TYPE

            lookup(grid, trxGridColumn, null, facilityTypeSC);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructFmsDrwDwnLkpTFA of FmsDrawdownsLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;
    }

    /**
     * Fill the lookup for TfaFmsDrawDowns data filtered by the defined criteria
     * 
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_draw_down (tfa06.pbl)/ dw_lookup_draw_down (ora_syb.pbl,syb_tfa.pbl)
     */
    public String fillFmsDrwDwnListTFA()
    {
        try
        {
            setSearchFilter(facilityTypeSC);
            copyproperties(facilityTypeSC);
            SessionCO sessionCO = returnSessionObject();
            facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
            facilityTypeSC.setBranchCode(sessionCO.getBranchCode());
            facilityTypeSC.setStatusLovType(BigDecimal.valueOf(263));
            facilityTypeSC.setPreferredLanguage(sessionCO.getLanguage());

            if(BigDecimal.ZERO.compareTo(NumberUtil.nullEmptyToValue(NumberUtil
                .emptyDecimalToNull(facilityTypeSC.getFacilityBr()), BigDecimal.ZERO)) != 0)
            {
                facilityTypeSC.setBranchCode(facilityTypeSC.getFacilityBr());
            }

            if(checkNbRec(facilityTypeSC))
            {
                setRecords(fmsDrawdownsBO.returnTfaDrwDwnCount(facilityTypeSC));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(fmsDrawdownsBO.returnTfaDrwDwnList(facilityTypeSC));

        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * 
     * @author tonynouh
     * @date: 26/06/2014
     * @PB: w_lookup_amf_drawdowns_by_account
     */
    public String constructDrwDwnAccountLkp()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"BRANCH_CODE", "CURRENCY_CODE", "GL_CODE", "CIF_SUB_NO", "SL_NO",
                "ADDITIONAL_REFERENCE", "DD_BR", "DD_NO", "LONG_NAME_ENG", "LONG_NAME_ARAB"};
            String[] colType = {"number", "number", "number", "number", "number", "text", "number", "number",
                "text", "text"};

            String[] titles = {getText("Branch_Code_key"), getText("Currency_key"), getText("GL_key"),
                getText("CIF_key"), getText("SL_key"), getText("AdditionalReference_key"),
                getText("dd_br_key"), getText("dd_no_key"), getText("Long_Name_eng_key"),
                getText("Long_Name_Arab_key")};

            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Draw_Down_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/FmsDrawdowns_fillDrwDwnAccountList");
            List<LookupGridColumn> trxGridColumn = returnStandarColSpecs(name, colType, titles);
            lookup(grid, trxGridColumn, null, facilityTypeSC);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructDrwDwnAccountLkp of FmsDrawdownsLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    public String fillDrwDwnAccountList()
    {
        try
        {
            setSearchFilter(facilityTypeSC);
            copyproperties(facilityTypeSC);
            SessionCO sessionCO = returnSessionObject();
            facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
            facilityTypeSC.setBranchCode(sessionCO.getBranchCode());
            if(BigDecimal.ZERO.compareTo(NumberUtil.nullEmptyToValue(NumberUtil
                .emptyDecimalToNull(facilityTypeSC.getFacilityBr()), BigDecimal.ZERO)) != 0)
            {
                facilityTypeSC.setBranchCode(facilityTypeSC.getFacilityBr());
            }

            if(checkNbRec(facilityTypeSC))
            {
                setRecords(fmsDrawdownsBO.returnDrwDwnAccountCount(facilityTypeSC));
            }
            setGridModel(fmsDrawdownsBO.returnDrwDwnAccountList(facilityTypeSC));
        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * 
     * @author tonynouh
     * @date: 26/06/2014
     * @PB: w_lookup_drawdown
     */
    public String constructDrwDwnLkp()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"CODE", "DRWDWN_CODE", "FROM_FACILITY", "FACILITY_BRANCH", "CHQ_TRSFR_AMT"};
            String[] colType = {"number", "number", "number", "number", "number"};
            String[] titles = {getText("Code__key"), getText("drawdown_code_key"),
                getText("from_facility_key"), getText("facility_branch_key"), getText("cheque_trsfr_amt_key")};

            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Draw_Down_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/FmsDrawdowns_fillDrwDwnList");
            List<LookupGridColumn> trxGridColumn = returnStandarColSpecs(name, colType, titles);
            lookup(grid, trxGridColumn, null, facilityTypeSC);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructDrwDwnLkp of FmsDrawdownsLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    public String fillDrwDwnList()
    {
        try
        {
            setSearchFilter(facilityTypeSC);
            copyproperties(facilityTypeSC);
            SessionCO sessionCO = returnSessionObject();
            facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
            facilityTypeSC.setBranchCode(sessionCO.getBranchCode());

            if(checkNbRec(facilityTypeSC))
            {
                setRecords(fmsDrawdownsBO.returnDrwDwnListCount(facilityTypeSC));
            }
            setGridModel(fmsDrawdownsBO.returnDrwDwnList(facilityTypeSC));
        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    
    /***
     * Construct Fms DrawDowns LookupAction for FMS template screens
     * 
     * @return String
     */
    public String constructLookupTemplateFMS()
    {
        try
        {
            List<LookupGridColumn> lsGridColumn = constructLookupGrid();

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Drawdown_Details_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/FmsDrawdowns_fillFmsDrawDownsListTemplateFMS");

            lookup(grid, lsGridColumn, null, facilityTypeSC);
        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }

        return SUCCESS;

    }

    /**
     * Fill the lookup for fillFmsDrawDowns data filtered by the defined
     * criteria
     * 
     * @return
     * @throws JSONException
     */
    public String fillFmsDrawDownsListTemplateFMS() throws JSONException
    {
        try
        {
            setSearchFilter(facilityTypeSC);
            copyproperties(facilityTypeSC);
            SessionCO sessionCO = returnSessionObject();
            facilityTypeSC.setBranchCode(sessionCO.getBranchCode());
            facilityTypeSC.setCompCode(sessionCO.getCompanyCode());

            if(checkNbRec(facilityTypeSC))
            {
                setRecords(fmsDrawdownsBO.fmsDrawDownsListCountTemplateFMS(facilityTypeSC));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(fmsDrawdownsBO.fmsDrawDownsListTemplateFMS(facilityTypeSC));

        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }
        return SUCCESS;
    }
    
    /**
     * @param facilityTypeSC the facilityTypeSC to set
     */
    public void setFacilityTypeSC(FacilityTypeSC facilityTypeSC)
    {
        this.facilityTypeSC = facilityTypeSC;
    }

    /**
     * @return the facilityTypeSC
     */
    public FacilityTypeSC getFacilityTypeSC()
    {
        return facilityTypeSC;
    }

    /**
     * @param fmsDrawdownsBO the fmsDrawdownsBO to set
     */
    public void setFmsDrawdownsBO(FmsDrawdownsBO fmsDrawdownsBO)
    {
        this.fmsDrawdownsBO = fmsDrawdownsBO;
    }
}
