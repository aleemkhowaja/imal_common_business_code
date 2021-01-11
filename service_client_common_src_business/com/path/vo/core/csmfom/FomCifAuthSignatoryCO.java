package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_AUTH_SIGNATORYVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

public class FomCifAuthSignatoryCO extends RetailBaseVO
{
    private CIF_AUTH_SIGNATORYVO cifAuthSignatoryVO = new CIF_AUTH_SIGNATORYVO();
    CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String saveType;
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private BigDecimal brancheCode;
    private BigDecimal cifType;
    private Boolean accesByTeller = true;
    // this is used to add the warning msg lists from database
    private ArrayList<Integer> warningListCode = new ArrayList<Integer>();
    private HashMap<Integer, String[]> ctsMsgParam = new HashMap<Integer, String[]>();
    private CIFVO cifVO = new CIFVO();
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private String authSignCountryDesc;
    private String authSignCountryOfAddressDesc;
    private String nationalityCountryDesc;
    private String moreSignatoryhStatusDesc;
	//TP 262352 Hala Al Sheikh Enhance the checking on the US Passport
    private String authSignCountryOfIssDesc;
    private List<FomCifAuthSignatoryCO> fomAuthSignatoryCOList = new ArrayList<FomCifAuthSignatoryCO>();
    //End Hala
    //used for webservice 
    private String delete;
    
    //EWBI160037- [John Massaad]
    private BigDecimal authCIFBrCode;
    
    private String authSignNationalityDesc;
    
    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public BigDecimal getBrancheCode()
    {
	return brancheCode;
    }

    public void setBrancheCode(BigDecimal brancheCode)
    {
	this.brancheCode = brancheCode;
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

    public CIF_AUTH_SIGNATORYVO getCifAuthSignatoryVO()
    {
	return cifAuthSignatoryVO;
    }

    public void setCifAuthSignatoryVO(CIF_AUTH_SIGNATORYVO cifAuthSignatoryVO)
    {
	this.cifAuthSignatoryVO = cifAuthSignatoryVO;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public ArrayList<Integer> getWarningListCode()
    {
        return warningListCode;
    }

    public void setWarningListCode(ArrayList<Integer> warningListCode)
    {
        this.warningListCode = warningListCode;
    }

    public HashMap<Integer, String[]> getCtsMsgParam()
    {
        return ctsMsgParam;
    }

    public void setCtsMsgParam(HashMap<Integer, String[]> ctsMsgParam)
    {
        this.ctsMsgParam = ctsMsgParam;
    }

    public CIFVO getCifVO()
    {
        return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
    {
        return buisnessElement;
    }

    public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
    {
        this.buisnessElement = buisnessElement;
    }
    
    public String getAuthSignCountryOfIssDesc()
    {
        return authSignCountryOfIssDesc;
    }

    public void setAuthSignCountryOfIssDesc(String authSignCountryOfIssDesc)
    {
        this.authSignCountryOfIssDesc = authSignCountryOfIssDesc;
    }

    public List<FomCifAuthSignatoryCO> getFomAuthSignatoryCOList()
    {
        return fomAuthSignatoryCOList;
    }

    public void setFomAuthSignatoryCOList(List<FomCifAuthSignatoryCO> fomAuthSignatoryCOList)
    {
        this.fomAuthSignatoryCOList = fomAuthSignatoryCOList;
    }
    
    public String getAuthSignCountryDesc()
    {
    	return authSignCountryDesc;
    }

    public void setAuthSignCountryDesc(String authSignCountryDesc)
    {
    	this.authSignCountryDesc = authSignCountryDesc;
    }

    public String getAuthSignCountryOfAddressDesc()
    {
    	return authSignCountryOfAddressDesc;
    }

    public void setAuthSignCountryOfAddressDesc(String authSignCountryOfAddressDesc)
    {
    	this.authSignCountryOfAddressDesc = authSignCountryOfAddressDesc;
    }
    
    public String getNationalityCountryDesc()
    {
        return nationalityCountryDesc;
    }

    public void setNationalityCountryDesc(String nationalityCountryDesc)
    {
        this.nationalityCountryDesc = nationalityCountryDesc;
    }

    public String getMoreSignatoryhStatusDesc()
    {
        return moreSignatoryhStatusDesc;
    }

    public void setMoreSignatoryhStatusDesc(String moreSignatoryhStatusDesc)
    {
        this.moreSignatoryhStatusDesc = moreSignatoryhStatusDesc;
    }

    public String getDelete()
    {
        return delete;
    }

    public void setDelete(String delete)
    {
        this.delete = delete;
    }

    public BigDecimal getAuthCIFBrCode()
    {
	return authCIFBrCode;
    }

    public void setAuthCIFBrCode(BigDecimal authCIFBrCode)
    {
	this.authCIFBrCode = authCIFBrCode;
    }

    public String getAuthSignNationalityDesc()
    {
	return authSignNationalityDesc;
    }

    public void setAuthSignNationalityDesc(String authSignNationalityDesc)
    {
	this.authSignNationalityDesc = authSignNationalityDesc;
    }
    
}