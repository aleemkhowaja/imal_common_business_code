package com.path.actions.lookups.core;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.core.account.AccountTierNoBO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.account.AccountTierNoCO;

public class AccountTierNoLookupAction extends LookupBaseAction
{
    private AccountSC criteria = new AccountSC();
    private List<AccountTierNoCO> accountTiersCOList;
    private AccountTierNoBO accountTierNoBO;
    
    @Override
    public Object getModel()
    {
	return criteria;
    }
   
    /**
     * Construct Tier No Lookup based on CSM Admin created tier No.
     * 
     * @return
     */
    public String constructTierNoLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = {"accLimitScreenCode","accLimitDesc","accLimitBy","accTierNO" };
	    String[] colType = {"number","text","text","number"};
	    String[] titles = { getText("code_key"),getText("value_desc_key"),getText("limit_by_key"),getText("limit_tier_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("accountList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AccountTierNo_fillTierNoLookup");

	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();

	    int cols = name.length;
	    for(int i = 0; i < cols; i++)
	    {
		// Defining each column
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, criteria);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of AccountTierNoLookupAction");
	    e.printStackTrace();
	}
	return SUCCESS;
	    
    }
    
    /**
    * Fill the lookup account data filtered by the defined criteria
    * 
    */
   public String fillTierNoLookup()
   {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(accountTierNoBO.accountTierNoListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(accountTierNoBO.accountTierNoList(criteria));

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of constructTierNoLookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
   }

    public AccountSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(AccountSC criteria)
    {
        this.criteria = criteria;
    }

    public List<AccountTierNoCO> getAccountTiersCOList()
    {
        return accountTiersCOList;
    }

    public void setAccountTiersCOList(List<AccountTierNoCO> accountTiersCOList)
    {
        this.accountTiersCOList = accountTiersCOList;
    }

    public void setAccountTierNoBO(AccountTierNoBO accountTierNoBO)
    {
        this.accountTierNoBO = accountTierNoBO;
    }
}
