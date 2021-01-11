package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.cardsmessage.CardsMessageBO;
import com.path.dbmaps.vo.CTSCARDS_MESSAGEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cardtype.CardTypeSC;

public class CardsMessageLookupAction extends LookupBaseAction {

    
    private CardTypeSC criteria = new CardTypeSC();
    private CardsMessageBO cardsMessageBO;
    private BigDecimal CODE;

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
	    String[] name    = {"CODE","DESC_ENG","DESC_ARAB"};
	    String[] colType = { "number", "text", "text"};
	    String[] titles =  { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key")};

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CODE","DESC_ENG"};
		colType = new String[] { "number", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CardsMessageLookup_fillCardsMessageLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Cities data filtered by the defined criteria
     *
     * @return
     */
    public String fillCardsMessageLookup()
    {
	try
	{
	    List<CTSCARDS_MESSAGEVO> cardsMessageVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCode(CODE);

	    if(checkNbRec(criteria))
	    {
		setRecords(cardsMessageBO.cardsMessageListCount(criteria));
	    }
	    cardsMessageVOList = cardsMessageBO.cardsMessageList(criteria);
	    setGridModel(cardsMessageVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCardsMessageLookup of CardsMessageLookupAction");
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

    public BigDecimal getCODE()
    {
	return CODE;
    }

    public void setCODE(BigDecimal cODE)
    {
	CODE = cODE;
    }

    public void setCardsMessageBO(CardsMessageBO cardsMessageBO)
    {
	this.cardsMessageBO = cardsMessageBO;
    }

}
