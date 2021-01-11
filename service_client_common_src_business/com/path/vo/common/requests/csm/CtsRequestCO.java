/**
 * 
 */
package com.path.vo.common.requests.csm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSREQ_CHARGES_DETVO;
import com.path.dbmaps.vo.CTS_REQUESTVOWithBLOBs;
import com.path.dbmaps.vo.CTS_REQUEST_TYPEVO;
import com.path.dbmaps.vo.PMSORDERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.entitycharges.EntityChargesCO;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          CtsRequestCO.java used to
 */
public class CtsRequestCO extends RetailBaseVO
{
	private CTS_REQUESTVOWithBLOBs ctsRequestVO = new CTS_REQUESTVOWithBLOBs();
    private CTSREQ_CHARGES_DETVO ctsReqChargesDetVO  = new CTSREQ_CHARGES_DETVO();

    private String processBranchDesc;
    private String reqReferene;
    private String saveType;
    private String isEmptied = "true";
    private String isWaived;
    private String originalProgRef;
    private String originalAppName;
    private String appName;

    private BigDecimal amount;
    private String facilityType;
    private String applicationFor;
    private String language;
    private String cyDesc;
    private String requestStatusDesc;
    private String requestTypeDesc;
    private BigDecimal cyDecimal;
    private BigDecimal cifBranch;
    private String cifDesc;
    private BigDecimal periodicity;
    private String additionalRef;

    private BigDecimal facilityNumber;

    private BigDecimal cifIdNo;
    private String cifIdNoStr;
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal requestTypeCode;
    private BigDecimal requestCy;
    private BigDecimal requestCif;

    private BigDecimal NBR_DAYS;
    private BigDecimal FIELD_N11;
    private BigDecimal FIELD_N12;
    private BigDecimal FIELD_N13;
    private BigDecimal FIELD_N14;
    private BigDecimal FIELD_N15;
    private String ADDITIONAL_REFERENCE;
    private String ACCOUNT_NAME;
    private String FIELD_S4;
    private String FIELD_S17;
    private String statusColorCode;
    private Date runningDate;
    private String opt; // Opt Reference
    private EntityChargesCO entityChargesCO = new EntityChargesCO();
    private AMFVO amfVO = new AMFVO();
    private String paymentType;
    private BigDecimal scannedCIFNo;
    private String showPaymentType = "true";
    private String iisRequest;

    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hmSysParam = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private String automatic;
    private String specialSub;
    private BigDecimal tradingCurrency;

    // added by rany for assests process
    private PMSORDERVO pmsordervo = new PMSORDERVO();
    private String ripsType;
    private String stpPurchase;
    private String reportFlag;
    private BigDecimal processRepNo;
    private String openPrintSetup;
    private BigDecimal print;
    private String enableVerify;
    private String msg;
    private String tfaStatus;
    private CTS_REQUEST_TYPEVO requestTypeVO=new CTS_REQUEST_TYPEVO();
    private String docType;
    private boolean screenProcess;
    
    
    // ERROR HANDLING
    private String errType;
    private String errText;
    private BigDecimal errCode;
    

    // end assets

  
 
    /**
     * @return the requestStatusDesc
     */
    public String getRequestStatusDesc()
    {
	return requestStatusDesc;
    }

    /**
     * @param requestStatusDesc the requestStatusDesc to set
     */
    public void setRequestStatusDesc(String requestStatusDesc)
    {
	this.requestStatusDesc = requestStatusDesc;
    }

    /**
     * @return the requestTypeDesc
     */
    public String getRequestTypeDesc()
    {
	return requestTypeDesc;
    }

    /**
     * @param requestTypeDesc the requestTypeDesc to set
     */
    public void setRequestTypeDesc(String requestTypeDesc)
    {
	this.requestTypeDesc = requestTypeDesc;
    }

    /**
     * @return the processBranchDesc
     */
    public String getProcessBranchDesc()
    {
	return processBranchDesc;
    }

    /**
     * @param processBranchDesc the processBranchDesc to set
     */
    public void setProcessBranchDesc(String processBranchDesc)
    {
	this.processBranchDesc = processBranchDesc;
    }

    public BigDecimal getCifIdNo()
    {
	return cifIdNo;
    }

    public void setCifIdNo(BigDecimal cifIdNo)
    {
	this.cifIdNo = cifIdNo;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public String getReqReferene()
    {
	return reqReferene;
    }

    public void setReqReferene(String reqReferene)
    {
	this.reqReferene = reqReferene;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHmSysParam()
    {
	return hmSysParam;
    }

    public void setHmSysParam(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hmSysParam)
    {
	this.hmSysParam = hmSysParam;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    @Override
    public Date getRunningDate()
    {
	return runningDate;
    }

    @Override
    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public String getApplicationFor()
    {
	return applicationFor;
    }

    public void setApplicationFor(String applicationFor)
    {
	this.applicationFor = applicationFor;
    }

    public String getFacilityType()
    {
	return facilityType;
    }

    public void setFacilityType(String facilityType)
    {
	this.facilityType = facilityType;
    }

    public BigDecimal getFacilityNumber()
    {
	return facilityNumber;
    }

    public void setFacilityNumber(BigDecimal facilityNumber)
    {
	this.facilityNumber = facilityNumber;
    }

    public BigDecimal getNBR_DAYS()
    {
	return NBR_DAYS;
    }

    public void setNBR_DAYS(BigDecimal nBRDAYS)
    {
	NBR_DAYS = nBRDAYS;
    }

    public BigDecimal getFIELD_N11()
    {
	return FIELD_N11;
    }

    public void setFIELD_N11(BigDecimal fIELDN11)
    {
	FIELD_N11 = fIELDN11;
    }

    public BigDecimal getFIELD_N12()
    {
	return FIELD_N12;
    }

    public void setFIELD_N12(BigDecimal fIELDN12)
    {
	FIELD_N12 = fIELDN12;
    }

    public BigDecimal getFIELD_N13()
    {
	return FIELD_N13;
    }

    public void setFIELD_N13(BigDecimal fIELDN13)
    {
	FIELD_N13 = fIELDN13;
    }

    public BigDecimal getFIELD_N14()
    {
	return FIELD_N14;
    }

    public void setFIELD_N14(BigDecimal fIELDN14)
    {
	FIELD_N14 = fIELDN14;
    }

    public BigDecimal getFIELD_N15()
    {
	return FIELD_N15;
    }

    public void setFIELD_N15(BigDecimal fIELDN15)
    {
	FIELD_N15 = fIELDN15;
    }

    public String getADDITIONAL_REFERENCE()
    {
	return ADDITIONAL_REFERENCE;
    }

    public void setADDITIONAL_REFERENCE(String aDDITIONALREFERENCE)
    {
	ADDITIONAL_REFERENCE = aDDITIONALREFERENCE;
    }

    public String getACCOUNT_NAME()
    {
	return ACCOUNT_NAME;
    }

    public void setACCOUNT_NAME(String aCCOUNTNAME)
    {
	ACCOUNT_NAME = aCCOUNTNAME;
    }

    public String getFIELD_S4()
    {
	return FIELD_S4;
    }

    public void setFIELD_S4(String fIELDS4)
    {
	FIELD_S4 = fIELDS4;
    }

    public String getFIELD_S17()
    {
	return FIELD_S17;
    }

    public void setFIELD_S17(String fIELDS17)
    {
	FIELD_S17 = fIELDS17;
    }

    public BigDecimal getRequestTypeCode()
    {
	return requestTypeCode;
    }

    public void setRequestTypeCode(BigDecimal requestTypeCode)
    {
	this.requestTypeCode = requestTypeCode;
    }

    public String getOriginalProgRef()
    {
	return originalProgRef;
    }

    public void setOriginalProgRef(String originalProgRef)
    {
	this.originalProgRef = originalProgRef;
    }

    public String getOriginalAppName()
    {
	return originalAppName;
    }

    public void setOriginalAppName(String originalAppName)
    {
	this.originalAppName = originalAppName;
    }

    @Override
    public String getAppName()
    {
	return appName;
    }

    @Override
    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public void setStatusColorCode(String statusColorCode)
    {
	this.statusColorCode = statusColorCode;
    }

    public String getStatusColorCode()
    {
	return statusColorCode;
    }

    /**
     * @return the cifBranch
     */
    public BigDecimal getCifBranch()
    {
	return cifBranch;
    }

    /**
     * @param cifBranch the cifBranch to set
     */
    public void setCifBranch(BigDecimal cifBranch)
    {
	this.cifBranch = cifBranch;
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
     * @return the periodicity
     */
    public BigDecimal getPeriodicity()
    {
	return periodicity;
    }

    /**
     * @param periodicity the periodicity to set
     */
    public void setPeriodicity(BigDecimal periodicity)
    {
	this.periodicity = periodicity;
    }

    /**
     * @return the additionalRef
     */
    public String getAdditionalRef()
    {
	return additionalRef;
    }

    /**
     * @param additionalRef the additionalRef to set
     */
    public void setAdditionalRef(String additionalRef)
    {
	this.additionalRef = additionalRef;
    }

    /**
     * @return the cyDesc
     */
    public String getCyDesc()
    {
	return cyDesc;
    }

    /**
     * @param cyDesc the cyDesc to set
     */
    public void setCyDesc(String cyDesc)
    {
	this.cyDesc = cyDesc;
    }

    /**
     * @return the cyDecimal
     */
    public BigDecimal getCyDecimal()
    {
	return cyDecimal;
    }

    /**
     * @param cyDecimal the cyDecimal to set
     */
    public void setCyDecimal(BigDecimal cyDecimal)
    {
	this.cyDecimal = cyDecimal;
    }

    /**
     * @return the language
     */
    @Override
    public String getLanguage()
    {
	return language;
    }

    /**
     * @param language the language to set
     */
    @Override
    public void setLanguage(String language)
    {
	this.language = language;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount()
    {
	return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    /**
     * @return the isEmptied
     */
    public String getIsEmptied()
    {
	return isEmptied;
    }

    /**
     * @param isEmptied the isEmptied to set
     */
    public void setIsEmptied(String isEmptied)
    {
	this.isEmptied = isEmptied;
    }

    /**
     * @return the isWaived
     */
    public String getIsWaived()
    {
	return isWaived;
    }

    /**
     * @param isWaived the isWaived to set
     */
    public void setIsWaived(String isWaived)
    {
	this.isWaived = isWaived;
    }

    /**
     * @return the opt
     */
    @Override
    public String getOpt()
    {
	return opt;
    }

    /**
     * @param opt the opt to set
     */
    @Override
    public void setOpt(String opt)
    {
	this.opt = opt;
    }

    /**
     * @return the entityChargesCO
     */
    public EntityChargesCO getEntityChargesCO()
    {
	return entityChargesCO;
    }

    /**
     * @param entityChargesCO the entityChargesCO to set
     */
    public void setEntityChargesCO(EntityChargesCO entityChargesCO)
    {
	this.entityChargesCO = entityChargesCO;
    }

    /**
     * @return the amfVO
     */
    public AMFVO getAmfVO()
    {
	return amfVO;
    }

    /**
     * @param amfVO the amfVO to set
     */
    public void setAmfVO(AMFVO amfVO)
    {
	this.amfVO = amfVO;
    }

    /**
     * @return the paymentType
     */
    public String getPaymentType()
    {
	return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType)
    {
	this.paymentType = paymentType;
    }

    public BigDecimal getScannedCIFNo()
    {
	return scannedCIFNo;
    }

    public void setScannedCIFNo(BigDecimal scannedCIFNo)
    {
	this.scannedCIFNo = scannedCIFNo;
    }

    public String getShowPaymentType()
    {
	return showPaymentType;
    }

    public void setShowPaymentType(String showPaymentType)
    {
	this.showPaymentType = showPaymentType;
    }

    public String getIisRequest()
    {
	return iisRequest;
    }

    public void setIisRequest(String iisRequest)
    {
	this.iisRequest = iisRequest;
    }

    /**
     * @param automatic the automatic to set
     */
    public void setAutomatic(String automatic)
    {
	this.automatic = automatic;
    }

    /**
     * @return the automatic
     */
    public String getAutomatic()
    {
	return automatic;
    }

    /**
     * @param pmsordervo the pmsordervo to set
     */
    public void setPmsordervo(PMSORDERVO pmsordervo)
    {
	this.pmsordervo = pmsordervo;
    }

    /**
     * @return the pmsordervo
     */
    public PMSORDERVO getPmsordervo()
    {
	return pmsordervo;
    }

    /**
     * @param specialSub the specialSub to set
     */
    public void setSpecialSub(String specialSub)
    {
	this.specialSub = specialSub;
    }

    /**
     * @return the specialSub
     */
    public String getSpecialSub()
    {
	return specialSub;
    }

    /**
     * @param tradingCurrency the tradingCurrency to set
     */
    public void setTradingCurrency(BigDecimal tradingCurrency)
    {
	this.tradingCurrency = tradingCurrency;
    }

    /**
     * @return the tradingCurrency
     */
    public BigDecimal getTradingCurrency()
    {
	return tradingCurrency;
    }

    /**
     * @param ripsType the ripsType to set
     */
    public void setRipsType(String ripsType)
    {
	this.ripsType = ripsType;
    }

    /**
     * @return the ripsType
     */
    public String getRipsType()
    {
	return ripsType;
    }

    /**
     * @param errType the errType to set
     */
    public void setErrType(String errType)
    {
	this.errType = errType;
    }

    /**
     * @return the errType
     */
    public String getErrType()
    {
	return errType;
    }

    /**
     * @param errText the errText to set
     */
    public void setErrText(String errText)
    {
	this.errText = errText;
    }

    /**
     * @return the errText
     */
    public String getErrText()
    {
	return errText;
    }

    /**
     * @param errCode the errCode to set
     */
    public void setErrCode(BigDecimal errCode)
    {
	this.errCode = errCode;
    }

    /**
     * @return the errCode
     */
    public BigDecimal getErrCode()
    {
	return errCode;
    }

    /**
     * @param enableVerify the enableVerify to set
     */
    public void setEnableVerify(String enableVerify)
    {
	this.enableVerify = enableVerify;
    }

    /**
     * @return the enableVerify
     */
    public String getEnableVerify()
    {
	return enableVerify;
    }

    /**
     * @param reportFlag the reportFlag to set
     */
    public void setReportFlag(String reportFlag)
    {
	this.reportFlag = reportFlag;
    }

    /**
     * @return the reportFlag
     */
    public String getReportFlag()
    {
	return reportFlag;
    }

    /**
     * @param processRepNo the processRepNo to set
     */
    public void setProcessRepNo(BigDecimal processRepNo)
    {
	this.processRepNo = processRepNo;
    }

    /**
     * @return the processRepNo
     */
    public BigDecimal getProcessRepNo()
    {
	return processRepNo;
    }

    /**
     * @param openPrintSetup the openPrintSetup to set
     */
    public void setOpenPrintSetup(String openPrintSetup)
    {
	this.openPrintSetup = openPrintSetup;
    }

    /**
     * @return the openPrintSetup
     */
    public String getOpenPrintSetup()
    {
	return openPrintSetup;
    }

    /**
     * @param print the print to set
     */
    public void setPrint(BigDecimal print)
    {
	this.print = print;
    }

    /**
     * @return the print
     */
    public BigDecimal getPrint()
    {
	return print;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg)
    {
	this.msg = msg;
    }

    /**
     * @return the msg
     */
    public String getMsg()
    {
	return msg;
    }

    /**
     * @param stpPurchase the stpPurchase to set
     */
    public void setStpPurchase(String stpPurchase)
    {
	this.stpPurchase = stpPurchase;
    }

    /**
     * @return the stpPurchase
     */
    public String getStpPurchase()
    {
	return stpPurchase;
    }

    public BigDecimal getRequestCy()
    {
        return requestCy;
    }

    public void setRequestCy(BigDecimal requestCy)
    {
        this.requestCy = requestCy;
    }

    /**
     * @return the ctsReqChargesDetVO
     */
    public CTSREQ_CHARGES_DETVO getCtsReqChargesDetVO()
    {
        return ctsReqChargesDetVO;
    }

    /**
     * @param ctsReqChargesDetVO the ctsReqChargesDetVO to set
     */
    public void setCtsReqChargesDetVO(CTSREQ_CHARGES_DETVO ctsReqChargesDetVO)
    {
        this.ctsReqChargesDetVO = ctsReqChargesDetVO;
    }

    public String getTfaStatus()
    {
        return tfaStatus;
    }

    public void setTfaStatus(String tfaStatus)
    {
        this.tfaStatus = tfaStatus;
    }

    public CTS_REQUEST_TYPEVO getRequestTypeVO()
    {
        return requestTypeVO;
    }

    public void setRequestTypeVO(CTS_REQUEST_TYPEVO requestTypeVO)
    {
        this.requestTypeVO = requestTypeVO;
    }

    public String getDocType()
    {
        return docType;
    }

    public void setDocType(String docType)
    {
        this.docType = docType;
    }

    public boolean isScreenProcess()
    {
        return screenProcess;
    }

    public void setScreenProcess(boolean screenProcess)
    {
        this.screenProcess = screenProcess;
    }

    /**
     * @return the ctsRequestVO
     */
    public CTS_REQUESTVOWithBLOBs getCtsRequestVO()
    {
	return ctsRequestVO;
    }

    /**
     * @param ctsRequestVO the ctsRequestVO to set
     */
    public void setCtsRequestVO(CTS_REQUESTVOWithBLOBs ctsRequestVO)
    {
	this.ctsRequestVO = ctsRequestVO;
    }

    public BigDecimal getRequestCif()
    {
        return requestCif;
    }

    public void setRequestCif(BigDecimal requestCif)
    {
        this.requestCif = requestCif;
    }

    public String getCifIdNoStr()
    {
        return cifIdNoStr;
    }

    public void setCifIdNoStr(String cifIdNoStr)
    {
        this.cifIdNoStr = cifIdNoStr;
    }
    
    
}
