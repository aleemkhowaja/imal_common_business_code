package com.path.vo.core.authsignatories;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_AUTH_SIGNATORYVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * BillCollectionCO.java used to hold complex objects of Bill
 */
public class AuthSignatoriesCO extends RetailBaseVO
{    	private BigDecimal cifNo;
	private BigDecimal compCode;
	
        private String cifDesc;// cif name used upon choosing CIF from IRIS Scan/
        private CIF_AUTH_SIGNATORYVO cifAuthSignatoryVO = new CIF_AUTH_SIGNATORYVO();
        private CIFVO cifVO = new CIFVO();
        private String authSignCountryDesc;
	private String authSignCountryOfAddressDesc;
    
	private String authSignCountryOfIssDesc;
        
        
        public BigDecimal getCifNo()
        {
            return cifNo;
        }
        public void setCifNo(BigDecimal cifNo)
        {
            this.cifNo = cifNo;
        }
        public String getCifDesc()
        {
            return cifDesc;
        }
        public void setCifDesc(String cifDesc)
        {
            this.cifDesc = cifDesc;
        }
	public CIFVO getCifVO()
	{
	    return cifVO;
	}
	public void setCifVO(CIFVO cifVO)
	{
	    this.cifVO = cifVO;
	}
	public CIF_AUTH_SIGNATORYVO getCifAuthSignatoryVO()
	{
	    return cifAuthSignatoryVO;
	}
	public void setCifAuthSignatoryVO(CIF_AUTH_SIGNATORYVO cifAuthSignatoryVO)
	{
	    this.cifAuthSignatoryVO = cifAuthSignatoryVO;
	}
	public String getAuthSignCountryDesc()
	{
	    return authSignCountryDesc;
	}
	public void setAuthSignCountryDesc(String authSignCountryDesc)
	{
	    this.authSignCountryDesc = authSignCountryDesc;
	}
	public String getAuthSignCountryOfAddressDesc()
	{
	    return authSignCountryOfAddressDesc;
	}
	public void setAuthSignCountryOfAddressDesc(String authSignCountryOfAddressDesc)
	{
	    this.authSignCountryOfAddressDesc = authSignCountryOfAddressDesc;
	}
	public String getAuthSignCountryOfIssDesc()
	{
	    return authSignCountryOfIssDesc;
	}
	public void setAuthSignCountryOfIssDesc(String authSignCountryOfIssDesc)
	{
	    this.authSignCountryOfIssDesc = authSignCountryOfIssDesc;
	}
	public BigDecimal getCompCode()
	{
	    return compCode;
	}
	public void setCompCode(BigDecimal compCode)
	{
	    this.compCode = compCode;
	}


}
