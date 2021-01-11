package com.path.bo.common.dynamictemplate.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.dynamictemplate.DynamicTemplateBO;
import com.path.bo.common.dynamictemplate.DynamicTemplateConstant;
import com.path.dao.common.dynamictemplate.DynamicTemplateDAO;
import com.path.dbmaps.vo.BCOM_DYN_ENTITY_APP_LISTVO;
import com.path.dbmaps.vo.BCOM_DYN_ENT_TEMPL_CONVVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;
import com.path.vo.common.tree.TreeNodeCO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTemplateBOImpl.java used to
 */
public class DynamicTemplateBOImpl extends BaseBO implements DynamicTemplateBO
{
    DynamicTemplateDAO dynamicTemplateDAO;

    public DynamicTemplateDAO getDynamicTemplateDAO()
    {
	return dynamicTemplateDAO;
    }

    public void setDynamicTemplateDAO(DynamicTemplateDAO dynamicTemplateDAO)
    {
	this.dynamicTemplateDAO = dynamicTemplateDAO;
    }

    /**
     * Method used to return Count of DynamicTemplate
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws BaseException
     */
    public int returnDynamicTemplateListCount(DynamicTemplateSC criteria) throws BaseException
    {
	return dynamicTemplateDAO.returnDynamicTemplateListCount(criteria);
    }

    /**
     * Method used to return List of DynamicTemplate
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws BaseException
     */
    public List returnDynamicTemplateList(DynamicTemplateSC criteria) throws BaseException
    {
	return dynamicTemplateDAO.returnDynamicTemplateList(criteria);
    }

    @Override
    public DynamicTemplateCO retrieveSelectedDynTempId(DynamicTemplateSC dynTemplateSC) throws BaseException
    {
	return dynamicTemplateDAO.retrieveSelectedDynTempId(dynTemplateSC);
    }

    @Override
    public List<TreeNodeCO> returnTreeNodes(DynamicTemplateSC sc) throws BaseException
    {
	return dynamicTemplateDAO.returnTreeNodes(sc);
    }

    @Override
    public int retSysParamScreenChrgListCount(DynamicTemplateSC sc) throws BaseException
    {
	return dynamicTemplateDAO.retSysParamScreenChrgListCount(sc);
    }

    @Override
    public List retSysParamScreenChrgList(DynamicTemplateSC sc) throws BaseException
    {
	return dynamicTemplateDAO.retSysParamScreenChrgList(sc);
    }

    @Override
    public DynamicTemplateCO retScreenDetails(DynamicTemplateSC criteria) throws BaseException
    {
	return dynamicTemplateDAO.retScreenDetails(criteria);
    }

    @Override
    public DynamicTemplateCO retrieveSelectNodesDesc(DynamicTemplateSC sc) throws BaseException
    {
	return dynamicTemplateDAO.retrieveSelectNodesDesc(sc);
    }

    @Override
    public DynamicTemplateCO retrieveSelectNodesDescWithoutScreenId(DynamicTemplateSC sc) throws BaseException
    {
	return dynamicTemplateDAO.retrieveSelectNodesDescWithoutScreenId(sc);
    }
	
    @Override
    public void save(DynamicTemplateCO dynTemplateCO) throws BaseException
    {
	AuditRefCO refCO = dynTemplateCO.getAuditRefCO();
	int nodeOrder;
	// add
	if((ConstantsCommon.EMPTY_BIGDECIMAL_VALUE).equals(dynTemplateCO.getDynTemplateVO().getDYN_TEMP_ID())|| (dynamicTemplateDAO.checkNodeIfExist(dynTemplateCO)) == 0)
	{
	    dynTemplateCO.getDynTemplateVO().setCREATED_BY(dynTemplateCO.getUserID());
	    dynTemplateCO.getDynTemplateVO().setCREATED_DATE(dynTemplateCO.getRunningDate());
	    dynTemplateCO.getDynTemplateVO().setSERVER_CREATED_DATE(commonLibBO.returnSystemDateWithTime());

	    // insert into Dyn_chrg_template
	    if((ConstantsCommon.EMPTY_BIGDECIMAL_VALUE).equals(dynTemplateCO.getDynTemplateVO().getDYN_TEMP_ID()))
	    {
		// get the counter
		dynTemplateCO.getDynTemplateVO().setDYN_TEMP_ID(new BigDecimal(dynamicTemplateDAO.returnDynTempId()));
		genericDAO.insert(dynTemplateCO.getDynTemplateVO());
	    }
	    // insert into Dyn_chrg_template_nodes
	    dynTemplateCO.getDynTemplateNodesVO().setDYN_TEMP_ID(dynTemplateCO.getDynTemplateVO().getDYN_TEMP_ID());
	    
	    //get the node order related to parent id
	    dynTemplateCO.getDynTemplateNodesVO().setNODE_ORDER(dynamicTemplateDAO.retNoderOrderRelatedToParent(dynTemplateCO));
	    
	    NumberUtil.resetEmptyValues(dynTemplateCO);
	    genericDAO.insert(dynTemplateCO.getDynTemplateNodesVO());
	    
	    // apply audit
	    refCO.setOperationType(AuditConstant.CREATED);
	    auditBO.callAudit(null, dynTemplateCO.getDynTemplateVO(), refCO);
	}
	// update
	else
	{  
	    dynTemplateCO.getDynTemplateVO().setMODIFIED_BY(dynTemplateCO.getUserID());
	    dynTemplateCO.getDynTemplateVO().setMODIFIED_DATE(dynTemplateCO.getRunningDate());
	    dynTemplateCO.getDynTemplateVO().setSERVER_MODIFIED_DATE(commonLibBO.returnSystemDateWithTime());
	    NumberUtil.resetEmptyValues(dynTemplateCO);	    	
	    	    
	    Integer row = genericDAO.update(dynTemplateCO.getDynTemplateVO());
	    if(row == null || row < 1)
	    {
		throw new BOException(MessageCodes.RECORD_CHANGED);
	    }
	    
	    dynTemplateCO.getDynTemplateNodesVO().setDYN_TEMP_ID(dynTemplateCO.getDynTemplateVO().getDYN_TEMP_ID());
	    
	    if(!StringUtil.isEmptyString(dynTemplateCO.getDynTemplateNodesVO().getPARENT_NODE_ID())
		    && !StringUtil.isEmptyString(dynTemplateCO.getDynTemplateNodesVO().getNODE_ID())
			    && dynTemplateCO.getDynTemplateNodesVO().getNODE_ID().equals(dynTemplateCO.getDynTemplateNodesVO().getPARENT_NODE_ID()) 
			    )
	    {
		throw new BOException(MessageCodes.CODE_ALREADY_IN_USE);

	    }
	    
	    Integer row1 = dynamicTemplateDAO.updateTemplateNode (dynTemplateCO);
		    
	   // Integer row1 = genericDAO.update(dynTemplateCO.getDynTemplateNodesVO());
	    if(row1 == null || row1 < 1)
	    {
		throw new BOException(MessageCodes.CODE_ALREADY_IN_USE);
	    }
	    
	    // apply audit
	    refCO.setOperationType(AuditConstant.UPDATE);
	    DynamicTemplateCO oldreportQueryCO = (DynamicTemplateCO) dynTemplateCO.getAuditObj();
	    auditBO.callAudit(oldreportQueryCO.getDynTemplateVO(), dynTemplateCO.getDynTemplateVO(), refCO);
	    auditBO.insertAudit(refCO);
	}
    }
    
    @Override
    public BigDecimal retSavedDynTempId(DynamicTemplateCO dynTemplateCO) throws BaseException
    {
	return dynamicTemplateDAO.retSavedDynTempId(dynTemplateCO);
    }
    
    @Override
    public void deleteNode(DynamicTemplateCO dynTemplateCO) throws BaseException
    {
	
	Integer nbrOfChilds = dynamicTemplateDAO.returnNbrOfChilds(dynTemplateCO);
	
	if(nbrOfChilds > 0)
	{
	    throw new BOException(MessageCodes.CANNOT_DELETE_DETAILS_EXISTS);
	}
	
	if( StringUtil.isNotEmpty(dynTemplateCO.getDynTemplateNodesVO().getPARENT_NODE_ID()) 
		&& "ROOT".equals(dynTemplateCO.getDynTemplateNodesVO().getPARENT_NODE_ID()))
	{
	    throw new BOException(MessageCodes.EMPTY_MESSAGE , new String[] { "Cannot Proceed!" , "Cannot Delete ROOT Node!" } );
	}
	genericDAO.delete(dynTemplateCO.getDynTemplateNodesVO());
    }
    
    @Override
    public void deleteDynTempId(DynamicTemplateCO dynTemplateCO) throws BaseException
    {
	{
	    dynamicTemplateDAO.deleteDynChrgTempNodes(dynTemplateCO);

	    genericDAO.delete(dynTemplateCO.getDynTemplateVO());
	}
    }
    
    @Override
    public List<DynamicTemplateCO> retNodesList(DynamicTemplateSC criteria) throws BaseException
    {
	return dynamicTemplateDAO.retNodesList(criteria);
    }
	
    @Override
    public int returnDynamicTemplateConvListCount(DynamicTemplateSC criteria) throws BaseException
    {
	return dynamicTemplateDAO.returnDynamicTemplateConvListCount(criteria);
    }

    @Override
    public List returnDynamicTemplateConvList(DynamicTemplateSC criteria) throws BaseException
    {
	return dynamicTemplateDAO.returnDynamicTemplateConvList(criteria);
    }
    
    @Override
    public void saveDynTempConv(DynamicTemplateCO dynTemplateCO) throws BaseException
    {
	AuditRefCO refCO = dynTemplateCO.getAuditRefCO();
	dynTemplateCO.getDynTempConvVO().setSTATUS(ConstantsCommon.ACTIVE_RECORD);

	// add
	if((ConstantsCommon.EMPTY_BIGDECIMAL_VALUE).equals(dynTemplateCO.getDynTempConvVO().getCONVENTION_NUMBER()))
	{
	    // get the counter
	    dynTemplateCO.getDynTempConvVO().setCONVENTION_NUMBER(dynamicTemplateDAO.returnDynTempConvNO());

	    dynTemplateCO.getDynTempConvVO().setCREATED_BY(dynTemplateCO.getUserID());
	    dynTemplateCO.getDynTempConvVO().setCREATED_DATE(dynTemplateCO.getRunningDate());
	    dynTemplateCO.getDynTempConvVO().setSERVER_CREATED_DATE(commonLibBO.returnSystemDateWithTime());

	    dynTemplateCO.getDynTempConvVO().setSTATUS(ConstantsCommon.ACTIVE_RECORD);
	    dynTemplateCO.getDynTempConvVO().setCOMP_CODE(dynTemplateCO.getCompCode());
	    
	    genericDAO.insert(dynTemplateCO.getDynTempConvVO());
	    // apply audit
	    refCO.setOperationType(AuditConstant.CREATED);
	    NumberUtil.resetEmptyValues(dynTemplateCO.getDynTempConvVO());
	    auditBO.callAudit(null, dynTemplateCO.getDynTempConvVO(), refCO);
	}
	// update
	else
	{
	    dynTemplateCO.getDynTempConvVO().setMODIFIED_BY(dynTemplateCO.getUserID());
	    dynTemplateCO.getDynTempConvVO().setMODIFIED_DATE(dynTemplateCO.getRunningDate());
	    dynTemplateCO.getDynTempConvVO().setSERVER_MODIFIED_DATE(commonLibBO.returnSystemDateWithTime());

	    //get the old value and insert them into the mirror alert table
	    DynamicTemplateCO oldDynTempCO = new DynamicTemplateCO();
	    DynamicTemplateSC oldDynTempSC = new DynamicTemplateSC();
	    oldDynTempSC.setLovTypeId(DynamicTemplateConstant.LOV_TYPE);
	    oldDynTempSC.setLovTypeEntity(DynamicTemplateConstant.LOV_TYPE_ENTITY);
	    oldDynTempSC.setLovLkOptType(DynamicTemplateConstant.LOV_LK_OPT_TYPE);
	    oldDynTempSC.setCrudMode(DynamicTemplateConstant.CRUD_R);
	    oldDynTempSC.setPreferredLanguage(dynTemplateCO.getLanguage());
	    oldDynTempSC.setDtConvNo(dynTemplateCO.getDynTempConvVO().getCONVENTION_NUMBER());
	    oldDynTempCO = dynamicTemplateDAO.retrieveSelectedConvNo(oldDynTempSC);
	    oldDynTempCO.getDynTempConvVO().setCOMP_CODE(dynTemplateCO.getCompCode());
	    PathPropertyUtil.copyProperties(oldDynTempCO.getDynTempConvVO(), dynTemplateCO.getDynTempConvAlrtVO());
	    genericDAO.insert(dynTemplateCO.getDynTempConvAlrtVO());
	    
	    Integer row = genericDAO.update(dynTemplateCO.getDynTempConvVO());
	    if(row == null || row < 1)
	    {
		throw new BOException(MessageCodes.RECORD_CHANGED);
	    }

	    // apply audit
	    refCO.setOperationType(AuditConstant.UPDATE);
	    NumberUtil.resetEmptyValues(dynTemplateCO.getDynTempConvVO());
	    DynamicTemplateCO olddynTempCO = (DynamicTemplateCO) dynTemplateCO.getAuditObj();
	    auditBO.callAudit(olddynTempCO.getDynTempConvVO(), dynTemplateCO.getDynTempConvVO(), refCO);
	    auditBO.insertAudit(refCO);
	}
    }
    
    @Override
    public void deleteCustomerConv(DynamicTemplateCO dynTemplateCO) throws BaseException
    {
	dynTemplateCO.getDynTempConvVO().setCOMP_CODE(dynTemplateCO.getCompCode());
	dynTemplateCO.getDynTempConvVO().setDELETED_BY(dynTemplateCO.getUserID());
	dynTemplateCO.getDynTempConvVO().setDELETED_DATE(dynTemplateCO.getRunningDate());
	Date serverDate = commonLibBO.returnSystemDateWithTime();
	dynTemplateCO.getDynTempConvVO().setSERVER_DELETED_DATE(serverDate);
	dynTemplateCO.getDynTempConvVO().setSTATUS(ConstantsCommon.OPERATION_TYPE_DELETE);

	Integer update = genericDAO.update(dynTemplateCO.getDynTempConvVO());
	if(update == null || update < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}
	BCOM_DYN_ENT_TEMPL_CONVVO oldAuditVO = (BCOM_DYN_ENT_TEMPL_CONVVO) genericDAO.selectByPK(dynTemplateCO.getDynTempConvVO());
	BCOM_DYN_ENT_TEMPL_CONVVO newAuditVO = new BCOM_DYN_ENT_TEMPL_CONVVO();
	PathPropertyUtil.copyProperties(oldAuditVO, newAuditVO);
	newAuditVO.setDELETED_BY(dynTemplateCO.getUserID());
	newAuditVO.setDELETED_DATE(dynTemplateCO.getRunningDate());
	newAuditVO.setSTATUS(ConstantsCommon.OPERATION_TYPE_DELETE);
	newAuditVO.setSERVER_DELETED_DATE(serverDate);

	auditBO.callAudit(oldAuditVO, newAuditVO, dynTemplateCO.getAuditRefCO());
	auditBO.insertAudit(dynTemplateCO.getAuditRefCO());
    }
    
    @Override
    public void ApproveCustomerConv(DynamicTemplateCO dynTemplateCO) throws BaseException
    {
	dynTemplateCO.getDynTempConvVO().setCOMP_CODE(dynTemplateCO.getCompCode());
	Date systemDate = commonLibBO.returnSystemDateWithTime();
	dynTemplateCO.getDynTempConvVO().setAPPROVED_BY(dynTemplateCO.getUserID());
	dynTemplateCO.getDynTempConvVO().setAPPROVED_DATE(dynTemplateCO.getRunningDate());
	dynTemplateCO.getDynTempConvVO().setSTATUS(ConstantsCommon.STATUS_APPROVED);
	dynTemplateCO.getDynTempConvVO().setSERVER_APPROVED_DATE(systemDate);

	BCOM_DYN_ENT_TEMPL_CONVVO oldAuditVO = (BCOM_DYN_ENT_TEMPL_CONVVO) genericDAO.selectByPK(dynTemplateCO.getDynTempConvVO());
	Integer update = genericDAO.update(dynTemplateCO.getDynTempConvVO());
	if(update == null || update < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}
	BCOM_DYN_ENT_TEMPL_CONVVO newAuditVO = new BCOM_DYN_ENT_TEMPL_CONVVO();
	PathPropertyUtil.copyProperties(oldAuditVO, newAuditVO);
	newAuditVO.setAPPROVED_BY(dynTemplateCO.getUserID());
	newAuditVO.setAPPROVED_DATE(dynTemplateCO.getRunningDate());
	newAuditVO.setSTATUS(ConstantsCommon.STATUS_APPROVED);
	newAuditVO.setSERVER_APPROVED_DATE(systemDate);

	auditBO.callAudit(oldAuditVO, newAuditVO, dynTemplateCO.getAuditRefCO());
	auditBO.insertAudit(dynTemplateCO.getAuditRefCO());
    }
    
    @Override
    public void RejectCustomerConv(DynamicTemplateCO dynTemplateCO) throws BaseException
    {
	Integer update;
	dynTemplateCO.getDynTempConvVO().setCOMP_CODE(dynTemplateCO.getCompCode());
	Date systemDate = commonLibBO.returnSystemDateWithTime();
	dynTemplateCO.getDynTempConvVO().setAPPROVE_REJECTED_BY(dynTemplateCO.getUserID());
	dynTemplateCO.getDynTempConvVO().setAPPROVE_REJECTED_DATE(dynTemplateCO.getRunningDate());
	dynTemplateCO.getDynTempConvVO().setSTATUS(DynamicTemplateConstant.STATUS_APPROVE_REJECTED);
	dynTemplateCO.getDynTempConvVO().setSERVER_APPROVE_REJECTED_DATE(systemDate);

	BCOM_DYN_ENT_TEMPL_CONVVO oldAuditVO = (BCOM_DYN_ENT_TEMPL_CONVVO) genericDAO.selectByPK(dynTemplateCO.getDynTempConvVO());
	
	//check if it is the first time rejected
	DynamicTemplateCO oldDynConvCO  = dynamicTemplateDAO.checkOldConvRecord(dynTemplateCO.getDynTempConvVO().getCONVENTION_NUMBER());
	
	if(oldDynConvCO != null)
	{
	    oldDynConvCO.getDynTempConvAlrtVO().setDATE_UPDATED(null);
	    PathPropertyUtil.copyProperties(oldDynConvCO.getDynTempConvAlrtVO(), dynTemplateCO.getDynTempConvVO());
	}
	
	update = genericDAO.update(dynTemplateCO.getDynTempConvVO());
	
	if(update == null || update < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}
	BCOM_DYN_ENT_TEMPL_CONVVO newAuditVO = new BCOM_DYN_ENT_TEMPL_CONVVO();
	PathPropertyUtil.copyProperties(oldAuditVO, newAuditVO);
	newAuditVO.setAPPROVE_REJECTED_BY(dynTemplateCO.getUserID());
	newAuditVO.setSERVER_APPROVE_REJECTED_DATE(dynTemplateCO.getRunningDate());
	newAuditVO.setSTATUS(DynamicTemplateConstant.STATUS_APPROVE_REJECTED);
	newAuditVO.setSERVER_APPROVE_REJECTED_DATE(systemDate);

	auditBO.callAudit(oldAuditVO, newAuditVO, dynTemplateCO.getAuditRefCO());
	auditBO.insertAudit(dynTemplateCO.getAuditRefCO());
    }
    
    @Override
    public void SuspendCustomerConv(DynamicTemplateCO dynTemplateCO) throws BaseException
    {
	dynTemplateCO.getDynTempConvVO().setCOMP_CODE(dynTemplateCO.getCompCode());
	Date systemDate = commonLibBO.returnSystemDateWithTime();
	dynTemplateCO.getDynTempConvVO().setSUSPENDED_BY(dynTemplateCO.getUserID());
	dynTemplateCO.getDynTempConvVO().setSUSPENDED_DATE(dynTemplateCO.getRunningDate());
	dynTemplateCO.getDynTempConvVO().setSTATUS(ConstantsCommon.CIF_SUSPENDED);
	dynTemplateCO.getDynTempConvVO().setSERVER_SUSPENDED_DATE(systemDate);

	BCOM_DYN_ENT_TEMPL_CONVVO oldAuditVO = (BCOM_DYN_ENT_TEMPL_CONVVO) genericDAO.selectByPK(dynTemplateCO.getDynTempConvVO());
	Integer update = genericDAO.update(dynTemplateCO.getDynTempConvVO());
	if(update == null || update < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}
	BCOM_DYN_ENT_TEMPL_CONVVO newAuditVO = new BCOM_DYN_ENT_TEMPL_CONVVO();
	PathPropertyUtil.copyProperties(oldAuditVO, newAuditVO);
	newAuditVO.setSUSPENDED_BY(dynTemplateCO.getUserID());
	newAuditVO.setSUSPENDED_DATE(dynTemplateCO.getRunningDate());
	newAuditVO.setSTATUS(ConstantsCommon.CIF_SUSPENDED);
	newAuditVO.setSERVER_SUSPENDED_DATE(systemDate);

	auditBO.callAudit(oldAuditVO, newAuditVO, dynTemplateCO.getAuditRefCO());
	auditBO.insertAudit(dynTemplateCO.getAuditRefCO());
    }
    
    @Override
    public void ReactivateCustomerConv(DynamicTemplateCO dynTemplateCO) throws BaseException
    {
	dynTemplateCO.getDynTempConvVO().setCOMP_CODE(dynTemplateCO.getCompCode());
	Date systemDate = commonLibBO.returnSystemDateWithTime();
	dynTemplateCO.getDynTempConvVO().setREACTIVATE_BY(dynTemplateCO.getUserID());
	dynTemplateCO.getDynTempConvVO().setREACTIVATE_DATE(dynTemplateCO.getRunningDate());
	dynTemplateCO.getDynTempConvVO().setSTATUS(DynamicTemplateConstant.STATUS_APPROVED);
	dynTemplateCO.getDynTempConvVO().setSERVER_REACTIVATE_DATE(systemDate);
	
	BCOM_DYN_ENT_TEMPL_CONVVO oldAuditVO = (BCOM_DYN_ENT_TEMPL_CONVVO) genericDAO.selectByPK(dynTemplateCO.getDynTempConvVO());
	Integer update = genericDAO.update(dynTemplateCO.getDynTempConvVO());
	if(update == null || update < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}
	BCOM_DYN_ENT_TEMPL_CONVVO newAuditVO = new BCOM_DYN_ENT_TEMPL_CONVVO();
	PathPropertyUtil.copyProperties(oldAuditVO, newAuditVO);
	newAuditVO.setREACTIVATE_BY(dynTemplateCO.getUserID());
	newAuditVO.setREACTIVATE_DATE(dynTemplateCO.getRunningDate());
	newAuditVO.setSTATUS(DynamicTemplateConstant.STATUS_REACTIVATED);
	newAuditVO.setSERVER_REACTIVATE_DATE(systemDate);
	
	auditBO.callAudit(oldAuditVO, newAuditVO, dynTemplateCO.getAuditRefCO());
	auditBO.insertAudit(dynTemplateCO.getAuditRefCO());
    }
    
    @Override
    public HashMap<String  ,SYS_PARAM_SCREEN_DISPLAYVO> returnAccountRequired(DynamicTemplateCO dynTemplateCO) throws BaseException
    {
	RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
	reqFieldSC.setCompCode(dynTemplateCO.getCompCode());
	reqFieldSC.setProgRef(commonLibBO.returnOrginProgRef(dynTemplateCO.getAppName(),
		dynTemplateCO.getProgRef()));
	reqFieldSC.setAppName(dynTemplateCO.getAppName());
	reqFieldSC.setBranchCode(dynTemplateCO.getBranchCode());
	String[] listIds = new String[] {}, listNames = new String[] {}, listIdsToHide = new String[] {},
		listNamesToHide = new String[] {};
	
	 listIds = new String[] { "accBr" };
	 listNames = new String[] { "dynTemplateCO.dynTempConvVO.ACC_BR" };
	 applyDynScreenDisplay(listIds, ConstantsCommon.ACTION_TYPE_MANDATORY, BigDecimal.ONE.toString(),dynTemplateCO.getHm(), reqFieldSC);
	 return dynTemplateCO.getHm();
    }
    
    @Override
    public DynamicTemplateCO retrieveSelectedConvNo(DynamicTemplateSC sc) throws BaseException
    {
	return dynamicTemplateDAO.retrieveSelectedConvNo(sc);
    }
    
    @Override
    public int checkIfAppExist(DynamicTemplateSC sc) throws BaseException
    {
	return  dynamicTemplateDAO.checkIfAppExist(sc);
    }
    
    public BCOM_DYN_ENTITY_APP_LISTVO returnAppNameVO (BCOM_DYN_ENTITY_APP_LISTVO appListVo) throws BaseException
    {
	 return (BCOM_DYN_ENTITY_APP_LISTVO) genericDAO.selectByPK(appListVo);
    } 
}
