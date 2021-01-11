/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTSTRSVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * BankersChequesCO.java used to
 */
public class BankersChequesCO extends RetailBaseVO
{
    private CTSTRSVO ctstrsVO = new  CTSTRSVO();
    private BigDecimal branch_code;
    private BigDecimal trx_no; 
    private String     trx_type;
    private String     trxTypeDesc;
    private BigDecimal from_acc_br;
    private BigDecimal from_acc_cy;
    private BigDecimal from_acc_gl;
    private BigDecimal from_acc_cif;
    private BigDecimal from_acc_sl;
    private BigDecimal from_acc_add_ref;
    private String     from_acc_name;
    private BigDecimal to_acc_br;
    private BigDecimal to_acc_cy;
    private BigDecimal to_acc_gl;
    private BigDecimal to_acc_cif;
    private BigDecimal to_acc_sl;
    private BigDecimal to_acc_add_ref;
    private String     to_acc_name;
    private BigDecimal amount;
    private Date       trx_date;
    private String     remittance_type;
    private String     remittance_status;
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
     * @return the from_acc_br
     */
    public BigDecimal getFrom_acc_br()
    {
        return from_acc_br;
    }
    /**
     * @param fromAccBr the from_acc_br to set
     */
    public void setFrom_acc_br(BigDecimal fromAccBr)
    {
        from_acc_br = fromAccBr;
    }
    /**
     * @return the from_acc_cy
     */
    public BigDecimal getFrom_acc_cy()
    {
        return from_acc_cy;
    }
    /**
     * @param fromAccCy the from_acc_cy to set
     */
    public void setFrom_acc_cy(BigDecimal fromAccCy)
    {
        from_acc_cy = fromAccCy;
    }
    /**
     * @return the from_acc_gl
     */
    public BigDecimal getFrom_acc_gl()
    {
        return from_acc_gl;
    }
    /**
     * @param fromAccGl the from_acc_gl to set
     */
    public void setFrom_acc_gl(BigDecimal fromAccGl)
    {
        from_acc_gl = fromAccGl;
    }
    /**
     * @return the from_acc_cif
     */
    public BigDecimal getFrom_acc_cif()
    {
        return from_acc_cif;
    }
    /**
     * @param fromAccCif the from_acc_cif to set
     */
    public void setFrom_acc_cif(BigDecimal fromAccCif)
    {
        from_acc_cif = fromAccCif;
    }
    /**
     * @return the from_acc_sl
     */
    public BigDecimal getFrom_acc_sl()
    {
        return from_acc_sl;
    }
    /**
     * @param fromAccSl the from_acc_sl to set
     */
    public void setFrom_acc_sl(BigDecimal fromAccSl)
    {
        from_acc_sl = fromAccSl;
    }
    /**
     * @return the from_acc_add_ref
     */
    public BigDecimal getFrom_acc_add_ref()
    {
        return from_acc_add_ref;
    }
    /**
     * @param fromAccAddRef the from_acc_add_ref to set
     */
    public void setFrom_acc_add_ref(BigDecimal fromAccAddRef)
    {
        from_acc_add_ref = fromAccAddRef;
    }
    /**
     * @return the to_acc_br
     */
    public BigDecimal getTo_acc_br()
    {
        return to_acc_br;
    }
    /**
     * @param toAccBr the to_acc_br to set
     */
    public void setTo_acc_br(BigDecimal toAccBr)
    {
        to_acc_br = toAccBr;
    }
    /**
     * @return the to_acc_cy
     */
    public BigDecimal getTo_acc_cy()
    {
        return to_acc_cy;
    }
    /**
     * @param toAccCy the to_acc_cy to set
     */
    public void setTo_acc_cy(BigDecimal toAccCy)
    {
        to_acc_cy = toAccCy;
    }
    /**
     * @return the to_acc_gl
     */
    public BigDecimal getTo_acc_gl()
    {
        return to_acc_gl;
    }
    /**
     * @param toAccGl the to_acc_gl to set
     */
    public void setTo_acc_gl(BigDecimal toAccGl)
    {
        to_acc_gl = toAccGl;
    }
    /**
     * @return the to_acc_cif
     */
    public BigDecimal getTo_acc_cif()
    {
        return to_acc_cif;
    }
    /**
     * @param toAccCif the to_acc_cif to set
     */
    public void setTo_acc_cif(BigDecimal toAccCif)
    {
        to_acc_cif = toAccCif;
    }
    /**
     * @return the to_acc_sl
     */
    public BigDecimal getTo_acc_sl()
    {
        return to_acc_sl;
    }
    /**
     * @param toAccSl the to_acc_sl to set
     */
    public void setTo_acc_sl(BigDecimal toAccSl)
    {
        to_acc_sl = toAccSl;
    }
    /**
     * @return the to_acc_add_ref
     */
    public BigDecimal getTo_acc_add_ref()
    {
        return to_acc_add_ref;
    }
    /**
     * @param toAccAddRef the to_acc_add_ref to set
     */
    public void setTo_acc_add_ref(BigDecimal toAccAddRef)
    {
        to_acc_add_ref = toAccAddRef;
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
     * @return the remittance_type
     */
    public String getRemittance_type()
    {
        return remittance_type;
    }
    /**
     * @param remittanceType the remittance_type to set
     */
    public void setRemittance_type(String remittanceType)
    {
        remittance_type = remittanceType;
    }
    /**
     * @return the remittance_status
     */
    public String getRemittance_status()
    {
        return remittance_status;
    }
    /**
     * @param remittanceStatus the remittance_status to set
     */
    public void setRemittance_status(String remittanceStatus)
    {
        remittance_status = remittanceStatus;
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
     * @return the trxTypeDesc
     */
    public String getTrxTypeDesc()
    {
        return trxTypeDesc;
    }
    /**
     * @param trxTypeDesc the trxTypeDesc to set
     */
    public void setTrxTypeDesc(String trxTypeDesc)
    {
        this.trxTypeDesc = trxTypeDesc;
    }
    public CTSTRSVO getCtstrsVO()
    {
        return ctstrsVO;
    }
    public void setCtstrsVO(CTSTRSVO ctstrsVO)
    {
        this.ctstrsVO = ctstrsVO;
    }
    public String getFrom_acc_name()
    {
        return from_acc_name;
    }
    public void setFrom_acc_name(String fromAccName)
    {
        from_acc_name = fromAccName;
    }
    public String getTo_acc_name()
    {
        return to_acc_name;
    }
    public void setTo_acc_name(String toAccName)
    {
        to_acc_name = toAccName;
    }
}
