package com.path.vo.core.economicsector;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class EconomicSectorSC extends GridParamsSC
{
    private BigDecimal cifType;
    private BigDecimal sectorCode;
    private String showInPos;
    // TP#621590 ;13-Feb-2018;d.james
    private String allTypes;
    private String allTypesFlag;
    private BigDecimal legalStatusCode;
    private String useCifMatrix;
    
    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    /**
     * @return the sectorCode
     */
    public BigDecimal getSectorCode()
    {
	return sectorCode;
    }

    /**
     * @param sectorCode the sectorCode to set
     */
    public void setSectorCode(BigDecimal sectorCode)
    {
	this.sectorCode = sectorCode;
    }

    public String getShowInPos()
    {
	return showInPos;
    }

    public void setShowInPos(String showInPos)
    {
	this.showInPos = showInPos;
	}

	public BigDecimal getLegalStatusCode()
	{
	    return legalStatusCode;
	}

	public void setLegalStatusCode(BigDecimal legalStatusCode)
	{
	    this.legalStatusCode = legalStatusCode;
	}

	public String getUseCifMatrix()
	{
	    return useCifMatrix;
	}

	public void setUseCifMatrix(String useCifMatrix)
	{
	    this.useCifMatrix = useCifMatrix;
	}
	
    public String getAllTypes()
    {
	return allTypes;
    }

    public void setAllTypes(String allTypes)
    {
	this.allTypes = allTypes;
    }

    public String getAllTypesFlag()
    {
	return allTypesFlag;
    }

    public void setAllTypesFlag(String allTypesFlag)
    {
	this.allTypesFlag = allTypesFlag;
    }

}
