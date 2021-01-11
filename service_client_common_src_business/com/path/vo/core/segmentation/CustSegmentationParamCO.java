package com.path.vo.core.segmentation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.AML_PARAM_MAPPINGVO;
import com.path.dbmaps.vo.CTS_SEGMENT_PARAMVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * CustSegmentationCO.java used to
 */
public class CustSegmentationParamCO extends RetailBaseVO
{
    private CTS_SEGMENT_PARAMVO ctsSegmentParamVO = new CTS_SEGMENT_PARAMVO();
  //By Bilal For TP#750884
    private String jsonMultiselectArray;
    private List<AML_PARAM_MAPPINGVO> lstMultiSelect = new ArrayList<AML_PARAM_MAPPINGVO>(); 
    private AML_PARAM_MAPPINGVO paramMappingVO = new AML_PARAM_MAPPINGVO();
    private BigDecimal queryId;
    private String multiSelectlkp;
    private String querySelectParamGridStr; 
    private List<CustSegmentationParamCO> segQuerySelectParamCOLst = new ArrayList<CustSegmentationParamCO>(); 
    private BigDecimal oldQueryIdParam; 
    private String isSegmentationScore;
    private String isOpened;
    //end

    public CTS_SEGMENT_PARAMVO getCtsSegmentParamVO()
    {
        return ctsSegmentParamVO;
    }

    public void setCtsSegmentParamVO(CTS_SEGMENT_PARAMVO ctsSegmentParamVO)
    {
        this.ctsSegmentParamVO = ctsSegmentParamVO;
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


	public List<CustSegmentationParamCO> getSegQuerySelectParamCOLst() {
		return segQuerySelectParamCOLst;
	}

	public void setSegQuerySelectParamCOLst(List<CustSegmentationParamCO> segQuerySelectParamCOLst) {
		this.segQuerySelectParamCOLst = segQuerySelectParamCOLst;
	}

	public BigDecimal getOldQueryIdParam() {
		return oldQueryIdParam;
	}

	public void setOldQueryIdParam(BigDecimal oldQueryIdParam) {
		this.oldQueryIdParam = oldQueryIdParam;
	}

	public String getIsSegmentationScore() {
		return isSegmentationScore;
	}

	public void setIsSegmentationScore(String isSegmentationScore) {
		this.isSegmentationScore = isSegmentationScore;
	}

	public String getIsOpened() {
		return isOpened;
	}

	public void setIsOpened(String isOpened) {
		this.isOpened = isOpened;
	}
	

}