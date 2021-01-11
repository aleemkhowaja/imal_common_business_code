/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.account.AccountsConstant;
import com.path.bo.core.cif.CifBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.admin.companies.CompaniesCO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.ciftrxtypelimit.CifTrxTypeLimitCO;

/**
 * @author MarwanMaddah
 * 
 */
public class CifLookupAction extends LookupBaseAction
{
    private CifSC criteria = new CifSC();
    private CifBO cifBO;
    private String lookupCallingScreen;
    private String type, utilityPayment;

    /**
     * 
     */
    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * Construct CIF Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "BRANCH_CODE", "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG",
		    "SHORT_NAME_ARAB", "LONG_NAME_ARAB", "FULL_NAME_ARAB", "TEL", "DESCR", "ID_NO", "CIF_TYPE", "CIF_TYPE_DESC",
		    "ADDITIONAL_REFERENCE", "COUNTRY", "COUNTRY_DESC" };
	    String[] colType = { "number", "number", "text", "text", "text", "text", "text", "text", "text", "text",
		    "text", "text", "text", "text", "number", "text" };

	    String[] titles = { getText("Branch_code_key"), getText("CIF_No_key"), getText("Short_Name_key"),

		    getText("Long_Name__key"), getText("Full_Name_key"), getText("Short_Name_Arab_key"),
		    getText("Long_Name_Arab_key"), getText("Full_Name_Arab_key"), getText("Tel_key"),
		    getText("Resident_key"), getText("Id_No_key"), getText("Cif_Type_key"), getText("Cif_Type_Description_key"),
		    getText("Additional_Reference_key"), getText("Country_key"), getText("country_desc_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "BRANCH_CODE", "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG",
			"TEL", "DESCR", "ID_NO", "CIF_TYPE", "CIF_TYPE_DESC", "ADDITIONAL_REFERENCE", "COUNTRY", "COUNTRY_DESC" };
		colType = new String[] { "number", "number", "text", "text", "text", "text", "text", "text", "text", "text",
			"text", "number", "text"};
		;

		titles = new String[] { getText("Branch_code_key"), getText("CIF_No_key"), getText("Short_Name_key"),

			getText("Long_Name__key"), getText("Full_Name_key"), getText("Tel_key"),
			getText("Resident_key"), getText("Id_No_key"), getText("Cif_Type_key"), getText("Cif_Type_key"),
			getText("Additional_Reference_key"), getText("Country_key"), getText("Country_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifLookup");

	    List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
	    columnSpecs.get(0).setLeadZeros("4");
	    columnSpecs.get(1).setLeadZeros("8");

	    lookup(grid, columnSpecs, null, criteria);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Construct CIF Lookup Query based on the VO returned in the resultMap.
     * 
     * @return
     */

    public String constructCifQueryLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "BRANCH_CODE", "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG",
		    "ADDITIONAL_REFERENCE", "TEL", "ECO_SECTOR", "RELATION_CODE", "COUNTRY", "ID_NO", "ID_NO2",
		    "CIF_TYPE", "ONE_OBLIGOR", "EMAIL_ID", "SEXE", "SHORT_NAME_ARAB", "LONG_NAME_ARAB",
		    "FULL_NAME_ARAB", "CARD_NAME", "NICK_NAME", "STATUS", };
	    String[] colType = { "number", "number", "text", "text", "text", "text", "text", "text", "text", "text",
		    "text", "text", "text", "text", "text", "text", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Branch_key"), getText("CIF_No_key"), getText("Short_name_eng_key"),
		    getText("Long_Name_eng_key"), getText("Full_Name_key"), getText("Additional_Reference_key"),
		    getText("Tel_key"), getText("Eco_Sector_key"), getText("Relation_key"), getText("Country_key"),
		    getText("Id_No_key"), getText("Id_No_key"), getText("Cif_Type_key"), getText("One_Obligor_key"),
		    getText("Email_Id_key"), getText("Gender_key"), getText("Short_Name_Arab_key"),
		    getText("Long_Name_Arab_key"), getText("Full_Name_Arab_key"), getText("Card_Name_key"),
		    getText("Nick_Name_key"), getText("Status_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "BRANCH_CODE", "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG",
			"ADDITIONAL_REFERENCE", "TEL", "ECO_SECTOR", "RELATION_CODE", "COUNTRY", "ID_NO", "ID_NO2",
			"CIF_TYPE", "ONE_OBLIGOR", "EMAIL_ID", "SEXE", "CARD_NAME", "NICK_NAME", "STATUS" };
		colType = new String[] { "number", "number", "text", "text", "text", "text", "text", "text", "text",
			"text", "text", "text", "text", "text", "text", "text", "text", "text", "text" };
		titles = new String[] { getText("Branch_key"), getText("CIF_No_key"), getText("Short_name_eng_key"),
			getText("Long_Name_eng_key"), getText("Full_Name_key"), getText("Additional_Reference_key"),
			getText("Tel_key"), getText("Eco_Sector_key"), getText("Relation_key"), getText("Country_key"),
			getText("Id_No_key"), getText("Id_No_key"), getText("Cif_Type_key"), getText("One_Obligor_key"),
			getText("Email_Id_key"), getText("Gender_key"), getText("Card_Name_key"),
			getText("Nick_Name_key"), getText("Status_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifLookupQuery");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String constructCifCertLkp() // For Certificate CIF Lkp
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "BRANCH_CODE", "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG",
		    "SHORT_NAME_ARAB", "LONG_NAME_ARAB", "FULL_NAME_ARAB" };
	    String[] colType = { "text", "text", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Branch_code_key"), getText("CIF_No_key"), getText("Short_Name_key"),
		    getText("Long_Name__key"), getText("Full_Name_key"), getText("Short_Name_Arab_key"),
		    getText("Long_Name_Arab_key"), getText("Full_Name_Arab_key") };

	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "BRANCH_CODE", "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG" };
		colType = new String[] { "text", "text", "text", "text", "text" };
		titles = new String[] { getText("Branch_code_key"), getText("CIF_No_key"), getText("Short_Name_key"),
			getText("Long_Name__key"), getText("Full_Name_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifCertiLkp");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillCifCertiLkp()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setGI_VERSION(BigDecimal.ONE);
	    criteria.setGMI_FLAG("X");
	    criteria.setRaType("X");
	    //Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]
	    if(getRecords() == 0)
	    {
		setRecords(cifBO.cifListCountCert(criteria));
	    }
	    setGridModel(cifBO.cifListCert(criteria));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct BANK_CIF Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */
    public String constructBankCIFLookup()
    {
	if(TrxMgntConstant.TRANSFER.equals(type) && "1".equals(utilityPayment))
	{
	    return constructCifBenefLkp();
	}
	else
	{
	    return constructCifQueryLookup();
	}
    }

    /**
     * triggered from CORR_BANK
     * 
     * @return
     * @throws BaseException
     */
    public String constructCorrBankLookup() throws BaseException
    {
	criteria.setCompCode(returnSessionObject().getCompanyCode());
	CTSTRXTYPEVO ctsTrxType = cifBO.returnCorrBankLookupData(criteria);
	if((ctsTrxType != null && "0".equals(ctsTrxType.getSHOW_ALL_BANK_CIF()))
		&& (TrxMgntConstant.TRANSFER.equals(ctsTrxType.getTYPE()))
		&& (TrxMgntConstant.TRSFR_TYPE_LOCAL.compareTo(ctsTrxType.getTRSFR_TYPE()) == 0
			|| TrxMgntConstant.TRSFR_TYPE_INTERNATIONAL.compareTo(ctsTrxType.getTRSFR_TYPE()) == 0))
	{
	    return constructCifBenefLkp();
	}
	return bankCifLookup();
    }

    public String constructBenefBankLookup() throws BaseException
    {
	criteria.setCompCode(returnSessionObject().getCompanyCode());
	CTSTRXTYPEVO ctsTrxType = cifBO.returnCorrBankLookupData(criteria);

	if((ctsTrxType != null && ((TrxMgntConstant.TRANSFER.equals(ctsTrxType.getTYPE())
		&& (TrxMgntConstant.TRSFR_TYPE_LOCAL.compareTo(ctsTrxType.getTRSFR_TYPE()) == 0
			|| TrxMgntConstant.TRSFR_TYPE_INTERNATIONAL.compareTo(ctsTrxType.getTRSFR_TYPE()) == 0)))
		|| "1".equals(ctsTrxType.getFILTER_BENEF()))
		&& (!"1".equals(ctsTrxType.getFILTER_BENEF()) || "1".equals(ctsTrxType.getSEND_SWIFT())))
	{
	    return constructCifBenefLkp();
	}

	return bankCifLookup();
    }

    public String constructIntermBankLookup() throws BaseException
    {
	criteria.setCompCode(returnSessionObject().getCompanyCode());
	CTSTRXTYPEVO ctsTrxType = cifBO.returnCorrBankLookupData(criteria);

	if(ctsTrxType != null && ((TrxMgntConstant.TRANSFER.equals(ctsTrxType.getTYPE())
		&& (TrxMgntConstant.TRSFR_TYPE_LOCAL.compareTo(ctsTrxType.getTRSFR_TYPE()) == 0
			|| TrxMgntConstant.TRSFR_TYPE_INTERNATIONAL.compareTo(ctsTrxType.getTRSFR_TYPE()) == 0))))

	{

	    return constructCifBenefLkp();

	}
	return bankCifLookup();
    }

    /**
     * @author eliasaoun PB : n_transaction / uf_dw_main_rbuttondown /
     *         w_lookup_corr_bank Construct bank lookup in Non financial Info
     *         screen
     */
    public String constructCifBenefLkp()
    {
	// todo in some conditions it appears as w_lookup_bankcif
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[][] cols = { { "cifTrxtypeLimitVO.CIF_NO", "number", getText("CIF_No_key") },
		    { "cifVO.SHORT_NAME_ENG", "text", getText("CIF_Short_Name_key") },
		    { "cif_EXTENDEDVO.FULL_NAME_ENG", "text", getText("Full_Name_key") },
		    { "cifVO.SHORT_NAME_ARAB", "text", getText("CIF_Short_Name_Arab_key") },
		    { "NICK_NAME", "text", getText("Nick_Name_key") },
		    { "cif_EXTENDEDVO.FULL_NAME_ARAB", "text", getText("Full_Name_Arab_key") },
		    { "cifTrxtypeLimitVO.ACC_BR", "number", getText("Acc_Br_key") },
		    { "cifTrxtypeLimitVO.ACC_CY", "number", getText("Acc_Cy_key") },
		    { "cifTrxtypeLimitVO.ACC_GL", "number", getText("Acc_GL_key") },
		    { "cifTrxtypeLimitVO.ACC_CIF", "number", getText("Acc_CIF_key") },
		    { "cifTrxtypeLimitVO.ACC_SL", "number", getText("Acc_SL_key") },
		    { "AMF_BRIEF_NAME_ENG", "text", getText("Brief_Name_key") },
		    { "AMF_BRIEF_NAME_ARAB", "text", getText("Brief_Name_Arab_key") } };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		cols = new String[][] { { "cifTrxtypeLimitVO.CIF_NO", "number", getText("CIF_No_key") },
			{ "CIF_SHORT_NAME_ENG", "text", getText("CIF_Short_Name_key") },
			{ "CIF_EXTENDED.FULL_NAME_ENG", "text", getText("Full_Name_key") },
			{ "NICK_NAME", "text", getText("Nick_Name_key") },
			{ "cifTrxtypeLimitVO.ACC_BR", "number", getText("Acc_Br_key") },
			{ "cifTrxtypeLimitVO.ACC_CY", "number", getText("Acc_Cy_key") },
			{ "cifTrxtypeLimitVO.ACC_GL", "number", getText("Acc_GL_key") },
			{ "cifTrxtypeLimitVO.ACC_CIF", "number", getText("Acc_CIF_key") },
			{ "cifTrxtypeLimitVO.ACC_SL", "number", getText("Acc_SL_key") },
			{ "AMF_BRIEF_NAME_ENG", "text", getText("Brief_Name_key") }, };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifBenefLkp");
	    lookup(grid, criteria, cols);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @author eliasaoun called from : constructCifBenefLkp()
     */
    public String fillCifBenefLkp()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setComp_code(sessionCO.getCompanyCode());

	    if(ConstantsCommon.FALSE.equals(criteria.getCorrBankLkp())
		    && (criteria.getAccNo() == null || "".equals(criteria.getAccNo())))
	    {
		criteria.setCurrencyCode(null);
		criteria.setTrxType(null); // Reda #253103 18/12/2014
	    }
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else
	    {
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]

	    if(FomConstant.RB_REAL_BENEFICIARIES_REF.equals(lookupCallingScreen))
	    {
		CompaniesCO companiesCO = cifBO.getDefaultBenefCriteria(criteria);
		if(companiesCO.getCompaniesVO() != null)
		{
		    criteria.setCountry(companiesCO.getCompaniesVO().getCOMP_COUNTRY());
		}
	    }

	    if(getRecords() == 0)
	    {
		setRecords(cifBO.cifBenefLkpCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.cifBenefLkpList(criteria));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup CIF data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCifLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setLang(sessionCO.getLanguage());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else
	    {
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]
	    if((criteria.getSrchMapFldsOnly() != null) && criteria.getSrchMapFldsOnly().get("ID_NO") != null)
	    {

		criteria.setIdNoFilter(criteria.getSrchMapFldsOnly().get("ID_NO").toString());
	    }
	    
	    // from billRegistration screen
	    if(AccountsConstant.FROM_SCREEN_BILL.equals(lookupCallingScreen))
	    {
		criteria.setRaType("X");
		criteria.setGMI_FLAG("N");
		criteria.setACC_BC("B");
		criteria.setCIFStatus(null); // which mean "A"
		criteria.setAffectPassChq(null);
		criteria.setAFFECT_CARD(null);

		if(getRecords() == 0)
		{
		    setRecords(cifBO.cifListCountbyBrCyGl(criteria));
		}
		// set the collection into gridModel attribute defined at JSP
		// grid
		setGridModel(cifBO.cifListbyBrCyGl(criteria));
	    }
	    else if("VISIST_SCHEDULE".equals(lookupCallingScreen) || "CUSTOMER_RELATION_VISIT".equals(lookupCallingScreen))
	    {
		
		if(!NumberUtil.isEmptyDecimal(criteria.getTellerCode()))
		{

		    criteria.setBranchCode(sessionCO.getBranchCode());
		    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		    
		    if(getRecords() == 0)
		    {
			setRecords(cifBO.returnCifNoLookupCount(criteria));
		    }
		    // set the collection into gridModel attribute defined at
		    // JSP grid
		    setGridModel(cifBO.returnCifNoLookup(criteria));
		}
	    }
	    else
	    {
		/**
		 * [MARWAN] in case the call is from Dashboard ....
		 */
		/*
		 * if(BigDecimal.ONE.equals(NumberUtil.nullToZero(criteria.
		 * getFromDash ())))
		 * {if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(criteria.
		 * getLoginTypeByBr())) {
		 * criteria.setBranchCode(sessionCO.getBranchCode()); } }
		 */
//		if(getRecords() == 0)
//		{
//		    setRecords(cifBO.cifListCount(criteria));
//		}
//		// set the collection into gridModel attribute defined at JSP
//		// grid
//		setGridModel(cifBO.cifList(criteria));
		
		/*
		 * #718601 - Add Restrictions to 360
		 */
		if("GLBVIEW001".equals(criteria.getTraceProgRef()))
		{
		    criteria.setCurrAppName(sessionCO.getCurrentAppName());
		    criteria.setPageRef(criteria.getTraceProgRef());
		    criteria.setRestrBranchCode(sessionCO.getBranchCode());
		

		
		    if(getRecords() == 0)
		    {
			setRecords(cifBO.cifListCountRestricted(criteria));
		    }
		    // set the collection into gridModel attribute defined at JSP grid
		    setGridModel(cifBO.cifListRestricted(criteria));
		}
		else
		{
		    if(getRecords() == 0)
		    {
			setRecords(cifBO.cifListCount(criteria));
		    }
		    // set the collection into gridModel attribute defined at JSP grid
		    setGridModel(cifBO.cifList(criteria));
		    
		}
	    }

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup CIF Lookup Query data filtered by the defined criteria
     * dw_master_lookup_cif
     * 
     * @return
     */

    public String fillCifLookupQuery()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setComp_code(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]
	    if(lookupCallingScreen != null && "FOM_FundTransfer".equals(lookupCallingScreen))
	    {
		criteria.setRaFlag(sessionCO.getShowBranchesChar());
		criteria.setRaStatus("A");
		criteria.setRaResident("B");
	    }
	    else if(lookupCallingScreen != null && "FOM_EMPLOYER_CIF".equals(lookupCallingScreen))
	    {
		criteria.setRaFlag(sessionCO.getShowBranchesChar());
		criteria.setRaStatus("A");
		criteria.setRaResident("B");
	    }
	    else if(lookupCallingScreen != null && "MANUAL_BATCHING_CIF".equals(lookupCallingScreen))
	    {
		criteria.setBanksLkp("true");
		criteria.setBankCifLkp("true");
		criteria.setLookupBankCifAib("true");

	    }
	    // NABIL FEGHALI BB140155 KYC new changes
	    else if(lookupCallingScreen != null && "FOM_KYC".equals(lookupCallingScreen))
	    {
		criteria.setBanksLkp("true");
		criteria.setBankCifLkp("true");
		criteria.setLookupBankCif("true");
		criteria.setBankType(null);
		criteria.setResident("true");
	    }
	    else if(lookupCallingScreen != null && ("PORTFOLIO_CREATION".equals(lookupCallingScreen)
		    || "SPECIAL_CONDITIONS_CIF".equals(lookupCallingScreen)
		    || "TRADE_COUNTER_PARTY".equals(lookupCallingScreen)))
	    {

		criteria.setRaStatus("A");
		criteria.setRaResident("B");
		criteria.setRaFlag("I");
		
		// Abdo BB110153	
		if(lookupCallingScreen != null && "SPECIAL_CONDITIONS_CIF".equals(lookupCallingScreen))
		{
		    if("0".equals(StringUtil.nullEmptyToValue(criteria.getBranchCentralisation(), "0")))
		    {
			criteria.setRaFlag("N");
			criteria.setBranchCode(sessionCO.getBranchCode());
		    }
		}

	    }
	    else if(lookupCallingScreen != null && FomConstant.RB_REAL_BENEFICIARIES_REF.equals(lookupCallingScreen))
	    {
		criteria.setRaFlag("I");
		/** @todo */
		criteria.setRaStatus("A");
		/** @todo */
		criteria.setRaResident("B");
		criteria.getBanksLkp(); // should be 'banksLkp !="true"'
	    }
	    else if(lookupCallingScreen != null
		    && ("AVA_FILE".equalsIgnoreCase(lookupCallingScreen)
			    || "AVA_BENEF_DEF".equalsIgnoreCase(lookupCallingScreen))
		    || "ADD_COMPANION_DEF".equals(lookupCallingScreen))
	    {
		criteria.setRaFlag(sessionCO.getShowBranchesChar());
		criteria.setRaStatus("A");
		criteria.setRaResident("B");
		if("AVA_FILE".equalsIgnoreCase(lookupCallingScreen))
		{ // EWBI160074 -- [John Massaad]
		    if(!StringUtil.isNotEmpty(criteria.getCifType()))
		    {
			criteria.setCifType("T");// Corporate
		    }
		    criteria.setFromScreen("AVA_FILE");
		}
	    }
	    /*
	     * called from Add Payment Screen where add group Touristic, Medical
	     * or Other
	     */
	    else if(lookupCallingScreen != null && ("TOU".equalsIgnoreCase(lookupCallingScreen)
		    || "MED".equalsIgnoreCase(lookupCallingScreen) || "OTH".equalsIgnoreCase(lookupCallingScreen)))
	    {
		criteria.setRaFlag(sessionCO.getShowBranchesChar());
		criteria.setRaStatus("A");
		criteria.setRaResident("B");
		criteria.setFromScreen("AVA_PAYMENT");
		if("TOU".equalsIgnoreCase(lookupCallingScreen) || "MED".equalsIgnoreCase(lookupCallingScreen))
		{
		    criteria.setCifType("V");// Individual
		}
	    }
	    // added by nour for tp#925559
	    else if(lookupCallingScreen != null && ("KYC_Management".equals(lookupCallingScreen) || "CREDIT_EVALUATION_CIF".equals(lookupCallingScreen)))
	    {
	    	criteria.setRaFlag("I");
			criteria.setRaStatus("A");
			criteria.setRaResident("B");
	    }
	    else if(lookupCallingScreen != null && ("ISSUANCE_LIMIT".equals(lookupCallingScreen)
	    		|| "COUNTER_PARTY".equals(lookupCallingScreen) 
	    		|| "COUNTER_PARTY_SEC_TYPE".equals(lookupCallingScreen) ))
		{
			criteria.setBanksLkp("true");
			criteria.setBankCifLkp("true");
			criteria.setLookupBankCif("true");
			criteria.setBankType(BigDecimal.ZERO);
			criteria.setIsBank(BigDecimal.ZERO);
		}
	    else if(lookupCallingScreen != null && "GL_TYPE_TEMPLATE".equals(lookupCallingScreen))
		{
	    	criteria.setRaStatus("A");
	    	criteria.setRaFlag("I");
	    	criteria.setRaResident("B");
		}
	    else
	    {
		if("TRANSFER_ACCOUNTS".equals(lookupCallingScreen))
		{

		    criteria.setRaFlag(sessionCO.getShowBranchesChar());
		    criteria.setRaStatus("A");
		    criteria.setRaResident("B");

		}
		else
		{
		    criteria.setRaFlag("I");
		    /** @todo */
		    criteria.setRaStatus("X");
		    /** @todo */
		    criteria.setRaResident("B");
		    /** @todo */
		}
	    }
	    if(checkNbRec(criteria))
	    {
		setRecords(cifBO.cifLookupQueryListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.cifLookupQueryList(criteria));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Lookup for DW_Lookup_CIF_no_acc
     * 
     * @return
     */
    public String constructCifNoAccLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG", "TEL", "RESIDENT", "ID_NO",
		    "CIF_TYPE", "ADDITIONAL_REFERENCE" };
	    String[] colType = { "text", "text", "text", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Short_Name_key"), getText("Long_Name__key"),
		    getText("Full_Name_key"), getText("Tel_key"), getText("Resident_key"), getText("Id_No_key"),
		    getText("Cif_Type_key"), getText("Additional_Reference_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cif_No_Acc_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifNoAccLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String fillCifNoAccLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setComp_code(sessionCO.getCompanyCode());
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else
	    {
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]

	    if(getRecords() == 0)
	    {
		setRecords(cifBO.cifNoAccListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.cifNoAccList(criteria));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct CIF Bank Lookup based on the VO returned in the resultMap.
     */
    public String contructCifBankLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG", "ADDITIONAL_REFERENCE",
		    "SHORT_NAME_ARAB", "LONG_NAME_ARAB", "FULL_NAME_ARAB" };
	    String[] colType = { "text", "text", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key"),
		    getText("Full_Name_key"), getText("Additional_Reference_key"), getText("Short_Name_Arab_key"),
		    getText("Long_Name_Arab_key"), getText("Full_Name_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG",
			"ADDITIONAL_REFERENCE" };
		colType = new String[] { "text", "text", "text", "text", "text" };
		titles = new String[] { getText("CIF_No_key"), getText("Short_name_eng_key"),
			getText("Long_Name_eng_key"), getText("Full_Name_key"), getText("Additional_Reference_key") };
	    }

	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifBankLookupQuery");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillCifBankLookupQuery()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setComp_code(sessionCO.getCompanyCode());
	    criteria.setStatus("A");
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]
	    if(getRecords() == 0)
	    {
		setRecords(cifBO.cifBankListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.cifBankList(criteria));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // *******************************************************************************************************************************//
    public String constructCifListJointAccLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CIF_NO", "BRANCH_CODE", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG", "TEL",
		    "RESIDENT", "ID_NO", "CIF_TYPE", "ADDITIONAL_REFERENCE" };
	    String[] colType = { "number", "number", "text", "text", "text", "text", "text", "text", "number", "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Branch_key"), getText("Short_Name_key"),
		    getText("Long_Name__key"), getText("Full_Name_key"), getText("Tel_key"), getText("Resident_key"),
		    getText("Id_No_key"), getText("Cif_Type_key"), getText("Additional_Reference_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifListJointAccLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String fillCifListJointAccLookup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    criteria.setComp_code(returnSessionObject().getCompanyCode());
	    // criteria.setBranchCode(returnSessionObject().getBranchCode()); /*DASI200009*/
	    //Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else
	    {
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]

	    if(getRecords() == 0)
	    {
		setRecords(cifBO.cifJointListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.cifJointList(criteria));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // *******************************************************************************************************************************//

    /**
     * Construct CIF All Amf Lookup Query dw_lookup_cif_allamf raees
     * 
     * @return
     */

    public String constructCifAllAmfLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    // raees
	    String[] name = { "BRANCH_CODE", "CURRENCY_CODE", "GL_CODE", "CIF_SUB_NO", "SL_NO",

		    "ADDITIONAL_REFERENCE", "AC_SRL", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG", "STATUS",

		    "ACC_BC", "GMI_FLAG",

	    };
	    String[] colType = { "number", "number", "number", "number", "number", "text", "text", "text", "text",
		    "text", "text", "text", "number" };
	    String[] titles = { getText("branchKey"), getText("CY_key"), getText("G_L_Code_key"),
		    getText("CIF_SUB_key"), getText("S_L_No_key"), getText("Additional_Reference_key"),
		    getText("Serial_key"), getText("briefDesc"), getText("Long_Description_key"),
		    getText("Full_Name_key"), getText("Status_key"), "ACC_BC", "GMI_FLAG" };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup__Account_Codes_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifAllAmfLookupQuery");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillCifAllAmfLookupQuery()
    {
	try
	{
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setBranchCode(BigDecimal.ZERO);
	    criteria.setCurrencyCode(BigDecimal.ZERO);
	    criteria.setGlCode(BigDecimal.ZERO);
	    criteria.setBS_CONTRA("X");
	    criteria.setRaFlag("X");
	    criteria.setCifType("X");
	    criteria.setAffectPassChq("-1");

	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setComp_code(sessionCO.getCompanyCode());

	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]
	    if(getRecords() == 0)
	    {
		setRecords(cifBO.cifAllAmfListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.cifAllAmfList(criteria));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Lookup window corresponding to w_lookup_cif
     * 
     * @return
     */
    public String constructMemoDtlsCifLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG", "ADDITIONAL_REFERENCE",
		    "CIF_TYPE", "TEL", "RESIDENT", "ID_NO", "CARD_NAME", "NICK_NAME", };
	    String[] colType = { "number", "text", "text", "text", "text", "text", "text", "text", "text", "text",
		    "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Short_Name_key"), getText("Long_Name__key"),
		    getText("Full_Name_key"), getText("Additional_Reference_key"), getText("Cif_Type_key"),
		    getText("Tel_key"), getText("Resident_key"), getText("Id_No_key"), getText("Card_Name_key"),
		    getText("Nick_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillMemoDtlsCifLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * @PB : w_lookup_cif_institution CifSC.flag = null by default, for any
     *     exception should be specified
     */
    public String fillMemoDtlsCifLookup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setAppName(ConstantsCommon.RET_APP_NAME);
	    // criteria.setGI_VERSION(new BigDecimal(1));
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]

	    // to identify it is from bill registration screen
	    String originOptRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
	    }
	    if(originOptRef != null && originOptRef.startsWith("REG"))
	    {
		criteria.setFlag("REG");
		criteria.setRaType("L");
	    }

	    if(getRecords() == 0)
	    {
		setRecords(cifBO.memoDtlsCifListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.memoDtlsCifList(criteria));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String constructCardsManagementCifLookup()
    {
	try
	{
	    String[] name = { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG", "ADDITIONAL_REFERENCE",
		    "CIF_TYPE", "TEL", "DESCR", "ID_NO", "ID_NO2", "CARD_NAME", "NICK_NAME", };
	    String[] colType = { "number", "text", "text", "text", "text", "number", "text", "text", "number", "number",
		    "text", "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Short_Name_key"), getText("Long_Name__key"),
		    getText("Full_Name_key"), getText("Additional_Reference_key"), getText("Cif_Type_key"),
		    getText("Tel_key"), getText("Resident_key"), getText("Id_No_key"), getText("Id_No_2_key"),
		    getText("Card_Name_key"), getText("Nick_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCardsManagementCifLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillCardsManagementCifLookup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setComp_code(sessionCO.getCompanyCode());
	    criteria.setLang(sessionCO.getLanguage());
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]
	    
	    if(getRecords() == 0)
	    {
		setRecords(cifBO.cardsManagementCifListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.cardsManagementCifList(criteria));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Lookup window corresponding to w_lookup_cif_fms
     * 
     * @return
     */
    public String constructCifFmsLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "cifVO.CIF_NO", "cifVO.SHORT_NAME_ENG", "cifVO.SHORT_NAME_ARAB", "cifVO.LONG_NAME_ENG",
		    "cifVO.LONG_NAME_ARAB", "cifExtendedVO.FULL_NAME_ENG", "cifExtendedVO.FULL_NAME_ARAB",
		    "cifVO.ID_NO", "cifVO.TEL", "cifVO.RESIDENT", "cifVO.TYPE", "cifVO.CIF_TYPE", "CIF_TYPE_DESC",
		    "COUNTRY_DESC" };
	    String[] colType = { "number", "text", "text", "text", "text", "text", "text", "text", "text", "text",
		    "text", "text", "text", "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Short_name_eng_key"), getText("Short_Name_Arab_key"),
		    getText("Long_Name_eng_key"), getText("Long_Name_Arab_key"),getText("Full_Name_key"),getText("Full_Name_Arab_key"), getText("Id_No_key"),
		    getText("Tel_key"), getText("Resident_key"), getText("Individual_Institution_key"),
		    getText("Cif_Type_key"), getText("Type_Description_key"), getText("Country_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "cifVO.CIF_NO", "cifVO.SHORT_NAME_ENG", "cifVO.LONG_NAME_ENG",
			"cifExtendedVO.FULL_NAME_ENG", "cifVO.ID_NO", "cifVO.TEL", "cifVO.RESIDENT", "cifVO.CIF_TYPE",
			"cifVO.TYPE", "CIF_TYPE_DESC", "COUNTRY_DESC" };
		colType = new String[] { "number", "text", "text", "text", "text", "text", "text", "text", "text",
			"text", "text" };
		titles = new String[] { getText("CIF_No_key"), getText("Short_name_eng_key"),
			getText("Long_Name_eng_key"), getText("Full_Name_key"), getText("Id_No_key"),
			getText("Tel_key"), getText("Resident_key"), getText("Individual_Institution_key"),
			getText("Cif_Type_key"), getText("Type_Description_key"), getText("Country_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifFmsLookup");

	    //TP#468452; Ajas.Abbas; 09/02/2017
	    List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
	    columnSpecs.get(0).setLeadZeros("8");

	    lookup(grid, columnSpecs, null, criteria);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillCifFmsLookup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setLang(sessionCO.getLanguage());
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]
	    
	    if(NumberUtil.isEmptyDecimal(criteria.getCifTypeCode()))
	    {
		criteria.setCifTypeCode(BigDecimal.ZERO);
	    }
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    if(getRecords() == 0)
	    {
		setRecords(cifBO.returnCifFmsListCount(criteria));
	    }
	    List<CIFCO> cifCOList = cifBO.returnCifFmsList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifCOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct CIF Bank Lookup for w_maintain_advice.dw_main_2.rbbuttondown
     * case "accwth_bank_cif" and w_maintain_advice.dw_main_6.rbbuttondown case
     * 'reimbursing_bank_cif',...
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @PB: w_lookup_cif_bank(tfa06)/dw_lookup_cif_bank(tfa06)
     */
    public String constructCommonSwiftCIFLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "cifVO.BRANCH_CODE", "cifVO.CIF_NO", "cifVO.SHORT_NAME_ENG", "cifVO.LONG_NAME_ENG",
		    "cifExtendedVO.FULL_NAME_ENG", "cifVO.TEL", "cifVO.RESIDENT", "cifVO.ID_NO", "cifVO.CIF_TYPE",
		    "cifVO.ADDITIONAL_REFERENCE", "pmsCifSwiftVO.SWIFT_BIC_BBBB", "pmsCifSwiftVO.SWIFT_BIC_CC",
		    "pmsCifSwiftVO.SWIFT_BIC_LL", "pmsCifSwiftVO.SWIFT_BIC_T", "pmsCifSwiftVO.SWIFT_BIC_BCD" };
	    String[] colType = { "number", "number", "text", "text", "test", "text", "text", "text", "text", "number",
		    "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Branch_Code_key"), getText("CIF_No_key"), getText("Short_Name_key"),
		    getText("Long_Name__key"), getText("Full_Name_key"), getText("Tel_key"), getText("Resident_key"),
		    getText("CIVIL_ID_NUMBER"), getText("Cif_Type_key"), getText("Additional_Reference_key"),
		    getText("bank_code_key"), getText("Country_Code_key"), getText("Location_Code_key"),
		    getText("Terminal_Id_key"), getText("Branch_Code_key") };
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCommonSwiftCIFLookupQuery");
	    List<LookupGridColumn> cifGridColumn = returnStandarColSpecs(name, colType, titles);
	    for(int i = 0; i < name.length; i++)
	    {
		if("cifVO.BRANCH_CODE".equals(cifGridColumn.get(i).getName())
			|| "cifVO.CIF_TYPE".equals(cifGridColumn.get(i).getName()))
		{
		    cifGridColumn.get(i).setLeadZeros("4");
		}
		else if("cifVO.CIF_NO".equals(cifGridColumn.get(i).getName()))
		{
		    cifGridColumn.get(i).setLeadZeros("8");
		}
	    }
	    lookup(grid, cifGridColumn, null, criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructCommonSwiftCIFLookup of CifLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill CIF Bank Lookup for w_maintain_advice.dw_main_2.rbbuttondown case
     * "accwth_bank_cif" and w_maintain_advice.dw_main_6.rbbuttondown case
     * 'reimbursing_bank_cif',...
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @PB:w_lookup_cif_bank(tfa06)/dw_lookup_cif_bank(tfa06)
     */
    public String fillCommonSwiftCIFLookupQuery()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]

	    if(checkNbRec(criteria))
	    {
		setRecords(cifBO.returnCommonSwiftDataCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.returnCommonSwiftData(criteria));
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCommonSwiftCIFLookupQuery of CifLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct CIF Bank Lookup for w_maintain_advice.dw_main_1.rbbuttondown
     * case "receiver_bank"
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @PB:w_lookup_bank_cif(tfa06)/dw_lookup_bank_cif(tfa05)
     */
    public String constructReceiverBankLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "cifVO.CIF_NO", "cifVO.SHORT_NAME_ENG", "cifExtendedVO.FULL_NAME_ENG",
		    "cifVO.ADDITIONAL_REFERENCE", "pmsCifSwiftVO.SWIFT_BIC_BBBB", "pmsCifSwiftVO.SWIFT_BIC_CC",
		    "pmsCifSwiftVO.SWIFT_BIC_LL", "pmsCifSwiftVO.SWIFT_BIC_T", "pmsCifSwiftVO.SWIFT_BIC_BCD" };
	    String[] colType = { "number", "text", "text", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Name_key"), getText("Full_Name_key"),
		    getText("Additional_Reference_key"), getText("bank_code_key"), getText("Country_Code_key"),
		    getText("Location_Code_key"), getText("Terminal_Id_key"), getText("Branch_Code_key") };
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillReceiverBankLookupQuery");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructReceiverBankLookup of CifLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct CIF Bank Lookup for w_maintain_advice.dw_main_1.rbbuttondown
     * case "receiver_bank"
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @PB: w_lookup_bank_cif(tfa06)/dw_lookup_bank_cif(tfa05)
     */
    public String fillReceiverBankLookupQuery()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	 criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]	    if(checkNbRec(criteria))

	    if(checkNbRec(criteria))
	    {
		setRecords(cifBO.returnReceiverBankListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.returnReceiverBankList(criteria));
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillReceiverBankLookupQuery of CifLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct CIF lookup with swift codes
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @PB: w_lookup_cif_all(tfa06) /dw_lookup_cif_all(tfa05)
     */
    public String contructAllCIFLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "cifVO.CIF_NO", "cifVO.SHORT_NAME_ENG", "cifExtendedVO.FULL_NAME_ENG",
		    "cifVO.ADDITIONAL_REFERENCE", "pmsCifSwiftVO.SWIFT_BIC_BBBB", "pmsCifSwiftVO.SWIFT_BIC_CC",
		    "pmsCifSwiftVO.SWIFT_BIC_LL", "pmsCifSwiftVO.SWIFT_BIC_T", "pmsCifSwiftVO.SWIFT_BIC_BCD" };
	    String[] colType = { "number", "text", "text", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Name_key"), getText("Full_Name_key"),
		    getText("Additional_Reference_key"), getText("bank_code_key"), getText("Country_Code_key"),
		    getText("Location_Code_key"), getText("Terminal_Id_key"), getText("Branch_Code_key") };
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillAllCIFLookupQuery");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in contructAllCIFLookup of CifLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill CIF lookup with swift codes
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @PB: w_lookup_cif_all(tfa06) /dw_lookup_cif_all(tfa05)
     */
    public String fillAllCIFLookupQuery()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150] 
	    if(checkNbRec(criteria))
	    {
		setRecords(cifBO.returnAllCIFListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.returnAllCIFList(criteria));
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillAllCIFLookupQuery of CifLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct CIF Lookup based on the VO returned in the resultMap.
     * w_lookup_cif_branch
     * 
     * @return
     */
    public String constructCIFBRLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "BRANCH_CODE" };
	    String[] colType = { "text" };
	    String[] titles = { getText("Branch_code_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCIFBRLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillCIFBRLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setComp_code(sessionCO.getCompanyCode());
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]

	    CIFVO cifVO = null;
	    if(!NumberUtil.isEmptyDecimal(criteria.getCif_no()))
	    {
		cifVO = cifBO.returnCIF(criteria);
	    }
	    CIFVO cifVO1;
	    List<CIFVO> cifVOList = new ArrayList<CIFVO>();

	    if(null != cifVO && StringUtil.isNotEmpty(cifVO.getADD_STRING3())
		    && StringUtil.isNotEmpty(cifVO.getADD_STRING4()))
	    {

		int intFrom = Integer.parseInt(cifVO.getADD_STRING3());
//		int intTo = Integer.parseInt(cifVO.getADD_STRING4());
		int intTo = 0;
		BigDecimal bigDecimalTo = new BigDecimal(cifVO.getADD_STRING4());
		if(bigDecimalTo.compareTo(new BigDecimal(9999)) > 0)
		{
		    intTo = 9999; //branch code cannot be greater than 9999
		}
		else
		{
		    intTo = Integer.parseInt(cifVO.getADD_STRING4());
		}
		for(int i = intFrom; i <= intTo; i++)
		{
		    cifVO1 = new CIFVO();
		    cifVO1.setBRANCH_CODE(new BigDecimal(i));
		    cifVOList.add(cifVO1);
		}
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifVOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Lookup window corresponding to w_lookup_cif_fms
     * 
     * @return
     */
    public String constructDeveloperCifFmsLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "cifVO.CIF_NO", "cifVO.SHORT_NAME_ENG" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Short_name_eng_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillDeveloperCifFmsLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillDeveloperCifFmsLookup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setLang(sessionCO.getLanguage());

	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]
	    
	    if(NumberUtil.isEmptyDecimal(criteria.getCifTypeCode()))
	    {
		criteria.setCifTypeCode(BigDecimal.ZERO);
	    }

	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    if(getRecords() == 0)
	    {
		setRecords(cifBO.returnDeveloperCifFmsListCount(criteria));
	    }
	    List<CIFVO> cifVOList = cifBO.returnDeveloperCifFmsList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifVOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * PB : w_lookup_bankcif
     */
    public String bankCifLookup() throws BaseException
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG", "TEL", "RESIDENT", "ID_NO",
		    "ADD_STRING2", "ADD_STRING3", "ADD_STRING4", "SHORT_NAME_ARAB", "LONG_NAME_ARAB",
		    "FULL_NAME_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text", "text", "text", "text", "text", "text",
		    "text", "text", "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Short_Name_key"), getText("Long_Name__key"),
		    getText("Full_Name_key"), getText("Tel_key"), getText("Resident_key"), getText("Civil_ID_key"),
		    getText("add_string2_key"), getText("add_string3_key"), getText("add_string4_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"), getText("Full_Name_Arab_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("CIF_No_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillBankCifLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * Fill the lookup reason data filtered by the defined criteria
     * 
     * @return
     */
    public String fillBankCifLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setComp_code(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]

	    // flags to select the adaptable query
	    criteria.setBanksLkp("true");
	    criteria.setLookupBankCif("true");

	    if(getRecords() == 0)
	    {
		setRecords(cifBO.cifLookupQueryListCount(criteria));
	    }
	    List<CIFVO> lst = cifBO.cifLookupQueryList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(lst);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct CIF Lookup based on compCode and Status only.
     * w_master_lookup_cif
     * 
     * @author HanaaElJazzar
     * @return String
     */
    public String constructCifLookupByGlobalCif()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG", "CIF_TYPE", "TEL",
		    "RESIDENT", "ID_NO", "BRANCH_CODE", "ADDITIONAL_REFERENCE" };

	    String[] colType = { "number", "text", "text", "text", "number", "text", "text", "text", "number", "text" };

	    String[] titles = { getText("CIF_No_key"), getText("Short_Name_key"), getText("Long_Name__key"),
		    getText("Full_Name_key"), getText("Cif_Type_key"), getText("Tel_key"), getText("Resident_key"),
		    getText("Civil_ID_key"), getText("branchCode"), getText("Additional_Reference_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");

	    grid.setUrl("/pathdesktop/CifLookup_fillCifLookupByGlobalCif");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup CIF data filtered by the defined compCode and status
     * 
     * @author hanaaeljazzar
     * @return String
     */
    @SuppressWarnings("unchecked")
    public String fillCifLookupByGlobalCif()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]

	    if(NumberUtil.isEmptyDecimal(criteria.getCompCode()))
	    {
		criteria.setCompCode(sessionCO.getCompanyCode());
	    }

	    // coming from from Assets TRX Template
	    String originOptRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
	    }
	    if(StringUtil.nullToEmpty(originOptRef).equals("P0066M"))
	    {
		criteria.setStatus(ConstantsCommon.CIF_ACTIVE);
	    }

	    if(checkNbRec(criteria))
	    {
		setRecords(cifBO.returnCifListCountByGlobalCif(criteria));
	    }

	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifBO.getCifListByGlobalCif(criteria));

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCifLookupByCompCode of AssetsCifLookupAction");
	    handleException(e, "Error Loading Grid of Account List", null);
	}
	return SUCCESS;
    }

    /**
     * Construct CIF Lookup Query based on Id No
     * 
     * @return
     */
    public String constructLookupCifIdNo()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG", "ADDITIONAL_REFERENCE",
		    "CIF_TYPE", "TEL", "RESIDENT", "ID_NO", "CARD_NAME", "NICK_NAME" };
	    String[] colType = { "number", "text", "text", "text", "number", "text", "text", "text", "text", "text",
		    "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Short_Name_key"), getText("Long_Name__key"),
		    getText("Full_Name_key"), getText("Additional_Reference_key"), getText("Cif_Type_key"),
		    getText("Tel_key"), getText("Resident_key"), getText("Id_No_key"), getText("Card_Name_key"),
		    getText("Nick_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifLookupIdNo");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillCifLookupIdNo()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]

	    if(StringUtil.isNotEmpty(criteria.getId_no()))
	    {
		if(checkNbRec(criteria))
		{
		    setRecords(cifBO.returnCifIdNoListCount(criteria));
		}
		// set the collection into gridModel attribute defined at JSP
		// grid
		setGridModel(cifBO.returnCifIdNoListResult(criteria));
	    }

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct CIF Lookup Query based on vehicle number
     * 
     * @return
     */
    public String constructLookupCifVehicleNo()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "cifVO.CIF_NO", "cifVO.SHORT_NAME_ENG", "cifVO.SHORT_NAME_ARAB", "cifVO.LONG_NAME_ENG",
		    "cifVO.LONG_NAME_ARAB", "cifExtendedVO.FULL_NAME_ENG", "cifExtendedVO.FULL_NAME_ARAB", "vehicleNo",
		    "cifVO.ADDITIONAL_REFERENCE", "cifVO.CIF_TYPE", "cifVO.TEL", "cifVO.RESIDENT", "cifVO.ID_NO",
		    "cifVO.CARD_NAME", "cifVO.NICK_NAME" };
	    String[] colType = { "number", "text", "text", "number", "text", "text", "text", "text", "text", "text",
		    "text", "text", "text", "text", "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Short_name_eng_key"), getText("Short_Name_Arab_key"),
		    getText("Long_Name_eng_key"), getText("Long_Name_Arab_key"), getText("Full_Name_key"),
		    getText("Full_Name_Arab_key"), getText("Vehicule_No_key"), getText("Additional_Reference_key"),
		    getText("Cif_Type_key"), getText("Tel_key"), getText("Resident_key"), getText("Id_No_key"),
		    getText("Card_Name_key"), getText("Nick_Name_key") };

	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "cifVO.CIF_NO", "cifVO.SHORT_NAME_ENG", "cifVO.LONG_NAME_ENG",
			"cifExtendedVO.FULL_NAME_ENG", "vehicleNo", "cifVO.ADDITIONAL_REFERENCE", "cifVO.CIF_TYPE",
			"cifVO.TEL", "cifVO.RESIDENT", "cifVO.ID_NO", "cifVO.CARD_NAME", "cifVO.NICK_NAME" };
		colType = new String[] { "number", "text", "text", "text", "number", "text", "text", "text", "text",
			"text", "text", "text" };
		titles = new String[] { getText("CIF_No_key"), getText("Short_Name_key"), getText("Long_Name__key"),
			getText("Full_Name_key"), getText("Vehicule_No_key"), getText("Additional_Reference_key"),
			getText("Cif_Type_key"), getText("Tel_key"), getText("Resident_key"), getText("Id_No_key"),
			getText("Card_Name_key"), getText("Nick_Name_key") };
	    }
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifLookupVehicleNo");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillCifLookupVehicleNo()
    {
	try
	{
	    List<CIFCO> cifCOList = new ArrayList<CIFCO>();
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setStatus(ConstantsCommon.STATUS_APPROVED);
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]
	    if(StringUtil.isNotEmpty(criteria.getVehicleNo()))
	    {
		if(checkNbRec(criteria))
		{
		    setRecords(cifBO.returnCifVehicleNoListCount(criteria));
		}
		cifCOList = cifBO.returnCifVehicleNoListResult(criteria);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifCOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * added by abbas for bug#472144
     * 
     * this method constructs Bank CIF Lookup
     * 
     * @return
     */
    public String constructBankCIFSwiftLookup()
    {
	try
	{
	    // in the below array, remove cifvo from the fields for tp#506223
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "FULL_NAME_ENG", "TEL", "RESIDENT", "ID_NO",
		    "ADD_STRING2", "ADD_STRING3", "ADD_STRING4" };
	    String[] colType = { "number", "text", "text", "text", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("CIF_No_key"), getText("Short_Name_key"), getText("Long_Name__key"),
		    getText("Full_Name_key"), getText("Tel_key"), getText("Resident_key"), getText("Civil_ID_key"),
		    getText("add_string2_key"), getText("add_string3_key"), getText("add_string4_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText(""));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillBankCIFSwiftLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * added by abbas for bug#472144
     * 
     * this methods calls the mapper in order to retrieve Bank CIF Lookup Data
     * 
     * @return
     */
    public String fillBankCIFSwiftLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setComp_code(sessionCO.getCompanyCode());
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
	   	 criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
	   	criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    //END Raed Saad - [BB160150]

	    if(checkNbRec(criteria))
	    {
		setRecords(cifBO.bankCifLkpCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP
	    // grid
	    // added for tp#506223
	    List<CifTrxTypeLimitCO> cifCOList = cifBO.bankCifLkpList(criteria);
	    List<CIFVO> cifVOList = new ArrayList<CIFVO>();
	    for(int i = 0; i < cifCOList.size(); i++)
	    {
		CIFVO cifVO = cifCOList.get(i).getCifVO();
		cifVO.setCIF_NO(cifCOList.get(i).getCifTrxtypeLimitVO().getCIF_NO());
		cifVOList.add(cifVO);
	    }
	    setGridModel(cifVOList);
	    // end tp#506223
	    /*
	     * commented for tp#506223
	     * setGridModel(cifBO.bankCifLkpList(criteria));
	     */
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // end abbas

    /**
     * Construct CIF Lookup based on the VO returned in the resultMap.
     * Joyce Kanazeh
     * Customer Realationship Management - Visit Schedule
     * TP#412662
     * @return
     */
    public String constructCiNoLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "cifVO.BRANCH_CODE", "cifVO.CIF_NO", "cifVO.SHORT_NAME_ENG", "cifVO.LONG_NAME_ENG", "cifVO.TEL", "cifVO.RESIDENT", "cifVO.ID_NO",
		    "cifVO.CIF_TYPE", "cifVO.ADDITIONAL_REFERENCE" };
	    
	    String[] colType = { "text", "text", "text", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Branch_code_key"), getText("CIF_No_key"), getText("Short_Name_key"),
		    getText("Long_Name__key"), getText("Tel_key"), getText("Resident_key"), getText("Id_No_key"),
		    getText("Cif_Type_key"), getText("Additional_Reference_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifLookup_fillCifLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    /**
     * @param cifBO the cifBO to set
     */
    public void setCifBO(CifBO cifBO)
    {
	this.cifBO = cifBO;
    }

    /**
     * @return the criteria
     */
    public CifSC getCriteria()
    {
	return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(CifSC criteria)
    {
	this.criteria = criteria;
    }

    public String getLookupCallingScreen()
    {
	return lookupCallingScreen;
    }

    public void setLookupCallingScreen(String lookupCallingScreen)
    {
	this.lookupCallingScreen = lookupCallingScreen;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public String getUtilityPayment()
    {
	return utilityPayment;
    }

    public void setUtilityPayment(String utilityPayment)
    {
	this.utilityPayment = utilityPayment;
    }

}
