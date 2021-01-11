package com.path.vo.core.trxmgnt.nonfininfo.multibankbenef;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class MultiBankBeneficiariesSC extends GridParamsSC
{
    private BigDecimal trsNo;
    private BigDecimal lineNo;
    private BigDecimal multiTrsNo;
    private String nonInfoAlert;
    private BigDecimal trxType;
    private BigDecimal mainTrxNo;
    
    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }
    
    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

    public BigDecimal getMultiTrsNo()
    {
        return multiTrsNo;
    }

    public void setMultiTrsNo(BigDecimal multiTrsNo)
    {
        this.multiTrsNo = multiTrsNo;
    }

    public String getNonInfoAlert()
    {
        return nonInfoAlert;
    }

    public void setNonInfoAlert(String nonInfoAlert)
    {
        this.nonInfoAlert = nonInfoAlert;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public BigDecimal getMainTrxNo()
    {
        return mainTrxNo;
    }

    public void setMainTrxNo(BigDecimal mainTrxNo)
    {
        this.mainTrxNo = mainTrxNo;
    }

}