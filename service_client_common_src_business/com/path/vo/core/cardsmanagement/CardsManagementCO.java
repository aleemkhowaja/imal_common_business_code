/**
 * @Auther:WissamAbouJaoude
 * @Date:March 16, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.core.cardsmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.dbmaps.vo.CTSCARDS_ACCVO;
import com.path.dbmaps.vo.CTSCARDS_MGTVO;
import com.path.dbmaps.vo.CTSCARDS_MGT_NOVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERCARDLIMITVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_AVA_BENEFICIARIESVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.FMSCREDITCARD_DETAILSVO;
import com.path.dbmaps.vo.FMSFACILITYDETVO;
import com.path.dbmaps.vo.FMSFACILITYVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.additionalfield.AdditionalFieldsByTypeCO;
import com.path.vo.common.dynfiles.DynFilesCO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.cardreader.CardReaderCO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.entitycharges.EntityChargesCO;
import com.path.vo.core.reports.ReportsCO;
import com.path.vo.core.trxmgnt.TrxMgntCO;

public class CardsManagementCO extends RetailBaseVO
{
    private FMSCREDITCARD_DETAILSVO fmsCreditCardDetailsVO = new FMSCREDITCARD_DETAILSVO();
    private FMSFACILITYDETVO fmsFacilityDetVO = new FMSFACILITYDETVO();
    private CIF_ADDRESSVO cifAddress = new CIF_ADDRESSVO();
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private CTSCARDS_MGTVO cardsMgtVO = new CTSCARDS_MGTVO();
    private CTSCARDS_MGTVO originCardsMgtVO = new CTSCARDS_MGTVO();
    private BRANCHESVO branchesVO = new BRANCHESVO();
    private AMFVO amfVO = new AMFVO();
    private CURRENCIESVO currencyVO = new CURRENCIESVO();
    private GEN_LEDGERVO genLedgerVO = new GEN_LEDGERVO();
    private CIFVO cifVO = new CIFVO();
    private RIFCTTVO rifcttVO = new RIFCTTVO();
    private CardsAccountCO cardsAccountCO = new CardsAccountCO();
    private CTS_AVA_BENEFICIARIESVO beneficirayVO = new CTS_AVA_BENEFICIARIESVO();
    private CTSCARDS_MGT_NOVO ctsCardsMgtNOVO = new CTSCARDS_MGT_NOVO();
    private CTSCARDS_ACCVO cardAccountVO = new CTSCARDS_ACCVO();
    private CTSTELLERCARDLIMITVO ctsTellerCardLimit = new CTSTELLERCARDLIMITVO();
    private String accountDetails;
    private String printConfirmationMessage;
    private ReportResponseCO reportResponseCO = new ReportResponseCO();
    private List<ReportResponseCO> reportResponseCOList = new ArrayList<ReportResponseCO>();
    private List<CardsAccountCO> lstAllAccountDetailsRec = new ArrayList<CardsAccountCO>();
    private List<CardsManagementCO> lstAllCardsMgtRec = new ArrayList<CardsManagementCO>();
    private byte[] scriptByte;
    private CTSCARDSVO ctsCardsVO = new CTSCARDSVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
    private CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
    private DynFilesCO dynFilesCO = new DynFilesCO();
    private EntityChargesCO entityChargesCO = new EntityChargesCO();
    private FMSFACILITYVO fmsFacilityVO = new FMSFACILITYVO();
    private String physical_status;
    private String cardNo;
    private String isEmptied = "true";
    private String record_status;
    private String screenSrc;
    private String userIsBranchManager;
    private String saveUpdateFlag;
    private String isHiddenChargeDiv;
    private String isFromAlert;
    private String channelId;
    private String allowExceptions;
    private String oldReason;
    private String eventList;
    private String alertApprove;
    private String oldCifReason;
    private String action;
    private String linkOpened;
    private String xmlData;
    private String allowCountCards;
    private String colName;
    private String confirmMsg;
    private Integer msgCode;
    private String warningMsg;
    private String prepaid;
    private String avaCard;
    private String benefName;
    private String eventId;
    private String maskedCardNo;
    private String maskedParentCardNo;
    private String periodId;
    private String allowCreditReport;
    private String allowDebitReport;
    private Date fromDate;
    private Date dateTo;
    private String isWaived;
    private String waiveIncluding;
    private String auto_create_acc;
    private String createdFrom;
    private String enableCardHolderTab;
    private String cardTypeDesc;
    private String cifDesc;
    private String destBranchDesc;
    private String lienInfoDesc;
    private String idTypeDesc;
    private String nationalityDesc;
    private String occupPositionDesc;
    private String deptDesc;
    private String educLevelDesc;
    private String creditTypeDesc;
    private String divisionDesc;
    private String mailingRegionDesc;
    private String mailingBoxDesc;
    private String mailingCountryDesc;
    private BigDecimal countryCode;
    private BigDecimal atmSpentCv;
    private BigDecimal atmSpentFc;
    private BigDecimal scannedCIFNo;
    private BigDecimal argumentId;
    private BigDecimal reportId;
    private BigDecimal returnAcc;
    private BigDecimal returnActiveCard;
    private BigDecimal posSpentCv;
    private BigDecimal posSpentFc;
    private BigDecimal records_nb;
    private BigDecimal errorCode;
    private String errorMessage;
    private String cifHolderDesc;
    private String applyReasonDesc;
    private String reasonReadOnly;
    private String cardsAccDetGridUpdates;
    private String cardsChargesGridUpdate;
    private String process;
    private String progRef;
    private String holdOfRenewal;
    private String primKey;
    private String successMsg;
    private BigDecimal percentage;
    private BigDecimal sumLimitAmnt;
    private BigDecimal sumAccPosLimit;
    private BigDecimal baseCurrDecPoint;
    private String limitType;
    private String card_desc;
    private String drCrType;
    private String cardType;
    private String maxOrMin;
    private String limit_checking_by;
    private String purchaserIDTypeName;
    private String receiverIDTypeName;
    private Boolean freeCardFlag;
    private String dependencyCallSource;
    private String preferredLanguage;
    private String reasonUsedFor;
    private String statusReason;
    private String statusAction;
    private String statusReasonAction;
    private String type;
    private String cardDesignDesc;
    private String cardMessageDesc;
    private String statusReasonDesc;
    private String accName;
    private BigDecimal protectFlag;
    private String ivcrud;
    private Boolean tabsInformationVisible = true;
    private Boolean tabsCardPaymentVisible = true;
    private Boolean tabsAccountDetailsVisible = true;
    private Boolean tabsAccountDetailsReadOnly = false;
    private Boolean tabsCardHolderInfoVisible = true;
    private Boolean mainDetailsCardLimitSectionVisible = true;
    private Boolean mainDetailsMaxBalSectionVisible = true;
    private Boolean mainDetailsFacilityDataSectionVisible = false;
    // For check Box on screen
    private Boolean noLiabilityFlag;
    private Boolean holdForRenewalFlag;
    private Boolean clNetCheckedFlag;
    private Boolean deleteAccountsGridData;
    private Boolean allowAccess;
    private Boolean confirmFlag;
    private String exceptFlag;
    private String sameType;
    private String userName;
    private String accCyReadOnly;
    private String accPosBasedOnReadOnly;
    private String accPosPeriodicityOnReadOnly;
    private String limitBasedOnReadOnly;
    private String limitCheckPeriodReadOnly;
    private String confirmResp;
    private String originCardNo;
    private String newCardNo;
    private String selectedCard;
    private BigDecimal originAppId;
    private BigDecimal originAppRef;
    private BigDecimal newAppId;
    private BigDecimal newAppRef;
    private String[] infoMsgParam;
    private String atmCardLimit;
    private String stringColumn;
    private String dateColumn;
    private String flag;
    private String batchFlag;
    private BigDecimal trx_code;
    private String trx_desc;
    private Boolean _accBtnFlag = true;
    private BigDecimal allowAddAccToAccGrid;
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private String showSendAlert;
    private String cardScreenTitle;
    // For Cards Grid in Issue,Reissue etc
    private Integer creditCount = 0;
    private Integer debitCount = 0;
    private List<String> listWarningMsg = new ArrayList<String>();
    private String showMemoOnLoad;
    // SMART list
    private ArrayList<SmartCO> smartCOList;

    private TrxMgntCO trxMgntCO = new TrxMgntCO();

    // Store original cardNo for using as parameter in Card History screen(The
    // card_no can be null or "" but screen will return only "")
    private String origCardNo;
    private String viewSign;
    private BigDecimal trsNo;
    private BigDecimal cifBranch;
    private String cifVisibility;
    private BigDecimal benefCode;
    private String benefDesc;
    private BigDecimal fileCode;
    //BMOI130009 card reader
    private CardReaderCO cardReaderCO = new CardReaderCO();
    private String returnedError;
    /*
     * jihane TP82894 - IIAB080110 ; TP82682 ABARI11065 added to store sum of dues amount 
     */
    private String logDuesCreateTrx;
    
    private BigDecimal lockId;//US 154817 
    private String accForLockExists;//US 154817 return true in case the procedure P_RET_LOCK_UNLOCK_SAFE_ACC return accounts to be locked
    
    private boolean suppressMessage;		//Used to stop Exceptions from being thrown
    
    private String idTypeBenefDesc;
    private String occupationBenefDesc;
    private String occupPositionBenefDesc;
    private String statusBenefDesc;
    //Bug # 378565 --[John Massaad]
    private String replaceReissue;
    
    private String confirmMgnt;
    private String continueProcess;
    
  //Bug # 378565 --[John Massaad]
    
    private BigDecimal chargeSchema;
    private BigDecimal trxType;
   // private String limCheckBy;//BMOI140007
    private BigDecimal ldecAmount;//BMOI140007
    private String mobile;//BMOI140007    
  //  private BigDecimal code; //BMOI140007 
    private BigDecimal wdMinLimitAmount;//BMOI140007 
    private BigDecimal wdLimitAmount;//BMOI140007 
    private BigDecimal posMinLimitAmount;//BMOI140007 
    private BigDecimal postLimitAmount;//BMOI140007
    

    private String cardProductDesc;
    private BigDecimal cifNO;//BMOI150250    
    private String UPDATE_SUB_STATUS; //BMOI150250    
    
    private String pin_status_desc; //BMOI140021
    private String yesNo; //BMOIO140021
    
    private BigDecimal totalCVCharges;
    private boolean considerCharges;
    private BigDecimal previousValue;
    private String cardReaderCivilID; //BMOI130009 
    private String cardReaderCardSerial;
    
    //Hasan BMO160011 23/01/2016
    private BigDecimal blackListReason;
    private String blackListReasonDesc;
    private String methodName;
    private String parentRef;
    private String autoCreation;
    private String restrictFactor;
    private BigDecimal blackListReturnedValue;
    private String statusDesc;
    private String pinStatus;
    private BigDecimal facilityNo;    
    private String allowCifCreationMaskYN;
    
    // added by nancy - 19/12/2017
    private String properties;
    // end nancy

    private String pinTypeDesc;
    // Additional Fields by Type isLoaded flag // DASI170129
    private List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList = new ArrayList<AdditionalFieldsByTypeCO>();
    
    private String fromGenNewCard;
    private List<CardsMgmtGuarantorDetailsCO> lstAllCardsGuarantorDet = new ArrayList<CardsMgmtGuarantorDetailsCO>();
    private String cardsGuarantorDetails;
    
    private boolean openSignature = false;
    //added by abbas for Bug#683186
    private String fromStatusReasonLookUp;
    
    
    //795158 BB-S10 Activating other branch cards[falha]
    private String STATUS_REASON;

    private boolean calledFromBulkActivate;
    private BigDecimal fromBranch;
    private BigDecimal toBranch;
    private BigDecimal fromApplicationId;
    private BigDecimal toApplicationId;
    private String fromCardNo;
    private String toCardNo;
    //795158 BB-S10 Activating other branch cards[falha]
    private BigDecimal cardChargeAmount;
    
    //Hala Al Sheikh - ABEI180106
    private List<CardsCollateralsCO> cardsCollateralsCOs = new ArrayList<CardsCollateralsCO>();
    private CardsCollateralsCO cardsCollateralsCO;
    private String collateralUpdates;
    private String isHiddenFacilityDiv;
    private BigDecimal facilityValue;
    private BigDecimal facilityCode;
    private BigDecimal facilityBranch;
    private BigDecimal facilitySubLimit;
    private String facilityBranchDesc;
    
    private List<ReportsCO> reportsList;
    
    

    
    private String cifAdressHomeTel;
    private String cifAdressMobile;
    private String cifAdressWorkTel;
    private String civilCodeBriefDescEng;
    private BigDecimal cardAtmAvailable;
    private BigDecimal cardPosAvailable;
    
    
    //maria for BMO180074
    private String errorType;
    
    private String disableWaive;
    

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    
    public BigDecimal getCifBranch()
    {
        return cifBranch;
    }

    public void setCifBranch(BigDecimal cifBranch)
    {
        this.cifBranch = cifBranch;
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

    public CTSCARDS_MGTVO getCardsMgtVO()
    {
	return cardsMgtVO;
    }

    public void setCardsMgtVO(CTSCARDS_MGTVO cardsMgtVO)
    {
	this.cardsMgtVO = cardsMgtVO;
    }

    public BRANCHESVO getBranchesVO()
    {
	return branchesVO;
    }

    public void setBranchesVO(BRANCHESVO branchesVO)
    {
	this.branchesVO = branchesVO;
    }

    public AMFVO getAmfVO()
    {
	return amfVO;
    }

    public void setAmfVO(AMFVO amfVO)
    {
	this.amfVO = amfVO;
    }

    public CIFVO getCifVO()
    {
	return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
	this.cifVO = cifVO;
    }

    public CardsAccountCO getCardsAccountCO()
    {
	return cardsAccountCO;
    }

    public void setCardsAccountCO(CardsAccountCO cardsAccountCO)
    {
	this.cardsAccountCO = cardsAccountCO;
    }

    public CTSCARDSVO getCtsCardsVO()
    {
	return ctsCardsVO;
    }

    public void setCtsCardsVO(CTSCARDSVO ctsCardsVO)
    {
	this.ctsCardsVO = ctsCardsVO;
    }

    public String getCardTypeDesc()
    {
	return cardTypeDesc;
    }

    public void setCardTypeDesc(String cardTypeDesc)
    {
	this.cardTypeDesc = cardTypeDesc;
    }

    public String getCifDesc()
    {
	return cifDesc;
    }

    public void setCifDesc(String cifDesc)
    {
	this.cifDesc = cifDesc;
    }

    public String getDestBranchDesc()
    {
	return destBranchDesc;
    }

    public void setDestBranchDesc(String destBranchDesc)
    {
	this.destBranchDesc = destBranchDesc;
    }

    public String getLienInfoDesc()
    {
	return lienInfoDesc;
    }

    public void setLienInfoDesc(String lienInfoDesc)
    {
	this.lienInfoDesc = lienInfoDesc;
    }

    public String getIdTypeDesc()
    {
	return idTypeDesc;
    }

    public void setIdTypeDesc(String idTypeDesc)
    {
	this.idTypeDesc = idTypeDesc;
    }

    public String getNationalityDesc()
    {
	return nationalityDesc;
    }

    public void setNationalityDesc(String nationalityDesc)
    {
	this.nationalityDesc = nationalityDesc;
    }

    public String getOccupPositionDesc()
    {
	return occupPositionDesc;
    }

    public void setOccupPositionDesc(String occupPositionDesc)
    {
	this.occupPositionDesc = occupPositionDesc;
    }

    public String getDeptDesc()
    {
	return deptDesc;
    }

    public void setDeptDesc(String deptDesc)
    {
	this.deptDesc = deptDesc;
    }

    public String getEducLevelDesc()
    {
	return educLevelDesc;
    }

    public void setEducLevelDesc(String educLevelDesc)
    {
	this.educLevelDesc = educLevelDesc;
    }

    public String getCreditTypeDesc()
    {
	return creditTypeDesc;
    }

    public void setCreditTypeDesc(String creditTypeDesc)
    {
	this.creditTypeDesc = creditTypeDesc;
    }

    public String getDivisionDesc()
    {
	return divisionDesc;
    }

    public void setDivisionDesc(String divisionDesc)
    {
	this.divisionDesc = divisionDesc;
    }

    public String getMailingRegionDesc()
    {
	return mailingRegionDesc;
    }

    public void setMailingRegionDesc(String mailingRegionDesc)
    {
	this.mailingRegionDesc = mailingRegionDesc;
    }

    public String getCifHolderDesc()
    {
	return cifHolderDesc;
    }

    public void setCifHolderDesc(String cifHolderDesc)
    {
	this.cifHolderDesc = cifHolderDesc;
    }

    public String getApplyReasonDesc()
    {
	return applyReasonDesc;
    }

    public void setApplyReasonDesc(String applyReasonDesc)
    {
	this.applyReasonDesc = applyReasonDesc;
    }

    public String getPrepaid()
    {
	return prepaid;
    }

    public void setPrepaid(String prepaid)
    {
	this.prepaid = prepaid;
    }

    public String getProcess()
    {
	return process;
    }

    public void setProcess(String process)
    {
	this.process = process;
    }

    public String getHoldOfRenewal()
    {
	return holdOfRenewal;
    }

    public void setHoldOfRenewal(String holdOfRenewal)
    {
	this.holdOfRenewal = holdOfRenewal;
    }

    public BigDecimal getPercentage()
    {
	return percentage;
    }

    public void setPercentage(BigDecimal percentage)
    {
	this.percentage = percentage;
    }

    public String getCard_desc()
    {
	return card_desc;
    }

    public void setCard_desc(String cardDesc)
    {
	card_desc = cardDesc;
    }

    public String getDrCrType()
    {
	return drCrType;
    }

    public void setDrCrType(String drCrType)
    {
	this.drCrType = drCrType;
    }

    public String getCardType()
    {
	return cardType;
    }

    public void setCardType(String cardType)
    {
	this.cardType = cardType;
    }

    public String getAuto_create_acc()
    {
	return auto_create_acc;
    }

    public void setAuto_create_acc(String autoCreateAcc)
    {
	auto_create_acc = autoCreateAcc;
    }

    public String getLimit_checking_by()
    {
	return limit_checking_by;
    }

    public void setLimit_checking_by(String limit_checking_by)
    {
	this.limit_checking_by = limit_checking_by;
    }

    public String getMailingCountryDesc()
    {
	return mailingCountryDesc;
    }

    public void setMailingCountryDesc(String mailingCountryDesc)
    {
	this.mailingCountryDesc = mailingCountryDesc;
    }

    public String getPurchaserIDTypeName()
    {
	return purchaserIDTypeName;
    }

    public void setPurchaserIDTypeName(String purchaserIDTypeName)
    {
	this.purchaserIDTypeName = purchaserIDTypeName;
    }

    public String getReceiverIDTypeName()
    {
	return receiverIDTypeName;
    }

    public void setReceiverIDTypeName(String receiverIDTypeName)
    {
	this.receiverIDTypeName = receiverIDTypeName;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
	return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
	this.hm = hm;
    }

    public Boolean getFreeCardFlag()
    {
	return freeCardFlag;
    }

    public void setFreeCardFlag(Boolean freeCardFlag)
    {
	this.freeCardFlag = freeCardFlag;
    }

    public String getPreferredLanguage()
    {
	return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
	this.preferredLanguage = preferredLanguage;
    }

    public String getDependencyCallSource()
    {
	return dependencyCallSource;
    }

    public void setDependencyCallSource(String dependencyCallSource)
    {
	this.dependencyCallSource = dependencyCallSource;
    }

    public CTSCARDS_MGT_NOVO getCtsCardsMgtNOVO()
    {
	return ctsCardsMgtNOVO;
    }

    public void setCtsCardsMgtNOVO(CTSCARDS_MGT_NOVO ctsCardsMgtNOVO)
    {
	this.ctsCardsMgtNOVO = ctsCardsMgtNOVO;
    }

    public CTSCARDS_ACCVO getCardAccountVO()
    {
	return cardAccountVO;
    }

    public void setCardAccountVO(CTSCARDS_ACCVO cardAccountVO)
    {
	this.cardAccountVO = cardAccountVO;
    }

    public String getAccountDetails()
    {
	return accountDetails;
    }

    public void setAccountDetails(String accountDetails)
    {
	this.accountDetails = accountDetails;
    }

    public List<CardsAccountCO> getLstAllAccountDetailsRec()
    {
	return lstAllAccountDetailsRec;
    }

    public void setLstAllAccountDetailsRec(List<CardsAccountCO> lstAllAccountDetailsRec)
    {
	this.lstAllAccountDetailsRec = lstAllAccountDetailsRec;
    }

    public RIFCTTVO getRifcttVO()
    {
	return rifcttVO;
    }

    public void setRifcttVO(RIFCTTVO rifcttVO)
    {
	this.rifcttVO = rifcttVO;
    }

    public String getAction()
    {
	return action;
    }

    public void setAction(String action)
    {
	this.action = action;
    }

    public String getLinkOpened()
    {
	return linkOpened;
    }

    public void setLinkOpened(String linkOpened)
    {
	this.linkOpened = linkOpened;
    }

    public String getConfirmMsg()
    {
	return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg)
    {
	this.confirmMsg = confirmMsg;
    }

    public String getWarningMsg()
    {
	return warningMsg;
    }

    public void setWarningMsg(String warningMsg)
    {
	this.warningMsg = warningMsg;
    }

    public BigDecimal getSumLimitAmnt()
    {
	return sumLimitAmnt;
    }

    public void setSumLimitAmnt(BigDecimal sumLimitAmnt)
    {
	this.sumLimitAmnt = sumLimitAmnt;
    }

    public BigDecimal getSumAccPosLimit()
    {
	return sumAccPosLimit;
    }

    public void setSumAccPosLimit(BigDecimal sumAccPosLimit)
    {
	this.sumAccPosLimit = sumAccPosLimit;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public CTSTELLERCARDLIMITVO getCtsTellerCardLimit()
    {
	return ctsTellerCardLimit;
    }

    public void setCtsTellerCardLimit(CTSTELLERCARDLIMITVO ctsTellerCardLimit)
    {
	this.ctsTellerCardLimit = ctsTellerCardLimit;
    }

    @Override
    public BigDecimal getBaseCurrDecPoint()
    {
	return baseCurrDecPoint;
    }

    @Override
    public void setBaseCurrDecPoint(BigDecimal baseCurrDecPoint)
    {
	this.baseCurrDecPoint = baseCurrDecPoint;
    }

    public String getMaxOrMin()
    {
	return maxOrMin;
    }

    public void setMaxOrMin(String maxOrMin)
    {
	this.maxOrMin = maxOrMin;
    }

    public String getReasonUsedFor()
    {
	return reasonUsedFor;
    }

    public void setReasonUsedFor(String reasonUsedFor)
    {
	this.reasonUsedFor = reasonUsedFor;
    }

    public String getStatusReason()
    {
	return statusReason;
    }

    public void setStatusReason(String statusReason)
    {
	this.statusReason = statusReason;
    }

    public String getStatusAction()
    {
	return statusAction;
    }

    public void setStatusAction(String statusAction)
    {
	this.statusAction = statusAction;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public CTSCONTROLVO getCtsControlVO()
    {
	return ctsControlVO;
    }

    public void setCtsControlVO(CTSCONTROLVO ctsControlVO)
    {
	this.ctsControlVO = ctsControlVO;
    }

    public CIFCONTROLVO getCifControlVO()
    {
	return cifControlVO;
    }

    public void setCifControlVO(CIFCONTROLVO cifControlVO)
    {
	this.cifControlVO = cifControlVO;
    }

    public String getCardDesignDesc()
    {
	return cardDesignDesc;
    }

    public void setCardDesignDesc(String cardDesignDesc)
    {
	this.cardDesignDesc = cardDesignDesc;
    }

    public String getCardMessageDesc()
    {
	return cardMessageDesc;
    }

    public void setCardMessageDesc(String cardMessageDesc)
    {
	this.cardMessageDesc = cardMessageDesc;
    }

    public String getStatusReasonDesc()
    {
	return statusReasonDesc;
    }

    public void setStatusReasonDesc(String statusReasonDesc)
    {
	this.statusReasonDesc = statusReasonDesc;
    }

    public BigDecimal getProtectFlag()
    {
	return protectFlag;
    }

    public void setProtectFlag(BigDecimal protectFlag)
    {
	this.protectFlag = protectFlag;
    }

    public String getIvcrud()
    {
	return ivcrud;
    }

    public void setIvcrud(String ivcrud)
    {
	this.ivcrud = ivcrud;
    }

    public Boolean getNoLiabilityFlag()
    {
	return noLiabilityFlag;
    }

    public void setNoLiabilityFlag(Boolean noLiabilityFlag)
    {
	this.noLiabilityFlag = noLiabilityFlag;
    }

    public Boolean getHoldForRenewalFlag()
    {
	return holdForRenewalFlag;
    }

    public void setHoldForRenewalFlag(Boolean holdForRenewalFlag)
    {
	this.holdForRenewalFlag = holdForRenewalFlag;
    }

    public Boolean getClNetCheckedFlag()
    {
	return clNetCheckedFlag;
    }

    public void setClNetCheckedFlag(Boolean clNetCheckedFlag)
    {
	this.clNetCheckedFlag = clNetCheckedFlag;
    }

    public Boolean getTabsInformationVisible()
    {
	return tabsInformationVisible;
    }

    public void setTabsInformationVisible(Boolean tabsInformationVisible)
    {
	this.tabsInformationVisible = tabsInformationVisible;
    }

    public Boolean getTabsCardPaymentVisible()
    {
	return tabsCardPaymentVisible;
    }

    public void setTabsCardPaymentVisible(Boolean tabsCardPaymentVisible)
    {
	this.tabsCardPaymentVisible = tabsCardPaymentVisible;
    }

    public Boolean getTabsAccountDetailsVisible()
    {
	return tabsAccountDetailsVisible;
    }

    public void setTabsAccountDetailsVisible(Boolean tabsAccountDetailsVisible)
    {
	this.tabsAccountDetailsVisible = tabsAccountDetailsVisible;
    }

    public Boolean getTabsCardHolderInfoVisible()
    {
	return tabsCardHolderInfoVisible;
    }

    public void setTabsCardHolderInfoVisible(Boolean tabsCardHolderInfoVisible)
    {
	this.tabsCardHolderInfoVisible = tabsCardHolderInfoVisible;
    }

    public Boolean getMainDetailsCardLimitSectionVisible()
    {
	return mainDetailsCardLimitSectionVisible;
    }

    public void setMainDetailsCardLimitSectionVisible(Boolean mainDetailsCardLimitSectionVisible)
    {
	this.mainDetailsCardLimitSectionVisible = mainDetailsCardLimitSectionVisible;
    }

    public CURRENCIESVO getCurrencyVO()
    {
	return currencyVO;
    }

    public void setCurrencyVO(CURRENCIESVO currencyVO)
    {
	this.currencyVO = currencyVO;
    }

    public GEN_LEDGERVO getGenLedgerVO()
    {
	return genLedgerVO;
    }

    public void setGenLedgerVO(GEN_LEDGERVO genLedgerVO)
    {
	this.genLedgerVO = genLedgerVO;
    }

    public String getAccName()
    {
	return accName;
    }

    public void setAccName(String accName)
    {
	this.accName = accName;
    }

    public Boolean getConfirmFlag()
    {
	return confirmFlag;
    }

    public void setConfirmFlag(Boolean confirmFlag)
    {
	this.confirmFlag = confirmFlag;
    }

    public String getEnableCardHolderTab()
    {
	return enableCardHolderTab;
    }

    public void setEnableCardHolderTab(String enableCardHolderTab)
    {
	this.enableCardHolderTab = enableCardHolderTab;
    }

    public String getSameType()
    {
	return sameType;
    }

    public void setSameType(String sameType)
    {
	this.sameType = sameType;
    }

    public Boolean getDeleteAccountsGridData()
    {
	return deleteAccountsGridData;
    }

    public void setDeleteAccountsGridData(Boolean deleteAccountsGridData)
    {
	this.deleteAccountsGridData = deleteAccountsGridData;
    }

    public Boolean getTabsAccountDetailsReadOnly()
    {
	return tabsAccountDetailsReadOnly;
    }

    public void setTabsAccountDetailsReadOnly(Boolean tabsAccountDetailsReadOnly)
    {
	this.tabsAccountDetailsReadOnly = tabsAccountDetailsReadOnly;
    }

    public String getUserName()
    {
	return userName;
    }

    public void setUserName(String userName)
    {
	this.userName = userName;
    }

    public String getOldCifReason()
    {
	return oldCifReason;
    }

    public void setOldCifReason(String oldCifReason)
    {
	this.oldCifReason = oldCifReason;
    }

    public String getCardsAccDetGridUpdates()
    {
	return cardsAccDetGridUpdates;
    }

    public void setCardsAccDetGridUpdates(String cardsAccDetGridUpdates)
    {
	this.cardsAccDetGridUpdates = cardsAccDetGridUpdates;
    }

    public String getCardsChargesGridUpdate()
    {
	return cardsChargesGridUpdate;
    }

    public void setCardsChargesGridUpdate(String cardsChargesGridUpdate)
    {
	this.cardsChargesGridUpdate = cardsChargesGridUpdate;
    }

    public EntityChargesCO getEntityChargesCO()
    {
	return entityChargesCO;
    }

    public void setEntityChargesCO(EntityChargesCO entityChargesCO)
    {
	this.entityChargesCO = entityChargesCO;
    }

    public String getUserIsBranchManager()
    {
	return userIsBranchManager;
    }

    public void setUserIsBranchManager(String userIsBranchManager)
    {
	this.userIsBranchManager = userIsBranchManager;
    }

    public String getIsFromAlert()
    {
	return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
	this.isFromAlert = isFromAlert;
    }

    public String getPhysical_status()
    {
	return physical_status;
    }

    public void setPhysical_status(String physicalStatus)
    {
	physical_status = physicalStatus;
    }

    public String getRecord_status()
    {
	return record_status;
    }

    public void setRecord_status(String recordStatus)
    {
	record_status = recordStatus;
    }

    public String getAccCyReadOnly()
    {
	return accCyReadOnly;
    }

    public void setAccCyReadOnly(String accCyReadOnly)
    {
	this.accCyReadOnly = accCyReadOnly;
    }

    public String getAccPosBasedOnReadOnly()
    {
	return accPosBasedOnReadOnly;
    }

    public void setAccPosBasedOnReadOnly(String accPosBasedOnReadOnly)
    {
	this.accPosBasedOnReadOnly = accPosBasedOnReadOnly;
    }

    public String getAccPosPeriodicityOnReadOnly()
    {
	return accPosPeriodicityOnReadOnly;
    }

    public void setAccPosPeriodicityOnReadOnly(String accPosPeriodicityOnReadOnly)
    {
	this.accPosPeriodicityOnReadOnly = accPosPeriodicityOnReadOnly;
    }

    public String getLimitBasedOnReadOnly()
    {
	return limitBasedOnReadOnly;
    }

    public void setLimitBasedOnReadOnly(String limitBasedOnReadOnly)
    {
	this.limitBasedOnReadOnly = limitBasedOnReadOnly;
    }

    public String getLimitCheckPeriodReadOnly()
    {
	return limitCheckPeriodReadOnly;
    }

    public void setLimitCheckPeriodReadOnly(String limitCheckPeriodReadOnly)
    {
	this.limitCheckPeriodReadOnly = limitCheckPeriodReadOnly;
    }

    public String getSuccessMsg()
    {
	return successMsg;
    }

    public void setSuccessMsg(String successMsg)
    {
	this.successMsg = successMsg;
    }

    public String[] getInfoMsgParam()
    {
	return infoMsgParam;
    }

    public void setInfoMsgParam(String... infoMsgParam)
    {
	this.infoMsgParam = infoMsgParam;
    }

    public String getConfirmResp()
    {
	return confirmResp;
    }

    public void setConfirmResp(String confirmResp)
    {
	this.confirmResp = confirmResp;
    }

    public List<CardsManagementCO> getLstAllCardsMgtRec()
    {
	return lstAllCardsMgtRec;
    }

    public void setLstAllCardsMgtRec(List<CardsManagementCO> lstAllCardsMgtRec)
    {
	this.lstAllCardsMgtRec = lstAllCardsMgtRec;
    }

    public String getOriginCardNo()
    {
	return originCardNo;
    }

    public void setOriginCardNo(String originCardNo)
    {
	this.originCardNo = originCardNo;
    }

    public BigDecimal getOriginAppId()
    {
	return originAppId;
    }

    public void setOriginAppId(BigDecimal originAppId)
    {
	this.originAppId = originAppId;
    }

    public String getPeriodId()
    {
	return periodId;
    }

    public void setPeriodId(String periodId)
    {
	this.periodId = periodId;
    }

    public Date getFromDate()
    {
	return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
	this.fromDate = fromDate;
    }

    public Date getDateTo()
    {
	return dateTo;
    }

    public void setDateTo(Date dateTo)
    {
	this.dateTo = dateTo;
    }

    public String getSelectedCard()
    {
	return selectedCard;
    }

    public void setSelectedCard(String selectedCard)
    {
	this.selectedCard = selectedCard;
    }

    public String getAtmCardLimit()
    {
	return atmCardLimit;
    }

    public void setAtmCardLimit(String atmCardLimit)
    {
	this.atmCardLimit = atmCardLimit;
    }

    public String getAllowExceptions()
    {
	return allowExceptions;
    }

    public void setAllowExceptions(String allowExceptions)
    {
	this.allowExceptions = allowExceptions;
    }

    public String getPrimKey()
    {
	return primKey;
    }

    public void setPrimKey(String primKey)
    {
	this.primKey = primKey;
    }

    public String getNewCardNo()
    {
	return newCardNo;
    }

    public void setNewCardNo(String newCardNo)
    {
	this.newCardNo = newCardNo;
    }

    public BigDecimal getOriginAppRef()
    {
	return originAppRef;
    }

    public void setOriginAppRef(BigDecimal originAppRef)
    {
	this.originAppRef = originAppRef;
    }

    public BigDecimal getNewAppId()
    {
	return newAppId;
    }

    public void setNewAppId(BigDecimal newAppId)
    {
	this.newAppId = newAppId;
    }

    public BigDecimal getNewAppRef()
    {
	return newAppRef;
    }

    public void setNewAppRef(BigDecimal newAppRef)
    {
	this.newAppRef = newAppRef;
    }

    public String getOldReason()
    {
	return oldReason;
    }

    public void setOldReason(String oldReason)
    {
	this.oldReason = oldReason;
    }

    public String getStringColumn()
    {
	return stringColumn;
    }

    public void setStringColumn(String stringColumn)
    {
	this.stringColumn = stringColumn;
    }

    public String getDateColumn()
    {
	return dateColumn;
    }

    public void setDateColumn(String dateColumn)
    {
	this.dateColumn = dateColumn;
    }

    public String getAllowCountCards()
    {
	return allowCountCards;
    }

    public void setAllowCountCards(String allowCountCards)
    {
	this.allowCountCards = allowCountCards;
    }

    public String getColName()
    {
	return colName;
    }

    public void setColName(String colName)
    {
	this.colName = colName;
    }

    public Boolean getMainDetailsMaxBalSectionVisible()
    {
	return mainDetailsMaxBalSectionVisible;
    }

    public void setMainDetailsMaxBalSectionVisible(Boolean mainDetailsMaxBalSectionVisible)
    {
	this.mainDetailsMaxBalSectionVisible = mainDetailsMaxBalSectionVisible;
    }

    public BigDecimal getCountryCode()
    {
	return countryCode;
    }

    public void setCountryCode(BigDecimal countryCode)
    {
	this.countryCode = countryCode;
    }

    public BigDecimal getTrx_code()
    {
	return trx_code;
    }

    public void setTrx_code(BigDecimal trxCode)
    {
	trx_code = trxCode;
    }

    public String getTrx_desc()
    {
	return trx_desc;
    }

    public void setTrx_desc(String trxDesc)
    {
	trx_desc = trxDesc;
    }

    public String getExceptFlag()
    {
	return exceptFlag;
    }

    public Boolean get_accBtnFlag()
    {
	return _accBtnFlag;
    }

    public void set_accBtnFlag(Boolean accBtnFlag)
    {
	_accBtnFlag = accBtnFlag;
    }

    public BigDecimal getAllowAddAccToAccGrid()
    {
	return allowAddAccToAccGrid;
    }

    public void setAllowAddAccToAccGrid(BigDecimal allowAddAccToAccGrid)
    {
	this.allowAddAccToAccGrid = allowAddAccToAccGrid;
    }

    public void setExceptFlag(String exceptFlag)
    {
	this.exceptFlag = exceptFlag;
    }

    public String getEventId()
    {
	return eventId;
    }

    public void setEventId(String eventId)
    {
	this.eventId = eventId;
    }

    public String getCardScreenTitle()
    {
	return cardScreenTitle;
    }

    public void setCardScreenTitle(String cardScreenTitle)
    {
	this.cardScreenTitle = cardScreenTitle;
    }

    public String getXmlData()
    {
	return xmlData;
    }

    public void setXmlData(String xmlData)
    {
	this.xmlData = xmlData;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public Integer getCreditCount()
    {
	return creditCount;
    }

    public void setCreditCount(Integer creditCount)
    {
	this.creditCount = creditCount;
    }

    public Integer getDebitCount()
    {
	return debitCount;
    }

    public void setDebitCount(Integer debitCount)
    {
	this.debitCount = debitCount;
    }

    public CTSCARDS_MGTVO getOriginCardsMgtVO()
    {
	return originCardsMgtVO;
    }

    public void setOriginCardsMgtVO(CTSCARDS_MGTVO originCardsMgtVO)
    {
	this.originCardsMgtVO = originCardsMgtVO;
    }

    public BigDecimal getScannedCIFNo()
    {
	return scannedCIFNo;
    }

    public void setScannedCIFNo(BigDecimal scannedCIFNo)
    {
	this.scannedCIFNo = scannedCIFNo;
    }

    public String getCreatedFrom()
    {
	return createdFrom;
    }

    public void setCreatedFrom(String createdFrom)
    {
	this.createdFrom = createdFrom;
    }

    public String getIsEmptied()
    {
	return isEmptied;
    }

    public void setIsEmptied(String isEmptied)
    {
	this.isEmptied = isEmptied;
    }

    public String getOrigCardNo()
    {
	return origCardNo;
    }

    public void setOrigCardNo(String origCardNo)
    {
	this.origCardNo = origCardNo;
    }

    public String getIsHiddenChargeDiv()
    {
	return isHiddenChargeDiv;
    }

    public void setIsHiddenChargeDiv(String isHiddenChargeDiv)
    {
	this.isHiddenChargeDiv = isHiddenChargeDiv;
    }

    public List<String> getListWarningMsg()
    {
	return listWarningMsg;
    }

    public void setListWarningMsg(List<String> listWarningMsg)
    {
	this.listWarningMsg = listWarningMsg;
    }

    public ArrayList<SmartCO> getSmartCOList()
    {
	return smartCOList;
    }

    public void setSmartCOList(ArrayList<SmartCO> smartCOList)
    {
	this.smartCOList = smartCOList;
    }

    public String getFlag()
    {
	return flag;
    }

    public void setFlag(String flag)
    {
	this.flag = flag;
    }

    public ReportResponseCO getReportResponseCO()
    {
	return reportResponseCO;
    }

    public void setReportResponseCO(ReportResponseCO reportResponseCO)
    {
	this.reportResponseCO = reportResponseCO;
    }

    public Integer getMsgCode()
    {
	return msgCode;
    }

    public void setMsgCode(Integer msgCode)
    {
	this.msgCode = msgCode;
    }

    public BigDecimal getArgumentId()
    {
	return argumentId;
    }

    public void setArgumentId(BigDecimal argumentId)
    {
	this.argumentId = argumentId;
    }

    public BigDecimal getReportId()
    {
	return reportId;
    }

    public void setReportId(BigDecimal reportId)
    {
	this.reportId = reportId;
    }

    public String getAlertApprove()
    {
	return alertApprove;
    }

    public void setAlertApprove(String alertApprove)
    {
	this.alertApprove = alertApprove;
    }

    public List<ReportResponseCO> getReportResponseCOList()
    {
	return reportResponseCOList;
    }

    public void setReportResponseCOList(List<ReportResponseCO> reportResponseCOList)
    {
	this.reportResponseCOList = reportResponseCOList;
    }

    public String getBatchFlag()
    {
	return batchFlag;
    }

    public void setBatchFlag(String batchFlag)
    {
	this.batchFlag = batchFlag;
    }

    public String getIsWaived()
    {
	return isWaived;
    }

    public void setIsWaived(String isWaived)
    {
	this.isWaived = isWaived;
    }

    public DynFilesCO getDynFilesCO()
    {
	return dynFilesCO;
    }

    public void setDynFilesCO(DynFilesCO dynFilesCO)
    {
	this.dynFilesCO = dynFilesCO;
    }

    public byte[] getScriptByte()
    {
	return scriptByte;
    }

    public void setScriptByte(byte[] scriptByte)
    {
	this.scriptByte = scriptByte;
    }

    public String getAllowCreditReport()
    {
	return allowCreditReport;
    }

    public void setAllowCreditReport(String allowCreditReport)
    {
	this.allowCreditReport = allowCreditReport;
    }

    public String getAllowDebitReport()
    {
	return allowDebitReport;
    }

    public void setAllowDebitReport(String allowDebitReport)
    {
	this.allowDebitReport = allowDebitReport;
    }

    public String getEventList()
    {
	return eventList;
    }

    public void setEventList(String eventList)
    {
	this.eventList = eventList;
    }

    public String getWaiveIncluding()
    {
	return waiveIncluding;
    }

    public void setWaiveIncluding(String waiveIncluding)
    {
	this.waiveIncluding = waiveIncluding;
    }

    public String getShowMemoOnLoad()
    {
	return showMemoOnLoad;
    }

    public void setShowMemoOnLoad(String showMemoOnLoad)
    {
	this.showMemoOnLoad = showMemoOnLoad;
    }

    /**
     * @return the viewSign
     */
    public String getViewSign()
    {
	return viewSign;
    }

    /**
     * @param viewSign the viewSign to set
     */
    public void setViewSign(String viewSign)
    {
	this.viewSign = viewSign;
    }

    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }

    public String getPrintConfirmationMessage()
    {
	return printConfirmationMessage;
    }

    public void setPrintConfirmationMessage(String printConfirmationMessage)
    {
	this.printConfirmationMessage = printConfirmationMessage;
    }

    public TrxMgntCO getTrxMgntCO()
    {
        return trxMgntCO;
    }

    public void setTrxMgntCO(TrxMgntCO trxMgntCO)
    {
        this.trxMgntCO = trxMgntCO;
    }

    public String getMaskedCardNo()
    {
        return maskedCardNo;
    }

    public void setMaskedCardNo(String maskedCardNo)
    {
        this.maskedCardNo = maskedCardNo;
    }

    public String getMaskedParentCardNo()
    {
        return maskedParentCardNo;
    }

    public void setMaskedParentCardNo(String maskedParentCardNo)
    {
        this.maskedParentCardNo = maskedParentCardNo;
    }

    public String getReasonReadOnly()
    {
        return reasonReadOnly;
    }

    public void setReasonReadOnly(String reasonReadOnly)
    {
        this.reasonReadOnly = reasonReadOnly;
    }

    public String getMailingBoxDesc()
    {
        return mailingBoxDesc;
    }

    public void setMailingBoxDesc(String mailingBoxDesc)
    {
        this.mailingBoxDesc = mailingBoxDesc;
    }

    public String getScreenSrc()
    {
        return screenSrc;
    }

    public void setScreenSrc(String screenSrc)
    {
        this.screenSrc = screenSrc;
    }

    @Override
    public String getChannelId()
    {
        return channelId;
    }

    @Override
    public void setChannelId(String channelId)
    {
        this.channelId = channelId;
    }

    public String getSaveUpdateFlag()
    {
        return saveUpdateFlag;
    }

    public void setSaveUpdateFlag(String saveUpdateFlag)
    {
        this.saveUpdateFlag = saveUpdateFlag;
    }

    public String getLogDuesCreateTrx()
    {
        return logDuesCreateTrx;
    }

    public void setLogDuesCreateTrx(String logDuesCreateTrx)
    {
        this.logDuesCreateTrx = logDuesCreateTrx;
    }

    public Boolean getAllowAccess()
    {
        return allowAccess;
    }

    public void setAllowAccess(Boolean allowAccess)
    {
        this.allowAccess = allowAccess;
    }

    /**
     * @return the statusReasonAction
     */
    public String getStatusReasonAction()
    {
        return statusReasonAction;
    }

    /**
     * @param statusReasonAction the statusReasonAction to set
     */
    public void setStatusReasonAction(String statusReasonAction)
    {
        this.statusReasonAction = statusReasonAction;
    }

    public String getCifVisibility()
    {
        return cifVisibility;
    }

    public void setCifVisibility(String cifVisibility)
    {
        this.cifVisibility = cifVisibility;
    }

    public String getLimitType()
    {
        return limitType;
    }

    public void setLimitType(String limitType)
    {
        this.limitType = limitType;
    }

    public BigDecimal getReturnAcc()
    {
        return returnAcc;
    }

    public void setReturnAcc(BigDecimal returnAcc)
    {
        this.returnAcc = returnAcc;
    }

    public BigDecimal getReturnActiveCard()
    {
        return returnActiveCard;
    }

    public void setReturnActiveCard(BigDecimal returnActiveCard)
    {
        this.returnActiveCard = returnActiveCard;
    }

    public BigDecimal getPosSpentCv()
    {
        return posSpentCv;
    }

    public void setPosSpentCv(BigDecimal posSpentCv)
    {
        this.posSpentCv = posSpentCv;
    }

    public BigDecimal getPosSpentFc()
    {
        return posSpentFc;
    }

    public void setPosSpentFc(BigDecimal posSpentFc)
    {
        this.posSpentFc = posSpentFc;
    }

    public BigDecimal getRecords_nb()
    {
        return records_nb;
    }

    public void setRecords_nb(BigDecimal recordsNb)
    {
        records_nb = recordsNb;
    }

    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public String getCardNo()
    {
        return cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public BigDecimal getAtmSpentCv()
    {
        return atmSpentCv;
    }

    public void setAtmSpentCv(BigDecimal atmSpentCv)
    {
        this.atmSpentCv = atmSpentCv;
    }

    public BigDecimal getAtmSpentFc()
    {
        return atmSpentFc;
    }

    public void setAtmSpentFc(BigDecimal atmSpentFc)
    {
        this.atmSpentFc = atmSpentFc;
    }

    public boolean isSuppressMessage()
    {
        return suppressMessage;
    }

    public void setSuppressMessage(boolean suppressMessage)
    {
        this.suppressMessage = suppressMessage;
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

    public String getReplaceReissue()
    {
        return replaceReissue;
    }

    public void setReplaceReissue(String replaceReissue)
    {
        this.replaceReissue = replaceReissue;
    }
    
    public BigDecimal getBenefCode()
    {
        return benefCode;
    }

    public void setBenefCode(BigDecimal benefCode)
    {
        this.benefCode = benefCode;
    }

    public String getBenefDesc()
    {
        return benefDesc;
    }

    public void setBenefDesc(String benefDesc)
    {
        this.benefDesc = benefDesc;
    }

    public CTS_AVA_BENEFICIARIESVO getBeneficirayVO()
    {
        return beneficirayVO;
    }

    public void setBeneficirayVO(CTS_AVA_BENEFICIARIESVO beneficirayVO)
    {
        this.beneficirayVO = beneficirayVO;
    }

    public String getAvaCard()
    {
        return avaCard;
    }

    public void setAvaCard(String avaCard)
    {
        this.avaCard = avaCard;
    }

    public String getBenefName()
    {
        return benefName;
    }

    public void setBenefName(String benefName)
    {
        this.benefName = benefName;
    }

    public BigDecimal getFileCode()
    {
        return fileCode;
    }

    public void setFileCode(BigDecimal fileCode)
    {
        this.fileCode = fileCode;
    }

    public String getIdTypeBenefDesc()
    {
        return idTypeBenefDesc;
    }

    public void setIdTypeBenefDesc(String idTypeBenefDesc)
    {
        this.idTypeBenefDesc = idTypeBenefDesc;
    }

   
    public String getOccupPositionBenefDesc()
    {
        return occupPositionBenefDesc;
    }

    public void setOccupPositionBenefDesc(String occupPositionBenefDesc)
    {
        this.occupPositionBenefDesc = occupPositionBenefDesc;
    }

    public String getStatusBenefDesc()
    {
        return statusBenefDesc;
    }

    public void setStatusBenefDesc(String statusBenefDesc)
    {
        this.statusBenefDesc = statusBenefDesc;
    }

    public String getOccupationBenefDesc()
    {
        return occupationBenefDesc;
    }

    public void setOccupationBenefDesc(String occupationBenefDesc)
    {
        this.occupationBenefDesc = occupationBenefDesc;
    }

    public String getConfirmMgnt()
    {
        return confirmMgnt;
    }

    public void setConfirmMgnt(String confirmMgnt)
    {
        this.confirmMgnt = confirmMgnt;
    }

    public String getContinueProcess()
    {
        return continueProcess;
    }

    public void setContinueProcess(String continueProcess)
    {
        this.continueProcess = continueProcess;
    }
    
    public BigDecimal getTotalCVCharges()
    {
        return totalCVCharges;
    }

    public void setTotalCVCharges(BigDecimal totalCVCharges)
    {
        this.totalCVCharges = totalCVCharges;
    }

    public boolean isConsiderCharges()
    {
        return considerCharges;
    }

    public void setConsiderCharges(boolean considerCharges)
    {
        this.considerCharges = considerCharges;
    }

    public BigDecimal getWdMinLimitAmount()
    {
        return wdMinLimitAmount;
    }

    public void setWdMinLimitAmount(BigDecimal wdMinLimitAmount)
    {
        this.wdMinLimitAmount = wdMinLimitAmount;
    }

    public BigDecimal getWdLimitAmount()
    {
        return wdLimitAmount;
    }

    public void setWdLimitAmount(BigDecimal wdLimitAmount)
    {
        this.wdLimitAmount = wdLimitAmount;
    }

    public BigDecimal getPosMinLimitAmount()
    {
        return posMinLimitAmount;
    }

    public void setPosMinLimitAmount(BigDecimal posMinLimitAmount)
    {
        this.posMinLimitAmount = posMinLimitAmount;
    }

    public BigDecimal getPostLimitAmount()
    {
        return postLimitAmount;
    }

    public void setPostLimitAmount(BigDecimal postLimitAmount)
    {
        this.postLimitAmount = postLimitAmount;
    }

    public BigDecimal getLdecAmount()
    {
        return ldecAmount;
    }

    public void setLdecAmount(BigDecimal ldecAmount)
    {
        this.ldecAmount = ldecAmount;
    }

    public CIF_ADDRESSVO getCifAddress()
    {
        return cifAddress;
    }

    public void setCifAddress(CIF_ADDRESSVO cifAddress)
    {
        this.cifAddress = cifAddress;
    }

    public FMSCREDITCARD_DETAILSVO getFmsCreditCardDetailsVO()
    {
        return fmsCreditCardDetailsVO;
    }

    public void setFmsCreditCardDetailsVO(FMSCREDITCARD_DETAILSVO fmsCreditCardDetailsVO)
    {
        this.fmsCreditCardDetailsVO = fmsCreditCardDetailsVO;
    }

    public BigDecimal getCifNO()
    {
        return cifNO;
    }

    public void setCifNO(BigDecimal cifNO)
    {
        this.cifNO = cifNO;
    }

    public FMSFACILITYVO getFmsFacilityVO()
    {
        return fmsFacilityVO;
    }

    public void setFmsFacilityVO(FMSFACILITYVO fmsFacilityVO)
    {
        this.fmsFacilityVO = fmsFacilityVO;
    }

    public String getUPDATE_SUB_STATUS()
    {
        return UPDATE_SUB_STATUS;
    }

    public void setUPDATE_SUB_STATUS(String uPDATE_SUB_STATUS)
    {
        UPDATE_SUB_STATUS = uPDATE_SUB_STATUS;
    }

    public FMSFACILITYDETVO getFmsFacilityDetVO()
    {
        return fmsFacilityDetVO;
    }

    public void setFmsFacilityDetVO(FMSFACILITYDETVO fmsFacilityDetVO)
    {
        this.fmsFacilityDetVO = fmsFacilityDetVO;
    }

    public String getPin_status_desc()
    {
        return pin_status_desc;
    }

    public void setPin_status_desc(String pin_status_desc)
    {
        this.pin_status_desc = pin_status_desc;
    }

    public String getYesNo()
    {
        return yesNo;
    }

    public void setYesNo(String yesNo)
    {
        this.yesNo = yesNo;
    }

    public Boolean getMainDetailsFacilityDataSectionVisible()
    {
        return mainDetailsFacilityDataSectionVisible;
    }

    public void setMainDetailsFacilityDataSectionVisible(Boolean mainDetailsFacilityDataSectionVisible)
    {
        this.mainDetailsFacilityDataSectionVisible = mainDetailsFacilityDataSectionVisible;
    }
    
    public BigDecimal getPreviousValue()
    {
        return previousValue;
    }

    public void setPreviousValue(BigDecimal previousValue)
    {
        this.previousValue = previousValue;
    }

    public BigDecimal getBlackListReason()
    {
	return blackListReason;
    }

    public void setBlackListReason(BigDecimal blackListReason)
    {
	this.blackListReason = blackListReason;
    }

    public String getBlackListReasonDesc()
    {
	return blackListReasonDesc;
    }

    public void setBlackListReasonDesc(String blackListReasonDesc)
    {
	this.blackListReasonDesc = blackListReasonDesc;
    }

    public String getMethodName()
    {
	return methodName;
    }

    public void setMethodName(String methodName)
    {
	this.methodName = methodName;
    }

    public String getParentRef()
    {
	return parentRef;
    }

    public void setParentRef(String parentRef)
    {
	this.parentRef = parentRef;
    }

    public String getAutoCreation()
    {
	return autoCreation;
    }

    public void setAutoCreation(String autoCreation)
    {
	this.autoCreation = autoCreation;
    }

    public String getRestrictFactor()
    {
	return restrictFactor;
    }

    public void setRestrictFactor(String restrictFactor)
    {
	this.restrictFactor = restrictFactor;
    }

    public CardReaderCO getCardReaderCO()
    {
        return cardReaderCO;
    }

    public void setCardReaderCO(CardReaderCO cardReaderCO)
    {
        this.cardReaderCO = cardReaderCO;
    }

    public String getReturnedError()
    {
        return returnedError;
    }

    public void setReturnedError(String returnedError)
    {
        this.returnedError = returnedError;
    }

    public String getCardReaderCivilID()
    {
        return cardReaderCivilID;
    }

    public void setCardReaderCivilID(String cardReaderCivilID)
    {
        this.cardReaderCivilID = cardReaderCivilID;
    }

    public String getCardReaderCardSerial()
    {
        return cardReaderCardSerial;
    }

    public void setCardReaderCardSerial(String cardReaderCardSerial)
    {
        this.cardReaderCardSerial = cardReaderCardSerial;
    }

    public BigDecimal getBlackListReturnedValue()
    {
	return blackListReturnedValue;
    }

    public void setBlackListReturnedValue(BigDecimal blackListReturnedValue)
    {
	this.blackListReturnedValue = blackListReturnedValue;
    }

    public String getStatusDesc()
    {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }

    public String getPinStatus()
    {
        return pinStatus;
    }

    public void setPinStatus(String pinStatus)
    {
        this.pinStatus = pinStatus;
    }

    public BigDecimal getFacilityNo()
    {
        return facilityNo;
    }

    public void setFacilityNo(BigDecimal facilityNo)
    {
        this.facilityNo = facilityNo;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }
    

    public List<AdditionalFieldsByTypeCO> getAdditionalFieldsByTypeCOList()
    {
        return additionalFieldsByTypeCOList;
    }

    public void setAdditionalFieldsByTypeCOList(List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList)
    {
        this.additionalFieldsByTypeCOList = additionalFieldsByTypeCOList;
    }

    public String getPinTypeDesc()
    {
        return pinTypeDesc;
    }

    public void setPinTypeDesc(String pinTypeDesc)
    {
        this.pinTypeDesc = pinTypeDesc;
    }
    

    public String getFromGenNewCard()
    {
	return fromGenNewCard;
    }

    public void setFromGenNewCard(String fromGenNewCard)
    {
	this.fromGenNewCard = fromGenNewCard;
    }

    public BigDecimal getChargeSchema()
    {
	return chargeSchema;
    }

    public void setChargeSchema(BigDecimal chargeSchema)
    {
	this.chargeSchema = chargeSchema;
    }

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    public String getCardProductDesc()
    {
        return cardProductDesc;
    }

    public void setCardProductDesc(String cardProductDesc)
    {
        this.cardProductDesc = cardProductDesc;
    }

    public String getProperties()
    {
        return properties;
    }

    public void setProperties(String properties)
    {
        this.properties = properties;
    }

    public List<CardsMgmtGuarantorDetailsCO> getLstAllCardsGuarantorDet()
    {
        return lstAllCardsGuarantorDet;
    }

    public void setLstAllCardsGuarantorDet(List<CardsMgmtGuarantorDetailsCO> lstAllCardsGuarantorDet)
    {
        this.lstAllCardsGuarantorDet = lstAllCardsGuarantorDet;
    }

    public String getCardsGuarantorDetails()
    {
        return cardsGuarantorDetails;
    }

    public void setCardsGuarantorDetails(String cardsGuarantorDetails)
    {
        this.cardsGuarantorDetails = cardsGuarantorDetails;
    }

    public boolean isOpenSignature()
    {
	return openSignature;
    }

    public void setOpenSignature(boolean openSignature)
    {
	this.openSignature = openSignature;
    }

    public String getFromStatusReasonLookUp()
    {
        return fromStatusReasonLookUp;
    }

    public void setFromStatusReasonLookUp(String fromStatusReasonLookUp)
    {
        this.fromStatusReasonLookUp = fromStatusReasonLookUp;
    }
    

    public String getSTATUS_REASON()
    {
        return STATUS_REASON;
    }

    public void setSTATUS_REASON(String sTATUS_REASON)
    {
        STATUS_REASON = sTATUS_REASON;
    }

    public boolean isCalledFromBulkActivate()
    {
        return calledFromBulkActivate;
    }

    public void setCalledFromBulkActivate(boolean calledFromBulkActivate)
    {
        this.calledFromBulkActivate = calledFromBulkActivate;
    }

    public BigDecimal getFromBranch()
    {
        return fromBranch;
    }

    public void setFromBranch(BigDecimal fromBranch)
    {
        this.fromBranch = fromBranch;
    }

    public BigDecimal getToBranch()
    {
        return toBranch;
    }

    public void setToBranch(BigDecimal toBranch)
    {
        this.toBranch = toBranch;
    }

    public BigDecimal getFromApplicationId()
    {
        return fromApplicationId;
    }

    public void setFromApplicationId(BigDecimal fromApplicationId)
    {
        this.fromApplicationId = fromApplicationId;
    }

    public BigDecimal getToApplicationId()
    {
        return toApplicationId;
    }

    public void setToApplicationId(BigDecimal toApplicationId)
    {
        this.toApplicationId = toApplicationId;
    }

    public String getFromCardNo()
    {
        return fromCardNo;
    }

    public void setFromCardNo(String fromCardNo)
    {
        this.fromCardNo = fromCardNo;
    }

    public String getToCardNo()
    {
        return toCardNo;
    }

    public void setToCardNo(String toCardNo)
    {
        this.toCardNo = toCardNo;
    }

    public BigDecimal getCardChargeAmount()
    {
        return cardChargeAmount;
    }

    public void setCardChargeAmount(BigDecimal cardChargeAmount)
    {
        this.cardChargeAmount = cardChargeAmount;
    }

    public List<CardsCollateralsCO> getCardsCollateralsCOs()
    {
        return cardsCollateralsCOs;
    }

    public void setCardsCollateralsCOs(List<CardsCollateralsCO> cardsCollateralsCOs)
    {
        this.cardsCollateralsCOs = cardsCollateralsCOs;
    }

    public CardsCollateralsCO getCardsCollateralsCO()
    {
        return cardsCollateralsCO;
    }

    public void setCardsCollateralsCO(CardsCollateralsCO cardsCollateralsCO)
    {
        this.cardsCollateralsCO = cardsCollateralsCO;
    }

    public String getCollateralUpdates()
    {
        return collateralUpdates;
    }

    public void setCollateralUpdates(String collateralUpdates)
    {
        this.collateralUpdates = collateralUpdates;
    }

    public String getIsHiddenFacilityDiv()
    {
        return isHiddenFacilityDiv;
    }

    public void setIsHiddenFacilityDiv(String isHiddenFacilityDiv)
    {
        this.isHiddenFacilityDiv = isHiddenFacilityDiv;
    }

    public BigDecimal getFacilityValue()
    {
        return facilityValue;
    }

    public void setFacilityValue(BigDecimal facilityValue)
    {
        this.facilityValue = facilityValue;
    }

    public BigDecimal getFacilityCode()
    {
        return facilityCode;
    }

    public void setFacilityCode(BigDecimal facilityCode)
    {
        this.facilityCode = facilityCode;
    }

    public String getFacilityBranchDesc()
    {
        return facilityBranchDesc;
    }

    public void setFacilityBranchDesc(String facilityBranchDesc)
    {
        this.facilityBranchDesc = facilityBranchDesc;
    }

    public List<ReportsCO> getReportsList()
    {
	return reportsList;
    }

    public void setReportsList(List<ReportsCO> reportsList)
    {
	this.reportsList = reportsList;
    }

    public BigDecimal getFacilityBranch()
    {
        return facilityBranch;
    }

    public void setFacilityBranch(BigDecimal facilityBranch)
    {
        this.facilityBranch = facilityBranch;
    }

    public BigDecimal getFacilitySubLimit()
    {
        return facilitySubLimit;
    }

    public void setFacilitySubLimit(BigDecimal facilitySubLimit)
    {
        this.facilitySubLimit = facilitySubLimit;
    }

    public String getCifAdressHomeTel()
    {
        return cifAdressHomeTel;
    }

    public void setCifAdressHomeTel(String cifAdressHomeTel)
    {
        this.cifAdressHomeTel = cifAdressHomeTel;
    }

    public String getCifAdressMobile()
    {
        return cifAdressMobile;
    }

    public void setCifAdressMobile(String cifAdressMobile)
    {
        this.cifAdressMobile = cifAdressMobile;
    }

    public String getCifAdressWorkTel()
    {
        return cifAdressWorkTel;
    }

    public void setCifAdressWorkTel(String cifAdressWorkTel)
    {
        this.cifAdressWorkTel = cifAdressWorkTel;
    }

    public String getCivilCodeBriefDescEng()
    {
        return civilCodeBriefDescEng;
    }

    public void setCivilCodeBriefDescEng(String civilCodeBriefDescEng)
    {
        this.civilCodeBriefDescEng = civilCodeBriefDescEng;
    }

    public BigDecimal getCardAtmAvailable()
    {
        return cardAtmAvailable;
    }

    public void setCardAtmAvailable(BigDecimal cardAtmAvailable)
    {
        this.cardAtmAvailable = cardAtmAvailable;
    }

    public BigDecimal getCardPosAvailable()
    {
        return cardPosAvailable;
    }

    public void setCardPosAvailable(BigDecimal cardPosAvailable)
    {
        this.cardPosAvailable = cardPosAvailable;
    }
    
    public String getErrorType()
    {
	return errorType;
    }

    public void setErrorType(String errorType)
    {
        this.errorType = errorType;
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