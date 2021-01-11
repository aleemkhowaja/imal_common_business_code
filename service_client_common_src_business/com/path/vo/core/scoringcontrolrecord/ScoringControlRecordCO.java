package com.path.vo.core.scoringcontrolrecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.AML_CIFCONTROL_RECORD_SCOREVO;
import com.path.dbmaps.vo.CIFCONTROL_DEFINE_SCORE_RANGEVO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.common.RetailBaseVO;
  
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ScoringControlRecordCO.java used to
 */
public class ScoringControlRecordCO extends RetailBaseVO
{
 private CIFCONTROL_DEFINE_SCORE_RANGEVO   cifControlDefineScoreRangeVO = new CIFCONTROL_DEFINE_SCORE_RANGEVO  ();
 private CIFCONTROL_DEFINE_SCORE_RANGEVO   oldCifControlDefineScoreRangeVO = new CIFCONTROL_DEFINE_SCORE_RANGEVO  ();
//by bilal for TP#987360
 private AML_CIFCONTROL_RECORD_SCOREVO amlCifControlScoreVO = new AML_CIFCONTROL_RECORD_SCOREVO();//by bilal for TP#987360
 private AML_CIFCONTROL_RECORD_SCOREVO oldAmlCifControlScoreVO = new AML_CIFCONTROL_RECORD_SCOREVO();//by bilal for TP#987360
 //end bilal
 private String ivCrud;
	 private BigDecimal dualParam;
	  private BigDecimal LovTypeId;
	  private String ProgRef;
	  private int isRTLDir;
	  private String statusDesc;
	  private ArrayList<SmartCO> smartCOList;
	  private Date runningDateTime;
	  private BigDecimal compCode;
	  private String saveUpdateFlag;
	  private BigDecimal method;
	  private List<ScoringControlRecordCO> allControlRecordDetailsData;
	    private List<ScoringControlRecordCO> oldAllControlRecordDetailsData;
	    private List<ScoringControlRecordCO> updatedListControlRecord;
	    private int countOfRows; //by bilal for BUG#973477
	    
	public String getIvCrud()
	{
		return ivCrud;
	}
	
	public void setIvCrud(String ivCrud)
	{
		this.ivCrud = ivCrud;
	}
	
	public BigDecimal getLovTypeId()
	{
		return LovTypeId;
	}
	
	public void setLovTypeId(BigDecimal lovTypeId)
	{
		LovTypeId = lovTypeId;
	}
	
	public String getProgRef()
	{
		return ProgRef;
	}
	
	public void setProgRef(String progRef)
	{
		ProgRef = progRef;
	}
	
	public int getIsRTLDir()
	{
		return isRTLDir;
	}
	
	public void setIsRTLDir(int isRTLDir)
	{
		this.isRTLDir = isRTLDir;
	}
	
	public ArrayList<SmartCO> getSmartCOList()
	{
		return smartCOList;
	}
	
	public void setSmartCOList(ArrayList<SmartCO> smartCOList)
	{
		this.smartCOList = smartCOList;
	}
	
	public Date getRunningDateTime()
	{
		return runningDateTime;
	}
	
	public void setRunningDateTime(Date runningDateTime)
	{
		this.runningDateTime = runningDateTime;
	}
	
	public BigDecimal getCompCode()
	{
		return compCode;
	}
	
	public void setCompCode(BigDecimal compCode)
	{
		this.compCode = compCode;
	}

	
	public String getSaveUpdateFlag()
	{
		return saveUpdateFlag;
	}

	
	public void setSaveUpdateFlag(String saveUpdateFlag)
	{
		this.saveUpdateFlag = saveUpdateFlag;
	}

	
	public CIFCONTROL_DEFINE_SCORE_RANGEVO getCifControlDefineScoreRangeVO()
	{
		return cifControlDefineScoreRangeVO;
	}

	
	public void setCifControlDefineScoreRangeVO(CIFCONTROL_DEFINE_SCORE_RANGEVO cifControlDefineScoreRangeVO)
	{
		this.cifControlDefineScoreRangeVO = cifControlDefineScoreRangeVO;
	}

	
	public List<ScoringControlRecordCO> getAllControlRecordDetailsData()
	{
		return allControlRecordDetailsData;
	}

	
	public void setAllControlRecordDetailsData(List<ScoringControlRecordCO> allControlRecordDetailsData)
	{
		this.allControlRecordDetailsData = allControlRecordDetailsData;
	}

	
	public List<ScoringControlRecordCO> getOldAllControlRecordDetailsData()
	{
		return oldAllControlRecordDetailsData;
	}

	
	public void setOldAllControlRecordDetailsData(List<ScoringControlRecordCO> oldAllControlRecordDetailsData)
	{
		this.oldAllControlRecordDetailsData = oldAllControlRecordDetailsData;
	}

	
	public List<ScoringControlRecordCO> getUpdatedListControlRecord()
	{
		return updatedListControlRecord;
	}

	
	public void setUpdatedListControlRecord(List<ScoringControlRecordCO> updatedListControlRecord)
	{
		this.updatedListControlRecord = updatedListControlRecord;
	}

	
	public String getStatusDesc()
	{
		return statusDesc;
	}

	
	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}

	
	public CIFCONTROL_DEFINE_SCORE_RANGEVO getOldCifControlDefineScoreRangeVO()
	{
		return oldCifControlDefineScoreRangeVO;
	}

	
	public void setOldCifControlDefineScoreRangeVO(CIFCONTROL_DEFINE_SCORE_RANGEVO oldCifControlDefineScoreRangeVO)
	{
		this.oldCifControlDefineScoreRangeVO = oldCifControlDefineScoreRangeVO;
	}

	
	public BigDecimal getDualParam()
	{
		return dualParam;
	}

	
	public void setDualParam(BigDecimal dualParam)
	{
		this.dualParam = dualParam;
	}

	
	public BigDecimal getMethod()
	{
		return method;
	}

	
	public void setMethod(BigDecimal method)
	{
		this.method = method;
	}

	public int getCountOfRows() {
		return countOfRows;
	}

	public void setCountOfRows(int countOfRows) {
		this.countOfRows = countOfRows;
	}

	public AML_CIFCONTROL_RECORD_SCOREVO getAmlCifControlScoreVO() {
		return amlCifControlScoreVO;
	}

	public void setAmlCifControlScoreVO(AML_CIFCONTROL_RECORD_SCOREVO amlCifControlScoreVO) {
		this.amlCifControlScoreVO = amlCifControlScoreVO;
	}

	public AML_CIFCONTROL_RECORD_SCOREVO getOldAmlCifControlScoreVO() {
		return oldAmlCifControlScoreVO;
	}

	public void setOldAmlCifControlScoreVO(AML_CIFCONTROL_RECORD_SCOREVO oldAmlCifControlScoreVO) {
		this.oldAmlCifControlScoreVO = oldAmlCifControlScoreVO;
	}

}
