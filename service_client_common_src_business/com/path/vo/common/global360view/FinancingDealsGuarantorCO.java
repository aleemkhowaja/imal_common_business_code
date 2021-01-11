package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.dbmaps.vo.TRSDEAL_GUARANTORVO;
import com.path.vo.core.common.RetailBaseVO;

public class FinancingDealsGuarantorCO extends RetailBaseVO {
	
	private TRSDEAL_GUARANTORVO trsDealGuarantorVO;
	private String itemStatus;
	private BigDecimal currDecimalPoints;
	private String guarantorName;
	private String accName;
	
	
	public TRSDEAL_GUARANTORVO getTrsDealGuarantorVO() {
		return trsDealGuarantorVO;
	}
	public void setTrsDealGuarantorVO(TRSDEAL_GUARANTORVO trsDealGuarantorVO) {
		this.trsDealGuarantorVO = trsDealGuarantorVO;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
 
	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
	}
	public String getGuarantorName() {
		return guarantorName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getAccName() {
		return accName;
	}
	public BigDecimal getCurrDecimalPoints() {
		return currDecimalPoints;
	}
	public void setCurrDecimalPoints(BigDecimal currDecimalPoints) {
		this.currDecimalPoints = currDecimalPoints;
	}
	
	
	
	

}
