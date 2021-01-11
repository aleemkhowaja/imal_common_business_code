package com.path.vo.core.blacklisttype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import com.path.dbmaps.vo.MOSBLACKLIST_TYPEVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.common.RetailBaseVO;
  
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * author:Nour
 * 
 * BlackListTypeCO.java used to
 */
public class BlackListTypeCO extends RetailBaseVO
{
  private MOSBLACKLIST_TYPEVO   mosBlackListTypeVO = new MOSBLACKLIST_TYPEVO  ();
  private MOSBLACKLIST_TYPEVO   oldMosBlackListTypeVO = new MOSBLACKLIST_TYPEVO  ();

  private String ivCrud;
	private BigDecimal LovTypeId;
	private String ProgRef;
	private BigDecimal code;
	private BigDecimal branch;
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> screenParam = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private ArrayList<SmartCO> smartCOList;
	private BigDecimal dualParam;
    private String statusDesc;
    private BigDecimal delete;
    private BigDecimal method;



public MOSBLACKLIST_TYPEVO getMosBlackListTypeVO()
{
	return mosBlackListTypeVO;
}


public void setMosBlackListTypeVO(MOSBLACKLIST_TYPEVO mosBlackListTypeVO)
{
	this.mosBlackListTypeVO = mosBlackListTypeVO;
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



public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
{
	return buisnessElement;
}



public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
{
	this.buisnessElement = buisnessElement;
}



public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getScreenParam()
{
	return screenParam;
}



public void setScreenParam(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> screenParam)
{
	this.screenParam = screenParam;
}



public ArrayList<SmartCO> getSmartCOList()
{
	return smartCOList;
}



public void setSmartCOList(ArrayList<SmartCO> smartCOList)
{
	this.smartCOList = smartCOList;
}



public MOSBLACKLIST_TYPEVO getOldMosBlackListTypeVO()
{
	return oldMosBlackListTypeVO;
}



public void setOldMosBlackListTypeVO(MOSBLACKLIST_TYPEVO oldMosBlackListTypeVO)
{
	this.oldMosBlackListTypeVO = oldMosBlackListTypeVO;
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
