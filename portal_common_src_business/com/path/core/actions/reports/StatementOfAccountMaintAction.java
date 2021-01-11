package com.path.core.actions.reports;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.path.actions.ReportAction;
import com.path.actions.base.RetailReportBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.reports.ReportsBO;
import com.path.bo.core.reports.StatementOfAccountConstant;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.TMP_REPORTSVOWithBLOBs;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.core.reports.ReportsCO;
//import com.path.core.bo.trxmgnt.TrxMgntBO;
import com.path.vo.core.reports.ReportsSC;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.reporting.ReportOutputCO;

/**
 * @author eliasaoun
 * @category w_report_stmt_bnk_acc_new / ret_soa_win.pbl, w_report_stmt_acc_ret
 *           / ret02,w_report_statement_boubyan / ret_soa_win.pbl
 */
public class StatementOfAccountMaintAction extends RetailReportBaseAction
{
    protected ReportsCO reportsCO = new ReportsCO();
    protected ReportsSC reportsSC = new ReportsSC();
    protected ReportsBO reportsBO;
    //NABIL FEGHALI - IIAB110237 - SOA Charges
    protected ReportAction reportAction;
    //protected TrxMgntBO trxMgntBO;
    protected TrxMgntCO trxMgntCO = new TrxMgntCO(); 
    
    protected HashMap<String, String> reportByDateList = new HashMap<String, String>();

    protected LinkedHashMap<String, String> rangeByCriteriaList = new LinkedHashMap<String, String>();

    protected InputStream inputPDFStream;

    private List<SelectCO> exportTypeList = new ArrayList<SelectCO>();
    
    private String auditTrxNbr; //Rania - FIBSI190047
    
    @Override
    public Object getModel()
    {
	return reportsSC;
    }

    /**
     * redirection to the main page
     */
    public String initialize() throws Exception
    {
	SessionCO sessionCO;
	try
	{
	    sessionCO = returnSessionObject();
	    fillSessionVariables(sessionCO);
	    
	    //Bug [238819] hiding recordLogs button
	    set_showRecordLogsBtn("false");
	    
	    reportsCO.set_type(super._type);
	    reportsCO.setTrxMgntCO(trxMgntCO);
	    

	    SelectSC selSC = new SelectSC(StatementOfAccountConstant.EXPORT_TYPE);
	    exportTypeList = returnLOV(selSC);
	    
	    reportsCO = reportsBO.getInitData( reportsCO);
	    reportsCO.setExportType("PDF");
	    applySecurity();
	    initDataViewScope(sessionCO);
	    
	    setAuditTrxNbr(prepareAuditTrxNbr()); //Rania - FIBSI190047
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * common method to fill session variables needed to continue our process
     * @param sessionCO
     */
    public void fillSessionVariables(SessionCO sessionCO)
    {
	reportsCO.setLoginBraCode(sessionCO.getBranchCode());
	reportsCO.setLoginCompCode(sessionCO.getCompanyCode());
	reportsCO.setRunningDate(sessionCO.getRunningDateRET());
	reportsCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	reportsCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
	reportsCO.setOpt(get_pageRef());
	reportsCO.setAppName(sessionCO.getCurrentAppName());
	reportsCO.setLanguage(sessionCO.getLanguage());
    }

    /**
     * Initialize required values that are sets for struts tags
     * @param sessionCO
     */
    private void initDataViewScope(SessionCO sessionCO) throws Exception
    {

	gregoHijriDateList.put(StatementOfAccountConstant.GREGORIAN_DATE_FROMAT, getText("gregorian_date_key"));
	gregoHijriDateList.put(StatementOfAccountConstant.HIJRI_DATE_FROMAT, getText("hijri_date_key"));
	if(StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED.equals(_type))
	{
	    if(ConstantsCommon.YES.equals(reportsCO.getCtsAdminSoaCtrlVO().getSHOW_HIJRI_DATE()))
	    {
		gregoHijriDateList.remove(StatementOfAccountConstant.GREGORIAN_DATE_FROMAT);
	    }
	    else if(ConstantsCommon.NO.equals(reportsCO.getCtsAdminSoaCtrlVO().getSHOW_HIJRI_DATE()))
	    {
		gregoHijriDateList.remove(StatementOfAccountConstant.HIJRI_DATE_FROMAT);
	    }
	}
	    
	reportByDateList.put(StatementOfAccountConstant.REPORT_BY_TRADE_DATE, getText("Trade_Date_key"));
	reportByDateList.put(StatementOfAccountConstant.REPORT_BY_VALUE_DATE, getText("valueDate_key"));

	yesNoRadioList.put("false", getText("no_key"));
	yesNoRadioList.put("true", getText("yes_key"));

	
	//@Modif : w_report_statement_boubyan (TP id:83155)
	if(StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED.equals(_type)
		|| StatementOfAccountConstant.SCREEN_TYPE.ARCHIVE.equals(_type)
		|| StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED_BB_ITM.equals(_type) 
		|| StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED_AL_HILAL.equals(_type))
	{
	    if(!StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO().getRETRIEVE_BY_IBAN(), ConstantsCommon.YES)
		    .equals(ConstantsCommon.NO))
	    {
		//if the IBAN is parameterized as "Not shown" it will be hidden
		if(!"0".equals(StringUtil.nullEmptyToValue(reportsCO.getAccNVCONTROLVO().getSHOW_IBAN_ACC(), "0")))
		{
		    rangeByCriteriaList.put("1", getText("by_iban_key"));
		}
	    }
	    if(!StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO().getRETRIEVE_BY_ACCOUNT(),
		    ConstantsCommon.YES).equals(ConstantsCommon.NO))
	    {
		rangeByCriteriaList.put("2", getText("by_accounts_key"));
	    }
	    if(!StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO().getRETRIEVE_BY_REFERENCE(),
		    ConstantsCommon.YES).equals(ConstantsCommon.NO))
	    {
		rangeByCriteriaList.put("3", getText("by_reference_key"));
	    }
	    if(!StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO().getRETRIEVE_BY_CARDNO(),
		    ConstantsCommon.YES).equals(ConstantsCommon.NO))
	    {
		rangeByCriteriaList.put("4", getText("by_card_no_key"));
	    }
	}

	initDataViewScope_ONLINE_LANGUAGE();
	//NABIl FEGHALI - FIX ISSUE #198804
	reportsCO.getCompaniesVO().setCOMP_CODE(sessionCO.getCompanyCode());
	if(NumberUtil.isEmptyDecimal(reportsCO.getBranchesVO().getBRANCH_CODE()))
	{
	    reportsCO.getBranchesVO().setBRANCH_CODE(sessionCO.getBranchCode());
	}
	//default company name
	reportsCO.getCompaniesVO().setBRIEF_DESC_ENG(sessionCO.getCompanyName());
	
//	if(NumberUtil.isEmptyDecimal(reportsCO.getAmfVOFrom().getBRANCH_CODE()))
//	{
//	    reportsCO.getAmfVOFrom().setBRANCH_CODE(sessionCO.getBranchCode());
//	}
//	if(NumberUtil.isEmptyDecimal(reportsCO.getAmfVOTo().getBRANCH_CODE()))
//	{
//	    reportsCO.getAmfVOTo().setBRANCH_CODE(sessionCO.getBranchCode());
//	}
	
	if(StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES.equals(_type)
		|| StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES_APPROVE.equals(_type))
	{
	    RequiredFieldsSC requiredFieldsSC = new RequiredFieldsSC();
	    requiredFieldsSC.setCompCode(sessionCO.getCompanyCode());
	    requiredFieldsSC.setBranchCode(sessionCO.getBranchCode());
	    requiredFieldsSC.setAppName(sessionCO.getCurrentAppName());
	    requiredFieldsSC.setProgRef(com.path.bo.core.reports.StatementOfAccountConstant.SOA_CLIENT_REF.STANDARD);
	    requiredFieldsSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    requiredFieldsSC.setLoginUserId(sessionCO.getUserName());
	    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = returnCommonLibBO().returnMapRequiredData(requiredFieldsSC);
	    reportsCO.getHm().putAll(hm);//Ali AMMAR 16/03/2017 BUG 1 for TP# 497260
    	    setAdditionalScreenParams(reportsCO.getHm());
	    
	}
    }

    
    /** @Modif : w_report_statement_boubyan (TP id:83155)
     * reportsCO.ctsSoaCtrlVO.ONLINE_LANGUAGE
     */
    private void initDataViewScope_ONLINE_LANGUAGE()
    {
	if(StatementOfAccountConstant.SOA_CLIENT_REF.SUMMARIZED.equals(get_pageRef()))
	{
	    // report language
	    reportsCO.getCtsSoaCtrlVO().setONLINE_LANGUAGE(ConstantsCommon.LANGUAGE_ENGLISH);
	    languageList.put(ConstantsCommon.LANGUAGE_ARABIC, getText("arabic_key"));
	    languageList.put(ConstantsCommon.LANGUAGE_ENGLISH, getText("latin_key"));
	}
	else
	{
	    // message language
	    //reportsCO.getCtsSoaCtrlVO().setONLINE_LANGUAGE(ConstantsCommon.PREFERED_LANG_LATIN);
	    languageList.put(ConstantsCommon.PREFERED_LANG_ARABIC, getText("arabic_key"));
	    languageList.put(ConstantsCommon.PREFERED_LANG_LATIN, getText("latin_key"));
	    if(StatementOfAccountConstant.SCREEN_TYPE.CUSTOMIZED.equals(_type))
	    {
		String onlineLanguage = StringUtil.nullEmptyToValue(reportsCO.getCtsAdminSoaCtrlVO()
			.getONLINE_LANGUAGE(), StatementOfAccountConstant.ONLINE_LANGUAGE_DEFAULT_LATIN);
		String pthLanguage = reportsCO.getPthCtrlVO().getLANGUAGE();
		if(onlineLanguage.equals(StatementOfAccountConstant.ONLINE_LANGUAGE_ENGLISH)
			&& !"3".endsWith(StringUtil.nullEmptyToValue(pthLanguage, 0)))
		{
		    languageList.remove(ConstantsCommon.PREFERED_LANG_ARABIC);
		}
		else if(onlineLanguage.equals(StatementOfAccountConstant.ONLINE_LANGUAGE_ARABIC)
			&& !"1".endsWith(StringUtil.nullEmptyToValue(pthLanguage, 0)))
		{
		    reportsCO.getCtsSoaCtrlVO().setONLINE_LANGUAGE(ConstantsCommon.PREFERED_LANG_ARABIC);
		    languageList.remove(ConstantsCommon.PREFERED_LANG_LATIN);
		}
	    }
	}
    }

    /**
     * this method is used to show/hide criteria based on the _type of the screen
     * screen
     */
    private void applySecurity()
    {
	try
	{
	    // flag to show/hide the info bar , it should be hidden if we open
	    // it from 360 degrees menu
	    boolean showInfoBar = StatementOfAccountConstant.SCREEN_TYPE.DASHBOARD.equals(_type) || StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES.equals(_type) || StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES_APPROVE.equals(_type) ? false : true;
	    ServletActionContext.getRequest().setAttribute("showInfoBar", showInfoBar);
	    //NABIL FEGHALI - IIAB110237 - SOA Charges
	    if(StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES_APPROVE.equals(_type))
	    {
		set_recReadOnly("true");
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	set_showSmartInfoBtn("false");
	super.setAdditionalScreenParams(reportsCO.getHm());
    }


    // default values gregoHijriDateList
    public String getDefaultGregoHijriDateList()
    {
	return StatementOfAccountConstant.GREGORIAN_DATE_FROMAT;
    }
    
    //related property reportsCO.ctsSoaCtrlVO.ONLINE_DATE_TYPE
    public String getDefaultReportByDateList()
    {
	return reportsCO.getCtsSoaCtrlVO().getONLINE_DATE_TYPE();
    }
    
    // related property reportsCO.ctsSoaCtrlVO.ONLINE_LANGUAGE
    public String getDefaultLanguageList()
    {
	return reportsCO.getCtsSoaCtrlVO().getONLINE_LANGUAGE();
    }
    
    // related property RangeByCriteria
    public int getDefaultRangeByCriteria()
    {
	return reportsCO.getRangeByCriteria();
    }
    
    // related property ctsSoaCtrlVO.STMT_WITHOUT_MVT_ON
    public String getDefaultIncludeStmtWithoutMvmt()
    {
	return reportsCO.getCtsSoaCtrlVO().getSTMT_WITHOUT_MVT_ON();
    }
    
    // related property reportsCO.ctsSoaCtrlVO.MSG_IN_REPORT_ON
    public String getDefaultMsgIncludeInReport(){
	return reportsCO.getCtsSoaCtrlVO().getMSG_IN_REPORT_ON();
    }
    
    // related property ctsSoaCtrlVO.ONLINE_ADD_REF
    public String getDefaultAddReference(){
	return reportsCO.getCtsSoaCtrlVO().getONLINE_ADD_REF() ;
    }
    
    public String getDefaultPrintLogo(){
	return "false" ;
    }

    // end default values
    
    
    /**
     * ue_checked
     */
    public String checkBeforeGenerate()
    {
	SessionCO sessionCO;
	try
	{
	    sessionCO = returnSessionObject();

	    fillSessionVariables(sessionCO);
	    reportsCO.setCtsTellerVO(sessionCO.getCtsTellerVO());
	    reportsCO.setLoginUserId(sessionCO.getUserName());
	    reportsCO.setCrud(getIv_crud());

	    //NABIL FEGHALI - IIAB110237 - SOA Charges
	    if(StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES.equals(reportsCO.get_type()))
	    {
		reportsCO.setOpt(com.path.bo.core.reports.StatementOfAccountConstant.SOA_CLIENT_REF.STANDARD);
	    }
	    
	    reportsCO = reportsBO.checkBeforeGenerate_statementOfAccount(reportsCO);
	    
	    //NABIL FEGHALI - IIAB110237 - SOA Charges
	    if(StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES.equals(reportsCO.get_type()))
	    {
		applyStatementCharges();
	    }
	    
	    //Rania - FIBSI190047
	    reportsCO.getAmfVOFrom().setCOMP_CODE(reportsCO.getLoginCompCode());
	    reportsCO.getAmfVOFrom().setADDITIONAL_REFERENCE(get_pageRef());
	    
	    applyRetrieveAudit(AuditConstant.STATEMENT_OF_ACCOUNT_KEY, reportsCO.getAmfVOFrom(), reportsCO);
	    //
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return LOADJSON;
    }
    
    //NABIL FEGHALI - IIAB110237 - SOA Charges
    private void applyStatementCharges() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	reportAction.session = this.session;
	reportAction.setA_p("0");
	reportAction.setD_p("2");
	reportAction.setL(reportsCO.getCtsSoaCtrlVO().getONLINE_LANGUAGE());
	reportAction.setR_a_p(reportsCO.getReportParams());
	reportAction.setR_r(StatementOfAccountConstant.SOA_CLIENT_REF.WIFAK_ACC_STATEMENT);//ALI AMMAR 20/03/2017 Request from CHAFIC 
	reportAction.setVar_format("PDF");
	reportAction.setFlushResponse(false);
	reportAction.setW_p("1");
	reportAction.generateReport();
	ReportOutputCO reportOutputCO = reportAction.getReportOutputCO();
	if(reportOutputCO == null)
	{
	    throw new BOException(MessageCodes.STATEMENT_OF_ACCOUNT_NOT_GENERATED);
	}
	else
	{
	    int pageNbr = reportOutputCO.getPagesNbr();
	    if(pageNbr == 0)// throw message in case no records found
	    {
		throw new BOException(MessageCodes.NO_RECORDS_FOR_THIS_RANGE);
	    }
	     if(pageNbr > 0)
	    {
		trxMgntCO.setLanguage(sessionCO.getLanguage());
		trxMgntCO.setLoginUserId(sessionCO.getUserName());
		trxMgntCO.setLoginBraCode(sessionCO.getBranchCode());
		trxMgntCO.setCtsTellerVO(sessionCO.getCtsTellerVO());
		trxMgntCO.setLoginCompCode(sessionCO.getCompanyCode());
		trxMgntCO.setRunningDateRET(sessionCO.getRunningDateRET());
		trxMgntCO.setPthCtrlVO(returnCommonLibBO().returnPthCtrl());
		trxMgntCO.setCrud(getIv_crud() == null ? "R" : getIv_crud().split(",")[0]);
		trxMgntCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
		trxMgntCO.setLoginTellerCode(sessionCO.getCtsTellerVO().getCODE());
		trxMgntCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
		trxMgntCO.getCtstrsStatementVO().setSOA_NB_PAGES(new BigDecimal(pageNbr));
		trxMgntCO.getCtstrsStatementVO().setSOA_DATE_FROM(reportsCO.getFrom_date());
		trxMgntCO.getCtstrsStatementVO().setSOA_DATE_TO(reportsCO.getTo_date());
		
//		trxMgntCO = trxMgntBO.applyStatementCharges(trxMgntCO);
		this.session.put(TrxMgntConstant.SOA_REPORT_BYTES, reportOutputCO.getReportBytes2());
		this.session.put(TrxMgntConstant.SOA_WATERMARK_REPORT_BYTES, reportOutputCO.getReportBytes());
		trxMgntCO.setOpenSOAReport(StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES);
		NumberUtil.resetEmptyValues(trxMgntCO);
	    }
	}
    
    }
    
    //NABIL FEGHALI - IIAB110237 - SOA Charges
    public String returnStatementChargesReport() throws BaseException 
    {
	try
	{
	    byte[] reportBytes = null;
	    if(StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES.equals(trxMgntCO.getOpenSOAReport()))
	    {
		reportBytes = (byte[]) this.session.get(TrxMgntConstant.SOA_WATERMARK_REPORT_BYTES);
	    }
	    else if(StatementOfAccountConstant.SCREEN_TYPE.TRX_CHARGES_APPROVE.equals(trxMgntCO.getOpenSOAReport()))
	    {
		TMP_REPORTSVOWithBLOBs tmpReportsWithblobs = new TMP_REPORTSVOWithBLOBs();
		tmpReportsWithblobs.setCOMP_CODE(trxMgntCO.getCtstrsVO().getCOMP_CODE());
		tmpReportsWithblobs.setBRANCH_CODE(trxMgntCO.getCtstrsVO().getBRANCH_CODE());
		tmpReportsWithblobs.setREP_ID(trxMgntCO.getCtstrsVO().getOBJ_CODE());
		tmpReportsWithblobs = reportsBO.returnTmpReports(tmpReportsWithblobs);
		if(tmpReportsWithblobs != null)
		{
		    reportBytes = tmpReportsWithblobs.getREP_OBJECT();
		}
	    }
	    
	    if(reportBytes == null || reportBytes.length <= 0)
	    {
		throw new BOException(MessageCodes.STATEMENT_OF_ACCOUNT_NOT_GENERATED);
	    }
	    else
	    {
		inputPDFStream  =  new ByteArrayInputStream(reportBytes);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "successPDFStream";
    }
    
    /**
     * @author RaniaAlBitar
     * Request FIBSI190047
     */
    
    public String prepareAuditTrxNbr()
    {
	String auditTrxNbr = "";
	
	auditTrxNbr = String.format("%1$" + 4 + "s", reportsCO.getLoginCompCode().toString()).replace(' ', '0');

	if(get_pageRef() != null)
	{
	    auditTrxNbr = auditTrxNbr.concat(String.format("%1$" + 35 + "s", get_pageRef().toString()).replace(' ', '0'));
	}
	else
	{
	    auditTrxNbr = auditTrxNbr.concat(String.format("%1$" + 35 + "s", "0").replace(' ', '0'));
	}
	   
	return auditTrxNbr;
    }
    
    /**
     * Getters and Setters
     */
    public void setReportsBO(ReportsBO reportsBO)
    {
	this.reportsBO = reportsBO;
    }

    public ReportsCO getReportsCO()
    {
	return reportsCO;
    }

    public void setReportsCO(ReportsCO reportsCO)
    {
	this.reportsCO = reportsCO;
    }

    public ReportsSC getReportsSC()
    {
	return reportsSC;
    }

    public void setReportsSC(ReportsSC reportsSC)
    {
	this.reportsSC = reportsSC;
    }


    public HashMap<String, String> getReportByDateList()
    {
	return reportByDateList;
    }

    public void setReportByDateList(HashMap<String, String> reportByDateList)
    {
	this.reportByDateList = reportByDateList;
    }

    public LinkedHashMap<String, String> getRangeByCriteriaList()
    {
        return rangeByCriteriaList;
    }

    public void setRangeByCriteriaList(LinkedHashMap<String, String> rangeByCriteriaList)
    {
        this.rangeByCriteriaList = rangeByCriteriaList;
    }

    public void setReportAction(ReportAction reportAction)
    {
        this.reportAction = reportAction;
    }

    public TrxMgntCO getTrxMgntCO()
    {
        return trxMgntCO;
    }

    public void setTrxMgntCO(TrxMgntCO trxMgntCO)
    {
        this.trxMgntCO = trxMgntCO;
    }

//    public void setTrxMgntBO(TrxMgntBO trxMgntBO)
//    {
//        this.trxMgntBO = trxMgntBO;
//    }

    public InputStream getInputPDFStream()
    {
        return inputPDFStream;
    }

    public void setInputPDFStream(InputStream inputPDFStream)
    {
        this.inputPDFStream = inputPDFStream;
    }

    public List<SelectCO> getExportTypeList()
    {
        return exportTypeList;
    }

    public void setExportTypeList(List<SelectCO> exportTypeList)
    {
        this.exportTypeList = exportTypeList;
    }

    public String getAuditTrxNbr()
    {
        return auditTrxNbr;
    }

    public void setAuditTrxNbr(String auditTrxNbr)
    {
        this.auditTrxNbr = auditTrxNbr;
    }
}
