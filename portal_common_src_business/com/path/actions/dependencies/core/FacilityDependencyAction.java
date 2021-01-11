/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.facilitytype.FacilityTypeBO;
import com.path.dbmaps.vo.FMSFACILITYDETVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.facilitytype.FacilityCO;
import com.path.vo.core.facilitytype.FacilityTypeSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * FacilityNumberDependencyAction.java used to
 */
public class FacilityDependencyAction extends RetailBaseAction
{
    private FacilityTypeBO facilityTypeBO;
    private final FacilityTypeSC criteria = new FacilityTypeSC();
    private FacilityCO facilityCO;
    private FMSFACILITYDETVO facilityDetVO;
    
    public String dependencyByFacilityNumber() {

	try 
	{
	    if(criteria.getCode() != null){
		SessionCO sessionCO = returnSessionObject();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setBranchCode(sessionCO.getBranchCode());

		facilityCO = facilityTypeBO.returnFacilityCOByCode(criteria);
	    }
	    if(facilityCO==null)
	    {
		facilityCO = new FacilityCO();
	    }
	} 
	catch (Exception e) 
	{
		log.error(e,"Error in dependencyByFacilityNumber method of FacilityDependencyAction");
		handleException(e, "ERROR in FacilityNumber Dependency", null);
	}

	return SUCCESS;
    }
    
    public String dependencyByFacilitySubLimit() {

	try 
	{
	    if(criteria.getCode() != null){
		SessionCO sessionCO = returnSessionObject();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setBranchCode(sessionCO.getBranchCode());

		facilityDetVO = facilityTypeBO.returnFacilityDetVOByCode(criteria);
	    }
	    if(facilityDetVO==null)
	    {
		facilityDetVO = new FMSFACILITYDETVO();
	    }
	} 
	catch (Exception e) 
	{
		log.error(e,"Error in dependencyByFacilitySubLimit method of FacilityDependencyAction");
		handleException(e, "ERROR in FacilitySubLimit Dependency", null);
	}

	return SUCCESS;
    }
    
    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * @return the facilityCO
     */
    public FacilityCO getFacilityCO()
    {
        return facilityCO;
    }

    /**
     * @param facilityTypeBO the facilityTypeBO to set
     */
    public void setFacilityTypeBO(FacilityTypeBO facilityTypeBO)
    {
        this.facilityTypeBO = facilityTypeBO;
    }

    /**
     * @return the facilityDetVO
     */
    public FMSFACILITYDETVO getFacilityDetVO()
    {
        return facilityDetVO;
    }
}
