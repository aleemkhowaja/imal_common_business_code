package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.common.reportresponse.ReportResponseCO;

@SuppressWarnings("serial")
public class FinancingDealsSC extends GridParamsSC{
	
	private Integer cifNo;
	private String  branchFilter;
	private Integer dealCurrency;
	private String dealType;
    // report Printing
    private List<ReportResponseCO> reportResponseCOList;
	private Integer dealNo;
	private String status;
	private BigDecimal planNbr;
	private BigDecimal planSeq;
	private Integer prodClassCode;
	
	private String category;
	private String appName;
	
	private BigDecimal baseCurrDecPoints;
	private BigDecimal code;
	
    private Date rateRevDate;
    // DBU191081 Muhammed Anas Start
    private String outstandingDealsFlag;
    private BigDecimal lovType;
    private String langCode;
    // DBU191081 Muhammed Anas 

    public BigDecimal getBaseCurrDecPoints()
    {
		return baseCurrDecPoints;
	}

	public void setBaseCurrDecPoints(BigDecimal baseCurrDecPoints) {
		this.baseCurrDecPoints = baseCurrDecPoints;
	}

	public BigDecimal getPlanNbr() {
		return planNbr;
	}

	public void setPlanNbr(BigDecimal planNbr) {
		this.planNbr = planNbr;
	}

	public BigDecimal getPlanSeq() {
		return planSeq;
	}

	public void setPlanSeq(BigDecimal planSeq) {
		this.planSeq = planSeq;
	}

	 

	public String getBranchFilter() {
		return branchFilter;
	}

	public void setBranchFilter(String branchFilter) {
		this.branchFilter = branchFilter;
	}

	public Integer getCifNo() {
		return cifNo;
	}

	public void setCifNo(Integer cifNo) {
		this.cifNo = cifNo;
	}

	public void setDealCurrency(Integer dealCurrency) {
		this.dealCurrency = dealCurrency;
	}

	public Integer getDealCurrency() {
		return dealCurrency;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getDealType() {
		return dealType;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setDealNo(Integer dealNo) {
		this.dealNo = dealNo;
	}

	public Integer getDealNo() {
		return dealNo;
	}

	public void setProdClassCode(Integer prodClassCode) {
		this.prodClassCode = prodClassCode;
	}

	public Integer getProdClassCode() {
		return prodClassCode;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppName() {
		return appName;
	}

	/**
	 * @return the code
	 */
	public BigDecimal getCode()
	{
	    return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(BigDecimal code)
	{
	    this.code = code;
	}

    public List<ReportResponseCO> getReportResponseCOList()
    {
	return reportResponseCOList;
    }

    public void setReportResponseCOList(List<ReportResponseCO> reportResponseCOList)
    {
	this.reportResponseCOList = reportResponseCOList;
    }

    public Date getRateRevDate()
    {
	return rateRevDate;
    }

    public void setRateRevDate(Date rateRevDate)
    {
	this.rateRevDate = rateRevDate;
    }
    
    public String getOutstandingDealsFlag() {
	return outstandingDealsFlag;
    }

    public void setOutstandingDealsFlag(String outstandingDealsFlag) {
    	this.outstandingDealsFlag = outstandingDealsFlag;
    }
    
    public BigDecimal getLovType() {
    	return lovType;
    }
    
    public void setLovType(BigDecimal lovType) {
    	this.lovType = lovType;
    }
    
    public String getLangCode() {
    	return langCode;
    }
    
    public void setLangCode(String langCode) {
    	this.langCode = langCode;
    }

 
}
