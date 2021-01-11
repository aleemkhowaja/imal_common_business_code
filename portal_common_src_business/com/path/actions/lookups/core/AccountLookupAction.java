/**
 * @Auther:MarwanMaddah
 * @Date:Feb 24, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.struts2.json.JSONException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.iis.IISCommonConstants;
import com.path.bo.core.account.AccountBO;
import com.path.bo.core.account.AccountsConstant;
import com.path.bo.core.csmfom.FomConstant;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.TFSCTRL1VO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.trxmgnt.accountdtl.TrxMgntAccountDtlCO;

/**
 * Used to load Account lookup...
 */
public class AccountLookupAction extends LookupBaseAction
{
    private List<AccountCO> accountCOList;
    private AccountSC criteria = new AccountSC();
    private AccountBO accountBO;
    private String lookupCallingScreen;
    private String gmiFlag;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * Construct Account Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "amfVO.BRANCH_CODE", "amfVO.CURRENCY_CODE", "amfVO.GL_CODE", "glVO.BRIEF_DESC_ENG", "amfVO.CIF_SUB_NO",
		    "amfVO.SL_NO", "amfVO.BRIEF_NAME_ENG", "amfVO.LONG_NAME_ENG","amfVO.FULL_NAME_ENG", "amfVO.ADDITIONAL_REFERENCE",
		    "cifVO.LONG_NAME_ENG", "cifVO.ID_NO", "amfVO.DIV", "amfVO.DEPT", "amfVO.ACC_BC", "amfVO.STATUS",
		    "amfVO.AC_SIGN", "amfVO.IBAN_ACC_NO", "amfVO.GMI_FLAG", "amfVO.AC_SRL", "cifVO.SHORT_NAME_ENG",
		    "cifVO.TEL", "cifVO.ECO_SECTOR", "cifVO.RELATION_CODE", "cifVO.COUNTRY", "cifVO.ID_NO2",
		    "cifVO.CIF_TYPE", "cifVO.ONE_OBLIGOR", "cifVO.EMAIL_ID", "cifVO.SEXE", "cifVO.SHORT_NAME_ARAB",
		    "cifVO.LONG_NAME_ARAB", "cifVO.CARD_NAME", "cifVO.NICK_NAME", "cifVO.STATUS" };
	    String[] colType = { "number", "number", "number", "text", "number", "number", "text", "text","text", "text", "text",
		    "text", "number", "number", "text", "text", "text", "text", "text", "number", "text", "text",
		    "number", "number", "number", "text", "number", "number", "text", "text", "text", "text", "text",
		    "text", "text" };

	    String[] titles = { getText("Branch_Code_key"), getText("Currency_key"), getText("GL_key"), getText("gl_brief_name_key"),
		    getText("CIF_key"), getText("SL_key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key"),
		    getText("Full_Name_key"),getText("AdditionalReference_key"), getText("Long_Desc_Eng_key"), getText("Id_No_key"),
		    getText("Div_key"), getText("Dept_key"), getText("acc_bc_key"), getText("Status_key"),
		    getText("ac_sign_key"), getText("ibanAccNo_key"), getText("Gmi_Flag_key"), getText("ac_srl_key"),
		    getText("Short_Name_key"), getText("Tel_key"), getText("Eco_Sector_key"), getText("Relation_key"),
		    getText("Country_key"), getText("Id_No_key"), getText("Cif_Type_key"), getText("One_Obligor_key"),
		    getText("Email_Id_key"), getText("Gender_key"), getText("Short_Name_Arab_key"),
		    getText("Long_Name_Arab_key"), getText("Card_Name_key"), getText("Nick_Name_key"),
		    getText("Status_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "amfVO.BRANCH_CODE", "amfVO.CURRENCY_CODE", "amfVO.GL_CODE","glVO.BRIEF_DESC_ENG", "amfVO.CIF_SUB_NO",
			"amfVO.SL_NO","subsidiary", "amfVO.BRIEF_NAME_ENG", "amfVO.LONG_NAME_ENG", "amfVO.FULL_NAME_ENG","amfVO.ADDITIONAL_REFERENCE",
			"cifVO.LONG_NAME_ENG", "cifVO.ID_NO", "amfVO.DIV", "amfVO.DEPT","amfVO.ACC_BC", "amfVO.STATUS",
			"amfVO.AC_SIGN", "amfVO.IBAN_ACC_NO", "amfVO.GMI_FLAG","amfVO.AC_SRL", "cifVO.SHORT_NAME_ENG",
			"cifVO.TEL", "cifVO.ECO_SECTOR", "cifVO.RELATION_CODE","cifVO.COUNTRY", "cifVO.ID_NO2",
			"cifVO.CIF_TYPE", "cifVO.ONE_OBLIGOR", "cifVO.EMAIL_ID",
			"cifVO.SEXE", "cifVO.SHORT_NAME_ARAB", "cifVO.LONG_NAME_ARAB", "cifVO.CARD_NAME",
                			"cifVO.NICK_NAME", "cifVO.STATUS" };
		colType = new String[] { "number", "number", "number","text", "number", "number","text", "text", "text","text", "text",
			"text", "text", "number", "number", "text", "text", "text", "text", "text", "number", "text",
			"text", "number", "number", "number", "text", "number", "number", "text","text","text", "text", "text",
			"text", "text" };
		titles = new String[] { getText("Branch_Code_key"), getText("Currency_key"), getText("GL_key"), getText("gl_brief_name_key"),
			getText("CIF_key"), getText("SL_key"), getText("subsidiary_key"), getText("Short_name_eng_key"),
			getText("Long_Name_eng_key"),getText("Full_Name_key"), getText("AdditionalReference_key"), getText("Long_Desc_Eng_key"),
			getText("Id_No_key"), getText("Div_key"), getText("Dept_key"), getText("acc_bc_key"),
			getText("Status_key"), getText("ac_sign_key"), getText("ibanAccNo_key"),
			getText("Gmi_Flag_key"), getText("ac_srl_key"), getText("Short_Name_key"), getText("Tel_key"),
			getText("Eco_Sector_key"), getText("Relation_key"), getText("Country_key"),
			getText("Id_No_key"), getText("Cif_Type_key"), getText("One_Obligor_key"),
			getText("Email_Id_key"), getText("Gender_key"), getText("Short_Name_Arab_key"),
			getText("Long_Name_Arab_key"), getText("Card_Name_key"), getText("Nick_Name_key"),
			getText("Status_key") };

		/*
		 * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
		 * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
		 * Arabic Visible and Mandatory And English Mandatory , 3=
		 * Arabic Visible and Mandatory English Not Mandatory).
		 */
		if(returnSessionObject().getHideArabicColumns())
		{
		    name = new String[] { "amfVO.BRANCH_CODE", "amfVO.CURRENCY_CODE", "amfVO.GL_CODE",
			    "amfVO.CIF_SUB_NO", "amfVO.SL_NO","subsidiary", "amfVO.BRIEF_NAME_ENG", "amfVO.LONG_NAME_ENG",
			    "amfVO.FULL_NAME_ENG", "amfVO.ADDITIONAL_REFERENCE", "cifVO.LONG_NAME_ENG", "cifVO.ID_NO",
			    "amfVO.DIV", "amfVO.DEPT", "amfVO.ACC_BC", "amfVO.STATUS", "amfVO.AC_SIGN",
			    "amfVO.IBAN_ACC_NO", "amfVO.GMI_FLAG", "amfVO.AC_SRL", "cifVO.SHORT_NAME_ENG", "cifVO.TEL",
			    "cifVO.ECO_SECTOR", "cifVO.RELATION_CODE", "cifVO.COUNTRY", "cifVO.ID_NO2",
			    "cifVO.CIF_TYPE", "cifVO.ONE_OBLIGOR", "cifVO.EMAIL_ID", "cifVO.SEXE", "cifVO.CARD_NAME",
			    "cifVO.NICK_NAME", "cifVO.STATUS" };
		    colType = new String[] { "number", "number", "number", "number", "number","number", "text", "text", "text",
			    "text", "text", "text", "number", "number", "text", "text", "text", "text", "text",
			    "number", "text", "text", "number", "number", "number", "text", "number", "number", "text",
			    "text", "text", "text", "text" };
		    titles = new String[] { getText("Branch_Code_key"), getText("Currency_key"), getText("GL_key"),
			    getText("CIF_key"), getText("SL_key"), getText("subsidiary_key"), getText("Short_name_eng_key"),
			    getText("Long_Name_eng_key"), getText("Full_Name_key"), getText("AdditionalReference_key"),
			    getText("Long_Desc_Eng_key"), getText("Id_No_key"), getText("Div_key"), getText("Dept_key"),
			    getText("acc_bc_key"), getText("Status_key"), getText("ac_sign_key"),
			    getText("ibanAccNo_key"), getText("Gmi_Flag_key"), getText("ac_srl_key"),
			    getText("Short_Name_key"), getText("Tel_key"), getText("Eco_Sector_key"),
			    getText("Relation_key"), getText("Country_key"), getText("Id_No_key"),
			    getText("Cif_Type_key"), getText("One_Obligor_key"), getText("Email_Id_key"),
			    getText("Gender_key"), getText("Card_Name_key"), getText("Nick_Name_key"),
			    getText("Status_key") };
		}
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("accountList_key"));
	    grid.setRowNum("5");
	    if("deduct_from_acc_sl".equals(lookupCallingScreen))
	    {
		grid.setUrl("/pathdesktop/AccountLookup_filldeductFromAccLookup");
	    }
	    else
	    {
		grid.setUrl("/pathdesktop/AccountLookup_fillAccountLookup");
	    }

	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    int cols = name.length;

	    for(int i = 0; i < cols; i++)
	    {
		// Defining each column
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		// gridColumn.setIndex(name[i].split("\\.")[1]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);

		if("amfVO.CURRENCY_CODE".equals(name[i]) || "amfVO.SL_NO".equals(name[i]))
		{
		    gridColumn.setLeadZeros("3");
		}
		else if("amfVO.BRANCH_CODE".equals(name[i]))
		{
		    gridColumn.setLeadZeros("4");
		}
		else if("amfVO.GL_CODE".equals(name[i]))
		{
		    gridColumn.setLeadZeros("6");
		}
		else if("amfVO.CIF_SUB_NO".equals(name[i]))
		{
		    gridColumn.setLeadZeros("8");
		}
		//BUG TP#802663 copied from #588093 AMANAUPG170181
		if(ArrayUtils.contains(new String[] { "amfVO.BRANCH_CODE", "amfVO.CURRENCY_CODE", "amfVO.GL_CODE",
			"amfVO.CIF_SUB_NO", "amfVO.SL_NO" }, name[i]))
		{
		    gridColumn.setWidth("80");
		}
		
	    }
	    lookup(grid, lsGridColumn, null, criteria);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of AccountLookupAction");
	    e.printStackTrace();
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup account data filtered by the defined criteria
     * 
     */
    public String fillAccountLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setLovType(ConstantsCommon.ACCOUNT_STATUS_LOV_TYPE);
	    criteria.setLangCode(sessionCO.getLanguage());
	    criteria.setAppName(sessionCO.getCurrentAppName());

	    /*
	     * optRef is added by Guitta on15/11/2013 in order to open the
	     * account lookup in transaction screen when opened from dynamic OPT
	     */
	    String originOptRef = "", parentProgRef = "", parentOfParentProgRef = "";

	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());

	    }
	    /*
	     * Added to get the parent of the parent of the dynamic opts created
	     * in dynamic screen section == > to get the (GU0024)
	     */
	    String[] parentOptRef = returnCommonLibBO().returnOptDetailsList(sessionCO.getCurrentAppName(),
		    originOptRef);
	    if(parentOptRef[3] != null)
	    {
		parentProgRef = parentOptRef[3];
		OPTVO optVO = new OPTVO();
		optVO.setAPP_NAME(sessionCO.getCurrentAppName());
		optVO.setPROG_REF(parentProgRef);
		optVO = returnCommonLibBO().returnOptDetails(optVO);
		if(null != optVO)
		{
		    if(null != optVO.getPARENT_REF())
		    {
			parentOfParentProgRef = optVO.getPARENT_REF();
		    }
		}
	    }

	    if(!"QUER001T".equals(originOptRef) && !"P00124MT".equals(originOptRef))
	    {
		criteria.setCompCode(sessionCO.getCompanyCode());
	    }
	    // dynamic Integration
	    if("GU0024".equals(parentOfParentProgRef))
	    {
		criteria.setBS_CONTRA("X");
		criteria.setGMI_FLAG("X");
		criteria.setFlag("AMF");
		criteria.setBankCifInd("X");
		criteria.setCifCode(BigDecimal.ZERO);
		criteria.setAMFStatus(
			"'A','I','T'"); /*
					 * To not take into consideration the P
					 * status
					 */
		// criteria.setAddRef();

	    }
	    // Links Management
	    if("LM01MT".equals(originOptRef)
		    && ("to_acc".equals(criteria.getColumnId()) || "from_acc".equals(criteria.getColumnId())))
	    {
		criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
		criteria.setGMI_FLAG("N"); // only General and Fixed Account
	    }

	    // lost and found
	    if("N001MT".equals(originOptRef))
	    {
		criteria.setGL_TYPE("X");
		criteria.setACC_BC("B");
		criteria.setBS_CONTRA("X");
		criteria.setFlag("AMF");
		criteria.setStatus("A");
		// BUG#326866 prevent the lookup from retrieving internal
		// account
		criteria.setGmiExcludes("'I'");

	    }
	    //Special Conditions
	    /**
	     * 
	     * Abdo BB110153
	     */
	    if("SPC00MT".equals(originOptRef))
	    {
		if("0".equals(StringUtil.nullEmptyToValue(criteria.getBranchCentralisation(), "0")))
		{
		    criteria.setBranchCode(sessionCO.getBranchCode());
		}
	    }
	    // Dues
	    if("DUES01MT".equals(originOptRef))
	    {
		criteria.setACC_BC("B");
		criteria.setBS_CONTRA("X");
		criteria.setGMI_FLAG("X");
		criteria.setFlag("AMF");
		criteria.setBankCifInd("X");
	    }

	    // chequeBook Maintenance
	    if("Q000MT".equals(originOptRef))
	    {
		criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
		criteria.setBS_CONTRA("X");
		criteria.setFlag("AMF");

		CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
		ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
		ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
		ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);

		if("1".equals(ctsControlVO.getFORBID_OTHER_BR_CHQ()))
		{
		    criteria.setBranchCode(sessionCO.getBranchCode());
		}

		if(!"LNK_ACC_SL".equals(criteria.getColumnId()))
		{
		    //Hasan Bug#627576 FIBSI180104 07/03/2018
//		    if(criteria.getAllowInternAcc() == null || "".equals(criteria.getAllowInternAcc()))
//		    {
//			criteria.setAllowInternAcc("0");
//		    }
//
//		    if(!("1".equals(criteria.getAllowInternAcc()) && ConstantsCommon.INTERNAL_GL_TYPE.equals(criteria
//			    .getGL_TYPE())))
//		    {
		    if(!"1".equals(StringUtil.nullToEmpty(ctsControlVO.getACCEPT_INTRN_CHQ())))
		    {
			criteria.setAffectPassChq("2");
			criteria.setGMI_FLAG("N"); // only General and Fixed
			// Account
		    }
		}
	    }

	    // chequeBook Query
	    if("Q000QR".equals(originOptRef))
	    {
		criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
		criteria.setBS_CONTRA("X");
		criteria.setFlag("AMF");
		//Hasan Bug#489080 28/02/2017
//		criteria.setAffectPassChq("2");
//		criteria.setGMI_FLAG("X");
		criteria.setAllowInternAcc("1");
		criteria.setFromScreen("CHEQUEBOOK_QUERY");

		CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
		ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
		ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
		ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);

		if("1".equals(ctsControlVO.getFORBID_OTHER_BR_CHQ()))
		{
		    criteria.setBranchCode(sessionCO.getBranchCode());
		}
		
		//Hasan Bug#627576 FIBSI180104 07/03/2018
		if(!"1".equals(StringUtil.nullToEmpty(ctsControlVO.getACCEPT_INTRN_CHQ())))
		{
		    criteria.setAffectPassChq("2");
		    criteria.setGMI_FLAG("N"); // only General and Fixed
		}
	    }
	    
	    //Hasan Bug#666137 DASI180216 03/05/2018
	    if("TA001MT".equals(originOptRef))
	    {
		//criteria.setAMFStatus("'A'");
		criteria.setAMFStatus("'" + ConstantsCommon.ACTIVE_ACCOUNT + "','"
			    + ConstantsCommon.INACTIVE_ACCOUNT + "'");
	    }

	    // Memo Details
	    /*
	     * if("M001MT".equals(originOptRef)) {
	     * criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
	     * criteria.setBS_CONTRA("X"); criteria.setFlag("AMF");
	     * criteria.setGMI_FLAG("N"); }
	     */

	    // FOM Trx Type Limit Screen
	    if(FomConstant.MAINTENANCE_OPT.equals(originOptRef))
	    {
		/**
		 * Real Beneficiaries BMOI130017 w_lookup_amf_dyn
		 */
		if(FomConstant.RB_REAL_BENEFICIARIES_REF.equals(lookupCallingScreen))
		{
		    criteria.setGMI_FLAG("X");
		    criteria.setFlag(FomConstant.RB_REAL_BENEFICIARIES_REF);
		    criteria.setAMFStatus("'" + ConstantsCommon.ACTIVE_ACCOUNT + "','"
			    + ConstantsCommon.INACTIVE_ACCOUNT + "','" + ConstantsCommon.DORMANT_ACCOUNT + "'");
		    criteria.setCATEGORY("D");
		    criteria.setBankCifInd("X");

		}
		//Reda - #585244 - CDMI170372 09/11/2017
		else if(FomConstant.FOM_TRXTYPE_LIMITS.equals(lookupCallingScreen))
		{
		    criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
		    criteria.setBS_CONTRA("X");
		    criteria.setGMI_FLAG("X");
		    criteria.setAddRef(null);
		}
		//Hasan Bug#531007 29/05/2017
		else if(FomConstant.PACKAGE_PRODUCT_REF.equals(lookupCallingScreen))
		{
		    criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
		    criteria.setBS_CONTRA("X");
		    criteria.setGMI_FLAG("X");
		    criteria.setAddRef(null);
		}
		else
		{
		    criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
		    criteria.setBS_CONTRA("B");
		    criteria.setFlag("AMF");
		    criteria.setGMI_FLAG("N");
		}
	    }

	    // Safebox Management
	    if("E003RQ".equals(originOptRef))
	    {
		criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
		criteria.setBS_CONTRA("X");
		criteria.setFlag("AMF");

		CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
		ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
		ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
		ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);

		if("1".equals(ctsControlVO.getFORBID_OTHER_BR_CHQ()))
		{
		    criteria.setBranchCode(sessionCO.getBranchCode());
		}

		if(!"LNK_ACC_SL".equals(criteria.getColumnId()))
		{
		    if(criteria.getAllowInternAcc() == null || "".equals(criteria.getAllowInternAcc()))
		    {
			criteria.setAllowInternAcc("0");
		    }

		    if("0".equals(criteria.getAllowInternAcc())
			    && ConstantsCommon.INTERNAL_GL_TYPE.equals(criteria.getGL_TYPE()))
		    {
			criteria.setAffectPassChq("3");
			criteria.setGMI_FLAG("X"); // no Restriction on GMI
		    }
		    else
		    {
			criteria.setAffectPassChq("2");
			criteria.setGMI_FLAG("N"); // only General and Fixed
			// Account
		    }
		}
	    }

	    /*
	     * Transaction account, checking is done on the prog ref or the opt
	     * ref for the dynamic opt case
	     */

	    if("D001MT".equals(originOptRef) || "D001CE".equals(originOptRef) || "D001RE".equals(originOptRef)
		    || "D001MT".equals(originOptRef) || "D001CE".equals(originOptRef)  || "D001AS".equals(originOptRef) || "T001MT".equals(originOptRef))//FIX FOR 808406-HUSSEIN EL HAJJ
	    {
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria = accountBO.returnTrxTypeCriteria(criteria);
	    }

	    // Cards Management Screen CIF Lookup
	    if("G001MT".equals(originOptRef))
	    {
		criteria.setFlag("CIF");
		criteria.setBS_CONTRA("C");
	    }
	    // PassBook Management Screen
	    if("S000MT".equals(originOptRef))
	    {
		criteria.setAffectPassChq("1");
	    }
	    /* SMS Subscription screen */
	    if("SMS00MT".equals(originOptRef))
	    {
		criteria.setACC_BC("B"); // B/S
		criteria.setBS_CONTRA(ConstantsCommon.OFF_BALANCE_SHEET); // Client
//		criteria.setGMI_FLAG(ConstantsCommon.NON_INTERNAL_GEN_LEDGER_TYPE); // Non
		// Internal
	    }
	    
	    /* AVA File screen opening and reactivate and Maintenance of ava payment*/
	    if("AVAFLMT".equals(originOptRef) || "AVAFLYP".equals(originOptRef) || "AVAPAYMT".equals(originOptRef))
	    {
		criteria.setAMFStatus("'" + ConstantsCommon.ACTIVE_ACCOUNT + "','"
		    + ConstantsCommon.INACTIVE_ACCOUNT + "','" + ConstantsCommon.DORMANT_ACCOUNT + "'");
	    }
	    // Tfa Screens && "MA01MT".equals(originOptRef
	    if(ConstantsCommon.TFA_APP_NAME.equals(sessionCO.getCurrentAppName()) || 
                     ConstantsCommon.TFA_PARAM_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		String gmiIncludes = criteria.getGmiIncludes();

		TFSCTRL1VO tfsCtrl1VO = new TFSCTRL1VO();
		tfsCtrl1VO.setCOMP_CODE(sessionCO.getCompanyCode());
		tfsCtrl1VO.setBRANCH(sessionCO.getBranchCode());
		tfsCtrl1VO = returnCommonLibBO().returnTfsCtrl_1(tfsCtrl1VO);
		String gmiIncludesStr = null;
		if(StringUtil.nullToEmpty(criteria.getGmiIncludes()).isEmpty())
		{
		    if(tfsCtrl1VO != null && "1".equals(StringUtil.nullToEmpty(tfsCtrl1VO.getMARGIN_INTERNAL_ACC())))
		    {
			gmiIncludesStr = ConstantsCommon.GMI_ALL;
		    }
		    else
		    {
			gmiIncludesStr = ConstantsCommon.GMI_FIXED_GEN;
		    }
		}
		// ( :ra_gmi_flag = 'F' AND AMF.GMI_FLAG IN('F') )OR
		// ( :ra_gmi_flag = 'I' AND AMF.GMI_FLAG IN('I') ) OR
		// ( :ra_gmi_flag = 'N' AND AMF.GMI_FLAG IN('G','I') ) OR
		// ( :ra_gmi_flag = 'G' AND AMF.GMI_FLAG IN('G','F') )OR
		// ( :ra_gmi_flag = 'A' AND AMF.GMI_FLAG IN('G','F','I') )
		// else if(ConstantsCommon.GMI_FIXED.equals(gmiIncludes))
		// {
		// gmiIncludesStr = "'" + ConstantsCommon.GMI_FIXED + "'";
		// }
		// else if(ConstantsCommon.GMI_INTERNAL.equals(gmiIncludes))
		// {
		// gmiIncludesStr = "'" + ConstantsCommon.GMI_INTERNAL + "'";
		// }
		// else if("N".equals(gmiIncludes))
		// {
		// gmiIncludesStr = ConstantsCommon.GMI_GEN_INTERNAL;
		// }
		// else if("G".equals(gmiIncludes))
		// {
		// gmiIncludesStr = ConstantsCommon.GMI_FIXED_GEN;
		// }
		// else if("A".equals(gmiIncludes))
		// {
		// gmiIncludesStr = ConstantsCommon.GMI_ALL;
		// }
		else
		{
		    int len = gmiIncludes.length();
		    StringBuffer gmiIncludesStrBfr = new StringBuffer();
		    gmiIncludesStrBfr.append("'").append(gmiIncludes.charAt(0)).append("'");
		    if(len > 1)
		    {
			for(int i = 1; i < len; i++)
			{
			    gmiIncludesStrBfr.append(",'").append(gmiIncludes.charAt(i)).append("'");
			}
		    }
		    gmiIncludesStr = gmiIncludesStrBfr.toString();
		}

		// added by rany used for suspense account in tfa param
		// Bassam Eid - BUG# 721130 - Error when invoking the lookup of
		// any account field
		if(!StringUtil.nullToEmpty(criteria.getAMFStatus()).isEmpty())
		{

		    int len = criteria.getAMFStatus().length();
		    StringBuffer amfStatusStrBfr = new StringBuffer();
		    amfStatusStrBfr.append("'").append(criteria.getAMFStatus().charAt(0)).append("'");
		    if(len > 1)
		    {
			for(int i = 1; i < len; i++)
			{
			    amfStatusStrBfr.append(",'").append(criteria.getAMFStatus().charAt(i)).append("'");
			}
		    }
		    criteria.setAMFStatus(amfStatusStrBfr.toString());
		}
		criteria.setGmiIncludes(gmiIncludesStr);
		criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
		// end rany
	    }

	    if("journalVoucher".equals(lookupCallingScreen))
	    {
		criteria.setGmiIncludes(ConstantsCommon.GMI_ALL);
		//Bassam Eid - BUG# 889686 - ABEI190576 - Manual JV Contra Error
		criteria.setACC_BC(criteria.getBS_CONTRA());
	    }
	    
	    // incident report
	    if("INC01".equals(parentProgRef))  
	    {
		CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
		ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
		ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
		ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);
		if("1".equals(ctsControlVO.getALLOW_INC_REP_CLOSED_ACC_YN()))
		{
		    criteria.setAMFStatus("'" + ConstantsCommon.ACTIVE_ACCOUNT + "','" + ConstantsCommon.INACTIVE_ACCOUNT + "','"
			    + ConstantsCommon.DORMANT_ACCOUNT + "','" + ConstantsCommon.APPLY_FOR_CLOSURE_ACCOUNT + "','" + AccountsConstant.STATUS_CLOSURE_APPROVED + "','" + AccountsConstant.ACC_STATUS_CLOSED + "'");
		}
		
		if(ConstantsCommon.ZERO.equals(ctsControlVO.getACCEPT_INTER_ACC_INC_REP_YN()))
		{
		    criteria.setGmiExcludes("'I'");
		}
		criteria.setFromScreen("IncidentReport");	
		
	    }

	    // condition SUKUK_APP_NAME added for bug #247720
	    if(ConstantsCommon.ASSETS_APP_NAME.equals(sessionCO.getCurrentAppName())
		    || ConstantsCommon.SUKUK_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		if((!(("3").equals(criteria.getTabIdentifier()) || ("2").equals(criteria.getTabIdentifier()))) &&
		// assets security type
		// modified by rany for bugfixing tp id#232109 by adding
		// P00101A reference
			((("P00101MT".equals(originOptRef)) || ("P00101A".equals(originOptRef)))
				&& criteria.getLineNb().compareTo(new BigDecimal(19)) != 0
				&& criteria.getLineNb().compareTo(new BigDecimal(20)) != 0
				&& criteria.getLineNb().compareTo(new BigDecimal(84)) != 0
				&& criteria.getLineNb().compareTo(new BigDecimal(85)) != 0
				&& criteria.getLineNb().compareTo(new BigDecimal(86)) != 0
				&& criteria.getLineNb().compareTo(new BigDecimal(87)) != 0))
		{
		    criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
		}

		// assets transaction type
		if("P00114MT".equals(originOptRef))
		{
		    criteria.setBS_CONTRA(ConstantsCommon.BOTH_GL_TYPE);
		    criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
		    criteria.setBranchCode(sessionCO.getBranchCode());
		    criteria.setBankCifInd(ConstantsCommon.CIF_ALL);
		}
		// added for tp#383867
		if(("S0003MT".equals(originOptRef)) || ("S0001MT".equals(originOptRef)))
		{
		    criteria.setGmiExcludes(ConstantsCommon.GMI_INCLUDE_INTERNAL);
		}
		// end tp#383867
		// portfolio relation file
		if("P0032U".equals(originOptRef) || "P0032MA".equals(originOptRef))
		{

		    // portfolio Cash Account
		    if(BigDecimal.ONE.equals(criteria.getAssetsAccflg()))
		    {

			if(ConstantsCommon.CB_CLIENT.equals(criteria.getPortfolioType()))
			{

			    criteria.setGMI_FLAG(ConstantsCommon.NON_INTERNAL_GEN_LEDGER_TYPE);
			}
			else
			{
			    criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
			    criteria.setGMI_FLAG(ConstantsCommon.BOTH_GL_TYPE);
			}
			criteria.setBankCifInd(ConstantsCommon.CIF_ALL);
		    }

		    // Fiduciary Cash Account
		    if(BigDecimal.valueOf(2).equals(criteria.getAssetsAccflg()))
		    {
			criteria.setBranchCode(sessionCO.getBranchCode());
			//commented/added by abbas for TP#822121
			//if(ConstantsCommon.CB_CLIENT.equals(criteria.getPortfolioType()))
			//{

			if(ConstantsCommon.CB_CLIENT.equals(criteria.getPortfolioType()))
			{

			    criteria.setGMI_FLAG(ConstantsCommon.NON_INTERNAL_GEN_LEDGER_TYPE);
			}
			else
			{

			    criteria.setGMI_FLAG(ConstantsCommon.BOTH_GL_TYPE);
			}
			criteria.setBankCifInd(ConstantsCommon.CIF_ALL);
		    }

		    // portfolio Capital Account
		    if(BigDecimal.valueOf(3).equals(criteria.getAssetsAccflg()))
		    {

			criteria.setBranchCode(sessionCO.getBranchCode());

			if(ConstantsCommon.CB_CLIENT.equals(criteria.getPortfolioType()))
			{

			    criteria.setGMI_FLAG(ConstantsCommon.NON_INTERNAL_GEN_LEDGER_TYPE);
			}
			else
			{
			    criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
			    criteria.setGMI_FLAG(ConstantsCommon.BOTH_GL_TYPE);
			}
			criteria.setBankCifInd(ConstantsCommon.CIF_ALL);
		    }

		    // Other effected Account and deposite account
		    if(BigDecimal.valueOf(4).equals(criteria.getAssetsAccflg()))
		    {

			// added by abbas for TP#627397
			if(ConstantsCommon.YES.equals(criteria.getAllowInputDiffCompYn()))
			{
			    criteria.setCompCode(criteria.getFundCode());
			    criteria.setGMI_FLAG(ConstantsCommon.NON_INTERNAL_GEN_LEDGER_TYPE);
			}
			else
			{
			    criteria.setGMI_FLAG(ConstantsCommon.BOTH_GL_TYPE);
			}
			// end abbas
			criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
			criteria.setGMI_FLAG(ConstantsCommon.BOTH_GL_TYPE);
			criteria.setBankCifInd(ConstantsCommon.CIF_ALL);

		    }

		    // fund Capital and fund cash Accounts
		    if(BigDecimal.valueOf(6).equals(criteria.getAssetsAccflg()))
		    {

			criteria.setBranchCode(BigDecimal.ONE);
			criteria.setCompCode(criteria.getFundCode());
			criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
			criteria.setGMI_FLAG(ConstantsCommon.BOTH_GL_TYPE);

		    }

		}

	    }// TP 481335
	    else if ( ConstantsCommon.IIS_APP_NAME.equals(sessionCO.getCurrentAppName()) || ConstantsCommon.ITRS_APP_NAME.equals(sessionCO.getCurrentAppName())
				|| ConstantsCommon.PROV_APP_NAME.equals(sessionCO.getCurrentAppName()) || ConstantsCommon.ICOR_APP_NAME.equals(sessionCO.getCurrentAppName())
				|| ConstantsCommon.IRET_APP_NAME.equals(sessionCO.getCurrentAppName())
		    )
		   {
			   if(!StringUtil.isNotEmpty(criteria.getAddRef()))
			   {
				   criteria.setAddRef(null);
			   }
		   }

	    // TP 455835 ABARSU160619
	    // in case of transaction screen the scanned cif should work base on
	    // the flag 'Apply Iris To Transaction'
	    // at the level of csm admin transaction type, more over the user
	    // can change it or clear it, so the lookup of accounts
	    // will show all accounts
	    if(!"D001MT".equals(originOptRef) && !"D001CE".equals(originOptRef) && !"D001RE".equals(originOptRef)
		    && !"D001MT".equals(originOptRef) && !"D001CE".equals(originOptRef))
	    {
		// Nabil feghali - Fix Issue #212072
		if(Boolean.valueOf(criteria.getFilterByScannedCIF())
			&& !NumberUtil.isEmptyDecimal(sessionCO.getScannedCIFNo()))
		{
		    criteria.setCifCode(sessionCO.getScannedCIFNo());
		}
	    }
	    if("D001CE".equals(originOptRef))
	    {
		criteria.setAffectPassChq("-1");

		// Nabil feghali - Fix Issue #212072
		if(Boolean.valueOf(criteria.getFilterByScannedCIF())
			&& !NumberUtil.isEmptyDecimal(sessionCO.getScannedCIFNo()))
		{
		    criteria.setCifCode(sessionCO.getScannedCIFNo());
		}
	    }
	    
	    if(isFromIISModule(sessionCO.getCurrentAppName()))
	    {
	    	criteria.setAppName(IISCommonConstants.IIS_APP);
	    }
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
	    /**    by habib Baalbaki   accocunt restriction 372747
	    if(checkNbRec(criteria))
	    {
		setRecords(accountBO.accountListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(accountBO.accountList(criteria));
	  */  
	    
	  //habib accocunt restriction 372747
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    criteria.setPageRef(originOptRef);
	    if(!"P00124MT".equals(originOptRef))
	    {
	    	criteria.setCompCode(sessionCO.getCompanyCode());
	    }
	    criteria.setCheckNbRec(checkNbRec(criteria));
	    criteria = accountBO.returnAccountList(criteria);
	    if(criteria.isCheckNbRec())
	    {
		setRecords(criteria.getTrxMgntNbRecords());
	    }
	    setGridModel(criteria.getAccountListRecords());

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of AccountLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    private boolean isFromIISModule(String appName)
    {
	return ConstantsCommon.IIS_APP_NAME.equals(appName) || ConstantsCommon.ITRS_APP_NAME.equals(appName)
		|| ConstantsCommon.PROV_APP_NAME.equals(appName) || ConstantsCommon.ICOR_APP_NAME.equals(appName)
		|| ConstantsCommon.IRET_APP_NAME.equals(appName);
    }

    /**
     * Fill the lookup account data filtered by the defined criteria
     * 
     * @return
     * @throws JSONException
     */
    public String filldeductFromAccLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setLovType(ConstantsCommon.ACCOUNT_STATUS_LOV_TYPE);
	    criteria.setLangCode(sessionCO.getLanguage());
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    if(StringUtil.isNotEmpty(criteria.getTrxMgntAccountDtlGrid()))
	    {
		GridUpdates gu = getGridUpdates(criteria.getTrxMgntAccountDtlGrid(), TrxMgntAccountDtlCO.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<TrxMgntAccountDtlCO> accDetList = gu.getLstAllRec();
		    int sizeOfAccDetList = accDetList.size();
		    AMFVO amfVO;
		    TrxMgntAccountDtlCO trxMgntAccountDtlCO;
		    for(int i = 0; i < sizeOfAccDetList; i++)
		    {
			trxMgntAccountDtlCO = accDetList.get(i);
			amfVO = new AMFVO();
			amfVO.setBRANCH_CODE(trxMgntAccountDtlCO.getCtstrsACCDETVO().getAC_BR());
			amfVO.setCURRENCY_CODE(trxMgntAccountDtlCO.getCtstrsACCDETVO().getAC_CY());
			amfVO.setGL_CODE(trxMgntAccountDtlCO.getCtstrsACCDETVO().getAC_GL());
			amfVO.setCIF_SUB_NO(trxMgntAccountDtlCO.getCtstrsACCDETVO().getAC_CIF());
			amfVO.setSL_NO(trxMgntAccountDtlCO.getCtstrsACCDETVO().getAC_SL());
			criteria.getAmfList().add(amfVO);
		    }
		}

		// TP 455835 ABARSU160619
		// in case of transaction screen the scanned cif should work
		// base on the flag 'Apply Iris To Transaction'
		// at the level of csm admin transaction type, more over the
		// user can change it or clear it, so the lookup of accounts
		// will show all accounts
		// // Nabil feghali - Fix Issue #212072
		// if(Boolean.valueOf(criteria.getFilterByScannedCIF())
		// && !NumberUtil.isEmptyDecimal(sessionCO.getScannedCIFNo()))
		// {
		// criteria.setCifCode(sessionCO.getScannedCIFNo());
		// }

		if(getRecords() == 0)
		{
		    setRecords(accountBO.deductFromAccountCount(criteria));
		}
		accountCOList = accountBO.deductFromAccountList(criteria);
	    }
	    else
	    {
		setRecords(0);
		accountCOList = new ArrayList<AccountCO>();
	    }

	    setGridModel(accountCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /****
     * Method for constructing lookup for SL_NO of an Account Component (Window
     * : w_lookup_amf_ret_nonint, Used in : General Account Screen)
     * 
     * @return SUCCESS
     */
    public String constructAccountLookup()
    {
	try
	{
	    String[] names = { "amfVO.BRANCH_CODE", "amfVO.CURRENCY_CODE", "amfVO.GL_CODE", "amfVO.CIF_SUB_NO",
		    "amfVO.SL_NO","subsidiary", "amfVO.ADDITIONAL_REFERENCE", "amfVO.IBAN_ACC_NO", "amfVO.AC_SRL",
		    "amfVO.BRIEF_NAME_ENG", "amfVO.LONG_NAME_ENG", "amfVO.FULL_NAME_ENG","amfVO.STATUS ", "amfVO.ADD_STRING5",
		    "amfVO.DATE_OPND", "amfVO.MATURITY_DTE", "rifattVO.CATEGORY", "STATUSDESC" };

	    String[] colTypes = { "number", "number", "number", "number", "number", "number", "text", "text", "number", "text",
		    "text","text", "text", "text", "date", "date", "text", "text" };

	    String[] titles = { getText("Branch_Code_key"), getText("Currency_key"), getText("GL_key"),
		    getText("CIF_key"), getText("SL_key"),getText("subsidiary_key"), getText("AdditionalReference_key"),
		    getText("IBAN_Account_Number_key"), getText("ac_srl_key"), getText("Brief_Name_key"),
		    getText("Long_Name_key"),getText("Full_Name_key"), getText("Status_key"), getText("Old_Reference_key"),
		    getText("Opening_Date_key"), getText("Maturity_Date_key"), getText("Category_key"),
		    getText("status_key"), getText("status_desc_key") };
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("accountList_key"));
	    grid.setRowNum("5");

	    if(lookupCallingScreen != null && ("SOT".equals(lookupCallingScreen)
		    || AccountsConstant.FROM_SCREEN_BILL.equals(lookupCallingScreen)))
	    {
		grid.setUrl("/pathdesktop/AccountLookup_generateAccountListForW_lookup_amf_ret");
	    }
	    else if(lookupCallingScreen != null && "Cards".equals(lookupCallingScreen))
	    {
		grid.setUrl("/pathdesktop/AccountLookup_generateAccountList");
	    }
	    else
	    {
		grid.setUrl(
			"/pathdesktop/AccountLookup_generateAccountList?lookupCallingScreen=" + lookupCallingScreen);
	    }

	    int cols = names.length;
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    for(int i = 0; i < cols; i++)
	    {
		// Defining each columnt
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(names[i]);
		String[] strArray = names[i].split("\\.");
		String value = strArray.length > 1 ? strArray[1] : strArray[0];
		gridColumn.setIndex(value);
		// gridColumn.setIndex(names[i].split("\\.")[1]);
		gridColumn.setColType(colTypes[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		// adding column to the list

		if("amfVO.CURRENCY_CODE".equals(names[i]) || "amfVO.SL_NO".equals(names[i]))
		{
		    gridColumn.setLeadZeros("3");
		}
		else if("amfVO.BRANCH_CODE".equals(names[i]))
		{
		    gridColumn.setLeadZeros("4");
		}
		else if("amfVO.GL_CODE".equals(names[i]))
		{
		    gridColumn.setLeadZeros("6");
		}
		else if("amfVO.CIF_SUB_NO".equals(names[i]))
		{
		    gridColumn.setLeadZeros("8");
		}

		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, criteria);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /****
     * Method for filling the account list data in Account lookup component
     * (Window : w_lookup_amf_ret_nonint, Used in : General Account Screen)
     * 
     * @return SUCCESS
     */
    public String generateAccountList()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(NumberUtil.isEmptyDecimal(criteria.getBranchCode()))
	    {
		criteria.setBranchCode(null);
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getCifCode()))
	    {
		criteria.setCifCode(null);
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getCurrencyCode()))
	    {
		criteria.setCurrencyCode(null);
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getGlCode()))
	    {
		criteria.setGlCode(null);
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getSlNbr()))
	    {
		criteria.setSlNbr(null);
	    }
	    criteria.setBS_CONTRA("B");
	    if(getGmiFlag() == null || "".equalsIgnoreCase(getGmiFlag()))
	    {
		criteria.setGMI_FLAG("X");
	    }
	    else
	    {
		criteria.setGMI_FLAG(getGmiFlag());
	    }
	    criteria.setAffectPassChq("-1");
	    criteria.setCifType("X");
	    criteria.setAFFECT_CARD("0");

	    String originOptRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
	    }

	    if("E003RQ".equals(originOptRef) || "E003GV".equals(originOptRef))
	    {
		criteria.setGMI_FLAG("N");
		criteria.setCifType("C");
	    }

	    if(lookupCallingScreen != null && "Cards".equals(lookupCallingScreen))
	    {
		criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);// lstr_account.s_acc_bc
		// = 'B'
		criteria.setBS_CONTRA("B");
		criteria.setGMI_FLAG("N");// s_gmi_flag = 'N'
		criteria.setAffectPassChq("-1"); // null
		criteria.setAFFECT_CARD("1");// s_card = '1'
		criteria.setCifType("C");
	    }
	    // US 83055 w_outstanding_pft posting of transaction
	    else if("TrxMgntOutStandingProfit".equals(lookupCallingScreen))
	    {
		criteria.setBS_CONTRA("X");
		criteria.setStatus("'C','M','S'");
	    }
	    else if("A002CDAMT".equals(originOptRef))
	    {
		criteria.setBS_CONTRA("X");
		criteria.setStatus("'I','A'");
		criteria.setGMI_FLAG("G");
	    }
	    // TP#201176;Roshin;14/07/2014[start]
	    criteria.setLovType(ConstantsCommon.ACCOUNT_STATUS_LOV_TYPE);
	    criteria.setLangCode(sessionCO.getLanguage());
	    // TP#201176;Roshin;14/07/2014[end]
	    
	    
	    //habib accocunt restriction 372747
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    criteria.setPageRef(originOptRef);
//	    criteria.setUserId(sessionCO.getUserName());
//	    criteria.setCompCode(sessionCO.getCompanyCode());
	    
	/**  by habib Baalbaki   accocunt restriction 372747
	    if(getRecords() == 0)
	    {
		setRecords(accountBO.getAccountsListCount(criteria));
	    }
	    accountCOList = UserMaintAction.getAccountsList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(accountCOList);
	    
	    */
	    
	    criteria.setCheckNbRec(checkNbRec(criteria));
	    criteria = accountBO.returnAllAccountList(criteria);
	    if(criteria.isCheckNbRec())
	    {
		setRecords(criteria.getTrxMgntNbRecords());
	    }
	    /**
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag
	     */
	    setGridModel(criteria.getAccountListRecords());

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /****
     * Method for filling the account list data in Account lookup component
     * (Window : w_lookup_amf_ret, Used in : General Account Screen SOT Popup)
     * 
     * @return SUCCESS
     */
    public String generateAccountListForW_lookup_amf_ret()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(NumberUtil.isEmptyDecimal(criteria.getBranchCode()))
	    {
		criteria.setBranchCode(BigDecimal.ZERO);
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getCifCode()))
	    {
		criteria.setCifCode(new BigDecimal(-1));
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getCurrencyCode()))
	    {
		criteria.setCurrencyCode(BigDecimal.ZERO);
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getGlCode()))
	    {
		criteria.setGlCode(BigDecimal.ZERO);
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getSlNbr()))
	    {
		criteria.setSlNbr(null);
	    }

	    if(lookupCallingScreen != null && ("SOT".equals(lookupCallingScreen)
		    || AccountsConstant.FROM_SCREEN_BILL.equals(lookupCallingScreen)))
	    {
		criteria.setBS_CONTRA("B");
		criteria.setGMI_FLAG("G");
		criteria.setAffectPassChq("-1");
		criteria.setCifType("X");
	    }
	    criteria.setLovType(ConstantsCommon.ACCOUNT_STATUS_LOV_TYPE);
	    criteria.setLangCode(sessionCO.getLanguage());
	    
	    /** habib accocunt restriction 372747
	    if(getRecords() == 0)
	    {
		setRecords(accountBO.accountListCountByBrCyGlCif(criteria));
	    }
	    accountCOList = accountBO.accountListByBrCyGlCif(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(accountCOList);
	     */
	    
	    //habib accocunt restriction 372747
	    String originalProgRef = StringUtil.nullEmptyToValue(returnCommonLibBO().returnOrginProgRef(
		    sessionCO.getCurrentAppName(), get_pageRef()), get_pageRef());
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    criteria.setPageRef(originalProgRef);
//	    criteria.setUserId(sessionCO.getUserName());
//	    criteria.setCompCode(sessionCO.getCompanyCode());
	    
	    criteria.setCheckNbRec(checkNbRec(criteria));
	    criteria = accountBO.returnAccListByBrCyGlCifList(criteria);
	    if(criteria.isCheckNbRec())
	    {
		setRecords(criteria.getTrxMgntNbRecords());
	    }
	    /**
	     * set the collection into gridModel attribute defined at JSP grid tag
	     */
	    setGridModel(criteria.getCifAccList());

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @param accountBO the accountBO to set
     */
    public void setAccountBO(AccountBO accountBO)
    {
	this.accountBO = accountBO;
    }

    public AccountSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(AccountSC criteria)
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

    public String getGmiFlag()
    {
	return gmiFlag;
    }

    public void setGmiFlag(String gmiFlag)
    {
	this.gmiFlag = gmiFlag;
    }

    /****
     * Method for constructing lookup from AMF (Window : w_lookup_bdc)
     * 
     * @return SUCCESS
     */
    public String constructAccountBDCLookup()
    {
	try
	{
	    String[] name = { "SERIAL_NO", "SEQ_NO", "BRANCH_CODE", "CURRENCY_CODE", "GL_CODE", "CIF_SUB_NO", "SL_NO",
		    "BRIEF_NAME_ENG", "FULL_NAME_ENG","OPEN_DEP_TRX_TYPE", "STATUS" };

	    String[] colType = { "number", "number", "number", "number", "number", "number", "number", "text","text", "number",
		    "text" };

	    String[] titles = { "BDC Serial No", "Certificate Deposit No", getText("Branch_Code_key"),
		    getText("Currency_key"), getText("GL_key"), getText("CIF_key"), getText("SL_key"),
		    getText("Brief_Name_key"),getText("Full_Name_key"), getText("Trx_Type_key"), getText("status_key") };
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("accountList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AccountLookup_fillAccountBDCLookupList");

	    lookup(grid, criteria, name, colType, titles);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup account data filtered by the defined criteria
     * (w_lookup_bdc)
     * 
     * @return
     * @throws JSONException
     */
    public String fillAccountBDCLookupList()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(criteria.getCurrencyCode()))
	    {
		setSearchFilter(criteria);
		copyproperties(criteria);
		SessionCO sessionCO = returnSessionObject();
		criteria.setLovType(ConstantsCommon.ACCOUNT_STATUS_LOV_TYPE);
		criteria.setLangCode(sessionCO.getLanguage());
		criteria.setCompCode(sessionCO.getCompanyCode());

		if(getRecords() == 0)
		{
		    setRecords(accountBO.accountsDataBDCListCount(criteria));
		}
		// set the collection into gridModel attribute defined at JSP
		// grid
		setGridModel(accountBO.accountsDataBDCList(criteria));
	    }
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
     * @author EliasAoun
     * @PB w_lookup_amf_report_company_branch ; w_lookup_cif_allbranch is not
     *     used here because we can't populate a lookup on a cif in the account
     * 
     * @author OliviaGhazal w_lookup_amf_new
     * @return
     */
    public String constructAMFReportCompBranch()
    {
	String[] name = { "amfVO.BRANCH_CODE", "amfVO.CURRENCY_CODE", "amfVO.GL_CODE", "amfVO.CIF_SUB_NO",
		"amfVO.SL_NO", "subsidiary", "amfVO.ADDITIONAL_REFERENCE", "amfVO.BRIEF_NAME_ENG", "amfVO.LONG_NAME_ENG",
		"amfVO.FULL_NAME_ENG","amfVO.BRIEF_NAME_ARAB", "amfVO.LONG_NAME_ARAB","amfVO.FULL_NAME_ARAB", "amfVO.STATUS", "amfVO.DIV", "amfVO.DEPT",
		"amfVO.IBAN_ACC_NO" };

	String[] colType = { "number", "number", "number", "number", "number", "number", "text", "text", "text", "text", "text",
		"text", "text", "text", "text", "text", "text" };


	String[] titles = { getText("branchKey"), getText("CY_key"), getText("G/L_key"), getText("CIF_SUB_key"),
		getText("SL_key"), getText("subsidiary_key"), getText("Additional_Reference_key"), getText("BRIEF_NAME_ENG"),
		getText("LONG_NAME_ENG"),getText("Full_Name_key"), getText("Short_Name_Arab_key"), getText("Long_Name_Arab_key"),
		getText("Full_Name_Arab_key"),getText("Status_key"), getText("Division_key"), getText("Department_key"), getText("ibanAccNo_key") };

	/*
	 * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English
	 * Mandatory, 1=Arabic Hidden and English Mandatory, 2= Arabic Visible
	 * and Mandatory And English Mandatory , 3= Arabic Visible and Mandatory
	 * English Not Mandatory).
	 */
	if(returnSessionObject().getHideArabicColumns())
	{

	    name = new String[] { "amfVO.BRANCH_CODE", "amfVO.CURRENCY_CODE", "amfVO.GL_CODE", "amfVO.CIF_SUB_NO",
		    "amfVO.SL_NO", "subsidiary", "amfVO.ADDITIONAL_REFERENCE", "amfVO.BRIEF_NAME_ENG", "amfVO.LONG_NAME_ENG",
		    "amfVO.FULL_NAME_ENG","amfVO.STATUS", "amfVO.DIV", "amfVO.DEPT", "amfVO.IBAN_ACC_NO" };

	    colType = new String[] { "number", "number", "number", "number", "number", "number", "text", "text", "text", "text",
		    "text", "text", "text", "text" };

	    titles = new String[] { getText("branchKey"), getText("CY_key"), getText("G/L_key"), getText("CIF_SUB_key"),
		    getText("SL_key"), getText("subsidiary_key"), getText("Additional_Reference_key"), getText("BRIEF_NAME_ENG"),
		    getText("LONG_NAME_ENG"),getText("Full_Name_key"), getText("Status_key"), getText("Division_key"), getText("Department_key"),
		    getText("ibanAccNo_key") };

	}

	try
	{

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("branchKey"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AccountLookup_fillAMFReportCompBranchLkp");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillAMFReportCompBranchLkp()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setLangCode(sessionCO.getLanguage());
	    // in pb = 0 also
	    // criteria.setAccDiv(BigDecimal.ZERO);
	    // criteria.setAccDept(BigDecimal.ZERO);

	    criteria.setGMI_FLAG("A");
	    criteria.setACC_BC("Z");

	    // String optRef = "";
	    // String[] optDetails = returnCommonLibBO()
	    // .returnOptDetailsList(sessionCO.getCurrentAppName(),
	    // originOptRef);
	    // if(optDetails != null && optDetails.length > 0)
	    // {
	    // optRef = optDetails[4];
	    // }

	    String originOptRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
	    }
	    if("PR0021".equals(originOptRef) || "Y005".equals(originOptRef))
	    {
		criteria.setStatus(" 'A'  , 'I'  , 'T'  , 'P'  ");
	    }

	    if(getRecords() == 0)
	    {
		setRecords(accountBO.getAMFReportCompBranchLkpListCount(criteria));
	    }
	    accountCOList = accountBO.getAMFReportCompBranchLkpList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(accountCOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String constructCoveringAccountLookup()
    {
	try
	{
	    String[] names = { "amfVO.BRANCH_CODE", "amfVO.CURRENCY_CODE", "amfVO.GL_CODE", "amfVO.CIF_SUB_NO",
		    "amfVO.SL_NO", "amfVO.ADDITIONAL_REFERENCE", "amfVO.IBAN_ACC_NO", "amfVO.AC_SRL",
		    "amfVO.BRIEF_NAME_ENG", "amfVO.LONG_NAME_ENG", "amfVO.FULL_NAME_ENG","amfVO.STATUS ", "amfVO.ADD_STRING5",
		    "amfVO.DATE_OPND", "amfVO.MATURITY_DTE", "rifattVO.CATEGORY", "STATUSDESC" };

	    String[] colTypes = { "number", "number", "number", "number", "number", "text", "text", "number", "text",
		    "text","text", "text", "text", "date", "date", "text", "text" };

	    String[] titles = { getText("Branch_Code_key"), getText("Currency_key"), getText("GL_key"),
		    getText("CIF_key"), getText("SL_key"), getText("AdditionalReference_key"),
		    getText("IBAN_Account_Number_key"), getText("ac_srl_key"), getText("Brief_Name_key"),
		    getText("Long_Name_key"), getText("Full_Name_key"), getText("Status_key"), getText("Old_Reference_key"),
		    getText("Opening_Date_key"), getText("Maturity_Date_key"), getText("Category_key"),
		    getText("status_key") };
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("accountList_key"));
	    grid.setRowNum("5");

	    if(lookupCallingScreen != null && ("SOT".equals(lookupCallingScreen)
		    || AccountsConstant.FROM_SCREEN_BILL.equals(lookupCallingScreen)))
	    {
		grid.setUrl("/pathdesktop/AccountLookup_generateAccountListForW_lookup_amf_ret");
	    }
	    else if(lookupCallingScreen != null && "Cards".equals(lookupCallingScreen))
	    {
		grid.setUrl("/pathdesktop/AccountLookup_generateCoveringAccountList");
	    }
	    else
	    {
		grid.setUrl("/pathdesktop/AccountLookup_generateCoveringAccountList?lookupCallingScreen="
			+ lookupCallingScreen);
	    }

	    int cols = names.length;
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    for(int i = 0; i < cols; i++)
	    {
		// Defining each columnt
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(names[i]);
		String[] strArray = names[i].split("\\.");
		String value = strArray.length > 1 ? strArray[1] : strArray[0];
		gridColumn.setIndex(value);
		// gridColumn.setIndex(names[i].split("\\.")[1]);
		gridColumn.setColType(colTypes[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, criteria);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String generateCoveringAccountList()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(NumberUtil.isEmptyDecimal(criteria.getBranchCode()))
	    {
		criteria.setBranchCode(null);
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getCifCode()))
	    {
		criteria.setCifCode(null);
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getCurrencyCode()))
	    {
		criteria.setCurrencyCode(null);
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getGlCode()))
	    {
		criteria.setGlCode(null);
	    }
	    if(NumberUtil.isEmptyDecimal(criteria.getSlNbr()))
	    {
		criteria.setSlNbr(null);
	    }
	    criteria.setBS_CONTRA("B");
	    if(getGmiFlag() == null || "".equalsIgnoreCase(getGmiFlag()))
	    {
		criteria.setGMI_FLAG("G");
	    }
	    else
	    {
		criteria.setGMI_FLAG(getGmiFlag());
	    }

	    // TP#201176;Roshin;14/07/2014[start]
	    criteria.setLovType(ConstantsCommon.ACCOUNT_STATUS_LOV_TYPE);
	    criteria.setLangCode(sessionCO.getLanguage());
	    // TP#201176;Roshin;14/07/2014[end]
	    if(getRecords() == 0)
	    {
		setRecords(accountBO.getCoveringAccountsListCount(criteria));
	    }
	    accountCOList = accountBO.getCoveringAccountsList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(accountCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

}
