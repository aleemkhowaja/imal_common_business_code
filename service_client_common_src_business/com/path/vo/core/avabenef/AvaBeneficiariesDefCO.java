package com.path.vo.core.avabenef;

import com.path.dbmaps.vo.CTS_AVA_BENEFICIARIESVO;
import com.path.vo.core.common.RetailBaseVO;

public class AvaBeneficiariesDefCO extends RetailBaseVO
{
    private CTS_AVA_BENEFICIARIESVO avaBeneficiariesVO = new CTS_AVA_BENEFICIARIESVO();

    private String cifDesc;
    private String idTypeDesc;
    private String occupationDesc;
    private String occupPositionDesc;
    private String statusDesc;

    public CTS_AVA_BENEFICIARIESVO getAvaBeneficiariesVO()
    {
	return avaBeneficiariesVO;
    }

    public void setAvaBeneficiariesVO(CTS_AVA_BENEFICIARIESVO avaBeneficiariesVO)
    {
	this.avaBeneficiariesVO = avaBeneficiariesVO;
    }

    public String getCifDesc()
    {
	return cifDesc;
    }

    public void setCifDesc(String cifDesc)
    {
	this.cifDesc = cifDesc;
    }

    public String getIdTypeDesc()
    {
	return idTypeDesc;
    }

    public void setIdTypeDesc(String idTypeDesc)
    {
	this.idTypeDesc = idTypeDesc;
    }

    public String getOccupationDesc()
    {
        return occupationDesc;
    }

    public void setOccupationDesc(String occupationDesc)
    {
        this.occupationDesc = occupationDesc;
    }

    public String getOccupPositionDesc()
    {
        return occupPositionDesc;
    }

    public void setOccupPositionDesc(String occupPositionDesc)
    {
        this.occupPositionDesc = occupPositionDesc;
    }

    public String getStatusDesc()
    {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }

}
