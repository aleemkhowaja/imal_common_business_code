package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.facilitytype.FacilityTypeBO;
import com.path.dbmaps.vo.FMSFACILITYTYPEVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.facilitytype.FacilityTypeSC;

public class FacilityTypeDependencyAction extends RetailBaseAction
{
    private FacilityTypeBO facilityTypeBO;
    private FacilityTypeSC facilityTypeSC = new FacilityTypeSC();
    private FMSFACILITYTYPEVO facilityTypeVO;
    private BigDecimal CODE;
    private BigDecimal FACILITY_CATEG;

    public String dependencyByFacilityTypeCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
	    facilityTypeSC.setBranchCode(sessionCO.getBranchCode());
	    facilityTypeSC.setCode(CODE);
	    facilityTypeSC.setAllTypes(getText("All_types_key"));
	    facilityTypeSC.setFACILITY_CATEG(BigDecimal.ONE);
	    facilityTypeVO = facilityTypeBO.returnFacilityTypeById(facilityTypeSC);

	}
	catch(Exception e)
	{
	    facilityTypeVO = new FMSFACILITYTYPEVO();
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String returnFacilityTypeByCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    facilityTypeSC.setCompCode(sessionCO.getCompanyCode());
	    facilityTypeSC.setBranchCode(sessionCO.getBranchCode());
	    facilityTypeSC.setCode(CODE);
	    facilityTypeSC.setFACILITY_CATEG(FACILITY_CATEG);

	    if(NumberUtil.isEmptyDecimal(CODE))
	    {
		facilityTypeVO = new FMSFACILITYTYPEVO();
	    }
	    else
	    {
		facilityTypeVO = facilityTypeBO.returnFacilityTypeByCode(facilityTypeSC);
	    }

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public void setFacilityTypeBO(FacilityTypeBO facilityTypeBO)
    {
	this.facilityTypeBO = facilityTypeBO;
    }

    public FacilityTypeSC getFacilityTypeSC()
    {
	return facilityTypeSC;
    }

    public void setFacilityTypeSC(FacilityTypeSC facilityTypeSC)
    {
	this.facilityTypeSC = facilityTypeSC;
    }

    public BigDecimal getCODE()
    {
	return CODE;
    }

    public void setCODE(BigDecimal cODE)
    {
	CODE = cODE;
    }

    public FMSFACILITYTYPEVO getFacilityTypeVO()
    {
	return facilityTypeVO;
    }

    public void setFacilityTypeVO(FMSFACILITYTYPEVO facilityTypeVO)
    {
	this.facilityTypeVO = facilityTypeVO;
    }

    /**
     * @return the fACILITY_CATEG
     */
    public BigDecimal getFACILITY_CATEG()
    {
	return FACILITY_CATEG;
    }

    /**
     * @param fACILITYCATEG the fACILITY_CATEG to set
     */
    public void setFACILITY_CATEG(BigDecimal fACILITYCATEG)
    {
	FACILITY_CATEG = fACILITYCATEG;
    }
}
