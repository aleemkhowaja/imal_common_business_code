package com.path.vo.core.avafilecompanion;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class AvaFileCompanionLkpSC extends GridParamsSC
{
    private BigDecimal fileCode;
    private BigDecimal companionSeq;

    public BigDecimal getFileCode()
    {
	return fileCode;
    }

    public void setFileCode(BigDecimal fileCode)
    {
	this.fileCode = fileCode;
    }

    public BigDecimal getCompanionSeq()
    {
        return companionSeq;
    }

    public void setCompanionSeq(BigDecimal companionSeq)
    {
        this.companionSeq = companionSeq;
    }

    
}
