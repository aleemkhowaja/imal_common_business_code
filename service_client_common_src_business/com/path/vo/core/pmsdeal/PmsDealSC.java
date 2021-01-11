/**
 * 
 */
package com.path.vo.core.pmsdeal;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          PmsDealSC.java used to
 */
public class PmsDealSC extends GridParamsSC
{
    private BigDecimal dealNo;
    private String iv_crud;
    private BigDecimal code1;// security code1
    private BigDecimal code2;// security code1
    private String trxType;
    private String pthControl;

    /**
     * @return the dealNo
     */
    public BigDecimal getDealNo()
    {
	return dealNo;
    }

    /**
     * @param dealNo the dealNo to set
     */
    public void setDealNo(BigDecimal dealNo)
    {
	this.dealNo = dealNo;
    }

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    public BigDecimal getCode1()
    {
	return code1;
    }

    public void setCode1(BigDecimal code1)
    {
	this.code1 = code1;
    }

    public BigDecimal getCode2()
    {
	return code2;
    }

    public void setCode2(BigDecimal code2)
    {
	this.code2 = code2;
    }

    public String getTrxType()
    {
	return trxType;
    }

    public void setTrxType(String trxType)
    {
	this.trxType = trxType;
    }

    public String getPthControl()
    {
	return pthControl;
    }

    public void setPthControl(String pthControl)
    {
	this.pthControl = pthControl;
    }

}
