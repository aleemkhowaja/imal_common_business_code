package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.BaseSC;

public class PopulateCifSC extends BaseSC{
	

	BigDecimal fromCompany;
	BigDecimal toCompany;
	BigDecimal fromCif;
	BigDecimal toCif;
	BigDecimal popRange;
	BigDecimal ignoreOverriding;
	BigDecimal change;
	String briefName;
	String appName;  
	String suspendBy;
	Date  suspendDate;
	public BigDecimal getFromCompany() {
		return fromCompany;
	}
	public void setFromCompany(BigDecimal fromCompany) {
		this.fromCompany = fromCompany;
	}
	public BigDecimal getToCompany() {
		return toCompany;
	}
	public void setToCompany(BigDecimal toCompany) {
		this.toCompany = toCompany;
	}
	public BigDecimal getFromCif() {
		return fromCif;
	}
	public void setFromCif(BigDecimal fromCif) {
		this.fromCif = fromCif;
	}
	public BigDecimal getToCif() {
		return toCif;
	}
	public void setToCif(BigDecimal toCif) {
		this.toCif = toCif;
	}
	public BigDecimal getPopRange() {
		return popRange;
	}
	public void setPopRange(BigDecimal popRange) {
		this.popRange = popRange;
	}
	public BigDecimal getIgnoreOverriding() {
		return ignoreOverriding;
	}
	public void setIgnoreOverriding(BigDecimal ignoreOverriding) {
		this.ignoreOverriding = ignoreOverriding;
	}
	public BigDecimal getChange() {
		return change;
	}
	public void setChange(BigDecimal change) {
		this.change = change;
	}
	public String getBriefName() {
		return briefName;
	}
	public void setBriefName(String briefName) {
		this.briefName = briefName;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getSuspendBy() {
		return suspendBy;
	}
	public void setSuspendBy(String suspendBy) {
		this.suspendBy = suspendBy;
	}
	public Date getSuspendDate() {
		return suspendDate;
	}
	public void setSuspendDate(Date suspendDate) {
		this.suspendDate = suspendDate;
	}
	
	
	


}
