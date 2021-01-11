package com.path.vo.core.instructionsubinstr;

import com.path.struts2.lib.common.GridParamsSC;
import java.math.BigDecimal;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionSubInstrSC.java used to
 */
public class InstructionSubInstrSC extends GridParamsSC
{
    private BigDecimal instrCode;
    private BigDecimal subInstrCode;
    public BigDecimal getInstrCode()
    {
        return instrCode;
    }
    public void setInstrCode(BigDecimal instrCode)
    {
        this.instrCode = instrCode;
    }
    public BigDecimal getSubInstrCode()
    {
        return subInstrCode;
    }
    public void setSubInstrCode(BigDecimal subInstrCode)
    {
        this.subInstrCode = subInstrCode;
    }
    
    
}
