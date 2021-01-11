package com.path.vo.core.blacklistmanagement;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class BlackListIntSourceSC extends GridParamsSC
{
    private String cifNo;
    private BigDecimal lovTypeId;
    private String checkedList;
    private String fromWhere;
    
    private String as_source; //used as parameter while calling soundex
    private BigDecimal OS_ERROR_CODE;
    private String OS_ERROR_TEXT;
    private String fileName;
    private String fileCode;
    private BigDecimal blckListCifNo;
    
    
    public String getCifNo()
    {
        return cifNo;
    }
    public void setCifNo(String cifNo)
    {
        this.cifNo = cifNo;
    }
    public BigDecimal getLovTypeId()
    {
        return lovTypeId;
    }
    public void setLovTypeId(BigDecimal lovTypeId)
    {
        this.lovTypeId = lovTypeId;
    }
    public String getCheckedList()
    {
        return checkedList;
    }
    public void setCheckedList(String checkedList)
    {
        this.checkedList = checkedList;
    }
    public String getFromWhere()
    {
        return fromWhere;
    }
    public void setFromWhere(String fromWhere)
    {
        this.fromWhere = fromWhere;
    }
	public String getAs_source() {
		return as_source;
	}
	public void setAs_source(String asSource) {
		as_source = asSource;
	}
	public BigDecimal getOS_ERROR_CODE() {
		return OS_ERROR_CODE;
	}
	public void setOS_ERROR_CODE(BigDecimal oSERRORCODE) {
		OS_ERROR_CODE = oSERRORCODE;
	}
	public String getOS_ERROR_TEXT() {
		return OS_ERROR_TEXT;
	}
	public void setOS_ERROR_TEXT(String oSERRORTEXT) {
		OS_ERROR_TEXT = oSERRORTEXT;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public BigDecimal getBlckListCifNo()
	{
	    return blckListCifNo;
	}
	public void setBlckListCifNo(BigDecimal blckListCifNo)
	{
	    this.blckListCifNo = blckListCifNo;
	}
	
	
    
}
