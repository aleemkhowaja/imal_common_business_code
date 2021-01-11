package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FomOwnershipDetailsSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal authCifNo;
    private String detailsType;
    //EWBI160091 (403157)- Modification of CIF
    private BigDecimal compCodeCif;

    public BigDecimal getAuthCifNo()
    {
	return authCifNo;
    }

    public void setAuthCifNo(BigDecimal authCifNo)
    {
	this.authCifNo = authCifNo;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public String getDetailsType()
    {
        return detailsType;
    }

    public void setDetailsType(String detailsType)
    {
        this.detailsType = detailsType;
    }

    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }
    
    

}
