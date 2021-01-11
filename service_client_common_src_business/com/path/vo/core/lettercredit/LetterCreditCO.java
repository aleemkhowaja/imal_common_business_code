package com.path.vo.core.lettercredit;

import java.math.BigDecimal;

import com.path.dbmaps.vo.TFSLC1VO;
import com.path.dbmaps.vo.TFSLC2VO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * LetterCreditCO.java used to hold complex objects of LC
 */
public class LetterCreditCO extends RetailBaseVO
{
    private TFSLC1VO tfsLc1VO = new TFSLC1VO();
    private TFSLC2VO tfsLc2VO = new TFSLC2VO();

    private BigDecimal totalShipAmt;
    private BigDecimal setlAmt;
    private BigDecimal totalShipGuarantAmt;
    private BigDecimal partialShipAllowed;
    private BigDecimal creditAvail;
    private String cyDesc;
    private BigDecimal cyDecimalPt;
    private String cifDesc;
    private String tfsDocTypeDesc;
    private String lcStatusDesc;
    private String lcRefTypeDesc; 
    private String setlMethodDesc;
    private String lcRefNbrDesc;
    
    // kaldanaf - ABAR130110 - add values needed for charges amendment
    private BigDecimal outstandingMarginAmount;

    /**
     * @return the tfsLc1VO
     */
    public TFSLC1VO getTfsLc1VO()
    {
        return tfsLc1VO;
    }

    /**
     * @param tfsLc1VO the tfsLc1VO to set
     */
    public void setTfsLc1VO(TFSLC1VO tfsLc1VO)
    {
        this.tfsLc1VO = tfsLc1VO;
    }

    /**
     * @return the tfsLc2VO
     */
    public TFSLC2VO getTfsLc2VO()
    {
        return tfsLc2VO;
    }

    /**
     * @param tfsLc2VO the tfsLc2VO to set
     */
    public void setTfsLc2VO(TFSLC2VO tfsLc2VO)
    {
        this.tfsLc2VO = tfsLc2VO;
    }

    /**
     * @return the totalShipAmt
     */
    public BigDecimal getTotalShipAmt()
    {
        return totalShipAmt;
    }

    /**
     * @param totalShipAmt the totalShipAmt to set
     */
    public void setTotalShipAmt(BigDecimal totalShipAmt)
    {
        this.totalShipAmt = totalShipAmt;
    }

    /**
     * @return the setlAmt
     */
    public BigDecimal getSetlAmt()
    {
        return setlAmt;
    }

    /**
     * @param setlAmt the setlAmt to set
     */
    public void setSetlAmt(BigDecimal setlAmt)
    {
        this.setlAmt = setlAmt;
    }

    /**
     * @return the totalShipGuarantAmt
     */
    public BigDecimal getTotalShipGuarantAmt()
    {
        return totalShipGuarantAmt;
    }

    /**
     * @param totalShipGuarantAmt the totalShipGuarantAmt to set
     */
    public void setTotalShipGuarantAmt(BigDecimal totalShipGuarantAmt)
    {
        this.totalShipGuarantAmt = totalShipGuarantAmt;
    }

    /**
     * @return the partialShipAllowed
     */
    public BigDecimal getPartialShipAllowed()
    {
        return partialShipAllowed;
    }

    /**
     * @param partialShipAllowed the partialShipAllowed to set
     */
    public void setPartialShipAllowed(BigDecimal partialShipAllowed)
    {
        this.partialShipAllowed = partialShipAllowed;
    }

    /**
     * @return the creditAvail
     */
    public BigDecimal getCreditAvail()
    {
        return creditAvail;
    }

    /**
     * @param creditAvail the creditAvail to set
     */
    public void setCreditAvail(BigDecimal creditAvail)
    {
        this.creditAvail = creditAvail;
    }

    /**
     * @return the cyDesc
     */
    public String getCyDesc()
    {
        return cyDesc;
    }

    /**
     * @param cyDesc the cyDesc to set
     */
    public void setCyDesc(String cyDesc)
    {
        this.cyDesc = cyDesc;
    }

    /**
     * @return the cyDecimalPt
     */
    public BigDecimal getCyDecimalPt()
    {
        return cyDecimalPt;
    }

    /**
     * @param cyDecimalPt the cyDecimalPt to set
     */
    public void setCyDecimalPt(BigDecimal cyDecimalPt)
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
     * @return the lcStatusDesc
     */
    public String getLcStatusDesc()
    {
        return lcStatusDesc;
    }

    /**
     * @param lcStatusDesc the lcStatusDesc to set
     */
    public void setLcStatusDesc(String lcStatusDesc)
    {
        this.lcStatusDesc = lcStatusDesc;
    }

    /**
     * @return the lcRefTypeDesc
     */
    public String getLcRefTypeDesc()
    {
        return lcRefTypeDesc;
    }

    /**
     * @param lcRefTypeDesc the lcRefTypeDesc to set
     */
    public void setLcRefTypeDesc(String lcRefTypeDesc)
    {
        this.lcRefTypeDesc = lcRefTypeDesc;
    }

    /**
     * @return the setlMethodDesc
     */
    public String getSetlMethodDesc()
    {
        return setlMethodDesc;
    }

    /**
     * @param setlMethodDesc the setlMethodDesc to set
     */
    public void setSetlMethodDesc(String setlMethodDesc)
    {
        this.setlMethodDesc = setlMethodDesc;
    }

    /**
     * @return the lcRefNbrDesc
     */
    public String getLcRefNbrDesc()
    {
        return lcRefNbrDesc;
    }

    /**
     * @param lcRefNbrDesc the lcRefNbrDesc to set
     */
    public void setLcRefNbrDesc(String lcRefNbrDesc)
    {
        this.lcRefNbrDesc = lcRefNbrDesc;
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
