package com.path.vo.common;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;

public class AmountCO  extends BaseSC{
	
	 private BigDecimal baseCurrency;
	 private BigDecimal currencyAccount;
	 private BigDecimal currencyDecimalPoint;
	 private BigDecimal middleExchaRate;
	 private BigDecimal cvAmount;
	 private BigDecimal fcAmount;
	 private BigDecimal currencyUnit;
	 private String currencyMultipDivide;
	 private BigDecimal currencyDecimalPoints;
	 private String exchType; // C if wanted Cash else null if wanted from Control record
	 private String sellBuySign; // the Rate is Sell(S) or Buy (B) or null for mid rate
	

	public BigDecimal getCurrencyDecimalPoint() {
		return currencyDecimalPoint;
	}
	public void setCurrencyDecimalPoint(BigDecimal currencyDecimalPoint) {
		this.currencyDecimalPoint = currencyDecimalPoint;
	}
	public BigDecimal getMiddleExchaRate() {
		return middleExchaRate;
	}
	public void setMiddleExchaRate(BigDecimal middleExchaRate) {
		this.middleExchaRate = middleExchaRate;
	}
	public BigDecimal getCvAmount() {
		return cvAmount;
	}
	public void setCvAmount(BigDecimal cvAmount) {
		this.cvAmount = cvAmount;
	}
	public BigDecimal getFcAmount() {
		return fcAmount;
	}
	public void setFcAmount(BigDecimal fcAmount) {
		this.fcAmount = fcAmount;
	}
	public BigDecimal getCurrencyUnit() {
		return currencyUnit;
	}
	public void setCurrencyUnit(BigDecimal currencyUnit) {
		this.currencyUnit = currencyUnit;
	}
	public BigDecimal getCurrencyAccount() {
		return currencyAccount;
	}
	public void setCurrencyAccount(BigDecimal currencyAccount) {
		this.currencyAccount = currencyAccount;
	}
	public String getCurrencyMultipDivide() {
		return currencyMultipDivide;
	}
	public void setCurrencyMultipDivide(String currencyMultipDivide) {
		this.currencyMultipDivide = currencyMultipDivide;
	}
	public BigDecimal getCurrencyDecimalPoints() {
		return currencyDecimalPoints;
	}
	public void setCurrencyDecimalPoints(BigDecimal currencyDecimalPoints) {
		this.currencyDecimalPoints = currencyDecimalPoints;
	}
	public BigDecimal getBaseCurrency()
	{
	    return baseCurrency;
	}
	public void setBaseCurrency(BigDecimal baseCurrency)
	{
	    this.baseCurrency = baseCurrency;
	}
    /**
     * @return the exchType
     */
    public String getExchType()
    {
        return exchType;
    }
    /**
     * @param exchType the exchType to set
     */
    public void setExchType(String exchType)
    {
        this.exchType = exchType;
    }
    /**
     * @return the sellBuySign
     */
    public String getSellBuySign()
    {
        return sellBuySign;
    }
    /**
     * @param sellBuySign the sellBuySign to set
     */
    public void setSellBuySign(String sellBuySign)
    {
        this.sellBuySign = sellBuySign;
    }
	

}
