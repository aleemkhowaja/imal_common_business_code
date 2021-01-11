package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CIF_FINANCE_ENGVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

 public class FOMOtherFinancialEngagementsCO extends  RetailBaseVO
 {
	private CIF_FINANCE_ENGVO cifFinancialVO = new CIF_FINANCE_ENGVO();
	CTSTELLERVO ctsTellerVO = new CTSTELLERVO() ;
	private BigDecimal currencyDecimalPoints;
	private String currencyDesc;
	private String saveType;
	private String cifStatus;
	private String iv_crud;
	private Date cif_UpdateDate ;
	private Boolean accesByTeller=true;
	private BigDecimal amtFormat ;
	private BigDecimal baseAmtFormat ;
	
	//Hala Al Sheikh - BIPL180103
	private String blkListWarnMessage;
	
	public Date getCif_UpdateDate() {
		return cif_UpdateDate;
	}
	public void setCif_UpdateDate(Date cifUpdateDate) {
		cif_UpdateDate = cifUpdateDate;
	}
	public String getCifStatus() {
		return cifStatus;
	}
	public void setCifStatus(String cifStatus) {
		this.cifStatus = cifStatus;
	}
	public CTSTELLERVO getCtsTellerVO() {
		return ctsTellerVO;
	}
	public void setCtsTellerVO(CTSTELLERVO ctsTellerVO) {
		this.ctsTellerVO = ctsTellerVO;
	}
	public String getIv_crud() {
		return iv_crud;
	}
	public void setIv_crud(String ivCrud) {
		iv_crud = ivCrud;
	}
	
	
	public CIF_FINANCE_ENGVO getCifFinancialVO()
	{
		return cifFinancialVO;
	}
	public void setCifFinancialVO(CIF_FINANCE_ENGVO cifFinancialVO)
	{
		this.cifFinancialVO = cifFinancialVO;
	}
	public String getCurrencyDesc()
	{
		return currencyDesc;
	}
	public void setCurrencyDesc(String currencyDesc)
	{
		this.currencyDesc = currencyDesc;
	}
	public BigDecimal getCurrencyDecimalPoints()
	{
		return currencyDecimalPoints;
	}
	public void setCurrencyDecimalPoints(BigDecimal currencyDecimalPoints)
	{
		this.currencyDecimalPoints = currencyDecimalPoints;
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
	public BigDecimal getAmtFormat()
	{
		return amtFormat;
	}
	public void setAmtFormat(BigDecimal amtFormat)
	{
		this.amtFormat = amtFormat;
	}
	public BigDecimal getBaseAmtFormat()
	{
		return baseAmtFormat;
	}
	public void setBaseAmtFormat(BigDecimal baseAmtFormat)
	{
		this.baseAmtFormat = baseAmtFormat;
	}
	public String getBlkListWarnMessage()
	{
	    return blkListWarnMessage;
	}
	public void setBlkListWarnMessage(String blkListWarnMessage)
	{
	    this.blkListWarnMessage = blkListWarnMessage;
	}
 }