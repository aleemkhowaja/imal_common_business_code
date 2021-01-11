package com.path.vo.core.productclass;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ProductClassSC extends GridParamsSC
{

    private String appName;
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal productClassCode;
    private BigDecimal categoryCode;
    private String checkUserLimit;
    private String checkParyLimit;
    private BigDecimal cifNo;
    private BigDecimal facilityType;
    private String item;
    private String gradeByCif = "N";
    private BigDecimal appCode;
    private String calledFrom = "A"; // "G": Grading & "A" Application/Facility
    private String windowReference = "";
    private boolean fromLimitScreen;
// TP#621590 ;13-Feb-2018;d.james
    private String allTypes;
    private String allTypesFlag;
    private String allClass;

    // sankar
    private String isRAhnyn = "N";

    private String isBillsCalac = "N";

    // TP#735981;Anas;27/03/2019[start]
    private String conventionalFxFlag;
    private BigDecimal parentCIF;
    // TP #772002 ;Anas; 02/09/2019
    private String calledFromCrossCurrencySwap;
    private String calledFromProfitRateSwap;

    public String getIsRAhnyn()
    {
	return isRAhnyn;
    }

    public void setIsRAhnyn(String isRAhnyn)
    {
	this.isRAhnyn = isRAhnyn;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    @Override
    public BigDecimal getCompCode()
    {
	return compCode;
    }

    @Override
    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    @Override
    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    @Override
    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public BigDecimal getProductClassCode()
    {
	return productClassCode;
    }

    public void setProductClassCode(BigDecimal productClassCode)
    {
	this.productClassCode = productClassCode;
    }

    /**
     * @return the categoryCode
     */
    public BigDecimal getCategoryCode()
    {
	return categoryCode;
    }

    /**
     * @param categoryCode the categoryCode to set
     */
    public void setCategoryCode(BigDecimal categoryCode)
    {
	this.categoryCode = categoryCode;
    }

    /**
     * @return the checkUserLimit
     */
    public String getCheckUserLimit()
    {
	return checkUserLimit;
    }

    /**
     * @param checkUserLimit the checkUserLimit to set
     */
    public void setCheckUserLimit(String checkUserLimit)
    {
	this.checkUserLimit = checkUserLimit;
    }

    /**
     * @return the checkParyLimit
     */
    public String getCheckParyLimit()
    {
	return checkParyLimit;
    }

    /**
     * @param checkParyLimit the checkParyLimit to set
     */
    public void setCheckParyLimit(String checkParyLimit)
    {
	this.checkParyLimit = checkParyLimit;
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
     * @return the facilityType
     */
    public BigDecimal getFacilityType()
    {
	return facilityType;
    }

    /**
     * @param facilityType the facilityType to set
     */
    public void setFacilityType(BigDecimal facilityType)
    {
	this.facilityType = facilityType;
    }

    /**
     * @return the item
     */
    public String getItem()
    {
	return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item)
    {
	this.item = item;
    }

    public void setGradeByCif(String gradeByCif)
    {
	this.gradeByCif = gradeByCif;
    }

    public String getGradeByCif()
    {
	return gradeByCif;
    }

    public void setAppCode(BigDecimal appCode)
    {
	this.appCode = appCode;
    }

    public BigDecimal getAppCode()
    {
	return appCode;
    }

    public void setCalledFrom(String calledFrom)
    {
	this.calledFrom = calledFrom;
    }

    public String getCalledFrom()
    {
	return calledFrom;
    }

    public String getWindowReference()
    {
	return windowReference;
    }

    public void setWindowReference(String windowReference)
    {
	this.windowReference = windowReference;
    }

    public void setFromLimitScreen(boolean fromLimitScreen)
    {
	this.fromLimitScreen = fromLimitScreen;
    }

    public boolean isFromLimitScreen()
    {
	return fromLimitScreen;
    }

    public String getIsBillsCalac()
    {
	return isBillsCalac;
    }

    public void setIsBillsCalac(String isBillsCalac)
    {
	this.isBillsCalac = isBillsCalac;
    }

    public String getAllClass()
    {
	return allClass;
    }

    public void setAllClass(String allClass)
    {
	this.allClass = allClass;
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

    public String getConventionalFxFlag()
    {
	return conventionalFxFlag;
    }

    public void setConventionalFxFlag(String conventionalFxFlag)
    {
	this.conventionalFxFlag = conventionalFxFlag;
    }

    /**
     * @return the parentCIF
     */
    public BigDecimal getParentCIF()
    {
	return parentCIF;
    }

    /**
     * @param parentCIF the parentCIF to set
     */
    public void setParentCIF(BigDecimal parentCIF)
    {
	this.parentCIF = parentCIF;
    }

    public String getCalledFromCrossCurrencySwap()
    {
	return calledFromCrossCurrencySwap;
    }

    public void setCalledFromCrossCurrencySwap(String calledFromCrossCurrencySwap)
    {
	this.calledFromCrossCurrencySwap = calledFromCrossCurrencySwap;
    }

    public String getCalledFromProfitRateSwap()
    {
	return calledFromProfitRateSwap;
    }

    public void setCalledFromProfitRateSwap(String calledFromProfitRateSwap)
    {
	this.calledFromProfitRateSwap = calledFromProfitRateSwap;
    }
}