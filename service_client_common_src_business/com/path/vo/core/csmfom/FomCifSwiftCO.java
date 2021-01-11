package com.path.vo.core.csmfom;

import com.path.dbmaps.vo.PMSCIFSWIFTVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.core.common.RetailBaseVO;

public class FomCifSwiftCO extends RetailBaseVO
{
    private PMSCIFSWIFTVO cifSwiftVO = new PMSCIFSWIFTVO();
    private String saveType;
    private String status;
    private String cifName;
    private String bicCodeNumber;// this is used to get the bic code number from
				 // (
    // BIC_BBBB +BIC_CC+ BIC_L

    private String isoCountry;

    public String getBicCodeNumber()
    {
	return bicCodeNumber;
    }

    public void setBicCodeNumber(String bicCodeNumber)
    {
	this.bicCodeNumber = bicCodeNumber;
    }

    public String getCifName()
    {
	return cifName;
    }

    public void setCifName(String cifName)
    {
	this.cifName = cifName;
    }

    public PMSCIFSWIFTVO getCifSwiftVO()
    {
	return cifSwiftVO;
    }

    public void setCifSwiftVO(PMSCIFSWIFTVO cifSwiftVO)
    {
	this.cifSwiftVO = cifSwiftVO;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getIsoCountry()
    {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry)
    {
        this.isoCountry = isoCountry;
    }

}