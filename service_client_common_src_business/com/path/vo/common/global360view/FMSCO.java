/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.FMSAPPCOLLATERALSVO;
import com.path.dbmaps.vo.FMSAPPLVO;
import com.path.dbmaps.vo.FMSCATEGORYVO;
import com.path.dbmaps.vo.FMSCOLLATERALVO;
import com.path.dbmaps.vo.FMSDRWDWNVO;
import com.path.dbmaps.vo.FMSFACILITYDETVO;
import com.path.dbmaps.vo.FMSFACILITYTYPEVO;
import com.path.dbmaps.vo.FMSFACILITYVO;
import com.path.vo.core.common.RetailBaseVO;


public class FMSCO extends RetailBaseVO
{ 
    private FMSCOLLATERALVO fmsCollateralVO = new FMSCOLLATERALVO();
    private FMSAPPCOLLATERALSVO fmsAppCollateralVO = new FMSAPPCOLLATERALSVO();
    private FMSFACILITYVO fmsFacilityVO = new FMSFACILITYVO();
    private FMSFACILITYTYPEVO fmsFacilityTypeVO = new FMSFACILITYTYPEVO();
    private FMSAPPLVO fmsApplVO = new FMSAPPLVO();
    private FMSCATEGORYVO fmsCategoryVO = new FMSCATEGORYVO();
    private FMSFACILITYDETVO fmsFacilityDetVO = new FMSFACILITYDETVO();
    private FMSDRWDWNVO fmsDrwDwnVO = new FMSDRWDWNVO();
    private BigDecimal curDecimalPoints;
    private BigDecimal calcAmount;
    private BigDecimal cvAmount;
    private String currencyDesc;
    private Date newAppMaxDate;
    private String revolveOnOff;
    private String currencyHeader;
    private String className;
    private BigDecimal DEAL_AMOUNT;
    private BigDecimal BLOCKED_AMOUNT;
    private BigDecimal UTILIZED_AMOUNT;
    private BigDecimal UNUTILIZED_AMOUNT;
    private BigDecimal INDICATOR_AMOUNT;
    private String statusDesc;
    private String appForDesc;
	private BigDecimal EXCESS_OVER_LIMIT_UTILISED;	
    
    public FMSCOLLATERALVO getFmsCollateralVO()
	{
		return fmsCollateralVO;
	}
	public void setFmsCollateralVO(FMSCOLLATERALVO fmsCollateralVO)
	{
		this.fmsCollateralVO = fmsCollateralVO;
	}
	public String getCurrencyDesc()
	{
		return currencyDesc;
	}
	public void setCurrencyDesc(String currencyDesc)
	{
		this.currencyDesc = currencyDesc;
	}
	public FMSFACILITYVO getFmsFacilityVO()
	{
		return fmsFacilityVO;
	}
	public void setFmsFacilityVO(FMSFACILITYVO fmsFacilityVO)
	{
		this.fmsFacilityVO = fmsFacilityVO;
	}
	public BigDecimal getCurDecimalPoints()
	{
		return curDecimalPoints;
	}
	public void setCurDecimalPoints(BigDecimal curDecimalPoints)
	{
		this.curDecimalPoints = curDecimalPoints;
	}
	public FMSAPPCOLLATERALSVO getFmsAppCollateralVO()
	{
		return fmsAppCollateralVO;
	}
	public void setFmsAppCollateralVO(FMSAPPCOLLATERALSVO fmsAppCollateralVO)
	{
		this.fmsAppCollateralVO = fmsAppCollateralVO;
	}
	public BigDecimal getCalcAmount()
	{
		return calcAmount;
	}
	public void setCalcAmount(BigDecimal calcAmount)
	{
		this.calcAmount = calcAmount;
	}
	public FMSAPPLVO getFmsApplVO()
	{
		return fmsApplVO;
	}
	public void setFmsApplVO(FMSAPPLVO fmsApplVO)
	{
		this.fmsApplVO = fmsApplVO;
	}
	public Date getNewAppMaxDate()
	{
		return newAppMaxDate;
	}
	public void setNewAppMaxDate(Date newAppMaxDate)
	{
		this.newAppMaxDate = newAppMaxDate;
	}
	public FMSFACILITYTYPEVO getFmsFacilityTypeVO()
	{
		return fmsFacilityTypeVO;
	}
	public void setFmsFacilityTypeVO(FMSFACILITYTYPEVO fmsFacilityTypeVO)
	{
		this.fmsFacilityTypeVO = fmsFacilityTypeVO;
	}
	public BigDecimal getCvAmount()
	{
		return cvAmount;
	}
	public void setCvAmount(BigDecimal cvAmount)
	{
		this.cvAmount = cvAmount;
	}
	public FMSCATEGORYVO getFmsCategoryVO()
	{
		return fmsCategoryVO;
	}
	public void setFmsCategoryVO(FMSCATEGORYVO fmsCategoryVO)
	{
		this.fmsCategoryVO = fmsCategoryVO;
	}
	public String getCurrencyHeader()
	{
		return currencyHeader;
	}
	public void setCurrencyHeader(String currencyHeader)
	{
		this.currencyHeader = currencyHeader;
	}
	public String getRevolveOnOff()
	{
		return revolveOnOff;
	}
	public void setRevolveOnOff(String revolveOnOff)
	{
		this.revolveOnOff = revolveOnOff;
	}
	public FMSFACILITYDETVO getFmsFacilityDetVO()
	{
		return fmsFacilityDetVO;
	}
	public void setFmsFacilityDetVO(FMSFACILITYDETVO fmsFacilityDetVO)
	{
		this.fmsFacilityDetVO = fmsFacilityDetVO;
	}
	public String getClassName()
	{
		return className;
	}
	public void setClassName(String className)
	{
		this.className = className;
	}
	public BigDecimal getUTILIZED_AMOUNT()
	{
		return UTILIZED_AMOUNT;
	}
	public void setUTILIZED_AMOUNT(BigDecimal uTILIZEDAMOUNT)
	{
		UTILIZED_AMOUNT = uTILIZEDAMOUNT;
	}
	public BigDecimal getUNUTILIZED_AMOUNT()
	{
		return UNUTILIZED_AMOUNT;
	}
	public void setUNUTILIZED_AMOUNT(BigDecimal uNUTILIZEDAMOUNT)
	{
		UNUTILIZED_AMOUNT = uNUTILIZEDAMOUNT;
	}
	public BigDecimal getBLOCKED_AMOUNT()
	{
		return BLOCKED_AMOUNT;
	}
	public void setBLOCKED_AMOUNT(BigDecimal bLOCKEDAMOUNT)
	{
		BLOCKED_AMOUNT = bLOCKEDAMOUNT;
	}
	public BigDecimal getDEAL_AMOUNT()
	{
		return DEAL_AMOUNT;
	}
	public void setDEAL_AMOUNT(BigDecimal dEALAMOUNT)
	{
		DEAL_AMOUNT = dEALAMOUNT;
	}
	public String getStatusDesc()
	{
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}
	public String getAppForDesc()
	{
		return appForDesc;
	}
	public void setAppForDesc(String appForDesc)
	{
		this.appForDesc = appForDesc;
	}
	public BigDecimal getINDICATOR_AMOUNT()
	{
		return INDICATOR_AMOUNT;
	}
	public void setINDICATOR_AMOUNT(BigDecimal iNDICATORAMOUNT)
	{
		INDICATOR_AMOUNT = iNDICATORAMOUNT;
	}
	public FMSDRWDWNVO getFmsDrwDwnVO()
	{
	    return fmsDrwDwnVO;
	}
	public void setFmsDrwDwnVO(FMSDRWDWNVO fmsDrwDwnVO)
	{
	    this.fmsDrwDwnVO = fmsDrwDwnVO;
	}
	public BigDecimal getEXCESS_OVER_LIMIT_UTILISED()
	{
	    return EXCESS_OVER_LIMIT_UTILISED;
	}
	public void setEXCESS_OVER_LIMIT_UTILISED(BigDecimal eXCESS_OVER_LIMIT_UTILISED)
	{
	    EXCESS_OVER_LIMIT_UTILISED = eXCESS_OVER_LIMIT_UTILISED;
	}
    
}
