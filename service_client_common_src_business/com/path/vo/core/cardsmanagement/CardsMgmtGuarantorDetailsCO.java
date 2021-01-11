package com.path.vo.core.cardsmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSCARDS_MGT_GUARANTOR_DETVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.csmfom.FomCO;

public class CardsMgmtGuarantorDetailsCO extends RetailBaseVO
{
    private String cardsGuarantorDet;
    private CTSCARDS_MGT_GUARANTOR_DETVO ctsCardsMgtGuarantorDetVO = new CTSCARDS_MGT_GUARANTOR_DETVO();
    private String guarantorIdTypeDesc;
    private String guarantorCifDesc;
    private CIFVO cifVO = new CIFVO();
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private FomCO fomCO = new FomCO();
    
    public String getCardsGuarantorDet()
    {
        return cardsGuarantorDet;
    }
    public void setCardsGuarantorDet(String cardsGuarantorDet)
    {
        this.cardsGuarantorDet = cardsGuarantorDet;
    }
    public CTSCARDS_MGT_GUARANTOR_DETVO getCtsCardsMgtGuarantorDetVO()
    {
        return ctsCardsMgtGuarantorDetVO;
    }
    public void setCtsCardsMgtGuarantorDetVO(CTSCARDS_MGT_GUARANTOR_DETVO ctsCardsMgtGuarantorDetVO)
    {
        this.ctsCardsMgtGuarantorDetVO = ctsCardsMgtGuarantorDetVO;
    }
    public String getGuarantorIdTypeDesc()
    {
        return guarantorIdTypeDesc;
    }
    public void setGuarantorIdTypeDesc(String guarantorIdTypeDesc)
    {
        this.guarantorIdTypeDesc = guarantorIdTypeDesc;
    }
    public String getGuarantorCifDesc()
    {
        return guarantorCifDesc;
    }
    public void setGuarantorCifDesc(String guarantorCifDesc)
    {
        this.guarantorCifDesc = guarantorCifDesc;
    }
    public CIFVO getCifVO()
    {
        return cifVO;
    }
    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }
    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }
    public FomCO getFomCO()
    {
        return fomCO;
    }
    public void setFomCO(FomCO fomCO)
    {
        this.fomCO = fomCO;
    }
    
    
}
