package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTSCHARGES_CURRENCYVO;
import com.path.dbmaps.vo.CTSCHARGES_CURRENCY_TEMPVO;
import com.path.dbmaps.vo.CTSCHARGES_ROSTER_TEMPVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.lib.vo.BaseVO;

public class CTSChargesCurrencyCO extends BaseVO
{
    private CTSCHARGES_CURRENCYVO ctsChargesCurrencyVO = new CTSCHARGES_CURRENCYVO();    
    
    private CTSCHARGES_CURRENCY_TEMPVO ctsChargesCurrencyTempVO = new CTSCHARGES_CURRENCY_TEMPVO();   
    private CURRENCIESVO currencyVO = new CURRENCIESVO();
    private BigDecimal amtFormat ;
    private String ctsForeignChargesTierGridJson;
    private List<CTSCHARGES_ROSTER_TEMPVO> ctscharges_ROSTER_TEMPVOs=new ArrayList<CTSCHARGES_ROSTER_TEMPVO>();
	public CTSCHARGES_CURRENCYVO getCtsChargesCurrencyVO()
	{
		return ctsChargesCurrencyVO;
	}
	public void setCtsChargesCurrencyVO(CTSCHARGES_CURRENCYVO ctsChargesCurrencyVO)
	{   
		this.ctsChargesCurrencyVO = ctsChargesCurrencyVO;
	}
	public CURRENCIESVO getCurrencyVO()
	{ 
		return currencyVO;
	}  
	public void setCurrencyVO(CURRENCIESVO currencyVO)
	{
		this.currencyVO = currencyVO;
	}
	public BigDecimal getAmtFormat()
	{
		return amtFormat;
	}
	public void setAmtFormat(BigDecimal amtFormat)
	{
		this.amtFormat = amtFormat;
	}
	public String getCtsForeignChargesTierGridJson()
	{
	    return ctsForeignChargesTierGridJson;
	}
	public void setCtsForeignChargesTierGridJson(String ctsForeignChargesTierGridJson)
	{
	    this.ctsForeignChargesTierGridJson = ctsForeignChargesTierGridJson;
	}
	public CTSCHARGES_CURRENCY_TEMPVO getCtsChargesCurrencyTempVO()
	{
	    return ctsChargesCurrencyTempVO;
	}
	public void setCtsChargesCurrencyTempVO(CTSCHARGES_CURRENCY_TEMPVO ctsChargesCurrencyTempVO)
	{
	    this.ctsChargesCurrencyTempVO = ctsChargesCurrencyTempVO;
	}
	public List<CTSCHARGES_ROSTER_TEMPVO> getCtscharges_ROSTER_TEMPVOs()
	{
	    return ctscharges_ROSTER_TEMPVOs;
	}
	public void setCtscharges_ROSTER_TEMPVOs(List<CTSCHARGES_ROSTER_TEMPVO> ctscharges_ROSTER_TEMPVOs)
	{
	    this.ctscharges_ROSTER_TEMPVOs = ctscharges_ROSTER_TEMPVOs;
	}    
	
    
}																							
