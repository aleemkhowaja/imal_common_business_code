package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.CIF_OCCUPATIONVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.vo.core.common.RetailBaseVO;

public class FomCifOccupationCO extends RetailBaseVO
{

    CIF_OCCUPATIONVO cif_OccupationVO = new CIF_OCCUPATIONVO();
    CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String saveType;
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private String preferredLanguage;// Preferred Language "A" or "L"
    private String progRef; // MODIF  BMOI130018 - Joyce KANAZEH

    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private Boolean accesByTeller = true;
    private BigDecimal salVisible;
    private String countryDesc;
    private String regionDesc;
    private String positionDesc;
    private String divisionDesc;
    private String occupationDesc;
    private String deptDesc;
    private String legalStatusDesc;
    private String cityDesc;
    
    private String cityLongDesc;
    private String countryLongDesc;
    private String regionLongDesc;
    private String positionLongDesc;
    
    //Added by Mark Ayoub on 02/06/2018 - Needed for cifType mandatory expression
    private BigDecimal cifType;
    private BigDecimal cifNo;
    
    // MODIF  BMOI130018 - Joyce KANAZEH

    private String mainOccupationYN ;
    //in case the user chooses yes in confirmation, we set this property to 1
    private String mainOccupationSet ;
    
    private BigDecimal priorityCode;
    private String priorityDesc;
    
    private ArrayList<FomCifOccupationCO> cifOccupationListCOs = new ArrayList<FomCifOccupationCO>();
    

	// END  MODIF  BMOI130018 - Joyce KANAZEH
    
    //used for webservice 
    private String deleteCifOccupation;
    
    private BigDecimal countryID;
  	
    //Hala Al Sheikh - BIPL180103
    private String blkListWarnMessage;
    private CIFVO cifVO;
    private String postalCodeAreaDesc;
    private String postalcodeDesc;
    
    public String getPreferredLanguage()
    {
	return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
	this.preferredLanguage = preferredLanguage;
    }

    public Date getCif_UpdateDate()
    {
	return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
	cif_UpdateDate = cifUpdateDate;
    }

    public CIF_OCCUPATIONVO getCif_OccupationVO()
    {
	return cif_OccupationVO;
    }

    public void setCif_OccupationVO(CIF_OCCUPATIONVO cifOccupationVO)
    {
	cif_OccupationVO = cifOccupationVO;
    }

    // MODIF  BMOI130018 - Joyce KANAZEH
    
    public String getProgRef()
    {
        return progRef;
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    
    // END MODIF  BMOI130018 - Joyce KANAZEH

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
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

    public BigDecimal getSalVisible()
    {
	return salVisible;
    }

    public void setSalVisible(BigDecimal salVisible)
    {
	this.salVisible = salVisible;
    }

    public String getCountryDesc()
    {
        return countryDesc;
    }

    public void setCountryDesc(String countryDesc)
    {
        this.countryDesc = countryDesc;
    }

    public String getRegionDesc()
    {
        return regionDesc;
    }

    public void setRegionDesc(String regionDesc)
    {
        this.regionDesc = regionDesc;
    }

    public ArrayList<FomCifOccupationCO> getCifOccupationListCOs()
    {
        return cifOccupationListCOs;
    }

    public void setCifOccupationListCOs(ArrayList<FomCifOccupationCO> cifOccupationListCOs)
    {
        this.cifOccupationListCOs = cifOccupationListCOs;
    }

    public String getPositionDesc()
    {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc)
    {
        this.positionDesc = positionDesc;
    }

    public String getDivisionDesc()
    {
        return divisionDesc;
    }

    public void setDivisionDesc(String divisionDesc)
    {
        this.divisionDesc = divisionDesc;
    }

    public String getOccupationDesc()
    {
        return occupationDesc;
    }

    public void setOccupationDesc(String occupationDesc)
    {
        this.occupationDesc = occupationDesc;
    }

    public String getDeptDesc()
    {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc)
    {
        this.deptDesc = deptDesc;
    }

    public String getLegalStatusDesc()
    {
        return legalStatusDesc;
    }

    public void setLegalStatusDesc(String legalStatusDesc)
    {
        this.legalStatusDesc = legalStatusDesc;
    }
    
    // MODIF  BMOI130018 - Joyce KANAZEH

    public String getMainOccupationYN()
    {
        return mainOccupationYN;
    }

    public void setMainOccupationYN(String mainOccupationYN)
    {
        this.mainOccupationYN = mainOccupationYN;
    }

    public String getMainOccupationSet()
    {
        return mainOccupationSet;
    }

    public void setMainOccupationSet(String mainOccupationSet)
    {
        this.mainOccupationSet = mainOccupationSet;
    }

    public String getCityDesc()
    {
        return cityDesc;
    }

    public void setCityDesc(String cityDesc)
    {
        this.cityDesc = cityDesc;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public String getRegionLongDesc() {
	return regionLongDesc;
    }

    public void setRegionLongDesc(String regionLongDesc) {
	this.regionLongDesc = regionLongDesc;
    }

    public String getPositionLongDesc() {
	return positionLongDesc;
    }

    public void setPositionLongDesc(String positionLongDesc) {
	this.positionLongDesc = positionLongDesc;
    }

    public String getCountryLongDesc() {
	return countryLongDesc;
    }

    public void setCountryLongDesc(String countryLongDesc) {
	this.countryLongDesc = countryLongDesc;
    }

    public String getCityLongDesc() {
	return cityLongDesc;
    }

    public void setCityLongDesc(String cityLongDesc) {
	this.cityLongDesc = cityLongDesc;
    }

    public BigDecimal getPriorityCode()
    {
	return priorityCode;
    }

    public void setPriorityCode(BigDecimal priorityCode)
    {
	this.priorityCode = priorityCode;
    }

    public String getPriorityDesc()
    {
	return priorityDesc;
    }

    public void setPriorityDesc(String priorityDesc)
    {
	this.priorityDesc = priorityDesc;
    }

    public String getDeleteCifOccupation()
    {
        return deleteCifOccupation;
    }

    public void setDeleteCifOccupation(String deleteCifOccupation)
    {
        this.deleteCifOccupation = deleteCifOccupation;
    }

    public BigDecimal getCountryID()
    {
        return countryID;
    }

    public void setCountryID(BigDecimal countryID)
    {
        this.countryID = countryID;
    }

    public String getBlkListWarnMessage()
    {
        return blkListWarnMessage;
    }

    public void setBlkListWarnMessage(String blkListWarnMessage)
    {
        this.blkListWarnMessage = blkListWarnMessage;
    }

    //// END MODIF  BMOI130018 - Joyce KANAZEH

  

	public String getPostalCodeAreaDesc() {
		return postalCodeAreaDesc;
	}

	public void setPostalCodeAreaDesc(String postalCodeAreaDesc) {
		this.postalCodeAreaDesc = postalCodeAreaDesc;
	}

	public String getPostalcodeDesc() {
		return postalcodeDesc;
	}

	public void setPostalcodeDesc(String postalcodeDesc) {
		this.postalcodeDesc = postalcodeDesc;
	}

	    public CIFVO getCifVO()
	    {
	        return cifVO;
	    }

	    public void setCifVO(CIFVO cifVO)
	    {
	        this.cifVO = cifVO;
	    }
	    
}
