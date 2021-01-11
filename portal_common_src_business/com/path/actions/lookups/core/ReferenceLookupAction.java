package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.reference.ReferenceBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.reference.ReferenceCO;
import com.path.vo.core.reference.ReferenceSC;

public class ReferenceLookupAction extends LookupBaseAction
{

    private ReferenceBO referenceBO;
    private ReferenceSC referenceSC = new ReferenceSC();
    private List<ReferenceCO> referenceCOList;

    @Override
    public Object getModel()
    {
	return referenceSC;
    }
    /**
     * Construct Reference Lookup based on the VO returned in the resultMap.
     *
     * @return
     */

    public String constructLookup()
    {
    	if("1".equals(referenceSC.getProductType()))
	{
	    ConstructLookupLcIssue();
	}
	else if("2".equals(referenceSC.getProductType()))
	{
	    ConstructLookupLgIssue();
	}
	else if("3".equals(referenceSC.getProductType()))
	{
	    ConstructLookupBc();
	}
	else if("4".equals(referenceSC.getProductType()))
    	{
	    ConstructLookupDealNo();
    	}
	return SUCCESS;
    }
//    w_lookup_lc_issue
	private void ConstructLookupLcIssue() {
		try
		{
		    // Design the Grid by defining the column model and column names
		    String[] name = { "LC_REFERENCE_NBR", "LC_STATUS", "LC_REFERENCE_YEAR", "LC_REFERENCE_TYPE", "LC_NBR" , "CIF", "LC_CURRENCY", "BRIEF_DESC_ENG", "LC_AMOUNT", "SETTLEMENT_METHOD", "APPLICATION_DATE", "VALIDITY_FROM", "VALIDITY_TO", "MARGIN_REQUIRED"};
		    String[] colType = { "number", "text", "number", "text", "number", "number", "number", "text", "number","text", "date","date","date","number"};
		    String[] titles = { getText("LC_Ref_Nbr_key"), getText("Status_key"), getText("Year_key"),
			    getText("Type_key"),  getText("LC_Request_Nbr_key"),getText("CIF_key"),getText("Party_key"),getText("CY_Code_key"),getText("CY_Name_key"),getText("Amount_key"),getText("Settlement_Method_key"),getText("ApplicationDate_key"),getText("ValidityFrom_key"),getText("ValidityTo_key") };
		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Lookup/Query__For_Reference_key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/Reference_fillReferenceLCLookup");
		   /* int cols = name.length;
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
		    lookup(grid, lsGridColumn, null, referenceSC);
		    */
		    lookup(grid,referenceSC,name,colType,titles);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
	}

//  w_lookup_lg_issue *****************************
	private void ConstructLookupLgIssue() {
		try
		{
		    // Design the Grid by defining the column model and column names
		    String[] name = { "LG_NBR", "REQUISITION_NBR", "LG_STATUS", "CIF",  "CURRENCY", "AMOUNT","DOC_DATE","VALIDITY_FROM","VALIDITY_TO", "DOC_NUMBER", "DOC_YEAR", "BRIEF_DESC_ENG", "DECIMAL_POINTS", "SHORT_NAME_ENG", "BRIEF_NAME_ENG", "MARGIN_REQUIRED"};
		    String[] colType = {"number", "number", "text", "number", "number", "number","date","date","date","number","number", "text", "number", "text" ,"text","number"};
		    String[] titles = { getText("LG_Nbr_key"), getText("Doc_year_key"), getText("Doc_no_key"),
			    getText("Status_key"),  getText("LG_Type_BriefName_key"),getText("Requisition_Nbr_key"),
			    "date1","date2","date3",
			    getText("Applicant_Name_key"),getText("CY_Name_key"),getText("Amount_key"),getText("Doc_date_key"),getText("ValidityFrom_key"),getText("ValidityTill_key"),getText("Cif_key")};
		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Lookup/Query_For_ReferenceLG_key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/Reference_fillReferenceLGLookup");
		  /*  int cols = name.length;
		    for(int i = 0; i < cols; i++)		    {
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
		    lookup(grid, lsGridColumn, null, referenceSC);
		    */
		    lookup(grid,referenceSC,name,colType,titles);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
	}

//  w_lookup_BC *****************************
	private void ConstructLookupBc() {
		try
		{
		    // Design the Grid by defining the column model and column names
		    String[] name = { "BILL_TYPE", "BILL_NBR", "BILL_DATE", "PARTY_BANK_CIF", "SHORT_NAME_ENG" , "CUSTOMER_CIF", "SHORT_NAME_ENG", "PAY_METHOD", "PAY_FACILITY_NO", "CURRENCY", "STATUS", "BANK_DEF_CIF", "BRIEF_DESC_ENG", "DOC_NUMBER", "DOC_YEAR", "AMOUNT" , "MANUAL_REFERENCE"};
		    String[] colType = {"text", "number", "date","number","text","number","text","text","number","number","text","number","text","numeric","number","number","text"};
		    String[] titles = { getText("Bill_Type_key"), getText("Bill_No_key"), getText("Bill_Date_key"),
			    getText("Party_Bank_CIF_key"),  getText("Short_name_eng_key"),getText("Customer_CIF_key"),getText("Short_name_eng_key"),getText("CustomerName_key"),getText("Pay_Method_key"),getText("Pay_Facility_No_key"),getText("Currency_Status_key"),getText("BankDef_cif_key"),getText("Brief_Desc_Eng_key"),getText("Doc_no_key"),getText("Doc_year_key"),getText("Amount_key"),getText("Manuel_Reference_key")};
		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Lookup/Query__For_ReferenceBC_key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/Reference_fillReferenceBCLookup");
		   /* int cols = name.length;
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
		    lookup(grid, lsGridColumn, null, referenceSC);
		    */
		    lookup(grid,referenceSC,name,colType,titles);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
	}

//  w_lookup_Deal No *****************************
	private void ConstructLookupDealNo() {
		try
		{
		    // Design the Grid by defining the column model and column names
		    String[] name = { "SERIAL_NO", "VALUE_DATE", "MATURITY_DATE", "CIF_NO"};
		    String[] colType = {"number", "date", "date", "number"};
		    String[] titles = { getText("Deal_No_key"), getText("Counter_Party_key"), getText("Value_Date_key"), getText("Maturity_Date_key")};
		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Lookup/Query__For_ReferenceDeal_key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/Reference_fillReferenceDealLookup");
		   /* int cols = name.length;
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
		    lookup(grid, lsGridColumn, null, referenceSC);
		    */

		    lookup(grid,referenceSC,name,colType,titles);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
	}

    /**
     * Fill the lookup for ReferenceLC Lookup data filtered by the defined criteria
     *
     * @return
     */
    public String fillReferenceLCLookup()
    {
	try
	{
	    setSearchFilter(referenceSC);
	    copyproperties(referenceSC);
	    SessionCO sessionCO = returnSessionObject();
	    referenceSC.setCompCode(sessionCO.getCompanyCode());
	    referenceSC.setBranchCode(referenceSC.getLinkBranchNo());
	    if(checkNbRec(referenceSC))
	    {
	    	setRecords(referenceBO.referenceListCount(referenceSC));
	    }
	    referenceCOList = referenceBO.referenceList(referenceSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(referenceCOList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of ReferenceLCLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup for ReferenceLG Lookup data filtered by the defined criteria
     *
     * @return
     */
    public String fillReferenceLGLookup()
    {
	try
	{
	    setSearchFilter(referenceSC);
	    copyproperties(referenceSC);
	    SessionCO sessionCO = returnSessionObject();
	    referenceSC.setCompCode(sessionCO.getCompanyCode());
	    referenceSC.setBranchCode(referenceSC.getLinkBranchNo());
	    referenceSC.setRaType("O");
	    referenceSC.setIv_crud("N");
	    if(checkNbRec(referenceSC))
	    {
	    	setRecords(referenceBO.referenceLGListCount(referenceSC));
	    }
	    referenceCOList = referenceBO.referenceLGList(referenceSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(referenceCOList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of ReferenceLGLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    /**
     * Fill the lookup for ReferenceBC Lookup data filtered by the defined criteria
     *
     * @return
     */
    public String fillReferenceBCLookup()
    {
	try
	{
	    setSearchFilter(referenceSC);
	    copyproperties(referenceSC);
	    SessionCO sessionCO = returnSessionObject();
	    referenceSC.setCompCode(sessionCO.getCompanyCode());
	    referenceSC.setBranchCode(referenceSC.getLinkBranchNo());
	    referenceSC.setBillType("N");
	    if(checkNbRec(referenceSC))
	    {
	    	setRecords(referenceBO.referenceBCListCount(referenceSC));
	    }
	    referenceCOList = referenceBO.referenceBCList(referenceSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(referenceCOList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of ReferenceBCLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    /**
     * Fill the lookup for ReferenceDeal Lookup data filtered by the defined criteria
     *
     * @return
     */
    public String fillReferenceDealLookup()
    {
	try
	{
	    setSearchFilter(referenceSC);
	    copyproperties(referenceSC);
	    SessionCO sessionCO = returnSessionObject();
	    referenceSC.setCompCode(sessionCO.getCompanyCode());
	    referenceSC.setBranchCode(referenceSC.getLinkBranchNo());
	    if(checkNbRec(referenceSC))
	    {
	    	setRecords(referenceBO.referenceDealListCount(referenceSC));
	    }
	    referenceCOList = referenceBO.referenceDealList(referenceSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(referenceCOList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of ReferenceDealLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    /**
     * Construct Forex Deal Lookup
     *
     * @author: BoushraFahs
     * @date: 23 Jan 2014
     * @PB: w_lookup_fx_deal (tfa06)/ dw_lookup_fx_deal (tfa06)
     */
    public String constructFxDealLkp()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"trsDealVO.BRANCH_CODE", "trsDealVO.SERIAL_NO", "trsDealVO.PROMISSORY_FX_NO",
                "dealCyDesc", "trsDealVO.DEAL_AMOUNT", "trsDealVO.FORWARD_RATE", "otherCyDesc",
                "trsDealVO.OTHER_AMOUNT", "outstandSold", "outstandBought", "dealCyDecPnts"};

            String[] colType = {"number", "number", "number", "text", "number", "number", "text", "number",
                "number", "number", "number"};

            String[] titles = {getText("PFX_Branch_key"), getText("Deal_Nbr_key"), getText("PFX_Nbr_key"),
                getText("Sold_Cy_key"), getText("Deal_Sold_Amt_key"), getText("Rate_key"),
                getText("Bought_Cy_key"), getText("Bought_Amt_key"), getText("Outstanding_Deal_Sold_Amt_key"),
                getText("Outstanding_Deal_Bought_Amt_key"), getText("dealCyDecPnts")};

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("Forex_Deal_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/Reference_fillFxDealLookup");
            List<LookupGridColumn> fxGridColumn = returnStandarColSpecs(name, colType, titles);
            for(int i = 0; i < name.length; i++)
            {
                if("trsDealVO.BRANCH_CODE".equals(fxGridColumn.get(i).getName()))
                {
                    fxGridColumn.get(i).setLeadZeros("4");
                }
                else if("trsDealVO.SERIAL_NO".equals(fxGridColumn.get(i).getName())
                    || "trsDealVO.PROMISSORY_FX_NO".equals(fxGridColumn.get(i).getName()))
                {
                    fxGridColumn.get(i).setLeadZeros("12");
                }
                else if("trsDealVO.DEAL_AMOUNT".equals(fxGridColumn.get(i).getName())
                    || "outstandSold".equals(fxGridColumn.get(i).getName())
                    || "outstandBought".equals(fxGridColumn.get(i).getName()))
                {
                    fxGridColumn.get(i).setFormatter("currencyFmatter");
                    fxGridColumn.get(i).setFormatCol("dealCyDecPnts");
                }
                else if("trsDealVO.FORWARD_RATE".equals(fxGridColumn.get(i).getName()))
                {
                    fxGridColumn.get(i).setNbFormat("#.#####0");
                }
                else if("dealCyDecPnts".equals(fxGridColumn.get(i).getName()))
                {
                    fxGridColumn.get(i).setHidden(true);
                }
            }
            lookup(grid, fxGridColumn, null, referenceSC);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructFxDealLkp of ReferenceDealLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;
    }

    /**
     * Fill Forex Deal Lookup
     *
     * @author: BoushraFahs
     * @date: 23 Jan 2014
     * @PB: w_lookup_fx_deal (tfa06)/ dw_lookup_fx_deal (tfa06)
     */
    public String fillFxDealLookup()
    {
        try
        {
            setSearchFilter(referenceSC);
            copyproperties(referenceSC);
            SessionCO sessionCO = returnSessionObject();
            referenceSC.setCompCode(sessionCO.getCompanyCode());
            if(BigDecimal.ZERO
                .compareTo(NumberUtil.nullEmptyToValue(referenceSC.getFromNbr(), BigDecimal.ZERO)) == 0)
            {
                referenceSC.setBranchCode(sessionCO.getBranchCode());
            }
            else
            {
                referenceSC.setBranchCode(referenceSC.getFromNbr());
            }
            referenceSC.setPreferredLanguage(sessionCO.getLanguage());
            referenceSC.setTrxDate(sessionCO.getRunningDateRET());
            referenceSC.setTrx(BigDecimal.ZERO);

            if(checkNbRec(referenceSC))
            {
                setRecords(referenceBO.returnFxDealLkpCount(referenceSC));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(referenceBO.returnFxDealLkpList(referenceSC));
        }
        catch(Exception e)
        {
            log.error(e, "Error in fillFxDealLookup of ReferenceDealLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }


    public ReferenceSC getReferenceSC()
    {
	return referenceSC;
    }

    public void setReferenceSC(ReferenceSC referenceSC)
    {
	this.referenceSC = referenceSC;
    }

	public void setReferenceBO(ReferenceBO referenceBO) {
		this.referenceBO = referenceBO;
	}

}
