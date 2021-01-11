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


public class DashSmsSubscriptionCO extends RetailBaseVO
{
    private BigDecimal CODE;   	
    private BigDecimal BRANCH_CODE;
    private BigDecimal ACC_BR    ;  
    private BigDecimal ACC_CY  ;   
    private BigDecimal ACC_GL  ;    
    private BigDecimal ACC_CIF  ;   
    private BigDecimal ACC_SL   ;   
    private String MOBILE_NUM ; 
    private String STATUS   ;  
    private String smsSubStatus;
    private String IBAN_ACC_NO;
    private String  ACC_ADD_REF ;
    public BigDecimal getCODE()
    {
        return CODE;
    }
    public void setCODE(BigDecimal cODE)
    {
        CODE = cODE;
    }
    public BigDecimal getBRANCH_CODE()
    {
        return BRANCH_CODE;
    }
    public void setBRANCH_CODE(BigDecimal bRANCH_CODE)
    {
        BRANCH_CODE = bRANCH_CODE;
    }
    public BigDecimal getACC_BR()
    {
        return ACC_BR;
    }
    public void setACC_BR(BigDecimal aCC_BR)
    {
        ACC_BR = aCC_BR;
    }
    public BigDecimal getACC_CY()
    {
        return ACC_CY;
    }
    public void setACC_CY(BigDecimal aCC_CY)
    {
        ACC_CY = aCC_CY;
    }
    public BigDecimal getACC_GL()
    {
        return ACC_GL;
    }
    public void setACC_GL(BigDecimal aCC_GL)
    {
        ACC_GL = aCC_GL;
    }
    public BigDecimal getACC_CIF()
    {
        return ACC_CIF;
    }
    public void setACC_CIF(BigDecimal aCC_CIF)
    {
        ACC_CIF = aCC_CIF;
    }
    public BigDecimal getACC_SL()
    {
        return ACC_SL;
    }
    public void setACC_SL(BigDecimal aCC_SL)
    {
        ACC_SL = aCC_SL;
    }
    public String getMOBILE_NUM()
    {
        return MOBILE_NUM;
    }
    public void setMOBILE_NUM(String mOBILE_NUM)
    {
        MOBILE_NUM = mOBILE_NUM;
    }
    public String getSTATUS()
    {
        return STATUS;
    }
    public void setSTATUS(String sTATUS)
    {
        STATUS = sTATUS;
    }
    public String getSmsSubStatus()
    {
        return smsSubStatus;
    }
    public void setSmsSubStatus(String smsSubStatus)
    {
        this.smsSubStatus = smsSubStatus;
    }
    public String getIBAN_ACC_NO()
    {
        return IBAN_ACC_NO;
    }
    public void setIBAN_ACC_NO(String iBAN_ACC_NO)
    {
        IBAN_ACC_NO = iBAN_ACC_NO;
    }
    public String getACC_ADD_REF()
    {
        return ACC_ADD_REF;
    }
    public void setACC_ADD_REF(String aCC_ADD_REF)
    {
        ACC_ADD_REF = aCC_ADD_REF;
    }
    
    

}
