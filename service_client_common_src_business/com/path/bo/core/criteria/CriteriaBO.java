package com.path.bo.core.criteria;

import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.AML_PARAM_MAPPINGVO;
import com.path.dbmaps.vo.CTS_CRITERIA_PARAMVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.criteria.CriteriaCO;
import com.path.vo.core.criteria.CriteriaParamCO;
import com.path.vo.core.criteria.CriteriaSC;
import com.path.vo.core.procedureid.ProcedureIdCO;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: tonyelkhoury
 * 
 * 
 */

public interface CriteriaBO
{

    public List<CriteriaCO> returnCriteriaList(CriteriaSC criteriaSC) throws BaseException;

    public Integer returnCriteriaListCount(CriteriaSC criteriaSC) throws BaseException;

    public CriteriaCO returnCriteriaDetails(CriteriaSC criteriaSC) throws BaseException;

    public int returnProcedureListCount(CriteriaSC criteriaSC) throws BaseException;

    public List returnProcedureList(CriteriaSC criteriaSC) throws BaseException;

    // public void checkIfProcedureCanDeleted(CriteriaCO criteriaCO) throws
    // BaseException;

    public void saveProcedures(ArrayList<ProcedureIdCO> procedureIdCOs) throws BaseException;

    public CriteriaCO saveCriteria(CriteriaCO criteriaCO) throws BaseException;

    public void dependencyByCriteriaCode(CriteriaCO criteriaCO) throws BaseException;

    public List<CriteriaParamCO> returnCriteriaParamList(CriteriaSC criteriaSC) throws BaseException;

    public Integer returnCriteriaParamListCount(CriteriaSC criteriaSC) throws BaseException;

    public void checkData(CriteriaCO criteriaCO) throws BaseException;

    public List<CriteriaParamCO> returnCriteriaParamListResult(CriteriaSC criteriaSC) throws BaseException;
    
    public CriteriaParamCO  returnArgumentDetailsResult(CriteriaSC criteriaSC) throws BaseException;

    public void returnCountCriteriaLinkSegment(CriteriaCO criteriaCO) throws BaseException;
    
    public List<CriteriaCO> dependencyByScoreValue(CriteriaCO criteriaCO) throws BaseException;
    
  //By Bilal For TP#750884
    public List<AML_PARAM_MAPPINGVO> returnQryMultiSelectList(CriteriaSC criteriaSC) throws BaseException;

    public Integer returnQryMultiSelectListCount(CriteriaSC criteriaSC) throws BaseException;
    
    public List<AML_PARAM_MAPPINGVO> loadMultiSelectListGrid(CriteriaSC criteriaSC) throws BaseException;
    
    public List<CriteriaParamCO> returnReplaceArgumentSelect(CriteriaSC criteriaSC) throws BaseException;
    
    public List<CriteriaParamCO>  returnArgumentSelectDetails(CriteriaSC criteriaSC) throws BaseException;
    
    public void dependencyByCriteriaReference(CriteriaCO criteriaCO) throws BaseException;
    
    public Integer returnMaxCriteriaCode(CriteriaCO criteriaCO) throws BaseException;
}
