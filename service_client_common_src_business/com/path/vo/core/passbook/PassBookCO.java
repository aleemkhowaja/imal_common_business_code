/**
 * 
 */
package com.path.vo.core.passbook;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSPASSBOOK_TYPEVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_PASSBOOKDETVO;
import com.path.dbmaps.vo.CTS_PASSBOOKVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.entitycharges.EntityChargesCO;
import com.path.vo.core.trxmgnt.TrxMgntCO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: hibaoweidat
 * 
 *          PassBookCO.java used to
 */
public class PassBookCO extends RetailBaseVO
{
    

    private CTS_PASSBOOKVO passBookVO = new CTS_PASSBOOKVO() ;
    private CTS_PASSBOOKDETVO passBookDetVO = new CTS_PASSBOOKDETVO();
    private CTSPASSBOOK_TYPEVO passBookTypeVO = new CTSPASSBOOK_TYPEVO();
    private ArrayList<BaseException> listOfWarningMessages = new ArrayList<BaseException>();
    private String type_desc;
    private String cif_desc;
    private String acc_desc;
    private BigDecimal CREDIT;    
    private BigDecimal DEBIT;
    private BigDecimal CONSOLIDATED_SUM;
    private String addGrid;
    private String status_desc;
    private String userName;
    private String cif_address;
    private String id_no;
    private String lostPassbkMsg;
    private String blackListMsg;
    private String cy_name;
    private String ac_type;
    private String cif_status;
    private String CHR_AC_DESC;
    private String branchName;
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO > hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private String isEmptied = "true";
    private EntityChargesCO entityChargesCO = new EntityChargesCO();
    private String preferredLanguage;
    private CURRENCIESVO currency = new CURRENCIESVO();
    private GEN_LEDGERVO genledgerVO = new GEN_LEDGERVO();
    private AMFVO amfVO = new AMFVO();
    private String type;
    private String chargesGridUpdate;
    private BigDecimal oldPbkCode;
    private String deleteMsg;
    private String closeMsg;
    private String userIsBranchManager;
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private String showSendAlert;
    private String isFromAlert;
    private BigDecimal scannedCIFNo;
    private CIFVO cifVO = new CIFVO();
    private List<String> listWarningMsg = new ArrayList<String>();
    private BigDecimal errCode;
    private BigDecimal consolidate;
    private BigDecimal maxlinebypage;
    private BigDecimal maxline;
    private BigDecimal maxpage;
    private String errMsg;
    private BigDecimal minline;
    private BigDecimal linesToPrint;
    private ArrayList<SmartCO> smartCOList;  
    private String confirmMsg;
    private Integer msgCode;
    private BigDecimal trsNo;
    private String isWaived;
    private TrxMgntCO trxMgntCO;
    private BigDecimal DECIMAL_FORMAT;
    private String flag;
    private String accountFromLookUp;
    private BigDecimal pagesNumber;
    private BigDecimal vaultNo;
    private boolean fromSave;				//To know if called from save so that certain functionalities dont run
    
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
    
    /*
     * jihane TP82894 - IIAB080110 ; TP82682 ABARI11065 added to store sum of dues amount 
     */
    private String logDuesCreateTrx ;
    
    private BigDecimal lockId;//US 154817 
    private String accForLockExists;//US 154817 return true in case the procedure P_RET_LOCK_UNLOCK_SAFE_ACC return accounts to be locked
    private String signatureAccepted;
    private String allowCifCreationMaskYN;
    private String screenSrc;
    
    //Habib Baalbaki accocunt restriction 372747
    private String errType;
    private BigDecimal rtrnVal;
    private boolean checkNbRec;
    private String currAppName;
    private String pageRef;
    private int trxMgntNbRecords;
    private List<AMFVO> accountListRecords = new ArrayList<>();
    private BigDecimal chargesAmount;
    private ReportResponseCO reportResponseCO = new ReportResponseCO();
    private CTSCONTROLVO ctsControl = new CTSCONTROLVO();
    
    //Rakan Makarem - AMANAUPG170247
    private String reportDefaultFormat;
    
    private boolean yesNoConfirmation = true;
    private String disableWaive;
    
    
    
    public String getSignatureAccepted()
    {
        return signatureAccepted;
    }

    public void setSignatureAccepted(String signatureAccepted)
    {
        this.signatureAccepted = signatureAccepted;
    }

    public BigDecimal getPagesNumber()
    {
        return pagesNumber;
    }

    public void setPagesNumber(BigDecimal pagesNumber)
    {
        this.pagesNumber = pagesNumber;
    }

    public String getFlag()
    {
        return flag;
    }

    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    public BigDecimal getDECIMAL_FORMAT()
    {
        return DECIMAL_FORMAT;
    }

    public void setDECIMAL_FORMAT(BigDecimal dECIMALFORMAT)
    {
        DECIMAL_FORMAT = dECIMALFORMAT;
    }

    public String getIsWaived()
    {
        return isWaived;
    }

    public void setIsWaived(String isWaived)
    {
        this.isWaived = isWaived;
    }

    public String getConfirmMsg()
    {
        return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg)
    {
        this.confirmMsg = confirmMsg;
    }

    public BigDecimal getLinesToPrint()
    {
        return linesToPrint;
    }

    public void setLinesToPrint(BigDecimal linesToPrint)
    {
        this.linesToPrint = linesToPrint;
    }

    public BigDecimal getMaxlinebypage()
    {
        return maxlinebypage;
    }

    public void setMaxlinebypage(BigDecimal maxlinebypage)
    {
        this.maxlinebypage = maxlinebypage;
    }

    public BigDecimal getMinline()
    {
        return minline;
    }

    public void setMinline(BigDecimal minline)
    {
        this.minline = minline;
    }

    public BigDecimal getMaxline()
    {
        return maxline;
    }

    public void setMaxline(BigDecimal maxline)
    {
        this.maxline = maxline;
    }

    public BigDecimal getMaxpage()
    {
        return maxpage;
    }

    public void setMaxpage(BigDecimal maxpage)
    {
        this.maxpage = maxpage;
    }

    public BigDecimal getConsolidate()
    {
        return consolidate;
    }

    public void setConsolidate(BigDecimal consolidate)
    {
        this.consolidate = consolidate;
    }

    public String getErrMsg()
    {
        return errMsg;
    }

    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }

    public BigDecimal getErrCode()
    {
        return errCode;
    }

    public void setErrCode(BigDecimal errCode)
    {
        this.errCode = errCode;
    }

    public CIFVO getCifVO()
    {
        return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }

    public BigDecimal getScannedCIFNo()
    {
        return scannedCIFNo;
    }

    public void setScannedCIFNo(BigDecimal scannedCIFNo)
    {
        this.scannedCIFNo = scannedCIFNo;
    }

    public String getIsFromAlert()
    {
        return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
        this.isFromAlert = isFromAlert;
    }

    public String getShowSendAlert()
    {
        return showSendAlert;
    }

    public void setShowSendAlert(String showSendAlert)
    {
        this.showSendAlert = showSendAlert;
    }

    public AlertsParamCO getAlertsParamCO()
    {
        return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
        this.alertsParamCO = alertsParamCO;
    }

    public String getUserIsBranchManager()
    {
        return userIsBranchManager;
    }

    public void setUserIsBranchManager(String userIsBranchManager)
    {
        this.userIsBranchManager = userIsBranchManager;
    }

    public String getCloseMsg()
    {
        return closeMsg;
    }

    public void setCloseMsg(String closeMsg)
    {
        this.closeMsg = closeMsg;
    }

    public String getDeleteMsg()
    {
        return deleteMsg;
    }

    public void setDeleteMsg(String deleteMsg)
    {
        this.deleteMsg = deleteMsg;
    }

    public BigDecimal getOldPbkCode()
    {
        return oldPbkCode;
    }

    public void setOldPbkCode(BigDecimal oldPbkCode)
    {
        this.oldPbkCode = oldPbkCode;
    }

    public AMFVO getAmfVO()
    {
        return amfVO;
    }

    public void setAmfVO(AMFVO amfVO)
    {
        this.amfVO = amfVO;
    }

    public GEN_LEDGERVO getGenledgerVO()
    {
        return genledgerVO;
    }

    public void setGenledgerVO(GEN_LEDGERVO genledgerVO)
    {
        this.genledgerVO = genledgerVO;
    }

    public CTS_PASSBOOKVO getPassBookVO()
    {
        return passBookVO;
    }

    public void setPassBookVO(CTS_PASSBOOKVO passBookVO)
    {
        this.passBookVO = passBookVO;
    }

    public String getType_desc()
    {
        return type_desc;
    }

    public void setType_desc(String typeDesc)
    {
        type_desc = typeDesc;
    }

    public String getCif_desc()
    {
        return cif_desc;
    }

    public void setCif_desc(String cifDesc)
    {
        cif_desc = cifDesc;
    }

    public String getAcc_desc()
    {
        return acc_desc;
    }

    public void setAcc_desc(String accDesc)
    {
        acc_desc = accDesc;
    }

    public CTSPASSBOOK_TYPEVO getPassBookTypeVO()
    {
        return passBookTypeVO;
    }

    public void setPassBookTypeVO(CTSPASSBOOK_TYPEVO passBookTypeVO)
    {
        this.passBookTypeVO = passBookTypeVO;
    }

    public CTS_PASSBOOKDETVO getPassBookDetVO()
    {
        return passBookDetVO;
    }

    public void setPassBookDetVO(CTS_PASSBOOKDETVO passBookDetVO)
    {
        this.passBookDetVO = passBookDetVO;
    }

    public BigDecimal getCREDIT()
    {
        return CREDIT;
    }

    public void setCREDIT(BigDecimal cREDIT)
    {
        CREDIT = cREDIT;
    }

    public BigDecimal getDEBIT()
    {
        return DEBIT;
    }

    public void setDEBIT(BigDecimal dEBIT)
    {
        DEBIT = dEBIT;
    }

    public BigDecimal getCONSOLIDATED_SUM()
    {
        return CONSOLIDATED_SUM;
    }

    public void setCONSOLIDATED_SUM(BigDecimal cONSOLIDATEDSUM)
    {
        CONSOLIDATED_SUM = cONSOLIDATEDSUM;
    }

    public String getAddGrid()
    {
        return addGrid;
    }

    public void setAddGrid(String addGrid)
    {
        this.addGrid = addGrid;
    }

    public String getStatus_desc()
    {
        return status_desc;
    }

    public void setStatus_desc(String statusDesc)
    {
        status_desc = statusDesc;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getCif_address()
    {
        return cif_address;
    }

    public void setCif_address(String cifAddress)
    {
        cif_address = cifAddress;
    }

    public String getId_no()
    {
        return id_no;
    }

    public void setId_no(String idNo)
    {
        id_no = idNo;
    }

    public String getLostPassbkMsg()
    {
        return lostPassbkMsg;
    }

    public void setLostPassbkMsg(String lostPassbkMsg)
    {
        this.lostPassbkMsg = lostPassbkMsg;
    }

    public String getBlackListMsg()
    {
        return blackListMsg;
    }

    public void setBlackListMsg(String blackListMsg)
    {
        this.blackListMsg = blackListMsg;
    }

    public String getCy_name()
    {
        return cy_name;
    }

    public void setCy_name(String cyName)
    {
        cy_name = cyName;
    }

    public String getAc_type()
    {
        return ac_type;
    }

    public void setAc_type(String acType)
    {
        ac_type = acType;
    }

    public String getCif_status()
    {
        return cif_status;
    }

    public void setCif_status(String cifStatus)
    {
        cif_status = cifStatus;
    }

    public ArrayList<BaseException> getListOfWarningMessages()
    {
        return listOfWarningMessages;
    }

    public void setListOfWarningMessages(ArrayList<BaseException> listOfWarningMessages)
    {
        this.listOfWarningMessages = listOfWarningMessages;
    }

    public String getCHR_AC_DESC()
    {
        return CHR_AC_DESC;
    }

    public void setCHR_AC_DESC(String cHRACDESC)
    {
        CHR_AC_DESC = cHRACDESC;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }

    public String getIsEmptied()
    {
        return isEmptied;
    }

    public void setIsEmptied(String isEmptied)
    {
        this.isEmptied = isEmptied;
    }

    public EntityChargesCO getEntityChargesCO()
    {
        return entityChargesCO;
    }

    public void setEntityChargesCO(EntityChargesCO entityChargesCO)
    {
        this.entityChargesCO = entityChargesCO;
    }

    public String getBranchName()
    {
        return branchName;
    }

    public void setBranchName(String branchName)
    {
        this.branchName = branchName;
    }

    public String getPreferredLanguage()
    {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
        this.preferredLanguage = preferredLanguage;
    }

    public CURRENCIESVO getCurrency()
    {
        return currency;
    }

    public void setCurrency(CURRENCIESVO currency)
    {
        this.currency = currency;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getChargesGridUpdate()
    {
        return chargesGridUpdate;
    }

    public void setChargesGridUpdate(String chargesGridUpdate)
    {
        this.chargesGridUpdate = chargesGridUpdate;
    }

    public List<String> getListWarningMsg()
    {
        return listWarningMsg;
    }

    public void setListWarningMsg(List<String> listWarningMsg)
    {
        this.listWarningMsg = listWarningMsg;
    }

    public void setSmartCOList(ArrayList<SmartCO> smartCOList)
    {
	this.smartCOList = smartCOList;
    }

    public ArrayList<SmartCO> getSmartCOList()
    {
	return smartCOList;
    }

    public Integer getMsgCode()
    {
        return msgCode;
    }

    public void setMsgCode(Integer msgCode)
    {
        this.msgCode = msgCode;
    }

    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public TrxMgntCO getTrxMgntCO()
    {
        return trxMgntCO;
    }

    public void setTrxMgntCO(TrxMgntCO trxMgntCO)
    {
        this.trxMgntCO = trxMgntCO;
    }

    public BigDecimal getVaultNo()
    {
	return vaultNo;
    }

    public void setVaultNo(BigDecimal vaultNo)
    {
	this.vaultNo = vaultNo;
    }

    public String getAccountFromLookUp()
    {
	return accountFromLookUp;
    }

    public void setAccountFromLookUp(String accountFromLookUp)
    {
	this.accountFromLookUp = accountFromLookUp;
    }

    public String getLogDuesCreateTrx()
    {
	return logDuesCreateTrx;
    }

    public void setLogDuesCreateTrx(String logDuesCreateTrx)
    {
	this.logDuesCreateTrx = logDuesCreateTrx;
    }

    public boolean isFromSave()
    {
	return fromSave;
    }

    public void setFromSave(boolean fromSave)
    {
	this.fromSave = fromSave;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public CTSCONTROLVO getCtsControlVO()
    {
	return ctsControlVO;
    }

    public void setCtsControlVO(CTSCONTROLVO ctsControlVO)
    {
	this.ctsControlVO = ctsControlVO;
    }

    public BigDecimal getLockId()
    {
	return lockId;
    }

    public void setLockId(BigDecimal lockId)
    {
	this.lockId = lockId;
    }

    public String getAccForLockExists()
    {
	return accForLockExists;
    }

    public void setAccForLockExists(String accForLockExists)
    {
	this.accForLockExists = accForLockExists;
    }

    public String getAllowCifCreationMaskYN()
    {
	return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
	this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    public String getScreenSrc()
    {
	return screenSrc;
    }

    public void setScreenSrc(String screenSrc)
    {
	this.screenSrc = screenSrc;
    }

    public CTSCONTROLVO getCtsControl()
    {
	return ctsControl;
    }

    public void setCtsControl(CTSCONTROLVO ctsControl)
    {
	this.ctsControl = ctsControl;
    }

    public String getReportDefaultFormat()
    {
	return reportDefaultFormat;
    }

    public void setReportDefaultFormat(String reportDefaultFormat)
    {
	this.reportDefaultFormat = reportDefaultFormat;
    }

    public boolean isYesNoConfirmation()
    {
	return yesNoConfirmation;
    }

    public void setYesNoConfirmation(boolean yesNoConfirmation)
    {
	this.yesNoConfirmation = yesNoConfirmation;
    }

    public String getErrType()
    {
	return errType;
    }

    public void setErrType(String errType)
    {
	this.errType = errType;
    }

    public BigDecimal getRtrnVal()
    {
	return rtrnVal;
    }

    public void setRtrnVal(BigDecimal rtrnVal)
    {
	this.rtrnVal = rtrnVal;
    }

    public boolean isCheckNbRec()
    {
	return checkNbRec;
    }

    public void setCheckNbRec(boolean checkNbRec)
    {
	this.checkNbRec = checkNbRec;
    }

    public String getCurrAppName()
    {
	return currAppName;
    }

    public void setCurrAppName(String currAppName)
    {
	this.currAppName = currAppName;
    }

    public String getPageRef()
    {
	return pageRef;
    }

    public void setPageRef(String pageRef)
    {
	this.pageRef = pageRef;
    }

    public int getTrxMgntNbRecords()
    {
	return trxMgntNbRecords;
    }

    public void setTrxMgntNbRecords(int trxMgntNbRecords)
    {
	this.trxMgntNbRecords = trxMgntNbRecords;
    }

    public List<AMFVO> getAccountListRecords()
    {
	return accountListRecords;
    }

    public void setAccountListRecords(List<AMFVO> accountListRecords)
    {
	this.accountListRecords = accountListRecords;
    }

    public BigDecimal getChargesAmount()
    {
	return chargesAmount;
    }

    public void setChargesAmount(BigDecimal chargesAmount)
    {
	this.chargesAmount = chargesAmount;
    }

    public void setReportResponseCO(ReportResponseCO reportResponseCO)
    {
	this.reportResponseCO = reportResponseCO;
    }

    public ReportResponseCO getReportResponseCO()
    {
	return reportResponseCO;
    }

    public String getDisableWaive()
    {
	return disableWaive;
    }

    public void setDisableWaive(String disableWaive)
    {
	this.disableWaive = disableWaive;
    }
}
