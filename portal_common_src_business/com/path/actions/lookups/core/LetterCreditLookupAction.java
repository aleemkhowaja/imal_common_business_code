package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.lettercredit.LetterCreditBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.lettercredit.LetterCreditSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 */
public class LetterCreditLookupAction extends LookupBaseAction
{
    private LetterCreditBO letterCreditBO;
    private LetterCreditSC criteria = new LetterCreditSC();

    /**
     * Construct Letter credit Lookup
     * 
     * @author: ghenoiesaab
     * @date: Oct 1, 2013
     * @PB: w_lookup_bc (tfajv)
     */
    public String constructLookup()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = new String[] {"tfsLc1VO.LC_REFERENCE_NBR", "lcStatusDesc",
                "tfsLc1VO.LC_REFERENCE_YEAR", "lcRefTypeDesc", "tfsLc1VO.LC_NBR", "tfsLc1VO.CIF",
                "tfsLc1VO.LC_CURRENCY", "cyDesc", "tfsLc1VO.LC_AMOUNT", "setlMethodDesc",
                "tfsLc1VO.APPLICATION_DATE", "tfsLc1VO.VALIDITY_FROM", "tfsLc1VO.VALIDITY_TO",
                "tfsDocTypeDesc", "cyDecimalPt"};

            String[] colType = new String[] {"number", "text", "number", "text", "number", "number", "number",
                "text", "number", "text", "date", "date", "date", "text", "number"};

            String[] titles = new String[] {getText("LC_Ref_Nbr_key"), getText("Status_key"),
                getText("Year_key"), getText("Type_key"), getText("LC_Request_Nbr_key"), getText("CIF_key"),
                getText("CY_Code_key"), getText("Currency_key"), getText("Amount_key"),
                getText("Settlement_Method_key"), getText("ApplicationDate_key"),
                getText("ValidityFrom_key"), getText("ValidityTo_key"), getText("Type_key"),
                getText("Decimal_points_key")};

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("LC_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/LetterCreditLookup_fillLetterCreditLookup");

            List<LookupGridColumn> lcGridColumn = returnStandarColSpecs(name, colType, titles);
            lcGridColumn.get(0).setLeadZeros("10");// tfsLc1VO.LC_REFERENCE_NBR
            lcGridColumn.get(4).setLeadZeros("10");// tfsLc1VO.LC_NBR
            lcGridColumn.get(5).setLeadZeros("8");// tfsLc1VO.CIF
            lcGridColumn.get(6).setLeadZeros("3");// tfsLc1VO.LC_CURRENCY
            lcGridColumn.get(8).setFormatter("currencyFmatter");// tfsLc1VO.LC_AMOUNT
            lcGridColumn.get(8).setFormatCol("cyDecimalPt");// tfsLc1VO.LC_AMOUNT
            lcGridColumn.get(14).setHidden(true);// cyDecimalPt

            lookup(grid, lcGridColumn, null, criteria);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructLookup of LetterCreditLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;
    }

    /**
     * Fill Letter Credit Lookup
     * 
     * @author: ghenoiesaab
     * @date: Oct 1, 2013
     * @PB: w_lookup_bc (tfajv)
     */
    public String fillLetterCreditLookup()
    {
        try
        {
            NumberUtil.resetEmptyValues(criteria);
            setSearchFilter(criteria);
            copyproperties(criteria);
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());
            criteria.setLovTypeId(ConstantsCommon.CREDIT_AVAILABILITY_LOV_TYPE);
            criteria.setSetlMethodLovType(ConstantsCommon.SETTLEMENT_METHOD_LOV_TYPE);
            criteria.setPreferredLanguage(sessionCO.getLanguage());
            criteria.setStatusLovType(ConstantsCommon.LC_LOV_TYPE);
            //Mark Ayoub - 450290
            if("R".equals(criteria.getLcType()))
            {
             criteria.setLcType("O");
             criteria.setIsContractRegist("R");
            }
            //End Mark

            if(checkNbRec(criteria))
            {
                setRecords(letterCreditBO.returnLetterCreditLookupCount(criteria));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(letterCreditBO.returnLetterCreditLookupList(criteria));
        }
        catch(Exception e)
        {
            log.error(e, "Error in fillLetterCreditLookup of LetterCreditLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * LC Issuance lc_nbr live search
     * 
     * @author: BassamEid
     * @date: May 20, 2014
     * @PB: w_lookup_lc (tfa06.pbl) dw_lookup_lc_issue_request
     * @return
     */
    public String constructLcIssueLookup()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = new String[] {"tfsLc1VO.LC_NBR", "lcStatusDesc", "tfsLc1VO.CIF",
                "tfsLc1VO.APPLICATION_DATE", "tfsLc1VO.VALIDITY_FROM", "tfsLc1VO.VALIDITY_TO",
                "tfsLc1VO.LC_CURRENCY", "cyDesc", "tfsLc1VO.LC_AMOUNT", "cyDecimalPt"};

            String[] colType = new String[] {"number", "text", "number", "date", "date", "date", "number",
                "text", "number", "number"};

            String[] titles = new String[] {getText("LC_Request_Nbr_key"), getText("Status_key"),
                getText("CIF_key"), getText("ApplicationDate_key"), getText("ValidityFrom_key"),
                getText("ValidityTo_key"), getText("CY_Code_key"), getText("Currency_key"),
                getText("Amount_key"), getText("Decimal_points_key")};

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("LC_Request_Nbr_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/LetterCreditLookup_fillLcIssueLookup");

            List<LookupGridColumn> lcGridColumn = returnStandarColSpecs(name, colType, titles);
            lcGridColumn.get(0).setLeadZeros("10");// tfsLc1VO.LC_NBR
            lcGridColumn.get(2).setLeadZeros("8");// tfsLc1VO.CIF
            lcGridColumn.get(6).setLeadZeros("3");// tfsLc1VO.LC_CURRENCY
            lcGridColumn.get(8).setFormatter("currencyFmatter");// tfsLc1VO.LC_AMOUNT
            lcGridColumn.get(8).setFormatCol("cyDecimalPt");// tfsLc1VO.LC_AMOUNT
            lcGridColumn.get(9).setHidden(true);// cyDecimalPt

            lookup(grid, lcGridColumn, null, criteria);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructLcIssueLookup of LetterCreditLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * LC Issuance lc_nbr live search
     * 
     * @author: BassamEid
     * @date: May 20, 2014
     * @PB: w_lookup_lc (tfa06.pbl) dw_lookup_lc_issue_request
     * @return
     */
    public String fillLcIssueLookup()
    {
        try
        {
            NumberUtil.resetEmptyValues(criteria);
            setSearchFilter(criteria);
            copyproperties(criteria);
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());
            criteria.setPreferredLanguage(sessionCO.getLanguage());
            criteria.setStatusLovType(ConstantsCommon.LC_LOV_TYPE);

            if(checkNbRec(criteria))
            {
                setRecords(letterCreditBO.returnLcIssueLookupCount(criteria));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(letterCreditBO.returnLcIssueLookupList(criteria));
        }
        catch(Exception e)
        {
            log.error(e, "Error in fillLcIssueLookup of LetterCreditLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    public Object getModel()
    {
        return criteria;
    }

    public LetterCreditSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(LetterCreditSC criteria)
    {
        this.criteria = criteria;
    }

    public void setLetterCreditBO(LetterCreditBO letterCreditBO)
    {
        this.letterCreditBO = letterCreditBO;
    }
}
