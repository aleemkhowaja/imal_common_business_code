package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.dbmaps.vo.CIF_EXTENDEDVO;
import com.path.dbmaps.vo.CIF_PROXY_BENEFVO;
import com.path.dbmaps.vo.CIF_PROXY_BENEF_DETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * FOMRealBeneficiariesCO.java used to
 */
public class FOMRealBeneficiariesCO extends RetailBaseVO
{

    
    
    private CIF_PROXY_BENEFVO cifProxyBenfVO = new CIF_PROXY_BENEFVO ();
    private CIF_PROXY_BENEF_DETVO cifProxyBenfDetVO = new CIF_PROXY_BENEF_DETVO ();
    //TP 262352 Hala Al Sheikh Enhance the checking on the US Passport
    private CIF_EXTENDEDVO cifExtendedVO = new CIF_EXTENDEDVO();
    private String cifProxyCountryOfIssuanceDesc;
    // End Hala  
    HashMap<String  ,SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement =new HashMap<String  ,SYS_PARAM_SCREEN_DISPLAYVO>();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO ();
    private AMFVO amfVO = new AMFVO ();
    private CIFVO cifVO = new CIFVO();
    private CIF_ADDRESSVO cifAddressVO = new CIF_ADDRESSVO();
    
    
    private String cifStatus;
   
    private BigDecimal cifType;
    private BigDecimal lineNo;
    private String fromField;
   
    private Date dateToCompare;
    private String saveType;
    private BigDecimal cifNo;
    private Date cif_UpdateDate;
    private Boolean accesByTeller = true;
    private CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
    private int accessType;
    private String linkCIFNoDesc;
    private String regionCodeDesc;
    private String sectorDesc;
    private String poBoxAreaDesc;
    private String cityCodeDesc;
    private String idTypeDesc;
    private String idNationalityDesc;
    private String idPalceOfBirthDesc;
    private String countryDesc;
    private String postalcodeDesc;
    private String residenceTypeDesc;
    private String bankCIFNoDesc;
    private String currencyCodeDesc;
    private String s_type;
    private BigDecimal idPOBorNationality;
    private String currenciesDesc;
    private String bankAddress;
    private String cifRegionCodeDesc;
    private String cifCountryDesc;
    private String postalcodeDesc1;
    private String statusDesc;
    private BigDecimal lovType;
    private String langCode;
    private String allowBenefUpdateThirParty;
    private BigDecimal compCodeCif;
    
    //Hala Al Sheikh - BIPL180103
    private String blkListWarnMessage;
    
    //Rania - SBI190008 - SECP requirement for Ultimate Beneficial Owner
    private String parentCifName;
    private String parentFirstNameL;
    private String parentFirstNameO;
    private String parentSecondNameL;
    private String parentSecondNameO;
    private String parentThirdNameL;
    private String parentThirdNameO;
    private String parentLastNameL;
    private String parentLastNameO;
    private String parentMotherFirstName;
    private String parentMotherLastName;
    private String parentNickName;
    
    private List<CifMembersCO> memberGridUpdateList = new ArrayList<CifMembersCO>();
    private List<FomCifAuthSignatoryCO> moreSignatoryGridUpdateList = new ArrayList<FomCifAuthSignatoryCO>();
    private List<FOMOwnerShipDetailsCO> ownerGridUpdateList = new ArrayList<FOMOwnerShipDetailsCO>();
    
    private BigDecimal parentCifNo;
    private BigDecimal fomRealBenefCifType;
    private String confirmMessage;
    private Date cancelDeleteDate;
    private BigDecimal olErrorCode;
    private String osErrorDesc;
    private String mainFormChange;
    //
    private String fromNew;
    
    public String getFromNew()
    {
        return fromNew;
    }
    public void setFromNew(String fromNew)
    {
        this.fromNew = fromNew;
    }
    public CIFVO getCifVO()
    {
        return cifVO;
    }
    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }
    public CIF_ADDRESSVO getCifAddressVO()
    {
        return cifAddressVO;
    }
    public void setCifAddressVO(CIF_ADDRESSVO cifAddressVO)
    {
        this.cifAddressVO = cifAddressVO;
    }
    private String latestCifupdateDate;
    
    
    
    
    
    
    public String getLatestCifupdateDate()
    {
        return latestCifupdateDate;
    }
    public void setLatestCifupdateDate(String latestCifupdateDate)
    {
        this.latestCifupdateDate = latestCifupdateDate;
    }
    public CIF_PROXY_BENEFVO getCifProxyBenfVO()
    {
        return cifProxyBenfVO;
    }
    public void setCifProxyBenfVO(CIF_PROXY_BENEFVO cifProxyBenfVO)
    {
        this.cifProxyBenfVO = cifProxyBenfVO;
    }
    public CIF_PROXY_BENEF_DETVO getCifProxyBenfDetVO()
    {
        return cifProxyBenfDetVO;
    }
    public AMFVO getAmfVO()
    {
        return amfVO;
    }
    public void setAmfVO(AMFVO amfVO)
    {
        this.amfVO = amfVO;
    }
    public void setCifProxyBenfDetVO(CIF_PROXY_BENEF_DETVO cifProxyBenfDetVO)
    {
        this.cifProxyBenfDetVO = cifProxyBenfDetVO;
    }
    public String getCifStatus()
    {
        return cifStatus;
    }
    public void setCifStatus(String cifStatus)
    {
        this.cifStatus = cifStatus;
    }
    public BigDecimal getCifType()
    {
        return cifType;
    }
    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }
    public String getSaveType()
    {
        return saveType;
    }
    public void setSaveType(String saveType)
    {
        this.saveType = saveType;
    }
    public BigDecimal getCifNo()
    {
        return cifNo;
    }
    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
    public Date getCif_UpdateDate()
    {
        return cif_UpdateDate;
    }
    public void setCif_UpdateDate(Date cifUpdateDate)
    {
        cif_UpdateDate = cifUpdateDate;
    }
    public CIFCONTROLVO getCifControlVO()
    {
        return cifControlVO;
    }
    public String getFromField()
    {
        return fromField;
    }
    public void setFromField(String fromField)
    {
        this.fromField = fromField;
    }
    public void setCifControlVO(CIFCONTROLVO cifControlVO)
    {
        this.cifControlVO = cifControlVO;
    }
    public CTSTELLERVO getCtsTellerVO()
    {
        return ctsTellerVO;
    }
    public String getCifRegionCodeDesc()
    {
        return cifRegionCodeDesc;
    }
    public String getPostalcodeDesc1()
    {
        return postalcodeDesc1;
    }
    public void setPostalcodeDesc1(String postalcodeDesc1)
    {
        this.postalcodeDesc1 = postalcodeDesc1;
    }
    public String getCifCountryDesc()
    {
        return cifCountryDesc;
    }
    public void setCifCountryDesc(String cifCountryDesc)
    {
        this.cifCountryDesc = cifCountryDesc;
    }
    public void setCifRegionCodeDesc(String cifRegionCodeDesc)
    {
        this.cifRegionCodeDesc = cifRegionCodeDesc;
    }
    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
        this.ctsTellerVO = ctsTellerVO;
    }
    public Boolean getAccesByTeller()
    {
        return accesByTeller;
    }
    public void setAccesByTeller(Boolean accesByTeller)
    {
        this.accesByTeller = accesByTeller;
    }
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
    {
        return buisnessElement;
    }
    public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
    {
        this.buisnessElement = buisnessElement;
    }
    public int getAccessType()
    {
        return accessType;
    }
    public void setAccessType(int accessType)
    {
        this.accessType = accessType;
    }
    public String getCurrencyCodeDesc()
    {
        return currencyCodeDesc;
    }
    public void setCurrencyCodeDesc(String currencyCodeDesc)
    {
        this.currencyCodeDesc = currencyCodeDesc;
    }
    public String getBankCIFNoDesc()
    {
        return bankCIFNoDesc;
    }
    public void setBankCIFNoDesc(String bankCIFNoDesc)
    {
        this.bankCIFNoDesc = bankCIFNoDesc;
    }
    public String getPostalcodeDesc()
    {
        return postalcodeDesc;
    }
    public void setPostalcodeDesc(String postalcodeDesc)
    {
        this.postalcodeDesc = postalcodeDesc;
    }
    public String getCountryDesc()
    {
        return countryDesc;
    }
    public void setCountryDesc(String countryDesc)
    {
        this.countryDesc = countryDesc;
    }
    public String getLinkCIFNoDesc()
    {
        return linkCIFNoDesc;
    }
    public String getIdPalceOfBirthDesc()
    {
        return idPalceOfBirthDesc;
    }
    public void setIdPalceOfBirthDesc(String idPalceOfBirthDesc)
    {
        this.idPalceOfBirthDesc = idPalceOfBirthDesc;
    }
    public BigDecimal getIdPOBorNationality()
    {
        return idPOBorNationality;
    }
    public void setIdPOBorNationality(BigDecimal idPOBorNationality)
    {
        this.idPOBorNationality = idPOBorNationality;
    }
    public String getIdNationalityDesc()
    {
        return idNationalityDesc;
    }
    public void setIdNationalityDesc(String idNationalityDesc)
    {
        this.idNationalityDesc = idNationalityDesc;
    }
    public void setLinkCIFNoDesc(String linkCIFNoDesc)
    {
        this.linkCIFNoDesc = linkCIFNoDesc;
    }
    public String getS_type()
    {
        return s_type;
    }
    public Date getDateToCompare()
    {
        return dateToCompare;
    }
    public void setDateToCompare(Date dateToCompare)
    {
        this.dateToCompare = dateToCompare;
    }
    public String getPoBoxAreaDesc()
    {
        return poBoxAreaDesc;
    }
    public void setPoBoxAreaDesc(String poBoxAreaDesc)
    {
        this.poBoxAreaDesc = poBoxAreaDesc;
    }
    public String getSectorDesc()
    {
        return sectorDesc;
    }
    public void setSectorDesc(String sectorDesc)
    {
        this.sectorDesc = sectorDesc;
    }
    public void setS_type(String sType)
    {
        s_type = sType;
    }
    public String getRegionCodeDesc()
    {
        return regionCodeDesc;
    }
    public void setRegionCodeDesc(String regionCodeDesc)
    {
        this.regionCodeDesc = regionCodeDesc;
    }
    public String getCityCodeDesc()
    {
        return cityCodeDesc;
    }
    public void setCityCodeDesc(String cityCodeDesc)
    {
        this.cityCodeDesc = cityCodeDesc;
    }
    public BigDecimal getLineNo()
    {
        return lineNo;
    }
    public String getCurrenciesDesc()
    {
        return currenciesDesc;
    }
    public void setCurrenciesDesc(String currenciesDesc)
    {
        this.currenciesDesc = currenciesDesc;
    }
    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }
    public String getIdTypeDesc()
    {
        return idTypeDesc;
    }
    public void setIdTypeDesc(String idTypeDesc)
    {
        this.idTypeDesc = idTypeDesc;
    }
    public String getResidenceTypeDesc()
    {
        return residenceTypeDesc;
    }
    public void setResidenceTypeDesc(String residenceTypeDesc)
    {
        this.residenceTypeDesc = residenceTypeDesc;
    }
    public String getBankAddress()
    {
        return bankAddress;
    }
    public void setBankAddress(String bankAddress)
    {
        this.bankAddress = bankAddress;
    }
    public String getCifProxyCountryOfIssuanceDesc()
    {
        return cifProxyCountryOfIssuanceDesc;
    }
    public void setCifProxyCountryOfIssuanceDesc(String cifProxyCountryOfIssuanceDesc)
    {
        this.cifProxyCountryOfIssuanceDesc = cifProxyCountryOfIssuanceDesc;
    }
    public CIF_EXTENDEDVO getCifExtendedVO()
    {
        return cifExtendedVO;
    }
    public void setCifExtendedVO(CIF_EXTENDEDVO cifExtendedVO)
    {
        this.cifExtendedVO = cifExtendedVO;
    }
    public String getStatusDesc()
    {
        return statusDesc;
    }
    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }
    public BigDecimal getLovType()
    {
        return lovType;
    }
    public void setLovType(BigDecimal lovType)
    {
        this.lovType = lovType;
    }
    public String getLangCode()
    {
        return langCode;
    }
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
    public String getAllowBenefUpdateThirParty()
    {
        return allowBenefUpdateThirParty;
    }
    public void setAllowBenefUpdateThirParty(String allowBenefUpdateThirParty)
    {
        this.allowBenefUpdateThirParty = allowBenefUpdateThirParty;
    }
    public String getBlkListWarnMessage()
    {
        return blkListWarnMessage;
    }
    public void setBlkListWarnMessage(String blkListWarnMessage)
    {
        this.blkListWarnMessage = blkListWarnMessage;
    }
    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }
    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }    

    public String getParentCifName()
    {
        return parentCifName;
    }
    public void setParentCifName(String parentCifName)
    {
        this.parentCifName = parentCifName;
    }
    public String getParentFirstNameL()
    {
        return parentFirstNameL;
    }
    public void setParentFirstNameL(String parentFirstNameL)
    {
        this.parentFirstNameL = parentFirstNameL;
    }
    public String getParentFirstNameO()
    {
        return parentFirstNameO;
    }
    public void setParentFirstNameO(String parentFirstNameO)
    {
        this.parentFirstNameO = parentFirstNameO;
    }
    public String getParentSecondNameL()
    {
        return parentSecondNameL;
    }
    public void setParentSecondNameL(String parentSecondNameL)
    {
        this.parentSecondNameL = parentSecondNameL;
    }
    public String getParentSecondNameO()
    {
        return parentSecondNameO;
    }
    public void setParentSecondNameO(String parentSecondNameO)
    {
        this.parentSecondNameO = parentSecondNameO;
    }
    public String getParentThirdNameL()
    {
        return parentThirdNameL;
    }
    public void setParentThirdNameL(String parentThirdNameL)
    {
        this.parentThirdNameL = parentThirdNameL;
    }
    public String getParentThirdNameO()
    {
        return parentThirdNameO;
    }
    public void setParentThirdNameO(String parentThirdNameO)
    {
        this.parentThirdNameO = parentThirdNameO;
    }
    public String getParentLastNameL()
    {
        return parentLastNameL;
    }
    public void setParentLastNameL(String parentLastNameL)
    {
        this.parentLastNameL = parentLastNameL;
    }
    public String getParentLastNameO()
    {
        return parentLastNameO;
    }
    public void setParentLastNameO(String parentLastNameO)
    {
        this.parentLastNameO = parentLastNameO;
    }
    public String getParentMotherFirstName()
    {
        return parentMotherFirstName;
    }
    public void setParentMotherFirstName(String parentMotherFirstName)
    {
        this.parentMotherFirstName = parentMotherFirstName;
    }
    public String getParentMotherLastName()
    {
        return parentMotherLastName;
    }
    public void setParentMotherLastName(String parentMotherLastName)
    {
        this.parentMotherLastName = parentMotherLastName;
    }
    public String getParentNickName()
    {
        return parentNickName;
    }
    public void setParentNickName(String parentNickName)
    {
        this.parentNickName = parentNickName;
    }
    public List<CifMembersCO> getMemberGridUpdateList()
    {
        return memberGridUpdateList;
    }
    public void setMemberGridUpdateList(List<CifMembersCO> memberGridUpdateList)
    {
        this.memberGridUpdateList = memberGridUpdateList;
    }
    public List<FomCifAuthSignatoryCO> getMoreSignatoryGridUpdateList()
    {
        return moreSignatoryGridUpdateList;
    }
    public void setMoreSignatoryGridUpdateList(List<FomCifAuthSignatoryCO> moreSignatoryGridUpdateList)
    {
        this.moreSignatoryGridUpdateList = moreSignatoryGridUpdateList;
    }
    public List<FOMOwnerShipDetailsCO> getOwnerGridUpdateList()
    {
        return ownerGridUpdateList;
    }
    public void setOwnerGridUpdateList(List<FOMOwnerShipDetailsCO> ownerGridUpdateList)
    {
        this.ownerGridUpdateList = ownerGridUpdateList;
    }
    public BigDecimal getParentCifNo()
    {
        return parentCifNo;
    }
    public void setParentCifNo(BigDecimal parentCifNo)
    {
        this.parentCifNo = parentCifNo;
    }
    public BigDecimal getFomRealBenefCifType()
    {
        return fomRealBenefCifType;
    }
    public void setFomRealBenefCifType(BigDecimal fomRealBenefCifType)
    {
        this.fomRealBenefCifType = fomRealBenefCifType;
    }
    public String getConfirmMessage()
    {
        return confirmMessage;
    }
    public void setConfirmMessage(String confirmMessage)
    {
        this.confirmMessage = confirmMessage;
    }
    public Date getCancelDeleteDate()
    {
        return cancelDeleteDate;
    }
    public void setCancelDeleteDate(Date cancelDeleteDate)
    {
        this.cancelDeleteDate = cancelDeleteDate;
    }
    public BigDecimal getOlErrorCode()
    {
        return olErrorCode;
    }
    public void setOlErrorCode(BigDecimal olErrorCode)
    {
        this.olErrorCode = olErrorCode;
    }
    public String getOsErrorDesc()
    {
        return osErrorDesc;
    }
    public void setOsErrorDesc(String osErrorDesc)
    {
        this.osErrorDesc = osErrorDesc;
    }
    public String getMainFormChange()
    {
        return mainFormChange;
    }
    public void setMainFormChange(String mainFormChange)
    {
        this.mainFormChange = mainFormChange;
    }
}
