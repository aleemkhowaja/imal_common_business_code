package com.path.vo.core.trxmgnt.accountdtl;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class TrxMgntAccountDtlSC extends GridParamsSC {
	private BigDecimal trsNo;

	private String     language;
	private BigDecimal lovType;
	private String     appName;
	private String     progRef;
	private String     ivCrud;
	private String     currStatus;
	
	private BigDecimal trxType;
	
	private String     trsfrMethod;
	private String     cbInd;
	private String     trsType;
	
	private String totalPercMsg;
	private boolean accDtlsBtnEnabled;

	public BigDecimal getTrsNo() {
		return trsNo;
	}

	public void setTrsNo(BigDecimal trsNo) {
		this.trsNo = trsNo;
	}

	public BigDecimal getLovType() {
		return lovType;
	}

	public void setLovType(BigDecimal lovType) {
		this.lovType = lovType;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getProgRef() {
		return progRef;
	}

	public void setProgRef(String progRef) {
		this.progRef = progRef;
	}

	public String getIvCrud() {
		return ivCrud;
	}

	public void setIvCrud(String ivCrud) {
		this.ivCrud = ivCrud;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTotalPercMsg()
	{
		return totalPercMsg;
	}

	public void setTotalPercMsg(String totalPercMsg)
	{
		this.totalPercMsg = totalPercMsg;
	}

	/**
	 * @return the trsfrMethod
	 */
	public String getTrsfrMethod()
	{
	    return trsfrMethod;
	}

	/**
	 * @param trsfrMethod the trsfrMethod to set
	 */
	public void setTrsfrMethod(String trsfrMethod)
	{
	    this.trsfrMethod = trsfrMethod;
	}

	/**
	 * @return the cbInd
	 */
	public String getCbInd()
	{
	    return cbInd;
	}

	/**
	 * @param cbInd the cbInd to set
	 */
	public void setCbInd(String cbInd)
	{
	    this.cbInd = cbInd;
	}

	/**
	 * @return the trxType
	 */
	public BigDecimal getTrxType()
	{
	    return trxType;
	}

	/**
	 * @param trxType the trxType to set
	 */
	public void setTrxType(BigDecimal trxType)
	{
	    this.trxType = trxType;
	}

	/**
	 * @return the trsType
	 */
	public String getTrsType()
	{
	    return trsType;
	}

	/**
	 * @param trsType the trsType to set
	 */
	public void setTrsType(String trsType)
	{
	    this.trsType = trsType;
	}

	/**
	 * @return the currStatus
	 */
	public String getCurrStatus()
	{
	    return currStatus;
	}

	/**
	 * @param currStatus the currStatus to set
	 */
	public void setCurrStatus(String currStatus)
	{
	    this.currStatus = currStatus;
	}

	public boolean isAccDtlsBtnEnabled() {
		return accDtlsBtnEnabled;
	}

	public void setAccDtlsBtnEnabled(boolean accDtlsBtnEnabled) {
		this.accDtlsBtnEnabled = accDtlsBtnEnabled;
	}

}
