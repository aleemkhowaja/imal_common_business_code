package com.path.vo.core.cardsmanagement;

import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.el.lang.ELArithmetic.BigIntegerDelegate;

import com.path.dbmaps.vo.CTSCARDS_COLLATERALSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

public class CardsCollateralsCO extends RetailBaseVO
{
    private CTSCARDS_COLLATERALSVO ctsCardsCollateralsVO;
    private String collateralName;
    private BigDecimal collateralType;
    private BigDecimal collateralAllocatedAmount;
    private String amountType;
    private BigDecimal fixedAmount;
    private String collateralUpdates;
    private BigDecimal facilitySubLimit;
    private BigDecimal facilityCode;
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    

    public CTSCARDS_COLLATERALSVO getCtsCardsCollateralsVO()
    {
        return ctsCardsCollateralsVO;
    }

    public void setCtsCardsCollateralsVO(CTSCARDS_COLLATERALSVO ctsCardsCollateralsVO)
    {
        this.ctsCardsCollateralsVO = ctsCardsCollateralsVO;
    }

    public String getCollateralName()
    {
        return collateralName;
    }

    public void setCollateralName(String collateralName)
    {
        this.collateralName = collateralName;
    }

    public BigDecimal getCollateralType()
    {
        return collateralType;
    }

    public void setCollateralType(BigDecimal collateralType)
    {
        this.collateralType = collateralType;
    }

    public BigDecimal getCollateralAllocatedAmount()
    {
        return collateralAllocatedAmount;
    }

    public void setCollateralAllocatedAmount(BigDecimal collateralAllocatedAmount)
    {
        this.collateralAllocatedAmount = collateralAllocatedAmount;
    }

    public String getAmountType()
    {
        return amountType;
    }

    public void setAmountType(String amountType)
    {
        this.amountType = amountType;
    }

    public BigDecimal getFixedAmount()
    {
        return fixedAmount;
    }

    public void setFixedAmount(BigDecimal fixedAmount)
    {
        this.fixedAmount = fixedAmount;
    }

    public String getCollateralUpdates()
    {
        return collateralUpdates;
    }

    public void setCollateralUpdates(String collateralUpdates)
    {
        this.collateralUpdates = collateralUpdates;
    }

    public BigDecimal getFacilitySubLimit()
    {
        return facilitySubLimit;
    }

    public void setFacilitySubLimit(BigDecimal facilitySubLimit)
    {
        this.facilitySubLimit = facilitySubLimit;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }

    public BigDecimal getFacilityCode()
    {
        return facilityCode;
    }

    public void setFacilityCode(BigDecimal facilityCode)
    {
        this.facilityCode = facilityCode;
    }
}