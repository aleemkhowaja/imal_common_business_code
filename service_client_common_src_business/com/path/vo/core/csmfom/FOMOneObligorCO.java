package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTS_CIF_ONE_OBLIGORVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Reda Charabaty
 * 
 *          FOMPolicyTreatmentCO.java used to
 */
public class FOMOneObligorCO extends RetailBaseVO
{

    private BigDecimal compCode;
    private CTS_CIF_ONE_OBLIGORVO ctsCIFOneObligorVO;
    private Boolean accessByTeller = true;
    private BigDecimal cifNo;
    private String briefDesc;
    private String longDesc;
    private Date dateUpdated;
    private BigDecimal obligorCode;
    private String crud;
    
    private BigDecimal iisUtilized;
    private BigDecimal iisUnutilized;
    private BigDecimal assetsUtilized;
    private BigDecimal csmUtilized;
    private BigDecimal lcUtilized;
    private BigDecimal lgUtilized;
    private BigDecimal acceptanceUtilized;
    private BigDecimal fxUtilized;
    private BigDecimal securitiesAmt;
    private BigDecimal cashMarginAmt;
    private BigDecimal cashFDCollateralsAmt;
    private BigDecimal confirmationCode;
    private BigDecimal previousValue;
    private String previousBriefValue;
    private String previousLongValue;
    private BigDecimal parentObligor;

    public BigDecimal getCompCode()
    {
        return compCode;
    }
    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }
    
    public Boolean getAccessByTeller()
    {
        return accessByTeller;
    }
    public void setAccessByTeller(Boolean accessByTeller)
    {
        this.accessByTeller = accessByTeller;
    }
    public BigDecimal getCifNo()
    {
        return cifNo;
    }
    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
    public CTS_CIF_ONE_OBLIGORVO getCtsCIFOneObligorVO()
    {
        return ctsCIFOneObligorVO;
    }
    public void setCtsCIFOneObligorVO(CTS_CIF_ONE_OBLIGORVO ctsCIFOneObligorVO)
    {
        this.ctsCIFOneObligorVO = ctsCIFOneObligorVO;
    }
    public String getBriefDesc()
    {
        return briefDesc;
    }
    public void setBriefDesc(String briefDesc)
    {
        this.briefDesc = briefDesc;
    }
    public String getLongDesc()
    {
        return longDesc;
    }
    public void setLongDesc(String longDesc)
    {
        this.longDesc = longDesc;
    }
    public Date getDateUpdated()
    {
        return dateUpdated;
    }
    public void setDateUpdated(Date dateUpdated)
    {
        this.dateUpdated = dateUpdated;
    }
    public BigDecimal getObligorCode()
    {
        return obligorCode;
    }
    public void setObligorCode(BigDecimal obligorCode)
    {
        this.obligorCode = obligorCode;
    }
    @Override
    public String getCrud()
    {
        return crud;
    }
    @Override
    public void setCrud(String crud)
    {
        this.crud = crud;
    }
    public BigDecimal getIisUtilized()
    {
        return iisUtilized;
    }
    public void setIisUtilized(BigDecimal iisUtilized)
    {
        this.iisUtilized = iisUtilized;
    }
    public BigDecimal getIisUnutilized()
    {
        return iisUnutilized;
    }
    public void setIisUnutilized(BigDecimal iisUnutilized)
    {
        this.iisUnutilized = iisUnutilized;
    }
    public BigDecimal getAssetsUtilized()
    {
        return assetsUtilized;
    }
    public void setAssetsUtilized(BigDecimal assetsUtilized)
    {
        this.assetsUtilized = assetsUtilized;
    }
    public BigDecimal getCsmUtilized()
    {
        return csmUtilized;
    }
    public void setCsmUtilized(BigDecimal csmUtilized)
    {
        this.csmUtilized = csmUtilized;
    }
    public BigDecimal getLcUtilized()
    {
        return lcUtilized;
    }
    public void setLcUtilized(BigDecimal lcUtilized)
    {
        this.lcUtilized = lcUtilized;
    }
    public BigDecimal getLgUtilized()
    {
        return lgUtilized;
    }
    public void setLgUtilized(BigDecimal lgUtilized)
    {
        this.lgUtilized = lgUtilized;
    }
    public BigDecimal getAcceptanceUtilized()
    {
        return acceptanceUtilized;
    }
    public void setAcceptanceUtilized(BigDecimal acceptanceUtilized)
    {
        this.acceptanceUtilized = acceptanceUtilized;
    }
    public BigDecimal getFxUtilized()
    {
        return fxUtilized;
    }
    public void setFxUtilized(BigDecimal fxUtilized)
    {
        this.fxUtilized = fxUtilized;
    }
    public BigDecimal getSecuritiesAmt()
    {
        return securitiesAmt;
    }
    public void setSecuritiesAmt(BigDecimal securitiesAmt)
    {
        this.securitiesAmt = securitiesAmt;
    }
    public BigDecimal getCashMarginAmt()
    {
        return cashMarginAmt;
    }
    public void setCashMarginAmt(BigDecimal cashMarginAmt)
    {
        this.cashMarginAmt = cashMarginAmt;
    }
    public BigDecimal getCashFDCollateralsAmt()
    {
        return cashFDCollateralsAmt;
    }
    public void setCashFDCollateralsAmt(BigDecimal cashFDCollateralsAmt)
    {
        this.cashFDCollateralsAmt = cashFDCollateralsAmt;
    }
    public BigDecimal getConfirmationCode()
    {
        return confirmationCode;
    }
    public void setConfirmationCode(BigDecimal confirmationCode)
    {
        this.confirmationCode = confirmationCode;
    }
    public BigDecimal getPreviousValue()
    {
        return previousValue;
    }
    public void setPreviousValue(BigDecimal previousValue)
    {
        this.previousValue = previousValue;
    }
    public String getPreviousBriefValue()
    {
        return previousBriefValue;
    }
    public void setPreviousBriefValue(String previousBriefValue)
    {
        this.previousBriefValue = previousBriefValue;
    }
    public String getPreviousLongValue()
    {
        return previousLongValue;
    }
    public void setPreviousLongValue(String previousLongValue)
    {
        this.previousLongValue = previousLongValue;
    }
    public BigDecimal getParentObligor()
    {
        return parentObligor;
    }
    public void setParentObligor(BigDecimal parentObligor)
    {
        this.parentObligor = parentObligor;
    }
    
}
