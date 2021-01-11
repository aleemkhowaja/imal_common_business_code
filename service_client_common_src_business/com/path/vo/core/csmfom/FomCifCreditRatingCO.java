package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

public class FomCifCreditRatingCO extends RetailBaseVO
{
    /**
     * JOIN QUERY FETCH FROM CREDIT_RATING AND CIF_CREDIT_RATING
     */
    
    private BigDecimal COMP_CODE;
    private BigDecimal CIF_NO;
    private BigDecimal LINE_NO;
    private BigDecimal CREDIT_RATING;
    private String BRIEF_NAME_ENG;
    private String SOURCE;
    private Date FROM_DATE;
    private Date TO_DATE;
    private String BRIEF_NAME_ARAB;
    
    private String cifStatus;
	private String iv_crud;
	private Date cif_UpdateDate ;
	
	private CTSTELLERVO ctsTellerVO = new CTSTELLERVO() ;
	private Boolean accesByTeller=true;

	
	
	
    public CTSTELLERVO getCtsTellerVO() {
		return ctsTellerVO;
	}

	public void setCtsTellerVO(CTSTELLERVO ctsTellerVO) {
		this.ctsTellerVO = ctsTellerVO;
	}

	public String getCifStatus() {
		return cifStatus;
	}

	public void setCifStatus(String cifStatus) {
		this.cifStatus = cifStatus;
	}

	public String getIv_crud() {
		return iv_crud;
	}

	public void setIv_crud(String ivCrud) {
		iv_crud = ivCrud;
	}

	public Date getCif_UpdateDate() {
		return cif_UpdateDate;
	}

	public void setCif_UpdateDate(Date cifUpdateDate) {
		cif_UpdateDate = cifUpdateDate;
	}

	public BigDecimal getCOMP_CODE()
    {
	return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMPCODE)
    {
	COMP_CODE = cOMPCODE;
    }

    public BigDecimal getCIF_NO()
    {
	return CIF_NO;
    }

    public void setCIF_NO(BigDecimal cIFNO)
    {
	CIF_NO = cIFNO;
    }

    public BigDecimal getLINE_NO()
    {
	return LINE_NO;
    }

    public void setLINE_NO(BigDecimal lINENO)
    {
	LINE_NO = lINENO;
    }

    public BigDecimal getCREDIT_RATING()
    {
	return CREDIT_RATING;
    }

    public void setCREDIT_RATING(BigDecimal cREDITRATING)
    {
	CREDIT_RATING = cREDITRATING;
    }

    public String getBRIEF_NAME_ENG()
    {
	return BRIEF_NAME_ENG;
    }

    public void setBRIEF_NAME_ENG(String bRIEFNAMEENG)
    {
	BRIEF_NAME_ENG = bRIEFNAMEENG;
    }

    public String getSOURCE()
    {
	return SOURCE;
    }

    public void setSOURCE(String sOURCE)
    {
	SOURCE = sOURCE;
    }

    public Date getFROM_DATE()
    {
	return FROM_DATE;
    }

    public void setFROM_DATE(Date fROMDATE)
    {
	FROM_DATE = fROMDATE;
    }

    public Date getTO_DATE()
    {
	return TO_DATE;
    }

    public void setTO_DATE(Date tODATE)
    {
	TO_DATE = tODATE;
    }

    public String getBRIEF_NAME_ARAB()
    {
	return BRIEF_NAME_ARAB;
    }

    public void setBRIEF_NAME_ARAB(String bRIEFNAMEARAB)
    {
	BRIEF_NAME_ARAB = bRIEFNAMEARAB;
    }

	public Boolean getAccesByTeller()
	{
		return accesByTeller;
	}

	public void setAccesByTeller(Boolean accesByTeller)
	{
		this.accesByTeller = accesByTeller;
	}
}