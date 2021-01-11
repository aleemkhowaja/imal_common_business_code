package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.currency.CurrencyBO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.currency.CurrencySC;

public class CurrencyLookupAction extends LookupBaseAction
{

   
    private CurrencySC currencySC = new CurrencySC();
    private List<CURRENCIESVO> currencyVOList;
    private CurrencyBO currencyBO;

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
	    String[] name = { "CURRENCY_CODE", "BRIEF_DESC_ENG","BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB","ADDITIONAL_REFERENCE","DECIMAL_POINTS", "UNIT" };
	    String[] colType = { "number", "text", "text", "text","text", "text","number", "number" };
	    String[] titles = { getText("Currency_Code_key"), getText("Brief_Description_key"),
		    getText("Arabic_Brief_Name_key"),
		    getText("Long_Description_key"),getText("Long_Name_Arab_key"),getText("Additional_Ref_key"), getText("Decimal_points_key"), getText("Unit_key") };
	    
	     /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		  name = new String[] { "CURRENCY_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "ADDITIONAL_REFERENCE","DECIMAL_POINTS", "UNIT" };
		  colType = new String[]{ "number", "text","text","text","number", "number" };
		  titles = new String[] { getText("Currency_Code_key"), getText("Brief_Description_key"),
			    getText("Long_Description_key"), getText("Additional_Ref_key"), getText("Decimal_points_key"), getText("Unit_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Currency_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/currencyLookup_fillCurrencyLookup");
	    List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
	    columnSpecs.get(0).setLeadZeros("3");
	    lookup(grid, columnSpecs, null, currencySC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String fillCurrencyLookup()
    {
	try
	{
	    setSearchFilter(currencySC);
	    copyproperties(currencySC);
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * if condition added By HanaaElJazzar for TrxTemplate Screen. If
	     * the company code was not sent to this method, then take it from
	     * the session...
	     */
	    if(NumberUtil.isEmptyDecimal(currencySC.getCompCode()))
	    {
		currencySC.setCompCode(sessionCO.getCompanyCode());
	    }
	    currencySC.setBranchCode(sessionCO.getBranchCode());
	    String originOptRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
	    }
	    if("REGCLMT".equals(originOptRef))
	    {
		currencySC.setAccBrCode(sessionCO.getBranchCode());
		if(checkNbRec(currencySC))
		{
		    setRecords(currencyBO.currencyAmfListCount(currencySC));
		}
		currencyVOList = currencyBO.currencyAmfList(currencySC);
	    }
	    else
	    {
		if(checkNbRec(currencySC))
		{
		    setRecords(currencyBO.currencyListCount(currencySC));
		}
		currencyVOList = currencyBO.currencyList(currencySC);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(currencyVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of CurrencyLookUpAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public String allCurrenciesConstructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CURRENCY_CODE", "BRIEF_DESC_ENG","BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB","ADDITIONAL_REFERENCE","DECIMAL_POINTS", "UNIT" };
	    String[] colType = { "number", "text", "text", "text","text", "text","number", "number" };
	    String[] titles = { getText("Currency_Code_key"), getText("Brief_Description_key"),
		    getText("Arabic_Brief_Name_key"),
		    getText("Long_Description_key"),getText("Long_Name_Arab_key"),getText("Additional_Ref_key"), getText("Decimal_points_key"), getText("Unit_key") };
	    
	     /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		  name = new String[] { "CURRENCY_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "ADDITIONAL_REFERENCE","DECIMAL_POINTS", "UNIT" };
		  colType = new String[]{ "number", "text","text","text","number", "number" };
		  titles = new String[] { getText("Currency_Code_key"), getText("Brief_Description_key"),
			    getText("Long_Description_key"), getText("Additional_Ref_key"), getText("Decimal_points_key"), getText("Unit_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Currency_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/currencyLookup_fillAllCurrenciesConstructLookup");
	    List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
	    columnSpecs.get(0).setLeadZeros("3");
	    lookup(grid, columnSpecs, null, currencySC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    public String fillAllCurrenciesConstructLookup()
    {
	try
	{
	    setSearchFilter(currencySC);
	    copyproperties(currencySC);
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * if condition added By HanaaElJazzar for TrxTemplate Screen. If
	     * the company code was not sent to this method, then take it from
	     * the session...
	     */
	    if(NumberUtil.isEmptyDecimal(currencySC.getCompCode()))
	    {
		currencySC.setCompCode(sessionCO.getCompanyCode());
	    }
	    currencySC.setAllCurrenciesFlag("true");
	    currencySC.setLanguage(sessionCO.getLanguage());
	    
	    if(checkNbRec(currencySC))
	    {
		setRecords(currencyBO.currencyListCount(currencySC));
	    }
	    currencyVOList = currencyBO.currencyList(currencySC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(currencyVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of CurrencyLookUpAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public String constructLookupAddRef()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CURRENCY_CODE", "ADDITIONAL_REFERENCE", "BRIEF_DESC_ENG", "LONG_DESC_ENG",
		    "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Currency_Code_key"), getText("Additional_Ref_key"),
		    getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
		    getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CURRENCY_CODE", "ADDITIONAL_REFERENCE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text", "text" };
		titles = new String[] { getText("Currency_Code_key"), getText("Additional_Ref_key"),
			getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Currency_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/currencyLookup_fillCurrencyLookupAddRef");
	    lookup(grid, currencySC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillCurrencyLookupAddRef()
    {
	try
	{
	    currencySC.setCompCode(returnSessionObject().getCompanyCode());
	    setSearchFilter(currencySC);
	    copyproperties(currencySC);

	    if(checkNbRec(currencySC))
	    {
		setRecords(currencyBO.currencyListCount(currencySC));
	    }
	    currencyVOList = currencyBO.currencyList(currencySC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(currencyVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCurrencyLookupAddRef of CurrencyLookUpAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String constructLookupFms()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CURRENCY_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "DECIMAL_POINTS", "UNIT" };
	    String[] colType = { "number", "text", "text", "number", "number" };
	    String[] titles = { getText("Currency_Code_key"), getText("Brief_Description_key"),
		    getText("Long_Description_key"), getText("Decimal_points_key"), getText("UNIT") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Currency_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/currencyLookup_fillCurrencyLookupFms");
	    // TP#468490; Ajas.Abbas; 09/02/2017
	     List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
	     columnSpecs.get(0).setLeadZeros("3");
	     lookup(grid, columnSpecs, null, currencySC);
 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String fillCurrencyLookupFms()
    {
	try
	{
	    setSearchFilter(currencySC);
	    copyproperties(currencySC);
	    SessionCO sessionCO = returnSessionObject();
	    currencySC.setCompCode(sessionCO.getCompanyCode());
	    currencySC.setBranchCode(sessionCO.getBranchCode());

	    String originOptRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
	    }
	    if("REGCLMT".equals(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), originOptRef)))
	    {
		currencySC.setAccBrCode(sessionCO.getBranchCode());
		if(checkNbRec(currencySC))
		{
		    setRecords(currencyBO.currencyAmfListCount(currencySC));
		}
		currencyVOList = currencyBO.currencyAmfList(currencySC);
	    }
	    else
	    {
		if(checkNbRec(currencySC))
		{
		    setRecords(currencyBO.currencyListCount(currencySC));
		}
		currencyVOList = currencyBO.currencyList(currencySC);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(currencyVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCurrencyLookupFms of CurrencyLookUpAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	/** @author Anand.Ramadas */
    public String constructLookupFAS()
    {
       try
       {
           // Design the Grid by defining the column model and column names
           String[] name = { "CURRENCY_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "DECIMAL_POINTS", "UNIT" };
           String[] colType = { "number", "text", "text", "number", "number" };
           String[] titles = { getText("Currency_Code_key"), getText("Brief_Description_key"),
                  getText("Long_Description_key"), getText("Decimal_points_key"), getText("UNIT") };

           // Defining the Grid
           LookupGrid grid = new LookupGrid();
           grid.setCaption(getText("Currency_key"));
           grid.setRowNum("5");
           grid.setUrl("/pathdesktop/currencyLookup_fillCurrencyLookupFAS");
           List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
           columnSpecs.get(0).setLeadZeros("3");
           lookup(grid, columnSpecs, null, currencySC);

       }
       catch(Exception e)
       {
           handleException(e, null, null);
       }

       return SUCCESS;
    }

    /** @author Anand.Ramadas */
    public String fillCurrencyLookupFAS()
    {
       try
       {
           setSearchFilter(currencySC);
           copyproperties(currencySC);
           SessionCO sessionCO = returnSessionObject();
           currencySC.setCompCode(sessionCO.getCompanyCode());
           currencySC.setBranchCode(sessionCO.getBranchCode());

           if(checkNbRec(currencySC))
           {
              setRecords(currencyBO.currencyListCountFAS(currencySC));
           }
           currencyVOList = currencyBO.currencyListFAS(currencySC);
           // set the collection into gridModel attribute defined at JSP grid
           setGridModel(currencyVOList);

       }
       catch(Exception e)
       {
           log.error(e, "Error in fillCurrencyLookupFms of CurrencyLookUpAction");
           handleException(e, null, null);
       }
       return SUCCESS;
    }


    public CurrencySC getCurrencySC()
    {
	return currencySC;
    }

    public void setCurrencySC(CurrencySC currencySC)
    {
	this.currencySC = currencySC;
    }

    public void setCurrencyBO(CurrencyBO currencyBO)
    {
	this.currencyBO = currencyBO;
    }

}
