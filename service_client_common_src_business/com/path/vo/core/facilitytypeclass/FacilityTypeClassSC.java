package com.path.vo.core.facilitytypeclass;

import java.math.BigDecimal;

import com.path.dbmaps.vo.V_DRAWDOWN_CLASSVO;
import com.path.struts2.lib.common.GridParamsSC;

public class FacilityTypeClassSC extends GridParamsSC
{
    private V_DRAWDOWN_CLASSVO viewDrawDownClassVO;
    private String ivCrud;
    private String langCode;
    private BigDecimal categoryCode;
    private String classType;
    private String appType;
    private String generalFacilityType;
    //used to use as  cloumn instead of generalFacilityType
    private String facilityType;
    private BigDecimal facilityCode;
    private BigDecimal facilityBr;
    private BigDecimal generalFacTypeLovType;

    public String getIvCrud()
    {
        return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
        this.ivCrud = ivCrud;
    }

    public BigDecimal getCategoryCode()
    {
        return categoryCode;
    }

    public void setCategoryCode(BigDecimal categoryCode)
    {
        this.categoryCode = categoryCode;
    }

    public String getLangCode()
    {
        return langCode;
    }

    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }

    public V_DRAWDOWN_CLASSVO getViewDrawDownClassVO()
    {
        return viewDrawDownClassVO;
    }

    public void setViewDrawDownClassVO(V_DRAWDOWN_CLASSVO viewDrawDownClassVO)
    {
        this.viewDrawDownClassVO = viewDrawDownClassVO;
    }

    public BigDecimal getFacilityCode()
    {
        return facilityCode;
    }

    public void setFacilityCode(BigDecimal facilityCode)
    {
        this.facilityCode = facilityCode;
    }

    public String getClassType()
    {
        return classType;
    }

    public void setClassType(String classType)
    {
        this.classType = classType;
    }

    public String getAppType()
    {
        return appType;
    }

    public void setAppType(String appType)
    {
        this.appType = appType;
    }

    public String getGeneralFacilityType()
    {
        return generalFacilityType;
    }

    public void setGeneralFacilityType(String generalFacilityType)
    {
        this.generalFacilityType = generalFacilityType;
    }

    /**
     * @return the facilityBr
     */
    public BigDecimal getFacilityBr()
    {
        return facilityBr;
    }

    /**
     * @param facilityBr the facilityBr to set
     */
    public void setFacilityBr(BigDecimal facilityBr)
    {
        this.facilityBr = facilityBr;
    }

    /**
     * @return the generalFacTypeLovType
     */
    public BigDecimal getGeneralFacTypeLovType()
    {
        return generalFacTypeLovType;
    }

    /**
     * @param generalFacTypeLovType the generalFacTypeLovType to set
     */
    public void setGeneralFacTypeLovType(BigDecimal generalFacTypeLovType)
    {
        this.generalFacTypeLovType = generalFacTypeLovType;
    }

    public String getFacilityType()
    {
        return facilityType;
    }

    public void setFacilityType(String facilityType)
    {
        this.facilityType = facilityType;
    }

}
