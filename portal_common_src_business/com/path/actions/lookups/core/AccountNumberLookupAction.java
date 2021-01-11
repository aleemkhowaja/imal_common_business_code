/**
 * 
 */
package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.account.AccountBO;
import com.path.dbmaps.vo.AMFVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.core.account.AccountSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AccountNumberLookupAction.java used to
 */
public class AccountNumberLookupAction extends LookupBaseAction
{
    private AccountSC accountSC = new AccountSC();
    private AccountBO accountBO;
    
    /**
     * Construct AccountNumber Lookup based on the VO returned in the
     * resultMap.
     * window : w_lookup_acc_no
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names 
	    String[] name = { "ACC_NO"};
	    String[] colType = { "text"};
	    String[] titles = { getText("Account_Number_key")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Account_Number_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AccountNumber_fillAccountNumberLookup");
	    grid.setShrinkToFit("true");
	    lookup(grid, accountSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of AccountNumberLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    /**
     * Fill the lookup for AccountNumber data filtered by the defined criteria
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String fillAccountNumberLookup()
    {
	try
	{
	    setSearchFilter(accountSC);
	    copyproperties(accountSC);
	    if(checkNbRec(accountSC))
	    {
		setRecords(accountBO.accountNumberListCount(accountSC));
	    }
	    List<AMFVO> amfVOList = accountBO.accountNumberList(accountSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(amfVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of AccountNumberLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * @param accountBO the accountBO to set
     */
    public void setAccountBO(AccountBO accountBO)
    {
        this.accountBO = accountBO;
    }
    
    /**
     * @return the accountSC
     */
    @Override
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
}
