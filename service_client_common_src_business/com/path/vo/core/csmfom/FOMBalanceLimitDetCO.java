package com.path.vo.core.csmfom;

import com.path.dbmaps.vo.CIF_TRX_LIMIT_DETVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: AIssac
 * 
 *          FOMBalanceLimitCO.java used to
 */
public class FOMBalanceLimitDetCO extends CIF_TRX_LIMIT_DETVO
{
    // private CIF_TRX_LIMIT_DETVO cifTrxLimitDetVO = new CIF_TRX_LIMIT_DETVO();
    private String ACC_DESC;

    // public CIF_TRX_LIMIT_DETVO getCifTrxLimitDetVO()
    // {
    // return cifTrxLimitDetVO;
    // }
    // public void setCifTrxLimitDetVO(CIF_TRX_LIMIT_DETVO cifTrxLimitDetVO)
    // {
    // this.cifTrxLimitDetVO = cifTrxLimitDetVO;
    // }
    public String getACC_DESC()
    {
	return ACC_DESC;
    }

    public void setACC_DESC(String aCCDESC)
    {
	ACC_DESC = aCCDESC;
    }

}
