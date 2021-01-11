package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.productclass.ProductClassBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.productclass.ProductClassCO;
import com.path.vo.core.productclass.ProductClassSC;

public class ProductClassLookupAction extends LookupBaseAction
{

    private ProductClassSC productClassSC = new ProductClassSC();
    private List<ProductClassCO> lstProductClasses;
    private ProductClassBO productClassBO;

    private BigDecimal productClassId;

    @Override
    public Object getModel()
    {
	return productClassSC;
    }

    public String mergeProductLookup()
    {
	try
	{
	    String[] name = { "CODE", "BRIEF_NAME_ENG" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("code_key"), getText("Short_name_eng_key") };

	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/productClassLookup_fillMergeProductClassLookup");
	    lookup(grid, productClassSC, name, colType, titles);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String fillMergeProductClassLookup()
    {

	try
	{
	    setSearchFilter(productClassSC);
	    copyproperties(productClassSC);
	    SessionCO sessionCO = returnSessionObject();
	    productClassSC.setCompCode(sessionCO.getCompanyCode());
	    productClassSC.setBranchCode(sessionCO.getBranchCode());
	    productClassSC.setProductClassCode(productClassId);

	    productClassSC.setAppName(sessionCO.getCurrentAppName());
	    if(productClassSC.getCifNo() == null)
	    {
		productClassSC.setCifNo(BigDecimal.ZERO);
	    }
	    productClassSC.setWindowReference(StringUtil.nullEmptyToValue(productClassSC.getWindowReference(), ""));
	    if((get_pageRef() != null) && (get_pageRef().startsWith("M06")))
	    {
		productClassSC.setFromLimitScreen(true);
	    }
	    if(checkNbRec(productClassSC))
	    {

		setRecords(productClassBO.mergeProductClassesListCount(productClassSC));
	    }

	    if(NumberUtil.emptyDecimalToZero(productClassId).compareTo(BigDecimal.ZERO) != 0)
	    {
		lstProductClasses = productClassBO.mergeproductClassesWithId(productClassSC);
	    }
	    else
	    {
		lstProductClasses = productClassBO.mergeproductClassesList(productClassSC);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(lstProductClasses);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of AccountLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;

    }

    /**
     * Construct the lookup grid.
     * 
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "DESC_ENG" };
	    String[] colType = { "number", "text", "text", "text" };
	    String[] titles = { getText("code_key"), getText("Short_name_eng_key"), getText("Arabic_Brief_Name_key "),
		    getText("Category_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("code_key"), getText("Short_name_eng_key"), getText("Category_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/productClassLookup_fillProductClassLookup?&productClassSC.isRAhnyn="
		    + productClassSC.getIsRAhnyn() + "&productClassSC.isBillsCalac=" + productClassSC.getIsBillsCalac()
		    + "&productClassSC.categoryCode="
		    + NumberUtil.nullToZero(productClassSC.getCategoryCode()).toString() + "&productClassSC.appName="
		    + StringUtil.nullEmptyToValue(productClassSC.getAppName(), ""));
	    lookup(grid, productClassSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillProductClassLookup()
    {
	try
	{
	    setSearchFilter(productClassSC);
	    copyproperties(productClassSC);
	    SessionCO sessionCO = returnSessionObject();
	    productClassSC.setCompCode(sessionCO.getCompanyCode());
	    productClassSC.setBranchCode(sessionCO.getBranchCode());
	    // productClassSC.setAppName("IIS");
	    if(productClassSC.getAppName() == null || "".equals(productClassSC.getAppName()))
	    {
		productClassSC.setAppName(sessionCO.getCurrentAppName());
	    }

	    if(productClassSC.getCifNo() == null)
	    {
		productClassSC.setCifNo(BigDecimal.ZERO);
	    }
	    productClassSC.setWindowReference(StringUtil.nullEmptyToValue(productClassSC.getWindowReference(), ""));
	    if((get_pageRef() != null) && (get_pageRef().startsWith("M06")))
	    {
		productClassSC.setFromLimitScreen(true);
	    }
	    productClassSC.setCategoryCode(NumberUtil.nullToZero(productClassSC.getCategoryCode()));

	    if(checkNbRec(productClassSC))
	    {
		setRecords(productClassBO.productClassesListCount(productClassSC));
	    }
	    lstProductClasses = productClassBO.productClassesList(productClassSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(lstProductClasses);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of AccountLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String constructAllClassLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "DESC_ENG" };
	    String[] colType = { "number", "text", "text", "text" };
	    String[] titles = { getText("code_key"), getText("Short_name_eng_key"), getText("Arabic_Brief_Name_key "),
		    getText("Category_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("code_key"), getText("Short_name_eng_key"), getText("Category_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/productClassLookup_fillProductAllClassLookup?&productClassSC.isRAhnyn="
		    + productClassSC.getIsRAhnyn() + "&productClassSC.isBillsCalac=" + productClassSC.getIsBillsCalac()
		    + "&productClassSC.categoryCode="
		    + NumberUtil.nullToZero(productClassSC.getCategoryCode()).toString() + "&productClassSC.appName="
		    + StringUtil.nullEmptyToValue(productClassSC.getAppName(), ""));
	    lookup(grid, productClassSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillProductAllClassLookup()
    {
	try
	{
	    setSearchFilter(productClassSC);
	    copyproperties(productClassSC);
	    SessionCO sessionCO = returnSessionObject();
	    productClassSC.setCompCode(sessionCO.getCompanyCode());
	    productClassSC.setBranchCode(sessionCO.getBranchCode());
	    productClassSC.setAllClass("true");
	    // productClassSC.setAppName("IIS");
	    if(productClassSC.getAppName() == null || "".equals(productClassSC.getAppName()))
	    {
		productClassSC.setAppName(sessionCO.getCurrentAppName());
	    }

	    if(productClassSC.getCifNo() == null)
	    {
		productClassSC.setCifNo(BigDecimal.ZERO);
	    }
	    productClassSC.setWindowReference(StringUtil.nullEmptyToValue(productClassSC.getWindowReference(), ""));
	    if((get_pageRef() != null) && (get_pageRef().startsWith("M06")))
	    {
		productClassSC.setFromLimitScreen(true);
	    }
	    productClassSC.setCategoryCode(NumberUtil.nullToZero(productClassSC.getCategoryCode()));

	    if(checkNbRec(productClassSC))
	    {
		setRecords(productClassBO.productClassesListCount(productClassSC));
	    }
	    lstProductClasses = productClassBO.productClassesList(productClassSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(lstProductClasses);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of AccountLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct the lookup grid dw_dddw_class.
     * 
     * @return
     */
    public String constructLookupFms()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "DESC_ENG", "CODE", "BRIEF_NAME_ENG" };
	    String[] colType = { "text", "number", "text" };
	    String[] titles = { getText("Category_key"), getText("code_key"), getText("Short_name_eng_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/productClassLookup_fillProductClassLookupFms");
	    lookup(grid, productClassSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    @SuppressWarnings("unchecked")
    public String fillProductClassLookupFms()
    {
	try
	{
	    setSearchFilter(productClassSC);
	    copyproperties(productClassSC);
	    SessionCO sessionCO = returnSessionObject();
	    productClassSC.setCompCode(sessionCO.getCompanyCode());
	    productClassSC.setBranchCode(sessionCO.getBranchCode());
	    if(NumberUtil.isEmptyDecimal(productClassSC.getCifNo()))
	    {
		productClassSC.setCifNo(BigDecimal.ZERO);
	    }
	    productClassSC.setGradeByCif(productClassBO.returnGradeByCif(productClassSC));
	    // "G": Grading & "A" Application/Facility
	    if("G".equals(productClassSC.getCalledFrom()))
	    {
		if("Y".equals(productClassSC.getGradeByCif())
			&& NumberUtil.isEmptyDecimal(productClassSC.getFacilityType()))
		{
		    productClassSC.setFacilityType(BigDecimal.valueOf(-1));
		    productClassSC.setItem("A");
		}
		if("N".equals(productClassSC.getGradeByCif()) && NumberUtil.isEmptyDecimal(productClassSC.getAppCode()))
		{
		    productClassSC.setItem("A");
		}
		// TP ID # 242654 to filter by the selected Product class in
		// Grading Screen
		if(!NumberUtil.isEmptyDecimal(productClassSC.getAppCode())
			&& !NumberUtil.isEmptyDecimal(productClassSC.getProductClassCode()))
		{
		    productClassSC.set_search("true");
		    productClassSC.setColSearchQuery("CODE = " + productClassSC.getProductClassCode());
		}
	    }

	    if(checkNbRec(productClassSC))
	    {
		setRecords(productClassBO.productClassesListCountFms(productClassSC));
	    }
	    lstProductClasses = productClassBO.productClassesListFms(productClassSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(lstProductClasses);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of fillProductClassLookupFms");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public ProductClassSC getProductClassSC()
    {
	return productClassSC;
    }

    public void setProductClassSC(ProductClassSC productClassSC)
    {
	this.productClassSC = productClassSC;
    }

    public void setProductClassBO(ProductClassBO productClassBO)
    {
	this.productClassBO = productClassBO;
    }

    public String constructDealClassLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "DESC_ENG" };
	    String[] colType = { "number", "text", "text", "text" };
	    String[] titles = { getText("Code"), getText("Short_name_eng_key"), getText("Arabic_Brief_Name_key "),
		    getText("Category_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Code"), getText("Short_name_eng_key"), getText("Category_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    // grid.setUrl("/pathdesktop/productClassLookup_fillDealProductClassLookup?categoryCode="+
	    // productClassSC.getCategoryCode());
	    grid.setUrl("/pathdesktop/productClassLookup_fillDealProductClassLookup");

	    lookup(grid, productClassSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillDealProductClassLookup()
    {
	try
	{
	    setSearchFilter(productClassSC);
	    copyproperties(productClassSC);
	    SessionCO sessionCO = returnSessionObject();
	    productClassSC.setCompCode(sessionCO.getCompanyCode());
	    productClassSC.setBranchCode(sessionCO.getBranchCode());
	    productClassSC.setAppName(sessionCO.getCurrentAppName());
	    productClassSC.setUserId(sessionCO.getUserName());
	    if(NumberUtil.isEmptyDecimal(productClassSC.getCifNo()))
	    {
		productClassSC.setCifNo(BigDecimal.ZERO);
	    }
	    if(checkNbRec(productClassSC))
	    {
		setRecords(productClassBO.dealProductClassesListCount(productClassSC));
	    }
	    lstProductClasses = productClassBO.dealProductClassesList(productClassSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(lstProductClasses);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillDealProductClassLookup of ProductClassLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    
    /**
     * TP 556854/729361
     * 
     * 
     * @return
     */
    public String constructLookupInFms()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CATEGORY", "CODE", "BRIEF_NAME_ENG" };
	    String[] colType = { "number", "number", "text" };
	    String[] titles = { getText("Category_key"), getText("code_key"), getText("Short_name_eng_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/productClassLookup_fillProductClassLookupInFms");

	    List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
	    for(int i = 0; i < name.length; i++)
	    {
		if("CATEGORY".equals(columnSpecs.get(i).getName()))
		{
		    columnSpecs.get(i).setLeadZeros("2");
		}

		if("CODE".equals(columnSpecs.get(i).getName()))
		{
		    columnSpecs.get(i).setLeadZeros("4");
		}
	    }
	    lookup(grid, columnSpecs, null, productClassSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    @SuppressWarnings("unchecked")
    public String fillProductClassLookupInFms()
    {
	try
	{
	    setSearchFilter(productClassSC);
	    copyproperties(productClassSC);
	    SessionCO sessionCO = returnSessionObject();
	    productClassSC.setCompCode(sessionCO.getCompanyCode());
	    productClassSC.setPreferredLanguage(sessionCO.getLanguage());

	    if(checkNbRec(productClassSC))
	    {
		setRecords(productClassBO.productClassesListCountInFms(productClassSC));
	    }
	    lstProductClasses = productClassBO.productClassesListInFms(productClassSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(lstProductClasses);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of fillProductClassLookupInFms");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    // TP#178297; Arun.R.Variyath; 25/06/2014- Start
    /**
     * @author ARUN.VARIYATH Construct the product class lookup grid for PROV
     * @return
     */
    public String constructProductClassWithoutApp()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "DESC_ENG" };
	    String[] colType = { "number", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Short_name_eng_key"), getText("Arabic_Brief_Name_key "),
		    getText("Category_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Short_name_eng_key"), getText("Category_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/productClassLookup_fillProductClassLookupWithoutApp");
	    lookup(grid, productClassSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    @SuppressWarnings("unchecked")
    // @author ARUN.VARIYATH
    public String fillProductClassLookupWithoutApp()
    {
	try
	{
	    setSearchFilter(productClassSC);
	    copyproperties(productClassSC);
	    SessionCO sessionCO = returnSessionObject();
	    productClassSC.setCompCode(sessionCO.getCompanyCode());
	    if(productClassSC.getCifNo() == null)
	    {
		productClassSC.setCifNo(BigDecimal.ZERO);
	    }

	    if(checkNbRec(productClassSC))
	    {
		setRecords(productClassBO.productClassesListCountWithoutApp(productClassSC));
	    }
	    lstProductClasses = productClassBO.productClassesListWithoutApp(productClassSC);
	    setGridModel(lstProductClasses);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of Product Class Lookup Action");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    // TP#178297; Arun.R.Variyath; 25/06/2014- End

    // TP#738547 khalid; 17/10/2018- Start
    public String constructProductClassLookupFmsParam()
    {
	try
	{
	    // // Design the Grid by defining the column model and column names
	    String[] name = { "DESC_ENG", "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB" };
	    String[] colType = { "text", "number", "text", "text" };
	    String[] titles = { getText("Category_key"), getText("Code_key"), getText("Short_name_eng_key"),
		    getText("Arabic_Brief_Name_key ") };

	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "DESC_ENG", "CODE", "BRIEF_NAME_ENG" };
		colType = new String[] { "text", "number", "text" };
		titles = new String[] { getText("Category_key"), getText("Code_key"), getText("Short_name_eng_key") };

	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    // grid.setCaption(getText("cifList_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/productClassLookup_fillProductClassLookupFmsParam");
	    lookup(grid, productClassSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    // @SuppressWarnings("unchecked")
    public String fillProductClassLookupFmsParam()
    {
	try
	{
	    setSearchFilter(productClassSC);
	    copyproperties(productClassSC);
	    SessionCO sessionCO = returnSessionObject();
	    productClassSC.setCompCode(sessionCO.getCompanyCode());
	    productClassSC.setAppName(sessionCO.getCurrentAppName());

	    if(checkNbRec(productClassSC))
	    {
		setRecords(productClassBO.productClassLookupFmsParamCount(productClassSC));
	    }
	    lstProductClasses = productClassBO.productClassLookupFmsParamList(productClassSC);

	    setGridModel(lstProductClasses);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of Product Class Lookup Action");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    // TP#738547 khalid; 17/10/2018- END

    public BigDecimal getProductClassId()
    {
	return productClassId;
    }

    public void setProductClassId(BigDecimal productClassId)
    {
	this.productClassId = productClassId;
    }
}
