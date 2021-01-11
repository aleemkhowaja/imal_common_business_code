/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.account.AccountBO;
import com.path.vo.core.account.AccountSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: raees
 *
 * AccountNumberDependencyAction.java used to
 */
public class AccountNumberDependencyAction extends RetailBaseAction
{
    private AccountSC accountSC = new AccountSC();
    private AccountBO accountBO;
    private String accNumber;

    /**
     * get the selected amfVO object by account number on dependency action
     * @return the String
     */
    public String dependencyByAccountNumber()
    {
	try
	{
	    int checkAccountNumber = accountBO.checkAccountNumber(accountSC);
	    if(checkAccountNumber > 0)
	    {
		accNumber = accountSC.getAccNo();
	    }
	    else
	    {
		accNumber="";
	    }
	}catch (Exception e)
	{
	    log.error(e, "Error in dependencyByAccountNumber method of AccountNumberDependencyAction");
	    handleException(e, "ERROR IN AccountNumber DEPENDENCY MANAGEMENT", null);
	}
	return SUCCESS;
    }

    /**
     * @return the accountSC
     */
    public Object getModel()
    {
	return accountSC;
    }

    /**
     * @return the accountSC
     */
    public AccountSC getAccountSC()
    {
	return accountSC;
    }

    /**
     * @param accountSC the accountSC to set
     */
    public void setAccountSC(AccountSC accountSC)
    {
	this.accountSC = accountSC;
    }

    /**
     * @param accountBO the accountBO to set
     */
    public void setAccountBO(AccountBO accountBO)
    {
	this.accountBO = accountBO;
    }

    /**
     * @return the accNumber
     */
    public String getAccNumber()
    {
	return accNumber;
    }

    /**
     * @param accNumber the accNumber to set
     */
    public void setAccNumber(String accNumber)
    {
	this.accNumber = accNumber;
    }
}
