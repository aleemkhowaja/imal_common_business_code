/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTS_PASSBOOKVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashPassbooksCO.java used to
 */
public class DashPassbookCO extends RetailBaseVO
{
   private CTS_PASSBOOKVO ctsPassBookVO = new CTS_PASSBOOKVO();
   private AMFVO amfVO = new AMFVO();
   private String     branchDesc;
   private BigDecimal branch_code;
   private BigDecimal passbook_no;
   private String     status;
   private Date       date_created;
   private String     passbook_type;
   private BigDecimal current_page;
   private BigDecimal acc_br;
   private BigDecimal acc_cy;
   private BigDecimal acc_gl;
   private BigDecimal acc_cif;
   private BigDecimal acc_sl;   

/**
 * @return the passbook_no
 */
public BigDecimal getPassbook_no()
{
    return passbook_no;
}
/**
 * @param passbookNo the passbook_no to set
 */
public void setPassbook_no(BigDecimal passbookNo)
{
    passbook_no = passbookNo;
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
 * @return the date_created
 */
public Date getDate_created()
{
    return date_created;
}
/**
 * @param dateCreated the date_created to set
 */
public void setDate_created(Date dateCreated)
{
    date_created = dateCreated;
}
/**
 * @return the passbook_type
 */
public String getPassbook_type()
{
    return passbook_type;
}
/**
 * @param passbookType the passbook_type to set
 */
public void setPassbook_type(String passbookType)
{
    passbook_type = passbookType;
}
/**
 * @return the current_page
 */
public BigDecimal getCurrent_page()
{
    return current_page;
}
/**
 * @param currentPage the current_page to set
 */
public void setCurrent_page(BigDecimal currentPage)
{
    current_page = currentPage;
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
 * @return the branchDesc
 */
public String getBranchDesc()
{
    return branchDesc;
}
/**
 * @param branchDesc the branchDesc to set
 */
public void setBranchDesc(String branchDesc)
{
    this.branchDesc = branchDesc;
}
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
public CTS_PASSBOOKVO getCtsPassBookVO()
{
    return ctsPassBookVO;
}
public void setCtsPassBookVO(CTS_PASSBOOKVO ctsPassBookVO)
{
    this.ctsPassBookVO = ctsPassBookVO;
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
