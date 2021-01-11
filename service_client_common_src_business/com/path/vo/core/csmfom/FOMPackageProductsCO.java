package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.CIF_PACKAGE_DEDUCT_CHARGESVO;
import com.path.dbmaps.vo.CIF_PACKAGE_PRODUCTSVO;
import com.path.dbmaps.vo.CTSPRODUCT_PACKAGE_DETVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Hasan Youssef
 * 
 *          FOMPackageProductsCO.java used to
 */
public class FOMPackageProductsCO extends RetailBaseVO
{
    private CIF_PACKAGE_PRODUCTSVO cifPackageProductVO = new CIF_PACKAGE_PRODUCTSVO();
    private CTSPRODUCT_PACKAGE_DETVO ctsproductPackageDetVO = new CTSPRODUCT_PACKAGE_DETVO();
    private CIF_PACKAGE_DEDUCT_CHARGESVO cifPackageDeductChargesVO = new CIF_PACKAGE_DEDUCT_CHARGESVO();
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayHm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private Date runningDate;
    private BigDecimal compCodeCif;
    private BigDecimal cifNo;
    private String packageBriefDesc;
    private String days;
    private String chqbookDesc;
    private String cardDesc;
    private String passbookDesc;
    private String userName;
    private String preferredLanguage;
    private BigDecimal lineNoDeduct;
    private String protectPeriod;
    private String deductChargesFromStr;
    private Boolean cancelButtonClicked = false;
    private String smsDesc;
    private String specificCurrency;

    public String getCifStatus()
    {
	return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
	this.cifStatus = cifStatus;
    }

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    public Date getCif_UpdateDate()
    {
	return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
	cif_UpdateDate = cifUpdateDate;
    }

    @Override
    public Date getRunningDate()
    {
	return runningDate;
    }

    @Override
    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifPackageProductVO(CIF_PACKAGE_PRODUCTSVO cifPackageProductVO)
    {
	this.cifPackageProductVO = cifPackageProductVO;
    }

    public CIF_PACKAGE_PRODUCTSVO getCifPackageProductVO()
    {
	return cifPackageProductVO;
    }

    public void setPackageBriefDesc(String packageBriefDesc)
    {
	this.packageBriefDesc = packageBriefDesc;
    }

    public String getPackageBriefDesc()
    {
	return packageBriefDesc;
    }

    public void setDays(String days)
    {
	this.days = days;
    }

    public String getDays()
    {
	return days;
    }

    public void setCtsproductPackageDetVO(CTSPRODUCT_PACKAGE_DETVO ctsproductPackageDetVO)
    {
	this.ctsproductPackageDetVO = ctsproductPackageDetVO;
    }

    public CTSPRODUCT_PACKAGE_DETVO getCtsproductPackageDetVO()
    {
	return ctsproductPackageDetVO;
    }

    public void setChqbookDesc(String chqbookDesc)
    {
	this.chqbookDesc = chqbookDesc;
    }

    public String getChqbookDesc()
    {
	return chqbookDesc;
    }

    public void setCardDesc(String cardDesc)
    {
	this.cardDesc = cardDesc;
    }

    public String getCardDesc()
    {
	return cardDesc;
    }

    public void setPassbookDesc(String passbookDesc)
    {
	this.passbookDesc = passbookDesc;
    }

    public String getPassbookDesc()
    {
	return passbookDesc;
    }

    public void setCifPackageDeductChargesVO(CIF_PACKAGE_DEDUCT_CHARGESVO cifPackageDeductChargesVO)
    {
	this.cifPackageDeductChargesVO = cifPackageDeductChargesVO;
    }

    public CIF_PACKAGE_DEDUCT_CHARGESVO getCifPackageDeductChargesVO()
    {
	return cifPackageDeductChargesVO;
    }

    public void setUserName(String userName)
    {
	this.userName = userName;
    }

    public String getUserName()
    {
	return userName;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
	this.preferredLanguage = preferredLanguage;
    }

    public String getPreferredLanguage()
    {
	return preferredLanguage;
    }

    public void setSysParamScreenDisplayHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayHm)
    {
	this.sysParamScreenDisplayHm = sysParamScreenDisplayHm;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getSysParamScreenDisplayHm()
    {
	return sysParamScreenDisplayHm;
    }

    public void setLineNoDeduct(BigDecimal lineNoDeduct)
    {
	this.lineNoDeduct = lineNoDeduct;
    }

    public BigDecimal getLineNoDeduct()
    {
	return lineNoDeduct;
    }

    public void setProtectPeriod(String protectPeriod)
    {
	this.protectPeriod = protectPeriod;
    }

    public String getProtectPeriod()
    {
	return protectPeriod;
    }
    
    public void setDeductChargesFromStr(String deductChargesFromStr)
    {
	this.deductChargesFromStr = deductChargesFromStr;
    }

    public String getDeductChargesFromStr()
    {
	return deductChargesFromStr;
    }

    public void setCancelButtonClicked(Boolean cancelButtonClicked)
    {
	this.cancelButtonClicked = cancelButtonClicked;
    }

    public Boolean getCancelButtonClicked()
    {
	return cancelButtonClicked;
    }

    public void setSmsDesc(String smsDesc)
    {
	this.smsDesc = smsDesc;
    }

    public String getSmsDesc()
    {
	return smsDesc;
    }

    public void setSpecificCurrency(String specificCurrency)
    {
	this.specificCurrency = specificCurrency;
    }

    public String getSpecificCurrency()
    {
	return specificCurrency;
    }
}
