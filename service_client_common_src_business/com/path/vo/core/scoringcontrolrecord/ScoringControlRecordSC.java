package com.path.vo.core.scoringcontrolrecord;

import java.math.BigDecimal;
import com.path.dbmaps.vo.CIFCONTROL_DEFINE_SCORE_RANGEVO;
import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ScoringControlRecordSC.java used to
 */
public class ScoringControlRecordSC extends GridParamsSC
{
	 private CIFCONTROL_DEFINE_SCORE_RANGEVO   cifControlDefineScoreRangeVO = new CIFCONTROL_DEFINE_SCORE_RANGEVO  ();

	private BigDecimal compCode;
    private BigDecimal branch;
    private BigDecimal lovType;
    private String appName;
    private String progRef;
    private String ivCrud;
    private String language;
    private BigDecimal LovTypeId;
	 private BigDecimal scoreCode;
	 private BigDecimal dualParam;
	 private String status;

	
	public BigDecimal getCompCode()
	{
		return compCode;
	}
	
	public void setCompCode(BigDecimal compCode)
	{
		this.compCode = compCode;
	}
	
	public BigDecimal getBranch()
	{
		return branch;
	}
	
	public void setBranch(BigDecimal branch)
	{
		this.branch = branch;
	}
	
	public BigDecimal getLovType()
	{
		return lovType;
	}
	
	public void setLovType(BigDecimal lovType)
	{
		this.lovType = lovType;
	}
	
	public String getAppName()
	{
		return appName;
	}
	
	public void setAppName(String appName)
	{
		this.appName = appName;
	}
	
	public String getProgRef()
	{
		return progRef;
	}
	
	public void setProgRef(String progRef)
	{
		this.progRef = progRef;
	}
	
	public String getIvCrud()
	{
		return ivCrud;
	}
	
	public void setIvCrud(String ivCrud)
	{
		this.ivCrud = ivCrud;
	}
	
	public String getLanguage()
	{
		return language;
	}
	
	public void setLanguage(String language)
	{
		this.language = language;
	}
	
	public BigDecimal getLovTypeId()
	{
		return LovTypeId;
	}
	
	public void setLovTypeId(BigDecimal lovTypeId)
	{
		LovTypeId = lovTypeId;
	}

	
	public CIFCONTROL_DEFINE_SCORE_RANGEVO getCifControlDefineScoreRangeVO()
	{
		return cifControlDefineScoreRangeVO;
	}

	
	public void setCifControlDefineScoreRangeVO(CIFCONTROL_DEFINE_SCORE_RANGEVO cifControlDefineScoreRangeVO)
	{
		this.cifControlDefineScoreRangeVO = cifControlDefineScoreRangeVO;
	}

	
	public BigDecimal getScoreCode()
	{
		return scoreCode;
	}

	
	public void setScoreCode(BigDecimal scoreCode)
	{
		this.scoreCode = scoreCode;
	}

	
	public BigDecimal getDualParam()
	{
		return dualParam;
	}

	
	public void setDualParam(BigDecimal dualParam)
	{
		this.dualParam = dualParam;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
