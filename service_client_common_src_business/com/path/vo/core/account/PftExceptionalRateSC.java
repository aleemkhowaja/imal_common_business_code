package com.path.vo.core.account;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class PftExceptionalRateSC extends GridParamsSC
{
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal currencyCode;
    private BigDecimal GlCode;
    private BigDecimal cifCode;
    private BigDecimal slNbr;
    private String drcrIdx; 
    private BigDecimal lineNbr;
    
    public BigDecimal getCompCode()
    {
        return compCode;
    }
    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }
    public BigDecimal getBranchCode()
    {
        return branchCode;
    }
    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }
    public BigDecimal getCurrencyCode()
    {
        return currencyCode;
    }
    public void setCurrencyCode(BigDecimal currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    public BigDecimal getGlCode()
    {
        return GlCode;
    }
    public void setGlCode(BigDecimal glCode)
    {
        GlCode = glCode;
    }
    public BigDecimal getCifCode()
    {
        return cifCode;
    }
    public void setCifCode(BigDecimal cifCode)
    {
        this.cifCode = cifCode;
    }
    public BigDecimal getSlNbr()
    {
        return slNbr;
    }
    public void setSlNbr(BigDecimal slNbr)
    {
        this.slNbr = slNbr;
    }
    public String getDrcrIdx()
    {
        return drcrIdx;
    }
    public void setDrcrIdx(String drcrIdx)
    {
        this.drcrIdx = drcrIdx;
    }
    public BigDecimal getLineNbr()
    {
        return lineNbr;
    }
    public void setLineNbr(BigDecimal lineNbr)
    {
        this.lineNbr = lineNbr;
    }


}
