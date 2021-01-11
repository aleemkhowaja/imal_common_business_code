package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: AIssac
 * 
 *          FOMPolicyTreatmentCO.java used to
 */
public class FOMPolicyTreatmentCO extends RetailBaseVO
{
    // private CTS_CHARGES_FEES_POLICY_DETVO ctsChargesFeesPolicyDetVO = new
    // CTS_CHARGES_FEES_POLICY_DETVO();
    // private CTS_CHARGES_FEES_POLICYVO ctsChargesFeesPolicyVO = new
    // CTS_CHARGES_FEES_POLICYVO();

    private BigDecimal POLICY_COMP_CODE;
    private BigDecimal POLICY_CODE;
    private BigDecimal POLICY_LINE_NO;
    private String BRIEF_NAME_ENG;
    private String BRIEF_NAME_ARAB;
    private String LONG_NAME_ENG;
    private String LONG_NAME_ARAB;
    private String PERIODICITY;
    private BigDecimal POLICY_DET_COMP_CODE;
    private BigDecimal POLICY_DET_CODE;
    private BigDecimal POLICY_DET_LINE_NO;
    private BigDecimal POLICY_DET_ENTITY_CODE;
    private String POLICY_DET_ENTITY_TYPE;
    private String periodicityDesc;

    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private BigDecimal CIF_NO;
    private BigDecimal COMP_CODE;
    private BigDecimal CIF_TYPE;
    private String langCode;
    private BigDecimal lovType;
    private BigDecimal PRIORITY_CODE;
    private String language;

    private Boolean accesByTeller = true;
    private BigDecimal compCodeCif;
    
    

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public String getCifStatus()
    {
	return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
	this.cifStatus = cifStatus;
    }

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    public Date getCif_UpdateDate()
    {
	return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
	cif_UpdateDate = cifUpdateDate;
    }

    public BigDecimal getCIF_NO()
    {
	return CIF_NO;
    }

    public void setCIF_NO(BigDecimal cIFNO)
    {
	CIF_NO = cIFNO;
    }

    public BigDecimal getCOMP_CODE()
    {
	return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMPCODE)
    {
	COMP_CODE = cOMPCODE;
    }

    // public CTS_CHARGES_FEES_POLICY_DETVO getCtsChargesFeesPolicyDetVO()
    // {
    // return ctsChargesFeesPolicyDetVO;
    // }
    // public void setCtsChargesFeesPolicyDetVO(CTS_CHARGES_FEES_POLICY_DETVO
    // ctsChargesFeesPolicyDetVO)
    // {
    // this.ctsChargesFeesPolicyDetVO = ctsChargesFeesPolicyDetVO;
    // }
    // public CTS_CHARGES_FEES_POLICYVO getCtsChargesFeesPolicyVO()
    // {
    // return ctsChargesFeesPolicyVO;
    // }
    // public void setCtsChargesFeesPolicyVO(CTS_CHARGES_FEES_POLICYVO
    // ctsChargesFeesPolicyVO)
    // {
    // this.ctsChargesFeesPolicyVO = ctsChargesFeesPolicyVO;
    // }
    public String getPeriodicityDesc()
    {
	return periodicityDesc;
    }

    public void setPeriodicityDesc(String periodicityDesc)
    {
	this.periodicityDesc = periodicityDesc;
    }

    public BigDecimal getPOLICY_COMP_CODE()
    {
	return POLICY_COMP_CODE;
    }

    public void setPOLICY_COMP_CODE(BigDecimal pOLICYCOMPCODE)
    {
	POLICY_COMP_CODE = pOLICYCOMPCODE;
    }

    public BigDecimal getPOLICY_CODE()
    {
	return POLICY_CODE;
    }

    public void setPOLICY_CODE(BigDecimal pOLICYCODE)
    {
	POLICY_CODE = pOLICYCODE;
    }

    public BigDecimal getPOLICY_LINE_NO()
    {
	return POLICY_LINE_NO;
    }

    public void setPOLICY_LINE_NO(BigDecimal pOLICYLINENO)
    {
	POLICY_LINE_NO = pOLICYLINENO;
    }

    public String getBRIEF_NAME_ENG()
    {
	return BRIEF_NAME_ENG;
    }

    public void setBRIEF_NAME_ENG(String bRIEFNAMEENG)
    {
	BRIEF_NAME_ENG = bRIEFNAMEENG;
    }

    public String getBRIEF_NAME_ARAB()
    {
	return BRIEF_NAME_ARAB;
    }

    public void setBRIEF_NAME_ARAB(String bRIEFNAMEARAB)
    {
	BRIEF_NAME_ARAB = bRIEFNAMEARAB;
    }

    public String getLONG_NAME_ENG()
    {
	return LONG_NAME_ENG;
    }

    public void setLONG_NAME_ENG(String lONGNAMEENG)
    {
	LONG_NAME_ENG = lONGNAMEENG;
    }

    public String getLONG_NAME_ARAB()
    {
	return LONG_NAME_ARAB;
    }

    public void setLONG_NAME_ARAB(String lONGNAMEARAB)
    {
	LONG_NAME_ARAB = lONGNAMEARAB;
    }

    public String getPERIODICITY()
    {
	return PERIODICITY;
    }

    public void setPERIODICITY(String pERIODICITY)
    {
	PERIODICITY = pERIODICITY;
    }

    public BigDecimal getPOLICY_DET_COMP_CODE()
    {
	return POLICY_DET_COMP_CODE;
    }

    public void setPOLICY_DET_COMP_CODE(BigDecimal pOLICYDETCOMPCODE)
    {
	POLICY_DET_COMP_CODE = pOLICYDETCOMPCODE;
    }

    public BigDecimal getPOLICY_DET_CODE()
    {
	return POLICY_DET_CODE;
    }

    public void setPOLICY_DET_CODE(BigDecimal pOLICYDETCODE)
    {
	POLICY_DET_CODE = pOLICYDETCODE;
    }

    public BigDecimal getPOLICY_DET_LINE_NO()
    {
	return POLICY_DET_LINE_NO;
    }

    public void setPOLICY_DET_LINE_NO(BigDecimal pOLICYDETLINENO)
    {
	POLICY_DET_LINE_NO = pOLICYDETLINENO;
    }

    public BigDecimal getPOLICY_DET_ENTITY_CODE()
    {
	return POLICY_DET_ENTITY_CODE;
    }

    public void setPOLICY_DET_ENTITY_CODE(BigDecimal pOLICYDETENTITYCODE)
    {
	POLICY_DET_ENTITY_CODE = pOLICYDETENTITYCODE;
    }

    public String getPOLICY_DET_ENTITY_TYPE()
    {
	return POLICY_DET_ENTITY_TYPE;
    }

    public void setPOLICY_DET_ENTITY_TYPE(String pOLICYDETENTITYTYPE)
    {
	POLICY_DET_ENTITY_TYPE = pOLICYDETENTITYTYPE;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public BigDecimal getCIF_TYPE()
    {
	return CIF_TYPE;
    }

    public void setCIF_TYPE(BigDecimal cIFTYPE)
    {
	CIF_TYPE = cIFTYPE;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getPRIORITY_CODE()
    {
	return PRIORITY_CODE;
    }

    public void setPRIORITY_CODE(BigDecimal pRIORITYCODE)
    {
	PRIORITY_CODE = pRIORITYCODE;
    }

    public String getLangCode()
    {
	return langCode;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }

}
