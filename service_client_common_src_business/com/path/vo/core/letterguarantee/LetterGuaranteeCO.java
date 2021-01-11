package com.path.vo.core.letterguarantee;

import com.path.dbmaps.vo.TFSLGVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * LetterGuaranteeCO.java used to hold complex objects of LG
 */
public class LetterGuaranteeCO extends RetailBaseVO
{
    private TFSLGVO tfsLgVO = new TFSLGVO();
    private String cyBriefDesc;
    private String cyDecimalPt;
    private String cifDesc;
    private String tfsDocTypeDesc;
    private String lgStatusDesc;

    /**
     * @return the tfsLgVO
     */
    public TFSLGVO getTfsLgVO()
    {
        return tfsLgVO;
    }

    /**
     * @param tfsLgVO the tfsLgVO to set
     */
    public void setTfsLgVO(TFSLGVO tfsLgVO)
    {
        this.tfsLgVO = tfsLgVO;
    }

    /**
     * @return the cyBriefDesc
     */
    public String getCyBriefDesc()
    {
        return cyBriefDesc;
    }

    /**
     * @param cyBriefDesc the cyBriefDesc to set
     */
    public void setCyBriefDesc(String cyBriefDesc)
    {
        this.cyBriefDesc = cyBriefDesc;
    }

    /**
     * @return the cyDecimalPt
     */
    public String getCyDecimalPt()
    {
        return cyDecimalPt;
    }

    /**
     * @param cyDecimalPt the cyDecimalPt to set
     */
    public void setCyDecimalPt(String cyDecimalPt)
    {
        this.cyDecimalPt = cyDecimalPt;
    }

    /**
     * @return the cifDesc
     */
    public String getCifDesc()
    {
        return cifDesc;
    }

    /**
     * @param cifDesc the cifDesc to set
     */
    public void setCifDesc(String cifDesc)
    {
        this.cifDesc = cifDesc;
    }

    /**
     * @return the tfsDocTypeDesc
     */
    public String getTfsDocTypeDesc()
    {
        return tfsDocTypeDesc;
    }

    /**
     * @param tfsDocTypeDesc the tfsDocTypeDesc to set
     */
    public void setTfsDocTypeDesc(String tfsDocTypeDesc)
    {
        this.tfsDocTypeDesc = tfsDocTypeDesc;
    }

    /**
     * @return the lgStatusDesc
     */
    public String getLgStatusDesc()
    {
        return lgStatusDesc;
    }

    /**
     * @param lgStatusDesc the lgStatusDesc to set
     */
    public void setLgStatusDesc(String lgStatusDesc)
    {
        this.lgStatusDesc = lgStatusDesc;
    }

}
