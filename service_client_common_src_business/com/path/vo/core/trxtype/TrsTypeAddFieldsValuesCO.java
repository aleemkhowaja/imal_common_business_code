package com.path.vo.core.trxtype;

import com.path.dbmaps.vo.TRSTYPE_ADD_FIELDS_VALUEVO;
import com.path.vo.core.common.RetailBaseVO;

public class TrsTypeAddFieldsValuesCO extends RetailBaseVO
{
   
    private TRSTYPE_ADD_FIELDS_VALUEVO addFieldsValueVo = new TRSTYPE_ADD_FIELDS_VALUEVO();
   
    
    public TRSTYPE_ADD_FIELDS_VALUEVO getAddFieldsValueVo()
    {
        return addFieldsValueVo;
    }

    public void setAddFieldsValueVo(TRSTYPE_ADD_FIELDS_VALUEVO addFieldsValueVo)
    {
        this.addFieldsValueVo = addFieldsValueVo;
    }
    
}
