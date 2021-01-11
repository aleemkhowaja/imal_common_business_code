package com.path.vo.core.avacategory;

import com.path.dbmaps.vo.CTS_AVA_CATEGVO;
import com.path.dbmaps.vo.CTS_AVA_CATEG_PAY_LIMITVO;
import com.path.lib.vo.BaseVO;

public class AvaCategoryCO extends BaseVO
{
    private CTS_AVA_CATEGVO avaCategVO = new CTS_AVA_CATEGVO();
    private CTS_AVA_CATEG_PAY_LIMITVO avaCategPayLimitVO = new CTS_AVA_CATEG_PAY_LIMITVO();
    private String avaTypeDesc;

    public String getAvaTypeDesc()
    {
        return avaTypeDesc;
    }

    public void setAvaTypeDesc(String avaTypeDesc)
    {
        this.avaTypeDesc = avaTypeDesc;
    }

    public CTS_AVA_CATEGVO getAvaCategVO()
    {
        return avaCategVO;
    }

    public void setAvaCategVO(CTS_AVA_CATEGVO avaCategVO)
    {
        this.avaCategVO = avaCategVO;
    }

    public CTS_AVA_CATEG_PAY_LIMITVO getAvaCategPayLimitVO()
    {
        return avaCategPayLimitVO;
    }

    public void setAvaCategPayLimitVO(CTS_AVA_CATEG_PAY_LIMITVO avaCategPayLimitVO)
    {
        this.avaCategPayLimitVO = avaCategPayLimitVO;
    }
}
