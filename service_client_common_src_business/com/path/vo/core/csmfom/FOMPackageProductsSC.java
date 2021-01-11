package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

public class FOMPackageProductsSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal compCodeCif;
    private BigDecimal cifType;
    private BigDecimal packageCode;
    private String prodType;
    private BigDecimal lineNo;
    private String accAddRef;
    private Date expiryDate;
    private BigDecimal gracePeriod;
    private String selectedLine;
    private Date firstPaymentDate;
    private Date nextDateCharge;
    private String alreadyTaken;
    private Boolean alreadyLoaded;
    private BigDecimal currencyCode;
    
    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setPackageCode(BigDecimal packageCode)
    {
	this.packageCode = packageCode;
    }

    public BigDecimal getPackageCode()
    {
	return packageCode;
    }

    public void setProdType(String prodType)
    {
	this.prodType = prodType;
    }

    public String getProdType()
    {
	return prodType;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setAccAddRef(String accAddRef)
    {
	this.accAddRef = accAddRef;
    }

    public String getAccAddRef()
    {
	return accAddRef;
    }

    public void setExpiryDate(Date expiryDate)
    {
	this.expiryDate = expiryDate;
    }

    public Date getExpiryDate()
    {
	return expiryDate;
    }

    public void setGracePeriod(BigDecimal gracePeriod)
    {
	this.gracePeriod = gracePeriod;
    }

    public BigDecimal getGracePeriod()
    {
	return gracePeriod;
    }

    public void setSelectedLine(String selectedLine)
    {
	this.selectedLine = selectedLine;
    }

    public String getSelectedLine()
    {
	return selectedLine;
    }

    public void setFirstPaymentDate(Date firstPaymentDate)
    {
	this.firstPaymentDate = firstPaymentDate;
    }

    public Date getFirstPaymentDate()
    {
	return firstPaymentDate;
    }

    public void setNextDateCharge(Date nextDateCharge)
    {
	this.nextDateCharge = nextDateCharge;
    }

    public Date getNextDateCharge()
    {
	return nextDateCharge;
    }

    public void setAlreadyTaken(String alreadyTaken)
    {
	this.alreadyTaken = alreadyTaken;
    }

    public String getAlreadyTaken()
    {
	return alreadyTaken;
    }

    public void setAlreadyLoaded(Boolean alreadyLoaded)
    {
	this.alreadyLoaded = alreadyLoaded;
    }

    public Boolean getAlreadyLoaded()
    {
	return alreadyLoaded;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }
}
