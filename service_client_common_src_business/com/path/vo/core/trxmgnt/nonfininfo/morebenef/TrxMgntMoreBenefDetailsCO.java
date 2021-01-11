package com.path.vo.core.trxmgnt.nonfininfo.morebenef;

import com.path.dbmaps.vo.CTSTRS_BENEF_MORE_DETVO;
import com.path.vo.core.common.RetailBaseVO;

public class TrxMgntMoreBenefDetailsCO extends RetailBaseVO
{
 
    	private String cityDesc;
    	private String regionDesc;   
    	private String beneficiaryIdTypeDesc;
    	private String nationalityDesc;
    	private String countryDesc;
	private CTSTRS_BENEF_MORE_DETVO ctsTrsMoreBenefDetVO = new CTSTRS_BENEF_MORE_DETVO();

	public CTSTRS_BENEF_MORE_DETVO getCtsTrsMoreBenefDetVO()
	{
	    return ctsTrsMoreBenefDetVO;
	}

	public void setCtsTrsMoreBenefDetVO(CTSTRS_BENEF_MORE_DETVO ctsTrsMoreBenefDetVO)
	{
	    this.ctsTrsMoreBenefDetVO = ctsTrsMoreBenefDetVO;
	}

	public String getCityDesc()
	{
	    return cityDesc;
	}

	public void setCityDesc(String cityDesc)
	{
	    this.cityDesc = cityDesc;
	}

	public String getRegionDesc()
	{
	    return regionDesc;
	}

	public void setRegionDesc(String regionDesc)
	{
	    this.regionDesc = regionDesc;
	}

	public String getBeneficiaryIdTypeDesc()
	{
	    return beneficiaryIdTypeDesc;
	}

	public void setBeneficiaryIdTypeDesc(String beneficiaryIdTypeDesc)
	{
	    this.beneficiaryIdTypeDesc = beneficiaryIdTypeDesc;
	}

	public String getNationalityDesc()
	{
	    return nationalityDesc;
	}

	public void setNationalityDesc(String nationalityDesc)
	{
	    this.nationalityDesc = nationalityDesc;
	}

	public String getCountryDesc()
	{
	    return countryDesc;
	}

	public void setCountryDesc(String countryDesc)
	{
	    this.countryDesc = countryDesc;
	}
	
	
	
 }
