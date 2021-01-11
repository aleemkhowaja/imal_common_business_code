package com.path.vo.core.aml;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import com.path.dbmaps.vo.AML_KYCVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_KYCVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * KycManagementCO.java used to
 */
public class KycManagementCO extends RetailBaseVO
{

	private AML_KYCVO amlKycVO = new AML_KYCVO();
	private AML_KYCVO oldAmlKycVO = new AML_KYCVO();
	private CIF_KYCVO cifKycVO = new CIF_KYCVO();
	private CIFVO cifVO = new CIFVO();
	private RIFCTTVO  rifcttVO = new RIFCTTVO();


	private String ivCrud;
	private BigDecimal LovTypeId;
	private String ProgRef;
	private BigDecimal code;
	private BigDecimal cif;
	private BigDecimal branch;
	private String statusDesc;
	private BigDecimal delete;
	private BigDecimal method;
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> screenParam = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private ArrayList<SmartCO> smartCOList;
	private String desc;
	private BigDecimal applyCorporateKycId;
	private String additionnalKycProps;
	private BigDecimal kycRegion;
	private String kycRegionDesc;
	private BigDecimal kycAddressPostalCode;
	private String kycHouseBuildling;
	private String kycTel;
	private String kycFax;
	private String kycPoBox;
	private String kycAddressPostalCodeDesc;
	private String kycLoadPassPortInfo;
	private BigDecimal cifType;
	private BigDecimal isEmptyScreen;
	private BigDecimal screenId;
	private String cifStatus;
	private String cifLanguage;
	private String cif_vtInd;
	private String SHORT_NAME_ENG;
	private BigDecimal CIF_TYPE;
	private String STATUS;
	private String LANGUAGE;

	public String getIvCrud()
	{
		return ivCrud;
	}

	public void setIvCrud(String ivCrud)
	{
		this.ivCrud = ivCrud;
	}

	public BigDecimal getLovTypeId()
	{
		return LovTypeId;
	}

	public void setLovTypeId(BigDecimal lovTypeId)
	{
		LovTypeId = lovTypeId;
	}

	public String getProgRef()
	{
		return ProgRef;
	}

	public void setProgRef(String progRef)
	{
		ProgRef = progRef;
	}

	public BigDecimal getCode()
	{
		return code;
	}

	public void setCode(BigDecimal code)
	{
		this.code = code;
	}

	public BigDecimal getCif()
	{
		return cif;
	}

	public void setCif(BigDecimal cif)
	{
		this.cif = cif;
	}

	public BigDecimal getBranch()
	{
		return branch;
	}

	public void setBranch(BigDecimal branch)
	{
		this.branch = branch;
	}

	public String getStatusDesc()
	{
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}

	public BigDecimal getDelete()
	{
		return delete;
	}

	public void setDelete(BigDecimal delete)
	{
		this.delete = delete;
	}

	public BigDecimal getMethod()
	{
		return method;
	}

	public void setMethod(BigDecimal method)
	{
		this.method = method;
	}

	public AML_KYCVO getAmlKycVO()
	{
		return amlKycVO;
	}

	public void setAmlKycVO(AML_KYCVO amlKycVO)
	{
		this.amlKycVO = amlKycVO;
	}

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getScreenParam()
	{
		return screenParam;
	}

	public void setScreenParam(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> screenParam)
	{
		this.screenParam = screenParam;
	}

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
	{
		return buisnessElement;
	}

	public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
	{
		this.buisnessElement = buisnessElement;
	}

	public ArrayList<SmartCO> getSmartCOList()
	{
		return smartCOList;
	}

	public void setSmartCOList(ArrayList<SmartCO> smartCOList)
	{
		this.smartCOList = smartCOList;
	}

	public AML_KYCVO getOldAmlKycVO()
	{
		return oldAmlKycVO;
	}

	public void setOldAmlKycVO(AML_KYCVO oldAmlKycVO)
	{
		this.oldAmlKycVO = oldAmlKycVO;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}


	public BigDecimal getApplyCorporateKycId()
	{
		return applyCorporateKycId;
	}

	public void setApplyCorporateKycId(BigDecimal applyCorporateKycId)
	{
		this.applyCorporateKycId = applyCorporateKycId;
	}

	public String getAdditionnalKycProps()
	{
		return additionnalKycProps;
	}

	public void setAdditionnalKycProps(String additionnalKycProps)
	{
		this.additionnalKycProps = additionnalKycProps;
	}

	public BigDecimal getKycRegion()
	{
		return kycRegion;
	}

	public void setKycRegion(BigDecimal kycRegion)
	{
		this.kycRegion = kycRegion;
	}

	public String getKycRegionDesc()
	{
		return kycRegionDesc;
	}

	public void setKycRegionDesc(String kycRegionDesc)
	{
		this.kycRegionDesc = kycRegionDesc;
	}

	public BigDecimal getKycAddressPostalCode()
	{
		return kycAddressPostalCode;
	}

	public void setKycAddressPostalCode(BigDecimal kycAddressPostalCode)
	{
		this.kycAddressPostalCode = kycAddressPostalCode;
	}

	public String getKycHouseBuildling()
	{
		return kycHouseBuildling;
	}

	public void setKycHouseBuildling(String kycHouseBuildling)
	{
		this.kycHouseBuildling = kycHouseBuildling;
	}

	public String getKycTel()
	{
		return kycTel;
	}

	public void setKycTel(String kycTel)
	{
		this.kycTel = kycTel;
	}

	public String getKycFax()
	{
		return kycFax;
	}

	public void setKycFax(String kycFax)
	{
		this.kycFax = kycFax;
	}

	public String getKycPoBox()
	{
		return kycPoBox;
	}

	public void setKycPoBox(String kycPoBox)
	{
		this.kycPoBox = kycPoBox;
	}

	public String getKycAddressPostalCodeDesc()
	{
		return kycAddressPostalCodeDesc;
	}

	public void setKycAddressPostalCodeDesc(String kycAddressPostalCodeDesc)
	{
		this.kycAddressPostalCodeDesc = kycAddressPostalCodeDesc;
	}

	public String getKycLoadPassPortInfo()
	{
		return kycLoadPassPortInfo;
	}

	public void setKycLoadPassPortInfo(String kycLoadPassPortInfo)
	{
		this.kycLoadPassPortInfo = kycLoadPassPortInfo;
	}

	public BigDecimal getCifType()
	{
		return cifType;
	}

	public void setCifType(BigDecimal cifType)
	{
		this.cifType = cifType;
	}

	public BigDecimal getIsEmptyScreen()
	{
		return isEmptyScreen;
	}

	public void setIsEmptyScreen(BigDecimal isEmptyScreen)
	{
		this.isEmptyScreen = isEmptyScreen;
	}

	public CIF_KYCVO getCifKycVO()
	{
		return cifKycVO;
	}

	public void setCifKycVO(CIF_KYCVO cifKycVO)
	{
		this.cifKycVO = cifKycVO;
	}

	public BigDecimal getScreenId()
	{
		return screenId;
	}

	public void setScreenId(BigDecimal screenId)
	{
		this.screenId = screenId;
	}

	public String getCifStatus()
	{
		return cifStatus;
	}

	public void setCifStatus(String cifStatus)
	{
		this.cifStatus = cifStatus;
	}

	public String getCifLanguage()
	{
		return cifLanguage;
	}

	public void setCifLanguage(String cifLanguage)
	{
		this.cifLanguage = cifLanguage;
	}

	
	public CIFVO getCifVO()
	{
		return cifVO;
	}

	
	public void setCifVO(CIFVO cifVO)
	{
		this.cifVO = cifVO;
	}

	
	public RIFCTTVO getRifcttVO()
	{
		return rifcttVO;
	}

	
	public void setRifcttVO(RIFCTTVO rifcttVO)
	{
		this.rifcttVO = rifcttVO;
	}

	
	public String getCif_vtInd()
	{
		return cif_vtInd;
	}

	
	public void setCif_vtInd(String cif_vtInd)
	{
		this.cif_vtInd = cif_vtInd;
	}

	
	public String getSHORT_NAME_ENG()
	{
		return SHORT_NAME_ENG;
	}

	
	public void setSHORT_NAME_ENG(String sHORT_NAME_ENG)
	{
		SHORT_NAME_ENG = sHORT_NAME_ENG;
	}

	
	

	
	
	public BigDecimal getCIF_TYPE()
	{
		return CIF_TYPE;
	}

	
	public void setCIF_TYPE(BigDecimal cIF_TYPE)
	{
		CIF_TYPE = cIF_TYPE;
	}

	public String getSTATUS()
	{
		return STATUS;
	}

	
	public void setSTATUS(String sTATUS)
	{
		STATUS = sTATUS;
	}

	
	public String getLANGUAGE()
	{
		return LANGUAGE;
	}

	
	public void setLANGUAGE(String lANGUAGE)
	{
		LANGUAGE = lANGUAGE;
	}
	

}
