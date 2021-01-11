/**
 * 
 */
package com.path.vo.core.fmsdrowdowns;

import java.math.BigDecimal;
import java.util.Date;

import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * FMSDrawdownCO.java used to
 */
public class FMSDrawdownCO extends RetailBaseVO
{
    private BigDecimal CODE;
    private BigDecimal FROM_FACILITY;
    private BigDecimal DRAWDOWN_TYPE;
    private String STATUS;
    private String LONG_NAME_ENG;
    private BigDecimal BRANCH_CODE;
    private BigDecimal CURRENCY_CODE;
    private String BRIEF_NAME_ENG;//FMSDRWDWNTYPE.BRIEF_NAME_ENG
    
    private BigDecimal FROM_APPLICATION;//FMSFACILITY.FROM_APPLICATION
    
    private BigDecimal CIF_NO;
    private String CIF_SHORT_NAME_ENG;//CIF.SHORT_NAME_ENG
    private String CIF_LONG_NAME_ENG;//CIF.LONG_NAME_ENG
    
    private Date DATE_SUBMITTED;
    private Date VALUE_DATE;
    
    private BigDecimal DD_VALUE;
    private BigDecimal PAID_AMT;
    
    private BigDecimal DD_BR;
    private BigDecimal DD_NO;
    private BigDecimal GL_CODE;
    private String ADDITIONAL_REFERENCE;
    private BigDecimal SL_NO;
    private String LONG_NAME_ARAB;
    private BigDecimal CHQ_TRSFR_AMT;
    private BigDecimal DRWDWN_CODE;
    private BigDecimal FACILITY_BRANCH;
    
    
    /**
     * @return the cODE
     */
    public BigDecimal getCODE()
    {
        return CODE;
    }
    /**
     * @param cODE the cODE to set
     */
    public void setCODE(BigDecimal cODE)
    {
        CODE = cODE;
    }
    /**
     * @return the fROM_FACILITY
     */
    public BigDecimal getFROM_FACILITY()
    {
        return FROM_FACILITY;
    }
    /**
     * @param fROMFACILITY the fROM_FACILITY to set
     */
    public void setFROM_FACILITY(BigDecimal fROMFACILITY)
    {
        FROM_FACILITY = fROMFACILITY;
    }
    /**
     * @return the dRAWDOWN_TYPE
     */
    public BigDecimal getDRAWDOWN_TYPE()
    {
        return DRAWDOWN_TYPE;
    }
    /**
     * @param dRAWDOWNTYPE the dRAWDOWN_TYPE to set
     */
    public void setDRAWDOWN_TYPE(BigDecimal dRAWDOWNTYPE)
    {
        DRAWDOWN_TYPE = dRAWDOWNTYPE;
    }
    /**
     * @return the sTATUS
     */
    public String getSTATUS()
    {
        return STATUS;
    }
    /**
     * @param sTATUS the sTATUS to set
     */
    public void setSTATUS(String sTATUS)
    {
        STATUS = sTATUS;
    }
    /**
     * @return the lONG_NAME_ENG
     */
    public String getLONG_NAME_ENG()
    {
        return LONG_NAME_ENG;
    }
    /**
     * @param lONGNAMEENG the lONG_NAME_ENG to set
     */
    public void setLONG_NAME_ENG(String lONGNAMEENG)
    {
        LONG_NAME_ENG = lONGNAMEENG;
    }
    /**
     * @return the bRIEF_NAME_ENG
     */
    public String getBRIEF_NAME_ENG()
    {
        return BRIEF_NAME_ENG;
    }
    /**
     * @param bRIEFNAMEENG the bRIEF_NAME_ENG to set
     */
    public void setBRIEF_NAME_ENG(String bRIEFNAMEENG)
    {
        BRIEF_NAME_ENG = bRIEFNAMEENG;
    }
    /**
     * @return the fROM_APPLICATION
     */
    public BigDecimal getFROM_APPLICATION()
    {
        return FROM_APPLICATION;
    }
    /**
     * @param fROMAPPLICATION the fROM_APPLICATION to set
     */
    public void setFROM_APPLICATION(BigDecimal fROMAPPLICATION)
    {
        FROM_APPLICATION = fROMAPPLICATION;
    }
    /**
     * @return the cIF_NO
     */
    public BigDecimal getCIF_NO()
    {
        return CIF_NO;
    }
    /**
     * @param cIFNO the cIF_NO to set
     */
    public void setCIF_NO(BigDecimal cIFNO)
    {
        CIF_NO = cIFNO;
    }
    /**
     * @return the cIF_SHORT_NAME_ENG
     */
    public String getCIF_SHORT_NAME_ENG()
    {
        return CIF_SHORT_NAME_ENG;
    }
    /**
     * @param cIFSHORTNAMEENG the cIF_SHORT_NAME_ENG to set
     */
    public void setCIF_SHORT_NAME_ENG(String cIFSHORTNAMEENG)
    {
        CIF_SHORT_NAME_ENG = cIFSHORTNAMEENG;
    }
    /**
     * @return the cIF_LONG_NAME_ENG
     */
    public String getCIF_LONG_NAME_ENG()
    {
        return CIF_LONG_NAME_ENG;
    }
    /**
     * @param cIFLONGNAMEENG the cIF_LONG_NAME_ENG to set
     */
    public void setCIF_LONG_NAME_ENG(String cIFLONGNAMEENG)
    {
        CIF_LONG_NAME_ENG = cIFLONGNAMEENG;
    }
	public BigDecimal getBRANCH_CODE()
	{
		return BRANCH_CODE;
	}
	public void setBRANCH_CODE(BigDecimal bRANCHCODE)
	{
		BRANCH_CODE = bRANCHCODE;
	}
	public BigDecimal getCURRENCY_CODE()
	{
		return CURRENCY_CODE;
	}
	public void setCURRENCY_CODE(BigDecimal cURRENCYCODE)
	{
		CURRENCY_CODE = cURRENCYCODE;
	}
	/**
	 * @return the dATE_SUBMITTED
	 */
	public Date getDATE_SUBMITTED()
	{
	    return DATE_SUBMITTED;
	}
	/**
	 * @param dATESUBMITTED the dATE_SUBMITTED to set
	 */
	public void setDATE_SUBMITTED(Date dATESUBMITTED)
	{
	    DATE_SUBMITTED = dATESUBMITTED;
	}
	/**
	 * @return the vALUE_DATE
	 */
	public Date getVALUE_DATE()
	{
	    return VALUE_DATE;
	}
	/**
	 * @param vALUEDATE the vALUE_DATE to set
	 */
	public void setVALUE_DATE(Date vALUEDATE)
	{
	    VALUE_DATE = vALUEDATE;
	}
	/**
	 * @return the dD_VALUE
	 */
	public BigDecimal getDD_VALUE()
	{
	    return DD_VALUE;
	}
	/**
	 * @param dDVALUE the dD_VALUE to set
	 */
	public void setDD_VALUE(BigDecimal dDVALUE)
	{
	    DD_VALUE = dDVALUE;
	}
	/**
	 * @return the pAID_AMT
	 */
	public BigDecimal getPAID_AMT()
	{
	    return PAID_AMT;
	}
	/**
	 * @param pAIDAMT the pAID_AMT to set
	 */
	public void setPAID_AMT(BigDecimal pAIDAMT)
	{
	    PAID_AMT = pAIDAMT;
	}
	public BigDecimal getDD_BR()
	{
	    return DD_BR;
	}
	public void setDD_BR(BigDecimal dDBR)
	{
	    DD_BR = dDBR;
	}
	public BigDecimal getDD_NO()
	{
	    return DD_NO;
	}
	public void setDD_NO(BigDecimal dDNO)
	{
	    DD_NO = dDNO;
	}
	public BigDecimal getGL_CODE()
	{
	    return GL_CODE;
	}
	public void setGL_CODE(BigDecimal gLCODE)
	{
	    GL_CODE = gLCODE;
	}
	public String getADDITIONAL_REFERENCE()
	{
	    return ADDITIONAL_REFERENCE;
	}
	public void setADDITIONAL_REFERENCE(String aDDITIONALREFERENCE)
	{
	    ADDITIONAL_REFERENCE = aDDITIONALREFERENCE;
	}
	public BigDecimal getSL_NO()
	{
	    return SL_NO;
	}
	public void setSL_NO(BigDecimal sLNO)
	{
	    SL_NO = sLNO;
	}
	public String getLONG_NAME_ARAB()
	{
	    return LONG_NAME_ARAB;
	}
	public void setLONG_NAME_ARAB(String lONGNAMEARAB)
	{
	    LONG_NAME_ARAB = lONGNAMEARAB;
	}
	public BigDecimal getCHQ_TRSFR_AMT()
	{
	    return CHQ_TRSFR_AMT;
	}
	public void setCHQ_TRSFR_AMT(BigDecimal cHQTRSFRAMT)
	{
	    CHQ_TRSFR_AMT = cHQTRSFRAMT;
	}
	public BigDecimal getDRWDWN_CODE()
	{
	    return DRWDWN_CODE;
	}
	public void setDRWDWN_CODE(BigDecimal dRWDWNCODE)
	{
	    DRWDWN_CODE = dRWDWNCODE;
	}
	public BigDecimal getFACILITY_BRANCH()
	{
	    return FACILITY_BRANCH;
	}
	public void setFACILITY_BRANCH(BigDecimal fACILITYBRANCH)
	{
	    FACILITY_BRANCH = fACILITYBRANCH;
	}

}
