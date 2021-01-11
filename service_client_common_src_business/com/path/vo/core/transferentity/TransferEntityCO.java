package com.path.vo.core.transferentity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.path.dbmaps.vo.CTS_TRANSFER_ENTITYVO;
import com.path.dbmaps.vo.FMSAPPLVO;
import com.path.dbmaps.vo.FMSFACILITYTYPEVO;
import com.path.dbmaps.vo.FMSFACILITYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.core.common.RetailBaseVO;

public class TransferEntityCO extends RetailBaseVO
{

	private CTS_TRANSFER_ENTITYVO transferEntityVO = new CTS_TRANSFER_ENTITYVO();
	private BigDecimal batchNo;
	private BigDecimal branchCode;
	private String statusDesc;
	private FMSFACILITYTYPEVO fmsFacilityTypeVO = new FMSFACILITYTYPEVO();
	private FMSFACILITYVO fmsFacilityVO = new FMSFACILITYVO(); 
	

	private BigDecimal CIF_TYPE;
	private BigDecimal ACCOUNT_TYPE;
	private BigDecimal FACILITY_TYPE;
	private BigDecimal FROM_CIF;
	private BigDecimal TO_CIF;
	private BigDecimal FROM_APP;
	private BigDecimal TO_APP;
	private BigDecimal facilityCateg;
	
	
	private String relationManagerAtRetrieve;
	private String rangeTypeAtRetrieve;
	private String     filterTypeAtRetrieve;

	private String relationManagerDesc;
	private String destRmDesc;
	private String cifTypeDesc;
	private String accTypeDesc;
	private String fromCifDesc;
	private String toCifDesc;
	private String codeTypeDesc;
	private String transferTypeDesc;
	private String rangeTypeDesc;
	private String filterTypeDesc;
	private String fromCodeDesc;
	private String toCodeDesc;
	private String facilityBranchDesc;
	private String facilityTypeDesc;

	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	private String preferredLang;
	private String transferEntityDetSelectedRecords;
	private List<TransferEntityGridCO> transferEntityGridList;
	private String isFromAlert;
	private AlertsParamCO alertsParamCO = new AlertsParamCO();
	private String warningMessages;
	private List<String> listWarningMsg = new ArrayList<String>();
	//added by ali harissa for bug
	private String userId;
	private String userDesc;

	public CTS_TRANSFER_ENTITYVO getTransferEntityVO()
	{
		return transferEntityVO;
	}

	public void setTransferEntityVO(CTS_TRANSFER_ENTITYVO transferEntityVO)
	{
		this.transferEntityVO = transferEntityVO;
	}
	
	public String getStatusDesc()
	{
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}

	public BigDecimal getCIF_TYPE()
	{
		return CIF_TYPE;
	}

	public void setCIF_TYPE(BigDecimal cIF_TYPE)
	{
		CIF_TYPE = cIF_TYPE;
	}

	public BigDecimal getACCOUNT_TYPE()
	{
		return ACCOUNT_TYPE;
	}

	public void setACCOUNT_TYPE(BigDecimal aCCOUNT_TYPE)
	{
		ACCOUNT_TYPE = aCCOUNT_TYPE;
	}

	public BigDecimal getFACILITY_TYPE()
	{
		return FACILITY_TYPE;
	}

	public void setFACILITY_TYPE(BigDecimal fUCILITY_TYPE)
	{
		FACILITY_TYPE = fUCILITY_TYPE;
	}

	public BigDecimal getFROM_CIF()
	{
		return FROM_CIF;
	}

	public void setFROM_CIF(BigDecimal fROM_CIF)
	{
		FROM_CIF = fROM_CIF;
	}

	public BigDecimal getTO_CIF()
	{
		return TO_CIF;
	}

	public void setTO_CIF(BigDecimal tO_CIF)
	{
		TO_CIF = tO_CIF;
	}

	public BigDecimal getFROM_APP()
	{
		return FROM_APP;
	}

	public void setFROM_APP(BigDecimal fROM_APP)
	{
		FROM_APP = fROM_APP;
	}

	public BigDecimal getTO_APP()
	{
		return TO_APP;
	}

	public void setTO_APP(BigDecimal tO_APP)
	{
		TO_APP = tO_APP;
	}

	public String getCifTypeDesc()
	{
		return cifTypeDesc;
	}

	public void setCifTypeDesc(String cifTypeDesc)
	{
		this.cifTypeDesc = cifTypeDesc;
	}

	public String getAccTypeDesc()
	{
		return accTypeDesc;
	}

	public void setAccTypeDesc(String accTypeDesc)
	{
		this.accTypeDesc = accTypeDesc;
	}

	public String getFromCifDesc()
	{
		return fromCifDesc;
	}

	public void setFromCifDesc(String fromCifDesc)
	{
		this.fromCifDesc = fromCifDesc;
	}

	public String getToCifDesc()
	{
		return toCifDesc;
	}

	public void setToCifDesc(String toCifDesc)
	{
		this.toCifDesc = toCifDesc;
	}

	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
	{
		return hm;
	}

	public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
	{
		this.hm = hm;
	}

	public String getPreferredLang()
	{
		return preferredLang;
	}

	public void setPreferredLang(String preferredLang)
	{
		this.preferredLang = preferredLang;
	}

	public String getDestRmDesc()
	{
		return destRmDesc;
	}

	public void setDestRmDesc(String destRmDesc)
	{
		this.destRmDesc = destRmDesc;
	}

	public String getRelationManagerDesc()
	{
		return relationManagerDesc;
	}

	public void setRelationManagerDesc(String relationManagerDesc)
	{
		this.relationManagerDesc = relationManagerDesc;
	}

	public BigDecimal getBatchNo()
	{
		return batchNo;
	}

	public void setBatchNo(BigDecimal batchNo)
	{
		this.batchNo = batchNo;
	}

	public BigDecimal getBranchCode()
	{
		return branchCode;
	}

	public void setBranchCode(BigDecimal branchCode)
	{
		this.branchCode = branchCode;
	}

	public String getTransferEntityDetSelectedRecords()
	{
		return transferEntityDetSelectedRecords;
	}

	public void setTransferEntityDetSelectedRecords(String transferEntityDetSelectedRecords)
	{
		this.transferEntityDetSelectedRecords = transferEntityDetSelectedRecords;
	}

	public List<TransferEntityGridCO> getTransferEntityGridList()
	{
		return transferEntityGridList;
	}

	public void setTransferEntityGridList(List<TransferEntityGridCO> transferEntityGridList)
	{
		this.transferEntityGridList = transferEntityGridList;
	}

	
	public String getCodeTypeDesc()
	{
		return codeTypeDesc;
	}

	
	public void setCodeTypeDesc(String codeTypeDesc)
	{
		this.codeTypeDesc = codeTypeDesc;
	}

	
	public String getTransferTypeDesc()
	{
		return transferTypeDesc;
	}

	
	public void setTransferTypeDesc(String transferTypeDesc)
	{
		this.transferTypeDesc = transferTypeDesc;
	}

	
	public String getRangeTypeDesc()
	{
		return rangeTypeDesc;
	}

	
	public void setRangeTypeDesc(String rangeTypeDesc)
	{
		this.rangeTypeDesc = rangeTypeDesc;
	}

	
	public String getFilterTypeDesc()
	{
		return filterTypeDesc;
	}

	
	public void setFilterTypeDesc(String filterTypeDesc)
	{
		this.filterTypeDesc = filterTypeDesc;
	}

	
	public String getFromCodeDesc()
	{
		return fromCodeDesc;
	}

	
	public void setFromCodeDesc(String fromCodeDesc)
	{
		this.fromCodeDesc = fromCodeDesc;
	}

	
	public String getToCodeDesc()
	{
		return toCodeDesc;
	}

	
	public void setToCodeDesc(String toCodeDesc)
	{
		this.toCodeDesc = toCodeDesc;
	}

	public String getIsFromAlert()
	{
		return isFromAlert;
	}

	public void setIsFromAlert(String isFromAlert)
	{
		this.isFromAlert = isFromAlert;
	}

	public AlertsParamCO getAlertsParamCO()
	{
		return alertsParamCO;
	}

	public void setAlertsParamCO(AlertsParamCO alertsParamCO)
	{
		this.alertsParamCO = alertsParamCO;
	}

	public String getWarningMessages()
	{
		return warningMessages;
	}

	public void setWarningMessages(String warningMessages)
	{
		this.warningMessages = warningMessages;
	}

	public List<String> getListWarningMsg()
	{
		return listWarningMsg;
	}

	public void setListWarningMsg(List<String> listWarningMsg)
	{
		this.listWarningMsg = listWarningMsg;
	}

	
	public FMSFACILITYTYPEVO getFmsFacilityTypeVO()
	{
		return fmsFacilityTypeVO;
	}

	
	public void setFmsFacilityTypeVO(FMSFACILITYTYPEVO fmsFacilityTypeVO)
	{
		this.fmsFacilityTypeVO = fmsFacilityTypeVO;
	}

	
	public BigDecimal getFacilityCateg()
	{
		return facilityCateg;
	}

	
	public void setFacilityCateg(BigDecimal facilityCateg)
	{
		this.facilityCateg = facilityCateg;
	}

	
	public FMSFACILITYVO getFmsFacilityVO()
	{
		return fmsFacilityVO;
	}

	
	public void setFmsFacilityVO(FMSFACILITYVO fmsFacilityVO)
	{
		this.fmsFacilityVO = fmsFacilityVO;
	}

	
	public String getFacilityBranchDesc()
	{
		return facilityBranchDesc;
	}

	
	public void setFacilityBranchDesc(String facilityBranchDesc)
	{
		this.facilityBranchDesc = facilityBranchDesc;
	}

	
	public String getFacilityTypeDesc()
	{
		return facilityTypeDesc;
	}

	
	public void setFacilityTypeDesc(String facilityTypeDesc)
	{
		this.facilityTypeDesc = facilityTypeDesc;
	}

	
	
	public String getRelationManagerAtRetrieve()
	{
		return relationManagerAtRetrieve;
	}

	
	public void setRelationManagerAtRetrieve(String relationManagerAtRetrieve)
	{
		this.relationManagerAtRetrieve = relationManagerAtRetrieve;
	}

	public String getRangeTypeAtRetrieve()
	{
		return rangeTypeAtRetrieve;
	}

	
	public void setRangeTypeAtRetrieve(String rangeTypeAtRetrieve)
	{
		this.rangeTypeAtRetrieve = rangeTypeAtRetrieve;
	}

	
	public String getFilterTypeAtRetrieve()
	{
		return filterTypeAtRetrieve;
	}

	
	public void setFilterTypeAtRetrieve(String filterTypeAtRetrieve)
	{
		this.filterTypeAtRetrieve = filterTypeAtRetrieve;
	}

	
	public String getUserId()
	{
		return userId;
	}

	
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	
	public String getUserDesc()
	{
		return userDesc;
	}

	
	public void setUserDesc(String userDesc)
	{
		this.userDesc = userDesc;
	}


}
