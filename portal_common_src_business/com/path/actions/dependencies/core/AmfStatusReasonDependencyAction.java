/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.amfstatus.AmfStatusReasonBO;
import com.path.dbmaps.vo.AMF_SUSPEND_REASONVO;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.amfstatus.AmfStatusSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AmfStatusReasonDependencyAction.java used to
 */
public class AmfStatusReasonDependencyAction extends RetailBaseAction
{
    private AmfStatusReasonBO amfStatusReasonBO;
    private AmfStatusSC amfStatusSC = new AmfStatusSC();
    private AMF_SUSPEND_REASONVO amfSuspendReasonVO;
    
    /**
     * get the selected amfSuspendReasonVO object by code on dependency action
     * 
     * @return the String
     */
    public String dependencyByCode()
    {
	try
	{
	    if(amfStatusSC.getCode() != null)
	    {
		SessionCO sessionCO = returnSessionObject();
		amfStatusSC.setCompCode(sessionCO.getCompanyCode());
		/*
		 * add orginal progref to the criteria in case there is an
		 * original progRef. this case will be exists in SAVE AS Management
		 */
		String originalProgRef = StringUtil.nullEmptyToValue(returnCommonLibBO().returnOrginProgRef(
			sessionCO.getCurrentAppName(), get_pageRef()), get_pageRef());
		if("A001CL".equalsIgnoreCase(originalProgRef) || "A002CL".equalsIgnoreCase(originalProgRef)
			|| "A002CLT".equalsIgnoreCase(originalProgRef)
			|| "TA001MT".equalsIgnoreCase(originalProgRef))
		{
		    amfStatusSC.setStatusType("C");
		    
		    if("TA001MT".equalsIgnoreCase(originalProgRef)){
			amfStatusSC.setCannotReopen(Boolean.TRUE);
		    }
		}
		
		/*
		 * jihane TP241411 in case of suspend send status type to avoid
		 * selecting wrong suspend reason
		 */
		if("A001ZP".equalsIgnoreCase(originalProgRef) || "A002ZP".equalsIgnoreCase(originalProgRef))
		{
		    amfStatusSC.setStatusType("S");
		}
		
		amfSuspendReasonVO = amfStatusReasonBO.returnDependencyByCode(amfStatusSC);
	    }
	    if(amfSuspendReasonVO == null)
	    {
		amfSuspendReasonVO = new AMF_SUSPEND_REASONVO();
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in returnDependencyByCode method of AmfStatusReasonDependencyAction");
	    handleException(e, "ERROR IN AmfStatusReason DEPENDENCY MANAGEMENT", null);
	}
	return SUCCESS;
    }
    
    /**
     * @return the amfStatusSC
     */
    @Override
    public Object getModel()
    {
        return amfStatusSC;
    }

    /**
     * @return the amfStatusSC
     */
    public AmfStatusSC getAmfStatusSC()
    {
        return amfStatusSC;
    }

    /**
     * @param amfStatusSC the amfStatusSC to set
     */
    public void setAmfStatusSC(AmfStatusSC amfStatusSC)
    {
        this.amfStatusSC = amfStatusSC;
    }

    /**
     * @return the amfSuspendReasonVO
     */
    public AMF_SUSPEND_REASONVO getAmfSuspendReasonVO()
    {
        return amfSuspendReasonVO;
    }

    /**
     * @param amfSuspendReasonVO the amfSuspendReasonVO to set
     */
    public void setAmfSuspendReasonVO(AMF_SUSPEND_REASONVO amfSuspendReasonVO)
    {
        this.amfSuspendReasonVO = amfSuspendReasonVO;
    }

    /**
     * @param amfStatusReasonBO the amfStatusReasonBO to set
     */
    public void setAmfStatusReasonBO(AmfStatusReasonBO amfStatusReasonBO)
    {
        this.amfStatusReasonBO = amfStatusReasonBO;
    }
}
