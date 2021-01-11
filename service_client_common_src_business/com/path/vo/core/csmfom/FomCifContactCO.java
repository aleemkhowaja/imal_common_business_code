package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CIF_CONTACTVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

public class FomCifContactCO extends RetailBaseVO
{
    private CIF_CONTACTVO cifContactVO = new CIF_CONTACTVO();
    CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String contactTypeDesc;
    private String saveType;
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private BigDecimal brancheCode;
    //EWBI160091 (403157)- Modification of CIF
    private BigDecimal compCodeCif;

    private Boolean accesByTeller = true;
    
    private String deleteCifContact;

    public BigDecimal getBrancheCode()
    {
	return brancheCode;
    }

    public void setBrancheCode(BigDecimal brancheCode)
    {
	this.brancheCode = brancheCode;
    }

    public CIF_CONTACTVO getCifContactVO()
    {
	return cifContactVO;
    }

    public void setCifContactVO(CIF_CONTACTVO cifContactVO)
    {
	this.cifContactVO = cifContactVO;
    }

    public String getContactTypeDesc()
    {
	return contactTypeDesc;
    }

    public void setContactTypeDesc(String contactTypeDesc)
    {
	this.contactTypeDesc = contactTypeDesc;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

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

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }
    

    public String getDeleteCifContact()
    {
        return deleteCifContact;
    }

    public void setDeleteCifContact(String deleteCifContact)
    {
        this.deleteCifContact = deleteCifContact;
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