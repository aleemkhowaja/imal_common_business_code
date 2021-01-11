package com.path.actions.dependencies.core;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.cities.CitiesBO;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.FomElementsConstant;
import com.path.dbmaps.vo.CITIESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.core.cities.CitiesSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * CitiesDependencyAction.java used to
 */
public class CitiesDependencyAction extends RetailBaseAction
{
    private CitiesBO citiesBO;
    private CoreCommonServiceBO coreCommonServiceBO;
    private CITIESVO citiesVO;
    private AddressCommonCO addressCO = new AddressCommonCO();
    private BigDecimal COUNTRY_CODE;
    private BigDecimal REGION_CODE;
    private BigDecimal CITY_CODE;
    private String callingScreen;
    private String screenReference;
    private String cifLanguage;
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	
    public String dependencyByCityCode()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();

	    if(callingScreen != null && FomConstant.FOM_SCREEN_NAME.equalsIgnoreCase(callingScreen))
	    {
		set_forceAfterDepEvent("true");
		if(NumberUtil.emptyDecimalToNull(COUNTRY_CODE) != null
			&& NumberUtil.emptyDecimalToNull(REGION_CODE) != null)
		{
		    addressCO.setCOMP_CODE(sessionCO.getCompanyCode());
		    addressCO.setCITY_CODE(CITY_CODE);
		    addressCO.setREGION(REGION_CODE);
		    addressCO.setCOUNTRY(COUNTRY_CODE);
		    addressCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
		    /*In FOM the arabic description must be according to the cif language instead of prefferred language BMOUPI170114 - TP:532453*/
			if (FomConstant.FOM_SCREEN_NAME.equalsIgnoreCase(callingScreen) && !("").equals(StringUtil.nullToEmpty(getCifLanguage())) )
			{
			    addressCO.setPreferredLanguage (getCifLanguage());
			}
			else
			{
			    addressCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
			}
		    elementHashmap = coreCommonServiceBO.checkAddressCityCode(addressCO);

		    setAdditionalScreenParams(elementHashmap);

		    citiesVO = new CITIESVO();
		    if(NumberUtil.emptyDecimalToNull(CITY_CODE) == null)
		    {
			citiesVO.setCITY_CODE(null);
		    }
		    else
		    {
			citiesVO.setCITY_CODE(CITY_CODE);
		    }

		    if(elementHashmap.containsKey(FomElementsConstant.CITY_DESC_ID))
		    {
			citiesVO.setBRIEF_DESC_ENG(elementHashmap.get(FomElementsConstant.CITY_DESC_ID).getValue()
				.toString());
		    }
		    else
		    {
			citiesVO.setBRIEF_DESC_ENG(null);
		    }
		}
	    }
	    else
	    {
		if(NumberUtil.emptyDecimalToNull(COUNTRY_CODE) != null
			&& NumberUtil.emptyDecimalToNull(REGION_CODE) != null
			&& NumberUtil.emptyDecimalToNull(CITY_CODE) != null)
		{
		    CitiesSC criteria = new CitiesSC();
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    criteria.setCountry_code(COUNTRY_CODE);
		    criteria.setRegion_code(REGION_CODE);
		    criteria.setCity_code(CITY_CODE);
		    citiesVO = citiesBO.returnCityById(criteria);
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCityCode method of CitiesDependencyAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    // TP#269793; Saheer.Naduthodi; 09/02/2015
    // to show the stopping message for invalid city code
    public String onChangeCityCode()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();

	    CitiesSC criteria = new CitiesSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCountry_code(NumberUtil.emptyDecimalToZero(COUNTRY_CODE));
	    criteria.setRegion_code(NumberUtil.emptyDecimalToZero(REGION_CODE));
	    criteria.setCity_code(NumberUtil.emptyDecimalToZero(CITY_CODE));
	    citiesVO = citiesBO.returnCityById(criteria);
	    if(citiesVO == null)
	    {
		citiesVO = new CITIESVO();
		throw new BOException(MessageCodes.INVALID_MISSING_CODE);
	    }

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public CITIESVO getCitiesVO()
    {
	return citiesVO;
    }

    public void setCitiesVO(CITIESVO citiesVO)
    {
	this.citiesVO = citiesVO;
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

    public void setCitiesBO(CitiesBO citiesBO)
    {
	this.citiesBO = citiesBO;
    }

    public BigDecimal getCITY_CODE()
    {
	return CITY_CODE;
    }

    public void setCITY_CODE(BigDecimal cITYCODE)
    {
	CITY_CODE = cITYCODE;
    }

    public AddressCommonCO getAddressCO()
    {
	return addressCO;
    }

    public void setAddressCO(AddressCommonCO addressCO)
    {
	this.addressCO = addressCO;
    }

    public String getCallingScreen()
    {
	return callingScreen;
    }

    public void setCallingScreen(String callingScreen)
    {
	this.callingScreen = callingScreen;
    }

    public String getScreenReference()
    {
	return screenReference;
    }

    public void setScreenReference(String screenReference)
    {
	this.screenReference = screenReference;
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
