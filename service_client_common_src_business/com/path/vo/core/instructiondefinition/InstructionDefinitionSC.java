package com.path.vo.core.instructiondefinition;

import com.path.struts2.lib.common.GridParamsSC;
import java.math.BigDecimal;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * InstructionDefinitionSC.java used to
 */
public class InstructionDefinitionSC extends GridParamsSC
{
    BigDecimal instructionCode;
    String cyExchType;
    
    public BigDecimal getInstructionCode()
    {
        return instructionCode;
    }

    public void setInstructionCode(BigDecimal instructionCode)
    {
        this.instructionCode = instructionCode;
    }

    public String getCyExchType()
    {
        return cyExchType;
    }

    public void setCyExchType(String cyExchType)
    {
        this.cyExchType = cyExchType;
    }
    
    
}
