package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.accountcharges.AccountChargesProductsBO;
import com.path.dbmaps.vo.CTS_SAFEBOX_CHARGESVO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.accountcharges.AccountChargesSC;
import com.path.vo.core.cardsmanagement.CardsManagementSC;
import com.path.vo.core.certificatetypes.CertificateTypesSC;
import com.path.vo.core.cheque.ChequeSC;
import com.path.vo.core.lostfound.LostFoundSC;
import com.path.vo.core.passbook.PassbookSC;
import com.path.vo.core.reason.ReasonSC;

public class AccountChargesProductsLookupAction extends LookupBaseAction
{
    private AccountChargesSC criteria = new AccountChargesSC();
    private AccountChargesProductsBO accountChargesProductsBO;
    private List<CTS_SAFEBOX_CHARGESVO> safeboxVOList;
    
    @Override
    public Object getModel()
    {
    	return criteria;
    }
    
    public String constructLookup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    if(criteria.getProductType() == null)
	    {
		return null;
	    }
	    else if("CAR".equals(criteria.getProductType()))
	    {
		//Hasan Bug#475705 21/04/2017
		// Design the Grid by defining the column model and column names
		String[] name = { "STATUS_IDEN", "STATUS_ENG_DESC", "STATUS_AR_DESC", "STATUS_ACTION" };
		String[] colType = { "text", "text", "text", "text" };
		String[] titles = { getText("Status_Iden_key"), getText("status_key"), getText("status_key"),
			getText("status_action_key") };
		
		List<LookupGridColumn> listGridColumn = returnStandarColSpecs(name, colType, titles);

		for(int i = 0; i < name.length; i++)
		{
		    if("STATUS_ACTION".equals(listGridColumn.get(i).getName()))
		    {
			listGridColumn.get(i).setHidden(true);
		    }
		}

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("CardsStatusReasonList_key"));
		grid.setRowNum("5");
		grid.setUrl("/path/cardsManagement/CardsStatusReason_fillCardsStatusReasonLookup?statusAction1=AC");

		CardsManagementSC cardsManagementSC = new CardsManagementSC();
		cardsManagementSC.setCompCode(sessionCO.getCompanyCode());

//		lookup(grid, cardsManagementSC, name, colType, titles);
		lookup(grid, listGridColumn, null, criteria);
	    }
	    else if("SB_R".equals(criteria.getProductType()) || "SB_I".equals(criteria.getProductType())
		    || "SB_RI".equals(criteria.getProductType()) || "SB_P".equals(criteria.getProductType())
		    || "SB_S".equals(criteria.getProductType()) || "SB_RN".equals(criteria.getProductType())
		    ||  "SAF".equals(criteria.getProductType()))//HUSSEIN-SEGMENTATION 
	    {
		// Design the Grid by defining the column model and column names
		String[] name = { "CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "PERIODICITY", "PERIODICITY_TYPE",
			"CHARGES", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
		String[] colType = { "number", "text", "text", "number", "text", "number", "text", "text" };
		String[] titles = { getText("code_key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key"),
			getText("periodicity_key"), getText("periodicity_type_key"), getText("charges_key"),
			getText("Short_Name_Arab_key"), getText("Long_Name_Arab_key") };

		if(returnSessionObject().getHideArabicColumns())
		{
		    name = new String[] { "CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "PERIODICITY", "PERIODICITY_TYPE",
			    "CHARGES" };
		    colType = new String[] { "number", "text", "text", "number", "text", "number" };
		    titles = new String[] { getText("code_key"), getText("Short_name_eng_key"),
			    getText("Long_Name_eng_key"), getText("periodicity_key"), getText("periodicity_type_key"),
			    getText("charges_key") };
		}

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("safebox_key"));
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/AccountChargesProductsLookupAction_loadSafeboxChargesLookup");
		lookup(grid, criteria, name, colType, titles);

	    }
	    else if("L".equals(criteria.getProductType()))
	    {
		String[] name = { "DOC_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB" };
		String[] colType = { "number", "text", "text" };
		String[] titles = { getText("Document_Code_key"), getText("Lkp_Document_Desc_En_key"),
			getText("Lkp_Document_Desc_Ar_key") };
		/**
		 * Defining The Grid ...
		 */
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("Lkp_Document_Type_Caption_key"));
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/LostFoundLookup_loadDocTypeLookup");

		LostFoundSC lostFoundSC = new LostFoundSC();
		lostFoundSC.setCompCode(sessionCO.getCompanyCode());

		lookup(grid, criteria, name, colType, titles);
	    }
	    else if("CER".equals(criteria.getProductType()))
	    {
		// Types the Grid by defining the column model and column names
		String[] name = { "CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB" };
		String[] colType = { "number", "text", "text" };
		String[] titles = { getText("Code__key"), getText("Brief_Description_key"),
			getText("Brief_Desc_Arab_key") };

		if(returnSessionObject().getHideArabicColumns())
		{
		    name = new String[] { "CODE", "BRIEF_DESC_ENG" };
		    colType = new String[] { "number", "text" };
		    titles = new String[] { getText("Code__key"), getText("Brief_Description_key") };
		}

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("TypesList"));
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/CertificateTypeLookup_fillCertificateLkp");

		CertificateTypesSC certificateTypesSC = new CertificateTypesSC();
		certificateTypesSC.setCompCode(sessionCO.getCompanyCode());

		lookup(grid, certificateTypesSC, name, colType, titles);
	    }
	    else if("PAS".equals(criteria.getProductType()))
	    {
		// Design the Grid by defining the column model and column names
		String[] name = { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB",
			"PASSBOOK_LAYOUT" };
		String[] colType = { "number", "text", "text", "text", "text", "text" };
		String[] titles = { getText("Code_key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key"),
			getText("Short_Name_Arab_key"), getText("Long_Name_Arab_key"), getText("Passbook_Layout_key") };

		/*
		 * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
		 * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
		 * Arabic Visible and Mandatory And English Mandatory , 3=
		 * Arabic Visible and Mandatory English Not Mandatory).
		 */
		if(returnSessionObject().getHideArabicColumns())
		{
		    name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "PASSBOOK_LAYOUT" };
		    colType = new String[] { "number", "text", "text", "text" };
		    titles = new String[] { getText("Code_key"), getText("Short_name_eng_key"),
			    getText("Long_Name_eng_key"), getText("Passbook_Layout_key") };
		}

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("Passbook_key"));
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/PassbookLookup_fillPassbookLookup");

		PassbookSC passbookSC = new PassbookSC();
		passbookSC.setCompCode(sessionCO.getCompanyCode());

		lookup(grid, passbookSC, name, colType, titles);
	    }
	    else if("CHQ".equals(criteria.getProductType()))
	    {
		String[] name = { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB" };
		String[] colType = { "number", "text", "text", "text" };
		String[] titles = { getText("cheque_code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key"), getText("Brief_Desc_Arab_key") };

		/*
		 * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
		 * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
		 * Arabic Visible and Mandatory And English Mandatory ,3= Arabic
		 * Visible and Mandatory English Not Mandatory).
		 */
		if(returnSessionObject().getHideArabicColumns())
		{
		    name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
		    colType = new String[] { "number", "text", "text" };
		    titles = new String[] { getText("cheque_code_key"), getText("Brief_Desc_Eng_key"),
			    getText("Long_Desc_Eng_key") };
		}
		/**
		 * Defining The Grid ...
		 */
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("cheque_code_key"));
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/ChequeLookupAction_loadChequeLookup");

		ChequeSC chequeSC = new ChequeSC();
		chequeSC.setCompCode(sessionCO.getCompanyCode());

		lookup(grid, chequeSC, name, colType, titles);
	    }
	    else if("VR".equals(criteria.getProductType()))
	    {
		String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB" };
		String[] colType = { "number", "text", "text" };

		String[] titles = { getText("Code__key"), getText("Lkp_Reason_En_key"), getText("Lkp_Reason_Ar_key") };

		/*
		 * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
		 * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
		 * Arabic Visible and Mandatory And English Mandatory , 3=
		 * Arabic Visible and Mandatory English Not Mandatory).
		 */
		if(returnSessionObject().getHideArabicColumns())
		{
		    name = new String[] { "CODE", "BRIEF_NAME_ENG" };
		    colType = new String[] { "text", "text" };
		    titles = new String[] { "", getText("Lkp_Reason_En_key") };
		}
		/**
		 * Defining The Grid ...
		 */
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("Lkp_Reason_Caption_key"));
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/ReasonLookup_loadReasonLookup?reason_type=" + "1");

		List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(name, colType, titles);
		lsGridColumn.get(0).setHidden(true);
		lsGridColumn.get(0).setHidden(false);
		lsGridColumn.get(0).setWidth("100");

		ReasonSC reasonSC = new ReasonSC();
		reasonSC.setCompCode(sessionCO.getCompanyCode());

		lookup(grid, lsGridColumn, null, reasonSC);
	    }
	    //Hasan #502702 21/01/2017
	    else if("REQ".equals(criteria.getProductType()))
	    {
		// Design the Grid by defining the column model and column names
		String[] name = { "CODE", "APP_NAME", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB" };
		String[] colType = { "number", "text", "text", "text" };
		String[] titles = { getText("Code__key"), getText("APPLICATION_NAME_key"), getText("Brief_Name_key"),
			getText("Brief_Name_Arab_key") };

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/CtsRequestTypeLookup_fillCtsRequestTypeLookup?appName=@");
		lookup(grid, criteria, name, colType, titles);
	    }
	    else if("TRX".equals(criteria.getProductType()) || "SO".equals(criteria.getProductType()))
	    {
		    // Design the Grid by defining the column model and column names
		    String[] name = {"CODE",
			    "SHORT_DESC_ENG",
			    "LONG_DESC_ENG",
			    "SHORT_DESC_ARAB",
			    "LONG_DESC_ARAB",
		    "REFERENCE"};
		    String[] colType = { "text", "text", "text", "text", "text", "text"};
		    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
			    getText("Brief_Desc_Arab_key"),getText("Long_Desc_Arab_key"), getText("_Reference_key")};
		    
		    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
		       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
			, 3= Arabic Visible and Mandatory English Not Mandatory). */
		    if(returnSessionObject().getHideArabicColumns())
		    {
			name = new String[] {"CODE",
	        			    "SHORT_DESC_ENG",
	        			    "LONG_DESC_ENG",
	        		    		"REFERENCE"};
			colType = new String[] { "text", "text", "text", "text"};
			titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
				                getText("_Reference_key")};
		    }

		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Trx_Type_key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/CtsTrxTypeLookup_fillTrxTypeLookup");
		    lookup(grid, criteria, name, colType, titles);
		
	    }
	    else if("AMC".equals(criteria.getProductType()))
	    {
		    // Design the Grid by defining the column model and column names
		    String[] name = {"CODE",
	                             "BRIEF_NAME_ENG",
	                             "BRIEF_NAME_ARAB",
	                             "LONG_NAME_ENG",
	                             "LONG_NAME_ARAB",
	                             "PERIODICITY",
	                             "PERIODICITY_TYPE"
	                            };
		    String[] colType = { "number", "text", "text", "text", "text","text","text"};
		    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
		    		getText("Long_Desc_Eng_key"), getText("Long_Desc_Arab_key"), "", getText("Periodicity__key")};

		    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
		       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
			, 3= Arabic Visible and Mandatory English Not Mandatory). */
		    if(returnSessionObject().getHideArabicColumns())
		    {
			name = new String[] {"CODE",
	                                    "BRIEF_NAME_ENG",
	                                    "LONG_NAME_ENG",
	                                    "PERIODICITY",
	                                    "PERIODICITY_TYPE" };
			colType = new String[] { "number", "text", "text", "text", "text"};
			titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
		    		getText("Long_Desc_Eng_key"), "", getText("Periodicity__key")};
		    }

		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Lookup/Query_Charges_key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/ChargesFeesPolicyLookup_fillChargesFeesPolicyLookup");
		    List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(name, colType, titles);
		    if(name.length == 7)
		    {
			lsGridColumn.get(5).setHidden(true); // Periodicity is Hidden
		    }
		    else
		    {
			lsGridColumn.get(3).setHidden(true); // Periodicity is Hidden
		    }
		    lookup(grid, lsGridColumn, null, criteria);
		}
	    
	    
	    

	}
	catch(Exception e)
	{
	    log.error(e, "Error in construct Lookup of Account Charges Products Lookup Action");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    public String loadSafeboxChargesLookup()
    {
    	try
    	{
    		setSearchFilter(criteria);
    	    copyproperties(criteria);
    	    SessionCO sessionCO = returnSessionObject();
    	    criteria.setCompCode(sessionCO.getCompanyCode());
    	    setRecords(accountChargesProductsBO.loadSafeboxChargesLookupCount(criteria));
    	    safeboxVOList = accountChargesProductsBO.loadSafeboxChargesLookup(criteria);
    	    setGridModel(safeboxVOList);
    	}
		catch(Exception e)
		{
		    log.error(e, "Error in filling data in Lookup of Account Charges Products Lookup Action");
		    handleException(e, null, null);
		}
    	return SUCCESS;
    }

    public AccountChargesSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(AccountChargesSC criteria)
    {
        this.criteria = criteria;
    }

	public List<CTS_SAFEBOX_CHARGESVO> getSafeboxVOList() {
		return safeboxVOList;
	}

	public void setSafeboxVOList(List<CTS_SAFEBOX_CHARGESVO> safeboxVOList) {
		this.safeboxVOList = safeboxVOList;
	}
	
	public void setAccountChargesProductsBO(AccountChargesProductsBO accountChargesProductsBO)
    {
		this.accountChargesProductsBO = accountChargesProductsBO;
    }
}
