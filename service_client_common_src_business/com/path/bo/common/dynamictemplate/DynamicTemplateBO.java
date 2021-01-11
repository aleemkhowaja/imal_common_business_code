package com.path.bo.common.dynamictemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.BCOM_DYN_ENTITY_APP_LISTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.dynamictemplate.DynamicTemplateCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;
import com.path.vo.common.tree.TreeNodeCO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTemplateBO.java used to
 */
public interface DynamicTemplateBO
{
    /**
     * Method used to return count of DynamicTemplate Screen
     * 
     * @param DynamicTemplateaSC Search DynamicTemplateSC Parameter
     * @return integer
     * @throws BaseException
     */
    public int returnDynamicTemplateListCount(DynamicTemplateSC criteria) throws BaseException;

    /**
     * Method used to return list of DynamicTemplate Screen
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return list
     * @throws BaseException
     */
    public List returnDynamicTemplateList(DynamicTemplateSC criteria) throws BaseException;

    /**
     * Method used to return selected DynTempId
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return DynamicTemplateCO
     * @throws BaseException
     */
    public DynamicTemplateCO retrieveSelectedDynTempId(DynamicTemplateSC dynTemplateSC) throws BaseException;

    /**
     * Method used to return the TreeNode
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return list<TreeNodeCO>
     * @throws BaseException
     */
    public List<TreeNodeCO> returnTreeNodes(DynamicTemplateSC sc) throws BaseException;

    /**
     * Method used to return count of SysParamLookup Screen
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return int
     * @throws BaseException
     */
    public int retSysParamScreenChrgListCount(DynamicTemplateSC sc) throws BaseException;

    /**
     * Method used to return list of SysParamLookup Screen
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return list
     * @throws BaseException
     */
    public List retSysParamScreenChrgList(DynamicTemplateSC sc) throws BaseException;

    /**
     * Method used to return ScreenDetails
     * 
     * @param BigDecimal Search BigDecimal Parameter
     * @return DynamicTemplateCO
     * @throws BaseException
     */
    public DynamicTemplateCO retScreenDetails(DynamicTemplateSC criteria) throws BaseException;

    /**
     * Method used to retrieve Selected Nodes Desc
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return DynamicTemplateCO
     * @throws BaseException
     */
    public DynamicTemplateCO retrieveSelectNodesDesc(DynamicTemplateSC sc) throws BaseException;

    /**
     * Method used to save Selected Nodes
     * 
     * @param DynamicTemplateCO Search DynamicTemplateSC Parameter
     * @return 
     * @throws BaseException
     */
    public void save(DynamicTemplateCO dynTemplateCO) throws BaseException;

    /**
     * Method used to return Saved DynTempId
     * 
     * @param String Search DynamicTemplateSC Parameter
     * @return BigDecimal
     * @throws BaseException
     */
    public BigDecimal retSavedDynTempId(DynamicTemplateCO dynTemplateCO) throws BaseException;

    /**
     * Method used to delete Selected Nodes
     * 
     * @param DynamicTemplateCO Search DynamicTemplateSC Parameter
     * @return 
     * @throws BaseException
     */
    public void deleteNode(DynamicTemplateCO dynTemplateCO) throws BaseException;

    /**
     * Method used to delete all node related to a specific application from the grid 
     * 
     * @param DynamicTemplateCO Search DynamicTemplateSC Parameter
     * @return 
     * @throws BaseException
     */
    public void deleteDynTempId(DynamicTemplateCO dynTemplateCO) throws BaseException;

    /**
     * Method used to return Nodes List related to a specific application 
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return List<DynamicTemplateCO>
     * @throws BaseException
     */
    public List<DynamicTemplateCO> retNodesList(DynamicTemplateSC criteria) throws BaseException;

    /**
     * Method used to retrieve Selected Nodes Desc Without ScreenId 
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return List<DynamicTemplateCO>
     * @throws BaseException
     */
    public DynamicTemplateCO retrieveSelectNodesDescWithoutScreenId(DynamicTemplateSC sc) throws BaseException;

    /**
     * Method used to return count of DynamicTemplate Customer Convention Screen
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return int
     * @throws BaseException
     */
    public int returnDynamicTemplateConvListCount(DynamicTemplateSC criteria) throws BaseException;

    /**
     * Method used to return list of DynamicTemplate Customer Convention Screen
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return list
     * @throws BaseException
     */
    public List returnDynamicTemplateConvList(DynamicTemplateSC criteria) throws BaseException;

    /**
     * Method used to save Dynamic Template Customer Convention
     * 
     * @param DynamicTemplateCO Search DynamicTemplateSC Parameter
     * @return 
     * @throws BaseException
     */
    public void saveDynTempConv(DynamicTemplateCO dynTemplateCO) throws BaseException;

    /**
     * Method used to set the account requiered
     * 
     * @param DynamicTemplateCO Search DynamicTemplateSC Parameter
     * @return HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>
     * @throws BaseException
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> returnAccountRequired(DynamicTemplateCO dynTemplateCO)throws BaseException;

    /**
     * Method used to retrieve selected Dynamic Template Customer Convention
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return DynamicTemplateCO
     * @throws BaseException
     */
    public DynamicTemplateCO retrieveSelectedConvNo(DynamicTemplateSC sc) throws BaseException;

    /**
     * Method used to delete Dynamic Template Customer Convention
     * 
     * @param DynamicTemplateCO Search DynamicTemplateSC Parameter
     * @return 
     * @throws BaseException
     */
    public void deleteCustomerConv(DynamicTemplateCO dynTemplateCO) throws BaseException;

    /**
     * Method used to approve Dynamic Template Customer Convention
     * 
     * @param DynamicTemplateCO Search DynamicTemplateSC Parameter
     * @return 
     * @throws BaseException
     */
    public void ApproveCustomerConv(DynamicTemplateCO dynTemplateCO) throws BaseException;

    /**
     * Method used to reject Dynamic Template Customer Convention
     * 
     * @param DynamicTemplateCO Search DynamicTemplateSC Parameter
     * @return 
     * @throws BaseException
     */
    public void RejectCustomerConv(DynamicTemplateCO dynTemplateCO) throws BaseException;

    /**
     * Method used to suspend Dynamic Template Customer Convention
     * 
     * @param DynamicTemplateCO Search DynamicTemplateSC Parameter
     * @return 
     * @throws BaseException
     */
    public void SuspendCustomerConv(DynamicTemplateCO dynTemplateCO) throws BaseException;

    /**
     * Method used to reactivate Dynamic Template Customer Convention
     * 
     * @param DynamicTemplateCO Search DynamicTemplateSC Parameter
     * @return 
     * @throws BaseException
     */
    public void ReactivateCustomerConv(DynamicTemplateCO dynTemplateCO) throws BaseException;
    
    /**
     * Method used to reactivate Dynamic Template Customer Convention
     * 
     * @param DynamicTemplateSC Search DynamicTemplateSC Parameter
     * @return 
     * @throws BaseException
     */
    public int checkIfAppExist(DynamicTemplateSC sc) throws BaseException;
    
    public BCOM_DYN_ENTITY_APP_LISTVO returnAppNameVO(BCOM_DYN_ENTITY_APP_LISTVO appNameVO) throws BaseException;
}