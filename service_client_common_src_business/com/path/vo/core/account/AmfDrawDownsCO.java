/**
 * 
 */
package com.path.vo.core.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.AMF_DRAWDOWNSVO;
import com.path.dbmaps.vo.AMF_POINT_ACCRUALS_DETVO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          AmfDrawDownsCO.java used to
 */
public class AmfDrawDownsCO implements Serializable
{
    private AMF_DRAWDOWNSVO amfDrawdownsVO = new AMF_DRAWDOWNSVO();
    private List<AmfDrawDownsCO> drawDownList = new ArrayList<AmfDrawDownsCO>();
    private String longNameEng;
    //#309981 - IDBI140007
    private String drawDownsVisibility;
    //Hala Al Sheikh - SBI170059 SBI170060
    private String profitDetails;
    private AMF_POINT_ACCRUALS_DETVO amfPointAccrualsDetVO = new AMF_POINT_ACCRUALS_DETVO();
    private BigDecimal unsettledProfit;
    private BigDecimal unsettledPenalty;

    /**
     * @return the amfDrawdownsVO
     */
    public AMF_DRAWDOWNSVO getAmfDrawdownsVO()
    {
	return amfDrawdownsVO;
    }

    /**
     * @param amfDrawdownsVO the amfDrawdownsVO to set
     */
    public void setAmfDrawdownsVO(AMF_DRAWDOWNSVO amfDrawdownsVO)
    {
	this.amfDrawdownsVO = amfDrawdownsVO;
    }

    /**
     * @return the longNameEng
     */
    public String getLongNameEng()
    {
	return longNameEng;
    }

    /**
     * @param longNameEng the longNameEng to set
     */
    public void setLongNameEng(String longNameEng)
    {
	this.longNameEng = longNameEng;
    }

    public List<AmfDrawDownsCO> getDrawDownList()
    {
	return drawDownList;
    }

    public void setDrawDownList(List<AmfDrawDownsCO> drawDownList)
    {
	this.drawDownList = drawDownList;
    }

    public String getDrawDownsVisibility()
    {
        return drawDownsVisibility;
    }

    public void setDrawDownsVisibility(String drawDownsVisibility)
    {
        this.drawDownsVisibility = drawDownsVisibility;
    }

    public String getProfitDetails()
    {
        return profitDetails;
    }

    public void setProfitDetails(String profitDetails)
    {
        this.profitDetails = profitDetails;
    }

    public AMF_POINT_ACCRUALS_DETVO getAmfPointAccrualsDetVO()
    {
        return amfPointAccrualsDetVO;
    }

    public void setAmfPointAccrualsDetVO(AMF_POINT_ACCRUALS_DETVO amfPointAccrualsDetVO)
    {
        this.amfPointAccrualsDetVO = amfPointAccrualsDetVO;
    }

    public BigDecimal getUnsettledProfit()
    {
        return unsettledProfit;
    }

    public void setUnsettledProfit(BigDecimal unsettledProfit)
    {
        this.unsettledProfit = unsettledProfit;
    }

    public BigDecimal getUnsettledPenalty()
    {
        return unsettledPenalty;
    }

    public void setUnsettledPenalty(BigDecimal unsettledPenalty)
    {
        this.unsettledPenalty = unsettledPenalty;
    }
}
