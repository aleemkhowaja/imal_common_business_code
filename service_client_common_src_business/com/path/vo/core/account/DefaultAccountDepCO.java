package com.path.vo.core.account;

import com.path.lib.vo.BaseVO;

public class DefaultAccountDepCO extends BaseVO
{
   private String accountType;
   private String cifDesc;
   private String currrencyDesc;
   private String statusDesc;
/**
 * @return the accountType
 */
public String getAccountType()
{
    return accountType;
}
/**
 * @param accountType the accountType to set
 */
public void setAccountType(String accountType)
{
    this.accountType = accountType;
}
/**
 * @return the cifDesc
 */
public String getCifDesc()
{
    return cifDesc;
}
/**
 * @param cifDesc the cifDesc to set
 */
public void setCifDesc(String cifDesc)
{
    this.cifDesc = cifDesc;
}
/**
 * @return the currrencyDesc
 */
public String getCurrrencyDesc()
{
    return currrencyDesc;
}
/**
 * @param currrencyDesc the currrencyDesc to set
 */
public void setCurrrencyDesc(String currrencyDesc)
{
    this.currrencyDesc = currrencyDesc;
}
public String getStatusDesc()
{
    return statusDesc;
}
public void setStatusDesc(String statusDesc)
{
    this.statusDesc = statusDesc;
}
}
