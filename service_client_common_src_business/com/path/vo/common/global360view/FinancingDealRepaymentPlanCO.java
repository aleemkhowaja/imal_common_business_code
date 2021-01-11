package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.TRSPAYPLANDETVO;
import com.path.dbmaps.vo.TRSPAYPLANVO;
import com.path.vo.core.common.RetailBaseVO;

@SuppressWarnings("serial")
public class FinancingDealRepaymentPlanCO extends RetailBaseVO
{
    private TRSPAYPLANVO trsPayPlanVO;
    private TRSPAYPLANDETVO trsPayPlanDetVO;

    private String currBriefDescEng;
    private BigDecimal currDecimalPoints;

    private BigDecimal activeSettlementAmt;
    private BigDecimal approvedSettlement;

    private String paymentType;
    private BigDecimal amount;
    private BigDecimal profitAmt;
    private Date dateSettled;
    private BigDecimal settlementAmount;
    private BigDecimal computedActiveSettlementAmt;
    private BigDecimal computedRemainingAmt;
    // private BigDecimal computedReimbursedProfitAmt;
    private BigDecimal computedAmtReceived;
    // private BigDecimal computedReserveAmt;
    private BigDecimal computedIncidentalCost;
    private BigDecimal computedAdvInsurance;
    private BigDecimal computedTotalInstallment;
    private BigDecimal cfIncidentCost;
    private BigDecimal advInsuranceAmt;
    private BigDecimal curPeriodUnsettledAmt;
    private BigDecimal actNoOfpayments;

    private String status;

    private String dealStatus;
    private BigDecimal remainingAmt;

    private String accountName;
    private String coveringAccountName;

    private String upfrontDeal;
    private BigDecimal dealType;
    private String cifName;

    public TRSPAYPLANVO getTrsPayPlanVO()
    {
	return trsPayPlanVO;
    }

    public void setTrsPayPlanVO(TRSPAYPLANVO trsPayPlanVO)
    {
	this.trsPayPlanVO = trsPayPlanVO;
    }

    public TRSPAYPLANDETVO getTrsPayPlanDetVO()
    {
	return trsPayPlanDetVO;
    }

    public void setTrsPayPlanDetVO(TRSPAYPLANDETVO trsPayPlanDetVO)
    {
	this.trsPayPlanDetVO = trsPayPlanDetVO;
    }

    public void setActiveSettlementAmt(BigDecimal activeSettlementAmt)
    {
	this.activeSettlementAmt = activeSettlementAmt;
    }

    public BigDecimal getActiveSettlementAmt()
    {
	return activeSettlementAmt;
    }

    public String getCurrBriefDescEng()
    {
	return currBriefDescEng;
    }

    public void setCurrBriefDescEng(String currBriefDescEng)
    {
	this.currBriefDescEng = currBriefDescEng;
    }

    public String getPaymentType()
    {
	return paymentType;
    }

    public void setPaymentType(String paymentType)
    {
	this.paymentType = paymentType;
    }

    public BigDecimal getAmount()
    {
	return amount == null ? BigDecimal.ZERO : amount;
    }

    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    public BigDecimal getProfitAmt()
    {
	return profitAmt == null ? BigDecimal.ZERO : profitAmt;
    }

    public void setProfitAmt(BigDecimal profitAmt)
    {
	this.profitAmt = profitAmt;
    }

    public Date getDateSettled()
    {
	return dateSettled;
    }

    public void setDateSettled(Date dateSettled)
    {
	this.dateSettled = dateSettled;
    }

    public BigDecimal getSettlementAmount()
    {
	return settlementAmount == null ? BigDecimal.ZERO : settlementAmount;
    }

    public void setSettlementAmount(BigDecimal settlementAmount)
    {
	this.settlementAmount = settlementAmount;
    }

    public BigDecimal getComputedActiveSettlementAmt()
    {
	computedActiveSettlementAmt = getSettlementAmount()
		.subtract((approvedSettlement == null ? BigDecimal.ZERO : approvedSettlement));
	return computedActiveSettlementAmt;
    }

    public void setComputedActiveSettlementAmt(BigDecimal computedActiveSettlementAmt)
    {
	this.computedActiveSettlementAmt = computedActiveSettlementAmt;
    }

    public BigDecimal getComputedRemainingAmt()
    {
	computedRemainingAmt = getAmount().subtract(getSettlementAmount());
	return computedRemainingAmt;
    }

    public void setComputedRemainingAmt(BigDecimal computedRemainingAmt)
    {
	this.computedRemainingAmt = computedRemainingAmt;
    }

    public BigDecimal getComputedAmtReceived()
    {
	computedAmtReceived = getSettlementAmount().add(
		trsPayPlanDetVO.getRESERVE_AMOUNT() == null ? BigDecimal.ZERO : trsPayPlanDetVO.getRESERVE_AMOUNT());
	return computedAmtReceived;
    }

    public void setComputedAmtReceived(BigDecimal computedAmtReceived)
    {
	this.computedAmtReceived = computedAmtReceived;
    }

    public BigDecimal getComputedIncidentalCost()
    {
	return computedIncidentalCost == null ? BigDecimal.ZERO : computedIncidentalCost;
    }

    public void setComputedIncidentalCost(BigDecimal computedIncidentalCost)
    {
	this.computedIncidentalCost = computedIncidentalCost;
    }

    public BigDecimal getComputedAdvInsurance()
    {
	return computedAdvInsurance == null ? BigDecimal.ZERO : computedAdvInsurance;
    }

    public void setComputedAdvInsurance(BigDecimal computedAdvInsurance)
    {
	this.computedAdvInsurance = computedAdvInsurance;
    }

    public BigDecimal getComputedTotalInstallment()
    {
	computedTotalInstallment = getComputedIncidentalCost().add(getComputedAdvInsurance()).add(getAmount());
	return computedTotalInstallment;

    }

    public void setComputedTotalInstallment(BigDecimal computedTotalInstallment)
    {
	this.computedTotalInstallment = computedTotalInstallment;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getStatus()
    {
	return status;
    }

    public void setCurrDecimalPoints(BigDecimal currDecimalPoints)
    {
	this.currDecimalPoints = currDecimalPoints;
    }

    public BigDecimal getCurrDecimalPoints()
    {
	return currDecimalPoints;
    }

    public void setApprovedSettlement(BigDecimal approvedSettlement)
    {
	this.approvedSettlement = approvedSettlement;
    }

    public BigDecimal getCfIncidentCost()
    {
	return cfIncidentCost == null ? BigDecimal.ZERO : cfIncidentCost;
    }

    public void setCfIncidentCost(BigDecimal cfIncidentCost)
    {
	this.cfIncidentCost = cfIncidentCost;
    }

    public BigDecimal getApprovedSettlement()
    {
	return approvedSettlement;
    }

    public BigDecimal getAdvInsuranceAmt()
    {
	return advInsuranceAmt == null ? BigDecimal.ZERO : advInsuranceAmt;
    }

    public void setAdvInsuranceAmt(BigDecimal advInsuranceAmt)
    {
	this.advInsuranceAmt = advInsuranceAmt;
    }

    public void setDealStatus(String dealStatus)
    {
	this.dealStatus = dealStatus;
    }

    public String getDealStatus()
    {
	return dealStatus;
    }

    public BigDecimal getRemainingAmt()
    {
	if(trsPayPlanVO != null)
	{
	    remainingAmt = trsPayPlanVO.getTOTAL_AMT().subtract(
		    (trsPayPlanVO.getTOTAL_AMT_PAID() == null ? BigDecimal.ZERO : trsPayPlanVO.getTOTAL_AMT_PAID())
			    .subtract(activeSettlementAmt == null ? BigDecimal.ZERO : activeSettlementAmt));
	}
	return remainingAmt;

    }

    public void setRemainingAmt(BigDecimal remainingAmt)
    {
	this.remainingAmt = remainingAmt;
    }

    public String getAccountName()
    {
	return accountName;
    }

    public void setAccountName(String accountName)
    {
	this.accountName = accountName;
    }

    public String getCoveringAccountName()
    {
	return coveringAccountName;
    }

    public void setCoveringAccountName(String coveringAccountName)
    {
	this.coveringAccountName = coveringAccountName;
    }

    public BigDecimal getCurPeriodUnsettledAmt()
    {
	return curPeriodUnsettledAmt;
    }

    public void setCurPeriodUnsettledAmt(BigDecimal curPeriodUnsettledAmt)
    {
	this.curPeriodUnsettledAmt = curPeriodUnsettledAmt;
    }

    public BigDecimal getActNoOfpayments()
    {
	return actNoOfpayments;
    }

    public void setActNoOfpayments(BigDecimal actNoOfpayments)
    {
	this.actNoOfpayments = actNoOfpayments;
    }

    public String getUpfrontDeal()
    {
	return upfrontDeal;
    }

    public void setUpfrontDeal(String upfrontDeal)
    {
	this.upfrontDeal = upfrontDeal;
    }

    public BigDecimal getDealType()
    {
	return dealType;
    }

    public void setDealType(BigDecimal dealType)
    {
	this.dealType = dealType;
    }

    public String getCifName()
    {
	return cifName;
    }

    public void setCifName(String cifName)
    {
	this.cifName = cifName;
    }

}
