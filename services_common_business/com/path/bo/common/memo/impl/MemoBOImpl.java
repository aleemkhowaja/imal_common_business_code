package com.path.bo.common.memo.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.memo.MemoBO;
import com.path.bo.common.memo.MemoConstants;
import com.path.bo.core.account.AccountBO;
import com.path.bo.core.common.CoreCommonBO;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.dao.common.memo.MemoDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSCONTROL_ALERTVO;
import com.path.dbmaps.vo.CTSMEMOVO;
import com.path.dbmaps.vo.CTSMEMOVOKey;
import com.path.dbmaps.vo.CTSMEMO_DETVO;
import com.path.dbmaps.vo.CTS_CONDITIONAL_AUTOMATIONVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.BaseSC;
import com.path.struts2.lib.common.ConnectionCO;
import com.path.vo.common.CheckRequiredCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.audit.TrackPropCO;
import com.path.vo.common.memo.MemoCO;
import com.path.vo.common.memo.MemoDtlCO;
import com.path.vo.common.memo.MemoDtlLogCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.common.smart.SmartSC;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.conditionalautomation.ConditionalAutomationCO;

public class MemoBOImpl extends BaseBO implements MemoBO
{

    private MemoDAO memoDAO;
    private AlertsBO alertsBO;
    private CoreCommonBO coreCommonBO;
    protected AccountBO accountBO;
    CoreCommonServiceBO coreCommonServiceBO;
    
    public void setMemoDAO(MemoDAO memoDAO)
    {
	this.memoDAO = memoDAO;
    }

    public MemoDAO getMemoDAO()
    {
	return memoDAO;
    }
    
    public AlertsBO getAlertsBO()
    {
	return alertsBO;
    }

    public void setAlertsBO(AlertsBO alertsBO)
    {
	this.alertsBO = alertsBO;
    }

    /**
     * checks whether there is any memo available based on the criteria
     */
    @Override
    public boolean isMemoAvailable(MemoSC memoSC) throws BaseException
    {
		/**
		 * Connection object is required to connect with core db
		 * It is required when the CORE_IMAL_YN = 'N' in PthCtrl1 table
		 * the application which call this method which is standalone.
		 */
		if(ConstantsCommon.NO.equals(StringUtil.nullToEmpty(commonLibBO.returnPthCtrl1().getCORE_IMAL_YN())))
		{
		    BaseSC sc = new BaseSC();
		    String jndiname = "services.jndi";
		    sc.setUseConnection(memoSC.getUseConnection());
		    CommonMethods.applyConnectionJNDIToSC(sc, jndiname);	
		    memoSC.setConnCO(sc.getConnCO());
		}
		
		return memoDAO.returnCountAvailableMemo(memoSC) != 0;
    }

    /**
     * returns memo list
     */
    @Override
    public ArrayList<MemoCO> getMemoList(MemoSC memoSC) throws BaseException
    {
	return memoDAO.getMemoList(memoSC);
    }

    /**
     * returns count of memo list
     */
    @Override
    public Integer getMemoCount(MemoSC memoSC) throws BaseException
    {
	return memoDAO.getMemoCount(memoSC);
    }

    /**
     * returns memo details list count
     */
    @Override
    public Integer getMemoDtlListCount(MemoSC memoSC) throws BaseException
    {
	return memoDAO.getMemoDtlListCount(memoSC);
    }

    /**
     *return memo details list
     */
    @Override
    public ArrayList<MemoCO> getMemoDtlList(MemoSC memoSC) throws BaseException
    {
	return memoDAO.getMemoDtlList(memoSC);
    }
    
    @Override
    public MemoSC returnMemoDtlList(MemoSC criteria) throws BaseException
    {
		// Habib Baalbaki accocunt restriction 372747
		AccountSC accountSC = new AccountSC();
		accountSC.setCurrAppName(criteria.getCurrAppName());
		accountSC.setPageRef(criteria.getPageRef());
		accountSC.setUserId(criteria.getUserId());
		accountSC.setCompCode(criteria.getCompCode());
		accountBO.callFillAccRestricted(accountSC);

		int result = 0;
		if (criteria.isCheckNbRec())
		{
			result = getMemoDtlListCount(criteria);
			criteria.setTrxMgntNbRecords(result);
		}
		if (criteria.isCheckNbRec() && result == 0)
		{
			criteria.setSidx(null);
			criteria.setSord(null);
		}
		List<MemoCO> amfList = getMemoDtlList(criteria);
		criteria.setListRecords(amfList);
		return criteria;
    }
    
    

    /**
     * returns memo details form data based on criteria
     */
    @Override
    public MemoDtlCO getMemoFormData(MemoDtlCO memoDtlCO) throws BaseException
    {
	return memoDAO.getMemoFormData(memoDtlCO);
    }

    /**
     * returns memo list
     */
    @Override
    public ArrayList<CTSMEMOVO> getCtsMemoList(MemoSC memoSC) throws BaseException
    {
	return memoDAO.getCtsMemoList(memoSC);
    }

    /**
     * returns memo count
     */
    @Override
    public Integer getCtsMemoCount(MemoSC memoSC) throws BaseException
    {
	return memoDAO.getCtsMemoCount(memoSC);
    }

    /**
     * return Memo log count
     */
    @Override
    public ArrayList<MemoDtlLogCO> getCtsMemoLogList(MemoSC memoSC) throws BaseException
    {
	return memoDAO.getCtsMemoLogList(memoSC);
    }

    /**
     * return Memo log count
     */
    @Override
    public Integer getCtsMemoLogCount(MemoSC memoSC) throws BaseException
    {
	return memoDAO.getCtsMemoLogCount(memoSC);
    }

    /**
     * return memo object based on criteria for lookup
     */
    @Override
    public CTSMEMOVO getMemoById(CTSMEMOVOKey ctsMemoVOKey) throws BaseException
    {
	return memoDAO.getMemoById(ctsMemoVOKey);
    }

    /**
     * Review memo
     * 
     * @param memoDAO
     */

    public void reviewMemo(ArrayList<MemoCO> reviewMemoList, MemoSC memoSC) throws BaseException
    {
	if(reviewMemoList != null && !reviewMemoList.isEmpty())
	{
	    //Bassam Eid - BUG# 681162
	    int i = 0;
	    for(MemoCO memoCO : reviewMemoList)
	    {
		memoCO.getCtsmemoDETVO().setCOMP_CODE(memoSC.getCompCode());
		memoDAO.reviewMemo(memoCO.getCtsmemoDETVO());
		updateMemoLog(memoCO.getCtsmemoDETVO(), memoSC);
		//NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
		if(ConstantsCommon.RET_APP_NAME.equals(memoSC.getAppName()))
		{
		    memoSC.setEventType(reviewMemoList.get(i).getEventType());
		    memoSC.setCifAccNo(reviewMemoList.get(i).getCtsmemoDETVO().getCIF_NO());
		    checkMemoConditionalAutomation(memoCO.getCtsmemoDETVO(), memoSC);
		}
		i++;
	    }
	}
    }
    
    /**
     * NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation 
     * @throws BaseException
     */
    private void checkMemoConditionalAutomation(CTSMEMO_DETVO ctsMemoDETVO, MemoSC memoSC)throws BaseException
    {
	//Check the CONDITIONAL AUTOMATION CODE from the memo table
	if(!NumberUtil.isEmptyDecimal(ctsMemoDETVO.getCOND_AUTOMATION_CODE()))
	{
	    //Bassam Eid - BUG# 681162
	    BigDecimal eventType = new BigDecimal(3);
	    if(!NumberUtil.isEmptyDecimal(memoSC.getEventType()))
	    {
		eventType = memoSC.getEventType();
	    }
	    //////////////////////////
	    List<CTS_CONDITIONAL_AUTOMATIONVO> ctsConditionalAutomationVOList = coreCommonBO
		    .returnConditionalAutomationList(memoSC.getCompCode(), "S", eventType, null,
			    BigDecimal.ONE, ctsMemoDETVO.getCOND_AUTOMATION_CODE(),null);
	    if(ctsConditionalAutomationVOList != null && !ctsConditionalAutomationVOList.isEmpty())
	    {
		List<BigDecimal> condAutoList = new ArrayList<BigDecimal>();
		for(CTS_CONDITIONAL_AUTOMATIONVO ctsCondAuto : ctsConditionalAutomationVOList)
		{
		    condAutoList.add(ctsCondAuto.getCODE());
		}
		//Deleting the related special condition that are created from a conditional automation
		//that was linked to the conditional automation that created this memo
		ConditionalAutomationCO conditionalAutomationCO = new ConditionalAutomationCO();
		conditionalAutomationCO.setRunningDate(memoSC.getRunningDate());
		conditionalAutomationCO.setLoginCompCode(memoSC.getCompCode());
		if(NumberUtil.isEmptyDecimal(ctsMemoDETVO.getCIF_NO()))
		{
		    conditionalAutomationCO.setCifNO(ctsMemoDETVO.getACC_CIF());
		}
		else
		{
		    conditionalAutomationCO.setCifNO(ctsMemoDETVO.getCIF_NO());
		}
		coreCommonBO.countDeleteSpecialCond(conditionalAutomationCO, Arrays.asList("P","TD"), "C", condAutoList);
		
		//Delete the memo in case the flag 'Delete Special Condition when reviewing memo' is checked
		//If the conditional automation that created this memo was linked by another conditional automation for a special condition.
		CTSMEMO_DETVO ctsMemoDetUpdate = new CTSMEMO_DETVO();
		ctsMemoDetUpdate.setCOMP_CODE(memoSC.getCompCode()); 
		ctsMemoDetUpdate.setBRANCH_CODE(ctsMemoDETVO.getBRANCH_CODE()); 
		ctsMemoDetUpdate.setTRX_NO(ctsMemoDETVO.getTRX_NO()); 
		ctsMemoDetUpdate.setSTATUS(MemoConstants.STATUS_CANCEL);
		ctsMemoDetUpdate.setDATE_CANCELLED(commonLibBO.addSystemTimeToDate(memoSC.getRunningDate()));
		ctsMemoDetUpdate.setCANCELLED_BY("SYSTEM");
		
		memoDAO.updateStatus(ctsMemoDetUpdate);
	    }
	}
    }
    
    private void updateMemoLog(CTSMEMO_DETVO ctsMemoDETVO, MemoSC memoSC) throws BaseException
    {
	NumberUtil.resetEmptyValues(ctsMemoDETVO);
	String type = memoSC.getType();
	if(type == null || type.isEmpty())
	{
	    if( NumberUtil.isEmptyDecimal(ctsMemoDETVO.getACC_BR())
		    || NumberUtil.isEmptyDecimal(ctsMemoDETVO.getACC_CY())
		    || NumberUtil.isEmptyDecimal(ctsMemoDETVO.getACC_GL())
		    || NumberUtil.isEmptyDecimal(ctsMemoDETVO.getACC_CIF())
		    || NumberUtil.isEmptyDecimal(ctsMemoDETVO.getACC_SL())) 
	    {
		if( !NumberUtil.isEmptyDecimal(ctsMemoDETVO.getCIF_NO()))
		{	
		    type = MemoConstants.CIF_TYPE;
		}
	    }
	    else
	    {
		type = MemoConstants.ACC_TYPE;
	    }
	}
	
	
	if(StringUtil.nullToEmpty(type).equals(MemoConstants.ACC_TYPE) || StringUtil.nullToEmpty(type).equals(MemoConstants.CIF_TYPE) ||
		StringUtil.nullToEmpty(type).equals("P") )
	{
	    
	    MemoDtlCO memoDtlCO = new MemoDtlCO();
	    memoDtlCO.setCtsMemoDetVO(ctsMemoDETVO);
	    memoDtlCO.setUserName(memoSC.getUserId());
	    memoDtlCO.setRunningDate(commonLibBO.addSystemTimeToDate(memoSC.getRunningDate()));
	    memoDtlCO.setType(memoSC.getType());
	    memoDAO.updateMemoLog(memoDtlCO);
	}
	
    }
    
    @Override
    public MemoDtlCO saveNew(MemoDtlCO memoDtlCO) throws BaseException
    {
	Object returnObj;
	
	//in case save method is called from webservice no need to call checkRequired, since it is already called
	if(memoDtlCO.getIntegAction() == null)
	{
	    /**
	     * mandatory fields management
	     */
	    CheckRequiredCO checkRequiredCO = new CheckRequiredCO();
	    checkRequiredCO.setObj_value(memoDtlCO);
	    checkRequiredCO.setOpt(memoDtlCO.getOpt());
	    checkRequiredCO.setCompCode(memoDtlCO.getCtsMemoDetVO().getCOMP_CODE());
	    checkRequiredCO.setLanguage(memoDtlCO.getLanguage());
	    checkRequiredCO.setApp(memoDtlCO.getApp());

	    /**
	     * Check Required Management ...
	     */
	    commonLibBO.checkRequired(checkRequiredCO);
	}

	/**
	 * check data management based on some business roles
	 */
	checkData(memoDtlCO);
	if(memoDtlCO.getCtsMemoVO().getCODE() == null || NumberUtil.isEmptyDecimal(memoDtlCO.getCtsMemoVO().getCODE()))
	{
	    // memoDtlCO.getCtsMemoDetVO().setCOMP_CODE(memoDtlCO.getLoginCompCode());
	    // memoDtlCO.getCtsMemoDetVO().setBRANCH_CODE(memoDtlCO.getLoginBraCode());

	    Boolean bContinue = false;
	    BigDecimal trsNo;
	    do
	    {
		trsNo = commonLibBO.returnCTSCTR(memoDtlCO.getCtsMemoDetVO().getCOMP_CODE()
			, memoDtlCO.getCtsMemoDetVO().getBRANCH_CODE(), "3", "C"
			, memoDtlCO.getApp(), memoDtlCO.getLoginUserId(), memoDtlCO.getOpt());

		if(trsNo == null || trsNo.intValue() == -1)
		{
		    throw new BOException(1325);
		}
		else
		{
		    CTSMEMO_DETVO ctsMemoDetVO = new CTSMEMO_DETVO();

		    ctsMemoDetVO.setCOMP_CODE(memoDtlCO.getCtsMemoDetVO().getCOMP_CODE());
		    ctsMemoDetVO.setBRANCH_CODE(memoDtlCO.getCtsMemoDetVO().getBRANCH_CODE());
		    ctsMemoDetVO.setTRX_NO(trsNo);

		    returnObj = genericDAO.selectByPK(ctsMemoDetVO);

		    if(returnObj == null)
		    {
			bContinue = true;
		    }
		}

	    }while(Boolean.FALSE.equals(bContinue));
	    memoDtlCO.getCtsMemoDetVO().setTRX_NO(trsNo);
	}

	
	CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();

	Date dateToSetTime = ctsMemoDetVO.getDATE_CREATED();
	ctsMemoDetVO.setDATE_CREATED(commonLibBO.addSystemTimeToDate(dateToSetTime));
	/**
	 * Audit Management ...
	 */
	AuditRefCO refCO = memoDtlCO.getAuditRefCO();
	refCO.setOperationType(AuditConstant.CREATED);
	refCO.setKeyRef(AuditConstant.MEMO_DTL_KEY_REF);
	/**
	 * Smart Management
	 */
	SmartSC smartSC = new SmartSC();
	smartSC.setAppName(refCO.getAppName());
	smartSC.setCompCode(ctsMemoDetVO.getCOMP_CODE());
	smartSC.setBranchCode(ctsMemoDetVO.getBRANCH_CODE());
	smartSC.setRunningDate(refCO.getRunningDate());
	smartSC.setUserId(refCO.getUserID());
	smartSC.setProgRef(refCO.getProgRef());
	smartSC.setLanguage(memoDtlCO.getLanguage());
	smartBO.validateAndUpdateSmartDetails(memoDtlCO.getSmartCOList(), smartSC, refCO, ctsMemoDetVO);
	

	genericDAO.insert(ctsMemoDetVO);
	
	
	
	
	auditBO.callAudit(null, ctsMemoDetVO, refCO);
	return memoDtlCO;

    }

    /**
     * Check the data that we are going to submit, based on some business roles
     * 
     * @param linkCifAmf
     * @throws BaseException
     */
    private void checkData(MemoDtlCO memoDtlCO) throws BaseException
    {
	ArrayList<BaseException> lst = new ArrayList<BaseException>();
	BaseException baseEx = null;
	if("1".equals(memoDtlCO.getCtsMemoVO().getCIF_SPECIFIC())
		&& (memoDtlCO.getCtsMemoDetVO().getCIF_NO().intValue() < 0 || null == memoDtlCO.getCtsMemoDetVO().getCIF_NO()) )
	{
	    baseEx = new BaseException(MemoConstants.CIF_MANDATORY);
	    lst.add(baseEx);

	}
	if("1".equals(memoDtlCO.getCtsMemoVO().getACC_SPECIFIC())
		&& (memoDtlCO.getCtsMemoDetVO().getACC_BR().intValue() < 0 || null == memoDtlCO.getCtsMemoDetVO().getACC_BR())
		&& (memoDtlCO.getCtsMemoDetVO().getACC_GL().intValue() < 0 || null == memoDtlCO.getCtsMemoDetVO().getACC_GL())
		&& (memoDtlCO.getCtsMemoDetVO().getACC_SL().intValue() < 0 || null == memoDtlCO.getCtsMemoDetVO().getACC_SL())
		&& (memoDtlCO.getCtsMemoDetVO().getACC_CY().intValue() < 0 || null == memoDtlCO.getCtsMemoDetVO().getACC_CY())
		&& (memoDtlCO.getCtsMemoDetVO().getACC_CIF().intValue() < 0 || null == memoDtlCO.getCtsMemoDetVO().getACC_CIF()))
	{
		baseEx = new BaseException(MemoConstants.ACC_NB_MANDATORY);
		lst.add(baseEx);
	}

	if("1".equals(memoDtlCO.getCtsMemoVO().getDATE_INTERVAL())
		&& ( null == memoDtlCO.getCtsMemoDetVO().getFROM_DATE()
			|| null == memoDtlCO.getCtsMemoDetVO().getDATE_TO()) )
	{
	    baseEx = new BaseException(MemoConstants.DATE_INT_MANDATORY);
	    lst.add(baseEx);
	}
	if(!lst.isEmpty())
	{
	    throw new BOException(lst);
	}
    }

    public void approve(MemoDtlCO memoDtlCO) throws BaseException
    {
	Date dateToSetTime = memoDtlCO.getCtsMemoDetVO().getDATE_APPROVED();
	memoDtlCO.getCtsMemoDetVO().setDATE_APPROVED(commonLibBO.addSystemTimeToDate(dateToSetTime));
	CTSMEMO_DETVO detVO = new CTSMEMO_DETVO();
	detVO.setDATE_APPROVED(memoDtlCO.getCtsMemoDetVO().getDATE_APPROVED());
	detVO.setAPPROVED_BY(memoDtlCO.getCtsMemoDetVO().getAPPROVED_BY());
	
	int errorCode = commonLibBO.validateMakerChecker(
		memoDtlCO.getCtsMemoDetVO().getCREATED_BY(),
		memoDtlCO.getCtsMemoDetVO().getAPPROVED_BY(),
		memoDtlCO.getOriginUserId());
	if(errorCode > 0)
	{
	    throw new BOException(errorCode);
	}
	
	callStatusUpdate(memoDtlCO, detVO);
	TrackPropCO trackCO = auditBO.copyAuditProps(memoDtlCO.getAuditRefCO());
	trackCO.setOperationType(AuditConstant.APPROVE); 
	trackCO.setVoMainPropRef("ctsMemoDetVO");
	//the newCO shall be null when we use this method upon approve/reject.
	auditBO.callTrackChanges(memoDtlCO.getAuditObj(), null, trackCO);
	// Send an acknowledge alert in case of remote approve through
	// openItem screen. In local approve the acknowledgment will not be
	// sent.
	if(memoDtlCO.getAlertsParamCO() != null && Boolean.valueOf(memoDtlCO.getIsFromAlert()))
	{
	    alertsBO.updateTodoAndSendAck(memoDtlCO.getAlertsParamCO());
	}
    }

    public void toCancel(MemoDtlCO memoDtlCO) throws BaseException
    {
	Date dateToSetTime = memoDtlCO.getCtsMemoDetVO().getTOBE_CANCELLED_DATE();
	memoDtlCO.getCtsMemoDetVO().setTOBE_CANCELLED_DATE(commonLibBO.addSystemTimeToDate(dateToSetTime));
	CTSMEMO_DETVO detVO = new CTSMEMO_DETVO();
	detVO.setTOBE_CANCELLED_DATE(memoDtlCO.getCtsMemoDetVO().getTOBE_CANCELLED_DATE());
	detVO.setTOBE_CANCELLED_BY(memoDtlCO.getCtsMemoDetVO().getTOBE_CANCELLED_BY());
	callStatusUpdate(memoDtlCO, detVO);
    }

    public void cancel(MemoDtlCO memoDtlCO) throws BaseException
    {
	Date dateToSetTime = memoDtlCO.getCtsMemoDetVO().getDATE_CANCELLED();
	memoDtlCO.getCtsMemoDetVO().setDATE_CANCELLED(commonLibBO.addSystemTimeToDate(dateToSetTime));
	CTSMEMO_DETVO detVO = new CTSMEMO_DETVO();
	detVO.setDATE_CANCELLED(memoDtlCO.getCtsMemoDetVO().getDATE_CANCELLED());
	detVO.setCANCELLED_BY(memoDtlCO.getCtsMemoDetVO().getCANCELLED_BY());
	callStatusUpdate(memoDtlCO, detVO);
	// Send an acknowledge alert in case of remote approve through
	// openItem screen. In local approve the acknowledgment will not be
	// sent.
	if(memoDtlCO.getAlertsParamCO() != null && Boolean.valueOf(memoDtlCO.getIsFromAlert()))
	{
	    alertsBO.updateTodoAndSendAck(memoDtlCO.getAlertsParamCO());
	}
    }

    public void toSuspend(MemoDtlCO memoDtlCO) throws BaseException
    {
	Date dateToSetTime = memoDtlCO.getCtsMemoDetVO().getTOBE_SUSPENDED_DATE();
	memoDtlCO.getCtsMemoDetVO().setTOBE_SUSPENDED_DATE(commonLibBO.addSystemTimeToDate(dateToSetTime));
	CTSMEMO_DETVO detVO = new CTSMEMO_DETVO();
	detVO.setTOBE_SUSPENDED_DATE(memoDtlCO.getCtsMemoDetVO().getTOBE_SUSPENDED_DATE());
	detVO.setTOBE_SUSPENDED_BY(memoDtlCO.getCtsMemoDetVO().getTOBE_SUSPENDED_BY());
	callStatusUpdate(memoDtlCO, detVO);
    }

    public void suspend(MemoDtlCO memoDtlCO) throws BaseException
    {
	Date dateToSetTime = memoDtlCO.getCtsMemoDetVO().getDATE_SUSPENDED();
	memoDtlCO.getCtsMemoDetVO().setDATE_SUSPENDED(commonLibBO.addSystemTimeToDate(dateToSetTime));
	CTSMEMO_DETVO detVO = new CTSMEMO_DETVO();
	detVO.setDATE_SUSPENDED(memoDtlCO.getCtsMemoDetVO().getDATE_SUSPENDED());
	detVO.setSUSPENDED_BY(memoDtlCO.getCtsMemoDetVO().getSUSPENDED_BY());
	callStatusUpdate(memoDtlCO, detVO);
	// Send an acknowledge alert in case of remote approve through
	// openItem screen. In local approve the acknowledgment will not be
	// sent.
	if(memoDtlCO.getAlertsParamCO() != null && Boolean.valueOf(memoDtlCO.getIsFromAlert()))
	{
	    alertsBO.updateTodoAndSendAck(memoDtlCO.getAlertsParamCO());
	}
    }

    public void reactivate(MemoDtlCO memoDtlCO) throws BaseException
    {
	Date dateToSetTime = memoDtlCO.getCtsMemoDetVO().getDATE_REACTIVATED();
	memoDtlCO.getCtsMemoDetVO().setDATE_REACTIVATED(commonLibBO.addSystemTimeToDate(dateToSetTime));
	CTSMEMO_DETVO detVO = new CTSMEMO_DETVO();
	detVO.setDATE_REACTIVATED(memoDtlCO.getCtsMemoDetVO().getDATE_REACTIVATED());
	detVO.setREACTIVATED_BY(memoDtlCO.getCtsMemoDetVO().getREACTIVATED_BY());
	callStatusUpdate(memoDtlCO, detVO);
	// Send an acknowledge alert in case of remote approve through
	// openItem screen. In local approve the acknowledgment will not be
	// sent.
	if(memoDtlCO.getAlertsParamCO() != null && Boolean.valueOf(memoDtlCO.getIsFromAlert()))
	{
	    alertsBO.updateTodoAndSendAck(memoDtlCO.getAlertsParamCO());
	}
    }

    public void toReactivate(MemoDtlCO memoDtlCO) throws BaseException
    {
	Date dateToSetTime = memoDtlCO.getCtsMemoDetVO().getTOBE_REACTIVATED_DATE();
	memoDtlCO.getCtsMemoDetVO().setTOBE_REACTIVATED_DATE(commonLibBO.addSystemTimeToDate(dateToSetTime));
	CTSMEMO_DETVO detVO = new CTSMEMO_DETVO();
	detVO.setTOBE_REACTIVATED_DATE(memoDtlCO.getCtsMemoDetVO().getTOBE_REACTIVATED_DATE());
	detVO.setTOBE_REACTIVATED_BY(memoDtlCO.getCtsMemoDetVO().getTOBE_REACTIVATED_BY());
	callStatusUpdate(memoDtlCO, detVO);
    }

    public void callStatusUpdate(MemoDtlCO memoDtlCO, CTSMEMO_DETVO detVO) throws BaseException
    {
	detVO.setSTATUS(memoDtlCO.getCtsMemoDetVO().getSTATUS());
	detVO.setCOMP_CODE(memoDtlCO.getCtsMemoDetVO().getCOMP_CODE());
	detVO.setBRANCH_CODE(memoDtlCO.getCtsMemoDetVO().getBRANCH_CODE());
	detVO.setTRX_NO(memoDtlCO.getCtsMemoDetVO().getTRX_NO());
	detVO.setDATE_UPDATED(memoDtlCO.getCtsMemoDetVO().getDATE_UPDATED());

	/*
	 * Update
	 */
	Integer row = memoDAO.updateStatus(detVO);

	/*
	 * Record Changed between retrieve and update
	 */
	if(row == null || row < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}

	MemoDtlCO oldMemoDtlCO = (MemoDtlCO) memoDtlCO.getAuditObj();
	auditBO.callAudit(oldMemoDtlCO.getCtsMemoDetVO(), memoDtlCO.getCtsMemoDetVO(), memoDtlCO.getAuditRefCO());
	auditBO.insertAudit(memoDtlCO.getAuditRefCO());
    }

    @Override
    public MemoDtlCO getMemo(MemoDtlCO memoDtlParamCO) throws BaseException
    {
	MemoDtlCO memoDtlCO = memoDtlParamCO;
	CTSMEMOVO ctsMemoVO = memoDtlCO.getCtsMemoVO();
	ctsMemoVO = memoDAO.getMemo(ctsMemoVO);

	if(null == ctsMemoVO)
	{
	    /*
	     * memoDtlCO = new MemoDtlCO();
	     * memoDtlCO.getCtsMemoDetVO().setMEMO_CODE(null);
	     * memoDtlCO.getCtsMemoVO().setBRIEF_DESC_ENG(null);
	     */
	    throw new BOException(MessageCodes.INVALID_CODE);
	}
	else
	{
	    memoDtlCO.setCtsMemoVO(ctsMemoVO);
	    if(!"L".equals(ctsMemoVO.getTYPE()))
	    {
		if("0".equals(ctsMemoVO.getDATE_INTERVAL()))
		{
		    memoDtlCO.setDateIntervalReadOnly("true");
		    memoDtlCO.getCtsMemoDetVO().setFROM_DATE(null);
		    memoDtlCO.getCtsMemoDetVO().setDATE_TO(null);
		}
		else
		{
		    memoDtlCO.setDateIntervalReadOnly(null);
		}
	    }
	    if("0".equals(ctsMemoVO.getCIF_SPECIFIC()))
	    {
		memoDtlCO.setCifReadOnly("true");
		memoDtlCO.getCtsMemoDetVO().setCIF_NO(null);
		memoDtlCO.setCifDesc(null);
	    }
	    else
	    {
		memoDtlCO.setCifReadOnly(null);
	    }
	    if("0".equals(ctsMemoVO.getACC_SPECIFIC()))
	    {

		if(null == memoDtlCO.getCtsMemoDetVO().getTRX_NO())
		{
		    memoDtlCO.getCtsMemoDetVO().setACC_BR(null);
		    memoDtlCO.getCtsMemoDetVO().setACC_CIF(null);
		    memoDtlCO.getCtsMemoDetVO().setACC_CY(null);
		    memoDtlCO.getCtsMemoDetVO().setACC_GL(null);
		    memoDtlCO.getCtsMemoDetVO().setACC_SL(null);
		    memoDtlCO.getCtsMemoDetVO().setACC_ADD_REF(null);
		    memoDtlCO.getCtsMemoDetVO().setACC_BR(null);
		}
		memoDtlCO.setAccReadOnly("true");
	    }
	    else
	    {
		memoDtlCO.setAccReadOnly(null);
	    }
	    
	    //Rania - 
	    if("0".equals(ctsMemoVO.getSEGMENT_SPECIFIC_YN()))
	    {
		memoDtlCO.getCtsMemoDetVO().setSEGMENT_CODE(null);
		memoDtlCO.setSegmentDesc(null);
		memoDtlCO.setSegmentReadOnly("true");
	    }
	    else
	    {
		memoDtlCO.setSegmentReadOnly(null);
	    }
	    //
	    
	    memoDtlCO = ctrlMandatoryFields(memoDtlCO);
	}
	return memoDtlCO;

    }

    public void update(MemoDtlCO memoDtlCO) throws BaseException
    {
	/**
	 * mandatory fields management
	 */
	CheckRequiredCO checkRequiredCO = new CheckRequiredCO();
	checkRequiredCO.setObj_value(memoDtlCO);
	checkRequiredCO.setOpt(memoDtlCO.getOpt());
	checkRequiredCO.setCompCode(memoDtlCO.getCtsMemoDetVO().getCOMP_CODE());
	checkRequiredCO.setLanguage(memoDtlCO.getLanguage());
	checkRequiredCO.setApp(memoDtlCO.getApp());

	/**
	 * Check Required Management ...
	 */
	commonLibBO.checkRequired(checkRequiredCO);

	/**
	 * check data management based on some business roles
	 */
	checkData(memoDtlCO);

	CTSMEMO_DETVO ctsMemoDetVO = memoDtlCO.getCtsMemoDetVO();
	 //Date dateToSetTime = ctsMemoDetVO.getDATE_CREATED(); //
	ctsMemoDetVO.setDATE_MODIFIED(commonLibBO.addSystemTimeToDate(ctsMemoDetVO.getDATE_MODIFIED()));
	ctsMemoDetVO.setDATE_UPDATED(memoDtlCO.getCtsMemoDetVO().getDATE_UPDATED());
	// genericDAO.update(ctsMemoDetVO);

	/*
	 * Update
	 */
	Integer row = memoDAO.updateStatus(ctsMemoDetVO);

	/*
	 * Record Changed between retrieve and update
	 */
	if(row == null || row < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}

	/**
	 * Audit Management ...
	 */
	// AuditRefCO refCO = memoDtlCO.getAuditRefCO();
	// refCO.setOperationType(AuditConstant.CREATED);
	// refCO.setKeyRef(AuditConstant.MEMO_DTL_KEY_REF);

	    AlertsSC AlertSC = new AlertsSC();
	    AlertSC.setCompCode(memoDtlCO.getAlertsParamCO().getCompCode());
	    AlertSC.setBranchCode(memoDtlCO.getAlertsParamCO().getBranchCode());
	    AlertSC.setAppName(memoDtlCO.getAlertsParamCO().getAppName());
	    AlertSC.setTodoAlert("'MJ'");
	    AlertSC.setTodoParam(memoDtlCO.getCtsMemoDetVO().getCIF_NO().toString());
	    AlertSC.setProgRef("M001P");
		  
	  
	  int resTodoByAlert =  coreCommonServiceBO.returnSTodoDetByAlert(AlertSC);
	
	MemoDtlCO auditCO = (MemoDtlCO) memoDtlCO.getAuditObj();
	auditBO.callAudit(auditCO.getCtsMemoDetVO(), memoDtlCO.getCtsMemoDetVO(), memoDtlCO.getAuditRefCO());
	auditBO.insertAudit(memoDtlCO.getAuditRefCO());
	if(StringUtil.isNotEmpty(memoDtlCO.getCtsMemoDetVO().getAPPROVED_BY())
		|| (resTodoByAlert> 0)
	   )
	{
	    TrackPropCO trackPropCO = auditBO.copyAuditProps(memoDtlCO.getAuditRefCO());
	    trackPropCO.setCoInstanceName("memoDtlCO");
	    trackPropCO.setVoMainPropRef("ctsMemoDetVO");
	    trackPropCO.setTrackVoMainPropRef(true);
	    trackPropCO.setVoPropertiesNames("ctsMemoDetVO");
	    auditBO.callTrackChanges(auditCO, memoDtlCO, trackPropCO);
	}
    }

    @Override
    public void delete(MemoDtlCO memoDtlCO) throws BaseException
    {
	Date dateToSetTime = memoDtlCO.getCtsMemoDetVO().getDATE_DELETED();
	memoDtlCO.getCtsMemoDetVO().setDATE_DELETED(commonLibBO.addSystemTimeToDate(dateToSetTime));
	CTSMEMO_DETVO detVO = new CTSMEMO_DETVO();
	detVO.setDATE_DELETED(memoDtlCO.getCtsMemoDetVO().getDATE_DELETED());
	detVO.setDELETED_BY(memoDtlCO.getCtsMemoDetVO().getDELETED_BY());
	callStatusUpdate(memoDtlCO, detVO);
    }

    /**
     * returns memo trx details list count
     * 
     * @param MemoSC
     * @return Integer
     * @throws BaseException
     */
    public Integer getMemoDtlTrxListCount(MemoSC memoSC) throws BaseException
    {
	return memoDAO.getMemoDtlTrxListCount(memoSC);
    }

    /**
     * return memo trx details list
     * 
     * @param MemoSC
     * @return
     * @throws BaseException
     */
    public ArrayList<MemoCO> getMemoDtlTrxList(MemoSC memoSC) throws BaseException
    {
	return memoDAO.getMemoDtlTrxList(memoSC);
    }

    /**
     * This function will check the status of the record in the DB if the same
     * like memoDtlCO.getCtsMemoDetVO().getSTATUS()
     * 
     * @author hibaoweidat
     * @param memoDtlCO
     * @return
     * @throws BaseException
     */
    public void checkMemoDtls(MemoDtlCO memoDtlCO) throws BaseException
    {
	// check if Memo record still has the same
	// status. PB = IF f_check_alert_trx_status(istr_alert) = -1 THEN

	CTSMEMO_DETVO memoVO = new CTSMEMO_DETVO();
	memoVO.setCOMP_CODE(memoDtlCO.getLoginCompCode());
	memoVO.setBRANCH_CODE(memoDtlCO.getLoginBraCode());
	memoVO.setTRX_NO(memoDtlCO.getCtsMemoDetVO().getTRX_NO());
	memoVO = (CTSMEMO_DETVO) genericDAO.selectByPK(memoVO);

	if(!(memoVO != null && memoVO.getSTATUS() != null && memoVO.getSTATUS().equals(
		memoDtlCO.getCtsMemoDetVO().getSTATUS()))
		&& memoDtlCO.getAlertsParamCO() != null)
	{
		S_TODO_DETVO currentSTodoDet = new S_TODO_DETVO();
		currentSTodoDet.setTODO_CODE(memoDtlCO.getAlertsParamCO().getTodoCode());
		currentSTodoDet.setTODO_LINE(memoDtlCO.getAlertsParamCO().getTodoLine());
		alertsBO.fUpdateTodo(currentSTodoDet, AlertsConstants.UPDATE_NO_TRX);
		throw new BOException(MessageCodes.TRANSACTION_STATUS_HAS_CHANGED);
	}
	// Check if the alerts has the same status
	if(memoDtlCO.getAlertsParamCO() != null && !Boolean.valueOf(memoDtlCO.getAlertsParamCO().getIsLocalApprove()))
	{
	    alertsBO.checkIfSameStatus(memoDtlCO.getAlertsParamCO());
	}

    }

    @Override
    public void rejectMemoDtls(MemoDtlCO memoDtlCO) throws BaseException
    {
	// check if same status
	checkMemoDtls(memoDtlCO);
	if(MemoConstants.STATUS_ACTIVE.equals(memoDtlCO.getCtsMemoDetVO().getSTATUS()))
	{
	    if(StringUtil.nullToEmpty(memoDtlCO.getCtsMemoDetVO().getAPPROVED_BY()).isEmpty() )
	    {
		memoDtlCO.getCtsMemoDetVO().setSTATUS(MemoConstants.STATUS_DELETE);
		memoDtlCO.getCtsMemoDetVO()
			.setDATE_DELETED(commonLibBO.addSystemTimeToDate(memoDtlCO.getRunningDate()));
		memoDtlCO.getCtsMemoDetVO().setDELETED_BY(memoDtlCO.getUserName());
	    }
	    else
	    {
		memoDtlCO.getCtsMemoDetVO().setSTATUS(MemoConstants.STATUS_ACTIVE);
	    }
	}
	else if(MemoConstants.STATUS_TO_SUSPEND.equals(memoDtlCO.getCtsMemoDetVO().getSTATUS())
		|| MemoConstants.STATUS_TO_CANCEL.equals(memoDtlCO.getCtsMemoDetVO().getSTATUS()))
	{
	    memoDtlCO.getCtsMemoDetVO().setSTATUS(MemoConstants.STATUS_APPROVE);
	}
	else if(MemoConstants.STATUS_TO_REACTIVATE.equals(memoDtlCO.getCtsMemoDetVO().getSTATUS()))
	{
	    memoDtlCO.getCtsMemoDetVO().setSTATUS(MemoConstants.STATUS_SUSPEND);
	}
	
	memoDAO.updateStatus(memoDtlCO.getCtsMemoDetVO());
	// Send an acknowledge alert in case of remote approve through
	// openItem screen. In local approve the acknowledgment will not be
	// sent.
	if(memoDtlCO.getAlertsParamCO() != null && Boolean.valueOf(memoDtlCO.getIsFromAlert()))
	{
	    alertsBO.updateTodoAndSendAck(memoDtlCO.getAlertsParamCO());
	}
	
    }
    
    
    /**
     * @author nabilfeghali
     */
    public MemoDtlCO loadAlertMemoDetails(MemoDtlCO memoDtlCO) throws BaseException
    {
	  MemoSC memoSC = new MemoSC();
	  memoSC.setCompCode(memoDtlCO.getAlertsParamCO().getCompCode());
	  memoSC.setBranchCode(memoDtlCO.getAlertsParamCO().getBranchCode());
	  memoSC.setTrxNo(new BigDecimal(memoDtlCO.getAlertsParamCO().getTodoParam()));
	  memoSC.setPreferredLanguage(memoDtlCO.getLoginPreferrredLanguage());
	  MemoDtlCO memoDtlCOData = memoDAO.loadAlertMemoDescription(memoSC);
	  if(memoDtlCOData != null )
	  {
	      StringBuffer description = new StringBuffer("");
	      description.append(" <Memo_Type_key> : " + StringUtil.nullToEmpty(memoDtlCOData.getCtsMemoVO().getBRIEF_DESC_ENG())+
	      			" , \n <Comments_key> : " + StringUtil.nullToEmpty(memoDtlCOData.getCtsMemoDetVO().getENG_COMENT()) + "\n");
	      
	      if("1".equals(memoDtlCOData.getCtsMemoVO().getCIF_SPECIFIC()) 
		      && memoDtlCOData.getCifDesc() != null 
		      && !memoDtlCOData.getCifDesc().isEmpty())
	      {
		  description.append(memoDtlCOData.getCifDesc());
	      }
	      
	      if("1".equals(memoDtlCOData.getCtsMemoVO().getACC_SPECIFIC()) 
		      && memoDtlCOData.getAC_DESC() != null 
		      && !memoDtlCOData.getAC_DESC().isEmpty())
	      {
		  description.append(memoDtlCOData.getAC_DESC());
	      }
	      
	      memoDtlCO.getAlertsParamCO().setAlertDescription(description.toString());
	  }
	  return memoDtlCO;
    }

    /**
     * @author Sarah Elhusseini
     * Set cif, account, date interval to mandatory
     *         when memo type is for specific cif, account or date interval
     *         is set to mandatory
     */
    public MemoDtlCO ctrlMandatoryFields(MemoDtlCO memoDtlParamsCO) throws BaseException
    {
	MemoDtlCO memoDtlCO = memoDtlParamsCO;
	/* Set CIF field to mandatory when memo is for specific CIF */
	if("1".equals(memoDtlCO.getCtsMemoVO().getCIF_SPECIFIC()))
	{
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("lookuptxt_cifNo", null,
			ConstantsCommon.ACTION_TYPE_MANDATORY, "1", memoDtlCO.getHm(), null));
	}
	else
	{
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("lookuptxt_cifNo", null,
			ConstantsCommon.ACTION_TYPE_MANDATORY, "0", memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("lookuptxt_cifNo", null, ConstantsCommon.ACTION_TYPE_READONLY, "1",
			memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().get("lookuptxt_cifNo").setOverWriteReadOnly(true);
	}

	/* Set Date interval to mandatory */
	if("1".equals(memoDtlCO.getCtsMemoVO().getDATE_INTERVAL()))
	{
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("fromDate", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "1", memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("toDate", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "1", memoDtlCO.getHm(), null));
	}
	else
	{
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("fromDate", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("toDate", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", memoDtlCO.getHm(), null));	}

	/* Set account to mandatory when memo is for specific account */
	if("1".equals(memoDtlCO.getCtsMemoVO().getACC_SPECIFIC()))
	{
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("tbl_pathAccount_account", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "1", memoDtlCO.getHm(), null));

	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("accBr", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "1", memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("accCy", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "1", memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("accGl", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "1", memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("accCif", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "1", memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("lookuptxt_accSl", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "1", memoDtlCO.getHm(), null));

	    /* Set CIF field value to null when memo is for specific account */
	    if(!"1".equals(memoDtlCO.getCtsMemoVO().getCIF_SPECIFIC()))
	    {
		memoDtlCO.getCtsMemoDetVO().setCIF_NO(null);
		memoDtlCO.setCifDesc(null);
	    }
	}
	else
	{
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("tbl_pathAccount_account", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", memoDtlCO.getHm(), null));

	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("accBr", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("accCy", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("accGl", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("accCif", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", memoDtlCO.getHm(), null));
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("lookuptxt_accSl", null,
		    ConstantsCommon.ACTION_TYPE_MANDATORY, "0", memoDtlCO.getHm(), null));
	}
	
	
	//Rania - 
	if("1".equals(memoDtlCO.getCtsMemoVO().getSEGMENT_SPECIFIC_YN()))
	{
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("lookuptxt_segmentCode", null, ConstantsCommon.ACTION_TYPE_MANDATORY, "1", memoDtlCO.getHm(), null));
	}
	else
	{
	    memoDtlCO.getHm().putAll(commonLibBO.applyDynScreenDisplay("lookuptxt_segmentCode", null, ConstantsCommon.ACTION_TYPE_MANDATORY, "0", memoDtlCO.getHm(), null));
	}
	
	return memoDtlCO;
    }

    public void setCoreCommonBO(CoreCommonBO coreCommonBO)
    {
        this.coreCommonBO = coreCommonBO;
    }

    public AMFVO returnAccountByReference(AccountSC criteria) throws BaseException
    {
	accountBO.checkAccountInAMF(criteria);
	return accountBO.returnAccountByReference(criteria);
    }

    public void setAccountBO(AccountBO accountBO)
    {
        this.accountBO = accountBO;
    }

    /**
     * BB140189
     * 
     * @author Jean-Louis
     * Check if KYC is outstanding 
     */
    public MemoDtlCO checkKYC(MemoDtlCO memoDtlCO) throws BaseException
    {
	CIFVO cifVO = new CIFVO();
	//Modified By nancy ---- 22/02/2018  - copying BMOUPI170577 from 14.0.14
	//Tony Nouh
	if (null == memoDtlCO.getLoginCompCode() )
	{
	    cifVO.setCOMP_CODE(memoDtlCO.getCtsMemoDetVO().getCOMP_CODE());
	}
	// end nancy
	cifVO.setCOMP_CODE(memoDtlCO.getLoginCompCode());
	if (null == memoDtlCO.getLoginCompCode() )
	{
	    cifVO.setCOMP_CODE(memoDtlCO.getCtsMemoDetVO().getCOMP_CODE());
	}
	// end nancy
	cifVO.setCIF_NO(memoDtlCO.getCtsMemoDetVO().getCIF_NO());
	cifVO = (CIFVO) genericDAO.selectByPK(cifVO);
	if(null != cifVO && (FomConstant.KYC_OUTSTANDING.equals(cifVO.getKYC_COMPLETED())
				|| FomConstant.KYC_COMPLETED_BY_CALL.equals(cifVO.getKYC_COMPLETED())
				|| FomConstant.KYC_RECALCITRANT.equals(cifVO.getKYC_COMPLETED()))) {
	    AlertsSC alertSC = new AlertsSC();
	    alertSC.setCompCode(memoDtlCO.getLoginCompCode());
	    alertSC.setBranchCode(memoDtlCO.getLoginBraCode());
	    alertSC.setAlertType(AlertsConstants.MEMO_ALERT_TYPE);
	    alertSC.setAlertAddCode(AlertsConstants.MEMO_ADD_CODE_KYC);

	    Map<String, CTSCONTROL_ALERTVO> alertControlMap = alertsBO.returnAllCtsControlAlert(alertSC);
	    // Check on KYC flag activation
		if(alertControlMap != null
		    && alertControlMap.containsKey(AlertsConstants.MEMO_ADD_CODE_KYC)
		    && "1".equals(alertControlMap.get(AlertsConstants.MEMO_ADD_CODE_KYC).getACTIVATE()))
	    {
		memoDtlCO.getAlertsParamCO().setAllowToSend(BigDecimal.ONE);
		if(StringUtil.isNotEmpty(memoDtlCO.getAlertsParamCO().getTodoExcepEnglish()))
		{
		    StringBuffer exceptionEng = new StringBuffer(memoDtlCO.getAlertsParamCO().getTodoExcepEnglish());
			if (FomConstant.KYC_COMPLETED_BY_CALL.equals(cifVO.getKYC_COMPLETED())) {//Abdo Dynamic KYC TP#382751
				exceptionEng.append(", " + AlertsConstants.ACCOUNT_TODO_EXCEP_CIF_KYC_COMPLETED_BY_CALL);
			} else if (FomConstant.KYC_RECALCITRANT.equals(cifVO.getKYC_COMPLETED())) {
				exceptionEng.append(", " + AlertsConstants.ACCOUNT_TODO_EXCEP_CIF_KYC_RECALCITRANT);
			} else {
				exceptionEng.append(", " + AlertsConstants.ACCOUNT_TODO_EXCEP_CIF_KYC_OUTSTANDINIG);
			}
			memoDtlCO.getAlertsParamCO().setTodoExcepEnglish(exceptionEng.toString());
		}
		else//Abdo Dynamic KYC TP#382751
		{
			if (FomConstant.KYC_COMPLETED_BY_CALL.equals(cifVO.getKYC_COMPLETED())) {
				memoDtlCO.getAlertsParamCO()
						.setTodoExcepEnglish(AlertsConstants.ACCOUNT_TODO_EXCEP_CIF_KYC_COMPLETED_BY_CALL);

			} else if (FomConstant.KYC_RECALCITRANT.equals(cifVO.getKYC_COMPLETED())) {
				memoDtlCO.getAlertsParamCO()
						.setTodoExcepEnglish(AlertsConstants.ACCOUNT_TODO_EXCEP_CIF_KYC_RECALCITRANT);
			} else {
				memoDtlCO.getAlertsParamCO()
						.setTodoExcepEnglish(AlertsConstants.ACCOUNT_TODO_EXCEP_CIF_KYC_OUTSTANDINIG);
			}
		    
		}
	    }
	}
	return memoDtlCO;
    }
    
    //Hala Al Sheikh - TP813252
    public BigDecimal getMinMemoCrmCode(MemoSC memoSC) throws BaseException
    {
	return memoDAO.getMinMemoCrmCode(memoSC);
    }

    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
        this.coreCommonServiceBO = coreCommonServiceBO;
    }

    /*
     * f_create_delete_memo
     * we should use the procedure P_RET_CREATE_MEMO instead.
     * coreCommonProcedureBO.createDeleteMemo(memoDtlCO);
    public MemoDtlCO createDeleteMemo(MemoDtlCO memoDtlCO) throws BaseException
    {
	if("D".equals(memoDtlCO.getCheckArg()))	//delete all memo for this cif with description = 'KYC is outstanding' and memo_code = 0 and not from conditional automation
	{
	    memoDtlCO.getCtsMemoDetVO().setSTATUS(MemoConstants.STATUS_DELETE);
	    memoDtlCO.getCtsMemoDetVO().setMEMO_CODE(BigDecimal.ZERO);
	    memoDAO.updateMemoDetls(memoDtlCO);
	}
	else if("I".equals(memoDtlCO.getCheckArg()))// if there are deleted memo for this cif, reactivate them by changing their status into 'P'
	{
	    memoDtlCO.getCtsMemoDetVO().setSTATUS(MemoConstants.STATUS_APPROVE);
	    memoDtlCO.getCtsMemoDetVO().setMEMO_CODE(BigDecimal.ZERO);
	    
	   int result =  memoDAO.updateMemoDetls(memoDtlCO);
	   if(result != 0)
	   {
		BigDecimal trxNO = commonLibBO.returnCTSCTR(memoDtlCO.getLoginCompCode(), memoDtlCO.getLoginBraCode(), "3", "C");
	        //insert a memo for this cif with description = 'KYC is outstanding' and memo_code = 0
	     
		memoDtlCO.getCtsMemoDetVO().setENG_COMENT("KYC is outstanding"); //ALERT_TRX_KYC_KEY_IS_OUTSTANDING
		memoDtlCO.getCtsMemoDetVO().setARAB_COMENT("KYC is outstanding");
		memoDtlCO.getCtsMemoDetVO().setCOMMON_DESC_ENG("KYC is outstanding");
		memoDtlCO.getCtsMemoDetVO().setTRX_NO(trxNO);
		memoDtlCO.getCtsMemoDetVO().setMEMO_CODE(BigDecimal.ZERO);
		memoDtlCO.getCtsMemoDetVO().setSTATUS(MemoConstants.STATUS_APPROVE);
		memoDtlCO.getCtsMemoDetVO().setFROM_DATE(memoDtlCO.getRunningDate());
		memoDtlCO.getCtsMemoDetVO().setDATE_TO(DateUtil.dateAdd(DateUtil.YEAR, new Long(999),memoDtlCO.getRunningDate()));
		memoDtlCO.getCtsMemoDetVO().setLAST_REVIEW_NO(BigDecimal.ZERO);
		memoDtlCO.getCtsMemoDetVO().setDATE_CREATED(memoDtlCO.getRunningDate());
		memoDtlCO.getCtsMemoDetVO().setCREATED_BY(memoDtlCO.getUserName());
		memoDtlCO.getCtsMemoDetVO().setDATE_APPROVED(memoDtlCO.getRunningDate());
		memoDtlCO.getCtsMemoDetVO().setAPPROVED_BY(memoDtlCO.getUserName());
	     genericDAO.insert(memoDtlCO.getCtsMemoDetVO());
	   }
	}
	else if("C".equals(memoDtlCO.getCheckArg())) // 'C' insert new memo from conditional automation when CIF is not complete
	{
		BigDecimal trxNO    = commonLibBO.returnCTSCTR(memoDtlCO.getLoginCompCode(), memoDtlCO.getLoginBraCode(), "3", "C");
		BigDecimal memoCode = memoDtlCO.getCtsMemoDetVO().getMEMO_CODE();
		//NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation 
		String cifIsNotComplete = commonLibBO.returnTranslErrorMessage(MessageCodes.CIF_IS_NOT_COMPLETE, 
			StringUtil.isNotEmpty(memoDtlCO.getLanguage()) ? memoDtlCO.getLanguage() : ConstantsCommon.LANGUAGE_ENGLISH);
		    
		memoDtlCO.getCtsMemoDetVO().setENG_COMENT(cifIsNotComplete);
		memoDtlCO.getCtsMemoDetVO().setARAB_COMENT(cifIsNotComplete);
		memoDtlCO.getCtsMemoDetVO().setCOMMON_DESC_ENG(cifIsNotComplete);
		memoDtlCO.getCtsMemoDetVO().setTRX_NO(trxNO);
		memoDtlCO.getCtsMemoDetVO().setMEMO_CODE(BigDecimal.ZERO);
		memoDtlCO.getCtsMemoDetVO().setSTATUS(MemoConstants.STATUS_APPROVE);
		memoDtlCO.getCtsMemoDetVO().setLAST_REVIEW_NO(BigDecimal.ZERO);
		memoDtlCO.getCtsMemoDetVO().setCOND_AUTOMATION_CODE(memoCode);
		genericDAO.insert(memoDtlCO.getCtsMemoDetVO());
	}
	//NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation 
	else if("CD".equals(memoDtlCO.getCheckArg()))
	{
	    //'CD' delete the memo already created from conditional automation when CIF is not complete
	    memoDtlCO.getCtsMemoDetVO().setSTATUS(MemoConstants.STATUS_DELETE);
	    memoDtlCO.getCtsMemoDetVO().setMEMO_CODE(BigDecimal.ZERO);
	    memoDAO.updateCTSMEMODET_CondAutoStatus(memoDtlCO);
	}
	else if("FSR".equals(memoDtlCO.getCheckArg()) || "FSI".equals(memoDtlCO.getCheckArg()))
	{
	    BigDecimal memoCode = memoDtlCO.getCtsMemoDetVO().getMEMO_CODE();
	    memoDtlCO.getCtsMemoDetVO().setMEMO_CODE(BigDecimal.ZERO);
	    if("FSI".equals(memoDtlCO.getCheckArg()))
	    {
		memoDtlCO.setEvent(MemoConstants.EVENT_TYPE_INCOMPLETE);  //8
	    }
	    else
	    {
		memoDtlCO.setEvent(MemoConstants.EVENT_TYPE_RECALCITRANT); //7
	    }
	    
	    //validate if record already exists, then only update status
	    CTSMEMO_DETVO memoDtlVO = memoDAO.recalcitrantIncompleteMemoList(memoDtlCO);
	    if(null != memoDtlVO)
	    {
		BigDecimal condAutCode = NumberUtil.nullToZero(memoDtlVO.getCOND_AUTOMATION_CODE());
		String status = memoDtlVO.getSTATUS();

		if(BigDecimal.ZERO.compareTo(condAutCode) == -1)
		{
		    memoDtlCO.getCtsMemoDetVO().setSTATUS(MemoConstants.STATUS_APPROVE);
		    memoDtlCO.getCtsMemoDetVO().setCOND_AUTOMATION_CODE(condAutCode);
		    memoDAO.updateCTSMEMODET_Status(memoDtlCO);

		}
		else
		{
		    if(!MemoConstants.STATUS_APPROVE.equals(StringUtil.nullToEmpty(status)))
		    {
			memoDtlCO.getCtsMemoDetVO().setCOND_AUTOMATION_CODE(new BigDecimal(0));
			memoDtlCO.getCtsMemoDetVO().setTRX_NO(commonLibBO.returnCTSCTR(memoDtlCO.getLoginCompCode(), memoDtlCO.getLoginBraCode(), "3", "C") );
			memoDtlCO.getCtsMemoDetVO().setENG_COMENT("Recalcitrant CIF - FATCA IRS Regulation");
			memoDtlCO.getCtsMemoDetVO().setARAB_COMENT("Recalcitrant CIF - FATCA IRS Regulation");
			memoDtlCO.getCtsMemoDetVO().setCOMMON_DESC_ENG("Recalcitrant CIF - FATCA IRS Regulation");
			memoDtlCO.getCtsMemoDetVO().setMEMO_CODE(BigDecimal.ZERO);
			memoDtlCO.getCtsMemoDetVO().setSTATUS(MemoConstants.STATUS_APPROVE);
			memoDtlCO.getCtsMemoDetVO().setLAST_REVIEW_NO(BigDecimal.ZERO);
			memoDtlCO.getCtsMemoDetVO().setCOND_AUTOMATION_CODE(memoCode);
			genericDAO.insert(memoDtlCO.getCtsMemoDetVO());
		    }
		}
		if(MemoConstants.STATUS_APPROVE.equals(StringUtil.nullToEmpty(status)))
		{
		    memoDAO.updateCTSMEMODET_Desc(memoDtlCO);
		}
	    }
	    
	    //FSI - VALIDATE IF A MEMO WAS CREATED FOR Recalcitrant CIF -FATCA IRS Regulation, THEN DELETE THE MEMO
	    //FSR - VALIDATE IF A MEMO WAS CREATED FOR Incomplete CIF	-FATCA IRS Regulation, THEN DELETE THE MEMO
	    if("FSI".equals(memoDtlCO.getCheckArg()))
	    {
		memoDtlCO.setEvent(MemoConstants.EVENT_TYPE_RECALCITRANT); //7
	    }
	    else
	    {
		memoDtlCO.setEvent(MemoConstants.EVENT_TYPE_INCOMPLETE);  //8
	    }
	    memoDtlCO.setStatus(MemoConstants.STATUS_APPROVE);
	    memoDtlVO = memoDAO.recalcitrantIncompleteMemoList(memoDtlCO);
	    if(null != memoDtlVO)
	    {
		if(BigDecimal.ZERO.compareTo(NumberUtil.nullToZero(memoDtlVO.getCOND_AUTOMATION_CODE())) == -1)
		{
		    memoDtlVO.setSTATUS("D");
		    memoDAO.updateCTSMEMODET_Status(memoDtlCO);
		}
	    }
	}
	else if ("FSD".equals(memoDtlCO.getCheckArg()))
	{
	    memoDtlCO.getCtsMemoDetVO().setSTATUS("D");
	    memoDAO.updateCTSMEMODET_FSDStatus(memoDtlCO);
	}
	return memoDtlCO;
    }
    */
}
