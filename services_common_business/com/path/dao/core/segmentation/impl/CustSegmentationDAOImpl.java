package com.path.dao.core.segmentation.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dao.core.segmentation.CustSegmentationDAO;
import com.path.dbmaps.vo.AML_PARAM_MAPPINGVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_SEGMENTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.core.segmentation.CustSegmentationCO;
import com.path.vo.core.segmentation.CustSegmentationParamCO;
import com.path.vo.core.segmentation.CustSegmentationProcessCO;
import com.path.vo.core.segmentation.CustSegmentationSC;
import com.path.vo.core.segmentation.ExcludeCIFSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * CustSegmentationDAOImpl.java used to
 */
public class CustSegmentationDAOImpl extends BaseDAO implements CustSegmentationDAO
{

    /**
     * Method used to return Count of CustSegmentation
     * 
     * @param criteria Search Criteria Parameter
     * @return int Result number of Records
     * @throws DAOException
     */
    public int returnCustSegmentationListCount(CustSegmentationSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "custSegmentationMapper.resCustSegmentationListMap");
	return ((Integer) getSqlMap().queryForObject("custSegmentationMapper.returnCustSegmentationListCount",
		criteria)).intValue();
    }

    /**
     * Method used to return List of CustSegmentation
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws DAOException
     */
    public List returnCustSegmentationList(CustSegmentationSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "custSegmentationMapper.resCustSegmentationListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("custSegmentationMapper.returnCustSegmentationList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("custSegmentationMapper.returnCustSegmentationList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    public CustSegmentationCO returnCustSegmentationForm(CustSegmentationSC custSegmentationSC) throws DAOException
    {

	return (CustSegmentationCO) getSqlMap().queryForObject("custSegmentationMapper.returnCustSegmentationForm",
		custSegmentationSC);

    }

    public int dependencyBySegmentCode(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("custSegmentationMapper.dependencyBySegmentCode",
		custSegmentationSC);
    }

    // RETREIVE GRID VIEW : DETAILS
    public int returnCustSegmentationDetailListCount(CustSegmentationSC custSegmentationSC) throws DAOException
    {

	DAOHelper.fixGridMaps(custSegmentationSC, getSqlMap(),
		"custSegmentationMapper.resCustomerSegmentationDetailListMap");
	return ((Integer) getSqlMap().queryForObject("custSegmentationMapper.returnCustSegmentationDetailListCount",
		custSegmentationSC)).intValue();
    }

    // RETREIVE GRID VIEW : DETAILS

    public List returnCustSegmentationDetailList(CustSegmentationSC custSegmentationSC) throws DAOException
    {

	DAOHelper.fixGridMaps(custSegmentationSC, getSqlMap(),
		"custSegmentationMapper.resCustomerSegmentationDetailListMap");

	custSegmentationSC.setSortOrder("ORDER BY LINE_NO ASC");

	if(custSegmentationSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("custSegmentationMapper.returnCustSegmentationDetailList",
		    custSegmentationSC);
	}
	else
	{
	    List list = getSqlMap().queryForList("custSegmentationMapper.returnCustSegmentationDetailList",
		    custSegmentationSC, custSegmentationSC.getRecToskip(), custSegmentationSC.getNbRec());

	    return list;
	}
    }

    public int dependencyByCriteriaCode(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("custSegmentationMapper.dependencyByCriteriaCode",
		custSegmentationSC);
    }

    public String returnCriteriaDesc(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	return (String) getSqlMap().queryForObject("custSegmentationMapper.returnCriteriaDesc", custSegmentationSC);
    }

    // Retreive Exclude CIF grid in POPUP SCREEN

    public int returnExcludeCIFsDetailListCount(ExcludeCIFSC excludeCIFSC) throws DAOException
    {
	DAOHelper.fixGridMaps(excludeCIFSC, getSqlMap(), "custSegmentationMapper.resExcludeCIFsDetailListMap");
	return ((Integer) getSqlMap().queryForObject("custSegmentationMapper.returnExcludeCIFsDetailListCount",
		excludeCIFSC)).intValue();
    }

    public List returnExcludeCIFsDetailList(ExcludeCIFSC excludeCIFSC) throws DAOException
    {
	DAOHelper.fixGridMaps(excludeCIFSC, getSqlMap(), "custSegmentationMapper.resExcludeCIFsDetailListMap");
	if(excludeCIFSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("custSegmentationMapper.returnExcludeCIFsDetailList", excludeCIFSC);
	}
	else
	{
	    return getSqlMap().queryForList("custSegmentationMapper.returnExcludeCIFsDetailList", excludeCIFSC,
		    excludeCIFSC.getRecToskip(), excludeCIFSC.getNbRec());
	}
    }

    @Override
    public int checkDateUpdated(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("custSegmentationMapper.checkDateUpdated", custSegmentationSC);
    }

    @Override
    public void approveSegment(CustSegmentationCO custSegmentationCO) throws DAOException
    {
	getSqlMap().update("custSegmentationMapper.updateSegmentStatus", custSegmentationCO);

    }

    @Override
    public void rejectSegment(CustSegmentationCO custSegmentationCO) throws DAOException
    {
	getSqlMap().update("custSegmentationMapper.updateSegmentStatus", custSegmentationCO);
    }

    @Override
    public void updateAfterApproveSegment(CustSegmentationCO custSegmentationCO) throws DAOException
    {
	getSqlMap().update("custSegmentationMapper.updateSegmentStatus", custSegmentationCO);

    }

    @Override
    public int returnSegCriteriaDetailsCount(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("custSegmentationMapper.returnSegCriteriaDetailsCount",
		custSegmentationSC);
    }

    @Override
    public List returnListOfCustomerSegmentation(CustSegmentationSC criteria) throws DAOException
    {
	// TODO Auto-generated method stub
	return getSqlMap().queryForList("custSegmentationMapper.returnCustSegmentationDetailList", criteria);
    }

    @Override
    public void deleteCtsCifSegmentExclude(ExcludeCIFSC excludeCIFSC) throws DAOException
    {
	getSqlMap().delete("custSegmentationMapper.deleteCtsCifSegmentExclude", excludeCIFSC);

    }

    @Override
    public List<CustSegmentationParamCO> returnSegmentationParamList(CustSegmentationSC criteriaSC) throws DAOException
    {
	DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "custSegmentationMapper.segmentationParamResultMap");
	if(criteriaSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("custSegmentationMapper.returnSegmentationParamList", criteriaSC);
	}
	else
	{
	    return getSqlMap().queryForList("custSegmentationMapper.returnSegmentationParamList", criteriaSC,
		    criteriaSC.getRecToskip(), criteriaSC.getNbRec());

	}
    }

    public int returnSegmentationParamListCount(CustSegmentationSC criteriaSC) throws DAOException
    {
	DAOHelper.fixGridMaps(criteriaSC, getSqlMap(), "custSegmentationMapper.segmentationParamResultMap");
	int count = ((Integer) getSqlMap().queryForObject("custSegmentationMapper.returnSegmentationParamListCount",
		criteriaSC)).intValue();
	return count;
    }

    public int checkSegProcQueryParamExists(CustSegmentationSC criteriaSC) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("custSegmentationMapper.checkSegProcQueryParamExists", criteriaSC))
		.intValue();
    }

    public CustSegmentationParamCO returnArgumentDetailsResult(CustSegmentationSC criteriaSC) throws DAOException
    {
	return (CustSegmentationParamCO) getSqlMap()
		.queryForObject("custSegmentationMapper.returnArgumentDetailsResult", criteriaSC);
    }

    public void deleteSegmentationParam(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().delete("custSegmentationMapper.deleteSegmentationParam", custSegmentationSC);
    }

    @Override
    public Integer returnCustSegmentationProcessListCount(CustSegmentationSC criteria) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("custSegmentationMapper.returnCustSegmentationProcessListCount",
		criteria);
    }

    @Override
    public List returnCustSegmentationProcessList(CustSegmentationSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "custSegmentationMapper.resCustSegmentProcessMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("custSegmentationMapper.returnCustSegmentationProcessList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("custSegmentationMapper.returnCustSegmentationProcessList", criteria,
            criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    @Override
    public Integer getCifOfTrialSegmentationProcessListCount(CustSegmentationSC criteriaSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("custSegmentationMapper.getCifOfTrialSegmentationProcessListCount",
		criteriaSC);
    }

    @Override
    public List getCifOfTrialSegmentationProcessList(CustSegmentationSC criteriaSC) throws DAOException
    {
	// DAOHelper.fixGridMaps(criteriaSC, getSqlMap(),
	// "custSegmentationMapper.cifOfTrialSegmentationProcessMap");
	if(criteriaSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("custSegmentationMapper.getCifOfTrialSegmentationProcessList", criteriaSC);
	}
	else
	{
	    return getSqlMap().queryForList("custSegmentationMapper.getCifOfTrialSegmentationProcessList", criteriaSC,
		    criteriaSC.getRecToskip(), criteriaSC.getNbRec());
	}
    }

    public List<CustSegmentationParamCO> returnArgumentParamsDetails(CustSegmentationSC custSegmentationSC)
	    throws DAOException
    {
	return (List<CustSegmentationParamCO>) getSqlMap()
		.queryForList("custSegmentationMapper.returnArgumentParamsDetails", custSegmentationSC);
    }

    public List<String> returnOutArgs(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	return (List<String>) getSqlMap().queryForList("custSegmentationMapper.returnOutArgs", custSegmentationSC);
    }

    @Override
    public void approveCustSegProcess(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().update("custSegmentationMapper.updateCustSegProcessStatus", custSegmentationSC);
	// getSqlMap().update("custSegmentationMapper.updateCustSegCifExt",
	// custSegmentationSC);
    }

    @Override
    public void rejectCustSegProcess(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().delete("custSegmentationMapper.rejectCustSegProcess", custSegmentationSC);
    }

    public void insertSegProcessResult(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().insert("custSegmentationMapper.insertSegProcessResult", custSegmentationSC);
	// List<CTS_SEG_CIF_EXEC_RESULT_TEMPVO> t =
	// getSqlMap().queryForList("custSegmentationMapper.insertSegProcessResult",
	// custSegmentationSC);
	// t.size();
    }

    public void deleteFromCTS_SEG_CIF_EXEC_RESULT_TEMP(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	if(!(NumberUtil.isEmptyDecimal(custSegmentationSC.getFromBranch())
		|| NumberUtil.isEmptyDecimal(custSegmentationSC.getToBranch()))
		|| !(NumberUtil.isEmptyDecimal(custSegmentationSC.getFromCif())
			|| NumberUtil.isEmptyDecimal(custSegmentationSC.getToCif())))
	{
	    getSqlMap().delete("custSegmentationMapper.deleteFromCTS_SEG_CIF_EXEC_RESULT_TEMP", custSegmentationSC);
	}
    }

    public void deleteFromCTS_SEG_CIF_EXEC_RESULT(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	if(!(NumberUtil.isEmptyDecimal(custSegmentationSC.getFromBranch())
		|| NumberUtil.isEmptyDecimal(custSegmentationSC.getToBranch()))
		|| !(NumberUtil.isEmptyDecimal(custSegmentationSC.getFromCif())
			|| NumberUtil.isEmptyDecimal(custSegmentationSC.getToCif())))
	{
	    getSqlMap().delete("custSegmentationMapper.deleteFromCTS_SEG_CIF_EXEC_RESULT", custSegmentationSC);
	}
    }

    /**
     * @author raniaalbitar 718813 - Dynamic Customer Scoring on latest
     */

    public int returnSegmentationLookupCount(GridParamsSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "custSegmentationMapper.resSegmentationListMap");
	return ((Integer) getSqlMap().queryForObject("custSegmentationMapper.returnSegmentationListCount", criteria))
		.intValue();
    }

    public List returnSegmentationLookup(GridParamsSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "custSegmentationMapper.resSegmentationListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("custSegmentationMapper.returnSegmentationList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("custSegmentationMapper.returnSegmentationList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    public CustSegmentationSC returnMainSegmentCode(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	return (CustSegmentationSC) getSqlMap().queryForObject("custSegmentationMapper.returnMainSegmentCode",
		custSegmentationSC);
    }

    public List<CustSegmentationCO> returnCustSegmentationDetails(CustSegmentationSC custSegmentationSC)
	    throws DAOException
    {
	return getSqlMap().queryForList("custSegmentationMapper.returnCustSegmentationDetails", custSegmentationSC);
    }

    public void insertAmlCifScoreResult(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().insert("custSegmentationMapper.insertAmlCifScoreResult", custSegmentationSC);
    }

    public CustSegmentationSC returnSegmentGroupCode(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	return (CustSegmentationSC) getSqlMap().queryForObject("custSegmentationMapper.returnSegmentGroupCode",
		custSegmentationSC);
    }

    public int returnCifCountBySegment(CustSegmentationSC criteria) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("custSegmentationMapper.returnCifCountBySegment", criteria);
    }
    
    public void deleteSegmentationDetails(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().delete("custSegmentationMapper.deleteSegmentationDetails", custSegmentationSC);
    }
    
    public void deleteSegmentationParamForAllLines(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().delete("custSegmentationMapper.deleteSegmentationParamForAllLines", custSegmentationSC);
    }
    
    public void insertCifScoreResult(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().insert("custSegmentationMapper.insertCifScoreResult", custSegmentationSC);
    }
    
    public int returnMainScoreCount(CustSegmentationCO custSegmentationCO) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("custSegmentationMapper.returnMainScoreCount", custSegmentationCO);
    }
    
 // Added By Ali for TP#864398
    public int getSegmentCodeMax(CustSegmentationSC criteria) throws DAOException
    {
	Integer maxSubObject = (Integer)getSqlMap().queryForObject("custSegmentationMapper.getSegmentCodeMax", criteria);
	return maxSubObject.intValue();
    }
    
    // added by nour for tp 864398
	public int dependencyByReasonCode(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("custSegmentationMapper.dependencyByReasonCode",
		custSegmentationSC);
    }
	
	public int dependencyByReasonRef(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("custSegmentationMapper.dependencyByReasonRef",
		custSegmentationSC);
    }
    public String returnScoreRiskDescription(CustSegmentationSC custSegmentationSC) throws DAOException
    {
    	return (String) getSqlMap().queryForObject("custSegmentationMapper.returnScoreRiskDescription", custSegmentationSC);
    }


	public String returnReasonDesc(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	return (String) getSqlMap().queryForObject("custSegmentationMapper.returnReasonDesc", custSegmentationSC);
    }

	@Override
	public Integer getMaxLineNo(CustSegmentationSC custSegmentationSC) throws DAOException {
		return (Integer) getSqlMap().queryForObject("custSegmentationMapper.returnMaxLineNo", custSegmentationSC);
	}

	@Override
	public List<AML_PARAM_MAPPINGVO> loadMultiSelectListGrid(CustSegmentationSC custSegmentationSC)
			throws DAOException {
		DAOHelper.fixGridMaps(custSegmentationSC, getSqlMap(), "custSegmentationMapper.multiSelectResultMap");

		if (custSegmentationSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("custSegmentationMapper.loadMultiSelectListGrid", custSegmentationSC);
		}
		else
		{
			/* call the query */
			return getSqlMap().queryForList("custSegmentationMapper.loadMultiSelectListGrid", custSegmentationSC, custSegmentationSC.getRecToskip(), custSegmentationSC.getNbRec());

		}
	}

	@Override
	public void deleteOldListSelected(CustSegmentationCO custSegmentationCO) throws DAOException {
		sqlMap.delete("custSegmentationMapper.deleteOldListSelected", custSegmentationCO);
	}

	@Override
	public List<CustSegmentationParamCO> returnReplaceArgumentSelect(CustSegmentationSC custSegmentationSC)
			throws DAOException {
		DAOHelper.fixGridMaps(custSegmentationSC, getSqlMap(), "custSegmentationMapper.segmentationParamResultMap");

		if (custSegmentationSC.getIsSybase() == 1)
		{
			custSegmentationSC.setSortOrder("ORDER BY PARAM_ORDER");
		}

		return getSqlMap().queryForList("custSegmentationMapper.returnReplaceArgumentSelect", custSegmentationSC);
	}

	@Override
	public Integer getMaxGaArgId(CustSegmentationSC custSegmentationSC) throws DAOException {
		return (Integer) getSqlMap().queryForObject("custSegmentationMapper.returnMaxGaArgId", custSegmentationSC);
	}

	@Override
	public void deleteSegmentationSelectParam(CustSegmentationSC custSegmentationSC) throws DAOException {
		getSqlMap().delete("custSegmentationMapper.deleteSegmentationSelectParam", custSegmentationSC);
	}

	@Override
	// added by nour for bug #955568
	public Integer returnMainScore(CustSegmentationCO custSegmentationCO) throws DAOException
	{
		return (Integer) getSqlMap().queryForObject("custSegmentationMapper.returnMainScore", custSegmentationCO);

	}

	 @Override
	    public CTS_SEGMENTVO returnSegmentCodeForDependency(CustSegmentationSC custSegmentationSC) throws DAOException
	    {
		return (CTS_SEGMENTVO) getSqlMap().queryForObject("custSegmentationMapper.returnSegmentCodeForDependency",
			custSegmentationSC);
	    }

	    public int returnCifListForProcessCount(CustSegmentationSC criteria) throws DAOException
	    {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "custSegmentationMapper.resCifListForProcessMap");
		return ((Integer) getSqlMap().queryForObject("custSegmentationMapper.returnCifListForProcessCount",
			criteria)).intValue();
	    }

	    public List returnCifListForProcess(CustSegmentationSC criteria) throws DAOException
	    {
		return getSqlMap().queryForList("custSegmentationMapper.returnCifListForProcess", criteria);
	    }
	    
	    public ArrayList<CTSTELLERVO> returnUsrAccessBySegmentProcess(CustSegmentationSC criteria) throws DAOException
	    {
		return (ArrayList<CTSTELLERVO>) getSqlMap().queryForList("custSegmentationMapper.returnUsrAccessBySegmentProcess", criteria);
	    }
	    
	    public void updateSegmentHistory(CustSegmentationSC custSegmentationSC) throws DAOException
	    {
		getSqlMap().update("custSegmentationMapper.updateSegmentHistory", custSegmentationSC);
	    }

	    public void insertSegmentHistory(CustSegmentationSC custSegmentationSC) throws DAOException
	    {
		getSqlMap().insert("custSegmentationMapper.insertSegmentHistory", custSegmentationSC);
	    }

	    public CTS_SEGMENTVO checkAutoApprove(CustSegmentationSC custSegmentationSC) throws DAOException
	    {
		return (CTS_SEGMENTVO) getSqlMap().queryForObject("custSegmentationMapper.checkAutoApprove", custSegmentationSC);
	    }

	    @Override
	    public int checkHistoryRecordExists(CustSegmentationProcessCO listCO) throws DAOException
	    {
		return (Integer) getSqlMap().queryForObject("custSegmentationMapper.checkHistoryRecordExists", listCO);
	    }

	    @Override
	    public void fillRecommendedDateHistory(CustSegmentationProcessCO listCO) throws DAOException
	    {
		getSqlMap().insert("custSegmentationMapper.insertRecommendedDateHistory", listCO);
		
	    }
	    

	    @Override
	    public int returnUserAccessSegmentCount(CustSegmentationSC custSegmentationSC) throws DAOException
	    {
		return (Integer) getSqlMap().queryForObject("custSegmentationMapper.returnUserAccessSegmentCount", custSegmentationSC);
	    }
	    
}
