/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.legalstatus.LegalStatusBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIF_EXTENDEDVO;
import com.path.dbmaps.vo.LEGAL_STATUSVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.legalstatus.LegalStatusSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          LegalStatusDependencyAction.java used to
 */
public class LegalStatusDependencyAction extends RetailBaseAction
{
    private LegalStatusBO legalStatusBO;
    private LegalStatusSC legalStatusSC = new LegalStatusSC();
    private LEGAL_STATUSVO legalStatusVO;
    private CIF_EXTENDEDVO cifExtendedVO;
    
    public String dependencyByStatusCode()
    {
	try
	{ 
	    SessionCO sessionCO = returnSessionObject();
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
	    if (null != cifControlVO)
	    {
		legalStatusSC.setUseCifMatrix(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()));
	    }	    
	    if(("1").equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN())) &&(NumberUtil.isEmptyDecimal(cifExtendedVO.getECO_AGENT()) || cifExtendedVO == null))
	    {
		throw new BOException(MessageCodes.PLEASE_FILL, new String[] { "economic_agent_key" });
       	    }	
	    
	    if(NumberUtil.emptyDecimalToNull(legalStatusSC.getStatusCode()) == null)
	    {
		legalStatusVO = new LEGAL_STATUSVO();
	    }
	    else
	    {		
		legalStatusSC.setCompCode(sessionCO.getCompanyCode());
		legalStatusSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
		legalStatusVO = legalStatusBO.returnDependencyByStatusCode(legalStatusSC);
		legalStatusVO = (legalStatusVO == null ? new LEGAL_STATUSVO() : legalStatusVO);
	    }
	}
	catch(Exception e)
	{
	    legalStatusVO = new LEGAL_STATUSVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    @Override
    public LegalStatusSC getModel()
    {
	return legalStatusSC;
    }

    /**
     * @return the legalStatusSC
     */
    public LegalStatusSC getLegalStatusSC()
    {
	return legalStatusSC;
    }

    /**
     * @param legalStatusSC the legalStatusSC to set
     */
    public void setLegalStatusSC(LegalStatusSC legalStatusSC)
    {
	this.legalStatusSC = legalStatusSC;
    }

    /**
     * @return the legalStatusVO
     */
    public LEGAL_STATUSVO getLegalStatusVO()
    {
	return legalStatusVO;
    }

    /**
     * @param legalStatusVO the legalStatusVO to set
     */
    public void setLegalStatusVO(LEGAL_STATUSVO legalStatusVO)
    {
	this.legalStatusVO = legalStatusVO;
    }

    /**
     * @param legalStatusBO the legalStatusBO to set
     */
    public void setLegalStatusBO(LegalStatusBO legalStatusBO)
    {
	this.legalStatusBO = legalStatusBO;
    }

    public CIF_EXTENDEDVO getCifExtendedVO()
    {
        return cifExtendedVO;
    }

    public void setCifExtendedVO(CIF_EXTENDEDVO cifExtendedVO)
    {
        this.cifExtendedVO = cifExtendedVO;
    }

}
