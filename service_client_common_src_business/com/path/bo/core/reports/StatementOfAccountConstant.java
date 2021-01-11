package com.path.bo.core.reports;

import java.math.BigDecimal;

import com.path.lib.common.util.StringUtil;

/**
 * 
 * @author EliasAoun
 * 
 */
public class StatementOfAccountConstant
{

    // Processing Clients Statements
    public static final String TRADE_DATE_PAGEREF = "RETCLSTT";
    public static final String TRADE_DATE_NO_TRX_PAGEREF = "RETCLSTT1";
    public static final String VALUE_DATE_PAGEREF = "RSTCLSTV";
    public static final String VALUE_DATE_NO_TRX_PAGEREF = "RSTCLSTV1";
   // Processing Clients Statements
    public static final String CUSTOMIZED_ABAR = "R0266";

    public static final String EXTENDED_REPORT_PAGEREF = "RP";

    public static final BigDecimal EXPORT_TYPE = BigDecimal.valueOf(1429);
  
    public static final class REPORT_SUFFIX
    {
	public static final String MAIN = "M";
	public static final String HEADER = "H";
	public static final String DETAIL = "D";
	public static final String FOOTER = "F";
	public static final String AVAIL = "AV";
    }

    public static final class SCREEN_TYPE
    {
	// general type, standard
	public static final String GENERAL = "GEN";
	// summarized soa
	public static final String SUMMARIZE = "SUM";
	// Boubyan
	public static final String CUSTOMIZED = "CUST";
	//BB ITN
	public static final String CUSTOMIZED_BB_ITM = "R0255";
	//AUBBH statement of account report  TP:306866
	public static final String CUSTOMIZED_AL_HILAL = "R0246";
	
	// global view
	public static final String DASHBOARD = "GLBV";
	// NABIL FEGHALI - IIAB110237 - SOA Charges
	public static final String TRX_CHARGES = "TRX_CHARGES";
	public static final String TRX_CHARGES_APPROVE = "TRX_CHARGES_APPROVE";
	
	//Archive
	public static final String ARCHIVE = "R0240";
	
	// Processing Clients statement
	public static final String TRADE_DATE = "T";
	public static final String VALUE_DATE = "V";

	// Processing Clients statement
	public static final String SUMMARY_DEP_WITHD_T = "R0021";
	public static final String SUMMARY_DEP_WITHD_V = "R0022";
	
	/*
	 *  Processing Clients Statements
	 *  "RETCLSTT" - "RETCLSTT1" - "RSTCLSTV" - "RSTCLSTV1"
	 */
	public static final String PROCESSING_CLIENT_STATEMENT_T = "R0081";
	public static final String PROCESSING_CLIENT_STATEMENT_V = "R0082";
	public static final String PROCESSING_CLIENT_STATEMENT = "R008";
	public static final String PROCESSING_CLIENT_STATEMENT_NO_TRX = "R008N";
	// Processing Clients Statements
	
    }

    
    public static final String PROCESSING_CLIENT_STATEMENT_BS_CONTRA = "Z";

    /*
     * this function returns the type of the report Summary Of Deposits
     * Withdrawals [R0021/R0022]
     * 
     * @param reportType
     */
    public static String returnSummaryDepWithdType(String reportType)
    {
	if(SCREEN_TYPE.SUMMARY_DEP_WITHD_T.equals(reportType))
	{
	    return REPORT_BY_VALUE_DATE;
	}
	else
	{
	    return REPORT_BY_TRADE_DATE;
	}
    }

    // report reference
    public static final class SOA_CLIENT_REF
    {
	public static final String GLOBALVIEW = "GLBVIEW001";
	public static final String SUMMARIZED = "R023";
	public static final String SUMMARIZED_AMANA = "R0243RP";
	public static final String SUMMARIZED_BMO = "R0243BMORP";
	public static final String SUMMARIZED_GAB = "R0247RP";
	public static final String STANDARD = "R108T";
	public static final String BLME = "R075RP";
	public static final String GAB = "GAB_SOA_1";
	public static final String JAIZ = "R0253";
	// in case of sybase
	public static final String CUSTOMIZED = "R024";
	public static final String WIFAK_ACC_STATEMENT= "WIBCSMSOA";
	public static final String CUSTOMIZED_ARCHIVE = "R0240"; // Added by Rania Al-Bitar - BB140230 - Monthly data archiving - 14.x
	public static final String UCB = "R029"; // Youssef ZAKI - UCB120006 - Statement of account changes - 25/11/2019
	public static final String AIB = "R0242";
	public static final String CUSTOMIZED_AGIB = "RET_SOA";
    }


    
    public static final String SUMM_DEPOSIT_WITHD_CB_IND = "C";
    public static final String SUMM_DEPOSIT_WITHD_BS_CONTRA = "B";
    
    public static final BigDecimal ACC_MIN_BR = BigDecimal.valueOf(1);
    public static final BigDecimal ACC_MAX_BR = BigDecimal.valueOf(9999);
    public static final BigDecimal ACC_MIN_CY = BigDecimal.valueOf(1);
    public static final BigDecimal ACC_MAX_CY = BigDecimal.valueOf(999);
    public static final BigDecimal ACC_MIN_GL = BigDecimal.valueOf(1);
    public static final BigDecimal ACC_MAX_GL = BigDecimal.valueOf(999);
    public static final BigDecimal ACC_MIN_CIF = BigDecimal.valueOf(1);
    public static final BigDecimal ACC_MAX_CIF = BigDecimal.valueOf(99999999);
    // because we have account with serial_no = 0
    public static final BigDecimal ACC_MIN_SL = BigDecimal.valueOf(0);
    public static final BigDecimal ACC_MAX_SL = BigDecimal.valueOf(999);
    
    // SYS_PARAM_LOV_TYPE variables
    public static final BigDecimal STMT_PERIODICITY_LOVTYPE = BigDecimal.valueOf(283);
    public static final BigDecimal STMT_PERIODICITY_QUART_G_LOVTYPE = BigDecimal.valueOf(284);// Grego
    public static final BigDecimal STMT_PERIODICITY_QUART_H_LOVTYPE = BigDecimal.valueOf(285);// Hijri
    public static final BigDecimal MONTHS_OF_YEAR_G_LOVTYPE = BigDecimal.valueOf(286);
    public static final BigDecimal MONTHS_OF_YEAR_H_LOVTYPE = BigDecimal.valueOf(287);
    public static final BigDecimal SEMI_ANNUAL_G_LOVTYPE = BigDecimal.valueOf(288);
    public static final BigDecimal SEMI_ANNUAL_H_LOVTYPE = BigDecimal.valueOf(289);

    public static final String GREGORIAN_DATE_FROMAT = "G";
    public static final String HIJRI_DATE_FROMAT = "H";

    public static final String REPORT_BY_VALUE_DATE = "V";
    public static final String REPORT_BY_TRADE_DATE = "T";

    // SOA arguments default values
    public static final String SOA_RA_BALANCE_TYPE_AVAIL = "AVAIL";
    public static final String SOA_AS_ENDWEEK_DAY = "FRI";
    public static final String SOA_RA_OPTION = "N";
    public static final String SOA_AS_STMT_TYPE = "O";
    public static final String SOA_AS_APP_TYPE = "W";
    public static final String SOA_APP_TYPE_SUM_WITHD = "S";
    public static final int SOA_THRESHOLD = 0;
    public static final int SOA_AUTOSWEEP = 0;
    public static final int SOA_CLEARING = 0;

    // STMT_PERIODICITY variables
    public static final String STMT_PERIODICITY_WEEK = "W";
    public static final String STMT_PERIODICITY_MONTH = "M";
    public static final String STMT_PERIODICITY_QUARTERLY = "Q";
    public static final String STMT_PERIODICITY_SEMIANNUAL = "S";
    public static final String STMT_PERIODICITY_YEARLY = "Y";
    public static final String STMT_PERIODICITY_OTHER = "O";

    // Select range by criteria
    public static final int RANGE_CRITERIA_BY_IBAN = 1;
    public static final int RANGE_CRITERIA_BY_ACCOUNT = 2;
    public static final int RANGE_CRITERIA_BY_REFERENCE = 3;
    public static final int RANGE_CRITERIA_BY_CARD_NO = 4;

    // online language
    public static final String ONLINE_LANGUAGE_DEFAULT_LATIN = "O";
    public static final String ONLINE_LANGUAGE_DEFAULT_ARABIC = "D";
    public static final String ONLINE_LANGUAGE_ENGLISH = "E";
    public static final String ONLINE_LANGUAGE_ARABIC = "A";
    

    // SYS_PARAM_SCREEN_DISPLAY
    public static enum SOA_SPSD_ELEMENTS
    {
	MSG_IN_REPORT_ON("msgIncludeInReport", "reportsCO.ctsSoaCtrlVO.MSG_IN_REPORT_ON"), ONLINE_ADD_REF(
		"addReference", "reportsCO.ctsSoaCtrlVO.ONLINE_ADD_REF"), ONLINE_PRINT_LOGO("printLogo",
		"reportsCO.ctsSoaCtrlVO.ONLINE_PRINT_LOGO"), ONLINE_DATE_TYPE("reportByDate",
		"reportsCO.ctsSoaCtrlVO.ONLINE_DATE_TYPE"), ONLINE_REVAL_TRANS("includeRevaluation",
		"reportsCO.ctsSoaCtrlVO.ONLINE_REVAL_TRANS"), CONSOL_MCE_TRS("consolMCETrs",
		"reportsCO.consMCETrs"), ONLINE_REVERSE_TRANS("includeReverse",
		"reportsCO.ctsSoaCtrlVO.ONLINE_REVERSE_TRANS"), INCLUDE_MSG_FOOTER("includeMsgFooter",
		"reportsCO.ctsSoaCtrlVO.INCLUDE_MSG_FOOTER"), INC_STATNO_PRIOR_ON("incrementStmtNbrPriorToPrint",
		"reportsCO.ctsSoaCtrlVO.INC_STATNO_PRIOR_ON"), ONLINE_LANGUAGE("languageOpt",
		"reportsCO.ctsSoaCtrlVO.ONLINE_LANGUAGE"), FROM_IBAN_ACC_NO("lookuptxt_fromIban",
		"reportsCO.amfVOFrom.IBAN_ACC_NO"), TO_IBAN_ACC_NO("lookuptxt_toIban", "reportsCO.amfVOTo.IBAN_ACC_NO"), FROM_ADDITIONAL_REFERENCE(
		"lookuptxt_fromReference", "reportsCO.amfVOFrom.ADDITIONAL_REFERENCE"), TO_ADDITIONAL_REFERENCE(
		"lookuptxt_toReference", "reportsCO.amfVOTo.ADDITIONAL_REFERENCE"), fromCardNo("lookuptxt_fromCardNo",
		"reportsCO.fromCardNo"), toCardNo("lookuptxt_toCardNo", "reportsCO.toCardNo"), STMT_WITHOUT_MVT_ON(
		"includeStmtWithoutMvmt", "reportsCO.ctsSoaCtrlVO.STMT_WITHOUT_MVT_ON"), from_date("from_date",
		"reportsCO.from_date"), to_date("to_date", "reportsCO.to_date"), from_date_hijri("from_date_hijri",
		"reportsCO.from_date_hijri"), to_date_hijri("to_date_hijri", "reportsCO.to_date_hijri"), year(
		"monthYearCategory", "reportsCO.year"), month("monthSubCombo", "reportsCO.month"), FROM_ACCOUNT(
		"pathAccount_fromAccount", "reportsCO.amfVOFrom.BRANCH_CODE"), TO_ACCOUNT("pathAccount_toAccount",
		"reportsCO.amfVOTo.BRANCH_CODE"), GREGO_HIJRI("gregoHijriDateList",
		"reportsCO.ctsSoaCtrlVO.SHOW_HIJRI_DATE"), MSG_CODE("lookuptxt_rifMessageCode",
		"reportsCO.rifMessageVO.MSG_CODE"), CONSOL_MCE_CHARGE("consolMCECharge",
		"reportsCO.ctsSoaCtrlVO.CONSOL_MULTI_CHQ_TRS_SOA_CHRG"),SHOW_OVERDRAFT_DETAILS("showOverdraftAcc","reportsCO.ctsSoaCtrlVO.SHOW_OVERDRAFT_DETAILS_YN");

	private String id;
	private String name;

	SOA_SPSD_ELEMENTS(String id, String name)
	{
	    this.id = id;
	    this.name = name;
	}

	public String getId()
	{
	    return id;
	}

	public void setId(String id)
	{
	    this.id = id;
	}

	public String getName()
	{
	    return name;
	}

	public void setName(String name)
	{
	    this.name = name;
	}

    } 
    
    public static String returnProcessStatementType(String reportType)
	{
	    if(SCREEN_TYPE.PROCESSING_CLIENT_STATEMENT_T.equals(reportType))
	    {
		return REPORT_BY_TRADE_DATE;
	    }
	    else
	    {
		return REPORT_BY_VALUE_DATE;
	    }
	}
	
	public static String returnCheckboxValue(String value)
	{
	    if(!StringUtil.isNotEmpty(value) || "false".equals(value))
	    {
		return "0";
	    }
	    else
	    {
		return "1";
	    }
	}
	


    
    public static final String DATE_OPND = "statementOfAccountsCO.amfvo.DATE_OPND";
    public static final String ID_DATE_OPND = "dtOpened";
    public static final String DATE_CLOSD = "statementOfAccountsCO.amfvo.DATE_CLOSD";
    public static final String ID_DATE_CLOSD = "dtClosed";
    
}