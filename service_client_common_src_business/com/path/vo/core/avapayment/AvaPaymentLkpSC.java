package com.path.vo.core.avapayment;

import java.math.BigDecimal;
import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * AvaCategorySC.java used to
 */
public class AvaPaymentLkpSC extends GridParamsSC
{	

    	private BigDecimal paymentCode;	    
	private BigDecimal trxType;
    	private String avaPaymentCode;
    	private String language;
    	private BigDecimal lovPayMethod;
    	private BigDecimal lovReturnType;
    	private BigDecimal cifNo;
	private BigDecimal benefStatusLov;
	private String trxMethod;
	private String screenRef;
    	
	
	public BigDecimal getPaymentCode()
	{
	    return paymentCode;
	}
	public void setPaymentCode(BigDecimal paymentCode)
	{
	    this.paymentCode = paymentCode;
	}
	public BigDecimal getTrxType() {
		return trxType;
	}
	public void setTrxType(BigDecimal trxType) {
		this.trxType = trxType;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public BigDecimal getLovPayMethod() {
		return lovPayMethod;
	}
	public void setLovPayMethod(BigDecimal lovPayMethod) {
		this.lovPayMethod = lovPayMethod;
	}
	public BigDecimal getLovReturnType() {
		return lovReturnType;
	}
	public void setLovReturnType(BigDecimal lovReturnType) {
		this.lovReturnType = lovReturnType;
	}
	public BigDecimal getCifNo() {
		return cifNo;
	}
	public void setCifNo(BigDecimal cifNo) {
		this.cifNo = cifNo;
	}
	
	public BigDecimal getBenefStatusLov()
	{
	    return benefStatusLov;
	}
	public void setBenefStatusLov(BigDecimal benefStatusLov)
	{
	    this.benefStatusLov = benefStatusLov;
	}
	public String getTrxMethod()
	{
	    return trxMethod;
	}
	public void setTrxMethod(String trxMethod)
	{
	    this.trxMethod = trxMethod;
	}
	public String getScreenRef()
	{
	    return screenRef;
	}
	public void setScreenRef(String screenRef)
	{
	    this.screenRef = screenRef;
	}
	public String getAvaPaymentCode()
	{
	    return avaPaymentCode;
	}
	public void setAvaPaymentCode(String avaPaymentCode)
	{
	    this.avaPaymentCode = avaPaymentCode;
	}
}
