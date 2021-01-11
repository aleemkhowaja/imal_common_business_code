package com.path.vo.common.global360view.oneobligor;

import com.path.dbmaps.vo.CIF_PROFILEVO;
import com.path.dbmaps.vo.CREDIT_RATINGVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.RIFOBTVO;
import com.path.dbmaps.vo.RIFOBT_TRENDS_DETVO;
import com.path.vo.core.common.RetailBaseVO;
/**
 * 
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: johnmassaad
 *
 * OneObligorCO.java used to
 */
public class DashOneObligorCO extends RetailBaseVO
{
    private RIFOBTVO rifOBTVO = new RIFOBTVO();
    private RIFOBT_TRENDS_DETVO rifOBTTrendsDetVO = new RIFOBT_TRENDS_DETVO();
    private CREDIT_RATINGVO creditRatingVO = new CREDIT_RATINGVO();
    private CIF_PROFILEVO cifProfileVO = new CIF_PROFILEVO();
    private CURRENCIESVO currenciesVO = new CURRENCIESVO();
    private String isLookUp;
    private String ctsTrxTypeDesc;
    private String currecnyFormatter;
    
    public RIFOBTVO getRifOBTVO()
    {
        return rifOBTVO;
    }

    public void setRifOBTVO(RIFOBTVO rifOBTVO)
    {
        this.rifOBTVO = rifOBTVO;
    }

    public RIFOBT_TRENDS_DETVO getRifOBTTrendsDetVO()
    {
        return rifOBTTrendsDetVO;
    }

    public void setRifOBTTrendsDetVO(RIFOBT_TRENDS_DETVO rifOBTTrendsDetVO)
    {
        this.rifOBTTrendsDetVO = rifOBTTrendsDetVO;
    }

    public CREDIT_RATINGVO getCreditRatingVO()
    {
        return creditRatingVO;
    }

    public void setCreditRatingVO(CREDIT_RATINGVO creditRatingVO)
    {
        this.creditRatingVO = creditRatingVO;
    }

    public CIF_PROFILEVO getCifProfileVO()
    {
        return cifProfileVO;
    }

    public void setCifProfileVO(CIF_PROFILEVO cifProfileVO)
    {
        this.cifProfileVO = cifProfileVO;
    }

    public CURRENCIESVO getCurrenciesVO()
    {
        return currenciesVO;
    }

    public void setCurrenciesVO(CURRENCIESVO currenciesVO)
    {
        this.currenciesVO = currenciesVO;
    }

    public String getIsLookUp()
    {
        return isLookUp;
    }

    public void setIsLookUp(String isLookUp)
    {
        this.isLookUp = isLookUp;
    }

    public String getCtsTrxTypeDesc()
    {
        return ctsTrxTypeDesc;
    }

    public void setCtsTrxTypeDesc(String ctsTrxTypeDesc)
    {
        this.ctsTrxTypeDesc = ctsTrxTypeDesc;
    }

    public String getCurrecnyFormatter()
    {
        return currecnyFormatter;
    }

    public void setCurrecnyFormatter(String currecnyFormatter)
    {
        this.currecnyFormatter = currecnyFormatter;
    }

}
