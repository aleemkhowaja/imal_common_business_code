package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.vo.core.common.RetailBaseVO;

public class FinancingDealStatusCriteriaCO  extends RetailBaseVO{
	
	
	private BigDecimal dealType;
	private Date maturityDate;
	private String status;
	private Integer matRecInsNbr;
	private Integer matPaymentInsNbr;
	private BigDecimal activeSettlementCount;
	private BigDecimal apprSettlmentAmt;
	private BigDecimal overdueAmt;
	private BigDecimal settledAmtBeforeSwitching;
	private BigDecimal reimbursedProfit;
	private BigDecimal totalAmt;
	private BigDecimal totalAmtPaid;
	
	public BigDecimal getDealType() {
		return dealType;
	}
	public void setDealType(BigDecimal dealType) {
		this.dealType = dealType;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
 
	public BigDecimal getActiveSettlementCount() {
		return activeSettlementCount;
	}
	public void setActiveSettlementCount(BigDecimal activeSettlementCount) {
		this.activeSettlementCount = activeSettlementCount;
	}
	public BigDecimal getApprSettlmentAmt() {
		return apprSettlmentAmt;
	}
	public void setApprSettlmentAmt(BigDecimal apprSettlmentAmt) {
		this.apprSettlmentAmt = apprSettlmentAmt;
	}
	public BigDecimal getOverdueAmt() {
		return overdueAmt;
	}
	public void setOverdueAmt(BigDecimal overdueAmt) {
		this.overdueAmt = overdueAmt;
	}
	public BigDecimal getSettledAmtBeforeSwitching() {
		return settledAmtBeforeSwitching;
	}
	public void setSettledAmtBeforeSwitching(BigDecimal settledAmtBeforeSwitching) {
		this.settledAmtBeforeSwitching = settledAmtBeforeSwitching;
	}
	public BigDecimal getReimbursedProfit() {
		return reimbursedProfit;
	}
	public void setReimbursedProfit(BigDecimal reimbursedProfit) {
		this.reimbursedProfit = reimbursedProfit;
	}
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}
	public BigDecimal getTotalAmtPaid() {
		return totalAmtPaid;
	}
	public void setTotalAmtPaid(BigDecimal totalAmtPaid) {
		this.totalAmtPaid = totalAmtPaid;
	}
	public Integer getMatRecInsNbr() {
		return matRecInsNbr;
	}
	public void setMatRecInsNbr(Integer matRecInsNbr) {
		this.matRecInsNbr = matRecInsNbr;
	}
	public Integer getMatPaymentInsNbr() {
		return matPaymentInsNbr;
	}
	public void setMatPaymentInsNbr(Integer matPaymentInsNbr) {
		this.matPaymentInsNbr = matPaymentInsNbr;
	}
	
	

}
