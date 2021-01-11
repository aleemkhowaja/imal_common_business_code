package com.path.vo.core.trxmgnt.breakingdeposit;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class TrxMgntBreakingDepositSC extends GridParamsSC {
	private BigDecimal trsNo;
    private String cbInd;
    private String trsType;
    private String language;
	private String appName;
	private String progRef;
	private String ivCrud;
	private String preferredLanguage;
	private String isChangedRelatedGl;
	private String isChangedRate;
	
	
	
	public String getIsChangedRate() {
		return isChangedRate;
	}

	public void setIsChangedRate(String isChangedRate) {
		this.isChangedRate = isChangedRate;
	}

	public String getIsChangedRelatedGl() {
		return isChangedRelatedGl;
	}

	public void setIsChangedRelatedGl(String isChangedRelatedGl) {
		this.isChangedRelatedGl = isChangedRelatedGl;
	}

	private BigDecimal glCode;
	
	
	public BigDecimal getGlCode() {
		return glCode;
	}

	public void setGlCode(BigDecimal glCode) {
		this.glCode = glCode;
	}

	public BigDecimal getTrsNo() {
		return trsNo;
	}

	public void setTrsNo(BigDecimal trsNo) {
		this.trsNo = trsNo;
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

	 

	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	public String getCbInd() {
		return cbInd;
	}

	public void setCbInd(String cbInd) {
		this.cbInd = cbInd;
	}

	public String getTrsType() {
		return trsType;
	}

	public void setTrsType(String trsType) {
		this.trsType = trsType;
	}
}
