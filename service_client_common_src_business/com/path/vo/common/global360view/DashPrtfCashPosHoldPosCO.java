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
 * DashPrtfCashPosHoldPosCO.java used to
 */
public class DashPrtfCashPosHoldPosCO extends RetailBaseVO 
{
  /**
   * Data Form   
   */
  private String     portfolioNo;
  private String     portfolioName;
  private BigDecimal totalUnrealizedGainLoss;
  private BigDecimal totalRealizedGainLoss;
  private BigDecimal unrealizedCyGainLoss;
  private BigDecimal totalAssets;
  
  /**
   * For Formatting management
   */
  private String     totalUnrealizedGainLossFrmtd;
  private String     totalRealizedGainLossFrmtd;
  private String     unrealizedCyGainLossFrmtd;
  private String     totalAssetsFrmtd;
  
  private BigDecimal all_securities;
  private BigDecimal holdingBySecurity;
  
  /**
   * for Formatting Management
   */
  private BigDecimal decimal_points;
  
  /**
   * Cash position Grid  
   */
  private String     account_type;
  private String     currency;
  private BigDecimal value_trade_cy;
  private BigDecimal value_base_cy;
  
  /**
   * Holding Position Grid
   */
  private String     security_type;
  private String     cyDesc;
  private BigDecimal book_value;
  private BigDecimal market_value;
  private BigDecimal market_value_base_cy;
  private String     securityName;
  private BigDecimal acc_cy;
  private BigDecimal acc_gl;
  private BigDecimal secType;
  private BigDecimal tradeCy;

/**
 * @return the account_type
 */
public String getAccount_type()
{
    return account_type;
}
/**
 * @param accountType the account_type to set
 */
public void setAccount_type(String accountType)
{
    account_type = accountType;
}
/**
 * @return the currency
 */
public String getCurrency()
{
    return currency;
}
/**
 * @param currency the currency to set
 */
public void setCurrency(String currency)
{
    this.currency = currency;
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
 * @return the value_trade_cy
 */
public BigDecimal getValue_trade_cy()
{
    return value_trade_cy;
}
/**
 * @param valueTradeCy the value_trade_cy to set
 */
public void setValue_trade_cy(BigDecimal valueTradeCy)
{
    value_trade_cy = valueTradeCy;
}
/**
 * @return the value_base_cy
 */
public BigDecimal getValue_base_cy()
{
    return value_base_cy;
}
/**
 * @param valueBaseCy the value_base_cy to set
 */
public void setValue_base_cy(BigDecimal valueBaseCy)
{
    value_base_cy = valueBaseCy;
}
/**
 * @return the security_type
 */
public String getSecurity_type()
{
    return security_type;
}
/**
 * @param securityType the security_type to set
 */
public void setSecurity_type(String securityType)
{
    security_type = securityType;
}
/**
 * @return the cyDesc
 */
public String getCyDesc()
{
    return cyDesc;
}
/**
 * @param cyDesc the cyDesc to set
 */
public void setCyDesc(String cyDesc)
{
    this.cyDesc = cyDesc;
}
/**
 * @return the book_value
 */
public BigDecimal getBook_value()
{
    return book_value;
}
/**
 * @param bookValue the book_value to set
 */
public void setBook_value(BigDecimal bookValue)
{
    book_value = bookValue;
}
/**
 * @return the market_value
 */
public BigDecimal getMarket_value()
{
    return market_value;
}
/**
 * @param marketValue the market_value to set
 */
public void setMarket_value(BigDecimal marketValue)
{
    market_value = marketValue;
}
/**
 * @return the market_value_base_cy
 */
public BigDecimal getMarket_value_base_cy()
{
    return market_value_base_cy;
}
/**
 * @param marketValueBaseCy the market_value_base_cy to set
 */
public void setMarket_value_base_cy(BigDecimal marketValueBaseCy)
{
    market_value_base_cy = marketValueBaseCy;
}
/**
 * @return the portfolioName
 */
public String getPortfolioName()
{
    return portfolioName;
}
/**
 * @param portfolioName the portfolioName to set
 */
public void setPortfolioName(String portfolioName)
{
    this.portfolioName = portfolioName;
}
/**
 * @return the totalUnrealizedGainLoss
 */
public BigDecimal getTotalUnrealizedGainLoss()
{
    return totalUnrealizedGainLoss;
}
/**
 * @param totalUnrealizedGainLoss the totalUnrealizedGainLoss to set
 */
public void setTotalUnrealizedGainLoss(BigDecimal totalUnrealizedGainLoss)
{
    this.totalUnrealizedGainLoss = totalUnrealizedGainLoss;
}
/**
 * @return the totalRealizedGainLoss
 */
public BigDecimal getTotalRealizedGainLoss()
{
    return totalRealizedGainLoss;
}
/**
 * @param totalRealizedGainLoss the totalRealizedGainLoss to set
 */
public void setTotalRealizedGainLoss(BigDecimal totalRealizedGainLoss)
{
    this.totalRealizedGainLoss = totalRealizedGainLoss;
}
/**
 * @return the unrealizedCyGainLoss
 */
public BigDecimal getUnrealizedCyGainLoss()
{
    return unrealizedCyGainLoss;
}
/**
 * @param unrealizedCyGainLoss the unrealizedCyGainLoss to set
 */
public void setUnrealizedCyGainLoss(BigDecimal unrealizedCyGainLoss)
{
    this.unrealizedCyGainLoss = unrealizedCyGainLoss;
}
/**
 * @return the totalAssets
 */
public BigDecimal getTotalAssets()
{
    return totalAssets;
}
/**
 * @param totalAssets the totalAssets to set
 */
public void setTotalAssets(BigDecimal totalAssets)
{
    this.totalAssets = totalAssets;
}
/**
 * @return the all_securities
 */
public BigDecimal getAll_securities()
{
    return all_securities;
}
/**
 * @param allSecurities the all_securities to set
 */
public void setAll_securities(BigDecimal allSecurities)
{
    all_securities = allSecurities;
}
/**
 * @return the holdingBySecurity
 */
public BigDecimal getHoldingBySecurity()
{
    return holdingBySecurity;
}
/**
 * @param holdingBySecurity the holdingBySecurity to set
 */
public void setHoldingBySecurity(BigDecimal holdingBySecurity)
{
    this.holdingBySecurity = holdingBySecurity;
}
/**
 * @return the portfolioNo
 */
public String getPortfolioNo()
{
    return portfolioNo;
}
/**
 * @param portfolioNo the portfolioNo to set
 */
public void setPortfolioNo(String portfolioNo)
{
    this.portfolioNo = portfolioNo;
}
/**
 * @return the totalUnrealizedGainLossFrmtd
 */
public String getTotalUnrealizedGainLossFrmtd()
{
    return totalUnrealizedGainLossFrmtd;
}
/**
 * @param totalUnrealizedGainLossFrmtd the totalUnrealizedGainLossFrmtd to set
 */
public void setTotalUnrealizedGainLossFrmtd(String totalUnrealizedGainLossFrmtd)
{
    this.totalUnrealizedGainLossFrmtd = totalUnrealizedGainLossFrmtd;
}
/**
 * @return the totalRealizedGainLossFrmtd
 */
public String getTotalRealizedGainLossFrmtd()
{
    return totalRealizedGainLossFrmtd;
}
/**
 * @param totalRealizedGainLossFrmtd the totalRealizedGainLossFrmtd to set
 */
public void setTotalRealizedGainLossFrmtd(String totalRealizedGainLossFrmtd)
{
    this.totalRealizedGainLossFrmtd = totalRealizedGainLossFrmtd;
}
/**
 * @return the unrealizedCyGainLossFrmtd
 */
public String getUnrealizedCyGainLossFrmtd()
{
    return unrealizedCyGainLossFrmtd;
}
/**
 * @param unrealizedCyGainLossFrmtd the unrealizedCyGainLossFrmtd to set
 */
public void setUnrealizedCyGainLossFrmtd(String unrealizedCyGainLossFrmtd)
{
    this.unrealizedCyGainLossFrmtd = unrealizedCyGainLossFrmtd;
}
/**
 * @return the totalAssetsFrmtd
 */
public String getTotalAssetsFrmtd()
{
    return totalAssetsFrmtd;
}
/**
 * @param totalAssetsFrmtd the totalAssetsFrmtd to set
 */
public void setTotalAssetsFrmtd(String totalAssetsFrmtd)
{
    this.totalAssetsFrmtd = totalAssetsFrmtd;
}
public String getSecurityName()
{
    return securityName;
}
public void setSecurityName(String securityName)
{
    this.securityName = securityName;
}
/**
 * @return the acc_cy
 */
public BigDecimal getAcc_cy()
{
    return acc_cy;
}
/**
 * @param accCy the acc_cy to set
 */
public void setAcc_cy(BigDecimal accCy)
{
    acc_cy = accCy;
}
/**
 * @return the acc_gl
 */
public BigDecimal getAcc_gl()
{
    return acc_gl;
}
/**
 * @param accGl the acc_gl to set
 */
public void setAcc_gl(BigDecimal accGl)
{
    acc_gl = accGl;
}
/**
 * @return the secType
 */
public BigDecimal getSecType()
{
    return secType;
}
/**
 * @param secType the secType to set
 */
public void setSecType(BigDecimal secType)
{
    this.secType = secType;
}
/**
 * @return the tradeCy
 */
public BigDecimal getTradeCy()
{
    return tradeCy;
}
/**
 * @param tradeCy the tradeCy to set
 */
public void setTradeCy(BigDecimal tradeCy)
{
    this.tradeCy = tradeCy;
}
}
