package com.path.dao.core.criteria.impl;

import java.math.BigDecimal;
import java.util.List;
import com.path.dao.core.criteria.CriteriaDAO;
import com.path.dbmaps.vo.AML_PARAM_MAPPINGVO;
import com.path.dbmaps.vo.CTS_CRITERIA_PARAMVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.criteria.CriteriaCO;
import com.path.vo.core.criteria.CriteriaParamCO;
import com.path.vo.core.criteria.CriteriaSC;
import com.path.vo.core.procedureid.ProcedureIdCO;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * @author: tonyelkhoury
 * 
 * 
 */

public class CriteriaDAOImpl extends BaseDAO implements CriteriaDAO
{

	public List<CriteriaCO> returnCriteriaList(CriteriaSC criteriaSC) throws DAOException
	{

		// /*set number of rows to be displayed in the page of grid, and the
		// total number of records */
		DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "criteriaMapper.criteriaResultMap");

		if (criteriaSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("criteriaMapper.returnCriteriaList", criteriaSC);
		}
		else
		{
			/* call the query */
			return getSqlMap().queryForList("criteriaMapper.returnCriteriaList", criteriaSC, criteriaSC.getRecToskip(), criteriaSC.getNbRec());

		}
	}

	public Integer returnCriteriaListCount(CriteriaSC criteriaSC) throws DAOException
	{
		/*
		 * DAOHelper: used to fix the mapping between properties and database column names
		 */
		DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "criteriaMapper.criteriaResultMap");
		return (Integer) getSqlMap().queryForObject("criteriaMapper.returnCriteriaListCount", criteriaSC);
	}

	public CriteriaCO returnCriteriaDetails(CriteriaSC criteriaSC) throws BaseException
	{
		List<CriteriaCO> lst = getSqlMap().queryForList("criteriaMapper.returnCriteriaDetails", criteriaSC);
		return (lst == null || lst.isEmpty()) ? (new CriteriaCO()) : lst.get(0);
	}

	public int returnProcedureListCount(CriteriaSC criteriaSC) throws DAOException
	{
		DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "criteriaMapper.resProcedureListMap");
		return ((Integer) getSqlMap().queryForObject("criteriaMapper.returnProcedureListCount", criteriaSC)).intValue();
	}

	public List returnProcedureList(CriteriaSC criteriaSC) throws DAOException
	{
		DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "criteriaMapper.resProcedureListMap");
		if (criteriaSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("criteriaMapper.returnProcedureList", criteriaSC);
		}
		else
		{
			return getSqlMap().queryForList("criteriaMapper.returnProcedureList", criteriaSC, criteriaSC.getRecToskip(), criteriaSC.getNbRec());
		}
	}

	public void updateCounter(String tableName) throws DAOException
	{
		getSqlMap().update("criteriaMapper.updateCounterVal", tableName);
	}
	
	public void insertCounter(String tableName) throws DAOException
	{
		getSqlMap().update("criteriaMapper.insertCounterVal", tableName);
	}

	public Integer retCounterVal(String tableName) throws DAOException
	{
		Integer t = (Integer) getSqlMap().queryForObject("criteriaMapper.returnCounterVal", tableName);
		return t;
	}

	public int returnProcValue(String procedureName) throws DAOException
	{

		return (Integer) getSqlMap().queryForObject("criteriaMapper.returnProcValue", procedureName);
	}

	public void saveProcedureDetails(ProcedureIdCO procedureIdCO) throws DAOException
	{

		getSqlMap().insert("criteriaMapper.saveProcedureDetails", procedureIdCO);
	}

	public int checkduplicateCriteriaCode(CriteriaCO criteriaCO) throws DAOException
	{
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("criteriaMapper.checkduplicateCriteriaCode", criteriaCO)).intValue();
		return nb;

	}

	public List<CriteriaParamCO> returnCriteriaParamList(CriteriaSC criteriaSC) throws DAOException
	{
		DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "criteriaMapper.criteriaParamResultMap");

		if (criteriaSC.getIsSybase() == 1)
		{
			criteriaSC.setSortOrder("ORDER BY PARAM_ORDER");
		}

		if (criteriaSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("criteriaMapper.returnCriteriaParamList", criteriaSC);
		}
		else
		{
			/* call the query */

			return getSqlMap().queryForList("criteriaMapper.returnCriteriaParamList", criteriaSC, criteriaSC.getRecToskip(), criteriaSC.getNbRec());

		}

	}

	public List<CriteriaParamCO> returnQueryParamList(CriteriaSC criteriaSC) throws DAOException
	{
		DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "criteriaMapper.queryParamResultMap");

		if (criteriaSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("criteriaMapper.returnQueryParamList", criteriaSC);
		}
		else
		{
			/* call the query */

			return getSqlMap().queryForList("criteriaMapper.returnQueryParamList", criteriaSC, criteriaSC.getRecToskip(), criteriaSC.getNbRec());

		}

	}

	public Integer returnCriteriaParamListCount(CriteriaSC criteriaSC) throws DAOException
	{
		DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "criteriaMapper.criteriaParamResultMap");
		int a = (Integer) getSqlMap().queryForObject("criteriaMapper.returnCriteriaParamListCount", criteriaSC);
		return a;

	}

	// public Integer returnCriteriaParamNewListCount(CriteriaSC criteriaSC)
	// throws DAOException
	// {
	//
	// DAOHelper.fixGridMaps(criteriaSC, getSqlMap(),
	// "criteriaMapper.criteriaParamResultMap");
	// int a = (Integer)
	// getSqlMap().queryForObject("criteriaMapper.returnCriteriaNewParamListCount",
	// criteriaSC);
	// return a;
	//
	// }

	// public List<CriteriaParamCO> returnCriteriaNewParamList(CriteriaSC
	// criteriaSC) throws DAOException
	// {
	//
	// DAOHelper.fixGridMaps(criteriaSC, getSqlMap(),
	// "criteriaMapper.criteriaParamResultMap");
	//
	// if(criteriaSC.getNbRec() == -1)
	// {
	// return
	// getSqlMap().queryForList("criteriaMapper.returnCriteriaNewPramList",
	// criteriaSC);
	// }
	// else
	// {
	// /* call the query */
	//
	// return
	// getSqlMap().queryForList("criteriaMapper.returnCriteriaNewPramList",
	// criteriaSC,
	// criteriaSC.getRecToskip(), criteriaSC.getNbRec());
	//
	// }
	//
	// }

	public void deleteCriteriaParam(CriteriaCO criteriaCO) throws DAOException
	{

		sqlMap.delete("criteriaMapper.deleteCriteriaParam", criteriaCO);
	}

	public CriteriaCO returnQueryById(BigDecimal queryId) throws DAOException
	{

		return (CriteriaCO) getSqlMap().queryForObject("criteriaMapper.returnProcValue", queryId);
	}

	public CriteriaParamCO returnArgumentDetails(CriteriaSC criteriaSC) throws DAOException
	{
		return (CriteriaParamCO) getSqlMap().queryForObject("criteriaMapper.returnArgumentDetails", criteriaSC);
	}

	/**
	 * @author raniaalbitar
	 * 718813 - Dynamic Customer Scoring on latest
	 */
	public int returnCountCriteriaLinkSegment(CriteriaCO criteriaCO) throws DAOException
	{
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("criteriaMapper.returnCountCriteriaLinkSegment", criteriaCO)).intValue();
		return nb;

	}
	
	/**
	 * @author RaniaAlBitar
	 * ABSAI180073 - FICA Risk Matrix calculation
	 */
	
	public List<CriteriaCO> dependencyByScoreValue(CriteriaCO criteriaCO) throws DAOException
	{
	    return getSqlMap().queryForList("criteriaMapper.dependencyByScoreValue", criteriaCO);
	}
	

	@Override
	public List<AML_PARAM_MAPPINGVO> returnQryMultiSelectList(CriteriaSC criteriaSC) throws DAOException {
		DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "criteriaMapper.multiSelectResultMap");

		if (criteriaSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("criteriaMapper.returnValuesMultiSelectList", criteriaSC);
		}
		else
		{
			/* call the query */
			return getSqlMap().queryForList("criteriaMapper.returnValuesMultiSelectList", criteriaSC, criteriaSC.getRecToskip(), criteriaSC.getNbRec());

		}
	}

	@Override
	public Integer returnQryMultiSelectListCount(CriteriaSC criteriaSC) throws DAOException {
		DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "criteriaMapper.multiSelectResultMap");
		return (Integer) getSqlMap().queryForObject("criteriaMapper.returnValuesMultiSelectCount", criteriaSC);
	}

	@Override
	public Integer getMaxLineNo(CriteriaSC criteriaSC) throws DAOException {
		return (Integer) getSqlMap().queryForObject("criteriaMapper.returnMaxLineNo", criteriaSC);
	}

	@Override
	public List<AML_PARAM_MAPPINGVO> loadMultiSelectListGrid(CriteriaSC criteriaSC) throws DAOException {
		DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "criteriaMapper.multiSelectResultMap");

		if (criteriaSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("criteriaMapper.loadMultiSelectListGrid", criteriaSC);
		}
		else
		{
			/* call the query */
			return getSqlMap().queryForList("criteriaMapper.loadMultiSelectListGrid", criteriaSC, criteriaSC.getRecToskip(), criteriaSC.getNbRec());

		}
	}

	@Override
	public void deleteOldListSelected(CriteriaCO criteriaCO) throws DAOException {
		sqlMap.delete("criteriaMapper.deleteOldListSelected", criteriaCO);
	}

	@Override
	public List<CriteriaParamCO> returnReplaceArgumentSelect(CriteriaSC criteriaSC) throws DAOException {
		DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "criteriaMapper.criteriaOldParamResultMap");

		if (criteriaSC.getIsSybase() == 1)
		{
			criteriaSC.setSortOrder("ORDER BY PARAM_ORDER");
		}

		return getSqlMap().queryForList("criteriaMapper.returnReplaceArgumentSelect", criteriaSC);
	}

	@Override
	public List<CriteriaParamCO> returnArgumentSelectDetails(CriteriaSC criteriaSC) throws DAOException {
		return (List<CriteriaParamCO>) getSqlMap().queryForList("criteriaMapper.returnArgumentSelectDetails", criteriaSC);
	}
	//bug 969312
	@Override
	public Integer returnMaxCriteriaCode(CriteriaCO criteriaCO) throws DAOException {
		return (Integer) getSqlMap().queryForObject("criteriaMapper.returnMaxCriteriaCode", criteriaCO);
	}

	public Integer dependencyByCriteriaReference(CriteriaCO criteriaCO) throws DAOException 
	{
		return (Integer) getSqlMap().queryForObject("criteriaMapper.checkCriteriaReferenceUniqueness", criteriaCO);	
	}

	// by bilal for BUG#974752
	@Override
	public Integer getArgumentQueryId(CriteriaSC criteriaSC) throws DAOException {
		return (Integer) getSqlMap().queryForObject("criteriaMapper.getArgumentQueryId", criteriaSC);
	}

	// by bilal for BUG#974752
	@Override
	public Integer getArgumentPrcId(CriteriaSC criteriaSC) throws DAOException {
		return (Integer) getSqlMap().queryForObject("criteriaMapper.getArgumentPrcId", criteriaSC);
	}
	
}
