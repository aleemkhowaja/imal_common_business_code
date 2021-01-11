package com.path.vo.core.csmfom;


import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTS_AMF_KYC_BTN_DETVO;
import com.path.dbmaps.vo.CTS_CIF_KYC_BTN_DETVO;
import com.path.lib.vo.BaseVO;

public class CTS_AMF_KYC_BTN_DETCO  extends BaseVO
{
    private CTS_AMF_KYC_BTN_DETVO ctsAmfKycBtnDetVO = new CTS_AMF_KYC_BTN_DETVO();
    private String COUNTRY_RECEIVE_DESC;
    private String COUNTRY_REMITTANCE_DESC;
    private List<CTS_AMF_KYC_BTN_DETCO> ctsAmfKycBtnDetCOList=new ArrayList<>();
    public CTS_AMF_KYC_BTN_DETVO getCtsAmfKycBtnDetVO()
    {
        return ctsAmfKycBtnDetVO;
    }
    public void setCtsAmfKycBtnDetVO(CTS_AMF_KYC_BTN_DETVO ctsAmfKycBtnDetVO)
    {
        this.ctsAmfKycBtnDetVO = ctsAmfKycBtnDetVO;
    }
    public String getCOUNTRY_RECEIVE_DESC()
    {
        return COUNTRY_RECEIVE_DESC;
    }
    public void setCOUNTRY_RECEIVE_DESC(String cOUNTRY_RECEIVE_DESC)
    {
        COUNTRY_RECEIVE_DESC = cOUNTRY_RECEIVE_DESC;
    }
    public String getCOUNTRY_REMITTANCE_DESC()
    {
        return COUNTRY_REMITTANCE_DESC;
    }
    public void setCOUNTRY_REMITTANCE_DESC(String cOUNTRY_REMITTANCE_DESC)
    {
        COUNTRY_REMITTANCE_DESC = cOUNTRY_REMITTANCE_DESC;
    }
    public List<CTS_AMF_KYC_BTN_DETCO> getCtsAmfKycBtnDetCOList()
    {
        return ctsAmfKycBtnDetCOList;
    }
    public void setCtsAmfKycBtnDetCOList(List<CTS_AMF_KYC_BTN_DETCO> ctsAmfKycBtnDetCOList)
    {
        this.ctsAmfKycBtnDetCOList = ctsAmfKycBtnDetCOList;
    }
    

}