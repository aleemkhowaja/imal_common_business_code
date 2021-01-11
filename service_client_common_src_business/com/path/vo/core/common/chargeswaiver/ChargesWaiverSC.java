package com.path.vo.core.common.chargeswaiver;


import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

public class ChargesWaiverSC extends GridParamsSC
{
    private String exemptionType;
    private BigDecimal waiverPercentage;
    private BigDecimal waiverAmount;
    private Date fromDate;
    private Date toDate;
    private BigDecimal fromBalance;
    private BigDecimal toBalance;
    private String pageRef;
    private String entityCode;
    private String entityType;
    private String screenRef;
    private String cifStatus;
    private Date cif_UpdateDate;
    
    //Rania - Merging of AIB150186 and AIB170086-14.1.3
    private BigDecimal lineNo;
    private BigDecimal updatedLineNo;
    //
    
    public String getExemptionType()
    {
        return exemptionType;
    }

    public void setExemptionType(String exemptionType)
    {
        this.exemptionType = exemptionType;
    }

    public BigDecimal getWaiverPercentage()
    {
        return waiverPercentage;
    }

    public void setWaiverPercentage(BigDecimal waiverPercentage)
    {
        this.waiverPercentage = waiverPercentage;
    }

    public BigDecimal getWaiverAmount()
    {
        return waiverAmount;
    }

    public void setWaiverAmount(BigDecimal waiverAmount)
    {
        this.waiverAmount = waiverAmount;
    }

    public Date getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public Date getToDate()
    {
        return toDate;
    }

    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }

    public BigDecimal getFromBalance()
    {
        return fromBalance;
    }

    public void setFromBalance(BigDecimal fromBalance)
    {
        this.fromBalance = fromBalance;
    }

    public BigDecimal getToBalance()
    {
        return toBalance;
    }

    public void setToBalance(BigDecimal toBalance)
    {
        this.toBalance = toBalance;
    }

    public String getPageRef()
    {
        return pageRef;
    }

    public void setPageRef(String pageRef)
    {
        this.pageRef = pageRef;
    }

    public String getEntityCode()
    {
        return entityCode;
    }

    public void setEntityCode(String entityCode)
    {
        this.entityCode = entityCode;
    }

    public String getEntityType()
    {
        return entityType;
    }

    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }

    public String getScreenRef()
    {
        return screenRef;
    }

    public void setScreenRef(String screenRef)
    {
        this.screenRef = screenRef;
    }

    public String getCifStatus()
    {
        return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
        this.cifStatus = cifStatus;
    }

    public Date getCif_UpdateDate()
    {
        return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cif_UpdateDate)
    {
        this.cif_UpdateDate = cif_UpdateDate;
    }

    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

    public BigDecimal getUpdatedLineNo()
    {
        return updatedLineNo;
    }

    public void setUpdatedLineNo(BigDecimal updatedLineNo)
    {
        this.updatedLineNo = updatedLineNo;
    }
}