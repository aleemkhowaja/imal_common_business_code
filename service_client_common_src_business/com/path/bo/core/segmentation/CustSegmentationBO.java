package com.path.bo.core.segmentation;

import java.math.BigDecimal;
import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.core.segmentation.CustSegmentationCO;
import com.path.vo.core.segmentation.CustSegmentationParamCO;
import com.path.vo.core.segmentation.CustSegmentationSC;
import com.path.vo.core.segmentation.ExcludeCIFSC;
import java.util.HashMap;
import com.path.dbmaps.vo.AML_PARAM_MAPPINGVO;
import com.path.dbmaps.vo.CTS_SEGMENTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * CustSegmentationBO.java used to
 */
public interface CustSegmentationBO
{
    public int returnCustSegmentationListCount(CustSegmentationSC criteria) throws BaseException;

    public List returnCustSegmentationList(CustSegmentationSC criteria) throws BaseException;

    public CustSegmentationCO returnCustSegmentationForm(CustSegmentationSC custSegmentationSC) throws BaseException;

    public CustSegmentationCO saveNewSegment(CustSegmentationCO custSegmentationCO) throws BaseException;

    public CustSegmentationCO updateSegment(CustSegmentationCO custSegmentationCO) throws BaseException;

    public CustSegmentationCO updateSegmentHeader(CustSegmentationCO custSegmentationCO) throws BaseException;

    public int returnCustSegmentationDetailListCount(CustSegmentationSC criteria) throws BaseException;

    public List returnCustSegmentationDetailList(CustSegmentationSC criteria) throws BaseException;

    public CustSegmentationCO dependencyBySegmentCode(CustSegmentationCO custSegmentationCO) throws BaseException;

    // dependency on LookUps
    public CustSegmentationCO dependencyByCriteriaCode(CustSegmentationCO custSegmentationCO) throws BaseException;

    // Exclude CIF grid
    public int returnExcludeCIFsDetailListCount(ExcludeCIFSC excludeCIFSC) throws BaseException;

    public List returnExcludeCIFsDetailList(ExcludeCIFSC excludeCIFSC) throws BaseException;

    public CustSegmentationCO checkDateUpdated(CustSegmentationCO custSegmentationCO) throws BaseException;

    CustSegmentationCO approveSegment(CustSegmentationCO custSegmentationCO) throws BaseException;

    CustSegmentationCO rejectSegment(CustSegmentationCO custSegmentationCO) throws BaseException;
    // CustSegmentationCO updateAfterApproveSegment(CustSegmentationCO
    // custSegmentationCO) throws BaseException;

    public CustSegmentationCO initialiseData(CustSegmentationCO custSegmentationCO, Boolean newRecord) throws BaseException;

    public List returnListOfCustomerSegmentation(CustSegmentationSC criteria) throws BaseException;

    public void saveExcludeCifGrid(CustSegmentationCO custSegCO, Boolean newRecord) throws BaseException;

    public int returnSegmentationParamListCount(CustSegmentationSC criteriaSC) throws BaseException;

    public List<CustSegmentationParamCO> returnSegmentationParamList(CustSegmentationSC criteriaSC) throws BaseException;

    public CustSegmentationSC runTrialSegmentationProcess(CustSegmentationSC custSegmentationSC) throws BaseException;

    public CustSegmentationCO trialProcess(CustSegmentationCO custSegmentationCO) throws BaseException;

    public CustSegmentationCO updateDefPriorties(CustSegmentationCO custSegmentationCO) throws BaseException;

    public CustSegmentationSC validateBranchCode(CustSegmentationSC custSegmentationSC) throws BaseException;

    public void loadCustSegmentationProcessGrid(CustSegmentationSC criteria) throws BaseException;

    public Integer returnCustSegmentationProcessListCount(CustSegmentationSC criteria) throws BaseException;

    public List returnCustSegmentationProcessList(CustSegmentationSC criteria) throws BaseException;

    public CustSegmentationSC dependencyByCif(CustSegmentationSC custSegmentationSC) throws BaseException;

    public void approveCustSegProcess(CustSegmentationSC custSegmentationSC) throws BaseException;

    public void rejectCustSegProcess(CustSegmentationSC custSegmentationSC) throws BaseException;

    public void permanentRejectCustSegProcess(CustSegmentationSC custSegmentationSC) throws BaseException;

    public Integer getCifOfTrialSegmentationProcessListCount(CustSegmentationSC criteriaSC) throws BaseException;

    public List getCifOfTrialSegmentationProcessList(CustSegmentationSC criteriaSC) throws BaseException;

    public int returnSegmentationLookupCount(GridParamsSC criteria) throws BaseException;

    public List returnSegmentationLookup(GridParamsSC criteria) throws BaseException;

    public CustSegmentationSC dependencyByMainCif(CustSegmentationSC custSegmentationSC) throws BaseException;

    public CustSegmentationSC dependencyByMainSegmentCode(CustSegmentationSC custSegmentationSC) throws BaseException;

    public List<CustSegmentationCO> returnCustSegmentationDetails(CustSegmentationSC custSegmentationSC) throws BaseException;

    public void deleteFromCTS_SEG_CIF_EXEC_RESULT_TEMP(CustSegmentationSC criteria) throws BaseException;

    public void deleteFromCTS_SEG_CIF_EXEC_RESULT(CustSegmentationSC criteria) throws BaseException;

    public void insertSegProcessResult(CustSegmentationSC custSegmentationSC) throws BaseException;

    public void totalPercentageValidation(CustSegmentationCO custSegmentationCO) throws BaseException;

    public void insertAmlCifScoreResult(CustSegmentationSC custSegmentationSC) throws BaseException;

    public CustSegmentationSC dependencyByGroupCode(CustSegmentationSC custSegmentationSC) throws BaseException;
    
    public void deleteSegment(CustSegmentationCO custSegmentationCO) throws BaseException;
    
    public void insertCifScoreResult(CustSegmentationSC custSegmentationSC) throws BaseException;
    public int dependencyByMainScore(CustSegmentationCO custSegmentationCO) throws BaseException;
    
 // Added By Ali for TP#864398
    CustSegmentationCO validateStartEndDates(CustSegmentationCO tempCO) throws BaseException;
    
    public CustSegmentationCO hideShowSuspensionReason(CustSegmentationCO custSegmentationCO) throws BaseException;
    /***
     *added by nour for #864398
     */
    
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> updateAfterAppVis(CustSegmentationCO custSegmentationCO) throws BaseException;
    public CustSegmentationCO dependencyByReasonCode(CustSegmentationCO custSegmentationCO) throws BaseException;
    public CustSegmentationCO dependencyByReasonRef(CustSegmentationCO custSegmentationCO) throws BaseException;

    CustSegmentationCO dependencyByPeriodicity(CustSegmentationCO custSegmentationCO) throws BaseException;

    
    //By Bilal For TP#750884
    public List<AML_PARAM_MAPPINGVO> loadMultiSelectListGrid(CustSegmentationSC custSegmentationSC) throws BaseException;
    
    public List<CustSegmentationParamCO> returnReplaceArgumentSelect(CustSegmentationSC custSegmentationSC) throws BaseException;
    
    public CTS_SEGMENTVO returnSegmentCodeForDependency(CustSegmentationSC custSegmentationSC) throws BaseException;
    
    public CustSegmentationCO returnQueryID(CustSegmentationCO custSegmentationCO) throws BaseException;
}