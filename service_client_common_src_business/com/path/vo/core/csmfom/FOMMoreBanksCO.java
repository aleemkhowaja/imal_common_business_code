package com.path.vo.core.csmfom;

import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.CIF_BANK_DETAILS1VO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: AIssac
 * 
 *          FOMMoreBanksCO.java used to
 */
public class FOMMoreBanksCO extends RetailBaseVO
{
    private CIF_BANK_DETAILS1VO cifBankDetailsVO = new CIF_BANK_DETAILS1VO();
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String CIF_BANK_NAME;
    private String CURRENCY_BRIEF_DESC_ENG;
    private String CURRENCy_DECIMAL_POINTS;
    private String saveType;
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private Boolean accesByTeller = true;

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

    public String getCURRENCY_BRIEF_DESC_ENG()
    {
	return CURRENCY_BRIEF_DESC_ENG;
    }

    public void setCURRENCY_BRIEF_DESC_ENG(String cURRENCYBRIEFDESCENG)
    {
	CURRENCY_BRIEF_DESC_ENG = cURRENCYBRIEFDESCENG;
    }

    public String getCURRENCy_DECIMAL_POINTS()
    {
	return CURRENCy_DECIMAL_POINTS;
    }

    public void setCURRENCy_DECIMAL_POINTS(String cURRENCyDECIMALPOINTS)
    {
	CURRENCy_DECIMAL_POINTS = cURRENCyDECIMALPOINTS;
    }

    public CIF_BANK_DETAILS1VO getCifBankDetailsVO()
    {
	return cifBankDetailsVO;
    }

    public void setCifBankDetailsVO(CIF_BANK_DETAILS1VO cifBankDetailsVO)
    {
	this.cifBankDetailsVO = cifBankDetailsVO;
    }

    public String getCIF_BANK_NAME()
    {
	return CIF_BANK_NAME;
    }

    public void setCIF_BANK_NAME(String cIFBANKNAME)
    {
	CIF_BANK_NAME = cIFBANKNAME;
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

    /**
     * @return the businessElement
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBusinessElement()
    {
	return businessElement;
    }

    /**
     * @param businessElement the businessElement to set
     */
    public void setBusinessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessElement)
    {
	this.businessElement = businessElement;
    }

}
