package com.path.actions.common.memo;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.memo.MemoBO;
import com.path.bo.common.memo.MemoConstants;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSCONTROL_ALERTVO;
import com.path.dbmaps.vo.CTSMEMO_DETVO;
import com.path.dbmaps.vo.CTSMEMO_DETVOKey;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.memo.MemoDtlCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.alerts.AlertsSC;

/**
 * 
 * @author george
 * 
 */

public class MemoDtlsMaintAction extends RetailBaseAction
{

    private MemoBO memoDtlBO;
    private CTSMEMO_DETVOKey ctsMemoDetVOKey;
    private MemoDtlCO memoDtlCO = new MemoDtlCO();
    private boolean dateValid;
    private Date date;
    private String actionType = "saveNew";
    private String _toolBarMode = "false";
    private boolean accReadOnlyMode;
    private boolean dateIntrvlReadOnlyMode;
    private AlertsBO alertsBO;
    private String accessMenu;
    private AMFVO account = new AMFVO();

    @Override
    public Object getModel()
    {
	return memoDtlCO;
    }

    /**
     * Loads the Memo details page
     * 
     * @return
     * @throws BaseException 
     */
    public String loadMemoDtlsPage() throws BaseException
    {
	if(getIv_crud().equals("R"))
	{
	    set_showNewInfoBtn("true");
	    set_recReadOnly("false");
	}
	else
	{
	    set_recReadOnly("true");
	}
	SessionCO sessionCO = returnSessionObject();
	// check if login user is branch manager for alert button
	memoDtlCO.setUserIsBranchManager(sessionCO.getCtsTellerVO().getUSER_IS_BRANCH_MANAGER());
	// check if application is RADM for alert button
	memoDtlCO.setCurrentApplication(sessionCO.getCurrentAppName());

	set_searchGridId("memoDetailsGrid_Id");
	fillMenuOptions();
	memoDtlCO.getCtsMemoDetVO().setLAST_REVIEW_NO(BigDecimal.ZERO);
	return "csmMemoDtlsPage";
    }

    /**
     * 
     * @return
     * @throws BaseException 
     */
    public String initialize() throws BaseException
    {
	if(getIv_crud().equals("R"))
	{
	    set_recReadOnly("false");
	    set_showNewInfoBtn("true");
	}
	else
	{
	    set_recReadOnly("true");
	    _toolBarMode = "true";
	}
	setActionType("saveNew");
	fillMenuOptions();
	memoDtlCO.getCtsMemoDetVO().setLAST_REVIEW_NO(BigDecimal.ZERO);
	return "success";
    }

    /**
     * Populates the data in the form on clicking the Grid
     * 
     * @return
     * @throws BaseException 
     */
    public String populateMemoForm() throws BaseException
    {
	try
	{	   
	    SessionCO sessionCO = returnSessionObject();

	    //Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
		    memoDtlCO.setAllowCifCreationMaskYN("1");
	    }
	    else{
		    memoDtlCO.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN()); 
	    }
	    //END Raed Saad - [BB160150]
	    
	    String todoAlertOldStatus = memoDtlCO.getAlertsParamCO().getTodoAlertOldStatus();
	    Boolean isFromAlert = Boolean.valueOf(memoDtlCO.getIsFromAlert());
	    Boolean isAlertLocalApprove = Boolean.valueOf(memoDtlCO.getAlertsParamCO().getIsLocalApprove());
	    // added to check if screen is coming from alert
	    if(memoDtlCO.getAlertsParamCO() != null && Boolean.valueOf(memoDtlCO.getIsFromAlert()))
	    {
		memoDtlCO.getCtsMemoDetVO().setCOMP_CODE(memoDtlCO.getAlertsParamCO().getCompCode());
		memoDtlCO.getCtsMemoDetVO().setBRANCH_CODE(memoDtlCO.getAlertsParamCO().getBranchCode());
	    }
	    else
	    {
		memoDtlCO.getCtsMemoDetVO().setCOMP_CODE(returnSessionObject().getCompanyCode());
		memoDtlCO.getCtsMemoDetVO().setBRANCH_CODE(returnSessionObject().getBranchCode());
	    }
	    memoDtlCO.setLangCode(returnSessionObject().getLanguage());
	    memoDtlCO.setLovType(MemoConstants.STATUS_LOV_TYPE);
	    memoDtlCO = memoDtlBO.getMemoFormData(memoDtlCO);
	    memoDtlCO.setOriginUserId(returnSessionObject().getUserName());
	    if(memoDtlCO.getCtsMemoDetVO().getSTATUS() == null)
	    {
		set_recReadOnly("false");
	    }
	    else
	    {
		if(("A".equals(memoDtlCO.getCtsMemoDetVO().getSTATUS()) && "R".equals(getIv_crud()))
			|| "UP".equals(getIv_crud()))
		{
		    set_recReadOnly("false");
		}
		else
		{
		    set_recReadOnly("true");
		}
	    }
	    //BUG#262014
	    memoDtlCO = memoDtlBO.ctrlMandatoryFields(memoDtlCO);
	    setDateIntrvlReadOnlyMode(!"1".equals(memoDtlCO.getCtsMemoVO().getDATE_INTERVAL()));
	    setAccReadOnlyMode(!"1".equals(memoDtlCO.getCtsMemoVO().getACC_SPECIFIC()));
	    // call Audit on Retrieve
	    applyRetrieveAudit(AuditConstant.MEMO_DTL_KEY_REF, memoDtlCO.getCtsMemoDetVO(), memoDtlCO);
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setTrxNbr(getAuditTrxNbr());
	    applyChangesHighlights(refCO);
	    fillMenuOptions();
	    
	    checkRefreshAlert(isFromAlert, isAlertLocalApprove, todoAlertOldStatus);
	    setAdditionalScreenParams(memoDtlCO.getHm());
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }
    
    /**
     * Check if the alert should be refreshed
     * @param todoAlertOldStatus
     */
    private void checkRefreshAlert(Boolean isFromAlert, Boolean isLocalApprove, String todoAlertOldStatus)
    {
	if(isFromAlert != null && isFromAlert 
		&& isLocalApprove != null && !isLocalApprove)
	{
		Boolean shouldRefreshAlert = (todoAlertOldStatus != null && StringUtil.isNotEmpty(todoAlertOldStatus) 
						&& StringUtil.isNotEmpty(memoDtlCO.getCtsMemoDetVO().getSTATUS())
						&& !todoAlertOldStatus.equals(memoDtlCO.getCtsMemoDetVO().getSTATUS()));
		memoDtlCO.getAlertsParamCO().setShouldRefreshAlert(shouldRefreshAlert.toString());
	}
	else
	{
	    memoDtlCO.getAlertsParamCO().setShouldRefreshAlert(Boolean.FALSE.toString());
	}
    }

    /**
     * Dependency of Memo
     * 
     * @return
     */
    public String returnMemoById()
    {
	try
	{
	   //BUG#261637
	   if(NumberUtil.isEmptyDecimal(memoDtlCO.getCtsMemoVO().getCODE()))
	   {
	       memoDtlCO =  new MemoDtlCO();
	   }
	   else
	   {
	       memoDtlCO.getCtsMemoVO().setCOMP_CODE(returnSessionObject().getCompanyCode());
	       memoDtlCO = memoDtlBO.getMemo(memoDtlCO);
	       setAdditionalScreenParams(memoDtlCO.getHm());
	   }

	}
	catch(BaseException e)
	{
	    memoDtlCO = null;
	    handleException(e, null, null);
	}

	return "success_json";

    }

    public String validateDate()
    {
	try
	{
	    if(dateValid)
	    {
		if(null != date && date.before(returnSessionObject().getRunningDateRET()))
		{
		    throw new BOException(905);
		}
	    }
	    else
	    {
		throw new BOException(555);
	    }
	}
	catch(BOException e)
	{
	    handleException(e, null, null);

	}

	return "success_json";
    }

    /**
     * SaveNew method which called on saveNew Management ....
     * 
     * @return
     */
    public String saveNew()
    {
	try
	{
	    if(NumberUtil.isEmptyDecimal(memoDtlCO.getCtsMemoDetVO().getTRX_NO()))
	    {
		SessionCO sessionCO = returnSessionObject();
		String ivCrud = getIv_crud();
		/**
		 * data preparation...
		 */
		CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();
		ctsMemoDetVO.setCOMP_CODE(sessionCO.getCompanyCode());
		ctsMemoDetVO.setBRANCH_CODE(sessionCO.getBranchCode());
		ctsMemoDetVO.setCREATED_BY(sessionCO.getUserName());
		ctsMemoDetVO.setDATE_CREATED(sessionCO.getRunningDateRET());
		ctsMemoDetVO.setSTATUS(MemoConstants.STATUS_ACTIVE);
		memoDtlCO.setRunningDate(sessionCO.getRunningDateRET());
		if(NumberUtil.isEmptyDecimal(ctsMemoDetVO.getLAST_REVIEW_NO()))
		{
			ctsMemoDetVO.setLAST_REVIEW_NO(BigDecimal.ZERO);
		}

		// ctsMemoDetVO.setOLD_STATUS(MemoConstants.STATUS_ACTIVE);

		memoDtlCO.setOpt(get_pageRef());
		memoDtlCO.setApp(sessionCO.getCurrentAppName());
		memoDtlCO.setLanguage(sessionCO.getLanguage());
		memoDtlCO.setLoginUserId(sessionCO.getUserName());
		memoDtlCO.setLoginCompCode(sessionCO.getCompanyCode()); //Jean-Louis BB140189

		/**
		 * call the business layer ...
		 */
		AuditRefCO refCO = initAuditRefCO();
		memoDtlCO.setAuditRefCO(refCO);
		memoDtlCO = memoDtlBO.saveNew(memoDtlCO);
		/**
		 * call the method checkForAlert for the alert Management ...
		 */
		AlertsParamCO alertsParamCO = returnAlertsParamCO(memoDtlCO,true);
		showSendAlert(alertsParamCO);

		memoDtlCO = new MemoDtlCO();
		set_recReadOnly("false");
		set_toolBarMode("false");
		// set_deleteButton("false");
		setIv_crud(ivCrud);
	    }
	    else
	    {
		update();
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "success";

    }

    /**
     * SaveNew method which called on saveNew Management ....
     * 
     * @return
     */
    public String update()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    String ivCrud = getIv_crud();
	    /**
	     * data preparation...
	     */
	    CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();
	    ctsMemoDetVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    ctsMemoDetVO.setBRANCH_CODE(sessionCO.getBranchCode());
	    // ctsMemoDetVO.setCREATED_BY(sessionCO.getUserName());
	    // ctsMemoDetVO.setDATE_CREATED(sessionCO.getRunningDateRET());
	    ctsMemoDetVO.setSTATUS(MemoConstants.STATUS_ACTIVE);
	    ctsMemoDetVO.setMODIFIED_BY(sessionCO.getUserName());
	    ctsMemoDetVO.setDATE_MODIFIED(sessionCO.getRunningDateRET());

	    // ctsMemoDetVO.setOLD_STATUS(MemoConstants.STATUS_ACTIVE);

	    memoDtlCO.setOpt(get_pageRef());
	    memoDtlCO.setApp(sessionCO.getCurrentAppName());
	    memoDtlCO.setLanguage(sessionCO.getLanguage());

	    // construct Audit Reference
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(AuditConstant.MEMO_DTL_KEY_REF);
	    memoDtlCO.setAuditRefCO(refCO);
	    memoDtlCO.setAuditObj(returnAuditObject(memoDtlCO.getClass()));
	    memoDtlCO.setRunningDate(sessionCO.getRunningDateRET());

	    /**
	     * call the business layer ...
	     */
	    memoDtlBO.update(memoDtlCO);

	    /**
	     * call the method checkForAlert for the alert Management ...
	     */
	    AlertsParamCO alertsParamCO = returnAlertsParamCO(memoDtlCO, false);
	    showSendAlert(alertsParamCO);
	    memoDtlCO = new MemoDtlCO();
	    set_recReadOnly("false");
	    set_toolBarMode("false");
	    // set_deleteButton("false");
	    setIv_crud(ivCrud);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "success";
    }

    /**
     * Do The approve management, it will change the status of the selected
     * record.
     * 
     * @return
     */
    public String approve()
    {
	SessionCO sessionCO = returnSessionObject();
	try
	{

	    String ivCrud = getIv_crud();
	    /**
	     * data preparation ...
	     */
	    CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();
	    ctsMemoDetVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    ctsMemoDetVO.setBRANCH_CODE(sessionCO.getBranchCode());
	    ctsMemoDetVO.setAPPROVED_BY(sessionCO.getUserName());
	    ctsMemoDetVO.setDATE_APPROVED(sessionCO.getRunningDateRET());
	    ctsMemoDetVO.setSTATUS(MemoConstants.STATUS_APPROVE);
	    memoDtlCO.setRunningDate(sessionCO.getRunningDateRET());
	    if(null != sessionCO.getLocalApproveUserName())
	    {
		memoDtlCO.setUserName(sessionCO.getLocalApproveUserName());
	    }
	    memoDtlCO.setApp(sessionCO.getCurrentAppName());
	    memoDtlCO.setLanguage(sessionCO.getLanguage());
	    memoDtlCO.setOriginUserId(sessionCO.getUserName());
	    /**
	     * call Business layer ...
	     */
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(AuditConstant.MEMO_DTL_KEY_REF);
	    memoDtlCO.setAuditRefCO(refCO);
	    memoDtlCO.setAuditObj(returnAuditObject(memoDtlCO.getClass()));
	    memoDtlBO.approve(memoDtlCO);
	    ctsMemoDetVO = new CTSMEMO_DETVO();
	    memoDtlCO.setCtsMemoDetVO(ctsMemoDetVO);
	    /**
	     * call the method checkForAlert for the alert Management ...
	     */
	    // checkForAlert(alertCO);
	    // memoDtlCO = new MemoDtlCO();
	    set_recReadOnly("true");
	    set_toolBarMode("true");
	    setIv_crud(ivCrud);

	}
	catch(Exception ex)
	{
	    ex.printStackTrace();
	    handleException(ex, null, null);
	}
	sessionCO.setLocalApproveUserName(null);
	return "success";
    }

    /**
     * Do The Cancel management, it will change the status of the selected
     * record.
     * 
     * @return
     */
    public String toCancel()
    {
	SessionCO sessionCO = returnSessionObject();
	try
	{

	    String ivCrud = getIv_crud();
	    /**
	     * data preparation ...
	     */
	    CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();
	    ctsMemoDetVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    ctsMemoDetVO.setBRANCH_CODE(sessionCO.getBranchCode());
	    ctsMemoDetVO.setTOBE_CANCELLED_BY(sessionCO.getUserName());
	    ctsMemoDetVO.setTOBE_CANCELLED_DATE(sessionCO.getRunningDateRET());
	    ctsMemoDetVO.setSTATUS(MemoConstants.STATUS_TO_CANCEL);
	    memoDtlCO.setRunningDate(sessionCO.getRunningDateRET());
	    if(null != sessionCO.getLocalApproveUserName())
	    {
		memoDtlCO.setUserName(sessionCO.getLocalApproveUserName());
	    }
	    memoDtlCO.setApp(sessionCO.getCurrentAppName());
	    memoDtlCO.setLanguage(sessionCO.getLanguage());

	    /**
	     * call Business layer ...
	     */
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(AuditConstant.MEMO_DTL_KEY_REF);
	    memoDtlCO.setAuditRefCO(refCO);
	    memoDtlCO.setAuditObj(returnAuditObject(memoDtlCO.getClass()));
	    memoDtlBO.toCancel(memoDtlCO);
	    /**
	     * call the method checkForAlert for the alert Management ...
	     */
	    AlertsParamCO alertsParamCO = returnAlertsParamCO(memoDtlCO, false);
	    showSendAlert(alertsParamCO);

	    ctsMemoDetVO = new CTSMEMO_DETVO();
	    memoDtlCO.setCtsMemoDetVO(ctsMemoDetVO);

	    // memoDtlCO = new MemoDtlCO();
	    set_recReadOnly("true");
	    set_toolBarMode("true");
	    setIv_crud(ivCrud);

	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	sessionCO.setLocalApproveUserName(null);
	return "success";
    }

    /**
     * Do The Cancel management, it will change the status of the selected
     * record.
     * 
     * @return
     */
    public String cancel()
    {
	SessionCO sessionCO = returnSessionObject();
	try
	{

	    String ivCrud = getIv_crud();
	    /**
	     * data preparation ...
	     */
	    CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();
	    ctsMemoDetVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    ctsMemoDetVO.setBRANCH_CODE(sessionCO.getBranchCode());
	    ctsMemoDetVO.setCANCELLED_BY(sessionCO.getUserName());
	    ctsMemoDetVO.setDATE_CANCELLED(sessionCO.getRunningDateRET());
	    ctsMemoDetVO.setSTATUS(MemoConstants.STATUS_CANCEL);
	    memoDtlCO.setRunningDate(sessionCO.getRunningDateRET());
	    if(null != sessionCO.getLocalApproveUserName())
	    {
		memoDtlCO.setUserName(sessionCO.getLocalApproveUserName());
	    }
	    memoDtlCO.setApp(sessionCO.getCurrentAppName());
	    memoDtlCO.setLanguage(sessionCO.getLanguage());

	    /**
	     * call Business layer ...
	     */
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(AuditConstant.MEMO_DTL_KEY_REF);
	    memoDtlCO.setAuditRefCO(refCO);
	    memoDtlCO.setAuditObj(returnAuditObject(memoDtlCO.getClass()));
	    memoDtlBO.cancel(memoDtlCO);
	    ctsMemoDetVO = new CTSMEMO_DETVO();
	    memoDtlCO.setCtsMemoDetVO(ctsMemoDetVO);
	    /**
	     * call the method checkForAlert for the alert Management ...
	     */
	    // checkForAlert(alertCO);
	    // memoDtlCO = new MemoDtlCO();
	    set_recReadOnly("true");
	    set_toolBarMode("true");
	    setIv_crud(ivCrud);

	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	sessionCO.setLocalApproveUserName(null);
	return "success";
    }

    /**
     * Do The Cancel management, it will change the status of the selected
     * record.
     * 
     * @return
     */
    public String toSuspend()
    {
	SessionCO sessionCO = returnSessionObject();
	try
	{

	    String ivCrud = getIv_crud();
	    /**
	     * data preparation ...
	     */
	    CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();
	    ctsMemoDetVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    ctsMemoDetVO.setBRANCH_CODE(sessionCO.getBranchCode());
	    ctsMemoDetVO.setTOBE_SUSPENDED_BY(sessionCO.getUserName());
	    ctsMemoDetVO.setTOBE_SUSPENDED_DATE(sessionCO.getRunningDateRET());
	    ctsMemoDetVO.setSTATUS(MemoConstants.STATUS_TO_SUSPEND);
	    if(null != sessionCO.getLocalApproveUserName())
	    {
		memoDtlCO.setUserName(sessionCO.getLocalApproveUserName());
	    }
	    memoDtlCO.setApp(sessionCO.getCurrentAppName());
	    memoDtlCO.setLanguage(sessionCO.getLanguage());
	    memoDtlCO.setRunningDate(sessionCO.getRunningDateRET());

	    /**
	     * call Business layer ...
	     */
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(AuditConstant.MEMO_DTL_KEY_REF);
	    memoDtlCO.setAuditRefCO(refCO);
	    memoDtlCO.setAuditObj(returnAuditObject(memoDtlCO.getClass()));
	    memoDtlBO.toSuspend(memoDtlCO);
	    /**
	     * call the method checkForAlert for the alert Management ...
	     */
	    AlertsParamCO alertsParamCO = returnAlertsParamCO(memoDtlCO, false);
	    showSendAlert(alertsParamCO);

	    ctsMemoDetVO = new CTSMEMO_DETVO();
	    memoDtlCO.setCtsMemoDetVO(ctsMemoDetVO);
	    /**
	     * call the method checkForAlert for the alert Management ...
	     */
	    // checkForAlert(alertCO);
	    // memoDtlCO = new MemoDtlCO();
	    set_recReadOnly("true");
	    set_toolBarMode("true");
	    setIv_crud(ivCrud);

	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	sessionCO.setLocalApproveUserName(null);
	return "success";
    }

    /**
     * Do The Cancel management, it will change the status of the selected
     * record.
     * 
     * @return
     */
    public String suspend()
    {
	SessionCO sessionCO = returnSessionObject();
	try
	{

	    String ivCrud = getIv_crud();
	    /**
	     * data preparation ...
	     */
	    CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();
	    ctsMemoDetVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    ctsMemoDetVO.setBRANCH_CODE(sessionCO.getBranchCode());
	    ctsMemoDetVO.setSUSPENDED_BY(sessionCO.getUserName());
	    ctsMemoDetVO.setDATE_SUSPENDED(sessionCO.getRunningDateRET());
	    ctsMemoDetVO.setSTATUS(MemoConstants.STATUS_SUSPEND);
	    if(null != sessionCO.getLocalApproveUserName())
	    {
		memoDtlCO.setUserName(sessionCO.getLocalApproveUserName());
	    }
	    memoDtlCO.setApp(sessionCO.getCurrentAppName());
	    memoDtlCO.setLanguage(sessionCO.getLanguage());
	    memoDtlCO.setRunningDate(sessionCO.getRunningDateRET());

	    /**
	     * call Business layer ...
	     */
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(AuditConstant.MEMO_DTL_KEY_REF);
	    memoDtlCO.setAuditRefCO(refCO);
	    memoDtlCO.setAuditObj(returnAuditObject(memoDtlCO.getClass()));
	    memoDtlCO.setRunningDate(sessionCO.getRunningDateRET());
	    memoDtlBO.suspend(memoDtlCO);
	    ctsMemoDetVO = new CTSMEMO_DETVO();
	    memoDtlCO.setCtsMemoDetVO(ctsMemoDetVO);
	    /**
	     * call the method checkForAlert for the alert Management ...
	     */
	    // checkForAlert(alertCO);
	    // memoDtlCO = new MemoDtlCO();
	    set_recReadOnly("true");
	    set_toolBarMode("true");
	    setIv_crud(ivCrud);

	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	sessionCO.setLocalApproveUserName(null);
	return "success";
    }

    /**
     * Do The toReactivate management, it will change the status of the selected
     * record.
     * 
     * @return
     */
    public String toReactivate()
    {
	SessionCO sessionCO = returnSessionObject();
	try
	{

	    String ivCrud = getIv_crud();
	    /**
	     * data preparation ...
	     */
	    CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();
	    ctsMemoDetVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    ctsMemoDetVO.setBRANCH_CODE(sessionCO.getBranchCode());
	    ctsMemoDetVO.setTOBE_REACTIVATED_BY(sessionCO.getUserName());
	    ctsMemoDetVO.setTOBE_REACTIVATED_DATE(sessionCO.getRunningDateRET());
	    if(null != sessionCO.getLocalApproveUserName())
	    {
		memoDtlCO.setUserName(sessionCO.getLocalApproveUserName());
	    }
	    ctsMemoDetVO.setSTATUS(MemoConstants.STATUS_TO_REACTIVATE);
	    memoDtlCO.setApp(sessionCO.getCurrentAppName());
	    memoDtlCO.setLanguage(sessionCO.getLanguage());

	    /**
	     * call Business layer ...
	     */
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(AuditConstant.MEMO_DTL_KEY_REF);
	    memoDtlCO.setAuditRefCO(refCO);
	    memoDtlCO.setAuditObj(returnAuditObject(memoDtlCO.getClass()));
	    memoDtlCO.setRunningDate(sessionCO.getRunningDateRET());
	    memoDtlBO.toReactivate(memoDtlCO);
	    /**
	     * call the method checkForAlert for the alert Management ...
	     */
	    AlertsParamCO alertsParamCO = returnAlertsParamCO(memoDtlCO, false);
	    showSendAlert(alertsParamCO);

	    ctsMemoDetVO = new CTSMEMO_DETVO();
	    memoDtlCO.setCtsMemoDetVO(ctsMemoDetVO);
	    // memoDtlCO = new MemoDtlCO();
	    set_recReadOnly("true");
	    set_toolBarMode("true");
	    setIv_crud(ivCrud);

	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	sessionCO.setLocalApproveUserName(null);
	return "success";
    }

    /**
     * Do The reactivate management, it will change the status of the selected
     * record.
     * 
     * @return
     */
    public String reactivate()
    {
	SessionCO sessionCO = returnSessionObject();
	try
	{

	    String ivCrud = getIv_crud();
	    /**
	     * data preparation ...
	     */
	    CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();
	    ctsMemoDetVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    ctsMemoDetVO.setBRANCH_CODE(sessionCO.getBranchCode());
	    ctsMemoDetVO.setREACTIVATED_BY(sessionCO.getUserName());
	    ctsMemoDetVO.setDATE_REACTIVATED(sessionCO.getRunningDateRET());
	    ctsMemoDetVO.setSTATUS(MemoConstants.STATUS_APPROVE);
	    if(null != sessionCO.getLocalApproveUserName())
	    {
		memoDtlCO.setUserName(sessionCO.getLocalApproveUserName());
	    }
	    memoDtlCO.setApp(sessionCO.getCurrentAppName());
	    memoDtlCO.setLanguage(sessionCO.getLanguage());

	    /**
	     * call Business layer ...
	     */
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(AuditConstant.MEMO_DTL_KEY_REF);
	    memoDtlCO.setAuditRefCO(refCO);
	    memoDtlCO.setAuditObj(returnAuditObject(memoDtlCO.getClass()));
	    memoDtlCO.setRunningDate(sessionCO.getRunningDateRET());
	    memoDtlBO.reactivate(memoDtlCO);
	    ctsMemoDetVO = new CTSMEMO_DETVO();
	    memoDtlCO.setCtsMemoDetVO(ctsMemoDetVO);
	    /**
	     * call the method checkForAlert for the alert Management ...
	     */
	    // checkForAlert(alertCO);
	    // memoDtlCO = new MemoDtlCO();
	    set_recReadOnly("true");
	    set_toolBarMode("true");
	    setIv_crud(ivCrud);

	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	sessionCO.setLocalApproveUserName(null);
	return "success";
    }

    public String saveMemo()
    {
	return "success";
    }

    public String delete()
    {
	SessionCO sessionCO = returnSessionObject();
	try
	{

	    String ivCrud = getIv_crud();
	    /**
	     * data preparation ...
	     */
	    CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();

	    ctsMemoDetVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    ctsMemoDetVO.setBRANCH_CODE(sessionCO.getBranchCode());
	    ctsMemoDetVO.setDELETED_BY(sessionCO.getUserName());
	    ctsMemoDetVO.setDATE_DELETED(sessionCO.getRunningDateRET());
	    ctsMemoDetVO.setSTATUS(MemoConstants.STATUS_DELETE);
	    memoDtlCO.setRunningDate(sessionCO.getRunningDateRET());
	    if(null != sessionCO.getLocalApproveUserName())
	    {
		memoDtlCO.setUserName(sessionCO.getLocalApproveUserName());
	    }
	    memoDtlCO.setApp(sessionCO.getCurrentAppName());
	    memoDtlCO.setLanguage(sessionCO.getLanguage());

	    /**
	     * call Business layer ...
	     */
	    // construct Audit Reference
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.DELETE);
	    refCO.setKeyRef(AuditConstant.MEMO_DTL_KEY_REF);
	    memoDtlCO.setAuditRefCO(refCO);
	    memoDtlCO.setAuditObj(returnAuditObject(memoDtlCO.getClass()));

	    memoDtlBO.delete(memoDtlCO);

	    /**
	     * call the method checkForAlert for the alert Management ...
	     */
	    // checkForAlert(alertCO);
	    memoDtlCO = new MemoDtlCO();
	    set_recReadOnly("true");
	    set_toolBarMode("true");
	    setIv_crud(ivCrud);

	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	sessionCO.setLocalApproveUserName(null);
	return "success";
    }

    public String newMemo()
    {
	return "success";
    }

    /**
     * This function contains the treatment that should be done when clicking
     * the alert button
     * 
     * @author hibaoweidat
     * @return
     */
    public String onAlertButtonClicked() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	memoDtlCO.getCtsMemoDetVO().setCOMP_CODE(sessionCO.getCompanyCode());
	memoDtlCO.getCtsMemoDetVO().setBRANCH_CODE(sessionCO.getBranchCode());
	// Set alert parameters and send alert
	AlertsParamCO alertsParamCO = returnAlertsParamCO(memoDtlCO, false);
	showSendAlert(alertsParamCO);
	return AlertsConstants.ALERT_JSON_SUCCESS;
    }

    /******************************************** Alerts Implementation **************************************************************/

    private AlertsParamCO returnAlertsParamCO(MemoDtlCO memoDtlCO, boolean isNewAction) throws BaseException
    {
	AlertsParamCO alertsParamCO = new AlertsParamCO();

	String status = memoDtlCO.getCtsMemoDetVO().getSTATUS();
	if(isNewAction && status == null)
	{
	    status = MemoConstants.STATUS_ACTIVE;
	}

	SessionCO sessionCO = returnSessionObject();
	memoDtlCO.setLoginCompCode(sessionCO.getCompanyCode());
	memoDtlCO.setLoginBraCode(sessionCO.getBranchCode());
	AlertsParamCO returedAlertsParamCO = checkSendAlert(alertsParamCO, isNewAction, status, get_pageRef());
	if(StringUtil.isNotEmpty(returedAlertsParamCO.getTodoExcepEnglish()))
	{
	    alertsParamCO.setTodoExcepArabic(translateMatchingMessageByLang(returedAlertsParamCO.getTodoExcepEnglish(),
		    ConstantsCommon.LANGUAGE_ARABIC));

	    alertsParamCO.setTodoExcepEnglish(translateMatchingMessageByLang(returedAlertsParamCO.getTodoExcepEnglish(),
		    ConstantsCommon.LANGUAGE_ENGLISH));
	}
	if(returedAlertsParamCO.getAllowToSend() != null
		&& BigDecimal.ZERO.equals(returedAlertsParamCO.getAllowToSend()))
	{
	    // The alert should not be sent, so we should return null.
	    return null;
	}

	// Set the next progRef based on the record status
	alertsParamCO.setProgRef(returedAlertsParamCO.getProgRef());
	alertsParamCO.setCompCode(sessionCO.getCompanyCode());
	alertsParamCO.setBranchCode(sessionCO.getBranchCode());
	alertsParamCO.setStatus(status);
	alertsParamCO.setAmount(BigDecimal.ZERO);

	alertsParamCO.setTrsNo(memoDtlCO.getCtsMemoDetVO().getTRX_NO());

//	String alertDescriptionPattern = AlertsConstants.MEMO_ALERT_DESCRIPTION_PATTERN;

//	String alertDescription = MessageFormat.format(alertDescriptionPattern, memoDtlCO.getCtsMemoVO()
//		.getBRIEF_DESC_ENG(), memoDtlCO.getCtsMemoDetVO().getENG_COMENT(), memoDtlCO.getCifDesc());

//	alertsParamCO.setAlertDescription(alertDescription);
	alertsParamCO.setAlertLabelKey(getText(AlertsConstants.MEMO_TODO_ALERT
		+ AlertsConstants.ALERT_SEND_TITLE_SUFFIX));

	alertsParamCO.setReasonCode(AlertsConstants.MEMO_REASON_CODE);
	alertsParamCO.setAlertType(AlertsConstants.MEMO_ALERT_TYPE);
	alertsParamCO.setTrsNo(memoDtlCO.getCtsMemoDetVO().getTRX_NO());
	alertsParamCO.setTodoAlert(AlertsConstants.MEMO_TODO_ALERT);
	alertsParamCO.setTodoParam(memoDtlCO.getCtsMemoDetVO().getTRX_NO().toString());

	alertsParamCO.setActionType(AlertsConstants.ACTION_TYPE_X);
	alertsParamCO.setDistributionType(AlertsConstants.DISTRIBUTION_TYPE_B);
	alertsParamCO.setDistributionTo(AlertsConstants.DISTRIBUTION_TO_U);
	// TODO adjust getText(AlertsConstants.REMITTANCE_APPROVE_DESC)
	// alertsParamCO.setBriefNameEnglish(getText(AlertsConstants.REMITTANCE_APPROVE_DESC));
	alertsParamCO.setTodoType(AlertsConstants.TODO_TYPE_P);
	alertsParamCO.setTodoPriority(AlertsConstants.TODO_PRIORITY_A);
	alertsParamCO.setTodoChecked(AlertsConstants.TODO_CHECKED_U);
	alertsParamCO.setTodoExecution(AlertsConstants.TODO_EXECUTION_N);
	alertsParamCO.setAllowToSend(BigDecimal.ONE);

	alertsParamCO.setTodoExternal("0");
	alertsParamCO.setTrsNo(BigDecimal.ZERO);
	alertsParamCO.setTodoTellerBranch(BigDecimal.ZERO);
	alertsParamCO.setTodoTellerId(BigDecimal.ZERO);
	alertsParamCO.setCIF_NO(BigDecimal.ZERO);
	alertsParamCO.setTodoAlertOldStatus(memoDtlCO.getCtsMemoDetVO().getSTATUS());
	
	memoDtlCO.getAlertsParamCO().setCompCode(alertsParamCO.getCompCode());
	memoDtlCO.getAlertsParamCO().setBranchCode(alertsParamCO.getBranchCode());
	memoDtlCO.getAlertsParamCO().setTodoParam(alertsParamCO.getTodoParam());
	String alertDescription = prepareAlertMemoDescription(memoDtlCO);
	alertsParamCO.setAlertDescription(alertDescription);

	NumberUtil.resetEmptyValues(alertsParamCO);
	return alertsParamCO;
    }

    private AlertsParamCO checkSendAlert(AlertsParamCO alertParams, Boolean isNewAction, String status, String pageRef)
	    throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	// TODO OR ib_alert_mode = TRUE
	if("1".equals(sessionCO.getCtsTellerVO().getUSER_IS_BRANCH_MANAGER()))
	{
	    alertParams.setAllowToSend(BigDecimal.ZERO);
	    return alertParams;
	}

	AlertsSC alertSC = new AlertsSC();
	alertSC.setCompCode(sessionCO.getCompanyCode());
	alertSC.setBranchCode(sessionCO.getBranchCode());
	alertSC.setAppName(sessionCO.getCurrentAppName());
	alertSC.setAlertType(AlertsConstants.MEMO_ALERT_TYPE);
	alertSC.setProgRef(pageRef);
	alertSC.setStatus(status);
	alertSC.setUserId(sessionCO.getUserName());

	// In case of update of a new record, we should check separately if the
	// update action should send an alert
	// amend
	if(!isNewAction && MemoConstants.STATUS_ACTIVE.equals(status))
	{
	    alertSC.setAlertAddCode(AlertsConstants.MEMO_ALERT_ADD_CODE_MI);
	    CTSCONTROL_ALERTVO ctsControlAlert = alertsBO.returnCtsControlAlert(alertSC);

	    if(ctsControlAlert != null && "1".equals(ctsControlAlert.getACTIVATE()))
	    {
		alertParams.setAllowToSend(BigDecimal.ONE);
		// Set the next progref to be saved in S_TODO_DET.TODO_PROG_REF
		alertParams.setProgRef(AlertsConstants.MEMO_PAGE_M001P);
		// Set the TODO_EXCEP in S_TODO_DET
		alertParams.setTodoExcepEnglish(translateKeyByLang(AlertsConstants.MEMO_TODO_EXCEP_ON_UPDATE,
			ConstantsCommon.LANGUAGE_ENGLISH));
		alertParams.setTodoExcepArabic(translateKeyByLang(AlertsConstants.MEMO_TODO_EXCEP_ON_UPDATE,
			ConstantsCommon.LANGUAGE_ARABIC));
	    }
	    else
	    {
		alertParams.setAllowToSend(BigDecimal.ZERO);
	    }

	}
	else
	{
	    // Check if the alert should be sent and return the next progref
	    String nextProgRef = alertsBO.returnAlertsNextProgRefByStatus(alertSC);
	    if(nextProgRef == null)
	    {
		alertParams.setAllowToSend(BigDecimal.ZERO);
	    }
	    else
	    {
		alertParams.setAllowToSend(BigDecimal.ONE);
		alertParams.setProgRef(nextProgRef);
		// Set the TODO_EXCEP in S_TODO_DET
		String todoExcepKey = MessageFormat.format(AlertsConstants.ALERT_TODO_EXCEP_PATTERN,
			AlertsConstants.MEMO_TODO_ALERT, nextProgRef);
		alertParams.setTodoExcepEnglish(translateKeyByLang(todoExcepKey, ConstantsCommon.LANGUAGE_ENGLISH));
		alertParams.setTodoExcepArabic(translateKeyByLang(todoExcepKey, ConstantsCommon.LANGUAGE_ARABIC));
	    }
	}
	//Jean-Louis BB140189
	memoDtlCO = memoDtlBO.checkKYC(memoDtlCO);
	if(memoDtlCO.getAlertsParamCO().getTodoExcepEnglish() != null
		&& memoDtlCO.getAlertsParamCO().getTodoExcepEnglish().indexOf("A_CIF_KYC_OUTSTANDINIG_TODO_EXCEP") != -1)
	{
	    if(StringUtil.isNotEmpty(alertParams.getTodoExcepEnglish()))
	    {
		StringBuffer exception = new StringBuffer(alertParams.getTodoExcepEnglish());
		exception.append(", " + memoDtlCO.getAlertsParamCO().getTodoExcepEnglish());
		alertParams.setTodoExcepEnglish(translateMatchingMessageByLang(exception.toString(),
			ConstantsCommon.LANGUAGE_ENGLISH));
		alertParams.setTodoExcepArabic(translateMatchingMessageByLang(exception.toString(),
			ConstantsCommon.LANGUAGE_ARABIC));
	    }
	    else
	    {
		alertParams.setTodoExcepEnglish(translateMatchingMessageByLang(memoDtlCO.getAlertsParamCO()
			.getTodoExcepEnglish(), ConstantsCommon.LANGUAGE_ENGLISH));
		alertParams.setTodoExcepArabic(translateMatchingMessageByLang(memoDtlCO.getAlertsParamCO()
			.getTodoExcepEnglish(), ConstantsCommon.LANGUAGE_ARABIC));
	    }
	}
	return alertParams;
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
	    applyMemoDetailAlertsData(receivedAlertParamCO, sessionCO);
	    memoDtlBO.checkMemoDtls(memoDtlCO);

	    String[] optDetailsArray = returnCommonLibBO().returnOptDetailsList(sessionCO.getCurrentAppName(),
		    receivedAlertParamCO.getProgRef().trim());
	    if(optDetailsArray != null && optDetailsArray.length > 0)
	    {
		String ivCrud = optDetailsArray[2];
		if(MemoConstants.IV_CRUD_P.equals(ivCrud))
		{
		    // Calling the approve method for Memo Detail.
		    memoDtlCO.getAlertsParamCO().setTodoAlert(AlertsConstants.MEMO_ACK_APPROVE);
		    approve();
		}
		else if(MemoConstants.IV_CRUD_S.equals(ivCrud))
		{
		    // Calling the method for Memo Detail.
		    memoDtlCO.getAlertsParamCO().setTodoAlert(AlertsConstants.MEMO_ACK_SUSPEND);
		    suspend();
		}
		else if(MemoConstants.IV_CRUD_N.equals(ivCrud))
		{
		    // Calling the cancel method for Memo Detail.
		    memoDtlCO.getAlertsParamCO().setTodoAlert(AlertsConstants.MEMO_ACK_CANCEL);
		    cancel();
		}
		else if(MemoConstants.IV_CRUD_A.equals(ivCrud))
		{
		    // Calling the cancel method for Memo Detail.
		    memoDtlCO.getAlertsParamCO().setTodoAlert(AlertsConstants.MEMO_ACK_REACTIVATE);
		    reactivate();
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
	    AlertsParamCO receivedAlertParamCO = get_alert();
	    applyMemoDetailAlertsData(receivedAlertParamCO, sessionCO);
	    memoDtlCO.getAlertsParamCO().setTodoAlert(AlertsConstants.MEMO_ACK_REJECT);
	    // the reject method will call checkMemoDtls() and if its the same
	    // status then it will reject the recording of links management
	    memoDtlBO.rejectMemoDtls(memoDtlCO);

	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}

	// Set _alert to null to avoid opening the sendAlert popup
	set_alert(null);

	return AlertsConstants.ALERT_JSON_SUCCESS;
    }

    /**
     * @author hibaoweidat
     * @param receivedAlertParamCO
     * @param sessionCO
     * @param currentSTodoDet
     */
    private S_TODO_DETVO applyMemoDetailAlertsData(AlertsParamCO receivedAlertParamCO, SessionCO sessionCO)
	    throws BaseException
    {

	S_TODO_DETVO currentSTodoDet = new S_TODO_DETVO();
	currentSTodoDet.setTODO_CODE(receivedAlertParamCO.getTodoCode());
	currentSTodoDet.setTODO_LINE(receivedAlertParamCO.getTodoLine());
	receivedAlertParamCO.setOldTodoAlert(receivedAlertParamCO.getTodoAlert());
	memoDtlCO.setIsFromAlert(Boolean.TRUE.toString());
	memoDtlCO.setRunningDate(DateUtil.addHourAndMinutesToDate(sessionCO.getRunningDateRET()));
	if(Boolean.valueOf(receivedAlertParamCO.getIsLocalApprove()))
	{
	    // If this action is called from local approve. the local
	    // approve user name is set in linksManagement
	    memoDtlCO.setLoginCompCode(sessionCO.getCompanyCode());
	    memoDtlCO.setLoginBraCode(sessionCO.getBranchCode());
	    memoDtlCO.getCtsMemoDetVO().setCOMP_CODE(sessionCO.getCompanyCode());
	    memoDtlCO.getCtsMemoDetVO().setBRANCH_CODE(sessionCO.getBranchCode());
	    memoDtlCO.setUserName(sessionCO.getLocalApproveUserName());
	    receivedAlertParamCO.setAppName(sessionCO.getCurrentAppName());
	    receivedAlertParamCO.setUserId(sessionCO.getLocalApproveUserName());
	}
	else
	{
	    currentSTodoDet = alertsBO.returnSTodoDet(currentSTodoDet);
	    memoDtlCO.setLoginCompCode(currentSTodoDet.getCOMP_CODE());
	    memoDtlCO.setLoginBraCode(currentSTodoDet.getBRANCH_CODE());
	    memoDtlCO.getCtsMemoDetVO().setCOMP_CODE(currentSTodoDet.getCOMP_CODE());
	    memoDtlCO.getCtsMemoDetVO().setBRANCH_CODE(currentSTodoDet.getBRANCH_CODE());
	    memoDtlCO.setUserName(sessionCO.getUserName());
	    receivedAlertParamCO.setUserId(sessionCO.getUserName());
	}
	memoDtlCO.setAlertsParamCO(receivedAlertParamCO);
	return currentSTodoDet;
    }

    
    /**
     * This function is called after clicking on the details button when receiving an alert.
     * @return
     * @throws BaseException
     */
    public String loadAlertMemoDetails() throws BaseException
    {
	try
	{
	    // Jean-Louis BB140189
	    String memoAlertDesc = prepareAlertMemoDescription(memoDtlCO);
	    memoDtlCO.getAlertsParamCO().setAlertDescription(memoAlertDesc);
	    if(StringUtil.isNotEmpty(memoAlertDesc)
		    && memoAlertDesc.indexOf(getText("A_CIF_KYC_OUTSTANDINIG_TODO_EXCEP")) != -1)
	    {
		memoDtlCO.getAlertsParamCO().setDetailsColor("red");
	    }
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return AlertsConstants.ALERT_JSON_SUCCESS;
    }

    private String prepareAlertMemoDescription(MemoDtlCO memoDtlParamCO) throws BaseException
    {
	MemoDtlCO memoDtlCO = memoDtlParamCO; 
	SessionCO sessionCO = returnSessionObject();
	memoDtlCO.setLanguage(sessionCO.getLanguage());
	memoDtlCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
	memoDtlCO = memoDtlBO.loadAlertMemoDetails(memoDtlCO);
	// Jean-Louis BB140189
	StringBuffer trxDescription = new StringBuffer(memoDtlCO.getAlertsParamCO().getAlertDescription());
	if(memoDtlParamCO.getAlertsParamCO().getTodoExcepEnglish() != null
		&& StringUtil.isNotEmpty(memoDtlParamCO.getAlertsParamCO().getTodoExcepEnglish()))
	{
	    trxDescription.append(", "
		    + translateMatchingMessage(memoDtlParamCO.getAlertsParamCO().getTodoExcepEnglish()));
	}
	return translateMatchingMessageByLang(trxDescription.toString(), sessionCO.getLanguage());
    }
    
    /**
     * This function is to grant access privileges to the save button
     * @return String
     * @param memoDtlBO
     * @author johnmassaad
     */
    public void fillMenuOptions() throws BaseException
    {
	if((MemoConstants.CRUD_MAINTENANCE).equals(getIv_crud()))
	{
	    if(NumberUtil.isEmptyDecimal(memoDtlCO.getCtsMemoDetVO().getTRX_NO()))
	    {
		accessMenu = MemoConstants.PARENT_OPT+MemoConstants.REFERENCE_CREATE;
	    }
	    else
	    {
		accessMenu = MemoConstants.PARENT_OPT+MemoConstants.REFERENCE_UPDATE;
	    }
	}
	else if((MemoConstants.CRUD_UPDATE_AFTER_APPROVE).equals(getIv_crud()))
	{
	    accessMenu = MemoConstants.PARENT_OPT+MemoConstants.REFERENCE_UPDATE_AFTER_APPROVE;
	}
   }
    //
    // public CTSMEMOVOKey getCtsMemoVOKey() {
    // return ctsMemoVOKey;
    // }
    //
    // public void setCtsMemoVOKey(CTSMEMOVOKey ctsMemoVOKey) {
    // this.ctsMemoVOKey = ctsMemoVOKey;
    // }

    /**
     * @author Sarah Elhusseini
     * dependency by account add reference
     */
    public String dependencyByAddRef()
    {
	try
	{
	    if(memoDtlCO.getAccRef() == null || "".equals(memoDtlCO.getAccRef()))
	    {
		account = new AMFVO();
	    }
	    else
	    {
		SessionCO sessionCO = returnSessionObject();
		AccountSC criteria = new AccountSC();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setUserId(sessionCO.getUserName());
		criteria.setLangCode(sessionCO.getLanguage());
		criteria.setDisplayMsg(BigDecimal.ONE);
		criteria.setLovType(ConstantsCommon.STATUS_LOV);
		criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		criteria.setAddRef(memoDtlCO.getAccRef());
		
		//habib accocunt restriction 372747
		String originalProgRef = StringUtil.nullEmptyToValue(returnCommonLibBO().returnOrginProgRef(
			 sessionCO.getCurrentAppName(), get_pageRef()), get_pageRef());
		criteria.setCurrAppName(sessionCO.getCurrentAppName());
		criteria.setPageRef(originalProgRef);
		
		AMFVO accResult = memoDtlBO.returnAccountByReference(criteria);

		if(accResult == null)
		{
		    account = new AMFVO();
		}
		else
		{
		    account.setBRIEF_NAME_ENG(accResult.getBRIEF_NAME_ENG());
		    account.setADDITIONAL_REFERENCE(accResult.getADDITIONAL_REFERENCE());
		    account.setBRANCH_CODE(accResult.getBRANCH_CODE());
		    account.setCURRENCY_CODE(accResult.getCURRENCY_CODE());
		    account.setGL_CODE(accResult.getGL_CODE());
		    account.setCIF_SUB_NO(accResult.getCIF_SUB_NO());
		    account.setSL_NO(accResult.getSL_NO());
		    account.setCurrrencyDesc(accResult.getCurrrencyDesc());
		    account.setCifDesc(accResult.getCifDesc());
		    account.setAccountType(accResult.getAccountType());
		    account.setGMI_FLAG(accResult.getGMI_FLAG());
		}

		MemoSC memoSC = new MemoSC();
		memoSC.setCompCode(criteria.getCompCode());
		memoSC.setForAccOrCif("A");
		memoSC.setCifNo(account.getCIF_SUB_NO());
		memoSC.setAccBR(account.getBRANCH_CODE());
		memoSC.setAccCY(account.getCURRENCY_CODE());
		memoSC.setAccGL(account.getGL_CODE());
		memoSC.setAccCIF(account.getCIF_SUB_NO());
		memoSC.setAccSL(account.getSL_NO());
		memoSC.setLovType(MemoConstants.LOV_TYPE);
		memoSC.setLangCode(criteria.getLangCode());
		checkForMemo(memoSC);
	    }
	}
	catch(Exception ex)
	{
	    account.setADDITIONAL_REFERENCE(null);
	    handleException(ex, null, null);
	}

	return "success_json";
    }
    
    
    public CTSMEMO_DETVOKey getCtsMemoDetVOKey()
    {
	return ctsMemoDetVOKey;
    }

    public void setCtsMemoDetVOKey(CTSMEMO_DETVOKey ctsMemoDetVOKey)
    {
	this.ctsMemoDetVOKey = ctsMemoDetVOKey;
    }

    public MemoDtlCO getMemoDtlCO()
    {
	return memoDtlCO;
    }

    public void setMemoDtlCO(MemoDtlCO memoDtlCO)
    {
	this.memoDtlCO = memoDtlCO;
    }

    // public CTSMEMOVO getCtsMemoVO() {
    // return ctsMemoVO;
    // }
    //
    // public void setCtsMemoVO(CTSMEMOVO ctsMemoVO) {
    // this.ctsMemoVO = ctsMemoVO;
    // }

    public Date getDate()
    {
	return date;
    }

    public void setDate(Date date)
    {
	this.date = date;
    }

    public boolean getDateValid()
    {
	return dateValid;
    }

    public void setDateValid(boolean dateValid)
    {
	this.dateValid = dateValid;
    }

    public String getActionType()
    {
	return actionType;
    }

    public void setActionType(String actionType)
    {
	this.actionType = actionType;
    }

    public String get_toolBarMode()
    {
	return _toolBarMode;
    }

    public void set_toolBarMode(String toolBarMode)
    {
	_toolBarMode = toolBarMode;
    }

    public boolean isAccReadOnlyMode()
    {
	return Boolean.valueOf(get_recReadOnly()) ? true : accReadOnlyMode; // if
	// the
	// full
	// page
	// is
	// in
	// readonly
	// then
	// return
	// true
	// or
	// else
	// accReadOnly
	// value
    }

    public void setAccReadOnlyMode(boolean accReadOnlyMode)
    {
	this.accReadOnlyMode = accReadOnlyMode;
    }

    public boolean isDateIntrvlReadOnlyMode()
    {
	return Boolean.valueOf(get_recReadOnly()) ? true : dateIntrvlReadOnlyMode; // if
	// the
	// full
	// page
	// is
	// in
	// readonly
	// then
	// return
	// true
	// or
	// else
	// dateIntrvlReadOnly
	// value
    }

    public void setDateIntrvlReadOnlyMode(boolean dateIntrvlReadOnlyMode)
    {
	this.dateIntrvlReadOnlyMode = dateIntrvlReadOnlyMode;
    }

    public void setAlertsBO(AlertsBO alertsBO)
    {
	this.alertsBO = alertsBO;
    }

    public String getAccessMenu()
    {
        return accessMenu;
    }

    public void setAccessMenu(String accessMenu)
    {
        this.accessMenu = accessMenu;
    }

    public AMFVO getAccount()
    {
        return account;
    }

    public void setAccount(AMFVO account)
    {
        this.account = account;
    }

    public void setMemoDtlBO(MemoBO memoDtlBO)
    {
        this.memoDtlBO = memoDtlBO;
    }
}
