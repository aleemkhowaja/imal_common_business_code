package com.path.vo.core.csmfom;

import com.path.dbmaps.vo.CIF_KYC_FINANC_INFO_CNTRYVO;
import com.path.lib.vo.BaseVO;

public class CIFKycFinancialInfoCountryCO extends BaseVO {
	private CIF_KYC_FINANC_INFO_CNTRYVO cifKycFinancialInfoCountryVO = new CIF_KYC_FINANC_INFO_CNTRYVO();
	private String KYC_FINANCIAL_COUNTRY_DESC;
	//delete used for webservice
	private String delete;

	public String getKYC_FINANCIAL_COUNTRY_DESC() {
		return KYC_FINANCIAL_COUNTRY_DESC;
	}

	public void setKYC_FINANCIAL_COUNTRY_DESC(String kYC_FINANCIAL_COUNTRY_DESC) {
		KYC_FINANCIAL_COUNTRY_DESC = kYC_FINANCIAL_COUNTRY_DESC;
	}

	public CIF_KYC_FINANC_INFO_CNTRYVO getCifKycFinancialInfoCountryVO() {
		return cifKycFinancialInfoCountryVO;
	}

	public void setCifKycFinancialInfoCountryVO(CIF_KYC_FINANC_INFO_CNTRYVO cifKycFinancialInfoCountryVO) {
		this.cifKycFinancialInfoCountryVO = cifKycFinancialInfoCountryVO;
	}

	public String getDelete()
	{
	    return delete;
	}

	public void setDelete(String delete)
	{
	    this.delete = delete;
	}

}
