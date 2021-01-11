package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * @author sarahelhusseini
 *
 */
public class FOMTrxDetailsSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal lineNo;
    public BigDecimal getCifNo()
    {
        return cifNo;
    }
    public BigDecimal getLineNo()
    {
        return lineNo;
    }
    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }
}
