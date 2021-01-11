package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_AUTH_SIGNATORYVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: AIssac
 * 
 *          FOMBalanceLimitCO.java used to
 */
public class FOMOwnerShipDetailsCO extends RetailBaseVO
{
    private CIF_AUTH_SIGNATORYVO CIFAUTHSIGNATORYVO = new CIF_AUTH_SIGNATORYVO();
    CTSTELLERVO ctsTellerVO = new CTSTELLERVO();

    private String saveType;
    private String cifStatus;
    private String iv_crud;
    private String lang;
    private String msgTitle;
    private String msgText;
    private String idTypeDesc;
    private BigDecimal brancheCode;
    private Date cif_UpdateDate;
    private Boolean pepCheckbox;
    private BigDecimal cifType;
    private String positionDesc;
    private Boolean accesByTeller = true;
    
    CIFVO cifVO = new CIFVO();
    private ArrayList<Integer> warningListCode = new ArrayList<Integer>();
    private HashMap<Integer, String[]> ctsMsgParam = new HashMap<Integer, String[]>();

    private String ownerShipCountryDesc;
    private String ownerShipCountryOfAddressDesc;
    private String nationalityCountryDesc;
    private String seCountryListedDesc;
    
    //TP 262352 Hala Al Sheikh Enhance the checking on the US Passport
    private List<FOMOwnerShipDetailsCO> fomAuthSignatoryCOList = new ArrayList<FOMOwnerShipDetailsCO>();
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private String ownerShipCountryOfIssDesc;
    //End Hala
    private String inGridStr;
    private List<CIFKycFinancialInfoCountryCO> cifKycFinancialInfoCountryList=new ArrayList<>();
    private String ownerShipStatusDesc;
    
    //US#704079-APPLY PEP ON JAVA
    private CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
    //used for webservice 
    private String delete;
    //TP 324728 - [John Massaad] Enhance the checking on the US Passport
    //EWBI160091 (403157)- Modification of CIF
    private BigDecimal compCodeCif;
    
    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public Boolean getPepCheckbox()
    {
	return pepCheckbox;
    }

    public void setPepCheckbox(Boolean pepCheckbox)
    {
	this.pepCheckbox = pepCheckbox;
    }

    public BigDecimal getBrancheCode()
    {
	return brancheCode;
    }

    public void setBrancheCode(BigDecimal brancheCode)
    {
	this.brancheCode = brancheCode;
    }

    public String getLang()
    {
	return lang;
    }

    public void setLang(String lang)
    {
	this.lang = lang;
    }

    public CIF_AUTH_SIGNATORYVO getCIFAUTHSIGNATORYVO()
    {
	return CIFAUTHSIGNATORYVO;
    }

    public void setCIFAUTHSIGNATORYVO(CIF_AUTH_SIGNATORYVO cIFAUTHSIGNATORYVO)
    {
	CIFAUTHSIGNATORYVO = cIFAUTHSIGNATORYVO;
    }

    public Date getCif_UpdateDate()
    {
	return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
	cif_UpdateDate = cifUpdateDate;
    }

    public String getCifStatus()
    {
	return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
	this.cifStatus = cifStatus;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public String getIdTypeDesc()
    {
	return idTypeDesc;
    }

    public void setIdTypeDesc(String idTypeDesc)
    {
	this.idTypeDesc = idTypeDesc;
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

    /**
     * @return the msgTitle
     */
    public String getMsgTitle()
    {
        return msgTitle;
    }

    /**
     * @param msgTitle the msgTitle to set
     */
    public void setMsgTitle(String msgTitle)
    {
        this.msgTitle = msgTitle;
    }

    /**
     * @return the msgText
     */
    public String getMsgText()
    {
        return msgText;
    }

    /**
     * @param msgText the msgText to set
     */
    public void setMsgText(String msgText)
    {
        this.msgText = msgText;
    }
    public List<FOMOwnerShipDetailsCO> getFomAuthSignatoryCOList()
    {
        return fomAuthSignatoryCOList;
    }

    public void setFomAuthSignatoryCOList(List<FOMOwnerShipDetailsCO> fomAuthSignatoryCOList)
    {
        this.fomAuthSignatoryCOList = fomAuthSignatoryCOList;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
    {
        return buisnessElement;
    }

    public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
    {
        this.buisnessElement = buisnessElement;
    }

    public String getOwnerShipCountryOfIssDesc()
    {
        return ownerShipCountryOfIssDesc;
    }

    public void setOwnerShipCountryOfIssDesc(String ownerShipCountryOfIssDesc)
    {
        this.ownerShipCountryOfIssDesc = ownerShipCountryOfIssDesc;
    }
    
    public String getOwnerShipCountryDesc()
    {
    	return ownerShipCountryDesc;
    }

    public void setOwnerShipCountryDesc(String ownerShipCountryDesc)
    {
    	this.ownerShipCountryDesc = ownerShipCountryDesc;
    }

    public String getOwnerShipCountryOfAddressDesc()
    {
    	return ownerShipCountryOfAddressDesc;
    }

    public void setOwnerShipCountryOfAddressDesc(String ownerShipCountryOfAddressDesc)
    {
    	this.ownerShipCountryOfAddressDesc = ownerShipCountryOfAddressDesc;
    }

    public String getPositionDesc()
    {
	return positionDesc;
    }

    public void setPositionDesc(String positionDesc)
    {
	this.positionDesc = positionDesc;
    }

    public String getInGridStr()
    {
        return inGridStr;
    }

    public void setInGridStr(String inGridStr)
    {
        this.inGridStr = inGridStr;
    }

    public List<CIFKycFinancialInfoCountryCO> getCifKycFinancialInfoCountryList()
    {
        return cifKycFinancialInfoCountryList;
    }

    public void setCifKycFinancialInfoCountryList(List<CIFKycFinancialInfoCountryCO> cifKycFinancialInfoCountryList)
    {
        this.cifKycFinancialInfoCountryList = cifKycFinancialInfoCountryList;
    }

    public CIFCONTROLVO getCifControlVO()
    {
	return cifControlVO;
    }

    public void setCifControlVO(CIFCONTROLVO cifControlVO)
    {
	this.cifControlVO = cifControlVO;
    }

    public String getNationalityCountryDesc()
    {
	return nationalityCountryDesc;
    }

    public void setNationalityCountryDesc(String nationalityCountryDesc)
    {
	this.nationalityCountryDesc = nationalityCountryDesc;
    }

    public String getSeCountryListedDesc()
    {
	return seCountryListedDesc;
    }

    public void setSeCountryListedDesc(String seCountryListedDesc)
    {
	this.seCountryListedDesc = seCountryListedDesc;
    }

    public String getOwnerShipStatusDesc()
    {
	return ownerShipStatusDesc;
    }

    public void setOwnerShipStatusDesc(String ownerShipStatusDesc)
    {
	this.ownerShipStatusDesc = ownerShipStatusDesc;
    }

    public String getDelete()
    {
	return delete;
    }

    public void setDelete(String delete)
    {
	this.delete = delete;
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
