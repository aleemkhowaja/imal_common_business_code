package com.path.vo.core.trxmgnt.billreference;

import com.path.dbmaps.vo.CTS_SERV_REGVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: eliasaoun
 *
 * TrxBillReferenceCO.java used to
 */
public class TrxBillReferenceCO extends BaseVO
{
    private CTS_SERV_REGVO ctsServRegVO = new CTS_SERV_REGVO();

    public CTS_SERV_REGVO getCtsServRegVO()
    {
	return ctsServRegVO;
    }

    public void setCtsServRegVO(CTS_SERV_REGVO ctsServRegVO)
    {
	this.ctsServRegVO = ctsServRegVO;
    }

}
