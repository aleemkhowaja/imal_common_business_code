package com.path.core.actions.reports;

import com.path.actions.base.RetailReportBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.reports.ReportsBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.reports.ReportsCO;
import com.path.vo.core.reports.ReportsSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: EliasAoun
 *
 * ReportsDependencyAction.java used to
 */
public class ReportsDependencyAction extends RetailReportBaseAction
{
    private ReportsBO reportsBO;
    private ReportsCO reportsCO = new ReportsCO();
    private ReportsSC reportsSC = new ReportsSC();
    private final static String LOADJSON = "loadJson";

    
    @Override
    public Object getModel()
    {
	return reportsCO;
    }
    
    
    public String companyDependency()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(reportsCO.getCompaniesVO().getCOMP_CODE()))
	    {
		reportsCO = reportsBO.checkCompanyDependency(reportsCO);
	    }else{
		reportsCO.getCompaniesVO().setCOMP_CODE(null);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }

    
    private void handleException1(Exception e, String object, String object2)
    {
	reportsCO = null;	
	handleException(e, object, object2);
    }


    public String branchByCodeDependency()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(reportsCO.getBranchesVO().getBRANCH_CODE()))
	    {
		SessionCO sessionCO = returnSessionObject();
		reportsCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
		reportsCO.getCompaniesVO().setCOMP_CODE(sessionCO.getCompanyCode()); //SANDRA
		reportsCO = reportsBO.checkBranchByCodeDependency(reportsCO);
	    }
	    else
	    {
		reportsCO.getBranchesVO().setBRANCH_CODE(null);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }

    
    public String accBrFromDependency()
    {
	try
	{
	    if(NumberUtil.isNumberPositive(reportsCO.getAmfVOFrom().getBRANCH_CODE()))
	    {
		reportsCO.getAmfVOTo().setBRANCH_CODE(reportsCO.getAmfVOFrom().getBRANCH_CODE());
		if ( reportsCO.getBranchesVO() != null) 
		{
			reportsCO.getBranchesVO().setBRANCH_CODE(reportsCO.getAmfVOFrom().getBRANCH_CODE());
			SessionCO sessionCO = returnSessionObject();
			reportsCO.getCompaniesVO().setCOMP_CODE(sessionCO.getCompanyCode());
			branchByCodeDependency();
		}
	    }
	    else
	    {
		reportsCO.getAmfVOFrom().setBRANCH_CODE(null);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    public String accCyFromDependency()
    {
	try
	{
	    if(NumberUtil.isNumberPositive(reportsCO.getAmfVOFrom().getCURRENCY_CODE()))
	    {
		reportsCO.getAmfVOTo().setCURRENCY_CODE(reportsCO.getAmfVOFrom().getCURRENCY_CODE());
	    }
	    else
	    {
		reportsCO.getAmfVOFrom().setCURRENCY_CODE(null);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    
    public String accGlFromDependency()
    {
	try
	{
	    if(NumberUtil.isEmptyDecimal(reportsCO.getAmfVOFrom().getGL_CODE()))
	    {
		reportsCO.getAmfVOFrom().setGL_CODE(null);
	    }
	    else
	    {
		reportsCO.getAmfVOTo().setGL_CODE(reportsCO.getAmfVOFrom().getGL_CODE());
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    
    
    public String accCifFromDependency()
    {
	try
	{
	    if(NumberUtil.isEmptyDecimal(reportsCO.getAmfVOFrom().getCIF_SUB_NO()))
	    {
		reportsCO.getAmfVOFrom().setCIF_SUB_NO(null);
	    }
	    else
	    {
		reportsCO.getAmfVOTo().setCIF_SUB_NO(reportsCO.getAmfVOFrom().getCIF_SUB_NO());
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    
    public String accSlFromDependency()
    {
	try
	{
	    if(NumberUtil.isEmptyDecimal(reportsCO.getAmfVOFrom().getSL_NO()))
	    {
		reportsCO.getAmfVOFrom().setSL_NO(null);
	    }
	    else
	    {
		reportsCO.getAmfVOTo().setSL_NO(reportsCO.getAmfVOFrom().getSL_NO());
		  if(NumberUtil.isEmptyDecimal(reportsCO.getAmfVOFrom().getSL_NO()))
		    {
			reportsCO.getAmfVOTo().setSL_NO( null);
			throw new BOException(MessageCodes.INVALID_FROM_ACC);
				
		    }
		  if ( reportsCO.getBranchesVO() != null) 
			{
				reportsCO.getBranchesVO().setBRANCH_CODE(reportsCO.getAmfVOFrom().getBRANCH_CODE());
				SessionCO sessionCO = returnSessionObject();
				reportsCO.getCompaniesVO().setCOMP_CODE(sessionCO.getCompanyCode());
				branchByCodeDependency();
			}
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    /**
     * @param reportsCO.amfVOTo.CURRENCY_CODE
     * @dependenOn reportsCO.amfVOTo.CURRENCY_CODE
     */
    public String accCyToDependency()
    {
	try
	{
	    if(NumberUtil.isEmptyDecimal(reportsCO.getAmfVOTo().getCURRENCY_CODE()))
	    {
		reportsCO.getAmfVOTo().setCURRENCY_CODE( null);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    
    
    /**
     * @param reportsCO.amfVOTo.GL_CODE
     * @dependenOn reportsCO.amfVOTo.GL_CODE
     */
    public String accGlToDependency(){
	try
	{
	    if(NumberUtil.isEmptyDecimal(reportsCO.getAmfVOTo().getGL_CODE()))
	    {
		reportsCO.getAmfVOTo().setGL_CODE( null);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    
    /**
     * @param reportsCO.amfVOTo.CIF_SUB_NO
     * @dependenOn reportsCO.amfVOTo.CIF_SUB_NO
     */
    public String accCifToDependency(){
	try
	{
	    if(NumberUtil.isEmptyDecimal(reportsCO.getAmfVOTo().getCIF_SUB_NO()))
	    {
		reportsCO.getAmfVOTo().setCIF_SUB_NO( null);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    
    /**
     * @param reportsCO.amfVOTo.SL_NO
     * @dependenOn reportsCO.amfVOTo.SL_NO
     */
    public String accSlToDependency(){
	try
	{
	    if(NumberUtil.isEmptyDecimal(reportsCO.getAmfVOTo().getSL_NO()))
	    {
		reportsCO.getAmfVOTo().setSL_NO( null);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    
    
    /**
     * @param reportsCO.stmtPeriodicity
     */
    public String stmtPeriodicityDependency()
    {
	try
	{
	    fillSessionVariables();

	    reportsCO = reportsBO.checkStmtPeriodicity(reportsCO);
	    getAdditionalScreenParams().putAll(reportsCO.getHm());
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    
    /**
     * @param reportsCO.amfVOFrom.IBAN_ACC_NO
     */
    public String fromIbanDependency(){
	try
	{
	    if(StringUtil.isNotEmpty( reportsCO.getAmfVOFrom().getIBAN_ACC_NO())){
		reportsCO = reportsBO.checkFromIbanDependency(reportsCO);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    /**
      * @Modif : w_report_statement_boubyan (TP id:83155)
      * @param reportsCO.amfVOTo.IBAN_ACC_NO
     */
    public String toIbanDependency(){
	try
	{
	    if(StringUtil.isNotEmpty( reportsCO.getAmfVOTo().getIBAN_ACC_NO())){
		reportsCO = reportsBO.checkToIbanDependency(reportsCO);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    /**
     * fill the session varibales of the used Type ReportsCO
     */
    private void fillSessionVariables()
    {
	SessionCO sessionCO = returnSessionObject();
	reportsCO.setRunningDate(sessionCO.getRunningDateRET());
	reportsCO.setLoginCompCode(sessionCO.getCompanyCode());
	reportsCO.setLanguage(sessionCO.getLanguage());
	reportsCO.setOpt(get_pageRef());
	reportsCO.setAppName(sessionCO.getCurrentAppName());
    }
    
    
    /**
      * @Modif : w_report_statement_boubyan (TP id:83155)
      * @param reportsCO.amfVOFrom.ADDITIONAL_REFERENCE
     */
    public String fromReferenceDependency(){
	try
	{
	    if( StringUtil.isNotEmpty( reportsCO.getAmfVOFrom().getADDITIONAL_REFERENCE())){
		reportsCO = reportsBO.checkFromReferenceDependency(reportsCO);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    /**
     * @Modif : w_report_statement_boubyan (TP id:83155)
     * @param reportsCO.amfVOTo.ADDITIONAL_REFERENCE
     */
    public String toReferenceDependency(){
	try
	{
	    if( StringUtil.isNotEmpty( reportsCO.getAmfVOTo().getADDITIONAL_REFERENCE())){
		reportsCO = reportsBO.checkToReferenceDependency(reportsCO);
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    /**
     * @Modif : w_report_statement_boubyan (TP id:83155)
     * @param reportsCO.fromCardNo
     */
    public String fromCardNoDependency(){
	try
	{
	    reportsCO.setLoginPreferrredLanguage(returnSessionObject().getPreferredLanguage());
	    if(StringUtil.isNotEmpty( reportsCO.getFromCardNo())){
		reportsCO = reportsBO.checkFromCardNoDependency(reportsCO);
	    }else{
		reportsCO = null;
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    /**
     * @param reportsCO.from_date
     */
    public String fromDateDependency(){
	try
	{
	    reportsCO.setRunningDate(returnSessionObject().getRunningDateRET());
	    if(reportsCO.getFrom_date() != null){
		reportsCO = reportsBO.fromDateDependency(reportsCO);
	    }else{
		reportsCO = null;
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    /**
     * @param reportsCO.from_date
     */
    public String toDateDependency(){
	try
	{
	    reportsCO.setRunningDate(returnSessionObject().getRunningDateRET());
	    if(reportsCO.getTo_date() != null){
		reportsCO = reportsBO.toDateDependency(reportsCO);
	    }else{
		reportsCO = null;
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    /**
     * @Modif : w_report_statement_boubyan (TP id:83155)
     * @param reportsCO.rangeByCriteria
     * @description called from StatementOfAccountMaint.js
     */
    public String showHideRangeByCriteria()
    {
	try
	{
	    reportsCO.setLoginPreferrredLanguage(returnSessionObject().getPreferredLanguage());
	    fillSessionVariables();
	    
	    reportsCO = reportsBO.showHideRangeByCriteria(reportsCO);
	    getAdditionalScreenParams().putAll(reportsCO.getHm());
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    public String showHideRangeGregoHijri()
    {
	try
	{
	    reportsCO.setLoginPreferrredLanguage(returnSessionObject().getPreferredLanguage());
	    fillSessionVariables();
	    
	    reportsCO = reportsBO.showHideRangeGregoHijri(reportsCO);
	    getAdditionalScreenParams().putAll(reportsCO.getHm());
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    /**
     * 08/09/2015
     */
    public String chooseLanguageDependency()
    {
	try
	{
	    reportsCO.setLoginPreferrredLanguage(returnSessionObject().getPreferredLanguage());
	    fillSessionVariables();
	    
	    reportsCO = reportsBO.chooseLanguageDependency(reportsCO);
	    getAdditionalScreenParams().putAll(reportsCO.getHm());
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    
    
    /**
     * 08/09/2015
     */
    public String msgIncludeInReportDependency()
    {
	try
	{
	    reportsCO.setLoginPreferrredLanguage(returnSessionObject().getPreferredLanguage());
	    fillSessionVariables();
	    
	    reportsCO = reportsBO.msgIncludeInReportDependency(reportsCO);
	    getAdditionalScreenParams().putAll(reportsCO.getHm());
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
    }
    
    /**
     * 08/09/2015
     */
    public String rifMessageCodeDependency()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(reportsCO.getRifMessageVO().getMSG_CODE()))
	    {
		reportsCO.setLoginPreferrredLanguage(returnSessionObject().getPreferredLanguage());
		fillSessionVariables();

		reportsCO = reportsBO.rifMessageCodeDependency(reportsCO);
		getAdditionalScreenParams().putAll(reportsCO.getHm());
	    }
	}
	catch(Exception e)
	{
	    handleException1(e, null, null);
	}
	return LOADJSON;
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

}
