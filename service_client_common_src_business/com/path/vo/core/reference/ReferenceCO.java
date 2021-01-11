package com.path.vo.core.reference;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.TRSDEALVO;
import com.path.dbmaps.vo.TRS_FX_LINKED_UTILIZATIONVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 */
public class ReferenceCO extends BaseVO
{
    private String LC_TYPE;
    private BigDecimal LC_NBR;
    private BigDecimal LC_REFERENCE_NBR;
    private String LC_STATUS;
    private String LC_REFERENCE_TYPE;
    private BigDecimal LC_REFERENCE_TIME;
    private BigDecimal LC_REFERENCE_YEAR;
    private BigDecimal CIF;
    private Date APPLICATION_DATE;
    private Date DOC_DATE;
    private Date VALIDITY_FROM;
    private Date VALIDITY_TO;
    private BigDecimal LC_CURRENCY;
    private BigDecimal LC_AMOUNT;
    private BigDecimal MARGIN_REQUIRED;
    private BigDecimal TOTAL_SHIPMENT_AMOUNT;
    private BigDecimal SETTLEMENT_AMOUNT;
    private BigDecimal TOTAL_SHIPPING_GUARANTEE_AMT;
    private BigDecimal PARTIAL_SHIPMENTS_ALLOWED;
    private String CREDIT_AVAILABILITY;
    private BigDecimal DECIMAL_POINTS;
    private String BRIEF_DESC_ENG;
    private String SHORT_NAME_ENG;
    private String SETTLEMENT_METHOD;
    private BigDecimal SERIAL_NO;
    private Date VALUE_DATE;
    private Date MATURITY_DATE;
    private BigDecimal CIF_NO;
    private String BILL_TYPE;
    private BigDecimal LG_NBR;
    private BigDecimal REQUISITION_NBR;
    private String LG_STATUS;
    private BigDecimal CURRENCY;
    private BigDecimal AMOUNT;
    private BigDecimal DOC_NUMBER;
    private BigDecimal DOC_YEAR;
    private String BRIEF_NAME_ENG;
    private BigDecimal BILL_NBR;
    private Date BILL_DATE;

    // FxDeal Lookup
    private TRSDEALVO trsDealVO = new TRSDEALVO();
    private TRS_FX_LINKED_UTILIZATIONVO trsFxLinkedUtilizationVO = new TRS_FX_LINKED_UTILIZATIONVO();
    private String otherCyDesc;
    private BigDecimal otherCyDecPnts;
    private String dealCyDesc;
    private BigDecimal dealCyDecPnts;
    private BigDecimal outstandSold;
    private BigDecimal outstandBought;

    public String getLC_TYPE()
    {
        return LC_TYPE;
    }

    public void setLC_TYPE(String lCTYPE)
    {
        LC_TYPE = lCTYPE;
    }

    public BigDecimal getLC_NBR()
    {
        return LC_NBR;
    }

    public void setLC_NBR(BigDecimal lCNBR)
    {
        LC_NBR = lCNBR;
    }

    public BigDecimal getLC_REFERENCE_NBR()
    {
        return LC_REFERENCE_NBR;
    }

    public void setLC_REFERENCE_NBR(BigDecimal lCREFERENCENBR)
    {
        LC_REFERENCE_NBR = lCREFERENCENBR;
    }

    public String getLC_STATUS()
    {
        return LC_STATUS;
    }

    public void setLC_STATUS(String lCSTATUS)
    {
        LC_STATUS = lCSTATUS;
    }

    public String getLC_REFERENCE_TYPE()
    {
        return LC_REFERENCE_TYPE;
    }

    public void setLC_REFERENCE_TYPE(String lCREFERENCETYPE)
    {
        LC_REFERENCE_TYPE = lCREFERENCETYPE;
    }

    public BigDecimal getLC_REFERENCE_TIME()
    {
        return LC_REFERENCE_TIME;
    }

    public void setLC_REFERENCE_TIME(BigDecimal lCREFERENCETIME)
    {
        LC_REFERENCE_TIME = lCREFERENCETIME;
    }

    public BigDecimal getLC_REFERENCE_YEAR()
    {
        return LC_REFERENCE_YEAR;
    }

    public void setLC_REFERENCE_YEAR(BigDecimal lCREFERENCEYEAR)
    {
        LC_REFERENCE_YEAR = lCREFERENCEYEAR;
    }

    public BigDecimal getCIF()
    {
        return CIF;
    }

    public void setCIF(BigDecimal cIF)
    {
        CIF = cIF;
    }

    public Date getAPPLICATION_DATE()
    {
        return APPLICATION_DATE;
    }

    public void setAPPLICATION_DATE(Date aPPLICATIONDATE)
    {
        APPLICATION_DATE = aPPLICATIONDATE;
    }

    public Date getVALIDITY_FROM()
    {
        return VALIDITY_FROM;
    }

    public void setVALIDITY_FROM(Date vALIDITYFROM)
    {
        VALIDITY_FROM = vALIDITYFROM;
    }

    public Date getVALIDITY_TO()
    {
        return VALIDITY_TO;
    }

    public void setVALIDITY_TO(Date vALIDITYTO)
    {
        VALIDITY_TO = vALIDITYTO;
    }

    public BigDecimal getLC_CURRENCY()
    {
        return LC_CURRENCY;
    }

    public void setLC_CURRENCY(BigDecimal lCCURRENCY)
    {
        LC_CURRENCY = lCCURRENCY;
    }

    public BigDecimal getLC_AMOUNT()
    {
        return LC_AMOUNT;
    }

    public void setLC_AMOUNT(BigDecimal lCAMOUNT)
    {
        LC_AMOUNT = lCAMOUNT;
    }

    public BigDecimal getMARGIN_REQUIRED()
    {
        return MARGIN_REQUIRED;
    }

    public void setMARGIN_REQUIRED(BigDecimal mARGINREQUIRED)
    {
        MARGIN_REQUIRED = mARGINREQUIRED;
    }

    public BigDecimal getTOTAL_SHIPMENT_AMOUNT()
    {
        return TOTAL_SHIPMENT_AMOUNT;
    }

    public void setTOTAL_SHIPMENT_AMOUNT(BigDecimal tOTALSHIPMENTAMOUNT)
    {
        TOTAL_SHIPMENT_AMOUNT = tOTALSHIPMENTAMOUNT;
    }

    public BigDecimal getSETTLEMENT_AMOUNT()
    {
        return SETTLEMENT_AMOUNT;
    }

    public void setSETTLEMENT_AMOUNT(BigDecimal sETTLEMENTAMOUNT)
    {
        SETTLEMENT_AMOUNT = sETTLEMENTAMOUNT;
    }

    public BigDecimal getTOTAL_SHIPPING_GUARANTEE_AMT()
    {
        return TOTAL_SHIPPING_GUARANTEE_AMT;
    }

    public void setTOTAL_SHIPPING_GUARANTEE_AMT(BigDecimal tOTALSHIPPINGGUARANTEEAMT)
    {
        TOTAL_SHIPPING_GUARANTEE_AMT = tOTALSHIPPINGGUARANTEEAMT;
    }

    public BigDecimal getPARTIAL_SHIPMENTS_ALLOWED()
    {
        return PARTIAL_SHIPMENTS_ALLOWED;
    }

    public void setPARTIAL_SHIPMENTS_ALLOWED(BigDecimal pARTIALSHIPMENTSALLOWED)
    {
        PARTIAL_SHIPMENTS_ALLOWED = pARTIALSHIPMENTSALLOWED;
    }

    public String getCREDIT_AVAILABILITY()
    {
        return CREDIT_AVAILABILITY;
    }

    public void setCREDIT_AVAILABILITY(String cREDITAVAILABILITY)
    {
        CREDIT_AVAILABILITY = cREDITAVAILABILITY;
    }

    public BigDecimal getDECIMAL_POINTS()
    {
        return DECIMAL_POINTS;
    }

    public void setDECIMAL_POINTS(BigDecimal dECIMALPOINTS)
    {
        DECIMAL_POINTS = dECIMALPOINTS;
    }

    public String getBRIEF_DESC_ENG()
    {
        return BRIEF_DESC_ENG;
    }

    public void setBRIEF_DESC_ENG(String bRIEFDESCENG)
    {
        BRIEF_DESC_ENG = bRIEFDESCENG;
    }

    public String getSHORT_NAME_ENG()
    {
        return SHORT_NAME_ENG;
    }

    public void setSHORT_NAME_ENG(String sHORTNAMEENG)
    {
        SHORT_NAME_ENG = sHORTNAMEENG;
    }

    public String getSETTLEMENT_METHOD()
    {
        return SETTLEMENT_METHOD;
    }

    public void setSETTLEMENT_METHOD(String sETTLEMENTMETHOD)
    {
        SETTLEMENT_METHOD = sETTLEMENTMETHOD;
    }

    public BigDecimal getSERIAL_NO()
    {
        return SERIAL_NO;
    }

    public void setSERIAL_NO(BigDecimal sERIALNO)
    {
        SERIAL_NO = sERIALNO;
    }

    public Date getVALUE_DATE()
    {
        return VALUE_DATE;
    }

    public void setVALUE_DATE(Date vALUEDATE)
    {
        VALUE_DATE = vALUEDATE;
    }

    public Date getMATURITY_DATE()
    {
        return MATURITY_DATE;
    }

    public void setMATURITY_DATE(Date mATURITYDATE)
    {
        MATURITY_DATE = mATURITYDATE;
    }

    public BigDecimal getCIF_NO()
    {
        return CIF_NO;
    }

    public void setCIF_NO(BigDecimal cIFNO)
    {
        CIF_NO = cIFNO;
    }

    public String getBILL_TYPE()
    {
        return BILL_TYPE;
    }

    public void setBILL_TYPE(String bILLTYPE)
    {
        BILL_TYPE = bILLTYPE;
    }

    public Date getDOC_DATE()
    {
        return DOC_DATE;
    }

    public void setDOC_DATE(Date dOCDATE)
    {
        DOC_DATE = dOCDATE;
    }

    public BigDecimal getLG_NBR()
    {
        return LG_NBR;
    }

    public void setLG_NBR(BigDecimal lGNBR)
    {
        LG_NBR = lGNBR;
    }

    public BigDecimal getREQUISITION_NBR()
    {
        return REQUISITION_NBR;
    }

    public void setREQUISITION_NBR(BigDecimal rEQUISITIONNBR)
    {
        REQUISITION_NBR = rEQUISITIONNBR;
    }

    public String getLG_STATUS()
    {
        return LG_STATUS;
    }

    public void setLG_STATUS(String lGSTATUS)
    {
        LG_STATUS = lGSTATUS;
    }

    public BigDecimal getCURRENCY()
    {
        return CURRENCY;
    }

    public void setCURRENCY(BigDecimal cURRENCY)
    {
        CURRENCY = cURRENCY;
    }

    public BigDecimal getAMOUNT()
    {
        return AMOUNT;
    }

    public void setAMOUNT(BigDecimal aMOUNT)
    {
        AMOUNT = aMOUNT;
    }

    public BigDecimal getDOC_NUMBER()
    {
        return DOC_NUMBER;
    }

    public void setDOC_NUMBER(BigDecimal dOCNUMBER)
    {
        DOC_NUMBER = dOCNUMBER;
    }

    public BigDecimal getDOC_YEAR()
    {
        return DOC_YEAR;
    }

    public void setDOC_YEAR(BigDecimal dOCYEAR)
    {
        DOC_YEAR = dOCYEAR;
    }

    public String getBRIEF_NAME_ENG()
    {
        return BRIEF_NAME_ENG;
    }

    public void setBRIEF_NAME_ENG(String bRIEFNAMEENG)
    {
        BRIEF_NAME_ENG = bRIEFNAMEENG;
    }

    public BigDecimal getBILL_NBR()
    {
        return BILL_NBR;
    }

    public void setBILL_NBR(BigDecimal bILLNBR)
    {
        BILL_NBR = bILLNBR;
    }

    public Date getBILL_DATE()
    {
        return BILL_DATE;
    }

    public void setBILL_DATE(Date bILLDATE)
    {
        BILL_DATE = bILLDATE;
    }

    /**
     * @return the trsDealVO
     */
    public TRSDEALVO getTrsDealVO()
    {
        return trsDealVO;
    }

    /**
     * @param trsDealVO the trsDealVO to set
     */
    public void setTrsDealVO(TRSDEALVO trsDealVO)
    {
        this.trsDealVO = trsDealVO;
    }

    /**
     * @return the trsFxLinkedUtilizationVO
     */
    public TRS_FX_LINKED_UTILIZATIONVO getTrsFxLinkedUtilizationVO()
    {
        return trsFxLinkedUtilizationVO;
    }

    /**
     * @param trsFxLinkedUtilizationVO the trsFxLinkedUtilizationVO to set
     */
    public void setTrsFxLinkedUtilizationVO(TRS_FX_LINKED_UTILIZATIONVO trsFxLinkedUtilizationVO)
    {
        this.trsFxLinkedUtilizationVO = trsFxLinkedUtilizationVO;
    }

    /**
     * @return the otherCyDesc
     */
    public String getOtherCyDesc()
    {
        return otherCyDesc;
    }

    /**
     * @param otherCyDesc the otherCyDesc to set
     */
    public void setOtherCyDesc(String otherCyDesc)
    {
        this.otherCyDesc = otherCyDesc;
    }

    /**
     * @return the otherCyDecPnts
     */
    public BigDecimal getOtherCyDecPnts()
    {
        return otherCyDecPnts;
    }

    /**
     * @param otherCyDecPnts the otherCyDecPnts to set
     */
    public void setOtherCyDecPnts(BigDecimal otherCyDecPnts)
    {
        this.otherCyDecPnts = otherCyDecPnts;
    }

    /**
     * @return the dealCyDesc
     */
    public String getDealCyDesc()
    {
        return dealCyDesc;
    }

    /**
     * @param dealCyDesc the dealCyDesc to set
     */
    public void setDealCyDesc(String dealCyDesc)
    {
        this.dealCyDesc = dealCyDesc;
    }

    /**
     * @return the dealCyDecPnts
     */
    public BigDecimal getDealCyDecPnts()
    {
        return dealCyDecPnts;
    }

    /**
     * @param dealCyDecPnts the dealCyDecPnts to set
     */
    public void setDealCyDecPnts(BigDecimal dealCyDecPnts)
    {
        this.dealCyDecPnts = dealCyDecPnts;
    }

    /**
     * @return the outstandSold
     */
    public BigDecimal getOutstandSold()
    {
        return outstandSold;
    }

    /**
     * @param outstandSold the outstandSold to set
     */
    public void setOutstandSold(BigDecimal outstandSold)
    {
        this.outstandSold = outstandSold;
    }

    /**
     * @return the outstandBought
     */
    public BigDecimal getOutstandBought()
    {
        return outstandBought;
    }

    /**
     * @param outstandBought the outstandBought to set
     */
    public void setOutstandBought(BigDecimal outstandBought)
    {
        this.outstandBought = outstandBought;
    }
}
