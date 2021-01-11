package com.path.vo.core.passbookinventory;

import java.io.Serializable;

import com.path.dbmaps.vo.CTSPASSBOOK_TYPEVO;
import com.path.dbmaps.vo.PASSBOOK_INVENTORYVO;
import com.path.vo.core.common.RetailBaseVO;

public class PassBookinventoryCO extends RetailBaseVO implements Serializable
{
    private PASSBOOK_INVENTORYVO passbookInventoryVO=new PASSBOOK_INVENTORYVO();
    
    private CTSPASSBOOK_TYPEVO ctsPassBookTypeVO=new CTSPASSBOOK_TYPEVO();

    public PASSBOOK_INVENTORYVO getPassbookInventoryVO()
    {
        return passbookInventoryVO;
    }

    public void setPassbookInventoryVO(PASSBOOK_INVENTORYVO passbookInventoryVO)
    {
        this.passbookInventoryVO = passbookInventoryVO;
    }

    public CTSPASSBOOK_TYPEVO getCtsPassBookTypeVO()
    {
        return ctsPassBookTypeVO;
    }

    public void setCtsPassBookTypeVO(CTSPASSBOOK_TYPEVO ctsPassBookTypeVO)
    {
        this.ctsPassBookTypeVO = ctsPassBookTypeVO;
    }
    
}
