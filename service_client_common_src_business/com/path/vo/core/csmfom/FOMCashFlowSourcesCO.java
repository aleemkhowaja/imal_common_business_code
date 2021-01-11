package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CIF_CASH_FLOW_SOURCES_DETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: AIssac
 * 
 *          FOMCashFlowSourcesCO.java used to
 */
public class FOMCashFlowSourcesCO extends RetailBaseVO
{
    private CIF_CASH_FLOW_SOURCES_DETVO cifCashFlowSourcesDetVo = new CIF_CASH_FLOW_SOURCES_DETVO();
    private CURRENCIESVO currenciesVo = new CURRENCIESVO();
    CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String CY_DESC;
    private String saveType;
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private Boolean accesByTeller = true;
    private BigDecimal amtFormat;

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
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

    public String getCY_DESC()
    {
	return CY_DESC;
    }

    public void setCY_DESC(String cYDESC)
    {
	CY_DESC = cYDESC;
    }

    public CIF_CASH_FLOW_SOURCES_DETVO getCifCashFlowSourcesDetVo()
    {
	return cifCashFlowSourcesDetVo;
    }

    public void setCifCashFlowSourcesDetVo(CIF_CASH_FLOW_SOURCES_DETVO cifCashFlowSourcesDetVo)
    {
	this.cifCashFlowSourcesDetVo = cifCashFlowSourcesDetVo;
    }

    public CURRENCIESVO getCurrenciesVo()
    {
	return currenciesVo;
    }

    public void setCurrenciesVo(CURRENCIESVO currenciesVo)
    {
	this.currenciesVo = currenciesVo;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public BigDecimal getAmtFormat()
    {
	return amtFormat;
    }

    public void setAmtFormat(BigDecimal amtFormat)
    {
	this.amtFormat = amtFormat;
    }
}
