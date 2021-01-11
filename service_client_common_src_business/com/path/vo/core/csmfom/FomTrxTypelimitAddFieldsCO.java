package com.path.vo.core.csmfom;

import com.path.dbmaps.vo.TRSTYPE_ADD_FIELDSVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: AIssac
 * 
 *          FomBillTypeCO.java used to
 */
public class FomTrxTypelimitAddFieldsCO extends RetailBaseVO
{
    private TRSTYPE_ADD_FIELDSVO trstypeaddfieldsVO = new TRSTYPE_ADD_FIELDSVO();

    public TRSTYPE_ADD_FIELDSVO getTrstypeaddfieldsVO()
    {
        return trstypeaddfieldsVO;
    }

    public void setTrstypeaddfieldsVO(TRSTYPE_ADD_FIELDSVO trstypeaddfieldsVO)
    {
        this.trstypeaddfieldsVO = trstypeaddfieldsVO;
    }
}
