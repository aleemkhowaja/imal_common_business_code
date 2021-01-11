package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

 public class FomCifAddressCO extends  RetailBaseVO
 {
	private CIF_ADDRESSVO cifAddressVO = new CIF_ADDRESSVO();
	CTSTELLERVO ctsTellerVO = new CTSTELLERVO() ;
	private String saveType;
	// For check Box on screen
	private Boolean permnAddrFlag;
	private Boolean printAddrFlag;
	private Boolean defaultAddrFlag;
	private String cifStatus;
	private String iv_crud;
	private Date cif_UpdateDate ;
	private BigDecimal compCodeCif;
	private boolean changedAddress;
	
	
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
	
	
	public CIF_ADDRESSVO getCifAddressVO()
	{
		return cifAddressVO;
	}
	public void setCifAddressVO(CIF_ADDRESSVO cifAddressVO)
	{
		this.cifAddressVO = cifAddressVO;
	}
	public String getSaveType()
	{
		return saveType;
	}
	public void setSaveType(String saveType)
	{
		this.saveType = saveType;
	}
	public Boolean getPermnAddrFlag()
	{
		return permnAddrFlag;
	}
	public void setPermnAddrFlag(Boolean permnAddrFlag)
	{
		this.permnAddrFlag = permnAddrFlag;
	}
	public Boolean getDefaultAddrFlag()
	{
		return defaultAddrFlag;
	}
	public void setDefaultAddrFlag(Boolean defaultAddrFlag)
	{
		this.defaultAddrFlag = defaultAddrFlag;
	}
	public Boolean getPrintAddrFlag()
	{
		return printAddrFlag;
	}
	public void setPrintAddrFlag(Boolean printAddrFlag)
	{
		this.printAddrFlag = printAddrFlag;
	}
	public BigDecimal getCompCodeCif()
	{
	    return compCodeCif;
	}
	public void setCompCodeCif(BigDecimal compCodeCif)
	{
	    this.compCodeCif = compCodeCif;
	}
	public boolean isChangedAddress()
	{
	    return changedAddress;
	}
	public void setChangedAddress(boolean changedAddress)
	{
	    this.changedAddress = changedAddress;
	}
	
}