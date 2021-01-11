package com.path.vo.core.printreports;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class PrintReportsSC extends GridParamsSC
{

    private BigDecimal filteType; 
    private String  printingLevel;
    
    public BigDecimal getFilteType()
    {
        return filteType;
    }
    public void setFilteType(BigDecimal filteType)
    {
        this.filteType = filteType;
    }
    public String getPrintingLevel()
    {
        return printingLevel;
    }
    public void setPrintingLevel(String printingLevel)
    {
        this.printingLevel = printingLevel;
    }
    
}
