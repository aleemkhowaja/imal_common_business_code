package com.path.vo.core.trxmgnt.nonfininfo.morebenef;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTSTRS_BENEF_DETVO;
import com.path.dbmaps.vo.CTSTRS_BENEF_DET_ALERTVO;
import com.path.vo.core.common.RetailBaseVO;

public class TrxMgntMoreBenefCO extends RetailBaseVO
{
 
	private CTSTRS_BENEF_DETVO ctsTrsBenefDetVO = new CTSTRS_BENEF_DETVO();
	private BigDecimal InfoMsg;
	private String regionDesc;
	private String cityDesc;
	
	//Hala Al Sheikh
	private CTSTRS_BENEF_DET_ALERTVO ctsTrsBenefDetAlertVO = new CTSTRS_BENEF_DET_ALERTVO();

	public CTSTRS_BENEF_DETVO getCtsTrsBenefDetVO() 
	{
	    return ctsTrsBenefDetVO;
	}
	public void setCtsTrsBenefDetVO(CTSTRS_BENEF_DETVO ctsTrsBenefDetVO)
	{
	    this.ctsTrsBenefDetVO = ctsTrsBenefDetVO;
	}
	
	public BigDecimal getInfoMsg()
	{
	    return InfoMsg;
	}
	public void setInfoMsg(BigDecimal infoMsg)
	{
	    InfoMsg = infoMsg;
	}

	public String getRegionDesc()
	{
	    return regionDesc;
	}
	public void setRegionDesc(String regionDesc)
	{
	    this.regionDesc = regionDesc;
	}
	public String getCityDesc()
	{
	    return cityDesc;
	}
	public void setCityDesc(String cityDesc)
	{
	    this.cityDesc = cityDesc;
	}
	public CTSTRS_BENEF_DET_ALERTVO getCtsTrsBenefDetAlertVO()
	{
	    return ctsTrsBenefDetAlertVO;
	}
	public void setCtsTrsBenefDetAlertVO(CTSTRS_BENEF_DET_ALERTVO ctsTrsBenefDetAlertVO)
	{
	    this.ctsTrsBenefDetAlertVO = ctsTrsBenefDetAlertVO;
	}
 
 }
