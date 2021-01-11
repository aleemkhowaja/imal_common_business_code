/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: ghenoiesaab
 * 
 * LetterGuaranteeLookupAction used to open LG lookup
 */
package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.letterguarantee.LetterGuaranteeBO;
import com.path.dbmaps.vo.TFSCTRL1VO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.letterguarantee.LetterGuaranteeSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: ghenoiesaab
 * 
 * LetterGuaranteeLookupAction used to open LG lookup
 */
public class LetterGuaranteeLookupAction extends LookupBaseAction
{
    private LetterGuaranteeBO letterGuaranteeBO;

    private LetterGuaranteeSC criteria = new LetterGuaranteeSC();

    /**
     * Construct LG Lookup
     * 
     * @PB: w_lookup_lg_issue (tfajv)
     * dw_lookup_lg_margin_ny (ora_tfa/syb_tfa)
     * dw_lookup_lg_margin (ora_tfa/syb_tfa)
     * dw_lookup_lg_issue_ny (ora_tfa/syb_tfa)
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

            String serialityByYear = tfsctrl1vo != null ? StringUtil.nullToEmpty(tfsctrl1vo.getSERIALITY_BY_YEAR()) : "";

            String[] name = null, colType = null, titles = null;
            // Design the Grid by defining the column model and column names
           // if("0".equals(serialityByYear))
            {
                // dw_lookup_lg_issue_ny
                name = new String[] {"tfsLgVO.LG_NBR", "tfsLgVO.DOC_NUMBER", "lgStatusDesc", "tfsDocTypeDesc",
                    "tfsLgVO.REQUISITION_NBR", "cifDesc", "cyBriefDesc", "tfsLgVO.AMOUNT", 
                    "tfsLgVO.DOC_DATE", "tfsLgVO.VALIDITY_FROM", "tfsLgVO.VALIDITY_TO", "tfsLgVO.CIF",
                    "tfsDocTypeDesc", "cyDecimalPt"};

                colType = new String[] {"number", "number", "text", "text", "number", "text", "text", "number",
                    "date", "date", "date", "number", "text", "number"};

                titles = new String[] {getText("LG_Nbr_key"), getText("Document_Number_key"),
                    getText("Status_key"), getText("LG_Type_BriefName_key"), getText("Request_No_key"),
                    getText("Applicant_Name_key"), getText("Currency_key"), getText("Amount_key"),
                    getText("Doc_date_key"), getText("ValidityFrom_key"), getText("ValidityTill_key"),
                    getText("CIF_key"), getText("Type_key"), getText("Decimal_points_key")};

            }
            
            BigDecimal trxType = NumberUtil.emptyDecimalToZero(criteria.getTrxType());
            
            // kaldanaf - FIBA140163 - obtaining the right lookup relative to the right screen
            if(ConstantsCommon.TRX_TYPE_SUSPENSE_SETTLEMENT.equals(trxType)
                || ConstantsCommon.TRX_TYPE_OUTSIDE_CHARGES.equals(trxType)
                || ConstantsCommon.TRX_TYPE_OTHER_COMMISSION.equals(trxType)
                || ConstantsCommon.TRX_TYPE_AMEND_MARGIN.equals(trxType))
            {
                if("0".equals(serialityByYear))
                {
                    // dw_lookup_lg_margin_ny
                    name = new String[] {"tfsLgVO.LG_NBR", "tfsLgVO.DOC_NUMBER", "lgStatusDesc",
                        "tfsDocTypeDesc", "tfsLgVO.REQUISITION_NBR", "cifDesc", "cyBriefDesc",
                        "tfsLgVO.AMOUNT", "tfsLgVO.DOC_DATE", "tfsLgVO.VALIDITY_FROM", "tfsLgVO.VALIDITY_TO",
                        "tfsLgVO.CIF", "tfsDocTypeDesc", "cyDecimalPt"};

                    colType = new String[] {"number", "number", "text", "text", "number", "text", "text",
                        "number", "date", "date", "date", "number", "text", "number"};

                    titles = new String[] {getText("LG_Nbr_key"), getText("Document_Number_key"),
                        getText("Status_key"), getText("LG_Type_BriefName_key"), getText("Request_No_key"),
                        getText("Applicant_Name_key"), getText("Currency_key"), getText("Amount_key"),
                        getText("Doc_date_key"), getText("ValidityFrom_key"), getText("ValidityTill_key"),
                        getText("CIF_key"), getText("Type_key"), getText("Decimal_points_key")};

                }
                else
                {
                    // dw_lookup_lg_margin

                    name = new String[] {"tfsLgVO.LG_NBR", "tfsLgVO.DOC_YEAR", "tfsLgVO.DOC_NUMBER",
                        "lgStatusDesc", "tfsDocTypeDesc", "tfsLgVO.REQUISITION_NBR", "cifDesc", "cyBriefDesc",
                        "tfsLgVO.AMOUNT", "tfsLgVO.CIF", "tfsDocTypeDesc", "cyDecimalPt"};

                    colType = new String[] {"number", "number", "number", "text", "text", "text", "text",
                        "text", "number", "number", "text", "number"};

                    titles = new String[] {getText("LG_Nbr_key"), getText("Document_Year_key"),
                        getText("Document_Number_key"), getText("Status_key"),
                        getText("LG_Type_BriefName_key"), getText("Request_No_key"),
                        getText("Applicant_Name_key"), getText("Currency_key"), getText("Amount_key"),
                        getText("CIF_key"), getText("Type_key"), getText("Decimal_points_key")};
                }

            }
            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("LGs_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/LetterGuaranteeLookup_fillLetterGuaranteeLookup");

            List<LookupGridColumn> lgGridColumn = returnStandarColSpecs(name, colType, titles);

            for(int i = 0; i < name.length; i++)
            {
                if("tfsLgVO.DOC_NUMBER".equals(lgGridColumn.get(i).getName())
                    || "tfsLgVO.LG_NBR".equals(lgGridColumn.get(i).getName()))
                {
                    lgGridColumn.get(i).setLeadZeros("6");
                }
                else if("tfsLgVO.REQUISITION_NBR".equals(lgGridColumn.get(i).getName()))
                {
                    lgGridColumn.get(i).setLeadZeros("10");
                }
                else if("tfsLgVO.AMOUNT".equals(lgGridColumn.get(i).getName()))
                {
                    lgGridColumn.get(i).setFormatter("currencyFmatter");
                    lgGridColumn.get(i).setFormatCol("cyDecimalPt");
                }
                else if("tfsLgVO.CIF".equals(lgGridColumn.get(i).getName()))
                {
                    lgGridColumn.get(i).setLeadZeros("8");
                }
                else if("cyDecimalPt".equals(lgGridColumn.get(i).getName()))
                {
                    lgGridColumn.get(i).setHidden(true);
                }
            }
            lookup(grid, lgGridColumn, null, criteria);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructLookup of LetterGuaranteeLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;
    }

    /**
     * Fill Letter Guarantee
     * 
     * @author: ghenoiesaab
     * @PB: w_lookup_lg_issue (tfajv)
     * dw_lookup_lg_margin_ny (ora_tfa/syb_tfa)
     * dw_lookup_lg_margin (ora_tfa/syb_tfa)
     * dw_lookup_lg_issue_ny (ora_tfa/syb_tfa)
     */
    public String fillLetterGuaranteeLookup()
    {
        try
        {
            setSearchFilter(criteria);
            copyproperties(criteria);
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());
            criteria.setStatusLovType(ConstantsCommon.LG_STATUS_LOV_TYPE);
            criteria.setPreferredLanguage(sessionCO.getLanguage());

            if(checkNbRec(criteria))
            {
                setRecords(letterGuaranteeBO.returnLetterGuaranteeLookupCount(criteria));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(letterGuaranteeBO.returnLetterGuaranteeLookupList(criteria));
        }
        catch(Exception e)
        {
            log.error(e, "Error in fillLetterGuaranteeLookup of LetterGuaranteeLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * Construct LG Issuance Lookup
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     * @PB: w_lookup_lg (tfa06.pbl) - dw_lookup_lg (tfa05.pbl)
     */
    public String constructLgIssueLookup()
    {
        try
        {
            String[] name = null, colType = null, titles = null;

            // Design the Grid by defining the column model and column names
            name = new String[] {"tfsLgVO.REQUISITION_NBR", "lgStatusDesc", "tfsLgVO.CIF", "cifDesc",
                "cyBriefDesc", "tfsLgVO.AMOUNT", "tfsLgVO.DOC_DATE", "tfsLgVO.VALIDITY_FROM",
                "tfsLgVO.VALIDITY_TO", "tfsDocTypeDesc", "cyDecimalPt"};

            colType = new String[] {"number", "text", "number", "text", "text", "number", "date", "date",
                "date", "text", "number"};

            titles = new String[] {getText("Request_No_key"), getText("Status_key"), getText("CIF_key"),
                getText("Party_Name_key"), getText("Currency_key"), getText("Amount_key"),
                getText("Doc_date_key"), getText("ValidityFrom_key"), getText("ValidityTill_key"),
                getText("Type_key"), getText("Decimal_points_key")};

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("LG_Request_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/LetterGuaranteeLookup_fillLgIssueLookup");

            List<LookupGridColumn> lgGridColumn = returnStandarColSpecs(name, colType, titles);

            for(int i = 0; i < name.length; i++)
            {
                if("tfsLgVO.REQUISITION_NBR".equals(lgGridColumn.get(i).getName()))
                {
                    lgGridColumn.get(i).setLeadZeros("10");
                }
                else if("tfsLgVO.AMOUNT".equals(lgGridColumn.get(i).getName()))
                {
                    lgGridColumn.get(i).setFormatter("currencyFmatter");
                    lgGridColumn.get(i).setFormatCol("cyDecimalPt");
                }
                else if("cyDecimalPt".equals(lgGridColumn.get(i).getName()))
                {
                    lgGridColumn.get(i).setHidden(true);
                }
            }
            lookup(grid, lgGridColumn, null, criteria);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructLgIssueLookup of LetterGuaranteeLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;
    }

    /**
     * Fill LG Issuance Lookup
     * 
     * @author: BoushraFahs
     * @date: 13 May 2014
     * @PB: w_lookup_lg (tfa06.pbl) - dw_lookup_lg (tfa05.pbl)
     */
    public String fillLgIssueLookup()
    {
        try
        {
            setSearchFilter(criteria);
            copyproperties(criteria);
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());
            criteria.setIsRTLDir(sessionCO.getIsRTLDir());
            criteria.setPreferredLanguage(sessionCO.getLanguage());
            // from LG
            criteria.setStatusLovType(ConstantsCommon.LG_STATUS_LOV_TYPE);

            if(checkNbRec(criteria))
            {
                setRecords(letterGuaranteeBO.returnLgIssueLkpCount(criteria));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(letterGuaranteeBO.returnLgIssueLkpList(criteria));
        }
        catch(Exception e)
        {
            log.error(e, "Error in fillLgIssueLookup of LetterGuaranteeLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    public Object getModel()
    {
        return criteria;
    }

    public LetterGuaranteeSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(LetterGuaranteeSC criteria)
    {
        this.criteria = criteria;
    }

    public void setLetterGuaranteeBO(LetterGuaranteeBO letterGuaranteeBO)
    {
        this.letterGuaranteeBO = letterGuaranteeBO;
    }

}
