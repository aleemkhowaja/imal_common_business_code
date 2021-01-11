package com.path.vo.core.transferentity;

import java.math.BigDecimal;
import com.path.struts2.lib.common.GridParamsSC;

public class TransferEntitySC extends GridParamsSC
{

	private String filterType;
	private String rangeType;
	
	private BigDecimal currencyCode;
	
	private String cifType;
	private String accountType;
	private String facilityType;
	private BigDecimal fromCif;
	private BigDecimal toCif;
	private BigDecimal fromApp;
	private BigDecimal toApp;
	private BigDecimal facilityBranch;
	private BigDecimal batchNo;
	private String relationManager;
	private String fromRetrieve;
	private String lang;
	private String status;
	private BigDecimal facilityCateg;
	private String methodName;
	private String oldRM;
	private String destRM;
	private BigDecimal cifNo;
	private BigDecimal errorCode;	
	private String errorMessage;
	//added by ali harissa for bug
	private String user_id;
	private String employee_id;

	   
	   
	
	
	
	public String getEmployee_id()
	{
		return employee_id;
	}


	
	public void setEmployee_id(String employee_id)
	{
		this.employee_id = employee_id;
	}


	public String getUser_id()
	{
		return user_id;
	}

	
	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}


	private BigDecimal fmsapp;

	public String getFilterType()
	{
		return filterType;
	}

	public void setFilterType(String filterType)
	{
		this.filterType = filterType;
	}

	public String getRangeType()
	{
		return rangeType;
	}

	public void setRangeType(String rangeType)
	{
		this.rangeType = rangeType;
	}

	public String getCifType()
	{
		return cifType;
	}

	public void setCifType(String cifType)
	{
		this.cifType = cifType;
	}

	public String getAccountType()
	{
		return accountType;
	}

	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}

	public String getFacilityType()
	{
		return facilityType;
	}

	public void setFacilityType(String facilityType)
	{
		this.facilityType = facilityType;
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

	public BigDecimal getFromApp()
	{
		return fromApp;
	}

	public void setFromApp(BigDecimal fromApp)
	{
		this.fromApp = fromApp;
	}

	public BigDecimal getToApp()
	{
		return toApp;
	}

	public void setToApp(BigDecimal toApp)
	{
		this.toApp = toApp;
	}

	public BigDecimal getFacilityBranch()
	{
		return facilityBranch;
	}

	public void setFacilityBranch(BigDecimal facilityBranch)
	{
		this.facilityBranch = facilityBranch;
	}



	public BigDecimal getBatchNo()
	{
		return batchNo;
	}

	public void setBatchNo(BigDecimal batchNo)
	{
		this.batchNo = batchNo;
	}

	public String getLang()
	{
		return lang;
	}

	public void setLang(String lang)
	{
		this.lang = lang;
	}

	public String getFromRetrieve()
	{
		return fromRetrieve;
	}

	public void setFromRetrieve(String fromRetrieve)
	{
		this.fromRetrieve = fromRetrieve;
	}

	
	public String getMethodName()
	{
		return methodName;
	}

	
	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}

	
	public String getStatus()
	{
		return status;
	}

	
	public void setStatus(String status)
	{
		this.status = status;
	}

	
	public BigDecimal getFacilityCateg()
	{
		return facilityCateg;
	}

	
	public void setFacilityCateg(BigDecimal facilityCateg)
	{
		this.facilityCateg = facilityCateg;
	}

	
	public BigDecimal getFmsapp()
	{
		return fmsapp;
	}

	
	public void setFmsapp(BigDecimal fmsapp)
	{
		this.fmsapp = fmsapp;
	}

	
	public BigDecimal getCurrencyCode()
	{
		return currencyCode;
	}

	
	public void setCurrencyCode(BigDecimal currencyCode)
	{
		this.currencyCode = currencyCode;
	}

	

	
	
	public String getRelationManager()
	{
		return relationManager;
	}


	
	public void setRelationManager(String relationManager)
	{
		this.relationManager = relationManager;
	}


	
	public String getOldRM()
	{
		return oldRM;
	}


	
	public void setOldRM(String oldRM)
	{
		this.oldRM = oldRM;
	}


	
	public String getDestRM()
	{
		return destRM;
	}


	
	public void setDestRM(String destRM)
	{
		this.destRM = destRM;
	}


	public BigDecimal getCifNo()
	{
		return cifNo;
	}

	
	public void setCifNo(BigDecimal cifNo)
	{
		this.cifNo = cifNo;
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

	

	

}
