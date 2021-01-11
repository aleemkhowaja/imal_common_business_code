package com.path.vo.core.blacklistsource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import com.path.dbmaps.vo.MOSBLACKSOURCEVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * BlackListSourceCO.java used to
 * 
 * nour tp id #777000
 */
public class BlackListSourceCO extends RetailBaseVO
{

	private MOSBLACKSOURCEVO blackSourceVO = new MOSBLACKSOURCEVO();
	private MOSBLACKSOURCEVO oldBlackSourceVO = new MOSBLACKSOURCEVO();

	private String ivCrud;
	private BigDecimal LovTypeId;
	private String ProgRef;
	private BigDecimal code;
	private BigDecimal cif;
	private BigDecimal branch;
	private String CENTRAL_BANK;
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> screenParam = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private String shortEng;
	private String shortAr;
	private String longEng;
	private String longAr;
	private BigDecimal dualParam;
    private String statusDesc;
    private BigDecimal delete;
    private BigDecimal method;




	// SMART list
	private ArrayList<SmartCO> smartCOList;
	private Date runningDateTime;

	public MOSBLACKSOURCEVO getBlackSourceVO()
	{
		return blackSourceVO;
	}

	public void setBlackSourceVO(MOSBLACKSOURCEVO blackSourceVO)
	{
		this.blackSourceVO = blackSourceVO;
	}

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

	

	public BigDecimal getCode()
	{
		return code;
	}

	public void setCode(BigDecimal code)
	{
		this.code = code;
	}

	public BigDecimal getBranch()
	{
		return branch;
	}

	public void setBranch(BigDecimal branch)
	{
		this.branch = branch;
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

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getScreenParam()
	{
		return screenParam;
	}

	public void setScreenParam(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> screenParam)
	{
		this.screenParam = screenParam;
	}

	public MOSBLACKSOURCEVO getOldBlackSourceVO()
	{
		return oldBlackSourceVO;
	}

	public void setOldBlackSourceVO(MOSBLACKSOURCEVO oldBlackSourceVO)
	{
		this.oldBlackSourceVO = oldBlackSourceVO;
	}

	public String getCENTRAL_BANK()
	{
		return CENTRAL_BANK;
	}

	public void setCENTRAL_BANK(String cENTRAL_BANK)
	{
		CENTRAL_BANK = cENTRAL_BANK;
	}

	
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
	{
		return buisnessElement;
	}

	
	public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
	{
		this.buisnessElement = buisnessElement;
	}

	
	public BigDecimal getCif()
	{
		return cif;
	}

	
	public void setCif(BigDecimal cif)
	{
		this.cif = cif;
	}

	
	public String getShortEng()
	{
		return shortEng;
	}

	
	public void setShortEng(String shortEng)
	{
		this.shortEng = shortEng;
	}

	
	public String getShortAr()
	{
		return shortAr;
	}

	
	public void setShortAr(String shortAr)
	{
		this.shortAr = shortAr;
	}

	
	public String getLongEng()
	{
		return longEng;
	}

	
	public void setLongEng(String longEng)
	{
		this.longEng = longEng;
	}

	
	public String getLongAr()
	{
		return longAr;
	}

	
	public void setLongAr(String longAr)
	{
		this.longAr = longAr;
	}

	
	public BigDecimal getDualParam()
	{
		return dualParam;
	}

	
	public void setDualParam(BigDecimal dualParam)
	{
		this.dualParam = dualParam;
	}

	
	public String getStatusDesc()
	{
		return statusDesc;
	}

	
	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}

	
	public BigDecimal getDelete()
	{
		return delete;
	}

	
	public void setDelete(BigDecimal delete)
	{
		this.delete = delete;
	}

	
	public BigDecimal getMethod()
	{
		return method;
	}

	
	public void setMethod(BigDecimal method)
	{
		this.method = method;
	}
	

}
