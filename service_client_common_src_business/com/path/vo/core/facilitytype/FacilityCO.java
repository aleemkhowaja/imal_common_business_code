/**
 * 
 */
package com.path.vo.core.facilitytype;

import java.math.BigDecimal;

import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          FacilityCO.java used to
 */
public class FacilityCO extends RetailBaseVO
{
    private BigDecimal CODE;
    private BigDecimal branch;
    private BigDecimal fromApplication;
    private BigDecimal facilityValue;
    private BigDecimal drwdwnAmount;
    private BigDecimal currency;
    private BigDecimal cif;
    private String facilityType;
    private String revolvingOneOff;
    private String status;
    private String shortNameEng;
    private String SHORT_NAME_ENG;
    private String briefDescEng;
    private String LONG_NAME_ENG;

    /**
     * @return the cODE
     */
    public BigDecimal getCODE()
    {
	return CODE;
    }

    /**
     * @param cODE the cODE to set
     */
    public void setCODE(BigDecimal cODE)
    {
	CODE = cODE;
    }

    /**
     * @return the sHORT_NAME_ENG
     */
    public String getSHORT_NAME_ENG()
    {
	return SHORT_NAME_ENG;
    }

    /**
     * @param sHORTNAMEENG the sHORT_NAME_ENG to set
     */
    public void setSHORT_NAME_ENG(String sHORTNAMEENG)
    {
	SHORT_NAME_ENG = sHORTNAMEENG;
    }

    /**
     * @return the lONG_NAME_ENG
     */
    public String getLONG_NAME_ENG()
    {
	return LONG_NAME_ENG;
    }

    /**
     * @param lONGNAMEENG the lONG_NAME_ENG to set
     */
    public void setLONG_NAME_ENG(String lONGNAMEENG)
    {
	LONG_NAME_ENG = lONGNAMEENG;
    }

    public BigDecimal getBranch()
    {
	return branch;
    }

    public void setBranch(BigDecimal branch)
    {
	this.branch = branch;
    }

    public BigDecimal getFromApplication()
    {
	return fromApplication;
    }

    public void setFromApplication(BigDecimal fromApplication)
    {
	this.fromApplication = fromApplication;
    }

    public BigDecimal getFacilityValue()
    {
	return facilityValue;
    }

    public void setFacilityValue(BigDecimal facilityValue)
    {
	this.facilityValue = facilityValue;
    }

    public BigDecimal getDrwdwnAmount()
    {
	return drwdwnAmount;
    }

    public void setDrwdwnAmount(BigDecimal drwdwnAmount)
    {
	this.drwdwnAmount = drwdwnAmount;
    }

    public BigDecimal getCurrency()
    {
	return currency;
    }

    public void setCurrency(BigDecimal currency)
    {
	this.currency = currency;
    }

    public String getRevolvingOneOff()
    {
	return revolvingOneOff;
    }

    public void setRevolvingOneOff(String revolvingOneOff)
    {
	this.revolvingOneOff = revolvingOneOff;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getShortNameEng()
    {
	return shortNameEng;
    }

    public void setShortNameEng(String shortNameEng)
    {
	this.shortNameEng = shortNameEng;
    }

    public String getBriefDescEng()
    {
	return briefDescEng;
    }

    public void setBriefDescEng(String briefDescEng)
    {
	this.briefDescEng = briefDescEng;
    }

    public void setCif(BigDecimal cif)
    {
	this.cif = cif;
    }

    public BigDecimal getCif()
    {
	return cif;
    }

    /**
     * @return the facilityType
     */
    public String getFacilityType()
    {
        return facilityType;
    }

    /**
     * @param facilityType the facilityType to set
     */
    public void setFacilityType(String facilityType)
    {
        this.facilityType = facilityType;
    }

}
