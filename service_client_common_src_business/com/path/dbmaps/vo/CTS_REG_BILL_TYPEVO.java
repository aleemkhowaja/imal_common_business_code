package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class CTS_REG_BILL_TYPEVO extends CTS_REG_BILL_TYPEVOKey
{
    private BigDecimal BRANCH_CODE;
    private BigDecimal GL_CODE;
    private BigDecimal CIF_SUB_NO;
    private BigDecimal SL_NO;
    public BigDecimal getBRANCH_CODE()
    {
        return BRANCH_CODE;
    }
    public void setBRANCH_CODE(BigDecimal bRANCH_CODE)
    {
        BRANCH_CODE = bRANCH_CODE;
    }
    public BigDecimal getGL_CODE()
    {
        return GL_CODE;
    }
    public void setGL_CODE(BigDecimal gL_CODE)
    {
        GL_CODE = gL_CODE;
    }
    public BigDecimal getCIF_SUB_NO()
    {
        return CIF_SUB_NO;
    }
    public void setCIF_SUB_NO(BigDecimal cIF_SUB_NO)
    {
        CIF_SUB_NO = cIF_SUB_NO;
    }
    public BigDecimal getSL_NO()
    {
        return SL_NO;
    }
    public void setSL_NO(BigDecimal sL_NO)
    {
        SL_NO = sL_NO;
    }
}
