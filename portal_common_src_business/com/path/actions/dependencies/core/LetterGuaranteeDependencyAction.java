package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.letterguarantee.LetterGuaranteeBO;
import com.path.dbmaps.vo.TFSLGVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.letterguarantee.LetterGuaranteeSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: ghenoiesaab
 * 
 *          LetterGuaranteeDependencyAction.java used to check LG dependency
 */

public class LetterGuaranteeDependencyAction extends RetailBaseAction
{
    LetterGuaranteeSC criteria = new LetterGuaranteeSC();
    private TFSLGVO tfsLgVO = new TFSLGVO();
    private LetterGuaranteeBO letterGuaranteeBO;

    /**
     * used for the dependency management on Letter Guarantee management.
     * 
     * @return
     */
    public String dependencyByLetterGuarantee()
    {
	try
	{

	    if(NumberUtil.isEmptyDecimal(criteria.getReqNbr()))
	    {

		throw new BOException(MessageCodes.INVALID_LG_REFERENCE);
	    }
	    else
	    {
		SessionCO sessionCO = returnSessionObject();
		/**
		 * set the criteria...
		 */
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setBranchCode(sessionCO.getBranchCode());
		criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		
		tfsLgVO = letterGuaranteeBO.checkLetterGuaranteeValidation(criteria);
		if(tfsLgVO == null)
		{
		    throw new BOException(MessageCodes.INVALID_LG_REFERENCE);
		}
	    }
	}
	catch(Exception e)
	{

	    log.error(e, "Error in dependencyByLetterGuarantee method of LetterGuaranteeDependencyAction.");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setLetterGuaranteeBO(LetterGuaranteeBO letterGuaranteeBO)
    {
	this.letterGuaranteeBO = letterGuaranteeBO;
    }

    public TFSLGVO getTfsLgVO()
    {
	return tfsLgVO;
    }

    public void setTfsLgVO(TFSLGVO tgsLgVO)
    {
	this.tfsLgVO = tgsLgVO;
    }

    public LetterGuaranteeSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(LetterGuaranteeSC criteria)
    {
	this.criteria = criteria;
    }

    public Object getModel()
    {
	return criteria;
    }

}
