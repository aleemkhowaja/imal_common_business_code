package com.path.vo.core.link;

import com.path.dbmaps.vo.S_LINKVO;
import com.path.lib.vo.BaseVO;

public class LinkCO extends BaseVO
{
    private S_LINKVO         s_linkVO;
    private String           LINK_TO_CIF;
    private String           LINK_TO_AMF;
    public S_LINKVO getS_linkVO()
    {
        return s_linkVO;
    }
    public void setS_linkVO(S_LINKVO sLinkVO)
    {
        s_linkVO = sLinkVO;
    }
    public String getLINK_TO_CIF()
    {
        return LINK_TO_CIF;
    }
    public void setLINK_TO_CIF(String lINKTOCIF)
    {
        LINK_TO_CIF = lINKTOCIF;
    }
    public String getLINK_TO_AMF()
    {
        return LINK_TO_AMF;
    }
    public void setLINK_TO_AMF(String lINKTOAMF)
    {
        LINK_TO_AMF = lINKTOAMF;
    }
}
