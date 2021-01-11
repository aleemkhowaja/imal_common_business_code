package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.currencynominationdet.CurrencyNominationDetBO;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.dbmaps.vo.CURRENCY_NOMINATION_DETVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.currency.CurrencySC;

public class CurrencyNominationDetLookupAction extends LookupBaseAction
{
    
    private final CurrencySC currencySC = new CurrencySC();
    private List<CURRENCY_NOMINATION_DETVO> currencyNominationDetVO;
    private CurrencyNominationDetBO currencyNominationDetBO;
    private String trxType;
    
    @Override
    public Object getModel()
    {
	return currencySC;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "VALUE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Value_key"), getText("Brief_Description_key"),
		    getText("Long_Description_key"), getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[]{ "VALUE", "BRIEF_DESC_ENG", "LONG_DESC_ENG"};
		colType = new String[]{ "number", "text", "text"};
		titles = new String[]{ getText("Value_key"), getText("Brief_Description_key"), getText("Long_Description_key")};
	    }
	    String originOptRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(returnSessionObject().getCurrentAppName(), get_pageRef());
	    }
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(" ");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/currencyNominationDetLookup_fillCyNominationDetLookup?_pageRef="+originOptRef);
	  /*  int cols = name.length;

	    for(int i = 0; i < cols; i++)
	    {
		// Defining each column
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, currencySC);
	    */
	    lookup(grid, currencySC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillCyNominationDetLookup()
    {
	try
	{
	    setSearchFilter(currencySC);
	    copyproperties(currencySC);
	    SessionCO sessionCO = returnSessionObject();
	    currencySC.setCompCode(sessionCO.getCompanyCode());
	    
	    // TONY NOUH Tar BPI120089 on 03/12/2013
	    // Added By Joyce For Tar BPI120089 on 14/03/2013 as discussed with Marwan, since the field value will be protected only when TRX_TYPE = 'D'
	    // from transaction screen we should only see the details if CTSTRXTYPE.TYPE equals D
	    /*
             * optRef is added in order to open the
             * account lookup in transaction screen when opened from dynamic OPT
             */
            String optRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		optRef = returnCommonLibBO().returnOrginProgRef(returnSessionObject().getCurrentAppName(), get_pageRef());
	    }
	    if( ("D001MT".equals(optRef) && TrxMgntConstant.DEPOSIT.equals(trxType))
		    || !"D001MT".equals(optRef))
	    {
		if(checkNbRec(currencySC))
		{
		    setRecords(currencyNominationDetBO.currencyNominationDetListCount(currencySC));
		}
		currencyNominationDetVO = currencyNominationDetBO
		    	.currencyNominationDetList(currencySC);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(currencyNominationDetVO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setCurrencyNominationDetBO(CurrencyNominationDetBO currencyNominationDetBO)
    {
	this.currencyNominationDetBO = currencyNominationDetBO;
    }

    public String getTrxType()
    {
        return trxType;
    }

    public void setTrxType(String trxType)
    {
        this.trxType = trxType;
    }

}
