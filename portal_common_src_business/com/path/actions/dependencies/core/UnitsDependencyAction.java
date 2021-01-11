/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.unit.UnitsBO;
import com.path.dbmaps.vo.UNITSVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.unit.UnitSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * UnitsDependencyAction.java used to
 */
public class UnitsDependencyAction extends RetailBaseAction
{
    private UnitsBO unitsBO;
    private UnitSC unitSC = new UnitSC();
    private UNITSVO unitVO;
    
    
    /**
     * get the selected unitVO object by unit code on dependency action
     * @return the String
     */
    public String dependencyByUnitCode()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(unitSC.getDeptCode()) && !NumberUtil.isEmptyDecimal(unitSC.getDivisionCode()) && !NumberUtil.isEmptyDecimal(unitSC.getUnitCode()))
	    {
		SessionCO sessionCO = returnSessionObject();
		if(NumberUtil.isEmptyDecimal(unitSC.getCompCode())){
			unitSC.setCompCode(sessionCO.getCompanyCode());
		}
		unitVO = unitsBO.returnDependencyByUnitCode(unitSC);
		if(unitVO == null)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Unit_key" });
		}
	    }
	    // if(unitVO == null )
	    // unitVO = new UNITSVO();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * @return the unitSC
     */
    @Override
    public Object getModel()
    {
        return unitSC;
    }
    /**
     * @return the unitSC
     */
    public UnitSC getUnitSC()
    {
        return unitSC;
    }
    /**
     * @param unitSC the unitSC to set
     */
    public void setUnitSC(UnitSC unitSC)
    {
        this.unitSC = unitSC;
    }
    /**
     * @return the unitVO
     */
    public UNITSVO getUnitVO()
    {
        return unitVO;
    }
    /**
     * @param unitVO the unitVO to set
     */
    public void setUnitVO(UNITSVO unitVO)
    {
        this.unitVO = unitVO;
    }
    /**
     * @param unitsBO the unitsBO to set
     */
    public void setUnitsBO(UnitsBO unitsBO)
    {
        this.unitsBO = unitsBO;
    }
}
