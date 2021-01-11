package com.path.vo.core.specialconditions;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

@SuppressWarnings("serial")
public final class SpecialConditionsSC extends GridParamsSC
{
    private String requesterSourceAsReasonType = String.valueOf(17);
    private BigDecimal lineNo;
    private BigDecimal forbidProdcutExceptionLineNo;
    private BigDecimal cifNoSC;
    private BigDecimal accGlSC;
    private BigDecimal accCifSC;
    private BigDecimal accSlSC;
    
    private String language;
    private String ivCrud;
    
    private BigDecimal statusLov;
    private BigDecimal entityTypeLov;
    private BigDecimal forbitRestricTrxLov;
    private BigDecimal forbitProductLov;
    private BigDecimal recordSourceLov;
    
    private String appName;
    private String progRef;
    private BigDecimal batchNo;
    private String alertStatus;
    private BigDecimal errorCode;
    private String errorMessage;
    private String status; // BB110153 - Special Condition 
    private BigDecimal grantAll;  // BB110153 - Special Condition 
    private String allowCifCreationMaskYN;
    private String isLoadGrid;
    private String allowDelSpcCondDecYN; //reda SUPT190047
    

    private BigDecimal spCondLineNo;
    private String crDrForex;
    private Date forbidExceptionFromTime;
    private Date forbidExceptionToTime;
    private BigDecimal exceptionLineNo;
    
    private String editAllBranchesSpConds;//JAIZ200115  
    


    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public String getIvCrud()
    {
	return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    public void setStatusLov(BigDecimal statuslovtype)
    {
	this.statusLov = statuslovtype;
    }

    public BigDecimal getStatusLov()
    {
	return statusLov;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setRequesterSourceAsReasonType(String requesterSourceAsReasonType)
    {
	this.requesterSourceAsReasonType = requesterSourceAsReasonType;
    }

    public String getRequesterSourceAsReasonType()
    {
	return requesterSourceAsReasonType;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal obj)
    {
	this.lineNo = obj;
    }

    public BigDecimal getCifNoSC()
    {
	return cifNoSC;
    }

    public void setCifNoSC(BigDecimal obj)
    {
	this.cifNoSC = obj;
    }

    public BigDecimal getAccCifSC()
    {
	return accCifSC;
    }

    public void setAccCifSC(BigDecimal obj)
    {
	this.accCifSC = obj;
    }

    public BigDecimal getAccGlSC()
    {
	return accGlSC;
    }

    public void setAccGlSC(BigDecimal accGlSC)
    {
	this.accGlSC = accGlSC;
    }

    public BigDecimal getAccSlSC()
    {
	return accSlSC;
    }

    public void setAccSlSC(BigDecimal accSlSC)
    {
	this.accSlSC = accSlSC;
    }

    public void setBatchNo(BigDecimal obj)
    {
	this.batchNo = obj;
    }

    public BigDecimal getBatchNo()
    {
	return batchNo;
    }

    public String getAlertStatus()
    {
	return alertStatus;
    }

    public void setAlertStatus(String alertStatus)
    {
	this.alertStatus = alertStatus;
    }

    public BigDecimal getErrorCode()
    {
	return errorCode;
    }

    public void setErrorCode(BigDecimal obj)
    {
	this.errorCode = obj;
    }

    public String getErrorMessage()
    {
	return errorMessage;
    }

    public void setErrorMessage(String obj)
    {
	this.errorMessage = obj;
    }

    public BigDecimal getEntityTypeLov()
    {
        return entityTypeLov;
    }

    public void setEntityTypeLov(BigDecimal entityTypeLov)
    {
        this.entityTypeLov = entityTypeLov;
    }

    public BigDecimal getForbitRestricTrxLov()
    {
        return forbitRestricTrxLov;
    }

    public void setForbitRestricTrxLov(BigDecimal forbitRestricTrxLov)
    {
        this.forbitRestricTrxLov = forbitRestricTrxLov;
    }

    public BigDecimal getForbitProductLov()
    {
        return forbitProductLov;
    }

    public void setForbitProductLov(BigDecimal forbitProductLov)
    {
        this.forbitProductLov = forbitProductLov;
    }

    public BigDecimal getRecordSourceLov()
    {
	return recordSourceLov;
    }

    public void setRecordSourceLov(BigDecimal recordSourceLov)
    {
	this.recordSourceLov = recordSourceLov;
    }

    public BigDecimal getGrantAll()
    {
	return grantAll;
    }

    public void setGrantAll(BigDecimal grantAll)
    {
	this.grantAll = grantAll;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }
    
    public BigDecimal getSpCondLineNo()
    {
	return spCondLineNo;
    }

    public void setSpCondLineNo(BigDecimal spCondLineNo)
    {
	this.spCondLineNo = spCondLineNo;
    }

    public String getCrDrForex()
    {
	return crDrForex;
    }

    public void setCrDrForex(String crDrForex)
    {
	this.crDrForex = crDrForex;
    }
    public Date getForbidExceptionFromTime()
    {
        return forbidExceptionFromTime;
    }

    public void setForbidExceptionFromTime(Date forbidExceptionFromTime)
    {
        this.forbidExceptionFromTime = forbidExceptionFromTime;
    }
    
    public Date getForbidExceptionToTime()
    {
        return forbidExceptionToTime;
    }

    public void setForbidExceptionToTime(Date forbidExceptionToTime)
    {
        this.forbidExceptionToTime = forbidExceptionToTime;
    }
    
    public BigDecimal getExceptionLineNo()
    {
	return exceptionLineNo;
    }

    public void setExceptionLineNo(BigDecimal exceptionLineNo)
    {
	this.exceptionLineNo = exceptionLineNo;
    }       
    
    
    
	public String getAllowCifCreationMaskYN()
	{
	    return allowCifCreationMaskYN;
	}

	public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
	{
	    this.allowCifCreationMaskYN = allowCifCreationMaskYN;
	}

	
	public String getAllowDelSpcCondDecYN()
	{
	    return allowDelSpcCondDecYN;
	}

	public void setAllowDelSpcCondDecYN(String allowDelSpcCondDecYN)
	{
	    this.allowDelSpcCondDecYN = allowDelSpcCondDecYN;
	}

	
	public String getIsLoadGrid()
	{
	    return isLoadGrid;
	}

	public void setIsLoadGrid(String isLoadGrid)
	{
	    this.isLoadGrid = isLoadGrid;
	}

	public BigDecimal getForbidProdcutExceptionLineNo()
	{
	    return forbidProdcutExceptionLineNo;
	}

	public void setForbidProdcutExceptionLineNo(BigDecimal forbidProdcutExceptionLineNo)
	{
	    this.forbidProdcutExceptionLineNo = forbidProdcutExceptionLineNo;
	}
	
	public String getEditAllBranchesSpConds()
	{
	    return editAllBranchesSpConds;
	}

	public void setEditAllBranchesSpConds(String editAllBranchesSpConds)
	{
	    this.editAllBranchesSpConds = editAllBranchesSpConds;
	}
	    
}

