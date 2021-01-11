package com.path.vo.core.avapayment;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * AvaPaymentSC.java used to
 */
public class AvaPaymentSC extends GridParamsSC
{
	private BigDecimal compCode;
	private BigDecimal paymentCode;
	private BigDecimal countryCode;
	private String language;
	private String statusCode;
	private BigDecimal lovPayMethod;
	private BigDecimal lovReturnType;
	private BigDecimal lovType;
	private BigDecimal lovStatus;
	private String ivCrud;
	private String progRef;
	private String appName;
	private String screenSrc;
	private String avaPaymentCancelation;
	private BigDecimal avaFileCode;
	private Date periodDate;
	private String paymentType;
	private String addGroup;
	private String restPayBal;
	private String addAction;
	private Date startPeriodDate;
	private Date endPeriodDate;
	private BigDecimal amountPaid;
	private BigDecimal cifNo;
	private Date departureDate;
	private Date returnDate;
	private BigDecimal sumLimitAllPeriod;
	private BigDecimal categCode;
	
	private Date openingFileDate;

	
	
	public Date getDepartureDate()
	{
	    return departureDate;
	}
	public void setDepartureDate(Date departureDate)
	{
	    this.departureDate = departureDate;
	}
	public Date getReturnDate()
	{
	    return returnDate;
	}
	public void setReturnDate(Date returnDate)
	{
	    this.returnDate = returnDate;
	}
	public BigDecimal getCifNo()
	{
	    return cifNo;
	}
	public void setCifNo(BigDecimal cifNo)
	{
	    this.cifNo = cifNo;
	}
	public BigDecimal getAmountPaid()
	{
	    return amountPaid;
	}
	public void setAmountPaid(BigDecimal amountPaid)
	{
	    this.amountPaid = amountPaid;
	}
	/**
	 * @return the appName
	 */
	public String getAppName()
	{
	    return appName;
	}
	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName)
	{
	    this.appName = appName;
	}
	/**
	 * @return the progRef
	 */
	public String getProgRef()
	{
	    return progRef;
	}
	/**
	 * @param progRef the progRef to set
	 */
	public void setProgRef(String progRef)
	{
	    this.progRef = progRef;
	}
	/**
	 * @return the ivCrud
	 */
	public String getIvCrud()
	{
	    return ivCrud;
	}
	/**
	 * @param ivCrud the ivCrud to set
	 */
	public void setIvCrud(String ivCrud)
	{
	    this.ivCrud = ivCrud;
	}
	public void setCompCode(BigDecimal compCode)
	{
		this.compCode = compCode;
	}
	public BigDecimal getCompCode()
	{
		return compCode;
	}
	public void setPaymentCode(BigDecimal paymentCode)
	{
		this.paymentCode = paymentCode;
	}
	public BigDecimal getPaymentCode()
	{
		return paymentCode;
	}
	/**
	 * @return the language
	 */
	public String getLanguage()
	{
	    return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language)
	{
	    this.language = language;
	}
	/**
	 * @return the statusCode
	 */
	public String getStatusCode()
	{
	    return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode)
	{
	    this.statusCode = statusCode;
	}
	/**
	 * @return the countryCode
	 */
	public BigDecimal getCountryCode()
	{
	    return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(BigDecimal countryCode)
	{
	    this.countryCode = countryCode;
	}
	/**
	 * @return the lovPayMethod
	 */
	public BigDecimal getLovPayMethod()
	{
	    return lovPayMethod;
	}
	/**
	 * @param lovPayMethod the lovPayMethod to set
	 */
	public void setLovPayMethod(BigDecimal lovPayMethod)
	{
	    this.lovPayMethod = lovPayMethod;
	}
	/**
	 * @return the lovReturnType
	 */
	public BigDecimal getLovReturnType()
	{
	    return lovReturnType;
	}
	/**
	 * @param lovReturnType the lovReturnType to set
	 */
	public void setLovReturnType(BigDecimal lovReturnType)
	{
	    this.lovReturnType = lovReturnType;
	}
	/**
	 * @return the lovStatus
	 */
	public BigDecimal getLovStatus()
	{
	    return lovStatus;
	}
	/**
	 * @param lovStatus the lovStatus to set
	 */
	public void setLovStatus(BigDecimal lovStatus)
	{
	    this.lovStatus = lovStatus;
	}
	/**
	 * @return the lovType
	 */
	public BigDecimal getLovType()
	{
	    return lovType;
	}
	/**
	 * @param lovType the lovType to set
	 */
	public void setLovType(BigDecimal lovType)
	{
	    this.lovType = lovType;
	}
	public String getScreenSrc()
	{
	    return screenSrc;
	}
	public void setScreenSrc(String screenSrc)
	{
	    this.screenSrc = screenSrc;
	}
	public String getAvaPaymentCancelation()
	{
	    return avaPaymentCancelation;
	}
	public void setAvaPaymentCancelation(String avaPaymentCancelation)
	{
	    this.avaPaymentCancelation = avaPaymentCancelation;
	}
	public BigDecimal getAvaFileCode()
	{
	    return avaFileCode;
	}
	public void setAvaFileCode(BigDecimal avaFileCode)
	{
	    this.avaFileCode = avaFileCode;
	}
	public Date getPeriodDate()
	{
	    return periodDate;
	}
	public void setPeriodDate(Date periodDate)
	{
	    this.periodDate = periodDate;
	}
	public String getPaymentType()
	{
	    return paymentType;
	}
	public void setPaymentType(String paymentType)
	{
	    this.paymentType = paymentType;
	}
	public String getAddGroup()
	{
	    return addGroup;
	}
	public void setAddGroup(String addGroup)
	{
	    this.addGroup = addGroup;
	}
	public String getRestPayBal()
	{
	    return restPayBal;
	}
	public void setRestPayBal(String restPayBal)
	{
	    this.restPayBal = restPayBal;
	}
	public String getAddAction()
	{
	    return addAction;
	}
	public void setAddAction(String addAction)
	{
	    this.addAction = addAction;
	}
	 public Date getStartPeriodDate()
     {
         return startPeriodDate;
     }
     public void setStartPeriodDate(Date startPeriodDate)
     {
         this.startPeriodDate = startPeriodDate;
     }
     public Date getEndPeriodDate()
     {
         return endPeriodDate;
     }
     public void setEndPeriodDate(Date endPeriodDate)
     {
         this.endPeriodDate = endPeriodDate;
     }
    public BigDecimal getSumLimitAllPeriod()
    {
        return sumLimitAllPeriod;
    }
    public void setSumLimitAllPeriod(BigDecimal sumLimitAllPeriod)
    {
        this.sumLimitAllPeriod = sumLimitAllPeriod;
    }
	public BigDecimal getCategCode() {
		return categCode;
	}
	public void setCategCode(BigDecimal categCode) {
		this.categCode = categCode;
	}
	public Date getOpeningFileDate()
	{
	    return openingFileDate;
	}
	public void setOpeningFileDate(Date openingFileDate)
	{
	    this.openingFileDate = openingFileDate;
	}


}
