/**
 * 
 */
package com.path.vo.core.trxmgnt.outstandingprofit;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * TrxMgntOutstdProfitSC.java used to
 */
public class TrxMgntOutstdProfitSC extends GridParamsSC
{
  private String     trsType;
  private String     cbInd;
  private BigDecimal trsNo;
  private String     statusCode;
  
/**
 * @return the cbInd
 */
public String getCbInd()
{
    return cbInd;
}
/**
 * @param cbInd the cbInd to set
 */
public void setCbInd(String cbInd)
{
    this.cbInd = cbInd;
}
/**
 * @return the statusCode
 */
public String getStatusCode()
{
    return statusCode;
}
/**
 * @param statusCode the statusCode to set
 */
public void setStatusCode(String statusCode)
{
    this.statusCode = statusCode;
}
/**
 * @return the trsType
 */
public String getTrsType()
{
    return trsType;
}
/**
 * @param trsType the trsType to set
 */
public void setTrsType(String trsType)
{
    this.trsType = trsType;
}
/**
 * @return the trsNo
 */
public BigDecimal getTrsNo()
{
    return trsNo;
}
/**
 * @param trsNo the trsNo to set
 */
public void setTrsNo(BigDecimal trsNo)
{
    this.trsNo = trsNo;
}
}
