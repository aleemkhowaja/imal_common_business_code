package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.core.transferaccoutcriteriaexcep.TransferAccountsCriteriaExceptionSC;

/**
 * @author ALI AMMAR For Transfer Accounts Screen
 * 
 */
public class TransferAccCriteriaExcepLookupAction extends LookupBaseAction
{
    private TransferAccountsCriteriaExceptionSC criteria=new TransferAccountsCriteriaExceptionSC();

    public String constructLookup()
    {
    	try
    	{

    		if(criteria.getExceptionFactor()!=null && !criteria.getExceptionFactor().trim().equals(""))
    		{
    			if("A".equals(criteria.getExceptionFactor())){
    				callAccountCurrencyGrid();	
    			}
    			if("C".equals(criteria.getExceptionFactor())){
    				callCIFTypeGrid();
    			}
    			if("G".equals(criteria.getExceptionFactor())){
    				callGLTypeGrid();
    			}
    			if("L".equals(criteria.getExceptionFactor())){
    				callLegalStatusGrid();
    			}
    			if("P".equals(criteria.getExceptionFactor())){
    				callRankingGrid();
    			}
    			if("R".equals(criteria.getExceptionFactor())){
    				callResidentGrid();

    			}
    		}
    	}catch(Exception e)
    	{
    		handleException(e, null, null);
    	}

    	return SUCCESS;

    }
    
    private void callAccountCurrencyGrid() throws BaseException{
	  // Design the Grid by defining the column model and column names
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CURRENCY_CODE", "BRIEF_DESC_ENG","BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB","ADDITIONAL_REFERENCE","DECIMAL_POINTS", "UNIT" };
	    String[] colType = { "number", "text", "text", "text","text", "text","number", "number" };
	    String[] titles = { getText("Currency_Code_key"), getText("Brief_Description_key"),getText("Arabic_Brief_Name_key"),
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
	    lookup(grid, criteria, name, colType, titles);
    }

 
    private void callCIFTypeGrid() throws BaseException{
	    // Design the Grid by defining the column model and column names
	    String[] name = {"TYPE_CODE",
                         "BRIEF_DESC_ENG",
                         "LONG_DESC_ENG",
                         "BRIEF_DESC_ARAB",
                         "LONG_DESC_ARAB",
                         "ADDITIONAL_REFERENCE"
                         };
	    String[] colType = { "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
        		        getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"), getText("Additional_Reference_key")};

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"TYPE_CODE",
                                "BRIEF_DESC_ENG",
                                "LONG_DESC_ENG",
                                "ADDITIONAL_REFERENCE" };
		colType = new String[] { "text", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"), getText("Additional_Reference_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Cif_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifTypeLookup_fillCifTypeLookup");
	    lookup(grid, criteria, name, colType, titles);
     }
    
    private void callGLTypeGrid() throws BaseException{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "GL_CODE", "TERM_IND", "TERM_DAYS", "BRIEF_DESC_ENG", "BS_CONTRA",
		    "ADDITIONAL_REFERENCE", "AC_SIGN", "BRIEF_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Gl_Code_key"), getText("Period_key"), getText("Number_key"),
		    getText("Brief_Desc_Eng_key"), getText("Bs_Contra_key"), getText("Additional_Reference_key"),
		    getText("AC_Sign_key"), getText("Brief_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "GL_CODE", "TERM_IND", "TERM_DAYS", "BRIEF_DESC_ENG", "BS_CONTRA",
			"ADDITIONAL_REFERENCE", "AC_SIGN" };
		colType = new String[] { "number", "text", "text", "text", "text", "text", "text" };
		titles = new String[] { getText("Gl_Code_key"), getText("Period_key"), getText("Number_key"),
			getText("Brief_Desc_Eng_key"), getText("Bs_Contra_key"), getText("Additional_Reference_key"),
			getText("AC_Sign_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/GLLookup_fillGlLookup");
	    lookup(grid, criteria, name, colType, titles);
     }
    
    private void callLegalStatusGrid() throws BaseException{
	  // Design the Grid by defining the column model and column names
	    String[] name = { "STATUS_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Eng_key"),
		    getText("Long_Desc_Arab_key") };


	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "STATUS_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),  getText("Long_Desc_Eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("legal_status_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/LegalStatus_fillLegalStatusLookup");
	    lookup(grid, criteria, name, colType, titles); 
     }
    
    private void callRankingGrid() throws BaseException{
	   // Design the Grid by defining the column model and column names
	    String[] name = { "PRIORITY_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB" };
	    String[] colType = { "numeric", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
		    getText("Long_Desc_Eng_key"), getText("Long_Desc_Arab_key") };
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "PRIORITY_CODE", "BRIEF_DESC_ENG","LONG_DESC_ENG" };
		colType = new String[] { "numeric", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("legal_status_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Ranking_fillRankingLookup");

	    lookup(grid,criteria,name,colType,titles);
    }
    
    private void callResidentGrid() throws BaseException{

	 String[] name = { "code", "descValue" };
	 String[] colType = { "numeric", "text" };
	 String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key")};
	
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("legal_status_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/TransferAccCriteriaExcepLookupAction_fillResidentLookup");

	    lookup(grid,criteria,name,colType,titles);

    }
    
    /**
     * Fill the lookup for Resident data filtered by the defined criteria
     * 
     * @return
     */
    public String fillResidentLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    
	    SelectSC selSC = new SelectSC(new BigDecimal(24));
	    List<SelectCO> selCOs = returnLOV(selSC);

	    if(checkNbRec(criteria))
	    {
		setRecords(selCOs!=null?selCOs.size():0);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(selCOs);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of fillResidentLookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public TransferAccountsCriteriaExceptionSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(TransferAccountsCriteriaExceptionSC criteria)
    {
        this.criteria = criteria;
    }
}
