package com.path.dao.core.criteria;

import java.math.BigDecimal;
import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.criteria.CriteriaCO;
import com.path.vo.core.criteria.CriteriaParamCO;
import com.path.vo.core.criteria.CriteriaSC;
import com.path.vo.core.procedureid.ProcedureIdCO;
import com.path.dbmaps.vo.AML_PARAM_MAPPINGVO;
import com.path.dbmaps.vo.CTS_CRITERIA_PARAMVO;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: tonyelkhoury
 * 
 * 
 */
public interface CriteriaDAO
{

    public List<CriteriaCO> returnCriteriaList(CriteriaSC criteriaSC) throws DAOException;

    public Integer returnCriteriaListCount(CriteriaSC criteriaSC) throws DAOException;

    public CriteriaCO returnCriteriaDetails(CriteriaSC criteriaSC) throws BaseException;

    public int returnProcedureListCount(CriteriaSC criteriaSC) throws DAOException;

    public List returnProcedureList(CriteriaSC criteriaSC) throws DAOException;

    public Integer retCounterVal(String tableName) throws DAOException;

    public void updateCounter(String tableName) throws DAOException;

    public int returnProcValue(String procedureName) throws DAOException;

    public void saveProcedureDetails(ProcedureIdCO procedureIdCO) throws DAOException;

    public int checkduplicateCriteriaCode(CriteriaCO criteriaCO) throws DAOException;

    public List<CriteriaParamCO> returnCriteriaParamList(CriteriaSC criteriaSC) throws DAOException;

    public Integer returnCriteriaParamListCount(CriteriaSC criteriaSC) throws DAOException;

    // public Integer returnCriteriaParamNewListCount(CriteriaSC
    // criteriaSC)throws DAOException;
    // public List<CriteriaParamCO> returnCriteriaNewParamList(CriteriaSC
    // criteriaSC)throws DAOException;
    public void deleteCriteriaParam(CriteriaCO criteriaCO) throws DAOException;

    public CriteriaCO returnQueryById(BigDecimal queryId) throws DAOException;
    
    public CriteriaParamCO returnArgumentDetails(CriteriaSC criteriaSC) throws DAOException;
    
    public List<CriteriaParamCO> returnQueryParamList(CriteriaSC criteriaSC) throws DAOException;

    public int returnCountCriteriaLinkSegment(CriteriaCO criteriaCO) throws DAOException;
    
    public List<CriteriaCO> dependencyByScoreValue(CriteriaCO criteriaCO) throws DAOException;
    
    public void insertCounter(String tableName) throws DAOException;
    //By Bilal For TP#750884
      public List<AML_PARAM_MAPPINGVO> returnQryMultiSelectList(CriteriaSC criteriaSC) throws DAOException;

      public Integer returnQryMultiSelectListCount(CriteriaSC criteriaSC) throws DAOException;
      
      //By Bilal For TP#750884
      public Integer getMaxLineNo(CriteriaSC criteriaSC) throws DAOException;
      
      public List<AML_PARAM_MAPPINGVO> loadMultiSelectListGrid(CriteriaSC criteriaSC) throws DAOException;
      
      public void deleteOldListSelected(CriteriaCO criteriaCO) throws DAOException;

      public List<CriteriaParamCO> returnReplaceArgumentSelect(CriteriaSC criteriaSC) throws DAOException;
      
      public List<CriteriaParamCO> returnArgumentSelectDetails(CriteriaSC criteriaSC) throws DAOException;
      
      public Integer returnMaxCriteriaCode(CriteriaCO criteriaCO) throws DAOException;
      
      public Integer dependencyByCriteriaReference(CriteriaCO criteriaCO) throws DAOException;
      
      public Integer getArgumentQueryId(CriteriaSC criteriaSC) throws DAOException;
      
      public Integer getArgumentPrcId(CriteriaSC criteriaSC) throws DAOException;
      
}
