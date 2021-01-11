package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.CIF_FATCA_NATIONALITYVO;
import com.path.dbmaps.vo.CTSTELLERVO;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * FOMBalanceLimitCO.java used to
 */
import com.path.vo.core.common.RetailBaseVO;

public class FOMAddNationalitiesCO extends RetailBaseVO
{
    private CIF_FATCA_NATIONALITYVO cifFatcaNationalitiesVO = new CIF_FATCA_NATIONALITYVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String addNationalitiesDetListStr;// string added to hold the list
    private List<FOMAddNationalitiesCO> addNationalitiesDetList = new ArrayList<FOMAddNationalitiesCO>();
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private Boolean accesByTeller = true;
    private BigDecimal cifNo;
    private String idTypeDesc;
    private String nationalityDesc;
    private String latestDateUpdated;
    private BigDecimal COMP_CODE;
    private BigDecimal CIF_NO;
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

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

   
    public CIF_FATCA_NATIONALITYVO getCifFatcaNationalitiesVO()
    {
	return cifFatcaNationalitiesVO;
    }

    public void setCifFatcaNationalitiesVO(CIF_FATCA_NATIONALITYVO cifFatcaNationalitiesVO)
    {
	this.cifFatcaNationalitiesVO = cifFatcaNationalitiesVO;
    }

    public String getIdTypeDesc()
    {
	return idTypeDesc;
    }

    public void setIdTypeDesc(String idTypeDesc)
    {
	this.idTypeDesc = idTypeDesc;
    }

    public String getNationalityDesc()
    {
	return nationalityDesc;
    }

    public void setNationalityDesc(String nationalityDesc)
    {
	this.nationalityDesc = nationalityDesc;
    }

    public String getAddNationalitiesDetListStr()
    {
	return addNationalitiesDetListStr;
    }

    public void setAddNationalitiesDetListStr(String addNationalitiesDetListStr)
    {
	this.addNationalitiesDetListStr = addNationalitiesDetListStr;
    }

    public List<FOMAddNationalitiesCO> getAddNationalitiesDetList()
    {
	return addNationalitiesDetList;
    }

    public void setAddNationalitiesDetList(List<FOMAddNationalitiesCO> addNationalitiesDetList)
    {
	this.addNationalitiesDetList = addNationalitiesDetList;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public String getLatestDateUpdated()
    {
	return latestDateUpdated;
    }

    public void setLatestDateUpdated(String latestDateUpdated)
    {
	this.latestDateUpdated = latestDateUpdated;
    }

    public BigDecimal getCOMP_CODE()
    {
        return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMP_CODE)
    {
        COMP_CODE = cOMP_CODE;
    }

    public BigDecimal getCIF_NO()
    {
        return CIF_NO;
    }

    public void setCIF_NO(BigDecimal cIF_NO)
    {
        CIF_NO = cIF_NO;
    }


}
