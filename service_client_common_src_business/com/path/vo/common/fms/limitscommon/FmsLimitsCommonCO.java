package com.path.vo.common.fms.limitscommon;

import com.path.dbmaps.vo.FMSAPPCOLLATERALSVO;
import com.path.dbmaps.vo.FMSAPPLCHARGESVO;
import com.path.dbmaps.vo.FMSAPPLGUARANTVO;
import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Vysakh.das
 * 
 *          FmsLimitsCommonCO.java used to
 */
public class FmsLimitsCommonCO extends BaseVO
{
    private BigDecimal companyCode;
    private BigDecimal branchCode;
    private BigDecimal drawDowncode;
    private BigDecimal facilityCode;
    private BigDecimal facilityApplicationCode;
    private BigDecimal cif;
    private BigDecimal facilityDetailLineNbr;
    private BigDecimal productClass;
    private BigDecimal Currency;
    private BigDecimal availableAmount;
    private Date valueDate;
    private Date maturityDate;
    private Date revolvingExpiryDate;
    private Date effectiveUntil;
    private BigDecimal yield;
    private BigDecimal dealExpected;
    private BigDecimal liborRate;
    private FMSAPPLCHARGESVO fmsApplChargesVO;
    private FMSAPPCOLLATERALSVO fmsApplCollateralVO;
    private FMSAPPLGUARANTVO fmsApplGuarantVO;
    private BigDecimal nostroAccBr;
    private BigDecimal nostroAccGl;
    private BigDecimal nostroAccCif;
    private BigDecimal nostroAccSlno;

    public BigDecimal getCompanyCode()
    {
	return companyCode;
    }

    public void setCompanyCode(BigDecimal companyCode)
    {
	this.companyCode = companyCode;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public BigDecimal getDrawDowncode()
    {
	return drawDowncode;
    }

    public void setDrawDowncode(BigDecimal drawDowncode)
    {
	this.drawDowncode = drawDowncode;
    }

    public BigDecimal getFacilityCode()
    {
	return facilityCode;
    }

    public void setFacilityCode(BigDecimal facilityCode)
    {
	this.facilityCode = facilityCode;
    }

    public BigDecimal getFacilityApplicationCode()
    {
	return facilityApplicationCode;
    }

    public void setFacilityApplicationCode(BigDecimal facilityApplicationCode)
    {
	this.facilityApplicationCode = facilityApplicationCode;
    }

    public BigDecimal getCif()
    {
	return cif;
    }

    public void setCif(BigDecimal cif)
    {
	this.cif = cif;
    }

    public BigDecimal getFacilityDetailLineNbr()
    {
	return facilityDetailLineNbr;
    }

    public void setFacilityDetailLineNbr(BigDecimal facilityDetailLineNbr)
    {
	this.facilityDetailLineNbr = facilityDetailLineNbr;
    }

    public BigDecimal getProductClass()
    {
	return productClass;
    }

    public void setProductClass(BigDecimal productClass)
    {
	this.productClass = productClass;
    }

    public BigDecimal getCurrency()
    {
	return Currency;
    }

    public void setCurrency(BigDecimal currency)
    {
	Currency = currency;
    }

    public BigDecimal getAvailableAmount()
    {
	return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount)
    {
	this.availableAmount = availableAmount;
    }

    public Date getValueDate()
    {
	return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public Date getMaturityDate()
    {
	return maturityDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
	this.maturityDate = maturityDate;
    }

    public Date getRevolvingExpiryDate()
    {
	return revolvingExpiryDate;
    }

    public void setRevolvingExpiryDate(Date revolvingExpiryDate)
    {
	this.revolvingExpiryDate = revolvingExpiryDate;
    }

    public Date getEffectiveUntil()
    {
	return effectiveUntil;
    }

    public void setEffectiveUntil(Date effectiveUntil)
    {
	this.effectiveUntil = effectiveUntil;
    }

    public BigDecimal getYield()
    {
	return yield;
    }

    public void setYield(BigDecimal yield)
    {
	this.yield = yield;
    }

    public BigDecimal getDealExpected()
    {
	return dealExpected;
    }

    public void setDealExpected(BigDecimal dealExpected)
    {
	this.dealExpected = dealExpected;
    }

    public BigDecimal getLiborRate()
    {
	return liborRate;
    }

    public void setLiborRate(BigDecimal liborRate)
    {
	this.liborRate = liborRate;
    }

    public FMSAPPLCHARGESVO getFmsApplChargesVO()
    {
	return fmsApplChargesVO;
    }

    public void setFmsApplChargesVO(FMSAPPLCHARGESVO fmsApplChargesVO)
    {
	this.fmsApplChargesVO = fmsApplChargesVO;
    }

    public FMSAPPCOLLATERALSVO getFmsApplCollateralVO()
    {
	return fmsApplCollateralVO;
    }

    public void setFmsApplCollateralVO(FMSAPPCOLLATERALSVO fmsApplCollateralVO)
    {
	this.fmsApplCollateralVO = fmsApplCollateralVO;
    }

    public FMSAPPLGUARANTVO getFmsApplGuarantVO()
    {
	return fmsApplGuarantVO;
    }

    public void setFmsApplGuarantVO(FMSAPPLGUARANTVO fmsApplGuarantVO)
    {
	this.fmsApplGuarantVO = fmsApplGuarantVO;
    }

    public BigDecimal getNostroAccBr()
    {
	return nostroAccBr;
    }

    public void setNostroAccBr(BigDecimal nostroAccBr)
    {
	this.nostroAccBr = nostroAccBr;
    }

    public BigDecimal getNostroAccGl()
    {
	return nostroAccGl;
    }

    public void setNostroAccGl(BigDecimal nostroAccGl)
    {
	this.nostroAccGl = nostroAccGl;
    }

    public BigDecimal getNostroAccCif()
    {
	return nostroAccCif;
    }

    public void setNostroAccCif(BigDecimal nostroAccCif)
    {
	this.nostroAccCif = nostroAccCif;
    }

    public BigDecimal getNostroAccSlno()
    {
	return nostroAccSlno;
    }

    public void setNostroAccSlno(BigDecimal nostroAccSlno)
    {
	this.nostroAccSlno = nostroAccSlno;
    }

}
