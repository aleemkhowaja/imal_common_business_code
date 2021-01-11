package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.passbook.PassbookBO;
import com.path.dbmaps.vo.CTSPASSBOOK_TYPEVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.passbook.PassBookCO;
import com.path.vo.core.passbook.PassbookSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * PassbookDependencyAction.java used to
 */
public class PassbookDependencyAction extends RetailBaseAction
{
    private PassbookBO passbookBO;
    private CTSPASSBOOK_TYPEVO passbookVO;
    private PassbookSC criteria = new PassbookSC();
    private PassBookCO passBookCO = new PassBookCO();

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public String dependencyByPassbookCode()
    {
	try
	{
	    if(NumberUtil.isEmptyDecimal(criteria.getPassbookCode()))
	    {
		passbookVO = new CTSPASSBOOK_TYPEVO();
	    }
	    else
	    {
		SessionCO sessionCO = returnSessionObject();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setBranchCode(sessionCO.getBranchCode());
		criteria.setPreferredLanguage(sessionCO.getLanguage());
		passBookCO = passbookBO.returnPassbookById(criteria);
		passbookVO = passBookCO.getPassBookTypeVO();
		
		if(passBookCO.getListWarningMsg() != null && passBookCO.getListWarningMsg().size() != 0)
		{
		    StringBuffer listWarningMsg = new StringBuffer();
		    for(String warningMsg : passBookCO.getListWarningMsg())
		    {
			listWarningMsg.append(warningMsg);
			listWarningMsg.append("\n");
		    }
		    set_warning(listWarningMsg.toString());
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByPassbookCode method of PassbookDependencyAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public CTSPASSBOOK_TYPEVO getPassbookVO()
    {
	return passbookVO;
    }

    public void setPassbookVO(CTSPASSBOOK_TYPEVO passbookVO)
    {
	this.passbookVO = passbookVO;
    }

    public void setPassbookBO(PassbookBO passbookBO)
    {
	this.passbookBO = passbookBO;
    }

    public PassbookSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(PassbookSC criteria)
    {
        this.criteria = criteria;
    }

    public PassBookCO getPassBookCO()
    {
    	return passBookCO;
    }

    public void setPassBookCO(PassBookCO passBookCO)
    {
    	this.passBookCO = passBookCO;
    }
    
}
