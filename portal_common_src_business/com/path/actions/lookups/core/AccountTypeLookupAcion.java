package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.accounttype.AccountTypeBO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.core.accounttype.AccountTypeSC;

public class AccountTypeLookupAcion extends LookupBaseAction {
	
	
	AccountTypeSC criteria = new AccountTypeSC();
	private AccountTypeBO accountTypeBO;
	private BigDecimal TYPE_CODE;
	
	@Override
	public Object getModel()
    {
		return criteria;
    }
	 
	public String constructLookup()
    {
	try
	{	   
	    // Design the Grid by defining the column model and column names
	    String[] name = {"TYPE_CODE",
                             "BRIEF_DESC_ENG",
                             "BRIEF_DESC_ARAB",
                             "LONG_DESC_ENG",
                             "LONG_DESC_ARAB",
                             "ADDITIONAL_REFERENCE"
	    					};	
	    String[] colType = { "number", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
	    		getText("Long_Desc_Eng_key"),getText("Long_Desc_Arab_key"), getText("Additional_Reference_key")};
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"TYPE_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "ADDITIONAL_REFERENCE"
	    					};
		colType = new String[] { "number", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
	    		getText("Long_Desc_Eng_key"), getText("Additional_Reference_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Account_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AccountTypeLookup_fillAccountTypeLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of AccountTypeLookupAcion");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Cities data filtered by the defined criteria
     * 
     * @return
     */
    public String fillAccountTypeLookup()
    {
	try
	{
	    List<RIFATTVO> accountTypeVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setTypeCode(TYPE_CODE);
	    criteria.setBs_contra("B");
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(accountTypeBO.accountTypeListCount(criteria));
	    }
	    accountTypeVOList = accountTypeBO.accountTypeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(accountTypeVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillAccountTypeLookup of AccountTypeLookupAcion");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    public BigDecimal getTYPE_CODE()
	{
		return TYPE_CODE;
	}

	public void setTYPE_CODE(BigDecimal tYPECODE)
	{
		TYPE_CODE = tYPECODE;
	}

	public void setCriteria(AccountTypeSC criteria)
	{
		this.criteria = criteria;
	}

	public void setAccountTypeBO(AccountTypeBO accountTypeBO)
	{
		this.accountTypeBO = accountTypeBO;
	}

	public AccountTypeSC getCriteria()
	{
		return criteria;
	}
}
