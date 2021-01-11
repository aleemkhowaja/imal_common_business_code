/**
 * 
 */
package com.path.vo.iis.common;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * @author Raees
 *
 */
public class IISInvestmentDealSC extends GridParamsSC {
	private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal utilizationCurrency; 
    private String tangibleAsset;
    private Date fromDate;
    private Date toDate;
    
    private BigDecimal dealNumber;
    private String utilizaionStatus;
    
	public BigDecimal getCompCode() {
		return compCode;
	}
	public void setCompCode(BigDecimal compCode) {
		this.compCode = compCode;
	}
	public BigDecimal getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(BigDecimal branchCode) {
		this.branchCode = branchCode;
	}
	public BigDecimal getUtilizationCurrency() {
		return utilizationCurrency;
	}
	public void setUtilizationCurrency(BigDecimal utilizationCurrency) {
		this.utilizationCurrency = utilizationCurrency;
	}
	public String getTangibleAsset() {
		return tangibleAsset;
	}
	public void setTangibleAsset(String tangibleAsset) {
		this.tangibleAsset = tangibleAsset;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public BigDecimal getDealNumber() {
		return dealNumber;
	}
	public void setDealNumber(BigDecimal dealNumber) {
		this.dealNumber = dealNumber;
	}
	public String getUtilizaionStatus() {
		return utilizaionStatus;
	}
	public void setUtilizaionStatus(String utilizaionStatus) {
		this.utilizaionStatus = utilizaionStatus;
	}
}
