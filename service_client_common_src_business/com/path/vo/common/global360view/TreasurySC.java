package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class TreasurySC extends GridParamsSC {
	
	
	private BigDecimal cifNo;	
	private String  branchFilter;
	
	
	public BigDecimal getCifNo() {
		return cifNo;
	}
	public void setCifNo(BigDecimal cifNo) {
		this.cifNo = cifNo;
	}
	public void setBranchFilter(String branchFilter) {
		this.branchFilter = branchFilter;
	}
	public String getBranchFilter() {
		return branchFilter;
	}
	

}
