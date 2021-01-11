package com.path.dao.common.dynamictemplate.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.common.dynamictemplate.DynamicTemplateDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.dynamictemplate.DynamicTemplateCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;
import com.path.vo.common.tree.TreeNodeCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * DynamicTemplateDAOImpl.java used to
 */
public class DynamicTemplateDAOImpl extends BaseDAO implements DynamicTemplateDAO
{
    @Override
    public int returnDynamicTemplateListCount(DynamicTemplateSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dynamicTemplateMapper.resDynamicTemplateListMap");
	return ((Integer) getSqlMap().queryForObject("dynamicTemplateMapper.returnDynamicTemplateListCount", criteria))
		.intValue();
    }

    @Override
    public List returnDynamicTemplateList(DynamicTemplateSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dynamicTemplateMapper.resDynamicTemplateListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dynamicTemplateMapper.returnDynamicTemplateList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dynamicTemplateMapper.returnDynamicTemplateList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    @Override
    public DynamicTemplateCO retrieveSelectedDynTempId(DynamicTemplateSC dynTemplateSC) throws DAOException
    {
	return ((DynamicTemplateCO) getSqlMap().queryForObject("dynamicTemplateMapper.retrieveSelectedDynTempId",
		dynTemplateSC));
    }

    @Override
    public List<TreeNodeCO> returnTreeNodes(DynamicTemplateSC sc) throws DAOException
    {
	return ((List<TreeNodeCO>) getSqlMap().queryForList("dynamicTemplateMapper.returnTreeNodes", sc));
    }

    @Override
    public int retSysParamScreenChrgListCount(DynamicTemplateSC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "dynamicTemplateMapper.retSysParamScreenChrgListMap");
	return ((Integer) getSqlMap().queryForObject("dynamicTemplateMapper.retSysParamScreenChrgListCount", sc))
		.intValue();
    }
    
    @Override
    public List retSysParamScreenChrgList(DynamicTemplateSC sc) throws DAOException
    {
	DAOHelper.fixGridMaps(sc, getSqlMap(), "dynamicTemplateMapper.retSysParamScreenChrgListMap");
	if(sc.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dynamicTemplateMapper.retSysParamScreenChrgList", sc);
	}
	else
	{
	    return getSqlMap().queryForList("dynamicTemplateMapper.retSysParamScreenChrgList", sc,
		    sc.getRecToskip(), sc.getNbRec());
	}
    }
    
    @Override
    public DynamicTemplateCO retScreenDetails(DynamicTemplateSC criteria) throws DAOException
    {
	return ((DynamicTemplateCO) getSqlMap().queryForObject("dynamicTemplateMapper.retScreenDetails",criteria));
    }
    
    @Override
    public DynamicTemplateCO retrieveSelectNodesDesc(DynamicTemplateSC sc) throws DAOException
    {
	return ((DynamicTemplateCO) getSqlMap().queryForObject("dynamicTemplateMapper.retrieveSelectNodesDesc",sc));
    }
    
    @Override
    public DynamicTemplateCO retrieveSelectNodesDescWithoutScreenId(DynamicTemplateSC sc) throws DAOException
    {
	return ((DynamicTemplateCO) getSqlMap().queryForObject("dynamicTemplateMapper.retrieveSelectNodesDescWithoutScreenId",sc));
    }
    
    @Override
    public int returnDynTempId() throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dynamicTemplateMapper.returnDynTempId",null ))
		.intValue();
	return nb;
    }
    
    @Override
    public int checkNodeIfExist(DynamicTemplateCO dynTemplateCO) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("dynamicTemplateMapper.checkNodeIfExist",dynTemplateCO )).intValue();
    }
    
    @Override
    public BigDecimal retSavedDynTempId(DynamicTemplateCO dynTemplateCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("dynamicTemplateMapper.retSavedDynTempId",dynTemplateCO );
    }
   
    @Override
    public void deleteDynChrgTempNodes(DynamicTemplateCO dynTemplateCO) throws DAOException
    {
	getSqlMap().queryForObject("dynamicTemplateMapper.deleteDynChrgTempNodes",dynTemplateCO );
    }
    
    @Override
    public List<DynamicTemplateCO> retNodesList(DynamicTemplateSC criteria) throws DAOException
    {
	return (List<DynamicTemplateCO>) getSqlMap().queryForList("dynamicTemplateMapper.retNodesList",criteria );
    }
    
    @Override
    public BigDecimal retNoderOrderRelatedToParent(DynamicTemplateCO dynTemplateCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("dynamicTemplateMapper.retNoderOrderRelatedToParent",dynTemplateCO );
    }
    
    @Override
    public int returnDynamicTemplateConvListCount(DynamicTemplateSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dynamicTemplateMapper.resDynamicTemplateConvListMap");
	return ((Integer) getSqlMap().queryForObject("dynamicTemplateMapper.returnDynamicTemplateConvListCount", criteria))
		.intValue();
    }

    @Override
    public List returnDynamicTemplateConvList(DynamicTemplateSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dynamicTemplateMapper.resDynamicTemplateConvListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dynamicTemplateMapper.returnDynamicTemplateConvList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dynamicTemplateMapper.returnDynamicTemplateConvList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }
    
    @Override
    public BigDecimal returnDynTempConvNO() throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("dynamicTemplateMapper.returnDynTempConvNO", null);
    }
    
    @Override
    public DynamicTemplateCO retrieveSelectedConvNo(DynamicTemplateSC sc) throws DAOException
    {
	return ((DynamicTemplateCO) getSqlMap().queryForObject("dynamicTemplateMapper.retrieveSelectedConvNo", sc));
    }
    
    @Override
    public DynamicTemplateCO checkOldConvRecord(BigDecimal convNumb) throws DAOException
    {
	return ((DynamicTemplateCO) getSqlMap().queryForObject("dynamicTemplateMapper.checkOldConvRecord", convNumb));
    }
    
    @Override
    public int checkIfAppExist(DynamicTemplateSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("dynamicTemplateMapper.checkIfAppExist", criteria));
    }

    @Override
    public Integer updateTemplateNode(DynamicTemplateCO dynTemplateCO) throws DAOException
    {
	// TODO Auto-generated method stub
	return getSqlMap().update("dynamicTemplateMapper.updateTemplateNode",dynTemplateCO);
    }

    @Override
    public Integer returnNbrOfChilds(DynamicTemplateCO dynTemplateCO) throws DAOException
    {
	// TODO Auto-generated method stub
	return ((Integer) getSqlMap().queryForObject("dynamicTemplateMapper.returnNbrOfChilds", dynTemplateCO));
    }
}
