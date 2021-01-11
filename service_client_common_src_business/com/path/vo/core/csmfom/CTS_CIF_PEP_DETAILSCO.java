package com.path.vo.core.csmfom;

import com.path.dbmaps.vo.CTS_CIF_PEP_DETAILSVO;
import com.path.lib.vo.BaseVO;

public class CTS_CIF_PEP_DETAILSCO  extends BaseVO
{
    private String PEP_NATIONALITY_DESC;
    private String COUNTRY_OF_RESIDENCE_DESC;
    private CTS_CIF_PEP_DETAILSVO ctsCifPepDetailsVO = new CTS_CIF_PEP_DETAILSVO();

    public CTS_CIF_PEP_DETAILSVO getCtsCifPepDetailsVO()
    {
        return ctsCifPepDetailsVO;
    }

    public void setCtsCifPepDetailsVO(CTS_CIF_PEP_DETAILSVO ctsCifPepDetailsVO)
    {
        this.ctsCifPepDetailsVO = ctsCifPepDetailsVO;
    }

    

    public String getCOUNTRY_OF_RESIDENCE_DESC()
    {
        return COUNTRY_OF_RESIDENCE_DESC;
    }

    public void setCOUNTRY_OF_RESIDENCE_DESC(String cOUNTRY_OF_RESIDENCE_DESC)
    {
        COUNTRY_OF_RESIDENCE_DESC = cOUNTRY_OF_RESIDENCE_DESC;
    }

    public String getPEP_NATIONALITY_DESC()
    {
        return PEP_NATIONALITY_DESC;
    }

    public void setPEP_NATIONALITY_DESC(String pEP_NATIONALITY_DESC)
    {
        PEP_NATIONALITY_DESC = pEP_NATIONALITY_DESC;
    }
    	
}
