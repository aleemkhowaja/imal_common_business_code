package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.dbmaps.vo.ACC_VAT_BR_CYVO;
import com.path.vo.core.common.RetailBaseVO;
/**
 * 
 * Copyright 2019, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author mariachamieh
 * 
 * FOMVATDetailsCO.java used to
 */
public class FOMVATDetailsCO extends RetailBaseVO
{

    private BigDecimal cifNo;
    private BigDecimal lineNo;
    private String fromNew;
    private BigDecimal compCodeCif;
    private String vatPercResNonRes;
    private BigDecimal vatZone;
    private BigDecimal nationCode;
    private String resident;
    private ACC_VAT_BR_CYVO accVatCyVO = new ACC_VAT_BR_CYVO();
    public BigDecimal getCifNo()
    {
        return cifNo;
    }
    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
    public BigDecimal getLineNo()
    {
        return lineNo;
    }
    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }
    public String getFromNew()
    {
        return fromNew;
    }
    public void setFromNew(String fromNew)
    {
        this.fromNew = fromNew;
    }
    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }
    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }
    public String getVatPercResNonRes()
    {
        return vatPercResNonRes;
    }
    public void setVatPercResNonRes(String vatPercResNonRes)
    {
        this.vatPercResNonRes = vatPercResNonRes;
    }
    public BigDecimal getVatZone()
    {
        return vatZone;
    }
    public void setVatZone(BigDecimal vatZone)
    {
        this.vatZone = vatZone;
    }
    public BigDecimal getNationCode()
    {
        return nationCode;
    }
    public void setNationCode(BigDecimal nationCode)
    {
        this.nationCode = nationCode;
    }
    public String getResident()
    {
        return resident;
    }
    public void setResident(String resident)
    {
        this.resident = resident;
    }
	public ACC_VAT_BR_CYVO getAccVatCyVO() {
		return accVatCyVO;
	}
	public void setAccVatCyVO(ACC_VAT_BR_CYVO accVatCyVO) {
		this.accVatCyVO = accVatCyVO;
	}    
}
