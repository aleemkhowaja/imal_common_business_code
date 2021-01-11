package com.path.vo.core.csmfom;

import java.util.Date;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_EDUCATIONVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

public class FomEducationCO extends RetailBaseVO
{

    private CIF_EDUCATIONVO cifEducationVO = new CIF_EDUCATIONVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private CIFVO cifVo = new CIFVO(); 
    private String saveType;
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;

    private Boolean accesByTeller = true;

    public CIF_EDUCATIONVO getCifEducationVO()
    {
	return cifEducationVO;
    }

    public void setCifEducationVO(CIF_EDUCATIONVO cifEducationVO)
    {
	this.cifEducationVO = cifEducationVO;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

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

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    /**
     * @return the cifVo
     */
    public CIFVO getCifVo()
    {
        return cifVo;
    }

    /**
     * @param cifVo the cifVo to set
     */
    public void setCifVo(CIFVO cifVo)
    {
        this.cifVo = cifVo;
    }

}
