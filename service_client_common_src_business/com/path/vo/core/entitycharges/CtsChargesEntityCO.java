package com.path.vo.core.entitycharges;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTS_CHARGES_ENTITYVO;
import com.path.vo.core.common.RetailBaseVO;

public class CtsChargesEntityCO extends RetailBaseVO 
{
    private CTS_CHARGES_ENTITYVO ctsChargesEntityVO = new CTS_CHARGES_ENTITYVO();
    private CTS_CHARGES_ENTITYVO vatCtsChargesEntityVO = new CTS_CHARGES_ENTITYVO();
    private CTSCHARGESVO ctsChargesVO = new CTSCHARGESVO();
    private String chargeDesc;
    private BigDecimal entityCount = BigDecimal.ONE;
    private String actionType;
    private BigDecimal chrgsCurrDecPoint;
    private BigDecimal baseCurrDecPoint; 
    
    private BigDecimal totalChargesAmount; 

    private String entityChargeKey;

    public void setChargeDesc(String chargeDesc)
    {
	this.chargeDesc = chargeDesc;
    }

    public String getChargeDesc()
    {
	return chargeDesc;
    }

    public CTS_CHARGES_ENTITYVO getVatCtsChargesEntityVO()
    {
	return vatCtsChargesEntityVO;
    }

    public void setVatCtsChargesEntityVO(CTS_CHARGES_ENTITYVO vatCtsChargesEntityVO)
    {
	this.vatCtsChargesEntityVO = vatCtsChargesEntityVO;
    }

    public BigDecimal getEntityCount()
    {
	return entityCount;
    }

    public void setEntityCount(BigDecimal entityCount)
    {
	this.entityCount = entityCount;
    }

    public CTS_CHARGES_ENTITYVO getCtsChargesEntityVO()
    {
        return ctsChargesEntityVO;
    }

    public void setCtsChargesEntityVO(CTS_CHARGES_ENTITYVO ctsChargesEntityVO)
    {
        this.ctsChargesEntityVO = ctsChargesEntityVO;
    }

    public CTSCHARGESVO getCtsChargesVO()
    {
        return ctsChargesVO;
    }

    public void setCtsChargesVO(CTSCHARGESVO ctsChargesVO)
    {
        this.ctsChargesVO = ctsChargesVO;
    }

	public String getEntityChargeKey() {
		return entityChargeKey;
	}

	public void setEntityChargeKey(String entityChargeKey) {
		this.entityChargeKey = entityChargeKey;
	}

	public void setChrgsCurrDecPoint(BigDecimal chrgsCurrDecPoint) {
		this.chrgsCurrDecPoint = chrgsCurrDecPoint;
	}

	public BigDecimal getChrgsCurrDecPoint() {
		return chrgsCurrDecPoint;
	}

	@Override
	public void setBaseCurrDecPoint(BigDecimal baseCurrDecPoint) {
		this.baseCurrDecPoint = baseCurrDecPoint;
	}

	@Override
	public BigDecimal getBaseCurrDecPoint() {
		return baseCurrDecPoint;
	}

	public String getActionType()
	{
	    return actionType;
	}

	public void setActionType(String actionType)
	{
	    this.actionType = actionType;
	}

    public BigDecimal getTotalChargesAmount()
    {
        return totalChargesAmount;
    }

    public void setTotalChargesAmount(BigDecimal totalChargesAmount)
    {
        this.totalChargesAmount = totalChargesAmount;
    }

}
