package com.path.vo.core.criteria;

import java.math.BigDecimal;
import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * @author: tonyelkhoury GridParamsSC: contains the parameters needed for Search, Flipping and Sorting
 * 
 */
public class CriteriaSC extends GridParamsSC
{

        public CriteriaSC()
        {
    		super.setSearchCols(new String[] { "CRITERIA_CODE", "CRITERIA_DESC", "QUERY_ID", "PROCEDURE_ID" });
        }

	private String progRef;
	private String appName;
	private String lang;
	private String ivCrud;
	private BigDecimal id;
	private BigDecimal procLineNo;
	private BigDecimal BRANCH_CODE;
	private BigDecimal CRITERIA_CODE;
	private String ENTITY_TYPE;
	private BigDecimal ENTITY_ID;
	private String entityName;
	private BigDecimal PARAM_ORDER;
	private String paramName;
	private String isSegmentationScore; // Rania - 718813 - Dynamic Customer Scoring on latest
	//Bilal - 750884
	private BigDecimal queryId; 
	private BigDecimal businessRuleCode; 
	private String querySelectParamGridStr;
	private BigDecimal criteriaEntityId; 
	private BigDecimal paramQueryId;
	
	public String getParamName()
	{
		return paramName;
	}

	public void setParamName(String paramName)
	{
		this.paramName = paramName;
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

	public BigDecimal getId()
	{
		return id;
	}

	public void setId(BigDecimal id)
	{
		this.id = id;
	}

	public BigDecimal getProcLineNo()
	{
		return procLineNo;
	}

	public void setProcLineNo(BigDecimal procLineNo)
	{
		this.procLineNo = procLineNo;
	}

	public BigDecimal getBRANCH_CODE()
	{
		return BRANCH_CODE;
	}

	public void setBRANCH_CODE(BigDecimal bRANCHCODE)
	{
		BRANCH_CODE = bRANCHCODE;
	}

	public BigDecimal getCRITERIA_CODE()
	{
		return CRITERIA_CODE;
	}

	public void setCRITERIA_CODE(BigDecimal cRITERIACODE)
	{
		CRITERIA_CODE = cRITERIACODE;
	}

	public String getENTITY_TYPE()
	{
		return ENTITY_TYPE;
	}

	public void setENTITY_TYPE(String eNTITYTYPE)
	{
		ENTITY_TYPE = eNTITYTYPE;
	}

	public BigDecimal getENTITY_ID()
	{
		return ENTITY_ID;
	}

	public void setENTITY_ID(BigDecimal eNTITYID)
	{
		ENTITY_ID = eNTITYID;
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

	public void setPARAM_ORDER(BigDecimal pARAMORDER)
	{
		PARAM_ORDER = pARAMORDER;
	}

	public String getIsSegmentationScore()
	{
		return isSegmentationScore;
	}

	public void setIsSegmentationScore(String isSegmentationScore)
	{
		this.isSegmentationScore = isSegmentationScore;
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

	public BigDecimal getParamQueryId() {
		return paramQueryId;
	}

	public void setParamQueryId(BigDecimal paramQueryId) {
		this.paramQueryId = paramQueryId;
	}
	
	
}
