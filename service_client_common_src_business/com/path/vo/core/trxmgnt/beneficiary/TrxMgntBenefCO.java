package com.path.vo.core.trxmgnt.beneficiary;

import com.path.dbmaps.vo.AMFVOKey;
import com.path.dbmaps.vo.CIF_PROXY_BENEFVO;
import com.path.dbmaps.vo.CIF_PROXY_BENEF_DETVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: eliasaoun
 *
 * TrxMgntBenefCO.java used to
 */
public class TrxMgntBenefCO extends RetailBaseVO
{
    CIF_PROXY_BENEFVO cifProxyBenefVO = new CIF_PROXY_BENEFVO();
    CIF_PROXY_BENEF_DETVO cifProxyBenefDetVO = new CIF_PROXY_BENEF_DETVO();
    AMFVOKey toTrsAccVO = new AMFVOKey();

    String firstLastNameL;// FIRST_NAME_L + LAST_NAME_L
    Integer countBenefDet;
    String multiBenef;//beneficiary type
    String bankCIFNoDesc;
    String regionDesc;
    String cityDesc;
    String addReference;//BMO180089

    public CIF_PROXY_BENEFVO getCifProxyBenefVO()
    {
	return cifProxyBenefVO;
    }

    public void setCifProxyBenefVO(CIF_PROXY_BENEFVO cifProxyBenefVO)
    {
	this.cifProxyBenefVO = cifProxyBenefVO;
    }

    public CIF_PROXY_BENEF_DETVO getCifProxyBenefDetVO()
    {
	return cifProxyBenefDetVO;
    }

    public void setCifProxyBenefDetVO(CIF_PROXY_BENEF_DETVO cifProxyBenefDetVO)
    {
	this.cifProxyBenefDetVO = cifProxyBenefDetVO;
    }

    public String getFirstLastNameL()
    {
	return firstLastNameL;
    }

    public void setFirstLastNameL(String firstLastNameL)
    {
	this.firstLastNameL = firstLastNameL;
    }

    public Integer getCountBenefDet()
    {
	return countBenefDet;
    }

    public void setCountBenefDet(Integer countBenefDet)
    {
	this.countBenefDet = countBenefDet;
    }

    public AMFVOKey getToTrsAccVO()
    {
        return toTrsAccVO;
    }

    public void setToTrsAccVO(AMFVOKey toTrsAccVO)
    {
        this.toTrsAccVO = toTrsAccVO;
    }

    public String getMultiBenef()
    {
        return multiBenef;
    }

    public void setMultiBenef(String multiBenef)
    {
        this.multiBenef = multiBenef;
    }

    public String getBankCIFNoDesc()
    {
        return bankCIFNoDesc;
    }

    public void setBankCIFNoDesc(String bankCIFNoDesc)
    {
        this.bankCIFNoDesc = bankCIFNoDesc;
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

    public String getAddReference()
    {
        return addReference;
    }

    public void setAddReference(String addReference)
    {
        this.addReference = addReference;
    }

}
