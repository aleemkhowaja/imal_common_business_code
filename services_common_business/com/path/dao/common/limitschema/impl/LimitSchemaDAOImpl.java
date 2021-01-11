/**
 * 
 */
package com.path.dao.common.limitschema.impl;

import java.util.List;

import com.path.dao.common.limitschema.LimitSchemaDAO;
import com.path.dbmaps.vo.LIMIT_SCHEMAVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.limitschema.LimitSchemaCO;
import com.path.vo.common.limitschema.LimitSchemaSC;
import com.path.vo.common.signature.SignatureSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * LimitSchemaDAOImpl.java used to
 */
public class LimitSchemaDAOImpl extends BaseDAO implements LimitSchemaDAO
{

    @SuppressWarnings("unchecked")
    @Override
    public List<LimitSchemaCO> returnLimitSchemaList(LimitSchemaSC limitSchemaSC) throws DAOException
    {
	DAOHelper.fixGridMaps(limitSchemaSC, getSqlMap(), "limitSchema.limitSchemaResultMap");
	if(limitSchemaSC.getNbRec() == -1){
	    return getSqlMap().queryForList("limitSchema.limitSchemaGridList", limitSchemaSC);		    
	}
	else{
	    return getSqlMap().queryForList("limitSchema.limitSchemaGridList", limitSchemaSC, limitSchemaSC.getRecToskip(), limitSchemaSC.getNbRec());
	}
    }

    @Override
    public int returnLimitSchemaListCount(LimitSchemaSC limitSchemaSC) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("limitSchema.limitSchemaGridListCount", limitSchemaSC)).intValue();
	return nb;
    }

    @Override
    public void deleteLimitSchema(LimitSchemaSC limitSchemaSC) throws DAOException
    {
	 getSqlMap().delete("limitSchema.deleteLimitSchemaList", limitSchemaSC);
    }
    
    public int returnlimitSchemaCountForACCOrCIF(SignatureSC signatureSC)throws DAOException{
    	return ((Integer) getSqlMap().queryForObject("limitSchema.limitSchemaCountForACCOrCIF", signatureSC)).intValue();
    }
    
    public List<LimitSchemaCO> returnlimitSchemaForACCOrCIF(SignatureSC signatureSC)throws DAOException{
    	return getSqlMap().queryForList("limitSchema.limitSchemaForACCOrCIF", signatureSC);
    	
    }
    
    public int selectMaxOfLimitSchema(LIMIT_SCHEMAVO limitSchemaVO)throws DAOException{
    	return ((Integer) getSqlMap().queryForObject("limitSchema.selectMaxOfLimitSchema", limitSchemaVO)).intValue();
    }
    
    public int selectMaxOfLimitSchemaTemp(LIMIT_SCHEMAVO limitSchemaVO)throws DAOException{
    	return ((Integer) getSqlMap().queryForObject("limitSchema.selectMaxOfLimitSchemaTemp", limitSchemaVO)).intValue();
    }
    public void deleteLimitSchemaTemp(LIMIT_SCHEMAVO limitSchemaVO) throws DAOException
    {
	 getSqlMap().delete("limitSchema.deleteLimitSchemaTemp", limitSchemaVO);
    }


}
