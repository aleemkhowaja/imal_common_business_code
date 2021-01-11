/**
 * @author GhenoieSaab
 * @Date:June 6, 2012
 * @Team:JAVA Te am.
 * @copyright: PathSolution 2012
 */
package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.path.bo.core.billtype.BillTypeBO;
import com.path.dbmaps.vo.CTS_BILL_TYPEVO;
import com.path.dbmaps.vo.CTS_SERV_REGVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.billtype.BillTypeSC;

public class BillTypeLookupAction extends LookupBaseAction
{
    private List<CTS_BILL_TYPEVO> billTypeVOList;
    private BillTypeSC criteria = new BillTypeSC();
    private BillTypeBO billTypeBO;
    
    /**
     * 
     */
    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * @PB : w_lookup_registered_bill_type
     * Construct Bill Type Lookup based on the VO returned in the resultMap.
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "BILL_TYPE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB",
		    "ADDITIONAL_REFERENCE" };
	    String[] colType = { "number", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Bill_Type_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"), getText("additional_reference_key") };

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "BILL_TYPE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "ADDITIONAL_REFERENCE" };
		colType = new String[] { "number", "text", "text", "text" };
		titles = new String[] { getText("Bill_Type_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key"), getText("additional_reference_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Bill_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/BillTypeLookup_fillBillTypeLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of BillTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup Bill Type data filtered by the defined criteria
     * 
     * @return
     */
    public String fillBillTypeLookup()
    {
	try
	{
	    
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(getRecords() == 0)
	    {
		setRecords(billTypeBO.billTypeListCount(criteria));
	    }
	    billTypeVOList = billTypeBO.billTypeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(billTypeVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillBillTypeLookup of BillTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public BillTypeSC getCriteria()
    {
        return criteria;
    }
    public void setCriteria(BillTypeSC criteria)
    {
        this.criteria = criteria;
    }
    public void setBillTypeBO(BillTypeBO billTypeBO)
    {
        this.billTypeBO = billTypeBO;
    }
    
    public String constructAllBillTypeLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "BILL_TYPE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB",
		    "ADDITIONAL_REFERENCE" };
	    String[] colType = { "number", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Bill_Type_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"), getText("additional_reference_key") };
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "BILL_TYPE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "ADDITIONAL_REFERENCE" };
		colType = new String[] { "number", "text", "text", "text" };
		titles = new String[] { getText("Bill_Type_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key"), getText("additional_reference_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Bill_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/BillTypeLookup_fetchAllBillTypeLookup");
	    lookup(grid, criteria, name, colType, titles);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of BillTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    public String fetchAllBillTypeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    if(getRecords() == 0)
	    {
		setRecords(billTypeBO.billTypeListAllCount(criteria));
	    }
	    billTypeVOList = billTypeBO.billTypeListAll(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(billTypeVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fetchAllBillTypeLookup of BillTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * @author RaniaAlBitar
     * Bug #829901
     * @return
     */
    
    public String constructBillPaymentLookup()
    {
	try
	{
	    String[][] colsArr = { { "BILL_TYPE", "number", getText("Bill_Type_key") },
		    { "REFERENCE", "text", getText("Reference_key") },
		    { "NICKNAME", "text", getText("NICKNAME_key") } };

	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Bill_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/BillTypeLookup_fetchBillPaymentLookup");
	    lookup(grid, criteria, colsArr);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of BillTypeLookupAction constructBillPaymentLookup");
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    /**
     * @author RaniaAlBitar
     * Bug #829901
     * @return
     */
    
    public String fetchBillPaymentLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    criteria.setCompCode(returnSessionObject().getCompanyCode());

	    fillAdditionalParams();

	    if(getRecords() == 0)
	    {
		setRecords(billTypeBO.returnBillPaymentListCount(criteria));
	    }
	    List<CTS_SERV_REGVO> lst = billTypeBO.returnBillPaymentList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(lst);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fetchAllBillTypeLookup of BillTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * @author RaniaAlBitar
     * Bug #829901
     * @return
     */
    
    private void fillAdditionalParams()
    {
	if("2".equals(criteria.getShowSoRefLookup()))
	{
	    criteria.setCifNo(new BigDecimal(ServletActionContext.getRequest().getParameter("bankCif")));
	    criteria.setBillType(new BigDecimal(ServletActionContext.getRequest().getParameter("billType")));
	    criteria.setCyCode(new BigDecimal(ServletActionContext.getRequest().getParameter("trsCy")));
	    criteria.setAccCif(new BigDecimal(ServletActionContext.getRequest().getParameter("toTrsAcCif")));
	}
    }
}