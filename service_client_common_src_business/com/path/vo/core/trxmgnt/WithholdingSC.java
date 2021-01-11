package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class WithholdingSC extends GridParamsSC 
{
    
    private BigDecimal taxRegulationID;
    private BigDecimal processID;
    private BigDecimal errorCode;
    private String errorMessage;
    private String action;		// 'F' for Final Run - 'T' for Trial Run
    
    // Raed Saad - [#562508 ABARSI160021]
    private BigDecimal fromCif;
    private BigDecimal toCif;
    // END - Raed Saad - [#562508 ABARSI160021]
    
    private String reference;
    
    public BigDecimal getTaxRegulationID()
    {
        return taxRegulationID;
    }
    public void setTaxRegulationID(BigDecimal taxRegulationID)
    {
        this.taxRegulationID = taxRegulationID;
    }
    public BigDecimal getProcessID()
    {
        return processID;
    }
    public void setProcessID(BigDecimal processID)
    {
        this.processID = processID;
    }
    public BigDecimal getErrorCode()
    {
        return errorCode;
    }
    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }
    public String getErrorMessage()
    {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
    public String getAction()
    {
        return action;
    }
    public void setAction(String action)
    {
        this.action = action;
    }
    
    public BigDecimal getFromCif()
    {
        return fromCif;
    }
    
    public void setFromCif(BigDecimal fromCif)
    {
        this.fromCif = fromCif;
    }
    
    public BigDecimal getToCif()
    {
        return toCif;
    }
    
    public void setToCif(BigDecimal toCif)
    {
        this.toCif = toCif;
    }
    
    public String getReference()
    {
        return reference;
    }
    public void setReference(String reference)
    {
        this.reference = reference;
    }
    
 
}
