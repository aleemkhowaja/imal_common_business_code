package com.path.dao.common.dynamictemplate;

import java.math.BigDecimal;
import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.common.dynamictemplate.DynamicTemplateCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;
import com.path.vo.common.tree.TreeNodeCO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTemplateDAO.java used to
 */
public interface DynamicTemplateDAO 
{
	public int returnDynamicTemplateListCount(DynamicTemplateSC criteria) throws DAOException;
	public List returnDynamicTemplateList(DynamicTemplateSC criteria) throws DAOException;	
	public DynamicTemplateCO retrieveSelectedDynTempId(DynamicTemplateSC dynTemplateSC) throws DAOException;
	public List<TreeNodeCO> returnTreeNodes(DynamicTemplateSC sc) throws DAOException;
	public int retSysParamScreenChrgListCount(DynamicTemplateSC sc) throws DAOException;
	public List retSysParamScreenChrgList(DynamicTemplateSC sc) throws DAOException;	
	public DynamicTemplateCO retScreenDetails(DynamicTemplateSC criteria) throws DAOException;
	public DynamicTemplateCO retrieveSelectNodesDesc(DynamicTemplateSC sc) throws DAOException;
	public int returnDynTempId() throws DAOException;
	public int checkNodeIfExist(DynamicTemplateCO dynTemplateCO) throws DAOException;
	public BigDecimal retSavedDynTempId(DynamicTemplateCO dynTemplateCO) throws DAOException;
	public void deleteDynChrgTempNodes(DynamicTemplateCO dynTemplateCO) throws DAOException;
	public List<DynamicTemplateCO> retNodesList(DynamicTemplateSC criteria) throws DAOException;
	public DynamicTemplateCO retrieveSelectNodesDescWithoutScreenId(DynamicTemplateSC sc) throws DAOException;
	public BigDecimal retNoderOrderRelatedToParent(DynamicTemplateCO dynTemplateCO) throws DAOException;
	public int returnDynamicTemplateConvListCount(DynamicTemplateSC criteria) throws DAOException;
	public List returnDynamicTemplateConvList(DynamicTemplateSC criteria) throws DAOException;	
	public BigDecimal returnDynTempConvNO() throws DAOException;
	public DynamicTemplateCO retrieveSelectedConvNo(DynamicTemplateSC sc) throws DAOException;
	public DynamicTemplateCO checkOldConvRecord(BigDecimal convNumb) throws DAOException;
	public int checkIfAppExist(DynamicTemplateSC criteria) throws DAOException;
	public Integer updateTemplateNode(DynamicTemplateCO dynTemplateCO) throws DAOException;
	public Integer returnNbrOfChilds(DynamicTemplateCO dynTemplateCO)throws DAOException;
	
}