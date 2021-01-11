package com.path.vo.core.conditionalautomation;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * @author sarahelhusseini
 * 
 */
public class ConditionalAutomationSC extends GridParamsSC
{
    private String entityType;
    private BigDecimal cifType;
    private BigDecimal eventType;
    private BigDecimal deleteSpecialCond;
    private BigDecimal linkedCondAutomationCode;
    private BigDecimal cifTypesFlag;
    private String specialCondType;


	
	public String getSpecialCondType()
	{
		return specialCondType;
	}

	
	public void setSpecialCondType(String specialCondType)
	{
		this.specialCondType = specialCondType;
	}

    public BigDecimal getCifTypesFlag()
    {
        return cifTypesFlag;
    }

    public void setCifTypesFlag(BigDecimal cifTypesFlag)
    {
        this.cifTypesFlag = cifTypesFlag;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public BigDecimal getEventType()
    {
        return eventType;
    }

    public void setEventType(BigDecimal eventType)
    {
        this.eventType = eventType;
    }

    public String getEntityType()
    {
	return entityType;
    }

    public void setEntityType(String entityType)
    {
	this.entityType = entityType;
    }

    public BigDecimal getDeleteSpecialCond()
    {
        return deleteSpecialCond;
    }

    public void setDeleteSpecialCond(BigDecimal deleteSpecialCond)
    {
        this.deleteSpecialCond = deleteSpecialCond;
    }

    public BigDecimal getLinkedCondAutomationCode()
    {
        return linkedCondAutomationCode;
    }

    public void setLinkedCondAutomationCode(BigDecimal linkedCondAutomationCode)
    {
        this.linkedCondAutomationCode = linkedCondAutomationCode;
    }
}
