/**
 * @Auther:WissamAbouJaoude
 * @Date:Mar 27, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.cardtype.CardTypeBO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cardtype.CardTypeSC;

public class CardTypeLookupAction extends LookupBaseAction
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    private CardTypeSC criteria = new CardTypeSC();
    private transient CardTypeBO cardTypeBO;
    
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
	    String[] name = {"CODE","BRIEF_NAME_ENG","LONG_NAME_ENG","BRIEF_NAME_ARAB","LONG_NAME_ARAB"};
	    String[] colType = { "number", "text", "text","text", "text"};
	    String[] titles = { getText("code_key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key"),getText("Short_Name_Arab_key"), getText("Long_Name_Arab_key")};
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CODE","BRIEF_NAME_ENG","LONG_NAME_ENG"};
		colType = new String[] { "number", "text", "text"};
		titles = new String[] { getText("code_key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Card_Type_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CardTypeLookup_fillCardTypeLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CardTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Card Type data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCardTypeLookup()
    {
	try
	{
	    List<CTSCARDSVO> ctsCardsVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    if (criteria.getType() != null && StringUtil.isNotEmpty(criteria.getType()))
	    {
		if("2".equals(criteria.getType())) // case when affectcard flag
						   // is for debit card
		{
		    criteria.setCardCrDrtype("D");
		}

		else if("3".equals(criteria.getType())) // case when affectcard
							// flag is for credit
							// card
		{
		    criteria.setCardCrDrtype("C");
		}
		else
		{
		    criteria.setCardCrDrtype(null); // case when affectcard flag
						    // is for debit/credit card
		}
	    }

	    if(getRecords() == 0)
	    {
		setRecords(cardTypeBO.cardTypeListCount(criteria));
	    }
	    ctsCardsVOList = cardTypeBO.cardTypeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(ctsCardsVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of CardTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public CardTypeSC getCriteria()
    {
        return criteria;
    }
    public void setCriteria(CardTypeSC criteria)
    {
        this.criteria = criteria;
    }
    public void setCardTypeBO(CardTypeBO cardTypeBO)
    {
        this.cardTypeBO = cardTypeBO;
    }
}