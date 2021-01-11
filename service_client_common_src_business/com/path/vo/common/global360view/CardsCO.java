/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSCARDS_MGTVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * CardsCO.java used to
 */
public class CardsCO extends RetailBaseVO
{
    private CTSCARDS_MGTVO ctsCardsMGTVO = new CTSCARDS_MGTVO();
    private AMFVO amfVO = new AMFVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private BigDecimal banch_code;
    private String maskedCardNo;
    private String     primary_suplementary;
    private String     card_type;
    private Date       expiry_date;
    private String     status;
    private String     credit_type;
    private Double     payment_perc;
    private BigDecimal acc_br;
    private BigDecimal acc_cy;
    private BigDecimal acc_gl;
    private BigDecimal acc_cif;
    private BigDecimal acc_sl;
    
    /**
     * @return the banch_code
     */
    public BigDecimal getBanch_code()
    {
        return banch_code;
    }
    /**
     * @param banchCode the banch_code to set
     */
    public void setBanch_code(BigDecimal banchCode)
    {
        banch_code = banchCode;
    }
    /**
     * @return the primary_suplementary
     */
    public String getPrimary_suplementary()
    {
        return primary_suplementary;
    }
    /**
     * @param primarySuplementary the primary_suplementary to set
     */
    public void setPrimary_suplementary(String primarySuplementary)
    {
        primary_suplementary = primarySuplementary;
    }
    /**
     * @return the card_type
     */
    public String getCard_type()
    {
        return card_type;
    }
    /**
     * @param cardType the card_type to set
     */
    public void setCard_type(String cardType)
    {
        card_type = cardType;
    }
    /**
     * @return the expiry_date
     */
    public Date getExpiry_date()
    {
        return expiry_date;
    }
    /**
     * @param expiryDate the expiry_date to set
     */
    public void setExpiry_date(Date expiryDate)
    {
        expiry_date = expiryDate;
    }
    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
    /**
     * @return the credit_type
     */
    public String getCredit_type()
    {
        return credit_type;
    }
    /**
     * @param creditType the credit_type to set
     */
    public void setCredit_type(String creditType)
    {
        credit_type = creditType;
    }
    /**
     * @return the payment_perc
     */
    public Double getPayment_perc()
    {
        return payment_perc;
    }
    /**
     * @param paymentPerc the payment_perc to set
     */
    public void setPayment_perc(Double paymentPerc)
    {
        payment_perc = paymentPerc;
    }
    /**
     * @return the acc_br
     */
    public BigDecimal getAcc_br()
    {
        return acc_br;
    }
    /**
     * @param accBr the acc_br to set
     */
    public void setAcc_br(BigDecimal accBr)
    {
        acc_br = accBr;
    }
    /**
     * @return the acc_cy
     */
    public BigDecimal getAcc_cy()
    {
        return acc_cy;
    }
    /**
     * @param accCy the acc_cy to set
     */
    public void setAcc_cy(BigDecimal accCy)
    {
        acc_cy = accCy;
    }
    /**
     * @return the acc_gl
     */
    public BigDecimal getAcc_gl()
    {
        return acc_gl;
    }
    /**
     * @param accGl the acc_gl to set
     */
    public void setAcc_gl(BigDecimal accGl)
    {
        acc_gl = accGl;
    }
    /**
     * @return the acc_cif
     */
    public BigDecimal getAcc_cif()
    {
        return acc_cif;
    }
    /**
     * @param accCif the acc_cif to set
     */
    public void setAcc_cif(BigDecimal accCif)
    {
        acc_cif = accCif;
    }
    /**
     * @return the acc_sl
     */
    public BigDecimal getAcc_sl()
    {
        return acc_sl;
    }
    /**
     * @param accSl the acc_sl to set
     */
    public void setAcc_sl(BigDecimal accSl)
    {
        acc_sl = accSl;
    }
    public CTSCARDS_MGTVO getCtsCardsMGTVO()
    {
        return ctsCardsMGTVO;
    }
    public void setCtsCardsMGTVO(CTSCARDS_MGTVO ctsCardsMGTVO)
    {
        this.ctsCardsMGTVO = ctsCardsMGTVO;
    }
    public AMFVO getAmfVO()
    {
        return amfVO;
    }
    public void setAmfVO(AMFVO amfVO)
    {
        this.amfVO = amfVO;
    }
    public String getMaskedCardNo()
    {
        return maskedCardNo;
    }
    public void setMaskedCardNo(String maskedCardNo)
    {
        this.maskedCardNo = maskedCardNo;
    }
    public CTSTELLERVO getCtsTellerVO()
    {
        return ctsTellerVO;
    }
    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
        this.ctsTellerVO = ctsTellerVO;
    } 
}
