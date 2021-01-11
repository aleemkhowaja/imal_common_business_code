package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;
import com.path.dbmaps.vo.CTSTELLERVO;

public class FinancialInwardOutwardSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private String cifStatus;
    private Date cif_UpdateDate;
    private BigDecimal Id;
    private String type;
    private String lang;
    private BigDecimal monthly_income;
    private BigDecimal compCodeCif;
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public BigDecimal getId()
    {
	return Id;
    }

    public void setId(BigDecimal id)
    {
	Id = id;
    }

    public String getLang()
    {
	return lang;
    }

    public void setLang(String lang)
    {
	this.lang = lang;
    }

    public BigDecimal getMonthly_income()
    {
        return monthly_income;
    }

    public void setMonthly_income(BigDecimal monthlyIncome)
    {
        monthly_income = monthlyIncome;
    }

    public String getCifStatus()
    {
        return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
        this.cifStatus = cifStatus;
    }

    public Date getCif_UpdateDate()
    {
        return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
        cif_UpdateDate = cifUpdateDate;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
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
