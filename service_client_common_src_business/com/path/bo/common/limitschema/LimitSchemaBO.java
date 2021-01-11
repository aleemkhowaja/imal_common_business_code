/**
 * 
 */
package com.path.bo.common.limitschema;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.limitschema.LimitSchemaCO;
import com.path.vo.common.limitschema.LimitSchemaSC;
import com.path.vo.common.signature.SignatureSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * LimitSchemaBO.java used to
 */
public interface LimitSchemaBO
{
    public List<LimitSchemaCO> returnLimitSchemaList(LimitSchemaSC limitSchemaSC) throws BaseException;

    public int returnLimitSchemaListCount(LimitSchemaSC limitSchemaSC) throws BaseException;
    
    public LimitSchemaCO saveLimitSchema(LimitSchemaSC limitSchemaSC,List<LimitSchemaCO> limitSchemaList, LimitSchemaCO limitSchemaCO) throws BaseException;
    
    public void validateAddNewRow(List<LimitSchemaCO> limitSchemaList) throws BaseException;
    
    public void onChangeEffectiveFromDate(LimitSchemaCO limitSchemaCO) throws BaseException;
    
    public void onChangeEffectiveToDate(LimitSchemaCO limitSchemaCO) throws BaseException;
    
    public boolean checkIfLimitSchemaIsReadonly(String status,String menuCrud,String saveType) throws BaseException;
    
    public void approveLimitSchema(List<LimitSchemaCO> limitSchemaList) throws BaseException;    
    
    public void rejectLimitSchema(List<LimitSchemaCO> limitSchemaList) throws BaseException;
    
    public void saveLimitSchemaFromSign(List<LimitSchemaCO> limitSchemaCOList,boolean isAutoApprove, LimitSchemaCO limitSchemaCO) throws BaseException;
    
    public int returnLimitSchemaCountForACCOrCIF(SignatureSC signatureSC)throws BaseException;
    
    public List<LimitSchemaCO> returnLimitSchemaForACCOrCIF(SignatureSC signatureSC)throws BaseException;
    public int checkNegativeComp(LimitSchemaSC limitSchemaSC) throws BaseException;
    
    public LimitSchemaCO initialise(LimitSchemaCO limitSchemaCO) throws BaseException;    
}
