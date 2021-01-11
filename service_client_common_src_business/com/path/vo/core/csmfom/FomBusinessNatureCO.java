package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.CIF_BUSINESS_NATURE_DETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

 public class FomBusinessNatureCO extends  RetailBaseVO
 {
	private CIF_BUSINESS_NATURE_DETVO businessNatureVO = new CIF_BUSINESS_NATURE_DETVO();

	private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	CTSTELLERVO ctsTellerVO = new CTSTELLERVO() ;
	private BigDecimal decimalPoint;
	private String currencyDesc;
	private String saveType;
	private String cifStatus;
	private String iv_crud;
	private Date cif_UpdateDate ;
	private String accesByTeller="true";
	private BigDecimal amtFormat ;
	
	//Added by Mark Ayoub on 02/06/2018 - Needed for cifType mandatory expression
	private BigDecimal cifType;
	//End Mark
	private BigDecimal countryID;
	
	//used for webservice 
	private String deleteBusinessNature;
		
	
	public CIF_BUSINESS_NATURE_DETVO getBusinessNatureVO()
	{
		return businessNatureVO;
	}
	public void setBusinessNatureVO(CIF_BUSINESS_NATURE_DETVO businessNatureVO)
	{
		this.businessNatureVO = businessNatureVO;
	}
	public String getCurrencyDesc()
	{
		return currencyDesc;
	}
	public void setCurrencyDesc(String currencyDesc)
	{
		this.currencyDesc = currencyDesc;
	}
	public BigDecimal getDecimalPoint()
	{
		return decimalPoint;
	}
	public void setDecimalPoint(BigDecimal decimalPoint)
	{
		this.decimalPoint = decimalPoint;
	}
	public String getSaveType()
	{
		return saveType;
	}
	public void setSaveType(String saveType)
	{
		this.saveType = saveType;
	}
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
	public BigDecimal getAmtFormat()
	{
		return amtFormat;
	}
	public void setAmtFormat(BigDecimal amtFormat)
	{
		this.amtFormat = amtFormat;
	}
	public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
	{
	    return buisnessElement;
	}
	public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
	{
	    this.buisnessElement = buisnessElement;
	}
	public String getAccesByTeller()
	{
	    return accesByTeller;
	}
	public void setAccesByTeller(String accesByTeller)
	{
	    this.accesByTeller = accesByTeller;
	}
	public BigDecimal getCifType()
	{
	    return cifType;
	}
	public void setCifType(BigDecimal cifType)
	{
	    this.cifType = cifType;
	}
	public BigDecimal getCountryID()
	{
	    return countryID;
	}
	public void setCountryID(BigDecimal countryID)
	{
	    this.countryID = countryID;
	}
	
	public String getDeleteBusinessNature()
	{
	    return deleteBusinessNature;
	}
	public void setDeleteBusinessNature(String deleteBusinessNature)
	{
	    this.deleteBusinessNature = deleteBusinessNature;
	}
	
	
	
	
 }