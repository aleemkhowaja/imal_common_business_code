package com.path.dao.core.segmentation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.core.segmentation.CustSegmentationCO;
import com.path.vo.core.segmentation.CustSegmentationParamCO;
import com.path.vo.core.segmentation.CustSegmentationProcessCO;
import com.path.vo.core.segmentation.CustSegmentationSC;
import com.path.vo.core.segmentation.ExcludeCIFSC;
import com.path.dbmaps.vo.AML_PARAM_MAPPINGVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_SEGMENTVO;
import com.path.vo.core.criteria.CriteriaCO;
import com.path.vo.core.criteria.CriteriaParamCO;
import com.path.vo.core.criteria.CriteriaSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * CustSegmentationDAO.java used to
 */
public interface CustSegmentationDAO
{
    public int returnCustSegmentationListCount(CustSegmentationSC criteria) throws DAOException;

    public List returnCustSegmentationList(CustSegmentationSC criteria) throws DAOException;

    public CustSegmentationCO returnCustSegmentationForm(CustSegmentationSC custSegmentationSC) throws DAOException;

    public int dependencyBySegmentCode(CustSegmentationSC custSegmentationSC) throws DAOException;

    public int returnCustSegmentationDetailListCount(CustSegmentationSC custSegmentationSC) throws DAOException;

    public List returnCustSegmentationDetailList(CustSegmentationSC custSegmentationSC) throws DAOException;

    public int dependencyByCriteriaCode(CustSegmentationSC custSegmentationSC) throws DAOException;

    public String returnCriteriaDesc(CustSegmentationSC custSegmentationSC) throws DAOException;

    public int returnExcludeCIFsDetailListCount(ExcludeCIFSC excludeCIFSC) throws DAOException;

    public List returnExcludeCIFsDetailList(ExcludeCIFSC excludeCIFSC) throws DAOException;

    public int checkDateUpdated(CustSegmentationSC custSegmentationSC) throws DAOException;

    void approveSegment(CustSegmentationCO custSegmentationCO) throws DAOException;

    void rejectSegment(CustSegmentationCO custSegmentationCO) throws DAOException;

    void updateAfterApproveSegment(CustSegmentationCO custSegmentationCO) throws DAOException;

    public int returnSegCriteriaDetailsCount(CustSegmentationSC custSegmentationSC) throws DAOException;

    public List returnListOfCustomerSegmentation(CustSegmentationSC criteria) throws DAOException;

    public void deleteCtsCifSegmentExclude(ExcludeCIFSC excludeCIFSC) throws DAOException;

    public List<CustSegmentationParamCO> returnSegmentationParamList(CustSegmentationSC criteriaSC) throws DAOException;

    public int returnSegmentationParamListCount(CustSegmentationSC criteriaSC) throws DAOException;

    public int checkSegProcQueryParamExists(CustSegmentationSC criteriaSC) throws DAOException;

    public CustSegmentationParamCO returnArgumentDetailsResult(CustSegmentationSC criteriaSC) throws DAOException;

    public void deleteSegmentationParam(CustSegmentationSC criteriaSC) throws DAOException;

    public List<CustSegmentationParamCO> returnArgumentParamsDetails(CustSegmentationSC custSegmentationSC) throws DAOException;

    public List<String> returnOutArgs(CustSegmentationSC custSegmentationSC) throws DAOException;

    public Integer returnCustSegmentationProcessListCount(CustSegmentationSC criteria) throws DAOException;

    public List returnCustSegmentationProcessList(CustSegmentationSC criteria) throws DAOException;

    public void insertSegProcessResult(CustSegmentationSC custSegmentationSC) throws DAOException;

    public void deleteFromCTS_SEG_CIF_EXEC_RESULT_TEMP(CustSegmentationSC custSegmentationSC) throws DAOException;

    public void deleteFromCTS_SEG_CIF_EXEC_RESULT(CustSegmentationSC custSegmentationSC) throws DAOException;

    public void approveCustSegProcess(CustSegmentationSC custSegmentationSC) throws DAOException;

    public void rejectCustSegProcess(CustSegmentationSC custSegmentationSC) throws DAOException;

    public Integer getCifOfTrialSegmentationProcessListCount(CustSegmentationSC criteriaSC) throws DAOException;

    public List getCifOfTrialSegmentationProcessList(CustSegmentationSC criteriaSC) throws DAOException;

    public int returnSegmentationLookupCount(GridParamsSC criteria) throws DAOException;

    public List returnSegmentationLookup(GridParamsSC criteria) throws DAOException;

    public CustSegmentationSC returnMainSegmentCode(CustSegmentationSC custSegmentationSC) throws DAOException;

    public List<CustSegmentationCO> returnCustSegmentationDetails(CustSegmentationSC custSegmentationSC) throws DAOException;

    public void insertAmlCifScoreResult(CustSegmentationSC custSegmentationSC) throws DAOException;

    public CustSegmentationSC returnSegmentGroupCode(CustSegmentationSC custSegmentationSC) throws DAOException;
    
    public int returnCifCountBySegment(CustSegmentationSC criteria) throws DAOException;
    
    public void deleteSegmentationDetails(CustSegmentationSC custSegmentationSC) throws DAOException;
    
    public void deleteSegmentationParamForAllLines(CustSegmentationSC custSegmentationSC) throws DAOException;
    
    public void insertCifScoreResult(CustSegmentationSC custSegmentationSC) throws DAOException;
    public int returnMainScoreCount(CustSegmentationCO custSegmentationCO) throws DAOException;
    
///////added by ali
  public int getSegmentCodeMax(CustSegmentationSC criteria) throws DAOException;
  ////////ended ali
  
  // added by nour
  public int dependencyByReasonCode(CustSegmentationSC custSegmentationSC) throws DAOException;
  public int dependencyByReasonRef(CustSegmentationSC custSegmentationSC) throws DAOException;


  public String returnReasonDesc(CustSegmentationSC custSegmentationSC) throws DAOException;
  //end
  
  //By Bilal For TP#750884
  public Integer getMaxLineNo(CustSegmentationSC custSegmentationSC) throws DAOException;
  
  public Integer getMaxGaArgId(CustSegmentationSC custSegmentationSC) throws DAOException;
  
  public List<AML_PARAM_MAPPINGVO> loadMultiSelectListGrid(CustSegmentationSC custSegmentationSC) throws DAOException;
  
  public void deleteOldListSelected(CustSegmentationCO custSegmentationCO) throws DAOException;
  
  public List<CustSegmentationParamCO> returnReplaceArgumentSelect(CustSegmentationSC custSegmentationSC) throws DAOException;
  
  public void deleteSegmentationSelectParam(CustSegmentationSC custSegmentationSC) throws DAOException;
  // added by nour for bug 955568
  public Integer returnMainScore (CustSegmentationCO custSegmentationCO) throws DAOException;
  
  public CTS_SEGMENTVO returnSegmentCodeForDependency(CustSegmentationSC custSegmentationSC) throws DAOException;;

  public int returnCifListForProcessCount(CustSegmentationSC criteria) throws DAOException;
  public List returnCifListForProcess(CustSegmentationSC criteria) throws DAOException;
  public ArrayList<CTSTELLERVO> returnUsrAccessBySegmentProcess(CustSegmentationSC criteria) throws DAOException;
  public void updateSegmentHistory(CustSegmentationSC custSegmentationSC) throws DAOException;
  public void insertSegmentHistory(CustSegmentationSC custSegmentationSC) throws DAOException;

  public String returnScoreRiskDescription(CustSegmentationSC custSegmentationSC) throws DAOException;
    
  public CTS_SEGMENTVO checkAutoApprove(CustSegmentationSC custSegmentationSC) throws DAOException;

  public int checkHistoryRecordExists(CustSegmentationProcessCO listCO)throws DAOException;

  public void fillRecommendedDateHistory(CustSegmentationProcessCO listCO)throws DAOException;
   
  public int returnUserAccessSegmentCount(CustSegmentationSC custSegmentationSC)throws DAOException; 
  
}
