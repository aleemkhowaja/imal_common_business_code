package com.path.actions.common.dynamictemplate;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.dynamictemplate.DynamicTemplateBO;
import com.path.bo.common.dynamictemplate.DynamicTemplateConstant;
import com.path.bo.core.account.AccountBO;
import com.path.bo.core.cif.CifBO;
import com.path.bo.core.segmentation.CustSegmentationBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.TreeBaseAction;
import com.path.vo.common.AlertsParamCO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.accountcharges.AccountChargesCO;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.segmentation.CustSegmentationSC;
import com.path.vo.core.ctsteller.CTSTELLERSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * DynamicTemplateMaintAction.java used to
 */
public class DynamicTemplateConventionMaintAction extends TreeBaseAction
{
    private DynamicTemplateBO dynamicTemplateBO;
    private DynamicTemplateCO dynTemplateCO;
    private DynamicTemplateSC criteria = new DynamicTemplateSC();
    private List<SelectCO> entityTypelist;
    private BigDecimal convNo;
    private String convStatus;
    private Boolean _popupBtnFlag = true;
    private Boolean _popuplineFlag = true;
    private AccountBO accountBO;
    private CustSegmentationBO custSegmentationBO;
    private CifBO cifBO;
    private AlertsBO alertsBO;
    
    
    public void setDynamicTemplateBO(DynamicTemplateBO dynamicTemplateBO)
    {
	this.dynamicTemplateBO = dynamicTemplateBO;
    }

    public DynamicTemplateCO getDynTemplateCO()
    {
        return dynTemplateCO;
    }

    public void setDynTemplateCO(DynamicTemplateCO dynTemplateCO)
    {
        this.dynTemplateCO = dynTemplateCO;
    }
    
    public Object getModel()
    {
	return criteria;
    }

    public DynamicTemplateSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(DynamicTemplateSC criteria)
    {
	this.criteria = criteria;
    }

    public List<SelectCO> getEntityTypelist()
    {
        return entityTypelist;
    }

    public void setEntityTypelist(List<SelectCO> entityTypelist)
    {
        this.entityTypelist = entityTypelist;
    }
    
    public BigDecimal getConvNo()
    {
        return convNo;
    }

    public void setConvNo(BigDecimal convNo)
    {
        this.convNo = convNo;
    }

    public String getConvStatus()
    {
        return convStatus;
    }

    public void setConvStatus(String convStatus)
    {
        this.convStatus = convStatus;
    }
    
    private void initList() throws BaseException
    {
	SelectSC selSC = new SelectSC(DynamicTemplateConstant.LOV_TYPE_ENTITY);
	entityTypelist = returnLOV(selSC);
    }
    
    public String loadConvTemplatePage()
    {
	try
	{
	    set_showSmartInfoBtn("false");
	    //set_searchGridId("dynamicTemplateConventionListGridTbl_Id");
	    dynTemplateCO = new DynamicTemplateCO();
	    fillSessionData();
	    initList();
	    if(DynamicTemplateConstant.CRUD_R.equals(getIv_crud()))
	    {
		set_showNewInfoBtn("true");
	    }
	    if(DynamicTemplateConstant.CRUD_P.equals(getIv_crud()) || DynamicTemplateConstant.CRUD_UP.equals(getIv_crud()))
	    {
		//set_recReadOnly("true"); hussein to discuss
	    }
	    dynTemplateCO.setStatusDesc(getText("Active_key"));
//	    dynTemplateCO.setHm(dynamicTemplateBO.returnAccountRequired(dynTemplateCO));
//	    setAdditionalScreenParams(dynTemplateCO.getHm());
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "dynamicTemplateConvList";
    }

    public String saveNew()
    {
	try
	{
	    // apply session value
	    fillSessionData();

	    // AuditRefCO refCO;
	    if(null == dynTemplateCO.getDynTempConvVO().getSTATUS() || dynTemplateCO.getDynTempConvVO().getSTATUS().isEmpty())
	    {
		dynTemplateCO.setAuditRefCO(fillSessionVariables(AuditConstant.CREATED));
	    }
	    else
	    {
		dynTemplateCO.setAuditRefCO(fillSessionVariables(AuditConstant.UPDATE));
		dynTemplateCO.setAuditObj(returnAuditObject(dynTemplateCO.getClass()));
	    }
	    // save
	    dynamicTemplateBO.saveDynTempConv(dynTemplateCO);
	    // empty form
	    dynTemplateCO = new DynamicTemplateCO();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String deleteCustomerConv()
    {
	try
	{
	    // apply session value
	    fillSessionData();

	    dynTemplateCO.setAuditRefCO(fillSessionVariables(AuditConstant.DELETE));
	    dynamicTemplateBO.deleteCustomerConv(dynTemplateCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String ApproveCustomerConv()
    {
	try
	{
	    // apply session value
	    fillSessionData();

	    dynTemplateCO.setAuditRefCO(fillSessionVariables(AuditConstant.UPDATE));
	    dynTemplateCO.getAuditRefCO().setTrxNbr(getAuditTrxNbr());
	    dynamicTemplateBO.ApproveCustomerConv(dynTemplateCO);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String RejectCustomerConv()
    {
	try
	{
	    // apply session value
	    fillSessionData();

	    dynTemplateCO.setAuditRefCO(fillSessionVariables(AuditConstant.UPDATE));
	    dynTemplateCO.getAuditRefCO().setTrxNbr(getAuditTrxNbr());
	    dynamicTemplateBO.RejectCustomerConv(dynTemplateCO);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String SuspendCustomerConv()
    {
	try
	{
	    // apply session value
	    fillSessionData();

	    dynTemplateCO.setAuditRefCO(fillSessionVariables(AuditConstant.UPDATE));
	    dynTemplateCO.getAuditRefCO().setTrxNbr(getAuditTrxNbr());
	    dynamicTemplateBO.SuspendCustomerConv(dynTemplateCO);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String ReactivateCustomerConv()
    {
	try
	{
	    // apply session value
	    fillSessionData();

	    dynTemplateCO.setAuditRefCO(fillSessionVariables(AuditConstant.UPDATE));
	    dynTemplateCO.getAuditRefCO().setTrxNbr(getAuditTrxNbr());
	    dynamicTemplateBO.ReactivateCustomerConv(dynTemplateCO);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String retrieveSelectedConvNo()
    {
	try
	{
	    DynamicTemplateSC dynTempConvSC = new DynamicTemplateSC();
	    initList();
	    SessionCO sessionCO = returnSessionObject();
	    dynTempConvSC.setCompCode(sessionCO.getCompanyCode());
	    dynTempConvSC.setBranchCode(sessionCO.getBranchCode());
	    dynTempConvSC.setDtConvNo(convNo);
	    dynTempConvSC.setLovTypeId(DynamicTemplateConstant.LOV_TYPE);
	    dynTempConvSC.setLovTypeEntity(DynamicTemplateConstant.LOV_TYPE_ENTITY);
	    dynTempConvSC.setLovLkOptType(DynamicTemplateConstant.LOV_LK_OPT_TYPE);
	    dynTempConvSC.setCrudMode(getIv_crud());
	    dynTempConvSC.setCurrAppName(sessionCO.getCurrentAppName());
	    dynTempConvSC.setPreferredLanguage(sessionCO.getLanguage());
	    dynTempConvSC.setMenuRef(get_pageRef());
	    dynTempConvSC.setConvOldStatus(convStatus);
	    dynTemplateCO = dynamicTemplateBO.retrieveSelectedConvNo(dynTempConvSC);
	    if(!(dynTemplateCO.getDynTempConvVO().getSTATUS().equals(dynTempConvSC.getConvOldStatus())))
	    {
		throw new BOException(MessageCodes.RECORD_CHANGED);
	    }
	    if(DynamicTemplateConstant.CRUD_P.equals(getIv_crud())||DynamicTemplateConstant.CRUD_J.equals(getIv_crud()))
	    {
		set_recReadOnly(ConstantsCommon.TRUE);
	    }
	    else if(DynamicTemplateConstant.CRUD_UP.equals(getIv_crud()))
	    {
		set_recReadOnly(ConstantsCommon.FALSE);
	    }
	    else if(DynamicTemplateConstant.STATUS_ACTIVE.equals(dynTemplateCO.getDynTempConvVO().getSTATUS()))
	    {
		set_recReadOnly(ConstantsCommon.FALSE);
	    }
	    else
	    {
		set_recReadOnly(ConstantsCommon.TRUE);
	    }

	    applyRetrieveAudit(AuditConstant.DYNAMIC_TEMPLATE_CONV_KEY_REF, dynTemplateCO.getDynTempConvVO(),
			dynTemplateCO);
	}
	catch(Exception e)
	{
	    // log.error(e,
	    // "Error in method loadstfTypeParamGrid in
	    // StfTypeParamMainAction");
	    handleException(e, null, null);
	    return ERROR;
	}
	return "dynamicTemplateConvMaint";
    }
    
    public String clearStpForm()
    {
	{
	    try
	    {
		initList();
		dynTemplateCO = new DynamicTemplateCO();
		if(DynamicTemplateConstant.CRUD_UP.equals(getIv_crud()) || DynamicTemplateConstant.STATUS_APPROVED.equals(getIv_crud()))
		{
		    set_recReadOnly("true");
		}
		else
		{
		    set_recReadOnly("false");
		}
		dynTemplateCO.getDynTempConvVO().setSTATUS(null);
		dynTemplateCO.setStatusDesc(getText("Active_key"));
		applyRetrieveAudit(AuditConstant.DYNAMIC_TEMPLATE_CONV_KEY_REF, dynTemplateCO.getDynTempConvVO(),
			dynTemplateCO);
	    }
	    catch(Exception e)
	    {
		log.error(e, "");
	    }
	    return "dynamicTemplateConvMaint";
	}
    }
    
    private AuditRefCO fillSessionVariables(String status)
    {

	AuditRefCO refCO = initAuditRefCO();
	try
	{
	    refCO.setOperationType(status);
	    refCO.setKeyRef(AuditConstant.DYNAMIC_TEMPLATE_CONV_KEY_REF);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return refCO;
    }
    
    public void fillSessionData() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	dynTemplateCO.setCompCode(sessionCO.getCompanyCode());
	dynTemplateCO.setBranchCode(sessionCO.getBranchCode());
	dynTemplateCO.setAppName(sessionCO.getCurrentAppName());
	dynTemplateCO.setProgRef(get_pageRef());
	dynTemplateCO.setUserID(sessionCO.getUserName());
	dynTemplateCO.setRunningDate(returnCommonLibBO().addSystemTimeToDate(sessionCO.getRunningDateRET()));
	dynTemplateCO.setIvCrud(getIv_crud());
	dynTemplateCO.setLanguage(sessionCO.getLanguage());
	dynTemplateCO.setUserID(sessionCO.getUserName());
	dynTemplateCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
    }
    
    public String loadAlertConvTemplatePage()
    {
	try
	{
	    set_showSmartInfoBtn("false");
	    //set_searchGridId("dynamicTemplateConventionListGridTbl_Id");
	    //dynTemplateCO = new DynamicTemplateCO();
	    fillSessionData();
	    initList();
	    
	    set_popuplineFlag(false);
	    set_popupBtnFlag(false);
	    
	    set_showNewInfoBtn("false");
	    set_recReadOnly("true");
	    
	    String[] todoParam = dynTemplateCO.getAlertHeaderDetails().split("~");
	    
	    String convEntityType=todoParam [5];
	    
	    dynTemplateCO.getDynTempConvVO().setENTITY_TYPE(convEntityType);
	    
	    if("A".equals(convEntityType))
	    {
		AccountSC criteria = new AccountSC();
		criteria.setCompCode(dynTemplateCO.getCompCode());
		criteria.setBranchCode(new BigDecimal(todoParam[0]));
		criteria.setCurrencyCode(new BigDecimal(todoParam[1]));
		criteria.setGlCode(new BigDecimal(todoParam[2]));
		criteria.setCifCode(new BigDecimal(todoParam[3]));
		criteria.setSlNbr(new BigDecimal(todoParam[4]));
		
		  if((criteria.getAddRef() != null && !"".equals(criteria.getAddRef()))
			    || (!NumberUtil.isEmptyDecimal(criteria.getBranchCode())
				    && !NumberUtil.isEmptyDecimal(criteria.getCurrencyCode())
				    && !NumberUtil.isEmptyDecimal(criteria.getGlCode())
				    && !NumberUtil.isEmptyDecimal(criteria.getCifCode()) && !NumberUtil.isEmptyDecimal(criteria
				    .getSlNbr())))
		    {
				criteria.setLovType(ConstantsCommon.STATUS_LOV);
				criteria.setPreferredLanguage(dynTemplateCO.getLoginPreferrredLanguage());
				dynTemplateCO.setAmfVO(accountBO.returnAMFBySLNo(criteria));
		    }
		  		  
		dynTemplateCO.getDynTempConvVO().setACC_BR(dynTemplateCO.getAmfVO().getBRANCH_CODE());
		dynTemplateCO.getDynTempConvVO().setACC_CY(dynTemplateCO.getAmfVO().getCURRENCY_CODE());
		dynTemplateCO.getDynTempConvVO().setACC_CIF(dynTemplateCO.getAmfVO().getCIF_SUB_NO());
		dynTemplateCO.getDynTempConvVO().setACC_GL(dynTemplateCO.getAmfVO().getGL_CODE());
		dynTemplateCO.getDynTempConvVO().setACC_SL(dynTemplateCO.getAmfVO().getSL_NO());
		dynTemplateCO.setAccAddRef(dynTemplateCO.getAmfVO().getADDITIONAL_REFERENCE());
		dynTemplateCO.setAccountName(dynTemplateCO.getAmfVO().getBRIEF_NAME_ENG());
		
	    }
	    else if ("S".equals(convEntityType))
	    {
		CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
		custSegmentationSC.setCompCode(dynTemplateCO.getCompCode());
		custSegmentationSC.setIsSegmentationScore("S");
		custSegmentationSC.setSegment_code(new BigDecimal(todoParam[6]));
		
		dynTemplateCO.setCtsSegmentVO(custSegmentationBO.returnSegmentCodeForDependency(custSegmentationSC));
		
		dynTemplateCO.getDynTempConvVO().setSEGMENT_CODE(dynTemplateCO.getCtsSegmentVO().getSEGMENT_CODE());
		dynTemplateCO.setSegmentName(dynTemplateCO.getCtsSegmentVO().getSEGMENT_DESC());
		
		
		
	    }	
	    else if ("C".equals(convEntityType))
	    {
		
		CifSC cifSC = new CifSC();
		cifSC.setComp_code(dynTemplateCO.getCompCode());
		cifSC.setCif_no(new BigDecimal(todoParam[7]));
		
		dynTemplateCO.setCifVO(cifBO.returnCIF(cifSC));
		
		dynTemplateCO.getDynTempConvVO().setCIF_NO(dynTemplateCO.getCifVO().getCIF_NO());
		dynTemplateCO.setCifName(dynTemplateCO.getCifVO().getSHORT_NAME_ENG());
		
	    }	
	    
	  
//	    dynTemplateCO.setHm(dynamicTemplateBO.returnAccountRequired(dynTemplateCO));
//	    setAdditionalScreenParams(dynTemplateCO.getHm());
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "dynamicTemplateConvList";
    }

    
    public String alertApproveRetCharges()
    {/*
		try
		{
		    SessionCO sessionCO = returnSessionObject();
		    AccountChargesCO accountChargesCO = new AccountChargesCO();
		    AlertsParamCO receivedAlertParamCO = get_alert();
		    applyRetChargesAlertsData(accountChargesCO,receivedAlertParamCO, sessionCO);
	
		    if(receivedAlertParamCO != null && !Boolean.valueOf(receivedAlertParamCO.getIsLocalApprove()))
		    {
		    	alertsBO.checkIfSameStatus(receivedAlertParamCO);
		    }
	
		    String[] optDetailsArray = returnCommonLibBO().returnOptDetailsList(sessionCO.getCurrentAppName(),
			    receivedAlertParamCO.getProgRef().trim());
		    if(optDetailsArray != null && optDetailsArray.length > 0)
		    {
				String ivCrud = optDetailsArray[2];
				dynTemplateCO.setOpt(receivedAlertParamCO.getProgRef());
				dynTemplateCO.setCrud(ivCrud);
		
				if("P".equals(ivCrud))
				{
				    // Calling the approve method for Account Charges
				    receivedAlertParamCO.setTodoAlert(AlertsConstants.ACCOUNTCHARGES_ACK_APPROVE);
				    accountChargesBO.saveTemplateCharges(accountChargesCO);
				    
				}
		    }
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
	
		// Set _alert to null to avoid opening the sendAlert popup
		set_alert(null);
	*/
		return "success";
    }
    
    private void applyRetChargesAlertsData(AccountChargesCO accountChargesCO,AlertsParamCO receivedAlertParamCO, SessionCO sessionCO) throws BaseException
    {
		receivedAlertParamCO.setOldTodoAlert(receivedAlertParamCO.getTodoAlert());
		accountChargesCO.setIsFromAlert(Boolean.TRUE.toString());
		accountChargesCO.setRunningDate(returnCommonLibBO().addSystemTimeToDate(sessionCO.getRunningDateRET()));
		if(Boolean.valueOf(receivedAlertParamCO.getIsLocalApprove()))
		{
		    // If this action is called from local approve. the local
		    // approve user name is set in avaFileCO
			accountChargesCO.setLoginCompCode(sessionCO.getCompanyCode());
			accountChargesCO.setLoginBraCode(sessionCO.getBranchCode());
			accountChargesCO.setLoginUserId(sessionCO.getLocalApproveUserName());
		    receivedAlertParamCO.setAppName(sessionCO.getCurrentAppName());
		    receivedAlertParamCO.setUserId(sessionCO.getLocalApproveUserName());
	
		    CTSTELLERSC ctsTellerSC = new CTSTELLERSC();
		    ctsTellerSC.setCompCode(sessionCO.getCompanyCode());
		    ctsTellerSC.setBranchCode(sessionCO.getBranchCode());
		    ctsTellerSC.setUserId(sessionCO.getLocalApproveUserName());
		    CTSTELLERVO ctsTellerVO = alertsBO.ctsTellerDetails(ctsTellerSC);
		    if(ctsTellerVO != null)
		    {
		    	accountChargesCO.setLoginTellerCode(ctsTellerVO.getCODE());
		    }
		    accountChargesCO.setCtsTellerVO(ctsTellerVO);
		}
		else
		{
			accountChargesCO.setLoginCompCode(accountChargesCO.getAlertsParamCO().getCompCode());
			accountChargesCO.setLoginBraCode(accountChargesCO.getAlertsParamCO().getBranchCode());
			accountChargesCO.setLoginTellerCode(sessionCO.getCtsTellerVO().getCODE());
			accountChargesCO.setLoginUserId(sessionCO.getUserName());
			accountChargesCO.setCtsTellerVO(sessionCO.getCtsTellerVO());
		    receivedAlertParamCO.setUserId(sessionCO.getUserName());
		}
	
		accountChargesCO.setAlertsParamCO(receivedAlertParamCO);
    }
    
    public Boolean get_popupBtnFlag()
    {
        return _popupBtnFlag;
    }

    public void set_popupBtnFlag(Boolean _popupBtnFlag)
    {
        this._popupBtnFlag = _popupBtnFlag;
    }

    public Boolean get_popuplineFlag()
    {
        return _popuplineFlag;
    }

    public void set_popuplineFlag(Boolean _popuplineFlag)
    {
        this._popuplineFlag = _popuplineFlag;
    }

    public void setAccountBO(AccountBO accountBO)
    {
        this.accountBO = accountBO;
    }

    public void setCustSegmentationBO(CustSegmentationBO custSegmentationBO)
    {
        this.custSegmentationBO = custSegmentationBO;
    }

    public void setCifBO(CifBO cifBO)
    {
        this.cifBO = cifBO;
    }

    public void setAlertsBO(AlertsBO alertsBO)
    {
        this.alertsBO = alertsBO;
    }

}
