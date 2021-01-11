package com.path.vo.core.accountcharges;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSOVERDRAFT_SETTLMENTVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_CHARGES_PARAM_TMPVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Hasan Youssef
 * 
 *          AccountChargesCO.java used to
 */
public class AccountChargesCO extends RetailBaseVO
{
    private CTS_CHARGES_PARAM_TMPVO ctsChargesParamTmpVO = new CTS_CHARGES_PARAM_TMPVO();
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private String isFromAlert;
    private String userIsBranchManager;
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private AMFVO amfVO = new AMFVO();
    private GEN_LEDGERVO genledgerVO = new GEN_LEDGERVO();
    private String trxTypeDesc;
    private String chargeName;
    private String chTypeDesc;
    private String chLeaveDesc;
    private String destroyChargesDesc;
    private String cancelChargesDesc;
    private String submitChargesDesc;
    private String statusDesc;
    private String accountChargesStr;
    
    private String entityTypeDisable;
    private String rowDisable;
    private String entityTypeCodeDisable;
    private String trxTypeDisable;
    private String chargeCodeDisable;
    private String relatedEntityTrxDisable;
    private String relatedEntityChqbookDisable;
    private String reasonDisable;
    
    private String USER_ID; 
    private String ACTION_DESC;
    private Date ACTION_DATE;
    
    private String action;
    private CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
    private String 	chqserial_type;
    private String alertAccountDetails;
    private String ACC_DESC;
    private String accAdditionalReference;
    
    private String templateChqbookChargesStr;
    private String templateTrxChargesStr;
    
    private String segStatusDesc;
    
    private String productChargesToBeDeletedStr;
    
    
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    
    /*
     * 
     * LIST of Products Charges for template/Convention
     * 
     * */
    private List<CTS_CHARGES_PARAM_TMPVO> productChargesList = new ArrayList<CTS_CHARGES_PARAM_TMPVO>();
    
    private List<CTS_CHARGES_PARAM_TMPVO> chequebookChargesList = new ArrayList<CTS_CHARGES_PARAM_TMPVO>();
    private List<CTS_CHARGES_PARAM_TMPVO> trxTypeChargesList = new ArrayList<CTS_CHARGES_PARAM_TMPVO>();
    
    private String screenSrc;
    
 
    public String getACC_DESC()
    {
        return ACC_DESC;
    }

    public void setACC_DESC(String aCC_DESC)
    {
        ACC_DESC = aCC_DESC;
    }

	public AlertsParamCO getAlertsParamCO() {
		return alertsParamCO;
	}

	public void setAlertsParamCO(AlertsParamCO alertsParamCO) {
		this.alertsParamCO = alertsParamCO;
	}

	public String getIsFromAlert() {
		return isFromAlert;
	}

	public void setIsFromAlert(String isFromAlert) {
		this.isFromAlert = isFromAlert;
	}

	public String getUserIsBranchManager() {
		return userIsBranchManager;
	}

	public void setUserIsBranchManager(String userIsBranchManager) {
		this.userIsBranchManager = userIsBranchManager;
	}

	public CTSTELLERVO getCtsTellerVO() {
		return ctsTellerVO;
	}

	public void setCtsTellerVO(CTSTELLERVO ctsTellerVO) {
		this.ctsTellerVO = ctsTellerVO;
	}

	public AMFVO getAmfVO() {
		return amfVO;
	}

	public void setAmfVO(AMFVO amfVO) {
		this.amfVO = amfVO;
	}

	public GEN_LEDGERVO getGenledgerVO() {
		return genledgerVO;
	}

	public void setGenledgerVO(GEN_LEDGERVO genledgerVO) {
		this.genledgerVO = genledgerVO;
	}

	public String getTrxTypeDesc() {
		return trxTypeDesc;
	}

	public void setTrxTypeDesc(String trxTypeDesc) {
		this.trxTypeDesc = trxTypeDesc;
	}

	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}

	public String getChTypeDesc() {
		return chTypeDesc;
	}

	public void setChTypeDesc(String chTypeDesc) {
		this.chTypeDesc = chTypeDesc;
	}

	public String getChLeaveDesc() {
		return chLeaveDesc;
	}

	public void setChLeaveDesc(String chLeaveDesc) {
		this.chLeaveDesc = chLeaveDesc;
	}

	public String getDestroyChargesDesc() {
		return destroyChargesDesc;
	}

	public void setDestroyChargesDesc(String destroyChargesDesc) {
		this.destroyChargesDesc = destroyChargesDesc;
	}

	public String getCancelChargesDesc() {
		return cancelChargesDesc;
	}

	public void setCancelChargesDesc(String cancelChargesDesc) {
		this.cancelChargesDesc = cancelChargesDesc;
	}

	public CTS_CHARGES_PARAM_TMPVO getCtsChargesParamTmpVO() {
		return ctsChargesParamTmpVO;
	}

	public void setCtsChargesParamTmpVO(CTS_CHARGES_PARAM_TMPVO ctsChargesParamTmpVO) {
		this.ctsChargesParamTmpVO = ctsChargesParamTmpVO;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getAccountChargesStr() {
		return accountChargesStr;
	}

	public void setAccountChargesStr(String accountChargesStr) {
		this.accountChargesStr = accountChargesStr;
	}

	public String getSubmitChargesDesc() {
		return submitChargesDesc;
	}

	public void setSubmitChargesDesc(String submitChargesDesc) {
		this.submitChargesDesc = submitChargesDesc;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getACTION_DESC() {
		return ACTION_DESC;
	}

	public void setACTION_DESC(String aCTION_DESC) {
		ACTION_DESC = aCTION_DESC;
	}

	public Date getACTION_DATE() {
		return ACTION_DATE;
	}

	public void setACTION_DATE(Date aCTION_DATE) {
		ACTION_DATE = aCTION_DATE;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getEntityTypeDisable() {
		return entityTypeDisable;
	}

	public void setEntityTypeDisable(String entityTypeDisable) {
		this.entityTypeDisable = entityTypeDisable;
	}

	public String getRowDisable() {
		return rowDisable;
	}

	public void setRowDisable(String rowDisable) {
		this.rowDisable = rowDisable;
	}

	public String getEntityTypeCodeDisable() {
		return entityTypeCodeDisable;
	}

	public void setEntityTypeCodeDisable(String entityTypeCodeDisable) {
		this.entityTypeCodeDisable = entityTypeCodeDisable;
	}

	public String getTrxTypeDisable() {
		return trxTypeDisable;
	}

	public void setTrxTypeDisable(String trxTypeDisable) {
		this.trxTypeDisable = trxTypeDisable;
	}

	public String getChargeCodeDisable() {
		return chargeCodeDisable;
	}

	public void setChargeCodeDisable(String chargeCodeDisable) {
		this.chargeCodeDisable = chargeCodeDisable;
	}

	public String getRelatedEntityTrxDisable() {
		return relatedEntityTrxDisable;
	}

	public void setRelatedEntityTrxDisable(String relatedEntityTrxDisable) {
		this.relatedEntityTrxDisable = relatedEntityTrxDisable;
	}

	public String getRelatedEntityChqbookDisable() {
		return relatedEntityChqbookDisable;
	}

	public void setRelatedEntityChqbookDisable(String relatedEntityChqbookDisable) {
		this.relatedEntityChqbookDisable = relatedEntityChqbookDisable;
	}

	public String getReasonDisable() {
		return reasonDisable;
	}

	public void setReasonDisable(String reasonDisable) {
		this.reasonDisable = reasonDisable;
	}

	public CTSCONTROLVO getCtsControlVO() {
		return ctsControlVO;
	}

	public void setCtsControlVO(CTSCONTROLVO ctsControlVO) {
		this.ctsControlVO = ctsControlVO;
	}

	public String getChqserial_type() {
		return chqserial_type;
	}

	public void setChqserial_type(String chqserial_type) {
		this.chqserial_type = chqserial_type;
	}

	public String getAlertAccountDetails() {
		return alertAccountDetails;
	}

	public void setAlertAccountDetails(String alertAccountDetails) {
		this.alertAccountDetails = alertAccountDetails;
	}

	public String getAccAdditionalReference()
	{
	    return accAdditionalReference;
	}

	public void setAccAdditionalReference(String accAdditionalReference)
	{
	    this.accAdditionalReference = accAdditionalReference;
	}

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBusinessElement()
	{
	    return businessElement;
	}

	public void setBusinessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessElement)
	{
	    this.businessElement = businessElement;
	}

	public String getTemplateChqbookChargesStr()
	{
	    return templateChqbookChargesStr;
	}

	public void setTemplateChqbookChargesStr(String templateChqbookChargesStr)
	{
	    this.templateChqbookChargesStr = templateChqbookChargesStr;
	}

	public List<CTS_CHARGES_PARAM_TMPVO> getChequebookChargesList()
	{
	    return chequebookChargesList;
	}

	public void setChequebookChargesList(List<CTS_CHARGES_PARAM_TMPVO> chequebookChargesList)
	{
	    this.chequebookChargesList = chequebookChargesList;
	}

	public List<CTS_CHARGES_PARAM_TMPVO> getTrxTypeChargesList()
	{
	    return trxTypeChargesList;
	}

	public void setTrxTypeChargesList(List<CTS_CHARGES_PARAM_TMPVO> trxTypeChargesList)
	{
	    this.trxTypeChargesList = trxTypeChargesList;
	}

	public String getTemplateTrxChargesStr()
	{
	    return templateTrxChargesStr;
	}

	public void setTemplateTrxChargesStr(String templateTrxChargesStr)
	{
	    this.templateTrxChargesStr = templateTrxChargesStr;
	}

	public String getSegStatusDesc()
	{
	    return segStatusDesc;
	}

	public void setSegStatusDesc(String segStatusDesc)
	{
	    this.segStatusDesc = segStatusDesc;
	}

	public List<CTS_CHARGES_PARAM_TMPVO> getProductChargesList()
	{
	    return productChargesList;
	}

	public void setProductChargesList(List<CTS_CHARGES_PARAM_TMPVO> productChargesList)
	{
	    this.productChargesList = productChargesList;
	}

	public String getProductChargesToBeDeletedStr()
	{
	    return productChargesToBeDeletedStr;
	}

	public void setProductChargesToBeDeletedStr(String productChargesToBeDeletedStr)
	{
	    this.productChargesToBeDeletedStr = productChargesToBeDeletedStr;
	}

	public String getScreenSrc()
	{
	    return screenSrc;
	}

	public void setScreenSrc(String screenSrc)
	{
	    this.screenSrc = screenSrc;
	}
}