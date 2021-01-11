package com.path.vo.core.chequebook;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSCHEQUEBOOKVO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_DESIGNVO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_LEAVESVO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_LINKACCVO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_STATUSVO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_TYPESVO;
import com.path.dbmaps.vo.CTSCHEQUESVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRSVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.dynfiles.DynFilesCO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.accounttype.AccountTypeCO;
import com.path.vo.core.cardreader.CardReaderCO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.entitycharges.EntityChargesCO;
import com.path.vo.core.trxmgnt.TrxMgntCO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: WissamChebli
 * 
 *          ChequeBookCO.java used to
 */
public class ChequeBookCO extends RetailBaseVO
{
    private CTSCHEQUEBOOKVO ctschqbookVO = new CTSCHEQUEBOOKVO();
    private CTSCHEQUEBOOK_DESIGNVO ctsDesignVO = new CTSCHEQUEBOOK_DESIGNVO();
    private CTSCHEQUEBOOK_TYPESVO ctsTypeVO = new CTSCHEQUEBOOK_TYPESVO();
    private CTSCHEQUEBOOK_LEAVESVO ctsLeavesVO = new CTSCHEQUEBOOK_LEAVESVO();
    private CTSCHEQUEBOOK_STATUSVO ctschqbookStatusVO = new CTSCHEQUEBOOK_STATUSVO();
    private CTSCHEQUESVO ctscheques = new CTSCHEQUESVO();
    private CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
    private CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
    private ReportResponseCO reportResponseCO = new ReportResponseCO();
    private ReportResponseCO reportResponse1CO = new ReportResponseCO();
    private List<ReportResponseCO> reportResponseCOList = new ArrayList<ReportResponseCO>();
    private List<ReportResponseCO> reportResponseCO1List = new ArrayList<ReportResponseCO>();
    private List<ReportResponseCO> reportResponseCO2List = new ArrayList<ReportResponseCO>();
    private CTSCHEQUEBOOK_LINKACCVO ctschequebook_linkaccVO = new CTSCHEQUEBOOK_LINKACCVO();
    private List<CTSCHEQUEBOOKVO> listChequeBookAdd = new ArrayList<CTSCHEQUEBOOKVO>();
    private List<CTSCHEQUEBOOK_LINKACCVO> listAdditAccAll = new ArrayList<CTSCHEQUEBOOK_LINKACCVO>();
    private List<CTSCHEQUEBOOK_LINKACCVO> listAdditAccAdd = new ArrayList<CTSCHEQUEBOOK_LINKACCVO>();
    private List<CTSCHEQUEBOOK_LINKACCVO> listAdditAccDel = new ArrayList<CTSCHEQUEBOOK_LINKACCVO>();
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO > hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private CTSCHEQUEBOOK_LEAVESVO leavesVO = new CTSCHEQUEBOOK_LEAVESVO(); 
    private AccountTypeCO accountTypeCO = new AccountTypeCO();
    private TrxMgntCO trxMgntCO = new TrxMgntCO();
    private CIFVO cifVO = new CIFVO(); 
    private CURRENCIESVO currency = new CURRENCIESVO();
    private GEN_LEDGERVO genledgerVO = new GEN_LEDGERVO();
    private AccountCO accountCO = new AccountCO();
    private EntityChargesCO entityChargesCO = new EntityChargesCO();
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private DynFilesCO dynFilesCO = new DynFilesCO();
    private String limitType; 
    private String isFromAlert;
    private String showTheReason;
    private String alertApprove;
    private String channelId;
    private String normalFile;
    private String urgentFile;
    private String isWaived;
    private String signatureSign;
    private String integAction; // Web Service Action
    private String integAddRef;
    private BigDecimal 	integAccBr;
    private String displayWarnMsg;
    private String printConfirmationMessage;
    private String printExceptionsReport;
    private BigDecimal processId;
    private BigDecimal returnAcc;
    private boolean allowAccess;
    private String processName;
    private byte[] scriptByte;
    private String userIsBranchManager;
    private Boolean selectReportLanguage = false;
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    
    private Date 	runningDate;
    private String 	userName;
    private String 	addAccGridUpdate;
    private String 	chargesGridUpdate;
    private String 	gridSelectedRow;
    private String 	chqserial_type;
    private String 	isEmptied = "true";
    private BigDecimal 	CHQ_FROM_NBR;
    private BigDecimal 	MAX_CODE;
    private BigDecimal 	NEW_CODE;
    private BigDecimal 	PREVIOUSNBR;
    private BigDecimal 	CHQ_SERIAL_NO;
    private BigDecimal 	LINE_NO;
    private String	selectType;
    private String	newStatus;
    private String	chqStatus;
    private String	autoSubmit;
    private String	chargeBtn;
    private String 	cardNo;
    private BigDecimal	chqFrom;
    private BigDecimal	chqTo;
    private BigDecimal	chqNumber;
    private BigDecimal scannedCIFNo;
    private BigDecimal reportId;
    private BigDecimal argumentId;
    private BigDecimal nbrCopies;
    private BigDecimal engArgumentId;
    private BigDecimal arabArgumentId;
    private BigDecimal engReportId;
    private BigDecimal arabReportId; 
    private BigDecimal engNbrCopies;
    private BigDecimal arabNbrCopies;
    private String additionalReference;
    private BigDecimal chequeBookCode;
    private String allowInternAcc;
    private String selChqBook;
    private String accLkp;
    private String screenSrc;
    private Boolean isRetrieved;

    // Maint Action fields
    private String ACC_TYPE;
    private String AC_DESC;
    private String CHR_AC_DESC;
    private String CIF_NAME;
    private String CY_NAME;
    private BigDecimal CY_CODE;
    private String DESIGN_DESC;
    private String LEAVES_DESC;
    private String TYPES_DESC;
    private String DEST_BRANCH_DESC;
    private BigDecimal NUMBER_LAST;
    private String CHEQUE_BRIEF_NAME;
    private Date fromDate;
    private Date toDate;

    private boolean check_status;
    private String confirmMsg;
    private String isProceed;
    private Integer msgCode;

    private AMFVO amfVO = new AMFVO();
    private String statusDesc;
    private String listStatus;
    private String type;
    private String process;
    private String normalUrgentId;
    private String isOperCompleted;
    private String collectedByDescType;

    private int digits;

    private BigDecimal cifNo;
    private BigDecimal glCODE;
    private String cifName;
    private String batchNo;
    private String chequeBooks;
    private String checkDigitMsg1;
    private String checkDigitMsg2;
    private String checkDateMsg;
    private String blackListMsg;
    private String checkZeroNullMsg;
    private String deleteMsg;
    private String duplicateMsg;
    private String delvDateMsg;
    private String dateReqMsg;
    private String branchMsg;
    private String colName;
    private String flag;
    private List<String> inStatusList;
    private List<String> notInStatusList;
    
    private BigDecimal chequeWithoutCurr;
    
    private String warningMessages;
    private BigDecimal amount;
    
    /*
     * Cheque type Charges
     */
    private BigDecimal chargesSchema;
    private BigDecimal trxType;
    private BigDecimal destroyCharges;
    private BigDecimal cancelCharges;
    private List<String> listWarningMsg = new ArrayList<String>();
    private BigDecimal trsNo;
    private CTSTRSVO ctsTrsVO = new CTSTRSVO();
    
    //SMART list
    private ArrayList<SmartCO> smartCOList;

    /*
     * jihane TP82894 - IIAB080110 ; TP82682 ABARI11065 added to store sum of dues amount 
     */
    private String logDuesCreateTrx ;
    
    private String actionReason;
    private String showActionReason;
    
    private String rejectMessage;
    private String fromAmfList;

    // Flag : to detect if the warning of message specific to cif should be displayed or not
    private String showCifWarning;
    
    private BigDecimal lockId;//US 154817 
    private String accForLockExists;//US 154817 return true in case the procedure P_RET_LOCK_UNLOCK_SAFE_ACC return accounts to be locked
    
    private CardReaderCO cardReaderCO  = new CardReaderCO();
    
    //Hasan BMO160011 23/01/2016
    private BigDecimal blackListReason;
    private String blackListReasonDesc;
    private String methodName;
    private String parentRef;
    private String allowCifCreationMaskYN;    
    private String applySignature;
    
    // START - These attributes were added for the sendToProvider Call from the webservice
    private List<HashMap<String,BigDecimal>> lstChequeBookCode;
    // END - These attributes were added for the sendToProvider Call from the webservice    
    
    //Bassam Eid BUG# 678070
    private String doNotfilterByUpdatePassBook;
    ////////////////////////
    
    //added by rany for bugid:677766
    private String isCalledFrom;
    
  //Habib Baalbaki accocunt restriction 372747
    private String currAppName;
    private String pageRef;
    
    //chequebook query webservice 
    private String ibanAccNo;
    private List<CTSCHEQUEBOOK_STATUSVO> chequesList = new ArrayList<CTSCHEQUEBOOK_STATUSVO>();
    

    private CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO();
    
    //used for webservice
    private List<ChequeBookCO> chequeBookCOList = new ArrayList<ChequeBookCO>();
    private String skipErrorMessages;
    
    //Rania - IIAB120019 - Cancelling Customer Cheques
    private String reasonCodeDesc;
    private String bulkCancelGridUpdates;
    private String cifDesc;
    private String rejectApproveFlag;
    private ArrayList<ChequeBookCO> bulkCancelListCOs;
    private String requireCancelReason;
    private BigDecimal bulkBatchNo;
    private String fromBatch;
    //Rania - BMO180068 - Changes regarding chq book and related processing
    private BigDecimal bulkDestroyPeriod; 
    private String bulkDestroyPeriodFlag; 
    private String bulkDestoryGridUpdates; 
    private ArrayList<ChequeBookCO> bulkDestoryListCOs;
    private String chqScreenTitle;
    //
    private String disableWaive;
    
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

    public BigDecimal getChequeWithoutCurr()
    {
        return chequeWithoutCurr;
    }

    public void setChequeWithoutCurr(BigDecimal chequeWithoutCurr)
    {
        this.chequeWithoutCurr = chequeWithoutCurr;
    }

    /**
     * @return the ctschqbookVO
     */
    public CTSCHEQUEBOOKVO getCtschqbookVO()
    {
	return ctschqbookVO;
    }

    /**
     * @param ctschqbookVO the ctschqbookVO to set
     */
    public void setCtschqbookVO(CTSCHEQUEBOOKVO ctschqbookVO)
    {
	this.ctschqbookVO = ctschqbookVO;
    }

    /**
     * @return the from_cif_desc
     */
    /**
     * @return the runningDate
     */
    @Override
    public Date getRunningDate()
    {
	return runningDate;
    }

    /**
     * @param runningDate the runningDate to set
     */
    @Override
    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
	return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
	this.userName = userName;
    }

    /**
     * @return the chqserial_type
     */
    public String getChqserial_type()
    {
	return chqserial_type;
    }

    /**
     * @param chqserialType the chqserial_type to set
     */
    public void setChqserial_type(String chqserialType)
    {
	chqserial_type = chqserialType;
    }

    /**
     * @return the cHQ_FROM_NBR
     */
    public BigDecimal getCHQ_FROM_NBR()
    {
	return CHQ_FROM_NBR;
    }

    /**
     * @param cHQFROMNBR the cHQ_FROM_NBR to set
     */
    public void setCHQ_FROM_NBR(BigDecimal cHQFROMNBR)
    {
	CHQ_FROM_NBR = cHQFROMNBR;
    }

    /**
     * @return the mAX_CODE
     */
    public BigDecimal getMAX_CODE()
    {
	return MAX_CODE;
    }

    /**
     * @param mAXCODE the mAX_CODE to set
     */
    public void setMAX_CODE(BigDecimal mAXCODE)
    {
	MAX_CODE = mAXCODE;
    }

    /**
     * @return the nEW_CODE
     */
    public BigDecimal getNEW_CODE()
    {
	return NEW_CODE;
    }

    /**
     * @param nEWCODE the nEW_CODE to set
     */
    public void setNEW_CODE(BigDecimal nEWCODE)
    {
	NEW_CODE = nEWCODE;
    }

    /**
     * @return the pREVIOUSNBR
     */
    public BigDecimal getPREVIOUSNBR()
    {
	return PREVIOUSNBR;
    }

    /**
     * @param pREVIOUSNBR the pREVIOUSNBR to set
     */
    public void setPREVIOUSNBR(BigDecimal pREVIOUSNBR)
    {
	PREVIOUSNBR = pREVIOUSNBR;
    }

    /**
     * @return the cHQ_SERIAL_NO
     */
    public BigDecimal getCHQ_SERIAL_NO()
    {
	return CHQ_SERIAL_NO;
    }

    /**
     * @param cHQSERIALNO the cHQ_SERIAL_NO to set
     */
    public void setCHQ_SERIAL_NO(BigDecimal cHQSERIALNO)
    {
	CHQ_SERIAL_NO = cHQSERIALNO;
    }

    /**
     * @return the selectType
     */
    public String getSelectType()
    {
	return selectType;
    }

    /**
     * @param selectType the selectType to set
     */
    public void setSelectType(String selectType)
    {
	this.selectType = selectType;
    }

    /**
     * @return the newStatus
     */
    public String getNewStatus()
    {
	return newStatus;
    }

    /**
     * @param newStatus the newStatus to set
     */
    public void setNewStatus(String newStatus)
    {
	this.newStatus = newStatus;
    }

    /**
     * @return the ctschqbookStatusVO
     */
    public CTSCHEQUEBOOK_STATUSVO getCtschqbookStatusVO()
    {
	return ctschqbookStatusVO;
    }

    /**
     * @param ctschqbookStatusVO the ctschqbookStatusVO to set
     */
    public void setCtschqbookStatusVO(CTSCHEQUEBOOK_STATUSVO ctschqbookStatusVO)
    {
	this.ctschqbookStatusVO = ctschqbookStatusVO;
    }

    /**
     * @return the autoSubmit
     */
    public String getAutoSubmit()
    {
	return autoSubmit;
    }

    /**
     * @param autoSubmit the autoSubmit to set
     */
    public void setAutoSubmit(String autoSubmit)
    {
	this.autoSubmit = autoSubmit;
    }
    /**
     * 
     * @return
     */
    public BigDecimal getChqFrom()
    {
        return chqFrom;
    }

    /**
     * 
     * @param chqFrom
     */
    public void setChqFrom(BigDecimal chqFrom)
    {
        this.chqFrom = chqFrom;
    }

    /**
     * 
     * @return
     */
    public BigDecimal getChqTo()
    {
        return chqTo;
    }

    /**
     * 
     * @param chqTo
     */
    public void setChqTo(BigDecimal chqTo)
    {
        this.chqTo = chqTo;
    }

    /**
     * @return the chqNumber
     */
    public BigDecimal getChqNumber()
    {
	return chqNumber;
    }

    /**
     * @param chqNumber the chqNumber to set
     */
    public void setChqNumber(BigDecimal chqNumber)
    {
	this.chqNumber = chqNumber;
    }

    /**
     * @return the chqStatus
     */
    public String getChqStatus()
    {
	return chqStatus;
    }

    /**
     * @param chqStatus the chqStatus to set
     */
    public void setChqStatus(String chqStatus)
    {
	this.chqStatus = chqStatus;
    }

    public AMFVO getAmfVO()
    {
	return amfVO;
    }

    public void setAmfVO(AMFVO amfVO)
    {
	this.amfVO = amfVO;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public String getProcess()
    {
	return process;
    }

    public void setProcess(String process)
    {
	this.process = process;
    }

    /**
     * @return the additionalReference
     */
    public String getAdditionalReference()
    {
	return additionalReference;
    }

    /**
     * @param additionalReference the additionalReference to set
     */
    public void setAdditionalReference(String additionalReference)
    {
	this.additionalReference = additionalReference;
    }

    /**
     * @return the ctsControlVO
     */
    public CTSCONTROLVO getCtsControlVO()
    {
	return ctsControlVO;
    }

    /**
     * @param ctsControlVO the ctsControlVO to set
     */
    public void setCtsControlVO(CTSCONTROLVO ctsControlVO)
    {
	this.ctsControlVO = ctsControlVO;
    }

    /**
     * @return the check_status
     */
    public boolean isCheck_status()
    {
	return check_status;
    }

    /**
     * @param checkStatus the check_status to set
     */
    public void setCheck_status(boolean checkStatus)
    {
	check_status = checkStatus;
    }

    /**
     * @return the checkDigitMsg1
     */
    public String getCheckDigitMsg1()
    {
	return checkDigitMsg1;
    }

    /**
     * @param checkDigitMsg1 the checkDigitMsg1 to set
     */
    public void setCheckDigitMsg1(String checkDigitMsg1)
    {
	this.checkDigitMsg1 = checkDigitMsg1;
    }

    /**
     * @return the checkDigitMsg2
     */
    public String getCheckDigitMsg2()
    {
	return checkDigitMsg2;
    }

    /**
     * @param checkDigitMsg2 the checkDigitMsg2 to set
     */
    public void setCheckDigitMsg2(String checkDigitMsg2)
    {
	this.checkDigitMsg2 = checkDigitMsg2;
    }

    /**
     * @return the digits
     */
    public int getDigits()
    {
	return digits;
    }

    /**
     * @param digits the digits to set
     */
    public void setDigits(int digits)
    {
	this.digits = digits;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    /**
     * @return the cifName
     */
    public String getCifName()
    {
	return cifName;
    }

    /**
     * @param cifName the cifName to set
     */
    public void setCifName(String cifName)
    {
	this.cifName = cifName;
    }

    /**
     * @return the ctschequebook_linkaccVO
     */
    public CTSCHEQUEBOOK_LINKACCVO getCtschequebook_linkaccVO()
    {
	return ctschequebook_linkaccVO;
    }

    /**
     * @param ctschequebookLinkaccVO the ctschequebook_linkaccVO to set
     */
    public void setCtschequebook_linkaccVO(CTSCHEQUEBOOK_LINKACCVO ctschequebookLinkaccVO)
    {
	ctschequebook_linkaccVO = ctschequebookLinkaccVO;
    }

    /**
     * @return the glCODE
     */
    public BigDecimal getGlCODE()
    {
	return glCODE;
    }

    /**
     * @param glCODE the glCODE to set
     */
    public void setGlCODE(BigDecimal glCODE)
    {
	this.glCODE = glCODE;
    }

    /**
     * @return the aCC_TYPE
     */
    public String getACC_TYPE()
    {
	return ACC_TYPE;
    }

    /**
     * @return the aC_DESC
     */
    public String getAC_DESC()
    {
	return AC_DESC;
    }

    /**
     * @param aCDESC the aC_DESC to set
     */
    public void setAC_DESC(String aCDESC)
    {
	AC_DESC = aCDESC;
    }

    /**
     * @return the cIF_NAME
     */
    public String getCIF_NAME()
    {
	return CIF_NAME;
    }

    /**
     * @param cIFNAME the cIF_NAME to set
     */
    public void setCIF_NAME(String cIFNAME)
    {
	CIF_NAME = cIFNAME;
    }

    /**
     * @return the cY_NAME
     */
    public String getCY_NAME()
    {
	return CY_NAME;
    }

    /**
     * @param cYNAME the cY_NAME to set
     */
    public void setCY_NAME(String cYNAME)
    {
	CY_NAME = cYNAME;
    }

    /**
     * @param aCCTYPE the aCC_TYPE to set
     */
    public void setACC_TYPE(String aCCTYPE)
    {
	ACC_TYPE = aCCTYPE;
    }

    public CIFVO getCifVO()
    {
        return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }

    public CURRENCIESVO getCurrency()
    {
	return currency;
    }

    public void setCurrency(CURRENCIESVO currency)
    {
	this.currency = currency;
    }

    public String getDESIGN_DESC()
    {
	return DESIGN_DESC;
    }

    public void setDESIGN_DESC(String dESIGNDESC)
    {
	DESIGN_DESC = dESIGNDESC;
    }

    public String getLEAVES_DESC()
    {
	return LEAVES_DESC;
    }

    public void setLEAVES_DESC(String lEAVESDESC)
    {
	LEAVES_DESC = lEAVESDESC;
    }

    public String getTYPES_DESC()
    {
	return TYPES_DESC;
    }

    public void setTYPES_DESC(String tYPESDESC)
    {
	TYPES_DESC = tYPESDESC;
    }

    public String getDEST_BRANCH_DESC()
    {
	return DEST_BRANCH_DESC;
    }

    public void setDEST_BRANCH_DESC(String dESTBRANCHDESC)
    {
	DEST_BRANCH_DESC = dESTBRANCHDESC;
    }

    public BigDecimal getNUMBER_LAST()
    {
	return NUMBER_LAST;
    }

    public void setNUMBER_LAST(BigDecimal nUMBERLAST)
    {
	NUMBER_LAST = nUMBERLAST;
    }

    /**
     * @return the cHEQUE_BRIEF_NAME
     */
    public String getCHEQUE_BRIEF_NAME()
    {
	return CHEQUE_BRIEF_NAME;
    }

    /**
     * @param cHEQUEBRIEFNAME the cHEQUE_BRIEF_NAME to set
     */
    public void setCHEQUE_BRIEF_NAME(String cHEQUEBRIEFNAME)
    {
	CHEQUE_BRIEF_NAME = cHEQUEBRIEFNAME;
    }

    public CTSCHEQUESVO getCtscheques()
    {
	return ctscheques;
    }

    public void setCtscheques(CTSCHEQUESVO ctscheques)
    {
	this.ctscheques = ctscheques;
    }

    public String getAddAccGridUpdate()
    {
	return addAccGridUpdate;
    }

    public void setAddAccGridUpdate(String addAccGridUpdate)
    {
	this.addAccGridUpdate = addAccGridUpdate;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public String getListStatus()
    {
	return listStatus;
    }

    public void setListStatus(String listStatus)
    {
	this.listStatus = listStatus;
    }

    public BigDecimal getChequeBookCode()
    {
	return chequeBookCode;
    }

    public void setChequeBookCode(BigDecimal chequeBookCode)
    {
	this.chequeBookCode = chequeBookCode;
    }

    public List<CTSCHEQUEBOOK_LINKACCVO> getListAdditAccAdd()
    {
	return listAdditAccAdd;
    }

    public void setListAdditAccAdd(List<CTSCHEQUEBOOK_LINKACCVO> listAdditAccAdd)
    {
	this.listAdditAccAdd = listAdditAccAdd;
    }

    public List<CTSCHEQUEBOOK_LINKACCVO> getListAdditAccDel()
    {
	return listAdditAccDel;
    }

    public void setListAdditAccDel(List<CTSCHEQUEBOOK_LINKACCVO> listAdditAccDel)
    {
	this.listAdditAccDel = listAdditAccDel;
    }

    public Date getFromDate()
    {
	return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
	this.fromDate = fromDate;
    }

    public Date getToDate()
    {
	return toDate;
    }

    public void setToDate(Date toDate)
    {
	this.toDate = toDate;
    }

    public String getChequeBooks()
    {
	return chequeBooks;
    }

    public void setChequeBooks(String chequeBooks)
    {
	this.chequeBooks = chequeBooks;
    }

    public String getGridSelectedRow()
    {
	return gridSelectedRow;
    }

    public void setGridSelectedRow(String gridSelectedRow)
    {
	this.gridSelectedRow = gridSelectedRow;
    }

    public List<CTSCHEQUEBOOKVO> getListChequeBookAdd()
    {
	return listChequeBookAdd;
    }

    public void setListChequeBookAdd(List<CTSCHEQUEBOOKVO> listChequeBookAdd)
    {
	this.listChequeBookAdd = listChequeBookAdd;
    }

    public String getNormalUrgentId()
    {
	return normalUrgentId;
    }

    public void setNormalUrgentId(String normalUrgentId)
    {
	this.normalUrgentId = normalUrgentId;
    }

    public String getCHR_AC_DESC()
    {
	return CHR_AC_DESC;
    }

    public void setCHR_AC_DESC(String cHRACDESC)
    {
	CHR_AC_DESC = cHRACDESC;
    }

    public String getCheckDateMsg()
    {
	return checkDateMsg;
    }

    public void setCheckDateMsg(String checkDateMsg)
    {
	this.checkDateMsg = checkDateMsg;
    }

    public String getIsOperCompleted()
    {
	return isOperCompleted;
    }

    public void setIsOperCompleted(String isOperCompleted)
    {
	this.isOperCompleted = isOperCompleted;
    }

    public String getDeleteMsg()
    {
	return deleteMsg;
    }

    public void setDeleteMsg(String deleteMsg)
    {
	this.deleteMsg = deleteMsg;
    }

    public String getDuplicateMsg()
    {
        return duplicateMsg;
    }

    public void setDuplicateMsg(String duplicateMsg)
    {
        this.duplicateMsg = duplicateMsg;
    }

    public String getBranchMsg()
    {
        return branchMsg;
    }

    public void setBranchMsg(String branchMsg)
    {
        this.branchMsg = branchMsg;
    }

    public String getAllowInternAcc()
    {
        return allowInternAcc;
    }

    public void setAllowInternAcc(String allowInternAcc)
    {
        this.allowInternAcc = allowInternAcc;
    }

    public GEN_LEDGERVO getGenledgerVO()
    {
        return genledgerVO;
    }

    public void setGenledgerVO(GEN_LEDGERVO genledgerVO)
    {
        this.genledgerVO = genledgerVO;
    }

    public String getCheckZeroNullMsg()
    {
        return checkZeroNullMsg;
    }

    public void setCheckZeroNullMsg(String checkZeroNullMsg)
    {
        this.checkZeroNullMsg = checkZeroNullMsg;
    }

    public String getBlackListMsg()
    {
        return blackListMsg;
    }

    public void setBlackListMsg(String blackListMsg)
    {
        this.blackListMsg = blackListMsg;
    }

    public AccountTypeCO getAccountTypeCO()
    {
        return accountTypeCO;
    }

    public void setAccountTypeCO(AccountTypeCO accountTypeCO)
    {
        this.accountTypeCO = accountTypeCO;
    }

    public String getDelvDateMsg()
    {
        return delvDateMsg;
    }

    public void setDelvDateMsg(String delvDateMsg)
    {
        this.delvDateMsg = delvDateMsg;
    }

    public String getCollectedByDescType()
    {
        return collectedByDescType;
    }

    public void setCollectedByDescType(String collectedByDescType)
    {
        this.collectedByDescType = collectedByDescType;
    }

    public String getSelChqBook()
    {
        return selChqBook;
    }

    public void setSelChqBook(String selChqBook)
    {
        this.selChqBook = selChqBook;
    }

    public List<String> getInStatusList()
    {
        return inStatusList;
    }

    public void setInStatusList(List<String> inStatusList)
    {
        this.inStatusList = inStatusList;
    }

    public List<String> getNotInStatusList()
    {
        return notInStatusList;
    }

    public void setNotInStatusList(List<String> notInStatusList)
    {
        this.notInStatusList = notInStatusList;
    }

    public CIFCONTROLVO getCifControlVO()
    {
        return cifControlVO;
    }

    public void setCifControlVO(CIFCONTROLVO cifControlVO)
    {
        this.cifControlVO = cifControlVO;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }

    public BigDecimal getLINE_NO()
    {
        return LINE_NO;
    }

    public void setLINE_NO(BigDecimal lINENO)
    {
        LINE_NO = lINENO;
    }

    public BigDecimal getCY_CODE()
    {
        return CY_CODE;
    }

    public void setCY_CODE(BigDecimal cYCODE)
    {
        CY_CODE = cYCODE;
    }

    public String getWarningMessages()
    {
        return warningMessages;
    }

    public void setWarningMessages(String warningMessages)
    {
        this.warningMessages = warningMessages;
    }

    public String getChargeBtn()
    {
        return chargeBtn;
    }

    public void setChargeBtn(String chargeBtn)
    {
        this.chargeBtn = chargeBtn;
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

    public String getChargesGridUpdate()
    {
        return chargesGridUpdate;
    }

    public void setChargesGridUpdate(String chargesGridUpdate)
    {
        this.chargesGridUpdate = chargesGridUpdate;
    }

    public Boolean getIsRetrieved()
    {
        return isRetrieved;
    }

    public void setIsRetrieved(Boolean isRetrieved)
    {
        this.isRetrieved = isRetrieved;
    }

    public String getConfirmMsg()
    {
        return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg)
    {
        this.confirmMsg = confirmMsg;
    }

    public AccountCO getAccountCO()
    {
        return accountCO;
    }

    public void setAccountCO(AccountCO accountCO)
    {
        this.accountCO = accountCO;
    }

    public CTSCHEQUEBOOK_LEAVESVO getLeavesVO()
    {
        return leavesVO;
    }

    public void setLeavesVO(CTSCHEQUEBOOK_LEAVESVO leavesVO)
    {
        this.leavesVO = leavesVO;
    }

    public BigDecimal getScannedCIFNo()
    {
        return scannedCIFNo;
    }

    public void setScannedCIFNo(BigDecimal scannedCIFNo)
    {
        this.scannedCIFNo = scannedCIFNo;
    }

    public String getColName()
    {
        return colName;
    }

    public void setColName(String colName)
    {
        this.colName = colName;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public AlertsParamCO getAlertsParamCO()
    {
        return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
        this.alertsParamCO = alertsParamCO;
    }

    public String getIsFromAlert()
    {
        return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
        this.isFromAlert = isFromAlert;
    }

    public String getUserIsBranchManager()
    {
        return userIsBranchManager;
    }

    public void setUserIsBranchManager(String userIsBranchManager)
    {
        this.userIsBranchManager = userIsBranchManager;
    }

    public String getDateReqMsg()
    {
        return dateReqMsg;
    }

    public List<CTSCHEQUEBOOK_LINKACCVO> getListAdditAccAll()
    {
        return listAdditAccAll;
    }

    public void setListAdditAccAll(List<CTSCHEQUEBOOK_LINKACCVO> listAdditAccAll)
    {
        this.listAdditAccAll = listAdditAccAll;
    }

    public String getIsProceed()
    {
        return isProceed;
    }

    public void setIsProceed(String isProceed)
    {
        this.isProceed = isProceed;
    }

    public BigDecimal getChargesSchema()
    {
        return chargesSchema;
    }

    public void setChargesSchema(BigDecimal chargesSchema)
    {
        this.chargesSchema = chargesSchema;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public BigDecimal getDestroyCharges()
    {
        return destroyCharges;
    }

    public void setDestroyCharges(BigDecimal destroyCharges)
    {
        this.destroyCharges = destroyCharges;
    }

    public BigDecimal getCancelCharges()
    {
        return cancelCharges;
    }

    public void setCancelCharges(BigDecimal cancelCharges)
    {
        this.cancelCharges = cancelCharges;
    }

    public void setDateReqMsg(String dateReqMsg)
    {
        this.dateReqMsg = dateReqMsg;
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

    public Integer getMsgCode()
    {
        return msgCode;
    }

    public void setMsgCode(Integer msgCode)
    {
        this.msgCode = msgCode;
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

    public DynFilesCO getDynFilesCO()
    {
        return dynFilesCO;
    }

    public void setDynFilesCO(DynFilesCO dynFilesCO)
    {
        this.dynFilesCO = dynFilesCO;
    }

    public String getNormalFile()
    {
        return normalFile;
    }

    public void setNormalFile(String normalFile)
    {
        this.normalFile = normalFile;
    }

    public String getUrgentFile()
    {
        return urgentFile;
    }

    public void setUrgentFile(String urgentFile)
    {
        this.urgentFile = urgentFile;
    }

    public byte[] getScriptByte()
    {
        return scriptByte;
    }

    public void setScriptByte(byte[] scriptByte)
    {
        this.scriptByte = scriptByte;
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

    public ReportResponseCO getReportResponse1CO()
    {
        return reportResponse1CO;
    }

    public void setReportResponse1CO(ReportResponseCO reportResponse1CO)
    {
        this.reportResponse1CO = reportResponse1CO;
    }

    public String getIsWaived()
    {
        return isWaived;
    }

    public void setIsWaived(String isWaived)
    {
        this.isWaived = isWaived;
    }

    public String getPrintExceptionsReport()
    {
        return printExceptionsReport;
    }

    public void setPrintExceptionsReport(String printExceptionsReport)
    {
        this.printExceptionsReport = printExceptionsReport;
    }

    public BigDecimal getProcessId()
    {
        return processId;
    }

    public void setProcessId(BigDecimal processId)
    {
        this.processId = processId;
    }

    public String getProcessName()
    {
        return processName;
    }

    public void setProcessName(String processName)
    {
        this.processName = processName;
    }

    public String getSignatureSign()
    {
        return signatureSign;
    }

    public void setSignatureSign(String signatureSign)
    {
        this.signatureSign = signatureSign;
    }

    public CTSCHEQUEBOOK_DESIGNVO getCtsDesignVO()
    {
        return ctsDesignVO;
    }

    public void setCtsDesignVO(CTSCHEQUEBOOK_DESIGNVO ctsDesignVO)
    {
        this.ctsDesignVO = ctsDesignVO;
    }

    public CTSCHEQUEBOOK_TYPESVO getCtsTypeVO()
    {
        return ctsTypeVO;
    }

    public void setCtsTypeVO(CTSCHEQUEBOOK_TYPESVO ctsTypeVO)
    {
        this.ctsTypeVO = ctsTypeVO;
    }

    public CTSCHEQUEBOOK_LEAVESVO getCtsLeavesVO()
    {
        return ctsLeavesVO;
    }

    public void setCtsLeavesVO(CTSCHEQUEBOOK_LEAVESVO ctsLeavesVO)
    {
        this.ctsLeavesVO = ctsLeavesVO;
    }

    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public List<ReportResponseCO> getReportResponseCO1List()
    {
        return reportResponseCO1List;
    }

    public void setReportResponseCO1List(List<ReportResponseCO> reportResponseCO1List)
    {
        this.reportResponseCO1List = reportResponseCO1List;
    }

    public BigDecimal getReportId()
    {
        return reportId;
    }

    public void setReportId(BigDecimal reportId)
    {
        this.reportId = reportId;
    }

    public BigDecimal getArgumentId()
    {
        return argumentId;
    }

    public void setArgumentId(BigDecimal argumentId)
    {
        this.argumentId = argumentId;
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

    public List<ReportResponseCO> getReportResponseCO2List()
    {
        return reportResponseCO2List;
    }

    public void setReportResponseCO2List(List<ReportResponseCO> reportResponseCO2List)
    {
        this.reportResponseCO2List = reportResponseCO2List;
    }

    public String getBatchNo()
    {
        return batchNo;
    }

    public void setBatchNo(String batchNo)
    {
        this.batchNo = batchNo;
    }

    public String getScreenSrc()
    {
        return screenSrc;
    }

    public void setScreenSrc(String screenSrc)
    {
        this.screenSrc = screenSrc;
    }

    public String getShowTheReason()
    {
        return showTheReason;
    }

    public void setShowTheReason(String showTheReason)
    {
        this.showTheReason = showTheReason;
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

    /**
     * @return the ctsTrsVO
     */
    public CTSTRSVO getCtsTrsVO()
    {
        return ctsTrsVO;
    }

    /**
     * @param ctsTrsVO the ctsTrsVO to set
     */
    public void setCtsTrsVO(CTSTRSVO ctsTrsVO)
    {
        this.ctsTrsVO = ctsTrsVO;
    }

    /**
     * @return the accLkp
     */
    public String getAccLkp()
    {
        return accLkp;
    }

    /**
     * @param accLkp the accLkp to set
     */
    public void setAccLkp(String accLkp)
    {
        this.accLkp = accLkp;
    }

    public String getLogDuesCreateTrx()
    {
        return logDuesCreateTrx;
    }

    public void setLogDuesCreateTrx(String logDuesCreateTrx)
    {
        this.logDuesCreateTrx = logDuesCreateTrx;
    }

    /**
     * @return the allowAccess
     */
    public boolean isAllowAccess()
    {
        return allowAccess;
    }

    /**
     * @param allowAccess the allowAccess to set
     */
    public void setAllowAccess(boolean allowAccess)
    {
        this.allowAccess = allowAccess;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
        return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
        this.ctsTellerVO = ctsTellerVO;
    }

    public String getRejectMessage()
    {
        return rejectMessage;
    }

    public void setRejectMessage(String rejectMessage)
    {
        this.rejectMessage = rejectMessage;
    }

    public String getActionReason()
    {
        return actionReason;
    }

    public void setActionReason(String actionReason)
    {
        this.actionReason = actionReason;
    }

    public String getShowActionReason()
    {
        return showActionReason;
    }

    public void setShowActionReason(String showActionReason)
    {
        this.showActionReason = showActionReason;
    }

    /**
     * @return the displayWarnMsg
     */
    public String getDisplayWarnMsg()
    {
        return displayWarnMsg;
    }

    /**
     * @param displayWarnMsg the displayWarnMsg to set
     */
    public void setDisplayWarnMsg(String displayWarnMsg)
    {
        this.displayWarnMsg = displayWarnMsg;
    }

    public String getShowCifWarning()
    {
        return showCifWarning;
    }

    public void setShowCifWarning(String showCifWarning)
    {
        this.showCifWarning = showCifWarning;
    }

    public String getFromAmfList()
    {
        return fromAmfList;
    }

    public void setFromAmfList(String fromAmfList)
    {
        this.fromAmfList = fromAmfList;
    }

    /**
     * @return the engReportId
     */
    public BigDecimal getEngReportId()
    {
        return engReportId;
    }

    /**
     * @param engReportId the engReportId to set
     */
    public void setEngReportId(BigDecimal engReportId)
    {
        this.engReportId = engReportId;
    }

    /**
     * @return the arabReportId
     */
    public BigDecimal getArabReportId()
    {
        return arabReportId;
    }

    /**
     * @param arabReportId the arabReportId to set
     */
    public void setArabReportId(BigDecimal arabReportId)
    {
        this.arabReportId = arabReportId;
    }

    /**
     * @return the selectReportLanguage
     */
    public Boolean getSelectReportLanguage()
    {
        return selectReportLanguage;
    }

    /**
     * @param selectReportLanguage the selectReportLanguage to set
     */
    public void setSelectReportLanguage(Boolean selectReportLanguage)
    {
        this.selectReportLanguage = selectReportLanguage;
    }

    /**
     * @return the engArgumentId
     */
    public BigDecimal getEngArgumentId()
    {
        return engArgumentId;
    }

    /**
     * @param engArgumentId the engArgumentId to set
     */
    public void setEngArgumentId(BigDecimal engArgumentId)
    {
        this.engArgumentId = engArgumentId;
    }

    /**
     * @return the arabArgumentId
     */
    public BigDecimal getArabArgumentId()
    {
        return arabArgumentId;
    }

    /**
     * @param arabArgumentId the arabArgumentId to set
     */
    public void setArabArgumentId(BigDecimal arabArgumentId)
    {
        this.arabArgumentId = arabArgumentId;
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

    public String getCardNo()
    {
        return cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    /**
     * @return the integAddRef
     */
    public String getIntegAddRef()
    {
        return integAddRef;
    }

    /**
     * @param integAddRef the integAddRef to set
     */
    public void setIntegAddRef(String integAddRef)
    {
        this.integAddRef = integAddRef;
    }

    /**
     * @return the integAccBr
     */
    public BigDecimal getIntegAccBr()
    {
        return integAccBr;
    }

    /**
     * @param integAccBr the integAccBr to set
     */
    public void setIntegAccBr(BigDecimal integAccBr)
    {
        this.integAccBr = integAccBr;
    }
    
    public String getIntegAction()
    {
        return integAction;
    }

    public void setIntegAction(String integAction)
    {
        this.integAction = integAction;
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

    // START - These attributes were added for the sendToProvider Call from the webservice
    public List<HashMap<String, BigDecimal>> getLstChequeBookCode()
    {
        return lstChequeBookCode;
    }

    public void setLstChequeBookCode(List<HashMap<String, BigDecimal>> lstChequeBookCode)
    {
        this.lstChequeBookCode = lstChequeBookCode;
    }

    public String getDoNotfilterByUpdatePassBook()
    {
        return doNotfilterByUpdatePassBook;
    }

    public void setDoNotfilterByUpdatePassBook(String doNotfilterByUpdatePassBook)
    {
        this.doNotfilterByUpdatePassBook = doNotfilterByUpdatePassBook;
    }

    public String getIsCalledFrom()
    {
	return isCalledFrom;
    }

    public void setIsCalledFrom(String isCalledFrom)
    {
	this.isCalledFrom = isCalledFrom;
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



    // END - These attributes were added for the sendToProvider Call from the webservice    
    
    public BigDecimal getEngNbrCopies()
    {
        return engNbrCopies;
    }

    public void setEngNbrCopies(BigDecimal engNbrCopies)
    {
        this.engNbrCopies = engNbrCopies;
    }

    public BigDecimal getArabNbrCopies()
    {
        return arabNbrCopies;
    }

    public void setArabNbrCopies(BigDecimal arabNbrCopies)
    {
        this.arabNbrCopies = arabNbrCopies;
    }

    public BigDecimal getNbrCopies()
    {
        return nbrCopies;
    }

    public void setNbrCopies(BigDecimal nbrCopies)
    {
        this.nbrCopies = nbrCopies;
    }

    public String getIbanAccNo() {
	return ibanAccNo;
    }

    public void setIbanAccNo(String ibanAccNo) {
	this.ibanAccNo = ibanAccNo;
    }

    public List<CTSCHEQUEBOOK_STATUSVO> getChequesList() {
	return chequesList;
    }

    public void setChequesList(List<CTSCHEQUEBOOK_STATUSVO> chequesList) {
	this.chequesList = chequesList;
    }


    public CTSTRXTYPEVO getCtsTrxTypeVO()
    {
        return ctsTrxTypeVO;
    }

    public void setCtsTrxTypeVO(CTSTRXTYPEVO ctsTrxTypeVO)
    {
        this.ctsTrxTypeVO = ctsTrxTypeVO;
    }
    
    public List<ChequeBookCO> getChequeBookCOList()
    {
        return chequeBookCOList;
    }

    public void setChequeBookCOList(List<ChequeBookCO> chequeBookCOList)
    {
        this.chequeBookCOList = chequeBookCOList;
    }

    public String getSkipErrorMessages()
    {
        return skipErrorMessages;
    }

    public void setSkipErrorMessages(String skipErrorMessages)
    {
        this.skipErrorMessages = skipErrorMessages;
    }

    public String getReasonCodeDesc()
    {
        return reasonCodeDesc;
    }

    public void setReasonCodeDesc(String reasonCodeDesc)
    {
        this.reasonCodeDesc = reasonCodeDesc;
    }

    public String getBulkCancelGridUpdates()
    {
        return bulkCancelGridUpdates;
    }

    public void setBulkCancelGridUpdates(String bulkCancelGridUpdates)
    {
        this.bulkCancelGridUpdates = bulkCancelGridUpdates;
    }

    public String getCifDesc()
    {
        return cifDesc;
    }

    public void setCifDesc(String cifDesc)
    {
        this.cifDesc = cifDesc;
    }

    public ArrayList<ChequeBookCO> getBulkCancelListCOs()
    {
        return bulkCancelListCOs;
    }

    public void setBulkCancelListCOs(ArrayList<ChequeBookCO> bulkCancelListCOs)
    {
        this.bulkCancelListCOs = bulkCancelListCOs;
    }

    public String getRejectApproveFlag()
    {
        return rejectApproveFlag;
    }

    public void setRejectApproveFlag(String rejectApproveFlag)
    {
        this.rejectApproveFlag = rejectApproveFlag;
    }

    public String getRequireCancelReason()
    {
        return requireCancelReason;
    }

    public void setRequireCancelReason(String requireCancelReason)
    {
        this.requireCancelReason = requireCancelReason;
    }

    public BigDecimal getBulkBatchNo()
    {
        return bulkBatchNo;
    }

    public void setBulkBatchNo(BigDecimal bulkBatchNo)
    {
        this.bulkBatchNo = bulkBatchNo;
    }
    
    public String getFromBatch()
    {
        return fromBatch;
    }

    public void setFromBatch(String fromBatch)
    {
        this.fromBatch = fromBatch;
    }
    
    public CardReaderCO getCardReaderCO()
    {
        return cardReaderCO;
    }

    public void setCardReaderCO(CardReaderCO cardReaderCO)
    {
        this.cardReaderCO = cardReaderCO;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    public String getApplySignature()
    {
        return applySignature;
    }

    public void setApplySignature(String applySignature)
    {
        this.applySignature = applySignature;
    }

    public BigDecimal getBulkDestroyPeriod()
    {
	return bulkDestroyPeriod;
    }

    public void setBulkDestroyPeriod(BigDecimal bulkDestroyPeriod)
    {
	this.bulkDestroyPeriod = bulkDestroyPeriod;
    }

    public String getBulkDestroyPeriodFlag()
    {
	return bulkDestroyPeriodFlag;
    }

    public void setBulkDestroyPeriodFlag(String bulkDestroyPeriodFlag)
    {
	this.bulkDestroyPeriodFlag = bulkDestroyPeriodFlag;
    }

    public String getBulkDestoryGridUpdates()
    {
	return bulkDestoryGridUpdates;
    }

    public void setBulkDestoryGridUpdates(String bulkDestoryGridUpdates)
    {
	this.bulkDestoryGridUpdates = bulkDestoryGridUpdates;
    }

    public ArrayList<ChequeBookCO> getBulkDestoryListCOs()
    {
	return bulkDestoryListCOs;
    }

    public void setBulkDestoryListCOs(ArrayList<ChequeBookCO> bulkDestoryListCOs)
    {
	this.bulkDestoryListCOs = bulkDestoryListCOs;
    }

    public String getChqScreenTitle()
    {
	return chqScreenTitle;
    }

    public void setChqScreenTitle(String chqScreenTitle)
    {
	this.chqScreenTitle = chqScreenTitle;
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