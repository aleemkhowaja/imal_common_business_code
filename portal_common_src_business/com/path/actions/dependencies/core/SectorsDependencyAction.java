package com.path.actions.dependencies.core;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.FomElementsConstant;
import com.path.bo.core.sectors.SectorsBO;
import com.path.dbmaps.vo.SECTORSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.core.sectors.SectorsSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: lvalappil
 *
 * SectorsDependencyAction.java used to
 */
public class SectorsDependencyAction extends RetailBaseAction
{
    private SectorsBO sectorsBO;
    private CoreCommonServiceBO coreCommonServiceBO;
    private SECTORSVO sectorsVO;
    private BigDecimal COUNTRY_CODE;
    private BigDecimal REGION_CODE;
    private BigDecimal CITY_CODE;
    private BigDecimal SECTOR_CODE;
    private String callingScreen;
    private String cifLanguage;
    //private String screenReference;
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    public String dependencyBySectorCode() {

	try
	{
	    SessionCO sessionCO = returnSessionObject();

	    if(callingScreen !=null && FomConstant.FOM_SCREEN_NAME.equalsIgnoreCase(callingScreen))
	    {
		set_forceAfterDepEvent("true");
		if (NumberUtil.emptyDecimalToNull(COUNTRY_CODE) != null && NumberUtil.emptyDecimalToNull(REGION_CODE) != null && NumberUtil.emptyDecimalToNull(CITY_CODE) != null)
		{
		    AddressCommonCO addressCO = new AddressCommonCO();
		    addressCO.setCOMP_CODE(sessionCO.getCompanyCode());
		    addressCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
		    addressCO.setREGION(REGION_CODE);
		    addressCO.setCOUNTRY(COUNTRY_CODE);
		    addressCO.setCITY_CODE(CITY_CODE);
		    addressCO.setSECTOR_CODE(SECTOR_CODE);
		    /*In FOM the arabic description must be according to the cif language instead of prefferred language BMOUPI170114 - TP:532453*/
			if (FomConstant.FOM_SCREEN_NAME.equalsIgnoreCase(callingScreen) && !("").equals(StringUtil.nullToEmpty(getCifLanguage())) )
			{
			    addressCO.setPreferredLanguage (getCifLanguage());
			}
			else
			{
			    addressCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
			}
		    addressCO.setREGION(REGION_CODE);
		    addressCO.setCOUNTRY(COUNTRY_CODE);
		    addressCO.setCITY_CODE(CITY_CODE);
		    addressCO.setSECTOR_CODE(SECTOR_CODE);

		    elementHashmap = coreCommonServiceBO.checkAddressSectorCode(addressCO);
		    setAdditionalScreenParams(elementHashmap);

		    sectorsVO = new SECTORSVO();
		    if (NumberUtil.emptyDecimalToNull(SECTOR_CODE) == null)
		    {
			sectorsVO.setSECTOR_CODE(null);
		    }
		    else
		    {
			sectorsVO.setSECTOR_CODE(SECTOR_CODE);
		    }

		    if(elementHashmap.containsKey(FomElementsConstant.SECTOR_DESC_ID))
		    {
			sectorsVO.setLONG_DESC_ENG(elementHashmap.get(FomElementsConstant.SECTOR_DESC_ID).getValue().toString());
		    }
		    else
		    {
			sectorsVO.setLONG_DESC_ENG(null);
		    }

		}
	    }
	    else
	    {
		if (NumberUtil.emptyDecimalToNull(COUNTRY_CODE) != null && NumberUtil.emptyDecimalToNull(REGION_CODE) != null && NumberUtil.emptyDecimalToNull(CITY_CODE) != null && NumberUtil.emptyDecimalToNull(SECTOR_CODE) != null)
		{
		    SectorsSC criteria = new SectorsSC();
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		    criteria.setCountry_code(COUNTRY_CODE);
		    criteria.setRegion_code(REGION_CODE);
		    criteria.setCity_code(CITY_CODE);
		    criteria.setSector_code(SECTOR_CODE);
		    sectorsVO = sectorsBO.returnSectorById(criteria);
		}
	    }
	}
	catch (Exception e)
	{
	    log.error(e,"Error in dependencyBySectorCode method of SectorsDependencyAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    // TP#269793; Saheer.Naduthodi; 09/02/2015
    // With Warning message for invalid code
    public String onChangeSectorCode()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();

	    SectorsSC criteria = new SectorsSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setCountry_code(NumberUtil.emptyDecimalToZero(COUNTRY_CODE));
	    criteria.setRegion_code(NumberUtil.emptyDecimalToZero(REGION_CODE));
	    criteria.setCity_code(NumberUtil.emptyDecimalToZero(CITY_CODE));
	    criteria.setSector_code(NumberUtil.emptyDecimalToZero(SECTOR_CODE));
	    sectorsVO = sectorsBO.returnSectorById(criteria);
	    if(sectorsVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CODE);
	    }
	}
	catch(Exception e)
	{
	    sectorsVO = new SECTORSVO();
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public SECTORSVO getSectorsVO()
    {
	return sectorsVO;
    }

    public void setSectorsVO(SECTORSVO sectorsVO)
    {
	this.sectorsVO = sectorsVO;
    }

    public BigDecimal getCOUNTRY_CODE()
    {
	return COUNTRY_CODE;
    }

    public void setCOUNTRY_CODE(BigDecimal cOUNTRYCODE)
    {
	COUNTRY_CODE = cOUNTRYCODE;
    }

    public BigDecimal getREGION_CODE()
    {
	return REGION_CODE;
    }

    public void setREGION_CODE(BigDecimal rEGIONCODE)
    {
	REGION_CODE = rEGIONCODE;
    }

    public BigDecimal getCITY_CODE()
    {
	return CITY_CODE;
    }

    public void setCITY_CODE(BigDecimal cITYCODE)
    {
	CITY_CODE = cITYCODE;
    }

    public void setSectorsBO(SectorsBO sectorsBO)
    {
	this.sectorsBO = sectorsBO;
    }

    public BigDecimal getSECTOR_CODE()
    {
	return SECTOR_CODE;
    }

    public void setSECTOR_CODE(BigDecimal sECTORCODE)
    {
	SECTOR_CODE = sECTORCODE;
    }

    public String getCallingScreen()
    {
	return callingScreen;
    }

    public void setCallingScreen(String callingScreen)
    {
	this.callingScreen = callingScreen;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getElementHashmap()
    {
	return elementHashmap;
    }

    public void setElementHashmap(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap)
    {
	this.elementHashmap = elementHashmap;
    }

    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
        this.coreCommonServiceBO = coreCommonServiceBO;
    }
    
    public String getCifLanguage()
    {
        return cifLanguage;
    }

    public void setCifLanguage(String cifLanguage)
    {
        this.cifLanguage = cifLanguage;
    }

}
