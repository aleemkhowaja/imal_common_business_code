package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.lettercredit.LetterCreditBO;
import com.path.dbmaps.vo.TFSLC1VO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.lettercredit.LetterCreditCO;
import com.path.vo.core.lettercredit.LetterCreditSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: ghenoiesaab
 * @date: Jul 8, 2013
 * LetterCreditDependencyAction.java used to implement LC dependencies methods
 */
public class LetterCreditDependencyAction extends RetailBaseAction
{
    private TFSLC1VO tfslc1VO = new TFSLC1VO();
    private LetterCreditBO letterCreditBO;
    private LetterCreditSC criteria = new LetterCreditSC();
    private LetterCreditCO letterCreditCO = new LetterCreditCO();

    /**
     * used for the dependency management on Letter Credit management.
     * 
     * @author: ghenoiesaab
     * @date: Oct 3, 2013
     * @PB:
     * @return
     */
    public String dependencyByLetterCredit()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * set the criteria...
	     */
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());

	    tfslc1VO = letterCreditBO.returnLetterCreditById(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByLetterCredit method of LetterCreditDependencyAction.");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    /**
     * used for the dependency management on Import/Export LC
     * 
     * @author: BoushraFahs
     * @date: 4 Oct 2013
     * @PB:
     * @return
     */
    public String dependencyByLC()
    {
        try
        {
            if(NumberUtil.isEmptyDecimal(criteria.getLcRefNbr()))
            {
                throw new BOException(MessageCodes.INVALID_LC_REFERENCE);
            }
            else
            {
        	SessionCO sessionCO = returnSessionObject();
        	/**
        	 * set the criteria...
        	 */
        	criteria.setCompCode(sessionCO.getCompanyCode());
        	criteria.setBranchCode(sessionCO.getBranchCode());
        	
        	letterCreditCO = letterCreditBO.returnLcDetailsById(criteria);
        	if(letterCreditCO == null)
        	{
        	    throw new BOException(MessageCodes.INVALID_LC_REFERENCE);
        	}
            }
        }
        catch(Exception e)
        {
            log.error(e, "Error in dependencyByLC method of LetterCreditDependencyAction.");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    public void setLetterCreditBO(LetterCreditBO letterCreditBO)
    {
	this.letterCreditBO = letterCreditBO;
    }

    public TFSLC1VO getTfslc1VO()
    {
	return tfslc1VO;
    }

    public void setTfslc1VO(TFSLC1VO tfslc1vo)
    {
	tfslc1VO = tfslc1vo;
    }

    public Object getModel()
    {
	return criteria;
    }

    public LetterCreditSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(LetterCreditSC criteria)
    {
        this.criteria = criteria;
    }


    /**
     * @return the letterCreditCO
     */
    public LetterCreditCO getLetterCreditCO()
    {
        return letterCreditCO;
    }


    /**
     * @param letterCreditCO the letterCreditCO to set
     */
    public void setLetterCreditCO(LetterCreditCO letterCreditCO)
    {
        this.letterCreditCO = letterCreditCO;
    }
}
