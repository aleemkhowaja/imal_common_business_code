/**
 * 
 */
package com.path.vo.core.trxmgnt.overdraftsettlment;

import com.path.dbmaps.vo.CTSOVERDRAFT_SETTLMENTVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * TrxMgntOverdraftSettlCO.java used to
 */
public class TrxMgntOverdraftSettlCO extends RetailBaseVO
{
    private CTSOVERDRAFT_SETTLMENTVO ctsOverdraftSettlmentVO;

    /**
     * @return the ctsOverdraftSettlmentVO
     */
    public CTSOVERDRAFT_SETTLMENTVO getCtsOverdraftSettlmentVO()
    {
        return ctsOverdraftSettlmentVO;
    }

    /**
     * @param ctsOverdraftSettlmentVO the ctsOverdraftSettlmentVO to set
     */
    public void setCtsOverdraftSettlmentVO(CTSOVERDRAFT_SETTLMENTVO ctsOverdraftSettlmentVO)
    {
        this.ctsOverdraftSettlmentVO = ctsOverdraftSettlmentVO;
    }
}
