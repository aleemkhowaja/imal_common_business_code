package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.billcollection.BillCollectionBO;
import com.path.dbmaps.vo.TFSCTRL1VO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.billcollection.BillCollectionSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 */
public class BillCollectionLookupAction extends LookupBaseAction
{
    private BillCollectionBO billCollectionBO;

    private BillCollectionSC criteria = new BillCollectionSC();

    /**
     * Construct Bill Lookup
     * 
     * @author: ghenoiesaab
     * @date: Feb 6, 2014
     * @PB:w_lookup_bc (tfajv.pbl)
     * dw_lookup_bc_no_year(ora_tfa.pbl/syb_tfa.pbl)
     * & dw_lookup_bc (ora_tfa.pbl/syb_tfa.pbl)
     */
    public String constructLookup()
    {
        try
        {
            SessionCO sessionCO = returnSessionObject();
            TFSCTRL1VO tfsctrl1vo = new TFSCTRL1VO();
            tfsctrl1vo.setCOMP_CODE(sessionCO.getCompanyCode());
            tfsctrl1vo.setBRANCH(sessionCO.getBranchCode());
            tfsctrl1vo = returnCommonLibBO().returnTfsCtrl_1(tfsctrl1vo);

            String[] name = null, colType = null, titles = null;

            // Design the Grid by defining the column model and column names
            // dw_lookup_bc_no_year
            if("0".equals(StringUtil.nullEmptyToValue(tfsctrl1vo.getSERIALITY_BY_YEAR(), "0")))
            {
                name = new String[] {"tfsBillVO.BILL_NBR", "billStatusDesc", "tfsBillVO.BANK_DEF_CIF",
                    "bankName", "tfsBillVO.CUSTOMER_CIF", "customerName", "cyBriefDesc", "tfsBillVO.BILL_DATE",
                    "tfsBillVO.AMOUNT", "tfsBillVO.MANUAL_REFERENCE", "billSetlTypeDesc", "tfsDocTypeDesc",
                    "cyDecimalPt"};
                colType = new String[] {"number", "text", "number", "text", "number", "text", "text", "date",
                    "number", "text", "text", "text", "number"};
                titles = new String[] {getText("Bill_No_key"), getText("Status_key"),
                    getText("Bank_cif_Key"), getText("Bank_Name_key"), getText("Customer_CIF_key"),
                    getText("Customer_Name_key"), getText("Currency_key"), getText("Bill_Date_key"),
                    getText("Amount_key"), getText("Reference_key"), getText("Type_key"),
                    getText("Bill_Type_key"), getText("Decimal_points_key")};
            }
            // dw_lookup_bc
            else
            {
                name = new String[] {"tfsBillVO.DOC_YEAR", "tfsBillVO.BILL_NBR", "billStatusDesc",
                    "tfsBillVO.BANK_DEF_CIF", "bankName", "tfsBillVO.CUSTOMER_CIF", "customerName",
                    "cyBriefDesc", "tfsBillVO.AMOUNT", "tfsBillVO.MANUAL_REFERENCE", "billSetlTypeDesc",
                    "tfsDocTypeDesc", "cyDecimalPt"};
                colType = new String[] {"number", "number", "text", "number", "text", "number", "text", "text",
                    "number", "text", "text", "text", "number"};
                titles = new String[] {getText("Document_Year_key"), getText("Bill_No_key"),
                    getText("Status_key"), getText("Bank_cif_Key"), getText("Bank_Name_key"),
                    getText("Customer_CIF_key"), getText("Customer_Name_key"), getText("Currency_key"),
                    getText("Amount_key"), getText("Reference_key"), getText("Type_key"),
                    getText("Bill_Type_key"), getText("Decimal_points_key")};
            }
            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Bill_No_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/BillCollectionLookup_fillBillCollectionLookup");
            List<LookupGridColumn> billGridColumn = returnStandarColSpecs(name, colType, titles);
            for(int i = 0; i < name.length; i++)
            {
                if("tfsBillVO.DOC_NUMBER".equals(billGridColumn.get(i).getName())
                    || "tfsBillVO.BILL_NBR".equals(billGridColumn.get(i).getName()))
                {
                    billGridColumn.get(i).setLeadZeros("6");
                }
                else if("tfsBillVO.BANK_DEF_CIF".equals(billGridColumn.get(i).getName())
                    || "tfsBillVO.CUSTOMER_CIF".equals(billGridColumn.get(i).getName()))
                {
                    billGridColumn.get(i).setLeadZeros("8");
                }
                else if("tfsBillVO.AMOUNT".equals(billGridColumn.get(i).getName()))
                {
                    billGridColumn.get(i).setFormatter("currencyFmatter");
                    billGridColumn.get(i).setFormatCol("cyDecimalPt");
                }
                else if("cyDecimalPt".equals(billGridColumn.get(i).getName()))
                {
                    billGridColumn.get(i).setHidden(true);
                }
            }
            lookup(grid, billGridColumn, null, criteria);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructLookup of BillCollectionLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;
    }

    /**
     * Fill Bill Lookup
     * 
     * @author: ghenoiesaab
     * @date: Feb 6, 2014
     * @PB:w_lookup_bc (tfajv.pbl)
     * dw_lookup_bc_no_year(ora_tfa.pbl/syb_tfa.pbl)
     * & dw_lookup_bc (ora_tfa.pbl/syb_tfa.pbl)
     */
    public String fillBillCollectionLookup()
    {
        try
        {
            setSearchFilter(criteria);
            copyproperties(criteria);
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());
            criteria.setLovTypeId(ConstantsCommon.CREDIT_AVAILABILITY_LOV_TYPE);
            criteria.setPreferredLanguage(sessionCO.getLanguage());
            criteria.setStatusLovType(ConstantsCommon.BILL_STATUS_LOV_TYPE);

            if(checkNbRec(criteria))
            {
                setRecords(billCollectionBO.returnBillCollectionLookupCount(criteria));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(billCollectionBO.returnBillCollectionLookupList(criteria));
        }
        catch(Exception e)
        {
            log.error(e, "Error in fillBillCollectionLookup of BillCollectionLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * Construct the acceptance lookup
     * 
     * @author: eliebounassif
     * @date: Feb 4, 2014
     * @PB: w_lookup_bc_acceptance (tfajv.pb)
     * dw_lookup_bc_accept_only (ora_tfa.pbl/syb_tfa.pbl)
     */
    public String constructAcceptanceLookup()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"tfsTrxVO.TRX_NBR", "tfsTrxVO.LC_AMEND_NO", "tfsTrxVO.STATUS",
                "tfsBillVO.BANK_DEF_CIF", "bankName", "tfsBillVO.CUSTOMER_CIF", "tfsBillVO.BILL_DATE",
                "customerName", "cyBriefDesc", "tfsTrxVO.SHIPMENT_AMOUNT", "tfsTrxVO.CV_AMOUNT",
                "tfsBillVO.TYPE", "cyDecimalPt"};
            String[] colType = {"number", "number", "text", "number", "text", "number", "date", "text", "text",
                "number", "number", "number", "number"};
            String[] titles = {getText("Acceptance_Code_key"), getText("Acceptance_Counter_key"),
                getText("Status_key"), getText("Bank_cif_Key"), getText("Bank_Name_key"),
                getText("Customer_CIF_key"), getText("Bill_Date_key"), getText("Customer_Name_key"),
                getText("Currency_Name_key"), getText("FC_Amount_key"), getText("CV_amt_key"),
                getText("Bill_Type_key"), getText("Decimal_points_key")};

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption("Acceptance_Code_key");
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/BillCollectionLookup_fillAcceptanceLookup");
            List<LookupGridColumn> acceptanceGridColumn = returnStandarColSpecs(name, colType, titles);
            acceptanceGridColumn.get(0).setLeadZeros("10");// tfsTrxVO.TRX_NBR
            acceptanceGridColumn.get(1).setLeadZeros("4");// tfsTrxVO.LC_AMEND_NO
            acceptanceGridColumn.get(3).setLeadZeros("8");// tfsBillVO.BANK_DEF_CIF
            acceptanceGridColumn.get(5).setLeadZeros("8");// tfsBillVO.CUSTOMER_CIF
            acceptanceGridColumn.get(9).setFormatter("currencyFmatter");// tfsTrxVO.SHIPMENT_AMOUNT
            acceptanceGridColumn.get(9).setFormatCol("cyDecimalPt");// tfsTrxVO.SHIPMENT_AMOUNT
            acceptanceGridColumn.get(10).setFormatter("currencyFmatter");// tfsTrxVO.CV_AMOUNT
            acceptanceGridColumn.get(10).setFormatCol("cyDecimalPt");// tfsTrxVO.CV_AMOUNT
            acceptanceGridColumn.get(12).setHidden(true);// cyDecimalPt
            lookup(grid, acceptanceGridColumn, null, criteria);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructLookup of constructAcceptanceLookup");
            handleException(e, null, null);
        }

        return SUCCESS;

    }

    /**
     * Fill acceptance lookup
     * 
     * @author: eliebounassif
     * @date: Feb 4, 2014
     * @PB: w_lookup_bc_acceptance (tfajv.pb)
     * dw_lookup_bc_accept_only (ora_tfa.pbl/syb_tfa.pbl)
     */
    public String fillAcceptanceLookup()
    {
        try
        {
            setSearchFilter(criteria);
            copyproperties(criteria);
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());
            criteria.setTrxType(ConstantsCommon.TRX_TYPE_ACCEPTANCE);
            criteria.setIsRTLDir(sessionCO.getIsRTLDir());
            criteria.setPreferredLanguage(sessionCO.getLanguage());
            criteria.setStatusLovType(ConstantsCommon.BILL_STATUS_LOV_TYPE);
            if(checkNbRec(criteria))
            {
                setRecords(billCollectionBO.returnAcceptanceLkpCount(criteria));
            }
            setGridModel(billCollectionBO.returnAcceptanceLkpList(criteria));
        }
        catch(Exception e)
        {
            log.error(e, "Error in fillAcceptanceLookup of BillCollectionLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * Construct the acceptance amend lookup
     * 
     * @author: eliebounassif
     * @date: Feb 25, 2014
     * @PB:w_lookup_bc_acceptance_amend (tfajv.pb)
     * dw_lookup_bc_accept_amend (ora_tfa.pbl/syb_tfa.pbl)
     */
    public String constructAcceptanceAmendLookup()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"tfsTrxVO.TRX_NBR", "tfsTrxVO.LC_AMEND_NO", "tfsTrxVO.STATUS",
                "tfsBillVO.BANK_DEF_CIF", "bankName", "tfsBillVO.CUSTOMER_CIF", "billDate", "customerName",
                "cyBriefDesc", "tfsTrxVO.CV_AMOUNT"};
            String[] colType = {"number", "number", "text", "number", "text", "number", "text", "text", "text",
                "number"};
            String[] titles = {getText("Acceptance_Code_key"), getText("Acceptance_Counter_key"),
                getText("Status_key"), getText("Bank_cif_Key"), getText("Bank_Name_key"),
                getText("Customer_CIF_key"), getText("Bill_Date_key"), getText("Customer_Name_key"),
                getText("Currency_Name_key"), getText("CV_amt_key")};

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption("Acceptance_Code_key");
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/BillCollectionLookup_fillAcceptanceAmendLookup");
            List<LookupGridColumn> acceptanceAmendGridColumn = returnStandarColSpecs(name, colType, titles);
            acceptanceAmendGridColumn.get(0).setLeadZeros("10");// tfsTrxVO.TRX_NBR
            acceptanceAmendGridColumn.get(1).setLeadZeros("4");// tfsTrxVO.LC_AMEND_NO
            acceptanceAmendGridColumn.get(3).setLeadZeros("8");// tfsBillVO.BANK_DEF_CIF
            acceptanceAmendGridColumn.get(5).setLeadZeros("8");// tfsBillVO.CUSTOMER_CIF
            acceptanceAmendGridColumn.get(9).setFormatter("currencyFmatter");// tfsTrxVO.CV_AMOUNT
            acceptanceAmendGridColumn.get(9).setFormatCol("cyDecimalPt");// tfsTrxVO.CV_AMOUNT
            lookup(grid, acceptanceAmendGridColumn, null, criteria);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructLookup of constructAcceptanceAmendLookup");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * Fill acceptance amend lookup
     * 
     * @author: eliebounassif
     * @date: Feb 25, 2014
     * @PB:w_lookup_bc_acceptance_amend (tfajv.pb)
     * dw_lookup_bc_accept_amend (ora_tfa.pbl/syb_tfa.pbl)
     */
    public String fillAcceptanceAmendLookup()
    {
        try
        {
            setSearchFilter(criteria);
            copyproperties(criteria);
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());
            criteria.setTrxType(ConstantsCommon.TRX_TYPE_ACCEPTANCE);
            criteria.setIsRTLDir(sessionCO.getIsRTLDir());
            criteria.setPreferredLanguage(sessionCO.getLanguage());
            criteria.setStatusLovType(ConstantsCommon.STATUS_LOV_TYPE);
            if(checkNbRec(criteria))
            {
                setRecords(billCollectionBO.returnAcceptanceAmendLkpCount(criteria));
            }
            setGridModel(billCollectionBO.returnAcceptanceAmendLkpList(criteria));
        }
        catch(Exception e)
        {
            log.error(e, "Error in fillAcceptanceAmendLookup of BillCollectionLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    public Object getModel()
    {
        return criteria;
    }

    public BillCollectionSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(BillCollectionSC criteria)
    {
        this.criteria = criteria;
    }

    public void setBillCollectionBO(BillCollectionBO billCollectionBO)
    {
        this.billCollectionBO = billCollectionBO;
    }

}
