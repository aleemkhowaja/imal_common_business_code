package com.path.vo.core.facilitytype;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FacilityTypeSC extends GridParamsSC
{
    private String facilityCateg;
    private String crud;
    private BigDecimal cifNo;
    private BigDecimal code;
    private BigDecimal currencyCode;

    // AMANA130105
    private BigDecimal glCode;
    private String odType;
    // AMANA130105
    private BigDecimal lineNbr;
    private BigDecimal FACILITY_CATEG;

    private BigDecimal utilized;
    private BigDecimal paidAmount;
    private BigDecimal utilizedMargin;
    private BigDecimal facilityCode;
    private BigDecimal facilityBr;
    private String settleMethod;

    private BigDecimal statusLovType;
    private BigDecimal facilityTypeLovType;
    private BigDecimal oneOffLovType;
    // Flag 0/1 added in order not to filter by branch (TP# 416218 - STF - Off
    // Takers screen)
    private BigDecimal disableBranchFilter;

    // TP#621590 ;13-Feb-2018;d.james
    private String allTypes;
    private String allTypesFlag;

    // Hala Al Sheikh - ABEI180106
    private String fromCards;

    // TP#SBI170059 Snitha for CSM
    private BigDecimal overdraftType;
    
    //Raed Saad - [#539366 - AMANA130105]
    private BigDecimal accBranch;
    //END Raed Saad - [#539366 - AMANA130105]

    public String getFacilityCateg()
    {
	return facilityCateg;
    }

    public void setFacilityCateg(String facilityCateg)
    {
	this.facilityCateg = facilityCateg;
    }

    /**
     * @return the cifNo
     */
    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    /**
     * @param cifNo the cifNo to set
     */
    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
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

    /**
     * @return the lineNbr
     */
    public BigDecimal getLineNbr()
    {
	return lineNbr;
    }

    /**
     * @param lineNbr the lineNbr to set
     */
    public void setLineNbr(BigDecimal lineNbr)
    {
	this.lineNbr = lineNbr;
    }

    /**
     * @return the crud
     */
    public String getCrud()
    {
	return crud;
    }

    /**
     * @param crud the crud to set
     */
    public void setCrud(String crud)
    {
	this.crud = crud;
    }

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    /**
     * @return the utilized
     */
    public BigDecimal getUtilized()
    {
	return utilized;
    }

    /**
     * @param utilized the utilized to set
     */
    public void setUtilized(BigDecimal utilized)
    {
	this.utilized = utilized;
    }

    /**
     * @return the paidAmount
     */
    public BigDecimal getPaidAmount()
    {
	return paidAmount;
    }

    /**
     * @param paidAmount the paidAmount to set
     */
    public void setPaidAmount(BigDecimal paidAmount)
    {
	this.paidAmount = paidAmount;
    }

    /**
     * @return the utilizedMargin
     */
    public BigDecimal getUtilizedMargin()
    {
	return utilizedMargin;
    }

    /**
     * @param utilizedMargin the utilizedMargin to set
     */
    public void setUtilizedMargin(BigDecimal utilizedMargin)
    {
	this.utilizedMargin = utilizedMargin;
    }

    public BigDecimal getFACILITY_CATEG()
    {
	return FACILITY_CATEG;
    }

    public void setFACILITY_CATEG(BigDecimal fACILITYCATEG)
    {
	FACILITY_CATEG = fACILITYCATEG;
    }

    public void setFacilityCode(BigDecimal facilityCode)
    {
	this.facilityCode = facilityCode;
    }

    public BigDecimal getFacilityCode()
    {
	return facilityCode;
    }

    /**
     * @return the settleMethod
     */
    public String getSettleMethod()
    {
	return settleMethod;
    }

    /**
     * @param settleMethod the settleMethod to set
     */
    public void setSettleMethod(String settleMethod)
    {
	this.settleMethod = settleMethod;
    }

    /**
     * @return the statusLovType
     */
    public BigDecimal getStatusLovType()
    {
	return statusLovType;
    }

    /**
     * @param statusLovType the statusLovType to set
     */
    public void setStatusLovType(BigDecimal statusLovType)
    {
	this.statusLovType = statusLovType;
    }

    /**
     * @return the facilityTypeLovType
     */
    public BigDecimal getFacilityTypeLovType()
    {
	return facilityTypeLovType;
    }

    /**
     * @param facilityTypeLovType the facilityTypeLovType to set
     */
    public void setFacilityTypeLovType(BigDecimal facilityTypeLovType)
    {
	this.facilityTypeLovType = facilityTypeLovType;
    }

    /**
     * @return the oneOffLovType
     */
    public BigDecimal getOneOffLovType()
    {
	return oneOffLovType;
    }

    /**
     * @param oneOffLovType the oneOffLovType to set
     */
    public void setOneOffLovType(BigDecimal oneOffLovType)
    {
	this.oneOffLovType = oneOffLovType;
    }

    /**
     * @return the facilityBr
     */
    public BigDecimal getFacilityBr()
    {
	return facilityBr;
    }

    /**
     * @param facilityBr the facilityBr to set
     */
    public void setFacilityBr(BigDecimal facilityBr)
    {
	this.facilityBr = facilityBr;
    }

    public BigDecimal getGlCode()
    {
	return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    public String getOdType()
    {
	return odType;
    }

    public void setOdType(String odType)
    {
	this.odType = odType;
    }

    public BigDecimal getDisableBranchFilter()
    {
	return disableBranchFilter;
    }

    public void setDisableBranchFilter(BigDecimal disableBranchFilter)
    {
	this.disableBranchFilter = disableBranchFilter;
    }

    public String getAllTypes()
    {
	return allTypes;
    }

    public void setAllTypes(String allTypes)
    {
	this.allTypes = allTypes;
    }

    public String getAllTypesFlag()
    {
	return allTypesFlag;
    }

    public void setAllTypesFlag(String allTypesFlag)
    {
	this.allTypesFlag = allTypesFlag;
    }

    public String getFromCards()
    {
	return fromCards;
    }

    public void setFromCards(String fromCards)
    {
	this.fromCards = fromCards;
    }

    public BigDecimal getOverdraftType()
    {
	return overdraftType;
    }

    public void setOverdraftType(BigDecimal overdraftType)
    {
	this.overdraftType = overdraftType;
    }

    public BigDecimal getAccBranch()
    {
        return accBranch;
    }

    public void setAccBranch(BigDecimal accBranch)
    {
        this.accBranch = accBranch;
    }
}
