/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTS_SAFEBOXVO;
import com.path.dbmaps.vo.CTS_SAFEBOX_PARAMVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: marwanmaddah
 * 
 *          SafeboxesCO.java used to
 */
public class SafeboxesCO extends RetailBaseVO
{
    CTS_SAFEBOX_PARAMVO ctsParamVO = new CTS_SAFEBOX_PARAMVO();
    CTS_SAFEBOXVO ctsSafeboxVO = new CTS_SAFEBOXVO();
    private BigDecimal branch_code;
    private BigDecimal trx_no;
    private String type;
    private BigDecimal safebox_no;
    private String location;
    private String statusdesc;
    private String statusTrx;
    private BigDecimal acc_br;
    private BigDecimal acc_cy;
    private BigDecimal acc_gl;
    private BigDecimal acc_cif;
    private BigDecimal acc_sl;
    private String acc_add_ref;
    private String accountName;
    private Date dateFrom;
    private Date dateTo;

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
     * @return the type
     */
    public String getType()
    {
	return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
	this.type = type;
    }

    /**
     * @return the safebox_no
     */
    public BigDecimal getSafebox_no()
    {
	return safebox_no;
    }

    /**
     * @param safeboxNo the safebox_no to set
     */
    public void setSafebox_no(BigDecimal safeboxNo)
    {
	safebox_no = safeboxNo;
    }

    /**
     * @return the location
     */
    public String getLocation()
    {
	return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location)
    {
	this.location = location;
    }

    /**
     * @return the statusdesc
     */
    public String getStatusdesc()
    {
	return statusdesc;
    }

    /**
     * @param statusdesc the statusdesc to set
     */
    public void setStatusdesc(String statusdesc)
    {
	this.statusdesc = statusdesc;
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
     * @return the accountName
     */
    public String getAccountName()
    {
	return accountName;
    }

    /**
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName)
    {
	this.accountName = accountName;
    }

    /**
     * @return the acc_add_ref
     */
    public String getAcc_add_ref()
    {
	return acc_add_ref;
    }

    /**
     * @param accAddRef the acc_add_ref to set
     */
    public void setAcc_add_ref(String accAddRef)
    {
	acc_add_ref = accAddRef;
    }

    /**
     * @return the dateFrom
     */
    public Date getDateFrom()
    {
	return dateFrom;
    }

    /**
     * @param dateFrom the dateFrom to set
     */
    public void setDateFrom(Date dateFrom)
    {
	this.dateFrom = dateFrom;
    }

    /**
     * @return the dateTo
     */
    public Date getDateTo()
    {
	return dateTo;
    }

    /**
     * @param dateTo the dateTo to set
     */
    public void setDateTo(Date dateTo)
    {
	this.dateTo = dateTo;
    }

    public CTS_SAFEBOX_PARAMVO getCtsParamVO()
    {
	return ctsParamVO;
    }

    public void setCtsParamVO(CTS_SAFEBOX_PARAMVO ctsParamVO)
    {
	this.ctsParamVO = ctsParamVO;
    }

    public CTS_SAFEBOXVO getCtsSafeboxVO()
    {
	return ctsSafeboxVO;
    }

    public void setCtsSafeboxVO(CTS_SAFEBOXVO ctsSafeboxVO)
    {
	this.ctsSafeboxVO = ctsSafeboxVO;
    }

    /**
     * @return the statusTrx
     */
    public String getStatusTrx()
    {
        return statusTrx;
    }

    /**
     * @param statusTrx the statusTrx to set
     */
    public void setStatusTrx(String statusTrx)
    {
        this.statusTrx = statusTrx;
    }

}
