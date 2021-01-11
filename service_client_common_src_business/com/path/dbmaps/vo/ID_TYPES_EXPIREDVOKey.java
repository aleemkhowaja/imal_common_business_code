package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class ID_TYPES_EXPIREDVOKey extends BaseVO 
{

    private BigDecimal COMP_CODE;
    
    private BigDecimal CIF_SUB_NO ; 
    
    private BigDecimal ID_TYPE_CODE;

    public BigDecimal getCOMP_CODE()
    {
        return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMP_CODE)
    {
        COMP_CODE = cOMP_CODE;
    }

    public BigDecimal getCIF_SUB_NO()
    {
        return CIF_SUB_NO;
    }

    public void setCIF_SUB_NO(BigDecimal cIF_SUB_NO)
    {
        CIF_SUB_NO = cIF_SUB_NO;
    }

    public BigDecimal getID_TYPE_CODE()
    {
        return ID_TYPE_CODE;
    }

    public void setID_TYPE_CODE(BigDecimal iD_TYPE_CODE)
    {
        ID_TYPE_CODE = iD_TYPE_CODE;
    }
}
