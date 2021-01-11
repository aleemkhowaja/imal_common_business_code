package com.path.bo.core.reports.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.path.bo.admin.branches.BranchesBO;
import com.path.bo.admin.companies.CompaniesBO;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.account.AccountBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.reports.ReportsBO;
import com.path.bo.core.reports.StatementOfAccountConstant;
import com.path.bo.core.reports.StatementOfAccountConstant.SOA_SPSD_ELEMENTS;
import com.path.bo.core.rifcttgl.RifcttGlBO;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.dao.core.reports.ReportsDAO;
import com.path.dbmaps.vo.ACC_NV_CONTROLVO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRSVO;
import com.path.dbmaps.vo.CTSTRS_STATEMENTVO;
import com.path.dbmaps.vo.CTS_SOA_CTRLVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.RIFMESSAGEVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.TMP_REPORTSVOWithBLOBs;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.branches.BranchesSC;
import com.path.vo.admin.companies.CompaniesCO;
import com.path.vo.admin.companies.CompaniesSC;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.trshijridetailcalendar.TrsHijriDetailCalendarSC;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.common.AccRestrictedSC;
import com.path.vo.core.reports.ReportsCO;
import com.path.vo.core.reports.ReportsSC;
import com.path.vo.core.rifcttgl.RifcttGlSC;

/**
 * 
 * @author EliasAoun
 *
 */
public class ReportsBOImpl extends RetailBaseBO implements ReportsBO
{
    private ReportsDAO reportsDAO;
    private BranchesBO branchesBO;
    private RifcttGlBO rifcttGlBO;
    private CompaniesBO companiesBO;
    private AccountBO accountBO;

    public void setReportsDAO(ReportsDAO reportsDAO) { this.reportsDAO = reportsDAO; }
    public void setBranchesBO(BranchesBO branchesBO) { this.branchesBO = branchesBO; }

    public void setRifcttGlBO(RifcttGlBO rifcttGlBO) { this.rifcttGlBO = rifcttGlBO; }
    public void setCompaniesBO(CompaniesBO companiesBO) { this.companiesBO = companiesBO; }
    
    public void setAccountBO(AccountBO accountBO) { this.accountBO = accountBO; }
    
    
    
    @Override
    public ReportsCO checkCompanyDependency(ReportsCO reportsCO) throws BaseException
    {
	ReportsSC reportsSC = new ReportsSC();
	reportsSC.setCompany_code(reportsCO.getCompaniesVO().getCOMP_CODE());
	List<CompaniesCO> theList = call_getCompanyCurrLkpList( reportsSC);
	if( theList == null ||  theList.isEmpty()){
	    throw new BOException( MessageCodes.INCORRECT_COMPANY);
	}else{
	    reportsCO.setCompaniesVO( theList.get(0).getCompaniesVO());
	}
	return reportsCO;
    }
    
    private List<CompaniesCO> call_getCompanyCurrLkpList(ReportsSC reportsSC) throws BaseException
    {
	CompaniesSC criteria = new CompaniesSC();
	criteria.setCompCode(reportsSC.getCompany_code());
	criteria.setNbRec(-1);
	return companiesBO.getCompanyCurrLkpList(criteria);
    }

    @Override
    public ReportsCO getInitData(ReportsCO reportsCO) throws BaseException
    {
	initDefaultValues(reportsCO);
	
	//default branch name desc
	BRANCHESVO branchVO = new BRANCHESVO();
	branchVO.setCOMP_CODE(reportsCO.getLoginCompCode());
	branchVO.setBRANCH_CODE(NumberUtil.nullEmptyToValue(reportsCO.getBranchesVO().getBRANCH_CODE(), reportsCO.getLoginBraCode()));
	branchVO = (BRANCHESVO) genericDAO.selectByPK(branchVO);
	if(branchVO != null)
	{
	    reportsCO.getBranchesVO().setBRIEF_DESC_ENG(
		    ConstantsCommon.PREFERED_LANG_LATIN.equals(reportsCO.getLoginPreferrredLanguage()) ? branchVO
			    .getBRIEF_DESC_ENG() : branchVO.getBRIEF_DESC_ARAB());
	}

	Date to_date = reportsCO.getRunningDate();
	Date from_date = DateUtil.getMonthFirstDay(to_date);
	//reportsCO.setFrom_date(from_date);
	reportsCO.setFrom_date(reportsCO.getRunningDate());//BUG#829389-'To Date' to be maintained as today's date in Reports 
	reportsCO.setTo_date(to_date);
	reportsCO.getCtsSoaCtrlVO().setONLINE_ADD_REF("true") ;
	//NABIL FEGHALI - IIAB110237 - SOA Charges
	if( StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES_APPROVE.equals(reportsCO.get_type()) 
		&& reportsCO.getTrxMgntCO() != null)
	{
	    CTSTRS_STATEMENTVO ctstrsStatementVO = new CTSTRS_STATEMENTVO();
	    CTSTRSVO ctsTrsVO = reportsCO.getTrxMgntCO().getCtstrsVO();
	    ctstrsStatementVO.setCOMP_CODE(ctsTrsVO.getCOMP_CODE());
	    ctstrsStatementVO.setBRANCH_CODE(ctsTrsVO.getBRANCH_CODE());
	    ctstrsStatementVO.setTRS_NO(ctsTrsVO.getTRS_NO());
	    ctstrsStatementVO.setCB_IND(TrxMgntConstant.CLIENT_CB_IND);
	    ctstrsStatementVO.setTRS_TYPE(TrxMgntConstant.TRS_TYPE_CSM);
	    ctstrsStatementVO = (CTSTRS_STATEMENTVO)genericDAO.selectByPK(ctstrsStatementVO);
	    if(ctstrsStatementVO != null)
	    {
		reportsCO.setFrom_date(ctstrsStatementVO.getSOA_DATE_FROM());
		reportsCO.setTo_date(ctstrsStatementVO.getSOA_DATE_TO());
	    }
	}
	reportsCO.setPthCtrlVO(commonLibBO.returnPthCtrl());
	
	//TODO uncomment BLME
//	reportsCO.setReportReference(reportsCO.getOpt());
//	 // used for dynamic SOA that are opened by Client based on paramterization in admin
//	if(StatementOfAccountConstant.DYNAMIC_STATEMENT_OF_ACCOUNT_PAGEREF.equals(reportsCO.getOpt()))
//	{
//	    CTS_SOA_CTRLVO parameterizedSOA = new CTS_SOA_CTRLVO();
//	    parameterizedSOA.setCOMP_CODE(reportsCO.getLoginCompCode());
//	    parameterizedSOA = (CTS_SOA_CTRLVO) genericDAO.selectByPK(parameterizedSOA);
//	    if(parameterizedSOA != null)
//	    {
//		String reportReference = StringUtil.nullEmptyToValue(parameterizedSOA.getDATAWINDOW_NAME(),
//			StatementOfAccountConstant.REPORT_REFERENCE.BOUBYAN);
//		reportsCO.setReportReference(reportReference);
//	    }
//	}
	//Hijri date modif
	//we fill the hijri date property with gregorian value and in jsp it is automatically converted to hijri
	reportsCO.setFrom_date_hijri(reportsCO.getFrom_date());
	reportsCO.setTo_date_hijri(reportsCO.getTo_date());
	applySecurity(reportsCO);

	return reportsCO;
    }
    
    /**
     * @Description this method serves to fill the default values for some elements on load of report screen
     * N.B. : these values may be overwritten later due to additional business conditions 
     * @param reportsCO
     */
    private void initDefaultValues(ReportsCO reportsCO)
    {
	reportsCO.getCtsSoaCtrlVO().setSTMT_WITHOUT_MVT_ON("false");
	reportsCO.getCtsSoaCtrlVO().setMSG_IN_REPORT_ON("false");
	reportsCO.getCtsSoaCtrlVO().setONLINE_DATE_TYPE( StatementOfAccountConstant.REPORT_BY_VALUE_DATE);
    }
    
    /**
     * return the parametrization of SOA control record at the level of Admin
     * @param compCode
     */
	private CTS_SOA_CTRLVO loadCtsSoaCtrl(BigDecimal compCode)
			throws BaseException {
		CTS_SOA_CTRLVO voKey = new CTS_SOA_CTRLVO();
		voKey.setCOMP_CODE(compCode);
		voKey = (CTS_SOA_CTRLVO) genericDAO.selectByPK(voKey);

		// in case the soa control record is not defined, we consider the flags
		// as "0" (not parameterized)
		return voKey == null ? new CTS_SOA_CTRLVO() : voKey;
	}
    
    /**
     * @param reportsCO
     * @description here we show/hide elements
     */
    private void applySecurity(ReportsCO reportsCO) throws BaseException
    {
	String reportType = reportsCO.get_type();
	BigDecimal loginCompCode = reportsCO.getLoginCompCode();

	PTH_CTRLVO pthCtrlVO = reportsCO.getPthCtrlVO();

	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = call_returnAdditionalFieldsParam(reportsCO);
	reportsCO.setHm(hm);
	if(StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED.equals(reportType)
		|| StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES.equals(reportType)
		|| StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED_BB_ITM.equals(reportType)
		|| StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED_AL_HILAL.equals(reportType))
	{
	    reportsCO.setCtsAdminSoaCtrlVO(loadCtsSoaCtrl(loginCompCode));
	    
	    // here I select the defaulted criteria based on admin module flag
	    selectDefaultRangeCriteria(reportsCO);
	    // here I show/hide the elements based on the latter criteria
	    manageRangeByCriteria(reportsCO,false);

	    showHideONLINE_ADD_REF(reportsCO);
	    showHideONLINE_PRINT_LOGO(reportsCO);
	    showHideONLINE_DATE_TYPE(reportsCO);
	    showHideINC_STATNO_PRIOR_ON(reportsCO);
	    showHideINCLUDE_MSG_FOOTER(reportsCO);

	}

	showHideONLINE_LANGUAGE(reportsCO);
	showHideMSG_IN_REPORT_ON(reportsCO);
	showHideSTMT_WITHOUT_MVT_ON(reportsCO);
	showHideONLINE_REVAL_TRANS(reportsCO);
	showHideONLINE_REVERSE_TRANS(reportsCO);

	if(StatementOfAccountConstant.SCREEN_TYPE.SUMMARIZE.equals(reportType))
	{
	    applyDynScreenDisplay("languageOpt_lbl", null, ConstantsCommon.ACTION_TYPE_LABEL,
		    "report_language_format_key", hm, null);
	}
	//NABIL FEGHALI - IIAB110237 - SOA Charges
	if(StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES.equals(reportType))
	{
	    CTS_SOA_CTRLVO ctsSoaCtrlVO = loadCtsSoaCtrl(loginCompCode);
	    if(ctsSoaCtrlVO != null && "Y".equals(ctsSoaCtrlVO.getFORBID_ACC_AMENDMENT()))
	    {
		applyDynScreenDisplay(new String[]{"accBrFrom","accCyFrom","accGlFrom","accCifFrom","lookuptxt_accSlFrom",
		    				"accBrTo","accCyTo","accGlTo","accCifTo","lookuptxt_accSlTo"}, 
		    ConstantsCommon.ACTION_TYPE_READONLY, "1", hm, null);
	    }
	}
	
	if(StatementOfAccountConstant.SCREEN_TYPE.DASHBOARD.equals(reportType)
		|| StatementOfAccountConstant.SCREEN_TYPE.GENERAL.equals(reportType)
		|| StatementOfAccountConstant.SCREEN_TYPE.SUMMARIZE.equals(reportType))
	{
	    applyDynScreenDisplay(new String[] { SOA_SPSD_ELEMENTS.FROM_IBAN_ACC_NO.getId(),
		    SOA_SPSD_ELEMENTS.TO_IBAN_ACC_NO.getId(),
		    SOA_SPSD_ELEMENTS.FROM_ADDITIONAL_REFERENCE.getId(),
		    SOA_SPSD_ELEMENTS.TO_ADDITIONAL_REFERENCE.getId(),
		    SOA_SPSD_ELEMENTS.fromCardNo.getId(), SOA_SPSD_ELEMENTS.STMT_WITHOUT_MVT_ON.getId()
	    		}, ConstantsCommon.ACTION_TYPE_VISIBLE, "0",
		    hm, null);
	}
	
	BigDecimal maintainHijriDate = BigDecimal.ZERO;//suppose hijri not shown
	if(pthCtrlVO != null)
	{
	    maintainHijriDate = NumberUtil.nullEmptyToValue(pthCtrlVO.getMAINTAIN_HIJIRI_DATE(), BigDecimal.ZERO);
	}
	if(maintainHijriDate.compareTo(BigDecimal.ONE) == 0)
	{
	    // todo SPSD
	    applyDynScreenDisplay(SOA_SPSD_ELEMENTS.GREGO_HIJRI.getId(), SOA_SPSD_ELEMENTS.GREGO_HIJRI.getName(),
		    ConstantsCommon.ACTION_TYPE_VISIBLE, "1", hm, null);
	}
	// Hijri date modif
	CTS_SOA_CTRLVO ctsSoaCtrlVO = loadCtsSoaCtrl(loginCompCode);
	String showHijrDate = ConstantsCommon.NO;//suppose hijri not shown
	if(ctsSoaCtrlVO != null)
	{
	    showHijrDate = ctsSoaCtrlVO.getSHOW_HIJRI_DATE();
	}

	reportsCO.setShowDateFormat(true);
	reportsCO.getCtsSoaCtrlVO().setSHOW_HIJRI_DATE(StatementOfAccountConstant.GREGORIAN_DATE_FROMAT);

	 //Abdo TP#419257 25-08-2016
	if(ctsSoaCtrlVO != null)
	{
	    reportsCO.getCtsSoaCtrlVO().setONLINE_DATE_TYPE( reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE());
	    reportsCO.getCtsSoaCtrlVO().setONLINE_LANGUAGE( reportsCO.getCtsSoaCtrlVO().getONLINE_LANGUAGE());
	    reportsCO.getCtsSoaCtrlVO().setMSG_IN_REPORT_ON( reportsCO.getCtsSoaCtrlVO().getMSG_IN_REPORT_ON());
	    reportsCO.getCtsSoaCtrlVO().setONLINE_REVAL_TRANS( reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS());
	}
	 //End Abdo 
	 
	 
	 //Bug 338090 -- [John Massaad]
	//if the flag at the level of PTH ctrl is checked
	if(maintainHijriDate.compareTo(BigDecimal.ONE) == 0)   
	{
	    if(ConstantsCommon.YES.equals(showHijrDate))
		{//showHijrDate = yes
		    applyDynScreenDisplay(new String[] { SOA_SPSD_ELEMENTS.GREGO_HIJRI.getId(),
			    SOA_SPSD_ELEMENTS.from_date.getId(), SOA_SPSD_ELEMENTS.to_date.getId() },
			    ConstantsCommon.ACTION_TYPE_VISIBLE, "0", hm, null);
		    reportsCO.getCtsSoaCtrlVO().setSHOW_HIJRI_DATE(StatementOfAccountConstant.HIJRI_DATE_FROMAT);
		    reportsCO.setShowDateFormat(false);
		}
		else if(ConstantsCommon.NO.equals(showHijrDate))
			
		{ //showHijrDate = no
		    applyDynScreenDisplay(new String[] { SOA_SPSD_ELEMENTS.GREGO_HIJRI.getId(),
			    SOA_SPSD_ELEMENTS.from_date_hijri.getId(), SOA_SPSD_ELEMENTS.to_date_hijri.getId() },
			    ConstantsCommon.ACTION_TYPE_VISIBLE, "0", hm, null);
		    reportsCO.getCtsSoaCtrlVO().setSHOW_HIJRI_DATE(StatementOfAccountConstant.GREGORIAN_DATE_FROMAT);
		    reportsCO.setShowDateFormat(false);
		}else{ //showHijrDate = option
		    applyDynScreenDisplay(new String[] { SOA_SPSD_ELEMENTS.from_date_hijri.getId(),
			    SOA_SPSD_ELEMENTS.to_date_hijri.getId() }, ConstantsCommon.ACTION_TYPE_VISIBLE, "0", hm, null);
		    reportsCO.setShowDateFormat(true);
		}
	    
	}
	else //if the flag at the level of PTH ctrl is not checked
	{
	    applyDynScreenDisplay(new String[] { SOA_SPSD_ELEMENTS.GREGO_HIJRI.getId(),
		    SOA_SPSD_ELEMENTS.from_date_hijri.getId(), SOA_SPSD_ELEMENTS.to_date_hijri.getId() },
		    ConstantsCommon.ACTION_TYPE_VISIBLE, "0", hm, null);
	    reportsCO.getCtsSoaCtrlVO().setSHOW_HIJRI_DATE(StatementOfAccountConstant.GREGORIAN_DATE_FROMAT);
	    reportsCO.setShowDateFormat(false);
	    
	}
//	Bug 338090 -- [John Massaad] 
    }
    
    /**
     * @param reportsCO
     * @param hm, ONLINE_LANGUAGE
     */
    private void showHideONLINE_LANGUAGE(ReportsCO reportsCO) throws BaseException
    {
	String onlineLanguage = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO().getONLINE_LANGUAGE(),
		StatementOfAccountConstant.ONLINE_LANGUAGE_DEFAULT_LATIN);

	String visible = "1", value = ConstantsCommon.PREFERED_LANG_LATIN;

	if(onlineLanguage.equals(StatementOfAccountConstant.ONLINE_LANGUAGE_DEFAULT_ARABIC))
	{
	    value = ConstantsCommon.PREFERED_LANG_ARABIC;
	}
      
	if (onlineLanguage.equals(StatementOfAccountConstant.ONLINE_LANGUAGE_DEFAULT_ARABIC) 
		|| onlineLanguage.equals(StatementOfAccountConstant.ONLINE_LANGUAGE_DEFAULT_LATIN ) )
	{
	  visible = "1";
	}
	else
	{
	    visible = "0";
	}
	
	
	// the elements of the radio list are show/hide in the action
	//reportsCO.getCtsSoaCtrlVO().setINCLUDE_MSG_FOOTER(value);
	reportsCO.getCtsSoaCtrlVO().setONLINE_LANGUAGE(value); //#DN -#608205
	applyDynScreenDisplay(SOA_SPSD_ELEMENTS.ONLINE_LANGUAGE.getId(), SOA_SPSD_ELEMENTS.ONLINE_LANGUAGE
		.getName(), ConstantsCommon.ACTION_TYPE_VISIBLE, visible, reportsCO.getHm(), null);
    }
    
    /**
     * @param reportsCO
     * @param hm, INCLUDE_MSG_FOOTER
     * @throws BaseException
     */
    private void showHideINCLUDE_MSG_FOOTER(ReportsCO reportsCO) throws BaseException
    {
	String includeMsgFooter = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO().getINCLUDE_MSG_FOOTER(),
		"2");

	String visible = "1", checked = "false";
	if("0".equals(includeMsgFooter))
	{
	    visible = "0";
	}
	else if("1".equals(includeMsgFooter))
	{
	    visible = "0";
	    checked = "true";
	}
	reportsCO.getCtsSoaCtrlVO().setINCLUDE_MSG_FOOTER(checked);
	applyDynScreenDisplay(SOA_SPSD_ELEMENTS.INCLUDE_MSG_FOOTER.getId(),
		SOA_SPSD_ELEMENTS.INCLUDE_MSG_FOOTER.getName(), ConstantsCommon.ACTION_TYPE_VISIBLE, visible,
		reportsCO.getHm(), null);
    }
    
    
    /**
     * @param reportsCO
     * @param hm, INC_STATNO_PRIOR_ON
     */
    private void showHideINC_STATNO_PRIOR_ON(ReportsCO reportsCO) throws BaseException
    {
	String incStatNoPriorOn = StringUtil.nullEmptyToValue(
		reportsCO.getCtsAdminSoaCtrlVO().getINC_STATNO_PRIOR_ON(), ConstantsCommon.OPTIONAL);

	String visible = "1", checked = "false";
	if(incStatNoPriorOn.equals(ConstantsCommon.NO))
	{
	    visible = "0";
	}
	else if(incStatNoPriorOn.equals(ConstantsCommon.YES))
	{
	    visible = "0";
	    checked = "true";
	}
	reportsCO.getCtsSoaCtrlVO().setINC_STATNO_PRIOR_ON(checked);
	applyDynScreenDisplay(SOA_SPSD_ELEMENTS.INC_STATNO_PRIOR_ON.getId(),
		SOA_SPSD_ELEMENTS.INC_STATNO_PRIOR_ON.getName(), ConstantsCommon.ACTION_TYPE_VISIBLE, visible,
		reportsCO.getHm(), null);
    }
    
    
    /**
     * @param reportsCO
     * @param hm, ONLINE_REVERSE_TRANS
     * @throws BaseException
     */
    private void showHideONLINE_REVERSE_TRANS(ReportsCO reportsCO) throws BaseException
    {
	String onlineReverseTrans = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO()
		.getONLINE_REVERSE_TRANS(), ConstantsCommon.OPTIONAL);

	String visible = "1", value = "false";
	if(onlineReverseTrans.equals(ConstantsCommon.NO))
	{
	    visible = "0";
	}
	else if(onlineReverseTrans.equals(ConstantsCommon.YES))
	{
	    visible = "0";
	    value = "true";
	}

	String defaultReverseFlag = StringUtil.nullEmptyToValue(coreCommonBO.returnCsmControls()
		.getDEFAULT_REFERSAL_FLAG(), "0");
	if("1".equals(defaultReverseFlag) && "1".equals(visible))
	{
	    value = "true";
	}

	reportsCO.getCtsSoaCtrlVO().setONLINE_REVERSE_TRANS(value);
	applyDynScreenDisplay(SOA_SPSD_ELEMENTS.ONLINE_REVERSE_TRANS.getId(),
		SOA_SPSD_ELEMENTS.ONLINE_REVERSE_TRANS.getName(), ConstantsCommon.ACTION_TYPE_VISIBLE, visible,
		reportsCO.getHm(), null);
    }
    
    /**
     * @param reportsCO
     * @param hm, ONLINE_REVAL_TRANS
     */
    private void showHideONLINE_REVAL_TRANS(ReportsCO reportsCO) throws BaseException
    {
	String onlineRevaltrans = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO().getONLINE_REVAL_TRANS(),
		ConstantsCommon.OPTIONAL);

	String visible = "1", value = "false";
	if(onlineRevaltrans.equals(ConstantsCommon.NO))
	{
	    visible = "0";
	}
	else if(onlineRevaltrans.equals(ConstantsCommon.YES))
	{
	    visible = "0";
	    value = "true";
	}
	reportsCO.getCtsSoaCtrlVO().setONLINE_REVAL_TRANS(value);
	applyDynScreenDisplay(SOA_SPSD_ELEMENTS.ONLINE_REVAL_TRANS.getId(),
		SOA_SPSD_ELEMENTS.ONLINE_REVAL_TRANS.getName(), ConstantsCommon.ACTION_TYPE_VISIBLE, visible,
		reportsCO.getHm(), null);
    }
    
    
    /**
     * @param reportsCO
     * @param hm, ONLINE_DATE_TYPE
     */
    private void showHideONLINE_DATE_TYPE(ReportsCO reportsCO) throws BaseException
    {
	String onlineDateType = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO().getONLINE_DATE_TYPE(),
		ConstantsCommon.OPTIONAL);

	String visible = "1", value = StatementOfAccountConstant.REPORT_BY_TRADE_DATE;//default value(optional)
	if(onlineDateType.equals(StatementOfAccountConstant.REPORT_BY_VALUE_DATE))
	{
	    visible = "0";
	    value = onlineDateType;
	}
	else if(onlineDateType.equals(StatementOfAccountConstant.REPORT_BY_TRADE_DATE))
	{
	    visible = "0";
	}
	reportsCO.getCtsSoaCtrlVO().setONLINE_DATE_TYPE(value);
	applyDynScreenDisplay(SOA_SPSD_ELEMENTS.ONLINE_DATE_TYPE.getId(),
		SOA_SPSD_ELEMENTS.ONLINE_DATE_TYPE.getName(), ConstantsCommon.ACTION_TYPE_VISIBLE, visible,
		reportsCO.getHm(), null);
    }
    
    
    /**
     * @param reportsCO
     * @param hm, ONLINE_PRINT_LOGO
     */
    private void showHideONLINE_PRINT_LOGO(ReportsCO reportsCO) throws BaseException
    {
	String onlinePrintLogo = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO().getONLINE_PRINT_LOGO(),
		ConstantsCommon.OPTIONAL);

	String visible = "1", value = "false";
	if(onlinePrintLogo.equals(ConstantsCommon.NO))
	{
	    visible = "0";
	}
	else if(onlinePrintLogo.equals(ConstantsCommon.YES))
	{
	    visible = "0";
	    value = "true";
	}
	reportsCO.getCtsSoaCtrlVO().setONLINE_PRINT_LOGO(value);
	applyDynScreenDisplay(SOA_SPSD_ELEMENTS.ONLINE_PRINT_LOGO.getId(),
		SOA_SPSD_ELEMENTS.ONLINE_PRINT_LOGO.getName(), ConstantsCommon.ACTION_TYPE_VISIBLE, visible,
		reportsCO.getHm(), null);
    }
    
    /**
     * @param reportsCO
     * @param hm, ONLINE_ADD_REF
     */
    private void showHideONLINE_ADD_REF(ReportsCO reportsCO) throws BaseException
    {
	String showRefStmt = StringUtil.nullEmptyToValue(reportsCO.getPthCtrlVO().getSHOW_REF_STMT(), "1");

	String visible = "1", value = "false";
	if("0".equals(showRefStmt))
	{
	    visible = "0";
	}
	else
	{
	    //if we should show the input
	    String onlineAddRef = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO().getONLINE_ADD_REF(),
		    ConstantsCommon.YES);
	    if(onlineAddRef.equals(ConstantsCommon.NO))
	    {
		visible = "0";
	    }
	    else if(onlineAddRef.equals(ConstantsCommon.YES))
	    {
		visible = "0";
		value = "true";

	    }
	}
	reportsCO.getCtsSoaCtrlVO().setONLINE_ADD_REF(value);
	applyDynScreenDisplay(SOA_SPSD_ELEMENTS.ONLINE_ADD_REF.getId(), SOA_SPSD_ELEMENTS.ONLINE_ADD_REF
		.getName(), ConstantsCommon.ACTION_TYPE_VISIBLE, visible, reportsCO.getHm(), null);
    }
    
    
    /**
     * @param reportsCO
     * @param hm, MSG_IN_REPORT_ON
     */
    private void showHideMSG_IN_REPORT_ON(ReportsCO reportsCO) throws BaseException
    {
	String msgInReportOn = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO().getMSG_IN_REPORT_ON(),
		ConstantsCommon.OPTIONAL);
	String visible = "1", value = "false", readonly = "0";
	
	// hide the element and set the default value
	if(msgInReportOn.equals(ConstantsCommon.NO))
	{
	    visible = "0";
	}
	else if(msgInReportOn.equals(ConstantsCommon.YES))
	{
	    visible = "0";
	    value = "true";
	}
	reportsCO.getCtsSoaCtrlVO().setMSG_IN_REPORT_ON(value);
	msgIncludeInReportDependency(reportsCO);//Abdo TP337060 15/10/2015
	
	applyDynScreenDisplay(SOA_SPSD_ELEMENTS.MSG_IN_REPORT_ON.getId(),
		SOA_SPSD_ELEMENTS.MSG_IN_REPORT_ON.getName(), ConstantsCommon.ACTION_TYPE_VISIBLE, visible,
		reportsCO.getHm(), null);
	//if selected "No"
	if(value=="false")
	{
	    readonly = "1";
	}
	applyDynScreenDisplay(SOA_SPSD_ELEMENTS.MSG_CODE.getId(),
		SOA_SPSD_ELEMENTS.MSG_CODE.getName(), ConstantsCommon.ACTION_TYPE_READONLY, readonly,
		reportsCO.getHm(), null);
	applyDynScreenDisplay("msgIncludeInReport_lbl","msgIncludeInReport_lbl", ConstantsCommon.ACTION_TYPE_VISIBLE, visible,
		reportsCO.getHm(), null);
    }
    
    
    /**
     * @param reportsCO
     * @param hm, STMT_WITHOUT_MVT_ON
     */
    private void showHideSTMT_WITHOUT_MVT_ON(ReportsCO reportsCO) throws BaseException
    {
	String stmtWithoutMvtOn = StringUtil.nullEmptyToValue(
		reportsCO.getCtsAdminSoaCtrlVO().getSTMT_WITHOUT_MVT_ON(), ConstantsCommon.OPTIONAL);
	// hide the element and set the default value
	String visible = "1", value = "false";
	if(stmtWithoutMvtOn.equals(ConstantsCommon.NO))
	{
	    visible = "0";
	}
	else if(stmtWithoutMvtOn.equals(ConstantsCommon.YES))
	{
	    visible = "0";
	    value = "true";
	}
	reportsCO.getCtsSoaCtrlVO().setSTMT_WITHOUT_MVT_ON(value);
	applyDynScreenDisplay(SOA_SPSD_ELEMENTS.STMT_WITHOUT_MVT_ON.getId(),
		SOA_SPSD_ELEMENTS.STMT_WITHOUT_MVT_ON.getName(), ConstantsCommon.ACTION_TYPE_VISIBLE, visible,
		reportsCO.getHm(), null);
    }
    
    
    /**
     * @param reportsCO
     * @throws BaseException 
     */
    private void selectDefaultRangeCriteria(ReportsCO reportsCO) throws BaseException
    {
	BigDecimal loginCompCode = reportsCO.getLoginCompCode();
	BigDecimal loginBranchCode = reportsCO.getLoginBraCode();
	
	int defaultCriteriaToShow = StatementOfAccountConstant.RANGE_CRITERIA_BY_REFERENCE;
	String retrieveByReference = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO()
		.getRETRIEVE_BY_REFERENCE(), ConstantsCommon.NO);
	if(!retrieveByReference.equals(ConstantsCommon.YES))
	{
	    String retrieveByCardNbr = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO()
		    .getRETRIEVE_BY_CARDNO(), ConstantsCommon.YES);
	    if(retrieveByCardNbr.equals(ConstantsCommon.YES))
	    {
		defaultCriteriaToShow = StatementOfAccountConstant.RANGE_CRITERIA_BY_CARD_NO;
	    }
	    else
	    {
		String retrieveByAccount = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO()
			.getRETRIEVE_BY_ACCOUNT(), ConstantsCommon.YES);
		if(retrieveByAccount.equals(ConstantsCommon.YES))
		{
		    defaultCriteriaToShow = StatementOfAccountConstant.RANGE_CRITERIA_BY_ACCOUNT;
		}
		else
		{
		    String retrieveByIBAN = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO()
			    .getRETRIEVE_BY_IBAN(), ConstantsCommon.NO);
		    ACC_NV_CONTROLVO accNVCONTROLVO = new ACC_NV_CONTROLVO();
		    accNVCONTROLVO.setBRANCH_CODE(loginBranchCode);
		    accNVCONTROLVO.setCOMP_CODE(loginCompCode);
		    accNVCONTROLVO = commonLibBO.returnAccountNvCtrl(accNVCONTROLVO);

		    String showIbanAcc = StringUtil.nullEmptyToValue(accNVCONTROLVO.getSHOW_IBAN_ACC(), "0");
		    if("0".equals(showIbanAcc) || retrieveByIBAN.equals(ConstantsCommon.NO))
		    {

			defaultCriteriaToShow = StatementOfAccountConstant.RANGE_CRITERIA_BY_IBAN;
		    }
		}
	    }
	}
	reportsCO.setRangeByCriteria(defaultCriteriaToShow);

    }
    
    private RIFMESSAGEVO call_getMessageByCompLkpList(ReportsCO reportsCO) throws BaseException
    {
	RifcttGlSC criteria = new RifcttGlSC();
	criteria.setCompCode(reportsCO.getLoginCompCode());
	criteria.setNbRec(1);
	List rifMessagelst = rifcttGlBO.getRifMessageByCompLkpList(criteria);
	
	if(rifMessagelst != null && !rifMessagelst.isEmpty()){
	    return (RIFMESSAGEVO) rifMessagelst.get(0);
	}
	
	return null;
    }


    @Override
    public ReportsCO checkBranchByCodeDependency(ReportsCO reportsCO) throws BaseException
    {
	BranchesSC branchesSC = new BranchesSC();
	branchesSC.setPreferredLanguage(reportsCO.getLoginPreferrredLanguage());
	branchesSC.setCompCode(reportsCO.getCompaniesVO().getCOMP_CODE());
	branchesSC.setBranchCode(reportsCO.getBranchesVO().getBRANCH_CODE());
	BRANCHESVO branchesVO = branchesBO.getBranchDescByCodeAndPrefLang(branchesSC);
	if(branchesVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_BRANCH_CODE);
	}
	reportsCO.setBranchesVO(branchesVO);
	return reportsCO;
    }

    @Override
    public ReportsCO checkBeforeGenerate_statementOfAccount(ReportsCO reportsCO) throws BaseException
    {
	BigDecimal loginCompCode = reportsCO.getLoginCompCode();
	BigDecimal loginBranchCode = reportsCO.getLoginBraCode();
	String reportType = reportsCO.get_type();

	String includeRevaluation = reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS();
	String includeReverse = reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS();
	String onlineAddref = reportsCO.getCtsSoaCtrlVO().getONLINE_ADD_REF();

	// checking for exceptions
	checkDataValidity(reportsCO);

	if(StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED.equals(reportType) || StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED_BB_ITM.equals(reportType)|| StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED_AL_HILAL.equals(reportType))
	{
	    checkBeforeGenerate_stmt_boubyan(reportsCO);

	    reportsCO.setCtsAdminSoaCtrlVO(loadCtsSoaCtrl(loginCompCode));

	    // Include Footer Message In Statement
	    String include_footer = "0"/*, footerMsg = ""*/;
	    if(StringUtil.nullEmptyToValue(reportsCO.getCtsSoaCtrlVO().getINCLUDE_MSG_FOOTER(), "false").equals("true"))
	    {
		include_footer = "1";
/*
		String footerMessageEng1 = StringUtil.nullToEmpty(reportsCO.getCtsAdminSoaCtrlVO()
			.getFOOTER_MESSAGE_ENG1());
		String footerMessageEng2 = StringUtil.nullToEmpty(reportsCO.getCtsAdminSoaCtrlVO()
			.getFOOTER_MESSAGE_ENG2());
		String footerMessageAr1 = StringUtil.nullToEmpty(reportsCO.getCtsAdminSoaCtrlVO()
			.getFOOTER_MESSAGE_ARAB1());
		String footerMessageAr2 = StringUtil.nullToEmpty(reportsCO.getCtsAdminSoaCtrlVO()
			.getFOOTER_MESSAGE_ARAB2());

		// latin or arabic
		String onlineLanguage = reportsCO.getCtsSoaCtrlVO().getONLINE_LANGUAGE();

		footerMsg = footerMessageEng1 + " " + footerMessageEng2;
		if(!ConstantsCommon.PREFERED_LANG_LATIN.equals(onlineLanguage))
		{
		    footerMsg = footerMessageAr1 + " " + footerMessageAr2;
		}*/
	    }
	    reportsCO.getCtsSoaCtrlVO().setINCLUDE_MSG_FOOTER(include_footer);

//	    String clearingDetails = "1";// default 
//	    if("N".equals(reportsCO.getCtsAdminSoaCtrlVO().getCLEARING_DETAILS()))
//	    {
//		clearingDetails = "0";
//	    }
//	    else if("C".equals(reportsCO.getCtsAdminSoaCtrlVO().getCLEARING_DETAILS()))
//	    {
//		clearingDetails = "2";
//	    }

	   
	    reportsCO.getCtsSoaCtrlVO().setONLINE_REVAL_TRANS("true".equals(onlineAddref) ? "1" : "0");

	    String onlinePrintLogo = reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO();
	    reportsCO.getCtsSoaCtrlVO().setONLINE_PRINT_LOGO("true".equals(onlinePrintLogo) ? "1" : "0");
	}

	String msgIncludeInReport = reportsCO.getCtsSoaCtrlVO().getMSG_IN_REPORT_ON();
	if(!"true".equals(msgIncludeInReport))
	{
	    reportsCO.setRifMsgDesc("");
	}

	reportsCO.getCtsSoaCtrlVO().setONLINE_REVAL_TRANS("true".equals(includeRevaluation) ? "1" : "0");
	reportsCO.getCtsSoaCtrlVO().setONLINE_REVERSE_TRANS("true".equals(includeReverse) ? "1" : "0");
	reportsCO.getCtsSoaCtrlVO().setONLINE_ADD_REF("true".equals(onlineAddref) ? "1" : "0");
	
//	BigDecimal MAINTAIN_HIJIRI_DATE = commonLibBO.returnPthCtrl().getMAINTAIN_HIJIRI_DATE();
//	if(MAINTAIN_HIJIRI_DATE.compareTo(BigDecimal.ONE) == 0)
//	{
//	    Date from_date = call_returnConvertDateGregoHijri(reportsCO.getFrom_date(),
//		    StatementOfAccountConstant.GREGORIAN_DATE_FROMAT, loginCompCode);
//	    reportsCO.setFrom_date(from_date);
//	}
//	reportsCO.setGregoHijri(StatementOfAccountConstant.GREGORIAN_DATE_FROMAT);

	// Include Teller Accounts
	CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
	ctsControlVO.setCOMP_CODE(loginCompCode);
	ctsControlVO.setBRANCH_CODE(loginBranchCode);
	ctsControlVO = commonLibBO.returnCtsControlDetails(ctsControlVO);

	String TELLER_ACC_POSITION;
	BigDecimal TELLER_ACC_POSITION_LEVEL = null;
	if(ctsControlVO == null)
	{
	    TELLER_ACC_POSITION = "1";
	}
	else
	{
	    TELLER_ACC_POSITION = ctsControlVO.getTELLER_ACC_POSITION();
	    TELLER_ACC_POSITION_LEVEL = NumberUtil.nullEmptyToValue(ctsControlVO.getTELLER_ACC_POSITION_LEVEL(),
		    BigDecimal.TEN);

	}
	reportsCO.setCtsControlVO(ctsControlVO);

	CTSTELLERVO ctsTellerVO = reportsCO.getCtsTellerVO();
	BigDecimal LL_TELLER_LEVEL = BigDecimal.ZERO;
	//in case the report is called from outside csm, they have no teller
	if(ctsTellerVO != null)
	{
	    LL_TELLER_LEVEL = NumberUtil.nullEmptyToValue(ctsTellerVO.getPRIVILEGE_LEVEL(), BigDecimal.TEN);
	}

	if("0".equals(TELLER_ACC_POSITION) && LL_TELLER_LEVEL.compareTo(TELLER_ACC_POSITION_LEVEL) == 1)
	{
	    TELLER_ACC_POSITION = "1";
	}
	
	
	ctsControlVO.setTELLER_ACC_POSITION(TELLER_ACC_POSITION);
	ctsControlVO.setTELLER_ACC_POSITION_LEVEL(TELLER_ACC_POSITION_LEVEL);
	reportsCO.setIsTellerAccount(TELLER_ACC_POSITION);
	msgIncludeInReportDependency(reportsCO); //#DN -#608205
	String reportParams = fillReportParams(reportsCO);
	reportsCO.setReportParams(reportParams);

	//Check access on report reference
	if(StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES.equals(reportsCO.get_type()) && StringUtil.isNotEmpty(reportsCO.getOpt()))
	{
	    CommonLibSC commonLibSC = new CommonLibSC();
	    commonLibSC.setCompCode(loginCompCode);
	    commonLibSC.setBranchCode(loginBranchCode);
	    commonLibSC.setAppName(ConstantsCommon.RET_APP_NAME);
	    commonLibSC.setProgRef(reportsCO.getOpt());
	    commonLibSC.setUserId(reportsCO.getLoginUserId());
	    commonLibSC.setProfType(commonLibBO.returnPthCtrl().getPOP_PROF_MOD_ACCESS());
	    
	    Integer access = commonLibBO.checkAccessByProgRef(commonLibSC);
	    if(access != null && access != 1)
	    {
//		throw new BOException(MessageCodes.NO_ACCESS);
	    }
	}
	
	return reportsCO;
    }


    /**
     * @author EliasAoun
     * @throws BaseException 
     * @description special checking for boubyan
     */
    private void checkBeforeGenerate_stmt_boubyan(ReportsCO reportsCO) throws BaseException
    {
	int rangeByCriteria = reportsCO.getRangeByCriteria() == 0 ? StatementOfAccountConstant.RANGE_CRITERIA_BY_IBAN
		: reportsCO.getRangeByCriteria();
	BigDecimal fromCompanyCode = reportsCO.getCompaniesVO().getCOMP_CODE();
	BigDecimal frombranchCode = reportsCO.getBranchesVO().getBRANCH_CODE();
	
	ReportsSC criteria = new ReportsSC();
	criteria.setCompany_code(fromCompanyCode);
	criteria.setBranch_code(frombranchCode);

	AMFVO fromAmfVO, toAmfVO;
	
	if(rangeByCriteria == StatementOfAccountConstant.RANGE_CRITERIA_BY_REFERENCE)
	{
	    criteria.setReferenceCode(reportsCO.getAmfVOFrom().getADDITIONAL_REFERENCE());
	    fromAmfVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_REFERENCE);
	    reportsCO.getAmfVOFrom().setCURRENCY_CODE(fromAmfVO.getCURRENCY_CODE());
	    reportsCO.getAmfVOFrom().setGL_CODE(fromAmfVO.getGL_CODE());
	    reportsCO.getAmfVOFrom().setCIF_SUB_NO(fromAmfVO.getCIF_SUB_NO());
	    reportsCO.getAmfVOFrom().setSL_NO(fromAmfVO.getSL_NO());
	    reportsCO.getAmfVOFrom().setIBAN_ACC_NO(fromAmfVO.getIBAN_ACC_NO());

	    criteria.setReferenceCode(reportsCO.getAmfVOTo().getADDITIONAL_REFERENCE());
	    toAmfVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_REFERENCE);
	    reportsCO.getAmfVOTo().setCURRENCY_CODE(toAmfVO.getCURRENCY_CODE());
	    reportsCO.getAmfVOTo().setGL_CODE(toAmfVO.getGL_CODE());
	    reportsCO.getAmfVOTo().setCIF_SUB_NO(toAmfVO.getCIF_SUB_NO());
	    reportsCO.getAmfVOTo().setSL_NO(toAmfVO.getSL_NO());
	    reportsCO.getAmfVOTo().setIBAN_ACC_NO(toAmfVO.getIBAN_ACC_NO());

	}
	else if(rangeByCriteria == StatementOfAccountConstant.RANGE_CRITERIA_BY_IBAN)
	{
	    
	    criteria.setIbanCode( reportsCO.getAmfVOFrom().getIBAN_ACC_NO());
	    fromAmfVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_IBAN);
	    reportsCO.getAmfVOFrom().setCURRENCY_CODE(fromAmfVO.getCURRENCY_CODE());
	    reportsCO.getAmfVOFrom().setGL_CODE(fromAmfVO.getGL_CODE());
	    reportsCO.getAmfVOFrom().setCIF_SUB_NO(fromAmfVO.getCIF_SUB_NO());
	    reportsCO.getAmfVOFrom().setSL_NO(fromAmfVO.getSL_NO());
	    reportsCO.getAmfVOFrom().setIBAN_ACC_NO(fromAmfVO.getIBAN_ACC_NO());
	    
	    criteria.setIbanCode( reportsCO.getAmfVOTo().getIBAN_ACC_NO());
	    toAmfVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_IBAN);
	    reportsCO.getAmfVOTo().setCURRENCY_CODE(toAmfVO.getCURRENCY_CODE());
	    reportsCO.getAmfVOTo().setGL_CODE(toAmfVO.getGL_CODE());
	    reportsCO.getAmfVOTo().setCIF_SUB_NO(toAmfVO.getCIF_SUB_NO());
	    reportsCO.getAmfVOTo().setSL_NO(toAmfVO.getSL_NO());
	    reportsCO.getAmfVOTo().setIBAN_ACC_NO(toAmfVO.getIBAN_ACC_NO());
	}
	else
	{
	    // TODO to check if we need this verification or not
	    /* BUG#328202 */
	    BigDecimal fromCurrency = reportsCO.getAmfVOFrom().getCURRENCY_CODE();
	    BigDecimal fromGlCode = reportsCO.getAmfVOFrom().getGL_CODE();
	    BigDecimal fromCifCode = reportsCO.getAmfVOFrom().getCIF_SUB_NO();
	    BigDecimal fromSlNo = reportsCO.getAmfVOFrom().getSL_NO();

	    // BigDecimal toCurrency =
	    // reportsCO.getAmfVOTo().getCURRENCY_CODE();
	    // BigDecimal toGlCode = reportsCO.getAmfVOTo().getGL_CODE();
	    // BigDecimal toCifCode = reportsCO.getAmfVOTo().getCIF_SUB_NO();
	    // BigDecimal toSlNo = reportsCO.getAmfVOTo().getSL_NO();

	    criteria.setAcc_cy_code(fromCurrency);
	    criteria.setAcc_gl_code(fromGlCode);
	    criteria.setAcc_cif_code(fromCifCode);
	    criteria.setAcc_sl_code(fromSlNo);

	    // criteria.setAcc_cy_code(toCurrency);
	    // criteria.setAcc_gl_code(toGlCode);
	    // criteria.setAcc_cif_code(toCifCode);
	    // criteria.setAcc_sl_code(toSlNo);

	    criteria.setCardNo(reportsCO.getFromCardNo());
	    if(rangeByCriteria == StatementOfAccountConstant.RANGE_CRITERIA_BY_CARD_NO)
	    {
		fromAmfVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_CARD_NO);
		reportsCO.getAmfVOFrom().setADDITIONAL_REFERENCE(fromAmfVO.getADDITIONAL_REFERENCE());

//		toAmfVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_CARD_NO);
		reportsCO.getAmfVOTo().setADDITIONAL_REFERENCE(fromAmfVO.getADDITIONAL_REFERENCE());
	    }
//	    else if(rangeByCriteria == StatementOfAccountConstant.RANGE_CRITERIA_BY_ACCOUNT)
//	    {
//		if(NumberUtil.nullToZero(toCurrency).compareTo(BigDecimal.ZERO) != 0
//			&& NumberUtil.nullToZero(toGlCode).compareTo(BigDecimal.ZERO) != 0
//			&& NumberUtil.nullToZero(toCifCode).compareTo(BigDecimal.ZERO) != 0
//			&& NumberUtil.nullToZero(toCifCode).compareTo(BigDecimal.ZERO) != 0)
//		{
//		    fromAmfVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_ACCOUNT);
//		    reportsCO.getAmfVOFrom().setADDITIONAL_REFERENCE(fromAmfVO.getADDITIONAL_REFERENCE());
//		    reportsCO.getAmfVOFrom().setIBAN_ACC_NO(fromAmfVO.getIBAN_ACC_NO());
//		}
//		if(NumberUtil.nullToZero(toCurrency).compareTo(ConstantsCommon.MAXIMUM_SL) != 0
//			&& NumberUtil.nullToZero(toGlCode).compareTo(BigDecimal.valueOf(999999)) != 0
//			&& NumberUtil.nullToZero(toCifCode).compareTo(ConstantsCommon.MAXIMUM_CIF) != 0
//			&& NumberUtil.nullToZero(toCifCode).compareTo(ConstantsCommon.MAXIMUM_CIF) != 0)
//		{
//		    toAmfVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_ACCOUNT);
//		    reportsCO.getAmfVOTo().setADDITIONAL_REFERENCE(toAmfVO.getADDITIONAL_REFERENCE());
//		    reportsCO.getAmfVOTo().setIBAN_ACC_NO(toAmfVO.getIBAN_ACC_NO());
//		}
//	    }
	}
    }
    
    
    /**
     * @param reportsCO
     * @return the parameters that should be sent to the report based on its reference(progRef)
     */
    /**
     * @param reportsCO
     * @return
     * @throws BaseException
     */
    private String fillReportParams(ReportsCO reportsCO)  throws BaseException
    {
	String reportParams = "";
	String reportType = reportsCO.get_type();
		
	// in case the user does have the ability to choose between Hijri/Grego (based on Admin parameterization)
	//i suppose that hes chooses Grego unless the right parameterization for selecting Hijri from Admin is done 
	String gregoHijriFlag = StringUtil.nullEmptyToValue(reportsCO.getCtsSoaCtrlVO().getSHOW_HIJRI_DATE(),
		StatementOfAccountConstant.GREGORIAN_DATE_FROMAT);
	//in case the option is invisible
	if(!StringUtil.isNotEmpty(reportsCO.getCtsSoaCtrlVO().getSHOW_HIJRI_DATE()))
	{
	    PTH_CTRLVO pthCtrlVO = commonLibBO.returnPthCtrl();
	    if(pthCtrlVO != null
		    && NumberUtil.nullEmptyToValue(pthCtrlVO.getMAINTAIN_HIJIRI_DATE(), BigDecimal.ZERO).compareTo(
			    BigDecimal.ONE) == 0)
	    {
		CTS_SOA_CTRLVO soaVO = loadCtsSoaCtrl(reportsCO.getLoginCompCode());
		if(soaVO != null
			&& StringUtil.nullEmptyToValue(soaVO.getSHOW_HIJRI_DATE(), ConstantsCommon.NO).equals(
				ConstantsCommon.YES))
		{
		    gregoHijriFlag = StatementOfAccountConstant.HIJRI_DATE_FROMAT;
		}
	    }
	}
	reportsCO.getCtsSoaCtrlVO().setSHOW_HIJRI_DATE(gregoHijriFlag);
	CTS_SOA_CTRLVO parameterizedSOA = loadCtsSoaCtrl(reportsCO.getLoginCompCode());

	/*
	 * if the report is opened Processing Clients Statements
	 */
	if(StatementOfAccountConstant.SCREEN_TYPE.TRADE_DATE.equals(reportType)
		|| StatementOfAccountConstant.SCREEN_TYPE.VALUE_DATE.equals(reportType))
	{
	    if(StatementOfAccountConstant.SCREEN_TYPE.TRADE_DATE.equals(reportType))
	    {
		if("true".equals(reportsCO.getPrintStmtIfNoTrx()))
		{
		    reportsCO.setOpt(StatementOfAccountConstant.TRADE_DATE_NO_TRX_PAGEREF
			    .concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
		}
		else
		{
		    reportsCO.setOpt(StatementOfAccountConstant.TRADE_DATE_PAGEREF
			    .concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
		}
	    }
	    else
	    {
		if("true".equals(reportsCO.getPrintStmtIfNoTrx()))
		{
		    reportsCO.setOpt(StatementOfAccountConstant.VALUE_DATE_NO_TRX_PAGEREF
			    .concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
		}
		else
		{
		    reportsCO.setOpt(StatementOfAccountConstant.VALUE_DATE_PAGEREF
			    .concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
		}
	    }
	    reportParams = CommonMethods.generateReportParams(reportsCO.getLoginCompCode(),// RA_COMPANY_CODE
		    reportsCO.getLoginBraCode(),// RA_BRANCH_CODE
		    reportsCO.getStmtPeriodicity(),// RA_STMT_PERIOD
		    //#334115 i have removed one day, in order to calculate accurate brought forward in P_GET_BF_BALANCE 
		    DateUtil.format(getDaysBefore(reportsCO.getFrom_date(),1), DateUtil.DEFAULT_DATE_FORMAT),// RA_FR_DATE
		    DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_TO_DATE
		    reportsCO.getBs_contra(),// RA_BC_IND
		    reportsCO.getBaseCurrencyCode(),// RA_BASECY
		    reportsCO.getBaseCurrDecPoint(),// RA_BASECY_DEC
		    reportsCO.getLoginPreferrredLanguage(),// RA_LANGUAGE
		    DateUtil.format(reportsCO.getRunningDate(), DateUtil.DEFAULT_DATE_FORMAT),// RA_RUNNING_DATE
		    reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FROM_CIF
		    reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
		    reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FROM_GL
		    reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
		    reportsCO.getExcludeSuspendedAccounts(),// RA_SUSPENDED
		    reportsCO.getExcludeDeletedAccounts(),// RA_DELETED
		    reportsCO.getLoginUserId(),// RA_USERID
		    reportsCO.getOpt(),// RA_REFERENCE
		    reportsCO.getCtsSoaCtrlVO().getSHOW_HIJRI_DATE(),// RA_GREGO_HIJRI
		    DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT), DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
		    StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
		    StatementOfAccountConstant.SOA_RA_OPTION,// AS_OPTION
		    StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
		    StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
		    StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
		    StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
		    StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
		    StatementOfAccountConstant.SOA_AS_APP_TYPE,// AS_APP_TYPE
		    null,//ADV_ERROR
		    null,//AS_ERR_MESS 
		    StatementOfAccountConstant.returnProcessStatementType(reportType),// RA_VT, value date
		    StatementOfAccountConstant.ACC_MAX_SL, //RA_TO_SL
		    StatementOfAccountConstant.ACC_MIN_SL, //RA_FR_SL
		    StatementOfAccountConstant.ACC_MIN_CY, //RA_FR_CY
		    StatementOfAccountConstant.ACC_MAX_CY, //RA_TO_CY
		    0, //RA_INCLUDE_REVEAL
		    0);//RA_INCLUDE_REVERSE
	}
	else if(StatementOfAccountConstant.SCREEN_TYPE.GENERAL.equals(reportType)
		|| StatementOfAccountConstant.SCREEN_TYPE.DASHBOARD.equals(reportType)
		|| StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES.equals(reportType))
	{
		
	    if(!StatementOfAccountConstant.SCREEN_TYPE.GENERAL.equals(reportType) && parameterizedSOA.getREPORT_REFERENCE_IN_TRX()!=null && !parameterizedSOA.getREPORT_REFERENCE_IN_TRX().isEmpty())
	    {
		reportParams=fillCustomizedParameters(reportsCO, reportParams, parameterizedSOA.getREPORT_REFERENCE_IN_TRX());
		reportsCO.setOpt( parameterizedSOA.getREPORT_REFERENCE_IN_TRX());		
		reportsCO.getCtsSoaCtrlVO().setONLINE_LANGUAGE(reportsCO.getLanguage());

	    }
	    else
	    {
	    reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
		    reportsCO.getBranchesVO().getBRANCH_CODE(),// RA_BRANCH
		    reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FR_CY
		    reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_GL
		    reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FR_CIF
		    reportsCO.getAmfVOFrom().getSL_NO(),// RA_FR_SL
		    reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
		    reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
		    reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
		    reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL
		    DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
		    DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
		    reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT,
								      // value
								      // date
		    reportsCO.getBaseCurrencyCode(),// RA_BASE_CY
		    reportsCO.getCompaniesVO().getBRIEF_DESC_ENG(),// RA_COMP_NAME
		    reportsCO.getBranchesVO().getBRIEF_DESC_ENG(),// RA_BRANCH_NAME

		    reportsCO.getLoginUserId(),// RA_USERID
		    "R",// RA_REF
		    DateUtil.format(reportsCO.getRunningDate(), DateUtil.DEFAULT_DATE_FORMAT),// RA_SYS_DATE
		    reportsCO.getRifMsgDesc(),// RA_MESSAGE
		    reportsCO.getCtsSoaCtrlVO().getONLINE_LANGUAGE(),// RA_LANGUAGE
		    reportsCO.getLoginBraCode(),// RA_BR
		    reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
		    reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS(),// RA_INCLUDE_REVERSE
		    reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
		    reportsCO.getCtsSoaCtrlVO().getSHOW_HIJRI_DATE(),// RA_GREGO_HIJRI
		    StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// RA_AVAIL_USERID
		    StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
		    DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT),
			    DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
		    StatementOfAccountConstant.SOA_RA_OPTION,// RA_OPTION
		    StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
		    StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
		    StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
		    StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
		    StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
		    StatementOfAccountConstant.SOA_AS_APP_TYPE// AS_APP_TYPE
		    );
	    reportsCO.getCtsSoaCtrlVO().setONLINE_LANGUAGE(reportsCO.getLanguage());
	    reportsCO.setOpt("R108T".concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
	    }
	}
	else if(StatementOfAccountConstant.SCREEN_TYPE.SUMMARIZE.equals(reportType))
	{
	    // in this report the report language is selected from the screen
	    reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
		    reportsCO.getAmfVOFrom().getBRANCH_CODE(),// RA_BRANCH
		    reportsCO.getAmfVOTo().getBRANCH_CODE(),// RA_BRANCH
		    DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
		    DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
		    reportsCO.getBaseCurrencyCode(),// RA_BASE_CY
		    reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FR_CY
		    reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
		    reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_GL
		    reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
		    reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FR_CIF
		    reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
		    reportsCO.getAmfVOFrom().getSL_NO(),// RA_FR_SL
		    reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL
		    reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT
		    reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
		    reportsCO.getLoginUserId(),// RA_USERID
		    "1",// RA_INCLUDE_REVERSE
		    reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
		    reportsCO.getCtsSoaCtrlVO().getSHOW_HIJRI_DATE(),// RA_GREGO_HIJRI
		    StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
		    StatementOfAccountConstant.SOA_AS_APP_TYPE,// AS_APP_TYPE
		    StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
		    DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT),
			    DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
		    StatementOfAccountConstant.SOA_RA_OPTION,// RA_OPTION
		    StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
		    StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
		    StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
		    StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
		    reportsCO.getLoginPreferrredLanguage()// RA_LANGUAGE
		    );

	    reportsCO.setOpt(reportsCO.getOpt().concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
	}
	else if( StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED_BB_ITM.equals(reportType))
	    {
		reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
			reportsCO.getBranchesVO().getBRANCH_CODE(),// RA_FROM_BR
			reportsCO.getBranchesVO().getBRANCH_CODE(),// RA_TO_BR
			DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
			DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
			reportsCO.getBaseCurrencyCode(),// RA_BASE_CY
			reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FR_CY
			reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
			reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_GL
			reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
			reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FR_CIF
			reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
			reportsCO.getAmfVOFrom().getSL_NO(),// RA_FR_SL
			reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL

			reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT,
			reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
			reportsCO.getLoginUserId(),// RA_USERID
			reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS(),// RA_INCLUDE_REVERSE
			reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
			"0", // RS_SHOW_REF
			reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO(),// RS_SHOW_LOGO
			StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
			StatementOfAccountConstant.SOA_AS_APP_TYPE,// AS_APP_TYPE
			StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
			DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT),
				DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
			StatementOfAccountConstant.SOA_RA_OPTION,// RA_OPTION
			StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
			//#BUG 509866 :send 1 to fill table CY_WORK_DAYS_TMP in procedure by calling P_INSERT_CY_WRK_DAYS
			"1",//StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING 
			StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
			StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
			"L");
	    reportsCO.setOpt(StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED_BB_ITM.concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));

		return reportParams;
	    }
	else if( StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED_AL_HILAL.equals(reportType))
	    {
		reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
			reportsCO.getBranchesVO().getBRANCH_CODE(),// RA_FROM_BR
			reportsCO.getBranchesVO().getBRANCH_CODE(),// RA_TO_BR
			DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
			DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
			reportsCO.getBaseCurrencyCode(),// RA_BASE_CY
			reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FR_CY
			reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
			reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_GL
			reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
			reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FR_CIF
			reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
			reportsCO.getAmfVOFrom().getSL_NO(),// RA_FR_SL
			reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL

			reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT,
			reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
			reportsCO.getLoginUserId(),// RA_USERID
			reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS(),// RA_INCLUDE_REVERSE
			reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
			"0", // RS_SHOW_REF
			reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO(),// RS_SHOW_LOGO
			StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
			StatementOfAccountConstant.SOA_AS_APP_TYPE,// AS_APP_TYPE
			StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
			DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT),
				DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
			StatementOfAccountConstant.SOA_RA_OPTION,// RA_OPTION
			StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
			//#BUG 509866 :send 1 to fill table CY_WORK_DAYS_TMP in procedure by calling P_INSERT_CY_WRK_DAYS
			"1",//StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING 
			StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
			StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
			"L");
	    reportsCO.setOpt(StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED_AL_HILAL.concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));

		return reportParams;
	    }
	/** 
	 * Added by Rania Al-Bitar 
	 * BB140230 - Monthly data archiving - 14.x
	 */
	else if(StatementOfAccountConstant.SOA_CLIENT_REF.CUSTOMIZED_ARCHIVE.equals(reportType))
	{
	    // in this report the report language is selected from the screen
	    reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
		    reportsCO.getAmfVOFrom().getBRANCH_CODE(),// RA_FROM_BR
		    reportsCO.getAmfVOTo().getBRANCH_CODE(),// RA_TO_BR
		    DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_FROM_DATE
		    DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_TO_DATE
		    reportsCO.getBaseCurrencyCode(),// RA_BASE_CY
		    reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FROM_CY
		    reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
		    reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FROM_GL
		    reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
		    reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FROM_CIF
		    reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
		    reportsCO.getAmfVOFrom().getSL_NO(),// RA_FROM_SL
		    reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL
		    reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT
		    reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
		    reportsCO.getLoginUserId(),// RA_USERID
		    "1",// RA_INCLUDE_REVERSE
		    reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
		    "0",// 	RS_SHOW_REF
                    reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO(),// RS_SHOW_LOGO
		    StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
		    StatementOfAccountConstant.SOA_AS_APP_TYPE,// AS_APP_TYPE
		    StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
				DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT),
					DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
			    StatementOfAccountConstant.SOA_RA_OPTION,// RA_OPTION
			    StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
			    StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
			    StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
			    StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
			    reportsCO.getLoginPreferrredLanguage(),// RA_LANGUAGE
			    null,//ADV_ERROR
			    null,//AS_ERR_MESS
			    ""//AS_DATABASE
	    );
	    reportsCO.setOpt(reportsCO.getOpt().concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
	}
	else if(StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED.equals(reportType))
	{
	    /*
	     * if the report is related to SOA, we should retrieve its default
	     * reference parameterized in admin as each client will set its own
	     * SOA
	     */

	    if(parameterizedSOA != null)
	    {
		String reportReference = parameterizedSOA.getDATAWINDOW_NAME();
		if(StringUtil.isNotEmpty(reportReference))
		{
		    /*
		     * if we open the report from Dashboard screen, we should
		     * then open the default report
		     */
		    if(StatementOfAccountConstant.SCREEN_TYPE.DASHBOARD.equals(reportType)
			    || StatementOfAccountConstant.SCREEN_TYPE.GENERAL.equals(reportType)
			    || StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES.equals(reportType))
		    {
			reportsCO.setOpt(reportReference);
		    }
		    reportsCO.setOpt(reportReference);

		    if(StatementOfAccountConstant.SOA_CLIENT_REF.SUMMARIZED_AMANA.equals(reportReference))
		    {
			reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
				reportsCO.getAmfVOFrom().getBRANCH_CODE(),// RA_BRANCH
				reportsCO.getAmfVOTo().getBRANCH_CODE(),// RA_BRANCH
				DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
				DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
				reportsCO.getBaseCurrencyCode(),// RA_BASE_CY

				reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FR_CY
				reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
				reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_GL
				reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
				reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FR_CIF
				reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
				reportsCO.getAmfVOFrom().getSL_NO(),// RA_FR_SL
				reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL

				reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT
										  // value
										  // date
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
				reportsCO.getLoginUserId(),// RA_USERID
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS(),// RA_INCLUDE_REVERSE
				reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
				"0", // RS_SHOW_REF
				reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO(),// RS_SHOW_LOGO
				StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
				StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
				DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT),
					DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
				StatementOfAccountConstant.SOA_RA_OPTION,// AS_OPTION
				StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
				StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
				StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
				StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
				"EN");
		    }
		    else if(StatementOfAccountConstant.SOA_CLIENT_REF.SUMMARIZED_GAB.equals(reportReference))
		    {
			reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
				reportsCO.getAmfVOFrom().getBRANCH_CODE(),// RA_BRANCH
				reportsCO.getAmfVOTo().getBRANCH_CODE(),// RA_BRANCH
				DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
				DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
				reportsCO.getBaseCurrencyCode(),// RA_BASE_CY

				reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FR_CY
				reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
				reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_GL
				reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
				reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FR_CIF
				reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
				reportsCO.getAmfVOFrom().getSL_NO(),// RA_FR_SL
				reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL

				reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT
										  // value
										  // date
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
				reportsCO.getLoginUserId(),// RA_USERID
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS(),// RA_INCLUDE_REVERSE
				reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
				StringUtil.nullEmptyToValue(reportsCO.getCtsSoaCtrlVO().getONLINE_ADD_REF(), "0"), // RS_SHOW_REF
				reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO(),// RS_SHOW_LOGO
				StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
				StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
				DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT),
					DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
				StatementOfAccountConstant.SOA_RA_OPTION,// AS_OPTION
				StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
				StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
				StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
				StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
				"EN",
				reportsCO.getCtsSoaCtrlVO().getSHOW_HIJRI_DATE());
		    }
		    //FALHA ABAR130036 - Statement of Account Changes
		    else if(StatementOfAccountConstant.CUSTOMIZED_ABAR.equals(reportReference))
		    {
			
	/*		reportsCO.getAmfVOFrom().setGL_CODE(new BigDecimal(0));

		
			reportsCO.getAmfVOTo().setGL_CODE(new BigDecimal(0));

		
			reportsCO.getAmfVOFrom().setCIF_SUB_NO(new BigDecimal(0));

		
			reportsCO.getAmfVOTo().setCIF_SUB_NO(new BigDecimal(0));*/
			//falha Additional Reference is included under SOA
			String ONLINE_ADD_REF=StringUtil.nullEmptyToValue(parameterizedSOA.getONLINE_ADD_REF(), "0");
			if ("Y".equals(ONLINE_ADD_REF))
			{
			    ONLINE_ADD_REF="1";
			}
			else
			{
			    ONLINE_ADD_REF="0";  
			}
			//Additional Reference is included under SOA
			reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
				reportsCO.getAmfVOFrom().getBRANCH_CODE(),// RA_BRANCH
				reportsCO.getAmfVOTo().getBRANCH_CODE(),// RA_BRANCH
				DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
				DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
				reportsCO.getBaseCurrencyCode(),// RA_BASE_CY

				reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FR_CY
				reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
				reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_GL
				reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
				reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FR_CIF
				reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
				reportsCO.getAmfVOFrom().getSL_NO(),// RA_FR_SL
				reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL

				reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT
										  // value
										  // date
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
				reportsCO.getLoginUserId(),// RA_USERID
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS(),// RA_INCLUDE_REVERSE
				reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
				ONLINE_ADD_REF, // RS_SHOW_REF
				reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO(),// RS_SHOW_LOGO
				"",//RA_MESS
				reportsCO.getLoginBraCode(),//RA_BRANCH
				
				StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
				StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
				DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT),
					DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
				StatementOfAccountConstant.SOA_RA_OPTION,// AS_OPTION
				StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
				StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
				StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
				StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
				"EN"
				//,reportsCO.getCtsSoaCtrlVO().getSHOW_HIJRI_DATE()
				);
			reportsCO.setOpt(reportsCO.getOpt().concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
			return reportParams;
		    }    //END FALHA ABAR130036 - Statement of Account Changes
		    else if(StatementOfAccountConstant.SOA_CLIENT_REF.CUSTOMIZED.equals(reportReference))
		    {
			reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
				reportsCO.getBranchesVO().getBRANCH_CODE(),// RA_FROM_BR
				reportsCO.getBranchesVO().getBRANCH_CODE(),// RA_TO_BR
				DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
				DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
				reportsCO.getBaseCurrencyCode(),// RA_BASE_CY
				reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FR_CY
				reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
				reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_GL
				reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
				reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FR_CIF
				reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
				reportsCO.getAmfVOFrom().getSL_NO(),// RA_FR_SL
				reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL

				reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT,
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
				reportsCO.getLoginUserId(),// RA_USERID
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS(),// RA_INCLUDE_REVERSE
				reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
				reportsCO.getCtsSoaCtrlVO().getONLINE_ADD_REF(), // RS_SHOW_REF
				reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO(),// RS_SHOW_LOGO
				StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
				StatementOfAccountConstant.SOA_AS_APP_TYPE,// AS_APP_TYPE
				StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
				DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT), DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
				StatementOfAccountConstant.SOA_RA_OPTION,// RA_OPTION
				StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
				StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
				StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
				StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
				"L");

			reportsCO.setOpt(reportsCO.getOpt().concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
			return reportParams;
		    }
		    else if(StatementOfAccountConstant.SOA_CLIENT_REF.BLME.equals(reportReference))  //-- TO COPY TO 14.1
		    {
			reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
				reportsCO.getBranchesVO().getBRANCH_CODE(),// RA_FROM_BR
				reportsCO.getBranchesVO().getBRANCH_CODE(),// RA_TO_BR
				DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
				DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
				reportsCO.getBaseCurrencyCode(),// RA_BASE_CY
				reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FR_CY
				reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
				reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_GL
				reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
				reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FR_CIF
				reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
				reportsCO.getAmfVOFrom().getSL_NO(),// RA_FR_SL
				reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL

				reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT,
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
				reportsCO.getLoginUserId(),// RA_USERID
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS(),// RA_INCLUDE_REVERSE
				reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
				"0", // RS_SHOW_REF
				reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO(),// RS_SHOW_LOGO
				    reportsCO.getCtsSoaCtrlVO().getSHOW_HIJRI_DATE(),// RA_GREGO_HIJRI
				"1",//RS_INCL_VAL
				"1",//RS_SHOW_INTERNAL
				StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
				StatementOfAccountConstant.SOA_AS_APP_TYPE,// AS_APP_TYPE
				StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
				DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT),
					DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
				    
				StatementOfAccountConstant.SOA_RA_OPTION,// RA_OPTION
				StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
				StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
				StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
				StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
				"L",
				reportsCO.getCtsSoaCtrlVO().getINCLUDE_MSG_FOOTER(),
				StatementOfAccountConstant.returnCheckboxValue(reportsCO.getCtsSoaCtrlVO().getMSG_IN_REPORT_ON()),
				reportsCO.getRifMessageVO().getMSG_CODE()
				);
			
			reportsCO.setOpt(reportsCO.getOpt().concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
			return reportParams;
		    }
		    //hussein ELHAJJ- US#201981-JAIZ140062 - Printing Of Statement account with name at account level instead of CIF level
		    else if(StatementOfAccountConstant.SOA_CLIENT_REF.JAIZ.equals(reportReference))  //-- TO COPY TO 14.1
		    {
			reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
				reportsCO.getAmfVOFrom().getBRANCH_CODE(),// RA_BRANCH
				reportsCO.getAmfVOTo().getBRANCH_CODE(),// RA_BRANCH
				DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
				DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
				reportsCO.getBaseCurrencyCode(),// RA_BASE_CY

				reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FR_CY
				reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
				reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_GL
				reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
				reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FR_CIF
				reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
				reportsCO.getAmfVOFrom().getSL_NO(),// RA_FR_SL
				reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL

				reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT
										  // value
										  // date
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
				reportsCO.getLoginUserId(),// RA_USERID
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS(),// RA_INCLUDE_REVERSE
				reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
				"0", // RS_SHOW_REF
				reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO(),// RS_SHOW_LOGO
				StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
				StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
				DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT),
					DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
				StatementOfAccountConstant.SOA_RA_OPTION,// AS_OPTION
				StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
				StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
				StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
				StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
				"EN",
				reportsCO.getCtsSoaCtrlVO().getINCLUDE_MSG_FOOTER(),
				StatementOfAccountConstant.returnCheckboxValue(reportsCO.getCtsSoaCtrlVO().getMSG_IN_REPORT_ON()),
				reportsCO.getRifMessageVO().getMSG_CODE()
				);
				
			
			reportsCO.setOpt(reportsCO.getOpt().concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
			return reportParams;
		    }
		    
		    
		 // Youssef ZAKI - UCB120006 - Statement of account changes - 25/11/2019
		    else if(StatementOfAccountConstant.SOA_CLIENT_REF.UCB.equals(reportReference))  //-- TO COPY TO 14.1
		    {
			reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP
				reportsCO.getAmfVOFrom().getBRANCH_CODE(),// RA_BRANCH
				reportsCO.getAmfVOTo().getBRANCH_CODE(),// RA_BRANCH
				DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
				DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
				reportsCO.getBaseCurrencyCode(),// RA_BASE_CY
				reportsCO.getAmfVOFrom().getCURRENCY_CODE(),// RA_FR_CY
				reportsCO.getAmfVOTo().getCURRENCY_CODE(),// RA_TO_CY
				reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_GL
				reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_GL
				reportsCO.getAmfVOFrom().getCIF_SUB_NO(),// RA_FR_CIF
				reportsCO.getAmfVOTo().getCIF_SUB_NO(),// RA_TO_CIF
				reportsCO.getAmfVOFrom().getSL_NO(),// RA_FR_SL
				reportsCO.getAmfVOTo().getSL_NO(),// RA_TO_SL
				reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),// RA_VT
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),// RA_INCLUDE_REVAL
				reportsCO.getLoginUserId(),// RA_USERID
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS(),// RA_INCLUDE_REVERSE
				reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),// RA_INCLUDE_TELLER
				"0", // RS_SHOW_REF
				reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO(),// RS_SHOW_LOGO
				reportsCO.getRifMessageVO().getMSG_CODE(),
				reportsCO.getCtsSoaCtrlVO().getINC_STATNO_PRIOR_ON().toString().equals("true") ?"1":"0" ,//				RS_NB_OF_STMT
				StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
				StatementOfAccountConstant.returnCheckboxValue(reportsCO.getCtsSoaCtrlVO().getMSG_IN_REPORT_ON()), // RS_APP_TYPE MAKE SURE OF IT
				StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
                                DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT), DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
				StatementOfAccountConstant.SOA_RA_OPTION,// AS_OPTION RS_CLOSING_DATE_EXISTS
				StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
				StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
				StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
				StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
				"EN",
				reportsCO.getCtsSoaCtrlVO().getINCLUDE_MSG_FOOTER()
	
				);
				
			
			reportsCO.setOpt(reportsCO.getOpt().concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
			return reportParams;
		    }
		    //Rania - AIB120029 - AIB120058 - Statement of account - 27/02/2020
		    else if(StatementOfAccountConstant.SOA_CLIENT_REF.AIB.equals(reportReference))
		    {
			
			reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getCOMP_CODE(), //Company Code
				reportsCO.getAmfVOFrom().getBRANCH_CODE(), //From Branch Code
				reportsCO.getAmfVOTo().getBRANCH_CODE(), //To Branch Code
				DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),//From Date
				DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),//To Date
				reportsCO.getBaseCurrencyCode(),//Base Burrency
				reportsCO.getAmfVOFrom().getCURRENCY_CODE(),//From Currency
				reportsCO.getAmfVOTo().getCURRENCY_CODE(),//To Currency
				reportsCO.getAmfVOFrom().getGL_CODE(),//From GL
				reportsCO.getAmfVOTo().getGL_CODE(),//To GL
				reportsCO.getAmfVOFrom().getCIF_SUB_NO(),//From CIF
				reportsCO.getAmfVOTo().getCIF_SUB_NO(),//To CIF
				reportsCO.getAmfVOFrom().getSL_NO(),//From SL
				reportsCO.getAmfVOTo().getSL_NO(),//To SL
				reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE(),//ra_vt
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVAL_TRANS(),//ra_include_reval
				reportsCO.getLoginUserId(),//ra_userid
				reportsCO.getCtsSoaCtrlVO().getONLINE_REVERSE_TRANS(),//ra_include_reverse
				reportsCO.getCtsControlVO().getTELLER_ACC_POSITION(),//ra_include_teller
				"0",//rs_show_ref
				reportsCO.getCtsSoaCtrlVO().getONLINE_PRINT_LOGO(),//rs_show_logo
				0,//msg code 1
				gregoHijriFlag,
				0, //msg code 2
				0, //msg code 3
				0, //msg code 4
				1, //nb pages
				reportsCO.getCtsSoaCtrlVO().getINCLUDE_MSG_FOOTER(),
				StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
				StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
				DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT), DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
				StatementOfAccountConstant.SOA_RA_OPTION,// AS_OPTION
				StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
				StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
				StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
				StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
				"EN",
				reportsCO.getCtsSoaCtrlVO().getFOOTER_MESSAGE_ENG1(),
				StatementOfAccountConstant.returnCheckboxValue(reportsCO.getCtsSoaCtrlVO().getMSG_IN_REPORT_ON()),
				reportsCO.getRifMessageVO().getMSG_CODE()
			);

			reportsCO.setOpt(reportsCO.getOpt().concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
			return reportParams;
		    }
		    
		    	    
		}
		else
		{
		    // if no reference is parameterized in admin
		    throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
		}
	    }
	}
	return reportParams;
    }
    
    
    
    /**
     * @description here i check for conditions that throw an exception before
     *              check business conditions Check if the data entered is valid
     *              or not, before opening the report
     */
    private void checkDataValidity(ReportsCO reportsCO) throws BaseException
    {
	
	BigDecimal compCode = reportsCO.getCompaniesVO().getCOMP_CODE();
	if(NumberUtil.isEmptyDecimal(compCode))
	{
	    throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
	}

	// VALIDATE BRANCHES
	BigDecimal branchCode = reportsCO.getBranchesVO().getBRANCH_CODE();
	if(NumberUtil.isEmptyDecimal(branchCode))
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_BRANCH_CODE);
	}
	String loginPreferrredLanguage = reportsCO.getLoginPreferrredLanguage();
	BranchesSC branchesSC = new BranchesSC();
	branchesSC.setPreferredLanguage(loginPreferrredLanguage);
	branchesSC.setCompCode(compCode);
	branchesSC.setBranchCode(branchCode);
	BRANCHESVO branchesVO = branchesBO.getBranchDescByCodeAndPrefLang(branchesSC);

	if(branchesVO == null)
	{
	    throw new BOException(MessageCodes.BRANCH_NOT_EXIST_FOR_COMPANY, new String[] { compCode.toString() });
	}

	

	Date from_date = reportsCO.getFrom_date();
	if(from_date == null)
	{
	    throw new BOException(MessageCodes.INVALID_DATE);
	}
	Date to_date = reportsCO.getTo_date();
	if(to_date == null)
	{
	    throw new BOException(MessageCodes.INVALID_DATE);
	}

	if(from_date.compareTo(to_date) > 0)
	{
	    throw new BOException(MessageCodes.INVALID_DATE_RANGE);
	}

	String byDate = reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE();
	Date runningDate = reportsCO.getRunningDate();
	/*if(StatementOfAccountConstant.REPORT_BY_TRADE_DATE.equals(byDate)
		&& (to_date.compareTo(runningDate) > 0))
	{
		throw new BOException(MessageCodes.DATE_CANNOT_BE_GREATER_THAN_RUNNING);
	}
*/
	boolean checkRangeValidityByAccount = true;
	if(  StatementOfAccountConstant.RANGE_CRITERIA_BY_ACCOUNT != reportsCO.getRangeByCriteria())
	{
	    checkRangeValidityByAccount = false;
	}
	
	if(checkRangeValidityByAccount)
	{
	    int cpt = reportsDAO.accountRangeValidity(reportsCO);
	    if(cpt == 0)
	    {
		throw new BOException(MessageCodes.NO_RECORDS_FOR_THIS_RANGE);
	    }
	}
	else
	{
	    reportsCO.getCompaniesVO().setCOMP_CODE(reportsCO.getLoginCompCode());
	    BigDecimal count = reportsDAO.checkAccountRestriction(reportsCO);
	    if(count.compareTo(BigDecimal.ZERO) == 0)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }
	}
    }
    
    
    /**
     * PB : f_get_opened_date_comp_branch
     */
//    private Date call_openedDateBranch(ReportsCO reportsCO) throws BaseException
//    {
//	YRTSC yrtSC = new YRTSC();
//	Date fromDate = reportsCO.getFrom_date();
//
//	int ll_year = DateUtil.getDayYearMonth(fromDate, DateUtil.YEAR);
//	int ll_month = DateUtil.getDayYearMonth(fromDate, DateUtil.MONTH);
//
//	reportsCO.setYear(BigDecimal.valueOf(ll_year));
//	reportsCO.setMonth(BigDecimal.valueOf(ll_month));
//
//	String yrMonth = NumberUtil.addLeadingZeros(ll_year, 4).concat(NumberUtil.addLeadingZeros(ll_month, 2));
//
//	yrtSC.setCompCode(reportsCO.getCompaniesVO().getCOMP_CODE());
//	yrtSC.setBranchCode(reportsCO.getBranchesVO().getBRANCH_CODE());
//	yrtSC.setYrMonth(yrMonth);
//
//	String ldt_opened = reportsDAO.getOpenedDateBranch(yrtSC);
//	if(ldt_opened != null)
//	{
//	    String subYear1 = ldt_opened.substring(0, 4);
//	    String submonth1 = ldt_opened.substring(4, 6);
//
//	    Integer subYear = Integer.parseInt(subYear1);
//	    Integer submonth = Integer.valueOf(submonth1);
//
//	    if(subYear == 12)
//	    {
//		subYear++;
//		submonth = 1;
//	    }
//	    else
//	    {
//		submonth++;
//	    }
//	    Calendar cal = Calendar.getInstance();
//	    cal.set(subYear, submonth - 1, 1);
//	    return cal.getTime();
//	}
//	else
//	{
//	    return null;
//	}
//    }
    
    
    /**
     * Pb :f_convert_date_grego_hijiri
     * @param dateToConv
     * @param type
     * @param companyCode
     */
    private Date call_returnConvertDateGregoHijri(Date dateToConv, String type, BigDecimal companyCode) throws BaseException{
        
	TrsHijriDetailCalendarSC hijriDetailCalendarSC = new TrsHijriDetailCalendarSC();
	hijriDetailCalendarSC.setCompCode(companyCode);
	hijriDetailCalendarSC.setAsInto(type);
	hijriDetailCalendarSC.setTheDate(dateToConv);
	String resDate = commonLibBO.returnConvertDateGregoHijri(hijriDetailCalendarSC);
	return DateUtil.parseDate(resDate, DateUtil.DEFAULT_DATE_FORMAT);
    }
    
    
    
    @Override
    public ReportsCO checkStmtPeriodicity(ReportsCO reportsCO) throws BaseException
    {
	String stmtPeriodicity = reportsCO.getStmtPeriodicity();
	BigDecimal companyCode = reportsCO.getLoginCompCode();
	Date runningDate = reportsCO.getRunningDate();
	String hasGregoHijri = reportsCO.getGregoHijri();
	String language = reportsCO.getLanguage();

	
	    
	SelectSC selSC;
	List<SelectCO> lst;
	String[] elemToShow = { }, elemToHide = new String[] {};

	if(StatementOfAccountConstant.STMT_PERIODICITY_OTHER.equals(stmtPeriodicity))
	{
	    if(StatementOfAccountConstant.HIJRI_DATE_FROMAT.equals(hasGregoHijri))
	    {
		runningDate = call_returnConvertDateGregoHijri(runningDate,
			StatementOfAccountConstant.HIJRI_DATE_FROMAT, companyCode);
	    }

	    elemToShow = new String[] { SOA_SPSD_ELEMENTS.from_date.getId(), SOA_SPSD_ELEMENTS.to_date.getId() };
	    elemToHide = new String[] { SOA_SPSD_ELEMENTS.year.getId(), SOA_SPSD_ELEMENTS.month.getId() };
	    
	    commonLibBO.applyDynScreenDisplay(elemToShow, ConstantsCommon.ACTION_TYPE_VALUE, runningDate, reportsCO.getHm(), null);
	}
	else if(StatementOfAccountConstant.STMT_PERIODICITY_WEEK.equals(stmtPeriodicity))
	{
	    Date fromDate = getDaysBefore(runningDate, 6);
	    Date toDate = runningDate;

	    if(StatementOfAccountConstant.HIJRI_DATE_FROMAT.equals(hasGregoHijri))
	    {
		fromDate = call_returnConvertDateGregoHijri(fromDate, StatementOfAccountConstant.HIJRI_DATE_FROMAT,
			companyCode);
		toDate = call_returnConvertDateGregoHijri(toDate, StatementOfAccountConstant.HIJRI_DATE_FROMAT,
			companyCode);
	    }
	    
	    elemToShow = new String[] { SOA_SPSD_ELEMENTS.from_date.getId(), SOA_SPSD_ELEMENTS.to_date.getId() };
	    elemToHide = new String[] { SOA_SPSD_ELEMENTS.year.getId(), SOA_SPSD_ELEMENTS.month.getId() };

	    commonLibBO.applyDynScreenDisplay(SOA_SPSD_ELEMENTS.from_date.getId(), SOA_SPSD_ELEMENTS.from_date.getName(), ConstantsCommon.ACTION_TYPE_VALUE, fromDate, reportsCO.getHm(), null);
	    commonLibBO.applyDynScreenDisplay(SOA_SPSD_ELEMENTS.to_date.getId(), SOA_SPSD_ELEMENTS.to_date.getName(), ConstantsCommon.ACTION_TYPE_VALUE, toDate, reportsCO.getHm(), null);
	}
	else if(StatementOfAccountConstant.STMT_PERIODICITY_MONTH.equals(stmtPeriodicity))
	{
	    selSC = new SelectSC(StatementOfAccountConstant.MONTHS_OF_YEAR_G_LOVTYPE);
	    selSC.setLanguage(language);

	    Date toDate = runningDate;
	    if(StatementOfAccountConstant.HIJRI_DATE_FROMAT.equals(hasGregoHijri))
	    {
		toDate = call_returnConvertDateGregoHijri(runningDate, StatementOfAccountConstant.HIJRI_DATE_FROMAT,
			companyCode);
	    }
	    Integer month = DateUtil.getDayYearMonth(toDate, DateUtil.MONTH);

	    if(StatementOfAccountConstant.HIJRI_DATE_FROMAT.equals(hasGregoHijri))
	    {
		selSC = new SelectSC(StatementOfAccountConstant.MONTHS_OF_YEAR_H_LOVTYPE);
	    }
	    lst = commonLibBO.returnLOV(selSC);
	    applySortingLst(lst);
	    
	    elemToShow = new String[] { SOA_SPSD_ELEMENTS.month.getId()};
	    elemToHide = new String[] { SOA_SPSD_ELEMENTS.from_date.getId(), SOA_SPSD_ELEMENTS.to_date.getId(),
		    SOA_SPSD_ELEMENTS.year.getId() };

	    addBusinessToElement(reportsCO.getHm(), SOA_SPSD_ELEMENTS.month.getId(), null, lst);
	    reportsCO.getCtsSoaCtrlVO().setONLINE_DATE_TYPE(month.toString());
	    
	}
	else if(StatementOfAccountConstant.STMT_PERIODICITY_QUARTERLY.equals(stmtPeriodicity))
	{
	    selSC = new SelectSC(StatementOfAccountConstant.STMT_PERIODICITY_QUART_G_LOVTYPE);
	    selSC.setLanguage(language);
	    if(StatementOfAccountConstant.HIJRI_DATE_FROMAT.equals(hasGregoHijri))
	    {
		selSC = new SelectSC(StatementOfAccountConstant.STMT_PERIODICITY_QUART_H_LOVTYPE);
	    }
	    lst = commonLibBO.returnLOV(selSC);
	    
	    elemToShow = new String[] { SOA_SPSD_ELEMENTS.month.getId() };
	    elemToHide = new String[] { SOA_SPSD_ELEMENTS.from_date.getId(), SOA_SPSD_ELEMENTS.to_date.getId(),
		    SOA_SPSD_ELEMENTS.year.getId() };

	    addBusinessToElement(reportsCO.getHm(), SOA_SPSD_ELEMENTS.month.getId(), null, lst);
	}
	else if(StatementOfAccountConstant.STMT_PERIODICITY_SEMIANNUAL.equals(stmtPeriodicity))
	{
	    selSC = new SelectSC(StatementOfAccountConstant.SEMI_ANNUAL_G_LOVTYPE);
	    selSC.setLanguage(language);
	    if(StatementOfAccountConstant.HIJRI_DATE_FROMAT.equals(hasGregoHijri))
	    {
		selSC = new SelectSC(StatementOfAccountConstant.SEMI_ANNUAL_H_LOVTYPE);
	    }
	    lst = commonLibBO.returnLOV(selSC);
	    
	    elemToShow = new String[] { SOA_SPSD_ELEMENTS.month.getId()};
	    elemToHide = new String[] {  SOA_SPSD_ELEMENTS.from_date.getId(),SOA_SPSD_ELEMENTS.to_date.getId(), SOA_SPSD_ELEMENTS.year.getId() };

	    addBusinessToElement(reportsCO.getHm(), SOA_SPSD_ELEMENTS.month.getId(), null, lst);
	}
	else if(StatementOfAccountConstant.STMT_PERIODICITY_YEARLY.equals(stmtPeriodicity))
	{
	    Date toDate = runningDate;
	    if(StatementOfAccountConstant.HIJRI_DATE_FROMAT.equals(hasGregoHijri))
	    {
		toDate = call_returnConvertDateGregoHijri(runningDate, StatementOfAccountConstant.HIJRI_DATE_FROMAT,
			companyCode);
	    }
	    int year = DateUtil.getDayYearMonth(toDate, DateUtil.YEAR);
	    
	    
	    
	    elemToShow = new String[] { SOA_SPSD_ELEMENTS.year.getId()};
	    elemToHide = new String[] {  SOA_SPSD_ELEMENTS.from_date.getId(),SOA_SPSD_ELEMENTS.to_date.getId(), SOA_SPSD_ELEMENTS.month.getId() };

	    reportsCO.setYear(BigDecimal.valueOf(year));
	}
	else
	{
	    elemToHide = new String[] { SOA_SPSD_ELEMENTS.from_date.getName(), SOA_SPSD_ELEMENTS.to_date.getName(),
		    SOA_SPSD_ELEMENTS.month.getId(), SOA_SPSD_ELEMENTS.year.getId() };
	}

	applyDynScreenDisplay(elemToShow, ConstantsCommon.ACTION_TYPE_VISIBLE, "1", reportsCO.getHm(), null);
	applyDynScreenDisplay(elemToHide, ConstantsCommon.ACTION_TYPE_VISIBLE, "0", reportsCO.getHm(), null);
	return reportsCO;
    }
    
    /**
     * Apply sort to month numbers
     */
    private void applySortingLst(List<SelectCO> lst)
    {
	Collections.sort(lst, new Comparator<SelectCO>()
	{
	    public int compare(SelectCO o1, SelectCO o2)
	    {
		Integer code1 = Integer.parseInt(o1.getCode());
		Integer code2 = Integer.parseInt(o2.getCode());
		return code1.compareTo(code2);
	    }
	});
    }
    
    
    /**
     * get the date before number of days passed
     * @param runningDate
     * @param nbrOfDays
     * @return Date
     */
    private Date getDaysBefore(Date runningDate, int nbrOfDays)
    {
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(runningDate);
	calendar.add(Calendar.DAY_OF_YEAR, -nbrOfDays);
	return calendar.getTime();
    }
    
    /**
     * @author EliasAoun
     * @Desc this function is used whenever we have to fill a combo with a list
     *       (because thius feature is not yet implemented)
     */
    private void addBusinessToElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm, String elementId,
	    String elementName, List<SelectCO> lst) throws BaseException
    {
	SYS_PARAM_SCREEN_DISPLAYVO tmpVO = hm.get(elementId);
	if(tmpVO == null)
	{
	    tmpVO = hm.get(elementName);
	    if(tmpVO == null)
	    {
		tmpVO = new SYS_PARAM_SCREEN_DISPLAYVO();
		tmpVO.setValue(lst);
		tmpVO.setELEMENT_ID(elementId);
		hm.put(elementId, tmpVO);
	    }
	}
	tmpVO.setValue(lst);
    }
    

    @Override
    public ReportsCO getProcessStmtInitData(ReportsCO thereportsCO) throws BaseException
    {
	
	ReportsCO reportsCO = thereportsCO ;
	
	Date runningDate = reportsCO.getRunningDate();
	reportsCO = reportsDAO.getProcessStmtInitData(reportsCO);
	
	reportsCO.setStmtPeriodicity( StatementOfAccountConstant.STMT_PERIODICITY_WEEK);
	reportsCO.setGregoHijri( StatementOfAccountConstant.GREGORIAN_DATE_FROMAT);

	Date fromDate = getDaysBefore(runningDate, 6);
	Date toDate = runningDate;
	reportsCO.setFrom_date(fromDate);
	reportsCO.setTo_date(toDate);
	
	thereportsCO.setStmtPeriodicity(reportsCO.getStmtPeriodicity());
	applySecurity(thereportsCO);
	reportsCO.setHm(thereportsCO.getHm());

	reportsCO.setShowDateFormat(true);
	return reportsCO;
    }
    

    @Override
    public ReportsCO checkBeforeGenerate_processingStmt(ReportsCO reportsCO) throws BaseException
    { 
	BigDecimal cifCodeRangeFrom = reportsCO.getAmfVOFrom().getCIF_SUB_NO();
	BigDecimal cifCodeRangeTo = reportsCO.getAmfVOTo().getCIF_SUB_NO();
	//String hasGregoHijri = reportsCO.getGregoHijri();
	
	if(!NumberUtil.isEmptyDecimal(cifCodeRangeFrom) && !NumberUtil.isEmptyDecimal(cifCodeRangeTo)
		&& (cifCodeRangeFrom.compareTo(cifCodeRangeTo) == 1))
	{
		throw new BOException(MessageCodes.INVALID_CIF_RANGE);
	}
	
	BigDecimal glCodeRangeFrom = reportsCO.getAmfVOFrom().getGL_CODE();
	BigDecimal glCodeRangeTo = reportsCO.getAmfVOTo().getGL_CODE();
	
	if(!NumberUtil.isEmptyDecimal(glCodeRangeFrom) && !NumberUtil.isEmptyDecimal(glCodeRangeTo)
		&& glCodeRangeFrom.compareTo(glCodeRangeTo) == 1)
	{
		throw new BOException(MessageCodes.INVALID_GL_CODE_RANGE);
	}
	
	Date from_date = reportsCO.getFrom_date();
	Date to_date = reportsCO.getTo_date();
	Date runningDate = reportsCO.getRunningDate();
	
	if(from_date != null && to_date != null)
	{
	    if(from_date.compareTo(to_date) == 1)
	    {
		throw new BOException(MessageCodes.INVALID_DATERANGE);
	    }

	    if(from_date.compareTo(runningDate) == 1 || from_date.compareTo(runningDate) == 1)
	    {
		throw new BOException(MessageCodes.DATE_RANGE_NOT_GREATER_RUNNING_DATE);
	    }

	    String stmtPeriodicity = reportsCO.getStmtPeriodicity();
	    if(StatementOfAccountConstant.STMT_PERIODICITY_WEEK.equals(stmtPeriodicity))
	    {
		long nbOfDays = DateUtil.numberOfDays(from_date, to_date);
		if(nbOfDays > Calendar.DAY_OF_WEEK)
		{
		    throw new BOException(MessageCodes.DATE_RANGE_EXCEEDS_SEVEN_DAYS);
		}
	    }
	}
	
	
	String cifCodeRange = reportsCO.getCifCodeRange();
	//if we selected all cif range
	if("1".equals(cifCodeRange)){
	    cifCodeRangeFrom = BigDecimal.ONE;
	    cifCodeRangeTo = reportsDAO.getMaxCifNo(reportsCO);
	}
	
	
	String glCodeRange = reportsCO.getGlCodeRange();
	//if we selected all gl range
	if("1".equals(glCodeRange)){
	    glCodeRangeFrom = BigDecimal.ONE;
	    glCodeRangeTo = reportsDAO.getMaxGlCode(reportsCO);
	}
	
	String excludeDeletedAccounts = "true".equals(reportsCO.getExcludeDeletedAccounts()) ? "1" : "0";
	reportsCO.setExcludeDeletedAccounts(excludeDeletedAccounts);

	String excludeSuspendedAccounts = "true".equals(reportsCO.getExcludeSuspendedAccounts()) ? "1" : "0";
	reportsCO.setExcludeSuspendedAccounts(excludeSuspendedAccounts);

	
	String stmtPeriodicity = reportsCO.getStmtPeriodicity();
	if(StatementOfAccountConstant.STMT_PERIODICITY_WEEK.equals(stmtPeriodicity)
		|| StatementOfAccountConstant.STMT_PERIODICITY_OTHER.equals(stmtPeriodicity))
	{
	    reportsCO.setFrom_date(commonLibBO.addSystemTimeToDate(reportsCO.getFrom_date()));
	    reportsCO.setTo_date(commonLibBO.addSystemTimeToDate(reportsCO.getTo_date()));
	}
	
	if(StatementOfAccountConstant.STMT_PERIODICITY_MONTH.equals(stmtPeriodicity))
	{
	    Integer selectedMonth = NumberUtil.toInteger(reportsCO.getMonth());
	    // TODO need to configure hijri date
	    // PB : w_select_reports_client_statement / cb_ok / clicked
//	    if(StatementOfAccountConstant.HIJRI_DATE_FROMAT.equals(hasGregoHijri))
//	    {
//		// Date runningDateHijri =
//		// call_returnConvertDateGregoHijri(runningDate,
//		// StatementOfAccountConstant.HIJRI_DATE_FROMAT, companyCode);
//	    }
//	    else
//	    {
		// Gregorian
		Calendar monthlyCal = Calendar.getInstance();
		monthlyCal.setTime(runningDate);
		int runningMonth = monthlyCal.get(Calendar.MONTH);
		monthlyCal.set(Calendar.MONTH, selectedMonth);

		from_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		to_date = DateUtil.getMonthLastDay(monthlyCal.getTime());

		if(to_date.compareTo(runningDate) == 1 && selectedMonth == runningMonth)
		{
		    to_date = runningDate;
		}
//	    }
	}
	
	if(StatementOfAccountConstant.STMT_PERIODICITY_QUARTERLY.equals(stmtPeriodicity))
	{
	 // TODO need to configure hijri date
//	    Date localDate = call_returnConvertDateGregoHijri(runningDate,
//		    StatementOfAccountConstant.HIJRI_DATE_FROMAT, companyCode);
//	    int year = DateUtil.getDayYearMonth(localDate, DateUtil.YEAR);

	    Integer selectedQuarter = NumberUtil.toInteger(reportsCO.getMonth());

	    Calendar monthlyCal = Calendar.getInstance();
	    monthlyCal.setTime(runningDate);
	    switch (selectedQuarter)
	    {
		case 2:
		    monthlyCal.set(Calendar.MONTH, Calendar.APRIL);
		    from_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		    monthlyCal.set(Calendar.MONTH, Calendar.JUNE);
		    to_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		    break;
		case 3:
		    monthlyCal.set(Calendar.MONTH, Calendar.JULY);
		    from_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		    monthlyCal.set(Calendar.MONTH, Calendar.SEPTEMBER);
		    to_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		    break;
		case 4:
		    monthlyCal.set(Calendar.MONTH, Calendar.OCTOBER);
		    from_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		    monthlyCal.set(Calendar.MONTH, Calendar.DECEMBER);
		    to_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		    break;
		default:// 1
		    monthlyCal.set(Calendar.MONTH, Calendar.JANUARY);
		    from_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		    monthlyCal.set(Calendar.MONTH, Calendar.MARCH);
		    to_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		    break;
	    }
	}
	
	if(StatementOfAccountConstant.STMT_PERIODICITY_SEMIANNUAL.equals(stmtPeriodicity))
	{
	    Integer selectedSemiAnnual = NumberUtil.toInteger(reportsCO.getMonth());

	    Calendar monthlyCal = Calendar.getInstance();
	    monthlyCal.setTime(runningDate);

		if(selectedSemiAnnual == 2)
		{
		    monthlyCal.set(Calendar.MONTH, Calendar.JULY);
		    from_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		    monthlyCal.set(Calendar.MONTH, Calendar.DECEMBER);
		    to_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		}
		else
		{
		    monthlyCal.set(Calendar.MONTH, Calendar.JANUARY);
		    from_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		    monthlyCal.set(Calendar.MONTH, Calendar.JUNE);
		    to_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
		}
	}
	
	if(StatementOfAccountConstant.STMT_PERIODICITY_YEARLY.equals(stmtPeriodicity))
	{
	    Calendar monthlyCal = Calendar.getInstance();
	    monthlyCal.setTime(runningDate);
	    monthlyCal.set(Calendar.MONTH, Calendar.JANUARY);
	    from_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
	    monthlyCal.set(Calendar.MONTH, Calendar.DECEMBER);
	    to_date = DateUtil.getMonthFirstDay(monthlyCal.getTime());
	}

	reportsCO.getAmfVOFrom().setGL_CODE(glCodeRangeFrom);
	reportsCO.getAmfVOTo().setGL_CODE(glCodeRangeTo);
	reportsCO.getAmfVOFrom().setCIF_SUB_NO(cifCodeRangeFrom);
	reportsCO.getAmfVOTo().setCIF_SUB_NO(cifCodeRangeTo);
	reportsCO.setFrom_date(from_date);
	reportsCO.setTo_date(to_date);

	checkProcessingStmtData( reportsCO);
	
	String reportParams = fillReportParams(reportsCO);
	reportsCO.setReportParams(reportParams);
	
	return reportsCO;
    }

    /**
     * 
     * @param reportsCO
     * @throws BaseException
     */
    private void checkProcessingStmtData(ReportsCO reportsCO) throws BaseException
    {
	String _type = reportsCO.get_type();
	if(StatementOfAccountConstant.REPORT_BY_TRADE_DATE.equals(_type) || StatementOfAccountConstant.REPORT_BY_VALUE_DATE.equals(_type))
	{
	    reportsCO.setBs_contra("Z");
	}

	AccRestrictedSC accRestrictedSC = new AccRestrictedSC();
	accRestrictedSC.setCompCode(reportsCO.getCompaniesVO().getCOMP_CODE());
	accRestrictedSC.setBranchCode(reportsCO.getLoginBraCode());
	accRestrictedSC.setFrAcBr(new BigDecimal(0));
	accRestrictedSC.setFrAcCif(new BigDecimal(0));
	accRestrictedSC.setFrAcCy(new BigDecimal(0));
	accRestrictedSC.setFrAcGl(new BigDecimal(0));
	accRestrictedSC.setFrAcSl(new BigDecimal(0));
	accRestrictedSC.setToAcBr(new BigDecimal(9999));
	accRestrictedSC.setToAcCy(new BigDecimal(999));
	accRestrictedSC.setToAcCif(new BigDecimal(99999999));
	accRestrictedSC.setToAcGl(new BigDecimal(999999));
	accRestrictedSC.setToAcSl(new BigDecimal(9999));
	accRestrictedSC.setUserId(reportsCO.getLoginUserId());
	accRestrictedSC.setAppName(reportsCO.getAppName());
	accRestrictedSC.setProgRef(reportsCO.getOpt());
	
	coreCommonProcedureBO.fillAccRestricted(accRestrictedSC);
	
	int count = reportsDAO.getProcessingStmtData(reportsCO);
	if(count == 0 && reportsCO.getPrintStmtIfNoTrx().equals("false"))
	{
	    throw new BOException(MessageCodes.NO_RECORDS_FOR_THIS_RANGE);
	}
    }

    
    /**
     * @author eliasaoun
     * @Modif : w_report_statement_boubyan (TP id:83155)
     */
    public ReportsCO checkFromIbanDependency(ReportsCO reportsCO) throws BaseException
    {
	ReportsSC criteria = new ReportsSC();
	criteria.setCompany_code(reportsCO.getCompaniesVO().getCOMP_CODE());
	criteria.setIbanCode(reportsCO.getAmfVOFrom().getIBAN_ACC_NO());
	AMFVO fromIbanAMFVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_IBAN);

	reportsCO.getBranchesVO().setBRANCH_CODE(fromIbanAMFVO.getBRANCH_CODE());
	reportsCO.getAmfVOFrom().setBRANCH_CODE(fromIbanAMFVO.getBRANCH_CODE());
	reportsCO.getAmfVOFrom().setCURRENCY_CODE(fromIbanAMFVO.getCURRENCY_CODE());
	reportsCO.getAmfVOFrom().setGL_CODE(fromIbanAMFVO.getGL_CODE());
	reportsCO.getAmfVOFrom().setCIF_SUB_NO(fromIbanAMFVO.getCIF_SUB_NO());
	reportsCO.getAmfVOFrom().setSL_NO(fromIbanAMFVO.getSL_NO());
	reportsCO.getAmfVOTo().setIBAN_ACC_NO(reportsCO.getAmfVOFrom().getIBAN_ACC_NO());
	return reportsCO;
    }
    
    /**
     * @author eliasaoun
     * @Modif : w_report_statement_boubyan (TP id:83155)
     */
    private AMFVO returnAMFbasedOnFieldId(ReportsSC criteria, Integer fieldId) throws BaseException
    {
	if(StatementOfAccountConstant.RANGE_CRITERIA_BY_REFERENCE == fieldId)
	{
	    if(!StringUtil.isNotEmpty(criteria.getReferenceCode()))
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_REFERENCE);
	    }
	}
	else if(StatementOfAccountConstant.RANGE_CRITERIA_BY_IBAN == fieldId)
	{
	    if(!StringUtil.isNotEmpty(criteria.getIbanCode()))
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_IBAN);
	    }
	}
	/* BUG#328202 the condition should be done on cardNo and not on IbanCode. */
	else if(StatementOfAccountConstant.RANGE_CRITERIA_BY_CARD_NO == fieldId
		&& !StringUtil.isNotEmpty(criteria.getCardNo()))
	{
	    throw new BOException(MessageCodes.PARAM1_IS_MISSING_INVALID, new String[] { "Card_No_key" });
	}

	criteria.setFieldId(fieldId.toString());
	List<AMFVO> lst = reportsDAO.returnAMFbasedOnFieldId(criteria);
	int msgCode = 0;
	// it may return more than one row, so in this case i supposed it is
	// invalid
	if(lst == null || lst.size() != 1)
	{
	    msgCode = MessageCodes.INVALID_MISSING_IBAN;
	    if(StatementOfAccountConstant.RANGE_CRITERIA_BY_REFERENCE == fieldId
		    || StatementOfAccountConstant.RANGE_CRITERIA_BY_CARD_NO == fieldId)
	    {
		msgCode = MessageCodes.INVALID_MISSING_REFERENCE;
	    }
	}
	
	//if we have catch an error
	if(msgCode > 0)
	{
	    throw new BOException(msgCode);
	}
	return lst.get(0);
    }

    /**
     * this method validate the iban code passed as String, and convert/extract the number from it
     * N.B.:the algorithm is not final,it may differ
     * @param ibanStr
     */
    private long validateIbanCode(String ibanStr)
    {
	String ibanNum = "0";
	String ibanRegex = "(\\d+)";
	Matcher matcher = Pattern.compile(ibanRegex).matcher(ibanStr);
	while(matcher.find())
	{
	    ibanNum = matcher.group();
	}
	Double ibanDouble = Double.parseDouble(ibanNum.toString());
	return Math.round(ibanDouble); 
    }
    
    
    /**
     * @author eliasaoun
     * @Modif : w_report_statement_boubyan (TP id:83155)
     */
    public ReportsCO checkToIbanDependency(ReportsCO reportsCO) throws BaseException
    {
	long fromIban = validateIbanCode(reportsCO.getAmfVOFrom().getIBAN_ACC_NO());
	long toIban = validateIbanCode(reportsCO.getAmfVOTo().getIBAN_ACC_NO());

	if(fromIban > toIban)
	{
	    throw new BOException(MessageCodes.INVALID_RANGE);
	}

	ReportsSC criteria = new ReportsSC();
	criteria.setCompany_code(reportsCO.getCompaniesVO().getCOMP_CODE());
	criteria.setIbanCode(reportsCO.getAmfVOTo().getIBAN_ACC_NO());
	AMFVO toIbanAMFVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_IBAN);
        
	reportsCO.getBranchesVO().setBRANCH_CODE(toIbanAMFVO.getBRANCH_CODE());
	reportsCO.getAmfVOTo().setBRANCH_CODE(toIbanAMFVO.getBRANCH_CODE());
	reportsCO.getAmfVOTo().setCURRENCY_CODE(toIbanAMFVO.getCURRENCY_CODE());
	reportsCO.getAmfVOTo().setGL_CODE(toIbanAMFVO.getGL_CODE());
	reportsCO.getAmfVOTo().setCIF_SUB_NO(toIbanAMFVO.getCIF_SUB_NO());
	reportsCO.getAmfVOTo().setSL_NO(toIbanAMFVO.getSL_NO());
        return reportsCO;
    }

    
    /**
     * @author eliasaoun
     * @Modif : w_report_statement_boubyan (TP id:83155)
     */
    public ReportsCO checkFromReferenceDependency(ReportsCO reportsCO) throws BaseException
    {
	ReportsSC criteria = new ReportsSC();
	criteria.setCompany_code(reportsCO.getCompaniesVO().getCOMP_CODE());
	criteria.setReferenceCode( reportsCO.getAmfVOFrom().getADDITIONAL_REFERENCE());
	AMFVO fromReferenceAMFVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_REFERENCE);
	
	reportsCO.getBranchesVO().setBRANCH_CODE(fromReferenceAMFVO.getBRANCH_CODE());
	reportsCO.getAmfVOFrom().setBRANCH_CODE(fromReferenceAMFVO.getBRANCH_CODE());
	reportsCO.getAmfVOFrom().setCURRENCY_CODE(fromReferenceAMFVO.getCURRENCY_CODE());
	reportsCO.getAmfVOFrom().setGL_CODE(fromReferenceAMFVO.getGL_CODE());
	reportsCO.getAmfVOFrom().setCIF_SUB_NO(fromReferenceAMFVO.getCIF_SUB_NO());
	reportsCO.getAmfVOFrom().setSL_NO(fromReferenceAMFVO.getSL_NO());
	String additionalReference = fromReferenceAMFVO.getADDITIONAL_REFERENCE();/// bug #617349
	if(!StringUtil.isNotEmpty(additionalReference))
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_REFERENCE);
	}
	reportsCO.getAmfVOFrom().setADDITIONAL_REFERENCE(additionalReference);
	reportsCO.getAmfVOTo().setADDITIONAL_REFERENCE(additionalReference);
	
	return reportsCO;
    }

    
    /**
     * @author eliasaoun
     * @Modif : w_report_statement_boubyan (TP id:83155)
     */
    public ReportsCO checkToReferenceDependency(ReportsCO reportsCO) throws BaseException
    {
	long fromReference = validateIbanCode(reportsCO.getAmfVOFrom().getADDITIONAL_REFERENCE());
	long toReference = validateIbanCode(reportsCO.getAmfVOFrom().getADDITIONAL_REFERENCE());

	if(fromReference > toReference)
	{
	    throw new BOException(MessageCodes.INVALID_RANGE);
	}

	ReportsSC criteria = new ReportsSC();
	criteria.setCompany_code(reportsCO.getCompaniesVO().getCOMP_CODE());
	criteria.setReferenceCode(reportsCO.getAmfVOFrom().getADDITIONAL_REFERENCE());
	AMFVO toReferenceAMFVO = returnAMFbasedOnFieldId(criteria, StatementOfAccountConstant.RANGE_CRITERIA_BY_REFERENCE);

	reportsCO.getBranchesVO().setBRANCH_CODE(toReferenceAMFVO.getBRANCH_CODE());
	reportsCO.getAmfVOTo().setBRANCH_CODE(toReferenceAMFVO.getBRANCH_CODE());
	reportsCO.getAmfVOTo().setCURRENCY_CODE(toReferenceAMFVO.getCURRENCY_CODE());
	reportsCO.getAmfVOTo().setGL_CODE(toReferenceAMFVO.getGL_CODE());
	reportsCO.getAmfVOTo().setCIF_SUB_NO(toReferenceAMFVO.getCIF_SUB_NO());
	reportsCO.getAmfVOTo().setSL_NO(toReferenceAMFVO.getSL_NO());
	return reportsCO;
    }

    
    /**
     * @author eliasaoun
     * @Modif : w_report_statement_boubyan (TP id:83155)
     */
    public ReportsCO checkFromCardNoDependency(ReportsCO reportsCO) throws BaseException
    {
	AccountSC criteria = new AccountSC();
	criteria.setCompCode(reportsCO.getCompaniesVO().getCOMP_CODE());
	criteria.setBranchCode(reportsCO.getAmfVOFrom().getBRANCH_CODE());
	criteria.setCurrencyCode(reportsCO.getAmfVOFrom().getCURRENCY_CODE());
	criteria.setGlCode(reportsCO.getAmfVOFrom().getGL_CODE());
	criteria.setCifCode(reportsCO.getAmfVOFrom().getCIF_SUB_NO());
	criteria.setSlNbr(reportsCO.getAmfVOFrom().getSL_NO());
	criteria.setLangCode(reportsCO.getLoginPreferrredLanguage());
	
	AccountCO amfCO = accountBO.returnAMFDetails(criteria);
	if(amfCO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_REFERENCE);
	}

	String additionalReference = amfCO.getAmfVO().getADDITIONAL_REFERENCE();
	if(!StringUtil.isNotEmpty(additionalReference))
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_REFERENCE);
	}
	reportsCO.getAmfVOFrom().setADDITIONAL_REFERENCE(additionalReference);
	reportsCO.getAmfVOTo().setADDITIONAL_REFERENCE(additionalReference);

	// refill branch fields
	reportsCO.getBranchesVO().setBRANCH_CODE(criteria.getBranchCode());
	checkBranchByCodeDependency(reportsCO);

	return reportsCO;
    }
    
    /**
     * @author EliasAoun
     * @param reportsCO.appName, reportsCO.language, reportsCO.opt
     */
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> call_returnAdditionalFieldsParam(ReportsCO reportsCO) throws BaseException
    {
	RequiredFieldsSC criteria = new RequiredFieldsSC();
	criteria.setAppName(reportsCO.getAppName());
	criteria.setLangCode(reportsCO.getLanguage());
	criteria.setProgRef(reportsCO.getOpt());	//pageRef
	criteria.setCompCode(BigDecimal.ZERO);		//explicitly
	return commonLibBO.returnMapRequiredData(criteria);
    }
    
    
    /**
     * @author EliasAoun
     * @param originalArr the array of String that we want to remove elements
     *            from
     * @param removeArr the elements that we want to remove/show
     */
//    private String[] removeElement(String[] theOriginalArr, String removeArr[])
//    {
//	String[] originalArr = theOriginalArr ;
//	
//	for(String column : removeArr)
//	{
//	    originalArr = ArrayUtils.removeElement(originalArr, column);
//	}
//	return originalArr;
//    }
    

    @Override
    /**
     * @Modif : w_report_statement_boubyan (TP id:83155)
     */
    public ReportsCO showHideRangeByCriteria(ReportsCO reportsCO) throws BaseException
    {
	manageRangeByCriteria(reportsCO,true);
	
	return reportsCO;
    }

    
    /**
     * @Modif : w_report_statement_boubyan (TP id:83155)
     * @param reportsCO
     * @param fromDependency = true if it is called from dependency, false if it
     *            is called on load to avoid reloading the dynamic display hm
     * @Description in this method i show/hide elements based on the selected criteria
     * @Note sometimes on load we should use account name
     */
    private void manageRangeByCriteria(ReportsCO reportsCO, boolean isFromDependency) throws BaseException
    {
	int rangeByCriteria = reportsCO.getRangeByCriteria();
	String[] elemToShow = null, elemToHide = null;
	
	switch (rangeByCriteria)
	{
	    case StatementOfAccountConstant.RANGE_CRITERIA_BY_IBAN:
		elemToHide = new String[] { SOA_SPSD_ELEMENTS.FROM_ADDITIONAL_REFERENCE.getId(),
			SOA_SPSD_ELEMENTS.TO_ADDITIONAL_REFERENCE.getId(), SOA_SPSD_ELEMENTS.FROM_ACCOUNT.getId(),
			SOA_SPSD_ELEMENTS.TO_ACCOUNT.getId(), SOA_SPSD_ELEMENTS.fromCardNo.getId() 
			 , "accBrFrom", "accCyFrom", "accGlFrom", "accCifFrom", "lookuptxt_accSlFrom"  , "accBrTo",
			   "accCyTo", "accGlTo", "accCifTo", "lookuptxt_accSlTo" };

		elemToShow = new String[] { SOA_SPSD_ELEMENTS.FROM_IBAN_ACC_NO.getId(),
			SOA_SPSD_ELEMENTS.TO_IBAN_ACC_NO.getId() };
		break;
	    case StatementOfAccountConstant.RANGE_CRITERIA_BY_ACCOUNT:
		elemToHide = new String[] { SOA_SPSD_ELEMENTS.FROM_ADDITIONAL_REFERENCE.getId(),
			SOA_SPSD_ELEMENTS.TO_ADDITIONAL_REFERENCE.getId(), SOA_SPSD_ELEMENTS.FROM_IBAN_ACC_NO.getId(),
			SOA_SPSD_ELEMENTS.TO_IBAN_ACC_NO.getId(), SOA_SPSD_ELEMENTS.fromCardNo.getId() };
		
		if(isFromDependency)
		{
		    elemToShow = new String[] { SOA_SPSD_ELEMENTS.FROM_ACCOUNT.getId(),
			    SOA_SPSD_ELEMENTS.TO_ACCOUNT.getId()  , "accBrFrom",
				   "accCyFrom", "accGlFrom", "accCifFrom", "lookuptxt_accSlFrom"  , "accBrTo",
				   "accCyTo", "accGlTo", "accCifTo", "lookuptxt_accSlTo" };
		}else{
		    elemToShow = new String[] { SOA_SPSD_ELEMENTS.FROM_ACCOUNT.getName(),
			    SOA_SPSD_ELEMENTS.TO_ACCOUNT.getName()  , "accBrFrom",
				   "accCyFrom", "accGlFrom", "accCifFrom", "lookuptxt_accSlFrom"  , "accBrTo",
				   "accCyTo", "accGlTo", "accCifTo", "lookuptxt_accSlTo" };
		}
		break;
	    case StatementOfAccountConstant.RANGE_CRITERIA_BY_CARD_NO:
		elemToHide = new String[] { SOA_SPSD_ELEMENTS.FROM_ADDITIONAL_REFERENCE.getId(),
			SOA_SPSD_ELEMENTS.TO_ADDITIONAL_REFERENCE.getId(), SOA_SPSD_ELEMENTS.FROM_IBAN_ACC_NO.getId(),
			SOA_SPSD_ELEMENTS.TO_IBAN_ACC_NO.getId(), SOA_SPSD_ELEMENTS.FROM_ACCOUNT.getId(),
			SOA_SPSD_ELEMENTS.TO_ACCOUNT.getId()  , "accBrFrom",
			   "accCyFrom", "accGlFrom", "accCifFrom", "lookuptxt_accSlFrom"  , "accBrTo",
			   "accCyTo", "accGlTo", "accCifTo", "lookuptxt_accSlTo"  };
		
		elemToShow = new String[] { SOA_SPSD_ELEMENTS.fromCardNo.getId() };
		break;
	    default:
		//Reference
		
		if(isFromDependency)
		{
		    elemToHide = new String[] { SOA_SPSD_ELEMENTS.FROM_IBAN_ACC_NO.getId(),
				SOA_SPSD_ELEMENTS.TO_IBAN_ACC_NO.getId(), SOA_SPSD_ELEMENTS.FROM_ACCOUNT.getId(),
				SOA_SPSD_ELEMENTS.TO_ACCOUNT.getId(), SOA_SPSD_ELEMENTS.fromCardNo.getId() , "accBrFrom",
				   "accCyFrom", "accGlFrom", "accCifFrom", "lookuptxt_accSlFrom"  , "accBrTo",
				   "accCyTo", "accGlTo", "accCifTo", "lookuptxt_accSlTo"  };
			
		    elemToShow = new String[] { SOA_SPSD_ELEMENTS.FROM_ADDITIONAL_REFERENCE.getId(),
				SOA_SPSD_ELEMENTS.TO_ADDITIONAL_REFERENCE.getId() };
		}else{
		    elemToHide = new String[] { SOA_SPSD_ELEMENTS.FROM_IBAN_ACC_NO.getName(),
				SOA_SPSD_ELEMENTS.TO_IBAN_ACC_NO.getName(), SOA_SPSD_ELEMENTS.FROM_ACCOUNT.getName(),
				SOA_SPSD_ELEMENTS.TO_ACCOUNT.getName(), SOA_SPSD_ELEMENTS.fromCardNo.getName() , "reportsCO.amfVOFrom.BRANCH_CODE",
				   "reportsCO.amfVOFrom.CURRENCY_CODE", "reportsCO.amfVOFrom.GL_CODE", "reportsCO.amfVOFrom.CIF_SUB_NO", "reportsCO.amfVOFrom.SL_NO"  , "reportsCO.amfVOTo.BRANCH_CODE",
				   "reportsCO.amfVOTo.CURRENCY_CODE", "reportsCO.amfVOTo.GL_CODE", "reportsCO.amfVOTo.CIF_SUB_NO", "reportsCO.amfVOTo.SL_NO"  };
			
		    elemToShow = new String[] { SOA_SPSD_ELEMENTS.FROM_ADDITIONAL_REFERENCE.getName(),
				SOA_SPSD_ELEMENTS.TO_ADDITIONAL_REFERENCE.getName() };
		}
		break;
	}

//	elemToHide = removeElement(elemToHide, elemToShow);
	
//	elemToShow = ArrayUtils.add(elemToShow, SOA_SPSD_ELEMENTS.STMT_WITHOUT_MVT_ON.getId());
	// show
	applyDynScreenDisplay(elemToShow, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE.toString(), reportsCO.getHm(), null);
	// // hide
	applyDynScreenDisplay(elemToHide, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO.toString(), reportsCO.getHm(), null);

    }
    
    
    /**
     * NABIL FEGHALI - IIAB110237 - SOA Charges
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int updateTMPReports(TMP_REPORTSVOWithBLOBs criteria) throws BaseException
    {
	return reportsDAO.updateTMPReports(criteria);
    }
    
    /**
     * NABIL FEGHALI - IIAB110237 - SOA Charges
     * @param criteria
     * @return
     * @throws BaseException
     */
    public Integer countTMPReports(TMP_REPORTSVOWithBLOBs criteria) throws BaseException
    {
	return reportsDAO.countTMPReports(criteria);
    }
    
    public TMP_REPORTSVOWithBLOBs returnTmpReports(TMP_REPORTSVOWithBLOBs criteria) throws BaseException
    {
	return reportsDAO.returnTmpReports(criteria);
    }
    
    public ReportsCO showHideRangeGregoHijri(ReportsCO reportsCO) throws BaseException
    {
	if(StatementOfAccountConstant.HIJRI_DATE_FROMAT.equals(reportsCO.getCtsSoaCtrlVO().getSHOW_HIJRI_DATE()))
	{
	    applyDynScreenDisplay(
		    new String[] { SOA_SPSD_ELEMENTS.from_date.getId(), SOA_SPSD_ELEMENTS.to_date.getId() },
		    ConstantsCommon.ACTION_TYPE_VISIBLE, "0", reportsCO.getHm(), null);
	    applyDynScreenDisplay(new String[] {
		    SOA_SPSD_ELEMENTS.from_date_hijri.getId().concat("_"+reportsCO.getOpt()).concat("_hijriDate"),
		    SOA_SPSD_ELEMENTS.to_date_hijri.getId().concat("_"+reportsCO.getOpt()).concat("_hijriDate") },
		    ConstantsCommon.ACTION_TYPE_VISIBLE, "1", reportsCO.getHm(), null);
	}
	else if(StatementOfAccountConstant.GREGORIAN_DATE_FROMAT.equals(reportsCO.getCtsSoaCtrlVO()
		.getSHOW_HIJRI_DATE()))
	{
	    applyDynScreenDisplay(new String[] {
		    SOA_SPSD_ELEMENTS.from_date_hijri.getId().concat("_"+reportsCO.getOpt()).concat("_hijriDate"),
		    SOA_SPSD_ELEMENTS.to_date_hijri.getId().concat("_"+reportsCO.getOpt()).concat("_hijriDate") },
		    ConstantsCommon.ACTION_TYPE_VISIBLE, "0", reportsCO.getHm(), null);
	    applyDynScreenDisplay(
		    new String[] { SOA_SPSD_ELEMENTS.from_date.getId(), SOA_SPSD_ELEMENTS.to_date.getId() },
		    ConstantsCommon.ACTION_TYPE_VISIBLE, "1", reportsCO.getHm(), null);
	}
	return reportsCO;
    }
    
    
    public ReportsCO fromDateDependency(ReportsCO reportsCO) throws BaseException
    {
	Date from_date = reportsCO.getFrom_date();
	Date to_date = reportsCO.getTo_date();

	if(to_date != null && from_date != null && from_date.compareTo(to_date) > 0)
	{
	    throw new BOException(MessageCodes.INVALID_DATE_RANGE);
	}

	String byDate = reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE();
	Date runningDate = reportsCO.getRunningDate();
	/*if(StatementOfAccountConstant.REPORT_BY_TRADE_DATE.equals(byDate) && (from_date.compareTo(runningDate) > 0))
	{
	    throw new BOException(MessageCodes.DATE_CANNOT_BE_GREATER_THAN_RUNNING);
	}
	*/
	//reportsCO.setTo_date(from_date);//JAIZ REQUEST BASED ON JAIZUP190149 
	return reportsCO;
    }
    
    public ReportsCO toDateDependency(ReportsCO reportsCO) throws BaseException
    {
	Date from_date = reportsCO.getFrom_date();
	Date to_date = reportsCO.getTo_date();
	
	if(to_date != null && from_date != null && from_date.compareTo(to_date) > 0)
	{
	    throw new BOException(MessageCodes.INVALID_DATE_RANGE);
	}
	
	String byDate = reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE();
	Date runningDate = reportsCO.getRunningDate();
	/*if(StatementOfAccountConstant.REPORT_BY_TRADE_DATE.equals(byDate) && (from_date.compareTo(runningDate) > 0))
	{
	    throw new BOException(MessageCodes.DATE_CANNOT_BE_GREATER_THAN_RUNNING);
	}*/
	return reportsCO;
    }
    
    
    
    /**
     * 08/09/2015
     */
    public ReportsCO msgIncludeInReportDependency(ReportsCO reportsCO) throws BaseException
    {
	String selectedCriteriaVal = reportsCO.getCtsSoaCtrlVO().getMSG_IN_REPORT_ON();
	if("true".equals(selectedCriteriaVal))
	{
	    RIFMESSAGEVO msgVO = call_getMessageByCompLkpList(reportsCO);
	    if(msgVO != null)
	    {
		reportsCO.getRifMessageVO().setMSG_CODE(msgVO.getMSG_CODE());
		if(ConstantsCommon.PREFERED_LANG_ARABIC.equals(reportsCO.getCtsSoaCtrlVO().getONLINE_LANGUAGE()))
		{
		    reportsCO.setRifMsgDesc(msgVO.getMSG_ARAB());
		}
		else
		{
		    reportsCO.setRifMsgDesc(msgVO.getMSG_ENG());
		}
	    }
	    applyDynScreenDisplay(
		    new String[] { SOA_SPSD_ELEMENTS.ONLINE_LANGUAGE.getId(), SOA_SPSD_ELEMENTS.MSG_CODE.getId() },
		    ConstantsCommon.ACTION_TYPE_READONLY, "0", reportsCO.getHm(), null);
	}
	else
	{
	    reportsCO.getRifMessageVO().setMSG_CODE(null);
	    reportsCO.setRifMsgDesc(null);
	    //bug #683327  Disabled language's radio button -BB SOA
/*	    applyDynScreenDisplay(new String[] { SOA_SPSD_ELEMENTS.ONLINE_LANGUAGE.getId(),
		    SOA_SPSD_ELEMENTS.MSG_CODE.getId() }, ConstantsCommon.ACTION_TYPE_READONLY, "1", reportsCO.getHm(),
		    null);*/
	    
	  applyDynScreenDisplay( SOA_SPSD_ELEMENTS.MSG_CODE.getId(),SOA_SPSD_ELEMENTS.MSG_CODE.getName() , ConstantsCommon.ACTION_TYPE_READONLY, "1", reportsCO.getHm(),
		    null);
	}
	return reportsCO;
    }
    
    /**
     * 08/09/2015
     */
    public ReportsCO chooseLanguageDependency(ReportsCO reportsCO) throws BaseException
    {
	String selectedCriteriaVal = reportsCO.getCtsSoaCtrlVO().getONLINE_LANGUAGE();
	RIFMESSAGEVO msgVO = call_getMessageByCompLkpList(reportsCO);
	if(msgVO != null)
	{
	    reportsCO.getRifMessageVO().setMSG_CODE(msgVO.getMSG_CODE());
	    if(ConstantsCommon.PREFERED_LANG_ARABIC.equals(selectedCriteriaVal))
	    {
		reportsCO.setRifMsgDesc(msgVO.getMSG_ARAB());
	    }
	    else
	    {
		reportsCO.setRifMsgDesc(msgVO.getMSG_ENG());
	    }
	}
	return reportsCO;
    }
    
    @Override
    public ReportsCO rifMessageCodeDependency(ReportsCO reportsCO) throws BaseException
    {
	if(!NumberUtil.isEmptyDecimal(reportsCO.getRifMessageVO().getMSG_CODE()))
	{
	    RIFMESSAGEVO msgVO = new RIFMESSAGEVO();
	    msgVO.setCOMP_CODE(reportsCO.getLoginCompCode());
	    msgVO.setMSG_CODE(reportsCO.getRifMessageVO().getMSG_CODE());
	    msgVO = (RIFMESSAGEVO) genericDAO.selectByPK(msgVO);
	    if(msgVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CODE);
	    }
	    else
	    {
		reportsCO.getRifMessageVO().setMSG_CODE(msgVO.getMSG_CODE());
		if(ConstantsCommon.PREFERED_LANG_ARABIC.equals(reportsCO.getCtsSoaCtrlVO().getONLINE_LANGUAGE()))
		{
		    reportsCO.setRifMsgDesc(msgVO.getMSG_ARAB());
		}
		else
		{
		    reportsCO.setRifMsgDesc(msgVO.getMSG_ENG());
		}
	    }
	}
	return reportsCO;
    }
    


    public ReportsCO initialize_authWithdTerm(ReportsCO reportsCOParam) throws BaseException
    {
	ReportsCO reportsCO = reportsCOParam;
	
	reportsCO.setValueDate(commonLibBO.returnSystemDateNoTime());
	reportsCO.setFrom_date(DateUtil.getMonthFirstDay(reportsCOParam.getRunningDate()));
	reportsCO.setTo_date(reportsCOParam.getRunningDate());
	reportsCO.getCtsSoaCtrlVO().setONLINE_LANGUAGE(ConstantsCommon.PREFERED_LANG_LATIN);
	
	reportsCO.getAmfVOFrom().setGL_CODE(BigDecimal.ONE);
	reportsCO.getAmfVOTo().setGL_CODE(BigDecimal.valueOf(999999));
	showHideONLINE_LANGUAGE(reportsCO);
	reportsCO.setExcludeMaturedAccounts("true");
	
	applySecurity_authWithdTerm(reportsCO);
	return reportsCO;
    }
    private void applySecurity_authWithdTerm(ReportsCO reportsCO) throws BaseException
    {
	//in case we are opening the screen LIST OF AUTHORIZED W/D FOR TERM DEPOSITS - R005
	if(!(StatementOfAccountConstant.SCREEN_TYPE.SUMMARY_DEP_WITHD_V.equals(reportsCO.get_type())
		|| StatementOfAccountConstant.SCREEN_TYPE.SUMMARY_DEP_WITHD_T.equals(reportsCO.get_type())))
	{
	    reportsCO.setShowLanguage(false);
	    applyDynScreenDisplay(SOA_SPSD_ELEMENTS.ONLINE_LANGUAGE.getId(), SOA_SPSD_ELEMENTS.ONLINE_LANGUAGE
		    .getName(), ConstantsCommon.ACTION_TYPE_VISIBLE, "0", reportsCO.getHm(), null);
	    reportsCO.setShowGlRange(false);
	    applyDynScreenDisplay(new String[] { "glCodeRangeFrom", "glCodeRangeTo", "glCodeRangeBetween",
		    "glCodeRangeAll", "excludeMaturedAccounts" }, ConstantsCommon.ACTION_TYPE_VISIBLE, "0", reportsCO.getHm(), null);
	}
    }
    
    @Override
    public ReportsCO checkBeforeGenerate_authWithdTerm(ReportsCO reportsCOParam) throws BaseException
    {
	ReportsCO reportsCO = reportsCOParam;
	
	if(reportsCOParam.getDateCriteria() == 3 && (reportsCO.getFrom_date() == null || reportsCO.getTo_date() == null))
	{
	    throw new BOException(MessageCodes.INVALID_DATERANGE);
	}
	else if(reportsCOParam.getDateCriteria() == 2)
	{
	    reportsCO.setFrom_date(reportsCO.getValueDate());
	    reportsCO.setTo_date(reportsCO.getValueDate());
	}
	else
	{
	    reportsCO.setFrom_date( DateUtil.createDate(1990, 1, 1));//in case all date is selected
	    reportsCO.setTo_date(reportsCO.getRunningDate());
	}

	if("2".equals(reportsCOParam.getGlCodeRange()))
	{
	    if(NumberUtil.isEmptyDecimal(reportsCO.getAmfVOFrom().getGL_CODE()) || NumberUtil.isEmptyDecimal(reportsCO.getAmfVOTo().getGL_CODE()))
	    {
		throw new BOException(MessageCodes.INVALID_GL_CODE_RANGE);
	    }
	}

	COMPANIESVO companiesVO = new COMPANIESVO();
	companiesVO.setCOMP_CODE(reportsCO.getLoginCompCode());
	companiesVO = commonLibBO.returnLoggedCompanyDetails(companiesVO);

	if(companiesVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
	}

	if(reportsCOParam.getLanguage().equals(ConstantsCommon.PREFERED_LANG_LATIN))
	{
	    reportsCO.setCompDesc(companiesVO.getBRIEF_DESC_ENG());
	}
	else
	{
	    reportsCO.setCompDesc(companiesVO.getBRIEF_DESC_ARAB());
	}

	reportsCO.setBaseCurrencyCode(companiesVO.getBASE_CURRENCY());

	if(reportsCOParam.getRangeByCriteria() != 1)
	{
	    reportsCOParam.setRangeByCriteria( 0);
	}
	fillReportParams_authWithdTerm(reportsCO);	
	return reportsCO;
    }
    
    
    private void fillReportParams_authWithdTerm(ReportsCO reportsCO) throws BaseException
    {
	String reportParams = "";
	String reportType = reportsCO.get_type();
	/*
	 * if the report is opened Processing Clients Statements
	 */
	if(StatementOfAccountConstant.SCREEN_TYPE.SUMMARY_DEP_WITHD_V.equals(reportType)
		|| StatementOfAccountConstant.SCREEN_TYPE.SUMMARY_DEP_WITHD_T.equals(reportType))
	{
	    if("1".equals(reportsCO.getGlCodeRange()))
	    {
		reportsCO.getAmfVOFrom().setGL_CODE(BigDecimal.ONE);
		reportsCO.getAmfVOTo().setGL_CODE(BigDecimal.valueOf(999999));
	    }
	    if(1 == reportsCO.getRangeByCriteria())
	    {
		reportsCO.setFrom_date( DateUtil.createDate(1990, 1, 1));//in case all date is selected
		reportsCO.setTo_date(reportsCO.getRunningDate());
	    }

	    reportParams = CommonMethods.generateReportParams(reportsCO.getCompaniesVO().getBRIEF_DESC_ENG(), 
		    reportsCO.getLoginCompCode(),// RA_COMPANY_CODE
		    reportsCO.getLoginBraCode(),// RA_BRANCH_CODE
		1,  //  reportsCO.getAmfVOFrom().getGL_CODE(),// RA_FR_TYPE
		999999, //   reportsCO.getAmfVOTo().getGL_CODE(),// RA_TO_TYPE
		    DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_FR_DATE
		    DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_TO_DATE
		    StatementOfAccountConstant.SUMM_DEPOSIT_WITHD_CB_IND,// RA_CB_IND
		    StatementOfAccountConstant.SUMM_DEPOSIT_WITHD_BS_CONTRA,// RA_BS_CONTRA
		    DateUtil.format(reportsCO.getRunningDate(), DateUtil.DEFAULT_DATE_FORMAT),// RA_RUNNING_DATE
		    StatementOfAccountConstant.returnSummaryDepWithdType(reportType),// RA_REPORT_FLG
		    reportsCO.getBaseCurrencyCode(),// RA_CURRENCY
		    reportsCO.getBaseCurrDecPoint(),// RA_CURRENCY_DEC
		    StatementOfAccountConstant.returnCheckboxValue(reportsCO.getExcludeMaturedAccounts()),// RA_MATURED
		    StatementOfAccountConstant.returnCheckboxValue(reportsCO.getExcludeRenewedDeposits()),// RA_RENEWED
		    reportsCO.getLoginUserId(),// RA_USERID
		    reportsCO.getOpt(),// RA_REFERENCE
		    StatementOfAccountConstant.SOA_RA_BALANCE_TYPE_AVAIL,// AS_BALANCE_TYPE
		    BigDecimal.ONE,// AL_FR_CY
		    BigDecimal.ONE,// AL_FR_CIF
		    BigDecimal.ZERO,// AL_FR_SL
		    BigDecimal.valueOf(999),// AL_TO_CY
		    BigDecimal.valueOf(99999999),// AL_TO_CIF
		    BigDecimal.valueOf(999),// AL_TO_SL
		    StatementOfAccountConstant.SOA_AS_APP_TYPE,// AS_APP_TYPE
		    StatementOfAccountConstant.SOA_THRESHOLD,// AL_THRESHOLD
		    DateUtil.format(DateUtil.parseDate("01/01/2008", DateUtil.DEFAULT_DATE_FORMAT), DateUtil.DEFAULT_DATE_FORMAT),// ADT_OPENED
		    StatementOfAccountConstant.SOA_AUTOSWEEP,// AS_AUTO_SWEEP
		    StatementOfAccountConstant.SOA_CLEARING,// AS_CLEARING
		    "0",// AS_INCLUDE_REVAL
		    "0",// AS_INCLUDE_REVERSE
		    StatementOfAccountConstant.SOA_AS_STMT_TYPE,// AS_STMT_TYPE
		    StatementOfAccountConstant.SOA_AS_ENDWEEK_DAY,// AS_ENDWEEK_DAY
		    reportsCO.getCtsSoaCtrlVO().getONLINE_LANGUAGE(),
		    StatementOfAccountConstant.SOA_RA_OPTION,
		    null,
		    null //Commented arguments because they are not needed for the reports tar #1006572
		    /*,
		    StatementOfAccountConstant.returnSummaryDepWithdType(reportsCO.get_type()),		    "0"*/);
	    reportsCO.setOpt("R002".concat(StatementOfAccountConstant.EXTENDED_REPORT_PAGEREF));
	}
	
	else
	{
	    
	    reportParams = CommonMethods.generateReportParams(reportsCO.getLoginCompCode(),// RA_COMP
		    reportsCO.getLoginBraCode(),// RA_BRANCH
		    StatementOfAccountConstant.SUMM_DEPOSIT_WITHD_CB_IND,//RA_CB_IND
		    reportsCO.getRangeByCriteria(), //RA_ALLDATES
		    DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
		    DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
		    reportsCO.getBaseCurrencyCode(), //RA_CURRENCY
		    reportsCO.getCompDesc(), //RA_COMP_NAME
		    DateUtil.format(reportsCO.getRunningDate(), DateUtil.DEFAULT_DATE_FORMAT)// RA_SYS_DATE
		  );
	    reportsCO.setOpt("R005");
	}
	reportsCO.setReportParams(reportParams);
    }
    
    //870340 GAB190046 - CHANGE STATEMENT GENERATED ON TRANSACTION TYPE 35 falha
    
    private String fillCustomizedParameters(ReportsCO reportsCO,
	    String reportParams,String reportReference) throws BaseException
    {
	if(StatementOfAccountConstant.SOA_CLIENT_REF.GAB.equals(reportReference))
    {
		AMFVO amfVo=new AMFVO();
		amfVo.setCOMP_CODE(reportsCO.getCompaniesVO().getCOMP_CODE());
		amfVo.setBRANCH_CODE(reportsCO.getAmfVOFrom().getBRANCH_CODE());
		amfVo.setCURRENCY_CODE(reportsCO.getAmfVOFrom().getCURRENCY_CODE());
		amfVo.setGL_CODE(reportsCO.getAmfVOFrom().getGL_CODE());
		amfVo.setCIF_SUB_NO(reportsCO.getAmfVOFrom().getCIF_SUB_NO());
		amfVo.setSL_NO(reportsCO.getAmfVOFrom().getSL_NO());
		amfVo=(AMFVO)genericDAO.selectByPK(amfVo);
		
		reportParams = CommonMethods.generateReportParams(
		reportsCO.getCompaniesVO().getCOMP_CODE(),// RA_COMP		
		DateUtil.format(reportsCO.getFrom_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_FR
		DateUtil.format(reportsCO.getTo_date(), DateUtil.DEFAULT_DATE_FORMAT),// RA_DATE_TO
		reportsCO.getBranchesVO().getBRANCH_CODE(),// RA_LOG_BRANCH
		reportsCO.getBaseCurrencyCode(),// RA_BASE_CY			
		amfVo.getADDITIONAL_REFERENCE()// RA_ACCOUNT
		);
	
	reportsCO.setOpt(reportsCO.getOpt());
	return reportParams;
    }

return reportParams;
}
//870340 GAB190046 - CHANGE STATEMENT GENERATED ON TRANSACTION TYPE 35 falha

      
}
