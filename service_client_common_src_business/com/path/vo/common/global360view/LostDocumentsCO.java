/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSLOSTFOUNDVO;
import com.path.dbmaps.vo.CTS_LOSTDOCVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * LostDocumentsCO.java used to
 */
public class LostDocumentsCO extends RetailBaseVO
{
    private CTSLOSTFOUNDVO ctsLostFoundVO = new CTSLOSTFOUNDVO();
    private CTS_LOSTDOCVO ctsLostDocVO = new CTS_LOSTDOCVO();
    private AMFVO amfVO = new AMFVO();
    
    private String docTypeBriefName;
    private BigDecimal branch_code;
    private BigDecimal trx_no;
    private String     status;
    private BigDecimal acc_br;
    private BigDecimal acc_cy;
    private BigDecimal acc_gl;
    private BigDecimal acc_cif;
    private BigDecimal acc_sl;
    private BigDecimal doc_no;
    private BigDecimal to_doc_no;
    private Date       stop_date;
    private String     stop_reason;
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
    /**
     * @return the doc_no
     */
    public BigDecimal getDoc_no()
    {
        return doc_no;
    }
    /**
     * @param docNo the doc_no to set
     */
    public void setDoc_no(BigDecimal docNo)
    {
        doc_no = docNo;
    }
    /**
     * @return the to_doc_no
     */
    public BigDecimal getTo_doc_no()
    {
        return to_doc_no;
    }
    /**
     * @param toDocNo the to_doc_no to set
     */
    public void setTo_doc_no(BigDecimal toDocNo)
    {
        to_doc_no = toDocNo;
    }
    /**
     * @return the stop_date
     */
    public Date getStop_date()
    {
        return stop_date;
    }
    /**
     * @param stopDate the stop_date to set
     */
    public void setStop_date(Date stopDate)
    {
        stop_date = stopDate;
    }
    /**
     * @return the stop_reason
     */
    public String getStop_reason()
    {
        return stop_reason;
    }
    /**
     * @param stopReason the stop_reason to set
     */
    public void setStop_reason(String stopReason)
    {
        stop_reason = stopReason;
    }
    public CTSLOSTFOUNDVO getCtsLostFoundVO()
    {
        return ctsLostFoundVO;
    }
    public void setCtsLostFoundVO(CTSLOSTFOUNDVO ctsLostFoundVO)
    {
        this.ctsLostFoundVO = ctsLostFoundVO;
    }
    public CTS_LOSTDOCVO getCtsLostDocVO()
    {
        return ctsLostDocVO;
    }
    public void setCtsLostDocVO(CTS_LOSTDOCVO ctsLostDocVO)
    {
        this.ctsLostDocVO = ctsLostDocVO;
    }
    public String getDocTypeBriefName()
    {
        return docTypeBriefName;
    }
    public void setDocTypeBriefName(String docTypeBriefName)
    {
        this.docTypeBriefName = docTypeBriefName;
    }
    public AMFVO getAmfVO()
    {
        return amfVO;
    }
    public void setAmfVO(AMFVO amfVO)
    {
        this.amfVO = amfVO;
    }  
}
