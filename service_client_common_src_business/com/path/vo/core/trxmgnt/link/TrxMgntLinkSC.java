/**
 * 
 */
package com.path.vo.core.trxmgnt.link;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: MarwanMaddah
 *
 * TrxMgntLinkSC.java used to
 */
public class TrxMgntLinkSC extends GridParamsSC
{
   private BigDecimal accCy;
   private BigDecimal accGl;
   private BigDecimal accCif;
   private BigDecimal accSl;
/**
 * @return the accCy
 */
public BigDecimal getAccCy()
{
    return accCy;
}
/**
 * @param accCy the accCy to set
 */
public void setAccCy(BigDecimal accCy)
{
    this.accCy = accCy;
}
/**
 * @return the accGl
 */
public BigDecimal getAccGl()
{
    return accGl;
}
/**
 * @param accGl the accGl to set
 */
public void setAccGl(BigDecimal accGl)
{
    this.accGl = accGl;
}
/**
 * @return the accCif
 */
public BigDecimal getAccCif()
{
    return accCif;
}
/**
 * @param accCif the accCif to set
 */
public void setAccCif(BigDecimal accCif)
{
    this.accCif = accCif;
}
/**
 * @return the accSl
 */
public BigDecimal getAccSl()
{
    return accSl;
}
/**
 * @param accSl the accSl to set
 */
public void setAccSl(BigDecimal accSl)
{
    this.accSl = accSl;
}

}
