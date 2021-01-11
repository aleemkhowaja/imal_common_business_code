package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_ID_DETAILSVO;
import com.path.dbmaps.vo.CIF_PROXY_BENEF_ID_DETAILSVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

public class FOMIdsCO extends RetailBaseVO
{

    private BigDecimal CIF_NO;
    private BigDecimal COMP_CODE;
    private BigDecimal ID_TYPE_CODE;
    private String ID_NO;
    private String ID_TYPE_MAND_YN;
    private String idTypeDesc;
    private String ID_CARD_TYPE;

    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private Boolean accesByTeller = true;
    private BigDecimal BRANCH_CODE;
    private BigDecimal cifTypeCode;
    // TP 324728 -- Hala Al Sheikh Enhance the checking on the US
    private CIF_ID_DETAILSVO cifIdDetailsVO = new CIF_ID_DETAILSVO();
    private String idDtlsCountryOfIssDesc;
    private String protectCountry;
   //End Hala
    private ArrayList<String> warningMessages; 
    private CIFVO cifVO;
    private String idTypeExpired;
    private String defaultexpirydate;
    //used for webservice 
    private String deleteCifId;
    
    //Rania - 930612
    private BigDecimal GL_CODE;
    
    private BigDecimal CURRENCY_CODE;
    
    private BigDecimal SL_NO;
    
    private Date ID_EXPIRY_DATE;
    //
    private boolean markForDelete=true;
    
    //Rania - SBI190008 - SECP requirement for Ultimate Beneficial Owner
    private CIF_PROXY_BENEF_ID_DETAILSVO cifProxyBenefIDDetailsVO = new CIF_PROXY_BENEF_ID_DETAILSVO();
    private BigDecimal realBenefLineNo;
    private BigDecimal realSubBenefLineNo;
    //
    
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

    public String getIdTypeDesc()
    {
	return idTypeDesc;
    }

    public void setIdTypeDesc(String idTypeDesc)
    {
	this.idTypeDesc = idTypeDesc;
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

    public String getID_NO()
    {
	return ID_NO;
    }

    public void setID_NO(String iDNO)
    {
	ID_NO = iDNO;
    }

    public String getID_TYPE_MAND_YN()
    {
	return ID_TYPE_MAND_YN;
    }

    public void setID_TYPE_MAND_YN(String iDTYPEMANDYN)
    {
	ID_TYPE_MAND_YN = iDTYPEMANDYN;
    }

    public BigDecimal getID_TYPE_CODE()
    {
	return ID_TYPE_CODE;
    }

    public void setID_TYPE_CODE(BigDecimal iDTYPECODE)
    {
	ID_TYPE_CODE = iDTYPECODE;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public BigDecimal getBRANCH_CODE()
    {
	return BRANCH_CODE;
    }

    public void setBRANCH_CODE(BigDecimal bRANCHCODE)
    {
	BRANCH_CODE = bRANCHCODE;
    }

    public String getID_CARD_TYPE()
    {
	return ID_CARD_TYPE;
    }

    public void setID_CARD_TYPE(String iDCARDTYPE)
    {
	ID_CARD_TYPE = iDCARDTYPE;
    }

    public BigDecimal getCifTypeCode()
    {
        return cifTypeCode;
    }

    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
        this.cifTypeCode = cifTypeCode;
    }
    public CIF_ID_DETAILSVO getCifIdDetailsVO()
    {
        return cifIdDetailsVO;
    }

    public void setCifIdDetailsVO(CIF_ID_DETAILSVO cifIdDetailsVO)
    {
        this.cifIdDetailsVO = cifIdDetailsVO;
    }

    public String getIdDtlsCountryOfIssDesc()
    {
        return idDtlsCountryOfIssDesc;
    }

    public void setIdDtlsCountryOfIssDesc(String idDtlsCountryOfIssDesc)
    {
        this.idDtlsCountryOfIssDesc = idDtlsCountryOfIssDesc;
    }

    public String getProtectCountry()
    {
        return protectCountry;
    }

    public void setProtectCountry(String protectCountry)
    {
        this.protectCountry = protectCountry;
    }

    public ArrayList<String> getWarningMessages()
    {
        return warningMessages;
    }

    public void setWarningMessages(ArrayList<String> warningMessages)
    {
        this.warningMessages = warningMessages;
    }

    public CIFVO getCifVO()
    {
        return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }


    public String getDefaultexpirydate()
    {
        return defaultexpirydate;
    }

    public void setDefaultexpirydate(String defaultexpirydate)
    {
        this.defaultexpirydate = defaultexpirydate;
    }


    public String getDeleteCifId()
    {
        return deleteCifId;
    }

    public void setDeleteCifId(String deleteCifId)
    {
        this.deleteCifId = deleteCifId;
    }

    public BigDecimal getGL_CODE()
    {
        return GL_CODE;
    }

    public void setGL_CODE(BigDecimal gL_CODE)
    {
        GL_CODE = gL_CODE;
    }

    public BigDecimal getCURRENCY_CODE()
    {
        return CURRENCY_CODE;
    }

    public void setCURRENCY_CODE(BigDecimal cURRENCY_CODE)
    {
        CURRENCY_CODE = cURRENCY_CODE;
    }

    public BigDecimal getSL_NO()
    {
        return SL_NO;
    }

    public void setSL_NO(BigDecimal sL_NO)
    {
        SL_NO = sL_NO;
    }

    public String getIdTypeExpired()
    {
        return idTypeExpired;
    }

    public void setIdTypeExpired(String idTypeExpired)
    {
        this.idTypeExpired = idTypeExpired;
    }

    public Date getID_EXPIRY_DATE()
    {
        return ID_EXPIRY_DATE;
    }

    public void setID_EXPIRY_DATE(Date iD_EXPIRY_DATE)
    {
        ID_EXPIRY_DATE = iD_EXPIRY_DATE;
    }

    
    @Override
    public int hashCode()
    {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((BRANCH_CODE == null) ? 0 : BRANCH_CODE.hashCode());
	result = prime * result + ((CIF_NO == null) ? 0 : CIF_NO.hashCode());
	result = prime * result + ((COMP_CODE == null) ? 0 : COMP_CODE.hashCode());
	result = prime * result + ((CURRENCY_CODE == null) ? 0 : CURRENCY_CODE.hashCode());
	result = prime * result + ((GL_CODE == null) ? 0 : GL_CODE.hashCode());
	result = prime * result + ((SL_NO == null) ? 0 : SL_NO.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj)
    {
	if(this == obj)
	    return true;
	if(obj == null)
	    return false;
	if(getClass() != obj.getClass())
	    return false;
	FOMIdsCO other = (FOMIdsCO) obj;
	if(BRANCH_CODE == null)
	{
	    if(other.BRANCH_CODE != null)
		return false;
	}
	else if(!BRANCH_CODE.equals(other.BRANCH_CODE))
	    return false;
	if(CIF_NO == null)
	{
	    if(other.CIF_NO != null)
		return false;
	}
	else if(!CIF_NO.equals(other.CIF_NO))
	    return false;
	if(COMP_CODE == null)
	{
	    if(other.COMP_CODE != null)
		return false;
	}
	else if(!COMP_CODE.equals(other.COMP_CODE))
	    return false;
	if(CURRENCY_CODE == null)
	{
	    if(other.CURRENCY_CODE != null)
		return false;
	}
	else if(!CURRENCY_CODE.equals(other.CURRENCY_CODE))
	    return false;
	if(GL_CODE == null)
	{
	    if(other.GL_CODE != null)
		return false;
	}
	else if(!GL_CODE.equals(other.GL_CODE))
	    return false;
	if(SL_NO == null)
	{
	    if(other.SL_NO != null)
		return false;
	}
	else if(!SL_NO.equals(other.SL_NO))
	    return false;
	return true;
    }

    public boolean isMarkForDelete()
    {
        return markForDelete;
    }

    public void setMarkForDelete(boolean markForDelete)
    {
        this.markForDelete = markForDelete;
    }

    public CIF_PROXY_BENEF_ID_DETAILSVO getCifProxyBenefIDDetailsVO()
    {
        return cifProxyBenefIDDetailsVO;
    }

    public void setCifProxyBenefIDDetailsVO(CIF_PROXY_BENEF_ID_DETAILSVO cifProxyBenefIDDetailsVO)
    {
        this.cifProxyBenefIDDetailsVO = cifProxyBenefIDDetailsVO;
    }

    public BigDecimal getRealBenefLineNo()
    {
        return realBenefLineNo;
    }

    public void setRealBenefLineNo(BigDecimal realBenefLineNo)
    {
        this.realBenefLineNo = realBenefLineNo;
    }

    public BigDecimal getRealSubBenefLineNo()
    {
        return realSubBenefLineNo;
    }

    public void setRealSubBenefLineNo(BigDecimal realSubBenefLineNo)
    {
        this.realSubBenefLineNo = realSubBenefLineNo;
    }
}