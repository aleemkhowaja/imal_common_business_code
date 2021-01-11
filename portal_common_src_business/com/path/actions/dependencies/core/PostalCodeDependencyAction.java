package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.postalcode.PostalCodeBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.POSTAL_CODEVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.postalcode.PostalCodeSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: lvalappil
 * 
 *          PostalCodeDependencyAction.java used to
 */
public class PostalCodeDependencyAction extends RetailBaseAction
{
    private PostalCodeBO postalCodeBO;
    private POSTAL_CODEVO postalCodeVO = new POSTAL_CODEVO();
    private BigDecimal COUNTRY_CODE;
    private BigDecimal REGION_CODE;
    private String POSTAL_CODE;
    private BigDecimal displayMsg;
    private String cifLanguage;

    public String dependencyByPostalCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    PostalCodeSC criteria = new PostalCodeSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    if(!NumberUtil.isEmptyDecimal(COUNTRY_CODE))
	    {
		criteria.setCountry_code(COUNTRY_CODE);
	    }
	    if(!NumberUtil.isEmptyDecimal(REGION_CODE))
	    {
		criteria.setRegion_code(REGION_CODE);
	    }
	    /*In FOM the arabic description must be according to the cif language instead of prefferred language BMOUPI170114 - TP:532453*/
		if (!("").equals(StringUtil.nullToEmpty(getCifLanguage())) )
		{
		    criteria.setPreferredLanguage (getCifLanguage());
		}
		else
		{
		    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		}
		    
		CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
		cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
		cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
		BigDecimal postalCode = null;
		if(cifControlVO != null && "N".equals(cifControlVO.getPOSTAL_CODE_TYPE()) && POSTAL_CODE != null && !"".equals(POSTAL_CODE.trim()))
		{
		    postalCode = new BigDecimal(POSTAL_CODE);
		    POSTAL_CODE = postalCode.toString();
		 }


	    criteria.setPostal_code(POSTAL_CODE);

	    if(BigDecimal.ONE.compareTo(NumberUtil.nullToZero(getDisplayMsg())) == 0)
	    {
		if(NumberUtil.isEmptyDecimal(COUNTRY_CODE))
		{
		    String errMsg = returnCommonLibBO().returnTranslErrorMessage(MessageCodes.Invalid_Missing_country_code, sessionCO.getLanguage());
		    addDependencyMsg(errMsg, null);
		}
		if(NumberUtil.isEmptyDecimal(REGION_CODE))
		{
		    String errMsg = returnCommonLibBO().returnTranslErrorMessage(MessageCodes.INVALID_REGION_CODE, sessionCO.getLanguage());
		    addDependencyMsg(errMsg, null);
		}
	    }

	    if(!NumberUtil.isEmptyDecimal(COUNTRY_CODE) && !NumberUtil.isEmptyDecimal(REGION_CODE))
	    {
		postalCodeVO = postalCodeBO.returnPostalCodeById(criteria);
	    }

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByPostalCode method of PostalCodeDependencyAction");
	    handleException(e, "ERROR in Postal Code  Dependency", null);
	}

	return SUCCESS;

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

    public POSTAL_CODEVO getPostalCodeVO()
    {
	return postalCodeVO;
    }

    public void setPostalCodeVO(POSTAL_CODEVO postalCodeVO)
    {
	this.postalCodeVO = postalCodeVO;
    }

    public void setPostalCodeBO(PostalCodeBO postalCodeBO)
    {
	this.postalCodeBO = postalCodeBO;
    }

    public String getPOSTAL_CODE()
    {
	return POSTAL_CODE;
    }

    public void setPOSTAL_CODE(String pOSTALCODE)
    {
	POSTAL_CODE = pOSTALCODE;
    }

    public BigDecimal getDisplayMsg()
    {
	return displayMsg;
    }

    public void setDisplayMsg(BigDecimal displayMsg)
    {
	this.displayMsg = displayMsg;
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
