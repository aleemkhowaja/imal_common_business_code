package com.path.vo.core.nationality;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class NationalitySC extends GridParamsSC
{
    private BigDecimal nationalityCode;
    private String nationBriefDesc;

    public BigDecimal getNationalityCode()
    {
	return nationalityCode;
    }

    public void setNationalityCode(BigDecimal nationalityCode)
    {
	this.nationalityCode = nationalityCode;
    }

    /**
     * @return the nationBriefDesc
     */
    public String getNationBriefDesc()
    {
	return nationBriefDesc;
    }

    /**
     * @param nationBriefDesc the nationBriefDesc to set
     */
    public void setNationBriefDesc(String nationBriefDesc)
    {
	this.nationBriefDesc = nationBriefDesc;
    }

}
