package com.path.vo.core.criteria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.AML_PARAM_MAPPINGVO;
import com.path.dbmaps.vo.CTS_CRITERIA_PARAMVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: tonyelkhoury
 * 
 * 
 */

public class CriteriaParamCO extends RetailBaseVO
{

    private CTS_CRITERIA_PARAMVO ctsCriteriaParamVO = new CTS_CRITERIA_PARAMVO();
    private String entityName;
    //By Bilal For TP#750884
    private String jsonMultiselectArray;
    private List<AML_PARAM_MAPPINGVO> lstMultiSelect = new ArrayList<AML_PARAM_MAPPINGVO>(); 
    private AML_PARAM_MAPPINGVO paramMappingVO = new AML_PARAM_MAPPINGVO();
    private BigDecimal queryId;
    private String multiSelectlkp;
    private String querySelectParamGridStr; //By Bilal For TP#750884
    private List<CriteriaParamCO> criteriaQuerySelectParamCOLst = new ArrayList<CriteriaParamCO>(); //By Bilal For TP#750884
    private BigDecimal oldQueryIdParam; //By Bilal For TP#750884
    private String isOpened;
    
    public CTS_CRITERIA_PARAMVO getCtsCriteriaParamVO()
    {
	return ctsCriteriaParamVO;
    }

    public void setCtsCriteriaParamVO(CTS_CRITERIA_PARAMVO ctsCriteriaParamVO)
    {
	this.ctsCriteriaParamVO = ctsCriteriaParamVO;
    }

    public String getEntityName()
    {
	return entityName;
    }

    public void setEntityName(String entityName)
    {
	this.entityName = entityName;
    }

	public String getJsonMultiselectArray() {
		return jsonMultiselectArray;
	}

	public void setJsonMultiselectArray(String jsonMultiselectArray) {
		this.jsonMultiselectArray = jsonMultiselectArray;
	}

	public List<AML_PARAM_MAPPINGVO> getLstMultiSelect() {
		return lstMultiSelect;
	}

	public void setLstMultiSelect(List<AML_PARAM_MAPPINGVO> lstMultiSelect) {
		this.lstMultiSelect = lstMultiSelect;
	}

	public AML_PARAM_MAPPINGVO getParamMappingVO() {
		return paramMappingVO;
	}

	public void setParamMappingVO(AML_PARAM_MAPPINGVO paramMappingVO) {
		this.paramMappingVO = paramMappingVO;
	}

	public BigDecimal getQueryId() {
		return queryId;
	}

	public void setQueryId(BigDecimal queryId) {
		this.queryId = queryId;
	}

	public String getMultiSelectlkp() {
		return multiSelectlkp;
	}

	public void setMultiSelectlkp(String multiSelectlkp) {
		this.multiSelectlkp = multiSelectlkp;
	}

	public String getQuerySelectParamGridStr() {
		return querySelectParamGridStr;
	}

	public void setQuerySelectParamGridStr(String querySelectParamGridStr) {
		this.querySelectParamGridStr = querySelectParamGridStr;
	}

	public List<CriteriaParamCO> getCriteriaQuerySelectParamCOLst() {
		return criteriaQuerySelectParamCOLst;
	}

	public void setCriteriaQuerySelectParamCOLst(List<CriteriaParamCO> criteriaQuerySelectParamCOLst) {
		this.criteriaQuerySelectParamCOLst = criteriaQuerySelectParamCOLst;
	}

	public BigDecimal getOldQueryIdParam() {
		return oldQueryIdParam;
	}

	public void setOldQueryIdParam(BigDecimal oldQueryIdParam) {
		this.oldQueryIdParam = oldQueryIdParam;
	}

	public String getIsOpened() {
		return isOpened;
	}

	public void setIsOpened(String isOpened) {
		this.isOpened = isOpened;
	}


}
