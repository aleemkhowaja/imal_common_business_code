package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import com.path.dbmaps.vo.CIF_KYC_FINANCIAL_INFOVO;
import com.path.dbmaps.vo.CIF_KYC_FINANCIAL_INFO_DTLSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

public class CIF_KYC_FINANCIAL_INFOCO  extends BaseVO
{
    private String KYC_NATIONALITY_DESC;
    private String KYC_FINANCIAL_BIRTH_COUNTRY_DESC;
    private String KYC_REGION_DESC;
    private String KYC_CITY_DESC;
    private String KYC_CIF_TYPE_DESC;
    private String KYC_FINANCIAL_COUNTRY_DESC;
    private String KYC_ADDRESS_REGION_DESC;
    private String KYC_ADDRESS_CITY_DESC;
    private String KYC_FINANCIAL_ECONOMIC_SECTOR_DESC;
    private String KYC_FINANCIAL_POLITICAL_POS_DESC;
    private BigDecimal KYC_FINANCIAL_SHARES;
    private BigDecimal KYC_FINANCIAL_SHARES_PERC;
    private CIF_KYC_FINANCIAL_INFOVO cifKycFinancialInfoVO = new CIF_KYC_FINANCIAL_INFOVO();
    private CIF_KYC_FINANCIAL_INFO_DTLSVO cifKycFinancialInfoDtlsVO = new CIF_KYC_FINANCIAL_INFO_DTLSVO();
    private String YMC_COUNTRY_DESC;
    private String YMC_CURRENCY_DESC;
    private String roleDesc;
    private String idTypeDesc;
    private List<CIFKycFinancialInfoCountryCO> cifKycFinancialInfoCountryCOs=new ArrayList<>();
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private BigDecimal compCode;
    private String cifDesc;
    private String poBoxAreaDesc;
    private String postalcodeDesc;
    private String inGridStr;
    private BigDecimal authCifNo;
    private String countryDesc;
    private String ymcCountryTaxPayerActionType;
    private String openedFromDashboard;
    private BigDecimal civilIdType;
    private BigDecimal branchCode;
    private String KYC_FINANCIAL_RELATION_DESC;
    
    //BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement FALHA
    private String gridMode="0"; // 0 no grid normal dependnecy, 1 no data show warning, 2 read from cif, 3 read from another custodian
    private String language; 
    private BigDecimal selectedCif;
    private String selectedCustomerRef;
    private String RESIDENT_BANK_DESC;
    private String cifIdTypeDesc;
    private String POLITICAL_POS_CLIENT_DESC;
    private String openExistingRecord;
    private String finType;
    //BB190461 - CSM-FOM-KYC-Al Ghaly/Minor Enhancement FALHA
    
    public BigDecimal getKYC_FINANCIAL_SHARES()
    {
        return KYC_FINANCIAL_SHARES;
    }

    public void setKYC_FINANCIAL_SHARES(BigDecimal kYC_FINANCIAL_SHARES)
    {
        KYC_FINANCIAL_SHARES = kYC_FINANCIAL_SHARES;
    }

    public BigDecimal getKYC_FINANCIAL_SHARES_PERC()
    {
        return KYC_FINANCIAL_SHARES_PERC;
    }

    public void setKYC_FINANCIAL_SHARES_PERC(BigDecimal kYC_FINANCIAL_SHARES_PERC)
    {
        KYC_FINANCIAL_SHARES_PERC = kYC_FINANCIAL_SHARES_PERC;
    }

    public String getKYC_FINANCIAL_POLITICAL_POS_DESC()
    {
        return KYC_FINANCIAL_POLITICAL_POS_DESC;
    }

    public void setKYC_FINANCIAL_POLITICAL_POS_DESC(String kYC_FINANCIAL_POLITICAL_POS_DESC)
    {
        KYC_FINANCIAL_POLITICAL_POS_DESC = kYC_FINANCIAL_POLITICAL_POS_DESC;
    }

    public String getKYC_FINANCIAL_ECONOMIC_SECTOR_DESC()
    {
        return KYC_FINANCIAL_ECONOMIC_SECTOR_DESC;
    }

    public void setKYC_FINANCIAL_ECONOMIC_SECTOR_DESC(String kYC_FINANCIAL_ECONOMIC_SECTOR_DESC)
    {
        KYC_FINANCIAL_ECONOMIC_SECTOR_DESC = kYC_FINANCIAL_ECONOMIC_SECTOR_DESC;
    }

    public String getKYC_ADDRESS_CITY_DESC()
    {
        return KYC_ADDRESS_CITY_DESC;
    }

    public void setKYC_ADDRESS_CITY_DESC(String kYC_ADDRESS_CITY_DESC)
    {
        KYC_ADDRESS_CITY_DESC = kYC_ADDRESS_CITY_DESC;
    }

    public String getKYC_ADDRESS_REGION_DESC()
    {
        return KYC_ADDRESS_REGION_DESC;
    }

    public void setKYC_ADDRESS_REGION_DESC(String kYC_ADDRESS_REGION_DESC)
    {
        KYC_ADDRESS_REGION_DESC = kYC_ADDRESS_REGION_DESC;
    }

    public String getKYC_FINANCIAL_COUNTRY_DESC()
    {
        return KYC_FINANCIAL_COUNTRY_DESC;
    }

    public void setKYC_FINANCIAL_COUNTRY_DESC(String kYC_FINANCIAL_COUNTRY_DESC)
    {
        KYC_FINANCIAL_COUNTRY_DESC = kYC_FINANCIAL_COUNTRY_DESC;
    }

    public CIF_KYC_FINANCIAL_INFOVO getCifKycFinancialInfoVO()
    {
	return cifKycFinancialInfoVO;
    }

    public String getKYC_CIF_TYPE_DESC()
    {
        return KYC_CIF_TYPE_DESC;
    }

    public void setKYC_CIF_TYPE_DESC(String kYC_CIF_TYPE_DESC)
    {
        KYC_CIF_TYPE_DESC = kYC_CIF_TYPE_DESC;
    }

    public String getKYC_CITY_DESC()
    {
	return KYC_CITY_DESC;
    }

    public void setKYC_CITY_DESC(String kYC_CITY_DESC)
    {
	KYC_CITY_DESC = kYC_CITY_DESC;
    }

    public String getKYC_REGION_DESC()
    {
	return KYC_REGION_DESC;
    }

    public void setKYC_REGION_DESC(String kYC_REGION_DESC)
    {
	KYC_REGION_DESC = kYC_REGION_DESC;
    }

    public void setCifKycFinancialInfoVO(CIF_KYC_FINANCIAL_INFOVO cifKycFinancialInfoVO)
    {
	this.cifKycFinancialInfoVO = cifKycFinancialInfoVO;
    }

    public String getKYC_FINANCIAL_BIRTH_COUNTRY_DESC()
    {
	return KYC_FINANCIAL_BIRTH_COUNTRY_DESC;
    }

    public void setKYC_FINANCIAL_BIRTH_COUNTRY_DESC(String kYC_FINANCIAL_BIRTH_COUNTRY_DESC)
    {
	KYC_FINANCIAL_BIRTH_COUNTRY_DESC = kYC_FINANCIAL_BIRTH_COUNTRY_DESC;
    }

    public String getKYC_NATIONALITY_DESC()
    {
	return KYC_NATIONALITY_DESC;
    }

    public void setKYC_NATIONALITY_DESC(String kYC_NATIONALITY_DESC)
    {
	KYC_NATIONALITY_DESC = kYC_NATIONALITY_DESC;
    }
    
    public String getYMC_COUNTRY_DESC()
    {
        return YMC_COUNTRY_DESC;
    }

    public void setYMC_COUNTRY_DESC(String yMC_COUNTRY_DESC)
    {
        YMC_COUNTRY_DESC = yMC_COUNTRY_DESC;
    }

    public String getYMC_CURRENCY_DESC()
    {
	return YMC_CURRENCY_DESC;
    }

    public void setYMC_CURRENCY_DESC(String yMC_CURRENCY_DESC)
    {
	YMC_CURRENCY_DESC = yMC_CURRENCY_DESC;
    }

    public String getRoleDesc()
    {
	return roleDesc;
    }

    public void setRoleDesc(String roleDesc)
    {
	this.roleDesc = roleDesc;
    }

    public List<CIFKycFinancialInfoCountryCO> getCifKycFinancialInfoCountryCOs()
    {
	return cifKycFinancialInfoCountryCOs;
    }

    public void setCifKycFinancialInfoCountryCOs(List<CIFKycFinancialInfoCountryCO> cifKycFinancialInfoCountryCOs)
    {
	this.cifKycFinancialInfoCountryCOs = cifKycFinancialInfoCountryCOs;
    }

    public String getIdTypeDesc()
    {
	return idTypeDesc;
    }

    public void setIdTypeDesc(String idTypeDesc)
    {
	this.idTypeDesc = idTypeDesc;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
	return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
	this.hm = hm;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public String getCifDesc()
    {
	return cifDesc;
    }

    public void setCifDesc(String cifDesc)
    {
	this.cifDesc = cifDesc;
    }

    public String getPoBoxAreaDesc()
    {
	return poBoxAreaDesc;
    }

    public void setPoBoxAreaDesc(String poBoxAreaDesc)
    {
	this.poBoxAreaDesc = poBoxAreaDesc;
    }

    public String getPostalcodeDesc()
    {
	return postalcodeDesc;
    }

    public void setPostalcodeDesc(String postalcodeDesc)
    {
	this.postalcodeDesc = postalcodeDesc;
    }

    public String getInGridStr()
    {
	return inGridStr;
    }

    public void setInGridStr(String inGridStr)
    {
	this.inGridStr = inGridStr;
    }

    public BigDecimal getAuthCifNo()
    {
	return authCifNo;
    }

    public void setAuthCifNo(BigDecimal authCifNo)
    {
	this.authCifNo = authCifNo;
    }

    public CIF_KYC_FINANCIAL_INFO_DTLSVO getCifKycFinancialInfoDtlsVO()
    {
	return cifKycFinancialInfoDtlsVO;
    }

    public void setCifKycFinancialInfoDtlsVO(CIF_KYC_FINANCIAL_INFO_DTLSVO cifKycFinancialInfoDtlsVO)
    {
	this.cifKycFinancialInfoDtlsVO = cifKycFinancialInfoDtlsVO;
    }

    public String getCountryDesc()
    {
	return countryDesc;
    }

    public void setCountryDesc(String countryDesc)
    {
	this.countryDesc = countryDesc;
    }

    public String getYmcCountryTaxPayerActionType()
    {
	return ymcCountryTaxPayerActionType;
    }

    public void setYmcCountryTaxPayerActionType(String ymcCountryTaxPayerActionType)
    {
	this.ymcCountryTaxPayerActionType = ymcCountryTaxPayerActionType;
    }

    public String getOpenedFromDashboard()
    {
	return openedFromDashboard;
    }

    public void setOpenedFromDashboard(String openedFromDashboard)
    {
	this.openedFromDashboard = openedFromDashboard;
    }

    public String getKYC_FINANCIAL_RELATION_DESC()
    {
	return KYC_FINANCIAL_RELATION_DESC;
    }

    public void setKYC_FINANCIAL_RELATION_DESC(String kYC_FINANCIAL_RELATION_DESC)
    {
	KYC_FINANCIAL_RELATION_DESC = kYC_FINANCIAL_RELATION_DESC;
    }

    public BigDecimal getCivilIdType()
    {
	return civilIdType;
    }

    public void setCivilIdType(BigDecimal civilIdType)
    {
	this.civilIdType = civilIdType;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }
    public String getGridMode()
	{
	    return gridMode;
	}

	public void setGridMode(String gridMode)
	{
	    this.gridMode = gridMode;
	}

	public String getLanguage()
	{
	    return language;
	}

	public void setLanguage(String language)
	{
	    this.language = language;
	}

	

	public BigDecimal getSelectedCif()
	{
	    return selectedCif;
	}

	public void setSelectedCif(BigDecimal selectedCif)
	{
	    this.selectedCif = selectedCif;
	}

	public String getSelectedCustomerRef()
	{
	    return selectedCustomerRef;
	}

	public void setSelectedCustomerRef(String selectedCustomerRef)
	{
	    this.selectedCustomerRef = selectedCustomerRef;
	}

	public String getRESIDENT_BANK_DESC()
	{
	    return RESIDENT_BANK_DESC;
	}

	public void setRESIDENT_BANK_DESC(String rESIDENT_BANK_DESC)
	{
	    RESIDENT_BANK_DESC = rESIDENT_BANK_DESC;
	}

	public String getCifIdTypeDesc()
	{
	    return cifIdTypeDesc;
	}

	public void setCifIdTypeDesc(String cifIdTypeDesc)
	{
	    this.cifIdTypeDesc = cifIdTypeDesc;
	}

	public String getPOLITICAL_POS_CLIENT_DESC()
	{
	    return POLITICAL_POS_CLIENT_DESC;
	}

	public void setPOLITICAL_POS_CLIENT_DESC(String pOLITICAL_POS_CLIENT_DESC)
	{
	    POLITICAL_POS_CLIENT_DESC = pOLITICAL_POS_CLIENT_DESC;
	}

	public String getOpenExistingRecord()
	{
	    return openExistingRecord;
	}

	public void setOpenExistingRecord(String openExistingRecord)
	{
	    this.openExistingRecord = openExistingRecord;
	}

	public String getFinType()
	{
	    return finType;
	}

	public void setFinType(String finType)
	{
	    this.finType = finType;
	}
	
	
}
