/**
 * 
 */
package com.path.dao.common.limitschema;

import java.util.List;

import com.path.dbmaps.vo.LIMIT_SCHEMAVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.limitschema.LimitSchemaCO;
import com.path.vo.common.limitschema.LimitSchemaSC;
import com.path.vo.common.signature.SignatureSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * LimitSchemaDAO.java used to
 */
public interface LimitSchemaDAO
{
    public List<LimitSchemaCO> returnLimitSchemaList(LimitSchemaSC limitSchemaSC) throws DAOException;

    public int returnLimitSchemaListCount(LimitSchemaSC limitSchemaSC) throws DAOException;

    public void deleteLimitSchema(LimitSchemaSC limitSchemaSC) throws DAOException;
    
    public int returnlimitSchemaCountForACCOrCIF(SignatureSC signatureSC)throws DAOException;
    
    public List<LimitSchemaCO> returnlimitSchemaForACCOrCIF(SignatureSC signatureSC)throws DAOException;
    
    public int selectMaxOfLimitSchema(LIMIT_SCHEMAVO limitSchemaVO)throws DAOException;
    
    public int selectMaxOfLimitSchemaTemp(LIMIT_SCHEMAVO limitSchemaVO)throws DAOException;
    
    public void deleteLimitSchemaTemp(LIMIT_SCHEMAVO limitSchemaVO) throws DAOException;

}
