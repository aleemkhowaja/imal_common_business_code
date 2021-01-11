package com.path.vo.common.address;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class AddressCommonSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal slNo;
    private BigDecimal glCode;
    private BigDecimal cyCode;
    private BigDecimal lineNo;
    private String defaultAdd;
    private String permAdd;
    private String screenSrc;
    private boolean defaultAddressFromCif;
    private boolean moreAddressWindowOpened;
    private String postalCodeType;
    private boolean fromFomKyc;
    private String walletAdd;
    //EWBI160091 (403157)- Modification of CIF
    private BigDecimal compCodeCif;
		
    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public String getDefaultAdd()
    {
	return defaultAdd;
    }

    public void setDefaultAdd(String defaultAdd)
    {
	this.defaultAdd = defaultAdd;
    }

    public void setPermAdd(String permAdd)
    {
	this.permAdd = permAdd;
    }

    public String getPermAdd()
    {
	return permAdd;
    }

    public BigDecimal getSlNo()
    {
	return slNo;
    }

    public void setSlNo(BigDecimal slNo)
    {
	this.slNo = slNo;
    }

    public BigDecimal getGlCode()
    {
	return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    public BigDecimal getCyCode()
    {
	return cyCode;
    }

    public void setCyCode(BigDecimal cyCode)
    {
	this.cyCode = cyCode;
    }

    public String getScreenSrc()
    {
	return screenSrc;
    }

    public void setScreenSrc(String screenSrc)
    {
	this.screenSrc = screenSrc;
    }

    public boolean isDefaultAddressFromCif()
    {
	return defaultAddressFromCif;
    }

    public void setDefaultAddressFromCif(boolean defaultAddressFromCif)
    {
	this.defaultAddressFromCif = defaultAddressFromCif;
    }

    public boolean isMoreAddressWindowOpened()
    {
	return moreAddressWindowOpened;
    }

    public void setMoreAddressWindowOpened(boolean moreAddressWindowOpened)
    {
	this.moreAddressWindowOpened = moreAddressWindowOpened;
    }

    public String getPostalCodeType()
    {
	return postalCodeType;
    }

    public void setPostalCodeType(String postalCodeType)
    {
	this.postalCodeType = postalCodeType;
    }

    public boolean isFromFomKyc()
    {
	return fromFomKyc;
    }

    public void setFromFomKyc(boolean fromFomKyc)
    {
	this.fromFomKyc = fromFomKyc;
    }

    public String getWalletAdd()
    {
	return walletAdd;
    }

    public void setWalletAdd(String walletAdd)
    {
	this.walletAdd = walletAdd;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }
	
}
