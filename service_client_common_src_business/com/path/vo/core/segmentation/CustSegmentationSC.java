package com.path.vo.core.segmentation;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * CustSegmentationSC.java used to
 */
public class CustSegmentationSC extends GridParamsSC
{
    private BigDecimal segment_code;
    private BigDecimal criteria_code;
    private BigDecimal BRANCH_CODE;
    private BigDecimal lineNo;
    private String language;
    private Date dateUpdated;
    private String progRef;
    private String appName;
    private String lang;
    private String ivCrud;
    private String ENTITY_TYPE;
    private BigDecimal ENTITY_ID;
    private String entityName;
    private BigDecimal PARAM_ORDER;
    private String paramName;
    private String paramFromSegment;
    private BigDecimal errorCode;
    private String errorMessage;
    private Date processDate;
    private BigDecimal fromBranch;
    private BigDecimal toBranch;
    private BigDecimal fromCif;
    private BigDecimal toCif;
    private String processType; // It holds the following value: 'ST' (Segmentaion Trial), 'FP' (Final Process), 'TP' (Trial Process)
    private BigDecimal cifNo;
    private String allowCifCreationMaskYN;
    private String status;
    
    private String queryParamGridPK;
    private String procParamGridPK;
    
    private BigDecimal isRejected;

    //Rania - Customers Segmentation
    private BigDecimal groupCode; 
    private BigDecimal segmentCode;
    private String groupDesc;
    //
    
    //Rania - 718813 - Dynamic Customer Scoring on latest
    private String isSegmentationScore;
    private BigDecimal score;
    private String cifDesc;
    private String segmentDesc;
    //
    
    //Rania - ABSAI180073
    private String  scoreRiskDescription;
    //
    
    private BigDecimal reasonCode; //added by nour tp 864398 
    private String reasonRef;//added by nour tp 864398 
    
    private String runType;
    private BigDecimal isClassified;
    
    //By Bilal For TP#750884 
    private BigDecimal queryId; 
	private BigDecimal businessRuleCode; 
	private String action; 
	private String segDetailRowId;
	private String querySelectParamGridStr;
	private BigDecimal criteriaEntityId; 
	private BigDecimal criteriaCode;
	private String PARAM_CLASS;
	private String SEGMENT_TYPE;
	private BigDecimal SEG_LINE_NO;
	private BigDecimal rowId;
	private String multiSelectlkp;
	//
	
	 private BigDecimal tellerCode;
	 
    
    public BigDecimal getSegment_code()
    {
	return segment_code;
    }

    public void setSegment_code(BigDecimal segmentCode)
    {
	segment_code = segmentCode;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getCriteria_code()
    {
	return criteria_code;
    }

    public void setCriteria_code(BigDecimal criteriaCode)
    {
	criteria_code = criteriaCode;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public Date getDateUpdated()
    {
	return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated)
    {
	this.dateUpdated = dateUpdated;
    }

    public String getProgRef()
    {
        return progRef;
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public String getLang()
    {
        return lang;
    }

    public void setLang(String lang)
    {
        this.lang = lang;
    }

    public String getIvCrud()
    {
        return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
        this.ivCrud = ivCrud;
    }

    public String getENTITY_TYPE()
    {
        return ENTITY_TYPE;
    }

    public void setENTITY_TYPE(String eNTITY_TYPE)
    {
        ENTITY_TYPE = eNTITY_TYPE;
    }

    public BigDecimal getENTITY_ID()
    {
        return ENTITY_ID;
    }

    public void setENTITY_ID(BigDecimal eNTITY_ID)
    {
        ENTITY_ID = eNTITY_ID;
    }

    public String getEntityName()
    {
        return entityName;
    }

    public void setEntityName(String entityName)
    {
        this.entityName = entityName;
    }

    public BigDecimal getPARAM_ORDER()
    {
        return PARAM_ORDER;
    }

    public void setPARAM_ORDER(BigDecimal pARAM_ORDER)
    {
        PARAM_ORDER = pARAM_ORDER;
    }

    public String getParamName()
    {
        return paramName;
    }

    public void setParamName(String paramName)
    {
        this.paramName = paramName;
    }

    public String getParamFromSegment()
    {
        return paramFromSegment;
    }

    public void setParamFromSegment(String paramFromSegment)
    {
        this.paramFromSegment = paramFromSegment;
    }

    public BigDecimal getBRANCH_CODE()
    {
        return BRANCH_CODE;
    }

    public void setBRANCH_CODE(BigDecimal bRANCH_CODE)
    {
        BRANCH_CODE = bRANCH_CODE;
    }
    
    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public Date getProcessDate()
    {
	return processDate;
    }

    public void setProcessDate(Date processDate)
    {
	this.processDate = processDate;
    }

    public BigDecimal getFromBranch()
    {
	return fromBranch;
    }

    public void setFromBranch(BigDecimal fromBranch)
    {
	this.fromBranch = fromBranch;
    }

    public BigDecimal getToBranch()
    {
	return toBranch;
    }

    public void setToBranch(BigDecimal toBranch)
    {
	this.toBranch = toBranch;
    }

    public BigDecimal getFromCif()
    {
	return fromCif;
    }

    public void setFromCif(BigDecimal fromCif)
    {
	this.fromCif = fromCif;
    }

    public BigDecimal getToCif()
    {
	return toCif;
    }

    public void setToCif(BigDecimal toCif)
    {
	this.toCif = toCif;
    }

    public String getProcessType()
    {
	return processType;
    }

    public void setProcessType(String processType)
    {
	this.processType = processType;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public String getAllowCifCreationMaskYN()
    {
	return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
	this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getQueryParamGridPK()
    {
        return queryParamGridPK;
    }

    public void setQueryParamGridPK(String queryParamGridPK)
    {
        this.queryParamGridPK = queryParamGridPK;
    }

    public String getProcParamGridPK()
    {
        return procParamGridPK;
    }

    public void setProcParamGridPK(String procParamGridPK)
    {
        this.procParamGridPK = procParamGridPK;
    }

    public BigDecimal getIsRejected()
    {
        return isRejected;
    }

    public void setIsRejected(BigDecimal isRejected)
    {
        this.isRejected = isRejected;
    }

	
	public BigDecimal getGroupCode()
	{
		return groupCode;
	}

	
	public void setGroupCode(BigDecimal groupCode)
	{
		this.groupCode = groupCode;
	}

	
	public String getIsSegmentationScore()
	{
		return isSegmentationScore;
	}

	
	public void setIsSegmentationScore(String isSegmentationScore)
	{
		this.isSegmentationScore = isSegmentationScore;
	}

	
	public BigDecimal getScore()
	{
		return score;
	}

	
	public void setScore(BigDecimal score)
	{
		this.score = score;
	}

	
	public BigDecimal getSegmentCode()
	{
		return segmentCode;
	}

	
	public void setSegmentCode(BigDecimal segmentCode)
	{
		this.segmentCode = segmentCode;
	}

	
	public String getCifDesc()
	{
		return cifDesc;
	}

	
	public void setCifDesc(String cifDesc)
	{
		this.cifDesc = cifDesc;
	}

	
	public String getSegmentDesc()
	{
		return segmentDesc;
	}

	
	public void setSegmentDesc(String segmentDesc)
	{
		this.segmentDesc = segmentDesc;
	}

	
	public String getGroupDesc()
	{
		return groupDesc;
	}

	
	public void setGroupDesc(String groupDesc)
	{
		this.groupDesc = groupDesc;
	}

	public String getScoreRiskDescription()
	{
	    return scoreRiskDescription;
	}

	public void setScoreRiskDescription(String scoreRiskDescription)
	{
	    this.scoreRiskDescription = scoreRiskDescription;
	}
	
	public BigDecimal getReasonCode()
	{
		return reasonCode;
	}

	
	public void setReasonCode(BigDecimal reasonCode)
	{
		this.reasonCode = reasonCode;
	}

	
	public String getReasonRef()
	{
		return reasonRef;
	}

	
	public void setReasonRef(String reasonRef)
	{
		this.reasonRef = reasonRef;
	}

	public BigDecimal getQueryId() {
		return queryId;
	}

	public void setQueryId(BigDecimal queryId) {
		this.queryId = queryId;
	}

	public BigDecimal getBusinessRuleCode() {
		return businessRuleCode;
	}

	public void setBusinessRuleCode(BigDecimal businessRuleCode) {
		this.businessRuleCode = businessRuleCode;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public String getSegDetailRowId() {
		return segDetailRowId;
	}

	public void setSegDetailRowId(String segDetailRowId) {
		this.segDetailRowId = segDetailRowId;
	}

	public String getQuerySelectParamGridStr() {
		return querySelectParamGridStr;
	}

	public void setQuerySelectParamGridStr(String querySelectParamGridStr) {
		this.querySelectParamGridStr = querySelectParamGridStr;
	}

	public BigDecimal getCriteriaEntityId() {
		return criteriaEntityId;
	}

	public void setCriteriaEntityId(BigDecimal criteriaEntityId) {
		this.criteriaEntityId = criteriaEntityId;
	}

	public BigDecimal getCriteriaCode() {
		return criteriaCode;
	}

	public void setCriteriaCode(BigDecimal criteriaCode) {
		this.criteriaCode = criteriaCode;
	}

	public String getPARAM_CLASS() {
		return PARAM_CLASS;
	}

	public void setPARAM_CLASS(String pARAM_CLASS) {
		PARAM_CLASS = pARAM_CLASS;
	}

	public String getSEGMENT_TYPE() {
		return SEGMENT_TYPE;
	}

	public void setSEGMENT_TYPE(String sEGMENT_TYPE) {
		SEGMENT_TYPE = sEGMENT_TYPE;
	}

	public BigDecimal getSEG_LINE_NO() {
		return SEG_LINE_NO;
	}

	public void setSEG_LINE_NO(BigDecimal sEG_LINE_NO) {
		SEG_LINE_NO = sEG_LINE_NO;
	}

	public BigDecimal getRowId() {
		return rowId;
	}

	public void setRowId(BigDecimal rowId) {
		this.rowId = rowId;
	}

	public String getMultiSelectlkp() {
		return multiSelectlkp;
	}

	public void setMultiSelectlkp(String multiSelectlkp) {
		this.multiSelectlkp = multiSelectlkp;
	}

	public String getRunType()
	{
	    return runType;
	}

	public void setRunType(String runType)
	{
	    this.runType = runType;
	}

	public BigDecimal getIsClassified()
	{
	    return isClassified;
	}

	public void setIsClassified(BigDecimal isClassified)
	{
	    this.isClassified = isClassified;
	}
	
	public BigDecimal getTellerCode()
	{
	    return tellerCode;
	}

	public void setTellerCode(BigDecimal tellerCode)
	{
	    this.tellerCode = tellerCode;
	}
	
}