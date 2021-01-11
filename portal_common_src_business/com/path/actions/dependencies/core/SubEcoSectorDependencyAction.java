/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.subecosector.SubEcoSectorBO;
import com.path.dbmaps.vo.RIFSECVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.subecosector.SubEcoSectorSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 *
 *          SubEcoSectorDependencyAction.java used to
 */
public class SubEcoSectorDependencyAction extends RetailBaseAction
{
    private SubEcoSectorSC subEcoSectorSC = new SubEcoSectorSC();
    private SubEcoSectorBO subEcoSectorBO;
    private RIFSECVO subEcoSectorVO;

    public String dependencyBySubSectorCode()
    {
	try
	{
	    NumberUtil.resetEmptyValues(subEcoSectorSC);
	    if(subEcoSectorSC.getSectorCode() == null || subEcoSectorSC.getSubSectorCode() == null)
	    {
		if(subEcoSectorSC.getSectorCode() == null && subEcoSectorSC.getSubSectorCode() != null)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_ECONOMIC_SECTOR_CODE);
		}
		else
		{
		    subEcoSectorSC = null;
		}
	    }
	    else
	    {
		SessionCO sessionCO = returnSessionObject();
		subEcoSectorSC.setCompCode(sessionCO.getCompanyCode());
		subEcoSectorSC.setAllTypes(getText("All_types_key"));
		subEcoSectorSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
		subEcoSectorVO = subEcoSectorBO.returnDependencyBySubSectorCode(subEcoSectorSC);
		if(subEcoSectorVO == null)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Sub_Economic_Sector_key" });
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyBySectorCode method of EconomicSectorDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String dependencyBySubSectorCodeforFOM()
    {
	try
	{
	    if(subEcoSectorSC.getSectorCode() == null || subEcoSectorSC.getSubSectorCode() == null
		    || subEcoSectorSC.getCifType() == null)
	    {
		subEcoSectorVO = new RIFSECVO();
	    }
	    else
	    {
		SessionCO sessionCO = returnSessionObject();
		subEcoSectorSC.setCompCode(sessionCO.getCompanyCode());
		subEcoSectorSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
		subEcoSectorVO = subEcoSectorBO.returnDependencyBySubSectorCodeforFOM(subEcoSectorSC);
		subEcoSectorVO = (subEcoSectorVO == null ? new RIFSECVO() : subEcoSectorVO);
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyBySectorCode method of EconomicSectorDependencyAction");
	    handleException(e, "ERROR in EconomicSector Dependency", null);
	}
	return SUCCESS;
    }

    @Override
    public SubEcoSectorSC getModel()
    {
	return subEcoSectorSC;
    }

    /**
     * @return the subEcoSectorSC
     */
    public SubEcoSectorSC getSubEcoSectorSC()
    {
	return subEcoSectorSC;
    }

    /**
     * @param subEcoSectorSC the subEcoSectorSC to set
     */
    public void setSubEcoSectorSC(SubEcoSectorSC subEcoSectorSC)
    {
	this.subEcoSectorSC = subEcoSectorSC;
    }

    /**
     * @return the subEcoSectorVO
     */
    public RIFSECVO getSubEcoSectorVO()
    {
	return subEcoSectorVO;
    }

    /**
     * @param subEcoSectorVO the subEcoSectorVO to set
     */
    public void setSubEcoSectorVO(RIFSECVO subEcoSectorVO)
    {
	this.subEcoSectorVO = subEcoSectorVO;
    }

    /**
     * @param subEcoSectorBO the subEcoSectorBO to set
     */
    public void setSubEcoSectorBO(SubEcoSectorBO subEcoSectorBO)
    {
	this.subEcoSectorBO = subEcoSectorBO;
    }
}
