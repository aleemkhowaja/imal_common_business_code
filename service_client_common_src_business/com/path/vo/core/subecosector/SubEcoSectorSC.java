package com.path.vo.core.subecosector;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class SubEcoSectorSC extends GridParamsSC
{
    private BigDecimal sectorCode;
    private BigDecimal cifType;
    private BigDecimal subSectorCode;
    private String calledFrom = "A"; // "G": Grading & "A" Application/Facility
    // TP#621590 ;13-Feb-2018;d.james
    private String allTypes;
    private String allTypesFlag;

    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    /**
     * @return the subSectorCode
     */
    public BigDecimal getSubSectorCode()
    {
	return subSectorCode;
    }

    /**
     * @param subSectorCode the subSectorCode to set
     */
    public void setSubSectorCode(BigDecimal subSectorCode)
    {
	this.subSectorCode = subSectorCode;
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

    public void setCalledFrom(String calledFrom)
    {
	this.calledFrom = calledFrom;
    }

    public String getCalledFrom()
    {
	return calledFrom;
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
