
package com.path.actions.lookups.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.zxing.common.StringUtils;
import com.path.lib.common.util.StringUtil;
import com.path.bo.common.global360view.cards.CardsBO;
import com.path.bo.core.cardtype.CardTypeBO;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.dbmaps.vo.CTSCARDS_MGTVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cardsmanagement.CardsManagementSC;

public class CardsMgtLookupAction extends LookupBaseAction
{
    private CardsManagementSC criteria = new CardsManagementSC();
    private CardTypeBO cardTypeBO;
    private CardsBO cardsBO;
    
    /**
     * 
     */
    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * Construct Card Type Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */
    public String constructLookup()
    {
	try
	{	    
		// Design the Grid by defining the column model and column names
	    String[] name    = {"CARD_NO","REFERENCE","APPLICATION_ID","APP_REF","CIF","BRANCH_CODE","STATUS"};
	    String[] colType = {"text", "text", "number", "number","number","number", "text"};
	    String[] titles  = {getText("Card_No_key") ,getText("Card_No_key"), getText("Application_Id_key"), getText("Application_Reference_key"),getText("CIF_key"), getText("branchKey"), getText("Status_key")};

	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    if(name != null && colType != null && titles != null && name.length == colType.length
		    && colType.length == titles.length)
	    {
		int cols = name.length;
		for(int i = 0; i < cols; i++)
		{
		    // check if . character available in the name, since index
		    // cannot have . in it.
		    // Defining each column
		    LookupGridColumn gridColumn = new LookupGridColumn();
		    gridColumn.setName(name[i]);
		    if(i == 0)
		    {
			gridColumn.setIndex(name[1]);
		    }
		    else
		    {
			gridColumn.setIndex(name[i]);
		    }
		    gridColumn.setColType(colType[i]);
		    gridColumn.setTitle(titles[i]);
		    gridColumn.setSearch(true);
		    // adding column to the list
		    lsGridColumn.add(gridColumn);
		}
	    }
	    else
	    {
		throw new BaseException("Incorrect List Specification for Columns to Return Standard Specification");
	    }
	    
	    for(int i = 0; i < name.length; i++)
	    {
		if("CARD_NO".equals(lsGridColumn.get(i).getName()))
		{
			lsGridColumn.get(i).setHidden(true);
		}
	    }
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Card_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CardMgtLookup_fillCardMgtLookup");
	    lookup(grid, lsGridColumn, null, criteria);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillCardMgtLookup()
    {
	try
	{
	    List<CTSCARDS_MGTVO> ctsCardsMgtVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setMaskedCardNo(sessionCO.getCtsTellerVO().getMASK_CARD_NO());
	    //RakanMakarem -BUG#678236
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setUserId(sessionCO.getUserName());//Hasan Bug#457443 10/04/2017
	    criteria.setLovTypeStatus(CoreCommonConstants.CARDS_MANAGEMENT_STATUS_LOV_TYPE);
//	    criteria.setCif(new BigDecimal(1));
//	    criteria.setCardType(new BigDecimal(1));
//	    criteria.setSameType("1");
//	    criteria.setType("D");

	    if(getRecords() == 0)
	    {
		setRecords(cardTypeBO.cardMgtListCount(criteria));
	    }
	    ctsCardsMgtVOList = cardTypeBO.cardMgtList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(ctsCardsMgtVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of CardsMgtLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     *  BB140052
     * 
     * @author Sarah Elhusseini
     * Construct Card Management Lookup
     * 
     * @return
     */
    public String constructCardsMgntLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name    = { "maskedCardNo","cardsMgtVO.CARD_NO", 	        "cardsMgtVO.CARD_TYPE",      "ctsCardsVO.BRIEF_NAME_ENG",
		    	         "cardsMgtVO.APPLICATION_ID",   "cardsMgtVO.APP_REF",        "cardsMgtVO.BRANCH_CODE",
		    	         "cardsMgtVO.CARD_HOLDER_NAME", "branchesVO.BRIEF_DESC_ENG", "cardsMgtVO.DEST_BRANCH",
		    	         "cardsMgtVO.CIF",	        "cifVO.SHORT_NAME_ENG", "cardsMgtVO.STATUS",
		    	         "cardsMgtVO.CIF_STATUS",       "cardsMgtVO.PRIM_SUPP",      "cardsAccountCO.accountVO.ACC_BR",
		    	         "cardsAccountCO.accountVO.ACC_CY", 	        "cardsAccountCO.accountVO.ACC_GL",         "cardsAccountCO.accountVO.ACC_CIF",
		    	         "cardsAccountCO.accountVO.ACC_SL", 	        "cardsAccountCO.accountVO.ACC_ADD_REF",    "amfVO.IBAN_ACC_NO" };

	    String[] colType = { "text", "text",   "number", "text",
		    		 "number", "number", "number",
		    		 "text",   "text",   "number",
		    		 "number", "text",   "text",
		    		 "text",   "text",   "number",
		    		 "number", "number", "number",
		    		 "number", "text",    "text" };

	    String[] titles  = { getText("Card_No_key"), getText("Card_No_key"),          getText("Card_Type_key"), 	        getText("Card_Name_key"),
		    		 getText("Application_Id_key"),   getText("Application_Reference_key"), getText("branchKey"),
		    		 getText("Card_Holder_Name_key"), getText("Branch_Name_key"), 	        getText("destination_branch_key"),
		    		 getText("CIF_key"), 		  getText("CIF_Name_key"), 	        getText("Status_key"),
		    		 getText("CIF_Status_key"),       getText("Primary_Supplementary_key"), getText("Branch_key"),
		    		 getText("Currency_key"),         getText("GL_key"), 		        getText("CIF_key"),	
		    		 getText("SL_key"), 		  getText("Additional_Reference_key"),  getText("IBAN_Account_Number_key") };
	    
	    
	//    List<LookupGridColumn> listGridColumn = returnStandarColSpecs(name, colType, titles);
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    if(name != null && colType != null && titles != null && name.length == colType.length
	    		&& colType.length == titles.length)
    	{
    	    int cols = name.length;
    	    for(int i = 0; i < cols; i++)
    	    {
    		// check if . character available in the name, since index
    		// cannot have . in it.
    		// Defining each column
    		LookupGridColumn gridColumn = new LookupGridColumn();
    		gridColumn.setName(name[i]);
    		if(i == 0)
    		{
    			gridColumn.setIndex(name[1]);
    		}
    		else
    		{
    			gridColumn.setIndex(name[i]);
    		}
    		gridColumn.setColType(colType[i]);
    		gridColumn.setTitle(titles[i]);
    		gridColumn.setSearch(true);
    		// adding column to the list
    		lsGridColumn.add(gridColumn);
    	    }
    	}
    	else
    	{
    	    throw new BaseException("Incorrect List Specification for Columns to Return Standard Specification");
    	}

	  //795158 BB-S10 Activating other branch cards[falha]
	    for(int i = 0; i < name.length; i++)
	    {
		if( "G001BA".equals(get_pageRef()))
		{
		    if("maskedCardNo".equals(lsGridColumn.get(i).getName()))
		{
			lsGridColumn.get(i).setHidden(true);
		} 
		}
		else
		{  
		    
			if("cardsMgtVO.CARD_NO".equals(lsGridColumn.get(i).getName()))
		{
			lsGridColumn.get(i).setHidden(true);
		}
		}
		
	    }
	  //795158 BB-S10 Activating other branch cards[falha]
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CardMgtLookup_fillCardManagementtLookup");
	    lookup(grid, lsGridColumn, null, criteria);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
 
    /**
     * BB140052 Construct Card Management Lookup based to be opened in
     * transaction screen
     * 
     * @author Sarah ElHusseini
     * 
     * @return
     */
    public String fillCardManagementtLookup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    /*Begin - #459982 - Error message generated when trying to define Card No manually.*/
	    String mask = criteria.getMaskedCardNo();
//	    Boolean maskFilter = false;
	    if(com.path.lib.common.util.StringUtil.isNotEmpty(criteria.getColSearchQuery()))
	    {
		if(criteria.getColSearchQuery().contains("maskedCardNo"))
		{
//		    maskFilter = true;
//		    TP 641484 no search will be applicable on card no in case mask card no is checked
		    if("1".equals(sessionCO.getCtsTellerVO().getMASK_CARD_NO()))
		    {
			criteria.setColSearchQuery(criteria.getColSearchQuery().replaceAll("maskedCardNo", "'"+mask+"'"));
		    }
		}
	    }
	    /*End - #459982 - Error message generated when trying to define Card No manually.*/
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setMaskedCardNo(sessionCO.getCtsTellerVO().getMASK_CARD_NO());
	    criteria.setSysDate(sessionCO.getRunningDateRET());
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setLovTypeStatus(CoreCommonConstants.CARDS_MANAGEMENT_STATUS_LOV_TYPE);
	    criteria.setLovTypeCifStatus(CoreCommonConstants.CARDS_MANAGEMENT_CIF_STATUS_LOV_TYPE);
	    criteria.setLovTypePrimSupp(CoreCommonConstants.CARDS_MANAGEMENT_PRIMSUPP_LOV_TYPE);
	    criteria.setIsSybase(returnCommonLibBO().returnIsSybase());
	    criteria.setUserId(sessionCO.getUserName());

	  //795158 BB-S10 Activating other branch cards[falha]
	    if("G001BA".equals(get_pageRef()))
	    {
		criteria.setProgRef(get_pageRef());
	    }
	  //795158 BB-S10 Activating other branch cards[falha]
	    if(getRecords() == 0)
	    {
	    	int cntRecords=cardsBO.cardsManagementListCount(criteria);
	    	setRecords(cntRecords);
//	    	if(maskFilter)
//	  	    {
//	    		criteria.setNbRec(cntRecords);
//	  	    }
	    }
	    List<CardsManagementCO> cardsMgmtList = cardsBO.cardsManagementList(criteria);
//	    /*Begin - #459982 - Error message generated when trying to define Card No manually.*/
//	    if(maskFilter)
//	    {
//	    	List<Object> cardsToRemove = new ArrayList<Object>();
//	    	for(Object a: cardsMgmtList){
//	    	    if(!StringUtil.nullToEmpty(((CardsManagementCO) a).getMaskedCardNo()).contains(mask)){
//	    	    	cardsToRemove.add(a);
//	    	    }
//	    	}
//	    	cardsMgmtList.removeAll(cardsToRemove);
//		//cardsMgmtList.removeIf(s -> !s.getMaskedCardNo().contains(mask));
//	    }
//	    /*End - #459982 - Error message generated when trying to define Card No manually.*/
	    setGridModel(cardsMgmtList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData in CardsMgtLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
  //Hala Al Sheikh - ABEI180106
    public String constructCardsCollateralLookup()
    {
	 try
	{
	    String[] name = { "ctsCardsCollateralsVO.COLLATERAL_CODE", "collateralName", "amountType", "collateralType",  "fixedAmount", "collateralAllocatedAmt"};
	    String[] colType = { "number", "text", "text", "text", "number", "number"};
	    String[] titles = { getText("Collateral_No_key"), getText("Collateral_Name_key"), getText("amount_type_key"),
		    getText("Collateral_Type_Key"), getText("fixed_amount_key"), getText("collateral_alloc_amt_key")};


	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Collateral_No_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CardMgtLookup_fillCardsCollateralLookup");
	    lookup(grid, criteria, name, colType, titles); 
	}
	catch(Exception e)
        {
            log.error(e, "Error in constructCardsCollateralLookup of CardsMgtLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;
    }

    public String fillCardsCollateralLookup()
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
                setRecords(cardsBO.collateralsListCount(criteria));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(cardsBO.collateralsList(criteria));

        }
        catch(Exception e)
        {
            log.error(e, "Error in fillCardsCollateralLookup of CardsMgtLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }    
    //End Hala
    public void setCardsBO(CardsBO cardsBO)
    {
	this.cardsBO = cardsBO;
    }

    public CardsManagementSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CardsManagementSC criteria)
    {
	this.criteria = criteria;
    }

    public void setCardTypeBO(CardTypeBO cardTypeBO)
    {
	this.cardTypeBO = cardTypeBO;
    }

}