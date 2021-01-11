/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * AssetsAndLiabCO.java used to
 */
public class AssetsAndLiabCO extends RetailBaseVO
{
    private BigDecimal categoryId;
    private String     category;
    private BigDecimal totalNbrAcc;
    private BigDecimal currentBalance;
    private BigDecimal availableBalance;
    private BigDecimal blockedAmount;
    private BigDecimal overdrawLimit;
    private BigDecimal decimal_points;
    private BigDecimal duesAssetLiablAmt;

    /**
     * @return the categoryId
     */
    public BigDecimal getCategoryId()
    {
        return categoryId;
    }
    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(BigDecimal categoryId)
    {
        this.categoryId = categoryId;
    }
    /**
     * @return the category
     */
    public String getCategory()
    {
        return category;
    }
    /**
     * @param category the category to set
     */
    public void setCategory(String category)
    {
        this.category = category;
    }
    /**
     * @return the totalNbrAcc
     */
    public BigDecimal getTotalNbrAcc()
    {
        return totalNbrAcc;
    }
    /**
     * @param totalNbrAcc the totalNbrAcc to set
     */
    public void setTotalNbrAcc(BigDecimal totalNbrAcc)
    {
        this.totalNbrAcc = totalNbrAcc;
    }

    /**
     * @return the overdrawLimit
     */
    public BigDecimal getOverdrawLimit()
    {
        return overdrawLimit;
    }
    /**
     * @param overdrawLimit the overdrawLimit to set
     */
    public void setOverdrawLimit(BigDecimal overdrawLimit)
    {
        this.overdrawLimit = overdrawLimit;
    }

    /**
     * @return the decimal_points
     */
    public BigDecimal getDecimal_points()
    {
        return decimal_points;
    }
    /**
     * @param decimalPoints the decimal_points to set
     */
    public void setDecimal_points(BigDecimal decimalPoints)
    {
        decimal_points = decimalPoints;
    }
    /**
     * @return the currentBalance
     */
    public BigDecimal getCurrentBalance()
    {
        return currentBalance;
    }
    /**
     * @param currentBalance the currentBalance to set
     */
    public void setCurrentBalance(BigDecimal currentBalance)
    {
        this.currentBalance = currentBalance;
    }
    /**
     * @return the availableBalance
     */
    public BigDecimal getAvailableBalance()
    {
        return availableBalance;
    }
    /**
     * @param availableBalance the availableBalance to set
     */
    public void setAvailableBalance(BigDecimal availableBalance)
    {
        this.availableBalance = availableBalance;
    }
    /**
     * @return the blockedAmount
     */
    public BigDecimal getBlockedAmount()
    {
        return blockedAmount;
    }
    /**
     * @param blockedAmount the blockedAmount to set
     */
    public void setBlockedAmount(BigDecimal blockedAmount)
    {
        this.blockedAmount = blockedAmount;
    }
    public BigDecimal getDuesAssetLiablAmt()
    {
        return duesAssetLiablAmt;
    }
    public void setDuesAssetLiablAmt(BigDecimal duesAssetLiablAmt)
    {
        this.duesAssetLiablAmt = duesAssetLiablAmt;
    }
 
  

}
