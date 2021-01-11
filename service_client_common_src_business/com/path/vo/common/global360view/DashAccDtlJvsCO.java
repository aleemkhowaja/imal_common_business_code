/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashAccDtlJvsCO.java used to
 */
public class DashAccDtlJvsCO extends RetailBaseVO
{
   private String     acc_num;
   private String     accountName;
   private String     op_no;
   private String     jv_type;
   private String     jv_ref;
   private String     op_status;
   private Date       value_date;
   private Date       trx_date;
   private BigDecimal amount;
   private String     description;
   private String     ac_sign;
   private BigDecimal amount_FORMAT;
   
   private BigDecimal compCode;
   private BigDecimal branchCode;
   private BigDecimal glCode;
   private BigDecimal currencyCode;
   private BigDecimal slNo;
   private String srlNo;
   
/**
 * @return the acc_num
 */
public String getAcc_num()
{
    return acc_num;
}
/**
 * @param accNum the acc_num to set
 */
public void setAcc_num(String accNum)
{
    acc_num = accNum;
}
/**
 * @return the accountName
 */
public String getAccountName()
{
    return accountName;
}
/**
 * @param accountName the accountName to set
 */
public void setAccountName(String accountName)
{
    this.accountName = accountName;
}
/**
 * @return the op_no
 */
public String getOp_no()
{
    return op_no;
}
/**
 * @param opNo the op_no to set
 */
public void setOp_no(String opNo)
{
    op_no = opNo;
}
/**
 * @return the jv_type
 */
public String getJv_type()
{
    return jv_type;
}
/**
 * @param jvType the jv_type to set
 */
public void setJv_type(String jvType)
{
    jv_type = jvType;
}
/**
 * @return the jv_ref
 */
public String getJv_ref()
{
    return jv_ref;
}
/**
 * @param jvRef the jv_ref to set
 */
public void setJv_ref(String jvRef)
{
    jv_ref = jvRef;
}
/**
 * @return the op_status
 */
public String getOp_status()
{
    return op_status;
}
/**
 * @param opStatus the op_status to set
 */
public void setOp_status(String opStatus)
{
    op_status = opStatus;
}
/**
 * @return the value_date
 */
public Date getValue_date()
{
    return value_date;
}
/**
 * @param valueDate the value_date to set
 */
public void setValue_date(Date valueDate)
{
    value_date = valueDate;
}
/**
 * @return the trx_date
 */
public Date getTrx_date()
{
    return trx_date;
}
/**
 * @param trxDate the trx_date to set
 */
public void setTrx_date(Date trxDate)
{
    trx_date = trxDate;
}
/**
 * @return the description
 */
public String getDescription()
{
    return description;
}
/**
 * @param description the description to set
 */
public void setDescription(String description)
{
    this.description = description;
}
/**
 * @return the glCode
 */
public BigDecimal getGlCode()
{
    return glCode;
}
/**
 * @param glCode the glCode to set
 */
public void setGlCode(BigDecimal glCode)
{
    this.glCode = glCode;
}
/**
 * @return the currencyCode
 */
public BigDecimal getCurrencyCode()
{
    return currencyCode;
}
/**
 * @param currencyCode the currencyCode to set
 */
public void setCurrencyCode(BigDecimal currencyCode)
{
    this.currencyCode = currencyCode;
}
/**
 * @return the slNo
 */
public BigDecimal getSlNo()
{
    return slNo;
}
/**
 * @param slNo the slNo to set
 */
public void setSlNo(BigDecimal slNo)
{
    this.slNo = slNo;
}
/**
 * @return the compCode
 */
public BigDecimal getCompCode()
{
    return compCode;
}
/**
 * @param compCode the compCode to set
 */
public void setCompCode(BigDecimal compCode)
{
    this.compCode = compCode;
}
/**
 * @return the branchCode
 */
public BigDecimal getBranchCode()
{
    return branchCode;
}
/**
 * @param branchCode the branchCode to set
 */
public void setBranchCode(BigDecimal branchCode)
{
    this.branchCode = branchCode;
}

/**
 * @return the ac_sign
 */
public String getAc_sign()
{
    return ac_sign;
}
/**
 * @param acSign the ac_sign to set
 */
public void setAc_sign(String acSign)
{
    ac_sign = acSign;
}

/**
 * @return the amount
 */
public BigDecimal getAmount()
{
    return amount;
}
/**
 * @param amount the amount to set
 */
public void setAmount(BigDecimal amount)
{
    this.amount = amount;
}
/**
 * @return the amount_FORMAT
 */
public BigDecimal getAmount_FORMAT()
{
    return amount_FORMAT;
}
/**
 * @param amountFORMAT the amount_FORMAT to set
 */
public void setAmount_FORMAT(BigDecimal amountFORMAT)
{
    amount_FORMAT = amountFORMAT;
}
public String getSrlNo()
{
    return srlNo;
}
public void setSrlNo(String srlNo)
{
    this.srlNo = srlNo;
}
}
