/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.fmsdrawdowns.FmsDrawdownsBO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.facilitytype.FacilityTypeSC;
import com.path.vo.core.fmsdrowdowns.FMSDrawdownCO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * FmsDrawdownsDependencyAction.java used to
 */
public class FmsDrawdownsDependencyAction extends RetailBaseAction
{
    private FacilityTypeSC facilityTypeSC = new FacilityTypeSC();
    private FmsDrawdownsBO fmsDrawdownsBO;
    private FMSDrawdownCO fmsDrawdownCO;
    
    /**
     * get the selected amfSuspendReasonVO object by code on dependency action
     * @return the String
     */
    public String dependencyByCode()
    {
	try
	{
	    if(facilityTypeSC.getCode() != null ){
	    SessionCO sessionCO = returnSessionObject();
	    facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
	    facilityTypeSC.setCrud("V");
	    fmsDrawdownCO =  fmsDrawdownsBO.returnDependencyByCode(facilityTypeSC);
	    }
	    if(fmsDrawdownCO == null )
	    {
		fmsDrawdownCO = new FMSDrawdownCO();
	    }
	}catch (Exception e) 
	{
	    log.error(e, "Error in returnDependencyByCode method of FmsDrawdownsDependencyAction");
	    handleException(e, "ERROR IN FmsDrawdowns DEPENDENCY MANAGEMENT", null);
	}
        return SUCCESS;
    }
    
    /**
     * @return the amfStatusSC
     */
    @Override
    public Object getModel()
    {
        return facilityTypeSC;
    }

    /**
     * @return the fmsDrawdownCO
     */
    public FMSDrawdownCO getFmsDrawdownCO()
    {
        return fmsDrawdownCO;
    }

    /**
     * @param fmsDrawdownsBO the fmsDrawdownsBO to set
     */
    public void setFmsDrawdownsBO(FmsDrawdownsBO fmsDrawdownsBO)
    {
        this.fmsDrawdownsBO = fmsDrawdownsBO;
    }

    /**
     * @return the facilityTypeSC
     */
    public FacilityTypeSC getFacilityTypeSC()
    {
        return facilityTypeSC;
    }

    /**
     * @param facilityTypeSC the facilityTypeSC to set
     */
    public void setFacilityTypeSC(FacilityTypeSC facilityTypeSC)
    {
        this.facilityTypeSC = facilityTypeSC;
    }
}
