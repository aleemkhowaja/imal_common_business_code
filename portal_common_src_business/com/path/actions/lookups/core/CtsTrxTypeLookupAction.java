
package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.bo.core.trxtype.TrxTypeBO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.trxtype.TrxTypeSC;

public class CtsTrxTypeLookupAction extends LookupBaseAction {
	 
    private List<CTSTRXTYPEVO> trxVOList;
    private TrxTypeSC criteria = new TrxTypeSC();
    private TrxTypeBO trxTypeBO;
    private String trxTypeGridUrl;
    private String fromWhere;

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
	    String[] name = {"CODE",
		    "SHORT_DESC_ENG",
		    "LONG_DESC_ENG",
		    "SHORT_DESC_ARAB",
		    "LONG_DESC_ARAB",
	    "REFERENCE"};
	    String[] colType = { "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"),getText("Long_Desc_Arab_key"), getText("_Reference_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CODE",
        			    "SHORT_DESC_ENG",
        			    "LONG_DESC_ENG",
        		    		"REFERENCE"};
		colType = new String[] { "text", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
			                getText("_Reference_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Trx_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsTrxTypeLookup_fillTrxTypeLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    public String constructMCELookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"CODE",
		    "SHORT_DESC_ENG",
		    "LONG_DESC_ENG",
		    "SHORT_DESC_ARAB",
		    "LONG_DESC_ARAB",
	    "REFERENCE"};
	    String[] colType = { "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"),getText("Long_Desc_Arab_key"), getText("_Reference_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CODE",
			    "SHORT_DESC_ENG",
			    "LONG_DESC_ENG",
		    		"REFERENCE"};
		colType = new String[] { "text", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
			                getText("_Reference_key")};
	    }
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Trx_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsTrxTypeLookup_fillTrxTypeMCELookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    public String constructBulkRemitLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"CODE", "SHORT_DESC_ENG", "LONG_DESC_ENG", "SHORT_DESC_ARAB", "LONG_DESC_ARAB", "REFERENCE"};
	    String[] colType = { "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    		getText("Brief_Desc_Arab_key"),getText("Long_Desc_Arab_key"), getText("_Reference_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CODE", "SHORT_DESC_ENG", "LONG_DESC_ENG", "REFERENCE"};
		colType = new String[] { "text", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"), getText("_Reference_key")};
	    }
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Trx_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsTrxTypeLookup_fillTrxTypeBulkRemitLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    /**
     * the transaction type lookup in transaction screen 
     * has been manage in a specific function because in transaction screen 
     * we have the opts group management which not exists in all other transaction type lookups 
     * @author marwanmaddah
     * @date   Dec 13, 2012
     * @return String
     *
     */
    public String constructLookupFromTrx()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"CODE",
		    "SHORT_DESC_ENG",
		    "LONG_DESC_ENG",
		    "SHORT_DESC_ARAB",
		    "LONG_DESC_ARAB",
	    "REFERENCE"};
	    String[] colType = { "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"),getText("Long_Desc_Arab_key"), getText("_Reference_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CODE",
            			    "SHORT_DESC_ENG",
            			    "LONG_DESC_ENG",
            		    	    "REFERENCE"};
		colType = new String[] { "text", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
			               getText("_Reference_key")};
	    }
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Trx_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsTrxTypeLookup_fillTrxTypeLookupFromTrx");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    /**
     * Construct the lookup grid with specified url 
     * @param url
     * @throws BaseException 
     */
    private void constructLookupGrid(String url) throws BaseException
    {
	// Design the Grid by defining the column model and column names
	String[] name = { "CODE", "SHORT_DESC_ENG", "LONG_DESC_ENG", "SHORT_DESC_ARAB", "LONG_DESC_ARAB" };
	String[] colType = { "number", "text", "text", "text", "text" };
	String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };

	/* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	if(returnSessionObject().getHideArabicColumns())
	{
	    name = new String[] { "CODE", "SHORT_DESC_ENG", "LONG_DESC_ENG" };
	    colType = new String[] { "number", "text", "text" };
	    titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") };
	}

	// Defining the Grid
	LookupGrid grid = new LookupGrid();
	grid.setCaption(getText("Trx_Type_key"));
	grid.setRowNum("5");
	grid.setUrl(url);
	lookup(grid, criteria, name, colType, titles);
    }
    
    /**
     * This method is to fill the transaction type in Transaciton Trends popup
     * @return String 
     */
    public String constructTransactionTypeForTransactionTrends(){
	try
	{	    
	    String url = "/pathdesktop/CtsTrxTypeLookup_fillTrxTypeLookup";
	    constructLookupGrid(url);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructTransactionTypeForTransactionTrends of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    /**
     * This method is to fill the transaction type in Limit Schema popup
     * @return String 
     */
    public String constructTransactionTypeForLimitSchema(){
	try
	{	    
	    String url = "/pathdesktop/CtsTrxTypeLookup_fillLimitSchemaTrxTypeLookup";
	    constructLookupGrid(url);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructTransactionTypeForTransactionTrends of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    public String constructTransactionTypeForTrxTypeLimitCharges(){
	try
	{	    
	    String url = "/pathdesktop/CtsTrxTypeLookup_fillTrxTypeForTrxTypeLimitChargesLookup";
	    constructLookupGrid(url);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructTransactionTypeForTrxTypeLimitCharges of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    public String fillTrxTypeForTrxTypeLimitChargesLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setStatus("S");
	    criteria.setType("Z");

	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.trxTypeForTransactionTrendsListCount(criteria));
	    }
	    trxVOList = trxTypeBO.trxTypeForTransactionTrendsList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trxVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillTrxTypeForTransactionTrendsLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }



    /**
     * Fill the lookup TrxType data for the Transaction trends popup filtered by the defined criteria
     * 
     * @return String
     */
    public String fillTrxTypeForTransactionTrendsLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.trxTypeForTransactionTrendsListCount(criteria));
	    }
	    trxVOList = trxTypeBO.trxTypeForTransactionTrendsList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trxVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillTrxTypeForTransactionTrendsLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup TrxType data filtered by the defined criteria
     * 
     * @return
     */
    public String fillTrxTypeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setStatus("P");
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.trxTypeListCount(criteria));
	    }
	    trxVOList = trxTypeBO.trxTypeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trxVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillTrxTypeLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    /**
     * 
     * @author marwanmaddah
     * @date   Dec 13, 2012
     * @return
     *
     */
    public String fillTrxTypeLookupFromTrx()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setStatus("P");
	    List<String> allOptsLst = TrxMgntConstant.allOptsList;
	    String originProgRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
	    /**
	     * in case the pageRef is include in the pre defined opts
	     */
	 /*   String targetProgRef="";
	    if(sessionCO.getOriginalAppName() != null && !"".equals(sessionCO.getOriginalAppName()))
	    {
		String[] arr = returnCommonLibBO().returnOptDetailsList(sessionCO.getOriginalAppName(), get_pageRef());
		if(arr[6] != null)
		{
		    targetProgRef = arr[6];
		}
	    }*///alternative solution for 808406-hussein el hajj
	    
	    if(allOptsLst.contains(get_pageRef()) || TrxMgntConstant.OPT_SCANCHEQUEMT.equals(get_pageRef()) || 
	       "F00I1".equals(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef()).subSequence(0, 5)) ||
	       "T001MT".equals(get_pageRef()) )
	    {
		criteria.setReference("D001");
		criteria.setIsDyOpt("false");
		if(TrxMgntConstant.OPT_SCANCHEQUEMT.equals(originProgRef))
		{
		    criteria.setChqRelated("'"+TrxMgntConstant.CLEARING_CHEQUE+"'");
		}
	    }
	    /**
	     * in case of dynamic OPTs
	     */
	    else
	    {
		criteria.setReference(get_pageRef(). substring(0,get_pageRef().length()-2));
		criteria.setIsDyOpt("true");
	    }
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.trxTypeListCount(criteria));
	    }
	    trxVOList = trxTypeBO.trxTypeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trxVOList);
	    
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillTrxTypeLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Fill the lookup TrxType data filtered by the defined criteria
     * 
     * @return
     */
    public String fillTrxTypeMCELookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setStatus("P");
	    criteria.setChqRelated("'"+TrxMgntConstant.CLEARING_CHEQUE+"', '"+TrxMgntConstant.HOUSE_CHEQUE+"'");
	    
	    /** Habib Baalbaki accocunt restriction 372747
	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.trxTypeMCEListCount(criteria));
	    }
	    trxVOList = trxTypeBO.trxTypeMCEList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trxVOList);
	    */
	    
	  //Habib Baalbaki accocunt restriction 372747
	    String originalProgRef = StringUtil.nullEmptyToValue(returnCommonLibBO().returnOrginProgRef(
		    sessionCO.getCurrentAppName(), get_pageRef()), get_pageRef());
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    criteria.setPageRef(originalProgRef);
	    criteria.setUserId(sessionCO.getUserName());
	    
	    criteria.setCheckNbRec(checkNbRec(criteria));
	    criteria = trxTypeBO.returnTrxTypeMCEList(criteria);
	    if(criteria.isCheckNbRec())
	    {
		setRecords(criteria.getNbRecords());
	    }
	    setGridModel(criteria.getListRecords());
	    
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillTrxTypeLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String fillTrxTypeBulkRemitLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    if(!NumberUtil.isEmptyDecimal(criteria.getBulkRemittanceType())
		    && StringUtil.isNotEmpty(criteria.getTrsfrMethod()))
	    {
		SessionCO sessionCO = returnSessionObject();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setUserId(sessionCO.getUserName());
		criteria.setStatus(TrxMgntConstant.APPROVED_TRX);
		criteria.setTrsType(TrxMgntConstant.TRANSFER);

//		if(TrxMgntConstant.ISSUE_MULTIPLE_INSTRUMENTS_THROUGH_ONE_DEBIT.compareTo(criteria.getBulkRemittanceType()) == 0 //1
//			|| TrxMgntConstant.DEPOSITING_MULTIPLE_INSTRUMENTS_IN_ONE_ACCOUNT.compareTo(criteria.getBulkRemittanceType()) == 0) //4
//		{
		    criteria.setMultiTrx(TrxMgntConstant.SINGLE_TRX);
//		}
//		else
//		{
//		    criteria.setMultiTrx(TrxMgntConstant.MULTI_TRX);
//		}
		if(/*TrxMgntConstant.ISSUE_ONE_INSTRUMENT_THROUGH_MULTI_DEBITS.compareTo(criteria.getBulkRemittanceType()) == 0 //2
			||*/ TrxMgntConstant.DEPOSITING_MULTIPLE_INSTRUMENTS_IN_ONE_ACCOUNT.compareTo(criteria.getBulkRemittanceType()) == 0) //4
		{
		    criteria.setCrDrForex(TrxMgntConstant.MAIN_ACC_CR);
		}
		else
		{
		    criteria.setCrDrForex(TrxMgntConstant.MAIN_ACC_DR);
		}
		if(/*TrxMgntConstant.DEPOSITING_ONE_INSTRUMENT_IN_MULTIPLE_ACCOUNTS.compareTo(criteria.getBulkRemittanceType()) == 0 //3
			||*/ TrxMgntConstant.DEPOSITING_MULTIPLE_INSTRUMENTS_IN_ONE_ACCOUNT.compareTo(criteria.getBulkRemittanceType()) == 0) //4
		{
		    criteria.setLinkToOtherTrx("1");
		}
		else
		{
		    criteria.setLinkToOtherTrx("0");
		}
		
		if(checkNbRec(criteria))
		{
		    setRecords(trxTypeBO.trxTypeBulkRemitListCount(criteria));
		}
		trxVOList = trxTypeBO.trxTypeBulkRemitList(criteria);
		// set the collection into gridModel attribute defined at JSP grid
		setGridModel(trxVOList);
	    }
	    
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillTrxTypeLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Fill the lookup TrxType data filtered by the defined criteria
     * 
     * @return
     */
    public String fillLimitSchemaTrxTypeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    if(criteria.getRecToskip() == 0)
	    {
		criteria.setNbRec(criteria.getNbRec()-1);
	    }
	    else
	    {
		criteria.setRecToskip(criteria.getRecToskip()-1);
	    }
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setStatus("P");
	    
	    if(checkNbRec(criteria))
	    {
		int trxTypeListCount = trxTypeBO.trxTypeListCount(criteria);
		if(trxTypeListCount > 0)
		{
		    trxTypeListCount++;
		}
		setRecords(trxTypeListCount);
	    }
	    trxVOList = trxTypeBO.trxTypeList(criteria);
	    if(criteria.getRecToskip() == 0 && null != trxVOList && !trxVOList.isEmpty()){
		CTSTRXTYPEVO aCTSTRXTYPEVO = new CTSTRXTYPEVO();
		aCTSTRXTYPEVO.setCODE(BigDecimal.ZERO);
		String desc = getText("All_types_key");
		aCTSTRXTYPEVO.setSHORT_DESC_ENG(desc);
		aCTSTRXTYPEVO.setLONG_DESC_ENG(desc);
		aCTSTRXTYPEVO.setSHORT_DESC_ARAB(desc);
		aCTSTRXTYPEVO.setLONG_DESC_ARAB(desc);
		trxVOList.add(0, aCTSTRXTYPEVO);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trxVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillTrxTypeLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String constructCardsTrxTypeLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"CODE",
                         "SHORT_DESC_ENG",
                         "LONG_DESC_ENG",
                         "SHORT_DESC_ARAB",
                         "LONG_DESC_ARAB",
                         "REFERENCE"};
	    String[] colType = { "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
	    		getText("Brief_Desc_Arab_key"),getText("Long_Desc_Arab_key"), getText("_Reference_key")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Cards_Trx_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsTrxTypeLookup_fillCardsTrxTypeLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CardsTrxTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup CardsTrxType data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCardsTrxTypeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.cardsTrxTypeListCount(criteria));
	    }
	    trxVOList = trxTypeBO.cardsTrxTypeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trxVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCardsTrxTypeLookup of CardsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String constructHoldTrxTypeLookup()
    {
	try
	{	   
	    String url = "/pathdesktop/CtsTrxTypeLookup_fillHoldTrxTypeLookup";
	    constructLookupGrid(url);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructHoldTrxTypeLookup of TrxTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup HoldTrxType data filtered by the defined criteria
     * 
     * @return
     */
    public String fillHoldTrxTypeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.holdTrxTypeListCount(criteria));
	    }
	    trxVOList = trxTypeBO.holdTrxTypeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trxVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillHoldTrxTypeLookup of TrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String constructCloseTrsfrTrxTypeLookup()
    {
	try
	{	   
	    String url = "/pathdesktop/CtsTrxTypeLookup_fillCloseTrsfrTrxTypeLookup";
	    constructLookupGrid(url);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructCloseTrsfrTrxTypeLookup of TrxTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup CloseTrsfr TrxType data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCloseTrsfrTrxTypeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setType("X");
	    criteria.setChequeFlag("N");
	    criteria.setTrsfr(BigDecimal.ZERO);
	    criteria.setNostro("2");
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.closeTransferTrxTypeListCount(criteria));
	    }
	    trxVOList = trxTypeBO.closeTransferTrxTypeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trxVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCloseTrsfrTrxTypeLookup of TrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String constructTransactionTypeForTransferCash()
    {
	try
	{ 
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Trx_Type_key"));
	    grid.setRowNum("5");
	    String url = "/pathdesktop/CtsTrxTypeLookup_fillTrxTypeForTransferCashLookup";
	    constructLookupGrid(url);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructTransactionTypeForTransferCash of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    public String fillTrxTypeForTransferCashLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setType("T");
	    criteria.setChequeFlag("N");
	    criteria.setTrsfr(BigDecimal.ONE);
	    criteria.setNostro("1");
	    criteria.setMultiTrx("0");
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setFolderType("T");
	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.trxTypeForTransferCashListCount(criteria));
	    }
	    trxVOList = trxTypeBO.trxTypeForTransferCashList(criteria);

	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trxVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillTrxTypeForTransactionTrendsLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String constructTrxTypeForCurrencyExchange()
    {
	try
	{ 
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Trx_Type_key"));
	    grid.setRowNum("5");
	    String url = "/pathdesktop/CtsTrxTypeLookup_fillTrxTypeForCurrencyExchangeLookup";
	    constructLookupGrid(url);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructTrxTypeForCurrencyExchange of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    public String fillTrxTypeForCurrencyExchangeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setType("T");
	    criteria.setTrsfr(BigDecimal.ONE);
	    criteria.setNostro("1");
	    criteria.setMultiTrx("0");
	    criteria.setStandingOrder("0");
	    criteria.setChqRelated("N");
	    criteria.setStatus("P");
	    criteria.setCyExch("1");
	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.trxTypeForCurrencyExchangeListCount(criteria));
	    }
	    trxVOList = trxTypeBO.trxTypeForCurrencyExchangeList(criteria);

	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trxVOList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillTrxTypeForCurrencyExchangeLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    /***
     * Method for constructing the TRX type lookup for fixed maturity accounts - dddw_import_trxtype - AccountsInstructionsTab.jsp
     * @return
     */
    public String constructTrxLookupForFma()
    {
		try
		{	    
		    // Design the Grid by defining the column model and column names
		    String[] name = {"CODE",
			    "SHORT_DESC_ENG",
			    "LONG_DESC_ENG",
			    "SHORT_DESC_ARAB",
			    "LONG_DESC_ARAB",
		    "REMITT_TYPE"};
		    String[] colType = { "number", "text", "text", "text", "text", "number"};
		    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
			    getText("Brief_Desc_Arab_key"),getText("Long_Desc_Arab_key"), getText("Remittance_Type_key")};
		    
		    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
		       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
			, 3= Arabic Visible and Mandatory English Not Mandatory). */
		    if(returnSessionObject().getHideArabicColumns())
		    {
			name = new String[] {"CODE",
        				    "SHORT_DESC_ENG",
        				    "LONG_DESC_ENG",
        			    	    "REMITT_TYPE"};
			colType = new String[] { "number", "text", "text", "number"};
			titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
				                 getText("Remittance_Type_key")};
		    }
	
		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Trx_Type_key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/CtsTrxTypeLookup_fillTrxLookupForFma?fromWhere="+fromWhere);
		    lookup(grid, criteria, name, colType, titles);
		}
		catch(Exception e)
		{
		    log.error(e, "Error in constructLookup of CtsTrxTypeLookupAction");
		    handleException(e, null, null);
		}
		return SUCCESS;
    }

    public String fillTrxLookupForFma() 
    {
		try
		{
		    setSearchFilter(criteria);
		    copyproperties(criteria);
		    SessionCO sessionCO = returnSessionObject();
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    criteria.setUserId(sessionCO.getUserName());
		    criteria.setType("T");
		    criteria.setChequeFlag("N");
		    criteria.setTrsfr(BigDecimal.ONE);
		    criteria.setNostro("2");
		    criteria.setMultiTrx("0");
		    criteria.setFolderType("F");
		    criteria.setReference(fromWhere);
		    if(checkNbRec(criteria))
		    {
			setRecords(trxTypeBO.getTrxTypeForFmaListCount(criteria));
		    }
		    trxVOList = trxTypeBO.getTrxTypeForFmaList(criteria);
		    // set the collection into gridModel attribute defined at JSP grid
		    setGridModel(trxVOList);
		
		}
		catch(Exception e)
		{
		    log.error(e, "Error in fillHoldTrxTypeLookup of TrxTypeLookupAction");
		    handleException(e, null, null);
		}
		return SUCCESS;
    }
    

    /**
     * Set the trx type Grid URL and load the trx type Jsp Page...
     * 
     * @return
     */
    public String constructTrxTypeGrid()
    {
	try
	{
	    ServletContext application = ServletActionContext.getServletContext();
	    String theRealPath = application.getContextPath();
	    String originOptRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(returnSessionObject().getCurrentAppName(), get_pageRef());
	    }
	    trxTypeGridUrl = theRealPath + "/pathdesktop/CtsTrxTypeLookup_loadCtsTrxTypeGrid?_pageRef="+originOptRef;
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "trxTypeGrid";
    }
    
    /**
     * get data from Database, convert them to be compatible with CTSTRXTYPEVO, get
     * HTML and set the Model.
     * 
     * @return
     */
    public String loadCtsTrxTypeGrid()
    {
	String[] searchCol = {"CODE", "SHORT_DESC_ENG", "LONG_DESC_ENG", "SHORT_DESC_ARAB", "LONG_DESC_ARAB", "REFERENCE"};
	try
	{
	    criteria.setSearchCols(searchCol);
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setType("T");
	    criteria.setChequeFlag("N");
	    criteria.setTrsfr(BigDecimal.ONE);
	    criteria.setNostro("2");
	    criteria.setMultiTrx("0");
	    criteria.setUserId(sessionCO.getUserName());
	    // The folder type is set to -1 so the method returnCodeForTrxTypeList in trxTypeBO doesn't return any value then
	    // we get the records from trxTypeLookupForTransferCashCount
	    criteria.setFolderType("-1");
	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.trxTypeForTransferCashListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel( trxTypeBO.trxTypeForTransferCashList(criteria));
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    
    
    
    /**
     * @author EliasAoun 19/03/2014
     * @PB w_lookup_trxtype
     * @Modif REGAUT ; TP : #153655
     * @return
     */
    public String constructTrxTypeForAutoPayLkp()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
		String[] columnArr[] = { { "CODE", "number", getText("Code__key") },
			{ "SHORT_DESC_ENG", "text", getText("Brief_Name_key") },
			{ "LONG_DESC_ENG", "text", getText("Long_Name__key") },
			{ "TYPE", "text", getText("Base_Currency_key") },
			{ "STATUS", "text", getText("Remark_key") },
			{ "REFERENCE", "text", getText("Brief_Desc_Arab_key") },
			{ "SHORT_DESC_ARAB", "text", getText("Long_Desc_Arab_key") },
			{ "LONG_DESC_ARAB", "text", getText("Long_Desc_Arab_key") } 
			};
	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		columnArr = new String[][]{ { "CODE", "number", getText("Code__key") },
			{ "SHORT_DESC_ENG", "text", getText("Brief_Name_key") },
			{ "LONG_DESC_ENG", "text", getText("Long_Name__key") },
			{ "TYPE", "text", getText("Base_Currency_key") },
			{ "STATUS", "text", getText("Remark_key") },
			{ "REFERENCE", "text", getText("Brief_Desc_Arab_key") }
			};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Trx_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsTrxTypeLookup_fillTrxTypeForAutoPayLkp");
	    lookup(grid, criteria, columnArr);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String fillTrxTypeForAutoPayLkp()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setType("Z");
	    criteria.setStatus("S");
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeBO.trxTypeLookupForTrxTypeLimitChargesListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel( trxTypeBO.trxTypeLookupForTrxTypeLimitChargesList(criteria));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * @author Hasan 14/12/2016
     * @Modif TP#82867 BPI120091 -phase 2
     * @return
     */
    public String constructTrxTypeAccCharges()
    {
		try
		{
		    // Design the Grid by defining the column model and column names
			String[] columnArr[] = { { "CODE", "number", getText("Code__key") },
				{ "SHORT_DESC_ENG", "text", getText("Brief_Name_key") },
				{ "LONG_DESC_ENG", "text", getText("Long_Name__key") },
				{ "TYPE", "text", getText("Base_Currency_key") },
				{ "STATUS", "text", getText("Remark_key") },
				{ "REFERENCE", "text", getText("Brief_Desc_Arab_key") },
				{ "SHORT_DESC_ARAB", "text", getText("Long_Desc_Arab_key") },
				{ "LONG_DESC_ARAB", "text", getText("Long_Desc_Arab_key") } 
				};
			
		    if(returnSessionObject().getHideArabicColumns())
		    {
			columnArr = new String[][]{ { "CODE", "number", getText("Code__key") },
				{ "SHORT_DESC_ENG", "text", getText("Brief_Name_key") },
				{ "LONG_DESC_ENG", "text", getText("Long_Name__key") },
				{ "TYPE", "text", getText("Base_Currency_key") },
				{ "STATUS", "text", getText("Remark_key") },
				{ "REFERENCE", "text", getText("Brief_Desc_Arab_key") }
				};
		    }
	
		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("Trx_Type_key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/CtsTrxTypeLookup_fillTrxTypeAccCharges");
		    lookup(grid, criteria, columnArr);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
		return SUCCESS;
    }
    
    
    public String fillTrxTypeAccCharges()
    {
		try
		{
		    setSearchFilter(criteria);
		    copyproperties(criteria);
		    SessionCO sessionCO = returnSessionObject();
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    criteria.setUserId(sessionCO.getUserName());
		    criteria.setStatus("P");
		    
		    if(checkNbRec(criteria))
		    {
		    	setRecords(trxTypeBO.trxTypeLookupForAccChargesListCount(criteria));
		    }
		    // set the collection into gridModel attribute defined at JSP grid
		    setGridModel( trxTypeBO.trxTypeLookupForAccChargesList(criteria));
	
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
		return SUCCESS;
    }
    //Hasan EWBI160043 24/08/2016
    public String constructCertificateTrxTypeLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"CODE",
		    "SHORT_DESC_ENG",
		    "LONG_DESC_ENG",
		    "SHORT_DESC_ARAB",
		    "LONG_DESC_ARAB",
	    "REFERENCE"};
	    String[] colType = { "text", "text", "text", "text", "text", "text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"),getText("Long_Desc_Arab_key"), getText("_Reference_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CODE",
        			    "SHORT_DESC_ENG",
        			    "LONG_DESC_ENG",
        		    		"REFERENCE"};
		colType = new String[] { "text", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
			                getText("_Reference_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Trx_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsTrxTypeLookup_fillCertificateTrxTypeLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructCertificateTrxTypeLookup of CtsTrxTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    
    public TrxTypeSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(TrxTypeSC criteria)
    {
	this.criteria = criteria;
    }

    public void setTrxTypeBO(TrxTypeBO trxTypeBO)
    {
	this.trxTypeBO = trxTypeBO;
    }
    
    public String getTrxTypeGridUrl()
    {
        return trxTypeGridUrl;
    }

    public void setTrxTypeGridUrl(String trxTypeGridUrl)
    {
        this.trxTypeGridUrl = trxTypeGridUrl;
    }

    public String getFromWhere()
    {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere)
    {
        this.fromWhere = fromWhere;
    }
   
}
