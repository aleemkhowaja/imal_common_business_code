package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.occupation.OccupationBO;
import com.path.dbmaps.vo.CIF_OCCUPATIONVO;
import com.path.dbmaps.vo.OCCUPATIONSVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.occupation.OccupationSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * OccupationDependencyAction.java used to
 */
public class OccupationDependencyAction extends RetailBaseAction
{
	private OccupationBO occupationBO;
	private OCCUPATIONSVO occupationVO;
	private CIF_OCCUPATIONVO cifOccupationStatusVO;
    private BigDecimal OCCUPATION_CODE;
    private String OCCUPATION_STATUS;
    private BigDecimal sectorCode;
    private BigDecimal subSectorCode;
	
	public String dependencyByOccupationCode() {

		try 
		{
			SessionCO sessionCO = returnSessionObject();
			OccupationSC criteria = new OccupationSC();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
			criteria.setOccupationCode(OCCUPATION_CODE);
			criteria.setSectorCode(sectorCode);
			criteria.setSubSectorCode(subSectorCode);
			occupationVO = occupationBO.returnOccupationById(criteria);
			
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByOccupationCode method of OccupationDependencyAction");
			handleException(e, "ERROR in Occupation Dependency", null);
		}

		return SUCCESS;

	}
	
	public String cifOccupationStatusDependency() {

		try 
		{
			SessionCO sessionCO = returnSessionObject();
			OccupationSC criteria = new OccupationSC();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setOccupStatus(OCCUPATION_STATUS);
			cifOccupationStatusVO = occupationBO.returnCifOccupationStatus(criteria);
			
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in cifOccupationStatusDependency method of OccupationDependencyAction");
			handleException(e, "ERROR in CIF Occupation Status Dependency", null);
		}

		return SUCCESS;

	}

	public OCCUPATIONSVO getOccupationVO()
	{
		return occupationVO;
	}

	public void setOccupationVO(OCCUPATIONSVO occupationVO)
	{
		this.occupationVO = occupationVO;
	}

	public BigDecimal getOCCUPATION_CODE()
	{
		return OCCUPATION_CODE;
	}

	public void setOCCUPATION_CODE(BigDecimal oCCUPATIONCODE)
	{
		OCCUPATION_CODE = oCCUPATIONCODE;
	}

	public void setOccupationBO(OccupationBO occupationBO)
	{
		this.occupationBO = occupationBO;
	}

	public String getOCCUPATION_STATUS()
	{
		return OCCUPATION_STATUS;
	}

	public void setOCCUPATION_STATUS(String oCCUPATIONSTATUS)
	{
		OCCUPATION_STATUS = oCCUPATIONSTATUS;
	}

	public CIF_OCCUPATIONVO getCifOccupationStatusVO()
	{
		return cifOccupationStatusVO;
	}

	public void setCifOccupationStatusVO(CIF_OCCUPATIONVO cifOccupationStatusVO)
	{
		this.cifOccupationStatusVO = cifOccupationStatusVO;
	}

	public BigDecimal getSectorCode()
	{
	    return sectorCode;
	}

	public void setSectorCode(BigDecimal sectorCode)
	{
	    this.sectorCode = sectorCode;
	}

	public BigDecimal getSubSectorCode()
	{
	    return subSectorCode;
	}

	public void setSubSectorCode(BigDecimal subSectorCode)
	{
	    this.subSectorCode = subSectorCode;
	}


    

	
	
}
