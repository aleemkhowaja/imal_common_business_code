/**
 * 
 */
package com.path.vo.core.ctstrsowing;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * CtsTrsOwingSC.java used to
 */
public class CtstrsOwingSC extends GridParamsSC
{
  private BigDecimal trsNo;

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
