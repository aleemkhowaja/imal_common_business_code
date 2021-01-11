package com.path.vo.core.avapayment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_AVA_FILEVO;
import com.path.dbmaps.vo.CTS_AVA_FILE_COMPANIONVO;
import com.path.dbmaps.vo.CTS_AVA_PAYMENTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.core.avabenef.AvaBeneficiariesDefCO;
import com.path.vo.core.avacategory.AvaCategoryCO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.entitycharges.EntityChargesCO;
import com.path.vo.core.trxmgnt.TrxMgntCO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * AvaPaymentCO.java used to
 */
public class AvaPaymentCO extends  RetailBaseVO
{
	private CTS_AVA_PAYMENTVO avaPaymentVO = new CTS_AVA_PAYMENTVO();
	//private CTS_AVA_BENEFICIARIESVO avaBeneficiariesVO = new CTS_AVA_BENEFICIARIESVO();
	private AvaBeneficiariesDefCO avaBeneficiariesDefCO = new AvaBeneficiariesDefCO();
	private AlertsParamCO alertsParamCO = new AlertsParamCO();
	private AvaCategoryCO avaCategoryCO = new AvaCategoryCO();
	private String statusDesc = new String();
	private CTS_AVA_FILEVO avaFileVO = new CTS_AVA_FILEVO();
	private String categoryDesc;
	private String cifDesc;
	private String statusFileDesc;
	private String paymentMethod;
	private String returnType;
	private String avaDestinationCountryDesc;
	private String avaReturnFCCYDesc;
	private String destinationCountry;
	private String fileName;
	private String benefDesc;
	private String confirmMsg;
	private String confirmMgnt;
	private String continueProcess;
        private Integer confirmationCode;
        private String isFromAlert;
        private String userIsBranchManager;
        private boolean isRemoteAlertApprove;
        private String localApproveUserName;
        private BigDecimal returnPaymentCode;
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO > hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private boolean fromRetrieve = false;
	private BigDecimal paymentLimit; 
	private String periodicity;
	private BigDecimal cumulativePayment;
	private BigDecimal availableBal;
	private ArrayList<String> listOfWarningMessages = new ArrayList<String>();
	private String originCountryCodeDesc;
	private BigDecimal cifAge;
	private BigDecimal maxPayment;
	private String idTypeDesc;
	private String cifNbrDesc;
	private CTS_AVA_FILE_COMPANIONVO avaFileCompanionVO;
	
	private EntityChargesCO entityChargesCO = new EntityChargesCO();
	private String chargesGridIsEmptied = "false";
	private String isWaived;
	private String chargesGridUpdates;
	private TrxMgntCO trxMgntCO;
	private CTSTELLERVO ctsTellerVO;
	private String accName;
	private String accAddRef;
	private Date startPeriodDate;
	private Date endPeriodDate;
	private BigDecimal nofPeriod;
	
	private String companyTypeDesc;
	private String address;
	private String showBranchesChar;
	private String operationTypeDesc;
	
	//Bug # 409575 -- [John Massaad]
	private BigDecimal loginUserBranchCode;
	
	private String avaFCCurrencyDesc;
	private String reverseReasonType;
	private String reasonDesc ;
	private String userId;
	private String pageRef;
	private BigDecimal tellerCode;
	private BigDecimal originalExchRate;

	
	
	public CTS_AVA_FILE_COMPANIONVO getAvaFileCompanionVO()
	{
	    return avaFileCompanionVO;
	}

	public void setAvaFileCompanionVO(CTS_AVA_FILE_COMPANIONVO avaFileCompanionVO)
	{
	    this.avaFileCompanionVO = avaFileCompanionVO;
	}

	
	/**
	 * @return the hm
	 */
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
	{
	    return hm;
	}

	/**
	 * @param hm the hm to set
	 */
	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
	{
	    this.hm = hm;
	}

	//private String idTypeDesc;
	/**
	 * @return the avaPaymentVO
	 */
	public CTS_AVA_PAYMENTVO getAvaPaymentVO()
	{
	    return avaPaymentVO;
	}

	/**
	 * @param avaPaymentVO the avaPaymentVO to set
	 */
	public void setAvaPaymentVO(CTS_AVA_PAYMENTVO avaPaymentVO)
	{
	    this.avaPaymentVO = avaPaymentVO;
	}

	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc()
	{
	    return statusDesc;
	}

	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc)
	{
	    this.statusDesc = statusDesc;
	}

	/**
	 * @return the ayaBeneficiariesVO
	 */
	/*public CTS_AVA_BENEFICIARIESVO getAvaBeneficiariesVO()
	{
	    return avaBeneficiariesVO;
	}
*/
	/**
	 * @param ayaBeneficiariesVO the ayaBeneficiariesVO to set
	 */
	/*public void setAvaBeneficiariesVO(CTS_AVA_BENEFICIARIESVO avaBeneficiariesVO)
	{
	    this.avaBeneficiariesVO = avaBeneficiariesVO;
	}*/

	/**
	 * @return the avaFileVO
	 */
	public CTS_AVA_FILEVO getAvaFileVO()
	{
	    return avaFileVO;
	}

	/**
	 * @param avaFileVO the avaFileVO to set
	 */
	public void setAvaFileVO(CTS_AVA_FILEVO avaFileVO)
	{
	    this.avaFileVO = avaFileVO;
	}

	/**
	 * @return the categoryDesc
	 */
	public String getCategoryDesc()
	{
	    return categoryDesc;
	}

	/**
	 * @param categoryDesc the categoryDesc to set
	 */
	public void setCategoryDesc(String categoryDesc)
	{
	    this.categoryDesc = categoryDesc;
	}

	/**
	 * @return the cifDesc
	 */
	public String getCifDesc()
	{
	    return cifDesc;
	}

	/**
	 * @param cifDesc the cifDesc to set
	 */
	public void setCifDesc(String cifDesc)
	{
	    this.cifDesc = cifDesc;
	}

	/**
	 * @return the statusFileDesc
	 */
	public String getStatusFileDesc()
	{
	    return statusFileDesc;
	}

	/**
	 * @param statusFileDesc the statusFileDesc to set
	 */
	public void setStatusFileDesc(String statusFileDesc)
	{
	    this.statusFileDesc = statusFileDesc;
	}

	/**
	 * @return the avaDestinationCountryDesc
	 */
	public String getAvaDestinationCountryDesc()
	{
	    return avaDestinationCountryDesc;
	}

	/**
	 * @param avaDestinationCountryDesc the avaDestinationCountryDesc to set
	 */
	public void setAvaDestinationCountryDesc(String avaDestinationCountryDesc)
	{
	    this.avaDestinationCountryDesc = avaDestinationCountryDesc;
	}

	/**
	 * @return the avaReturnFCCYDesc
	 */
	public String getAvaReturnFCCYDesc()
	{
	    return avaReturnFCCYDesc;
	}

	/**
	 * @param avaReturnFCCYDesc the avaReturnFCCYDesc to set
	 */
	public void setAvaReturnFCCYDesc(String avaReturnFCCYDesc)
	{
	    this.avaReturnFCCYDesc = avaReturnFCCYDesc;
	}

	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod()
	{
	    return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod)
	{
	    this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the returnType
	 */
	public String getReturnType()
	{
	    return returnType;
	}

	/**
	 * @param returnType the returnType to set
	 */
	public void setReturnType(String returnType)
	{
	    this.returnType = returnType;
	}

	/**
	 * @return the destinationCountry
	 */
	public String getDestinationCountry()
	{
	    return destinationCountry;
	}

	/**
	 * @param destinationCountry the destinationCountry to set
	 */
	public void setDestinationCountry(String destinationCountry)
	{
	    this.destinationCountry = destinationCountry;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName()
	{
	    return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName)
	{
	    this.fileName = fileName;
	}

	/**
	 * @return the benefDesc
	 */
	public String getBenefDesc()
	{
	    return benefDesc;
	}

	/**
	 * @param benefDesc the benefDesc to set
	 */
	public void setBenefDesc(String benefDesc)
	{
	    this.benefDesc = benefDesc;
	}

	/**
	 * @return the idTypeDesc
	 */
	/*public String getIdTypeDesc()
	{
	    return idTypeDesc;
	}

	/**
	 * @param idTypeDesc the idTypeDesc to set
	 */
	/*public void setIdTypeDesc(String idTypeDesc)
	{
	    this.idTypeDesc = idTypeDesc;
	}*/

	/**
	 * @return the avaBeneficiariesDefCO
	 */
	public AvaBeneficiariesDefCO getAvaBeneficiariesDefCO()
	{
	    return avaBeneficiariesDefCO;
	}

	/**
	 * @param avaBeneficiariesDefCO the avaBeneficiariesDefCO to set
	 */
	public void setAvaBeneficiariesDefCO(AvaBeneficiariesDefCO avaBeneficiariesDefCO)
	{
	    this.avaBeneficiariesDefCO = avaBeneficiariesDefCO;
	}

	/**
	 * @return the confirmationCode
	 */
	public Integer getConfirmationCode()
	{
	    return confirmationCode;
	}

	/**
	 * @param confirmationCode the confirmationCode to set
	 */
	public void setConfirmationCode(Integer confirmationCode)
	{
	    this.confirmationCode = confirmationCode;
	}

	/**
	 * @return the confirmMsg
	 */
	public String getConfirmMsg()
	{
	    return confirmMsg;
	}

	/**
	 * @param confirmMsg the confirmMsg to set
	 */
	public void setConfirmMsg(String confirmMsg)
	{
	    this.confirmMsg = confirmMsg;
	}

	/**
	 * @return the confirmMgnt
	 */
	public String getConfirmMgnt()
	{
	    return confirmMgnt;
	}

	/**
	 * @param confirmMgnt the confirmMgnt to set
	 */
	public void setConfirmMgnt(String confirmMgnt)
	{
	    this.confirmMgnt = confirmMgnt;
	}

	/**
	 * @return the continueProcess
	 */
	public String getContinueProcess()
	{
	    return continueProcess;
	}

	/**
	 * @param continueProcess the continueProcess to set
	 */
	public void setContinueProcess(String continueProcess)
	{
	    this.continueProcess = continueProcess;
	}

	/**
	 * @return the isFromAlert
	 */
	public String getIsFromAlert()
	{
	    return isFromAlert;
	}

	/**
	 * @param isFromAlert the isFromAlert to set
	 */
	public void setIsFromAlert(String isFromAlert)
	{
	    this.isFromAlert = isFromAlert;
	}

	/**
	 * @return the userIsBranchManager
	 */
	public String getUserIsBranchManager()
	{
	    return userIsBranchManager;
	}

	/**
	 * @param userIsBranchManager the userIsBranchManager to set
	 */
	public void setUserIsBranchManager(String userIsBranchManager)
	{
	    this.userIsBranchManager = userIsBranchManager;
	}

	/**
	 * @return the isRemoteAlertApprove
	 */
	public boolean isRemoteAlertApprove()
	{
	    return isRemoteAlertApprove;
	}

	/**
	 * @param isRemoteAlertApprove the isRemoteAlertApprove to set
	 */
	public void setRemoteAlertApprove(boolean isRemoteAlertApprove)
	{
	    this.isRemoteAlertApprove = isRemoteAlertApprove;
	}

	/**
	 * @return the localApproveUserName
	 */
	public String getLocalApproveUserName()
	{
	    return localApproveUserName;
	}

	/**
	 * @param localApproveUserName the localApproveUserName to set
	 */
	public void setLocalApproveUserName(String localApproveUserName)
	{
	    this.localApproveUserName = localApproveUserName;
	}

	public AlertsParamCO getAlertsParamCO() {
		return alertsParamCO;
	}

	public void setAlertsParamCO(AlertsParamCO alertsParamCO) {
		this.alertsParamCO = alertsParamCO;
	}


	/**
	 * @param returnPaymentCode the returnPaymentCode to set
	 */
	public void setReturnPaymentCode(BigDecimal returnPaymentCode)
	{
	    this.returnPaymentCode = returnPaymentCode;
	}

	/**
	 * @return the returnPaymentCode
	 */
	public BigDecimal getReturnPaymentCode()
	{
	    return returnPaymentCode;
	}

	/**
	 * @return the fromRetrieve
	 */
	public boolean isFromRetrieve()
	{
	    return fromRetrieve;
	}

	/**
	 * @param fromRetrieve the fromRetrieve to set
	 */
	public void setFromRetrieve(boolean fromRetrieve)
	{
	    this.fromRetrieve = fromRetrieve;
	}

	public BigDecimal getPaymentLimit()
	{
	    return paymentLimit;
	}

	public void setPaymentLimit(BigDecimal paymentLimit)
	{
	    this.paymentLimit = paymentLimit;
	}

	public String getPeriodicity()
	{
	    return periodicity;
	}

	public void setPeriodicity(String periodicity)
	{
	    this.periodicity = periodicity;
	}

	public BigDecimal getCumulativePayment()
	{
	    return cumulativePayment;
	}

	public void setCumulativePayment(BigDecimal cumulativePayment)
	{
	    this.cumulativePayment = cumulativePayment;
	}


	public BigDecimal getAvailableBal()
	{
	    return availableBal;
	}

	public void setAvailableBal(BigDecimal availableBal)
	{
	    this.availableBal = availableBal;
	}

	public ArrayList<String> getListOfWarningMessages() {
		return listOfWarningMessages;
	}

	public void setListOfWarningMessages(ArrayList<String> listOfWarningMessages) {
		this.listOfWarningMessages = listOfWarningMessages;
	}

	public String getOriginCountryCodeDesc() {
		return originCountryCodeDesc;
	}

	public void setOriginCountryCodeDesc(String originCountryCodeDesc) {
		this.originCountryCodeDesc = originCountryCodeDesc;
	}

	public BigDecimal getCifAge() {
		return cifAge;
	}

	public void setCifAge(BigDecimal cifAge) {
		this.cifAge = cifAge;
	}

	public BigDecimal getMaxPayment() {
		return maxPayment;
	}

	public void setMaxPayment(BigDecimal maxPayment) {
		this.maxPayment = maxPayment;
	}


	public AvaCategoryCO getAvaCategoryCO() {
		return avaCategoryCO;
	}

	public void setAvaCategoryCO(AvaCategoryCO avaCategoryCO) {
		this.avaCategoryCO = avaCategoryCO;
	}

	public String getIdTypeDesc() {
		return idTypeDesc;
	}

	public void setIdTypeDesc(String idTypeDesc) {
		this.idTypeDesc = idTypeDesc;
	}

	public String getCifNbrDesc() {
		return cifNbrDesc;
	}

	public void setCifNbrDesc(String cifNbrDesc) {
		this.cifNbrDesc = cifNbrDesc;
	}

	public String getChargesGridIsEmptied()
	{
	    return chargesGridIsEmptied;
	}

	public void setChargesGridIsEmptied(String chargesGridIsEmptied)
	{
	    this.chargesGridIsEmptied = chargesGridIsEmptied;
	}

	public String getIsWaived()
	{
	    return isWaived;
	}

	public void setIsWaived(String isWaived)
	{
	    this.isWaived = isWaived;
	}

	public String getChargesGridUpdates()
	{
	    return chargesGridUpdates;
	}

	public void setChargesGridUpdates(String chargesGridUpdates)
	{
	    this.chargesGridUpdates = chargesGridUpdates;
	}

	public TrxMgntCO getTrxMgntCO()
	{
	    return trxMgntCO;
	}

	public void setTrxMgntCO(TrxMgntCO trxMgntCO)
	{
	    this.trxMgntCO = trxMgntCO;
	}

	public CTSTELLERVO getCtsTellerVO()
	{
	    return ctsTellerVO;
	}

	public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
	{
	    this.ctsTellerVO = ctsTellerVO;
	}

	public EntityChargesCO getEntityChargesCO()
	{
	    return entityChargesCO;
	}

	public void setEntityChargesCO(EntityChargesCO entityChargesCO)
	{
	    this.entityChargesCO = entityChargesCO;
	}

	public String getCompanyTypeDesc()
	{
	    return companyTypeDesc;
	}

	public void setCompanyTypeDesc(String companyTypeDesc)
	{
	    this.companyTypeDesc = companyTypeDesc;
	}

	public String getAddress()
	{
	    return address;
	}

	public void setAddress(String address)
	{
	    this.address = address;
	}

	public String getAccName()
	{
	    return accName;
	}

	public void setAccName(String accName)
	{
	    this.accName = accName;
	}

	public String getAccAddRef()
	{
	    return accAddRef;
	}

	public void setAccAddRef(String accAddRef)
	{
	    this.accAddRef = accAddRef;
	}

	public Date getStartPeriodDate() {
		return startPeriodDate;
	}

	public void setStartPeriodDate(Date startPeriodDate) {
		this.startPeriodDate = startPeriodDate;
	}

	public Date getEndPeriodDate() {
		return endPeriodDate;
	}

	public void setEndPeriodDate(Date endPeriodDate) {
		this.endPeriodDate = endPeriodDate;
	}

	public BigDecimal getNofPeriod()
	{
	    return nofPeriod;
	}

	public void setNofPeriod(BigDecimal nofPeriod)
	{
	    this.nofPeriod = nofPeriod;
	}

	public String getShowBranchesChar() {
		return showBranchesChar;
	}

	public void setShowBranchesChar(String showBranchesChar) {
		this.showBranchesChar = showBranchesChar;
	}

	public String getOperationTypeDesc()
	{
	    return operationTypeDesc;
	}

	public void setOperationTypeDesc(String operationTypeDesc)
	{
	    this.operationTypeDesc = operationTypeDesc;
	}

	public BigDecimal getLoginUserBranchCode()
	{
	    return loginUserBranchCode;
	}

	public void setLoginUserBranchCode(BigDecimal loginUserBranchCode)
	{
	    this.loginUserBranchCode = loginUserBranchCode;
	}

	public String getAvaFCCurrencyDesc()
	{
	    return avaFCCurrencyDesc;
	}

	public void setAvaFCCurrencyDesc(String avaFCCurrencyDesc)
	{
	    this.avaFCCurrencyDesc = avaFCCurrencyDesc;
	}

	public String getReverseReasonType()
	{
	    return reverseReasonType;
	}

	public void setReverseReasonType(String reverseReasonType)
	{
	    this.reverseReasonType = reverseReasonType;
	}

	public String getReasonDesc()
	{
	    return reasonDesc;
	}

	public void setReasonDesc(String reasonDesc)
	{
	    this.reasonDesc = reasonDesc;
	}

	public String getUserId()
	{
	    return userId;
	}

	public void setUserId(String userId)
	{
	    this.userId = userId;
	}

	public String getPageRef()
	{
	    return pageRef;
	}

	public void setPageRef(String pageRef)
	{
	    this.pageRef = pageRef;
	}

	public BigDecimal getTellerCode()
	{
	    return tellerCode;
	}

	public void setTellerCode(BigDecimal tellerCode)
	{
	    this.tellerCode = tellerCode;
	}

	public BigDecimal getOriginalExchRate()
	{
	    return originalExchRate;
	}

	public void setOriginalExchRate(BigDecimal originalExchRate)
	{
	    this.originalExchRate = originalExchRate;
	}
	
	
}
