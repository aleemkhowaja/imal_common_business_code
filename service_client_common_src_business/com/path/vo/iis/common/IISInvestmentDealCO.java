package com.path.vo.iis.common;

import java.math.BigDecimal;
import java.util.Date;
import com.path.lib.vo.BaseVO;

public class IISInvestmentDealCO extends BaseVO 
{
	private BigDecimal compCode;
    private BigDecimal branchCode;
    private String tangibleAsset;
    private String countryDesc;
    private String categoryDesc;
    
	private BigDecimal lineNo;
	private BigDecimal dealNo;
	private BigDecimal dealCurrency;
	private BigDecimal productClass;
	private BigDecimal category;
	private BigDecimal cifNo;
	private BigDecimal countryCode;
	private BigDecimal netAssetValue;
	private BigDecimal amortization;
	private BigDecimal income;
	private BigDecimal principalAmount;
	private BigDecimal noOfInstallment;
    private BigDecimal markUpPercentage;
    private BigDecimal totalDealsValue;
    private BigDecimal totalIncome;
    
    private Date maturityDate;
	private Date installmentDate;
	private Date runningDate;
	
	
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
	public BigDecimal getLineNo() {
		return lineNo;
	}
	public void setLineNo(BigDecimal lineNo) {
		this.lineNo = lineNo;
	}
	public BigDecimal getDealNo() {
		return dealNo;
	}
	public void setDealNo(BigDecimal dealNo) {
		this.dealNo = dealNo;
	}
	public BigDecimal getProductClass() {
		return productClass;
	}
	public void setProductClass(BigDecimal productClass) {
		this.productClass = productClass;
	}
	public BigDecimal getCategory() {
		return category;
	}
	public void setCategory(BigDecimal category) {
		this.category = category;
	}
	public BigDecimal getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(BigDecimal countryCode) {
		this.countryCode = countryCode;
	}
	public BigDecimal getNetAssetValue() {
		return netAssetValue;
	}
	public void setNetAssetValue(BigDecimal netAssetValue) {
		this.netAssetValue = netAssetValue;
	}
	public BigDecimal getAmortization() {
		return amortization;
	}
	public void setAmortization(BigDecimal amortization) {
		this.amortization = amortization;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public BigDecimal getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(BigDecimal principalAmount) {
		this.principalAmount = principalAmount;
	}
	public BigDecimal getNoOfInstallment() {
		return noOfInstallment;
	}
	public void setNoOfInstallment(BigDecimal noOfInstallment) {
		this.noOfInstallment = noOfInstallment;
	}
	public BigDecimal getMarkUpPercentage() {
		return markUpPercentage;
	}
	public void setMarkUpPercentage(BigDecimal markUpPercentage) {
		this.markUpPercentage = markUpPercentage;
	}
	public BigDecimal getTotalDealsValue() {
		return totalDealsValue;
	}
	public void setTotalDealsValue(BigDecimal totalDealsValue) {
		this.totalDealsValue = totalDealsValue;
	}
	public BigDecimal getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Date getInstallmentDate() {
		return installmentDate;
	}
	public void setInstallmentDate(Date installmentDate) {
		this.installmentDate = installmentDate;
	}
	public Date getRunningDate() {
		return runningDate;
	}
	public void setRunningDate(Date runningDate) {
		this.runningDate = runningDate;
	}
	public String getTangibleAsset() {
		return tangibleAsset;
	}
	public void setTangibleAsset(String tangibleAsset) {
		this.tangibleAsset = tangibleAsset;
	}
	public BigDecimal getDealCurrency() {
		return dealCurrency;
	}
	public void setDealCurrency(BigDecimal dealCurrency) {
		this.dealCurrency = dealCurrency;
	}
	public BigDecimal getCifNo() {
		return cifNo;
	}
	public void setCifNo(BigDecimal cifNo) {
		this.cifNo = cifNo;
	}

    public String getCountryDesc()
    {
	return countryDesc;
    }

    public void setCountryDesc(String countryDesc)
    {
	this.countryDesc = countryDesc;
    }
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	

}
