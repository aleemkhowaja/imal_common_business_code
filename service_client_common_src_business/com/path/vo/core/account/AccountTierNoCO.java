package com.path.vo.core.account;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountTierNoCO  implements Serializable
{
    private BigDecimal accTierNO;
    private BigDecimal accLimitScreenCode;
    private String accLimitDesc;
    private String accLimitBy;
    
    public BigDecimal getAccTierNO()
    {
        return accTierNO;
    }
    public void setAccTierNO(BigDecimal accTierNO)
    {
        this.accTierNO = accTierNO;
    }
    public BigDecimal getAccLimitScreenCode()
    {
        return accLimitScreenCode;
    }
    public void setAccLimitScreenCode(BigDecimal accLimitScreenCode)
    {
        this.accLimitScreenCode = accLimitScreenCode;
    }
    public String getAccLimitDesc()
    {
        return accLimitDesc;
    }
    public void setAccLimitDesc(String accLimitDesc)
    {
        this.accLimitDesc = accLimitDesc;
    }
    public String getAccLimitBy()
    {
        return accLimitBy;
    }
    public void setAccLimitBy(String accLimitBy)
    {
        this.accLimitBy = accLimitBy;
    }
}
