package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTSTRS_SO_CHARGES_DETVO;
import com.path.vo.core.common.RetailBaseVO;

public class TrxMgntSOChargesCO  extends RetailBaseVO
{
    private CTSTRS_SO_CHARGES_DETVO ctstrsSOCHARGESDETVO;
    private CTSTRS_SO_CHARGES_DETVO tvaSOCHARGESDETVO;
    private CTSCHARGESVO            ctsChargesVO;
    
    private BigDecimal AMOUNT_FORMAT;
    private BigDecimal AMOUNT_NEW_FORMAT;
    private BigDecimal AMOUNT_FC_NEW_FORMAT;
    
    private BigDecimal tva_amount_FORMAT;
    private BigDecimal tva_amount_new_FORMAT;
    private BigDecimal tva_amount_fc_new_FORMAT;
    private String     BRIEF_NAME;
    
    
    public CTSTRS_SO_CHARGES_DETVO getCtstrsSOCHARGESDETVO()
    {
        return ctstrsSOCHARGESDETVO;
    }
    public void setCtstrsSOCHARGESDETVO(CTSTRS_SO_CHARGES_DETVO ctstrsSOCHARGESDETVO)
    {
        this.ctstrsSOCHARGESDETVO = ctstrsSOCHARGESDETVO;
    }
    public CTSTRS_SO_CHARGES_DETVO getTvaSOCHARGESDETVO()
    {
        return tvaSOCHARGESDETVO;
    }
    public void setTvaSOCHARGESDETVO(CTSTRS_SO_CHARGES_DETVO tvaSOCHARGESDETVO)
    {
        this.tvaSOCHARGESDETVO = tvaSOCHARGESDETVO;
    }
    public BigDecimal getAMOUNT_FORMAT()
    {
        return AMOUNT_FORMAT;
    }
    public void setAMOUNT_FORMAT(BigDecimal aMOUNTFORMAT)
    {
        AMOUNT_FORMAT = aMOUNTFORMAT;
    }
    public BigDecimal getAMOUNT_NEW_FORMAT()
    {
        return AMOUNT_NEW_FORMAT;
    }
    public void setAMOUNT_NEW_FORMAT(BigDecimal aMOUNTNEWFORMAT)
    {
        AMOUNT_NEW_FORMAT = aMOUNTNEWFORMAT;
    }
    public BigDecimal getAMOUNT_FC_NEW_FORMAT()
    {
        return AMOUNT_FC_NEW_FORMAT;
    }
    public void setAMOUNT_FC_NEW_FORMAT(BigDecimal aMOUNTFCNEWFORMAT)
    {
        AMOUNT_FC_NEW_FORMAT = aMOUNTFCNEWFORMAT;
    }
    public BigDecimal getTva_amount_FORMAT()
    {
        return tva_amount_FORMAT;
    }
    public void setTva_amount_FORMAT(BigDecimal tvaAmountFORMAT)
    {
        tva_amount_FORMAT = tvaAmountFORMAT;
    }
    public BigDecimal getTva_amount_new_FORMAT()
    {
        return tva_amount_new_FORMAT;
    }
    public void setTva_amount_new_FORMAT(BigDecimal tvaAmountNewFORMAT)
    {
        tva_amount_new_FORMAT = tvaAmountNewFORMAT;
    }
    public BigDecimal getTva_amount_fc_new_FORMAT()
    {
        return tva_amount_fc_new_FORMAT;
    }
    public void setTva_amount_fc_new_FORMAT(BigDecimal tvaAmountFcNewFORMAT)
    {
        tva_amount_fc_new_FORMAT = tvaAmountFcNewFORMAT;
    }
    /**
     * @return the ctsChargesVO
     */
    public CTSCHARGESVO getCtsChargesVO()
    {
        return ctsChargesVO;
    }
    /**
     * @param ctsChargesVO the ctsChargesVO to set
     */
    public void setCtsChargesVO(CTSCHARGESVO ctsChargesVO)
    {
        this.ctsChargesVO = ctsChargesVO;
    }
    /**
     * @return the bRIEF_NAME
     */
    public String getBRIEF_NAME()
    {
        return BRIEF_NAME;
    }
    /**
     * @param bRIEFNAME the bRIEF_NAME to set
     */
    public void setBRIEF_NAME(String bRIEFNAME)
    {
        BRIEF_NAME = bRIEFNAME;
    }
    
}
