/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.economicsector.EconomicSectorBO;
import com.path.dbmaps.vo.ECO_SECTORSVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.economicsector.EconomicSectorSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 */
public class EconomicSectorDependencyAction extends RetailBaseAction
{
    private EconomicSectorBO economicSectorBO;
    private EconomicSectorSC economicSectorSC = new EconomicSectorSC();
    private ECO_SECTORSVO ecoSectorsVO;

    /**
     * Method to handle the dependency of eco sector
     * 
     * @return String
     */
    public String dependencyBySectorCode()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(economicSectorSC.getSectorCode()))
	    {
		SessionCO sessionCO = returnSessionObject();
		economicSectorSC.setCompCode(sessionCO.getCompanyCode());
		economicSectorSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
		economicSectorSC.setAllTypes(getText("All_types_key"));
		ecoSectorsVO = economicSectorBO.returnDependencyBySectorCode(economicSectorSC);
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyBySectorCode method of EconomicSectorDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @return the economicSectorSC
     */
    public EconomicSectorSC getModel()
    {
	return economicSectorSC;
    }

    /**
     * @return the economicSectorSC
     */
    public EconomicSectorSC getEconomicSectorSC()
    {
	return economicSectorSC;
    }

    /**
     * @param economicSectorSC the economicSectorSC to set
     */
    public void setEconomicSectorSC(EconomicSectorSC economicSectorSC)
    {
	this.economicSectorSC = economicSectorSC;
    }

    /**
     * @param economicSectorBO the economicSectorBO to set
     */
    public void setEconomicSectorBO(EconomicSectorBO economicSectorBO)
    {
	this.economicSectorBO = economicSectorBO;
    }

    /**
     * @return the ecoSectorsVO
     */
    public ECO_SECTORSVO getEcoSectorsVO()
    {
	return ecoSectorsVO;
    }

    /**
     * @param ecoSectorsVO the ecoSectorsVO to set
     */
    public void setEcoSectorsVO(ECO_SECTORSVO ecoSectorsVO)
    {
	this.ecoSectorsVO = ecoSectorsVO;
    }

}
