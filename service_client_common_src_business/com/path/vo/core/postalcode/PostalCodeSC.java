package com.path.vo.core.postalcode;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class PostalCodeSC extends GridParamsSC
{

    private BigDecimal country_code;
    private BigDecimal region_code;
    private String postal_code;
    private String filterByRegion = Boolean.TRUE.toString();

    public BigDecimal getCountry_code()
    {
	return country_code;
    }

    public void setCountry_code(BigDecimal countryCode)
    {
	country_code = countryCode;
    }

    public BigDecimal getRegion_code()
    {
	return region_code;
    }

    public void setRegion_code(BigDecimal regionCode)
    {
	region_code = regionCode;
    }

    public String getPostal_code()
    {
	return postal_code;
    }

    public void setPostal_code(String postalCode)
    {
	postal_code = postalCode;
    }

    public String getFilterByRegion()
    {
	return filterByRegion;
    }

    public void setFilterByRegion(String filterByRegion)
    {
	this.filterByRegion = filterByRegion;
    }

}
