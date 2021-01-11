/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSTRSVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashVoidChequesCO.java used to
 */
public class DashChequesServicesCO extends RetailBaseVO
{
    private AMFVO amfVO = new AMFVO();
    private CTSTRSVO ctstrsVO = new CTSTRSVO(); 
    private BigDecimal branch_code;
    private BigDecimal trx_no;
    private BigDecimal trs_no;
    private BigDecimal trs_acc_br;
    private BigDecimal trs_acc_cy;
    private BigDecimal trs_acc_gl;
    private BigDecimal trs_acc_cif;
    private BigDecimal trs_acc_sl;
  
    private BigDecimal trs_acc_add_ref;
    private BigDecimal amount;
    private BigDecimal cv_amount;
    private String     trx_type;
    private String     trs_currency;
    private String     void_reason;
    private Date       trx_date;
    private Date       value_date;
    private Date       cheque_date;
    private Date       date_voided;
    private BigDecimal decimal_points;
    /**
     * @return the branch_code
     */
    public BigDecimal getBranch_code()
    {
        return branch_code;
    }
    /**
     * @param branchCode the branch_code to set
     */
    public void setBranch_code(BigDecimal branchCode)
    {
        branch_code = branchCode;
    }
    /**
     * @return the trx_no
     */
    public BigDecimal getTrx_no()
    {
        return trx_no;
    }
    /**
     * @param trxNo the trx_no to set
     */
    public void setTrx_no(BigDecimal trxNo)
    {
        trx_no = trxNo;
    }
    /**
     * @return the trx_type
     */
    public String getTrx_type()
    {
        return trx_type;
    }
    /**
     * @param trxType the trx_type to set
     */
    public void setTrx_type(String trxType)
    {
        trx_type = trxType;
    }
    /**
     * @return the trx_date
     */
    public Date getTrx_date()
    {
        return trx_date;
    }
    /**
     * @param trxDate the trx_date to set
     */
    public void setTrx_date(Date trxDate)
    {
        trx_date = trxDate;
    }
    /**
     * @return the value_date
     */
    public Date getValue_date()
    {
        return value_date;
    }
    /**
     * @param valueDate the value_date to set
     */
    public void setValue_date(Date valueDate)
    {
        value_date = valueDate;
    }
    /**
     * @return the trs_acc_br
     */
    public BigDecimal getTrs_acc_br()
    {
        return trs_acc_br;
    }
    /**
     * @param trsAccBr the trs_acc_br to set
     */
    public void setTrs_acc_br(BigDecimal trsAccBr)
    {
        trs_acc_br = trsAccBr;
    }
    /**
     * @return the trs_acc_cy
     */
    public BigDecimal getTrs_acc_cy()
    {
        return trs_acc_cy;
    }
    /**
     * @param trsAccCy the trs_acc_cy to set
     */
    public void setTrs_acc_cy(BigDecimal trsAccCy)
    {
        trs_acc_cy = trsAccCy;
    }
    /**
     * @return the trs_acc_gl
     */
    public BigDecimal getTrs_acc_gl()
    {
        return trs_acc_gl;
    }
    /**
     * @param trsAccGl the trs_acc_gl to set
     */
    public void setTrs_acc_gl(BigDecimal trsAccGl)
    {
        trs_acc_gl = trsAccGl;
    }
    /**
     * @return the trs_acc_cif
     */
    public BigDecimal getTrs_acc_cif()
    {
        return trs_acc_cif;
    }
    /**
     * @param trsAccCif the trs_acc_cif to set
     */
    public void setTrs_acc_cif(BigDecimal trsAccCif)
    {
        trs_acc_cif = trsAccCif;
    }
    /**
     * @return the trs_acc_sl
     */
    public BigDecimal getTrs_acc_sl()
    {
        return trs_acc_sl;
    }
    /**
     * @param trsAccSl the trs_acc_sl to set
     */
    public void setTrs_acc_sl(BigDecimal trsAccSl)
    {
        trs_acc_sl = trsAccSl;
    }
    /**
     * @return the trs_acc_add_ref
     */
    public BigDecimal getTrs_acc_add_ref()
    {
        return trs_acc_add_ref;
    }
    /**
     * @param trsAccAddRef the trs_acc_add_ref to set
     */
    public void setTrs_acc_add_ref(BigDecimal trsAccAddRef)
    {
        trs_acc_add_ref = trsAccAddRef;
    }
    /**
     * @return the trs_currency
     */
    public String getTrs_currency()
    {
        return trs_currency;
    }
    /**
     * @param trsCurrency the trs_currency to set
     */
    public void setTrs_currency(String trsCurrency)
    {
        trs_currency = trsCurrency;
    }
    /**
     * @return the amount
     */
    public BigDecimal getAmount()
    {
        return amount;
    }
    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
    /**
     * @return the cv_amount
     */
    public BigDecimal getCv_amount()
    {
        return cv_amount;
    }
    /**
     * @param cvAmount the cv_amount to set
     */
    public void setCv_amount(BigDecimal cvAmount)
    {
        cv_amount = cvAmount;
    }
    /**
     * @return the void_reason
     */
    public String getVoid_reason()
    {
        return void_reason;
    }
    /**
     * @param voidReason the void_reason to set
     */
    public void setVoid_reason(String voidReason)
    {
        void_reason = voidReason;
    }
    /**
     * @return the date_voided
     */
    public Date getDate_voided()
    {
        return date_voided;
    }
    /**
     * @param dateVoided the date_voided to set
     */
    public void setDate_voided(Date dateVoided)
    {
        date_voided = dateVoided;
    }
    /**
     * @return the decimal_points
     */
    public BigDecimal getDecimal_points()
    {
        return decimal_points;
    }
    /**
     * @param decimalPoints the decimal_points to set
     */
    public void setDecimal_points(BigDecimal decimalPoints)
    {
        decimal_points = decimalPoints;
    }
    /**
     * @return the cheque_date
     */
    public Date getCheque_date()
    {
        return cheque_date;
    }
    /**
     * @param chequeDate the cheque_date to set
     */
    public void setCheque_date(Date chequeDate)
    {
        cheque_date = chequeDate;
    }
    public AMFVO getAmfVO()
    {
        return amfVO;
    }
    public void setAmfVO(AMFVO amfVO)
    {
        this.amfVO = amfVO;
    }
    public CTSTRSVO getCtstrsVO()
    {
        return ctstrsVO;
    }
    public void setCtstrsVO(CTSTRSVO ctstrsVO)
    {
        this.ctstrsVO = ctstrsVO;
    }
    public BigDecimal getTrs_no()
    {
        return trs_no;
    }
    public void setTrs_no(BigDecimal trsNo)
    {
        trs_no = trsNo;
    }
}
