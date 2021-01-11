package com.path.vo.core.billcollection;

import java.math.BigDecimal;

import com.path.dbmaps.vo.TFSBILLVO;
import com.path.dbmaps.vo.TFSTRXVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * BillCollectionCO.java used to hold complex objects of Bill
 */
public class BillCollectionCO extends RetailBaseVO
{
    private TFSBILLVO tfsBillVO = new TFSBILLVO();
    private TFSTRXVO tfsTrxVO = new TFSTRXVO();
    private String bankName;
    private String customerName;
    private String cyBriefDesc;
    private String billSetlTypeDesc;
    private String tfsDocTypeDesc;
    private String billStatusDesc;
    private String cyDecimalPt;
    private String billDate;
    
    // kaldanaf - ABAR130110 - add values needed for charges amendment
    private BigDecimal outstandingMarginAmount;

    public String getBillDate()
    {
        return billDate;
    }

    public void setBillDate(String billDate)
    {
        this.billDate = billDate;
    }

    /**
     * @return the tfsBillVO
     */
    public TFSBILLVO getTfsBillVO()
    {
        return tfsBillVO;
    }

    /**
     * @param tfsBillVO the tfsBillVO to set
     */
    public void setTfsBillVO(TFSBILLVO tfsBillVO)
    {
        this.tfsBillVO = tfsBillVO;
    }

    /**
     * @return the bankName
     */
    public String getBankName()
    {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName()
    {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
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
     * @return the billSetlTypeDesc
     */
    public String getBillSetlTypeDesc()
    {
        return billSetlTypeDesc;
    }

    /**
     * @param billSetlTypeDesc the billSetlTypeDesc to set
     */
    public void setBillSetlTypeDesc(String billSetlTypeDesc)
    {
        this.billSetlTypeDesc = billSetlTypeDesc;
    }

    /**
     * @return the billStatusDesc
     */
    public String getBillStatusDesc()
    {
        return billStatusDesc;
    }

    /**
     * @param billStatusDesc the billStatusDesc to set
     */
    public void setBillStatusDesc(String billStatusDesc)
    {
        this.billStatusDesc = billStatusDesc;
    }

    /**
     * @return the cyDecimalPt
     */
    public String getCyDecimalPt()
    {
        return cyDecimalPt;
    }

    public TFSTRXVO getTfsTrxVO()
    {
        return tfsTrxVO;
    }

    public void setTfsTrxVO(TFSTRXVO tfsTrxVO)
    {
        this.tfsTrxVO = tfsTrxVO;
    }

    /**
     * @param cyDecimalPt the cyDecimalPt to set
     */
    public void setCyDecimalPt(String cyDecimalPt)
    {
        this.cyDecimalPt = cyDecimalPt;
    }

    public BigDecimal getOutstandingMarginAmount()
    {
        return outstandingMarginAmount;
    }

    public void setOutstandingMarginAmount(BigDecimal outstandingMarginAmount)
    {
        this.outstandingMarginAmount = outstandingMarginAmount;
    }

}
