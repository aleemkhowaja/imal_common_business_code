package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CIF_TRX_TRENDS_DETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: AIssac
 * 
 *          FOMTransactionTrendsCO.java used to
 */
public class FOMTransactionTrendsCO extends BaseVO
{
    private CIF_TRX_TRENDS_DETVO transactionTrendsVo = new CIF_TRX_TRENDS_DETVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String TRX_TYPE_SHORT_DESC_ENG;
    private String PERIODICITY_TYPE_DESC;
    private String CURRENCY_DESC;
    private String saveType;
    private String cifStatus;
    private Boolean accesByTeller = true;
    private BigDecimal amtFormat;
    private String iv_crud;
    private Date cif_UpdateDate;
    private Date runningDate;
    private BigDecimal loginCompCode;

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

    public String getTRX_TYPE_SHORT_DESC_ENG()
    {
	return TRX_TYPE_SHORT_DESC_ENG;
    }

    public void setTRX_TYPE_SHORT_DESC_ENG(String tRXTYPESHORTDESCENG)
    {
	TRX_TYPE_SHORT_DESC_ENG = tRXTYPESHORTDESCENG;
    }

    public CIF_TRX_TRENDS_DETVO getTransactionTrendsVo()
    {
	return transactionTrendsVo;
    }

    public void setTransactionTrendsVo(CIF_TRX_TRENDS_DETVO transactionTrendsVo)
    {
	this.transactionTrendsVo = transactionTrendsVo;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public String getPERIODICITY_TYPE_DESC()
    {
	return PERIODICITY_TYPE_DESC;
    }

    public void setPERIODICITY_TYPE_DESC(String pERIODICITYTYPEDESC)
    {
	PERIODICITY_TYPE_DESC = pERIODICITYTYPEDESC;
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

    /**
     * @return the runningDate
     */
    public Date getRunningDate()
    {
        return runningDate;
    }

    /**
     * @param runningDate the runningDate to set
     */
    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

	public void setLoginCompCode(BigDecimal loginCompCode) {
		this.loginCompCode = loginCompCode;
	}

	public BigDecimal getLoginCompCode() {
		return loginCompCode;
	}

	public String getCURRENCY_DESC()
	{
	    return CURRENCY_DESC;
	}

	public void setCURRENCY_DESC(String cURRENCY_DESC)
	{
	    CURRENCY_DESC = cURRENCY_DESC;
	}

}
