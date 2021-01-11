package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.CIF_TRX_LIMITVO;
import com.path.dbmaps.vo.CTSTELLERVO;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * FOMBalanceLimitCO.java used to
 */
public class FOMBalanceLimitCO extends CIF_TRX_LIMITVO
{
	private List<FOMBalanceLimitDetCO> balanceLimitDetList = new ArrayList<FOMBalanceLimitDetCO>();
	private CTSTELLERVO ctsTellerVO = new CTSTELLERVO() ;
	private String balanceLimitDetListStr;// string added to hold the list
    private String CY_DESC;
    private String cifStatus;
	private String iv_crud;
	private Date cif_UpdateDate ;
	private Boolean accesByTeller=true;
	private BigDecimal amtFormat ;
	private Date runningDate;
	// added by nancy -- 16/07/2018-- 382769-- account limits
	private BigDecimal accLimitCode;
	// end nancy 
	
	public String getCY_DESC()
    {
        return CY_DESC;
    }

    public void setCY_DESC(String cYDESC)
    {
        CY_DESC = cYDESC;
    }

    public List<FOMBalanceLimitDetCO> getBalanceLimitDetList()
	{
		return balanceLimitDetList;
	}

	public void setBalanceLimitDetList(List<FOMBalanceLimitDetCO> balanceLimitDetList)
	{
		this.balanceLimitDetList = balanceLimitDetList;
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

	public CTSTELLERVO getCtsTellerVO() {
		return ctsTellerVO;
	}

	public void setCtsTellerVO(CTSTELLERVO ctsTellerVO) {
		this.ctsTellerVO = ctsTellerVO;
	}

	public String getBalanceLimitDetListStr()
	{
		return balanceLimitDetListStr;
	}

	public void setBalanceLimitDetListStr(String balanceLimitDetListStr)
	{
		this.balanceLimitDetListStr = balanceLimitDetListStr;
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

	public Date getRunningDate()
	{
	    return runningDate;
	}

	public void setRunningDate(Date runningDate)
	{
	    this.runningDate = runningDate;
	}

	public BigDecimal getAccLimitCode()
	{
	    return accLimitCode;
	}

	public void setAccLimitCode(BigDecimal accLimitCode)
	{
	    this.accLimitCode = accLimitCode;
	}
	
}
