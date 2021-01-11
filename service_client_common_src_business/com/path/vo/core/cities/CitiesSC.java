package com.path.vo.core.cities;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CitiesSC extends GridParamsSC {

	private BigDecimal country_code;
	private BigDecimal region_code;
	private BigDecimal city_code;

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

	public BigDecimal getCity_code()
	{
		return city_code;
	}

	public void setCity_code(BigDecimal cityCode)
	{
		city_code = cityCode;
	}
}
