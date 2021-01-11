package com.path.vo.core.csmfom;

import com.path.dbmaps.vo.CTS_CIF_MEMBERS_DETVO;
import com.path.vo.core.common.RetailBaseVO;

public class CTSCifMembersDetCO extends RetailBaseVO
{
    private CTS_CIF_MEMBERS_DETVO ctsCifMembersDetVO = new CTS_CIF_MEMBERS_DETVO();
    
    private String residenceDesc;
   

    public CTS_CIF_MEMBERS_DETVO getCtsCifMembersDetVO()
    {
        return ctsCifMembersDetVO;
    }

    public void setCtsCifMembersDetVO(CTS_CIF_MEMBERS_DETVO ctsCifMembersDetVO)
    {
        this.ctsCifMembersDetVO = ctsCifMembersDetVO;
    }

    public String getResidenceDesc()
    {
        return residenceDesc;
    }

    public void setResidenceDesc(String residenceDesc)
    {
        this.residenceDesc = residenceDesc;
    }
}
