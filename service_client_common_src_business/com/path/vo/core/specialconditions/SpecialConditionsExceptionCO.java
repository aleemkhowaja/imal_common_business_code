package com.path.vo.core.specialconditions;

import com.path.dbmaps.vo.CTS_FORBID_PRODUCT_EXCEPTIONVO;
import com.path.vo.core.common.RetailBaseVO;

public class SpecialConditionsExceptionCO extends RetailBaseVO
{
    private String statusDescription;
    private CTS_FORBID_PRODUCT_EXCEPTIONVO forbidProductExceptionVO;
    
    
    public String getStatusDescription()
    {
        return statusDescription;
    }
    public void setStatusDescription(String statusDescription)
    {
        this.statusDescription = statusDescription;
    }
    public CTS_FORBID_PRODUCT_EXCEPTIONVO getForbidProductExceptionVO()
    {
        return forbidProductExceptionVO;
    }
    public void setForbidProductExceptionVO(CTS_FORBID_PRODUCT_EXCEPTIONVO forbidProductExceptionVO)
    {
        this.forbidProductExceptionVO = forbidProductExceptionVO;
    }
}
