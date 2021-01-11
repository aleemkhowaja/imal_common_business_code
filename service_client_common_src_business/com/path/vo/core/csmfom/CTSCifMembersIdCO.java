package com.path.vo.core.csmfom;

import java.util.Date;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTS_CIF_MEMBERS_IDVO;
import com.path.vo.core.common.RetailBaseVO;

public class CTSCifMembersIdCO extends RetailBaseVO
{
    private CTS_CIF_MEMBERS_IDVO ctsCifMembersIDVO = new CTS_CIF_MEMBERS_IDVO();
    private String idTypeDesc;
    private String idDtlsCountryOfIssDesc;

    public CTS_CIF_MEMBERS_IDVO getCtsCifMembersIDVO()
    {
        return ctsCifMembersIDVO;
    }

    public void setCtsCifMembersIDVO(CTS_CIF_MEMBERS_IDVO ctsCifMembersIDVO)
    {
        this.ctsCifMembersIDVO = ctsCifMembersIDVO;
    }

    public String getIdTypeDesc()
    {
        return idTypeDesc;
    }

    public void setIdTypeDesc(String idTypeDesc)
    {
        this.idTypeDesc = idTypeDesc;
    }

    public String getIdDtlsCountryOfIssDesc()
    {
        return idDtlsCountryOfIssDesc;
    }

    public void setIdDtlsCountryOfIssDesc(String idDtlsCountryOfIssDesc)
    {
        this.idDtlsCountryOfIssDesc = idDtlsCountryOfIssDesc;
    }
}
