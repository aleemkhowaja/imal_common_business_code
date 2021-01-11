package com.path.vo.core.trxfieldsname;

import com.path.dbmaps.vo.CTSTRXTYPE_STDVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * TrxFieldsNameCO.java used to
 */
public class TrxFieldsNameCO extends RetailBaseVO
{
    private CTSTRXTYPE_STDVO ctsTrxTypeSTDVO = new CTSTRXTYPE_STDVO();
    private String elementName;

    public CTSTRXTYPE_STDVO getCtsTrxTypeSTDVO()
    {
        return ctsTrxTypeSTDVO;
    }

    public void setCtsTrxTypeSTDVO(CTSTRXTYPE_STDVO ctsTrxTypeSTDVO)
    {
        this.ctsTrxTypeSTDVO = ctsTrxTypeSTDVO;
    }

    public String getElementName()
    {
        return elementName;
    }

    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }
}
