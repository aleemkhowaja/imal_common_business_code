package com.path.vo.core.csmfom;

import com.path.dbmaps.vo.CIF_COUNTRY_INFOVO;
import com.path.lib.vo.BaseVO;

public class CIFCountryInfoCO extends BaseVO {
	private CIF_COUNTRY_INFOVO cifCountryInfoVO = new CIF_COUNTRY_INFOVO();
	private String KYC_FINANCIAL_COUNTRY_DESC;

	public String getKYC_FINANCIAL_COUNTRY_DESC() {
		return KYC_FINANCIAL_COUNTRY_DESC;
	}

	public void setKYC_FINANCIAL_COUNTRY_DESC(String kYC_FINANCIAL_COUNTRY_DESC) {
		KYC_FINANCIAL_COUNTRY_DESC = kYC_FINANCIAL_COUNTRY_DESC;
	}

	public CIF_COUNTRY_INFOVO getCifCountryInfoVO() {
		return cifCountryInfoVO;
	}

	public void setCifCountryInfoVO(CIF_COUNTRY_INFOVO cifCountryInfoVO) {
		this.cifCountryInfoVO = cifCountryInfoVO;
	}



}
