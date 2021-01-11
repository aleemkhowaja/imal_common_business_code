package com.path.vo.core.occupation;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class OccupationSC extends GridParamsSC
{
    private BigDecimal occupationCode;
    private String occupStatus;
    private BigDecimal sectorCode;
    private BigDecimal subSectorCode;

	public BigDecimal getOccupationCode()
	{
		return occupationCode;
	}

	public void setOccupationCode(BigDecimal occupationCode)
	{
		this.occupationCode = occupationCode;
	}

	public String getOccupStatus()
	{
		return occupStatus;
	}

	public void setOccupStatus(String occupStatus)
	{
		this.occupStatus = occupStatus;
	}

	public BigDecimal getSectorCode()
	{
	    return sectorCode;
	}

	public void setSectorCode(BigDecimal sectorCode)
	{
	    this.sectorCode = sectorCode;
	}

	public BigDecimal getSubSectorCode()
	{
	    return subSectorCode;
	}

	public void setSubSectorCode(BigDecimal subSectorCode)
	{
	    this.subSectorCode = subSectorCode;
	}

	
	

}
