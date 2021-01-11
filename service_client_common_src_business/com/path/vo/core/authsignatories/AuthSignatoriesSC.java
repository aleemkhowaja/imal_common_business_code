package com.path.vo.core.authsignatories;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * 
 * BillCollectionSC.java used for search criteria parameters of Bill
 */
public class AuthSignatoriesSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private String cifDesc;// cif name used upon choosing CIF from IRIS Scan/
    
    private BigDecimal authCifNo;
    
    public BigDecimal getCifNo()
    {
        return cifNo;
    }
    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
    public String getCifDesc()
    {
        return cifDesc;
    }
    public void setCifDesc(String cifDesc)
    {
        this.cifDesc = cifDesc;
    }
    public BigDecimal getAuthCifNo()
    {
        return authCifNo;
    }
    public void setAuthCifNo(BigDecimal authCifNo)
    {
        this.authCifNo = authCifNo;
    }
  

}
