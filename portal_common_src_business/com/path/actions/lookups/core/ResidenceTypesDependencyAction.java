/**
 * 
 */
package com.path.actions.lookups.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.residencetypes.ResidenceTypesBO;
import com.path.dbmaps.vo.RESIDENCE_TYPESVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.residencetypes.ResidenceTypesSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * ResidenceTypesDependencyAction.java used to
 */
public class ResidenceTypesDependencyAction extends RetailBaseAction
{
    private RESIDENCE_TYPESVO residenceTypesVO;
    private ResidenceTypesSC residenceTypesSC = new ResidenceTypesSC();
    private ResidenceTypesBO residenceTypesBO;
    private String cifLanguage;
    
    public String dependencyByCode() 
    {
	try 
	{
	    if(residenceTypesSC.getCode() == null)
	    {
			residenceTypesVO = new RESIDENCE_TYPESVO();
	    }
	    else
	    {
			SessionCO sessionCO = returnSessionObject();
			residenceTypesSC.setCompCode(sessionCO.getCompanyCode());
			residenceTypesSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
			if (!("").equals(StringUtil.nullToEmpty(getCifLanguage())) )
			{
			    residenceTypesSC.setPreferredLanguage (getCifLanguage());
			}
			else
			{
			    residenceTypesSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
			}
			residenceTypesVO = residenceTypesBO.returnDependencyByCode(residenceTypesSC);
			residenceTypesVO=(residenceTypesVO==null?new RESIDENCE_TYPESVO():residenceTypesVO);
	    }
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // TP#269793; Saheer.Naduthodi; 09/02/2015
    // With Stopping message for invalid code
    public String onChangeResidenceCode()
    {
	try
	{

	    SessionCO sessionCO = returnSessionObject();
	    residenceTypesSC.setCompCode(sessionCO.getCompanyCode());
	    residenceTypesSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    residenceTypesVO = residenceTypesBO.returnDependencyByCode(residenceTypesSC);
	    if(residenceTypesVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CODE);
	    }

	}
	catch(Exception e)
	{
	    residenceTypesVO = new RESIDENCE_TYPESVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    /**
     * @return the residenceTypesSC
     */
    public ResidenceTypesSC getModel()
    {
        return residenceTypesSC;
    }
    /**
     * @return the residenceTypesVO
     */
    public RESIDENCE_TYPESVO getResidenceTypesVO()
    {
        return residenceTypesVO;
    }
    /**
     * @param residenceTypesVO the residenceTypesVO to set
     */
    public void setResidenceTypesVO(RESIDENCE_TYPESVO residenceTypesVO)
    {
        this.residenceTypesVO = residenceTypesVO;
    }
    /**
     * @return the residenceTypesSC
     */
    public ResidenceTypesSC getResidenceTypesSC()
    {
        return residenceTypesSC;
    }
    /**
     * @param residenceTypesSC the residenceTypesSC to set
     */
    public void setResidenceTypesSC(ResidenceTypesSC residenceTypesSC)
    {
        this.residenceTypesSC = residenceTypesSC;
    }
    /**
     * @param residenceTypesBO the residenceTypesBO to set
     */
    public void setResidenceTypesBO(ResidenceTypesBO residenceTypesBO)
    {
        this.residenceTypesBO = residenceTypesBO;
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
