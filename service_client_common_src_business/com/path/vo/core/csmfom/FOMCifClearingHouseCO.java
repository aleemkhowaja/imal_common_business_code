package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * FOMCifClearingHouseCO.java used to
 */
public class FOMCifClearingHouseCO extends RetailBaseVO 
{
    //private CIF_CLEARING_HOUSEVO cifClearingHouseVO = new CIF_CLEARING_HOUSEVO();
    private BigDecimal COMP_CODE;
    private BigDecimal CIF_NO;
    private BigDecimal CURRENCY_CODE;
    private BigDecimal CLEARING_HOUSE;
    private String CY_DESC;
    private String CLH_NAME;
    
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO() ;
	private String cifStatus;
	private String iv_crud;
	private Date cif_UpdateDate ;
	
	private Boolean accesByTeller=true;
    
    
    public CTSTELLERVO getCtsTellerVO() {
		return ctsTellerVO;
	}

	public void setCtsTellerVO(CTSTELLERVO ctsTellerVO) {
		this.ctsTellerVO = ctsTellerVO;
	}

	public String getCifStatus() {
		return cifStatus;
	}

	public void setCifStatus(String cifStatus) {
		this.cifStatus = cifStatus;
	}

	public String getIv_crud() {
		return iv_crud;
	}

	public void setIv_crud(String ivCrud) {
		iv_crud = ivCrud;
	}

	public Date getCif_UpdateDate() {
		return cif_UpdateDate;
	}

	public void setCif_UpdateDate(Date cifUpdateDate) {
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

    public String getCLH_NAME()
    {
	return CLH_NAME;
    }

    public void setCLH_NAME(String cLHNAME)
    {
	CLH_NAME = cLHNAME;
    }

	public BigDecimal getCOMP_CODE()
	{
		return COMP_CODE;
	}

	public void setCOMP_CODE(BigDecimal cOMPCODE)
	{
		COMP_CODE = cOMPCODE;
	}

	public BigDecimal getCIF_NO()
	{
		return CIF_NO;
	}

	public void setCIF_NO(BigDecimal cIFNO)
	{
		CIF_NO = cIFNO;
	}

	public BigDecimal getCURRENCY_CODE()
	{
		return CURRENCY_CODE;
	}

	public void setCURRENCY_CODE(BigDecimal cURRENCYCODE)
	{
		CURRENCY_CODE = cURRENCYCODE;
	}

	public BigDecimal getCLEARING_HOUSE()
	{
		return CLEARING_HOUSE;
	}

	public void setCLEARING_HOUSE(BigDecimal cLEARINGHOUSE)
	{
		CLEARING_HOUSE = cLEARINGHOUSE;
	}

	public Boolean getAccesByTeller()
	{
		return accesByTeller;
	}

	public void setAccesByTeller(Boolean accesByTeller)
	{
		this.accesByTeller = accesByTeller;
	}

//    public CIF_CLEARING_HOUSEVO getCifClearingHouseVO()
//    {
//	return cifClearingHouseVO;
//    }
//
//    public void setCifClearingHouseVO(CIF_CLEARING_HOUSEVO cifClearingHouseVO)
//    {
//	this.cifClearingHouseVO = cifClearingHouseVO;
//    }

}
