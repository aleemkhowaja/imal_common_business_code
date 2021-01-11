package com.path.core.actions.blacklistmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.memo.MemoConstants;
import com.path.core.bo.blacklistmanagement.BlackListBO;
import com.path.core.bo.blacklistmanagement.BlackListConstant;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.blacklistmanagement.BlackListCO;
import com.path.vo.core.blacklistmanagement.BlackListIdsCO;
import com.path.vo.core.blacklistmanagement.BlackListSC;
import com.path.vo.core.cif.CifSC;

/**
 * PB : w_maintain_black_list_management / black_list.pbl
 */
public class BlackListMaintAction extends RetailBaseAction
{
    private BlackListBO blackListBO;
    private AlertsBO alertsBO;

    private BlackListSC blackListSC = new BlackListSC();
    private BlackListCO blackListCO = new BlackListCO();
    private CIFCO cifCO;
    CifSC cifSC = new CifSC();
    private boolean subGridButtonMode;
    private HashMap<String, String> typeRadioMap = new HashMap<String, String>();
    private String typeRadioMapDefaultValue;
    private String blackListIdsStr;
    private boolean messageConfirmed;
    private String accessPrivilegeRef;
    
    //SmartCO list
    private ArrayList<SmartCO> smartCOList;
    
	private void setDefaultsInCO() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	if(blackListCO != null && blackListCO.getAlertsParamCO() != null
		&& Boolean.valueOf(blackListCO.getIsFromAlert()))
	{
	    blackListCO.setLoginCompCode(blackListCO.getAlertsParamCO().getCompCode());
	    blackListCO.setLoginBraCode(blackListCO.getAlertsParamCO().getBranchCode());
	    blackListCO.setUserId(blackListCO.getAlertsParamCO().getUserId());
	}
	else
	{
	    blackListCO.setLoginCompCode(sessionCO.getCompanyCode());
	    blackListCO.setLoginBraCode(sessionCO.getBranchCode());
	    blackListCO.setUserId(sessionCO.getUserName());
	}
	if(!BlackListConstant.APP_AML.equals(sessionCO.getCurrentAppName()))
	{
		blackListCO.setLoginTellerCode(sessionCO.getCtsTellerVO().getCODE());
	}
	
	blackListCO.setLanguage(sessionCO.getLanguage());//fixing pmd RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE
	blackListCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());//fixing pmd RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE
	blackListCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	blackListCO.setRunningDate(sessionCO.getRunningDateRET());
	blackListCO.setPageRef(get_pageRef());
	blackListCO.setCrud(getIv_crud());
	blackListCO.setAppName(sessionCO.getCurrentAppName());
    }

    // BLACK LIST INITIAL ON MAINTENANCE
    public String loadBlackListPage() throws BaseException
    {
	initialize();
	return "blackListGridPage";
    }

    //
    // // BLACK LIST INITIAL
    public String loadBlackListDetPage() throws BaseException
    {
		initialize();
		return "blackListDetailPage";
	    }
	
	    public void initialize() throws BaseException
	    {
		set_searchGridId("blackListGridTbl_Id");
		if("R".equalsIgnoreCase(getIv_crud())/*|| getIv_crud().equalsIgnoreCase("UP")*/)
		{
		    blackListCO.setActionType("saveNew");
		    set_showNewInfoBtn("true");
		    set_recReadOnly("false");
		    setSubGridButtonMode(true);
		    // set access privilege on New Create mode
		    setAccessPrivilegeRef(BlackListConstant.ACCESS_CREATE);
		}
		else
		{
		    set_recReadOnly("true");
		    setSubGridButtonMode(false);
		}
		fillRadioMap();
		setTypeRadioMapDefaultValue("V");
		setDefaultsInCO();
		returnCtsTellerInCO();
    }

    // BLACK LIST ON NEW BUTTON
    public String loadBlackListDetailPage() throws BaseException
    {
	if(getIv_crud().equalsIgnoreCase("R") || getIv_crud().equalsIgnoreCase("UP"))
	{
	    set_recReadOnly("false");
	    setSubGridButtonMode(true);
	}
	else
	{
	    set_recReadOnly("true");
	    setSubGridButtonMode(false);
	}
	initialize();
	fillRadioMap();
	setTypeRadioMapDefaultValue("V");

	return "blackListDetailPage";
    }

    private void fillRadioMap()
    {
	typeRadioMap.put("V", getText("Individual_key"));
	typeRadioMap.put("T", getText("Institution_key"));
    }

    // BLACK LIST EDIT
    public String showBlackListDetails()
    {
	try
	{
	    setDefaultsInCO();
	    blackListSC.setCompCode(blackListCO.getLoginCompCode());
	    blackListSC.setBranchCode(blackListCO.getLoginBraCode());
	    blackListSC.setLangCode(blackListCO.getLanguage());
	    blackListSC.setIvCrud(getIv_crud());
	    blackListSC.setLovType(BlackListConstant.BLACK_LIST_STATUS_LOV_TYPE);
	    
	    blackListSC.setCurrAppName(blackListCO.getAppName());
	    
	    blackListCO = blackListBO.getBlackListDetails(blackListSC);
	    blackListCO.setAppName(blackListSC.getCurrAppName()); //by bilal for TP#885556
	    // set access privilege on update mode
	    setAccessPrivilegeRef(BlackListConstant.ACCESS_UPDATE);
	    
	    if((getIv_crud().equalsIgnoreCase("R") && blackListCO.getBlackListVO().getSTATUS().equalsIgnoreCase(
		    BlackListConstant.STATUS_ACTIVE))
		    || getIv_crud().equalsIgnoreCase("UP"))
	    {
		set_recReadOnly("false");
		setSubGridButtonMode(true);
	    }
	    else
	    {
		setSubGridButtonMode(false);
		set_recReadOnly("true");
	    }
	    
	    fillRadioMap();
	    
	    SessionCO sessionCO = returnSessionObject();
	    returnCtsTellerInCO();
	    
	    if(blackListCO.getBlackListVO().getTYPE() != null)
	    {
		setTypeRadioMapDefaultValue(blackListCO.getBlackListVO().getTYPE());
	    }

	    applyRetrieveAudit(AuditConstant.BLACK_LIST_KEY_REF, blackListCO.getBlackListVO(), blackListCO);
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setTrxNbr(getAuditTrxNbr());
	    applyChangesHighlights(refCO);
	    /* apply memo on retrieve if CIF code is not null */
	    if(!NumberUtil.isEmptyDecimal(blackListCO.getBlackListVO().getCIF()))
	    {
		applyMemoOnBlackListRetrieve(sessionCO);
	    }

   	 	
	    if(BlackListConstant.CRUD_UPDATE_AFTER_APPROVE.equalsIgnoreCase(getIv_crud()))
	    {
	    	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> displayMap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
		displayMap = returnCommonLibBO().applyDynScreenDisplay("trs_ac_br", "trs_ac_br", ConstantsCommon.ACTION_TYPE_READONLY, "1", displayMap, null);
		getAdditionalScreenParams().putAll(displayMap);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    //e.printStackTrace();
	    //log.error(e, "Error in showBlackListDetails");
	}
	return "blackListDetailPage";
    }

    /**
     * @author Sarah ElHusseini
     * retrieve memo for chosen CIF
     * IIAB120195
     */
    private void applyMemoOnBlackListRetrieve(SessionCO sessionCO) throws BaseException
    {
	CTSCONTROLVO ctsControlVO = returnCommonLibBO().returnCTSCONTROLVO(sessionCO.getCompanyCode(), sessionCO.getBranchCode());
	/* Checking if Memo should appear on OPT */
	if(null != ctsControlVO &&
	   MemoConstants.SHOW_MEMO_ALL_OPT_RETRIEVE_TRUE.equals(ctsControlVO.getSHOW_MEMO_ALL_OPT_RETRIEVE()))
	{
	    List<MemoSC> memoList = fillMemoParameters(blackListCO);
	    applyMemoOnRetrieve(memoList,false);
	}
    }

    /**
     * @author SarahElHusseini
     * @param blackListCO
     * @return list of criteria from CIF to be check if there are available memo for it
     */
    private List<MemoSC> fillMemoParameters(BlackListCO blackListCO)
    {
	List<MemoSC> memoList = new ArrayList<MemoSC>();
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    MemoSC memoSC = new MemoSC();
	    memoSC.setAppType(MemoConstants.CSM_APP_TYPE);
	    memoSC.setCompCode(sessionCO.getCompanyCode());
	    memoSC.setOptRef(MemoConstants.MEMO_BLACKLIST_OPT);
	    memoSC.setForAccOrCif(MemoConstants.CIF);
	    memoSC.setCifNo(blackListCO.getBlackListVO().getCIF());
	    memoList.add(memoSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return memoList;
    }

    // SAVE
    public String saveBlackList()
    {
	try
	{

	    List<BlackListIdsCO> blackListIdsList = new ArrayList<BlackListIdsCO>();
	    if(blackListIdsStr != null && !"".equalsIgnoreCase(blackListIdsStr))
	    {
		GridUpdates gu = getGridUpdates(blackListIdsStr, BlackListIdsCO.class, true);
		blackListIdsList = gu.getLstAllRec();

	    }

	    blackListCO.getBlackListIdsList().addAll(blackListIdsList);

	    setDefaultsInCO();
	    
	    /**
	     * data preparation...
	     */
	    blackListCO.setApp(blackListCO.getAppName());

	    blackListCO.setOpt(get_pageRef());
	    blackListCO.setLanguage(blackListCO.getLanguage());

	    blackListCO.setSmartCOList(smartCOList);
	    // audit
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setKeyRef(AuditConstant.BLACK_LIST_KEY_REF);
	    blackListCO.setAuditRefCO(refCO);

	    if("saveNew".equals(blackListCO.getActionType()))
	    {
		refCO.setOperationType(AuditConstant.CREATED);
	    }
	    else
	    {
		refCO.setOperationType(AuditConstant.UPDATE);
		blackListCO.setAuditObj(returnAuditObject(blackListCO.getClass()));
	    }
	    blackListCO = blackListBO.saveBlackList(blackListCO);
	    /*
	     * Set alert parameters and send alert
	     */
	    //added by bilal for TP#885556
	    if(!BlackListConstant.APP_AML.equals(blackListCO.getAppName()))
	    {
	    	AlertsParamCO alertsParamCO = returnAlertsParamCO(blackListCO);
		    showSendAlert(alertsParamCO);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "success";
    }

    // DELETE
    public String deleteBlackList()
    {
	try
	{
	    /*
	     * audit
	     */
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.DELETE);
	    refCO.setKeyRef(AuditConstant.BLACK_LIST_KEY_REF);
	    blackListCO.setAuditRefCO(refCO);
	    blackListCO.setAuditObj(returnAuditObject(blackListCO.getClass()));

	    setDefaultsInCO();
	    blackListCO = blackListBO.delete(blackListCO);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	returnSessionObject().setLocalApproveUserName(null);
	return "success";

    }

    // APPROVE
    public String approveBlackList() throws BOException
    {
	try
	{
	    /*
	     * audit
	     */
	    SessionCO sessionCO = returnSessionObject();
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(AuditConstant.BLACK_LIST_KEY_REF);
	    blackListCO.setAuditRefCO(refCO);
	    blackListCO.setAuditObj(returnAuditObject(blackListCO.getClass()));

	    setDefaultsInCO();
	    blackListCO.setRunningDate(blackListCO.getRunningDate());
	    blackListCO.setMessageConfirmed(getMessageConfirmed());
	    blackListCO.setLoginUserId(sessionCO.getUserName());
	    blackListCO = blackListBO.approve(blackListCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }

    // to be reversed
    public String toBeReversedBlackList() throws BOException
    {
	try
	{
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(AuditConstant.BLACK_LIST_KEY_REF);
	    blackListCO.setAuditRefCO(refCO);
	    blackListCO.setAuditObj(returnAuditObject(blackListCO.getClass()));
	    
	    setDefaultsInCO();
	    blackListCO.getBlackListVO().setCOMP_CODE(blackListCO.getLoginCompCode());
	    blackListCO.getBlackListVO().setTO_BE_REVERSED_BY(blackListCO.getUserId());
	    blackListCO.getBlackListVO().setTO_BE_REVERSED_DATE(blackListCO.getRunningDate());
	    blackListCO.setRunningDate(blackListCO.getRunningDate());
	    blackListCO.setLoginUserId(blackListCO.getUserId());

	    blackListCO = blackListBO.toBeReversed(blackListCO);

	    /*
	     * Set alert parameters and send alert
	     */
	    //added by bilal for TP#885556
	    if(!BlackListConstant.APP_AML.equals(blackListCO.getAppName()))
	    {
		    AlertsParamCO alertsParamCO = returnAlertsParamCO(blackListCO);
		    showSendAlert(alertsParamCO);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }

    // reverse
    public String reverseBlackList() throws BOException
    {
	try
	{
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(AuditConstant.BLACK_LIST_KEY_REF);
	    blackListCO.setAuditRefCO(refCO);
	    blackListCO.setAuditObj(returnAuditObject(blackListCO.getClass()));

	    setDefaultsInCO();
	    blackListCO.getBlackListVO().setCOMP_CODE(blackListCO.getLoginCompCode());
	    blackListCO.setRunningDate(blackListCO.getRunningDate());
	    blackListCO.getBlackListVO().setREVERSED_BY(blackListCO.getUserId());
	    blackListCO.getBlackListVO().setDATE_REVERSED(blackListCO.getRunningDate());
	    blackListCO.setLoginUserId(blackListCO.getUserId());
	    blackListCO.setMessageConfirmed(getMessageConfirmed());

	    blackListCO = blackListBO.reverse(blackListCO);

	    throw new BOException(MessageCodes.RECORDS_HAVE_BEEN_SUCCESSFULLY_REVERSED,
		    ConstantsCommon.WARNING_INFO_MSG_TYPE);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "success";

    }

    /**
     * This function contains the treatment that should be done when clicking
     * the alert button
     * 
     * @return
     */
    public String onAlertButtonClicked() throws BaseException
    {
	/*
	 * Set alert parameters and send alert
	 */
	SessionCO sessionCO = returnSessionObject();
	blackListCO.setAppName(sessionCO.getCurrentAppName());
	blackListCO.setLoginUserId(sessionCO.getUserName());
	//blackListCO.setUserIsBranchManager(sessionCO.getCtsTellerVO().getUSER_IS_BRANCH_MANAGER());
	blackListCO.setOpt(get_pageRef()); 
	blackListCO.setPageRef(get_pageRef()); 
	blackListCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
	blackListCO.setLanguage(sessionCO.getLanguage());
	blackListCO.setCrud(getIv_crud());
	blackListCO.setLoginCompCode(sessionCO.getCompanyCode());
	blackListCO.setLoginBraCode(sessionCO.getBranchCode());
	AlertsParamCO alertsParamCO = returnAlertsParamCO(blackListCO);
	showSendAlert(alertsParamCO);
	return AlertsConstants.ALERT_JSON_SUCCESS;
    }

    /**
     * This function will return the alerts param co
     * 
     * @param blackListCO
     * @return
     */
    private AlertsParamCO returnAlertsParamCO(BlackListCO blackListCO) throws BaseException
    {
	return blackListBO.returnAlertsParamCO(blackListCO);

    }

    /**
     * This function will fill the alerts data in black list screen
     * 
     * @param receivedAlertParamCO
     * @param sessionCO
     * @throws BaseException
     */
    private void applyBlackListAlertsData(AlertsParamCO receivedAlertParamCO, SessionCO sessionCO) throws BaseException
    {
	if(receivedAlertParamCO != null)
	{
	    S_TODO_DETVO currentSTodoDet = new S_TODO_DETVO();
	    currentSTodoDet.setTODO_CODE(receivedAlertParamCO.getTodoCode());
	    currentSTodoDet.setTODO_LINE(receivedAlertParamCO.getTodoLine());
	    receivedAlertParamCO.setOldTodoAlert(receivedAlertParamCO.getTodoAlert());
	    blackListCO.setIsFromAlert(true);
	    if(Boolean.valueOf(receivedAlertParamCO.getIsLocalApprove()))
	    {
		receivedAlertParamCO.setAppName(sessionCO.getCurrentAppName());
		blackListCO.setLoginCompCode(sessionCO.getCompanyCode());
		blackListCO.setLoginBraCode(sessionCO.getBranchCode());
		blackListCO.setIsRemoteAlertApprove(false);
		// If this action is called from local approve. the local
		// approve user name is set in blackListCO
		if(StringUtil.isNotEmpty(sessionCO.getLocalApproveUserName()))
		{
		    blackListCO.setLocalApproveUserName(sessionCO.getLocalApproveUserName());
		    receivedAlertParamCO.setUserId(sessionCO.getLocalApproveUserName());
		}
	    }
	    else
	    {
		currentSTodoDet = alertsBO.returnSTodoDet(currentSTodoDet);
		blackListCO.setLoginCompCode(currentSTodoDet.getCOMP_CODE());
		blackListCO.setLoginBraCode(currentSTodoDet.getBRANCH_CODE());
		blackListCO.setIsRemoteAlertApprove(true);
		receivedAlertParamCO.setUserId(sessionCO.getUserName());
		receivedAlertParamCO.setDateReceived(returnCommonLibBO().returnSystemDateWithTime());
	    }
	    blackListCO.setAlertsParamCO(receivedAlertParamCO);
	}
    }

    /**
     * This function will be called from AlertsOpenItem when clicking on approve
     * button
     * 
     * @return
     */
    public String alertApprove()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    AlertsParamCO receivedAlertParamCO = get_alert();
	    applyBlackListAlertsData(receivedAlertParamCO, sessionCO);

	    if(receivedAlertParamCO != null && !Boolean.valueOf(receivedAlertParamCO.getIsLocalApprove()))
	    {
		alertsBO.checkIfSameStatus(receivedAlertParamCO);
	    }

	    String[] optDetailsArray = returnCommonLibBO().returnOptDetailsList(sessionCO.getCurrentAppName(),
		    receivedAlertParamCO.getProgRef().trim());
	    String reference = receivedAlertParamCO.getProgRef().substring(0, 5);
	    if(optDetailsArray != null && optDetailsArray.length > 0)
	    {
		/*
		 * Set the next progRef
		 */
		if(BlackListConstant.STATUS_ACTIVE.equals(blackListCO.getBlackListVO().getSTATUS()))
		{
		    receivedAlertParamCO.setTodoAlert(AlertsConstants.BLACK_LIST_ACK_APPROVE);
		    receivedAlertParamCO.setProgRef(reference + AlertsConstants.BLACK_LIST_PROG_REF_APPROVE);
		    setMessageConfirmed(true);
		    approveBlackList();
		}
		else
		{
		    receivedAlertParamCO.setTodoAlert(AlertsConstants.BLACK_LIST_ACK_REVERSE);
		    receivedAlertParamCO.setProgRef(reference + AlertsConstants.BLACK_LIST_PROG_REF_REVERSE);
		    setMessageConfirmed(true);
		    reverseBlackList();
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	// Set _alert to null to avoid opening the sendAlert popup
	set_alert(null);
	return AlertsConstants.ALERT_JSON_SUCCESS;
    }

    /**
     * This function will be called from AlertsOpenItem when clicking on reject
     * button
     * 
     * @return
     */
    public String alertReject()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    blackListCO.setRunningDate(sessionCO.getRunningDateRET());
	    AlertsParamCO receivedAlertParamCO = get_alert();
	    applyBlackListAlertsData(receivedAlertParamCO, sessionCO);
	    // Check if the alerts has the same status
	    if(receivedAlertParamCO != null && !Boolean.valueOf(receivedAlertParamCO.getIsLocalApprove()))
	    {
		alertsBO.checkIfSameStatus(receivedAlertParamCO);
	    }

	    // Reject the black list
	    if(BlackListConstant.STATUS_ACTIVE.equals(blackListCO.getBlackListVO().getSTATUS()))
	    {
		receivedAlertParamCO.setTodoAlert(AlertsConstants.BLACK_LIST_ACK_APPROVE_REJECT);
	    }
	    else
	    {
		receivedAlertParamCO.setTodoAlert(AlertsConstants.BLACK_LIST_ACK_REVERSE_REJECT);
	    }
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setKeyRef(AuditConstant.TRANS_CHASH_KEY_REF);
	    blackListCO.setAuditRefCO(refCO);
	    refCO.setOperationType(AuditConstant.UPDATE);
	    blackListCO.setAuditObj(returnAuditObject(blackListCO.getClass()));
	    
	    blackListCO = blackListBO.rejectBlackList(blackListCO);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	/*
	 * Set _alert to null to avoid opening the sendAlert popup
	 */
	set_alert(null);

	return AlertsConstants.ALERT_JSON_SUCCESS;
    }
    
    /**
     * return teller details to check if the user is branch manager
     * @throws BaseException
     */
    public void returnCtsTellerInCO() throws BaseException
    {
		SessionCO sessionCO = returnSessionObject();
		CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
		ctsTellerVO.setCOMP_CODE(sessionCO.getCompanyCode());
		ctsTellerVO.setBRANCH_CODE(sessionCO.getBranchCode());
		if(!BlackListConstant.APP_AML.equals(sessionCO.getCurrentAppName())) //b*b
		{
			if(sessionCO.getCtsTellerVO().getCODE() != null)
			{
			    ctsTellerVO.setCODE(sessionCO.getCtsTellerVO().getCODE());
			    ctsTellerVO = blackListBO.returnCtsTellerDetails(ctsTellerVO);
			}
			blackListCO.setCtsTellerVO(ctsTellerVO);
			blackListCO.setUserIsBranchManager(ctsTellerVO.getUSER_IS_BRANCH_MANAGER());
		}
    }
    
    
    /**
     * This function is called after clicking on the details button when receiving an alert.
     * @return
     * @throws BaseException
     */
    public String loadAlertBlackListDetails() throws BaseException
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    StringBuffer description = new StringBuffer();
	    String todoAlert = blackListCO.getAlertsParamCO().getTodoAlert();
	    if(AlertsConstants.BLACK_LIST_ACK_APPROVE.equals(todoAlert))
	    {
		description.append( "<Approve_key>");
	    }
	    else if(AlertsConstants.BLACK_LIST_ACK_APPROVE_REJECT.equals(todoAlert))
	    {
		description.append( "<Reject_Key>");
	    }
	    else if(AlertsConstants.BLACK_LIST_ACK_REVERSE.equals(todoAlert))
	    {
		description.append( "<Approve_key>");
	    }
	    else if(AlertsConstants.BLACK_LIST_ACK_REVERSE_REJECT.equals(todoAlert))
	    {
		description.append( "<Reject_Key>");
	    }
	    else if(AlertsConstants.BLACK_LIST_TODO_ALERT_APPROVE.equals(todoAlert))
	    {
		description.append( "<CIF_Suspicious_key>");
	    }
	    else if(AlertsConstants.BLACK_LIST_TODO_ALERT_REVERSE.equals(todoAlert))
	    {
		description.append( "<CIF_Suspicious_key>");
	    }
	    else if(AlertsConstants.BLACK_LIST_LOG_ALERT.equals(todoAlert))
	    {
		//added by rany for tpid:514489-SBI170088 tfa blacklist checking  
	  	if(blackListCO.getAlertsParamCO().getTodoExcepEnglish() != null && StringUtil.isNotEmpty(blackListCO.getAlertsParamCO().getTodoExcepEnglish()))
	  	{
	  	    description.append(translateMatchingMessage(blackListCO.getAlertsParamCO().getTodoExcepEnglish()));
	  	}
	  	else
	  	{
	  	    description.append( "<Approve_key>");
	  	}
	  	blackListCO.getAlertsParamCO().setDetailsColor("red");
	    }//end rany
	    if(!description.toString().isEmpty())
	    {
		blackListCO.getAlertsParamCO().setAlertDescription(translateMatchingMessageByLang(description.toString(), sessionCO.getLanguage()));
	    }
	    
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return AlertsConstants.ALERT_JSON_SUCCESS;
    }

    /**
     * #82748 - Manage the alert for suspicious report generated on EOD
     * This function is used to delete the alert related to the EOD61 report after opening it
     * @author nabilfeghali
     * @return
     */
    public String blackListEODCallBack()
    {
        try
        {
            S_TODO_DETVO sTodoDet = new S_TODO_DETVO();
            sTodoDet.setTODO_CODE(blackListCO.getAlertsParamCO().getTodoCode());
            sTodoDet.setTODO_LINE(blackListCO.getAlertsParamCO().getTodoLine());
            alertsBO.fUpdateTodo(sTodoDet, AlertsConstants.UPDATE_NO_TRX);
        }
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    
    public BlackListSC getBlackListSC()
    {
	return blackListSC;
    }

    public void setBlackListSC(BlackListSC blackListSC)
    {
	this.blackListSC = blackListSC;
    }

    public BlackListCO getBlackListCO()
    {
	return blackListCO;
    }

    public void setBlackListCO(BlackListCO blackListCO)
    {
	this.blackListCO = blackListCO;
    }

    public void setBlackListBO(BlackListBO blackListBO)
    {
	this.blackListBO = blackListBO;
    }

    public CIFCO getCifCO()
    {
	return cifCO;
    }

    public void setCifCO(CIFCO cifCO)
    {
	this.cifCO = cifCO;
    }

    public CifSC getCifSC()
    {
	return cifSC;
    }

    public void setCifSC(CifSC cifSC)
    {
	this.cifSC = cifSC;
    }

    public boolean isSubGridButtonMode()
    {
	return subGridButtonMode;
    }

    public void setSubGridButtonMode(boolean subGridButtonMode)
    {
	this.subGridButtonMode = subGridButtonMode;
    }

    public HashMap<String, String> getTypeRadioMap()
    {
	return typeRadioMap;
    }

    public void setTypeRadioMap(HashMap<String, String> typeRadioMap)
    {
	this.typeRadioMap = typeRadioMap;
    }

    public String getTypeRadioMapDefaultValue()
    {
	return typeRadioMapDefaultValue;
    }

    public void setTypeRadioMapDefaultValue(String typeRadioMapDefaultValue)
    {
	this.typeRadioMapDefaultValue = typeRadioMapDefaultValue;
    }

    public String getBlackListIdsStr()
    {
	return blackListIdsStr;
    }

    public void setBlackListIdsStr(String blackListIdsStr)
    {
	this.blackListIdsStr = blackListIdsStr;
    }

    public boolean getMessageConfirmed()
    {
	return messageConfirmed;
    }

    public void setMessageConfirmed(boolean messageConfirmed)
    {
	this.messageConfirmed = messageConfirmed;
    }

    public void setAlertsBO(AlertsBO alertsBO)
    {
	this.alertsBO = alertsBO;
    }

    public ArrayList<SmartCO> getSmartCOList()
    {
	return smartCOList;
    }

    public void setSmartCOList(ArrayList<SmartCO> smartCOList)
    {
	this.smartCOList = smartCOList;
    }

    public String getAccessPrivilegeRef()
    {
	return accessPrivilegeRef;
    }

    public void setAccessPrivilegeRef(String accessPrivilegeRef)
    {
	this.accessPrivilegeRef = accessPrivilegeRef;
    }

}
