package com.path.vo.core.segmentation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.path.dbmaps.vo.CTS_SEGMENTVO;
import com.path.dbmaps.vo.CTS_SEGMENT_CIF_EXCLUDEVO;
import com.path.dbmaps.vo.CTS_SEGMENT_DETVOWithBLOBs;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * CustSegmentationCO.java used to
 */
public class CustSegmentationCO extends RetailBaseVO
{

	private CTS_SEGMENTVO ctsSegmentVO = new CTS_SEGMENTVO();
	private CTS_SEGMENT_DETVOWithBLOBs ctsSegmentDetVO = new CTS_SEGMENT_DETVOWithBLOBs();
	private CTS_SEGMENT_CIF_EXCLUDEVO ctsSegmentCifExcludeVO = new CTS_SEGMENT_CIF_EXCLUDEVO();
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private String criteriaDesc;
	private String statusdesc;
	private String segmentDesc;
	private String oldstatusdesc;
	private String displayExpression;
	private String excludeCifGridUpdates;
	private BigDecimal priorityLevel;
	
	// Rania - 718813 - Dynamic Customer Scoring on latest
	private String isSegmentationScore;
	private BigDecimal cifNo;
	private BigDecimal score;
	private String fromDepFunc;
	private String errorMessage;
	//

	// Rania - Customers Segmentation
	public String chargesWaiverGridUpdates;
	private AlertsParamCO alertsParamCO = new AlertsParamCO();
	private String groupDesc;
	//
	
	//Rania - ABSAI180073
	private String scoringCalcCriteria;
	private BigDecimal queryID;
	private String queryDesc;
	//
	
	public BigDecimal getPriorityLevel()
	{
		return priorityLevel;
	}

	public void setPriorityLevel(BigDecimal priorityLevel)
	{
		this.priorityLevel = priorityLevel;
	}

	private ArrayList<CustSegmentationCO> excludeCifListCOs;

	/* GRID UPDATE LIST INITIALIZATION */
	List<CustSegmentationCO> gridAllList = new ArrayList<CustSegmentationCO>(), gridUpdateList, gridAddList, gridDeleteList;

	private String queryParamGridStr;
	private String procParamGridStr;
	private String segmentationParamOpened;
	private List<CustSegmentationParamCO> queryParamCOList;
	private List<CustSegmentationParamCO> procParamCOList;
	private int paramIsOpen;

	private String companyName;
	private String companyArabName;
	private String baseCurrencyName;
	private BigDecimal exposCurCode;
	private String exposCurName;
	private String clientType;
	private BigDecimal fiscalYear;
	private int isRTLDir;
	private String branchName;
	
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>(); // added by nour for #864398
    private String progRef; // added by nour for 864398
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> requiredHm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>(); // added by nour for #864398
    private String reasonName;// added by nour for #864398
    private String  reasonNameRef;// added by nour for #864398
    public BigDecimal compCode;// added by nour for #864398
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> screenParam = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();// added by nour for #864398

    private BigDecimal queryParamId;//By Bilal For TP#750884
    private BigDecimal criteriaCode; //By Bilal For TP#750884
    private String entityTypeParam;
    private String divFormParam;
    private String isFromProcess; //By Bilal For TP#750884

	public BigDecimal getExposCurCode()
	{
		return exposCurCode;
	}

	public void setExposCurCode(BigDecimal exposCurCode)
	{
		this.exposCurCode = exposCurCode;
	}

	public String getExposCurName()
	{
		return exposCurName;
	}

	public void setExposCurName(String exposCurName)
	{
		this.exposCurName = exposCurName;
	}

	public String getClientType()
	{
		return clientType;
	}

	public void setClientType(String clientType)
	{
		this.clientType = clientType;
	}

	public BigDecimal getFiscalYear()
	{
		return fiscalYear;
	}

	public void setFiscalYear(BigDecimal fiscalYear)
	{
		this.fiscalYear = fiscalYear;
	}

	public int getIsRTLDir()
	{
		return isRTLDir;
	}

	public void setIsRTLDir(int isRTLDir)
	{
		this.isRTLDir = isRTLDir;
	}

	public String getBranchName()
	{
		return branchName;
	}

	public void setBranchName(String branchName)
	{
		this.branchName = branchName;
	}

	public String getBaseCurrencyName()
	{
		return baseCurrencyName;
	}

	public void setBaseCurrencyName(String baseCurrencyName)
	{
		this.baseCurrencyName = baseCurrencyName;
	}

	public String getCompanyArabName()
	{
		return companyArabName;
	}

	public void setCompanyArabName(String companyArabName)
	{
		this.companyArabName = companyArabName;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public List<CustSegmentationCO> getGridAllList()
	{
		return gridAllList;
	}

	public void setGridAllList(List<CustSegmentationCO> gridAllList)
	{
		this.gridAllList = gridAllList;
	}

	public List<CustSegmentationCO> getGridUpdateList()
	{
		return gridUpdateList;
	}

	public void setGridUpdateList(List<CustSegmentationCO> gridUpdateList)
	{
		this.gridUpdateList = gridUpdateList;
	}

	public List<CustSegmentationCO> getGridAddList()
	{
		return gridAddList;
	}

	public void setGridAddList(List<CustSegmentationCO> gridAddList)
	{
		this.gridAddList = gridAddList;
	}

	public List<CustSegmentationCO> getGridDeleteList()
	{
		return gridDeleteList;
	}

	public void setGridDeleteList(List<CustSegmentationCO> gridDeleteList)
	{
		this.gridDeleteList = gridDeleteList;
	}

	public CTS_SEGMENTVO getCtsSegmentVO()
	{
		return ctsSegmentVO;
	}

	public void setCtsSegmentVO(CTS_SEGMENTVO ctsSegmentVO)
	{
		this.ctsSegmentVO = ctsSegmentVO;
	}

	public CTS_SEGMENT_DETVOWithBLOBs getCtsSegmentDetVO()
	{
		return ctsSegmentDetVO;
	}

	public void setCtsSegmentDetVO(CTS_SEGMENT_DETVOWithBLOBs ctsSegmentDetVO)
	{
		this.ctsSegmentDetVO = ctsSegmentDetVO;
	}

	public String getStatusdesc()
	{
		return statusdesc;
	}

	public void setStatusdesc(String statusdesc)
	{
		this.statusdesc = statusdesc;
	}

	public String getCriteriaDesc()
	{
		return criteriaDesc;
	}

	public void setCriteriaDesc(String criteriaDesc)
	{
		this.criteriaDesc = criteriaDesc;
	}

	public CTS_SEGMENT_CIF_EXCLUDEVO getCtsSegmentCifExcludeVO()
	{
		return ctsSegmentCifExcludeVO;
	}

	public void setCtsSegmentCifExcludeVO(CTS_SEGMENT_CIF_EXCLUDEVO ctsSegmentCifExcludeVO)
	{
		this.ctsSegmentCifExcludeVO = ctsSegmentCifExcludeVO;
	}

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
	{
		return buisnessElement;
	}

	public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
	{
		this.buisnessElement = buisnessElement;
	}

	public String getOldstatusdesc()
	{
		return oldstatusdesc;
	}

	public void setOldstatusdesc(String oldstatusdesc)
	{
		this.oldstatusdesc = oldstatusdesc;
	}

	public String getDisplayExpression()
	{
		return displayExpression;
	}

	public void setDisplayExpression(String displayExpression)
	{
		this.displayExpression = displayExpression;
	}

	public String getExcludeCifGridUpdates()
	{
		return excludeCifGridUpdates;
	}

	public void setExcludeCifGridUpdates(String excludeCifGridUpdates)
	{
		this.excludeCifGridUpdates = excludeCifGridUpdates;
	}

	public ArrayList<CustSegmentationCO> getExcludeCifListCOs()
	{
		return excludeCifListCOs;
	}

	public void setExcludeCifListCOs(ArrayList<CustSegmentationCO> excludeCifListCOs)
	{
		this.excludeCifListCOs = excludeCifListCOs;
	}

	public String getSegmentDesc()
	{
		return segmentDesc;
	}

	public void setSegmentDesc(String segmentDesc)
	{
		this.segmentDesc = segmentDesc;
	}

	public String getQueryParamGridStr()
	{
		return queryParamGridStr;
	}

	public void setQueryParamGridStr(String queryParamGridStr)
	{
		this.queryParamGridStr = queryParamGridStr;
	}

	public String getProcParamGridStr()
	{
		return procParamGridStr;
	}

	public void setProcParamGridStr(String procParamGridStr)
	{
		this.procParamGridStr = procParamGridStr;
	}

	public List<CustSegmentationParamCO> getQueryParamCOList()
	{
		return queryParamCOList;
	}

	public void setQueryParamCOList(List<CustSegmentationParamCO> queryParamCOList)
	{
		this.queryParamCOList = queryParamCOList;
	}

	public List<CustSegmentationParamCO> getProcParamCOList()
	{
		return procParamCOList;
	}

	public void setProcParamCOList(List<CustSegmentationParamCO> procParamCOList)
	{
		this.procParamCOList = procParamCOList;
	}

	public String getSegmentationParamOpened()
	{
		return segmentationParamOpened;
	}

	public void setSegmentationParamOpened(String segmentationParamOpened)
	{
		this.segmentationParamOpened = segmentationParamOpened;
	}

	public int getParamIsOpen()
	{
		return paramIsOpen;
	}

	public void setParamIsOpen(int paramIsOpen)
	{
		this.paramIsOpen = paramIsOpen;
	}

	public String getIsSegmentationScore()
	{
		return isSegmentationScore;
	}

	public void setIsSegmentationScore(String isSegmentationScore)
	{
		this.isSegmentationScore = isSegmentationScore;
	}

	public BigDecimal getCifNo()
	{
		return cifNo;
	}

	public void setCifNo(BigDecimal cifNo)
	{
		this.cifNo = cifNo;
	}

	public BigDecimal getScore()
	{
		return score;
	}

	public void setScore(BigDecimal score)
	{
		this.score = score;
	}

	public String getFromDepFunc()
	{
		return fromDepFunc;
	}

	public void setFromDepFunc(String fromDepFunc)
	{
		this.fromDepFunc = fromDepFunc;
	}

	public String getChargesWaiverGridUpdates()
	{
		return chargesWaiverGridUpdates;
	}

	public void setChargesWaiverGridUpdates(String chargesWaiverGridUpdates)
	{
		this.chargesWaiverGridUpdates = chargesWaiverGridUpdates;
	}

	public AlertsParamCO getAlertsParamCO()
	{
		return alertsParamCO;
	}

	public void setAlertsParamCO(AlertsParamCO alertsParamCO)
	{
		this.alertsParamCO = alertsParamCO;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}

	public String getGroupDesc()
	{
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc)
	{
		this.groupDesc = groupDesc;
	}

	public String getScoringCalcCriteria()
	{
	    return scoringCalcCriteria;
	}

	public void setScoringCalcCriteria(String scoringCalcCriteria)
	{
	    this.scoringCalcCriteria = scoringCalcCriteria;
	}

	public BigDecimal getQueryID()
	{
	    return queryID;
	}

	public void setQueryID(BigDecimal queryID)
	{
	    this.queryID = queryID;
	}

	public String getQueryDesc()
	{
	    return queryDesc;
	}

	public void setQueryDesc(String queryDesc)
	{
	    this.queryDesc = queryDesc;
	}
	
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
	{
		return hm;
	}

	
	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
	{
		this.hm = hm;
	}

	
	public String getProgRef()
	{
		return progRef;
	}

	
	public void setProgRef(String progRef)
	{
		this.progRef = progRef;
	}

	
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getRequiredHm()
	{
		return requiredHm;
	}

	
	public void setRequiredHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> requiredHm)
	{
		this.requiredHm = requiredHm;
	}

	
	public String getReasonName()
	{
		return reasonName;
	}

	
	public void setReasonName(String reasonName)
	{
		this.reasonName = reasonName;
	}

	
	public BigDecimal getCompCode()
	{
		return compCode;
	}

	
	public void setCompCode(BigDecimal compCode)
	{
		this.compCode = compCode;
	}

	
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getScreenParam()
	{
		return screenParam;
	}

	
	public void setScreenParam(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> screenParam)
	{
		this.screenParam = screenParam;
	}

	
	public String getReasonNameRef()
	{
		return reasonNameRef;
	}

	
	public void setReasonNameRef(String reasonNameRef)
	{
		this.reasonNameRef = reasonNameRef;
	}

	public BigDecimal getQueryParamId() {
		return queryParamId;
	}

	public void setQueryParamId(BigDecimal queryParamId) {
		this.queryParamId = queryParamId;
	}

	public BigDecimal getCriteriaCode() {
		return criteriaCode;
	}

	public void setCriteriaCode(BigDecimal criteriaCode) {
		this.criteriaCode = criteriaCode;
	}

	public String getEntityTypeParam() {
		return entityTypeParam;
	}

	public void setEntityTypeParam(String entityTypeParam) {
		this.entityTypeParam = entityTypeParam;
	}

	public String getDivFormParam() {
		return divFormParam;
	}

	public void setDivFormParam(String divFormParam) {
		this.divFormParam = divFormParam;
	}

	public String getIsFromProcess() {
		return isFromProcess;
	}

	public void setIsFromProcess(String isFromProcess) {
		this.isFromProcess = isFromProcess;
	}
	
}

